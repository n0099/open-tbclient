package com.baidu.tieba.myAttentionAndFans;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class ConcernSelectView extends FrameLayout {
    private View fPU;
    private LinearLayout kYW;
    private ImageView kYX;
    private TextView kYY;
    private TextView kYZ;
    private TextView kZa;
    public LinearLayout kZb;
    private Animation kZc;
    private Animation kZd;
    private boolean kZe;
    private a kZf;
    private Context mContext;
    private int mSkinType;

    /* loaded from: classes22.dex */
    public interface a {
        void AH(int i);

        void tp(boolean z);
    }

    public ConcernSelectView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mContext = context;
        initUI();
    }

    public ConcernSelectView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.mContext = context;
        initUI();
    }

    public ConcernSelectView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.mContext = context;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(this.mContext).inflate(R.layout.concern_select_layout, this);
        this.kYW = (LinearLayout) findViewById(R.id.expandable_area);
        this.kYX = (ImageView) findViewById(R.id.expandable_btn);
        this.kZb = (LinearLayout) findViewById(R.id.menu_list);
        this.kYY = (TextView) findViewById(R.id.menu_title);
        this.kYZ = (TextView) findViewById(R.id.all_concerned_item);
        this.kZa = (TextView) findViewById(R.id.each_concerned_item);
        this.fPU = findViewById(R.id.item_divider_line);
        this.kYW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new ar("c12774").dR("obj_locate", "1"));
                ConcernSelectView.this.y(ConcernSelectView.this.kZb, ConcernSelectView.this.kZb.getVisibility() == 0 ? 1 : 0);
            }
        });
        this.kYZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new ar("c12774").dR("obj_locate", "2"));
                ap.setViewTextColor(ConcernSelectView.this.kYZ, R.color.CAM_X0105);
                ap.setViewTextColor(ConcernSelectView.this.kZa, R.color.CAM_X0107);
                ConcernSelectView.this.kYY.setText(R.string.all_concerned);
                if (ConcernSelectView.this.kZf != null) {
                    ConcernSelectView.this.kZf.AH(0);
                }
                ConcernSelectView.this.y(ConcernSelectView.this.kZb, 1);
            }
        });
        this.kZa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new ar("c12774").dR("obj_locate", "3"));
                ap.setViewTextColor(ConcernSelectView.this.kYZ, R.color.CAM_X0107);
                ap.setViewTextColor(ConcernSelectView.this.kZa, R.color.CAM_X0105);
                ConcernSelectView.this.kYY.setText(R.string.each_concerned);
                if (ConcernSelectView.this.kZf != null) {
                    ConcernSelectView.this.kZf.AH(1);
                }
                ConcernSelectView.this.y(ConcernSelectView.this.kZb, 1);
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void closeView() {
        if (this.kZb.getVisibility() == 0) {
            y(this.kZb, 1);
        }
    }

    public boolean ddT() {
        return this.kZb.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            SvgManager.bqB().a(this.kYX, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0109, (SvgManager.SvgResourceStateType) null);
            ap.setViewTextColor(this.kYY, R.color.CAM_X0109);
            ap.setViewTextColor(this.kYZ, R.color.CAM_X0105);
            ap.setViewTextColor(this.kZa, R.color.CAM_X0107);
            ap.setBackgroundResource(this.kZb, R.drawable.concern_item_bg);
            ap.setBackgroundResource(this.kYY, R.color.CAM_X0201);
            ap.setBackgroundResource(this.kYZ, R.drawable.concern_item_menu_select_bg);
            ap.setBackgroundResource(this.kZa, R.drawable.concern_item_menu_select_bg);
            ap.setBackgroundResource(this.fPU, R.color.CAM_X0204);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(final View view, final int i) {
        if (view != null && view.getAnimation() == null && this.kZb != null) {
            int childCount = this.kZb.getChildCount();
            if (childCount < 0) {
                childCount = 0;
            }
            com.baidu.tieba.myAttentionAndFans.a aVar = new com.baidu.tieba.myAttentionAndFans.a(view, i, childCount * (((int) this.mContext.getResources().getDimension(R.dimen.tbds80)) + ((int) this.mContext.getResources().getDimension(R.dimen.ds1))));
            if (i == 0 && view.getVisibility() != 0) {
                view.setVisibility(0);
            }
            aVar.setDuration(260L);
            aVar.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.4
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    boolean z = i == 0;
                    if (z && view != null && (view.getParent() instanceof ListView)) {
                        ListView listView = (ListView) view.getParent();
                        int bottom = view.getBottom();
                        Rect rect = new Rect();
                        boolean globalVisibleRect = view.getGlobalVisibleRect(rect);
                        Rect rect2 = new Rect();
                        listView.getGlobalVisibleRect(rect2);
                        if (!globalVisibleRect) {
                            listView.smoothScrollBy(bottom, 260);
                        } else if (rect2.bottom == rect.bottom) {
                            listView.smoothScrollBy(bottom, 260);
                        }
                    }
                    if (ConcernSelectView.this.kZf != null) {
                        ConcernSelectView.this.kZf.tp(z);
                    }
                }
            });
            view.startAnimation(aVar);
            if (this.kYX != null) {
                if (this.kYX.getAnimation() == null || this.kYX.getAnimation().hasEnded()) {
                    if (i == 0) {
                        if (this.kZc == null) {
                            ddV();
                        }
                        if (this.kZd != null) {
                            this.kZd.cancel();
                        }
                        this.kYX.startAnimation(this.kZc);
                        return;
                    }
                    if (this.kZd == null) {
                        ddU();
                    }
                    if (this.kZc != null) {
                        this.kZc.cancel();
                    }
                    this.kYX.startAnimation(this.kZd);
                }
            }
        }
    }

    private void ddU() {
        this.kZd = AnimationUtils.loadAnimation(this.mContext, R.anim.rotate_collapse);
        this.kZd.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                ConcernSelectView.this.kZe = false;
            }
        });
    }

    private void ddV() {
        this.kZc = AnimationUtils.loadAnimation(this.mContext, R.anim.rotate_expand);
        this.kZc.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ConcernSelectView.this.kZe = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void setOnExpandListener(a aVar) {
        this.kZf = aVar;
    }
}

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
/* loaded from: classes23.dex */
public class ConcernSelectView extends FrameLayout {
    private View fYf;
    private Animation lmA;
    private Animation lmB;
    private boolean lmC;
    private a lmD;
    private LinearLayout lmu;
    private ImageView lmv;
    private TextView lmw;
    private TextView lmx;
    private TextView lmy;
    public LinearLayout lmz;
    private Context mContext;
    private int mSkinType;

    /* loaded from: classes23.dex */
    public interface a {
        void Bv(int i);

        void tR(boolean z);
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
        this.lmu = (LinearLayout) findViewById(R.id.expandable_area);
        this.lmv = (ImageView) findViewById(R.id.expandable_btn);
        this.lmz = (LinearLayout) findViewById(R.id.menu_list);
        this.lmw = (TextView) findViewById(R.id.menu_title);
        this.lmx = (TextView) findViewById(R.id.all_concerned_item);
        this.lmy = (TextView) findViewById(R.id.each_concerned_item);
        this.fYf = findViewById(R.id.item_divider_line);
        this.lmu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new ar("c12774").dY("obj_locate", "1"));
                ConcernSelectView.this.y(ConcernSelectView.this.lmz, ConcernSelectView.this.lmz.getVisibility() == 0 ? 1 : 0);
            }
        });
        this.lmx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new ar("c12774").dY("obj_locate", "2"));
                ap.setViewTextColor(ConcernSelectView.this.lmx, R.color.CAM_X0105);
                ap.setViewTextColor(ConcernSelectView.this.lmy, R.color.CAM_X0107);
                ConcernSelectView.this.lmw.setText(R.string.all_concerned);
                if (ConcernSelectView.this.lmD != null) {
                    ConcernSelectView.this.lmD.Bv(0);
                }
                ConcernSelectView.this.y(ConcernSelectView.this.lmz, 1);
            }
        });
        this.lmy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new ar("c12774").dY("obj_locate", "3"));
                ap.setViewTextColor(ConcernSelectView.this.lmx, R.color.CAM_X0107);
                ap.setViewTextColor(ConcernSelectView.this.lmy, R.color.CAM_X0105);
                ConcernSelectView.this.lmw.setText(R.string.each_concerned);
                if (ConcernSelectView.this.lmD != null) {
                    ConcernSelectView.this.lmD.Bv(1);
                }
                ConcernSelectView.this.y(ConcernSelectView.this.lmz, 1);
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void djf() {
        if (this.lmz.getVisibility() == 0) {
            y(this.lmz, 1);
        }
    }

    public boolean djg() {
        return this.lmz.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            SvgManager.btW().a(this.lmv, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0109, (SvgManager.SvgResourceStateType) null);
            ap.setViewTextColor(this.lmw, R.color.CAM_X0109);
            ap.setViewTextColor(this.lmx, R.color.CAM_X0105);
            ap.setViewTextColor(this.lmy, R.color.CAM_X0107);
            ap.setBackgroundResource(this.lmz, R.drawable.concern_item_bg);
            ap.setBackgroundResource(this.lmw, R.color.CAM_X0201);
            ap.setBackgroundResource(this.lmx, R.drawable.concern_item_menu_select_bg);
            ap.setBackgroundResource(this.lmy, R.drawable.concern_item_menu_select_bg);
            ap.setBackgroundResource(this.fYf, R.color.CAM_X0204);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(final View view, final int i) {
        if (view != null && view.getAnimation() == null && this.lmz != null) {
            int childCount = this.lmz.getChildCount();
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
                    if (ConcernSelectView.this.lmD != null) {
                        ConcernSelectView.this.lmD.tR(z);
                    }
                }
            });
            view.startAnimation(aVar);
            if (this.lmv != null) {
                if (this.lmv.getAnimation() == null || this.lmv.getAnimation().hasEnded()) {
                    if (i == 0) {
                        if (this.lmA == null) {
                            dji();
                        }
                        if (this.lmB != null) {
                            this.lmB.cancel();
                        }
                        this.lmv.startAnimation(this.lmA);
                        return;
                    }
                    if (this.lmB == null) {
                        djh();
                    }
                    if (this.lmA != null) {
                        this.lmA.cancel();
                    }
                    this.lmv.startAnimation(this.lmB);
                }
            }
        }
    }

    private void djh() {
        this.lmB = AnimationUtils.loadAnimation(this.mContext, R.anim.rotate_collapse);
        this.lmB.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                ConcernSelectView.this.lmC = false;
            }
        });
    }

    private void dji() {
        this.lmA = AnimationUtils.loadAnimation(this.mContext, R.anim.rotate_expand);
        this.lmA.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ConcernSelectView.this.lmC = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void setOnExpandListener(a aVar) {
        this.lmD = aVar;
    }
}

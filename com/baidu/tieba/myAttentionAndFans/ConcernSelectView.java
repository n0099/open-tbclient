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
/* loaded from: classes8.dex */
public class ConcernSelectView extends FrameLayout {
    private View gfy;
    private TextView lvA;
    private TextView lvB;
    public LinearLayout lvC;
    private Animation lvD;
    private Animation lvE;
    private boolean lvF;
    private a lvG;
    private LinearLayout lvx;
    private ImageView lvy;
    private TextView lvz;
    private Context mContext;
    private int mSkinType;

    /* loaded from: classes8.dex */
    public interface a {
        void Al(int i);

        void ub(boolean z);
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
        this.lvx = (LinearLayout) findViewById(R.id.expandable_area);
        this.lvy = (ImageView) findViewById(R.id.expandable_btn);
        this.lvC = (LinearLayout) findViewById(R.id.menu_list);
        this.lvz = (TextView) findViewById(R.id.menu_title);
        this.lvA = (TextView) findViewById(R.id.all_concerned_item);
        this.lvB = (TextView) findViewById(R.id.each_concerned_item);
        this.gfy = findViewById(R.id.item_divider_line);
        this.lvx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new ar("c12774").dR("obj_locate", "1"));
                ConcernSelectView.this.B(ConcernSelectView.this.lvC, ConcernSelectView.this.lvC.getVisibility() == 0 ? 1 : 0);
            }
        });
        this.lvA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new ar("c12774").dR("obj_locate", "2"));
                ap.setViewTextColor(ConcernSelectView.this.lvA, R.color.CAM_X0105);
                ap.setViewTextColor(ConcernSelectView.this.lvB, R.color.CAM_X0107);
                ConcernSelectView.this.lvz.setText(R.string.all_concerned);
                if (ConcernSelectView.this.lvG != null) {
                    ConcernSelectView.this.lvG.Al(0);
                }
                ConcernSelectView.this.B(ConcernSelectView.this.lvC, 1);
            }
        });
        this.lvB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new ar("c12774").dR("obj_locate", "3"));
                ap.setViewTextColor(ConcernSelectView.this.lvA, R.color.CAM_X0107);
                ap.setViewTextColor(ConcernSelectView.this.lvB, R.color.CAM_X0105);
                ConcernSelectView.this.lvz.setText(R.string.each_concerned);
                if (ConcernSelectView.this.lvG != null) {
                    ConcernSelectView.this.lvG.Al(1);
                }
                ConcernSelectView.this.B(ConcernSelectView.this.lvC, 1);
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void dhi() {
        if (this.lvC.getVisibility() == 0) {
            B(this.lvC, 1);
        }
    }

    public boolean dhj() {
        return this.lvC.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            SvgManager.bsR().a(this.lvy, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0109, (SvgManager.SvgResourceStateType) null);
            ap.setViewTextColor(this.lvz, R.color.CAM_X0109);
            ap.setViewTextColor(this.lvA, R.color.CAM_X0105);
            ap.setViewTextColor(this.lvB, R.color.CAM_X0107);
            ap.setBackgroundResource(this.lvC, R.drawable.concern_item_bg);
            ap.setBackgroundResource(this.lvz, R.color.CAM_X0201);
            ap.setBackgroundResource(this.lvA, R.drawable.concern_item_menu_select_bg);
            ap.setBackgroundResource(this.lvB, R.drawable.concern_item_menu_select_bg);
            ap.setBackgroundResource(this.gfy, R.color.CAM_X0204);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(final View view, final int i) {
        if (view != null && view.getAnimation() == null && this.lvC != null) {
            int childCount = this.lvC.getChildCount();
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
                    if (ConcernSelectView.this.lvG != null) {
                        ConcernSelectView.this.lvG.ub(z);
                    }
                }
            });
            view.startAnimation(aVar);
            if (this.lvy != null) {
                if (this.lvy.getAnimation() == null || this.lvy.getAnimation().hasEnded()) {
                    if (i == 0) {
                        if (this.lvD == null) {
                            dhl();
                        }
                        if (this.lvE != null) {
                            this.lvE.cancel();
                        }
                        this.lvy.startAnimation(this.lvD);
                        return;
                    }
                    if (this.lvE == null) {
                        dhk();
                    }
                    if (this.lvD != null) {
                        this.lvD.cancel();
                    }
                    this.lvy.startAnimation(this.lvE);
                }
            }
        }
    }

    private void dhk() {
        this.lvE = AnimationUtils.loadAnimation(this.mContext, R.anim.rotate_collapse);
        this.lvE.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                ConcernSelectView.this.lvF = false;
            }
        });
    }

    private void dhl() {
        this.lvD = AnimationUtils.loadAnimation(this.mContext, R.anim.rotate_expand);
        this.lvD.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ConcernSelectView.this.lvF = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void setOnExpandListener(a aVar) {
        this.lvG = aVar;
    }
}

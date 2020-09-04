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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
/* loaded from: classes17.dex */
public class ConcernSelectView extends FrameLayout {
    private View fmI;
    private LinearLayout kiA;
    private ImageView kiB;
    private TextView kiC;
    private TextView kiD;
    private TextView kiE;
    public LinearLayout kiF;
    private Animation kiG;
    private Animation kiH;
    private boolean kiI;
    private a kiJ;
    private Context mContext;
    private int mSkinType;

    /* loaded from: classes17.dex */
    public interface a {
        void rX(boolean z);

        void yy(int i);
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
        this.kiA = (LinearLayout) findViewById(R.id.expandable_area);
        this.kiB = (ImageView) findViewById(R.id.expandable_btn);
        this.kiF = (LinearLayout) findViewById(R.id.menu_list);
        this.kiC = (TextView) findViewById(R.id.menu_title);
        this.kiD = (TextView) findViewById(R.id.all_concerned_item);
        this.kiE = (TextView) findViewById(R.id.each_concerned_item);
        this.fmI = findViewById(R.id.item_divider_line);
        this.kiA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new aq("c12774").dD("obj_locate", "1"));
                ConcernSelectView.this.t(ConcernSelectView.this.kiF, ConcernSelectView.this.kiF.getVisibility() == 0 ? 1 : 0);
            }
        });
        this.kiD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new aq("c12774").dD("obj_locate", "2"));
                ap.setViewTextColor(ConcernSelectView.this.kiD, R.color.cp_cont_b);
                ap.setViewTextColor(ConcernSelectView.this.kiE, R.color.cp_cont_j);
                ConcernSelectView.this.kiC.setText(R.string.all_concerned);
                if (ConcernSelectView.this.kiJ != null) {
                    ConcernSelectView.this.kiJ.yy(0);
                }
                ConcernSelectView.this.t(ConcernSelectView.this.kiF, 1);
            }
        });
        this.kiE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new aq("c12774").dD("obj_locate", "3"));
                ap.setViewTextColor(ConcernSelectView.this.kiD, R.color.cp_cont_j);
                ap.setViewTextColor(ConcernSelectView.this.kiE, R.color.cp_cont_b);
                ConcernSelectView.this.kiC.setText(R.string.each_concerned);
                if (ConcernSelectView.this.kiJ != null) {
                    ConcernSelectView.this.kiJ.yy(1);
                }
                ConcernSelectView.this.t(ConcernSelectView.this.kiF, 1);
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void closeView() {
        if (this.kiF.getVisibility() == 0) {
            t(this.kiF, 1);
        }
    }

    public boolean cRx() {
        return this.kiF.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            SvgManager.bjq().a(this.kiB, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
            ap.setViewTextColor(this.kiC, R.color.cp_cont_d);
            ap.setViewTextColor(this.kiD, R.color.cp_cont_b);
            ap.setViewTextColor(this.kiE, R.color.cp_cont_j);
            ap.setBackgroundResource(this.kiF, R.drawable.concern_item_bg);
            ap.setBackgroundResource(this.kiC, R.color.cp_bg_line_d);
            ap.setBackgroundResource(this.kiD, R.drawable.concern_item_menu_select_bg);
            ap.setBackgroundResource(this.kiE, R.drawable.concern_item_menu_select_bg);
            ap.setBackgroundResource(this.fmI, R.color.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(final View view, final int i) {
        if (view != null && view.getAnimation() == null && this.kiF != null) {
            int childCount = this.kiF.getChildCount();
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
                    if (ConcernSelectView.this.kiJ != null) {
                        ConcernSelectView.this.kiJ.rX(z);
                    }
                }
            });
            view.startAnimation(aVar);
            if (this.kiB != null) {
                if (this.kiB.getAnimation() == null || this.kiB.getAnimation().hasEnded()) {
                    if (i == 0) {
                        if (this.kiG == null) {
                            cRz();
                        }
                        if (this.kiH != null) {
                            this.kiH.cancel();
                        }
                        this.kiB.startAnimation(this.kiG);
                        return;
                    }
                    if (this.kiH == null) {
                        cRy();
                    }
                    if (this.kiG != null) {
                        this.kiG.cancel();
                    }
                    this.kiB.startAnimation(this.kiH);
                }
            }
        }
    }

    private void cRy() {
        this.kiH = AnimationUtils.loadAnimation(this.mContext, R.anim.rotate_collapse);
        this.kiH.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                ConcernSelectView.this.kiI = false;
            }
        });
    }

    private void cRz() {
        this.kiG = AnimationUtils.loadAnimation(this.mContext, R.anim.rotate_expand);
        this.kiG.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ConcernSelectView.this.kiI = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void setOnExpandListener(a aVar) {
        this.kiJ = aVar;
    }
}

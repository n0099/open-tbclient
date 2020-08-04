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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes17.dex */
public class ConcernSelectView extends FrameLayout {
    private View fbk;
    private LinearLayout jSX;
    private ImageView jSY;
    private TextView jSZ;
    private TextView jTa;
    private TextView jTb;
    public LinearLayout jTc;
    private Animation jTd;
    private Animation jTe;
    private boolean jTf;
    private a jTg;
    private Context mContext;
    private int mSkinType;

    /* loaded from: classes17.dex */
    public interface a {
        void rp(boolean z);

        void wf(int i);
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
        this.jSX = (LinearLayout) findViewById(R.id.expandable_area);
        this.jSY = (ImageView) findViewById(R.id.expandable_btn);
        this.jTc = (LinearLayout) findViewById(R.id.menu_list);
        this.jSZ = (TextView) findViewById(R.id.menu_title);
        this.jTa = (TextView) findViewById(R.id.all_concerned_item);
        this.jTb = (TextView) findViewById(R.id.each_concerned_item);
        this.fbk = findViewById(R.id.item_divider_line);
        this.jSX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new ap("c12774").dn("obj_locate", "1"));
                ConcernSelectView.this.t(ConcernSelectView.this.jTc, ConcernSelectView.this.jTc.getVisibility() == 0 ? 1 : 0);
            }
        });
        this.jTa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new ap("c12774").dn("obj_locate", "2"));
                ao.setViewTextColor(ConcernSelectView.this.jTa, R.color.cp_cont_b);
                ao.setViewTextColor(ConcernSelectView.this.jTb, R.color.cp_cont_j);
                ConcernSelectView.this.jSZ.setText(R.string.all_concerned);
                if (ConcernSelectView.this.jTg != null) {
                    ConcernSelectView.this.jTg.wf(0);
                }
                ConcernSelectView.this.t(ConcernSelectView.this.jTc, 1);
            }
        });
        this.jTb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new ap("c12774").dn("obj_locate", "3"));
                ao.setViewTextColor(ConcernSelectView.this.jTa, R.color.cp_cont_j);
                ao.setViewTextColor(ConcernSelectView.this.jTb, R.color.cp_cont_b);
                ConcernSelectView.this.jSZ.setText(R.string.each_concerned);
                if (ConcernSelectView.this.jTg != null) {
                    ConcernSelectView.this.jTg.wf(1);
                }
                ConcernSelectView.this.t(ConcernSelectView.this.jTc, 1);
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void closeView() {
        if (this.jTc.getVisibility() == 0) {
            t(this.jTc, 1);
        }
    }

    public boolean cGH() {
        return this.jTc.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            SvgManager.baR().a(this.jSY, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
            ao.setViewTextColor(this.jSZ, R.color.cp_cont_d);
            ao.setViewTextColor(this.jTa, R.color.cp_cont_b);
            ao.setViewTextColor(this.jTb, R.color.cp_cont_j);
            ao.setBackgroundResource(this.jTc, R.drawable.concern_item_bg);
            ao.setBackgroundResource(this.jSZ, R.color.cp_bg_line_d);
            ao.setBackgroundResource(this.jTa, R.drawable.concern_item_menu_select_bg);
            ao.setBackgroundResource(this.jTb, R.drawable.concern_item_menu_select_bg);
            ao.setBackgroundResource(this.fbk, R.color.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(final View view, final int i) {
        if (view != null && view.getAnimation() == null && this.jTc != null) {
            int childCount = this.jTc.getChildCount();
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
                    if (ConcernSelectView.this.jTg != null) {
                        ConcernSelectView.this.jTg.rp(z);
                    }
                }
            });
            view.startAnimation(aVar);
            if (this.jSY != null) {
                if (this.jSY.getAnimation() == null || this.jSY.getAnimation().hasEnded()) {
                    if (i == 0) {
                        if (this.jTd == null) {
                            cGJ();
                        }
                        if (this.jTe != null) {
                            this.jTe.cancel();
                        }
                        this.jSY.startAnimation(this.jTd);
                        return;
                    }
                    if (this.jTe == null) {
                        cGI();
                    }
                    if (this.jTd != null) {
                        this.jTd.cancel();
                    }
                    this.jSY.startAnimation(this.jTe);
                }
            }
        }
    }

    private void cGI() {
        this.jTe = AnimationUtils.loadAnimation(this.mContext, R.anim.rotate_collapse);
        this.jTe.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                ConcernSelectView.this.jTf = false;
            }
        });
    }

    private void cGJ() {
        this.jTd = AnimationUtils.loadAnimation(this.mContext, R.anim.rotate_expand);
        this.jTd.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ConcernSelectView.this.jTf = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void setOnExpandListener(a aVar) {
        this.jTg = aVar;
    }
}

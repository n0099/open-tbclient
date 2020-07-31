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
    private LinearLayout jSV;
    private ImageView jSW;
    private TextView jSX;
    private TextView jSY;
    private TextView jSZ;
    public LinearLayout jTa;
    private Animation jTb;
    private Animation jTc;
    private boolean jTd;
    private a jTe;
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
        this.jSV = (LinearLayout) findViewById(R.id.expandable_area);
        this.jSW = (ImageView) findViewById(R.id.expandable_btn);
        this.jTa = (LinearLayout) findViewById(R.id.menu_list);
        this.jSX = (TextView) findViewById(R.id.menu_title);
        this.jSY = (TextView) findViewById(R.id.all_concerned_item);
        this.jSZ = (TextView) findViewById(R.id.each_concerned_item);
        this.fbk = findViewById(R.id.item_divider_line);
        this.jSV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new ap("c12774").dn("obj_locate", "1"));
                ConcernSelectView.this.t(ConcernSelectView.this.jTa, ConcernSelectView.this.jTa.getVisibility() == 0 ? 1 : 0);
            }
        });
        this.jSY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new ap("c12774").dn("obj_locate", "2"));
                ao.setViewTextColor(ConcernSelectView.this.jSY, R.color.cp_cont_b);
                ao.setViewTextColor(ConcernSelectView.this.jSZ, R.color.cp_cont_j);
                ConcernSelectView.this.jSX.setText(R.string.all_concerned);
                if (ConcernSelectView.this.jTe != null) {
                    ConcernSelectView.this.jTe.wf(0);
                }
                ConcernSelectView.this.t(ConcernSelectView.this.jTa, 1);
            }
        });
        this.jSZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new ap("c12774").dn("obj_locate", "3"));
                ao.setViewTextColor(ConcernSelectView.this.jSY, R.color.cp_cont_j);
                ao.setViewTextColor(ConcernSelectView.this.jSZ, R.color.cp_cont_b);
                ConcernSelectView.this.jSX.setText(R.string.each_concerned);
                if (ConcernSelectView.this.jTe != null) {
                    ConcernSelectView.this.jTe.wf(1);
                }
                ConcernSelectView.this.t(ConcernSelectView.this.jTa, 1);
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void closeView() {
        if (this.jTa.getVisibility() == 0) {
            t(this.jTa, 1);
        }
    }

    public boolean cGH() {
        return this.jTa.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            SvgManager.baR().a(this.jSW, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
            ao.setViewTextColor(this.jSX, R.color.cp_cont_d);
            ao.setViewTextColor(this.jSY, R.color.cp_cont_b);
            ao.setViewTextColor(this.jSZ, R.color.cp_cont_j);
            ao.setBackgroundResource(this.jTa, R.drawable.concern_item_bg);
            ao.setBackgroundResource(this.jSX, R.color.cp_bg_line_d);
            ao.setBackgroundResource(this.jSY, R.drawable.concern_item_menu_select_bg);
            ao.setBackgroundResource(this.jSZ, R.drawable.concern_item_menu_select_bg);
            ao.setBackgroundResource(this.fbk, R.color.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(final View view, final int i) {
        if (view != null && view.getAnimation() == null && this.jTa != null) {
            int childCount = this.jTa.getChildCount();
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
                    if (ConcernSelectView.this.jTe != null) {
                        ConcernSelectView.this.jTe.rp(z);
                    }
                }
            });
            view.startAnimation(aVar);
            if (this.jSW != null) {
                if (this.jSW.getAnimation() == null || this.jSW.getAnimation().hasEnded()) {
                    if (i == 0) {
                        if (this.jTb == null) {
                            cGJ();
                        }
                        if (this.jTc != null) {
                            this.jTc.cancel();
                        }
                        this.jSW.startAnimation(this.jTb);
                        return;
                    }
                    if (this.jTc == null) {
                        cGI();
                    }
                    if (this.jTb != null) {
                        this.jTb.cancel();
                    }
                    this.jSW.startAnimation(this.jTc);
                }
            }
        }
    }

    private void cGI() {
        this.jTc = AnimationUtils.loadAnimation(this.mContext, R.anim.rotate_collapse);
        this.jTc.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                ConcernSelectView.this.jTd = false;
            }
        });
    }

    private void cGJ() {
        this.jTb = AnimationUtils.loadAnimation(this.mContext, R.anim.rotate_expand);
        this.jTb.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ConcernSelectView.this.jTd = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void setOnExpandListener(a aVar) {
        this.jTe = aVar;
    }
}

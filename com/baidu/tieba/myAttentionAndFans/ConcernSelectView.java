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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class ConcernSelectView extends FrameLayout {
    private View ghM;
    private LinearLayout lrM;
    private ImageView lrN;
    private TextView lrO;
    private TextView lrP;
    private TextView lrQ;
    public LinearLayout lrR;
    private Animation lrS;
    private Animation lrT;
    private boolean lrU;
    private a lrV;
    private Context mContext;
    private int mSkinType;

    /* loaded from: classes8.dex */
    public interface a {
        void BH(int i);

        void tS(boolean z);
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
        this.lrM = (LinearLayout) findViewById(R.id.expandable_area);
        this.lrN = (ImageView) findViewById(R.id.expandable_btn);
        this.lrR = (LinearLayout) findViewById(R.id.menu_list);
        this.lrO = (TextView) findViewById(R.id.menu_title);
        this.lrP = (TextView) findViewById(R.id.all_concerned_item);
        this.lrQ = (TextView) findViewById(R.id.each_concerned_item);
        this.ghM = findViewById(R.id.item_divider_line);
        this.lrM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new aq("c12774").dX("obj_locate", "1"));
                ConcernSelectView.this.B(ConcernSelectView.this.lrR, ConcernSelectView.this.lrR.getVisibility() == 0 ? 1 : 0);
            }
        });
        this.lrP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new aq("c12774").dX("obj_locate", "2"));
                ao.setViewTextColor(ConcernSelectView.this.lrP, R.color.CAM_X0105);
                ao.setViewTextColor(ConcernSelectView.this.lrQ, R.color.CAM_X0107);
                ConcernSelectView.this.lrO.setText(R.string.all_concerned);
                if (ConcernSelectView.this.lrV != null) {
                    ConcernSelectView.this.lrV.BH(0);
                }
                ConcernSelectView.this.B(ConcernSelectView.this.lrR, 1);
            }
        });
        this.lrQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new aq("c12774").dX("obj_locate", "3"));
                ao.setViewTextColor(ConcernSelectView.this.lrP, R.color.CAM_X0107);
                ao.setViewTextColor(ConcernSelectView.this.lrQ, R.color.CAM_X0105);
                ConcernSelectView.this.lrO.setText(R.string.each_concerned);
                if (ConcernSelectView.this.lrV != null) {
                    ConcernSelectView.this.lrV.BH(1);
                }
                ConcernSelectView.this.B(ConcernSelectView.this.lrR, 1);
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void diS() {
        if (this.lrR.getVisibility() == 0) {
            B(this.lrR, 1);
        }
    }

    public boolean diT() {
        return this.lrR.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            SvgManager.bwq().a(this.lrN, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0109, (SvgManager.SvgResourceStateType) null);
            ao.setViewTextColor(this.lrO, R.color.CAM_X0109);
            ao.setViewTextColor(this.lrP, R.color.CAM_X0105);
            ao.setViewTextColor(this.lrQ, R.color.CAM_X0107);
            ao.setBackgroundResource(this.lrR, R.drawable.concern_item_bg);
            ao.setBackgroundResource(this.lrO, R.color.CAM_X0201);
            ao.setBackgroundResource(this.lrP, R.drawable.concern_item_menu_select_bg);
            ao.setBackgroundResource(this.lrQ, R.drawable.concern_item_menu_select_bg);
            ao.setBackgroundResource(this.ghM, R.color.CAM_X0204);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(final View view, final int i) {
        if (view != null && view.getAnimation() == null && this.lrR != null) {
            int childCount = this.lrR.getChildCount();
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
                    if (ConcernSelectView.this.lrV != null) {
                        ConcernSelectView.this.lrV.tS(z);
                    }
                }
            });
            view.startAnimation(aVar);
            if (this.lrN != null) {
                if (this.lrN.getAnimation() == null || this.lrN.getAnimation().hasEnded()) {
                    if (i == 0) {
                        if (this.lrS == null) {
                            diV();
                        }
                        if (this.lrT != null) {
                            this.lrT.cancel();
                        }
                        this.lrN.startAnimation(this.lrS);
                        return;
                    }
                    if (this.lrT == null) {
                        diU();
                    }
                    if (this.lrS != null) {
                        this.lrS.cancel();
                    }
                    this.lrN.startAnimation(this.lrT);
                }
            }
        }
    }

    private void diU() {
        this.lrT = AnimationUtils.loadAnimation(this.mContext, R.anim.rotate_collapse);
        this.lrT.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                ConcernSelectView.this.lrU = false;
            }
        });
    }

    private void diV() {
        this.lrS = AnimationUtils.loadAnimation(this.mContext, R.anim.rotate_expand);
        this.lrS.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ConcernSelectView.this.lrU = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void setOnExpandListener(a aVar) {
        this.lrV = aVar;
    }
}

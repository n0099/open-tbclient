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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class ConcernSelectView extends FrameLayout {
    private View ban;
    private LinearLayout eSR;
    private ImageView eSS;
    private TextView eST;
    private TextView eSU;
    private TextView eSV;
    public LinearLayout eSW;
    private Animation eSX;
    private Animation eSY;
    private boolean eSZ;
    private a eTa;
    private Context mContext;
    private int mSkinType;

    /* loaded from: classes3.dex */
    public interface a {
        void iM(boolean z);

        void lc(int i);
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
        LayoutInflater.from(this.mContext).inflate(d.i.concern_select_layout, this);
        this.eSR = (LinearLayout) findViewById(d.g.expandable_area);
        this.eSS = (ImageView) findViewById(d.g.expandable_btn);
        this.eSW = (LinearLayout) findViewById(d.g.menu_list);
        this.eST = (TextView) findViewById(d.g.menu_title);
        this.eSU = (TextView) findViewById(d.g.all_concerned_item);
        this.eSV = (TextView) findViewById(d.g.each_concerned_item);
        this.ban = findViewById(d.g.item_divider_line);
        this.eSR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new al("c12774").ac("obj_locate", "1"));
                ConcernSelectView.this.t(ConcernSelectView.this.eSW, ConcernSelectView.this.eSW.getVisibility() == 0 ? 1 : 0);
            }
        });
        this.eSU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new al("c12774").ac("obj_locate", "2"));
                ak.h(ConcernSelectView.this.eSU, d.C0126d.cp_cont_b);
                ak.h(ConcernSelectView.this.eSV, d.C0126d.cp_cont_j);
                ConcernSelectView.this.eST.setText(d.k.all_concerned);
                if (ConcernSelectView.this.eTa != null) {
                    ConcernSelectView.this.eTa.lc(0);
                }
                ConcernSelectView.this.t(ConcernSelectView.this.eSW, 1);
            }
        });
        this.eSV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new al("c12774").ac("obj_locate", "3"));
                ak.h(ConcernSelectView.this.eSU, d.C0126d.cp_cont_j);
                ak.h(ConcernSelectView.this.eSV, d.C0126d.cp_cont_b);
                ConcernSelectView.this.eST.setText(d.k.each_concerned);
                if (ConcernSelectView.this.eTa != null) {
                    ConcernSelectView.this.eTa.lc(1);
                }
                ConcernSelectView.this.t(ConcernSelectView.this.eSW, 1);
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void aSl() {
        if (!(this.eSW.getVisibility() == 0)) {
            t(this.eSW, 0);
        }
    }

    public void aSm() {
        if (this.eSW.getVisibility() == 0) {
            t(this.eSW, 1);
        }
    }

    public boolean aSn() {
        return this.eSW.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ak.c(this.eSS, d.f.icon_arrow_gray_down);
            ak.h(this.eST, d.C0126d.cp_cont_d);
            ak.h(this.eSU, d.C0126d.cp_cont_b);
            ak.h(this.eSV, d.C0126d.cp_cont_j);
            ak.i(this.eSW, d.f.bg_user_float_shadow);
            ak.i(this.eST, d.C0126d.cp_bg_line_d);
            ak.i(this.eSU, d.f.concern_item_bg);
            ak.i(this.eSV, d.f.concern_item_bg);
            ak.i(this.ban, d.C0126d.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(final View view2, final int i) {
        if (view2 != null && view2.getAnimation() == null && this.eSW != null) {
            int childCount = this.eSW.getChildCount();
            if (childCount < 0) {
                childCount = 0;
            }
            com.baidu.tieba.myAttentionAndFans.a aVar = new com.baidu.tieba.myAttentionAndFans.a(view2, i, childCount * (((int) this.mContext.getResources().getDimension(d.e.tbds80)) + ((int) this.mContext.getResources().getDimension(d.e.ds1))));
            if (i == 0 && view2.getVisibility() != 0) {
                view2.setVisibility(0);
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
                    if (z && view2 != null && (view2.getParent() instanceof ListView)) {
                        ListView listView = (ListView) view2.getParent();
                        int bottom = view2.getBottom();
                        Rect rect = new Rect();
                        boolean globalVisibleRect = view2.getGlobalVisibleRect(rect);
                        Rect rect2 = new Rect();
                        listView.getGlobalVisibleRect(rect2);
                        if (!globalVisibleRect) {
                            listView.smoothScrollBy(bottom, 260);
                        } else if (rect2.bottom == rect.bottom) {
                            listView.smoothScrollBy(bottom, 260);
                        }
                    }
                    if (ConcernSelectView.this.eTa != null) {
                        ConcernSelectView.this.eTa.iM(z);
                    }
                }
            });
            view2.startAnimation(aVar);
            if (this.eSS != null) {
                if (this.eSS.getAnimation() == null || this.eSS.getAnimation().hasEnded()) {
                    if (i == 0) {
                        if (this.eSX == null) {
                            aSp();
                        }
                        if (this.eSY != null) {
                            this.eSY.cancel();
                        }
                        this.eSS.startAnimation(this.eSX);
                        return;
                    }
                    if (this.eSY == null) {
                        aSo();
                    }
                    if (this.eSX != null) {
                        this.eSX.cancel();
                    }
                    this.eSS.startAnimation(this.eSY);
                }
            }
        }
    }

    private void aSo() {
        this.eSY = AnimationUtils.loadAnimation(this.mContext, d.a.rotate_collapse);
        this.eSY.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                ConcernSelectView.this.eSZ = false;
            }
        });
    }

    private void aSp() {
        this.eSX = AnimationUtils.loadAnimation(this.mContext, d.a.rotate_expand);
        this.eSX.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ConcernSelectView.this.eSZ = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void setOnExpandListener(a aVar) {
        this.eTa = aVar;
    }
}

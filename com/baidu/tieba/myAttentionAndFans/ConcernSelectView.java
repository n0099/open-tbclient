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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class ConcernSelectView extends FrameLayout {
    private View bQn;
    private LinearLayout fwN;
    private ImageView fwO;
    private TextView fwP;
    private TextView fwQ;
    private TextView fwR;
    public LinearLayout fwS;
    private Animation fwT;
    private Animation fwU;
    private boolean fwV;
    private a fwW;
    private Context mContext;
    private int mSkinType;

    /* loaded from: classes3.dex */
    public interface a {
        void jk(boolean z);

        void sm(int i);
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
        LayoutInflater.from(this.mContext).inflate(d.h.concern_select_layout, this);
        this.fwN = (LinearLayout) findViewById(d.g.expandable_area);
        this.fwO = (ImageView) findViewById(d.g.expandable_btn);
        this.fwS = (LinearLayout) findViewById(d.g.menu_list);
        this.fwP = (TextView) findViewById(d.g.menu_title);
        this.fwQ = (TextView) findViewById(d.g.all_concerned_item);
        this.fwR = (TextView) findViewById(d.g.each_concerned_item);
        this.bQn = findViewById(d.g.item_divider_line);
        this.fwN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new ak("c12774").ab("obj_locate", "1"));
                ConcernSelectView.this.D(ConcernSelectView.this.fwS, ConcernSelectView.this.fwS.getVisibility() == 0 ? 1 : 0);
            }
        });
        this.fwQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new ak("c12774").ab("obj_locate", "2"));
                aj.r(ConcernSelectView.this.fwQ, d.C0141d.cp_cont_b);
                aj.r(ConcernSelectView.this.fwR, d.C0141d.cp_cont_j);
                ConcernSelectView.this.fwP.setText(d.j.all_concerned);
                if (ConcernSelectView.this.fwW != null) {
                    ConcernSelectView.this.fwW.sm(0);
                }
                ConcernSelectView.this.D(ConcernSelectView.this.fwS, 1);
            }
        });
        this.fwR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new ak("c12774").ab("obj_locate", "3"));
                aj.r(ConcernSelectView.this.fwQ, d.C0141d.cp_cont_j);
                aj.r(ConcernSelectView.this.fwR, d.C0141d.cp_cont_b);
                ConcernSelectView.this.fwP.setText(d.j.each_concerned);
                if (ConcernSelectView.this.fwW != null) {
                    ConcernSelectView.this.fwW.sm(1);
                }
                ConcernSelectView.this.D(ConcernSelectView.this.fwS, 1);
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void aXp() {
        if (!(this.fwS.getVisibility() == 0)) {
            D(this.fwS, 0);
        }
    }

    public void aXq() {
        if (this.fwS.getVisibility() == 0) {
            D(this.fwS, 1);
        }
    }

    public boolean aXr() {
        return this.fwS.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.c(this.fwO, d.f.icon_arrow_gray_down);
            aj.r(this.fwP, d.C0141d.cp_cont_d);
            aj.r(this.fwQ, d.C0141d.cp_cont_b);
            aj.r(this.fwR, d.C0141d.cp_cont_j);
            aj.s(this.fwS, d.f.bg_user_float_shadow);
            aj.s(this.fwP, d.C0141d.cp_bg_line_d);
            aj.s(this.fwQ, d.f.concern_item_bg);
            aj.s(this.fwR, d.f.concern_item_bg);
            aj.s(this.bQn, d.C0141d.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(final View view, final int i) {
        if (view != null && view.getAnimation() == null && this.fwS != null) {
            int childCount = this.fwS.getChildCount();
            if (childCount < 0) {
                childCount = 0;
            }
            com.baidu.tieba.myAttentionAndFans.a aVar = new com.baidu.tieba.myAttentionAndFans.a(view, i, childCount * (((int) this.mContext.getResources().getDimension(d.e.tbds80)) + ((int) this.mContext.getResources().getDimension(d.e.ds1))));
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
                    if (ConcernSelectView.this.fwW != null) {
                        ConcernSelectView.this.fwW.jk(z);
                    }
                }
            });
            view.startAnimation(aVar);
            if (this.fwO != null) {
                if (this.fwO.getAnimation() == null || this.fwO.getAnimation().hasEnded()) {
                    if (i == 0) {
                        if (this.fwT == null) {
                            aXt();
                        }
                        if (this.fwU != null) {
                            this.fwU.cancel();
                        }
                        this.fwO.startAnimation(this.fwT);
                        return;
                    }
                    if (this.fwU == null) {
                        aXs();
                    }
                    if (this.fwT != null) {
                        this.fwT.cancel();
                    }
                    this.fwO.startAnimation(this.fwU);
                }
            }
        }
    }

    private void aXs() {
        this.fwU = AnimationUtils.loadAnimation(this.mContext, d.a.rotate_collapse);
        this.fwU.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                ConcernSelectView.this.fwV = false;
            }
        });
    }

    private void aXt() {
        this.fwT = AnimationUtils.loadAnimation(this.mContext, d.a.rotate_expand);
        this.fwT.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ConcernSelectView.this.fwV = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void setOnExpandListener(a aVar) {
        this.fwW = aVar;
    }
}

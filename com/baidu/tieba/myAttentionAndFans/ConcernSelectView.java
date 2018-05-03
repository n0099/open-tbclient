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
    private View bam;
    private LinearLayout eRK;
    private ImageView eRL;
    private TextView eRM;
    private TextView eRN;
    private TextView eRO;
    public LinearLayout eRP;
    private Animation eRQ;
    private Animation eRR;
    private boolean eRS;
    private a eRT;
    private Context mContext;
    private int mSkinType;

    /* loaded from: classes3.dex */
    public interface a {
        void iL(boolean z);

        void ld(int i);
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
        this.eRK = (LinearLayout) findViewById(d.g.expandable_area);
        this.eRL = (ImageView) findViewById(d.g.expandable_btn);
        this.eRP = (LinearLayout) findViewById(d.g.menu_list);
        this.eRM = (TextView) findViewById(d.g.menu_title);
        this.eRN = (TextView) findViewById(d.g.all_concerned_item);
        this.eRO = (TextView) findViewById(d.g.each_concerned_item);
        this.bam = findViewById(d.g.item_divider_line);
        this.eRK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new al("c12774").ac("obj_locate", "1"));
                ConcernSelectView.this.t(ConcernSelectView.this.eRP, ConcernSelectView.this.eRP.getVisibility() == 0 ? 1 : 0);
            }
        });
        this.eRN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new al("c12774").ac("obj_locate", "2"));
                ak.h(ConcernSelectView.this.eRN, d.C0126d.cp_cont_b);
                ak.h(ConcernSelectView.this.eRO, d.C0126d.cp_cont_j);
                ConcernSelectView.this.eRM.setText(d.k.all_concerned);
                if (ConcernSelectView.this.eRT != null) {
                    ConcernSelectView.this.eRT.ld(0);
                }
                ConcernSelectView.this.t(ConcernSelectView.this.eRP, 1);
            }
        });
        this.eRO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new al("c12774").ac("obj_locate", "3"));
                ak.h(ConcernSelectView.this.eRN, d.C0126d.cp_cont_j);
                ak.h(ConcernSelectView.this.eRO, d.C0126d.cp_cont_b);
                ConcernSelectView.this.eRM.setText(d.k.each_concerned);
                if (ConcernSelectView.this.eRT != null) {
                    ConcernSelectView.this.eRT.ld(1);
                }
                ConcernSelectView.this.t(ConcernSelectView.this.eRP, 1);
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void aSl() {
        if (!(this.eRP.getVisibility() == 0)) {
            t(this.eRP, 0);
        }
    }

    public void aSm() {
        if (this.eRP.getVisibility() == 0) {
            t(this.eRP, 1);
        }
    }

    public boolean aSn() {
        return this.eRP.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ak.c(this.eRL, d.f.icon_arrow_gray_down);
            ak.h(this.eRM, d.C0126d.cp_cont_d);
            ak.h(this.eRN, d.C0126d.cp_cont_b);
            ak.h(this.eRO, d.C0126d.cp_cont_j);
            ak.i(this.eRP, d.f.bg_user_float_shadow);
            ak.i(this.eRM, d.C0126d.cp_bg_line_d);
            ak.i(this.eRN, d.f.concern_item_bg);
            ak.i(this.eRO, d.f.concern_item_bg);
            ak.i(this.bam, d.C0126d.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(final View view2, final int i) {
        if (view2 != null && view2.getAnimation() == null && this.eRP != null) {
            int childCount = this.eRP.getChildCount();
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
                    if (ConcernSelectView.this.eRT != null) {
                        ConcernSelectView.this.eRT.iL(z);
                    }
                }
            });
            view2.startAnimation(aVar);
            if (this.eRL != null) {
                if (this.eRL.getAnimation() == null || this.eRL.getAnimation().hasEnded()) {
                    if (i == 0) {
                        if (this.eRQ == null) {
                            aSp();
                        }
                        if (this.eRR != null) {
                            this.eRR.cancel();
                        }
                        this.eRL.startAnimation(this.eRQ);
                        return;
                    }
                    if (this.eRR == null) {
                        aSo();
                    }
                    if (this.eRQ != null) {
                        this.eRQ.cancel();
                    }
                    this.eRL.startAnimation(this.eRR);
                }
            }
        }
    }

    private void aSo() {
        this.eRR = AnimationUtils.loadAnimation(this.mContext, d.a.rotate_collapse);
        this.eRR.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                ConcernSelectView.this.eRS = false;
            }
        });
    }

    private void aSp() {
        this.eRQ = AnimationUtils.loadAnimation(this.mContext, d.a.rotate_expand);
        this.eRQ.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ConcernSelectView.this.eRS = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void setOnExpandListener(a aVar) {
        this.eRT = aVar;
    }
}

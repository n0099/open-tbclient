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
    private LinearLayout eRN;
    private ImageView eRO;
    private TextView eRP;
    private TextView eRQ;
    private TextView eRR;
    public LinearLayout eRS;
    private Animation eRT;
    private Animation eRU;
    private boolean eRV;
    private a eRW;
    private Context mContext;
    private int mSkinType;

    /* loaded from: classes3.dex */
    public interface a {
        void iL(boolean z);

        void le(int i);
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
        this.eRN = (LinearLayout) findViewById(d.g.expandable_area);
        this.eRO = (ImageView) findViewById(d.g.expandable_btn);
        this.eRS = (LinearLayout) findViewById(d.g.menu_list);
        this.eRP = (TextView) findViewById(d.g.menu_title);
        this.eRQ = (TextView) findViewById(d.g.all_concerned_item);
        this.eRR = (TextView) findViewById(d.g.each_concerned_item);
        this.bam = findViewById(d.g.item_divider_line);
        this.eRN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new al("c12774").ac("obj_locate", "1"));
                ConcernSelectView.this.t(ConcernSelectView.this.eRS, ConcernSelectView.this.eRS.getVisibility() == 0 ? 1 : 0);
            }
        });
        this.eRQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new al("c12774").ac("obj_locate", "2"));
                ak.h(ConcernSelectView.this.eRQ, d.C0126d.cp_cont_b);
                ak.h(ConcernSelectView.this.eRR, d.C0126d.cp_cont_j);
                ConcernSelectView.this.eRP.setText(d.k.all_concerned);
                if (ConcernSelectView.this.eRW != null) {
                    ConcernSelectView.this.eRW.le(0);
                }
                ConcernSelectView.this.t(ConcernSelectView.this.eRS, 1);
            }
        });
        this.eRR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new al("c12774").ac("obj_locate", "3"));
                ak.h(ConcernSelectView.this.eRQ, d.C0126d.cp_cont_j);
                ak.h(ConcernSelectView.this.eRR, d.C0126d.cp_cont_b);
                ConcernSelectView.this.eRP.setText(d.k.each_concerned);
                if (ConcernSelectView.this.eRW != null) {
                    ConcernSelectView.this.eRW.le(1);
                }
                ConcernSelectView.this.t(ConcernSelectView.this.eRS, 1);
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void aSl() {
        if (!(this.eRS.getVisibility() == 0)) {
            t(this.eRS, 0);
        }
    }

    public void aSm() {
        if (this.eRS.getVisibility() == 0) {
            t(this.eRS, 1);
        }
    }

    public boolean aSn() {
        return this.eRS.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ak.c(this.eRO, d.f.icon_arrow_gray_down);
            ak.h(this.eRP, d.C0126d.cp_cont_d);
            ak.h(this.eRQ, d.C0126d.cp_cont_b);
            ak.h(this.eRR, d.C0126d.cp_cont_j);
            ak.i(this.eRS, d.f.bg_user_float_shadow);
            ak.i(this.eRP, d.C0126d.cp_bg_line_d);
            ak.i(this.eRQ, d.f.concern_item_bg);
            ak.i(this.eRR, d.f.concern_item_bg);
            ak.i(this.bam, d.C0126d.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(final View view2, final int i) {
        if (view2 != null && view2.getAnimation() == null && this.eRS != null) {
            int childCount = this.eRS.getChildCount();
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
                    if (ConcernSelectView.this.eRW != null) {
                        ConcernSelectView.this.eRW.iL(z);
                    }
                }
            });
            view2.startAnimation(aVar);
            if (this.eRO != null) {
                if (this.eRO.getAnimation() == null || this.eRO.getAnimation().hasEnded()) {
                    if (i == 0) {
                        if (this.eRT == null) {
                            aSp();
                        }
                        if (this.eRU != null) {
                            this.eRU.cancel();
                        }
                        this.eRO.startAnimation(this.eRT);
                        return;
                    }
                    if (this.eRU == null) {
                        aSo();
                    }
                    if (this.eRT != null) {
                        this.eRT.cancel();
                    }
                    this.eRO.startAnimation(this.eRU);
                }
            }
        }
    }

    private void aSo() {
        this.eRU = AnimationUtils.loadAnimation(this.mContext, d.a.rotate_collapse);
        this.eRU.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                ConcernSelectView.this.eRV = false;
            }
        });
    }

    private void aSp() {
        this.eRT = AnimationUtils.loadAnimation(this.mContext, d.a.rotate_expand);
        this.eRT.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ConcernSelectView.this.eRV = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void setOnExpandListener(a aVar) {
        this.eRW = aVar;
    }
}

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
    private View bQA;
    private LinearLayout fwZ;
    private ImageView fxa;
    private TextView fxb;
    private TextView fxc;
    private TextView fxd;
    public LinearLayout fxe;
    private Animation fxf;
    private Animation fxg;
    private boolean fxh;
    private a fxi;
    private Context mContext;
    private int mSkinType;

    /* loaded from: classes3.dex */
    public interface a {
        void jk(boolean z);

        void sl(int i);
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
        this.fwZ = (LinearLayout) findViewById(d.g.expandable_area);
        this.fxa = (ImageView) findViewById(d.g.expandable_btn);
        this.fxe = (LinearLayout) findViewById(d.g.menu_list);
        this.fxb = (TextView) findViewById(d.g.menu_title);
        this.fxc = (TextView) findViewById(d.g.all_concerned_item);
        this.fxd = (TextView) findViewById(d.g.each_concerned_item);
        this.bQA = findViewById(d.g.item_divider_line);
        this.fwZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new ak("c12774").ab("obj_locate", "1"));
                ConcernSelectView.this.D(ConcernSelectView.this.fxe, ConcernSelectView.this.fxe.getVisibility() == 0 ? 1 : 0);
            }
        });
        this.fxc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new ak("c12774").ab("obj_locate", "2"));
                aj.r(ConcernSelectView.this.fxc, d.C0140d.cp_cont_b);
                aj.r(ConcernSelectView.this.fxd, d.C0140d.cp_cont_j);
                ConcernSelectView.this.fxb.setText(d.j.all_concerned);
                if (ConcernSelectView.this.fxi != null) {
                    ConcernSelectView.this.fxi.sl(0);
                }
                ConcernSelectView.this.D(ConcernSelectView.this.fxe, 1);
            }
        });
        this.fxd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new ak("c12774").ab("obj_locate", "3"));
                aj.r(ConcernSelectView.this.fxc, d.C0140d.cp_cont_j);
                aj.r(ConcernSelectView.this.fxd, d.C0140d.cp_cont_b);
                ConcernSelectView.this.fxb.setText(d.j.each_concerned);
                if (ConcernSelectView.this.fxi != null) {
                    ConcernSelectView.this.fxi.sl(1);
                }
                ConcernSelectView.this.D(ConcernSelectView.this.fxe, 1);
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void aXq() {
        if (!(this.fxe.getVisibility() == 0)) {
            D(this.fxe, 0);
        }
    }

    public void aXr() {
        if (this.fxe.getVisibility() == 0) {
            D(this.fxe, 1);
        }
    }

    public boolean aXs() {
        return this.fxe.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.c(this.fxa, d.f.icon_arrow_gray_down);
            aj.r(this.fxb, d.C0140d.cp_cont_d);
            aj.r(this.fxc, d.C0140d.cp_cont_b);
            aj.r(this.fxd, d.C0140d.cp_cont_j);
            aj.s(this.fxe, d.f.bg_user_float_shadow);
            aj.s(this.fxb, d.C0140d.cp_bg_line_d);
            aj.s(this.fxc, d.f.concern_item_bg);
            aj.s(this.fxd, d.f.concern_item_bg);
            aj.s(this.bQA, d.C0140d.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(final View view, final int i) {
        if (view != null && view.getAnimation() == null && this.fxe != null) {
            int childCount = this.fxe.getChildCount();
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
                    if (ConcernSelectView.this.fxi != null) {
                        ConcernSelectView.this.fxi.jk(z);
                    }
                }
            });
            view.startAnimation(aVar);
            if (this.fxa != null) {
                if (this.fxa.getAnimation() == null || this.fxa.getAnimation().hasEnded()) {
                    if (i == 0) {
                        if (this.fxf == null) {
                            aXu();
                        }
                        if (this.fxg != null) {
                            this.fxg.cancel();
                        }
                        this.fxa.startAnimation(this.fxf);
                        return;
                    }
                    if (this.fxg == null) {
                        aXt();
                    }
                    if (this.fxf != null) {
                        this.fxf.cancel();
                    }
                    this.fxa.startAnimation(this.fxg);
                }
            }
        }
    }

    private void aXt() {
        this.fxg = AnimationUtils.loadAnimation(this.mContext, d.a.rotate_collapse);
        this.fxg.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                ConcernSelectView.this.fxh = false;
            }
        });
    }

    private void aXu() {
        this.fxf = AnimationUtils.loadAnimation(this.mContext, d.a.rotate_expand);
        this.fxf.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ConcernSelectView.this.fxh = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void setOnExpandListener(a aVar) {
        this.fxi = aVar;
    }
}

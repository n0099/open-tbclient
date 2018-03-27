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
    private View bQq;
    private LinearLayout fxd;
    private ImageView fxe;
    private TextView fxf;
    private TextView fxg;
    private TextView fxh;
    public LinearLayout fxi;
    private Animation fxj;
    private Animation fxk;
    private boolean fxl;
    private a fxm;
    private Context mContext;
    private int mSkinType;

    /* loaded from: classes3.dex */
    public interface a {
        void jp(boolean z);

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
        this.fxd = (LinearLayout) findViewById(d.g.expandable_area);
        this.fxe = (ImageView) findViewById(d.g.expandable_btn);
        this.fxi = (LinearLayout) findViewById(d.g.menu_list);
        this.fxf = (TextView) findViewById(d.g.menu_title);
        this.fxg = (TextView) findViewById(d.g.all_concerned_item);
        this.fxh = (TextView) findViewById(d.g.each_concerned_item);
        this.bQq = findViewById(d.g.item_divider_line);
        this.fxd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new ak("c12774").ab("obj_locate", "1"));
                ConcernSelectView.this.D(ConcernSelectView.this.fxi, ConcernSelectView.this.fxi.getVisibility() == 0 ? 1 : 0);
            }
        });
        this.fxg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new ak("c12774").ab("obj_locate", "2"));
                aj.r(ConcernSelectView.this.fxg, d.C0141d.cp_cont_b);
                aj.r(ConcernSelectView.this.fxh, d.C0141d.cp_cont_j);
                ConcernSelectView.this.fxf.setText(d.j.all_concerned);
                if (ConcernSelectView.this.fxm != null) {
                    ConcernSelectView.this.fxm.sm(0);
                }
                ConcernSelectView.this.D(ConcernSelectView.this.fxi, 1);
            }
        });
        this.fxh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new ak("c12774").ab("obj_locate", "3"));
                aj.r(ConcernSelectView.this.fxg, d.C0141d.cp_cont_j);
                aj.r(ConcernSelectView.this.fxh, d.C0141d.cp_cont_b);
                ConcernSelectView.this.fxf.setText(d.j.each_concerned);
                if (ConcernSelectView.this.fxm != null) {
                    ConcernSelectView.this.fxm.sm(1);
                }
                ConcernSelectView.this.D(ConcernSelectView.this.fxi, 1);
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void aXq() {
        if (!(this.fxi.getVisibility() == 0)) {
            D(this.fxi, 0);
        }
    }

    public void aXr() {
        if (this.fxi.getVisibility() == 0) {
            D(this.fxi, 1);
        }
    }

    public boolean aXs() {
        return this.fxi.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.c(this.fxe, d.f.icon_arrow_gray_down);
            aj.r(this.fxf, d.C0141d.cp_cont_d);
            aj.r(this.fxg, d.C0141d.cp_cont_b);
            aj.r(this.fxh, d.C0141d.cp_cont_j);
            aj.s(this.fxi, d.f.bg_user_float_shadow);
            aj.s(this.fxf, d.C0141d.cp_bg_line_d);
            aj.s(this.fxg, d.f.concern_item_bg);
            aj.s(this.fxh, d.f.concern_item_bg);
            aj.s(this.bQq, d.C0141d.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(final View view, final int i) {
        if (view != null && view.getAnimation() == null && this.fxi != null) {
            int childCount = this.fxi.getChildCount();
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
                    if (ConcernSelectView.this.fxm != null) {
                        ConcernSelectView.this.fxm.jp(z);
                    }
                }
            });
            view.startAnimation(aVar);
            if (this.fxe != null) {
                if (this.fxe.getAnimation() == null || this.fxe.getAnimation().hasEnded()) {
                    if (i == 0) {
                        if (this.fxj == null) {
                            aXu();
                        }
                        if (this.fxk != null) {
                            this.fxk.cancel();
                        }
                        this.fxe.startAnimation(this.fxj);
                        return;
                    }
                    if (this.fxk == null) {
                        aXt();
                    }
                    if (this.fxj != null) {
                        this.fxj.cancel();
                    }
                    this.fxe.startAnimation(this.fxk);
                }
            }
        }
    }

    private void aXt() {
        this.fxk = AnimationUtils.loadAnimation(this.mContext, d.a.rotate_collapse);
        this.fxk.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                ConcernSelectView.this.fxl = false;
            }
        });
    }

    private void aXu() {
        this.fxj = AnimationUtils.loadAnimation(this.mContext, d.a.rotate_expand);
        this.fxj.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ConcernSelectView.this.fxl = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void setOnExpandListener(a aVar) {
        this.fxm = aVar;
    }
}

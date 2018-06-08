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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class ConcernSelectView extends FrameLayout {
    private View biz;
    private LinearLayout fej;
    private ImageView fek;
    private TextView fel;
    private TextView fem;
    private TextView fen;
    public LinearLayout feo;
    private Animation fep;
    private Animation feq;
    private boolean fer;
    private a fes;
    private Context mContext;
    private int mSkinType;

    /* loaded from: classes3.dex */
    public interface a {
        void iS(boolean z);

        void lj(int i);
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
        this.fej = (LinearLayout) findViewById(d.g.expandable_area);
        this.fek = (ImageView) findViewById(d.g.expandable_btn);
        this.feo = (LinearLayout) findViewById(d.g.menu_list);
        this.fel = (TextView) findViewById(d.g.menu_title);
        this.fem = (TextView) findViewById(d.g.all_concerned_item);
        this.fen = (TextView) findViewById(d.g.each_concerned_item);
        this.biz = findViewById(d.g.item_divider_line);
        this.fej.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new am("c12774").ah("obj_locate", "1"));
                ConcernSelectView.this.t(ConcernSelectView.this.feo, ConcernSelectView.this.feo.getVisibility() == 0 ? 1 : 0);
            }
        });
        this.fem.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new am("c12774").ah("obj_locate", "2"));
                al.h(ConcernSelectView.this.fem, d.C0141d.cp_cont_b);
                al.h(ConcernSelectView.this.fen, d.C0141d.cp_cont_j);
                ConcernSelectView.this.fel.setText(d.k.all_concerned);
                if (ConcernSelectView.this.fes != null) {
                    ConcernSelectView.this.fes.lj(0);
                }
                ConcernSelectView.this.t(ConcernSelectView.this.feo, 1);
            }
        });
        this.fen.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new am("c12774").ah("obj_locate", "3"));
                al.h(ConcernSelectView.this.fem, d.C0141d.cp_cont_j);
                al.h(ConcernSelectView.this.fen, d.C0141d.cp_cont_b);
                ConcernSelectView.this.fel.setText(d.k.each_concerned);
                if (ConcernSelectView.this.fes != null) {
                    ConcernSelectView.this.fes.lj(1);
                }
                ConcernSelectView.this.t(ConcernSelectView.this.feo, 1);
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void aXi() {
        if (!(this.feo.getVisibility() == 0)) {
            t(this.feo, 0);
        }
    }

    public void aXj() {
        if (this.feo.getVisibility() == 0) {
            t(this.feo, 1);
        }
    }

    public boolean aXk() {
        return this.feo.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.c(this.fek, d.f.icon_arrow_gray_down);
            al.h(this.fel, d.C0141d.cp_cont_d);
            al.h(this.fem, d.C0141d.cp_cont_b);
            al.h(this.fen, d.C0141d.cp_cont_j);
            al.i(this.feo, d.f.bg_user_float_shadow);
            al.i(this.fel, d.C0141d.cp_bg_line_d);
            al.i(this.fem, d.f.concern_item_bg);
            al.i(this.fen, d.f.concern_item_bg);
            al.i(this.biz, d.C0141d.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(final View view, final int i) {
        if (view != null && view.getAnimation() == null && this.feo != null) {
            int childCount = this.feo.getChildCount();
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
                    if (ConcernSelectView.this.fes != null) {
                        ConcernSelectView.this.fes.iS(z);
                    }
                }
            });
            view.startAnimation(aVar);
            if (this.fek != null) {
                if (this.fek.getAnimation() == null || this.fek.getAnimation().hasEnded()) {
                    if (i == 0) {
                        if (this.fep == null) {
                            aXm();
                        }
                        if (this.feq != null) {
                            this.feq.cancel();
                        }
                        this.fek.startAnimation(this.fep);
                        return;
                    }
                    if (this.feq == null) {
                        aXl();
                    }
                    if (this.fep != null) {
                        this.fep.cancel();
                    }
                    this.fek.startAnimation(this.feq);
                }
            }
        }
    }

    private void aXl() {
        this.feq = AnimationUtils.loadAnimation(this.mContext, d.a.rotate_collapse);
        this.feq.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                ConcernSelectView.this.fer = false;
            }
        });
    }

    private void aXm() {
        this.fep = AnimationUtils.loadAnimation(this.mContext, d.a.rotate_expand);
        this.fep.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ConcernSelectView.this.fer = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void setOnExpandListener(a aVar) {
        this.fes = aVar;
    }
}

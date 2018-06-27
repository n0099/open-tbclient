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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class ConcernSelectView extends FrameLayout {
    private View bjZ;
    private LinearLayout fia;
    private ImageView fib;
    private TextView fic;
    private TextView fie;
    private TextView fif;
    public LinearLayout fig;
    private Animation fih;
    private Animation fii;
    private boolean fij;
    private a fik;
    private Context mContext;
    private int mSkinType;

    /* loaded from: classes3.dex */
    public interface a {
        void jc(boolean z);

        void lq(int i);
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
        this.fia = (LinearLayout) findViewById(d.g.expandable_area);
        this.fib = (ImageView) findViewById(d.g.expandable_btn);
        this.fig = (LinearLayout) findViewById(d.g.menu_list);
        this.fic = (TextView) findViewById(d.g.menu_title);
        this.fie = (TextView) findViewById(d.g.all_concerned_item);
        this.fif = (TextView) findViewById(d.g.each_concerned_item);
        this.bjZ = findViewById(d.g.item_divider_line);
        this.fia.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new an("c12774").ah("obj_locate", "1"));
                ConcernSelectView.this.v(ConcernSelectView.this.fig, ConcernSelectView.this.fig.getVisibility() == 0 ? 1 : 0);
            }
        });
        this.fie.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new an("c12774").ah("obj_locate", "2"));
                am.h(ConcernSelectView.this.fie, d.C0142d.cp_cont_b);
                am.h(ConcernSelectView.this.fif, d.C0142d.cp_cont_j);
                ConcernSelectView.this.fic.setText(d.k.all_concerned);
                if (ConcernSelectView.this.fik != null) {
                    ConcernSelectView.this.fik.lq(0);
                }
                ConcernSelectView.this.v(ConcernSelectView.this.fig, 1);
            }
        });
        this.fif.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new an("c12774").ah("obj_locate", "3"));
                am.h(ConcernSelectView.this.fie, d.C0142d.cp_cont_j);
                am.h(ConcernSelectView.this.fif, d.C0142d.cp_cont_b);
                ConcernSelectView.this.fic.setText(d.k.each_concerned);
                if (ConcernSelectView.this.fik != null) {
                    ConcernSelectView.this.fik.lq(1);
                }
                ConcernSelectView.this.v(ConcernSelectView.this.fig, 1);
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void aXP() {
        if (!(this.fig.getVisibility() == 0)) {
            v(this.fig, 0);
        }
    }

    public void aXQ() {
        if (this.fig.getVisibility() == 0) {
            v(this.fig, 1);
        }
    }

    public boolean aXR() {
        return this.fig.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.c(this.fib, d.f.icon_arrow_gray_down);
            am.h(this.fic, d.C0142d.cp_cont_d);
            am.h(this.fie, d.C0142d.cp_cont_b);
            am.h(this.fif, d.C0142d.cp_cont_j);
            am.i(this.fig, d.f.bg_user_float_shadow);
            am.i(this.fic, d.C0142d.cp_bg_line_d);
            am.i(this.fie, d.f.concern_item_bg);
            am.i(this.fif, d.f.concern_item_bg);
            am.i(this.bjZ, d.C0142d.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(final View view, final int i) {
        if (view != null && view.getAnimation() == null && this.fig != null) {
            int childCount = this.fig.getChildCount();
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
                    if (ConcernSelectView.this.fik != null) {
                        ConcernSelectView.this.fik.jc(z);
                    }
                }
            });
            view.startAnimation(aVar);
            if (this.fib != null) {
                if (this.fib.getAnimation() == null || this.fib.getAnimation().hasEnded()) {
                    if (i == 0) {
                        if (this.fih == null) {
                            aXT();
                        }
                        if (this.fii != null) {
                            this.fii.cancel();
                        }
                        this.fib.startAnimation(this.fih);
                        return;
                    }
                    if (this.fii == null) {
                        aXS();
                    }
                    if (this.fih != null) {
                        this.fih.cancel();
                    }
                    this.fib.startAnimation(this.fii);
                }
            }
        }
    }

    private void aXS() {
        this.fii = AnimationUtils.loadAnimation(this.mContext, d.a.rotate_collapse);
        this.fii.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                ConcernSelectView.this.fij = false;
            }
        });
    }

    private void aXT() {
        this.fih = AnimationUtils.loadAnimation(this.mContext, d.a.rotate_expand);
        this.fih.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ConcernSelectView.this.fij = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void setOnExpandListener(a aVar) {
        this.fik = aVar;
    }
}

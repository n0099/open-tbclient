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
    private View bkE;
    private LinearLayout fin;
    private ImageView fio;
    private TextView fip;
    private TextView fiq;
    private TextView fir;
    public LinearLayout fis;
    private Animation fit;
    private Animation fiu;
    private boolean fiv;
    private a fiw;
    private Context mContext;
    private int mSkinType;

    /* loaded from: classes3.dex */
    public interface a {
        void iO(boolean z);

        void lB(int i);
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
        this.fin = (LinearLayout) findViewById(d.g.expandable_area);
        this.fio = (ImageView) findViewById(d.g.expandable_btn);
        this.fis = (LinearLayout) findViewById(d.g.menu_list);
        this.fip = (TextView) findViewById(d.g.menu_title);
        this.fiq = (TextView) findViewById(d.g.all_concerned_item);
        this.fir = (TextView) findViewById(d.g.each_concerned_item);
        this.bkE = findViewById(d.g.item_divider_line);
        this.fin.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new an("c12774").af("obj_locate", "1"));
                ConcernSelectView.this.v(ConcernSelectView.this.fis, ConcernSelectView.this.fis.getVisibility() == 0 ? 1 : 0);
            }
        });
        this.fiq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new an("c12774").af("obj_locate", "2"));
                am.h(ConcernSelectView.this.fiq, d.C0140d.cp_cont_b);
                am.h(ConcernSelectView.this.fir, d.C0140d.cp_cont_j);
                ConcernSelectView.this.fip.setText(d.j.all_concerned);
                if (ConcernSelectView.this.fiw != null) {
                    ConcernSelectView.this.fiw.lB(0);
                }
                ConcernSelectView.this.v(ConcernSelectView.this.fis, 1);
            }
        });
        this.fir.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new an("c12774").af("obj_locate", "3"));
                am.h(ConcernSelectView.this.fiq, d.C0140d.cp_cont_j);
                am.h(ConcernSelectView.this.fir, d.C0140d.cp_cont_b);
                ConcernSelectView.this.fip.setText(d.j.each_concerned);
                if (ConcernSelectView.this.fiw != null) {
                    ConcernSelectView.this.fiw.lB(1);
                }
                ConcernSelectView.this.v(ConcernSelectView.this.fis, 1);
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void aWk() {
        if (!(this.fis.getVisibility() == 0)) {
            v(this.fis, 0);
        }
    }

    public void aWl() {
        if (this.fis.getVisibility() == 0) {
            v(this.fis, 1);
        }
    }

    public boolean aWm() {
        return this.fis.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.c(this.fio, d.f.icon_arrow_gray_down);
            am.h(this.fip, d.C0140d.cp_cont_d);
            am.h(this.fiq, d.C0140d.cp_cont_b);
            am.h(this.fir, d.C0140d.cp_cont_j);
            am.i(this.fis, d.f.bg_user_float_shadow);
            am.i(this.fip, d.C0140d.cp_bg_line_d);
            am.i(this.fiq, d.f.concern_item_bg);
            am.i(this.fir, d.f.concern_item_bg);
            am.i(this.bkE, d.C0140d.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(final View view, final int i) {
        if (view != null && view.getAnimation() == null && this.fis != null) {
            int childCount = this.fis.getChildCount();
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
                    if (ConcernSelectView.this.fiw != null) {
                        ConcernSelectView.this.fiw.iO(z);
                    }
                }
            });
            view.startAnimation(aVar);
            if (this.fio != null) {
                if (this.fio.getAnimation() == null || this.fio.getAnimation().hasEnded()) {
                    if (i == 0) {
                        if (this.fit == null) {
                            aWo();
                        }
                        if (this.fiu != null) {
                            this.fiu.cancel();
                        }
                        this.fio.startAnimation(this.fit);
                        return;
                    }
                    if (this.fiu == null) {
                        aWn();
                    }
                    if (this.fit != null) {
                        this.fit.cancel();
                    }
                    this.fio.startAnimation(this.fiu);
                }
            }
        }
    }

    private void aWn() {
        this.fiu = AnimationUtils.loadAnimation(this.mContext, d.a.rotate_collapse);
        this.fiu.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                ConcernSelectView.this.fiv = false;
            }
        });
    }

    private void aWo() {
        this.fit = AnimationUtils.loadAnimation(this.mContext, d.a.rotate_expand);
        this.fit.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ConcernSelectView.this.fiv = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void setOnExpandListener(a aVar) {
        this.fiw = aVar;
    }
}

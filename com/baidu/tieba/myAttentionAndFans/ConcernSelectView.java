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
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class ConcernSelectView extends FrameLayout {
    private View bzG;
    private LinearLayout fJj;
    private ImageView fJk;
    private TextView fJl;
    private TextView fJm;
    private TextView fJn;
    public LinearLayout fJo;
    private Animation fJp;
    private Animation fJq;
    private boolean fJr;
    private a fJs;
    private Context mContext;
    private int mSkinType;

    /* loaded from: classes3.dex */
    public interface a {
        void jU(boolean z);

        void nx(int i);
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
        LayoutInflater.from(this.mContext).inflate(e.h.concern_select_layout, this);
        this.fJj = (LinearLayout) findViewById(e.g.expandable_area);
        this.fJk = (ImageView) findViewById(e.g.expandable_btn);
        this.fJo = (LinearLayout) findViewById(e.g.menu_list);
        this.fJl = (TextView) findViewById(e.g.menu_title);
        this.fJm = (TextView) findViewById(e.g.all_concerned_item);
        this.fJn = (TextView) findViewById(e.g.each_concerned_item);
        this.bzG = findViewById(e.g.item_divider_line);
        this.fJj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new am("c12774").aB("obj_locate", "1"));
                ConcernSelectView.this.x(ConcernSelectView.this.fJo, ConcernSelectView.this.fJo.getVisibility() == 0 ? 1 : 0);
            }
        });
        this.fJm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new am("c12774").aB("obj_locate", "2"));
                al.h(ConcernSelectView.this.fJm, e.d.cp_cont_b);
                al.h(ConcernSelectView.this.fJn, e.d.cp_cont_j);
                ConcernSelectView.this.fJl.setText(e.j.all_concerned);
                if (ConcernSelectView.this.fJs != null) {
                    ConcernSelectView.this.fJs.nx(0);
                }
                ConcernSelectView.this.x(ConcernSelectView.this.fJo, 1);
            }
        });
        this.fJn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new am("c12774").aB("obj_locate", "3"));
                al.h(ConcernSelectView.this.fJm, e.d.cp_cont_j);
                al.h(ConcernSelectView.this.fJn, e.d.cp_cont_b);
                ConcernSelectView.this.fJl.setText(e.j.each_concerned);
                if (ConcernSelectView.this.fJs != null) {
                    ConcernSelectView.this.fJs.nx(1);
                }
                ConcernSelectView.this.x(ConcernSelectView.this.fJo, 1);
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void bei() {
        if (!(this.fJo.getVisibility() == 0)) {
            x(this.fJo, 0);
        }
    }

    public void bej() {
        if (this.fJo.getVisibility() == 0) {
            x(this.fJo, 1);
        }
    }

    public boolean bek() {
        return this.fJo.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.c(this.fJk, e.f.icon_arrow_gray_down);
            al.h(this.fJl, e.d.cp_cont_d);
            al.h(this.fJm, e.d.cp_cont_b);
            al.h(this.fJn, e.d.cp_cont_j);
            al.i(this.fJo, e.f.bg_user_float_shadow);
            al.i(this.fJl, e.d.cp_bg_line_d);
            al.i(this.fJm, e.f.concern_item_bg);
            al.i(this.fJn, e.f.concern_item_bg);
            al.i(this.bzG, e.d.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(final View view, final int i) {
        if (view != null && view.getAnimation() == null && this.fJo != null) {
            int childCount = this.fJo.getChildCount();
            if (childCount < 0) {
                childCount = 0;
            }
            com.baidu.tieba.myAttentionAndFans.a aVar = new com.baidu.tieba.myAttentionAndFans.a(view, i, childCount * (((int) this.mContext.getResources().getDimension(e.C0210e.tbds80)) + ((int) this.mContext.getResources().getDimension(e.C0210e.ds1))));
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
                    if (ConcernSelectView.this.fJs != null) {
                        ConcernSelectView.this.fJs.jU(z);
                    }
                }
            });
            view.startAnimation(aVar);
            if (this.fJk != null) {
                if (this.fJk.getAnimation() == null || this.fJk.getAnimation().hasEnded()) {
                    if (i == 0) {
                        if (this.fJp == null) {
                            bem();
                        }
                        if (this.fJq != null) {
                            this.fJq.cancel();
                        }
                        this.fJk.startAnimation(this.fJp);
                        return;
                    }
                    if (this.fJq == null) {
                        bel();
                    }
                    if (this.fJp != null) {
                        this.fJp.cancel();
                    }
                    this.fJk.startAnimation(this.fJq);
                }
            }
        }
    }

    private void bel() {
        this.fJq = AnimationUtils.loadAnimation(this.mContext, e.a.rotate_collapse);
        this.fJq.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                ConcernSelectView.this.fJr = false;
            }
        });
    }

    private void bem() {
        this.fJp = AnimationUtils.loadAnimation(this.mContext, e.a.rotate_expand);
        this.fJp.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ConcernSelectView.this.fJr = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void setOnExpandListener(a aVar) {
        this.fJs = aVar;
    }
}

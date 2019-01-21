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
    private View bzH;
    private LinearLayout fJk;
    private ImageView fJl;
    private TextView fJm;
    private TextView fJn;
    private TextView fJo;
    public LinearLayout fJp;
    private Animation fJq;
    private Animation fJr;
    private boolean fJs;
    private a fJt;
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
        this.fJk = (LinearLayout) findViewById(e.g.expandable_area);
        this.fJl = (ImageView) findViewById(e.g.expandable_btn);
        this.fJp = (LinearLayout) findViewById(e.g.menu_list);
        this.fJm = (TextView) findViewById(e.g.menu_title);
        this.fJn = (TextView) findViewById(e.g.all_concerned_item);
        this.fJo = (TextView) findViewById(e.g.each_concerned_item);
        this.bzH = findViewById(e.g.item_divider_line);
        this.fJk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new am("c12774").aB("obj_locate", "1"));
                ConcernSelectView.this.x(ConcernSelectView.this.fJp, ConcernSelectView.this.fJp.getVisibility() == 0 ? 1 : 0);
            }
        });
        this.fJn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new am("c12774").aB("obj_locate", "2"));
                al.h(ConcernSelectView.this.fJn, e.d.cp_cont_b);
                al.h(ConcernSelectView.this.fJo, e.d.cp_cont_j);
                ConcernSelectView.this.fJm.setText(e.j.all_concerned);
                if (ConcernSelectView.this.fJt != null) {
                    ConcernSelectView.this.fJt.nx(0);
                }
                ConcernSelectView.this.x(ConcernSelectView.this.fJp, 1);
            }
        });
        this.fJo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new am("c12774").aB("obj_locate", "3"));
                al.h(ConcernSelectView.this.fJn, e.d.cp_cont_j);
                al.h(ConcernSelectView.this.fJo, e.d.cp_cont_b);
                ConcernSelectView.this.fJm.setText(e.j.each_concerned);
                if (ConcernSelectView.this.fJt != null) {
                    ConcernSelectView.this.fJt.nx(1);
                }
                ConcernSelectView.this.x(ConcernSelectView.this.fJp, 1);
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void bei() {
        if (!(this.fJp.getVisibility() == 0)) {
            x(this.fJp, 0);
        }
    }

    public void bej() {
        if (this.fJp.getVisibility() == 0) {
            x(this.fJp, 1);
        }
    }

    public boolean bek() {
        return this.fJp.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.c(this.fJl, e.f.icon_arrow_gray_down);
            al.h(this.fJm, e.d.cp_cont_d);
            al.h(this.fJn, e.d.cp_cont_b);
            al.h(this.fJo, e.d.cp_cont_j);
            al.i(this.fJp, e.f.bg_user_float_shadow);
            al.i(this.fJm, e.d.cp_bg_line_d);
            al.i(this.fJn, e.f.concern_item_bg);
            al.i(this.fJo, e.f.concern_item_bg);
            al.i(this.bzH, e.d.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(final View view, final int i) {
        if (view != null && view.getAnimation() == null && this.fJp != null) {
            int childCount = this.fJp.getChildCount();
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
                    if (ConcernSelectView.this.fJt != null) {
                        ConcernSelectView.this.fJt.jU(z);
                    }
                }
            });
            view.startAnimation(aVar);
            if (this.fJl != null) {
                if (this.fJl.getAnimation() == null || this.fJl.getAnimation().hasEnded()) {
                    if (i == 0) {
                        if (this.fJq == null) {
                            bem();
                        }
                        if (this.fJr != null) {
                            this.fJr.cancel();
                        }
                        this.fJl.startAnimation(this.fJq);
                        return;
                    }
                    if (this.fJr == null) {
                        bel();
                    }
                    if (this.fJq != null) {
                        this.fJq.cancel();
                    }
                    this.fJl.startAnimation(this.fJr);
                }
            }
        }
    }

    private void bel() {
        this.fJr = AnimationUtils.loadAnimation(this.mContext, e.a.rotate_collapse);
        this.fJr.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                ConcernSelectView.this.fJs = false;
            }
        });
    }

    private void bem() {
        this.fJq = AnimationUtils.loadAnimation(this.mContext, e.a.rotate_expand);
        this.fJq.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ConcernSelectView.this.fJs = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void setOnExpandListener(a aVar) {
        this.fJt = aVar;
    }
}

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
    private View buH;
    private LinearLayout fxk;
    private ImageView fxl;
    private TextView fxm;
    private TextView fxn;
    private TextView fxo;
    public LinearLayout fxp;
    private Animation fxq;
    private Animation fxr;
    private boolean fxs;
    private a fxt;
    private Context mContext;
    private int mSkinType;

    /* loaded from: classes3.dex */
    public interface a {
        void jE(boolean z);

        void mB(int i);
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
        this.fxk = (LinearLayout) findViewById(e.g.expandable_area);
        this.fxl = (ImageView) findViewById(e.g.expandable_btn);
        this.fxp = (LinearLayout) findViewById(e.g.menu_list);
        this.fxm = (TextView) findViewById(e.g.menu_title);
        this.fxn = (TextView) findViewById(e.g.all_concerned_item);
        this.fxo = (TextView) findViewById(e.g.each_concerned_item);
        this.buH = findViewById(e.g.item_divider_line);
        this.fxk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new am("c12774").ax("obj_locate", "1"));
                ConcernSelectView.this.w(ConcernSelectView.this.fxp, ConcernSelectView.this.fxp.getVisibility() == 0 ? 1 : 0);
            }
        });
        this.fxn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new am("c12774").ax("obj_locate", "2"));
                al.h(ConcernSelectView.this.fxn, e.d.cp_cont_b);
                al.h(ConcernSelectView.this.fxo, e.d.cp_cont_j);
                ConcernSelectView.this.fxm.setText(e.j.all_concerned);
                if (ConcernSelectView.this.fxt != null) {
                    ConcernSelectView.this.fxt.mB(0);
                }
                ConcernSelectView.this.w(ConcernSelectView.this.fxp, 1);
            }
        });
        this.fxo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new am("c12774").ax("obj_locate", "3"));
                al.h(ConcernSelectView.this.fxn, e.d.cp_cont_j);
                al.h(ConcernSelectView.this.fxo, e.d.cp_cont_b);
                ConcernSelectView.this.fxm.setText(e.j.each_concerned);
                if (ConcernSelectView.this.fxt != null) {
                    ConcernSelectView.this.fxt.mB(1);
                }
                ConcernSelectView.this.w(ConcernSelectView.this.fxp, 1);
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void bbF() {
        if (!(this.fxp.getVisibility() == 0)) {
            w(this.fxp, 0);
        }
    }

    public void bbG() {
        if (this.fxp.getVisibility() == 0) {
            w(this.fxp, 1);
        }
    }

    public boolean bbH() {
        return this.fxp.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.c(this.fxl, e.f.icon_arrow_gray_down);
            al.h(this.fxm, e.d.cp_cont_d);
            al.h(this.fxn, e.d.cp_cont_b);
            al.h(this.fxo, e.d.cp_cont_j);
            al.i(this.fxp, e.f.bg_user_float_shadow);
            al.i(this.fxm, e.d.cp_bg_line_d);
            al.i(this.fxn, e.f.concern_item_bg);
            al.i(this.fxo, e.f.concern_item_bg);
            al.i(this.buH, e.d.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(final View view, final int i) {
        if (view != null && view.getAnimation() == null && this.fxp != null) {
            int childCount = this.fxp.getChildCount();
            if (childCount < 0) {
                childCount = 0;
            }
            com.baidu.tieba.myAttentionAndFans.a aVar = new com.baidu.tieba.myAttentionAndFans.a(view, i, childCount * (((int) this.mContext.getResources().getDimension(e.C0175e.tbds80)) + ((int) this.mContext.getResources().getDimension(e.C0175e.ds1))));
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
                    if (ConcernSelectView.this.fxt != null) {
                        ConcernSelectView.this.fxt.jE(z);
                    }
                }
            });
            view.startAnimation(aVar);
            if (this.fxl != null) {
                if (this.fxl.getAnimation() == null || this.fxl.getAnimation().hasEnded()) {
                    if (i == 0) {
                        if (this.fxq == null) {
                            bbJ();
                        }
                        if (this.fxr != null) {
                            this.fxr.cancel();
                        }
                        this.fxl.startAnimation(this.fxq);
                        return;
                    }
                    if (this.fxr == null) {
                        bbI();
                    }
                    if (this.fxq != null) {
                        this.fxq.cancel();
                    }
                    this.fxl.startAnimation(this.fxr);
                }
            }
        }
    }

    private void bbI() {
        this.fxr = AnimationUtils.loadAnimation(this.mContext, e.a.rotate_collapse);
        this.fxr.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                ConcernSelectView.this.fxs = false;
            }
        });
    }

    private void bbJ() {
        this.fxq = AnimationUtils.loadAnimation(this.mContext, e.a.rotate_expand);
        this.fxq.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ConcernSelectView.this.fxs = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void setOnExpandListener(a aVar) {
        this.fxt = aVar;
    }
}

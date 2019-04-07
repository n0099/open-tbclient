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
/* loaded from: classes5.dex */
public class ConcernSelectView extends FrameLayout {
    private View cKM;
    private LinearLayout gZi;
    private ImageView gZj;
    private TextView gZk;
    private TextView gZl;
    private TextView gZm;
    public LinearLayout gZn;
    private Animation gZo;
    private Animation gZp;
    private boolean gZq;
    private a gZr;
    private Context mContext;
    private int mSkinType;

    /* loaded from: classes5.dex */
    public interface a {
        void mv(boolean z);

        void rh(int i);
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
        this.gZi = (LinearLayout) findViewById(d.g.expandable_area);
        this.gZj = (ImageView) findViewById(d.g.expandable_btn);
        this.gZn = (LinearLayout) findViewById(d.g.menu_list);
        this.gZk = (TextView) findViewById(d.g.menu_title);
        this.gZl = (TextView) findViewById(d.g.all_concerned_item);
        this.gZm = (TextView) findViewById(d.g.each_concerned_item);
        this.cKM = findViewById(d.g.item_divider_line);
        this.gZi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new am("c12774").bJ("obj_locate", "1"));
                ConcernSelectView.this.C(ConcernSelectView.this.gZn, ConcernSelectView.this.gZn.getVisibility() == 0 ? 1 : 0);
            }
        });
        this.gZl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new am("c12774").bJ("obj_locate", "2"));
                al.j(ConcernSelectView.this.gZl, d.C0277d.cp_cont_b);
                al.j(ConcernSelectView.this.gZm, d.C0277d.cp_cont_j);
                ConcernSelectView.this.gZk.setText(d.j.all_concerned);
                if (ConcernSelectView.this.gZr != null) {
                    ConcernSelectView.this.gZr.rh(0);
                }
                ConcernSelectView.this.C(ConcernSelectView.this.gZn, 1);
            }
        });
        this.gZm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new am("c12774").bJ("obj_locate", "3"));
                al.j(ConcernSelectView.this.gZl, d.C0277d.cp_cont_j);
                al.j(ConcernSelectView.this.gZm, d.C0277d.cp_cont_b);
                ConcernSelectView.this.gZk.setText(d.j.each_concerned);
                if (ConcernSelectView.this.gZr != null) {
                    ConcernSelectView.this.gZr.rh(1);
                }
                ConcernSelectView.this.C(ConcernSelectView.this.gZn, 1);
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void bEI() {
        if (!(this.gZn.getVisibility() == 0)) {
            C(this.gZn, 0);
        }
    }

    public void bEJ() {
        if (this.gZn.getVisibility() == 0) {
            C(this.gZn, 1);
        }
    }

    public boolean bEK() {
        return this.gZn.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.c(this.gZj, d.f.icon_arrow_gray_down);
            al.j(this.gZk, d.C0277d.cp_cont_d);
            al.j(this.gZl, d.C0277d.cp_cont_b);
            al.j(this.gZm, d.C0277d.cp_cont_j);
            al.k(this.gZn, d.f.concern_item_bg);
            al.k(this.gZk, d.C0277d.cp_bg_line_d);
            al.k(this.gZl, d.f.concern_item_menu_select_bg);
            al.k(this.gZm, d.f.concern_item_menu_select_bg);
            al.k(this.cKM, d.C0277d.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(final View view, final int i) {
        if (view != null && view.getAnimation() == null && this.gZn != null) {
            int childCount = this.gZn.getChildCount();
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
                    if (ConcernSelectView.this.gZr != null) {
                        ConcernSelectView.this.gZr.mv(z);
                    }
                }
            });
            view.startAnimation(aVar);
            if (this.gZj != null) {
                if (this.gZj.getAnimation() == null || this.gZj.getAnimation().hasEnded()) {
                    if (i == 0) {
                        if (this.gZo == null) {
                            bEM();
                        }
                        if (this.gZp != null) {
                            this.gZp.cancel();
                        }
                        this.gZj.startAnimation(this.gZo);
                        return;
                    }
                    if (this.gZp == null) {
                        bEL();
                    }
                    if (this.gZo != null) {
                        this.gZo.cancel();
                    }
                    this.gZj.startAnimation(this.gZp);
                }
            }
        }
    }

    private void bEL() {
        this.gZp = AnimationUtils.loadAnimation(this.mContext, d.a.rotate_collapse);
        this.gZp.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                ConcernSelectView.this.gZq = false;
            }
        });
    }

    private void bEM() {
        this.gZo = AnimationUtils.loadAnimation(this.mContext, d.a.rotate_expand);
        this.gZo.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ConcernSelectView.this.gZq = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void setOnExpandListener(a aVar) {
        this.gZr = aVar;
    }
}

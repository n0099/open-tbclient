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
    private View cKK;
    public LinearLayout gZA;
    private Animation gZB;
    private Animation gZC;
    private boolean gZD;
    private a gZE;
    private LinearLayout gZv;
    private ImageView gZw;
    private TextView gZx;
    private TextView gZy;
    private TextView gZz;
    private Context mContext;
    private int mSkinType;

    /* loaded from: classes5.dex */
    public interface a {
        void mv(boolean z);

        void rl(int i);
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
        this.gZv = (LinearLayout) findViewById(d.g.expandable_area);
        this.gZw = (ImageView) findViewById(d.g.expandable_btn);
        this.gZA = (LinearLayout) findViewById(d.g.menu_list);
        this.gZx = (TextView) findViewById(d.g.menu_title);
        this.gZy = (TextView) findViewById(d.g.all_concerned_item);
        this.gZz = (TextView) findViewById(d.g.each_concerned_item);
        this.cKK = findViewById(d.g.item_divider_line);
        this.gZv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new am("c12774").bJ("obj_locate", "1"));
                ConcernSelectView.this.C(ConcernSelectView.this.gZA, ConcernSelectView.this.gZA.getVisibility() == 0 ? 1 : 0);
            }
        });
        this.gZy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new am("c12774").bJ("obj_locate", "2"));
                al.j(ConcernSelectView.this.gZy, d.C0277d.cp_cont_b);
                al.j(ConcernSelectView.this.gZz, d.C0277d.cp_cont_j);
                ConcernSelectView.this.gZx.setText(d.j.all_concerned);
                if (ConcernSelectView.this.gZE != null) {
                    ConcernSelectView.this.gZE.rl(0);
                }
                ConcernSelectView.this.C(ConcernSelectView.this.gZA, 1);
            }
        });
        this.gZz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new am("c12774").bJ("obj_locate", "3"));
                al.j(ConcernSelectView.this.gZy, d.C0277d.cp_cont_j);
                al.j(ConcernSelectView.this.gZz, d.C0277d.cp_cont_b);
                ConcernSelectView.this.gZx.setText(d.j.each_concerned);
                if (ConcernSelectView.this.gZE != null) {
                    ConcernSelectView.this.gZE.rl(1);
                }
                ConcernSelectView.this.C(ConcernSelectView.this.gZA, 1);
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void bEL() {
        if (!(this.gZA.getVisibility() == 0)) {
            C(this.gZA, 0);
        }
    }

    public void bEM() {
        if (this.gZA.getVisibility() == 0) {
            C(this.gZA, 1);
        }
    }

    public boolean bEN() {
        return this.gZA.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.c(this.gZw, d.f.icon_arrow_gray_down);
            al.j(this.gZx, d.C0277d.cp_cont_d);
            al.j(this.gZy, d.C0277d.cp_cont_b);
            al.j(this.gZz, d.C0277d.cp_cont_j);
            al.k(this.gZA, d.f.concern_item_bg);
            al.k(this.gZx, d.C0277d.cp_bg_line_d);
            al.k(this.gZy, d.f.concern_item_menu_select_bg);
            al.k(this.gZz, d.f.concern_item_menu_select_bg);
            al.k(this.cKK, d.C0277d.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(final View view, final int i) {
        if (view != null && view.getAnimation() == null && this.gZA != null) {
            int childCount = this.gZA.getChildCount();
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
                    if (ConcernSelectView.this.gZE != null) {
                        ConcernSelectView.this.gZE.mv(z);
                    }
                }
            });
            view.startAnimation(aVar);
            if (this.gZw != null) {
                if (this.gZw.getAnimation() == null || this.gZw.getAnimation().hasEnded()) {
                    if (i == 0) {
                        if (this.gZB == null) {
                            bEP();
                        }
                        if (this.gZC != null) {
                            this.gZC.cancel();
                        }
                        this.gZw.startAnimation(this.gZB);
                        return;
                    }
                    if (this.gZC == null) {
                        bEO();
                    }
                    if (this.gZB != null) {
                        this.gZB.cancel();
                    }
                    this.gZw.startAnimation(this.gZC);
                }
            }
        }
    }

    private void bEO() {
        this.gZC = AnimationUtils.loadAnimation(this.mContext, d.a.rotate_collapse);
        this.gZC.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                ConcernSelectView.this.gZD = false;
            }
        });
    }

    private void bEP() {
        this.gZB = AnimationUtils.loadAnimation(this.mContext, d.a.rotate_expand);
        this.gZB.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ConcernSelectView.this.gZD = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void setOnExpandListener(a aVar) {
        this.gZE = aVar;
    }
}

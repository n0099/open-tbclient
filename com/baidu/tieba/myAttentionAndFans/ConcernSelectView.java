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
    private View byS;
    private LinearLayout fIp;
    private ImageView fIq;
    private TextView fIr;
    private TextView fIs;
    private TextView fIt;
    public LinearLayout fIu;
    private Animation fIv;
    private Animation fIw;
    private boolean fIx;
    private a fIy;
    private Context mContext;
    private int mSkinType;

    /* loaded from: classes3.dex */
    public interface a {
        void jU(boolean z);

        void nw(int i);
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
        this.fIp = (LinearLayout) findViewById(e.g.expandable_area);
        this.fIq = (ImageView) findViewById(e.g.expandable_btn);
        this.fIu = (LinearLayout) findViewById(e.g.menu_list);
        this.fIr = (TextView) findViewById(e.g.menu_title);
        this.fIs = (TextView) findViewById(e.g.all_concerned_item);
        this.fIt = (TextView) findViewById(e.g.each_concerned_item);
        this.byS = findViewById(e.g.item_divider_line);
        this.fIp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new am("c12774").aA("obj_locate", "1"));
                ConcernSelectView.this.x(ConcernSelectView.this.fIu, ConcernSelectView.this.fIu.getVisibility() == 0 ? 1 : 0);
            }
        });
        this.fIs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new am("c12774").aA("obj_locate", "2"));
                al.h(ConcernSelectView.this.fIs, e.d.cp_cont_b);
                al.h(ConcernSelectView.this.fIt, e.d.cp_cont_j);
                ConcernSelectView.this.fIr.setText(e.j.all_concerned);
                if (ConcernSelectView.this.fIy != null) {
                    ConcernSelectView.this.fIy.nw(0);
                }
                ConcernSelectView.this.x(ConcernSelectView.this.fIu, 1);
            }
        });
        this.fIt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new am("c12774").aA("obj_locate", "3"));
                al.h(ConcernSelectView.this.fIs, e.d.cp_cont_j);
                al.h(ConcernSelectView.this.fIt, e.d.cp_cont_b);
                ConcernSelectView.this.fIr.setText(e.j.each_concerned);
                if (ConcernSelectView.this.fIy != null) {
                    ConcernSelectView.this.fIy.nw(1);
                }
                ConcernSelectView.this.x(ConcernSelectView.this.fIu, 1);
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void bdI() {
        if (!(this.fIu.getVisibility() == 0)) {
            x(this.fIu, 0);
        }
    }

    public void bdJ() {
        if (this.fIu.getVisibility() == 0) {
            x(this.fIu, 1);
        }
    }

    public boolean bdK() {
        return this.fIu.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.c(this.fIq, e.f.icon_arrow_gray_down);
            al.h(this.fIr, e.d.cp_cont_d);
            al.h(this.fIs, e.d.cp_cont_b);
            al.h(this.fIt, e.d.cp_cont_j);
            al.i(this.fIu, e.f.bg_user_float_shadow);
            al.i(this.fIr, e.d.cp_bg_line_d);
            al.i(this.fIs, e.f.concern_item_bg);
            al.i(this.fIt, e.f.concern_item_bg);
            al.i(this.byS, e.d.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(final View view, final int i) {
        if (view != null && view.getAnimation() == null && this.fIu != null) {
            int childCount = this.fIu.getChildCount();
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
                    if (ConcernSelectView.this.fIy != null) {
                        ConcernSelectView.this.fIy.jU(z);
                    }
                }
            });
            view.startAnimation(aVar);
            if (this.fIq != null) {
                if (this.fIq.getAnimation() == null || this.fIq.getAnimation().hasEnded()) {
                    if (i == 0) {
                        if (this.fIv == null) {
                            bdM();
                        }
                        if (this.fIw != null) {
                            this.fIw.cancel();
                        }
                        this.fIq.startAnimation(this.fIv);
                        return;
                    }
                    if (this.fIw == null) {
                        bdL();
                    }
                    if (this.fIv != null) {
                        this.fIv.cancel();
                    }
                    this.fIq.startAnimation(this.fIw);
                }
            }
        }
    }

    private void bdL() {
        this.fIw = AnimationUtils.loadAnimation(this.mContext, e.a.rotate_collapse);
        this.fIw.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                ConcernSelectView.this.fIx = false;
            }
        });
    }

    private void bdM() {
        this.fIv = AnimationUtils.loadAnimation(this.mContext, e.a.rotate_expand);
        this.fIv.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ConcernSelectView.this.fIx = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void setOnExpandListener(a aVar) {
        this.fIy = aVar;
    }
}

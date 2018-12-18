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
    private View byP;
    private TextView fFA;
    private TextView fFB;
    public LinearLayout fFC;
    private Animation fFD;
    private Animation fFE;
    private boolean fFF;
    private a fFG;
    private LinearLayout fFx;
    private ImageView fFy;
    private TextView fFz;
    private Context mContext;
    private int mSkinType;

    /* loaded from: classes3.dex */
    public interface a {
        void jR(boolean z);

        void nj(int i);
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
        this.fFx = (LinearLayout) findViewById(e.g.expandable_area);
        this.fFy = (ImageView) findViewById(e.g.expandable_btn);
        this.fFC = (LinearLayout) findViewById(e.g.menu_list);
        this.fFz = (TextView) findViewById(e.g.menu_title);
        this.fFA = (TextView) findViewById(e.g.all_concerned_item);
        this.fFB = (TextView) findViewById(e.g.each_concerned_item);
        this.byP = findViewById(e.g.item_divider_line);
        this.fFx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new am("c12774").aA("obj_locate", "1"));
                ConcernSelectView.this.x(ConcernSelectView.this.fFC, ConcernSelectView.this.fFC.getVisibility() == 0 ? 1 : 0);
            }
        });
        this.fFA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new am("c12774").aA("obj_locate", "2"));
                al.h(ConcernSelectView.this.fFA, e.d.cp_cont_b);
                al.h(ConcernSelectView.this.fFB, e.d.cp_cont_j);
                ConcernSelectView.this.fFz.setText(e.j.all_concerned);
                if (ConcernSelectView.this.fFG != null) {
                    ConcernSelectView.this.fFG.nj(0);
                }
                ConcernSelectView.this.x(ConcernSelectView.this.fFC, 1);
            }
        });
        this.fFB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new am("c12774").aA("obj_locate", "3"));
                al.h(ConcernSelectView.this.fFA, e.d.cp_cont_j);
                al.h(ConcernSelectView.this.fFB, e.d.cp_cont_b);
                ConcernSelectView.this.fFz.setText(e.j.each_concerned);
                if (ConcernSelectView.this.fFG != null) {
                    ConcernSelectView.this.fFG.nj(1);
                }
                ConcernSelectView.this.x(ConcernSelectView.this.fFC, 1);
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void bcU() {
        if (!(this.fFC.getVisibility() == 0)) {
            x(this.fFC, 0);
        }
    }

    public void bcV() {
        if (this.fFC.getVisibility() == 0) {
            x(this.fFC, 1);
        }
    }

    public boolean bcW() {
        return this.fFC.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.c(this.fFy, e.f.icon_arrow_gray_down);
            al.h(this.fFz, e.d.cp_cont_d);
            al.h(this.fFA, e.d.cp_cont_b);
            al.h(this.fFB, e.d.cp_cont_j);
            al.i(this.fFC, e.f.bg_user_float_shadow);
            al.i(this.fFz, e.d.cp_bg_line_d);
            al.i(this.fFA, e.f.concern_item_bg);
            al.i(this.fFB, e.f.concern_item_bg);
            al.i(this.byP, e.d.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(final View view, final int i) {
        if (view != null && view.getAnimation() == null && this.fFC != null) {
            int childCount = this.fFC.getChildCount();
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
                    if (ConcernSelectView.this.fFG != null) {
                        ConcernSelectView.this.fFG.jR(z);
                    }
                }
            });
            view.startAnimation(aVar);
            if (this.fFy != null) {
                if (this.fFy.getAnimation() == null || this.fFy.getAnimation().hasEnded()) {
                    if (i == 0) {
                        if (this.fFD == null) {
                            bcY();
                        }
                        if (this.fFE != null) {
                            this.fFE.cancel();
                        }
                        this.fFy.startAnimation(this.fFD);
                        return;
                    }
                    if (this.fFE == null) {
                        bcX();
                    }
                    if (this.fFD != null) {
                        this.fFD.cancel();
                    }
                    this.fFy.startAnimation(this.fFE);
                }
            }
        }
    }

    private void bcX() {
        this.fFE = AnimationUtils.loadAnimation(this.mContext, e.a.rotate_collapse);
        this.fFE.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                ConcernSelectView.this.fFF = false;
            }
        });
    }

    private void bcY() {
        this.fFD = AnimationUtils.loadAnimation(this.mContext, e.a.rotate_expand);
        this.fFD.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ConcernSelectView.this.fFF = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void setOnExpandListener(a aVar) {
        this.fFG = aVar;
    }
}

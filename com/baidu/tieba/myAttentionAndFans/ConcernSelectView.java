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
    private View bqy;
    private LinearLayout fpE;
    private ImageView fpF;
    private TextView fpG;
    private TextView fpH;
    private TextView fpI;
    public LinearLayout fpJ;
    private Animation fpK;
    private Animation fpL;
    private boolean fpM;
    private a fpN;
    private Context mContext;
    private int mSkinType;

    /* loaded from: classes3.dex */
    public interface a {
        void jm(boolean z);

        void md(int i);
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
        this.fpE = (LinearLayout) findViewById(e.g.expandable_area);
        this.fpF = (ImageView) findViewById(e.g.expandable_btn);
        this.fpJ = (LinearLayout) findViewById(e.g.menu_list);
        this.fpG = (TextView) findViewById(e.g.menu_title);
        this.fpH = (TextView) findViewById(e.g.all_concerned_item);
        this.fpI = (TextView) findViewById(e.g.each_concerned_item);
        this.bqy = findViewById(e.g.item_divider_line);
        this.fpE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new am("c12774").al("obj_locate", "1"));
                ConcernSelectView.this.w(ConcernSelectView.this.fpJ, ConcernSelectView.this.fpJ.getVisibility() == 0 ? 1 : 0);
            }
        });
        this.fpH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new am("c12774").al("obj_locate", "2"));
                al.h(ConcernSelectView.this.fpH, e.d.cp_cont_b);
                al.h(ConcernSelectView.this.fpI, e.d.cp_cont_j);
                ConcernSelectView.this.fpG.setText(e.j.all_concerned);
                if (ConcernSelectView.this.fpN != null) {
                    ConcernSelectView.this.fpN.md(0);
                }
                ConcernSelectView.this.w(ConcernSelectView.this.fpJ, 1);
            }
        });
        this.fpI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new am("c12774").al("obj_locate", "3"));
                al.h(ConcernSelectView.this.fpH, e.d.cp_cont_j);
                al.h(ConcernSelectView.this.fpI, e.d.cp_cont_b);
                ConcernSelectView.this.fpG.setText(e.j.each_concerned);
                if (ConcernSelectView.this.fpN != null) {
                    ConcernSelectView.this.fpN.md(1);
                }
                ConcernSelectView.this.w(ConcernSelectView.this.fpJ, 1);
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void aYt() {
        if (!(this.fpJ.getVisibility() == 0)) {
            w(this.fpJ, 0);
        }
    }

    public void aYu() {
        if (this.fpJ.getVisibility() == 0) {
            w(this.fpJ, 1);
        }
    }

    public boolean aYv() {
        return this.fpJ.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.c(this.fpF, e.f.icon_arrow_gray_down);
            al.h(this.fpG, e.d.cp_cont_d);
            al.h(this.fpH, e.d.cp_cont_b);
            al.h(this.fpI, e.d.cp_cont_j);
            al.i(this.fpJ, e.f.bg_user_float_shadow);
            al.i(this.fpG, e.d.cp_bg_line_d);
            al.i(this.fpH, e.f.concern_item_bg);
            al.i(this.fpI, e.f.concern_item_bg);
            al.i(this.bqy, e.d.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(final View view, final int i) {
        if (view != null && view.getAnimation() == null && this.fpJ != null) {
            int childCount = this.fpJ.getChildCount();
            if (childCount < 0) {
                childCount = 0;
            }
            com.baidu.tieba.myAttentionAndFans.a aVar = new com.baidu.tieba.myAttentionAndFans.a(view, i, childCount * (((int) this.mContext.getResources().getDimension(e.C0141e.tbds80)) + ((int) this.mContext.getResources().getDimension(e.C0141e.ds1))));
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
                    if (ConcernSelectView.this.fpN != null) {
                        ConcernSelectView.this.fpN.jm(z);
                    }
                }
            });
            view.startAnimation(aVar);
            if (this.fpF != null) {
                if (this.fpF.getAnimation() == null || this.fpF.getAnimation().hasEnded()) {
                    if (i == 0) {
                        if (this.fpK == null) {
                            aYx();
                        }
                        if (this.fpL != null) {
                            this.fpL.cancel();
                        }
                        this.fpF.startAnimation(this.fpK);
                        return;
                    }
                    if (this.fpL == null) {
                        aYw();
                    }
                    if (this.fpK != null) {
                        this.fpK.cancel();
                    }
                    this.fpF.startAnimation(this.fpL);
                }
            }
        }
    }

    private void aYw() {
        this.fpL = AnimationUtils.loadAnimation(this.mContext, e.a.rotate_collapse);
        this.fpL.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                ConcernSelectView.this.fpM = false;
            }
        });
    }

    private void aYx() {
        this.fpK = AnimationUtils.loadAnimation(this.mContext, e.a.rotate_expand);
        this.fpK.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ConcernSelectView.this.fpM = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void setOnExpandListener(a aVar) {
        this.fpN = aVar;
    }
}

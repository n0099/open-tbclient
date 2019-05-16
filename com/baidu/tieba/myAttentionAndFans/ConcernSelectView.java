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
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class ConcernSelectView extends FrameLayout {
    private View cSY;
    private LinearLayout hqA;
    private ImageView hqB;
    private TextView hqC;
    private TextView hqD;
    private TextView hqE;
    public LinearLayout hqF;
    private Animation hqG;
    private Animation hqH;
    private boolean hqI;
    private a hqJ;
    private Context mContext;
    private int mSkinType;

    /* loaded from: classes5.dex */
    public interface a {
        void nk(boolean z);

        void sp(int i);
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
        LayoutInflater.from(this.mContext).inflate(R.layout.concern_select_layout, this);
        this.hqA = (LinearLayout) findViewById(R.id.expandable_area);
        this.hqB = (ImageView) findViewById(R.id.expandable_btn);
        this.hqF = (LinearLayout) findViewById(R.id.menu_list);
        this.hqC = (TextView) findViewById(R.id.menu_title);
        this.hqD = (TextView) findViewById(R.id.all_concerned_item);
        this.hqE = (TextView) findViewById(R.id.each_concerned_item);
        this.cSY = findViewById(R.id.item_divider_line);
        this.hqA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new am("c12774").bT("obj_locate", "1"));
                ConcernSelectView.this.E(ConcernSelectView.this.hqF, ConcernSelectView.this.hqF.getVisibility() == 0 ? 1 : 0);
            }
        });
        this.hqD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new am("c12774").bT("obj_locate", "2"));
                al.j(ConcernSelectView.this.hqD, R.color.cp_cont_b);
                al.j(ConcernSelectView.this.hqE, R.color.cp_cont_j);
                ConcernSelectView.this.hqC.setText(R.string.all_concerned);
                if (ConcernSelectView.this.hqJ != null) {
                    ConcernSelectView.this.hqJ.sp(0);
                }
                ConcernSelectView.this.E(ConcernSelectView.this.hqF, 1);
            }
        });
        this.hqE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new am("c12774").bT("obj_locate", "3"));
                al.j(ConcernSelectView.this.hqD, R.color.cp_cont_j);
                al.j(ConcernSelectView.this.hqE, R.color.cp_cont_b);
                ConcernSelectView.this.hqC.setText(R.string.each_concerned);
                if (ConcernSelectView.this.hqJ != null) {
                    ConcernSelectView.this.hqJ.sp(1);
                }
                ConcernSelectView.this.E(ConcernSelectView.this.hqF, 1);
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void bMt() {
        if (!(this.hqF.getVisibility() == 0)) {
            E(this.hqF, 0);
        }
    }

    public void bMu() {
        if (this.hqF.getVisibility() == 0) {
            E(this.hqF, 1);
        }
    }

    public boolean bMv() {
        return this.hqF.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.c(this.hqB, (int) R.drawable.icon_arrow_gray_down);
            al.j(this.hqC, R.color.cp_cont_d);
            al.j(this.hqD, R.color.cp_cont_b);
            al.j(this.hqE, R.color.cp_cont_j);
            al.k(this.hqF, R.drawable.concern_item_bg);
            al.k(this.hqC, R.color.cp_bg_line_d);
            al.k(this.hqD, R.drawable.concern_item_menu_select_bg);
            al.k(this.hqE, R.drawable.concern_item_menu_select_bg);
            al.k(this.cSY, R.color.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(final View view, final int i) {
        if (view != null && view.getAnimation() == null && this.hqF != null) {
            int childCount = this.hqF.getChildCount();
            if (childCount < 0) {
                childCount = 0;
            }
            com.baidu.tieba.myAttentionAndFans.a aVar = new com.baidu.tieba.myAttentionAndFans.a(view, i, childCount * (((int) this.mContext.getResources().getDimension(R.dimen.tbds80)) + ((int) this.mContext.getResources().getDimension(R.dimen.ds1))));
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
                    if (ConcernSelectView.this.hqJ != null) {
                        ConcernSelectView.this.hqJ.nk(z);
                    }
                }
            });
            view.startAnimation(aVar);
            if (this.hqB != null) {
                if (this.hqB.getAnimation() == null || this.hqB.getAnimation().hasEnded()) {
                    if (i == 0) {
                        if (this.hqG == null) {
                            bMx();
                        }
                        if (this.hqH != null) {
                            this.hqH.cancel();
                        }
                        this.hqB.startAnimation(this.hqG);
                        return;
                    }
                    if (this.hqH == null) {
                        bMw();
                    }
                    if (this.hqG != null) {
                        this.hqG.cancel();
                    }
                    this.hqB.startAnimation(this.hqH);
                }
            }
        }
    }

    private void bMw() {
        this.hqH = AnimationUtils.loadAnimation(this.mContext, R.anim.rotate_collapse);
        this.hqH.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                ConcernSelectView.this.hqI = false;
            }
        });
    }

    private void bMx() {
        this.hqG = AnimationUtils.loadAnimation(this.mContext, R.anim.rotate_expand);
        this.hqG.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ConcernSelectView.this.hqI = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void setOnExpandListener(a aVar) {
        this.hqJ = aVar;
    }
}

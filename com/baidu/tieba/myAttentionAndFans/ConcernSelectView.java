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
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class ConcernSelectView extends FrameLayout {
    private View cUD;
    private LinearLayout hxI;
    private ImageView hxJ;
    private TextView hxK;
    private TextView hxL;
    private TextView hxM;
    public LinearLayout hxN;
    private Animation hxO;
    private Animation hxP;
    private boolean hxQ;
    private a hxR;
    private Context mContext;
    private int mSkinType;

    /* loaded from: classes5.dex */
    public interface a {
        void nz(boolean z);

        void sJ(int i);
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
        this.hxI = (LinearLayout) findViewById(R.id.expandable_area);
        this.hxJ = (ImageView) findViewById(R.id.expandable_btn);
        this.hxN = (LinearLayout) findViewById(R.id.menu_list);
        this.hxK = (TextView) findViewById(R.id.menu_title);
        this.hxL = (TextView) findViewById(R.id.all_concerned_item);
        this.hxM = (TextView) findViewById(R.id.each_concerned_item);
        this.cUD = findViewById(R.id.item_divider_line);
        this.hxI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new an("c12774").bT("obj_locate", "1"));
                ConcernSelectView.this.E(ConcernSelectView.this.hxN, ConcernSelectView.this.hxN.getVisibility() == 0 ? 1 : 0);
            }
        });
        this.hxL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new an("c12774").bT("obj_locate", "2"));
                am.j(ConcernSelectView.this.hxL, R.color.cp_cont_b);
                am.j(ConcernSelectView.this.hxM, R.color.cp_cont_j);
                ConcernSelectView.this.hxK.setText(R.string.all_concerned);
                if (ConcernSelectView.this.hxR != null) {
                    ConcernSelectView.this.hxR.sJ(0);
                }
                ConcernSelectView.this.E(ConcernSelectView.this.hxN, 1);
            }
        });
        this.hxM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new an("c12774").bT("obj_locate", "3"));
                am.j(ConcernSelectView.this.hxL, R.color.cp_cont_j);
                am.j(ConcernSelectView.this.hxM, R.color.cp_cont_b);
                ConcernSelectView.this.hxK.setText(R.string.each_concerned);
                if (ConcernSelectView.this.hxR != null) {
                    ConcernSelectView.this.hxR.sJ(1);
                }
                ConcernSelectView.this.E(ConcernSelectView.this.hxN, 1);
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void bPt() {
        if (!(this.hxN.getVisibility() == 0)) {
            E(this.hxN, 0);
        }
    }

    public void bPu() {
        if (this.hxN.getVisibility() == 0) {
            E(this.hxN, 1);
        }
    }

    public boolean bPv() {
        return this.hxN.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.c(this.hxJ, (int) R.drawable.icon_arrow_gray_down);
            am.j(this.hxK, R.color.cp_cont_d);
            am.j(this.hxL, R.color.cp_cont_b);
            am.j(this.hxM, R.color.cp_cont_j);
            am.k(this.hxN, R.drawable.concern_item_bg);
            am.k(this.hxK, R.color.cp_bg_line_d);
            am.k(this.hxL, R.drawable.concern_item_menu_select_bg);
            am.k(this.hxM, R.drawable.concern_item_menu_select_bg);
            am.k(this.cUD, R.color.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(final View view, final int i) {
        if (view != null && view.getAnimation() == null && this.hxN != null) {
            int childCount = this.hxN.getChildCount();
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
                    if (ConcernSelectView.this.hxR != null) {
                        ConcernSelectView.this.hxR.nz(z);
                    }
                }
            });
            view.startAnimation(aVar);
            if (this.hxJ != null) {
                if (this.hxJ.getAnimation() == null || this.hxJ.getAnimation().hasEnded()) {
                    if (i == 0) {
                        if (this.hxO == null) {
                            bPx();
                        }
                        if (this.hxP != null) {
                            this.hxP.cancel();
                        }
                        this.hxJ.startAnimation(this.hxO);
                        return;
                    }
                    if (this.hxP == null) {
                        bPw();
                    }
                    if (this.hxO != null) {
                        this.hxO.cancel();
                    }
                    this.hxJ.startAnimation(this.hxP);
                }
            }
        }
    }

    private void bPw() {
        this.hxP = AnimationUtils.loadAnimation(this.mContext, R.anim.rotate_collapse);
        this.hxP.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                ConcernSelectView.this.hxQ = false;
            }
        });
    }

    private void bPx() {
        this.hxO = AnimationUtils.loadAnimation(this.mContext, R.anim.rotate_expand);
        this.hxO.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ConcernSelectView.this.hxQ = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void setOnExpandListener(a aVar) {
        this.hxR = aVar;
    }
}

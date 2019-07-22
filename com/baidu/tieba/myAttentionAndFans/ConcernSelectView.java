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
    private View cUw;
    private LinearLayout hwQ;
    private ImageView hwR;
    private TextView hwS;
    private TextView hwT;
    private TextView hwU;
    public LinearLayout hwV;
    private Animation hwW;
    private Animation hwX;
    private boolean hwY;
    private a hwZ;
    private Context mContext;
    private int mSkinType;

    /* loaded from: classes5.dex */
    public interface a {
        void nz(boolean z);

        void sH(int i);
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
        this.hwQ = (LinearLayout) findViewById(R.id.expandable_area);
        this.hwR = (ImageView) findViewById(R.id.expandable_btn);
        this.hwV = (LinearLayout) findViewById(R.id.menu_list);
        this.hwS = (TextView) findViewById(R.id.menu_title);
        this.hwT = (TextView) findViewById(R.id.all_concerned_item);
        this.hwU = (TextView) findViewById(R.id.each_concerned_item);
        this.cUw = findViewById(R.id.item_divider_line);
        this.hwQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new an("c12774").bT("obj_locate", "1"));
                ConcernSelectView.this.E(ConcernSelectView.this.hwV, ConcernSelectView.this.hwV.getVisibility() == 0 ? 1 : 0);
            }
        });
        this.hwT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new an("c12774").bT("obj_locate", "2"));
                am.j(ConcernSelectView.this.hwT, R.color.cp_cont_b);
                am.j(ConcernSelectView.this.hwU, R.color.cp_cont_j);
                ConcernSelectView.this.hwS.setText(R.string.all_concerned);
                if (ConcernSelectView.this.hwZ != null) {
                    ConcernSelectView.this.hwZ.sH(0);
                }
                ConcernSelectView.this.E(ConcernSelectView.this.hwV, 1);
            }
        });
        this.hwU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new an("c12774").bT("obj_locate", "3"));
                am.j(ConcernSelectView.this.hwT, R.color.cp_cont_j);
                am.j(ConcernSelectView.this.hwU, R.color.cp_cont_b);
                ConcernSelectView.this.hwS.setText(R.string.each_concerned);
                if (ConcernSelectView.this.hwZ != null) {
                    ConcernSelectView.this.hwZ.sH(1);
                }
                ConcernSelectView.this.E(ConcernSelectView.this.hwV, 1);
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void bPf() {
        if (!(this.hwV.getVisibility() == 0)) {
            E(this.hwV, 0);
        }
    }

    public void bPg() {
        if (this.hwV.getVisibility() == 0) {
            E(this.hwV, 1);
        }
    }

    public boolean bPh() {
        return this.hwV.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.c(this.hwR, (int) R.drawable.icon_arrow_gray_down);
            am.j(this.hwS, R.color.cp_cont_d);
            am.j(this.hwT, R.color.cp_cont_b);
            am.j(this.hwU, R.color.cp_cont_j);
            am.k(this.hwV, R.drawable.concern_item_bg);
            am.k(this.hwS, R.color.cp_bg_line_d);
            am.k(this.hwT, R.drawable.concern_item_menu_select_bg);
            am.k(this.hwU, R.drawable.concern_item_menu_select_bg);
            am.k(this.cUw, R.color.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(final View view, final int i) {
        if (view != null && view.getAnimation() == null && this.hwV != null) {
            int childCount = this.hwV.getChildCount();
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
                    if (ConcernSelectView.this.hwZ != null) {
                        ConcernSelectView.this.hwZ.nz(z);
                    }
                }
            });
            view.startAnimation(aVar);
            if (this.hwR != null) {
                if (this.hwR.getAnimation() == null || this.hwR.getAnimation().hasEnded()) {
                    if (i == 0) {
                        if (this.hwW == null) {
                            bPj();
                        }
                        if (this.hwX != null) {
                            this.hwX.cancel();
                        }
                        this.hwR.startAnimation(this.hwW);
                        return;
                    }
                    if (this.hwX == null) {
                        bPi();
                    }
                    if (this.hwW != null) {
                        this.hwW.cancel();
                    }
                    this.hwR.startAnimation(this.hwX);
                }
            }
        }
    }

    private void bPi() {
        this.hwX = AnimationUtils.loadAnimation(this.mContext, R.anim.rotate_collapse);
        this.hwX.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                ConcernSelectView.this.hwY = false;
            }
        });
    }

    private void bPj() {
        this.hwW = AnimationUtils.loadAnimation(this.mContext, R.anim.rotate_expand);
        this.hwW.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ConcernSelectView.this.hwY = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void setOnExpandListener(a aVar) {
        this.hwZ = aVar;
    }
}

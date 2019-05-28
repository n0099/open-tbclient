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
    private View cSZ;
    private LinearLayout hqD;
    private ImageView hqE;
    private TextView hqF;
    private TextView hqG;
    private TextView hqH;
    public LinearLayout hqI;
    private Animation hqJ;
    private Animation hqK;
    private boolean hqL;
    private a hqM;
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
        this.hqD = (LinearLayout) findViewById(R.id.expandable_area);
        this.hqE = (ImageView) findViewById(R.id.expandable_btn);
        this.hqI = (LinearLayout) findViewById(R.id.menu_list);
        this.hqF = (TextView) findViewById(R.id.menu_title);
        this.hqG = (TextView) findViewById(R.id.all_concerned_item);
        this.hqH = (TextView) findViewById(R.id.each_concerned_item);
        this.cSZ = findViewById(R.id.item_divider_line);
        this.hqD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new am("c12774").bT("obj_locate", "1"));
                ConcernSelectView.this.E(ConcernSelectView.this.hqI, ConcernSelectView.this.hqI.getVisibility() == 0 ? 1 : 0);
            }
        });
        this.hqG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new am("c12774").bT("obj_locate", "2"));
                al.j(ConcernSelectView.this.hqG, R.color.cp_cont_b);
                al.j(ConcernSelectView.this.hqH, R.color.cp_cont_j);
                ConcernSelectView.this.hqF.setText(R.string.all_concerned);
                if (ConcernSelectView.this.hqM != null) {
                    ConcernSelectView.this.hqM.sp(0);
                }
                ConcernSelectView.this.E(ConcernSelectView.this.hqI, 1);
            }
        });
        this.hqH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new am("c12774").bT("obj_locate", "3"));
                al.j(ConcernSelectView.this.hqG, R.color.cp_cont_j);
                al.j(ConcernSelectView.this.hqH, R.color.cp_cont_b);
                ConcernSelectView.this.hqF.setText(R.string.each_concerned);
                if (ConcernSelectView.this.hqM != null) {
                    ConcernSelectView.this.hqM.sp(1);
                }
                ConcernSelectView.this.E(ConcernSelectView.this.hqI, 1);
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void bMw() {
        if (!(this.hqI.getVisibility() == 0)) {
            E(this.hqI, 0);
        }
    }

    public void bMx() {
        if (this.hqI.getVisibility() == 0) {
            E(this.hqI, 1);
        }
    }

    public boolean bMy() {
        return this.hqI.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.c(this.hqE, (int) R.drawable.icon_arrow_gray_down);
            al.j(this.hqF, R.color.cp_cont_d);
            al.j(this.hqG, R.color.cp_cont_b);
            al.j(this.hqH, R.color.cp_cont_j);
            al.k(this.hqI, R.drawable.concern_item_bg);
            al.k(this.hqF, R.color.cp_bg_line_d);
            al.k(this.hqG, R.drawable.concern_item_menu_select_bg);
            al.k(this.hqH, R.drawable.concern_item_menu_select_bg);
            al.k(this.cSZ, R.color.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(final View view, final int i) {
        if (view != null && view.getAnimation() == null && this.hqI != null) {
            int childCount = this.hqI.getChildCount();
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
                    if (ConcernSelectView.this.hqM != null) {
                        ConcernSelectView.this.hqM.nk(z);
                    }
                }
            });
            view.startAnimation(aVar);
            if (this.hqE != null) {
                if (this.hqE.getAnimation() == null || this.hqE.getAnimation().hasEnded()) {
                    if (i == 0) {
                        if (this.hqJ == null) {
                            bMA();
                        }
                        if (this.hqK != null) {
                            this.hqK.cancel();
                        }
                        this.hqE.startAnimation(this.hqJ);
                        return;
                    }
                    if (this.hqK == null) {
                        bMz();
                    }
                    if (this.hqJ != null) {
                        this.hqJ.cancel();
                    }
                    this.hqE.startAnimation(this.hqK);
                }
            }
        }
    }

    private void bMz() {
        this.hqK = AnimationUtils.loadAnimation(this.mContext, R.anim.rotate_collapse);
        this.hqK.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                ConcernSelectView.this.hqL = false;
            }
        });
    }

    private void bMA() {
        this.hqJ = AnimationUtils.loadAnimation(this.mContext, R.anim.rotate_expand);
        this.hqJ.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ConcernSelectView.this.hqL = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void setOnExpandListener(a aVar) {
        this.hqM = aVar;
    }
}

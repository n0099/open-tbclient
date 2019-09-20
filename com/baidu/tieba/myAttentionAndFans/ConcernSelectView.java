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
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class ConcernSelectView extends FrameLayout {
    private View cVw;
    private LinearLayout hzE;
    private ImageView hzF;
    private TextView hzG;
    private TextView hzH;
    private TextView hzI;
    public LinearLayout hzJ;
    private Animation hzK;
    private Animation hzL;
    private boolean hzM;
    private a hzN;
    private Context mContext;
    private int mSkinType;

    /* loaded from: classes5.dex */
    public interface a {
        void nD(boolean z);

        void sN(int i);
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
        this.hzE = (LinearLayout) findViewById(R.id.expandable_area);
        this.hzF = (ImageView) findViewById(R.id.expandable_btn);
        this.hzJ = (LinearLayout) findViewById(R.id.menu_list);
        this.hzG = (TextView) findViewById(R.id.menu_title);
        this.hzH = (TextView) findViewById(R.id.all_concerned_item);
        this.hzI = (TextView) findViewById(R.id.each_concerned_item);
        this.cVw = findViewById(R.id.item_divider_line);
        this.hzE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new an("c12774").bT("obj_locate", "1"));
                ConcernSelectView.this.E(ConcernSelectView.this.hzJ, ConcernSelectView.this.hzJ.getVisibility() == 0 ? 1 : 0);
            }
        });
        this.hzH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new an("c12774").bT("obj_locate", "2"));
                am.j(ConcernSelectView.this.hzH, R.color.cp_cont_b);
                am.j(ConcernSelectView.this.hzI, R.color.cp_cont_j);
                ConcernSelectView.this.hzG.setText(R.string.all_concerned);
                if (ConcernSelectView.this.hzN != null) {
                    ConcernSelectView.this.hzN.sN(0);
                }
                ConcernSelectView.this.E(ConcernSelectView.this.hzJ, 1);
            }
        });
        this.hzI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new an("c12774").bT("obj_locate", "3"));
                am.j(ConcernSelectView.this.hzH, R.color.cp_cont_j);
                am.j(ConcernSelectView.this.hzI, R.color.cp_cont_b);
                ConcernSelectView.this.hzG.setText(R.string.each_concerned);
                if (ConcernSelectView.this.hzN != null) {
                    ConcernSelectView.this.hzN.sN(1);
                }
                ConcernSelectView.this.E(ConcernSelectView.this.hzJ, 1);
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void bQh() {
        if (!(this.hzJ.getVisibility() == 0)) {
            E(this.hzJ, 0);
        }
    }

    public void bQi() {
        if (this.hzJ.getVisibility() == 0) {
            E(this.hzJ, 1);
        }
    }

    public boolean bQj() {
        return this.hzJ.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            SvgManager.ajv().a(this.hzF, R.drawable.icon_pure_list_arrow12_down_n_svg, R.color.cp_cont_d, null);
            am.j(this.hzG, R.color.cp_cont_d);
            am.j(this.hzH, R.color.cp_cont_b);
            am.j(this.hzI, R.color.cp_cont_j);
            am.k(this.hzJ, R.drawable.concern_item_bg);
            am.k(this.hzG, R.color.cp_bg_line_d);
            am.k(this.hzH, R.drawable.concern_item_menu_select_bg);
            am.k(this.hzI, R.drawable.concern_item_menu_select_bg);
            am.k(this.cVw, R.color.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(final View view, final int i) {
        if (view != null && view.getAnimation() == null && this.hzJ != null) {
            int childCount = this.hzJ.getChildCount();
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
                    if (ConcernSelectView.this.hzN != null) {
                        ConcernSelectView.this.hzN.nD(z);
                    }
                }
            });
            view.startAnimation(aVar);
            if (this.hzF != null) {
                if (this.hzF.getAnimation() == null || this.hzF.getAnimation().hasEnded()) {
                    if (i == 0) {
                        if (this.hzK == null) {
                            bQl();
                        }
                        if (this.hzL != null) {
                            this.hzL.cancel();
                        }
                        this.hzF.startAnimation(this.hzK);
                        return;
                    }
                    if (this.hzL == null) {
                        bQk();
                    }
                    if (this.hzK != null) {
                        this.hzK.cancel();
                    }
                    this.hzF.startAnimation(this.hzL);
                }
            }
        }
    }

    private void bQk() {
        this.hzL = AnimationUtils.loadAnimation(this.mContext, R.anim.rotate_collapse);
        this.hzL.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                ConcernSelectView.this.hzM = false;
            }
        });
    }

    private void bQl() {
        this.hzK = AnimationUtils.loadAnimation(this.mContext, R.anim.rotate_expand);
        this.hzK.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ConcernSelectView.this.hzM = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void setOnExpandListener(a aVar) {
        this.hzN = aVar;
    }
}

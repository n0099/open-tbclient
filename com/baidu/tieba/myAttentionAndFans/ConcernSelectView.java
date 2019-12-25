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
/* loaded from: classes7.dex */
public class ConcernSelectView extends FrameLayout {
    private View bZT;
    private ImageView ilA;
    private TextView ilB;
    private TextView ilC;
    private TextView ilD;
    public LinearLayout ilE;
    private Animation ilF;
    private Animation ilG;
    private boolean ilH;
    private a ilI;
    private LinearLayout ilz;
    private Context mContext;
    private int mSkinType;

    /* loaded from: classes7.dex */
    public interface a {
        void oE(boolean z);

        void tM(int i);
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
        this.ilz = (LinearLayout) findViewById(R.id.expandable_area);
        this.ilA = (ImageView) findViewById(R.id.expandable_btn);
        this.ilE = (LinearLayout) findViewById(R.id.menu_list);
        this.ilB = (TextView) findViewById(R.id.menu_title);
        this.ilC = (TextView) findViewById(R.id.all_concerned_item);
        this.ilD = (TextView) findViewById(R.id.each_concerned_item);
        this.bZT = findViewById(R.id.item_divider_line);
        this.ilz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new an("c12774").cp("obj_locate", "1"));
                ConcernSelectView.this.r(ConcernSelectView.this.ilE, ConcernSelectView.this.ilE.getVisibility() == 0 ? 1 : 0);
            }
        });
        this.ilC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new an("c12774").cp("obj_locate", "2"));
                am.setViewTextColor(ConcernSelectView.this.ilC, (int) R.color.cp_cont_b);
                am.setViewTextColor(ConcernSelectView.this.ilD, (int) R.color.cp_cont_j);
                ConcernSelectView.this.ilB.setText(R.string.all_concerned);
                if (ConcernSelectView.this.ilI != null) {
                    ConcernSelectView.this.ilI.tM(0);
                }
                ConcernSelectView.this.r(ConcernSelectView.this.ilE, 1);
            }
        });
        this.ilD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new an("c12774").cp("obj_locate", "3"));
                am.setViewTextColor(ConcernSelectView.this.ilC, (int) R.color.cp_cont_j);
                am.setViewTextColor(ConcernSelectView.this.ilD, (int) R.color.cp_cont_b);
                ConcernSelectView.this.ilB.setText(R.string.each_concerned);
                if (ConcernSelectView.this.ilI != null) {
                    ConcernSelectView.this.ilI.tM(1);
                }
                ConcernSelectView.this.r(ConcernSelectView.this.ilE, 1);
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void cer() {
        if (!(this.ilE.getVisibility() == 0)) {
            r(this.ilE, 0);
        }
    }

    public void ces() {
        if (this.ilE.getVisibility() == 0) {
            r(this.ilE, 1);
        }
    }

    public boolean cet() {
        return this.ilE.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            SvgManager.aDW().a(this.ilA, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
            am.setViewTextColor(this.ilB, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.ilC, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.ilD, (int) R.color.cp_cont_j);
            am.setBackgroundResource(this.ilE, R.drawable.concern_item_bg);
            am.setBackgroundResource(this.ilB, R.color.cp_bg_line_d);
            am.setBackgroundResource(this.ilC, R.drawable.concern_item_menu_select_bg);
            am.setBackgroundResource(this.ilD, R.drawable.concern_item_menu_select_bg);
            am.setBackgroundResource(this.bZT, R.color.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(final View view, final int i) {
        if (view != null && view.getAnimation() == null && this.ilE != null) {
            int childCount = this.ilE.getChildCount();
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
                    if (ConcernSelectView.this.ilI != null) {
                        ConcernSelectView.this.ilI.oE(z);
                    }
                }
            });
            view.startAnimation(aVar);
            if (this.ilA != null) {
                if (this.ilA.getAnimation() == null || this.ilA.getAnimation().hasEnded()) {
                    if (i == 0) {
                        if (this.ilF == null) {
                            cev();
                        }
                        if (this.ilG != null) {
                            this.ilG.cancel();
                        }
                        this.ilA.startAnimation(this.ilF);
                        return;
                    }
                    if (this.ilG == null) {
                        ceu();
                    }
                    if (this.ilF != null) {
                        this.ilF.cancel();
                    }
                    this.ilA.startAnimation(this.ilG);
                }
            }
        }
    }

    private void ceu() {
        this.ilG = AnimationUtils.loadAnimation(this.mContext, R.anim.rotate_collapse);
        this.ilG.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                ConcernSelectView.this.ilH = false;
            }
        });
    }

    private void cev() {
        this.ilF = AnimationUtils.loadAnimation(this.mContext, R.anim.rotate_expand);
        this.ilF.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ConcernSelectView.this.ilH = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void setOnExpandListener(a aVar) {
        this.ilI = aVar;
    }
}

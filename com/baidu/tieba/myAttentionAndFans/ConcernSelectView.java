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
    private View ddZ;
    private LinearLayout hxB;
    private ImageView hxC;
    private TextView hxD;
    private TextView hxE;
    private TextView hxF;
    public LinearLayout hxG;
    private Animation hxH;
    private Animation hxI;
    private boolean hxJ;
    private a hxK;
    private Context mContext;
    private int mSkinType;

    /* loaded from: classes5.dex */
    public interface a {
        void np(boolean z);

        void rG(int i);
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
        this.hxB = (LinearLayout) findViewById(R.id.expandable_area);
        this.hxC = (ImageView) findViewById(R.id.expandable_btn);
        this.hxG = (LinearLayout) findViewById(R.id.menu_list);
        this.hxD = (TextView) findViewById(R.id.menu_title);
        this.hxE = (TextView) findViewById(R.id.all_concerned_item);
        this.hxF = (TextView) findViewById(R.id.each_concerned_item);
        this.ddZ = findViewById(R.id.item_divider_line);
        this.hxB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new an("c12774").bS("obj_locate", "1"));
                ConcernSelectView.this.t(ConcernSelectView.this.hxG, ConcernSelectView.this.hxG.getVisibility() == 0 ? 1 : 0);
            }
        });
        this.hxE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new an("c12774").bS("obj_locate", "2"));
                am.setViewTextColor(ConcernSelectView.this.hxE, (int) R.color.cp_cont_b);
                am.setViewTextColor(ConcernSelectView.this.hxF, (int) R.color.cp_cont_j);
                ConcernSelectView.this.hxD.setText(R.string.all_concerned);
                if (ConcernSelectView.this.hxK != null) {
                    ConcernSelectView.this.hxK.rG(0);
                }
                ConcernSelectView.this.t(ConcernSelectView.this.hxG, 1);
            }
        });
        this.hxF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new an("c12774").bS("obj_locate", "3"));
                am.setViewTextColor(ConcernSelectView.this.hxE, (int) R.color.cp_cont_j);
                am.setViewTextColor(ConcernSelectView.this.hxF, (int) R.color.cp_cont_b);
                ConcernSelectView.this.hxD.setText(R.string.each_concerned);
                if (ConcernSelectView.this.hxK != null) {
                    ConcernSelectView.this.hxK.rG(1);
                }
                ConcernSelectView.this.t(ConcernSelectView.this.hxG, 1);
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void bNf() {
        if (!(this.hxG.getVisibility() == 0)) {
            t(this.hxG, 0);
        }
    }

    public void bNg() {
        if (this.hxG.getVisibility() == 0) {
            t(this.hxG, 1);
        }
    }

    public boolean bNh() {
        return this.hxG.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            SvgManager.amL().a(this.hxC, R.drawable.icon_pure_list_arrow12_down_n_svg, R.color.cp_cont_d, null);
            am.setViewTextColor(this.hxD, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.hxE, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.hxF, (int) R.color.cp_cont_j);
            am.setBackgroundResource(this.hxG, R.drawable.concern_item_bg);
            am.setBackgroundResource(this.hxD, R.color.cp_bg_line_d);
            am.setBackgroundResource(this.hxE, R.drawable.concern_item_menu_select_bg);
            am.setBackgroundResource(this.hxF, R.drawable.concern_item_menu_select_bg);
            am.setBackgroundResource(this.ddZ, R.color.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(final View view, final int i) {
        if (view != null && view.getAnimation() == null && this.hxG != null) {
            int childCount = this.hxG.getChildCount();
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
                    if (ConcernSelectView.this.hxK != null) {
                        ConcernSelectView.this.hxK.np(z);
                    }
                }
            });
            view.startAnimation(aVar);
            if (this.hxC != null) {
                if (this.hxC.getAnimation() == null || this.hxC.getAnimation().hasEnded()) {
                    if (i == 0) {
                        if (this.hxH == null) {
                            bNj();
                        }
                        if (this.hxI != null) {
                            this.hxI.cancel();
                        }
                        this.hxC.startAnimation(this.hxH);
                        return;
                    }
                    if (this.hxI == null) {
                        bNi();
                    }
                    if (this.hxH != null) {
                        this.hxH.cancel();
                    }
                    this.hxC.startAnimation(this.hxI);
                }
            }
        }
    }

    private void bNi() {
        this.hxI = AnimationUtils.loadAnimation(this.mContext, R.anim.rotate_collapse);
        this.hxI.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                ConcernSelectView.this.hxJ = false;
            }
        });
    }

    private void bNj() {
        this.hxH = AnimationUtils.loadAnimation(this.mContext, R.anim.rotate_expand);
        this.hxH.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ConcernSelectView.this.hxJ = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void setOnExpandListener(a aVar) {
        this.hxK = aVar;
    }
}

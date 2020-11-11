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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
/* loaded from: classes23.dex */
public class ConcernSelectView extends FrameLayout {
    private View fQl;
    private LinearLayout kYE;
    private ImageView kYF;
    private TextView kYG;
    private TextView kYH;
    private TextView kYI;
    public LinearLayout kYJ;
    private Animation kYK;
    private Animation kYL;
    private boolean kYM;
    private a kYN;
    private Context mContext;
    private int mSkinType;

    /* loaded from: classes23.dex */
    public interface a {
        void Aj(int i);

        void tm(boolean z);
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
        this.kYE = (LinearLayout) findViewById(R.id.expandable_area);
        this.kYF = (ImageView) findViewById(R.id.expandable_btn);
        this.kYJ = (LinearLayout) findViewById(R.id.menu_list);
        this.kYG = (TextView) findViewById(R.id.menu_title);
        this.kYH = (TextView) findViewById(R.id.all_concerned_item);
        this.kYI = (TextView) findViewById(R.id.each_concerned_item);
        this.fQl = findViewById(R.id.item_divider_line);
        this.kYE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new aq("c12774").dR("obj_locate", "1"));
                ConcernSelectView.this.w(ConcernSelectView.this.kYJ, ConcernSelectView.this.kYJ.getVisibility() == 0 ? 1 : 0);
            }
        });
        this.kYH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new aq("c12774").dR("obj_locate", "2"));
                ap.setViewTextColor(ConcernSelectView.this.kYH, R.color.cp_cont_b);
                ap.setViewTextColor(ConcernSelectView.this.kYI, R.color.cp_cont_j);
                ConcernSelectView.this.kYG.setText(R.string.all_concerned);
                if (ConcernSelectView.this.kYN != null) {
                    ConcernSelectView.this.kYN.Aj(0);
                }
                ConcernSelectView.this.w(ConcernSelectView.this.kYJ, 1);
            }
        });
        this.kYI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new aq("c12774").dR("obj_locate", "3"));
                ap.setViewTextColor(ConcernSelectView.this.kYH, R.color.cp_cont_j);
                ap.setViewTextColor(ConcernSelectView.this.kYI, R.color.cp_cont_b);
                ConcernSelectView.this.kYG.setText(R.string.each_concerned);
                if (ConcernSelectView.this.kYN != null) {
                    ConcernSelectView.this.kYN.Aj(1);
                }
                ConcernSelectView.this.w(ConcernSelectView.this.kYJ, 1);
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void closeView() {
        if (this.kYJ.getVisibility() == 0) {
            w(this.kYJ, 1);
        }
    }

    public boolean dew() {
        return this.kYJ.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            SvgManager.brn().a(this.kYF, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
            ap.setViewTextColor(this.kYG, R.color.cp_cont_d);
            ap.setViewTextColor(this.kYH, R.color.cp_cont_b);
            ap.setViewTextColor(this.kYI, R.color.cp_cont_j);
            ap.setBackgroundResource(this.kYJ, R.drawable.concern_item_bg);
            ap.setBackgroundResource(this.kYG, R.color.cp_bg_line_d);
            ap.setBackgroundResource(this.kYH, R.drawable.concern_item_menu_select_bg);
            ap.setBackgroundResource(this.kYI, R.drawable.concern_item_menu_select_bg);
            ap.setBackgroundResource(this.fQl, R.color.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(final View view, final int i) {
        if (view != null && view.getAnimation() == null && this.kYJ != null) {
            int childCount = this.kYJ.getChildCount();
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
                    if (ConcernSelectView.this.kYN != null) {
                        ConcernSelectView.this.kYN.tm(z);
                    }
                }
            });
            view.startAnimation(aVar);
            if (this.kYF != null) {
                if (this.kYF.getAnimation() == null || this.kYF.getAnimation().hasEnded()) {
                    if (i == 0) {
                        if (this.kYK == null) {
                            dey();
                        }
                        if (this.kYL != null) {
                            this.kYL.cancel();
                        }
                        this.kYF.startAnimation(this.kYK);
                        return;
                    }
                    if (this.kYL == null) {
                        dex();
                    }
                    if (this.kYK != null) {
                        this.kYK.cancel();
                    }
                    this.kYF.startAnimation(this.kYL);
                }
            }
        }
    }

    private void dex() {
        this.kYL = AnimationUtils.loadAnimation(this.mContext, R.anim.rotate_collapse);
        this.kYL.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                ConcernSelectView.this.kYM = false;
            }
        });
    }

    private void dey() {
        this.kYK = AnimationUtils.loadAnimation(this.mContext, R.anim.rotate_expand);
        this.kYK.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ConcernSelectView.this.kYM = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void setOnExpandListener(a aVar) {
        this.kYN = aVar;
    }
}

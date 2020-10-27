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
    private View fKv;
    private LinearLayout kSI;
    private ImageView kSJ;
    private TextView kSK;
    private TextView kSL;
    private TextView kSM;
    public LinearLayout kSN;
    private Animation kSO;
    private Animation kSP;
    private boolean kSQ;
    private a kSR;
    private Context mContext;
    private int mSkinType;

    /* loaded from: classes23.dex */
    public interface a {
        void td(boolean z);

        void zW(int i);
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
        this.kSI = (LinearLayout) findViewById(R.id.expandable_area);
        this.kSJ = (ImageView) findViewById(R.id.expandable_btn);
        this.kSN = (LinearLayout) findViewById(R.id.menu_list);
        this.kSK = (TextView) findViewById(R.id.menu_title);
        this.kSL = (TextView) findViewById(R.id.all_concerned_item);
        this.kSM = (TextView) findViewById(R.id.each_concerned_item);
        this.fKv = findViewById(R.id.item_divider_line);
        this.kSI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new aq("c12774").dR("obj_locate", "1"));
                ConcernSelectView.this.w(ConcernSelectView.this.kSN, ConcernSelectView.this.kSN.getVisibility() == 0 ? 1 : 0);
            }
        });
        this.kSL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new aq("c12774").dR("obj_locate", "2"));
                ap.setViewTextColor(ConcernSelectView.this.kSL, R.color.cp_cont_b);
                ap.setViewTextColor(ConcernSelectView.this.kSM, R.color.cp_cont_j);
                ConcernSelectView.this.kSK.setText(R.string.all_concerned);
                if (ConcernSelectView.this.kSR != null) {
                    ConcernSelectView.this.kSR.zW(0);
                }
                ConcernSelectView.this.w(ConcernSelectView.this.kSN, 1);
            }
        });
        this.kSM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new aq("c12774").dR("obj_locate", "3"));
                ap.setViewTextColor(ConcernSelectView.this.kSL, R.color.cp_cont_j);
                ap.setViewTextColor(ConcernSelectView.this.kSM, R.color.cp_cont_b);
                ConcernSelectView.this.kSK.setText(R.string.each_concerned);
                if (ConcernSelectView.this.kSR != null) {
                    ConcernSelectView.this.kSR.zW(1);
                }
                ConcernSelectView.this.w(ConcernSelectView.this.kSN, 1);
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void closeView() {
        if (this.kSN.getVisibility() == 0) {
            w(this.kSN, 1);
        }
    }

    public boolean dbU() {
        return this.kSN.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            SvgManager.boN().a(this.kSJ, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
            ap.setViewTextColor(this.kSK, R.color.cp_cont_d);
            ap.setViewTextColor(this.kSL, R.color.cp_cont_b);
            ap.setViewTextColor(this.kSM, R.color.cp_cont_j);
            ap.setBackgroundResource(this.kSN, R.drawable.concern_item_bg);
            ap.setBackgroundResource(this.kSK, R.color.cp_bg_line_d);
            ap.setBackgroundResource(this.kSL, R.drawable.concern_item_menu_select_bg);
            ap.setBackgroundResource(this.kSM, R.drawable.concern_item_menu_select_bg);
            ap.setBackgroundResource(this.fKv, R.color.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(final View view, final int i) {
        if (view != null && view.getAnimation() == null && this.kSN != null) {
            int childCount = this.kSN.getChildCount();
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
                    if (ConcernSelectView.this.kSR != null) {
                        ConcernSelectView.this.kSR.td(z);
                    }
                }
            });
            view.startAnimation(aVar);
            if (this.kSJ != null) {
                if (this.kSJ.getAnimation() == null || this.kSJ.getAnimation().hasEnded()) {
                    if (i == 0) {
                        if (this.kSO == null) {
                            dbW();
                        }
                        if (this.kSP != null) {
                            this.kSP.cancel();
                        }
                        this.kSJ.startAnimation(this.kSO);
                        return;
                    }
                    if (this.kSP == null) {
                        dbV();
                    }
                    if (this.kSO != null) {
                        this.kSO.cancel();
                    }
                    this.kSJ.startAnimation(this.kSP);
                }
            }
        }
    }

    private void dbV() {
        this.kSP = AnimationUtils.loadAnimation(this.mContext, R.anim.rotate_collapse);
        this.kSP.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                ConcernSelectView.this.kSQ = false;
            }
        });
    }

    private void dbW() {
        this.kSO = AnimationUtils.loadAnimation(this.mContext, R.anim.rotate_expand);
        this.kSO.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ConcernSelectView.this.kSQ = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void setOnExpandListener(a aVar) {
        this.kSR = aVar;
    }
}

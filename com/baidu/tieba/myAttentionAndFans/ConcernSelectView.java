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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class ConcernSelectView extends FrameLayout {
    private View eVD;
    private TextView jKA;
    private TextView jKB;
    public LinearLayout jKC;
    private Animation jKD;
    private Animation jKE;
    private boolean jKF;
    private a jKG;
    private LinearLayout jKx;
    private ImageView jKy;
    private TextView jKz;
    private Context mContext;
    private int mSkinType;

    /* loaded from: classes10.dex */
    public interface a {
        void qK(boolean z);

        void vN(int i);
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
        this.jKx = (LinearLayout) findViewById(R.id.expandable_area);
        this.jKy = (ImageView) findViewById(R.id.expandable_btn);
        this.jKC = (LinearLayout) findViewById(R.id.menu_list);
        this.jKz = (TextView) findViewById(R.id.menu_title);
        this.jKA = (TextView) findViewById(R.id.all_concerned_item);
        this.jKB = (TextView) findViewById(R.id.each_concerned_item);
        this.eVD = findViewById(R.id.item_divider_line);
        this.jKx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new ao("c12774").dk("obj_locate", "1"));
                ConcernSelectView.this.s(ConcernSelectView.this.jKC, ConcernSelectView.this.jKC.getVisibility() == 0 ? 1 : 0);
            }
        });
        this.jKA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new ao("c12774").dk("obj_locate", "2"));
                an.setViewTextColor(ConcernSelectView.this.jKA, (int) R.color.cp_cont_b);
                an.setViewTextColor(ConcernSelectView.this.jKB, (int) R.color.cp_cont_j);
                ConcernSelectView.this.jKz.setText(R.string.all_concerned);
                if (ConcernSelectView.this.jKG != null) {
                    ConcernSelectView.this.jKG.vN(0);
                }
                ConcernSelectView.this.s(ConcernSelectView.this.jKC, 1);
            }
        });
        this.jKB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new ao("c12774").dk("obj_locate", "3"));
                an.setViewTextColor(ConcernSelectView.this.jKA, (int) R.color.cp_cont_j);
                an.setViewTextColor(ConcernSelectView.this.jKB, (int) R.color.cp_cont_b);
                ConcernSelectView.this.jKz.setText(R.string.each_concerned);
                if (ConcernSelectView.this.jKG != null) {
                    ConcernSelectView.this.jKG.vN(1);
                }
                ConcernSelectView.this.s(ConcernSelectView.this.jKC, 1);
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void closeView() {
        if (this.jKC.getVisibility() == 0) {
            s(this.jKC, 1);
        }
    }

    public boolean cCY() {
        return this.jKC.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            SvgManager.aWQ().a(this.jKy, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
            an.setViewTextColor(this.jKz, (int) R.color.cp_cont_d);
            an.setViewTextColor(this.jKA, (int) R.color.cp_cont_b);
            an.setViewTextColor(this.jKB, (int) R.color.cp_cont_j);
            an.setBackgroundResource(this.jKC, R.drawable.concern_item_bg);
            an.setBackgroundResource(this.jKz, R.color.cp_bg_line_d);
            an.setBackgroundResource(this.jKA, R.drawable.concern_item_menu_select_bg);
            an.setBackgroundResource(this.jKB, R.drawable.concern_item_menu_select_bg);
            an.setBackgroundResource(this.eVD, R.color.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(final View view, final int i) {
        if (view != null && view.getAnimation() == null && this.jKC != null) {
            int childCount = this.jKC.getChildCount();
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
                    if (ConcernSelectView.this.jKG != null) {
                        ConcernSelectView.this.jKG.qK(z);
                    }
                }
            });
            view.startAnimation(aVar);
            if (this.jKy != null) {
                if (this.jKy.getAnimation() == null || this.jKy.getAnimation().hasEnded()) {
                    if (i == 0) {
                        if (this.jKD == null) {
                            cDa();
                        }
                        if (this.jKE != null) {
                            this.jKE.cancel();
                        }
                        this.jKy.startAnimation(this.jKD);
                        return;
                    }
                    if (this.jKE == null) {
                        cCZ();
                    }
                    if (this.jKD != null) {
                        this.jKD.cancel();
                    }
                    this.jKy.startAnimation(this.jKE);
                }
            }
        }
    }

    private void cCZ() {
        this.jKE = AnimationUtils.loadAnimation(this.mContext, R.anim.rotate_collapse);
        this.jKE.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                ConcernSelectView.this.jKF = false;
            }
        });
    }

    private void cDa() {
        this.jKD = AnimationUtils.loadAnimation(this.mContext, R.anim.rotate_expand);
        this.jKD.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ConcernSelectView.this.jKF = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void setOnExpandListener(a aVar) {
        this.jKG = aVar;
    }
}

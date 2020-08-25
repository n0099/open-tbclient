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
/* loaded from: classes17.dex */
public class ConcernSelectView extends FrameLayout {
    private View fmE;
    private Animation kiA;
    private boolean kiB;
    private a kiC;
    private LinearLayout kit;
    private ImageView kiu;
    private TextView kiv;
    private TextView kiw;
    private TextView kix;
    public LinearLayout kiy;
    private Animation kiz;
    private Context mContext;
    private int mSkinType;

    /* loaded from: classes17.dex */
    public interface a {
        void rV(boolean z);

        void yy(int i);
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
        this.kit = (LinearLayout) findViewById(R.id.expandable_area);
        this.kiu = (ImageView) findViewById(R.id.expandable_btn);
        this.kiy = (LinearLayout) findViewById(R.id.menu_list);
        this.kiv = (TextView) findViewById(R.id.menu_title);
        this.kiw = (TextView) findViewById(R.id.all_concerned_item);
        this.kix = (TextView) findViewById(R.id.each_concerned_item);
        this.fmE = findViewById(R.id.item_divider_line);
        this.kit.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new aq("c12774").dD("obj_locate", "1"));
                ConcernSelectView.this.t(ConcernSelectView.this.kiy, ConcernSelectView.this.kiy.getVisibility() == 0 ? 1 : 0);
            }
        });
        this.kiw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new aq("c12774").dD("obj_locate", "2"));
                ap.setViewTextColor(ConcernSelectView.this.kiw, R.color.cp_cont_b);
                ap.setViewTextColor(ConcernSelectView.this.kix, R.color.cp_cont_j);
                ConcernSelectView.this.kiv.setText(R.string.all_concerned);
                if (ConcernSelectView.this.kiC != null) {
                    ConcernSelectView.this.kiC.yy(0);
                }
                ConcernSelectView.this.t(ConcernSelectView.this.kiy, 1);
            }
        });
        this.kix.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new aq("c12774").dD("obj_locate", "3"));
                ap.setViewTextColor(ConcernSelectView.this.kiw, R.color.cp_cont_j);
                ap.setViewTextColor(ConcernSelectView.this.kix, R.color.cp_cont_b);
                ConcernSelectView.this.kiv.setText(R.string.each_concerned);
                if (ConcernSelectView.this.kiC != null) {
                    ConcernSelectView.this.kiC.yy(1);
                }
                ConcernSelectView.this.t(ConcernSelectView.this.kiy, 1);
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void closeView() {
        if (this.kiy.getVisibility() == 0) {
            t(this.kiy, 1);
        }
    }

    public boolean cRw() {
        return this.kiy.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            SvgManager.bjq().a(this.kiu, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
            ap.setViewTextColor(this.kiv, R.color.cp_cont_d);
            ap.setViewTextColor(this.kiw, R.color.cp_cont_b);
            ap.setViewTextColor(this.kix, R.color.cp_cont_j);
            ap.setBackgroundResource(this.kiy, R.drawable.concern_item_bg);
            ap.setBackgroundResource(this.kiv, R.color.cp_bg_line_d);
            ap.setBackgroundResource(this.kiw, R.drawable.concern_item_menu_select_bg);
            ap.setBackgroundResource(this.kix, R.drawable.concern_item_menu_select_bg);
            ap.setBackgroundResource(this.fmE, R.color.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(final View view, final int i) {
        if (view != null && view.getAnimation() == null && this.kiy != null) {
            int childCount = this.kiy.getChildCount();
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
                    if (ConcernSelectView.this.kiC != null) {
                        ConcernSelectView.this.kiC.rV(z);
                    }
                }
            });
            view.startAnimation(aVar);
            if (this.kiu != null) {
                if (this.kiu.getAnimation() == null || this.kiu.getAnimation().hasEnded()) {
                    if (i == 0) {
                        if (this.kiz == null) {
                            cRy();
                        }
                        if (this.kiA != null) {
                            this.kiA.cancel();
                        }
                        this.kiu.startAnimation(this.kiz);
                        return;
                    }
                    if (this.kiA == null) {
                        cRx();
                    }
                    if (this.kiz != null) {
                        this.kiz.cancel();
                    }
                    this.kiu.startAnimation(this.kiA);
                }
            }
        }
    }

    private void cRx() {
        this.kiA = AnimationUtils.loadAnimation(this.mContext, R.anim.rotate_collapse);
        this.kiA.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                ConcernSelectView.this.kiB = false;
            }
        });
    }

    private void cRy() {
        this.kiz = AnimationUtils.loadAnimation(this.mContext, R.anim.rotate_expand);
        this.kiz.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ConcernSelectView.this.kiB = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void setOnExpandListener(a aVar) {
        this.kiC = aVar;
    }
}

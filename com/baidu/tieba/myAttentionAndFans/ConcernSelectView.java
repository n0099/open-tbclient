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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class ConcernSelectView extends FrameLayout {
    private View ghb;
    private ImageView lxA;
    private TextView lxB;
    private TextView lxC;
    private TextView lxD;
    public LinearLayout lxE;
    private Animation lxF;
    private Animation lxG;
    private boolean lxH;
    private a lxI;
    private LinearLayout lxz;
    private Context mContext;
    private int mSkinType;

    /* loaded from: classes7.dex */
    public interface a {
        void Am(int i);

        void ub(boolean z);
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
        this.lxz = (LinearLayout) findViewById(R.id.expandable_area);
        this.lxA = (ImageView) findViewById(R.id.expandable_btn);
        this.lxE = (LinearLayout) findViewById(R.id.menu_list);
        this.lxB = (TextView) findViewById(R.id.menu_title);
        this.lxC = (TextView) findViewById(R.id.all_concerned_item);
        this.lxD = (TextView) findViewById(R.id.each_concerned_item);
        this.ghb = findViewById(R.id.item_divider_line);
        this.lxz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new ar("c12774").dR("obj_locate", "1"));
                ConcernSelectView.this.B(ConcernSelectView.this.lxE, ConcernSelectView.this.lxE.getVisibility() == 0 ? 1 : 0);
            }
        });
        this.lxC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new ar("c12774").dR("obj_locate", "2"));
                ap.setViewTextColor(ConcernSelectView.this.lxC, R.color.CAM_X0105);
                ap.setViewTextColor(ConcernSelectView.this.lxD, R.color.CAM_X0107);
                ConcernSelectView.this.lxB.setText(R.string.all_concerned);
                if (ConcernSelectView.this.lxI != null) {
                    ConcernSelectView.this.lxI.Am(0);
                }
                ConcernSelectView.this.B(ConcernSelectView.this.lxE, 1);
            }
        });
        this.lxD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new ar("c12774").dR("obj_locate", "3"));
                ap.setViewTextColor(ConcernSelectView.this.lxC, R.color.CAM_X0107);
                ap.setViewTextColor(ConcernSelectView.this.lxD, R.color.CAM_X0105);
                ConcernSelectView.this.lxB.setText(R.string.each_concerned);
                if (ConcernSelectView.this.lxI != null) {
                    ConcernSelectView.this.lxI.Am(1);
                }
                ConcernSelectView.this.B(ConcernSelectView.this.lxE, 1);
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void dhr() {
        if (this.lxE.getVisibility() == 0) {
            B(this.lxE, 1);
        }
    }

    public boolean dhs() {
        return this.lxE.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            SvgManager.bsU().a(this.lxA, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0109, (SvgManager.SvgResourceStateType) null);
            ap.setViewTextColor(this.lxB, R.color.CAM_X0109);
            ap.setViewTextColor(this.lxC, R.color.CAM_X0105);
            ap.setViewTextColor(this.lxD, R.color.CAM_X0107);
            ap.setBackgroundResource(this.lxE, R.drawable.concern_item_bg);
            ap.setBackgroundResource(this.lxB, R.color.CAM_X0201);
            ap.setBackgroundResource(this.lxC, R.drawable.concern_item_menu_select_bg);
            ap.setBackgroundResource(this.lxD, R.drawable.concern_item_menu_select_bg);
            ap.setBackgroundResource(this.ghb, R.color.CAM_X0204);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(final View view, final int i) {
        if (view != null && view.getAnimation() == null && this.lxE != null) {
            int childCount = this.lxE.getChildCount();
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
                    if (ConcernSelectView.this.lxI != null) {
                        ConcernSelectView.this.lxI.ub(z);
                    }
                }
            });
            view.startAnimation(aVar);
            if (this.lxA != null) {
                if (this.lxA.getAnimation() == null || this.lxA.getAnimation().hasEnded()) {
                    if (i == 0) {
                        if (this.lxF == null) {
                            dhu();
                        }
                        if (this.lxG != null) {
                            this.lxG.cancel();
                        }
                        this.lxA.startAnimation(this.lxF);
                        return;
                    }
                    if (this.lxG == null) {
                        dht();
                    }
                    if (this.lxF != null) {
                        this.lxF.cancel();
                    }
                    this.lxA.startAnimation(this.lxG);
                }
            }
        }
    }

    private void dht() {
        this.lxG = AnimationUtils.loadAnimation(this.mContext, R.anim.rotate_collapse);
        this.lxG.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                ConcernSelectView.this.lxH = false;
            }
        });
    }

    private void dhu() {
        this.lxF = AnimationUtils.loadAnimation(this.mContext, R.anim.rotate_expand);
        this.lxF.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ConcernSelectView.this.lxH = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void setOnExpandListener(a aVar) {
        this.lxI = aVar;
    }
}

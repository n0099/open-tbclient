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
/* loaded from: classes22.dex */
public class ConcernSelectView extends FrameLayout {
    private View fpN;
    private LinearLayout kqZ;
    private ImageView kra;
    private TextView krb;
    private TextView krc;
    private TextView krd;
    public LinearLayout kre;
    private Animation krf;
    private Animation krg;
    private boolean krh;
    private a kri;
    private Context mContext;
    private int mSkinType;

    /* loaded from: classes22.dex */
    public interface a {
        void sf(boolean z);

        void yX(int i);
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
        this.kqZ = (LinearLayout) findViewById(R.id.expandable_area);
        this.kra = (ImageView) findViewById(R.id.expandable_btn);
        this.kre = (LinearLayout) findViewById(R.id.menu_list);
        this.krb = (TextView) findViewById(R.id.menu_title);
        this.krc = (TextView) findViewById(R.id.all_concerned_item);
        this.krd = (TextView) findViewById(R.id.each_concerned_item);
        this.fpN = findViewById(R.id.item_divider_line);
        this.kqZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new aq("c12774").dF("obj_locate", "1"));
                ConcernSelectView.this.u(ConcernSelectView.this.kre, ConcernSelectView.this.kre.getVisibility() == 0 ? 1 : 0);
            }
        });
        this.krc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new aq("c12774").dF("obj_locate", "2"));
                ap.setViewTextColor(ConcernSelectView.this.krc, R.color.cp_cont_b);
                ap.setViewTextColor(ConcernSelectView.this.krd, R.color.cp_cont_j);
                ConcernSelectView.this.krb.setText(R.string.all_concerned);
                if (ConcernSelectView.this.kri != null) {
                    ConcernSelectView.this.kri.yX(0);
                }
                ConcernSelectView.this.u(ConcernSelectView.this.kre, 1);
            }
        });
        this.krd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new aq("c12774").dF("obj_locate", "3"));
                ap.setViewTextColor(ConcernSelectView.this.krc, R.color.cp_cont_j);
                ap.setViewTextColor(ConcernSelectView.this.krd, R.color.cp_cont_b);
                ConcernSelectView.this.krb.setText(R.string.each_concerned);
                if (ConcernSelectView.this.kri != null) {
                    ConcernSelectView.this.kri.yX(1);
                }
                ConcernSelectView.this.u(ConcernSelectView.this.kre, 1);
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void closeView() {
        if (this.kre.getVisibility() == 0) {
            u(this.kre, 1);
        }
    }

    public boolean cVd() {
        return this.kre.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            SvgManager.bkl().a(this.kra, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
            ap.setViewTextColor(this.krb, R.color.cp_cont_d);
            ap.setViewTextColor(this.krc, R.color.cp_cont_b);
            ap.setViewTextColor(this.krd, R.color.cp_cont_j);
            ap.setBackgroundResource(this.kre, R.drawable.concern_item_bg);
            ap.setBackgroundResource(this.krb, R.color.cp_bg_line_d);
            ap.setBackgroundResource(this.krc, R.drawable.concern_item_menu_select_bg);
            ap.setBackgroundResource(this.krd, R.drawable.concern_item_menu_select_bg);
            ap.setBackgroundResource(this.fpN, R.color.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(final View view, final int i) {
        if (view != null && view.getAnimation() == null && this.kre != null) {
            int childCount = this.kre.getChildCount();
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
                    if (ConcernSelectView.this.kri != null) {
                        ConcernSelectView.this.kri.sf(z);
                    }
                }
            });
            view.startAnimation(aVar);
            if (this.kra != null) {
                if (this.kra.getAnimation() == null || this.kra.getAnimation().hasEnded()) {
                    if (i == 0) {
                        if (this.krf == null) {
                            cVf();
                        }
                        if (this.krg != null) {
                            this.krg.cancel();
                        }
                        this.kra.startAnimation(this.krf);
                        return;
                    }
                    if (this.krg == null) {
                        cVe();
                    }
                    if (this.krf != null) {
                        this.krf.cancel();
                    }
                    this.kra.startAnimation(this.krg);
                }
            }
        }
    }

    private void cVe() {
        this.krg = AnimationUtils.loadAnimation(this.mContext, R.anim.rotate_collapse);
        this.krg.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                ConcernSelectView.this.krh = false;
            }
        });
    }

    private void cVf() {
        this.krf = AnimationUtils.loadAnimation(this.mContext, R.anim.rotate_expand);
        this.krf.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ConcernSelectView.this.krh = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void setOnExpandListener(a aVar) {
        this.kri = aVar;
    }
}

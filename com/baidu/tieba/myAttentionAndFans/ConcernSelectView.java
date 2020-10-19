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
    private View fCa;
    private LinearLayout kGl;
    private ImageView kGm;
    private TextView kGn;
    private TextView kGo;
    private TextView kGp;
    public LinearLayout kGq;
    private Animation kGr;
    private Animation kGs;
    private boolean kGt;
    private a kGu;
    private Context mContext;
    private int mSkinType;

    /* loaded from: classes23.dex */
    public interface a {
        void sM(boolean z);

        void zD(int i);
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
        this.kGl = (LinearLayout) findViewById(R.id.expandable_area);
        this.kGm = (ImageView) findViewById(R.id.expandable_btn);
        this.kGq = (LinearLayout) findViewById(R.id.menu_list);
        this.kGn = (TextView) findViewById(R.id.menu_title);
        this.kGo = (TextView) findViewById(R.id.all_concerned_item);
        this.kGp = (TextView) findViewById(R.id.each_concerned_item);
        this.fCa = findViewById(R.id.item_divider_line);
        this.kGl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new aq("c12774").dK("obj_locate", "1"));
                ConcernSelectView.this.v(ConcernSelectView.this.kGq, ConcernSelectView.this.kGq.getVisibility() == 0 ? 1 : 0);
            }
        });
        this.kGo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new aq("c12774").dK("obj_locate", "2"));
                ap.setViewTextColor(ConcernSelectView.this.kGo, R.color.cp_cont_b);
                ap.setViewTextColor(ConcernSelectView.this.kGp, R.color.cp_cont_j);
                ConcernSelectView.this.kGn.setText(R.string.all_concerned);
                if (ConcernSelectView.this.kGu != null) {
                    ConcernSelectView.this.kGu.zD(0);
                }
                ConcernSelectView.this.v(ConcernSelectView.this.kGq, 1);
            }
        });
        this.kGp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new aq("c12774").dK("obj_locate", "3"));
                ap.setViewTextColor(ConcernSelectView.this.kGo, R.color.cp_cont_j);
                ap.setViewTextColor(ConcernSelectView.this.kGp, R.color.cp_cont_b);
                ConcernSelectView.this.kGn.setText(R.string.each_concerned);
                if (ConcernSelectView.this.kGu != null) {
                    ConcernSelectView.this.kGu.zD(1);
                }
                ConcernSelectView.this.v(ConcernSelectView.this.kGq, 1);
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void closeView() {
        if (this.kGq.getVisibility() == 0) {
            v(this.kGq, 1);
        }
    }

    public boolean cYM() {
        return this.kGq.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            SvgManager.bmU().a(this.kGm, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
            ap.setViewTextColor(this.kGn, R.color.cp_cont_d);
            ap.setViewTextColor(this.kGo, R.color.cp_cont_b);
            ap.setViewTextColor(this.kGp, R.color.cp_cont_j);
            ap.setBackgroundResource(this.kGq, R.drawable.concern_item_bg);
            ap.setBackgroundResource(this.kGn, R.color.cp_bg_line_d);
            ap.setBackgroundResource(this.kGo, R.drawable.concern_item_menu_select_bg);
            ap.setBackgroundResource(this.kGp, R.drawable.concern_item_menu_select_bg);
            ap.setBackgroundResource(this.fCa, R.color.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(final View view, final int i) {
        if (view != null && view.getAnimation() == null && this.kGq != null) {
            int childCount = this.kGq.getChildCount();
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
                    if (ConcernSelectView.this.kGu != null) {
                        ConcernSelectView.this.kGu.sM(z);
                    }
                }
            });
            view.startAnimation(aVar);
            if (this.kGm != null) {
                if (this.kGm.getAnimation() == null || this.kGm.getAnimation().hasEnded()) {
                    if (i == 0) {
                        if (this.kGr == null) {
                            cYO();
                        }
                        if (this.kGs != null) {
                            this.kGs.cancel();
                        }
                        this.kGm.startAnimation(this.kGr);
                        return;
                    }
                    if (this.kGs == null) {
                        cYN();
                    }
                    if (this.kGr != null) {
                        this.kGr.cancel();
                    }
                    this.kGm.startAnimation(this.kGs);
                }
            }
        }
    }

    private void cYN() {
        this.kGs = AnimationUtils.loadAnimation(this.mContext, R.anim.rotate_collapse);
        this.kGs.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                ConcernSelectView.this.kGt = false;
            }
        });
    }

    private void cYO() {
        this.kGr = AnimationUtils.loadAnimation(this.mContext, R.anim.rotate_expand);
        this.kGr.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ConcernSelectView.this.kGt = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void setOnExpandListener(a aVar) {
        this.kGu = aVar;
    }
}

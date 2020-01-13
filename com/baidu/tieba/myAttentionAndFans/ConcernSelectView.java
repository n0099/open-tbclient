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
/* loaded from: classes8.dex */
public class ConcernSelectView extends FrameLayout {
    private View caf;
    private LinearLayout ipf;
    private ImageView ipg;
    private TextView iph;
    private TextView ipi;
    private TextView ipj;
    public LinearLayout ipk;
    private Animation ipl;
    private Animation ipm;
    private boolean ipn;
    private a ipo;
    private Context mContext;
    private int mSkinType;

    /* loaded from: classes8.dex */
    public interface a {
        void oQ(boolean z);

        void tR(int i);
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
        this.ipf = (LinearLayout) findViewById(R.id.expandable_area);
        this.ipg = (ImageView) findViewById(R.id.expandable_btn);
        this.ipk = (LinearLayout) findViewById(R.id.menu_list);
        this.iph = (TextView) findViewById(R.id.menu_title);
        this.ipi = (TextView) findViewById(R.id.all_concerned_item);
        this.ipj = (TextView) findViewById(R.id.each_concerned_item);
        this.caf = findViewById(R.id.item_divider_line);
        this.ipf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new an("c12774").cp("obj_locate", "1"));
                ConcernSelectView.this.r(ConcernSelectView.this.ipk, ConcernSelectView.this.ipk.getVisibility() == 0 ? 1 : 0);
            }
        });
        this.ipi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new an("c12774").cp("obj_locate", "2"));
                am.setViewTextColor(ConcernSelectView.this.ipi, (int) R.color.cp_cont_b);
                am.setViewTextColor(ConcernSelectView.this.ipj, (int) R.color.cp_cont_j);
                ConcernSelectView.this.iph.setText(R.string.all_concerned);
                if (ConcernSelectView.this.ipo != null) {
                    ConcernSelectView.this.ipo.tR(0);
                }
                ConcernSelectView.this.r(ConcernSelectView.this.ipk, 1);
            }
        });
        this.ipj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new an("c12774").cp("obj_locate", "3"));
                am.setViewTextColor(ConcernSelectView.this.ipi, (int) R.color.cp_cont_j);
                am.setViewTextColor(ConcernSelectView.this.ipj, (int) R.color.cp_cont_b);
                ConcernSelectView.this.iph.setText(R.string.each_concerned);
                if (ConcernSelectView.this.ipo != null) {
                    ConcernSelectView.this.ipo.tR(1);
                }
                ConcernSelectView.this.r(ConcernSelectView.this.ipk, 1);
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void cfA() {
        if (!(this.ipk.getVisibility() == 0)) {
            r(this.ipk, 0);
        }
    }

    public void closeView() {
        if (this.ipk.getVisibility() == 0) {
            r(this.ipk, 1);
        }
    }

    public boolean cfB() {
        return this.ipk.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            SvgManager.aEp().a(this.ipg, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
            am.setViewTextColor(this.iph, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.ipi, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.ipj, (int) R.color.cp_cont_j);
            am.setBackgroundResource(this.ipk, R.drawable.concern_item_bg);
            am.setBackgroundResource(this.iph, R.color.cp_bg_line_d);
            am.setBackgroundResource(this.ipi, R.drawable.concern_item_menu_select_bg);
            am.setBackgroundResource(this.ipj, R.drawable.concern_item_menu_select_bg);
            am.setBackgroundResource(this.caf, R.color.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(final View view, final int i) {
        if (view != null && view.getAnimation() == null && this.ipk != null) {
            int childCount = this.ipk.getChildCount();
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
                    if (ConcernSelectView.this.ipo != null) {
                        ConcernSelectView.this.ipo.oQ(z);
                    }
                }
            });
            view.startAnimation(aVar);
            if (this.ipg != null) {
                if (this.ipg.getAnimation() == null || this.ipg.getAnimation().hasEnded()) {
                    if (i == 0) {
                        if (this.ipl == null) {
                            cfD();
                        }
                        if (this.ipm != null) {
                            this.ipm.cancel();
                        }
                        this.ipg.startAnimation(this.ipl);
                        return;
                    }
                    if (this.ipm == null) {
                        cfC();
                    }
                    if (this.ipl != null) {
                        this.ipl.cancel();
                    }
                    this.ipg.startAnimation(this.ipm);
                }
            }
        }
    }

    private void cfC() {
        this.ipm = AnimationUtils.loadAnimation(this.mContext, R.anim.rotate_collapse);
        this.ipm.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                ConcernSelectView.this.ipn = false;
            }
        });
    }

    private void cfD() {
        this.ipl = AnimationUtils.loadAnimation(this.mContext, R.anim.rotate_expand);
        this.ipl.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ConcernSelectView.this.ipn = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void setOnExpandListener(a aVar) {
        this.ipo = aVar;
    }
}

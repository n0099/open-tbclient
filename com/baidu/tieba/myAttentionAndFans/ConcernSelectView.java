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
/* loaded from: classes10.dex */
public class ConcernSelectView extends FrameLayout {
    private View cem;
    private LinearLayout irc;
    private ImageView ird;
    private TextView ire;
    private TextView irf;
    private TextView irg;
    public LinearLayout irh;
    private Animation iri;
    private Animation irj;
    private boolean irk;
    private a irl;
    private Context mContext;
    private int mSkinType;

    /* loaded from: classes10.dex */
    public interface a {
        void oT(boolean z);

        void tX(int i);
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
        this.irc = (LinearLayout) findViewById(R.id.expandable_area);
        this.ird = (ImageView) findViewById(R.id.expandable_btn);
        this.irh = (LinearLayout) findViewById(R.id.menu_list);
        this.ire = (TextView) findViewById(R.id.menu_title);
        this.irf = (TextView) findViewById(R.id.all_concerned_item);
        this.irg = (TextView) findViewById(R.id.each_concerned_item);
        this.cem = findViewById(R.id.item_divider_line);
        this.irc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new an("c12774").cy("obj_locate", "1"));
                ConcernSelectView.this.r(ConcernSelectView.this.irh, ConcernSelectView.this.irh.getVisibility() == 0 ? 1 : 0);
            }
        });
        this.irf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new an("c12774").cy("obj_locate", "2"));
                am.setViewTextColor(ConcernSelectView.this.irf, (int) R.color.cp_cont_b);
                am.setViewTextColor(ConcernSelectView.this.irg, (int) R.color.cp_cont_j);
                ConcernSelectView.this.ire.setText(R.string.all_concerned);
                if (ConcernSelectView.this.irl != null) {
                    ConcernSelectView.this.irl.tX(0);
                }
                ConcernSelectView.this.r(ConcernSelectView.this.irh, 1);
            }
        });
        this.irg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new an("c12774").cy("obj_locate", "3"));
                am.setViewTextColor(ConcernSelectView.this.irf, (int) R.color.cp_cont_j);
                am.setViewTextColor(ConcernSelectView.this.irg, (int) R.color.cp_cont_b);
                ConcernSelectView.this.ire.setText(R.string.each_concerned);
                if (ConcernSelectView.this.irl != null) {
                    ConcernSelectView.this.irl.tX(1);
                }
                ConcernSelectView.this.r(ConcernSelectView.this.irh, 1);
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void chh() {
        if (!(this.irh.getVisibility() == 0)) {
            r(this.irh, 0);
        }
    }

    public void closeView() {
        if (this.irh.getVisibility() == 0) {
            r(this.irh, 1);
        }
    }

    public boolean chi() {
        return this.irh.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            SvgManager.aGC().a(this.ird, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
            am.setViewTextColor(this.ire, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.irf, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.irg, (int) R.color.cp_cont_j);
            am.setBackgroundResource(this.irh, R.drawable.concern_item_bg);
            am.setBackgroundResource(this.ire, R.color.cp_bg_line_d);
            am.setBackgroundResource(this.irf, R.drawable.concern_item_menu_select_bg);
            am.setBackgroundResource(this.irg, R.drawable.concern_item_menu_select_bg);
            am.setBackgroundResource(this.cem, R.color.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(final View view, final int i) {
        if (view != null && view.getAnimation() == null && this.irh != null) {
            int childCount = this.irh.getChildCount();
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
                    if (ConcernSelectView.this.irl != null) {
                        ConcernSelectView.this.irl.oT(z);
                    }
                }
            });
            view.startAnimation(aVar);
            if (this.ird != null) {
                if (this.ird.getAnimation() == null || this.ird.getAnimation().hasEnded()) {
                    if (i == 0) {
                        if (this.iri == null) {
                            chk();
                        }
                        if (this.irj != null) {
                            this.irj.cancel();
                        }
                        this.ird.startAnimation(this.iri);
                        return;
                    }
                    if (this.irj == null) {
                        chj();
                    }
                    if (this.iri != null) {
                        this.iri.cancel();
                    }
                    this.ird.startAnimation(this.irj);
                }
            }
        }
    }

    private void chj() {
        this.irj = AnimationUtils.loadAnimation(this.mContext, R.anim.rotate_collapse);
        this.irj.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                ConcernSelectView.this.irk = false;
            }
        });
    }

    private void chk() {
        this.iri = AnimationUtils.loadAnimation(this.mContext, R.anim.rotate_expand);
        this.iri.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ConcernSelectView.this.irk = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void setOnExpandListener(a aVar) {
        this.irl = aVar;
    }
}

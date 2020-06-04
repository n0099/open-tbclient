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
    private View eLr;
    private LinearLayout jtg;
    private ImageView jth;
    private TextView jti;
    private TextView jtj;
    private TextView jtk;
    public LinearLayout jtl;
    private Animation jtm;
    private Animation jtn;
    private boolean jto;
    private a jtp;
    private Context mContext;
    private int mSkinType;

    /* loaded from: classes10.dex */
    public interface a {
        void qA(boolean z);

        void vi(int i);
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
        this.jtg = (LinearLayout) findViewById(R.id.expandable_area);
        this.jth = (ImageView) findViewById(R.id.expandable_btn);
        this.jtl = (LinearLayout) findViewById(R.id.menu_list);
        this.jti = (TextView) findViewById(R.id.menu_title);
        this.jtj = (TextView) findViewById(R.id.all_concerned_item);
        this.jtk = (TextView) findViewById(R.id.each_concerned_item);
        this.eLr = findViewById(R.id.item_divider_line);
        this.jtg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new an("c12774").dh("obj_locate", "1"));
                ConcernSelectView.this.s(ConcernSelectView.this.jtl, ConcernSelectView.this.jtl.getVisibility() == 0 ? 1 : 0);
            }
        });
        this.jtj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new an("c12774").dh("obj_locate", "2"));
                am.setViewTextColor(ConcernSelectView.this.jtj, (int) R.color.cp_cont_b);
                am.setViewTextColor(ConcernSelectView.this.jtk, (int) R.color.cp_cont_j);
                ConcernSelectView.this.jti.setText(R.string.all_concerned);
                if (ConcernSelectView.this.jtp != null) {
                    ConcernSelectView.this.jtp.vi(0);
                }
                ConcernSelectView.this.s(ConcernSelectView.this.jtl, 1);
            }
        });
        this.jtk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new an("c12774").dh("obj_locate", "3"));
                am.setViewTextColor(ConcernSelectView.this.jtj, (int) R.color.cp_cont_j);
                am.setViewTextColor(ConcernSelectView.this.jtk, (int) R.color.cp_cont_b);
                ConcernSelectView.this.jti.setText(R.string.each_concerned);
                if (ConcernSelectView.this.jtp != null) {
                    ConcernSelectView.this.jtp.vi(1);
                }
                ConcernSelectView.this.s(ConcernSelectView.this.jtl, 1);
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void closeView() {
        if (this.jtl.getVisibility() == 0) {
            s(this.jtl, 1);
        }
    }

    public boolean czb() {
        return this.jtl.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            SvgManager.aUW().a(this.jth, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
            am.setViewTextColor(this.jti, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.jtj, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.jtk, (int) R.color.cp_cont_j);
            am.setBackgroundResource(this.jtl, R.drawable.concern_item_bg);
            am.setBackgroundResource(this.jti, R.color.cp_bg_line_d);
            am.setBackgroundResource(this.jtj, R.drawable.concern_item_menu_select_bg);
            am.setBackgroundResource(this.jtk, R.drawable.concern_item_menu_select_bg);
            am.setBackgroundResource(this.eLr, R.color.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(final View view, final int i) {
        if (view != null && view.getAnimation() == null && this.jtl != null) {
            int childCount = this.jtl.getChildCount();
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
                    if (ConcernSelectView.this.jtp != null) {
                        ConcernSelectView.this.jtp.qA(z);
                    }
                }
            });
            view.startAnimation(aVar);
            if (this.jth != null) {
                if (this.jth.getAnimation() == null || this.jth.getAnimation().hasEnded()) {
                    if (i == 0) {
                        if (this.jtm == null) {
                            czd();
                        }
                        if (this.jtn != null) {
                            this.jtn.cancel();
                        }
                        this.jth.startAnimation(this.jtm);
                        return;
                    }
                    if (this.jtn == null) {
                        czc();
                    }
                    if (this.jtm != null) {
                        this.jtm.cancel();
                    }
                    this.jth.startAnimation(this.jtn);
                }
            }
        }
    }

    private void czc() {
        this.jtn = AnimationUtils.loadAnimation(this.mContext, R.anim.rotate_collapse);
        this.jtn.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                ConcernSelectView.this.jto = false;
            }
        });
    }

    private void czd() {
        this.jtm = AnimationUtils.loadAnimation(this.mContext, R.anim.rotate_expand);
        this.jtm.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ConcernSelectView.this.jto = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void setOnExpandListener(a aVar) {
        this.jtp = aVar;
    }
}

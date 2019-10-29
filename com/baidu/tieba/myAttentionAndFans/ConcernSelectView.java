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
/* loaded from: classes5.dex */
public class ConcernSelectView extends FrameLayout {
    private View deR;
    private boolean hyA;
    private a hyB;
    private LinearLayout hys;
    private ImageView hyt;
    private TextView hyu;
    private TextView hyv;
    private TextView hyw;
    public LinearLayout hyx;
    private Animation hyy;
    private Animation hyz;
    private Context mContext;
    private int mSkinType;

    /* loaded from: classes5.dex */
    public interface a {
        void np(boolean z);

        void rH(int i);
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
        this.hys = (LinearLayout) findViewById(R.id.expandable_area);
        this.hyt = (ImageView) findViewById(R.id.expandable_btn);
        this.hyx = (LinearLayout) findViewById(R.id.menu_list);
        this.hyu = (TextView) findViewById(R.id.menu_title);
        this.hyv = (TextView) findViewById(R.id.all_concerned_item);
        this.hyw = (TextView) findViewById(R.id.each_concerned_item);
        this.deR = findViewById(R.id.item_divider_line);
        this.hys.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new an("c12774").bS("obj_locate", "1"));
                ConcernSelectView.this.t(ConcernSelectView.this.hyx, ConcernSelectView.this.hyx.getVisibility() == 0 ? 1 : 0);
            }
        });
        this.hyv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new an("c12774").bS("obj_locate", "2"));
                am.setViewTextColor(ConcernSelectView.this.hyv, (int) R.color.cp_cont_b);
                am.setViewTextColor(ConcernSelectView.this.hyw, (int) R.color.cp_cont_j);
                ConcernSelectView.this.hyu.setText(R.string.all_concerned);
                if (ConcernSelectView.this.hyB != null) {
                    ConcernSelectView.this.hyB.rH(0);
                }
                ConcernSelectView.this.t(ConcernSelectView.this.hyx, 1);
            }
        });
        this.hyw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new an("c12774").bS("obj_locate", "3"));
                am.setViewTextColor(ConcernSelectView.this.hyv, (int) R.color.cp_cont_j);
                am.setViewTextColor(ConcernSelectView.this.hyw, (int) R.color.cp_cont_b);
                ConcernSelectView.this.hyu.setText(R.string.each_concerned);
                if (ConcernSelectView.this.hyB != null) {
                    ConcernSelectView.this.hyB.rH(1);
                }
                ConcernSelectView.this.t(ConcernSelectView.this.hyx, 1);
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void bNh() {
        if (!(this.hyx.getVisibility() == 0)) {
            t(this.hyx, 0);
        }
    }

    public void bNi() {
        if (this.hyx.getVisibility() == 0) {
            t(this.hyx, 1);
        }
    }

    public boolean bNj() {
        return this.hyx.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            SvgManager.amN().a(this.hyt, R.drawable.icon_pure_list_arrow12_down_n_svg, R.color.cp_cont_d, null);
            am.setViewTextColor(this.hyu, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.hyv, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.hyw, (int) R.color.cp_cont_j);
            am.setBackgroundResource(this.hyx, R.drawable.concern_item_bg);
            am.setBackgroundResource(this.hyu, R.color.cp_bg_line_d);
            am.setBackgroundResource(this.hyv, R.drawable.concern_item_menu_select_bg);
            am.setBackgroundResource(this.hyw, R.drawable.concern_item_menu_select_bg);
            am.setBackgroundResource(this.deR, R.color.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(final View view, final int i) {
        if (view != null && view.getAnimation() == null && this.hyx != null) {
            int childCount = this.hyx.getChildCount();
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
                    if (ConcernSelectView.this.hyB != null) {
                        ConcernSelectView.this.hyB.np(z);
                    }
                }
            });
            view.startAnimation(aVar);
            if (this.hyt != null) {
                if (this.hyt.getAnimation() == null || this.hyt.getAnimation().hasEnded()) {
                    if (i == 0) {
                        if (this.hyy == null) {
                            bNl();
                        }
                        if (this.hyz != null) {
                            this.hyz.cancel();
                        }
                        this.hyt.startAnimation(this.hyy);
                        return;
                    }
                    if (this.hyz == null) {
                        bNk();
                    }
                    if (this.hyy != null) {
                        this.hyy.cancel();
                    }
                    this.hyt.startAnimation(this.hyz);
                }
            }
        }
    }

    private void bNk() {
        this.hyz = AnimationUtils.loadAnimation(this.mContext, R.anim.rotate_collapse);
        this.hyz.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                ConcernSelectView.this.hyA = false;
            }
        });
    }

    private void bNl() {
        this.hyy = AnimationUtils.loadAnimation(this.mContext, R.anim.rotate_expand);
        this.hyy.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ConcernSelectView.this.hyA = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void setOnExpandListener(a aVar) {
        this.hyB = aVar;
    }
}

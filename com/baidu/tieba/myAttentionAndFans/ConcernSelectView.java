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
    private View eLg;
    private LinearLayout jsa;
    private ImageView jsb;
    private TextView jsc;
    private TextView jsd;
    private TextView jse;
    public LinearLayout jsf;
    private Animation jsg;
    private Animation jsh;
    private boolean jsi;
    private a jsj;
    private Context mContext;
    private int mSkinType;

    /* loaded from: classes10.dex */
    public interface a {
        void qA(boolean z);

        void vg(int i);
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
        this.jsa = (LinearLayout) findViewById(R.id.expandable_area);
        this.jsb = (ImageView) findViewById(R.id.expandable_btn);
        this.jsf = (LinearLayout) findViewById(R.id.menu_list);
        this.jsc = (TextView) findViewById(R.id.menu_title);
        this.jsd = (TextView) findViewById(R.id.all_concerned_item);
        this.jse = (TextView) findViewById(R.id.each_concerned_item);
        this.eLg = findViewById(R.id.item_divider_line);
        this.jsa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new an("c12774").dh("obj_locate", "1"));
                ConcernSelectView.this.s(ConcernSelectView.this.jsf, ConcernSelectView.this.jsf.getVisibility() == 0 ? 1 : 0);
            }
        });
        this.jsd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new an("c12774").dh("obj_locate", "2"));
                am.setViewTextColor(ConcernSelectView.this.jsd, (int) R.color.cp_cont_b);
                am.setViewTextColor(ConcernSelectView.this.jse, (int) R.color.cp_cont_j);
                ConcernSelectView.this.jsc.setText(R.string.all_concerned);
                if (ConcernSelectView.this.jsj != null) {
                    ConcernSelectView.this.jsj.vg(0);
                }
                ConcernSelectView.this.s(ConcernSelectView.this.jsf, 1);
            }
        });
        this.jse.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new an("c12774").dh("obj_locate", "3"));
                am.setViewTextColor(ConcernSelectView.this.jsd, (int) R.color.cp_cont_j);
                am.setViewTextColor(ConcernSelectView.this.jse, (int) R.color.cp_cont_b);
                ConcernSelectView.this.jsc.setText(R.string.each_concerned);
                if (ConcernSelectView.this.jsj != null) {
                    ConcernSelectView.this.jsj.vg(1);
                }
                ConcernSelectView.this.s(ConcernSelectView.this.jsf, 1);
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void closeView() {
        if (this.jsf.getVisibility() == 0) {
            s(this.jsf, 1);
        }
    }

    public boolean cyK() {
        return this.jsf.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            SvgManager.aUV().a(this.jsb, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
            am.setViewTextColor(this.jsc, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.jsd, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.jse, (int) R.color.cp_cont_j);
            am.setBackgroundResource(this.jsf, R.drawable.concern_item_bg);
            am.setBackgroundResource(this.jsc, R.color.cp_bg_line_d);
            am.setBackgroundResource(this.jsd, R.drawable.concern_item_menu_select_bg);
            am.setBackgroundResource(this.jse, R.drawable.concern_item_menu_select_bg);
            am.setBackgroundResource(this.eLg, R.color.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(final View view, final int i) {
        if (view != null && view.getAnimation() == null && this.jsf != null) {
            int childCount = this.jsf.getChildCount();
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
                    if (ConcernSelectView.this.jsj != null) {
                        ConcernSelectView.this.jsj.qA(z);
                    }
                }
            });
            view.startAnimation(aVar);
            if (this.jsb != null) {
                if (this.jsb.getAnimation() == null || this.jsb.getAnimation().hasEnded()) {
                    if (i == 0) {
                        if (this.jsg == null) {
                            cyM();
                        }
                        if (this.jsh != null) {
                            this.jsh.cancel();
                        }
                        this.jsb.startAnimation(this.jsg);
                        return;
                    }
                    if (this.jsh == null) {
                        cyL();
                    }
                    if (this.jsg != null) {
                        this.jsg.cancel();
                    }
                    this.jsb.startAnimation(this.jsh);
                }
            }
        }
    }

    private void cyL() {
        this.jsh = AnimationUtils.loadAnimation(this.mContext, R.anim.rotate_collapse);
        this.jsh.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                ConcernSelectView.this.jsi = false;
            }
        });
    }

    private void cyM() {
        this.jsg = AnimationUtils.loadAnimation(this.mContext, R.anim.rotate_expand);
        this.jsg.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ConcernSelectView.this.jsi = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void setOnExpandListener(a aVar) {
        this.jsj = aVar;
    }
}

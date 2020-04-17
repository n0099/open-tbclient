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
    private View cDw;
    private LinearLayout jcT;
    private ImageView jcU;
    private TextView jcV;
    private TextView jcW;
    private TextView jcX;
    public LinearLayout jcY;
    private Animation jcZ;
    private Animation jda;
    private boolean jdb;
    private a jdc;
    private Context mContext;
    private int mSkinType;

    /* loaded from: classes10.dex */
    public interface a {
        void qd(boolean z);

        void uA(int i);
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
        this.jcT = (LinearLayout) findViewById(R.id.expandable_area);
        this.jcU = (ImageView) findViewById(R.id.expandable_btn);
        this.jcY = (LinearLayout) findViewById(R.id.menu_list);
        this.jcV = (TextView) findViewById(R.id.menu_title);
        this.jcW = (TextView) findViewById(R.id.all_concerned_item);
        this.jcX = (TextView) findViewById(R.id.each_concerned_item);
        this.cDw = findViewById(R.id.item_divider_line);
        this.jcT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new an("c12774").cI("obj_locate", "1"));
                ConcernSelectView.this.s(ConcernSelectView.this.jcY, ConcernSelectView.this.jcY.getVisibility() == 0 ? 1 : 0);
            }
        });
        this.jcW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new an("c12774").cI("obj_locate", "2"));
                am.setViewTextColor(ConcernSelectView.this.jcW, (int) R.color.cp_cont_b);
                am.setViewTextColor(ConcernSelectView.this.jcX, (int) R.color.cp_cont_j);
                ConcernSelectView.this.jcV.setText(R.string.all_concerned);
                if (ConcernSelectView.this.jdc != null) {
                    ConcernSelectView.this.jdc.uA(0);
                }
                ConcernSelectView.this.s(ConcernSelectView.this.jcY, 1);
            }
        });
        this.jcX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new an("c12774").cI("obj_locate", "3"));
                am.setViewTextColor(ConcernSelectView.this.jcW, (int) R.color.cp_cont_j);
                am.setViewTextColor(ConcernSelectView.this.jcX, (int) R.color.cp_cont_b);
                ConcernSelectView.this.jcV.setText(R.string.each_concerned);
                if (ConcernSelectView.this.jdc != null) {
                    ConcernSelectView.this.jdc.uA(1);
                }
                ConcernSelectView.this.s(ConcernSelectView.this.jcY, 1);
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void csj() {
        if (!(this.jcY.getVisibility() == 0)) {
            s(this.jcY, 0);
        }
    }

    public void closeView() {
        if (this.jcY.getVisibility() == 0) {
            s(this.jcY, 1);
        }
    }

    public boolean csk() {
        return this.jcY.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            SvgManager.aOU().a(this.jcU, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
            am.setViewTextColor(this.jcV, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.jcW, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.jcX, (int) R.color.cp_cont_j);
            am.setBackgroundResource(this.jcY, R.drawable.concern_item_bg);
            am.setBackgroundResource(this.jcV, R.color.cp_bg_line_d);
            am.setBackgroundResource(this.jcW, R.drawable.concern_item_menu_select_bg);
            am.setBackgroundResource(this.jcX, R.drawable.concern_item_menu_select_bg);
            am.setBackgroundResource(this.cDw, R.color.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(final View view, final int i) {
        if (view != null && view.getAnimation() == null && this.jcY != null) {
            int childCount = this.jcY.getChildCount();
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
                    if (ConcernSelectView.this.jdc != null) {
                        ConcernSelectView.this.jdc.qd(z);
                    }
                }
            });
            view.startAnimation(aVar);
            if (this.jcU != null) {
                if (this.jcU.getAnimation() == null || this.jcU.getAnimation().hasEnded()) {
                    if (i == 0) {
                        if (this.jcZ == null) {
                            csm();
                        }
                        if (this.jda != null) {
                            this.jda.cancel();
                        }
                        this.jcU.startAnimation(this.jcZ);
                        return;
                    }
                    if (this.jda == null) {
                        csl();
                    }
                    if (this.jcZ != null) {
                        this.jcZ.cancel();
                    }
                    this.jcU.startAnimation(this.jda);
                }
            }
        }
    }

    private void csl() {
        this.jda = AnimationUtils.loadAnimation(this.mContext, R.anim.rotate_collapse);
        this.jda.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                ConcernSelectView.this.jdb = false;
            }
        });
    }

    private void csm() {
        this.jcZ = AnimationUtils.loadAnimation(this.mContext, R.anim.rotate_expand);
        this.jcZ.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ConcernSelectView.this.jdb = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void setOnExpandListener(a aVar) {
        this.jdc = aVar;
    }
}

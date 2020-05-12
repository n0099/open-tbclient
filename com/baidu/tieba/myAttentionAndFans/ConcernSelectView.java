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
    private View cDC;
    private LinearLayout jcX;
    private ImageView jcY;
    private TextView jcZ;
    private TextView jda;
    private TextView jdb;
    public LinearLayout jdc;
    private Animation jdd;
    private Animation jde;
    private boolean jdf;
    private a jdg;
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
        this.jcX = (LinearLayout) findViewById(R.id.expandable_area);
        this.jcY = (ImageView) findViewById(R.id.expandable_btn);
        this.jdc = (LinearLayout) findViewById(R.id.menu_list);
        this.jcZ = (TextView) findViewById(R.id.menu_title);
        this.jda = (TextView) findViewById(R.id.all_concerned_item);
        this.jdb = (TextView) findViewById(R.id.each_concerned_item);
        this.cDC = findViewById(R.id.item_divider_line);
        this.jcX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new an("c12774").cI("obj_locate", "1"));
                ConcernSelectView.this.s(ConcernSelectView.this.jdc, ConcernSelectView.this.jdc.getVisibility() == 0 ? 1 : 0);
            }
        });
        this.jda.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new an("c12774").cI("obj_locate", "2"));
                am.setViewTextColor(ConcernSelectView.this.jda, (int) R.color.cp_cont_b);
                am.setViewTextColor(ConcernSelectView.this.jdb, (int) R.color.cp_cont_j);
                ConcernSelectView.this.jcZ.setText(R.string.all_concerned);
                if (ConcernSelectView.this.jdg != null) {
                    ConcernSelectView.this.jdg.uA(0);
                }
                ConcernSelectView.this.s(ConcernSelectView.this.jdc, 1);
            }
        });
        this.jdb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new an("c12774").cI("obj_locate", "3"));
                am.setViewTextColor(ConcernSelectView.this.jda, (int) R.color.cp_cont_j);
                am.setViewTextColor(ConcernSelectView.this.jdb, (int) R.color.cp_cont_b);
                ConcernSelectView.this.jcZ.setText(R.string.each_concerned);
                if (ConcernSelectView.this.jdg != null) {
                    ConcernSelectView.this.jdg.uA(1);
                }
                ConcernSelectView.this.s(ConcernSelectView.this.jdc, 1);
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void csh() {
        if (!(this.jdc.getVisibility() == 0)) {
            s(this.jdc, 0);
        }
    }

    public void closeView() {
        if (this.jdc.getVisibility() == 0) {
            s(this.jdc, 1);
        }
    }

    public boolean csi() {
        return this.jdc.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            SvgManager.aOR().a(this.jcY, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
            am.setViewTextColor(this.jcZ, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.jda, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.jdb, (int) R.color.cp_cont_j);
            am.setBackgroundResource(this.jdc, R.drawable.concern_item_bg);
            am.setBackgroundResource(this.jcZ, R.color.cp_bg_line_d);
            am.setBackgroundResource(this.jda, R.drawable.concern_item_menu_select_bg);
            am.setBackgroundResource(this.jdb, R.drawable.concern_item_menu_select_bg);
            am.setBackgroundResource(this.cDC, R.color.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(final View view, final int i) {
        if (view != null && view.getAnimation() == null && this.jdc != null) {
            int childCount = this.jdc.getChildCount();
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
                    if (ConcernSelectView.this.jdg != null) {
                        ConcernSelectView.this.jdg.qd(z);
                    }
                }
            });
            view.startAnimation(aVar);
            if (this.jcY != null) {
                if (this.jcY.getAnimation() == null || this.jcY.getAnimation().hasEnded()) {
                    if (i == 0) {
                        if (this.jdd == null) {
                            csk();
                        }
                        if (this.jde != null) {
                            this.jde.cancel();
                        }
                        this.jcY.startAnimation(this.jdd);
                        return;
                    }
                    if (this.jde == null) {
                        csj();
                    }
                    if (this.jdd != null) {
                        this.jdd.cancel();
                    }
                    this.jcY.startAnimation(this.jde);
                }
            }
        }
    }

    private void csj() {
        this.jde = AnimationUtils.loadAnimation(this.mContext, R.anim.rotate_collapse);
        this.jde.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                ConcernSelectView.this.jdf = false;
            }
        });
    }

    private void csk() {
        this.jdd = AnimationUtils.loadAnimation(this.mContext, R.anim.rotate_expand);
        this.jdd.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ConcernSelectView.this.jdf = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void setOnExpandListener(a aVar) {
        this.jdg = aVar;
    }
}

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
    private View cen;
    private LinearLayout iro;
    private ImageView irp;
    private TextView irq;
    private TextView irr;
    private TextView irs;
    public LinearLayout irt;
    private Animation iru;
    private Animation irv;
    private boolean irw;
    private a irx;
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
        this.iro = (LinearLayout) findViewById(R.id.expandable_area);
        this.irp = (ImageView) findViewById(R.id.expandable_btn);
        this.irt = (LinearLayout) findViewById(R.id.menu_list);
        this.irq = (TextView) findViewById(R.id.menu_title);
        this.irr = (TextView) findViewById(R.id.all_concerned_item);
        this.irs = (TextView) findViewById(R.id.each_concerned_item);
        this.cen = findViewById(R.id.item_divider_line);
        this.iro.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new an("c12774").cy("obj_locate", "1"));
                ConcernSelectView.this.r(ConcernSelectView.this.irt, ConcernSelectView.this.irt.getVisibility() == 0 ? 1 : 0);
            }
        });
        this.irr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new an("c12774").cy("obj_locate", "2"));
                am.setViewTextColor(ConcernSelectView.this.irr, (int) R.color.cp_cont_b);
                am.setViewTextColor(ConcernSelectView.this.irs, (int) R.color.cp_cont_j);
                ConcernSelectView.this.irq.setText(R.string.all_concerned);
                if (ConcernSelectView.this.irx != null) {
                    ConcernSelectView.this.irx.tX(0);
                }
                ConcernSelectView.this.r(ConcernSelectView.this.irt, 1);
            }
        });
        this.irs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new an("c12774").cy("obj_locate", "3"));
                am.setViewTextColor(ConcernSelectView.this.irr, (int) R.color.cp_cont_j);
                am.setViewTextColor(ConcernSelectView.this.irs, (int) R.color.cp_cont_b);
                ConcernSelectView.this.irq.setText(R.string.each_concerned);
                if (ConcernSelectView.this.irx != null) {
                    ConcernSelectView.this.irx.tX(1);
                }
                ConcernSelectView.this.r(ConcernSelectView.this.irt, 1);
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void chi() {
        if (!(this.irt.getVisibility() == 0)) {
            r(this.irt, 0);
        }
    }

    public void closeView() {
        if (this.irt.getVisibility() == 0) {
            r(this.irt, 1);
        }
    }

    public boolean chj() {
        return this.irt.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            SvgManager.aGC().a(this.irp, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
            am.setViewTextColor(this.irq, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.irr, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.irs, (int) R.color.cp_cont_j);
            am.setBackgroundResource(this.irt, R.drawable.concern_item_bg);
            am.setBackgroundResource(this.irq, R.color.cp_bg_line_d);
            am.setBackgroundResource(this.irr, R.drawable.concern_item_menu_select_bg);
            am.setBackgroundResource(this.irs, R.drawable.concern_item_menu_select_bg);
            am.setBackgroundResource(this.cen, R.color.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(final View view, final int i) {
        if (view != null && view.getAnimation() == null && this.irt != null) {
            int childCount = this.irt.getChildCount();
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
                    if (ConcernSelectView.this.irx != null) {
                        ConcernSelectView.this.irx.oT(z);
                    }
                }
            });
            view.startAnimation(aVar);
            if (this.irp != null) {
                if (this.irp.getAnimation() == null || this.irp.getAnimation().hasEnded()) {
                    if (i == 0) {
                        if (this.iru == null) {
                            chl();
                        }
                        if (this.irv != null) {
                            this.irv.cancel();
                        }
                        this.irp.startAnimation(this.iru);
                        return;
                    }
                    if (this.irv == null) {
                        chk();
                    }
                    if (this.iru != null) {
                        this.iru.cancel();
                    }
                    this.irp.startAnimation(this.irv);
                }
            }
        }
    }

    private void chk() {
        this.irv = AnimationUtils.loadAnimation(this.mContext, R.anim.rotate_collapse);
        this.irv.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                ConcernSelectView.this.irw = false;
            }
        });
    }

    private void chl() {
        this.iru = AnimationUtils.loadAnimation(this.mContext, R.anim.rotate_expand);
        this.iru.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ConcernSelectView.this.irw = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void setOnExpandListener(a aVar) {
        this.irx = aVar;
    }
}

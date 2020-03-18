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
    private View cey;
    private LinearLayout isO;
    private ImageView isP;
    private TextView isQ;
    private TextView isR;
    private TextView isS;
    public LinearLayout isT;
    private Animation isU;
    private Animation isV;
    private boolean isW;
    private a isX;
    private Context mContext;
    private int mSkinType;

    /* loaded from: classes10.dex */
    public interface a {
        void oZ(boolean z);

        void ud(int i);
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
        this.isO = (LinearLayout) findViewById(R.id.expandable_area);
        this.isP = (ImageView) findViewById(R.id.expandable_btn);
        this.isT = (LinearLayout) findViewById(R.id.menu_list);
        this.isQ = (TextView) findViewById(R.id.menu_title);
        this.isR = (TextView) findViewById(R.id.all_concerned_item);
        this.isS = (TextView) findViewById(R.id.each_concerned_item);
        this.cey = findViewById(R.id.item_divider_line);
        this.isO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new an("c12774").cx("obj_locate", "1"));
                ConcernSelectView.this.r(ConcernSelectView.this.isT, ConcernSelectView.this.isT.getVisibility() == 0 ? 1 : 0);
            }
        });
        this.isR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new an("c12774").cx("obj_locate", "2"));
                am.setViewTextColor(ConcernSelectView.this.isR, (int) R.color.cp_cont_b);
                am.setViewTextColor(ConcernSelectView.this.isS, (int) R.color.cp_cont_j);
                ConcernSelectView.this.isQ.setText(R.string.all_concerned);
                if (ConcernSelectView.this.isX != null) {
                    ConcernSelectView.this.isX.ud(0);
                }
                ConcernSelectView.this.r(ConcernSelectView.this.isT, 1);
            }
        });
        this.isS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new an("c12774").cx("obj_locate", "3"));
                am.setViewTextColor(ConcernSelectView.this.isR, (int) R.color.cp_cont_j);
                am.setViewTextColor(ConcernSelectView.this.isS, (int) R.color.cp_cont_b);
                ConcernSelectView.this.isQ.setText(R.string.each_concerned);
                if (ConcernSelectView.this.isX != null) {
                    ConcernSelectView.this.isX.ud(1);
                }
                ConcernSelectView.this.r(ConcernSelectView.this.isT, 1);
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void chC() {
        if (!(this.isT.getVisibility() == 0)) {
            r(this.isT, 0);
        }
    }

    public void closeView() {
        if (this.isT.getVisibility() == 0) {
            r(this.isT, 1);
        }
    }

    public boolean chD() {
        return this.isT.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            SvgManager.aGG().a(this.isP, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
            am.setViewTextColor(this.isQ, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.isR, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.isS, (int) R.color.cp_cont_j);
            am.setBackgroundResource(this.isT, R.drawable.concern_item_bg);
            am.setBackgroundResource(this.isQ, R.color.cp_bg_line_d);
            am.setBackgroundResource(this.isR, R.drawable.concern_item_menu_select_bg);
            am.setBackgroundResource(this.isS, R.drawable.concern_item_menu_select_bg);
            am.setBackgroundResource(this.cey, R.color.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(final View view, final int i) {
        if (view != null && view.getAnimation() == null && this.isT != null) {
            int childCount = this.isT.getChildCount();
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
                    if (ConcernSelectView.this.isX != null) {
                        ConcernSelectView.this.isX.oZ(z);
                    }
                }
            });
            view.startAnimation(aVar);
            if (this.isP != null) {
                if (this.isP.getAnimation() == null || this.isP.getAnimation().hasEnded()) {
                    if (i == 0) {
                        if (this.isU == null) {
                            chF();
                        }
                        if (this.isV != null) {
                            this.isV.cancel();
                        }
                        this.isP.startAnimation(this.isU);
                        return;
                    }
                    if (this.isV == null) {
                        chE();
                    }
                    if (this.isU != null) {
                        this.isU.cancel();
                    }
                    this.isP.startAnimation(this.isV);
                }
            }
        }
    }

    private void chE() {
        this.isV = AnimationUtils.loadAnimation(this.mContext, R.anim.rotate_collapse);
        this.isV.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                ConcernSelectView.this.isW = false;
            }
        });
    }

    private void chF() {
        this.isU = AnimationUtils.loadAnimation(this.mContext, R.anim.rotate_expand);
        this.isU.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ConcernSelectView.this.isW = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void setOnExpandListener(a aVar) {
        this.isX = aVar;
    }
}

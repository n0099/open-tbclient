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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class ConcernSelectView extends FrameLayout {
    private View bvs;
    private LinearLayout fyH;
    private ImageView fyI;
    private TextView fyJ;
    private TextView fyK;
    private TextView fyL;
    public LinearLayout fyM;
    private Animation fyN;
    private Animation fyO;
    private boolean fyP;
    private a fyQ;
    private Context mContext;
    private int mSkinType;

    /* loaded from: classes3.dex */
    public interface a {
        void jO(boolean z);

        void mT(int i);
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
        LayoutInflater.from(this.mContext).inflate(e.h.concern_select_layout, this);
        this.fyH = (LinearLayout) findViewById(e.g.expandable_area);
        this.fyI = (ImageView) findViewById(e.g.expandable_btn);
        this.fyM = (LinearLayout) findViewById(e.g.menu_list);
        this.fyJ = (TextView) findViewById(e.g.menu_title);
        this.fyK = (TextView) findViewById(e.g.all_concerned_item);
        this.fyL = (TextView) findViewById(e.g.each_concerned_item);
        this.bvs = findViewById(e.g.item_divider_line);
        this.fyH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new am("c12774").ax("obj_locate", "1"));
                ConcernSelectView.this.x(ConcernSelectView.this.fyM, ConcernSelectView.this.fyM.getVisibility() == 0 ? 1 : 0);
            }
        });
        this.fyK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new am("c12774").ax("obj_locate", "2"));
                al.h(ConcernSelectView.this.fyK, e.d.cp_cont_b);
                al.h(ConcernSelectView.this.fyL, e.d.cp_cont_j);
                ConcernSelectView.this.fyJ.setText(e.j.all_concerned);
                if (ConcernSelectView.this.fyQ != null) {
                    ConcernSelectView.this.fyQ.mT(0);
                }
                ConcernSelectView.this.x(ConcernSelectView.this.fyM, 1);
            }
        });
        this.fyL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new am("c12774").ax("obj_locate", "3"));
                al.h(ConcernSelectView.this.fyK, e.d.cp_cont_j);
                al.h(ConcernSelectView.this.fyL, e.d.cp_cont_b);
                ConcernSelectView.this.fyJ.setText(e.j.each_concerned);
                if (ConcernSelectView.this.fyQ != null) {
                    ConcernSelectView.this.fyQ.mT(1);
                }
                ConcernSelectView.this.x(ConcernSelectView.this.fyM, 1);
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void bbe() {
        if (!(this.fyM.getVisibility() == 0)) {
            x(this.fyM, 0);
        }
    }

    public void bbf() {
        if (this.fyM.getVisibility() == 0) {
            x(this.fyM, 1);
        }
    }

    public boolean bbg() {
        return this.fyM.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.c(this.fyI, e.f.icon_arrow_gray_down);
            al.h(this.fyJ, e.d.cp_cont_d);
            al.h(this.fyK, e.d.cp_cont_b);
            al.h(this.fyL, e.d.cp_cont_j);
            al.i(this.fyM, e.f.bg_user_float_shadow);
            al.i(this.fyJ, e.d.cp_bg_line_d);
            al.i(this.fyK, e.f.concern_item_bg);
            al.i(this.fyL, e.f.concern_item_bg);
            al.i(this.bvs, e.d.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(final View view, final int i) {
        if (view != null && view.getAnimation() == null && this.fyM != null) {
            int childCount = this.fyM.getChildCount();
            if (childCount < 0) {
                childCount = 0;
            }
            com.baidu.tieba.myAttentionAndFans.a aVar = new com.baidu.tieba.myAttentionAndFans.a(view, i, childCount * (((int) this.mContext.getResources().getDimension(e.C0200e.tbds80)) + ((int) this.mContext.getResources().getDimension(e.C0200e.ds1))));
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
                    if (ConcernSelectView.this.fyQ != null) {
                        ConcernSelectView.this.fyQ.jO(z);
                    }
                }
            });
            view.startAnimation(aVar);
            if (this.fyI != null) {
                if (this.fyI.getAnimation() == null || this.fyI.getAnimation().hasEnded()) {
                    if (i == 0) {
                        if (this.fyN == null) {
                            bbi();
                        }
                        if (this.fyO != null) {
                            this.fyO.cancel();
                        }
                        this.fyI.startAnimation(this.fyN);
                        return;
                    }
                    if (this.fyO == null) {
                        bbh();
                    }
                    if (this.fyN != null) {
                        this.fyN.cancel();
                    }
                    this.fyI.startAnimation(this.fyO);
                }
            }
        }
    }

    private void bbh() {
        this.fyO = AnimationUtils.loadAnimation(this.mContext, e.a.rotate_collapse);
        this.fyO.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                ConcernSelectView.this.fyP = false;
            }
        });
    }

    private void bbi() {
        this.fyN = AnimationUtils.loadAnimation(this.mContext, e.a.rotate_expand);
        this.fyN.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ConcernSelectView.this.fyP = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void setOnExpandListener(a aVar) {
        this.fyQ = aVar;
    }
}

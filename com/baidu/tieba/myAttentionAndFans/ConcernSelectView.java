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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class ConcernSelectView extends FrameLayout {
    private View bkJ;
    private LinearLayout fih;
    private ImageView fii;
    private TextView fij;
    private TextView fik;
    private TextView fil;
    public LinearLayout fim;
    private Animation fin;
    private Animation fio;
    private boolean fip;
    private a fiq;
    private Context mContext;
    private int mSkinType;

    /* loaded from: classes3.dex */
    public interface a {
        void iO(boolean z);

        void lB(int i);
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
        LayoutInflater.from(this.mContext).inflate(f.h.concern_select_layout, this);
        this.fih = (LinearLayout) findViewById(f.g.expandable_area);
        this.fii = (ImageView) findViewById(f.g.expandable_btn);
        this.fim = (LinearLayout) findViewById(f.g.menu_list);
        this.fij = (TextView) findViewById(f.g.menu_title);
        this.fik = (TextView) findViewById(f.g.all_concerned_item);
        this.fil = (TextView) findViewById(f.g.each_concerned_item);
        this.bkJ = findViewById(f.g.item_divider_line);
        this.fih.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new an("c12774").ae("obj_locate", "1"));
                ConcernSelectView.this.w(ConcernSelectView.this.fim, ConcernSelectView.this.fim.getVisibility() == 0 ? 1 : 0);
            }
        });
        this.fik.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new an("c12774").ae("obj_locate", "2"));
                am.h(ConcernSelectView.this.fik, f.d.cp_cont_b);
                am.h(ConcernSelectView.this.fil, f.d.cp_cont_j);
                ConcernSelectView.this.fij.setText(f.j.all_concerned);
                if (ConcernSelectView.this.fiq != null) {
                    ConcernSelectView.this.fiq.lB(0);
                }
                ConcernSelectView.this.w(ConcernSelectView.this.fim, 1);
            }
        });
        this.fil.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new an("c12774").ae("obj_locate", "3"));
                am.h(ConcernSelectView.this.fik, f.d.cp_cont_j);
                am.h(ConcernSelectView.this.fil, f.d.cp_cont_b);
                ConcernSelectView.this.fij.setText(f.j.each_concerned);
                if (ConcernSelectView.this.fiq != null) {
                    ConcernSelectView.this.fiq.lB(1);
                }
                ConcernSelectView.this.w(ConcernSelectView.this.fim, 1);
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void aWg() {
        if (!(this.fim.getVisibility() == 0)) {
            w(this.fim, 0);
        }
    }

    public void aWh() {
        if (this.fim.getVisibility() == 0) {
            w(this.fim, 1);
        }
    }

    public boolean aWi() {
        return this.fim.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.c(this.fii, f.C0146f.icon_arrow_gray_down);
            am.h(this.fij, f.d.cp_cont_d);
            am.h(this.fik, f.d.cp_cont_b);
            am.h(this.fil, f.d.cp_cont_j);
            am.i(this.fim, f.C0146f.bg_user_float_shadow);
            am.i(this.fij, f.d.cp_bg_line_d);
            am.i(this.fik, f.C0146f.concern_item_bg);
            am.i(this.fil, f.C0146f.concern_item_bg);
            am.i(this.bkJ, f.d.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(final View view, final int i) {
        if (view != null && view.getAnimation() == null && this.fim != null) {
            int childCount = this.fim.getChildCount();
            if (childCount < 0) {
                childCount = 0;
            }
            com.baidu.tieba.myAttentionAndFans.a aVar = new com.baidu.tieba.myAttentionAndFans.a(view, i, childCount * (((int) this.mContext.getResources().getDimension(f.e.tbds80)) + ((int) this.mContext.getResources().getDimension(f.e.ds1))));
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
                    if (ConcernSelectView.this.fiq != null) {
                        ConcernSelectView.this.fiq.iO(z);
                    }
                }
            });
            view.startAnimation(aVar);
            if (this.fii != null) {
                if (this.fii.getAnimation() == null || this.fii.getAnimation().hasEnded()) {
                    if (i == 0) {
                        if (this.fin == null) {
                            aWk();
                        }
                        if (this.fio != null) {
                            this.fio.cancel();
                        }
                        this.fii.startAnimation(this.fin);
                        return;
                    }
                    if (this.fio == null) {
                        aWj();
                    }
                    if (this.fin != null) {
                        this.fin.cancel();
                    }
                    this.fii.startAnimation(this.fio);
                }
            }
        }
    }

    private void aWj() {
        this.fio = AnimationUtils.loadAnimation(this.mContext, f.a.rotate_collapse);
        this.fio.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                ConcernSelectView.this.fip = false;
            }
        });
    }

    private void aWk() {
        this.fin = AnimationUtils.loadAnimation(this.mContext, f.a.rotate_expand);
        this.fin.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ConcernSelectView.this.fip = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void setOnExpandListener(a aVar) {
        this.fiq = aVar;
    }
}

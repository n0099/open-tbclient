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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class ConcernSelectView extends FrameLayout {
    private View gft;
    private LinearLayout lvj;
    private ImageView lvk;
    private TextView lvl;
    private TextView lvm;
    private TextView lvn;
    public LinearLayout lvo;
    private Animation lvp;
    private Animation lvq;
    private boolean lvr;
    private a lvs;
    private Context mContext;
    private int mSkinType;

    /* loaded from: classes8.dex */
    public interface a {
        void Al(int i);

        void ub(boolean z);
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
        this.lvj = (LinearLayout) findViewById(R.id.expandable_area);
        this.lvk = (ImageView) findViewById(R.id.expandable_btn);
        this.lvo = (LinearLayout) findViewById(R.id.menu_list);
        this.lvl = (TextView) findViewById(R.id.menu_title);
        this.lvm = (TextView) findViewById(R.id.all_concerned_item);
        this.lvn = (TextView) findViewById(R.id.each_concerned_item);
        this.gft = findViewById(R.id.item_divider_line);
        this.lvj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new ar("c12774").dR("obj_locate", "1"));
                ConcernSelectView.this.B(ConcernSelectView.this.lvo, ConcernSelectView.this.lvo.getVisibility() == 0 ? 1 : 0);
            }
        });
        this.lvm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new ar("c12774").dR("obj_locate", "2"));
                ap.setViewTextColor(ConcernSelectView.this.lvm, R.color.CAM_X0105);
                ap.setViewTextColor(ConcernSelectView.this.lvn, R.color.CAM_X0107);
                ConcernSelectView.this.lvl.setText(R.string.all_concerned);
                if (ConcernSelectView.this.lvs != null) {
                    ConcernSelectView.this.lvs.Al(0);
                }
                ConcernSelectView.this.B(ConcernSelectView.this.lvo, 1);
            }
        });
        this.lvn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new ar("c12774").dR("obj_locate", "3"));
                ap.setViewTextColor(ConcernSelectView.this.lvm, R.color.CAM_X0107);
                ap.setViewTextColor(ConcernSelectView.this.lvn, R.color.CAM_X0105);
                ConcernSelectView.this.lvl.setText(R.string.each_concerned);
                if (ConcernSelectView.this.lvs != null) {
                    ConcernSelectView.this.lvs.Al(1);
                }
                ConcernSelectView.this.B(ConcernSelectView.this.lvo, 1);
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void dhb() {
        if (this.lvo.getVisibility() == 0) {
            B(this.lvo, 1);
        }
    }

    public boolean dhc() {
        return this.lvo.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            SvgManager.bsR().a(this.lvk, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0109, (SvgManager.SvgResourceStateType) null);
            ap.setViewTextColor(this.lvl, R.color.CAM_X0109);
            ap.setViewTextColor(this.lvm, R.color.CAM_X0105);
            ap.setViewTextColor(this.lvn, R.color.CAM_X0107);
            ap.setBackgroundResource(this.lvo, R.drawable.concern_item_bg);
            ap.setBackgroundResource(this.lvl, R.color.CAM_X0201);
            ap.setBackgroundResource(this.lvm, R.drawable.concern_item_menu_select_bg);
            ap.setBackgroundResource(this.lvn, R.drawable.concern_item_menu_select_bg);
            ap.setBackgroundResource(this.gft, R.color.CAM_X0204);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(final View view, final int i) {
        if (view != null && view.getAnimation() == null && this.lvo != null) {
            int childCount = this.lvo.getChildCount();
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
                    if (ConcernSelectView.this.lvs != null) {
                        ConcernSelectView.this.lvs.ub(z);
                    }
                }
            });
            view.startAnimation(aVar);
            if (this.lvk != null) {
                if (this.lvk.getAnimation() == null || this.lvk.getAnimation().hasEnded()) {
                    if (i == 0) {
                        if (this.lvp == null) {
                            dhe();
                        }
                        if (this.lvq != null) {
                            this.lvq.cancel();
                        }
                        this.lvk.startAnimation(this.lvp);
                        return;
                    }
                    if (this.lvq == null) {
                        dhd();
                    }
                    if (this.lvp != null) {
                        this.lvp.cancel();
                    }
                    this.lvk.startAnimation(this.lvq);
                }
            }
        }
    }

    private void dhd() {
        this.lvq = AnimationUtils.loadAnimation(this.mContext, R.anim.rotate_collapse);
        this.lvq.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                ConcernSelectView.this.lvr = false;
            }
        });
    }

    private void dhe() {
        this.lvp = AnimationUtils.loadAnimation(this.mContext, R.anim.rotate_expand);
        this.lvp.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ConcernSelectView.this.lvr = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void setOnExpandListener(a aVar) {
        this.lvs = aVar;
    }
}

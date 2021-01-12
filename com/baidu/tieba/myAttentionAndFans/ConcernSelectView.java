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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class ConcernSelectView extends FrameLayout {
    private View gde;
    private LinearLayout lnc;
    private ImageView lnd;
    private TextView lne;
    private TextView lnf;
    private TextView lnh;
    public LinearLayout lni;
    private Animation lnj;
    private Animation lnk;
    private boolean lnl;
    private a lnm;
    private Context mContext;
    private int mSkinType;

    /* loaded from: classes7.dex */
    public interface a {
        void Ab(int i);

        void tO(boolean z);
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
        this.lnc = (LinearLayout) findViewById(R.id.expandable_area);
        this.lnd = (ImageView) findViewById(R.id.expandable_btn);
        this.lni = (LinearLayout) findViewById(R.id.menu_list);
        this.lne = (TextView) findViewById(R.id.menu_title);
        this.lnf = (TextView) findViewById(R.id.all_concerned_item);
        this.lnh = (TextView) findViewById(R.id.each_concerned_item);
        this.gde = findViewById(R.id.item_divider_line);
        this.lnc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new aq("c12774").dW("obj_locate", "1"));
                ConcernSelectView.this.B(ConcernSelectView.this.lni, ConcernSelectView.this.lni.getVisibility() == 0 ? 1 : 0);
            }
        });
        this.lnf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new aq("c12774").dW("obj_locate", "2"));
                ao.setViewTextColor(ConcernSelectView.this.lnf, R.color.CAM_X0105);
                ao.setViewTextColor(ConcernSelectView.this.lnh, R.color.CAM_X0107);
                ConcernSelectView.this.lne.setText(R.string.all_concerned);
                if (ConcernSelectView.this.lnm != null) {
                    ConcernSelectView.this.lnm.Ab(0);
                }
                ConcernSelectView.this.B(ConcernSelectView.this.lni, 1);
            }
        });
        this.lnh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new aq("c12774").dW("obj_locate", "3"));
                ao.setViewTextColor(ConcernSelectView.this.lnf, R.color.CAM_X0107);
                ao.setViewTextColor(ConcernSelectView.this.lnh, R.color.CAM_X0105);
                ConcernSelectView.this.lne.setText(R.string.each_concerned);
                if (ConcernSelectView.this.lnm != null) {
                    ConcernSelectView.this.lnm.Ab(1);
                }
                ConcernSelectView.this.B(ConcernSelectView.this.lni, 1);
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void dfb() {
        if (this.lni.getVisibility() == 0) {
            B(this.lni, 1);
        }
    }

    public boolean dfc() {
        return this.lni.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            SvgManager.bsx().a(this.lnd, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0109, (SvgManager.SvgResourceStateType) null);
            ao.setViewTextColor(this.lne, R.color.CAM_X0109);
            ao.setViewTextColor(this.lnf, R.color.CAM_X0105);
            ao.setViewTextColor(this.lnh, R.color.CAM_X0107);
            ao.setBackgroundResource(this.lni, R.drawable.concern_item_bg);
            ao.setBackgroundResource(this.lne, R.color.CAM_X0201);
            ao.setBackgroundResource(this.lnf, R.drawable.concern_item_menu_select_bg);
            ao.setBackgroundResource(this.lnh, R.drawable.concern_item_menu_select_bg);
            ao.setBackgroundResource(this.gde, R.color.CAM_X0204);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(final View view, final int i) {
        if (view != null && view.getAnimation() == null && this.lni != null) {
            int childCount = this.lni.getChildCount();
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
                    if (ConcernSelectView.this.lnm != null) {
                        ConcernSelectView.this.lnm.tO(z);
                    }
                }
            });
            view.startAnimation(aVar);
            if (this.lnd != null) {
                if (this.lnd.getAnimation() == null || this.lnd.getAnimation().hasEnded()) {
                    if (i == 0) {
                        if (this.lnj == null) {
                            dfe();
                        }
                        if (this.lnk != null) {
                            this.lnk.cancel();
                        }
                        this.lnd.startAnimation(this.lnj);
                        return;
                    }
                    if (this.lnk == null) {
                        dfd();
                    }
                    if (this.lnj != null) {
                        this.lnj.cancel();
                    }
                    this.lnd.startAnimation(this.lnk);
                }
            }
        }
    }

    private void dfd() {
        this.lnk = AnimationUtils.loadAnimation(this.mContext, R.anim.rotate_collapse);
        this.lnk.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                ConcernSelectView.this.lnl = false;
            }
        });
    }

    private void dfe() {
        this.lnj = AnimationUtils.loadAnimation(this.mContext, R.anim.rotate_expand);
        this.lnj.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.myAttentionAndFans.ConcernSelectView.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ConcernSelectView.this.lnl = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void setOnExpandListener(a aVar) {
        this.lnm = aVar;
    }
}

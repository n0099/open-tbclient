package com.baidu.tieba.pb.pb.godreply.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.support.v4.widget.ExploreByTouchHelper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class a {
    private ViewGroup RU;
    private View.OnClickListener avq;
    private b eSE;
    private int apG = 3;
    private final int[] eSD = new int[2];
    private int eSF = ExploreByTouchHelper.INVALID_ID;
    private int eSG = ExploreByTouchHelper.INVALID_ID;
    private boolean eSH = false;

    public void E(View.OnClickListener onClickListener) {
        this.avq = onClickListener;
    }

    public void showTip(View view) {
        Context context;
        if (view != null && (context = view.getContext()) != null && (context instanceof Activity)) {
            if (this.RU == null) {
                this.RU = (RelativeLayout) ((Activity) context).findViewById(d.g.pb_layout);
            }
            if (this.RU != null) {
                view.getLocationOnScreen(this.eSD);
                int dip2px = l.dip2px(context, 160.0f);
                int dip2px2 = l.dip2px(context, 36.0f);
                if (this.eSE == null) {
                    this.eSE = new b(context);
                }
                this.eSE.animate().cancel();
                this.eSE.setAlpha(0.0f);
                this.eSE.animate().alpha(1.0f).setListener(null).start();
                this.eSE.setOnClickListener(this.avq);
                this.eSE.onChangeSkinType(this.apG);
                if (this.eSE.getParent() != null && this.eSE.getParent() != this.RU) {
                    ((ViewGroup) this.eSE.getParent()).removeView(this.eSE);
                }
                if (this.eSE.getParent() == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px, dip2px2);
                    layoutParams.rightMargin = bO(context);
                    layoutParams.topMargin = this.eSD[1] + view.getHeight() + bN(context);
                    layoutParams.addRule(11);
                    int childCount = this.RU.getChildCount();
                    int i = -1;
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = this.RU.getChildAt(i2);
                        if (childAt != null && childAt.getId() == d.g.new_pb_list) {
                            i = i2 + 1;
                        }
                    }
                    if (i > -1 && i <= this.RU.getChildCount()) {
                        this.RU.addView(this.eSE, i, layoutParams);
                    }
                }
                this.eSE.setVisibility(0);
            }
        }
    }

    public void hideTip() {
        if (this.eSE != null) {
            this.eSE.animate().cancel();
            this.eSE.animate().alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.pb.godreply.a.a.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    a.this.aSH();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    a.this.aSH();
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSH() {
        if (this.eSE != null && this.eSE.getParent() != null && this.eSE.getParent() == this.RU) {
            this.eSE.setVisibility(4);
        }
    }

    public void bc(View view) {
        if (aSI()) {
            Context context = view.getContext();
            view.getLocationOnScreen(this.eSD);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eSE.getLayoutParams();
            layoutParams.rightMargin = bO(context);
            layoutParams.topMargin = this.eSD[1] + view.getHeight() + bN(context);
            layoutParams.addRule(11);
            this.eSE.setLayoutParams(layoutParams);
            if (layoutParams.topMargin + this.eSE.getHeight() < l.ag(context)[1] && !this.eSH) {
                c.t(context, true);
                this.eSH = true;
                this.eSE.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.hideTip();
                    }
                }, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
        }
    }

    public boolean aSI() {
        return this.eSE != null && this.eSE.getParent() != null && this.eSE.getParent() == this.RU && this.eSE.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        this.apG = i;
        if (this.eSE != null) {
            this.eSE.onChangeSkinType(i);
        }
    }

    private int bN(Context context) {
        if (this.eSF == Integer.MIN_VALUE) {
            this.eSF = -l.dip2px(context, 5.0f);
        }
        return this.eSF;
    }

    private int bO(Context context) {
        if (this.eSG == Integer.MIN_VALUE) {
            this.eSG = l.dip2px(context, 17.0f);
        }
        return this.eSG;
    }
}

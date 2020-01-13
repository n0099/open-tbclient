package com.baidu.tieba.pb.pb.godreply.usertips;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class a {
    private ViewGroup cGr;
    private View.OnClickListener dmY;
    private GodReplyLeaderboardTipView iCl;
    private int MH = 3;
    private final int[] iCk = new int[2];
    private int iCm = Integer.MIN_VALUE;
    private int iCn = Integer.MIN_VALUE;
    private boolean iCo = false;

    public void P(View.OnClickListener onClickListener) {
        this.dmY = onClickListener;
    }

    public void showTip(View view) {
        Context context;
        if (view != null && (context = view.getContext()) != null && (context instanceof Activity)) {
            if (this.cGr == null) {
                this.cGr = (RelativeLayout) ((Activity) context).findViewById(R.id.pb_layout);
            }
            if (this.cGr != null) {
                view.getLocationOnScreen(this.iCk);
                int dip2px = l.dip2px(context, 160.0f);
                int dip2px2 = l.dip2px(context, 36.0f);
                if (this.iCl == null) {
                    this.iCl = new GodReplyLeaderboardTipView(context);
                }
                this.iCl.animate().cancel();
                this.iCl.setAlpha(0.0f);
                this.iCl.animate().alpha(1.0f).setListener(null).start();
                this.iCl.setOnClickListener(this.dmY);
                this.iCl.onChangeSkinType(this.MH);
                if (this.iCl.getParent() != null && this.iCl.getParent() != this.cGr) {
                    ((ViewGroup) this.iCl.getParent()).removeView(this.iCl);
                }
                if (this.iCl.getParent() == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px, dip2px2);
                    layoutParams.rightMargin = fi(context);
                    layoutParams.topMargin = this.iCk[1] + view.getHeight() + fh(context);
                    layoutParams.addRule(11);
                    int childCount = this.cGr.getChildCount();
                    int i = -1;
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = this.cGr.getChildAt(i2);
                        if (childAt != null && childAt.getId() == R.id.new_pb_list) {
                            i = i2 + 1;
                        }
                    }
                    if (i > -1 && i <= this.cGr.getChildCount()) {
                        this.cGr.addView(this.iCl, i, layoutParams);
                    }
                }
                this.iCl.setVisibility(0);
            }
        }
    }

    public void hideTip() {
        if (this.iCl != null) {
            this.iCl.animate().cancel();
            this.iCl.animate().alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.pb.godreply.usertips.a.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    a.this.hideTipView();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    a.this.hideTipView();
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideTipView() {
        if (this.iCl != null && this.iCl.getParent() != null && this.iCl.getParent() == this.cGr) {
            this.iCl.setVisibility(4);
        }
    }

    public void cs(View view) {
        if (ckm()) {
            Context context = view.getContext();
            view.getLocationOnScreen(this.iCk);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iCl.getLayoutParams();
            layoutParams.rightMargin = fi(context);
            layoutParams.topMargin = this.iCk[1] + view.getHeight() + fh(context);
            layoutParams.addRule(11);
            this.iCl.setLayoutParams(layoutParams);
            if (layoutParams.topMargin + this.iCl.getHeight() < l.getScreenDimensions(context)[1] && !this.iCo) {
                b.k(context, true);
                this.iCo = true;
                this.iCl.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.usertips.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.hideTip();
                    }
                }, 5000L);
            }
        }
    }

    public boolean ckm() {
        return this.iCl != null && this.iCl.getParent() != null && this.iCl.getParent() == this.cGr && this.iCl.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        this.MH = i;
        if (this.iCl != null) {
            this.iCl.onChangeSkinType(i);
        }
    }

    private int fh(Context context) {
        if (this.iCm == Integer.MIN_VALUE) {
            this.iCm = -l.dip2px(context, 5.0f);
        }
        return this.iCm;
    }

    private int fi(Context context) {
        if (this.iCn == Integer.MIN_VALUE) {
            this.iCn = l.dip2px(context, 17.0f);
        }
        return this.iCn;
    }
}

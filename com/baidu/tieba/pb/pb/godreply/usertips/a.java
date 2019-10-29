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
/* loaded from: classes4.dex */
public class a {
    private ViewGroup bUz;
    private View.OnClickListener czV;
    private GodReplyLeaderboardTipView hLk;
    private int csX = 3;
    private final int[] hLj = new int[2];
    private int hLl = Integer.MIN_VALUE;
    private int hLm = Integer.MIN_VALUE;
    private boolean hLn = false;

    public void P(View.OnClickListener onClickListener) {
        this.czV = onClickListener;
    }

    public void showTip(View view) {
        Context context;
        if (view != null && (context = view.getContext()) != null && (context instanceof Activity)) {
            if (this.bUz == null) {
                this.bUz = (RelativeLayout) ((Activity) context).findViewById(R.id.pb_layout);
            }
            if (this.bUz != null) {
                view.getLocationOnScreen(this.hLj);
                int dip2px = l.dip2px(context, 160.0f);
                int dip2px2 = l.dip2px(context, 36.0f);
                if (this.hLk == null) {
                    this.hLk = new GodReplyLeaderboardTipView(context);
                }
                this.hLk.animate().cancel();
                this.hLk.setAlpha(0.0f);
                this.hLk.animate().alpha(1.0f).setListener(null).start();
                this.hLk.setOnClickListener(this.czV);
                this.hLk.onChangeSkinType(this.csX);
                if (this.hLk.getParent() != null && this.hLk.getParent() != this.bUz) {
                    ((ViewGroup) this.hLk.getParent()).removeView(this.hLk);
                }
                if (this.hLk.getParent() == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px, dip2px2);
                    layoutParams.rightMargin = dR(context);
                    layoutParams.topMargin = this.hLj[1] + view.getHeight() + dQ(context);
                    layoutParams.addRule(11);
                    int childCount = this.bUz.getChildCount();
                    int i = -1;
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = this.bUz.getChildAt(i2);
                        if (childAt != null && childAt.getId() == R.id.new_pb_list) {
                            i = i2 + 1;
                        }
                    }
                    if (i > -1 && i <= this.bUz.getChildCount()) {
                        this.bUz.addView(this.hLk, i, layoutParams);
                    }
                }
                this.hLk.setVisibility(0);
            }
        }
    }

    public void hideTip() {
        if (this.hLk != null) {
            this.hLk.animate().cancel();
            this.hLk.animate().alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.pb.godreply.usertips.a.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    a.this.bRP();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    a.this.bRP();
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRP() {
        if (this.hLk != null && this.hLk.getParent() != null && this.hLk.getParent() == this.bUz) {
            this.hLk.setVisibility(4);
        }
    }

    public void cr(View view) {
        if (bRQ()) {
            Context context = view.getContext();
            view.getLocationOnScreen(this.hLj);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hLk.getLayoutParams();
            layoutParams.rightMargin = dR(context);
            layoutParams.topMargin = this.hLj[1] + view.getHeight() + dQ(context);
            layoutParams.addRule(11);
            this.hLk.setLayoutParams(layoutParams);
            if (layoutParams.topMargin + this.hLk.getHeight() < l.getScreenDimensions(context)[1] && !this.hLn) {
                b.j(context, true);
                this.hLn = true;
                this.hLk.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.usertips.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.hideTip();
                    }
                }, 5000L);
            }
        }
    }

    public boolean bRQ() {
        return this.hLk != null && this.hLk.getParent() != null && this.hLk.getParent() == this.bUz && this.hLk.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        this.csX = i;
        if (this.hLk != null) {
            this.hLk.onChangeSkinType(i);
        }
    }

    private int dQ(Context context) {
        if (this.hLl == Integer.MIN_VALUE) {
            this.hLl = -l.dip2px(context, 5.0f);
        }
        return this.hLl;
    }

    private int dR(Context context) {
        if (this.hLm == Integer.MIN_VALUE) {
            this.hLm = l.dip2px(context, 17.0f);
        }
        return this.hLm;
    }
}

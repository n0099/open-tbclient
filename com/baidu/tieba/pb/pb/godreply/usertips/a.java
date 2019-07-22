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
    private ViewGroup bBG;
    private View.OnClickListener clU;
    private GodReplyLeaderboardTipView hJQ;
    private int cdL = 3;
    private final int[] hJP = new int[2];
    private int hJR = Integer.MIN_VALUE;
    private int hJS = Integer.MIN_VALUE;
    private boolean hJT = false;

    public void O(View.OnClickListener onClickListener) {
        this.clU = onClickListener;
    }

    public void showTip(View view) {
        Context context;
        if (view != null && (context = view.getContext()) != null && (context instanceof Activity)) {
            if (this.bBG == null) {
                this.bBG = (RelativeLayout) ((Activity) context).findViewById(R.id.pb_layout);
            }
            if (this.bBG != null) {
                view.getLocationOnScreen(this.hJP);
                int dip2px = l.dip2px(context, 160.0f);
                int dip2px2 = l.dip2px(context, 36.0f);
                if (this.hJQ == null) {
                    this.hJQ = new GodReplyLeaderboardTipView(context);
                }
                this.hJQ.animate().cancel();
                this.hJQ.setAlpha(0.0f);
                this.hJQ.animate().alpha(1.0f).setListener(null).start();
                this.hJQ.setOnClickListener(this.clU);
                this.hJQ.onChangeSkinType(this.cdL);
                if (this.hJQ.getParent() != null && this.hJQ.getParent() != this.bBG) {
                    ((ViewGroup) this.hJQ.getParent()).removeView(this.hJQ);
                }
                if (this.hJQ.getParent() == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px, dip2px2);
                    layoutParams.rightMargin = ed(context);
                    layoutParams.topMargin = this.hJP[1] + view.getHeight() + ec(context);
                    layoutParams.addRule(11);
                    int childCount = this.bBG.getChildCount();
                    int i = -1;
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = this.bBG.getChildAt(i2);
                        if (childAt != null && childAt.getId() == R.id.new_pb_list) {
                            i = i2 + 1;
                        }
                    }
                    if (i > -1 && i <= this.bBG.getChildCount()) {
                        this.bBG.addView(this.hJQ, i, layoutParams);
                    }
                }
                this.hJQ.setVisibility(0);
            }
        }
    }

    public void hideTip() {
        if (this.hJQ != null) {
            this.hJQ.animate().cancel();
            this.hJQ.animate().alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.pb.godreply.usertips.a.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    a.this.bTN();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    a.this.bTN();
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTN() {
        if (this.hJQ != null && this.hJQ.getParent() != null && this.hJQ.getParent() == this.bBG) {
            this.hJQ.setVisibility(4);
        }
    }

    public void cu(View view) {
        if (bTO()) {
            Context context = view.getContext();
            view.getLocationOnScreen(this.hJP);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hJQ.getLayoutParams();
            layoutParams.rightMargin = ed(context);
            layoutParams.topMargin = this.hJP[1] + view.getHeight() + ec(context);
            layoutParams.addRule(11);
            this.hJQ.setLayoutParams(layoutParams);
            if (layoutParams.topMargin + this.hJQ.getHeight() < l.aj(context)[1] && !this.hJT) {
                b.j(context, true);
                this.hJT = true;
                this.hJQ.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.usertips.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.hideTip();
                    }
                }, 5000L);
            }
        }
    }

    public boolean bTO() {
        return this.hJQ != null && this.hJQ.getParent() != null && this.hJQ.getParent() == this.bBG && this.hJQ.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        this.cdL = i;
        if (this.hJQ != null) {
            this.hJQ.onChangeSkinType(i);
        }
    }

    private int ec(Context context) {
        if (this.hJR == Integer.MIN_VALUE) {
            this.hJR = -l.dip2px(context, 5.0f);
        }
        return this.hJR;
    }

    private int ed(Context context) {
        if (this.hJS == Integer.MIN_VALUE) {
            this.hJS = l.dip2px(context, 17.0f);
        }
        return this.hJS;
    }
}

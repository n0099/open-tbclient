package com.baidu.tieba.pb.pb.godreply.usertips;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class a {
    private ViewGroup Ta;
    private View.OnClickListener axG;
    private GodReplyLeaderboardTipView fee;
    private int aqQ = 3;
    private final int[] fed = new int[2];
    private int fef = Integer.MIN_VALUE;
    private int feg = Integer.MIN_VALUE;
    private boolean feh = false;

    public void G(View.OnClickListener onClickListener) {
        this.axG = onClickListener;
    }

    public void showTip(View view2) {
        Context context;
        if (view2 != null && (context = view2.getContext()) != null && (context instanceof Activity)) {
            if (this.Ta == null) {
                this.Ta = (RelativeLayout) ((Activity) context).findViewById(d.g.pb_layout);
            }
            if (this.Ta != null) {
                view2.getLocationOnScreen(this.fed);
                int dip2px = l.dip2px(context, 160.0f);
                int dip2px2 = l.dip2px(context, 36.0f);
                if (this.fee == null) {
                    this.fee = new GodReplyLeaderboardTipView(context);
                }
                this.fee.animate().cancel();
                this.fee.setAlpha(0.0f);
                this.fee.animate().alpha(1.0f).setListener(null).start();
                this.fee.setOnClickListener(this.axG);
                this.fee.onChangeSkinType(this.aqQ);
                if (this.fee.getParent() != null && this.fee.getParent() != this.Ta) {
                    ((ViewGroup) this.fee.getParent()).removeView(this.fee);
                }
                if (this.fee.getParent() == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px, dip2px2);
                    layoutParams.rightMargin = bO(context);
                    layoutParams.topMargin = this.fed[1] + view2.getHeight() + bN(context);
                    layoutParams.addRule(11);
                    int childCount = this.Ta.getChildCount();
                    int i = -1;
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = this.Ta.getChildAt(i2);
                        if (childAt != null && childAt.getId() == d.g.new_pb_list) {
                            i = i2 + 1;
                        }
                    }
                    if (i > -1 && i <= this.Ta.getChildCount()) {
                        this.Ta.addView(this.fee, i, layoutParams);
                    }
                }
                this.fee.setVisibility(0);
            }
        }
    }

    public void hideTip() {
        if (this.fee != null) {
            this.fee.animate().cancel();
            this.fee.animate().alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.pb.godreply.usertips.a.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    a.this.aWG();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    a.this.aWG();
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWG() {
        if (this.fee != null && this.fee.getParent() != null && this.fee.getParent() == this.Ta) {
            this.fee.setVisibility(4);
        }
    }

    public void aU(View view2) {
        if (aWH()) {
            Context context = view2.getContext();
            view2.getLocationOnScreen(this.fed);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fee.getLayoutParams();
            layoutParams.rightMargin = bO(context);
            layoutParams.topMargin = this.fed[1] + view2.getHeight() + bN(context);
            layoutParams.addRule(11);
            this.fee.setLayoutParams(layoutParams);
            if (layoutParams.topMargin + this.fee.getHeight() < l.aj(context)[1] && !this.feh) {
                b.u(context, true);
                this.feh = true;
                this.fee.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.usertips.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.hideTip();
                    }
                }, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
        }
    }

    public boolean aWH() {
        return this.fee != null && this.fee.getParent() != null && this.fee.getParent() == this.Ta && this.fee.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        this.aqQ = i;
        if (this.fee != null) {
            this.fee.onChangeSkinType(i);
        }
    }

    private int bN(Context context) {
        if (this.fef == Integer.MIN_VALUE) {
            this.fef = -l.dip2px(context, 5.0f);
        }
        return this.fef;
    }

    private int bO(Context context) {
        if (this.feg == Integer.MIN_VALUE) {
            this.feg = l.dip2px(context, 17.0f);
        }
        return this.feg;
    }
}

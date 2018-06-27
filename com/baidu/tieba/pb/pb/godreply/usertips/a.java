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
    private View.OnClickListener aGU;
    private ViewGroup abh;
    private GodReplyLeaderboardTipView fuB;
    private int azP = 3;
    private final int[] fuA = new int[2];
    private int fuC = Integer.MIN_VALUE;
    private int fuD = Integer.MIN_VALUE;
    private boolean fuE = false;

    public void J(View.OnClickListener onClickListener) {
        this.aGU = onClickListener;
    }

    public void showTip(View view) {
        Context context;
        if (view != null && (context = view.getContext()) != null && (context instanceof Activity)) {
            if (this.abh == null) {
                this.abh = (RelativeLayout) ((Activity) context).findViewById(d.g.pb_layout);
            }
            if (this.abh != null) {
                view.getLocationOnScreen(this.fuA);
                int dip2px = l.dip2px(context, 160.0f);
                int dip2px2 = l.dip2px(context, 36.0f);
                if (this.fuB == null) {
                    this.fuB = new GodReplyLeaderboardTipView(context);
                }
                this.fuB.animate().cancel();
                this.fuB.setAlpha(0.0f);
                this.fuB.animate().alpha(1.0f).setListener(null).start();
                this.fuB.setOnClickListener(this.aGU);
                this.fuB.onChangeSkinType(this.azP);
                if (this.fuB.getParent() != null && this.fuB.getParent() != this.abh) {
                    ((ViewGroup) this.fuB.getParent()).removeView(this.fuB);
                }
                if (this.fuB.getParent() == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px, dip2px2);
                    layoutParams.rightMargin = bY(context);
                    layoutParams.topMargin = this.fuA[1] + view.getHeight() + bX(context);
                    layoutParams.addRule(11);
                    int childCount = this.abh.getChildCount();
                    int i = -1;
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = this.abh.getChildAt(i2);
                        if (childAt != null && childAt.getId() == d.g.new_pb_list) {
                            i = i2 + 1;
                        }
                    }
                    if (i > -1 && i <= this.abh.getChildCount()) {
                        this.abh.addView(this.fuB, i, layoutParams);
                    }
                }
                this.fuB.setVisibility(0);
            }
        }
    }

    public void hideTip() {
        if (this.fuB != null) {
            this.fuB.animate().cancel();
            this.fuB.animate().alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.pb.godreply.usertips.a.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    a.this.bcj();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    a.this.bcj();
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcj() {
        if (this.fuB != null && this.fuB.getParent() != null && this.fuB.getParent() == this.abh) {
            this.fuB.setVisibility(4);
        }
    }

    public void aY(View view) {
        if (bck()) {
            Context context = view.getContext();
            view.getLocationOnScreen(this.fuA);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fuB.getLayoutParams();
            layoutParams.rightMargin = bY(context);
            layoutParams.topMargin = this.fuA[1] + view.getHeight() + bX(context);
            layoutParams.addRule(11);
            this.fuB.setLayoutParams(layoutParams);
            if (layoutParams.topMargin + this.fuB.getHeight() < l.al(context)[1] && !this.fuE) {
                b.u(context, true);
                this.fuE = true;
                this.fuB.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.usertips.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.hideTip();
                    }
                }, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
        }
    }

    public boolean bck() {
        return this.fuB != null && this.fuB.getParent() != null && this.fuB.getParent() == this.abh && this.fuB.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        this.azP = i;
        if (this.fuB != null) {
            this.fuB.onChangeSkinType(i);
        }
    }

    private int bX(Context context) {
        if (this.fuC == Integer.MIN_VALUE) {
            this.fuC = -l.dip2px(context, 5.0f);
        }
        return this.fuC;
    }

    private int bY(Context context) {
        if (this.fuD == Integer.MIN_VALUE) {
            this.fuD = l.dip2px(context, 17.0f);
        }
        return this.fuD;
    }
}

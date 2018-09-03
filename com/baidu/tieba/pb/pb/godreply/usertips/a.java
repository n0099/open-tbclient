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
import com.baidu.tieba.f;
/* loaded from: classes2.dex */
public class a {
    private View.OnClickListener aGT;
    private ViewGroup aaL;
    private GodReplyLeaderboardTipView fuF;
    private int azF = 3;
    private final int[] fuE = new int[2];
    private int fuG = Integer.MIN_VALUE;
    private int fuH = Integer.MIN_VALUE;
    private boolean fuI = false;

    public void H(View.OnClickListener onClickListener) {
        this.aGT = onClickListener;
    }

    public void showTip(View view) {
        Context context;
        if (view != null && (context = view.getContext()) != null && (context instanceof Activity)) {
            if (this.aaL == null) {
                this.aaL = (RelativeLayout) ((Activity) context).findViewById(f.g.pb_layout);
            }
            if (this.aaL != null) {
                view.getLocationOnScreen(this.fuE);
                int dip2px = l.dip2px(context, 160.0f);
                int dip2px2 = l.dip2px(context, 36.0f);
                if (this.fuF == null) {
                    this.fuF = new GodReplyLeaderboardTipView(context);
                }
                this.fuF.animate().cancel();
                this.fuF.setAlpha(0.0f);
                this.fuF.animate().alpha(1.0f).setListener(null).start();
                this.fuF.setOnClickListener(this.aGT);
                this.fuF.onChangeSkinType(this.azF);
                if (this.fuF.getParent() != null && this.fuF.getParent() != this.aaL) {
                    ((ViewGroup) this.fuF.getParent()).removeView(this.fuF);
                }
                if (this.fuF.getParent() == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px, dip2px2);
                    layoutParams.rightMargin = bY(context);
                    layoutParams.topMargin = this.fuE[1] + view.getHeight() + bX(context);
                    layoutParams.addRule(11);
                    int childCount = this.aaL.getChildCount();
                    int i = -1;
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = this.aaL.getChildAt(i2);
                        if (childAt != null && childAt.getId() == f.g.new_pb_list) {
                            i = i2 + 1;
                        }
                    }
                    if (i > -1 && i <= this.aaL.getChildCount()) {
                        this.aaL.addView(this.fuF, i, layoutParams);
                    }
                }
                this.fuF.setVisibility(0);
            }
        }
    }

    public void hideTip() {
        if (this.fuF != null) {
            this.fuF.animate().cancel();
            this.fuF.animate().alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.pb.godreply.usertips.a.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    a.this.bax();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    a.this.bax();
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bax() {
        if (this.fuF != null && this.fuF.getParent() != null && this.fuF.getParent() == this.aaL) {
            this.fuF.setVisibility(4);
        }
    }

    public void bb(View view) {
        if (bay()) {
            Context context = view.getContext();
            view.getLocationOnScreen(this.fuE);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fuF.getLayoutParams();
            layoutParams.rightMargin = bY(context);
            layoutParams.topMargin = this.fuE[1] + view.getHeight() + bX(context);
            layoutParams.addRule(11);
            this.fuF.setLayoutParams(layoutParams);
            if (layoutParams.topMargin + this.fuF.getHeight() < l.al(context)[1] && !this.fuI) {
                b.i(context, true);
                this.fuI = true;
                this.fuF.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.usertips.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.hideTip();
                    }
                }, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
        }
    }

    public boolean bay() {
        return this.fuF != null && this.fuF.getParent() != null && this.fuF.getParent() == this.aaL && this.fuF.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        this.azF = i;
        if (this.fuF != null) {
            this.fuF.onChangeSkinType(i);
        }
    }

    private int bX(Context context) {
        if (this.fuG == Integer.MIN_VALUE) {
            this.fuG = -l.dip2px(context, 5.0f);
        }
        return this.fuG;
    }

    private int bY(Context context) {
        if (this.fuH == Integer.MIN_VALUE) {
            this.fuH = l.dip2px(context, 17.0f);
        }
        return this.fuH;
    }
}

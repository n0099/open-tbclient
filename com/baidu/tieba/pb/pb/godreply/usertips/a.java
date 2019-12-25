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
/* loaded from: classes6.dex */
public class a {
    private ViewGroup cGf;
    private View.OnClickListener dmK;
    private GodReplyLeaderboardTipView iyH;
    private int MA = 3;
    private final int[] iyG = new int[2];
    private int iyI = Integer.MIN_VALUE;
    private int iyJ = Integer.MIN_VALUE;
    private boolean iyK = false;

    public void Q(View.OnClickListener onClickListener) {
        this.dmK = onClickListener;
    }

    public void showTip(View view) {
        Context context;
        if (view != null && (context = view.getContext()) != null && (context instanceof Activity)) {
            if (this.cGf == null) {
                this.cGf = (RelativeLayout) ((Activity) context).findViewById(R.id.pb_layout);
            }
            if (this.cGf != null) {
                view.getLocationOnScreen(this.iyG);
                int dip2px = l.dip2px(context, 160.0f);
                int dip2px2 = l.dip2px(context, 36.0f);
                if (this.iyH == null) {
                    this.iyH = new GodReplyLeaderboardTipView(context);
                }
                this.iyH.animate().cancel();
                this.iyH.setAlpha(0.0f);
                this.iyH.animate().alpha(1.0f).setListener(null).start();
                this.iyH.setOnClickListener(this.dmK);
                this.iyH.onChangeSkinType(this.MA);
                if (this.iyH.getParent() != null && this.iyH.getParent() != this.cGf) {
                    ((ViewGroup) this.iyH.getParent()).removeView(this.iyH);
                }
                if (this.iyH.getParent() == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px, dip2px2);
                    layoutParams.rightMargin = fi(context);
                    layoutParams.topMargin = this.iyG[1] + view.getHeight() + fh(context);
                    layoutParams.addRule(11);
                    int childCount = this.cGf.getChildCount();
                    int i = -1;
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = this.cGf.getChildAt(i2);
                        if (childAt != null && childAt.getId() == R.id.new_pb_list) {
                            i = i2 + 1;
                        }
                    }
                    if (i > -1 && i <= this.cGf.getChildCount()) {
                        this.cGf.addView(this.iyH, i, layoutParams);
                    }
                }
                this.iyH.setVisibility(0);
            }
        }
    }

    public void hideTip() {
        if (this.iyH != null) {
            this.iyH.animate().cancel();
            this.iyH.animate().alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.pb.godreply.usertips.a.1
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
        if (this.iyH != null && this.iyH.getParent() != null && this.iyH.getParent() == this.cGf) {
            this.iyH.setVisibility(4);
        }
    }

    public void cn(View view) {
        if (cje()) {
            Context context = view.getContext();
            view.getLocationOnScreen(this.iyG);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iyH.getLayoutParams();
            layoutParams.rightMargin = fi(context);
            layoutParams.topMargin = this.iyG[1] + view.getHeight() + fh(context);
            layoutParams.addRule(11);
            this.iyH.setLayoutParams(layoutParams);
            if (layoutParams.topMargin + this.iyH.getHeight() < l.getScreenDimensions(context)[1] && !this.iyK) {
                b.k(context, true);
                this.iyK = true;
                this.iyH.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.usertips.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.hideTip();
                    }
                }, 5000L);
            }
        }
    }

    public boolean cje() {
        return this.iyH != null && this.iyH.getParent() != null && this.iyH.getParent() == this.cGf && this.iyH.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        this.MA = i;
        if (this.iyH != null) {
            this.iyH.onChangeSkinType(i);
        }
    }

    private int fh(Context context) {
        if (this.iyI == Integer.MIN_VALUE) {
            this.iyI = -l.dip2px(context, 5.0f);
        }
        return this.iyI;
    }

    private int fi(Context context) {
        if (this.iyJ == Integer.MIN_VALUE) {
            this.iyJ = l.dip2px(context, 17.0f);
        }
        return this.iyJ;
    }
}

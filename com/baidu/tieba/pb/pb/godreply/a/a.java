package com.baidu.tieba.pb.pb.godreply.a;

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
    private ViewGroup aGz;
    private View.OnClickListener bjO;
    private b fHa;
    private int bdS = 3;
    private final int[] fGZ = new int[2];
    private int fHb = Integer.MIN_VALUE;
    private int fHc = Integer.MIN_VALUE;
    private boolean fHd = false;

    public void F(View.OnClickListener onClickListener) {
        this.bjO = onClickListener;
    }

    public void showTip(View view) {
        Context context;
        if (view != null && (context = view.getContext()) != null && (context instanceof Activity)) {
            if (this.aGz == null) {
                this.aGz = (RelativeLayout) ((Activity) context).findViewById(d.g.pb_layout);
            }
            if (this.aGz != null) {
                view.getLocationOnScreen(this.fGZ);
                int dip2px = l.dip2px(context, 160.0f);
                int dip2px2 = l.dip2px(context, 36.0f);
                if (this.fHa == null) {
                    this.fHa = new b(context);
                }
                this.fHa.animate().cancel();
                this.fHa.setAlpha(0.0f);
                this.fHa.animate().alpha(1.0f).setListener(null).start();
                this.fHa.setOnClickListener(this.bjO);
                this.fHa.onChangeSkinType(this.bdS);
                if (this.fHa.getParent() != null && this.fHa.getParent() != this.aGz) {
                    ((ViewGroup) this.fHa.getParent()).removeView(this.fHa);
                }
                if (this.fHa.getParent() == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px, dip2px2);
                    layoutParams.rightMargin = bW(context);
                    layoutParams.topMargin = this.fGZ[1] + view.getHeight() + bV(context);
                    layoutParams.addRule(11);
                    int childCount = this.aGz.getChildCount();
                    int i = -1;
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = this.aGz.getChildAt(i2);
                        if (childAt != null && childAt.getId() == d.g.new_pb_list) {
                            i = i2 + 1;
                        }
                    }
                    if (i > -1 && i <= this.aGz.getChildCount()) {
                        this.aGz.addView(this.fHa, i, layoutParams);
                    }
                }
                this.fHa.setVisibility(0);
            }
        }
    }

    public void hideTip() {
        if (this.fHa != null) {
            this.fHa.animate().cancel();
            this.fHa.animate().alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.pb.godreply.a.a.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    a.this.bac();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    a.this.bac();
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bac() {
        if (this.fHa != null && this.fHa.getParent() != null && this.fHa.getParent() == this.aGz) {
            this.fHa.setVisibility(4);
        }
    }

    public void cp(View view) {
        if (bad()) {
            Context context = view.getContext();
            view.getLocationOnScreen(this.fGZ);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fHa.getLayoutParams();
            layoutParams.rightMargin = bW(context);
            layoutParams.topMargin = this.fGZ[1] + view.getHeight() + bV(context);
            layoutParams.addRule(11);
            this.fHa.setLayoutParams(layoutParams);
            if (layoutParams.topMargin + this.fHa.getHeight() < l.as(context)[1] && !this.fHd) {
                c.u(context, true);
                this.fHd = true;
                this.fHa.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.hideTip();
                    }
                }, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
        }
    }

    public boolean bad() {
        return this.fHa != null && this.fHa.getParent() != null && this.fHa.getParent() == this.aGz && this.fHa.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        this.bdS = i;
        if (this.fHa != null) {
            this.fHa.onChangeSkinType(i);
        }
    }

    private int bV(Context context) {
        if (this.fHb == Integer.MIN_VALUE) {
            this.fHb = -l.dip2px(context, 5.0f);
        }
        return this.fHb;
    }

    private int bW(Context context) {
        if (this.fHc == Integer.MIN_VALUE) {
            this.fHc = l.dip2px(context, 17.0f);
        }
        return this.fHc;
    }
}

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
    private ViewGroup aGy;
    private View.OnClickListener bjw;
    private b fFf;
    private int bdE = 3;
    private final int[] fFe = new int[2];
    private int fFg = Integer.MIN_VALUE;
    private int fFh = Integer.MIN_VALUE;
    private boolean fFi = false;

    public void E(View.OnClickListener onClickListener) {
        this.bjw = onClickListener;
    }

    public void showTip(View view) {
        Context context;
        if (view != null && (context = view.getContext()) != null && (context instanceof Activity)) {
            if (this.aGy == null) {
                this.aGy = (RelativeLayout) ((Activity) context).findViewById(d.g.pb_layout);
            }
            if (this.aGy != null) {
                view.getLocationOnScreen(this.fFe);
                int dip2px = l.dip2px(context, 160.0f);
                int dip2px2 = l.dip2px(context, 36.0f);
                if (this.fFf == null) {
                    this.fFf = new b(context);
                }
                this.fFf.animate().cancel();
                this.fFf.setAlpha(0.0f);
                this.fFf.animate().alpha(1.0f).setListener(null).start();
                this.fFf.setOnClickListener(this.bjw);
                this.fFf.onChangeSkinType(this.bdE);
                if (this.fFf.getParent() != null && this.fFf.getParent() != this.aGy) {
                    ((ViewGroup) this.fFf.getParent()).removeView(this.fFf);
                }
                if (this.fFf.getParent() == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px, dip2px2);
                    layoutParams.rightMargin = bZ(context);
                    layoutParams.topMargin = this.fFe[1] + view.getHeight() + bY(context);
                    layoutParams.addRule(11);
                    int childCount = this.aGy.getChildCount();
                    int i = -1;
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = this.aGy.getChildAt(i2);
                        if (childAt != null && childAt.getId() == d.g.new_pb_list) {
                            i = i2 + 1;
                        }
                    }
                    if (i > -1 && i <= this.aGy.getChildCount()) {
                        this.aGy.addView(this.fFf, i, layoutParams);
                    }
                }
                this.fFf.setVisibility(0);
            }
        }
    }

    public void hideTip() {
        if (this.fFf != null) {
            this.fFf.animate().cancel();
            this.fFf.animate().alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.pb.godreply.a.a.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    a.this.aZT();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    a.this.aZT();
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZT() {
        if (this.fFf != null && this.fFf.getParent() != null && this.fFf.getParent() == this.aGy) {
            this.fFf.setVisibility(4);
        }
    }

    public void cn(View view) {
        if (aZU()) {
            Context context = view.getContext();
            view.getLocationOnScreen(this.fFe);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fFf.getLayoutParams();
            layoutParams.rightMargin = bZ(context);
            layoutParams.topMargin = this.fFe[1] + view.getHeight() + bY(context);
            layoutParams.addRule(11);
            this.fFf.setLayoutParams(layoutParams);
            if (layoutParams.topMargin + this.fFf.getHeight() < l.as(context)[1] && !this.fFi) {
                c.u(context, true);
                this.fFi = true;
                this.fFf.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.hideTip();
                    }
                }, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
        }
    }

    public boolean aZU() {
        return this.fFf != null && this.fFf.getParent() != null && this.fFf.getParent() == this.aGy && this.fFf.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        this.bdE = i;
        if (this.fFf != null) {
            this.fFf.onChangeSkinType(i);
        }
    }

    private int bY(Context context) {
        if (this.fFg == Integer.MIN_VALUE) {
            this.fFg = -l.dip2px(context, 5.0f);
        }
        return this.fFg;
    }

    private int bZ(Context context) {
        if (this.fFh == Integer.MIN_VALUE) {
            this.fFh = l.dip2px(context, 17.0f);
        }
        return this.fFh;
    }
}

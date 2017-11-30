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
    private ViewGroup RW;
    private View.OnClickListener avi;
    private b eRw;
    private int apA = 3;
    private final int[] eRv = new int[2];
    private int eRx = ExploreByTouchHelper.INVALID_ID;
    private int eRy = ExploreByTouchHelper.INVALID_ID;
    private boolean eRz = false;

    public void E(View.OnClickListener onClickListener) {
        this.avi = onClickListener;
    }

    public void showTip(View view) {
        Context context;
        if (view != null && (context = view.getContext()) != null && (context instanceof Activity)) {
            if (this.RW == null) {
                this.RW = (RelativeLayout) ((Activity) context).findViewById(d.g.pb_layout);
            }
            if (this.RW != null) {
                view.getLocationOnScreen(this.eRv);
                int dip2px = l.dip2px(context, 160.0f);
                int dip2px2 = l.dip2px(context, 36.0f);
                if (this.eRw == null) {
                    this.eRw = new b(context);
                }
                this.eRw.animate().cancel();
                this.eRw.setAlpha(0.0f);
                this.eRw.animate().alpha(1.0f).setListener(null).start();
                this.eRw.setOnClickListener(this.avi);
                this.eRw.onChangeSkinType(this.apA);
                if (this.eRw.getParent() != null && this.eRw.getParent() != this.RW) {
                    ((ViewGroup) this.eRw.getParent()).removeView(this.eRw);
                }
                if (this.eRw.getParent() == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px, dip2px2);
                    layoutParams.rightMargin = bR(context);
                    layoutParams.topMargin = this.eRv[1] + view.getHeight() + bQ(context);
                    layoutParams.addRule(11);
                    int childCount = this.RW.getChildCount();
                    int i = -1;
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = this.RW.getChildAt(i2);
                        if (childAt != null && childAt.getId() == d.g.new_pb_list) {
                            i = i2 + 1;
                        }
                    }
                    if (i > -1 && i <= this.RW.getChildCount()) {
                        this.RW.addView(this.eRw, i, layoutParams);
                    }
                }
                this.eRw.setVisibility(0);
            }
        }
    }

    public void hideTip() {
        if (this.eRw != null) {
            this.eRw.animate().cancel();
            this.eRw.animate().alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.pb.godreply.a.a.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    a.this.aSy();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    a.this.aSy();
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSy() {
        if (this.eRw != null && this.eRw.getParent() != null && this.eRw.getParent() == this.RW) {
            this.eRw.setVisibility(4);
        }
    }

    public void aY(View view) {
        if (aSz()) {
            Context context = view.getContext();
            view.getLocationOnScreen(this.eRv);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eRw.getLayoutParams();
            layoutParams.rightMargin = bR(context);
            layoutParams.topMargin = this.eRv[1] + view.getHeight() + bQ(context);
            layoutParams.addRule(11);
            this.eRw.setLayoutParams(layoutParams);
            if (layoutParams.topMargin + this.eRw.getHeight() < l.ag(context)[1] && !this.eRz) {
                c.t(context, true);
                this.eRz = true;
                this.eRw.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.hideTip();
                    }
                }, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
        }
    }

    public boolean aSz() {
        return this.eRw != null && this.eRw.getParent() != null && this.eRw.getParent() == this.RW && this.eRw.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        this.apA = i;
        if (this.eRw != null) {
            this.eRw.onChangeSkinType(i);
        }
    }

    private int bQ(Context context) {
        if (this.eRx == Integer.MIN_VALUE) {
            this.eRx = -l.dip2px(context, 5.0f);
        }
        return this.eRx;
    }

    private int bR(Context context) {
        if (this.eRy == Integer.MIN_VALUE) {
            this.eRy = l.dip2px(context, 17.0f);
        }
        return this.eRy;
    }
}

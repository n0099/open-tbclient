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
    private ViewGroup aGw;
    private View.OnClickListener bjG;
    private b fGF;
    private int bdK = 3;
    private final int[] fGE = new int[2];
    private int fGG = Integer.MIN_VALUE;
    private int fGH = Integer.MIN_VALUE;
    private boolean fGI = false;

    public void F(View.OnClickListener onClickListener) {
        this.bjG = onClickListener;
    }

    public void showTip(View view) {
        Context context;
        if (view != null && (context = view.getContext()) != null && (context instanceof Activity)) {
            if (this.aGw == null) {
                this.aGw = (RelativeLayout) ((Activity) context).findViewById(d.g.pb_layout);
            }
            if (this.aGw != null) {
                view.getLocationOnScreen(this.fGE);
                int dip2px = l.dip2px(context, 160.0f);
                int dip2px2 = l.dip2px(context, 36.0f);
                if (this.fGF == null) {
                    this.fGF = new b(context);
                }
                this.fGF.animate().cancel();
                this.fGF.setAlpha(0.0f);
                this.fGF.animate().alpha(1.0f).setListener(null).start();
                this.fGF.setOnClickListener(this.bjG);
                this.fGF.onChangeSkinType(this.bdK);
                if (this.fGF.getParent() != null && this.fGF.getParent() != this.aGw) {
                    ((ViewGroup) this.fGF.getParent()).removeView(this.fGF);
                }
                if (this.fGF.getParent() == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px, dip2px2);
                    layoutParams.rightMargin = bZ(context);
                    layoutParams.topMargin = this.fGE[1] + view.getHeight() + bY(context);
                    layoutParams.addRule(11);
                    int childCount = this.aGw.getChildCount();
                    int i = -1;
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = this.aGw.getChildAt(i2);
                        if (childAt != null && childAt.getId() == d.g.new_pb_list) {
                            i = i2 + 1;
                        }
                    }
                    if (i > -1 && i <= this.aGw.getChildCount()) {
                        this.aGw.addView(this.fGF, i, layoutParams);
                    }
                }
                this.fGF.setVisibility(0);
            }
        }
    }

    public void hideTip() {
        if (this.fGF != null) {
            this.fGF.animate().cancel();
            this.fGF.animate().alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.pb.godreply.a.a.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    a.this.aZX();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    a.this.aZX();
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZX() {
        if (this.fGF != null && this.fGF.getParent() != null && this.fGF.getParent() == this.aGw) {
            this.fGF.setVisibility(4);
        }
    }

    public void cp(View view) {
        if (aZY()) {
            Context context = view.getContext();
            view.getLocationOnScreen(this.fGE);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fGF.getLayoutParams();
            layoutParams.rightMargin = bZ(context);
            layoutParams.topMargin = this.fGE[1] + view.getHeight() + bY(context);
            layoutParams.addRule(11);
            this.fGF.setLayoutParams(layoutParams);
            if (layoutParams.topMargin + this.fGF.getHeight() < l.as(context)[1] && !this.fGI) {
                c.u(context, true);
                this.fGI = true;
                this.fGF.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.a.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.hideTip();
                    }
                }, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
        }
    }

    public boolean aZY() {
        return this.fGF != null && this.fGF.getParent() != null && this.fGF.getParent() == this.aGw && this.fGF.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        this.bdK = i;
        if (this.fGF != null) {
            this.fGF.onChangeSkinType(i);
        }
    }

    private int bY(Context context) {
        if (this.fGG == Integer.MIN_VALUE) {
            this.fGG = -l.dip2px(context, 5.0f);
        }
        return this.fGG;
    }

    private int bZ(Context context) {
        if (this.fGH == Integer.MIN_VALUE) {
            this.fGH = l.dip2px(context, 17.0f);
        }
        return this.fGH;
    }
}

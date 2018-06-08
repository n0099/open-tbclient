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
    private View.OnClickListener aGc;
    private ViewGroup abe;
    private GodReplyLeaderboardTipView fqI;
    private int ayX = 3;
    private final int[] fqH = new int[2];
    private int fqJ = Integer.MIN_VALUE;
    private int fqK = Integer.MIN_VALUE;
    private boolean fqL = false;

    public void G(View.OnClickListener onClickListener) {
        this.aGc = onClickListener;
    }

    public void showTip(View view) {
        Context context;
        if (view != null && (context = view.getContext()) != null && (context instanceof Activity)) {
            if (this.abe == null) {
                this.abe = (RelativeLayout) ((Activity) context).findViewById(d.g.pb_layout);
            }
            if (this.abe != null) {
                view.getLocationOnScreen(this.fqH);
                int dip2px = l.dip2px(context, 160.0f);
                int dip2px2 = l.dip2px(context, 36.0f);
                if (this.fqI == null) {
                    this.fqI = new GodReplyLeaderboardTipView(context);
                }
                this.fqI.animate().cancel();
                this.fqI.setAlpha(0.0f);
                this.fqI.animate().alpha(1.0f).setListener(null).start();
                this.fqI.setOnClickListener(this.aGc);
                this.fqI.onChangeSkinType(this.ayX);
                if (this.fqI.getParent() != null && this.fqI.getParent() != this.abe) {
                    ((ViewGroup) this.fqI.getParent()).removeView(this.fqI);
                }
                if (this.fqI.getParent() == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px, dip2px2);
                    layoutParams.rightMargin = bZ(context);
                    layoutParams.topMargin = this.fqH[1] + view.getHeight() + bY(context);
                    layoutParams.addRule(11);
                    int childCount = this.abe.getChildCount();
                    int i = -1;
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = this.abe.getChildAt(i2);
                        if (childAt != null && childAt.getId() == d.g.new_pb_list) {
                            i = i2 + 1;
                        }
                    }
                    if (i > -1 && i <= this.abe.getChildCount()) {
                        this.abe.addView(this.fqI, i, layoutParams);
                    }
                }
                this.fqI.setVisibility(0);
            }
        }
    }

    public void hideTip() {
        if (this.fqI != null) {
            this.fqI.animate().cancel();
            this.fqI.animate().alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.pb.godreply.usertips.a.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    a.this.bbC();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    a.this.bbC();
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbC() {
        if (this.fqI != null && this.fqI.getParent() != null && this.fqI.getParent() == this.abe) {
            this.fqI.setVisibility(4);
        }
    }

    public void aX(View view) {
        if (bbD()) {
            Context context = view.getContext();
            view.getLocationOnScreen(this.fqH);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fqI.getLayoutParams();
            layoutParams.rightMargin = bZ(context);
            layoutParams.topMargin = this.fqH[1] + view.getHeight() + bY(context);
            layoutParams.addRule(11);
            this.fqI.setLayoutParams(layoutParams);
            if (layoutParams.topMargin + this.fqI.getHeight() < l.al(context)[1] && !this.fqL) {
                b.u(context, true);
                this.fqL = true;
                this.fqI.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.usertips.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.hideTip();
                    }
                }, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
        }
    }

    public boolean bbD() {
        return this.fqI != null && this.fqI.getParent() != null && this.fqI.getParent() == this.abe && this.fqI.getVisibility() == 0;
    }

    public void onChangeSkinType(int i) {
        this.ayX = i;
        if (this.fqI != null) {
            this.fqI.onChangeSkinType(i);
        }
    }

    private int bY(Context context) {
        if (this.fqJ == Integer.MIN_VALUE) {
            this.fqJ = -l.dip2px(context, 5.0f);
        }
        return this.fqJ;
    }

    private int bZ(Context context) {
        if (this.fqK == Integer.MIN_VALUE) {
            this.fqK = l.dip2px(context, 17.0f);
        }
        return this.fqK;
    }
}

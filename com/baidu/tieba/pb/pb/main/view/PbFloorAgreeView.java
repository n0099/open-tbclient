package com.baidu.tieba.pb.pb.main.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class PbFloorAgreeView extends LinearLayout {
    private ImageView exc;
    private TextView exd;
    private boolean exe;
    private ScaleAnimation exf;

    public PbFloorAgreeView(Context context) {
        super(context);
        this.exe = false;
        init();
    }

    public PbFloorAgreeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.exe = false;
        init();
    }

    public PbFloorAgreeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.exe = false;
        init();
    }

    public void init() {
        Context context = getContext();
        this.exd = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, com.baidu.adp.lib.util.k.g(context, w.f.ds48));
        layoutParams.topMargin = com.baidu.adp.lib.util.k.g(context, w.f.ds12);
        this.exd.setLayoutParams(layoutParams);
        this.exd.setTextSize(0, com.baidu.adp.lib.util.k.g(context, w.f.fontsize24));
        this.exd.setGravity(17);
        aq.i(this.exd, w.e.cp_cont_d);
        addView(this.exd);
        this.exc = new ImageView(context);
        aq.c(this.exc, w.g.icon_floor_praise_n);
        this.exc.setPadding(com.baidu.adp.lib.util.k.g(context, w.f.ds6), com.baidu.adp.lib.util.k.g(context, w.f.ds12), com.baidu.adp.lib.util.k.g(context, w.f.ds18), 0);
        addView(this.exc);
    }

    public void a(boolean z, long j, boolean z2) {
        if (this.exe != z) {
            this.exe = z;
            onChangeSkinType();
        }
        this.exd.setText(au.v(j));
        if (z2) {
            this.exc.startAnimation(getScaleAnimation());
        }
    }

    private Animation getScaleAnimation() {
        if (this.exf == null) {
            this.exf = new ScaleAnimation(1.4f, 1.0f, 1.4f, 1.0f, 1, 0.5f, 1, 1.0f);
            this.exf.setDuration(200L);
        }
        return this.exf;
    }

    public void onChangeSkinType() {
        if (this.exe) {
            aq.c(this.exc, w.g.icon_floor_praised);
            aq.i(this.exd, w.e.cp_cont_h);
            return;
        }
        aq.c(this.exc, w.g.icon_floor_praise_n);
        aq.i(this.exd, w.e.cp_cont_f);
    }
}

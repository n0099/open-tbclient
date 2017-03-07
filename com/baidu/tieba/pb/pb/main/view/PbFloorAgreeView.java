package com.baidu.tieba.pb.pb.main.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class PbFloorAgreeView extends LinearLayout {
    private ImageView etW;
    private TextView etX;
    private boolean etY;
    private ScaleAnimation etZ;
    private Context mContext;

    public PbFloorAgreeView(Context context) {
        super(context);
        this.etY = false;
        this.mContext = context;
        init();
    }

    public PbFloorAgreeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.etY = false;
        this.mContext = context;
        init();
    }

    public PbFloorAgreeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.etY = false;
        this.mContext = context;
        init();
    }

    public void init() {
        this.etW = new ImageView(this.mContext);
        aq.c(this.etW, w.g.icon_hand_n);
        this.etW.setPadding(com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds5), com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds30), com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds4), 0);
        addView(this.etW);
        this.etX = new TextView(this.mContext);
        aq.i((View) this.etX, w.e.cp_cont_d);
        this.etX.setPadding(0, com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds30), com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds20), 0);
        this.etX.setTextSize(0, com.baidu.adp.lib.util.k.g(this.mContext, w.f.fontsize24));
        this.etX.setText("0");
        addView(this.etX);
        this.etZ = new ScaleAnimation(1.4f, 1.0f, 1.4f, 1.0f, 1, 0.5f, 1, 1.0f);
        this.etZ.setDuration(200L);
    }

    public void a(boolean z, long j, boolean z2) {
        if (this.etY != z) {
            this.etY = z;
            if (this.etY) {
                aq.c(this.etW, w.g.icon_hand_s);
            } else {
                aq.c(this.etW, w.g.icon_hand_n);
            }
        }
        this.etX.setText(au.u(j));
        if (z2) {
            this.etW.startAnimation(this.etZ);
        }
    }

    public void tD() {
        if (this.etY) {
            aq.c(this.etW, w.g.icon_hand_s);
        } else {
            aq.c(this.etW, w.g.icon_hand_n);
        }
        aq.i((View) this.etX, w.e.cp_cont_d);
    }
}

package com.baidu.tieba.pb.pb.main.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class PbFloorAgreeView extends LinearLayout {
    private ImageView erZ;
    private TextView esa;
    private boolean esb;
    private ScaleAnimation esc;
    private Context mContext;

    public PbFloorAgreeView(Context context) {
        super(context);
        this.esb = false;
        this.mContext = context;
        init();
    }

    public PbFloorAgreeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.esb = false;
        this.mContext = context;
        init();
    }

    public PbFloorAgreeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.esb = false;
        this.mContext = context;
        init();
    }

    public void init() {
        this.erZ = new ImageView(this.mContext);
        aq.c(this.erZ, w.g.icon_hand_n);
        this.erZ.setPadding(com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds5), com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds30), com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds4), 0);
        addView(this.erZ);
        this.esa = new TextView(this.mContext);
        aq.i(this.esa, w.e.cp_cont_d);
        this.esa.setPadding(0, com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds30), com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds20), 0);
        this.esa.setTextSize(0, com.baidu.adp.lib.util.k.g(this.mContext, w.f.fontsize24));
        this.esa.setText("0");
        addView(this.esa);
        this.esc = new ScaleAnimation(1.4f, 1.0f, 1.4f, 1.0f, 1, 0.5f, 1, 1.0f);
        this.esc.setDuration(200L);
    }

    public void a(boolean z, long j, boolean z2) {
        if (this.esb != z) {
            this.esb = z;
            if (this.esb) {
                aq.c(this.erZ, w.g.icon_hand_s);
            } else {
                aq.c(this.erZ, w.g.icon_hand_n);
            }
        }
        this.esa.setText(au.u(j));
        if (z2) {
            this.erZ.startAnimation(this.esc);
        }
    }

    public void onChangeSkinType() {
        if (this.esb) {
            aq.c(this.erZ, w.g.icon_hand_s);
        } else {
            aq.c(this.erZ, w.g.icon_hand_n);
        }
        aq.i(this.esa, w.e.cp_cont_d);
    }
}

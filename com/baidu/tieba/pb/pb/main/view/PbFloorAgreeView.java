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
    private ImageView eur;
    private TextView eus;
    private boolean eut;
    private ScaleAnimation euu;
    private Context mContext;

    public PbFloorAgreeView(Context context) {
        super(context);
        this.eut = false;
        this.mContext = context;
        init();
    }

    public PbFloorAgreeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eut = false;
        this.mContext = context;
        init();
    }

    public PbFloorAgreeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eut = false;
        this.mContext = context;
        init();
    }

    public void init() {
        this.eur = new ImageView(this.mContext);
        aq.c(this.eur, w.g.icon_hand_n);
        this.eur.setPadding(com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds5), com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds30), com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds4), 0);
        addView(this.eur);
        this.eus = new TextView(this.mContext);
        aq.i(this.eus, w.e.cp_cont_d);
        this.eus.setPadding(0, com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds30), com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds20), 0);
        this.eus.setTextSize(0, com.baidu.adp.lib.util.k.g(this.mContext, w.f.fontsize24));
        this.eus.setText("0");
        addView(this.eus);
        this.euu = new ScaleAnimation(1.4f, 1.0f, 1.4f, 1.0f, 1, 0.5f, 1, 1.0f);
        this.euu.setDuration(200L);
    }

    public void a(boolean z, long j, boolean z2) {
        if (this.eut != z) {
            this.eut = z;
            if (this.eut) {
                aq.c(this.eur, w.g.icon_hand_s);
            } else {
                aq.c(this.eur, w.g.icon_hand_n);
            }
        }
        this.eus.setText(au.u(j));
        if (z2) {
            this.eur.startAnimation(this.euu);
        }
    }

    public void onChangeSkinType() {
        if (this.eut) {
            aq.c(this.eur, w.g.icon_hand_s);
        } else {
            aq.c(this.eur, w.g.icon_hand_n);
        }
        aq.i(this.eus, w.e.cp_cont_d);
    }
}

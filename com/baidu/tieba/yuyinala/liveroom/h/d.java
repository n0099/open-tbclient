package com.baidu.tieba.yuyinala.liveroom.h;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.live.sdk.a;
import com.baidu.live.tieba.view.BarImageView;
import com.baidu.live.view.AlaLoadingButton;
/* loaded from: classes11.dex */
public class d extends a {
    private TextView aYt;
    private View cBE;
    private TextView hEU;
    private BarImageView ovV;
    private AlaLoadingButton ovW;

    public d(@NonNull Context context) {
        super(context);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.h.a
    public void init() {
        super.init();
        ED();
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.h.a
    public void initView() {
        setContentView(a.g.ala_yuyin_guide_follow_float);
        this.cBE = findViewById(a.f.layout_root);
        this.cBE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.h.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.dismiss();
            }
        });
        this.aYt = (TextView) findViewById(a.f.tv_guide_folllow_tip);
        this.ovV = (BarImageView) findViewById(a.f.iv_avatar);
        this.hEU = (TextView) findViewById(a.f.ala_live_name);
        this.ovV.setShowOval(true);
        this.ovV.setBorderColor(getContext().getResources().getColor(a.c.sdk_cp_bg_line_k_alpha10_1));
        this.ovV.setAutoChangeStyle(false);
        this.ovW = (AlaLoadingButton) findViewById(a.f.tv_confirm);
        this.ovW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.h.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.ovN != null) {
                    d.this.ovN.onConfirm();
                }
            }
        });
        this.hEE = this.ovW.getText().toString();
        cgb();
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.h.a
    public void LX(int i) {
        if (this.ovW != null) {
            this.ovW.setStatus(i);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.h.a
    public void o(String str, String str2, String str3) {
        cga();
        this.ovV.startLoad(str, 25, false, false);
        this.hEU.setText(str2);
        if (!TextUtils.isEmpty(str3)) {
            this.aYt.setText(str3);
        }
        LN();
        show();
    }

    private void cgb() {
        if (com.baidu.live.ae.a.Qj().buX != null && com.baidu.live.ae.a.Qj().buX.aMM == null) {
        }
    }

    private void ED() {
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.h.d.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                d.this.cga();
            }
        });
    }

    private void LN() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setDuration(400L);
        translateAnimation.setInterpolator(new LinearInterpolator());
        this.cBE.startAnimation(translateAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cga() {
        if (this.ovV != null) {
            this.ovV.stopLoad();
        }
    }
}

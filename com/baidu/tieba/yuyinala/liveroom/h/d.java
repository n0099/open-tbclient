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
    private TextView hEG;
    private BarImageView ovv;
    private AlaLoadingButton ovw;

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
        this.ovv = (BarImageView) findViewById(a.f.iv_avatar);
        this.hEG = (TextView) findViewById(a.f.ala_live_name);
        this.ovv.setShowOval(true);
        this.ovv.setBorderColor(getContext().getResources().getColor(a.c.sdk_cp_bg_line_k_alpha10_1));
        this.ovv.setAutoChangeStyle(false);
        this.ovw = (AlaLoadingButton) findViewById(a.f.tv_confirm);
        this.ovw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.h.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.ovn != null) {
                    d.this.ovn.onConfirm();
                }
            }
        });
        this.hEq = this.ovw.getText().toString();
        cfU();
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.h.a
    public void LW(int i) {
        if (this.ovw != null) {
            this.ovw.setStatus(i);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.h.a
    public void o(String str, String str2, String str3) {
        cfT();
        this.ovv.startLoad(str, 25, false, false);
        this.hEG.setText(str2);
        if (!TextUtils.isEmpty(str3)) {
            this.aYt.setText(str3);
        }
        LN();
        show();
    }

    private void cfU() {
        if (com.baidu.live.ae.a.Qj().buX != null && com.baidu.live.ae.a.Qj().buX.aMM == null) {
        }
    }

    private void ED() {
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.h.d.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                d.this.cfT();
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
    public void cfT() {
        if (this.ovv != null) {
            this.ovv.stopLoad();
        }
    }
}

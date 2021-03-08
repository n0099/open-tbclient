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
/* loaded from: classes10.dex */
public class d extends a {
    private TextView aZT;
    private View cDe;
    private TextView hGD;
    private BarImageView oya;
    private AlaLoadingButton oyb;

    public d(@NonNull Context context) {
        super(context);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.h.a
    public void init() {
        super.init();
        EG();
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.h.a
    public void initView() {
        setContentView(a.g.ala_yuyin_guide_follow_float);
        this.cDe = findViewById(a.f.layout_root);
        this.cDe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.h.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.dismiss();
            }
        });
        this.aZT = (TextView) findViewById(a.f.tv_guide_folllow_tip);
        this.oya = (BarImageView) findViewById(a.f.iv_avatar);
        this.hGD = (TextView) findViewById(a.f.ala_live_name);
        this.oya.setShowOval(true);
        this.oya.setBorderColor(getContext().getResources().getColor(a.c.sdk_cp_bg_line_k_alpha10_1));
        this.oya.setAutoChangeStyle(false);
        this.oyb = (AlaLoadingButton) findViewById(a.f.tv_confirm);
        this.oyb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.h.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.oxS != null) {
                    d.this.oxS.onConfirm();
                }
            }
        });
        this.hGn = this.oyb.getText().toString();
        cgh();
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.h.a
    public void Mb(int i) {
        if (this.oyb != null) {
            this.oyb.setStatus(i);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.h.a
    public void o(String str, String str2, String str3) {
        cgg();
        this.oya.startLoad(str, 25, false, false);
        this.hGD.setText(str2);
        if (!TextUtils.isEmpty(str3)) {
            this.aZT.setText(str3);
        }
        LQ();
        show();
    }

    private void cgh() {
        if (com.baidu.live.ae.a.Qm().bwx != null && com.baidu.live.ae.a.Qm().bwx.aOm == null) {
        }
    }

    private void EG() {
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.h.d.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                d.this.cgg();
            }
        });
    }

    private void LQ() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setDuration(400L);
        translateAnimation.setInterpolator(new LinearInterpolator());
        this.cDe.startAnimation(translateAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgg() {
        if (this.oya != null) {
            this.oya.stopLoad();
        }
    }
}

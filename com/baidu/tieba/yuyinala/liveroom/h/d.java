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
    private TextView aVl;
    private View czi;
    private TextView hAw;
    private BarImageView olD;
    private AlaLoadingButton olE;

    public d(@NonNull Context context) {
        super(context);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.h.a
    public void init() {
        super.init();
        Dn();
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.h.a
    public void initView() {
        setContentView(a.g.ala_yuyin_guide_follow_float);
        this.czi = findViewById(a.f.layout_root);
        this.czi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.h.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.dismiss();
            }
        });
        this.aVl = (TextView) findViewById(a.f.tv_guide_folllow_tip);
        this.olD = (BarImageView) findViewById(a.f.iv_avatar);
        this.hAw = (TextView) findViewById(a.f.ala_live_name);
        this.olD.setShowOval(true);
        this.olD.setBorderColor(getContext().getResources().getColor(a.c.sdk_cp_bg_line_k_alpha10_1));
        this.olD.setAutoChangeStyle(false);
        this.olE = (AlaLoadingButton) findViewById(a.f.tv_confirm);
        this.olE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.h.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.olv != null) {
                    d.this.olv.onConfirm();
                }
            }
        });
        this.hAg = this.olE.getText().toString();
        cfb();
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.h.a
    public void LB(int i) {
        if (this.olE != null) {
            this.olE.setStatus(i);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.h.a
    public void o(String str, String str2, String str3) {
        cfa();
        this.olD.startLoad(str, 25, false, false);
        this.hAw.setText(str2);
        if (!TextUtils.isEmpty(str3)) {
            this.aVl.setText(str3);
        }
        Ko();
        show();
    }

    private void cfb() {
        if (com.baidu.live.af.a.OJ().bru != null && com.baidu.live.af.a.OJ().bru.aJZ == null) {
        }
    }

    private void Dn() {
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.h.d.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                d.this.cfa();
            }
        });
    }

    private void Ko() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setDuration(400L);
        translateAnimation.setInterpolator(new LinearInterpolator());
        this.czi.startAnimation(translateAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfa() {
        if (this.olD != null) {
            this.olD.stopLoad();
        }
    }
}

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
    private TextView aZY;
    private View cDU;
    private TextView hFc;
    private BarImageView oqj;
    private AlaLoadingButton oqk;

    public d(@NonNull Context context) {
        super(context);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.h.a
    public void init() {
        super.init();
        Hi();
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.h.a
    public void initView() {
        setContentView(a.g.ala_yuyin_guide_follow_float);
        this.cDU = findViewById(a.f.layout_root);
        this.cDU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.h.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.dismiss();
            }
        });
        this.aZY = (TextView) findViewById(a.f.tv_guide_folllow_tip);
        this.oqj = (BarImageView) findViewById(a.f.iv_avatar);
        this.hFc = (TextView) findViewById(a.f.ala_live_name);
        this.oqj.setShowOval(true);
        this.oqj.setBorderColor(getContext().getResources().getColor(a.c.sdk_cp_bg_line_k_alpha10_1));
        this.oqj.setAutoChangeStyle(false);
        this.oqk = (AlaLoadingButton) findViewById(a.f.tv_confirm);
        this.oqk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.h.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.oqb != null) {
                    d.this.oqb.onConfirm();
                }
            }
        });
        this.hEM = this.oqk.getText().toString();
        ciT();
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.h.a
    public void Ni(int i) {
        if (this.oqk != null) {
            this.oqk.setStatus(i);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.h.a
    public void p(String str, String str2, String str3) {
        ciS();
        this.oqj.startLoad(str, 25, false, false);
        this.hFc.setText(str2);
        if (!TextUtils.isEmpty(str3)) {
            this.aZY.setText(str3);
        }
        Oj();
        show();
    }

    private void ciT() {
        if (com.baidu.live.af.a.SE().bwi != null && com.baidu.live.af.a.SE().bwi.aOM == null) {
        }
    }

    private void Hi() {
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.h.d.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                d.this.ciS();
            }
        });
    }

    private void Oj() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setDuration(400L);
        translateAnimation.setInterpolator(new LinearInterpolator());
        this.cDU.startAnimation(translateAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ciS() {
        if (this.oqj != null) {
            this.oqj.stopLoad();
        }
    }
}

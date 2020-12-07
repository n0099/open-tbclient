package com.baidu.yuyinala.privatemessage.implugin.ui.material.a;

import android.app.Dialog;
import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class d extends Dialog {
    private Animation oSm;

    public d(Context context) {
        super(context, a.i.CustomProgressDialog);
        setCanceledOnTouchOutside(false);
        setContentView(a.g.bd_im_syncwaitdialog);
        getWindow().getAttributes().gravity = 17;
        getWindow().setDimAmount(0.0f);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        ImageView imageView = (ImageView) findViewById(a.f.loadingImageView);
        this.oSm = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
        this.oSm.setRepeatMode(-1);
        this.oSm.setRepeatCount(-1);
        this.oSm.setDuration(1500L);
        imageView.startAnimation(this.oSm);
    }

    public void setMessage(String str) {
        TextView textView = (TextView) findViewById(a.f.id_tv_loadingmsg);
        if (textView != null) {
            textView.setText(str);
        }
    }
}

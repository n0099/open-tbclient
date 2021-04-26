package com.baidu.wallet.lightapp.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.ResUtils;
/* loaded from: classes5.dex */
public class LoadingDialogForLightApp extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    public TextView f25762a;

    /* renamed from: b  reason: collision with root package name */
    public ProgressBar f25763b;

    /* renamed from: c  reason: collision with root package name */
    public String f25764c;

    /* renamed from: d  reason: collision with root package name */
    public Context f25765d;

    public LoadingDialogForLightApp(Context context) {
        super(context, ResUtils.style(context, "LoadingDialog"));
        this.f25765d = null;
        this.f25765d = context;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(ResUtils.layout(this.f25765d, "wallet_base_loading_dialog_for_light_app"));
        this.f25762a = (TextView) findViewById(ResUtils.id(this.f25765d, "dialog_msg"));
        this.f25763b = (ProgressBar) findViewById(ResUtils.id(this.f25765d, "progress_bar"));
        if (!TextUtils.isEmpty(this.f25764c)) {
            this.f25762a.setText(this.f25764c);
        }
        if (!TextUtils.isEmpty(GlobalUtils.showStr)) {
            this.f25762a.setText(GlobalUtils.showStr);
        }
        setCanceledOnTouchOutside(false);
        setCancelable(true);
    }

    public void setMessage(int i2) {
        TextView textView = this.f25762a;
        if (textView == null) {
            return;
        }
        textView.setText(i2);
    }

    public void setMessage(String str) {
        TextView textView = this.f25762a;
        if (textView == null) {
            return;
        }
        textView.setText(str);
    }

    public LoadingDialogForLightApp(Context context, String str) {
        super(context, ResUtils.style(context, "LoadingDialog"));
        this.f25765d = null;
        this.f25764c = str;
        this.f25765d = context;
    }

    public LoadingDialogForLightApp(Context context, int i2) {
        super(context, i2);
        this.f25765d = null;
    }
}

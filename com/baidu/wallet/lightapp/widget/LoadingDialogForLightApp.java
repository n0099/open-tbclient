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
    public TextView f24936a;

    /* renamed from: b  reason: collision with root package name */
    public ProgressBar f24937b;

    /* renamed from: c  reason: collision with root package name */
    public String f24938c;

    /* renamed from: d  reason: collision with root package name */
    public Context f24939d;

    public LoadingDialogForLightApp(Context context) {
        super(context, ResUtils.style(context, "LoadingDialog"));
        this.f24939d = null;
        this.f24939d = context;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(ResUtils.layout(this.f24939d, "wallet_base_loading_dialog_for_light_app"));
        this.f24936a = (TextView) findViewById(ResUtils.id(this.f24939d, "dialog_msg"));
        this.f24937b = (ProgressBar) findViewById(ResUtils.id(this.f24939d, "progress_bar"));
        if (!TextUtils.isEmpty(this.f24938c)) {
            this.f24936a.setText(this.f24938c);
        }
        if (!TextUtils.isEmpty(GlobalUtils.showStr)) {
            this.f24936a.setText(GlobalUtils.showStr);
        }
        setCanceledOnTouchOutside(false);
        setCancelable(true);
    }

    public void setMessage(int i2) {
        TextView textView = this.f24936a;
        if (textView == null) {
            return;
        }
        textView.setText(i2);
    }

    public void setMessage(String str) {
        TextView textView = this.f24936a;
        if (textView == null) {
            return;
        }
        textView.setText(str);
    }

    public LoadingDialogForLightApp(Context context, String str) {
        super(context, ResUtils.style(context, "LoadingDialog"));
        this.f24939d = null;
        this.f24938c = str;
        this.f24939d = context;
    }

    public LoadingDialogForLightApp(Context context, int i2) {
        super(context, i2);
        this.f24939d = null;
    }
}

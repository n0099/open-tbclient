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
    public TextView f25121a;

    /* renamed from: b  reason: collision with root package name */
    public ProgressBar f25122b;

    /* renamed from: c  reason: collision with root package name */
    public String f25123c;

    /* renamed from: d  reason: collision with root package name */
    public Context f25124d;

    public LoadingDialogForLightApp(Context context) {
        super(context, ResUtils.style(context, "LoadingDialog"));
        this.f25124d = null;
        this.f25124d = context;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(ResUtils.layout(this.f25124d, "wallet_base_loading_dialog_for_light_app"));
        this.f25121a = (TextView) findViewById(ResUtils.id(this.f25124d, "dialog_msg"));
        this.f25122b = (ProgressBar) findViewById(ResUtils.id(this.f25124d, "progress_bar"));
        if (!TextUtils.isEmpty(this.f25123c)) {
            this.f25121a.setText(this.f25123c);
        }
        if (!TextUtils.isEmpty(GlobalUtils.showStr)) {
            this.f25121a.setText(GlobalUtils.showStr);
        }
        setCanceledOnTouchOutside(false);
        setCancelable(true);
    }

    public void setMessage(int i2) {
        TextView textView = this.f25121a;
        if (textView == null) {
            return;
        }
        textView.setText(i2);
    }

    public void setMessage(String str) {
        TextView textView = this.f25121a;
        if (textView == null) {
            return;
        }
        textView.setText(str);
    }

    public LoadingDialogForLightApp(Context context, String str) {
        super(context, ResUtils.style(context, "LoadingDialog"));
        this.f25124d = null;
        this.f25123c = str;
        this.f25124d = context;
    }

    public LoadingDialogForLightApp(Context context, int i2) {
        super(context, i2);
        this.f25124d = null;
    }
}

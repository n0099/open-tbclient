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
    public TextView f24988a;

    /* renamed from: b  reason: collision with root package name */
    public ProgressBar f24989b;

    /* renamed from: c  reason: collision with root package name */
    public String f24990c;

    /* renamed from: d  reason: collision with root package name */
    public Context f24991d;

    public LoadingDialogForLightApp(Context context) {
        super(context, ResUtils.style(context, "LoadingDialog"));
        this.f24991d = null;
        this.f24991d = context;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(ResUtils.layout(this.f24991d, "wallet_base_loading_dialog_for_light_app"));
        this.f24988a = (TextView) findViewById(ResUtils.id(this.f24991d, "dialog_msg"));
        this.f24989b = (ProgressBar) findViewById(ResUtils.id(this.f24991d, "progress_bar"));
        if (!TextUtils.isEmpty(this.f24990c)) {
            this.f24988a.setText(this.f24990c);
        }
        if (!TextUtils.isEmpty(GlobalUtils.showStr)) {
            this.f24988a.setText(GlobalUtils.showStr);
        }
        setCanceledOnTouchOutside(false);
        setCancelable(true);
    }

    public void setMessage(int i) {
        TextView textView = this.f24988a;
        if (textView == null) {
            return;
        }
        textView.setText(i);
    }

    public void setMessage(String str) {
        TextView textView = this.f24988a;
        if (textView == null) {
            return;
        }
        textView.setText(str);
    }

    public LoadingDialogForLightApp(Context context, String str) {
        super(context, ResUtils.style(context, "LoadingDialog"));
        this.f24991d = null;
        this.f24990c = str;
        this.f24991d = context;
    }

    public LoadingDialogForLightApp(Context context, int i) {
        super(context, i);
        this.f24991d = null;
    }
}

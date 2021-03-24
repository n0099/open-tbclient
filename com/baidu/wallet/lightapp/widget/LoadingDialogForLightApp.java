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
    public TextView f25302a;

    /* renamed from: b  reason: collision with root package name */
    public ProgressBar f25303b;

    /* renamed from: c  reason: collision with root package name */
    public String f25304c;

    /* renamed from: d  reason: collision with root package name */
    public Context f25305d;

    public LoadingDialogForLightApp(Context context) {
        super(context, ResUtils.style(context, "LoadingDialog"));
        this.f25305d = null;
        this.f25305d = context;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(ResUtils.layout(this.f25305d, "wallet_base_loading_dialog_for_light_app"));
        this.f25302a = (TextView) findViewById(ResUtils.id(this.f25305d, "dialog_msg"));
        this.f25303b = (ProgressBar) findViewById(ResUtils.id(this.f25305d, "progress_bar"));
        if (!TextUtils.isEmpty(this.f25304c)) {
            this.f25302a.setText(this.f25304c);
        }
        if (!TextUtils.isEmpty(GlobalUtils.showStr)) {
            this.f25302a.setText(GlobalUtils.showStr);
        }
        setCanceledOnTouchOutside(false);
        setCancelable(true);
    }

    public void setMessage(int i) {
        TextView textView = this.f25302a;
        if (textView == null) {
            return;
        }
        textView.setText(i);
    }

    public void setMessage(String str) {
        TextView textView = this.f25302a;
        if (textView == null) {
            return;
        }
        textView.setText(str);
    }

    public LoadingDialogForLightApp(Context context, String str) {
        super(context, ResUtils.style(context, "LoadingDialog"));
        this.f25305d = null;
        this.f25304c = str;
        this.f25305d = context;
    }

    public LoadingDialogForLightApp(Context context, int i) {
        super(context, i);
        this.f25305d = null;
    }
}

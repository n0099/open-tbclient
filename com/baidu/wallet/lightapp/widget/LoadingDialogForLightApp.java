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
    public TextView f24996a;

    /* renamed from: b  reason: collision with root package name */
    public ProgressBar f24997b;

    /* renamed from: c  reason: collision with root package name */
    public String f24998c;

    /* renamed from: d  reason: collision with root package name */
    public Context f24999d;

    public LoadingDialogForLightApp(Context context) {
        super(context, ResUtils.style(context, "LoadingDialog"));
        this.f24999d = null;
        this.f24999d = context;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(ResUtils.layout(this.f24999d, "wallet_base_loading_dialog_for_light_app"));
        this.f24996a = (TextView) findViewById(ResUtils.id(this.f24999d, "dialog_msg"));
        this.f24997b = (ProgressBar) findViewById(ResUtils.id(this.f24999d, "progress_bar"));
        if (!TextUtils.isEmpty(this.f24998c)) {
            this.f24996a.setText(this.f24998c);
        }
        if (!TextUtils.isEmpty(GlobalUtils.showStr)) {
            this.f24996a.setText(GlobalUtils.showStr);
        }
        setCanceledOnTouchOutside(false);
        setCancelable(true);
    }

    public void setMessage(int i) {
        TextView textView = this.f24996a;
        if (textView == null) {
            return;
        }
        textView.setText(i);
    }

    public void setMessage(String str) {
        TextView textView = this.f24996a;
        if (textView == null) {
            return;
        }
        textView.setText(str);
    }

    public LoadingDialogForLightApp(Context context, String str) {
        super(context, ResUtils.style(context, "LoadingDialog"));
        this.f24999d = null;
        this.f24998c = str;
        this.f24999d = context;
    }

    public LoadingDialogForLightApp(Context context, int i) {
        super(context, i);
        this.f24999d = null;
    }
}

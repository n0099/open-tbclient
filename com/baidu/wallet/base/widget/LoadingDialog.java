package com.baidu.wallet.base.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
/* loaded from: classes5.dex */
public class LoadingDialog extends Dialog {

    /* renamed from: c  reason: collision with root package name */
    public static final String f23631c = "LoadingDialog";

    /* renamed from: a  reason: collision with root package name */
    public TextView f23632a;

    /* renamed from: b  reason: collision with root package name */
    public String f23633b;

    /* renamed from: d  reason: collision with root package name */
    public Context f23634d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f23635e;

    public LoadingDialog(Context context) {
        super(context, ResUtils.style(context, "EbpayPromptDialog"));
        this.f23634d = null;
        this.f23634d = context;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(ResUtils.layout(this.f23634d, "wallet_base_layout_loading"));
        this.f23632a = (TextView) findViewById(ResUtils.id(this.f23634d, "dialog_msg"));
        if (!TextUtils.isEmpty(this.f23633b)) {
            this.f23632a.setText(this.f23633b);
        }
        if (!TextUtils.isEmpty(WalletGlobalUtils.showStr)) {
            this.f23632a.setText(WalletGlobalUtils.showStr);
        }
        ImageView imageView = (ImageView) findViewById(ResUtils.id(this.f23634d, "img_anim"));
        this.f23635e = imageView;
        AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getDrawable();
        animationDrawable.stop();
        animationDrawable.start();
        setCanceledOnTouchOutside(false);
        setCancelable(false);
    }

    public void setMessage(int i2) {
        TextView textView = this.f23632a;
        if (textView == null) {
            return;
        }
        textView.setText(i2);
    }

    public void setMessage(String str) {
        TextView textView = this.f23632a;
        if (textView == null) {
            return;
        }
        textView.setText(str);
    }

    public LoadingDialog(Context context, String str) {
        super(context, ResUtils.style(context, "EbpayPromptDialog"));
        this.f23634d = null;
        this.f23633b = str;
        this.f23634d = context;
    }

    public LoadingDialog(Context context, int i2) {
        super(context, i2);
        this.f23634d = null;
    }
}

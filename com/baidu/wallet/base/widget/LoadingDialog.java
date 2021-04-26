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
    public static final String f24272c = "LoadingDialog";

    /* renamed from: a  reason: collision with root package name */
    public TextView f24273a;

    /* renamed from: b  reason: collision with root package name */
    public String f24274b;

    /* renamed from: d  reason: collision with root package name */
    public Context f24275d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f24276e;

    public LoadingDialog(Context context) {
        super(context, ResUtils.style(context, "EbpayPromptDialog"));
        this.f24275d = null;
        this.f24275d = context;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(ResUtils.layout(this.f24275d, "wallet_base_layout_loading"));
        this.f24273a = (TextView) findViewById(ResUtils.id(this.f24275d, "dialog_msg"));
        if (!TextUtils.isEmpty(this.f24274b)) {
            this.f24273a.setText(this.f24274b);
        }
        if (!TextUtils.isEmpty(WalletGlobalUtils.showStr)) {
            this.f24273a.setText(WalletGlobalUtils.showStr);
        }
        ImageView imageView = (ImageView) findViewById(ResUtils.id(this.f24275d, "img_anim"));
        this.f24276e = imageView;
        AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getDrawable();
        animationDrawable.stop();
        animationDrawable.start();
        setCanceledOnTouchOutside(false);
        setCancelable(false);
    }

    public void setMessage(int i2) {
        TextView textView = this.f24273a;
        if (textView == null) {
            return;
        }
        textView.setText(i2);
    }

    public void setMessage(String str) {
        TextView textView = this.f24273a;
        if (textView == null) {
            return;
        }
        textView.setText(str);
    }

    public LoadingDialog(Context context, String str) {
        super(context, ResUtils.style(context, "EbpayPromptDialog"));
        this.f24275d = null;
        this.f24274b = str;
        this.f24275d = context;
    }

    public LoadingDialog(Context context, int i2) {
        super(context, i2);
        this.f24275d = null;
    }
}

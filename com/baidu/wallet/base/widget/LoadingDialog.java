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
    public static final String f23850c = "LoadingDialog";

    /* renamed from: a  reason: collision with root package name */
    public TextView f23851a;

    /* renamed from: b  reason: collision with root package name */
    public String f23852b;

    /* renamed from: d  reason: collision with root package name */
    public Context f23853d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f23854e;

    public LoadingDialog(Context context) {
        super(context, ResUtils.style(context, "EbpayPromptDialog"));
        this.f23853d = null;
        this.f23853d = context;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(ResUtils.layout(this.f23853d, "wallet_base_layout_loading"));
        this.f23851a = (TextView) findViewById(ResUtils.id(this.f23853d, "dialog_msg"));
        if (!TextUtils.isEmpty(this.f23852b)) {
            this.f23851a.setText(this.f23852b);
        }
        if (!TextUtils.isEmpty(WalletGlobalUtils.showStr)) {
            this.f23851a.setText(WalletGlobalUtils.showStr);
        }
        ImageView imageView = (ImageView) findViewById(ResUtils.id(this.f23853d, "img_anim"));
        this.f23854e = imageView;
        AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getDrawable();
        animationDrawable.stop();
        animationDrawable.start();
        setCanceledOnTouchOutside(false);
        setCancelable(false);
    }

    public void setMessage(int i) {
        TextView textView = this.f23851a;
        if (textView == null) {
            return;
        }
        textView.setText(i);
    }

    public void setMessage(String str) {
        TextView textView = this.f23851a;
        if (textView == null) {
            return;
        }
        textView.setText(str);
    }

    public LoadingDialog(Context context, String str) {
        super(context, ResUtils.style(context, "EbpayPromptDialog"));
        this.f23853d = null;
        this.f23852b = str;
        this.f23853d = context;
    }

    public LoadingDialog(Context context, int i) {
        super(context, i);
        this.f23853d = null;
    }
}

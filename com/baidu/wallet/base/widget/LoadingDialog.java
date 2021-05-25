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
    public static final String f23446c = "LoadingDialog";

    /* renamed from: a  reason: collision with root package name */
    public TextView f23447a;

    /* renamed from: b  reason: collision with root package name */
    public String f23448b;

    /* renamed from: d  reason: collision with root package name */
    public Context f23449d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f23450e;

    public LoadingDialog(Context context) {
        super(context, ResUtils.style(context, "EbpayPromptDialog"));
        this.f23449d = null;
        this.f23449d = context;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(ResUtils.layout(this.f23449d, "wallet_base_layout_loading"));
        this.f23447a = (TextView) findViewById(ResUtils.id(this.f23449d, "dialog_msg"));
        if (!TextUtils.isEmpty(this.f23448b)) {
            this.f23447a.setText(this.f23448b);
        }
        if (!TextUtils.isEmpty(WalletGlobalUtils.showStr)) {
            this.f23447a.setText(WalletGlobalUtils.showStr);
        }
        ImageView imageView = (ImageView) findViewById(ResUtils.id(this.f23449d, "img_anim"));
        this.f23450e = imageView;
        AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getDrawable();
        animationDrawable.stop();
        animationDrawable.start();
        setCanceledOnTouchOutside(false);
        setCancelable(false);
    }

    public void setMessage(int i2) {
        TextView textView = this.f23447a;
        if (textView == null) {
            return;
        }
        textView.setText(i2);
    }

    public void setMessage(String str) {
        TextView textView = this.f23447a;
        if (textView == null) {
            return;
        }
        textView.setText(str);
    }

    public LoadingDialog(Context context, String str) {
        super(context, ResUtils.style(context, "EbpayPromptDialog"));
        this.f23449d = null;
        this.f23448b = str;
        this.f23449d = context;
    }

    public LoadingDialog(Context context, int i2) {
        super(context, i2);
        this.f23449d = null;
    }
}

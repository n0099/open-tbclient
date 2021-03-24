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
    public static final String f23849c = "LoadingDialog";

    /* renamed from: a  reason: collision with root package name */
    public TextView f23850a;

    /* renamed from: b  reason: collision with root package name */
    public String f23851b;

    /* renamed from: d  reason: collision with root package name */
    public Context f23852d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f23853e;

    public LoadingDialog(Context context) {
        super(context, ResUtils.style(context, "EbpayPromptDialog"));
        this.f23852d = null;
        this.f23852d = context;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(ResUtils.layout(this.f23852d, "wallet_base_layout_loading"));
        this.f23850a = (TextView) findViewById(ResUtils.id(this.f23852d, "dialog_msg"));
        if (!TextUtils.isEmpty(this.f23851b)) {
            this.f23850a.setText(this.f23851b);
        }
        if (!TextUtils.isEmpty(WalletGlobalUtils.showStr)) {
            this.f23850a.setText(WalletGlobalUtils.showStr);
        }
        ImageView imageView = (ImageView) findViewById(ResUtils.id(this.f23852d, "img_anim"));
        this.f23853e = imageView;
        AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getDrawable();
        animationDrawable.stop();
        animationDrawable.start();
        setCanceledOnTouchOutside(false);
        setCancelable(false);
    }

    public void setMessage(int i) {
        TextView textView = this.f23850a;
        if (textView == null) {
            return;
        }
        textView.setText(i);
    }

    public void setMessage(String str) {
        TextView textView = this.f23850a;
        if (textView == null) {
            return;
        }
        textView.setText(str);
    }

    public LoadingDialog(Context context, String str) {
        super(context, ResUtils.style(context, "EbpayPromptDialog"));
        this.f23852d = null;
        this.f23851b = str;
        this.f23852d = context;
    }

    public LoadingDialog(Context context, int i) {
        super(context, i);
        this.f23852d = null;
    }
}

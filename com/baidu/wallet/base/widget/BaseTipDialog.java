package com.baidu.wallet.base.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.apollon.utils.ResUtils;
/* loaded from: classes5.dex */
public class BaseTipDialog extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    public LinearLayout f23407a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f23408b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout.LayoutParams f23409c;
    public Context mContext;
    public LayoutInflater mInflater;

    public BaseTipDialog(Context context) {
        super(context, ResUtils.style(context, "EbpayPromptDialog"));
        this.mContext = context;
    }

    public void addContentView(View view) {
        this.f23407a.removeAllViews();
        this.f23407a.addView(view, this.f23409c);
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(ResUtils.layout(this.mContext, "wallet_base_dialog_notitle"));
        if (this.mInflater == null) {
            this.mInflater = LayoutInflater.from(this.mContext);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.f23409c = layoutParams;
        layoutParams.gravity = 17;
        this.f23407a = (LinearLayout) findViewById(ResUtils.id(this.mContext, "ebpay_dialog_content_layout"));
        this.f23408b = (TextView) findViewById(ResUtils.id(this.mContext, "ebpay_dialog_title"));
        findViewById(ResUtils.id(this.mContext, "ebpay_dialog_title_close")).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.base.widget.BaseTipDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BaseTipDialog.this.dismiss();
            }
        });
        findViewById(ResUtils.id(this.mContext, "i_konw_btn")).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.base.widget.BaseTipDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BaseTipDialog.this.dismiss();
            }
        });
        setCancelable(false);
        setCanceledOnTouchOutside(false);
    }

    public void setTitleMessage(int i) {
        TextView textView = this.f23408b;
        if (textView == null) {
            return;
        }
        textView.setText(i);
    }

    public void showCloseBtn(boolean z) {
        View findViewById = findViewById(ResUtils.id(this.mContext, "ebpay_dialog_title_close"));
        if (findViewById != null) {
            findViewById.setVisibility(z ? 0 : 4);
        }
    }

    public BaseTipDialog(Context context, int i) {
        super(context, i);
        this.mContext = context;
    }

    public void setTitleMessage(String str) {
        TextView textView = this.f23408b;
        if (textView == null) {
            return;
        }
        textView.setText(str);
    }
}

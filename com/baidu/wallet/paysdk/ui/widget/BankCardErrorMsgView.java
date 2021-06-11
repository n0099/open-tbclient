package com.baidu.wallet.paysdk.ui.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.apollon.utils.ResUtils;
/* loaded from: classes5.dex */
public class BankCardErrorMsgView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public TextView f26107a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f26108b;

    public BankCardErrorMsgView(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(ResUtils.layout(context, "wallet_cashdesk_bindcard_errormsg_view"), this);
        this.f26107a = (TextView) inflate.findViewById(ResUtils.id(context, "wallet_bindcard_errormsg_tip_name"));
        this.f26108b = (TextView) inflate.findViewById(ResUtils.id(context, "wallet_bindcard_errormsg_tip_value"));
    }

    public void showErrorLayout(CharSequence charSequence, CharSequence charSequence2) {
        TextView textView = this.f26107a;
        TextUtils.isEmpty(charSequence);
        textView.setVisibility(8);
        this.f26107a.setText(charSequence);
        this.f26108b.setVisibility(TextUtils.isEmpty(charSequence2) ? 4 : 0);
        this.f26108b.setText(charSequence2);
    }

    public BankCardErrorMsgView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }
}

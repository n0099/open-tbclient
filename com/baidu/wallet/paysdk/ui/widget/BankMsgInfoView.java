package com.baidu.wallet.paysdk.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.widget.BorderTipTextView;
@SuppressLint({"NewApi"})
/* loaded from: classes5.dex */
public class BankMsgInfoView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public NetImageView f26848a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f26849b;

    /* renamed from: c  reason: collision with root package name */
    public BorderTipTextView f26850c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f26851d;

    public BankMsgInfoView(Context context) {
        super(context);
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_cashdesk_bind_card_bankinfo_view"), this);
        this.f26851d = (ViewGroup) findViewById(ResUtils.id(getContext(), "layout_entity"));
        this.f26848a = (NetImageView) findViewById(ResUtils.id(getContext(), "bindcard_bankinfo_logo"));
        this.f26849b = (TextView) findViewById(ResUtils.id(getContext(), "bindcard_bankinfo_txt"));
        this.f26850c = (BorderTipTextView) findViewById(ResUtils.id(getContext(), "bindcard_bankinfo_coupon_txt"));
    }

    public void hideCouponView() {
        this.f26850c.setVisibility(8);
    }

    public void setBankInfo(String str, CharSequence charSequence) {
        if (!TextUtils.isEmpty(str)) {
            this.f26848a.setImageResource(ResUtils.drawable(getContext(), "wallet_base_banklogo_defult"));
            this.f26848a.setImageUrl(str);
            this.f26848a.setVisibility(0);
        }
        this.f26849b.setText(charSequence);
    }

    public void setCouponDesc(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            this.f26850c.setVisibility(0);
            this.f26850c.setText(charSequence, true);
            return;
        }
        this.f26850c.setVisibility(8);
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        if (i2 == 0) {
            super.setVisibility(0);
            this.f26851d.setVisibility(0);
            return;
        }
        this.f26851d.setVisibility(4);
    }

    public BankMsgInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public BankMsgInfoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }
}

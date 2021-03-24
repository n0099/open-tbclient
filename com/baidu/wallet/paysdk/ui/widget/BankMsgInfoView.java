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
    public NetImageView f26359a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f26360b;

    /* renamed from: c  reason: collision with root package name */
    public BorderTipTextView f26361c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f26362d;

    public BankMsgInfoView(Context context) {
        super(context);
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_cashdesk_bind_card_bankinfo_view"), this);
        this.f26362d = (ViewGroup) findViewById(ResUtils.id(getContext(), "layout_entity"));
        this.f26359a = (NetImageView) findViewById(ResUtils.id(getContext(), "bindcard_bankinfo_logo"));
        this.f26360b = (TextView) findViewById(ResUtils.id(getContext(), "bindcard_bankinfo_txt"));
        this.f26361c = (BorderTipTextView) findViewById(ResUtils.id(getContext(), "bindcard_bankinfo_coupon_txt"));
    }

    public void hideCouponView() {
        this.f26361c.setVisibility(8);
    }

    public void setBankInfo(String str, CharSequence charSequence) {
        if (!TextUtils.isEmpty(str)) {
            this.f26359a.setImageResource(ResUtils.drawable(getContext(), "wallet_base_banklogo_defult"));
            this.f26359a.setImageUrl(str);
            this.f26359a.setVisibility(0);
        }
        this.f26360b.setText(charSequence);
    }

    public void setCouponDesc(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            this.f26361c.setVisibility(0);
            this.f26361c.setText(charSequence, true);
            return;
        }
        this.f26361c.setVisibility(8);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (i == 0) {
            super.setVisibility(0);
            this.f26362d.setVisibility(0);
            return;
        }
        this.f26362d.setVisibility(4);
    }

    public BankMsgInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public BankMsgInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }
}

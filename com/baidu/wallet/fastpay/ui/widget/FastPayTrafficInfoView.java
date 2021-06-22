package com.baidu.wallet.fastpay.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.apollon.utils.ResUtils;
@SuppressLint({"NewApi"})
/* loaded from: classes5.dex */
public class FastPayTrafficInfoView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    public TextView f24264a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f24265b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f24266c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f24267d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f24268e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f24269f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f24270g;

    public FastPayTrafficInfoView(Context context) {
        super(context);
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_fp_traffic_info_item"), this);
        this.f24270g = (TextView) findViewById(ResUtils.id(getContext(), "wallet_to_buy"));
        this.f24264a = (TextView) findViewById(ResUtils.id(getContext(), "wallet_traffic_info_current_price"));
        this.f24265b = (TextView) findViewById(ResUtils.id(getContext(), "wallet_traffic_info_formal_price"));
        this.f24266c = (TextView) findViewById(ResUtils.id(getContext(), "wallet_traffic_info_available_area"));
        this.f24267d = (TextView) findViewById(ResUtils.id(getContext(), "wallet_traffic_info_available_time"));
        this.f24268e = (TextView) findViewById(ResUtils.id(getContext(), "wallet_traffic_info_discount_info"));
        this.f24269f = (TextView) findViewById(ResUtils.id(getContext(), "wallet_traffic_info_hui_des"));
    }

    public void setActualPrice(String str) {
        if (this.f24264a == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f24264a.setText(str);
    }

    public void setDiscountInfo(String str) {
        if (this.f24268e == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f24268e.setVisibility(0);
        this.f24268e.setText(str);
    }

    public void setHuiDes(String str) {
        if (this.f24269f == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f24269f.setText(str);
        this.f24269f.setVisibility(0);
    }

    public void setOnBuyClickListener(View.OnClickListener onClickListener) {
        this.f24270g.setOnClickListener(onClickListener);
    }

    public void setOriginalmalPrice(String str) {
        if (this.f24265b == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f24265b.setText(str);
        this.f24265b.getPaint().setFlags(17);
    }

    public void setUsePeriod(String str) {
        if (this.f24267d == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f24267d.setText(str);
    }

    public void setUseProvince(String str) {
        if (this.f24266c == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f24266c.setVisibility(0);
        TextView textView = this.f24266c;
        textView.setText(str + "，");
    }

    public FastPayTrafficInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public FastPayTrafficInfoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }
}

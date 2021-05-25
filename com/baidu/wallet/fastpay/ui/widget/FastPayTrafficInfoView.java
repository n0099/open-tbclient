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
    public TextView f24079a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f24080b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f24081c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f24082d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f24083e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f24084f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f24085g;

    public FastPayTrafficInfoView(Context context) {
        super(context);
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_fp_traffic_info_item"), this);
        this.f24085g = (TextView) findViewById(ResUtils.id(getContext(), "wallet_to_buy"));
        this.f24079a = (TextView) findViewById(ResUtils.id(getContext(), "wallet_traffic_info_current_price"));
        this.f24080b = (TextView) findViewById(ResUtils.id(getContext(), "wallet_traffic_info_formal_price"));
        this.f24081c = (TextView) findViewById(ResUtils.id(getContext(), "wallet_traffic_info_available_area"));
        this.f24082d = (TextView) findViewById(ResUtils.id(getContext(), "wallet_traffic_info_available_time"));
        this.f24083e = (TextView) findViewById(ResUtils.id(getContext(), "wallet_traffic_info_discount_info"));
        this.f24084f = (TextView) findViewById(ResUtils.id(getContext(), "wallet_traffic_info_hui_des"));
    }

    public void setActualPrice(String str) {
        if (this.f24079a == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f24079a.setText(str);
    }

    public void setDiscountInfo(String str) {
        if (this.f24083e == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f24083e.setVisibility(0);
        this.f24083e.setText(str);
    }

    public void setHuiDes(String str) {
        if (this.f24084f == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f24084f.setText(str);
        this.f24084f.setVisibility(0);
    }

    public void setOnBuyClickListener(View.OnClickListener onClickListener) {
        this.f24085g.setOnClickListener(onClickListener);
    }

    public void setOriginalmalPrice(String str) {
        if (this.f24080b == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f24080b.setText(str);
        this.f24080b.getPaint().setFlags(17);
    }

    public void setUsePeriod(String str) {
        if (this.f24082d == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f24082d.setText(str);
    }

    public void setUseProvince(String str) {
        if (this.f24081c == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f24081c.setVisibility(0);
        TextView textView = this.f24081c;
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

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
    public TextView f24905a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f24906b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f24907c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f24908d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f24909e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f24910f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f24911g;

    public FastPayTrafficInfoView(Context context) {
        super(context);
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_fp_traffic_info_item"), this);
        this.f24911g = (TextView) findViewById(ResUtils.id(getContext(), "wallet_to_buy"));
        this.f24905a = (TextView) findViewById(ResUtils.id(getContext(), "wallet_traffic_info_current_price"));
        this.f24906b = (TextView) findViewById(ResUtils.id(getContext(), "wallet_traffic_info_formal_price"));
        this.f24907c = (TextView) findViewById(ResUtils.id(getContext(), "wallet_traffic_info_available_area"));
        this.f24908d = (TextView) findViewById(ResUtils.id(getContext(), "wallet_traffic_info_available_time"));
        this.f24909e = (TextView) findViewById(ResUtils.id(getContext(), "wallet_traffic_info_discount_info"));
        this.f24910f = (TextView) findViewById(ResUtils.id(getContext(), "wallet_traffic_info_hui_des"));
    }

    public void setActualPrice(String str) {
        if (this.f24905a == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f24905a.setText(str);
    }

    public void setDiscountInfo(String str) {
        if (this.f24909e == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f24909e.setVisibility(0);
        this.f24909e.setText(str);
    }

    public void setHuiDes(String str) {
        if (this.f24910f == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f24910f.setText(str);
        this.f24910f.setVisibility(0);
    }

    public void setOnBuyClickListener(View.OnClickListener onClickListener) {
        this.f24911g.setOnClickListener(onClickListener);
    }

    public void setOriginalmalPrice(String str) {
        if (this.f24906b == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f24906b.setText(str);
        this.f24906b.getPaint().setFlags(17);
    }

    public void setUsePeriod(String str) {
        if (this.f24908d == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f24908d.setText(str);
    }

    public void setUseProvince(String str) {
        if (this.f24907c == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f24907c.setVisibility(0);
        TextView textView = this.f24907c;
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

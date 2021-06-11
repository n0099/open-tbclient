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
    public TextView f24182a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f24183b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f24184c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f24185d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f24186e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f24187f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f24188g;

    public FastPayTrafficInfoView(Context context) {
        super(context);
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_fp_traffic_info_item"), this);
        this.f24188g = (TextView) findViewById(ResUtils.id(getContext(), "wallet_to_buy"));
        this.f24182a = (TextView) findViewById(ResUtils.id(getContext(), "wallet_traffic_info_current_price"));
        this.f24183b = (TextView) findViewById(ResUtils.id(getContext(), "wallet_traffic_info_formal_price"));
        this.f24184c = (TextView) findViewById(ResUtils.id(getContext(), "wallet_traffic_info_available_area"));
        this.f24185d = (TextView) findViewById(ResUtils.id(getContext(), "wallet_traffic_info_available_time"));
        this.f24186e = (TextView) findViewById(ResUtils.id(getContext(), "wallet_traffic_info_discount_info"));
        this.f24187f = (TextView) findViewById(ResUtils.id(getContext(), "wallet_traffic_info_hui_des"));
    }

    public void setActualPrice(String str) {
        if (this.f24182a == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f24182a.setText(str);
    }

    public void setDiscountInfo(String str) {
        if (this.f24186e == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f24186e.setVisibility(0);
        this.f24186e.setText(str);
    }

    public void setHuiDes(String str) {
        if (this.f24187f == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f24187f.setText(str);
        this.f24187f.setVisibility(0);
    }

    public void setOnBuyClickListener(View.OnClickListener onClickListener) {
        this.f24188g.setOnClickListener(onClickListener);
    }

    public void setOriginalmalPrice(String str) {
        if (this.f24183b == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f24183b.setText(str);
        this.f24183b.getPaint().setFlags(17);
    }

    public void setUsePeriod(String str) {
        if (this.f24185d == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f24185d.setText(str);
    }

    public void setUseProvince(String str) {
        if (this.f24184c == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f24184c.setVisibility(0);
        TextView textView = this.f24184c;
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

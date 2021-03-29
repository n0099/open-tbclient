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
    public TextView f24461a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f24462b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f24463c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f24464d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f24465e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f24466f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f24467g;

    public FastPayTrafficInfoView(Context context) {
        super(context);
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_fp_traffic_info_item"), this);
        this.f24467g = (TextView) findViewById(ResUtils.id(getContext(), "wallet_to_buy"));
        this.f24461a = (TextView) findViewById(ResUtils.id(getContext(), "wallet_traffic_info_current_price"));
        this.f24462b = (TextView) findViewById(ResUtils.id(getContext(), "wallet_traffic_info_formal_price"));
        this.f24463c = (TextView) findViewById(ResUtils.id(getContext(), "wallet_traffic_info_available_area"));
        this.f24464d = (TextView) findViewById(ResUtils.id(getContext(), "wallet_traffic_info_available_time"));
        this.f24465e = (TextView) findViewById(ResUtils.id(getContext(), "wallet_traffic_info_discount_info"));
        this.f24466f = (TextView) findViewById(ResUtils.id(getContext(), "wallet_traffic_info_hui_des"));
    }

    public void setActualPrice(String str) {
        if (this.f24461a == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f24461a.setText(str);
    }

    public void setDiscountInfo(String str) {
        if (this.f24465e == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f24465e.setVisibility(0);
        this.f24465e.setText(str);
    }

    public void setHuiDes(String str) {
        if (this.f24466f == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f24466f.setText(str);
        this.f24466f.setVisibility(0);
    }

    public void setOnBuyClickListener(View.OnClickListener onClickListener) {
        this.f24467g.setOnClickListener(onClickListener);
    }

    public void setOriginalmalPrice(String str) {
        if (this.f24462b == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f24462b.setText(str);
        this.f24462b.getPaint().setFlags(17);
    }

    public void setUsePeriod(String str) {
        if (this.f24464d == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f24464d.setText(str);
    }

    public void setUseProvince(String str) {
        if (this.f24463c == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f24463c.setVisibility(0);
        TextView textView = this.f24463c;
        textView.setText(str + "，");
    }

    public FastPayTrafficInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public FastPayTrafficInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }
}

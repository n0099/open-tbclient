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
    public TextView f24154a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f24155b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f24156c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f24157d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f24158e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f24159f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f24160g;

    public FastPayTrafficInfoView(Context context) {
        super(context);
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_fp_traffic_info_item"), this);
        this.f24160g = (TextView) findViewById(ResUtils.id(getContext(), "wallet_to_buy"));
        this.f24154a = (TextView) findViewById(ResUtils.id(getContext(), "wallet_traffic_info_current_price"));
        this.f24155b = (TextView) findViewById(ResUtils.id(getContext(), "wallet_traffic_info_formal_price"));
        this.f24156c = (TextView) findViewById(ResUtils.id(getContext(), "wallet_traffic_info_available_area"));
        this.f24157d = (TextView) findViewById(ResUtils.id(getContext(), "wallet_traffic_info_available_time"));
        this.f24158e = (TextView) findViewById(ResUtils.id(getContext(), "wallet_traffic_info_discount_info"));
        this.f24159f = (TextView) findViewById(ResUtils.id(getContext(), "wallet_traffic_info_hui_des"));
    }

    public void setActualPrice(String str) {
        if (this.f24154a == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f24154a.setText(str);
    }

    public void setDiscountInfo(String str) {
        if (this.f24158e == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f24158e.setVisibility(0);
        this.f24158e.setText(str);
    }

    public void setHuiDes(String str) {
        if (this.f24159f == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f24159f.setText(str);
        this.f24159f.setVisibility(0);
    }

    public void setOnBuyClickListener(View.OnClickListener onClickListener) {
        this.f24160g.setOnClickListener(onClickListener);
    }

    public void setOriginalmalPrice(String str) {
        if (this.f24155b == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f24155b.setText(str);
        this.f24155b.getPaint().setFlags(17);
    }

    public void setUsePeriod(String str) {
        if (this.f24157d == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f24157d.setText(str);
    }

    public void setUseProvince(String str) {
        if (this.f24156c == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f24156c.setVisibility(0);
        TextView textView = this.f24156c;
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

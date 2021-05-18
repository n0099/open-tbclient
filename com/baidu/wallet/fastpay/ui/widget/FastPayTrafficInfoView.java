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
    public TextView f24150a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f24151b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f24152c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f24153d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f24154e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f24155f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f24156g;

    public FastPayTrafficInfoView(Context context) {
        super(context);
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_fp_traffic_info_item"), this);
        this.f24156g = (TextView) findViewById(ResUtils.id(getContext(), "wallet_to_buy"));
        this.f24150a = (TextView) findViewById(ResUtils.id(getContext(), "wallet_traffic_info_current_price"));
        this.f24151b = (TextView) findViewById(ResUtils.id(getContext(), "wallet_traffic_info_formal_price"));
        this.f24152c = (TextView) findViewById(ResUtils.id(getContext(), "wallet_traffic_info_available_area"));
        this.f24153d = (TextView) findViewById(ResUtils.id(getContext(), "wallet_traffic_info_available_time"));
        this.f24154e = (TextView) findViewById(ResUtils.id(getContext(), "wallet_traffic_info_discount_info"));
        this.f24155f = (TextView) findViewById(ResUtils.id(getContext(), "wallet_traffic_info_hui_des"));
    }

    public void setActualPrice(String str) {
        if (this.f24150a == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f24150a.setText(str);
    }

    public void setDiscountInfo(String str) {
        if (this.f24154e == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f24154e.setVisibility(0);
        this.f24154e.setText(str);
    }

    public void setHuiDes(String str) {
        if (this.f24155f == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f24155f.setText(str);
        this.f24155f.setVisibility(0);
    }

    public void setOnBuyClickListener(View.OnClickListener onClickListener) {
        this.f24156g.setOnClickListener(onClickListener);
    }

    public void setOriginalmalPrice(String str) {
        if (this.f24151b == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f24151b.setText(str);
        this.f24151b.getPaint().setFlags(17);
    }

    public void setUsePeriod(String str) {
        if (this.f24153d == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f24153d.setText(str);
    }

    public void setUseProvince(String str) {
        if (this.f24152c == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f24152c.setVisibility(0);
        TextView textView = this.f24152c;
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

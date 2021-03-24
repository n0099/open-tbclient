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
    public TextView f24460a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f24461b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f24462c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f24463d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f24464e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f24465f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f24466g;

    public FastPayTrafficInfoView(Context context) {
        super(context);
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_fp_traffic_info_item"), this);
        this.f24466g = (TextView) findViewById(ResUtils.id(getContext(), "wallet_to_buy"));
        this.f24460a = (TextView) findViewById(ResUtils.id(getContext(), "wallet_traffic_info_current_price"));
        this.f24461b = (TextView) findViewById(ResUtils.id(getContext(), "wallet_traffic_info_formal_price"));
        this.f24462c = (TextView) findViewById(ResUtils.id(getContext(), "wallet_traffic_info_available_area"));
        this.f24463d = (TextView) findViewById(ResUtils.id(getContext(), "wallet_traffic_info_available_time"));
        this.f24464e = (TextView) findViewById(ResUtils.id(getContext(), "wallet_traffic_info_discount_info"));
        this.f24465f = (TextView) findViewById(ResUtils.id(getContext(), "wallet_traffic_info_hui_des"));
    }

    public void setActualPrice(String str) {
        if (this.f24460a == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f24460a.setText(str);
    }

    public void setDiscountInfo(String str) {
        if (this.f24464e == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f24464e.setVisibility(0);
        this.f24464e.setText(str);
    }

    public void setHuiDes(String str) {
        if (this.f24465f == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f24465f.setText(str);
        this.f24465f.setVisibility(0);
    }

    public void setOnBuyClickListener(View.OnClickListener onClickListener) {
        this.f24466g.setOnClickListener(onClickListener);
    }

    public void setOriginalmalPrice(String str) {
        if (this.f24461b == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f24461b.setText(str);
        this.f24461b.getPaint().setFlags(17);
    }

    public void setUsePeriod(String str) {
        if (this.f24463d == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f24463d.setText(str);
    }

    public void setUseProvince(String str) {
        if (this.f24462c == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f24462c.setVisibility(0);
        TextView textView = this.f24462c;
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

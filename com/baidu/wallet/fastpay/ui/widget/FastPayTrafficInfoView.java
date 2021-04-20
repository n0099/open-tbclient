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
    public TextView f24146a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f24147b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f24148c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f24149d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f24150e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f24151f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f24152g;

    public FastPayTrafficInfoView(Context context) {
        super(context);
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_fp_traffic_info_item"), this);
        this.f24152g = (TextView) findViewById(ResUtils.id(getContext(), "wallet_to_buy"));
        this.f24146a = (TextView) findViewById(ResUtils.id(getContext(), "wallet_traffic_info_current_price"));
        this.f24147b = (TextView) findViewById(ResUtils.id(getContext(), "wallet_traffic_info_formal_price"));
        this.f24148c = (TextView) findViewById(ResUtils.id(getContext(), "wallet_traffic_info_available_area"));
        this.f24149d = (TextView) findViewById(ResUtils.id(getContext(), "wallet_traffic_info_available_time"));
        this.f24150e = (TextView) findViewById(ResUtils.id(getContext(), "wallet_traffic_info_discount_info"));
        this.f24151f = (TextView) findViewById(ResUtils.id(getContext(), "wallet_traffic_info_hui_des"));
    }

    public void setActualPrice(String str) {
        if (this.f24146a == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f24146a.setText(str);
    }

    public void setDiscountInfo(String str) {
        if (this.f24150e == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f24150e.setVisibility(0);
        this.f24150e.setText(str);
    }

    public void setHuiDes(String str) {
        if (this.f24151f == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f24151f.setText(str);
        this.f24151f.setVisibility(0);
    }

    public void setOnBuyClickListener(View.OnClickListener onClickListener) {
        this.f24152g.setOnClickListener(onClickListener);
    }

    public void setOriginalmalPrice(String str) {
        if (this.f24147b == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f24147b.setText(str);
        this.f24147b.getPaint().setFlags(17);
    }

    public void setUsePeriod(String str) {
        if (this.f24149d == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f24149d.setText(str);
    }

    public void setUseProvince(String str) {
        if (this.f24148c == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f24148c.setVisibility(0);
        TextView textView = this.f24148c;
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

package com.baidu.wallet.base.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.utils.ResUtils;
/* loaded from: classes5.dex */
public class OrderConfirmation extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public NetImageView f24299a;

    /* renamed from: b  reason: collision with root package name */
    public NetImageView f24300b;

    /* renamed from: c  reason: collision with root package name */
    public View f24301c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f24302d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f24303e;

    /* renamed from: f  reason: collision with root package name */
    public View f24304f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f24305g;

    /* renamed from: h  reason: collision with root package name */
    public View f24306h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f24307i;
    public View j;
    public TextView k;
    public TextView l;
    public ImageView m;
    public View n;
    public TextView o;

    public OrderConfirmation(Context context) {
        super(context);
        this.f24301c = null;
        this.f24302d = null;
        this.f24303e = null;
        this.f24304f = null;
        this.f24305g = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_base_orderconfirmation"), this);
        this.f24299a = (NetImageView) findViewById(ResUtils.id(getContext(), "bd_wallet_id_base_order_back"));
        this.f24300b = (NetImageView) findViewById(ResUtils.id(getContext(), "bd_wallet_id_title"));
        this.f24300b.setImageResource(ResUtils.drawable(getContext(), "wallet_cashdesk_logo"));
        TextView textView = (TextView) findViewById(ResUtils.id(getContext(), "bd_wallet_id_base_order_pay_title"));
        this.n = textView;
        if (textView != null) {
            textView.setVisibility(8);
        }
        TextView textView2 = (TextView) findViewById(ResUtils.id(getContext(), "bd_wallet_id_base_order_pay_price"));
        this.o = textView2;
        if (textView2 != null) {
            textView2.setText("");
        }
        this.f24301c = findViewById(ResUtils.id(getContext(), "bd_wallet_id_base_order_ebpay_account_layout"));
        this.f24303e = (ImageView) findViewById(ResUtils.id(getContext(), "bd_wallet_id_base_order_ebpay_account_icon"));
        this.f24302d = (TextView) findViewById(ResUtils.id(getContext(), "bd_wallet_id_base_order_ebpay_account"));
        this.f24304f = findViewById(ResUtils.id(getContext(), "bd_wallet_id_base_order_account"));
        this.f24305g = (TextView) findViewById(ResUtils.id(getContext(), "bd_wallet_id_base_order_account_value"));
        this.f24306h = findViewById(ResUtils.id(getContext(), "bd_wallet_id_base_order_sp_name"));
        this.f24307i = (TextView) findViewById(ResUtils.id(getContext(), "bd_wallet_id_base_order_spname_value"));
        View findViewById = findViewById(ResUtils.id(getContext(), "bd_wallet_id_base_order_goods"));
        this.j = findViewById;
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        TextView textView3 = (TextView) findViewById(ResUtils.id(getContext(), "bd_wallet_id_base_order_goods_discount_type"));
        this.k = textView3;
        if (textView3 != null) {
            textView3.setText("");
        }
        TextView textView4 = (TextView) findViewById(ResUtils.id(getContext(), "bd_wallet_id_base_order_goods_discount"));
        this.l = textView4;
        if (textView4 != null) {
            textView4.setText("");
        }
        ImageView imageView = (ImageView) findViewById(ResUtils.id(getContext(), "bd_wallet_account_arrow_icon"));
        this.m = imageView;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    private void b() {
        if (this.n != null) {
            View view = this.f24301c;
            int i2 = (view == null || view.getVisibility() != 0) ? 0 : 1;
            if (this.f24301c != null && this.f24304f.getVisibility() == 0) {
                i2++;
            }
            if (this.f24301c != null && this.j.getVisibility() == 0) {
                i2++;
            }
            if (i2 >= 3) {
                this.n.setVisibility(8);
            } else {
                this.n.setVisibility(0);
            }
        }
    }

    public View getBackButton() {
        return this.f24299a;
    }

    public View getCouponInfoView() {
        return this.j;
    }

    public void setAccountInfo(String str, View.OnClickListener onClickListener) {
        if (this.f24301c != null) {
            if (!TextUtils.isEmpty(str)) {
                this.f24301c.setVisibility(0);
                if (onClickListener != null) {
                    this.f24301c.setOnClickListener(onClickListener);
                    this.f24303e.setVisibility(0);
                } else {
                    this.f24303e.setVisibility(4);
                }
                this.f24302d.setText(str);
                b();
                return;
            }
            this.f24301c.setVisibility(8);
        }
    }

    public void setCouponInfo(CharSequence charSequence, CharSequence charSequence2, View.OnClickListener onClickListener) {
        View view = this.j;
        if (view == null || view.getVisibility() == 8) {
            return;
        }
        if (onClickListener != null) {
            this.j.setOnClickListener(onClickListener);
        }
        if (this.k != null) {
            if (!TextUtils.isEmpty(charSequence)) {
                this.j.setVisibility(0);
                this.k.setText(charSequence);
            } else {
                this.j.setVisibility(8);
                return;
            }
        }
        if (this.l != null) {
            if (!TextUtils.isEmpty(charSequence2)) {
                this.l.setVisibility(0);
                this.l.setVisibility(0);
                this.l.setText(charSequence2);
                this.m.setVisibility(0);
                return;
            }
            this.l.setVisibility(8);
            this.m.setVisibility(4);
            this.j.setOnClickListener(null);
        }
    }

    public void setDiscountInfoVisiable(boolean z) {
        View view = this.j;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    public void setOrderInfo(CharSequence charSequence) {
        View view = this.f24304f;
        if (view == null) {
            return;
        }
        if (this.f24305g == null) {
            view.setVisibility(8);
        } else if (!TextUtils.isEmpty(charSequence)) {
            this.f24304f.setVisibility(0);
            this.f24305g.setText(charSequence);
        } else {
            this.f24304f.setVisibility(8);
        }
    }

    public void setOrderPrice(CharSequence charSequence, CharSequence charSequence2) {
        TextView textView;
        if (this.n == null || TextUtils.isEmpty(charSequence) || (textView = this.o) == null) {
            return;
        }
        textView.setText(charSequence);
        this.n.setVisibility(0);
    }

    public void setSpNameValue(CharSequence charSequence) {
        View view = this.f24306h;
        if (view == null) {
            return;
        }
        if (this.f24307i == null) {
            view.setVisibility(8);
        } else if (!TextUtils.isEmpty(charSequence)) {
            this.f24306h.setVisibility(0);
            this.f24307i.setText(charSequence);
        } else {
            this.f24306h.setVisibility(8);
        }
    }

    public void setTitle(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f24300b.setImageUrl(str);
    }

    public OrderConfirmation(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f24301c = null;
        this.f24302d = null;
        this.f24303e = null;
        this.f24304f = null;
        this.f24305g = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        a();
    }
}

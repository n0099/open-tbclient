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
    public NetImageView f23544a;

    /* renamed from: b  reason: collision with root package name */
    public NetImageView f23545b;

    /* renamed from: c  reason: collision with root package name */
    public View f23546c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f23547d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f23548e;

    /* renamed from: f  reason: collision with root package name */
    public View f23549f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f23550g;

    /* renamed from: h  reason: collision with root package name */
    public View f23551h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f23552i;
    public View j;
    public TextView k;
    public TextView l;
    public ImageView m;
    public View n;
    public TextView o;

    public OrderConfirmation(Context context) {
        super(context);
        this.f23546c = null;
        this.f23547d = null;
        this.f23548e = null;
        this.f23549f = null;
        this.f23550g = null;
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
        this.f23544a = (NetImageView) findViewById(ResUtils.id(getContext(), "bd_wallet_id_base_order_back"));
        this.f23545b = (NetImageView) findViewById(ResUtils.id(getContext(), "bd_wallet_id_title"));
        this.f23545b.setImageResource(ResUtils.drawable(getContext(), "wallet_cashdesk_logo"));
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
        this.f23546c = findViewById(ResUtils.id(getContext(), "bd_wallet_id_base_order_ebpay_account_layout"));
        this.f23548e = (ImageView) findViewById(ResUtils.id(getContext(), "bd_wallet_id_base_order_ebpay_account_icon"));
        this.f23547d = (TextView) findViewById(ResUtils.id(getContext(), "bd_wallet_id_base_order_ebpay_account"));
        this.f23549f = findViewById(ResUtils.id(getContext(), "bd_wallet_id_base_order_account"));
        this.f23550g = (TextView) findViewById(ResUtils.id(getContext(), "bd_wallet_id_base_order_account_value"));
        this.f23551h = findViewById(ResUtils.id(getContext(), "bd_wallet_id_base_order_sp_name"));
        this.f23552i = (TextView) findViewById(ResUtils.id(getContext(), "bd_wallet_id_base_order_spname_value"));
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
            View view = this.f23546c;
            int i2 = (view == null || view.getVisibility() != 0) ? 0 : 1;
            if (this.f23546c != null && this.f23549f.getVisibility() == 0) {
                i2++;
            }
            if (this.f23546c != null && this.j.getVisibility() == 0) {
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
        return this.f23544a;
    }

    public View getCouponInfoView() {
        return this.j;
    }

    public void setAccountInfo(String str, View.OnClickListener onClickListener) {
        if (this.f23546c != null) {
            if (!TextUtils.isEmpty(str)) {
                this.f23546c.setVisibility(0);
                if (onClickListener != null) {
                    this.f23546c.setOnClickListener(onClickListener);
                    this.f23548e.setVisibility(0);
                } else {
                    this.f23548e.setVisibility(4);
                }
                this.f23547d.setText(str);
                b();
                return;
            }
            this.f23546c.setVisibility(8);
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
        View view = this.f23549f;
        if (view == null) {
            return;
        }
        if (this.f23550g == null) {
            view.setVisibility(8);
        } else if (!TextUtils.isEmpty(charSequence)) {
            this.f23549f.setVisibility(0);
            this.f23550g.setText(charSequence);
        } else {
            this.f23549f.setVisibility(8);
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
        View view = this.f23551h;
        if (view == null) {
            return;
        }
        if (this.f23552i == null) {
            view.setVisibility(8);
        } else if (!TextUtils.isEmpty(charSequence)) {
            this.f23551h.setVisibility(0);
            this.f23552i.setText(charSequence);
        } else {
            this.f23551h.setVisibility(8);
        }
    }

    public void setTitle(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f23545b.setImageUrl(str);
    }

    public OrderConfirmation(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23546c = null;
        this.f23547d = null;
        this.f23548e = null;
        this.f23549f = null;
        this.f23550g = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        a();
    }
}

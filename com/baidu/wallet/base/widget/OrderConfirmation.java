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
    public NetImageView f23876a;

    /* renamed from: b  reason: collision with root package name */
    public NetImageView f23877b;

    /* renamed from: c  reason: collision with root package name */
    public View f23878c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f23879d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f23880e;

    /* renamed from: f  reason: collision with root package name */
    public View f23881f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f23882g;

    /* renamed from: h  reason: collision with root package name */
    public View f23883h;
    public TextView i;
    public View j;
    public TextView k;
    public TextView l;
    public ImageView m;
    public View n;
    public TextView o;

    public OrderConfirmation(Context context) {
        super(context);
        this.f23878c = null;
        this.f23879d = null;
        this.f23880e = null;
        this.f23881f = null;
        this.f23882g = null;
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
        this.f23876a = (NetImageView) findViewById(ResUtils.id(getContext(), "bd_wallet_id_base_order_back"));
        this.f23877b = (NetImageView) findViewById(ResUtils.id(getContext(), "bd_wallet_id_title"));
        this.f23877b.setImageResource(ResUtils.drawable(getContext(), "wallet_cashdesk_logo"));
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
        this.f23878c = findViewById(ResUtils.id(getContext(), "bd_wallet_id_base_order_ebpay_account_layout"));
        this.f23880e = (ImageView) findViewById(ResUtils.id(getContext(), "bd_wallet_id_base_order_ebpay_account_icon"));
        this.f23879d = (TextView) findViewById(ResUtils.id(getContext(), "bd_wallet_id_base_order_ebpay_account"));
        this.f23881f = findViewById(ResUtils.id(getContext(), "bd_wallet_id_base_order_account"));
        this.f23882g = (TextView) findViewById(ResUtils.id(getContext(), "bd_wallet_id_base_order_account_value"));
        this.f23883h = findViewById(ResUtils.id(getContext(), "bd_wallet_id_base_order_sp_name"));
        this.i = (TextView) findViewById(ResUtils.id(getContext(), "bd_wallet_id_base_order_spname_value"));
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
            View view = this.f23878c;
            int i = (view == null || view.getVisibility() != 0) ? 0 : 1;
            if (this.f23878c != null && this.f23881f.getVisibility() == 0) {
                i++;
            }
            if (this.f23878c != null && this.j.getVisibility() == 0) {
                i++;
            }
            if (i >= 3) {
                this.n.setVisibility(8);
            } else {
                this.n.setVisibility(0);
            }
        }
    }

    public View getBackButton() {
        return this.f23876a;
    }

    public View getCouponInfoView() {
        return this.j;
    }

    public void setAccountInfo(String str, View.OnClickListener onClickListener) {
        if (this.f23878c != null) {
            if (!TextUtils.isEmpty(str)) {
                this.f23878c.setVisibility(0);
                if (onClickListener != null) {
                    this.f23878c.setOnClickListener(onClickListener);
                    this.f23880e.setVisibility(0);
                } else {
                    this.f23880e.setVisibility(4);
                }
                this.f23879d.setText(str);
                b();
                return;
            }
            this.f23878c.setVisibility(8);
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
        View view = this.f23881f;
        if (view == null) {
            return;
        }
        if (this.f23882g == null) {
            view.setVisibility(8);
        } else if (!TextUtils.isEmpty(charSequence)) {
            this.f23881f.setVisibility(0);
            this.f23882g.setText(charSequence);
        } else {
            this.f23881f.setVisibility(8);
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
        View view = this.f23883h;
        if (view == null) {
            return;
        }
        if (this.i == null) {
            view.setVisibility(8);
        } else if (!TextUtils.isEmpty(charSequence)) {
            this.f23883h.setVisibility(0);
            this.i.setText(charSequence);
        } else {
            this.f23883h.setVisibility(8);
        }
    }

    public void setTitle(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f23877b.setImageUrl(str);
    }

    public OrderConfirmation(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23878c = null;
        this.f23879d = null;
        this.f23880e = null;
        this.f23881f = null;
        this.f23882g = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        a();
    }
}

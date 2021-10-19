package com.baidu.wallet.personal.ui.view;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.personal.datamodel.CouponList;
/* loaded from: classes8.dex */
public class a extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.wallet.personal.ui.view.c, com.baidu.wallet.personal.a.a.b
    public void a(int i2, CouponList.Coupon coupon) {
        TextView textView;
        String str;
        TextView textView2;
        Context context;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, coupon) == null) {
            super.a(i2, coupon);
            int i3 = coupon.coupon_list_show_formwork;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f63879e.getLayoutParams();
            layoutParams.topMargin = DisplayUtils.dip2px(this.f63876b.getContext(), 17.0f);
            this.f63881g.f63897a.getLayoutParams().height = DisplayUtils.dip2px(this.f63876b.getContext(), 139.0f);
            layoutParams.bottomMargin = DisplayUtils.dip2px(this.f63876b.getContext(), 28.5f);
            this.f63879e.setLayoutParams(layoutParams);
            if (coupon.coupon_name.length() > 5) {
                textView = this.f63882h;
                str = coupon.coupon_name.substring(0, 5);
            } else {
                textView = this.f63882h;
                str = coupon.coupon_name;
            }
            textView.setText(str);
            this.f63882h.getLayoutParams().width = DisplayUtils.dip2px(this.f63876b.getContext(), 60.0f);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.k.f63900a.getLayoutParams();
            layoutParams2.leftMargin = DisplayUtils.dip2px(this.f63876b.getContext(), 12.5f);
            if (!this.k.f63901b) {
                layoutParams2.height = DisplayUtils.dip2px(this.f63876b.getContext(), 14.0f);
                this.k.f63900a.setBackgroundDrawable(ResUtils.getDrawable(this.f63876b.getContext(), "wallet_personal_coupon_market_label_cash"));
            }
            this.k.f63900a.setLayoutParams(layoutParams2);
            if (this.f63875a) {
                str2 = "ebpay_white";
                this.f63883i.setTextColor(ResUtils.getColor(this.f63876b.getContext(), "ebpay_white"));
                this.f63884j.setTextColor(ResUtils.getColor(this.f63876b.getContext(), "ebpay_white"));
                if (TextUtils.isEmpty(coupon.coupon_color_bg) || !this.f63881g.f63898b) {
                    this.f63881g.f63897a.setBackgroundDrawable(ResUtils.getDrawable(this.f63876b.getContext(), "wallet_personal_coupon_cash_gray_bg"));
                }
                this.k.f63900a.setTextColor(ResUtils.getColor(this.f63876b.getContext(), "ebpay_white"));
                this.l.setTextColor(ResUtils.getColor(this.f63876b.getContext(), "ebpay_white"));
                this.r.setTextColor(ResUtils.getColor(this.f63876b.getContext(), "ebpay_white"));
                textView2 = this.m;
                context = this.f63876b.getContext();
            } else {
                this.f63883i.setTextColor(com.baidu.wallet.personal.b.b.a(this.f63876b.getContext(), i3));
                this.f63883i.setTypeface(Typeface.DEFAULT);
                this.f63884j.setTextColor(com.baidu.wallet.personal.b.b.a(this.f63876b.getContext(), i3));
                if (TextUtils.isEmpty(coupon.coupon_color_bg) || !this.f63881g.f63898b) {
                    this.f63881g.f63897a.setBackgroundDrawable(ResUtils.getDrawable(this.f63876b.getContext(), "wallet_personal_coupon_base_formwork_5_55"));
                }
                this.k.f63900a.setTextColor(com.baidu.wallet.personal.b.b.a(this.f63876b.getContext(), i3));
                this.l.setTextColor(com.baidu.wallet.personal.b.b.a(this.f63876b.getContext(), i3));
                this.r.setTextColor(com.baidu.wallet.personal.b.b.a(this.f63876b.getContext(), i3));
                textView2 = this.m;
                context = this.f63876b.getContext();
                str2 = "coupon_base_orage_ccf7d1af";
            }
            textView2.setTextColor(ResUtils.getColor(context, str2));
            this.n.setVisibility(8);
            if (TextUtils.isEmpty(coupon.coupon_color) && Build.VERSION.SDK_INT >= 16) {
                this.f63880f.setBackground(com.baidu.wallet.personal.b.b.a(this.f63876b.getContext(), com.baidu.wallet.personal.b.b.b(this.f63876b.getContext(), coupon.coupon_list_show_formwork), 0));
            }
            a();
        }
    }
}

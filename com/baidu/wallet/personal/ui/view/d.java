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
/* loaded from: classes2.dex */
public class d extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public d() {
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
        Context context;
        float f2;
        RelativeLayout relativeLayout;
        Context context2;
        int i3;
        String str;
        TextView textView;
        Context context3;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, coupon) == null) {
            super.a(i2, coupon);
            if (this.l.getVisibility() == 0) {
                if ((this.a || !coupon.date_message.contains("后过期")) && !coupon.date_message.contains("前使用")) {
                    this.l.setTextColor(ResUtils.getColor(this.f52828b.getContext(), "coupon_base_black_394259"));
                } else {
                    this.l.setTextColor(ResUtils.getColor(this.f52828b.getContext(), "coupon_base_red_f73f31"));
                    this.l.setTypeface(Typeface.SANS_SERIF, 1);
                }
            }
            if (this.m.getVisibility() == 0) {
                this.m.setTextColor(ResUtils.getColor(this.f52828b.getContext(), "coupon_base_black_cc394259"));
            }
            if (this.n.getVisibility() == 0) {
                this.n.setTextColor(ResUtils.getColor(this.f52828b.getContext(), "coupon_base_black_cc394259"));
            }
            int i4 = coupon.coupon_list_show_formwork;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f52831e.getLayoutParams();
            layoutParams.topMargin = DisplayUtils.dip2px(this.f52828b.getContext(), 17.0f);
            if (TextUtils.isEmpty(coupon.sub_title) || TextUtils.isEmpty(coupon.sub_title2)) {
                this.f52833g.a.getLayoutParams().height = DisplayUtils.dip2px(this.f52828b.getContext(), 139.0f);
                context = this.f52828b.getContext();
                f2 = 29.0f;
            } else {
                this.f52833g.a.getLayoutParams().height = DisplayUtils.dip2px(this.f52828b.getContext(), 155.0f);
                context = this.f52828b.getContext();
                f2 = 28.0f;
            }
            layoutParams.bottomMargin = DisplayUtils.dip2px(context, f2);
            this.f52831e.setLayoutParams(layoutParams);
            this.f52835i.setTextColor(com.baidu.wallet.personal.b.b.a(this.f52828b.getContext(), i4));
            this.f52836j.setTextColor(ResUtils.getColor(this.f52828b.getContext(), "coupon_base_black_000014"));
            if ((TextUtils.isEmpty(coupon.coupon_color_bg) || !this.f52833g.f52842b) && Build.VERSION.SDK_INT >= 16) {
                if (this.a) {
                    relativeLayout = this.f52833g.a;
                    context2 = this.f52828b.getContext();
                    i3 = this.f52833g.a.getLayoutParams().height;
                    str = "wallet_personal_coupon_gray_special_bg";
                } else {
                    relativeLayout = this.f52833g.a;
                    context2 = this.f52828b.getContext();
                    i3 = this.f52833g.a.getLayoutParams().height;
                    str = "wallet_personal_coupon_base_formwork_11_22_33_44_66";
                }
                relativeLayout.setBackground(com.baidu.wallet.personal.b.b.a(context2, str, i3));
            }
            if (TextUtils.isEmpty(coupon.coupon_color) && Build.VERSION.SDK_INT >= 16) {
                this.f52832f.setBackground(com.baidu.wallet.personal.b.b.a(this.f52828b.getContext(), com.baidu.wallet.personal.b.b.b(this.f52828b.getContext(), i4), 0));
            }
            if (this.a) {
                textView = this.r;
                context3 = this.f52828b.getContext();
                str2 = "coupon_base_gray_e1e2e6";
            } else {
                textView = this.r;
                context3 = this.f52828b.getContext();
                str2 = "coupon_base_yellow_eec19a";
            }
            textView.setTextColor(ResUtils.getColor(context3, str2));
            a();
        }
    }
}

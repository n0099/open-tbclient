package com.baidu.wallet.personal.ui.view;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.personal.datamodel.CouponList;
/* loaded from: classes2.dex */
public class b extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public b() {
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
        NinePatchDrawable a;
        RelativeLayout relativeLayout2;
        Context context3;
        int i4;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, coupon) == null) {
            super.a(i2, coupon);
            if (i2 < 0 || coupon == null) {
                return;
            }
            if (this.l.getVisibility() == 0) {
                if ((this.a || !coupon.date_message.contains("后过期")) && !coupon.date_message.contains("前使用")) {
                    this.l.setTextColor(ResUtils.getColor(this.f52661b.getContext(), "coupon_base_black_394259"));
                } else {
                    this.l.setTextColor(ResUtils.getColor(this.f52661b.getContext(), "coupon_base_red_f73f31"));
                    this.l.setTypeface(Typeface.SANS_SERIF, 1);
                }
            }
            if (this.m.getVisibility() == 0) {
                this.m.setTextColor(ResUtils.getColor(this.f52661b.getContext(), "coupon_base_black_cc394259"));
            }
            if (this.n.getVisibility() == 0) {
                this.n.setTextColor(ResUtils.getColor(this.f52661b.getContext(), "coupon_base_black_cc394259"));
            }
            if (this.r.getVisibility() == 0) {
                this.r.setTextColor(ResUtils.getColor(this.f52661b.getContext(), "ebpay_white"));
            }
            int i5 = coupon.coupon_list_show_formwork;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f52664e.getLayoutParams();
            layoutParams.topMargin = DisplayUtils.dip2px(this.f52661b.getContext(), 17.0f);
            if (TextUtils.isEmpty(coupon.sub_title) || TextUtils.isEmpty(coupon.sub_title2)) {
                this.f52666g.a.getLayoutParams().height = DisplayUtils.dip2px(this.f52661b.getContext(), 139.0f);
                context = this.f52661b.getContext();
                f2 = 29.0f;
            } else {
                this.f52666g.a.getLayoutParams().height = DisplayUtils.dip2px(this.f52661b.getContext(), 155.0f);
                context = this.f52661b.getContext();
                f2 = 28.0f;
            }
            layoutParams.bottomMargin = DisplayUtils.dip2px(context, f2);
            this.f52664e.setLayoutParams(layoutParams);
            this.f52668i.setTextColor(com.baidu.wallet.personal.b.b.a(this.f52661b.getContext(), i5));
            if (TextUtils.isEmpty(coupon.coupon_color) && Build.VERSION.SDK_INT >= 16) {
                this.f52665f.setBackground(com.baidu.wallet.personal.b.b.a(this.f52661b.getContext(), com.baidu.wallet.personal.b.b.b(this.f52661b.getContext(), i5), 0));
            }
            if (i5 != 1) {
                if (i5 == 3) {
                    if (TextUtils.isEmpty(coupon.coupon_color_bg) || !this.f52666g.f52675b) {
                        if (!this.a) {
                            relativeLayout = this.f52666g.a;
                            context2 = this.f52661b.getContext();
                            i3 = this.f52666g.a.getLayoutParams().height;
                            str = "wallet_personal_coupon_base_formwork_3";
                            a = com.baidu.wallet.personal.b.b.a(context2, str, i3);
                        }
                        relativeLayout = this.f52666g.a;
                        a = com.baidu.wallet.personal.b.b.a(this.f52661b.getContext(), "wallet_personal_coupon_gray_common_bg", this.f52666g.a.getLayoutParams().height);
                    }
                    a();
                } else if (i5 != 6) {
                    if (i5 == 8) {
                        if (TextUtils.isEmpty(coupon.coupon_color_bg) || !this.f52666g.f52675b) {
                            if (this.a) {
                                relativeLayout2 = this.f52666g.a;
                                context3 = this.f52661b.getContext();
                                i4 = this.f52666g.a.getLayoutParams().height;
                                str2 = "wallet_personal_coupon_common_dark_gray";
                            } else {
                                relativeLayout2 = this.f52666g.a;
                                context3 = this.f52661b.getContext();
                                i4 = this.f52666g.a.getLayoutParams().height;
                                str2 = "wallet_personal_coupon_base_formwork_8";
                            }
                            relativeLayout2.setBackgroundDrawable(com.baidu.wallet.personal.b.b.a(context3, str2, i4));
                        }
                        this.f52667h.setTextColor(-1);
                        if (!coupon.date_message.contains("后过期") && !coupon.date_message.contains("前使用")) {
                            this.l.setTextColor(-1);
                        }
                        this.f52669j.setTextColor(-1);
                        this.m.setTextColor(-1);
                        this.n.setTextColor(-1);
                        this.r.setTextColor(-1);
                    } else if (TextUtils.isEmpty(coupon.coupon_color_bg) || !this.f52666g.f52675b) {
                        if (!this.a) {
                            relativeLayout = this.f52666g.a;
                            context2 = this.f52661b.getContext();
                            i3 = this.f52666g.a.getLayoutParams().height;
                            str = "wallet_personal_coupon_base_formwork_2_4_7";
                            a = com.baidu.wallet.personal.b.b.a(context2, str, i3);
                        }
                        relativeLayout = this.f52666g.a;
                        a = com.baidu.wallet.personal.b.b.a(this.f52661b.getContext(), "wallet_personal_coupon_gray_common_bg", this.f52666g.a.getLayoutParams().height);
                    }
                    a();
                }
                relativeLayout.setBackgroundDrawable(a);
                a();
            }
            if (TextUtils.isEmpty(coupon.coupon_color_bg) || !this.f52666g.f52675b) {
                if (!this.a) {
                    relativeLayout = this.f52666g.a;
                    context2 = this.f52661b.getContext();
                    i3 = this.f52666g.a.getLayoutParams().height;
                    str = "wallet_personal_coupon_base_formwork_1_6";
                    a = com.baidu.wallet.personal.b.b.a(context2, str, i3);
                    relativeLayout.setBackgroundDrawable(a);
                }
                relativeLayout = this.f52666g.a;
                a = com.baidu.wallet.personal.b.b.a(this.f52661b.getContext(), "wallet_personal_coupon_gray_common_bg", this.f52666g.a.getLayoutParams().height);
                relativeLayout.setBackgroundDrawable(a);
            }
            a();
        }
    }
}

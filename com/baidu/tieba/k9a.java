package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.dimen.TbDimenUtil;
import com.baidu.tieba.person.ProfileVirtualImageInfo;
import com.baidu.tieba.write.write.NewWriteActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.Glide;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class k9a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final NewWriteActivity a;
    public View b;
    public View c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947869302, "Lcom/baidu/tieba/k9a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947869302, "Lcom/baidu/tieba/k9a;");
        }
    }

    public k9a(NewWriteActivity mActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mActivity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(mActivity, "mActivity");
        this.a = mActivity;
    }

    public static final void g(k9a this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            View view3 = this$0.c;
            Intrinsics.checkNotNull(view3);
            view3.setVisibility(8);
            a35.s("writeSpringFestivalBless");
        }
    }

    public static final void j(k9a this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            View view3 = this$0.b;
            Intrinsics.checkNotNull(view3);
            view3.setVisibility(8);
            a35.s("writeVirtualGuide");
        }
    }

    public static final void k(k9a this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.a.u1("5");
        }
    }

    public static final void h(k9a this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            View view2 = this$0.c;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            a35.s("writeSpringFestivalBless");
        }
    }

    public static final void l(k9a this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            View view2 = this$0.b;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            a35.s("writeVirtualGuide");
        }
    }

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!c() && !b()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            View view2 = this.c;
            if (view2 != null) {
                Intrinsics.checkNotNull(view2);
                if (view2.getVisibility() == 0) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            View view2 = this.b;
            if (view2 != null) {
                Intrinsics.checkNotNull(view2);
                if (view2.getVisibility() == 0) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.a.getIntent() != null && tg5.a() && f()) {
                return;
            }
            i();
        }
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            View view2 = this.b;
            if (view2 != null) {
                Intrinsics.checkNotNull(view2);
                if (view2.getVisibility() == 0) {
                    View view3 = this.b;
                    Intrinsics.checkNotNull(view3);
                    view3.setVisibility(8);
                    a35.s("writeVirtualGuide");
                    return true;
                }
            }
            View view4 = this.c;
            if (view4 != null) {
                Intrinsics.checkNotNull(view4);
                if (view4.getVisibility() == 0) {
                    View view5 = this.c;
                    Intrinsics.checkNotNull(view5);
                    view5.setVisibility(8);
                    a35.s("writeSpringFestivalBless");
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (o65.m().i("key_write_spring_festival_bless_guide_has_show", false)) {
                return false;
            }
            o65.m().w("key_write_spring_festival_bless_guide_has_show", true);
            ((ViewStub) this.a.findViewById(R.id.obfuscated_res_0x7f092179)).inflate();
            View findViewById = this.a.findViewById(R.id.obfuscated_res_0x7f092178);
            this.c = findViewById;
            Intrinsics.checkNotNull(findViewById);
            findViewById.setVisibility(0);
            View view2 = this.c;
            Intrinsics.checkNotNull(view2);
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.h9a
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view3) == null) {
                        k9a.g(k9a.this, view3);
                    }
                }
            });
            a35.m("writeSpringFestivalBless");
            p45 d = p45.d(this.c);
            d.e(R.string.A_X05);
            d.f(R.color.CAM_X0611);
            View view3 = this.c;
            Intrinsics.checkNotNull(view3);
            p45 d2 = p45.d(view3.findViewById(R.id.obfuscated_res_0x7f092177));
            d2.o(R.string.J_X06);
            d2.f(R.color.CAM_X0201);
            View view4 = this.c;
            Intrinsics.checkNotNull(view4);
            p45 d3 = p45.d((TextView) view4.findViewById(R.id.obfuscated_res_0x7f09217a));
            d3.w(R.color.CAM_X0105);
            d3.C(R.string.F_X02);
            View view5 = this.c;
            Intrinsics.checkNotNull(view5);
            p45.d((TextView) view5.findViewById(R.id.obfuscated_res_0x7f092174)).w(R.color.CAM_X0107);
            View view6 = this.c;
            Intrinsics.checkNotNull(view6);
            p45 d4 = p45.d(view6.findViewById(R.id.obfuscated_res_0x7f09217c));
            d4.o(R.string.J_X07);
            d4.e(R.string.A_X10);
            d4.f(R.color.CAM_X0319);
            View view7 = this.c;
            Intrinsics.checkNotNull(view7);
            p45 d5 = p45.d((TextView) view7.findViewById(R.id.obfuscated_res_0x7f09217d));
            d5.w(R.color.CAM_X0301);
            d5.C(R.string.F_X02);
            View view8 = this.c;
            Intrinsics.checkNotNull(view8);
            View findViewById2 = view8.findViewById(R.id.obfuscated_res_0x7f092175);
            if (this.a.k instanceof pca) {
                ViewGroup.LayoutParams layoutParams = findViewById2.getLayoutParams();
                if (layoutParams != null) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                    layoutParams2.setMarginStart(TbDimenUtil.dp2px(this.a.getApplicationContext(), 12.0f));
                    layoutParams2.setMargins(0, TbDimenUtil.dp2px(this.a.getApplicationContext(), 20.0f), 0, TbDimenUtil.dp2px(this.a.getApplicationContext(), 8.0f));
                    findViewById2.setLayoutParams(layoutParams2);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                }
            }
            p45 d6 = p45.d(findViewById2);
            d6.o(R.string.J_X07);
            d6.f(R.color.CAM_X0205);
            View view9 = this.c;
            Intrinsics.checkNotNull(view9);
            p45.d((TextView) view9.findViewById(R.id.obfuscated_res_0x7f092176)).w(R.color.CAM_X0105);
            View view10 = this.c;
            Intrinsics.checkNotNull(view10);
            WebPManager.setPureDrawable((ImageView) view10.findViewById(R.id.obfuscated_res_0x7f09217e), R.drawable.icon_pure_post_chosen12, R.color.CAM_X0301, null);
            View view11 = this.c;
            Intrinsics.checkNotNull(view11);
            view11.postDelayed(new Runnable() { // from class: com.baidu.tieba.f9a
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        k9a.h(k9a.this);
                    }
                }
            }, 4000L);
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            boolean i = o65.m().i("key_virtual_image_setting_guide_has_show", false);
            if (b() || i) {
                return false;
            }
            o65.m().w("key_virtual_image_setting_guide_has_show", true);
            ((ViewStub) this.a.findViewById(R.id.obfuscated_res_0x7f092895)).inflate();
            View findViewById = this.a.findViewById(R.id.obfuscated_res_0x7f092894);
            this.b = findViewById;
            Intrinsics.checkNotNull(findViewById);
            findViewById.setVisibility(0);
            View view2 = this.b;
            Intrinsics.checkNotNull(view2);
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.g9a
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view3) == null) {
                        k9a.j(k9a.this, view3);
                    }
                }
            });
            a35.m("writeVirtualGuide");
            p45 d = p45.d(this.b);
            d.e(R.string.A_X05);
            d.f(R.color.CAM_X0611);
            View view3 = this.b;
            Intrinsics.checkNotNull(view3);
            p45 d2 = p45.d(view3.findViewById(R.id.obfuscated_res_0x7f092891));
            d2.o(R.string.J_X06);
            d2.f(R.color.CAM_X0201);
            View view4 = this.b;
            Intrinsics.checkNotNull(view4);
            View findViewById2 = view4.findViewById(R.id.obfuscated_res_0x7f092890);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "mVirtualImageGuideView!!…_image_setting_guide_img)");
            ImageView imageView = (ImageView) findViewById2;
            Glide.with(imageView).load(rn6.b("virtual_image_setting_guide.gif", "virtual_image_setting_guide")).into(imageView);
            View view5 = this.b;
            Intrinsics.checkNotNull(view5);
            View findViewById3 = view5.findViewById(R.id.obfuscated_res_0x7f09288e);
            if (this.a.k instanceof pca) {
                ViewGroup.LayoutParams layoutParams = findViewById3.getLayoutParams();
                if (layoutParams != null) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                    layoutParams2.setMarginStart(TbDimenUtil.dp2px(this.a.getApplicationContext(), 100.0f));
                    layoutParams2.setMargins(0, TbDimenUtil.dp2px(this.a.getApplicationContext(), 20.0f), 0, TbDimenUtil.dp2px(this.a.getApplicationContext(), 8.0f));
                    findViewById3.setLayoutParams(layoutParams2);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                }
            }
            p45 d3 = p45.d(findViewById3);
            d3.o(R.string.J_X07);
            d3.f(R.color.CAM_X0205);
            ProfileVirtualImageInfo profileVirtualImageInfo = ProfileVirtualImageInfo.getInstance();
            View view6 = this.b;
            Intrinsics.checkNotNull(view6);
            p45.d((TextView) view6.findViewById(R.id.obfuscated_res_0x7f092892)).w(R.color.CAM_X0105);
            View view7 = this.b;
            Intrinsics.checkNotNull(view7);
            p45.d((TextView) view7.findViewById(R.id.obfuscated_res_0x7f09288f)).w(R.color.CAM_X0105);
            View view8 = this.b;
            Intrinsics.checkNotNull(view8);
            TextView textView = (TextView) view8.findViewById(R.id.obfuscated_res_0x7f09288c);
            if (profileVirtualImageInfo != null && profileVirtualImageInfo.getIsSetVirtualImage() == 1) {
                textView.setVisibility(8);
            } else {
                p45 d4 = p45.d(textView);
                d4.C(R.string.F_X01);
                d4.B(R.dimen.T_X07);
                d4.w(R.color.CAM_X0304);
                d4.o(R.string.J_X07);
                d4.m(R.dimen.L_X02);
                d4.l(R.color.CAM_X0304);
                d4.k(R.string.A_X07);
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.d9a
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view9) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view9) == null) {
                            k9a.k(k9a.this, view9);
                        }
                    }
                });
            }
            View view9 = this.b;
            Intrinsics.checkNotNull(view9);
            view9.postDelayed(new Runnable() { // from class: com.baidu.tieba.e9a
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        k9a.l(k9a.this);
                    }
                }
            }, 4000L);
            return true;
        }
        return invokeV.booleanValue;
    }
}

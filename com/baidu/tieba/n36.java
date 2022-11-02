package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.InterestGuideActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class n36 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;
    public final Context b;
    public View c;
    public RelativeLayout d;
    public RelativeLayout e;
    public ImageView f;
    public TextView g;
    public ImageView h;

    public n36(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = 3;
        this.b = context;
        c();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, v) == null) {
            Intrinsics.checkNotNullParameter(v, "v");
            if (v.getId() == R.id.obfuscated_res_0x7f09056f) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new InterestGuideActivityConfig(this.b, 5)));
                x47.a(1);
            }
        }
    }

    public final View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ImageView imageView = this.h;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCardInterestClose");
                return null;
            }
            return imageView;
        }
        return (View) invokeV.objValue;
    }

    public final View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            View view2 = this.c;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mView");
                return null;
            }
            return view2;
        }
        return (View) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            RelativeLayout relativeLayout = null;
            View inflate = LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d01a0, (ViewGroup) null);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(mContext).inflate(R…card_interest_view, null)");
            this.c = inflate;
            if (inflate == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mView");
                inflate = null;
            }
            View findViewById = inflate.findViewById(R.id.obfuscated_res_0x7f090570);
            Intrinsics.checkNotNullExpressionValue(findViewById, "mView.findViewById(R.id.card_interest_root)");
            this.d = (RelativeLayout) findViewById;
            View view2 = this.c;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mView");
                view2 = null;
            }
            View findViewById2 = view2.findViewById(R.id.obfuscated_res_0x7f09056f);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "mView.findViewById(R.id.card_interest_insind)");
            this.e = (RelativeLayout) findViewById2;
            View view3 = this.c;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mView");
                view3 = null;
            }
            View findViewById3 = view3.findViewById(R.id.obfuscated_res_0x7f09056c);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "mView.findViewById(R.id.card_interest_add)");
            this.f = (ImageView) findViewById3;
            View view4 = this.c;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mView");
                view4 = null;
            }
            View findViewById4 = view4.findViewById(R.id.obfuscated_res_0x7f09056e);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "mView.findViewById(R.id.card_interest_content)");
            this.g = (TextView) findViewById4;
            View view5 = this.c;
            if (view5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mView");
                view5 = null;
            }
            View findViewById5 = view5.findViewById(R.id.obfuscated_res_0x7f09056d);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "mView.findViewById(R.id.card_interest_close)");
            this.h = (ImageView) findViewById5;
            RelativeLayout relativeLayout2 = this.e;
            if (relativeLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCardInterestInsind");
            } else {
                relativeLayout = relativeLayout2;
            }
            relativeLayout.setOnClickListener(this);
            d(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void d(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048579, this, i) == null) && this.a != i) {
            RelativeLayout relativeLayout = this.d;
            ImageView imageView = null;
            if (relativeLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCardInterestRoot");
                relativeLayout = null;
            }
            kw4 d = kw4.d(relativeLayout);
            d.n(R.string.J_X06);
            d.f(R.color.CAM_X0201);
            ImageView imageView2 = this.f;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCardInterestAdd");
                imageView2 = null;
            }
            WebPManager.setPureDrawable(imageView2, R.drawable.obfuscated_res_0x7f0806be, R.color.CAM_X0304, null);
            TextView textView = this.g;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCardInterestContent");
                textView = null;
            }
            kw4 d2 = kw4.d(textView);
            d2.v(R.color.CAM_X0304);
            d2.z(R.dimen.T_X08);
            ImageView imageView3 = this.h;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCardInterestClose");
            } else {
                imageView = imageView3;
            }
            imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_card_close22, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL_PRESS));
        }
    }
}

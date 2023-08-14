package com.baidu.tieba;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class q87 implements i87 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public q87() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.i87
    public SpannableString b(Context context, a77 richTextData, ClickableSpan clickableSpan) {
        InterceptResult invokeLLL;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, richTextData, clickableSpan)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(richTextData, "richTextData");
            Intrinsics.checkNotNullParameter(clickableSpan, "clickableSpan");
            String c = richTextData.f().c();
            SpannableString spannableString = new SpannableString(c);
            int dimens = BdUtilHelper.getDimens(i37.a, R.dimen.L_X01);
            int dimens2 = BdUtilHelper.getDimens(i37.a, R.dimen.tbds10);
            int dimens3 = BdUtilHelper.getDimens(i37.a, R.dimen.T_X10);
            int dimens4 = BdUtilHelper.getDimens(i37.a, R.dimen.M_W_X002);
            int dimens5 = BdUtilHelper.getDimens(i37.a, R.dimen.M_W_X002);
            int dimens6 = BdUtilHelper.getDimens(i37.a, R.dimen.tbds42);
            t57 a = richTextData.f().a();
            if (a != null) {
                i = hb7.a.b(a);
            } else {
                i = R.color.CAM_X0302;
            }
            t57 b = richTextData.f().b();
            if (b != null) {
                i2 = hb7.a.b(b);
            } else {
                i2 = R.color.CAM_X0101;
            }
            d95 d95Var = new d95(dimens, -1, i, dimens3, i2, dimens4, dimens6);
            d95Var.b(dimens2);
            d95Var.i(dimens5);
            d95Var.f(true);
            d95Var.g(true);
            d95Var.d(BdUtilHelper.getDimens(i37.a, R.dimen.tbds7));
            spannableString.setSpan(d95Var, 0, c.length(), 17);
            if (!TextUtils.isEmpty(richTextData.d())) {
                spannableString.setSpan(clickableSpan, 0, c.length(), 33);
            }
            return spannableString;
        }
        return (SpannableString) invokeLLL.objValue;
    }
}

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
/* loaded from: classes6.dex */
public final class kb7 implements cb7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public kb7() {
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

    @Override // com.baidu.tieba.cb7
    public SpannableString b(Context context, t97 richTextData, ClickableSpan clickableSpan) {
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
            int dimens = BdUtilHelper.getDimens(a67.a, R.dimen.L_X01);
            int dimens2 = BdUtilHelper.getDimens(a67.a, R.dimen.tbds10);
            int dimens3 = BdUtilHelper.getDimens(a67.a, R.dimen.T_X10);
            int dimens4 = BdUtilHelper.getDimens(a67.a, R.dimen.M_W_X002);
            int dimens5 = BdUtilHelper.getDimens(a67.a, R.dimen.M_W_X002);
            int dimens6 = BdUtilHelper.getDimens(a67.a, R.dimen.tbds42);
            m87 a = richTextData.f().a();
            if (a != null) {
                i = ce7.a.b(a);
            } else {
                i = R.color.CAM_X0302;
            }
            m87 b = richTextData.f().b();
            if (b != null) {
                i2 = ce7.a.b(b);
            } else {
                i2 = R.color.CAM_X0101;
            }
            u95 u95Var = new u95(dimens, -1, i, dimens3, i2, dimens4, dimens6);
            u95Var.b(dimens2);
            u95Var.i(dimens5);
            u95Var.f(true);
            u95Var.g(true);
            u95Var.d(BdUtilHelper.getDimens(a67.a, R.dimen.tbds7));
            spannableString.setSpan(u95Var, 0, c.length(), 17);
            if (!TextUtils.isEmpty(richTextData.d())) {
                spannableString.setSpan(clickableSpan, 0, c.length(), 33);
            }
            return spannableString;
        }
        return (SpannableString) invokeLLL.objValue;
    }
}

package com.baidu.tieba;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class zy6 implements ry6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public zy6() {
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

    @Override // com.baidu.tieba.ry6
    public SpannableString b(Context context, sx6 richTextData, ClickableSpan clickableSpan) {
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
            int g = ii.g(yu6.a, R.dimen.L_X01);
            int g2 = ii.g(yu6.a, R.dimen.tbds10);
            int g3 = ii.g(yu6.a, R.dimen.T_X10);
            int g4 = ii.g(yu6.a, R.dimen.M_W_X002);
            int g5 = ii.g(yu6.a, R.dimen.M_W_X002);
            int g6 = ii.g(yu6.a, R.dimen.tbds42);
            xw6 a = richTextData.f().a();
            if (a != null) {
                i = h17.a.b(a);
            } else {
                i = R.color.CAM_X0302;
            }
            xw6 b = richTextData.f().b();
            if (b != null) {
                i2 = h17.a.b(b);
            } else {
                i2 = R.color.CAM_X0101;
            }
            t45 t45Var = new t45(g, -1, i, g3, i2, g4, g6);
            t45Var.b(g2);
            t45Var.i(g5);
            t45Var.f(true);
            t45Var.g(true);
            t45Var.d(ii.g(yu6.a, R.dimen.tbds7));
            spannableString.setSpan(t45Var, 0, c.length(), 17);
            if (!TextUtils.isEmpty(richTextData.d())) {
                spannableString.setSpan(clickableSpan, 0, c.length(), 33);
            }
            return spannableString;
        }
        return (SpannableString) invokeLLL.objValue;
    }
}

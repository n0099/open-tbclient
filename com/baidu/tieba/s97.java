package com.baidu.tieba;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.b55;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class s97 implements j97 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public s97() {
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

    @Override // com.baidu.tieba.j97
    public SpannableString b(Context context, k77 richTextData, ClickableSpan clickableSpan) {
        InterceptResult invokeLLL;
        Unit unit;
        Unit unit2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, richTextData, clickableSpan)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(richTextData, "richTextData");
            Intrinsics.checkNotNullParameter(clickableSpan, "clickableSpan");
            String c = richTextData.g().c();
            SpannableString spannableString = new SpannableString(c);
            int dimens = BdUtilHelper.getDimens(h27.a, R.dimen.L_X02);
            int dimens2 = BdUtilHelper.getDimens(h27.a, R.dimen.tbds10);
            int dimens3 = BdUtilHelper.getDimens(h27.a, R.dimen.T_X10);
            int dimens4 = BdUtilHelper.getDimens(h27.a, R.dimen.M_W_X002);
            int dimens5 = BdUtilHelper.getDimens(context, R.dimen.tbds1);
            int dimens6 = BdUtilHelper.getDimens(h27.a, R.dimen.M_W_X002);
            int dimens7 = BdUtilHelper.getDimens(h27.a, R.dimen.tbds40);
            b55.a aVar = new b55.a();
            n57 b = richTextData.g().b();
            if (b != null) {
                aVar.a = rc7.a.d(b);
                aVar.b = rc7.a.c(b);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                aVar.a = SkinManager.getColor(0, (int) R.color.CAM_X0306);
                aVar.b = SkinManager.getColor(4, (int) R.color.CAM_X0306);
            }
            b55.a aVar2 = new b55.a();
            n57 a = richTextData.g().a();
            if (a != null) {
                aVar2.a = rc7.a.d(a);
                aVar2.b = rc7.a.c(a);
                unit2 = Unit.INSTANCE;
            } else {
                unit2 = null;
            }
            if (unit2 == null) {
                aVar2.a = SkinManager.getColor(0, (int) R.color.CAM_X0306);
                aVar2.b = SkinManager.getColor(4, (int) R.color.CAM_X0306);
            }
            b55 b55Var = new b55(dimens, -1, aVar2, dimens3, aVar, dimens4, dimens7);
            b55Var.b(dimens2);
            b55Var.h(dimens5);
            b55Var.i(dimens6);
            b55Var.f(false);
            b55Var.g(true);
            b55Var.a(0.5f);
            b55Var.d(BdUtilHelper.getDimens(h27.a, R.dimen.tbds7));
            spannableString.setSpan(b55Var, 0, c.length(), 17);
            if (!TextUtils.isEmpty(richTextData.e())) {
                spannableString.setSpan(clickableSpan, 0, c.length(), 33);
            }
            return spannableString;
        }
        return (SpannableString) invokeLLL.objValue;
    }
}

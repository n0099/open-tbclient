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
import kotlin.text.StringsKt__StringsJVMKt;
/* loaded from: classes6.dex */
public final class j77 implements e77 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public j77() {
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

    @Override // com.baidu.tieba.e77
    public SpannableString b(Context context, f67 richTextData, ClickableSpan clickableSpan) {
        InterceptResult invokeLLL;
        k57 b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, richTextData, clickableSpan)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(richTextData, "richTextData");
            Intrinsics.checkNotNullParameter(clickableSpan, "clickableSpan");
            i67 f = richTextData.f();
            SpannableString spannableString = new SpannableString(f.c());
            if (!TextUtils.isEmpty(richTextData.d()) && f.b() != null) {
                if ((clickableSpan instanceof f77) && (b = f.b()) != null) {
                    ((f77) clickableSpan).a(u97.a.a(b));
                }
                int length = f.c().length();
                if (StringsKt__StringsJVMKt.endsWith$default(f.c(), " ", false, 2, null)) {
                    length = f.c().length() - 1;
                }
                spannableString.setSpan(clickableSpan, 0, length, 33);
            }
            return spannableString;
        }
        return (SpannableString) invokeLLL.objValue;
    }
}

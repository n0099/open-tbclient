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
/* loaded from: classes7.dex */
public final class n87 implements i87 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public n87() {
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
        t57 b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, richTextData, clickableSpan)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(richTextData, "richTextData");
            Intrinsics.checkNotNullParameter(clickableSpan, "clickableSpan");
            f77 f = richTextData.f();
            SpannableString spannableString = new SpannableString(f.c());
            if (!TextUtils.isEmpty(richTextData.d()) && f.b() != null) {
                if ((clickableSpan instanceof j87) && (b = f.b()) != null) {
                    ((j87) clickableSpan).a(hb7.a.a(b));
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

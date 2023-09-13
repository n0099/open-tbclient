package com.baidu.tieba;

import android.graphics.Color;
import android.text.TextUtils;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class m61 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @ColorInt
    public static int a(@Nullable String str, @ColorRes int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65536, null, str, i)) == null) {
            if (TextUtils.isEmpty(str)) {
                return ContextCompat.getColor(tj0.b(), i);
            }
            try {
                return Color.parseColor(str);
            } catch (IllegalArgumentException unused) {
                return ContextCompat.getColor(tj0.b(), i);
            }
        }
        return invokeLI.intValue;
    }
}

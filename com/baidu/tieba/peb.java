package com.baidu.tieba;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.IEruptionStrategyGroup;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Set;
import kotlin.collections.SetsKt__SetsKt;
/* loaded from: classes7.dex */
public final class peb {
    public static /* synthetic */ Interceptable $ic;
    public static final Set<String> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948060572, "Lcom/baidu/tieba/peb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948060572, "Lcom/baidu/tieba/peb;");
                return;
            }
        }
        a = SetsKt__SetsKt.setOf((Object[]) new String[]{"M", "L", IEruptionStrategyGroup.STRATEGY_MODIFIER_H, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "C", ExifInterface.LATITUDE_SOUTH, "Q", "R", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Z", "m", "l", "h", "v", "c", "s", "q", "r", "a", "z"});
    }
}

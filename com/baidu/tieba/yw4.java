package com.baidu.tieba;

import com.baidu.tbadk.data.DialogStrategiesData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class yw4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void b(List<? extends DialogStrategiesData> list, List<? extends DialogStrategiesData> list2) {
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, list, list2) == null) {
            for (DialogStrategiesData dialogStrategiesData : list) {
                Iterator<T> it = list2.iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj = it.next();
                        if (Intrinsics.areEqual(((DialogStrategiesData) obj).getDialogName(), dialogStrategiesData.getDialogName())) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                DialogStrategiesData dialogStrategiesData2 = (DialogStrategiesData) obj;
                if (dialogStrategiesData2 != null) {
                    DialogStrategiesData.StrategiesConfigData c = c(dialogStrategiesData2, "FREQUENCE_STRATEGY");
                    boolean z = false;
                    if (c != null && d(c, c(dialogStrategiesData, "FREQUENCE_STRATEGY"))) {
                        z = true;
                    }
                    if (z) {
                        ww4 ww4Var = ww4.a;
                        String dialogName = dialogStrategiesData.getDialogName();
                        Intrinsics.checkNotNullExpressionValue(dialogName, "ori.dialogName");
                        ww4Var.b(dialogName);
                    }
                }
            }
        }
    }

    public static final DialogStrategiesData.StrategiesConfigData c(DialogStrategiesData dialogStrategiesData, String str) {
        InterceptResult invokeLL;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, dialogStrategiesData, str)) == null) {
            List<DialogStrategiesData.StrategiesConfigData> dialogStrategy = dialogStrategiesData.getDialogStrategy();
            Intrinsics.checkNotNullExpressionValue(dialogStrategy, "dialogStrategy");
            Iterator<T> it = dialogStrategy.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (Intrinsics.areEqual(str, ((DialogStrategiesData.StrategiesConfigData) obj).getType())) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            return (DialogStrategiesData.StrategiesConfigData) obj;
        }
        return (DialogStrategiesData.StrategiesConfigData) invokeLL.objValue;
    }

    public static final boolean d(DialogStrategiesData.StrategiesConfigData strategiesConfigData, DialogStrategiesData.StrategiesConfigData strategiesConfigData2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, strategiesConfigData, strategiesConfigData2)) == null) {
            if (strategiesConfigData2 != null) {
                if (Intrinsics.areEqual(strategiesConfigData.H().get("startTimestamp"), strategiesConfigData2.H().get("startTimestamp")) && Intrinsics.areEqual(strategiesConfigData.H().get("endTimestamp"), strategiesConfigData2.H().get("endTimestamp"))) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}

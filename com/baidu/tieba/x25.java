package com.baidu.tieba;

import com.baidu.tbadk.core.log.YunDialogLog;
import com.baidu.tbadk.data.DialogStrategiesData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SetsKt___SetsKt;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class x25 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00e6, code lost:
        if (d(r3, r4) == true) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void b(List<? extends DialogStrategiesData> list, List<? extends DialogStrategiesData> list2) {
        DialogStrategiesData.StrategiesConfigData strategiesConfigData;
        Object obj;
        Object obj2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, list, list2) == null) {
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
            for (DialogStrategiesData dialogStrategiesData : list) {
                arrayList.add(dialogStrategiesData.getDialogName());
            }
            Set set = CollectionsKt___CollectionsKt.toSet(arrayList);
            ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10));
            for (DialogStrategiesData dialogStrategiesData2 : list2) {
                arrayList2.add(dialogStrategiesData2.getDialogName());
            }
            for (String name : SetsKt___SetsKt.plus(set, (Iterable) CollectionsKt___CollectionsKt.toSet(arrayList2))) {
                Iterator<T> it = list.iterator();
                while (true) {
                    strategiesConfigData = null;
                    if (it.hasNext()) {
                        obj = it.next();
                        if (Intrinsics.areEqual(((DialogStrategiesData) obj).getDialogName(), name)) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                DialogStrategiesData dialogStrategiesData3 = (DialogStrategiesData) obj;
                Iterator<T> it2 = list2.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        obj2 = it2.next();
                        if (Intrinsics.areEqual(((DialogStrategiesData) obj2).getDialogName(), name)) {
                            break;
                        }
                    } else {
                        obj2 = null;
                        break;
                    }
                }
                DialogStrategiesData dialogStrategiesData4 = (DialogStrategiesData) obj2;
                if (dialogStrategiesData3 == null || dialogStrategiesData4 == null) {
                    YunDialogLog.getInstance().c("YunDialogManager", "本地或远程没有弹窗 " + name + " ，准备重置频次");
                    v25 v25Var = v25.a;
                    Intrinsics.checkNotNullExpressionValue(name, "name");
                    v25Var.b(name);
                }
                boolean z = true;
                if (dialogStrategiesData3 != null && (r3 = c(dialogStrategiesData3, "FREQUENCE_STRATEGY")) != null) {
                    if (dialogStrategiesData4 != null) {
                        strategiesConfigData = c(dialogStrategiesData4, "FREQUENCE_STRATEGY");
                    }
                }
                z = false;
                if (z) {
                    YunDialogLog.getInstance().c("YunDialogManager", "云弹窗 " + name + " 频次配置更新，准备重置频次");
                    v25 v25Var2 = v25.a;
                    Intrinsics.checkNotNullExpressionValue(name, "name");
                    v25Var2.b(name);
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
                if (!Intrinsics.areEqual(strategiesConfigData.O().get("startTimestamp"), strategiesConfigData2.O().get("startTimestamp")) || !Intrinsics.areEqual(strategiesConfigData.O().get("endTimestamp"), strategiesConfigData2.O().get("endTimestamp")) || !Intrinsics.areEqual(strategiesConfigData.O().get("frequence"), strategiesConfigData2.O().get("frequence"))) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}

package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.dialog.yun.strategy.FrequenceDialogStrategy;
import com.baidu.tbadk.core.log.YunDialogLog;
import com.baidu.tbadk.data.DialogStrategiesData;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.log.TbLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SetsKt___SetsKt;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class j75 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.tieba.i75.a(java.lang.String):void] */
    public static final /* synthetic */ void a(List list) {
        c(list);
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.tieba.i75.a(java.lang.String):void] */
    public static final /* synthetic */ void b(List list, List list2) {
        d(list, list2);
    }

    public static final void c(List<? extends DialogStrategiesData> list) {
        Map<String, Object> data;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, list) == null) {
            for (DialogStrategiesData dialogStrategiesData : list) {
                try {
                    DialogStrategiesData.StrategiesConfigData e = e(dialogStrategiesData, "NEW_FREQUENCE_STRATEGY");
                    if (e != null && (data = e.N()) != null) {
                        Intrinsics.checkNotNullExpressionValue(data, "data");
                        FrequenceDialogStrategy.Data data2 = (FrequenceDialogStrategy.Data) DataExt.toEntity(data, FrequenceDialogStrategy.Data.class);
                        if (data2 != null) {
                            g75 g75Var = g75.a;
                            String dialogName = dialogStrategiesData.getDialogName();
                            Intrinsics.checkNotNullExpressionValue(dialogName, "it.dialogName");
                            int b = g75Var.b(dialogName);
                            int i = data2.frequenceClearVersion;
                            if (i != b) {
                                TbLog yunDialogLog = YunDialogLog.getInstance();
                                yunDialogLog.i(YunDialogManager.LOG_KEY, "云弹窗 " + dialogStrategiesData.getDialogName() + " 频次重置版本更新，准备重置频次");
                                g75 g75Var2 = g75.a;
                                String dialogName2 = dialogStrategiesData.getDialogName();
                                Intrinsics.checkNotNullExpressionValue(dialogName2, "it.dialogName");
                                g75Var2.f(dialogName2, i);
                            }
                        }
                    }
                } catch (Exception e2) {
                    if (!TbadkCoreApplication.getInst().isDebugMode()) {
                        TbLog yunDialogLog2 = YunDialogLog.getInstance();
                        yunDialogLog2.e(YunDialogManager.LOG_KEY, "新版云弹窗频次重置策略异常" + e2.getMessage());
                        e2.printStackTrace();
                    } else {
                        throw e2;
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00e6, code lost:
        if (f(r3, r4) == true) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void d(List<? extends DialogStrategiesData> list, List<? extends DialogStrategiesData> list2) {
        DialogStrategiesData.StrategiesConfigData strategiesConfigData;
        Object obj;
        Object obj2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, list, list2) == null) {
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
                    YunDialogLog.getInstance().i(YunDialogManager.LOG_KEY, "本地或远程没有弹窗 " + name + " ，准备重置频次");
                    h75 h75Var = h75.a;
                    Intrinsics.checkNotNullExpressionValue(name, "name");
                    h75Var.b(name);
                }
                boolean z = true;
                if (dialogStrategiesData3 != null && (r3 = e(dialogStrategiesData3, "FREQUENCE_STRATEGY")) != null) {
                    if (dialogStrategiesData4 != null) {
                        strategiesConfigData = e(dialogStrategiesData4, "FREQUENCE_STRATEGY");
                    }
                }
                z = false;
                if (z) {
                    YunDialogLog.getInstance().i(YunDialogManager.LOG_KEY, "云弹窗 " + name + " 频次配置更新，准备重置频次");
                    h75 h75Var2 = h75.a;
                    Intrinsics.checkNotNullExpressionValue(name, "name");
                    h75Var2.b(name);
                }
            }
        }
    }

    public static final DialogStrategiesData.StrategiesConfigData e(DialogStrategiesData dialogStrategiesData, String str) {
        InterceptResult invokeLL;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, dialogStrategiesData, str)) == null) {
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

    public static final boolean f(DialogStrategiesData.StrategiesConfigData strategiesConfigData, DialogStrategiesData.StrategiesConfigData strategiesConfigData2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, strategiesConfigData, strategiesConfigData2)) == null) {
            if (strategiesConfigData2 != null) {
                if (!Intrinsics.areEqual(strategiesConfigData.N().get("startTimestamp"), strategiesConfigData2.N().get("startTimestamp")) || !Intrinsics.areEqual(strategiesConfigData.N().get("endTimestamp"), strategiesConfigData2.N().get("endTimestamp")) || !Intrinsics.areEqual(strategiesConfigData.N().get("frequence"), strategiesConfigData2.N().get("frequence"))) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}

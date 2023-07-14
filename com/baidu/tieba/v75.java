package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.dialog.yun.strategy.FrequenceDialogStrategy;
import com.baidu.tbadk.core.log.YunDialogLog;
import com.baidu.tbadk.data.DialogStrategiesData;
import com.baidu.tbadk.util.DataExt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class v75 implements k75 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public v75() {
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

    @Override // com.baidu.tieba.k75
    public Map<String, Object> a(DialogStrategiesData dialogData, Map<String, Object> strategyData, Map<String, Object> extraData) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, dialogData, strategyData, extraData)) == null) {
            Intrinsics.checkNotNullParameter(dialogData, "dialogData");
            Intrinsics.checkNotNullParameter(strategyData, "strategyData");
            Intrinsics.checkNotNullParameter(extraData, "extraData");
            HashMap hashMap = new HashMap(strategyData);
            hashMap.put("dialogName", dialogData.getDialogName());
            return hashMap;
        }
        return (Map) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.k75
    public boolean b(Map<String, Object> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map)) == null) {
            Intrinsics.checkNotNullParameter(map, "map");
            boolean z = false;
            try {
                FrequenceDialogStrategy.Data data = (FrequenceDialogStrategy.Data) DataExt.toEntity(map, FrequenceDialogStrategy.Data.class);
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                if (currentTimeMillis >= data.startTimestamp && currentTimeMillis <= data.endTimestamp) {
                    if (data.frequence == 0) {
                        return true;
                    }
                    w75 w75Var = w75.a;
                    String str = data.dialogName;
                    Intrinsics.checkNotNullExpressionValue(str, "data.dialogName");
                    int a = w75Var.a(str);
                    if (a < data.frequence) {
                        z = true;
                    }
                    if (!z) {
                        h29 yunDialogLog = YunDialogLog.getInstance();
                        yunDialogLog.c("YunDialogManager", "云弹窗 " + data.dialogName + " 命中频次超限限制，当前已展示次数：" + a + "，配置展现次数：" + data.frequence);
                    }
                    return z;
                }
                h29 yunDialogLog2 = YunDialogLog.getInstance();
                yunDialogLog2.c("YunDialogManager", "云弹窗 " + data.dialogName + " 命中频次时间限制，当前时间戳：" + currentTimeMillis + " 配置时间：" + data.startTimestamp + " - " + data.endTimestamp);
                return false;
            } catch (Exception e) {
                if (!TbadkApplication.getInst().isDebugMode()) {
                    YunDialogLog.getInstance().c("YunDialogManager", "云弹窗频次策略解析失败");
                    return false;
                }
                throw e;
            }
        }
        return invokeL.booleanValue;
    }
}

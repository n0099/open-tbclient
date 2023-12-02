package com.baidu.tieba;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.log.YunDialogLog;
import com.baidu.tbadk.data.DialogStrategiesData;
import com.baidu.tieba.log.TbLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes9.dex */
public class x48 implements c25 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public x48() {
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

    @Override // com.baidu.tieba.c25
    @NonNull
    public Map<String, Object> a(@NonNull DialogStrategiesData dialogStrategiesData, @NonNull Map<String, Object> map, @NonNull Map<String, Object> map2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, dialogStrategiesData, map, map2)) == null) {
            HashMap hashMap = new HashMap(map);
            hashMap.put("dialogName", "frsShield");
            hashMap.putAll(map);
            hashMap.putAll(map2);
            return hashMap;
        }
        return (Map) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.c25
    public boolean b(@NonNull Map<String, Object> map) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map)) == null) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            boolean z2 = false;
            if (currentActivity instanceof i25) {
                i25 i25Var = (i25) currentActivity;
                if (i25Var.i1() != null) {
                    h25 i1 = i25Var.i1();
                    if (!i1.R0() && i1.W() != null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        TbLog yunDialogLog = YunDialogLog.getInstance();
                        StringBuilder sb = new StringBuilder();
                        sb.append("吧内屏蔽弹窗策略校验失败：Frs是否展示过弹窗->");
                        sb.append(i1.R0());
                        sb.append("|是否存在FRS数据->");
                        if (i1.W() != null) {
                            z2 = true;
                        }
                        sb.append(z2);
                        yunDialogLog.e(YunDialogManager.LOG_KEY, sb.toString());
                    }
                    return z;
                }
            }
            YunDialogLog.getInstance().e(YunDialogManager.LOG_KEY, "吧内屏蔽弹窗策略校验失败：获取到的IForumDialogExtSupport为空");
            return false;
        }
        return invokeL.booleanValue;
    }
}

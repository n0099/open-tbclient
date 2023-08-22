package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.log.YunDialogLog;
import com.baidu.tbadk.data.DialogStrategiesData;
import com.baidu.tieba.log.TbLog;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class p65 implements l65 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948014010, "Lcom/baidu/tieba/p65;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948014010, "Lcom/baidu/tieba/p65;");
        }
    }

    public p65() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.l65
    public Map<String, Object> a(DialogStrategiesData dialogData, Map<String, ? extends Object> strategyData, Map<String, ? extends Object> extraData) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, dialogData, strategyData, extraData)) == null) {
            Intrinsics.checkNotNullParameter(dialogData, "dialogData");
            Intrinsics.checkNotNullParameter(strategyData, "strategyData");
            Intrinsics.checkNotNullParameter(extraData, "extraData");
            HashMap hashMap = new HashMap(strategyData);
            hashMap.put("dialog_url", dialogData.getDialogUrl());
            hashMap.putAll(extraData);
            return hashMap;
        }
        return (Map) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.l65
    public boolean b(Map<String, ? extends Object> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map)) == null) {
            Intrinsics.checkNotNullParameter(map, "map");
            Object obj = map.get("dialog_url");
            if ((obj instanceof String) && !TextUtils.isEmpty((CharSequence) obj)) {
                Object obj2 = map.get("check_preheat");
                if (obj2 != null && Intrinsics.areEqual("1", obj2.toString()) && !cy5.b().e((String) obj)) {
                    YunDialogLog.getInstance().e("HybridCheckStrategy", "H5弹窗未预热完成");
                    return false;
                }
                try {
                    Object obj3 = map.get("init_offline_module");
                    if ((obj3 instanceof String) && !TextUtils.isEmpty((CharSequence) obj3)) {
                        TbLog yunDialogLog = YunDialogLog.getInstance();
                        yunDialogLog.i("HybridCheckStrategy", "主动初始化离线包:" + obj3);
                        HashSet hashSet = new HashSet();
                        hashSet.add(obj3);
                        fz4.d(hashSet);
                        TbLog yunDialogLog2 = YunDialogLog.getInstance();
                        yunDialogLog2.i("HybridCheckStrategy", "离线包主动初始化完成:" + obj3);
                    }
                } catch (Exception e) {
                    TbLog yunDialogLog3 = YunDialogLog.getInstance();
                    yunDialogLog3.e("HybridCheckStrategy", "离线包手动初始化异常:" + e);
                }
                Object obj4 = map.get("check_offline");
                if (obj4 != null && Intrinsics.areEqual("1", obj4.toString()) && !fz4.c((String) obj)) {
                    YunDialogLog.getInstance().e("HybridCheckStrategy", "离线包不可用");
                    return false;
                }
                return true;
            }
            YunDialogLog.getInstance().e("HybridCheckStrategy", "未下发待检测的H5弹窗url");
            return false;
        }
        return invokeL.booleanValue;
    }
}

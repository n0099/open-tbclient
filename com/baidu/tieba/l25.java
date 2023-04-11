package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.yun.YunDialogDataManager;
import com.baidu.tbadk.data.DialogStrategiesData;
import com.baidu.tbadk.util.DataExt;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class l25 {
    public static /* synthetic */ Interceptable $ic;
    public static final l25 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947891002, "Lcom/baidu/tieba/l25;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947891002, "Lcom/baidu/tieba/l25;");
                return;
            }
        }
        a = new l25();
    }

    public l25() {
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

    public final void a(String json) {
        boolean z;
        List entityList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, json) == null) {
            Intrinsics.checkNotNullParameter(json, "json");
            String k = YunDialogDataManager.k();
            me<String> g = b05.g("tb.dialog_strategies_data", TbadkCoreApplication.getCurrentAccount(), k);
            if (g != null) {
                String str = g.get(k);
                if (str != null) {
                    if (str.length() > 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        str = null;
                    }
                    if (str != null && (entityList = DataExt.toEntityList(str, DialogStrategiesData.class)) != null) {
                        List entityList2 = DataExt.toEntityList(json, DialogStrategiesData.class);
                        Intrinsics.checkNotNullExpressionValue(entityList2, "toEntityList(json, Dialo…rategiesData::class.java)");
                        m25.b(entityList, entityList2);
                    }
                }
                g.a(k, json);
            }
        }
    }
}

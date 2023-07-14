package com.baidu.tieba;

import com.baidu.adp.log.DefaultLog;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.data.DialogStrategiesData;
import com.baidu.tieba.easteregg.data.EasterEggAdData;
import com.baidu.tieba.easteregg.data.EasterEggAdDataHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class nz6 implements k75 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public nz6() {
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
            hashMap.put("dialogName", "easterEgg");
            hashMap.putAll(strategyData);
            hashMap.putAll(extraData);
            return hashMap;
        }
        return (Map) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.k75
    public boolean b(Map<String, Object> map) {
        InterceptResult invokeL;
        int i;
        Unit unit;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map)) == null) {
            Intrinsics.checkNotNullParameter(map, "map");
            DefaultLog.getInstance().c("easterEgg", "彩蛋广告触发云弹窗判断逻辑");
            if (v85.a().b() != 3) {
                h29 defaultLog = DefaultLog.getInstance();
                defaultLog.b("easterEgg", "彩蛋广告不展示，非用户启动，启动类型：" + v85.a().b());
                return false;
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null) {
                currentAccount = StringUtil.NULL_STRING;
            }
            Integer num = kia.h.a().c().get(currentAccount);
            if (num != null) {
                i = num.intValue();
            } else {
                i = 0;
            }
            if (i >= 1) {
                h29 defaultLog2 = DefaultLog.getInstance();
                defaultLog2.b("easterEgg", "彩蛋广告不展示，当前用户：" + currentAccount + "已经展示过彩蛋广告");
                return false;
            }
            EasterEggAdData b = EasterEggAdDataHolder.b.a().b();
            if (b == null) {
                return false;
            }
            DefaultLog.getInstance().c("easterEgg", "彩蛋广告数据不为空");
            if (!b.isValidData()) {
                DefaultLog.getInstance().b("easterEgg", "彩蛋广告不展示，数据不合法");
                return false;
            }
            String url = b.getUrl();
            if (url != null) {
                if (c(url)) {
                    DefaultLog.getInstance().b("easterEgg", "彩蛋广告不展示，已经被手动关闭");
                    return false;
                }
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                DefaultLog.getInstance().b("easterEgg", "彩蛋广告不展示，广告url为空");
                return false;
            }
            DefaultLog.getInstance().c("easterEgg", "彩蛋广告可以展示");
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            da5 p = da5.p();
            return p.l(EasterEggAdData.KEY_EASTER_EGG_AD + TbadkCoreApplication.getCurrentAccount() + str, false);
        }
        return invokeL.booleanValue;
    }
}

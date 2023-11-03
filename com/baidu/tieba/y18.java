package com.baidu.tieba;

import android.app.Activity;
import com.baidu.adp.lib.resourceLoader.BdResourceLoader;
import com.baidu.adp.lib.safe.UiUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.FrsSpriteNewUserGuide;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.log.YunDialogLog;
import com.baidu.tbadk.data.DialogStrategiesData;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import tbclient.ThemeColorInfo;
/* loaded from: classes9.dex */
public final class y18 implements w15 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public y18() {
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

    public static final void d(String resultBgUrl) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, resultBgUrl) == null) {
            Intrinsics.checkNotNullParameter(resultBgUrl, "$resultBgUrl");
            BdResourceLoader.getInstance().loadResource(resultBgUrl, 59, null, null);
        }
    }

    public final void c(ThemeColorInfo themeColorInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, themeColorInfo) != null) || themeColorInfo == null) {
            return;
        }
        final String g = c1b.g(themeColorInfo);
        if (!StringUtils.isNotNull(g)) {
            UiUtils.post(new Runnable() { // from class: com.baidu.tieba.d18
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        y18.d(g);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.w15
    public Map<String, Object> a(DialogStrategiesData dialogData, Map<String, Object> strategyData, Map<String, Object> extraData) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, dialogData, strategyData, extraData)) == null) {
            Intrinsics.checkNotNullParameter(dialogData, "dialogData");
            Intrinsics.checkNotNullParameter(strategyData, "strategyData");
            Intrinsics.checkNotNullParameter(extraData, "extraData");
            HashMap hashMap = new HashMap(strategyData);
            hashMap.put("dialogName", "frsNewUserGuide");
            hashMap.putAll(strategyData);
            hashMap.putAll(extraData);
            return hashMap;
        }
        return (Map) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.w15
    public boolean b(Map<String, Object> map) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map)) == null) {
            Intrinsics.checkNotNullParameter(map, "map");
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity instanceof c25) {
                c25 c25Var = (c25) currentActivity;
                if (c25Var.j1() != null) {
                    ThemeColorInfo themeColorInfo = null;
                    if (!bk5.g(false, 1, null)) {
                        YunDialogLog.getInstance().e(YunDialogManager.LOG_KEY, "新用户弹窗策略校验失败：动画资源未就绪");
                        return false;
                    } else if (!gl5.a.a().b()) {
                        YunDialogLog.getInstance().e(YunDialogManager.LOG_KEY, "新用户弹窗策略校验失败：非新用户");
                        return false;
                    } else {
                        boolean z3 = currentActivity instanceof FrsActivity;
                        if (z3) {
                            jx7 q1 = ((FrsActivity) currentActivity).q1();
                            if (q1 != null && q1.o0()) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (z2) {
                                YunDialogLog.getInstance().e(YunDialogManager.LOG_KEY, "新用户弹窗策略校验失败：用户已关注本吧");
                                return false;
                            }
                        }
                        if (z3) {
                            jx7 q12 = ((FrsActivity) currentActivity).q1();
                            if (q12 != null && q12.U()) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z) {
                                YunDialogLog.getInstance().e(YunDialogManager.LOG_KEY, "新用户弹窗策略校验失败：底部直播动画弹窗存在互斥");
                                return false;
                            }
                        }
                        b25 j1 = c25Var.j1();
                        FrsSpriteNewUserGuide B0 = j1.B0();
                        if (B0 == null) {
                            return false;
                        }
                        if (!B0.isValid()) {
                            YunDialogLog.getInstance().e(YunDialogManager.LOG_KEY, "新用户弹窗策略校验失败：该吧未下发新用户引导配置");
                        }
                        long millis = TimeUnit.SECONDS.toMillis(B0.bubblePeriod);
                        long W1 = j1.W1();
                        if (W1 > 0 && System.currentTimeMillis() - W1 < millis) {
                            return false;
                        }
                        FrsSpriteNewUserGuide.BubbleText bubbleText = B0.bubbleText;
                        if (bubbleText != null) {
                            themeColorInfo = bubbleText.bgUrlTheme;
                        }
                        c(themeColorInfo);
                        return true;
                    }
                }
            }
            YunDialogLog.getInstance().e(YunDialogManager.LOG_KEY, "新用户弹窗策略校验失败：获取到的IForumDialogExtSupport为空");
            return false;
        }
        return invokeL.booleanValue;
    }
}

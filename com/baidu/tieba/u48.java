package com.baidu.tieba;

import android.app.Activity;
import com.baidu.adp.lib.resourceLoader.BdResourceLoader;
import com.baidu.adp.lib.safe.UiUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.FrsSpriteNewUserGuide;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.log.YunDialogLog;
import com.baidu.tbadk.data.DialogStrategiesData;
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
/* loaded from: classes8.dex */
public final class u48 implements c25 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public u48() {
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
        final String g = z5b.g(themeColorInfo);
        if (!StringUtils.isNotNull(g)) {
            UiUtils.post(new Runnable() { // from class: com.baidu.tieba.y38
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        u48.d(g);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.c25
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

    @Override // com.baidu.tieba.c25
    public boolean b(Map<String, Object> map) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map)) == null) {
            Intrinsics.checkNotNullParameter(map, "map");
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity instanceof i25) {
                i25 i25Var = (i25) currentActivity;
                if (i25Var.i1() != null) {
                    ThemeColorInfo themeColorInfo = null;
                    if (!lk5.g(false, 1, null)) {
                        YunDialogLog.getInstance().e(YunDialogManager.LOG_KEY, "新用户弹窗策略校验失败：动画资源未就绪");
                        return false;
                    } else if (!rl5.a.a().b()) {
                        YunDialogLog.getInstance().e(YunDialogManager.LOG_KEY, "新用户弹窗策略校验失败：非新用户");
                        return false;
                    } else {
                        h25 i1 = i25Var.i1();
                        ForumData a1 = i1.a1();
                        if (a1 != null && a1.isLike() == 1) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            YunDialogLog.getInstance().e(YunDialogManager.LOG_KEY, "新用户弹窗策略校验失败：用户已关注本吧");
                            return false;
                        } else if (i1.I0()) {
                            YunDialogLog.getInstance().e(YunDialogManager.LOG_KEY, "新用户弹窗策略校验失败：底部直播动画弹窗存在互斥");
                            return false;
                        } else {
                            FrsSpriteNewUserGuide F0 = i1.F0();
                            if (F0 == null) {
                                return false;
                            }
                            if (F0.isValid()) {
                                FrsSpriteNewUserGuide.BubbleText bubbleText = F0.bubbleText;
                                if (bubbleText != null && bubbleText.type == 1) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                if (z2) {
                                    long millis = TimeUnit.SECONDS.toMillis(F0.bubblePeriod);
                                    long i2 = i1.i2();
                                    if (i2 > 0 && System.currentTimeMillis() - i2 < millis) {
                                        return false;
                                    }
                                    FrsSpriteNewUserGuide.BubbleText bubbleText2 = F0.bubbleText;
                                    if (bubbleText2 != null) {
                                        themeColorInfo = bubbleText2.bgUrlTheme;
                                    }
                                    c(themeColorInfo);
                                    return true;
                                }
                            }
                            YunDialogLog.getInstance().e(YunDialogManager.LOG_KEY, "新用户弹窗策略校验失败：该吧未下发新用户引导配置");
                            return false;
                        }
                    }
                }
            }
            YunDialogLog.getInstance().e(YunDialogManager.LOG_KEY, "新用户弹窗策略校验失败：获取到的IForumDialogExtSupport为空");
            return false;
        }
        return invokeL.booleanValue;
    }
}

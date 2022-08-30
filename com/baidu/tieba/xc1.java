package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.searchbox.devicescore.DeviceScoreCollectFetcher;
import com.baidu.searchbox.devicescore.DeviceScoreConfigFetcher;
import com.baidu.searchbox.devicescore.DeviceScoreFetcher;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.searchbox.live.interfaces.defaultimpl.service.LivePreStartPlayServiceFetcher;
import com.baidu.searchbox.live.interfaces.defaultimpl.service.MultiPluginManagerServiceFetcher;
import com.baidu.searchbox.live.interfaces.defaultimpl.service.YYPluginManageServiceFetcher;
import com.baidu.searchbox.live.service.Media2YYServiceFetcher;
import com.baidu.searchbox.live.service.PluginInvokeServiceFetcher;
import com.baidu.searchbox.live.service.YY2MediaServiceFetcher;
import com.baidu.searchbox.live.service.YYPluginProgressInvokeServiceFetcher;
import com.baidu.searchbox.logsystem.exceptionhandler.impl.ExceptionHandlerServiceFetcher;
import com.baidu.searchbox.performance.speed.SpeedRuntimeProvider;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.tbadk.abtest.helper.HttpsExperimentFetcher;
import com.baidu.tbadk.abtest.helper.NetExperimentFetcher;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.UBC;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public class xc1 {
    public static /* synthetic */ Interceptable $ic;
    public static final ConcurrentHashMap<ServiceReference, wc1<?>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948295459, "Lcom/baidu/tieba/xc1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948295459, "Lcom/baidu/tieba/xc1;");
                return;
            }
        }
        a = new ConcurrentHashMap<>();
        d();
    }

    public xc1() {
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

    public static <T> T a(ServiceReference serviceReference) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, serviceReference)) == null) {
            wc1<?> wc1Var = a.get(serviceReference);
            if (wc1Var != null) {
                return (T) wc1Var.getService();
            }
            return null;
        }
        return (T) invokeL.objValue;
    }

    public static <T> void b(ServiceReference serviceReference, wc1<T> wc1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, serviceReference, wc1Var) == null) {
            a.put(serviceReference, wc1Var);
        }
    }

    public static <T> void c(String str, String str2, Class<? extends wc1<T>> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2, cls) == null) {
            try {
                b(new ServiceReference(str, str2), cls.newInstance());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            c("Frs", "FrsService", qf6.class);
            c("HotTopic", "HotTopicRequest", ek5.class);
            c("device_score", "DEVICE_SCORE", DeviceScoreFetcher.class);
            c("device_score", "DEVICE_SCORE_COLLECT", DeviceScoreCollectFetcher.class);
            c("device_score", "DEVICE_SCORE_CONFIG", DeviceScoreConfigFetcher.class);
            c("live", "ab", qi7.class);
            c("live", DI.ACCOUNT, fi7.class);
            c("live", DI.APP_INFO_NAME, hi7.class);
            c("live", DI.EXT.EXT_LIVE_JUMP_PAGE, wi7.class);
            c("live", DI.EXT.EXT_LIVE_LOG, dj7.class);
            c("live", DI.FOLLOW_STATUS, ui7.class);
            c("live", DI.LIGHTBROWSER_VIEW, mi7.class);
            c("live", DI.LIVE_CUSTOM_SETTINGS, zj7.class);
            c("live", DI.LIVE_EVENT_DISPATCHER, si7.class);
            c("live", DI.LIVE_LIKE, yi7.class);
            c("live", DI.LIVE_LOCATION, bj7.class);
            c("live", DI.LIVE_REAL_AUTH, ji7.class);
            c("live", DI.LIVE_SHOW_VIDEO_PLAYER, lj7.class);
            c("live", DI.MINI_SHELL.MEDIA_2_YY, Media2YYServiceFetcher.class);
            c("live", "multi_plugin", MultiPluginManagerServiceFetcher.class);
            c("live", "net", fj7.class);
            c("live", DI.PAY_CHANNEL, oi7.class);
            c("live", DI.LIVE_PLAYER, sj7.class);
            c("live", DI.MINI_SHELL.PLUGIN_MANAGER, PluginInvokeServiceFetcher.class);
            c("live", DI.LIVE_PRE_START_PLAYER, LivePreStartPlayServiceFetcher.class);
            c("live", DI.ROUTER_NAME, xj7.class);
            c("live", "share", dk7.class);
            c("live", DI.TB.SHARE_CHANNEL, bk7.class);
            c("live", DI.THIRD_PART_ACCOUNT, fk7.class);
            c("live", DI.YY.THIRD_PART_ALI_RECHARGE, gk7.class);
            c("live", DI.YY.THIRD_PART_WX_RECHARGE, ik7.class);
            c("live", DI.TOAST_NAME, kk7.class);
            c("live", DI.MINI_SHELL.YY_2_MEDIA, YY2MediaServiceFetcher.class);
            c("live", DI.YY.YY_MULTI_PLUGIN_PROGRESS, YYPluginProgressInvokeServiceFetcher.class);
            c("live", DI.YYPAY.YY_PAY, ij7.class);
            c("live", DI.YY.YY_PLUGIN, YYPluginManageServiceFetcher.class);
            c("logsystem", "exceptionhandler", ExceptionHandlerServiceFetcher.class);
            c("nad.core", "adRequester", vx0.class);
            c("nad.core", "browserDownload", ni0.class);
            c("nad.core", "cmd", yn5.class);
            c("nad.core", "config", zn5.class);
            c("nad.core", "crius", yh0.class);
            c("nad.core", "deviceInfoInner", lf0.class);
            c("nad.core", "eventbus", bk0.class);
            c("nad.core", "exp", qk0.class);
            c("nad.core", "ipdx", of0.class);
            c("nad.core", "loadImage", xe0.class);
            c("nad.core", "loadVideo", st0.class);
            c("nad.core", "maxUI", bo5.class);
            c("nad.core", "navBarTool", do5.class);
            c("nad.core", "splash.config", eo5.class);
            c("nad.core", "splash.host", fo5.class);
            c("nad.core", "thirdService", co5.class);
            c("speed", "runtime", SpeedRuntimeProvider.class);
            c("tbBaseEmotion", "EmotionService", j66.class);
            c("tbadkcore", "IHttpsExperiment", HttpsExperimentFetcher.class);
            c("tbadkcore", "INetExperiment", NetExperimentFetcher.class);
            c("tbadkcore", "ISoProcess", o85.class);
            c(UBCCloudControlProcessor.UBC_KEY, UBC.TAG, m59.class);
            c("voyager", StatConstants.VALUE_TYPE_UPLOAD, de9.class);
            c("yaLog", "yaLogConfig", af9.class);
        }
    }
}

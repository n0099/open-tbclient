package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.behavior.record.BehaviorServiceFetcher;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.searchbox.abtest.ioc.AbTestServiceFetcher;
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
public class ue1 {
    public static /* synthetic */ Interceptable $ic;
    public static final ConcurrentHashMap<ServiceReference, te1<?>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948208008, "Lcom/baidu/tieba/ue1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948208008, "Lcom/baidu/tieba/ue1;");
                return;
            }
        }
        a = new ConcurrentHashMap<>();
        d();
    }

    public ue1() {
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
            te1<?> te1Var = a.get(serviceReference);
            if (te1Var != null) {
                return (T) te1Var.getService();
            }
            return null;
        }
        return (T) invokeL.objValue;
    }

    public static <T> void b(ServiceReference serviceReference, te1<T> te1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, serviceReference, te1Var) == null) {
            a.put(serviceReference, te1Var);
        }
    }

    public static <T> void c(String str, String str2, Class<? extends te1<T>> cls) {
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
            c("Frs", "FrsService", fh6.class);
            c("HotTopic", "HotTopicRequest", lm5.class);
            c("abtest", "service", AbTestServiceFetcher.class);
            c("behavior-api", "behavior-api", BehaviorServiceFetcher.class);
            c("device_score", "DEVICE_SCORE", DeviceScoreFetcher.class);
            c("device_score", "DEVICE_SCORE_COLLECT", DeviceScoreCollectFetcher.class);
            c("device_score", "DEVICE_SCORE_CONFIG", DeviceScoreConfigFetcher.class);
            c("live", "ab", wj7.class);
            c("live", DI.ACCOUNT, lj7.class);
            c("live", DI.APP_INFO_NAME, nj7.class);
            c("live", DI.EXT.EXT_LIVE_JUMP_PAGE, ek7.class);
            c("live", DI.EXT.EXT_LIVE_LOG, lk7.class);
            c("live", DI.FOLLOW_STATUS, ck7.class);
            c("live", DI.LIGHTBROWSER_VIEW, sj7.class);
            c("live", DI.LIVE_CUSTOM_SETTINGS, hl7.class);
            c("live", DI.LIVE_EVENT_DISPATCHER, ak7.class);
            c("live", DI.LIVE_LIKE, gk7.class);
            c("live", DI.LIVE_LOCATION, jk7.class);
            c("live", DI.LIVE_REAL_AUTH, pj7.class);
            c("live", DI.LIVE_SHOW_VIDEO_PLAYER, tk7.class);
            c("live", DI.LIVE_USER_SECURITY_BEHAVIOR, yj7.class);
            c("live", DI.LIVE_USER_SECURITY_DEVICE_INFO, zj7.class);
            c("live", DI.MINI_SHELL.MEDIA_2_YY, Media2YYServiceFetcher.class);
            c("live", "multi_plugin", MultiPluginManagerServiceFetcher.class);
            c("live", "net", nk7.class);
            c("live", DI.PAY_CHANNEL, uj7.class);
            c("live", DI.LIVE_PLAYER, al7.class);
            c("live", DI.MINI_SHELL.PLUGIN_MANAGER, PluginInvokeServiceFetcher.class);
            c("live", DI.LIVE_PRE_START_PLAYER, LivePreStartPlayServiceFetcher.class);
            c("live", DI.ROUTER_NAME, fl7.class);
            c("live", "share", ll7.class);
            c("live", DI.TB.SHARE_CHANNEL, jl7.class);
            c("live", DI.THIRD_PART_ACCOUNT, nl7.class);
            c("live", DI.YY.THIRD_PART_ALI_RECHARGE, ol7.class);
            c("live", DI.YY.THIRD_PART_WX_RECHARGE, ql7.class);
            c("live", DI.TOAST_NAME, sl7.class);
            c("live", DI.MINI_SHELL.YY_2_MEDIA, YY2MediaServiceFetcher.class);
            c("live", DI.YY.YY_MULTI_PLUGIN_PROGRESS, YYPluginProgressInvokeServiceFetcher.class);
            c("live", DI.YYPAY.YY_PAY, qk7.class);
            c("live", DI.YY.YY_PLUGIN, YYPluginManageServiceFetcher.class);
            c("logsystem", "exceptionhandler", ExceptionHandlerServiceFetcher.class);
            c("nad.core", "adRequester", hz0.class);
            c("nad.core", "browserDownload", wj0.class);
            c("nad.core", "cmd", hq5.class);
            c("nad.core", "config", iq5.class);
            c("nad.core", "crius", ij0.class);
            c("nad.core", "deviceInfo.bag", b.class);
            c("nad.core", "deviceInfoInner", tg0.class);
            c("nad.core", "eventbus", nl0.class);
            c("nad.core", "exp", cm0.class);
            c("nad.core", "ipdx", wg0.class);
            c("nad.core", "loadImage", dg0.class);
            c("nad.core", "loadVideo", ev0.class);
            c("nad.core", "maxUI", kq5.class);
            c("nad.core", "navBarTool", mq5.class);
            c("nad.core", "splash.config", nq5.class);
            c("nad.core", "splash.host", oq5.class);
            c("nad.core", "thirdService", lq5.class);
            c("nad.core", "uad", pq5.class);
            c("speed", "runtime", SpeedRuntimeProvider.class);
            c("tbBaseEmotion", "EmotionService", x76.class);
            c("tbadkcore", "IHttpsExperiment", HttpsExperimentFetcher.class);
            c("tbadkcore", "INetExperiment", NetExperimentFetcher.class);
            c("tbadkcore", "ISoProcess", ua5.class);
            c("tbadkcore", "tbadkcore", yn5.class);
            c(UBCCloudControlProcessor.UBC_KEY, UBC.TAG, n99.class);
            c("voyager", StatConstants.VALUE_TYPE_UPLOAD, ei9.class);
            c("yaLog", "yaLogConfig", bj9.class);
        }
    }
}

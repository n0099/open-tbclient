package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.behavior.record.BehaviorServiceFetcher;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.searchbox.abtest.ioc.AbTestServiceFetcher;
import com.baidu.searchbox.devicescore.DeviceScoreCollectFetcher;
import com.baidu.searchbox.devicescore.DeviceScoreConfigFetcher;
import com.baidu.searchbox.devicescore.DeviceScoreFetcher;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.searchbox.live.interfaces.defaultimpl.service.LivePlayUrlServiceFetcher;
import com.baidu.searchbox.live.interfaces.defaultimpl.service.LivePreStartPlayServiceFetcher;
import com.baidu.searchbox.live.interfaces.defaultimpl.service.MultiPluginManagerServiceFetcher;
import com.baidu.searchbox.live.interfaces.defaultimpl.service.YYPluginManageServiceFetcher;
import com.baidu.searchbox.live.service.Media2YYServiceFetcher;
import com.baidu.searchbox.live.service.PluginInvokeServiceFetcher;
import com.baidu.searchbox.live.service.YY2MediaServiceFetcher;
import com.baidu.searchbox.live.service.YYPluginProgressInvokeServiceFetcher;
import com.baidu.searchbox.logsystem.exceptionhandler.impl.ExceptionHandlerServiceFetcher;
import com.baidu.searchbox.performance.speed.SpeedRuntimeProvider;
import com.baidu.searchbox.retrieve.core.task.FetchTaskFetcher;
import com.baidu.searchbox.retrieve.core.task.UploadTaskFetcher;
import com.baidu.searchbox.retrieve.inter.IFetchTask;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.searchbox.retrieve.stats.service.StatServiceFetcher;
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
import com.baidu.webkit.sdk.WebViewFactoryProvider;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public class qk1 {
    public static /* synthetic */ Interceptable $ic;
    public static final ConcurrentHashMap<ServiceReference, pk1<?>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948094610, "Lcom/baidu/tieba/qk1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948094610, "Lcom/baidu/tieba/qk1;");
                return;
            }
        }
        a = new ConcurrentHashMap<>();
        d();
    }

    public qk1() {
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
            pk1<?> pk1Var = a.get(serviceReference);
            if (pk1Var != null) {
                return (T) pk1Var.getService();
            }
            return null;
        }
        return (T) invokeL.objValue;
    }

    public static <T> void b(ServiceReference serviceReference, pk1<T> pk1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, serviceReference, pk1Var) == null) {
            a.put(serviceReference, pk1Var);
        }
    }

    public static <T> void c(String str, String str2, Class<? extends pk1<T>> cls) {
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
            c("AlaLiveSdk", "IMSdkService", rw7.class);
            c("AlaSquare", "SecondFloorService", l36.class);
            c(IFetchTask.NAME_SPACE, "report", FetchTaskFetcher.class);
            c("Frames", "ISafetyConfig", ja6.class);
            c("Frames", "JsPromptBridge", ca6.class);
            c("Frs", "FrsService", ps6.class);
            c("HotTopic", "HotTopicRequest", qu5.class);
            c("ImMessageCenter", "ChatBoxDialogService", hp7.class);
            c("ImMessageCenter", "ChatFloatEntranceService", eq7.class);
            c("ImMessageCenter", "GroupChatService", fp7.class);
            c(WebViewFactoryProvider.SETTING_MONITOR, "IMonitorBehavior", fc6.class);
            c("abtest", "service", AbTestServiceFetcher.class);
            c("behavior-api", "behavior-api", BehaviorServiceFetcher.class);
            c("device_score", "DEVICE_SCORE", DeviceScoreFetcher.class);
            c("device_score", "DEVICE_SCORE_COLLECT", DeviceScoreCollectFetcher.class);
            c("device_score", "DEVICE_SCORE_CONFIG", DeviceScoreConfigFetcher.class);
            c("live", DI.AB_NAME, bz7.class);
            c("live", DI.ACCOUNT, qy7.class);
            c("live", DI.APP_INFO_NAME, sy7.class);
            c("live", DI.EXT.EXT_LIVE_JUMP_PAGE, jz7.class);
            c("live", DI.EXT.EXT_LIVE_LOG, qz7.class);
            c("live", DI.FOLLOW_STATUS, hz7.class);
            c("live", DI.LIGHTBROWSER_VIEW, xy7.class);
            c("live", DI.LIVE_CUSTOM_SETTINGS, m08.class);
            c("live", DI.LIVE_EVENT_DISPATCHER, fz7.class);
            c("live", DI.LIVE_LIKE, lz7.class);
            c("live", DI.LIVE_LOCATION, oz7.class);
            c("live", DI.LIVE_PLAY_URL, LivePlayUrlServiceFetcher.class);
            c("live", DI.LIVE_REAL_AUTH, uy7.class);
            c("live", DI.LIVE_SHOW_VIDEO_PLAYER, yz7.class);
            c("live", DI.LIVE_USER_SECURITY_BEHAVIOR, dz7.class);
            c("live", DI.LIVE_USER_SECURITY_DEVICE_INFO, ez7.class);
            c("live", DI.MINI_SHELL.MEDIA_2_YY, Media2YYServiceFetcher.class);
            c("live", "multi_plugin", MultiPluginManagerServiceFetcher.class);
            c("live", "net", sz7.class);
            c("live", DI.PAY_CHANNEL, zy7.class);
            c("live", DI.LIVE_PLAYER, f08.class);
            c("live", DI.MINI_SHELL.PLUGIN_MANAGER, PluginInvokeServiceFetcher.class);
            c("live", DI.LIVE_PRE_START_PLAYER, LivePreStartPlayServiceFetcher.class);
            c("live", DI.ROUTER_NAME, k08.class);
            c("live", "share", q08.class);
            c("live", DI.TB.SHARE_CHANNEL, o08.class);
            c("live", DI.THIRD_PART_ACCOUNT, s08.class);
            c("live", DI.YY.THIRD_PART_ALI_RECHARGE, t08.class);
            c("live", DI.YY.THIRD_PART_WX_RECHARGE, v08.class);
            c("live", "toast", x08.class);
            c("live", DI.MINI_SHELL.YY_2_MEDIA, YY2MediaServiceFetcher.class);
            c("live", DI.YY.YY_MULTI_PLUGIN_PROGRESS, YYPluginProgressInvokeServiceFetcher.class);
            c("live", DI.YYPAY.YY_PAY, vz7.class);
            c("live", DI.YY.YY_PLUGIN, YYPluginManageServiceFetcher.class);
            c("logsystem", "exceptionhandler", ExceptionHandlerServiceFetcher.class);
            c("nad.business", "rewardVideoLpTaskCenter", mo0.class);
            c("nad.core", "adRequester", v11.class);
            c("nad.core", "browserDownload", al0.class);
            c("nad.core", "cmd", yy5.class);
            c("nad.core", "config", zy5.class);
            c("nad.core", "crius", mk0.class);
            c("nad.core", "deviceInfo.bag", c.class);
            c("nad.core", "deviceInfoInner", sh0.class);
            c("nad.core", "eventbus", rm0.class);
            c("nad.core", "exp", gn0.class);
            c("nad.core", "ipdx", vh0.class);
            c("nad.core", "loadImage", bh0.class);
            c("nad.core", "loadVideo", sx0.class);
            c("nad.core", "maxUI", bz5.class);
            c("nad.core", "nativeCookieMgr", s81.class);
            c("nad.core", "navBarTool", dz5.class);
            c("nad.core", "splash.config", ez5.class);
            c("nad.core", "splash.host", fz5.class);
            c("nad.core", "thirdService", cz5.class);
            c("nad.core", "uad", gz5.class);
            c(StatConstants.VALUE_FROM_RETRIEVE, "stat", StatServiceFetcher.class);
            c(StatConstants.VALUE_FROM_RETRIEVE, StatConstants.VALUE_TYPE_UPLOAD, UploadTaskFetcher.class);
            c("speed", "runtime", SpeedRuntimeProvider.class);
            c("tbBaseEmotion", "EmotionService", cj6.class);
            c("tbadkcore", "IHttpsExperiment", HttpsExperimentFetcher.class);
            c("tbadkcore", "INetExperiment", NetExperimentFetcher.class);
            c("tbadkcore", "ISoProcess", hi5.class);
            c("tbadkcore", "tbadkcore", ew5.class);
            c(UBCCloudControlProcessor.UBC_KEY, UBC.TAG, op9.class);
            c("voyager", StatConstants.VALUE_TYPE_UPLOAD, ey9.class);
            c("yaLog", "yaLogConfig", dz9.class);
        }
    }
}

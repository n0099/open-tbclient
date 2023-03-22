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
import com.baidu.webkit.sdk.WebView;
import com.baidu.webkit.sdk.WebViewFactoryProvider;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public class rj1 {
    public static /* synthetic */ Interceptable $ic;
    public static final ConcurrentHashMap<ServiceReference, qj1<?>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948123440, "Lcom/baidu/tieba/rj1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948123440, "Lcom/baidu/tieba/rj1;");
                return;
            }
        }
        a = new ConcurrentHashMap<>();
        d();
    }

    public rj1() {
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
            qj1<?> qj1Var = a.get(serviceReference);
            if (qj1Var != null) {
                return (T) qj1Var.getService();
            }
            return null;
        }
        return (T) invokeL.objValue;
    }

    public static <T> void b(ServiceReference serviceReference, qj1<T> qj1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, serviceReference, qj1Var) == null) {
            a.put(serviceReference, qj1Var);
        }
    }

    public static <T> void c(String str, String str2, Class<? extends qj1<T>> cls) {
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
            c("AlaLiveSdk", "IMSdkService", a58.class);
            c("AlaLiveSdk", "IMSdkServicePerson", b58.class);
            c("AlaSquare", "SecondFloorService", i46.class);
            c(IFetchTask.NAME_SPACE, "report", FetchTaskFetcher.class);
            c("Frames", "ISafetyConfig", hb6.class);
            c("Frames", "JsPromptBridge", bb6.class);
            c("Frs", "FrsService", tw6.class);
            c("HotTopic", "HotTopicRequest", nv5.class);
            c("ImMessageCenter", "ChatBoxDialogService", kt7.class);
            c("ImMessageCenter", "ChatFloatEntranceService", iu7.class);
            c("ImMessageCenter", "GroupChatService", it7.class);
            c(WebViewFactoryProvider.SETTING_MONITOR, "IMonitorBehavior", td6.class);
            c(WebView.LOGTAG, "IWebViewFactoryService", xa6.class);
            c("abtest", "service", AbTestServiceFetcher.class);
            c("behavior-api", "behavior-api", BehaviorServiceFetcher.class);
            c("device_score", "DEVICE_SCORE", DeviceScoreFetcher.class);
            c("device_score", "DEVICE_SCORE_COLLECT", DeviceScoreCollectFetcher.class);
            c("device_score", "DEVICE_SCORE_CONFIG", DeviceScoreConfigFetcher.class);
            c("live", DI.AB_NAME, p78.class);
            c("live", DI.ACCOUNT, e78.class);
            c("live", DI.APP_INFO_NAME, g78.class);
            c("live", DI.EXT.EXT_LIVE_JUMP_PAGE, z78.class);
            c("live", DI.EXT.EXT_LIVE_LOG, g88.class);
            c("live", DI.FOLLOW_STATUS, v78.class);
            c("live", DI.LIGHTBROWSER_VIEW, l78.class);
            c("live", DI.LIVE_CUSTOM_SETTINGS, a98.class);
            c("live", DI.LIVE_EVENT_DISPATCHER, t78.class);
            c("live", DI.LIVE_LIKE, b88.class);
            c("live", DI.LIVE_LOCATION, e88.class);
            c("live", DI.LIVE_PLAY_URL, LivePlayUrlServiceFetcher.class);
            c("live", DI.LIVE_REAL_AUTH, i78.class);
            c("live", DI.LIVE_SHOW_VIDEO_PLAYER, o88.class);
            c("live", DI.LIVE_USER_SECURITY_BEHAVIOR, r78.class);
            c("live", DI.LIVE_USER_SECURITY_DEVICE_INFO, s78.class);
            c("live", DI.MINI_SHELL.MEDIA_2_YY, Media2YYServiceFetcher.class);
            c("live", "multi_plugin", MultiPluginManagerServiceFetcher.class);
            c("live", "net", i88.class);
            c("live", DI.PAY_CHANNEL, n78.class);
            c("live", DI.LIVE_PLAYER, v88.class);
            c("live", DI.MINI_SHELL.PLUGIN_MANAGER, PluginInvokeServiceFetcher.class);
            c("live", DI.LIVE_PRE_START_PLAYER, LivePreStartPlayServiceFetcher.class);
            c("live", DI.ROUTER_NAME, y88.class);
            c("live", "share", e98.class);
            c("live", DI.TB.SHARE_CHANNEL, c98.class);
            c("live", DI.THIRD_PART_ACCOUNT, g98.class);
            c("live", DI.YY.THIRD_PART_ALI_RECHARGE, h98.class);
            c("live", DI.YY.THIRD_PART_WX_RECHARGE, j98.class);
            c("live", "toast", l98.class);
            c("live", DI.MINI_SHELL.YY_2_MEDIA, YY2MediaServiceFetcher.class);
            c("live", DI.YY.YY_MULTI_PLUGIN_PROGRESS, YYPluginProgressInvokeServiceFetcher.class);
            c("live", DI.YYPAY.YY_PAY, l88.class);
            c("live", DI.YY.YY_PLUGIN, YYPluginManageServiceFetcher.class);
            c(com.baidu.searchbox.live.game.interfaces.DI.MODULE_NAME, "common", x78.class);
            c("logsystem", "exceptionhandler", ExceptionHandlerServiceFetcher.class);
            c("module_home", "SpriteResourceService", h89.class);
            c("nad.business", "rewardVideoLpTaskCenter", gn0.class);
            c("nad.core", "adRequester", s01.class);
            c("nad.core", "browserDownload", uj0.class);
            c("nad.core", "cmd", vz5.class);
            c("nad.core", "config", wz5.class);
            c("nad.core", "crius", gj0.class);
            c("nad.core", "deviceInfo.bag", c.class);
            c("nad.core", "deviceInfoInner", mg0.class);
            c("nad.core", "eventbus", ll0.class);
            c("nad.core", "exp", am0.class);
            c("nad.core", "ipdx", pg0.class);
            c("nad.core", "loadImage", vf0.class);
            c("nad.core", "loadVideo", ow0.class);
            c("nad.core", "maxUI", yz5.class);
            c("nad.core", "nativeCookieMgr", s71.class);
            c("nad.core", "navBarTool", a06.class);
            c("nad.core", "splash.config", b06.class);
            c("nad.core", "splash.host", c06.class);
            c("nad.core", "thirdService", zz5.class);
            c("nad.core", "uad", d06.class);
            c(StatConstants.VALUE_FROM_RETRIEVE, "stat", StatServiceFetcher.class);
            c(StatConstants.VALUE_FROM_RETRIEVE, StatConstants.VALUE_TYPE_UPLOAD, UploadTaskFetcher.class);
            c("speed", "runtime", SpeedRuntimeProvider.class);
            c("tbBaseEmotion", "EmotionService", xl6.class);
            c("tbadkcore", "IHttpsExperiment", HttpsExperimentFetcher.class);
            c("tbadkcore", "INetExperiment", NetExperimentFetcher.class);
            c("tbadkcore", "ISoProcess", ri5.class);
            c("tbadkcore", "tbadkcore", bx5.class);
            c("tieba.core", "eventbus", m28.class);
            c("tieba.core", "eventbus.autorelease", l28.class);
            c(UBCCloudControlProcessor.UBC_KEY, UBC.TAG, y0a.class);
            c("voyager", StatConstants.VALUE_TYPE_UPLOAD, u9a.class);
            c("yaLog", "yaLogConfig", taa.class);
        }
    }
}

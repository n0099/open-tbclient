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
import com.baidu.searchbox.live.video.VideoInsertLiveServiceFetcher;
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
import com.baidu.tbadk.abtest.helper.ThreadExperimentFetcher;
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
public class sj1 {
    public static /* synthetic */ Interceptable $ic;
    public static final ConcurrentHashMap<ServiceReference, rj1<?>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948153231, "Lcom/baidu/tieba/sj1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948153231, "Lcom/baidu/tieba/sj1;");
                return;
            }
        }
        a = new ConcurrentHashMap<>();
        d();
    }

    public sj1() {
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
            rj1<?> rj1Var = a.get(serviceReference);
            if (rj1Var != null) {
                return (T) rj1Var.getService();
            }
            return null;
        }
        return (T) invokeL.objValue;
    }

    public static <T> void b(ServiceReference serviceReference, rj1<T> rj1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, serviceReference, rj1Var) == null) {
            a.put(serviceReference, rj1Var);
        }
    }

    public static <T> void c(String str, String str2, Class<? extends rj1<T>> cls) {
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
            c("AlaLiveSdk", "IMSdkService", rf8.class);
            c("AlaLiveSdk", "IMSdkServicePerson", sf8.class);
            c("AlaSquare", "SecondFloorService", o56.class);
            c(IFetchTask.NAME_SPACE, "report", FetchTaskFetcher.class);
            c("Frames", "ISafetyConfig", oc6.class);
            c("Frames", "JsPromptBridge", ic6.class);
            c("Frs", "FrsService", n57.class);
            c("HotTopic", "HotTopicRequest", tw5.class);
            c("ImMessageCenter", "ChatBoxDialogService", h38.class);
            c("ImMessageCenter", "ChatFloatEntranceService", g48.class);
            c("ImMessageCenter", "GroupChatService", f38.class);
            c(WebViewFactoryProvider.SETTING_MONITOR, "IMonitorBehavior", bf6.class);
            c(WebView.LOGTAG, "IPrefetchManager", hc6.class);
            c(WebView.LOGTAG, "IWebViewFactoryService", dc6.class);
            c("abtest", "service", AbTestServiceFetcher.class);
            c("behavior-api", "behavior-api", BehaviorServiceFetcher.class);
            c("device_score", "DEVICE_SCORE", DeviceScoreFetcher.class);
            c("device_score", "DEVICE_SCORE_COLLECT", DeviceScoreCollectFetcher.class);
            c("device_score", "DEVICE_SCORE_CONFIG", DeviceScoreConfigFetcher.class);
            c("feed", "component.resolver", ji6.class);
            c("feed", "widget.resolver", ki6.class);
            c("live", DI.AB_NAME, gi8.class);
            c("live", DI.ACCOUNT, vh8.class);
            c("live", DI.APP_INFO_NAME, xh8.class);
            c("live", DI.EXT.EXT_LIVE_JUMP_PAGE, qi8.class);
            c("live", DI.EXT.EXT_LIVE_LOG, xi8.class);
            c("live", DI.FOLLOW_STATUS, mi8.class);
            c("live", DI.LIGHTBROWSER_VIEW, ci8.class);
            c("live", DI.LIVE_CUSTOM_SETTINGS, rj8.class);
            c("live", DI.LIVE_EVENT_DISPATCHER, ki8.class);
            c("live", DI.LIVE_INSERT_VIDEO, VideoInsertLiveServiceFetcher.class);
            c("live", DI.LIVE_LIKE, si8.class);
            c("live", DI.LIVE_LOCATION, vi8.class);
            c("live", DI.LIVE_PLAY_URL, LivePlayUrlServiceFetcher.class);
            c("live", DI.LIVE_REAL_AUTH, zh8.class);
            c("live", DI.LIVE_SHOW_VIDEO_PLAYER, fj8.class);
            c("live", DI.LIVE_USER_SECURITY_BEHAVIOR, ii8.class);
            c("live", DI.LIVE_USER_SECURITY_DEVICE_INFO, ji8.class);
            c("live", DI.MINI_SHELL.MEDIA_2_YY, Media2YYServiceFetcher.class);
            c("live", "multi_plugin", MultiPluginManagerServiceFetcher.class);
            c("live", "net", zi8.class);
            c("live", DI.PAY_CHANNEL, ei8.class);
            c("live", DI.LIVE_PLAYER, mj8.class);
            c("live", DI.MINI_SHELL.PLUGIN_MANAGER, PluginInvokeServiceFetcher.class);
            c("live", DI.LIVE_PRE_START_PLAYER, LivePreStartPlayServiceFetcher.class);
            c("live", DI.ROUTER_NAME, pj8.class);
            c("live", "share", vj8.class);
            c("live", DI.TB.SHARE_CHANNEL, tj8.class);
            c("live", DI.THIRD_PART_ACCOUNT, xj8.class);
            c("live", DI.YY.THIRD_PART_ALI_RECHARGE, yj8.class);
            c("live", DI.YY.THIRD_PART_WX_RECHARGE, ak8.class);
            c("live", "toast", ck8.class);
            c("live", DI.MINI_SHELL.YY_2_MEDIA, YY2MediaServiceFetcher.class);
            c("live", DI.YY.YY_MULTI_PLUGIN_PROGRESS, YYPluginProgressInvokeServiceFetcher.class);
            c("live", DI.YYPAY.YY_PAY, cj8.class);
            c("live", DI.YY.YY_PLUGIN, YYPluginManageServiceFetcher.class);
            c(com.baidu.searchbox.live.game.interfaces.DI.MODULE_NAME, "common", oi8.class);
            c("logsystem", "exceptionhandler", ExceptionHandlerServiceFetcher.class);
            c("module_home", "SpriteResourceService", yh9.class);
            c("nad.business", "rewardVideoLpTaskCenter", hn0.class);
            c("nad.core", "adRequester", t01.class);
            c("nad.core", "browserDownload", vj0.class);
            c("nad.core", "cmd", b16.class);
            c("nad.core", "config", c16.class);
            c("nad.core", "crius", hj0.class);
            c("nad.core", "deviceInfo.bag", c.class);
            c("nad.core", "deviceInfoInner", ng0.class);
            c("nad.core", "eventbus", ml0.class);
            c("nad.core", "exp", bm0.class);
            c("nad.core", "ipdx", qg0.class);
            c("nad.core", "loadImage", wf0.class);
            c("nad.core", "loadVideo", pw0.class);
            c("nad.core", "maxUI", e16.class);
            c("nad.core", "nativeCookieMgr", t71.class);
            c("nad.core", "navBarTool", g16.class);
            c("nad.core", "splash.config", h16.class);
            c("nad.core", "splash.host", i16.class);
            c("nad.core", "thirdService", f16.class);
            c("nad.core", "uad", j16.class);
            c(StatConstants.VALUE_FROM_RETRIEVE, "stat", StatServiceFetcher.class);
            c(StatConstants.VALUE_FROM_RETRIEVE, StatConstants.VALUE_TYPE_UPLOAD, UploadTaskFetcher.class);
            c("speed", "runtime", SpeedRuntimeProvider.class);
            c("tbBaseEmotion", "EmotionService", ap6.class);
            c("tbadkcore", "IHttpsExperiment", HttpsExperimentFetcher.class);
            c("tbadkcore", "INetExperiment", NetExperimentFetcher.class);
            c("tbadkcore", "ISoProcess", xj5.class);
            c("tbadkcore", "IThreadExperiment", ThreadExperimentFetcher.class);
            c("tbadkcore", "tbadkcore", hy5.class);
            c("tieba.core", "eventbus", dd8.class);
            c("tieba.core", "eventbus.autorelease", cd8.class);
            c(UBCCloudControlProcessor.UBC_KEY, UBC.TAG, paa.class);
            c("voyager", StatConstants.VALUE_TYPE_UPLOAD, lja.class);
            c("yaLog", "yaLogConfig", kka.class);
        }
    }
}

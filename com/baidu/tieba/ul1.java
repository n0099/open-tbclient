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
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes8.dex */
public class ul1 {
    public static /* synthetic */ Interceptable $ic;
    public static final ConcurrentHashMap<ServiceReference, tl1<?>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948214735, "Lcom/baidu/tieba/ul1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948214735, "Lcom/baidu/tieba/ul1;");
                return;
            }
        }
        a = new ConcurrentHashMap<>();
        d();
    }

    public ul1() {
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
            tl1<?> tl1Var = a.get(serviceReference);
            if (tl1Var != null) {
                return (T) tl1Var.getService();
            }
            return null;
        }
        return (T) invokeL.objValue;
    }

    public static <T> void b(ServiceReference serviceReference, tl1<T> tl1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, serviceReference, tl1Var) == null) {
            a.put(serviceReference, tl1Var);
        }
    }

    public static <T> void c(String str, String str2, Class<? extends tl1<T>> cls) {
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
            c("AlaLiveSdk", "IMSdkService", aq8.class);
            c("AlaLiveSdk", "IMSdkServicePerson", bq8.class);
            c("AlaSquare", "SecondFloorService", gc6.class);
            c(IFetchTask.NAME_SPACE, "report", FetchTaskFetcher.class);
            c("Frames", "ISafetyConfig", sj6.class);
            c("Frames", "JsPromptBridge", mj6.class);
            c("Frs", "FrsService", vd7.class);
            c("HotTopic", "HotTopicRequest", h36.class);
            c("ImMessageCenter", "ChatBoxDialogService", nc8.class);
            c("ImMessageCenter", "ChatFloatEntranceService", ld8.class);
            c("ImMessageCenter", "GroupChatService", kc8.class);
            c(WebView.LOGTAG, "EMManagerProvider", kj6.class);
            c(WebView.LOGTAG, "IPrefetchManager", ij6.class);
            c(WebView.LOGTAG, "IPrerenderManager", jj6.class);
            c(WebView.LOGTAG, "IWebViewDebug", lj6.class);
            c(WebView.LOGTAG, "IWebViewFactoryService", dj6.class);
            c("abtest", "service", AbTestServiceFetcher.class);
            c("behavior-api", "behavior-api", BehaviorServiceFetcher.class);
            c("device_score", "DEVICE_SCORE", DeviceScoreFetcher.class);
            c("device_score", "DEVICE_SCORE_COLLECT", DeviceScoreCollectFetcher.class);
            c("device_score", "DEVICE_SCORE_CONFIG", DeviceScoreConfigFetcher.class);
            c("download", "DOWNLOAD", rv6.class);
            c("download", "DOWNLOAD", v20.class);
            c("download", "db", r20.class);
            c("feed", "component.resolver", up6.class);
            c("feed", "widget.resolver", vp6.class);
            c("live", DI.AB_NAME, qs8.class);
            c("live", DI.ACCOUNT, es8.class);
            c("live", DI.APP_INFO_NAME, gs8.class);
            c("live", DI.EXT.EXT_LIVE_JUMP_PAGE, at8.class);
            c("live", DI.EXT.EXT_LIVE_LOG, ht8.class);
            c("live", DI.FOLLOW_STATUS, ws8.class);
            c("live", DI.LIGHTBROWSER_VIEW, ls8.class);
            c("live", DI.LIVE_CUSTOM_SETTINGS, bu8.class);
            c("live", DI.LIVE_EVENT_DISPATCHER, us8.class);
            c("live", DI.LIVE_INSERT_VIDEO, VideoInsertLiveServiceFetcher.class);
            c("live", DI.LIVE_LIKE, ct8.class);
            c("live", DI.LIVE_LOCATION, ft8.class);
            c("live", DI.LIVE_PLAY_URL, LivePlayUrlServiceFetcher.class);
            c("live", DI.LIVE_REAL_AUTH, is8.class);
            c("live", DI.LIVE_SHOW_VIDEO_PLAYER, pt8.class);
            c("live", DI.LIVE_USER_SECURITY_BEHAVIOR, ss8.class);
            c("live", DI.LIVE_USER_SECURITY_DEVICE_INFO, ts8.class);
            c("live", DI.MINI_SHELL.MEDIA_2_YY, Media2YYServiceFetcher.class);
            c("live", "multi_plugin", MultiPluginManagerServiceFetcher.class);
            c("live", "net", jt8.class);
            c("live", DI.PAY_CHANNEL, os8.class);
            c("live", DI.LIVE_PLAYER, wt8.class);
            c("live", DI.MINI_SHELL.PLUGIN_MANAGER, PluginInvokeServiceFetcher.class);
            c("live", DI.LIVE_PRE_START_PLAYER, LivePreStartPlayServiceFetcher.class);
            c("live", DI.ROUTER_NAME, zt8.class);
            c("live", "share", fu8.class);
            c("live", DI.TB.SHARE_CHANNEL, du8.class);
            c("live", DI.THIRD_PART_ACCOUNT, hu8.class);
            c("live", DI.YY.THIRD_PART_ALI_RECHARGE, iu8.class);
            c("live", DI.YY.THIRD_PART_WX_RECHARGE, ku8.class);
            c("live", "toast", mu8.class);
            c("live", DI.MINI_SHELL.YY_2_MEDIA, YY2MediaServiceFetcher.class);
            c("live", DI.YY.YY_GAMEASSIST_DXM_RECHARGE, jt7.class);
            c("live", DI.YY.YY_GAMEASSIST_HOST_INFO, ht7.class);
            c("live", DI.YY.YY_GAMEASSIST_MODIFY_PWD, lt7.class);
            c("live", DI.YY.YY_GAMEASSIST_PERSMISSION, nt7.class);
            c("live", DI.YY.YY_MULTI_PLUGIN_PROGRESS, YYPluginProgressInvokeServiceFetcher.class);
            c("live", DI.YYPAY.YY_PAY, mt8.class);
            c("live", DI.YY.YY_PLUGIN, YYPluginManageServiceFetcher.class);
            c(com.baidu.searchbox.live.game.interfaces.DI.MODULE_NAME, "common", ys8.class);
            c("logsystem", "exceptionhandler", ExceptionHandlerServiceFetcher.class);
            c("module_home", "SpriteResourceService", vt9.class);
            c("nad.business", "rewardVideoLpTaskCenter", jp0.class);
            c("nad.core", "adRequester", v21.class);
            c("nad.core", "browserDownload", xl0.class);
            c("nad.core", "cmd", s76.class);
            c("nad.core", "config", t76.class);
            c("nad.core", "crius", jl0.class);
            c("nad.core", "cyber", q66.class);
            c("nad.core", "deviceInfo.bag", c.class);
            c("nad.core", "deviceInfoInner", pi0.class);
            c("nad.core", "downloadCreator", g86.class);
            c("nad.core", "eventbus", on0.class);
            c("nad.core", "exp", do0.class);
            c("nad.core", "ipdx", si0.class);
            c("nad.core", "loadImage", yh0.class);
            c("nad.core", "loadVideo", ry0.class);
            c("nad.core", "maxUI", v76.class);
            c("nad.core", "nativeCookieMgr", v91.class);
            c("nad.core", "navBarTool", x76.class);
            c("nad.core", "splash.config", y76.class);
            c("nad.core", "splash.host", z76.class);
            c("nad.core", "thirdService", w76.class);
            c("nad.core", "uad", a86.class);
            c(StatConstants.VALUE_FROM_RETRIEVE, "stat", StatServiceFetcher.class);
            c(StatConstants.VALUE_FROM_RETRIEVE, "upload", UploadTaskFetcher.class);
            c("speed", "runtime", SpeedRuntimeProvider.class);
            c("tbBaseEmotion", "EmotionService", hx6.class);
            c("tbadkcore", "IHttpsExperiment", HttpsExperimentFetcher.class);
            c("tbadkcore", "INetExperiment", NetExperimentFetcher.class);
            c("tbadkcore", "ISoProcess", cq5.class);
            c("tbadkcore", "IThreadExperiment", ThreadExperimentFetcher.class);
            c("tbadkcore", "tbadkcore", v46.class);
            c("tieba.core", "eventbus", mn8.class);
            c("tieba.core", "eventbus.autorelease", ln8.class);
            c("ubc", UBC.TAG, foa.class);
            c("voyager", "upload", bxa.class);
            c("yaLog", "yaLogConfig", aya.class);
        }
    }
}

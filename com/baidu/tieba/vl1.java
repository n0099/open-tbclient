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
import com.baidu.tbadk.switchs.UniKVTestFetcher;
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
public class vl1 {
    public static /* synthetic */ Interceptable $ic;
    public static final ConcurrentHashMap<ServiceReference, ul1<?>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948244526, "Lcom/baidu/tieba/vl1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948244526, "Lcom/baidu/tieba/vl1;");
                return;
            }
        }
        a = new ConcurrentHashMap<>();
        d();
    }

    public vl1() {
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
            ul1<?> ul1Var = a.get(serviceReference);
            if (ul1Var != null) {
                return (T) ul1Var.getService();
            }
            return null;
        }
        return (T) invokeL.objValue;
    }

    public static <T> void b(ServiceReference serviceReference, ul1<T> ul1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, serviceReference, ul1Var) == null) {
            a.put(serviceReference, ul1Var);
        }
    }

    public static <T> void c(String str, String str2, Class<? extends ul1<T>> cls) {
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
            c("AlaLiveSdk", "IMSdkService", xq8.class);
            c("AlaLiveSdk", "IMSdkServicePerson", yq8.class);
            c("AlaSquare", "SecondFloorService", nc6.class);
            c(IFetchTask.NAME_SPACE, "report", FetchTaskFetcher.class);
            c("Frames", "ISafetyConfig", zj6.class);
            c("Frames", "JsPromptBridge", tj6.class);
            c("Frs", "FrsService", ce7.class);
            c("HotTopic", "HotTopicRequest", o36.class);
            c("ImMessageCenter", "ChatBoxDialogService", fd8.class);
            c("ImMessageCenter", "ChatFloatEntranceService", de8.class);
            c("ImMessageCenter", "GroupChatService", cd8.class);
            c("UniKVTest", "UniKVTest", UniKVTestFetcher.class);
            c(WebView.LOGTAG, "EMManagerProvider", rj6.class);
            c(WebView.LOGTAG, "IPrefetchManager", pj6.class);
            c(WebView.LOGTAG, "IPrerenderManager", qj6.class);
            c(WebView.LOGTAG, "IWebViewDebug", sj6.class);
            c(WebView.LOGTAG, "IWebViewFactoryService", kj6.class);
            c("abtest", "service", AbTestServiceFetcher.class);
            c("behavior-api", "behavior-api", BehaviorServiceFetcher.class);
            c("device_score", "DEVICE_SCORE", DeviceScoreFetcher.class);
            c("device_score", "DEVICE_SCORE_COLLECT", DeviceScoreCollectFetcher.class);
            c("device_score", "DEVICE_SCORE_CONFIG", DeviceScoreConfigFetcher.class);
            c("download", "DOWNLOAD", yv6.class);
            c("download", "DOWNLOAD", w20.class);
            c("download", "db", s20.class);
            c("feed", "component.resolver", bq6.class);
            c("feed", "widget.resolver", cq6.class);
            c("live", DI.AB_NAME, nt8.class);
            c("live", DI.ACCOUNT, bt8.class);
            c("live", DI.APP_INFO_NAME, dt8.class);
            c("live", DI.EXT.EXT_LIVE_JUMP_PAGE, xt8.class);
            c("live", DI.EXT.EXT_LIVE_LOG, eu8.class);
            c("live", DI.FOLLOW_STATUS, tt8.class);
            c("live", DI.LIGHTBROWSER_VIEW, it8.class);
            c("live", DI.LIVE_CUSTOM_SETTINGS, yu8.class);
            c("live", DI.LIVE_EVENT_DISPATCHER, rt8.class);
            c("live", DI.LIVE_INSERT_VIDEO, VideoInsertLiveServiceFetcher.class);
            c("live", DI.LIVE_LIKE, zt8.class);
            c("live", DI.LIVE_LOCATION, cu8.class);
            c("live", DI.LIVE_PLAY_URL, LivePlayUrlServiceFetcher.class);
            c("live", DI.LIVE_REAL_AUTH, ft8.class);
            c("live", DI.LIVE_SHOW_VIDEO_PLAYER, mu8.class);
            c("live", DI.LIVE_USER_SECURITY_BEHAVIOR, pt8.class);
            c("live", DI.LIVE_USER_SECURITY_DEVICE_INFO, qt8.class);
            c("live", DI.MINI_SHELL.MEDIA_2_YY, Media2YYServiceFetcher.class);
            c("live", "multi_plugin", MultiPluginManagerServiceFetcher.class);
            c("live", "net", gu8.class);
            c("live", DI.PAY_CHANNEL, lt8.class);
            c("live", DI.LIVE_PLAYER, tu8.class);
            c("live", DI.MINI_SHELL.PLUGIN_MANAGER, PluginInvokeServiceFetcher.class);
            c("live", DI.LIVE_PRE_START_PLAYER, LivePreStartPlayServiceFetcher.class);
            c("live", DI.ROUTER_NAME, wu8.class);
            c("live", "share", cv8.class);
            c("live", DI.TB.SHARE_CHANNEL, av8.class);
            c("live", DI.THIRD_PART_ACCOUNT, ev8.class);
            c("live", DI.YY.THIRD_PART_ALI_RECHARGE, fv8.class);
            c("live", DI.YY.THIRD_PART_WX_RECHARGE, hv8.class);
            c("live", "toast", jv8.class);
            c("live", DI.MINI_SHELL.YY_2_MEDIA, YY2MediaServiceFetcher.class);
            c("live", DI.YY.YY_GAMEASSIST_DXM_RECHARGE, tt7.class);
            c("live", DI.YY.YY_GAMEASSIST_HOST_INFO, rt7.class);
            c("live", DI.YY.YY_GAMEASSIST_MODIFY_PWD, vt7.class);
            c("live", DI.YY.YY_GAMEASSIST_PERSMISSION, xt7.class);
            c("live", DI.YY.YY_MULTI_PLUGIN_PROGRESS, YYPluginProgressInvokeServiceFetcher.class);
            c("live", DI.YYPAY.YY_PAY, ju8.class);
            c("live", DI.YY.YY_PLUGIN, YYPluginManageServiceFetcher.class);
            c(com.baidu.searchbox.live.game.interfaces.DI.MODULE_NAME, "common", vt8.class);
            c("logsystem", "exceptionhandler", ExceptionHandlerServiceFetcher.class);
            c("module_home", "SpriteResourceService", sv9.class);
            c("nad.business", "rewardVideoLpTaskCenter", kp0.class);
            c("nad.core", "adRequester", w21.class);
            c("nad.core", "browserDownload", yl0.class);
            c("nad.core", "cmd", z76.class);
            c("nad.core", "config", a86.class);
            c("nad.core", "crius", kl0.class);
            c("nad.core", "cyber", x66.class);
            c("nad.core", "deviceInfo.bag", c.class);
            c("nad.core", "deviceInfoInner", qi0.class);
            c("nad.core", "downloadCreator", n86.class);
            c("nad.core", "eventbus", pn0.class);
            c("nad.core", "exp", eo0.class);
            c("nad.core", "ipdx", ti0.class);
            c("nad.core", "loadImage", zh0.class);
            c("nad.core", "loadVideo", sy0.class);
            c("nad.core", "maxUI", c86.class);
            c("nad.core", "nativeCookieMgr", w91.class);
            c("nad.core", "navBarTool", e86.class);
            c("nad.core", "splash.config", f86.class);
            c("nad.core", "splash.host", g86.class);
            c("nad.core", "thirdService", d86.class);
            c("nad.core", "uad", h86.class);
            c(StatConstants.VALUE_FROM_RETRIEVE, "stat", StatServiceFetcher.class);
            c(StatConstants.VALUE_FROM_RETRIEVE, "upload", UploadTaskFetcher.class);
            c("speed", "runtime", SpeedRuntimeProvider.class);
            c("tbBaseEmotion", "EmotionService", ox6.class);
            c("tbadkcore", "IHttpsExperiment", HttpsExperimentFetcher.class);
            c("tbadkcore", "INetExperiment", NetExperimentFetcher.class);
            c("tbadkcore", "ISoProcess", jq5.class);
            c("tbadkcore", "IThreadExperiment", ThreadExperimentFetcher.class);
            c("tbadkcore", "tbadkcore", c56.class);
            c("tieba.core", "eventbus", jo8.class);
            c("tieba.core", "eventbus.autorelease", io8.class);
            c("ubc", UBC.TAG, dqa.class);
            c("voyager", "upload", zya.class);
            c("yaLog", "yaLogConfig", yza.class);
        }
    }
}

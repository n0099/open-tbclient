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
/* loaded from: classes6.dex */
public class lk1 {
    public static /* synthetic */ Interceptable $ic;
    public static final ConcurrentHashMap<ServiceReference, kk1<?>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947945655, "Lcom/baidu/tieba/lk1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947945655, "Lcom/baidu/tieba/lk1;");
                return;
            }
        }
        a = new ConcurrentHashMap<>();
        d();
    }

    public lk1() {
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
            kk1<?> kk1Var = a.get(serviceReference);
            if (kk1Var != null) {
                return (T) kk1Var.getService();
            }
            return null;
        }
        return (T) invokeL.objValue;
    }

    public static <T> void b(ServiceReference serviceReference, kk1<T> kk1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, serviceReference, kk1Var) == null) {
            a.put(serviceReference, kk1Var);
        }
    }

    public static <T> void c(String str, String str2, Class<? extends kk1<T>> cls) {
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
            c("AlaLiveSdk", "IMSdkService", dk8.class);
            c("AlaLiveSdk", "IMSdkServicePerson", ek8.class);
            c("AlaSquare", "SecondFloorService", c86.class);
            c(IFetchTask.NAME_SPACE, "report", FetchTaskFetcher.class);
            c("Frames", "ISafetyConfig", mf6.class);
            c("Frames", "JsPromptBridge", gf6.class);
            c("Frs", "FrsService", s87.class);
            c("HotTopic", "HotTopicRequest", gz5.class);
            c("ImMessageCenter", "ChatBoxDialogService", y68.class);
            c("ImMessageCenter", "ChatFloatEntranceService", w78.class);
            c("ImMessageCenter", "GroupChatService", v68.class);
            c(WebView.LOGTAG, "EMManagerProvider", ff6.class);
            c(WebView.LOGTAG, "IPrefetchManager", df6.class);
            c(WebView.LOGTAG, "IPrerenderManager", ef6.class);
            c(WebView.LOGTAG, "IWebViewFactoryService", ye6.class);
            c("abtest", "service", AbTestServiceFetcher.class);
            c("behavior-api", "behavior-api", BehaviorServiceFetcher.class);
            c("device_score", "DEVICE_SCORE", DeviceScoreFetcher.class);
            c("device_score", "DEVICE_SCORE_COLLECT", DeviceScoreCollectFetcher.class);
            c("device_score", "DEVICE_SCORE_CONFIG", DeviceScoreConfigFetcher.class);
            c("feed", "component.resolver", jl6.class);
            c("feed", "widget.resolver", kl6.class);
            c("live", DI.AB_NAME, tm8.class);
            c("live", DI.ACCOUNT, hm8.class);
            c("live", DI.APP_INFO_NAME, jm8.class);
            c("live", DI.EXT.EXT_LIVE_JUMP_PAGE, dn8.class);
            c("live", DI.EXT.EXT_LIVE_LOG, kn8.class);
            c("live", DI.FOLLOW_STATUS, zm8.class);
            c("live", DI.LIGHTBROWSER_VIEW, om8.class);
            c("live", DI.LIVE_CUSTOM_SETTINGS, eo8.class);
            c("live", DI.LIVE_EVENT_DISPATCHER, xm8.class);
            c("live", DI.LIVE_INSERT_VIDEO, VideoInsertLiveServiceFetcher.class);
            c("live", DI.LIVE_LIKE, fn8.class);
            c("live", DI.LIVE_LOCATION, in8.class);
            c("live", DI.LIVE_PLAY_URL, LivePlayUrlServiceFetcher.class);
            c("live", DI.LIVE_REAL_AUTH, lm8.class);
            c("live", DI.LIVE_SHOW_VIDEO_PLAYER, sn8.class);
            c("live", DI.LIVE_USER_SECURITY_BEHAVIOR, vm8.class);
            c("live", DI.LIVE_USER_SECURITY_DEVICE_INFO, wm8.class);
            c("live", DI.MINI_SHELL.MEDIA_2_YY, Media2YYServiceFetcher.class);
            c("live", "multi_plugin", MultiPluginManagerServiceFetcher.class);
            c("live", "net", mn8.class);
            c("live", DI.PAY_CHANNEL, rm8.class);
            c("live", DI.LIVE_PLAYER, zn8.class);
            c("live", DI.MINI_SHELL.PLUGIN_MANAGER, PluginInvokeServiceFetcher.class);
            c("live", DI.LIVE_PRE_START_PLAYER, LivePreStartPlayServiceFetcher.class);
            c("live", DI.ROUTER_NAME, co8.class);
            c("live", "share", io8.class);
            c("live", DI.TB.SHARE_CHANNEL, go8.class);
            c("live", DI.THIRD_PART_ACCOUNT, ko8.class);
            c("live", DI.YY.THIRD_PART_ALI_RECHARGE, lo8.class);
            c("live", DI.YY.THIRD_PART_WX_RECHARGE, no8.class);
            c("live", "toast", po8.class);
            c("live", DI.MINI_SHELL.YY_2_MEDIA, YY2MediaServiceFetcher.class);
            c("live", DI.YY.YY_MULTI_PLUGIN_PROGRESS, YYPluginProgressInvokeServiceFetcher.class);
            c("live", DI.YYPAY.YY_PAY, pn8.class);
            c("live", DI.YY.YY_PLUGIN, YYPluginManageServiceFetcher.class);
            c(com.baidu.searchbox.live.game.interfaces.DI.MODULE_NAME, "common", bn8.class);
            c("logsystem", "exceptionhandler", ExceptionHandlerServiceFetcher.class);
            c("module_home", "SpriteResourceService", mn9.class);
            c("nad.business", "rewardVideoLpTaskCenter", ao0.class);
            c("nad.core", "adRequester", m11.class);
            c("nad.core", "browserDownload", ok0.class);
            c("nad.core", "cmd", p36.class);
            c("nad.core", "config", q36.class);
            c("nad.core", "crius", ak0.class);
            c("nad.core", "deviceInfo.bag", c.class);
            c("nad.core", "deviceInfoInner", gh0.class);
            c("nad.core", "eventbus", fm0.class);
            c("nad.core", "exp", um0.class);
            c("nad.core", "ipdx", jh0.class);
            c("nad.core", "loadImage", pg0.class);
            c("nad.core", "loadVideo", ix0.class);
            c("nad.core", "maxUI", s36.class);
            c("nad.core", "nativeCookieMgr", m81.class);
            c("nad.core", "navBarTool", u36.class);
            c("nad.core", "splash.config", v36.class);
            c("nad.core", "splash.host", w36.class);
            c("nad.core", "thirdService", t36.class);
            c("nad.core", "uad", x36.class);
            c(StatConstants.VALUE_FROM_RETRIEVE, "stat", StatServiceFetcher.class);
            c(StatConstants.VALUE_FROM_RETRIEVE, StatConstants.VALUE_TYPE_UPLOAD, UploadTaskFetcher.class);
            c("speed", "runtime", SpeedRuntimeProvider.class);
            c("tbBaseEmotion", "EmotionService", hs6.class);
            c("tbadkcore", "IHttpsExperiment", HttpsExperimentFetcher.class);
            c("tbadkcore", "INetExperiment", NetExperimentFetcher.class);
            c("tbadkcore", "ISoProcess", am5.class);
            c("tbadkcore", "IThreadExperiment", ThreadExperimentFetcher.class);
            c("tbadkcore", "tbadkcore", u06.class);
            c("tieba.core", "eventbus", ph8.class);
            c("tieba.core", "eventbus.autorelease", oh8.class);
            c("ubc", UBC.TAG, sga.class);
            c("voyager", StatConstants.VALUE_TYPE_UPLOAD, opa.class);
            c("yaLog", "yaLogConfig", nqa.class);
        }
    }
}

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
/* loaded from: classes9.dex */
public class zk1 {
    public static /* synthetic */ Interceptable $ic;
    public static final ConcurrentHashMap<ServiceReference, yk1<?>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948362729, "Lcom/baidu/tieba/zk1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948362729, "Lcom/baidu/tieba/zk1;");
                return;
            }
        }
        a = new ConcurrentHashMap<>();
        d();
    }

    public zk1() {
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
            yk1<?> yk1Var = a.get(serviceReference);
            if (yk1Var != null) {
                return (T) yk1Var.getService();
            }
            return null;
        }
        return (T) invokeL.objValue;
    }

    public static <T> void b(ServiceReference serviceReference, yk1<T> yk1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, serviceReference, yk1Var) == null) {
            a.put(serviceReference, yk1Var);
        }
    }

    public static <T> void c(String str, String str2, Class<? extends yk1<T>> cls) {
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
            c("AlaLiveSdk", "IMSdkService", k39.class);
            c("AlaLiveSdk", "IMSdkServicePerson", l39.class);
            c("AlaSquare", "SecondFloorService", fc6.class);
            c(IFetchTask.NAME_SPACE, "report", FetchTaskFetcher.class);
            c("Frames", "ISafetyConfig", sj6.class);
            c("Frames", "JsPromptBridge", mj6.class);
            c("Frs", "FrsService", nh7.class);
            c("Frs", "FrsVisitedInfoService", cx6.class);
            c("HotTopic", "HotTopicRequest", w26.class);
            c("IM", "IMessageCenterService", xw8.class);
            c("ImMessageCenter", "ChatBoxDialogService", nk8.class);
            c("ImMessageCenter", "ChatFloatEntranceService", fm8.class);
            c("ImMessageCenter", "GroupChatService", kk8.class);
            c("MessageCenter", "MessageCenterAIBotService", ww8.class);
            c("UniKVTest", "UniKVTest", UniKVTestFetcher.class);
            c(WebView.LOGTAG, "EMManagerProvider", kj6.class);
            c(WebView.LOGTAG, "IPrefetchManager", ij6.class);
            c(WebView.LOGTAG, "IPrerenderManager", jj6.class);
            c(WebView.LOGTAG, "IWebViewDebug", lj6.class);
            c(WebView.LOGTAG, "IWebViewFactoryService", dj6.class);
            c("abtest", "service", AbTestServiceFetcher.class);
            c("aibot", "AibotChatService", tb8.class);
            c("behavior-api", "behavior-api", BehaviorServiceFetcher.class);
            c("device_score", "DEVICE_SCORE", DeviceScoreFetcher.class);
            c("device_score", "DEVICE_SCORE_COLLECT", DeviceScoreCollectFetcher.class);
            c("device_score", "DEVICE_SCORE_CONFIG", DeviceScoreConfigFetcher.class);
            c("download", "DOWNLOAD", hx6.class);
            c("download", "DOWNLOAD", z10.class);
            c("download", "db", v10.class);
            c("feed", "component.resolver", hq6.class);
            c("feed", "widget.resolver", iq6.class);
            c("live", DI.AB_NAME, z59.class);
            c("live", "account", n59.class);
            c("live", DI.APP_INFO_NAME, p59.class);
            c("live", DI.PLAYER.DU_MEDIA, z69.class);
            c("live", DI.EXT.EXT_LIVE_JUMP_PAGE, j69.class);
            c("live", DI.EXT.EXT_LIVE_LOG, q69.class);
            c("live", DI.FOLLOW_STATUS, f69.class);
            c("live", DI.LIGHTBROWSER_VIEW, u59.class);
            c("live", DI.LIVE_CUSTOM_SETTINGS, o79.class);
            c("live", DI.LIVE_EVENT_DISPATCHER, d69.class);
            c("live", DI.LIVE_INSERT_VIDEO, VideoInsertLiveServiceFetcher.class);
            c("live", DI.LIVE_LIKE, l69.class);
            c("live", DI.LIVE_LOCATION, o69.class);
            c("live", DI.LIVE_PLAY_URL, LivePlayUrlServiceFetcher.class);
            c("live", DI.LIVE_REAL_AUTH, r59.class);
            c("live", DI.LIVE_SHOW_VIDEO_PLAYER, a79.class);
            c("live", DI.LIVE_USER_SECURITY_BEHAVIOR, b69.class);
            c("live", DI.LIVE_USER_SECURITY_DEVICE_INFO, c69.class);
            c("live", DI.LIVE_YY_RTC, m79.class);
            c("live", DI.MINI_SHELL.MEDIA_2_YY, Media2YYServiceFetcher.class);
            c("live", "multi_plugin", MultiPluginManagerServiceFetcher.class);
            c("live", "net", s69.class);
            c("live", DI.PAY_CHANNEL, x59.class);
            c("live", DI.LIVE_PLAYER, h79.class);
            c("live", DI.MINI_SHELL.PLUGIN_MANAGER, PluginInvokeServiceFetcher.class);
            c("live", DI.LIVE_PRE_START_PLAYER, LivePreStartPlayServiceFetcher.class);
            c("live", DI.ROUTER_NAME, k79.class);
            c("live", "share", s79.class);
            c("live", DI.TB.SHARE_CHANNEL, q79.class);
            c("live", DI.THIRD_PART_ACCOUNT, u79.class);
            c("live", DI.YY.THIRD_PART_ALI_RECHARGE, v79.class);
            c("live", DI.YY.THIRD_PART_WX_RECHARGE, x79.class);
            c("live", "toast", z79.class);
            c("live", DI.MINI_SHELL.YY_2_MEDIA, YY2MediaServiceFetcher.class);
            c("live", DI.YY.YY_GAMEASSIST_DXM_RECHARGE, rx7.class);
            c("live", DI.YY.YY_GAMEASSIST_HOST_INFO, px7.class);
            c("live", DI.YY.YY_GAMEASSIST_MODIFY_PWD, tx7.class);
            c("live", DI.YY.YY_GAMEASSIST_PERSMISSION, vx7.class);
            c("live", DI.YY.YY_MULTI_PLUGIN_PROGRESS, YYPluginProgressInvokeServiceFetcher.class);
            c("live", DI.YYPAY.YY_PAY, v69.class);
            c("live", DI.YY.YY_PLUGIN, YYPluginManageServiceFetcher.class);
            c(com.baidu.searchbox.live.game.interfaces.DI.MODULE_NAME, "common", h69.class);
            c("logsystem", "exceptionhandler", ExceptionHandlerServiceFetcher.class);
            c("module_home", "SpriteResourceService", nba.class);
            c("module_home", "SpriteStateService", iba.class);
            c("nad.business", "rewardVideoLpTaskCenter", yo0.class);
            c("nad.core", "adRequester", t21.class);
            c("nad.core", "browserDownload", fl0.class);
            c("nad.core", "cmd", s76.class);
            c("nad.core", "config", t76.class);
            c("nad.core", "crius", rk0.class);
            c("nad.core", "cyber", f66.class);
            c("nad.core", "deviceInfo.bag", d.class);
            c("nad.core", "deviceInfoInner", vh0.class);
            c("nad.core", "downloadCreator", g86.class);
            c("nad.core", "eventbus", dn0.class);
            c("nad.core", "exp", sn0.class);
            c("nad.core", "ipdx", yh0.class);
            c("nad.core", "loadImage", eh0.class);
            c("nad.core", "loadVideo", py0.class);
            c("nad.core", "maxUI", v76.class);
            c("nad.core", "nativeCookieMgr", ka1.class);
            c("nad.core", "navBarTool", x76.class);
            c("nad.core", "splash.config", y76.class);
            c("nad.core", "splash.host", z76.class);
            c("nad.core", "thirdService", w76.class);
            c("nad.core", "uad", a86.class);
            c(StatConstants.VALUE_FROM_RETRIEVE, "stat", StatServiceFetcher.class);
            c(StatConstants.VALUE_FROM_RETRIEVE, "upload", UploadTaskFetcher.class);
            c("speed", "runtime", SpeedRuntimeProvider.class);
            c("tbBaseEmotion", "EmotionService", zy6.class);
            c("tbadkcore", "IHttpsExperiment", HttpsExperimentFetcher.class);
            c("tbadkcore", "INetExperiment", NetExperimentFetcher.class);
            c("tbadkcore", "ISoProcess", nq5.class);
            c("tbadkcore", "tbadkcore", k46.class);
            c("tieba.core", "eventbus", x09.class);
            c("tieba.core", "eventbus.autorelease", w09.class);
            c("ubc", UBC.TAG, k9b.class);
            c("voyager", "upload", gib.class);
            c("yaLog", "yaLogConfig", fjb.class);
        }
    }
}

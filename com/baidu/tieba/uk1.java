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
public class uk1 {
    public static /* synthetic */ Interceptable $ic;
    public static final ConcurrentHashMap<ServiceReference, tk1<?>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948213774, "Lcom/baidu/tieba/uk1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948213774, "Lcom/baidu/tieba/uk1;");
                return;
            }
        }
        a = new ConcurrentHashMap<>();
        d();
    }

    public uk1() {
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
            tk1<?> tk1Var = a.get(serviceReference);
            if (tk1Var != null) {
                return (T) tk1Var.getService();
            }
            return null;
        }
        return (T) invokeL.objValue;
    }

    public static <T> void b(ServiceReference serviceReference, tk1<T> tk1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, serviceReference, tk1Var) == null) {
            a.put(serviceReference, tk1Var);
        }
    }

    public static <T> void c(String str, String str2, Class<? extends tk1<T>> cls) {
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
            c("AlaLiveSdk", "IMSdkService", gz8.class);
            c("AlaLiveSdk", "IMSdkServicePerson", hz8.class);
            c("AlaSquare", "SecondFloorService", cb6.class);
            c(IFetchTask.NAME_SPACE, "report", FetchTaskFetcher.class);
            c("Frames", "ISafetyConfig", oi6.class);
            c("Frames", "JsPromptBridge", ii6.class);
            c("Frs", "FrsService", vf7.class);
            c("Frs", "FrsVisitedInfoService", pv6.class);
            c("HotTopic", "HotTopicRequest", e26.class);
            c("IM", "IMessageCenterService", us8.class);
            c("ImMessageCenter", "ChatBoxDialogService", ng8.class);
            c("ImMessageCenter", "ChatFloatEntranceService", fi8.class);
            c("ImMessageCenter", "GroupChatService", kg8.class);
            c("UniKVTest", "UniKVTest", UniKVTestFetcher.class);
            c(WebView.LOGTAG, "EMManagerProvider", gi6.class);
            c(WebView.LOGTAG, "IPrefetchManager", ei6.class);
            c(WebView.LOGTAG, "IPrerenderManager", fi6.class);
            c(WebView.LOGTAG, "IWebViewDebug", hi6.class);
            c(WebView.LOGTAG, "IWebViewFactoryService", zh6.class);
            c("abtest", "service", AbTestServiceFetcher.class);
            c("behavior-api", "behavior-api", BehaviorServiceFetcher.class);
            c("device_score", "DEVICE_SCORE", DeviceScoreFetcher.class);
            c("device_score", "DEVICE_SCORE_COLLECT", DeviceScoreCollectFetcher.class);
            c("device_score", "DEVICE_SCORE_CONFIG", DeviceScoreConfigFetcher.class);
            c("download", "DOWNLOAD", uv6.class);
            c("download", "DOWNLOAD", w10.class);
            c("download", "db", s10.class);
            c("feed", "component.resolver", xo6.class);
            c("feed", "widget.resolver", yo6.class);
            c("live", DI.AB_NAME, v19.class);
            c("live", "account", j19.class);
            c("live", DI.APP_INFO_NAME, l19.class);
            c("live", DI.PLAYER.DU_MEDIA, v29.class);
            c("live", DI.EXT.EXT_LIVE_JUMP_PAGE, f29.class);
            c("live", DI.EXT.EXT_LIVE_LOG, m29.class);
            c("live", DI.FOLLOW_STATUS, b29.class);
            c("live", DI.LIGHTBROWSER_VIEW, q19.class);
            c("live", DI.LIVE_CUSTOM_SETTINGS, k39.class);
            c("live", DI.LIVE_EVENT_DISPATCHER, z19.class);
            c("live", DI.LIVE_INSERT_VIDEO, VideoInsertLiveServiceFetcher.class);
            c("live", DI.LIVE_LIKE, h29.class);
            c("live", DI.LIVE_LOCATION, k29.class);
            c("live", DI.LIVE_PLAY_URL, LivePlayUrlServiceFetcher.class);
            c("live", DI.LIVE_REAL_AUTH, n19.class);
            c("live", DI.LIVE_SHOW_VIDEO_PLAYER, w29.class);
            c("live", DI.LIVE_USER_SECURITY_BEHAVIOR, x19.class);
            c("live", DI.LIVE_USER_SECURITY_DEVICE_INFO, y19.class);
            c("live", DI.LIVE_YY_RTC, i39.class);
            c("live", DI.MINI_SHELL.MEDIA_2_YY, Media2YYServiceFetcher.class);
            c("live", "multi_plugin", MultiPluginManagerServiceFetcher.class);
            c("live", "net", o29.class);
            c("live", DI.PAY_CHANNEL, t19.class);
            c("live", DI.LIVE_PLAYER, d39.class);
            c("live", DI.MINI_SHELL.PLUGIN_MANAGER, PluginInvokeServiceFetcher.class);
            c("live", DI.LIVE_PRE_START_PLAYER, LivePreStartPlayServiceFetcher.class);
            c("live", DI.ROUTER_NAME, g39.class);
            c("live", "share", o39.class);
            c("live", DI.TB.SHARE_CHANNEL, m39.class);
            c("live", DI.THIRD_PART_ACCOUNT, q39.class);
            c("live", DI.YY.THIRD_PART_ALI_RECHARGE, r39.class);
            c("live", DI.YY.THIRD_PART_WX_RECHARGE, t39.class);
            c("live", "toast", v39.class);
            c("live", DI.MINI_SHELL.YY_2_MEDIA, YY2MediaServiceFetcher.class);
            c("live", DI.YY.YY_GAMEASSIST_DXM_RECHARGE, vv7.class);
            c("live", DI.YY.YY_GAMEASSIST_HOST_INFO, tv7.class);
            c("live", DI.YY.YY_GAMEASSIST_MODIFY_PWD, xv7.class);
            c("live", DI.YY.YY_GAMEASSIST_PERSMISSION, zv7.class);
            c("live", DI.YY.YY_MULTI_PLUGIN_PROGRESS, YYPluginProgressInvokeServiceFetcher.class);
            c("live", DI.YYPAY.YY_PAY, r29.class);
            c("live", DI.YY.YY_PLUGIN, YYPluginManageServiceFetcher.class);
            c(com.baidu.searchbox.live.game.interfaces.DI.MODULE_NAME, "common", d29.class);
            c("logsystem", "exceptionhandler", ExceptionHandlerServiceFetcher.class);
            c("module_home", "SpriteResourceService", h7a.class);
            c("module_home", "SpriteStateService", c7a.class);
            c("nad.business", "rewardVideoLpTaskCenter", vo0.class);
            c("nad.core", "adRequester", q21.class);
            c("nad.core", "browserDownload", cl0.class);
            c("nad.core", "cmd", p66.class);
            c("nad.core", "config", q66.class);
            c("nad.core", "crius", ok0.class);
            c("nad.core", "cyber", n56.class);
            c("nad.core", "deviceInfo.bag", d.class);
            c("nad.core", "deviceInfoInner", sh0.class);
            c("nad.core", "downloadCreator", d76.class);
            c("nad.core", "eventbus", an0.class);
            c("nad.core", "exp", pn0.class);
            c("nad.core", "ipdx", vh0.class);
            c("nad.core", "loadImage", bh0.class);
            c("nad.core", "loadVideo", my0.class);
            c("nad.core", "maxUI", s66.class);
            c("nad.core", "nativeCookieMgr", fa1.class);
            c("nad.core", "navBarTool", u66.class);
            c("nad.core", "splash.config", v66.class);
            c("nad.core", "splash.host", w66.class);
            c("nad.core", "thirdService", t66.class);
            c("nad.core", "uad", x66.class);
            c(StatConstants.VALUE_FROM_RETRIEVE, "stat", StatServiceFetcher.class);
            c(StatConstants.VALUE_FROM_RETRIEVE, "upload", UploadTaskFetcher.class);
            c("speed", "runtime", SpeedRuntimeProvider.class);
            c("tbBaseEmotion", "EmotionService", kx6.class);
            c("tbadkcore", "IHttpsExperiment", HttpsExperimentFetcher.class);
            c("tbadkcore", "INetExperiment", NetExperimentFetcher.class);
            c("tbadkcore", "ISoProcess", wp5.class);
            c("tbadkcore", "IThreadExperiment", ThreadExperimentFetcher.class);
            c("tbadkcore", "tbadkcore", s36.class);
            c("tieba.core", "eventbus", tw8.class);
            c("tieba.core", "eventbus.autorelease", sw8.class);
            c("ubc", UBC.TAG, u2b.class);
            c("voyager", "upload", qbb.class);
            c("yaLog", "yaLogConfig", pcb.class);
        }
    }
}

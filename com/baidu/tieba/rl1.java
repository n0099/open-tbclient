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
/* loaded from: classes7.dex */
public class rl1 {
    public static /* synthetic */ Interceptable $ic;
    public static final ConcurrentHashMap<ServiceReference, ql1<?>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948125362, "Lcom/baidu/tieba/rl1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948125362, "Lcom/baidu/tieba/rl1;");
                return;
            }
        }
        a = new ConcurrentHashMap<>();
        d();
    }

    public rl1() {
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
            ql1<?> ql1Var = a.get(serviceReference);
            if (ql1Var != null) {
                return (T) ql1Var.getService();
            }
            return null;
        }
        return (T) invokeL.objValue;
    }

    public static <T> void b(ServiceReference serviceReference, ql1<T> ql1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, serviceReference, ql1Var) == null) {
            a.put(serviceReference, ql1Var);
        }
    }

    public static <T> void c(String str, String str2, Class<? extends ql1<T>> cls) {
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
            c("AlaLiveSdk", "IMSdkService", l19.class);
            c("AlaLiveSdk", "IMSdkServicePerson", m19.class);
            c("AlaSquare", "SecondFloorService", wd6.class);
            c(IFetchTask.NAME_SPACE, "report", FetchTaskFetcher.class);
            c("Frames", "ISafetyConfig", il6.class);
            c("Frames", "JsPromptBridge", cl6.class);
            c("Frs", "FrsService", ni7.class);
            c("HotTopic", "HotTopicRequest", x46.class);
            c("IM", "IMessageCenterService", yu8.class);
            c("ImMessageCenter", "ChatBoxDialogService", vi8.class);
            c("ImMessageCenter", "ChatFloatEntranceService", nk8.class);
            c("ImMessageCenter", "GroupChatService", si8.class);
            c("UniKVTest", "UniKVTest", UniKVTestFetcher.class);
            c(WebView.LOGTAG, "EMManagerProvider", al6.class);
            c(WebView.LOGTAG, "IPrefetchManager", yk6.class);
            c(WebView.LOGTAG, "IPrerenderManager", zk6.class);
            c(WebView.LOGTAG, "IWebViewDebug", bl6.class);
            c(WebView.LOGTAG, "IWebViewFactoryService", tk6.class);
            c("abtest", "service", AbTestServiceFetcher.class);
            c("behavior-api", "behavior-api", BehaviorServiceFetcher.class);
            c("device_score", "DEVICE_SCORE", DeviceScoreFetcher.class);
            c("device_score", "DEVICE_SCORE_COLLECT", DeviceScoreCollectFetcher.class);
            c("device_score", "DEVICE_SCORE_CONFIG", DeviceScoreConfigFetcher.class);
            c("download", "DOWNLOAD", my6.class);
            c("download", "DOWNLOAD", y20.class);
            c("download", "db", u20.class);
            c("feed", "component.resolver", qr6.class);
            c("feed", "widget.resolver", rr6.class);
            c("live", DI.AB_NAME, b49.class);
            c("live", DI.ACCOUNT, p39.class);
            c("live", DI.APP_INFO_NAME, r39.class);
            c("live", DI.EXT.EXT_LIVE_JUMP_PAGE, l49.class);
            c("live", DI.EXT.EXT_LIVE_LOG, s49.class);
            c("live", DI.FOLLOW_STATUS, h49.class);
            c("live", DI.LIGHTBROWSER_VIEW, w39.class);
            c("live", DI.LIVE_CUSTOM_SETTINGS, m59.class);
            c("live", DI.LIVE_EVENT_DISPATCHER, f49.class);
            c("live", DI.LIVE_INSERT_VIDEO, VideoInsertLiveServiceFetcher.class);
            c("live", DI.LIVE_LIKE, n49.class);
            c("live", DI.LIVE_LOCATION, q49.class);
            c("live", DI.LIVE_PLAY_URL, LivePlayUrlServiceFetcher.class);
            c("live", DI.LIVE_REAL_AUTH, t39.class);
            c("live", DI.LIVE_SHOW_VIDEO_PLAYER, a59.class);
            c("live", DI.LIVE_USER_SECURITY_BEHAVIOR, d49.class);
            c("live", DI.LIVE_USER_SECURITY_DEVICE_INFO, e49.class);
            c("live", DI.MINI_SHELL.MEDIA_2_YY, Media2YYServiceFetcher.class);
            c("live", "multi_plugin", MultiPluginManagerServiceFetcher.class);
            c("live", "net", u49.class);
            c("live", DI.PAY_CHANNEL, z39.class);
            c("live", DI.LIVE_PLAYER, h59.class);
            c("live", DI.MINI_SHELL.PLUGIN_MANAGER, PluginInvokeServiceFetcher.class);
            c("live", DI.LIVE_PRE_START_PLAYER, LivePreStartPlayServiceFetcher.class);
            c("live", DI.ROUTER_NAME, k59.class);
            c("live", "share", q59.class);
            c("live", DI.TB.SHARE_CHANNEL, o59.class);
            c("live", DI.THIRD_PART_ACCOUNT, s59.class);
            c("live", DI.YY.THIRD_PART_ALI_RECHARGE, t59.class);
            c("live", DI.YY.THIRD_PART_WX_RECHARGE, v59.class);
            c("live", "toast", x59.class);
            c("live", DI.MINI_SHELL.YY_2_MEDIA, YY2MediaServiceFetcher.class);
            c("live", DI.YY.YY_GAMEASSIST_DXM_RECHARGE, ny7.class);
            c("live", DI.YY.YY_GAMEASSIST_HOST_INFO, ly7.class);
            c("live", DI.YY.YY_GAMEASSIST_MODIFY_PWD, py7.class);
            c("live", DI.YY.YY_GAMEASSIST_PERSMISSION, ry7.class);
            c("live", DI.YY.YY_MULTI_PLUGIN_PROGRESS, YYPluginProgressInvokeServiceFetcher.class);
            c("live", DI.YYPAY.YY_PAY, x49.class);
            c("live", DI.YY.YY_PLUGIN, YYPluginManageServiceFetcher.class);
            c(com.baidu.searchbox.live.game.interfaces.DI.MODULE_NAME, "common", j49.class);
            c("logsystem", "exceptionhandler", ExceptionHandlerServiceFetcher.class);
            c("module_home", "SpriteResourceService", m8a.class);
            c("module_home", "SpriteStateService", h8a.class);
            c("nad.business", "rewardVideoLpTaskCenter", xp0.class);
            c("nad.core", "adRequester", n31.class);
            c("nad.core", "browserDownload", em0.class);
            c("nad.core", "cmd", i96.class);
            c("nad.core", "config", j96.class);
            c("nad.core", "crius", ql0.class);
            c("nad.core", "cyber", g86.class);
            c("nad.core", "deviceInfo.bag", d.class);
            c("nad.core", "deviceInfoInner", ui0.class);
            c("nad.core", "downloadCreator", w96.class);
            c("nad.core", "eventbus", co0.class);
            c("nad.core", "exp", ro0.class);
            c("nad.core", "ipdx", xi0.class);
            c("nad.core", "loadImage", di0.class);
            c("nad.core", "loadVideo", jz0.class);
            c("nad.core", "maxUI", l96.class);
            c("nad.core", "nativeCookieMgr", cb1.class);
            c("nad.core", "navBarTool", n96.class);
            c("nad.core", "splash.config", o96.class);
            c("nad.core", "splash.host", p96.class);
            c("nad.core", "thirdService", m96.class);
            c("nad.core", "uad", q96.class);
            c(StatConstants.VALUE_FROM_RETRIEVE, "stat", StatServiceFetcher.class);
            c(StatConstants.VALUE_FROM_RETRIEVE, "upload", UploadTaskFetcher.class);
            c("speed", "runtime", SpeedRuntimeProvider.class);
            c("tbBaseEmotion", "EmotionService", c07.class);
            c("tbadkcore", "IHttpsExperiment", HttpsExperimentFetcher.class);
            c("tbadkcore", "INetExperiment", NetExperimentFetcher.class);
            c("tbadkcore", "ISoProcess", sr5.class);
            c("tbadkcore", "IThreadExperiment", ThreadExperimentFetcher.class);
            c("tbadkcore", "tbadkcore", l66.class);
            c("tieba.core", "eventbus", xy8.class);
            c("tieba.core", "eventbus.autorelease", wy8.class);
            c("ubc", UBC.TAG, r3b.class);
            c("voyager", "upload", ncb.class);
            c("yaLog", "yaLogConfig", mdb.class);
        }
    }
}

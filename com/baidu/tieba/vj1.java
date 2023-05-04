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
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public class vj1 {
    public static /* synthetic */ Interceptable $ic;
    public static final ConcurrentHashMap<ServiceReference, uj1<?>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948242604, "Lcom/baidu/tieba/vj1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948242604, "Lcom/baidu/tieba/vj1;");
                return;
            }
        }
        a = new ConcurrentHashMap<>();
        d();
    }

    public vj1() {
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
            uj1<?> uj1Var = a.get(serviceReference);
            if (uj1Var != null) {
                return (T) uj1Var.getService();
            }
            return null;
        }
        return (T) invokeL.objValue;
    }

    public static <T> void b(ServiceReference serviceReference, uj1<T> uj1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, serviceReference, uj1Var) == null) {
            a.put(serviceReference, uj1Var);
        }
    }

    public static <T> void c(String str, String str2, Class<? extends uj1<T>> cls) {
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
            c("AlaLiveSdk", "IMSdkService", hi8.class);
            c("AlaLiveSdk", "IMSdkServicePerson", ii8.class);
            c("AlaSquare", "SecondFloorService", q66.class);
            c(IFetchTask.NAME_SPACE, "report", FetchTaskFetcher.class);
            c("Frames", "ISafetyConfig", ae6.class);
            c("Frames", "JsPromptBridge", ud6.class);
            c("Frs", "FrsService", e77.class);
            c("HotTopic", "HotTopicRequest", ux5.class);
            c("ImMessageCenter", "ChatBoxDialogService", f58.class);
            c("ImMessageCenter", "ChatFloatEntranceService", d68.class);
            c("ImMessageCenter", "GroupChatService", d58.class);
            c(WebView.LOGTAG, "EMManagerProvider", td6.class);
            c(WebView.LOGTAG, "IPrefetchManager", rd6.class);
            c(WebView.LOGTAG, "IPrerenderManager", sd6.class);
            c(WebView.LOGTAG, "IWebViewFactoryService", md6.class);
            c("abtest", "service", AbTestServiceFetcher.class);
            c("behavior-api", "behavior-api", BehaviorServiceFetcher.class);
            c("device_score", "DEVICE_SCORE", DeviceScoreFetcher.class);
            c("device_score", "DEVICE_SCORE_COLLECT", DeviceScoreCollectFetcher.class);
            c("device_score", "DEVICE_SCORE_CONFIG", DeviceScoreConfigFetcher.class);
            c("feed", "component.resolver", wj6.class);
            c("feed", "widget.resolver", xj6.class);
            c("live", DI.AB_NAME, xk8.class);
            c("live", DI.ACCOUNT, lk8.class);
            c("live", DI.APP_INFO_NAME, nk8.class);
            c("live", DI.EXT.EXT_LIVE_JUMP_PAGE, hl8.class);
            c("live", DI.EXT.EXT_LIVE_LOG, ol8.class);
            c("live", DI.FOLLOW_STATUS, dl8.class);
            c("live", DI.LIGHTBROWSER_VIEW, sk8.class);
            c("live", DI.LIVE_CUSTOM_SETTINGS, im8.class);
            c("live", DI.LIVE_EVENT_DISPATCHER, bl8.class);
            c("live", DI.LIVE_INSERT_VIDEO, VideoInsertLiveServiceFetcher.class);
            c("live", DI.LIVE_LIKE, jl8.class);
            c("live", DI.LIVE_LOCATION, ml8.class);
            c("live", DI.LIVE_PLAY_URL, LivePlayUrlServiceFetcher.class);
            c("live", DI.LIVE_REAL_AUTH, pk8.class);
            c("live", DI.LIVE_SHOW_VIDEO_PLAYER, wl8.class);
            c("live", DI.LIVE_USER_SECURITY_BEHAVIOR, zk8.class);
            c("live", DI.LIVE_USER_SECURITY_DEVICE_INFO, al8.class);
            c("live", DI.MINI_SHELL.MEDIA_2_YY, Media2YYServiceFetcher.class);
            c("live", "multi_plugin", MultiPluginManagerServiceFetcher.class);
            c("live", "net", ql8.class);
            c("live", DI.PAY_CHANNEL, vk8.class);
            c("live", DI.LIVE_PLAYER, dm8.class);
            c("live", DI.MINI_SHELL.PLUGIN_MANAGER, PluginInvokeServiceFetcher.class);
            c("live", DI.LIVE_PRE_START_PLAYER, LivePreStartPlayServiceFetcher.class);
            c("live", DI.ROUTER_NAME, gm8.class);
            c("live", "share", mm8.class);
            c("live", DI.TB.SHARE_CHANNEL, km8.class);
            c("live", DI.THIRD_PART_ACCOUNT, om8.class);
            c("live", DI.YY.THIRD_PART_ALI_RECHARGE, pm8.class);
            c("live", DI.YY.THIRD_PART_WX_RECHARGE, rm8.class);
            c("live", "toast", tm8.class);
            c("live", DI.MINI_SHELL.YY_2_MEDIA, YY2MediaServiceFetcher.class);
            c("live", DI.YY.YY_MULTI_PLUGIN_PROGRESS, YYPluginProgressInvokeServiceFetcher.class);
            c("live", DI.YYPAY.YY_PAY, tl8.class);
            c("live", DI.YY.YY_PLUGIN, YYPluginManageServiceFetcher.class);
            c(com.baidu.searchbox.live.game.interfaces.DI.MODULE_NAME, "common", fl8.class);
            c("logsystem", "exceptionhandler", ExceptionHandlerServiceFetcher.class);
            c("module_home", "SpriteResourceService", jl9.class);
            c("nad.business", "rewardVideoLpTaskCenter", kn0.class);
            c("nad.core", "adRequester", w01.class);
            c("nad.core", "browserDownload", yj0.class);
            c("nad.core", "cmd", d26.class);
            c("nad.core", "config", e26.class);
            c("nad.core", "crius", kj0.class);
            c("nad.core", "deviceInfo.bag", c.class);
            c("nad.core", "deviceInfoInner", qg0.class);
            c("nad.core", "eventbus", pl0.class);
            c("nad.core", "exp", em0.class);
            c("nad.core", "ipdx", tg0.class);
            c("nad.core", "loadImage", zf0.class);
            c("nad.core", "loadVideo", sw0.class);
            c("nad.core", "maxUI", g26.class);
            c("nad.core", "nativeCookieMgr", w71.class);
            c("nad.core", "navBarTool", i26.class);
            c("nad.core", "splash.config", j26.class);
            c("nad.core", "splash.host", k26.class);
            c("nad.core", "thirdService", h26.class);
            c("nad.core", "uad", l26.class);
            c(StatConstants.VALUE_FROM_RETRIEVE, "stat", StatServiceFetcher.class);
            c(StatConstants.VALUE_FROM_RETRIEVE, StatConstants.VALUE_TYPE_UPLOAD, UploadTaskFetcher.class);
            c("speed", "runtime", SpeedRuntimeProvider.class);
            c("tbBaseEmotion", "EmotionService", tq6.class);
            c("tbadkcore", "IHttpsExperiment", HttpsExperimentFetcher.class);
            c("tbadkcore", "INetExperiment", NetExperimentFetcher.class);
            c("tbadkcore", "ISoProcess", rk5.class);
            c("tbadkcore", "IThreadExperiment", ThreadExperimentFetcher.class);
            c("tbadkcore", "tbadkcore", iz5.class);
            c("tieba.core", "eventbus", tf8.class);
            c("tieba.core", "eventbus.autorelease", sf8.class);
            c(UBCCloudControlProcessor.UBC_KEY, UBC.TAG, tea.class);
            c("voyager", StatConstants.VALUE_TYPE_UPLOAD, pna.class);
            c("yaLog", "yaLogConfig", ooa.class);
        }
    }
}

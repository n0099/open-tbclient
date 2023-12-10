package com.baidu.tieba.livesdk;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.controller.CustomRule;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.log.PeiwanLog;
import com.baidu.ala.AlaCmdConfigSocket;
import com.baidu.ala.atomdata.AlaAdminListActivityConfig;
import com.baidu.ala.atomdata.AlaFansFamilyActivityConfig;
import com.baidu.ala.atomdata.AlaForbiddenListActivityConfig;
import com.baidu.ala.atomdata.AlaLoveFamilyActivityConfig;
import com.baidu.ala.atomdata.AlaPersonCenterExpActivityConfig;
import com.baidu.ala.atomdata.AlaPersonCenterRealAuthenConfig;
import com.baidu.ala.atomdata.AlaSDKShareEmptyActivityConfig;
import com.baidu.ala.liveroom.messages.ALAPushAlertResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.searchbox.live.nps.LiveNPSPluginManager;
import com.baidu.searchbox.schemedispatch.forbid.InvokeStatisticKt;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.abtest.UsbAbTestConst;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.ala.IYYCloudSwitchCallback;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.AlaMasterLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.AlaTabFeedActivityConfig;
import com.baidu.tbadk.core.atomData.AlaWriteShareInBarActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.BjhMasterActivityConfig;
import com.baidu.tbadk.core.util.ForumBroadcastHelper;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.NewUrlSchemaHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.mutiprocess.share.ShareEvent;
import com.baidu.tbadk.util.WebviewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.a5;
import com.baidu.tieba.aa5;
import com.baidu.tieba.cn8;
import com.baidu.tieba.g98;
import com.baidu.tieba.gg;
import com.baidu.tieba.kh9;
import com.baidu.tieba.kj9;
import com.baidu.tieba.livesdk.dispatcher.YYCustomerServiceDispatcher;
import com.baidu.tieba.livesdk.dispatcher.YYFeedbackDispatcher;
import com.baidu.tieba.livesdk.dispatcher.YYLiveRoomDispatcher;
import com.baidu.tieba.livesdk.dispatcher.YYRouterDispatcher;
import com.baidu.tieba.livesdk.share.AlaSDKShareEmptyActivity;
import com.baidu.tieba.livesdk.share.AlaShareInBarEmptyActivity;
import com.baidu.tieba.nu5;
import com.baidu.tieba.ph9;
import com.baidu.tieba.play.cyberPlayer.CyberRemotePlayerService;
import com.baidu.tieba.qh9;
import com.baidu.tieba.qn6;
import com.baidu.tieba.ru5;
import com.baidu.tieba.st5;
import com.baidu.tieba.tbadkCore.data.FlutterOpenData;
import com.baidu.tieba.vh9;
import com.baidu.tieba.vn6;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class AlaLiveSdkStatic {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public static CustomMessageListener b;
    public static CustomMessageListener c;
    public static CustomMessageListener d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public interface w {
        void a(Boolean bool, String str);
    }

    /* loaded from: classes7.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: com.baidu.tieba.livesdk.AlaLiveSdkStatic$d$a$a  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class C0389a extends nu5<String> {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                public C0389a(a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tieba.nu5
                public String doInBackground() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        return UtilHelper.getClipBoardContent();
                    }
                    return (String) invokeV.objValue;
                }
            }

            /* loaded from: classes7.dex */
            public class b implements st5<String> {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                public b(a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tieba.st5
                /* renamed from: a */
                public void onReturnDataInUI(String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null && interceptable.invokeL(1048576, this, str) != null) {
                        return;
                    }
                    AlaLiveSdkStatic.t(str);
                }
            }

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (TbadkCoreApplication.getInst().isMIUIRom()) {
                        ru5.b(new C0389a(this), new b(this));
                    } else {
                        AlaLiveSdkStatic.t(UtilHelper.getClipBoardContent());
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                SafeHandler.getInst().postDelayed(new a(this), 100L);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.baidu.tieba.livesdk.AlaLiveSdkStatic$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0388a extends CustomMessageListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0388a(a aVar, int i) {
                super(i);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super(((Integer) newInitContext.callArgs[0]).intValue());
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                    LiveNPSPluginManager.getInstance().startYYActivity(TbadkCoreApplication.getInst().getCurrentActivity());
                }
            }
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MessageManager.getInstance().registerListener(new C0388a(this, 2921569));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements UrlManager.UrlDealListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes7.dex */
        public class a implements CyberPlayerManager.InstallListener2 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
            public void onInstallError(int i, int i2, String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIIL(1048576, this, i, i2, str) == null) {
                }
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
            public void onInstallProgress(int i, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
                }
            }

            public a(i iVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener2
            public void onInstallInfo(int i, int i2, Object obj) {
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, obj) != null) || !(obj instanceof String)) {
                    return;
                }
                if (i == 100) {
                    TbadkCoreApplication.getInst().setLibcyberffmpeg((String) obj);
                } else if (i == 101) {
                    TbadkCoreApplication.getInst().setLibssl((String) obj);
                } else if (i == 102) {
                    TbadkCoreApplication.getInst().setLibcrypto((String) obj);
                }
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
            public void onInstallSuccess(int i, String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) {
                    TbadkCoreApplication.getInst().setLibcyberVersion(str);
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements w {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;
            public final /* synthetic */ String b;
            public final /* synthetic */ HashMap c;
            public final /* synthetic */ TbPageContext d;
            public final /* synthetic */ String e;
            public final /* synthetic */ Uri f;

            public b(i iVar, String str, String str2, HashMap hashMap, TbPageContext tbPageContext, String str3, Uri uri) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iVar, str, str2, hashMap, tbPageContext, str3, uri};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = str;
                this.b = str2;
                this.c = hashMap;
                this.d = tbPageContext;
                this.e = str3;
                this.f = uri;
            }

            @Override // com.baidu.tieba.livesdk.AlaLiveSdkStatic.w
            public void a(Boolean bool, String str) {
                String str2;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048576, this, bool, str) == null) {
                    if (bool.booleanValue()) {
                        String str3 = this.a;
                        String str4 = this.b;
                        if (!TextUtils.isDigitsOnly(str3)) {
                            this.c.put("room_id", str);
                            str4 = AlaLiveSdkStatic.m(this.c);
                            str2 = str;
                        } else {
                            str2 = str3;
                        }
                        kj9.j().w(this.d.getPageActivity(), str2, this.e, str4, this.f);
                    } else if (UsbAbTestConst.KEY_SHARE_H5_CARD_OPTIMIZE.equals(this.e)) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("open_busy_tips", 1);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new FlutterOpenData(this.d.getPageActivity(), "GameAudioListPage", hashMap)));
                    } else {
                        BdUtilHelper.showToast(this.d.getPageActivity(), (int) R.string.obfuscated_res_0x7f0f08da);
                    }
                }
            }
        }

        /* loaded from: classes7.dex */
        public class c implements qh9 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ TbPageContext a;
            public final /* synthetic */ String b;

            public c(i iVar, TbPageContext tbPageContext, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iVar, tbPageContext, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = tbPageContext;
                this.b = str;
            }

            @Override // com.baidu.tieba.qh9
            public void onCallback(JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                    try {
                        int optInt = jSONObject.optInt("status", 0);
                        String optString = jSONObject.optString("message");
                        String optString2 = jSONObject.optString("productId");
                        String optString3 = jSONObject.optString("total");
                        String optString4 = jSONObject.optString("transitionId");
                        JSONObject jSONObject2 = new JSONObject();
                        if (!TextUtils.isEmpty(optString2)) {
                            jSONObject2.put("productId", optString2);
                        }
                        if (!TextUtils.isEmpty(optString3)) {
                            jSONObject2.put("total", optString3);
                        }
                        if (!TextUtils.isEmpty(optString4)) {
                            jSONObject2.put("transitionId", optString4);
                        }
                        AlaLiveSdkStatic.p(this.a, optInt, optString, jSONObject2, this.b);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public i() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            InterceptResult invokeLL;
            long longValue;
            int intValue;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, tbPageContext, strArr)) == null) {
                if (tbPageContext != null && strArr != null && strArr[0] != null) {
                    if (!CyberPlayerManager.isCoreLoaded(1)) {
                        try {
                            CyberPlayerManager.install(TbadkCoreApplication.getInst().getContext(), TbadkCoreApplication.getInst().getCuidGalaxy2(), (String) null, 3, (Class<?>) CyberRemotePlayerService.class, (Map<String, String>) null, (CyberPlayerManager.InstallListener2) new a(this));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    if (!strArr[0].startsWith(UrlSchemaHelper.SCHEMA_LIVE_SDK) && !strArr[0].contains(UrlSchemaHelper.GO_TO_MIX_LIVE) && !strArr[0].startsWith(NewUrlSchemaHelper.SCHEME)) {
                        return 3;
                    }
                    AlaLiveSdkStatic.n();
                    if (strArr[0].contains(UrlSchemaHelper.GO_TO_MIX_LIVE)) {
                        String paramFromURL = WebviewHelper.getParamFromURL(strArr[0], "url");
                        if ("video/mixlive".equals(AlaLiveSdkStatic.r(paramFromURL))) {
                            Uri parse = Uri.parse(paramFromURL);
                            HashMap hashMap = new HashMap();
                            for (String str : parse.getQueryParameterNames()) {
                                hashMap.put(str, parse.getQueryParameter(str));
                            }
                            kj9.j().w(tbPageContext.getPageActivity(), (String) hashMap.get("room_id"), (String) hashMap.get("source"), AlaLiveSdkStatic.m(hashMap), parse);
                            return 0;
                        }
                    }
                    if (strArr[0].startsWith("bdtiebalive://video/mixlive") && "video/mixlive".equals(AlaLiveSdkStatic.r(strArr[0]))) {
                        Uri parse2 = Uri.parse(strArr[0]);
                        HashMap hashMap2 = new HashMap();
                        for (String str2 : parse2.getQueryParameterNames()) {
                            hashMap2.put(str2, parse2.getQueryParameter(str2));
                        }
                        String str3 = (String) hashMap2.get("room_id");
                        String str4 = (String) hashMap2.get("source");
                        String m = AlaLiveSdkStatic.m(hashMap2);
                        if (!"source_host_invite".equals(str4) && !"source_user_click".equals(str4) && !UsbAbTestConst.KEY_SHARE_H5_CARD_OPTIMIZE.equals(str4) && !"source_system_recommend".equals(str4) && !"source_tieba_card".equals(str4) && !"source_audio_unknown".equals(str4)) {
                            kj9.j().w(tbPageContext.getPageActivity(), str3, str4, m, parse2);
                        } else {
                            AlaLiveSdkStatic.o(str3, new b(this, str3, m, hashMap2, tbPageContext, str4, parse2));
                        }
                        return 0;
                    } else if (strArr[0].startsWith("bdtiebalive://video/createRoom") && "video/createRoom".equals(AlaLiveSdkStatic.r(strArr[0]))) {
                        Uri parse3 = Uri.parse(strArr[0]);
                        HashMap hashMap3 = new HashMap();
                        for (String str5 : parse3.getQueryParameterNames()) {
                            hashMap3.put(str5, String.valueOf(parse3.getQueryParameter(str5)));
                        }
                        BjhMasterActivityConfig bjhMasterActivityConfig = new BjhMasterActivityConfig(tbPageContext.getPageActivity().getApplication(), (String) hashMap3.get("fid"), (String) hashMap3.get(ForumBroadcastHelper.KEY_PARMARS_FORUM_NAME));
                        kh9.r((Application) bjhMasterActivityConfig.getContext(), bjhMasterActivityConfig.getTiebaExtra(), null);
                        return 0;
                    } else if (strArr[0].startsWith("bdtiebalive://deeplink")) {
                        if (InvokeStatisticKt.SCHEME_INVOKE_PAGE_DEEPLINK.equals(AlaLiveSdkStatic.r(strArr[0]))) {
                            vn6 vn6Var = new vn6(strArr[0]);
                            qn6.a(tbPageContext.getPageActivity(), vn6Var.d(), vn6Var.a(), false);
                        }
                        return 0;
                    } else {
                        if (strArr[0].startsWith("bdtiebalive://webview") && AlbumActivityConfig.FROM_WEB_VIEW.equals(AlaLiveSdkStatic.r(strArr[0]))) {
                            String b2 = new vn6(strArr[0]).b("url_key");
                            if (!TextUtils.isEmpty(b2)) {
                                UrlManager.getInstance().dealOneLink((TbPageContext) a5.a(tbPageContext.getPageActivity()), new String[]{b2});
                                return 0;
                            }
                        }
                        if (strArr[0].startsWith("bdtiebalive://video/live")) {
                            Uri parse4 = Uri.parse(strArr[0]);
                            HashMap hashMap4 = new HashMap();
                            for (String str6 : parse4.getQueryParameterNames()) {
                                hashMap4.put(str6, parse4.getQueryParameter(str6));
                            }
                            if (strArr[0].startsWith("bdtiebalive:video/live/tbean")) {
                                String str7 = (String) hashMap4.get(WebChromeClient.KEY_ARG_CALLBACK);
                                vh9 vh9Var = new vh9();
                                vh9Var.a = str7;
                                vh9Var.c = (String) hashMap4.get("is_translucent");
                                vh9Var.b = TextUtils.equals((String) hashMap4.get("is_translucent"), "1");
                                kh9.d(tbPageContext.getPageActivity(), vh9Var, new c(this, tbPageContext, str7));
                            } else if (strArr[0].startsWith("bdtiebalive://video/live/start")) {
                                kh9.a(tbPageContext.getPageActivity(), strArr[0], hashMap4);
                            } else if (strArr[0].startsWith("bdtiebalive://video/live/admin")) {
                                kh9.e(tbPageContext.getPageActivity());
                            } else if (strArr[0].startsWith("bdtiebalive://video/live/forbidden")) {
                                kh9.h(tbPageContext.getPageActivity());
                            } else if (!strArr[0].startsWith("bdtiebalive://video/live/exp") && !strArr[0].startsWith("bdtiebalive://video/live/experience")) {
                                if (strArr[0].startsWith("bdtiebalive://video/live/guardian")) {
                                    kh9.j(tbPageContext.getPageActivity(), (String) hashMap4.get("value"), (String) hashMap4.get("uid"));
                                } else if (strArr[0].startsWith("bdtiebalive://video/live/fans")) {
                                    kh9.g(tbPageContext.getPageActivity(), null, 0);
                                } else if (strArr[0].startsWith("bdtiebalive://video/live/patrons")) {
                                    kh9.m(tbPageContext.getPageActivity(), (String) hashMap4.get("userId"));
                                } else if (strArr[0].startsWith("bdtiebalive://video/live/patronage")) {
                                    kh9.l(tbPageContext.getPageActivity());
                                } else if (strArr[0].startsWith("bdtiebalive://video/live/realAuthen")) {
                                    kh9.n(tbPageContext.getPageActivity(), (String) hashMap4.get("userId"), (String) hashMap4.get("certifyStatus"));
                                } else {
                                    kh9.b(tbPageContext.getPageActivity(), strArr[0], hashMap4);
                                }
                            } else {
                                if (hashMap4.get("exp") == null) {
                                    longValue = -1;
                                } else {
                                    longValue = ((Long) hashMap4.get("exp")).longValue();
                                }
                                if (hashMap4.get("level") == null) {
                                    intValue = -1;
                                } else {
                                    intValue = ((Integer) hashMap4.get("level")).intValue();
                                }
                                kh9.f(tbPageContext.getPageActivity(), longValue, intValue);
                            }
                            return 0;
                        } else if (strArr[0].startsWith(YYRouterDispatcher.PREFIX)) {
                            kh9.c(tbPageContext.getPageActivity(), strArr[0]);
                            return 0;
                        } else if (strArr[0].startsWith("com.baidu.tieba://unidispatch/BDPLiveChannel")) {
                            AlaTabFeedActivityConfig alaTabFeedActivityConfig = new AlaTabFeedActivityConfig(tbPageContext.getPageActivity());
                            alaTabFeedActivityConfig.setPageSource(aa5.d(strArr[0]));
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, alaTabFeedActivityConfig));
                            return 0;
                        } else if (strArr[0].startsWith(YYLiveRoomDispatcher.PREFIX)) {
                            kj9.j().G(tbPageContext.getPageActivity(), strArr[0]);
                            return 0;
                        } else if (strArr[0].startsWith(YYFeedbackDispatcher.PREFIX)) {
                            kj9.j().F(tbPageContext.getPageActivity(), strArr[0]);
                            return 0;
                        } else if (strArr[0].startsWith(YYCustomerServiceDispatcher.PREFIX)) {
                            kj9.j().E(tbPageContext.getPageActivity(), strArr[0]);
                            return 0;
                        }
                    }
                }
                return 3;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof ShareEvent)) {
                long j = JavaTypesHelper.toLong(((ShareEvent) customResponsedMessage.getData()).extLiveInfo, 0L);
                if (j > 0) {
                    kh9.q(j);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || !(customResponsedMessage instanceof UpdateAttentionMessage)) {
                return;
            }
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage.getData() == null || StringUtils.isNull(updateAttentionMessage.getData().toUid) || !updateAttentionMessage.getData().isSucc || updateAttentionMessage.getData().isFromLive) {
                return;
            }
            AlaLiveSdkStatic.n();
            kh9.p(updateAttentionMessage.getData().toUid, updateAttentionMessage.getData().isAttention);
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        public e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            AlaLiveSdkStatic.q(this.a);
        }
    }

    /* loaded from: classes7.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MessageManager.getInstance().registerListener(AlaLiveSdkStatic.d);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements UrlManager.UrlDealListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            InterceptResult invokeLL;
            Map<String, String> paramPair;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, tbPageContext, strArr)) == null) {
                if (strArr == null || strArr[0] == null) {
                    return 3;
                }
                String lowerCase = strArr[0].toLowerCase();
                if (!lowerCase.startsWith("http://tieba.baidu.com/ala/share?") && !lowerCase.startsWith("https://tieba.baidu.com/ala/share?") && !lowerCase.startsWith("http://tieba.baidu.com/ala/share/live") && !lowerCase.startsWith("https://tieba.baidu.com/ala/share/live")) {
                    return 3;
                }
                String paramStr = UrlManager.getParamStr(lowerCase);
                if (!StringUtils.isNull(paramStr) && (paramPair = UrlManager.getParamPair(paramStr)) != null) {
                    AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                    alaLiveInfoCoreData.liveID = JavaTypesHelper.toLong(paramPair.get("liveid"), 0L);
                    String str = paramPair.get("uname");
                    alaLiveInfoCoreData.userName = str;
                    if (alaLiveInfoCoreData.liveID != 0 || !TextUtils.isEmpty(str)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, null, null, false, null)));
                        return 1;
                    }
                    return 1;
                }
                return 1;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public class h implements UrlManager.UrlDealListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, tbPageContext, strArr)) == null) {
                if (strArr != null && strArr[0] != null && strArr[0].startsWith("tbnps://") && strArr[0].contains("pre_download")) {
                    try {
                        Uri parse = Uri.parse(strArr[0]);
                        if (parse != null) {
                            gg.j(parse.getQueryParameter("package_name"));
                        }
                        return 0;
                    } catch (Exception unused) {
                        if (BdBaseApplication.getInst().isDebugMode()) {
                            BdLog.e("Plug-in predownload schema parse exception");
                        }
                    }
                }
                return 3;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public class j implements UrlManager.UrlDealListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public j() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            InterceptResult invokeLL;
            Map<String, String> paramPair;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, tbPageContext, strArr)) == null) {
                if (tbPageContext != null && strArr != null && strArr.length != 0) {
                    String str = strArr[0];
                    if (StringUtils.isNull(str)) {
                        return 3;
                    }
                    if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_TB_CLIENT)) {
                        if (tbPageContext != null && (paramPair = UrlManager.getParamPair(UrlManager.getParamStrBehindScheme(str))) != null) {
                            String str2 = paramPair.get("liveid");
                            String str3 = paramPair.get("uname");
                            String str4 = paramPair.get("rtmpurl");
                            if (StringUtils.isNull(str2) && StringUtils.isNull(str3)) {
                                return 3;
                            }
                            try {
                                if (!StringUtils.isNull(str3)) {
                                    str3 = URLDecoder.decode(str3, "UTF-8");
                                }
                                if (StringUtils.isNull(str4)) {
                                    str4 = "";
                                }
                                AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                                alaLiveInfoCoreData.liveID = JavaTypesHelper.toLong(str2, 0L);
                                alaLiveInfoCoreData.userName = str3;
                                alaLiveInfoCoreData.rtmpUrl = str4;
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_OUTSIDE, null, false, null)));
                            } catch (UnsupportedEncodingException e) {
                                e.printStackTrace();
                            }
                            return 0;
                        }
                    } else if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_JUMP_LIVE_ROOM)) {
                        long j = JavaTypesHelper.toLong(WebviewHelper.getMatchStringFromURL(str, "liveId="), 0L);
                        if (j == 0) {
                            return 3;
                        }
                        AlaLiveInfoCoreData alaLiveInfoCoreData2 = new AlaLiveInfoCoreData();
                        alaLiveInfoCoreData2.liveID = j;
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData2, AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_ACTIVE_VIEW, "", false, "")));
                        return 1;
                    }
                }
                return 3;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public class k implements CustomMessageTask.CustomRunnable<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public k() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                return new CustomResponsedMessage<>(2921431);
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class l extends CustomRule {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.controller.MessageRule
        public CustomMessage<?> process(CustomMessage<?> customMessage, CustomMessageTask customMessageTask) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, customMessage, customMessageTask)) == null) {
                if (customMessage != null && (customMessage.getData() instanceof AlaLiveRoomActivityConfig)) {
                    AlaLiveSdkStatic.n();
                    AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = (AlaLiveRoomActivityConfig) customMessage.getData();
                    Intent intent = alaLiveRoomActivityConfig.getIntent();
                    kh9.k(alaLiveRoomActivityConfig.getContext(), intent.getStringExtra(AlaLiveRoomActivityConfig.LIVE_FROM_TYPE), (AlaLiveInfoCoreData) intent.getSerializableExtra("live_info_core"));
                    return null;
                } else if (customMessage != null && (customMessage.getData() instanceof AlaMasterLiveRoomActivityConfig) && (((AlaMasterLiveRoomActivityConfig) customMessage.getData()).getContext() instanceof Activity)) {
                    AlaLiveSdkStatic.n();
                    kh9.i((Activity) ((AlaMasterLiveRoomActivityConfig) customMessage.getData()).getContext(), new HashMap());
                    return null;
                } else if (customMessage != null && (customMessage.getData() instanceof BjhMasterActivityConfig)) {
                    AlaLiveSdkStatic.n();
                    BjhMasterActivityConfig bjhMasterActivityConfig = (BjhMasterActivityConfig) customMessage.getData();
                    kh9.r((Application) bjhMasterActivityConfig.getContext(), bjhMasterActivityConfig.getTiebaExtra(), null);
                    return null;
                } else if (customMessage != null && (customMessage.getData() instanceof AlaAdminListActivityConfig)) {
                    AlaLiveSdkStatic.n();
                    kh9.e(((AlaAdminListActivityConfig) customMessage.getData()).getContext());
                    return null;
                } else if (customMessage != null && (customMessage.getData() instanceof AlaFansFamilyActivityConfig)) {
                    AlaLiveSdkStatic.n();
                    AlaFansFamilyActivityConfig alaFansFamilyActivityConfig = (AlaFansFamilyActivityConfig) customMessage.getData();
                    kh9.g(alaFansFamilyActivityConfig.getContext(), alaFansFamilyActivityConfig.getIntent().getStringExtra("author_live_user_id"), -1);
                    return null;
                } else if (customMessage != null && (customMessage.getData() instanceof AlaForbiddenListActivityConfig)) {
                    AlaLiveSdkStatic.n();
                    kh9.h(((AlaForbiddenListActivityConfig) customMessage.getData()).getContext());
                    return null;
                } else if (customMessage != null && (customMessage.getData() instanceof AlaLoveFamilyActivityConfig)) {
                    AlaLiveSdkStatic.n();
                    kh9.l(((AlaLoveFamilyActivityConfig) customMessage.getData()).getContext());
                    return null;
                } else if (customMessage != null && (customMessage.getData() instanceof AlaPersonCenterExpActivityConfig)) {
                    AlaLiveSdkStatic.n();
                    AlaPersonCenterExpActivityConfig alaPersonCenterExpActivityConfig = (AlaPersonCenterExpActivityConfig) customMessage.getData();
                    Intent intent2 = alaPersonCenterExpActivityConfig.getIntent();
                    kh9.f(alaPersonCenterExpActivityConfig.getContext(), intent2.getLongExtra(AlaPersonCenterExpActivityConfig.CURRENT_EXP, 0L), intent2.getIntExtra("current_level", 0));
                    return null;
                } else if (customMessage != null && (customMessage.getData() instanceof AlaPersonCenterRealAuthenConfig)) {
                    AlaLiveSdkStatic.n();
                    AlaPersonCenterRealAuthenConfig alaPersonCenterRealAuthenConfig = (AlaPersonCenterRealAuthenConfig) customMessage.getData();
                    Intent intent3 = alaPersonCenterRealAuthenConfig.getIntent();
                    kh9.n(alaPersonCenterRealAuthenConfig.getContext(), intent3.getStringExtra(AlaPersonCenterRealAuthenConfig.REAL_AUTHEN_USER_ID), intent3.getStringExtra(AlaPersonCenterRealAuthenConfig.REAL_AUTHEN_CERTIFY_STATUS));
                    return null;
                } else {
                    return customMessage;
                }
            }
            return (CustomMessage) invokeLL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class m extends nu5<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        public m(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nu5
        /* renamed from: a */
        public JSONObject doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                NetWork netWork = new NetWork(TbConfig.SERVER_GAME_PLAY_ADRESS + this.a);
                netWork.addPostData("room_id", this.b);
                netWork.setNeedBdussForGet(true);
                String netString = netWork.getNetString();
                if (netWork.getNetContext().getResponse().isRequestSuccess()) {
                    try {
                        JSONObject jSONObject = new JSONObject(netString);
                        PeiwanLog.getInstance().i(this.a, jSONObject.optString("logid"));
                        return jSONObject.optJSONObject("data");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                return new JSONObject();
            }
            return (JSONObject) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class n implements st5<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w a;

        public n(w wVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.st5
        /* renamed from: a */
        public void onReturnDataInUI(JSONObject jSONObject) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                String str = "0";
                boolean z = false;
                if (jSONObject != null) {
                    i = jSONObject.optInt("room_status", 0);
                    str = jSONObject.optString("room_id", "0");
                } else {
                    i = 0;
                }
                w wVar = this.a;
                if (i == 0) {
                    z = true;
                }
                wVar.a(Boolean.valueOf(z), str);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            IYYCloudSwitchCallback iYYCloudSwitchCallback;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                if (customResponsedMessage.getData() instanceof IYYCloudSwitchCallback) {
                    iYYCloudSwitchCallback = (IYYCloudSwitchCallback) customResponsedMessage.getData();
                } else {
                    iYYCloudSwitchCallback = null;
                }
                kj9.j().l(iYYCloudSwitchCallback);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class p extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                kj9.j().e(TbadkCoreApplication.getInst().getContext());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class q implements CustomMessageTask.CustomRunnable<IYYCloudSwitchCallback> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public q() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<IYYCloudSwitchCallback> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                return new CustomResponsedMessage<>(2921548, Long.valueOf(kj9.j().k(TbadkCoreApplication.getInst().getContext())));
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class r extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                g98.i().e(TbadkCoreApplication.getInst().getContext());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class s implements CustomMessageTask.CustomRunnable<IYYCloudSwitchCallback> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public s() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<IYYCloudSwitchCallback> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                return new CustomResponsedMessage<>(2921808, Long.valueOf(g98.i().j(TbadkCoreApplication.getInst().getContext())));
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class t implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public t() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            AlaLiveSdkStatic.w();
            AlaLiveSdkStatic.G();
            AlaLiveSdkStatic.y();
        }
    }

    /* loaded from: classes7.dex */
    public class u implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public u() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MessageManager.getInstance().registerListener(AlaLiveSdkStatic.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class v implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public v() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MessageManager.getInstance().registerListener(AlaLiveSdkStatic.b);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(785806598, "Lcom/baidu/tieba/livesdk/AlaLiveSdkStatic;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(785806598, "Lcom/baidu/tieba/livesdk/AlaLiveSdkStatic;");
                return;
            }
        }
        v();
        s();
        u();
        D();
        z();
        cn8.b(AlaCmdConfigSocket.ALA_SOCKET_PUSH_ALERT, ALAPushAlertResponsedMessage.class, false);
        TbadkCoreApplication.getInst().RegisterIntent(AlaSDKShareEmptyActivityConfig.class, AlaSDKShareEmptyActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(AlaWriteShareInBarActivityConfig.class, AlaShareInBarEmptyActivity.class);
        A();
        x();
        E();
        F();
        B();
        C();
        b = new b(2921406);
        c = new c(2001115);
        d = new d(2007002);
    }

    public AlaLiveSdkStatic() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            SafeHandler.getInst().post(new f());
        }
    }

    public static void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            SafeHandler.getInst().post(new a());
        }
    }

    public static void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            UrlManager.getInstance().addListener(new h());
        }
    }

    public static void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            MessageManager.getInstance().addMessageRule(new l(2002001));
        }
    }

    public static void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            SafeHandler.getInst().post(new v());
        }
    }

    public static void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            SafeHandler.getInst().post(new t());
        }
    }

    public static void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, null) == null) {
            try {
                if (!a) {
                    new ph9().b("0");
                    a = true;
                }
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    public static void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65563, null) == null) {
            UrlManager.getInstance().addListener(new j());
        }
    }

    public static void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65565, null) == null) {
            UrlManager.getInstance().addListener(new i());
        }
    }

    public static void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65566, null) == null) {
            UrlManager.getInstance().addListener(new g());
        }
    }

    public static void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65567, null) == null) {
            MessageManager.getInstance().registerListener(new o(2921545));
        }
    }

    public static void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65568, null) == null) {
            SafeHandler.getInst().post(new u());
        }
    }

    public static void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65570, null) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2921431, new k());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public static void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            MessageManager.getInstance().registerListener(new p(2921549));
            CustomMessageTask customMessageTask = new CustomMessageTask(2921548, new q());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public static void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65569, null) == null) {
            MessageManager.getInstance().registerListener(new r(2921807));
            CustomMessageTask customMessageTask = new CustomMessageTask(2921808, new s());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public static void o(String str, w wVar) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65559, null, str, wVar) == null) {
            if (TextUtils.isDigitsOnly(str)) {
                str2 = TbConfig.API_PRIVATE_ROOM_INFO;
            } else {
                str2 = TbConfig.API_PRIVATE_ROOM_SHARE;
            }
            ru5.b(new m(str2, str), new n(wVar));
        }
    }

    public static String m(HashMap<String, Object> hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, hashMap)) == null) {
            if (hashMap != null && !hashMap.isEmpty()) {
                JSONObject jSONObject = new JSONObject();
                for (String str : hashMap.keySet()) {
                    try {
                        Object obj = hashMap.get(str);
                        if (TextUtils.equals(str, "params")) {
                            try {
                                JSONObject jSONObject2 = new JSONObject(obj.toString());
                                Iterator<String> keys = jSONObject2.keys();
                                while (keys.hasNext()) {
                                    String next = keys.next();
                                    Object opt = jSONObject2.opt(next);
                                    if (opt != null) {
                                        jSONObject.put(next, opt);
                                    }
                                }
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                        } else {
                            jSONObject.put(str, obj);
                        }
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                    }
                }
                return jSONObject.toString();
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static void p(TbPageContext tbPageContext, int i2, String str, JSONObject jSONObject, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65560, null, new Object[]{tbPageContext, Integer.valueOf(i2), str, jSONObject, str2}) == null) {
            try {
                if (TextUtils.isEmpty(str2)) {
                    str2 = WebChromeClient.KEY_ARG_CALLBACK;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("status", i2);
                jSONObject2.put("message", str);
                if (jSONObject != null) {
                    jSONObject2.put("data", jSONObject);
                }
                CustomMessage customMessage = new CustomMessage(2921434);
                customMessage.setTag(tbPageContext.getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921434, "javascript:" + str2 + "('" + jSONObject2.toString() + "');");
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void q(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65561, null, str) == null) && !StringUtils.isNull(str) && str.startsWith("#bdtiebalive://") && str.endsWith("#")) {
            String replace = str.replace("#", "");
            if (!AlaLiveRoomActivityConfig.isAlreadyEnterLiveRoom) {
                UrlManager.getInstance().dealOneLink((TbPageContext) a5.a(TbadkCoreApplication.getInst().getCurrentActivity()), new String[]{replace});
            }
            UtilHelper.clearClipBoard();
        }
    }

    public static String r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, str)) == null) {
            try {
                Uri parse = Uri.parse(str);
                String host = parse.getHost();
                String path = parse.getPath();
                if (!TextUtils.isEmpty(path) && path.endsWith("/")) {
                    path = path.substring(0, path.length() - 1);
                }
                return host + path;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static void t(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65564, null, str) == null) && !StringUtils.isNull(str) && str.startsWith("#bdtiebalive://") && str.endsWith("#")) {
            n();
            SafeHandler.getInst().postDelayed(new e(str), 1000L);
        }
    }
}

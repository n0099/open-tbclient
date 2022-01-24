package com.baidu.tieba.livesdk;

import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import c.a.s0.d1.v0;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.AlaMasterLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.AlaWriteShareInBarActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.BjhMasterActivityConfig;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.mutiprocess.share.ShareEvent;
import com.baidu.tieba.livesdk.share.AlaSDKShareEmptyActivity;
import com.baidu.tieba.livesdk.share.AlaShareInBarEmptyActivity;
import com.baidu.tieba.play.cyberPlayer.CyberRemotePlayerService;
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
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public class AlaLiveSdkStatic {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static CustomMessageListener f45723b;

    /* renamed from: c  reason: collision with root package name */
    public static CustomMessageListener f45724c;

    /* renamed from: d  reason: collision with root package name */
    public static CustomMessageListener f45725d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes12.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.baidu.tieba.livesdk.AlaLiveSdkStatic$a$a  reason: collision with other inner class name */
        /* loaded from: classes12.dex */
        public class C1932a extends CustomMessageListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C1932a(a aVar, int i2) {
                super(i2);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MessageManager.getInstance().registerListener(new C1932a(this, 2921569));
            }
        }
    }

    /* loaded from: classes12.dex */
    public static class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes12.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: com.baidu.tieba.livesdk.AlaLiveSdkStatic$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes12.dex */
            public class RunnableC1933a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                public RunnableC1933a(a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        AlaLiveSdkStatic.n();
                    }
                }
            }

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    String clipBoardContent = UtilHelper.getClipBoardContent();
                    if (!StringUtils.isNull(clipBoardContent) && clipBoardContent.startsWith("#bdtiebalive://") && clipBoardContent.endsWith("#")) {
                        AlaLiveSdkStatic.l();
                        c.a.d.f.m.e.a().postDelayed(new RunnableC1933a(this), 1000L);
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
                c.a.d.f.m.e.a().postDelayed(new a(this), 100L);
            }
        }
    }

    /* loaded from: classes12.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MessageManager.getInstance().registerListener(AlaLiveSdkStatic.f45725d);
            }
        }
    }

    /* loaded from: classes12.dex */
    public static class d implements UrlManager.UrlDealListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                if (lowerCase.startsWith("http://tieba.baidu.com/ala/share?") || lowerCase.startsWith("https://tieba.baidu.com/ala/share?") || lowerCase.startsWith("http://tieba.baidu.com/ala/share/live") || lowerCase.startsWith("https://tieba.baidu.com/ala/share/live")) {
                    String paramStr = UrlManager.getParamStr(lowerCase);
                    if (StringUtils.isNull(paramStr) || (paramPair = UrlManager.getParamPair(paramStr)) == null) {
                        return 1;
                    }
                    AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                    alaLiveInfoCoreData.liveID = c.a.d.f.m.b.g(paramPair.get("liveid"), 0L);
                    String str = paramPair.get("uname");
                    alaLiveInfoCoreData.userName = str;
                    if (alaLiveInfoCoreData.liveID == 0 && TextUtils.isEmpty(str)) {
                        return 1;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, null, null, false, null)));
                    return 1;
                }
                return 3;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes12.dex */
    public static class e implements UrlManager.UrlDealListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                            c.a.d.h.c.j(parse.getQueryParameter("package_name"));
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

    /* loaded from: classes12.dex */
    public static class f implements UrlManager.UrlDealListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes12.dex */
        public class a implements CyberPlayerManager.InstallListener2 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
            public void onInstallError(int i2, int i3, String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, str) == null) {
                }
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener2
            public void onInstallInfo(int i2, int i3, Object obj) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, obj) == null) && (obj instanceof String)) {
                    if (i2 == 100) {
                        TbadkCoreApplication.getInst().setLibcyberffmpeg((String) obj);
                    } else if (i2 == 101) {
                        TbadkCoreApplication.getInst().setLibssl((String) obj);
                    } else if (i2 == 102) {
                        TbadkCoreApplication.getInst().setLibcrypto((String) obj);
                    }
                }
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
            public void onInstallProgress(int i2, int i3) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
                }
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
            public void onInstallSuccess(int i2, String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(1048579, this, i2, str) == null) {
                    TbadkCoreApplication.getInst().setLibcyberVersion(str);
                }
            }
        }

        /* loaded from: classes12.dex */
        public class b implements c.a.t0.b2.k.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ TbPageContext a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f45726b;

            public b(f fVar, TbPageContext tbPageContext, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar, tbPageContext, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = tbPageContext;
                this.f45726b = str;
            }

            @Override // c.a.t0.b2.k.a
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
                        AlaLiveSdkStatic.m(this.a, optInt, optString, jSONObject2, this.f45726b);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }

        public f() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                if (tbPageContext != null && strArr != null && strArr[0] != null) {
                    if (!CyberPlayerManager.isCoreLoaded(1)) {
                        try {
                            CyberPlayerManager.install(TbadkCoreApplication.getInst().getContext(), TbadkCoreApplication.getInst().getCuidGalaxy2(), (String) null, 3, (Class<?>) CyberRemotePlayerService.class, (Map<String, String>) null, (CyberPlayerManager.InstallListener2) new a(this));
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                    if (!strArr[0].startsWith(UrlSchemaHelper.SCHEMA_LIVE_SDK) && !strArr[0].contains(UrlSchemaHelper.GO_TO_MIX_LIVE)) {
                        return 3;
                    }
                    AlaLiveSdkStatic.l();
                    if (strArr[0].contains(UrlSchemaHelper.GO_TO_MIX_LIVE)) {
                        String d2 = v0.d(strArr[0], "url");
                        if ("video/mixlive".equals(AlaLiveSdkStatic.o(d2))) {
                            Uri parse = Uri.parse(d2);
                            HashMap hashMap = new HashMap();
                            for (String str : parse.getQueryParameterNames()) {
                                hashMap.put(str, parse.getQueryParameter(str));
                            }
                            c.a.t0.f2.a.j().w(tbPageContext.getPageActivity(), (String) hashMap.get("room_id"), (String) hashMap.get("source"), AlaLiveSdkStatic.k(hashMap), parse);
                            return 0;
                        }
                    }
                    if (strArr[0].startsWith("bdtiebalive://video/mixlive") && "video/mixlive".equals(AlaLiveSdkStatic.o(strArr[0]))) {
                        Uri parse2 = Uri.parse(strArr[0]);
                        HashMap hashMap2 = new HashMap();
                        for (String str2 : parse2.getQueryParameterNames()) {
                            hashMap2.put(str2, parse2.getQueryParameter(str2));
                        }
                        c.a.t0.f2.a.j().w(tbPageContext.getPageActivity(), (String) hashMap2.get("room_id"), (String) hashMap2.get("source"), AlaLiveSdkStatic.k(hashMap2), parse2);
                        return 0;
                    } else if (strArr[0].startsWith("bdtiebalive://video/createRoom") && "video/createRoom".equals(AlaLiveSdkStatic.o(strArr[0]))) {
                        Uri parse3 = Uri.parse(strArr[0]);
                        HashMap hashMap3 = new HashMap();
                        for (String str3 : parse3.getQueryParameterNames()) {
                            hashMap3.put(str3, String.valueOf(parse3.getQueryParameter(str3)));
                        }
                        BjhMasterActivityConfig bjhMasterActivityConfig = new BjhMasterActivityConfig(tbPageContext.getPageActivity().getApplication(), (String) hashMap3.get("fid"), (String) hashMap3.get("forumName"));
                        c.a.t0.b2.a.r((Application) bjhMasterActivityConfig.getContext(), bjhMasterActivityConfig.getStartJsonParams(), null);
                        return 0;
                    } else if (strArr[0].startsWith("bdtiebalive://deeplink")) {
                        if ("deeplink".equals(AlaLiveSdkStatic.o(strArr[0]))) {
                            c.a.t0.i0.e eVar = new c.a.t0.i0.e(strArr[0]);
                            c.a.t0.i0.b.a(tbPageContext.getPageActivity(), eVar.d(), eVar.a(), false);
                        }
                        return 0;
                    } else {
                        if (strArr[0].startsWith("bdtiebalive://webview") && AlbumActivityConfig.FROM_WEB_VIEW.equals(AlaLiveSdkStatic.o(strArr[0]))) {
                            String b2 = new c.a.t0.i0.e(strArr[0]).b("url_key");
                            if (!TextUtils.isEmpty(b2)) {
                                UrlManager.getInstance().dealOneLink((TbPageContext) c.a.d.a.j.a(tbPageContext.getPageActivity()), new String[]{b2});
                                return 0;
                            }
                        }
                        if (strArr[0].startsWith("bdtiebalive://video/live")) {
                            Uri parse4 = Uri.parse(strArr[0]);
                            HashMap hashMap4 = new HashMap();
                            for (String str4 : parse4.getQueryParameterNames()) {
                                hashMap4.put(str4, parse4.getQueryParameter(str4));
                            }
                            if (strArr[0].startsWith("bdtiebalive:video/live/tbean")) {
                                String str5 = (String) hashMap4.get(WebChromeClient.KEY_ARG_CALLBACK);
                                c.a.t0.b2.n.a aVar = new c.a.t0.b2.n.a();
                                aVar.a = str5;
                                aVar.f15395c = (String) hashMap4.get("is_translucent");
                                aVar.f15394b = TextUtils.equals((String) hashMap4.get("is_translucent"), "1");
                                c.a.t0.b2.a.e(tbPageContext.getPageActivity(), aVar, new b(this, tbPageContext, str5));
                            } else if (strArr[0].startsWith("bdtiebalive://video/live/start")) {
                                c.a.t0.b2.a.b(tbPageContext.getPageActivity(), strArr[0], hashMap4);
                            } else if (strArr[0].startsWith("bdtiebalive://video/live/admin")) {
                                c.a.t0.b2.a.f(tbPageContext.getPageActivity());
                            } else if (strArr[0].startsWith("bdtiebalive://video/live/forbidden")) {
                                c.a.t0.b2.a.i(tbPageContext.getPageActivity());
                            } else if (!strArr[0].startsWith("bdtiebalive://video/live/exp") && !strArr[0].startsWith("bdtiebalive://video/live/experience")) {
                                if (strArr[0].startsWith("bdtiebalive://video/live/guardian")) {
                                    c.a.t0.b2.a.j(tbPageContext.getPageActivity(), (String) hashMap4.get("value"), (String) hashMap4.get("uid"));
                                } else if (strArr[0].startsWith("bdtiebalive://video/live/fans")) {
                                    c.a.t0.b2.a.h(tbPageContext.getPageActivity(), null, 0);
                                } else if (strArr[0].startsWith("bdtiebalive://video/live/patrons")) {
                                    c.a.t0.b2.a.m(tbPageContext.getPageActivity(), (String) hashMap4.get("userId"));
                                } else if (strArr[0].startsWith("bdtiebalive://video/live/patronage")) {
                                    c.a.t0.b2.a.l(tbPageContext.getPageActivity());
                                } else if (strArr[0].startsWith("bdtiebalive://video/live/realAuthen")) {
                                    c.a.t0.b2.a.n(tbPageContext.getPageActivity(), (String) hashMap4.get("userId"), (String) hashMap4.get("certifyStatus"));
                                } else {
                                    c.a.t0.b2.a.c(tbPageContext.getPageActivity(), strArr[0], hashMap4);
                                }
                            } else {
                                c.a.t0.b2.a.g(tbPageContext.getPageActivity(), hashMap4.get("exp") == null ? -1L : ((Long) hashMap4.get("exp")).longValue(), hashMap4.get("level") == null ? -1 : ((Integer) hashMap4.get("level")).intValue());
                            }
                            return 0;
                        } else if (strArr[0].startsWith("bdtiebalive://video/yylive/router")) {
                            c.a.t0.b2.a.d(tbPageContext.getPageActivity(), strArr[0]);
                            return 0;
                        } else if (strArr[0].startsWith("bdtiebalive://video/yylive/joinlive")) {
                            c.a.t0.f2.a.j().G(tbPageContext.getPageActivity(), strArr[0]);
                            return 0;
                        } else if (strArr[0].startsWith("bdtiebalive://video/yylive/feedback")) {
                            c.a.t0.f2.a.j().F(tbPageContext.getPageActivity(), strArr[0]);
                            return 0;
                        } else if (strArr[0].startsWith("bdtiebalive://video/yylive/customerservice")) {
                            c.a.t0.f2.a.j().E(tbPageContext.getPageActivity(), strArr[0]);
                            return 0;
                        }
                    }
                }
                return 3;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes12.dex */
    public static class g implements UrlManager.UrlDealListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                                alaLiveInfoCoreData.liveID = c.a.d.f.m.b.g(str2, 0L);
                                alaLiveInfoCoreData.userName = str3;
                                alaLiveInfoCoreData.rtmpUrl = str4;
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_OUTSIDE, null, false, null)));
                            } catch (UnsupportedEncodingException e2) {
                                e2.printStackTrace();
                            }
                            return 0;
                        }
                    } else if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_JUMP_LIVE_ROOM)) {
                        long g2 = c.a.d.f.m.b.g(v0.c(str, "liveId="), 0L);
                        if (g2 == 0) {
                            return 3;
                        }
                        AlaLiveInfoCoreData alaLiveInfoCoreData2 = new AlaLiveInfoCoreData();
                        alaLiveInfoCoreData2.liveID = g2;
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData2, AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_ACTIVE_VIEW, "", false, "")));
                        return 1;
                    }
                }
                return 3;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes12.dex */
    public static class h implements CustomMessageTask.CustomRunnable<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) ? new CustomResponsedMessage<>(2921431) : (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes12.dex */
    public static class i extends c.a.d.c.f.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.c.f.f
        public CustomMessage<?> process(CustomMessage<?> customMessage, CustomMessageTask customMessageTask) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, customMessage, customMessageTask)) == null) {
                if (customMessage != null && (customMessage.getData() instanceof AlaLiveRoomActivityConfig)) {
                    AlaLiveSdkStatic.l();
                    AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = (AlaLiveRoomActivityConfig) customMessage.getData();
                    Intent intent = alaLiveRoomActivityConfig.getIntent();
                    c.a.t0.b2.a.k(alaLiveRoomActivityConfig.getContext(), intent.getStringExtra(AlaLiveRoomActivityConfig.LIVE_FROM_TYPE), (AlaLiveInfoCoreData) intent.getSerializableExtra("live_info_core"));
                    return null;
                } else if (customMessage != null && (customMessage.getData() instanceof AlaMasterLiveRoomActivityConfig)) {
                    AlaLiveSdkStatic.l();
                    c.a.t0.b2.a.a(((AlaMasterLiveRoomActivityConfig) customMessage.getData()).getContext());
                    return null;
                } else if (customMessage != null && (customMessage.getData() instanceof BjhMasterActivityConfig)) {
                    AlaLiveSdkStatic.l();
                    BjhMasterActivityConfig bjhMasterActivityConfig = (BjhMasterActivityConfig) customMessage.getData();
                    c.a.t0.b2.a.r((Application) bjhMasterActivityConfig.getContext(), bjhMasterActivityConfig.getStartJsonParams(), null);
                    return null;
                } else if (customMessage != null && (customMessage.getData() instanceof AlaAdminListActivityConfig)) {
                    AlaLiveSdkStatic.l();
                    c.a.t0.b2.a.f(((AlaAdminListActivityConfig) customMessage.getData()).getContext());
                    return null;
                } else if (customMessage != null && (customMessage.getData() instanceof AlaFansFamilyActivityConfig)) {
                    AlaLiveSdkStatic.l();
                    AlaFansFamilyActivityConfig alaFansFamilyActivityConfig = (AlaFansFamilyActivityConfig) customMessage.getData();
                    c.a.t0.b2.a.h(alaFansFamilyActivityConfig.getContext(), alaFansFamilyActivityConfig.getIntent().getStringExtra("author_live_user_id"), -1);
                    return null;
                } else if (customMessage != null && (customMessage.getData() instanceof AlaForbiddenListActivityConfig)) {
                    AlaLiveSdkStatic.l();
                    c.a.t0.b2.a.i(((AlaForbiddenListActivityConfig) customMessage.getData()).getContext());
                    return null;
                } else if (customMessage != null && (customMessage.getData() instanceof AlaLoveFamilyActivityConfig)) {
                    AlaLiveSdkStatic.l();
                    c.a.t0.b2.a.l(((AlaLoveFamilyActivityConfig) customMessage.getData()).getContext());
                    return null;
                } else if (customMessage != null && (customMessage.getData() instanceof AlaPersonCenterExpActivityConfig)) {
                    AlaLiveSdkStatic.l();
                    AlaPersonCenterExpActivityConfig alaPersonCenterExpActivityConfig = (AlaPersonCenterExpActivityConfig) customMessage.getData();
                    Intent intent2 = alaPersonCenterExpActivityConfig.getIntent();
                    c.a.t0.b2.a.g(alaPersonCenterExpActivityConfig.getContext(), intent2.getLongExtra(AlaPersonCenterExpActivityConfig.CURRENT_EXP, 0L), intent2.getIntExtra("current_level", 0));
                    return null;
                } else if (customMessage == null || !(customMessage.getData() instanceof AlaPersonCenterRealAuthenConfig)) {
                    return customMessage;
                } else {
                    AlaLiveSdkStatic.l();
                    AlaPersonCenterRealAuthenConfig alaPersonCenterRealAuthenConfig = (AlaPersonCenterRealAuthenConfig) customMessage.getData();
                    Intent intent3 = alaPersonCenterRealAuthenConfig.getIntent();
                    c.a.t0.b2.a.n(alaPersonCenterRealAuthenConfig.getContext(), intent3.getStringExtra(AlaPersonCenterRealAuthenConfig.REAL_AUTHEN_USER_ID), intent3.getStringExtra(AlaPersonCenterRealAuthenConfig.REAL_AUTHEN_CERTIFY_STATUS));
                    return null;
                }
            }
            return (CustomMessage) invokeLL.objValue;
        }
    }

    /* loaded from: classes12.dex */
    public static class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
                c.a.t0.f2.a.j().l(customResponsedMessage.getData() instanceof c.a.s0.e.f ? (c.a.s0.e.f) customResponsedMessage.getData() : null);
            }
        }
    }

    /* loaded from: classes12.dex */
    public static class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
                c.a.t0.f2.a.j().e(TbadkCoreApplication.getInst().getContext());
            }
        }
    }

    /* loaded from: classes12.dex */
    public static class l implements CustomMessageTask.CustomRunnable<c.a.s0.e.f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public l() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<c.a.s0.e.f> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) ? new CustomResponsedMessage<>(2921548, Long.valueOf(c.a.t0.f2.a.j().k(TbadkCoreApplication.getInst().getContext()))) : (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes12.dex */
    public static class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public m() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                AlaLiveSdkStatic.s();
                AlaLiveSdkStatic.B();
            }
        }
    }

    /* loaded from: classes12.dex */
    public static class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public n() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MessageManager.getInstance().registerListener(AlaLiveSdkStatic.f45724c);
            }
        }
    }

    /* loaded from: classes12.dex */
    public static class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public o() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MessageManager.getInstance().registerListener(AlaLiveSdkStatic.f45723b);
            }
        }
    }

    /* loaded from: classes12.dex */
    public static class p extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
                long g2 = c.a.d.f.m.b.g(((ShareEvent) customResponsedMessage.getData()).extLiveInfo, 0L);
                if (g2 > 0) {
                    c.a.t0.b2.a.q(g2);
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public static class q extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() == null || StringUtils.isNull(updateAttentionMessage.getData().f40771c) || !updateAttentionMessage.getData().a || updateAttentionMessage.getData().f40773e) {
                    return;
                }
                AlaLiveSdkStatic.l();
                c.a.t0.b2.a.p(updateAttentionMessage.getData().f40771c, updateAttentionMessage.getData().f40772d);
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
        r();
        p();
        q();
        y();
        u();
        c.a.t0.t1.c.b(AlaCmdConfigSocket.ALA_SOCKET_PUSH_ALERT, ALAPushAlertResponsedMessage.class, false);
        TbadkCoreApplication.getInst().RegisterIntent(AlaSDKShareEmptyActivityConfig.class, AlaSDKShareEmptyActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(AlaWriteShareInBarActivityConfig.class, AlaShareInBarEmptyActivity.class);
        v();
        t();
        z();
        A();
        w();
        x();
        f45723b = new p(2921406);
        f45724c = new q(2001115);
        f45725d = new b(2007002);
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
            c.a.d.f.m.e.a().post(new m());
        }
    }

    public static void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            MessageManager.getInstance().registerListener(new k(2921549));
            CustomMessageTask customMessageTask = new CustomMessageTask(2921548, new l());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public static String k(HashMap<String, Object> hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, hashMap)) == null) {
            if (hashMap == null || hashMap.isEmpty()) {
                return "";
            }
            JSONObject jSONObject = new JSONObject();
            for (String str : hashMap.keySet()) {
                try {
                    jSONObject.put(str, hashMap.get(str));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }

    public static void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, null) == null) {
            try {
                if (a) {
                    return;
                }
                new c.a.t0.b2.j.b().b("0");
                a = true;
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    public static void m(TbPageContext tbPageContext, int i2, String str, JSONObject jSONObject, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65552, null, new Object[]{tbPageContext, Integer.valueOf(i2), str, jSONObject, str2}) == null) {
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

    public static void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, null) == null) {
            String clipBoardContent = UtilHelper.getClipBoardContent();
            if (!StringUtils.isNull(clipBoardContent) && clipBoardContent.startsWith("#bdtiebalive://") && clipBoardContent.endsWith("#")) {
                String replace = clipBoardContent.replace("#", "");
                if (!AlaLiveRoomActivityConfig.isAlreadyEnterLiveRoom) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) c.a.d.a.j.a(TbadkCoreApplication.getInst().getCurrentActivity()), new String[]{replace});
                }
                UtilHelper.clearClipBoard();
            }
        }
    }

    public static String o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, str)) == null) {
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

    public static void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, null) == null) {
            UrlManager.getInstance().addListener(new g());
        }
    }

    public static void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, null) == null) {
            UrlManager.getInstance().addListener(new f());
        }
    }

    public static void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, null) == null) {
            UrlManager.getInstance().addListener(new d());
        }
    }

    public static void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, null) == null) {
            MessageManager.getInstance().registerListener(new j(2921545));
        }
    }

    public static void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65559, null) == null) {
            c.a.d.f.m.e.a().post(new n());
        }
    }

    public static void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, null) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2921431, new h());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public static void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65561, null) == null) {
            c.a.d.f.m.e.a().post(new c());
        }
    }

    public static void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65562, null) == null) {
            c.a.d.f.m.e.a().post(new a());
        }
    }

    public static void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65563, null) == null) {
            UrlManager.getInstance().addListener(new e());
        }
    }

    public static void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65564, null) == null) {
            MessageManager.getInstance().addMessageRule(new i(2002001));
        }
    }

    public static void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65565, null) == null) {
            c.a.d.f.m.e.a().post(new o());
        }
    }
}

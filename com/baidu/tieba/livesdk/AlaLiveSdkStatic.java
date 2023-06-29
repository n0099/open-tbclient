package com.baidu.tieba.livesdk;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
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
import com.baidu.searchbox.schemedispatch.forbid.InvokeStatisticKt;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.AlaMasterLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.AlaTabFeedActivityConfig;
import com.baidu.tbadk.core.atomData.AlaWriteShareInBarActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.BjhMasterActivityConfig;
import com.baidu.tbadk.core.util.NewUrlSchemaHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.mutiprocess.share.ShareEvent;
import com.baidu.tbadk.switchs.AsyncGetClipboardSwitch;
import com.baidu.tieba.ab;
import com.baidu.tieba.b78;
import com.baidu.tieba.ke5;
import com.baidu.tieba.kv8;
import com.baidu.tieba.livesdk.dispatcher.YYCustomerServiceDispatcher;
import com.baidu.tieba.livesdk.dispatcher.YYFeedbackDispatcher;
import com.baidu.tieba.livesdk.dispatcher.YYLiveRoomDispatcher;
import com.baidu.tieba.livesdk.dispatcher.YYRouterDispatcher;
import com.baidu.tieba.livesdk.share.AlaSDKShareEmptyActivity;
import com.baidu.tieba.livesdk.share.AlaShareInBarEmptyActivity;
import com.baidu.tieba.lx8;
import com.baidu.tieba.ly5;
import com.baidu.tieba.nl;
import com.baidu.tieba.play.cyberPlayer.CyberRemotePlayerService;
import com.baidu.tieba.pv8;
import com.baidu.tieba.qv8;
import com.baidu.tieba.r9;
import com.baidu.tieba.sp6;
import com.baidu.tieba.sx5;
import com.baidu.tieba.vg;
import com.baidu.tieba.vt7;
import com.baidu.tieba.vv8;
import com.baidu.tieba.vw4;
import com.baidu.tieba.ww5;
import com.baidu.tieba.wx5;
import com.baidu.tieba.xp6;
import com.baidu.tieba.yg;
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
/* loaded from: classes6.dex */
public class AlaLiveSdkStatic {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public static CustomMessageListener b;
    public static CustomMessageListener c;
    public static CustomMessageListener d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* loaded from: classes6.dex */
            public class b implements ww5<String> {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: com.baidu.tieba.livesdk.AlaLiveSdkStatic$d$a$b$a  reason: collision with other inner class name */
                /* loaded from: classes6.dex */
                public class RunnableC0401a implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ String a;

                    public RunnableC0401a(b bVar, String str) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {bVar, str};
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
                        AlaLiveSdkStatic.n(this.a);
                    }
                }

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
                @Override // com.baidu.tieba.ww5
                /* renamed from: a */
                public void onReturnDataInUI(String str) {
                    Interceptable interceptable = $ic;
                    if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && !StringUtils.isNull(str) && str.startsWith("#bdtiebalive://") && str.endsWith("#")) {
                        AlaLiveSdkStatic.l();
                        yg.a().postDelayed(new RunnableC0401a(this, str), 1000L);
                    }
                }
            }

            /* renamed from: com.baidu.tieba.livesdk.AlaLiveSdkStatic$d$a$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class C0400a extends sx5<String> {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                public C0400a(a aVar) {
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
                @Override // com.baidu.tieba.sx5
                public String doInBackground() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        return UtilHelper.getClipBoardContent();
                    }
                    return (String) invokeV.objValue;
                }
            }

            /* loaded from: classes6.dex */
            public class c implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String a;

                public c(a aVar, String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar, str};
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
                    AlaLiveSdkStatic.n(this.a);
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
                    if (AsyncGetClipboardSwitch.isOn() && TbadkCoreApplication.getInst().isMIUIRom()) {
                        wx5.b(new C0400a(this), new b(this));
                        return;
                    }
                    String clipBoardContent = UtilHelper.getClipBoardContent();
                    if (!StringUtils.isNull(clipBoardContent) && clipBoardContent.startsWith("#bdtiebalive://") && clipBoardContent.endsWith("#")) {
                        AlaLiveSdkStatic.l();
                        yg.a().postDelayed(new c(this, clipBoardContent), 1000L);
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
                yg.a().postDelayed(new a(this), 100L);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.baidu.tieba.livesdk.AlaLiveSdkStatic$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0399a extends CustomMessageListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0399a(a aVar, int i) {
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
                MessageManager.getInstance().registerListener(new C0399a(this, 2921569));
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class h implements UrlManager.UrlDealListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes6.dex */
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

            public a(h hVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar};
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

        /* loaded from: classes6.dex */
        public class b implements qv8 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ TbPageContext a;
            public final /* synthetic */ String b;

            public b(h hVar, TbPageContext tbPageContext, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar, tbPageContext, str};
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

            @Override // com.baidu.tieba.qv8
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
                        AlaLiveSdkStatic.m(this.a, optInt, optString, jSONObject2, this.b);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

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
                    AlaLiveSdkStatic.l();
                    if (strArr[0].contains(UrlSchemaHelper.GO_TO_MIX_LIVE)) {
                        String d = ly5.d(strArr[0], "url");
                        if ("video/mixlive".equals(AlaLiveSdkStatic.o(d))) {
                            Uri parse = Uri.parse(d);
                            HashMap hashMap = new HashMap();
                            for (String str : parse.getQueryParameterNames()) {
                                hashMap.put(str, parse.getQueryParameter(str));
                            }
                            lx8.j().w(tbPageContext.getPageActivity(), (String) hashMap.get("room_id"), (String) hashMap.get("source"), AlaLiveSdkStatic.k(hashMap), parse);
                            return 0;
                        }
                    }
                    if (strArr[0].startsWith("bdtiebalive://video/mixlive") && "video/mixlive".equals(AlaLiveSdkStatic.o(strArr[0]))) {
                        Uri parse2 = Uri.parse(strArr[0]);
                        HashMap hashMap2 = new HashMap();
                        for (String str2 : parse2.getQueryParameterNames()) {
                            hashMap2.put(str2, parse2.getQueryParameter(str2));
                        }
                        lx8.j().w(tbPageContext.getPageActivity(), (String) hashMap2.get("room_id"), (String) hashMap2.get("source"), AlaLiveSdkStatic.k(hashMap2), parse2);
                        return 0;
                    } else if (strArr[0].startsWith("bdtiebalive://video/createRoom") && "video/createRoom".equals(AlaLiveSdkStatic.o(strArr[0]))) {
                        Uri parse3 = Uri.parse(strArr[0]);
                        HashMap hashMap3 = new HashMap();
                        for (String str3 : parse3.getQueryParameterNames()) {
                            hashMap3.put(str3, String.valueOf(parse3.getQueryParameter(str3)));
                        }
                        BjhMasterActivityConfig bjhMasterActivityConfig = new BjhMasterActivityConfig(tbPageContext.getPageActivity().getApplication(), (String) hashMap3.get("fid"), (String) hashMap3.get("forumName"));
                        kv8.r((Application) bjhMasterActivityConfig.getContext(), bjhMasterActivityConfig.getTiebaExtra(), null);
                        return 0;
                    } else if (strArr[0].startsWith("bdtiebalive://deeplink")) {
                        if (InvokeStatisticKt.SCHEME_INVOKE_PAGE_DEEPLINK.equals(AlaLiveSdkStatic.o(strArr[0]))) {
                            xp6 xp6Var = new xp6(strArr[0]);
                            sp6.a(tbPageContext.getPageActivity(), xp6Var.d(), xp6Var.a(), false);
                        }
                        return 0;
                    } else {
                        if (strArr[0].startsWith("bdtiebalive://webview") && AlbumActivityConfig.FROM_WEB_VIEW.equals(AlaLiveSdkStatic.o(strArr[0]))) {
                            String b2 = new xp6(strArr[0]).b("url_key");
                            if (!TextUtils.isEmpty(b2)) {
                                UrlManager.getInstance().dealOneLink((TbPageContext) r9.a(tbPageContext.getPageActivity()), new String[]{b2});
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
                                vv8 vv8Var = new vv8();
                                vv8Var.a = str5;
                                vv8Var.c = (String) hashMap4.get("is_translucent");
                                vv8Var.b = TextUtils.equals((String) hashMap4.get("is_translucent"), "1");
                                kv8.d(tbPageContext.getPageActivity(), vv8Var, new b(this, tbPageContext, str5));
                            } else if (strArr[0].startsWith("bdtiebalive://video/live/start")) {
                                kv8.a(tbPageContext.getPageActivity(), strArr[0], hashMap4);
                            } else if (strArr[0].startsWith("bdtiebalive://video/live/admin")) {
                                kv8.e(tbPageContext.getPageActivity());
                            } else if (strArr[0].startsWith("bdtiebalive://video/live/forbidden")) {
                                kv8.h(tbPageContext.getPageActivity());
                            } else if (!strArr[0].startsWith("bdtiebalive://video/live/exp") && !strArr[0].startsWith("bdtiebalive://video/live/experience")) {
                                if (strArr[0].startsWith("bdtiebalive://video/live/guardian")) {
                                    kv8.j(tbPageContext.getPageActivity(), (String) hashMap4.get("value"), (String) hashMap4.get("uid"));
                                } else if (strArr[0].startsWith("bdtiebalive://video/live/fans")) {
                                    kv8.g(tbPageContext.getPageActivity(), null, 0);
                                } else if (strArr[0].startsWith("bdtiebalive://video/live/patrons")) {
                                    kv8.m(tbPageContext.getPageActivity(), (String) hashMap4.get("userId"));
                                } else if (strArr[0].startsWith("bdtiebalive://video/live/patronage")) {
                                    kv8.l(tbPageContext.getPageActivity());
                                } else if (strArr[0].startsWith("bdtiebalive://video/live/realAuthen")) {
                                    kv8.n(tbPageContext.getPageActivity(), (String) hashMap4.get("userId"), (String) hashMap4.get("certifyStatus"));
                                } else {
                                    kv8.b(tbPageContext.getPageActivity(), strArr[0], hashMap4);
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
                                kv8.f(tbPageContext.getPageActivity(), longValue, intValue);
                            }
                            return 0;
                        } else if (strArr[0].startsWith(YYRouterDispatcher.PREFIX)) {
                            kv8.c(tbPageContext.getPageActivity(), strArr[0]);
                            return 0;
                        } else if (strArr[0].startsWith("com.baidu.tieba://unidispatch/BDPLiveChannel")) {
                            AlaTabFeedActivityConfig alaTabFeedActivityConfig = new AlaTabFeedActivityConfig(tbPageContext.getPageActivity());
                            alaTabFeedActivityConfig.setPageSource(ke5.d(strArr[0]));
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, alaTabFeedActivityConfig));
                            return 0;
                        } else if (strArr[0].startsWith(YYLiveRoomDispatcher.PREFIX)) {
                            lx8.j().G(tbPageContext.getPageActivity(), strArr[0]);
                            return 0;
                        } else if (strArr[0].startsWith(YYFeedbackDispatcher.PREFIX)) {
                            lx8.j().F(tbPageContext.getPageActivity(), strArr[0]);
                            return 0;
                        } else if (strArr[0].startsWith(YYCustomerServiceDispatcher.PREFIX)) {
                            lx8.j().E(tbPageContext.getPageActivity(), strArr[0]);
                            return 0;
                        }
                    }
                }
                return 3;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends CustomMessageListener {
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
                long g = vg.g(((ShareEvent) customResponsedMessage.getData()).extLiveInfo, 0L);
                if (g > 0) {
                    kv8.q(g);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c extends CustomMessageListener {
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
            if (updateAttentionMessage.getData() == null || StringUtils.isNull(updateAttentionMessage.getData().c) || !updateAttentionMessage.getData().a || updateAttentionMessage.getData().e) {
                return;
            }
            AlaLiveSdkStatic.l();
            kv8.p(updateAttentionMessage.getData().c, updateAttentionMessage.getData().d);
        }
    }

    /* loaded from: classes6.dex */
    public static class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e() {
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

    /* loaded from: classes6.dex */
    public static class f implements UrlManager.UrlDealListener {
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
                    alaLiveInfoCoreData.liveID = vg.g(paramPair.get("liveid"), 0L);
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

    /* loaded from: classes6.dex */
    public static class g implements UrlManager.UrlDealListener {
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
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, tbPageContext, strArr)) == null) {
                if (strArr != null && strArr[0] != null && strArr[0].startsWith("tbnps://") && strArr[0].contains("pre_download")) {
                    try {
                        Uri parse = Uri.parse(strArr[0]);
                        if (parse != null) {
                            nl.j(parse.getQueryParameter("package_name"));
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

    /* loaded from: classes6.dex */
    public static class i implements UrlManager.UrlDealListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                                alaLiveInfoCoreData.liveID = vg.g(str2, 0L);
                                alaLiveInfoCoreData.userName = str3;
                                alaLiveInfoCoreData.rtmpUrl = str4;
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_OUTSIDE, null, false, null)));
                            } catch (UnsupportedEncodingException e) {
                                e.printStackTrace();
                            }
                            return 0;
                        }
                    } else if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_JUMP_LIVE_ROOM)) {
                        long g = vg.g(ly5.c(str, "liveId="), 0L);
                        if (g == 0) {
                            return 3;
                        }
                        AlaLiveInfoCoreData alaLiveInfoCoreData2 = new AlaLiveInfoCoreData();
                        alaLiveInfoCoreData2.liveID = g;
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData2, AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_ACTIVE_VIEW, "", false, "")));
                        return 1;
                    }
                }
                return 3;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class j implements CustomMessageTask.CustomRunnable<Object> {
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

    /* loaded from: classes6.dex */
    public static class k extends ab {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(int i) {
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
        @Override // com.baidu.tieba.eb
        public CustomMessage<?> process(CustomMessage<?> customMessage, CustomMessageTask customMessageTask) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, customMessage, customMessageTask)) == null) {
                if (customMessage != null && (customMessage.getData() instanceof AlaLiveRoomActivityConfig)) {
                    AlaLiveSdkStatic.l();
                    AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = (AlaLiveRoomActivityConfig) customMessage.getData();
                    Intent intent = alaLiveRoomActivityConfig.getIntent();
                    kv8.k(alaLiveRoomActivityConfig.getContext(), intent.getStringExtra(AlaLiveRoomActivityConfig.LIVE_FROM_TYPE), (AlaLiveInfoCoreData) intent.getSerializableExtra("live_info_core"));
                    return null;
                } else if (customMessage != null && (customMessage.getData() instanceof AlaMasterLiveRoomActivityConfig) && (((AlaMasterLiveRoomActivityConfig) customMessage.getData()).getContext() instanceof Activity)) {
                    AlaLiveSdkStatic.l();
                    kv8.i((Activity) ((AlaMasterLiveRoomActivityConfig) customMessage.getData()).getContext(), new HashMap());
                    return null;
                } else if (customMessage != null && (customMessage.getData() instanceof BjhMasterActivityConfig)) {
                    AlaLiveSdkStatic.l();
                    BjhMasterActivityConfig bjhMasterActivityConfig = (BjhMasterActivityConfig) customMessage.getData();
                    kv8.r((Application) bjhMasterActivityConfig.getContext(), bjhMasterActivityConfig.getTiebaExtra(), null);
                    return null;
                } else if (customMessage != null && (customMessage.getData() instanceof AlaAdminListActivityConfig)) {
                    AlaLiveSdkStatic.l();
                    kv8.e(((AlaAdminListActivityConfig) customMessage.getData()).getContext());
                    return null;
                } else if (customMessage != null && (customMessage.getData() instanceof AlaFansFamilyActivityConfig)) {
                    AlaLiveSdkStatic.l();
                    AlaFansFamilyActivityConfig alaFansFamilyActivityConfig = (AlaFansFamilyActivityConfig) customMessage.getData();
                    kv8.g(alaFansFamilyActivityConfig.getContext(), alaFansFamilyActivityConfig.getIntent().getStringExtra("author_live_user_id"), -1);
                    return null;
                } else if (customMessage != null && (customMessage.getData() instanceof AlaForbiddenListActivityConfig)) {
                    AlaLiveSdkStatic.l();
                    kv8.h(((AlaForbiddenListActivityConfig) customMessage.getData()).getContext());
                    return null;
                } else if (customMessage != null && (customMessage.getData() instanceof AlaLoveFamilyActivityConfig)) {
                    AlaLiveSdkStatic.l();
                    kv8.l(((AlaLoveFamilyActivityConfig) customMessage.getData()).getContext());
                    return null;
                } else if (customMessage != null && (customMessage.getData() instanceof AlaPersonCenterExpActivityConfig)) {
                    AlaLiveSdkStatic.l();
                    AlaPersonCenterExpActivityConfig alaPersonCenterExpActivityConfig = (AlaPersonCenterExpActivityConfig) customMessage.getData();
                    Intent intent2 = alaPersonCenterExpActivityConfig.getIntent();
                    kv8.f(alaPersonCenterExpActivityConfig.getContext(), intent2.getLongExtra(AlaPersonCenterExpActivityConfig.CURRENT_EXP, 0L), intent2.getIntExtra("current_level", 0));
                    return null;
                } else if (customMessage != null && (customMessage.getData() instanceof AlaPersonCenterRealAuthenConfig)) {
                    AlaLiveSdkStatic.l();
                    AlaPersonCenterRealAuthenConfig alaPersonCenterRealAuthenConfig = (AlaPersonCenterRealAuthenConfig) customMessage.getData();
                    Intent intent3 = alaPersonCenterRealAuthenConfig.getIntent();
                    kv8.n(alaPersonCenterRealAuthenConfig.getContext(), intent3.getStringExtra(AlaPersonCenterRealAuthenConfig.REAL_AUTHEN_USER_ID), intent3.getStringExtra(AlaPersonCenterRealAuthenConfig.REAL_AUTHEN_CERTIFY_STATUS));
                    return null;
                } else {
                    return customMessage;
                }
            }
            return (CustomMessage) invokeLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class l extends CustomMessageListener {
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
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            vw4 vw4Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                if (customResponsedMessage.getData() instanceof vw4) {
                    vw4Var = (vw4) customResponsedMessage.getData();
                } else {
                    vw4Var = null;
                }
                lx8.j().l(vw4Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(int i) {
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
                lx8.j().e(TbadkCoreApplication.getInst().getContext());
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class n implements CustomMessageTask.CustomRunnable<vw4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public n() {
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
        public CustomResponsedMessage<?> run(CustomMessage<vw4> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                return new CustomResponsedMessage<>(2921548, Long.valueOf(lx8.j().k(TbadkCoreApplication.getInst().getContext())));
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class o extends CustomMessageListener {
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
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                vt7.i().e(TbadkCoreApplication.getInst().getContext());
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class p implements CustomMessageTask.CustomRunnable<vw4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public p() {
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
        public CustomResponsedMessage<?> run(CustomMessage<vw4> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                return new CustomResponsedMessage<>(2921808, Long.valueOf(vt7.i().j(TbadkCoreApplication.getInst().getContext())));
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class q implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            AlaLiveSdkStatic.s();
            AlaLiveSdkStatic.C();
            AlaLiveSdkStatic.u();
        }
    }

    /* loaded from: classes6.dex */
    public static class r implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public r() {
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

    /* loaded from: classes6.dex */
    public static class s implements Runnable {
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
        r();
        p();
        q();
        z();
        v();
        b78.b(AlaCmdConfigSocket.ALA_SOCKET_PUSH_ALERT, ALAPushAlertResponsedMessage.class, false);
        TbadkCoreApplication.getInst().RegisterIntent(AlaSDKShareEmptyActivityConfig.class, AlaSDKShareEmptyActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(AlaWriteShareInBarActivityConfig.class, AlaShareInBarEmptyActivity.class);
        w();
        t();
        A();
        B();
        x();
        y();
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
            yg.a().post(new s());
        }
    }

    public static void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            yg.a().post(new q());
        }
    }

    public static void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, null) == null) {
            try {
                if (!a) {
                    new pv8().b("0");
                    a = true;
                }
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    public static void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, null) == null) {
            UrlManager.getInstance().addListener(new i());
        }
    }

    public static void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, null) == null) {
            UrlManager.getInstance().addListener(new h());
        }
    }

    public static void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, null) == null) {
            UrlManager.getInstance().addListener(new f());
        }
    }

    public static void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65559, null) == null) {
            MessageManager.getInstance().registerListener(new l(2921545));
        }
    }

    public static void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, null) == null) {
            yg.a().post(new r());
        }
    }

    public static void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65562, null) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2921431, new j());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public static void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65563, null) == null) {
            yg.a().post(new e());
        }
    }

    public static void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65564, null) == null) {
            yg.a().post(new a());
        }
    }

    public static void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65565, null) == null) {
            UrlManager.getInstance().addListener(new g());
        }
    }

    public static void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65566, null) == null) {
            MessageManager.getInstance().addMessageRule(new k(2002001));
        }
    }

    public static void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            MessageManager.getInstance().registerListener(new m(2921549));
            CustomMessageTask customMessageTask = new CustomMessageTask(2921548, new n());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public static void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65561, null) == null) {
            MessageManager.getInstance().registerListener(new o(2921807));
            CustomMessageTask customMessageTask = new CustomMessageTask(2921808, new p());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public static String k(HashMap<String, Object> hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, hashMap)) == null) {
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

    public static void m(TbPageContext tbPageContext, int i2, String str, JSONObject jSONObject, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65553, null, new Object[]{tbPageContext, Integer.valueOf(i2), str, jSONObject, str2}) == null) {
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

    public static void n(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65554, null, str) == null) && !StringUtils.isNull(str) && str.startsWith("#bdtiebalive://") && str.endsWith("#")) {
            String replace = str.replace("#", "");
            if (!AlaLiveRoomActivityConfig.isAlreadyEnterLiveRoom) {
                UrlManager.getInstance().dealOneLink((TbPageContext) r9.a(TbadkCoreApplication.getInst().getCurrentActivity()), new String[]{replace});
            }
            UtilHelper.clearClipBoard();
        }
    }

    public static String o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, str)) == null) {
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
}

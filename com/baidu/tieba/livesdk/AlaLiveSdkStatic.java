package com.baidu.tieba.livesdk;

import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
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
import com.baidu.tbadk.core.atomData.AlaTabFeedActivityConfig;
import com.baidu.tbadk.core.atomData.AlaWriteShareInBarActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.BjhMasterActivityConfig;
import com.baidu.tbadk.core.leveiconlivepolling.PollingModel;
import com.baidu.tbadk.core.util.NewUrlSchemaHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.mutiprocess.share.ShareEvent;
import com.baidu.tbadk.switchs.AsyncGetClipboardSwitch;
import com.baidu.tieba.bi7;
import com.baidu.tieba.dh;
import com.baidu.tieba.e77;
import com.baidu.tieba.fb;
import com.baidu.tieba.fi5;
import com.baidu.tieba.gh;
import com.baidu.tieba.kj7;
import com.baidu.tieba.livesdk.dispatcher.YYCustomerServiceDispatcher;
import com.baidu.tieba.livesdk.dispatcher.YYFeedbackDispatcher;
import com.baidu.tieba.livesdk.dispatcher.YYLiveRoomDispatcher;
import com.baidu.tieba.livesdk.dispatcher.YYRouterDispatcher;
import com.baidu.tieba.livesdk.share.AlaSDKShareEmptyActivity;
import com.baidu.tieba.livesdk.share.AlaShareInBarEmptyActivity;
import com.baidu.tieba.play.cyberPlayer.CyberRemotePlayerService;
import com.baidu.tieba.q15;
import com.baidu.tieba.qh5;
import com.baidu.tieba.rh7;
import com.baidu.tieba.rn4;
import com.baidu.tieba.tl;
import com.baidu.tieba.uh5;
import com.baidu.tieba.vg5;
import com.baidu.tieba.w26;
import com.baidu.tieba.w9;
import com.baidu.tieba.wh7;
import com.baidu.tieba.xh7;
import com.baidu.tieba.z26;
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
/* loaded from: classes4.dex */
public class AlaLiveSdkStatic {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public static CustomMessageListener b;
    public static CustomMessageListener c;
    public static CustomMessageListener d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.baidu.tieba.livesdk.AlaLiveSdkStatic$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0324a extends CustomMessageListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0324a(a aVar, int i) {
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
                MessageManager.getInstance().registerListener(new C0324a(this, 2921569));
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: com.baidu.tieba.livesdk.AlaLiveSdkStatic$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes4.dex */
            public class C0325a extends qh5<String> {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                public C0325a(a aVar) {
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
                @Override // com.baidu.tieba.qh5
                public String doInBackground() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? UtilHelper.getClipBoardContent() : (String) invokeV.objValue;
                }
            }

            /* renamed from: com.baidu.tieba.livesdk.AlaLiveSdkStatic$b$a$b  reason: collision with other inner class name */
            /* loaded from: classes4.dex */
            public class C0326b implements vg5<String> {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: com.baidu.tieba.livesdk.AlaLiveSdkStatic$b$a$b$a  reason: collision with other inner class name */
                /* loaded from: classes4.dex */
                public class RunnableC0327a implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ String a;

                    public RunnableC0327a(C0326b c0326b, String str) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {c0326b, str};
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
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            AlaLiveSdkStatic.n(this.a);
                        }
                    }
                }

                public C0326b(a aVar) {
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
                @Override // com.baidu.tieba.vg5
                /* renamed from: a */
                public void onReturnDataInUI(String str) {
                    Interceptable interceptable = $ic;
                    if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && !StringUtils.isNull(str) && str.startsWith("#bdtiebalive://") && str.endsWith("#")) {
                        AlaLiveSdkStatic.l();
                        gh.a().postDelayed(new RunnableC0327a(this, str), 1000L);
                    }
                }
            }

            /* loaded from: classes4.dex */
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
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        AlaLiveSdkStatic.n(this.a);
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
                        uh5.b(new C0325a(this), new C0326b(this));
                        return;
                    }
                    String clipBoardContent = UtilHelper.getClipBoardContent();
                    if (!StringUtils.isNull(clipBoardContent) && clipBoardContent.startsWith("#bdtiebalive://") && clipBoardContent.endsWith("#")) {
                        AlaLiveSdkStatic.l();
                        gh.a().postDelayed(new c(this, clipBoardContent), 1000L);
                    }
                }
            }
        }

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
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                gh.a().postDelayed(new a(this), 100L);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
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

    /* loaded from: classes4.dex */
    public static class d implements UrlManager.UrlDealListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d() {
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
                if (lowerCase.startsWith("http://tieba.baidu.com/ala/share?") || lowerCase.startsWith("https://tieba.baidu.com/ala/share?") || lowerCase.startsWith("http://tieba.baidu.com/ala/share/live") || lowerCase.startsWith("https://tieba.baidu.com/ala/share/live")) {
                    String paramStr = UrlManager.getParamStr(lowerCase);
                    if (StringUtils.isNull(paramStr) || (paramPair = UrlManager.getParamPair(paramStr)) == null) {
                        return 1;
                    }
                    AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                    alaLiveInfoCoreData.liveID = dh.g(paramPair.get("liveid"), 0L);
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

    /* loaded from: classes4.dex */
    public static class e implements UrlManager.UrlDealListener {
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

        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, tbPageContext, strArr)) == null) {
                if (strArr != null && strArr[0] != null && strArr[0].startsWith("tbnps://") && strArr[0].contains("pre_download")) {
                    try {
                        Uri parse = Uri.parse(strArr[0]);
                        if (parse != null) {
                            tl.i(parse.getQueryParameter("package_name"));
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

    /* loaded from: classes4.dex */
    public static class f implements UrlManager.UrlDealListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes4.dex */
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
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
            public void onInstallError(int i, int i2, String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIIL(1048576, this, i, i2, str) == null) {
                }
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener2
            public void onInstallInfo(int i, int i2, Object obj) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, obj) == null) && (obj instanceof String)) {
                    if (i == 100) {
                        TbadkCoreApplication.getInst().setLibcyberffmpeg((String) obj);
                    } else if (i == 101) {
                        TbadkCoreApplication.getInst().setLibssl((String) obj);
                    } else if (i == 102) {
                        TbadkCoreApplication.getInst().setLibcrypto((String) obj);
                    }
                }
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
            public void onInstallProgress(int i, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
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

        /* loaded from: classes4.dex */
        public class b implements xh7 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ TbPageContext a;
            public final /* synthetic */ String b;

            public b(f fVar, TbPageContext tbPageContext, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar, tbPageContext, str};
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

            @Override // com.baidu.tieba.xh7
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
                        String d = fi5.d(strArr[0], "url");
                        if ("video/mixlive".equals(AlaLiveSdkStatic.o(d))) {
                            Uri parse = Uri.parse(d);
                            HashMap hashMap = new HashMap();
                            for (String str : parse.getQueryParameterNames()) {
                                hashMap.put(str, parse.getQueryParameter(str));
                            }
                            kj7.j().w(tbPageContext.getPageActivity(), (String) hashMap.get("room_id"), (String) hashMap.get("source"), AlaLiveSdkStatic.k(hashMap), parse);
                            return 0;
                        }
                    }
                    if (strArr[0].startsWith("bdtiebalive://video/mixlive") && "video/mixlive".equals(AlaLiveSdkStatic.o(strArr[0]))) {
                        Uri parse2 = Uri.parse(strArr[0]);
                        HashMap hashMap2 = new HashMap();
                        for (String str2 : parse2.getQueryParameterNames()) {
                            hashMap2.put(str2, parse2.getQueryParameter(str2));
                        }
                        kj7.j().w(tbPageContext.getPageActivity(), (String) hashMap2.get("room_id"), (String) hashMap2.get("source"), AlaLiveSdkStatic.k(hashMap2), parse2);
                        return 0;
                    } else if (strArr[0].startsWith("bdtiebalive://video/createRoom") && "video/createRoom".equals(AlaLiveSdkStatic.o(strArr[0]))) {
                        Uri parse3 = Uri.parse(strArr[0]);
                        HashMap hashMap3 = new HashMap();
                        for (String str3 : parse3.getQueryParameterNames()) {
                            hashMap3.put(str3, String.valueOf(parse3.getQueryParameter(str3)));
                        }
                        BjhMasterActivityConfig bjhMasterActivityConfig = new BjhMasterActivityConfig(tbPageContext.getPageActivity().getApplication(), (String) hashMap3.get("fid"), (String) hashMap3.get("forumName"));
                        rh7.r((Application) bjhMasterActivityConfig.getContext(), bjhMasterActivityConfig.getTiebaExtra(), null);
                        return 0;
                    } else if (strArr[0].startsWith("bdtiebalive://deeplink")) {
                        if ("deeplink".equals(AlaLiveSdkStatic.o(strArr[0]))) {
                            z26 z26Var = new z26(strArr[0]);
                            w26.a(tbPageContext.getPageActivity(), z26Var.d(), z26Var.a(), false);
                        }
                        return 0;
                    } else {
                        if (strArr[0].startsWith("bdtiebalive://webview") && AlbumActivityConfig.FROM_WEB_VIEW.equals(AlaLiveSdkStatic.o(strArr[0]))) {
                            String b2 = new z26(strArr[0]).b("url_key");
                            if (!TextUtils.isEmpty(b2)) {
                                UrlManager.getInstance().dealOneLink((TbPageContext) w9.a(tbPageContext.getPageActivity()), new String[]{b2});
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
                                bi7 bi7Var = new bi7();
                                bi7Var.a = str5;
                                bi7Var.c = (String) hashMap4.get("is_translucent");
                                bi7Var.b = TextUtils.equals((String) hashMap4.get("is_translucent"), "1");
                                rh7.e(tbPageContext.getPageActivity(), bi7Var, new b(this, tbPageContext, str5));
                            } else if (strArr[0].startsWith("bdtiebalive://video/live/start")) {
                                rh7.b(tbPageContext.getPageActivity(), strArr[0], hashMap4);
                            } else if (strArr[0].startsWith("bdtiebalive://video/live/admin")) {
                                rh7.f(tbPageContext.getPageActivity());
                            } else if (strArr[0].startsWith("bdtiebalive://video/live/forbidden")) {
                                rh7.i(tbPageContext.getPageActivity());
                            } else if (!strArr[0].startsWith("bdtiebalive://video/live/exp") && !strArr[0].startsWith("bdtiebalive://video/live/experience")) {
                                if (strArr[0].startsWith("bdtiebalive://video/live/guardian")) {
                                    rh7.j(tbPageContext.getPageActivity(), (String) hashMap4.get("value"), (String) hashMap4.get("uid"));
                                } else if (strArr[0].startsWith("bdtiebalive://video/live/fans")) {
                                    rh7.h(tbPageContext.getPageActivity(), null, 0);
                                } else if (strArr[0].startsWith("bdtiebalive://video/live/patrons")) {
                                    rh7.m(tbPageContext.getPageActivity(), (String) hashMap4.get("userId"));
                                } else if (strArr[0].startsWith("bdtiebalive://video/live/patronage")) {
                                    rh7.l(tbPageContext.getPageActivity());
                                } else if (strArr[0].startsWith("bdtiebalive://video/live/realAuthen")) {
                                    rh7.n(tbPageContext.getPageActivity(), (String) hashMap4.get("userId"), (String) hashMap4.get("certifyStatus"));
                                } else {
                                    rh7.c(tbPageContext.getPageActivity(), strArr[0], hashMap4);
                                }
                            } else {
                                rh7.g(tbPageContext.getPageActivity(), hashMap4.get("exp") == null ? -1L : ((Long) hashMap4.get("exp")).longValue(), hashMap4.get(PollingModel.LEVEL) == null ? -1 : ((Integer) hashMap4.get(PollingModel.LEVEL)).intValue());
                            }
                            return 0;
                        } else if (strArr[0].startsWith(YYRouterDispatcher.PREFIX)) {
                            rh7.d(tbPageContext.getPageActivity(), strArr[0]);
                            return 0;
                        } else if (strArr[0].startsWith("com.baidu.tieba://unidispatch/BDPLiveChannel")) {
                            AlaTabFeedActivityConfig alaTabFeedActivityConfig = new AlaTabFeedActivityConfig(tbPageContext.getPageActivity());
                            alaTabFeedActivityConfig.setPageSource(q15.d(strArr[0]));
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, alaTabFeedActivityConfig));
                            return 0;
                        } else if (strArr[0].startsWith(YYLiveRoomDispatcher.PREFIX)) {
                            kj7.j().G(tbPageContext.getPageActivity(), strArr[0]);
                            return 0;
                        } else if (strArr[0].startsWith(YYFeedbackDispatcher.PREFIX)) {
                            kj7.j().F(tbPageContext.getPageActivity(), strArr[0]);
                            return 0;
                        } else if (strArr[0].startsWith(YYCustomerServiceDispatcher.PREFIX)) {
                            kj7.j().E(tbPageContext.getPageActivity(), strArr[0]);
                            return 0;
                        }
                    }
                }
                return 3;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes4.dex */
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
                                alaLiveInfoCoreData.liveID = dh.g(str2, 0L);
                                alaLiveInfoCoreData.userName = str3;
                                alaLiveInfoCoreData.rtmpUrl = str4;
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_OUTSIDE, null, false, null)));
                            } catch (UnsupportedEncodingException e) {
                                e.printStackTrace();
                            }
                            return 0;
                        }
                    } else if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_JUMP_LIVE_ROOM)) {
                        long g = dh.g(fi5.c(str, "liveId="), 0L);
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

    /* loaded from: classes4.dex */
    public static class h implements CustomMessageTask.CustomRunnable<Object> {
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

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) ? new CustomResponsedMessage<>(2921431) : (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class i extends fb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(int i) {
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
        @Override // com.baidu.tieba.jb
        public CustomMessage<?> process(CustomMessage<?> customMessage, CustomMessageTask customMessageTask) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, customMessage, customMessageTask)) == null) {
                if (customMessage != null && (customMessage.getData() instanceof AlaLiveRoomActivityConfig)) {
                    AlaLiveSdkStatic.l();
                    AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = (AlaLiveRoomActivityConfig) customMessage.getData();
                    Intent intent = alaLiveRoomActivityConfig.getIntent();
                    rh7.k(alaLiveRoomActivityConfig.getContext(), intent.getStringExtra(AlaLiveRoomActivityConfig.LIVE_FROM_TYPE), (AlaLiveInfoCoreData) intent.getSerializableExtra("live_info_core"));
                    return null;
                } else if (customMessage != null && (customMessage.getData() instanceof AlaMasterLiveRoomActivityConfig)) {
                    AlaLiveSdkStatic.l();
                    rh7.a(((AlaMasterLiveRoomActivityConfig) customMessage.getData()).getContext());
                    return null;
                } else if (customMessage != null && (customMessage.getData() instanceof BjhMasterActivityConfig)) {
                    AlaLiveSdkStatic.l();
                    BjhMasterActivityConfig bjhMasterActivityConfig = (BjhMasterActivityConfig) customMessage.getData();
                    rh7.r((Application) bjhMasterActivityConfig.getContext(), bjhMasterActivityConfig.getTiebaExtra(), null);
                    return null;
                } else if (customMessage != null && (customMessage.getData() instanceof AlaAdminListActivityConfig)) {
                    AlaLiveSdkStatic.l();
                    rh7.f(((AlaAdminListActivityConfig) customMessage.getData()).getContext());
                    return null;
                } else if (customMessage != null && (customMessage.getData() instanceof AlaFansFamilyActivityConfig)) {
                    AlaLiveSdkStatic.l();
                    AlaFansFamilyActivityConfig alaFansFamilyActivityConfig = (AlaFansFamilyActivityConfig) customMessage.getData();
                    rh7.h(alaFansFamilyActivityConfig.getContext(), alaFansFamilyActivityConfig.getIntent().getStringExtra("author_live_user_id"), -1);
                    return null;
                } else if (customMessage != null && (customMessage.getData() instanceof AlaForbiddenListActivityConfig)) {
                    AlaLiveSdkStatic.l();
                    rh7.i(((AlaForbiddenListActivityConfig) customMessage.getData()).getContext());
                    return null;
                } else if (customMessage != null && (customMessage.getData() instanceof AlaLoveFamilyActivityConfig)) {
                    AlaLiveSdkStatic.l();
                    rh7.l(((AlaLoveFamilyActivityConfig) customMessage.getData()).getContext());
                    return null;
                } else if (customMessage != null && (customMessage.getData() instanceof AlaPersonCenterExpActivityConfig)) {
                    AlaLiveSdkStatic.l();
                    AlaPersonCenterExpActivityConfig alaPersonCenterExpActivityConfig = (AlaPersonCenterExpActivityConfig) customMessage.getData();
                    Intent intent2 = alaPersonCenterExpActivityConfig.getIntent();
                    rh7.g(alaPersonCenterExpActivityConfig.getContext(), intent2.getLongExtra(AlaPersonCenterExpActivityConfig.CURRENT_EXP, 0L), intent2.getIntExtra("current_level", 0));
                    return null;
                } else if (customMessage == null || !(customMessage.getData() instanceof AlaPersonCenterRealAuthenConfig)) {
                    return customMessage;
                } else {
                    AlaLiveSdkStatic.l();
                    AlaPersonCenterRealAuthenConfig alaPersonCenterRealAuthenConfig = (AlaPersonCenterRealAuthenConfig) customMessage.getData();
                    Intent intent3 = alaPersonCenterRealAuthenConfig.getIntent();
                    rh7.n(alaPersonCenterRealAuthenConfig.getContext(), intent3.getStringExtra(AlaPersonCenterRealAuthenConfig.REAL_AUTHEN_USER_ID), intent3.getStringExtra(AlaPersonCenterRealAuthenConfig.REAL_AUTHEN_CERTIFY_STATUS));
                    return null;
                }
            }
            return (CustomMessage) invokeLL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(int i) {
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
                kj7.j().l(customResponsedMessage.getData() instanceof rn4 ? (rn4) customResponsedMessage.getData() : null);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class k extends CustomMessageListener {
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
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                kj7.j().e(TbadkCoreApplication.getInst().getContext());
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class l implements CustomMessageTask.CustomRunnable<rn4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public l() {
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
        public CustomResponsedMessage<?> run(CustomMessage<rn4> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) ? new CustomResponsedMessage<>(2921548, Long.valueOf(kj7.j().k(TbadkCoreApplication.getInst().getContext()))) : (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public m() {
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
                AlaLiveSdkStatic.s();
                AlaLiveSdkStatic.B();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class n implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MessageManager.getInstance().registerListener(AlaLiveSdkStatic.c);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public o() {
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

    /* loaded from: classes4.dex */
    public static class p extends CustomMessageListener {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof ShareEvent)) {
                long g = dh.g(((ShareEvent) customResponsedMessage.getData()).extLiveInfo, 0L);
                if (g > 0) {
                    rh7.q(g);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class q extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(int i) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() == null || StringUtils.isNull(updateAttentionMessage.getData().c) || !updateAttentionMessage.getData().a || updateAttentionMessage.getData().e) {
                    return;
                }
                AlaLiveSdkStatic.l();
                rh7.p(updateAttentionMessage.getData().c, updateAttentionMessage.getData().d);
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
        e77.b(AlaCmdConfigSocket.ALA_SOCKET_PUSH_ALERT, ALAPushAlertResponsedMessage.class, false);
        TbadkCoreApplication.getInst().RegisterIntent(AlaSDKShareEmptyActivityConfig.class, AlaSDKShareEmptyActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(AlaWriteShareInBarActivityConfig.class, AlaShareInBarEmptyActivity.class);
        v();
        t();
        z();
        A();
        w();
        x();
        b = new p(2921406);
        c = new q(2001115);
        d = new b(2007002);
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
            gh.a().post(new m());
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
        return (String) invokeL.objValue;
    }

    public static void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, null) == null) {
            try {
                if (a) {
                    return;
                }
                new wh7().b("0");
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

    public static void n(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65553, null, str) == null) && !StringUtils.isNull(str) && str.startsWith("#bdtiebalive://") && str.endsWith("#")) {
            String replace = str.replace("#", "");
            if (!AlaLiveRoomActivityConfig.isAlreadyEnterLiveRoom) {
                UrlManager.getInstance().dealOneLink((TbPageContext) w9.a(TbadkCoreApplication.getInst().getCurrentActivity()), new String[]{replace});
            }
            UtilHelper.clearClipBoard();
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
            gh.a().post(new n());
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
            gh.a().post(new c());
        }
    }

    public static void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65562, null) == null) {
            gh.a().post(new a());
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
            gh.a().post(new o());
        }
    }
}

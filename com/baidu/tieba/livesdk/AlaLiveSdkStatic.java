package com.baidu.tieba.livesdk;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
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
import com.baidu.searchbox.live.nps.LiveNPSPluginManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.AlaMasterLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.AlaWriteShareInBarActivityConfig;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.mutiprocess.share.ShareEvent;
import com.baidu.tieba.livesdk.share.AlaSDKShareEmptyActivity;
import com.baidu.tieba.livesdk.share.AlaShareInBarEmptyActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.z0.p0;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaLiveSdkStatic {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f18356a;

    /* renamed from: b  reason: collision with root package name */
    public static CustomMessageListener f18357b;

    /* renamed from: c  reason: collision with root package name */
    public static CustomMessageListener f18358c;

    /* renamed from: d  reason: collision with root package name */
    public static CustomMessageListener f18359d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.baidu.tieba.livesdk.AlaLiveSdkStatic$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0213a extends CustomMessageListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0213a(a aVar, int i2) {
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
                MessageManager.getInstance().registerListener(new C0213a(this, 2921569));
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
            public class RunnableC0214a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                public RunnableC0214a(a aVar) {
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
                        d.a.c.e.m.e.a().postDelayed(new RunnableC0214a(this), 1000L);
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
                d.a.c.e.m.e.a().postDelayed(new a(this), 100L);
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
                MessageManager.getInstance().registerListener(AlaLiveSdkStatic.f18359d);
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
                    alaLiveInfoCoreData.liveID = d.a.c.e.m.b.f(paramPair.get(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID), 0L);
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

        /* loaded from: classes4.dex */
        public class a implements d.a.p0.q1.k.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ TbPageContext f18360a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f18361b;

            public a(e eVar, TbPageContext tbPageContext, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, tbPageContext, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f18360a = tbPageContext;
                this.f18361b = str;
            }

            @Override // d.a.p0.q1.k.a
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
                        AlaLiveSdkStatic.m(this.f18360a, optInt, optString, jSONObject2, this.f18361b);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }

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
                if (strArr == null || strArr[0] == null || !(strArr[0].startsWith(UrlSchemaHelper.SCHEMA_LIVE_SDK) || strArr[0].contains(UrlSchemaHelper.GO_TO_MIX_LIVE))) {
                    return 3;
                }
                AlaLiveSdkStatic.l();
                if (strArr[0].contains(UrlSchemaHelper.GO_TO_MIX_LIVE)) {
                    String d2 = p0.d(strArr[0], "url");
                    if ("video/mixlive".equals(AlaLiveSdkStatic.o(d2))) {
                        Uri parse = Uri.parse(d2);
                        HashMap hashMap = new HashMap();
                        for (String str : parse.getQueryParameterNames()) {
                            hashMap.put(str, parse.getQueryParameter(str));
                        }
                        d.a.p0.u1.a.j().v(tbPageContext.getPageActivity(), (String) hashMap.get("room_id"), (String) hashMap.get("source"), AlaLiveSdkStatic.k(hashMap), parse);
                        return 0;
                    }
                }
                if (strArr[0].startsWith("bdtiebalive://video/mixlive") && "video/mixlive".equals(AlaLiveSdkStatic.o(strArr[0]))) {
                    Uri parse2 = Uri.parse(strArr[0]);
                    HashMap hashMap2 = new HashMap();
                    for (String str2 : parse2.getQueryParameterNames()) {
                        hashMap2.put(str2, parse2.getQueryParameter(str2));
                    }
                    d.a.p0.u1.a.j().v(tbPageContext.getPageActivity(), (String) hashMap2.get("room_id"), (String) hashMap2.get("source"), AlaLiveSdkStatic.k(hashMap2), parse2);
                    return 0;
                } else if (strArr[0].startsWith("bdtiebalive://deeplink")) {
                    if ("deeplink".equals(AlaLiveSdkStatic.o(strArr[0]))) {
                        d.a.p0.c0.e eVar = new d.a.p0.c0.e(strArr[0]);
                        d.a.p0.c0.b.a(tbPageContext.getPageActivity(), eVar.d(), eVar.a(), false);
                    }
                    return 0;
                } else {
                    if (strArr[0].startsWith("bdtiebalive://webview") && "webview".equals(AlaLiveSdkStatic.o(strArr[0]))) {
                        String b2 = new d.a.p0.c0.e(strArr[0]).b("url_key");
                        if (!TextUtils.isEmpty(b2)) {
                            UrlManager.getInstance().dealOneLink((TbPageContext) d.a.c.a.j.a(tbPageContext.getPageActivity()), new String[]{b2});
                            return 0;
                        }
                    }
                    if (strArr[0].startsWith("bdtiebalive://video/live")) {
                        Uri parse3 = Uri.parse(strArr[0]);
                        HashMap hashMap3 = new HashMap();
                        for (String str3 : parse3.getQueryParameterNames()) {
                            hashMap3.put(str3, parse3.getQueryParameter(str3));
                        }
                        if (strArr[0].startsWith("bdtiebalive:video/live/tbean")) {
                            String str4 = (String) hashMap3.get("callback");
                            d.a.p0.q1.n.a aVar = new d.a.p0.q1.n.a();
                            aVar.f61713a = str4;
                            aVar.f61715c = (String) hashMap3.get("is_translucent");
                            aVar.f61714b = TextUtils.equals((String) hashMap3.get("is_translucent"), "1");
                            d.a.p0.q1.a.e(tbPageContext.getPageActivity(), aVar, new a(this, tbPageContext, str4));
                        } else if (strArr[0].startsWith("bdtiebalive://video/live/start")) {
                            d.a.p0.q1.a.b(tbPageContext.getPageActivity(), strArr[0], hashMap3);
                        } else if (strArr[0].startsWith("bdtiebalive://video/live/admin")) {
                            d.a.p0.q1.a.f(tbPageContext.getPageActivity());
                        } else if (strArr[0].startsWith("bdtiebalive://video/live/forbidden")) {
                            d.a.p0.q1.a.i(tbPageContext.getPageActivity());
                        } else if (!strArr[0].startsWith("bdtiebalive://video/live/exp") && !strArr[0].startsWith("bdtiebalive://video/live/experience")) {
                            if (strArr[0].startsWith("bdtiebalive://video/live/guardian")) {
                                d.a.p0.q1.a.j(tbPageContext.getPageActivity(), (String) hashMap3.get("value"), (String) hashMap3.get("uid"));
                            } else if (strArr[0].startsWith("bdtiebalive://video/live/fans")) {
                                d.a.p0.q1.a.h(tbPageContext.getPageActivity(), null, 0);
                            } else if (strArr[0].startsWith("bdtiebalive://video/live/patrons")) {
                                d.a.p0.q1.a.m(tbPageContext.getPageActivity(), (String) hashMap3.get("userId"));
                            } else if (strArr[0].startsWith("bdtiebalive://video/live/patronage")) {
                                d.a.p0.q1.a.l(tbPageContext.getPageActivity());
                            } else if (strArr[0].startsWith("bdtiebalive://video/live/realAuthen")) {
                                d.a.p0.q1.a.n(tbPageContext.getPageActivity(), (String) hashMap3.get("userId"), (String) hashMap3.get("certifyStatus"));
                            } else {
                                d.a.p0.q1.a.c(tbPageContext.getPageActivity(), strArr[0], hashMap3);
                            }
                        } else {
                            d.a.p0.q1.a.g(tbPageContext.getPageActivity(), hashMap3.get("exp") == null ? -1L : ((Long) hashMap3.get("exp")).longValue(), hashMap3.get("level") == null ? -1 : ((Integer) hashMap3.get("level")).intValue());
                        }
                        return 0;
                    } else if (strArr[0].startsWith("bdtiebalive://video/yylive/router")) {
                        d.a.p0.q1.a.d(tbPageContext.getPageActivity(), strArr[0]);
                        return 0;
                    } else if (strArr[0].startsWith("bdtiebalive://video/yylive/joinlive")) {
                        d.a.p0.u1.a.j().F(tbPageContext.getPageActivity(), strArr[0]);
                        return 0;
                    } else if (strArr[0].startsWith("bdtiebalive://video/yylive/feedback")) {
                        d.a.p0.u1.a.j().E(tbPageContext.getPageActivity(), strArr[0]);
                        return 0;
                    } else {
                        if (strArr[0].startsWith("bdtiebalive://video/yylive/customerservice")) {
                            d.a.p0.u1.a.j().D(tbPageContext.getPageActivity(), strArr[0]);
                            return 0;
                        }
                        return 3;
                    }
                }
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class f implements UrlManager.UrlDealListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                            String str2 = paramPair.get(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID);
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
                                alaLiveInfoCoreData.liveID = d.a.c.e.m.b.f(str2, 0L);
                                alaLiveInfoCoreData.userName = str3;
                                alaLiveInfoCoreData.rtmpUrl = str4;
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_OUTSIDE, null, false, null)));
                            } catch (UnsupportedEncodingException e2) {
                                e2.printStackTrace();
                            }
                            return 0;
                        }
                    } else if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_JUMP_LIVE_ROOM)) {
                        long f2 = d.a.c.e.m.b.f(p0.c(str, "liveId="), 0L);
                        if (f2 == 0) {
                            return 3;
                        }
                        AlaLiveInfoCoreData alaLiveInfoCoreData2 = new AlaLiveInfoCoreData();
                        alaLiveInfoCoreData2.liveID = f2;
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
    public static class g implements CustomMessageTask.CustomRunnable<Object> {
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

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) ? new CustomResponsedMessage<>(2921431) : (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class h extends d.a.c.c.f.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(int i2) {
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
        @Override // d.a.c.c.f.f
        public CustomMessage<?> process(CustomMessage<?> customMessage, CustomMessageTask customMessageTask) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, customMessage, customMessageTask)) == null) {
                if (customMessage != null && (customMessage.getData() instanceof AlaLiveRoomActivityConfig)) {
                    AlaLiveSdkStatic.l();
                    AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = (AlaLiveRoomActivityConfig) customMessage.getData();
                    Intent intent = alaLiveRoomActivityConfig.getIntent();
                    d.a.p0.q1.a.k(alaLiveRoomActivityConfig.getContext(), intent.getStringExtra(AlaLiveRoomActivityConfig.LIVE_FROM_TYPE), (AlaLiveInfoCoreData) intent.getSerializableExtra("live_info_core"));
                    return null;
                } else if (customMessage != null && (customMessage.getData() instanceof AlaMasterLiveRoomActivityConfig)) {
                    AlaLiveSdkStatic.l();
                    d.a.p0.q1.a.a(((AlaMasterLiveRoomActivityConfig) customMessage.getData()).getContext());
                    return null;
                } else if (customMessage != null && (customMessage.getData() instanceof AlaAdminListActivityConfig)) {
                    AlaLiveSdkStatic.l();
                    d.a.p0.q1.a.f(((AlaAdminListActivityConfig) customMessage.getData()).getContext());
                    return null;
                } else if (customMessage != null && (customMessage.getData() instanceof AlaFansFamilyActivityConfig)) {
                    AlaLiveSdkStatic.l();
                    AlaFansFamilyActivityConfig alaFansFamilyActivityConfig = (AlaFansFamilyActivityConfig) customMessage.getData();
                    d.a.p0.q1.a.h(alaFansFamilyActivityConfig.getContext(), alaFansFamilyActivityConfig.getIntent().getStringExtra("author_live_user_id"), -1);
                    return null;
                } else if (customMessage != null && (customMessage.getData() instanceof AlaForbiddenListActivityConfig)) {
                    AlaLiveSdkStatic.l();
                    d.a.p0.q1.a.i(((AlaForbiddenListActivityConfig) customMessage.getData()).getContext());
                    return null;
                } else if (customMessage != null && (customMessage.getData() instanceof AlaLoveFamilyActivityConfig)) {
                    AlaLiveSdkStatic.l();
                    d.a.p0.q1.a.l(((AlaLoveFamilyActivityConfig) customMessage.getData()).getContext());
                    return null;
                } else if (customMessage != null && (customMessage.getData() instanceof AlaPersonCenterExpActivityConfig)) {
                    AlaLiveSdkStatic.l();
                    AlaPersonCenterExpActivityConfig alaPersonCenterExpActivityConfig = (AlaPersonCenterExpActivityConfig) customMessage.getData();
                    Intent intent2 = alaPersonCenterExpActivityConfig.getIntent();
                    d.a.p0.q1.a.g(alaPersonCenterExpActivityConfig.getContext(), intent2.getLongExtra(AlaPersonCenterExpActivityConfig.CURRENT_EXP, 0L), intent2.getIntExtra("current_level", 0));
                    return null;
                } else if (customMessage == null || !(customMessage.getData() instanceof AlaPersonCenterRealAuthenConfig)) {
                    return customMessage;
                } else {
                    AlaLiveSdkStatic.l();
                    AlaPersonCenterRealAuthenConfig alaPersonCenterRealAuthenConfig = (AlaPersonCenterRealAuthenConfig) customMessage.getData();
                    Intent intent3 = alaPersonCenterRealAuthenConfig.getIntent();
                    d.a.p0.q1.a.n(alaPersonCenterRealAuthenConfig.getContext(), intent3.getStringExtra(AlaPersonCenterRealAuthenConfig.REAL_AUTHEN_USER_ID), intent3.getStringExtra(AlaPersonCenterRealAuthenConfig.REAL_AUTHEN_CERTIFY_STATUS));
                    return null;
                }
            }
            return (CustomMessage) invokeLL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class i extends CustomMessageListener {
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
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                d.a.p0.u1.a.j().l(customResponsedMessage.getData() instanceof d.a.o0.d.f ? (d.a.o0.d.f) customResponsedMessage.getData() : null);
            }
        }
    }

    /* loaded from: classes4.dex */
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
                d.a.p0.u1.a.j().e(TbadkCoreApplication.getInst().getContext());
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class k implements CustomMessageTask.CustomRunnable<d.a.o0.d.f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public k() {
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
        public CustomResponsedMessage<?> run(CustomMessage<d.a.o0.d.f> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) ? new CustomResponsedMessage<>(2921548, Long.valueOf(d.a.p0.u1.a.j().k(TbadkCoreApplication.getInst().getContext()))) : (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class l implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                AlaLiveSdkStatic.s();
                AlaLiveSdkStatic.A();
            }
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
                MessageManager.getInstance().registerListener(AlaLiveSdkStatic.f18358c);
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
                MessageManager.getInstance().registerListener(AlaLiveSdkStatic.f18357b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class o extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(int i2) {
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
                long f2 = d.a.c.e.m.b.f(((ShareEvent) customResponsedMessage.getData()).extLiveInfo, 0L);
                if (f2 > 0) {
                    d.a.p0.q1.a.q(f2);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() == null || StringUtils.isNull(updateAttentionMessage.getData().f12819c) || !updateAttentionMessage.getData().f12817a || updateAttentionMessage.getData().f12821e) {
                    return;
                }
                AlaLiveSdkStatic.l();
                d.a.p0.q1.a.p(updateAttentionMessage.getData().f12819c, updateAttentionMessage.getData().f12820d);
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
        x();
        u();
        d.a.p0.i1.c.b(AlaCmdConfigSocket.ALA_SOCKET_PUSH_ALERT, ALAPushAlertResponsedMessage.class, false);
        TbadkCoreApplication.getInst().RegisterIntent(AlaSDKShareEmptyActivityConfig.class, AlaSDKShareEmptyActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(AlaWriteShareInBarActivityConfig.class, AlaShareInBarEmptyActivity.class);
        v();
        t();
        y();
        z();
        w();
        f18357b = new o(2921406);
        f18358c = new p(2001115);
        f18359d = new b(2007002);
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
            MessageManager.getInstance().registerListener(new j(2921549));
            CustomMessageTask customMessageTask = new CustomMessageTask(2921548, new k());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public static String k(HashMap<String, Object> hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, hashMap)) == null) {
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
        if (interceptable == null || interceptable.invokeV(65550, null) == null) {
            try {
                if (f18356a) {
                    return;
                }
                new d.a.p0.q1.j.b().b("0");
                f18356a = true;
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    public static void m(TbPageContext tbPageContext, int i2, String str, JSONObject jSONObject, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65551, null, new Object[]{tbPageContext, Integer.valueOf(i2), str, jSONObject, str2}) == null) {
            try {
                if (TextUtils.isEmpty(str2)) {
                    str2 = "callback";
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
        if (interceptable == null || interceptable.invokeV(65552, null) == null) {
            String clipBoardContent = UtilHelper.getClipBoardContent();
            if (!StringUtils.isNull(clipBoardContent) && clipBoardContent.startsWith("#bdtiebalive://") && clipBoardContent.endsWith("#")) {
                String replace = clipBoardContent.replace("#", "");
                if (!AlaLiveRoomActivityConfig.isAlreadyEnterLiveRoom) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) d.a.c.a.j.a(TbadkCoreApplication.getInst().getCurrentActivity()), new String[]{replace});
                }
                UtilHelper.clearClipBoard();
            }
        }
    }

    public static String o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, str)) == null) {
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
        if (interceptable == null || interceptable.invokeV(65554, null) == null) {
            UrlManager.getInstance().addListener(new f());
        }
    }

    public static void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, null) == null) {
            UrlManager.getInstance().addListener(new e());
        }
    }

    public static void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, null) == null) {
            UrlManager.getInstance().addListener(new d());
        }
    }

    public static void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, null) == null) {
            MessageManager.getInstance().registerListener(new i(2921545));
        }
    }

    public static void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, null) == null) {
            d.a.c.e.m.e.a().post(new m());
        }
    }

    public static void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65559, null) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2921431, new g());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public static void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, null) == null) {
            d.a.c.e.m.e.a().post(new c());
        }
    }

    public static void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65561, null) == null) {
            d.a.c.e.m.e.a().post(new a());
        }
    }

    public static void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65562, null) == null) {
            MessageManager.getInstance().addMessageRule(new h(2002001));
        }
    }

    public static void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65563, null) == null) {
            d.a.c.e.m.e.a().post(new n());
        }
    }

    public static void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65564, null) == null) {
            d.a.c.e.m.e.a().post(new l());
        }
    }
}

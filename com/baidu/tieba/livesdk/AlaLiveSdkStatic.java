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
import d.a.m0.z0.n0;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaLiveSdkStatic {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f18032a = false;

    /* renamed from: b  reason: collision with root package name */
    public static CustomMessageListener f18033b;

    /* renamed from: c  reason: collision with root package name */
    public static CustomMessageListener f18034c;

    /* renamed from: d  reason: collision with root package name */
    public static CustomMessageListener f18035d;

    /* loaded from: classes3.dex */
    public static class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            MessageManager.getInstance().registerListener(AlaLiveSdkStatic.f18035d);
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements UrlManager.UrlDealListener {
        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            Map<String, String> paramPair;
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
    }

    /* loaded from: classes3.dex */
    public static class c implements UrlManager.UrlDealListener {

        /* loaded from: classes3.dex */
        public class a implements d.a.n0.n1.k.a {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ TbPageContext f18036a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f18037b;

            public a(c cVar, TbPageContext tbPageContext, String str) {
                this.f18036a = tbPageContext;
                this.f18037b = str;
            }

            @Override // d.a.n0.n1.k.a
            public void onCallback(JSONObject jSONObject) {
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
                    AlaLiveSdkStatic.m(this.f18036a, optInt, optString, jSONObject2, this.f18037b);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            if (strArr == null || strArr[0] == null || !(strArr[0].startsWith(UrlSchemaHelper.SCHEMA_LIVE_SDK) || strArr[0].contains(UrlSchemaHelper.GO_TO_MIX_LIVE))) {
                return 3;
            }
            AlaLiveSdkStatic.l();
            if (strArr[0].contains(UrlSchemaHelper.GO_TO_MIX_LIVE)) {
                String d2 = n0.d(strArr[0], "url");
                if ("video/mixlive".equals(AlaLiveSdkStatic.o(d2))) {
                    Uri parse = Uri.parse(d2);
                    HashMap hashMap = new HashMap();
                    for (String str : parse.getQueryParameterNames()) {
                        hashMap.put(str, parse.getQueryParameter(str));
                    }
                    d.a.n0.r1.a.j().v(tbPageContext.getPageActivity(), (String) hashMap.get("room_id"), (String) hashMap.get("source"), AlaLiveSdkStatic.k(hashMap), parse);
                    return 0;
                }
            }
            if (strArr[0].startsWith("bdtiebalive://video/mixlive") && "video/mixlive".equals(AlaLiveSdkStatic.o(strArr[0]))) {
                Uri parse2 = Uri.parse(strArr[0]);
                HashMap hashMap2 = new HashMap();
                for (String str2 : parse2.getQueryParameterNames()) {
                    hashMap2.put(str2, parse2.getQueryParameter(str2));
                }
                d.a.n0.r1.a.j().v(tbPageContext.getPageActivity(), (String) hashMap2.get("room_id"), (String) hashMap2.get("source"), AlaLiveSdkStatic.k(hashMap2), parse2);
                return 0;
            } else if (strArr[0].startsWith("bdtiebalive://deeplink")) {
                if ("deeplink".equals(AlaLiveSdkStatic.o(strArr[0]))) {
                    d.a.n0.b0.e eVar = new d.a.n0.b0.e(strArr[0]);
                    d.a.n0.b0.b.a(tbPageContext.getPageActivity(), eVar.d(), eVar.a(), false);
                }
                return 0;
            } else {
                if (strArr[0].startsWith("bdtiebalive://webview") && "webview".equals(AlaLiveSdkStatic.o(strArr[0]))) {
                    String b2 = new d.a.n0.b0.e(strArr[0]).b("url_key");
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
                        d.a.n0.n1.n.a aVar = new d.a.n0.n1.n.a();
                        aVar.f57685a = str4;
                        aVar.f57687c = (String) hashMap3.get("is_translucent");
                        aVar.f57686b = TextUtils.equals((String) hashMap3.get("is_translucent"), "1");
                        d.a.n0.n1.a.e(tbPageContext.getPageActivity(), aVar, new a(this, tbPageContext, str4));
                    } else if (strArr[0].startsWith("bdtiebalive://video/live/start")) {
                        d.a.n0.n1.a.b(tbPageContext.getPageActivity(), strArr[0], hashMap3);
                    } else if (strArr[0].startsWith("bdtiebalive://video/live/admin")) {
                        d.a.n0.n1.a.f(tbPageContext.getPageActivity());
                    } else if (strArr[0].startsWith("bdtiebalive://video/live/forbidden")) {
                        d.a.n0.n1.a.i(tbPageContext.getPageActivity());
                    } else if (!strArr[0].startsWith("bdtiebalive://video/live/exp") && !strArr[0].startsWith("bdtiebalive://video/live/experience")) {
                        if (strArr[0].startsWith("bdtiebalive://video/live/guardian")) {
                            d.a.n0.n1.a.j(tbPageContext.getPageActivity(), (String) hashMap3.get("value"), (String) hashMap3.get("uid"));
                        } else if (strArr[0].startsWith("bdtiebalive://video/live/fans")) {
                            d.a.n0.n1.a.h(tbPageContext.getPageActivity(), null, 0);
                        } else if (strArr[0].startsWith("bdtiebalive://video/live/patrons")) {
                            d.a.n0.n1.a.m(tbPageContext.getPageActivity(), (String) hashMap3.get("userId"));
                        } else if (strArr[0].startsWith("bdtiebalive://video/live/patronage")) {
                            d.a.n0.n1.a.l(tbPageContext.getPageActivity());
                        } else if (strArr[0].startsWith("bdtiebalive://video/live/realAuthen")) {
                            d.a.n0.n1.a.n(tbPageContext.getPageActivity(), (String) hashMap3.get("userId"), (String) hashMap3.get("certifyStatus"));
                        } else {
                            d.a.n0.n1.a.c(tbPageContext.getPageActivity(), strArr[0], hashMap3);
                        }
                    } else {
                        d.a.n0.n1.a.g(tbPageContext.getPageActivity(), hashMap3.get("exp") == null ? -1L : ((Long) hashMap3.get("exp")).longValue(), hashMap3.get("level") == null ? -1 : ((Integer) hashMap3.get("level")).intValue());
                    }
                    return 0;
                } else if (strArr[0].startsWith("bdtiebalive://video/yylive/router")) {
                    d.a.n0.n1.a.d(tbPageContext.getPageActivity(), strArr[0]);
                    return 0;
                } else if (strArr[0].startsWith("bdtiebalive://video/yylive/joinlive")) {
                    d.a.n0.r1.a.j().F(tbPageContext.getPageActivity(), strArr[0]);
                    return 0;
                } else if (strArr[0].startsWith("bdtiebalive://video/yylive/feedback")) {
                    d.a.n0.r1.a.j().E(tbPageContext.getPageActivity(), strArr[0]);
                    return 0;
                } else {
                    if (strArr[0].startsWith("bdtiebalive://video/yylive/customerservice")) {
                        d.a.n0.r1.a.j().D(tbPageContext.getPageActivity(), strArr[0]);
                        return 0;
                    }
                    return 3;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements UrlManager.UrlDealListener {
        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            Map<String, String> paramPair;
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
                    long f2 = d.a.c.e.m.b.f(n0.c(str, "liveId="), 0L);
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
    }

    /* loaded from: classes3.dex */
    public static class e implements CustomMessageTask.CustomRunnable<Object> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            return new CustomResponsedMessage<>(2921431);
        }
    }

    /* loaded from: classes3.dex */
    public static class f extends d.a.c.c.f.b {
        public f(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.c.f.f
        public CustomMessage<?> process(CustomMessage<?> customMessage, CustomMessageTask customMessageTask) {
            if (customMessage != null && (customMessage.getData() instanceof AlaLiveRoomActivityConfig)) {
                AlaLiveSdkStatic.l();
                AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = (AlaLiveRoomActivityConfig) customMessage.getData();
                Intent intent = alaLiveRoomActivityConfig.getIntent();
                d.a.n0.n1.a.k(alaLiveRoomActivityConfig.getContext(), intent.getStringExtra(AlaLiveRoomActivityConfig.LIVE_FROM_TYPE), (AlaLiveInfoCoreData) intent.getSerializableExtra("live_info_core"));
                return null;
            } else if (customMessage != null && (customMessage.getData() instanceof AlaMasterLiveRoomActivityConfig)) {
                AlaLiveSdkStatic.l();
                d.a.n0.n1.a.a(((AlaMasterLiveRoomActivityConfig) customMessage.getData()).getContext());
                return null;
            } else if (customMessage != null && (customMessage.getData() instanceof AlaAdminListActivityConfig)) {
                AlaLiveSdkStatic.l();
                d.a.n0.n1.a.f(((AlaAdminListActivityConfig) customMessage.getData()).getContext());
                return null;
            } else if (customMessage != null && (customMessage.getData() instanceof AlaFansFamilyActivityConfig)) {
                AlaLiveSdkStatic.l();
                AlaFansFamilyActivityConfig alaFansFamilyActivityConfig = (AlaFansFamilyActivityConfig) customMessage.getData();
                d.a.n0.n1.a.h(alaFansFamilyActivityConfig.getContext(), alaFansFamilyActivityConfig.getIntent().getStringExtra("author_live_user_id"), -1);
                return null;
            } else if (customMessage != null && (customMessage.getData() instanceof AlaForbiddenListActivityConfig)) {
                AlaLiveSdkStatic.l();
                d.a.n0.n1.a.i(((AlaForbiddenListActivityConfig) customMessage.getData()).getContext());
                return null;
            } else if (customMessage != null && (customMessage.getData() instanceof AlaLoveFamilyActivityConfig)) {
                AlaLiveSdkStatic.l();
                d.a.n0.n1.a.l(((AlaLoveFamilyActivityConfig) customMessage.getData()).getContext());
                return null;
            } else if (customMessage != null && (customMessage.getData() instanceof AlaPersonCenterExpActivityConfig)) {
                AlaLiveSdkStatic.l();
                AlaPersonCenterExpActivityConfig alaPersonCenterExpActivityConfig = (AlaPersonCenterExpActivityConfig) customMessage.getData();
                Intent intent2 = alaPersonCenterExpActivityConfig.getIntent();
                d.a.n0.n1.a.g(alaPersonCenterExpActivityConfig.getContext(), intent2.getLongExtra(AlaPersonCenterExpActivityConfig.CURRENT_EXP, 0L), intent2.getIntExtra("current_level", 0));
                return null;
            } else if (customMessage == null || !(customMessage.getData() instanceof AlaPersonCenterRealAuthenConfig)) {
                return customMessage;
            } else {
                AlaLiveSdkStatic.l();
                AlaPersonCenterRealAuthenConfig alaPersonCenterRealAuthenConfig = (AlaPersonCenterRealAuthenConfig) customMessage.getData();
                Intent intent3 = alaPersonCenterRealAuthenConfig.getIntent();
                d.a.n0.n1.a.n(alaPersonCenterRealAuthenConfig.getContext(), intent3.getStringExtra(AlaPersonCenterRealAuthenConfig.REAL_AUTHEN_USER_ID), intent3.getStringExtra(AlaPersonCenterRealAuthenConfig.REAL_AUTHEN_CERTIFY_STATUS));
                return null;
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class g extends CustomMessageListener {
        public g(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.a.n0.r1.a.j().l(customResponsedMessage.getData() instanceof d.a.m0.d.f ? (d.a.m0.d.f) customResponsedMessage.getData() : null);
        }
    }

    /* loaded from: classes3.dex */
    public static class h extends CustomMessageListener {
        public h(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.a.n0.r1.a.j().e(TbadkCoreApplication.getInst().getContext());
        }
    }

    /* loaded from: classes3.dex */
    public static class i implements CustomMessageTask.CustomRunnable<d.a.m0.d.f> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<d.a.m0.d.f> customMessage) {
            return new CustomResponsedMessage<>(2921548, Long.valueOf(d.a.n0.r1.a.j().k(TbadkCoreApplication.getInst().getContext())));
        }
    }

    /* loaded from: classes3.dex */
    public static class j implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            AlaLiveSdkStatic.s();
            AlaLiveSdkStatic.z();
        }
    }

    /* loaded from: classes3.dex */
    public static class k implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            MessageManager.getInstance().registerListener(AlaLiveSdkStatic.f18034c);
        }
    }

    /* loaded from: classes3.dex */
    public static class l implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            MessageManager.getInstance().registerListener(AlaLiveSdkStatic.f18033b);
        }
    }

    /* loaded from: classes3.dex */
    public static class m extends CustomMessageListener {
        public m(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof ShareEvent)) {
                return;
            }
            long f2 = d.a.c.e.m.b.f(((ShareEvent) customResponsedMessage.getData()).extLiveInfo, 0L);
            if (f2 > 0) {
                d.a.n0.n1.a.q(f2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class n extends CustomMessageListener {
        public n(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() == null || StringUtils.isNull(updateAttentionMessage.getData().f12576c) || !updateAttentionMessage.getData().f12574a || updateAttentionMessage.getData().f12578e) {
                    return;
                }
                AlaLiveSdkStatic.l();
                d.a.n0.n1.a.p(updateAttentionMessage.getData().f12576c, updateAttentionMessage.getData().f12577d);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class o extends CustomMessageListener {

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: com.baidu.tieba.livesdk.AlaLiveSdkStatic$o$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class RunnableC0190a implements Runnable {
                public RunnableC0190a(a aVar) {
                }

                @Override // java.lang.Runnable
                public void run() {
                    AlaLiveSdkStatic.n();
                }
            }

            public a(o oVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
                String clipBoardContent = UtilHelper.getClipBoardContent();
                if (!StringUtils.isNull(clipBoardContent) && clipBoardContent.startsWith("#bdtiebalive://") && clipBoardContent.endsWith("#")) {
                    AlaLiveSdkStatic.l();
                    d.a.c.e.m.e.a().postDelayed(new RunnableC0190a(this), 1000L);
                }
            }
        }

        public o(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.a.c.e.m.e.a().postDelayed(new a(this), 100L);
        }
    }

    static {
        r();
        p();
        q();
        w();
        u();
        d.a.n0.f1.c.b(AlaCmdConfigSocket.ALA_SOCKET_PUSH_ALERT, ALAPushAlertResponsedMessage.class, false);
        TbadkCoreApplication.getInst().RegisterIntent(AlaSDKShareEmptyActivityConfig.class, AlaSDKShareEmptyActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(AlaWriteShareInBarActivityConfig.class, AlaShareInBarEmptyActivity.class);
        v();
        t();
        x();
        y();
        f18033b = new m(2921406);
        f18034c = new n(2001115);
        f18035d = new o(2007002);
    }

    public static String k(HashMap<String, Object> hashMap) {
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

    public static void l() {
        try {
            if (f18032a) {
                return;
            }
            new d.a.n0.n1.j.b().b("0");
            f18032a = true;
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }

    public static void m(TbPageContext tbPageContext, int i2, String str, JSONObject jSONObject, String str2) {
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

    public static void n() {
        String clipBoardContent = UtilHelper.getClipBoardContent();
        if (!StringUtils.isNull(clipBoardContent) && clipBoardContent.startsWith("#bdtiebalive://") && clipBoardContent.endsWith("#")) {
            String replace = clipBoardContent.replace("#", "");
            if (!AlaLiveRoomActivityConfig.isAlreadyEnterLiveRoom) {
                UrlManager.getInstance().dealOneLink((TbPageContext) d.a.c.a.j.a(TbadkCoreApplication.getInst().getCurrentActivity()), new String[]{replace});
            }
            UtilHelper.clearClipBoard();
        }
    }

    public static String o(String str) {
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

    public static void p() {
        UrlManager.getInstance().addListener(new d());
    }

    public static void q() {
        UrlManager.getInstance().addListener(new c());
    }

    public static void r() {
        UrlManager.getInstance().addListener(new b());
    }

    public static void s() {
        MessageManager.getInstance().registerListener(new g(2921545));
    }

    public static void t() {
        d.a.c.e.m.e.a().post(new k());
    }

    public static void u() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921431, new e());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static void v() {
        d.a.c.e.m.e.a().post(new a());
    }

    public static void w() {
        MessageManager.getInstance().addMessageRule(new f(2002001));
    }

    public static void x() {
        d.a.c.e.m.e.a().post(new l());
    }

    public static void y() {
        d.a.c.e.m.e.a().post(new j());
    }

    public static void z() {
        MessageManager.getInstance().registerListener(new h(2921549));
        CustomMessageTask customMessageTask = new CustomMessageTask(2921548, new i());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}

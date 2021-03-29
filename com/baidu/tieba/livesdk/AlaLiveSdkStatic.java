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
import d.b.h0.z0.n0;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaLiveSdkStatic {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f18757a = false;

    /* renamed from: b  reason: collision with root package name */
    public static CustomMessageListener f18758b;

    /* renamed from: c  reason: collision with root package name */
    public static CustomMessageListener f18759c;

    /* renamed from: d  reason: collision with root package name */
    public static CustomMessageListener f18760d;

    /* loaded from: classes3.dex */
    public static class a implements CustomMessageTask.CustomRunnable<Object> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            return new CustomResponsedMessage<>(2921431);
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends d.b.b.c.f.b {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.c.f.f
        public CustomMessage<?> process(CustomMessage<?> customMessage, CustomMessageTask customMessageTask) {
            if (customMessage != null && (customMessage.getData() instanceof AlaLiveRoomActivityConfig)) {
                AlaLiveSdkStatic.j();
                AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = (AlaLiveRoomActivityConfig) customMessage.getData();
                Intent intent = alaLiveRoomActivityConfig.getIntent();
                d.b.i0.l1.a.j(alaLiveRoomActivityConfig.getContext(), intent.getStringExtra(AlaLiveRoomActivityConfig.LIVE_FROM_TYPE), (AlaLiveInfoCoreData) intent.getSerializableExtra("live_info_core"));
                return null;
            } else if (customMessage != null && (customMessage.getData() instanceof AlaMasterLiveRoomActivityConfig)) {
                AlaLiveSdkStatic.j();
                d.b.i0.l1.a.a(((AlaMasterLiveRoomActivityConfig) customMessage.getData()).getContext());
                return null;
            } else if (customMessage != null && (customMessage.getData() instanceof AlaAdminListActivityConfig)) {
                AlaLiveSdkStatic.j();
                d.b.i0.l1.a.e(((AlaAdminListActivityConfig) customMessage.getData()).getContext());
                return null;
            } else if (customMessage != null && (customMessage.getData() instanceof AlaFansFamilyActivityConfig)) {
                AlaLiveSdkStatic.j();
                AlaFansFamilyActivityConfig alaFansFamilyActivityConfig = (AlaFansFamilyActivityConfig) customMessage.getData();
                d.b.i0.l1.a.g(alaFansFamilyActivityConfig.getContext(), alaFansFamilyActivityConfig.getIntent().getStringExtra("author_live_user_id"), -1);
                return null;
            } else if (customMessage != null && (customMessage.getData() instanceof AlaForbiddenListActivityConfig)) {
                AlaLiveSdkStatic.j();
                d.b.i0.l1.a.h(((AlaForbiddenListActivityConfig) customMessage.getData()).getContext());
                return null;
            } else if (customMessage != null && (customMessage.getData() instanceof AlaLoveFamilyActivityConfig)) {
                AlaLiveSdkStatic.j();
                d.b.i0.l1.a.k(((AlaLoveFamilyActivityConfig) customMessage.getData()).getContext());
                return null;
            } else if (customMessage != null && (customMessage.getData() instanceof AlaPersonCenterExpActivityConfig)) {
                AlaLiveSdkStatic.j();
                AlaPersonCenterExpActivityConfig alaPersonCenterExpActivityConfig = (AlaPersonCenterExpActivityConfig) customMessage.getData();
                Intent intent2 = alaPersonCenterExpActivityConfig.getIntent();
                d.b.i0.l1.a.f(alaPersonCenterExpActivityConfig.getContext(), intent2.getLongExtra(AlaPersonCenterExpActivityConfig.CURRENT_EXP, 0L), intent2.getIntExtra("current_level", 0));
                return null;
            } else if (customMessage == null || !(customMessage.getData() instanceof AlaPersonCenterRealAuthenConfig)) {
                return customMessage;
            } else {
                AlaLiveSdkStatic.j();
                AlaPersonCenterRealAuthenConfig alaPersonCenterRealAuthenConfig = (AlaPersonCenterRealAuthenConfig) customMessage.getData();
                Intent intent3 = alaPersonCenterRealAuthenConfig.getIntent();
                d.b.i0.l1.a.m(alaPersonCenterRealAuthenConfig.getContext(), intent3.getStringExtra(AlaPersonCenterRealAuthenConfig.REAL_AUTHEN_USER_ID), intent3.getStringExtra(AlaPersonCenterRealAuthenConfig.REAL_AUTHEN_CERTIFY_STATUS));
                return null;
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            MessageManager.getInstance().registerListener(AlaLiveSdkStatic.f18759c);
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            MessageManager.getInstance().registerListener(AlaLiveSdkStatic.f18758b);
        }
    }

    /* loaded from: classes3.dex */
    public static class e extends CustomMessageListener {
        public e(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof ShareEvent)) {
                return;
            }
            long f2 = d.b.b.e.m.b.f(((ShareEvent) customResponsedMessage.getData()).extLiveInfo, 0L);
            if (f2 > 0) {
                d.b.i0.l1.a.p(f2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class f extends CustomMessageListener {
        public f(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() == null || StringUtils.isNull(updateAttentionMessage.getData().f13695c) || !updateAttentionMessage.getData().f13693a) {
                    return;
                }
                AlaLiveSdkStatic.j();
                d.b.i0.l1.a.o(updateAttentionMessage.getData().f13695c, updateAttentionMessage.getData().l != 0);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class g extends CustomMessageListener {

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: com.baidu.tieba.livesdk.AlaLiveSdkStatic$g$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class RunnableC0203a implements Runnable {
                public RunnableC0203a(a aVar) {
                }

                @Override // java.lang.Runnable
                public void run() {
                    AlaLiveSdkStatic.l();
                }
            }

            public a(g gVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
                String clipBoardContent = UtilHelper.getClipBoardContent();
                if (!StringUtils.isNull(clipBoardContent) && clipBoardContent.startsWith("#bdtiebalive://") && clipBoardContent.endsWith("#")) {
                    AlaLiveSdkStatic.j();
                    d.b.b.e.m.e.a().postDelayed(new RunnableC0203a(this), 1000L);
                }
            }
        }

        public g(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.b.b.e.m.e.a().postDelayed(new a(this), 100L);
        }
    }

    /* loaded from: classes3.dex */
    public static class h implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            MessageManager.getInstance().registerListener(AlaLiveSdkStatic.f18760d);
        }
    }

    /* loaded from: classes3.dex */
    public static class i implements UrlManager.UrlDealListener {
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
                alaLiveInfoCoreData.liveID = d.b.b.e.m.b.f(paramPair.get(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID), 0L);
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
    public static class j implements UrlManager.UrlDealListener {

        /* loaded from: classes3.dex */
        public class a implements d.b.i0.l1.j.a {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ TbPageContext f18761a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f18762b;

            public a(j jVar, TbPageContext tbPageContext, String str) {
                this.f18761a = tbPageContext;
                this.f18762b = str;
            }

            @Override // d.b.i0.l1.j.a
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
                    AlaLiveSdkStatic.k(this.f18761a, optInt, optString, jSONObject2, this.f18762b);
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
            AlaLiveSdkStatic.j();
            if (strArr[0].contains(UrlSchemaHelper.GO_TO_MIX_LIVE)) {
                String d2 = n0.d(strArr[0], "url");
                if ("video/mixlive".equals(AlaLiveSdkStatic.m(d2))) {
                    Uri parse = Uri.parse(d2);
                    HashMap hashMap = new HashMap();
                    for (String str : parse.getQueryParameterNames()) {
                        hashMap.put(str, parse.getQueryParameter(str));
                    }
                    d.b.i0.p1.a.h().r(tbPageContext.getPageActivity(), (String) hashMap.get("room_id"), (String) hashMap.get("source"), AlaLiveSdkStatic.i(hashMap), parse);
                    return 0;
                }
            }
            if (strArr[0].startsWith("bdtiebalive://deeplink")) {
                if ("deeplink".equals(AlaLiveSdkStatic.m(strArr[0]))) {
                    d.b.i0.z.e eVar = new d.b.i0.z.e(strArr[0]);
                    d.b.i0.z.b.a(tbPageContext.getPageActivity(), eVar.d(), eVar.a(), false);
                }
                return 0;
            }
            if (strArr[0].startsWith("bdtiebalive://webview") && "webview".equals(AlaLiveSdkStatic.m(strArr[0]))) {
                String b2 = new d.b.i0.z.e(strArr[0]).b("url_key");
                if (!TextUtils.isEmpty(b2)) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) d.b.b.a.j.a(tbPageContext.getPageActivity()), new String[]{b2});
                    return 0;
                }
            }
            if (strArr[0].startsWith("bdtiebalive://video/live")) {
                Uri parse2 = Uri.parse(strArr[0]);
                HashMap hashMap2 = new HashMap();
                for (String str2 : parse2.getQueryParameterNames()) {
                    hashMap2.put(str2, parse2.getQueryParameter(str2));
                }
                if (strArr[0].startsWith("bdtiebalive:video/live/tbean")) {
                    String str3 = (String) hashMap2.get("callback");
                    d.b.i0.l1.m.a aVar = new d.b.i0.l1.m.a();
                    aVar.f56736a = str3;
                    aVar.f56738c = (String) hashMap2.get("is_translucent");
                    aVar.f56737b = TextUtils.equals((String) hashMap2.get("is_translucent"), "1");
                    d.b.i0.l1.a.d(tbPageContext.getPageActivity(), aVar, new a(this, tbPageContext, str3));
                } else if (strArr[0].startsWith("bdtiebalive://video/live/start")) {
                    d.b.i0.l1.a.b(tbPageContext.getPageActivity(), strArr[0], hashMap2);
                } else if (strArr[0].startsWith("bdtiebalive://video/live/admin")) {
                    d.b.i0.l1.a.e(tbPageContext.getPageActivity());
                } else if (strArr[0].startsWith("bdtiebalive://video/live/forbidden")) {
                    d.b.i0.l1.a.h(tbPageContext.getPageActivity());
                } else if (!strArr[0].startsWith("bdtiebalive://video/live/exp") && !strArr[0].startsWith("bdtiebalive://video/live/experience")) {
                    if (strArr[0].startsWith("bdtiebalive://video/live/guardian")) {
                        d.b.i0.l1.a.i(tbPageContext.getPageActivity(), (String) hashMap2.get("value"), (String) hashMap2.get("uid"));
                    } else if (strArr[0].startsWith("bdtiebalive://video/live/fans")) {
                        d.b.i0.l1.a.g(tbPageContext.getPageActivity(), null, 0);
                    } else if (strArr[0].startsWith("bdtiebalive://video/live/patrons")) {
                        d.b.i0.l1.a.l(tbPageContext.getPageActivity(), (String) hashMap2.get("userId"));
                    } else if (strArr[0].startsWith("bdtiebalive://video/live/patronage")) {
                        d.b.i0.l1.a.k(tbPageContext.getPageActivity());
                    } else if (strArr[0].startsWith("bdtiebalive://video/live/realAuthen")) {
                        d.b.i0.l1.a.m(tbPageContext.getPageActivity(), (String) hashMap2.get("userId"), (String) hashMap2.get("certifyStatus"));
                    } else {
                        d.b.i0.l1.a.c(tbPageContext.getPageActivity(), strArr[0], hashMap2);
                    }
                } else {
                    d.b.i0.l1.a.f(tbPageContext.getPageActivity(), hashMap2.get("exp") == null ? -1L : ((Long) hashMap2.get("exp")).longValue(), hashMap2.get("level") == null ? -1 : ((Integer) hashMap2.get("level")).intValue());
                }
                return 0;
            }
            return 3;
        }
    }

    /* loaded from: classes3.dex */
    public static class k implements UrlManager.UrlDealListener {
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
                            alaLiveInfoCoreData.liveID = d.b.b.e.m.b.f(str2, 0L);
                            alaLiveInfoCoreData.userName = str3;
                            alaLiveInfoCoreData.rtmpUrl = str4;
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_OUTSIDE, null, false, null)));
                        } catch (UnsupportedEncodingException e2) {
                            e2.printStackTrace();
                        }
                        return 0;
                    }
                } else if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_JUMP_LIVE_ROOM)) {
                    long f2 = d.b.b.e.m.b.f(n0.c(str, "liveId="), 0L);
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

    static {
        p();
        n();
        o();
        t();
        r();
        d.b.i0.d1.c.b(AlaCmdConfigSocket.ALA_SOCKET_PUSH_ALERT, ALAPushAlertResponsedMessage.class, false);
        TbadkCoreApplication.getInst().RegisterIntent(AlaSDKShareEmptyActivityConfig.class, AlaSDKShareEmptyActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(AlaWriteShareInBarActivityConfig.class, AlaShareInBarEmptyActivity.class);
        s();
        q();
        u();
        f18758b = new e(2921406);
        f18759c = new f(2001115);
        f18760d = new g(2007002);
    }

    public static String i(HashMap<String, Object> hashMap) {
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

    public static void j() {
        try {
            if (f18757a) {
                return;
            }
            new d.b.i0.l1.i.b().b("0");
            f18757a = true;
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }

    public static void k(TbPageContext tbPageContext, int i2, String str, JSONObject jSONObject, String str2) {
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

    public static void l() {
        String clipBoardContent = UtilHelper.getClipBoardContent();
        if (!StringUtils.isNull(clipBoardContent) && clipBoardContent.startsWith("#bdtiebalive://") && clipBoardContent.endsWith("#")) {
            String replace = clipBoardContent.replace("#", "");
            if (!AlaLiveRoomActivityConfig.isAlreadyEnterLiveRoom) {
                UrlManager.getInstance().dealOneLink((TbPageContext) d.b.b.a.j.a(TbadkCoreApplication.getInst().getCurrentActivity()), new String[]{replace});
            }
            UtilHelper.clearClipBoard();
        }
    }

    public static String m(String str) {
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

    public static void n() {
        UrlManager.getInstance().addListener(new k());
    }

    public static void o() {
        UrlManager.getInstance().addListener(new j());
    }

    public static void p() {
        UrlManager.getInstance().addListener(new i());
    }

    public static void q() {
        d.b.b.e.m.e.a().post(new c());
    }

    public static void r() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921431, new a());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static void s() {
        d.b.b.e.m.e.a().post(new h());
    }

    public static void t() {
        MessageManager.getInstance().addMessageRule(new b(2002001));
    }

    public static void u() {
        d.b.b.e.m.e.a().post(new d());
    }
}

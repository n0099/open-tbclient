package com.baidu.tieba.sdk.d;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.base.BdPageContextCreator;
import com.baidu.live.adp.base.IScrollableHelper;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.framework.message.Message;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.adp.lib.image.loader.ImageLoaderManager;
import com.baidu.live.adp.lib.image.loader.interfaces.IImageLoaderBuilder;
import com.baidu.live.adp.lib.network.http.BdNetWorkManager;
import com.baidu.live.adp.lib.network.http.interfaces.INetWorkBuilder;
import com.baidu.live.adp.lib.safe.SafeHandler;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.adp.widget.ICustomToast;
import com.baidu.live.d.m;
import com.baidu.live.d.q;
import com.baidu.live.d.y;
import com.baidu.live.data.AlaLiveStreamSessionInfo;
import com.baidu.live.data.bk;
import com.baidu.live.message.AlaSyncHttpResponseMessage;
import com.baidu.live.message.LiveSyncHttpResponseMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.ala.zan.BdZanViewCreater;
import com.baidu.live.tbadk.ala.zan.IAlaBdZanBuilder;
import com.baidu.live.tbadk.ar.LoadARSDKCallBack;
import com.baidu.live.tbadk.attention.AttentionStatusSyncManager;
import com.baidu.live.tbadk.attention.IAttentionStatusCallBack;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaLiveRoomActivityConfig;
import com.baidu.live.tbadk.core.atomdata.AlaMasterLiveRoomActivityConfig;
import com.baidu.live.tbadk.core.atomdata.BuyTBeanActivityConfig;
import com.baidu.live.tbadk.core.atomdata.CommonWebViewActivityConfig;
import com.baidu.live.tbadk.core.atomdata.FaceRecognitionActivityConfig;
import com.baidu.live.tbadk.core.atomdata.GuardClubInfoActivityConfig;
import com.baidu.live.tbadk.core.atomdata.GuardClubJoinListActivityConfig;
import com.baidu.live.tbadk.core.atomdata.YuyinAlaLiveRoomActivityConfig;
import com.baidu.live.tbadk.core.atomdata.YuyinAlaMasterLiveRoomActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UrlManager;
import com.baidu.live.tbadk.coreextra.message.UpdateAttentionMessage;
import com.baidu.live.tbadk.extrajump.ExtraJumpManager;
import com.baidu.live.tbadk.extrajump.interfaces.IExtraJumpBuilder;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.extraparams.interfaces.IExtraParams;
import com.baidu.live.tbadk.extraparams.interfaces.IExtraParamsBuilder;
import com.baidu.live.tbadk.load.library.IFaceUnityCallBack;
import com.baidu.live.tbadk.load.library.LoadLibraryManager;
import com.baidu.live.tbadk.location.LocationManager;
import com.baidu.live.tbadk.location.interfaces.ILocationBuilder;
import com.baidu.live.tbadk.pay.channel.PayChannelManager;
import com.baidu.live.tbadk.pay.channel.interfaces.IPayChannelBuilder;
import com.baidu.live.tbadk.pay.channel.interfaces.PayChannelType;
import com.baidu.live.tbadk.scheme.SchemeCallback;
import com.baidu.live.tbadk.scheme.SchemeUtils;
import com.baidu.live.tbadk.share.single.ShareSingleManager;
import com.baidu.live.tbadk.share.single.interfaces.IShareChannelBuild;
import com.baidu.live.tbadk.util.HostResourceManager;
import com.baidu.live.tbadk.util.IResourceAdapter;
import com.baidu.searchbox.live.base.LiveBaseActivity;
import com.baidu.tieba.sdk.activity.CommonWebViewActivity;
import com.baidu.tieba.sdk.activity.LivePlayerActivity;
import com.baidu.tieba.sdk.activity.YuyinLivePlayerActivity;
import com.baidu.tieba.sdk.b.c;
import com.baidu.tieba.sdk.b.d;
import com.baidu.tieba.sdk.b.e;
import com.baidu.tieba.sdk.b.f;
import com.baidu.tieba.sdk.b.g;
import com.baidu.tieba.sdk.f.b;
import com.baidu.tieba.sdk.f.h;
import com.baidu.tieba.sdk.f.i;
import com.baidu.tieba.sdk.f.j;
import com.baidu.tieba.sdk.f.k;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a implements BdPageContextCreator {
    private static a mXY = null;
    private d mXZ;
    private c mYa;
    private g mYb;
    private d mYc;
    private e mYd;
    private f mYe;
    private BdUniqueId mYf;
    private BdUniqueId mYg;
    private BdUniqueId mYh;
    private String mYi;
    private HttpMessageListener syncListener = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SYNC) { // from class: com.baidu.tieba.sdk.d.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021011 && (httpResponsedMessage instanceof AlaSyncHttpResponseMessage)) {
                AlaSyncHttpResponseMessage alaSyncHttpResponseMessage = (AlaSyncHttpResponseMessage) httpResponsedMessage;
                if (alaSyncHttpResponseMessage.getError() == 0) {
                    Message<?> orginalMessage = alaSyncHttpResponseMessage.getOrginalMessage();
                    if (orginalMessage != null && orginalMessage.getTag() != null && orginalMessage.getTag().equals(a.this.mYh) && alaSyncHttpResponseMessage.QQ() != null && alaSyncHttpResponseMessage.QQ().aOY != null && !TextUtils.isEmpty(alaSyncHttpResponseMessage.QQ().aOY.aQt)) {
                        a.dHb().br(TbadkCoreApplication.getInst(), alaSyncHttpResponseMessage.QQ().aOY.aQt);
                    } else if (orginalMessage != null && orginalMessage.getTag() != null && orginalMessage.getTag().equals(a.this.mYg) && com.baidu.live.af.a.SE().SF()) {
                        a.this.bm(null, a.this.mYi);
                    }
                }
            }
        }
    };
    private HttpMessageListener bCe = new HttpMessageListener(1021132) { // from class: com.baidu.tieba.sdk.d.a.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021132 && (httpResponsedMessage instanceof LiveSyncHttpResponseMessage)) {
                LiveSyncHttpResponseMessage liveSyncHttpResponseMessage = (LiveSyncHttpResponseMessage) httpResponsedMessage;
                if (liveSyncHttpResponseMessage.getError() == 0) {
                    Message<?> orginalMessage = liveSyncHttpResponseMessage.getOrginalMessage();
                    if (orginalMessage != null && orginalMessage.getTag() != null && orginalMessage.getTag().equals(a.this.mYf) && liveSyncHttpResponseMessage.QV() != null && liveSyncHttpResponseMessage.QV().aRH != null && !TextUtils.isEmpty(liveSyncHttpResponseMessage.QV().aRH.aSX)) {
                        a.dHb().br(TbadkCoreApplication.getInst(), liveSyncHttpResponseMessage.QV().aRH.aSX);
                    } else if (orginalMessage != null && orginalMessage.getTag() != null && orginalMessage.getTag().equals(a.this.mYg) && com.baidu.live.af.a.SE().SF()) {
                        a.this.bm(null, a.this.mYi);
                    }
                }
            }
        }
    };

    private a() {
    }

    public static a dHb() {
        a aVar;
        if (mXY != null) {
            return mXY;
        }
        synchronized (a.class) {
            if (mXY == null) {
                mXY = new a();
            }
            aVar = mXY;
        }
        return aVar;
    }

    public void setAppId(String str) {
        TbConfig.setSubappType(str);
        TbConfig.setTempDirName("tblive_" + str);
    }

    public void setPackageName(String str) {
        TbConfig.PACKAGE_NAME = str;
    }

    public static void Sk(String str) {
        TbConfig.FILE_PROVIDER_AUTHORITIES = str;
    }

    public static void Sl(String str) {
        TbConfig.FILE_OUTPUT_FILE_ROOT_PATH = str;
    }

    public void c(Application application) {
        TbadkCoreApplication.IS_SDK = true;
        TbConfig.setVersion("9.6.8.1");
        IScrollableHelper.defaultPageContextCreater = this;
        TbadkCoreApplication.getInst().onCreate(application);
        dHd();
        dHe();
        dHf();
        dHm();
        dHn();
        dHo();
        dHp();
        dHc();
        if (com.baidu.live.ar.c.aFi != null) {
            com.baidu.live.ar.c.aFi.init(application);
        }
    }

    private void dHc() {
        SchemeUtils.putCustomSchemePath("video/live", com.baidu.tieba.sdk.f.a.class);
        SchemeUtils.putCustomSchemePath("video/live/start", j.class);
        SchemeUtils.putCustomSchemePath("video/live/admin", b.class);
        SchemeUtils.putCustomSchemePath("video/live/forbidden", com.baidu.tieba.sdk.f.e.class);
        SchemeUtils.putCustomSchemePath("video/live/exp", com.baidu.tieba.sdk.f.c.class);
        SchemeUtils.putCustomSchemePath("video/live/experience", com.baidu.tieba.sdk.f.c.class);
        SchemeUtils.putCustomSchemePath("video/live/guardian", com.baidu.tieba.sdk.f.f.class);
        SchemeUtils.putCustomSchemePath("video/live/fans", com.baidu.tieba.sdk.f.d.class);
        SchemeUtils.putCustomSchemePath("video/live/tbean", k.class);
        SchemeUtils.putCustomSchemePath("video/live/patronage", com.baidu.tieba.sdk.f.g.class);
        SchemeUtils.putCustomSchemePath("video/live/patrons", h.class);
        SchemeUtils.putCustomSchemePath("video/live/realAuthen", i.class);
    }

    private void dHd() {
        MessageManager.getInstance().addMessageRule(new com.baidu.tieba.sdk.a.a(0));
    }

    private void dHe() {
        MessageManager.getInstance().addResponsedMessageRule(new com.baidu.tieba.sdk.util.c(0));
    }

    private void dHf() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_ADD_FRAGMENT, null));
    }

    public void dGY() {
        if (TbadkCoreApplication.getInst().getContext() != null) {
            com.baidu.live.af.a.SE().SG();
            com.baidu.tieba.sdk.login.a.dHq().dHr();
        }
    }

    public void dGZ() {
        if (TbadkCoreApplication.getInst().getContext() != null) {
            dHa();
        }
    }

    public com.baidu.tieba.sdk.e.a a(LiveBaseActivity liveBaseActivity) {
        return new com.baidu.tieba.sdk.e.a(liveBaseActivity);
    }

    public com.baidu.tieba.sdk.e.d b(LiveBaseActivity liveBaseActivity) {
        return new com.baidu.tieba.sdk.e.d(liveBaseActivity);
    }

    public void c(Context context, String str, boolean z, String str2, JSONObject jSONObject) {
        if (!TbadkCoreApplication.getInst().isRegistedIntent(YuyinAlaLiveRoomActivityConfig.class)) {
            TbadkCoreApplication.getInst().RegisterIntent(YuyinAlaLiveRoomActivityConfig.class, YuyinLivePlayerActivity.class);
        }
        if (!TextUtils.isEmpty(str)) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("recommend_type", z ? 0 : 1);
                jSONObject2.put("open_giftlist", str2);
                if (jSONObject != null) {
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        jSONObject2.put(next, jSONObject.opt(next));
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            String jSONObject3 = jSONObject2.toString();
            YuyinAlaLiveRoomActivityConfig yuyinAlaLiveRoomActivityConfig = new YuyinAlaLiveRoomActivityConfig(context);
            yuyinAlaLiveRoomActivityConfig.addExtraByRoomId(str, jSONObject3);
            yuyinAlaLiveRoomActivityConfig.setNeedStopImWhenClose(true);
            if (!(context instanceof Activity)) {
                yuyinAlaLiveRoomActivityConfig.getIntent().addFlags(268435456);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, yuyinAlaLiveRoomActivityConfig));
        }
    }

    public void b(Context context, long j, boolean z, String str, JSONObject jSONObject) {
        if (!TbadkCoreApplication.getInst().isRegistedIntent(YuyinAlaLiveRoomActivityConfig.class)) {
            TbadkCoreApplication.getInst().RegisterIntent(YuyinAlaLiveRoomActivityConfig.class, YuyinLivePlayerActivity.class);
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("recommend_type", z ? 0 : 1);
            jSONObject2.put("open_giftlist", str);
            if (jSONObject != null) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject2.put(next, jSONObject.opt(next));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String jSONObject3 = jSONObject2.toString();
        YuyinAlaLiveRoomActivityConfig yuyinAlaLiveRoomActivityConfig = new YuyinAlaLiveRoomActivityConfig(context);
        yuyinAlaLiveRoomActivityConfig.addExtraByLiveId(j, jSONObject3);
        yuyinAlaLiveRoomActivityConfig.setNeedStopImWhenClose(true);
        if (!(context instanceof Activity)) {
            yuyinAlaLiveRoomActivityConfig.getIntent().addFlags(268435456);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, yuyinAlaLiveRoomActivityConfig));
    }

    public void d(Context context, String str, boolean z, String str2, JSONObject jSONObject) {
        if (!TbadkCoreApplication.getInst().isRegistedIntent(YuyinAlaLiveRoomActivityConfig.class)) {
            TbadkCoreApplication.getInst().RegisterIntent(YuyinAlaLiveRoomActivityConfig.class, YuyinLivePlayerActivity.class);
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("recommend_type", z ? 0 : 1);
            jSONObject2.put("open_giftlist", str2);
            if (jSONObject != null) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject2.put(next, jSONObject.opt(next));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String jSONObject3 = jSONObject2.toString();
        YuyinAlaLiveRoomActivityConfig yuyinAlaLiveRoomActivityConfig = new YuyinAlaLiveRoomActivityConfig(context);
        yuyinAlaLiveRoomActivityConfig.addExtraByParams(jSONObject3);
        yuyinAlaLiveRoomActivityConfig.addExtraByUrl("", str, "");
        yuyinAlaLiveRoomActivityConfig.setNeedStopImWhenClose(true);
        if (!(context instanceof Activity)) {
            yuyinAlaLiveRoomActivityConfig.getIntent().addFlags(268435456);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, yuyinAlaLiveRoomActivityConfig));
    }

    public void a(Context context, String str, boolean z, String str2, JSONObject jSONObject) {
        boolean z2 = false;
        if (TbadkCoreApplication.getInst().getContext() != null) {
            if (!TbadkCoreApplication.getInst().isRegistedIntent(AlaLiveRoomActivityConfig.class)) {
                TbadkCoreApplication.getInst().RegisterIntent(AlaLiveRoomActivityConfig.class, LivePlayerActivity.class);
            }
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("recommend_type", z ? 0 : 1);
                    jSONObject2.put("open_giftlist", str2);
                    if (jSONObject != null) {
                        Iterator<String> keys = jSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            jSONObject2.put(next, jSONObject.opt(next));
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                String str3 = null;
                if (jSONObject != null) {
                    str3 = jSONObject.optString("extra");
                }
                if (!TextUtils.isEmpty(str3)) {
                    try {
                        z2 = "1".equals(new JSONObject(str3).optString(AlaLiveRoomActivityConfig.SDK_EXTRA_FROM_FLOATING));
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                String jSONObject3 = jSONObject2.toString();
                AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(context);
                alaLiveRoomActivityConfig.addExtraByRoomId(str, jSONObject3);
                alaLiveRoomActivityConfig.setNeedStopImWhenClose(true);
                if (!(context instanceof Activity)) {
                    alaLiveRoomActivityConfig.getIntent().addFlags(268435456);
                }
                if (z2) {
                    alaLiveRoomActivityConfig.getIntent().addFlags(131072);
                    alaLiveRoomActivityConfig.getIntent().addFlags(536870912);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaLiveRoomActivityConfig));
            }
        }
    }

    public void a(Context context, long j, boolean z, String str, JSONObject jSONObject) {
        if (TbadkCoreApplication.getInst().getContext() != null) {
            if (!TbadkCoreApplication.getInst().isRegistedIntent(AlaLiveRoomActivityConfig.class)) {
                TbadkCoreApplication.getInst().RegisterIntent(AlaLiveRoomActivityConfig.class, LivePlayerActivity.class);
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("recommend_type", z ? 0 : 1);
                jSONObject2.put("open_giftlist", str);
                if (jSONObject != null) {
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        jSONObject2.put(next, jSONObject.opt(next));
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            String jSONObject3 = jSONObject2.toString();
            AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(context);
            alaLiveRoomActivityConfig.addExtraByLiveId(j, jSONObject3);
            alaLiveRoomActivityConfig.setNeedStopImWhenClose(true);
            if (!(context instanceof Activity)) {
                alaLiveRoomActivityConfig.getIntent().addFlags(268435456);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaLiveRoomActivityConfig));
        }
    }

    public void b(Context context, String str, boolean z, String str2, JSONObject jSONObject) {
        if (TbadkCoreApplication.getInst().getContext() != null) {
            if (!TbadkCoreApplication.getInst().isRegistedIntent(AlaLiveRoomActivityConfig.class)) {
                TbadkCoreApplication.getInst().RegisterIntent(AlaLiveRoomActivityConfig.class, LivePlayerActivity.class);
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("recommend_type", z ? 0 : 1);
                jSONObject2.put("open_giftlist", str2);
                if (jSONObject != null) {
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        jSONObject2.put(next, jSONObject.opt(next));
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            String jSONObject3 = jSONObject2.toString();
            AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(context);
            alaLiveRoomActivityConfig.addExtraByParams(jSONObject3);
            alaLiveRoomActivityConfig.addExtraByUrl("", str, "");
            alaLiveRoomActivityConfig.setNeedStopImWhenClose(true);
            if (!(context instanceof Activity)) {
                alaLiveRoomActivityConfig.getIntent().addFlags(268435456);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaLiveRoomActivityConfig));
        }
    }

    public void bh(final Context context, final String str) {
        if (TbadkCoreApplication.getInst().getContext() != null) {
            if (!TbadkCoreApplication.getInst().isHaokan()) {
                bl(context, str);
            } else if (com.baidu.live.ar.c.aFi != null) {
                com.baidu.live.ar.c.aFi.loadSDK(new LoadARSDKCallBack() { // from class: com.baidu.tieba.sdk.d.a.1
                    @Override // com.baidu.live.tbadk.ar.LoadARSDKCallBack
                    public void onResult(boolean z, String str2) {
                        if (z) {
                            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.tieba.sdk.d.a.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    a.this.bl(context, str);
                                }
                            });
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bl(Context context, String str) {
        com.baidu.tieba.sdk.login.a.dHq().dHs();
        if (com.baidu.live.af.a.SE().SF() && com.baidu.live.af.a.SE().bCb != null && com.baidu.live.af.a.SE().bCb.aRz != null) {
            bm(context, str);
            return;
        }
        this.mYi = str;
        MessageManager.getInstance().registerListener(this.bCe);
        MessageManager.getInstance().registerListener(this.syncListener);
        this.mYg = BdUniqueId.gen();
        com.baidu.live.af.a.SE().e(this.mYg);
        com.baidu.live.af.a.SE().d(this.mYg);
    }

    public void bg(Context context, String str) {
        com.baidu.tieba.sdk.login.a.dHq().dHs();
        bn(context, str);
    }

    public void bm(Context context, String str) {
        if (TbadkCoreApplication.getInst().getContext() != null) {
            bq(context, str);
            this.mYi = null;
        }
    }

    public void bn(Context context, String str) {
        bp(context, str);
        this.mYi = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BuyTBeanActivityConfig bo(Context context, String str) {
        String str2;
        String str3;
        boolean z = false;
        try {
            if (TextUtils.isEmpty(str)) {
                str3 = null;
                str2 = null;
            } else {
                JSONObject jSONObject = new JSONObject(str);
                str2 = jSONObject.optString(BuyTBeanActivityConfig.CALLBACK);
                try {
                    z = jSONObject.optBoolean("isTranslucent");
                    str3 = jSONObject.optString("from");
                } catch (JSONException e) {
                    e = e;
                    e.printStackTrace();
                    str3 = null;
                    BuyTBeanActivityConfig buyTBeanActivityConfig = new BuyTBeanActivityConfig(context, 0L, true);
                    if (!TextUtils.isEmpty(str2)) {
                    }
                    if (!TextUtils.isEmpty(str3)) {
                    }
                    buyTBeanActivityConfig.setIsTranslucent(z);
                    return buyTBeanActivityConfig;
                }
            }
        } catch (JSONException e2) {
            e = e2;
            str2 = null;
        }
        BuyTBeanActivityConfig buyTBeanActivityConfig2 = new BuyTBeanActivityConfig(context, 0L, true);
        if (!TextUtils.isEmpty(str2)) {
            buyTBeanActivityConfig2.setCallback(str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            buyTBeanActivityConfig2.setFrom(str3);
        }
        buyTBeanActivityConfig2.setIsTranslucent(z);
        return buyTBeanActivityConfig2;
    }

    public void Sm(String str) {
        if (TbadkCoreApplication.getInst().getContext() != null) {
            com.baidu.tieba.sdk.login.a.dHq().dHr();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, bo(TbadkCoreApplication.getInst(), str)));
        }
    }

    public void a(com.baidu.tieba.sdk.b.a aVar) {
        com.baidu.tieba.sdk.login.a.dHq().b(aVar);
    }

    public void a(d dVar) {
        this.mXZ = dVar;
    }

    public d dHg() {
        return this.mXZ;
    }

    public void b(d dVar) {
        this.mYc = dVar;
    }

    public d dHh() {
        return this.mYc;
    }

    public void a(c cVar) {
        this.mYa = cVar;
    }

    public c dHi() {
        return this.mYa;
    }

    public g dHj() {
        return this.mYb;
    }

    public void a(e eVar) {
        this.mYd = eVar;
    }

    public void hy(long j) {
        if (TbadkCoreApplication.getInst().getContext() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_RES_ZIP_DOWNLOADED_STATUS, Long.valueOf(j)));
        }
    }

    public e dHk() {
        return this.mYd;
    }

    public void a(final com.baidu.tieba.sdk.b.b bVar) {
        if (bVar != null) {
            LoadLibraryManager.getInstance().setFaceUnityCallBack(new IFaceUnityCallBack() { // from class: com.baidu.tieba.sdk.d.a.2
                @Override // com.baidu.live.tbadk.load.library.IFaceUnityCallBack
                public byte[] getAuthPackCert() {
                    return bVar.getAuthPackCert();
                }

                @Override // com.baidu.live.tbadk.load.library.IFaceUnityCallBack
                public byte[] getFaceBeautificationData() {
                    return bVar.getFaceBeautificationData();
                }

                @Override // com.baidu.live.tbadk.load.library.IFaceUnityCallBack
                public byte[] getV3Data() {
                    return bVar.getV3Data();
                }
            });
        }
    }

    public void a(f fVar) {
        this.mYe = fVar;
    }

    public f dHl() {
        return this.mYe;
    }

    private void bp(Context context, String str) {
        if (TbadkCoreApplication.isLogin()) {
            YuyinAlaMasterLiveRoomActivityConfig yuyinAlaMasterLiveRoomActivityConfig = new YuyinAlaMasterLiveRoomActivityConfig(context != null ? context : TbadkCoreApplication.getInst().getApplicationContext(), null, null, TbadkCoreApplication.getCurrentAccount(), null, str);
            yuyinAlaMasterLiveRoomActivityConfig.setNeedStopImWhenClose(true);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, yuyinAlaMasterLiveRoomActivityConfig));
        }
    }

    private void bq(Context context, String str) {
        if (TbadkCoreApplication.getInst().getContext() != null && TbadkCoreApplication.isLogin()) {
            AlaMasterLiveRoomActivityConfig alaMasterLiveRoomActivityConfig = new AlaMasterLiveRoomActivityConfig(context != null ? context : TbadkCoreApplication.getInst().getApplicationContext(), null, null, TbadkCoreApplication.getCurrentAccount(), null, str);
            alaMasterLiveRoomActivityConfig.setNeedStopImWhenClose(true);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaMasterLiveRoomActivityConfig));
        }
    }

    public void dHa() {
        if (TbadkCoreApplication.getInst().getContext() != null) {
            com.baidu.tieba.sdk.login.a.dHq().VI();
            com.baidu.live.af.a.SE().d(null);
            com.baidu.live.af.a.SE().SH();
        }
    }

    private void dHm() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, new com.baidu.tieba.sdk.e.b());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void dHn() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2501018, new com.baidu.tieba.sdk.e.c());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void dHo() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913077, new com.baidu.tieba.sdk.g.b());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2913260, new com.baidu.tieba.sdk.g.a());
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
    }

    private void dHp() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_OPEN_WEB_BROWSER, new com.baidu.tieba.sdk.h.a());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        UrlManager.getInstance().setWebListener(new UrlManager.UrlWebDealListener() { // from class: com.baidu.tieba.sdk.d.a.3
            @Override // com.baidu.live.tbadk.core.util.UrlManager.UrlWebDealListener
            public void deal(TbPageContext<?> tbPageContext, String str, String str2, boolean z, UrlManager.UrlWebDialogCancelListener urlWebDialogCancelListener, boolean z2) {
                if (a.this.mYe != null) {
                    a.this.mYe.Oh(str2);
                }
            }
        });
    }

    public void a(INetWorkBuilder iNetWorkBuilder) {
        BdNetWorkManager.getInstance().init(iNetWorkBuilder);
    }

    public void a(IImageLoaderBuilder iImageLoaderBuilder) {
        ImageLoaderManager.getInstance().init(iImageLoaderBuilder);
    }

    public void a(IShareChannelBuild iShareChannelBuild) {
        ShareSingleManager.getInstance().init(iShareChannelBuild);
    }

    public void addPayChannelBuilder(PayChannelType payChannelType, IPayChannelBuilder iPayChannelBuilder) {
        PayChannelManager.getInstance().addPayChannelBuilder(payChannelType, iPayChannelBuilder);
    }

    public void a(ILocationBuilder iLocationBuilder) {
        LocationManager.getInstance().init(iLocationBuilder);
    }

    public void a(IExtraJumpBuilder iExtraJumpBuilder) {
        ExtraJumpManager.getInstance().init(iExtraJumpBuilder);
    }

    public void a(IExtraParamsBuilder iExtraParamsBuilder) {
        ExtraParamsManager.getInstance().init(iExtraParamsBuilder);
        final IExtraParams buildParamsExtra = ExtraParamsManager.getInstance().buildParamsExtra();
        if (buildParamsExtra != null) {
            AlaLiveStreamSessionInfo.setIReplaceUrl(new bk() { // from class: com.baidu.tieba.sdk.d.a.4
                @Override // com.baidu.live.data.bk
                public String replacePushUrl(String str) {
                    return TextUtils.isEmpty(str) ? str : buildParamsExtra.replacePushUrl(str);
                }

                @Override // com.baidu.live.data.bk
                public String replaceFlvUrl(String str) {
                    return TextUtils.isEmpty(str) ? str : buildParamsExtra.replaceFlvUrl(str);
                }

                @Override // com.baidu.live.data.bk
                public String replaceRtmpUrl(String str) {
                    return TextUtils.isEmpty(str) ? str : buildParamsExtra.replaceRtmpUrl(str);
                }

                @Override // com.baidu.live.data.bk
                public String replaceHslUrl(String str) {
                    return TextUtils.isEmpty(str) ? str : buildParamsExtra.replaceHslUrl(str);
                }
            });
        }
    }

    @Override // com.baidu.live.adp.base.BdPageContextCreator
    public BdPageContext createPageContext(LiveBaseActivity liveBaseActivity) {
        return liveBaseActivity instanceof YuyinLivePlayerActivity ? new com.baidu.tieba.sdk.e.d(liveBaseActivity) : new com.baidu.tieba.sdk.e.a(liveBaseActivity);
    }

    public void setCustomToast(ICustomToast iCustomToast) {
        BdUtilHelper.setCustomToast(iCustomToast);
    }

    public void a(IAlaBdZanBuilder iAlaBdZanBuilder) {
        BdZanViewCreater.getInst().setBdZanBuilder(iAlaBdZanBuilder);
    }

    public void c(com.baidu.live.liveroom.e.e eVar) {
        com.baidu.live.liveroom.e.i.Pq().a(eVar);
    }

    public void a(com.baidu.live.liveroom.e.c cVar) {
        com.baidu.live.liveroom.e.i.Pq().a(cVar);
    }

    public void g(Context context, String str, int i) {
        if (TbadkCoreApplication.getInst().getContext() != null) {
            com.baidu.tieba.sdk.login.a.dHq().dHr();
            if (StringUtils.isNull(str)) {
                str = TbadkCoreApplication.getCurrentAccount();
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new y(context, false, str, i)));
        }
    }

    public void gQ(Context context) {
        if (TbadkCoreApplication.getInst().getContext() != null) {
            com.baidu.tieba.sdk.login.a.dHq().dHr();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.d.a(context, "")));
        }
    }

    public void b(Context context, long j, int i) {
        if (TbadkCoreApplication.getInst().getContext() != null) {
            com.baidu.tieba.sdk.login.a.dHq().dHr();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new q(context, j, i)));
        }
    }

    public void gR(Context context) {
        if (TbadkCoreApplication.getInst().getContext() != null) {
            com.baidu.tieba.sdk.login.a.dHq().dHr();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.d.i(context)));
        }
    }

    public void gP(Context context) {
        if (TbadkCoreApplication.getInst().getContext() != null) {
            dHa();
            com.baidu.tieba.sdk.login.a.dHq().dHr();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GuardClubJoinListActivityConfig(context)));
        }
    }

    public void bk(Context context, String str) {
        if (TbadkCoreApplication.getInst().getContext() != null) {
            com.baidu.tieba.sdk.login.a.dHq().dHr();
            try {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GuardClubInfoActivityConfig(context, Long.valueOf(str).longValue(), 0L, true, "", true)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void y(Context context, String str, String str2) {
        if (TbadkCoreApplication.getInst().getContext() != null) {
            com.baidu.tieba.sdk.login.a.dHq().dHr();
            if (StringUtils.isNull(str)) {
                str = TbadkCoreApplication.getCurrentAccount();
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new m(context, str, str2)));
        }
    }

    public void setCustomProtocol(String str) {
        SchemeUtils.setCustomProtocol(str);
    }

    public boolean checkScheme(String str) {
        return SchemeUtils.checkScheme(str);
    }

    public boolean openScheme(Context context, String str) {
        return SchemeUtils.openScheme(context, str);
    }

    public boolean openScheme(Context context, String str, SchemeCallback schemeCallback) {
        return SchemeUtils.openScheme(context, str, schemeCallback);
    }

    public void Sn(String str) {
        TbConfig.setFromHost(str);
    }

    public void So(String str) {
        TbConfig.setCurrentFromHost(str);
    }

    public void setSubappVersionName(String str) {
        TbConfig.setSubappVersionName(str);
    }

    public void setSubappVersionCode(int i) {
        TbConfig.setSubappVersionCode(i);
    }

    public void br(Context context, String str) {
        if (TbadkCoreApplication.getInst().getContext() != null) {
            Log.d("LiveSdkDelegate", "openSdkWebView url:" + str);
            if (!TextUtils.isEmpty(str)) {
                if (!TbadkCoreApplication.getInst().isRegistedIntent(CommonWebViewActivityConfig.class)) {
                    TbadkCoreApplication.getInst().RegisterIntent(CommonWebViewActivityConfig.class, CommonWebViewActivity.class);
                }
                com.baidu.tieba.sdk.login.a.dHq().dHr();
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonWebViewActivityConfig(context, str)));
            }
        }
    }

    public void z(Context context, String str, String str2) {
        String string;
        if (TbadkCoreApplication.getInst().getContext() != null && !TextUtils.isEmpty(str2) && !str2.equals("1") && !str2.equals("2")) {
            if (str2.equals("0")) {
                dHa();
                com.baidu.tieba.sdk.login.a.dHq().dHr();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913222, new FaceRecognitionActivityConfig(context, str)));
            } else if (str2.equals("3")) {
                if (com.baidu.live.af.a.SE().bwi.aOY != null) {
                    string = com.baidu.live.af.a.SE().bwi.aOY.aQt;
                    if (TextUtils.isEmpty(string)) {
                        string = "";
                    }
                } else {
                    string = com.baidu.live.d.Ba().getString("ala_certify_refuse_url", "");
                }
                if (!TextUtils.isEmpty(string)) {
                    dHb().br(context, string);
                    return;
                }
                this.mYh = BdUniqueId.gen();
                MessageManager.getInstance().registerListener(this.syncListener);
                com.baidu.live.af.a.SE().d(this.mYh);
            }
        }
    }

    public void setResourceAdapter(IResourceAdapter iResourceAdapter) {
        HostResourceManager.getInstance().setResourceAdapter(iResourceAdapter);
    }

    public void bP(String str, int i) {
        if (TbadkCoreApplication.getInst().getContext() != null && !StringUtils.isNull(str)) {
            UpdateAttentionMessage.UpdateAttentionData updateAttentionData = new UpdateAttentionMessage.UpdateAttentionData();
            updateAttentionData.isSucc = true;
            updateAttentionData.toUid = str;
            updateAttentionData.isAttention = i != 0;
            updateAttentionData.status = i;
            UpdateAttentionMessage updateAttentionMessage = new UpdateAttentionMessage(updateAttentionData);
            updateAttentionMessage.comeFromHost = true;
            MessageManager.getInstance().dispatchResponsedMessage(updateAttentionMessage);
        }
    }

    public void setAttentionStatusChangedFromSDKCallBack(IAttentionStatusCallBack iAttentionStatusCallBack) {
        AttentionStatusSyncManager.getInstance().setAttentionStatusChangedFromSDKCallBack(iAttentionStatusCallBack);
    }

    public void a(com.baidu.live.liveroom.a.d dVar) {
        com.baidu.live.liveroom.a.b.OR().bsC = dVar;
    }
}

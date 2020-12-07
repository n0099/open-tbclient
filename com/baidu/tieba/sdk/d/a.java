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
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.adp.widget.ICustomToast;
import com.baidu.live.d.m;
import com.baidu.live.d.q;
import com.baidu.live.d.y;
import com.baidu.live.data.AlaLiveStreamSessionInfo;
import com.baidu.live.data.bi;
import com.baidu.live.message.AlaSyncHttpResponseMessage;
import com.baidu.live.message.LiveSyncHttpResponseMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.ala.zan.BdZanViewCreater;
import com.baidu.live.tbadk.ala.zan.IAlaBdZanBuilder;
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
/* loaded from: classes4.dex */
public class a implements BdPageContextCreator {
    private static a mSx = null;
    private g mSA;
    private d mSB;
    private e mSC;
    private f mSD;
    private BdUniqueId mSE;
    private BdUniqueId mSF;
    private BdUniqueId mSG;
    private String mSH;
    private d mSy;
    private c mSz;
    private HttpMessageListener syncListener = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SYNC) { // from class: com.baidu.tieba.sdk.d.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021011 && (httpResponsedMessage instanceof AlaSyncHttpResponseMessage)) {
                AlaSyncHttpResponseMessage alaSyncHttpResponseMessage = (AlaSyncHttpResponseMessage) httpResponsedMessage;
                if (alaSyncHttpResponseMessage.getError() == 0) {
                    Message<?> orginalMessage = alaSyncHttpResponseMessage.getOrginalMessage();
                    if (orginalMessage != null && orginalMessage.getTag() != null && orginalMessage.getTag().equals(a.this.mSG) && alaSyncHttpResponseMessage.PR() != null && alaSyncHttpResponseMessage.PR().aOr != null && !TextUtils.isEmpty(alaSyncHttpResponseMessage.PR().aOr.aPE)) {
                        a.dHl().bm(TbadkCoreApplication.getInst(), alaSyncHttpResponseMessage.PR().aOr.aPE);
                    } else if (orginalMessage != null && orginalMessage.getTag() != null && orginalMessage.getTag().equals(a.this.mSF) && com.baidu.live.ae.a.RB().RC()) {
                        a.this.bh(null, a.this.mSH);
                    }
                }
            }
        }
    };
    private HttpMessageListener bxt = new HttpMessageListener(1021132) { // from class: com.baidu.tieba.sdk.d.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021132 && (httpResponsedMessage instanceof LiveSyncHttpResponseMessage)) {
                LiveSyncHttpResponseMessage liveSyncHttpResponseMessage = (LiveSyncHttpResponseMessage) httpResponsedMessage;
                if (liveSyncHttpResponseMessage.getError() == 0) {
                    Message<?> orginalMessage = liveSyncHttpResponseMessage.getOrginalMessage();
                    if (orginalMessage != null && orginalMessage.getTag() != null && orginalMessage.getTag().equals(a.this.mSE) && liveSyncHttpResponseMessage.PW() != null && liveSyncHttpResponseMessage.PW().aQS != null && !TextUtils.isEmpty(liveSyncHttpResponseMessage.PW().aQS.aSc)) {
                        a.dHl().bm(TbadkCoreApplication.getInst(), liveSyncHttpResponseMessage.PW().aQS.aSc);
                    } else if (orginalMessage != null && orginalMessage.getTag() != null && orginalMessage.getTag().equals(a.this.mSF) && com.baidu.live.ae.a.RB().RC()) {
                        a.this.bh(null, a.this.mSH);
                    }
                }
            }
        }
    };

    private a() {
    }

    public static a dHl() {
        a aVar;
        if (mSx != null) {
            return mSx;
        }
        synchronized (a.class) {
            if (mSx == null) {
                mSx = new a();
            }
            aVar = mSx;
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

    public static void SB(String str) {
        TbConfig.FILE_PROVIDER_AUTHORITIES = str;
    }

    public static void SC(String str) {
        TbConfig.FILE_OUTPUT_FILE_ROOT_PATH = str;
    }

    public void d(Application application) {
        TbadkCoreApplication.IS_SDK = true;
        TbConfig.setVersion("9.6.8.1");
        IScrollableHelper.defaultPageContextCreater = this;
        TbadkCoreApplication.getInst().onCreate(application);
        dHn();
        dHo();
        dHv();
        dHw();
        dHx();
        dHy();
        dHm();
    }

    private void dHm() {
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

    private void dHn() {
        MessageManager.getInstance().addMessageRule(new com.baidu.tieba.sdk.a.a(0));
    }

    private void dHo() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_ADD_FRAGMENT, null));
    }

    public void dHi() {
        if (TbadkCoreApplication.getInst().getContext() != null) {
            com.baidu.live.ae.a.RB().RD();
            com.baidu.tieba.sdk.login.a.dHz().dHA();
        }
    }

    public void dHj() {
        if (TbadkCoreApplication.getInst().getContext() != null) {
            dHk();
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

    public void bd(Context context, String str) {
        if (TbadkCoreApplication.getInst().getContext() != null) {
            com.baidu.tieba.sdk.login.a.dHz().dHB();
            if (com.baidu.live.ae.a.RB().RC() && com.baidu.live.ae.a.RB().bxq != null && com.baidu.live.ae.a.RB().bxq.aQK != null) {
                bh(context, str);
                return;
            }
            this.mSH = str;
            MessageManager.getInstance().registerListener(this.bxt);
            MessageManager.getInstance().registerListener(this.syncListener);
            this.mSF = BdUniqueId.gen();
            com.baidu.live.ae.a.RB().e(this.mSF);
            com.baidu.live.ae.a.RB().d(this.mSF);
        }
    }

    public void bc(Context context, String str) {
        com.baidu.tieba.sdk.login.a.dHz().dHB();
        bi(context, str);
    }

    public void bh(Context context, String str) {
        if (TbadkCoreApplication.getInst().getContext() != null) {
            bl(context, str);
            this.mSH = null;
        }
    }

    public void bi(Context context, String str) {
        bk(context, str);
        this.mSH = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BuyTBeanActivityConfig bj(Context context, String str) {
        JSONException e;
        String str2;
        String str3 = null;
        boolean z = false;
        try {
            if (TextUtils.isEmpty(str)) {
                str2 = null;
            } else {
                JSONObject jSONObject = new JSONObject(str);
                str2 = jSONObject.optString(BuyTBeanActivityConfig.CALLBACK);
                try {
                    z = jSONObject.optBoolean("isTranslucent");
                    str3 = jSONObject.optString("from");
                } catch (JSONException e2) {
                    e = e2;
                    e.printStackTrace();
                    BuyTBeanActivityConfig buyTBeanActivityConfig = new BuyTBeanActivityConfig(context, 0L, true);
                    if (!TextUtils.isEmpty(str2)) {
                    }
                    if (!TextUtils.isEmpty(str3)) {
                    }
                    buyTBeanActivityConfig.setIsTranslucent(z);
                    return buyTBeanActivityConfig;
                }
            }
        } catch (JSONException e3) {
            e = e3;
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

    public void SD(String str) {
        if (TbadkCoreApplication.getInst().getContext() != null) {
            com.baidu.tieba.sdk.login.a.dHz().dHA();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, bj(TbadkCoreApplication.getInst(), str)));
        }
    }

    public void a(com.baidu.tieba.sdk.b.a aVar) {
        com.baidu.tieba.sdk.login.a.dHz().b(aVar);
    }

    public void a(d dVar) {
        this.mSy = dVar;
    }

    public d dHp() {
        return this.mSy;
    }

    public void b(d dVar) {
        this.mSB = dVar;
    }

    public d dHq() {
        return this.mSB;
    }

    public void a(c cVar) {
        this.mSz = cVar;
    }

    public c dHr() {
        return this.mSz;
    }

    public g dHs() {
        return this.mSA;
    }

    public void a(e eVar) {
        this.mSC = eVar;
    }

    public void hD(long j) {
        if (TbadkCoreApplication.getInst().getContext() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_RES_ZIP_DOWNLOADED_STATUS, Long.valueOf(j)));
        }
    }

    public e dHt() {
        return this.mSC;
    }

    public void a(final com.baidu.tieba.sdk.b.b bVar) {
        if (bVar != null) {
            LoadLibraryManager.getInstance().setFaceUnityCallBack(new IFaceUnityCallBack() { // from class: com.baidu.tieba.sdk.d.a.1
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
        this.mSD = fVar;
    }

    public f dHu() {
        return this.mSD;
    }

    private void bk(Context context, String str) {
        if (TbadkCoreApplication.isLogin()) {
            YuyinAlaMasterLiveRoomActivityConfig yuyinAlaMasterLiveRoomActivityConfig = new YuyinAlaMasterLiveRoomActivityConfig(context != null ? context : TbadkCoreApplication.getInst().getApplicationContext(), null, null, TbadkCoreApplication.getCurrentAccount(), null, str);
            yuyinAlaMasterLiveRoomActivityConfig.setNeedStopImWhenClose(true);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, yuyinAlaMasterLiveRoomActivityConfig));
        }
    }

    private void bl(Context context, String str) {
        if (TbadkCoreApplication.getInst().getContext() != null && TbadkCoreApplication.isLogin()) {
            AlaMasterLiveRoomActivityConfig alaMasterLiveRoomActivityConfig = new AlaMasterLiveRoomActivityConfig(context != null ? context : TbadkCoreApplication.getInst().getApplicationContext(), null, null, TbadkCoreApplication.getCurrentAccount(), null, str);
            alaMasterLiveRoomActivityConfig.setNeedStopImWhenClose(true);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaMasterLiveRoomActivityConfig));
        }
    }

    public void dHk() {
        if (TbadkCoreApplication.getInst().getContext() != null) {
            com.baidu.tieba.sdk.login.a.dHz().UD();
            com.baidu.live.ae.a.RB().d(null);
            com.baidu.live.ae.a.RB().RE();
        }
    }

    private void dHv() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, new com.baidu.tieba.sdk.e.b());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void dHw() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2501018, new com.baidu.tieba.sdk.e.c());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void dHx() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913077, new com.baidu.tieba.sdk.g.b());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2913260, new com.baidu.tieba.sdk.g.a());
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
    }

    private void dHy() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_OPEN_WEB_BROWSER, new com.baidu.tieba.sdk.h.a());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        UrlManager.getInstance().setWebListener(new UrlManager.UrlWebDealListener() { // from class: com.baidu.tieba.sdk.d.a.2
            @Override // com.baidu.live.tbadk.core.util.UrlManager.UrlWebDealListener
            public void deal(TbPageContext<?> tbPageContext, String str, String str2, boolean z, UrlManager.UrlWebDialogCancelListener urlWebDialogCancelListener, boolean z2) {
                if (a.this.mSD != null) {
                    a.this.mSD.Oz(str2);
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
            AlaLiveStreamSessionInfo.setIReplaceUrl(new bi() { // from class: com.baidu.tieba.sdk.d.a.3
                @Override // com.baidu.live.data.bi
                public String replacePushUrl(String str) {
                    return TextUtils.isEmpty(str) ? str : buildParamsExtra.replacePushUrl(str);
                }

                @Override // com.baidu.live.data.bi
                public String replaceFlvUrl(String str) {
                    return TextUtils.isEmpty(str) ? str : buildParamsExtra.replaceFlvUrl(str);
                }

                @Override // com.baidu.live.data.bi
                public String replaceRtmpUrl(String str) {
                    return TextUtils.isEmpty(str) ? str : buildParamsExtra.replaceRtmpUrl(str);
                }

                @Override // com.baidu.live.data.bi
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
        com.baidu.live.liveroom.e.i.PB().a(eVar);
    }

    public void a(com.baidu.live.liveroom.e.c cVar) {
        com.baidu.live.liveroom.e.i.PB().a(cVar);
    }

    public void f(Context context, String str, int i) {
        if (TbadkCoreApplication.getInst().getContext() != null) {
            com.baidu.tieba.sdk.login.a.dHz().dHA();
            if (StringUtils.isNull(str)) {
                str = TbadkCoreApplication.getCurrentAccount();
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new y(context, false, str, i)));
        }
    }

    public void gx(Context context) {
        if (TbadkCoreApplication.getInst().getContext() != null) {
            com.baidu.tieba.sdk.login.a.dHz().dHA();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.d.a(context, "")));
        }
    }

    public void a(Context context, long j, int i) {
        if (TbadkCoreApplication.getInst().getContext() != null) {
            com.baidu.tieba.sdk.login.a.dHz().dHA();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new q(context, j, i)));
        }
    }

    public void gy(Context context) {
        if (TbadkCoreApplication.getInst().getContext() != null) {
            com.baidu.tieba.sdk.login.a.dHz().dHA();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.d.i(context)));
        }
    }

    public void gw(Context context) {
        if (TbadkCoreApplication.getInst().getContext() != null) {
            dHk();
            com.baidu.tieba.sdk.login.a.dHz().dHA();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GuardClubJoinListActivityConfig(context)));
        }
    }

    public void bg(Context context, String str) {
        if (TbadkCoreApplication.getInst().getContext() != null) {
            com.baidu.tieba.sdk.login.a.dHz().dHA();
            try {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GuardClubInfoActivityConfig(context, Long.valueOf(str).longValue(), 0L, true, "", true)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void x(Context context, String str, String str2) {
        if (TbadkCoreApplication.getInst().getContext() != null) {
            com.baidu.tieba.sdk.login.a.dHz().dHA();
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

    public void SE(String str) {
        TbConfig.setFromHost(str);
    }

    public void SF(String str) {
        TbConfig.setCurrentFromHost(str);
    }

    public void setSubappVersionName(String str) {
        TbConfig.setSubappVersionName(str);
    }

    public void setSubappVersionCode(int i) {
        TbConfig.setSubappVersionCode(i);
    }

    public void bm(Context context, String str) {
        if (TbadkCoreApplication.getInst().getContext() != null) {
            Log.d("LiveSdkDelegate", "openSdkWebView url:" + str);
            if (!TextUtils.isEmpty(str)) {
                if (!TbadkCoreApplication.getInst().isRegistedIntent(CommonWebViewActivityConfig.class)) {
                    TbadkCoreApplication.getInst().RegisterIntent(CommonWebViewActivityConfig.class, CommonWebViewActivity.class);
                }
                com.baidu.tieba.sdk.login.a.dHz().dHA();
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonWebViewActivityConfig(context, str)));
            }
        }
    }

    public void y(Context context, String str, String str2) {
        String string;
        if (TbadkCoreApplication.getInst().getContext() != null && !TextUtils.isEmpty(str2) && !str2.equals("1") && !str2.equals("2")) {
            if (str2.equals("0")) {
                dHk();
                com.baidu.tieba.sdk.login.a.dHz().dHA();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913222, new FaceRecognitionActivityConfig(context, str)));
            } else if (str2.equals("3")) {
                if (com.baidu.live.ae.a.RB().brA.aOr != null) {
                    string = com.baidu.live.ae.a.RB().brA.aOr.aPE;
                    if (TextUtils.isEmpty(string)) {
                        string = "";
                    }
                } else {
                    string = com.baidu.live.d.BM().getString("ala_certify_refuse_url", "");
                }
                if (!TextUtils.isEmpty(string)) {
                    dHl().bm(context, string);
                    return;
                }
                this.mSG = BdUniqueId.gen();
                MessageManager.getInstance().registerListener(this.syncListener);
                com.baidu.live.ae.a.RB().d(this.mSG);
            }
        }
    }

    public void setResourceAdapter(IResourceAdapter iResourceAdapter) {
        HostResourceManager.getInstance().setResourceAdapter(iResourceAdapter);
    }

    public void bI(String str, int i) {
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
        com.baidu.live.liveroom.a.b.Pd().bqI = dVar;
    }
}

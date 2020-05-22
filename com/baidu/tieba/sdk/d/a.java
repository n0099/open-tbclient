package com.baidu.tieba.sdk.d;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
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
import com.baidu.live.c.m;
import com.baidu.live.c.t;
import com.baidu.live.data.AlaLiveStreamSessionInfo;
import com.baidu.live.data.aq;
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
import com.baidu.megapp.ma.MAActivity;
import com.baidu.tieba.sdk.activity.CommonWebViewActivity;
import com.baidu.tieba.sdk.activity.LivePlayerActivity;
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
/* loaded from: classes3.dex */
public class a implements BdPageContextCreator {
    private static a kST = null;
    private e kSU;
    private d kSV;
    private f kSW;
    private g kSX;
    private BdUniqueId kSY;
    private BdUniqueId kSZ;
    private BdUniqueId kTa;
    private String kTb;
    private c kTc = new c() { // from class: com.baidu.tieba.sdk.d.a.1
    };
    private HttpMessageListener syncListener = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SYNC) { // from class: com.baidu.tieba.sdk.d.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Message<?> orginalMessage;
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021011 && (httpResponsedMessage instanceof AlaSyncHttpResponseMessage)) {
                AlaSyncHttpResponseMessage alaSyncHttpResponseMessage = (AlaSyncHttpResponseMessage) httpResponsedMessage;
                if ((alaSyncHttpResponseMessage.getError() == 0) && (orginalMessage = alaSyncHttpResponseMessage.getOrginalMessage()) != null && orginalMessage.getTag() != null && orginalMessage.getTag().equals(a.this.kTa) && alaSyncHttpResponseMessage.Fo() != null && alaSyncHttpResponseMessage.Fo().ayu != null && !TextUtils.isEmpty(alaSyncHttpResponseMessage.Fo().ayu.azk)) {
                    a.cWj().aW(TbadkCoreApplication.getInst(), alaSyncHttpResponseMessage.Fo().ayu.azk);
                }
            }
        }
    };
    private HttpMessageListener aYS = new HttpMessageListener(1021132) { // from class: com.baidu.tieba.sdk.d.a.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021132 && (httpResponsedMessage instanceof LiveSyncHttpResponseMessage)) {
                LiveSyncHttpResponseMessage liveSyncHttpResponseMessage = (LiveSyncHttpResponseMessage) httpResponsedMessage;
                if (liveSyncHttpResponseMessage.getError() == 0) {
                    Message<?> orginalMessage = liveSyncHttpResponseMessage.getOrginalMessage();
                    if (orginalMessage != null && orginalMessage.getTag() != null && orginalMessage.getTag().equals(a.this.kSY) && liveSyncHttpResponseMessage.Fu() != null && liveSyncHttpResponseMessage.Fu().aAO != null && !TextUtils.isEmpty(liveSyncHttpResponseMessage.Fu().aAO.aBx)) {
                        a.cWj().aW(TbadkCoreApplication.getInst(), liveSyncHttpResponseMessage.Fu().aAO.aBx);
                    } else if (orginalMessage != null && orginalMessage.getTag() != null && orginalMessage.getTag().equals(a.this.kSZ)) {
                        a.this.aU(null, a.this.kTb);
                    }
                }
            }
        }
    };

    private a() {
    }

    public static a cWj() {
        a aVar;
        if (kST != null) {
            return kST;
        }
        synchronized (a.class) {
            if (kST == null) {
                kST = new a();
            }
            aVar = kST;
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

    public void init(Application application) {
        TbadkCoreApplication.IS_SDK = true;
        TbConfig.setVersion("9.6.8.1");
        IScrollableHelper.defaultPageContextCreater = this;
        TbadkCoreApplication.getInst().onCreate(application);
        if ((application.getApplicationInfo().flags & 2) == 0) {
            TbadkCoreApplication.getInst().setDebugMode(true);
        }
        cWl();
        cWm();
        cWr();
        cWs();
        cWt();
        cWk();
    }

    private void cWk() {
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

    private void cWl() {
        MessageManager.getInstance().addMessageRule(new com.baidu.tieba.sdk.a.a(0));
    }

    private void cWm() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_ADD_FRAGMENT, null));
    }

    public void cWg() {
        com.baidu.live.v.a.Ge().Gf();
        com.baidu.tieba.sdk.login.a.cWu().cWv();
    }

    public void cWh() {
        cWi();
        com.baidu.live.entereffect.a.wD().aZ(false);
    }

    public com.baidu.tieba.sdk.e.a a(MAActivity mAActivity) {
        return new com.baidu.tieba.sdk.e.a(mAActivity);
    }

    public void a(Context context, String str, boolean z, String str2, JSONObject jSONObject) {
        if (!TbadkCoreApplication.getInst().isRegistedIntent(AlaLiveRoomActivityConfig.class)) {
            TbadkCoreApplication.getInst().RegisterIntent(AlaLiveRoomActivityConfig.class, LivePlayerActivity.class);
        }
        if (!TextUtils.isEmpty(str)) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(AlaLiveRoomActivityConfig.SDK_EXTRA_RECOMMEND_TYPE, z ? 0 : 1);
                jSONObject2.put(AlaLiveRoomActivityConfig.LIVE_SHOW_GITE_PANEL, str2);
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
            alaLiveRoomActivityConfig.addExtraByRoomId(str, jSONObject3);
            alaLiveRoomActivityConfig.setNeedStopImWhenClose(true);
            if (!(context instanceof Activity)) {
                alaLiveRoomActivityConfig.getIntent().addFlags(268435456);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaLiveRoomActivityConfig));
        }
    }

    public void a(Context context, long j, boolean z, String str, JSONObject jSONObject) {
        if (!TbadkCoreApplication.getInst().isRegistedIntent(AlaLiveRoomActivityConfig.class)) {
            TbadkCoreApplication.getInst().RegisterIntent(AlaLiveRoomActivityConfig.class, LivePlayerActivity.class);
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(AlaLiveRoomActivityConfig.SDK_EXTRA_RECOMMEND_TYPE, z ? 0 : 1);
            jSONObject2.put(AlaLiveRoomActivityConfig.LIVE_SHOW_GITE_PANEL, str);
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

    public void b(Context context, String str, boolean z, String str2, JSONObject jSONObject) {
        if (!TbadkCoreApplication.getInst().isRegistedIntent(AlaLiveRoomActivityConfig.class)) {
            TbadkCoreApplication.getInst().RegisterIntent(AlaLiveRoomActivityConfig.class, LivePlayerActivity.class);
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(AlaLiveRoomActivityConfig.SDK_EXTRA_RECOMMEND_TYPE, z ? 0 : 1);
            jSONObject2.put(AlaLiveRoomActivityConfig.LIVE_SHOW_GITE_PANEL, str2);
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

    public void aQ(Context context, String str) {
        com.baidu.tieba.sdk.login.a.cWu().cWw();
        if (com.baidu.live.v.a.Ge().aYP != null && com.baidu.live.v.a.Ge().aYP.aAG != null) {
            aU(context, str);
            return;
        }
        this.kTb = str;
        MessageManager.getInstance().registerListener(this.aYS);
        this.kSZ = BdUniqueId.gen();
        com.baidu.live.v.a.Ge().c(this.kSZ);
        com.baidu.live.v.a.Ge().b(null);
    }

    public void aU(Context context, String str) {
        com.baidu.live.v.c.Gj().Gk();
        com.baidu.live.entereffect.a.wD().aZ(true);
        aV(context, str);
        this.kTb = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void LG(String str) {
        JSONException e;
        String str2;
        String str3 = null;
        com.baidu.tieba.sdk.login.a.cWu().cWv();
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
                    BuyTBeanActivityConfig buyTBeanActivityConfig = new BuyTBeanActivityConfig(TbadkCoreApplication.getInst(), 0L, true);
                    if (!TextUtils.isEmpty(str2)) {
                    }
                    if (!TextUtils.isEmpty(str3)) {
                    }
                    buyTBeanActivityConfig.setIsTranslucent(z);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, buyTBeanActivityConfig));
                }
            }
        } catch (JSONException e3) {
            e = e3;
            str2 = null;
        }
        BuyTBeanActivityConfig buyTBeanActivityConfig2 = new BuyTBeanActivityConfig(TbadkCoreApplication.getInst(), 0L, true);
        if (!TextUtils.isEmpty(str2)) {
            buyTBeanActivityConfig2.setCallback(str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            buyTBeanActivityConfig2.setFrom(str3);
        }
        buyTBeanActivityConfig2.setIsTranslucent(z);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, buyTBeanActivityConfig2));
    }

    public void a(com.baidu.tieba.sdk.b.a aVar) {
        com.baidu.tieba.sdk.login.a.cWu().b(aVar);
    }

    public void a(e eVar) {
        this.kSU = eVar;
    }

    public e cWn() {
        return this.kSU;
    }

    public void a(d dVar) {
        this.kSV = dVar;
    }

    public d cWo() {
        return this.kSV;
    }

    public void a(f fVar) {
        this.kSW = fVar;
    }

    public f cWp() {
        return this.kSW;
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

    public void a(g gVar) {
        this.kSX = gVar;
    }

    public g cWq() {
        return this.kSX;
    }

    private void aV(Context context, String str) {
        if (TbadkCoreApplication.isLogin()) {
            AlaMasterLiveRoomActivityConfig alaMasterLiveRoomActivityConfig = new AlaMasterLiveRoomActivityConfig(context != null ? context : TbadkCoreApplication.getInst().getApplicationContext(), null, null, TbadkCoreApplication.getCurrentAccount(), null, str);
            alaMasterLiveRoomActivityConfig.setNeedStopImWhenClose(true);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaMasterLiveRoomActivityConfig));
        }
    }

    public void cWi() {
        com.baidu.tieba.sdk.login.a.cWu().Gr();
        com.baidu.live.v.a.Ge().b(null);
        com.baidu.live.v.a.Ge().Gg();
    }

    private void cWr() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, new com.baidu.tieba.sdk.e.b());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void cWs() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913077, new com.baidu.tieba.sdk.g.a());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void cWt() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_OPEN_WEB_BROWSER, new com.baidu.tieba.sdk.h.a());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        UrlManager.getInstance().setWebListener(new UrlManager.UrlWebDealListener() { // from class: com.baidu.tieba.sdk.d.a.3
            @Override // com.baidu.live.tbadk.core.util.UrlManager.UrlWebDealListener
            public void deal(TbPageContext<?> tbPageContext, String str, String str2, boolean z, UrlManager.UrlWebDialogCancelListener urlWebDialogCancelListener, boolean z2) {
                if (a.this.kSX != null) {
                    a.this.kSX.HE(str2);
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
            AlaLiveStreamSessionInfo.setIReplaceUrl(new aq() { // from class: com.baidu.tieba.sdk.d.a.4
                @Override // com.baidu.live.data.aq
                public String replacePushUrl(String str) {
                    return TextUtils.isEmpty(str) ? str : buildParamsExtra.replacePushUrl(str);
                }

                @Override // com.baidu.live.data.aq
                public String replaceFlvUrl(String str) {
                    return TextUtils.isEmpty(str) ? str : buildParamsExtra.replaceFlvUrl(str);
                }

                @Override // com.baidu.live.data.aq
                public String replaceRtmpUrl(String str) {
                    return TextUtils.isEmpty(str) ? str : buildParamsExtra.replaceRtmpUrl(str);
                }

                @Override // com.baidu.live.data.aq
                public String replaceHslUrl(String str) {
                    return TextUtils.isEmpty(str) ? str : buildParamsExtra.replaceHslUrl(str);
                }
            });
        }
    }

    @Override // com.baidu.live.adp.base.BdPageContextCreator
    public BdPageContext createPageContext(MAActivity mAActivity) {
        return new com.baidu.tieba.sdk.e.a(mAActivity);
    }

    public void setCustomToast(ICustomToast iCustomToast) {
        BdUtilHelper.setCustomToast(iCustomToast);
    }

    public void a(IAlaBdZanBuilder iAlaBdZanBuilder) {
        BdZanViewCreater.getInst().setBdZanBuilder(iAlaBdZanBuilder);
    }

    public void c(com.baidu.live.liveroom.e.b bVar) {
        com.baidu.live.liveroom.e.e.Fc().a(bVar);
    }

    public void f(Context context, String str, int i) {
        com.baidu.tieba.sdk.login.a.cWu().cWv();
        if (StringUtils.isNull(str)) {
            str = TbadkCoreApplication.getCurrentAccount();
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new t(context, false, str, i)));
    }

    public void fl(Context context) {
        com.baidu.tieba.sdk.login.a.cWu().cWv();
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.c.a(context, "")));
    }

    public void a(Context context, long j, int i) {
        com.baidu.tieba.sdk.login.a.cWu().cWv();
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new m(context, j, i)));
    }

    public void fm(Context context) {
        com.baidu.tieba.sdk.login.a.cWu().cWv();
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.c.e(context)));
    }

    public void fk(Context context) {
        cWi();
        com.baidu.tieba.sdk.login.a.cWu().cWv();
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GuardClubJoinListActivityConfig(context)));
    }

    public void aT(Context context, String str) {
        com.baidu.tieba.sdk.login.a.cWu().cWv();
        try {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GuardClubInfoActivityConfig(context, Long.valueOf(str).longValue(), 0L, true, "", true)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void u(Context context, String str, String str2) {
        com.baidu.tieba.sdk.login.a.cWu().cWv();
        if (StringUtils.isNull(str)) {
            str = TbadkCoreApplication.getCurrentAccount();
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.c.i(context, str, str2)));
    }

    public void setCustomProtocol(String str) {
        SchemeUtils.setCustomProtocol(str);
    }

    public boolean checkScheme(String str) {
        return SchemeUtils.checkScheme(str);
    }

    public boolean openScheme(Context context, String str, SchemeCallback schemeCallback) {
        return SchemeUtils.openScheme(context, str, schemeCallback);
    }

    public void LH(String str) {
        TbConfig.setFromHost(str);
    }

    public void LI(String str) {
        TbConfig.setCurrentFromHost(str);
    }

    public void setSubappVersionName(String str) {
        TbConfig.setSubappVersionName(str);
    }

    public void setSubappVersionCode(int i) {
        TbConfig.setSubappVersionCode(i);
    }

    public void aW(Context context, String str) {
        Log.d("LiveSdkDelegate", "openSdkWebView url:" + str);
        if (!TextUtils.isEmpty(str)) {
            if (!TbadkCoreApplication.getInst().isRegistedIntent(CommonWebViewActivityConfig.class)) {
                TbadkCoreApplication.getInst().RegisterIntent(CommonWebViewActivityConfig.class, CommonWebViewActivity.class);
            }
            com.baidu.tieba.sdk.login.a.cWu().cWv();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonWebViewActivityConfig(context, str)));
        }
    }

    public void v(Context context, String str, String str2) {
        String string;
        if (!TextUtils.isEmpty(str2) && !str2.equals("1") && !str2.equals("2")) {
            if (str2.equals("0")) {
                cWi();
                com.baidu.tieba.sdk.login.a.cWu().cWv();
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FaceRecognitionActivityConfig(context, str)));
            } else if (str2.equals("3")) {
                if (com.baidu.live.v.a.Ge().aWF.ayu != null) {
                    string = com.baidu.live.v.a.Ge().aWF.ayu.azk;
                    if (TextUtils.isEmpty(string)) {
                        string = "";
                    }
                } else {
                    string = com.baidu.live.c.uN().getString("ala_certify_refuse_url", "");
                }
                if (!TextUtils.isEmpty(string)) {
                    cWj().aW(context, string);
                    return;
                }
                this.kTa = BdUniqueId.gen();
                MessageManager.getInstance().registerListener(this.syncListener);
                com.baidu.live.v.a.Ge().b(this.kTa);
            }
        }
    }

    public void setResourceAdapter(IResourceAdapter iResourceAdapter) {
        HostResourceManager.getInstance().setResourceAdapter(iResourceAdapter);
    }

    public void bA(String str, int i) {
        if (!StringUtils.isNull(str)) {
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
}

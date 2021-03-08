package com.baidu.tieba.yuyinala.liveroom.k;

import android.location.Address;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.framework.message.Message;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.adp.lib.lbs.BdLocationMananger;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.AlaWheatInfoDataWrapper;
import com.baidu.live.data.ab;
import com.baidu.live.data.dd;
import com.baidu.live.data.g;
import com.baidu.live.data.v;
import com.baidu.live.im.data.ImSendMsgData;
import com.baidu.live.im.q;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.statics.HKStaticManager;
import com.baidu.live.tbadk.statics.QMStaticManager;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.live.tbadk.timer.LiveTimerManager;
import com.baidu.live.tbadk.ubc.UbcAudioFlowStatisticManager;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.mobstat.Config;
import com.baidu.tieba.yuyinala.liveroom.alaaudiopk.TeamFightInfoResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.messages.AlaEnterLiveHttpResonseMessage;
import com.baidu.tieba.yuyinala.liveroom.messages.AlaGetAudienceHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.messages.AlaLiveRecommondHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.messages.AlaMGetLiveStatusHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.messages.AlaQuitLiveHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.messages.AlaUserLiveMarkInfoResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.messages.MasterIdentityResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.messages.YuyinGetLiveInfoHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.messages.e;
import com.baidu.tieba.yuyinala.liveroom.wheat.model.GetWheatListHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.wheat.model.n;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a extends BdBaseModel implements q.a {
    private ab aED;
    private BdPageContext<?> blX;
    private v gQG;
    private BdUniqueId hLL;
    private Handler hLM;
    private List<AlaLiveInfoData> hLR;
    private int hLS;
    private int hLT;
    private int hLX;
    private int hLY;
    private String hLZ;
    private com.baidu.live.ac.a hMa;
    private Set<Long> hMd;
    private long hMf;
    private long hMg;
    private boolean hMh;
    private HttpMessageListener hMm;
    private HttpMessageListener hMq;
    private HttpMessageListener hMr;
    private HttpMessageListener hMw;
    private HttpMessageListener hMy;
    private boolean mIsHost;
    private long mLastLiveId;
    private String otherParams;
    private com.baidu.tieba.yuyinala.liveroom.alaaudiopk.c ouJ;
    private InterfaceC0934a ozf;
    private final q ozm;
    private q.a ozn;
    public boolean ozo;
    public boolean ozp;
    private HttpMessageListener ozq;
    private HttpMessageListener ozr;
    private HttpMessageListener ozs;
    private HttpMessageListener ozt;
    private HttpMessageListener ozu;
    private HttpMessageListener ozv;

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0934a {
        void a(int i, String str, int i2, Object obj);
    }

    public a(BdPageContext<?> bdPageContext) {
        super(bdPageContext);
        this.hLM = new Handler();
        this.hLS = 0;
        this.hLT = 0;
        this.hLX = -1;
        this.hLY = 0;
        this.hMa = new com.baidu.live.ac.a(0);
        this.otherParams = "";
        this.hMf = System.currentTimeMillis();
        this.hMh = true;
        this.hMg = 0L;
        this.ozo = true;
        this.ozp = false;
        this.hMm = new HttpMessageListener(1031071) { // from class: com.baidu.tieba.yuyinala.liveroom.k.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                String cjf;
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof MasterIdentityResponseMessage)) {
                    MasterIdentityResponseMessage masterIdentityResponseMessage = (MasterIdentityResponseMessage) httpResponsedMessage;
                    if ((masterIdentityResponseMessage.cjd() == 1 || masterIdentityResponseMessage.cje() == 1) && !TextUtils.isEmpty(masterIdentityResponseMessage.cjf())) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("text", masterIdentityResponseMessage.cjf());
                            jSONObject.put("content_type", "custom_master_identity");
                            cjf = jSONObject.toString();
                        } catch (JSONException e) {
                            cjf = masterIdentityResponseMessage.cjf();
                            e.printStackTrace();
                        }
                        a.this.ozm.a(27, cjf, (com.baidu.live.data.a) null);
                    }
                }
            }
        };
        this.ozq = new HttpMessageListener(1031048) { // from class: com.baidu.tieba.yuyinala.liveroom.k.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            }
        };
        this.ozr = new HttpMessageListener(1031087) { // from class: com.baidu.tieba.yuyinala.liveroom.k.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof TeamFightInfoResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == a.this.unique_id) {
                    com.baidu.tieba.yuyinala.liveroom.alaaudiopk.c eaU = ((TeamFightInfoResponseMessage) httpResponsedMessage).eaU();
                    if (eaU != null) {
                        a.this.ouJ = eaU;
                    }
                    a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 12, eaU);
                }
            }
        };
        this.ozs = new HttpMessageListener(1031084) { // from class: com.baidu.tieba.yuyinala.liveroom.k.a.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetWheatListHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == a.this.unique_id) {
                    UbcAudioFlowStatisticManager.getInstance().doSlotEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_MIC_LITE_API_FLOW, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""), "micLiteApi");
                    UbcAudioFlowStatisticManager.getInstance().doSlotStart(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_MIC_LITE_API_FLOW, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""), "micLiteApiHandle", null);
                    AlaWheatInfoDataWrapper alaWheatInfoDataWrapper = ((GetWheatListHttpResponseMessage) httpResponsedMessage).aKy;
                    if (alaWheatInfoDataWrapper != null) {
                        a.this.aED.aKy = alaWheatInfoDataWrapper;
                        if (alaWheatInfoDataWrapper.getRoomMode() == 1) {
                            a.this.aED.aKv = new dd();
                            a.this.aED.aKv.mStep = alaWheatInfoDataWrapper.getActivityStage();
                        }
                        a.this.aED.aKN = true;
                        UbcAudioFlowStatisticManager.getInstance().doSlotEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_MIC_LITE_API_FLOW, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""), "micLiteApiHandle");
                        UbcAudioFlowStatisticManager.getInstance().doSlotStart(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_MIC_LITE_API_FLOW, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""), "UIRendering", null);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501033, a.this.aED));
                        a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, a.this.aED);
                        UbcAudioFlowStatisticManager.getInstance().doSlotEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_MIC_LITE_API_FLOW, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""), "UIRendering");
                        UbcAudioFlowStatisticManager.getInstance().endFlow(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_MIC_LITE_API_FLOW, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""));
                    }
                }
            }
        };
        this.ozt = new HttpMessageListener(1031023) { // from class: com.baidu.tieba.yuyinala.liveroom.k.a.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                long j = 0;
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaEnterLiveHttpResonseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == a.this.unique_id) {
                    a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 11, a.this.aED);
                    a.this.aED = ((AlaEnterLiveHttpResonseMessage) httpResponsedMessage).Fp();
                    if (a.this.aED != null) {
                        a.this.aED.aKO = true;
                        a.this.aED.aKN = true;
                    }
                    a.this.ozm.setAlaLiveShowData(a.this.aED);
                    if (a.this.aED != null && a.this.aED.mLiveInfo != null) {
                        if (!TbadkCoreApplication.getInst().isOther() && (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isActivityTaskWatchUnabled())) {
                            com.baidu.tieba.yuyinala.liveroom.task.b.ecc().fK(a.this.aED.mLiveInfo.live_id);
                        }
                        LiveTimerManager.getInstance().start(a.this.aED.mLiveInfo.live_id);
                    }
                    if (a.this.aED != null && TbadkCoreApplication.getCurrentAccountInfo() != null) {
                        if (a.this.aED.aJZ != null) {
                            if (a.this.aED.aJZ.levelId > 0) {
                                TbadkCoreApplication.getCurrentAccountInfo().setLiveLevel(a.this.aED.aJZ.levelId);
                            }
                            TbadkCoreApplication.getCurrentAccountObj().setNameShow(a.this.aED.aJZ.nickName);
                            if (!TextUtils.isEmpty(a.this.aED.aJZ.portrait)) {
                                TbadkCoreApplication.getCurrentAccountObj().setPortrait(a.this.aED.aJZ.portrait);
                            }
                        }
                        if (a.this.aED.mLiveSdkInfo != null) {
                            TbadkCoreApplication.getInst().setTbs(a.this.aED.mLiveSdkInfo.tbs);
                            com.baidu.live.d.xf().putString("ala_account_user_tbs", a.this.aED.mLiveSdkInfo.tbs);
                        }
                    }
                    if (a.this.aED != null) {
                        if (a.this.hLR.size() <= 0) {
                            a.this.hLR.add(a.this.aED.mLiveInfo);
                            a.this.hMd.add(Long.valueOf(a.this.aED.mLiveInfo.getLiveID()));
                        }
                        a.this.h(a.this.aED.mLiveInfo);
                        if (a.this.ozm != null) {
                            a.this.ozm.S(a.this.aED.aKk);
                        }
                        if (a.this.hLR != null && a.this.hLR.size() > 0) {
                            for (AlaLiveInfoData alaLiveInfoData : a.this.hLR) {
                                if (alaLiveInfoData.live_id == a.this.aED.mLiveInfo.live_id) {
                                    alaLiveInfoData.bg_cover = a.this.aED.aKu.bg_cover;
                                    alaLiveInfoData.is_followed = a.this.aED.aKu.is_followed;
                                    alaLiveInfoData.room_name = a.this.aED.aKu.room_name;
                                }
                            }
                        }
                    }
                    if (a.this.aED != null && a.this.aED.aJF != null) {
                        a.this.hLX = a.this.aED.aJF.follow_status;
                    }
                    UbcAudioFlowStatisticManager.getInstance().doSlotEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_ENTER_AUDIO_ROOM_PERF_FLOW, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""), "enterLiveApiHandle");
                    UbcAudioFlowStatisticManager.getInstance().doSlotStart(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_ENTER_AUDIO_ROOM_PERF_FLOW, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""), "UIRendering", null);
                    a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 3, a.this.aED);
                    if (a.this.aED != null && a.this.aED.mLiveInfo != null) {
                        a.this.cjN();
                    }
                    if (a.this.aED != null) {
                        a.this.aED.isHost = false;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913081, a.this.aED));
                        com.baidu.live.im.b.d.KQ().W(a.this.aED.aKk);
                    }
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        if (a.this.aED != null && a.this.aED.mLiveInfo != null) {
                            long j2 = a.this.aED.mLiveInfo.live_id;
                            long j3 = a.this.aED.mLiveInfo.room_id;
                            String str = a.this.aED.mLiveInfo.feed_id;
                            String str2 = "";
                            if (a.this.aED.aJD != null) {
                                long j4 = a.this.aED.aJD.userId;
                                str2 = a.this.aED.aJD.userName;
                                j = j4;
                            }
                            HKStaticManager.staticStartPlayTime(j2 + "", j3 + "", j + "", str2, System.currentTimeMillis(), str, a.this.otherParams);
                        }
                    } else if ((TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) && a.this.aED != null && a.this.aED.mLiveInfo != null) {
                        long j5 = a.this.aED.mLiveInfo.live_id;
                        long j6 = a.this.aED.mLiveInfo.room_id;
                        String str3 = a.this.aED.mLiveInfo.feed_id;
                        String str4 = "";
                        if (a.this.aED.aJD != null) {
                            j = a.this.aED.aJD.userId;
                            str4 = a.this.aED.aJD.userName;
                        }
                        QMStaticManager.staticStartPlayTime(j5 + "", j6 + "", j + "", str4, System.currentTimeMillis(), str3, a.this.otherParams, a.this.hLT + "");
                    }
                    com.baidu.live.d.xf().putLong("audio_enter_live_timestamp", System.currentTimeMillis() / 1000);
                }
            }
        };
        this.hMq = new HttpMessageListener(1031042) { // from class: com.baidu.tieba.yuyinala.liveroom.k.a.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaGetAudienceHttpResponseMessage)) {
                    v bTX = ((AlaGetAudienceHttpResponseMessage) httpResponsedMessage).bTX();
                    Message<?> message = httpResponsedMessage.getmOrginalMessage();
                    if (message instanceof com.baidu.tieba.yuyinala.liveroom.messages.b) {
                        com.baidu.tieba.yuyinala.liveroom.messages.b bVar = (com.baidu.tieba.yuyinala.liveroom.messages.b) message;
                        if (String.valueOf(bVar.ebP()).equals(a.this.aED.aKu.live_id)) {
                            bTX.liveId = String.valueOf(bVar.ebP());
                        } else {
                            return;
                        }
                    }
                    if (bTX != null) {
                        a.this.gQG = bTX;
                    }
                    if (a.this.aED != null && a.this.aED.aJF != null) {
                        if (a.this.hLX == -1) {
                            a.this.hLX = a.this.aED.aJF.follow_status;
                        }
                        if (a.this.aED.aJF.follow_status != a.this.hLX) {
                            a.this.aED.aJF.follow_status = a.this.hLX;
                        }
                    }
                    a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 2, a.this.gQG);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913016, a.this.gQG));
                }
            }
        };
        this.hMr = new HttpMessageListener(1021121) { // from class: com.baidu.tieba.yuyinala.liveroom.k.a.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaUserLiveMarkInfoResponseMessage) {
                    AlaUserLiveMarkInfoResponseMessage alaUserLiveMarkInfoResponseMessage = (AlaUserLiveMarkInfoResponseMessage) httpResponsedMessage;
                    if (alaUserLiveMarkInfoResponseMessage.getError() == 0) {
                        List<AlaLiveMarkData> cjc = alaUserLiveMarkInfoResponseMessage.cjc();
                        a.this.ozm.S(cjc);
                        if (a.this.aED != null) {
                            a.this.aED.aKk = cjc;
                            com.baidu.live.im.b.d.KQ().W(a.this.aED.aKk);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913118, a.this.aED));
                        }
                    }
                }
            }
        };
        this.ozu = new HttpMessageListener(1031024) { // from class: com.baidu.tieba.yuyinala.liveroom.k.a.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof YuyinGetLiveInfoHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == a.this.unique_id) {
                    if (httpResponsedMessage.hasError()) {
                        a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, null);
                        return;
                    }
                    ab Fp = httpResponsedMessage instanceof YuyinGetLiveInfoHttpResponseMessage ? ((YuyinGetLiveInfoHttpResponseMessage) httpResponsedMessage).Fp() : null;
                    if (Fp == null) {
                        a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, Fp);
                        return;
                    }
                    if (a.this.aED == null) {
                        a.this.aED = Fp;
                        a.this.ozm.setAlaLiveShowData(a.this.aED);
                    } else if (a.this.aED.mLiveInfo != null && Fp.mLiveInfo != null && a.this.aED.mLiveInfo.live_id != Fp.mLiveInfo.live_id) {
                        a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, a.this.aED);
                        return;
                    }
                    if (a.this.aED.mLiveInfo != null && Fp.mLiveInfo != null && a.this.aED.mLiveInfo.user_id == Fp.mLiveInfo.user_id) {
                        if (a.this.aED.mLiveInfo.mLiveCloseData != null && Fp.mLiveInfo.mLiveCloseData == null) {
                            Fp.mLiveInfo.mLiveCloseData = a.this.aED.mLiveInfo.mLiveCloseData;
                        }
                        if (a.this.aED.mLiveInfo.mAlaLiveSwitchData != null && Fp.mLiveInfo.mAlaLiveSwitchData == null) {
                            Fp.mLiveInfo.mAlaLiveSwitchData = a.this.aED.mLiveInfo.mAlaLiveSwitchData;
                        }
                    }
                    a.this.aED.mLiveInfo = Fp.mLiveInfo;
                    a.this.aED.aJD = Fp.aJD;
                    if (a.this.aED.aKu != null && Fp.aKu != null) {
                        if (a.this.aED.aKu.aVp == Fp.aKu.aVp) {
                            if (!TextUtils.equals(a.this.aED.aKu.bg_cover, Fp.aKu.bg_cover) || !TextUtils.equals(a.this.aED.aKu.aVo, Fp.aKu.aVo)) {
                                a.this.ozo = true;
                            } else {
                                a.this.ozo = false;
                            }
                        } else {
                            a.this.ozo = true;
                        }
                    }
                    int roomMode = Fp.aKy != null ? Fp.aKy.getRoomMode() : -1;
                    int roomMode2 = a.this.aED.aKy != null ? a.this.aED.aKy.getRoomMode() : -1;
                    boolean z = (roomMode2 == -1 || roomMode == -1 || roomMode2 == roomMode) ? false : true;
                    if (z) {
                        a.this.ozo = true;
                    }
                    a.this.aED.aKN = false;
                    a.this.aED.aKu = Fp.aKu;
                    a.this.aED.aKv = Fp.aKv;
                    a.this.aED.aKR = Fp.aKR;
                    a.this.aED.aJE = Fp.aJE;
                    a.this.aED.aJI = Fp.aJI;
                    a.this.aED.aKl = Fp.aKl;
                    a.this.aED.aKj = Fp.aKj;
                    a.this.aED.aKe = Fp.aKe;
                    a.this.aED.aKs = Fp.aKs;
                    a.this.aED.aKt = Fp.aKt;
                    a.this.aED.aKy = Fp.aKy;
                    if (Fp.aKo != null && Fp.aKo.aPq != null && !Fp.aKo.aPq.isEmpty()) {
                        a.this.aED.aKo = Fp.aKo;
                    }
                    if (Fp.aJZ != null) {
                        if (Fp.aJZ.userId != 0) {
                            a.this.aED.aJZ = Fp.aJZ;
                            TbadkCoreApplication.getCurrentAccountObj().setNameShow(a.this.aED.aJZ.nickName);
                        } else {
                            if (a.this.aED.aJZ == null) {
                                a.this.aED.aJZ = new AlaLiveUserInfoData();
                            }
                            a.this.aED.aJZ.throneUid = Fp.aJZ.throneUid;
                        }
                    }
                    if (Fp.aKc != null) {
                        a.this.aED.aKc = Fp.aKc;
                    }
                    if (Fp.aKj) {
                        a.this.aED.aKk = Fp.aKk;
                        if (a.this.ozm != null) {
                            a.this.ozm.S(Fp.aKk);
                        }
                    }
                    if (!a.this.mIsHost && a.this.aED.mLiveInfo != null) {
                        int i = a.this.aED.mLiveInfo.backstage_type;
                        if (a.this.ozm != null) {
                            a.this.ozm.he(String.valueOf(i));
                        }
                    }
                    if (a.this.ozm != null) {
                        a.this.ozm.setAlaLiveShowData(a.this.aED);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501033, a.this.aED));
                    a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, a.this.aED);
                    if (a.this.aED != null) {
                        com.baidu.live.im.b.d.KQ().W(a.this.aED.aKk);
                    }
                    if (z) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501014, new g(roomMode2, roomMode)));
                    }
                }
            }
        };
        this.ozv = new HttpMessageListener(1031044) { // from class: com.baidu.tieba.yuyinala.liveroom.k.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                long j;
                if (httpResponsedMessage != null && httpResponsedMessage.getOrginalMessage().getTag() == a.this.unique_id) {
                    List<Long> list = null;
                    if (httpResponsedMessage instanceof AlaMGetLiveStatusHttpResponseMessage) {
                        AlaMGetLiveStatusHttpResponseMessage alaMGetLiveStatusHttpResponseMessage = (AlaMGetLiveStatusHttpResponseMessage) httpResponsedMessage;
                        list = alaMGetLiveStatusHttpResponseMessage.getClosedIds();
                        j = alaMGetLiveStatusHttpResponseMessage.getInterval();
                    } else {
                        j = 5000;
                    }
                    long j2 = j >= 5000 ? j : 5000L;
                    if (list != null && list.size() > 0 && a.this.hLR != null && a.this.hLR.size() > 0) {
                        for (int size = a.this.hLR.size() - 1; size >= 0; size--) {
                            if (((AlaLiveInfoData) a.this.hLR.get(size)).live_id != a.this.aED.mLiveInfo.live_id && list.contains(Long.valueOf(((AlaLiveInfoData) a.this.hLR.get(size)).getLiveID()))) {
                                a.this.hLR.remove(size);
                            }
                        }
                    }
                    if (a.this.aED != null) {
                        a.this.h(a.this.aED.mLiveInfo);
                    }
                    a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 4, Long.valueOf(j2));
                }
            }
        };
        this.hMw = new HttpMessageListener(1031062) { // from class: com.baidu.tieba.yuyinala.liveroom.k.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getOrginalMessage() != null && (httpResponsedMessage.getOrginalMessage().getExtra() instanceof com.baidu.live.q.b)) {
                    com.baidu.live.q.b bVar = (com.baidu.live.q.b) httpResponsedMessage.getOrginalMessage().getExtra();
                    if (bVar.bys != null) {
                        if (httpResponsedMessage.getError() == 0) {
                            bVar.bys.hr(bVar.contentType);
                        } else {
                            bVar.bys.d(bVar.contentType, httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                        }
                    }
                }
            }
        };
        this.hMy = new HttpMessageListener(1031037) { // from class: com.baidu.tieba.yuyinala.liveroom.k.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                c cVar;
                if (httpResponsedMessage != null && httpResponsedMessage.getError() == 0) {
                    if (!(httpResponsedMessage instanceof AlaLiveRecommondHttpResponseMessage)) {
                        cVar = null;
                    } else {
                        cVar = ((AlaLiveRecommondHttpResponseMessage) httpResponsedMessage).ebQ();
                    }
                    if (cVar != null && !ListUtils.isEmpty(cVar.aJS)) {
                        a.this.hLS = cVar.pn + 1;
                        b bVar = cVar.aJS.get(cVar.aJS.size() - 1);
                        if (bVar != null) {
                            a.this.mLastLiveId = bVar.mLiveInfo.live_id;
                        }
                        a.this.a(cVar);
                        if (a.this.aED != null) {
                            a.this.h(a.this.aED.mLiveInfo);
                        }
                        a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 5, cVar);
                    }
                }
            }
        };
        this.blX = bdPageContext;
        this.ozm = new q(bdPageContext, false, this);
        this.hLR = new ArrayList();
        this.hMd = new HashSet();
        initTasks();
        registerListener(this.ozu);
        this.hLL = BdUniqueId.gen();
        registerListener(this.ozv);
        registerListener(this.hMw);
    }

    private void initTasks() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031037, com.baidu.live.a.axj + "ala/audio/recommend/getSwitchLives");
        tbHttpMessageTask.setResponsedClass(AlaLiveRecommondHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.hMy.setTag(this.hLL);
        registerListener(this.hMy);
        TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(1031042, com.baidu.live.a.axj + "ala/audio/live/getAudienceInfo");
        tbHttpMessageTask2.setIsNeedLogin(false);
        tbHttpMessageTask2.setIsNeedTbs(true);
        tbHttpMessageTask2.setRetry(1);
        tbHttpMessageTask2.setResponsedClass(AlaGetAudienceHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask2);
        registerListener(this.hMq);
        TbHttpMessageTask tbHttpMessageTask3 = new TbHttpMessageTask(1031023, com.baidu.live.a.axj + "ala/audio/enterLive");
        tbHttpMessageTask3.setIsNeedLogin(true);
        tbHttpMessageTask3.setIsNeedTbs(true);
        tbHttpMessageTask3.setIsNeedAddCommenParam(true);
        tbHttpMessageTask3.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask3.setResponsedClass(AlaEnterLiveHttpResonseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask3);
        registerListener(this.ozt);
        TbHttpMessageTask tbHttpMessageTask4 = new TbHttpMessageTask(1031084, com.baidu.live.a.axj + "/ala/audio/link/online");
        tbHttpMessageTask4.setIsNeedLogin(true);
        tbHttpMessageTask4.setIsNeedTbs(true);
        tbHttpMessageTask4.setIsNeedAddCommenParam(true);
        tbHttpMessageTask4.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask4.setResponsedClass(GetWheatListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask4);
        registerListener(this.ozs);
        TbHttpMessageTask tbHttpMessageTask5 = new TbHttpMessageTask(1031087, com.baidu.live.a.axj + "ala/audio/mode/getActivityInfo");
        tbHttpMessageTask5.setIsNeedLogin(true);
        tbHttpMessageTask5.setIsNeedTbs(true);
        tbHttpMessageTask5.setIsNeedAddCommenParam(true);
        tbHttpMessageTask5.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask5.setResponsedClass(TeamFightInfoResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask5);
        registerListener(this.ozr);
        TbHttpMessageTask tbHttpMessageTask6 = new TbHttpMessageTask(1031048, com.baidu.live.a.axj + "ala/audio/exitLive");
        tbHttpMessageTask6.setIsNeedLogin(false);
        tbHttpMessageTask6.setIsNeedTbs(true);
        tbHttpMessageTask6.setIsNeedAddCommenParam(true);
        tbHttpMessageTask6.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask6.setResponsedClass(AlaQuitLiveHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask6);
        registerListener(this.ozq);
        com.baidu.live.tieba.f.a.a.a(1021121, "ala/sdk/v1/open/getUserLiveMarkInfo", AlaUserLiveMarkInfoResponseMessage.class, true, true, true, true);
        registerListener(this.hMr);
        TbHttpMessageTask tbHttpMessageTask7 = new TbHttpMessageTask(1031071, TbConfig.SERVER_ADDRESS + "ala/UGC/getUGCAnchorInfo");
        tbHttpMessageTask7.setIsNeedLogin(false);
        tbHttpMessageTask7.setIsNeedTbs(true);
        tbHttpMessageTask7.setResponsedClass(MasterIdentityResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask7);
        registerListener(this.hMm);
    }

    public void cjo() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913043, new CustomMessageTask.CustomRunnable<ImSendMsgData>() { // from class: com.baidu.tieba.yuyinala.liveroom.k.a.1
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<ImSendMsgData> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    a.this.e(customMessage.getData());
                    return null;
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void cjp() {
        MessageManager.getInstance().unRegisterTask(2913043);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, String str, int i2, Object obj) {
        if (this.ozf != null) {
            this.ozf.a(i, str, i2, obj);
        }
    }

    public void hM(long j) {
        com.baidu.tieba.yuyinala.liveroom.messages.b bVar = new com.baidu.tieba.yuyinala.liveroom.messages.b();
        bVar.setLiveId(j);
        bVar.setParams();
        sendMessage(bVar);
    }

    public void a(long j, String str, long j2) {
        e eVar = new e();
        eVar.setLiveId(j);
        eVar.setFrom(str);
        eVar.bd(j2);
        eVar.setParams();
        sendMessage(eVar);
    }

    public void ag(ab abVar) {
        if (abVar != null) {
            try {
                sendMessage(new com.baidu.tieba.yuyinala.liveroom.alaaudiopk.d(0, com.baidu.tieba.yuyinala.liveroom.wheat.e.g.av(abVar), com.baidu.tieba.yuyinala.liveroom.wheat.e.g.ax(abVar), Long.parseLong(com.baidu.tieba.yuyinala.liveroom.wheat.e.g.aw(abVar)), com.baidu.tieba.yuyinala.liveroom.wheat.e.g.as(abVar)));
            } catch (Exception e) {
                Log.d(":nht...", "");
            }
        }
    }

    public void a(long j, String str, long j2, long j3) {
        e eVar = new e();
        eVar.setLiveId(j);
        eVar.setFrom(str);
        eVar.bd(j2);
        eVar.aS(j3);
        eVar.setParams();
        sendMessage(eVar);
    }

    public void cjA() {
        if (TbadkCoreApplication.isLogin()) {
            HttpMessage httpMessage = new HttpMessage(1021121);
            httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccount());
            sendMessage(httpMessage);
        }
    }

    public ab Fp() {
        return this.aED;
    }

    public void setLiveShowData(ab abVar) {
        this.aED = abVar;
    }

    public List<AlaLiveInfoData> cjC() {
        return this.hLR;
    }

    public v bTX() {
        return this.gQG;
    }

    public com.baidu.tieba.yuyinala.liveroom.alaaudiopk.c ebR() {
        return this.ouJ;
    }

    public void cH(List<Long> list) {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
            com.baidu.tieba.yuyinala.liveroom.messages.c cVar = new com.baidu.tieba.yuyinala.liveroom.messages.c();
            if (this.aED != null && this.aED.mLiveInfo != null) {
                cVar.setAudienceCount(this.aED.mLiveInfo.audience_count);
            }
            cVar.setListIds(list);
            cVar.setParams();
            sendMessage(cVar);
        }
    }

    public void cjD() {
        ArrayList arrayList = new ArrayList();
        for (AlaLiveInfoData alaLiveInfoData : this.hLR) {
            if (alaLiveInfoData != null) {
                arrayList.add(Long.valueOf(alaLiveInfoData.live_id));
            }
        }
        cH(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c cVar) {
        if (cVar != null) {
            if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isYinbo()) {
                if (this.hLR.size() == 1 && this.hLR.get(0).live_id == this.aED.mLiveInfo.live_id) {
                    if (c(cVar) != null) {
                    }
                    b(cVar);
                    return;
                }
                b(cVar);
                return;
            }
            b(cVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(c cVar) {
        boolean z;
        for (b bVar : cVar.aJS) {
            if (bVar != null && bVar.mLiveInfo != null) {
                for (AlaLiveInfoData alaLiveInfoData : this.hLR) {
                    if (alaLiveInfoData == null || alaLiveInfoData.live_id == bVar.mLiveInfo.live_id) {
                        z = false;
                        break;
                    }
                    while (r4.hasNext()) {
                    }
                }
                z = true;
                if (z) {
                    this.hLR.add(bVar.mLiveInfo);
                }
            }
        }
        if (this.hLR.size() >= 200) {
            ArrayList arrayList = new ArrayList();
            for (int size = this.hLR.size() - 200; size < this.hLR.size(); size++) {
                arrayList.add(this.hLR.get(size));
            }
            if (!ListUtils.isEmpty(arrayList)) {
                this.hLR.clear();
                this.hLR.addAll(arrayList);
                arrayList.clear();
            }
        }
    }

    private AlaLiveInfoData c(c cVar) {
        if (ListUtils.isEmpty(cVar.aJS)) {
            return null;
        }
        for (b bVar : cVar.aJS) {
            if (bVar != null && bVar.mLiveInfo != null && bVar.mLiveInfo.live_id == this.aED.mLiveInfo.live_id) {
                return bVar.mLiveInfo;
            }
        }
        return null;
    }

    public ArrayList<AlaLiveInfoData> cjE() {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        if (ListUtils.isEmpty(this.hLR)) {
            return null;
        }
        if (this.hMd.isEmpty()) {
            arrayList.addAll(this.hLR);
        } else {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.hLR.size()) {
                    break;
                }
                if ((this.aED == null || this.aED.mLiveInfo == null || this.aED.mLiveInfo.live_id != this.hLR.get(i2).live_id) && !this.hMd.contains(Long.valueOf(this.hLR.get(i2).live_id))) {
                    arrayList.add(this.hLR.get(i2));
                }
                i = i2 + 1;
            }
        }
        return arrayList;
    }

    public void g(AlaLiveInfoData alaLiveInfoData) {
        if (alaLiveInfoData != null) {
            this.hMd.add(Long.valueOf(alaLiveInfoData.getLiveID()));
            if (this.hMd.size() >= this.hLR.size() - 4) {
                oG(false);
            }
        }
    }

    public void wa(int i) {
        this.hLY = i;
    }

    public void oG(boolean z) {
        oH(z);
    }

    private void oH(boolean z) {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.hMg >= 1800000) {
                this.hMf = currentTimeMillis;
                this.hMh = true;
            }
            if (this.hMh) {
                HttpMessage httpMessage = new HttpMessage(1031037);
                httpMessage.addParam(Config.PACKAGE_NAME, z ? 0 : this.hLS);
                httpMessage.addParam("ps", 20);
                httpMessage.addParam("scr_w", BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst()));
                httpMessage.addParam("scr_h", BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst()));
                httpMessage.addParam("q_type", 0);
                httpMessage.addParam("scr_dip", String.valueOf(BdUtilHelper.getEquipmentDensity(TbadkCoreApplication.getInst())));
                httpMessage.addParam("forum_id", "");
                httpMessage.addParam("entry_name", "");
                httpMessage.addParam("live_id", this.mLastLiveId);
                httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccountId());
                httpMessage.addParam("slide_session_id", this.hMf);
                httpMessage.setTag(this.hLL);
                sendMessage(httpMessage);
                this.hMg = currentTimeMillis;
            }
        }
    }

    public void a(long j, boolean z, String str, String str2) {
        Address address = BdLocationMananger.getInstance().getAddress(false);
        com.baidu.tieba.yuyinala.liveroom.messages.a aVar = new com.baidu.tieba.yuyinala.liveroom.messages.a();
        if (address != null) {
            aVar.b(address.getLongitude(), address.getLatitude());
        }
        aVar.setForumName(str2);
        aVar.An(str);
        aVar.setLiveId(j);
        aVar.setParams();
        sendMessage(aVar);
    }

    public void Wb(String str) {
        sendMessage(new n(str));
    }

    public void aw(String str, String str2, String str3) {
        Address address = BdLocationMananger.getInstance().getAddress(false);
        com.baidu.tieba.yuyinala.liveroom.messages.a aVar = new com.baidu.tieba.yuyinala.liveroom.messages.a();
        if (address != null) {
            aVar.b(address.getLongitude(), address.getLatitude());
        }
        aVar.setForumName(str3);
        aVar.An(str2);
        aVar.setUk(str);
        aVar.setParams();
        sendMessage(aVar);
    }

    public void Ih(String str) {
        Address address = BdLocationMananger.getInstance().getAddress(false);
        com.baidu.tieba.yuyinala.liveroom.messages.a aVar = new com.baidu.tieba.yuyinala.liveroom.messages.a();
        if (address != null) {
            aVar.b(address.getLongitude(), address.getLatitude());
        }
        aVar.setRoomId(str);
        aVar.setParams();
        sendMessage(aVar);
    }

    public void fI(long j) {
        this.ozm.zU();
        this.hLZ = null;
        com.baidu.tieba.yuyinala.liveroom.messages.d dVar = new com.baidu.tieba.yuyinala.liveroom.messages.d();
        dVar.setLiveId(j);
        dVar.setParams();
        dVar.setTag(BdUniqueId.gen());
        sendMessage(dVar);
    }

    public void b(AlaLiveInfoCoreData alaLiveInfoCoreData) {
        if (this.aED == null) {
            this.aED = new ab(alaLiveInfoCoreData);
            this.aED.bx(true);
            this.ozm.setAlaLiveShowData(this.aED);
        }
        this.mLastLiveId = this.aED.mLiveInfo.live_id;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return true;
    }

    public void destory() {
        this.hLM.removeCallbacksAndMessages(null);
        cancelLoadData();
        MessageManager.getInstance().unRegisterListener(this.hMy);
        MessageManager.getInstance().removeMessageRule(this.hMa);
        MessageManager.getInstance().unRegisterListener(this.unique_id);
        MessageManager.getInstance().unRegisterTask(1021163);
        MessageManager.getInstance().removeMessage(1031062, getUniqueId());
        this.ozm.zU();
        this.ozn = null;
        this.blX = null;
    }

    public void wb(int i) {
        this.hLT = i;
        if (this.hLR.size() == 0) {
            this.hLT = 0;
        } else if (this.hLT < 0) {
            this.hLT = this.hLR.size() + this.hLT;
        } else {
            this.hLT %= this.hLR.size();
        }
    }

    public void h(AlaLiveInfoData alaLiveInfoData) {
        if (alaLiveInfoData != null && this.hLR.size() != 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.hLR.size()) {
                    if (this.hLR.get(i2).live_id != alaLiveInfoData.live_id) {
                        i = i2 + 1;
                    } else {
                        this.hLT = i2;
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public boolean cjH() {
        long j;
        if (this.aED == null || this.aED.mLiveInfo == null || this.hLR.size() <= 0) {
            return true;
        }
        AlaLiveInfoData alaLiveInfoData = this.hLR.get(0);
        if (alaLiveInfoData == null) {
            j = 0;
        } else {
            j = alaLiveInfoData.live_id;
        }
        return j == this.aED.mLiveInfo.live_id;
    }

    public boolean cjI() {
        long j;
        if (this.aED == null || this.aED.mLiveInfo == null || this.hLR.size() <= 0) {
            return true;
        }
        AlaLiveInfoData alaLiveInfoData = this.hLR.get(this.hLR.size() - 1);
        if (alaLiveInfoData == null) {
            j = 0;
        } else {
            j = alaLiveInfoData.live_id;
        }
        return j == this.aED.mLiveInfo.live_id;
    }

    public int cjJ() {
        return this.hLT;
    }

    public AlaLiveInfoData cjM() {
        if (this.hLT >= this.hLR.size()) {
            this.hLT = this.hLR.size() - 1;
        }
        if (this.hLT < 0) {
            this.hLT = 0;
        }
        if (this.hLR.size() <= this.hLT) {
            if (this.aED != null) {
                return this.aED.mLiveInfo;
            }
            return null;
        }
        return this.hLR.get(this.hLT);
    }

    public void a(InterfaceC0934a interfaceC0934a) {
        this.ozf = interfaceC0934a;
    }

    @Override // com.baidu.live.im.q.a
    public void d(List<com.baidu.live.im.data.b> list, boolean z) {
        if (this.ozn != null) {
            this.ozn.d(list, z);
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913038, list));
        }
    }

    @Override // com.baidu.live.im.q.a
    public void t(com.baidu.live.im.data.b bVar) {
        if (this.aED != null && this.aED.mLiveInfo.live_type == 1) {
            Q(bVar);
        }
        if (this.ozn != null) {
            this.ozn.t(bVar);
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913037, bVar));
        }
    }

    public void Q(com.baidu.live.im.data.b bVar) {
        JSONObject jSONObject;
        try {
            if (bVar.getObjContent() instanceof JSONObject) {
                jSONObject = (JSONObject) bVar.getObjContent();
            } else {
                jSONObject = new JSONObject(bVar.getContent());
            }
        } catch (JSONException e) {
            jSONObject = null;
        }
        if ((bVar.getMsgType() == 12 || bVar.getMsgType() == 13) && jSONObject != null && "ss_hot_live".equals(jSONObject.optString("content_type")) && !this.mIsHost) {
            oG(true);
        }
    }

    @Override // com.baidu.live.im.q.a
    public void JH() {
        if (this.ozn != null) {
            this.ozn.JH();
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913044));
        }
    }

    public void e(ImSendMsgData imSendMsgData) {
        AlaLiveUserInfoData alaLiveUserInfoData;
        if (this.aED != null) {
            if (this.mIsHost) {
                alaLiveUserInfoData = this.aED.aJD;
            } else {
                alaLiveUserInfoData = this.aED.aJZ;
            }
            if (alaLiveUserInfoData != null) {
                String[] strArr = this.aED.mLiveInfo.imEffect;
                String[] strArr2 = null;
                if (strArr != null) {
                    strArr2 = new String[strArr.length];
                    System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
                }
                if (!TbadkCoreApplication.getInst().isMobileBaidu() && this.aED != null && this.aED.aJZ != null && this.aED.mLiveInfo != null) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    String str = this.aED.aJZ.throneUid;
                    if (!TextUtils.isEmpty(currentAccount) && !TextUtils.isEmpty(str) && currentAccount.equals(str)) {
                        if (strArr2 == null || strArr2.length != 2) {
                            strArr2 = new String[2];
                            strArr2[1] = "";
                        }
                        strArr2[0] = "guard_seat_effect";
                    }
                }
                this.ozm.a(imSendMsgData, alaLiveUserInfoData.isOfficial == 1, alaLiveUserInfoData.isAdmin == 1, alaLiveUserInfoData.levelId, this.otherParams, strArr2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjN() {
        this.ozm.e(String.valueOf(this.aED.mLiveInfo.getGroupID()), String.valueOf(this.aED.mLiveInfo.getLastMsgID()), String.valueOf(this.aED.mLiveInfo.getUserID()), String.valueOf(this.aED.mLiveInfo.getLiveID()), this.aED.mLiveInfo.appId);
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public String cjQ() {
        return this.hLZ;
    }

    public void HC(String str) {
        this.hLZ = str;
    }
}

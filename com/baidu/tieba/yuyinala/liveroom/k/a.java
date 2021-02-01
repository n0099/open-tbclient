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
/* loaded from: classes11.dex */
public class a extends BdBaseModel implements q.a {
    private ab aDd;
    private BdPageContext<?> bkx;
    private v gOJ;
    private BdUniqueId hJO;
    private Handler hJP;
    private List<AlaLiveInfoData> hJU;
    private int hJV;
    private int hJW;
    private HttpMessageListener hKB;
    private int hKa;
    private int hKb;
    private String hKc;
    private com.baidu.live.ac.a hKd;
    private Set<Long> hKg;
    private long hKi;
    private long hKj;
    private boolean hKk;
    private HttpMessageListener hKp;
    private HttpMessageListener hKt;
    private HttpMessageListener hKu;
    private HttpMessageListener hKz;
    private boolean mIsHost;
    private long mLastLiveId;
    private com.baidu.tieba.yuyinala.liveroom.alaaudiopk.c osd;
    private String otherParams;
    private InterfaceC0926a owA;
    private final q owH;
    private q.a owI;
    public boolean owJ;
    public boolean owK;
    private HttpMessageListener owL;
    private HttpMessageListener owM;
    private HttpMessageListener owN;
    private HttpMessageListener owO;
    private HttpMessageListener owP;
    private HttpMessageListener owQ;

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0926a {
        void a(int i, String str, int i2, Object obj);
    }

    public a(BdPageContext<?> bdPageContext) {
        super(bdPageContext);
        this.hJP = new Handler();
        this.hJV = 0;
        this.hJW = 0;
        this.hKa = -1;
        this.hKb = 0;
        this.hKd = new com.baidu.live.ac.a(0);
        this.otherParams = "";
        this.hKi = System.currentTimeMillis();
        this.hKk = true;
        this.hKj = 0L;
        this.owJ = true;
        this.owK = false;
        this.hKp = new HttpMessageListener(1031071) { // from class: com.baidu.tieba.yuyinala.liveroom.k.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                String ciS;
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof MasterIdentityResponseMessage)) {
                    MasterIdentityResponseMessage masterIdentityResponseMessage = (MasterIdentityResponseMessage) httpResponsedMessage;
                    if ((masterIdentityResponseMessage.ciQ() == 1 || masterIdentityResponseMessage.ciR() == 1) && !TextUtils.isEmpty(masterIdentityResponseMessage.ciS())) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("text", masterIdentityResponseMessage.ciS());
                            jSONObject.put("content_type", "custom_master_identity");
                            ciS = jSONObject.toString();
                        } catch (JSONException e) {
                            ciS = masterIdentityResponseMessage.ciS();
                            e.printStackTrace();
                        }
                        a.this.owH.a(27, ciS, (com.baidu.live.data.a) null);
                    }
                }
            }
        };
        this.owL = new HttpMessageListener(1031048) { // from class: com.baidu.tieba.yuyinala.liveroom.k.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            }
        };
        this.owM = new HttpMessageListener(1031087) { // from class: com.baidu.tieba.yuyinala.liveroom.k.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof TeamFightInfoResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == a.this.unique_id) {
                    com.baidu.tieba.yuyinala.liveroom.alaaudiopk.c eaE = ((TeamFightInfoResponseMessage) httpResponsedMessage).eaE();
                    if (eaE != null) {
                        a.this.osd = eaE;
                    }
                    a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 12, eaE);
                }
            }
        };
        this.owN = new HttpMessageListener(1031084) { // from class: com.baidu.tieba.yuyinala.liveroom.k.a.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetWheatListHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == a.this.unique_id) {
                    UbcAudioFlowStatisticManager.getInstance().doSlotEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_MIC_LITE_API_FLOW, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""), "micLiteApi");
                    UbcAudioFlowStatisticManager.getInstance().doSlotStart(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_MIC_LITE_API_FLOW, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""), "micLiteApiHandle", null);
                    AlaWheatInfoDataWrapper alaWheatInfoDataWrapper = ((GetWheatListHttpResponseMessage) httpResponsedMessage).aIY;
                    if (alaWheatInfoDataWrapper != null) {
                        a.this.aDd.aIY = alaWheatInfoDataWrapper;
                        if (alaWheatInfoDataWrapper.getRoomMode() == 1) {
                            a.this.aDd.aIV = new dd();
                            a.this.aDd.aIV.mStep = alaWheatInfoDataWrapper.getActivityStage();
                        }
                        a.this.aDd.aJn = true;
                        UbcAudioFlowStatisticManager.getInstance().doSlotEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_MIC_LITE_API_FLOW, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""), "micLiteApiHandle");
                        UbcAudioFlowStatisticManager.getInstance().doSlotStart(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_MIC_LITE_API_FLOW, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""), "UIRendering", null);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501033, a.this.aDd));
                        a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, a.this.aDd);
                        UbcAudioFlowStatisticManager.getInstance().doSlotEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_MIC_LITE_API_FLOW, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""), "UIRendering");
                        UbcAudioFlowStatisticManager.getInstance().endFlow(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_MIC_LITE_API_FLOW, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""));
                    }
                }
            }
        };
        this.owO = new HttpMessageListener(1031023) { // from class: com.baidu.tieba.yuyinala.liveroom.k.a.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                long j = 0;
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaEnterLiveHttpResonseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == a.this.unique_id) {
                    a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 11, a.this.aDd);
                    a.this.aDd = ((AlaEnterLiveHttpResonseMessage) httpResponsedMessage).Fm();
                    if (a.this.aDd != null) {
                        a.this.aDd.aJo = true;
                        a.this.aDd.aJn = true;
                    }
                    a.this.owH.setAlaLiveShowData(a.this.aDd);
                    if (a.this.aDd != null && a.this.aDd.mLiveInfo != null) {
                        if (!TbadkCoreApplication.getInst().isOther() && (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isActivityTaskWatchUnabled())) {
                            com.baidu.tieba.yuyinala.liveroom.task.b.ebM().fK(a.this.aDd.mLiveInfo.live_id);
                        }
                        LiveTimerManager.getInstance().start(a.this.aDd.mLiveInfo.live_id);
                    }
                    if (a.this.aDd != null && TbadkCoreApplication.getCurrentAccountInfo() != null) {
                        if (a.this.aDd.aIz != null) {
                            if (a.this.aDd.aIz.levelId > 0) {
                                TbadkCoreApplication.getCurrentAccountInfo().setLiveLevel(a.this.aDd.aIz.levelId);
                            }
                            TbadkCoreApplication.getCurrentAccountObj().setNameShow(a.this.aDd.aIz.nickName);
                            if (!TextUtils.isEmpty(a.this.aDd.aIz.portrait)) {
                                TbadkCoreApplication.getCurrentAccountObj().setPortrait(a.this.aDd.aIz.portrait);
                            }
                        }
                        if (a.this.aDd.mLiveSdkInfo != null) {
                            TbadkCoreApplication.getInst().setTbs(a.this.aDd.mLiveSdkInfo.tbs);
                            com.baidu.live.d.xc().putString("ala_account_user_tbs", a.this.aDd.mLiveSdkInfo.tbs);
                        }
                    }
                    if (a.this.aDd != null) {
                        if (a.this.hJU.size() <= 0) {
                            a.this.hJU.add(a.this.aDd.mLiveInfo);
                            a.this.hKg.add(Long.valueOf(a.this.aDd.mLiveInfo.getLiveID()));
                        }
                        a.this.h(a.this.aDd.mLiveInfo);
                        if (a.this.owH != null) {
                            a.this.owH.S(a.this.aDd.aIK);
                        }
                        if (a.this.hJU != null && a.this.hJU.size() > 0) {
                            for (AlaLiveInfoData alaLiveInfoData : a.this.hJU) {
                                if (alaLiveInfoData.live_id == a.this.aDd.mLiveInfo.live_id) {
                                    alaLiveInfoData.bg_cover = a.this.aDd.aIU.bg_cover;
                                    alaLiveInfoData.is_followed = a.this.aDd.aIU.is_followed;
                                    alaLiveInfoData.room_name = a.this.aDd.aIU.room_name;
                                }
                            }
                        }
                    }
                    if (a.this.aDd != null && a.this.aDd.aIf != null) {
                        a.this.hKa = a.this.aDd.aIf.follow_status;
                    }
                    UbcAudioFlowStatisticManager.getInstance().doSlotEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_ENTER_AUDIO_ROOM_PERF_FLOW, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""), "enterLiveApiHandle");
                    UbcAudioFlowStatisticManager.getInstance().doSlotStart(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_ENTER_AUDIO_ROOM_PERF_FLOW, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""), "UIRendering", null);
                    a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 3, a.this.aDd);
                    if (a.this.aDd != null && a.this.aDd.mLiveInfo != null) {
                        a.this.cjA();
                    }
                    if (a.this.aDd != null) {
                        a.this.aDd.isHost = false;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913081, a.this.aDd));
                        com.baidu.live.im.b.d.KN().W(a.this.aDd.aIK);
                    }
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        if (a.this.aDd != null && a.this.aDd.mLiveInfo != null) {
                            long j2 = a.this.aDd.mLiveInfo.live_id;
                            long j3 = a.this.aDd.mLiveInfo.room_id;
                            String str = a.this.aDd.mLiveInfo.feed_id;
                            String str2 = "";
                            if (a.this.aDd.aId != null) {
                                long j4 = a.this.aDd.aId.userId;
                                str2 = a.this.aDd.aId.userName;
                                j = j4;
                            }
                            HKStaticManager.staticStartPlayTime(j2 + "", j3 + "", j + "", str2, System.currentTimeMillis(), str, a.this.otherParams);
                        }
                    } else if ((TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) && a.this.aDd != null && a.this.aDd.mLiveInfo != null) {
                        long j5 = a.this.aDd.mLiveInfo.live_id;
                        long j6 = a.this.aDd.mLiveInfo.room_id;
                        String str3 = a.this.aDd.mLiveInfo.feed_id;
                        String str4 = "";
                        if (a.this.aDd.aId != null) {
                            j = a.this.aDd.aId.userId;
                            str4 = a.this.aDd.aId.userName;
                        }
                        QMStaticManager.staticStartPlayTime(j5 + "", j6 + "", j + "", str4, System.currentTimeMillis(), str3, a.this.otherParams, a.this.hJW + "");
                    }
                    com.baidu.live.d.xc().putLong("audio_enter_live_timestamp", System.currentTimeMillis() / 1000);
                }
            }
        };
        this.hKt = new HttpMessageListener(1031042) { // from class: com.baidu.tieba.yuyinala.liveroom.k.a.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaGetAudienceHttpResponseMessage)) {
                    v bTK = ((AlaGetAudienceHttpResponseMessage) httpResponsedMessage).bTK();
                    Message<?> message = httpResponsedMessage.getmOrginalMessage();
                    if (message instanceof com.baidu.tieba.yuyinala.liveroom.messages.b) {
                        com.baidu.tieba.yuyinala.liveroom.messages.b bVar = (com.baidu.tieba.yuyinala.liveroom.messages.b) message;
                        if (String.valueOf(bVar.ebz()).equals(a.this.aDd.aIU.live_id)) {
                            bTK.liveId = String.valueOf(bVar.ebz());
                        } else {
                            return;
                        }
                    }
                    if (bTK != null) {
                        a.this.gOJ = bTK;
                    }
                    if (a.this.aDd != null && a.this.aDd.aIf != null) {
                        if (a.this.hKa == -1) {
                            a.this.hKa = a.this.aDd.aIf.follow_status;
                        }
                        if (a.this.aDd.aIf.follow_status != a.this.hKa) {
                            a.this.aDd.aIf.follow_status = a.this.hKa;
                        }
                    }
                    a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 2, a.this.gOJ);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913016, a.this.gOJ));
                }
            }
        };
        this.hKu = new HttpMessageListener(1021121) { // from class: com.baidu.tieba.yuyinala.liveroom.k.a.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaUserLiveMarkInfoResponseMessage) {
                    AlaUserLiveMarkInfoResponseMessage alaUserLiveMarkInfoResponseMessage = (AlaUserLiveMarkInfoResponseMessage) httpResponsedMessage;
                    if (alaUserLiveMarkInfoResponseMessage.getError() == 0) {
                        List<AlaLiveMarkData> ciP = alaUserLiveMarkInfoResponseMessage.ciP();
                        a.this.owH.S(ciP);
                        if (a.this.aDd != null) {
                            a.this.aDd.aIK = ciP;
                            com.baidu.live.im.b.d.KN().W(a.this.aDd.aIK);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913118, a.this.aDd));
                        }
                    }
                }
            }
        };
        this.owP = new HttpMessageListener(1031024) { // from class: com.baidu.tieba.yuyinala.liveroom.k.a.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof YuyinGetLiveInfoHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == a.this.unique_id) {
                    if (httpResponsedMessage.hasError()) {
                        a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, null);
                        return;
                    }
                    ab Fm = httpResponsedMessage instanceof YuyinGetLiveInfoHttpResponseMessage ? ((YuyinGetLiveInfoHttpResponseMessage) httpResponsedMessage).Fm() : null;
                    if (Fm == null) {
                        a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, Fm);
                        return;
                    }
                    if (a.this.aDd == null) {
                        a.this.aDd = Fm;
                        a.this.owH.setAlaLiveShowData(a.this.aDd);
                    } else if (a.this.aDd.mLiveInfo != null && Fm.mLiveInfo != null && a.this.aDd.mLiveInfo.live_id != Fm.mLiveInfo.live_id) {
                        a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, a.this.aDd);
                        return;
                    }
                    if (a.this.aDd.mLiveInfo != null && Fm.mLiveInfo != null && a.this.aDd.mLiveInfo.user_id == Fm.mLiveInfo.user_id) {
                        if (a.this.aDd.mLiveInfo.mLiveCloseData != null && Fm.mLiveInfo.mLiveCloseData == null) {
                            Fm.mLiveInfo.mLiveCloseData = a.this.aDd.mLiveInfo.mLiveCloseData;
                        }
                        if (a.this.aDd.mLiveInfo.mAlaLiveSwitchData != null && Fm.mLiveInfo.mAlaLiveSwitchData == null) {
                            Fm.mLiveInfo.mAlaLiveSwitchData = a.this.aDd.mLiveInfo.mAlaLiveSwitchData;
                        }
                    }
                    a.this.aDd.mLiveInfo = Fm.mLiveInfo;
                    a.this.aDd.aId = Fm.aId;
                    if (a.this.aDd.aIU != null && Fm.aIU != null) {
                        if (a.this.aDd.aIU.aTP == Fm.aIU.aTP) {
                            if (!TextUtils.equals(a.this.aDd.aIU.bg_cover, Fm.aIU.bg_cover) || !TextUtils.equals(a.this.aDd.aIU.aTO, Fm.aIU.aTO)) {
                                a.this.owJ = true;
                            } else {
                                a.this.owJ = false;
                            }
                        } else {
                            a.this.owJ = true;
                        }
                    }
                    int roomMode = Fm.aIY != null ? Fm.aIY.getRoomMode() : -1;
                    int roomMode2 = a.this.aDd.aIY != null ? a.this.aDd.aIY.getRoomMode() : -1;
                    boolean z = (roomMode2 == -1 || roomMode == -1 || roomMode2 == roomMode) ? false : true;
                    if (z) {
                        a.this.owJ = true;
                    }
                    a.this.aDd.aJn = false;
                    a.this.aDd.aIU = Fm.aIU;
                    a.this.aDd.aIV = Fm.aIV;
                    a.this.aDd.aJr = Fm.aJr;
                    a.this.aDd.aIe = Fm.aIe;
                    a.this.aDd.aIi = Fm.aIi;
                    a.this.aDd.aIL = Fm.aIL;
                    a.this.aDd.aIJ = Fm.aIJ;
                    a.this.aDd.aIE = Fm.aIE;
                    a.this.aDd.aIS = Fm.aIS;
                    a.this.aDd.aIT = Fm.aIT;
                    a.this.aDd.aIY = Fm.aIY;
                    if (Fm.aIO != null && Fm.aIO.aNQ != null && !Fm.aIO.aNQ.isEmpty()) {
                        a.this.aDd.aIO = Fm.aIO;
                    }
                    if (Fm.aIz != null) {
                        if (Fm.aIz.userId != 0) {
                            a.this.aDd.aIz = Fm.aIz;
                            TbadkCoreApplication.getCurrentAccountObj().setNameShow(a.this.aDd.aIz.nickName);
                        } else {
                            if (a.this.aDd.aIz == null) {
                                a.this.aDd.aIz = new AlaLiveUserInfoData();
                            }
                            a.this.aDd.aIz.throneUid = Fm.aIz.throneUid;
                        }
                    }
                    if (Fm.aIC != null) {
                        a.this.aDd.aIC = Fm.aIC;
                    }
                    if (Fm.aIJ) {
                        a.this.aDd.aIK = Fm.aIK;
                        if (a.this.owH != null) {
                            a.this.owH.S(Fm.aIK);
                        }
                    }
                    if (!a.this.mIsHost && a.this.aDd.mLiveInfo != null) {
                        int i = a.this.aDd.mLiveInfo.backstage_type;
                        if (a.this.owH != null) {
                            a.this.owH.gY(String.valueOf(i));
                        }
                    }
                    if (a.this.owH != null) {
                        a.this.owH.setAlaLiveShowData(a.this.aDd);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501033, a.this.aDd));
                    a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, a.this.aDd);
                    if (a.this.aDd != null) {
                        com.baidu.live.im.b.d.KN().W(a.this.aDd.aIK);
                    }
                    if (z) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501014, new g(roomMode2, roomMode)));
                    }
                }
            }
        };
        this.owQ = new HttpMessageListener(1031044) { // from class: com.baidu.tieba.yuyinala.liveroom.k.a.2
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
                    if (list != null && list.size() > 0 && a.this.hJU != null && a.this.hJU.size() > 0) {
                        for (int size = a.this.hJU.size() - 1; size >= 0; size--) {
                            if (((AlaLiveInfoData) a.this.hJU.get(size)).live_id != a.this.aDd.mLiveInfo.live_id && list.contains(Long.valueOf(((AlaLiveInfoData) a.this.hJU.get(size)).getLiveID()))) {
                                a.this.hJU.remove(size);
                            }
                        }
                    }
                    if (a.this.aDd != null) {
                        a.this.h(a.this.aDd.mLiveInfo);
                    }
                    a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 4, Long.valueOf(j2));
                }
            }
        };
        this.hKz = new HttpMessageListener(1031062) { // from class: com.baidu.tieba.yuyinala.liveroom.k.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getOrginalMessage() != null && (httpResponsedMessage.getOrginalMessage().getExtra() instanceof com.baidu.live.q.b)) {
                    com.baidu.live.q.b bVar = (com.baidu.live.q.b) httpResponsedMessage.getOrginalMessage().getExtra();
                    if (bVar.bwS != null) {
                        if (httpResponsedMessage.getError() == 0) {
                            bVar.bwS.hl(bVar.contentType);
                        } else {
                            bVar.bwS.d(bVar.contentType, httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                        }
                    }
                }
            }
        };
        this.hKB = new HttpMessageListener(1031037) { // from class: com.baidu.tieba.yuyinala.liveroom.k.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                c cVar;
                if (httpResponsedMessage != null && httpResponsedMessage.getError() == 0) {
                    if (!(httpResponsedMessage instanceof AlaLiveRecommondHttpResponseMessage)) {
                        cVar = null;
                    } else {
                        cVar = ((AlaLiveRecommondHttpResponseMessage) httpResponsedMessage).ebA();
                    }
                    if (cVar != null && !ListUtils.isEmpty(cVar.aIs)) {
                        a.this.hJV = cVar.pn + 1;
                        b bVar = cVar.aIs.get(cVar.aIs.size() - 1);
                        if (bVar != null) {
                            a.this.mLastLiveId = bVar.mLiveInfo.live_id;
                        }
                        a.this.a(cVar);
                        if (a.this.aDd != null) {
                            a.this.h(a.this.aDd.mLiveInfo);
                        }
                        a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 5, cVar);
                    }
                }
            }
        };
        this.bkx = bdPageContext;
        this.owH = new q(bdPageContext, false, this);
        this.hJU = new ArrayList();
        this.hKg = new HashSet();
        initTasks();
        registerListener(this.owP);
        this.hJO = BdUniqueId.gen();
        registerListener(this.owQ);
        registerListener(this.hKz);
    }

    private void initTasks() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031037, com.baidu.live.a.avJ + "ala/audio/recommend/getSwitchLives");
        tbHttpMessageTask.setResponsedClass(AlaLiveRecommondHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.hKB.setTag(this.hJO);
        registerListener(this.hKB);
        TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(1031042, com.baidu.live.a.avJ + "ala/audio/live/getAudienceInfo");
        tbHttpMessageTask2.setIsNeedLogin(false);
        tbHttpMessageTask2.setIsNeedTbs(true);
        tbHttpMessageTask2.setRetry(1);
        tbHttpMessageTask2.setResponsedClass(AlaGetAudienceHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask2);
        registerListener(this.hKt);
        TbHttpMessageTask tbHttpMessageTask3 = new TbHttpMessageTask(1031023, com.baidu.live.a.avJ + "ala/audio/enterLive");
        tbHttpMessageTask3.setIsNeedLogin(true);
        tbHttpMessageTask3.setIsNeedTbs(true);
        tbHttpMessageTask3.setIsNeedAddCommenParam(true);
        tbHttpMessageTask3.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask3.setResponsedClass(AlaEnterLiveHttpResonseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask3);
        registerListener(this.owO);
        TbHttpMessageTask tbHttpMessageTask4 = new TbHttpMessageTask(1031084, com.baidu.live.a.avJ + "/ala/audio/link/online");
        tbHttpMessageTask4.setIsNeedLogin(true);
        tbHttpMessageTask4.setIsNeedTbs(true);
        tbHttpMessageTask4.setIsNeedAddCommenParam(true);
        tbHttpMessageTask4.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask4.setResponsedClass(GetWheatListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask4);
        registerListener(this.owN);
        TbHttpMessageTask tbHttpMessageTask5 = new TbHttpMessageTask(1031087, com.baidu.live.a.avJ + "ala/audio/mode/getActivityInfo");
        tbHttpMessageTask5.setIsNeedLogin(true);
        tbHttpMessageTask5.setIsNeedTbs(true);
        tbHttpMessageTask5.setIsNeedAddCommenParam(true);
        tbHttpMessageTask5.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask5.setResponsedClass(TeamFightInfoResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask5);
        registerListener(this.owM);
        TbHttpMessageTask tbHttpMessageTask6 = new TbHttpMessageTask(1031048, com.baidu.live.a.avJ + "ala/audio/exitLive");
        tbHttpMessageTask6.setIsNeedLogin(false);
        tbHttpMessageTask6.setIsNeedTbs(true);
        tbHttpMessageTask6.setIsNeedAddCommenParam(true);
        tbHttpMessageTask6.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask6.setResponsedClass(AlaQuitLiveHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask6);
        registerListener(this.owL);
        com.baidu.live.tieba.f.a.a.a(1021121, "ala/sdk/v1/open/getUserLiveMarkInfo", AlaUserLiveMarkInfoResponseMessage.class, true, true, true, true);
        registerListener(this.hKu);
        TbHttpMessageTask tbHttpMessageTask7 = new TbHttpMessageTask(1031071, TbConfig.SERVER_ADDRESS + "ala/UGC/getUGCAnchorInfo");
        tbHttpMessageTask7.setIsNeedLogin(false);
        tbHttpMessageTask7.setIsNeedTbs(true);
        tbHttpMessageTask7.setResponsedClass(MasterIdentityResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask7);
        registerListener(this.hKp);
    }

    public void cjb() {
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

    public void cjc() {
        MessageManager.getInstance().unRegisterTask(2913043);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, String str, int i2, Object obj) {
        if (this.owA != null) {
            this.owA.a(i, str, i2, obj);
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

    public void cjn() {
        if (TbadkCoreApplication.isLogin()) {
            HttpMessage httpMessage = new HttpMessage(1021121);
            httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccount());
            sendMessage(httpMessage);
        }
    }

    public ab Fm() {
        return this.aDd;
    }

    public void setLiveShowData(ab abVar) {
        this.aDd = abVar;
    }

    public List<AlaLiveInfoData> cjp() {
        return this.hJU;
    }

    public v bTK() {
        return this.gOJ;
    }

    public com.baidu.tieba.yuyinala.liveroom.alaaudiopk.c ebB() {
        return this.osd;
    }

    public void cH(List<Long> list) {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
            com.baidu.tieba.yuyinala.liveroom.messages.c cVar = new com.baidu.tieba.yuyinala.liveroom.messages.c();
            if (this.aDd != null && this.aDd.mLiveInfo != null) {
                cVar.setAudienceCount(this.aDd.mLiveInfo.audience_count);
            }
            cVar.setListIds(list);
            cVar.setParams();
            sendMessage(cVar);
        }
    }

    public void cjq() {
        ArrayList arrayList = new ArrayList();
        for (AlaLiveInfoData alaLiveInfoData : this.hJU) {
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
                if (this.hJU.size() == 1 && this.hJU.get(0).live_id == this.aDd.mLiveInfo.live_id) {
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
        for (b bVar : cVar.aIs) {
            if (bVar != null && bVar.mLiveInfo != null) {
                for (AlaLiveInfoData alaLiveInfoData : this.hJU) {
                    if (alaLiveInfoData == null || alaLiveInfoData.live_id == bVar.mLiveInfo.live_id) {
                        z = false;
                        break;
                    }
                    while (r4.hasNext()) {
                    }
                }
                z = true;
                if (z) {
                    this.hJU.add(bVar.mLiveInfo);
                }
            }
        }
        if (this.hJU.size() >= 200) {
            ArrayList arrayList = new ArrayList();
            for (int size = this.hJU.size() - 200; size < this.hJU.size(); size++) {
                arrayList.add(this.hJU.get(size));
            }
            if (!ListUtils.isEmpty(arrayList)) {
                this.hJU.clear();
                this.hJU.addAll(arrayList);
                arrayList.clear();
            }
        }
    }

    private AlaLiveInfoData c(c cVar) {
        if (ListUtils.isEmpty(cVar.aIs)) {
            return null;
        }
        for (b bVar : cVar.aIs) {
            if (bVar != null && bVar.mLiveInfo != null && bVar.mLiveInfo.live_id == this.aDd.mLiveInfo.live_id) {
                return bVar.mLiveInfo;
            }
        }
        return null;
    }

    public ArrayList<AlaLiveInfoData> cjr() {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        if (ListUtils.isEmpty(this.hJU)) {
            return null;
        }
        if (this.hKg.isEmpty()) {
            arrayList.addAll(this.hJU);
        } else {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.hJU.size()) {
                    break;
                }
                if ((this.aDd == null || this.aDd.mLiveInfo == null || this.aDd.mLiveInfo.live_id != this.hJU.get(i2).live_id) && !this.hKg.contains(Long.valueOf(this.hJU.get(i2).live_id))) {
                    arrayList.add(this.hJU.get(i2));
                }
                i = i2 + 1;
            }
        }
        return arrayList;
    }

    public void g(AlaLiveInfoData alaLiveInfoData) {
        if (alaLiveInfoData != null) {
            this.hKg.add(Long.valueOf(alaLiveInfoData.getLiveID()));
            if (this.hKg.size() >= this.hJU.size() - 4) {
                oG(false);
            }
        }
    }

    public void vY(int i) {
        this.hKb = i;
    }

    public void oG(boolean z) {
        oH(z);
    }

    private void oH(boolean z) {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.hKj >= 1800000) {
                this.hKi = currentTimeMillis;
                this.hKk = true;
            }
            if (this.hKk) {
                HttpMessage httpMessage = new HttpMessage(1031037);
                httpMessage.addParam(Config.PACKAGE_NAME, z ? 0 : this.hJV);
                httpMessage.addParam("ps", 20);
                httpMessage.addParam("scr_w", BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst()));
                httpMessage.addParam("scr_h", BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst()));
                httpMessage.addParam("q_type", 0);
                httpMessage.addParam("scr_dip", String.valueOf(BdUtilHelper.getEquipmentDensity(TbadkCoreApplication.getInst())));
                httpMessage.addParam("forum_id", "");
                httpMessage.addParam("entry_name", "");
                httpMessage.addParam("live_id", this.mLastLiveId);
                httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccountId());
                httpMessage.addParam("slide_session_id", this.hKi);
                httpMessage.setTag(this.hJO);
                sendMessage(httpMessage);
                this.hKj = currentTimeMillis;
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
        aVar.Ag(str);
        aVar.setLiveId(j);
        aVar.setParams();
        sendMessage(aVar);
    }

    public void VI(String str) {
        sendMessage(new n(str));
    }

    public void aw(String str, String str2, String str3) {
        Address address = BdLocationMananger.getInstance().getAddress(false);
        com.baidu.tieba.yuyinala.liveroom.messages.a aVar = new com.baidu.tieba.yuyinala.liveroom.messages.a();
        if (address != null) {
            aVar.b(address.getLongitude(), address.getLatitude());
        }
        aVar.setForumName(str3);
        aVar.Ag(str2);
        aVar.setUk(str);
        aVar.setParams();
        sendMessage(aVar);
    }

    public void HX(String str) {
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
        this.owH.zR();
        this.hKc = null;
        com.baidu.tieba.yuyinala.liveroom.messages.d dVar = new com.baidu.tieba.yuyinala.liveroom.messages.d();
        dVar.setLiveId(j);
        dVar.setParams();
        dVar.setTag(BdUniqueId.gen());
        sendMessage(dVar);
    }

    public void b(AlaLiveInfoCoreData alaLiveInfoCoreData) {
        if (this.aDd == null) {
            this.aDd = new ab(alaLiveInfoCoreData);
            this.aDd.bx(true);
            this.owH.setAlaLiveShowData(this.aDd);
        }
        this.mLastLiveId = this.aDd.mLiveInfo.live_id;
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
        this.hJP.removeCallbacksAndMessages(null);
        cancelLoadData();
        MessageManager.getInstance().unRegisterListener(this.hKB);
        MessageManager.getInstance().removeMessageRule(this.hKd);
        MessageManager.getInstance().unRegisterListener(this.unique_id);
        MessageManager.getInstance().unRegisterTask(1021163);
        MessageManager.getInstance().removeMessage(1031062, getUniqueId());
        this.owH.zR();
        this.owI = null;
        this.bkx = null;
    }

    public void vZ(int i) {
        this.hJW = i;
        if (this.hJU.size() == 0) {
            this.hJW = 0;
        } else if (this.hJW < 0) {
            this.hJW = this.hJU.size() + this.hJW;
        } else {
            this.hJW %= this.hJU.size();
        }
    }

    public void h(AlaLiveInfoData alaLiveInfoData) {
        if (alaLiveInfoData != null && this.hJU.size() != 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.hJU.size()) {
                    if (this.hJU.get(i2).live_id != alaLiveInfoData.live_id) {
                        i = i2 + 1;
                    } else {
                        this.hJW = i2;
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public boolean cju() {
        long j;
        if (this.aDd == null || this.aDd.mLiveInfo == null || this.hJU.size() <= 0) {
            return true;
        }
        AlaLiveInfoData alaLiveInfoData = this.hJU.get(0);
        if (alaLiveInfoData == null) {
            j = 0;
        } else {
            j = alaLiveInfoData.live_id;
        }
        return j == this.aDd.mLiveInfo.live_id;
    }

    public boolean cjv() {
        long j;
        if (this.aDd == null || this.aDd.mLiveInfo == null || this.hJU.size() <= 0) {
            return true;
        }
        AlaLiveInfoData alaLiveInfoData = this.hJU.get(this.hJU.size() - 1);
        if (alaLiveInfoData == null) {
            j = 0;
        } else {
            j = alaLiveInfoData.live_id;
        }
        return j == this.aDd.mLiveInfo.live_id;
    }

    public int cjw() {
        return this.hJW;
    }

    public AlaLiveInfoData cjz() {
        if (this.hJW >= this.hJU.size()) {
            this.hJW = this.hJU.size() - 1;
        }
        if (this.hJW < 0) {
            this.hJW = 0;
        }
        if (this.hJU.size() <= this.hJW) {
            if (this.aDd != null) {
                return this.aDd.mLiveInfo;
            }
            return null;
        }
        return this.hJU.get(this.hJW);
    }

    public void a(InterfaceC0926a interfaceC0926a) {
        this.owA = interfaceC0926a;
    }

    @Override // com.baidu.live.im.q.a
    public void d(List<com.baidu.live.im.data.b> list, boolean z) {
        if (this.owI != null) {
            this.owI.d(list, z);
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913038, list));
        }
    }

    @Override // com.baidu.live.im.q.a
    public void t(com.baidu.live.im.data.b bVar) {
        if (this.aDd != null && this.aDd.mLiveInfo.live_type == 1) {
            Q(bVar);
        }
        if (this.owI != null) {
            this.owI.t(bVar);
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
    public void JE() {
        if (this.owI != null) {
            this.owI.JE();
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913044));
        }
    }

    public void e(ImSendMsgData imSendMsgData) {
        AlaLiveUserInfoData alaLiveUserInfoData;
        if (this.aDd != null) {
            if (this.mIsHost) {
                alaLiveUserInfoData = this.aDd.aId;
            } else {
                alaLiveUserInfoData = this.aDd.aIz;
            }
            if (alaLiveUserInfoData != null) {
                String[] strArr = this.aDd.mLiveInfo.imEffect;
                String[] strArr2 = null;
                if (strArr != null) {
                    strArr2 = new String[strArr.length];
                    System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
                }
                if (!TbadkCoreApplication.getInst().isMobileBaidu() && this.aDd != null && this.aDd.aIz != null && this.aDd.mLiveInfo != null) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    String str = this.aDd.aIz.throneUid;
                    if (!TextUtils.isEmpty(currentAccount) && !TextUtils.isEmpty(str) && currentAccount.equals(str)) {
                        if (strArr2 == null || strArr2.length != 2) {
                            strArr2 = new String[2];
                            strArr2[1] = "";
                        }
                        strArr2[0] = "guard_seat_effect";
                    }
                }
                this.owH.a(imSendMsgData, alaLiveUserInfoData.isOfficial == 1, alaLiveUserInfoData.isAdmin == 1, alaLiveUserInfoData.levelId, this.otherParams, strArr2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjA() {
        this.owH.e(String.valueOf(this.aDd.mLiveInfo.getGroupID()), String.valueOf(this.aDd.mLiveInfo.getLastMsgID()), String.valueOf(this.aDd.mLiveInfo.getUserID()), String.valueOf(this.aDd.mLiveInfo.getLiveID()), this.aDd.mLiveInfo.appId);
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public String cjD() {
        return this.hKc;
    }

    public void Hs(String str) {
        this.hKc = str;
    }
}

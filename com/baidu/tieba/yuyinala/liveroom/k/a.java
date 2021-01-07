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
import com.baidu.live.data.cx;
import com.baidu.live.data.g;
import com.baidu.live.data.r;
import com.baidu.live.data.x;
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
import com.baidu.tieba.yuyinala.liveroom.wheat.model.m;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends BdBaseModel implements q.a {
    private x aGe;
    private BdPageContext<?> blU;
    private r gQJ;
    private Set<Long> hKA;
    private long hKC;
    private long hKD;
    private boolean hKE;
    private HttpMessageListener hKJ;
    private HttpMessageListener hKN;
    private HttpMessageListener hKO;
    private HttpMessageListener hKT;
    private HttpMessageListener hKV;
    private BdUniqueId hKi;
    private Handler hKj;
    private List<AlaLiveInfoData> hKo;
    private int hKp;
    private int hKq;
    private int hKu;
    private int hKv;
    private String hKw;
    private com.baidu.live.ad.a hKx;
    private boolean mIsHost;
    private long mLastLiveId;
    private com.baidu.tieba.yuyinala.liveroom.alaaudiopk.d omO;
    private HttpMessageListener orA;
    private HttpMessageListener orB;
    private HttpMessageListener orC;
    private HttpMessageListener orD;
    private HttpMessageListener orE;
    private HttpMessageListener orF;
    private InterfaceC0939a orp;
    private final q orw;
    private q.a orx;
    public boolean ory;
    public boolean orz;
    private String otherParams;

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0939a {
        void a(int i, String str, int i2, Object obj);
    }

    public a(BdPageContext<?> bdPageContext) {
        super(bdPageContext);
        this.hKj = new Handler();
        this.hKp = 0;
        this.hKq = 0;
        this.hKu = -1;
        this.hKv = 0;
        this.hKx = new com.baidu.live.ad.a(0);
        this.otherParams = "";
        this.hKC = System.currentTimeMillis();
        this.hKE = true;
        this.hKD = 0L;
        this.ory = true;
        this.orz = false;
        this.hKJ = new HttpMessageListener(1031071) { // from class: com.baidu.tieba.yuyinala.liveroom.k.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                String clR;
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof MasterIdentityResponseMessage)) {
                    MasterIdentityResponseMessage masterIdentityResponseMessage = (MasterIdentityResponseMessage) httpResponsedMessage;
                    if ((masterIdentityResponseMessage.clP() == 1 || masterIdentityResponseMessage.clQ() == 1) && !TextUtils.isEmpty(masterIdentityResponseMessage.clR())) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("text", masterIdentityResponseMessage.clR());
                            jSONObject.put("content_type", "custom_master_identity");
                            clR = jSONObject.toString();
                        } catch (JSONException e) {
                            clR = masterIdentityResponseMessage.clR();
                            e.printStackTrace();
                        }
                        a.this.orw.a(27, clR, (com.baidu.live.data.a) null);
                    }
                }
            }
        };
        this.orA = new HttpMessageListener(1031048) { // from class: com.baidu.tieba.yuyinala.liveroom.k.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            }
        };
        this.orB = new HttpMessageListener(1031087) { // from class: com.baidu.tieba.yuyinala.liveroom.k.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof TeamFightInfoResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == a.this.unique_id) {
                    com.baidu.tieba.yuyinala.liveroom.alaaudiopk.d ecj = ((TeamFightInfoResponseMessage) httpResponsedMessage).ecj();
                    if (ecj != null) {
                        a.this.omO = ecj;
                    }
                    a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 12, ecj);
                }
            }
        };
        this.orC = new HttpMessageListener(1031084) { // from class: com.baidu.tieba.yuyinala.liveroom.k.a.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetWheatListHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == a.this.unique_id) {
                    UbcAudioFlowStatisticManager.getInstance().doSlotEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_MIC_LITE_API_FLOW, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""), "micLiteApi");
                    UbcAudioFlowStatisticManager.getInstance().doSlotStart(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_MIC_LITE_API_FLOW, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""), "micLiteApiHandle", null);
                    AlaWheatInfoDataWrapper alaWheatInfoDataWrapper = ((GetWheatListHttpResponseMessage) httpResponsedMessage).aLq;
                    if (alaWheatInfoDataWrapper != null) {
                        a.this.aGe.aLq = alaWheatInfoDataWrapper;
                        if (alaWheatInfoDataWrapper.getRoomMode() == 1) {
                            a.this.aGe.aLm = new cx();
                            a.this.aGe.aLm.mStep = alaWheatInfoDataWrapper.getActivityStage();
                        }
                        a.this.aGe.aLC = true;
                        UbcAudioFlowStatisticManager.getInstance().doSlotEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_MIC_LITE_API_FLOW, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""), "micLiteApiHandle");
                        UbcAudioFlowStatisticManager.getInstance().doSlotStart(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_MIC_LITE_API_FLOW, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""), "UIRendering", null);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501033, a.this.aGe));
                        a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, a.this.aGe);
                        UbcAudioFlowStatisticManager.getInstance().doSlotEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_MIC_LITE_API_FLOW, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""), "UIRendering");
                        UbcAudioFlowStatisticManager.getInstance().endFlow(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_MIC_LITE_API_FLOW, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""));
                    }
                }
            }
        };
        this.orD = new HttpMessageListener(1031023) { // from class: com.baidu.tieba.yuyinala.liveroom.k.a.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                long j = 0;
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaEnterLiveHttpResonseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == a.this.unique_id) {
                    a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 11, a.this.aGe);
                    a.this.aGe = ((AlaEnterLiveHttpResonseMessage) httpResponsedMessage).HR();
                    if (a.this.aGe != null) {
                        a.this.aGe.aLD = true;
                        a.this.aGe.aLC = true;
                    }
                    a.this.orw.setAlaLiveShowData(a.this.aGe);
                    if (a.this.aGe != null && a.this.aGe.mLiveInfo != null) {
                        if (!TbadkCoreApplication.getInst().isOther() && (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isActivityTaskWatchUnabled())) {
                            com.baidu.tieba.yuyinala.liveroom.task.b.edr().fF(a.this.aGe.mLiveInfo.live_id);
                        }
                        LiveTimerManager.getInstance().start(a.this.aGe.mLiveInfo.live_id);
                    }
                    if (a.this.aGe != null && TbadkCoreApplication.getCurrentAccountInfo() != null) {
                        if (a.this.aGe.aKQ != null) {
                            if (a.this.aGe.aKQ.levelId > 0) {
                                TbadkCoreApplication.getCurrentAccountInfo().setLiveLevel(a.this.aGe.aKQ.levelId);
                            }
                            TbadkCoreApplication.getCurrentAccountObj().setNameShow(a.this.aGe.aKQ.nickName);
                            if (!TextUtils.isEmpty(a.this.aGe.aKQ.portrait)) {
                                TbadkCoreApplication.getCurrentAccountObj().setPortrait(a.this.aGe.aKQ.portrait);
                            }
                        }
                        if (a.this.aGe.mLiveSdkInfo != null) {
                            TbadkCoreApplication.getInst().setTbs(a.this.aGe.mLiveSdkInfo.tbs);
                            com.baidu.live.d.Ba().putString("ala_account_user_tbs", a.this.aGe.mLiveSdkInfo.tbs);
                        }
                    }
                    if (a.this.aGe != null) {
                        if (a.this.hKo.size() <= 0) {
                            a.this.hKo.add(a.this.aGe.mLiveInfo);
                            a.this.hKA.add(Long.valueOf(a.this.aGe.mLiveInfo.getLiveID()));
                        }
                        a.this.h(a.this.aGe.mLiveInfo);
                        if (a.this.orw != null) {
                            a.this.orw.R(a.this.aGe.aLb);
                        }
                        if (a.this.hKo != null && a.this.hKo.size() > 0) {
                            for (AlaLiveInfoData alaLiveInfoData : a.this.hKo) {
                                if (alaLiveInfoData.live_id == a.this.aGe.mLiveInfo.live_id) {
                                    alaLiveInfoData.bg_cover = a.this.aGe.aLl.bg_cover;
                                    alaLiveInfoData.is_followed = a.this.aGe.aLl.is_followed;
                                    alaLiveInfoData.room_name = a.this.aGe.aLl.room_name;
                                }
                            }
                        }
                    }
                    if (a.this.aGe != null && a.this.aGe.aKw != null) {
                        a.this.hKu = a.this.aGe.aKw.follow_status;
                    }
                    UbcAudioFlowStatisticManager.getInstance().doSlotEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_ENTER_AUDIO_ROOM_PERF_FLOW, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""), "enterLiveApiHandle");
                    UbcAudioFlowStatisticManager.getInstance().doSlotStart(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_ENTER_AUDIO_ROOM_PERF_FLOW, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""), "UIRendering", null);
                    a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 3, a.this.aGe);
                    if (a.this.aGe != null && a.this.aGe.mLiveInfo != null) {
                        a.this.cmz();
                    }
                    if (a.this.aGe != null) {
                        a.this.aGe.isHost = false;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913081, a.this.aGe));
                        com.baidu.live.im.b.d.Nk().V(a.this.aGe.aLb);
                    }
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        if (a.this.aGe != null && a.this.aGe.mLiveInfo != null) {
                            long j2 = a.this.aGe.mLiveInfo.live_id;
                            long j3 = a.this.aGe.mLiveInfo.room_id;
                            String str = a.this.aGe.mLiveInfo.feed_id;
                            String str2 = "";
                            if (a.this.aGe.aKu != null) {
                                long j4 = a.this.aGe.aKu.userId;
                                str2 = a.this.aGe.aKu.userName;
                                j = j4;
                            }
                            HKStaticManager.staticStartPlayTime(j2 + "", j3 + "", j + "", str2, System.currentTimeMillis(), str, a.this.otherParams);
                        }
                    } else if ((TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) && a.this.aGe != null && a.this.aGe.mLiveInfo != null) {
                        long j5 = a.this.aGe.mLiveInfo.live_id;
                        long j6 = a.this.aGe.mLiveInfo.room_id;
                        String str3 = a.this.aGe.mLiveInfo.feed_id;
                        String str4 = "";
                        if (a.this.aGe.aKu != null) {
                            j = a.this.aGe.aKu.userId;
                            str4 = a.this.aGe.aKu.userName;
                        }
                        QMStaticManager.staticStartPlayTime(j5 + "", j6 + "", j + "", str4, System.currentTimeMillis(), str3, a.this.otherParams, a.this.hKq + "");
                    }
                }
            }
        };
        this.hKN = new HttpMessageListener(1031042) { // from class: com.baidu.tieba.yuyinala.liveroom.k.a.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaGetAudienceHttpResponseMessage)) {
                    r bWZ = ((AlaGetAudienceHttpResponseMessage) httpResponsedMessage).bWZ();
                    Message<?> message = httpResponsedMessage.getmOrginalMessage();
                    if (message instanceof com.baidu.tieba.yuyinala.liveroom.messages.b) {
                        com.baidu.tieba.yuyinala.liveroom.messages.b bVar = (com.baidu.tieba.yuyinala.liveroom.messages.b) message;
                        if (String.valueOf(bVar.edf()).equals(a.this.aGe.aLl.live_id)) {
                            bWZ.liveId = String.valueOf(bVar.edf());
                        } else {
                            return;
                        }
                    }
                    if (bWZ != null) {
                        a.this.gQJ = bWZ;
                    }
                    if (a.this.aGe != null && a.this.aGe.aKw != null) {
                        if (a.this.hKu == -1) {
                            a.this.hKu = a.this.aGe.aKw.follow_status;
                        }
                        if (a.this.aGe.aKw.follow_status != a.this.hKu) {
                            a.this.aGe.aKw.follow_status = a.this.hKu;
                        }
                    }
                    a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 2, a.this.gQJ);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913016, a.this.gQJ));
                }
            }
        };
        this.hKO = new HttpMessageListener(1021121) { // from class: com.baidu.tieba.yuyinala.liveroom.k.a.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaUserLiveMarkInfoResponseMessage) {
                    AlaUserLiveMarkInfoResponseMessage alaUserLiveMarkInfoResponseMessage = (AlaUserLiveMarkInfoResponseMessage) httpResponsedMessage;
                    if (alaUserLiveMarkInfoResponseMessage.getError() == 0) {
                        List<AlaLiveMarkData> clO = alaUserLiveMarkInfoResponseMessage.clO();
                        a.this.orw.R(clO);
                        if (a.this.aGe != null) {
                            a.this.aGe.aLb = clO;
                            com.baidu.live.im.b.d.Nk().V(a.this.aGe.aLb);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913118, a.this.aGe));
                        }
                    }
                }
            }
        };
        this.orE = new HttpMessageListener(1031024) { // from class: com.baidu.tieba.yuyinala.liveroom.k.a.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof YuyinGetLiveInfoHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == a.this.unique_id) {
                    if (httpResponsedMessage.hasError()) {
                        a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, null);
                        return;
                    }
                    x HR = httpResponsedMessage instanceof YuyinGetLiveInfoHttpResponseMessage ? ((YuyinGetLiveInfoHttpResponseMessage) httpResponsedMessage).HR() : null;
                    if (HR == null) {
                        a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, HR);
                        return;
                    }
                    if (a.this.aGe == null) {
                        a.this.aGe = HR;
                        a.this.orw.setAlaLiveShowData(a.this.aGe);
                    } else if (a.this.aGe.mLiveInfo != null && HR.mLiveInfo != null && a.this.aGe.mLiveInfo.live_id != HR.mLiveInfo.live_id) {
                        a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, a.this.aGe);
                        return;
                    }
                    if (a.this.aGe.mLiveInfo != null && HR.mLiveInfo != null && a.this.aGe.mLiveInfo.user_id == HR.mLiveInfo.user_id) {
                        if (a.this.aGe.mLiveInfo.mLiveCloseData != null && HR.mLiveInfo.mLiveCloseData == null) {
                            HR.mLiveInfo.mLiveCloseData = a.this.aGe.mLiveInfo.mLiveCloseData;
                        }
                        if (a.this.aGe.mLiveInfo.mAlaLiveSwitchData != null && HR.mLiveInfo.mAlaLiveSwitchData == null) {
                            HR.mLiveInfo.mAlaLiveSwitchData = a.this.aGe.mLiveInfo.mAlaLiveSwitchData;
                        }
                    }
                    a.this.aGe.mLiveInfo = HR.mLiveInfo;
                    a.this.aGe.aKu = HR.aKu;
                    if (a.this.aGe.aLl != null && HR.aLl != null) {
                        if (a.this.aGe.aLl.aVz == HR.aLl.aVz) {
                            if (!TextUtils.equals(a.this.aGe.aLl.bg_cover, HR.aLl.bg_cover) || !TextUtils.equals(a.this.aGe.aLl.aVy, HR.aLl.aVy)) {
                                a.this.ory = true;
                            } else {
                                a.this.ory = false;
                            }
                        } else {
                            a.this.ory = true;
                        }
                    }
                    int roomMode = HR.aLq != null ? HR.aLq.getRoomMode() : -1;
                    int roomMode2 = a.this.aGe.aLq != null ? a.this.aGe.aLq.getRoomMode() : -1;
                    boolean z = (roomMode2 == -1 || roomMode == -1 || roomMode2 == roomMode) ? false : true;
                    if (z) {
                        a.this.ory = true;
                    }
                    a.this.aGe.aLl = HR.aLl;
                    a.this.aGe.aLm = HR.aLm;
                    a.this.aGe.aLG = HR.aLG;
                    a.this.aGe.aKv = HR.aKv;
                    a.this.aGe.aKz = HR.aKz;
                    a.this.aGe.aLc = HR.aLc;
                    a.this.aGe.aLa = HR.aLa;
                    a.this.aGe.aKV = HR.aKV;
                    a.this.aGe.aLj = HR.aLj;
                    a.this.aGe.aLk = HR.aLk;
                    a.this.aGe.aLq = HR.aLq;
                    if (HR.aLf != null && HR.aLf.aPH != null && !HR.aLf.aPH.isEmpty()) {
                        a.this.aGe.aLf = HR.aLf;
                    }
                    if (HR.aKQ != null) {
                        if (HR.aKQ.userId != 0) {
                            a.this.aGe.aKQ = HR.aKQ;
                            TbadkCoreApplication.getCurrentAccountObj().setNameShow(a.this.aGe.aKQ.nickName);
                        } else {
                            if (a.this.aGe.aKQ == null) {
                                a.this.aGe.aKQ = new AlaLiveUserInfoData();
                            }
                            a.this.aGe.aKQ.throneUid = HR.aKQ.throneUid;
                        }
                    }
                    if (HR.aKT != null) {
                        a.this.aGe.aKT = HR.aKT;
                    }
                    if (HR.aLa) {
                        a.this.aGe.aLb = HR.aLb;
                        if (a.this.orw != null) {
                            a.this.orw.R(HR.aLb);
                        }
                    }
                    if (!a.this.mIsHost && a.this.aGe.mLiveInfo != null) {
                        int i = a.this.aGe.mLiveInfo.backstage_type;
                        if (a.this.orw != null) {
                            a.this.orw.hL(String.valueOf(i));
                        }
                    }
                    if (a.this.orw != null) {
                        a.this.orw.setAlaLiveShowData(a.this.aGe);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501033, a.this.aGe));
                    a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, a.this.aGe);
                    if (a.this.aGe != null) {
                        com.baidu.live.im.b.d.Nk().V(a.this.aGe.aLb);
                    }
                    if (z) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501014, new g(roomMode2, roomMode)));
                    }
                }
            }
        };
        this.orF = new HttpMessageListener(1031044) { // from class: com.baidu.tieba.yuyinala.liveroom.k.a.2
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
                    if (list != null && list.size() > 0 && a.this.hKo != null && a.this.hKo.size() > 0) {
                        for (int size = a.this.hKo.size() - 1; size >= 0; size--) {
                            if (((AlaLiveInfoData) a.this.hKo.get(size)).live_id != a.this.aGe.mLiveInfo.live_id && list.contains(Long.valueOf(((AlaLiveInfoData) a.this.hKo.get(size)).getLiveID()))) {
                                a.this.hKo.remove(size);
                            }
                        }
                    }
                    if (a.this.aGe != null) {
                        a.this.h(a.this.aGe.mLiveInfo);
                    }
                    a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 4, Long.valueOf(j2));
                }
            }
        };
        this.hKT = new HttpMessageListener(1031062) { // from class: com.baidu.tieba.yuyinala.liveroom.k.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getOrginalMessage() != null && (httpResponsedMessage.getOrginalMessage().getExtra() instanceof com.baidu.live.r.b)) {
                    com.baidu.live.r.b bVar = (com.baidu.live.r.b) httpResponsedMessage.getOrginalMessage().getExtra();
                    if (bVar.byc != null) {
                        if (httpResponsedMessage.getError() == 0) {
                            bVar.byc.hX(bVar.contentType);
                        } else {
                            bVar.byc.d(bVar.contentType, httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                        }
                    }
                }
            }
        };
        this.hKV = new HttpMessageListener(1031037) { // from class: com.baidu.tieba.yuyinala.liveroom.k.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                c cVar;
                if (httpResponsedMessage != null && httpResponsedMessage.getError() == 0) {
                    if (!(httpResponsedMessage instanceof AlaLiveRecommondHttpResponseMessage)) {
                        cVar = null;
                    } else {
                        cVar = ((AlaLiveRecommondHttpResponseMessage) httpResponsedMessage).edg();
                    }
                    if (cVar != null && !ListUtils.isEmpty(cVar.aKJ)) {
                        a.this.hKp = cVar.pn + 1;
                        b bVar = cVar.aKJ.get(cVar.aKJ.size() - 1);
                        if (bVar != null) {
                            a.this.mLastLiveId = bVar.mLiveInfo.live_id;
                        }
                        a.this.a(cVar);
                        if (a.this.aGe != null) {
                            a.this.h(a.this.aGe.mLiveInfo);
                        }
                        a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 5, cVar);
                    }
                }
            }
        };
        this.blU = bdPageContext;
        this.orw = new q(bdPageContext, false, this);
        this.hKo = new ArrayList();
        this.hKA = new HashSet();
        initTasks();
        registerListener(this.orE);
        this.hKi = BdUniqueId.gen();
        registerListener(this.orF);
        registerListener(this.hKT);
    }

    private void initTasks() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031037, com.baidu.live.a.aAH + "ala/audio/recommend/getSwitchLives");
        tbHttpMessageTask.setResponsedClass(AlaLiveRecommondHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.hKV.setTag(this.hKi);
        registerListener(this.hKV);
        TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(1031042, com.baidu.live.a.aAH + "ala/audio/live/getAudienceInfo");
        tbHttpMessageTask2.setIsNeedLogin(false);
        tbHttpMessageTask2.setIsNeedTbs(true);
        tbHttpMessageTask2.setRetry(1);
        tbHttpMessageTask2.setResponsedClass(AlaGetAudienceHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask2);
        registerListener(this.hKN);
        TbHttpMessageTask tbHttpMessageTask3 = new TbHttpMessageTask(1031023, com.baidu.live.a.aAH + "ala/audio/enterLive");
        tbHttpMessageTask3.setIsNeedLogin(true);
        tbHttpMessageTask3.setIsNeedTbs(true);
        tbHttpMessageTask3.setIsNeedAddCommenParam(true);
        tbHttpMessageTask3.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask3.setResponsedClass(AlaEnterLiveHttpResonseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask3);
        registerListener(this.orD);
        TbHttpMessageTask tbHttpMessageTask4 = new TbHttpMessageTask(1031084, com.baidu.live.a.aAH + "/ala/audio/link/online");
        tbHttpMessageTask4.setIsNeedLogin(true);
        tbHttpMessageTask4.setIsNeedTbs(true);
        tbHttpMessageTask4.setIsNeedAddCommenParam(true);
        tbHttpMessageTask4.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask4.setResponsedClass(GetWheatListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask4);
        registerListener(this.orC);
        TbHttpMessageTask tbHttpMessageTask5 = new TbHttpMessageTask(1031087, com.baidu.live.a.aAH + "ala/audio/mode/getActivityInfo");
        tbHttpMessageTask5.setIsNeedLogin(true);
        tbHttpMessageTask5.setIsNeedTbs(true);
        tbHttpMessageTask5.setIsNeedAddCommenParam(true);
        tbHttpMessageTask5.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask5.setResponsedClass(TeamFightInfoResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask5);
        registerListener(this.orB);
        TbHttpMessageTask tbHttpMessageTask6 = new TbHttpMessageTask(1031048, com.baidu.live.a.aAH + "ala/audio/exitLive");
        tbHttpMessageTask6.setIsNeedLogin(false);
        tbHttpMessageTask6.setIsNeedTbs(true);
        tbHttpMessageTask6.setIsNeedAddCommenParam(true);
        tbHttpMessageTask6.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask6.setResponsedClass(AlaQuitLiveHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask6);
        registerListener(this.orA);
        com.baidu.live.tieba.f.a.a.a(1021121, "ala/sdk/v1/open/getUserLiveMarkInfo", AlaUserLiveMarkInfoResponseMessage.class, true, true, true, true);
        registerListener(this.hKO);
        TbHttpMessageTask tbHttpMessageTask7 = new TbHttpMessageTask(1031071, TbConfig.SERVER_ADDRESS + "ala/UGC/getUGCAnchorInfo");
        tbHttpMessageTask7.setIsNeedLogin(false);
        tbHttpMessageTask7.setIsNeedTbs(true);
        tbHttpMessageTask7.setResponsedClass(MasterIdentityResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask7);
        registerListener(this.hKJ);
    }

    public void cma() {
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

    public void cmb() {
        MessageManager.getInstance().unRegisterTask(2913043);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, String str, int i2, Object obj) {
        if (this.orp != null) {
            this.orp.a(i, str, i2, obj);
        }
    }

    public void hH(long j) {
        com.baidu.tieba.yuyinala.liveroom.messages.b bVar = new com.baidu.tieba.yuyinala.liveroom.messages.b();
        bVar.setLiveId(j);
        bVar.setParams();
        sendMessage(bVar);
    }

    public void a(long j, String str, long j2) {
        e eVar = new e();
        eVar.setLiveId(j);
        eVar.setFrom(str);
        eVar.aZ(j2);
        eVar.setParams();
        sendMessage(eVar);
    }

    public void ag(x xVar) {
        if (xVar != null) {
            try {
                sendMessage(new com.baidu.tieba.yuyinala.liveroom.alaaudiopk.e(0, com.baidu.tieba.yuyinala.liveroom.wheat.e.g.av(xVar), (int) com.baidu.tieba.yuyinala.liveroom.wheat.e.g.ax(xVar), Integer.parseInt(com.baidu.tieba.yuyinala.liveroom.wheat.e.g.aw(xVar)), com.baidu.tieba.yuyinala.liveroom.wheat.e.g.as(xVar)));
            } catch (Exception e) {
                Log.d(":nht...", "");
            }
        }
    }

    public void a(long j, String str, long j2, long j3) {
        e eVar = new e();
        eVar.setLiveId(j);
        eVar.setFrom(str);
        eVar.aZ(j2);
        eVar.aP(j3);
        eVar.setParams();
        sendMessage(eVar);
    }

    public void cmm() {
        if (TbadkCoreApplication.isLogin()) {
            HttpMessage httpMessage = new HttpMessage(1021121);
            httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccount());
            sendMessage(httpMessage);
        }
    }

    public x HR() {
        return this.aGe;
    }

    public void setLiveShowData(x xVar) {
        this.aGe = xVar;
    }

    public List<AlaLiveInfoData> cmo() {
        return this.hKo;
    }

    public r bWZ() {
        return this.gQJ;
    }

    public com.baidu.tieba.yuyinala.liveroom.alaaudiopk.d edh() {
        return this.omO;
    }

    public void cM(List<Long> list) {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
            com.baidu.tieba.yuyinala.liveroom.messages.c cVar = new com.baidu.tieba.yuyinala.liveroom.messages.c();
            if (this.aGe != null && this.aGe.mLiveInfo != null) {
                cVar.setAudienceCount(this.aGe.mLiveInfo.audience_count);
            }
            cVar.setListIds(list);
            cVar.setParams();
            sendMessage(cVar);
        }
    }

    public void cmp() {
        ArrayList arrayList = new ArrayList();
        for (AlaLiveInfoData alaLiveInfoData : this.hKo) {
            if (alaLiveInfoData != null) {
                arrayList.add(Long.valueOf(alaLiveInfoData.live_id));
            }
        }
        cM(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c cVar) {
        if (cVar != null) {
            if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isYinbo()) {
                if (this.hKo.size() == 1 && this.hKo.get(0).live_id == this.aGe.mLiveInfo.live_id) {
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
        for (b bVar : cVar.aKJ) {
            if (bVar != null && bVar.mLiveInfo != null) {
                for (AlaLiveInfoData alaLiveInfoData : this.hKo) {
                    if (alaLiveInfoData == null || alaLiveInfoData.live_id == bVar.mLiveInfo.live_id) {
                        z = false;
                        break;
                    }
                    while (r4.hasNext()) {
                    }
                }
                z = true;
                if (z) {
                    this.hKo.add(bVar.mLiveInfo);
                }
            }
        }
        if (this.hKo.size() >= 200) {
            ArrayList arrayList = new ArrayList();
            for (int size = this.hKo.size() - 200; size < this.hKo.size(); size++) {
                arrayList.add(this.hKo.get(size));
            }
            if (!ListUtils.isEmpty(arrayList)) {
                this.hKo.clear();
                this.hKo.addAll(arrayList);
                arrayList.clear();
            }
        }
    }

    private AlaLiveInfoData c(c cVar) {
        if (ListUtils.isEmpty(cVar.aKJ)) {
            return null;
        }
        for (b bVar : cVar.aKJ) {
            if (bVar != null && bVar.mLiveInfo != null && bVar.mLiveInfo.live_id == this.aGe.mLiveInfo.live_id) {
                return bVar.mLiveInfo;
            }
        }
        return null;
    }

    public ArrayList<AlaLiveInfoData> cmq() {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        if (ListUtils.isEmpty(this.hKo)) {
            return null;
        }
        if (this.hKA.isEmpty()) {
            arrayList.addAll(this.hKo);
        } else {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.hKo.size()) {
                    break;
                }
                if ((this.aGe == null || this.aGe.mLiveInfo == null || this.aGe.mLiveInfo.live_id != this.hKo.get(i2).live_id) && !this.hKA.contains(Long.valueOf(this.hKo.get(i2).live_id))) {
                    arrayList.add(this.hKo.get(i2));
                }
                i = i2 + 1;
            }
        }
        return arrayList;
    }

    public void g(AlaLiveInfoData alaLiveInfoData) {
        if (alaLiveInfoData != null) {
            this.hKA.add(Long.valueOf(alaLiveInfoData.getLiveID()));
            if (this.hKA.size() >= this.hKo.size() - 4) {
                oA(false);
            }
        }
    }

    public void xt(int i) {
        this.hKv = i;
    }

    public void oA(boolean z) {
        oB(z);
    }

    private void oB(boolean z) {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.hKD >= 1800000) {
                this.hKC = currentTimeMillis;
                this.hKE = true;
            }
            if (this.hKE) {
                HttpMessage httpMessage = new HttpMessage(1031037);
                httpMessage.addParam(Config.PACKAGE_NAME, z ? 0 : this.hKp);
                httpMessage.addParam("ps", 20);
                httpMessage.addParam("scr_w", BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst()));
                httpMessage.addParam("scr_h", BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst()));
                httpMessage.addParam("q_type", 0);
                httpMessage.addParam("scr_dip", String.valueOf(BdUtilHelper.getEquipmentDensity(TbadkCoreApplication.getInst())));
                httpMessage.addParam("forum_id", "");
                httpMessage.addParam("entry_name", "");
                httpMessage.addParam("live_id", this.mLastLiveId);
                httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccountId());
                httpMessage.addParam("slide_session_id", this.hKC);
                httpMessage.setTag(this.hKi);
                sendMessage(httpMessage);
                this.hKD = currentTimeMillis;
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
        aVar.Ba(str);
        aVar.setLiveId(j);
        aVar.setParams();
        sendMessage(aVar);
    }

    public void VR(String str) {
        sendMessage(new m(str));
    }

    public void aw(String str, String str2, String str3) {
        Address address = BdLocationMananger.getInstance().getAddress(false);
        com.baidu.tieba.yuyinala.liveroom.messages.a aVar = new com.baidu.tieba.yuyinala.liveroom.messages.a();
        if (address != null) {
            aVar.b(address.getLongitude(), address.getLatitude());
        }
        aVar.setForumName(str3);
        aVar.Ba(str2);
        aVar.setUk(str);
        aVar.setParams();
        sendMessage(aVar);
    }

    public void IE(String str) {
        Address address = BdLocationMananger.getInstance().getAddress(false);
        com.baidu.tieba.yuyinala.liveroom.messages.a aVar = new com.baidu.tieba.yuyinala.liveroom.messages.a();
        if (address != null) {
            aVar.b(address.getLongitude(), address.getLatitude());
        }
        aVar.setRoomId(str);
        aVar.setParams();
        sendMessage(aVar);
    }

    public void fD(long j) {
        this.orw.Dc();
        this.hKw = null;
        com.baidu.tieba.yuyinala.liveroom.messages.d dVar = new com.baidu.tieba.yuyinala.liveroom.messages.d();
        dVar.setLiveId(j);
        dVar.setParams();
        dVar.setTag(BdUniqueId.gen());
        sendMessage(dVar);
    }

    public void b(AlaLiveInfoCoreData alaLiveInfoCoreData) {
        if (this.aGe == null) {
            this.aGe = new x(alaLiveInfoCoreData);
            this.aGe.bw(true);
            this.orw.setAlaLiveShowData(this.aGe);
        }
        this.mLastLiveId = this.aGe.mLiveInfo.live_id;
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
        this.hKj.removeCallbacksAndMessages(null);
        cancelLoadData();
        MessageManager.getInstance().unRegisterListener(this.hKV);
        MessageManager.getInstance().removeMessageRule(this.hKx);
        MessageManager.getInstance().unRegisterListener(this.unique_id);
        MessageManager.getInstance().unRegisterTask(1021163);
        MessageManager.getInstance().removeMessage(1031062, getUniqueId());
        this.orw.Dc();
        this.orx = null;
        this.blU = null;
    }

    public void xu(int i) {
        this.hKq = i;
        if (this.hKo.size() == 0) {
            this.hKq = 0;
        } else if (this.hKq < 0) {
            this.hKq = this.hKo.size() + this.hKq;
        } else {
            this.hKq %= this.hKo.size();
        }
    }

    public void h(AlaLiveInfoData alaLiveInfoData) {
        if (alaLiveInfoData != null && this.hKo.size() != 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.hKo.size()) {
                    if (this.hKo.get(i2).live_id != alaLiveInfoData.live_id) {
                        i = i2 + 1;
                    } else {
                        this.hKq = i2;
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public boolean cmt() {
        long j;
        if (this.aGe == null || this.aGe.mLiveInfo == null || this.hKo.size() <= 0) {
            return true;
        }
        AlaLiveInfoData alaLiveInfoData = this.hKo.get(0);
        if (alaLiveInfoData == null) {
            j = 0;
        } else {
            j = alaLiveInfoData.live_id;
        }
        return j == this.aGe.mLiveInfo.live_id;
    }

    public boolean cmu() {
        long j;
        if (this.aGe == null || this.aGe.mLiveInfo == null || this.hKo.size() <= 0) {
            return true;
        }
        AlaLiveInfoData alaLiveInfoData = this.hKo.get(this.hKo.size() - 1);
        if (alaLiveInfoData == null) {
            j = 0;
        } else {
            j = alaLiveInfoData.live_id;
        }
        return j == this.aGe.mLiveInfo.live_id;
    }

    public int cmv() {
        return this.hKq;
    }

    public AlaLiveInfoData cmy() {
        if (this.hKq >= this.hKo.size()) {
            this.hKq = this.hKo.size() - 1;
        }
        if (this.hKq < 0) {
            this.hKq = 0;
        }
        if (this.hKo.size() <= this.hKq) {
            if (this.aGe != null) {
                return this.aGe.mLiveInfo;
            }
            return null;
        }
        return this.hKo.get(this.hKq);
    }

    public void a(InterfaceC0939a interfaceC0939a) {
        this.orp = interfaceC0939a;
    }

    @Override // com.baidu.live.im.q.a
    public void d(List<com.baidu.live.im.data.b> list, boolean z) {
        if (this.orx != null) {
            this.orx.d(list, z);
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913038, list));
        }
    }

    @Override // com.baidu.live.im.q.a
    public void t(com.baidu.live.im.data.b bVar) {
        if (this.aGe != null && this.aGe.mLiveInfo.live_type == 1) {
            L(bVar);
        }
        if (this.orx != null) {
            this.orx.t(bVar);
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913037, bVar));
        }
    }

    public void L(com.baidu.live.im.data.b bVar) {
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
            oA(true);
        }
    }

    @Override // com.baidu.live.im.q.a
    public void Mb() {
        if (this.orx != null) {
            this.orx.Mb();
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913044));
        }
    }

    public void e(ImSendMsgData imSendMsgData) {
        AlaLiveUserInfoData alaLiveUserInfoData;
        if (this.aGe != null) {
            if (this.mIsHost) {
                alaLiveUserInfoData = this.aGe.aKu;
            } else {
                alaLiveUserInfoData = this.aGe.aKQ;
            }
            if (alaLiveUserInfoData != null) {
                String[] strArr = this.aGe.mLiveInfo.imEffect;
                String[] strArr2 = null;
                if (strArr != null) {
                    strArr2 = new String[strArr.length];
                    System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
                }
                if (!TbadkCoreApplication.getInst().isMobileBaidu() && this.aGe != null && this.aGe.aKQ != null && this.aGe.mLiveInfo != null) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    String str = this.aGe.aKQ.throneUid;
                    if (!TextUtils.isEmpty(currentAccount) && !TextUtils.isEmpty(str) && currentAccount.equals(str)) {
                        if (strArr2 == null || strArr2.length != 2) {
                            strArr2 = new String[2];
                            strArr2[1] = "";
                        }
                        strArr2[0] = "guard_seat_effect";
                    }
                }
                this.orw.a(imSendMsgData, alaLiveUserInfoData.isOfficial == 1, alaLiveUserInfoData.isAdmin == 1, alaLiveUserInfoData.levelId, this.otherParams, strArr2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmz() {
        this.orw.e(String.valueOf(this.aGe.mLiveInfo.getGroupID()), String.valueOf(this.aGe.mLiveInfo.getLastMsgID()), String.valueOf(this.aGe.mLiveInfo.getUserID()), String.valueOf(this.aGe.mLiveInfo.getLiveID()), this.aGe.mLiveInfo.appId);
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public String cmC() {
        return this.hKw;
    }

    public void HZ(String str) {
        this.hKw = str;
    }
}

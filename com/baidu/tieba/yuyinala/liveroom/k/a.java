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
/* loaded from: classes10.dex */
public class a extends BdBaseModel implements q.a {
    private x aBr;
    private BdPageContext<?> bhf;
    private r gMd;
    private BdUniqueId hFC;
    private Handler hFD;
    private List<AlaLiveInfoData> hFI;
    private int hFJ;
    private int hFK;
    private int hFO;
    private int hFP;
    private String hFQ;
    private com.baidu.live.ad.a hFR;
    private Set<Long> hFU;
    private long hFW;
    private long hFX;
    private boolean hFY;
    private HttpMessageListener hGd;
    private HttpMessageListener hGh;
    private HttpMessageListener hGi;
    private HttpMessageListener hGn;
    private HttpMessageListener hGp;
    private boolean mIsHost;
    private long mLastLiveId;
    private com.baidu.tieba.yuyinala.liveroom.alaaudiopk.d oij;
    private InterfaceC0922a omH;
    private final q omO;
    private q.a omP;
    public boolean omQ;
    public boolean omR;
    private HttpMessageListener omS;
    private HttpMessageListener omT;
    private HttpMessageListener omU;
    private HttpMessageListener omV;
    private HttpMessageListener omW;
    private HttpMessageListener omX;
    private String otherParams;

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0922a {
        void a(int i, String str, int i2, Object obj);
    }

    public a(BdPageContext<?> bdPageContext) {
        super(bdPageContext);
        this.hFD = new Handler();
        this.hFJ = 0;
        this.hFK = 0;
        this.hFO = -1;
        this.hFP = 0;
        this.hFR = new com.baidu.live.ad.a(0);
        this.otherParams = "";
        this.hFW = System.currentTimeMillis();
        this.hFY = true;
        this.hFX = 0L;
        this.omQ = true;
        this.omR = false;
        this.hGd = new HttpMessageListener(1031071) { // from class: com.baidu.tieba.yuyinala.liveroom.k.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                String chZ;
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof MasterIdentityResponseMessage)) {
                    MasterIdentityResponseMessage masterIdentityResponseMessage = (MasterIdentityResponseMessage) httpResponsedMessage;
                    if ((masterIdentityResponseMessage.chX() == 1 || masterIdentityResponseMessage.chY() == 1) && !TextUtils.isEmpty(masterIdentityResponseMessage.chZ())) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("text", masterIdentityResponseMessage.chZ());
                            jSONObject.put("content_type", "custom_master_identity");
                            chZ = jSONObject.toString();
                        } catch (JSONException e) {
                            chZ = masterIdentityResponseMessage.chZ();
                            e.printStackTrace();
                        }
                        a.this.omO.a(27, chZ, (com.baidu.live.data.a) null);
                    }
                }
            }
        };
        this.omS = new HttpMessageListener(1031048) { // from class: com.baidu.tieba.yuyinala.liveroom.k.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            }
        };
        this.omT = new HttpMessageListener(1031087) { // from class: com.baidu.tieba.yuyinala.liveroom.k.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof TeamFightInfoResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == a.this.unique_id) {
                    com.baidu.tieba.yuyinala.liveroom.alaaudiopk.d dYr = ((TeamFightInfoResponseMessage) httpResponsedMessage).dYr();
                    if (dYr != null) {
                        a.this.oij = dYr;
                    }
                    a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 12, dYr);
                }
            }
        };
        this.omU = new HttpMessageListener(1031084) { // from class: com.baidu.tieba.yuyinala.liveroom.k.a.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetWheatListHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == a.this.unique_id) {
                    UbcAudioFlowStatisticManager.getInstance().doSlotEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_MIC_LITE_API_FLOW, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""), "micLiteApi");
                    UbcAudioFlowStatisticManager.getInstance().doSlotStart(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_MIC_LITE_API_FLOW, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""), "micLiteApiHandle", null);
                    AlaWheatInfoDataWrapper alaWheatInfoDataWrapper = ((GetWheatListHttpResponseMessage) httpResponsedMessage).aGD;
                    if (alaWheatInfoDataWrapper != null) {
                        a.this.aBr.aGD = alaWheatInfoDataWrapper;
                        if (alaWheatInfoDataWrapper.getRoomMode() == 1) {
                            a.this.aBr.aGz = new cx();
                            a.this.aBr.aGz.mStep = alaWheatInfoDataWrapper.getActivityStage();
                        }
                        a.this.aBr.aGP = true;
                        UbcAudioFlowStatisticManager.getInstance().doSlotEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_MIC_LITE_API_FLOW, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""), "micLiteApiHandle");
                        UbcAudioFlowStatisticManager.getInstance().doSlotStart(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_MIC_LITE_API_FLOW, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""), "UIRendering", null);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501033, a.this.aBr));
                        a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, a.this.aBr);
                        UbcAudioFlowStatisticManager.getInstance().doSlotEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_MIC_LITE_API_FLOW, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""), "UIRendering");
                        UbcAudioFlowStatisticManager.getInstance().endFlow(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_MIC_LITE_API_FLOW, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""));
                    }
                }
            }
        };
        this.omV = new HttpMessageListener(1031023) { // from class: com.baidu.tieba.yuyinala.liveroom.k.a.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                long j = 0;
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaEnterLiveHttpResonseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == a.this.unique_id) {
                    a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 11, a.this.aBr);
                    a.this.aBr = ((AlaEnterLiveHttpResonseMessage) httpResponsedMessage).DW();
                    if (a.this.aBr != null) {
                        a.this.aBr.aGQ = true;
                        a.this.aBr.aGP = true;
                    }
                    a.this.omO.setAlaLiveShowData(a.this.aBr);
                    if (a.this.aBr != null && a.this.aBr.mLiveInfo != null) {
                        if (!TbadkCoreApplication.getInst().isOther() && (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isActivityTaskWatchUnabled())) {
                            com.baidu.tieba.yuyinala.liveroom.task.b.dZz().fF(a.this.aBr.mLiveInfo.live_id);
                        }
                        LiveTimerManager.getInstance().start(a.this.aBr.mLiveInfo.live_id);
                    }
                    if (a.this.aBr != null && TbadkCoreApplication.getCurrentAccountInfo() != null) {
                        if (a.this.aBr.aGd != null) {
                            if (a.this.aBr.aGd.levelId > 0) {
                                TbadkCoreApplication.getCurrentAccountInfo().setLiveLevel(a.this.aBr.aGd.levelId);
                            }
                            TbadkCoreApplication.getCurrentAccountObj().setNameShow(a.this.aBr.aGd.nickName);
                            if (!TextUtils.isEmpty(a.this.aBr.aGd.portrait)) {
                                TbadkCoreApplication.getCurrentAccountObj().setPortrait(a.this.aBr.aGd.portrait);
                            }
                        }
                        if (a.this.aBr.mLiveSdkInfo != null) {
                            TbadkCoreApplication.getInst().setTbs(a.this.aBr.mLiveSdkInfo.tbs);
                            com.baidu.live.d.xf().putString("ala_account_user_tbs", a.this.aBr.mLiveSdkInfo.tbs);
                        }
                    }
                    if (a.this.aBr != null) {
                        if (a.this.hFI.size() <= 0) {
                            a.this.hFI.add(a.this.aBr.mLiveInfo);
                            a.this.hFU.add(Long.valueOf(a.this.aBr.mLiveInfo.getLiveID()));
                        }
                        a.this.h(a.this.aBr.mLiveInfo);
                        if (a.this.omO != null) {
                            a.this.omO.R(a.this.aBr.aGo);
                        }
                        if (a.this.hFI != null && a.this.hFI.size() > 0) {
                            for (AlaLiveInfoData alaLiveInfoData : a.this.hFI) {
                                if (alaLiveInfoData.live_id == a.this.aBr.mLiveInfo.live_id) {
                                    alaLiveInfoData.bg_cover = a.this.aBr.aGy.bg_cover;
                                    alaLiveInfoData.is_followed = a.this.aBr.aGy.is_followed;
                                    alaLiveInfoData.room_name = a.this.aBr.aGy.room_name;
                                }
                            }
                        }
                    }
                    if (a.this.aBr != null && a.this.aBr.aFJ != null) {
                        a.this.hFO = a.this.aBr.aFJ.follow_status;
                    }
                    UbcAudioFlowStatisticManager.getInstance().doSlotEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_ENTER_AUDIO_ROOM_PERF_FLOW, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""), "enterLiveApiHandle");
                    UbcAudioFlowStatisticManager.getInstance().doSlotStart(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_ENTER_AUDIO_ROOM_PERF_FLOW, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""), "UIRendering", null);
                    a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 3, a.this.aBr);
                    if (a.this.aBr != null && a.this.aBr.mLiveInfo != null) {
                        a.this.ciH();
                    }
                    if (a.this.aBr != null) {
                        a.this.aBr.isHost = false;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913081, a.this.aBr));
                        com.baidu.live.im.b.d.Jp().V(a.this.aBr.aGo);
                    }
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        if (a.this.aBr != null && a.this.aBr.mLiveInfo != null) {
                            long j2 = a.this.aBr.mLiveInfo.live_id;
                            long j3 = a.this.aBr.mLiveInfo.room_id;
                            String str = a.this.aBr.mLiveInfo.feed_id;
                            String str2 = "";
                            if (a.this.aBr.aFH != null) {
                                long j4 = a.this.aBr.aFH.userId;
                                str2 = a.this.aBr.aFH.userName;
                                j = j4;
                            }
                            HKStaticManager.staticStartPlayTime(j2 + "", j3 + "", j + "", str2, System.currentTimeMillis(), str, a.this.otherParams);
                        }
                    } else if ((TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) && a.this.aBr != null && a.this.aBr.mLiveInfo != null) {
                        long j5 = a.this.aBr.mLiveInfo.live_id;
                        long j6 = a.this.aBr.mLiveInfo.room_id;
                        String str3 = a.this.aBr.mLiveInfo.feed_id;
                        String str4 = "";
                        if (a.this.aBr.aFH != null) {
                            j = a.this.aBr.aFH.userId;
                            str4 = a.this.aBr.aFH.userName;
                        }
                        QMStaticManager.staticStartPlayTime(j5 + "", j6 + "", j + "", str4, System.currentTimeMillis(), str3, a.this.otherParams, a.this.hFK + "");
                    }
                }
            }
        };
        this.hGh = new HttpMessageListener(1031042) { // from class: com.baidu.tieba.yuyinala.liveroom.k.a.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaGetAudienceHttpResponseMessage)) {
                    r bTh = ((AlaGetAudienceHttpResponseMessage) httpResponsedMessage).bTh();
                    Message<?> message = httpResponsedMessage.getmOrginalMessage();
                    if (message instanceof com.baidu.tieba.yuyinala.liveroom.messages.b) {
                        com.baidu.tieba.yuyinala.liveroom.messages.b bVar = (com.baidu.tieba.yuyinala.liveroom.messages.b) message;
                        if (String.valueOf(bVar.dZn()).equals(a.this.aBr.aGy.live_id)) {
                            bTh.liveId = String.valueOf(bVar.dZn());
                        } else {
                            return;
                        }
                    }
                    if (bTh != null) {
                        a.this.gMd = bTh;
                    }
                    if (a.this.aBr != null && a.this.aBr.aFJ != null) {
                        if (a.this.hFO == -1) {
                            a.this.hFO = a.this.aBr.aFJ.follow_status;
                        }
                        if (a.this.aBr.aFJ.follow_status != a.this.hFO) {
                            a.this.aBr.aFJ.follow_status = a.this.hFO;
                        }
                    }
                    a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 2, a.this.gMd);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913016, a.this.gMd));
                }
            }
        };
        this.hGi = new HttpMessageListener(1021121) { // from class: com.baidu.tieba.yuyinala.liveroom.k.a.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaUserLiveMarkInfoResponseMessage) {
                    AlaUserLiveMarkInfoResponseMessage alaUserLiveMarkInfoResponseMessage = (AlaUserLiveMarkInfoResponseMessage) httpResponsedMessage;
                    if (alaUserLiveMarkInfoResponseMessage.getError() == 0) {
                        List<AlaLiveMarkData> chW = alaUserLiveMarkInfoResponseMessage.chW();
                        a.this.omO.R(chW);
                        if (a.this.aBr != null) {
                            a.this.aBr.aGo = chW;
                            com.baidu.live.im.b.d.Jp().V(a.this.aBr.aGo);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913118, a.this.aBr));
                        }
                    }
                }
            }
        };
        this.omW = new HttpMessageListener(1031024) { // from class: com.baidu.tieba.yuyinala.liveroom.k.a.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof YuyinGetLiveInfoHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == a.this.unique_id) {
                    if (httpResponsedMessage.hasError()) {
                        a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, null);
                        return;
                    }
                    x DW = httpResponsedMessage instanceof YuyinGetLiveInfoHttpResponseMessage ? ((YuyinGetLiveInfoHttpResponseMessage) httpResponsedMessage).DW() : null;
                    if (DW == null) {
                        a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, DW);
                        return;
                    }
                    if (a.this.aBr == null) {
                        a.this.aBr = DW;
                        a.this.omO.setAlaLiveShowData(a.this.aBr);
                    } else if (a.this.aBr.mLiveInfo != null && DW.mLiveInfo != null && a.this.aBr.mLiveInfo.live_id != DW.mLiveInfo.live_id) {
                        a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, a.this.aBr);
                        return;
                    }
                    if (a.this.aBr.mLiveInfo != null && DW.mLiveInfo != null && a.this.aBr.mLiveInfo.user_id == DW.mLiveInfo.user_id) {
                        if (a.this.aBr.mLiveInfo.mLiveCloseData != null && DW.mLiveInfo.mLiveCloseData == null) {
                            DW.mLiveInfo.mLiveCloseData = a.this.aBr.mLiveInfo.mLiveCloseData;
                        }
                        if (a.this.aBr.mLiveInfo.mAlaLiveSwitchData != null && DW.mLiveInfo.mAlaLiveSwitchData == null) {
                            DW.mLiveInfo.mAlaLiveSwitchData = a.this.aBr.mLiveInfo.mAlaLiveSwitchData;
                        }
                    }
                    a.this.aBr.mLiveInfo = DW.mLiveInfo;
                    a.this.aBr.aFH = DW.aFH;
                    if (a.this.aBr.aGy != null && DW.aGy != null) {
                        if (a.this.aBr.aGy.aQM == DW.aGy.aQM) {
                            if (!TextUtils.equals(a.this.aBr.aGy.bg_cover, DW.aGy.bg_cover) || !TextUtils.equals(a.this.aBr.aGy.aQL, DW.aGy.aQL)) {
                                a.this.omQ = true;
                            } else {
                                a.this.omQ = false;
                            }
                        } else {
                            a.this.omQ = true;
                        }
                    }
                    int roomMode = DW.aGD != null ? DW.aGD.getRoomMode() : -1;
                    int roomMode2 = a.this.aBr.aGD != null ? a.this.aBr.aGD.getRoomMode() : -1;
                    boolean z = (roomMode2 == -1 || roomMode == -1 || roomMode2 == roomMode) ? false : true;
                    if (z) {
                        a.this.omQ = true;
                    }
                    a.this.aBr.aGy = DW.aGy;
                    a.this.aBr.aGz = DW.aGz;
                    a.this.aBr.aGT = DW.aGT;
                    a.this.aBr.aFI = DW.aFI;
                    a.this.aBr.aFM = DW.aFM;
                    a.this.aBr.aGp = DW.aGp;
                    a.this.aBr.aGn = DW.aGn;
                    a.this.aBr.aGi = DW.aGi;
                    a.this.aBr.aGw = DW.aGw;
                    a.this.aBr.aGx = DW.aGx;
                    a.this.aBr.aGD = DW.aGD;
                    if (DW.aGs != null && DW.aGs.aKU != null && !DW.aGs.aKU.isEmpty()) {
                        a.this.aBr.aGs = DW.aGs;
                    }
                    if (DW.aGd != null) {
                        if (DW.aGd.userId != 0) {
                            a.this.aBr.aGd = DW.aGd;
                            TbadkCoreApplication.getCurrentAccountObj().setNameShow(a.this.aBr.aGd.nickName);
                        } else {
                            if (a.this.aBr.aGd == null) {
                                a.this.aBr.aGd = new AlaLiveUserInfoData();
                            }
                            a.this.aBr.aGd.throneUid = DW.aGd.throneUid;
                        }
                    }
                    if (DW.aGg != null) {
                        a.this.aBr.aGg = DW.aGg;
                    }
                    if (DW.aGn) {
                        a.this.aBr.aGo = DW.aGo;
                        if (a.this.omO != null) {
                            a.this.omO.R(DW.aGo);
                        }
                    }
                    if (!a.this.mIsHost && a.this.aBr.mLiveInfo != null) {
                        int i = a.this.aBr.mLiveInfo.backstage_type;
                        if (a.this.omO != null) {
                            a.this.omO.gA(String.valueOf(i));
                        }
                    }
                    if (a.this.omO != null) {
                        a.this.omO.setAlaLiveShowData(a.this.aBr);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501033, a.this.aBr));
                    a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, a.this.aBr);
                    if (a.this.aBr != null) {
                        com.baidu.live.im.b.d.Jp().V(a.this.aBr.aGo);
                    }
                    if (z) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501014, new g(roomMode2, roomMode)));
                    }
                }
            }
        };
        this.omX = new HttpMessageListener(1031044) { // from class: com.baidu.tieba.yuyinala.liveroom.k.a.2
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
                    if (list != null && list.size() > 0 && a.this.hFI != null && a.this.hFI.size() > 0) {
                        for (int size = a.this.hFI.size() - 1; size >= 0; size--) {
                            if (((AlaLiveInfoData) a.this.hFI.get(size)).live_id != a.this.aBr.mLiveInfo.live_id && list.contains(Long.valueOf(((AlaLiveInfoData) a.this.hFI.get(size)).getLiveID()))) {
                                a.this.hFI.remove(size);
                            }
                        }
                    }
                    if (a.this.aBr != null) {
                        a.this.h(a.this.aBr.mLiveInfo);
                    }
                    a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 4, Long.valueOf(j2));
                }
            }
        };
        this.hGn = new HttpMessageListener(1031062) { // from class: com.baidu.tieba.yuyinala.liveroom.k.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getOrginalMessage() != null && (httpResponsedMessage.getOrginalMessage().getExtra() instanceof com.baidu.live.r.b)) {
                    com.baidu.live.r.b bVar = (com.baidu.live.r.b) httpResponsedMessage.getOrginalMessage().getExtra();
                    if (bVar.btp != null) {
                        if (httpResponsedMessage.getError() == 0) {
                            bVar.btp.gM(bVar.contentType);
                        } else {
                            bVar.btp.d(bVar.contentType, httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                        }
                    }
                }
            }
        };
        this.hGp = new HttpMessageListener(1031037) { // from class: com.baidu.tieba.yuyinala.liveroom.k.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                c cVar;
                if (httpResponsedMessage != null && httpResponsedMessage.getError() == 0) {
                    if (!(httpResponsedMessage instanceof AlaLiveRecommondHttpResponseMessage)) {
                        cVar = null;
                    } else {
                        cVar = ((AlaLiveRecommondHttpResponseMessage) httpResponsedMessage).dZo();
                    }
                    if (cVar != null && !ListUtils.isEmpty(cVar.aFW)) {
                        a.this.hFJ = cVar.pn + 1;
                        b bVar = cVar.aFW.get(cVar.aFW.size() - 1);
                        if (bVar != null) {
                            a.this.mLastLiveId = bVar.mLiveInfo.live_id;
                        }
                        a.this.a(cVar);
                        if (a.this.aBr != null) {
                            a.this.h(a.this.aBr.mLiveInfo);
                        }
                        a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 5, cVar);
                    }
                }
            }
        };
        this.bhf = bdPageContext;
        this.omO = new q(bdPageContext, false, this);
        this.hFI = new ArrayList();
        this.hFU = new HashSet();
        initTasks();
        registerListener(this.omW);
        this.hFC = BdUniqueId.gen();
        registerListener(this.omX);
        registerListener(this.hGn);
    }

    private void initTasks() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031037, com.baidu.live.a.avU + "ala/audio/recommend/getSwitchLives");
        tbHttpMessageTask.setResponsedClass(AlaLiveRecommondHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.hGp.setTag(this.hFC);
        registerListener(this.hGp);
        TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(1031042, com.baidu.live.a.avU + "ala/audio/live/getAudienceInfo");
        tbHttpMessageTask2.setIsNeedLogin(false);
        tbHttpMessageTask2.setIsNeedTbs(true);
        tbHttpMessageTask2.setRetry(1);
        tbHttpMessageTask2.setResponsedClass(AlaGetAudienceHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask2);
        registerListener(this.hGh);
        TbHttpMessageTask tbHttpMessageTask3 = new TbHttpMessageTask(1031023, com.baidu.live.a.avU + "ala/audio/enterLive");
        tbHttpMessageTask3.setIsNeedLogin(true);
        tbHttpMessageTask3.setIsNeedTbs(true);
        tbHttpMessageTask3.setIsNeedAddCommenParam(true);
        tbHttpMessageTask3.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask3.setResponsedClass(AlaEnterLiveHttpResonseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask3);
        registerListener(this.omV);
        TbHttpMessageTask tbHttpMessageTask4 = new TbHttpMessageTask(1031084, com.baidu.live.a.avU + "/ala/audio/link/online");
        tbHttpMessageTask4.setIsNeedLogin(true);
        tbHttpMessageTask4.setIsNeedTbs(true);
        tbHttpMessageTask4.setIsNeedAddCommenParam(true);
        tbHttpMessageTask4.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask4.setResponsedClass(GetWheatListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask4);
        registerListener(this.omU);
        TbHttpMessageTask tbHttpMessageTask5 = new TbHttpMessageTask(1031087, com.baidu.live.a.avU + "ala/audio/mode/getActivityInfo");
        tbHttpMessageTask5.setIsNeedLogin(true);
        tbHttpMessageTask5.setIsNeedTbs(true);
        tbHttpMessageTask5.setIsNeedAddCommenParam(true);
        tbHttpMessageTask5.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask5.setResponsedClass(TeamFightInfoResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask5);
        registerListener(this.omT);
        TbHttpMessageTask tbHttpMessageTask6 = new TbHttpMessageTask(1031048, com.baidu.live.a.avU + "ala/audio/exitLive");
        tbHttpMessageTask6.setIsNeedLogin(false);
        tbHttpMessageTask6.setIsNeedTbs(true);
        tbHttpMessageTask6.setIsNeedAddCommenParam(true);
        tbHttpMessageTask6.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask6.setResponsedClass(AlaQuitLiveHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask6);
        registerListener(this.omS);
        com.baidu.live.tieba.f.a.a.a(1021121, "ala/sdk/v1/open/getUserLiveMarkInfo", AlaUserLiveMarkInfoResponseMessage.class, true, true, true, true);
        registerListener(this.hGi);
        TbHttpMessageTask tbHttpMessageTask7 = new TbHttpMessageTask(1031071, TbConfig.SERVER_ADDRESS + "ala/UGC/getUGCAnchorInfo");
        tbHttpMessageTask7.setIsNeedLogin(false);
        tbHttpMessageTask7.setIsNeedTbs(true);
        tbHttpMessageTask7.setResponsedClass(MasterIdentityResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask7);
        registerListener(this.hGd);
    }

    public void cii() {
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

    public void cij() {
        MessageManager.getInstance().unRegisterTask(2913043);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, String str, int i2, Object obj) {
        if (this.omH != null) {
            this.omH.a(i, str, i2, obj);
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

    public void ciu() {
        if (TbadkCoreApplication.isLogin()) {
            HttpMessage httpMessage = new HttpMessage(1021121);
            httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccount());
            sendMessage(httpMessage);
        }
    }

    public x DW() {
        return this.aBr;
    }

    public void setLiveShowData(x xVar) {
        this.aBr = xVar;
    }

    public List<AlaLiveInfoData> ciw() {
        return this.hFI;
    }

    public r bTh() {
        return this.gMd;
    }

    public com.baidu.tieba.yuyinala.liveroom.alaaudiopk.d dZp() {
        return this.oij;
    }

    public void cM(List<Long> list) {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
            com.baidu.tieba.yuyinala.liveroom.messages.c cVar = new com.baidu.tieba.yuyinala.liveroom.messages.c();
            if (this.aBr != null && this.aBr.mLiveInfo != null) {
                cVar.setAudienceCount(this.aBr.mLiveInfo.audience_count);
            }
            cVar.setListIds(list);
            cVar.setParams();
            sendMessage(cVar);
        }
    }

    public void cix() {
        ArrayList arrayList = new ArrayList();
        for (AlaLiveInfoData alaLiveInfoData : this.hFI) {
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
                if (this.hFI.size() == 1 && this.hFI.get(0).live_id == this.aBr.mLiveInfo.live_id) {
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
        for (b bVar : cVar.aFW) {
            if (bVar != null && bVar.mLiveInfo != null) {
                for (AlaLiveInfoData alaLiveInfoData : this.hFI) {
                    if (alaLiveInfoData == null || alaLiveInfoData.live_id == bVar.mLiveInfo.live_id) {
                        z = false;
                        break;
                    }
                    while (r4.hasNext()) {
                    }
                }
                z = true;
                if (z) {
                    this.hFI.add(bVar.mLiveInfo);
                }
            }
        }
        if (this.hFI.size() >= 200) {
            ArrayList arrayList = new ArrayList();
            for (int size = this.hFI.size() - 200; size < this.hFI.size(); size++) {
                arrayList.add(this.hFI.get(size));
            }
            if (!ListUtils.isEmpty(arrayList)) {
                this.hFI.clear();
                this.hFI.addAll(arrayList);
                arrayList.clear();
            }
        }
    }

    private AlaLiveInfoData c(c cVar) {
        if (ListUtils.isEmpty(cVar.aFW)) {
            return null;
        }
        for (b bVar : cVar.aFW) {
            if (bVar != null && bVar.mLiveInfo != null && bVar.mLiveInfo.live_id == this.aBr.mLiveInfo.live_id) {
                return bVar.mLiveInfo;
            }
        }
        return null;
    }

    public ArrayList<AlaLiveInfoData> ciy() {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        if (ListUtils.isEmpty(this.hFI)) {
            return null;
        }
        if (this.hFU.isEmpty()) {
            arrayList.addAll(this.hFI);
        } else {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.hFI.size()) {
                    break;
                }
                if ((this.aBr == null || this.aBr.mLiveInfo == null || this.aBr.mLiveInfo.live_id != this.hFI.get(i2).live_id) && !this.hFU.contains(Long.valueOf(this.hFI.get(i2).live_id))) {
                    arrayList.add(this.hFI.get(i2));
                }
                i = i2 + 1;
            }
        }
        return arrayList;
    }

    public void g(AlaLiveInfoData alaLiveInfoData) {
        if (alaLiveInfoData != null) {
            this.hFU.add(Long.valueOf(alaLiveInfoData.getLiveID()));
            if (this.hFU.size() >= this.hFI.size() - 4) {
                ow(false);
            }
        }
    }

    public void vN(int i) {
        this.hFP = i;
    }

    public void ow(boolean z) {
        ox(z);
    }

    private void ox(boolean z) {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.hFX >= 1800000) {
                this.hFW = currentTimeMillis;
                this.hFY = true;
            }
            if (this.hFY) {
                HttpMessage httpMessage = new HttpMessage(1031037);
                httpMessage.addParam(Config.PACKAGE_NAME, z ? 0 : this.hFJ);
                httpMessage.addParam("ps", 20);
                httpMessage.addParam("scr_w", BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst()));
                httpMessage.addParam("scr_h", BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst()));
                httpMessage.addParam("q_type", 0);
                httpMessage.addParam("scr_dip", String.valueOf(BdUtilHelper.getEquipmentDensity(TbadkCoreApplication.getInst())));
                httpMessage.addParam("forum_id", "");
                httpMessage.addParam("entry_name", "");
                httpMessage.addParam("live_id", this.mLastLiveId);
                httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccountId());
                httpMessage.addParam("slide_session_id", this.hFW);
                httpMessage.setTag(this.hFC);
                sendMessage(httpMessage);
                this.hFX = currentTimeMillis;
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
        aVar.zP(str);
        aVar.setLiveId(j);
        aVar.setParams();
        sendMessage(aVar);
    }

    public void UJ(String str) {
        sendMessage(new m(str));
    }

    public void av(String str, String str2, String str3) {
        Address address = BdLocationMananger.getInstance().getAddress(false);
        com.baidu.tieba.yuyinala.liveroom.messages.a aVar = new com.baidu.tieba.yuyinala.liveroom.messages.a();
        if (address != null) {
            aVar.b(address.getLongitude(), address.getLatitude());
        }
        aVar.setForumName(str3);
        aVar.zP(str2);
        aVar.setUk(str);
        aVar.setParams();
        sendMessage(aVar);
    }

    public void Ht(String str) {
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
        this.omO.zh();
        this.hFQ = null;
        com.baidu.tieba.yuyinala.liveroom.messages.d dVar = new com.baidu.tieba.yuyinala.liveroom.messages.d();
        dVar.setLiveId(j);
        dVar.setParams();
        dVar.setTag(BdUniqueId.gen());
        sendMessage(dVar);
    }

    public void b(AlaLiveInfoCoreData alaLiveInfoCoreData) {
        if (this.aBr == null) {
            this.aBr = new x(alaLiveInfoCoreData);
            this.aBr.bs(true);
            this.omO.setAlaLiveShowData(this.aBr);
        }
        this.mLastLiveId = this.aBr.mLiveInfo.live_id;
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
        this.hFD.removeCallbacksAndMessages(null);
        cancelLoadData();
        MessageManager.getInstance().unRegisterListener(this.hGp);
        MessageManager.getInstance().removeMessageRule(this.hFR);
        MessageManager.getInstance().unRegisterListener(this.unique_id);
        MessageManager.getInstance().unRegisterTask(1021163);
        MessageManager.getInstance().removeMessage(1031062, getUniqueId());
        this.omO.zh();
        this.omP = null;
        this.bhf = null;
    }

    public void vO(int i) {
        this.hFK = i;
        if (this.hFI.size() == 0) {
            this.hFK = 0;
        } else if (this.hFK < 0) {
            this.hFK = this.hFI.size() + this.hFK;
        } else {
            this.hFK %= this.hFI.size();
        }
    }

    public void h(AlaLiveInfoData alaLiveInfoData) {
        if (alaLiveInfoData != null && this.hFI.size() != 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.hFI.size()) {
                    if (this.hFI.get(i2).live_id != alaLiveInfoData.live_id) {
                        i = i2 + 1;
                    } else {
                        this.hFK = i2;
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public boolean ciB() {
        long j;
        if (this.aBr == null || this.aBr.mLiveInfo == null || this.hFI.size() <= 0) {
            return true;
        }
        AlaLiveInfoData alaLiveInfoData = this.hFI.get(0);
        if (alaLiveInfoData == null) {
            j = 0;
        } else {
            j = alaLiveInfoData.live_id;
        }
        return j == this.aBr.mLiveInfo.live_id;
    }

    public boolean ciC() {
        long j;
        if (this.aBr == null || this.aBr.mLiveInfo == null || this.hFI.size() <= 0) {
            return true;
        }
        AlaLiveInfoData alaLiveInfoData = this.hFI.get(this.hFI.size() - 1);
        if (alaLiveInfoData == null) {
            j = 0;
        } else {
            j = alaLiveInfoData.live_id;
        }
        return j == this.aBr.mLiveInfo.live_id;
    }

    public int ciD() {
        return this.hFK;
    }

    public AlaLiveInfoData ciG() {
        if (this.hFK >= this.hFI.size()) {
            this.hFK = this.hFI.size() - 1;
        }
        if (this.hFK < 0) {
            this.hFK = 0;
        }
        if (this.hFI.size() <= this.hFK) {
            if (this.aBr != null) {
                return this.aBr.mLiveInfo;
            }
            return null;
        }
        return this.hFI.get(this.hFK);
    }

    public void a(InterfaceC0922a interfaceC0922a) {
        this.omH = interfaceC0922a;
    }

    @Override // com.baidu.live.im.q.a
    public void d(List<com.baidu.live.im.data.b> list, boolean z) {
        if (this.omP != null) {
            this.omP.d(list, z);
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913038, list));
        }
    }

    @Override // com.baidu.live.im.q.a
    public void t(com.baidu.live.im.data.b bVar) {
        if (this.aBr != null && this.aBr.mLiveInfo.live_type == 1) {
            L(bVar);
        }
        if (this.omP != null) {
            this.omP.t(bVar);
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
            ow(true);
        }
    }

    @Override // com.baidu.live.im.q.a
    public void Ig() {
        if (this.omP != null) {
            this.omP.Ig();
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913044));
        }
    }

    public void e(ImSendMsgData imSendMsgData) {
        AlaLiveUserInfoData alaLiveUserInfoData;
        if (this.aBr != null) {
            if (this.mIsHost) {
                alaLiveUserInfoData = this.aBr.aFH;
            } else {
                alaLiveUserInfoData = this.aBr.aGd;
            }
            if (alaLiveUserInfoData != null) {
                String[] strArr = this.aBr.mLiveInfo.imEffect;
                String[] strArr2 = null;
                if (strArr != null) {
                    strArr2 = new String[strArr.length];
                    System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
                }
                if (!TbadkCoreApplication.getInst().isMobileBaidu() && this.aBr != null && this.aBr.aGd != null && this.aBr.mLiveInfo != null) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    String str = this.aBr.aGd.throneUid;
                    if (!TextUtils.isEmpty(currentAccount) && !TextUtils.isEmpty(str) && currentAccount.equals(str)) {
                        if (strArr2 == null || strArr2.length != 2) {
                            strArr2 = new String[2];
                            strArr2[1] = "";
                        }
                        strArr2[0] = "guard_seat_effect";
                    }
                }
                this.omO.a(imSendMsgData, alaLiveUserInfoData.isOfficial == 1, alaLiveUserInfoData.isAdmin == 1, alaLiveUserInfoData.levelId, this.otherParams, strArr2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ciH() {
        this.omO.e(String.valueOf(this.aBr.mLiveInfo.getGroupID()), String.valueOf(this.aBr.mLiveInfo.getLastMsgID()), String.valueOf(this.aBr.mLiveInfo.getUserID()), String.valueOf(this.aBr.mLiveInfo.getLiveID()), this.aBr.mLiveInfo.appId);
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public String ciK() {
        return this.hFQ;
    }

    public void GO(String str) {
        this.hFQ = str;
    }
}

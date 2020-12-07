package com.baidu.tieba.yuyinala.liveroom.i;

import android.location.Address;
import android.os.Handler;
import android.text.TextUtils;
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
import com.baidu.live.data.cv;
import com.baidu.live.data.w;
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
import com.baidu.mobstat.Config;
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
import com.baidu.tieba.yuyinala.liveroom.wheat.model.l;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a extends BdBaseModel implements q.a {
    private w aFN;
    private com.baidu.live.data.q gEW;
    private Set<Long> hyA;
    private long hyC;
    private long hyD;
    private boolean hyE;
    private HttpMessageListener hyJ;
    private HttpMessageListener hyN;
    private HttpMessageListener hyO;
    private HttpMessageListener hyT;
    private HttpMessageListener hyV;
    private BdUniqueId hyi;
    private Handler hyj;
    private List<AlaLiveInfoData> hyo;
    private int hyp;
    private int hyq;
    private int hyu;
    private int hyv;
    private String hyw;
    private com.baidu.live.ac.a hyx;
    private boolean mIsHost;
    private long mLastLiveId;
    private BdPageContext<?> mPageContext;
    private InterfaceC0926a onY;
    private final q oof;
    private q.a oog;
    public boolean ooh;
    private HttpMessageListener ooi;
    private HttpMessageListener ooj;
    private HttpMessageListener ook;
    private HttpMessageListener ool;
    private HttpMessageListener oom;
    private String otherParams;

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0926a {
        void a(int i, String str, int i2, Object obj);
    }

    public a(BdPageContext<?> bdPageContext) {
        super(bdPageContext);
        this.hyj = new Handler();
        this.hyp = 0;
        this.hyq = 0;
        this.hyu = -1;
        this.hyv = 0;
        this.hyx = new com.baidu.live.ac.a(0);
        this.otherParams = "";
        this.hyC = System.currentTimeMillis();
        this.hyE = true;
        this.hyD = 0L;
        this.ooh = false;
        this.hyJ = new HttpMessageListener(1031071) { // from class: com.baidu.tieba.yuyinala.liveroom.i.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                String cjd;
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof MasterIdentityResponseMessage)) {
                    MasterIdentityResponseMessage masterIdentityResponseMessage = (MasterIdentityResponseMessage) httpResponsedMessage;
                    if ((masterIdentityResponseMessage.cjb() == 1 || masterIdentityResponseMessage.cjc() == 1) && !TextUtils.isEmpty(masterIdentityResponseMessage.cjd())) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("text", masterIdentityResponseMessage.cjd());
                            jSONObject.put("content_type", "custom_master_identity");
                            cjd = jSONObject.toString();
                        } catch (JSONException e) {
                            cjd = masterIdentityResponseMessage.cjd();
                            e.printStackTrace();
                        }
                        a.this.oof.a(27, cjd, (com.baidu.live.data.a) null);
                    }
                }
            }
        };
        this.ooi = new HttpMessageListener(1031048) { // from class: com.baidu.tieba.yuyinala.liveroom.i.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            }
        };
        this.ooj = new HttpMessageListener(1031084) { // from class: com.baidu.tieba.yuyinala.liveroom.i.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                AlaWheatInfoDataWrapper alaWheatInfoDataWrapper;
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetWheatListHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == a.this.unique_id && (alaWheatInfoDataWrapper = ((GetWheatListHttpResponseMessage) httpResponsedMessage).aKQ) != null) {
                    a.this.aFN.aKQ = alaWheatInfoDataWrapper;
                    if (alaWheatInfoDataWrapper.getRoomMode() == 1) {
                        a.this.aFN.aKM = new cv();
                        a.this.aFN.aKM.mStep = alaWheatInfoDataWrapper.getActivityStage();
                    }
                    a.this.aFN.aLc = true;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501033, a.this.aFN));
                    a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, a.this.aFN);
                }
            }
        };
        this.ook = new HttpMessageListener(1031023) { // from class: com.baidu.tieba.yuyinala.liveroom.i.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                long j = 0;
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaEnterLiveHttpResonseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == a.this.unique_id) {
                    AlaEnterLiveHttpResonseMessage alaEnterLiveHttpResonseMessage = (AlaEnterLiveHttpResonseMessage) httpResponsedMessage;
                    a.this.aFN = alaEnterLiveHttpResonseMessage.Iq();
                    if (a.this.aFN != null) {
                        a.this.aFN.aLd = true;
                    }
                    a.this.oof.setAlaLiveShowData(a.this.aFN);
                    if (a.this.aFN != null && a.this.aFN.mLiveInfo != null) {
                        if (!TbadkCoreApplication.getInst().isOther() && (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isActivityTaskWatchUnabled())) {
                            com.baidu.tieba.yuyinala.liveroom.task.b.edX().fF(a.this.aFN.mLiveInfo.live_id);
                        }
                        LiveTimerManager.getInstance().start(a.this.aFN.mLiveInfo.live_id);
                    }
                    if (a.this.aFN != null && TbadkCoreApplication.getCurrentAccountInfo() != null) {
                        if (a.this.aFN.aKr != null) {
                            if (a.this.aFN.aKr.levelId > 0) {
                                TbadkCoreApplication.getCurrentAccountInfo().setLiveLevel(a.this.aFN.aKr.levelId);
                            }
                            TbadkCoreApplication.getCurrentAccountObj().setNameShow(a.this.aFN.aKr.nickName);
                            if (!TextUtils.isEmpty(a.this.aFN.aKr.portrait)) {
                                TbadkCoreApplication.getCurrentAccountObj().setPortrait(a.this.aFN.aKr.portrait);
                            }
                        }
                        if (a.this.aFN.mLiveSdkInfo != null) {
                            TbadkCoreApplication.getInst().setTbs(a.this.aFN.mLiveSdkInfo.tbs);
                            com.baidu.live.d.BM().putString("ala_account_user_tbs", a.this.aFN.mLiveSdkInfo.tbs);
                        }
                    }
                    if (a.this.aFN != null) {
                        if (a.this.hyo.size() <= 0) {
                            a.this.hyo.add(a.this.aFN.mLiveInfo);
                            a.this.hyA.add(Long.valueOf(a.this.aFN.mLiveInfo.getLiveID()));
                        }
                        a.this.h(a.this.aFN.mLiveInfo);
                        if (a.this.oof != null) {
                            a.this.oof.R(a.this.aFN.aKB);
                        }
                    }
                    if (a.this.aFN != null && a.this.aFN.aJX != null) {
                        a.this.hyu = a.this.aFN.aJX.follow_status;
                    }
                    a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 3, a.this.aFN);
                    if (a.this.aFN != null && a.this.aFN.mLiveInfo != null) {
                        a.this.cjL();
                    }
                    if (a.this.aFN != null) {
                        a.this.aFN.isHost = false;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913081, a.this.aFN));
                        com.baidu.live.im.b.d.NK().V(a.this.aFN.aKB);
                    }
                    a.this.a(alaEnterLiveHttpResonseMessage);
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        if (a.this.aFN != null && a.this.aFN.mLiveInfo != null) {
                            long j2 = a.this.aFN.mLiveInfo.live_id;
                            long j3 = a.this.aFN.mLiveInfo.room_id;
                            String str = a.this.aFN.mLiveInfo.feed_id;
                            String str2 = "";
                            if (a.this.aFN.aJV != null) {
                                long j4 = a.this.aFN.aJV.userId;
                                str2 = a.this.aFN.aJV.userName;
                                j = j4;
                            }
                            HKStaticManager.staticStartPlayTime(j2 + "", j3 + "", j + "", str2, System.currentTimeMillis(), str, a.this.otherParams);
                        }
                    } else if ((TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) && a.this.aFN != null && a.this.aFN.mLiveInfo != null) {
                        long j5 = a.this.aFN.mLiveInfo.live_id;
                        long j6 = a.this.aFN.mLiveInfo.room_id;
                        String str3 = a.this.aFN.mLiveInfo.feed_id;
                        String str4 = "";
                        if (a.this.aFN.aJV != null) {
                            j = a.this.aFN.aJV.userId;
                            str4 = a.this.aFN.aJV.userName;
                        }
                        QMStaticManager.staticStartPlayTime(j5 + "", j6 + "", j + "", str4, System.currentTimeMillis(), str3, a.this.otherParams, a.this.hyq + "");
                    }
                }
            }
        };
        this.hyN = new HttpMessageListener(1031042) { // from class: com.baidu.tieba.yuyinala.liveroom.i.a.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaGetAudienceHttpResponseMessage)) {
                    com.baidu.live.data.q bUt = ((AlaGetAudienceHttpResponseMessage) httpResponsedMessage).bUt();
                    Message<?> message = httpResponsedMessage.getmOrginalMessage();
                    if (message instanceof com.baidu.tieba.yuyinala.liveroom.messages.b) {
                        com.baidu.tieba.yuyinala.liveroom.messages.b bVar = (com.baidu.tieba.yuyinala.liveroom.messages.b) message;
                        if (String.valueOf(bVar.edM()).equals(a.this.aFN.aKL.live_id)) {
                            bUt.liveId = String.valueOf(bVar.edM());
                        } else {
                            return;
                        }
                    }
                    if (bUt != null) {
                        a.this.gEW = bUt;
                    }
                    if (a.this.aFN != null && a.this.aFN.aJX != null) {
                        if (a.this.hyu == -1) {
                            a.this.hyu = a.this.aFN.aJX.follow_status;
                        }
                        if (a.this.aFN.aJX.follow_status != a.this.hyu) {
                            a.this.aFN.aJX.follow_status = a.this.hyu;
                        }
                    }
                    a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 2, a.this.gEW);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913016, a.this.gEW));
                }
            }
        };
        this.hyO = new HttpMessageListener(1021121) { // from class: com.baidu.tieba.yuyinala.liveroom.i.a.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaUserLiveMarkInfoResponseMessage) {
                    AlaUserLiveMarkInfoResponseMessage alaUserLiveMarkInfoResponseMessage = (AlaUserLiveMarkInfoResponseMessage) httpResponsedMessage;
                    if (alaUserLiveMarkInfoResponseMessage.getError() == 0) {
                        List<AlaLiveMarkData> cja = alaUserLiveMarkInfoResponseMessage.cja();
                        a.this.oof.R(cja);
                        if (a.this.aFN != null) {
                            a.this.aFN.aKB = cja;
                            com.baidu.live.im.b.d.NK().V(a.this.aFN.aKB);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913118, a.this.aFN));
                        }
                    }
                }
            }
        };
        this.ool = new HttpMessageListener(1031024) { // from class: com.baidu.tieba.yuyinala.liveroom.i.a.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof YuyinGetLiveInfoHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == a.this.unique_id) {
                    if (httpResponsedMessage.hasError()) {
                        a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, null);
                        return;
                    }
                    w Iq = httpResponsedMessage instanceof YuyinGetLiveInfoHttpResponseMessage ? ((YuyinGetLiveInfoHttpResponseMessage) httpResponsedMessage).Iq() : null;
                    if (Iq == null) {
                        a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, Iq);
                        return;
                    }
                    if (a.this.aFN == null) {
                        a.this.aFN = Iq;
                        a.this.oof.setAlaLiveShowData(a.this.aFN);
                    } else if (a.this.aFN.mLiveInfo != null && Iq.mLiveInfo != null && a.this.aFN.mLiveInfo.live_id != Iq.mLiveInfo.live_id) {
                        a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, a.this.aFN);
                        return;
                    }
                    if (a.this.aFN.mLiveInfo != null && Iq.mLiveInfo != null && a.this.aFN.mLiveInfo.user_id == Iq.mLiveInfo.user_id) {
                        if (a.this.aFN.mLiveInfo.mLiveCloseData != null && Iq.mLiveInfo.mLiveCloseData == null) {
                            Iq.mLiveInfo.mLiveCloseData = a.this.aFN.mLiveInfo.mLiveCloseData;
                        }
                        if (a.this.aFN.mLiveInfo.mAlaLiveSwitchData != null && Iq.mLiveInfo.mAlaLiveSwitchData == null) {
                            Iq.mLiveInfo.mAlaLiveSwitchData = a.this.aFN.mLiveInfo.mAlaLiveSwitchData;
                        }
                    }
                    a.this.aFN.mLiveInfo = Iq.mLiveInfo;
                    a.this.aFN.aJV = Iq.aJV;
                    if (a.this.aFN.aKL != null && Iq.aKL != null && !TextUtils.equals(a.this.aFN.aKL.bg_cover, Iq.aKL.bg_cover)) {
                        a.this.ooh = true;
                    } else {
                        a.this.ooh = false;
                    }
                    a.this.aFN.aKL = Iq.aKL;
                    a.this.aFN.aKM = Iq.aKM;
                    a.this.aFN.aJW = Iq.aJW;
                    a.this.aFN.aKa = Iq.aKa;
                    a.this.aFN.aKC = Iq.aKC;
                    a.this.aFN.aKA = Iq.aKA;
                    a.this.aFN.aKw = Iq.aKw;
                    a.this.aFN.aKJ = Iq.aKJ;
                    a.this.aFN.aKK = Iq.aKK;
                    a.this.aFN.aKQ = Iq.aKQ;
                    if (Iq.aKF != null && Iq.aKF.aPa != null && !Iq.aKF.aPa.isEmpty()) {
                        a.this.aFN.aKF = Iq.aKF;
                    }
                    if (Iq.aKr != null) {
                        if (Iq.aKr.userId != 0) {
                            a.this.aFN.aKr = Iq.aKr;
                            TbadkCoreApplication.getCurrentAccountObj().setNameShow(a.this.aFN.aKr.nickName);
                        } else {
                            if (a.this.aFN.aKr == null) {
                                a.this.aFN.aKr = new AlaLiveUserInfoData();
                            }
                            a.this.aFN.aKr.throneUid = Iq.aKr.throneUid;
                        }
                    }
                    if (Iq.aKu != null) {
                        a.this.aFN.aKu = Iq.aKu;
                    }
                    if (Iq.aKA) {
                        a.this.aFN.aKB = Iq.aKB;
                        if (a.this.oof != null) {
                            a.this.oof.R(Iq.aKB);
                        }
                    }
                    if (!a.this.mIsHost && a.this.aFN.mLiveInfo != null) {
                        int i = a.this.aFN.mLiveInfo.backstage_type;
                        if (a.this.oof != null) {
                            a.this.oof.ia(String.valueOf(i));
                        }
                    }
                    if (a.this.oof != null) {
                        a.this.oof.setAlaLiveShowData(a.this.aFN);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501033, a.this.aFN));
                    a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, a.this.aFN);
                    if (a.this.aFN != null) {
                        com.baidu.live.im.b.d.NK().V(a.this.aFN.aKB);
                    }
                }
            }
        };
        this.oom = new HttpMessageListener(1031044) { // from class: com.baidu.tieba.yuyinala.liveroom.i.a.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                List<Long> list;
                long j;
                if (httpResponsedMessage != null && httpResponsedMessage.getOrginalMessage().getTag() == a.this.unique_id) {
                    if (!(httpResponsedMessage instanceof AlaMGetLiveStatusHttpResponseMessage)) {
                        list = null;
                        j = 5000;
                    } else {
                        AlaMGetLiveStatusHttpResponseMessage alaMGetLiveStatusHttpResponseMessage = (AlaMGetLiveStatusHttpResponseMessage) httpResponsedMessage;
                        list = alaMGetLiveStatusHttpResponseMessage.getClosedIds();
                        j = alaMGetLiveStatusHttpResponseMessage.getInterval();
                    }
                    long j2 = j >= 5000 ? j : 5000L;
                    if (list != null && list.size() > 0 && a.this.hyo != null && a.this.hyo.size() > 0) {
                        for (int size = a.this.hyo.size() - 1; size >= 0; size--) {
                            if (((AlaLiveInfoData) a.this.hyo.get(size)).live_id != a.this.aFN.mLiveInfo.live_id && list.contains(Long.valueOf(((AlaLiveInfoData) a.this.hyo.get(size)).getLiveID()))) {
                                a.this.hyo.remove(size);
                            }
                        }
                    }
                    if (a.this.aFN != null) {
                        a.this.h(a.this.aFN.mLiveInfo);
                    }
                    a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 4, Long.valueOf(j2));
                }
            }
        };
        this.hyT = new HttpMessageListener(1031062) { // from class: com.baidu.tieba.yuyinala.liveroom.i.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getOrginalMessage() != null && (httpResponsedMessage.getOrginalMessage().getExtra() instanceof com.baidu.live.q.b)) {
                    com.baidu.live.q.b bVar = (com.baidu.live.q.b) httpResponsedMessage.getOrginalMessage().getExtra();
                    if (bVar.btq != null) {
                        if (httpResponsedMessage.getError() == 0) {
                            bVar.btq.il(bVar.contentType);
                        } else {
                            bVar.btq.d(bVar.contentType, httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                        }
                    }
                }
            }
        };
        this.hyV = new HttpMessageListener(1031037) { // from class: com.baidu.tieba.yuyinala.liveroom.i.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                c cVar;
                if (httpResponsedMessage != null && httpResponsedMessage.getError() == 0) {
                    if (!(httpResponsedMessage instanceof AlaLiveRecommondHttpResponseMessage)) {
                        cVar = null;
                    } else {
                        cVar = ((AlaLiveRecommondHttpResponseMessage) httpResponsedMessage).edN();
                    }
                    if (cVar != null && !ListUtils.isEmpty(cVar.aKk)) {
                        a.this.hyp = cVar.pn + 1;
                        b bVar = cVar.aKk.get(cVar.aKk.size() - 1);
                        if (bVar != null) {
                            a.this.mLastLiveId = bVar.mLiveInfo.live_id;
                        }
                        a.this.a(cVar);
                        if (a.this.aFN != null) {
                            a.this.h(a.this.aFN.mLiveInfo);
                        }
                        a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 5, cVar);
                    }
                }
            }
        };
        this.mPageContext = bdPageContext;
        this.oof = new q(bdPageContext, false, this);
        this.hyo = new ArrayList();
        this.hyA = new HashSet();
        initTasks();
        registerListener(this.ool);
        this.hyi = BdUniqueId.gen();
        registerListener(this.oom);
        registerListener(this.hyT);
    }

    private void initTasks() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031037, TbConfig.SERVER_ADDRESS + "ala/audio/recommend/getSwitchLives");
        tbHttpMessageTask.setResponsedClass(AlaLiveRecommondHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.hyV.setTag(this.hyi);
        registerListener(this.hyV);
        TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(1031042, TbConfig.SERVER_ADDRESS + "ala/audio/live/getAudienceInfo");
        tbHttpMessageTask2.setIsNeedLogin(false);
        tbHttpMessageTask2.setIsNeedTbs(true);
        tbHttpMessageTask2.setRetry(1);
        tbHttpMessageTask2.setResponsedClass(AlaGetAudienceHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask2);
        registerListener(this.hyN);
        TbHttpMessageTask tbHttpMessageTask3 = new TbHttpMessageTask(1031023, TbConfig.SERVER_ADDRESS + "ala/audio/enterLive");
        tbHttpMessageTask3.setIsNeedLogin(true);
        tbHttpMessageTask3.setIsNeedTbs(true);
        tbHttpMessageTask3.setIsNeedAddCommenParam(true);
        tbHttpMessageTask3.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask3.setResponsedClass(AlaEnterLiveHttpResonseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask3);
        registerListener(this.ook);
        TbHttpMessageTask tbHttpMessageTask4 = new TbHttpMessageTask(1031084, TbConfig.SERVER_ADDRESS + "/ala/audio/link/online");
        tbHttpMessageTask4.setIsNeedLogin(true);
        tbHttpMessageTask4.setIsNeedTbs(true);
        tbHttpMessageTask4.setIsNeedAddCommenParam(true);
        tbHttpMessageTask4.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask4.setResponsedClass(GetWheatListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask4);
        registerListener(this.ooj);
        com.baidu.live.tieba.f.a.a.a(1031048, "ala/audio/exitLive", AlaQuitLiveHttpResponseMessage.class, false, true, true, true);
        registerListener(this.ooi);
        com.baidu.live.tieba.f.a.a.a(1021121, "ala/sdk/v1/open/getUserLiveMarkInfo", AlaUserLiveMarkInfoResponseMessage.class, true, true, true, true);
        registerListener(this.hyO);
        TbHttpMessageTask tbHttpMessageTask5 = new TbHttpMessageTask(1031071, TbConfig.SERVER_ADDRESS + "ala/UGC/getUGCAnchorInfo");
        tbHttpMessageTask5.setIsNeedLogin(false);
        tbHttpMessageTask5.setIsNeedTbs(true);
        tbHttpMessageTask5.setResponsedClass(MasterIdentityResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask5);
        registerListener(this.hyJ);
    }

    public void cjm() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913043, new CustomMessageTask.CustomRunnable<ImSendMsgData>() { // from class: com.baidu.tieba.yuyinala.liveroom.i.a.1
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

    public void cjn() {
        MessageManager.getInstance().unRegisterTask(2913043);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, String str, int i2, Object obj) {
        if (this.onY != null) {
            this.onY.a(i, str, i2, obj);
        }
    }

    public void hN(long j) {
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

    public void a(long j, String str, long j2, long j3) {
        e eVar = new e();
        eVar.setLiveId(j);
        eVar.setFrom(str);
        eVar.aZ(j2);
        eVar.aQ(j3);
        eVar.setParams();
        sendMessage(eVar);
    }

    public void cjy() {
        if (TbadkCoreApplication.isLogin()) {
            HttpMessage httpMessage = new HttpMessage(1021121);
            httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccount());
            sendMessage(httpMessage);
        }
    }

    public w Iq() {
        return this.aFN;
    }

    public void setLiveShowData(w wVar) {
        this.aFN = wVar;
    }

    public List<AlaLiveInfoData> cjA() {
        return this.hyo;
    }

    public com.baidu.live.data.q bUt() {
        return this.gEW;
    }

    public void cF(List<Long> list) {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
            com.baidu.tieba.yuyinala.liveroom.messages.c cVar = new com.baidu.tieba.yuyinala.liveroom.messages.c();
            if (this.aFN != null && this.aFN.mLiveInfo != null) {
                cVar.setAudienceCount(this.aFN.mLiveInfo.audience_count);
            }
            cVar.setListIds(list);
            cVar.setParams();
            sendMessage(cVar);
        }
    }

    public void cjB() {
        ArrayList arrayList = new ArrayList();
        for (AlaLiveInfoData alaLiveInfoData : this.hyo) {
            if (alaLiveInfoData != null) {
                arrayList.add(Long.valueOf(alaLiveInfoData.live_id));
            }
        }
        cF(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c cVar) {
        if (cVar != null) {
            if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isYinbo()) {
                if (this.hyo.size() == 1 && this.hyo.get(0).live_id == this.aFN.mLiveInfo.live_id) {
                    if (c(cVar) != null) {
                        this.hyo.clear();
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
        for (b bVar : cVar.aKk) {
            if (bVar != null && bVar.mLiveInfo != null) {
                for (AlaLiveInfoData alaLiveInfoData : this.hyo) {
                    if (alaLiveInfoData == null || alaLiveInfoData.live_id == bVar.mLiveInfo.live_id) {
                        z = false;
                        break;
                    }
                    while (r4.hasNext()) {
                    }
                }
                z = true;
                if (z) {
                    this.hyo.add(bVar.mLiveInfo);
                }
            }
        }
        if (this.hyo.size() >= 200) {
            ArrayList arrayList = new ArrayList();
            for (int size = this.hyo.size() - 200; size < this.hyo.size(); size++) {
                arrayList.add(this.hyo.get(size));
            }
            if (!ListUtils.isEmpty(arrayList)) {
                this.hyo.clear();
                this.hyo.addAll(arrayList);
                arrayList.clear();
            }
        }
    }

    private AlaLiveInfoData c(c cVar) {
        if (ListUtils.isEmpty(cVar.aKk)) {
            return null;
        }
        for (b bVar : cVar.aKk) {
            if (bVar != null && bVar.mLiveInfo != null && bVar.mLiveInfo.live_id == this.aFN.mLiveInfo.live_id) {
                return bVar.mLiveInfo;
            }
        }
        return null;
    }

    public ArrayList<AlaLiveInfoData> cjC() {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        if (ListUtils.isEmpty(this.hyo)) {
            return null;
        }
        if (this.hyA.isEmpty()) {
            arrayList.addAll(this.hyo);
        } else {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.hyo.size()) {
                    break;
                }
                if ((this.aFN == null || this.aFN.mLiveInfo == null || this.aFN.mLiveInfo.live_id != this.hyo.get(i2).live_id) && !this.hyA.contains(Long.valueOf(this.hyo.get(i2).live_id))) {
                    arrayList.add(this.hyo.get(i2));
                }
                i = i2 + 1;
            }
        }
        return arrayList;
    }

    public void g(AlaLiveInfoData alaLiveInfoData) {
        if (alaLiveInfoData != null) {
            this.hyA.add(Long.valueOf(alaLiveInfoData.getLiveID()));
            if (this.hyA.size() >= this.hyo.size() - 4) {
                ob(false);
            }
        }
    }

    public void xi(int i) {
        this.hyv = i;
    }

    public void ob(boolean z) {
        oc(z);
    }

    private void oc(boolean z) {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.hyD >= 1800000) {
                this.hyC = currentTimeMillis;
                this.hyE = true;
            }
            if (this.hyE) {
                HttpMessage httpMessage = new HttpMessage(1031037);
                httpMessage.addParam(Config.PACKAGE_NAME, z ? 0 : this.hyp);
                httpMessage.addParam("ps", 20);
                httpMessage.addParam("scr_w", BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst()));
                httpMessage.addParam("scr_h", BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst()));
                httpMessage.addParam("q_type", 0);
                httpMessage.addParam("scr_dip", String.valueOf(BdUtilHelper.getEquipmentDensity(TbadkCoreApplication.getInst())));
                httpMessage.addParam("forum_id", "");
                httpMessage.addParam("entry_name", "");
                httpMessage.addParam("live_id", this.mLastLiveId);
                httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccountId());
                httpMessage.addParam("slide_session_id", this.hyC);
                httpMessage.setTag(this.hyi);
                sendMessage(httpMessage);
                this.hyD = currentTimeMillis;
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
        aVar.Bc(str);
        aVar.setLiveId(j);
        aVar.setParams();
        sendMessage(aVar);
        cjN();
    }

    public void Wr(String str) {
        sendMessage(new l(str));
    }

    public void at(String str, String str2, String str3) {
        Address address = BdLocationMananger.getInstance().getAddress(false);
        com.baidu.tieba.yuyinala.liveroom.messages.a aVar = new com.baidu.tieba.yuyinala.liveroom.messages.a();
        if (address != null) {
            aVar.b(address.getLongitude(), address.getLatitude());
        }
        aVar.setForumName(str3);
        aVar.Bc(str2);
        aVar.setUk(str);
        aVar.setParams();
        sendMessage(aVar);
        cjN();
    }

    public void ID(String str) {
        Address address = BdLocationMananger.getInstance().getAddress(false);
        com.baidu.tieba.yuyinala.liveroom.messages.a aVar = new com.baidu.tieba.yuyinala.liveroom.messages.a();
        if (address != null) {
            aVar.b(address.getLongitude(), address.getLatitude());
        }
        aVar.setRoomId(str);
        aVar.setParams();
        sendMessage(aVar);
        cjN();
    }

    public void fD(long j) {
        this.oof.DN();
        this.hyw = null;
        com.baidu.tieba.yuyinala.liveroom.messages.d dVar = new com.baidu.tieba.yuyinala.liveroom.messages.d();
        dVar.setLiveId(j);
        dVar.setParams();
        dVar.setTag(BdUniqueId.gen());
        sendMessage(dVar);
    }

    public void b(AlaLiveInfoCoreData alaLiveInfoCoreData) {
        if (this.aFN == null) {
            this.aFN = new w(alaLiveInfoCoreData);
            this.aFN.bz(true);
            this.oof.setAlaLiveShowData(this.aFN);
        }
        this.mLastLiveId = this.aFN.mLiveInfo.live_id;
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
        this.hyj.removeCallbacksAndMessages(null);
        cancelLoadData();
        MessageManager.getInstance().unRegisterListener(this.hyV);
        MessageManager.getInstance().removeMessageRule(this.hyx);
        MessageManager.getInstance().unRegisterListener(this.unique_id);
        MessageManager.getInstance().unRegisterTask(1021163);
        MessageManager.getInstance().removeMessage(1031062, getUniqueId());
        this.oof.DN();
        this.oog = null;
        this.mPageContext = null;
    }

    public void xj(int i) {
        this.hyq = i;
        if (this.hyo.size() == 0) {
            this.hyq = 0;
        } else if (this.hyq < 0) {
            this.hyq = this.hyo.size() + this.hyq;
        } else {
            this.hyq %= this.hyo.size();
        }
    }

    public void h(AlaLiveInfoData alaLiveInfoData) {
        if (alaLiveInfoData != null && this.hyo.size() != 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.hyo.size()) {
                    if (this.hyo.get(i2).live_id != alaLiveInfoData.live_id) {
                        i = i2 + 1;
                    } else {
                        this.hyq = i2;
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public boolean cjF() {
        long j;
        if (this.aFN == null || this.aFN.mLiveInfo == null || this.hyo.size() <= 0) {
            return true;
        }
        AlaLiveInfoData alaLiveInfoData = this.hyo.get(0);
        if (alaLiveInfoData == null) {
            j = 0;
        } else {
            j = alaLiveInfoData.live_id;
        }
        return j == this.aFN.mLiveInfo.live_id;
    }

    public boolean cjG() {
        long j;
        if (this.aFN == null || this.aFN.mLiveInfo == null || this.hyo.size() <= 0) {
            return true;
        }
        AlaLiveInfoData alaLiveInfoData = this.hyo.get(this.hyo.size() - 1);
        if (alaLiveInfoData == null) {
            j = 0;
        } else {
            j = alaLiveInfoData.live_id;
        }
        return j == this.aFN.mLiveInfo.live_id;
    }

    public int cjH() {
        return this.hyq;
    }

    public AlaLiveInfoData cjK() {
        if (this.hyq >= this.hyo.size()) {
            this.hyq = this.hyo.size() - 1;
        }
        if (this.hyq < 0) {
            this.hyq = 0;
        }
        if (this.hyo.size() <= this.hyq) {
            if (this.aFN != null) {
                return this.aFN.mLiveInfo;
            }
            return null;
        }
        return this.hyo.get(this.hyq);
    }

    public void a(InterfaceC0926a interfaceC0926a) {
        this.onY = interfaceC0926a;
    }

    @Override // com.baidu.live.im.q.a
    public void d(List<com.baidu.live.im.data.b> list, boolean z) {
        if (this.oog != null) {
            this.oog.d(list, z);
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913038, list));
        }
    }

    @Override // com.baidu.live.im.q.a
    public void t(com.baidu.live.im.data.b bVar) {
        if (this.aFN != null && this.aFN.mLiveInfo.live_type == 1) {
            J(bVar);
        }
        if (this.oog != null) {
            this.oog.t(bVar);
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913037, bVar));
        }
    }

    public void J(com.baidu.live.im.data.b bVar) {
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
            ob(true);
        }
    }

    @Override // com.baidu.live.im.q.a
    public void ME() {
        if (this.oog != null) {
            this.oog.ME();
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913044));
        }
    }

    public void e(ImSendMsgData imSendMsgData) {
        AlaLiveUserInfoData alaLiveUserInfoData;
        if (this.aFN != null) {
            if (this.mIsHost) {
                alaLiveUserInfoData = this.aFN.aJV;
            } else {
                alaLiveUserInfoData = this.aFN.aKr;
            }
            if (alaLiveUserInfoData != null) {
                String[] strArr = this.aFN.mLiveInfo.imEffect;
                String[] strArr2 = null;
                if (strArr != null) {
                    strArr2 = new String[strArr.length];
                    System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
                }
                if (!TbadkCoreApplication.getInst().isMobileBaidu() && this.aFN != null && this.aFN.aKr != null && this.aFN.mLiveInfo != null) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    String str = this.aFN.aKr.throneUid;
                    if (!TextUtils.isEmpty(currentAccount) && !TextUtils.isEmpty(str) && currentAccount.equals(str)) {
                        if (strArr2 == null || strArr2.length != 2) {
                            strArr2 = new String[2];
                            strArr2[1] = "";
                        }
                        strArr2[0] = "guard_seat_effect";
                    }
                }
                this.oof.a(imSendMsgData, alaLiveUserInfoData.isOfficial == 1, alaLiveUserInfoData.isAdmin == 1, alaLiveUserInfoData.levelId, this.otherParams, strArr2);
            }
        }
    }

    public void cjL() {
        this.oof.e(String.valueOf(this.aFN.mLiveInfo.getGroupID()), String.valueOf(this.aFN.mLiveInfo.getLastMsgID()), String.valueOf(this.aFN.mLiveInfo.getUserID()), String.valueOf(this.aFN.mLiveInfo.getLiveID()), this.aFN.mLiveInfo.appId);
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    private void cjN() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaEnterLiveHttpResonseMessage alaEnterLiveHttpResonseMessage) {
    }

    public String cjO() {
        return this.hyw;
    }

    public void Ia(String str) {
        this.hyw = str;
    }
}

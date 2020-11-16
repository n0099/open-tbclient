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
import com.baidu.live.data.ct;
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
    private w aDh;
    private com.baidu.live.data.q gwn;
    private BdUniqueId hoE;
    private Handler hoF;
    private List<AlaLiveInfoData> hoK;
    private int hoL;
    private int hoM;
    private int hoQ;
    private int hoR;
    private String hoS;
    private com.baidu.live.y.a hoT;
    private Set<Long> hoW;
    private long hoY;
    private long hoZ;
    private boolean hpa;
    private HttpMessageListener hpf;
    private HttpMessageListener hpj;
    private HttpMessageListener hpk;
    private HttpMessageListener hpp;
    private HttpMessageListener hpr;
    private boolean mIsHost;
    private long mLastLiveId;
    private BdPageContext<?> mPageContext;
    private InterfaceC0909a nYY;
    private final q nZf;
    private q.a nZg;
    public boolean nZh;
    private HttpMessageListener nZi;
    private HttpMessageListener nZj;
    private HttpMessageListener nZk;
    private HttpMessageListener nZl;
    private HttpMessageListener nZm;
    private String otherParams;

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0909a {
        void a(int i, String str, int i2, Object obj);
    }

    public a(BdPageContext<?> bdPageContext) {
        super(bdPageContext);
        this.hoF = new Handler();
        this.hoL = 0;
        this.hoM = 0;
        this.hoQ = -1;
        this.hoR = 0;
        this.hoT = new com.baidu.live.y.a(0);
        this.otherParams = "";
        this.hoY = System.currentTimeMillis();
        this.hpa = true;
        this.hoZ = 0L;
        this.nZh = false;
        this.hpf = new HttpMessageListener(1031071) { // from class: com.baidu.tieba.yuyinala.liveroom.i.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                String cfj;
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof MasterIdentityResponseMessage)) {
                    MasterIdentityResponseMessage masterIdentityResponseMessage = (MasterIdentityResponseMessage) httpResponsedMessage;
                    if ((masterIdentityResponseMessage.cfh() == 1 || masterIdentityResponseMessage.cfi() == 1) && !TextUtils.isEmpty(masterIdentityResponseMessage.cfj())) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("text", masterIdentityResponseMessage.cfj());
                            jSONObject.put("content_type", "custom_master_identity");
                            cfj = jSONObject.toString();
                        } catch (JSONException e) {
                            cfj = masterIdentityResponseMessage.cfj();
                            e.printStackTrace();
                        }
                        a.this.nZf.a(27, cfj, (com.baidu.live.data.a) null);
                    }
                }
            }
        };
        this.nZi = new HttpMessageListener(1031048) { // from class: com.baidu.tieba.yuyinala.liveroom.i.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            }
        };
        this.nZj = new HttpMessageListener(1031084) { // from class: com.baidu.tieba.yuyinala.liveroom.i.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                AlaWheatInfoDataWrapper alaWheatInfoDataWrapper;
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetWheatListHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == a.this.unique_id && (alaWheatInfoDataWrapper = ((GetWheatListHttpResponseMessage) httpResponsedMessage).aIe) != null) {
                    a.this.aDh.aIe = alaWheatInfoDataWrapper;
                    if (alaWheatInfoDataWrapper.getRoomMode() == 1) {
                        a.this.aDh.aIa = new ct();
                        a.this.aDh.aIa.mStep = alaWheatInfoDataWrapper.getActivityStage();
                    }
                    a.this.aDh.aIq = true;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501033, a.this.aDh));
                    a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, a.this.aDh);
                }
            }
        };
        this.nZk = new HttpMessageListener(1031023) { // from class: com.baidu.tieba.yuyinala.liveroom.i.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                long j = 0;
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaEnterLiveHttpResonseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == a.this.unique_id) {
                    AlaEnterLiveHttpResonseMessage alaEnterLiveHttpResonseMessage = (AlaEnterLiveHttpResonseMessage) httpResponsedMessage;
                    a.this.aDh = alaEnterLiveHttpResonseMessage.Gz();
                    a.this.aDh.aIr = true;
                    a.this.nZf.setAlaLiveShowData(a.this.aDh);
                    if (a.this.aDh != null && a.this.aDh.mLiveInfo != null) {
                        if (!TbadkCoreApplication.getInst().isOther() && (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isActivityTaskWatchUnabled())) {
                            com.baidu.tieba.yuyinala.liveroom.task.b.dYt().fb(a.this.aDh.mLiveInfo.live_id);
                        }
                        LiveTimerManager.getInstance().start(a.this.aDh.mLiveInfo.live_id);
                    }
                    if (a.this.aDh != null && TbadkCoreApplication.getCurrentAccountInfo() != null) {
                        if (a.this.aDh.aHG != null) {
                            if (a.this.aDh.aHG.levelId > 0) {
                                TbadkCoreApplication.getCurrentAccountInfo().setLiveLevel(a.this.aDh.aHG.levelId);
                            }
                            TbadkCoreApplication.getCurrentAccountObj().setNameShow(a.this.aDh.aHG.nickName);
                            if (!TextUtils.isEmpty(a.this.aDh.aHG.portrait)) {
                                TbadkCoreApplication.getCurrentAccountObj().setPortrait(a.this.aDh.aHG.portrait);
                            }
                        }
                        if (a.this.aDh.mLiveSdkInfo != null) {
                            TbadkCoreApplication.getInst().setTbs(a.this.aDh.mLiveSdkInfo.tbs);
                            com.baidu.live.d.Aq().putString("ala_account_user_tbs", a.this.aDh.mLiveSdkInfo.tbs);
                        }
                    }
                    if (a.this.aDh != null) {
                        if (a.this.hoK.size() <= 0) {
                            a.this.hoK.add(a.this.aDh.mLiveInfo);
                            a.this.hoW.add(Long.valueOf(a.this.aDh.mLiveInfo.getLiveID()));
                        }
                        a.this.h(a.this.aDh.mLiveInfo);
                        if (a.this.nZf != null) {
                            a.this.nZf.Q(a.this.aDh.aHP);
                        }
                    }
                    if (a.this.aDh != null && a.this.aDh.aHm != null) {
                        a.this.hoQ = a.this.aDh.aHm.follow_status;
                    }
                    a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 3, a.this.aDh);
                    if (a.this.aDh != null && a.this.aDh.mLiveInfo != null) {
                        a.this.cfR();
                    }
                    if (a.this.aDh != null) {
                        a.this.aDh.isHost = false;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913081, a.this.aDh));
                        com.baidu.live.im.b.d.Lx().U(a.this.aDh.aHP);
                    }
                    a.this.a(alaEnterLiveHttpResonseMessage);
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        if (a.this.aDh != null && a.this.aDh.mLiveInfo != null) {
                            long j2 = a.this.aDh.mLiveInfo.live_id;
                            long j3 = a.this.aDh.mLiveInfo.room_id;
                            String str = a.this.aDh.mLiveInfo.feed_id;
                            String str2 = "";
                            if (a.this.aDh.aHk != null) {
                                long j4 = a.this.aDh.aHk.userId;
                                str2 = a.this.aDh.aHk.userName;
                                j = j4;
                            }
                            HKStaticManager.staticStartPlayTime(j2 + "", j3 + "", j + "", str2, System.currentTimeMillis(), str, a.this.otherParams);
                        }
                    } else if ((TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) && a.this.aDh != null && a.this.aDh.mLiveInfo != null) {
                        long j5 = a.this.aDh.mLiveInfo.live_id;
                        long j6 = a.this.aDh.mLiveInfo.room_id;
                        String str3 = a.this.aDh.mLiveInfo.feed_id;
                        String str4 = "";
                        if (a.this.aDh.aHk != null) {
                            j = a.this.aDh.aHk.userId;
                            str4 = a.this.aDh.aHk.userName;
                        }
                        QMStaticManager.staticStartPlayTime(j5 + "", j6 + "", j + "", str4, System.currentTimeMillis(), str3, a.this.otherParams, a.this.hoM + "");
                    }
                }
            }
        };
        this.hpj = new HttpMessageListener(1031042) { // from class: com.baidu.tieba.yuyinala.liveroom.i.a.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaGetAudienceHttpResponseMessage)) {
                    com.baidu.live.data.q bQJ = ((AlaGetAudienceHttpResponseMessage) httpResponsedMessage).bQJ();
                    Message<?> message = httpResponsedMessage.getmOrginalMessage();
                    if (message instanceof com.baidu.tieba.yuyinala.liveroom.messages.b) {
                        com.baidu.tieba.yuyinala.liveroom.messages.b bVar = (com.baidu.tieba.yuyinala.liveroom.messages.b) message;
                        if (String.valueOf(bVar.dYi()).equals(a.this.aDh.aHZ.live_id)) {
                            bQJ.liveId = String.valueOf(bVar.dYi());
                        } else {
                            return;
                        }
                    }
                    if (bQJ != null) {
                        a.this.gwn = bQJ;
                    }
                    if (a.this.aDh != null && a.this.aDh.aHm != null) {
                        if (a.this.hoQ == -1) {
                            a.this.hoQ = a.this.aDh.aHm.follow_status;
                        }
                        if (a.this.aDh.aHm.follow_status != a.this.hoQ) {
                            a.this.aDh.aHm.follow_status = a.this.hoQ;
                        }
                    }
                    a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 2, a.this.gwn);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913016, a.this.gwn));
                }
            }
        };
        this.hpk = new HttpMessageListener(1021121) { // from class: com.baidu.tieba.yuyinala.liveroom.i.a.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaUserLiveMarkInfoResponseMessage) {
                    AlaUserLiveMarkInfoResponseMessage alaUserLiveMarkInfoResponseMessage = (AlaUserLiveMarkInfoResponseMessage) httpResponsedMessage;
                    if (alaUserLiveMarkInfoResponseMessage.getError() == 0) {
                        List<AlaLiveMarkData> cfg = alaUserLiveMarkInfoResponseMessage.cfg();
                        a.this.nZf.Q(cfg);
                        if (a.this.aDh != null) {
                            a.this.aDh.aHP = cfg;
                            com.baidu.live.im.b.d.Lx().U(a.this.aDh.aHP);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913118, a.this.aDh));
                        }
                    }
                }
            }
        };
        this.nZl = new HttpMessageListener(1031024) { // from class: com.baidu.tieba.yuyinala.liveroom.i.a.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof YuyinGetLiveInfoHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == a.this.unique_id) {
                    if (httpResponsedMessage.hasError()) {
                        a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, null);
                        return;
                    }
                    w Gz = httpResponsedMessage instanceof YuyinGetLiveInfoHttpResponseMessage ? ((YuyinGetLiveInfoHttpResponseMessage) httpResponsedMessage).Gz() : null;
                    if (Gz == null) {
                        a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, Gz);
                        return;
                    }
                    if (a.this.aDh == null) {
                        a.this.aDh = Gz;
                        a.this.nZf.setAlaLiveShowData(a.this.aDh);
                    } else if (a.this.aDh.mLiveInfo != null && Gz.mLiveInfo != null && a.this.aDh.mLiveInfo.live_id != Gz.mLiveInfo.live_id) {
                        a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, a.this.aDh);
                        return;
                    }
                    if (a.this.aDh.mLiveInfo != null && Gz.mLiveInfo != null && a.this.aDh.mLiveInfo.user_id == Gz.mLiveInfo.user_id) {
                        if (a.this.aDh.mLiveInfo.mLiveCloseData != null && Gz.mLiveInfo.mLiveCloseData == null) {
                            Gz.mLiveInfo.mLiveCloseData = a.this.aDh.mLiveInfo.mLiveCloseData;
                        }
                        if (a.this.aDh.mLiveInfo.mAlaLiveSwitchData != null && Gz.mLiveInfo.mAlaLiveSwitchData == null) {
                            Gz.mLiveInfo.mAlaLiveSwitchData = a.this.aDh.mLiveInfo.mAlaLiveSwitchData;
                        }
                    }
                    a.this.aDh.mLiveInfo = Gz.mLiveInfo;
                    a.this.aDh.aHk = Gz.aHk;
                    if (a.this.aDh.aHZ != null && Gz.aHZ != null && !TextUtils.equals(a.this.aDh.aHZ.bg_cover, Gz.aHZ.bg_cover)) {
                        a.this.nZh = true;
                    } else {
                        a.this.nZh = false;
                    }
                    a.this.aDh.aHZ = Gz.aHZ;
                    a.this.aDh.aIa = Gz.aIa;
                    a.this.aDh.aHl = Gz.aHl;
                    a.this.aDh.aHp = Gz.aHp;
                    a.this.aDh.aHQ = Gz.aHQ;
                    a.this.aDh.aHO = Gz.aHO;
                    a.this.aDh.aHL = Gz.aHL;
                    a.this.aDh.aHX = Gz.aHX;
                    a.this.aDh.aHY = Gz.aHY;
                    a.this.aDh.aIe = Gz.aIe;
                    if (Gz.aHT != null && Gz.aHT.aMd != null && !Gz.aHT.aMd.isEmpty()) {
                        a.this.aDh.aHT = Gz.aHT;
                    }
                    if (Gz.aHG != null) {
                        if (Gz.aHG.userId != 0) {
                            a.this.aDh.aHG = Gz.aHG;
                            TbadkCoreApplication.getCurrentAccountObj().setNameShow(a.this.aDh.aHG.nickName);
                        } else {
                            if (a.this.aDh.aHG == null) {
                                a.this.aDh.aHG = new AlaLiveUserInfoData();
                            }
                            a.this.aDh.aHG.throneUid = Gz.aHG.throneUid;
                        }
                    }
                    if (Gz.aHK != null) {
                        a.this.aDh.aHK = Gz.aHK;
                    }
                    if (Gz.aHO) {
                        a.this.aDh.aHP = Gz.aHP;
                        if (a.this.nZf != null) {
                            a.this.nZf.Q(Gz.aHP);
                        }
                    }
                    if (!a.this.mIsHost && a.this.aDh.mLiveInfo != null) {
                        int i = a.this.aDh.mLiveInfo.backstage_type;
                        if (a.this.nZf != null) {
                            a.this.nZf.hA(String.valueOf(i));
                        }
                    }
                    if (a.this.nZf != null) {
                        a.this.nZf.setAlaLiveShowData(a.this.aDh);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501033, a.this.aDh));
                    a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, a.this.aDh);
                    if (a.this.aDh != null) {
                        com.baidu.live.im.b.d.Lx().U(a.this.aDh.aHP);
                    }
                }
            }
        };
        this.nZm = new HttpMessageListener(1031044) { // from class: com.baidu.tieba.yuyinala.liveroom.i.a.11
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
                    if (list != null && list.size() > 0 && a.this.hoK != null && a.this.hoK.size() > 0) {
                        for (int size = a.this.hoK.size() - 1; size >= 0; size--) {
                            if (((AlaLiveInfoData) a.this.hoK.get(size)).live_id != a.this.aDh.mLiveInfo.live_id && list.contains(Long.valueOf(((AlaLiveInfoData) a.this.hoK.get(size)).getLiveID()))) {
                                a.this.hoK.remove(size);
                            }
                        }
                    }
                    if (a.this.aDh != null) {
                        a.this.h(a.this.aDh.mLiveInfo);
                    }
                    a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 4, Long.valueOf(j2));
                }
            }
        };
        this.hpp = new HttpMessageListener(1031062) { // from class: com.baidu.tieba.yuyinala.liveroom.i.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getOrginalMessage() != null && (httpResponsedMessage.getOrginalMessage().getExtra() instanceof com.baidu.live.o.b)) {
                    com.baidu.live.o.b bVar = (com.baidu.live.o.b) httpResponsedMessage.getOrginalMessage().getExtra();
                    if (bVar.boh != null) {
                        if (httpResponsedMessage.getError() == 0) {
                            bVar.boh.hI(bVar.contentType);
                        } else {
                            bVar.boh.d(bVar.contentType, httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                        }
                    }
                }
            }
        };
        this.hpr = new HttpMessageListener(1031037) { // from class: com.baidu.tieba.yuyinala.liveroom.i.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                c cVar;
                if (httpResponsedMessage != null && httpResponsedMessage.getError() == 0) {
                    if (!(httpResponsedMessage instanceof AlaLiveRecommondHttpResponseMessage)) {
                        cVar = null;
                    } else {
                        cVar = ((AlaLiveRecommondHttpResponseMessage) httpResponsedMessage).dYj();
                    }
                    if (cVar != null && !ListUtils.isEmpty(cVar.aHz)) {
                        a.this.hoL = cVar.pn + 1;
                        b bVar = cVar.aHz.get(cVar.aHz.size() - 1);
                        if (bVar != null) {
                            a.this.mLastLiveId = bVar.mLiveInfo.live_id;
                        }
                        a.this.a(cVar);
                        if (a.this.aDh != null) {
                            a.this.h(a.this.aDh.mLiveInfo);
                        }
                        a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 5, cVar);
                    }
                }
            }
        };
        this.mPageContext = bdPageContext;
        this.nZf = new q(bdPageContext, false, this);
        this.hoK = new ArrayList();
        this.hoW = new HashSet();
        initTasks();
        registerListener(this.nZl);
        this.hoE = BdUniqueId.gen();
        registerListener(this.nZm);
        registerListener(this.hpp);
    }

    private void initTasks() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031037, TbConfig.SERVER_ADDRESS + "ala/audio/recommend/getSwitchLives");
        tbHttpMessageTask.setResponsedClass(AlaLiveRecommondHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.hpr.setTag(this.hoE);
        registerListener(this.hpr);
        TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(1031042, TbConfig.SERVER_ADDRESS + "ala/audio/live/getAudienceInfo");
        tbHttpMessageTask2.setIsNeedLogin(false);
        tbHttpMessageTask2.setIsNeedTbs(true);
        tbHttpMessageTask2.setRetry(1);
        tbHttpMessageTask2.setResponsedClass(AlaGetAudienceHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask2);
        registerListener(this.hpj);
        TbHttpMessageTask tbHttpMessageTask3 = new TbHttpMessageTask(1031023, TbConfig.SERVER_ADDRESS + "ala/audio/enterLive");
        tbHttpMessageTask3.setIsNeedLogin(true);
        tbHttpMessageTask3.setIsNeedTbs(true);
        tbHttpMessageTask3.setIsNeedAddCommenParam(true);
        tbHttpMessageTask3.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask3.setResponsedClass(AlaEnterLiveHttpResonseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask3);
        registerListener(this.nZk);
        TbHttpMessageTask tbHttpMessageTask4 = new TbHttpMessageTask(1031084, TbConfig.SERVER_ADDRESS + "/ala/audio/link/online");
        tbHttpMessageTask4.setIsNeedLogin(true);
        tbHttpMessageTask4.setIsNeedTbs(true);
        tbHttpMessageTask4.setIsNeedAddCommenParam(true);
        tbHttpMessageTask4.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask4.setResponsedClass(GetWheatListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask4);
        registerListener(this.nZj);
        com.baidu.live.tieba.f.a.a.a(1031048, "ala/audio/exitLive", AlaQuitLiveHttpResponseMessage.class, false, true, true, true);
        registerListener(this.nZi);
        com.baidu.live.tieba.f.a.a.a(1021121, "ala/sdk/v1/open/getUserLiveMarkInfo", AlaUserLiveMarkInfoResponseMessage.class, true, true, true, true);
        registerListener(this.hpk);
        TbHttpMessageTask tbHttpMessageTask5 = new TbHttpMessageTask(1031071, TbConfig.SERVER_ADDRESS + "ala/UGC/getUGCAnchorInfo");
        tbHttpMessageTask5.setIsNeedLogin(false);
        tbHttpMessageTask5.setIsNeedTbs(true);
        tbHttpMessageTask5.setResponsedClass(MasterIdentityResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask5);
        registerListener(this.hpf);
    }

    public void cfs() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913043, new CustomMessageTask.CustomRunnable<ImSendMsgData>() { // from class: com.baidu.tieba.yuyinala.liveroom.i.a.1
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<ImSendMsgData> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    a.this.c(customMessage.getData());
                    return null;
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void cft() {
        MessageManager.getInstance().unRegisterTask(2913043);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, String str, int i2, Object obj) {
        if (this.nYY != null) {
            this.nYY.a(i, str, i2, obj);
        }
    }

    public void hi(long j) {
        com.baidu.tieba.yuyinala.liveroom.messages.b bVar = new com.baidu.tieba.yuyinala.liveroom.messages.b();
        bVar.setLiveId(j);
        bVar.setParams();
        sendMessage(bVar);
    }

    public void a(long j, String str, long j2) {
        e eVar = new e();
        eVar.setLiveId(j);
        eVar.setFrom(str);
        eVar.aB(j2);
        eVar.setParams();
        sendMessage(eVar);
    }

    public void a(long j, String str, long j2, long j3) {
        e eVar = new e();
        eVar.setLiveId(j);
        eVar.setFrom(str);
        eVar.aB(j2);
        eVar.as(j3);
        eVar.setParams();
        sendMessage(eVar);
    }

    public void cfE() {
        if (TbadkCoreApplication.isLogin()) {
            HttpMessage httpMessage = new HttpMessage(1021121);
            httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccount());
            sendMessage(httpMessage);
        }
    }

    public w Gz() {
        return this.aDh;
    }

    public void setLiveShowData(w wVar) {
        this.aDh = wVar;
    }

    public List<AlaLiveInfoData> cfG() {
        return this.hoK;
    }

    public com.baidu.live.data.q bQJ() {
        return this.gwn;
    }

    public void cB(List<Long> list) {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
            com.baidu.tieba.yuyinala.liveroom.messages.c cVar = new com.baidu.tieba.yuyinala.liveroom.messages.c();
            if (this.aDh != null && this.aDh.mLiveInfo != null) {
                cVar.setAudienceCount(this.aDh.mLiveInfo.audience_count);
            }
            cVar.setListIds(list);
            cVar.setParams();
            sendMessage(cVar);
        }
    }

    public void cfH() {
        ArrayList arrayList = new ArrayList();
        for (AlaLiveInfoData alaLiveInfoData : this.hoK) {
            if (alaLiveInfoData != null) {
                arrayList.add(Long.valueOf(alaLiveInfoData.live_id));
            }
        }
        cB(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c cVar) {
        if (cVar != null) {
            if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isYinbo()) {
                if (this.hoK.size() == 1 && this.hoK.get(0).live_id == this.aDh.mLiveInfo.live_id) {
                    if (c(cVar) != null) {
                        this.hoK.clear();
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
        for (b bVar : cVar.aHz) {
            if (bVar != null && bVar.mLiveInfo != null) {
                for (AlaLiveInfoData alaLiveInfoData : this.hoK) {
                    if (alaLiveInfoData == null || alaLiveInfoData.live_id == bVar.mLiveInfo.live_id) {
                        z = false;
                        break;
                    }
                    while (r4.hasNext()) {
                    }
                }
                z = true;
                if (z) {
                    this.hoK.add(bVar.mLiveInfo);
                }
            }
        }
        if (this.hoK.size() >= 200) {
            ArrayList arrayList = new ArrayList();
            for (int size = this.hoK.size() - 200; size < this.hoK.size(); size++) {
                arrayList.add(this.hoK.get(size));
            }
            if (!ListUtils.isEmpty(arrayList)) {
                this.hoK.clear();
                this.hoK.addAll(arrayList);
                arrayList.clear();
            }
        }
    }

    private AlaLiveInfoData c(c cVar) {
        if (ListUtils.isEmpty(cVar.aHz)) {
            return null;
        }
        for (b bVar : cVar.aHz) {
            if (bVar != null && bVar.mLiveInfo != null && bVar.mLiveInfo.live_id == this.aDh.mLiveInfo.live_id) {
                return bVar.mLiveInfo;
            }
        }
        return null;
    }

    public ArrayList<AlaLiveInfoData> cfI() {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        if (ListUtils.isEmpty(this.hoK)) {
            return null;
        }
        if (this.hoW.isEmpty()) {
            arrayList.addAll(this.hoK);
        } else {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.hoK.size()) {
                    break;
                }
                if ((this.aDh == null || this.aDh.mLiveInfo == null || this.aDh.mLiveInfo.live_id != this.hoK.get(i2).live_id) && !this.hoW.contains(Long.valueOf(this.hoK.get(i2).live_id))) {
                    arrayList.add(this.hoK.get(i2));
                }
                i = i2 + 1;
            }
        }
        return arrayList;
    }

    public void g(AlaLiveInfoData alaLiveInfoData) {
        if (alaLiveInfoData != null) {
            this.hoW.add(Long.valueOf(alaLiveInfoData.getLiveID()));
            if (this.hoW.size() >= this.hoK.size() - 4) {
                nG(false);
            }
        }
    }

    public void wD(int i) {
        this.hoR = i;
    }

    public void nG(boolean z) {
        nH(z);
    }

    private void nH(boolean z) {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.hoZ >= 1800000) {
                this.hoY = currentTimeMillis;
                this.hpa = true;
            }
            if (this.hpa) {
                HttpMessage httpMessage = new HttpMessage(1031037);
                httpMessage.addParam(Config.PACKAGE_NAME, z ? 0 : this.hoL);
                httpMessage.addParam("ps", 20);
                httpMessage.addParam("scr_w", BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst()));
                httpMessage.addParam("scr_h", BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst()));
                httpMessage.addParam("q_type", 0);
                httpMessage.addParam("scr_dip", String.valueOf(BdUtilHelper.getEquipmentDensity(TbadkCoreApplication.getInst())));
                httpMessage.addParam("forum_id", "");
                httpMessage.addParam("entry_name", "");
                httpMessage.addParam("live_id", this.mLastLiveId);
                httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccountId());
                httpMessage.addParam("slide_session_id", this.hoY);
                httpMessage.setTag(this.hoE);
                sendMessage(httpMessage);
                this.hoZ = currentTimeMillis;
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
        aVar.Av(str);
        aVar.setLiveId(j);
        aVar.setParams();
        sendMessage(aVar);
        cfT();
    }

    public void Vc(String str) {
        sendMessage(new l(str));
    }

    public void ar(String str, String str2, String str3) {
        Address address = BdLocationMananger.getInstance().getAddress(false);
        com.baidu.tieba.yuyinala.liveroom.messages.a aVar = new com.baidu.tieba.yuyinala.liveroom.messages.a();
        if (address != null) {
            aVar.b(address.getLongitude(), address.getLatitude());
        }
        aVar.setForumName(str3);
        aVar.Av(str2);
        aVar.setUk(str);
        aVar.setParams();
        sendMessage(aVar);
        cfT();
    }

    public void HO(String str) {
        Address address = BdLocationMananger.getInstance().getAddress(false);
        com.baidu.tieba.yuyinala.liveroom.messages.a aVar = new com.baidu.tieba.yuyinala.liveroom.messages.a();
        if (address != null) {
            aVar.b(address.getLongitude(), address.getLatitude());
        }
        aVar.setRoomId(str);
        aVar.setParams();
        sendMessage(aVar);
        cfT();
    }

    public void eZ(long j) {
        this.nZf.Cd();
        this.hoS = null;
        com.baidu.tieba.yuyinala.liveroom.messages.d dVar = new com.baidu.tieba.yuyinala.liveroom.messages.d();
        dVar.setLiveId(j);
        dVar.setParams();
        dVar.setTag(BdUniqueId.gen());
        sendMessage(dVar);
    }

    public void b(AlaLiveInfoCoreData alaLiveInfoCoreData) {
        if (this.aDh == null) {
            this.aDh = new w(alaLiveInfoCoreData);
            this.aDh.br(true);
            this.nZf.setAlaLiveShowData(this.aDh);
        }
        this.mLastLiveId = this.aDh.mLiveInfo.live_id;
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
        this.hoF.removeCallbacksAndMessages(null);
        cancelLoadData();
        MessageManager.getInstance().unRegisterListener(this.hpr);
        MessageManager.getInstance().removeMessageRule(this.hoT);
        MessageManager.getInstance().unRegisterListener(this.unique_id);
        MessageManager.getInstance().unRegisterTask(1021163);
        MessageManager.getInstance().removeMessage(1031062, getUniqueId());
        this.nZf.Cd();
        this.nZg = null;
        this.mPageContext = null;
    }

    public void wE(int i) {
        this.hoM = i;
        if (this.hoK.size() == 0) {
            this.hoM = 0;
        } else if (this.hoM < 0) {
            this.hoM = this.hoK.size() + this.hoM;
        } else {
            this.hoM %= this.hoK.size();
        }
    }

    public void h(AlaLiveInfoData alaLiveInfoData) {
        if (alaLiveInfoData != null && this.hoK.size() != 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.hoK.size()) {
                    if (this.hoK.get(i2).live_id != alaLiveInfoData.live_id) {
                        i = i2 + 1;
                    } else {
                        this.hoM = i2;
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public boolean cfL() {
        long j;
        if (this.aDh == null || this.aDh.mLiveInfo == null || this.hoK.size() <= 0) {
            return true;
        }
        AlaLiveInfoData alaLiveInfoData = this.hoK.get(0);
        if (alaLiveInfoData == null) {
            j = 0;
        } else {
            j = alaLiveInfoData.live_id;
        }
        return j == this.aDh.mLiveInfo.live_id;
    }

    public boolean cfM() {
        long j;
        if (this.aDh == null || this.aDh.mLiveInfo == null || this.hoK.size() <= 0) {
            return true;
        }
        AlaLiveInfoData alaLiveInfoData = this.hoK.get(this.hoK.size() - 1);
        if (alaLiveInfoData == null) {
            j = 0;
        } else {
            j = alaLiveInfoData.live_id;
        }
        return j == this.aDh.mLiveInfo.live_id;
    }

    public int cfN() {
        return this.hoM;
    }

    public AlaLiveInfoData cfQ() {
        if (this.hoM >= this.hoK.size()) {
            this.hoM = this.hoK.size() - 1;
        }
        if (this.hoM < 0) {
            this.hoM = 0;
        }
        if (this.hoK.size() <= this.hoM) {
            if (this.aDh != null) {
                return this.aDh.mLiveInfo;
            }
            return null;
        }
        return this.hoK.get(this.hoM);
    }

    public void a(InterfaceC0909a interfaceC0909a) {
        this.nYY = interfaceC0909a;
    }

    @Override // com.baidu.live.im.q.a
    public void d(List<com.baidu.live.im.data.a> list, boolean z) {
        if (this.nZg != null) {
            this.nZg.d(list, z);
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913038, list));
        }
    }

    @Override // com.baidu.live.im.q.a
    public void t(com.baidu.live.im.data.a aVar) {
        if (this.aDh != null && this.aDh.mLiveInfo.live_type == 1) {
            I(aVar);
        }
        if (this.nZg != null) {
            this.nZg.t(aVar);
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913037, aVar));
        }
    }

    public void I(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        try {
            if (aVar.getObjContent() instanceof JSONObject) {
                jSONObject = (JSONObject) aVar.getObjContent();
            } else {
                jSONObject = new JSONObject(aVar.getContent());
            }
        } catch (JSONException e) {
            jSONObject = null;
        }
        if ((aVar.getMsgType() == 12 || aVar.getMsgType() == 13) && jSONObject != null && "ss_hot_live".equals(jSONObject.optString("content_type")) && !this.mIsHost) {
            nG(true);
        }
    }

    @Override // com.baidu.live.im.q.a
    public void KC() {
        if (this.nZg != null) {
            this.nZg.KC();
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913044));
        }
    }

    public void c(ImSendMsgData imSendMsgData) {
        AlaLiveUserInfoData alaLiveUserInfoData;
        if (this.aDh != null) {
            if (this.mIsHost) {
                alaLiveUserInfoData = this.aDh.aHk;
            } else {
                alaLiveUserInfoData = this.aDh.aHG;
            }
            if (alaLiveUserInfoData != null) {
                String[] strArr = this.aDh.mLiveInfo.imEffect;
                String[] strArr2 = null;
                if (strArr != null) {
                    strArr2 = new String[strArr.length];
                    System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
                }
                if (!TbadkCoreApplication.getInst().isMobileBaidu() && this.aDh != null && this.aDh.aHG != null && this.aDh.mLiveInfo != null) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    String str = this.aDh.aHG.throneUid;
                    if (!TextUtils.isEmpty(currentAccount) && !TextUtils.isEmpty(str) && currentAccount.equals(str)) {
                        if (strArr2 == null || strArr2.length != 2) {
                            strArr2 = new String[2];
                            strArr2[1] = "";
                        }
                        strArr2[0] = "guard_seat_effect";
                    }
                }
                this.nZf.a(imSendMsgData, alaLiveUserInfoData.isOfficial == 1, alaLiveUserInfoData.isAdmin == 1, alaLiveUserInfoData.levelId, this.otherParams, strArr2);
            }
        }
    }

    public void cfR() {
        this.nZf.e(String.valueOf(this.aDh.mLiveInfo.getGroupID()), String.valueOf(this.aDh.mLiveInfo.getLastMsgID()), String.valueOf(this.aDh.mLiveInfo.getUserID()), String.valueOf(this.aDh.mLiveInfo.getLiveID()), this.aDh.mLiveInfo.appId);
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    private void cfT() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaEnterLiveHttpResonseMessage alaEnterLiveHttpResonseMessage) {
    }

    public String cfU() {
        return this.hoS;
    }

    public void Hm(String str) {
        this.hoS = str;
    }
}

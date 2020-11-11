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
    private w aES;
    private com.baidu.live.data.q gwG;
    private BdUniqueId hoX;
    private Handler hoY;
    private HttpMessageListener hpC;
    private HttpMessageListener hpD;
    private HttpMessageListener hpI;
    private HttpMessageListener hpK;
    private List<AlaLiveInfoData> hpd;
    private int hpe;
    private int hpf;
    private int hpj;
    private int hpk;
    private String hpl;
    private com.baidu.live.y.a hpm;
    private Set<Long> hpp;
    private long hpr;
    private long hps;
    private boolean hpt;
    private HttpMessageListener hpy;
    private boolean mIsHost;
    private long mLastLiveId;
    private BdPageContext<?> mPageContext;
    private final q nXC;
    private q.a nXD;
    public boolean nXE;
    private HttpMessageListener nXF;
    private HttpMessageListener nXG;
    private HttpMessageListener nXH;
    private HttpMessageListener nXI;
    private HttpMessageListener nXJ;
    private InterfaceC0906a nXv;
    private String otherParams;

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0906a {
        void a(int i, String str, int i2, Object obj);
    }

    public a(BdPageContext<?> bdPageContext) {
        super(bdPageContext);
        this.hoY = new Handler();
        this.hpe = 0;
        this.hpf = 0;
        this.hpj = -1;
        this.hpk = 0;
        this.hpm = new com.baidu.live.y.a(0);
        this.otherParams = "";
        this.hpr = System.currentTimeMillis();
        this.hpt = true;
        this.hps = 0L;
        this.nXE = false;
        this.hpy = new HttpMessageListener(1031071) { // from class: com.baidu.tieba.yuyinala.liveroom.i.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                String cfQ;
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof MasterIdentityResponseMessage)) {
                    MasterIdentityResponseMessage masterIdentityResponseMessage = (MasterIdentityResponseMessage) httpResponsedMessage;
                    if ((masterIdentityResponseMessage.cfO() == 1 || masterIdentityResponseMessage.cfP() == 1) && !TextUtils.isEmpty(masterIdentityResponseMessage.cfQ())) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("text", masterIdentityResponseMessage.cfQ());
                            jSONObject.put("content_type", "custom_master_identity");
                            cfQ = jSONObject.toString();
                        } catch (JSONException e) {
                            cfQ = masterIdentityResponseMessage.cfQ();
                            e.printStackTrace();
                        }
                        a.this.nXC.a(27, cfQ, (com.baidu.live.data.a) null);
                    }
                }
            }
        };
        this.nXF = new HttpMessageListener(1031048) { // from class: com.baidu.tieba.yuyinala.liveroom.i.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            }
        };
        this.nXG = new HttpMessageListener(1031084) { // from class: com.baidu.tieba.yuyinala.liveroom.i.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                AlaWheatInfoDataWrapper alaWheatInfoDataWrapper;
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetWheatListHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == a.this.unique_id && (alaWheatInfoDataWrapper = ((GetWheatListHttpResponseMessage) httpResponsedMessage).aJP) != null) {
                    a.this.aES.aJP = alaWheatInfoDataWrapper;
                    if (alaWheatInfoDataWrapper.getRoomMode() == 1) {
                        a.this.aES.aJL = new ct();
                        a.this.aES.aJL.mStep = alaWheatInfoDataWrapper.getActivityStage();
                    }
                    a.this.aES.aKb = true;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501033, a.this.aES));
                    a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, a.this.aES);
                }
            }
        };
        this.nXH = new HttpMessageListener(1031023) { // from class: com.baidu.tieba.yuyinala.liveroom.i.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                long j = 0;
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaEnterLiveHttpResonseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == a.this.unique_id) {
                    AlaEnterLiveHttpResonseMessage alaEnterLiveHttpResonseMessage = (AlaEnterLiveHttpResonseMessage) httpResponsedMessage;
                    a.this.aES = alaEnterLiveHttpResonseMessage.Hi();
                    a.this.aES.aKc = true;
                    a.this.nXC.setAlaLiveShowData(a.this.aES);
                    if (a.this.aES != null && a.this.aES.mLiveInfo != null) {
                        if (!TbadkCoreApplication.getInst().isOther() && (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isActivityTaskWatchUnabled())) {
                            com.baidu.tieba.yuyinala.liveroom.task.b.dYu().fb(a.this.aES.mLiveInfo.live_id);
                        }
                        LiveTimerManager.getInstance().start(a.this.aES.mLiveInfo.live_id);
                    }
                    if (a.this.aES != null && TbadkCoreApplication.getCurrentAccountInfo() != null) {
                        if (a.this.aES.aJr != null) {
                            if (a.this.aES.aJr.levelId > 0) {
                                TbadkCoreApplication.getCurrentAccountInfo().setLiveLevel(a.this.aES.aJr.levelId);
                            }
                            TbadkCoreApplication.getCurrentAccountObj().setNameShow(a.this.aES.aJr.nickName);
                            if (!TextUtils.isEmpty(a.this.aES.aJr.portrait)) {
                                TbadkCoreApplication.getCurrentAccountObj().setPortrait(a.this.aES.aJr.portrait);
                            }
                        }
                        if (a.this.aES.mLiveSdkInfo != null) {
                            TbadkCoreApplication.getInst().setTbs(a.this.aES.mLiveSdkInfo.tbs);
                            com.baidu.live.d.AZ().putString("ala_account_user_tbs", a.this.aES.mLiveSdkInfo.tbs);
                        }
                    }
                    if (a.this.aES != null) {
                        if (a.this.hpd.size() <= 0) {
                            a.this.hpd.add(a.this.aES.mLiveInfo);
                            a.this.hpp.add(Long.valueOf(a.this.aES.mLiveInfo.getLiveID()));
                        }
                        a.this.h(a.this.aES.mLiveInfo);
                        if (a.this.nXC != null) {
                            a.this.nXC.Q(a.this.aES.aJA);
                        }
                    }
                    if (a.this.aES != null && a.this.aES.aIX != null) {
                        a.this.hpj = a.this.aES.aIX.follow_status;
                    }
                    a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 3, a.this.aES);
                    if (a.this.aES != null && a.this.aES.mLiveInfo != null) {
                        a.this.cgy();
                    }
                    if (a.this.aES != null) {
                        a.this.aES.isHost = false;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913081, a.this.aES));
                        com.baidu.live.im.b.d.Mg().U(a.this.aES.aJA);
                    }
                    a.this.a(alaEnterLiveHttpResonseMessage);
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        if (a.this.aES != null && a.this.aES.mLiveInfo != null) {
                            long j2 = a.this.aES.mLiveInfo.live_id;
                            long j3 = a.this.aES.mLiveInfo.room_id;
                            String str = a.this.aES.mLiveInfo.feed_id;
                            String str2 = "";
                            if (a.this.aES.aIV != null) {
                                long j4 = a.this.aES.aIV.userId;
                                str2 = a.this.aES.aIV.userName;
                                j = j4;
                            }
                            HKStaticManager.staticStartPlayTime(j2 + "", j3 + "", j + "", str2, System.currentTimeMillis(), str, a.this.otherParams);
                        }
                    } else if ((TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) && a.this.aES != null && a.this.aES.mLiveInfo != null) {
                        long j5 = a.this.aES.mLiveInfo.live_id;
                        long j6 = a.this.aES.mLiveInfo.room_id;
                        String str3 = a.this.aES.mLiveInfo.feed_id;
                        String str4 = "";
                        if (a.this.aES.aIV != null) {
                            j = a.this.aES.aIV.userId;
                            str4 = a.this.aES.aIV.userName;
                        }
                        QMStaticManager.staticStartPlayTime(j5 + "", j6 + "", j + "", str4, System.currentTimeMillis(), str3, a.this.otherParams, a.this.hpf + "");
                    }
                }
            }
        };
        this.hpC = new HttpMessageListener(1031042) { // from class: com.baidu.tieba.yuyinala.liveroom.i.a.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaGetAudienceHttpResponseMessage)) {
                    com.baidu.live.data.q bRq = ((AlaGetAudienceHttpResponseMessage) httpResponsedMessage).bRq();
                    Message<?> message = httpResponsedMessage.getmOrginalMessage();
                    if (message instanceof com.baidu.tieba.yuyinala.liveroom.messages.b) {
                        com.baidu.tieba.yuyinala.liveroom.messages.b bVar = (com.baidu.tieba.yuyinala.liveroom.messages.b) message;
                        if (String.valueOf(bVar.dYj()).equals(a.this.aES.aJK.live_id)) {
                            bRq.liveId = String.valueOf(bVar.dYj());
                        } else {
                            return;
                        }
                    }
                    if (bRq != null) {
                        a.this.gwG = bRq;
                    }
                    if (a.this.aES != null && a.this.aES.aIX != null) {
                        if (a.this.hpj == -1) {
                            a.this.hpj = a.this.aES.aIX.follow_status;
                        }
                        if (a.this.aES.aIX.follow_status != a.this.hpj) {
                            a.this.aES.aIX.follow_status = a.this.hpj;
                        }
                    }
                    a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 2, a.this.gwG);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913016, a.this.gwG));
                }
            }
        };
        this.hpD = new HttpMessageListener(1021121) { // from class: com.baidu.tieba.yuyinala.liveroom.i.a.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaUserLiveMarkInfoResponseMessage) {
                    AlaUserLiveMarkInfoResponseMessage alaUserLiveMarkInfoResponseMessage = (AlaUserLiveMarkInfoResponseMessage) httpResponsedMessage;
                    if (alaUserLiveMarkInfoResponseMessage.getError() == 0) {
                        List<AlaLiveMarkData> cfN = alaUserLiveMarkInfoResponseMessage.cfN();
                        a.this.nXC.Q(cfN);
                        if (a.this.aES != null) {
                            a.this.aES.aJA = cfN;
                            com.baidu.live.im.b.d.Mg().U(a.this.aES.aJA);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913118, a.this.aES));
                        }
                    }
                }
            }
        };
        this.nXI = new HttpMessageListener(1031024) { // from class: com.baidu.tieba.yuyinala.liveroom.i.a.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof YuyinGetLiveInfoHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == a.this.unique_id) {
                    if (httpResponsedMessage.hasError()) {
                        a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, null);
                        return;
                    }
                    w Hi = httpResponsedMessage instanceof YuyinGetLiveInfoHttpResponseMessage ? ((YuyinGetLiveInfoHttpResponseMessage) httpResponsedMessage).Hi() : null;
                    if (Hi == null) {
                        a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, Hi);
                        return;
                    }
                    if (a.this.aES == null) {
                        a.this.aES = Hi;
                        a.this.nXC.setAlaLiveShowData(a.this.aES);
                    } else if (a.this.aES.mLiveInfo != null && Hi.mLiveInfo != null && a.this.aES.mLiveInfo.live_id != Hi.mLiveInfo.live_id) {
                        a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, a.this.aES);
                        return;
                    }
                    if (a.this.aES.mLiveInfo != null && Hi.mLiveInfo != null && a.this.aES.mLiveInfo.user_id == Hi.mLiveInfo.user_id) {
                        if (a.this.aES.mLiveInfo.mLiveCloseData != null && Hi.mLiveInfo.mLiveCloseData == null) {
                            Hi.mLiveInfo.mLiveCloseData = a.this.aES.mLiveInfo.mLiveCloseData;
                        }
                        if (a.this.aES.mLiveInfo.mAlaLiveSwitchData != null && Hi.mLiveInfo.mAlaLiveSwitchData == null) {
                            Hi.mLiveInfo.mAlaLiveSwitchData = a.this.aES.mLiveInfo.mAlaLiveSwitchData;
                        }
                    }
                    a.this.aES.mLiveInfo = Hi.mLiveInfo;
                    a.this.aES.aIV = Hi.aIV;
                    if (a.this.aES.aJK != null && Hi.aJK != null && !TextUtils.equals(a.this.aES.aJK.bg_cover, Hi.aJK.bg_cover)) {
                        a.this.nXE = true;
                    } else {
                        a.this.nXE = false;
                    }
                    a.this.aES.aJK = Hi.aJK;
                    a.this.aES.aJL = Hi.aJL;
                    a.this.aES.aIW = Hi.aIW;
                    a.this.aES.aJa = Hi.aJa;
                    a.this.aES.aJB = Hi.aJB;
                    a.this.aES.aJz = Hi.aJz;
                    a.this.aES.aJw = Hi.aJw;
                    a.this.aES.aJI = Hi.aJI;
                    a.this.aES.aJJ = Hi.aJJ;
                    a.this.aES.aJP = Hi.aJP;
                    if (Hi.aJE != null && Hi.aJE.aNO != null && !Hi.aJE.aNO.isEmpty()) {
                        a.this.aES.aJE = Hi.aJE;
                    }
                    if (Hi.aJr != null) {
                        if (Hi.aJr.userId != 0) {
                            a.this.aES.aJr = Hi.aJr;
                            TbadkCoreApplication.getCurrentAccountObj().setNameShow(a.this.aES.aJr.nickName);
                        } else {
                            if (a.this.aES.aJr == null) {
                                a.this.aES.aJr = new AlaLiveUserInfoData();
                            }
                            a.this.aES.aJr.throneUid = Hi.aJr.throneUid;
                        }
                    }
                    if (Hi.aJv != null) {
                        a.this.aES.aJv = Hi.aJv;
                    }
                    if (Hi.aJz) {
                        a.this.aES.aJA = Hi.aJA;
                        if (a.this.nXC != null) {
                            a.this.nXC.Q(Hi.aJA);
                        }
                    }
                    if (!a.this.mIsHost && a.this.aES.mLiveInfo != null) {
                        int i = a.this.aES.mLiveInfo.backstage_type;
                        if (a.this.nXC != null) {
                            a.this.nXC.hG(String.valueOf(i));
                        }
                    }
                    if (a.this.nXC != null) {
                        a.this.nXC.setAlaLiveShowData(a.this.aES);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501033, a.this.aES));
                    a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, a.this.aES);
                    if (a.this.aES != null) {
                        com.baidu.live.im.b.d.Mg().U(a.this.aES.aJA);
                    }
                }
            }
        };
        this.nXJ = new HttpMessageListener(1031044) { // from class: com.baidu.tieba.yuyinala.liveroom.i.a.11
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
                    if (list != null && list.size() > 0 && a.this.hpd != null && a.this.hpd.size() > 0) {
                        for (int size = a.this.hpd.size() - 1; size >= 0; size--) {
                            if (((AlaLiveInfoData) a.this.hpd.get(size)).live_id != a.this.aES.mLiveInfo.live_id && list.contains(Long.valueOf(((AlaLiveInfoData) a.this.hpd.get(size)).getLiveID()))) {
                                a.this.hpd.remove(size);
                            }
                        }
                    }
                    if (a.this.aES != null) {
                        a.this.h(a.this.aES.mLiveInfo);
                    }
                    a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 4, Long.valueOf(j2));
                }
            }
        };
        this.hpI = new HttpMessageListener(1031062) { // from class: com.baidu.tieba.yuyinala.liveroom.i.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getOrginalMessage() != null && (httpResponsedMessage.getOrginalMessage().getExtra() instanceof com.baidu.live.o.b)) {
                    com.baidu.live.o.b bVar = (com.baidu.live.o.b) httpResponsedMessage.getOrginalMessage().getExtra();
                    if (bVar.bpS != null) {
                        if (httpResponsedMessage.getError() == 0) {
                            bVar.bpS.hO(bVar.contentType);
                        } else {
                            bVar.bpS.d(bVar.contentType, httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                        }
                    }
                }
            }
        };
        this.hpK = new HttpMessageListener(1031037) { // from class: com.baidu.tieba.yuyinala.liveroom.i.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                c cVar;
                if (httpResponsedMessage != null && httpResponsedMessage.getError() == 0) {
                    if (!(httpResponsedMessage instanceof AlaLiveRecommondHttpResponseMessage)) {
                        cVar = null;
                    } else {
                        cVar = ((AlaLiveRecommondHttpResponseMessage) httpResponsedMessage).dYk();
                    }
                    if (cVar != null && !ListUtils.isEmpty(cVar.aJk)) {
                        a.this.hpe = cVar.pn + 1;
                        b bVar = cVar.aJk.get(cVar.aJk.size() - 1);
                        if (bVar != null) {
                            a.this.mLastLiveId = bVar.mLiveInfo.live_id;
                        }
                        a.this.a(cVar);
                        if (a.this.aES != null) {
                            a.this.h(a.this.aES.mLiveInfo);
                        }
                        a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 5, cVar);
                    }
                }
            }
        };
        this.mPageContext = bdPageContext;
        this.nXC = new q(bdPageContext, false, this);
        this.hpd = new ArrayList();
        this.hpp = new HashSet();
        initTasks();
        registerListener(this.nXI);
        this.hoX = BdUniqueId.gen();
        registerListener(this.nXJ);
        registerListener(this.hpI);
    }

    private void initTasks() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031037, TbConfig.SERVER_ADDRESS + "ala/audio/recommend/getSwitchLives");
        tbHttpMessageTask.setResponsedClass(AlaLiveRecommondHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.hpK.setTag(this.hoX);
        registerListener(this.hpK);
        TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(1031042, TbConfig.SERVER_ADDRESS + "ala/audio/live/getAudienceInfo");
        tbHttpMessageTask2.setIsNeedLogin(false);
        tbHttpMessageTask2.setIsNeedTbs(true);
        tbHttpMessageTask2.setRetry(1);
        tbHttpMessageTask2.setResponsedClass(AlaGetAudienceHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask2);
        registerListener(this.hpC);
        TbHttpMessageTask tbHttpMessageTask3 = new TbHttpMessageTask(1031023, TbConfig.SERVER_ADDRESS + "ala/audio/enterLive");
        tbHttpMessageTask3.setIsNeedLogin(true);
        tbHttpMessageTask3.setIsNeedTbs(true);
        tbHttpMessageTask3.setIsNeedAddCommenParam(true);
        tbHttpMessageTask3.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask3.setResponsedClass(AlaEnterLiveHttpResonseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask3);
        registerListener(this.nXH);
        TbHttpMessageTask tbHttpMessageTask4 = new TbHttpMessageTask(1031084, TbConfig.SERVER_ADDRESS + "/ala/audio/link/online");
        tbHttpMessageTask4.setIsNeedLogin(true);
        tbHttpMessageTask4.setIsNeedTbs(true);
        tbHttpMessageTask4.setIsNeedAddCommenParam(true);
        tbHttpMessageTask4.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask4.setResponsedClass(GetWheatListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask4);
        registerListener(this.nXG);
        com.baidu.live.tieba.f.a.a.a(1031048, "ala/audio/exitLive", AlaQuitLiveHttpResponseMessage.class, false, true, true, true);
        registerListener(this.nXF);
        com.baidu.live.tieba.f.a.a.a(1021121, "ala/sdk/v1/open/getUserLiveMarkInfo", AlaUserLiveMarkInfoResponseMessage.class, true, true, true, true);
        registerListener(this.hpD);
        TbHttpMessageTask tbHttpMessageTask5 = new TbHttpMessageTask(1031071, TbConfig.SERVER_ADDRESS + "ala/UGC/getUGCAnchorInfo");
        tbHttpMessageTask5.setIsNeedLogin(false);
        tbHttpMessageTask5.setIsNeedTbs(true);
        tbHttpMessageTask5.setResponsedClass(MasterIdentityResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask5);
        registerListener(this.hpy);
    }

    public void cfZ() {
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

    public void cga() {
        MessageManager.getInstance().unRegisterTask(2913043);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, String str, int i2, Object obj) {
        if (this.nXv != null) {
            this.nXv.a(i, str, i2, obj);
        }
    }

    public void hf(long j) {
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

    public void cgl() {
        if (TbadkCoreApplication.isLogin()) {
            HttpMessage httpMessage = new HttpMessage(1021121);
            httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccount());
            sendMessage(httpMessage);
        }
    }

    public w Hi() {
        return this.aES;
    }

    public void setLiveShowData(w wVar) {
        this.aES = wVar;
    }

    public List<AlaLiveInfoData> cgn() {
        return this.hpd;
    }

    public com.baidu.live.data.q bRq() {
        return this.gwG;
    }

    public void cB(List<Long> list) {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
            com.baidu.tieba.yuyinala.liveroom.messages.c cVar = new com.baidu.tieba.yuyinala.liveroom.messages.c();
            if (this.aES != null && this.aES.mLiveInfo != null) {
                cVar.setAudienceCount(this.aES.mLiveInfo.audience_count);
            }
            cVar.setListIds(list);
            cVar.setParams();
            sendMessage(cVar);
        }
    }

    public void cgo() {
        ArrayList arrayList = new ArrayList();
        for (AlaLiveInfoData alaLiveInfoData : this.hpd) {
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
                if (this.hpd.size() == 1 && this.hpd.get(0).live_id == this.aES.mLiveInfo.live_id) {
                    if (c(cVar) != null) {
                        this.hpd.clear();
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
        for (b bVar : cVar.aJk) {
            if (bVar != null && bVar.mLiveInfo != null) {
                for (AlaLiveInfoData alaLiveInfoData : this.hpd) {
                    if (alaLiveInfoData == null || alaLiveInfoData.live_id == bVar.mLiveInfo.live_id) {
                        z = false;
                        break;
                    }
                    while (r4.hasNext()) {
                    }
                }
                z = true;
                if (z) {
                    this.hpd.add(bVar.mLiveInfo);
                }
            }
        }
        if (this.hpd.size() >= 200) {
            ArrayList arrayList = new ArrayList();
            for (int size = this.hpd.size() - 200; size < this.hpd.size(); size++) {
                arrayList.add(this.hpd.get(size));
            }
            if (!ListUtils.isEmpty(arrayList)) {
                this.hpd.clear();
                this.hpd.addAll(arrayList);
                arrayList.clear();
            }
        }
    }

    private AlaLiveInfoData c(c cVar) {
        if (ListUtils.isEmpty(cVar.aJk)) {
            return null;
        }
        for (b bVar : cVar.aJk) {
            if (bVar != null && bVar.mLiveInfo != null && bVar.mLiveInfo.live_id == this.aES.mLiveInfo.live_id) {
                return bVar.mLiveInfo;
            }
        }
        return null;
    }

    public ArrayList<AlaLiveInfoData> cgp() {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        if (ListUtils.isEmpty(this.hpd)) {
            return null;
        }
        if (this.hpp.isEmpty()) {
            arrayList.addAll(this.hpd);
        } else {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.hpd.size()) {
                    break;
                }
                if ((this.aES == null || this.aES.mLiveInfo == null || this.aES.mLiveInfo.live_id != this.hpd.get(i2).live_id) && !this.hpp.contains(Long.valueOf(this.hpd.get(i2).live_id))) {
                    arrayList.add(this.hpd.get(i2));
                }
                i = i2 + 1;
            }
        }
        return arrayList;
    }

    public void g(AlaLiveInfoData alaLiveInfoData) {
        if (alaLiveInfoData != null) {
            this.hpp.add(Long.valueOf(alaLiveInfoData.getLiveID()));
            if (this.hpp.size() >= this.hpd.size() - 4) {
                nF(false);
            }
        }
    }

    public void wf(int i) {
        this.hpk = i;
    }

    public void nF(boolean z) {
        nG(z);
    }

    private void nG(boolean z) {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.hps >= 1800000) {
                this.hpr = currentTimeMillis;
                this.hpt = true;
            }
            if (this.hpt) {
                HttpMessage httpMessage = new HttpMessage(1031037);
                httpMessage.addParam(Config.PACKAGE_NAME, z ? 0 : this.hpe);
                httpMessage.addParam("ps", 20);
                httpMessage.addParam("scr_w", BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst()));
                httpMessage.addParam("scr_h", BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst()));
                httpMessage.addParam("q_type", 0);
                httpMessage.addParam("scr_dip", String.valueOf(BdUtilHelper.getEquipmentDensity(TbadkCoreApplication.getInst())));
                httpMessage.addParam("forum_id", "");
                httpMessage.addParam("entry_name", "");
                httpMessage.addParam("live_id", this.mLastLiveId);
                httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccountId());
                httpMessage.addParam("slide_session_id", this.hpr);
                httpMessage.setTag(this.hoX);
                sendMessage(httpMessage);
                this.hps = currentTimeMillis;
            }
        }
    }

    public void a(long j, boolean z, String str, String str2) {
        Address address = BdLocationMananger.getInstance().getAddress(false);
        com.baidu.tieba.yuyinala.liveroom.messages.a aVar = new com.baidu.tieba.yuyinala.liveroom.messages.a();
        if (address != null) {
            aVar.c(address.getLongitude(), address.getLatitude());
        }
        aVar.setForumName(str2);
        aVar.Ba(str);
        aVar.setLiveId(j);
        aVar.setParams();
        sendMessage(aVar);
        cgA();
    }

    public void Vr(String str) {
        sendMessage(new l(str));
    }

    public void ar(String str, String str2, String str3) {
        Address address = BdLocationMananger.getInstance().getAddress(false);
        com.baidu.tieba.yuyinala.liveroom.messages.a aVar = new com.baidu.tieba.yuyinala.liveroom.messages.a();
        if (address != null) {
            aVar.c(address.getLongitude(), address.getLatitude());
        }
        aVar.setForumName(str3);
        aVar.Ba(str2);
        aVar.setUk(str);
        aVar.setParams();
        sendMessage(aVar);
        cgA();
    }

    public void In(String str) {
        Address address = BdLocationMananger.getInstance().getAddress(false);
        com.baidu.tieba.yuyinala.liveroom.messages.a aVar = new com.baidu.tieba.yuyinala.liveroom.messages.a();
        if (address != null) {
            aVar.c(address.getLongitude(), address.getLatitude());
        }
        aVar.setRoomId(str);
        aVar.setParams();
        sendMessage(aVar);
        cgA();
    }

    public void eZ(long j) {
        this.nXC.CM();
        this.hpl = null;
        com.baidu.tieba.yuyinala.liveroom.messages.d dVar = new com.baidu.tieba.yuyinala.liveroom.messages.d();
        dVar.setLiveId(j);
        dVar.setParams();
        dVar.setTag(BdUniqueId.gen());
        sendMessage(dVar);
    }

    public void b(AlaLiveInfoCoreData alaLiveInfoCoreData) {
        if (this.aES == null) {
            this.aES = new w(alaLiveInfoCoreData);
            this.aES.bp(true);
            this.nXC.setAlaLiveShowData(this.aES);
        }
        this.mLastLiveId = this.aES.mLiveInfo.live_id;
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
        this.hoY.removeCallbacksAndMessages(null);
        cancelLoadData();
        MessageManager.getInstance().unRegisterListener(this.hpK);
        MessageManager.getInstance().removeMessageRule(this.hpm);
        MessageManager.getInstance().unRegisterListener(this.unique_id);
        MessageManager.getInstance().unRegisterTask(1021163);
        MessageManager.getInstance().removeMessage(1031062, getUniqueId());
        this.nXC.CM();
        this.nXD = null;
        this.mPageContext = null;
    }

    public void wg(int i) {
        this.hpf = i;
        if (this.hpd.size() == 0) {
            this.hpf = 0;
        } else if (this.hpf < 0) {
            this.hpf = this.hpd.size() + this.hpf;
        } else {
            this.hpf %= this.hpd.size();
        }
    }

    public void h(AlaLiveInfoData alaLiveInfoData) {
        if (alaLiveInfoData != null && this.hpd.size() != 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.hpd.size()) {
                    if (this.hpd.get(i2).live_id != alaLiveInfoData.live_id) {
                        i = i2 + 1;
                    } else {
                        this.hpf = i2;
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public boolean cgs() {
        long j;
        if (this.aES == null || this.aES.mLiveInfo == null || this.hpd.size() <= 0) {
            return true;
        }
        AlaLiveInfoData alaLiveInfoData = this.hpd.get(0);
        if (alaLiveInfoData == null) {
            j = 0;
        } else {
            j = alaLiveInfoData.live_id;
        }
        return j == this.aES.mLiveInfo.live_id;
    }

    public boolean cgt() {
        long j;
        if (this.aES == null || this.aES.mLiveInfo == null || this.hpd.size() <= 0) {
            return true;
        }
        AlaLiveInfoData alaLiveInfoData = this.hpd.get(this.hpd.size() - 1);
        if (alaLiveInfoData == null) {
            j = 0;
        } else {
            j = alaLiveInfoData.live_id;
        }
        return j == this.aES.mLiveInfo.live_id;
    }

    public int cgu() {
        return this.hpf;
    }

    public AlaLiveInfoData cgx() {
        if (this.hpf >= this.hpd.size()) {
            this.hpf = this.hpd.size() - 1;
        }
        if (this.hpf < 0) {
            this.hpf = 0;
        }
        if (this.hpd.size() <= this.hpf) {
            if (this.aES != null) {
                return this.aES.mLiveInfo;
            }
            return null;
        }
        return this.hpd.get(this.hpf);
    }

    public void a(InterfaceC0906a interfaceC0906a) {
        this.nXv = interfaceC0906a;
    }

    @Override // com.baidu.live.im.q.a
    public void d(List<com.baidu.live.im.data.a> list, boolean z) {
        if (this.nXD != null) {
            this.nXD.d(list, z);
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913038, list));
        }
    }

    @Override // com.baidu.live.im.q.a
    public void t(com.baidu.live.im.data.a aVar) {
        if (this.aES != null && this.aES.mLiveInfo.live_type == 1) {
            I(aVar);
        }
        if (this.nXD != null) {
            this.nXD.t(aVar);
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
            nF(true);
        }
    }

    @Override // com.baidu.live.im.q.a
    public void Ll() {
        if (this.nXD != null) {
            this.nXD.Ll();
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913044));
        }
    }

    public void c(ImSendMsgData imSendMsgData) {
        AlaLiveUserInfoData alaLiveUserInfoData;
        if (this.aES != null) {
            if (this.mIsHost) {
                alaLiveUserInfoData = this.aES.aIV;
            } else {
                alaLiveUserInfoData = this.aES.aJr;
            }
            if (alaLiveUserInfoData != null) {
                String[] strArr = this.aES.mLiveInfo.imEffect;
                String[] strArr2 = null;
                if (strArr != null) {
                    strArr2 = new String[strArr.length];
                    System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
                }
                if (!TbadkCoreApplication.getInst().isMobileBaidu() && this.aES != null && this.aES.aJr != null && this.aES.mLiveInfo != null) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    String str = this.aES.aJr.throneUid;
                    if (!TextUtils.isEmpty(currentAccount) && !TextUtils.isEmpty(str) && currentAccount.equals(str)) {
                        if (strArr2 == null || strArr2.length != 2) {
                            strArr2 = new String[2];
                            strArr2[1] = "";
                        }
                        strArr2[0] = "guard_seat_effect";
                    }
                }
                this.nXC.a(imSendMsgData, alaLiveUserInfoData.isOfficial == 1, alaLiveUserInfoData.isAdmin == 1, alaLiveUserInfoData.levelId, this.otherParams, strArr2);
            }
        }
    }

    public void cgy() {
        this.nXC.e(String.valueOf(this.aES.mLiveInfo.getGroupID()), String.valueOf(this.aES.mLiveInfo.getLastMsgID()), String.valueOf(this.aES.mLiveInfo.getUserID()), String.valueOf(this.aES.mLiveInfo.getLiveID()), this.aES.mLiveInfo.appId);
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    private void cgA() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaEnterLiveHttpResonseMessage alaEnterLiveHttpResonseMessage) {
    }

    public String cgB() {
        return this.hpl;
    }

    public void HL(String str) {
        this.hpl = str;
    }
}

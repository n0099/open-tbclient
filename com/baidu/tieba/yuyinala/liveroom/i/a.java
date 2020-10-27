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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a extends BdBaseModel implements q.a {
    private w aEc;
    private com.baidu.live.data.q gqS;
    private long hjA;
    private long hjB;
    private boolean hjC;
    private HttpMessageListener hjH;
    private HttpMessageListener hjL;
    private HttpMessageListener hjM;
    private HttpMessageListener hjR;
    private HttpMessageListener hjT;
    private BdUniqueId hjg;
    private Handler hjh;
    private List<AlaLiveInfoData> hjm;
    private int hjn;
    private int hjo;
    private int hjs;
    private int hjt;
    private String hju;
    private com.baidu.live.x.a hjv;
    private Set<Long> hjy;
    private boolean mIsHost;
    private long mLastLiveId;
    private BdPageContext<?> mPageContext;
    private InterfaceC0890a nQm;
    private final q nQt;
    private q.a nQu;
    public boolean nQv;
    private HttpMessageListener nQw;
    private HttpMessageListener nQx;
    private HttpMessageListener nQy;
    private HttpMessageListener nQz;
    private String otherParams;

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0890a {
        void a(int i, String str, int i2, Object obj);
    }

    public a(BdPageContext<?> bdPageContext) {
        super(bdPageContext);
        this.hjh = new Handler();
        this.hjn = 0;
        this.hjo = 0;
        this.hjs = -1;
        this.hjt = 0;
        this.hjv = new com.baidu.live.x.a(0);
        this.otherParams = "";
        this.hjA = System.currentTimeMillis();
        this.hjC = true;
        this.hjB = 0L;
        this.nQv = false;
        this.hjH = new HttpMessageListener(1031071) { // from class: com.baidu.tieba.yuyinala.liveroom.i.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                String cdp;
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof MasterIdentityResponseMessage)) {
                    MasterIdentityResponseMessage masterIdentityResponseMessage = (MasterIdentityResponseMessage) httpResponsedMessage;
                    if ((masterIdentityResponseMessage.cdn() == 1 || masterIdentityResponseMessage.cdo() == 1) && !TextUtils.isEmpty(masterIdentityResponseMessage.cdp())) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("text", masterIdentityResponseMessage.cdp());
                            jSONObject.put("content_type", "custom_master_identity");
                            cdp = jSONObject.toString();
                        } catch (JSONException e) {
                            cdp = masterIdentityResponseMessage.cdp();
                            e.printStackTrace();
                        }
                        a.this.nQt.a(27, cdp, (com.baidu.live.data.a) null);
                    }
                }
            }
        };
        this.nQw = new HttpMessageListener(1031048) { // from class: com.baidu.tieba.yuyinala.liveroom.i.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            }
        };
        this.nQx = new HttpMessageListener(1031023) { // from class: com.baidu.tieba.yuyinala.liveroom.i.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                long j = 0;
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaEnterLiveHttpResonseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == a.this.unique_id) {
                    AlaEnterLiveHttpResonseMessage alaEnterLiveHttpResonseMessage = (AlaEnterLiveHttpResonseMessage) httpResponsedMessage;
                    a.this.aEc = alaEnterLiveHttpResonseMessage.GH();
                    a.this.nQt.setAlaLiveShowData(a.this.aEc);
                    if (a.this.aEc != null && a.this.aEc.mLiveInfo != null) {
                        if (!TbadkCoreApplication.getInst().isOther() && (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isActivityTaskWatchUnabled())) {
                            com.baidu.tieba.yuyinala.liveroom.task.b.dVF().eF(a.this.aEc.mLiveInfo.live_id);
                        }
                        LiveTimerManager.getInstance().start(a.this.aEc.mLiveInfo.live_id);
                    }
                    if (a.this.aEc != null && TbadkCoreApplication.getCurrentAccountInfo() != null) {
                        if (a.this.aEc.aIA != null) {
                            if (a.this.aEc.aIA.levelId > 0) {
                                TbadkCoreApplication.getCurrentAccountInfo().setLiveLevel(a.this.aEc.aIA.levelId);
                            }
                            TbadkCoreApplication.getCurrentAccountObj().setNameShow(a.this.aEc.aIA.nickName);
                            if (!TextUtils.isEmpty(a.this.aEc.aIA.portrait)) {
                                TbadkCoreApplication.getCurrentAccountObj().setPortrait(a.this.aEc.aIA.portrait);
                            }
                        }
                        if (a.this.aEc.mLiveSdkInfo != null) {
                            TbadkCoreApplication.getInst().setTbs(a.this.aEc.mLiveSdkInfo.tbs);
                            com.baidu.live.d.AZ().putString("ala_account_user_tbs", a.this.aEc.mLiveSdkInfo.tbs);
                        }
                    }
                    if (a.this.aEc != null) {
                        if (a.this.hjm.size() <= 0) {
                            a.this.hjm.add(a.this.aEc.mLiveInfo);
                            a.this.hjy.add(Long.valueOf(a.this.aEc.mLiveInfo.getLiveID()));
                        }
                        a.this.h(a.this.aEc.mLiveInfo);
                        if (a.this.nQt != null) {
                            a.this.nQt.Q(a.this.aEc.aIJ);
                        }
                    }
                    if (a.this.aEc != null && a.this.aEc.aIg != null) {
                        a.this.hjs = a.this.aEc.aIg.follow_status;
                    }
                    a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 3, a.this.aEc);
                    if (a.this.aEc != null && a.this.aEc.mLiveInfo != null) {
                        a.this.cdX();
                    }
                    if (a.this.aEc != null) {
                        a.this.aEc.isHost = false;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913081, a.this.aEc));
                        com.baidu.live.im.b.d.LG().U(a.this.aEc.aIJ);
                    }
                    a.this.a(alaEnterLiveHttpResonseMessage);
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        if (a.this.aEc != null && a.this.aEc.mLiveInfo != null) {
                            long j2 = a.this.aEc.mLiveInfo.live_id;
                            long j3 = a.this.aEc.mLiveInfo.room_id;
                            String str = a.this.aEc.mLiveInfo.feed_id;
                            String str2 = "";
                            if (a.this.aEc.aIe != null) {
                                long j4 = a.this.aEc.aIe.userId;
                                str2 = a.this.aEc.aIe.userName;
                                j = j4;
                            }
                            HKStaticManager.staticStartPlayTime(j2 + "", j3 + "", j + "", str2, System.currentTimeMillis(), str, a.this.otherParams);
                        }
                    } else if ((TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) && a.this.aEc != null && a.this.aEc.mLiveInfo != null) {
                        long j5 = a.this.aEc.mLiveInfo.live_id;
                        long j6 = a.this.aEc.mLiveInfo.room_id;
                        String str3 = a.this.aEc.mLiveInfo.feed_id;
                        String str4 = "";
                        if (a.this.aEc.aIe != null) {
                            j = a.this.aEc.aIe.userId;
                            str4 = a.this.aEc.aIe.userName;
                        }
                        QMStaticManager.staticStartPlayTime(j5 + "", j6 + "", j + "", str4, System.currentTimeMillis(), str3, a.this.otherParams, a.this.hjo + "");
                    }
                }
            }
        };
        this.hjL = new HttpMessageListener(1031042) { // from class: com.baidu.tieba.yuyinala.liveroom.i.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaGetAudienceHttpResponseMessage)) {
                    com.baidu.live.data.q bOQ = ((AlaGetAudienceHttpResponseMessage) httpResponsedMessage).bOQ();
                    Message<?> message = httpResponsedMessage.getmOrginalMessage();
                    if (message instanceof com.baidu.tieba.yuyinala.liveroom.messages.b) {
                        com.baidu.tieba.yuyinala.liveroom.messages.b bVar = (com.baidu.tieba.yuyinala.liveroom.messages.b) message;
                        if (String.valueOf(bVar.dVu()).equals(a.this.aEc.aIS.live_id)) {
                            bOQ.liveId = String.valueOf(bVar.dVu());
                        } else {
                            return;
                        }
                    }
                    if (bOQ != null) {
                        a.this.gqS = bOQ;
                    }
                    if (a.this.aEc != null && a.this.aEc.aIg != null) {
                        if (a.this.hjs == -1) {
                            a.this.hjs = a.this.aEc.aIg.follow_status;
                        }
                        if (a.this.aEc.aIg.follow_status != a.this.hjs) {
                            a.this.aEc.aIg.follow_status = a.this.hjs;
                        }
                    }
                    a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 2, a.this.gqS);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913016, a.this.gqS));
                }
            }
        };
        this.hjM = new HttpMessageListener(1021121) { // from class: com.baidu.tieba.yuyinala.liveroom.i.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaUserLiveMarkInfoResponseMessage) {
                    AlaUserLiveMarkInfoResponseMessage alaUserLiveMarkInfoResponseMessage = (AlaUserLiveMarkInfoResponseMessage) httpResponsedMessage;
                    if (alaUserLiveMarkInfoResponseMessage.getError() == 0) {
                        List<AlaLiveMarkData> cdm = alaUserLiveMarkInfoResponseMessage.cdm();
                        a.this.nQt.Q(cdm);
                        if (a.this.aEc != null) {
                            a.this.aEc.aIJ = cdm;
                            com.baidu.live.im.b.d.LG().U(a.this.aEc.aIJ);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913118, a.this.aEc));
                        }
                    }
                }
            }
        };
        this.nQy = new HttpMessageListener(1031024) { // from class: com.baidu.tieba.yuyinala.liveroom.i.a.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof YuyinGetLiveInfoHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == a.this.unique_id) {
                    if (httpResponsedMessage.hasError()) {
                        a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, null);
                        return;
                    }
                    w GH = httpResponsedMessage instanceof YuyinGetLiveInfoHttpResponseMessage ? ((YuyinGetLiveInfoHttpResponseMessage) httpResponsedMessage).GH() : null;
                    if (GH == null) {
                        a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, GH);
                        return;
                    }
                    if (a.this.aEc == null) {
                        a.this.aEc = GH;
                        a.this.nQt.setAlaLiveShowData(a.this.aEc);
                    } else if (a.this.aEc.mLiveInfo != null && GH.mLiveInfo != null && a.this.aEc.mLiveInfo.live_id != GH.mLiveInfo.live_id) {
                        a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, a.this.aEc);
                        return;
                    }
                    if (a.this.aEc.mLiveInfo != null && GH.mLiveInfo != null && a.this.aEc.mLiveInfo.user_id == GH.mLiveInfo.user_id) {
                        if (a.this.aEc.mLiveInfo.mLiveCloseData != null && GH.mLiveInfo.mLiveCloseData == null) {
                            GH.mLiveInfo.mLiveCloseData = a.this.aEc.mLiveInfo.mLiveCloseData;
                        }
                        if (a.this.aEc.mLiveInfo.mAlaLiveSwitchData != null && GH.mLiveInfo.mAlaLiveSwitchData == null) {
                            GH.mLiveInfo.mAlaLiveSwitchData = a.this.aEc.mLiveInfo.mAlaLiveSwitchData;
                        }
                    }
                    a.this.aEc.mLiveInfo = GH.mLiveInfo;
                    a.this.aEc.aIe = GH.aIe;
                    if (a.this.aEc.aIS != null && GH.aIS != null && !TextUtils.equals(a.this.aEc.aIS.bg_cover, GH.aIS.bg_cover)) {
                        a.this.nQv = true;
                    } else {
                        a.this.nQv = false;
                    }
                    a.this.aEc.aIS = GH.aIS;
                    a.this.aEc.aIf = GH.aIf;
                    a.this.aEc.aIj = GH.aIj;
                    a.this.aEc.aIK = GH.aIK;
                    a.this.aEc.aII = GH.aII;
                    a.this.aEc.aIF = GH.aIF;
                    a.this.aEc.aIR = GH.aIR;
                    a.this.aEc.aIW = GH.aIW;
                    if (GH.aIN != null && GH.aIN.aMM != null && !GH.aIN.aMM.isEmpty()) {
                        a.this.aEc.aIN = GH.aIN;
                    }
                    if (GH.aIA != null) {
                        if (GH.aIA.userId != 0) {
                            a.this.aEc.aIA = GH.aIA;
                            TbadkCoreApplication.getCurrentAccountObj().setNameShow(a.this.aEc.aIA.nickName);
                        } else {
                            if (a.this.aEc.aIA == null) {
                                a.this.aEc.aIA = new AlaLiveUserInfoData();
                            }
                            a.this.aEc.aIA.throneUid = GH.aIA.throneUid;
                        }
                    }
                    if (GH.aIE != null) {
                        a.this.aEc.aIE = GH.aIE;
                    }
                    if (GH.aII) {
                        a.this.aEc.aIJ = GH.aIJ;
                        if (a.this.nQt != null) {
                            a.this.nQt.Q(GH.aIJ);
                        }
                    }
                    if (!a.this.mIsHost && a.this.aEc.mLiveInfo != null) {
                        int i = a.this.aEc.mLiveInfo.backstage_type;
                        if (a.this.nQt != null) {
                            a.this.nQt.hz(String.valueOf(i));
                        }
                    }
                    if (a.this.nQt != null) {
                        a.this.nQt.setAlaLiveShowData(a.this.aEc);
                    }
                    a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, a.this.aEc);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501033, a.this.aEc));
                    if (a.this.aEc != null) {
                        com.baidu.live.im.b.d.LG().U(a.this.aEc.aIJ);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501014, a.this.aEc));
                }
            }
        };
        this.nQz = new HttpMessageListener(1031044) { // from class: com.baidu.tieba.yuyinala.liveroom.i.a.9
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
                    if (list != null && list.size() > 0 && a.this.hjm != null && a.this.hjm.size() > 0) {
                        for (int size = a.this.hjm.size() - 1; size >= 0; size--) {
                            if (((AlaLiveInfoData) a.this.hjm.get(size)).live_id != a.this.aEc.mLiveInfo.live_id && list.contains(Long.valueOf(((AlaLiveInfoData) a.this.hjm.get(size)).getLiveID()))) {
                                a.this.hjm.remove(size);
                            }
                        }
                    }
                    if (a.this.aEc != null) {
                        a.this.h(a.this.aEc.mLiveInfo);
                    }
                    a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 4, Long.valueOf(j2));
                }
            }
        };
        this.hjR = new HttpMessageListener(1031062) { // from class: com.baidu.tieba.yuyinala.liveroom.i.a.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getOrginalMessage() != null && (httpResponsedMessage.getOrginalMessage().getExtra() instanceof com.baidu.live.o.b)) {
                    com.baidu.live.o.b bVar = (com.baidu.live.o.b) httpResponsedMessage.getOrginalMessage().getExtra();
                    if (bVar.boz != null) {
                        if (httpResponsedMessage.getError() == 0) {
                            bVar.boz.hH(bVar.contentType);
                        } else {
                            bVar.boz.d(bVar.contentType, httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                        }
                    }
                }
            }
        };
        this.hjT = new HttpMessageListener(1031037) { // from class: com.baidu.tieba.yuyinala.liveroom.i.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                c cVar;
                if (httpResponsedMessage != null && httpResponsedMessage.getError() == 0) {
                    if (!(httpResponsedMessage instanceof AlaLiveRecommondHttpResponseMessage)) {
                        cVar = null;
                    } else {
                        cVar = ((AlaLiveRecommondHttpResponseMessage) httpResponsedMessage).dVv();
                    }
                    if (cVar != null && !ListUtils.isEmpty(cVar.aIt)) {
                        a.this.hjn = cVar.pn + 1;
                        b bVar = cVar.aIt.get(cVar.aIt.size() - 1);
                        if (bVar != null) {
                            a.this.mLastLiveId = bVar.mLiveInfo.live_id;
                        }
                        a.this.a(cVar);
                        if (a.this.aEc != null) {
                            a.this.h(a.this.aEc.mLiveInfo);
                        }
                        a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 5, cVar);
                    }
                }
            }
        };
        this.mPageContext = bdPageContext;
        this.nQt = new q(bdPageContext, false, this);
        this.hjm = new ArrayList();
        this.hjy = new HashSet();
        initTasks();
        registerListener(this.nQy);
        this.hjg = BdUniqueId.gen();
        registerListener(this.nQz);
        registerListener(this.hjR);
    }

    private void initTasks() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031037, TbConfig.SERVER_ADDRESS + "ala/audio/recommend/getSwitchLives");
        tbHttpMessageTask.setResponsedClass(AlaLiveRecommondHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.hjT.setTag(this.hjg);
        registerListener(this.hjT);
        TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(1031042, TbConfig.SERVER_ADDRESS + "ala/audio/live/getAudienceInfo");
        tbHttpMessageTask2.setIsNeedLogin(false);
        tbHttpMessageTask2.setIsNeedTbs(true);
        tbHttpMessageTask2.setRetry(1);
        tbHttpMessageTask2.setResponsedClass(AlaGetAudienceHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask2);
        registerListener(this.hjL);
        TbHttpMessageTask tbHttpMessageTask3 = new TbHttpMessageTask(1031023, TbConfig.SERVER_ADDRESS + "ala/audio/enterLive");
        tbHttpMessageTask3.setIsNeedLogin(true);
        tbHttpMessageTask3.setIsNeedTbs(true);
        tbHttpMessageTask3.setIsNeedAddCommenParam(true);
        tbHttpMessageTask3.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask3.setResponsedClass(AlaEnterLiveHttpResonseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask3);
        registerListener(this.nQx);
        com.baidu.live.tieba.f.a.a.a(1031048, "ala/audio/exitLive", AlaQuitLiveHttpResponseMessage.class, false, true, true, true);
        registerListener(this.nQw);
        com.baidu.live.tieba.f.a.a.a(1021121, "ala/sdk/v1/open/getUserLiveMarkInfo", AlaUserLiveMarkInfoResponseMessage.class, true, true, true, true);
        registerListener(this.hjM);
        TbHttpMessageTask tbHttpMessageTask4 = new TbHttpMessageTask(1031071, TbConfig.SERVER_ADDRESS + "ala/UGC/getUGCAnchorInfo");
        tbHttpMessageTask4.setIsNeedLogin(false);
        tbHttpMessageTask4.setIsNeedTbs(true);
        tbHttpMessageTask4.setResponsedClass(MasterIdentityResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask4);
        registerListener(this.hjH);
    }

    public void cdy() {
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

    public void cdz() {
        MessageManager.getInstance().unRegisterTask(2913043);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, String str, int i2, Object obj) {
        if (this.nQm != null) {
            this.nQm.a(i, str, i2, obj);
        }
    }

    public void gJ(long j) {
        com.baidu.tieba.yuyinala.liveroom.messages.b bVar = new com.baidu.tieba.yuyinala.liveroom.messages.b();
        bVar.setLiveId(j);
        bVar.setParams();
        sendMessage(bVar);
    }

    public void a(long j, String str, long j2) {
        e eVar = new e();
        eVar.setLiveId(j);
        eVar.setFrom(str);
        eVar.ap(j2);
        eVar.setParams();
        sendMessage(eVar);
    }

    public void a(long j, String str, long j2, long j3) {
        e eVar = new e();
        eVar.setLiveId(j);
        eVar.setFrom(str);
        eVar.ap(j2);
        eVar.ag(j3);
        eVar.setParams();
        sendMessage(eVar);
    }

    public void cdK() {
        if (TbadkCoreApplication.isLogin()) {
            HttpMessage httpMessage = new HttpMessage(1021121);
            httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccount());
            sendMessage(httpMessage);
        }
    }

    public w GH() {
        return this.aEc;
    }

    public void d(w wVar) {
        this.aEc = wVar;
    }

    public List<AlaLiveInfoData> cdM() {
        return this.hjm;
    }

    public com.baidu.live.data.q bOQ() {
        return this.gqS;
    }

    public void ct(List<Long> list) {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
            com.baidu.tieba.yuyinala.liveroom.messages.c cVar = new com.baidu.tieba.yuyinala.liveroom.messages.c();
            if (this.aEc != null && this.aEc.mLiveInfo != null) {
                cVar.setAudienceCount(this.aEc.mLiveInfo.audience_count);
            }
            cVar.setListIds(list);
            cVar.setParams();
            sendMessage(cVar);
        }
    }

    public void cdN() {
        ArrayList arrayList = new ArrayList();
        for (AlaLiveInfoData alaLiveInfoData : this.hjm) {
            if (alaLiveInfoData != null) {
                arrayList.add(Long.valueOf(alaLiveInfoData.live_id));
            }
        }
        ct(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c cVar) {
        if (cVar != null) {
            if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isHaokan()) {
                if (this.hjm.size() == 1 && this.hjm.get(0).live_id == this.aEc.mLiveInfo.live_id) {
                    if (c(cVar) != null) {
                        this.hjm.clear();
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
        for (b bVar : cVar.aIt) {
            if (bVar != null && bVar.mLiveInfo != null) {
                for (AlaLiveInfoData alaLiveInfoData : this.hjm) {
                    if (alaLiveInfoData == null || alaLiveInfoData.live_id == bVar.mLiveInfo.live_id) {
                        z = false;
                        break;
                    }
                    while (r4.hasNext()) {
                    }
                }
                z = true;
                if (z) {
                    this.hjm.add(bVar.mLiveInfo);
                }
            }
        }
        if (this.hjm.size() >= 200) {
            ArrayList arrayList = new ArrayList();
            for (int size = this.hjm.size() - 200; size < this.hjm.size(); size++) {
                arrayList.add(this.hjm.get(size));
            }
            if (!ListUtils.isEmpty(arrayList)) {
                this.hjm.clear();
                this.hjm.addAll(arrayList);
                arrayList.clear();
            }
        }
    }

    private AlaLiveInfoData c(c cVar) {
        if (ListUtils.isEmpty(cVar.aIt)) {
            return null;
        }
        for (b bVar : cVar.aIt) {
            if (bVar != null && bVar.mLiveInfo != null && bVar.mLiveInfo.live_id == this.aEc.mLiveInfo.live_id) {
                return bVar.mLiveInfo;
            }
        }
        return null;
    }

    public ArrayList<AlaLiveInfoData> cdO() {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        if (ListUtils.isEmpty(this.hjm)) {
            return null;
        }
        if (this.hjy.isEmpty()) {
            arrayList.addAll(this.hjm);
        } else {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.hjm.size()) {
                    break;
                }
                if ((this.aEc == null || this.aEc.mLiveInfo == null || this.aEc.mLiveInfo.live_id != this.hjm.get(i2).live_id) && !this.hjy.contains(Long.valueOf(this.hjm.get(i2).live_id))) {
                    arrayList.add(this.hjm.get(i2));
                }
                i = i2 + 1;
            }
        }
        return arrayList;
    }

    public void g(AlaLiveInfoData alaLiveInfoData) {
        if (alaLiveInfoData != null) {
            this.hjy.add(Long.valueOf(alaLiveInfoData.getLiveID()));
            if (this.hjy.size() >= this.hjm.size() - 4) {
                nw(false);
            }
        }
    }

    public void vS(int i) {
        this.hjt = i;
    }

    public void nw(boolean z) {
        nx(z);
    }

    private void nx(boolean z) {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.hjB >= 1800000) {
                this.hjA = currentTimeMillis;
                this.hjC = true;
            }
            if (this.hjC) {
                HttpMessage httpMessage = new HttpMessage(1031037);
                httpMessage.addParam(Config.PACKAGE_NAME, z ? 0 : this.hjn);
                httpMessage.addParam("ps", 20);
                httpMessage.addParam("scr_w", BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst()));
                httpMessage.addParam("scr_h", BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst()));
                httpMessage.addParam("q_type", 0);
                httpMessage.addParam("scr_dip", String.valueOf(BdUtilHelper.getEquipmentDensity(TbadkCoreApplication.getInst())));
                httpMessage.addParam("forum_id", "");
                httpMessage.addParam("entry_name", "");
                httpMessage.addParam("live_id", this.mLastLiveId);
                httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccountId());
                httpMessage.addParam("slide_session_id", this.hjA);
                httpMessage.setTag(this.hjg);
                sendMessage(httpMessage);
                this.hjB = currentTimeMillis;
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
        aVar.AM(str);
        aVar.setLiveId(j);
        aVar.setParams();
        sendMessage(aVar);
        cdZ();
    }

    public void aq(String str, String str2, String str3) {
        Address address = BdLocationMananger.getInstance().getAddress(false);
        com.baidu.tieba.yuyinala.liveroom.messages.a aVar = new com.baidu.tieba.yuyinala.liveroom.messages.a();
        if (address != null) {
            aVar.c(address.getLongitude(), address.getLatitude());
        }
        aVar.setForumName(str3);
        aVar.AM(str2);
        aVar.setUk(str);
        aVar.setParams();
        sendMessage(aVar);
        cdZ();
    }

    public void HW(String str) {
        Address address = BdLocationMananger.getInstance().getAddress(false);
        com.baidu.tieba.yuyinala.liveroom.messages.a aVar = new com.baidu.tieba.yuyinala.liveroom.messages.a();
        if (address != null) {
            aVar.c(address.getLongitude(), address.getLatitude());
        }
        aVar.setRoomId(str);
        aVar.setParams();
        sendMessage(aVar);
        cdZ();
    }

    public void eD(long j) {
        this.nQt.Ct();
        this.hju = null;
        com.baidu.tieba.yuyinala.liveroom.messages.d dVar = new com.baidu.tieba.yuyinala.liveroom.messages.d();
        dVar.setLiveId(j);
        dVar.setParams();
        dVar.setTag(BdUniqueId.gen());
        sendMessage(dVar);
    }

    public void b(AlaLiveInfoCoreData alaLiveInfoCoreData) {
        if (this.aEc == null) {
            this.aEc = new w(alaLiveInfoCoreData);
            this.aEc.bo(true);
            this.nQt.setAlaLiveShowData(this.aEc);
        }
        this.mLastLiveId = this.aEc.mLiveInfo.live_id;
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
        this.hjh.removeCallbacksAndMessages(null);
        cancelLoadData();
        MessageManager.getInstance().unRegisterListener(this.hjT);
        MessageManager.getInstance().removeMessageRule(this.hjv);
        MessageManager.getInstance().unRegisterListener(this.unique_id);
        MessageManager.getInstance().unRegisterTask(1021163);
        MessageManager.getInstance().removeMessage(1031062, getUniqueId());
        this.nQt.Ct();
        this.nQu = null;
        this.mPageContext = null;
    }

    public void vT(int i) {
        this.hjo = i;
        if (this.hjm.size() == 0) {
            this.hjo = 0;
        } else if (this.hjo < 0) {
            this.hjo = this.hjm.size() + this.hjo;
        } else {
            this.hjo %= this.hjm.size();
        }
    }

    public void h(AlaLiveInfoData alaLiveInfoData) {
        if (alaLiveInfoData != null && this.hjm.size() != 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.hjm.size()) {
                    if (this.hjm.get(i2).live_id != alaLiveInfoData.live_id) {
                        i = i2 + 1;
                    } else {
                        this.hjo = i2;
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public boolean cdR() {
        long j;
        if (this.aEc == null || this.aEc.mLiveInfo == null || this.hjm.size() <= 0) {
            return true;
        }
        AlaLiveInfoData alaLiveInfoData = this.hjm.get(0);
        if (alaLiveInfoData == null) {
            j = 0;
        } else {
            j = alaLiveInfoData.live_id;
        }
        return j == this.aEc.mLiveInfo.live_id;
    }

    public boolean cdS() {
        long j;
        if (this.aEc == null || this.aEc.mLiveInfo == null || this.hjm.size() <= 0) {
            return true;
        }
        AlaLiveInfoData alaLiveInfoData = this.hjm.get(this.hjm.size() - 1);
        if (alaLiveInfoData == null) {
            j = 0;
        } else {
            j = alaLiveInfoData.live_id;
        }
        return j == this.aEc.mLiveInfo.live_id;
    }

    public int cdT() {
        return this.hjo;
    }

    public AlaLiveInfoData cdW() {
        if (this.hjo >= this.hjm.size()) {
            this.hjo = this.hjm.size() - 1;
        }
        if (this.hjo < 0) {
            this.hjo = 0;
        }
        if (this.hjm.size() <= this.hjo) {
            if (this.aEc != null) {
                return this.aEc.mLiveInfo;
            }
            return null;
        }
        return this.hjm.get(this.hjo);
    }

    public void a(InterfaceC0890a interfaceC0890a) {
        this.nQm = interfaceC0890a;
    }

    @Override // com.baidu.live.im.q.a
    public void d(List<com.baidu.live.im.data.a> list, boolean z) {
        if (this.nQu != null) {
            this.nQu.d(list, z);
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913038, list));
        }
    }

    @Override // com.baidu.live.im.q.a
    public void s(com.baidu.live.im.data.a aVar) {
        if (this.aEc != null && this.aEc.mLiveInfo.live_type == 1) {
            F(aVar);
        }
        if (this.nQu != null) {
            this.nQu.s(aVar);
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913037, aVar));
        }
    }

    public void F(com.baidu.live.im.data.a aVar) {
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
            nw(true);
        }
    }

    @Override // com.baidu.live.im.q.a
    public void KL() {
        if (this.nQu != null) {
            this.nQu.KL();
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913044));
        }
    }

    public void c(ImSendMsgData imSendMsgData) {
        AlaLiveUserInfoData alaLiveUserInfoData;
        if (this.aEc != null) {
            if (this.mIsHost) {
                alaLiveUserInfoData = this.aEc.aIe;
            } else {
                alaLiveUserInfoData = this.aEc.aIA;
            }
            if (alaLiveUserInfoData != null) {
                String[] strArr = this.aEc.mLiveInfo.imEffect;
                String[] strArr2 = null;
                if (strArr != null) {
                    strArr2 = new String[strArr.length];
                    System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
                }
                if (!TbadkCoreApplication.getInst().isMobileBaidu() && this.aEc != null && this.aEc.aIA != null && this.aEc.mLiveInfo != null) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    String str = this.aEc.aIA.throneUid;
                    if (!TextUtils.isEmpty(currentAccount) && !TextUtils.isEmpty(str) && currentAccount.equals(str)) {
                        if (strArr2 == null || strArr2.length != 2) {
                            strArr2 = new String[2];
                            strArr2[1] = "";
                        }
                        strArr2[0] = "guard_seat_effect";
                    }
                }
                this.nQt.a(imSendMsgData, alaLiveUserInfoData.isOfficial == 1, alaLiveUserInfoData.isAdmin == 1, alaLiveUserInfoData.levelId, this.otherParams, strArr2);
            }
        }
    }

    public void cdX() {
        this.nQt.e(String.valueOf(this.aEc.mLiveInfo.getGroupID()), String.valueOf(this.aEc.mLiveInfo.getLastMsgID()), String.valueOf(this.aEc.mLiveInfo.getUserID()), String.valueOf(this.aEc.mLiveInfo.getLiveID()), this.aEc.mLiveInfo.appId);
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    private void cdZ() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaEnterLiveHttpResonseMessage alaEnterLiveHttpResonseMessage) {
    }

    public String cea() {
        return this.hju;
    }

    public void Ht(String str) {
        this.hju = str;
    }
}

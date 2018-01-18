package com.baidu.tieba.tbadkCore;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.FeedForumData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PhotoLiveCardData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.ab;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.au;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.am;
import com.squareup.wire.Message;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;
import tbclient.AlaLiveNotify;
import tbclient.CategoryInfo;
import tbclient.ForumArIno;
import tbclient.FrsPage.AgreeBanner;
import tbclient.FrsPage.ColorEgg;
import tbclient.FrsPage.DataRes;
import tbclient.FrsPage.ForumHeadIcon;
import tbclient.FrsPage.FrsPageResIdl;
import tbclient.FrsPage.NavTabInfo;
import tbclient.FrsPage.RecmForumInfo;
import tbclient.FrsPage.StarEnter;
import tbclient.FrsTabInfo;
import tbclient.PopInfo;
import tbclient.ThreadInfo;
import tbclient.User;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class i implements com.baidu.tbadk.mvc.b.c {
    public static final Wire WIRE = new Wire(new Class[0]);
    private AntiData aLO;
    protected al eOn;
    protected ForumData fDm;
    private UserData fDt;
    protected List<Long> gVD;
    private j gVE;
    protected boolean gVF;
    protected String gVG;
    protected m gVH;
    private b gVI;
    private boolean gVJ;
    private List<PhotoLiveCardData> gVM;
    private int gVN;
    private PhotoLiveCardData gVO;
    private String gVP;
    private List<FrsTabInfo> gVS;
    private NavTabInfo gVT;
    private List<FeedForumData> gVV;
    private List<CategoryInfo> gVW;
    public ForumArIno gWA;
    private bd gWe;
    private au gWf;
    private com.baidu.tbadk.core.data.l gWh;
    private List<Integer> gWl;
    private List<com.baidu.adp.widget.ListView.i> gWm;
    private e gWn;
    private f gWo;
    public PopInfo gWp;
    private com.baidu.tieba.g.b gWq;
    private AgreeBanner gWr;
    private AlaLiveNotify gWs;
    private List<FrsTabInfo> gWt;
    private ForumHeadIcon gWv;
    private com.baidu.tieba.frs.s gWw;
    private k gWx;
    public FrsTabInfo gWy;
    private String gameName;
    private int mSortType;
    public List<RecmForumInfo> recm_forum_list;
    protected ArrayList<com.baidu.adp.widget.ListView.i> threadList;
    private HashMap<String, MetaData> userMap;
    public int gVC = 0;
    private List<g> gVK = new ArrayList();
    private int gVL = 0;
    private ArrayList<com.baidu.tbadk.core.data.n> gVQ = new ArrayList<>();
    protected com.baidu.tbadk.core.data.o gVR = null;
    private int gVU = 1;
    private String gVX = null;
    private com.baidu.tbadk.core.data.w gVY = null;
    public com.baidu.tbadk.core.data.x gVZ = null;
    private com.baidu.tbadk.core.data.p gWa = null;
    private Integer gWb = -1;
    public com.baidu.tbadk.core.data.u gWc = null;
    private com.baidu.tbadk.core.data.r gWd = null;
    private int gWg = -1;
    protected List<com.baidu.adp.widget.ListView.i> gWi = null;
    private int gWj = 0;
    private int gWk = 0;
    private int alaLiveCount = 0;
    private int gWu = 0;
    public int gWz = 0;

    public i() {
        initData();
    }

    private void initData() {
        this.fDm = new ForumData();
        this.threadList = new ArrayList<>();
        this.gWi = new ArrayList();
        this.userMap = new HashMap<>();
        this.eOn = new al();
        this.gVE = new j();
        this.fDt = new UserData();
        this.gVH = new m();
        c(new AntiData());
        a(new b());
        this.gWm = new ArrayList();
        this.gWl = new ArrayList();
    }

    public FrsPageResIdl C(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            FrsPageResIdl frsPageResIdl = (FrsPageResIdl) WIRE.parseFrom(bArr, FrsPageResIdl.class);
            if (frsPageResIdl != null && frsPageResIdl.data != null) {
                a(frsPageResIdl.data);
                return frsPageResIdl;
            }
            return frsPageResIdl;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }

    public void a(DataRes dataRes) {
        MetaData metaData;
        MetaData metaData2;
        if (dataRes != null) {
            try {
                initData();
                if (!com.baidu.tbadk.core.util.v.E(dataRes.color_egg)) {
                    for (ColorEgg colorEgg : dataRes.color_egg) {
                        if (colorEgg != null && !com.baidu.tbadk.core.util.v.E(colorEgg.holiday_words)) {
                            com.baidu.tbadk.core.data.n nVar = new com.baidu.tbadk.core.data.n();
                            if (nVar.a(colorEgg)) {
                                this.gVQ.add(nVar);
                            }
                        }
                    }
                }
                if (dataRes.activityhead != null && !com.baidu.tbadk.core.util.v.E(dataRes.activityhead.head_imgs)) {
                    this.gVR = new com.baidu.tbadk.core.data.o();
                    this.gVR.a(dataRes.activityhead);
                }
                List<User> list = dataRes.user_list;
                if (list != null) {
                    for (int i = 0; i < list.size(); i++) {
                        MetaData metaData3 = new MetaData();
                        metaData3.parserProtobuf(list.get(i));
                        String userId = metaData3.getUserId();
                        if (userId != null && !userId.equals("0")) {
                            this.userMap.put(metaData3.getUserId(), metaData3);
                        }
                    }
                }
                sw(dataRes.is_new_url.intValue());
                this.gVF = dataRes.fortune_bag.intValue() == 1;
                this.gVG = dataRes.fortune_desc;
                if (dataRes.forum != null) {
                    this.gVJ = dataRes.forum.has_game.intValue() == 1;
                    this.gVP = dataRes.forum.game_url;
                    this.gameName = dataRes.forum.game_name;
                }
                List<StarEnter> list2 = dataRes.star_enter;
                this.gVK.clear();
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        g gVar = new g();
                        gVar.a(list2.get(i2));
                        this.gVK.add(gVar);
                    }
                }
                this.gVH.a(dataRes.gcon_account);
                this.fDm.parserProtobuf(dataRes.forum);
                long longValue = dataRes.forum != null ? dataRes.forum.id.longValue() : 0L;
                this.gVD = dataRes.thread_id_list;
                this.aLO.parserProtobuf(dataRes.anti);
                if (dataRes.anti != null) {
                    com.baidu.tieba.p.a.e(dataRes.anti.block_pop_info);
                }
                this.gVI.a(dataRes.group);
                this.eOn.a(dataRes.page);
                this.gVE.a(dataRes.frs_star);
                this.fDt.parserProtobuf(dataRes.user);
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.fDt.getIsSelectTail());
                }
                this.gVS = dataRes.frs_tab_info;
                if (dataRes.nav_tab_info == null) {
                    NavTabInfo.Builder builder = new NavTabInfo.Builder();
                    builder.tab = dataRes.frs_tab_info;
                    this.gVT = builder.build(true);
                } else {
                    this.gVT = dataRes.nav_tab_info;
                }
                if (this.gVT.head != null && !com.baidu.tbadk.core.util.v.E(this.gVT.head)) {
                    this.gWy = this.gVT.head.get(0);
                }
                this.alaLiveCount = dataRes.ala_live_count.intValue();
                vy(dataRes.frs_tab_default.intValue());
                List<ZhiBoInfoTW> list3 = dataRes.twzhibo_info;
                if (list3 != null && list3.size() > 0) {
                    this.gVM = new ArrayList();
                    int size = list3.size();
                    int i3 = -1;
                    for (int i4 = 0; i4 < size; i4++) {
                        PhotoLiveCardData photoLiveCardData = new PhotoLiveCardData();
                        photoLiveCardData.parserProtobuf(list3.get(i4));
                        if (photoLiveCardData.getShowStyle() < 0) {
                            photoLiveCardData.setShowStyle(PhotoLiveCardData.getRandom(3, i3));
                        }
                        i3 = photoLiveCardData.getShowStyle();
                        photoLiveCardData.setShowExpressionViewIndexList(photoLiveCardData.getExpressionDatas());
                        if (photoLiveCardData.getPendantData() == null && (metaData2 = this.userMap.get(photoLiveCardData.getAuthorId())) != null && metaData2.getPendantData() != null) {
                            photoLiveCardData.setUserPendantData(metaData2.getPendantData());
                        }
                        this.gVM.add(photoLiveCardData);
                    }
                }
                this.gVN = dataRes.twzhibo_pos.intValue();
                if (dataRes.hot_twzhibo_info != null) {
                    this.gVO = new PhotoLiveCardData();
                    if (this.gVO.getShowStyle() < 0) {
                        PhotoLiveCardData photoLiveCardData2 = this.gVO;
                        this.gVO.setShowStyle(PhotoLiveCardData.getRandom(3, -1));
                    }
                    this.gVO.getShowStyle();
                    this.gVO.parserProtobuf(dataRes.hot_twzhibo_info);
                    this.gVO.setShowExpressionViewIndexList(this.gVO.getExpressionDatas());
                }
                a(dataRes.thread_list, longValue);
                this.gVW = dataRes.category_list;
                if (!am.isEmpty(dataRes.bawu_enter_url)) {
                    this.gVX = dataRes.bawu_enter_url;
                }
                if (dataRes.head_sdk != null) {
                    this.gVY = new com.baidu.tbadk.core.data.w();
                    this.gVY.a(dataRes.head_sdk);
                }
                if (dataRes.recommend_book != null) {
                    this.gVZ = new com.baidu.tbadk.core.data.x();
                    this.gVZ.a(dataRes.recommend_book);
                }
                if (dataRes.book_info != null) {
                    this.gWa = new com.baidu.tbadk.core.data.p();
                    this.gWa.a(dataRes.book_info);
                }
                if (dataRes.forum_present_info != null) {
                    this.gWc = new com.baidu.tbadk.core.data.u();
                    this.gWc.a(dataRes.forum_present_info);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.gWd = new com.baidu.tbadk.core.data.r();
                    this.gWd.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.card_shipin_info != null && dataRes.card_shipin_info.size() > 0) {
                    this.gWe = new bd();
                    this.gWe.aT(true);
                    this.gWe.eV(this.gVN);
                    this.gWe.setUserMap(this.userMap);
                    this.gWe.a(dataRes.card_shipin_info.get(0));
                    this.gWe.zB();
                    if (this.gWe.getFid() == 0 && longValue != 0) {
                        this.gWe.setFid(longValue);
                    }
                    this.gWe.j(this.gVQ);
                    this.gWe.aS(!this.gWe.yz());
                    if (this.gWe.yS() != null && this.gWe.yS().getPendantData() == null && (metaData = this.userMap.get(this.gWe.yS().getUserId())) != null && metaData.getPendantData() != null) {
                        com.baidu.tbadk.data.h hVar = new com.baidu.tbadk.data.h();
                        hVar.ab(metaData.getPendantData().JW());
                        hVar.cM(metaData.getPendantData().xt());
                        this.gWe.yS().setPendantData(hVar);
                    }
                }
                if (dataRes.ala_live_insert != null && dataRes.ala_live_insert.ala_live_list != null && dataRes.ala_live_insert.ala_live_list.size() > 0) {
                    this.gWn = new e();
                    this.gWn.gUZ = dataRes.ala_insert_floor.intValue();
                    ArrayList arrayList = new ArrayList();
                    for (int i5 = 0; i5 < dataRes.ala_live_insert.ala_live_list.size(); i5++) {
                        if (dataRes.ala_live_insert.ala_live_list.get(i5) != null) {
                            bd bdVar = new bd();
                            bdVar.a(dataRes.ala_live_insert.ala_live_list.get(i5));
                            arrayList.add(bdVar);
                        }
                    }
                    this.gWn.gUY = arrayList;
                }
                if (dataRes.ala_stage_list != null) {
                    this.gWo = new f();
                    ArrayList arrayList2 = new ArrayList();
                    for (int i6 = 0; i6 < dataRes.ala_stage_list.size(); i6++) {
                        if (dataRes.ala_stage_list.get(i6) != null) {
                            bd bdVar2 = new bd();
                            bdVar2.a(dataRes.ala_stage_list.get(i6));
                            arrayList2.add(bdVar2);
                        }
                    }
                    this.gWo.gVb = arrayList2;
                }
                if (dataRes.school_recom_info != null) {
                    this.gWg = dataRes.school_recom_pos.intValue();
                    this.gWf = new au();
                    this.gWf.a(dataRes.school_recom_info);
                }
                if (dataRes.carrier_enter != null) {
                    this.gWh = new com.baidu.tbadk.core.data.l();
                    this.gWh.a(dataRes.carrier_enter);
                }
                if (dataRes.vitality_info != null && dataRes.vitality_info.frequently_forum_info != null) {
                    this.gWj = dataRes.vitality_info.frequently_forum_info.forum_state.intValue();
                    this.gWk = dataRes.vitality_info.frequently_forum_info.access_flag.intValue();
                }
                this.mSortType = dataRes.sort_type.intValue();
                this.gVC = dataRes.need_log.intValue();
                com.baidu.tieba.recapp.e.a.bnw().rG(dataRes.asp_shown_info);
                this.gWl = dataRes.card_shipin_pos;
                if (dataRes.card_shipin_new != null) {
                    for (int i7 = 0; i7 < dataRes.card_shipin_new.size(); i7++) {
                        bd bdVar3 = new bd();
                        if (this.gWl != null && this.gWl.size() >= dataRes.card_shipin_new.size()) {
                            bdVar3.eV(this.gWl.get(i7).intValue());
                        }
                        bdVar3.aT(true);
                        bdVar3.a(dataRes.card_shipin_new.get(i7));
                        this.gWm.add(bdVar3);
                    }
                }
                this.gWp = dataRes.enter_pop_info;
                if (dataRes.esport != null) {
                    this.gWq = new com.baidu.tieba.g.b();
                    this.gWq.a(dataRes.esport);
                }
                this.gWr = dataRes.agree_banner;
                if (dataRes.user_extend != null) {
                    this.gWw = new com.baidu.tieba.frs.s();
                    this.gWw.a(dataRes.user_extend);
                }
                this.gWs = dataRes.live_frs_notify;
                this.gWt = dataRes.frs_game_tab_info;
                this.gWu = dataRes.game_default_tab_id.intValue();
                this.gWv = dataRes.forum_head_icon;
                if (dataRes.video != null && dataRes.video.video_act != null) {
                    this.gWx = new k();
                    this.gWx.a(dataRes.video.video_act);
                }
                if (dataRes.info != null) {
                    this.recm_forum_list = dataRes.info.recm_forum_list;
                }
                this.gWA = dataRes.forum_ar_info;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public AgreeBanner btx() {
        return this.gWr;
    }

    public void a(AgreeBanner agreeBanner) {
        this.gWr = agreeBanner;
    }

    public ForumHeadIcon bty() {
        return this.gWv;
    }

    public void a(ForumHeadIcon forumHeadIcon) {
        this.gWv = forumHeadIcon;
    }

    public List<RecmForumInfo> btz() {
        return this.recm_forum_list;
    }

    private void vy(int i) {
        this.gVU = 1;
        if (this.gVS != null && this.gVS.size() > 0) {
            for (FrsTabInfo frsTabInfo : this.gVS) {
                if (frsTabInfo != null && frsTabInfo.tab_id.intValue() == i) {
                    this.gVU = i;
                    return;
                }
            }
        }
    }

    public void a(List<ThreadInfo> list, long j) {
        if (list != null) {
            boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
            for (int i = 0; i < list.size(); i++) {
                bd bdVar = new bd();
                bdVar.setUserMap(this.userMap);
                bdVar.a(list.get(i));
                bdVar.eW(3);
                bdVar.zB();
                if (bdVar.getFid() == 0 && j != 0) {
                    bdVar.setFid(j);
                }
                if (StringUtils.isNull(bdVar.yY())) {
                    bdVar.cO(this.fDm.getName());
                }
                bdVar.j(this.gVQ);
                if (bdVar.getThreadType() == 33 && !bdVar.zt()) {
                    ar arVar = new ar();
                    arVar.a(bdVar, 0);
                    arVar.B(btM());
                    if (appResponseToIntentClass) {
                        this.threadList.add(arVar);
                    }
                } else if (!TextUtils.isEmpty(bdVar.zL())) {
                    ab abVar = new ab();
                    abVar.cJ(bdVar.zL());
                    this.threadList.add(abVar);
                } else {
                    this.threadList.add(bdVar);
                }
            }
        }
    }

    public int btA() {
        return this.alaLiveCount;
    }

    public void vz(int i) {
        this.alaLiveCount = i;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] Mp() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public boolean x(byte[] bArr) {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void j(JSONObject jSONObject) {
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void a(Message message) {
    }

    public ForumData aYE() {
        return this.fDm;
    }

    public int btB() {
        return this.gWj;
    }

    public void vA(int i) {
        this.gWj = i;
    }

    public int btC() {
        return this.gWk;
    }

    public void vB(int i) {
        this.gWk = i;
    }

    public void c(ForumData forumData) {
        this.fDm = forumData;
    }

    public ArrayList<com.baidu.adp.widget.ListView.i> getThreadList() {
        return this.threadList;
    }

    public void at(ArrayList<com.baidu.adp.widget.ListView.i> arrayList) {
        this.threadList = arrayList;
    }

    public AntiData xG() {
        return this.aLO;
    }

    public void c(AntiData antiData) {
        this.aLO = antiData;
    }

    public al xY() {
        return this.eOn;
    }

    public void a(al alVar) {
        this.eOn = alVar;
    }

    public j btD() {
        return this.gVE;
    }

    public void a(j jVar) {
        this.gVE = jVar;
    }

    public com.baidu.tbadk.core.data.o btE() {
        return this.gVR;
    }

    public void a(com.baidu.tbadk.core.data.o oVar) {
        this.gVR = oVar;
    }

    public boolean btF() {
        return this.gVF;
    }

    public void mt(boolean z) {
        this.gVF = z;
    }

    public String btG() {
        return this.gVG;
    }

    public void sk(String str) {
        this.gVG = str;
    }

    public m btH() {
        return this.gVH;
    }

    public void a(m mVar) {
        this.gVH = mVar;
    }

    public UserData getUserData() {
        return this.fDt;
    }

    public void e(UserData userData) {
        this.fDt = userData;
    }

    public List<Long> btI() {
        return this.gVD;
    }

    public void di(List<Long> list) {
        this.gVD = list;
    }

    public b btJ() {
        return this.gVI;
    }

    public void a(b bVar) {
        this.gVI = bVar;
    }

    public boolean btK() {
        return this.gVJ;
    }

    public void mu(boolean z) {
        this.gVJ = z;
    }

    public String getGameName() {
        return this.gameName;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public List<g> btL() {
        return this.gVK;
    }

    public void dj(List<g> list) {
        this.gVK = list;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public int aYT() {
        return this.gVL;
    }

    public void sw(int i) {
        this.gVL = i;
    }

    public List<PhotoLiveCardData> btM() {
        return this.gVM;
    }

    public String btN() {
        return this.gVP;
    }

    public void sl(String str) {
        this.gVP = str;
    }

    public List<FrsTabInfo> btO() {
        return this.gVS;
    }

    public void dk(List<FrsTabInfo> list) {
        this.gVS = list;
    }

    public void dl(List<PhotoLiveCardData> list) {
        this.gVM = list;
    }

    public boolean btP() {
        return this.gVO != null;
    }

    public PhotoLiveCardData btQ() {
        return this.gVO;
    }

    public void b(PhotoLiveCardData photoLiveCardData) {
        this.gVO = photoLiveCardData;
    }

    public int btR() {
        return this.gVN;
    }

    public void vC(int i) {
        this.gVN = i;
    }

    public List<FeedForumData> btS() {
        return this.gVV;
    }

    public void dm(List<FeedForumData> list) {
        this.gVV = list;
    }

    public void sm(String str) {
        if (this.gVV != null && str != null) {
            for (FeedForumData feedForumData : this.gVV) {
                if (feedForumData != null && feedForumData.getForumId() != null && feedForumData.getForumId().equals(str)) {
                    this.gVV.remove(feedForumData);
                    return;
                }
            }
        }
    }

    public List<CategoryInfo> btT() {
        return this.gVW;
    }

    public void dn(List<CategoryInfo> list) {
        this.gVW = list;
    }

    public void sn(String str) {
        this.gVX = str;
    }

    public String btU() {
        return this.gVX;
    }

    public bd btV() {
        return this.gWe;
    }

    public void af(bd bdVar) {
        this.gWe = bdVar;
    }

    public int btW() {
        return this.gVU;
    }

    public void vD(int i) {
        this.gVU = i;
    }

    public com.baidu.tbadk.core.data.w btX() {
        return this.gVY;
    }

    public void a(com.baidu.tbadk.core.data.w wVar) {
        this.gVY = wVar;
    }

    public com.baidu.tbadk.core.data.p btY() {
        return this.gWa;
    }

    public void a(com.baidu.tbadk.core.data.p pVar) {
        this.gWa = pVar;
    }

    public com.baidu.tbadk.core.data.r btZ() {
        return this.gWd;
    }

    public void a(com.baidu.tbadk.core.data.r rVar) {
        this.gWd = rVar;
    }

    public int bua() {
        return this.gWg;
    }

    public void vE(int i) {
        this.gWg = i;
    }

    public au bub() {
        return this.gWf;
    }

    public void a(au auVar) {
        this.gWf = auVar;
    }

    public NavTabInfo buc() {
        return this.gVT;
    }

    public void a(NavTabInfo navTabInfo) {
        this.gVT = navTabInfo;
    }

    public com.baidu.tbadk.core.data.l bud() {
        return this.gWh;
    }

    public void a(com.baidu.tbadk.core.data.l lVar) {
        this.gWh = lVar;
    }

    public Integer bue() {
        return this.gWb;
    }

    public void j(Integer num) {
        this.gWb = num;
    }

    public List<Integer> buf() {
        return this.gWl;
    }

    /* renamed from: do  reason: not valid java name */
    public void m14do(List<Integer> list) {
        this.gWl = list;
    }

    public List<com.baidu.adp.widget.ListView.i> bug() {
        return this.gWm;
    }

    public void dp(List<com.baidu.adp.widget.ListView.i> list) {
        this.gWm = list;
    }

    public com.baidu.tieba.g.b buh() {
        return this.gWq;
    }

    public void a(com.baidu.tieba.g.b bVar) {
        this.gWq = bVar;
    }

    public AlaLiveNotify bui() {
        return this.gWs;
    }

    public void a(AlaLiveNotify alaLiveNotify) {
        this.gWs = alaLiveNotify;
    }

    public List<FrsTabInfo> buj() {
        return this.gWt;
    }

    public void dq(List<FrsTabInfo> list) {
        this.gWt = list;
    }

    public void vF(int i) {
        this.gWu = i;
    }

    public int buk() {
        return this.gWu;
    }

    public void a(com.baidu.tieba.frs.s sVar) {
        this.gWw = sVar;
    }

    public com.baidu.tieba.frs.s bul() {
        return this.gWw;
    }

    public k bum() {
        return this.gWx;
    }

    public void a(k kVar) {
        this.gWx = kVar;
    }

    public e bun() {
        return this.gWn;
    }

    public void b(e eVar) {
        this.gWn = eVar;
    }

    public f buo() {
        return this.gWo;
    }

    public void b(f fVar) {
        this.gWo = fVar;
    }
}

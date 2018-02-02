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
    private AntiData aLR;
    protected al eOI;
    protected ForumData fDH;
    private UserData fDO;
    protected List<Long> gVX;
    private j gVY;
    protected boolean gVZ;
    private com.baidu.tbadk.core.data.l gWB;
    private List<Integer> gWF;
    private List<com.baidu.adp.widget.ListView.i> gWG;
    private e gWH;
    private f gWI;
    public PopInfo gWJ;
    private com.baidu.tieba.g.b gWK;
    private AgreeBanner gWL;
    private AlaLiveNotify gWM;
    private List<FrsTabInfo> gWN;
    private ForumHeadIcon gWP;
    private com.baidu.tieba.frs.s gWQ;
    private k gWR;
    public FrsTabInfo gWS;
    public ForumArIno gWU;
    protected String gWa;
    protected m gWb;
    private b gWc;
    private boolean gWd;
    private List<PhotoLiveCardData> gWg;
    private int gWh;
    private PhotoLiveCardData gWi;
    private String gWj;
    private List<FrsTabInfo> gWm;
    private NavTabInfo gWn;
    private List<FeedForumData> gWp;
    private List<CategoryInfo> gWq;
    private bd gWy;
    private au gWz;
    private String gameName;
    private int mSortType;
    public List<RecmForumInfo> recm_forum_list;
    protected ArrayList<com.baidu.adp.widget.ListView.i> threadList;
    private HashMap<String, MetaData> userMap;
    public int gVW = 0;
    private List<g> gWe = new ArrayList();
    private int gWf = 0;
    private ArrayList<com.baidu.tbadk.core.data.n> gWk = new ArrayList<>();
    protected com.baidu.tbadk.core.data.o gWl = null;
    private int gWo = 1;
    private String gWr = null;
    private com.baidu.tbadk.core.data.w gWs = null;
    public com.baidu.tbadk.core.data.x gWt = null;
    private com.baidu.tbadk.core.data.p gWu = null;
    private Integer gWv = -1;
    public com.baidu.tbadk.core.data.u gWw = null;
    private com.baidu.tbadk.core.data.r gWx = null;
    private int gWA = -1;
    protected List<com.baidu.adp.widget.ListView.i> gWC = null;
    private int gWD = 0;
    private int gWE = 0;
    private int alaLiveCount = 0;
    private int gWO = 0;
    public int gWT = 0;

    public i() {
        initData();
    }

    private void initData() {
        this.fDH = new ForumData();
        this.threadList = new ArrayList<>();
        this.gWC = new ArrayList();
        this.userMap = new HashMap<>();
        this.eOI = new al();
        this.gVY = new j();
        this.fDO = new UserData();
        this.gWb = new m();
        c(new AntiData());
        a(new b());
        this.gWG = new ArrayList();
        this.gWF = new ArrayList();
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
                                this.gWk.add(nVar);
                            }
                        }
                    }
                }
                if (dataRes.activityhead != null && !com.baidu.tbadk.core.util.v.E(dataRes.activityhead.head_imgs)) {
                    this.gWl = new com.baidu.tbadk.core.data.o();
                    this.gWl.a(dataRes.activityhead);
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
                this.gVZ = dataRes.fortune_bag.intValue() == 1;
                this.gWa = dataRes.fortune_desc;
                if (dataRes.forum != null) {
                    this.gWd = dataRes.forum.has_game.intValue() == 1;
                    this.gWj = dataRes.forum.game_url;
                    this.gameName = dataRes.forum.game_name;
                }
                List<StarEnter> list2 = dataRes.star_enter;
                this.gWe.clear();
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        g gVar = new g();
                        gVar.a(list2.get(i2));
                        this.gWe.add(gVar);
                    }
                }
                this.gWb.a(dataRes.gcon_account);
                this.fDH.parserProtobuf(dataRes.forum);
                long longValue = dataRes.forum != null ? dataRes.forum.id.longValue() : 0L;
                this.gVX = dataRes.thread_id_list;
                this.aLR.parserProtobuf(dataRes.anti);
                if (dataRes.anti != null) {
                    com.baidu.tieba.p.a.e(dataRes.anti.block_pop_info);
                }
                this.gWc.a(dataRes.group);
                this.eOI.a(dataRes.page);
                this.gVY.a(dataRes.frs_star);
                this.fDO.parserProtobuf(dataRes.user);
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.fDO.getIsSelectTail());
                }
                this.gWm = dataRes.frs_tab_info;
                if (dataRes.nav_tab_info == null) {
                    NavTabInfo.Builder builder = new NavTabInfo.Builder();
                    builder.tab = dataRes.frs_tab_info;
                    this.gWn = builder.build(true);
                } else {
                    this.gWn = dataRes.nav_tab_info;
                }
                if (this.gWn.head != null && !com.baidu.tbadk.core.util.v.E(this.gWn.head)) {
                    this.gWS = this.gWn.head.get(0);
                }
                this.alaLiveCount = dataRes.ala_live_count.intValue();
                vy(dataRes.frs_tab_default.intValue());
                List<ZhiBoInfoTW> list3 = dataRes.twzhibo_info;
                if (list3 != null && list3.size() > 0) {
                    this.gWg = new ArrayList();
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
                        this.gWg.add(photoLiveCardData);
                    }
                }
                this.gWh = dataRes.twzhibo_pos.intValue();
                if (dataRes.hot_twzhibo_info != null) {
                    this.gWi = new PhotoLiveCardData();
                    if (this.gWi.getShowStyle() < 0) {
                        PhotoLiveCardData photoLiveCardData2 = this.gWi;
                        this.gWi.setShowStyle(PhotoLiveCardData.getRandom(3, -1));
                    }
                    this.gWi.getShowStyle();
                    this.gWi.parserProtobuf(dataRes.hot_twzhibo_info);
                    this.gWi.setShowExpressionViewIndexList(this.gWi.getExpressionDatas());
                }
                a(dataRes.thread_list, longValue);
                this.gWq = dataRes.category_list;
                if (!am.isEmpty(dataRes.bawu_enter_url)) {
                    this.gWr = dataRes.bawu_enter_url;
                }
                if (dataRes.head_sdk != null) {
                    this.gWs = new com.baidu.tbadk.core.data.w();
                    this.gWs.a(dataRes.head_sdk);
                }
                if (dataRes.recommend_book != null) {
                    this.gWt = new com.baidu.tbadk.core.data.x();
                    this.gWt.a(dataRes.recommend_book);
                }
                if (dataRes.book_info != null) {
                    this.gWu = new com.baidu.tbadk.core.data.p();
                    this.gWu.a(dataRes.book_info);
                }
                if (dataRes.forum_present_info != null) {
                    this.gWw = new com.baidu.tbadk.core.data.u();
                    this.gWw.a(dataRes.forum_present_info);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.gWx = new com.baidu.tbadk.core.data.r();
                    this.gWx.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.card_shipin_info != null && dataRes.card_shipin_info.size() > 0) {
                    this.gWy = new bd();
                    this.gWy.aU(true);
                    this.gWy.eV(this.gWh);
                    this.gWy.setUserMap(this.userMap);
                    this.gWy.a(dataRes.card_shipin_info.get(0));
                    this.gWy.zC();
                    if (this.gWy.getFid() == 0 && longValue != 0) {
                        this.gWy.setFid(longValue);
                    }
                    this.gWy.j(this.gWk);
                    this.gWy.aT(!this.gWy.yA());
                    if (this.gWy.yT() != null && this.gWy.yT().getPendantData() == null && (metaData = this.userMap.get(this.gWy.yT().getUserId())) != null && metaData.getPendantData() != null) {
                        com.baidu.tbadk.data.h hVar = new com.baidu.tbadk.data.h();
                        hVar.ab(metaData.getPendantData().JY());
                        hVar.cM(metaData.getPendantData().xu());
                        this.gWy.yT().setPendantData(hVar);
                    }
                }
                if (dataRes.ala_live_insert != null && dataRes.ala_live_insert.ala_live_list != null && dataRes.ala_live_insert.ala_live_list.size() > 0) {
                    this.gWH = new e();
                    this.gWH.gVt = dataRes.ala_insert_floor.intValue();
                    ArrayList arrayList = new ArrayList();
                    for (int i5 = 0; i5 < dataRes.ala_live_insert.ala_live_list.size(); i5++) {
                        if (dataRes.ala_live_insert.ala_live_list.get(i5) != null) {
                            bd bdVar = new bd();
                            bdVar.a(dataRes.ala_live_insert.ala_live_list.get(i5));
                            arrayList.add(bdVar);
                        }
                    }
                    this.gWH.gVs = arrayList;
                }
                if (dataRes.ala_stage_list != null) {
                    this.gWI = new f();
                    ArrayList arrayList2 = new ArrayList();
                    for (int i6 = 0; i6 < dataRes.ala_stage_list.size(); i6++) {
                        if (dataRes.ala_stage_list.get(i6) != null) {
                            bd bdVar2 = new bd();
                            bdVar2.a(dataRes.ala_stage_list.get(i6));
                            arrayList2.add(bdVar2);
                        }
                    }
                    this.gWI.gVv = arrayList2;
                }
                if (dataRes.school_recom_info != null) {
                    this.gWA = dataRes.school_recom_pos.intValue();
                    this.gWz = new au();
                    this.gWz.a(dataRes.school_recom_info);
                }
                if (dataRes.carrier_enter != null) {
                    this.gWB = new com.baidu.tbadk.core.data.l();
                    this.gWB.a(dataRes.carrier_enter);
                }
                if (dataRes.vitality_info != null && dataRes.vitality_info.frequently_forum_info != null) {
                    this.gWD = dataRes.vitality_info.frequently_forum_info.forum_state.intValue();
                    this.gWE = dataRes.vitality_info.frequently_forum_info.access_flag.intValue();
                }
                this.mSortType = dataRes.sort_type.intValue();
                this.gVW = dataRes.need_log.intValue();
                com.baidu.tieba.recapp.e.a.bnx().rO(dataRes.asp_shown_info);
                this.gWF = dataRes.card_shipin_pos;
                if (dataRes.card_shipin_new != null) {
                    for (int i7 = 0; i7 < dataRes.card_shipin_new.size(); i7++) {
                        bd bdVar3 = new bd();
                        if (this.gWF != null && this.gWF.size() >= dataRes.card_shipin_new.size()) {
                            bdVar3.eV(this.gWF.get(i7).intValue());
                        }
                        bdVar3.aU(true);
                        bdVar3.a(dataRes.card_shipin_new.get(i7));
                        this.gWG.add(bdVar3);
                    }
                }
                this.gWJ = dataRes.enter_pop_info;
                if (dataRes.esport != null) {
                    this.gWK = new com.baidu.tieba.g.b();
                    this.gWK.a(dataRes.esport);
                }
                this.gWL = dataRes.agree_banner;
                if (dataRes.user_extend != null) {
                    this.gWQ = new com.baidu.tieba.frs.s();
                    this.gWQ.a(dataRes.user_extend);
                }
                this.gWM = dataRes.live_frs_notify;
                this.gWN = dataRes.frs_game_tab_info;
                this.gWO = dataRes.game_default_tab_id.intValue();
                this.gWP = dataRes.forum_head_icon;
                if (dataRes.video != null && dataRes.video.video_act != null) {
                    this.gWR = new k();
                    this.gWR.a(dataRes.video.video_act);
                }
                if (dataRes.info != null) {
                    this.recm_forum_list = dataRes.info.recm_forum_list;
                }
                this.gWU = dataRes.forum_ar_info;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public AgreeBanner btz() {
        return this.gWL;
    }

    public void a(AgreeBanner agreeBanner) {
        this.gWL = agreeBanner;
    }

    public ForumHeadIcon btA() {
        return this.gWP;
    }

    public void a(ForumHeadIcon forumHeadIcon) {
        this.gWP = forumHeadIcon;
    }

    public List<RecmForumInfo> btB() {
        return this.recm_forum_list;
    }

    private void vy(int i) {
        this.gWo = 1;
        if (this.gWm != null && this.gWm.size() > 0) {
            for (FrsTabInfo frsTabInfo : this.gWm) {
                if (frsTabInfo != null && frsTabInfo.tab_id.intValue() == i) {
                    this.gWo = i;
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
                bdVar.zC();
                if (bdVar.getFid() == 0 && j != 0) {
                    bdVar.setFid(j);
                }
                if (StringUtils.isNull(bdVar.yZ())) {
                    bdVar.cO(this.fDH.getName());
                }
                bdVar.j(this.gWk);
                if (bdVar.getThreadType() == 33 && !bdVar.zu()) {
                    ar arVar = new ar();
                    arVar.a(bdVar, 0);
                    arVar.B(btO());
                    if (appResponseToIntentClass) {
                        this.threadList.add(arVar);
                    }
                } else if (!TextUtils.isEmpty(bdVar.zM())) {
                    ab abVar = new ab();
                    abVar.cJ(bdVar.zM());
                    this.threadList.add(abVar);
                } else {
                    this.threadList.add(bdVar);
                }
            }
        }
    }

    public int btC() {
        return this.alaLiveCount;
    }

    public void vz(int i) {
        this.alaLiveCount = i;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] Mr() {
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

    public ForumData aYJ() {
        return this.fDH;
    }

    public int btD() {
        return this.gWD;
    }

    public void vA(int i) {
        this.gWD = i;
    }

    public int btE() {
        return this.gWE;
    }

    public void vB(int i) {
        this.gWE = i;
    }

    public void c(ForumData forumData) {
        this.fDH = forumData;
    }

    public ArrayList<com.baidu.adp.widget.ListView.i> getThreadList() {
        return this.threadList;
    }

    public void at(ArrayList<com.baidu.adp.widget.ListView.i> arrayList) {
        this.threadList = arrayList;
    }

    public AntiData xH() {
        return this.aLR;
    }

    public void c(AntiData antiData) {
        this.aLR = antiData;
    }

    public al xZ() {
        return this.eOI;
    }

    public void a(al alVar) {
        this.eOI = alVar;
    }

    public j btF() {
        return this.gVY;
    }

    public void a(j jVar) {
        this.gVY = jVar;
    }

    public com.baidu.tbadk.core.data.o btG() {
        return this.gWl;
    }

    public void a(com.baidu.tbadk.core.data.o oVar) {
        this.gWl = oVar;
    }

    public boolean btH() {
        return this.gVZ;
    }

    public void mw(boolean z) {
        this.gVZ = z;
    }

    public String btI() {
        return this.gWa;
    }

    public void st(String str) {
        this.gWa = str;
    }

    public m btJ() {
        return this.gWb;
    }

    public void a(m mVar) {
        this.gWb = mVar;
    }

    public UserData getUserData() {
        return this.fDO;
    }

    public void e(UserData userData) {
        this.fDO = userData;
    }

    public List<Long> btK() {
        return this.gVX;
    }

    public void di(List<Long> list) {
        this.gVX = list;
    }

    public b btL() {
        return this.gWc;
    }

    public void a(b bVar) {
        this.gWc = bVar;
    }

    public boolean btM() {
        return this.gWd;
    }

    public void mx(boolean z) {
        this.gWd = z;
    }

    public String getGameName() {
        return this.gameName;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public List<g> btN() {
        return this.gWe;
    }

    public void dj(List<g> list) {
        this.gWe = list;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public int aYY() {
        return this.gWf;
    }

    public void sw(int i) {
        this.gWf = i;
    }

    public List<PhotoLiveCardData> btO() {
        return this.gWg;
    }

    public String btP() {
        return this.gWj;
    }

    public void su(String str) {
        this.gWj = str;
    }

    public List<FrsTabInfo> btQ() {
        return this.gWm;
    }

    public void dk(List<FrsTabInfo> list) {
        this.gWm = list;
    }

    public void dl(List<PhotoLiveCardData> list) {
        this.gWg = list;
    }

    public boolean btR() {
        return this.gWi != null;
    }

    public PhotoLiveCardData btS() {
        return this.gWi;
    }

    public void b(PhotoLiveCardData photoLiveCardData) {
        this.gWi = photoLiveCardData;
    }

    public int btT() {
        return this.gWh;
    }

    public void vC(int i) {
        this.gWh = i;
    }

    public List<FeedForumData> btU() {
        return this.gWp;
    }

    public void dm(List<FeedForumData> list) {
        this.gWp = list;
    }

    public void sv(String str) {
        if (this.gWp != null && str != null) {
            for (FeedForumData feedForumData : this.gWp) {
                if (feedForumData != null && feedForumData.getForumId() != null && feedForumData.getForumId().equals(str)) {
                    this.gWp.remove(feedForumData);
                    return;
                }
            }
        }
    }

    public List<CategoryInfo> btV() {
        return this.gWq;
    }

    public void dn(List<CategoryInfo> list) {
        this.gWq = list;
    }

    public void sw(String str) {
        this.gWr = str;
    }

    public String btW() {
        return this.gWr;
    }

    public bd btX() {
        return this.gWy;
    }

    public void af(bd bdVar) {
        this.gWy = bdVar;
    }

    public int btY() {
        return this.gWo;
    }

    public void vD(int i) {
        this.gWo = i;
    }

    public com.baidu.tbadk.core.data.w btZ() {
        return this.gWs;
    }

    public void a(com.baidu.tbadk.core.data.w wVar) {
        this.gWs = wVar;
    }

    public com.baidu.tbadk.core.data.p bua() {
        return this.gWu;
    }

    public void a(com.baidu.tbadk.core.data.p pVar) {
        this.gWu = pVar;
    }

    public com.baidu.tbadk.core.data.r bub() {
        return this.gWx;
    }

    public void a(com.baidu.tbadk.core.data.r rVar) {
        this.gWx = rVar;
    }

    public int buc() {
        return this.gWA;
    }

    public void vE(int i) {
        this.gWA = i;
    }

    public au bud() {
        return this.gWz;
    }

    public void a(au auVar) {
        this.gWz = auVar;
    }

    public NavTabInfo bue() {
        return this.gWn;
    }

    public void a(NavTabInfo navTabInfo) {
        this.gWn = navTabInfo;
    }

    public com.baidu.tbadk.core.data.l buf() {
        return this.gWB;
    }

    public void a(com.baidu.tbadk.core.data.l lVar) {
        this.gWB = lVar;
    }

    public Integer bug() {
        return this.gWv;
    }

    public void j(Integer num) {
        this.gWv = num;
    }

    public List<Integer> buh() {
        return this.gWF;
    }

    /* renamed from: do  reason: not valid java name */
    public void m14do(List<Integer> list) {
        this.gWF = list;
    }

    public List<com.baidu.adp.widget.ListView.i> bui() {
        return this.gWG;
    }

    public void dp(List<com.baidu.adp.widget.ListView.i> list) {
        this.gWG = list;
    }

    public com.baidu.tieba.g.b buj() {
        return this.gWK;
    }

    public void a(com.baidu.tieba.g.b bVar) {
        this.gWK = bVar;
    }

    public AlaLiveNotify buk() {
        return this.gWM;
    }

    public void a(AlaLiveNotify alaLiveNotify) {
        this.gWM = alaLiveNotify;
    }

    public List<FrsTabInfo> bul() {
        return this.gWN;
    }

    public void dq(List<FrsTabInfo> list) {
        this.gWN = list;
    }

    public void vF(int i) {
        this.gWO = i;
    }

    public int bum() {
        return this.gWO;
    }

    public void a(com.baidu.tieba.frs.s sVar) {
        this.gWQ = sVar;
    }

    public com.baidu.tieba.frs.s bun() {
        return this.gWQ;
    }

    public k buo() {
        return this.gWR;
    }

    public void a(k kVar) {
        this.gWR = kVar;
    }

    public e bup() {
        return this.gWH;
    }

    public void b(e eVar) {
        this.gWH = eVar;
    }

    public f buq() {
        return this.gWI;
    }

    public void b(f fVar) {
        this.gWI = fVar;
    }
}

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
import com.baidu.tbadk.core.data.x;
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
import tbclient.FrsPage.StarRank;
import tbclient.FrsTabInfo;
import tbclient.PopInfo;
import tbclient.ThreadInfo;
import tbclient.User;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class i implements com.baidu.tbadk.mvc.b.c {
    public static final Wire WIRE = new Wire(new Class[0]);
    private AntiData aMZ;
    public ForumArIno dJn;
    protected al eSK;
    protected ForumData fGT;
    private UserData fHa;
    private bd gYC;
    private au gYD;
    private com.baidu.tbadk.core.data.l gYF;
    private List<Integer> gYJ;
    private List<com.baidu.adp.widget.ListView.i> gYK;
    private e gYL;
    private f gYM;
    public PopInfo gYN;
    private com.baidu.tieba.g.b gYO;
    private AgreeBanner gYP;
    private AlaLiveNotify gYQ;
    private List<FrsTabInfo> gYR;
    private ForumHeadIcon gYT;
    private com.baidu.tieba.frs.s gYU;
    private k gYV;
    public FrsTabInfo gYW;
    public StarRank gYY;
    protected List<Long> gYb;
    private j gYc;
    protected boolean gYd;
    protected String gYe;
    protected m gYf;
    private b gYg;
    private boolean gYh;
    private List<PhotoLiveCardData> gYk;
    private int gYl;
    private PhotoLiveCardData gYm;
    private String gYn;
    private List<FrsTabInfo> gYq;
    private NavTabInfo gYr;
    private List<FeedForumData> gYt;
    private List<CategoryInfo> gYu;
    private String gameName;
    private int mSortType;
    public List<RecmForumInfo> recm_forum_list;
    protected ArrayList<com.baidu.adp.widget.ListView.i> threadList;
    private HashMap<String, MetaData> userMap;
    public int gYa = 0;
    private List<g> gYi = new ArrayList();
    private int gYj = 0;
    private ArrayList<com.baidu.tbadk.core.data.n> gYo = new ArrayList<>();
    protected com.baidu.tbadk.core.data.o gYp = null;
    private int gYs = 1;
    private String gYv = null;
    private com.baidu.tbadk.core.data.w gYw = null;
    public x gYx = null;
    private com.baidu.tbadk.core.data.p gYy = null;
    private Integer gYz = -1;
    public com.baidu.tbadk.core.data.u gYA = null;
    private com.baidu.tbadk.core.data.r gYB = null;
    private int gYE = -1;
    protected List<com.baidu.adp.widget.ListView.i> gYG = null;
    private int gYH = 0;
    private int gYI = 0;
    private int alaLiveCount = 0;
    private int gYS = 0;
    public int gYX = 0;

    public i() {
        initData();
    }

    private void initData() {
        this.fGT = new ForumData();
        this.threadList = new ArrayList<>();
        this.gYG = new ArrayList();
        this.userMap = new HashMap<>();
        this.eSK = new al();
        this.gYc = new j();
        this.fHa = new UserData();
        this.gYf = new m();
        c(new AntiData());
        a(new b());
        this.gYK = new ArrayList();
        this.gYJ = new ArrayList();
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
                                this.gYo.add(nVar);
                            }
                        }
                    }
                }
                if (dataRes.activityhead != null && !com.baidu.tbadk.core.util.v.E(dataRes.activityhead.head_imgs)) {
                    this.gYp = new com.baidu.tbadk.core.data.o();
                    this.gYp.a(dataRes.activityhead);
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
                sA(dataRes.is_new_url.intValue());
                this.gYd = dataRes.fortune_bag.intValue() == 1;
                this.gYe = dataRes.fortune_desc;
                if (dataRes.forum != null) {
                    this.gYh = dataRes.forum.has_game.intValue() == 1;
                    this.gYn = dataRes.forum.game_url;
                    this.gameName = dataRes.forum.game_name;
                }
                List<StarEnter> list2 = dataRes.star_enter;
                this.gYi.clear();
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        g gVar = new g();
                        gVar.a(list2.get(i2));
                        this.gYi.add(gVar);
                    }
                }
                this.gYf.a(dataRes.gcon_account);
                this.fGT.parserProtobuf(dataRes.forum);
                long longValue = dataRes.forum != null ? dataRes.forum.id.longValue() : 0L;
                this.gYb = dataRes.thread_id_list;
                this.aMZ.parserProtobuf(dataRes.anti);
                if (dataRes.anti != null) {
                    com.baidu.tieba.p.a.e(dataRes.anti.block_pop_info);
                }
                this.gYg.a(dataRes.group);
                this.eSK.a(dataRes.page);
                this.gYc.a(dataRes.frs_star);
                this.fHa.parserProtobuf(dataRes.user);
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.fHa.getIsSelectTail());
                }
                this.gYq = dataRes.frs_tab_info;
                if (dataRes.nav_tab_info == null) {
                    NavTabInfo.Builder builder = new NavTabInfo.Builder();
                    builder.tab = dataRes.frs_tab_info;
                    this.gYr = builder.build(true);
                } else {
                    this.gYr = dataRes.nav_tab_info;
                }
                if (this.gYr.head != null && !com.baidu.tbadk.core.util.v.E(this.gYr.head)) {
                    this.gYW = this.gYr.head.get(0);
                }
                this.alaLiveCount = dataRes.ala_live_count.intValue();
                vz(dataRes.frs_tab_default.intValue());
                List<ZhiBoInfoTW> list3 = dataRes.twzhibo_info;
                if (list3 != null && list3.size() > 0) {
                    this.gYk = new ArrayList();
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
                        this.gYk.add(photoLiveCardData);
                    }
                }
                this.gYl = dataRes.twzhibo_pos.intValue();
                if (dataRes.hot_twzhibo_info != null) {
                    this.gYm = new PhotoLiveCardData();
                    if (this.gYm.getShowStyle() < 0) {
                        PhotoLiveCardData photoLiveCardData2 = this.gYm;
                        this.gYm.setShowStyle(PhotoLiveCardData.getRandom(3, -1));
                    }
                    this.gYm.getShowStyle();
                    this.gYm.parserProtobuf(dataRes.hot_twzhibo_info);
                    this.gYm.setShowExpressionViewIndexList(this.gYm.getExpressionDatas());
                }
                a(dataRes.thread_list, longValue);
                this.gYu = dataRes.category_list;
                if (!am.isEmpty(dataRes.bawu_enter_url)) {
                    this.gYv = dataRes.bawu_enter_url;
                }
                if (dataRes.head_sdk != null) {
                    this.gYw = new com.baidu.tbadk.core.data.w();
                    this.gYw.a(dataRes.head_sdk);
                }
                if (dataRes.recommend_book != null) {
                    this.gYx = new x();
                    this.gYx.a(dataRes.recommend_book);
                }
                if (dataRes.book_info != null) {
                    this.gYy = new com.baidu.tbadk.core.data.p();
                    this.gYy.a(dataRes.book_info);
                }
                if (dataRes.forum_present_info != null) {
                    this.gYA = new com.baidu.tbadk.core.data.u();
                    this.gYA.a(dataRes.forum_present_info);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.gYB = new com.baidu.tbadk.core.data.r();
                    this.gYB.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.card_shipin_info != null && dataRes.card_shipin_info.size() > 0) {
                    this.gYC = new bd();
                    this.gYC.aX(true);
                    this.gYC.eV(this.gYl);
                    this.gYC.setUserMap(this.userMap);
                    this.gYC.a(dataRes.card_shipin_info.get(0));
                    this.gYC.zW();
                    if (this.gYC.getFid() == 0 && longValue != 0) {
                        this.gYC.setFid(longValue);
                    }
                    this.gYC.j(this.gYo);
                    this.gYC.aW(!this.gYC.yU());
                    if (this.gYC.zn() != null && this.gYC.zn().getPendantData() == null && (metaData = this.userMap.get(this.gYC.zn().getUserId())) != null && metaData.getPendantData() != null) {
                        com.baidu.tbadk.data.h hVar = new com.baidu.tbadk.data.h();
                        hVar.ab(metaData.getPendantData().KD());
                        hVar.cX(metaData.getPendantData().ya());
                        this.gYC.zn().setPendantData(hVar);
                    }
                }
                if (dataRes.ala_live_insert != null && dataRes.ala_live_insert.ala_live_list != null && dataRes.ala_live_insert.ala_live_list.size() > 0) {
                    this.gYL = new e();
                    this.gYL.gXx = dataRes.ala_insert_floor.intValue();
                    ArrayList arrayList = new ArrayList();
                    for (int i5 = 0; i5 < dataRes.ala_live_insert.ala_live_list.size(); i5++) {
                        if (dataRes.ala_live_insert.ala_live_list.get(i5) != null) {
                            bd bdVar = new bd();
                            bdVar.a(dataRes.ala_live_insert.ala_live_list.get(i5));
                            arrayList.add(bdVar);
                        }
                    }
                    this.gYL.gXw = arrayList;
                }
                if (dataRes.ala_stage_list != null) {
                    this.gYM = new f();
                    ArrayList arrayList2 = new ArrayList();
                    for (int i6 = 0; i6 < dataRes.ala_stage_list.size(); i6++) {
                        if (dataRes.ala_stage_list.get(i6) != null) {
                            bd bdVar2 = new bd();
                            bdVar2.a(dataRes.ala_stage_list.get(i6));
                            arrayList2.add(bdVar2);
                        }
                    }
                    this.gYM.gXz = arrayList2;
                }
                if (dataRes.school_recom_info != null) {
                    this.gYE = dataRes.school_recom_pos.intValue();
                    this.gYD = new au();
                    this.gYD.a(dataRes.school_recom_info);
                }
                if (dataRes.carrier_enter != null) {
                    this.gYF = new com.baidu.tbadk.core.data.l();
                    this.gYF.a(dataRes.carrier_enter);
                }
                if (dataRes.vitality_info != null && dataRes.vitality_info.frequently_forum_info != null) {
                    this.gYH = dataRes.vitality_info.frequently_forum_info.forum_state.intValue();
                    this.gYI = dataRes.vitality_info.frequently_forum_info.access_flag.intValue();
                }
                this.mSortType = dataRes.sort_type.intValue();
                this.gYa = dataRes.need_log.intValue();
                com.baidu.tieba.recapp.d.a.boR().rV(dataRes.asp_shown_info);
                this.gYJ = dataRes.card_shipin_pos;
                if (dataRes.card_shipin_new != null) {
                    for (int i7 = 0; i7 < dataRes.card_shipin_new.size(); i7++) {
                        bd bdVar3 = new bd();
                        if (this.gYJ != null && this.gYJ.size() >= dataRes.card_shipin_new.size()) {
                            bdVar3.eV(this.gYJ.get(i7).intValue());
                        }
                        bdVar3.aX(true);
                        bdVar3.a(dataRes.card_shipin_new.get(i7));
                        this.gYK.add(bdVar3);
                    }
                }
                this.gYN = dataRes.enter_pop_info;
                if (dataRes.esport != null) {
                    this.gYO = new com.baidu.tieba.g.b();
                    this.gYO.a(dataRes.esport);
                }
                this.gYP = dataRes.agree_banner;
                if (dataRes.user_extend != null) {
                    this.gYU = new com.baidu.tieba.frs.s();
                    this.gYU.a(dataRes.user_extend);
                }
                this.gYQ = dataRes.live_frs_notify;
                this.gYR = dataRes.frs_game_tab_info;
                this.gYS = dataRes.game_default_tab_id.intValue();
                this.gYT = dataRes.forum_head_icon;
                if (dataRes.video != null && dataRes.video.video_act != null) {
                    this.gYV = new k();
                    this.gYV.a(dataRes.video.video_act);
                }
                if (dataRes.info != null) {
                    this.recm_forum_list = dataRes.info.recm_forum_list;
                }
                this.dJn = dataRes.forum_ar_info;
                if (dataRes.star_rank_info != null) {
                    this.gYY = dataRes.star_rank_info;
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public AgreeBanner buN() {
        return this.gYP;
    }

    public void a(AgreeBanner agreeBanner) {
        this.gYP = agreeBanner;
    }

    public ForumHeadIcon buO() {
        return this.gYT;
    }

    public void a(ForumHeadIcon forumHeadIcon) {
        this.gYT = forumHeadIcon;
    }

    public List<RecmForumInfo> buP() {
        return this.recm_forum_list;
    }

    private void vz(int i) {
        this.gYs = 1;
        if (this.gYq != null && this.gYq.size() > 0) {
            for (FrsTabInfo frsTabInfo : this.gYq) {
                if (frsTabInfo != null && frsTabInfo.tab_id.intValue() == i) {
                    this.gYs = i;
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
                bdVar.zW();
                if (bdVar.getFid() == 0 && j != 0) {
                    bdVar.setFid(j);
                }
                if (StringUtils.isNull(bdVar.zt())) {
                    bdVar.cZ(this.fGT.getName());
                }
                bdVar.j(this.gYo);
                if (bdVar.getThreadType() == 33 && !bdVar.zO()) {
                    ar arVar = new ar();
                    arVar.a(bdVar, 0);
                    arVar.B(bvc());
                    if (appResponseToIntentClass) {
                        this.threadList.add(arVar);
                    }
                } else if (!TextUtils.isEmpty(bdVar.Af())) {
                    ab abVar = new ab();
                    abVar.cU(bdVar.Af());
                    this.threadList.add(abVar);
                } else {
                    this.threadList.add(bdVar);
                }
            }
        }
    }

    public int buQ() {
        return this.alaLiveCount;
    }

    public void vA(int i) {
        this.alaLiveCount = i;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] MW() {
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
    public void o(JSONObject jSONObject) {
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void a(Message message) {
    }

    public ForumData bar() {
        return this.fGT;
    }

    public int buR() {
        return this.gYH;
    }

    public void vB(int i) {
        this.gYH = i;
    }

    public int buS() {
        return this.gYI;
    }

    public void vC(int i) {
        this.gYI = i;
    }

    public void c(ForumData forumData) {
        this.fGT = forumData;
    }

    public ArrayList<com.baidu.adp.widget.ListView.i> getThreadList() {
        return this.threadList;
    }

    public void au(ArrayList<com.baidu.adp.widget.ListView.i> arrayList) {
        this.threadList = arrayList;
    }

    public AntiData yn() {
        return this.aMZ;
    }

    public void c(AntiData antiData) {
        this.aMZ = antiData;
    }

    public al yA() {
        return this.eSK;
    }

    public void a(al alVar) {
        this.eSK = alVar;
    }

    public j buT() {
        return this.gYc;
    }

    public void a(j jVar) {
        this.gYc = jVar;
    }

    public com.baidu.tbadk.core.data.o buU() {
        return this.gYp;
    }

    public void a(com.baidu.tbadk.core.data.o oVar) {
        this.gYp = oVar;
    }

    public boolean buV() {
        return this.gYd;
    }

    public void mD(boolean z) {
        this.gYd = z;
    }

    public String buW() {
        return this.gYe;
    }

    public void sA(String str) {
        this.gYe = str;
    }

    public m buX() {
        return this.gYf;
    }

    public void a(m mVar) {
        this.gYf = mVar;
    }

    public UserData getUserData() {
        return this.fHa;
    }

    public void e(UserData userData) {
        this.fHa = userData;
    }

    public List<Long> buY() {
        return this.gYb;
    }

    /* renamed from: do  reason: not valid java name */
    public void m18do(List<Long> list) {
        this.gYb = list;
    }

    public b buZ() {
        return this.gYg;
    }

    public void a(b bVar) {
        this.gYg = bVar;
    }

    public boolean bva() {
        return this.gYh;
    }

    public void mE(boolean z) {
        this.gYh = z;
    }

    public String getGameName() {
        return this.gameName;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public List<g> bvb() {
        return this.gYi;
    }

    public void dp(List<g> list) {
        this.gYi = list;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public int baG() {
        return this.gYj;
    }

    public void sA(int i) {
        this.gYj = i;
    }

    public List<PhotoLiveCardData> bvc() {
        return this.gYk;
    }

    public String bvd() {
        return this.gYn;
    }

    public void sB(String str) {
        this.gYn = str;
    }

    public List<FrsTabInfo> bve() {
        return this.gYq;
    }

    public void dq(List<FrsTabInfo> list) {
        this.gYq = list;
    }

    public void dr(List<PhotoLiveCardData> list) {
        this.gYk = list;
    }

    public boolean bvf() {
        return this.gYm != null;
    }

    public PhotoLiveCardData bvg() {
        return this.gYm;
    }

    public void b(PhotoLiveCardData photoLiveCardData) {
        this.gYm = photoLiveCardData;
    }

    public int bvh() {
        return this.gYl;
    }

    public void vD(int i) {
        this.gYl = i;
    }

    public List<FeedForumData> bvi() {
        return this.gYt;
    }

    public void ds(List<FeedForumData> list) {
        this.gYt = list;
    }

    public void sC(String str) {
        if (this.gYt != null && str != null) {
            for (FeedForumData feedForumData : this.gYt) {
                if (feedForumData != null && feedForumData.getForumId() != null && feedForumData.getForumId().equals(str)) {
                    this.gYt.remove(feedForumData);
                    return;
                }
            }
        }
    }

    public List<CategoryInfo> bvj() {
        return this.gYu;
    }

    public void dt(List<CategoryInfo> list) {
        this.gYu = list;
    }

    public void sD(String str) {
        this.gYv = str;
    }

    public String bvk() {
        return this.gYv;
    }

    public bd bvl() {
        return this.gYC;
    }

    public void ai(bd bdVar) {
        this.gYC = bdVar;
    }

    public int bvm() {
        return this.gYs;
    }

    public void vE(int i) {
        this.gYs = i;
    }

    public com.baidu.tbadk.core.data.w bvn() {
        return this.gYw;
    }

    public void a(com.baidu.tbadk.core.data.w wVar) {
        this.gYw = wVar;
    }

    public com.baidu.tbadk.core.data.p bvo() {
        return this.gYy;
    }

    public void a(com.baidu.tbadk.core.data.p pVar) {
        this.gYy = pVar;
    }

    public com.baidu.tbadk.core.data.r bvp() {
        return this.gYB;
    }

    public void a(com.baidu.tbadk.core.data.r rVar) {
        this.gYB = rVar;
    }

    public int bvq() {
        return this.gYE;
    }

    public void vF(int i) {
        this.gYE = i;
    }

    public au bvr() {
        return this.gYD;
    }

    public void a(au auVar) {
        this.gYD = auVar;
    }

    public NavTabInfo bvs() {
        return this.gYr;
    }

    public void a(NavTabInfo navTabInfo) {
        this.gYr = navTabInfo;
    }

    public com.baidu.tbadk.core.data.l bvt() {
        return this.gYF;
    }

    public void a(com.baidu.tbadk.core.data.l lVar) {
        this.gYF = lVar;
    }

    public Integer bvu() {
        return this.gYz;
    }

    public void j(Integer num) {
        this.gYz = num;
    }

    public List<Integer> bvv() {
        return this.gYJ;
    }

    public void du(List<Integer> list) {
        this.gYJ = list;
    }

    public List<com.baidu.adp.widget.ListView.i> bvw() {
        return this.gYK;
    }

    public void dv(List<com.baidu.adp.widget.ListView.i> list) {
        this.gYK = list;
    }

    public com.baidu.tieba.g.b bvx() {
        return this.gYO;
    }

    public void a(com.baidu.tieba.g.b bVar) {
        this.gYO = bVar;
    }

    public AlaLiveNotify bvy() {
        return this.gYQ;
    }

    public void a(AlaLiveNotify alaLiveNotify) {
        this.gYQ = alaLiveNotify;
    }

    public List<FrsTabInfo> bvz() {
        return this.gYR;
    }

    public void dw(List<FrsTabInfo> list) {
        this.gYR = list;
    }

    public void vG(int i) {
        this.gYS = i;
    }

    public int bvA() {
        return this.gYS;
    }

    public void a(com.baidu.tieba.frs.s sVar) {
        this.gYU = sVar;
    }

    public com.baidu.tieba.frs.s bvB() {
        return this.gYU;
    }

    public k bvC() {
        return this.gYV;
    }

    public void a(k kVar) {
        this.gYV = kVar;
    }

    public e bvD() {
        return this.gYL;
    }

    public void b(e eVar) {
        this.gYL = eVar;
    }

    public f bvE() {
        return this.gYM;
    }

    public void b(f fVar) {
        this.gYM = fVar;
    }
}

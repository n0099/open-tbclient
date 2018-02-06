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
    private AntiData aNk;
    public ForumArIno dJz;
    protected al eSW;
    protected ForumData fHe;
    private UserData fHl;
    private int gYA;
    private PhotoLiveCardData gYB;
    private String gYC;
    private List<FrsTabInfo> gYF;
    private NavTabInfo gYG;
    private List<FeedForumData> gYI;
    private List<CategoryInfo> gYJ;
    private bd gYR;
    private au gYS;
    private com.baidu.tbadk.core.data.l gYU;
    private List<Integer> gYY;
    private List<com.baidu.adp.widget.ListView.i> gYZ;
    protected List<Long> gYq;
    private j gYr;
    protected boolean gYs;
    protected String gYt;
    protected m gYu;
    private b gYv;
    private boolean gYw;
    private List<PhotoLiveCardData> gYz;
    private e gZa;
    private f gZb;
    public PopInfo gZc;
    private com.baidu.tieba.g.b gZd;
    private AgreeBanner gZe;
    private AlaLiveNotify gZf;
    private List<FrsTabInfo> gZg;
    private ForumHeadIcon gZi;
    private com.baidu.tieba.frs.s gZj;
    private k gZk;
    public FrsTabInfo gZl;
    public StarRank gZn;
    private String gameName;
    private int mSortType;
    public List<RecmForumInfo> recm_forum_list;
    protected ArrayList<com.baidu.adp.widget.ListView.i> threadList;
    private HashMap<String, MetaData> userMap;
    public int gYp = 0;
    private List<g> gYx = new ArrayList();
    private int gYy = 0;
    private ArrayList<com.baidu.tbadk.core.data.n> gYD = new ArrayList<>();
    protected com.baidu.tbadk.core.data.o gYE = null;
    private int gYH = 1;
    private String gYK = null;
    private com.baidu.tbadk.core.data.w gYL = null;
    public x gYM = null;
    private com.baidu.tbadk.core.data.p gYN = null;
    private Integer gYO = -1;
    public com.baidu.tbadk.core.data.u gYP = null;
    private com.baidu.tbadk.core.data.r gYQ = null;
    private int gYT = -1;
    protected List<com.baidu.adp.widget.ListView.i> gYV = null;
    private int gYW = 0;
    private int gYX = 0;
    private int alaLiveCount = 0;
    private int gZh = 0;
    public int gZm = 0;

    public i() {
        initData();
    }

    private void initData() {
        this.fHe = new ForumData();
        this.threadList = new ArrayList<>();
        this.gYV = new ArrayList();
        this.userMap = new HashMap<>();
        this.eSW = new al();
        this.gYr = new j();
        this.fHl = new UserData();
        this.gYu = new m();
        c(new AntiData());
        a(new b());
        this.gYZ = new ArrayList();
        this.gYY = new ArrayList();
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
                                this.gYD.add(nVar);
                            }
                        }
                    }
                }
                if (dataRes.activityhead != null && !com.baidu.tbadk.core.util.v.E(dataRes.activityhead.head_imgs)) {
                    this.gYE = new com.baidu.tbadk.core.data.o();
                    this.gYE.a(dataRes.activityhead);
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
                sz(dataRes.is_new_url.intValue());
                this.gYs = dataRes.fortune_bag.intValue() == 1;
                this.gYt = dataRes.fortune_desc;
                if (dataRes.forum != null) {
                    this.gYw = dataRes.forum.has_game.intValue() == 1;
                    this.gYC = dataRes.forum.game_url;
                    this.gameName = dataRes.forum.game_name;
                }
                List<StarEnter> list2 = dataRes.star_enter;
                this.gYx.clear();
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        g gVar = new g();
                        gVar.a(list2.get(i2));
                        this.gYx.add(gVar);
                    }
                }
                this.gYu.a(dataRes.gcon_account);
                this.fHe.parserProtobuf(dataRes.forum);
                long longValue = dataRes.forum != null ? dataRes.forum.id.longValue() : 0L;
                this.gYq = dataRes.thread_id_list;
                this.aNk.parserProtobuf(dataRes.anti);
                if (dataRes.anti != null) {
                    com.baidu.tieba.p.a.e(dataRes.anti.block_pop_info);
                }
                this.gYv.a(dataRes.group);
                this.eSW.a(dataRes.page);
                this.gYr.a(dataRes.frs_star);
                this.fHl.parserProtobuf(dataRes.user);
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.fHl.getIsSelectTail());
                }
                this.gYF = dataRes.frs_tab_info;
                if (dataRes.nav_tab_info == null) {
                    NavTabInfo.Builder builder = new NavTabInfo.Builder();
                    builder.tab = dataRes.frs_tab_info;
                    this.gYG = builder.build(true);
                } else {
                    this.gYG = dataRes.nav_tab_info;
                }
                if (this.gYG.head != null && !com.baidu.tbadk.core.util.v.E(this.gYG.head)) {
                    this.gZl = this.gYG.head.get(0);
                }
                this.alaLiveCount = dataRes.ala_live_count.intValue();
                vy(dataRes.frs_tab_default.intValue());
                List<ZhiBoInfoTW> list3 = dataRes.twzhibo_info;
                if (list3 != null && list3.size() > 0) {
                    this.gYz = new ArrayList();
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
                        this.gYz.add(photoLiveCardData);
                    }
                }
                this.gYA = dataRes.twzhibo_pos.intValue();
                if (dataRes.hot_twzhibo_info != null) {
                    this.gYB = new PhotoLiveCardData();
                    if (this.gYB.getShowStyle() < 0) {
                        PhotoLiveCardData photoLiveCardData2 = this.gYB;
                        this.gYB.setShowStyle(PhotoLiveCardData.getRandom(3, -1));
                    }
                    this.gYB.getShowStyle();
                    this.gYB.parserProtobuf(dataRes.hot_twzhibo_info);
                    this.gYB.setShowExpressionViewIndexList(this.gYB.getExpressionDatas());
                }
                a(dataRes.thread_list, longValue);
                this.gYJ = dataRes.category_list;
                if (!am.isEmpty(dataRes.bawu_enter_url)) {
                    this.gYK = dataRes.bawu_enter_url;
                }
                if (dataRes.head_sdk != null) {
                    this.gYL = new com.baidu.tbadk.core.data.w();
                    this.gYL.a(dataRes.head_sdk);
                }
                if (dataRes.recommend_book != null) {
                    this.gYM = new x();
                    this.gYM.a(dataRes.recommend_book);
                }
                if (dataRes.book_info != null) {
                    this.gYN = new com.baidu.tbadk.core.data.p();
                    this.gYN.a(dataRes.book_info);
                }
                if (dataRes.forum_present_info != null) {
                    this.gYP = new com.baidu.tbadk.core.data.u();
                    this.gYP.a(dataRes.forum_present_info);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.gYQ = new com.baidu.tbadk.core.data.r();
                    this.gYQ.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.card_shipin_info != null && dataRes.card_shipin_info.size() > 0) {
                    this.gYR = new bd();
                    this.gYR.aX(true);
                    this.gYR.eV(this.gYA);
                    this.gYR.setUserMap(this.userMap);
                    this.gYR.a(dataRes.card_shipin_info.get(0));
                    this.gYR.zW();
                    if (this.gYR.getFid() == 0 && longValue != 0) {
                        this.gYR.setFid(longValue);
                    }
                    this.gYR.j(this.gYD);
                    this.gYR.aW(!this.gYR.yU());
                    if (this.gYR.zn() != null && this.gYR.zn().getPendantData() == null && (metaData = this.userMap.get(this.gYR.zn().getUserId())) != null && metaData.getPendantData() != null) {
                        com.baidu.tbadk.data.h hVar = new com.baidu.tbadk.data.h();
                        hVar.ab(metaData.getPendantData().KE());
                        hVar.cX(metaData.getPendantData().ya());
                        this.gYR.zn().setPendantData(hVar);
                    }
                }
                if (dataRes.ala_live_insert != null && dataRes.ala_live_insert.ala_live_list != null && dataRes.ala_live_insert.ala_live_list.size() > 0) {
                    this.gZa = new e();
                    this.gZa.gXM = dataRes.ala_insert_floor.intValue();
                    ArrayList arrayList = new ArrayList();
                    for (int i5 = 0; i5 < dataRes.ala_live_insert.ala_live_list.size(); i5++) {
                        if (dataRes.ala_live_insert.ala_live_list.get(i5) != null) {
                            bd bdVar = new bd();
                            bdVar.a(dataRes.ala_live_insert.ala_live_list.get(i5));
                            arrayList.add(bdVar);
                        }
                    }
                    this.gZa.gXL = arrayList;
                }
                if (dataRes.ala_stage_list != null) {
                    this.gZb = new f();
                    ArrayList arrayList2 = new ArrayList();
                    for (int i6 = 0; i6 < dataRes.ala_stage_list.size(); i6++) {
                        if (dataRes.ala_stage_list.get(i6) != null) {
                            bd bdVar2 = new bd();
                            bdVar2.a(dataRes.ala_stage_list.get(i6));
                            arrayList2.add(bdVar2);
                        }
                    }
                    this.gZb.gXO = arrayList2;
                }
                if (dataRes.school_recom_info != null) {
                    this.gYT = dataRes.school_recom_pos.intValue();
                    this.gYS = new au();
                    this.gYS.a(dataRes.school_recom_info);
                }
                if (dataRes.carrier_enter != null) {
                    this.gYU = new com.baidu.tbadk.core.data.l();
                    this.gYU.a(dataRes.carrier_enter);
                }
                if (dataRes.vitality_info != null && dataRes.vitality_info.frequently_forum_info != null) {
                    this.gYW = dataRes.vitality_info.frequently_forum_info.forum_state.intValue();
                    this.gYX = dataRes.vitality_info.frequently_forum_info.access_flag.intValue();
                }
                this.mSortType = dataRes.sort_type.intValue();
                this.gYp = dataRes.need_log.intValue();
                com.baidu.tieba.recapp.d.a.boS().rV(dataRes.asp_shown_info);
                this.gYY = dataRes.card_shipin_pos;
                if (dataRes.card_shipin_new != null) {
                    for (int i7 = 0; i7 < dataRes.card_shipin_new.size(); i7++) {
                        bd bdVar3 = new bd();
                        if (this.gYY != null && this.gYY.size() >= dataRes.card_shipin_new.size()) {
                            bdVar3.eV(this.gYY.get(i7).intValue());
                        }
                        bdVar3.aX(true);
                        bdVar3.a(dataRes.card_shipin_new.get(i7));
                        this.gYZ.add(bdVar3);
                    }
                }
                this.gZc = dataRes.enter_pop_info;
                if (dataRes.esport != null) {
                    this.gZd = new com.baidu.tieba.g.b();
                    this.gZd.a(dataRes.esport);
                }
                this.gZe = dataRes.agree_banner;
                if (dataRes.user_extend != null) {
                    this.gZj = new com.baidu.tieba.frs.s();
                    this.gZj.a(dataRes.user_extend);
                }
                this.gZf = dataRes.live_frs_notify;
                this.gZg = dataRes.frs_game_tab_info;
                this.gZh = dataRes.game_default_tab_id.intValue();
                this.gZi = dataRes.forum_head_icon;
                if (dataRes.video != null && dataRes.video.video_act != null) {
                    this.gZk = new k();
                    this.gZk.a(dataRes.video.video_act);
                }
                if (dataRes.info != null) {
                    this.recm_forum_list = dataRes.info.recm_forum_list;
                }
                this.dJz = dataRes.forum_ar_info;
                if (dataRes.star_rank_info != null) {
                    this.gZn = dataRes.star_rank_info;
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public AgreeBanner buO() {
        return this.gZe;
    }

    public void a(AgreeBanner agreeBanner) {
        this.gZe = agreeBanner;
    }

    public ForumHeadIcon buP() {
        return this.gZi;
    }

    public void a(ForumHeadIcon forumHeadIcon) {
        this.gZi = forumHeadIcon;
    }

    public List<RecmForumInfo> buQ() {
        return this.recm_forum_list;
    }

    private void vy(int i) {
        this.gYH = 1;
        if (this.gYF != null && this.gYF.size() > 0) {
            for (FrsTabInfo frsTabInfo : this.gYF) {
                if (frsTabInfo != null && frsTabInfo.tab_id.intValue() == i) {
                    this.gYH = i;
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
                    bdVar.cZ(this.fHe.getName());
                }
                bdVar.j(this.gYD);
                if (bdVar.getThreadType() == 33 && !bdVar.zO()) {
                    ar arVar = new ar();
                    arVar.a(bdVar, 0);
                    arVar.B(bvd());
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

    public int buR() {
        return this.alaLiveCount;
    }

    public void vz(int i) {
        this.alaLiveCount = i;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] MX() {
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

    public ForumData bas() {
        return this.fHe;
    }

    public int buS() {
        return this.gYW;
    }

    public void vA(int i) {
        this.gYW = i;
    }

    public int buT() {
        return this.gYX;
    }

    public void vB(int i) {
        this.gYX = i;
    }

    public void c(ForumData forumData) {
        this.fHe = forumData;
    }

    public ArrayList<com.baidu.adp.widget.ListView.i> getThreadList() {
        return this.threadList;
    }

    public void au(ArrayList<com.baidu.adp.widget.ListView.i> arrayList) {
        this.threadList = arrayList;
    }

    public AntiData yn() {
        return this.aNk;
    }

    public void c(AntiData antiData) {
        this.aNk = antiData;
    }

    public al yA() {
        return this.eSW;
    }

    public void a(al alVar) {
        this.eSW = alVar;
    }

    public j buU() {
        return this.gYr;
    }

    public void a(j jVar) {
        this.gYr = jVar;
    }

    public com.baidu.tbadk.core.data.o buV() {
        return this.gYE;
    }

    public void a(com.baidu.tbadk.core.data.o oVar) {
        this.gYE = oVar;
    }

    public boolean buW() {
        return this.gYs;
    }

    public void mD(boolean z) {
        this.gYs = z;
    }

    public String buX() {
        return this.gYt;
    }

    public void sA(String str) {
        this.gYt = str;
    }

    public m buY() {
        return this.gYu;
    }

    public void a(m mVar) {
        this.gYu = mVar;
    }

    public UserData getUserData() {
        return this.fHl;
    }

    public void e(UserData userData) {
        this.fHl = userData;
    }

    public List<Long> buZ() {
        return this.gYq;
    }

    /* renamed from: do  reason: not valid java name */
    public void m18do(List<Long> list) {
        this.gYq = list;
    }

    public b bva() {
        return this.gYv;
    }

    public void a(b bVar) {
        this.gYv = bVar;
    }

    public boolean bvb() {
        return this.gYw;
    }

    public void mE(boolean z) {
        this.gYw = z;
    }

    public String getGameName() {
        return this.gameName;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public List<g> bvc() {
        return this.gYx;
    }

    public void dp(List<g> list) {
        this.gYx = list;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public int baH() {
        return this.gYy;
    }

    public void sz(int i) {
        this.gYy = i;
    }

    public List<PhotoLiveCardData> bvd() {
        return this.gYz;
    }

    public String bve() {
        return this.gYC;
    }

    public void sB(String str) {
        this.gYC = str;
    }

    public List<FrsTabInfo> bvf() {
        return this.gYF;
    }

    public void dq(List<FrsTabInfo> list) {
        this.gYF = list;
    }

    public void dr(List<PhotoLiveCardData> list) {
        this.gYz = list;
    }

    public boolean bvg() {
        return this.gYB != null;
    }

    public PhotoLiveCardData bvh() {
        return this.gYB;
    }

    public void b(PhotoLiveCardData photoLiveCardData) {
        this.gYB = photoLiveCardData;
    }

    public int bvi() {
        return this.gYA;
    }

    public void vC(int i) {
        this.gYA = i;
    }

    public List<FeedForumData> bvj() {
        return this.gYI;
    }

    public void ds(List<FeedForumData> list) {
        this.gYI = list;
    }

    public void sC(String str) {
        if (this.gYI != null && str != null) {
            for (FeedForumData feedForumData : this.gYI) {
                if (feedForumData != null && feedForumData.getForumId() != null && feedForumData.getForumId().equals(str)) {
                    this.gYI.remove(feedForumData);
                    return;
                }
            }
        }
    }

    public List<CategoryInfo> bvk() {
        return this.gYJ;
    }

    public void dt(List<CategoryInfo> list) {
        this.gYJ = list;
    }

    public void sD(String str) {
        this.gYK = str;
    }

    public String bvl() {
        return this.gYK;
    }

    public bd bvm() {
        return this.gYR;
    }

    public void ai(bd bdVar) {
        this.gYR = bdVar;
    }

    public int bvn() {
        return this.gYH;
    }

    public void vD(int i) {
        this.gYH = i;
    }

    public com.baidu.tbadk.core.data.w bvo() {
        return this.gYL;
    }

    public void a(com.baidu.tbadk.core.data.w wVar) {
        this.gYL = wVar;
    }

    public com.baidu.tbadk.core.data.p bvp() {
        return this.gYN;
    }

    public void a(com.baidu.tbadk.core.data.p pVar) {
        this.gYN = pVar;
    }

    public com.baidu.tbadk.core.data.r bvq() {
        return this.gYQ;
    }

    public void a(com.baidu.tbadk.core.data.r rVar) {
        this.gYQ = rVar;
    }

    public int bvr() {
        return this.gYT;
    }

    public void vE(int i) {
        this.gYT = i;
    }

    public au bvs() {
        return this.gYS;
    }

    public void a(au auVar) {
        this.gYS = auVar;
    }

    public NavTabInfo bvt() {
        return this.gYG;
    }

    public void a(NavTabInfo navTabInfo) {
        this.gYG = navTabInfo;
    }

    public com.baidu.tbadk.core.data.l bvu() {
        return this.gYU;
    }

    public void a(com.baidu.tbadk.core.data.l lVar) {
        this.gYU = lVar;
    }

    public Integer bvv() {
        return this.gYO;
    }

    public void j(Integer num) {
        this.gYO = num;
    }

    public List<Integer> bvw() {
        return this.gYY;
    }

    public void du(List<Integer> list) {
        this.gYY = list;
    }

    public List<com.baidu.adp.widget.ListView.i> bvx() {
        return this.gYZ;
    }

    public void dv(List<com.baidu.adp.widget.ListView.i> list) {
        this.gYZ = list;
    }

    public com.baidu.tieba.g.b bvy() {
        return this.gZd;
    }

    public void a(com.baidu.tieba.g.b bVar) {
        this.gZd = bVar;
    }

    public AlaLiveNotify bvz() {
        return this.gZf;
    }

    public void a(AlaLiveNotify alaLiveNotify) {
        this.gZf = alaLiveNotify;
    }

    public List<FrsTabInfo> bvA() {
        return this.gZg;
    }

    public void dw(List<FrsTabInfo> list) {
        this.gZg = list;
    }

    public void vF(int i) {
        this.gZh = i;
    }

    public int bvB() {
        return this.gZh;
    }

    public void a(com.baidu.tieba.frs.s sVar) {
        this.gZj = sVar;
    }

    public com.baidu.tieba.frs.s bvC() {
        return this.gZj;
    }

    public k bvD() {
        return this.gZk;
    }

    public void a(k kVar) {
        this.gZk = kVar;
    }

    public e bvE() {
        return this.gZa;
    }

    public void b(e eVar) {
        this.gZa = eVar;
    }

    public f bvF() {
        return this.gZb;
    }

    public void b(f fVar) {
        this.gZb = fVar;
    }
}

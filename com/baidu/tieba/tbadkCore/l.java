package com.baidu.tieba.tbadkCore;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.BannerThreadInfoData;
import com.baidu.tbadk.core.data.FeedForumData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PhotoLiveCardData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.ao;
import com.baidu.tbadk.core.data.au;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.at;
import com.squareup.wire.Message;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;
import tbclient.CategoryInfo;
import tbclient.FrsPage.ColorEgg;
import tbclient.FrsPage.DataRes;
import tbclient.FrsPage.FrsPageResIdl;
import tbclient.FrsPage.NavTabInfo;
import tbclient.FrsPage.StarEnter;
import tbclient.FrsTabInfo;
import tbclient.PopInfo;
import tbclient.ThreadInfo;
import tbclient.User;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class l implements com.baidu.tbadk.mvc.b.c {
    public static final Wire WIRE = new Wire(new Class[0]);
    private AntiData Rl;
    protected ao djY;
    protected ForumData efp;
    private UserData efv;
    private com.baidu.tbadk.core.data.y fnA;
    private List<FrsTabInfo> fnC;
    private NavTabInfo fnD;
    private List<FeedForumData> fnF;
    private List<CategoryInfo> fnG;
    private bh fnO;
    private ax fnP;
    private com.baidu.tbadk.core.data.n fnR;
    private List<Integer> fnW;
    private List<com.baidu.adp.widget.ListView.v> fnX;
    public PopInfo fnZ;
    protected List<Long> fnl;
    private m fnm;
    protected boolean fnn;
    protected String fno;
    protected o fnp;
    private b fnq;
    private boolean fnr;
    private List<PhotoLiveCardData> fnu;
    private int fnv;
    private PhotoLiveCardData fnw;
    private String fnx;
    private com.baidu.tbadk.core.data.aa fnz;
    private String gameName;
    private int mSortType;
    protected ArrayList<com.baidu.adp.widget.ListView.v> threadList;
    private HashMap<String, MetaData> userMap;
    public int fnk = 0;
    private List<g> fns = new ArrayList();
    private int fnt = 0;
    private ArrayList<com.baidu.tbadk.core.data.p> fny = new ArrayList<>();
    protected com.baidu.tbadk.core.data.q fnB = null;
    private int fnE = 1;
    private String fnH = null;
    private com.baidu.tbadk.core.data.x fnI = null;
    public com.baidu.tbadk.core.data.z fnJ = null;
    private com.baidu.tbadk.core.data.r fnK = null;
    private Integer fnL = -1;
    public com.baidu.tbadk.core.data.v fnM = null;
    private com.baidu.tbadk.core.data.t fnN = null;
    private int fnQ = -1;
    protected List<com.baidu.adp.widget.ListView.v> fnS = null;
    private List<BannerThreadInfoData> fnT = null;
    private int fnU = 0;
    private int fnV = 0;
    private boolean isShowDriftingBottle = false;
    private long fnY = 0;
    private int alaLiveCount = 0;

    public l() {
        initData();
    }

    private void initData() {
        this.efp = new ForumData();
        this.threadList = new ArrayList<>();
        this.fnS = new ArrayList();
        this.userMap = new HashMap<>();
        this.djY = new ao();
        this.fnm = new m();
        this.efv = new UserData();
        this.fnp = new o();
        d(new AntiData());
        a(new b());
        this.fnT = new ArrayList();
        this.fnX = new ArrayList();
        this.fnW = new ArrayList();
    }

    public FrsPageResIdl D(byte[] bArr) {
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
                if (!com.baidu.tbadk.core.util.w.s(dataRes.color_egg)) {
                    for (ColorEgg colorEgg : dataRes.color_egg) {
                        if (colorEgg != null && !com.baidu.tbadk.core.util.w.s(colorEgg.holiday_words)) {
                            com.baidu.tbadk.core.data.p pVar = new com.baidu.tbadk.core.data.p();
                            if (pVar.a(colorEgg)) {
                                this.fny.add(pVar);
                            }
                        }
                    }
                }
                if (dataRes.activityhead != null && !com.baidu.tbadk.core.util.w.s(dataRes.activityhead.head_imgs)) {
                    this.fnB = new com.baidu.tbadk.core.data.q();
                    this.fnB.a(dataRes.activityhead);
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
                mr(dataRes.is_new_url.intValue());
                this.fnn = dataRes.fortune_bag.intValue() == 1;
                this.fno = dataRes.fortune_desc;
                if (dataRes.forum != null) {
                    this.fnr = dataRes.forum.has_game.intValue() == 1;
                    this.fnx = dataRes.forum.game_url;
                    this.gameName = dataRes.forum.game_name;
                }
                List<StarEnter> list2 = dataRes.star_enter;
                this.fns.clear();
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        g gVar = new g();
                        gVar.a(list2.get(i2));
                        this.fns.add(gVar);
                    }
                }
                this.fnp.a(dataRes.gcon_account);
                this.efp.parserProtobuf(dataRes.forum);
                long longValue = dataRes.forum != null ? dataRes.forum.id.longValue() : 0L;
                this.fnl = dataRes.thread_id_list;
                this.Rl.parserProtobuf(dataRes.anti);
                this.fnq.a(dataRes.group);
                this.djY.a(dataRes.page);
                this.fnm.a(dataRes.frs_star);
                this.efv.parserProtobuf(dataRes.user);
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.efv.getIsSelectTail());
                }
                this.fnC = dataRes.frs_tab_info;
                if (dataRes.nav_tab_info == null) {
                    NavTabInfo.Builder builder = new NavTabInfo.Builder();
                    builder.tab = dataRes.frs_tab_info;
                    this.fnD = builder.build(true);
                } else {
                    this.fnD = dataRes.nav_tab_info;
                }
                this.alaLiveCount = dataRes.ala_live_count.intValue();
                rJ(dataRes.frs_tab_default.intValue());
                List<ZhiBoInfoTW> list3 = dataRes.twzhibo_info;
                if (list3 != null && list3.size() > 0) {
                    this.fnu = new ArrayList();
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
                        this.fnu.add(photoLiveCardData);
                    }
                }
                this.fnv = dataRes.twzhibo_pos.intValue();
                if (dataRes.hot_twzhibo_info != null) {
                    this.fnw = new PhotoLiveCardData();
                    if (this.fnw.getShowStyle() < 0) {
                        this.fnw.setShowStyle(PhotoLiveCardData.getRandom(3, -1));
                    }
                    this.fnw.getShowStyle();
                    this.fnw.parserProtobuf(dataRes.hot_twzhibo_info);
                    this.fnw.setShowExpressionViewIndexList(this.fnw.getExpressionDatas());
                }
                a(dataRes.thread_list, longValue);
                this.fnG = dataRes.category_list;
                if (!at.isEmpty(dataRes.bawu_enter_url)) {
                    this.fnH = dataRes.bawu_enter_url;
                }
                if (dataRes.head_sdk != null) {
                    this.fnI = new com.baidu.tbadk.core.data.x();
                    this.fnI.a(dataRes.head_sdk);
                }
                if (dataRes.recommend_book != null) {
                    this.fnJ = new com.baidu.tbadk.core.data.z();
                    this.fnJ.a(dataRes.recommend_book);
                }
                if (dataRes.book_info != null) {
                    this.fnK = new com.baidu.tbadk.core.data.r();
                    this.fnK.a(dataRes.book_info);
                }
                if (dataRes.forum_present_info != null) {
                    this.fnM = new com.baidu.tbadk.core.data.v();
                    this.fnM.a(dataRes.forum_present_info);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.fnN = new com.baidu.tbadk.core.data.t();
                    this.fnN.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.store_card != null) {
                    this.fnz = new com.baidu.tbadk.core.data.aa();
                    this.fnz.a(dataRes.store_card);
                }
                if (dataRes.ntspread != null) {
                    this.fnA = new com.baidu.tbadk.core.data.y();
                    this.fnA.a(dataRes.ntspread);
                }
                if (dataRes.card_shipin_info != null && dataRes.card_shipin_info.size() > 0) {
                    this.fnO = new bh();
                    this.fnO.as(true);
                    this.fnO.bY(this.fnv);
                    this.fnO.setUserMap(this.userMap);
                    this.fnO.a(dataRes.card_shipin_info.get(0));
                    this.fnO.sd();
                    if (this.fnO.getFid() == 0 && longValue != 0) {
                        this.fnO.setFid(longValue);
                    }
                    this.fnO.j(this.fny);
                    this.fnO.ar(!this.fnO.rf());
                    if (this.fnO.getAuthor() != null && this.fnO.getAuthor().getPendantData() == null && (metaData = this.userMap.get(this.fnO.getAuthor().getUserId())) != null && metaData.getPendantData() != null) {
                        com.baidu.tbadk.data.j jVar = new com.baidu.tbadk.data.j();
                        jVar.N(metaData.getPendantData().BX());
                        jVar.cq(metaData.getPendantData().pL());
                        this.fnO.getAuthor().setPendantData(jVar);
                    }
                }
                if (dataRes.school_recom_info != null) {
                    this.fnQ = dataRes.school_recom_pos.intValue();
                    this.fnP = new ax();
                    this.fnP.a(dataRes.school_recom_info);
                }
                if (dataRes.carrier_enter != null) {
                    this.fnR = new com.baidu.tbadk.core.data.n();
                    this.fnR.a(dataRes.carrier_enter);
                }
                if (dataRes.banner_thread_list != null) {
                    this.fnT.clear();
                    int size2 = dataRes.banner_thread_list.size();
                    for (int i5 = 0; i5 < size2; i5++) {
                        BannerThreadInfoData bannerThreadInfoData = new BannerThreadInfoData();
                        bannerThreadInfoData.parserProtobuf(dataRes.banner_thread_list.get(i5));
                        this.fnT.add(bannerThreadInfoData);
                    }
                }
                if (dataRes.vitality_info != null && dataRes.vitality_info.frequently_forum_info != null) {
                    this.fnU = dataRes.vitality_info.frequently_forum_info.forum_state.intValue();
                    this.fnV = dataRes.vitality_info.frequently_forum_info.access_flag.intValue();
                }
                this.mSortType = dataRes.sort_type.intValue();
                this.fnk = dataRes.need_log.intValue();
                com.baidu.tieba.recapp.c.a.bad().pU(dataRes.asp_shown_info);
                this.fnW = dataRes.card_shipin_pos;
                if (dataRes.card_shipin_new != null) {
                    for (int i6 = 0; i6 < dataRes.card_shipin_new.size(); i6++) {
                        bh bhVar = new bh();
                        if (this.fnW != null && this.fnW.size() >= dataRes.card_shipin_new.size()) {
                            bhVar.bY(this.fnW.get(i6).intValue());
                        }
                        bhVar.as(true);
                        bhVar.a(dataRes.card_shipin_new.get(i6));
                        this.fnX.add(bhVar);
                    }
                }
                if (dataRes.bottle != null) {
                    this.isShowDriftingBottle = dataRes.bottle.has_enter_display.intValue() == 1;
                    this.fnY = dataRes.bottle.tid.longValue();
                } else {
                    this.isShowDriftingBottle = false;
                    this.fnY = 0L;
                }
                this.fnZ = dataRes.enter_pop_info;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    private void rJ(int i) {
        this.fnE = 1;
        if (this.fnC != null && this.fnC.size() > 0) {
            for (FrsTabInfo frsTabInfo : this.fnC) {
                if (frsTabInfo != null && frsTabInfo.tab_id.intValue() == i) {
                    this.fnE = i;
                    return;
                }
            }
        }
    }

    public void a(List<ThreadInfo> list, long j) {
        if (list != null) {
            boolean appResponseToIntentClass = TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
            for (int i = 0; i < list.size(); i++) {
                bh bhVar = new bh();
                bhVar.setUserMap(this.userMap);
                bhVar.a(list.get(i));
                bhVar.aW(3);
                bhVar.sd();
                if (bhVar.getFid() == 0 && j != 0) {
                    bhVar.setFid(j);
                }
                bhVar.j(this.fny);
                if (bhVar.getThreadType() == 33 && !bhVar.rW()) {
                    au auVar = new au();
                    auVar.a(bhVar, 0);
                    auVar.o(bfV());
                    if (appResponseToIntentClass) {
                        this.threadList.add(auVar);
                    }
                } else if (!TextUtils.isEmpty(bhVar.sq())) {
                    com.baidu.tbadk.core.data.ah ahVar = new com.baidu.tbadk.core.data.ah();
                    ahVar.co(bhVar.sq());
                    this.threadList.add(ahVar);
                } else {
                    this.threadList.add(bhVar);
                }
            }
        }
    }

    public int bfJ() {
        return this.alaLiveCount;
    }

    public void rK(int i) {
        this.alaLiveCount = i;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] Eo() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public boolean z(byte[] bArr) {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void i(JSONObject jSONObject) {
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void a(Message message) {
    }

    public ForumData aJY() {
        return this.efp;
    }

    public int bfK() {
        return this.fnU;
    }

    public void rL(int i) {
        this.fnU = i;
    }

    public int bfL() {
        return this.fnV;
    }

    public void rM(int i) {
        this.fnV = i;
    }

    public void c(ForumData forumData) {
        this.efp = forumData;
    }

    public ArrayList<com.baidu.adp.widget.ListView.v> getThreadList() {
        return this.threadList;
    }

    public void ax(ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        this.threadList = arrayList;
    }

    public AntiData qm() {
        return this.Rl;
    }

    public void d(AntiData antiData) {
        this.Rl = antiData;
    }

    public ao getPage() {
        return this.djY;
    }

    public void a(ao aoVar) {
        this.djY = aoVar;
    }

    public m bfM() {
        return this.fnm;
    }

    public void a(m mVar) {
        this.fnm = mVar;
    }

    public com.baidu.tbadk.core.data.q bfN() {
        return this.fnB;
    }

    public void b(com.baidu.tbadk.core.data.q qVar) {
        this.fnB = qVar;
    }

    public boolean bfO() {
        return this.fnn;
    }

    public void lc(boolean z) {
        this.fnn = z;
    }

    public String bfP() {
        return this.fno;
    }

    public void qn(String str) {
        this.fno = str;
    }

    public o bfQ() {
        return this.fnp;
    }

    public void a(o oVar) {
        this.fnp = oVar;
    }

    public UserData getUserData() {
        return this.efv;
    }

    public void h(UserData userData) {
        this.efv = userData;
    }

    public List<Long> bfR() {
        return this.fnl;
    }

    public void cX(List<Long> list) {
        this.fnl = list;
    }

    public b bfS() {
        return this.fnq;
    }

    public void a(b bVar) {
        this.fnq = bVar;
    }

    public boolean bfT() {
        return this.fnr;
    }

    public void ld(boolean z) {
        this.fnr = z;
    }

    public String getGameName() {
        return this.gameName;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public List<g> bfU() {
        return this.fns;
    }

    public void cY(List<g> list) {
        this.fns = list;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public int aKk() {
        return this.fnt;
    }

    public void mr(int i) {
        this.fnt = i;
    }

    public List<PhotoLiveCardData> bfV() {
        return this.fnu;
    }

    public String bfW() {
        return this.fnx;
    }

    public void qo(String str) {
        this.fnx = str;
    }

    public List<FrsTabInfo> bfX() {
        return this.fnC;
    }

    public void cZ(List<FrsTabInfo> list) {
        this.fnC = list;
    }

    public void da(List<PhotoLiveCardData> list) {
        this.fnu = list;
    }

    public boolean bfY() {
        return this.fnw != null;
    }

    public PhotoLiveCardData bfZ() {
        return this.fnw;
    }

    public void c(PhotoLiveCardData photoLiveCardData) {
        this.fnw = photoLiveCardData;
    }

    public com.baidu.tbadk.core.data.aa bga() {
        return this.fnz;
    }

    public void a(com.baidu.tbadk.core.data.aa aaVar) {
        this.fnz = aaVar;
    }

    public com.baidu.tbadk.core.data.y bgb() {
        return this.fnA;
    }

    public void a(com.baidu.tbadk.core.data.y yVar) {
        this.fnA = yVar;
    }

    public int bgc() {
        return this.fnv;
    }

    public void rN(int i) {
        this.fnv = i;
    }

    public List<FeedForumData> bgd() {
        return this.fnF;
    }

    public void db(List<FeedForumData> list) {
        this.fnF = list;
    }

    public void qp(String str) {
        if (this.fnF != null && str != null) {
            for (FeedForumData feedForumData : this.fnF) {
                if (feedForumData != null && feedForumData.getForumId() != null && feedForumData.getForumId().equals(str)) {
                    this.fnF.remove(feedForumData);
                    return;
                }
            }
        }
    }

    public List<CategoryInfo> bge() {
        return this.fnG;
    }

    public void dc(List<CategoryInfo> list) {
        this.fnG = list;
    }

    public void qq(String str) {
        this.fnH = str;
    }

    public String bgf() {
        return this.fnH;
    }

    public bh bgg() {
        return this.fnO;
    }

    public void J(bh bhVar) {
        this.fnO = bhVar;
    }

    public int bgh() {
        return this.fnE;
    }

    public void rO(int i) {
        this.fnE = i;
    }

    public com.baidu.tbadk.core.data.x bgi() {
        return this.fnI;
    }

    public void b(com.baidu.tbadk.core.data.x xVar) {
        this.fnI = xVar;
    }

    public com.baidu.tbadk.core.data.r bgj() {
        return this.fnK;
    }

    public void a(com.baidu.tbadk.core.data.r rVar) {
        this.fnK = rVar;
    }

    public com.baidu.tbadk.core.data.t bgk() {
        return this.fnN;
    }

    public void a(com.baidu.tbadk.core.data.t tVar) {
        this.fnN = tVar;
    }

    public int bgl() {
        return this.fnQ;
    }

    public void rP(int i) {
        this.fnQ = i;
    }

    public ax bgm() {
        return this.fnP;
    }

    public void a(ax axVar) {
        this.fnP = axVar;
    }

    public NavTabInfo bgn() {
        return this.fnD;
    }

    public void a(NavTabInfo navTabInfo) {
        this.fnD = navTabInfo;
    }

    public com.baidu.tbadk.core.data.n bgo() {
        return this.fnR;
    }

    public void a(com.baidu.tbadk.core.data.n nVar) {
        this.fnR = nVar;
    }

    public void dd(List<BannerThreadInfoData> list) {
        this.fnT = list;
    }

    public List<BannerThreadInfoData> bgp() {
        return this.fnT;
    }

    public int acb() {
        return this.mSortType;
    }

    public Integer bgq() {
        return this.fnL;
    }

    public void d(Integer num) {
        this.fnL = num;
    }

    public List<Integer> bgr() {
        return this.fnW;
    }

    public void de(List<Integer> list) {
        this.fnW = list;
    }

    public List<com.baidu.adp.widget.ListView.v> bgs() {
        return this.fnX;
    }

    public void df(List<com.baidu.adp.widget.ListView.v> list) {
        this.fnX = list;
    }

    public boolean isShowDriftingBottle() {
        return this.isShowDriftingBottle;
    }

    public long bgt() {
        return this.fnY;
    }

    public void le(boolean z) {
        this.isShowDriftingBottle = z;
    }

    public void cy(long j) {
        this.fnY = j;
    }
}

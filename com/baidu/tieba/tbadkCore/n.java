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
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.data.aw;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.util.az;
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
import tbclient.ThreadInfo;
import tbclient.User;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class n implements com.baidu.tbadk.mvc.b.c {
    public static final Wire WIRE = new Wire(new Class[0]);
    private AntiData RK;
    protected com.baidu.tbadk.core.data.am duh;
    protected ForumData elX;
    private UserData emd;
    protected List<Long> fsE;
    private o fsF;
    protected boolean fsG;
    protected String fsH;
    protected q fsI;
    private b fsJ;
    private boolean fsK;
    private List<PhotoLiveCardData> fsN;
    private int fsO;
    private PhotoLiveCardData fsP;
    private String fsQ;
    private com.baidu.tbadk.core.data.y fsS;
    private com.baidu.tbadk.core.data.w fsT;
    private List<FrsTabInfo> fsV;
    private NavTabInfo fsW;
    private List<FeedForumData> fsY;
    private List<CategoryInfo> fsZ;
    private bi ftg;
    private aw fth;
    private com.baidu.tbadk.core.data.l ftj;
    private String gameName;
    private int mSortType;
    protected ArrayList<com.baidu.adp.widget.ListView.v> threadList;
    private HashMap<String, MetaData> userMap;
    public int fsD = 0;
    private List<h> fsL = new ArrayList();
    private int fsM = 0;
    private ArrayList<com.baidu.tbadk.core.data.n> fsR = new ArrayList<>();
    protected com.baidu.tbadk.core.data.p fsU = null;
    private int fsX = 1;
    private String fta = null;
    private com.baidu.tbadk.core.data.v ftb = null;
    public com.baidu.tbadk.core.data.x ftc = null;
    private com.baidu.tbadk.core.data.q ftd = null;
    private Integer fte = -1;
    private com.baidu.tbadk.core.data.s ftf = null;
    private int fti = -1;
    protected List<com.baidu.adp.widget.ListView.v> ftk = null;
    private List<BannerThreadInfoData> ftl = null;
    private int ftm = 0;
    private int ftn = 0;

    public n() {
        initData();
    }

    private void initData() {
        this.elX = new ForumData();
        this.threadList = new ArrayList<>();
        this.ftk = new ArrayList();
        this.userMap = new HashMap<>();
        this.duh = new com.baidu.tbadk.core.data.am();
        this.fsF = new o();
        this.emd = new UserData();
        this.fsI = new q();
        d(new AntiData());
        a(new b());
        this.ftl = new ArrayList();
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
                if (dataRes.color_egg != null && dataRes.color_egg.size() > 0) {
                    for (ColorEgg colorEgg : dataRes.color_egg) {
                        if (colorEgg != null && colorEgg.holiday_words != null && colorEgg.holiday_words.size() > 0) {
                            com.baidu.tbadk.core.data.n nVar = new com.baidu.tbadk.core.data.n();
                            if (nVar.a(colorEgg)) {
                                this.fsR.add(nVar);
                            }
                        }
                    }
                }
                if (dataRes.activityhead != null && dataRes.activityhead.head_imgs != null && dataRes.activityhead.head_imgs.size() > 0) {
                    this.fsU = new com.baidu.tbadk.core.data.p();
                    this.fsU.a(dataRes.activityhead);
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
                mz(dataRes.is_new_url.intValue());
                this.fsG = dataRes.fortune_bag.intValue() == 1;
                this.fsH = dataRes.fortune_desc;
                if (dataRes.forum != null) {
                    this.fsK = dataRes.forum.has_game.intValue() == 1;
                    this.fsQ = dataRes.forum.game_url;
                    this.gameName = dataRes.forum.game_name;
                }
                List<StarEnter> list2 = dataRes.star_enter;
                this.fsL.clear();
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        h hVar = new h();
                        hVar.a(list2.get(i2));
                        this.fsL.add(hVar);
                    }
                }
                this.fsI.a(dataRes.gcon_account);
                this.elX.parserProtobuf(dataRes.forum);
                long longValue = dataRes.forum != null ? dataRes.forum.id.longValue() : 0L;
                this.fsE = dataRes.thread_id_list;
                this.RK.parserProtobuf(dataRes.anti);
                this.fsJ.a(dataRes.group);
                this.duh.a(dataRes.page);
                this.fsF.a(dataRes.frs_star);
                this.emd.parserProtobuf(dataRes.user);
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.emd.getIsSelectTail());
                }
                this.fsV = dataRes.frs_tab_info;
                if (dataRes.nav_tab_info == null) {
                    NavTabInfo.Builder builder = new NavTabInfo.Builder();
                    builder.tab = dataRes.frs_tab_info;
                    this.fsW = builder.build(true);
                } else {
                    this.fsW = dataRes.nav_tab_info;
                }
                rB(dataRes.frs_tab_default.intValue());
                List<ZhiBoInfoTW> list3 = dataRes.twzhibo_info;
                if (list3 != null && list3.size() > 0) {
                    this.fsN = new ArrayList();
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
                        this.fsN.add(photoLiveCardData);
                    }
                }
                this.fsO = dataRes.twzhibo_pos.intValue();
                if (dataRes.hot_twzhibo_info != null) {
                    this.fsP = new PhotoLiveCardData();
                    if (this.fsP.getShowStyle() < 0) {
                        this.fsP.setShowStyle(PhotoLiveCardData.getRandom(3, -1));
                    }
                    this.fsP.getShowStyle();
                    this.fsP.parserProtobuf(dataRes.hot_twzhibo_info);
                    this.fsP.setShowExpressionViewIndexList(this.fsP.getExpressionDatas());
                }
                b(dataRes.thread_list, longValue);
                this.fsZ = dataRes.category_list;
                if (!az.isEmpty(dataRes.bawu_enter_url)) {
                    this.fta = dataRes.bawu_enter_url;
                }
                if (dataRes.head_sdk != null) {
                    this.ftb = new com.baidu.tbadk.core.data.v();
                    this.ftb.a(dataRes.head_sdk);
                }
                if (dataRes.recommend_book != null) {
                    this.ftc = new com.baidu.tbadk.core.data.x();
                    this.ftc.a(dataRes.recommend_book);
                }
                if (dataRes.book_info != null) {
                    this.ftd = new com.baidu.tbadk.core.data.q();
                    this.ftd.a(dataRes.book_info);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.ftf = new com.baidu.tbadk.core.data.s();
                    this.ftf.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.store_card != null) {
                    this.fsS = new com.baidu.tbadk.core.data.y();
                    this.fsS.a(dataRes.store_card);
                }
                if (dataRes.ntspread != null) {
                    this.fsT = new com.baidu.tbadk.core.data.w();
                    this.fsT.a(dataRes.ntspread);
                }
                if (dataRes.card_shipin_info != null && dataRes.card_shipin_info.size() > 0) {
                    this.ftg = new bi();
                    this.ftg.setUserMap(this.userMap);
                    this.ftg.a(dataRes.card_shipin_info.get(0));
                    this.ftg.su();
                    if (this.ftg.getFid() == 0 && longValue != 0) {
                        this.ftg.setFid(longValue);
                    }
                    this.ftg.j(this.fsR);
                    this.ftg.ap(!this.ftg.rw());
                    if (this.ftg.getAuthor() != null && this.ftg.getAuthor().getPendantData() == null && (metaData = this.userMap.get(this.ftg.getAuthor().getUserId())) != null && metaData.getPendantData() != null) {
                        com.baidu.tbadk.data.j jVar = new com.baidu.tbadk.data.j();
                        jVar.Q(metaData.getPendantData().Cg());
                        jVar.cq(metaData.getPendantData().pO());
                        this.ftg.getAuthor().setPendantData(jVar);
                    }
                }
                if (dataRes.school_recom_info != null) {
                    this.fti = dataRes.school_recom_pos.intValue();
                    this.fth = new aw();
                    this.fth.a(dataRes.school_recom_info);
                }
                if (dataRes.carrier_enter != null) {
                    this.ftj = new com.baidu.tbadk.core.data.l();
                    this.ftj.a(dataRes.carrier_enter);
                }
                if (dataRes.banner_thread_list != null) {
                    this.ftl.clear();
                    int size2 = dataRes.banner_thread_list.size();
                    for (int i5 = 0; i5 < size2; i5++) {
                        BannerThreadInfoData bannerThreadInfoData = new BannerThreadInfoData();
                        bannerThreadInfoData.parserProtobuf(dataRes.banner_thread_list.get(i5));
                        this.ftl.add(bannerThreadInfoData);
                    }
                }
                if (dataRes.vitality_info != null && dataRes.vitality_info.frequently_forum_info != null) {
                    this.ftm = dataRes.vitality_info.frequently_forum_info.forum_state.intValue();
                    this.ftn = dataRes.vitality_info.frequently_forum_info.access_flag.intValue();
                }
                this.mSortType = dataRes.sort_type.intValue();
                this.fsD = dataRes.need_log.intValue();
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    private void rB(int i) {
        this.fsX = 1;
        if (this.fsV != null && this.fsV.size() > 0) {
            for (FrsTabInfo frsTabInfo : this.fsV) {
                if (frsTabInfo != null && frsTabInfo.tab_id.intValue() == i) {
                    this.fsX = i;
                    return;
                }
            }
        }
    }

    public void b(List<ThreadInfo> list, long j) {
        if (list != null) {
            boolean appResponseToIntentClass = TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
            for (int i = 0; i < list.size(); i++) {
                bi biVar = new bi();
                biVar.setUserMap(this.userMap);
                biVar.a(list.get(i));
                biVar.su();
                if (biVar.getFid() == 0 && j != 0) {
                    biVar.setFid(j);
                }
                biVar.j(this.fsR);
                if (biVar.getThreadType() == 33 && !biVar.sn()) {
                    as asVar = new as();
                    asVar.a(biVar, 0);
                    asVar.p(bhW());
                    if (appResponseToIntentClass) {
                        this.threadList.add(asVar);
                    }
                } else if (!TextUtils.isEmpty(biVar.sH())) {
                    com.baidu.tbadk.core.data.af afVar = new com.baidu.tbadk.core.data.af();
                    afVar.cn(biVar.sH());
                    this.threadList.add(afVar);
                } else {
                    this.threadList.add(biVar);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] EH() {
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

    public ForumData aMr() {
        return this.elX;
    }

    public int bhL() {
        return this.ftm;
    }

    public void rC(int i) {
        this.ftm = i;
    }

    public int bhM() {
        return this.ftn;
    }

    public void rD(int i) {
        this.ftn = i;
    }

    public void c(ForumData forumData) {
        this.elX = forumData;
    }

    public ArrayList<com.baidu.adp.widget.ListView.v> getThreadList() {
        return this.threadList;
    }

    public void aA(ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        this.threadList = arrayList;
    }

    public AntiData qq() {
        return this.RK;
    }

    public void d(AntiData antiData) {
        this.RK = antiData;
    }

    public com.baidu.tbadk.core.data.am getPage() {
        return this.duh;
    }

    public void a(com.baidu.tbadk.core.data.am amVar) {
        this.duh = amVar;
    }

    public o bhN() {
        return this.fsF;
    }

    public void a(o oVar) {
        this.fsF = oVar;
    }

    public com.baidu.tbadk.core.data.p bhO() {
        return this.fsU;
    }

    public void b(com.baidu.tbadk.core.data.p pVar) {
        this.fsU = pVar;
    }

    public boolean bhP() {
        return this.fsG;
    }

    public void kJ(boolean z) {
        this.fsG = z;
    }

    public String bhQ() {
        return this.fsH;
    }

    public void qV(String str) {
        this.fsH = str;
    }

    public q bhR() {
        return this.fsI;
    }

    public void a(q qVar) {
        this.fsI = qVar;
    }

    public UserData getUserData() {
        return this.emd;
    }

    public void j(UserData userData) {
        this.emd = userData;
    }

    public List<Long> bhS() {
        return this.fsE;
    }

    public void cY(List<Long> list) {
        this.fsE = list;
    }

    public b bhT() {
        return this.fsJ;
    }

    public void a(b bVar) {
        this.fsJ = bVar;
    }

    public boolean bhU() {
        return this.fsK;
    }

    public void kK(boolean z) {
        this.fsK = z;
    }

    public String getGameName() {
        return this.gameName;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public List<h> bhV() {
        return this.fsL;
    }

    public void cZ(List<h> list) {
        this.fsL = list;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public int aMA() {
        return this.fsM;
    }

    public void mz(int i) {
        this.fsM = i;
    }

    public List<PhotoLiveCardData> bhW() {
        return this.fsN;
    }

    public String bhX() {
        return this.fsQ;
    }

    public void qW(String str) {
        this.fsQ = str;
    }

    public List<FrsTabInfo> bhY() {
        return this.fsV;
    }

    public void da(List<FrsTabInfo> list) {
        this.fsV = list;
    }

    public void db(List<PhotoLiveCardData> list) {
        this.fsN = list;
    }

    public boolean bhZ() {
        return this.fsP != null;
    }

    public PhotoLiveCardData bia() {
        return this.fsP;
    }

    public void c(PhotoLiveCardData photoLiveCardData) {
        this.fsP = photoLiveCardData;
    }

    public com.baidu.tbadk.core.data.y bib() {
        return this.fsS;
    }

    public void a(com.baidu.tbadk.core.data.y yVar) {
        this.fsS = yVar;
    }

    public com.baidu.tbadk.core.data.w bic() {
        return this.fsT;
    }

    public void a(com.baidu.tbadk.core.data.w wVar) {
        this.fsT = wVar;
    }

    public int bid() {
        return this.fsO;
    }

    public void rE(int i) {
        this.fsO = i;
    }

    public List<FeedForumData> bie() {
        return this.fsY;
    }

    public void dc(List<FeedForumData> list) {
        this.fsY = list;
    }

    public void qX(String str) {
        if (this.fsY != null && str != null) {
            for (FeedForumData feedForumData : this.fsY) {
                if (feedForumData != null && feedForumData.getForumId() != null && feedForumData.getForumId().equals(str)) {
                    this.fsY.remove(feedForumData);
                    return;
                }
            }
        }
    }

    public List<CategoryInfo> bif() {
        return this.fsZ;
    }

    public void dd(List<CategoryInfo> list) {
        this.fsZ = list;
    }

    public void qY(String str) {
        this.fta = str;
    }

    public String big() {
        return this.fta;
    }

    public bi bih() {
        return this.ftg;
    }

    public void u(bi biVar) {
        this.ftg = biVar;
    }

    public int bii() {
        return this.fsX;
    }

    public void rF(int i) {
        this.fsX = i;
    }

    public com.baidu.tbadk.core.data.v bij() {
        return this.ftb;
    }

    public void b(com.baidu.tbadk.core.data.v vVar) {
        this.ftb = vVar;
    }

    public com.baidu.tbadk.core.data.q bik() {
        return this.ftd;
    }

    public void a(com.baidu.tbadk.core.data.q qVar) {
        this.ftd = qVar;
    }

    public com.baidu.tbadk.core.data.s bil() {
        return this.ftf;
    }

    public void a(com.baidu.tbadk.core.data.s sVar) {
        this.ftf = sVar;
    }

    public int bim() {
        return this.fti;
    }

    public void rG(int i) {
        this.fti = i;
    }

    public aw bin() {
        return this.fth;
    }

    public void a(aw awVar) {
        this.fth = awVar;
    }

    public NavTabInfo bio() {
        return this.fsW;
    }

    public void a(NavTabInfo navTabInfo) {
        this.fsW = navTabInfo;
    }

    public com.baidu.tbadk.core.data.l bip() {
        return this.ftj;
    }

    public void a(com.baidu.tbadk.core.data.l lVar) {
        this.ftj = lVar;
    }

    public void de(List<BannerThreadInfoData> list) {
        this.ftl = list;
    }

    public List<BannerThreadInfoData> biq() {
        return this.ftl;
    }

    public Integer bir() {
        return this.fte;
    }

    public void h(Integer num) {
        this.fte = num;
    }
}

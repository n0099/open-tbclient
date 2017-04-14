package com.baidu.tieba.tbadkCore;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.BannerThreadInfoData;
import com.baidu.tbadk.core.data.FeedForumData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PhotoLiveCardData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.data.ap;
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.data.ay;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.util.au;
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
    private AntiData WM;
    protected ap dkR;
    protected ForumData efR;
    private UserData efX;
    private boolean ftA;
    private List<PhotoLiveCardData> ftD;
    private int ftE;
    private PhotoLiveCardData ftF;
    private String ftG;
    private com.baidu.tbadk.core.data.z ftI;
    private List<FrsTabInfo> ftK;
    private NavTabInfo ftL;
    private List<FeedForumData> ftN;
    private List<CategoryInfo> ftO;
    private bi ftW;
    private ay ftX;
    private com.baidu.tbadk.core.data.m ftZ;
    protected List<Long> ftu;
    private m ftv;
    protected boolean ftw;
    protected String ftx;
    protected o fty;
    private b ftz;
    private List<Integer> fue;
    private List<com.baidu.adp.widget.ListView.v> fuf;
    public PopInfo fuh;
    private String gameName;
    private int mSortType;
    protected ArrayList<com.baidu.adp.widget.ListView.v> threadList;
    private HashMap<String, MetaData> userMap;
    public int ftt = 0;
    private List<g> ftB = new ArrayList();
    private int ftC = 0;
    private ArrayList<com.baidu.tbadk.core.data.o> ftH = new ArrayList<>();
    protected com.baidu.tbadk.core.data.r ftJ = null;
    private int ftM = 1;
    private String ftP = null;
    private com.baidu.tbadk.core.data.y ftQ = null;
    public com.baidu.tbadk.core.data.aa ftR = null;
    private com.baidu.tbadk.core.data.s ftS = null;
    private Integer ftT = -1;
    public com.baidu.tbadk.core.data.w ftU = null;
    private com.baidu.tbadk.core.data.u ftV = null;
    private int ftY = -1;
    protected List<com.baidu.adp.widget.ListView.v> fua = null;
    private List<BannerThreadInfoData> fub = null;
    private int fuc = 0;
    private int fud = 0;
    private boolean isShowDriftingBottle = false;
    private long fug = 0;
    private int alaLiveCount = 0;

    public l() {
        initData();
    }

    private void initData() {
        this.efR = new ForumData();
        this.threadList = new ArrayList<>();
        this.fua = new ArrayList();
        this.userMap = new HashMap<>();
        this.dkR = new ap();
        this.ftv = new m();
        this.efX = new UserData();
        this.fty = new o();
        d(new AntiData());
        a(new b());
        this.fub = new ArrayList();
        this.fuf = new ArrayList();
        this.fue = new ArrayList();
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
                if (!com.baidu.tbadk.core.util.x.q(dataRes.color_egg)) {
                    for (ColorEgg colorEgg : dataRes.color_egg) {
                        if (colorEgg != null && !com.baidu.tbadk.core.util.x.q(colorEgg.holiday_words)) {
                            com.baidu.tbadk.core.data.o oVar = new com.baidu.tbadk.core.data.o();
                            if (oVar.a(colorEgg)) {
                                this.ftH.add(oVar);
                            }
                        }
                    }
                }
                if (dataRes.activityhead != null && !com.baidu.tbadk.core.util.x.q(dataRes.activityhead.head_imgs)) {
                    this.ftJ = new com.baidu.tbadk.core.data.r();
                    this.ftJ.a(dataRes.activityhead);
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
                mi(dataRes.is_new_url.intValue());
                this.ftw = dataRes.fortune_bag.intValue() == 1;
                this.ftx = dataRes.fortune_desc;
                if (dataRes.forum != null) {
                    this.ftA = dataRes.forum.has_game.intValue() == 1;
                    this.ftG = dataRes.forum.game_url;
                    this.gameName = dataRes.forum.game_name;
                }
                List<StarEnter> list2 = dataRes.star_enter;
                this.ftB.clear();
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        g gVar = new g();
                        gVar.a(list2.get(i2));
                        this.ftB.add(gVar);
                    }
                }
                this.fty.a(dataRes.gcon_account);
                this.efR.parserProtobuf(dataRes.forum);
                long longValue = dataRes.forum != null ? dataRes.forum.id.longValue() : 0L;
                this.ftu = dataRes.thread_id_list;
                this.WM.parserProtobuf(dataRes.anti);
                this.ftz.a(dataRes.group);
                this.dkR.a(dataRes.page);
                this.ftv.a(dataRes.frs_star);
                this.efX.parserProtobuf(dataRes.user);
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.efX.getIsSelectTail());
                }
                this.ftK = dataRes.frs_tab_info;
                if (dataRes.nav_tab_info == null) {
                    NavTabInfo.Builder builder = new NavTabInfo.Builder();
                    builder.tab = dataRes.frs_tab_info;
                    this.ftL = builder.build(true);
                } else {
                    this.ftL = dataRes.nav_tab_info;
                }
                this.alaLiveCount = dataRes.ala_live_count.intValue();
                rG(dataRes.frs_tab_default.intValue());
                List<ZhiBoInfoTW> list3 = dataRes.twzhibo_info;
                if (list3 != null && list3.size() > 0) {
                    this.ftD = new ArrayList();
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
                        this.ftD.add(photoLiveCardData);
                    }
                }
                this.ftE = dataRes.twzhibo_pos.intValue();
                if (dataRes.hot_twzhibo_info != null) {
                    this.ftF = new PhotoLiveCardData();
                    if (this.ftF.getShowStyle() < 0) {
                        this.ftF.setShowStyle(PhotoLiveCardData.getRandom(3, -1));
                    }
                    this.ftF.getShowStyle();
                    this.ftF.parserProtobuf(dataRes.hot_twzhibo_info);
                    this.ftF.setShowExpressionViewIndexList(this.ftF.getExpressionDatas());
                }
                a(dataRes.thread_list, longValue);
                this.ftO = dataRes.category_list;
                if (!au.isEmpty(dataRes.bawu_enter_url)) {
                    this.ftP = dataRes.bawu_enter_url;
                }
                if (dataRes.head_sdk != null) {
                    this.ftQ = new com.baidu.tbadk.core.data.y();
                    this.ftQ.a(dataRes.head_sdk);
                }
                if (dataRes.recommend_book != null) {
                    this.ftR = new com.baidu.tbadk.core.data.aa();
                    this.ftR.a(dataRes.recommend_book);
                }
                if (dataRes.book_info != null) {
                    this.ftS = new com.baidu.tbadk.core.data.s();
                    this.ftS.a(dataRes.book_info);
                }
                if (dataRes.forum_present_info != null) {
                    this.ftU = new com.baidu.tbadk.core.data.w();
                    this.ftU.a(dataRes.forum_present_info);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.ftV = new com.baidu.tbadk.core.data.u();
                    this.ftV.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.ntspread != null) {
                    this.ftI = new com.baidu.tbadk.core.data.z();
                    this.ftI.a(dataRes.ntspread);
                }
                if (dataRes.card_shipin_info != null && dataRes.card_shipin_info.size() > 0) {
                    Log.e(PbActivityConfig.VALUE_FROM_FRS, "5FloorVideo:" + dataRes.card_shipin_info);
                    this.ftW = new bi();
                    this.ftW.at(true);
                    this.ftW.bW(this.ftE);
                    this.ftW.setUserMap(this.userMap);
                    this.ftW.a(dataRes.card_shipin_info.get(0));
                    this.ftW.sW();
                    if (this.ftW.getFid() == 0 && longValue != 0) {
                        this.ftW.setFid(longValue);
                    }
                    this.ftW.i(this.ftH);
                    this.ftW.as(!this.ftW.rW());
                    if (this.ftW.getAuthor() != null && this.ftW.getAuthor().getPendantData() == null && (metaData = this.userMap.get(this.ftW.getAuthor().getUserId())) != null && metaData.getPendantData() != null) {
                        com.baidu.tbadk.data.j jVar = new com.baidu.tbadk.data.j();
                        jVar.N(metaData.getPendantData().CO());
                        jVar.cr(metaData.getPendantData().qB());
                        this.ftW.getAuthor().setPendantData(jVar);
                    }
                }
                if (dataRes.school_recom_info != null) {
                    this.ftY = dataRes.school_recom_pos.intValue();
                    this.ftX = new ay();
                    this.ftX.a(dataRes.school_recom_info);
                }
                if (dataRes.carrier_enter != null) {
                    this.ftZ = new com.baidu.tbadk.core.data.m();
                    this.ftZ.a(dataRes.carrier_enter);
                }
                if (dataRes.banner_thread_list != null) {
                    this.fub.clear();
                    int size2 = dataRes.banner_thread_list.size();
                    for (int i5 = 0; i5 < size2; i5++) {
                        BannerThreadInfoData bannerThreadInfoData = new BannerThreadInfoData();
                        bannerThreadInfoData.parserProtobuf(dataRes.banner_thread_list.get(i5));
                        this.fub.add(bannerThreadInfoData);
                    }
                }
                if (dataRes.vitality_info != null && dataRes.vitality_info.frequently_forum_info != null) {
                    this.fuc = dataRes.vitality_info.frequently_forum_info.forum_state.intValue();
                    this.fud = dataRes.vitality_info.frequently_forum_info.access_flag.intValue();
                }
                this.mSortType = dataRes.sort_type.intValue();
                this.ftt = dataRes.need_log.intValue();
                com.baidu.tieba.recapp.d.a.bau().ps(dataRes.asp_shown_info);
                this.fue = dataRes.card_shipin_pos;
                if (dataRes.card_shipin_new != null) {
                    for (int i6 = 0; i6 < dataRes.card_shipin_new.size(); i6++) {
                        bi biVar = new bi();
                        if (this.fue != null && this.fue.size() >= dataRes.card_shipin_new.size()) {
                            biVar.bW(this.fue.get(i6).intValue());
                        }
                        biVar.at(true);
                        biVar.a(dataRes.card_shipin_new.get(i6));
                        this.fuf.add(biVar);
                    }
                }
                if (dataRes.bottle != null) {
                    this.isShowDriftingBottle = dataRes.bottle.has_enter_display.intValue() == 1;
                    this.fug = dataRes.bottle.tid.longValue();
                } else {
                    this.isShowDriftingBottle = false;
                    this.fug = 0L;
                }
                this.fuh = dataRes.enter_pop_info;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    private void rG(int i) {
        this.ftM = 1;
        if (this.ftK != null && this.ftK.size() > 0) {
            for (FrsTabInfo frsTabInfo : this.ftK) {
                if (frsTabInfo != null && frsTabInfo.tab_id.intValue() == i) {
                    this.ftM = i;
                    return;
                }
            }
        }
    }

    public void a(List<ThreadInfo> list, long j) {
        if (list != null) {
            boolean appResponseToIntentClass = TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
            for (int i = 0; i < list.size(); i++) {
                bi biVar = new bi();
                biVar.setUserMap(this.userMap);
                biVar.a(list.get(i));
                biVar.bX(3);
                biVar.sW();
                if (biVar.getFid() == 0 && j != 0) {
                    biVar.setFid(j);
                }
                biVar.i(this.ftH);
                if (biVar.getThreadType() == 33 && !biVar.sP()) {
                    av avVar = new av();
                    avVar.a(biVar, 0);
                    avVar.m(bgw());
                    if (appResponseToIntentClass) {
                        this.threadList.add(avVar);
                    }
                } else if (!TextUtils.isEmpty(biVar.tj())) {
                    ah ahVar = new ah();
                    ahVar.co(biVar.tj());
                    this.threadList.add(ahVar);
                } else {
                    this.threadList.add(biVar);
                }
            }
        }
    }

    public int bgk() {
        return this.alaLiveCount;
    }

    public void rH(int i) {
        this.alaLiveCount = i;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] Ff() {
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
    public void m(JSONObject jSONObject) {
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void a(Message message) {
    }

    public ForumData aJw() {
        return this.efR;
    }

    public int bgl() {
        return this.fuc;
    }

    public void rI(int i) {
        this.fuc = i;
    }

    public int bgm() {
        return this.fud;
    }

    public void rJ(int i) {
        this.fud = i;
    }

    public void c(ForumData forumData) {
        this.efR = forumData;
    }

    public ArrayList<com.baidu.adp.widget.ListView.v> getThreadList() {
        return this.threadList;
    }

    public void ax(ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        this.threadList = arrayList;
    }

    public AntiData rb() {
        return this.WM;
    }

    public void d(AntiData antiData) {
        this.WM = antiData;
    }

    public ap rr() {
        return this.dkR;
    }

    public void a(ap apVar) {
        this.dkR = apVar;
    }

    public m bgn() {
        return this.ftv;
    }

    public void a(m mVar) {
        this.ftv = mVar;
    }

    public com.baidu.tbadk.core.data.r bgo() {
        return this.ftJ;
    }

    public void b(com.baidu.tbadk.core.data.r rVar) {
        this.ftJ = rVar;
    }

    public boolean bgp() {
        return this.ftw;
    }

    public void ld(boolean z) {
        this.ftw = z;
    }

    public String bgq() {
        return this.ftx;
    }

    public void pN(String str) {
        this.ftx = str;
    }

    public o bgr() {
        return this.fty;
    }

    public void a(o oVar) {
        this.fty = oVar;
    }

    public UserData getUserData() {
        return this.efX;
    }

    public void h(UserData userData) {
        this.efX = userData;
    }

    public List<Long> bgs() {
        return this.ftu;
    }

    public void cD(List<Long> list) {
        this.ftu = list;
    }

    public b bgt() {
        return this.ftz;
    }

    public void a(b bVar) {
        this.ftz = bVar;
    }

    public boolean bgu() {
        return this.ftA;
    }

    public void le(boolean z) {
        this.ftA = z;
    }

    public String getGameName() {
        return this.gameName;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public List<g> bgv() {
        return this.ftB;
    }

    public void cE(List<g> list) {
        this.ftB = list;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public int aJI() {
        return this.ftC;
    }

    public void mi(int i) {
        this.ftC = i;
    }

    public List<PhotoLiveCardData> bgw() {
        return this.ftD;
    }

    public String bgx() {
        return this.ftG;
    }

    public void pO(String str) {
        this.ftG = str;
    }

    public List<FrsTabInfo> bgy() {
        return this.ftK;
    }

    public void cF(List<FrsTabInfo> list) {
        this.ftK = list;
    }

    public void cG(List<PhotoLiveCardData> list) {
        this.ftD = list;
    }

    public boolean bgz() {
        return this.ftF != null;
    }

    public PhotoLiveCardData bgA() {
        return this.ftF;
    }

    public void c(PhotoLiveCardData photoLiveCardData) {
        this.ftF = photoLiveCardData;
    }

    public com.baidu.tbadk.core.data.z bgB() {
        return this.ftI;
    }

    public void a(com.baidu.tbadk.core.data.z zVar) {
        this.ftI = zVar;
    }

    public int bgC() {
        return this.ftE;
    }

    public void rK(int i) {
        this.ftE = i;
    }

    public List<FeedForumData> bgD() {
        return this.ftN;
    }

    public void cH(List<FeedForumData> list) {
        this.ftN = list;
    }

    public void pP(String str) {
        if (this.ftN != null && str != null) {
            for (FeedForumData feedForumData : this.ftN) {
                if (feedForumData != null && feedForumData.getForumId() != null && feedForumData.getForumId().equals(str)) {
                    this.ftN.remove(feedForumData);
                    return;
                }
            }
        }
    }

    public List<CategoryInfo> bgE() {
        return this.ftO;
    }

    public void cI(List<CategoryInfo> list) {
        this.ftO = list;
    }

    public void pQ(String str) {
        this.ftP = str;
    }

    public String bgF() {
        return this.ftP;
    }

    public bi bgG() {
        return this.ftW;
    }

    public void H(bi biVar) {
        this.ftW = biVar;
    }

    public int bgH() {
        return this.ftM;
    }

    public void rL(int i) {
        this.ftM = i;
    }

    public com.baidu.tbadk.core.data.y bgI() {
        return this.ftQ;
    }

    public void b(com.baidu.tbadk.core.data.y yVar) {
        this.ftQ = yVar;
    }

    public com.baidu.tbadk.core.data.s bgJ() {
        return this.ftS;
    }

    public void a(com.baidu.tbadk.core.data.s sVar) {
        this.ftS = sVar;
    }

    public com.baidu.tbadk.core.data.u bgK() {
        return this.ftV;
    }

    public void a(com.baidu.tbadk.core.data.u uVar) {
        this.ftV = uVar;
    }

    public int bgL() {
        return this.ftY;
    }

    public void rM(int i) {
        this.ftY = i;
    }

    public ay bgM() {
        return this.ftX;
    }

    public void a(ay ayVar) {
        this.ftX = ayVar;
    }

    public NavTabInfo bgN() {
        return this.ftL;
    }

    public void a(NavTabInfo navTabInfo) {
        this.ftL = navTabInfo;
    }

    public com.baidu.tbadk.core.data.m bgO() {
        return this.ftZ;
    }

    public void a(com.baidu.tbadk.core.data.m mVar) {
        this.ftZ = mVar;
    }

    public void cJ(List<BannerThreadInfoData> list) {
        this.fub = list;
    }

    public List<BannerThreadInfoData> bgP() {
        return this.fub;
    }

    public int acS() {
        return this.mSortType;
    }

    public Integer bgQ() {
        return this.ftT;
    }

    public void d(Integer num) {
        this.ftT = num;
    }

    public List<Integer> bgR() {
        return this.fue;
    }

    public void cK(List<Integer> list) {
        this.fue = list;
    }

    public List<com.baidu.adp.widget.ListView.v> bgS() {
        return this.fuf;
    }

    public void cL(List<com.baidu.adp.widget.ListView.v> list) {
        this.fuf = list;
    }

    public boolean isShowDriftingBottle() {
        return this.isShowDriftingBottle;
    }

    public long bgT() {
        return this.fug;
    }

    public void lf(boolean z) {
        this.isShowDriftingBottle = z;
    }

    public void cA(long j) {
        this.fug = j;
    }
}

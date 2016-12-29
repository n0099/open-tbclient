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
import com.baidu.tbadk.core.data.an;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.aw;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.av;
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
public class m implements com.baidu.tbadk.mvc.b.c {
    public static final Wire WIRE = new Wire(new Class[0]);
    private AntiData Sc;
    private UserData dWC;
    protected ForumData dWw;
    protected an dcN;
    protected List<Long> fdQ;
    private n fdR;
    protected boolean fdS;
    protected String fdT;
    protected p fdU;
    private b fdV;
    private boolean fdW;
    private List<PhotoLiveCardData> fdZ;
    private List<Integer> feC;
    private List<com.baidu.adp.widget.ListView.v> feD;
    public PopInfo feF;
    private int fea;
    private PhotoLiveCardData feb;
    private String fec;
    private com.baidu.tbadk.core.data.z fef;
    private com.baidu.tbadk.core.data.x feg;
    private List<FrsTabInfo> fei;
    private NavTabInfo fej;
    private List<FeedForumData> fel;
    private List<CategoryInfo> fem;
    private bg feu;
    private aw fev;
    private com.baidu.tbadk.core.data.m fex;
    private String gameName;
    private int mSortType;
    protected ArrayList<com.baidu.adp.widget.ListView.v> threadList;
    private HashMap<String, MetaData> userMap;
    public int fdP = 0;
    private List<g> fdX = new ArrayList();
    private int fdY = 0;
    private ArrayList<com.baidu.tbadk.core.data.o> fed = new ArrayList<>();
    protected com.baidu.tbadk.core.data.p feh = null;
    private int fek = 1;
    private String fen = null;
    private com.baidu.tbadk.core.data.w feo = null;
    public com.baidu.tbadk.core.data.y fep = null;
    private com.baidu.tbadk.core.data.q feq = null;
    private Integer fer = -1;
    public com.baidu.tbadk.core.data.u fes = null;
    private com.baidu.tbadk.core.data.s fet = null;
    private int few = -1;
    protected List<com.baidu.adp.widget.ListView.v> fey = null;
    private List<BannerThreadInfoData> fez = null;
    private int feA = 0;
    private int feB = 0;
    private boolean isShowDriftingBottle = false;
    private long feE = 0;

    public m() {
        initData();
    }

    private void initData() {
        this.dWw = new ForumData();
        this.threadList = new ArrayList<>();
        this.fey = new ArrayList();
        this.userMap = new HashMap<>();
        this.dcN = new an();
        this.fdR = new n();
        this.dWC = new UserData();
        this.fdU = new p();
        d(new AntiData());
        a(new b());
        this.fez = new ArrayList();
        this.feD = new ArrayList();
        this.feC = new ArrayList();
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
                if (!com.baidu.tbadk.core.util.x.t(dataRes.color_egg)) {
                    for (ColorEgg colorEgg : dataRes.color_egg) {
                        if (colorEgg != null && !com.baidu.tbadk.core.util.x.t(colorEgg.holiday_words)) {
                            com.baidu.tbadk.core.data.o oVar = new com.baidu.tbadk.core.data.o();
                            if (oVar.a(colorEgg)) {
                                this.fed.add(oVar);
                            }
                        }
                    }
                }
                if (dataRes.activityhead != null && !com.baidu.tbadk.core.util.x.t(dataRes.activityhead.head_imgs)) {
                    this.feh = new com.baidu.tbadk.core.data.p();
                    this.feh.a(dataRes.activityhead);
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
                lE(dataRes.is_new_url.intValue());
                this.fdS = dataRes.fortune_bag.intValue() == 1;
                this.fdT = dataRes.fortune_desc;
                if (dataRes.forum != null) {
                    this.fdW = dataRes.forum.has_game.intValue() == 1;
                    this.fec = dataRes.forum.game_url;
                    this.gameName = dataRes.forum.game_name;
                }
                List<StarEnter> list2 = dataRes.star_enter;
                this.fdX.clear();
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        g gVar = new g();
                        gVar.a(list2.get(i2));
                        this.fdX.add(gVar);
                    }
                }
                this.fdU.a(dataRes.gcon_account);
                this.dWw.parserProtobuf(dataRes.forum);
                long longValue = dataRes.forum != null ? dataRes.forum.id.longValue() : 0L;
                this.fdQ = dataRes.thread_id_list;
                this.Sc.parserProtobuf(dataRes.anti);
                this.fdV.a(dataRes.group);
                this.dcN.a(dataRes.page);
                this.fdR.a(dataRes.frs_star);
                this.dWC.parserProtobuf(dataRes.user);
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.dWC.getIsSelectTail());
                }
                this.fei = dataRes.frs_tab_info;
                if (dataRes.nav_tab_info == null) {
                    NavTabInfo.Builder builder = new NavTabInfo.Builder();
                    builder.tab = dataRes.frs_tab_info;
                    this.fej = builder.build(true);
                } else {
                    this.fej = dataRes.nav_tab_info;
                }
                qX(dataRes.frs_tab_default.intValue());
                List<ZhiBoInfoTW> list3 = dataRes.twzhibo_info;
                if (list3 != null && list3.size() > 0) {
                    this.fdZ = new ArrayList();
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
                        this.fdZ.add(photoLiveCardData);
                    }
                }
                this.fea = dataRes.twzhibo_pos.intValue();
                if (dataRes.hot_twzhibo_info != null) {
                    this.feb = new PhotoLiveCardData();
                    if (this.feb.getShowStyle() < 0) {
                        this.feb.setShowStyle(PhotoLiveCardData.getRandom(3, -1));
                    }
                    this.feb.getShowStyle();
                    this.feb.parserProtobuf(dataRes.hot_twzhibo_info);
                    this.feb.setShowExpressionViewIndexList(this.feb.getExpressionDatas());
                }
                b(dataRes.thread_list, longValue);
                this.fem = dataRes.category_list;
                if (!av.isEmpty(dataRes.bawu_enter_url)) {
                    this.fen = dataRes.bawu_enter_url;
                }
                if (dataRes.head_sdk != null) {
                    this.feo = new com.baidu.tbadk.core.data.w();
                    this.feo.a(dataRes.head_sdk);
                }
                if (dataRes.recommend_book != null) {
                    this.fep = new com.baidu.tbadk.core.data.y();
                    this.fep.a(dataRes.recommend_book);
                }
                if (dataRes.book_info != null) {
                    this.feq = new com.baidu.tbadk.core.data.q();
                    this.feq.a(dataRes.book_info);
                }
                if (dataRes.forum_present_info != null) {
                    this.fes = new com.baidu.tbadk.core.data.u();
                    this.fes.a(dataRes.forum_present_info);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.fet = new com.baidu.tbadk.core.data.s();
                    this.fet.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.store_card != null) {
                    this.fef = new com.baidu.tbadk.core.data.z();
                    this.fef.a(dataRes.store_card);
                }
                if (dataRes.ntspread != null) {
                    this.feg = new com.baidu.tbadk.core.data.x();
                    this.feg.a(dataRes.ntspread);
                }
                if (dataRes.card_shipin_info != null && dataRes.card_shipin_info.size() > 0) {
                    this.feu = new bg();
                    this.feu.as(true);
                    this.feu.bZ(this.fea);
                    this.feu.setUserMap(this.userMap);
                    this.feu.a(dataRes.card_shipin_info.get(0));
                    this.feu.sl();
                    if (this.feu.getFid() == 0 && longValue != 0) {
                        this.feu.setFid(longValue);
                    }
                    this.feu.j(this.fed);
                    this.feu.ar(!this.feu.rn());
                    if (this.feu.getAuthor() != null && this.feu.getAuthor().getPendantData() == null && (metaData = this.userMap.get(this.feu.getAuthor().getUserId())) != null && metaData.getPendantData() != null) {
                        com.baidu.tbadk.data.k kVar = new com.baidu.tbadk.data.k();
                        kVar.O(metaData.getPendantData().Cb());
                        kVar.cs(metaData.getPendantData().pS());
                        this.feu.getAuthor().setPendantData(kVar);
                    }
                }
                if (dataRes.school_recom_info != null) {
                    this.few = dataRes.school_recom_pos.intValue();
                    this.fev = new aw();
                    this.fev.a(dataRes.school_recom_info);
                }
                if (dataRes.carrier_enter != null) {
                    this.fex = new com.baidu.tbadk.core.data.m();
                    this.fex.a(dataRes.carrier_enter);
                }
                if (dataRes.banner_thread_list != null) {
                    this.fez.clear();
                    int size2 = dataRes.banner_thread_list.size();
                    for (int i5 = 0; i5 < size2; i5++) {
                        BannerThreadInfoData bannerThreadInfoData = new BannerThreadInfoData();
                        bannerThreadInfoData.parserProtobuf(dataRes.banner_thread_list.get(i5));
                        this.fez.add(bannerThreadInfoData);
                    }
                }
                if (dataRes.vitality_info != null && dataRes.vitality_info.frequently_forum_info != null) {
                    this.feA = dataRes.vitality_info.frequently_forum_info.forum_state.intValue();
                    this.feB = dataRes.vitality_info.frequently_forum_info.access_flag.intValue();
                }
                this.mSortType = dataRes.sort_type.intValue();
                this.fdP = dataRes.need_log.intValue();
                com.baidu.tieba.recapp.c.a.aYn().pA(dataRes.asp_shown_info);
                this.feC = dataRes.card_shipin_pos;
                if (dataRes.card_shipin_new != null) {
                    for (int i6 = 0; i6 < dataRes.card_shipin_new.size(); i6++) {
                        bg bgVar = new bg();
                        if (this.feC != null && this.feC.size() >= dataRes.card_shipin_new.size()) {
                            bgVar.bZ(this.feC.get(i6).intValue());
                        }
                        bgVar.as(true);
                        bgVar.a(dataRes.card_shipin_new.get(i6));
                        this.feD.add(bgVar);
                    }
                }
                if (dataRes.bottle != null) {
                    this.isShowDriftingBottle = dataRes.bottle.has_enter_display.intValue() == 1;
                    this.feE = dataRes.bottle.tid.longValue();
                } else {
                    this.isShowDriftingBottle = false;
                    this.feE = 0L;
                }
                this.feF = dataRes.enter_pop_info;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    private void qX(int i) {
        this.fek = 1;
        if (this.fei != null && this.fei.size() > 0) {
            for (FrsTabInfo frsTabInfo : this.fei) {
                if (frsTabInfo != null && frsTabInfo.tab_id.intValue() == i) {
                    this.fek = i;
                    return;
                }
            }
        }
    }

    public void b(List<ThreadInfo> list, long j) {
        if (list != null) {
            boolean appResponseToIntentClass = TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
            for (int i = 0; i < list.size(); i++) {
                bg bgVar = new bg();
                bgVar.setUserMap(this.userMap);
                bgVar.a(list.get(i));
                bgVar.sl();
                if (bgVar.getFid() == 0 && j != 0) {
                    bgVar.setFid(j);
                }
                bgVar.j(this.fed);
                if (bgVar.getThreadType() == 33 && !bgVar.se()) {
                    at atVar = new at();
                    atVar.a(bgVar, 0);
                    atVar.p(beh());
                    if (appResponseToIntentClass) {
                        this.threadList.add(atVar);
                    }
                } else if (!TextUtils.isEmpty(bgVar.sy())) {
                    com.baidu.tbadk.core.data.ag agVar = new com.baidu.tbadk.core.data.ag();
                    agVar.cq(bgVar.sy());
                    this.threadList.add(agVar);
                } else {
                    this.threadList.add(bgVar);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] Eu() {
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

    public ForumData aIk() {
        return this.dWw;
    }

    public int bdW() {
        return this.feA;
    }

    public void qY(int i) {
        this.feA = i;
    }

    public int bdX() {
        return this.feB;
    }

    public void qZ(int i) {
        this.feB = i;
    }

    public void c(ForumData forumData) {
        this.dWw = forumData;
    }

    public ArrayList<com.baidu.adp.widget.ListView.v> getThreadList() {
        return this.threadList;
    }

    public void at(ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        this.threadList = arrayList;
    }

    public AntiData qt() {
        return this.Sc;
    }

    public void d(AntiData antiData) {
        this.Sc = antiData;
    }

    public an getPage() {
        return this.dcN;
    }

    public void a(an anVar) {
        this.dcN = anVar;
    }

    public n bdY() {
        return this.fdR;
    }

    public void a(n nVar) {
        this.fdR = nVar;
    }

    public com.baidu.tbadk.core.data.p bdZ() {
        return this.feh;
    }

    public void b(com.baidu.tbadk.core.data.p pVar) {
        this.feh = pVar;
    }

    public boolean bea() {
        return this.fdS;
    }

    public void kQ(boolean z) {
        this.fdS = z;
    }

    public String beb() {
        return this.fdT;
    }

    public void pT(String str) {
        this.fdT = str;
    }

    public p bec() {
        return this.fdU;
    }

    public void a(p pVar) {
        this.fdU = pVar;
    }

    public UserData getUserData() {
        return this.dWC;
    }

    public void h(UserData userData) {
        this.dWC = userData;
    }

    public List<Long> bed() {
        return this.fdQ;
    }

    public void cS(List<Long> list) {
        this.fdQ = list;
    }

    public b bee() {
        return this.fdV;
    }

    public void a(b bVar) {
        this.fdV = bVar;
    }

    public boolean bef() {
        return this.fdW;
    }

    public void kR(boolean z) {
        this.fdW = z;
    }

    public String getGameName() {
        return this.gameName;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public List<g> beg() {
        return this.fdX;
    }

    public void cT(List<g> list) {
        this.fdX = list;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public int aIv() {
        return this.fdY;
    }

    public void lE(int i) {
        this.fdY = i;
    }

    public List<PhotoLiveCardData> beh() {
        return this.fdZ;
    }

    public String bei() {
        return this.fec;
    }

    public void pU(String str) {
        this.fec = str;
    }

    public List<FrsTabInfo> bej() {
        return this.fei;
    }

    public void cU(List<FrsTabInfo> list) {
        this.fei = list;
    }

    public void cV(List<PhotoLiveCardData> list) {
        this.fdZ = list;
    }

    public boolean bek() {
        return this.feb != null;
    }

    public PhotoLiveCardData bel() {
        return this.feb;
    }

    public void c(PhotoLiveCardData photoLiveCardData) {
        this.feb = photoLiveCardData;
    }

    public com.baidu.tbadk.core.data.z bem() {
        return this.fef;
    }

    public void a(com.baidu.tbadk.core.data.z zVar) {
        this.fef = zVar;
    }

    public com.baidu.tbadk.core.data.x ben() {
        return this.feg;
    }

    public void a(com.baidu.tbadk.core.data.x xVar) {
        this.feg = xVar;
    }

    public int beo() {
        return this.fea;
    }

    public void ra(int i) {
        this.fea = i;
    }

    public List<FeedForumData> bep() {
        return this.fel;
    }

    public void cW(List<FeedForumData> list) {
        this.fel = list;
    }

    public void pV(String str) {
        if (this.fel != null && str != null) {
            for (FeedForumData feedForumData : this.fel) {
                if (feedForumData != null && feedForumData.getForumId() != null && feedForumData.getForumId().equals(str)) {
                    this.fel.remove(feedForumData);
                    return;
                }
            }
        }
    }

    public List<CategoryInfo> beq() {
        return this.fem;
    }

    public void cX(List<CategoryInfo> list) {
        this.fem = list;
    }

    public void pW(String str) {
        this.fen = str;
    }

    public String ber() {
        return this.fen;
    }

    public bg bes() {
        return this.feu;
    }

    public void B(bg bgVar) {
        this.feu = bgVar;
    }

    public int bet() {
        return this.fek;
    }

    public void rb(int i) {
        this.fek = i;
    }

    public com.baidu.tbadk.core.data.w beu() {
        return this.feo;
    }

    public void b(com.baidu.tbadk.core.data.w wVar) {
        this.feo = wVar;
    }

    public com.baidu.tbadk.core.data.q bev() {
        return this.feq;
    }

    public void a(com.baidu.tbadk.core.data.q qVar) {
        this.feq = qVar;
    }

    public com.baidu.tbadk.core.data.s bew() {
        return this.fet;
    }

    public void a(com.baidu.tbadk.core.data.s sVar) {
        this.fet = sVar;
    }

    public int bex() {
        return this.few;
    }

    public void rc(int i) {
        this.few = i;
    }

    public aw bey() {
        return this.fev;
    }

    public void a(aw awVar) {
        this.fev = awVar;
    }

    public NavTabInfo bez() {
        return this.fej;
    }

    public void a(NavTabInfo navTabInfo) {
        this.fej = navTabInfo;
    }

    public com.baidu.tbadk.core.data.m beA() {
        return this.fex;
    }

    public void a(com.baidu.tbadk.core.data.m mVar) {
        this.fex = mVar;
    }

    public void cY(List<BannerThreadInfoData> list) {
        this.fez = list;
    }

    public List<BannerThreadInfoData> beB() {
        return this.fez;
    }

    public int aaV() {
        return this.mSortType;
    }

    public Integer beC() {
        return this.fer;
    }

    public void g(Integer num) {
        this.fer = num;
    }

    public List<Integer> beD() {
        return this.feC;
    }

    public void cZ(List<Integer> list) {
        this.feC = list;
    }

    public List<com.baidu.adp.widget.ListView.v> beE() {
        return this.feD;
    }

    public void da(List<com.baidu.adp.widget.ListView.v> list) {
        this.feD = list;
    }

    public boolean isShowDriftingBottle() {
        return this.isShowDriftingBottle;
    }

    public long beF() {
        return this.feE;
    }

    public void kS(boolean z) {
        this.isShowDriftingBottle = z;
    }

    public void cF(long j) {
        this.feE = j;
    }
}

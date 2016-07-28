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
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.util.ba;
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
    private AntiData OT;
    protected ForumData dXV;
    private UserData dYb;
    protected com.baidu.tbadk.core.data.aj dhe;
    private List<FeedForumData> fiB;
    private List<CategoryInfo> fiC;
    private be fiG;
    private as fiH;
    private com.baidu.tbadk.core.data.l fiJ;
    protected List<Long> fih;
    private o fii;
    protected boolean fij;
    protected String fik;
    protected q fil;
    private b fim;
    private boolean fin;
    private List<PhotoLiveCardData> fiq;
    private int fir;
    private PhotoLiveCardData fis;
    private String fit;
    private com.baidu.tbadk.core.data.v fiv;
    private List<FrsTabInfo> fiy;
    private NavTabInfo fiz;
    private String gameName;
    private int mSortType;
    protected ArrayList<com.baidu.adp.widget.ListView.v> threadList;
    private HashMap<String, MetaData> userMap;
    public int fig = 0;
    private List<h> fio = new ArrayList();
    private int fip = 0;
    private ArrayList<com.baidu.tbadk.core.data.n> fiu = new ArrayList<>();
    protected com.baidu.tbadk.core.data.p fiw = null;
    private int fiA = 1;
    private String fiD = null;
    private com.baidu.tbadk.core.data.t fiE = null;
    public com.baidu.tbadk.core.data.u fiF = null;
    private int fiI = -1;
    protected List<com.baidu.adp.widget.ListView.v> fiK = null;
    private List<BannerThreadInfoData> fiL = null;
    private int fiM = 0;
    private int fiN = 0;

    public n() {
        initData();
    }

    private void initData() {
        this.dXV = new ForumData();
        this.threadList = new ArrayList<>();
        this.fiK = new ArrayList();
        this.userMap = new HashMap<>();
        this.dhe = new com.baidu.tbadk.core.data.aj();
        this.fii = new o();
        this.dYb = new UserData();
        this.fil = new q();
        d(new AntiData());
        a(new b());
        this.fiL = new ArrayList();
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
        if (dataRes != null) {
            try {
                initData();
                if (dataRes.color_egg != null && dataRes.color_egg.size() > 0) {
                    for (ColorEgg colorEgg : dataRes.color_egg) {
                        if (colorEgg != null && colorEgg.holiday_words != null && colorEgg.holiday_words.size() > 0) {
                            com.baidu.tbadk.core.data.n nVar = new com.baidu.tbadk.core.data.n();
                            if (nVar.a(colorEgg)) {
                                this.fiu.add(nVar);
                            }
                        }
                    }
                }
                if (dataRes.activityhead != null && dataRes.activityhead.head_imgs != null && dataRes.activityhead.head_imgs.size() > 0) {
                    this.fiw = new com.baidu.tbadk.core.data.p();
                    this.fiw.a(dataRes.activityhead);
                }
                List<User> list = dataRes.user_list;
                if (list != null) {
                    for (int i = 0; i < list.size(); i++) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(list.get(i));
                        String userId = metaData.getUserId();
                        if (userId != null && !userId.equals("0")) {
                            this.userMap.put(metaData.getUserId(), metaData);
                        }
                    }
                }
                lO(dataRes.is_new_url.intValue());
                this.fij = dataRes.fortune_bag.intValue() == 1;
                this.fik = dataRes.fortune_desc;
                if (dataRes.forum != null) {
                    this.fin = dataRes.forum.has_game.intValue() == 1;
                    this.fit = dataRes.forum.game_url;
                    this.gameName = dataRes.forum.game_name;
                }
                List<StarEnter> list2 = dataRes.star_enter;
                this.fio.clear();
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        h hVar = new h();
                        hVar.a(list2.get(i2));
                        this.fio.add(hVar);
                    }
                }
                this.fil.a(dataRes.gcon_account);
                this.dXV.parserProtobuf(dataRes.forum);
                long longValue = dataRes.forum != null ? dataRes.forum.id.longValue() : 0L;
                this.fih = dataRes.thread_id_list;
                this.OT.parserProtobuf(dataRes.anti);
                this.fim.a(dataRes.group);
                this.dhe.a(dataRes.page);
                this.fii.a(dataRes.frs_star);
                this.dYb.parserProtobuf(dataRes.user);
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.dYb.getIsSelectTail());
                }
                this.fiy = dataRes.frs_tab_info;
                if (dataRes.nav_tab_info == null) {
                    NavTabInfo.Builder builder = new NavTabInfo.Builder();
                    builder.tab = dataRes.frs_tab_info;
                    this.fiz = builder.build(true);
                } else {
                    this.fiz = dataRes.nav_tab_info;
                }
                qM(dataRes.frs_tab_default.intValue());
                List<ZhiBoInfoTW> list3 = dataRes.twzhibo_info;
                if (list3 != null && list3.size() > 0) {
                    this.fiq = new ArrayList();
                    int size = list3.size();
                    int i3 = -1;
                    for (int i4 = 0; i4 < size; i4++) {
                        PhotoLiveCardData photoLiveCardData = new PhotoLiveCardData();
                        photoLiveCardData.parserProtobuf(list3.get(i4));
                        if (photoLiveCardData.getShowStyle() < 0) {
                            photoLiveCardData.setShowStyle(photoLiveCardData.getRandom(3, i3));
                        }
                        i3 = photoLiveCardData.getShowStyle();
                        photoLiveCardData.setShowExpressionViewIndexList(photoLiveCardData.getExpressionDatas());
                        this.fiq.add(photoLiveCardData);
                    }
                }
                this.fir = dataRes.twzhibo_pos.intValue();
                if (dataRes.hot_twzhibo_info != null) {
                    this.fis = new PhotoLiveCardData();
                    if (this.fis.getShowStyle() < 0) {
                        this.fis.setShowStyle(this.fis.getRandom(3, -1));
                    }
                    this.fis.getShowStyle();
                    this.fis.parserProtobuf(dataRes.hot_twzhibo_info);
                    this.fis.setShowExpressionViewIndexList(this.fis.getExpressionDatas());
                }
                a(dataRes.thread_list, longValue);
                this.fiC = dataRes.category_list;
                if (!ba.isEmpty(dataRes.bawu_enter_url)) {
                    this.fiD = dataRes.bawu_enter_url;
                }
                if (dataRes.head_sdk != null) {
                    this.fiE = new com.baidu.tbadk.core.data.t();
                    this.fiE.a(dataRes.head_sdk);
                }
                if (dataRes.recommend_book != null) {
                    this.fiF = new com.baidu.tbadk.core.data.u();
                    this.fiF.a(dataRes.recommend_book);
                }
                if (dataRes.store_card != null) {
                    this.fiv = new com.baidu.tbadk.core.data.v();
                    this.fiv.a(dataRes.store_card);
                }
                if (dataRes.card_shipin_info != null && dataRes.card_shipin_info.size() > 0) {
                    this.fiG = new be();
                    this.fiG.setUserMap(this.userMap);
                    this.fiG.a(dataRes.card_shipin_info.get(0));
                    this.fiG.rd();
                    if (this.fiG.getFid() == 0 && longValue != 0) {
                        this.fiG.setFid(longValue);
                    }
                    this.fiG.j(this.fiu);
                    this.fiG.ao(true);
                }
                if (dataRes.school_recom_info != null) {
                    this.fiI = dataRes.school_recom_pos.intValue();
                    this.fiH = new as();
                    this.fiH.a(dataRes.school_recom_info);
                }
                if (dataRes.carrier_enter != null) {
                    this.fiJ = new com.baidu.tbadk.core.data.l();
                    this.fiJ.a(dataRes.carrier_enter);
                }
                if (dataRes.banner_thread_list != null) {
                    this.fiL.clear();
                    int size2 = dataRes.banner_thread_list.size();
                    for (int i5 = 0; i5 < size2; i5++) {
                        BannerThreadInfoData bannerThreadInfoData = new BannerThreadInfoData();
                        bannerThreadInfoData.parserProtobuf(dataRes.banner_thread_list.get(i5));
                        this.fiL.add(bannerThreadInfoData);
                    }
                }
                if (dataRes.vitality_info != null && dataRes.vitality_info.frequently_forum_info != null) {
                    this.fiM = dataRes.vitality_info.frequently_forum_info.forum_state.intValue();
                    this.fiN = dataRes.vitality_info.frequently_forum_info.access_flag.intValue();
                }
                this.mSortType = dataRes.sort_type.intValue();
                this.fig = dataRes.need_log.intValue();
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    private void qM(int i) {
        this.fiA = 1;
        if (this.fiy != null && this.fiy.size() > 0) {
            for (FrsTabInfo frsTabInfo : this.fiy) {
                if (frsTabInfo != null && frsTabInfo.tab_id.intValue() == i) {
                    this.fiA = i;
                    return;
                }
            }
        }
    }

    public void a(List<ThreadInfo> list, long j) {
        if (list != null) {
            boolean appResponseToIntentClass = TbadkCoreApplication.m10getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
            for (int i = 0; i < list.size(); i++) {
                be beVar = new be();
                beVar.setUserMap(this.userMap);
                beVar.a(list.get(i));
                beVar.rd();
                if (beVar.getFid() == 0 && j != 0) {
                    beVar.setFid(j);
                }
                beVar.j(this.fiu);
                if (beVar.getThreadType() == 33 && !beVar.qW()) {
                    ao aoVar = new ao();
                    aoVar.a(beVar, 0);
                    aoVar.p(bdK());
                    if (appResponseToIntentClass) {
                        this.threadList.add(aoVar);
                    }
                } else if (!TextUtils.isEmpty(beVar.rq())) {
                    com.baidu.tbadk.core.data.ac acVar = new com.baidu.tbadk.core.data.ac();
                    acVar.cm(beVar.rq());
                    this.threadList.add(acVar);
                } else {
                    this.threadList.add(beVar);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] Dn() {
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

    public ForumData aGX() {
        return this.dXV;
    }

    public int bdz() {
        return this.fiM;
    }

    public void qN(int i) {
        this.fiM = i;
    }

    public int bdA() {
        return this.fiN;
    }

    public void qO(int i) {
        this.fiN = i;
    }

    public void c(ForumData forumData) {
        this.dXV = forumData;
    }

    public ArrayList<com.baidu.adp.widget.ListView.v> getThreadList() {
        return this.threadList;
    }

    public void aB(ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        this.threadList = arrayList;
    }

    public AntiData pc() {
        return this.OT;
    }

    public void d(AntiData antiData) {
        this.OT = antiData;
    }

    public com.baidu.tbadk.core.data.aj getPage() {
        return this.dhe;
    }

    public void a(com.baidu.tbadk.core.data.aj ajVar) {
        this.dhe = ajVar;
    }

    public o bdB() {
        return this.fii;
    }

    public void a(o oVar) {
        this.fii = oVar;
    }

    public com.baidu.tbadk.core.data.p bdC() {
        return this.fiw;
    }

    public void b(com.baidu.tbadk.core.data.p pVar) {
        this.fiw = pVar;
    }

    public boolean bdD() {
        return this.fij;
    }

    public void ku(boolean z) {
        this.fij = z;
    }

    public String bdE() {
        return this.fik;
    }

    public void pX(String str) {
        this.fik = str;
    }

    public q bdF() {
        return this.fil;
    }

    public void a(q qVar) {
        this.fil = qVar;
    }

    public UserData getUserData() {
        return this.dYb;
    }

    public void f(UserData userData) {
        this.dYb = userData;
    }

    public List<Long> bdG() {
        return this.fih;
    }

    public void cT(List<Long> list) {
        this.fih = list;
    }

    public b bdH() {
        return this.fim;
    }

    public void a(b bVar) {
        this.fim = bVar;
    }

    public boolean bdI() {
        return this.fin;
    }

    public void kv(boolean z) {
        this.fin = z;
    }

    public String getGameName() {
        return this.gameName;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public List<h> bdJ() {
        return this.fio;
    }

    public void cU(List<h> list) {
        this.fio = list;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public int aHg() {
        return this.fip;
    }

    public void lO(int i) {
        this.fip = i;
    }

    public List<PhotoLiveCardData> bdK() {
        return this.fiq;
    }

    public String bdL() {
        return this.fit;
    }

    public void pY(String str) {
        this.fit = str;
    }

    public List<FrsTabInfo> bdM() {
        return this.fiy;
    }

    public void cV(List<FrsTabInfo> list) {
        this.fiy = list;
    }

    public void cW(List<PhotoLiveCardData> list) {
        this.fiq = list;
    }

    public boolean bdN() {
        return this.fis != null;
    }

    public PhotoLiveCardData bdO() {
        return this.fis;
    }

    public void c(PhotoLiveCardData photoLiveCardData) {
        this.fis = photoLiveCardData;
    }

    public com.baidu.tbadk.core.data.v bdP() {
        return this.fiv;
    }

    public void a(com.baidu.tbadk.core.data.v vVar) {
        this.fiv = vVar;
    }

    public int bdQ() {
        return this.fir;
    }

    public void qP(int i) {
        this.fir = i;
    }

    public List<FeedForumData> bdR() {
        return this.fiB;
    }

    public void cX(List<FeedForumData> list) {
        this.fiB = list;
    }

    public void pZ(String str) {
        if (this.fiB != null && str != null) {
            for (FeedForumData feedForumData : this.fiB) {
                if (feedForumData != null && feedForumData.getForumId() != null && feedForumData.getForumId().equals(str)) {
                    this.fiB.remove(feedForumData);
                    return;
                }
            }
        }
    }

    public List<CategoryInfo> bdS() {
        return this.fiC;
    }

    public void cY(List<CategoryInfo> list) {
        this.fiC = list;
    }

    public void qa(String str) {
        this.fiD = str;
    }

    public String bdT() {
        return this.fiD;
    }

    public be bdU() {
        return this.fiG;
    }

    public void u(be beVar) {
        this.fiG = beVar;
    }

    public int bdV() {
        return this.fiA;
    }

    public void qQ(int i) {
        this.fiA = i;
    }

    public com.baidu.tbadk.core.data.t bdW() {
        return this.fiE;
    }

    public void b(com.baidu.tbadk.core.data.t tVar) {
        this.fiE = tVar;
    }

    public int bdX() {
        return this.fiI;
    }

    public void qR(int i) {
        this.fiI = i;
    }

    public as bdY() {
        return this.fiH;
    }

    public void a(as asVar) {
        this.fiH = asVar;
    }

    public NavTabInfo bdZ() {
        return this.fiz;
    }

    public void a(NavTabInfo navTabInfo) {
        this.fiz = navTabInfo;
    }

    public com.baidu.tbadk.core.data.l bea() {
        return this.fiJ;
    }

    public void a(com.baidu.tbadk.core.data.l lVar) {
        this.fiJ = lVar;
    }

    public void cZ(List<BannerThreadInfoData> list) {
        this.fiL = list;
    }

    public List<BannerThreadInfoData> beb() {
        return this.fiL;
    }
}

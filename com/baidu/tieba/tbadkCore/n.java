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
import com.baidu.tbadk.core.data.ay;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.ax;
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
    private AntiData Sh;
    protected ao dzM;
    protected ForumData erU;
    private UserData esa;
    private List<com.baidu.adp.widget.ListView.v> fAA;
    private String fAa;
    private com.baidu.tbadk.core.data.aa fAc;
    private com.baidu.tbadk.core.data.y fAd;
    private List<FrsTabInfo> fAf;
    private NavTabInfo fAg;
    private List<FeedForumData> fAi;
    private List<CategoryInfo> fAj;
    private bk fAr;
    private ay fAs;
    private com.baidu.tbadk.core.data.m fAu;
    private List<Integer> fAz;
    protected List<Long> fzO;
    private o fzP;
    protected boolean fzQ;
    protected String fzR;
    protected q fzS;
    private b fzT;
    private boolean fzU;
    private List<PhotoLiveCardData> fzX;
    private int fzY;
    private PhotoLiveCardData fzZ;
    private String gameName;
    private int mSortType;
    protected ArrayList<com.baidu.adp.widget.ListView.v> threadList;
    private HashMap<String, MetaData> userMap;
    public int fzN = 0;
    private List<h> fzV = new ArrayList();
    private int fzW = 0;
    private ArrayList<com.baidu.tbadk.core.data.o> fAb = new ArrayList<>();
    protected com.baidu.tbadk.core.data.q fAe = null;
    private int fAh = 1;
    private String fAk = null;
    private com.baidu.tbadk.core.data.x fAl = null;
    public com.baidu.tbadk.core.data.z fAm = null;
    private com.baidu.tbadk.core.data.r fAn = null;
    private Integer fAo = -1;
    public com.baidu.tbadk.core.data.v fAp = null;
    private com.baidu.tbadk.core.data.t fAq = null;
    private int fAt = -1;
    protected List<com.baidu.adp.widget.ListView.v> fAv = null;
    private List<BannerThreadInfoData> fAw = null;
    private int fAx = 0;
    private int fAy = 0;

    public n() {
        initData();
    }

    private void initData() {
        this.erU = new ForumData();
        this.threadList = new ArrayList<>();
        this.fAv = new ArrayList();
        this.userMap = new HashMap<>();
        this.dzM = new ao();
        this.fzP = new o();
        this.esa = new UserData();
        this.fzS = new q();
        d(new AntiData());
        a(new b());
        this.fAw = new ArrayList();
        this.fAA = new ArrayList();
        this.fAz = new ArrayList();
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
                                this.fAb.add(oVar);
                            }
                        }
                    }
                }
                if (dataRes.activityhead != null && !com.baidu.tbadk.core.util.x.t(dataRes.activityhead.head_imgs)) {
                    this.fAe = new com.baidu.tbadk.core.data.q();
                    this.fAe.a(dataRes.activityhead);
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
                mH(dataRes.is_new_url.intValue());
                this.fzQ = dataRes.fortune_bag.intValue() == 1;
                this.fzR = dataRes.fortune_desc;
                if (dataRes.forum != null) {
                    this.fzU = dataRes.forum.has_game.intValue() == 1;
                    this.fAa = dataRes.forum.game_url;
                    this.gameName = dataRes.forum.game_name;
                }
                List<StarEnter> list2 = dataRes.star_enter;
                this.fzV.clear();
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        h hVar = new h();
                        hVar.a(list2.get(i2));
                        this.fzV.add(hVar);
                    }
                }
                this.fzS.a(dataRes.gcon_account);
                this.erU.parserProtobuf(dataRes.forum);
                long longValue = dataRes.forum != null ? dataRes.forum.id.longValue() : 0L;
                this.fzO = dataRes.thread_id_list;
                this.Sh.parserProtobuf(dataRes.anti);
                this.fzT.a(dataRes.group);
                this.dzM.a(dataRes.page);
                this.fzP.a(dataRes.frs_star);
                this.esa.parserProtobuf(dataRes.user);
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.esa.getIsSelectTail());
                }
                this.fAf = dataRes.frs_tab_info;
                if (dataRes.nav_tab_info == null) {
                    NavTabInfo.Builder builder = new NavTabInfo.Builder();
                    builder.tab = dataRes.frs_tab_info;
                    this.fAg = builder.build(true);
                } else {
                    this.fAg = dataRes.nav_tab_info;
                }
                rU(dataRes.frs_tab_default.intValue());
                List<ZhiBoInfoTW> list3 = dataRes.twzhibo_info;
                if (list3 != null && list3.size() > 0) {
                    this.fzX = new ArrayList();
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
                        this.fzX.add(photoLiveCardData);
                    }
                }
                this.fzY = dataRes.twzhibo_pos.intValue();
                if (dataRes.hot_twzhibo_info != null) {
                    this.fzZ = new PhotoLiveCardData();
                    if (this.fzZ.getShowStyle() < 0) {
                        this.fzZ.setShowStyle(PhotoLiveCardData.getRandom(3, -1));
                    }
                    this.fzZ.getShowStyle();
                    this.fzZ.parserProtobuf(dataRes.hot_twzhibo_info);
                    this.fzZ.setShowExpressionViewIndexList(this.fzZ.getExpressionDatas());
                }
                b(dataRes.thread_list, longValue);
                this.fAj = dataRes.category_list;
                if (!ax.isEmpty(dataRes.bawu_enter_url)) {
                    this.fAk = dataRes.bawu_enter_url;
                }
                if (dataRes.head_sdk != null) {
                    this.fAl = new com.baidu.tbadk.core.data.x();
                    this.fAl.a(dataRes.head_sdk);
                }
                if (dataRes.recommend_book != null) {
                    this.fAm = new com.baidu.tbadk.core.data.z();
                    this.fAm.a(dataRes.recommend_book);
                }
                if (dataRes.book_info != null) {
                    this.fAn = new com.baidu.tbadk.core.data.r();
                    this.fAn.a(dataRes.book_info);
                }
                if (dataRes.forum_present_info != null) {
                    this.fAp = new com.baidu.tbadk.core.data.v();
                    this.fAp.a(dataRes.forum_present_info);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.fAq = new com.baidu.tbadk.core.data.t();
                    this.fAq.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.store_card != null) {
                    this.fAc = new com.baidu.tbadk.core.data.aa();
                    this.fAc.a(dataRes.store_card);
                }
                if (dataRes.ntspread != null) {
                    this.fAd = new com.baidu.tbadk.core.data.y();
                    this.fAd.a(dataRes.ntspread);
                }
                if (dataRes.card_shipin_info != null && dataRes.card_shipin_info.size() > 0) {
                    this.fAr = new bk();
                    this.fAr.as(true);
                    this.fAr.bY(this.fzY);
                    this.fAr.setUserMap(this.userMap);
                    this.fAr.a(dataRes.card_shipin_info.get(0));
                    this.fAr.sw();
                    if (this.fAr.getFid() == 0 && longValue != 0) {
                        this.fAr.setFid(longValue);
                    }
                    this.fAr.j(this.fAb);
                    this.fAr.ar(!this.fAr.ry());
                    if (this.fAr.getAuthor() != null && this.fAr.getAuthor().getPendantData() == null && (metaData = this.userMap.get(this.fAr.getAuthor().getUserId())) != null && metaData.getPendantData() != null) {
                        com.baidu.tbadk.data.k kVar = new com.baidu.tbadk.data.k();
                        kVar.P(metaData.getPendantData().Co());
                        kVar.cs(metaData.getPendantData().pR());
                        this.fAr.getAuthor().setPendantData(kVar);
                    }
                }
                if (dataRes.school_recom_info != null) {
                    this.fAt = dataRes.school_recom_pos.intValue();
                    this.fAs = new ay();
                    this.fAs.a(dataRes.school_recom_info);
                }
                if (dataRes.carrier_enter != null) {
                    this.fAu = new com.baidu.tbadk.core.data.m();
                    this.fAu.a(dataRes.carrier_enter);
                }
                if (dataRes.banner_thread_list != null) {
                    this.fAw.clear();
                    int size2 = dataRes.banner_thread_list.size();
                    for (int i5 = 0; i5 < size2; i5++) {
                        BannerThreadInfoData bannerThreadInfoData = new BannerThreadInfoData();
                        bannerThreadInfoData.parserProtobuf(dataRes.banner_thread_list.get(i5));
                        this.fAw.add(bannerThreadInfoData);
                    }
                }
                if (dataRes.vitality_info != null && dataRes.vitality_info.frequently_forum_info != null) {
                    this.fAx = dataRes.vitality_info.frequently_forum_info.forum_state.intValue();
                    this.fAy = dataRes.vitality_info.frequently_forum_info.access_flag.intValue();
                }
                this.mSortType = dataRes.sort_type.intValue();
                this.fzN = dataRes.need_log.intValue();
                com.baidu.tieba.recapp.c.a.beA().qW(dataRes.asp_shown_info);
                this.fAz = dataRes.card_shipin_pos;
                if (dataRes.card_shipin_new != null) {
                    for (int i6 = 0; i6 < dataRes.card_shipin_new.size(); i6++) {
                        bk bkVar = new bk();
                        if (this.fAz != null && this.fAz.size() >= dataRes.card_shipin_new.size()) {
                            bkVar.bY(this.fAz.get(i6).intValue());
                        }
                        bkVar.as(true);
                        bkVar.a(dataRes.card_shipin_new.get(i6));
                        this.fAA.add(bkVar);
                    }
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    private void rU(int i) {
        this.fAh = 1;
        if (this.fAf != null && this.fAf.size() > 0) {
            for (FrsTabInfo frsTabInfo : this.fAf) {
                if (frsTabInfo != null && frsTabInfo.tab_id.intValue() == i) {
                    this.fAh = i;
                    return;
                }
            }
        }
    }

    public void b(List<ThreadInfo> list, long j) {
        if (list != null) {
            boolean appResponseToIntentClass = TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
            for (int i = 0; i < list.size(); i++) {
                bk bkVar = new bk();
                bkVar.setUserMap(this.userMap);
                bkVar.a(list.get(i));
                bkVar.sw();
                if (bkVar.getFid() == 0 && j != 0) {
                    bkVar.setFid(j);
                }
                bkVar.j(this.fAb);
                if (bkVar.getThreadType() == 33 && !bkVar.sp()) {
                    au auVar = new au();
                    auVar.a(bkVar, 0);
                    auVar.p(bkr());
                    if (appResponseToIntentClass) {
                        this.threadList.add(auVar);
                    }
                } else if (!TextUtils.isEmpty(bkVar.sJ())) {
                    com.baidu.tbadk.core.data.ah ahVar = new com.baidu.tbadk.core.data.ah();
                    ahVar.cp(bkVar.sJ());
                    this.threadList.add(ahVar);
                } else {
                    this.threadList.add(bkVar);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] EM() {
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

    public ForumData aOk() {
        return this.erU;
    }

    public int bkg() {
        return this.fAx;
    }

    public void rV(int i) {
        this.fAx = i;
    }

    public int bkh() {
        return this.fAy;
    }

    public void rW(int i) {
        this.fAy = i;
    }

    public void c(ForumData forumData) {
        this.erU = forumData;
    }

    public ArrayList<com.baidu.adp.widget.ListView.v> getThreadList() {
        return this.threadList;
    }

    public void aD(ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        this.threadList = arrayList;
    }

    public AntiData qs() {
        return this.Sh;
    }

    public void d(AntiData antiData) {
        this.Sh = antiData;
    }

    public ao getPage() {
        return this.dzM;
    }

    public void a(ao aoVar) {
        this.dzM = aoVar;
    }

    public o bki() {
        return this.fzP;
    }

    public void a(o oVar) {
        this.fzP = oVar;
    }

    public com.baidu.tbadk.core.data.q bkj() {
        return this.fAe;
    }

    public void b(com.baidu.tbadk.core.data.q qVar) {
        this.fAe = qVar;
    }

    public boolean bkk() {
        return this.fzQ;
    }

    public void lh(boolean z) {
        this.fzQ = z;
    }

    public String bkl() {
        return this.fzR;
    }

    public void rp(String str) {
        this.fzR = str;
    }

    public q bkm() {
        return this.fzS;
    }

    public void a(q qVar) {
        this.fzS = qVar;
    }

    public UserData getUserData() {
        return this.esa;
    }

    public void j(UserData userData) {
        this.esa = userData;
    }

    public List<Long> bkn() {
        return this.fzO;
    }

    public void dc(List<Long> list) {
        this.fzO = list;
    }

    public b bko() {
        return this.fzT;
    }

    public void a(b bVar) {
        this.fzT = bVar;
    }

    public boolean bkp() {
        return this.fzU;
    }

    public void li(boolean z) {
        this.fzU = z;
    }

    public String getGameName() {
        return this.gameName;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public List<h> bkq() {
        return this.fzV;
    }

    public void dd(List<h> list) {
        this.fzV = list;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public int aOu() {
        return this.fzW;
    }

    public void mH(int i) {
        this.fzW = i;
    }

    public List<PhotoLiveCardData> bkr() {
        return this.fzX;
    }

    public String bks() {
        return this.fAa;
    }

    public void rq(String str) {
        this.fAa = str;
    }

    public List<FrsTabInfo> bkt() {
        return this.fAf;
    }

    public void de(List<FrsTabInfo> list) {
        this.fAf = list;
    }

    public void df(List<PhotoLiveCardData> list) {
        this.fzX = list;
    }

    public boolean bku() {
        return this.fzZ != null;
    }

    public PhotoLiveCardData bkv() {
        return this.fzZ;
    }

    public void c(PhotoLiveCardData photoLiveCardData) {
        this.fzZ = photoLiveCardData;
    }

    public com.baidu.tbadk.core.data.aa bkw() {
        return this.fAc;
    }

    public void a(com.baidu.tbadk.core.data.aa aaVar) {
        this.fAc = aaVar;
    }

    public com.baidu.tbadk.core.data.y bkx() {
        return this.fAd;
    }

    public void a(com.baidu.tbadk.core.data.y yVar) {
        this.fAd = yVar;
    }

    public int bky() {
        return this.fzY;
    }

    public void rX(int i) {
        this.fzY = i;
    }

    public List<FeedForumData> bkz() {
        return this.fAi;
    }

    public void dg(List<FeedForumData> list) {
        this.fAi = list;
    }

    public void rr(String str) {
        if (this.fAi != null && str != null) {
            for (FeedForumData feedForumData : this.fAi) {
                if (feedForumData != null && feedForumData.getForumId() != null && feedForumData.getForumId().equals(str)) {
                    this.fAi.remove(feedForumData);
                    return;
                }
            }
        }
    }

    public List<CategoryInfo> bkA() {
        return this.fAj;
    }

    public void dh(List<CategoryInfo> list) {
        this.fAj = list;
    }

    public void rs(String str) {
        this.fAk = str;
    }

    public String bkB() {
        return this.fAk;
    }

    public bk bkC() {
        return this.fAr;
    }

    public void w(bk bkVar) {
        this.fAr = bkVar;
    }

    public int bkD() {
        return this.fAh;
    }

    public void rY(int i) {
        this.fAh = i;
    }

    public com.baidu.tbadk.core.data.x bkE() {
        return this.fAl;
    }

    public void b(com.baidu.tbadk.core.data.x xVar) {
        this.fAl = xVar;
    }

    public com.baidu.tbadk.core.data.r bkF() {
        return this.fAn;
    }

    public void a(com.baidu.tbadk.core.data.r rVar) {
        this.fAn = rVar;
    }

    public com.baidu.tbadk.core.data.t bkG() {
        return this.fAq;
    }

    public void a(com.baidu.tbadk.core.data.t tVar) {
        this.fAq = tVar;
    }

    public int bkH() {
        return this.fAt;
    }

    public void rZ(int i) {
        this.fAt = i;
    }

    public ay bkI() {
        return this.fAs;
    }

    public void a(ay ayVar) {
        this.fAs = ayVar;
    }

    public NavTabInfo bkJ() {
        return this.fAg;
    }

    public void a(NavTabInfo navTabInfo) {
        this.fAg = navTabInfo;
    }

    public com.baidu.tbadk.core.data.m bkK() {
        return this.fAu;
    }

    public void a(com.baidu.tbadk.core.data.m mVar) {
        this.fAu = mVar;
    }

    public void di(List<BannerThreadInfoData> list) {
        this.fAw = list;
    }

    public List<BannerThreadInfoData> bkL() {
        return this.fAw;
    }

    public Integer bkM() {
        return this.fAo;
    }

    public void h(Integer num) {
        this.fAo = num;
    }

    public List<Integer> bkN() {
        return this.fAz;
    }

    public void dj(List<Integer> list) {
        this.fAz = list;
    }

    public List<com.baidu.adp.widget.ListView.v> bkO() {
        return this.fAA;
    }

    public void dk(List<com.baidu.adp.widget.ListView.v> list) {
        this.fAA = list;
    }
}

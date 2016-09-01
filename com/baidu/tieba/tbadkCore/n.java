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
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.core.data.au;
import com.baidu.tbadk.core.data.bg;
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
    private AntiData RE;
    protected com.baidu.tbadk.core.data.ak dsK;
    protected ForumData ejZ;
    private UserData ekf;
    protected List<Long> fpY;
    private o fpZ;
    private com.baidu.tbadk.core.data.l fqB;
    protected boolean fqa;
    protected String fqb;
    protected q fqc;
    private b fqd;
    private boolean fqe;
    private List<PhotoLiveCardData> fqh;
    private int fqi;
    private PhotoLiveCardData fqj;
    private String fqk;
    private com.baidu.tbadk.core.data.w fqm;
    private List<FrsTabInfo> fqo;
    private NavTabInfo fqp;
    private List<FeedForumData> fqr;
    private List<CategoryInfo> fqs;
    private bg fqy;
    private au fqz;
    private String gameName;
    private int mSortType;
    protected ArrayList<com.baidu.adp.widget.ListView.v> threadList;
    private HashMap<String, MetaData> userMap;
    public int fpX = 0;
    private List<h> fqf = new ArrayList();
    private int fqg = 0;
    private ArrayList<com.baidu.tbadk.core.data.n> fql = new ArrayList<>();
    protected com.baidu.tbadk.core.data.p fqn = null;
    private int fqq = 1;
    private String fqt = null;
    private com.baidu.tbadk.core.data.u fqu = null;
    public com.baidu.tbadk.core.data.v fqv = null;
    private com.baidu.tbadk.core.data.q fqw = null;
    private Integer fqx = -1;
    private int fqA = -1;
    protected List<com.baidu.adp.widget.ListView.v> fqC = null;
    private List<BannerThreadInfoData> fqD = null;
    private int fqE = 0;
    private int fqF = 0;

    public n() {
        initData();
    }

    private void initData() {
        this.ejZ = new ForumData();
        this.threadList = new ArrayList<>();
        this.fqC = new ArrayList();
        this.userMap = new HashMap<>();
        this.dsK = new com.baidu.tbadk.core.data.ak();
        this.fpZ = new o();
        this.ekf = new UserData();
        this.fqc = new q();
        d(new AntiData());
        a(new b());
        this.fqD = new ArrayList();
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
        if (dataRes != null) {
            try {
                initData();
                if (dataRes.color_egg != null && dataRes.color_egg.size() > 0) {
                    for (ColorEgg colorEgg : dataRes.color_egg) {
                        if (colorEgg != null && colorEgg.holiday_words != null && colorEgg.holiday_words.size() > 0) {
                            com.baidu.tbadk.core.data.n nVar = new com.baidu.tbadk.core.data.n();
                            if (nVar.a(colorEgg)) {
                                this.fql.add(nVar);
                            }
                        }
                    }
                }
                if (dataRes.activityhead != null && dataRes.activityhead.head_imgs != null && dataRes.activityhead.head_imgs.size() > 0) {
                    this.fqn = new com.baidu.tbadk.core.data.p();
                    this.fqn.a(dataRes.activityhead);
                }
                List<User> list = dataRes.user_list;
                if (list != null) {
                    for (int i = 0; i < list.size(); i++) {
                        MetaData metaData2 = new MetaData();
                        metaData2.parserProtobuf(list.get(i));
                        String userId = metaData2.getUserId();
                        if (userId != null && !userId.equals("0")) {
                            this.userMap.put(metaData2.getUserId(), metaData2);
                        }
                    }
                }
                mr(dataRes.is_new_url.intValue());
                this.fqa = dataRes.fortune_bag.intValue() == 1;
                this.fqb = dataRes.fortune_desc;
                if (dataRes.forum != null) {
                    this.fqe = dataRes.forum.has_game.intValue() == 1;
                    this.fqk = dataRes.forum.game_url;
                    this.gameName = dataRes.forum.game_name;
                }
                List<StarEnter> list2 = dataRes.star_enter;
                this.fqf.clear();
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        h hVar = new h();
                        hVar.a(list2.get(i2));
                        this.fqf.add(hVar);
                    }
                }
                this.fqc.a(dataRes.gcon_account);
                this.ejZ.parserProtobuf(dataRes.forum);
                long longValue = dataRes.forum != null ? dataRes.forum.id.longValue() : 0L;
                this.fpY = dataRes.thread_id_list;
                this.RE.parserProtobuf(dataRes.anti);
                this.fqd.a(dataRes.group);
                this.dsK.a(dataRes.page);
                this.fpZ.a(dataRes.frs_star);
                this.ekf.parserProtobuf(dataRes.user);
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.ekf.getIsSelectTail());
                }
                this.fqo = dataRes.frs_tab_info;
                if (dataRes.nav_tab_info == null) {
                    NavTabInfo.Builder builder = new NavTabInfo.Builder();
                    builder.tab = dataRes.frs_tab_info;
                    this.fqp = builder.build(true);
                } else {
                    this.fqp = dataRes.nav_tab_info;
                }
                rn(dataRes.frs_tab_default.intValue());
                List<ZhiBoInfoTW> list3 = dataRes.twzhibo_info;
                if (list3 != null && list3.size() > 0) {
                    this.fqh = new ArrayList();
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
                        this.fqh.add(photoLiveCardData);
                    }
                }
                this.fqi = dataRes.twzhibo_pos.intValue();
                if (dataRes.hot_twzhibo_info != null) {
                    this.fqj = new PhotoLiveCardData();
                    if (this.fqj.getShowStyle() < 0) {
                        this.fqj.setShowStyle(PhotoLiveCardData.getRandom(3, -1));
                    }
                    this.fqj.getShowStyle();
                    this.fqj.parserProtobuf(dataRes.hot_twzhibo_info);
                    this.fqj.setShowExpressionViewIndexList(this.fqj.getExpressionDatas());
                }
                b(dataRes.thread_list, longValue);
                this.fqs = dataRes.category_list;
                if (!ba.isEmpty(dataRes.bawu_enter_url)) {
                    this.fqt = dataRes.bawu_enter_url;
                }
                if (dataRes.head_sdk != null) {
                    this.fqu = new com.baidu.tbadk.core.data.u();
                    this.fqu.a(dataRes.head_sdk);
                }
                if (dataRes.recommend_book != null) {
                    this.fqv = new com.baidu.tbadk.core.data.v();
                    this.fqv.a(dataRes.recommend_book);
                }
                if (dataRes.book_info != null) {
                    this.fqw = new com.baidu.tbadk.core.data.q();
                    this.fqw.a(dataRes.book_info);
                }
                if (dataRes.store_card != null) {
                    this.fqm = new com.baidu.tbadk.core.data.w();
                    this.fqm.a(dataRes.store_card);
                }
                if (dataRes.card_shipin_info != null && dataRes.card_shipin_info.size() > 0) {
                    this.fqy = new bg();
                    this.fqy.setUserMap(this.userMap);
                    this.fqy.a(dataRes.card_shipin_info.get(0));
                    this.fqy.si();
                    if (this.fqy.getFid() == 0 && longValue != 0) {
                        this.fqy.setFid(longValue);
                    }
                    this.fqy.j(this.fql);
                    this.fqy.ap(true);
                    if (this.fqy.getAuthor() != null && this.fqy.getAuthor().getPendantData() == null && (metaData = this.userMap.get(this.fqy.getAuthor().getUserId())) != null && metaData.getPendantData() != null) {
                        com.baidu.tbadk.data.j jVar = new com.baidu.tbadk.data.j();
                        jVar.P(metaData.getPendantData().Cd());
                        jVar.cq(metaData.getPendantData().rc());
                        this.fqy.getAuthor().setPendantData(jVar);
                    }
                }
                if (dataRes.school_recom_info != null) {
                    this.fqA = dataRes.school_recom_pos.intValue();
                    this.fqz = new au();
                    this.fqz.a(dataRes.school_recom_info);
                }
                if (dataRes.carrier_enter != null) {
                    this.fqB = new com.baidu.tbadk.core.data.l();
                    this.fqB.a(dataRes.carrier_enter);
                }
                if (dataRes.banner_thread_list != null) {
                    this.fqD.clear();
                    int size2 = dataRes.banner_thread_list.size();
                    for (int i5 = 0; i5 < size2; i5++) {
                        BannerThreadInfoData bannerThreadInfoData = new BannerThreadInfoData();
                        bannerThreadInfoData.parserProtobuf(dataRes.banner_thread_list.get(i5));
                        this.fqD.add(bannerThreadInfoData);
                    }
                }
                if (dataRes.vitality_info != null && dataRes.vitality_info.frequently_forum_info != null) {
                    this.fqE = dataRes.vitality_info.frequently_forum_info.forum_state.intValue();
                    this.fqF = dataRes.vitality_info.frequently_forum_info.access_flag.intValue();
                }
                this.mSortType = dataRes.sort_type.intValue();
                this.fpX = dataRes.need_log.intValue();
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    private void rn(int i) {
        this.fqq = 1;
        if (this.fqo != null && this.fqo.size() > 0) {
            for (FrsTabInfo frsTabInfo : this.fqo) {
                if (frsTabInfo != null && frsTabInfo.tab_id.intValue() == i) {
                    this.fqq = i;
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
                bgVar.si();
                if (bgVar.getFid() == 0 && j != 0) {
                    bgVar.setFid(j);
                }
                bgVar.j(this.fql);
                if (bgVar.getThreadType() == 33 && !bgVar.sb()) {
                    aq aqVar = new aq();
                    aqVar.a(bgVar, 0);
                    aqVar.p(bho());
                    if (appResponseToIntentClass) {
                        this.threadList.add(aqVar);
                    }
                } else if (!TextUtils.isEmpty(bgVar.sv())) {
                    com.baidu.tbadk.core.data.ad adVar = new com.baidu.tbadk.core.data.ad();
                    adVar.cn(bgVar.sv());
                    this.threadList.add(adVar);
                } else {
                    this.threadList.add(bgVar);
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

    public ForumData aLP() {
        return this.ejZ;
    }

    public int bhd() {
        return this.fqE;
    }

    public void ro(int i) {
        this.fqE = i;
    }

    public int bhe() {
        return this.fqF;
    }

    public void rp(int i) {
        this.fqF = i;
    }

    public void c(ForumData forumData) {
        this.ejZ = forumData;
    }

    public ArrayList<com.baidu.adp.widget.ListView.v> getThreadList() {
        return this.threadList;
    }

    public void aA(ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        this.threadList = arrayList;
    }

    public AntiData qf() {
        return this.RE;
    }

    public void d(AntiData antiData) {
        this.RE = antiData;
    }

    public com.baidu.tbadk.core.data.ak getPage() {
        return this.dsK;
    }

    public void a(com.baidu.tbadk.core.data.ak akVar) {
        this.dsK = akVar;
    }

    public o bhf() {
        return this.fpZ;
    }

    public void a(o oVar) {
        this.fpZ = oVar;
    }

    public com.baidu.tbadk.core.data.p bhg() {
        return this.fqn;
    }

    public void b(com.baidu.tbadk.core.data.p pVar) {
        this.fqn = pVar;
    }

    public boolean bhh() {
        return this.fqa;
    }

    public void kG(boolean z) {
        this.fqa = z;
    }

    public String bhi() {
        return this.fqb;
    }

    public void qH(String str) {
        this.fqb = str;
    }

    public q bhj() {
        return this.fqc;
    }

    public void a(q qVar) {
        this.fqc = qVar;
    }

    public UserData getUserData() {
        return this.ekf;
    }

    public void j(UserData userData) {
        this.ekf = userData;
    }

    public List<Long> bhk() {
        return this.fpY;
    }

    public void cX(List<Long> list) {
        this.fpY = list;
    }

    public b bhl() {
        return this.fqd;
    }

    public void a(b bVar) {
        this.fqd = bVar;
    }

    public boolean bhm() {
        return this.fqe;
    }

    public void kH(boolean z) {
        this.fqe = z;
    }

    public String getGameName() {
        return this.gameName;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public List<h> bhn() {
        return this.fqf;
    }

    public void cY(List<h> list) {
        this.fqf = list;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public int aLY() {
        return this.fqg;
    }

    public void mr(int i) {
        this.fqg = i;
    }

    public List<PhotoLiveCardData> bho() {
        return this.fqh;
    }

    public String bhp() {
        return this.fqk;
    }

    public void qI(String str) {
        this.fqk = str;
    }

    public List<FrsTabInfo> bhq() {
        return this.fqo;
    }

    public void cZ(List<FrsTabInfo> list) {
        this.fqo = list;
    }

    public void da(List<PhotoLiveCardData> list) {
        this.fqh = list;
    }

    public boolean bhr() {
        return this.fqj != null;
    }

    public PhotoLiveCardData bhs() {
        return this.fqj;
    }

    public void c(PhotoLiveCardData photoLiveCardData) {
        this.fqj = photoLiveCardData;
    }

    public com.baidu.tbadk.core.data.w bht() {
        return this.fqm;
    }

    public void a(com.baidu.tbadk.core.data.w wVar) {
        this.fqm = wVar;
    }

    public int bhu() {
        return this.fqi;
    }

    public void rq(int i) {
        this.fqi = i;
    }

    public List<FeedForumData> bhv() {
        return this.fqr;
    }

    public void db(List<FeedForumData> list) {
        this.fqr = list;
    }

    public void qJ(String str) {
        if (this.fqr != null && str != null) {
            for (FeedForumData feedForumData : this.fqr) {
                if (feedForumData != null && feedForumData.getForumId() != null && feedForumData.getForumId().equals(str)) {
                    this.fqr.remove(feedForumData);
                    return;
                }
            }
        }
    }

    public List<CategoryInfo> bhw() {
        return this.fqs;
    }

    public void dc(List<CategoryInfo> list) {
        this.fqs = list;
    }

    public void qK(String str) {
        this.fqt = str;
    }

    public String bhx() {
        return this.fqt;
    }

    public bg bhy() {
        return this.fqy;
    }

    public void u(bg bgVar) {
        this.fqy = bgVar;
    }

    public int bhz() {
        return this.fqq;
    }

    public void rr(int i) {
        this.fqq = i;
    }

    public com.baidu.tbadk.core.data.u bhA() {
        return this.fqu;
    }

    public void b(com.baidu.tbadk.core.data.u uVar) {
        this.fqu = uVar;
    }

    public com.baidu.tbadk.core.data.q bhB() {
        return this.fqw;
    }

    public void a(com.baidu.tbadk.core.data.q qVar) {
        this.fqw = qVar;
    }

    public int bhC() {
        return this.fqA;
    }

    public void rs(int i) {
        this.fqA = i;
    }

    public au bhD() {
        return this.fqz;
    }

    public void a(au auVar) {
        this.fqz = auVar;
    }

    public NavTabInfo bhE() {
        return this.fqp;
    }

    public void a(NavTabInfo navTabInfo) {
        this.fqp = navTabInfo;
    }

    public com.baidu.tbadk.core.data.l bhF() {
        return this.fqB;
    }

    public void a(com.baidu.tbadk.core.data.l lVar) {
        this.fqB = lVar;
    }

    public void dd(List<BannerThreadInfoData> list) {
        this.fqD = list;
    }

    public List<BannerThreadInfoData> bhG() {
        return this.fqD;
    }

    public Integer bhH() {
        return this.fqx;
    }

    public void h(Integer num) {
        this.fqx = num;
    }
}

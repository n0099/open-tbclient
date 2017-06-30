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
import com.baidu.tbadk.core.data.ai;
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.data.ay;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.util.aw;
import com.squareup.wire.Message;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;
import tbclient.CategoryInfo;
import tbclient.FrsPage.AgreeBanner;
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
    private AntiData Wa;
    protected as duF;
    protected ForumData erp;
    private UserData erv;
    protected List<Long> fJK;
    private m fJL;
    protected boolean fJM;
    protected String fJN;
    protected o fJO;
    private b fJP;
    private boolean fJQ;
    private List<PhotoLiveCardData> fJT;
    private int fJU;
    private PhotoLiveCardData fJV;
    private String fJW;
    private com.baidu.tbadk.core.data.aa fJY;
    private List<FrsTabInfo> fKa;
    private NavTabInfo fKb;
    private List<FeedForumData> fKd;
    private List<CategoryInfo> fKe;
    private bm fKm;
    private bb fKn;
    private com.baidu.tbadk.core.data.n fKp;
    private List<Integer> fKt;
    private List<com.baidu.adp.widget.ListView.v> fKu;
    public PopInfo fKw;
    private com.baidu.tieba.g.b fKx;
    private AgreeBanner fKy;
    private String gameName;
    private int mSortType;
    protected ArrayList<com.baidu.adp.widget.ListView.v> threadList;
    private HashMap<String, MetaData> userMap;
    public int fJJ = 0;
    private List<g> fJR = new ArrayList();
    private int fJS = 0;
    private ArrayList<com.baidu.tbadk.core.data.p> fJX = new ArrayList<>();
    protected com.baidu.tbadk.core.data.s fJZ = null;
    private int fKc = 1;
    private String fKf = null;
    private com.baidu.tbadk.core.data.z fKg = null;
    public com.baidu.tbadk.core.data.ab fKh = null;
    private com.baidu.tbadk.core.data.t fKi = null;
    private Integer fKj = -1;
    public com.baidu.tbadk.core.data.x fKk = null;
    private com.baidu.tbadk.core.data.v fKl = null;
    private int fKo = -1;
    protected List<com.baidu.adp.widget.ListView.v> fKq = null;
    private int fKr = 0;
    private int fKs = 0;
    private boolean isShowDriftingBottle = false;
    private long fKv = 0;
    private int alaLiveCount = 0;

    public l() {
        initData();
    }

    private void initData() {
        this.erp = new ForumData();
        this.threadList = new ArrayList<>();
        this.fKq = new ArrayList();
        this.userMap = new HashMap<>();
        this.duF = new as();
        this.fJL = new m();
        this.erv = new UserData();
        this.fJO = new o();
        d(new AntiData());
        a(new b());
        this.fKu = new ArrayList();
        this.fKt = new ArrayList();
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
                if (!com.baidu.tbadk.core.util.z.t(dataRes.color_egg)) {
                    for (ColorEgg colorEgg : dataRes.color_egg) {
                        if (colorEgg != null && !com.baidu.tbadk.core.util.z.t(colorEgg.holiday_words)) {
                            com.baidu.tbadk.core.data.p pVar = new com.baidu.tbadk.core.data.p();
                            if (pVar.a(colorEgg)) {
                                this.fJX.add(pVar);
                            }
                        }
                    }
                }
                if (dataRes.activityhead != null && !com.baidu.tbadk.core.util.z.t(dataRes.activityhead.head_imgs)) {
                    this.fJZ = new com.baidu.tbadk.core.data.s();
                    this.fJZ.a(dataRes.activityhead);
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
                mG(dataRes.is_new_url.intValue());
                this.fJM = dataRes.fortune_bag.intValue() == 1;
                this.fJN = dataRes.fortune_desc;
                if (dataRes.forum != null) {
                    this.fJQ = dataRes.forum.has_game.intValue() == 1;
                    this.fJW = dataRes.forum.game_url;
                    this.gameName = dataRes.forum.game_name;
                }
                List<StarEnter> list2 = dataRes.star_enter;
                this.fJR.clear();
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        g gVar = new g();
                        gVar.a(list2.get(i2));
                        this.fJR.add(gVar);
                    }
                }
                this.fJO.a(dataRes.gcon_account);
                this.erp.parserProtobuf(dataRes.forum);
                long longValue = dataRes.forum != null ? dataRes.forum.id.longValue() : 0L;
                this.fJK = dataRes.thread_id_list;
                this.Wa.parserProtobuf(dataRes.anti);
                this.fJP.a(dataRes.group);
                this.duF.a(dataRes.page);
                this.fJL.a(dataRes.frs_star);
                this.erv.parserProtobuf(dataRes.user);
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.erv.getIsSelectTail());
                }
                this.fKa = dataRes.frs_tab_info;
                if (dataRes.nav_tab_info == null) {
                    NavTabInfo.Builder builder = new NavTabInfo.Builder();
                    builder.tab = dataRes.frs_tab_info;
                    this.fKb = builder.build(true);
                } else {
                    this.fKb = dataRes.nav_tab_info;
                }
                this.alaLiveCount = dataRes.ala_live_count.intValue();
                st(dataRes.frs_tab_default.intValue());
                List<ZhiBoInfoTW> list3 = dataRes.twzhibo_info;
                if (list3 != null && list3.size() > 0) {
                    this.fJT = new ArrayList();
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
                        this.fJT.add(photoLiveCardData);
                    }
                }
                this.fJU = dataRes.twzhibo_pos.intValue();
                if (dataRes.hot_twzhibo_info != null) {
                    this.fJV = new PhotoLiveCardData();
                    if (this.fJV.getShowStyle() < 0) {
                        this.fJV.setShowStyle(PhotoLiveCardData.getRandom(3, -1));
                    }
                    this.fJV.getShowStyle();
                    this.fJV.parserProtobuf(dataRes.hot_twzhibo_info);
                    this.fJV.setShowExpressionViewIndexList(this.fJV.getExpressionDatas());
                }
                a(dataRes.thread_list, longValue);
                this.fKe = dataRes.category_list;
                if (!aw.isEmpty(dataRes.bawu_enter_url)) {
                    this.fKf = dataRes.bawu_enter_url;
                }
                if (dataRes.head_sdk != null) {
                    this.fKg = new com.baidu.tbadk.core.data.z();
                    this.fKg.a(dataRes.head_sdk);
                }
                if (dataRes.recommend_book != null) {
                    this.fKh = new com.baidu.tbadk.core.data.ab();
                    this.fKh.a(dataRes.recommend_book);
                }
                if (dataRes.book_info != null) {
                    this.fKi = new com.baidu.tbadk.core.data.t();
                    this.fKi.a(dataRes.book_info);
                }
                if (dataRes.forum_present_info != null) {
                    this.fKk = new com.baidu.tbadk.core.data.x();
                    this.fKk.a(dataRes.forum_present_info);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.fKl = new com.baidu.tbadk.core.data.v();
                    this.fKl.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.ntspread != null) {
                    this.fJY = new com.baidu.tbadk.core.data.aa();
                    this.fJY.a(dataRes.ntspread);
                }
                if (dataRes.card_shipin_info != null && dataRes.card_shipin_info.size() > 0) {
                    this.fKm = new bm();
                    this.fKm.ap(true);
                    this.fKm.bV(this.fJU);
                    this.fKm.setUserMap(this.userMap);
                    this.fKm.a(dataRes.card_shipin_info.get(0));
                    this.fKm.rZ();
                    if (this.fKm.getFid() == 0 && longValue != 0) {
                        this.fKm.setFid(longValue);
                    }
                    this.fKm.i(this.fJX);
                    this.fKm.ao(!this.fKm.qZ());
                    if (this.fKm.getAuthor() != null && this.fKm.getAuthor().getPendantData() == null && (metaData = this.userMap.get(this.fKm.getAuthor().getUserId())) != null && metaData.getPendantData() != null) {
                        com.baidu.tbadk.data.j jVar = new com.baidu.tbadk.data.j();
                        jVar.P(metaData.getPendantData().Ch());
                        jVar.cw(metaData.getPendantData().pI());
                        this.fKm.getAuthor().setPendantData(jVar);
                    }
                }
                if (dataRes.school_recom_info != null) {
                    this.fKo = dataRes.school_recom_pos.intValue();
                    this.fKn = new bb();
                    this.fKn.a(dataRes.school_recom_info);
                }
                if (dataRes.carrier_enter != null) {
                    this.fKp = new com.baidu.tbadk.core.data.n();
                    this.fKp.a(dataRes.carrier_enter);
                }
                if (dataRes.vitality_info != null && dataRes.vitality_info.frequently_forum_info != null) {
                    this.fKr = dataRes.vitality_info.frequently_forum_info.forum_state.intValue();
                    this.fKs = dataRes.vitality_info.frequently_forum_info.access_flag.intValue();
                }
                this.mSortType = dataRes.sort_type.intValue();
                this.fJJ = dataRes.need_log.intValue();
                com.baidu.tieba.recapp.d.a.bex().qD(dataRes.asp_shown_info);
                this.fKt = dataRes.card_shipin_pos;
                if (dataRes.card_shipin_new != null) {
                    for (int i5 = 0; i5 < dataRes.card_shipin_new.size(); i5++) {
                        bm bmVar = new bm();
                        if (this.fKt != null && this.fKt.size() >= dataRes.card_shipin_new.size()) {
                            bmVar.bV(this.fKt.get(i5).intValue());
                        }
                        bmVar.ap(true);
                        bmVar.a(dataRes.card_shipin_new.get(i5));
                        this.fKu.add(bmVar);
                    }
                }
                if (dataRes.bottle != null) {
                    this.isShowDriftingBottle = dataRes.bottle.has_enter_display.intValue() == 1;
                    this.fKv = dataRes.bottle.tid.longValue();
                } else {
                    this.isShowDriftingBottle = false;
                    this.fKv = 0L;
                }
                this.fKw = dataRes.enter_pop_info;
                if (dataRes.esport != null) {
                    this.fKx = new com.baidu.tieba.g.b();
                    this.fKx.a(dataRes.esport);
                }
                this.fKy = dataRes.agree_banner;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public AgreeBanner bkw() {
        return this.fKy;
    }

    public void a(AgreeBanner agreeBanner) {
        this.fKy = agreeBanner;
    }

    private void st(int i) {
        this.fKc = 1;
        if (this.fKa != null && this.fKa.size() > 0) {
            for (FrsTabInfo frsTabInfo : this.fKa) {
                if (frsTabInfo != null && frsTabInfo.tab_id.intValue() == i) {
                    this.fKc = i;
                    return;
                }
            }
        }
    }

    public void a(List<ThreadInfo> list, long j) {
        if (list != null) {
            boolean appResponseToIntentClass = TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
            for (int i = 0; i < list.size(); i++) {
                bm bmVar = new bm();
                bmVar.setUserMap(this.userMap);
                bmVar.a(list.get(i));
                bmVar.bW(3);
                bmVar.rZ();
                if (bmVar.getFid() == 0 && j != 0) {
                    bmVar.setFid(j);
                }
                if (StringUtils.isNull(bmVar.rw())) {
                    bmVar.cy(this.erp.getName());
                }
                bmVar.i(this.fJX);
                if (bmVar.getThreadType() == 33 && !bmVar.rS()) {
                    ay ayVar = new ay();
                    ayVar.a(bmVar, 0);
                    ayVar.p(bkJ());
                    if (appResponseToIntentClass) {
                        this.threadList.add(ayVar);
                    }
                } else if (!TextUtils.isEmpty(bmVar.sm())) {
                    ai aiVar = new ai();
                    aiVar.ct(bmVar.sm());
                    this.threadList.add(aiVar);
                } else {
                    this.threadList.add(bmVar);
                }
            }
        }
    }

    public int bkx() {
        return this.alaLiveCount;
    }

    public void su(int i) {
        this.alaLiveCount = i;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] EA() {
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
    public void n(JSONObject jSONObject) {
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void a(Message message) {
    }

    public ForumData aMt() {
        return this.erp;
    }

    public int bky() {
        return this.fKr;
    }

    public void sv(int i) {
        this.fKr = i;
    }

    public int bkz() {
        return this.fKs;
    }

    public void sw(int i) {
        this.fKs = i;
    }

    public void c(ForumData forumData) {
        this.erp = forumData;
    }

    public ArrayList<com.baidu.adp.widget.ListView.v> getThreadList() {
        return this.threadList;
    }

    public void az(ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        this.threadList = arrayList;
    }

    public AntiData qe() {
        return this.Wa;
    }

    public void d(AntiData antiData) {
        this.Wa = antiData;
    }

    public as qu() {
        return this.duF;
    }

    public void a(as asVar) {
        this.duF = asVar;
    }

    public m bkA() {
        return this.fJL;
    }

    public void a(m mVar) {
        this.fJL = mVar;
    }

    public com.baidu.tbadk.core.data.s bkB() {
        return this.fJZ;
    }

    public void a(com.baidu.tbadk.core.data.s sVar) {
        this.fJZ = sVar;
    }

    public boolean bkC() {
        return this.fJM;
    }

    public void lM(boolean z) {
        this.fJM = z;
    }

    public String bkD() {
        return this.fJN;
    }

    public void qZ(String str) {
        this.fJN = str;
    }

    public o bkE() {
        return this.fJO;
    }

    public void a(o oVar) {
        this.fJO = oVar;
    }

    public UserData getUserData() {
        return this.erv;
    }

    public void d(UserData userData) {
        this.erv = userData;
    }

    public List<Long> bkF() {
        return this.fJK;
    }

    public void cM(List<Long> list) {
        this.fJK = list;
    }

    public b bkG() {
        return this.fJP;
    }

    public void a(b bVar) {
        this.fJP = bVar;
    }

    public boolean bkH() {
        return this.fJQ;
    }

    public void lN(boolean z) {
        this.fJQ = z;
    }

    public String getGameName() {
        return this.gameName;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public List<g> bkI() {
        return this.fJR;
    }

    public void cN(List<g> list) {
        this.fJR = list;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public int aMH() {
        return this.fJS;
    }

    public void mG(int i) {
        this.fJS = i;
    }

    public List<PhotoLiveCardData> bkJ() {
        return this.fJT;
    }

    public String bkK() {
        return this.fJW;
    }

    public void ra(String str) {
        this.fJW = str;
    }

    public List<FrsTabInfo> bkL() {
        return this.fKa;
    }

    public void cO(List<FrsTabInfo> list) {
        this.fKa = list;
    }

    public void cP(List<PhotoLiveCardData> list) {
        this.fJT = list;
    }

    public boolean bkM() {
        return this.fJV != null;
    }

    public PhotoLiveCardData bkN() {
        return this.fJV;
    }

    public void c(PhotoLiveCardData photoLiveCardData) {
        this.fJV = photoLiveCardData;
    }

    public com.baidu.tbadk.core.data.aa bkO() {
        return this.fJY;
    }

    public void a(com.baidu.tbadk.core.data.aa aaVar) {
        this.fJY = aaVar;
    }

    public int bkP() {
        return this.fJU;
    }

    public void sx(int i) {
        this.fJU = i;
    }

    public List<FeedForumData> bkQ() {
        return this.fKd;
    }

    public void cQ(List<FeedForumData> list) {
        this.fKd = list;
    }

    public void rb(String str) {
        if (this.fKd != null && str != null) {
            for (FeedForumData feedForumData : this.fKd) {
                if (feedForumData != null && feedForumData.getForumId() != null && feedForumData.getForumId().equals(str)) {
                    this.fKd.remove(feedForumData);
                    return;
                }
            }
        }
    }

    public List<CategoryInfo> bkR() {
        return this.fKe;
    }

    public void cR(List<CategoryInfo> list) {
        this.fKe = list;
    }

    public void rc(String str) {
        this.fKf = str;
    }

    public String bkS() {
        return this.fKf;
    }

    public bm bkT() {
        return this.fKm;
    }

    public void W(bm bmVar) {
        this.fKm = bmVar;
    }

    public int bkU() {
        return this.fKc;
    }

    public void sy(int i) {
        this.fKc = i;
    }

    public com.baidu.tbadk.core.data.z bkV() {
        return this.fKg;
    }

    public void a(com.baidu.tbadk.core.data.z zVar) {
        this.fKg = zVar;
    }

    public com.baidu.tbadk.core.data.t bkW() {
        return this.fKi;
    }

    public void a(com.baidu.tbadk.core.data.t tVar) {
        this.fKi = tVar;
    }

    public com.baidu.tbadk.core.data.v bkX() {
        return this.fKl;
    }

    public void a(com.baidu.tbadk.core.data.v vVar) {
        this.fKl = vVar;
    }

    public int bkY() {
        return this.fKo;
    }

    public void sz(int i) {
        this.fKo = i;
    }

    public bb bkZ() {
        return this.fKn;
    }

    public void a(bb bbVar) {
        this.fKn = bbVar;
    }

    public NavTabInfo bla() {
        return this.fKb;
    }

    public void a(NavTabInfo navTabInfo) {
        this.fKb = navTabInfo;
    }

    public com.baidu.tbadk.core.data.n blb() {
        return this.fKp;
    }

    public void a(com.baidu.tbadk.core.data.n nVar) {
        this.fKp = nVar;
    }

    public Integer blc() {
        return this.fKj;
    }

    public void h(Integer num) {
        this.fKj = num;
    }

    public List<Integer> bld() {
        return this.fKt;
    }

    public void cS(List<Integer> list) {
        this.fKt = list;
    }

    public List<com.baidu.adp.widget.ListView.v> ble() {
        return this.fKu;
    }

    public void cT(List<com.baidu.adp.widget.ListView.v> list) {
        this.fKu = list;
    }

    public boolean isShowDriftingBottle() {
        return this.isShowDriftingBottle;
    }

    public long blf() {
        return this.fKv;
    }

    public void lO(boolean z) {
        this.isShowDriftingBottle = z;
    }

    public void cF(long j) {
        this.fKv = j;
    }

    public com.baidu.tieba.g.b blg() {
        return this.fKx;
    }

    public void a(com.baidu.tieba.g.b bVar) {
        this.fKx = bVar;
    }
}

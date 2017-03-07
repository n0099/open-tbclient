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
import com.baidu.tbadk.core.data.ai;
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.core.data.aw;
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.data.bj;
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
    private AntiData Wx;
    protected aq dms;
    protected ForumData ehK;
    private UserData ehQ;
    protected List<Long> frJ;
    private m frK;
    protected boolean frL;
    protected String frM;
    protected o frN;
    private b frO;
    private boolean frP;
    private List<PhotoLiveCardData> frS;
    private int frT;
    private PhotoLiveCardData frU;
    private String frV;
    private com.baidu.tbadk.core.data.ab frX;
    private com.baidu.tbadk.core.data.z frY;
    private List<FrsTabInfo> fsa;
    private NavTabInfo fsb;
    private List<FeedForumData> fsd;
    private List<CategoryInfo> fse;
    private bj fsm;
    private az fsn;
    private com.baidu.tbadk.core.data.m fsp;
    private List<Integer> fsu;
    private List<com.baidu.adp.widget.ListView.v> fsv;
    public PopInfo fsx;
    private String gameName;
    private int mSortType;
    protected ArrayList<com.baidu.adp.widget.ListView.v> threadList;
    private HashMap<String, MetaData> userMap;
    public int frI = 0;
    private List<g> frQ = new ArrayList();
    private int frR = 0;
    private ArrayList<com.baidu.tbadk.core.data.o> frW = new ArrayList<>();
    protected com.baidu.tbadk.core.data.r frZ = null;
    private int fsc = 1;
    private String fsf = null;
    private com.baidu.tbadk.core.data.y fsg = null;
    public com.baidu.tbadk.core.data.aa fsh = null;
    private com.baidu.tbadk.core.data.s fsi = null;
    private Integer fsj = -1;
    public com.baidu.tbadk.core.data.w fsk = null;
    private com.baidu.tbadk.core.data.u fsl = null;
    private int fso = -1;
    protected List<com.baidu.adp.widget.ListView.v> fsq = null;
    private List<BannerThreadInfoData> fsr = null;
    private int fss = 0;
    private int fst = 0;
    private boolean isShowDriftingBottle = false;
    private long fsw = 0;
    private int alaLiveCount = 0;

    public l() {
        initData();
    }

    private void initData() {
        this.ehK = new ForumData();
        this.threadList = new ArrayList<>();
        this.fsq = new ArrayList();
        this.userMap = new HashMap<>();
        this.dms = new aq();
        this.frK = new m();
        this.ehQ = new UserData();
        this.frN = new o();
        d(new AntiData());
        a(new b());
        this.fsr = new ArrayList();
        this.fsv = new ArrayList();
        this.fsu = new ArrayList();
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
                                this.frW.add(oVar);
                            }
                        }
                    }
                }
                if (dataRes.activityhead != null && !com.baidu.tbadk.core.util.x.q(dataRes.activityhead.head_imgs)) {
                    this.frZ = new com.baidu.tbadk.core.data.r();
                    this.frZ.a(dataRes.activityhead);
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
                mh(dataRes.is_new_url.intValue());
                this.frL = dataRes.fortune_bag.intValue() == 1;
                this.frM = dataRes.fortune_desc;
                if (dataRes.forum != null) {
                    this.frP = dataRes.forum.has_game.intValue() == 1;
                    this.frV = dataRes.forum.game_url;
                    this.gameName = dataRes.forum.game_name;
                }
                List<StarEnter> list2 = dataRes.star_enter;
                this.frQ.clear();
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        g gVar = new g();
                        gVar.a(list2.get(i2));
                        this.frQ.add(gVar);
                    }
                }
                this.frN.a(dataRes.gcon_account);
                this.ehK.parserProtobuf(dataRes.forum);
                long longValue = dataRes.forum != null ? dataRes.forum.id.longValue() : 0L;
                this.frJ = dataRes.thread_id_list;
                this.Wx.parserProtobuf(dataRes.anti);
                this.frO.a(dataRes.group);
                this.dms.a(dataRes.page);
                this.frK.a(dataRes.frs_star);
                this.ehQ.parserProtobuf(dataRes.user);
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.ehQ.getIsSelectTail());
                }
                this.fsa = dataRes.frs_tab_info;
                if (dataRes.nav_tab_info == null) {
                    NavTabInfo.Builder builder = new NavTabInfo.Builder();
                    builder.tab = dataRes.frs_tab_info;
                    this.fsb = builder.build(true);
                } else {
                    this.fsb = dataRes.nav_tab_info;
                }
                this.alaLiveCount = dataRes.ala_live_count.intValue();
                rI(dataRes.frs_tab_default.intValue());
                List<ZhiBoInfoTW> list3 = dataRes.twzhibo_info;
                if (list3 != null && list3.size() > 0) {
                    this.frS = new ArrayList();
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
                        this.frS.add(photoLiveCardData);
                    }
                }
                this.frT = dataRes.twzhibo_pos.intValue();
                if (dataRes.hot_twzhibo_info != null) {
                    this.frU = new PhotoLiveCardData();
                    if (this.frU.getShowStyle() < 0) {
                        this.frU.setShowStyle(PhotoLiveCardData.getRandom(3, -1));
                    }
                    this.frU.getShowStyle();
                    this.frU.parserProtobuf(dataRes.hot_twzhibo_info);
                    this.frU.setShowExpressionViewIndexList(this.frU.getExpressionDatas());
                }
                a(dataRes.thread_list, longValue);
                this.fse = dataRes.category_list;
                if (!au.isEmpty(dataRes.bawu_enter_url)) {
                    this.fsf = dataRes.bawu_enter_url;
                }
                if (dataRes.head_sdk != null) {
                    this.fsg = new com.baidu.tbadk.core.data.y();
                    this.fsg.a(dataRes.head_sdk);
                }
                if (dataRes.recommend_book != null) {
                    this.fsh = new com.baidu.tbadk.core.data.aa();
                    this.fsh.a(dataRes.recommend_book);
                }
                if (dataRes.book_info != null) {
                    this.fsi = new com.baidu.tbadk.core.data.s();
                    this.fsi.a(dataRes.book_info);
                }
                if (dataRes.forum_present_info != null) {
                    this.fsk = new com.baidu.tbadk.core.data.w();
                    this.fsk.a(dataRes.forum_present_info);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.fsl = new com.baidu.tbadk.core.data.u();
                    this.fsl.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.store_card != null) {
                    this.frX = new com.baidu.tbadk.core.data.ab();
                    this.frX.a(dataRes.store_card);
                }
                if (dataRes.ntspread != null) {
                    this.frY = new com.baidu.tbadk.core.data.z();
                    this.frY.a(dataRes.ntspread);
                }
                if (dataRes.card_shipin_info != null && dataRes.card_shipin_info.size() > 0) {
                    this.fsm = new bj();
                    this.fsm.ar(true);
                    this.fsm.bT(this.frT);
                    this.fsm.setUserMap(this.userMap);
                    this.fsm.a(dataRes.card_shipin_info.get(0));
                    this.fsm.sy();
                    if (this.fsm.getFid() == 0 && longValue != 0) {
                        this.fsm.setFid(longValue);
                    }
                    this.fsm.i(this.frW);
                    this.fsm.aq(!this.fsm.ry());
                    if (this.fsm.getAuthor() != null && this.fsm.getAuthor().getPendantData() == null && (metaData = this.userMap.get(this.fsm.getAuthor().getUserId())) != null && metaData.getPendantData() != null) {
                        com.baidu.tbadk.data.j jVar = new com.baidu.tbadk.data.j();
                        jVar.N(metaData.getPendantData().Cq());
                        jVar.ck(metaData.getPendantData().qd());
                        this.fsm.getAuthor().setPendantData(jVar);
                    }
                }
                if (dataRes.school_recom_info != null) {
                    this.fso = dataRes.school_recom_pos.intValue();
                    this.fsn = new az();
                    this.fsn.a(dataRes.school_recom_info);
                }
                if (dataRes.carrier_enter != null) {
                    this.fsp = new com.baidu.tbadk.core.data.m();
                    this.fsp.a(dataRes.carrier_enter);
                }
                if (dataRes.banner_thread_list != null) {
                    this.fsr.clear();
                    int size2 = dataRes.banner_thread_list.size();
                    for (int i5 = 0; i5 < size2; i5++) {
                        BannerThreadInfoData bannerThreadInfoData = new BannerThreadInfoData();
                        bannerThreadInfoData.parserProtobuf(dataRes.banner_thread_list.get(i5));
                        this.fsr.add(bannerThreadInfoData);
                    }
                }
                if (dataRes.vitality_info != null && dataRes.vitality_info.frequently_forum_info != null) {
                    this.fss = dataRes.vitality_info.frequently_forum_info.forum_state.intValue();
                    this.fst = dataRes.vitality_info.frequently_forum_info.access_flag.intValue();
                }
                this.mSortType = dataRes.sort_type.intValue();
                this.frI = dataRes.need_log.intValue();
                com.baidu.tieba.recapp.c.a.aZL().pd(dataRes.asp_shown_info);
                this.fsu = dataRes.card_shipin_pos;
                if (dataRes.card_shipin_new != null) {
                    for (int i6 = 0; i6 < dataRes.card_shipin_new.size(); i6++) {
                        bj bjVar = new bj();
                        if (this.fsu != null && this.fsu.size() >= dataRes.card_shipin_new.size()) {
                            bjVar.bT(this.fsu.get(i6).intValue());
                        }
                        bjVar.ar(true);
                        bjVar.a(dataRes.card_shipin_new.get(i6));
                        this.fsv.add(bjVar);
                    }
                }
                if (dataRes.bottle != null) {
                    this.isShowDriftingBottle = dataRes.bottle.has_enter_display.intValue() == 1;
                    this.fsw = dataRes.bottle.tid.longValue();
                } else {
                    this.isShowDriftingBottle = false;
                    this.fsw = 0L;
                }
                this.fsx = dataRes.enter_pop_info;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    private void rI(int i) {
        this.fsc = 1;
        if (this.fsa != null && this.fsa.size() > 0) {
            for (FrsTabInfo frsTabInfo : this.fsa) {
                if (frsTabInfo != null && frsTabInfo.tab_id.intValue() == i) {
                    this.fsc = i;
                    return;
                }
            }
        }
    }

    public void a(List<ThreadInfo> list, long j) {
        if (list != null) {
            boolean appResponseToIntentClass = TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
            for (int i = 0; i < list.size(); i++) {
                bj bjVar = new bj();
                bjVar.setUserMap(this.userMap);
                bjVar.a(list.get(i));
                bjVar.bU(3);
                bjVar.sy();
                if (bjVar.getFid() == 0 && j != 0) {
                    bjVar.setFid(j);
                }
                bjVar.i(this.frW);
                if (bjVar.getThreadType() == 33 && !bjVar.sr()) {
                    aw awVar = new aw();
                    awVar.a(bjVar, 0);
                    awVar.m(bfI());
                    if (appResponseToIntentClass) {
                        this.threadList.add(awVar);
                    }
                } else if (!TextUtils.isEmpty(bjVar.sL())) {
                    ai aiVar = new ai();
                    aiVar.ch(bjVar.sL());
                    this.threadList.add(aiVar);
                } else {
                    this.threadList.add(bjVar);
                }
            }
        }
    }

    public int bfw() {
        return this.alaLiveCount;
    }

    public void rJ(int i) {
        this.alaLiveCount = i;
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
    public void m(JSONObject jSONObject) {
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void a(Message message) {
    }

    public ForumData aJp() {
        return this.ehK;
    }

    public int bfx() {
        return this.fss;
    }

    public void rK(int i) {
        this.fss = i;
    }

    public int bfy() {
        return this.fst;
    }

    public void rL(int i) {
        this.fst = i;
    }

    public void c(ForumData forumData) {
        this.ehK = forumData;
    }

    public ArrayList<com.baidu.adp.widget.ListView.v> getThreadList() {
        return this.threadList;
    }

    public void ax(ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        this.threadList = arrayList;
    }

    public AntiData qE() {
        return this.Wx;
    }

    public void d(AntiData antiData) {
        this.Wx = antiData;
    }

    public aq getPage() {
        return this.dms;
    }

    public void a(aq aqVar) {
        this.dms = aqVar;
    }

    public m bfz() {
        return this.frK;
    }

    public void a(m mVar) {
        this.frK = mVar;
    }

    public com.baidu.tbadk.core.data.r bfA() {
        return this.frZ;
    }

    public void b(com.baidu.tbadk.core.data.r rVar) {
        this.frZ = rVar;
    }

    public boolean bfB() {
        return this.frL;
    }

    public void la(boolean z) {
        this.frL = z;
    }

    public String bfC() {
        return this.frM;
    }

    public void pw(String str) {
        this.frM = str;
    }

    public o bfD() {
        return this.frN;
    }

    public void a(o oVar) {
        this.frN = oVar;
    }

    public UserData getUserData() {
        return this.ehQ;
    }

    public void h(UserData userData) {
        this.ehQ = userData;
    }

    public List<Long> bfE() {
        return this.frJ;
    }

    public void cE(List<Long> list) {
        this.frJ = list;
    }

    public b bfF() {
        return this.frO;
    }

    public void a(b bVar) {
        this.frO = bVar;
    }

    public boolean bfG() {
        return this.frP;
    }

    public void lb(boolean z) {
        this.frP = z;
    }

    public String getGameName() {
        return this.gameName;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public List<g> bfH() {
        return this.frQ;
    }

    public void cF(List<g> list) {
        this.frQ = list;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public int aJB() {
        return this.frR;
    }

    public void mh(int i) {
        this.frR = i;
    }

    public List<PhotoLiveCardData> bfI() {
        return this.frS;
    }

    public String bfJ() {
        return this.frV;
    }

    public void px(String str) {
        this.frV = str;
    }

    public List<FrsTabInfo> bfK() {
        return this.fsa;
    }

    public void cG(List<FrsTabInfo> list) {
        this.fsa = list;
    }

    public void cH(List<PhotoLiveCardData> list) {
        this.frS = list;
    }

    public boolean bfL() {
        return this.frU != null;
    }

    public PhotoLiveCardData bfM() {
        return this.frU;
    }

    public void c(PhotoLiveCardData photoLiveCardData) {
        this.frU = photoLiveCardData;
    }

    public com.baidu.tbadk.core.data.ab bfN() {
        return this.frX;
    }

    public void a(com.baidu.tbadk.core.data.ab abVar) {
        this.frX = abVar;
    }

    public com.baidu.tbadk.core.data.z bfO() {
        return this.frY;
    }

    public void a(com.baidu.tbadk.core.data.z zVar) {
        this.frY = zVar;
    }

    public int bfP() {
        return this.frT;
    }

    public void rM(int i) {
        this.frT = i;
    }

    public List<FeedForumData> bfQ() {
        return this.fsd;
    }

    public void cI(List<FeedForumData> list) {
        this.fsd = list;
    }

    public void py(String str) {
        if (this.fsd != null && str != null) {
            for (FeedForumData feedForumData : this.fsd) {
                if (feedForumData != null && feedForumData.getForumId() != null && feedForumData.getForumId().equals(str)) {
                    this.fsd.remove(feedForumData);
                    return;
                }
            }
        }
    }

    public List<CategoryInfo> bfR() {
        return this.fse;
    }

    public void cJ(List<CategoryInfo> list) {
        this.fse = list;
    }

    public void pz(String str) {
        this.fsf = str;
    }

    public String bfS() {
        return this.fsf;
    }

    public bj bfT() {
        return this.fsm;
    }

    public void K(bj bjVar) {
        this.fsm = bjVar;
    }

    public int bfU() {
        return this.fsc;
    }

    public void rN(int i) {
        this.fsc = i;
    }

    public com.baidu.tbadk.core.data.y bfV() {
        return this.fsg;
    }

    public void b(com.baidu.tbadk.core.data.y yVar) {
        this.fsg = yVar;
    }

    public com.baidu.tbadk.core.data.s bfW() {
        return this.fsi;
    }

    public void a(com.baidu.tbadk.core.data.s sVar) {
        this.fsi = sVar;
    }

    public com.baidu.tbadk.core.data.u bfX() {
        return this.fsl;
    }

    public void a(com.baidu.tbadk.core.data.u uVar) {
        this.fsl = uVar;
    }

    public int bfY() {
        return this.fso;
    }

    public void rO(int i) {
        this.fso = i;
    }

    public az bfZ() {
        return this.fsn;
    }

    public void a(az azVar) {
        this.fsn = azVar;
    }

    public NavTabInfo bga() {
        return this.fsb;
    }

    public void a(NavTabInfo navTabInfo) {
        this.fsb = navTabInfo;
    }

    public com.baidu.tbadk.core.data.m bgb() {
        return this.fsp;
    }

    public void a(com.baidu.tbadk.core.data.m mVar) {
        this.fsp = mVar;
    }

    public void cK(List<BannerThreadInfoData> list) {
        this.fsr = list;
    }

    public List<BannerThreadInfoData> bgc() {
        return this.fsr;
    }

    public int acY() {
        return this.mSortType;
    }

    public Integer bgd() {
        return this.fsj;
    }

    public void d(Integer num) {
        this.fsj = num;
    }

    public List<Integer> bge() {
        return this.fsu;
    }

    public void cL(List<Integer> list) {
        this.fsu = list;
    }

    public List<com.baidu.adp.widget.ListView.v> bgf() {
        return this.fsv;
    }

    public void cM(List<com.baidu.adp.widget.ListView.v> list) {
        this.fsv = list;
    }

    public boolean isShowDriftingBottle() {
        return this.isShowDriftingBottle;
    }

    public long bgg() {
        return this.fsw;
    }

    public void lc(boolean z) {
        this.isShowDriftingBottle = z;
    }

    public void cA(long j) {
        this.fsw = j;
    }
}

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
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.core.data.aw;
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.data.bk;
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
    private AntiData Wf;
    protected aq dhn;
    protected ForumData ecV;
    private UserData edb;
    protected List<Long> frR;
    private m frS;
    protected boolean frT;
    protected String frU;
    protected o frV;
    private b frW;
    private boolean frX;
    private List<Integer> fsA;
    private List<com.baidu.adp.widget.ListView.v> fsB;
    public PopInfo fsD;
    private List<PhotoLiveCardData> fsa;
    private int fsb;
    private PhotoLiveCardData fsc;
    private String fsd;
    private com.baidu.tbadk.core.data.z fsf;
    private List<FrsTabInfo> fsh;
    private NavTabInfo fsi;
    private List<FeedForumData> fsk;
    private List<CategoryInfo> fsl;
    private bk fst;
    private az fsu;
    private com.baidu.tbadk.core.data.m fsw;
    private String gameName;
    private int mSortType;
    protected ArrayList<com.baidu.adp.widget.ListView.v> threadList;
    private HashMap<String, MetaData> userMap;
    public int frQ = 0;
    private List<g> frY = new ArrayList();
    private int frZ = 0;
    private ArrayList<com.baidu.tbadk.core.data.o> fse = new ArrayList<>();
    protected com.baidu.tbadk.core.data.r fsg = null;
    private int fsj = 1;
    private String fsm = null;
    private com.baidu.tbadk.core.data.y fsn = null;
    public com.baidu.tbadk.core.data.aa fso = null;
    private com.baidu.tbadk.core.data.s fsp = null;
    private Integer fsq = -1;
    public com.baidu.tbadk.core.data.w fsr = null;
    private com.baidu.tbadk.core.data.u fss = null;
    private int fsv = -1;
    protected List<com.baidu.adp.widget.ListView.v> fsx = null;
    private int fsy = 0;
    private int fsz = 0;
    private boolean isShowDriftingBottle = false;
    private long fsC = 0;
    private int alaLiveCount = 0;

    public l() {
        initData();
    }

    private void initData() {
        this.ecV = new ForumData();
        this.threadList = new ArrayList<>();
        this.fsx = new ArrayList();
        this.userMap = new HashMap<>();
        this.dhn = new aq();
        this.frS = new m();
        this.edb = new UserData();
        this.frV = new o();
        d(new AntiData());
        a(new b());
        this.fsB = new ArrayList();
        this.fsA = new ArrayList();
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
                if (!com.baidu.tbadk.core.util.x.r(dataRes.color_egg)) {
                    for (ColorEgg colorEgg : dataRes.color_egg) {
                        if (colorEgg != null && !com.baidu.tbadk.core.util.x.r(colorEgg.holiday_words)) {
                            com.baidu.tbadk.core.data.o oVar = new com.baidu.tbadk.core.data.o();
                            if (oVar.a(colorEgg)) {
                                this.fse.add(oVar);
                            }
                        }
                    }
                }
                if (dataRes.activityhead != null && !com.baidu.tbadk.core.util.x.r(dataRes.activityhead.head_imgs)) {
                    this.fsg = new com.baidu.tbadk.core.data.r();
                    this.fsg.a(dataRes.activityhead);
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
                mb(dataRes.is_new_url.intValue());
                this.frT = dataRes.fortune_bag.intValue() == 1;
                this.frU = dataRes.fortune_desc;
                if (dataRes.forum != null) {
                    this.frX = dataRes.forum.has_game.intValue() == 1;
                    this.fsd = dataRes.forum.game_url;
                    this.gameName = dataRes.forum.game_name;
                }
                List<StarEnter> list2 = dataRes.star_enter;
                this.frY.clear();
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        g gVar = new g();
                        gVar.a(list2.get(i2));
                        this.frY.add(gVar);
                    }
                }
                this.frV.a(dataRes.gcon_account);
                this.ecV.parserProtobuf(dataRes.forum);
                long longValue = dataRes.forum != null ? dataRes.forum.id.longValue() : 0L;
                this.frR = dataRes.thread_id_list;
                this.Wf.parserProtobuf(dataRes.anti);
                this.frW.a(dataRes.group);
                this.dhn.a(dataRes.page);
                this.frS.a(dataRes.frs_star);
                this.edb.parserProtobuf(dataRes.user);
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.edb.getIsSelectTail());
                }
                this.fsh = dataRes.frs_tab_info;
                if (dataRes.nav_tab_info == null) {
                    NavTabInfo.Builder builder = new NavTabInfo.Builder();
                    builder.tab = dataRes.frs_tab_info;
                    this.fsi = builder.build(true);
                } else {
                    this.fsi = dataRes.nav_tab_info;
                }
                this.alaLiveCount = dataRes.ala_live_count.intValue();
                rE(dataRes.frs_tab_default.intValue());
                List<ZhiBoInfoTW> list3 = dataRes.twzhibo_info;
                if (list3 != null && list3.size() > 0) {
                    this.fsa = new ArrayList();
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
                        this.fsa.add(photoLiveCardData);
                    }
                }
                this.fsb = dataRes.twzhibo_pos.intValue();
                if (dataRes.hot_twzhibo_info != null) {
                    this.fsc = new PhotoLiveCardData();
                    if (this.fsc.getShowStyle() < 0) {
                        this.fsc.setShowStyle(PhotoLiveCardData.getRandom(3, -1));
                    }
                    this.fsc.getShowStyle();
                    this.fsc.parserProtobuf(dataRes.hot_twzhibo_info);
                    this.fsc.setShowExpressionViewIndexList(this.fsc.getExpressionDatas());
                }
                a(dataRes.thread_list, longValue);
                this.fsl = dataRes.category_list;
                if (!au.isEmpty(dataRes.bawu_enter_url)) {
                    this.fsm = dataRes.bawu_enter_url;
                }
                if (dataRes.head_sdk != null) {
                    this.fsn = new com.baidu.tbadk.core.data.y();
                    this.fsn.a(dataRes.head_sdk);
                }
                if (dataRes.recommend_book != null) {
                    this.fso = new com.baidu.tbadk.core.data.aa();
                    this.fso.a(dataRes.recommend_book);
                }
                if (dataRes.book_info != null) {
                    this.fsp = new com.baidu.tbadk.core.data.s();
                    this.fsp.a(dataRes.book_info);
                }
                if (dataRes.forum_present_info != null) {
                    this.fsr = new com.baidu.tbadk.core.data.w();
                    this.fsr.a(dataRes.forum_present_info);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.fss = new com.baidu.tbadk.core.data.u();
                    this.fss.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.ntspread != null) {
                    this.fsf = new com.baidu.tbadk.core.data.z();
                    this.fsf.a(dataRes.ntspread);
                }
                if (dataRes.card_shipin_info != null && dataRes.card_shipin_info.size() > 0) {
                    this.fst = new bk();
                    this.fst.aq(true);
                    this.fst.bU(this.fsb);
                    this.fst.setUserMap(this.userMap);
                    this.fst.a(dataRes.card_shipin_info.get(0));
                    this.fst.sg();
                    if (this.fst.getFid() == 0 && longValue != 0) {
                        this.fst.setFid(longValue);
                    }
                    this.fst.i(this.fse);
                    this.fst.ap(!this.fst.rg());
                    if (this.fst.getAuthor() != null && this.fst.getAuthor().getPendantData() == null && (metaData = this.userMap.get(this.fst.getAuthor().getUserId())) != null && metaData.getPendantData() != null) {
                        com.baidu.tbadk.data.i iVar = new com.baidu.tbadk.data.i();
                        iVar.O(metaData.getPendantData().BT());
                        iVar.cr(metaData.getPendantData().pT());
                        this.fst.getAuthor().setPendantData(iVar);
                    }
                }
                if (dataRes.school_recom_info != null) {
                    this.fsv = dataRes.school_recom_pos.intValue();
                    this.fsu = new az();
                    this.fsu.a(dataRes.school_recom_info);
                }
                if (dataRes.carrier_enter != null) {
                    this.fsw = new com.baidu.tbadk.core.data.m();
                    this.fsw.a(dataRes.carrier_enter);
                }
                if (dataRes.vitality_info != null && dataRes.vitality_info.frequently_forum_info != null) {
                    this.fsy = dataRes.vitality_info.frequently_forum_info.forum_state.intValue();
                    this.fsz = dataRes.vitality_info.frequently_forum_info.access_flag.intValue();
                }
                this.mSortType = dataRes.sort_type.intValue();
                this.frQ = dataRes.need_log.intValue();
                com.baidu.tieba.recapp.d.a.aYU().pr(dataRes.asp_shown_info);
                this.fsA = dataRes.card_shipin_pos;
                if (dataRes.card_shipin_new != null) {
                    for (int i5 = 0; i5 < dataRes.card_shipin_new.size(); i5++) {
                        bk bkVar = new bk();
                        if (this.fsA != null && this.fsA.size() >= dataRes.card_shipin_new.size()) {
                            bkVar.bU(this.fsA.get(i5).intValue());
                        }
                        bkVar.aq(true);
                        bkVar.a(dataRes.card_shipin_new.get(i5));
                        this.fsB.add(bkVar);
                    }
                }
                if (dataRes.bottle != null) {
                    this.isShowDriftingBottle = dataRes.bottle.has_enter_display.intValue() == 1;
                    this.fsC = dataRes.bottle.tid.longValue();
                } else {
                    this.isShowDriftingBottle = false;
                    this.fsC = 0L;
                }
                this.fsD = dataRes.enter_pop_info;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    private void rE(int i) {
        this.fsj = 1;
        if (this.fsh != null && this.fsh.size() > 0) {
            for (FrsTabInfo frsTabInfo : this.fsh) {
                if (frsTabInfo != null && frsTabInfo.tab_id.intValue() == i) {
                    this.fsj = i;
                    return;
                }
            }
        }
    }

    public void a(List<ThreadInfo> list, long j) {
        if (list != null) {
            boolean appResponseToIntentClass = TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
            for (int i = 0; i < list.size(); i++) {
                bk bkVar = new bk();
                bkVar.setUserMap(this.userMap);
                bkVar.a(list.get(i));
                bkVar.bV(3);
                bkVar.sg();
                if (bkVar.getFid() == 0 && j != 0) {
                    bkVar.setFid(j);
                }
                if (StringUtils.isNull(bkVar.rD())) {
                    bkVar.ct(this.ecV.getName());
                }
                bkVar.i(this.fse);
                if (bkVar.getThreadType() == 33 && !bkVar.rZ()) {
                    aw awVar = new aw();
                    awVar.a(bkVar, 0);
                    awVar.n(bfa());
                    if (appResponseToIntentClass) {
                        this.threadList.add(awVar);
                    }
                } else if (!TextUtils.isEmpty(bkVar.st())) {
                    ah ahVar = new ah();
                    ahVar.co(bkVar.st());
                    this.threadList.add(ahVar);
                } else {
                    this.threadList.add(bkVar);
                }
            }
        }
    }

    public int beO() {
        return this.alaLiveCount;
    }

    public void rF(int i) {
        this.alaLiveCount = i;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] Ej() {
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

    public ForumData aHE() {
        return this.ecV;
    }

    public int beP() {
        return this.fsy;
    }

    public void rG(int i) {
        this.fsy = i;
    }

    public int beQ() {
        return this.fsz;
    }

    public void rH(int i) {
        this.fsz = i;
    }

    public void c(ForumData forumData) {
        this.ecV = forumData;
    }

    public ArrayList<com.baidu.adp.widget.ListView.v> getThreadList() {
        return this.threadList;
    }

    public void ay(ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        this.threadList = arrayList;
    }

    public AntiData ql() {
        return this.Wf;
    }

    public void d(AntiData antiData) {
        this.Wf = antiData;
    }

    public aq qB() {
        return this.dhn;
    }

    public void a(aq aqVar) {
        this.dhn = aqVar;
    }

    public m beR() {
        return this.frS;
    }

    public void a(m mVar) {
        this.frS = mVar;
    }

    public com.baidu.tbadk.core.data.r beS() {
        return this.fsg;
    }

    public void a(com.baidu.tbadk.core.data.r rVar) {
        this.fsg = rVar;
    }

    public boolean beT() {
        return this.frT;
    }

    public void kT(boolean z) {
        this.frT = z;
    }

    public String beU() {
        return this.frU;
    }

    public void pN(String str) {
        this.frU = str;
    }

    public o beV() {
        return this.frV;
    }

    public void a(o oVar) {
        this.frV = oVar;
    }

    public UserData getUserData() {
        return this.edb;
    }

    public void e(UserData userData) {
        this.edb = userData;
    }

    public List<Long> beW() {
        return this.frR;
    }

    public void cu(List<Long> list) {
        this.frR = list;
    }

    public b beX() {
        return this.frW;
    }

    public void a(b bVar) {
        this.frW = bVar;
    }

    public boolean beY() {
        return this.frX;
    }

    public void kU(boolean z) {
        this.frX = z;
    }

    public String getGameName() {
        return this.gameName;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public List<g> beZ() {
        return this.frY;
    }

    public void cv(List<g> list) {
        this.frY = list;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public int aHS() {
        return this.frZ;
    }

    public void mb(int i) {
        this.frZ = i;
    }

    public List<PhotoLiveCardData> bfa() {
        return this.fsa;
    }

    public String bfb() {
        return this.fsd;
    }

    public void pO(String str) {
        this.fsd = str;
    }

    public List<FrsTabInfo> bfc() {
        return this.fsh;
    }

    public void cw(List<FrsTabInfo> list) {
        this.fsh = list;
    }

    public void cx(List<PhotoLiveCardData> list) {
        this.fsa = list;
    }

    public boolean bfd() {
        return this.fsc != null;
    }

    public PhotoLiveCardData bfe() {
        return this.fsc;
    }

    public void c(PhotoLiveCardData photoLiveCardData) {
        this.fsc = photoLiveCardData;
    }

    public com.baidu.tbadk.core.data.z bff() {
        return this.fsf;
    }

    public void a(com.baidu.tbadk.core.data.z zVar) {
        this.fsf = zVar;
    }

    public int bfg() {
        return this.fsb;
    }

    public void rI(int i) {
        this.fsb = i;
    }

    public List<FeedForumData> bfh() {
        return this.fsk;
    }

    public void cy(List<FeedForumData> list) {
        this.fsk = list;
    }

    public void pP(String str) {
        if (this.fsk != null && str != null) {
            for (FeedForumData feedForumData : this.fsk) {
                if (feedForumData != null && feedForumData.getForumId() != null && feedForumData.getForumId().equals(str)) {
                    this.fsk.remove(feedForumData);
                    return;
                }
            }
        }
    }

    public List<CategoryInfo> bfi() {
        return this.fsl;
    }

    public void cz(List<CategoryInfo> list) {
        this.fsl = list;
    }

    public void pQ(String str) {
        this.fsm = str;
    }

    public String bfj() {
        return this.fsm;
    }

    public bk bfk() {
        return this.fst;
    }

    public void L(bk bkVar) {
        this.fst = bkVar;
    }

    public int bfl() {
        return this.fsj;
    }

    public void rJ(int i) {
        this.fsj = i;
    }

    public com.baidu.tbadk.core.data.y bfm() {
        return this.fsn;
    }

    public void a(com.baidu.tbadk.core.data.y yVar) {
        this.fsn = yVar;
    }

    public com.baidu.tbadk.core.data.s bfn() {
        return this.fsp;
    }

    public void a(com.baidu.tbadk.core.data.s sVar) {
        this.fsp = sVar;
    }

    public com.baidu.tbadk.core.data.u bfo() {
        return this.fss;
    }

    public void a(com.baidu.tbadk.core.data.u uVar) {
        this.fss = uVar;
    }

    public int bfp() {
        return this.fsv;
    }

    public void rK(int i) {
        this.fsv = i;
    }

    public az bfq() {
        return this.fsu;
    }

    public void a(az azVar) {
        this.fsu = azVar;
    }

    public NavTabInfo bfr() {
        return this.fsi;
    }

    public void a(NavTabInfo navTabInfo) {
        this.fsi = navTabInfo;
    }

    public com.baidu.tbadk.core.data.m bfs() {
        return this.fsw;
    }

    public void a(com.baidu.tbadk.core.data.m mVar) {
        this.fsw = mVar;
    }

    public int abX() {
        return this.mSortType;
    }

    public Integer bft() {
        return this.fsq;
    }

    public void d(Integer num) {
        this.fsq = num;
    }

    public List<Integer> bfu() {
        return this.fsA;
    }

    public void cA(List<Integer> list) {
        this.fsA = list;
    }

    public List<com.baidu.adp.widget.ListView.v> bfv() {
        return this.fsB;
    }

    public void cB(List<com.baidu.adp.widget.ListView.v> list) {
        this.fsB = list;
    }

    public boolean isShowDriftingBottle() {
        return this.isShowDriftingBottle;
    }

    public long bfw() {
        return this.fsC;
    }

    public void kV(boolean z) {
        this.isShowDriftingBottle = z;
    }

    public void cl(long j) {
        this.fsC = j;
    }
}

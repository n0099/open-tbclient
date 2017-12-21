package com.baidu.tieba.tbadkCore;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
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
import com.baidu.tbadk.core.data.ab;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.au;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.am;
import com.squareup.wire.Message;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;
import tbclient.AlaLiveNotify;
import tbclient.CategoryInfo;
import tbclient.FrsPage.AgreeBanner;
import tbclient.FrsPage.ColorEgg;
import tbclient.FrsPage.DataRes;
import tbclient.FrsPage.ForumHeadIcon;
import tbclient.FrsPage.FrsPageResIdl;
import tbclient.FrsPage.NavTabInfo;
import tbclient.FrsPage.RecmForumInfo;
import tbclient.FrsPage.StarEnter;
import tbclient.FrsTabInfo;
import tbclient.PopInfo;
import tbclient.ThreadInfo;
import tbclient.User;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class h implements com.baidu.tbadk.mvc.b.c {
    public static final Wire WIRE = new Wire(new Class[0]);
    private AntiData Xu;
    protected ForumData ePq;
    private UserData ePx;
    protected al eaL;
    private List<com.baidu.adp.widget.ListView.f> gAa;
    private e gAb;
    public PopInfo gAc;
    private com.baidu.tieba.g.b gAd;
    private AgreeBanner gAe;
    protected List<com.baidu.adp.widget.ListView.f> gAf;
    private AlaLiveNotify gAg;
    private List<FrsTabInfo> gAh;
    private ForumHeadIcon gAj;
    private com.baidu.tieba.frs.r gAk;
    private j gAl;
    public FrsTabInfo gAm;
    private String gameName;
    private List<PhotoLiveCardData> gzA;
    private int gzB;
    private PhotoLiveCardData gzC;
    private String gzD;
    private List<FrsTabInfo> gzG;
    private NavTabInfo gzH;
    private List<FeedForumData> gzJ;
    private List<CategoryInfo> gzK;
    private bd gzS;
    private au gzT;
    private com.baidu.tbadk.core.data.l gzV;
    private List<Integer> gzZ;
    protected List<Long> gzr;
    private i gzs;
    protected boolean gzt;
    protected String gzu;
    protected l gzv;
    private b gzw;
    private boolean gzx;
    private int mSortType;
    public List<RecmForumInfo> recm_forum_list;
    protected ArrayList<com.baidu.adp.widget.ListView.f> threadList;
    private HashMap<String, MetaData> userMap;
    public int gzq = 0;
    private List<f> gzy = new ArrayList();
    private int gzz = 0;
    private ArrayList<com.baidu.tbadk.core.data.n> gzE = new ArrayList<>();
    protected com.baidu.tbadk.core.data.o gzF = null;
    private int gzI = 1;
    private String gzL = null;
    private com.baidu.tbadk.core.data.v gzM = null;
    public com.baidu.tbadk.core.data.w gzN = null;
    private com.baidu.tbadk.core.data.p gzO = null;
    private Integer gzP = -1;
    public com.baidu.tbadk.core.data.t gzQ = null;
    private com.baidu.tbadk.core.data.r gzR = null;
    private int gzU = -1;
    protected List<com.baidu.adp.widget.ListView.f> gzW = null;
    private int gzX = 0;
    private int gzY = 0;
    private int alaLiveCount = 0;
    private int gAi = 0;
    public int gAn = 0;

    public h() {
        initData();
    }

    private void initData() {
        this.ePq = new ForumData();
        this.threadList = new ArrayList<>();
        this.gzW = new ArrayList();
        this.userMap = new HashMap<>();
        this.eaL = new al();
        this.gzs = new i();
        this.ePx = new UserData();
        this.gzv = new l();
        c(new AntiData());
        a(new b());
        this.gAa = new ArrayList();
        this.gzZ = new ArrayList();
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
                if (!com.baidu.tbadk.core.util.v.w(dataRes.color_egg)) {
                    for (ColorEgg colorEgg : dataRes.color_egg) {
                        if (colorEgg != null && !com.baidu.tbadk.core.util.v.w(colorEgg.holiday_words)) {
                            com.baidu.tbadk.core.data.n nVar = new com.baidu.tbadk.core.data.n();
                            if (nVar.a(colorEgg)) {
                                this.gzE.add(nVar);
                            }
                        }
                    }
                }
                if (dataRes.activityhead != null && !com.baidu.tbadk.core.util.v.w(dataRes.activityhead.head_imgs)) {
                    this.gzF = new com.baidu.tbadk.core.data.o();
                    this.gzF.a(dataRes.activityhead);
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
                pJ(dataRes.is_new_url.intValue());
                this.gzt = dataRes.fortune_bag.intValue() == 1;
                this.gzu = dataRes.fortune_desc;
                if (dataRes.forum != null) {
                    this.gzx = dataRes.forum.has_game.intValue() == 1;
                    this.gzD = dataRes.forum.game_url;
                    this.gameName = dataRes.forum.game_name;
                }
                List<StarEnter> list2 = dataRes.star_enter;
                this.gzy.clear();
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        f fVar = new f();
                        fVar.a(list2.get(i2));
                        this.gzy.add(fVar);
                    }
                }
                this.gzv.a(dataRes.gcon_account);
                this.ePq.parserProtobuf(dataRes.forum);
                long longValue = dataRes.forum != null ? dataRes.forum.id.longValue() : 0L;
                this.gzr = dataRes.thread_id_list;
                this.Xu.parserProtobuf(dataRes.anti);
                this.gzw.a(dataRes.group);
                this.eaL.a(dataRes.page);
                this.gzs.a(dataRes.frs_star);
                this.ePx.parserProtobuf(dataRes.user);
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.ePx.getIsSelectTail());
                }
                this.gzG = dataRes.frs_tab_info;
                if (dataRes.nav_tab_info == null) {
                    NavTabInfo.Builder builder = new NavTabInfo.Builder();
                    builder.tab = dataRes.frs_tab_info;
                    this.gzH = builder.build(true);
                } else {
                    this.gzH = dataRes.nav_tab_info;
                }
                if (this.gzH.head != null && !com.baidu.tbadk.core.util.v.w(this.gzH.head)) {
                    this.gAm = this.gzH.head.get(0);
                }
                this.alaLiveCount = dataRes.ala_live_count.intValue();
                uj(dataRes.frs_tab_default.intValue());
                List<ZhiBoInfoTW> list3 = dataRes.twzhibo_info;
                if (list3 != null && list3.size() > 0) {
                    this.gzA = new ArrayList();
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
                        this.gzA.add(photoLiveCardData);
                    }
                }
                this.gzB = dataRes.twzhibo_pos.intValue();
                if (dataRes.hot_twzhibo_info != null) {
                    this.gzC = new PhotoLiveCardData();
                    if (this.gzC.getShowStyle() < 0) {
                        PhotoLiveCardData photoLiveCardData2 = this.gzC;
                        this.gzC.setShowStyle(PhotoLiveCardData.getRandom(3, -1));
                    }
                    this.gzC.getShowStyle();
                    this.gzC.parserProtobuf(dataRes.hot_twzhibo_info);
                    this.gzC.setShowExpressionViewIndexList(this.gzC.getExpressionDatas());
                }
                a(dataRes.thread_list, longValue);
                this.gzK = dataRes.category_list;
                if (!am.isEmpty(dataRes.bawu_enter_url)) {
                    this.gzL = dataRes.bawu_enter_url;
                }
                if (dataRes.head_sdk != null) {
                    this.gzM = new com.baidu.tbadk.core.data.v();
                    this.gzM.a(dataRes.head_sdk);
                }
                if (dataRes.recommend_book != null) {
                    this.gzN = new com.baidu.tbadk.core.data.w();
                    this.gzN.a(dataRes.recommend_book);
                }
                if (dataRes.book_info != null) {
                    this.gzO = new com.baidu.tbadk.core.data.p();
                    this.gzO.a(dataRes.book_info);
                }
                if (dataRes.forum_present_info != null) {
                    this.gzQ = new com.baidu.tbadk.core.data.t();
                    this.gzQ.a(dataRes.forum_present_info);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.gzR = new com.baidu.tbadk.core.data.r();
                    this.gzR.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.card_shipin_info != null && dataRes.card_shipin_info.size() > 0) {
                    this.gzS = new bd();
                    this.gzS.am(true);
                    this.gzS.bX(this.gzB);
                    this.gzS.setUserMap(this.userMap);
                    this.gzS.a(dataRes.card_shipin_info.get(0));
                    this.gzS.sd();
                    if (this.gzS.getFid() == 0 && longValue != 0) {
                        this.gzS.setFid(longValue);
                    }
                    this.gzS.i(this.gzE);
                    this.gzS.al(!this.gzS.ra());
                    if (this.gzS.rv() != null && this.gzS.rv().getPendantData() == null && (metaData = this.userMap.get(this.gzS.rv().getUserId())) != null && metaData.getPendantData() != null) {
                        com.baidu.tbadk.data.k kVar = new com.baidu.tbadk.data.k();
                        kVar.T(metaData.getPendantData().CF());
                        kVar.cF(metaData.getPendantData().pR());
                        this.gzS.rv().setPendantData(kVar);
                    }
                }
                if (dataRes.ala_live_insert != null && dataRes.ala_live_insert.ala_live_list != null && dataRes.ala_live_insert.ala_live_list.size() > 0) {
                    this.gAb = new e();
                    this.gAb.gyP = dataRes.ala_insert_floor.intValue();
                    ArrayList arrayList = new ArrayList();
                    for (int i5 = 0; i5 < dataRes.ala_live_insert.ala_live_list.size(); i5++) {
                        if (dataRes.ala_live_insert.ala_live_list.get(i5) != null) {
                            bd bdVar = new bd();
                            bdVar.a(dataRes.ala_live_insert.ala_live_list.get(i5));
                            arrayList.add(bdVar);
                        }
                    }
                    this.gAb.gyO = arrayList;
                }
                if (dataRes.school_recom_info != null) {
                    this.gzU = dataRes.school_recom_pos.intValue();
                    this.gzT = new au();
                    this.gzT.a(dataRes.school_recom_info);
                }
                if (dataRes.carrier_enter != null) {
                    this.gzV = new com.baidu.tbadk.core.data.l();
                    this.gzV.a(dataRes.carrier_enter);
                }
                if (dataRes.vitality_info != null && dataRes.vitality_info.frequently_forum_info != null) {
                    this.gzX = dataRes.vitality_info.frequently_forum_info.forum_state.intValue();
                    this.gzY = dataRes.vitality_info.frequently_forum_info.access_flag.intValue();
                }
                this.mSortType = dataRes.sort_type.intValue();
                this.gzq = dataRes.need_log.intValue();
                com.baidu.tieba.recapp.e.a.bmw().sa(dataRes.asp_shown_info);
                this.gzZ = dataRes.card_shipin_pos;
                if (dataRes.card_shipin_new != null) {
                    for (int i6 = 0; i6 < dataRes.card_shipin_new.size(); i6++) {
                        bd bdVar2 = new bd();
                        if (this.gzZ != null && this.gzZ.size() >= dataRes.card_shipin_new.size()) {
                            bdVar2.bX(this.gzZ.get(i6).intValue());
                        }
                        bdVar2.am(true);
                        bdVar2.a(dataRes.card_shipin_new.get(i6));
                        this.gAa.add(bdVar2);
                    }
                }
                this.gAc = dataRes.enter_pop_info;
                if (dataRes.esport != null) {
                    this.gAd = new com.baidu.tieba.g.b();
                    this.gAd.a(dataRes.esport);
                }
                if (TbadkCoreApplication.isLogin() && dataRes.banner_user_story != null && dataRes.banner_user_story._switch.intValue() == 1 && dataRes.forum != null) {
                    com.baidu.tbadk.data.f fVar2 = new com.baidu.tbadk.data.f();
                    fVar2.a(dataRes.banner_user_story, 0L, dataRes.forum.id.longValue(), dataRes.forum.name, true);
                    this.gAf = fVar2.getList();
                    MessageManager.getInstance().sendMessageFromBackground(new CustomMessage((int) CmdConfigCustom.CMD_STORY_READ_CACHE, Long.valueOf(longValue)));
                }
                this.gAe = dataRes.agree_banner;
                if (dataRes.user_extend != null) {
                    this.gAk = new com.baidu.tieba.frs.r();
                    this.gAk.a(dataRes.user_extend);
                }
                this.gAg = dataRes.live_frs_notify;
                this.gAh = dataRes.frs_game_tab_info;
                this.gAi = dataRes.game_default_tab_id.intValue();
                this.gAj = dataRes.forum_head_icon;
                if (dataRes.video != null && dataRes.video.video_act != null) {
                    this.gAl = new j();
                    this.gAl.a(dataRes.video.video_act);
                }
                if (dataRes.info != null) {
                    this.recm_forum_list = dataRes.info.recm_forum_list;
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public List<com.baidu.adp.widget.ListView.f> buO() {
        return this.gAf;
    }

    public void ds(List<com.baidu.adp.widget.ListView.f> list) {
        this.gAf = list;
    }

    public AgreeBanner buP() {
        return this.gAe;
    }

    public void a(AgreeBanner agreeBanner) {
        this.gAe = agreeBanner;
    }

    public ForumHeadIcon buQ() {
        return this.gAj;
    }

    public void a(ForumHeadIcon forumHeadIcon) {
        this.gAj = forumHeadIcon;
    }

    public List<RecmForumInfo> buR() {
        return this.recm_forum_list;
    }

    private void uj(int i) {
        this.gzI = 1;
        if (this.gzG != null && this.gzG.size() > 0) {
            for (FrsTabInfo frsTabInfo : this.gzG) {
                if (frsTabInfo != null && frsTabInfo.tab_id.intValue() == i) {
                    this.gzI = i;
                    return;
                }
            }
        }
    }

    public void a(List<ThreadInfo> list, long j) {
        if (list != null) {
            boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
            for (int i = 0; i < list.size(); i++) {
                bd bdVar = new bd();
                bdVar.setUserMap(this.userMap);
                bdVar.a(list.get(i));
                bdVar.bY(3);
                bdVar.sd();
                if (bdVar.getFid() == 0 && j != 0) {
                    bdVar.setFid(j);
                }
                if (StringUtils.isNull(bdVar.rB())) {
                    bdVar.cH(this.ePq.getName());
                }
                bdVar.i(this.gzE);
                if (bdVar.getThreadType() == 33 && !bdVar.rW()) {
                    ar arVar = new ar();
                    arVar.a(bdVar, 0);
                    arVar.s(bve());
                    if (appResponseToIntentClass) {
                        this.threadList.add(arVar);
                    }
                } else if (!TextUtils.isEmpty(bdVar.sr())) {
                    ab abVar = new ab();
                    abVar.cC(bdVar.sr());
                    this.threadList.add(abVar);
                } else {
                    this.threadList.add(bdVar);
                }
            }
        }
    }

    public int buS() {
        return this.alaLiveCount;
    }

    public void uk(int i) {
        this.alaLiveCount = i;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] Fc() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public boolean x(byte[] bArr) {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void j(JSONObject jSONObject) {
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void a(Message message) {
    }

    public ForumData aRo() {
        return this.ePq;
    }

    public int buT() {
        return this.gzX;
    }

    public void ul(int i) {
        this.gzX = i;
    }

    public int buU() {
        return this.gzY;
    }

    public void um(int i) {
        this.gzY = i;
    }

    public void c(ForumData forumData) {
        this.ePq = forumData;
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> getThreadList() {
        return this.threadList;
    }

    public void aA(ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        this.threadList = arrayList;
    }

    public AntiData qg() {
        return this.Xu;
    }

    public void c(AntiData antiData) {
        this.Xu = antiData;
    }

    public al qy() {
        return this.eaL;
    }

    public void a(al alVar) {
        this.eaL = alVar;
    }

    public i buV() {
        return this.gzs;
    }

    public void a(i iVar) {
        this.gzs = iVar;
    }

    public com.baidu.tbadk.core.data.o buW() {
        return this.gzF;
    }

    public void a(com.baidu.tbadk.core.data.o oVar) {
        this.gzF = oVar;
    }

    public boolean buX() {
        return this.gzt;
    }

    public void mY(boolean z) {
        this.gzt = z;
    }

    public String buY() {
        return this.gzu;
    }

    public void sR(String str) {
        this.gzu = str;
    }

    public l buZ() {
        return this.gzv;
    }

    public void a(l lVar) {
        this.gzv = lVar;
    }

    public UserData getUserData() {
        return this.ePx;
    }

    public void e(UserData userData) {
        this.ePx = userData;
    }

    public List<Long> bva() {
        return this.gzr;
    }

    public void dt(List<Long> list) {
        this.gzr = list;
    }

    public b bvb() {
        return this.gzw;
    }

    public void a(b bVar) {
        this.gzw = bVar;
    }

    public boolean bvc() {
        return this.gzx;
    }

    public void mZ(boolean z) {
        this.gzx = z;
    }

    public String getGameName() {
        return this.gameName;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public List<f> bvd() {
        return this.gzy;
    }

    public void du(List<f> list) {
        this.gzy = list;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public int aRC() {
        return this.gzz;
    }

    public void pJ(int i) {
        this.gzz = i;
    }

    public List<PhotoLiveCardData> bve() {
        return this.gzA;
    }

    public String bvf() {
        return this.gzD;
    }

    public void sS(String str) {
        this.gzD = str;
    }

    public List<FrsTabInfo> bvg() {
        return this.gzG;
    }

    public void dv(List<FrsTabInfo> list) {
        this.gzG = list;
    }

    public void dw(List<PhotoLiveCardData> list) {
        this.gzA = list;
    }

    public boolean bvh() {
        return this.gzC != null;
    }

    public PhotoLiveCardData bvi() {
        return this.gzC;
    }

    public void c(PhotoLiveCardData photoLiveCardData) {
        this.gzC = photoLiveCardData;
    }

    public int bvj() {
        return this.gzB;
    }

    public void un(int i) {
        this.gzB = i;
    }

    public List<FeedForumData> bvk() {
        return this.gzJ;
    }

    public void dx(List<FeedForumData> list) {
        this.gzJ = list;
    }

    public void sT(String str) {
        if (this.gzJ != null && str != null) {
            for (FeedForumData feedForumData : this.gzJ) {
                if (feedForumData != null && feedForumData.getForumId() != null && feedForumData.getForumId().equals(str)) {
                    this.gzJ.remove(feedForumData);
                    return;
                }
            }
        }
    }

    public List<CategoryInfo> bvl() {
        return this.gzK;
    }

    public void dy(List<CategoryInfo> list) {
        this.gzK = list;
    }

    public void sU(String str) {
        this.gzL = str;
    }

    public String bvm() {
        return this.gzL;
    }

    public bd bvn() {
        return this.gzS;
    }

    public void ak(bd bdVar) {
        this.gzS = bdVar;
    }

    public int bvo() {
        return this.gzI;
    }

    public void uo(int i) {
        this.gzI = i;
    }

    public com.baidu.tbadk.core.data.v bvp() {
        return this.gzM;
    }

    public void a(com.baidu.tbadk.core.data.v vVar) {
        this.gzM = vVar;
    }

    public com.baidu.tbadk.core.data.p bvq() {
        return this.gzO;
    }

    public void a(com.baidu.tbadk.core.data.p pVar) {
        this.gzO = pVar;
    }

    public com.baidu.tbadk.core.data.r bvr() {
        return this.gzR;
    }

    public void a(com.baidu.tbadk.core.data.r rVar) {
        this.gzR = rVar;
    }

    public int bvs() {
        return this.gzU;
    }

    public void up(int i) {
        this.gzU = i;
    }

    public au bvt() {
        return this.gzT;
    }

    public void a(au auVar) {
        this.gzT = auVar;
    }

    public NavTabInfo bvu() {
        return this.gzH;
    }

    public void a(NavTabInfo navTabInfo) {
        this.gzH = navTabInfo;
    }

    public com.baidu.tbadk.core.data.l bvv() {
        return this.gzV;
    }

    public void a(com.baidu.tbadk.core.data.l lVar) {
        this.gzV = lVar;
    }

    public Integer bvw() {
        return this.gzP;
    }

    public void k(Integer num) {
        this.gzP = num;
    }

    public List<Integer> bvx() {
        return this.gzZ;
    }

    public void dz(List<Integer> list) {
        this.gzZ = list;
    }

    public List<com.baidu.adp.widget.ListView.f> bvy() {
        return this.gAa;
    }

    public void dA(List<com.baidu.adp.widget.ListView.f> list) {
        this.gAa = list;
    }

    public com.baidu.tieba.g.b bvz() {
        return this.gAd;
    }

    public void a(com.baidu.tieba.g.b bVar) {
        this.gAd = bVar;
    }

    public AlaLiveNotify bvA() {
        return this.gAg;
    }

    public void a(AlaLiveNotify alaLiveNotify) {
        this.gAg = alaLiveNotify;
    }

    public List<FrsTabInfo> bvB() {
        return this.gAh;
    }

    public void dB(List<FrsTabInfo> list) {
        this.gAh = list;
    }

    public void uq(int i) {
        this.gAi = i;
    }

    public int bvC() {
        return this.gAi;
    }

    public void a(com.baidu.tieba.frs.r rVar) {
        this.gAk = rVar;
    }

    public com.baidu.tieba.frs.r bvD() {
        return this.gAk;
    }

    public j bvE() {
        return this.gAl;
    }

    public void a(j jVar) {
        this.gAl = jVar;
    }

    public e bvF() {
        return this.gAb;
    }

    public void b(e eVar) {
        this.gAb = eVar;
    }
}

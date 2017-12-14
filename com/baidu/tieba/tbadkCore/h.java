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
    private AntiData Xr;
    protected ForumData ePl;
    private UserData ePs;
    protected al eaH;
    protected List<com.baidu.adp.widget.ListView.f> gAa;
    private AlaLiveNotify gAb;
    private List<FrsTabInfo> gAc;
    private ForumHeadIcon gAe;
    private com.baidu.tieba.frs.r gAf;
    private j gAg;
    public FrsTabInfo gAh;
    private String gameName;
    private List<FrsTabInfo> gzB;
    private NavTabInfo gzC;
    private List<FeedForumData> gzE;
    private List<CategoryInfo> gzF;
    private bd gzN;
    private au gzO;
    private com.baidu.tbadk.core.data.l gzQ;
    private List<Integer> gzU;
    private List<com.baidu.adp.widget.ListView.f> gzV;
    private e gzW;
    public PopInfo gzX;
    private com.baidu.tieba.g.b gzY;
    private AgreeBanner gzZ;
    protected List<Long> gzm;
    private i gzn;
    protected boolean gzo;
    protected String gzp;
    protected l gzq;
    private b gzr;
    private boolean gzs;
    private List<PhotoLiveCardData> gzv;
    private int gzw;
    private PhotoLiveCardData gzx;
    private String gzy;
    private int mSortType;
    public List<RecmForumInfo> recm_forum_list;
    protected ArrayList<com.baidu.adp.widget.ListView.f> threadList;
    private HashMap<String, MetaData> userMap;
    public int gzl = 0;
    private List<f> gzt = new ArrayList();
    private int gzu = 0;
    private ArrayList<com.baidu.tbadk.core.data.n> gzz = new ArrayList<>();
    protected com.baidu.tbadk.core.data.o gzA = null;
    private int gzD = 1;
    private String gzG = null;
    private com.baidu.tbadk.core.data.v gzH = null;
    public com.baidu.tbadk.core.data.w gzI = null;
    private com.baidu.tbadk.core.data.p gzJ = null;
    private Integer gzK = -1;
    public com.baidu.tbadk.core.data.t gzL = null;
    private com.baidu.tbadk.core.data.r gzM = null;
    private int gzP = -1;
    protected List<com.baidu.adp.widget.ListView.f> gzR = null;
    private int gzS = 0;
    private int gzT = 0;
    private int alaLiveCount = 0;
    private int gAd = 0;
    public int gAi = 0;

    public h() {
        initData();
    }

    private void initData() {
        this.ePl = new ForumData();
        this.threadList = new ArrayList<>();
        this.gzR = new ArrayList();
        this.userMap = new HashMap<>();
        this.eaH = new al();
        this.gzn = new i();
        this.ePs = new UserData();
        this.gzq = new l();
        c(new AntiData());
        a(new b());
        this.gzV = new ArrayList();
        this.gzU = new ArrayList();
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
                                this.gzz.add(nVar);
                            }
                        }
                    }
                }
                if (dataRes.activityhead != null && !com.baidu.tbadk.core.util.v.w(dataRes.activityhead.head_imgs)) {
                    this.gzA = new com.baidu.tbadk.core.data.o();
                    this.gzA.a(dataRes.activityhead);
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
                this.gzo = dataRes.fortune_bag.intValue() == 1;
                this.gzp = dataRes.fortune_desc;
                if (dataRes.forum != null) {
                    this.gzs = dataRes.forum.has_game.intValue() == 1;
                    this.gzy = dataRes.forum.game_url;
                    this.gameName = dataRes.forum.game_name;
                }
                List<StarEnter> list2 = dataRes.star_enter;
                this.gzt.clear();
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        f fVar = new f();
                        fVar.a(list2.get(i2));
                        this.gzt.add(fVar);
                    }
                }
                this.gzq.a(dataRes.gcon_account);
                this.ePl.parserProtobuf(dataRes.forum);
                long longValue = dataRes.forum != null ? dataRes.forum.id.longValue() : 0L;
                this.gzm = dataRes.thread_id_list;
                this.Xr.parserProtobuf(dataRes.anti);
                this.gzr.a(dataRes.group);
                this.eaH.a(dataRes.page);
                this.gzn.a(dataRes.frs_star);
                this.ePs.parserProtobuf(dataRes.user);
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.ePs.getIsSelectTail());
                }
                this.gzB = dataRes.frs_tab_info;
                if (dataRes.nav_tab_info == null) {
                    NavTabInfo.Builder builder = new NavTabInfo.Builder();
                    builder.tab = dataRes.frs_tab_info;
                    this.gzC = builder.build(true);
                } else {
                    this.gzC = dataRes.nav_tab_info;
                }
                if (this.gzC.head != null && !com.baidu.tbadk.core.util.v.w(this.gzC.head)) {
                    this.gAh = this.gzC.head.get(0);
                }
                this.alaLiveCount = dataRes.ala_live_count.intValue();
                uj(dataRes.frs_tab_default.intValue());
                List<ZhiBoInfoTW> list3 = dataRes.twzhibo_info;
                if (list3 != null && list3.size() > 0) {
                    this.gzv = new ArrayList();
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
                        this.gzv.add(photoLiveCardData);
                    }
                }
                this.gzw = dataRes.twzhibo_pos.intValue();
                if (dataRes.hot_twzhibo_info != null) {
                    this.gzx = new PhotoLiveCardData();
                    if (this.gzx.getShowStyle() < 0) {
                        PhotoLiveCardData photoLiveCardData2 = this.gzx;
                        this.gzx.setShowStyle(PhotoLiveCardData.getRandom(3, -1));
                    }
                    this.gzx.getShowStyle();
                    this.gzx.parserProtobuf(dataRes.hot_twzhibo_info);
                    this.gzx.setShowExpressionViewIndexList(this.gzx.getExpressionDatas());
                }
                a(dataRes.thread_list, longValue);
                this.gzF = dataRes.category_list;
                if (!am.isEmpty(dataRes.bawu_enter_url)) {
                    this.gzG = dataRes.bawu_enter_url;
                }
                if (dataRes.head_sdk != null) {
                    this.gzH = new com.baidu.tbadk.core.data.v();
                    this.gzH.a(dataRes.head_sdk);
                }
                if (dataRes.recommend_book != null) {
                    this.gzI = new com.baidu.tbadk.core.data.w();
                    this.gzI.a(dataRes.recommend_book);
                }
                if (dataRes.book_info != null) {
                    this.gzJ = new com.baidu.tbadk.core.data.p();
                    this.gzJ.a(dataRes.book_info);
                }
                if (dataRes.forum_present_info != null) {
                    this.gzL = new com.baidu.tbadk.core.data.t();
                    this.gzL.a(dataRes.forum_present_info);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.gzM = new com.baidu.tbadk.core.data.r();
                    this.gzM.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.card_shipin_info != null && dataRes.card_shipin_info.size() > 0) {
                    this.gzN = new bd();
                    this.gzN.am(true);
                    this.gzN.bX(this.gzw);
                    this.gzN.setUserMap(this.userMap);
                    this.gzN.a(dataRes.card_shipin_info.get(0));
                    this.gzN.sd();
                    if (this.gzN.getFid() == 0 && longValue != 0) {
                        this.gzN.setFid(longValue);
                    }
                    this.gzN.i(this.gzz);
                    this.gzN.al(!this.gzN.ra());
                    if (this.gzN.rv() != null && this.gzN.rv().getPendantData() == null && (metaData = this.userMap.get(this.gzN.rv().getUserId())) != null && metaData.getPendantData() != null) {
                        com.baidu.tbadk.data.k kVar = new com.baidu.tbadk.data.k();
                        kVar.T(metaData.getPendantData().CF());
                        kVar.cF(metaData.getPendantData().pR());
                        this.gzN.rv().setPendantData(kVar);
                    }
                }
                if (dataRes.ala_live_insert != null && dataRes.ala_live_insert.ala_live_list != null && dataRes.ala_live_insert.ala_live_list.size() > 0) {
                    this.gzW = new e();
                    this.gzW.gyK = dataRes.ala_insert_floor.intValue();
                    ArrayList arrayList = new ArrayList();
                    for (int i5 = 0; i5 < dataRes.ala_live_insert.ala_live_list.size(); i5++) {
                        if (dataRes.ala_live_insert.ala_live_list.get(i5) != null) {
                            bd bdVar = new bd();
                            bdVar.a(dataRes.ala_live_insert.ala_live_list.get(i5));
                            arrayList.add(bdVar);
                        }
                    }
                    this.gzW.gyJ = arrayList;
                }
                if (dataRes.school_recom_info != null) {
                    this.gzP = dataRes.school_recom_pos.intValue();
                    this.gzO = new au();
                    this.gzO.a(dataRes.school_recom_info);
                }
                if (dataRes.carrier_enter != null) {
                    this.gzQ = new com.baidu.tbadk.core.data.l();
                    this.gzQ.a(dataRes.carrier_enter);
                }
                if (dataRes.vitality_info != null && dataRes.vitality_info.frequently_forum_info != null) {
                    this.gzS = dataRes.vitality_info.frequently_forum_info.forum_state.intValue();
                    this.gzT = dataRes.vitality_info.frequently_forum_info.access_flag.intValue();
                }
                this.mSortType = dataRes.sort_type.intValue();
                this.gzl = dataRes.need_log.intValue();
                com.baidu.tieba.recapp.e.a.bmw().sa(dataRes.asp_shown_info);
                this.gzU = dataRes.card_shipin_pos;
                if (dataRes.card_shipin_new != null) {
                    for (int i6 = 0; i6 < dataRes.card_shipin_new.size(); i6++) {
                        bd bdVar2 = new bd();
                        if (this.gzU != null && this.gzU.size() >= dataRes.card_shipin_new.size()) {
                            bdVar2.bX(this.gzU.get(i6).intValue());
                        }
                        bdVar2.am(true);
                        bdVar2.a(dataRes.card_shipin_new.get(i6));
                        this.gzV.add(bdVar2);
                    }
                }
                this.gzX = dataRes.enter_pop_info;
                if (dataRes.esport != null) {
                    this.gzY = new com.baidu.tieba.g.b();
                    this.gzY.a(dataRes.esport);
                }
                if (TbadkCoreApplication.isLogin() && dataRes.banner_user_story != null && dataRes.banner_user_story._switch.intValue() == 1 && dataRes.forum != null) {
                    com.baidu.tbadk.data.f fVar2 = new com.baidu.tbadk.data.f();
                    fVar2.a(dataRes.banner_user_story, 0L, dataRes.forum.id.longValue(), dataRes.forum.name, true);
                    this.gAa = fVar2.getList();
                    MessageManager.getInstance().sendMessageFromBackground(new CustomMessage((int) CmdConfigCustom.CMD_STORY_READ_CACHE, Long.valueOf(longValue)));
                }
                this.gzZ = dataRes.agree_banner;
                if (dataRes.user_extend != null) {
                    this.gAf = new com.baidu.tieba.frs.r();
                    this.gAf.a(dataRes.user_extend);
                }
                this.gAb = dataRes.live_frs_notify;
                this.gAc = dataRes.frs_game_tab_info;
                this.gAd = dataRes.game_default_tab_id.intValue();
                this.gAe = dataRes.forum_head_icon;
                if (dataRes.video != null && dataRes.video.video_act != null) {
                    this.gAg = new j();
                    this.gAg.a(dataRes.video.video_act);
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
        return this.gAa;
    }

    public void ds(List<com.baidu.adp.widget.ListView.f> list) {
        this.gAa = list;
    }

    public AgreeBanner buP() {
        return this.gzZ;
    }

    public void a(AgreeBanner agreeBanner) {
        this.gzZ = agreeBanner;
    }

    public ForumHeadIcon buQ() {
        return this.gAe;
    }

    public void a(ForumHeadIcon forumHeadIcon) {
        this.gAe = forumHeadIcon;
    }

    public List<RecmForumInfo> buR() {
        return this.recm_forum_list;
    }

    private void uj(int i) {
        this.gzD = 1;
        if (this.gzB != null && this.gzB.size() > 0) {
            for (FrsTabInfo frsTabInfo : this.gzB) {
                if (frsTabInfo != null && frsTabInfo.tab_id.intValue() == i) {
                    this.gzD = i;
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
                    bdVar.cH(this.ePl.getName());
                }
                bdVar.i(this.gzz);
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
        return this.ePl;
    }

    public int buT() {
        return this.gzS;
    }

    public void ul(int i) {
        this.gzS = i;
    }

    public int buU() {
        return this.gzT;
    }

    public void um(int i) {
        this.gzT = i;
    }

    public void c(ForumData forumData) {
        this.ePl = forumData;
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> getThreadList() {
        return this.threadList;
    }

    public void aA(ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        this.threadList = arrayList;
    }

    public AntiData qg() {
        return this.Xr;
    }

    public void c(AntiData antiData) {
        this.Xr = antiData;
    }

    public al qy() {
        return this.eaH;
    }

    public void a(al alVar) {
        this.eaH = alVar;
    }

    public i buV() {
        return this.gzn;
    }

    public void a(i iVar) {
        this.gzn = iVar;
    }

    public com.baidu.tbadk.core.data.o buW() {
        return this.gzA;
    }

    public void a(com.baidu.tbadk.core.data.o oVar) {
        this.gzA = oVar;
    }

    public boolean buX() {
        return this.gzo;
    }

    public void mY(boolean z) {
        this.gzo = z;
    }

    public String buY() {
        return this.gzp;
    }

    public void sR(String str) {
        this.gzp = str;
    }

    public l buZ() {
        return this.gzq;
    }

    public void a(l lVar) {
        this.gzq = lVar;
    }

    public UserData getUserData() {
        return this.ePs;
    }

    public void e(UserData userData) {
        this.ePs = userData;
    }

    public List<Long> bva() {
        return this.gzm;
    }

    public void dt(List<Long> list) {
        this.gzm = list;
    }

    public b bvb() {
        return this.gzr;
    }

    public void a(b bVar) {
        this.gzr = bVar;
    }

    public boolean bvc() {
        return this.gzs;
    }

    public void mZ(boolean z) {
        this.gzs = z;
    }

    public String getGameName() {
        return this.gameName;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public List<f> bvd() {
        return this.gzt;
    }

    public void du(List<f> list) {
        this.gzt = list;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public int aRC() {
        return this.gzu;
    }

    public void pJ(int i) {
        this.gzu = i;
    }

    public List<PhotoLiveCardData> bve() {
        return this.gzv;
    }

    public String bvf() {
        return this.gzy;
    }

    public void sS(String str) {
        this.gzy = str;
    }

    public List<FrsTabInfo> bvg() {
        return this.gzB;
    }

    public void dv(List<FrsTabInfo> list) {
        this.gzB = list;
    }

    public void dw(List<PhotoLiveCardData> list) {
        this.gzv = list;
    }

    public boolean bvh() {
        return this.gzx != null;
    }

    public PhotoLiveCardData bvi() {
        return this.gzx;
    }

    public void c(PhotoLiveCardData photoLiveCardData) {
        this.gzx = photoLiveCardData;
    }

    public int bvj() {
        return this.gzw;
    }

    public void un(int i) {
        this.gzw = i;
    }

    public List<FeedForumData> bvk() {
        return this.gzE;
    }

    public void dx(List<FeedForumData> list) {
        this.gzE = list;
    }

    public void sT(String str) {
        if (this.gzE != null && str != null) {
            for (FeedForumData feedForumData : this.gzE) {
                if (feedForumData != null && feedForumData.getForumId() != null && feedForumData.getForumId().equals(str)) {
                    this.gzE.remove(feedForumData);
                    return;
                }
            }
        }
    }

    public List<CategoryInfo> bvl() {
        return this.gzF;
    }

    public void dy(List<CategoryInfo> list) {
        this.gzF = list;
    }

    public void sU(String str) {
        this.gzG = str;
    }

    public String bvm() {
        return this.gzG;
    }

    public bd bvn() {
        return this.gzN;
    }

    public void ak(bd bdVar) {
        this.gzN = bdVar;
    }

    public int bvo() {
        return this.gzD;
    }

    public void uo(int i) {
        this.gzD = i;
    }

    public com.baidu.tbadk.core.data.v bvp() {
        return this.gzH;
    }

    public void a(com.baidu.tbadk.core.data.v vVar) {
        this.gzH = vVar;
    }

    public com.baidu.tbadk.core.data.p bvq() {
        return this.gzJ;
    }

    public void a(com.baidu.tbadk.core.data.p pVar) {
        this.gzJ = pVar;
    }

    public com.baidu.tbadk.core.data.r bvr() {
        return this.gzM;
    }

    public void a(com.baidu.tbadk.core.data.r rVar) {
        this.gzM = rVar;
    }

    public int bvs() {
        return this.gzP;
    }

    public void up(int i) {
        this.gzP = i;
    }

    public au bvt() {
        return this.gzO;
    }

    public void a(au auVar) {
        this.gzO = auVar;
    }

    public NavTabInfo bvu() {
        return this.gzC;
    }

    public void a(NavTabInfo navTabInfo) {
        this.gzC = navTabInfo;
    }

    public com.baidu.tbadk.core.data.l bvv() {
        return this.gzQ;
    }

    public void a(com.baidu.tbadk.core.data.l lVar) {
        this.gzQ = lVar;
    }

    public Integer bvw() {
        return this.gzK;
    }

    public void k(Integer num) {
        this.gzK = num;
    }

    public List<Integer> bvx() {
        return this.gzU;
    }

    public void dz(List<Integer> list) {
        this.gzU = list;
    }

    public List<com.baidu.adp.widget.ListView.f> bvy() {
        return this.gzV;
    }

    public void dA(List<com.baidu.adp.widget.ListView.f> list) {
        this.gzV = list;
    }

    public com.baidu.tieba.g.b bvz() {
        return this.gzY;
    }

    public void a(com.baidu.tieba.g.b bVar) {
        this.gzY = bVar;
    }

    public AlaLiveNotify bvA() {
        return this.gAb;
    }

    public void a(AlaLiveNotify alaLiveNotify) {
        this.gAb = alaLiveNotify;
    }

    public List<FrsTabInfo> bvB() {
        return this.gAc;
    }

    public void dB(List<FrsTabInfo> list) {
        this.gAc = list;
    }

    public void uq(int i) {
        this.gAd = i;
    }

    public int bvC() {
        return this.gAd;
    }

    public void a(com.baidu.tieba.frs.r rVar) {
        this.gAf = rVar;
    }

    public com.baidu.tieba.frs.r bvD() {
        return this.gAf;
    }

    public j bvE() {
        return this.gAg;
    }

    public void a(j jVar) {
        this.gAg = jVar;
    }

    public e bvF() {
        return this.gzW;
    }

    public void b(e eVar) {
        this.gzW = eVar;
    }
}

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
import com.baidu.tbadk.core.data.aa;
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.data.ba;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.w;
import com.baidu.tbadk.core.data.y;
import com.baidu.tbadk.core.data.z;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.al;
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
import tbclient.FrsPage.FrsPageResIdl;
import tbclient.FrsPage.NavTabInfo;
import tbclient.FrsPage.StarEnter;
import tbclient.FrsTabInfo;
import tbclient.PopInfo;
import tbclient.ThreadInfo;
import tbclient.User;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class g implements com.baidu.tbadk.mvc.b.c {
    public static final Wire WIRE = new Wire(new Class[0]);
    private AntiData XM;
    private AlaLiveNotify cun;
    protected ar dEx;
    protected ForumData eDL;
    private UserData eDR;
    private String gameName;
    private List<PhotoLiveCardData> gfA;
    private int gfB;
    private PhotoLiveCardData gfC;
    private String gfD;
    private z gfF;
    private List<FrsTabInfo> gfH;
    private NavTabInfo gfI;
    private List<FeedForumData> gfK;
    private List<CategoryInfo> gfL;
    private bl gfT;
    private ba gfU;
    private com.baidu.tbadk.core.data.m gfW;
    protected List<Long> gfr;
    private h gfs;
    protected boolean gft;
    protected String gfu;
    protected j gfv;
    private b gfw;
    private boolean gfx;
    private List<Integer> gga;
    private List<com.baidu.adp.widget.ListView.f> ggb;
    public PopInfo ggd;
    private com.baidu.tieba.g.b gge;
    private AgreeBanner ggf;
    protected List<com.baidu.adp.widget.ListView.f> ggg;
    private List<FrsTabInfo> ggh;
    private int mSortType;
    protected ArrayList<com.baidu.adp.widget.ListView.f> threadList;
    private HashMap<String, MetaData> userMap;
    public int gfq = 0;
    private List<e> gfy = new ArrayList();
    private int gfz = 0;
    private ArrayList<com.baidu.tbadk.core.data.o> gfE = new ArrayList<>();
    protected com.baidu.tbadk.core.data.r gfG = null;
    private int gfJ = 1;
    private String gfM = null;
    private y gfN = null;
    public aa gfO = null;
    private com.baidu.tbadk.core.data.s gfP = null;
    private Integer gfQ = -1;
    public w gfR = null;
    private com.baidu.tbadk.core.data.u gfS = null;
    private int gfV = -1;
    protected List<com.baidu.adp.widget.ListView.f> gfX = null;
    private int gfY = 0;
    private int gfZ = 0;
    private boolean isShowDriftingBottle = false;
    private long ggc = 0;
    private int alaLiveCount = 0;

    public g() {
        initData();
    }

    private void initData() {
        this.eDL = new ForumData();
        this.threadList = new ArrayList<>();
        this.gfX = new ArrayList();
        this.userMap = new HashMap<>();
        this.dEx = new ar();
        this.gfs = new h();
        this.eDR = new UserData();
        this.gfv = new j();
        d(new AntiData());
        a(new b());
        this.ggb = new ArrayList();
        this.gga = new ArrayList();
    }

    public FrsPageResIdl F(byte[] bArr) {
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
                if (!com.baidu.tbadk.core.util.u.v(dataRes.color_egg)) {
                    for (ColorEgg colorEgg : dataRes.color_egg) {
                        if (colorEgg != null && !com.baidu.tbadk.core.util.u.v(colorEgg.holiday_words)) {
                            com.baidu.tbadk.core.data.o oVar = new com.baidu.tbadk.core.data.o();
                            if (oVar.a(colorEgg)) {
                                this.gfE.add(oVar);
                            }
                        }
                    }
                }
                if (dataRes.activityhead != null && !com.baidu.tbadk.core.util.u.v(dataRes.activityhead.head_imgs)) {
                    this.gfG = new com.baidu.tbadk.core.data.r();
                    this.gfG.a(dataRes.activityhead);
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
                mO(dataRes.is_new_url.intValue());
                this.gft = dataRes.fortune_bag.intValue() == 1;
                this.gfu = dataRes.fortune_desc;
                if (dataRes.forum != null) {
                    this.gfx = dataRes.forum.has_game.intValue() == 1;
                    this.gfD = dataRes.forum.game_url;
                    this.gameName = dataRes.forum.game_name;
                }
                List<StarEnter> list2 = dataRes.star_enter;
                this.gfy.clear();
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        e eVar = new e();
                        eVar.a(list2.get(i2));
                        this.gfy.add(eVar);
                    }
                }
                this.gfv.a(dataRes.gcon_account);
                this.eDL.parserProtobuf(dataRes.forum);
                long longValue = dataRes.forum != null ? dataRes.forum.id.longValue() : 0L;
                this.gfr = dataRes.thread_id_list;
                this.XM.parserProtobuf(dataRes.anti);
                this.gfw.a(dataRes.group);
                this.dEx.a(dataRes.page);
                this.gfs.a(dataRes.frs_star);
                this.eDR.parserProtobuf(dataRes.user);
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.eDR.getIsSelectTail());
                }
                this.gfH = dataRes.frs_tab_info;
                if (dataRes.nav_tab_info == null) {
                    NavTabInfo.Builder builder = new NavTabInfo.Builder();
                    builder.tab = dataRes.frs_tab_info;
                    this.gfI = builder.build(true);
                } else {
                    this.gfI = dataRes.nav_tab_info;
                }
                this.alaLiveCount = dataRes.ala_live_count.intValue();
                sW(dataRes.frs_tab_default.intValue());
                List<ZhiBoInfoTW> list3 = dataRes.twzhibo_info;
                if (list3 != null && list3.size() > 0) {
                    this.gfA = new ArrayList();
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
                        this.gfA.add(photoLiveCardData);
                    }
                }
                this.gfB = dataRes.twzhibo_pos.intValue();
                if (dataRes.hot_twzhibo_info != null) {
                    this.gfC = new PhotoLiveCardData();
                    if (this.gfC.getShowStyle() < 0) {
                        PhotoLiveCardData photoLiveCardData2 = this.gfC;
                        this.gfC.setShowStyle(PhotoLiveCardData.getRandom(3, -1));
                    }
                    this.gfC.getShowStyle();
                    this.gfC.parserProtobuf(dataRes.hot_twzhibo_info);
                    this.gfC.setShowExpressionViewIndexList(this.gfC.getExpressionDatas());
                }
                a(dataRes.thread_list, longValue);
                this.gfL = dataRes.category_list;
                if (!al.isEmpty(dataRes.bawu_enter_url)) {
                    this.gfM = dataRes.bawu_enter_url;
                }
                if (dataRes.head_sdk != null) {
                    this.gfN = new y();
                    this.gfN.a(dataRes.head_sdk);
                }
                if (dataRes.recommend_book != null) {
                    this.gfO = new aa();
                    this.gfO.a(dataRes.recommend_book);
                }
                if (dataRes.book_info != null) {
                    this.gfP = new com.baidu.tbadk.core.data.s();
                    this.gfP.a(dataRes.book_info);
                }
                if (dataRes.forum_present_info != null) {
                    this.gfR = new w();
                    this.gfR.a(dataRes.forum_present_info);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.gfS = new com.baidu.tbadk.core.data.u();
                    this.gfS.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.ntspread != null) {
                    this.gfF = new z();
                    this.gfF.a(dataRes.ntspread);
                }
                if (dataRes.card_shipin_info != null && dataRes.card_shipin_info.size() > 0) {
                    this.gfT = new bl();
                    this.gfT.ap(true);
                    this.gfT.bW(this.gfB);
                    this.gfT.setUserMap(this.userMap);
                    this.gfT.a(dataRes.card_shipin_info.get(0));
                    this.gfT.sn();
                    if (this.gfT.getFid() == 0 && longValue != 0) {
                        this.gfT.setFid(longValue);
                    }
                    this.gfT.i(this.gfE);
                    this.gfT.ao(!this.gfT.rm());
                    if (this.gfT.getAuthor() != null && this.gfT.getAuthor().getPendantData() == null && (metaData = this.userMap.get(this.gfT.getAuthor().getUserId())) != null && metaData.getPendantData() != null) {
                        com.baidu.tbadk.data.j jVar = new com.baidu.tbadk.data.j();
                        jVar.Q(metaData.getPendantData().CB());
                        jVar.cH(metaData.getPendantData().pV());
                        this.gfT.getAuthor().setPendantData(jVar);
                    }
                }
                if (dataRes.school_recom_info != null) {
                    this.gfV = dataRes.school_recom_pos.intValue();
                    this.gfU = new ba();
                    this.gfU.a(dataRes.school_recom_info);
                }
                if (dataRes.carrier_enter != null) {
                    this.gfW = new com.baidu.tbadk.core.data.m();
                    this.gfW.a(dataRes.carrier_enter);
                }
                if (dataRes.vitality_info != null && dataRes.vitality_info.frequently_forum_info != null) {
                    this.gfY = dataRes.vitality_info.frequently_forum_info.forum_state.intValue();
                    this.gfZ = dataRes.vitality_info.frequently_forum_info.access_flag.intValue();
                }
                this.mSortType = dataRes.sort_type.intValue();
                this.gfq = dataRes.need_log.intValue();
                com.baidu.tieba.recapp.d.a.bii().rh(dataRes.asp_shown_info);
                this.gga = dataRes.card_shipin_pos;
                if (dataRes.card_shipin_new != null) {
                    for (int i5 = 0; i5 < dataRes.card_shipin_new.size(); i5++) {
                        bl blVar = new bl();
                        if (this.gga != null && this.gga.size() >= dataRes.card_shipin_new.size()) {
                            blVar.bW(this.gga.get(i5).intValue());
                        }
                        blVar.ap(true);
                        blVar.a(dataRes.card_shipin_new.get(i5));
                        this.ggb.add(blVar);
                    }
                }
                if (dataRes.bottle != null) {
                    this.isShowDriftingBottle = dataRes.bottle.has_enter_display.intValue() == 1;
                    this.ggc = dataRes.bottle.tid.longValue();
                } else {
                    this.isShowDriftingBottle = false;
                    this.ggc = 0L;
                }
                this.ggd = dataRes.enter_pop_info;
                if (dataRes.esport != null) {
                    this.gge = new com.baidu.tieba.g.b();
                    this.gge.a(dataRes.esport);
                }
                if (TbadkCoreApplication.isLogin() && dataRes.banner_user_story != null && dataRes.banner_user_story._switch.intValue() == 1) {
                    com.baidu.tbadk.data.e eVar2 = new com.baidu.tbadk.data.e();
                    eVar2.a(dataRes.banner_user_story, longValue);
                    this.ggg = eVar2.Ct();
                    MessageManager.getInstance().sendMessageFromBackground(new CustomMessage((int) CmdConfigCustom.CMD_STORY_READ_CACHE, Long.valueOf(longValue)));
                }
                this.ggf = dataRes.agree_banner;
                this.cun = dataRes.live_frs_notify;
                this.ggh = dataRes.frs_game_tab_info;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public List<com.baidu.adp.widget.ListView.f> bqx() {
        return this.ggg;
    }

    public void dh(List<com.baidu.adp.widget.ListView.f> list) {
        this.ggg = list;
    }

    public AgreeBanner bqy() {
        return this.ggf;
    }

    public void a(AgreeBanner agreeBanner) {
        this.ggf = agreeBanner;
    }

    private void sW(int i) {
        this.gfJ = 1;
        if (this.gfH != null && this.gfH.size() > 0) {
            for (FrsTabInfo frsTabInfo : this.gfH) {
                if (frsTabInfo != null && frsTabInfo.tab_id.intValue() == i) {
                    this.gfJ = i;
                    return;
                }
            }
        }
    }

    public void a(List<ThreadInfo> list, long j) {
        if (list != null) {
            boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
            for (int i = 0; i < list.size(); i++) {
                bl blVar = new bl();
                blVar.setUserMap(this.userMap);
                blVar.a(list.get(i));
                blVar.bX(3);
                blVar.sn();
                if (blVar.getFid() == 0 && j != 0) {
                    blVar.setFid(j);
                }
                if (StringUtils.isNull(blVar.rK())) {
                    blVar.cJ(this.eDL.getName());
                }
                blVar.i(this.gfE);
                if (blVar.getThreadType() == 33 && !blVar.sg()) {
                    ax axVar = new ax();
                    axVar.a(blVar, 0);
                    axVar.r(bqL());
                    if (appResponseToIntentClass) {
                        this.threadList.add(axVar);
                    }
                } else if (!TextUtils.isEmpty(blVar.sA())) {
                    ah ahVar = new ah();
                    ahVar.cE(blVar.sA());
                    this.threadList.add(ahVar);
                } else {
                    this.threadList.add(blVar);
                }
            }
        }
    }

    public int bqz() {
        return this.alaLiveCount;
    }

    public void sX(int i) {
        this.alaLiveCount = i;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] EZ() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public boolean C(byte[] bArr) {
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

    public ForumData aPh() {
        return this.eDL;
    }

    public int bqA() {
        return this.gfY;
    }

    public void sY(int i) {
        this.gfY = i;
    }

    public int bqB() {
        return this.gfZ;
    }

    public void sZ(int i) {
        this.gfZ = i;
    }

    public void c(ForumData forumData) {
        this.eDL = forumData;
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> getThreadList() {
        return this.threadList;
    }

    public void aB(ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        this.threadList = arrayList;
    }

    public AntiData qr() {
        return this.XM;
    }

    public void d(AntiData antiData) {
        this.XM = antiData;
    }

    public ar qH() {
        return this.dEx;
    }

    public void a(ar arVar) {
        this.dEx = arVar;
    }

    public h bqC() {
        return this.gfs;
    }

    public void a(h hVar) {
        this.gfs = hVar;
    }

    public com.baidu.tbadk.core.data.r bqD() {
        return this.gfG;
    }

    public void a(com.baidu.tbadk.core.data.r rVar) {
        this.gfG = rVar;
    }

    public boolean bqE() {
        return this.gft;
    }

    public void ms(boolean z) {
        this.gft = z;
    }

    public String bqF() {
        return this.gfu;
    }

    public void rP(String str) {
        this.gfu = str;
    }

    public j bqG() {
        return this.gfv;
    }

    public void a(j jVar) {
        this.gfv = jVar;
    }

    public UserData getUserData() {
        return this.eDR;
    }

    public void setUserData(UserData userData) {
        this.eDR = userData;
    }

    public List<Long> bqH() {
        return this.gfr;
    }

    public void di(List<Long> list) {
        this.gfr = list;
    }

    public b bqI() {
        return this.gfw;
    }

    public void a(b bVar) {
        this.gfw = bVar;
    }

    public boolean bqJ() {
        return this.gfx;
    }

    public void mt(boolean z) {
        this.gfx = z;
    }

    public String getGameName() {
        return this.gameName;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public List<e> bqK() {
        return this.gfy;
    }

    public void dj(List<e> list) {
        this.gfy = list;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public int aPv() {
        return this.gfz;
    }

    public void mO(int i) {
        this.gfz = i;
    }

    public List<PhotoLiveCardData> bqL() {
        return this.gfA;
    }

    public String bqM() {
        return this.gfD;
    }

    public void rQ(String str) {
        this.gfD = str;
    }

    public List<FrsTabInfo> bqN() {
        return this.gfH;
    }

    public void dk(List<FrsTabInfo> list) {
        this.gfH = list;
    }

    public void dl(List<PhotoLiveCardData> list) {
        this.gfA = list;
    }

    public boolean bqO() {
        return this.gfC != null;
    }

    public PhotoLiveCardData bqP() {
        return this.gfC;
    }

    public void c(PhotoLiveCardData photoLiveCardData) {
        this.gfC = photoLiveCardData;
    }

    public z bqQ() {
        return this.gfF;
    }

    public void a(z zVar) {
        this.gfF = zVar;
    }

    public int bqR() {
        return this.gfB;
    }

    public void ta(int i) {
        this.gfB = i;
    }

    public List<FeedForumData> bqS() {
        return this.gfK;
    }

    public void dm(List<FeedForumData> list) {
        this.gfK = list;
    }

    public void rR(String str) {
        if (this.gfK != null && str != null) {
            for (FeedForumData feedForumData : this.gfK) {
                if (feedForumData != null && feedForumData.getForumId() != null && feedForumData.getForumId().equals(str)) {
                    this.gfK.remove(feedForumData);
                    return;
                }
            }
        }
    }

    public List<CategoryInfo> bqT() {
        return this.gfL;
    }

    public void dn(List<CategoryInfo> list) {
        this.gfL = list;
    }

    public void rS(String str) {
        this.gfM = str;
    }

    public String bqU() {
        return this.gfM;
    }

    public bl bqV() {
        return this.gfT;
    }

    public void ah(bl blVar) {
        this.gfT = blVar;
    }

    public int bqW() {
        return this.gfJ;
    }

    public void tb(int i) {
        this.gfJ = i;
    }

    public y bqX() {
        return this.gfN;
    }

    public void a(y yVar) {
        this.gfN = yVar;
    }

    public com.baidu.tbadk.core.data.s bqY() {
        return this.gfP;
    }

    public void a(com.baidu.tbadk.core.data.s sVar) {
        this.gfP = sVar;
    }

    public com.baidu.tbadk.core.data.u bqZ() {
        return this.gfS;
    }

    public void a(com.baidu.tbadk.core.data.u uVar) {
        this.gfS = uVar;
    }

    public int bra() {
        return this.gfV;
    }

    public void tc(int i) {
        this.gfV = i;
    }

    public ba brb() {
        return this.gfU;
    }

    public void a(ba baVar) {
        this.gfU = baVar;
    }

    public NavTabInfo brc() {
        return this.gfI;
    }

    public void a(NavTabInfo navTabInfo) {
        this.gfI = navTabInfo;
    }

    public com.baidu.tbadk.core.data.m brd() {
        return this.gfW;
    }

    public void a(com.baidu.tbadk.core.data.m mVar) {
        this.gfW = mVar;
    }

    public Integer bre() {
        return this.gfQ;
    }

    public void i(Integer num) {
        this.gfQ = num;
    }

    public List<Integer> brf() {
        return this.gga;
    }

    /* renamed from: do  reason: not valid java name */
    public void m13do(List<Integer> list) {
        this.gga = list;
    }

    public List<com.baidu.adp.widget.ListView.f> brg() {
        return this.ggb;
    }

    public void dp(List<com.baidu.adp.widget.ListView.f> list) {
        this.ggb = list;
    }

    public boolean isShowDriftingBottle() {
        return this.isShowDriftingBottle;
    }

    public long brh() {
        return this.ggc;
    }

    public void mu(boolean z) {
        this.isShowDriftingBottle = z;
    }

    public void cS(long j) {
        this.ggc = j;
    }

    public com.baidu.tieba.g.b bri() {
        return this.gge;
    }

    public void a(com.baidu.tieba.g.b bVar) {
        this.gge = bVar;
    }

    public AlaLiveNotify brj() {
        return this.cun;
    }

    public void a(AlaLiveNotify alaLiveNotify) {
        this.cun = alaLiveNotify;
    }

    public List<FrsTabInfo> brk() {
        return this.ggh;
    }

    public void dq(List<FrsTabInfo> list) {
        this.ggh = list;
    }
}

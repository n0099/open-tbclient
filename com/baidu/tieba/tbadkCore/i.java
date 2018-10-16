package com.baidu.tieba.tbadkCore;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.FeedForumData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.ab;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.data.x;
import com.baidu.tbadk.core.util.ao;
import com.squareup.wire.Message;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;
import tbclient.AlaLiveNotify;
import tbclient.BottomMenu;
import tbclient.CategoryInfo;
import tbclient.ForumArIno;
import tbclient.FrsPage.ActivityConfig;
import tbclient.FrsPage.AgreeBanner;
import tbclient.FrsPage.ColorEgg;
import tbclient.FrsPage.DataRes;
import tbclient.FrsPage.ForumHeadIcon;
import tbclient.FrsPage.FrsPageResIdl;
import tbclient.FrsPage.NavTabInfo;
import tbclient.FrsPage.RecmForumInfo;
import tbclient.FrsPage.RecomPostTopic;
import tbclient.FrsPage.StarEnter;
import tbclient.FrsPage.StarRank;
import tbclient.FrsPage.WorldcupSkin;
import tbclient.FrsTabInfo;
import tbclient.OriForumInfo;
import tbclient.PopInfo;
import tbclient.SmartApp;
import tbclient.ThreadInfo;
import tbclient.User;
import tbclient.WindowToast;
/* loaded from: classes6.dex */
public class i implements com.baidu.tbadk.mvc.b.c {
    public static final Wire WIRE = new Wire(new Class[0]);
    private AntiData anH;
    public ForumArIno dGk;
    protected al eWA;
    private UserData fHF;
    protected ForumData fHy;
    private String gameName;
    private bb haI;
    private at haJ;
    private com.baidu.tbadk.core.data.l haL;
    private List<Integer> haP;
    private List<com.baidu.adp.widget.ListView.h> haQ;
    private e haR;
    private f haS;
    public PopInfo haT;
    private com.baidu.tieba.h.b haU;
    private AgreeBanner haV;
    private AlaLiveNotify haW;
    private List<FrsTabInfo> haX;
    private ForumHeadIcon haZ;
    protected List<Long> haj;
    private j hak;
    protected boolean hal;
    protected String ham;
    protected m han;
    private b hao;
    private boolean hap;
    private int has;
    private String hat;
    private NavTabInfo haw;
    private List<FeedForumData> hay;
    private List<CategoryInfo> haz;
    private com.baidu.tieba.frs.q hba;
    private k hbb;
    public FrsTabInfo hbc;
    public StarRank hbd;
    public List<WindowToast> hbe;
    public ActivityConfig hbf;
    private WorldcupSkin hbg;
    public com.baidu.tieba.frs.b hbh;
    public List<OriForumInfo> hbi;
    public List<BottomMenu> hbj;
    private com.baidu.tieba.tbadkCore.data.m hbk;
    public boolean hbl;
    public List<String> hbn;
    public SmartApp hbo;
    public boolean isBrandForum;
    private int mSortType;
    public List<RecmForumInfo> recm_forum_list;
    protected ArrayList<com.baidu.adp.widget.ListView.h> threadList;
    private HashMap<String, MetaData> userMap;
    public int hai = 0;
    private List<g> haq = new ArrayList();
    private int har = 0;
    private ArrayList<com.baidu.tbadk.core.data.n> hau = new ArrayList<>();
    protected com.baidu.tbadk.core.data.o hav = null;
    private int hax = 1;
    private boolean gjG = false;
    private String haA = null;
    private com.baidu.tbadk.core.data.w haB = null;
    public x haC = null;
    public RecomPostTopic haD = null;
    private com.baidu.tbadk.core.data.p haE = null;
    private Integer haF = -1;
    public com.baidu.tbadk.core.data.u haG = null;
    private com.baidu.tbadk.core.data.r haH = null;
    private int haK = -1;
    protected List<com.baidu.adp.widget.ListView.h> haM = null;
    private int haN = 0;
    private int haO = 0;
    private int alaLiveCount = 0;
    private int haY = 0;
    public int dHx = 0;
    public int hbm = 1;

    public i() {
        initData();
    }

    private void initData() {
        this.fHy = new ForumData();
        this.threadList = new ArrayList<>();
        this.haM = new ArrayList();
        this.userMap = new HashMap<>();
        this.eWA = new al();
        this.hak = new j();
        this.fHF = new UserData();
        this.han = new m();
        c(new AntiData());
        a(new b());
        this.haQ = new ArrayList();
        this.haP = new ArrayList();
    }

    public FrsPageResIdl N(byte[] bArr) {
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
                if (!com.baidu.tbadk.core.util.v.J(dataRes.color_egg)) {
                    for (ColorEgg colorEgg : dataRes.color_egg) {
                        if (colorEgg != null && !com.baidu.tbadk.core.util.v.J(colorEgg.holiday_words)) {
                            com.baidu.tbadk.core.data.n nVar = new com.baidu.tbadk.core.data.n();
                            if (nVar.a(colorEgg)) {
                                this.hau.add(nVar);
                            }
                        }
                    }
                }
                if (dataRes.forum != null) {
                    this.hap = dataRes.forum.has_game.intValue() == 1;
                    this.hat = dataRes.forum.game_url;
                    this.gameName = dataRes.forum.game_name;
                    this.isBrandForum = dataRes.forum.is_brand_forum.intValue() == 1;
                }
                if (this.isBrandForum && dataRes.brand_forum_info != null) {
                    this.hav = new com.baidu.tbadk.core.data.o();
                    this.hav.a(dataRes.brand_forum_info.head_imgs);
                    this.hbh = new com.baidu.tieba.frs.b();
                    this.hbh.a(dataRes.brand_forum_info);
                    if (!com.baidu.tbadk.core.util.v.J(dataRes.brand_forum_info.relation_forum)) {
                        this.hbi = new ArrayList();
                        for (OriForumInfo oriForumInfo : dataRes.brand_forum_info.relation_forum) {
                            if (oriForumInfo != null) {
                                this.hbi.add(oriForumInfo);
                            }
                        }
                    }
                } else if (dataRes.activityhead != null && !com.baidu.tbadk.core.util.v.J(dataRes.activityhead.head_imgs)) {
                    this.hav = new com.baidu.tbadk.core.data.o();
                    this.hav.a(dataRes.activityhead);
                }
                this.hbj = dataRes.bottom_menu;
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
                rl(dataRes.is_new_url.intValue());
                this.hal = dataRes.fortune_bag.intValue() == 1;
                this.ham = dataRes.fortune_desc;
                List<StarEnter> list2 = dataRes.star_enter;
                this.haq.clear();
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        g gVar = new g();
                        gVar.a(list2.get(i2));
                        this.haq.add(gVar);
                    }
                }
                this.han.a(dataRes.gcon_account);
                this.fHy.parserProtobuf(dataRes.forum);
                long longValue = dataRes.forum != null ? dataRes.forum.id.longValue() : 0L;
                this.haj = dataRes.thread_id_list;
                this.anH.parserProtobuf(dataRes.anti);
                if (dataRes.anti != null) {
                    com.baidu.tieba.ueg.c.e(dataRes.anti.block_pop_info);
                }
                this.hao.a(dataRes.group);
                this.eWA.a(dataRes.page);
                this.hak.a(dataRes.frs_star);
                this.fHF.parserProtobuf(dataRes.user);
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.fHF.getIsSelectTail());
                }
                if (dataRes.nav_tab_info == null) {
                    NavTabInfo.Builder builder = new NavTabInfo.Builder();
                    builder.tab = dataRes.frs_tab_info;
                    this.haw = builder.build(true);
                } else {
                    this.haw = dataRes.nav_tab_info;
                }
                if (this.haw != null && com.baidu.tbadk.core.util.v.d(this.haw.tab, 0) != null) {
                    this.hbm = ((FrsTabInfo) com.baidu.tbadk.core.util.v.d(this.haw.tab, 0)).tab_id.intValue();
                }
                if (this.haw != null && !com.baidu.tbadk.core.util.v.J(this.haw.head)) {
                    this.hbc = this.haw.head.get(0);
                }
                this.alaLiveCount = dataRes.ala_live_count.intValue();
                ut(dataRes.frs_tab_default.intValue());
                this.has = dataRes.twzhibo_pos.intValue();
                this.gjG = dataRes.trends_redpoint.intValue() == 1;
                c(dataRes.thread_list, longValue);
                this.haz = dataRes.category_list;
                if (!ao.isEmpty(dataRes.bawu_enter_url)) {
                    this.haA = dataRes.bawu_enter_url;
                }
                if (dataRes.head_sdk != null) {
                    this.haB = new com.baidu.tbadk.core.data.w();
                    this.haB.a(dataRes.head_sdk);
                }
                if (dataRes.recommend_book != null) {
                    this.haC = new x();
                    this.haC.a(dataRes.recommend_book);
                }
                if (dataRes.book_info != null) {
                    this.haE = new com.baidu.tbadk.core.data.p();
                    this.haE.a(dataRes.book_info);
                }
                if (dataRes.forum_present_info != null) {
                    this.haG = new com.baidu.tbadk.core.data.u();
                    this.haG.a(dataRes.forum_present_info);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.haH = new com.baidu.tbadk.core.data.r();
                    this.haH.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.card_shipin_info != null && dataRes.card_shipin_info.size() > 0) {
                    this.haI = new bb();
                    this.haI.aK(true);
                    this.haI.ct(this.has);
                    this.haI.setUserMap(this.userMap);
                    this.haI.a(dataRes.card_shipin_info.get(0));
                    this.haI.zf();
                    this.haI.arq = this.isBrandForum;
                    if (this.haI.getFid() == 0 && longValue != 0) {
                        this.haI.setFid(longValue);
                    }
                    this.haI.m(this.hau);
                    this.haI.aJ(!this.haI.yb());
                    if (this.haI.yv() != null && this.haI.yv().getPendantData() == null && (metaData = this.userMap.get(this.haI.yv().getUserId())) != null && metaData.getPendantData() != null) {
                        com.baidu.tbadk.data.j jVar = new com.baidu.tbadk.data.j();
                        jVar.af(metaData.getPendantData().Ko());
                        jVar.dR(metaData.getPendantData().xf());
                        this.haI.yv().setPendantData(jVar);
                    }
                }
                if (dataRes.ala_live_insert != null && dataRes.ala_live_insert.ala_live_list != null && dataRes.ala_live_insert.ala_live_list.size() > 0) {
                    this.haR = new e();
                    this.haR.gZD = dataRes.ala_insert_floor.intValue();
                    ArrayList arrayList = new ArrayList();
                    for (int i3 = 0; i3 < dataRes.ala_live_insert.ala_live_list.size(); i3++) {
                        if (dataRes.ala_live_insert.ala_live_list.get(i3) != null) {
                            bb bbVar = new bb();
                            bbVar.a(dataRes.ala_live_insert.ala_live_list.get(i3));
                            bbVar.arq = this.isBrandForum;
                            arrayList.add(bbVar);
                        }
                    }
                    this.haR.gZC = arrayList;
                }
                if (dataRes.ala_stage_list != null) {
                    this.haS = new f();
                    ArrayList arrayList2 = new ArrayList();
                    for (int i4 = 0; i4 < dataRes.ala_stage_list.size(); i4++) {
                        if (dataRes.ala_stage_list.get(i4) != null) {
                            bb bbVar2 = new bb();
                            bbVar2.a(dataRes.ala_stage_list.get(i4));
                            bbVar2.arq = this.isBrandForum;
                            arrayList2.add(bbVar2);
                        }
                    }
                    this.haS.gZF = arrayList2;
                }
                if (dataRes.school_recom_info != null) {
                    this.haK = dataRes.school_recom_pos.intValue();
                    this.haJ = new at();
                    this.haJ.a(dataRes.school_recom_info);
                }
                if (dataRes.carrier_enter != null) {
                    this.haL = new com.baidu.tbadk.core.data.l();
                    this.haL.a(dataRes.carrier_enter);
                }
                if (dataRes.vitality_info != null && dataRes.vitality_info.frequently_forum_info != null) {
                    this.haN = dataRes.vitality_info.frequently_forum_info.forum_state.intValue();
                    this.haO = dataRes.vitality_info.frequently_forum_info.access_flag.intValue();
                }
                this.mSortType = dataRes.sort_type.intValue();
                this.hai = dataRes.need_log.intValue();
                com.baidu.tieba.recapp.d.a.bua().uf(dataRes.asp_shown_info);
                this.haP = dataRes.card_shipin_pos;
                if (dataRes.card_shipin_new != null) {
                    for (int i5 = 0; i5 < dataRes.card_shipin_new.size(); i5++) {
                        bb bbVar3 = new bb();
                        if (this.haP != null && this.haP.size() >= dataRes.card_shipin_new.size()) {
                            bbVar3.ct(this.haP.get(i5).intValue());
                        }
                        bbVar3.aK(true);
                        bbVar3.a(dataRes.card_shipin_new.get(i5));
                        bbVar3.arq = this.isBrandForum;
                        this.haQ.add(bbVar3);
                    }
                }
                this.haT = dataRes.enter_pop_info;
                if (dataRes.esport != null) {
                    this.haU = new com.baidu.tieba.h.b();
                    this.haU.a(dataRes.esport);
                }
                this.haV = dataRes.agree_banner;
                if (dataRes.user_extend != null) {
                    this.hba = new com.baidu.tieba.frs.q();
                    this.hba.a(dataRes.user_extend);
                }
                this.haW = dataRes.live_frs_notify;
                this.haX = dataRes.frs_game_tab_info;
                this.haY = dataRes.game_default_tab_id.intValue();
                this.haZ = dataRes.forum_head_icon;
                if (dataRes.video != null && dataRes.video.video_act != null) {
                    this.hbb = new k();
                    this.hbb.a(dataRes.video.video_act);
                }
                if (dataRes.info != null) {
                    this.recm_forum_list = dataRes.info.recm_forum_list;
                }
                this.dGk = dataRes.forum_ar_info;
                if (dataRes.star_rank_info != null) {
                    this.hbd = dataRes.star_rank_info;
                }
                if (dataRes.recom_post_topic != null) {
                    this.haD = dataRes.recom_post_topic;
                }
                this.hbe = dataRes.window_toast;
                this.hbf = dataRes.activity_config;
                this.hbg = dataRes.worldcup_skin;
                this.hbk = new com.baidu.tieba.tbadkCore.data.m();
                this.hbk.a(dataRes.redpacketrain);
                this.hbl = dataRes.video_auto_play.intValue() == 1;
                this.hbn = dataRes.smart_app_avatar;
                this.hbo = dataRes.smart_app;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public AgreeBanner bzV() {
        return this.haV;
    }

    public void a(AgreeBanner agreeBanner) {
        this.haV = agreeBanner;
    }

    public ForumHeadIcon bzW() {
        return this.haZ;
    }

    public void a(ForumHeadIcon forumHeadIcon) {
        this.haZ = forumHeadIcon;
    }

    public List<RecmForumInfo> bzX() {
        return this.recm_forum_list;
    }

    private void ut(int i) {
        this.hax = 1;
        if (this.haw != null && this.haw.tab != null && this.haw.tab.size() > 0) {
            for (FrsTabInfo frsTabInfo : this.haw.tab) {
                if (frsTabInfo != null && frsTabInfo.tab_id.intValue() == i) {
                    this.hax = i;
                    return;
                }
            }
        }
    }

    public void c(List<ThreadInfo> list, long j) {
        if (!com.baidu.tbadk.core.util.v.J(list)) {
            for (ThreadInfo threadInfo : list) {
                if (threadInfo != null) {
                    bb bbVar = new bb();
                    bbVar.setUserMap(this.userMap);
                    bbVar.a(threadInfo);
                    bbVar.setCurrentPage(3);
                    bbVar.zf();
                    if (bbVar.getFid() == 0 && j != 0) {
                        bbVar.setFid(j);
                    }
                    if (StringUtils.isNull(bbVar.yB())) {
                        bbVar.dU(this.fHy.getName());
                    }
                    bbVar.m(this.hau);
                    bbVar.arq = this.fHy.isBrandForum;
                    if (!TextUtils.isEmpty(bbVar.zp())) {
                        ab abVar = new ab();
                        abVar.dP(bbVar.zp());
                        this.threadList.add(abVar);
                    } else {
                        this.threadList.add(bbVar);
                    }
                }
            }
        }
    }

    public int bzY() {
        return this.alaLiveCount;
    }

    public void uu(int i) {
        this.alaLiveCount = i;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] MK() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public boolean G(byte[] bArr) {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void H(JSONObject jSONObject) {
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void a(Message message) {
    }

    public ForumData beT() {
        return this.fHy;
    }

    public int bzZ() {
        return this.haN;
    }

    public void uv(int i) {
        this.haN = i;
    }

    public int bAa() {
        return this.haO;
    }

    public void uw(int i) {
        this.haO = i;
    }

    public void c(ForumData forumData) {
        this.fHy = forumData;
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> getThreadList() {
        return this.threadList;
    }

    public void ay(ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        this.threadList = arrayList;
    }

    public AntiData xs() {
        return this.anH;
    }

    public void c(AntiData antiData) {
        this.anH = antiData;
    }

    public al xH() {
        return this.eWA;
    }

    public void a(al alVar) {
        this.eWA = alVar;
    }

    public j bAb() {
        return this.hak;
    }

    public void a(j jVar) {
        this.hak = jVar;
    }

    public com.baidu.tbadk.core.data.o bAc() {
        return this.hav;
    }

    public void a(com.baidu.tbadk.core.data.o oVar) {
        this.hav = oVar;
    }

    public boolean bAd() {
        return this.hal;
    }

    public void na(boolean z) {
        this.hal = z;
    }

    public String bAe() {
        return this.ham;
    }

    public void uM(String str) {
        this.ham = str;
    }

    public m bAf() {
        return this.han;
    }

    public void a(m mVar) {
        this.han = mVar;
    }

    public UserData getUserData() {
        return this.fHF;
    }

    public void e(UserData userData) {
        this.fHF = userData;
    }

    public List<Long> bAg() {
        return this.haj;
    }

    public void dD(List<Long> list) {
        this.haj = list;
    }

    public b bAh() {
        return this.hao;
    }

    public void a(b bVar) {
        this.hao = bVar;
    }

    public boolean bAi() {
        return this.hap;
    }

    public void nb(boolean z) {
        this.hap = z;
    }

    public String getGameName() {
        return this.gameName;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public List<g> bAj() {
        return this.haq;
    }

    public void dE(List<g> list) {
        this.haq = list;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public int bfi() {
        return this.har;
    }

    public void rl(int i) {
        this.har = i;
    }

    public String bAk() {
        return this.hat;
    }

    public void uN(String str) {
        this.hat = str;
    }

    public int bAl() {
        return this.has;
    }

    public void ux(int i) {
        this.has = i;
    }

    public List<FeedForumData> bAm() {
        return this.hay;
    }

    public void dF(List<FeedForumData> list) {
        this.hay = list;
    }

    public void uO(String str) {
        if (this.hay != null && str != null) {
            for (FeedForumData feedForumData : this.hay) {
                if (feedForumData != null && feedForumData.getForumId() != null && feedForumData.getForumId().equals(str)) {
                    this.hay.remove(feedForumData);
                    return;
                }
            }
        }
    }

    public List<CategoryInfo> bAn() {
        return this.haz;
    }

    public void dG(List<CategoryInfo> list) {
        this.haz = list;
    }

    public void uP(String str) {
        this.haA = str;
    }

    public String bAo() {
        return this.haA;
    }

    public bb bAp() {
        return this.haI;
    }

    public void at(bb bbVar) {
        this.haI = bbVar;
    }

    public int bAq() {
        return this.hax;
    }

    public void uy(int i) {
        this.hax = i;
    }

    public com.baidu.tbadk.core.data.w bAr() {
        return this.haB;
    }

    public void a(com.baidu.tbadk.core.data.w wVar) {
        this.haB = wVar;
    }

    public com.baidu.tbadk.core.data.p bAs() {
        return this.haE;
    }

    public void a(com.baidu.tbadk.core.data.p pVar) {
        this.haE = pVar;
    }

    public com.baidu.tbadk.core.data.r bAt() {
        return this.haH;
    }

    public void a(com.baidu.tbadk.core.data.r rVar) {
        this.haH = rVar;
    }

    public int bAu() {
        return this.haK;
    }

    public void uz(int i) {
        this.haK = i;
    }

    public at bAv() {
        return this.haJ;
    }

    public void a(at atVar) {
        this.haJ = atVar;
    }

    public NavTabInfo bAw() {
        return this.haw;
    }

    public void a(NavTabInfo navTabInfo) {
        this.haw = navTabInfo;
    }

    public boolean bAx() {
        return this.gjG;
    }

    public void nc(boolean z) {
        this.gjG = z;
    }

    public com.baidu.tbadk.core.data.l bAy() {
        return this.haL;
    }

    public void a(com.baidu.tbadk.core.data.l lVar) {
        this.haL = lVar;
    }

    public int aaI() {
        return this.mSortType;
    }

    public Integer bAz() {
        return this.haF;
    }

    public void q(Integer num) {
        this.haF = num;
    }

    public List<Integer> bAA() {
        return this.haP;
    }

    public void dH(List<Integer> list) {
        this.haP = list;
    }

    public List<com.baidu.adp.widget.ListView.h> bAB() {
        return this.haQ;
    }

    public void dI(List<com.baidu.adp.widget.ListView.h> list) {
        this.haQ = list;
    }

    public com.baidu.tieba.h.b bAC() {
        return this.haU;
    }

    public void a(com.baidu.tieba.h.b bVar) {
        this.haU = bVar;
    }

    public AlaLiveNotify bAD() {
        return this.haW;
    }

    public void a(AlaLiveNotify alaLiveNotify) {
        this.haW = alaLiveNotify;
    }

    public List<FrsTabInfo> bAE() {
        return this.haX;
    }

    public void dJ(List<FrsTabInfo> list) {
        this.haX = list;
    }

    public void uA(int i) {
        this.haY = i;
    }

    public int bAF() {
        return this.haY;
    }

    public void a(com.baidu.tieba.frs.q qVar) {
        this.hba = qVar;
    }

    public com.baidu.tieba.frs.q bAG() {
        return this.hba;
    }

    public k bAH() {
        return this.hbb;
    }

    public void a(k kVar) {
        this.hbb = kVar;
    }

    public e bAI() {
        return this.haR;
    }

    public void b(e eVar) {
        this.haR = eVar;
    }

    public f bAJ() {
        return this.haS;
    }

    public void b(f fVar) {
        this.haS = fVar;
    }

    public WorldcupSkin bAK() {
        return this.hbg;
    }

    public com.baidu.tieba.tbadkCore.data.m bAL() {
        return this.hbk;
    }

    public void d(com.baidu.tieba.tbadkCore.data.m mVar) {
        this.hbk = mVar;
    }
}

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
import tbclient.FrsPage.NebulaHotThreads;
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
    private AntiData asy;
    public ForumArIno dRw;
    protected ForumData fTD;
    private UserData fTK;
    protected al fip;
    private String gameName;
    protected List<Long> hmR;
    private j hmS;
    protected boolean hmT;
    protected String hmU;
    protected m hmV;
    private b hmW;
    private boolean hmX;
    private f hnA;
    public PopInfo hnB;
    private com.baidu.tieba.h.b hnC;
    private AgreeBanner hnD;
    private AlaLiveNotify hnE;
    private List<FrsTabInfo> hnF;
    private ForumHeadIcon hnH;
    private com.baidu.tieba.frs.q hnI;
    private k hnJ;
    public FrsTabInfo hnK;
    public StarRank hnL;
    public List<WindowToast> hnM;
    public ActivityConfig hnN;
    private WorldcupSkin hnO;
    public com.baidu.tieba.frs.b hnP;
    public List<OriForumInfo> hnQ;
    public List<BottomMenu> hnR;
    private com.baidu.tieba.tbadkCore.data.m hnS;
    public boolean hnT;
    public List<String> hnV;
    public SmartApp hnW;
    public NebulaHotThreads hnX;
    private int hna;
    private String hnb;
    private NavTabInfo hne;
    private List<FeedForumData> hng;
    private List<CategoryInfo> hnh;
    private bb hnq;
    private at hnr;
    private com.baidu.tbadk.core.data.l hnt;
    private List<Integer> hnx;
    private List<com.baidu.adp.widget.ListView.h> hny;
    private e hnz;
    public boolean isBrandForum;
    private int mSortType;
    public List<RecmForumInfo> recm_forum_list;
    protected ArrayList<com.baidu.adp.widget.ListView.h> threadList;
    private HashMap<String, MetaData> userMap;
    public int hmQ = 0;
    private List<g> hmY = new ArrayList();
    private int hmZ = 0;
    private ArrayList<com.baidu.tbadk.core.data.n> hnc = new ArrayList<>();
    protected com.baidu.tbadk.core.data.o hnd = null;
    private int hnf = 1;
    private boolean gvS = false;
    private String hni = null;
    private com.baidu.tbadk.core.data.w hnj = null;
    public x hnk = null;
    public RecomPostTopic hnl = null;
    private com.baidu.tbadk.core.data.p hnm = null;
    private Integer hnn = -1;
    public com.baidu.tbadk.core.data.u hno = null;
    private com.baidu.tbadk.core.data.r hnp = null;
    private int hns = -1;
    protected List<com.baidu.adp.widget.ListView.h> hnu = null;
    private int hnv = 0;
    private int hnw = 0;
    private int alaLiveCount = 0;
    private int hnG = 0;
    public int dSA = 0;
    public int hnU = 1;

    public i() {
        initData();
    }

    private void initData() {
        this.fTD = new ForumData();
        this.threadList = new ArrayList<>();
        this.hnu = new ArrayList();
        this.userMap = new HashMap<>();
        this.fip = new al();
        this.hmS = new j();
        this.fTK = new UserData();
        this.hmV = new m();
        c(new AntiData());
        a(new b());
        this.hny = new ArrayList();
        this.hnx = new ArrayList();
    }

    public FrsPageResIdl M(byte[] bArr) {
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
                if (!com.baidu.tbadk.core.util.v.I(dataRes.color_egg)) {
                    for (ColorEgg colorEgg : dataRes.color_egg) {
                        if (colorEgg != null && !com.baidu.tbadk.core.util.v.I(colorEgg.holiday_words)) {
                            com.baidu.tbadk.core.data.n nVar = new com.baidu.tbadk.core.data.n();
                            if (nVar.a(colorEgg)) {
                                this.hnc.add(nVar);
                            }
                        }
                    }
                }
                if (dataRes.forum != null) {
                    this.hmX = dataRes.forum.has_game.intValue() == 1;
                    this.hnb = dataRes.forum.game_url;
                    this.gameName = dataRes.forum.game_name;
                    this.isBrandForum = dataRes.forum.is_brand_forum.intValue() == 1;
                }
                if (this.isBrandForum && dataRes.brand_forum_info != null) {
                    this.hnd = new com.baidu.tbadk.core.data.o();
                    this.hnd.a(dataRes.brand_forum_info.head_imgs);
                    this.hnP = new com.baidu.tieba.frs.b();
                    this.hnP.a(dataRes.brand_forum_info);
                    if (!com.baidu.tbadk.core.util.v.I(dataRes.brand_forum_info.relation_forum)) {
                        this.hnQ = new ArrayList();
                        for (OriForumInfo oriForumInfo : dataRes.brand_forum_info.relation_forum) {
                            if (oriForumInfo != null) {
                                this.hnQ.add(oriForumInfo);
                            }
                        }
                    }
                } else if (dataRes.activityhead != null && !com.baidu.tbadk.core.util.v.I(dataRes.activityhead.head_imgs)) {
                    this.hnd = new com.baidu.tbadk.core.data.o();
                    this.hnd.a(dataRes.activityhead);
                }
                this.hnR = dataRes.bottom_menu;
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
                sp(dataRes.is_new_url.intValue());
                this.hmT = dataRes.fortune_bag.intValue() == 1;
                this.hmU = dataRes.fortune_desc;
                List<StarEnter> list2 = dataRes.star_enter;
                this.hmY.clear();
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        g gVar = new g();
                        gVar.a(list2.get(i2));
                        this.hmY.add(gVar);
                    }
                }
                this.hmV.a(dataRes.gcon_account);
                this.fTD.parserProtobuf(dataRes.forum);
                long longValue = dataRes.forum != null ? dataRes.forum.id.longValue() : 0L;
                this.hmR = dataRes.thread_id_list;
                this.asy.parserProtobuf(dataRes.anti);
                if (dataRes.anti != null) {
                    com.baidu.tieba.ueg.c.e(dataRes.anti.block_pop_info);
                }
                this.hmW.a(dataRes.group);
                this.fip.a(dataRes.page);
                this.hmS.a(dataRes.frs_star);
                this.fTK.parserProtobuf(dataRes.user);
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.fTK.getIsSelectTail());
                }
                if (dataRes.nav_tab_info == null) {
                    NavTabInfo.Builder builder = new NavTabInfo.Builder();
                    builder.tab = dataRes.frs_tab_info;
                    this.hne = builder.build(true);
                } else {
                    this.hne = dataRes.nav_tab_info;
                }
                if (this.hne != null && com.baidu.tbadk.core.util.v.d(this.hne.tab, 0) != null) {
                    this.hnU = ((FrsTabInfo) com.baidu.tbadk.core.util.v.d(this.hne.tab, 0)).tab_id.intValue();
                }
                if (this.hne != null && !com.baidu.tbadk.core.util.v.I(this.hne.head)) {
                    this.hnK = this.hne.head.get(0);
                }
                this.alaLiveCount = dataRes.ala_live_count.intValue();
                vy(dataRes.frs_tab_default.intValue());
                this.hna = dataRes.twzhibo_pos.intValue();
                this.gvS = dataRes.trends_redpoint.intValue() == 1;
                c(dataRes.thread_list, longValue);
                this.hnh = dataRes.category_list;
                if (!ao.isEmpty(dataRes.bawu_enter_url)) {
                    this.hni = dataRes.bawu_enter_url;
                }
                if (dataRes.head_sdk != null) {
                    this.hnj = new com.baidu.tbadk.core.data.w();
                    this.hnj.a(dataRes.head_sdk);
                }
                if (dataRes.recommend_book != null) {
                    this.hnk = new x();
                    this.hnk.a(dataRes.recommend_book);
                }
                if (dataRes.book_info != null) {
                    this.hnm = new com.baidu.tbadk.core.data.p();
                    this.hnm.a(dataRes.book_info);
                }
                if (dataRes.forum_present_info != null) {
                    this.hno = new com.baidu.tbadk.core.data.u();
                    this.hno.a(dataRes.forum_present_info);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.hnp = new com.baidu.tbadk.core.data.r();
                    this.hnp.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.card_shipin_info != null && dataRes.card_shipin_info.size() > 0) {
                    this.hnq = new bb();
                    this.hnq.bc(true);
                    this.hnq.cV(this.hna);
                    this.hnq.setUserMap(this.userMap);
                    this.hnq.a(dataRes.card_shipin_info.get(0));
                    this.hnq.AD();
                    this.hnq.awg = this.isBrandForum;
                    if (this.hnq.getFid() == 0 && longValue != 0) {
                        this.hnq.setFid(longValue);
                    }
                    this.hnq.m(this.hnc);
                    this.hnq.bb(!this.hnq.zz());
                    if (this.hnq.zT() != null && this.hnq.zT().getPendantData() == null && (metaData = this.userMap.get(this.hnq.zT().getUserId())) != null && metaData.getPendantData() != null) {
                        com.baidu.tbadk.data.l lVar = new com.baidu.tbadk.data.l();
                        lVar.ap(metaData.getPendantData().LW());
                        lVar.es(metaData.getPendantData().yF());
                        this.hnq.zT().setPendantData(lVar);
                    }
                }
                if (dataRes.ala_live_insert != null && dataRes.ala_live_insert.ala_live_list != null && dataRes.ala_live_insert.ala_live_list.size() > 0) {
                    this.hnz = new e();
                    this.hnz.hml = dataRes.ala_insert_floor.intValue();
                    ArrayList arrayList = new ArrayList();
                    for (int i3 = 0; i3 < dataRes.ala_live_insert.ala_live_list.size(); i3++) {
                        if (dataRes.ala_live_insert.ala_live_list.get(i3) != null) {
                            bb bbVar = new bb();
                            bbVar.a(dataRes.ala_live_insert.ala_live_list.get(i3));
                            bbVar.awg = this.isBrandForum;
                            arrayList.add(bbVar);
                        }
                    }
                    this.hnz.hmk = arrayList;
                }
                if (dataRes.ala_stage_list != null) {
                    this.hnA = new f();
                    ArrayList arrayList2 = new ArrayList();
                    for (int i4 = 0; i4 < dataRes.ala_stage_list.size(); i4++) {
                        if (dataRes.ala_stage_list.get(i4) != null) {
                            bb bbVar2 = new bb();
                            bbVar2.a(dataRes.ala_stage_list.get(i4));
                            bbVar2.awg = this.isBrandForum;
                            arrayList2.add(bbVar2);
                        }
                    }
                    this.hnA.hmn = arrayList2;
                }
                if (dataRes.school_recom_info != null) {
                    this.hns = dataRes.school_recom_pos.intValue();
                    this.hnr = new at();
                    this.hnr.a(dataRes.school_recom_info);
                }
                if (dataRes.carrier_enter != null) {
                    this.hnt = new com.baidu.tbadk.core.data.l();
                    this.hnt.a(dataRes.carrier_enter);
                }
                if (dataRes.vitality_info != null && dataRes.vitality_info.frequently_forum_info != null) {
                    this.hnv = dataRes.vitality_info.frequently_forum_info.forum_state.intValue();
                    this.hnw = dataRes.vitality_info.frequently_forum_info.access_flag.intValue();
                }
                this.mSortType = dataRes.sort_type.intValue();
                this.hmQ = dataRes.need_log.intValue();
                com.baidu.tieba.recapp.d.a.bwJ().vd(dataRes.asp_shown_info);
                this.hnx = dataRes.card_shipin_pos;
                if (dataRes.card_shipin_new != null) {
                    for (int i5 = 0; i5 < dataRes.card_shipin_new.size(); i5++) {
                        bb bbVar3 = new bb();
                        if (this.hnx != null && this.hnx.size() >= dataRes.card_shipin_new.size()) {
                            bbVar3.cV(this.hnx.get(i5).intValue());
                        }
                        bbVar3.bc(true);
                        bbVar3.a(dataRes.card_shipin_new.get(i5));
                        bbVar3.awg = this.isBrandForum;
                        this.hny.add(bbVar3);
                    }
                }
                this.hnB = dataRes.enter_pop_info;
                if (dataRes.esport != null) {
                    this.hnC = new com.baidu.tieba.h.b();
                    this.hnC.a(dataRes.esport);
                }
                this.hnD = dataRes.agree_banner;
                if (dataRes.user_extend != null) {
                    this.hnI = new com.baidu.tieba.frs.q();
                    this.hnI.a(dataRes.user_extend);
                }
                this.hnE = dataRes.live_frs_notify;
                this.hnF = dataRes.frs_game_tab_info;
                this.hnG = dataRes.game_default_tab_id.intValue();
                this.hnH = dataRes.forum_head_icon;
                if (dataRes.video != null && dataRes.video.video_act != null) {
                    this.hnJ = new k();
                    this.hnJ.a(dataRes.video.video_act);
                }
                if (dataRes.info != null) {
                    this.recm_forum_list = dataRes.info.recm_forum_list;
                }
                this.dRw = dataRes.forum_ar_info;
                if (dataRes.star_rank_info != null) {
                    this.hnL = dataRes.star_rank_info;
                }
                if (dataRes.recom_post_topic != null) {
                    this.hnl = dataRes.recom_post_topic;
                }
                this.hnM = dataRes.window_toast;
                this.hnN = dataRes.activity_config;
                this.hnO = dataRes.worldcup_skin;
                this.hnS = new com.baidu.tieba.tbadkCore.data.m();
                this.hnS.a(dataRes.redpacketrain);
                this.hnT = dataRes.video_auto_play.intValue() == 1;
                this.hnV = dataRes.smart_app_avatar;
                this.hnW = dataRes.smart_app;
                this.hnX = dataRes.nebula_hot_threads;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public AgreeBanner bCL() {
        return this.hnD;
    }

    public void a(AgreeBanner agreeBanner) {
        this.hnD = agreeBanner;
    }

    public ForumHeadIcon bCM() {
        return this.hnH;
    }

    public void a(ForumHeadIcon forumHeadIcon) {
        this.hnH = forumHeadIcon;
    }

    public List<RecmForumInfo> bCN() {
        return this.recm_forum_list;
    }

    private void vy(int i) {
        this.hnf = 1;
        if (this.hne != null && this.hne.tab != null && this.hne.tab.size() > 0) {
            for (FrsTabInfo frsTabInfo : this.hne.tab) {
                if (frsTabInfo != null && frsTabInfo.tab_id.intValue() == i) {
                    this.hnf = i;
                    return;
                }
            }
        }
    }

    public void c(List<ThreadInfo> list, long j) {
        if (!com.baidu.tbadk.core.util.v.I(list)) {
            for (ThreadInfo threadInfo : list) {
                if (threadInfo != null) {
                    bb bbVar = new bb();
                    bbVar.setUserMap(this.userMap);
                    bbVar.a(threadInfo);
                    bbVar.setCurrentPage(3);
                    bbVar.AD();
                    if (bbVar.getFid() == 0 && j != 0) {
                        bbVar.setFid(j);
                    }
                    if (StringUtils.isNull(bbVar.zZ())) {
                        bbVar.ev(this.fTD.getName());
                    }
                    bbVar.m(this.hnc);
                    bbVar.awg = this.fTD.isBrandForum;
                    if (!TextUtils.isEmpty(bbVar.AN())) {
                        ab abVar = new ab();
                        abVar.eq(bbVar.AN());
                        this.threadList.add(abVar);
                    } else {
                        this.threadList.add(bbVar);
                    }
                }
            }
        }
    }

    public int bCO() {
        return this.alaLiveCount;
    }

    public void vz(int i) {
        this.alaLiveCount = i;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] Op() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public boolean F(byte[] bArr) {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void I(JSONObject jSONObject) {
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void a(Message message) {
    }

    public ForumData bhx() {
        return this.fTD;
    }

    public int bCP() {
        return this.hnv;
    }

    public void vA(int i) {
        this.hnv = i;
    }

    public int bCQ() {
        return this.hnw;
    }

    public void vB(int i) {
        this.hnw = i;
    }

    public void c(ForumData forumData) {
        this.fTD = forumData;
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> getThreadList() {
        return this.threadList;
    }

    public void ay(ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        this.threadList = arrayList;
    }

    public AntiData yR() {
        return this.asy;
    }

    public void c(AntiData antiData) {
        this.asy = antiData;
    }

    public al zf() {
        return this.fip;
    }

    public void a(al alVar) {
        this.fip = alVar;
    }

    public j bCR() {
        return this.hmS;
    }

    public void a(j jVar) {
        this.hmS = jVar;
    }

    public com.baidu.tbadk.core.data.o bCS() {
        return this.hnd;
    }

    public void a(com.baidu.tbadk.core.data.o oVar) {
        this.hnd = oVar;
    }

    public boolean bCT() {
        return this.hmT;
    }

    public void nr(boolean z) {
        this.hmT = z;
    }

    public String bCU() {
        return this.hmU;
    }

    public void vK(String str) {
        this.hmU = str;
    }

    public m bCV() {
        return this.hmV;
    }

    public void a(m mVar) {
        this.hmV = mVar;
    }

    public UserData getUserData() {
        return this.fTK;
    }

    public void e(UserData userData) {
        this.fTK = userData;
    }

    public List<Long> bCW() {
        return this.hmR;
    }

    public void dH(List<Long> list) {
        this.hmR = list;
    }

    public b bCX() {
        return this.hmW;
    }

    public void a(b bVar) {
        this.hmW = bVar;
    }

    public boolean bCY() {
        return this.hmX;
    }

    public void ns(boolean z) {
        this.hmX = z;
    }

    public String getGameName() {
        return this.gameName;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public List<g> bCZ() {
        return this.hmY;
    }

    public void dI(List<g> list) {
        this.hmY = list;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public int bhM() {
        return this.hmZ;
    }

    public void sp(int i) {
        this.hmZ = i;
    }

    public String bDa() {
        return this.hnb;
    }

    public void vL(String str) {
        this.hnb = str;
    }

    public int bDb() {
        return this.hna;
    }

    public void vC(int i) {
        this.hna = i;
    }

    public List<FeedForumData> bDc() {
        return this.hng;
    }

    public void dJ(List<FeedForumData> list) {
        this.hng = list;
    }

    public void vM(String str) {
        if (this.hng != null && str != null) {
            for (FeedForumData feedForumData : this.hng) {
                if (feedForumData != null && feedForumData.getForumId() != null && feedForumData.getForumId().equals(str)) {
                    this.hng.remove(feedForumData);
                    return;
                }
            }
        }
    }

    public List<CategoryInfo> bDd() {
        return this.hnh;
    }

    public void dK(List<CategoryInfo> list) {
        this.hnh = list;
    }

    public void vN(String str) {
        this.hni = str;
    }

    public String bDe() {
        return this.hni;
    }

    public bb bDf() {
        return this.hnq;
    }

    public void at(bb bbVar) {
        this.hnq = bbVar;
    }

    public int bDg() {
        return this.hnf;
    }

    public void vD(int i) {
        this.hnf = i;
    }

    public com.baidu.tbadk.core.data.w bDh() {
        return this.hnj;
    }

    public void a(com.baidu.tbadk.core.data.w wVar) {
        this.hnj = wVar;
    }

    public com.baidu.tbadk.core.data.p bDi() {
        return this.hnm;
    }

    public void a(com.baidu.tbadk.core.data.p pVar) {
        this.hnm = pVar;
    }

    public com.baidu.tbadk.core.data.r bDj() {
        return this.hnp;
    }

    public void a(com.baidu.tbadk.core.data.r rVar) {
        this.hnp = rVar;
    }

    public int bDk() {
        return this.hns;
    }

    public void vE(int i) {
        this.hns = i;
    }

    public at bDl() {
        return this.hnr;
    }

    public void a(at atVar) {
        this.hnr = atVar;
    }

    public NavTabInfo bDm() {
        return this.hne;
    }

    public void a(NavTabInfo navTabInfo) {
        this.hne = navTabInfo;
    }

    public boolean bDn() {
        return this.gvS;
    }

    public void nt(boolean z) {
        this.gvS = z;
    }

    public com.baidu.tbadk.core.data.l bDo() {
        return this.hnt;
    }

    public void a(com.baidu.tbadk.core.data.l lVar) {
        this.hnt = lVar;
    }

    public int acy() {
        return this.mSortType;
    }

    public Integer bDp() {
        return this.hnn;
    }

    public void q(Integer num) {
        this.hnn = num;
    }

    public List<Integer> bDq() {
        return this.hnx;
    }

    public void dL(List<Integer> list) {
        this.hnx = list;
    }

    public List<com.baidu.adp.widget.ListView.h> bDr() {
        return this.hny;
    }

    public void dM(List<com.baidu.adp.widget.ListView.h> list) {
        this.hny = list;
    }

    public com.baidu.tieba.h.b bDs() {
        return this.hnC;
    }

    public void a(com.baidu.tieba.h.b bVar) {
        this.hnC = bVar;
    }

    public AlaLiveNotify bDt() {
        return this.hnE;
    }

    public void a(AlaLiveNotify alaLiveNotify) {
        this.hnE = alaLiveNotify;
    }

    public List<FrsTabInfo> bDu() {
        return this.hnF;
    }

    public void dN(List<FrsTabInfo> list) {
        this.hnF = list;
    }

    public void vF(int i) {
        this.hnG = i;
    }

    public int bDv() {
        return this.hnG;
    }

    public void a(com.baidu.tieba.frs.q qVar) {
        this.hnI = qVar;
    }

    public com.baidu.tieba.frs.q bDw() {
        return this.hnI;
    }

    public k bDx() {
        return this.hnJ;
    }

    public void a(k kVar) {
        this.hnJ = kVar;
    }

    public e bDy() {
        return this.hnz;
    }

    public void b(e eVar) {
        this.hnz = eVar;
    }

    public f bDz() {
        return this.hnA;
    }

    public void b(f fVar) {
        this.hnA = fVar;
    }

    public WorldcupSkin bDA() {
        return this.hnO;
    }

    public com.baidu.tieba.tbadkCore.data.m bDB() {
        return this.hnS;
    }

    public void d(com.baidu.tieba.tbadkCore.data.m mVar) {
        this.hnS = mVar;
    }
}

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
    private AntiData asx;
    public ForumArIno dRv;
    protected ForumData fTC;
    private UserData fTJ;
    protected al fio;
    private String gameName;
    protected List<Long> hmQ;
    private j hmR;
    protected boolean hmS;
    protected String hmT;
    protected m hmU;
    private b hmV;
    private boolean hmW;
    private int hmZ;
    public PopInfo hnA;
    private com.baidu.tieba.h.b hnB;
    private AgreeBanner hnC;
    private AlaLiveNotify hnD;
    private List<FrsTabInfo> hnE;
    private ForumHeadIcon hnG;
    private com.baidu.tieba.frs.q hnH;
    private k hnI;
    public FrsTabInfo hnJ;
    public StarRank hnK;
    public List<WindowToast> hnL;
    public ActivityConfig hnM;
    private WorldcupSkin hnN;
    public com.baidu.tieba.frs.b hnO;
    public List<OriForumInfo> hnP;
    public List<BottomMenu> hnQ;
    private com.baidu.tieba.tbadkCore.data.m hnR;
    public boolean hnS;
    public List<String> hnU;
    public SmartApp hnV;
    public NebulaHotThreads hnW;
    private String hna;
    private NavTabInfo hnd;
    private List<FeedForumData> hnf;
    private List<CategoryInfo> hng;
    private bb hnp;
    private at hnq;
    private com.baidu.tbadk.core.data.l hns;
    private List<Integer> hnw;
    private List<com.baidu.adp.widget.ListView.h> hnx;
    private e hny;
    private f hnz;
    public boolean isBrandForum;
    private int mSortType;
    public List<RecmForumInfo> recm_forum_list;
    protected ArrayList<com.baidu.adp.widget.ListView.h> threadList;
    private HashMap<String, MetaData> userMap;
    public int hmP = 0;
    private List<g> hmX = new ArrayList();
    private int hmY = 0;
    private ArrayList<com.baidu.tbadk.core.data.n> hnb = new ArrayList<>();
    protected com.baidu.tbadk.core.data.o hnc = null;
    private int hne = 1;
    private boolean gvR = false;
    private String hnh = null;
    private com.baidu.tbadk.core.data.w hni = null;
    public x hnj = null;
    public RecomPostTopic hnk = null;
    private com.baidu.tbadk.core.data.p hnl = null;
    private Integer hnm = -1;
    public com.baidu.tbadk.core.data.u hnn = null;
    private com.baidu.tbadk.core.data.r hno = null;
    private int hnr = -1;
    protected List<com.baidu.adp.widget.ListView.h> hnt = null;
    private int hnu = 0;
    private int hnv = 0;
    private int alaLiveCount = 0;
    private int hnF = 0;
    public int dSz = 0;
    public int hnT = 1;

    public i() {
        initData();
    }

    private void initData() {
        this.fTC = new ForumData();
        this.threadList = new ArrayList<>();
        this.hnt = new ArrayList();
        this.userMap = new HashMap<>();
        this.fio = new al();
        this.hmR = new j();
        this.fTJ = new UserData();
        this.hmU = new m();
        c(new AntiData());
        a(new b());
        this.hnx = new ArrayList();
        this.hnw = new ArrayList();
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
                                this.hnb.add(nVar);
                            }
                        }
                    }
                }
                if (dataRes.forum != null) {
                    this.hmW = dataRes.forum.has_game.intValue() == 1;
                    this.hna = dataRes.forum.game_url;
                    this.gameName = dataRes.forum.game_name;
                    this.isBrandForum = dataRes.forum.is_brand_forum.intValue() == 1;
                }
                if (this.isBrandForum && dataRes.brand_forum_info != null) {
                    this.hnc = new com.baidu.tbadk.core.data.o();
                    this.hnc.a(dataRes.brand_forum_info.head_imgs);
                    this.hnO = new com.baidu.tieba.frs.b();
                    this.hnO.a(dataRes.brand_forum_info);
                    if (!com.baidu.tbadk.core.util.v.I(dataRes.brand_forum_info.relation_forum)) {
                        this.hnP = new ArrayList();
                        for (OriForumInfo oriForumInfo : dataRes.brand_forum_info.relation_forum) {
                            if (oriForumInfo != null) {
                                this.hnP.add(oriForumInfo);
                            }
                        }
                    }
                } else if (dataRes.activityhead != null && !com.baidu.tbadk.core.util.v.I(dataRes.activityhead.head_imgs)) {
                    this.hnc = new com.baidu.tbadk.core.data.o();
                    this.hnc.a(dataRes.activityhead);
                }
                this.hnQ = dataRes.bottom_menu;
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
                this.hmS = dataRes.fortune_bag.intValue() == 1;
                this.hmT = dataRes.fortune_desc;
                List<StarEnter> list2 = dataRes.star_enter;
                this.hmX.clear();
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        g gVar = new g();
                        gVar.a(list2.get(i2));
                        this.hmX.add(gVar);
                    }
                }
                this.hmU.a(dataRes.gcon_account);
                this.fTC.parserProtobuf(dataRes.forum);
                long longValue = dataRes.forum != null ? dataRes.forum.id.longValue() : 0L;
                this.hmQ = dataRes.thread_id_list;
                this.asx.parserProtobuf(dataRes.anti);
                if (dataRes.anti != null) {
                    com.baidu.tieba.ueg.c.e(dataRes.anti.block_pop_info);
                }
                this.hmV.a(dataRes.group);
                this.fio.a(dataRes.page);
                this.hmR.a(dataRes.frs_star);
                this.fTJ.parserProtobuf(dataRes.user);
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.fTJ.getIsSelectTail());
                }
                if (dataRes.nav_tab_info == null) {
                    NavTabInfo.Builder builder = new NavTabInfo.Builder();
                    builder.tab = dataRes.frs_tab_info;
                    this.hnd = builder.build(true);
                } else {
                    this.hnd = dataRes.nav_tab_info;
                }
                if (this.hnd != null && com.baidu.tbadk.core.util.v.d(this.hnd.tab, 0) != null) {
                    this.hnT = ((FrsTabInfo) com.baidu.tbadk.core.util.v.d(this.hnd.tab, 0)).tab_id.intValue();
                }
                if (this.hnd != null && !com.baidu.tbadk.core.util.v.I(this.hnd.head)) {
                    this.hnJ = this.hnd.head.get(0);
                }
                this.alaLiveCount = dataRes.ala_live_count.intValue();
                vy(dataRes.frs_tab_default.intValue());
                this.hmZ = dataRes.twzhibo_pos.intValue();
                this.gvR = dataRes.trends_redpoint.intValue() == 1;
                c(dataRes.thread_list, longValue);
                this.hng = dataRes.category_list;
                if (!ao.isEmpty(dataRes.bawu_enter_url)) {
                    this.hnh = dataRes.bawu_enter_url;
                }
                if (dataRes.head_sdk != null) {
                    this.hni = new com.baidu.tbadk.core.data.w();
                    this.hni.a(dataRes.head_sdk);
                }
                if (dataRes.recommend_book != null) {
                    this.hnj = new x();
                    this.hnj.a(dataRes.recommend_book);
                }
                if (dataRes.book_info != null) {
                    this.hnl = new com.baidu.tbadk.core.data.p();
                    this.hnl.a(dataRes.book_info);
                }
                if (dataRes.forum_present_info != null) {
                    this.hnn = new com.baidu.tbadk.core.data.u();
                    this.hnn.a(dataRes.forum_present_info);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.hno = new com.baidu.tbadk.core.data.r();
                    this.hno.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.card_shipin_info != null && dataRes.card_shipin_info.size() > 0) {
                    this.hnp = new bb();
                    this.hnp.bc(true);
                    this.hnp.cV(this.hmZ);
                    this.hnp.setUserMap(this.userMap);
                    this.hnp.a(dataRes.card_shipin_info.get(0));
                    this.hnp.AD();
                    this.hnp.awf = this.isBrandForum;
                    if (this.hnp.getFid() == 0 && longValue != 0) {
                        this.hnp.setFid(longValue);
                    }
                    this.hnp.m(this.hnb);
                    this.hnp.bb(!this.hnp.zz());
                    if (this.hnp.zT() != null && this.hnp.zT().getPendantData() == null && (metaData = this.userMap.get(this.hnp.zT().getUserId())) != null && metaData.getPendantData() != null) {
                        com.baidu.tbadk.data.l lVar = new com.baidu.tbadk.data.l();
                        lVar.ap(metaData.getPendantData().LW());
                        lVar.es(metaData.getPendantData().yF());
                        this.hnp.zT().setPendantData(lVar);
                    }
                }
                if (dataRes.ala_live_insert != null && dataRes.ala_live_insert.ala_live_list != null && dataRes.ala_live_insert.ala_live_list.size() > 0) {
                    this.hny = new e();
                    this.hny.hmk = dataRes.ala_insert_floor.intValue();
                    ArrayList arrayList = new ArrayList();
                    for (int i3 = 0; i3 < dataRes.ala_live_insert.ala_live_list.size(); i3++) {
                        if (dataRes.ala_live_insert.ala_live_list.get(i3) != null) {
                            bb bbVar = new bb();
                            bbVar.a(dataRes.ala_live_insert.ala_live_list.get(i3));
                            bbVar.awf = this.isBrandForum;
                            arrayList.add(bbVar);
                        }
                    }
                    this.hny.hmj = arrayList;
                }
                if (dataRes.ala_stage_list != null) {
                    this.hnz = new f();
                    ArrayList arrayList2 = new ArrayList();
                    for (int i4 = 0; i4 < dataRes.ala_stage_list.size(); i4++) {
                        if (dataRes.ala_stage_list.get(i4) != null) {
                            bb bbVar2 = new bb();
                            bbVar2.a(dataRes.ala_stage_list.get(i4));
                            bbVar2.awf = this.isBrandForum;
                            arrayList2.add(bbVar2);
                        }
                    }
                    this.hnz.hmm = arrayList2;
                }
                if (dataRes.school_recom_info != null) {
                    this.hnr = dataRes.school_recom_pos.intValue();
                    this.hnq = new at();
                    this.hnq.a(dataRes.school_recom_info);
                }
                if (dataRes.carrier_enter != null) {
                    this.hns = new com.baidu.tbadk.core.data.l();
                    this.hns.a(dataRes.carrier_enter);
                }
                if (dataRes.vitality_info != null && dataRes.vitality_info.frequently_forum_info != null) {
                    this.hnu = dataRes.vitality_info.frequently_forum_info.forum_state.intValue();
                    this.hnv = dataRes.vitality_info.frequently_forum_info.access_flag.intValue();
                }
                this.mSortType = dataRes.sort_type.intValue();
                this.hmP = dataRes.need_log.intValue();
                com.baidu.tieba.recapp.d.a.bwJ().vd(dataRes.asp_shown_info);
                this.hnw = dataRes.card_shipin_pos;
                if (dataRes.card_shipin_new != null) {
                    for (int i5 = 0; i5 < dataRes.card_shipin_new.size(); i5++) {
                        bb bbVar3 = new bb();
                        if (this.hnw != null && this.hnw.size() >= dataRes.card_shipin_new.size()) {
                            bbVar3.cV(this.hnw.get(i5).intValue());
                        }
                        bbVar3.bc(true);
                        bbVar3.a(dataRes.card_shipin_new.get(i5));
                        bbVar3.awf = this.isBrandForum;
                        this.hnx.add(bbVar3);
                    }
                }
                this.hnA = dataRes.enter_pop_info;
                if (dataRes.esport != null) {
                    this.hnB = new com.baidu.tieba.h.b();
                    this.hnB.a(dataRes.esport);
                }
                this.hnC = dataRes.agree_banner;
                if (dataRes.user_extend != null) {
                    this.hnH = new com.baidu.tieba.frs.q();
                    this.hnH.a(dataRes.user_extend);
                }
                this.hnD = dataRes.live_frs_notify;
                this.hnE = dataRes.frs_game_tab_info;
                this.hnF = dataRes.game_default_tab_id.intValue();
                this.hnG = dataRes.forum_head_icon;
                if (dataRes.video != null && dataRes.video.video_act != null) {
                    this.hnI = new k();
                    this.hnI.a(dataRes.video.video_act);
                }
                if (dataRes.info != null) {
                    this.recm_forum_list = dataRes.info.recm_forum_list;
                }
                this.dRv = dataRes.forum_ar_info;
                if (dataRes.star_rank_info != null) {
                    this.hnK = dataRes.star_rank_info;
                }
                if (dataRes.recom_post_topic != null) {
                    this.hnk = dataRes.recom_post_topic;
                }
                this.hnL = dataRes.window_toast;
                this.hnM = dataRes.activity_config;
                this.hnN = dataRes.worldcup_skin;
                this.hnR = new com.baidu.tieba.tbadkCore.data.m();
                this.hnR.a(dataRes.redpacketrain);
                this.hnS = dataRes.video_auto_play.intValue() == 1;
                this.hnU = dataRes.smart_app_avatar;
                this.hnV = dataRes.smart_app;
                this.hnW = dataRes.nebula_hot_threads;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public AgreeBanner bCL() {
        return this.hnC;
    }

    public void a(AgreeBanner agreeBanner) {
        this.hnC = agreeBanner;
    }

    public ForumHeadIcon bCM() {
        return this.hnG;
    }

    public void a(ForumHeadIcon forumHeadIcon) {
        this.hnG = forumHeadIcon;
    }

    public List<RecmForumInfo> bCN() {
        return this.recm_forum_list;
    }

    private void vy(int i) {
        this.hne = 1;
        if (this.hnd != null && this.hnd.tab != null && this.hnd.tab.size() > 0) {
            for (FrsTabInfo frsTabInfo : this.hnd.tab) {
                if (frsTabInfo != null && frsTabInfo.tab_id.intValue() == i) {
                    this.hne = i;
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
                        bbVar.ev(this.fTC.getName());
                    }
                    bbVar.m(this.hnb);
                    bbVar.awf = this.fTC.isBrandForum;
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
        return this.fTC;
    }

    public int bCP() {
        return this.hnu;
    }

    public void vA(int i) {
        this.hnu = i;
    }

    public int bCQ() {
        return this.hnv;
    }

    public void vB(int i) {
        this.hnv = i;
    }

    public void c(ForumData forumData) {
        this.fTC = forumData;
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> getThreadList() {
        return this.threadList;
    }

    public void ay(ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        this.threadList = arrayList;
    }

    public AntiData yR() {
        return this.asx;
    }

    public void c(AntiData antiData) {
        this.asx = antiData;
    }

    public al zf() {
        return this.fio;
    }

    public void a(al alVar) {
        this.fio = alVar;
    }

    public j bCR() {
        return this.hmR;
    }

    public void a(j jVar) {
        this.hmR = jVar;
    }

    public com.baidu.tbadk.core.data.o bCS() {
        return this.hnc;
    }

    public void a(com.baidu.tbadk.core.data.o oVar) {
        this.hnc = oVar;
    }

    public boolean bCT() {
        return this.hmS;
    }

    public void nr(boolean z) {
        this.hmS = z;
    }

    public String bCU() {
        return this.hmT;
    }

    public void vK(String str) {
        this.hmT = str;
    }

    public m bCV() {
        return this.hmU;
    }

    public void a(m mVar) {
        this.hmU = mVar;
    }

    public UserData getUserData() {
        return this.fTJ;
    }

    public void e(UserData userData) {
        this.fTJ = userData;
    }

    public List<Long> bCW() {
        return this.hmQ;
    }

    public void dH(List<Long> list) {
        this.hmQ = list;
    }

    public b bCX() {
        return this.hmV;
    }

    public void a(b bVar) {
        this.hmV = bVar;
    }

    public boolean bCY() {
        return this.hmW;
    }

    public void ns(boolean z) {
        this.hmW = z;
    }

    public String getGameName() {
        return this.gameName;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public List<g> bCZ() {
        return this.hmX;
    }

    public void dI(List<g> list) {
        this.hmX = list;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public int bhM() {
        return this.hmY;
    }

    public void sp(int i) {
        this.hmY = i;
    }

    public String bDa() {
        return this.hna;
    }

    public void vL(String str) {
        this.hna = str;
    }

    public int bDb() {
        return this.hmZ;
    }

    public void vC(int i) {
        this.hmZ = i;
    }

    public List<FeedForumData> bDc() {
        return this.hnf;
    }

    public void dJ(List<FeedForumData> list) {
        this.hnf = list;
    }

    public void vM(String str) {
        if (this.hnf != null && str != null) {
            for (FeedForumData feedForumData : this.hnf) {
                if (feedForumData != null && feedForumData.getForumId() != null && feedForumData.getForumId().equals(str)) {
                    this.hnf.remove(feedForumData);
                    return;
                }
            }
        }
    }

    public List<CategoryInfo> bDd() {
        return this.hng;
    }

    public void dK(List<CategoryInfo> list) {
        this.hng = list;
    }

    public void vN(String str) {
        this.hnh = str;
    }

    public String bDe() {
        return this.hnh;
    }

    public bb bDf() {
        return this.hnp;
    }

    public void at(bb bbVar) {
        this.hnp = bbVar;
    }

    public int bDg() {
        return this.hne;
    }

    public void vD(int i) {
        this.hne = i;
    }

    public com.baidu.tbadk.core.data.w bDh() {
        return this.hni;
    }

    public void a(com.baidu.tbadk.core.data.w wVar) {
        this.hni = wVar;
    }

    public com.baidu.tbadk.core.data.p bDi() {
        return this.hnl;
    }

    public void a(com.baidu.tbadk.core.data.p pVar) {
        this.hnl = pVar;
    }

    public com.baidu.tbadk.core.data.r bDj() {
        return this.hno;
    }

    public void a(com.baidu.tbadk.core.data.r rVar) {
        this.hno = rVar;
    }

    public int bDk() {
        return this.hnr;
    }

    public void vE(int i) {
        this.hnr = i;
    }

    public at bDl() {
        return this.hnq;
    }

    public void a(at atVar) {
        this.hnq = atVar;
    }

    public NavTabInfo bDm() {
        return this.hnd;
    }

    public void a(NavTabInfo navTabInfo) {
        this.hnd = navTabInfo;
    }

    public boolean bDn() {
        return this.gvR;
    }

    public void nt(boolean z) {
        this.gvR = z;
    }

    public com.baidu.tbadk.core.data.l bDo() {
        return this.hns;
    }

    public void a(com.baidu.tbadk.core.data.l lVar) {
        this.hns = lVar;
    }

    public int acy() {
        return this.mSortType;
    }

    public Integer bDp() {
        return this.hnm;
    }

    public void q(Integer num) {
        this.hnm = num;
    }

    public List<Integer> bDq() {
        return this.hnw;
    }

    public void dL(List<Integer> list) {
        this.hnw = list;
    }

    public List<com.baidu.adp.widget.ListView.h> bDr() {
        return this.hnx;
    }

    public void dM(List<com.baidu.adp.widget.ListView.h> list) {
        this.hnx = list;
    }

    public com.baidu.tieba.h.b bDs() {
        return this.hnB;
    }

    public void a(com.baidu.tieba.h.b bVar) {
        this.hnB = bVar;
    }

    public AlaLiveNotify bDt() {
        return this.hnD;
    }

    public void a(AlaLiveNotify alaLiveNotify) {
        this.hnD = alaLiveNotify;
    }

    public List<FrsTabInfo> bDu() {
        return this.hnE;
    }

    public void dN(List<FrsTabInfo> list) {
        this.hnE = list;
    }

    public void vF(int i) {
        this.hnF = i;
    }

    public int bDv() {
        return this.hnF;
    }

    public void a(com.baidu.tieba.frs.q qVar) {
        this.hnH = qVar;
    }

    public com.baidu.tieba.frs.q bDw() {
        return this.hnH;
    }

    public k bDx() {
        return this.hnI;
    }

    public void a(k kVar) {
        this.hnI = kVar;
    }

    public e bDy() {
        return this.hny;
    }

    public void b(e eVar) {
        this.hny = eVar;
    }

    public f bDz() {
        return this.hnz;
    }

    public void b(f fVar) {
        this.hnz = fVar;
    }

    public WorldcupSkin bDA() {
        return this.hnN;
    }

    public com.baidu.tieba.tbadkCore.data.m bDB() {
        return this.hnR;
    }

    public void d(com.baidu.tieba.tbadkCore.data.m mVar) {
        this.hnR = mVar;
    }
}

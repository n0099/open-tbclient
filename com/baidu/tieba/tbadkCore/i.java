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
/* loaded from: classes2.dex */
public class i implements com.baidu.tbadk.mvc.b.c {
    public static final Wire WIRE = new Wire(new Class[0]);
    private AntiData aiM;
    public ForumArIno dyj;
    protected al eOS;
    private UserData fAd;
    protected ForumData fzW;
    protected List<Long> gSO;
    private j gSP;
    protected boolean gSQ;
    protected String gSR;
    protected m gSS;
    private b gST;
    private boolean gSU;
    private int gSX;
    private String gSY;
    private AgreeBanner gTA;
    private AlaLiveNotify gTB;
    private List<FrsTabInfo> gTC;
    private ForumHeadIcon gTE;
    private com.baidu.tieba.frs.q gTF;
    private k gTG;
    public FrsTabInfo gTH;
    public StarRank gTI;
    public List<WindowToast> gTJ;
    public ActivityConfig gTK;
    private WorldcupSkin gTL;
    public com.baidu.tieba.frs.b gTM;
    public List<OriForumInfo> gTN;
    public List<BottomMenu> gTO;
    private com.baidu.tieba.tbadkCore.data.m gTP;
    public boolean gTQ;
    public List<String> gTS;
    public SmartApp gTT;
    private NavTabInfo gTb;
    private List<FeedForumData> gTd;
    private List<CategoryInfo> gTe;
    private bb gTn;
    private at gTo;
    private com.baidu.tbadk.core.data.l gTq;
    private List<Integer> gTu;
    private List<com.baidu.adp.widget.ListView.h> gTv;
    private e gTw;
    private f gTx;
    public PopInfo gTy;
    private com.baidu.tieba.h.b gTz;
    private String gameName;
    public boolean isBrandForum;
    private int mSortType;
    public List<RecmForumInfo> recm_forum_list;
    protected ArrayList<com.baidu.adp.widget.ListView.h> threadList;
    private HashMap<String, MetaData> userMap;
    public int gSN = 0;
    private List<g> gSV = new ArrayList();
    private int gSW = 0;
    private ArrayList<com.baidu.tbadk.core.data.n> gSZ = new ArrayList<>();
    protected com.baidu.tbadk.core.data.o gTa = null;
    private int gTc = 1;
    private boolean gce = false;
    private String gTf = null;
    private com.baidu.tbadk.core.data.w gTg = null;
    public x gTh = null;
    public RecomPostTopic gTi = null;
    private com.baidu.tbadk.core.data.p gTj = null;
    private Integer gTk = -1;
    public com.baidu.tbadk.core.data.u gTl = null;
    private com.baidu.tbadk.core.data.r gTm = null;
    private int gTp = -1;
    protected List<com.baidu.adp.widget.ListView.h> gTr = null;
    private int gTs = 0;
    private int gTt = 0;
    private int alaLiveCount = 0;
    private int gTD = 0;
    public int dzx = 0;
    public int gTR = 1;

    public i() {
        initData();
    }

    private void initData() {
        this.fzW = new ForumData();
        this.threadList = new ArrayList<>();
        this.gTr = new ArrayList();
        this.userMap = new HashMap<>();
        this.eOS = new al();
        this.gSP = new j();
        this.fAd = new UserData();
        this.gSS = new m();
        c(new AntiData());
        a(new b());
        this.gTv = new ArrayList();
        this.gTu = new ArrayList();
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
                if (!com.baidu.tbadk.core.util.v.z(dataRes.color_egg)) {
                    for (ColorEgg colorEgg : dataRes.color_egg) {
                        if (colorEgg != null && !com.baidu.tbadk.core.util.v.z(colorEgg.holiday_words)) {
                            com.baidu.tbadk.core.data.n nVar = new com.baidu.tbadk.core.data.n();
                            if (nVar.a(colorEgg)) {
                                this.gSZ.add(nVar);
                            }
                        }
                    }
                }
                if (dataRes.forum != null) {
                    this.gSU = dataRes.forum.has_game.intValue() == 1;
                    this.gSY = dataRes.forum.game_url;
                    this.gameName = dataRes.forum.game_name;
                    this.isBrandForum = dataRes.forum.is_brand_forum.intValue() == 1;
                }
                if (this.isBrandForum && dataRes.brand_forum_info != null) {
                    this.gTa = new com.baidu.tbadk.core.data.o();
                    this.gTa.a(dataRes.brand_forum_info.head_imgs);
                    this.gTM = new com.baidu.tieba.frs.b();
                    this.gTM.a(dataRes.brand_forum_info);
                    if (!com.baidu.tbadk.core.util.v.z(dataRes.brand_forum_info.relation_forum)) {
                        this.gTN = new ArrayList();
                        for (OriForumInfo oriForumInfo : dataRes.brand_forum_info.relation_forum) {
                            if (oriForumInfo != null) {
                                this.gTN.add(oriForumInfo);
                            }
                        }
                    }
                } else if (dataRes.activityhead != null && !com.baidu.tbadk.core.util.v.z(dataRes.activityhead.head_imgs)) {
                    this.gTa = new com.baidu.tbadk.core.data.o();
                    this.gTa.a(dataRes.activityhead);
                }
                this.gTO = dataRes.bottom_menu;
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
                qN(dataRes.is_new_url.intValue());
                this.gSQ = dataRes.fortune_bag.intValue() == 1;
                this.gSR = dataRes.fortune_desc;
                List<StarEnter> list2 = dataRes.star_enter;
                this.gSV.clear();
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        g gVar = new g();
                        gVar.a(list2.get(i2));
                        this.gSV.add(gVar);
                    }
                }
                this.gSS.a(dataRes.gcon_account);
                this.fzW.parserProtobuf(dataRes.forum);
                long longValue = dataRes.forum != null ? dataRes.forum.id.longValue() : 0L;
                this.gSO = dataRes.thread_id_list;
                this.aiM.parserProtobuf(dataRes.anti);
                if (dataRes.anti != null) {
                    com.baidu.tieba.ueg.c.e(dataRes.anti.block_pop_info);
                }
                this.gST.a(dataRes.group);
                this.eOS.a(dataRes.page);
                this.gSP.a(dataRes.frs_star);
                this.fAd.parserProtobuf(dataRes.user);
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.fAd.getIsSelectTail());
                }
                if (dataRes.nav_tab_info == null) {
                    NavTabInfo.Builder builder = new NavTabInfo.Builder();
                    builder.tab = dataRes.frs_tab_info;
                    this.gTb = builder.build(true);
                } else {
                    this.gTb = dataRes.nav_tab_info;
                }
                if (this.gTb != null && com.baidu.tbadk.core.util.v.d(this.gTb.tab, 0) != null) {
                    this.gTR = ((FrsTabInfo) com.baidu.tbadk.core.util.v.d(this.gTb.tab, 0)).tab_id.intValue();
                }
                if (this.gTb != null && !com.baidu.tbadk.core.util.v.z(this.gTb.head)) {
                    this.gTH = this.gTb.head.get(0);
                }
                this.alaLiveCount = dataRes.ala_live_count.intValue();
                tW(dataRes.frs_tab_default.intValue());
                this.gSX = dataRes.twzhibo_pos.intValue();
                this.gce = dataRes.trends_redpoint.intValue() == 1;
                c(dataRes.thread_list, longValue);
                this.gTe = dataRes.category_list;
                if (!ao.isEmpty(dataRes.bawu_enter_url)) {
                    this.gTf = dataRes.bawu_enter_url;
                }
                if (dataRes.head_sdk != null) {
                    this.gTg = new com.baidu.tbadk.core.data.w();
                    this.gTg.a(dataRes.head_sdk);
                }
                if (dataRes.recommend_book != null) {
                    this.gTh = new x();
                    this.gTh.a(dataRes.recommend_book);
                }
                if (dataRes.book_info != null) {
                    this.gTj = new com.baidu.tbadk.core.data.p();
                    this.gTj.a(dataRes.book_info);
                }
                if (dataRes.forum_present_info != null) {
                    this.gTl = new com.baidu.tbadk.core.data.u();
                    this.gTl.a(dataRes.forum_present_info);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.gTm = new com.baidu.tbadk.core.data.r();
                    this.gTm.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.card_shipin_info != null && dataRes.card_shipin_info.size() > 0) {
                    this.gTn = new bb();
                    this.gTn.aA(true);
                    this.gTn.ci(this.gSX);
                    this.gTn.setUserMap(this.userMap);
                    this.gTn.a(dataRes.card_shipin_info.get(0));
                    this.gTn.wW();
                    this.gTn.amv = this.isBrandForum;
                    if (this.gTn.getFid() == 0 && longValue != 0) {
                        this.gTn.setFid(longValue);
                    }
                    this.gTn.m(this.gSZ);
                    this.gTn.az(!this.gTn.vS());
                    if (this.gTn.wm() != null && this.gTn.wm().getPendantData() == null && (metaData = this.userMap.get(this.gTn.wm().getUserId())) != null && metaData.getPendantData() != null) {
                        com.baidu.tbadk.data.j jVar = new com.baidu.tbadk.data.j();
                        jVar.ad(metaData.getPendantData().Ip());
                        jVar.dB(metaData.getPendantData().uW());
                        this.gTn.wm().setPendantData(jVar);
                    }
                }
                if (dataRes.ala_live_insert != null && dataRes.ala_live_insert.ala_live_list != null && dataRes.ala_live_insert.ala_live_list.size() > 0) {
                    this.gTw = new e();
                    this.gTw.gSi = dataRes.ala_insert_floor.intValue();
                    ArrayList arrayList = new ArrayList();
                    for (int i3 = 0; i3 < dataRes.ala_live_insert.ala_live_list.size(); i3++) {
                        if (dataRes.ala_live_insert.ala_live_list.get(i3) != null) {
                            bb bbVar = new bb();
                            bbVar.a(dataRes.ala_live_insert.ala_live_list.get(i3));
                            bbVar.amv = this.isBrandForum;
                            arrayList.add(bbVar);
                        }
                    }
                    this.gTw.gSh = arrayList;
                }
                if (dataRes.ala_stage_list != null) {
                    this.gTx = new f();
                    ArrayList arrayList2 = new ArrayList();
                    for (int i4 = 0; i4 < dataRes.ala_stage_list.size(); i4++) {
                        if (dataRes.ala_stage_list.get(i4) != null) {
                            bb bbVar2 = new bb();
                            bbVar2.a(dataRes.ala_stage_list.get(i4));
                            bbVar2.amv = this.isBrandForum;
                            arrayList2.add(bbVar2);
                        }
                    }
                    this.gTx.gSk = arrayList2;
                }
                if (dataRes.school_recom_info != null) {
                    this.gTp = dataRes.school_recom_pos.intValue();
                    this.gTo = new at();
                    this.gTo.a(dataRes.school_recom_info);
                }
                if (dataRes.carrier_enter != null) {
                    this.gTq = new com.baidu.tbadk.core.data.l();
                    this.gTq.a(dataRes.carrier_enter);
                }
                if (dataRes.vitality_info != null && dataRes.vitality_info.frequently_forum_info != null) {
                    this.gTs = dataRes.vitality_info.frequently_forum_info.forum_state.intValue();
                    this.gTt = dataRes.vitality_info.frequently_forum_info.access_flag.intValue();
                }
                this.mSortType = dataRes.sort_type.intValue();
                this.gSN = dataRes.need_log.intValue();
                com.baidu.tieba.recapp.d.a.bqL().tD(dataRes.asp_shown_info);
                this.gTu = dataRes.card_shipin_pos;
                if (dataRes.card_shipin_new != null) {
                    for (int i5 = 0; i5 < dataRes.card_shipin_new.size(); i5++) {
                        bb bbVar3 = new bb();
                        if (this.gTu != null && this.gTu.size() >= dataRes.card_shipin_new.size()) {
                            bbVar3.ci(this.gTu.get(i5).intValue());
                        }
                        bbVar3.aA(true);
                        bbVar3.a(dataRes.card_shipin_new.get(i5));
                        bbVar3.amv = this.isBrandForum;
                        this.gTv.add(bbVar3);
                    }
                }
                this.gTy = dataRes.enter_pop_info;
                if (dataRes.esport != null) {
                    this.gTz = new com.baidu.tieba.h.b();
                    this.gTz.a(dataRes.esport);
                }
                this.gTA = dataRes.agree_banner;
                if (dataRes.user_extend != null) {
                    this.gTF = new com.baidu.tieba.frs.q();
                    this.gTF.a(dataRes.user_extend);
                }
                this.gTB = dataRes.live_frs_notify;
                this.gTC = dataRes.frs_game_tab_info;
                this.gTD = dataRes.game_default_tab_id.intValue();
                this.gTE = dataRes.forum_head_icon;
                if (dataRes.video != null && dataRes.video.video_act != null) {
                    this.gTG = new k();
                    this.gTG.a(dataRes.video.video_act);
                }
                if (dataRes.info != null) {
                    this.recm_forum_list = dataRes.info.recm_forum_list;
                }
                this.dyj = dataRes.forum_ar_info;
                if (dataRes.star_rank_info != null) {
                    this.gTI = dataRes.star_rank_info;
                }
                if (dataRes.recom_post_topic != null) {
                    this.gTi = dataRes.recom_post_topic;
                }
                this.gTJ = dataRes.window_toast;
                this.gTK = dataRes.activity_config;
                this.gTL = dataRes.worldcup_skin;
                this.gTP = new com.baidu.tieba.tbadkCore.data.m();
                this.gTP.a(dataRes.redpacketrain);
                this.gTQ = dataRes.video_auto_play.intValue() == 1;
                this.gTS = dataRes.smart_app_avatar;
                this.gTT = dataRes.smart_app;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public AgreeBanner bwG() {
        return this.gTA;
    }

    public void a(AgreeBanner agreeBanner) {
        this.gTA = agreeBanner;
    }

    public ForumHeadIcon bwH() {
        return this.gTE;
    }

    public void a(ForumHeadIcon forumHeadIcon) {
        this.gTE = forumHeadIcon;
    }

    public List<RecmForumInfo> bwI() {
        return this.recm_forum_list;
    }

    private void tW(int i) {
        this.gTc = 1;
        if (this.gTb != null && this.gTb.tab != null && this.gTb.tab.size() > 0) {
            for (FrsTabInfo frsTabInfo : this.gTb.tab) {
                if (frsTabInfo != null && frsTabInfo.tab_id.intValue() == i) {
                    this.gTc = i;
                    return;
                }
            }
        }
    }

    public void c(List<ThreadInfo> list, long j) {
        if (!com.baidu.tbadk.core.util.v.z(list)) {
            for (ThreadInfo threadInfo : list) {
                if (threadInfo != null) {
                    bb bbVar = new bb();
                    bbVar.setUserMap(this.userMap);
                    bbVar.a(threadInfo);
                    bbVar.cj(3);
                    bbVar.wW();
                    if (bbVar.getFid() == 0 && j != 0) {
                        bbVar.setFid(j);
                    }
                    if (StringUtils.isNull(bbVar.ws())) {
                        bbVar.dE(this.fzW.getName());
                    }
                    bbVar.m(this.gSZ);
                    bbVar.amv = this.fzW.isBrandForum;
                    if (!TextUtils.isEmpty(bbVar.xg())) {
                        ab abVar = new ab();
                        abVar.dz(bbVar.xg());
                        this.threadList.add(abVar);
                    } else {
                        this.threadList.add(bbVar);
                    }
                }
            }
        }
    }

    public int bwJ() {
        return this.alaLiveCount;
    }

    public void tX(int i) {
        this.alaLiveCount = i;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] KM() {
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
    public void E(JSONObject jSONObject) {
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void a(Message message) {
    }

    public ForumData bbH() {
        return this.fzW;
    }

    public int bwK() {
        return this.gTs;
    }

    public void tY(int i) {
        this.gTs = i;
    }

    public int bwL() {
        return this.gTt;
    }

    public void tZ(int i) {
        this.gTt = i;
    }

    public void c(ForumData forumData) {
        this.fzW = forumData;
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> getThreadList() {
        return this.threadList;
    }

    public void ay(ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        this.threadList = arrayList;
    }

    public AntiData vj() {
        return this.aiM;
    }

    public void c(AntiData antiData) {
        this.aiM = antiData;
    }

    public al vy() {
        return this.eOS;
    }

    public void a(al alVar) {
        this.eOS = alVar;
    }

    public j bwM() {
        return this.gSP;
    }

    public void a(j jVar) {
        this.gSP = jVar;
    }

    public com.baidu.tbadk.core.data.o bwN() {
        return this.gTa;
    }

    public void a(com.baidu.tbadk.core.data.o oVar) {
        this.gTa = oVar;
    }

    public boolean bwO() {
        return this.gSQ;
    }

    public void mJ(boolean z) {
        this.gSQ = z;
    }

    public String bwP() {
        return this.gSR;
    }

    public void uk(String str) {
        this.gSR = str;
    }

    public m bwQ() {
        return this.gSS;
    }

    public void a(m mVar) {
        this.gSS = mVar;
    }

    public UserData getUserData() {
        return this.fAd;
    }

    public void e(UserData userData) {
        this.fAd = userData;
    }

    public List<Long> bwR() {
        return this.gSO;
    }

    public void dp(List<Long> list) {
        this.gSO = list;
    }

    public b bwS() {
        return this.gST;
    }

    public void a(b bVar) {
        this.gST = bVar;
    }

    public boolean bwT() {
        return this.gSU;
    }

    public void mK(boolean z) {
        this.gSU = z;
    }

    public String getGameName() {
        return this.gameName;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public List<g> bwU() {
        return this.gSV;
    }

    public void dq(List<g> list) {
        this.gSV = list;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public int bbW() {
        return this.gSW;
    }

    public void qN(int i) {
        this.gSW = i;
    }

    public String bwV() {
        return this.gSY;
    }

    public void ul(String str) {
        this.gSY = str;
    }

    public int bwW() {
        return this.gSX;
    }

    public void ua(int i) {
        this.gSX = i;
    }

    public List<FeedForumData> bwX() {
        return this.gTd;
    }

    public void dr(List<FeedForumData> list) {
        this.gTd = list;
    }

    public void um(String str) {
        if (this.gTd != null && str != null) {
            for (FeedForumData feedForumData : this.gTd) {
                if (feedForumData != null && feedForumData.getForumId() != null && feedForumData.getForumId().equals(str)) {
                    this.gTd.remove(feedForumData);
                    return;
                }
            }
        }
    }

    public List<CategoryInfo> bwY() {
        return this.gTe;
    }

    public void ds(List<CategoryInfo> list) {
        this.gTe = list;
    }

    public void un(String str) {
        this.gTf = str;
    }

    public String bwZ() {
        return this.gTf;
    }

    public bb bxa() {
        return this.gTn;
    }

    public void at(bb bbVar) {
        this.gTn = bbVar;
    }

    public int bxb() {
        return this.gTc;
    }

    public void ub(int i) {
        this.gTc = i;
    }

    public com.baidu.tbadk.core.data.w bxc() {
        return this.gTg;
    }

    public void a(com.baidu.tbadk.core.data.w wVar) {
        this.gTg = wVar;
    }

    public com.baidu.tbadk.core.data.p bxd() {
        return this.gTj;
    }

    public void a(com.baidu.tbadk.core.data.p pVar) {
        this.gTj = pVar;
    }

    public com.baidu.tbadk.core.data.r bxe() {
        return this.gTm;
    }

    public void a(com.baidu.tbadk.core.data.r rVar) {
        this.gTm = rVar;
    }

    public int bxf() {
        return this.gTp;
    }

    public void uc(int i) {
        this.gTp = i;
    }

    public at bxg() {
        return this.gTo;
    }

    public void a(at atVar) {
        this.gTo = atVar;
    }

    public NavTabInfo bxh() {
        return this.gTb;
    }

    public void a(NavTabInfo navTabInfo) {
        this.gTb = navTabInfo;
    }

    public boolean bxi() {
        return this.gce;
    }

    public void mL(boolean z) {
        this.gce = z;
    }

    public com.baidu.tbadk.core.data.l bxj() {
        return this.gTq;
    }

    public void a(com.baidu.tbadk.core.data.l lVar) {
        this.gTq = lVar;
    }

    public int Xb() {
        return this.mSortType;
    }

    public Integer bxk() {
        return this.gTk;
    }

    public void q(Integer num) {
        this.gTk = num;
    }

    public List<Integer> bxl() {
        return this.gTu;
    }

    public void dt(List<Integer> list) {
        this.gTu = list;
    }

    public List<com.baidu.adp.widget.ListView.h> bxm() {
        return this.gTv;
    }

    public void du(List<com.baidu.adp.widget.ListView.h> list) {
        this.gTv = list;
    }

    public com.baidu.tieba.h.b bxn() {
        return this.gTz;
    }

    public void a(com.baidu.tieba.h.b bVar) {
        this.gTz = bVar;
    }

    public AlaLiveNotify bxo() {
        return this.gTB;
    }

    public void a(AlaLiveNotify alaLiveNotify) {
        this.gTB = alaLiveNotify;
    }

    public List<FrsTabInfo> bxp() {
        return this.gTC;
    }

    public void dv(List<FrsTabInfo> list) {
        this.gTC = list;
    }

    public void ud(int i) {
        this.gTD = i;
    }

    public int bxq() {
        return this.gTD;
    }

    public void a(com.baidu.tieba.frs.q qVar) {
        this.gTF = qVar;
    }

    public com.baidu.tieba.frs.q bxr() {
        return this.gTF;
    }

    public k bxs() {
        return this.gTG;
    }

    public void a(k kVar) {
        this.gTG = kVar;
    }

    public e bxt() {
        return this.gTw;
    }

    public void b(e eVar) {
        this.gTw = eVar;
    }

    public f bxu() {
        return this.gTx;
    }

    public void b(f fVar) {
        this.gTx = fVar;
    }

    public WorldcupSkin bxv() {
        return this.gTL;
    }

    public com.baidu.tieba.tbadkCore.data.m bxw() {
        return this.gTP;
    }

    public void d(com.baidu.tieba.tbadkCore.data.m mVar) {
        this.gTP = mVar;
    }
}

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
    private AntiData aou;
    public ForumArIno dHz;
    protected al eXT;
    protected ForumData fIX;
    private UserData fJe;
    private String gameName;
    protected List<Long> hbH;
    private j hbI;
    protected boolean hbJ;
    protected String hbK;
    protected m hbL;
    private b hbM;
    private boolean hbN;
    private int hbQ;
    private String hbR;
    private NavTabInfo hbU;
    private List<FeedForumData> hbW;
    private List<CategoryInfo> hbX;
    public FrsTabInfo hcA;
    public StarRank hcB;
    public List<WindowToast> hcC;
    public ActivityConfig hcD;
    private WorldcupSkin hcE;
    public com.baidu.tieba.frs.b hcF;
    public List<OriForumInfo> hcG;
    public List<BottomMenu> hcH;
    private com.baidu.tieba.tbadkCore.data.m hcI;
    public boolean hcJ;
    public List<String> hcL;
    public SmartApp hcM;
    private bb hcg;
    private at hch;
    private com.baidu.tbadk.core.data.l hcj;
    private List<Integer> hcn;
    private List<com.baidu.adp.widget.ListView.h> hco;
    private e hcp;
    private f hcq;
    public PopInfo hcr;
    private com.baidu.tieba.h.b hcs;
    private AgreeBanner hct;
    private AlaLiveNotify hcu;
    private List<FrsTabInfo> hcv;
    private ForumHeadIcon hcx;
    private com.baidu.tieba.frs.q hcy;
    private k hcz;
    public boolean isBrandForum;
    private int mSortType;
    public List<RecmForumInfo> recm_forum_list;
    protected ArrayList<com.baidu.adp.widget.ListView.h> threadList;
    private HashMap<String, MetaData> userMap;
    public int hbG = 0;
    private List<g> hbO = new ArrayList();
    private int hbP = 0;
    private ArrayList<com.baidu.tbadk.core.data.n> hbS = new ArrayList<>();
    protected com.baidu.tbadk.core.data.o hbT = null;
    private int hbV = 1;
    private boolean glg = false;
    private String hbY = null;
    private com.baidu.tbadk.core.data.w hbZ = null;
    public x hca = null;
    public RecomPostTopic hcb = null;
    private com.baidu.tbadk.core.data.p hcc = null;
    private Integer hcd = -1;
    public com.baidu.tbadk.core.data.u hce = null;
    private com.baidu.tbadk.core.data.r hcf = null;
    private int hci = -1;
    protected List<com.baidu.adp.widget.ListView.h> hck = null;
    private int hcl = 0;
    private int hcm = 0;
    private int alaLiveCount = 0;
    private int hcw = 0;
    public int dID = 0;
    public int hcK = 1;

    public i() {
        initData();
    }

    private void initData() {
        this.fIX = new ForumData();
        this.threadList = new ArrayList<>();
        this.hck = new ArrayList();
        this.userMap = new HashMap<>();
        this.eXT = new al();
        this.hbI = new j();
        this.fJe = new UserData();
        this.hbL = new m();
        c(new AntiData());
        a(new b());
        this.hco = new ArrayList();
        this.hcn = new ArrayList();
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
                                this.hbS.add(nVar);
                            }
                        }
                    }
                }
                if (dataRes.forum != null) {
                    this.hbN = dataRes.forum.has_game.intValue() == 1;
                    this.hbR = dataRes.forum.game_url;
                    this.gameName = dataRes.forum.game_name;
                    this.isBrandForum = dataRes.forum.is_brand_forum.intValue() == 1;
                }
                if (this.isBrandForum && dataRes.brand_forum_info != null) {
                    this.hbT = new com.baidu.tbadk.core.data.o();
                    this.hbT.a(dataRes.brand_forum_info.head_imgs);
                    this.hcF = new com.baidu.tieba.frs.b();
                    this.hcF.a(dataRes.brand_forum_info);
                    if (!com.baidu.tbadk.core.util.v.I(dataRes.brand_forum_info.relation_forum)) {
                        this.hcG = new ArrayList();
                        for (OriForumInfo oriForumInfo : dataRes.brand_forum_info.relation_forum) {
                            if (oriForumInfo != null) {
                                this.hcG.add(oriForumInfo);
                            }
                        }
                    }
                } else if (dataRes.activityhead != null && !com.baidu.tbadk.core.util.v.I(dataRes.activityhead.head_imgs)) {
                    this.hbT = new com.baidu.tbadk.core.data.o();
                    this.hbT.a(dataRes.activityhead);
                }
                this.hcH = dataRes.bottom_menu;
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
                rE(dataRes.is_new_url.intValue());
                this.hbJ = dataRes.fortune_bag.intValue() == 1;
                this.hbK = dataRes.fortune_desc;
                List<StarEnter> list2 = dataRes.star_enter;
                this.hbO.clear();
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        g gVar = new g();
                        gVar.a(list2.get(i2));
                        this.hbO.add(gVar);
                    }
                }
                this.hbL.a(dataRes.gcon_account);
                this.fIX.parserProtobuf(dataRes.forum);
                long longValue = dataRes.forum != null ? dataRes.forum.id.longValue() : 0L;
                this.hbH = dataRes.thread_id_list;
                this.aou.parserProtobuf(dataRes.anti);
                if (dataRes.anti != null) {
                    com.baidu.tieba.ueg.c.e(dataRes.anti.block_pop_info);
                }
                this.hbM.a(dataRes.group);
                this.eXT.a(dataRes.page);
                this.hbI.a(dataRes.frs_star);
                this.fJe.parserProtobuf(dataRes.user);
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.fJe.getIsSelectTail());
                }
                if (dataRes.nav_tab_info == null) {
                    NavTabInfo.Builder builder = new NavTabInfo.Builder();
                    builder.tab = dataRes.frs_tab_info;
                    this.hbU = builder.build(true);
                } else {
                    this.hbU = dataRes.nav_tab_info;
                }
                if (this.hbU != null && com.baidu.tbadk.core.util.v.d(this.hbU.tab, 0) != null) {
                    this.hcK = ((FrsTabInfo) com.baidu.tbadk.core.util.v.d(this.hbU.tab, 0)).tab_id.intValue();
                }
                if (this.hbU != null && !com.baidu.tbadk.core.util.v.I(this.hbU.head)) {
                    this.hcA = this.hbU.head.get(0);
                }
                this.alaLiveCount = dataRes.ala_live_count.intValue();
                uM(dataRes.frs_tab_default.intValue());
                this.hbQ = dataRes.twzhibo_pos.intValue();
                this.glg = dataRes.trends_redpoint.intValue() == 1;
                c(dataRes.thread_list, longValue);
                this.hbX = dataRes.category_list;
                if (!ao.isEmpty(dataRes.bawu_enter_url)) {
                    this.hbY = dataRes.bawu_enter_url;
                }
                if (dataRes.head_sdk != null) {
                    this.hbZ = new com.baidu.tbadk.core.data.w();
                    this.hbZ.a(dataRes.head_sdk);
                }
                if (dataRes.recommend_book != null) {
                    this.hca = new x();
                    this.hca.a(dataRes.recommend_book);
                }
                if (dataRes.book_info != null) {
                    this.hcc = new com.baidu.tbadk.core.data.p();
                    this.hcc.a(dataRes.book_info);
                }
                if (dataRes.forum_present_info != null) {
                    this.hce = new com.baidu.tbadk.core.data.u();
                    this.hce.a(dataRes.forum_present_info);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.hcf = new com.baidu.tbadk.core.data.r();
                    this.hcf.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.card_shipin_info != null && dataRes.card_shipin_info.size() > 0) {
                    this.hcg = new bb();
                    this.hcg.ba(true);
                    this.hcg.cH(this.hbQ);
                    this.hcg.setUserMap(this.userMap);
                    this.hcg.a(dataRes.card_shipin_info.get(0));
                    this.hcg.zm();
                    this.hcg.asd = this.isBrandForum;
                    if (this.hcg.getFid() == 0 && longValue != 0) {
                        this.hcg.setFid(longValue);
                    }
                    this.hcg.m(this.hbS);
                    this.hcg.aZ(!this.hcg.yi());
                    if (this.hcg.yC() != null && this.hcg.yC().getPendantData() == null && (metaData = this.userMap.get(this.hcg.yC().getUserId())) != null && metaData.getPendantData() != null) {
                        com.baidu.tbadk.data.j jVar = new com.baidu.tbadk.data.j();
                        jVar.ah(metaData.getPendantData().KA());
                        jVar.dR(metaData.getPendantData().xn());
                        this.hcg.yC().setPendantData(jVar);
                    }
                }
                if (dataRes.ala_live_insert != null && dataRes.ala_live_insert.ala_live_list != null && dataRes.ala_live_insert.ala_live_list.size() > 0) {
                    this.hcp = new e();
                    this.hcp.hbc = dataRes.ala_insert_floor.intValue();
                    ArrayList arrayList = new ArrayList();
                    for (int i3 = 0; i3 < dataRes.ala_live_insert.ala_live_list.size(); i3++) {
                        if (dataRes.ala_live_insert.ala_live_list.get(i3) != null) {
                            bb bbVar = new bb();
                            bbVar.a(dataRes.ala_live_insert.ala_live_list.get(i3));
                            bbVar.asd = this.isBrandForum;
                            arrayList.add(bbVar);
                        }
                    }
                    this.hcp.hbb = arrayList;
                }
                if (dataRes.ala_stage_list != null) {
                    this.hcq = new f();
                    ArrayList arrayList2 = new ArrayList();
                    for (int i4 = 0; i4 < dataRes.ala_stage_list.size(); i4++) {
                        if (dataRes.ala_stage_list.get(i4) != null) {
                            bb bbVar2 = new bb();
                            bbVar2.a(dataRes.ala_stage_list.get(i4));
                            bbVar2.asd = this.isBrandForum;
                            arrayList2.add(bbVar2);
                        }
                    }
                    this.hcq.hbe = arrayList2;
                }
                if (dataRes.school_recom_info != null) {
                    this.hci = dataRes.school_recom_pos.intValue();
                    this.hch = new at();
                    this.hch.a(dataRes.school_recom_info);
                }
                if (dataRes.carrier_enter != null) {
                    this.hcj = new com.baidu.tbadk.core.data.l();
                    this.hcj.a(dataRes.carrier_enter);
                }
                if (dataRes.vitality_info != null && dataRes.vitality_info.frequently_forum_info != null) {
                    this.hcl = dataRes.vitality_info.frequently_forum_info.forum_state.intValue();
                    this.hcm = dataRes.vitality_info.frequently_forum_info.access_flag.intValue();
                }
                this.mSortType = dataRes.sort_type.intValue();
                this.hbG = dataRes.need_log.intValue();
                com.baidu.tieba.recapp.d.a.btw().uj(dataRes.asp_shown_info);
                this.hcn = dataRes.card_shipin_pos;
                if (dataRes.card_shipin_new != null) {
                    for (int i5 = 0; i5 < dataRes.card_shipin_new.size(); i5++) {
                        bb bbVar3 = new bb();
                        if (this.hcn != null && this.hcn.size() >= dataRes.card_shipin_new.size()) {
                            bbVar3.cH(this.hcn.get(i5).intValue());
                        }
                        bbVar3.ba(true);
                        bbVar3.a(dataRes.card_shipin_new.get(i5));
                        bbVar3.asd = this.isBrandForum;
                        this.hco.add(bbVar3);
                    }
                }
                this.hcr = dataRes.enter_pop_info;
                if (dataRes.esport != null) {
                    this.hcs = new com.baidu.tieba.h.b();
                    this.hcs.a(dataRes.esport);
                }
                this.hct = dataRes.agree_banner;
                if (dataRes.user_extend != null) {
                    this.hcy = new com.baidu.tieba.frs.q();
                    this.hcy.a(dataRes.user_extend);
                }
                this.hcu = dataRes.live_frs_notify;
                this.hcv = dataRes.frs_game_tab_info;
                this.hcw = dataRes.game_default_tab_id.intValue();
                this.hcx = dataRes.forum_head_icon;
                if (dataRes.video != null && dataRes.video.video_act != null) {
                    this.hcz = new k();
                    this.hcz.a(dataRes.video.video_act);
                }
                if (dataRes.info != null) {
                    this.recm_forum_list = dataRes.info.recm_forum_list;
                }
                this.dHz = dataRes.forum_ar_info;
                if (dataRes.star_rank_info != null) {
                    this.hcB = dataRes.star_rank_info;
                }
                if (dataRes.recom_post_topic != null) {
                    this.hcb = dataRes.recom_post_topic;
                }
                this.hcC = dataRes.window_toast;
                this.hcD = dataRes.activity_config;
                this.hcE = dataRes.worldcup_skin;
                this.hcI = new com.baidu.tieba.tbadkCore.data.m();
                this.hcI.a(dataRes.redpacketrain);
                this.hcJ = dataRes.video_auto_play.intValue() == 1;
                this.hcL = dataRes.smart_app_avatar;
                this.hcM = dataRes.smart_app;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public AgreeBanner bzr() {
        return this.hct;
    }

    public void a(AgreeBanner agreeBanner) {
        this.hct = agreeBanner;
    }

    public ForumHeadIcon bzs() {
        return this.hcx;
    }

    public void a(ForumHeadIcon forumHeadIcon) {
        this.hcx = forumHeadIcon;
    }

    public List<RecmForumInfo> bzt() {
        return this.recm_forum_list;
    }

    private void uM(int i) {
        this.hbV = 1;
        if (this.hbU != null && this.hbU.tab != null && this.hbU.tab.size() > 0) {
            for (FrsTabInfo frsTabInfo : this.hbU.tab) {
                if (frsTabInfo != null && frsTabInfo.tab_id.intValue() == i) {
                    this.hbV = i;
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
                    bbVar.zm();
                    if (bbVar.getFid() == 0 && j != 0) {
                        bbVar.setFid(j);
                    }
                    if (StringUtils.isNull(bbVar.yI())) {
                        bbVar.dU(this.fIX.getName());
                    }
                    bbVar.m(this.hbS);
                    bbVar.asd = this.fIX.isBrandForum;
                    if (!TextUtils.isEmpty(bbVar.zw())) {
                        ab abVar = new ab();
                        abVar.dP(bbVar.zw());
                        this.threadList.add(abVar);
                    } else {
                        this.threadList.add(bbVar);
                    }
                }
            }
        }
    }

    public int bzu() {
        return this.alaLiveCount;
    }

    public void uN(int i) {
        this.alaLiveCount = i;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] MT() {
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
    public void H(JSONObject jSONObject) {
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void a(Message message) {
    }

    public ForumData ber() {
        return this.fIX;
    }

    public int bzv() {
        return this.hcl;
    }

    public void uO(int i) {
        this.hcl = i;
    }

    public int bzw() {
        return this.hcm;
    }

    public void uP(int i) {
        this.hcm = i;
    }

    public void c(ForumData forumData) {
        this.fIX = forumData;
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> getThreadList() {
        return this.threadList;
    }

    public void ax(ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        this.threadList = arrayList;
    }

    public AntiData xA() {
        return this.aou;
    }

    public void c(AntiData antiData) {
        this.aou = antiData;
    }

    public al xO() {
        return this.eXT;
    }

    public void a(al alVar) {
        this.eXT = alVar;
    }

    public j bzx() {
        return this.hbI;
    }

    public void a(j jVar) {
        this.hbI = jVar;
    }

    public com.baidu.tbadk.core.data.o bzy() {
        return this.hbT;
    }

    public void a(com.baidu.tbadk.core.data.o oVar) {
        this.hbT = oVar;
    }

    public boolean bzz() {
        return this.hbJ;
    }

    public void nl(boolean z) {
        this.hbJ = z;
    }

    public String bzA() {
        return this.hbK;
    }

    public void uQ(String str) {
        this.hbK = str;
    }

    public m bzB() {
        return this.hbL;
    }

    public void a(m mVar) {
        this.hbL = mVar;
    }

    public UserData getUserData() {
        return this.fJe;
    }

    public void e(UserData userData) {
        this.fJe = userData;
    }

    public List<Long> bzC() {
        return this.hbH;
    }

    public void dB(List<Long> list) {
        this.hbH = list;
    }

    public b bzD() {
        return this.hbM;
    }

    public void a(b bVar) {
        this.hbM = bVar;
    }

    public boolean bzE() {
        return this.hbN;
    }

    public void nm(boolean z) {
        this.hbN = z;
    }

    public String getGameName() {
        return this.gameName;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public List<g> bzF() {
        return this.hbO;
    }

    public void dC(List<g> list) {
        this.hbO = list;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public int beG() {
        return this.hbP;
    }

    public void rE(int i) {
        this.hbP = i;
    }

    public String bzG() {
        return this.hbR;
    }

    public void uR(String str) {
        this.hbR = str;
    }

    public int bzH() {
        return this.hbQ;
    }

    public void uQ(int i) {
        this.hbQ = i;
    }

    public List<FeedForumData> bzI() {
        return this.hbW;
    }

    public void dD(List<FeedForumData> list) {
        this.hbW = list;
    }

    public void uS(String str) {
        if (this.hbW != null && str != null) {
            for (FeedForumData feedForumData : this.hbW) {
                if (feedForumData != null && feedForumData.getForumId() != null && feedForumData.getForumId().equals(str)) {
                    this.hbW.remove(feedForumData);
                    return;
                }
            }
        }
    }

    public List<CategoryInfo> bzJ() {
        return this.hbX;
    }

    public void dE(List<CategoryInfo> list) {
        this.hbX = list;
    }

    public void uT(String str) {
        this.hbY = str;
    }

    public String bzK() {
        return this.hbY;
    }

    public bb bzL() {
        return this.hcg;
    }

    public void at(bb bbVar) {
        this.hcg = bbVar;
    }

    public int bzM() {
        return this.hbV;
    }

    public void uR(int i) {
        this.hbV = i;
    }

    public com.baidu.tbadk.core.data.w bzN() {
        return this.hbZ;
    }

    public void a(com.baidu.tbadk.core.data.w wVar) {
        this.hbZ = wVar;
    }

    public com.baidu.tbadk.core.data.p bzO() {
        return this.hcc;
    }

    public void a(com.baidu.tbadk.core.data.p pVar) {
        this.hcc = pVar;
    }

    public com.baidu.tbadk.core.data.r bzP() {
        return this.hcf;
    }

    public void a(com.baidu.tbadk.core.data.r rVar) {
        this.hcf = rVar;
    }

    public int bzQ() {
        return this.hci;
    }

    public void uS(int i) {
        this.hci = i;
    }

    public at bzR() {
        return this.hch;
    }

    public void a(at atVar) {
        this.hch = atVar;
    }

    public NavTabInfo bzS() {
        return this.hbU;
    }

    public void a(NavTabInfo navTabInfo) {
        this.hbU = navTabInfo;
    }

    public boolean bzT() {
        return this.glg;
    }

    public void nn(boolean z) {
        this.glg = z;
    }

    public com.baidu.tbadk.core.data.l bzU() {
        return this.hcj;
    }

    public void a(com.baidu.tbadk.core.data.l lVar) {
        this.hcj = lVar;
    }

    public int aaT() {
        return this.mSortType;
    }

    public Integer bzV() {
        return this.hcd;
    }

    public void q(Integer num) {
        this.hcd = num;
    }

    public List<Integer> bzW() {
        return this.hcn;
    }

    public void dF(List<Integer> list) {
        this.hcn = list;
    }

    public List<com.baidu.adp.widget.ListView.h> bzX() {
        return this.hco;
    }

    public void dG(List<com.baidu.adp.widget.ListView.h> list) {
        this.hco = list;
    }

    public com.baidu.tieba.h.b bzY() {
        return this.hcs;
    }

    public void a(com.baidu.tieba.h.b bVar) {
        this.hcs = bVar;
    }

    public AlaLiveNotify bzZ() {
        return this.hcu;
    }

    public void a(AlaLiveNotify alaLiveNotify) {
        this.hcu = alaLiveNotify;
    }

    public List<FrsTabInfo> bAa() {
        return this.hcv;
    }

    public void dH(List<FrsTabInfo> list) {
        this.hcv = list;
    }

    public void uT(int i) {
        this.hcw = i;
    }

    public int bAb() {
        return this.hcw;
    }

    public void a(com.baidu.tieba.frs.q qVar) {
        this.hcy = qVar;
    }

    public com.baidu.tieba.frs.q bAc() {
        return this.hcy;
    }

    public k bAd() {
        return this.hcz;
    }

    public void a(k kVar) {
        this.hcz = kVar;
    }

    public e bAe() {
        return this.hcp;
    }

    public void b(e eVar) {
        this.hcp = eVar;
    }

    public f bAf() {
        return this.hcq;
    }

    public void b(f fVar) {
        this.hcq = fVar;
    }

    public WorldcupSkin bAg() {
        return this.hcE;
    }

    public com.baidu.tieba.tbadkCore.data.m bAh() {
        return this.hcI;
    }

    public void d(com.baidu.tieba.tbadkCore.data.m mVar) {
        this.hcI = mVar;
    }
}

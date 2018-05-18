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
import com.baidu.tbadk.core.data.ac;
import com.baidu.tbadk.core.data.am;
import com.baidu.tbadk.core.data.au;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.x;
import com.baidu.tbadk.core.data.y;
import com.baidu.tbadk.core.util.an;
import com.squareup.wire.Message;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;
import tbclient.AlaLiveNotify;
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
import tbclient.FrsTabInfo;
import tbclient.PopInfo;
import tbclient.ThreadInfo;
import tbclient.User;
import tbclient.WindowToast;
/* loaded from: classes2.dex */
public class i implements com.baidu.tbadk.mvc.b.c {
    public static final Wire WIRE = new Wire(new Class[0]);
    private AntiData YB;
    public ForumArIno ddj;
    protected am eoG;
    protected ForumData fcS;
    private UserData fcZ;
    private String gameName;
    protected List<Long> guU;
    private j guV;
    protected boolean guW;
    protected String guX;
    protected m guY;
    private b guZ;
    private List<Integer> gvB;
    private List<com.baidu.adp.widget.ListView.h> gvC;
    private e gvD;
    private f gvE;
    public PopInfo gvF;
    private com.baidu.tieba.h.b gvG;
    private AgreeBanner gvH;
    private AlaLiveNotify gvI;
    private List<FrsTabInfo> gvJ;
    private ForumHeadIcon gvL;
    private com.baidu.tieba.frs.o gvM;
    private k gvN;
    public FrsTabInfo gvO;
    public StarRank gvP;
    public List<WindowToast> gvQ;
    public ActivityConfig gvR;
    private boolean gva;
    private int gvd;
    private String gve;
    private List<FrsTabInfo> gvh;
    private NavTabInfo gvi;
    private List<FeedForumData> gvk;
    private List<CategoryInfo> gvl;
    private bd gvu;
    private au gvv;
    private com.baidu.tbadk.core.data.m gvx;
    private int mSortType;
    public List<RecmForumInfo> recm_forum_list;
    protected ArrayList<com.baidu.adp.widget.ListView.h> threadList;
    private HashMap<String, MetaData> userMap;
    public int guT = 0;
    private List<g> gvb = new ArrayList();
    private int gvc = 0;
    private ArrayList<com.baidu.tbadk.core.data.o> gvf = new ArrayList<>();
    protected com.baidu.tbadk.core.data.p gvg = null;
    private int gvj = 1;
    private boolean fFm = false;
    private String gvm = null;
    private x gvn = null;
    public y gvo = null;
    public RecomPostTopic gvp = null;
    private com.baidu.tbadk.core.data.q gvq = null;
    private Integer gvr = -1;
    public com.baidu.tbadk.core.data.v gvs = null;
    private com.baidu.tbadk.core.data.s gvt = null;
    private int gvw = -1;
    protected List<com.baidu.adp.widget.ListView.h> gvy = null;
    private int gvz = 0;
    private int gvA = 0;
    private int alaLiveCount = 0;
    private int gvK = 0;
    public int ddI = 0;

    public i() {
        initData();
    }

    private void initData() {
        this.fcS = new ForumData();
        this.threadList = new ArrayList<>();
        this.gvy = new ArrayList();
        this.userMap = new HashMap<>();
        this.eoG = new am();
        this.guV = new j();
        this.fcZ = new UserData();
        this.guY = new m();
        c(new AntiData());
        a(new b());
        this.gvC = new ArrayList();
        this.gvB = new ArrayList();
    }

    public FrsPageResIdl E(byte[] bArr) {
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
                if (!com.baidu.tbadk.core.util.v.w(dataRes.color_egg)) {
                    for (ColorEgg colorEgg : dataRes.color_egg) {
                        if (colorEgg != null && !com.baidu.tbadk.core.util.v.w(colorEgg.holiday_words)) {
                            com.baidu.tbadk.core.data.o oVar = new com.baidu.tbadk.core.data.o();
                            if (oVar.a(colorEgg)) {
                                this.gvf.add(oVar);
                            }
                        }
                    }
                }
                if (dataRes.activityhead != null && !com.baidu.tbadk.core.util.v.w(dataRes.activityhead.head_imgs)) {
                    this.gvg = new com.baidu.tbadk.core.data.p();
                    this.gvg.a(dataRes.activityhead);
                }
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
                pT(dataRes.is_new_url.intValue());
                this.guW = dataRes.fortune_bag.intValue() == 1;
                this.guX = dataRes.fortune_desc;
                if (dataRes.forum != null) {
                    this.gva = dataRes.forum.has_game.intValue() == 1;
                    this.gve = dataRes.forum.game_url;
                    this.gameName = dataRes.forum.game_name;
                }
                List<StarEnter> list2 = dataRes.star_enter;
                this.gvb.clear();
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        g gVar = new g();
                        gVar.a(list2.get(i2));
                        this.gvb.add(gVar);
                    }
                }
                this.guY.a(dataRes.gcon_account);
                this.fcS.parserProtobuf(dataRes.forum);
                long longValue = dataRes.forum != null ? dataRes.forum.id.longValue() : 0L;
                this.guU = dataRes.thread_id_list;
                this.YB.parserProtobuf(dataRes.anti);
                if (dataRes.anti != null) {
                    com.baidu.tieba.q.a.e(dataRes.anti.block_pop_info);
                }
                this.guZ.a(dataRes.group);
                this.eoG.a(dataRes.page);
                this.guV.a(dataRes.frs_star);
                this.fcZ.parserProtobuf(dataRes.user);
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.fcZ.getIsSelectTail());
                }
                this.gvh = dataRes.frs_tab_info;
                if (dataRes.nav_tab_info == null) {
                    NavTabInfo.Builder builder = new NavTabInfo.Builder();
                    builder.tab = dataRes.frs_tab_info;
                    this.gvi = builder.build(true);
                } else {
                    this.gvi = dataRes.nav_tab_info;
                }
                if (this.gvi.head != null && !com.baidu.tbadk.core.util.v.w(this.gvi.head)) {
                    this.gvO = this.gvi.head.get(0);
                }
                this.alaLiveCount = dataRes.ala_live_count.intValue();
                ta(dataRes.frs_tab_default.intValue());
                this.gvd = dataRes.twzhibo_pos.intValue();
                this.fFm = dataRes.trends_redpoint.intValue() == 1;
                a(dataRes.thread_list, longValue);
                this.gvl = dataRes.category_list;
                if (!an.isEmpty(dataRes.bawu_enter_url)) {
                    this.gvm = dataRes.bawu_enter_url;
                }
                if (dataRes.head_sdk != null) {
                    this.gvn = new x();
                    this.gvn.a(dataRes.head_sdk);
                }
                if (dataRes.recommend_book != null) {
                    this.gvo = new y();
                    this.gvo.a(dataRes.recommend_book);
                }
                if (dataRes.book_info != null) {
                    this.gvq = new com.baidu.tbadk.core.data.q();
                    this.gvq.a(dataRes.book_info);
                }
                if (dataRes.forum_present_info != null) {
                    this.gvs = new com.baidu.tbadk.core.data.v();
                    this.gvs.a(dataRes.forum_present_info);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.gvt = new com.baidu.tbadk.core.data.s();
                    this.gvt.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.card_shipin_info != null && dataRes.card_shipin_info.size() > 0) {
                    this.gvu = new bd();
                    this.gvu.ap(true);
                    this.gvu.bU(this.gvd);
                    this.gvu.setUserMap(this.userMap);
                    this.gvu.a(dataRes.card_shipin_info.get(0));
                    this.gvu.sw();
                    if (this.gvu.getFid() == 0 && longValue != 0) {
                        this.gvu.setFid(longValue);
                    }
                    this.gvu.i(this.gvf);
                    this.gvu.ao(!this.gvu.ry());
                    if (this.gvu.rP() != null && this.gvu.rP().getPendantData() == null && (metaData = this.userMap.get(this.gvu.rP().getUserId())) != null && metaData.getPendantData() != null) {
                        com.baidu.tbadk.data.h hVar = new com.baidu.tbadk.data.h();
                        hVar.T(metaData.getPendantData().Di());
                        hVar.cL(metaData.getPendantData().qF());
                        this.gvu.rP().setPendantData(hVar);
                    }
                }
                if (dataRes.ala_live_insert != null && dataRes.ala_live_insert.ala_live_list != null && dataRes.ala_live_insert.ala_live_list.size() > 0) {
                    this.gvD = new e();
                    this.gvD.gus = dataRes.ala_insert_floor.intValue();
                    ArrayList arrayList = new ArrayList();
                    for (int i3 = 0; i3 < dataRes.ala_live_insert.ala_live_list.size(); i3++) {
                        if (dataRes.ala_live_insert.ala_live_list.get(i3) != null) {
                            bd bdVar = new bd();
                            bdVar.a(dataRes.ala_live_insert.ala_live_list.get(i3));
                            arrayList.add(bdVar);
                        }
                    }
                    this.gvD.gur = arrayList;
                }
                if (dataRes.ala_stage_list != null) {
                    this.gvE = new f();
                    ArrayList arrayList2 = new ArrayList();
                    for (int i4 = 0; i4 < dataRes.ala_stage_list.size(); i4++) {
                        if (dataRes.ala_stage_list.get(i4) != null) {
                            bd bdVar2 = new bd();
                            bdVar2.a(dataRes.ala_stage_list.get(i4));
                            arrayList2.add(bdVar2);
                        }
                    }
                    this.gvE.guu = arrayList2;
                }
                if (dataRes.school_recom_info != null) {
                    this.gvw = dataRes.school_recom_pos.intValue();
                    this.gvv = new au();
                    this.gvv.a(dataRes.school_recom_info);
                }
                if (dataRes.carrier_enter != null) {
                    this.gvx = new com.baidu.tbadk.core.data.m();
                    this.gvx.a(dataRes.carrier_enter);
                }
                if (dataRes.vitality_info != null && dataRes.vitality_info.frequently_forum_info != null) {
                    this.gvz = dataRes.vitality_info.frequently_forum_info.forum_state.intValue();
                    this.gvA = dataRes.vitality_info.frequently_forum_info.access_flag.intValue();
                }
                this.mSortType = dataRes.sort_type.intValue();
                this.guT = dataRes.need_log.intValue();
                com.baidu.tieba.recapp.d.a.bjY().sf(dataRes.asp_shown_info);
                this.gvB = dataRes.card_shipin_pos;
                if (dataRes.card_shipin_new != null) {
                    for (int i5 = 0; i5 < dataRes.card_shipin_new.size(); i5++) {
                        bd bdVar3 = new bd();
                        if (this.gvB != null && this.gvB.size() >= dataRes.card_shipin_new.size()) {
                            bdVar3.bU(this.gvB.get(i5).intValue());
                        }
                        bdVar3.ap(true);
                        bdVar3.a(dataRes.card_shipin_new.get(i5));
                        this.gvC.add(bdVar3);
                    }
                }
                this.gvF = dataRes.enter_pop_info;
                if (dataRes.esport != null) {
                    this.gvG = new com.baidu.tieba.h.b();
                    this.gvG.a(dataRes.esport);
                }
                this.gvH = dataRes.agree_banner;
                if (dataRes.user_extend != null) {
                    this.gvM = new com.baidu.tieba.frs.o();
                    this.gvM.a(dataRes.user_extend);
                }
                this.gvI = dataRes.live_frs_notify;
                this.gvJ = dataRes.frs_game_tab_info;
                this.gvK = dataRes.game_default_tab_id.intValue();
                this.gvL = dataRes.forum_head_icon;
                if (dataRes.video != null && dataRes.video.video_act != null) {
                    this.gvN = new k();
                    this.gvN.a(dataRes.video.video_act);
                }
                if (dataRes.info != null) {
                    this.recm_forum_list = dataRes.info.recm_forum_list;
                }
                this.ddj = dataRes.forum_ar_info;
                if (dataRes.star_rank_info != null) {
                    this.gvP = dataRes.star_rank_info;
                }
                if (dataRes.recom_post_topic != null) {
                    this.gvp = dataRes.recom_post_topic;
                }
                this.gvQ = dataRes.window_toast;
                this.gvR = dataRes.activity_config;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public AgreeBanner bpU() {
        return this.gvH;
    }

    public void a(AgreeBanner agreeBanner) {
        this.gvH = agreeBanner;
    }

    public ForumHeadIcon bpV() {
        return this.gvL;
    }

    public void a(ForumHeadIcon forumHeadIcon) {
        this.gvL = forumHeadIcon;
    }

    public List<RecmForumInfo> bpW() {
        return this.recm_forum_list;
    }

    private void ta(int i) {
        this.gvj = 1;
        if (this.gvh != null && this.gvh.size() > 0) {
            for (FrsTabInfo frsTabInfo : this.gvh) {
                if (frsTabInfo != null && frsTabInfo.tab_id.intValue() == i) {
                    this.gvj = i;
                    return;
                }
            }
        }
    }

    public void a(List<ThreadInfo> list, long j) {
        if (list != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    bd bdVar = new bd();
                    bdVar.setUserMap(this.userMap);
                    bdVar.a(list.get(i2));
                    bdVar.bV(3);
                    bdVar.sw();
                    if (bdVar.getFid() == 0 && j != 0) {
                        bdVar.setFid(j);
                    }
                    if (StringUtils.isNull(bdVar.rU())) {
                        bdVar.cN(this.fcS.getName());
                    }
                    bdVar.i(this.gvf);
                    if (!TextUtils.isEmpty(bdVar.sG())) {
                        ac acVar = new ac();
                        acVar.cI(bdVar.sG());
                        this.threadList.add(acVar);
                    } else {
                        this.threadList.add(bdVar);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public int bpX() {
        return this.alaLiveCount;
    }

    public void tb(int i) {
        this.alaLiveCount = i;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] Fx() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public boolean y(byte[] bArr) {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void r(JSONObject jSONObject) {
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void a(Message message) {
    }

    public ForumData aVq() {
        return this.fcS;
    }

    public int bpY() {
        return this.gvz;
    }

    public void tc(int i) {
        this.gvz = i;
    }

    public int bpZ() {
        return this.gvA;
    }

    public void td(int i) {
        this.gvA = i;
    }

    public void c(ForumData forumData) {
        this.fcS = forumData;
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> getThreadList() {
        return this.threadList;
    }

    public void av(ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        this.threadList = arrayList;
    }

    public AntiData qS() {
        return this.YB;
    }

    public void c(AntiData antiData) {
        this.YB = antiData;
    }

    public am rf() {
        return this.eoG;
    }

    public void a(am amVar) {
        this.eoG = amVar;
    }

    public j bqa() {
        return this.guV;
    }

    public void a(j jVar) {
        this.guV = jVar;
    }

    public com.baidu.tbadk.core.data.p bqb() {
        return this.gvg;
    }

    public void a(com.baidu.tbadk.core.data.p pVar) {
        this.gvg = pVar;
    }

    public boolean bqc() {
        return this.guW;
    }

    public void mk(boolean z) {
        this.guW = z;
    }

    public String bqd() {
        return this.guX;
    }

    public void sL(String str) {
        this.guX = str;
    }

    public m bqe() {
        return this.guY;
    }

    public void a(m mVar) {
        this.guY = mVar;
    }

    public UserData getUserData() {
        return this.fcZ;
    }

    public void e(UserData userData) {
        this.fcZ = userData;
    }

    public List<Long> bqf() {
        return this.guU;
    }

    public void dj(List<Long> list) {
        this.guU = list;
    }

    public b bqg() {
        return this.guZ;
    }

    public void a(b bVar) {
        this.guZ = bVar;
    }

    public boolean bqh() {
        return this.gva;
    }

    public void ml(boolean z) {
        this.gva = z;
    }

    public String getGameName() {
        return this.gameName;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public List<g> bqi() {
        return this.gvb;
    }

    public void dk(List<g> list) {
        this.gvb = list;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public int aVF() {
        return this.gvc;
    }

    public void pT(int i) {
        this.gvc = i;
    }

    public String bqj() {
        return this.gve;
    }

    public void sM(String str) {
        this.gve = str;
    }

    public List<FrsTabInfo> bqk() {
        return this.gvh;
    }

    public void dl(List<FrsTabInfo> list) {
        this.gvh = list;
    }

    public int bql() {
        return this.gvd;
    }

    public void te(int i) {
        this.gvd = i;
    }

    public List<FeedForumData> bqm() {
        return this.gvk;
    }

    public void dm(List<FeedForumData> list) {
        this.gvk = list;
    }

    public void sN(String str) {
        if (this.gvk != null && str != null) {
            for (FeedForumData feedForumData : this.gvk) {
                if (feedForumData != null && feedForumData.getForumId() != null && feedForumData.getForumId().equals(str)) {
                    this.gvk.remove(feedForumData);
                    return;
                }
            }
        }
    }

    public List<CategoryInfo> bqn() {
        return this.gvl;
    }

    public void dn(List<CategoryInfo> list) {
        this.gvl = list;
    }

    public void sO(String str) {
        this.gvm = str;
    }

    public String bqo() {
        return this.gvm;
    }

    public bd bqp() {
        return this.gvu;
    }

    public void ak(bd bdVar) {
        this.gvu = bdVar;
    }

    public int bqq() {
        return this.gvj;
    }

    public void tf(int i) {
        this.gvj = i;
    }

    public x bqr() {
        return this.gvn;
    }

    public void a(x xVar) {
        this.gvn = xVar;
    }

    public com.baidu.tbadk.core.data.q bqs() {
        return this.gvq;
    }

    public void a(com.baidu.tbadk.core.data.q qVar) {
        this.gvq = qVar;
    }

    public com.baidu.tbadk.core.data.s bqt() {
        return this.gvt;
    }

    public void a(com.baidu.tbadk.core.data.s sVar) {
        this.gvt = sVar;
    }

    public int bqu() {
        return this.gvw;
    }

    public void tg(int i) {
        this.gvw = i;
    }

    public au bqv() {
        return this.gvv;
    }

    public void a(au auVar) {
        this.gvv = auVar;
    }

    public NavTabInfo bqw() {
        return this.gvi;
    }

    public void a(NavTabInfo navTabInfo) {
        this.gvi = navTabInfo;
    }

    public boolean bqx() {
        return this.fFm;
    }

    public void mm(boolean z) {
        this.fFm = z;
    }

    public com.baidu.tbadk.core.data.m bqy() {
        return this.gvx;
    }

    public void a(com.baidu.tbadk.core.data.m mVar) {
        this.gvx = mVar;
    }

    public Integer bqz() {
        return this.gvr;
    }

    public void k(Integer num) {
        this.gvr = num;
    }

    public List<Integer> bqA() {
        return this.gvB;
    }

    /* renamed from: do  reason: not valid java name */
    public void m19do(List<Integer> list) {
        this.gvB = list;
    }

    public List<com.baidu.adp.widget.ListView.h> bqB() {
        return this.gvC;
    }

    public void dp(List<com.baidu.adp.widget.ListView.h> list) {
        this.gvC = list;
    }

    public com.baidu.tieba.h.b bqC() {
        return this.gvG;
    }

    public void a(com.baidu.tieba.h.b bVar) {
        this.gvG = bVar;
    }

    public AlaLiveNotify bqD() {
        return this.gvI;
    }

    public void a(AlaLiveNotify alaLiveNotify) {
        this.gvI = alaLiveNotify;
    }

    public List<FrsTabInfo> bqE() {
        return this.gvJ;
    }

    public void dq(List<FrsTabInfo> list) {
        this.gvJ = list;
    }

    public void th(int i) {
        this.gvK = i;
    }

    public int bqF() {
        return this.gvK;
    }

    public void a(com.baidu.tieba.frs.o oVar) {
        this.gvM = oVar;
    }

    public com.baidu.tieba.frs.o bqG() {
        return this.gvM;
    }

    public k bqH() {
        return this.gvN;
    }

    public void a(k kVar) {
        this.gvN = kVar;
    }

    public e bqI() {
        return this.gvD;
    }

    public void b(e eVar) {
        this.gvD = eVar;
    }

    public f bqJ() {
        return this.gvE;
    }

    public void b(f fVar) {
        this.gvE = fVar;
    }
}

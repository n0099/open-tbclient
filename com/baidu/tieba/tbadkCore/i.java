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
    public ForumArIno dcb;
    protected am enx;
    protected ForumData fbL;
    private UserData fbS;
    private String gameName;
    protected List<Long> gtQ;
    private j gtR;
    protected boolean gtS;
    protected String gtT;
    protected m gtU;
    private b gtV;
    private boolean gtW;
    private int gtZ;
    private f guA;
    public PopInfo guB;
    private com.baidu.tieba.h.b guC;
    private AgreeBanner guD;
    private AlaLiveNotify guE;
    private List<FrsTabInfo> guF;
    private ForumHeadIcon guH;
    private com.baidu.tieba.frs.o guI;
    private k guJ;
    public FrsTabInfo guK;
    public StarRank guL;
    public List<WindowToast> guM;
    public ActivityConfig guN;
    private String gua;
    private List<FrsTabInfo> gud;
    private NavTabInfo gue;
    private List<FeedForumData> gug;
    private List<CategoryInfo> guh;
    private bd guq;
    private au gur;
    private com.baidu.tbadk.core.data.m gut;
    private List<Integer> gux;
    private List<com.baidu.adp.widget.ListView.h> guy;
    private e guz;
    private int mSortType;
    public List<RecmForumInfo> recm_forum_list;
    protected ArrayList<com.baidu.adp.widget.ListView.h> threadList;
    private HashMap<String, MetaData> userMap;
    public int gtP = 0;
    private List<g> gtX = new ArrayList();
    private int gtY = 0;
    private ArrayList<com.baidu.tbadk.core.data.o> gub = new ArrayList<>();
    protected com.baidu.tbadk.core.data.p guc = null;
    private int guf = 1;
    private boolean fEg = false;
    private String gui = null;
    private x guj = null;
    public y guk = null;
    public RecomPostTopic gul = null;
    private com.baidu.tbadk.core.data.q gum = null;
    private Integer gun = -1;
    public com.baidu.tbadk.core.data.v guo = null;
    private com.baidu.tbadk.core.data.s gup = null;
    private int gus = -1;
    protected List<com.baidu.adp.widget.ListView.h> guu = null;
    private int guv = 0;
    private int guw = 0;
    private int alaLiveCount = 0;
    private int guG = 0;
    public int dcA = 0;

    public i() {
        initData();
    }

    private void initData() {
        this.fbL = new ForumData();
        this.threadList = new ArrayList<>();
        this.guu = new ArrayList();
        this.userMap = new HashMap<>();
        this.enx = new am();
        this.gtR = new j();
        this.fbS = new UserData();
        this.gtU = new m();
        c(new AntiData());
        a(new b());
        this.guy = new ArrayList();
        this.gux = new ArrayList();
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
                                this.gub.add(oVar);
                            }
                        }
                    }
                }
                if (dataRes.activityhead != null && !com.baidu.tbadk.core.util.v.w(dataRes.activityhead.head_imgs)) {
                    this.guc = new com.baidu.tbadk.core.data.p();
                    this.guc.a(dataRes.activityhead);
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
                pU(dataRes.is_new_url.intValue());
                this.gtS = dataRes.fortune_bag.intValue() == 1;
                this.gtT = dataRes.fortune_desc;
                if (dataRes.forum != null) {
                    this.gtW = dataRes.forum.has_game.intValue() == 1;
                    this.gua = dataRes.forum.game_url;
                    this.gameName = dataRes.forum.game_name;
                }
                List<StarEnter> list2 = dataRes.star_enter;
                this.gtX.clear();
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        g gVar = new g();
                        gVar.a(list2.get(i2));
                        this.gtX.add(gVar);
                    }
                }
                this.gtU.a(dataRes.gcon_account);
                this.fbL.parserProtobuf(dataRes.forum);
                long longValue = dataRes.forum != null ? dataRes.forum.id.longValue() : 0L;
                this.gtQ = dataRes.thread_id_list;
                this.YB.parserProtobuf(dataRes.anti);
                if (dataRes.anti != null) {
                    com.baidu.tieba.q.a.e(dataRes.anti.block_pop_info);
                }
                this.gtV.a(dataRes.group);
                this.enx.a(dataRes.page);
                this.gtR.a(dataRes.frs_star);
                this.fbS.parserProtobuf(dataRes.user);
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.fbS.getIsSelectTail());
                }
                this.gud = dataRes.frs_tab_info;
                if (dataRes.nav_tab_info == null) {
                    NavTabInfo.Builder builder = new NavTabInfo.Builder();
                    builder.tab = dataRes.frs_tab_info;
                    this.gue = builder.build(true);
                } else {
                    this.gue = dataRes.nav_tab_info;
                }
                if (this.gue.head != null && !com.baidu.tbadk.core.util.v.w(this.gue.head)) {
                    this.guK = this.gue.head.get(0);
                }
                this.alaLiveCount = dataRes.ala_live_count.intValue();
                tb(dataRes.frs_tab_default.intValue());
                this.gtZ = dataRes.twzhibo_pos.intValue();
                this.fEg = dataRes.trends_redpoint.intValue() == 1;
                a(dataRes.thread_list, longValue);
                this.guh = dataRes.category_list;
                if (!an.isEmpty(dataRes.bawu_enter_url)) {
                    this.gui = dataRes.bawu_enter_url;
                }
                if (dataRes.head_sdk != null) {
                    this.guj = new x();
                    this.guj.a(dataRes.head_sdk);
                }
                if (dataRes.recommend_book != null) {
                    this.guk = new y();
                    this.guk.a(dataRes.recommend_book);
                }
                if (dataRes.book_info != null) {
                    this.gum = new com.baidu.tbadk.core.data.q();
                    this.gum.a(dataRes.book_info);
                }
                if (dataRes.forum_present_info != null) {
                    this.guo = new com.baidu.tbadk.core.data.v();
                    this.guo.a(dataRes.forum_present_info);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.gup = new com.baidu.tbadk.core.data.s();
                    this.gup.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.card_shipin_info != null && dataRes.card_shipin_info.size() > 0) {
                    this.guq = new bd();
                    this.guq.ap(true);
                    this.guq.bT(this.gtZ);
                    this.guq.setUserMap(this.userMap);
                    this.guq.a(dataRes.card_shipin_info.get(0));
                    this.guq.sx();
                    if (this.guq.getFid() == 0 && longValue != 0) {
                        this.guq.setFid(longValue);
                    }
                    this.guq.i(this.gub);
                    this.guq.ao(!this.guq.rz());
                    if (this.guq.rQ() != null && this.guq.rQ().getPendantData() == null && (metaData = this.userMap.get(this.guq.rQ().getUserId())) != null && metaData.getPendantData() != null) {
                        com.baidu.tbadk.data.h hVar = new com.baidu.tbadk.data.h();
                        hVar.T(metaData.getPendantData().Dk());
                        hVar.cL(metaData.getPendantData().qG());
                        this.guq.rQ().setPendantData(hVar);
                    }
                }
                if (dataRes.ala_live_insert != null && dataRes.ala_live_insert.ala_live_list != null && dataRes.ala_live_insert.ala_live_list.size() > 0) {
                    this.guz = new e();
                    this.guz.gto = dataRes.ala_insert_floor.intValue();
                    ArrayList arrayList = new ArrayList();
                    for (int i3 = 0; i3 < dataRes.ala_live_insert.ala_live_list.size(); i3++) {
                        if (dataRes.ala_live_insert.ala_live_list.get(i3) != null) {
                            bd bdVar = new bd();
                            bdVar.a(dataRes.ala_live_insert.ala_live_list.get(i3));
                            arrayList.add(bdVar);
                        }
                    }
                    this.guz.gtn = arrayList;
                }
                if (dataRes.ala_stage_list != null) {
                    this.guA = new f();
                    ArrayList arrayList2 = new ArrayList();
                    for (int i4 = 0; i4 < dataRes.ala_stage_list.size(); i4++) {
                        if (dataRes.ala_stage_list.get(i4) != null) {
                            bd bdVar2 = new bd();
                            bdVar2.a(dataRes.ala_stage_list.get(i4));
                            arrayList2.add(bdVar2);
                        }
                    }
                    this.guA.gtq = arrayList2;
                }
                if (dataRes.school_recom_info != null) {
                    this.gus = dataRes.school_recom_pos.intValue();
                    this.gur = new au();
                    this.gur.a(dataRes.school_recom_info);
                }
                if (dataRes.carrier_enter != null) {
                    this.gut = new com.baidu.tbadk.core.data.m();
                    this.gut.a(dataRes.carrier_enter);
                }
                if (dataRes.vitality_info != null && dataRes.vitality_info.frequently_forum_info != null) {
                    this.guv = dataRes.vitality_info.frequently_forum_info.forum_state.intValue();
                    this.guw = dataRes.vitality_info.frequently_forum_info.access_flag.intValue();
                }
                this.mSortType = dataRes.sort_type.intValue();
                this.gtP = dataRes.need_log.intValue();
                com.baidu.tieba.recapp.d.a.bjZ().sc(dataRes.asp_shown_info);
                this.gux = dataRes.card_shipin_pos;
                if (dataRes.card_shipin_new != null) {
                    for (int i5 = 0; i5 < dataRes.card_shipin_new.size(); i5++) {
                        bd bdVar3 = new bd();
                        if (this.gux != null && this.gux.size() >= dataRes.card_shipin_new.size()) {
                            bdVar3.bT(this.gux.get(i5).intValue());
                        }
                        bdVar3.ap(true);
                        bdVar3.a(dataRes.card_shipin_new.get(i5));
                        this.guy.add(bdVar3);
                    }
                }
                this.guB = dataRes.enter_pop_info;
                if (dataRes.esport != null) {
                    this.guC = new com.baidu.tieba.h.b();
                    this.guC.a(dataRes.esport);
                }
                this.guD = dataRes.agree_banner;
                if (dataRes.user_extend != null) {
                    this.guI = new com.baidu.tieba.frs.o();
                    this.guI.a(dataRes.user_extend);
                }
                this.guE = dataRes.live_frs_notify;
                this.guF = dataRes.frs_game_tab_info;
                this.guG = dataRes.game_default_tab_id.intValue();
                this.guH = dataRes.forum_head_icon;
                if (dataRes.video != null && dataRes.video.video_act != null) {
                    this.guJ = new k();
                    this.guJ.a(dataRes.video.video_act);
                }
                if (dataRes.info != null) {
                    this.recm_forum_list = dataRes.info.recm_forum_list;
                }
                this.dcb = dataRes.forum_ar_info;
                if (dataRes.star_rank_info != null) {
                    this.guL = dataRes.star_rank_info;
                }
                if (dataRes.recom_post_topic != null) {
                    this.gul = dataRes.recom_post_topic;
                }
                this.guM = dataRes.window_toast;
                this.guN = dataRes.activity_config;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public AgreeBanner bpW() {
        return this.guD;
    }

    public void a(AgreeBanner agreeBanner) {
        this.guD = agreeBanner;
    }

    public ForumHeadIcon bpX() {
        return this.guH;
    }

    public void a(ForumHeadIcon forumHeadIcon) {
        this.guH = forumHeadIcon;
    }

    public List<RecmForumInfo> bpY() {
        return this.recm_forum_list;
    }

    private void tb(int i) {
        this.guf = 1;
        if (this.gud != null && this.gud.size() > 0) {
            for (FrsTabInfo frsTabInfo : this.gud) {
                if (frsTabInfo != null && frsTabInfo.tab_id.intValue() == i) {
                    this.guf = i;
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
                    bdVar.bU(3);
                    bdVar.sx();
                    if (bdVar.getFid() == 0 && j != 0) {
                        bdVar.setFid(j);
                    }
                    if (StringUtils.isNull(bdVar.rV())) {
                        bdVar.cN(this.fbL.getName());
                    }
                    bdVar.i(this.gub);
                    if (!TextUtils.isEmpty(bdVar.sH())) {
                        ac acVar = new ac();
                        acVar.cI(bdVar.sH());
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

    public int bpZ() {
        return this.alaLiveCount;
    }

    public void tc(int i) {
        this.alaLiveCount = i;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] Fz() {
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
        return this.fbL;
    }

    public int bqa() {
        return this.guv;
    }

    public void td(int i) {
        this.guv = i;
    }

    public int bqb() {
        return this.guw;
    }

    public void te(int i) {
        this.guw = i;
    }

    public void c(ForumData forumData) {
        this.fbL = forumData;
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> getThreadList() {
        return this.threadList;
    }

    public void av(ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        this.threadList = arrayList;
    }

    public AntiData qT() {
        return this.YB;
    }

    public void c(AntiData antiData) {
        this.YB = antiData;
    }

    public am rg() {
        return this.enx;
    }

    public void a(am amVar) {
        this.enx = amVar;
    }

    public j bqc() {
        return this.gtR;
    }

    public void a(j jVar) {
        this.gtR = jVar;
    }

    public com.baidu.tbadk.core.data.p bqd() {
        return this.guc;
    }

    public void a(com.baidu.tbadk.core.data.p pVar) {
        this.guc = pVar;
    }

    public boolean bqe() {
        return this.gtS;
    }

    public void mj(boolean z) {
        this.gtS = z;
    }

    public String bqf() {
        return this.gtT;
    }

    public void sI(String str) {
        this.gtT = str;
    }

    public m bqg() {
        return this.gtU;
    }

    public void a(m mVar) {
        this.gtU = mVar;
    }

    public UserData getUserData() {
        return this.fbS;
    }

    public void e(UserData userData) {
        this.fbS = userData;
    }

    public List<Long> bqh() {
        return this.gtQ;
    }

    public void dg(List<Long> list) {
        this.gtQ = list;
    }

    public b bqi() {
        return this.gtV;
    }

    public void a(b bVar) {
        this.gtV = bVar;
    }

    public boolean bqj() {
        return this.gtW;
    }

    public void mk(boolean z) {
        this.gtW = z;
    }

    public String getGameName() {
        return this.gameName;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public List<g> bqk() {
        return this.gtX;
    }

    public void dh(List<g> list) {
        this.gtX = list;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public int aVF() {
        return this.gtY;
    }

    public void pU(int i) {
        this.gtY = i;
    }

    public String bql() {
        return this.gua;
    }

    public void sJ(String str) {
        this.gua = str;
    }

    public List<FrsTabInfo> bqm() {
        return this.gud;
    }

    public void di(List<FrsTabInfo> list) {
        this.gud = list;
    }

    public int bqn() {
        return this.gtZ;
    }

    public void tf(int i) {
        this.gtZ = i;
    }

    public List<FeedForumData> bqo() {
        return this.gug;
    }

    public void dj(List<FeedForumData> list) {
        this.gug = list;
    }

    public void sK(String str) {
        if (this.gug != null && str != null) {
            for (FeedForumData feedForumData : this.gug) {
                if (feedForumData != null && feedForumData.getForumId() != null && feedForumData.getForumId().equals(str)) {
                    this.gug.remove(feedForumData);
                    return;
                }
            }
        }
    }

    public List<CategoryInfo> bqp() {
        return this.guh;
    }

    public void dk(List<CategoryInfo> list) {
        this.guh = list;
    }

    public void sL(String str) {
        this.gui = str;
    }

    public String bqq() {
        return this.gui;
    }

    public bd bqr() {
        return this.guq;
    }

    public void ak(bd bdVar) {
        this.guq = bdVar;
    }

    public int bqs() {
        return this.guf;
    }

    public void tg(int i) {
        this.guf = i;
    }

    public x bqt() {
        return this.guj;
    }

    public void a(x xVar) {
        this.guj = xVar;
    }

    public com.baidu.tbadk.core.data.q bqu() {
        return this.gum;
    }

    public void a(com.baidu.tbadk.core.data.q qVar) {
        this.gum = qVar;
    }

    public com.baidu.tbadk.core.data.s bqv() {
        return this.gup;
    }

    public void a(com.baidu.tbadk.core.data.s sVar) {
        this.gup = sVar;
    }

    public int bqw() {
        return this.gus;
    }

    public void th(int i) {
        this.gus = i;
    }

    public au bqx() {
        return this.gur;
    }

    public void a(au auVar) {
        this.gur = auVar;
    }

    public NavTabInfo bqy() {
        return this.gue;
    }

    public void a(NavTabInfo navTabInfo) {
        this.gue = navTabInfo;
    }

    public boolean bqz() {
        return this.fEg;
    }

    public void ml(boolean z) {
        this.fEg = z;
    }

    public com.baidu.tbadk.core.data.m bqA() {
        return this.gut;
    }

    public void a(com.baidu.tbadk.core.data.m mVar) {
        this.gut = mVar;
    }

    public Integer bqB() {
        return this.gun;
    }

    public void k(Integer num) {
        this.gun = num;
    }

    public List<Integer> bqC() {
        return this.gux;
    }

    public void dl(List<Integer> list) {
        this.gux = list;
    }

    public List<com.baidu.adp.widget.ListView.h> bqD() {
        return this.guy;
    }

    public void dm(List<com.baidu.adp.widget.ListView.h> list) {
        this.guy = list;
    }

    public com.baidu.tieba.h.b bqE() {
        return this.guC;
    }

    public void a(com.baidu.tieba.h.b bVar) {
        this.guC = bVar;
    }

    public AlaLiveNotify bqF() {
        return this.guE;
    }

    public void a(AlaLiveNotify alaLiveNotify) {
        this.guE = alaLiveNotify;
    }

    public List<FrsTabInfo> bqG() {
        return this.guF;
    }

    public void dn(List<FrsTabInfo> list) {
        this.guF = list;
    }

    public void ti(int i) {
        this.guG = i;
    }

    public int bqH() {
        return this.guG;
    }

    public void a(com.baidu.tieba.frs.o oVar) {
        this.guI = oVar;
    }

    public com.baidu.tieba.frs.o bqI() {
        return this.guI;
    }

    public k bqJ() {
        return this.guJ;
    }

    public void a(k kVar) {
        this.guJ = kVar;
    }

    public e bqK() {
        return this.guz;
    }

    public void b(e eVar) {
        this.guz = eVar;
    }

    public f bqL() {
        return this.guA;
    }

    public void b(f fVar) {
        this.guA = fVar;
    }
}

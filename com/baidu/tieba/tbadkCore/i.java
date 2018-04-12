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
    public ForumArIno dce;
    protected am enA;
    protected ForumData fbO;
    private UserData fbV;
    private String gameName;
    protected List<Long> gtT;
    private j gtU;
    protected boolean gtV;
    protected String gtW;
    protected m gtX;
    private b gtY;
    private boolean gtZ;
    private List<Integer> guA;
    private List<com.baidu.adp.widget.ListView.h> guB;
    private e guC;
    private f guD;
    public PopInfo guE;
    private com.baidu.tieba.h.b guF;
    private AgreeBanner guG;
    private AlaLiveNotify guH;
    private List<FrsTabInfo> guI;
    private ForumHeadIcon guK;
    private com.baidu.tieba.frs.o guL;
    private k guM;
    public FrsTabInfo guN;
    public StarRank guO;
    public List<WindowToast> guP;
    public ActivityConfig guQ;
    private int guc;
    private String gud;
    private List<FrsTabInfo> gug;
    private NavTabInfo guh;
    private List<FeedForumData> guj;
    private List<CategoryInfo> guk;
    private bd gut;
    private au guu;
    private com.baidu.tbadk.core.data.m guw;
    private int mSortType;
    public List<RecmForumInfo> recm_forum_list;
    protected ArrayList<com.baidu.adp.widget.ListView.h> threadList;
    private HashMap<String, MetaData> userMap;
    public int gtS = 0;
    private List<g> gua = new ArrayList();
    private int gub = 0;
    private ArrayList<com.baidu.tbadk.core.data.o> gue = new ArrayList<>();
    protected com.baidu.tbadk.core.data.p guf = null;
    private int gui = 1;
    private boolean fEj = false;
    private String gul = null;
    private x gum = null;
    public y gun = null;
    public RecomPostTopic guo = null;
    private com.baidu.tbadk.core.data.q gup = null;
    private Integer guq = -1;
    public com.baidu.tbadk.core.data.v gur = null;
    private com.baidu.tbadk.core.data.s gus = null;
    private int guv = -1;
    protected List<com.baidu.adp.widget.ListView.h> gux = null;
    private int guy = 0;
    private int guz = 0;
    private int alaLiveCount = 0;
    private int guJ = 0;
    public int dcD = 0;

    public i() {
        initData();
    }

    private void initData() {
        this.fbO = new ForumData();
        this.threadList = new ArrayList<>();
        this.gux = new ArrayList();
        this.userMap = new HashMap<>();
        this.enA = new am();
        this.gtU = new j();
        this.fbV = new UserData();
        this.gtX = new m();
        c(new AntiData());
        a(new b());
        this.guB = new ArrayList();
        this.guA = new ArrayList();
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
                                this.gue.add(oVar);
                            }
                        }
                    }
                }
                if (dataRes.activityhead != null && !com.baidu.tbadk.core.util.v.w(dataRes.activityhead.head_imgs)) {
                    this.guf = new com.baidu.tbadk.core.data.p();
                    this.guf.a(dataRes.activityhead);
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
                pV(dataRes.is_new_url.intValue());
                this.gtV = dataRes.fortune_bag.intValue() == 1;
                this.gtW = dataRes.fortune_desc;
                if (dataRes.forum != null) {
                    this.gtZ = dataRes.forum.has_game.intValue() == 1;
                    this.gud = dataRes.forum.game_url;
                    this.gameName = dataRes.forum.game_name;
                }
                List<StarEnter> list2 = dataRes.star_enter;
                this.gua.clear();
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        g gVar = new g();
                        gVar.a(list2.get(i2));
                        this.gua.add(gVar);
                    }
                }
                this.gtX.a(dataRes.gcon_account);
                this.fbO.parserProtobuf(dataRes.forum);
                long longValue = dataRes.forum != null ? dataRes.forum.id.longValue() : 0L;
                this.gtT = dataRes.thread_id_list;
                this.YB.parserProtobuf(dataRes.anti);
                if (dataRes.anti != null) {
                    com.baidu.tieba.q.a.e(dataRes.anti.block_pop_info);
                }
                this.gtY.a(dataRes.group);
                this.enA.a(dataRes.page);
                this.gtU.a(dataRes.frs_star);
                this.fbV.parserProtobuf(dataRes.user);
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.fbV.getIsSelectTail());
                }
                this.gug = dataRes.frs_tab_info;
                if (dataRes.nav_tab_info == null) {
                    NavTabInfo.Builder builder = new NavTabInfo.Builder();
                    builder.tab = dataRes.frs_tab_info;
                    this.guh = builder.build(true);
                } else {
                    this.guh = dataRes.nav_tab_info;
                }
                if (this.guh.head != null && !com.baidu.tbadk.core.util.v.w(this.guh.head)) {
                    this.guN = this.guh.head.get(0);
                }
                this.alaLiveCount = dataRes.ala_live_count.intValue();
                tc(dataRes.frs_tab_default.intValue());
                this.guc = dataRes.twzhibo_pos.intValue();
                this.fEj = dataRes.trends_redpoint.intValue() == 1;
                a(dataRes.thread_list, longValue);
                this.guk = dataRes.category_list;
                if (!an.isEmpty(dataRes.bawu_enter_url)) {
                    this.gul = dataRes.bawu_enter_url;
                }
                if (dataRes.head_sdk != null) {
                    this.gum = new x();
                    this.gum.a(dataRes.head_sdk);
                }
                if (dataRes.recommend_book != null) {
                    this.gun = new y();
                    this.gun.a(dataRes.recommend_book);
                }
                if (dataRes.book_info != null) {
                    this.gup = new com.baidu.tbadk.core.data.q();
                    this.gup.a(dataRes.book_info);
                }
                if (dataRes.forum_present_info != null) {
                    this.gur = new com.baidu.tbadk.core.data.v();
                    this.gur.a(dataRes.forum_present_info);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.gus = new com.baidu.tbadk.core.data.s();
                    this.gus.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.card_shipin_info != null && dataRes.card_shipin_info.size() > 0) {
                    this.gut = new bd();
                    this.gut.ap(true);
                    this.gut.bU(this.guc);
                    this.gut.setUserMap(this.userMap);
                    this.gut.a(dataRes.card_shipin_info.get(0));
                    this.gut.sx();
                    if (this.gut.getFid() == 0 && longValue != 0) {
                        this.gut.setFid(longValue);
                    }
                    this.gut.i(this.gue);
                    this.gut.ao(!this.gut.rz());
                    if (this.gut.rQ() != null && this.gut.rQ().getPendantData() == null && (metaData = this.userMap.get(this.gut.rQ().getUserId())) != null && metaData.getPendantData() != null) {
                        com.baidu.tbadk.data.h hVar = new com.baidu.tbadk.data.h();
                        hVar.T(metaData.getPendantData().Dk());
                        hVar.cL(metaData.getPendantData().qG());
                        this.gut.rQ().setPendantData(hVar);
                    }
                }
                if (dataRes.ala_live_insert != null && dataRes.ala_live_insert.ala_live_list != null && dataRes.ala_live_insert.ala_live_list.size() > 0) {
                    this.guC = new e();
                    this.guC.gtr = dataRes.ala_insert_floor.intValue();
                    ArrayList arrayList = new ArrayList();
                    for (int i3 = 0; i3 < dataRes.ala_live_insert.ala_live_list.size(); i3++) {
                        if (dataRes.ala_live_insert.ala_live_list.get(i3) != null) {
                            bd bdVar = new bd();
                            bdVar.a(dataRes.ala_live_insert.ala_live_list.get(i3));
                            arrayList.add(bdVar);
                        }
                    }
                    this.guC.gtq = arrayList;
                }
                if (dataRes.ala_stage_list != null) {
                    this.guD = new f();
                    ArrayList arrayList2 = new ArrayList();
                    for (int i4 = 0; i4 < dataRes.ala_stage_list.size(); i4++) {
                        if (dataRes.ala_stage_list.get(i4) != null) {
                            bd bdVar2 = new bd();
                            bdVar2.a(dataRes.ala_stage_list.get(i4));
                            arrayList2.add(bdVar2);
                        }
                    }
                    this.guD.gtt = arrayList2;
                }
                if (dataRes.school_recom_info != null) {
                    this.guv = dataRes.school_recom_pos.intValue();
                    this.guu = new au();
                    this.guu.a(dataRes.school_recom_info);
                }
                if (dataRes.carrier_enter != null) {
                    this.guw = new com.baidu.tbadk.core.data.m();
                    this.guw.a(dataRes.carrier_enter);
                }
                if (dataRes.vitality_info != null && dataRes.vitality_info.frequently_forum_info != null) {
                    this.guy = dataRes.vitality_info.frequently_forum_info.forum_state.intValue();
                    this.guz = dataRes.vitality_info.frequently_forum_info.access_flag.intValue();
                }
                this.mSortType = dataRes.sort_type.intValue();
                this.gtS = dataRes.need_log.intValue();
                com.baidu.tieba.recapp.d.a.bjZ().sc(dataRes.asp_shown_info);
                this.guA = dataRes.card_shipin_pos;
                if (dataRes.card_shipin_new != null) {
                    for (int i5 = 0; i5 < dataRes.card_shipin_new.size(); i5++) {
                        bd bdVar3 = new bd();
                        if (this.guA != null && this.guA.size() >= dataRes.card_shipin_new.size()) {
                            bdVar3.bU(this.guA.get(i5).intValue());
                        }
                        bdVar3.ap(true);
                        bdVar3.a(dataRes.card_shipin_new.get(i5));
                        this.guB.add(bdVar3);
                    }
                }
                this.guE = dataRes.enter_pop_info;
                if (dataRes.esport != null) {
                    this.guF = new com.baidu.tieba.h.b();
                    this.guF.a(dataRes.esport);
                }
                this.guG = dataRes.agree_banner;
                if (dataRes.user_extend != null) {
                    this.guL = new com.baidu.tieba.frs.o();
                    this.guL.a(dataRes.user_extend);
                }
                this.guH = dataRes.live_frs_notify;
                this.guI = dataRes.frs_game_tab_info;
                this.guJ = dataRes.game_default_tab_id.intValue();
                this.guK = dataRes.forum_head_icon;
                if (dataRes.video != null && dataRes.video.video_act != null) {
                    this.guM = new k();
                    this.guM.a(dataRes.video.video_act);
                }
                if (dataRes.info != null) {
                    this.recm_forum_list = dataRes.info.recm_forum_list;
                }
                this.dce = dataRes.forum_ar_info;
                if (dataRes.star_rank_info != null) {
                    this.guO = dataRes.star_rank_info;
                }
                if (dataRes.recom_post_topic != null) {
                    this.guo = dataRes.recom_post_topic;
                }
                this.guP = dataRes.window_toast;
                this.guQ = dataRes.activity_config;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public AgreeBanner bpW() {
        return this.guG;
    }

    public void a(AgreeBanner agreeBanner) {
        this.guG = agreeBanner;
    }

    public ForumHeadIcon bpX() {
        return this.guK;
    }

    public void a(ForumHeadIcon forumHeadIcon) {
        this.guK = forumHeadIcon;
    }

    public List<RecmForumInfo> bpY() {
        return this.recm_forum_list;
    }

    private void tc(int i) {
        this.gui = 1;
        if (this.gug != null && this.gug.size() > 0) {
            for (FrsTabInfo frsTabInfo : this.gug) {
                if (frsTabInfo != null && frsTabInfo.tab_id.intValue() == i) {
                    this.gui = i;
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
                    bdVar.sx();
                    if (bdVar.getFid() == 0 && j != 0) {
                        bdVar.setFid(j);
                    }
                    if (StringUtils.isNull(bdVar.rV())) {
                        bdVar.cN(this.fbO.getName());
                    }
                    bdVar.i(this.gue);
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

    public void td(int i) {
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
        return this.fbO;
    }

    public int bqa() {
        return this.guy;
    }

    public void te(int i) {
        this.guy = i;
    }

    public int bqb() {
        return this.guz;
    }

    public void tf(int i) {
        this.guz = i;
    }

    public void c(ForumData forumData) {
        this.fbO = forumData;
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
        return this.enA;
    }

    public void a(am amVar) {
        this.enA = amVar;
    }

    public j bqc() {
        return this.gtU;
    }

    public void a(j jVar) {
        this.gtU = jVar;
    }

    public com.baidu.tbadk.core.data.p bqd() {
        return this.guf;
    }

    public void a(com.baidu.tbadk.core.data.p pVar) {
        this.guf = pVar;
    }

    public boolean bqe() {
        return this.gtV;
    }

    public void mj(boolean z) {
        this.gtV = z;
    }

    public String bqf() {
        return this.gtW;
    }

    public void sI(String str) {
        this.gtW = str;
    }

    public m bqg() {
        return this.gtX;
    }

    public void a(m mVar) {
        this.gtX = mVar;
    }

    public UserData getUserData() {
        return this.fbV;
    }

    public void e(UserData userData) {
        this.fbV = userData;
    }

    public List<Long> bqh() {
        return this.gtT;
    }

    public void dg(List<Long> list) {
        this.gtT = list;
    }

    public b bqi() {
        return this.gtY;
    }

    public void a(b bVar) {
        this.gtY = bVar;
    }

    public boolean bqj() {
        return this.gtZ;
    }

    public void mk(boolean z) {
        this.gtZ = z;
    }

    public String getGameName() {
        return this.gameName;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public List<g> bqk() {
        return this.gua;
    }

    public void dh(List<g> list) {
        this.gua = list;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public int aVF() {
        return this.gub;
    }

    public void pV(int i) {
        this.gub = i;
    }

    public String bql() {
        return this.gud;
    }

    public void sJ(String str) {
        this.gud = str;
    }

    public List<FrsTabInfo> bqm() {
        return this.gug;
    }

    public void di(List<FrsTabInfo> list) {
        this.gug = list;
    }

    public int bqn() {
        return this.guc;
    }

    public void tg(int i) {
        this.guc = i;
    }

    public List<FeedForumData> bqo() {
        return this.guj;
    }

    public void dj(List<FeedForumData> list) {
        this.guj = list;
    }

    public void sK(String str) {
        if (this.guj != null && str != null) {
            for (FeedForumData feedForumData : this.guj) {
                if (feedForumData != null && feedForumData.getForumId() != null && feedForumData.getForumId().equals(str)) {
                    this.guj.remove(feedForumData);
                    return;
                }
            }
        }
    }

    public List<CategoryInfo> bqp() {
        return this.guk;
    }

    public void dk(List<CategoryInfo> list) {
        this.guk = list;
    }

    public void sL(String str) {
        this.gul = str;
    }

    public String bqq() {
        return this.gul;
    }

    public bd bqr() {
        return this.gut;
    }

    public void ak(bd bdVar) {
        this.gut = bdVar;
    }

    public int bqs() {
        return this.gui;
    }

    public void th(int i) {
        this.gui = i;
    }

    public x bqt() {
        return this.gum;
    }

    public void a(x xVar) {
        this.gum = xVar;
    }

    public com.baidu.tbadk.core.data.q bqu() {
        return this.gup;
    }

    public void a(com.baidu.tbadk.core.data.q qVar) {
        this.gup = qVar;
    }

    public com.baidu.tbadk.core.data.s bqv() {
        return this.gus;
    }

    public void a(com.baidu.tbadk.core.data.s sVar) {
        this.gus = sVar;
    }

    public int bqw() {
        return this.guv;
    }

    public void ti(int i) {
        this.guv = i;
    }

    public au bqx() {
        return this.guu;
    }

    public void a(au auVar) {
        this.guu = auVar;
    }

    public NavTabInfo bqy() {
        return this.guh;
    }

    public void a(NavTabInfo navTabInfo) {
        this.guh = navTabInfo;
    }

    public boolean bqz() {
        return this.fEj;
    }

    public void ml(boolean z) {
        this.fEj = z;
    }

    public com.baidu.tbadk.core.data.m bqA() {
        return this.guw;
    }

    public void a(com.baidu.tbadk.core.data.m mVar) {
        this.guw = mVar;
    }

    public Integer bqB() {
        return this.guq;
    }

    public void k(Integer num) {
        this.guq = num;
    }

    public List<Integer> bqC() {
        return this.guA;
    }

    public void dl(List<Integer> list) {
        this.guA = list;
    }

    public List<com.baidu.adp.widget.ListView.h> bqD() {
        return this.guB;
    }

    public void dm(List<com.baidu.adp.widget.ListView.h> list) {
        this.guB = list;
    }

    public com.baidu.tieba.h.b bqE() {
        return this.guF;
    }

    public void a(com.baidu.tieba.h.b bVar) {
        this.guF = bVar;
    }

    public AlaLiveNotify bqF() {
        return this.guH;
    }

    public void a(AlaLiveNotify alaLiveNotify) {
        this.guH = alaLiveNotify;
    }

    public List<FrsTabInfo> bqG() {
        return this.guI;
    }

    public void dn(List<FrsTabInfo> list) {
        this.guI = list;
    }

    public void tj(int i) {
        this.guJ = i;
    }

    public int bqH() {
        return this.guJ;
    }

    public void a(com.baidu.tieba.frs.o oVar) {
        this.guL = oVar;
    }

    public com.baidu.tieba.frs.o bqI() {
        return this.guL;
    }

    public k bqJ() {
        return this.guM;
    }

    public void a(k kVar) {
        this.guM = kVar;
    }

    public e bqK() {
        return this.guC;
    }

    public void b(e eVar) {
        this.guC = eVar;
    }

    public f bqL() {
        return this.guD;
    }

    public void b(f fVar) {
        this.guD = fVar;
    }
}

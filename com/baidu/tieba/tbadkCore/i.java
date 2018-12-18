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
    private AntiData arV;
    public ForumArIno dNY;
    protected ForumData fPN;
    private UserData fPU;
    protected al feI;
    private String gameName;
    protected List<Long> hiA;
    private j hiB;
    protected boolean hiC;
    protected String hiD;
    protected m hiE;
    private b hiF;
    private boolean hiG;
    private int hiJ;
    private String hiK;
    private NavTabInfo hiN;
    private List<FeedForumData> hiP;
    private List<CategoryInfo> hiQ;
    private bb hiZ;
    public List<BottomMenu> hjA;
    private com.baidu.tieba.tbadkCore.data.m hjB;
    public boolean hjC;
    public List<String> hjE;
    public SmartApp hjF;
    public NebulaHotThreads hjG;
    private at hja;
    private com.baidu.tbadk.core.data.l hjc;
    private List<Integer> hjg;
    private List<com.baidu.adp.widget.ListView.h> hjh;
    private e hji;
    private f hjj;
    public PopInfo hjk;
    private com.baidu.tieba.h.b hjl;
    private AgreeBanner hjm;
    private AlaLiveNotify hjn;
    private List<FrsTabInfo> hjo;
    private ForumHeadIcon hjq;
    private com.baidu.tieba.frs.q hjr;
    private k hjs;
    public FrsTabInfo hjt;
    public StarRank hju;
    public List<WindowToast> hjv;
    public ActivityConfig hjw;
    private WorldcupSkin hjx;
    public com.baidu.tieba.frs.b hjy;
    public List<OriForumInfo> hjz;
    public boolean isBrandForum;
    private int mSortType;
    public List<RecmForumInfo> recm_forum_list;
    protected ArrayList<com.baidu.adp.widget.ListView.h> threadList;
    private HashMap<String, MetaData> userMap;
    public int hiz = 0;
    private List<g> hiH = new ArrayList();
    private int hiI = 0;
    private ArrayList<com.baidu.tbadk.core.data.n> hiL = new ArrayList<>();
    protected com.baidu.tbadk.core.data.o hiM = null;
    private int hiO = 1;
    private boolean grW = false;
    private String hiR = null;
    private com.baidu.tbadk.core.data.w hiS = null;
    public x hiT = null;
    public RecomPostTopic hiU = null;
    private com.baidu.tbadk.core.data.p hiV = null;
    private Integer hiW = -1;
    public com.baidu.tbadk.core.data.u hiX = null;
    private com.baidu.tbadk.core.data.r hiY = null;
    private int hjb = -1;
    protected List<com.baidu.adp.widget.ListView.h> hjd = null;
    private int hje = 0;
    private int hjf = 0;
    private int alaLiveCount = 0;
    private int hjp = 0;
    public int dPc = 0;
    public int hjD = 1;

    public i() {
        initData();
    }

    private void initData() {
        this.fPN = new ForumData();
        this.threadList = new ArrayList<>();
        this.hjd = new ArrayList();
        this.userMap = new HashMap<>();
        this.feI = new al();
        this.hiB = new j();
        this.fPU = new UserData();
        this.hiE = new m();
        c(new AntiData());
        a(new b());
        this.hjh = new ArrayList();
        this.hjg = new ArrayList();
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
                                this.hiL.add(nVar);
                            }
                        }
                    }
                }
                if (dataRes.forum != null) {
                    this.hiG = dataRes.forum.has_game.intValue() == 1;
                    this.hiK = dataRes.forum.game_url;
                    this.gameName = dataRes.forum.game_name;
                    this.isBrandForum = dataRes.forum.is_brand_forum.intValue() == 1;
                }
                if (this.isBrandForum && dataRes.brand_forum_info != null) {
                    this.hiM = new com.baidu.tbadk.core.data.o();
                    this.hiM.a(dataRes.brand_forum_info.head_imgs);
                    this.hjy = new com.baidu.tieba.frs.b();
                    this.hjy.a(dataRes.brand_forum_info);
                    if (!com.baidu.tbadk.core.util.v.I(dataRes.brand_forum_info.relation_forum)) {
                        this.hjz = new ArrayList();
                        for (OriForumInfo oriForumInfo : dataRes.brand_forum_info.relation_forum) {
                            if (oriForumInfo != null) {
                                this.hjz.add(oriForumInfo);
                            }
                        }
                    }
                } else if (dataRes.activityhead != null && !com.baidu.tbadk.core.util.v.I(dataRes.activityhead.head_imgs)) {
                    this.hiM = new com.baidu.tbadk.core.data.o();
                    this.hiM.a(dataRes.activityhead);
                }
                this.hjA = dataRes.bottom_menu;
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
                rY(dataRes.is_new_url.intValue());
                this.hiC = dataRes.fortune_bag.intValue() == 1;
                this.hiD = dataRes.fortune_desc;
                List<StarEnter> list2 = dataRes.star_enter;
                this.hiH.clear();
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        g gVar = new g();
                        gVar.a(list2.get(i2));
                        this.hiH.add(gVar);
                    }
                }
                this.hiE.a(dataRes.gcon_account);
                this.fPN.parserProtobuf(dataRes.forum);
                long longValue = dataRes.forum != null ? dataRes.forum.id.longValue() : 0L;
                this.hiA = dataRes.thread_id_list;
                this.arV.parserProtobuf(dataRes.anti);
                if (dataRes.anti != null) {
                    com.baidu.tieba.ueg.c.e(dataRes.anti.block_pop_info);
                }
                this.hiF.a(dataRes.group);
                this.feI.a(dataRes.page);
                this.hiB.a(dataRes.frs_star);
                this.fPU.parserProtobuf(dataRes.user);
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.fPU.getIsSelectTail());
                }
                if (dataRes.nav_tab_info == null) {
                    NavTabInfo.Builder builder = new NavTabInfo.Builder();
                    builder.tab = dataRes.frs_tab_info;
                    this.hiN = builder.build(true);
                } else {
                    this.hiN = dataRes.nav_tab_info;
                }
                if (this.hiN != null && com.baidu.tbadk.core.util.v.d(this.hiN.tab, 0) != null) {
                    this.hjD = ((FrsTabInfo) com.baidu.tbadk.core.util.v.d(this.hiN.tab, 0)).tab_id.intValue();
                }
                if (this.hiN != null && !com.baidu.tbadk.core.util.v.I(this.hiN.head)) {
                    this.hjt = this.hiN.head.get(0);
                }
                this.alaLiveCount = dataRes.ala_live_count.intValue();
                vi(dataRes.frs_tab_default.intValue());
                this.hiJ = dataRes.twzhibo_pos.intValue();
                this.grW = dataRes.trends_redpoint.intValue() == 1;
                c(dataRes.thread_list, longValue);
                this.hiQ = dataRes.category_list;
                if (!ao.isEmpty(dataRes.bawu_enter_url)) {
                    this.hiR = dataRes.bawu_enter_url;
                }
                if (dataRes.head_sdk != null) {
                    this.hiS = new com.baidu.tbadk.core.data.w();
                    this.hiS.a(dataRes.head_sdk);
                }
                if (dataRes.recommend_book != null) {
                    this.hiT = new x();
                    this.hiT.a(dataRes.recommend_book);
                }
                if (dataRes.book_info != null) {
                    this.hiV = new com.baidu.tbadk.core.data.p();
                    this.hiV.a(dataRes.book_info);
                }
                if (dataRes.forum_present_info != null) {
                    this.hiX = new com.baidu.tbadk.core.data.u();
                    this.hiX.a(dataRes.forum_present_info);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.hiY = new com.baidu.tbadk.core.data.r();
                    this.hiY.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.card_shipin_info != null && dataRes.card_shipin_info.size() > 0) {
                    this.hiZ = new bb();
                    this.hiZ.bb(true);
                    this.hiZ.cV(this.hiJ);
                    this.hiZ.setUserMap(this.userMap);
                    this.hiZ.a(dataRes.card_shipin_info.get(0));
                    this.hiZ.Aq();
                    this.hiZ.avD = this.isBrandForum;
                    if (this.hiZ.getFid() == 0 && longValue != 0) {
                        this.hiZ.setFid(longValue);
                    }
                    this.hiZ.m(this.hiL);
                    this.hiZ.ba(!this.hiZ.zm());
                    if (this.hiZ.zG() != null && this.hiZ.zG().getPendantData() == null && (metaData = this.userMap.get(this.hiZ.zG().getUserId())) != null && metaData.getPendantData() != null) {
                        com.baidu.tbadk.data.j jVar = new com.baidu.tbadk.data.j();
                        jVar.ao(metaData.getPendantData().LE());
                        jVar.ej(metaData.getPendantData().ys());
                        this.hiZ.zG().setPendantData(jVar);
                    }
                }
                if (dataRes.ala_live_insert != null && dataRes.ala_live_insert.ala_live_list != null && dataRes.ala_live_insert.ala_live_list.size() > 0) {
                    this.hji = new e();
                    this.hji.hhU = dataRes.ala_insert_floor.intValue();
                    ArrayList arrayList = new ArrayList();
                    for (int i3 = 0; i3 < dataRes.ala_live_insert.ala_live_list.size(); i3++) {
                        if (dataRes.ala_live_insert.ala_live_list.get(i3) != null) {
                            bb bbVar = new bb();
                            bbVar.a(dataRes.ala_live_insert.ala_live_list.get(i3));
                            bbVar.avD = this.isBrandForum;
                            arrayList.add(bbVar);
                        }
                    }
                    this.hji.hhT = arrayList;
                }
                if (dataRes.ala_stage_list != null) {
                    this.hjj = new f();
                    ArrayList arrayList2 = new ArrayList();
                    for (int i4 = 0; i4 < dataRes.ala_stage_list.size(); i4++) {
                        if (dataRes.ala_stage_list.get(i4) != null) {
                            bb bbVar2 = new bb();
                            bbVar2.a(dataRes.ala_stage_list.get(i4));
                            bbVar2.avD = this.isBrandForum;
                            arrayList2.add(bbVar2);
                        }
                    }
                    this.hjj.hhW = arrayList2;
                }
                if (dataRes.school_recom_info != null) {
                    this.hjb = dataRes.school_recom_pos.intValue();
                    this.hja = new at();
                    this.hja.a(dataRes.school_recom_info);
                }
                if (dataRes.carrier_enter != null) {
                    this.hjc = new com.baidu.tbadk.core.data.l();
                    this.hjc.a(dataRes.carrier_enter);
                }
                if (dataRes.vitality_info != null && dataRes.vitality_info.frequently_forum_info != null) {
                    this.hje = dataRes.vitality_info.frequently_forum_info.forum_state.intValue();
                    this.hjf = dataRes.vitality_info.frequently_forum_info.access_flag.intValue();
                }
                this.mSortType = dataRes.sort_type.intValue();
                this.hiz = dataRes.need_log.intValue();
                com.baidu.tieba.recapp.d.a.bvo().uK(dataRes.asp_shown_info);
                this.hjg = dataRes.card_shipin_pos;
                if (dataRes.card_shipin_new != null) {
                    for (int i5 = 0; i5 < dataRes.card_shipin_new.size(); i5++) {
                        bb bbVar3 = new bb();
                        if (this.hjg != null && this.hjg.size() >= dataRes.card_shipin_new.size()) {
                            bbVar3.cV(this.hjg.get(i5).intValue());
                        }
                        bbVar3.bb(true);
                        bbVar3.a(dataRes.card_shipin_new.get(i5));
                        bbVar3.avD = this.isBrandForum;
                        this.hjh.add(bbVar3);
                    }
                }
                this.hjk = dataRes.enter_pop_info;
                if (dataRes.esport != null) {
                    this.hjl = new com.baidu.tieba.h.b();
                    this.hjl.a(dataRes.esport);
                }
                this.hjm = dataRes.agree_banner;
                if (dataRes.user_extend != null) {
                    this.hjr = new com.baidu.tieba.frs.q();
                    this.hjr.a(dataRes.user_extend);
                }
                this.hjn = dataRes.live_frs_notify;
                this.hjo = dataRes.frs_game_tab_info;
                this.hjp = dataRes.game_default_tab_id.intValue();
                this.hjq = dataRes.forum_head_icon;
                if (dataRes.video != null && dataRes.video.video_act != null) {
                    this.hjs = new k();
                    this.hjs.a(dataRes.video.video_act);
                }
                if (dataRes.info != null) {
                    this.recm_forum_list = dataRes.info.recm_forum_list;
                }
                this.dNY = dataRes.forum_ar_info;
                if (dataRes.star_rank_info != null) {
                    this.hju = dataRes.star_rank_info;
                }
                if (dataRes.recom_post_topic != null) {
                    this.hiU = dataRes.recom_post_topic;
                }
                this.hjv = dataRes.window_toast;
                this.hjw = dataRes.activity_config;
                this.hjx = dataRes.worldcup_skin;
                this.hjB = new com.baidu.tieba.tbadkCore.data.m();
                this.hjB.a(dataRes.redpacketrain);
                this.hjC = dataRes.video_auto_play.intValue() == 1;
                this.hjE = dataRes.smart_app_avatar;
                this.hjF = dataRes.smart_app;
                this.hjG = dataRes.nebula_hot_threads;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public AgreeBanner bBk() {
        return this.hjm;
    }

    public void a(AgreeBanner agreeBanner) {
        this.hjm = agreeBanner;
    }

    public ForumHeadIcon bBl() {
        return this.hjq;
    }

    public void a(ForumHeadIcon forumHeadIcon) {
        this.hjq = forumHeadIcon;
    }

    public List<RecmForumInfo> bBm() {
        return this.recm_forum_list;
    }

    private void vi(int i) {
        this.hiO = 1;
        if (this.hiN != null && this.hiN.tab != null && this.hiN.tab.size() > 0) {
            for (FrsTabInfo frsTabInfo : this.hiN.tab) {
                if (frsTabInfo != null && frsTabInfo.tab_id.intValue() == i) {
                    this.hiO = i;
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
                    bbVar.Aq();
                    if (bbVar.getFid() == 0 && j != 0) {
                        bbVar.setFid(j);
                    }
                    if (StringUtils.isNull(bbVar.zM())) {
                        bbVar.em(this.fPN.getName());
                    }
                    bbVar.m(this.hiL);
                    bbVar.avD = this.fPN.isBrandForum;
                    if (!TextUtils.isEmpty(bbVar.AA())) {
                        ab abVar = new ab();
                        abVar.eh(bbVar.AA());
                        this.threadList.add(abVar);
                    } else {
                        this.threadList.add(bbVar);
                    }
                }
            }
        }
    }

    public int bBn() {
        return this.alaLiveCount;
    }

    public void vj(int i) {
        this.alaLiveCount = i;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] NX() {
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

    public ForumData bgh() {
        return this.fPN;
    }

    public int bBo() {
        return this.hje;
    }

    public void vk(int i) {
        this.hje = i;
    }

    public int bBp() {
        return this.hjf;
    }

    public void vl(int i) {
        this.hjf = i;
    }

    public void c(ForumData forumData) {
        this.fPN = forumData;
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> getThreadList() {
        return this.threadList;
    }

    public void ax(ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        this.threadList = arrayList;
    }

    public AntiData yE() {
        return this.arV;
    }

    public void c(AntiData antiData) {
        this.arV = antiData;
    }

    public al yS() {
        return this.feI;
    }

    public void a(al alVar) {
        this.feI = alVar;
    }

    public j bBq() {
        return this.hiB;
    }

    public void a(j jVar) {
        this.hiB = jVar;
    }

    public com.baidu.tbadk.core.data.o bBr() {
        return this.hiM;
    }

    public void a(com.baidu.tbadk.core.data.o oVar) {
        this.hiM = oVar;
    }

    public boolean bBs() {
        return this.hiC;
    }

    public void nn(boolean z) {
        this.hiC = z;
    }

    public String bBt() {
        return this.hiD;
    }

    public void vr(String str) {
        this.hiD = str;
    }

    public m bBu() {
        return this.hiE;
    }

    public void a(m mVar) {
        this.hiE = mVar;
    }

    public UserData getUserData() {
        return this.fPU;
    }

    public void e(UserData userData) {
        this.fPU = userData;
    }

    public List<Long> bBv() {
        return this.hiA;
    }

    public void dF(List<Long> list) {
        this.hiA = list;
    }

    public b bBw() {
        return this.hiF;
    }

    public void a(b bVar) {
        this.hiF = bVar;
    }

    public boolean bBx() {
        return this.hiG;
    }

    public void no(boolean z) {
        this.hiG = z;
    }

    public String getGameName() {
        return this.gameName;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public List<g> bBy() {
        return this.hiH;
    }

    public void dG(List<g> list) {
        this.hiH = list;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public int bgw() {
        return this.hiI;
    }

    public void rY(int i) {
        this.hiI = i;
    }

    public String bBz() {
        return this.hiK;
    }

    public void vs(String str) {
        this.hiK = str;
    }

    public int bBA() {
        return this.hiJ;
    }

    public void vm(int i) {
        this.hiJ = i;
    }

    public List<FeedForumData> bBB() {
        return this.hiP;
    }

    public void dH(List<FeedForumData> list) {
        this.hiP = list;
    }

    public void vt(String str) {
        if (this.hiP != null && str != null) {
            for (FeedForumData feedForumData : this.hiP) {
                if (feedForumData != null && feedForumData.getForumId() != null && feedForumData.getForumId().equals(str)) {
                    this.hiP.remove(feedForumData);
                    return;
                }
            }
        }
    }

    public List<CategoryInfo> bBC() {
        return this.hiQ;
    }

    public void dI(List<CategoryInfo> list) {
        this.hiQ = list;
    }

    public void vu(String str) {
        this.hiR = str;
    }

    public String bBD() {
        return this.hiR;
    }

    public bb bBE() {
        return this.hiZ;
    }

    public void at(bb bbVar) {
        this.hiZ = bbVar;
    }

    public int bBF() {
        return this.hiO;
    }

    public void vn(int i) {
        this.hiO = i;
    }

    public com.baidu.tbadk.core.data.w bBG() {
        return this.hiS;
    }

    public void a(com.baidu.tbadk.core.data.w wVar) {
        this.hiS = wVar;
    }

    public com.baidu.tbadk.core.data.p bBH() {
        return this.hiV;
    }

    public void a(com.baidu.tbadk.core.data.p pVar) {
        this.hiV = pVar;
    }

    public com.baidu.tbadk.core.data.r bBI() {
        return this.hiY;
    }

    public void a(com.baidu.tbadk.core.data.r rVar) {
        this.hiY = rVar;
    }

    public int bBJ() {
        return this.hjb;
    }

    public void vo(int i) {
        this.hjb = i;
    }

    public at bBK() {
        return this.hja;
    }

    public void a(at atVar) {
        this.hja = atVar;
    }

    public NavTabInfo bBL() {
        return this.hiN;
    }

    public void a(NavTabInfo navTabInfo) {
        this.hiN = navTabInfo;
    }

    public boolean bBM() {
        return this.grW;
    }

    public void np(boolean z) {
        this.grW = z;
    }

    public com.baidu.tbadk.core.data.l bBN() {
        return this.hjc;
    }

    public void a(com.baidu.tbadk.core.data.l lVar) {
        this.hjc = lVar;
    }

    public int abZ() {
        return this.mSortType;
    }

    public Integer bBO() {
        return this.hiW;
    }

    public void q(Integer num) {
        this.hiW = num;
    }

    public List<Integer> bBP() {
        return this.hjg;
    }

    public void dJ(List<Integer> list) {
        this.hjg = list;
    }

    public List<com.baidu.adp.widget.ListView.h> bBQ() {
        return this.hjh;
    }

    public void dK(List<com.baidu.adp.widget.ListView.h> list) {
        this.hjh = list;
    }

    public com.baidu.tieba.h.b bBR() {
        return this.hjl;
    }

    public void a(com.baidu.tieba.h.b bVar) {
        this.hjl = bVar;
    }

    public AlaLiveNotify bBS() {
        return this.hjn;
    }

    public void a(AlaLiveNotify alaLiveNotify) {
        this.hjn = alaLiveNotify;
    }

    public List<FrsTabInfo> bBT() {
        return this.hjo;
    }

    public void dL(List<FrsTabInfo> list) {
        this.hjo = list;
    }

    public void vp(int i) {
        this.hjp = i;
    }

    public int bBU() {
        return this.hjp;
    }

    public void a(com.baidu.tieba.frs.q qVar) {
        this.hjr = qVar;
    }

    public com.baidu.tieba.frs.q bBV() {
        return this.hjr;
    }

    public k bBW() {
        return this.hjs;
    }

    public void a(k kVar) {
        this.hjs = kVar;
    }

    public e bBX() {
        return this.hji;
    }

    public void b(e eVar) {
        this.hji = eVar;
    }

    public f bBY() {
        return this.hjj;
    }

    public void b(f fVar) {
        this.hjj = fVar;
    }

    public WorldcupSkin bBZ() {
        return this.hjx;
    }

    public com.baidu.tieba.tbadkCore.data.m bCa() {
        return this.hjB;
    }

    public void d(com.baidu.tieba.tbadkCore.data.m mVar) {
        this.hjB = mVar;
    }
}

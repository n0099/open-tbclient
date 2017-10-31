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
import com.baidu.tbadk.core.data.af;
import com.baidu.tbadk.core.data.ap;
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.data.ay;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.w;
import com.baidu.tbadk.core.data.y;
import com.baidu.tbadk.core.data.z;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.am;
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
import tbclient.FrsPage.ForumHeadIcon;
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
    private AntiData Xe;
    protected ap dRK;
    protected ForumData eGf;
    private UserData eGm;
    private String gameName;
    protected List<Long> gmJ;
    private h gmK;
    protected boolean gmL;
    protected String gmM;
    protected k gmN;
    private b gmO;
    private boolean gmP;
    private List<PhotoLiveCardData> gmS;
    private int gmT;
    private PhotoLiveCardData gmU;
    private String gmV;
    private z gmX;
    private List<FrsTabInfo> gmZ;
    private ForumHeadIcon gnA;
    private com.baidu.tieba.frs.q gnB;
    private i gnC;
    private NavTabInfo gna;
    private List<FeedForumData> gnc;
    private List<CategoryInfo> gnd;
    private bh gnl;
    private ay gnm;
    private com.baidu.tbadk.core.data.m gno;
    private List<Integer> gns;
    private List<com.baidu.adp.widget.ListView.f> gnt;
    public PopInfo gnu;
    private com.baidu.tieba.g.b gnv;
    private AgreeBanner gnw;
    protected List<com.baidu.adp.widget.ListView.f> gnx;
    private AlaLiveNotify gny;
    private List<FrsTabInfo> gnz;
    private int mSortType;
    protected ArrayList<com.baidu.adp.widget.ListView.f> threadList;
    private HashMap<String, MetaData> userMap;
    public int gmI = 0;
    private List<e> gmQ = new ArrayList();
    private int gmR = 0;
    private ArrayList<com.baidu.tbadk.core.data.o> gmW = new ArrayList<>();
    protected com.baidu.tbadk.core.data.r gmY = null;
    private int gnb = 1;
    private String gne = null;
    private y gnf = null;
    public aa gng = null;
    private com.baidu.tbadk.core.data.s gnh = null;
    private Integer gni = -1;
    public w gnj = null;
    private com.baidu.tbadk.core.data.u gnk = null;
    private int gnn = -1;
    protected List<com.baidu.adp.widget.ListView.f> gnp = null;
    private int gnq = 0;
    private int gnr = 0;
    private int alaLiveCount = 0;

    public g() {
        initData();
    }

    private void initData() {
        this.eGf = new ForumData();
        this.threadList = new ArrayList<>();
        this.gnp = new ArrayList();
        this.userMap = new HashMap<>();
        this.dRK = new ap();
        this.gmK = new h();
        this.eGm = new UserData();
        this.gmN = new k();
        d(new AntiData());
        a(new b());
        this.gnt = new ArrayList();
        this.gns = new ArrayList();
    }

    public FrsPageResIdl C(byte[] bArr) {
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
                if (!com.baidu.tbadk.core.util.v.v(dataRes.color_egg)) {
                    for (ColorEgg colorEgg : dataRes.color_egg) {
                        if (colorEgg != null && !com.baidu.tbadk.core.util.v.v(colorEgg.holiday_words)) {
                            com.baidu.tbadk.core.data.o oVar = new com.baidu.tbadk.core.data.o();
                            if (oVar.a(colorEgg)) {
                                this.gmW.add(oVar);
                            }
                        }
                    }
                }
                if (dataRes.activityhead != null && !com.baidu.tbadk.core.util.v.v(dataRes.activityhead.head_imgs)) {
                    this.gmY = new com.baidu.tbadk.core.data.r();
                    this.gmY.a(dataRes.activityhead);
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
                pp(dataRes.is_new_url.intValue());
                this.gmL = dataRes.fortune_bag.intValue() == 1;
                this.gmM = dataRes.fortune_desc;
                if (dataRes.forum != null) {
                    this.gmP = dataRes.forum.has_game.intValue() == 1;
                    this.gmV = dataRes.forum.game_url;
                    this.gameName = dataRes.forum.game_name;
                }
                List<StarEnter> list2 = dataRes.star_enter;
                this.gmQ.clear();
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        e eVar = new e();
                        eVar.a(list2.get(i2));
                        this.gmQ.add(eVar);
                    }
                }
                this.gmN.a(dataRes.gcon_account);
                this.eGf.parserProtobuf(dataRes.forum);
                long longValue = dataRes.forum != null ? dataRes.forum.id.longValue() : 0L;
                this.gmJ = dataRes.thread_id_list;
                this.Xe.parserProtobuf(dataRes.anti);
                this.gmO.a(dataRes.group);
                this.dRK.a(dataRes.page);
                this.gmK.a(dataRes.frs_star);
                this.eGm.parserProtobuf(dataRes.user);
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.eGm.getIsSelectTail());
                }
                this.gmZ = dataRes.frs_tab_info;
                if (dataRes.nav_tab_info == null) {
                    NavTabInfo.Builder builder = new NavTabInfo.Builder();
                    builder.tab = dataRes.frs_tab_info;
                    this.gna = builder.build(true);
                } else {
                    this.gna = dataRes.nav_tab_info;
                }
                this.alaLiveCount = dataRes.ala_live_count.intValue();
                tF(dataRes.frs_tab_default.intValue());
                List<ZhiBoInfoTW> list3 = dataRes.twzhibo_info;
                if (list3 != null && list3.size() > 0) {
                    this.gmS = new ArrayList();
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
                        this.gmS.add(photoLiveCardData);
                    }
                }
                this.gmT = dataRes.twzhibo_pos.intValue();
                if (dataRes.hot_twzhibo_info != null) {
                    this.gmU = new PhotoLiveCardData();
                    if (this.gmU.getShowStyle() < 0) {
                        PhotoLiveCardData photoLiveCardData2 = this.gmU;
                        this.gmU.setShowStyle(PhotoLiveCardData.getRandom(3, -1));
                    }
                    this.gmU.getShowStyle();
                    this.gmU.parserProtobuf(dataRes.hot_twzhibo_info);
                    this.gmU.setShowExpressionViewIndexList(this.gmU.getExpressionDatas());
                }
                a(dataRes.thread_list, longValue);
                this.gnd = dataRes.category_list;
                if (!am.isEmpty(dataRes.bawu_enter_url)) {
                    this.gne = dataRes.bawu_enter_url;
                }
                if (dataRes.head_sdk != null) {
                    this.gnf = new y();
                    this.gnf.a(dataRes.head_sdk);
                }
                if (dataRes.recommend_book != null) {
                    this.gng = new aa();
                    this.gng.a(dataRes.recommend_book);
                }
                if (dataRes.book_info != null) {
                    this.gnh = new com.baidu.tbadk.core.data.s();
                    this.gnh.a(dataRes.book_info);
                }
                if (dataRes.forum_present_info != null) {
                    this.gnj = new w();
                    this.gnj.a(dataRes.forum_present_info);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.gnk = new com.baidu.tbadk.core.data.u();
                    this.gnk.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.ntspread != null) {
                    this.gmX = new z();
                    this.gmX.a(dataRes.ntspread);
                }
                if (dataRes.card_shipin_info != null && dataRes.card_shipin_info.size() > 0) {
                    this.gnl = new bh();
                    this.gnl.am(true);
                    this.gnl.bW(this.gmT);
                    this.gnl.setUserMap(this.userMap);
                    this.gnl.a(dataRes.card_shipin_info.get(0));
                    this.gnl.sc();
                    if (this.gnl.getFid() == 0 && longValue != 0) {
                        this.gnl.setFid(longValue);
                    }
                    this.gnl.i(this.gmW);
                    this.gnl.al(!this.gnl.qY());
                    if (this.gnl.rt() != null && this.gnl.rt().getPendantData() == null && (metaData = this.userMap.get(this.gnl.rt().getUserId())) != null && metaData.getPendantData() != null) {
                        com.baidu.tbadk.data.k kVar = new com.baidu.tbadk.data.k();
                        kVar.Q(metaData.getPendantData().Cj());
                        kVar.cF(metaData.getPendantData().pQ());
                        this.gnl.rt().setPendantData(kVar);
                    }
                }
                if (dataRes.school_recom_info != null) {
                    this.gnn = dataRes.school_recom_pos.intValue();
                    this.gnm = new ay();
                    this.gnm.a(dataRes.school_recom_info);
                }
                if (dataRes.carrier_enter != null) {
                    this.gno = new com.baidu.tbadk.core.data.m();
                    this.gno.a(dataRes.carrier_enter);
                }
                if (dataRes.vitality_info != null && dataRes.vitality_info.frequently_forum_info != null) {
                    this.gnq = dataRes.vitality_info.frequently_forum_info.forum_state.intValue();
                    this.gnr = dataRes.vitality_info.frequently_forum_info.access_flag.intValue();
                }
                this.mSortType = dataRes.sort_type.intValue();
                this.gmI = dataRes.need_log.intValue();
                com.baidu.tieba.recapp.e.a.bjF().ru(dataRes.asp_shown_info);
                this.gns = dataRes.card_shipin_pos;
                if (dataRes.card_shipin_new != null) {
                    for (int i5 = 0; i5 < dataRes.card_shipin_new.size(); i5++) {
                        bh bhVar = new bh();
                        if (this.gns != null && this.gns.size() >= dataRes.card_shipin_new.size()) {
                            bhVar.bW(this.gns.get(i5).intValue());
                        }
                        bhVar.am(true);
                        bhVar.a(dataRes.card_shipin_new.get(i5));
                        this.gnt.add(bhVar);
                    }
                }
                this.gnu = dataRes.enter_pop_info;
                if (dataRes.esport != null) {
                    this.gnv = new com.baidu.tieba.g.b();
                    this.gnv.a(dataRes.esport);
                }
                if (TbadkCoreApplication.isLogin() && dataRes.banner_user_story != null && dataRes.banner_user_story._switch.intValue() == 1 && dataRes.forum != null) {
                    com.baidu.tbadk.data.f fVar = new com.baidu.tbadk.data.f();
                    fVar.a(dataRes.banner_user_story, 0L, dataRes.forum.id.longValue(), dataRes.forum.name, true);
                    this.gnx = fVar.getList();
                    MessageManager.getInstance().sendMessageFromBackground(new CustomMessage((int) CmdConfigCustom.CMD_STORY_READ_CACHE, Long.valueOf(longValue)));
                }
                this.gnw = dataRes.agree_banner;
                if (dataRes.user_extend != null) {
                    this.gnB = new com.baidu.tieba.frs.q();
                    this.gnB.a(dataRes.user_extend);
                }
                this.gny = dataRes.live_frs_notify;
                this.gnz = dataRes.frs_game_tab_info;
                this.gnA = dataRes.forum_head_icon;
                if (dataRes.video != null && dataRes.video.video_act != null) {
                    this.gnC = new i();
                    this.gnC.a(dataRes.video.video_act);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public List<com.baidu.adp.widget.ListView.f> bsq() {
        return this.gnx;
    }

    public void dh(List<com.baidu.adp.widget.ListView.f> list) {
        this.gnx = list;
    }

    public AgreeBanner bsr() {
        return this.gnw;
    }

    public void a(AgreeBanner agreeBanner) {
        this.gnw = agreeBanner;
    }

    public ForumHeadIcon bss() {
        return this.gnA;
    }

    public void a(ForumHeadIcon forumHeadIcon) {
        this.gnA = forumHeadIcon;
    }

    private void tF(int i) {
        this.gnb = 1;
        if (this.gmZ != null && this.gmZ.size() > 0) {
            for (FrsTabInfo frsTabInfo : this.gmZ) {
                if (frsTabInfo != null && frsTabInfo.tab_id.intValue() == i) {
                    this.gnb = i;
                    return;
                }
            }
        }
    }

    public void a(List<ThreadInfo> list, long j) {
        if (list != null) {
            boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
            for (int i = 0; i < list.size(); i++) {
                bh bhVar = new bh();
                bhVar.setUserMap(this.userMap);
                bhVar.a(list.get(i));
                bhVar.bX(3);
                bhVar.sc();
                if (bhVar.getFid() == 0 && j != 0) {
                    bhVar.setFid(j);
                }
                if (StringUtils.isNull(bhVar.rz())) {
                    bhVar.cH(this.eGf.getName());
                }
                bhVar.i(this.gmW);
                if (bhVar.getThreadType() == 33 && !bhVar.rV()) {
                    av avVar = new av();
                    avVar.a(bhVar, 0);
                    avVar.r(bsF());
                    if (appResponseToIntentClass) {
                        this.threadList.add(avVar);
                    }
                } else if (!TextUtils.isEmpty(bhVar.sq())) {
                    af afVar = new af();
                    afVar.cC(bhVar.sq());
                    this.threadList.add(afVar);
                } else {
                    this.threadList.add(bhVar);
                }
            }
        }
    }

    public int bst() {
        return this.alaLiveCount;
    }

    public void tG(int i) {
        this.alaLiveCount = i;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] EI() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public boolean x(byte[] bArr) {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void k(JSONObject jSONObject) {
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void a(Message message) {
    }

    public ForumData aPM() {
        return this.eGf;
    }

    public int bsu() {
        return this.gnq;
    }

    public void tH(int i) {
        this.gnq = i;
    }

    public int bsv() {
        return this.gnr;
    }

    public void tI(int i) {
        this.gnr = i;
    }

    public void c(ForumData forumData) {
        this.eGf = forumData;
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> getThreadList() {
        return this.threadList;
    }

    public void az(ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        this.threadList = arrayList;
    }

    public AntiData qf() {
        return this.Xe;
    }

    public void d(AntiData antiData) {
        this.Xe = antiData;
    }

    public ap qv() {
        return this.dRK;
    }

    public void a(ap apVar) {
        this.dRK = apVar;
    }

    public h bsw() {
        return this.gmK;
    }

    public void a(h hVar) {
        this.gmK = hVar;
    }

    public com.baidu.tbadk.core.data.r bsx() {
        return this.gmY;
    }

    public void a(com.baidu.tbadk.core.data.r rVar) {
        this.gmY = rVar;
    }

    public boolean bsy() {
        return this.gmL;
    }

    public void mr(boolean z) {
        this.gmL = z;
    }

    public String bsz() {
        return this.gmM;
    }

    public void sk(String str) {
        this.gmM = str;
    }

    public k bsA() {
        return this.gmN;
    }

    public void a(k kVar) {
        this.gmN = kVar;
    }

    public UserData getUserData() {
        return this.eGm;
    }

    public void f(UserData userData) {
        this.eGm = userData;
    }

    public List<Long> bsB() {
        return this.gmJ;
    }

    public void di(List<Long> list) {
        this.gmJ = list;
    }

    public b bsC() {
        return this.gmO;
    }

    public void a(b bVar) {
        this.gmO = bVar;
    }

    public boolean bsD() {
        return this.gmP;
    }

    public void ms(boolean z) {
        this.gmP = z;
    }

    public String getGameName() {
        return this.gameName;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public List<e> bsE() {
        return this.gmQ;
    }

    public void dj(List<e> list) {
        this.gmQ = list;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public int aQa() {
        return this.gmR;
    }

    public void pp(int i) {
        this.gmR = i;
    }

    public List<PhotoLiveCardData> bsF() {
        return this.gmS;
    }

    public String bsG() {
        return this.gmV;
    }

    public void sl(String str) {
        this.gmV = str;
    }

    public List<FrsTabInfo> bsH() {
        return this.gmZ;
    }

    public void dk(List<FrsTabInfo> list) {
        this.gmZ = list;
    }

    public void dl(List<PhotoLiveCardData> list) {
        this.gmS = list;
    }

    public boolean bsI() {
        return this.gmU != null;
    }

    public PhotoLiveCardData bsJ() {
        return this.gmU;
    }

    public void c(PhotoLiveCardData photoLiveCardData) {
        this.gmU = photoLiveCardData;
    }

    public z bsK() {
        return this.gmX;
    }

    public void a(z zVar) {
        this.gmX = zVar;
    }

    public int bsL() {
        return this.gmT;
    }

    public void tJ(int i) {
        this.gmT = i;
    }

    public List<FeedForumData> bsM() {
        return this.gnc;
    }

    public void dm(List<FeedForumData> list) {
        this.gnc = list;
    }

    public void sm(String str) {
        if (this.gnc != null && str != null) {
            for (FeedForumData feedForumData : this.gnc) {
                if (feedForumData != null && feedForumData.getForumId() != null && feedForumData.getForumId().equals(str)) {
                    this.gnc.remove(feedForumData);
                    return;
                }
            }
        }
    }

    public List<CategoryInfo> bsN() {
        return this.gnd;
    }

    public void dn(List<CategoryInfo> list) {
        this.gnd = list;
    }

    public void sn(String str) {
        this.gne = str;
    }

    public String bsO() {
        return this.gne;
    }

    public bh bsP() {
        return this.gnl;
    }

    public void ah(bh bhVar) {
        this.gnl = bhVar;
    }

    public int bsQ() {
        return this.gnb;
    }

    public void tK(int i) {
        this.gnb = i;
    }

    public y bsR() {
        return this.gnf;
    }

    public void a(y yVar) {
        this.gnf = yVar;
    }

    public com.baidu.tbadk.core.data.s bsS() {
        return this.gnh;
    }

    public void a(com.baidu.tbadk.core.data.s sVar) {
        this.gnh = sVar;
    }

    public com.baidu.tbadk.core.data.u bsT() {
        return this.gnk;
    }

    public void a(com.baidu.tbadk.core.data.u uVar) {
        this.gnk = uVar;
    }

    public int bsU() {
        return this.gnn;
    }

    public void tL(int i) {
        this.gnn = i;
    }

    public ay bsV() {
        return this.gnm;
    }

    public void a(ay ayVar) {
        this.gnm = ayVar;
    }

    public NavTabInfo bsW() {
        return this.gna;
    }

    public void a(NavTabInfo navTabInfo) {
        this.gna = navTabInfo;
    }

    public com.baidu.tbadk.core.data.m bsX() {
        return this.gno;
    }

    public void a(com.baidu.tbadk.core.data.m mVar) {
        this.gno = mVar;
    }

    public Integer bsY() {
        return this.gni;
    }

    public void j(Integer num) {
        this.gni = num;
    }

    public List<Integer> bsZ() {
        return this.gns;
    }

    /* renamed from: do  reason: not valid java name */
    public void m12do(List<Integer> list) {
        this.gns = list;
    }

    public List<com.baidu.adp.widget.ListView.f> bta() {
        return this.gnt;
    }

    public void dp(List<com.baidu.adp.widget.ListView.f> list) {
        this.gnt = list;
    }

    public com.baidu.tieba.g.b btb() {
        return this.gnv;
    }

    public void a(com.baidu.tieba.g.b bVar) {
        this.gnv = bVar;
    }

    public AlaLiveNotify btc() {
        return this.gny;
    }

    public void a(AlaLiveNotify alaLiveNotify) {
        this.gny = alaLiveNotify;
    }

    public List<FrsTabInfo> btd() {
        return this.gnz;
    }

    public void dq(List<FrsTabInfo> list) {
        this.gnz = list;
    }

    public void a(com.baidu.tieba.frs.q qVar) {
        this.gnB = qVar;
    }

    public com.baidu.tieba.frs.q bte() {
        return this.gnB;
    }

    public i btf() {
        return this.gnC;
    }

    public void a(i iVar) {
        this.gnC = iVar;
    }
}

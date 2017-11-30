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
import com.baidu.tbadk.core.data.ab;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.au;
import com.baidu.tbadk.core.data.bd;
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
public class h implements com.baidu.tbadk.mvc.b.c {
    public static final Wire WIRE = new Wire(new Class[0]);
    private AntiData Xx;
    protected al dZC;
    protected ForumData eOi;
    private UserData eOp;
    private String gameName;
    protected List<Long> gwE;
    private i gwF;
    protected boolean gwG;
    protected String gwH;
    protected l gwI;
    private b gwJ;
    private boolean gwK;
    private List<PhotoLiveCardData> gwN;
    private int gwO;
    private PhotoLiveCardData gwP;
    private String gwQ;
    private List<FrsTabInfo> gwT;
    private NavTabInfo gwU;
    private List<FeedForumData> gwW;
    private List<CategoryInfo> gwX;
    private bd gxf;
    private au gxg;
    private com.baidu.tbadk.core.data.l gxi;
    private List<Integer> gxm;
    private List<com.baidu.adp.widget.ListView.f> gxn;
    private e gxo;
    public PopInfo gxp;
    private com.baidu.tieba.g.b gxq;
    private AgreeBanner gxr;
    protected List<com.baidu.adp.widget.ListView.f> gxs;
    private AlaLiveNotify gxt;
    private List<FrsTabInfo> gxu;
    private ForumHeadIcon gxw;
    private com.baidu.tieba.frs.q gxx;
    private j gxy;
    public FrsTabInfo gxz;
    private int mSortType;
    protected ArrayList<com.baidu.adp.widget.ListView.f> threadList;
    private HashMap<String, MetaData> userMap;
    public int gwD = 0;
    private List<f> gwL = new ArrayList();
    private int gwM = 0;
    private ArrayList<com.baidu.tbadk.core.data.n> gwR = new ArrayList<>();
    protected com.baidu.tbadk.core.data.o gwS = null;
    private int gwV = 1;
    private String gwY = null;
    private com.baidu.tbadk.core.data.v gwZ = null;
    public com.baidu.tbadk.core.data.w gxa = null;
    private com.baidu.tbadk.core.data.p gxb = null;
    private Integer gxc = -1;
    public com.baidu.tbadk.core.data.t gxd = null;
    private com.baidu.tbadk.core.data.r gxe = null;
    private int gxh = -1;
    protected List<com.baidu.adp.widget.ListView.f> gxj = null;
    private int gxk = 0;
    private int gxl = 0;
    private int alaLiveCount = 0;
    private int gxv = 0;

    public h() {
        initData();
    }

    private void initData() {
        this.eOi = new ForumData();
        this.threadList = new ArrayList<>();
        this.gxj = new ArrayList();
        this.userMap = new HashMap<>();
        this.dZC = new al();
        this.gwF = new i();
        this.eOp = new UserData();
        this.gwI = new l();
        c(new AntiData());
        a(new b());
        this.gxn = new ArrayList();
        this.gxm = new ArrayList();
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
                if (!com.baidu.tbadk.core.util.v.w(dataRes.color_egg)) {
                    for (ColorEgg colorEgg : dataRes.color_egg) {
                        if (colorEgg != null && !com.baidu.tbadk.core.util.v.w(colorEgg.holiday_words)) {
                            com.baidu.tbadk.core.data.n nVar = new com.baidu.tbadk.core.data.n();
                            if (nVar.a(colorEgg)) {
                                this.gwR.add(nVar);
                            }
                        }
                    }
                }
                if (dataRes.activityhead != null && !com.baidu.tbadk.core.util.v.w(dataRes.activityhead.head_imgs)) {
                    this.gwS = new com.baidu.tbadk.core.data.o();
                    this.gwS.a(dataRes.activityhead);
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
                pC(dataRes.is_new_url.intValue());
                this.gwG = dataRes.fortune_bag.intValue() == 1;
                this.gwH = dataRes.fortune_desc;
                if (dataRes.forum != null) {
                    this.gwK = dataRes.forum.has_game.intValue() == 1;
                    this.gwQ = dataRes.forum.game_url;
                    this.gameName = dataRes.forum.game_name;
                }
                List<StarEnter> list2 = dataRes.star_enter;
                this.gwL.clear();
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        f fVar = new f();
                        fVar.a(list2.get(i2));
                        this.gwL.add(fVar);
                    }
                }
                this.gwI.a(dataRes.gcon_account);
                this.eOi.parserProtobuf(dataRes.forum);
                long longValue = dataRes.forum != null ? dataRes.forum.id.longValue() : 0L;
                this.gwE = dataRes.thread_id_list;
                this.Xx.parserProtobuf(dataRes.anti);
                this.gwJ.a(dataRes.group);
                this.dZC.a(dataRes.page);
                this.gwF.a(dataRes.frs_star);
                this.eOp.parserProtobuf(dataRes.user);
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.eOp.getIsSelectTail());
                }
                this.gwT = dataRes.frs_tab_info;
                if (dataRes.nav_tab_info == null) {
                    NavTabInfo.Builder builder = new NavTabInfo.Builder();
                    builder.tab = dataRes.frs_tab_info;
                    this.gwU = builder.build(true);
                } else {
                    this.gwU = dataRes.nav_tab_info;
                }
                if (this.gwU.head != null && !com.baidu.tbadk.core.util.v.w(this.gwU.head)) {
                    this.gxz = this.gwU.head.get(0);
                }
                this.alaLiveCount = dataRes.ala_live_count.intValue();
                tY(dataRes.frs_tab_default.intValue());
                List<ZhiBoInfoTW> list3 = dataRes.twzhibo_info;
                if (list3 != null && list3.size() > 0) {
                    this.gwN = new ArrayList();
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
                        this.gwN.add(photoLiveCardData);
                    }
                }
                this.gwO = dataRes.twzhibo_pos.intValue();
                if (dataRes.hot_twzhibo_info != null) {
                    this.gwP = new PhotoLiveCardData();
                    if (this.gwP.getShowStyle() < 0) {
                        PhotoLiveCardData photoLiveCardData2 = this.gwP;
                        this.gwP.setShowStyle(PhotoLiveCardData.getRandom(3, -1));
                    }
                    this.gwP.getShowStyle();
                    this.gwP.parserProtobuf(dataRes.hot_twzhibo_info);
                    this.gwP.setShowExpressionViewIndexList(this.gwP.getExpressionDatas());
                }
                a(dataRes.thread_list, longValue);
                this.gwX = dataRes.category_list;
                if (!am.isEmpty(dataRes.bawu_enter_url)) {
                    this.gwY = dataRes.bawu_enter_url;
                }
                if (dataRes.head_sdk != null) {
                    this.gwZ = new com.baidu.tbadk.core.data.v();
                    this.gwZ.a(dataRes.head_sdk);
                }
                if (dataRes.recommend_book != null) {
                    this.gxa = new com.baidu.tbadk.core.data.w();
                    this.gxa.a(dataRes.recommend_book);
                }
                if (dataRes.book_info != null) {
                    this.gxb = new com.baidu.tbadk.core.data.p();
                    this.gxb.a(dataRes.book_info);
                }
                if (dataRes.forum_present_info != null) {
                    this.gxd = new com.baidu.tbadk.core.data.t();
                    this.gxd.a(dataRes.forum_present_info);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.gxe = new com.baidu.tbadk.core.data.r();
                    this.gxe.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.card_shipin_info != null && dataRes.card_shipin_info.size() > 0) {
                    this.gxf = new bd();
                    this.gxf.am(true);
                    this.gxf.bX(this.gwO);
                    this.gxf.setUserMap(this.userMap);
                    this.gxf.a(dataRes.card_shipin_info.get(0));
                    this.gxf.sf();
                    if (this.gxf.getFid() == 0 && longValue != 0) {
                        this.gxf.setFid(longValue);
                    }
                    this.gxf.i(this.gwR);
                    this.gxf.al(!this.gxf.rc());
                    if (this.gxf.rx() != null && this.gxf.rx().getPendantData() == null && (metaData = this.userMap.get(this.gxf.rx().getUserId())) != null && metaData.getPendantData() != null) {
                        com.baidu.tbadk.data.k kVar = new com.baidu.tbadk.data.k();
                        kVar.T(metaData.getPendantData().CE());
                        kVar.cF(metaData.getPendantData().pT());
                        this.gxf.rx().setPendantData(kVar);
                    }
                }
                if (dataRes.ala_live_insert != null && dataRes.ala_live_insert.ala_live_list != null && dataRes.ala_live_insert.ala_live_list.size() > 0) {
                    this.gxo = new e();
                    this.gxo.gwc = dataRes.ala_insert_floor.intValue();
                    ArrayList arrayList = new ArrayList();
                    for (int i5 = 0; i5 < dataRes.ala_live_insert.ala_live_list.size(); i5++) {
                        if (dataRes.ala_live_insert.ala_live_list.get(i5) != null) {
                            bd bdVar = new bd();
                            bdVar.a(dataRes.ala_live_insert.ala_live_list.get(i5));
                            arrayList.add(bdVar);
                        }
                    }
                    this.gxo.gwb = arrayList;
                }
                if (dataRes.school_recom_info != null) {
                    this.gxh = dataRes.school_recom_pos.intValue();
                    this.gxg = new au();
                    this.gxg.a(dataRes.school_recom_info);
                }
                if (dataRes.carrier_enter != null) {
                    this.gxi = new com.baidu.tbadk.core.data.l();
                    this.gxi.a(dataRes.carrier_enter);
                }
                if (dataRes.vitality_info != null && dataRes.vitality_info.frequently_forum_info != null) {
                    this.gxk = dataRes.vitality_info.frequently_forum_info.forum_state.intValue();
                    this.gxl = dataRes.vitality_info.frequently_forum_info.access_flag.intValue();
                }
                this.mSortType = dataRes.sort_type.intValue();
                this.gwD = dataRes.need_log.intValue();
                com.baidu.tieba.recapp.e.a.blQ().rW(dataRes.asp_shown_info);
                this.gxm = dataRes.card_shipin_pos;
                if (dataRes.card_shipin_new != null) {
                    for (int i6 = 0; i6 < dataRes.card_shipin_new.size(); i6++) {
                        bd bdVar2 = new bd();
                        if (this.gxm != null && this.gxm.size() >= dataRes.card_shipin_new.size()) {
                            bdVar2.bX(this.gxm.get(i6).intValue());
                        }
                        bdVar2.am(true);
                        bdVar2.a(dataRes.card_shipin_new.get(i6));
                        this.gxn.add(bdVar2);
                    }
                }
                this.gxp = dataRes.enter_pop_info;
                if (dataRes.esport != null) {
                    this.gxq = new com.baidu.tieba.g.b();
                    this.gxq.a(dataRes.esport);
                }
                if (TbadkCoreApplication.isLogin() && dataRes.banner_user_story != null && dataRes.banner_user_story._switch.intValue() == 1 && dataRes.forum != null) {
                    com.baidu.tbadk.data.f fVar2 = new com.baidu.tbadk.data.f();
                    fVar2.a(dataRes.banner_user_story, 0L, dataRes.forum.id.longValue(), dataRes.forum.name, true);
                    this.gxs = fVar2.getList();
                    MessageManager.getInstance().sendMessageFromBackground(new CustomMessage((int) CmdConfigCustom.CMD_STORY_READ_CACHE, Long.valueOf(longValue)));
                }
                this.gxr = dataRes.agree_banner;
                if (dataRes.user_extend != null) {
                    this.gxx = new com.baidu.tieba.frs.q();
                    this.gxx.a(dataRes.user_extend);
                }
                this.gxt = dataRes.live_frs_notify;
                this.gxu = dataRes.frs_game_tab_info;
                this.gxv = dataRes.game_default_tab_id.intValue();
                this.gxw = dataRes.forum_head_icon;
                if (dataRes.video != null && dataRes.video.video_act != null) {
                    this.gxy = new j();
                    this.gxy.a(dataRes.video.video_act);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public List<com.baidu.adp.widget.ListView.f> bui() {
        return this.gxs;
    }

    public void dt(List<com.baidu.adp.widget.ListView.f> list) {
        this.gxs = list;
    }

    public AgreeBanner buj() {
        return this.gxr;
    }

    public void a(AgreeBanner agreeBanner) {
        this.gxr = agreeBanner;
    }

    public ForumHeadIcon buk() {
        return this.gxw;
    }

    public void a(ForumHeadIcon forumHeadIcon) {
        this.gxw = forumHeadIcon;
    }

    private void tY(int i) {
        this.gwV = 1;
        if (this.gwT != null && this.gwT.size() > 0) {
            for (FrsTabInfo frsTabInfo : this.gwT) {
                if (frsTabInfo != null && frsTabInfo.tab_id.intValue() == i) {
                    this.gwV = i;
                    return;
                }
            }
        }
    }

    public void a(List<ThreadInfo> list, long j) {
        if (list != null) {
            boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
            for (int i = 0; i < list.size(); i++) {
                bd bdVar = new bd();
                bdVar.setUserMap(this.userMap);
                bdVar.a(list.get(i));
                bdVar.bY(3);
                bdVar.sf();
                if (bdVar.getFid() == 0 && j != 0) {
                    bdVar.setFid(j);
                }
                if (StringUtils.isNull(bdVar.rD())) {
                    bdVar.cH(this.eOi.getName());
                }
                bdVar.i(this.gwR);
                if (bdVar.getThreadType() == 33 && !bdVar.rY()) {
                    ar arVar = new ar();
                    arVar.a(bdVar, 0);
                    arVar.s(bux());
                    if (appResponseToIntentClass) {
                        this.threadList.add(arVar);
                    }
                } else if (!TextUtils.isEmpty(bdVar.st())) {
                    ab abVar = new ab();
                    abVar.cC(bdVar.st());
                    this.threadList.add(abVar);
                } else {
                    this.threadList.add(bdVar);
                }
            }
        }
    }

    public int bul() {
        return this.alaLiveCount;
    }

    public void tZ(int i) {
        this.alaLiveCount = i;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] Fb() {
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

    public ForumData aRf() {
        return this.eOi;
    }

    public int bum() {
        return this.gxk;
    }

    public void ua(int i) {
        this.gxk = i;
    }

    public int bun() {
        return this.gxl;
    }

    public void ub(int i) {
        this.gxl = i;
    }

    public void c(ForumData forumData) {
        this.eOi = forumData;
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> getThreadList() {
        return this.threadList;
    }

    public void az(ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        this.threadList = arrayList;
    }

    public AntiData qi() {
        return this.Xx;
    }

    public void c(AntiData antiData) {
        this.Xx = antiData;
    }

    public al qA() {
        return this.dZC;
    }

    public void a(al alVar) {
        this.dZC = alVar;
    }

    public i buo() {
        return this.gwF;
    }

    public void a(i iVar) {
        this.gwF = iVar;
    }

    public com.baidu.tbadk.core.data.o bup() {
        return this.gwS;
    }

    public void a(com.baidu.tbadk.core.data.o oVar) {
        this.gwS = oVar;
    }

    public boolean buq() {
        return this.gwG;
    }

    public void mW(boolean z) {
        this.gwG = z;
    }

    public String bur() {
        return this.gwH;
    }

    public void sM(String str) {
        this.gwH = str;
    }

    public l bus() {
        return this.gwI;
    }

    public void a(l lVar) {
        this.gwI = lVar;
    }

    public UserData getUserData() {
        return this.eOp;
    }

    public void d(UserData userData) {
        this.eOp = userData;
    }

    public List<Long> but() {
        return this.gwE;
    }

    public void du(List<Long> list) {
        this.gwE = list;
    }

    public b buu() {
        return this.gwJ;
    }

    public void a(b bVar) {
        this.gwJ = bVar;
    }

    public boolean buv() {
        return this.gwK;
    }

    public void mX(boolean z) {
        this.gwK = z;
    }

    public String getGameName() {
        return this.gameName;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public List<f> buw() {
        return this.gwL;
    }

    public void dv(List<f> list) {
        this.gwL = list;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public int aRt() {
        return this.gwM;
    }

    public void pC(int i) {
        this.gwM = i;
    }

    public List<PhotoLiveCardData> bux() {
        return this.gwN;
    }

    public String buy() {
        return this.gwQ;
    }

    public void sN(String str) {
        this.gwQ = str;
    }

    public List<FrsTabInfo> buz() {
        return this.gwT;
    }

    public void dw(List<FrsTabInfo> list) {
        this.gwT = list;
    }

    public void dx(List<PhotoLiveCardData> list) {
        this.gwN = list;
    }

    public boolean buA() {
        return this.gwP != null;
    }

    public PhotoLiveCardData buB() {
        return this.gwP;
    }

    public void c(PhotoLiveCardData photoLiveCardData) {
        this.gwP = photoLiveCardData;
    }

    public int buC() {
        return this.gwO;
    }

    public void uc(int i) {
        this.gwO = i;
    }

    public List<FeedForumData> buD() {
        return this.gwW;
    }

    public void dy(List<FeedForumData> list) {
        this.gwW = list;
    }

    public void sO(String str) {
        if (this.gwW != null && str != null) {
            for (FeedForumData feedForumData : this.gwW) {
                if (feedForumData != null && feedForumData.getForumId() != null && feedForumData.getForumId().equals(str)) {
                    this.gwW.remove(feedForumData);
                    return;
                }
            }
        }
    }

    public List<CategoryInfo> buE() {
        return this.gwX;
    }

    public void dz(List<CategoryInfo> list) {
        this.gwX = list;
    }

    public void sP(String str) {
        this.gwY = str;
    }

    public String buF() {
        return this.gwY;
    }

    public bd buG() {
        return this.gxf;
    }

    public void ai(bd bdVar) {
        this.gxf = bdVar;
    }

    public int buH() {
        return this.gwV;
    }

    public void ud(int i) {
        this.gwV = i;
    }

    public com.baidu.tbadk.core.data.v buI() {
        return this.gwZ;
    }

    public void a(com.baidu.tbadk.core.data.v vVar) {
        this.gwZ = vVar;
    }

    public com.baidu.tbadk.core.data.p buJ() {
        return this.gxb;
    }

    public void a(com.baidu.tbadk.core.data.p pVar) {
        this.gxb = pVar;
    }

    public com.baidu.tbadk.core.data.r buK() {
        return this.gxe;
    }

    public void a(com.baidu.tbadk.core.data.r rVar) {
        this.gxe = rVar;
    }

    public int buL() {
        return this.gxh;
    }

    public void ue(int i) {
        this.gxh = i;
    }

    public au buM() {
        return this.gxg;
    }

    public void a(au auVar) {
        this.gxg = auVar;
    }

    public NavTabInfo buN() {
        return this.gwU;
    }

    public void a(NavTabInfo navTabInfo) {
        this.gwU = navTabInfo;
    }

    public com.baidu.tbadk.core.data.l buO() {
        return this.gxi;
    }

    public void a(com.baidu.tbadk.core.data.l lVar) {
        this.gxi = lVar;
    }

    public Integer buP() {
        return this.gxc;
    }

    public void k(Integer num) {
        this.gxc = num;
    }

    public List<Integer> buQ() {
        return this.gxm;
    }

    public void dA(List<Integer> list) {
        this.gxm = list;
    }

    public List<com.baidu.adp.widget.ListView.f> buR() {
        return this.gxn;
    }

    public void dB(List<com.baidu.adp.widget.ListView.f> list) {
        this.gxn = list;
    }

    public com.baidu.tieba.g.b buS() {
        return this.gxq;
    }

    public void a(com.baidu.tieba.g.b bVar) {
        this.gxq = bVar;
    }

    public AlaLiveNotify buT() {
        return this.gxt;
    }

    public void a(AlaLiveNotify alaLiveNotify) {
        this.gxt = alaLiveNotify;
    }

    public List<FrsTabInfo> buU() {
        return this.gxu;
    }

    public void dC(List<FrsTabInfo> list) {
        this.gxu = list;
    }

    public void uf(int i) {
        this.gxv = i;
    }

    public int buV() {
        return this.gxv;
    }

    public void a(com.baidu.tieba.frs.q qVar) {
        this.gxx = qVar;
    }

    public com.baidu.tieba.frs.q buW() {
        return this.gxx;
    }

    public j buX() {
        return this.gxy;
    }

    public void a(j jVar) {
        this.gxy = jVar;
    }

    public e buY() {
        return this.gxo;
    }

    public void b(e eVar) {
        this.gxo = eVar;
    }
}

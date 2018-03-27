package com.baidu.tieba.tbadkCore;

import android.text.TextUtils;
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
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.ab;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.au;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.am;
import com.squareup.wire.Message;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;
import tbclient.AlaLiveNotify;
import tbclient.CategoryInfo;
import tbclient.ForumArIno;
import tbclient.FrsPage.AgreeBanner;
import tbclient.FrsPage.ColorEgg;
import tbclient.FrsPage.DataRes;
import tbclient.FrsPage.ForumHeadIcon;
import tbclient.FrsPage.FrsPageResIdl;
import tbclient.FrsPage.NavTabInfo;
import tbclient.FrsPage.RecmForumInfo;
import tbclient.FrsPage.StarEnter;
import tbclient.FrsPage.StarRank;
import tbclient.FrsTabInfo;
import tbclient.PopInfo;
import tbclient.ThreadInfo;
import tbclient.User;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class j implements com.baidu.tbadk.mvc.b.c {
    public static final Wire WIRE = new Wire(new Class[0]);
    private AntiData aNa;
    public ForumArIno dJs;
    private com.baidu.tieba.tbadkCore.data.l dYT;
    protected al eSZ;
    protected ForumData fHj;
    private UserData fHq;
    protected n gYA;
    private b gYB;
    private boolean gYC;
    private List<PhotoLiveCardData> gYF;
    private int gYG;
    private PhotoLiveCardData gYH;
    private String gYI;
    private List<FrsTabInfo> gYL;
    private NavTabInfo gYM;
    private List<FeedForumData> gYO;
    private List<CategoryInfo> gYP;
    private bd gYX;
    private au gYY;
    protected List<Long> gYw;
    private k gYx;
    protected boolean gYy;
    protected String gYz;
    private com.baidu.tbadk.core.data.l gZa;
    private List<Integer> gZe;
    private List<com.baidu.adp.widget.ListView.i> gZf;
    private f gZg;
    private g gZh;
    public PopInfo gZi;
    private com.baidu.tieba.g.b gZj;
    private AgreeBanner gZk;
    private AlaLiveNotify gZl;
    private List<FrsTabInfo> gZm;
    private ForumHeadIcon gZo;
    private com.baidu.tieba.frs.s gZp;
    private l gZq;
    public FrsTabInfo gZr;
    public StarRank gZt;
    public e gZu;
    private String gameName;
    private int mSortType;
    public List<RecmForumInfo> recm_forum_list;
    protected ArrayList<com.baidu.adp.widget.ListView.i> threadList;
    private HashMap<String, MetaData> userMap;
    public int gYv = 0;
    private List<h> gYD = new ArrayList();
    private int gYE = 0;
    private ArrayList<com.baidu.tbadk.core.data.n> gYJ = new ArrayList<>();
    protected com.baidu.tbadk.core.data.o gYK = null;
    private int gYN = 1;
    private String gYQ = null;
    private com.baidu.tbadk.core.data.w gYR = null;
    public com.baidu.tbadk.core.data.x gYS = null;
    private com.baidu.tbadk.core.data.p gYT = null;
    private Integer gYU = -1;
    public com.baidu.tbadk.core.data.u gYV = null;
    private com.baidu.tbadk.core.data.r gYW = null;
    private int gYZ = -1;
    protected List<com.baidu.adp.widget.ListView.i> gZb = null;
    private int gZc = 0;
    private int gZd = 0;
    private int alaLiveCount = 0;
    private int gZn = 0;
    public int gZs = 0;

    public j() {
        initData();
    }

    private void initData() {
        this.fHj = new ForumData();
        this.threadList = new ArrayList<>();
        this.gZb = new ArrayList();
        this.userMap = new HashMap<>();
        this.eSZ = new al();
        this.gYx = new k();
        this.fHq = new UserData();
        this.gYA = new n();
        c(new AntiData());
        a(new b());
        this.gZf = new ArrayList();
        this.gZe = new ArrayList();
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
                if (!com.baidu.tbadk.core.util.v.E(dataRes.color_egg)) {
                    for (ColorEgg colorEgg : dataRes.color_egg) {
                        if (colorEgg != null && !com.baidu.tbadk.core.util.v.E(colorEgg.holiday_words)) {
                            com.baidu.tbadk.core.data.n nVar = new com.baidu.tbadk.core.data.n();
                            if (nVar.a(colorEgg)) {
                                this.gYJ.add(nVar);
                            }
                        }
                    }
                }
                if (dataRes.activityhead != null && !com.baidu.tbadk.core.util.v.E(dataRes.activityhead.head_imgs)) {
                    this.gYK = new com.baidu.tbadk.core.data.o();
                    this.gYK.a(dataRes.activityhead);
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
                sA(dataRes.is_new_url.intValue());
                this.gYy = dataRes.fortune_bag.intValue() == 1;
                this.gYz = dataRes.fortune_desc;
                if (dataRes.forum != null) {
                    this.gYC = dataRes.forum.has_game.intValue() == 1;
                    this.gYI = dataRes.forum.game_url;
                    this.gameName = dataRes.forum.game_name;
                }
                List<StarEnter> list2 = dataRes.star_enter;
                this.gYD.clear();
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        h hVar = new h();
                        hVar.a(list2.get(i2));
                        this.gYD.add(hVar);
                    }
                }
                this.gYA.a(dataRes.gcon_account);
                this.fHj.parserProtobuf(dataRes.forum);
                long longValue = dataRes.forum != null ? dataRes.forum.id.longValue() : 0L;
                this.gYw = dataRes.thread_id_list;
                this.aNa.parserProtobuf(dataRes.anti);
                if (dataRes.anti != null) {
                    com.baidu.tieba.p.a.e(dataRes.anti.block_pop_info);
                }
                this.gYB.a(dataRes.group);
                this.eSZ.a(dataRes.page);
                this.gYx.a(dataRes.frs_star);
                this.fHq.parserProtobuf(dataRes.user);
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.fHq.getIsSelectTail());
                }
                this.gYL = dataRes.frs_tab_info;
                if (dataRes.nav_tab_info == null) {
                    NavTabInfo.Builder builder = new NavTabInfo.Builder();
                    builder.tab = dataRes.frs_tab_info;
                    this.gYM = builder.build(true);
                } else {
                    this.gYM = dataRes.nav_tab_info;
                }
                if (this.gYM.head != null && !com.baidu.tbadk.core.util.v.E(this.gYM.head)) {
                    this.gZr = this.gYM.head.get(0);
                }
                this.alaLiveCount = dataRes.ala_live_count.intValue();
                vz(dataRes.frs_tab_default.intValue());
                List<ZhiBoInfoTW> list3 = dataRes.twzhibo_info;
                if (list3 != null && list3.size() > 0) {
                    this.gYF = new ArrayList();
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
                        this.gYF.add(photoLiveCardData);
                    }
                }
                this.gYG = dataRes.twzhibo_pos.intValue();
                if (dataRes.hot_twzhibo_info != null) {
                    this.gYH = new PhotoLiveCardData();
                    if (this.gYH.getShowStyle() < 0) {
                        PhotoLiveCardData photoLiveCardData2 = this.gYH;
                        this.gYH.setShowStyle(PhotoLiveCardData.getRandom(3, -1));
                    }
                    this.gYH.getShowStyle();
                    this.gYH.parserProtobuf(dataRes.hot_twzhibo_info);
                    this.gYH.setShowExpressionViewIndexList(this.gYH.getExpressionDatas());
                }
                if (dataRes.activity_config != null && dataRes.activity_config.activity_id.longValue() != 0) {
                    this.gZu = new e();
                    this.gZu.a(dataRes.activity_config);
                    if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("frs_activity_switch_" + dataRes.activity_config.activity_id, false)) {
                        this.gZu.setType(0);
                    }
                }
                a(dataRes.thread_list, longValue);
                this.gYP = dataRes.category_list;
                if (!am.isEmpty(dataRes.bawu_enter_url)) {
                    this.gYQ = dataRes.bawu_enter_url;
                }
                if (dataRes.head_sdk != null) {
                    this.gYR = new com.baidu.tbadk.core.data.w();
                    this.gYR.a(dataRes.head_sdk);
                }
                if (dataRes.recommend_book != null) {
                    this.gYS = new com.baidu.tbadk.core.data.x();
                    this.gYS.a(dataRes.recommend_book);
                }
                if (dataRes.book_info != null) {
                    this.gYT = new com.baidu.tbadk.core.data.p();
                    this.gYT.a(dataRes.book_info);
                }
                if (dataRes.forum_present_info != null) {
                    this.gYV = new com.baidu.tbadk.core.data.u();
                    this.gYV.a(dataRes.forum_present_info);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.gYW = new com.baidu.tbadk.core.data.r();
                    this.gYW.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.card_shipin_info != null && dataRes.card_shipin_info.size() > 0) {
                    this.gYX = new bd();
                    this.gYX.aX(true);
                    this.gYX.eV(this.gYG);
                    this.gYX.setUserMap(this.userMap);
                    this.gYX.a(dataRes.card_shipin_info.get(0));
                    this.gYX.zW();
                    if (this.gYX.getFid() == 0 && longValue != 0) {
                        this.gYX.setFid(longValue);
                    }
                    this.gYX.j(this.gYJ);
                    this.gYX.aW(!this.gYX.yU());
                    if (this.gYX.zn() != null && this.gYX.zn().getPendantData() == null && (metaData = this.userMap.get(this.gYX.zn().getUserId())) != null && metaData.getPendantData() != null) {
                        com.baidu.tbadk.data.h hVar2 = new com.baidu.tbadk.data.h();
                        hVar2.ab(metaData.getPendantData().KE());
                        hVar2.cX(metaData.getPendantData().ya());
                        this.gYX.zn().setPendantData(hVar2);
                    }
                }
                if (dataRes.ala_live_insert != null && dataRes.ala_live_insert.ala_live_list != null && dataRes.ala_live_insert.ala_live_list.size() > 0) {
                    this.gZg = new f();
                    this.gZg.gXS = dataRes.ala_insert_floor.intValue();
                    ArrayList arrayList = new ArrayList();
                    for (int i5 = 0; i5 < dataRes.ala_live_insert.ala_live_list.size(); i5++) {
                        if (dataRes.ala_live_insert.ala_live_list.get(i5) != null) {
                            bd bdVar = new bd();
                            bdVar.a(dataRes.ala_live_insert.ala_live_list.get(i5));
                            arrayList.add(bdVar);
                        }
                    }
                    this.gZg.gXR = arrayList;
                }
                if (dataRes.ala_stage_list != null) {
                    this.gZh = new g();
                    ArrayList arrayList2 = new ArrayList();
                    for (int i6 = 0; i6 < dataRes.ala_stage_list.size(); i6++) {
                        if (dataRes.ala_stage_list.get(i6) != null) {
                            bd bdVar2 = new bd();
                            bdVar2.a(dataRes.ala_stage_list.get(i6));
                            arrayList2.add(bdVar2);
                        }
                    }
                    this.gZh.gXU = arrayList2;
                }
                if (dataRes.school_recom_info != null) {
                    this.gYZ = dataRes.school_recom_pos.intValue();
                    this.gYY = new au();
                    this.gYY.a(dataRes.school_recom_info);
                }
                if (dataRes.carrier_enter != null) {
                    this.gZa = new com.baidu.tbadk.core.data.l();
                    this.gZa.a(dataRes.carrier_enter);
                }
                if (dataRes.vitality_info != null && dataRes.vitality_info.frequently_forum_info != null) {
                    this.gZc = dataRes.vitality_info.frequently_forum_info.forum_state.intValue();
                    this.gZd = dataRes.vitality_info.frequently_forum_info.access_flag.intValue();
                }
                this.mSortType = dataRes.sort_type.intValue();
                this.gYv = dataRes.need_log.intValue();
                com.baidu.tieba.recapp.d.a.boS().rV(dataRes.asp_shown_info);
                this.gZe = dataRes.card_shipin_pos;
                if (dataRes.card_shipin_new != null) {
                    for (int i7 = 0; i7 < dataRes.card_shipin_new.size(); i7++) {
                        bd bdVar3 = new bd();
                        if (this.gZe != null && this.gZe.size() >= dataRes.card_shipin_new.size()) {
                            bdVar3.eV(this.gZe.get(i7).intValue());
                        }
                        bdVar3.aX(true);
                        bdVar3.a(dataRes.card_shipin_new.get(i7));
                        this.gZf.add(bdVar3);
                    }
                }
                this.gZi = dataRes.enter_pop_info;
                if (dataRes.esport != null) {
                    this.gZj = new com.baidu.tieba.g.b();
                    this.gZj.a(dataRes.esport);
                }
                this.gZk = dataRes.agree_banner;
                if (dataRes.user_extend != null) {
                    this.gZp = new com.baidu.tieba.frs.s();
                    this.gZp.a(dataRes.user_extend);
                }
                this.gZl = dataRes.live_frs_notify;
                this.gZm = dataRes.frs_game_tab_info;
                this.gZn = dataRes.game_default_tab_id.intValue();
                this.gZo = dataRes.forum_head_icon;
                if (dataRes.video != null && dataRes.video.video_act != null) {
                    this.gZq = new l();
                    this.gZq.a(dataRes.video.video_act);
                }
                if (dataRes.info != null) {
                    this.recm_forum_list = dataRes.info.recm_forum_list;
                }
                this.dJs = dataRes.forum_ar_info;
                if (dataRes.star_rank_info != null) {
                    this.gZt = dataRes.star_rank_info;
                }
                if (dataRes.star_voice != null && !StringUtils.isNull(dataRes.star_voice.voice_md5)) {
                    this.dYT = new com.baidu.tieba.tbadkCore.data.l();
                    this.dYT.avatar = dataRes.star_voice.avatar;
                    this.dYT.title = dataRes.star_voice.title;
                    this.dYT.desc = dataRes.star_voice.desc;
                    this.dYT.haV = new VoiceData.VoiceModel();
                    this.dYT.haV.voiceId = dataRes.star_voice.voice_md5;
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public AgreeBanner buP() {
        return this.gZk;
    }

    public void a(AgreeBanner agreeBanner) {
        this.gZk = agreeBanner;
    }

    public ForumHeadIcon buQ() {
        return this.gZo;
    }

    public void a(ForumHeadIcon forumHeadIcon) {
        this.gZo = forumHeadIcon;
    }

    public List<RecmForumInfo> buR() {
        return this.recm_forum_list;
    }

    private void vz(int i) {
        this.gYN = 1;
        if (this.gYL != null && this.gYL.size() > 0) {
            for (FrsTabInfo frsTabInfo : this.gYL) {
                if (frsTabInfo != null && frsTabInfo.tab_id.intValue() == i) {
                    this.gYN = i;
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
                bdVar.eW(3);
                bdVar.zW();
                bdVar.setGrayScaleMode(this.gZu != null && this.gZu.getType() == 1);
                if (bdVar.getFid() == 0 && j != 0) {
                    bdVar.setFid(j);
                }
                if (StringUtils.isNull(bdVar.zt())) {
                    bdVar.cZ(this.fHj.getName());
                }
                bdVar.j(this.gYJ);
                if (bdVar.getThreadType() == 33 && !bdVar.zO()) {
                    ar arVar = new ar();
                    arVar.a(bdVar, 0);
                    arVar.B(bvf());
                    if (appResponseToIntentClass) {
                        this.threadList.add(arVar);
                    }
                } else if (!TextUtils.isEmpty(bdVar.Af())) {
                    ab abVar = new ab();
                    abVar.cU(bdVar.Af());
                    this.threadList.add(abVar);
                } else {
                    this.threadList.add(bdVar);
                }
            }
        }
    }

    public int buS() {
        return this.alaLiveCount;
    }

    public void vA(int i) {
        this.alaLiveCount = i;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] MX() {
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
    public void o(JSONObject jSONObject) {
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void a(Message message) {
    }

    public ForumData bas() {
        return this.fHj;
    }

    public int buT() {
        return this.gZc;
    }

    public void vB(int i) {
        this.gZc = i;
    }

    public int buU() {
        return this.gZd;
    }

    public void vC(int i) {
        this.gZd = i;
    }

    public void c(ForumData forumData) {
        this.fHj = forumData;
    }

    public ArrayList<com.baidu.adp.widget.ListView.i> getThreadList() {
        return this.threadList;
    }

    public void au(ArrayList<com.baidu.adp.widget.ListView.i> arrayList) {
        this.threadList = arrayList;
    }

    public AntiData yn() {
        return this.aNa;
    }

    public void c(AntiData antiData) {
        this.aNa = antiData;
    }

    public al yA() {
        return this.eSZ;
    }

    public void a(al alVar) {
        this.eSZ = alVar;
    }

    public k buV() {
        return this.gYx;
    }

    public void a(k kVar) {
        this.gYx = kVar;
    }

    public void b(com.baidu.tieba.tbadkCore.data.l lVar) {
        this.dYT = lVar;
    }

    public com.baidu.tieba.tbadkCore.data.l buW() {
        return this.dYT;
    }

    public com.baidu.tbadk.core.data.o buX() {
        return this.gYK;
    }

    public void a(com.baidu.tbadk.core.data.o oVar) {
        this.gYK = oVar;
    }

    public boolean buY() {
        return this.gYy;
    }

    public void mI(boolean z) {
        this.gYy = z;
    }

    public String buZ() {
        return this.gYz;
    }

    public void sA(String str) {
        this.gYz = str;
    }

    public n bva() {
        return this.gYA;
    }

    public void a(n nVar) {
        this.gYA = nVar;
    }

    public UserData getUserData() {
        return this.fHq;
    }

    public void e(UserData userData) {
        this.fHq = userData;
    }

    public List<Long> bvb() {
        return this.gYw;
    }

    /* renamed from: do  reason: not valid java name */
    public void m17do(List<Long> list) {
        this.gYw = list;
    }

    public b bvc() {
        return this.gYB;
    }

    public void a(b bVar) {
        this.gYB = bVar;
    }

    public boolean bvd() {
        return this.gYC;
    }

    public void mJ(boolean z) {
        this.gYC = z;
    }

    public String getGameName() {
        return this.gameName;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public List<h> bve() {
        return this.gYD;
    }

    public void dp(List<h> list) {
        this.gYD = list;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public int baH() {
        return this.gYE;
    }

    public void sA(int i) {
        this.gYE = i;
    }

    public List<PhotoLiveCardData> bvf() {
        return this.gYF;
    }

    public String bvg() {
        return this.gYI;
    }

    public void sB(String str) {
        this.gYI = str;
    }

    public List<FrsTabInfo> bvh() {
        return this.gYL;
    }

    public void dq(List<FrsTabInfo> list) {
        this.gYL = list;
    }

    public void dr(List<PhotoLiveCardData> list) {
        this.gYF = list;
    }

    public boolean bvi() {
        return this.gYH != null;
    }

    public PhotoLiveCardData bvj() {
        return this.gYH;
    }

    public void b(PhotoLiveCardData photoLiveCardData) {
        this.gYH = photoLiveCardData;
    }

    public int bvk() {
        return this.gYG;
    }

    public void vD(int i) {
        this.gYG = i;
    }

    public List<FeedForumData> bvl() {
        return this.gYO;
    }

    public void ds(List<FeedForumData> list) {
        this.gYO = list;
    }

    public void sC(String str) {
        if (this.gYO != null && str != null) {
            for (FeedForumData feedForumData : this.gYO) {
                if (feedForumData != null && feedForumData.getForumId() != null && feedForumData.getForumId().equals(str)) {
                    this.gYO.remove(feedForumData);
                    return;
                }
            }
        }
    }

    public List<CategoryInfo> bvm() {
        return this.gYP;
    }

    public void dt(List<CategoryInfo> list) {
        this.gYP = list;
    }

    public void sD(String str) {
        this.gYQ = str;
    }

    public String bvn() {
        return this.gYQ;
    }

    public bd bvo() {
        return this.gYX;
    }

    public void ai(bd bdVar) {
        this.gYX = bdVar;
    }

    public int bvp() {
        return this.gYN;
    }

    public void vE(int i) {
        this.gYN = i;
    }

    public com.baidu.tbadk.core.data.w bvq() {
        return this.gYR;
    }

    public void a(com.baidu.tbadk.core.data.w wVar) {
        this.gYR = wVar;
    }

    public com.baidu.tbadk.core.data.p bvr() {
        return this.gYT;
    }

    public void a(com.baidu.tbadk.core.data.p pVar) {
        this.gYT = pVar;
    }

    public com.baidu.tbadk.core.data.r bvs() {
        return this.gYW;
    }

    public void a(com.baidu.tbadk.core.data.r rVar) {
        this.gYW = rVar;
    }

    public int bvt() {
        return this.gYZ;
    }

    public void vF(int i) {
        this.gYZ = i;
    }

    public au bvu() {
        return this.gYY;
    }

    public void a(au auVar) {
        this.gYY = auVar;
    }

    public NavTabInfo bvv() {
        return this.gYM;
    }

    public void a(NavTabInfo navTabInfo) {
        this.gYM = navTabInfo;
    }

    public com.baidu.tbadk.core.data.l bvw() {
        return this.gZa;
    }

    public void a(com.baidu.tbadk.core.data.l lVar) {
        this.gZa = lVar;
    }

    public Integer bvx() {
        return this.gYU;
    }

    public void j(Integer num) {
        this.gYU = num;
    }

    public List<Integer> bvy() {
        return this.gZe;
    }

    public void du(List<Integer> list) {
        this.gZe = list;
    }

    public List<com.baidu.adp.widget.ListView.i> bvz() {
        return this.gZf;
    }

    public void dv(List<com.baidu.adp.widget.ListView.i> list) {
        this.gZf = list;
    }

    public com.baidu.tieba.g.b bvA() {
        return this.gZj;
    }

    public void a(com.baidu.tieba.g.b bVar) {
        this.gZj = bVar;
    }

    public AlaLiveNotify bvB() {
        return this.gZl;
    }

    public void a(AlaLiveNotify alaLiveNotify) {
        this.gZl = alaLiveNotify;
    }

    public List<FrsTabInfo> bvC() {
        return this.gZm;
    }

    public void dw(List<FrsTabInfo> list) {
        this.gZm = list;
    }

    public void vG(int i) {
        this.gZn = i;
    }

    public int bvD() {
        return this.gZn;
    }

    public void a(com.baidu.tieba.frs.s sVar) {
        this.gZp = sVar;
    }

    public com.baidu.tieba.frs.s bvE() {
        return this.gZp;
    }

    public l bvF() {
        return this.gZq;
    }

    public void a(l lVar) {
        this.gZq = lVar;
    }

    public f bvG() {
        return this.gZg;
    }

    public void b(f fVar) {
        this.gZg = fVar;
    }

    public g bvH() {
        return this.gZh;
    }

    public void b(g gVar) {
        this.gZh = gVar;
    }

    public e bvI() {
        return this.gZu;
    }
}

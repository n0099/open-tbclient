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
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.data.ba;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.util.au;
import com.squareup.wire.Message;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;
import tbclient.CategoryInfo;
import tbclient.FrsPage.AgreeBanner;
import tbclient.FrsPage.ColorEgg;
import tbclient.FrsPage.DataRes;
import tbclient.FrsPage.FrsPageResIdl;
import tbclient.FrsPage.NavTabInfo;
import tbclient.FrsPage.StarEnter;
import tbclient.FrsTabInfo;
import tbclient.PopInfo;
import tbclient.ThreadInfo;
import tbclient.User;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class l implements com.baidu.tbadk.mvc.b.c {
    public static final Wire WIRE = new Wire(new Class[0]);
    private AntiData Wa;
    protected ar dmJ;
    protected ForumData eis;
    private UserData eiy;
    private List<CategoryInfo> fAa;
    private bl fAi;
    private ba fAj;
    private com.baidu.tbadk.core.data.m fAl;
    private List<Integer> fAp;
    private List<com.baidu.adp.widget.ListView.v> fAq;
    public PopInfo fAs;
    private com.baidu.tieba.g.b fAt;
    private AgreeBanner fAu;
    protected List<Long> fzG;
    private m fzH;
    protected boolean fzI;
    protected String fzJ;
    protected o fzK;
    private b fzL;
    private boolean fzM;
    private List<PhotoLiveCardData> fzP;
    private int fzQ;
    private PhotoLiveCardData fzR;
    private String fzS;
    private com.baidu.tbadk.core.data.z fzU;
    private List<FrsTabInfo> fzW;
    private NavTabInfo fzX;
    private List<FeedForumData> fzZ;
    private String gameName;
    private int mSortType;
    protected ArrayList<com.baidu.adp.widget.ListView.v> threadList;
    private HashMap<String, MetaData> userMap;
    public int fzF = 0;
    private List<g> fzN = new ArrayList();
    private int fzO = 0;
    private ArrayList<com.baidu.tbadk.core.data.o> fzT = new ArrayList<>();
    protected com.baidu.tbadk.core.data.r fzV = null;
    private int fzY = 1;
    private String fAb = null;
    private com.baidu.tbadk.core.data.y fAc = null;
    public com.baidu.tbadk.core.data.aa fAd = null;
    private com.baidu.tbadk.core.data.s fAe = null;
    private Integer fAf = -1;
    public com.baidu.tbadk.core.data.w fAg = null;
    private com.baidu.tbadk.core.data.u fAh = null;
    private int fAk = -1;
    protected List<com.baidu.adp.widget.ListView.v> fAm = null;
    private int fAn = 0;
    private int fAo = 0;
    private boolean isShowDriftingBottle = false;
    private long fAr = 0;
    private int alaLiveCount = 0;

    public l() {
        initData();
    }

    private void initData() {
        this.eis = new ForumData();
        this.threadList = new ArrayList<>();
        this.fAm = new ArrayList();
        this.userMap = new HashMap<>();
        this.dmJ = new ar();
        this.fzH = new m();
        this.eiy = new UserData();
        this.fzK = new o();
        d(new AntiData());
        a(new b());
        this.fAq = new ArrayList();
        this.fAp = new ArrayList();
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
                if (!com.baidu.tbadk.core.util.x.r(dataRes.color_egg)) {
                    for (ColorEgg colorEgg : dataRes.color_egg) {
                        if (colorEgg != null && !com.baidu.tbadk.core.util.x.r(colorEgg.holiday_words)) {
                            com.baidu.tbadk.core.data.o oVar = new com.baidu.tbadk.core.data.o();
                            if (oVar.a(colorEgg)) {
                                this.fzT.add(oVar);
                            }
                        }
                    }
                }
                if (dataRes.activityhead != null && !com.baidu.tbadk.core.util.x.r(dataRes.activityhead.head_imgs)) {
                    this.fzV = new com.baidu.tbadk.core.data.r();
                    this.fzV.a(dataRes.activityhead);
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
                mv(dataRes.is_new_url.intValue());
                this.fzI = dataRes.fortune_bag.intValue() == 1;
                this.fzJ = dataRes.fortune_desc;
                if (dataRes.forum != null) {
                    this.fzM = dataRes.forum.has_game.intValue() == 1;
                    this.fzS = dataRes.forum.game_url;
                    this.gameName = dataRes.forum.game_name;
                }
                List<StarEnter> list2 = dataRes.star_enter;
                this.fzN.clear();
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        g gVar = new g();
                        gVar.a(list2.get(i2));
                        this.fzN.add(gVar);
                    }
                }
                this.fzK.a(dataRes.gcon_account);
                this.eis.parserProtobuf(dataRes.forum);
                long longValue = dataRes.forum != null ? dataRes.forum.id.longValue() : 0L;
                this.fzG = dataRes.thread_id_list;
                this.Wa.parserProtobuf(dataRes.anti);
                this.fzL.a(dataRes.group);
                this.dmJ.a(dataRes.page);
                this.fzH.a(dataRes.frs_star);
                this.eiy.parserProtobuf(dataRes.user);
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.eiy.getIsSelectTail());
                }
                this.fzW = dataRes.frs_tab_info;
                if (dataRes.nav_tab_info == null) {
                    NavTabInfo.Builder builder = new NavTabInfo.Builder();
                    builder.tab = dataRes.frs_tab_info;
                    this.fzX = builder.build(true);
                } else {
                    this.fzX = dataRes.nav_tab_info;
                }
                this.alaLiveCount = dataRes.ala_live_count.intValue();
                sa(dataRes.frs_tab_default.intValue());
                List<ZhiBoInfoTW> list3 = dataRes.twzhibo_info;
                if (list3 != null && list3.size() > 0) {
                    this.fzP = new ArrayList();
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
                        this.fzP.add(photoLiveCardData);
                    }
                }
                this.fzQ = dataRes.twzhibo_pos.intValue();
                if (dataRes.hot_twzhibo_info != null) {
                    this.fzR = new PhotoLiveCardData();
                    if (this.fzR.getShowStyle() < 0) {
                        this.fzR.setShowStyle(PhotoLiveCardData.getRandom(3, -1));
                    }
                    this.fzR.getShowStyle();
                    this.fzR.parserProtobuf(dataRes.hot_twzhibo_info);
                    this.fzR.setShowExpressionViewIndexList(this.fzR.getExpressionDatas());
                }
                a(dataRes.thread_list, longValue);
                this.fAa = dataRes.category_list;
                if (!au.isEmpty(dataRes.bawu_enter_url)) {
                    this.fAb = dataRes.bawu_enter_url;
                }
                if (dataRes.head_sdk != null) {
                    this.fAc = new com.baidu.tbadk.core.data.y();
                    this.fAc.a(dataRes.head_sdk);
                }
                if (dataRes.recommend_book != null) {
                    this.fAd = new com.baidu.tbadk.core.data.aa();
                    this.fAd.a(dataRes.recommend_book);
                }
                if (dataRes.book_info != null) {
                    this.fAe = new com.baidu.tbadk.core.data.s();
                    this.fAe.a(dataRes.book_info);
                }
                if (dataRes.forum_present_info != null) {
                    this.fAg = new com.baidu.tbadk.core.data.w();
                    this.fAg.a(dataRes.forum_present_info);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.fAh = new com.baidu.tbadk.core.data.u();
                    this.fAh.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.ntspread != null) {
                    this.fzU = new com.baidu.tbadk.core.data.z();
                    this.fzU.a(dataRes.ntspread);
                }
                if (dataRes.card_shipin_info != null && dataRes.card_shipin_info.size() > 0) {
                    this.fAi = new bl();
                    this.fAi.ap(true);
                    this.fAi.bV(this.fzQ);
                    this.fAi.setUserMap(this.userMap);
                    this.fAi.a(dataRes.card_shipin_info.get(0));
                    this.fAi.sc();
                    if (this.fAi.getFid() == 0 && longValue != 0) {
                        this.fAi.setFid(longValue);
                    }
                    this.fAi.i(this.fzT);
                    this.fAi.ao(!this.fAi.rc());
                    if (this.fAi.getAuthor() != null && this.fAi.getAuthor().getPendantData() == null && (metaData = this.userMap.get(this.fAi.getAuthor().getUserId())) != null && metaData.getPendantData() != null) {
                        com.baidu.tbadk.data.j jVar = new com.baidu.tbadk.data.j();
                        jVar.O(metaData.getPendantData().BN());
                        jVar.cq(metaData.getPendantData().pL());
                        this.fAi.getAuthor().setPendantData(jVar);
                    }
                }
                if (dataRes.school_recom_info != null) {
                    this.fAk = dataRes.school_recom_pos.intValue();
                    this.fAj = new ba();
                    this.fAj.a(dataRes.school_recom_info);
                }
                if (dataRes.carrier_enter != null) {
                    this.fAl = new com.baidu.tbadk.core.data.m();
                    this.fAl.a(dataRes.carrier_enter);
                }
                if (dataRes.vitality_info != null && dataRes.vitality_info.frequently_forum_info != null) {
                    this.fAn = dataRes.vitality_info.frequently_forum_info.forum_state.intValue();
                    this.fAo = dataRes.vitality_info.frequently_forum_info.access_flag.intValue();
                }
                this.mSortType = dataRes.sort_type.intValue();
                this.fzF = dataRes.need_log.intValue();
                com.baidu.tieba.recapp.d.a.ban().pG(dataRes.asp_shown_info);
                this.fAp = dataRes.card_shipin_pos;
                if (dataRes.card_shipin_new != null) {
                    for (int i5 = 0; i5 < dataRes.card_shipin_new.size(); i5++) {
                        bl blVar = new bl();
                        if (this.fAp != null && this.fAp.size() >= dataRes.card_shipin_new.size()) {
                            blVar.bV(this.fAp.get(i5).intValue());
                        }
                        blVar.ap(true);
                        blVar.a(dataRes.card_shipin_new.get(i5));
                        this.fAq.add(blVar);
                    }
                }
                if (dataRes.bottle != null) {
                    this.isShowDriftingBottle = dataRes.bottle.has_enter_display.intValue() == 1;
                    this.fAr = dataRes.bottle.tid.longValue();
                } else {
                    this.isShowDriftingBottle = false;
                    this.fAr = 0L;
                }
                this.fAs = dataRes.enter_pop_info;
                if (dataRes.esport != null) {
                    this.fAt = new com.baidu.tieba.g.b();
                    this.fAt.a(dataRes.esport);
                }
                this.fAu = dataRes.agree_banner;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public AgreeBanner bgi() {
        return this.fAu;
    }

    public void a(AgreeBanner agreeBanner) {
        this.fAu = agreeBanner;
    }

    private void sa(int i) {
        this.fzY = 1;
        if (this.fzW != null && this.fzW.size() > 0) {
            for (FrsTabInfo frsTabInfo : this.fzW) {
                if (frsTabInfo != null && frsTabInfo.tab_id.intValue() == i) {
                    this.fzY = i;
                    return;
                }
            }
        }
    }

    public void a(List<ThreadInfo> list, long j) {
        if (list != null) {
            boolean appResponseToIntentClass = TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
            for (int i = 0; i < list.size(); i++) {
                bl blVar = new bl();
                blVar.setUserMap(this.userMap);
                blVar.a(list.get(i));
                blVar.bW(3);
                blVar.sc();
                if (blVar.getFid() == 0 && j != 0) {
                    blVar.setFid(j);
                }
                if (StringUtils.isNull(blVar.rz())) {
                    blVar.cs(this.eis.getName());
                }
                blVar.i(this.fzT);
                if (blVar.getThreadType() == 33 && !blVar.rV()) {
                    ax axVar = new ax();
                    axVar.a(blVar, 0);
                    axVar.n(bgv());
                    if (appResponseToIntentClass) {
                        this.threadList.add(axVar);
                    }
                } else if (!TextUtils.isEmpty(blVar.sp())) {
                    ah ahVar = new ah();
                    ahVar.cn(blVar.sp());
                    this.threadList.add(ahVar);
                } else {
                    this.threadList.add(blVar);
                }
            }
        }
    }

    public int bgj() {
        return this.alaLiveCount;
    }

    public void sb(int i) {
        this.alaLiveCount = i;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] Ed() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public boolean z(byte[] bArr) {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void m(JSONObject jSONObject) {
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void a(Message message) {
    }

    public ForumData aIz() {
        return this.eis;
    }

    public int bgk() {
        return this.fAn;
    }

    public void sc(int i) {
        this.fAn = i;
    }

    public int bgl() {
        return this.fAo;
    }

    public void sd(int i) {
        this.fAo = i;
    }

    public void c(ForumData forumData) {
        this.eis = forumData;
    }

    public ArrayList<com.baidu.adp.widget.ListView.v> getThreadList() {
        return this.threadList;
    }

    public void ay(ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        this.threadList = arrayList;
    }

    public AntiData qh() {
        return this.Wa;
    }

    public void d(AntiData antiData) {
        this.Wa = antiData;
    }

    public ar qx() {
        return this.dmJ;
    }

    public void a(ar arVar) {
        this.dmJ = arVar;
    }

    public m bgm() {
        return this.fzH;
    }

    public void a(m mVar) {
        this.fzH = mVar;
    }

    public com.baidu.tbadk.core.data.r bgn() {
        return this.fzV;
    }

    public void a(com.baidu.tbadk.core.data.r rVar) {
        this.fzV = rVar;
    }

    public boolean bgo() {
        return this.fzI;
    }

    public void ln(boolean z) {
        this.fzI = z;
    }

    public String bgp() {
        return this.fzJ;
    }

    public void qb(String str) {
        this.fzJ = str;
    }

    public o bgq() {
        return this.fzK;
    }

    public void a(o oVar) {
        this.fzK = oVar;
    }

    public UserData getUserData() {
        return this.eiy;
    }

    public void a(UserData userData) {
        this.eiy = userData;
    }

    public List<Long> bgr() {
        return this.fzG;
    }

    public void cx(List<Long> list) {
        this.fzG = list;
    }

    public b bgs() {
        return this.fzL;
    }

    public void a(b bVar) {
        this.fzL = bVar;
    }

    public boolean bgt() {
        return this.fzM;
    }

    public void lo(boolean z) {
        this.fzM = z;
    }

    public String getGameName() {
        return this.gameName;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public List<g> bgu() {
        return this.fzN;
    }

    public void cy(List<g> list) {
        this.fzN = list;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public int aIN() {
        return this.fzO;
    }

    public void mv(int i) {
        this.fzO = i;
    }

    public List<PhotoLiveCardData> bgv() {
        return this.fzP;
    }

    public String bgw() {
        return this.fzS;
    }

    public void qc(String str) {
        this.fzS = str;
    }

    public List<FrsTabInfo> bgx() {
        return this.fzW;
    }

    public void cz(List<FrsTabInfo> list) {
        this.fzW = list;
    }

    public void cA(List<PhotoLiveCardData> list) {
        this.fzP = list;
    }

    public boolean bgy() {
        return this.fzR != null;
    }

    public PhotoLiveCardData bgz() {
        return this.fzR;
    }

    public void c(PhotoLiveCardData photoLiveCardData) {
        this.fzR = photoLiveCardData;
    }

    public com.baidu.tbadk.core.data.z bgA() {
        return this.fzU;
    }

    public void a(com.baidu.tbadk.core.data.z zVar) {
        this.fzU = zVar;
    }

    public int bgB() {
        return this.fzQ;
    }

    public void se(int i) {
        this.fzQ = i;
    }

    public List<FeedForumData> bgC() {
        return this.fzZ;
    }

    public void cB(List<FeedForumData> list) {
        this.fzZ = list;
    }

    public void qd(String str) {
        if (this.fzZ != null && str != null) {
            for (FeedForumData feedForumData : this.fzZ) {
                if (feedForumData != null && feedForumData.getForumId() != null && feedForumData.getForumId().equals(str)) {
                    this.fzZ.remove(feedForumData);
                    return;
                }
            }
        }
    }

    public List<CategoryInfo> bgD() {
        return this.fAa;
    }

    public void cC(List<CategoryInfo> list) {
        this.fAa = list;
    }

    public void qe(String str) {
        this.fAb = str;
    }

    public String bgE() {
        return this.fAb;
    }

    public bl bgF() {
        return this.fAi;
    }

    public void V(bl blVar) {
        this.fAi = blVar;
    }

    public int bgG() {
        return this.fzY;
    }

    public void sf(int i) {
        this.fzY = i;
    }

    public com.baidu.tbadk.core.data.y bgH() {
        return this.fAc;
    }

    public void a(com.baidu.tbadk.core.data.y yVar) {
        this.fAc = yVar;
    }

    public com.baidu.tbadk.core.data.s bgI() {
        return this.fAe;
    }

    public void a(com.baidu.tbadk.core.data.s sVar) {
        this.fAe = sVar;
    }

    public com.baidu.tbadk.core.data.u bgJ() {
        return this.fAh;
    }

    public void a(com.baidu.tbadk.core.data.u uVar) {
        this.fAh = uVar;
    }

    public int bgK() {
        return this.fAk;
    }

    public void sg(int i) {
        this.fAk = i;
    }

    public ba bgL() {
        return this.fAj;
    }

    public void a(ba baVar) {
        this.fAj = baVar;
    }

    public NavTabInfo bgM() {
        return this.fzX;
    }

    public void a(NavTabInfo navTabInfo) {
        this.fzX = navTabInfo;
    }

    public com.baidu.tbadk.core.data.m bgN() {
        return this.fAl;
    }

    public void a(com.baidu.tbadk.core.data.m mVar) {
        this.fAl = mVar;
    }

    public Integer bgO() {
        return this.fAf;
    }

    public void d(Integer num) {
        this.fAf = num;
    }

    public List<Integer> bgP() {
        return this.fAp;
    }

    public void cD(List<Integer> list) {
        this.fAp = list;
    }

    public List<com.baidu.adp.widget.ListView.v> bgQ() {
        return this.fAq;
    }

    public void cE(List<com.baidu.adp.widget.ListView.v> list) {
        this.fAq = list;
    }

    public boolean isShowDriftingBottle() {
        return this.isShowDriftingBottle;
    }

    public long bgR() {
        return this.fAr;
    }

    public void lp(boolean z) {
        this.isShowDriftingBottle = z;
    }

    public void cq(long j) {
        this.fAr = j;
    }

    public com.baidu.tieba.g.b bgS() {
        return this.fAt;
    }

    public void a(com.baidu.tieba.g.b bVar) {
        this.fAt = bVar;
    }
}

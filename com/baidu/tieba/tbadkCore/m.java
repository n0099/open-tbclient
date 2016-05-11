package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.FeedForumData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PhotoLiveCardData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.util.ay;
import com.squareup.wire.Message;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;
import tbclient.CategoryInfo;
import tbclient.FrsPage.ColorEgg;
import tbclient.FrsPage.DataRes;
import tbclient.FrsPage.FrsPageResIdl;
import tbclient.FrsPage.NavTabInfo;
import tbclient.FrsPage.StarEnter;
import tbclient.FrsTabInfo;
import tbclient.ThreadInfo;
import tbclient.User;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class m implements com.baidu.tbadk.mvc.b.c {
    public static final Wire WIRE = new Wire(new Class[0]);
    private AntiData OF;
    protected com.baidu.tbadk.core.data.ad cyL;
    protected ForumData dfa;
    private UserData dfg;
    protected String eqA;
    protected p eqB;
    private b eqC;
    private boolean eqD;
    private List<PhotoLiveCardData> eqG;
    private int eqH;
    private PhotoLiveCardData eqI;
    private String eqJ;
    private com.baidu.tbadk.core.data.r eqL;
    private List<FrsTabInfo> eqN;
    private NavTabInfo eqO;
    private List<FeedForumData> eqQ;
    private List<CategoryInfo> eqR;
    private ax eqU;
    private al eqV;
    protected List<Long> eqx;
    private n eqy;
    protected boolean eqz;
    private String gameName;
    protected ArrayList<com.baidu.adp.widget.ListView.v> threadList;
    private HashMap<String, MetaData> userMap;
    private List<g> eqE = new ArrayList();
    private int eqF = 0;
    private ArrayList<com.baidu.tbadk.core.data.l> eqK = new ArrayList<>();
    protected com.baidu.tbadk.core.data.m eqM = null;
    private int eqP = 1;
    private String eqS = null;
    private com.baidu.tbadk.core.data.q eqT = null;
    private int eqW = -1;
    protected List<com.baidu.adp.widget.ListView.v> eqX = null;

    public m() {
        initData();
    }

    private void initData() {
        this.dfa = new ForumData();
        this.threadList = new ArrayList<>();
        this.eqX = new ArrayList();
        this.userMap = new HashMap<>();
        this.cyL = new com.baidu.tbadk.core.data.ad();
        this.eqy = new n();
        this.dfg = new UserData();
        this.eqB = new p();
        d(new AntiData());
        a(new b());
    }

    public FrsPageResIdl A(byte[] bArr) {
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
        int i = -1;
        if (dataRes != null) {
            try {
                initData();
                if (dataRes.color_egg != null && dataRes.color_egg.size() > 0) {
                    for (ColorEgg colorEgg : dataRes.color_egg) {
                        if (colorEgg != null && colorEgg.holiday_words != null && colorEgg.holiday_words.size() > 0) {
                            com.baidu.tbadk.core.data.l lVar = new com.baidu.tbadk.core.data.l();
                            if (lVar.a(colorEgg)) {
                                this.eqK.add(lVar);
                            }
                        }
                    }
                }
                if (dataRes.activityhead != null && dataRes.activityhead.head_imgs != null && dataRes.activityhead.head_imgs.size() > 0) {
                    this.eqM = new com.baidu.tbadk.core.data.m();
                    this.eqM.a(dataRes.activityhead);
                }
                List<User> list = dataRes.user_list;
                if (list != null) {
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(list.get(i2));
                        String userId = metaData.getUserId();
                        if (userId != null && !userId.equals("0")) {
                            this.userMap.put(metaData.getUserId(), metaData);
                        }
                    }
                }
                kh(dataRes.is_new_url.intValue());
                this.eqz = dataRes.fortune_bag.intValue() == 1;
                this.eqA = dataRes.fortune_desc;
                if (dataRes.forum != null) {
                    this.eqD = dataRes.forum.has_game.intValue() == 1;
                    this.eqJ = dataRes.forum.game_url;
                    this.gameName = dataRes.forum.game_name;
                }
                List<StarEnter> list2 = dataRes.star_enter;
                this.eqE.clear();
                if (list2 != null) {
                    for (int i3 = 0; i3 < list2.size(); i3++) {
                        g gVar = new g();
                        gVar.a(list2.get(i3));
                        this.eqE.add(gVar);
                    }
                }
                this.eqB.a(dataRes.gcon_account);
                this.dfa.parserProtobuf(dataRes.forum);
                long longValue = dataRes.forum != null ? dataRes.forum.id.longValue() : 0L;
                this.eqx = dataRes.thread_id_list;
                this.OF.parserProtobuf(dataRes.anti);
                this.eqC.a(dataRes.group);
                this.cyL.a(dataRes.page);
                this.eqy.a(dataRes.frs_star);
                this.dfg.parserProtobuf(dataRes.user);
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.dfg.getIsSelectTail());
                }
                this.eqN = dataRes.frs_tab_info;
                if (dataRes.nav_tab_info == null) {
                    NavTabInfo.Builder builder = new NavTabInfo.Builder();
                    builder.tab = dataRes.frs_tab_info;
                    this.eqO = builder.build(true);
                } else {
                    this.eqO = dataRes.nav_tab_info;
                }
                pd(dataRes.frs_tab_default.intValue());
                List<ZhiBoInfoTW> list3 = dataRes.twzhibo_info;
                if (list3 != null && list3.size() > 0) {
                    this.eqG = new ArrayList();
                    int size = list3.size();
                    for (int i4 = 0; i4 < size; i4++) {
                        PhotoLiveCardData photoLiveCardData = new PhotoLiveCardData();
                        photoLiveCardData.parserProtobuf(list3.get(i4));
                        if (photoLiveCardData.getShowStyle() < 0) {
                            photoLiveCardData.setShowStyle(photoLiveCardData.getRandom(3, i));
                        }
                        i = photoLiveCardData.getShowStyle();
                        photoLiveCardData.setShowExpressionViewIndexList(photoLiveCardData.getExpressionDatas());
                        this.eqG.add(photoLiveCardData);
                    }
                }
                this.eqH = dataRes.twzhibo_pos.intValue();
                if (dataRes.hot_twzhibo_info != null) {
                    this.eqI = new PhotoLiveCardData();
                    if (this.eqI.getShowStyle() < 0) {
                        this.eqI.setShowStyle(this.eqI.getRandom(3, -1));
                    }
                    this.eqI.getShowStyle();
                    this.eqI.parserProtobuf(dataRes.hot_twzhibo_info);
                    this.eqI.setShowExpressionViewIndexList(this.eqI.getExpressionDatas());
                }
                a(dataRes.thread_list, longValue);
                this.eqR = dataRes.category_list;
                if (!ay.isEmpty(dataRes.bawu_enter_url)) {
                    this.eqS = dataRes.bawu_enter_url;
                }
                if (dataRes.head_sdk != null) {
                    this.eqT = new com.baidu.tbadk.core.data.q();
                    this.eqT.a(dataRes.head_sdk);
                }
                if (dataRes.store_card != null) {
                    this.eqL = new com.baidu.tbadk.core.data.r();
                    this.eqL.a(dataRes.store_card);
                }
                if (dataRes.card_shipin_info != null && dataRes.card_shipin_info.size() > 0) {
                    this.eqU = new ax();
                    this.eqU.setUserMap(this.userMap);
                    this.eqU.a(dataRes.card_shipin_info.get(0));
                    this.eqU.parser_title();
                    if (this.eqU.getFid() == 0 && longValue != 0) {
                        this.eqU.setFid(longValue);
                    }
                    this.eqU.i(this.eqK);
                    this.eqU.ao(true);
                }
                if (dataRes.school_recom_info != null) {
                    this.eqW = dataRes.school_recom_pos.intValue();
                    this.eqV = new al();
                    this.eqV.a(dataRes.school_recom_info);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    private void pd(int i) {
        this.eqP = 1;
        if (this.eqN != null && this.eqN.size() > 0) {
            for (FrsTabInfo frsTabInfo : this.eqN) {
                if (frsTabInfo != null && frsTabInfo.tab_id.intValue() == i) {
                    this.eqP = i;
                    return;
                }
            }
        }
    }

    public void a(List<ThreadInfo> list, long j) {
        if (list != null) {
            boolean appResponseToIntentClass = TbadkCoreApplication.m11getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
            for (int i = 0; i < list.size(); i++) {
                ax axVar = new ax();
                axVar.setUserMap(this.userMap);
                axVar.a(list.get(i));
                axVar.parser_title();
                if (axVar.getFid() == 0 && j != 0) {
                    axVar.setFid(j);
                }
                axVar.i(this.eqK);
                if (axVar.getThreadType() == 33 && !axVar.rd()) {
                    com.baidu.tbadk.core.data.ag agVar = new com.baidu.tbadk.core.data.ag();
                    agVar.a(axVar, 0);
                    agVar.o(aSj());
                    if (appResponseToIntentClass) {
                        this.threadList.add(agVar);
                    }
                } else {
                    this.threadList.add(axVar);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] Df() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public boolean w(byte[] bArr) {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void g(JSONObject jSONObject) {
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void a(Message message) {
    }

    public ForumData avA() {
        return this.dfa;
    }

    public void c(ForumData forumData) {
        this.dfa = forumData;
    }

    public ArrayList<com.baidu.adp.widget.ListView.v> getThreadList() {
        return this.threadList;
    }

    public void an(ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        this.threadList = arrayList;
    }

    public AntiData pz() {
        return this.OF;
    }

    public void d(AntiData antiData) {
        this.OF = antiData;
    }

    public com.baidu.tbadk.core.data.ad getPage() {
        return this.cyL;
    }

    public void a(com.baidu.tbadk.core.data.ad adVar) {
        this.cyL = adVar;
    }

    public n aSa() {
        return this.eqy;
    }

    public void a(n nVar) {
        this.eqy = nVar;
    }

    public com.baidu.tbadk.core.data.m aSb() {
        return this.eqM;
    }

    public void b(com.baidu.tbadk.core.data.m mVar) {
        this.eqM = mVar;
    }

    public boolean aSc() {
        return this.eqz;
    }

    public void jv(boolean z) {
        this.eqz = z;
    }

    public String aSd() {
        return this.eqA;
    }

    public void nI(String str) {
        this.eqA = str;
    }

    public p aSe() {
        return this.eqB;
    }

    public void a(p pVar) {
        this.eqB = pVar;
    }

    public UserData getUserData() {
        return this.dfg;
    }

    public void f(UserData userData) {
        this.dfg = userData;
    }

    public List<Long> aSf() {
        return this.eqx;
    }

    public void cq(List<Long> list) {
        this.eqx = list;
    }

    public b aSg() {
        return this.eqC;
    }

    public void a(b bVar) {
        this.eqC = bVar;
    }

    public boolean aSh() {
        return this.eqD;
    }

    public void jw(boolean z) {
        this.eqD = z;
    }

    public String getGameName() {
        return this.gameName;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public List<g> aSi() {
        return this.eqE;
    }

    public void cr(List<g> list) {
        this.eqE = list;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public int avI() {
        return this.eqF;
    }

    public void kh(int i) {
        this.eqF = i;
    }

    public List<PhotoLiveCardData> aSj() {
        return this.eqG;
    }

    public String aSk() {
        return this.eqJ;
    }

    public void nJ(String str) {
        this.eqJ = str;
    }

    public List<FrsTabInfo> aSl() {
        return this.eqN;
    }

    public void cs(List<FrsTabInfo> list) {
        this.eqN = list;
    }

    public void ct(List<PhotoLiveCardData> list) {
        this.eqG = list;
    }

    public boolean aSm() {
        return this.eqI != null;
    }

    public PhotoLiveCardData aSn() {
        return this.eqI;
    }

    public void b(PhotoLiveCardData photoLiveCardData) {
        this.eqI = photoLiveCardData;
    }

    public com.baidu.tbadk.core.data.r aSo() {
        return this.eqL;
    }

    public void a(com.baidu.tbadk.core.data.r rVar) {
        this.eqL = rVar;
    }

    public int aSp() {
        return this.eqH;
    }

    public void pe(int i) {
        this.eqH = i;
    }

    public List<FeedForumData> aSq() {
        return this.eqQ;
    }

    public void cu(List<FeedForumData> list) {
        this.eqQ = list;
    }

    public void nK(String str) {
        if (this.eqQ != null && str != null) {
            for (FeedForumData feedForumData : this.eqQ) {
                if (feedForumData != null && feedForumData.getForumId() != null && feedForumData.getForumId().equals(str)) {
                    this.eqQ.remove(feedForumData);
                    return;
                }
            }
        }
    }

    public List<CategoryInfo> aSr() {
        return this.eqR;
    }

    public void cv(List<CategoryInfo> list) {
        this.eqR = list;
    }

    public void nL(String str) {
        this.eqS = str;
    }

    public String aSs() {
        return this.eqS;
    }

    public ax aSt() {
        return this.eqU;
    }

    public void o(ax axVar) {
        this.eqU = axVar;
    }

    public int aSu() {
        return this.eqP;
    }

    public void pf(int i) {
        this.eqP = i;
    }

    public com.baidu.tbadk.core.data.q aSv() {
        return this.eqT;
    }

    public void b(com.baidu.tbadk.core.data.q qVar) {
        this.eqT = qVar;
    }

    public int aSw() {
        return this.eqW;
    }

    public void pg(int i) {
        this.eqW = i;
    }

    public al aSx() {
        return this.eqV;
    }

    public void a(al alVar) {
        this.eqV = alVar;
    }

    public NavTabInfo aSy() {
        return this.eqO;
    }

    public void a(NavTabInfo navTabInfo) {
        this.eqO = navTabInfo;
    }
}

package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.FeedForumData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PhotoLiveCardData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.ax;
import com.squareup.wire.Message;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;
import tbclient.AnchorInfo;
import tbclient.CategoryInfo;
import tbclient.FrsPage.ColorEgg;
import tbclient.FrsPage.DataRes;
import tbclient.FrsPage.FrsPageResIdl;
import tbclient.FrsPage.StarEnter;
import tbclient.FrsTabInfo;
import tbclient.ThreadInfo;
import tbclient.User;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class n implements com.baidu.tbadk.mvc.b.c {
    private static final Wire WIRE = new Wire(new Class[0]);
    private AntiData VX;
    protected ForumData cCN;
    private UserData cCS;
    protected com.baidu.tbadk.core.data.q ciK;
    protected List<Long> dEL;
    private o dEM;
    protected boolean dEN;
    protected String dEO;
    protected q dEP;
    private b dEQ;
    private boolean dER;
    private ArrayList<LiveCardData> dEU;
    private List<PhotoLiveCardData> dEV;
    private int dEW;
    private PhotoLiveCardData dEX;
    private String dEY;
    private com.baidu.tbadk.core.data.k dFa;
    private List<FrsTabInfo> dFc;
    private List<FeedForumData> dFd;
    private List<CategoryInfo> dFe;
    private String gameName;
    protected ArrayList<com.baidu.adp.widget.ListView.u> threadList;
    private HashMap<String, MetaData> userMap;
    private List<h> dES = new ArrayList();
    private int dET = 0;
    private ArrayList<com.baidu.tbadk.core.data.g> dEZ = new ArrayList<>();
    protected com.baidu.tbadk.core.data.h dFb = null;
    private String dFf = null;

    public n() {
        initData();
    }

    private void initData() {
        this.cCN = new ForumData();
        this.threadList = new ArrayList<>();
        this.userMap = new HashMap<>();
        this.ciK = new com.baidu.tbadk.core.data.q();
        this.dEM = new o();
        this.cCS = new UserData();
        this.dEP = new q();
        c(new AntiData());
        a(new b());
    }

    public FrsPageResIdl U(byte[] bArr) {
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
                            com.baidu.tbadk.core.data.g gVar = new com.baidu.tbadk.core.data.g();
                            if (gVar.a(colorEgg)) {
                                this.dEZ.add(gVar);
                            }
                        }
                    }
                }
                if (dataRes.activityhead != null && dataRes.activityhead.head_imgs != null && dataRes.activityhead.head_imgs.size() > 0) {
                    this.dFb = new com.baidu.tbadk.core.data.h();
                    this.dFb.a(dataRes.activityhead);
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
                jz(dataRes.is_new_url.intValue());
                this.dEN = dataRes.fortune_bag.intValue() == 1;
                this.dEO = dataRes.fortune_desc;
                if (dataRes.forum != null) {
                    this.dER = dataRes.forum.has_game.intValue() == 1;
                    this.dEY = dataRes.forum.game_url;
                    this.gameName = dataRes.forum.game_name;
                }
                List<StarEnter> list2 = dataRes.star_enter;
                this.dES.clear();
                if (list2 != null) {
                    for (int i3 = 0; i3 < list2.size(); i3++) {
                        h hVar = new h();
                        hVar.a(list2.get(i3));
                        this.dES.add(hVar);
                    }
                }
                this.dEP.a(dataRes.gcon_account);
                this.cCN.parserProtobuf(dataRes.forum);
                long j = 0;
                if (dataRes.forum != null) {
                    j = dataRes.forum.id.longValue();
                }
                a(dataRes.thread_list, j);
                this.dEL = dataRes.thread_id_list;
                this.VX.parserProtobuf(dataRes.anti);
                this.dEQ.a(dataRes.group);
                this.ciK.a(dataRes.page);
                this.dEM.a(dataRes.frs_star);
                this.cCS.parserProtobuf(dataRes.user);
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.cCS.getIsSelectTail());
                }
                List<AnchorInfo> list3 = dataRes.forum_livegroup_list;
                this.dEU = new ArrayList<>();
                if (list3 != null) {
                    for (int i4 = 0; i4 < list3.size(); i4++) {
                        LiveCardData liveCardData = new LiveCardData();
                        liveCardData.parserProtobuf(list3.get(i4));
                        this.dEU.add(liveCardData);
                    }
                }
                this.dFc = dataRes.frs_tab_info;
                List<ZhiBoInfoTW> list4 = dataRes.twzhibo_info;
                if (list4 != null && list4.size() > 0) {
                    this.dEV = new ArrayList();
                    int size = list4.size();
                    for (int i5 = 0; i5 < size; i5++) {
                        PhotoLiveCardData photoLiveCardData = new PhotoLiveCardData();
                        photoLiveCardData.parserProtobuf(list4.get(i5));
                        if (photoLiveCardData.getShowStyle() < 0) {
                            photoLiveCardData.setShowStyle(photoLiveCardData.getRandom(3, i));
                        }
                        i = photoLiveCardData.getShowStyle();
                        photoLiveCardData.setShowExpressionViewIndexList(photoLiveCardData.getExpressionDatas());
                        this.dEV.add(photoLiveCardData);
                    }
                    this.dEW = dataRes.twzhibo_pos.intValue();
                }
                if (dataRes.hot_twzhibo_info != null) {
                    this.dEX = new PhotoLiveCardData();
                    if (this.dEX.getShowStyle() < 0) {
                        this.dEX.setShowStyle(this.dEX.getRandom(3, -1));
                    }
                    this.dEX.getShowStyle();
                    this.dEX.parserProtobuf(dataRes.hot_twzhibo_info);
                    this.dEX.setShowExpressionViewIndexList(this.dEX.getExpressionDatas());
                }
                this.dFe = dataRes.category_list;
                if (!ax.isEmpty(dataRes.bawu_enter_url)) {
                    this.dFf = dataRes.bawu_enter_url;
                }
                if (dataRes.store_card != null) {
                    this.dFa = new com.baidu.tbadk.core.data.k();
                    this.dFa.a(dataRes.store_card);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void bL(List<ThreadInfo> list) {
        a(list, 0L);
    }

    public void a(List<ThreadInfo> list, long j) {
        if (list != null) {
            boolean appResponseToIntentClass = TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
            int i = 0;
            int i2 = -1;
            while (true) {
                int i3 = i;
                if (i3 < list.size()) {
                    com.baidu.tbadk.core.data.z zVar = new com.baidu.tbadk.core.data.z();
                    zVar.setUserMap(this.userMap);
                    zVar.a(list.get(i3));
                    zVar.parser_title();
                    if (zVar.ss() == 0 && j != 0) {
                        zVar.p(j);
                    }
                    zVar.k(this.dEZ);
                    if (zVar.getThreadType() == 33 && !zVar.sG()) {
                        com.baidu.tbadk.core.data.w wVar = new com.baidu.tbadk.core.data.w();
                        wVar.a(zVar, i2);
                        if (wVar.sh() != null) {
                            i2 = wVar.sh().getShowStyle();
                        }
                        if (appResponseToIntentClass) {
                            this.threadList.add(wVar);
                        }
                    } else {
                        this.threadList.add(zVar);
                    }
                    i = i3 + 1;
                } else {
                    return;
                }
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] Df() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public boolean R(byte[] bArr) {
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

    public ForumData akG() {
        return this.cCN;
    }

    public void c(ForumData forumData) {
        this.cCN = forumData;
    }

    public ArrayList<com.baidu.adp.widget.ListView.u> getThreadList() {
        return this.threadList;
    }

    public void am(ArrayList<com.baidu.adp.widget.ListView.u> arrayList) {
        this.threadList = arrayList;
    }

    public AntiData rI() {
        return this.VX;
    }

    public void c(AntiData antiData) {
        this.VX = antiData;
    }

    public com.baidu.tbadk.core.data.q getPage() {
        return this.ciK;
    }

    public void b(com.baidu.tbadk.core.data.q qVar) {
        this.ciK = qVar;
    }

    public o aDK() {
        return this.dEM;
    }

    public void a(o oVar) {
        this.dEM = oVar;
    }

    public com.baidu.tbadk.core.data.h aDL() {
        return this.dFb;
    }

    public void b(com.baidu.tbadk.core.data.h hVar) {
        this.dFb = hVar;
    }

    public boolean aDM() {
        return this.dEN;
    }

    public void hq(boolean z) {
        this.dEN = z;
    }

    public String aDN() {
        return this.dEO;
    }

    public void mi(String str) {
        this.dEO = str;
    }

    public q aDO() {
        return this.dEP;
    }

    public void a(q qVar) {
        this.dEP = qVar;
    }

    public UserData getUserData() {
        return this.cCS;
    }

    public void f(UserData userData) {
        this.cCS = userData;
    }

    public List<Long> aDP() {
        return this.dEL;
    }

    public void bM(List<Long> list) {
        this.dEL = list;
    }

    public b aDQ() {
        return this.dEQ;
    }

    public void a(b bVar) {
        this.dEQ = bVar;
    }

    public boolean aDR() {
        return this.dER;
    }

    public void hr(boolean z) {
        this.dER = z;
    }

    public String getGameName() {
        return this.gameName;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public List<h> aDS() {
        return this.dES;
    }

    public void bN(List<h> list) {
        this.dES = list;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public int akM() {
        return this.dET;
    }

    public void jz(int i) {
        this.dET = i;
    }

    public ArrayList<LiveCardData> aDT() {
        return this.dEU;
    }

    public void an(ArrayList<LiveCardData> arrayList) {
        this.dEU = arrayList;
    }

    public List<PhotoLiveCardData> aDU() {
        return this.dEV;
    }

    public String aDV() {
        return this.dEY;
    }

    public void mj(String str) {
        this.dEY = str;
    }

    public List<FrsTabInfo> aDW() {
        return this.dFc;
    }

    public void bO(List<FrsTabInfo> list) {
        this.dFc = list;
    }

    public void bP(List<PhotoLiveCardData> list) {
        this.dEV = list;
    }

    public boolean aDX() {
        return this.dEX != null;
    }

    public PhotoLiveCardData aDY() {
        return this.dEX;
    }

    public void c(PhotoLiveCardData photoLiveCardData) {
        this.dEX = photoLiveCardData;
    }

    public com.baidu.tbadk.core.data.k aDZ() {
        return this.dFa;
    }

    public void a(com.baidu.tbadk.core.data.k kVar) {
        this.dFa = kVar;
    }

    public int aEa() {
        return this.dEW;
    }

    public void mR(int i) {
        this.dEW = i;
    }

    public List<FeedForumData> aEb() {
        return this.dFd;
    }

    public void bQ(List<FeedForumData> list) {
        this.dFd = list;
    }

    public void mk(String str) {
        if (this.dFd != null && str != null) {
            for (FeedForumData feedForumData : this.dFd) {
                if (feedForumData != null && feedForumData.getForumId() != null && feedForumData.getForumId().equals(str)) {
                    this.dFd.remove(feedForumData);
                    return;
                }
            }
        }
    }

    public List<CategoryInfo> aEc() {
        return this.dFe;
    }

    public void bR(List<CategoryInfo> list) {
        this.dFe = list;
    }

    public void ml(String str) {
        this.dFf = str;
    }

    public String aEd() {
        return this.dFf;
    }
}

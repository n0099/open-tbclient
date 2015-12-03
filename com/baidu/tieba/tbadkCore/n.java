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
    private AntiData Vx;
    protected com.baidu.tbadk.core.data.q ceI;
    protected ForumData czh;
    private UserData czn;
    private List<FrsTabInfo> dxB;
    private List<FeedForumData> dxC;
    private List<CategoryInfo> dxD;
    protected List<Long> dxk;
    private o dxl;
    protected boolean dxm;
    protected String dxn;
    protected q dxo;
    private b dxp;
    private boolean dxq;
    private ArrayList<LiveCardData> dxt;
    private List<PhotoLiveCardData> dxu;
    private int dxv;
    private PhotoLiveCardData dxw;
    private String dxx;
    private com.baidu.tbadk.core.data.k dxz;
    private String gameName;
    protected ArrayList<com.baidu.adp.widget.ListView.u> threadList;
    private HashMap<String, MetaData> userMap;
    private List<h> dxr = new ArrayList();
    private int dxs = 0;
    private ArrayList<com.baidu.tbadk.core.data.g> dxy = new ArrayList<>();
    protected com.baidu.tbadk.core.data.h dxA = null;
    private String dxE = null;

    public n() {
        initData();
    }

    private void initData() {
        this.czh = new ForumData();
        this.threadList = new ArrayList<>();
        this.userMap = new HashMap<>();
        this.ceI = new com.baidu.tbadk.core.data.q();
        this.dxl = new o();
        this.czn = new UserData();
        this.dxo = new q();
        c(new AntiData());
        a(new b());
    }

    public FrsPageResIdl U(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            FrsPageResIdl frsPageResIdl = (FrsPageResIdl) new Wire(new Class[0]).parseFrom(bArr, FrsPageResIdl.class);
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
                                this.dxy.add(gVar);
                            }
                        }
                    }
                }
                if (dataRes.activityhead != null && dataRes.activityhead.head_imgs != null && dataRes.activityhead.head_imgs.size() > 0) {
                    this.dxA = new com.baidu.tbadk.core.data.h();
                    this.dxA.a(dataRes.activityhead);
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
                jb(dataRes.is_new_url.intValue());
                this.dxm = dataRes.fortune_bag.intValue() == 1;
                this.dxn = dataRes.fortune_desc;
                if (dataRes.forum != null) {
                    this.dxq = dataRes.forum.has_game.intValue() == 1;
                    this.dxx = dataRes.forum.game_url;
                    this.gameName = dataRes.forum.game_name;
                }
                List<StarEnter> list2 = dataRes.star_enter;
                this.dxr.clear();
                if (list2 != null) {
                    for (int i3 = 0; i3 < list2.size(); i3++) {
                        h hVar = new h();
                        hVar.a(list2.get(i3));
                        this.dxr.add(hVar);
                    }
                }
                this.dxo.a(dataRes.gcon_account);
                this.czh.parserProtobuf(dataRes.forum);
                long j = 0;
                if (dataRes.forum != null) {
                    j = dataRes.forum.id.longValue();
                }
                b(dataRes.thread_list, j);
                this.dxk = dataRes.thread_id_list;
                this.Vx.parserProtobuf(dataRes.anti);
                this.dxp.a(dataRes.group);
                this.ceI.a(dataRes.page);
                this.dxl.a(dataRes.frs_star);
                this.czn.parserProtobuf(dataRes.user);
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.czn.getIsSelectTail());
                }
                List<AnchorInfo> list3 = dataRes.forum_livegroup_list;
                this.dxt = new ArrayList<>();
                if (list3 != null) {
                    for (int i4 = 0; i4 < list3.size(); i4++) {
                        LiveCardData liveCardData = new LiveCardData();
                        liveCardData.parserProtobuf(list3.get(i4));
                        this.dxt.add(liveCardData);
                    }
                }
                this.dxB = dataRes.frs_tab_info;
                List<ZhiBoInfoTW> list4 = dataRes.twzhibo_info;
                if (list4 != null && list4.size() > 0) {
                    this.dxu = new ArrayList();
                    int size = list4.size();
                    for (int i5 = 0; i5 < size; i5++) {
                        PhotoLiveCardData photoLiveCardData = new PhotoLiveCardData();
                        photoLiveCardData.parserProtobuf(list4.get(i5));
                        if (photoLiveCardData.getShowStyle() < 0) {
                            photoLiveCardData.setShowStyle(photoLiveCardData.getRandom(3, i));
                        }
                        i = photoLiveCardData.getShowStyle();
                        photoLiveCardData.setShowExpressionViewIndexList(photoLiveCardData.getExpressionDatas());
                        this.dxu.add(photoLiveCardData);
                    }
                    this.dxv = dataRes.twzhibo_pos.intValue();
                }
                if (dataRes.hot_twzhibo_info != null) {
                    this.dxw = new PhotoLiveCardData();
                    if (this.dxw.getShowStyle() < 0) {
                        this.dxw.setShowStyle(this.dxw.getRandom(3, -1));
                    }
                    this.dxw.getShowStyle();
                    this.dxw.parserProtobuf(dataRes.hot_twzhibo_info);
                    this.dxw.setShowExpressionViewIndexList(this.dxw.getExpressionDatas());
                }
                this.dxD = dataRes.category_list;
                if (!ax.isEmpty(dataRes.bawu_enter_url)) {
                    this.dxE = dataRes.bawu_enter_url;
                }
                if (dataRes.store_card != null) {
                    this.dxz = new com.baidu.tbadk.core.data.k();
                    this.dxz.a(dataRes.store_card);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void bI(List<ThreadInfo> list) {
        b(list, 0L);
    }

    public void b(List<ThreadInfo> list, long j) {
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
                    if (zVar.sI() == 0 && j != 0) {
                        zVar.p(j);
                    }
                    zVar.k(this.dxy);
                    if (zVar.getThreadType() == 33 && !zVar.sW()) {
                        com.baidu.tbadk.core.data.w wVar = new com.baidu.tbadk.core.data.w();
                        wVar.a(zVar, i2);
                        if (wVar.sy() != null) {
                            i2 = wVar.sy().getShowStyle();
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
    public byte[] Dq() {
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

    public ForumData ajy() {
        return this.czh;
    }

    public void c(ForumData forumData) {
        this.czh = forumData;
    }

    public ArrayList<com.baidu.adp.widget.ListView.u> getThreadList() {
        return this.threadList;
    }

    public void am(ArrayList<com.baidu.adp.widget.ListView.u> arrayList) {
        this.threadList = arrayList;
    }

    public AntiData rZ() {
        return this.Vx;
    }

    public void c(AntiData antiData) {
        this.Vx = antiData;
    }

    public com.baidu.tbadk.core.data.q getPage() {
        return this.ceI;
    }

    public void b(com.baidu.tbadk.core.data.q qVar) {
        this.ceI = qVar;
    }

    public o aBC() {
        return this.dxl;
    }

    public void a(o oVar) {
        this.dxl = oVar;
    }

    public com.baidu.tbadk.core.data.h aBD() {
        return this.dxA;
    }

    public void b(com.baidu.tbadk.core.data.h hVar) {
        this.dxA = hVar;
    }

    public boolean aBE() {
        return this.dxm;
    }

    public void hh(boolean z) {
        this.dxm = z;
    }

    public String aBF() {
        return this.dxn;
    }

    public void mk(String str) {
        this.dxn = str;
    }

    public q aBG() {
        return this.dxo;
    }

    public void a(q qVar) {
        this.dxo = qVar;
    }

    public UserData getUserData() {
        return this.czn;
    }

    public void f(UserData userData) {
        this.czn = userData;
    }

    public List<Long> aBH() {
        return this.dxk;
    }

    public void bJ(List<Long> list) {
        this.dxk = list;
    }

    public b aBI() {
        return this.dxp;
    }

    public void a(b bVar) {
        this.dxp = bVar;
    }

    public boolean aBJ() {
        return this.dxq;
    }

    public void hi(boolean z) {
        this.dxq = z;
    }

    public String getGameName() {
        return this.gameName;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public List<h> aBK() {
        return this.dxr;
    }

    public void bK(List<h> list) {
        this.dxr = list;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public int ajE() {
        return this.dxs;
    }

    public void jb(int i) {
        this.dxs = i;
    }

    public ArrayList<LiveCardData> aBL() {
        return this.dxt;
    }

    public void an(ArrayList<LiveCardData> arrayList) {
        this.dxt = arrayList;
    }

    public List<PhotoLiveCardData> aBM() {
        return this.dxu;
    }

    public String aBN() {
        return this.dxx;
    }

    public void ml(String str) {
        this.dxx = str;
    }

    public List<FrsTabInfo> aBO() {
        return this.dxB;
    }

    public void bL(List<FrsTabInfo> list) {
        this.dxB = list;
    }

    public void bM(List<PhotoLiveCardData> list) {
        this.dxu = list;
    }

    public boolean aBP() {
        return this.dxw != null;
    }

    public PhotoLiveCardData aBQ() {
        return this.dxw;
    }

    public void c(PhotoLiveCardData photoLiveCardData) {
        this.dxw = photoLiveCardData;
    }

    public com.baidu.tbadk.core.data.k aBR() {
        return this.dxz;
    }

    public void a(com.baidu.tbadk.core.data.k kVar) {
        this.dxz = kVar;
    }

    public int aBS() {
        return this.dxv;
    }

    public void mp(int i) {
        this.dxv = i;
    }

    public List<FeedForumData> aBT() {
        return this.dxC;
    }

    public void bN(List<FeedForumData> list) {
        this.dxC = list;
    }

    public void mm(String str) {
        if (this.dxC != null && str != null) {
            for (FeedForumData feedForumData : this.dxC) {
                if (feedForumData != null && feedForumData.getForumId() != null && feedForumData.getForumId().equals(str)) {
                    this.dxC.remove(feedForumData);
                    return;
                }
            }
        }
    }

    public List<CategoryInfo> aBU() {
        return this.dxD;
    }

    public void bO(List<CategoryInfo> list) {
        this.dxD = list;
    }

    public void mn(String str) {
        this.dxE = str;
    }

    public String aBV() {
        return this.dxE;
    }
}

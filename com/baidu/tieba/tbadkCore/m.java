package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PhotoLiveCardData;
import com.baidu.tbadk.core.data.UserData;
import com.squareup.wire.Message;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;
import tbclient.AnchorInfo;
import tbclient.FrsPage.ColorEgg;
import tbclient.FrsPage.DataRes;
import tbclient.FrsPage.FrsPageResIdl;
import tbclient.FrsPage.StarEnter;
import tbclient.FrsTabInfo;
import tbclient.ThreadInfo;
import tbclient.User;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class m implements com.baidu.tbadk.mvc.b.c {
    private AntiData UT;
    private List<FrsTabInfo> cXB;
    protected List<Long> cXl;
    private n cXm;
    protected boolean cXn;
    protected String cXo;
    protected p cXp;
    private b cXq;
    private boolean cXr;
    private ArrayList<LiveCardData> cXu;
    private List<PhotoLiveCardData> cXv;
    private int cXw;
    private PhotoLiveCardData cXx;
    private String cXy;
    protected com.baidu.tbadk.core.data.o caH;
    protected ForumData cgf;
    private UserData cgl;
    private String gameName;
    protected ArrayList<com.baidu.adp.widget.ListView.u> threadList;
    private HashMap<String, MetaData> userMap;
    private List<h> cXs = new ArrayList();
    private int cXt = 0;
    private ArrayList<com.baidu.tbadk.core.data.g> cXz = new ArrayList<>();
    protected com.baidu.tbadk.core.data.h cXA = null;

    public m() {
        initData();
    }

    private void initData() {
        this.cgf = new ForumData();
        this.threadList = new ArrayList<>();
        this.userMap = new HashMap<>();
        this.caH = new com.baidu.tbadk.core.data.o();
        this.cXm = new n();
        this.cgl = new UserData();
        this.cXp = new p();
        d(new AntiData());
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
        int i;
        if (dataRes != null) {
            try {
                initData();
                if (dataRes.color_egg != null && dataRes.color_egg.size() > 0) {
                    for (ColorEgg colorEgg : dataRes.color_egg) {
                        if (colorEgg != null && colorEgg.holiday_words != null && colorEgg.holiday_words.size() > 0) {
                            com.baidu.tbadk.core.data.g gVar = new com.baidu.tbadk.core.data.g();
                            if (gVar.a(colorEgg)) {
                                this.cXz.add(gVar);
                            }
                        }
                    }
                }
                if (dataRes.activityhead != null && dataRes.activityhead.head_imgs != null && dataRes.activityhead.head_imgs.size() > 0) {
                    this.cXA = new com.baidu.tbadk.core.data.h();
                    this.cXA.a(dataRes.activityhead);
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
                hT(dataRes.is_new_url.intValue());
                this.cXn = dataRes.fortune_bag.intValue() == 1;
                this.cXo = dataRes.fortune_desc;
                if (dataRes.forum != null) {
                    this.cXr = dataRes.forum.has_game.intValue() == 1;
                    this.cXy = dataRes.forum.game_url;
                    this.gameName = dataRes.forum.game_name;
                }
                List<StarEnter> list2 = dataRes.star_enter;
                this.cXs.clear();
                if (list2 != null) {
                    for (int i3 = 0; i3 < list2.size(); i3++) {
                        h hVar = new h();
                        hVar.a(list2.get(i3));
                        this.cXs.add(hVar);
                    }
                }
                this.cXp.a(dataRes.gcon_account);
                this.cgf.parserProtobuf(dataRes.forum);
                List<ThreadInfo> list3 = dataRes.thread_list;
                if (list3 != null) {
                    int i4 = 0;
                    int i5 = -1;
                    while (i4 < list3.size()) {
                        com.baidu.tbadk.core.data.w wVar = new com.baidu.tbadk.core.data.w();
                        wVar.setUserMap(this.userMap);
                        wVar.a(list3.get(i4));
                        wVar.parser_title();
                        wVar.j(this.cXz);
                        if (wVar.sq() == 33 && !wVar.sv()) {
                            com.baidu.tbadk.core.data.t tVar = new com.baidu.tbadk.core.data.t();
                            tVar.a(wVar, i5);
                            i = tVar.sc() != null ? tVar.sc().getShowStyle() : i5;
                            if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                                this.threadList.add(tVar);
                            }
                        } else {
                            this.threadList.add(wVar);
                            i = i5;
                        }
                        i4++;
                        i5 = i;
                    }
                }
                this.cXl = dataRes.thread_id_list;
                this.UT.parserProtobuf(dataRes.anti);
                this.cXq.a(dataRes.group);
                this.caH.a(dataRes.page);
                this.cXm.a(dataRes.frs_star);
                this.cgl.parserProtobuf(dataRes.user);
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.cgl.getIsSelectTail());
                }
                List<AnchorInfo> list4 = dataRes.forum_livegroup_list;
                this.cXu = new ArrayList<>();
                if (list4 != null) {
                    for (int i6 = 0; i6 < list4.size(); i6++) {
                        LiveCardData liveCardData = new LiveCardData();
                        liveCardData.parserProtobuf(list4.get(i6));
                        this.cXu.add(liveCardData);
                    }
                }
                this.cXB = dataRes.frs_tab_info;
                List<ZhiBoInfoTW> list5 = dataRes.twzhibo_info;
                if (list5 != null && list5.size() > 0) {
                    this.cXv = new ArrayList();
                    int size = list5.size();
                    int i7 = -1;
                    for (int i8 = 0; i8 < size; i8++) {
                        PhotoLiveCardData photoLiveCardData = new PhotoLiveCardData();
                        photoLiveCardData.parserProtobuf(list5.get(i8));
                        if (photoLiveCardData.getShowStyle() < 0) {
                            photoLiveCardData.setShowStyle(photoLiveCardData.getRandom(3, i7));
                        }
                        i7 = photoLiveCardData.getShowStyle();
                        photoLiveCardData.setShowExpressionViewIndexList(photoLiveCardData.getExpressionDatas());
                        this.cXv.add(photoLiveCardData);
                    }
                    this.cXw = dataRes.twzhibo_pos.intValue();
                }
                if (dataRes.hot_twzhibo_info != null) {
                    this.cXx = new PhotoLiveCardData();
                    if (this.cXx.getShowStyle() < 0) {
                        this.cXx.setShowStyle(this.cXx.getRandom(3, -1));
                    }
                    this.cXx.getShowStyle();
                    this.cXx.parserProtobuf(dataRes.hot_twzhibo_info);
                    this.cXx.setShowExpressionViewIndexList(this.cXx.getExpressionDatas());
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] Cz() {
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

    public ForumData aeN() {
        return this.cgf;
    }

    public void c(ForumData forumData) {
        this.cgf = forumData;
    }

    public ArrayList<com.baidu.adp.widget.ListView.u> getThreadList() {
        return this.threadList;
    }

    public void af(ArrayList<com.baidu.adp.widget.ListView.u> arrayList) {
        this.threadList = arrayList;
    }

    public AntiData rF() {
        return this.UT;
    }

    public void d(AntiData antiData) {
        this.UT = antiData;
    }

    public com.baidu.tbadk.core.data.o getPage() {
        return this.caH;
    }

    public void b(com.baidu.tbadk.core.data.o oVar) {
        this.caH = oVar;
    }

    public n avu() {
        return this.cXm;
    }

    public void a(n nVar) {
        this.cXm = nVar;
    }

    public com.baidu.tbadk.core.data.h avv() {
        return this.cXA;
    }

    public void b(com.baidu.tbadk.core.data.h hVar) {
        this.cXA = hVar;
    }

    public boolean avw() {
        return this.cXn;
    }

    public void gq(boolean z) {
        this.cXn = z;
    }

    public String avx() {
        return this.cXo;
    }

    public void ls(String str) {
        this.cXo = str;
    }

    public p avy() {
        return this.cXp;
    }

    public void a(p pVar) {
        this.cXp = pVar;
    }

    public UserData getUserData() {
        return this.cgl;
    }

    public void i(UserData userData) {
        this.cgl = userData;
    }

    public List<Long> avz() {
        return this.cXl;
    }

    public void br(List<Long> list) {
        this.cXl = list;
    }

    public b avA() {
        return this.cXq;
    }

    public void a(b bVar) {
        this.cXq = bVar;
    }

    public boolean avB() {
        return this.cXr;
    }

    public void gr(boolean z) {
        this.cXr = z;
    }

    public String getGameName() {
        return this.gameName;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public List<h> avC() {
        return this.cXs;
    }

    public void bs(List<h> list) {
        this.cXs = list;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public int aeT() {
        return this.cXt;
    }

    public void hT(int i) {
        this.cXt = i;
    }

    public ArrayList<LiveCardData> avD() {
        return this.cXu;
    }

    public void ag(ArrayList<LiveCardData> arrayList) {
        this.cXu = arrayList;
    }

    public List<PhotoLiveCardData> avE() {
        return this.cXv;
    }

    public String avF() {
        return this.cXy;
    }

    public void lt(String str) {
        this.cXy = str;
    }

    public List<FrsTabInfo> avG() {
        return this.cXB;
    }

    public void bt(List<FrsTabInfo> list) {
        this.cXB = list;
    }

    public void bu(List<PhotoLiveCardData> list) {
        this.cXv = list;
    }

    public boolean avH() {
        return this.cXx != null;
    }

    public PhotoLiveCardData avI() {
        return this.cXx;
    }

    public void c(PhotoLiveCardData photoLiveCardData) {
        this.cXx = photoLiveCardData;
    }

    public int avJ() {
        return this.cXw;
    }

    public void kR(int i) {
        this.cXw = i;
    }
}

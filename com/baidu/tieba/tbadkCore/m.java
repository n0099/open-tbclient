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
    private AntiData UR;
    protected List<Long> cWM;
    private n cWN;
    protected boolean cWO;
    protected String cWP;
    protected p cWQ;
    private b cWR;
    private boolean cWS;
    private ArrayList<LiveCardData> cWV;
    private List<PhotoLiveCardData> cWW;
    private int cWX;
    private PhotoLiveCardData cWY;
    private String cWZ;
    private List<FrsTabInfo> cXc;
    protected com.baidu.tbadk.core.data.n caw;
    protected ForumData cfU;
    private UserData cga;
    private String gameName;
    protected ArrayList<com.baidu.adp.widget.ListView.u> threadList;
    private HashMap<String, MetaData> userMap;
    private List<h> cWT = new ArrayList();
    private int cWU = 0;
    private ArrayList<com.baidu.tbadk.core.data.f> cXa = new ArrayList<>();
    protected com.baidu.tbadk.core.data.g cXb = null;

    public m() {
        initData();
    }

    private void initData() {
        this.cfU = new ForumData();
        this.threadList = new ArrayList<>();
        this.userMap = new HashMap<>();
        this.caw = new com.baidu.tbadk.core.data.n();
        this.cWN = new n();
        this.cga = new UserData();
        this.cWQ = new p();
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
                            com.baidu.tbadk.core.data.f fVar = new com.baidu.tbadk.core.data.f();
                            if (fVar.a(colorEgg)) {
                                this.cXa.add(fVar);
                            }
                        }
                    }
                }
                if (dataRes.activityhead != null && dataRes.activityhead.head_imgs != null && dataRes.activityhead.head_imgs.size() > 0) {
                    this.cXb = new com.baidu.tbadk.core.data.g();
                    this.cXb.a(dataRes.activityhead);
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
                this.cWO = dataRes.fortune_bag.intValue() == 1;
                this.cWP = dataRes.fortune_desc;
                if (dataRes.forum != null) {
                    this.cWS = dataRes.forum.has_game.intValue() == 1;
                    this.cWZ = dataRes.forum.game_url;
                    this.gameName = dataRes.forum.game_name;
                }
                List<StarEnter> list2 = dataRes.star_enter;
                this.cWT.clear();
                if (list2 != null) {
                    for (int i3 = 0; i3 < list2.size(); i3++) {
                        h hVar = new h();
                        hVar.a(list2.get(i3));
                        this.cWT.add(hVar);
                    }
                }
                this.cWQ.a(dataRes.gcon_account);
                this.cfU.parserProtobuf(dataRes.forum);
                List<ThreadInfo> list3 = dataRes.thread_list;
                if (list3 != null) {
                    int i4 = 0;
                    int i5 = -1;
                    while (i4 < list3.size()) {
                        com.baidu.tbadk.core.data.v vVar = new com.baidu.tbadk.core.data.v();
                        vVar.setUserMap(this.userMap);
                        vVar.a(list3.get(i4));
                        vVar.parser_title();
                        vVar.j(this.cXa);
                        if (vVar.sq() == 33 && !vVar.sv()) {
                            com.baidu.tbadk.core.data.s sVar = new com.baidu.tbadk.core.data.s();
                            sVar.a(vVar, i5);
                            i = sVar.sc() != null ? sVar.sc().getShowStyle() : i5;
                            if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                                this.threadList.add(sVar);
                            }
                        } else {
                            this.threadList.add(vVar);
                            i = i5;
                        }
                        i4++;
                        i5 = i;
                    }
                }
                this.cWM = dataRes.thread_id_list;
                this.UR.parserProtobuf(dataRes.anti);
                this.cWR.a(dataRes.group);
                this.caw.a(dataRes.page);
                this.cWN.a(dataRes.frs_star);
                this.cga.parserProtobuf(dataRes.user);
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.cga.getIsSelectTail());
                }
                List<AnchorInfo> list4 = dataRes.forum_livegroup_list;
                this.cWV = new ArrayList<>();
                if (list4 != null) {
                    for (int i6 = 0; i6 < list4.size(); i6++) {
                        LiveCardData liveCardData = new LiveCardData();
                        liveCardData.parserProtobuf(list4.get(i6));
                        this.cWV.add(liveCardData);
                    }
                }
                this.cXc = dataRes.frs_tab_info;
                List<ZhiBoInfoTW> list5 = dataRes.twzhibo_info;
                if (list5 != null && list5.size() > 0) {
                    this.cWW = new ArrayList();
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
                        this.cWW.add(photoLiveCardData);
                    }
                    this.cWX = dataRes.twzhibo_pos.intValue();
                }
                if (dataRes.hot_twzhibo_info != null) {
                    this.cWY = new PhotoLiveCardData();
                    if (this.cWY.getShowStyle() < 0) {
                        this.cWY.setShowStyle(this.cWY.getRandom(3, -1));
                    }
                    this.cWY.getShowStyle();
                    this.cWY.parserProtobuf(dataRes.hot_twzhibo_info);
                    this.cWY.setShowExpressionViewIndexList(this.cWY.getExpressionDatas());
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
        return this.cfU;
    }

    public void c(ForumData forumData) {
        this.cfU = forumData;
    }

    public ArrayList<com.baidu.adp.widget.ListView.u> getThreadList() {
        return this.threadList;
    }

    public void af(ArrayList<com.baidu.adp.widget.ListView.u> arrayList) {
        this.threadList = arrayList;
    }

    public AntiData rF() {
        return this.UR;
    }

    public void d(AntiData antiData) {
        this.UR = antiData;
    }

    public com.baidu.tbadk.core.data.n getPage() {
        return this.caw;
    }

    public void b(com.baidu.tbadk.core.data.n nVar) {
        this.caw = nVar;
    }

    public n avo() {
        return this.cWN;
    }

    public void a(n nVar) {
        this.cWN = nVar;
    }

    public com.baidu.tbadk.core.data.g avp() {
        return this.cXb;
    }

    public void b(com.baidu.tbadk.core.data.g gVar) {
        this.cXb = gVar;
    }

    public boolean avq() {
        return this.cWO;
    }

    public void gq(boolean z) {
        this.cWO = z;
    }

    public String avr() {
        return this.cWP;
    }

    public void lp(String str) {
        this.cWP = str;
    }

    public p avs() {
        return this.cWQ;
    }

    public void a(p pVar) {
        this.cWQ = pVar;
    }

    public UserData getUserData() {
        return this.cga;
    }

    public void i(UserData userData) {
        this.cga = userData;
    }

    public List<Long> avt() {
        return this.cWM;
    }

    public void bq(List<Long> list) {
        this.cWM = list;
    }

    public b avu() {
        return this.cWR;
    }

    public void a(b bVar) {
        this.cWR = bVar;
    }

    public boolean avv() {
        return this.cWS;
    }

    public void gr(boolean z) {
        this.cWS = z;
    }

    public String getGameName() {
        return this.gameName;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public List<h> avw() {
        return this.cWT;
    }

    public void br(List<h> list) {
        this.cWT = list;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public int aeT() {
        return this.cWU;
    }

    public void hT(int i) {
        this.cWU = i;
    }

    public ArrayList<LiveCardData> avx() {
        return this.cWV;
    }

    public void ag(ArrayList<LiveCardData> arrayList) {
        this.cWV = arrayList;
    }

    public List<PhotoLiveCardData> avy() {
        return this.cWW;
    }

    public String avz() {
        return this.cWZ;
    }

    public void lq(String str) {
        this.cWZ = str;
    }

    public List<FrsTabInfo> avA() {
        return this.cXc;
    }

    public void bs(List<FrsTabInfo> list) {
        this.cXc = list;
    }

    public void bt(List<PhotoLiveCardData> list) {
        this.cWW = list;
    }

    public boolean avB() {
        return this.cWY != null;
    }

    public PhotoLiveCardData avC() {
        return this.cWY;
    }

    public void c(PhotoLiveCardData photoLiveCardData) {
        this.cWY = photoLiveCardData;
    }

    public int avD() {
        return this.cWX;
    }

    public void kP(int i) {
        this.cWX = i;
    }
}

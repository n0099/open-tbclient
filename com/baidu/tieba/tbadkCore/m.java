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
public class m implements com.baidu.tbadk.mvc.b.c {
    private AntiData UV;
    protected List<Long> cYH;
    private n cYI;
    protected boolean cYJ;
    protected String cYK;
    protected p cYL;
    private b cYM;
    private boolean cYN;
    private ArrayList<LiveCardData> cYQ;
    private List<PhotoLiveCardData> cYR;
    private int cYS;
    private PhotoLiveCardData cYT;
    private String cYU;
    private List<FrsTabInfo> cYX;
    private List<CategoryInfo> cYY;
    protected com.baidu.tbadk.core.data.o cbi;
    protected ForumData cgK;
    private UserData cgQ;
    private String gameName;
    protected ArrayList<com.baidu.adp.widget.ListView.u> threadList;
    private HashMap<String, MetaData> userMap;
    private List<h> cYO = new ArrayList();
    private int cYP = 0;
    private ArrayList<com.baidu.tbadk.core.data.g> cYV = new ArrayList<>();
    protected com.baidu.tbadk.core.data.h cYW = null;

    public m() {
        initData();
    }

    private void initData() {
        this.cgK = new ForumData();
        this.threadList = new ArrayList<>();
        this.userMap = new HashMap<>();
        this.cbi = new com.baidu.tbadk.core.data.o();
        this.cYI = new n();
        this.cgQ = new UserData();
        this.cYL = new p();
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
                                this.cYV.add(gVar);
                            }
                        }
                    }
                }
                if (dataRes.activityhead != null && dataRes.activityhead.head_imgs != null && dataRes.activityhead.head_imgs.size() > 0) {
                    this.cYW = new com.baidu.tbadk.core.data.h();
                    this.cYW.a(dataRes.activityhead);
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
                ih(dataRes.is_new_url.intValue());
                this.cYJ = dataRes.fortune_bag.intValue() == 1;
                this.cYK = dataRes.fortune_desc;
                if (dataRes.forum != null) {
                    this.cYN = dataRes.forum.has_game.intValue() == 1;
                    this.cYU = dataRes.forum.game_url;
                    this.gameName = dataRes.forum.game_name;
                }
                List<StarEnter> list2 = dataRes.star_enter;
                this.cYO.clear();
                if (list2 != null) {
                    for (int i3 = 0; i3 < list2.size(); i3++) {
                        h hVar = new h();
                        hVar.a(list2.get(i3));
                        this.cYO.add(hVar);
                    }
                }
                this.cYL.a(dataRes.gcon_account);
                this.cgK.parserProtobuf(dataRes.forum);
                List<ThreadInfo> list3 = dataRes.thread_list;
                if (list3 != null) {
                    int i4 = 0;
                    int i5 = -1;
                    while (i4 < list3.size()) {
                        com.baidu.tbadk.core.data.w wVar = new com.baidu.tbadk.core.data.w();
                        wVar.setUserMap(this.userMap);
                        wVar.a(list3.get(i4));
                        wVar.parser_title();
                        wVar.j(this.cYV);
                        if (wVar.sq() == 33 && !wVar.sv()) {
                            com.baidu.tbadk.core.data.t tVar = new com.baidu.tbadk.core.data.t();
                            tVar.a(wVar, i5);
                            i = tVar.sb() != null ? tVar.sb().getShowStyle() : i5;
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
                this.cYH = dataRes.thread_id_list;
                this.UV.parserProtobuf(dataRes.anti);
                this.cYM.a(dataRes.group);
                this.cbi.a(dataRes.page);
                this.cYI.a(dataRes.frs_star);
                this.cgQ.parserProtobuf(dataRes.user);
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.cgQ.getIsSelectTail());
                }
                List<AnchorInfo> list4 = dataRes.forum_livegroup_list;
                this.cYQ = new ArrayList<>();
                if (list4 != null) {
                    for (int i6 = 0; i6 < list4.size(); i6++) {
                        LiveCardData liveCardData = new LiveCardData();
                        liveCardData.parserProtobuf(list4.get(i6));
                        this.cYQ.add(liveCardData);
                    }
                }
                this.cYX = dataRes.frs_tab_info;
                List<ZhiBoInfoTW> list5 = dataRes.twzhibo_info;
                if (list5 != null && list5.size() > 0) {
                    this.cYR = new ArrayList();
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
                        this.cYR.add(photoLiveCardData);
                    }
                    this.cYS = dataRes.twzhibo_pos.intValue();
                }
                if (dataRes.hot_twzhibo_info != null) {
                    this.cYT = new PhotoLiveCardData();
                    if (this.cYT.getShowStyle() < 0) {
                        this.cYT.setShowStyle(this.cYT.getRandom(3, -1));
                    }
                    this.cYT.getShowStyle();
                    this.cYT.parserProtobuf(dataRes.hot_twzhibo_info);
                    this.cYT.setShowExpressionViewIndexList(this.cYT.getExpressionDatas());
                }
                this.cYY = dataRes.category_list;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] Cp() {
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

    public ForumData afg() {
        return this.cgK;
    }

    public void c(ForumData forumData) {
        this.cgK = forumData;
    }

    public ArrayList<com.baidu.adp.widget.ListView.u> getThreadList() {
        return this.threadList;
    }

    public void af(ArrayList<com.baidu.adp.widget.ListView.u> arrayList) {
        this.threadList = arrayList;
    }

    public AntiData rE() {
        return this.UV;
    }

    public void d(AntiData antiData) {
        this.UV = antiData;
    }

    public com.baidu.tbadk.core.data.o getPage() {
        return this.cbi;
    }

    public void b(com.baidu.tbadk.core.data.o oVar) {
        this.cbi = oVar;
    }

    public n avX() {
        return this.cYI;
    }

    public void a(n nVar) {
        this.cYI = nVar;
    }

    public com.baidu.tbadk.core.data.h avY() {
        return this.cYW;
    }

    public void b(com.baidu.tbadk.core.data.h hVar) {
        this.cYW = hVar;
    }

    public boolean avZ() {
        return this.cYJ;
    }

    public void gt(boolean z) {
        this.cYJ = z;
    }

    public String awa() {
        return this.cYK;
    }

    public void lw(String str) {
        this.cYK = str;
    }

    public p awb() {
        return this.cYL;
    }

    public void a(p pVar) {
        this.cYL = pVar;
    }

    public UserData getUserData() {
        return this.cgQ;
    }

    public void i(UserData userData) {
        this.cgQ = userData;
    }

    public List<Long> awc() {
        return this.cYH;
    }

    public void bv(List<Long> list) {
        this.cYH = list;
    }

    public b awd() {
        return this.cYM;
    }

    public void a(b bVar) {
        this.cYM = bVar;
    }

    public boolean awe() {
        return this.cYN;
    }

    public void gu(boolean z) {
        this.cYN = z;
    }

    public String getGameName() {
        return this.gameName;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public List<h> awf() {
        return this.cYO;
    }

    public void bw(List<h> list) {
        this.cYO = list;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public int afm() {
        return this.cYP;
    }

    public void ih(int i) {
        this.cYP = i;
    }

    public ArrayList<LiveCardData> awg() {
        return this.cYQ;
    }

    public void ag(ArrayList<LiveCardData> arrayList) {
        this.cYQ = arrayList;
    }

    public List<PhotoLiveCardData> awh() {
        return this.cYR;
    }

    public String awi() {
        return this.cYU;
    }

    public void lx(String str) {
        this.cYU = str;
    }

    public List<FrsTabInfo> awj() {
        return this.cYX;
    }

    public void bx(List<FrsTabInfo> list) {
        this.cYX = list;
    }

    public void by(List<PhotoLiveCardData> list) {
        this.cYR = list;
    }

    public boolean awk() {
        return this.cYT != null;
    }

    public PhotoLiveCardData awl() {
        return this.cYT;
    }

    public void c(PhotoLiveCardData photoLiveCardData) {
        this.cYT = photoLiveCardData;
    }

    public int awm() {
        return this.cYS;
    }

    public void lf(int i) {
        this.cYS = i;
    }

    public List<CategoryInfo> awn() {
        return this.cYY;
    }

    public void bz(List<CategoryInfo> list) {
        this.cYY = list;
    }
}

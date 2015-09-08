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
    private AntiData Vc;
    protected com.baidu.tbadk.core.data.o bWI;
    protected p cPA;
    private b cPB;
    private boolean cPC;
    private ArrayList<LiveCardData> cPF;
    private List<PhotoLiveCardData> cPG;
    private int cPH;
    private PhotoLiveCardData cPI;
    private String cPJ;
    private List<FrsTabInfo> cPM;
    protected List<Long> cPw;
    private n cPx;
    protected boolean cPy;
    protected String cPz;
    protected ForumData caQ;
    private UserData caW;
    private String gameName;
    protected ArrayList<com.baidu.adp.widget.ListView.u> threadList;
    private HashMap<String, MetaData> userMap;
    private List<h> cPD = new ArrayList();
    private int cPE = 0;
    private ArrayList<com.baidu.tbadk.core.data.g> cPK = new ArrayList<>();
    protected com.baidu.tbadk.core.data.h cPL = null;

    public m() {
        initData();
    }

    private void initData() {
        this.caQ = new ForumData();
        this.threadList = new ArrayList<>();
        this.userMap = new HashMap<>();
        this.bWI = new com.baidu.tbadk.core.data.o();
        this.cPx = new n();
        this.caW = new UserData();
        this.cPA = new p();
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
                                this.cPK.add(gVar);
                            }
                        }
                    }
                }
                if (dataRes.activityhead != null && dataRes.activityhead.head_imgs != null && dataRes.activityhead.head_imgs.size() > 0) {
                    this.cPL = new com.baidu.tbadk.core.data.h();
                    this.cPL.a(dataRes.activityhead);
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
                hL(dataRes.is_new_url.intValue());
                this.cPy = dataRes.fortune_bag.intValue() == 1;
                this.cPz = dataRes.fortune_desc;
                if (dataRes.forum != null) {
                    this.cPC = dataRes.forum.has_game.intValue() == 1;
                    this.cPJ = dataRes.forum.game_url;
                    this.gameName = dataRes.forum.game_name;
                }
                List<StarEnter> list2 = dataRes.star_enter;
                this.cPD.clear();
                if (list2 != null) {
                    for (int i3 = 0; i3 < list2.size(); i3++) {
                        h hVar = new h();
                        hVar.a(list2.get(i3));
                        this.cPD.add(hVar);
                    }
                }
                this.cPA.a(dataRes.gcon_account);
                this.caQ.parserProtobuf(dataRes.forum);
                List<ThreadInfo> list3 = dataRes.thread_list;
                if (list3 != null) {
                    for (int i4 = 0; i4 < list3.size(); i4++) {
                        com.baidu.tbadk.core.data.x xVar = new com.baidu.tbadk.core.data.x();
                        xVar.setUserMap(this.userMap);
                        xVar.a(list3.get(i4));
                        xVar.parser_title();
                        xVar.j(this.cPK);
                        if (xVar.sv() == 33 && !xVar.sA()) {
                            com.baidu.tbadk.core.data.t tVar = new com.baidu.tbadk.core.data.t();
                            tVar.a(xVar);
                            if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                                this.threadList.add(tVar);
                            }
                        } else {
                            this.threadList.add(xVar);
                        }
                    }
                }
                this.cPw = dataRes.thread_id_list;
                this.Vc.parserProtobuf(dataRes.anti);
                this.cPB.a(dataRes.group);
                this.bWI.a(dataRes.page);
                this.cPx.a(dataRes.frs_star);
                this.caW.parserProtobuf(dataRes.user);
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.caW.getIsSelectTail());
                }
                List<AnchorInfo> list4 = dataRes.forum_livegroup_list;
                this.cPF = new ArrayList<>();
                if (list4 != null) {
                    for (int i5 = 0; i5 < list4.size(); i5++) {
                        LiveCardData liveCardData = new LiveCardData();
                        liveCardData.parserProtobuf(list4.get(i5));
                        this.cPF.add(liveCardData);
                    }
                }
                this.cPM = dataRes.frs_tab_info;
                List<ZhiBoInfoTW> list5 = dataRes.twzhibo_info;
                if (list5 != null && list5.size() > 0) {
                    this.cPG = new ArrayList();
                    int size = list5.size();
                    for (int i6 = 0; i6 < size; i6++) {
                        PhotoLiveCardData photoLiveCardData = new PhotoLiveCardData();
                        photoLiveCardData.parserProtobuf(list5.get(i6));
                        if (photoLiveCardData.getShowStyle() < 0) {
                            photoLiveCardData.setShowStyle(photoLiveCardData.getRandom(3, i));
                        }
                        i = photoLiveCardData.getShowStyle();
                        photoLiveCardData.setShowExpressionViewIndexList(photoLiveCardData.getExpressionDatas());
                        this.cPG.add(photoLiveCardData);
                    }
                    this.cPH = dataRes.twzhibo_pos.intValue();
                }
                if (dataRes.hot_twzhibo_info != null) {
                    this.cPI = new PhotoLiveCardData();
                    if (this.cPI.getShowStyle() < 0) {
                        this.cPI.setShowStyle(this.cPI.getRandom(3, -1));
                    }
                    this.cPI.getShowStyle();
                    this.cPI.parserProtobuf(dataRes.hot_twzhibo_info);
                    this.cPI.setShowExpressionViewIndexList(this.cPI.getExpressionDatas());
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] CM() {
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

    public ForumData acP() {
        return this.caQ;
    }

    public void c(ForumData forumData) {
        this.caQ = forumData;
    }

    public ArrayList<com.baidu.adp.widget.ListView.u> getThreadList() {
        return this.threadList;
    }

    public void ad(ArrayList<com.baidu.adp.widget.ListView.u> arrayList) {
        this.threadList = arrayList;
    }

    public AntiData rK() {
        return this.Vc;
    }

    public void c(AntiData antiData) {
        this.Vc = antiData;
    }

    public com.baidu.tbadk.core.data.o getPage() {
        return this.bWI;
    }

    public void a(com.baidu.tbadk.core.data.o oVar) {
        this.bWI = oVar;
    }

    public n asY() {
        return this.cPx;
    }

    public void a(n nVar) {
        this.cPx = nVar;
    }

    public com.baidu.tbadk.core.data.h asZ() {
        return this.cPL;
    }

    public void b(com.baidu.tbadk.core.data.h hVar) {
        this.cPL = hVar;
    }

    public boolean ata() {
        return this.cPy;
    }

    public void gf(boolean z) {
        this.cPy = z;
    }

    public String atb() {
        return this.cPz;
    }

    public void kR(String str) {
        this.cPz = str;
    }

    public p atc() {
        return this.cPA;
    }

    public void a(p pVar) {
        this.cPA = pVar;
    }

    public UserData getUserData() {
        return this.caW;
    }

    public void h(UserData userData) {
        this.caW = userData;
    }

    public List<Long> atd() {
        return this.cPw;
    }

    public void bo(List<Long> list) {
        this.cPw = list;
    }

    public b ate() {
        return this.cPB;
    }

    public void a(b bVar) {
        this.cPB = bVar;
    }

    public boolean atf() {
        return this.cPC;
    }

    public void gg(boolean z) {
        this.cPC = z;
    }

    public String getGameName() {
        return this.gameName;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public List<h> atg() {
        return this.cPD;
    }

    public void bp(List<h> list) {
        this.cPD = list;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public int acV() {
        return this.cPE;
    }

    public void hL(int i) {
        this.cPE = i;
    }

    public ArrayList<LiveCardData> ath() {
        return this.cPF;
    }

    public void ae(ArrayList<LiveCardData> arrayList) {
        this.cPF = arrayList;
    }

    public List<PhotoLiveCardData> ati() {
        return this.cPG;
    }

    public String atj() {
        return this.cPJ;
    }

    public void kS(String str) {
        this.cPJ = str;
    }

    public List<FrsTabInfo> atk() {
        return this.cPM;
    }

    public void bq(List<FrsTabInfo> list) {
        this.cPM = list;
    }

    public void br(List<PhotoLiveCardData> list) {
        this.cPG = list;
    }

    public boolean atl() {
        return this.cPI != null;
    }

    public PhotoLiveCardData atm() {
        return this.cPI;
    }

    public void d(PhotoLiveCardData photoLiveCardData) {
        this.cPI = photoLiveCardData;
    }

    public int atn() {
        return this.cPH;
    }

    public void ko(int i) {
        this.cPH = i;
    }
}

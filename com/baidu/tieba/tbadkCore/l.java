package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
public class l implements com.baidu.tbadk.mvc.b.c {
    private AntiData Vd;
    protected com.baidu.tbadk.core.data.p bWc;
    protected ForumData bZW;
    protected List<Long> cGY;
    private m cGZ;
    protected boolean cHa;
    protected String cHb;
    protected o cHc;
    private b cHd;
    private boolean cHe;
    private ArrayList<LiveCardData> cHh;
    private List<PhotoLiveCardData> cHi;
    private String cHj;
    private List<FrsTabInfo> cHm;
    private UserData cac;
    private String gameName;
    protected ArrayList<com.baidu.adp.widget.ListView.u> threadList;
    private HashMap<String, MetaData> userMap;
    private List<g> cHf = new ArrayList();
    private int cHg = 0;
    private ArrayList<com.baidu.tbadk.core.data.g> cHk = new ArrayList<>();
    protected com.baidu.tbadk.core.data.h cHl = null;

    public l() {
        initData();
    }

    private void initData() {
        this.bZW = new ForumData();
        this.threadList = new ArrayList<>();
        this.userMap = new HashMap<>();
        this.bWc = new com.baidu.tbadk.core.data.p();
        this.cGZ = new m();
        this.cac = new UserData();
        this.cHc = new o();
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
        if (dataRes != null) {
            try {
                initData();
                if (dataRes.color_egg != null && dataRes.color_egg.size() > 0) {
                    for (ColorEgg colorEgg : dataRes.color_egg) {
                        if (colorEgg != null && colorEgg.holiday_words != null && colorEgg.holiday_words.size() > 0) {
                            com.baidu.tbadk.core.data.g gVar = new com.baidu.tbadk.core.data.g();
                            if (gVar.a(colorEgg)) {
                                this.cHk.add(gVar);
                            }
                        }
                    }
                }
                if (dataRes.activityhead != null && dataRes.activityhead.head_imgs != null && dataRes.activityhead.head_imgs.size() > 0) {
                    this.cHl = new com.baidu.tbadk.core.data.h();
                    this.cHl.a(dataRes.activityhead);
                }
                List<User> list = dataRes.user_list;
                if (list != null) {
                    for (int i = 0; i < list.size(); i++) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(list.get(i));
                        String userId = metaData.getUserId();
                        if (userId != null && !userId.equals("0")) {
                            this.userMap.put(metaData.getUserId(), metaData);
                        }
                    }
                }
                hB(dataRes.is_new_url.intValue());
                this.cHa = dataRes.fortune_bag.intValue() == 1;
                this.cHb = dataRes.fortune_desc;
                if (dataRes.forum != null) {
                    this.cHe = dataRes.forum.has_game.intValue() == 1;
                    this.cHj = dataRes.forum.game_url;
                    this.gameName = dataRes.forum.game_name;
                }
                List<StarEnter> list2 = dataRes.star_enter;
                this.cHf.clear();
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        g gVar2 = new g();
                        gVar2.a(list2.get(i2));
                        this.cHf.add(gVar2);
                    }
                }
                this.cHc.a(dataRes.gcon_account);
                this.bZW.parserProtobuf(dataRes.forum);
                List<ThreadInfo> list3 = dataRes.thread_list;
                if (list3 != null) {
                    for (int i3 = 0; i3 < list3.size(); i3++) {
                        com.baidu.tbadk.core.data.v vVar = new com.baidu.tbadk.core.data.v();
                        vVar.setUserMap(this.userMap);
                        vVar.a(list3.get(i3));
                        vVar.parser_title();
                        vVar.k(this.cHk);
                        this.threadList.add(vVar);
                    }
                }
                this.cGY = dataRes.thread_id_list;
                this.Vd.parserProtobuf(dataRes.anti);
                this.cHd.a(dataRes.group);
                this.bWc.a(dataRes.page);
                this.cGZ.a(dataRes.frs_star);
                this.cac.parserProtobuf(dataRes.user);
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.cac.getIsSelectTail());
                }
                List<AnchorInfo> list4 = dataRes.forum_livegroup_list;
                this.cHh = new ArrayList<>();
                if (list4 != null) {
                    for (int i4 = 0; i4 < list4.size(); i4++) {
                        LiveCardData liveCardData = new LiveCardData();
                        liveCardData.parserProtobuf(list4.get(i4));
                        this.cHh.add(liveCardData);
                    }
                }
                this.cHm = dataRes.frs_tab_info;
                List<ZhiBoInfoTW> list5 = dataRes.twzhibo_info;
                if (list5 != null && list5.size() > 0) {
                    this.cHi = new ArrayList();
                    int size = list5.size();
                    for (int i5 = 0; i5 < size; i5++) {
                        PhotoLiveCardData photoLiveCardData = new PhotoLiveCardData();
                        photoLiveCardData.parserProtobuf(list5.get(i5));
                        this.cHi.add(photoLiveCardData);
                    }
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] CC() {
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

    public ForumData acG() {
        return this.bZW;
    }

    public void c(ForumData forumData) {
        this.bZW = forumData;
    }

    public ArrayList<com.baidu.adp.widget.ListView.u> getThreadList() {
        return this.threadList;
    }

    public void X(ArrayList<com.baidu.adp.widget.ListView.u> arrayList) {
        this.threadList = arrayList;
    }

    public AntiData rM() {
        return this.Vd;
    }

    public void c(AntiData antiData) {
        this.Vd = antiData;
    }

    public com.baidu.tbadk.core.data.p getPage() {
        return this.bWc;
    }

    public void a(com.baidu.tbadk.core.data.p pVar) {
        this.bWc = pVar;
    }

    public m aoR() {
        return this.cGZ;
    }

    public void a(m mVar) {
        this.cGZ = mVar;
    }

    public com.baidu.tbadk.core.data.h aoS() {
        return this.cHl;
    }

    public void b(com.baidu.tbadk.core.data.h hVar) {
        this.cHl = hVar;
    }

    public boolean aoT() {
        return this.cHa;
    }

    public void fu(boolean z) {
        this.cHa = z;
    }

    public String aoU() {
        return this.cHb;
    }

    public void km(String str) {
        this.cHb = str;
    }

    public o aoV() {
        return this.cHc;
    }

    public void a(o oVar) {
        this.cHc = oVar;
    }

    public UserData getUserData() {
        return this.cac;
    }

    public void h(UserData userData) {
        this.cac = userData;
    }

    public List<Long> aoW() {
        return this.cGY;
    }

    public void bg(List<Long> list) {
        this.cGY = list;
    }

    public b aoX() {
        return this.cHd;
    }

    public void a(b bVar) {
        this.cHd = bVar;
    }

    public boolean aoY() {
        return this.cHe;
    }

    public void fv(boolean z) {
        this.cHe = z;
    }

    public String getGameName() {
        return this.gameName;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public List<g> aoZ() {
        return this.cHf;
    }

    public void bh(List<g> list) {
        this.cHf = list;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public int acL() {
        return this.cHg;
    }

    public void hB(int i) {
        this.cHg = i;
    }

    public ArrayList<LiveCardData> apa() {
        return this.cHh;
    }

    public void Y(ArrayList<LiveCardData> arrayList) {
        this.cHh = arrayList;
    }

    public String apb() {
        return this.cHj;
    }

    public void kn(String str) {
        this.cHj = str;
    }

    public List<FrsTabInfo> apc() {
        return this.cHm;
    }

    public void bi(List<FrsTabInfo> list) {
        this.cHm = list;
    }
}

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
import com.baidu.tbadk.core.data.am;
import com.baidu.tbadk.core.data.as;
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
import tbclient.FrsPage.StarEnter;
import tbclient.FrsTabInfo;
import tbclient.ThreadInfo;
import tbclient.User;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class m implements com.baidu.tbadk.mvc.b.c {
    public static final Wire WIRE = new Wire(new Class[0]);
    private AntiData TQ;
    protected com.baidu.tbadk.core.data.ac cxM;
    protected ForumData dcG;
    private UserData dcM;
    private List<FeedForumData> enB;
    private List<CategoryInfo> enC;
    private as enF;
    protected List<Long> enj;
    private n enk;
    protected boolean enl;
    protected String enm;
    protected p enn;
    private b eno;
    private boolean enp;
    private List<PhotoLiveCardData> ens;
    private int ent;
    private PhotoLiveCardData enu;
    private String env;
    private com.baidu.tbadk.core.data.r enx;
    private List<FrsTabInfo> enz;
    private String gameName;
    protected ArrayList<com.baidu.adp.widget.ListView.u> threadList;
    private HashMap<String, MetaData> userMap;
    private List<g> enq = new ArrayList();
    private int enr = 0;
    private ArrayList<com.baidu.tbadk.core.data.l> enw = new ArrayList<>();
    protected com.baidu.tbadk.core.data.m eny = null;
    private int enA = 1;
    private String enD = null;
    private com.baidu.tbadk.core.data.q enE = null;

    public m() {
        initData();
    }

    private void initData() {
        this.dcG = new ForumData();
        this.threadList = new ArrayList<>();
        this.userMap = new HashMap<>();
        this.cxM = new com.baidu.tbadk.core.data.ac();
        this.enk = new n();
        this.dcM = new UserData();
        this.enn = new p();
        d(new AntiData());
        a(new b());
    }

    public FrsPageResIdl B(byte[] bArr) {
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
                                this.enw.add(lVar);
                            }
                        }
                    }
                }
                if (dataRes.activityhead != null && dataRes.activityhead.head_imgs != null && dataRes.activityhead.head_imgs.size() > 0) {
                    this.eny = new com.baidu.tbadk.core.data.m();
                    this.eny.a(dataRes.activityhead);
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
                kB(dataRes.is_new_url.intValue());
                this.enl = dataRes.fortune_bag.intValue() == 1;
                this.enm = dataRes.fortune_desc;
                if (dataRes.forum != null) {
                    this.enp = dataRes.forum.has_game.intValue() == 1;
                    this.env = dataRes.forum.game_url;
                    this.gameName = dataRes.forum.game_name;
                }
                List<StarEnter> list2 = dataRes.star_enter;
                this.enq.clear();
                if (list2 != null) {
                    for (int i3 = 0; i3 < list2.size(); i3++) {
                        g gVar = new g();
                        gVar.a(list2.get(i3));
                        this.enq.add(gVar);
                    }
                }
                this.enn.a(dataRes.gcon_account);
                this.dcG.parserProtobuf(dataRes.forum);
                long longValue = dataRes.forum != null ? dataRes.forum.id.longValue() : 0L;
                a(dataRes.thread_list, longValue);
                this.enj = dataRes.thread_id_list;
                this.TQ.parserProtobuf(dataRes.anti);
                this.eno.a(dataRes.group);
                this.cxM.a(dataRes.page);
                this.enk.a(dataRes.frs_star);
                this.dcM.parserProtobuf(dataRes.user);
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.dcM.getIsSelectTail());
                }
                this.enz = dataRes.frs_tab_info;
                pi(dataRes.frs_tab_default.intValue());
                List<ZhiBoInfoTW> list3 = dataRes.twzhibo_info;
                if (list3 != null && list3.size() > 0) {
                    this.ens = new ArrayList();
                    int size = list3.size();
                    for (int i4 = 0; i4 < size; i4++) {
                        PhotoLiveCardData photoLiveCardData = new PhotoLiveCardData();
                        photoLiveCardData.parserProtobuf(list3.get(i4));
                        if (photoLiveCardData.getShowStyle() < 0) {
                            photoLiveCardData.setShowStyle(photoLiveCardData.getRandom(3, i));
                        }
                        i = photoLiveCardData.getShowStyle();
                        photoLiveCardData.setShowExpressionViewIndexList(photoLiveCardData.getExpressionDatas());
                        this.ens.add(photoLiveCardData);
                    }
                }
                this.ent = dataRes.twzhibo_pos.intValue();
                if (dataRes.hot_twzhibo_info != null) {
                    this.enu = new PhotoLiveCardData();
                    if (this.enu.getShowStyle() < 0) {
                        this.enu.setShowStyle(this.enu.getRandom(3, -1));
                    }
                    this.enu.getShowStyle();
                    this.enu.parserProtobuf(dataRes.hot_twzhibo_info);
                    this.enu.setShowExpressionViewIndexList(this.enu.getExpressionDatas());
                }
                this.enC = dataRes.category_list;
                if (!ay.isEmpty(dataRes.bawu_enter_url)) {
                    this.enD = dataRes.bawu_enter_url;
                }
                if (dataRes.head_sdk != null) {
                    this.enE = new com.baidu.tbadk.core.data.q();
                    this.enE.a(dataRes.head_sdk);
                }
                if (dataRes.store_card != null) {
                    this.enx = new com.baidu.tbadk.core.data.r();
                    this.enx.a(dataRes.store_card);
                }
                if (dataRes.card_shipin_info != null && dataRes.card_shipin_info.size() > 0) {
                    this.enF = new as();
                    this.enF.setUserMap(this.userMap);
                    this.enF.a(dataRes.card_shipin_info.get(0));
                    this.enF.parser_title();
                    if (this.enF.getFid() == 0 && longValue != 0) {
                        this.enF.setFid(longValue);
                    }
                    this.enF.i(this.enw);
                    this.enF.al(true);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    private void pi(int i) {
        this.enA = 1;
        if (this.enz != null && this.enz.size() > 0) {
            for (FrsTabInfo frsTabInfo : this.enz) {
                if (frsTabInfo != null && frsTabInfo.tab_id.intValue() == i) {
                    this.enA = i;
                    return;
                }
            }
        }
    }

    public void a(List<ThreadInfo> list, long j) {
        if (list != null) {
            boolean appResponseToIntentClass = TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
            int i = 0;
            int i2 = -1;
            while (true) {
                int i3 = i;
                if (i3 < list.size()) {
                    as asVar = new as();
                    asVar.setUserMap(this.userMap);
                    asVar.a(list.get(i3));
                    asVar.parser_title();
                    if (asVar.getFid() == 0 && j != 0) {
                        asVar.setFid(j);
                    }
                    asVar.i(this.enw);
                    if (asVar.getThreadType() == 33 && !asVar.tF()) {
                        am amVar = new am();
                        amVar.a(asVar, i2);
                        if (amVar.sT() != null) {
                            i2 = amVar.sT().getShowStyle();
                        }
                        if (appResponseToIntentClass) {
                            this.threadList.add(amVar);
                        }
                    } else {
                        this.threadList.add(asVar);
                    }
                    i = i3 + 1;
                } else {
                    return;
                }
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] Fn() {
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
    public void g(JSONObject jSONObject) {
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void a(Message message) {
    }

    public ForumData avu() {
        return this.dcG;
    }

    public void c(ForumData forumData) {
        this.dcG = forumData;
    }

    public ArrayList<com.baidu.adp.widget.ListView.u> getThreadList() {
        return this.threadList;
    }

    public void ao(ArrayList<com.baidu.adp.widget.ListView.u> arrayList) {
        this.threadList = arrayList;
    }

    public AntiData sf() {
        return this.TQ;
    }

    public void d(AntiData antiData) {
        this.TQ = antiData;
    }

    public com.baidu.tbadk.core.data.ac getPage() {
        return this.cxM;
    }

    public void b(com.baidu.tbadk.core.data.ac acVar) {
        this.cxM = acVar;
    }

    public n aRE() {
        return this.enk;
    }

    public void a(n nVar) {
        this.enk = nVar;
    }

    public com.baidu.tbadk.core.data.m aRF() {
        return this.eny;
    }

    public void b(com.baidu.tbadk.core.data.m mVar) {
        this.eny = mVar;
    }

    public boolean aRG() {
        return this.enl;
    }

    public void iG(boolean z) {
        this.enl = z;
    }

    public String aRH() {
        return this.enm;
    }

    public void nJ(String str) {
        this.enm = str;
    }

    public p aRI() {
        return this.enn;
    }

    public void a(p pVar) {
        this.enn = pVar;
    }

    public UserData getUserData() {
        return this.dcM;
    }

    public void f(UserData userData) {
        this.dcM = userData;
    }

    public List<Long> aRJ() {
        return this.enj;
    }

    public void co(List<Long> list) {
        this.enj = list;
    }

    public b aRK() {
        return this.eno;
    }

    public void a(b bVar) {
        this.eno = bVar;
    }

    public boolean aRL() {
        return this.enp;
    }

    public void iH(boolean z) {
        this.enp = z;
    }

    public String getGameName() {
        return this.gameName;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public List<g> aRM() {
        return this.enq;
    }

    public void cp(List<g> list) {
        this.enq = list;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public int avC() {
        return this.enr;
    }

    public void kB(int i) {
        this.enr = i;
    }

    public List<PhotoLiveCardData> aRN() {
        return this.ens;
    }

    public String aRO() {
        return this.env;
    }

    public void nK(String str) {
        this.env = str;
    }

    public List<FrsTabInfo> aRP() {
        return this.enz;
    }

    public void cq(List<FrsTabInfo> list) {
        this.enz = list;
    }

    public void cr(List<PhotoLiveCardData> list) {
        this.ens = list;
    }

    public boolean aRQ() {
        return this.enu != null;
    }

    public PhotoLiveCardData aRR() {
        return this.enu;
    }

    public void c(PhotoLiveCardData photoLiveCardData) {
        this.enu = photoLiveCardData;
    }

    public com.baidu.tbadk.core.data.r aRS() {
        return this.enx;
    }

    public void a(com.baidu.tbadk.core.data.r rVar) {
        this.enx = rVar;
    }

    public int aRT() {
        return this.ent;
    }

    public void pj(int i) {
        this.ent = i;
    }

    public List<FeedForumData> aRU() {
        return this.enB;
    }

    public void cs(List<FeedForumData> list) {
        this.enB = list;
    }

    public void nL(String str) {
        if (this.enB != null && str != null) {
            for (FeedForumData feedForumData : this.enB) {
                if (feedForumData != null && feedForumData.getForumId() != null && feedForumData.getForumId().equals(str)) {
                    this.enB.remove(feedForumData);
                    return;
                }
            }
        }
    }

    public List<CategoryInfo> aRV() {
        return this.enC;
    }

    public void ct(List<CategoryInfo> list) {
        this.enC = list;
    }

    public void nM(String str) {
        this.enD = str;
    }

    public String aRW() {
        return this.enD;
    }

    public as aRX() {
        return this.enF;
    }

    public void j(as asVar) {
        this.enF = asVar;
    }

    public int aRY() {
        return this.enA;
    }

    public void pk(int i) {
        this.enA = i;
    }

    public com.baidu.tbadk.core.data.q aRZ() {
        return this.enE;
    }

    public void b(com.baidu.tbadk.core.data.q qVar) {
        this.enE = qVar;
    }
}

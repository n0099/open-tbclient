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
import com.baidu.tbadk.core.util.aw;
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
    private static final Wire WIRE = new Wire(new Class[0]);
    private AntiData VM;
    protected ForumData cJt;
    private UserData cJy;
    protected com.baidu.tbadk.core.data.u cnk;
    protected List<Long> dUH;
    private n dUI;
    protected boolean dUJ;
    protected String dUK;
    protected p dUL;
    private b dUM;
    private boolean dUN;
    private List<PhotoLiveCardData> dUQ;
    private int dUR;
    private PhotoLiveCardData dUS;
    private String dUT;
    private com.baidu.tbadk.core.data.n dUV;
    private List<FrsTabInfo> dUX;
    private List<FeedForumData> dUY;
    private List<CategoryInfo> dUZ;
    private String gameName;
    protected ArrayList<com.baidu.adp.widget.ListView.u> threadList;
    private HashMap<String, MetaData> userMap;
    private List<g> dUO = new ArrayList();
    private int dUP = 0;
    private ArrayList<com.baidu.tbadk.core.data.i> dUU = new ArrayList<>();
    protected com.baidu.tbadk.core.data.j dUW = null;
    private String dVa = null;

    public m() {
        initData();
    }

    private void initData() {
        this.cJt = new ForumData();
        this.threadList = new ArrayList<>();
        this.userMap = new HashMap<>();
        this.cnk = new com.baidu.tbadk.core.data.u();
        this.dUI = new n();
        this.cJy = new UserData();
        this.dUL = new p();
        d(new AntiData());
        a(new b());
    }

    public FrsPageResIdl T(byte[] bArr) {
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
                            com.baidu.tbadk.core.data.i iVar = new com.baidu.tbadk.core.data.i();
                            if (iVar.a(colorEgg)) {
                                this.dUU.add(iVar);
                            }
                        }
                    }
                }
                if (dataRes.activityhead != null && dataRes.activityhead.head_imgs != null && dataRes.activityhead.head_imgs.size() > 0) {
                    this.dUW = new com.baidu.tbadk.core.data.j();
                    this.dUW.a(dataRes.activityhead);
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
                jW(dataRes.is_new_url.intValue());
                this.dUJ = dataRes.fortune_bag.intValue() == 1;
                this.dUK = dataRes.fortune_desc;
                if (dataRes.forum != null) {
                    this.dUN = dataRes.forum.has_game.intValue() == 1;
                    this.dUT = dataRes.forum.game_url;
                    this.gameName = dataRes.forum.game_name;
                }
                List<StarEnter> list2 = dataRes.star_enter;
                this.dUO.clear();
                if (list2 != null) {
                    for (int i3 = 0; i3 < list2.size(); i3++) {
                        g gVar = new g();
                        gVar.a(list2.get(i3));
                        this.dUO.add(gVar);
                    }
                }
                this.dUL.a(dataRes.gcon_account);
                this.cJt.parserProtobuf(dataRes.forum);
                long j = 0;
                if (dataRes.forum != null) {
                    j = dataRes.forum.id.longValue();
                }
                a(dataRes.thread_list, j);
                this.dUH = dataRes.thread_id_list;
                this.VM.parserProtobuf(dataRes.anti);
                this.dUM.a(dataRes.group);
                this.cnk.a(dataRes.page);
                this.dUI.a(dataRes.frs_star);
                this.cJy.parserProtobuf(dataRes.user);
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.cJy.getIsSelectTail());
                }
                this.dUX = dataRes.frs_tab_info;
                List<ZhiBoInfoTW> list3 = dataRes.twzhibo_info;
                if (list3 != null && list3.size() > 0) {
                    this.dUQ = new ArrayList();
                    int size = list3.size();
                    for (int i4 = 0; i4 < size; i4++) {
                        PhotoLiveCardData photoLiveCardData = new PhotoLiveCardData();
                        photoLiveCardData.parserProtobuf(list3.get(i4));
                        if (photoLiveCardData.getShowStyle() < 0) {
                            photoLiveCardData.setShowStyle(photoLiveCardData.getRandom(3, i));
                        }
                        i = photoLiveCardData.getShowStyle();
                        photoLiveCardData.setShowExpressionViewIndexList(photoLiveCardData.getExpressionDatas());
                        this.dUQ.add(photoLiveCardData);
                    }
                    this.dUR = dataRes.twzhibo_pos.intValue();
                }
                if (dataRes.hot_twzhibo_info != null) {
                    this.dUS = new PhotoLiveCardData();
                    if (this.dUS.getShowStyle() < 0) {
                        this.dUS.setShowStyle(this.dUS.getRandom(3, -1));
                    }
                    this.dUS.getShowStyle();
                    this.dUS.parserProtobuf(dataRes.hot_twzhibo_info);
                    this.dUS.setShowExpressionViewIndexList(this.dUS.getExpressionDatas());
                }
                this.dUZ = dataRes.category_list;
                if (!aw.isEmpty(dataRes.bawu_enter_url)) {
                    this.dVa = dataRes.bawu_enter_url;
                }
                if (dataRes.store_card != null) {
                    this.dUV = new com.baidu.tbadk.core.data.n();
                    this.dUV.a(dataRes.store_card);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void bX(List<ThreadInfo> list) {
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
                    com.baidu.tbadk.core.data.ah ahVar = new com.baidu.tbadk.core.data.ah();
                    ahVar.setUserMap(this.userMap);
                    ahVar.a(list.get(i3));
                    ahVar.parser_title();
                    if (ahVar.getFid() == 0 && j != 0) {
                        ahVar.setFid(j);
                    }
                    ahVar.l(this.dUU);
                    if (ahVar.getThreadType() == 33 && !ahVar.tB()) {
                        com.baidu.tbadk.core.data.ab abVar = new com.baidu.tbadk.core.data.ab();
                        abVar.a(ahVar, i2);
                        if (abVar.sS() != null) {
                            i2 = abVar.sS().getShowStyle();
                        }
                        if (appResponseToIntentClass) {
                            this.threadList.add(abVar);
                        }
                    } else {
                        this.threadList.add(ahVar);
                    }
                    i = i3 + 1;
                } else {
                    return;
                }
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] EA() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public boolean Q(byte[] bArr) {
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

    public ForumData aoE() {
        return this.cJt;
    }

    public void c(ForumData forumData) {
        this.cJt = forumData;
    }

    public ArrayList<com.baidu.adp.widget.ListView.u> getThreadList() {
        return this.threadList;
    }

    public void an(ArrayList<com.baidu.adp.widget.ListView.u> arrayList) {
        this.threadList = arrayList;
    }

    public AntiData so() {
        return this.VM;
    }

    public void d(AntiData antiData) {
        this.VM = antiData;
    }

    public com.baidu.tbadk.core.data.u getPage() {
        return this.cnk;
    }

    public void b(com.baidu.tbadk.core.data.u uVar) {
        this.cnk = uVar;
    }

    public n aKP() {
        return this.dUI;
    }

    public void a(n nVar) {
        this.dUI = nVar;
    }

    public com.baidu.tbadk.core.data.j aKQ() {
        return this.dUW;
    }

    public void b(com.baidu.tbadk.core.data.j jVar) {
        this.dUW = jVar;
    }

    public boolean aKR() {
        return this.dUJ;
    }

    public void hR(boolean z) {
        this.dUJ = z;
    }

    public String aKS() {
        return this.dUK;
    }

    public void my(String str) {
        this.dUK = str;
    }

    public p aKT() {
        return this.dUL;
    }

    public void a(p pVar) {
        this.dUL = pVar;
    }

    public UserData getUserData() {
        return this.cJy;
    }

    public void f(UserData userData) {
        this.cJy = userData;
    }

    public List<Long> aKU() {
        return this.dUH;
    }

    public void bY(List<Long> list) {
        this.dUH = list;
    }

    public b aKV() {
        return this.dUM;
    }

    public void a(b bVar) {
        this.dUM = bVar;
    }

    public boolean aKW() {
        return this.dUN;
    }

    public void hS(boolean z) {
        this.dUN = z;
    }

    public String getGameName() {
        return this.gameName;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public List<g> aKX() {
        return this.dUO;
    }

    public void bZ(List<g> list) {
        this.dUO = list;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public int aoK() {
        return this.dUP;
    }

    public void jW(int i) {
        this.dUP = i;
    }

    public List<PhotoLiveCardData> aKY() {
        return this.dUQ;
    }

    public String aKZ() {
        return this.dUT;
    }

    public void mz(String str) {
        this.dUT = str;
    }

    public List<FrsTabInfo> aLa() {
        return this.dUX;
    }

    public void ca(List<FrsTabInfo> list) {
        this.dUX = list;
    }

    public void cb(List<PhotoLiveCardData> list) {
        this.dUQ = list;
    }

    public boolean aLb() {
        return this.dUS != null;
    }

    public PhotoLiveCardData aLc() {
        return this.dUS;
    }

    public void c(PhotoLiveCardData photoLiveCardData) {
        this.dUS = photoLiveCardData;
    }

    public com.baidu.tbadk.core.data.n aLd() {
        return this.dUV;
    }

    public void a(com.baidu.tbadk.core.data.n nVar) {
        this.dUV = nVar;
    }

    public int aLe() {
        return this.dUR;
    }

    public void oc(int i) {
        this.dUR = i;
    }

    public List<FeedForumData> aLf() {
        return this.dUY;
    }

    public void cc(List<FeedForumData> list) {
        this.dUY = list;
    }

    public void mA(String str) {
        if (this.dUY != null && str != null) {
            for (FeedForumData feedForumData : this.dUY) {
                if (feedForumData != null && feedForumData.getForumId() != null && feedForumData.getForumId().equals(str)) {
                    this.dUY.remove(feedForumData);
                    return;
                }
            }
        }
    }

    public List<CategoryInfo> aLg() {
        return this.dUZ;
    }

    public void cd(List<CategoryInfo> list) {
        this.dUZ = list;
    }

    public void mB(String str) {
        this.dVa = str;
    }

    public String aLh() {
        return this.dVa;
    }
}

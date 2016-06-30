package com.baidu.tieba.tbadkCore;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.BannerThreadInfoData;
import com.baidu.tbadk.core.data.FeedForumData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PhotoLiveCardData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.util.ba;
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
public class n implements com.baidu.tbadk.mvc.b.c {
    public static final Wire WIRE = new Wire(new Class[0]);
    private AntiData OF;
    protected ForumData dLM;
    private UserData dLS;
    protected com.baidu.tbadk.core.data.af deh;
    private List<FeedForumData> eVA;
    private List<CategoryInfo> eVB;
    private az eVE;
    private com.baidu.tbadk.core.data.an eVF;
    private com.baidu.tbadk.core.data.k eVH;
    protected List<Long> eVh;
    private o eVi;
    protected boolean eVj;
    protected String eVk;
    protected q eVl;
    private b eVm;
    private boolean eVn;
    private List<PhotoLiveCardData> eVq;
    private int eVr;
    private PhotoLiveCardData eVs;
    private String eVt;
    private com.baidu.tbadk.core.data.t eVv;
    private List<FrsTabInfo> eVx;
    private NavTabInfo eVy;
    private String gameName;
    protected ArrayList<com.baidu.adp.widget.ListView.v> threadList;
    private HashMap<String, MetaData> userMap;
    private List<h> eVo = new ArrayList();
    private int eVp = 0;
    private ArrayList<com.baidu.tbadk.core.data.m> eVu = new ArrayList<>();
    protected com.baidu.tbadk.core.data.o eVw = null;
    private int eVz = 1;
    private String eVC = null;
    private com.baidu.tbadk.core.data.s eVD = null;
    private int eVG = -1;
    protected List<com.baidu.adp.widget.ListView.v> eVI = null;
    private List<BannerThreadInfoData> eVJ = null;
    private int eVK = 0;
    private int eVL = 0;

    public n() {
        initData();
    }

    private void initData() {
        this.dLM = new ForumData();
        this.threadList = new ArrayList<>();
        this.eVI = new ArrayList();
        this.userMap = new HashMap<>();
        this.deh = new com.baidu.tbadk.core.data.af();
        this.eVi = new o();
        this.dLS = new UserData();
        this.eVl = new q();
        d(new AntiData());
        a(new b());
        this.eVJ = new ArrayList();
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
        if (dataRes != null) {
            try {
                initData();
                if (dataRes.color_egg != null && dataRes.color_egg.size() > 0) {
                    for (ColorEgg colorEgg : dataRes.color_egg) {
                        if (colorEgg != null && colorEgg.holiday_words != null && colorEgg.holiday_words.size() > 0) {
                            com.baidu.tbadk.core.data.m mVar = new com.baidu.tbadk.core.data.m();
                            if (mVar.a(colorEgg)) {
                                this.eVu.add(mVar);
                            }
                        }
                    }
                }
                if (dataRes.activityhead != null && dataRes.activityhead.head_imgs != null && dataRes.activityhead.head_imgs.size() > 0) {
                    this.eVw = new com.baidu.tbadk.core.data.o();
                    this.eVw.a(dataRes.activityhead);
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
                lI(dataRes.is_new_url.intValue());
                this.eVj = dataRes.fortune_bag.intValue() == 1;
                this.eVk = dataRes.fortune_desc;
                if (dataRes.forum != null) {
                    this.eVn = dataRes.forum.has_game.intValue() == 1;
                    this.eVt = dataRes.forum.game_url;
                    this.gameName = dataRes.forum.game_name;
                }
                List<StarEnter> list2 = dataRes.star_enter;
                this.eVo.clear();
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        h hVar = new h();
                        hVar.a(list2.get(i2));
                        this.eVo.add(hVar);
                    }
                }
                this.eVl.a(dataRes.gcon_account);
                this.dLM.parserProtobuf(dataRes.forum);
                long longValue = dataRes.forum != null ? dataRes.forum.id.longValue() : 0L;
                this.eVh = dataRes.thread_id_list;
                this.OF.parserProtobuf(dataRes.anti);
                this.eVm.a(dataRes.group);
                this.deh.a(dataRes.page);
                this.eVi.a(dataRes.frs_star);
                this.dLS.parserProtobuf(dataRes.user);
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.dLS.getIsSelectTail());
                }
                this.eVx = dataRes.frs_tab_info;
                if (dataRes.nav_tab_info == null) {
                    NavTabInfo.Builder builder = new NavTabInfo.Builder();
                    builder.tab = dataRes.frs_tab_info;
                    this.eVy = builder.build(true);
                } else {
                    this.eVy = dataRes.nav_tab_info;
                }
                qr(dataRes.frs_tab_default.intValue());
                List<ZhiBoInfoTW> list3 = dataRes.twzhibo_info;
                if (list3 != null && list3.size() > 0) {
                    this.eVq = new ArrayList();
                    int size = list3.size();
                    int i3 = -1;
                    for (int i4 = 0; i4 < size; i4++) {
                        PhotoLiveCardData photoLiveCardData = new PhotoLiveCardData();
                        photoLiveCardData.parserProtobuf(list3.get(i4));
                        if (photoLiveCardData.getShowStyle() < 0) {
                            photoLiveCardData.setShowStyle(photoLiveCardData.getRandom(3, i3));
                        }
                        i3 = photoLiveCardData.getShowStyle();
                        photoLiveCardData.setShowExpressionViewIndexList(photoLiveCardData.getExpressionDatas());
                        this.eVq.add(photoLiveCardData);
                    }
                }
                this.eVr = dataRes.twzhibo_pos.intValue();
                if (dataRes.hot_twzhibo_info != null) {
                    this.eVs = new PhotoLiveCardData();
                    if (this.eVs.getShowStyle() < 0) {
                        this.eVs.setShowStyle(this.eVs.getRandom(3, -1));
                    }
                    this.eVs.getShowStyle();
                    this.eVs.parserProtobuf(dataRes.hot_twzhibo_info);
                    this.eVs.setShowExpressionViewIndexList(this.eVs.getExpressionDatas());
                }
                a(dataRes.thread_list, longValue);
                this.eVB = dataRes.category_list;
                if (!ba.isEmpty(dataRes.bawu_enter_url)) {
                    this.eVC = dataRes.bawu_enter_url;
                }
                if (dataRes.head_sdk != null) {
                    this.eVD = new com.baidu.tbadk.core.data.s();
                    this.eVD.a(dataRes.head_sdk);
                }
                if (dataRes.store_card != null) {
                    this.eVv = new com.baidu.tbadk.core.data.t();
                    this.eVv.a(dataRes.store_card);
                }
                if (dataRes.card_shipin_info != null && dataRes.card_shipin_info.size() > 0) {
                    this.eVE = new az();
                    this.eVE.setUserMap(this.userMap);
                    this.eVE.a(dataRes.card_shipin_info.get(0));
                    this.eVE.parser_title();
                    if (this.eVE.getFid() == 0 && longValue != 0) {
                        this.eVE.setFid(longValue);
                    }
                    this.eVE.i(this.eVu);
                    this.eVE.am(true);
                }
                if (dataRes.school_recom_info != null) {
                    this.eVG = dataRes.school_recom_pos.intValue();
                    this.eVF = new com.baidu.tbadk.core.data.an();
                    this.eVF.a(dataRes.school_recom_info);
                }
                if (dataRes.carrier_enter != null) {
                    this.eVH = new com.baidu.tbadk.core.data.k();
                    this.eVH.a(dataRes.carrier_enter);
                }
                if (dataRes.banner_thread_list != null) {
                    this.eVJ.clear();
                    int size2 = dataRes.banner_thread_list.size();
                    for (int i5 = 0; i5 < size2; i5++) {
                        BannerThreadInfoData bannerThreadInfoData = new BannerThreadInfoData();
                        bannerThreadInfoData.parserProtobuf(dataRes.banner_thread_list.get(i5));
                        this.eVJ.add(bannerThreadInfoData);
                    }
                }
                if (dataRes.vitality_info != null && dataRes.vitality_info.frequently_forum_info != null) {
                    this.eVK = dataRes.vitality_info.frequently_forum_info.forum_state.intValue();
                    this.eVL = dataRes.vitality_info.frequently_forum_info.access_flag.intValue();
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    private void qr(int i) {
        this.eVz = 1;
        if (this.eVx != null && this.eVx.size() > 0) {
            for (FrsTabInfo frsTabInfo : this.eVx) {
                if (frsTabInfo != null && frsTabInfo.tab_id.intValue() == i) {
                    this.eVz = i;
                    return;
                }
            }
        }
    }

    public void a(List<ThreadInfo> list, long j) {
        if (list != null) {
            boolean appResponseToIntentClass = TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
            for (int i = 0; i < list.size(); i++) {
                az azVar = new az();
                azVar.setUserMap(this.userMap);
                azVar.a(list.get(i));
                azVar.parser_title();
                if (azVar.getFid() == 0 && j != 0) {
                    azVar.setFid(j);
                }
                azVar.i(this.eVu);
                if (azVar.getThreadType() == 33 && !azVar.ra()) {
                    com.baidu.tbadk.core.data.aj ajVar = new com.baidu.tbadk.core.data.aj();
                    ajVar.a(azVar, 0);
                    ajVar.p(baw());
                    if (appResponseToIntentClass) {
                        this.threadList.add(ajVar);
                    }
                } else if (!TextUtils.isEmpty(azVar.rr())) {
                    com.baidu.tbadk.core.data.z zVar = new com.baidu.tbadk.core.data.z();
                    zVar.cm(azVar.rr());
                    this.threadList.add(zVar);
                } else {
                    this.threadList.add(azVar);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] Do() {
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

    public ForumData aDN() {
        return this.dLM;
    }

    public int bal() {
        return this.eVK;
    }

    public void qs(int i) {
        this.eVK = i;
    }

    public int bam() {
        return this.eVL;
    }

    public void qt(int i) {
        this.eVL = i;
    }

    public void c(ForumData forumData) {
        this.dLM = forumData;
    }

    public ArrayList<com.baidu.adp.widget.ListView.v> getThreadList() {
        return this.threadList;
    }

    public void ay(ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        this.threadList = arrayList;
    }

    public AntiData pt() {
        return this.OF;
    }

    public void d(AntiData antiData) {
        this.OF = antiData;
    }

    public com.baidu.tbadk.core.data.af getPage() {
        return this.deh;
    }

    public void a(com.baidu.tbadk.core.data.af afVar) {
        this.deh = afVar;
    }

    public o ban() {
        return this.eVi;
    }

    public void a(o oVar) {
        this.eVi = oVar;
    }

    public com.baidu.tbadk.core.data.o bao() {
        return this.eVw;
    }

    public void b(com.baidu.tbadk.core.data.o oVar) {
        this.eVw = oVar;
    }

    public boolean bap() {
        return this.eVj;
    }

    public void kg(boolean z) {
        this.eVj = z;
    }

    public String baq() {
        return this.eVk;
    }

    public void pn(String str) {
        this.eVk = str;
    }

    public q bar() {
        return this.eVl;
    }

    public void a(q qVar) {
        this.eVl = qVar;
    }

    public UserData getUserData() {
        return this.dLS;
    }

    public void f(UserData userData) {
        this.dLS = userData;
    }

    public List<Long> bas() {
        return this.eVh;
    }

    public void cG(List<Long> list) {
        this.eVh = list;
    }

    public b bat() {
        return this.eVm;
    }

    public void a(b bVar) {
        this.eVm = bVar;
    }

    public boolean bau() {
        return this.eVn;
    }

    public void kh(boolean z) {
        this.eVn = z;
    }

    public String getGameName() {
        return this.gameName;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public List<h> bav() {
        return this.eVo;
    }

    public void cH(List<h> list) {
        this.eVo = list;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public int aDV() {
        return this.eVp;
    }

    public void lI(int i) {
        this.eVp = i;
    }

    public List<PhotoLiveCardData> baw() {
        return this.eVq;
    }

    public String bax() {
        return this.eVt;
    }

    public void po(String str) {
        this.eVt = str;
    }

    public List<FrsTabInfo> bay() {
        return this.eVx;
    }

    public void cI(List<FrsTabInfo> list) {
        this.eVx = list;
    }

    public void cJ(List<PhotoLiveCardData> list) {
        this.eVq = list;
    }

    public boolean baz() {
        return this.eVs != null;
    }

    public PhotoLiveCardData baA() {
        return this.eVs;
    }

    public void c(PhotoLiveCardData photoLiveCardData) {
        this.eVs = photoLiveCardData;
    }

    public com.baidu.tbadk.core.data.t baB() {
        return this.eVv;
    }

    public void a(com.baidu.tbadk.core.data.t tVar) {
        this.eVv = tVar;
    }

    public int baC() {
        return this.eVr;
    }

    public void qu(int i) {
        this.eVr = i;
    }

    public List<FeedForumData> baD() {
        return this.eVA;
    }

    public void cK(List<FeedForumData> list) {
        this.eVA = list;
    }

    public void pp(String str) {
        if (this.eVA != null && str != null) {
            for (FeedForumData feedForumData : this.eVA) {
                if (feedForumData != null && feedForumData.getForumId() != null && feedForumData.getForumId().equals(str)) {
                    this.eVA.remove(feedForumData);
                    return;
                }
            }
        }
    }

    public List<CategoryInfo> baE() {
        return this.eVB;
    }

    public void cL(List<CategoryInfo> list) {
        this.eVB = list;
    }

    public void pq(String str) {
        this.eVC = str;
    }

    public String baF() {
        return this.eVC;
    }

    public az baG() {
        return this.eVE;
    }

    public void s(az azVar) {
        this.eVE = azVar;
    }

    public int baH() {
        return this.eVz;
    }

    public void qv(int i) {
        this.eVz = i;
    }

    public com.baidu.tbadk.core.data.s baI() {
        return this.eVD;
    }

    public void b(com.baidu.tbadk.core.data.s sVar) {
        this.eVD = sVar;
    }

    public int baJ() {
        return this.eVG;
    }

    public void qw(int i) {
        this.eVG = i;
    }

    public com.baidu.tbadk.core.data.an baK() {
        return this.eVF;
    }

    public void a(com.baidu.tbadk.core.data.an anVar) {
        this.eVF = anVar;
    }

    public NavTabInfo baL() {
        return this.eVy;
    }

    public void a(NavTabInfo navTabInfo) {
        this.eVy = navTabInfo;
    }

    public com.baidu.tbadk.core.data.k baM() {
        return this.eVH;
    }

    public void a(com.baidu.tbadk.core.data.k kVar) {
        this.eVH = kVar;
    }

    public void cM(List<BannerThreadInfoData> list) {
        this.eVJ = list;
    }

    public List<BannerThreadInfoData> baN() {
        return this.eVJ;
    }
}

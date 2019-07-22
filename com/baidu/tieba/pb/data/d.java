package com.baidu.tieba.pb.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.TwzhiboAnti;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.an;
import com.baidu.tbadk.core.data.ap;
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.core.data.ay;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.pb.pb.main.ad;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.tbadkCore.data.AppData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.usermute.MuteUser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.App;
import tbclient.PbPage.AppealInfo;
import tbclient.PbPage.DataRes;
import tbclient.PbPage.PbSortType;
import tbclient.Post;
import tbclient.SimpleForum;
import tbclient.SimpleUser;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes4.dex */
public class d {
    private List<bg> hHA;
    private int hHB;
    private AlaLiveInfoCoreData hHC;
    private TwzhiboAnti hHF;
    public AppealInfo hHG;
    private List<bc> hHH;
    private List<bc> hHI;
    public String hHK;
    private PostData hHL;
    private f hHM;
    public CardHListViewData hHN;
    private long hHO;
    private j hHP;
    public String hHQ;
    public int hHR;
    public int hHS;
    public List<PbSortType> hHT;
    public int hHU;
    public g hHV;
    private String hHW;
    private String hHX;
    private String hHs;
    private int hHt;
    private a hHy;
    private PostData hIa;
    private boolean hHx = true;
    private ArrayList<com.baidu.tieba.tbadkCore.data.m> hHD = new ArrayList<>();
    private com.baidu.tieba.tbadkCore.data.m hHE = null;
    private ForumData forum = new ForumData();
    private bc hHo = new bc();
    private bg dlT = new bg();
    private ArrayList<PostData> hHp = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private an page = new an();
    private AntiData anti = new AntiData();
    private com.baidu.tbadk.data.f hHq = new com.baidu.tbadk.data.f();
    private int hHr = 0;
    private final UserData userData = new UserData();
    private List<MuteUser> hHw = new ArrayList();
    private ap hHu = new ap();
    private aq hHz = new aq();
    private ad hHv = new ad();
    private m hHJ = new m();
    private List<ay.a> hHY = new ArrayList();
    private HashSet<String> hHZ = new HashSet<>();

    public boolean bSv() {
        return this.hHx;
    }

    public void od(boolean z) {
        this.hHx = z;
    }

    public d() {
        this.hHt = 0;
        this.hHF = null;
        this.hHt = 0;
        this.hHF = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.hHp != null && this.hHp.size() > 0;
    }

    public String[] eb(Context context) {
        String str = null;
        String str2 = "";
        if (isValid()) {
            int size = this.hHp.size() > 30 ? 30 : this.hHp.size();
            if (bSx() == null || bSx().aex() == null || com.baidu.tbadk.core.util.aq.isEmpty(bSx().aex().getUserId())) {
                return new String[]{null, ""};
            }
            String userId = bSx().aex().getUserId();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                PostData postData = (PostData) v.c(this.hHp, i);
                if (postData != null && postData.aex() != null && !com.baidu.tbadk.core.util.aq.isEmpty(postData.aex().getUserId()) && com.baidu.tbadk.core.util.aq.bV(userId, postData.aex().getUserId())) {
                    if (com.baidu.tbadk.core.util.aq.isEmpty(str)) {
                        str = postData.cpw();
                    }
                    String cpu = com.baidu.tbadk.core.util.aq.isEmpty(str2) ? postData.cpu() : str2;
                    if (!com.baidu.tbadk.core.util.aq.isEmpty(str) && !com.baidu.tbadk.core.util.aq.isEmpty(cpu)) {
                        str2 = cpu;
                        break;
                    }
                    str2 = cpu;
                }
                i++;
                str = str;
            }
            if (com.baidu.tbadk.core.util.aq.isEmpty(str)) {
                str = "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            }
            PostData postData2 = this.hHp.get(0);
            if (this.dlT != null && this.dlT.afp() != null && this.dlT.afp().getGroup_id() != 0) {
                str2 = "[" + context.getString(R.string.photo_live_tips) + "] " + str2;
            }
            if (this.dlT != null && this.dlT.afr() && postData2 != null && postData2.ayW() != null) {
                str = postData2.ayW().getThumbUrl();
            }
        }
        return new String[]{str, str2};
    }

    public ForumData getForum() {
        return this.forum;
    }

    public bc bSw() {
        return this.hHo;
    }

    public String getForumId() {
        if (this.forum == null) {
            return "";
        }
        return this.forum.getId();
    }

    public bg bSx() {
        return this.dlT;
    }

    public List<bg> bSy() {
        return this.hHA;
    }

    public String getThreadId() {
        if (this.dlT == null) {
            return "";
        }
        return this.dlT.getId();
    }

    public ArrayList<PostData> bSz() {
        return this.hHp;
    }

    public an getPage() {
        return this.page;
    }

    public ad bSA() {
        return this.hHv;
    }

    public aq bSB() {
        return this.hHz;
    }

    public void a(an anVar, int i) {
        this.page.ha(anVar.adp());
        this.page.gY(anVar.acE());
        this.page.gX(anVar.adm());
        this.page.hb(anVar.adq());
        this.page.gZ(anVar.ado());
        if (i == 0) {
            this.page = anVar;
        } else if (i == 1) {
            this.page.hc(anVar.adr());
        } else if (i == 2) {
            this.page.hd(anVar.ads());
        }
    }

    public AntiData getAnti() {
        return this.anti;
    }

    public UserData getUserData() {
        return this.userData;
    }

    public boolean aaB() {
        return this.dlT.aeF() != 0;
    }

    public void dx(boolean z) {
        if (this.dlT != null) {
            if (z) {
                this.dlT.hm(1);
            } else {
                this.dlT.hm(0);
            }
        }
    }

    public String aaA() {
        if (this.dlT != null) {
            return this.dlT.aeG();
        }
        return null;
    }

    public void BJ(String str) {
        if (this.dlT != null) {
            this.dlT.mC(str);
        }
    }

    public String bSC() {
        return this.hHX;
    }

    public boolean bSD() {
        return (this.dlT == null || this.dlT.aeI() == null || this.dlT.aeI().size() <= 0 || this.dlT.aeI().get(0) == null || !this.dlT.aeI().get(0).acF()) ? false : true;
    }

    public PostData bSE() {
        return this.hIa;
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                com.baidu.tieba.recapp.d.a.cit().DR(dataRes.asp_shown_info);
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
                setIsNewUrl(dataRes.is_new_url.intValue());
                this.forum.parserProtobuf(dataRes.forum);
                this.hHo.parserProtobuf(dataRes.display_forum);
                this.dlT.setUserMap(this.userMap);
                this.dlT.a(dataRes.thread);
                this.dlT.setCurrentPage(2);
                this.hHu.a(dataRes.news_info);
                switch (this.hHu.bHX) {
                    case 1:
                        this.hHv.hRS = this.hHu;
                        break;
                    case 2:
                        this.hHv.hRT = this.hHu;
                        break;
                    case 3:
                        this.hHv.hRU = this.hHu;
                        break;
                    default:
                        this.hHv.hRT = this.hHu;
                        break;
                }
                this.hHz.a(dataRes.recommend_book);
                List<Post> list2 = dataRes.post_list;
                if (list2 != null && list2.size() > 0) {
                    for (Post post : dataRes.post_list) {
                        if (!this.hHZ.contains(String.valueOf(post.id))) {
                            PostData postData = new PostData();
                            postData.setUserMap(this.userMap);
                            postData.qZ(this.forum.isBrandForum);
                            postData.a(post, context);
                            postData.a(bSx().aej());
                            this.hHZ.add(postData.getId());
                            if (postData.cpp() == 1 && this.dlT.afi()) {
                                if (bSD()) {
                                    postData.setPostType(0);
                                } else {
                                    postData.setPostType(this.dlT.afh());
                                }
                            } else if (postData.cpp() == 1 && this.dlT.afx()) {
                                postData.setPostType(41);
                            } else if (postData.cpp() == 1 && this.dlT != null && this.dlT.afr()) {
                                postData.setPostType(0);
                                postData.ayW();
                                if (this.dlT.aev() == null || this.dlT.aev().size() == 0) {
                                    JSONArray jSONArray = new JSONArray();
                                    JSONObject jSONObject = new JSONObject();
                                    try {
                                        jSONObject.put("type", 0);
                                        jSONObject.put("text", "");
                                        jSONArray.put(jSONObject);
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                    postData.c(TbRichTextView.a(context, jSONArray, false));
                                } else {
                                    postData.c(new TbRichText((Context) TbadkCoreApplication.getInst(), this.dlT.aev(), true));
                                }
                                this.hHL = postData;
                            }
                            if (postData.cpp() == 1 && this.dlT != null && this.dlT.isShareThread) {
                                postData.g(this.dlT.bLQ);
                            }
                            this.hHp.add(postData);
                        }
                    }
                }
                if (dataRes.first_floor_post != null) {
                    this.hIa = new PostData();
                    this.hIa.setUserMap(this.userMap);
                    this.hIa.qZ(this.forum.isBrandForum);
                    this.hIa.a(dataRes.first_floor_post, context);
                    if (this.dlT != null && this.dlT.isShareThread) {
                        this.hIa.g(this.dlT.bLQ);
                    }
                }
                this.page.a(dataRes.page);
                this.anti.parserProtobuf(dataRes.anti);
                this.hHq.a(dataRes.location);
                if (dataRes.user != null) {
                    this.hHr = dataRes.user.is_manager.intValue();
                }
                this.userData.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.hHw.add(muteUser);
                        }
                    }
                }
                this.dlT.hi(this.dlT.aeo() > 0 ? this.dlT.aeo() - 1 : 0);
                List<AppData> chB = r.chD().chB();
                if (chB != null) {
                    chB.clear();
                }
                this.hHE = null;
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        com.baidu.tieba.tbadkCore.data.m mVar = new com.baidu.tieba.tbadkCore.data.m();
                        mVar.d(app);
                        AppData cpd = mVar.cpd();
                        if (!this.hHD.contains(mVar) && cpd.goods != null && (!StringUtils.isNull(cpd.goods.user_name) || !StringUtils.isNull(cpd.goods.lego_card))) {
                            this.hHD.add(mVar);
                            if (chB != null) {
                                chB.add(mVar.cpd());
                            }
                        }
                    }
                    a(dataRes);
                }
                r.chD().chC();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.userData.getIsSelectTail());
                }
                this.hHF.parserProtobuf(dataRes.twzhibo_anti);
                this.hHG = dataRes.appeal_info;
                if (dataRes.god_card != null) {
                    this.hHy = new a();
                    this.hHy.a(dataRes.god_card);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.hHM = new f();
                    this.hHM.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.guess_like != null) {
                    this.hHN = new CardHListViewData();
                    this.hHN.parseProtobuf(dataRes.guess_like);
                }
                if (dataRes.feed_thread_list != null && dataRes.feed_thread_list.size() > 0) {
                    List<ThreadInfo> list3 = dataRes.feed_thread_list;
                    if (this.hHA == null) {
                        this.hHA = new ArrayList();
                    }
                    this.hHA.clear();
                    for (ThreadInfo threadInfo : list3) {
                        if (threadInfo != null) {
                            bg bgVar = new bg();
                            bgVar.a(threadInfo);
                            this.hHA.add(bgVar);
                        }
                    }
                    if (this.hHA != null && this.hHA.size() > 15) {
                        this.hHA = v.c(this.hHA, 0, 15);
                    }
                }
                this.hHB = dataRes.is_follow_current_channel.intValue();
                if (v.Z(dataRes.repost_recommend_forum_list) > 0) {
                    if (this.hHH == null) {
                        this.hHH = new ArrayList();
                    }
                    for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                        bc bcVar = new bc();
                        bcVar.parserProtobuf(simpleForum);
                        this.hHH.add(bcVar);
                    }
                }
                if (v.Z(dataRes.from_forum_list) > 0) {
                    if (this.hHI == null) {
                        this.hHI = new ArrayList();
                    }
                    for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                        if (simpleForum2 != null) {
                            bc bcVar2 = new bc();
                            bcVar2.parserProtobuf(simpleForum2);
                            this.hHI.add(bcVar2);
                        }
                    }
                }
                this.hHX = dataRes.multi_forum_text;
                if (this.hHO >= 0) {
                    this.hHO = dataRes.thread_freq_num.longValue();
                }
                this.hHP = new j();
                this.hHP.ccj = this.dlT;
                this.hHP.b(dataRes);
                this.hHQ = dataRes.partial_visible_toast;
                if (dataRes.follow_tip != null && dataRes.follow_tip.is_toast_tip.intValue() == 1) {
                    this.hHs = dataRes.follow_tip.tip_text;
                }
                this.hHC = new AlaLiveInfoCoreData();
                if (dataRes.ala_info != null) {
                    this.hHC.parserProtoBuf(dataRes.ala_info);
                }
                this.hHW = dataRes.fold_tip;
                this.hHR = dataRes.exp_news_today.intValue();
                this.hHS = dataRes.exp_guide_today.intValue();
                if (!v.aa(dataRes.thread_topic)) {
                    for (int i2 = 0; i2 < dataRes.thread_topic.size(); i2++) {
                        ay.a aVar = new ay.a();
                        aVar.a(dataRes.thread_topic.get(i2));
                        this.hHY.add(aVar);
                    }
                }
                this.hHT = dataRes.pb_sort_info;
                this.hHU = dataRes.sort_type.intValue();
                if (dataRes.manager_election != null) {
                    this.hHV = g.a(dataRes.manager_election);
                }
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }

    private void a(DataRes dataRes) {
        List<String> mo;
        App app = dataRes.banner_list.pb_banner_ad;
        com.baidu.tieba.tbadkCore.data.m mVar = new com.baidu.tieba.tbadkCore.data.m();
        mVar.jeU = true;
        mVar.d(app);
        AppData cpd = mVar.cpd();
        if (cpd.goods != null) {
            if (v.aa(cpd.goods.thread_pic_list) && (mo = AdvertAppInfo.a.mo(cpd.goods.lego_card)) != null && cpd.goods.thread_pic_list != null) {
                cpd.goods.thread_pic_list.addAll(mo);
            }
            this.hHE = mVar;
        }
    }

    public String bSF() {
        return this.hHW;
    }

    public CardHListViewData bSG() {
        return this.hHN;
    }

    public PostData bSH() {
        return this.hHL;
    }

    public PostData d(PostData postData) {
        this.hHL = postData;
        return postData;
    }

    public m bSI() {
        return this.hHJ;
    }

    public int bSJ() {
        return this.hHr;
    }

    public int getIsNewUrl() {
        return this.hHt;
    }

    public void setIsNewUrl(int i) {
        this.hHt = i;
    }

    public List<MuteUser> bSK() {
        return this.hHw;
    }

    public ArrayList<com.baidu.tieba.tbadkCore.data.m> bSL() {
        return this.hHD;
    }

    public com.baidu.tieba.tbadkCore.data.m bSM() {
        return this.hHE;
    }

    public void b(com.baidu.tieba.tbadkCore.data.m mVar) {
        this.hHE = mVar;
    }

    public void bSN() {
        if (this.hHE.cpd() != null) {
            this.hHE.cpd().legoCard = null;
        }
        this.hHE = null;
    }

    public a bSO() {
        return this.hHy;
    }

    public String bSP() {
        return this.hHK;
    }

    public void BK(String str) {
        this.hHK = str;
    }

    public f bSQ() {
        return this.hHM;
    }

    public int bSR() {
        return this.hHB;
    }

    public List<bc> bSS() {
        return this.hHI;
    }

    public long bST() {
        return this.hHO;
    }

    public j bSU() {
        return this.hHP;
    }

    public boolean bSV() {
        return (bSx() == null || !bSx().afr() || bSx().aeO() == null) ? false : true;
    }

    public AlaLiveInfoCoreData bSW() {
        return this.hHC;
    }
}

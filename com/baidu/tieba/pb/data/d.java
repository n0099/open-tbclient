package com.baidu.tieba.pb.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.TwzhiboAnti;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.data.an;
import com.baidu.tbadk.core.data.ao;
import com.baidu.tbadk.core.data.au;
import com.baidu.tbadk.core.data.ay;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.ad;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.tbadkCore.data.AppData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.usermute.MuteUser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.App;
import tbclient.PbPage.AppealInfo;
import tbclient.PbPage.DataRes;
import tbclient.Post;
import tbclient.SimpleForum;
import tbclient.SimpleUser;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes2.dex */
public class d {
    private a fsF;
    private List<bb> fsH;
    private int fsI;
    private AlaLiveInfoCoreData fsJ;
    private TwzhiboAnti fsM;
    public AppealInfo fsN;
    private List<ay> fsO;
    private List<ay> fsP;
    public String fsR;
    private PostData fsS;
    private f fsT;
    public CardHListViewData fsU;
    private long fsV;
    private j fsW;
    public String fsX;
    public int fsY;
    public int fsZ;
    private String fsy;
    private int fsz;
    private String fta;
    private String ftb;
    private PostData ftd;
    private boolean fsE = true;
    private ArrayList<com.baidu.tieba.tbadkCore.data.l> fsK = new ArrayList<>();
    private com.baidu.tieba.tbadkCore.data.l fsL = null;
    private ForumData fst = new ForumData();
    private ay fsu = new ay();
    private bb btJ = new bb();
    private ArrayList<PostData> fsv = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private al eHH = new al();
    private AntiData agm = new AntiData();
    private com.baidu.tbadk.data.f fsw = new com.baidu.tbadk.data.f();
    private int fsx = 0;
    private final UserData fsA = new UserData();
    private List<MuteUser> fsD = new ArrayList();
    private an fsB = new an();
    private ao fsG = new ao();
    private ad fsC = new ad();
    private l fsQ = new l();
    private List<au.a> ftc = new ArrayList();

    public boolean aZk() {
        return this.fsE;
    }

    public void jq(boolean z) {
        this.fsE = z;
    }

    public d() {
        this.fsz = 0;
        this.fsM = null;
        this.fsz = 0;
        this.fsM = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.fsv != null && this.fsv.size() > 0;
    }

    public String[] bX(Context context) {
        String str = null;
        String str2 = "";
        if (isValid()) {
            int size = this.fsv.size() > 30 ? 30 : this.fsv.size();
            if (aZn() == null || aZn().vk() == null || ap.isEmpty(aZn().vk().getUserId())) {
                return new String[]{null, ""};
            }
            String userId = aZn().vk().getUserId();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                PostData postData = (PostData) w.d(this.fsv, i);
                if (postData != null && postData.vk() != null && !ap.isEmpty(postData.vk().getUserId()) && ap.equals(userId, postData.vk().getUserId())) {
                    if (ap.isEmpty(str)) {
                        str = postData.bwm();
                    }
                    String bwk = ap.isEmpty(str2) ? postData.bwk() : str2;
                    if (!ap.isEmpty(str) && !ap.isEmpty(bwk)) {
                        str2 = bwk;
                        break;
                    }
                    str2 = bwk;
                }
                i++;
                str = str;
            }
            if (ap.isEmpty(str)) {
                str = "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            }
            PostData postData2 = this.fsv.get(0);
            if (this.btJ != null && this.btJ.vU() != null && this.btJ.vU().getGroup_id() != 0) {
                str2 = "[" + context.getString(d.j.photo_live_tips) + "] " + str2;
            }
            if (this.btJ != null && this.btJ.vW() && postData2 != null && postData2.NH() != null) {
                str = postData2.NH().getThumbUrl();
            }
        }
        return new String[]{str, str2};
    }

    public ForumData aZl() {
        return this.fst;
    }

    public ay aZm() {
        return this.fsu;
    }

    public String getForumId() {
        if (this.fst == null) {
            return "";
        }
        return this.fst.getId();
    }

    public bb aZn() {
        return this.btJ;
    }

    public List<bb> aZo() {
        return this.fsH;
    }

    public String getThreadId() {
        if (this.btJ == null) {
            return "";
        }
        return this.btJ.getId();
    }

    public ArrayList<PostData> aZp() {
        return this.fsv;
    }

    public al uw() {
        return this.eHH;
    }

    public ad aZq() {
        return this.fsC;
    }

    public ao aZr() {
        return this.fsG;
    }

    public void a(al alVar, int i) {
        this.eHH.bL(alVar.uq());
        this.eHH.bJ(alVar.tD());
        this.eHH.bI(alVar.un());
        this.eHH.bM(alVar.ur());
        this.eHH.bK(alVar.up());
        if (i == 0) {
            this.eHH = alVar;
        } else if (i == 1) {
            this.eHH.bN(alVar.us());
        } else if (i == 2) {
            this.eHH.bO(alVar.ut());
        }
    }

    public AntiData uh() {
        return this.agm;
    }

    public UserData getUserData() {
        return this.fsA;
    }

    public boolean rN() {
        return this.btJ.vt() != 0;
    }

    public void ad(boolean z) {
        if (this.btJ != null) {
            if (z) {
                this.btJ.bX(1);
            } else {
                this.btJ.bX(0);
            }
        }
    }

    public String rM() {
        if (this.btJ != null) {
            return this.btJ.vu();
        }
        return null;
    }

    public void qY(String str) {
        if (this.btJ != null) {
            this.btJ.dp(str);
        }
    }

    public String aZs() {
        return this.ftb;
    }

    public boolean aZt() {
        return (this.btJ == null || this.btJ.vw() == null || this.btJ.vw().size() <= 0 || this.btJ.vw().get(0) == null || !this.btJ.vw().get(0).tE()) ? false : true;
    }

    public PostData aZu() {
        return this.ftd;
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                com.baidu.tieba.recapp.d.a.bod().sS(dataRes.asp_shown_info);
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
                qj(dataRes.is_new_url.intValue());
                this.fst.parserProtobuf(dataRes.forum);
                this.fsu.parserProtobuf(dataRes.display_forum);
                this.btJ.setUserMap(this.userMap);
                this.btJ.a(dataRes.thread);
                this.btJ.ca(2);
                this.fsB.a(dataRes.news_info);
                switch (this.fsB.agG) {
                    case 1:
                        this.fsC.fCV = this.fsB;
                        break;
                    case 2:
                        this.fsC.fCW = this.fsB;
                        break;
                    case 3:
                        this.fsC.fCX = this.fsB;
                        break;
                    default:
                        this.fsC.fCW = this.fsB;
                        break;
                }
                this.fsG.a(dataRes.recommend_book);
                List<Post> list2 = dataRes.post_list;
                if (list2 != null && list2.size() > 0) {
                    for (Post post : dataRes.post_list) {
                        PostData postData = new PostData();
                        postData.setUserMap(this.userMap);
                        postData.js(this.fst.isBrandForum);
                        postData.a(post, context);
                        postData.a(aZn().uX());
                        if (postData.bwf() == 1 && this.btJ.vO()) {
                            if (aZt()) {
                                postData.setPostType(0);
                            } else {
                                postData.setPostType(this.btJ.vN());
                            }
                        } else if (postData.bwf() == 1 && this.btJ.wa()) {
                            postData.setPostType(41);
                        } else if (postData.bwf() == 1 && this.btJ != null && this.btJ.vW()) {
                            postData.setPostType(0);
                            postData.NH();
                            if (this.btJ.vi() == null || this.btJ.vi().size() == 0) {
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
                                postData.c(new TbRichText((Context) TbadkCoreApplication.getInst(), this.btJ.vi(), true));
                            }
                            this.fsS = postData;
                        }
                        if (postData.bwf() == 1 && this.btJ != null && this.btJ.isShareThread) {
                            postData.g(this.btJ.ajH);
                        }
                        this.fsv.add(postData);
                    }
                }
                if (dataRes.first_floor_post != null) {
                    this.ftd = new PostData();
                    this.ftd.setUserMap(this.userMap);
                    this.ftd.js(this.fst.isBrandForum);
                    this.ftd.a(dataRes.first_floor_post, context);
                    if (this.btJ != null && this.btJ.isShareThread) {
                        this.ftd.g(this.btJ.ajH);
                    }
                }
                this.eHH.a(dataRes.page);
                this.agm.parserProtobuf(dataRes.anti);
                this.fsw.a(dataRes.location);
                if (dataRes.user != null) {
                    this.fsx = dataRes.user.is_manager.intValue();
                }
                this.fsA.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.fsD.add(muteUser);
                        }
                    }
                }
                this.btJ.bT(this.btJ.vb() > 0 ? this.btJ.vb() - 1 : 0);
                List<AppData> bnl = r.bnn().bnl();
                if (bnl != null) {
                    bnl.clear();
                }
                this.fsL = null;
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        com.baidu.tieba.tbadkCore.data.l lVar = new com.baidu.tieba.tbadkCore.data.l();
                        lVar.d(app);
                        AppData bvT = lVar.bvT();
                        if (!this.fsK.contains(lVar) && bvT.goods != null && (!StringUtils.isNull(bvT.goods.user_name) || !StringUtils.isNull(bvT.goods.lego_card))) {
                            this.fsK.add(lVar);
                            if (bnl != null) {
                                bnl.add(lVar.bvT());
                            }
                        }
                    }
                    a(dataRes);
                }
                r.bnn().bnm();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.fsA.getIsSelectTail());
                }
                this.fsM.parserProtobuf(dataRes.twzhibo_anti);
                this.fsN = dataRes.appeal_info;
                if (dataRes.god_card != null) {
                    this.fsF = new a();
                    this.fsF.a(dataRes.god_card);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.fsT = new f();
                    this.fsT.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.guess_like != null) {
                    this.fsU = new CardHListViewData();
                    this.fsU.parseProtobuf(dataRes.guess_like);
                }
                if (dataRes.feed_thread_list != null && dataRes.feed_thread_list.size() > 0) {
                    List<ThreadInfo> list3 = dataRes.feed_thread_list;
                    if (this.fsH == null) {
                        this.fsH = new ArrayList();
                    }
                    this.fsH.clear();
                    for (ThreadInfo threadInfo : list3) {
                        if (threadInfo != null) {
                            bb bbVar = new bb();
                            bbVar.a(threadInfo);
                            this.fsH.add(bbVar);
                        }
                    }
                    if (this.fsH != null && this.fsH.size() > 15) {
                        this.fsH = w.a(this.fsH, 0, 15);
                    }
                }
                this.fsI = dataRes.is_follow_current_channel.intValue();
                if (w.y(dataRes.repost_recommend_forum_list) > 0) {
                    if (this.fsO == null) {
                        this.fsO = new ArrayList();
                    }
                    for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                        ay ayVar = new ay();
                        ayVar.parserProtobuf(simpleForum);
                        this.fsO.add(ayVar);
                    }
                }
                if (w.y(dataRes.from_forum_list) > 0) {
                    if (this.fsP == null) {
                        this.fsP = new ArrayList();
                    }
                    for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                        if (simpleForum2 != null) {
                            ay ayVar2 = new ay();
                            ayVar2.parserProtobuf(simpleForum2);
                            this.fsP.add(ayVar2);
                        }
                    }
                }
                this.ftb = dataRes.multi_forum_text;
                if (dataRes.top_agree_post_list != null && this.fsQ != null) {
                    this.fsQ.js(this.fst.isBrandForum);
                    this.fsQ.a(context, dataRes.top_agree_post_list);
                }
                if (this.fsV >= 0) {
                    this.fsV = dataRes.thread_freq_num.longValue();
                }
                this.fsW = new j();
                this.fsW.b(dataRes);
                this.fsX = dataRes.partial_visible_toast;
                if (dataRes.follow_tip != null && dataRes.follow_tip.is_toast_tip.intValue() == 1) {
                    this.fsy = dataRes.follow_tip.tip_text;
                }
                this.fsJ = new AlaLiveInfoCoreData();
                if (dataRes.ala_info != null) {
                    this.fsJ.parserProtoBuf(dataRes.ala_info);
                }
                this.fta = dataRes.fold_tip;
                this.fsY = dataRes.exp_news_today.intValue();
                this.fsZ = dataRes.exp_guide_today.intValue();
                if (!w.z(dataRes.thread_topic)) {
                    for (int i2 = 0; i2 < dataRes.thread_topic.size(); i2++) {
                        au.a aVar = new au.a();
                        aVar.a(dataRes.thread_topic.get(i2));
                        this.ftc.add(aVar);
                    }
                }
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }

    private void a(DataRes dataRes) {
        App app = dataRes.banner_list.pb_banner_ad;
        com.baidu.tieba.tbadkCore.data.l lVar = new com.baidu.tieba.tbadkCore.data.l();
        lVar.gNR = true;
        lVar.d(app);
        if (lVar.bvT().goods != null) {
            this.fsL = lVar;
        }
    }

    public String aZv() {
        return this.fta;
    }

    public CardHListViewData aZw() {
        return this.fsU;
    }

    public PostData aZx() {
        return this.fsS;
    }

    public PostData c(PostData postData) {
        this.fsS = postData;
        return postData;
    }

    public l aZy() {
        return this.fsQ;
    }

    public int aZz() {
        return this.fsx;
    }

    public int aZA() {
        return this.fsz;
    }

    public void qj(int i) {
        this.fsz = i;
    }

    public List<MuteUser> aZB() {
        return this.fsD;
    }

    public ArrayList<com.baidu.tieba.tbadkCore.data.l> aZC() {
        return this.fsK;
    }

    public com.baidu.tieba.tbadkCore.data.l aZD() {
        return this.fsL;
    }

    public void aZE() {
        if (this.fsL.bvT() != null) {
            this.fsL.bvT().legoCard = null;
        }
        this.fsL = null;
    }

    public a aZF() {
        return this.fsF;
    }

    public String aZG() {
        return this.fsR;
    }

    public void qZ(String str) {
        this.fsR = str;
    }

    public f aZH() {
        return this.fsT;
    }

    public int aZI() {
        return this.fsI;
    }

    public List<ay> aZJ() {
        return this.fsP;
    }

    public long aZK() {
        return this.fsV;
    }

    public j aZL() {
        return this.fsW;
    }

    public void a(j jVar) {
        this.fsW = jVar;
    }

    public boolean aZM() {
        return (aZn() == null || !aZn().vW() || aZn().vC() == null) ? false : true;
    }

    public String aZN() {
        return this.fsy;
    }

    public AlaLiveInfoCoreData aZO() {
        return this.fsJ;
    }

    public List<au.a> aZP() {
        return this.ftc;
    }
}

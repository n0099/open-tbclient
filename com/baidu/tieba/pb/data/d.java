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
import com.baidu.tieba.f;
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
    private List<bb> fsA;
    private int fsB;
    private AlaLiveInfoCoreData fsC;
    private TwzhiboAnti fsF;
    public AppealInfo fsG;
    private List<ay> fsH;
    private List<ay> fsI;
    public String fsK;
    private PostData fsL;
    private f fsM;
    public CardHListViewData fsN;
    private long fsO;
    private j fsP;
    public String fsQ;
    public int fsR;
    public int fsS;
    private String fsT;
    private String fsU;
    private PostData fsW;
    private String fsr;
    private int fss;
    private a fsy;
    private boolean fsx = true;
    private ArrayList<com.baidu.tieba.tbadkCore.data.l> fsD = new ArrayList<>();
    private com.baidu.tieba.tbadkCore.data.l fsE = null;
    private ForumData fsm = new ForumData();
    private ay fsn = new ay();
    private bb btL = new bb();
    private ArrayList<PostData> fso = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private al eHC = new al();
    private AntiData agm = new AntiData();
    private com.baidu.tbadk.data.f fsp = new com.baidu.tbadk.data.f();
    private int fsq = 0;
    private final UserData fst = new UserData();
    private List<MuteUser> fsw = new ArrayList();
    private an fsu = new an();
    private ao fsz = new ao();
    private ad fsv = new ad();
    private l fsJ = new l();
    private List<au.a> fsV = new ArrayList();

    public boolean aZf() {
        return this.fsx;
    }

    public void jq(boolean z) {
        this.fsx = z;
    }

    public d() {
        this.fss = 0;
        this.fsF = null;
        this.fss = 0;
        this.fsF = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.fso != null && this.fso.size() > 0;
    }

    public String[] bW(Context context) {
        String str = null;
        String str2 = "";
        if (isValid()) {
            int size = this.fso.size() > 30 ? 30 : this.fso.size();
            if (aZi() == null || aZi().vj() == null || ap.isEmpty(aZi().vj().getUserId())) {
                return new String[]{null, ""};
            }
            String userId = aZi().vj().getUserId();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                PostData postData = (PostData) w.d(this.fso, i);
                if (postData != null && postData.vj() != null && !ap.isEmpty(postData.vj().getUserId()) && ap.equals(userId, postData.vj().getUserId())) {
                    if (ap.isEmpty(str)) {
                        str = postData.bwn();
                    }
                    String bwl = ap.isEmpty(str2) ? postData.bwl() : str2;
                    if (!ap.isEmpty(str) && !ap.isEmpty(bwl)) {
                        str2 = bwl;
                        break;
                    }
                    str2 = bwl;
                }
                i++;
                str = str;
            }
            if (ap.isEmpty(str)) {
                str = "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            }
            PostData postData2 = this.fso.get(0);
            if (this.btL != null && this.btL.vT() != null && this.btL.vT().getGroup_id() != 0) {
                str2 = "[" + context.getString(f.j.photo_live_tips) + "] " + str2;
            }
            if (this.btL != null && this.btL.vV() && postData2 != null && postData2.NG() != null) {
                str = postData2.NG().getThumbUrl();
            }
        }
        return new String[]{str, str2};
    }

    public ForumData aZg() {
        return this.fsm;
    }

    public ay aZh() {
        return this.fsn;
    }

    public String getForumId() {
        if (this.fsm == null) {
            return "";
        }
        return this.fsm.getId();
    }

    public bb aZi() {
        return this.btL;
    }

    public List<bb> aZj() {
        return this.fsA;
    }

    public String getThreadId() {
        if (this.btL == null) {
            return "";
        }
        return this.btL.getId();
    }

    public ArrayList<PostData> aZk() {
        return this.fso;
    }

    public al uv() {
        return this.eHC;
    }

    public ad aZl() {
        return this.fsv;
    }

    public ao aZm() {
        return this.fsz;
    }

    public void a(al alVar, int i) {
        this.eHC.bL(alVar.up());
        this.eHC.bJ(alVar.tC());
        this.eHC.bI(alVar.um());
        this.eHC.bM(alVar.uq());
        this.eHC.bK(alVar.uo());
        if (i == 0) {
            this.eHC = alVar;
        } else if (i == 1) {
            this.eHC.bN(alVar.ur());
        } else if (i == 2) {
            this.eHC.bO(alVar.us());
        }
    }

    public AntiData ug() {
        return this.agm;
    }

    public UserData getUserData() {
        return this.fst;
    }

    public boolean rL() {
        return this.btL.vs() != 0;
    }

    public void ae(boolean z) {
        if (this.btL != null) {
            if (z) {
                this.btL.bX(1);
            } else {
                this.btL.bX(0);
            }
        }
    }

    public String rK() {
        if (this.btL != null) {
            return this.btL.vt();
        }
        return null;
    }

    public void rb(String str) {
        if (this.btL != null) {
            this.btL.dp(str);
        }
    }

    public String aZn() {
        return this.fsU;
    }

    public boolean aZo() {
        return (this.btL == null || this.btL.vv() == null || this.btL.vv().size() <= 0 || this.btL.vv().get(0) == null || !this.btL.vv().get(0).tD()) ? false : true;
    }

    public PostData aZp() {
        return this.fsW;
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                com.baidu.tieba.recapp.d.a.boe().sW(dataRes.asp_shown_info);
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
                this.fsm.parserProtobuf(dataRes.forum);
                this.fsn.parserProtobuf(dataRes.display_forum);
                this.btL.setUserMap(this.userMap);
                this.btL.a(dataRes.thread);
                this.btL.ca(2);
                this.fsu.a(dataRes.news_info);
                switch (this.fsu.agG) {
                    case 1:
                        this.fsv.fCO = this.fsu;
                        break;
                    case 2:
                        this.fsv.fCP = this.fsu;
                        break;
                    case 3:
                        this.fsv.fCQ = this.fsu;
                        break;
                    default:
                        this.fsv.fCP = this.fsu;
                        break;
                }
                this.fsz.a(dataRes.recommend_book);
                List<Post> list2 = dataRes.post_list;
                if (list2 != null && list2.size() > 0) {
                    for (Post post : dataRes.post_list) {
                        PostData postData = new PostData();
                        postData.setUserMap(this.userMap);
                        postData.js(this.fsm.isBrandForum);
                        postData.a(post, context);
                        postData.a(aZi().uW());
                        if (postData.bwg() == 1 && this.btL.vN()) {
                            if (aZo()) {
                                postData.setPostType(0);
                            } else {
                                postData.setPostType(this.btL.vM());
                            }
                        } else if (postData.bwg() == 1 && this.btL.vZ()) {
                            postData.setPostType(41);
                        } else if (postData.bwg() == 1 && this.btL != null && this.btL.vV()) {
                            postData.setPostType(0);
                            postData.NG();
                            if (this.btL.vh() == null || this.btL.vh().size() == 0) {
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
                                postData.c(new TbRichText((Context) TbadkCoreApplication.getInst(), this.btL.vh(), true));
                            }
                            this.fsL = postData;
                        }
                        if (postData.bwg() == 1 && this.btL != null && this.btL.isShareThread) {
                            postData.g(this.btL.ajH);
                        }
                        this.fso.add(postData);
                    }
                }
                if (dataRes.first_floor_post != null) {
                    this.fsW = new PostData();
                    this.fsW.setUserMap(this.userMap);
                    this.fsW.js(this.fsm.isBrandForum);
                    this.fsW.a(dataRes.first_floor_post, context);
                    if (this.btL != null && this.btL.isShareThread) {
                        this.fsW.g(this.btL.ajH);
                    }
                }
                this.eHC.a(dataRes.page);
                this.agm.parserProtobuf(dataRes.anti);
                this.fsp.a(dataRes.location);
                if (dataRes.user != null) {
                    this.fsq = dataRes.user.is_manager.intValue();
                }
                this.fst.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.fsw.add(muteUser);
                        }
                    }
                }
                this.btL.bT(this.btL.va() > 0 ? this.btL.va() - 1 : 0);
                List<AppData> bnm = r.bno().bnm();
                if (bnm != null) {
                    bnm.clear();
                }
                this.fsE = null;
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        com.baidu.tieba.tbadkCore.data.l lVar = new com.baidu.tieba.tbadkCore.data.l();
                        lVar.d(app);
                        AppData bvU = lVar.bvU();
                        if (!this.fsD.contains(lVar) && bvU.goods != null && (!StringUtils.isNull(bvU.goods.user_name) || !StringUtils.isNull(bvU.goods.lego_card))) {
                            this.fsD.add(lVar);
                            if (bnm != null) {
                                bnm.add(lVar.bvU());
                            }
                        }
                    }
                    a(dataRes);
                }
                r.bno().bnn();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.fst.getIsSelectTail());
                }
                this.fsF.parserProtobuf(dataRes.twzhibo_anti);
                this.fsG = dataRes.appeal_info;
                if (dataRes.god_card != null) {
                    this.fsy = new a();
                    this.fsy.a(dataRes.god_card);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.fsM = new f();
                    this.fsM.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.guess_like != null) {
                    this.fsN = new CardHListViewData();
                    this.fsN.parseProtobuf(dataRes.guess_like);
                }
                if (dataRes.feed_thread_list != null && dataRes.feed_thread_list.size() > 0) {
                    List<ThreadInfo> list3 = dataRes.feed_thread_list;
                    if (this.fsA == null) {
                        this.fsA = new ArrayList();
                    }
                    this.fsA.clear();
                    for (ThreadInfo threadInfo : list3) {
                        if (threadInfo != null) {
                            bb bbVar = new bb();
                            bbVar.a(threadInfo);
                            this.fsA.add(bbVar);
                        }
                    }
                    if (this.fsA != null && this.fsA.size() > 15) {
                        this.fsA = w.a(this.fsA, 0, 15);
                    }
                }
                this.fsB = dataRes.is_follow_current_channel.intValue();
                if (w.y(dataRes.repost_recommend_forum_list) > 0) {
                    if (this.fsH == null) {
                        this.fsH = new ArrayList();
                    }
                    for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                        ay ayVar = new ay();
                        ayVar.parserProtobuf(simpleForum);
                        this.fsH.add(ayVar);
                    }
                }
                if (w.y(dataRes.from_forum_list) > 0) {
                    if (this.fsI == null) {
                        this.fsI = new ArrayList();
                    }
                    for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                        if (simpleForum2 != null) {
                            ay ayVar2 = new ay();
                            ayVar2.parserProtobuf(simpleForum2);
                            this.fsI.add(ayVar2);
                        }
                    }
                }
                this.fsU = dataRes.multi_forum_text;
                if (dataRes.top_agree_post_list != null && this.fsJ != null) {
                    this.fsJ.js(this.fsm.isBrandForum);
                    this.fsJ.a(context, dataRes.top_agree_post_list);
                }
                if (this.fsO >= 0) {
                    this.fsO = dataRes.thread_freq_num.longValue();
                }
                this.fsP = new j();
                this.fsP.b(dataRes);
                this.fsQ = dataRes.partial_visible_toast;
                if (dataRes.follow_tip != null && dataRes.follow_tip.is_toast_tip.intValue() == 1) {
                    this.fsr = dataRes.follow_tip.tip_text;
                }
                this.fsC = new AlaLiveInfoCoreData();
                if (dataRes.ala_info != null) {
                    this.fsC.parserProtoBuf(dataRes.ala_info);
                }
                this.fsT = dataRes.fold_tip;
                this.fsR = dataRes.exp_news_today.intValue();
                this.fsS = dataRes.exp_guide_today.intValue();
                if (!w.z(dataRes.thread_topic)) {
                    for (int i2 = 0; i2 < dataRes.thread_topic.size(); i2++) {
                        au.a aVar = new au.a();
                        aVar.a(dataRes.thread_topic.get(i2));
                        this.fsV.add(aVar);
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
        lVar.gNT = true;
        lVar.d(app);
        if (lVar.bvU().goods != null) {
            this.fsE = lVar;
        }
    }

    public String aZq() {
        return this.fsT;
    }

    public CardHListViewData aZr() {
        return this.fsN;
    }

    public PostData aZs() {
        return this.fsL;
    }

    public PostData c(PostData postData) {
        this.fsL = postData;
        return postData;
    }

    public l aZt() {
        return this.fsJ;
    }

    public int aZu() {
        return this.fsq;
    }

    public int aZv() {
        return this.fss;
    }

    public void qj(int i) {
        this.fss = i;
    }

    public List<MuteUser> aZw() {
        return this.fsw;
    }

    public ArrayList<com.baidu.tieba.tbadkCore.data.l> aZx() {
        return this.fsD;
    }

    public com.baidu.tieba.tbadkCore.data.l aZy() {
        return this.fsE;
    }

    public void aZz() {
        if (this.fsE.bvU() != null) {
            this.fsE.bvU().legoCard = null;
        }
        this.fsE = null;
    }

    public a aZA() {
        return this.fsy;
    }

    public String aZB() {
        return this.fsK;
    }

    public void rc(String str) {
        this.fsK = str;
    }

    public f aZC() {
        return this.fsM;
    }

    public int aZD() {
        return this.fsB;
    }

    public List<ay> aZE() {
        return this.fsI;
    }

    public long aZF() {
        return this.fsO;
    }

    public j aZG() {
        return this.fsP;
    }

    public void a(j jVar) {
        this.fsP = jVar;
    }

    public boolean aZH() {
        return (aZi() == null || !aZi().vV() || aZi().vB() == null) ? false : true;
    }

    public String aZI() {
        return this.fsr;
    }

    public AlaLiveInfoCoreData aZJ() {
        return this.fsC;
    }

    public List<au.a> aZK() {
        return this.fsV;
    }
}

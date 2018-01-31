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
import com.baidu.tbadk.core.data.ay;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.ad;
import com.baidu.tieba.recapp.q;
import com.baidu.tieba.tbadkCore.data.AppData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.usermute.MuteUser;
import com.baidu.tieba.vote.VoteDataInfo;
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
public class f {
    private String fDM;
    private int fDN;
    private a fDT;
    private List<bd> fDV;
    private int fDW;
    private AlaLiveInfoCoreData fDX;
    private TwzhiboAnti fDZ;
    private VoteDataInfo fEa;
    public AppealInfo fEb;
    private List<ay> fEc;
    private List<ay> fEd;
    public String fEf;
    private PostData fEg;
    private h fEh;
    public CardHListViewData fEi;
    private long fEj;
    private l fEk;
    public String fEl;
    public int fEm;
    public int fEn;
    private String fEo;
    private String fEp;
    private PostData fEq;
    private boolean fDS = true;
    private ArrayList<com.baidu.tieba.tbadkCore.data.l> fDY = new ArrayList<>();
    private ForumData fDH = new ForumData();
    private ay fDI = new ay();
    private bd bXi = new bd();
    private ArrayList<PostData> fDJ = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private al eOI = new al();
    private AntiData aLR = new AntiData();
    private com.baidu.tbadk.data.f fDK = new com.baidu.tbadk.data.f();
    private int fDL = 0;
    private final UserData fDO = new UserData();
    private List<MuteUser> fDR = new ArrayList();
    private an fDP = new an();
    private ao fDU = new ao();
    private ad fDQ = new ad();
    private n fEe = new n();

    public boolean aYH() {
        return this.fDS;
    }

    public void jD(boolean z) {
        this.fDS = z;
    }

    public VoteDataInfo aYI() {
        return this.fEa;
    }

    public f() {
        this.fDN = 0;
        this.fDZ = null;
        this.fDN = 0;
        this.fDZ = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.fDJ != null && this.fDJ.size() > 0;
    }

    public String[] bU(Context context) {
        String str = null;
        String str2 = "";
        if (isValid()) {
            int size = this.fDJ.size() > 30 ? 30 : this.fDJ.size();
            if (aYL() == null || aYL().yT() == null || am.isEmpty(aYL().yT().getUserId())) {
                return new String[]{null, ""};
            }
            String userId = aYL().yT().getUserId();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                PostData postData = (PostData) v.f(this.fDJ, i);
                if (postData != null && postData.yT() != null && !am.isEmpty(postData.yT().getUserId()) && am.equals(userId, postData.yT().getUserId())) {
                    if (am.isEmpty(str)) {
                        str = postData.bvR();
                    }
                    String bvP = am.isEmpty(str2) ? postData.bvP() : str2;
                    if (!am.isEmpty(str) && !am.isEmpty(bvP)) {
                        str2 = bvP;
                        break;
                    }
                    str2 = bvP;
                }
                i++;
                str = str;
            }
            if (am.isEmpty(str)) {
                str = "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            }
            PostData postData2 = this.fDJ.get(0);
            if (this.bXi != null && this.bXi.zE() != null && this.bXi.zE().getGroup_id() != 0) {
                str2 = "[" + context.getString(d.j.photo_live_tips) + "] " + str2;
            }
            if (this.bXi != null && this.bXi.zG() && postData2 != null && postData2.QN() != null) {
                str = postData2.QN().getThumbUrl();
            }
        }
        return new String[]{str, str2};
    }

    public ForumData aYJ() {
        return this.fDH;
    }

    public ay aYK() {
        return this.fDI;
    }

    public String getForumId() {
        if (this.fDH == null) {
            return "";
        }
        return this.fDH.getId();
    }

    public bd aYL() {
        return this.bXi;
    }

    public List<bd> aYM() {
        return this.fDV;
    }

    public String getThreadId() {
        if (this.bXi == null) {
            return "";
        }
        return this.bXi.getId();
    }

    public ArrayList<PostData> aYN() {
        return this.fDJ;
    }

    public al xZ() {
        return this.eOI;
    }

    public ad aYO() {
        return this.fDQ;
    }

    public ao aYP() {
        return this.fDU;
    }

    public void a(al alVar, int i) {
        this.eOI.eH(alVar.xT());
        this.eOI.eF(alVar.wU());
        this.eOI.eE(alVar.xQ());
        this.eOI.eI(alVar.xU());
        this.eOI.eG(alVar.xS());
        if (i == 0) {
            this.eOI = alVar;
        } else if (i == 1) {
            this.eOI.eJ(alVar.xV());
        } else if (i == 2) {
            this.eOI.eK(alVar.xW());
        }
    }

    public AntiData xH() {
        return this.aLR;
    }

    public UserData getUserData() {
        return this.fDO;
    }

    public boolean vl() {
        return this.bXi.zc() != 0;
    }

    public void aI(boolean z) {
        if (this.bXi != null) {
            if (z) {
                this.bXi.eT(1);
            } else {
                this.bXi.eT(0);
            }
        }
    }

    public String vk() {
        if (this.bXi != null) {
            return this.bXi.zd();
        }
        return null;
    }

    public void qa(String str) {
        if (this.bXi != null) {
            this.bXi.cR(str);
        }
    }

    public String aYQ() {
        return this.fEp;
    }

    public boolean aYR() {
        return (this.bXi == null || this.bXi.zf() == null || this.bXi.zf().size() <= 0 || this.bXi.zf().get(0) == null || !this.bXi.zf().get(0).getIsSenior()) ? false : true;
    }

    public PostData aYS() {
        return this.fEq;
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                com.baidu.tieba.recapp.e.a.bnx().rN(dataRes.asp_shown_info);
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
                sw(dataRes.is_new_url.intValue());
                this.fDH.parserProtobuf(dataRes.forum);
                this.fDI.parserProtobuf(dataRes.display_forum);
                this.bXi.setUserMap(this.userMap);
                this.bXi.a(dataRes.thread);
                this.bXi.eW(2);
                this.fDP.a(dataRes.news_info);
                switch (this.fDP.aMi) {
                    case 1:
                        this.fDQ.fOX = this.fDP;
                        break;
                    case 2:
                        this.fDQ.fOY = this.fDP;
                        break;
                    case 3:
                        this.fDQ.fOZ = this.fDP;
                        break;
                    default:
                        this.fDQ.fOY = this.fDP;
                        break;
                }
                this.fDU.a(dataRes.recommend_book);
                if (this.bXi != null && this.bXi.yF() != null) {
                    this.fEa = new VoteDataInfo();
                    this.fEa.parserProtobuf(aYL().yF());
                }
                List<Post> list2 = dataRes.post_list;
                if (list2 != null && list2.size() > 0) {
                    for (Post post : dataRes.post_list) {
                        PostData postData = new PostData();
                        postData.setUserMap(this.userMap);
                        postData.a(post, context);
                        postData.a(aYL().yI());
                        if (postData.bvJ() == 1 && this.bXi.zy()) {
                            if (aYR()) {
                                postData.setPostType(0);
                            } else {
                                postData.setPostType(this.bXi.zx());
                            }
                        } else if (postData.bvJ() == 1 && this.bXi != null && this.bXi.zF()) {
                            postData.setPostType(36);
                        } else if (postData.bvJ() == 1 && this.bXi.zJ()) {
                            postData.setPostType(41);
                        } else if (postData.bvJ() == 1 && this.bXi != null && this.bXi.zG()) {
                            postData.setPostType(0);
                            postData.QN();
                            if (this.bXi.yR() == null || this.bXi.yR().size() == 0) {
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
                                postData.c(new TbRichText((Context) TbadkCoreApplication.getInst(), this.bXi.yR(), true));
                            }
                            this.fEg = postData;
                        } else if (postData.bvJ() == 1 && this.bXi.zK()) {
                            postData.setPostType(48);
                        }
                        if (postData.bvJ() == 1 && this.bXi != null && this.bXi.isShareThread) {
                            postData.f(this.bXi.aPc);
                        }
                        this.fDJ.add(postData);
                    }
                }
                if (dataRes.first_floor_post != null) {
                    this.fEq = new PostData();
                    this.fEq.setUserMap(this.userMap);
                    this.fEq.a(dataRes.first_floor_post, context);
                    if (this.bXi != null && this.bXi.isShareThread) {
                        this.fEq.f(this.bXi.aPc);
                    }
                }
                this.eOI.a(dataRes.page);
                this.aLR.parserProtobuf(dataRes.anti);
                this.fDK.a(dataRes.location);
                if (dataRes.user != null) {
                    this.fDL = dataRes.user.is_manager.intValue();
                }
                this.fDO.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.fDR.add(muteUser);
                        }
                    }
                }
                this.bXi.eP(this.bXi.yL() > 0 ? this.bXi.yL() - 1 : 0);
                List<AppData> bmQ = q.bmS().bmQ();
                if (bmQ != null) {
                    bmQ.clear();
                }
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        com.baidu.tieba.tbadkCore.data.l lVar = new com.baidu.tieba.tbadkCore.data.l();
                        lVar.d(app);
                        AppData bvx = lVar.bvx();
                        if (!this.fDY.contains(lVar) && bvx.goods != null && (!StringUtils.isNull(bvx.goods.user_name) || !StringUtils.isNull(bvx.goods.lego_card))) {
                            this.fDY.add(lVar);
                            if (bmQ != null) {
                                bmQ.add(lVar.bvx());
                            }
                        }
                    }
                }
                q.bmS().bmR();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.fDO.getIsSelectTail());
                }
                this.fDZ.parserProtobuf(dataRes.twzhibo_anti);
                this.fEb = dataRes.appeal_info;
                if (dataRes.god_card != null) {
                    this.fDT = new a();
                    this.fDT.a(dataRes.god_card);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.fEh = new h();
                    this.fEh.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.guess_like != null) {
                    this.fEi = new CardHListViewData();
                    this.fEi.parseProtobuf(dataRes.guess_like);
                }
                if (dataRes.feed_thread_list != null && dataRes.feed_thread_list.size() > 0) {
                    List<ThreadInfo> list3 = dataRes.feed_thread_list;
                    if (this.fDV == null) {
                        this.fDV = new ArrayList();
                    }
                    this.fDV.clear();
                    for (ThreadInfo threadInfo : list3) {
                        if (threadInfo != null) {
                            bd bdVar = new bd();
                            bdVar.a(threadInfo);
                            this.fDV.add(bdVar);
                        }
                    }
                    if (this.fDV != null && this.fDV.size() > 15) {
                        this.fDV = v.b(this.fDV, 0, 15);
                    }
                }
                this.fDW = dataRes.is_follow_current_channel.intValue();
                if (v.D(dataRes.repost_recommend_forum_list) > 0) {
                    if (this.fEc == null) {
                        this.fEc = new ArrayList();
                    }
                    for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                        ay ayVar = new ay();
                        ayVar.parserProtobuf(simpleForum);
                        this.fEc.add(ayVar);
                    }
                }
                if (v.D(dataRes.from_forum_list) > 0) {
                    if (this.fEd == null) {
                        this.fEd = new ArrayList();
                    }
                    for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                        if (simpleForum2 != null) {
                            ay ayVar2 = new ay();
                            ayVar2.parserProtobuf(simpleForum2);
                            this.fEd.add(ayVar2);
                        }
                    }
                }
                this.fEp = dataRes.multi_forum_text;
                if (dataRes.top_agree_post_list != null && this.fEe != null) {
                    this.fEe.a(context, dataRes.top_agree_post_list);
                }
                if (this.fEj >= 0) {
                    this.fEj = dataRes.thread_freq_num.longValue();
                }
                this.fEk = new l();
                this.fEk.a(dataRes);
                this.fEl = dataRes.partial_visible_toast;
                if (dataRes.follow_tip != null && dataRes.follow_tip.is_toast_tip.intValue() == 1) {
                    this.fDM = dataRes.follow_tip.tip_text;
                }
                this.fDX = new AlaLiveInfoCoreData();
                if (dataRes.ala_info != null) {
                    this.fDX.parserProtoBuf(dataRes.ala_info);
                }
                this.fEo = dataRes.fold_tip;
                this.fEm = dataRes.exp_news_today.intValue();
                this.fEn = dataRes.exp_guide_today.intValue();
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }

    public String aYT() {
        return this.fEo;
    }

    public CardHListViewData aYU() {
        return this.fEi;
    }

    public PostData aYV() {
        return this.fEg;
    }

    public PostData c(PostData postData) {
        this.fEg = postData;
        return postData;
    }

    public n aYW() {
        return this.fEe;
    }

    public int aYX() {
        return this.fDL;
    }

    public int aYY() {
        return this.fDN;
    }

    public void sw(int i) {
        this.fDN = i;
    }

    public List<MuteUser> aYZ() {
        return this.fDR;
    }

    public ArrayList<com.baidu.tieba.tbadkCore.data.l> aZa() {
        return this.fDY;
    }

    public a aZb() {
        return this.fDT;
    }

    public String aZc() {
        return this.fEf;
    }

    public void qb(String str) {
        this.fEf = str;
    }

    public h aZd() {
        return this.fEh;
    }

    public int aZe() {
        return this.fDW;
    }

    public List<ay> aZf() {
        return this.fEd;
    }

    public long aZg() {
        return this.fEj;
    }

    public l aZh() {
        return this.fEk;
    }

    public void a(l lVar) {
        this.fEk = lVar;
    }

    public boolean aZi() {
        return (aYL() == null || !aYL().zG() || aYL().zl() == null) ? false : true;
    }

    public String aZj() {
        return this.fDM;
    }

    public AlaLiveInfoCoreData aZk() {
        return this.fDX;
    }
}

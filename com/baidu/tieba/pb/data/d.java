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
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.e;
import com.baidu.tieba.pb.pb.main.ad;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.tbadkCore.data.AppData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.data.l;
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
/* loaded from: classes2.dex */
public class d {
    public String fAA;
    public int fAB;
    public int fAC;
    public List<PbSortType> fAD;
    public int fAE;
    private String fAF;
    private String fAG;
    private PostData fAJ;
    private String fAb;
    private int fAc;
    private a fAi;
    private List<bb> fAk;
    private int fAl;
    private AlaLiveInfoCoreData fAm;
    private TwzhiboAnti fAp;
    public AppealInfo fAq;
    private List<ay> fAr;
    private List<ay> fAs;
    public String fAu;
    private PostData fAv;
    private f fAw;
    public CardHListViewData fAx;
    private long fAy;
    private i fAz;
    private boolean fAh = true;
    private ArrayList<l> fAn = new ArrayList<>();
    private l fAo = null;
    private ForumData fzW = new ForumData();
    private ay fzX = new ay();
    private bb bzB = new bb();
    private ArrayList<PostData> fzY = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private al eOS = new al();
    private AntiData aiM = new AntiData();
    private com.baidu.tbadk.data.f fzZ = new com.baidu.tbadk.data.f();
    private int fAa = 0;
    private final UserData fAd = new UserData();
    private List<MuteUser> fAg = new ArrayList();
    private an fAe = new an();
    private ao fAj = new ao();
    private ad fAf = new ad();
    private k fAt = new k();
    private List<au.a> fAH = new ArrayList();
    private HashSet<String> fAI = new HashSet<>();

    public boolean bbG() {
        return this.fAh;
    }

    public void jR(boolean z) {
        this.fAh = z;
    }

    public d() {
        this.fAc = 0;
        this.fAp = null;
        this.fAc = 0;
        this.fAp = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.fzY != null && this.fzY.size() > 0;
    }

    public String[] cD(Context context) {
        String str = null;
        String str2 = "";
        if (isValid()) {
            int size = this.fzY.size() > 30 ? 30 : this.fzY.size();
            if (bbJ() == null || bbJ().wm() == null || com.baidu.tbadk.core.util.ao.isEmpty(bbJ().wm().getUserId())) {
                return new String[]{null, ""};
            }
            String userId = bbJ().wm().getUserId();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                PostData postData = (PostData) v.d(this.fzY, i);
                if (postData != null && postData.wm() != null && !com.baidu.tbadk.core.util.ao.isEmpty(postData.wm().getUserId()) && com.baidu.tbadk.core.util.ao.equals(userId, postData.wm().getUserId())) {
                    if (com.baidu.tbadk.core.util.ao.isEmpty(str)) {
                        str = postData.byT();
                    }
                    String byR = com.baidu.tbadk.core.util.ao.isEmpty(str2) ? postData.byR() : str2;
                    if (!com.baidu.tbadk.core.util.ao.isEmpty(str) && !com.baidu.tbadk.core.util.ao.isEmpty(byR)) {
                        str2 = byR;
                        break;
                    }
                    str2 = byR;
                }
                i++;
                str = str;
            }
            if (com.baidu.tbadk.core.util.ao.isEmpty(str)) {
                str = "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            }
            PostData postData2 = this.fzY.get(0);
            if (this.bzB != null && this.bzB.wY() != null && this.bzB.wY().getGroup_id() != 0) {
                str2 = "[" + context.getString(e.j.photo_live_tips) + "] " + str2;
            }
            if (this.bzB != null && this.bzB.xa() && postData2 != null && postData2.OZ() != null) {
                str = postData2.OZ().getThumbUrl();
            }
        }
        return new String[]{str, str2};
    }

    public ForumData bbH() {
        return this.fzW;
    }

    public ay bbI() {
        return this.fzX;
    }

    public String getForumId() {
        if (this.fzW == null) {
            return "";
        }
        return this.fzW.getId();
    }

    public bb bbJ() {
        return this.bzB;
    }

    public List<bb> bbK() {
        return this.fAk;
    }

    public String getThreadId() {
        if (this.bzB == null) {
            return "";
        }
        return this.bzB.getId();
    }

    public ArrayList<PostData> bbL() {
        return this.fzY;
    }

    public al vy() {
        return this.eOS;
    }

    public ad bbM() {
        return this.fAf;
    }

    public ao bbN() {
        return this.fAj;
    }

    public void a(al alVar, int i) {
        this.eOS.bU(alVar.vs());
        this.eOS.bS(alVar.uF());
        this.eOS.bR(alVar.vp());
        this.eOS.bV(alVar.vt());
        this.eOS.bT(alVar.vr());
        if (i == 0) {
            this.eOS = alVar;
        } else if (i == 1) {
            this.eOS.bW(alVar.vu());
        } else if (i == 2) {
            this.eOS.bX(alVar.vv());
        }
    }

    public AntiData vj() {
        return this.aiM;
    }

    public UserData getUserData() {
        return this.fAd;
    }

    public boolean sR() {
        return this.bzB.wv() != 0;
    }

    public void an(boolean z) {
        if (this.bzB != null) {
            if (z) {
                this.bzB.cg(1);
            } else {
                this.bzB.cg(0);
            }
        }
    }

    public String sQ() {
        if (this.bzB != null) {
            return this.bzB.ww();
        }
        return null;
    }

    public void rH(String str) {
        if (this.bzB != null) {
            this.bzB.dH(str);
        }
    }

    public String bbO() {
        return this.fAG;
    }

    public boolean bbP() {
        return (this.bzB == null || this.bzB.wy() == null || this.bzB.wy().size() <= 0 || this.bzB.wy().get(0) == null || !this.bzB.wy().get(0).uG()) ? false : true;
    }

    public PostData bbQ() {
        return this.fAJ;
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                com.baidu.tieba.recapp.d.a.bqL().tD(dataRes.asp_shown_info);
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
                qN(dataRes.is_new_url.intValue());
                this.fzW.parserProtobuf(dataRes.forum);
                this.fzX.parserProtobuf(dataRes.display_forum);
                this.bzB.setUserMap(this.userMap);
                this.bzB.a(dataRes.thread);
                this.bzB.cj(2);
                this.fAe.a(dataRes.news_info);
                switch (this.fAe.ajg) {
                    case 1:
                        this.fAf.fKy = this.fAe;
                        break;
                    case 2:
                        this.fAf.fKz = this.fAe;
                        break;
                    case 3:
                        this.fAf.fKA = this.fAe;
                        break;
                    default:
                        this.fAf.fKz = this.fAe;
                        break;
                }
                this.fAj.a(dataRes.recommend_book);
                List<Post> list2 = dataRes.post_list;
                if (list2 != null && list2.size() > 0) {
                    for (Post post : dataRes.post_list) {
                        if (!this.fAI.contains(String.valueOf(post.id))) {
                            PostData postData = new PostData();
                            postData.setUserMap(this.userMap);
                            postData.jT(this.fzW.isBrandForum);
                            postData.a(post, context);
                            postData.a(bbJ().vZ());
                            this.fAI.add(postData.getId());
                            if (postData.byM() == 1 && this.bzB.wR()) {
                                if (bbP()) {
                                    postData.setPostType(0);
                                } else {
                                    postData.setPostType(this.bzB.wQ());
                                }
                            } else if (postData.byM() == 1 && this.bzB.xe()) {
                                postData.setPostType(41);
                            } else if (postData.byM() == 1 && this.bzB != null && this.bzB.xa()) {
                                postData.setPostType(0);
                                postData.OZ();
                                if (this.bzB.wk() == null || this.bzB.wk().size() == 0) {
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
                                    postData.c(new TbRichText((Context) TbadkCoreApplication.getInst(), this.bzB.wk(), true));
                                }
                                this.fAv = postData;
                            }
                            if (postData.byM() == 1 && this.bzB != null && this.bzB.isShareThread) {
                                postData.g(this.bzB.aml);
                            }
                            this.fzY.add(postData);
                        }
                    }
                }
                if (dataRes.first_floor_post != null) {
                    this.fAJ = new PostData();
                    this.fAJ.setUserMap(this.userMap);
                    this.fAJ.jT(this.fzW.isBrandForum);
                    this.fAJ.a(dataRes.first_floor_post, context);
                    if (this.bzB != null && this.bzB.isShareThread) {
                        this.fAJ.g(this.bzB.aml);
                    }
                }
                this.eOS.a(dataRes.page);
                this.aiM.parserProtobuf(dataRes.anti);
                this.fzZ.a(dataRes.location);
                if (dataRes.user != null) {
                    this.fAa = dataRes.user.is_manager.intValue();
                }
                this.fAd.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.fAg.add(muteUser);
                        }
                    }
                }
                this.bzB.cc(this.bzB.wd() > 0 ? this.bzB.wd() - 1 : 0);
                List<AppData> bpT = r.bpV().bpT();
                if (bpT != null) {
                    bpT.clear();
                }
                this.fAo = null;
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        l lVar = new l();
                        lVar.d(app);
                        AppData byA = lVar.byA();
                        if (!this.fAn.contains(lVar) && byA.goods != null && (!StringUtils.isNull(byA.goods.user_name) || !StringUtils.isNull(byA.goods.lego_card))) {
                            this.fAn.add(lVar);
                            if (bpT != null) {
                                bpT.add(lVar.byA());
                            }
                        }
                    }
                    a(dataRes);
                }
                r.bpV().bpU();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.fAd.getIsSelectTail());
                }
                this.fAp.parserProtobuf(dataRes.twzhibo_anti);
                this.fAq = dataRes.appeal_info;
                if (dataRes.god_card != null) {
                    this.fAi = new a();
                    this.fAi.a(dataRes.god_card);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.fAw = new f();
                    this.fAw.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.guess_like != null) {
                    this.fAx = new CardHListViewData();
                    this.fAx.parseProtobuf(dataRes.guess_like);
                }
                if (dataRes.feed_thread_list != null && dataRes.feed_thread_list.size() > 0) {
                    List<ThreadInfo> list3 = dataRes.feed_thread_list;
                    if (this.fAk == null) {
                        this.fAk = new ArrayList();
                    }
                    this.fAk.clear();
                    for (ThreadInfo threadInfo : list3) {
                        if (threadInfo != null) {
                            bb bbVar = new bb();
                            bbVar.a(threadInfo);
                            this.fAk.add(bbVar);
                        }
                    }
                    if (this.fAk != null && this.fAk.size() > 15) {
                        this.fAk = v.b(this.fAk, 0, 15);
                    }
                }
                this.fAl = dataRes.is_follow_current_channel.intValue();
                if (v.y(dataRes.repost_recommend_forum_list) > 0) {
                    if (this.fAr == null) {
                        this.fAr = new ArrayList();
                    }
                    for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                        ay ayVar = new ay();
                        ayVar.parserProtobuf(simpleForum);
                        this.fAr.add(ayVar);
                    }
                }
                if (v.y(dataRes.from_forum_list) > 0) {
                    if (this.fAs == null) {
                        this.fAs = new ArrayList();
                    }
                    for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                        if (simpleForum2 != null) {
                            ay ayVar2 = new ay();
                            ayVar2.parserProtobuf(simpleForum2);
                            this.fAs.add(ayVar2);
                        }
                    }
                }
                this.fAG = dataRes.multi_forum_text;
                if (dataRes.top_agree_post_list != null && this.fAt != null) {
                    this.fAt.jT(this.fzW.isBrandForum);
                    this.fAt.a(context, dataRes.top_agree_post_list);
                }
                if (this.fAy >= 0) {
                    this.fAy = dataRes.thread_freq_num.longValue();
                }
                this.fAz = new i();
                this.fAz.bAn = this.bzB;
                this.fAz.b(dataRes);
                this.fAA = dataRes.partial_visible_toast;
                if (dataRes.follow_tip != null && dataRes.follow_tip.is_toast_tip.intValue() == 1) {
                    this.fAb = dataRes.follow_tip.tip_text;
                }
                this.fAm = new AlaLiveInfoCoreData();
                if (dataRes.ala_info != null) {
                    this.fAm.parserProtoBuf(dataRes.ala_info);
                }
                this.fAF = dataRes.fold_tip;
                this.fAB = dataRes.exp_news_today.intValue();
                this.fAC = dataRes.exp_guide_today.intValue();
                if (!v.z(dataRes.thread_topic)) {
                    for (int i2 = 0; i2 < dataRes.thread_topic.size(); i2++) {
                        au.a aVar = new au.a();
                        aVar.a(dataRes.thread_topic.get(i2));
                        this.fAH.add(aVar);
                    }
                }
                this.fAD = dataRes.pb_sort_info;
                this.fAE = dataRes.sort_type.intValue();
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }

    private void a(DataRes dataRes) {
        App app = dataRes.banner_list.pb_banner_ad;
        l lVar = new l();
        lVar.gVx = true;
        lVar.d(app);
        if (lVar.byA().goods != null) {
            this.fAo = lVar;
        }
    }

    public String bbR() {
        return this.fAF;
    }

    public CardHListViewData bbS() {
        return this.fAx;
    }

    public PostData bbT() {
        return this.fAv;
    }

    public PostData d(PostData postData) {
        this.fAv = postData;
        return postData;
    }

    public k bbU() {
        return this.fAt;
    }

    public int bbV() {
        return this.fAa;
    }

    public int bbW() {
        return this.fAc;
    }

    public void qN(int i) {
        this.fAc = i;
    }

    public List<MuteUser> bbX() {
        return this.fAg;
    }

    public ArrayList<l> bbY() {
        return this.fAn;
    }

    public l bbZ() {
        return this.fAo;
    }

    public void bca() {
        if (this.fAo.byA() != null) {
            this.fAo.byA().legoCard = null;
        }
        this.fAo = null;
    }

    public a bcb() {
        return this.fAi;
    }

    public String bcc() {
        return this.fAu;
    }

    public void rI(String str) {
        this.fAu = str;
    }

    public f bcd() {
        return this.fAw;
    }

    public int bce() {
        return this.fAl;
    }

    public List<ay> bcf() {
        return this.fAs;
    }

    public long bcg() {
        return this.fAy;
    }

    public i bch() {
        return this.fAz;
    }

    public boolean bci() {
        return (bbJ() == null || !bbJ().xa() || bbJ().wE() == null) ? false : true;
    }

    public String bcj() {
        return this.fAb;
    }

    public AlaLiveInfoCoreData bck() {
        return this.fAm;
    }

    public List<au.a> bcl() {
        return this.fAH;
    }
}

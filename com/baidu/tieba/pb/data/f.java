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
import com.baidu.tbadk.core.data.am;
import com.baidu.tbadk.core.data.ao;
import com.baidu.tbadk.core.data.ap;
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.data.be;
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
    private String fBR;
    private int fBS;
    private a fBY;
    private List<be> fCa;
    private int fCb;
    private AlaLiveInfoCoreData fCc;
    private TwzhiboAnti fCe;
    private VoteDataInfo fCf;
    public AppealInfo fCg;
    private List<az> fCh;
    private List<az> fCi;
    public String fCk;
    private PostData fCl;
    private h fCm;
    public CardHListViewData fCn;
    private long fCo;
    private l fCp;
    public String fCq;
    public int fCr;
    public int fCs;
    private String fCt;
    private String fCu;
    private PostData fCv;
    private boolean fBX = true;
    private ArrayList<com.baidu.tieba.tbadkCore.data.l> fCd = new ArrayList<>();
    private ForumData fBM = new ForumData();
    private az fBN = new az();
    private be bWT = new be();
    private ArrayList<PostData> fBO = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private am eMO = new am();
    private AntiData aLS = new AntiData();
    private com.baidu.tbadk.data.f fBP = new com.baidu.tbadk.data.f();
    private int fBQ = 0;
    private final UserData fBT = new UserData();
    private List<MuteUser> fBW = new ArrayList();
    private ao fBU = new ao();
    private ap fBZ = new ap();
    private ad fBV = new ad();
    private n fCj = new n();

    public boolean aYw() {
        return this.fBX;
    }

    public void jy(boolean z) {
        this.fBX = z;
    }

    public VoteDataInfo aYx() {
        return this.fCf;
    }

    public f() {
        this.fBS = 0;
        this.fCe = null;
        this.fBS = 0;
        this.fCe = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.fBO != null && this.fBO.size() > 0;
    }

    public String[] bX(Context context) {
        String str = null;
        String str2 = "";
        if (isValid()) {
            int size = this.fBO.size() > 30 ? 30 : this.fBO.size();
            if (aYA() == null || aYA().yX() == null || com.baidu.tbadk.core.util.am.isEmpty(aYA().yX().getUserId())) {
                return new String[]{null, ""};
            }
            String userId = aYA().yX().getUserId();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                PostData postData = (PostData) v.f(this.fBO, i);
                if (postData != null && postData.yX() != null && !com.baidu.tbadk.core.util.am.isEmpty(postData.yX().getUserId()) && com.baidu.tbadk.core.util.am.equals(userId, postData.yX().getUserId())) {
                    if (com.baidu.tbadk.core.util.am.isEmpty(str)) {
                        str = postData.bCt();
                    }
                    String bCr = com.baidu.tbadk.core.util.am.isEmpty(str2) ? postData.bCr() : str2;
                    if (!com.baidu.tbadk.core.util.am.isEmpty(str) && !com.baidu.tbadk.core.util.am.isEmpty(bCr)) {
                        str2 = bCr;
                        break;
                    }
                    str2 = bCr;
                }
                i++;
                str = str;
            }
            if (com.baidu.tbadk.core.util.am.isEmpty(str)) {
                str = "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            }
            PostData postData2 = this.fBO.get(0);
            if (this.bWT != null && this.bWT.zI() != null && this.bWT.zI().getGroup_id() != 0) {
                str2 = "[" + context.getString(d.j.photo_live_tips) + "] " + str2;
            }
            if (this.bWT != null && this.bWT.zK() && postData2 != null && postData2.QX() != null) {
                str = postData2.QX().getThumbUrl();
            }
        }
        return new String[]{str, str2};
    }

    public ForumData aYy() {
        return this.fBM;
    }

    public az aYz() {
        return this.fBN;
    }

    public String getForumId() {
        if (this.fBM == null) {
            return "";
        }
        return this.fBM.getId();
    }

    public be aYA() {
        return this.bWT;
    }

    public List<be> aYB() {
        return this.fCa;
    }

    public String getThreadId() {
        if (this.bWT == null) {
            return "";
        }
        return this.bWT.getId();
    }

    public ArrayList<PostData> aYC() {
        return this.fBO;
    }

    public am yb() {
        return this.eMO;
    }

    public ad aYD() {
        return this.fBV;
    }

    public ap aYE() {
        return this.fBZ;
    }

    public TwzhiboAnti aYF() {
        return this.fCe;
    }

    public void a(am amVar, int i) {
        this.eMO.eI(amVar.xV());
        this.eMO.eG(amVar.wU());
        this.eMO.eF(amVar.xS());
        this.eMO.eJ(amVar.xW());
        this.eMO.eH(amVar.xU());
        if (i == 0) {
            this.eMO = amVar;
        } else if (i == 1) {
            this.eMO.eK(amVar.xX());
        } else if (i == 2) {
            this.eMO.eL(amVar.xY());
        }
    }

    public AntiData xJ() {
        return this.aLS;
    }

    public UserData getUserData() {
        return this.fBT;
    }

    public boolean vk() {
        return this.bWT.zg() != 0;
    }

    public void aH(boolean z) {
        if (this.bWT != null) {
            if (z) {
                this.bWT.eU(1);
            } else {
                this.bWT.eU(0);
            }
        }
    }

    public String vj() {
        if (this.bWT != null) {
            return this.bWT.zh();
        }
        return null;
    }

    public void pQ(String str) {
        if (this.bWT != null) {
            this.bWT.cR(str);
        }
    }

    public String aYG() {
        return this.fCu;
    }

    public boolean aYH() {
        return (this.bWT == null || this.bWT.zj() == null || this.bWT.zj().size() <= 0 || this.bWT.zj().get(0) == null || !this.bWT.zj().get(0).getIsSenior()) ? false : true;
    }

    public PostData aYI() {
        return this.fCv;
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                com.baidu.tieba.recapp.e.a.bud().sm(dataRes.asp_shown_info);
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
                sD(dataRes.is_new_url.intValue());
                this.fBM.parserProtobuf(dataRes.forum);
                this.fBN.parserProtobuf(dataRes.display_forum);
                this.bWT.setUserMap(this.userMap);
                this.bWT.a(dataRes.thread);
                this.bWT.eY(2);
                this.fBU.a(dataRes.news_info);
                switch (this.fBU.aMj) {
                    case 1:
                        this.fBV.fNc = this.fBU;
                        break;
                    case 2:
                        this.fBV.fNd = this.fBU;
                        break;
                    case 3:
                        this.fBV.fNe = this.fBU;
                        break;
                    default:
                        this.fBV.fNd = this.fBU;
                        break;
                }
                this.fBZ.a(dataRes.recommend_book);
                if (this.bWT != null && this.bWT.yJ() != null) {
                    this.fCf = new VoteDataInfo();
                    this.fCf.parserProtobuf(aYA().yJ());
                }
                List<Post> list2 = dataRes.post_list;
                if (list2 != null && list2.size() > 0) {
                    for (Post post : dataRes.post_list) {
                        PostData postData = new PostData();
                        postData.setUserMap(this.userMap);
                        postData.a(post, context);
                        postData.a(aYA().yM());
                        if (postData.bCl() == 1 && this.bWT.zC()) {
                            if (aYH()) {
                                postData.setPostType(0);
                            } else {
                                postData.setPostType(this.bWT.zB());
                            }
                        } else if (postData.bCl() == 1 && this.bWT != null && this.bWT.zJ()) {
                            postData.setPostType(36);
                        } else if (postData.bCl() == 1 && this.bWT.zQ()) {
                            postData.setPostType(41);
                        } else if (postData.bCl() == 1 && this.bWT != null && this.bWT.zK()) {
                            postData.setPostType(0);
                            postData.QX();
                            if (this.bWT.yV() == null || this.bWT.yV().size() == 0) {
                                JSONArray jSONArray = new JSONArray();
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("type", 0);
                                    jSONObject.put("text", "");
                                    jSONArray.put(jSONObject);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                postData.d(TbRichTextView.a(context, jSONArray, false));
                            } else {
                                postData.d(new TbRichText((Context) TbadkCoreApplication.getInst(), this.bWT.yV(), true));
                            }
                            this.fCl = postData;
                        } else if (postData.bCl() == 1 && this.bWT.zR()) {
                            postData.setPostType(48);
                        }
                        if (postData.bCl() == 1 && this.bWT != null && this.bWT.isShareThread) {
                            postData.f(this.bWT.aPb);
                        }
                        this.fBO.add(postData);
                    }
                }
                if (dataRes.first_floor_post != null) {
                    this.fCv = new PostData();
                    this.fCv.setUserMap(this.userMap);
                    this.fCv.a(dataRes.first_floor_post, context);
                    if (this.bWT != null && this.bWT.isShareThread) {
                        this.fCv.f(this.bWT.aPb);
                    }
                }
                this.eMO.a(dataRes.page);
                this.aLS.parserProtobuf(dataRes.anti);
                this.fBP.a(dataRes.location);
                if (dataRes.user != null) {
                    this.fBQ = dataRes.user.is_manager.intValue();
                }
                this.fBT.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.fBW.add(muteUser);
                        }
                    }
                }
                this.bWT.eQ(this.bWT.yP() > 0 ? this.bWT.yP() - 1 : 0);
                List<AppData> btw = q.bty().btw();
                if (btw != null) {
                    btw.clear();
                }
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        com.baidu.tieba.tbadkCore.data.l lVar = new com.baidu.tieba.tbadkCore.data.l();
                        lVar.d(app);
                        AppData bBZ = lVar.bBZ();
                        if (!this.fCd.contains(lVar) && bBZ.goods != null && (!StringUtils.isNull(bBZ.goods.user_name) || !StringUtils.isNull(bBZ.goods.lego_card))) {
                            this.fCd.add(lVar);
                            if (btw != null) {
                                btw.add(lVar.bBZ());
                            }
                        }
                    }
                }
                q.bty().btx();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.fBT.getIsSelectTail());
                }
                this.fCe.parserProtobuf(dataRes.twzhibo_anti);
                this.fCg = dataRes.appeal_info;
                if (dataRes.god_card != null) {
                    this.fBY = new a();
                    this.fBY.a(dataRes.god_card);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.fCm = new h();
                    this.fCm.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.guess_like != null) {
                    this.fCn = new CardHListViewData();
                    this.fCn.parseProtobuf(dataRes.guess_like);
                }
                if (dataRes.feed_thread_list != null && dataRes.feed_thread_list.size() > 0) {
                    List<ThreadInfo> list3 = dataRes.feed_thread_list;
                    if (this.fCa == null) {
                        this.fCa = new ArrayList();
                    }
                    this.fCa.clear();
                    for (ThreadInfo threadInfo : list3) {
                        if (threadInfo != null) {
                            be beVar = new be();
                            beVar.a(threadInfo);
                            this.fCa.add(beVar);
                        }
                    }
                    if (this.fCa != null && this.fCa.size() > 15) {
                        this.fCa = v.b(this.fCa, 0, 15);
                    }
                }
                this.fCb = dataRes.is_follow_current_channel.intValue();
                if (v.F(dataRes.repost_recommend_forum_list) > 0) {
                    if (this.fCh == null) {
                        this.fCh = new ArrayList();
                    }
                    for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                        az azVar = new az();
                        azVar.parserProtobuf(simpleForum);
                        this.fCh.add(azVar);
                    }
                }
                if (v.F(dataRes.from_forum_list) > 0) {
                    if (this.fCi == null) {
                        this.fCi = new ArrayList();
                    }
                    for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                        if (simpleForum2 != null) {
                            az azVar2 = new az();
                            azVar2.parserProtobuf(simpleForum2);
                            this.fCi.add(azVar2);
                        }
                    }
                }
                this.fCu = dataRes.multi_forum_text;
                if (dataRes.top_agree_post_list != null && this.fCj != null) {
                    this.fCj.a(context, dataRes.top_agree_post_list);
                }
                if (this.fCo >= 0) {
                    this.fCo = dataRes.thread_freq_num.longValue();
                }
                this.fCp = new l();
                this.fCp.a(dataRes);
                this.fCq = dataRes.partial_visible_toast;
                if (dataRes.follow_tip != null && dataRes.follow_tip.is_toast_tip.intValue() == 1) {
                    this.fBR = dataRes.follow_tip.tip_text;
                }
                this.fCc = new AlaLiveInfoCoreData();
                if (dataRes.ala_info != null) {
                    this.fCc.parserProtoBuf(dataRes.ala_info);
                }
                this.fCt = dataRes.fold_tip;
                this.fCr = dataRes.exp_news_today.intValue();
                this.fCs = dataRes.exp_guide_today.intValue();
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }

    public String aYJ() {
        return this.fCt;
    }

    public CardHListViewData aYK() {
        return this.fCn;
    }

    public PostData aYL() {
        return this.fCl;
    }

    public PostData c(PostData postData) {
        this.fCl = postData;
        return postData;
    }

    public n aYM() {
        return this.fCj;
    }

    public int aYN() {
        return this.fBQ;
    }

    public int aYO() {
        return this.fBS;
    }

    public void sD(int i) {
        this.fBS = i;
    }

    public List<MuteUser> aYP() {
        return this.fBW;
    }

    public ArrayList<com.baidu.tieba.tbadkCore.data.l> aYQ() {
        return this.fCd;
    }

    public a aYR() {
        return this.fBY;
    }

    public ArrayList<com.baidu.adp.widget.ListView.i> aYS() {
        return new ArrayList<>(this.fBO);
    }

    public String aYT() {
        return this.fCk;
    }

    public void pR(String str) {
        this.fCk = str;
    }

    public h aYU() {
        return this.fCm;
    }

    public int aYV() {
        return this.fCb;
    }

    public List<az> aYW() {
        return this.fCi;
    }

    public long aYX() {
        return this.fCo;
    }

    public l aYY() {
        return this.fCp;
    }

    public void a(l lVar) {
        this.fCp = lVar;
    }

    public boolean aYZ() {
        return (aYA() == null || !aYA().zK() || aYA().zp() == null) ? false : true;
    }

    public String aZa() {
        return this.fBR;
    }

    public AlaLiveInfoCoreData aZb() {
        return this.fCc;
    }
}

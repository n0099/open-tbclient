package com.baidu.tieba.pb.data;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.TwzhiboAnti;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.ag;
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.data.au;
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.data.q;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.pb.pb.main.fb;
import com.baidu.tieba.tbadkCore.data.AppData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.usermute.MuteUser;
import com.baidu.tieba.vote.VoteDataInfo;
import com.baidu.tieba.w;
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
/* loaded from: classes.dex */
public class f {
    private int dvZ;
    private a erA;
    private List<bm> erC;
    private int erD;
    private int erE;
    private TwzhiboAnti erG;
    private VoteDataInfo erH;
    public AppealInfo erI;
    private List<bf> erJ;
    private List<bf> erK;
    public String erM;
    private PostData erN;
    private h erP;
    public CardHListViewData erQ;
    private long erR;
    private m erS;
    public String erT;
    private PostData erU;
    private boolean erz = true;
    private ArrayList<com.baidu.tieba.tbadkCore.data.o> erF = new ArrayList<>();
    private ForumData erp = new ForumData();
    private bf erq = new bf();
    private bm bai = new bm();
    private ArrayList<PostData> err = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private as duF = new as();
    private AntiData Wa = new AntiData();
    private com.baidu.tbadk.data.g ers = new com.baidu.tbadk.data.g();
    private int eru = 0;
    private boolean ert = false;
    private final UserData erv = new UserData();
    private List<MuteUser> ery = new ArrayList();
    private au erw = new au();
    private av erB = new av();
    private fb erx = new fb();
    private ag erO = new ag();
    private o erL = new o();

    public boolean aMq() {
        return this.erz;
    }

    public void it(boolean z) {
        this.erz = z;
    }

    public ag aMr() {
        return this.erO;
    }

    public VoteDataInfo aMs() {
        return this.erH;
    }

    public f() {
        this.dvZ = 0;
        this.erG = null;
        this.dvZ = 0;
        this.erG = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.err != null && this.err.size() > 0;
    }

    public q rQ() {
        if (this.bai == null) {
            return null;
        }
        return this.bai.rQ();
    }

    public String[] bD(Context context) {
        String str = null;
        String str2 = "";
        if (isValid()) {
            PostData postData = this.err.get(0);
            PreLoadImageInfo bmz = postData.bmz();
            str = bmz != null ? bmz.imgUrl : "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            str2 = postData.bO(context);
            if (this.bai != null && this.bai.sc() != null && this.bai.sc().getGroup_id() != 0) {
                str2 = "[" + context.getString(w.l.photo_live_tips) + "] " + str2;
            }
            if (this.bai != null && this.bai.se() && postData != null && postData.Ie() != null) {
                str = postData.Ie().getThumbUrl();
            }
        }
        return new String[]{str, str2};
    }

    public ForumData aMt() {
        return this.erp;
    }

    public bf aMu() {
        return this.erq;
    }

    public String getForumId() {
        if (this.erp == null) {
            return "";
        }
        return this.erp.getId();
    }

    public bm aMv() {
        return this.bai;
    }

    public List<bm> aMw() {
        return this.erC;
    }

    public String getThreadId() {
        if (this.bai == null) {
            return "";
        }
        return this.bai.getId();
    }

    public ArrayList<PostData> aMx() {
        return this.err;
    }

    public as qu() {
        return this.duF;
    }

    public fb aMy() {
        return this.erx;
    }

    public av aMz() {
        return this.erB;
    }

    public TwzhiboAnti aMA() {
        return this.erG;
    }

    public void a(as asVar, int i) {
        this.duF.bI(asVar.qo());
        this.duF.bG(asVar.pe());
        this.duF.bF(asVar.ql());
        this.duF.bJ(asVar.qp());
        this.duF.bH(asVar.qn());
        if (i == 0) {
            this.duF = asVar;
        } else if (i == 1) {
            this.duF.bK(asVar.qq());
        } else if (i == 2) {
            this.duF.bL(asVar.qr());
        }
    }

    public AntiData qe() {
        return this.Wa;
    }

    public UserData getUserData() {
        return this.erv;
    }

    public boolean nz() {
        return this.bai.getIsMarked() != 0;
    }

    public void ac(boolean z) {
        if (this.bai != null) {
            if (z) {
                this.bai.setIsMarked(1);
            } else {
                this.bai.setIsMarked(0);
            }
        }
    }

    public String ny() {
        if (this.bai != null) {
            return this.bai.rA();
        }
        return null;
    }

    public void oE(String str) {
        if (this.bai != null) {
            this.bai.cB(str);
        }
    }

    public boolean aMB() {
        return (this.bai == null || this.bai.rC() == null || this.bai.rC().size() <= 0 || this.bai.rC().get(0) == null || !this.bai.rC().get(0).getIsSenior()) ? false : true;
    }

    public PostData aMC() {
        return this.erU;
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                com.baidu.tieba.recapp.d.a.bex().qD(dataRes.asp_shown_info);
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
                mG(dataRes.is_new_url.intValue());
                this.erp.parserProtobuf(dataRes.forum);
                this.erq.parserProtobuf(dataRes.display_forum);
                this.bai.setUserMap(this.userMap);
                this.bai.a(dataRes.thread);
                this.bai.bW(2);
                if (rQ() != null) {
                    rQ().setForumId(com.baidu.adp.lib.g.b.c(this.erp.getId(), 0L));
                }
                this.erw.a(dataRes.news_info);
                switch (this.erw.Ws) {
                    case 1:
                        this.erx.eAn = this.erw;
                        break;
                    case 2:
                        this.erx.eAo = this.erw;
                        break;
                    case 3:
                        this.erx.eAp = this.erw;
                        break;
                    default:
                        this.erx.eAo = this.erw;
                        break;
                }
                this.erB.a(dataRes.recommend_book);
                if (this.bai != null && this.bai.rg() != null) {
                    this.erH = new VoteDataInfo();
                    this.erH.parserProtobuf(aMv().rg());
                }
                List<Post> list2 = dataRes.post_list;
                if (list2 != null && list2.size() > 0) {
                    for (Post post : dataRes.post_list) {
                        PostData postData = new PostData();
                        postData.setUserMap(this.userMap);
                        postData.a(post, context);
                        postData.a(aMv().rh());
                        if (postData.bmu() == 1 && this.bai.rW()) {
                            if (aMB()) {
                                postData.setPostType(0);
                            } else {
                                postData.setPostType(this.bai.rV());
                            }
                        } else if (postData.bmu() == 1 && this.bai != null && this.bai.sd()) {
                            postData.setPostType(36);
                        } else if (postData.bmu() == 1 && this.bai.sj()) {
                            postData.setPostType(41);
                        } else if (postData.bmu() == 1 && this.bai != null && this.bai.se()) {
                            postData.setPostType(0);
                            postData.Ie();
                            if (this.bai.rp() == null || this.bai.rp().size() == 0) {
                                JSONArray jSONArray = new JSONArray();
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("type", 0);
                                    jSONObject.put("text", "");
                                    jSONArray.put(jSONObject);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                postData.g(TbRichTextView.a(context, jSONArray, false));
                            } else {
                                postData.g(new TbRichText((Context) TbadkCoreApplication.m9getInst(), this.bai.rp(), true));
                            }
                            this.erN = postData;
                        } else if (postData.bmu() == 1 && this.bai.sk()) {
                            postData.setPostType(48);
                        }
                        this.err.add(postData);
                    }
                }
                if (dataRes.first_floor_post != null) {
                    this.erU = new PostData();
                    this.erU.setUserMap(this.userMap);
                    this.erU.a(dataRes.first_floor_post, context);
                }
                this.duF.a(dataRes.page);
                this.Wa.parserProtobuf(dataRes.anti);
                this.ers.a(dataRes.location);
                this.ert = dataRes.has_floor.intValue() == 1;
                if (dataRes.user != null) {
                    this.eru = dataRes.user.is_manager.intValue();
                }
                this.erv.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.ery.add(muteUser);
                        }
                    }
                }
                this.bai.bQ(this.bai.rj() > 0 ? this.bai.rj() - 1 : 0);
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        com.baidu.tieba.tbadkCore.data.o oVar = new com.baidu.tieba.tbadkCore.data.o();
                        oVar.c(app);
                        AppData bmj = oVar.bmj();
                        if (!this.erF.contains(oVar) && bmj.goods != null && (!StringUtils.isNull(bmj.goods.user_name) || !StringUtils.isNull(bmj.goods.lego_card))) {
                            this.erF.add(oVar);
                        }
                    }
                }
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.erv.getIsSelectTail());
                }
                this.erG.parserProtobuf(dataRes.twzhibo_anti);
                this.erI = dataRes.appeal_info;
                if (this.erO != null) {
                    this.erO.setForumId(getForumId());
                    this.erO.setThreadId(getThreadId());
                    this.erO.bE(0);
                    if (this.eru > 0) {
                        this.erO.bE(2);
                    }
                    if (this.bai != null && this.bai.getAuthor() != null) {
                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                        if (!TextUtils.isEmpty(currentAccount) && currentAccount.equals(this.bai.getAuthor().getUserId())) {
                            this.erO.bE(1);
                        }
                    }
                    this.erO.a(dataRes.graffiti_rank_list_info);
                    this.erO.VM = this.bai.Zh;
                }
                if (dataRes.god_card != null) {
                    this.erA = new a();
                    this.erA.a(dataRes.god_card);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.erP = new h();
                    this.erP.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.guess_like != null) {
                    this.erQ = new CardHListViewData();
                    this.erQ.parseProtobuf(dataRes.guess_like);
                }
                if (dataRes.feed_thread_list != null && dataRes.feed_thread_list.size() > 0) {
                    List<ThreadInfo> list3 = dataRes.feed_thread_list;
                    if (this.erC == null) {
                        this.erC = new ArrayList();
                    }
                    this.erC.clear();
                    for (ThreadInfo threadInfo : list3) {
                        if (threadInfo != null) {
                            bm bmVar = new bm();
                            bmVar.a(threadInfo);
                            this.erC.add(bmVar);
                        }
                    }
                    if (this.erC != null && this.erC.size() > 15) {
                        this.erC = z.a(this.erC, 0, 15);
                    }
                }
                this.erD = dataRes.is_follow_current_channel.intValue();
                this.erE = dataRes.switch_read_open.intValue();
                if (z.s(dataRes.repost_recommend_forum_list) > 0) {
                    if (this.erJ == null) {
                        this.erJ = new ArrayList();
                    }
                    for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                        bf bfVar = new bf();
                        bfVar.parserProtobuf(simpleForum);
                        this.erJ.add(bfVar);
                    }
                }
                if (z.s(dataRes.from_forum_list) > 0) {
                    if (this.erK == null) {
                        this.erK = new ArrayList();
                    }
                    for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                        bf bfVar2 = new bf();
                        bfVar2.parserProtobuf(simpleForum2);
                        this.erK.add(bfVar2);
                    }
                }
                if (dataRes.top_agree_post_list != null && this.erL != null) {
                    this.erL.a(context, dataRes.top_agree_post_list);
                }
                if (this.erR >= 0) {
                    this.erR = dataRes.thread_freq_num.longValue();
                }
                this.erS = new m();
                this.erS.a(dataRes);
                this.erT = dataRes.partial_visible_toast;
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }

    public CardHListViewData aMD() {
        return this.erQ;
    }

    public PostData aME() {
        return this.erN;
    }

    public PostData e(PostData postData) {
        this.erN = postData;
        return postData;
    }

    public o aMF() {
        return this.erL;
    }

    public int aMG() {
        return this.eru;
    }

    public int aMH() {
        return this.dvZ;
    }

    public void mG(int i) {
        this.dvZ = i;
    }

    public List<MuteUser> aMI() {
        return this.ery;
    }

    public ArrayList<com.baidu.tieba.tbadkCore.data.o> aMJ() {
        return this.erF;
    }

    public a aMK() {
        return this.erA;
    }

    public ArrayList<v> aML() {
        return new ArrayList<>(this.err);
    }

    public String aMM() {
        return this.erM;
    }

    public void oF(String str) {
        this.erM = str;
    }

    public h aMN() {
        return this.erP;
    }

    public int aMO() {
        return this.erD;
    }

    public boolean aMP() {
        return this.erE == 1;
    }

    public List<bf> aMQ() {
        return this.erK;
    }

    public long aMR() {
        return this.erR;
    }

    public m aMS() {
        return this.erS;
    }

    public void a(m mVar) {
        this.erS = mVar;
    }
}

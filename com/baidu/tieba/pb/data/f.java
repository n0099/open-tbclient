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
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.ac;
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
/* loaded from: classes.dex */
public class f {
    private int ePA;
    private AlaLiveInfoCoreData ePB;
    private TwzhiboAnti ePD;
    private VoteDataInfo ePE;
    public AppealInfo ePF;
    private List<ay> ePG;
    private List<ay> ePH;
    public String ePJ;
    private PostData ePK;
    private h ePL;
    public CardHListViewData ePM;
    private long ePN;
    private l ePO;
    public String ePP;
    private PostData ePQ;
    private String ePq;
    private int ePr;
    private a ePx;
    private List<bd> ePz;
    private boolean ePw = true;
    private ArrayList<com.baidu.tieba.tbadkCore.data.l> ePC = new ArrayList<>();
    private ForumData ePl = new ForumData();
    private ay ePm = new ay();
    private bd bjE = new bd();
    private ArrayList<PostData> ePn = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private al eaH = new al();
    private AntiData Xr = new AntiData();
    private com.baidu.tbadk.data.i ePo = new com.baidu.tbadk.data.i();
    private int ePp = 0;
    private final UserData ePs = new UserData();
    private List<MuteUser> ePv = new ArrayList();
    private an ePt = new an();
    private ao ePy = new ao();
    private ac ePu = new ac();
    private n ePI = new n();

    public boolean aRl() {
        return this.ePw;
    }

    public void iW(boolean z) {
        this.ePw = z;
    }

    public VoteDataInfo aRm() {
        return this.ePE;
    }

    public f() {
        this.ePr = 0;
        this.ePD = null;
        this.ePr = 0;
        this.ePD = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.ePn != null && this.ePn.size() > 0;
    }

    public String[] bM(Context context) {
        String str = null;
        String str2 = "";
        if (isValid()) {
            PostData postData = this.ePn.get(0);
            PreLoadImageInfo bxa = postData.bxa();
            str = bxa != null ? bxa.imgUrl : "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            str2 = postData.ce(context);
            if (this.bjE != null && this.bjE.sg() != null && this.bjE.sg().getGroup_id() != 0) {
                str2 = "[" + context.getString(d.j.photo_live_tips) + "] " + str2;
            }
            if (this.bjE != null && this.bjE.si() && postData != null && postData.JB() != null) {
                str = postData.JB().getThumbUrl();
            }
        }
        return new String[]{str, str2};
    }

    public ForumData aRn() {
        return this.ePl;
    }

    public ay aRo() {
        return this.ePm;
    }

    public String getForumId() {
        if (this.ePl == null) {
            return "";
        }
        return this.ePl.getId();
    }

    public bd aRp() {
        return this.bjE;
    }

    public List<bd> aRq() {
        return this.ePz;
    }

    public String getThreadId() {
        if (this.bjE == null) {
            return "";
        }
        return this.bjE.getId();
    }

    public ArrayList<PostData> aRr() {
        return this.ePn;
    }

    public al qy() {
        return this.eaH;
    }

    public ac aRs() {
        return this.ePu;
    }

    public ao aRt() {
        return this.ePy;
    }

    public TwzhiboAnti aRu() {
        return this.ePD;
    }

    public void a(al alVar, int i) {
        this.eaH.bI(alVar.qs());
        this.eaH.bG(alVar.pr());
        this.eaH.bF(alVar.qp());
        this.eaH.bJ(alVar.qt());
        this.eaH.bH(alVar.qr());
        if (i == 0) {
            this.eaH = alVar;
        } else if (i == 1) {
            this.eaH.bK(alVar.qu());
        } else if (i == 2) {
            this.eaH.bL(alVar.qv());
        }
    }

    public AntiData qg() {
        return this.Xr;
    }

    public UserData getUserData() {
        return this.ePs;
    }

    public boolean nH() {
        return this.bjE.rE() != 0;
    }

    public void ab(boolean z) {
        if (this.bjE != null) {
            if (z) {
                this.bjE.bU(1);
            } else {
                this.bjE.bU(0);
            }
        }
    }

    public String nG() {
        if (this.bjE != null) {
            return this.bjE.rF();
        }
        return null;
    }

    public void pG(String str) {
        if (this.bjE != null) {
            this.bjE.cK(str);
        }
    }

    public boolean aRv() {
        return (this.bjE == null || this.bjE.rH() == null || this.bjE.rH().size() <= 0 || this.bjE.rH().get(0) == null || !this.bjE.rH().get(0).getIsSenior()) ? false : true;
    }

    public PostData aRw() {
        return this.ePQ;
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                com.baidu.tieba.recapp.e.a.bmv().sa(dataRes.asp_shown_info);
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
                pJ(dataRes.is_new_url.intValue());
                this.ePl.parserProtobuf(dataRes.forum);
                this.ePm.parserProtobuf(dataRes.display_forum);
                this.bjE.setUserMap(this.userMap);
                this.bjE.a(dataRes.thread);
                this.bjE.bY(2);
                this.ePt.a(dataRes.news_info);
                switch (this.ePt.XI) {
                    case 1:
                        this.ePu.faf = this.ePt;
                        break;
                    case 2:
                        this.ePu.fag = this.ePt;
                        break;
                    case 3:
                        this.ePu.fah = this.ePt;
                        break;
                    default:
                        this.ePu.fag = this.ePt;
                        break;
                }
                this.ePy.a(dataRes.recommend_book);
                if (this.bjE != null && this.bjE.rh() != null) {
                    this.ePE = new VoteDataInfo();
                    this.ePE.parserProtobuf(aRp().rh());
                }
                List<Post> list2 = dataRes.post_list;
                if (list2 != null && list2.size() > 0) {
                    for (Post post : dataRes.post_list) {
                        PostData postData = new PostData();
                        postData.setUserMap(this.userMap);
                        postData.a(post, context);
                        postData.a(aRp().rk());
                        if (postData.bwU() == 1 && this.bjE.sa()) {
                            if (aRv()) {
                                postData.setPostType(0);
                            } else {
                                postData.setPostType(this.bjE.rZ());
                            }
                        } else if (postData.bwU() == 1 && this.bjE != null && this.bjE.sh()) {
                            postData.setPostType(36);
                        } else if (postData.bwU() == 1 && this.bjE.so()) {
                            postData.setPostType(41);
                        } else if (postData.bwU() == 1 && this.bjE != null && this.bjE.si()) {
                            postData.setPostType(0);
                            postData.JB();
                            if (this.bjE.rt() == null || this.bjE.rt().size() == 0) {
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
                                postData.d(new TbRichText((Context) TbadkCoreApplication.getInst(), this.bjE.rt(), true));
                            }
                            this.ePK = postData;
                        } else if (postData.bwU() == 1 && this.bjE.sp()) {
                            postData.setPostType(48);
                        }
                        if (postData.bwU() == 1 && this.bjE != null && this.bjE.isShareThread) {
                            postData.f(this.bjE.aaC);
                        }
                        this.ePn.add(postData);
                    }
                }
                if (dataRes.first_floor_post != null) {
                    this.ePQ = new PostData();
                    this.ePQ.setUserMap(this.userMap);
                    this.ePQ.a(dataRes.first_floor_post, context);
                    if (this.bjE != null && this.bjE.isShareThread) {
                        this.ePQ.f(this.bjE.aaC);
                    }
                }
                this.eaH.a(dataRes.page);
                this.Xr.parserProtobuf(dataRes.anti);
                this.ePo.a(dataRes.location);
                if (dataRes.user != null) {
                    this.ePp = dataRes.user.is_manager.intValue();
                }
                this.ePs.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.ePv.add(muteUser);
                        }
                    }
                }
                this.bjE.bQ(this.bjE.rn() > 0 ? this.bjE.rn() - 1 : 0);
                List<AppData> blO = q.blQ().blO();
                if (blO != null) {
                    blO.clear();
                }
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        com.baidu.tieba.tbadkCore.data.l lVar = new com.baidu.tieba.tbadkCore.data.l();
                        lVar.c(app);
                        AppData bwJ = lVar.bwJ();
                        if (!this.ePC.contains(lVar) && bwJ.goods != null && (!StringUtils.isNull(bwJ.goods.user_name) || !StringUtils.isNull(bwJ.goods.lego_card))) {
                            this.ePC.add(lVar);
                            if (blO != null) {
                                blO.add(lVar.bwJ());
                            }
                        }
                    }
                }
                q.blQ().blP();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.ePs.getIsSelectTail());
                }
                this.ePD.parserProtobuf(dataRes.twzhibo_anti);
                this.ePF = dataRes.appeal_info;
                if (dataRes.god_card != null) {
                    this.ePx = new a();
                    this.ePx.a(dataRes.god_card);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.ePL = new h();
                    this.ePL.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.guess_like != null) {
                    this.ePM = new CardHListViewData();
                    this.ePM.parseProtobuf(dataRes.guess_like);
                }
                if (dataRes.feed_thread_list != null && dataRes.feed_thread_list.size() > 0) {
                    List<ThreadInfo> list3 = dataRes.feed_thread_list;
                    if (this.ePz == null) {
                        this.ePz = new ArrayList();
                    }
                    this.ePz.clear();
                    for (ThreadInfo threadInfo : list3) {
                        if (threadInfo != null) {
                            bd bdVar = new bd();
                            bdVar.a(threadInfo);
                            this.ePz.add(bdVar);
                        }
                    }
                    if (this.ePz != null && this.ePz.size() > 15) {
                        this.ePz = v.a(this.ePz, 0, 15);
                    }
                }
                this.ePA = dataRes.is_follow_current_channel.intValue();
                if (v.v(dataRes.repost_recommend_forum_list) > 0) {
                    if (this.ePG == null) {
                        this.ePG = new ArrayList();
                    }
                    for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                        ay ayVar = new ay();
                        ayVar.parserProtobuf(simpleForum);
                        this.ePG.add(ayVar);
                    }
                }
                if (v.v(dataRes.from_forum_list) > 0) {
                    if (this.ePH == null) {
                        this.ePH = new ArrayList();
                    }
                    for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                        ay ayVar2 = new ay();
                        ayVar2.parserProtobuf(simpleForum2);
                        this.ePH.add(ayVar2);
                    }
                }
                if (dataRes.top_agree_post_list != null && this.ePI != null) {
                    this.ePI.a(context, dataRes.top_agree_post_list);
                }
                if (this.ePN >= 0) {
                    this.ePN = dataRes.thread_freq_num.longValue();
                }
                this.ePO = new l();
                this.ePO.a(dataRes);
                this.ePP = dataRes.partial_visible_toast;
                if (dataRes.follow_tip != null && dataRes.follow_tip.is_toast_tip.intValue() == 1) {
                    this.ePq = dataRes.follow_tip.tip_text;
                }
                this.ePB = new AlaLiveInfoCoreData();
                if (dataRes.ala_info != null) {
                    this.ePB.parserProtoBuf(dataRes.ala_info);
                }
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }

    public CardHListViewData aRx() {
        return this.ePM;
    }

    public PostData aRy() {
        return this.ePK;
    }

    public PostData c(PostData postData) {
        this.ePK = postData;
        return postData;
    }

    public n aRz() {
        return this.ePI;
    }

    public int aRA() {
        return this.ePp;
    }

    public int aRB() {
        return this.ePr;
    }

    public void pJ(int i) {
        this.ePr = i;
    }

    public List<MuteUser> aRC() {
        return this.ePv;
    }

    public ArrayList<com.baidu.tieba.tbadkCore.data.l> aRD() {
        return this.ePC;
    }

    public a aRE() {
        return this.ePx;
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> aRF() {
        return new ArrayList<>(this.ePn);
    }

    public String aRG() {
        return this.ePJ;
    }

    public void pH(String str) {
        this.ePJ = str;
    }

    public h aRH() {
        return this.ePL;
    }

    public int aRI() {
        return this.ePA;
    }

    public List<ay> aRJ() {
        return this.ePH;
    }

    public long aRK() {
        return this.ePN;
    }

    public l aRL() {
        return this.ePO;
    }

    public void a(l lVar) {
        this.ePO = lVar;
    }

    public boolean aRM() {
        return (aRp() == null || !aRp().si() || aRp().rN() == null) ? false : true;
    }

    public String aRN() {
        return this.ePq;
    }

    public AlaLiveInfoCoreData aRO() {
        return this.ePB;
    }
}

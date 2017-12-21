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
    private a ePC;
    private List<bd> ePE;
    private int ePF;
    private AlaLiveInfoCoreData ePG;
    private TwzhiboAnti ePI;
    private VoteDataInfo ePJ;
    public AppealInfo ePK;
    private List<ay> ePL;
    private List<ay> ePM;
    public String ePO;
    private PostData ePP;
    private h ePQ;
    public CardHListViewData ePR;
    private long ePS;
    private l ePT;
    public String ePU;
    private PostData ePV;
    private String ePv;
    private int ePw;
    private boolean ePB = true;
    private ArrayList<com.baidu.tieba.tbadkCore.data.l> ePH = new ArrayList<>();
    private ForumData ePq = new ForumData();
    private ay ePr = new ay();
    private bd bjI = new bd();
    private ArrayList<PostData> ePs = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private al eaL = new al();
    private AntiData Xu = new AntiData();
    private com.baidu.tbadk.data.i ePt = new com.baidu.tbadk.data.i();
    private int ePu = 0;
    private final UserData ePx = new UserData();
    private List<MuteUser> ePA = new ArrayList();
    private an ePy = new an();
    private ao ePD = new ao();
    private ac ePz = new ac();
    private n ePN = new n();

    public boolean aRm() {
        return this.ePB;
    }

    public void iW(boolean z) {
        this.ePB = z;
    }

    public VoteDataInfo aRn() {
        return this.ePJ;
    }

    public f() {
        this.ePw = 0;
        this.ePI = null;
        this.ePw = 0;
        this.ePI = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.ePs != null && this.ePs.size() > 0;
    }

    public String[] bM(Context context) {
        String str = null;
        String str2 = "";
        if (isValid()) {
            PostData postData = this.ePs.get(0);
            PreLoadImageInfo bxb = postData.bxb();
            str = bxb != null ? bxb.imgUrl : "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            str2 = postData.ce(context);
            if (this.bjI != null && this.bjI.sg() != null && this.bjI.sg().getGroup_id() != 0) {
                str2 = "[" + context.getString(d.j.photo_live_tips) + "] " + str2;
            }
            if (this.bjI != null && this.bjI.si() && postData != null && postData.JB() != null) {
                str = postData.JB().getThumbUrl();
            }
        }
        return new String[]{str, str2};
    }

    public ForumData aRo() {
        return this.ePq;
    }

    public ay aRp() {
        return this.ePr;
    }

    public String getForumId() {
        if (this.ePq == null) {
            return "";
        }
        return this.ePq.getId();
    }

    public bd aRq() {
        return this.bjI;
    }

    public List<bd> aRr() {
        return this.ePE;
    }

    public String getThreadId() {
        if (this.bjI == null) {
            return "";
        }
        return this.bjI.getId();
    }

    public ArrayList<PostData> aRs() {
        return this.ePs;
    }

    public al qy() {
        return this.eaL;
    }

    public ac aRt() {
        return this.ePz;
    }

    public ao aRu() {
        return this.ePD;
    }

    public TwzhiboAnti aRv() {
        return this.ePI;
    }

    public void a(al alVar, int i) {
        this.eaL.bI(alVar.qs());
        this.eaL.bG(alVar.pr());
        this.eaL.bF(alVar.qp());
        this.eaL.bJ(alVar.qt());
        this.eaL.bH(alVar.qr());
        if (i == 0) {
            this.eaL = alVar;
        } else if (i == 1) {
            this.eaL.bK(alVar.qu());
        } else if (i == 2) {
            this.eaL.bL(alVar.qv());
        }
    }

    public AntiData qg() {
        return this.Xu;
    }

    public UserData getUserData() {
        return this.ePx;
    }

    public boolean nH() {
        return this.bjI.rE() != 0;
    }

    public void ab(boolean z) {
        if (this.bjI != null) {
            if (z) {
                this.bjI.bU(1);
            } else {
                this.bjI.bU(0);
            }
        }
    }

    public String nG() {
        if (this.bjI != null) {
            return this.bjI.rF();
        }
        return null;
    }

    public void pG(String str) {
        if (this.bjI != null) {
            this.bjI.cK(str);
        }
    }

    public boolean aRw() {
        return (this.bjI == null || this.bjI.rH() == null || this.bjI.rH().size() <= 0 || this.bjI.rH().get(0) == null || !this.bjI.rH().get(0).getIsSenior()) ? false : true;
    }

    public PostData aRx() {
        return this.ePV;
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                com.baidu.tieba.recapp.e.a.bmw().sa(dataRes.asp_shown_info);
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
                this.ePq.parserProtobuf(dataRes.forum);
                this.ePr.parserProtobuf(dataRes.display_forum);
                this.bjI.setUserMap(this.userMap);
                this.bjI.a(dataRes.thread);
                this.bjI.bY(2);
                this.ePy.a(dataRes.news_info);
                switch (this.ePy.XL) {
                    case 1:
                        this.ePz.fak = this.ePy;
                        break;
                    case 2:
                        this.ePz.fal = this.ePy;
                        break;
                    case 3:
                        this.ePz.fam = this.ePy;
                        break;
                    default:
                        this.ePz.fal = this.ePy;
                        break;
                }
                this.ePD.a(dataRes.recommend_book);
                if (this.bjI != null && this.bjI.rh() != null) {
                    this.ePJ = new VoteDataInfo();
                    this.ePJ.parserProtobuf(aRq().rh());
                }
                List<Post> list2 = dataRes.post_list;
                if (list2 != null && list2.size() > 0) {
                    for (Post post : dataRes.post_list) {
                        PostData postData = new PostData();
                        postData.setUserMap(this.userMap);
                        postData.a(post, context);
                        postData.a(aRq().rk());
                        if (postData.bwV() == 1 && this.bjI.sa()) {
                            if (aRw()) {
                                postData.setPostType(0);
                            } else {
                                postData.setPostType(this.bjI.rZ());
                            }
                        } else if (postData.bwV() == 1 && this.bjI != null && this.bjI.sh()) {
                            postData.setPostType(36);
                        } else if (postData.bwV() == 1 && this.bjI.so()) {
                            postData.setPostType(41);
                        } else if (postData.bwV() == 1 && this.bjI != null && this.bjI.si()) {
                            postData.setPostType(0);
                            postData.JB();
                            if (this.bjI.rt() == null || this.bjI.rt().size() == 0) {
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
                                postData.d(new TbRichText((Context) TbadkCoreApplication.getInst(), this.bjI.rt(), true));
                            }
                            this.ePP = postData;
                        } else if (postData.bwV() == 1 && this.bjI.sp()) {
                            postData.setPostType(48);
                        }
                        if (postData.bwV() == 1 && this.bjI != null && this.bjI.isShareThread) {
                            postData.f(this.bjI.aaF);
                        }
                        this.ePs.add(postData);
                    }
                }
                if (dataRes.first_floor_post != null) {
                    this.ePV = new PostData();
                    this.ePV.setUserMap(this.userMap);
                    this.ePV.a(dataRes.first_floor_post, context);
                    if (this.bjI != null && this.bjI.isShareThread) {
                        this.ePV.f(this.bjI.aaF);
                    }
                }
                this.eaL.a(dataRes.page);
                this.Xu.parserProtobuf(dataRes.anti);
                this.ePt.a(dataRes.location);
                if (dataRes.user != null) {
                    this.ePu = dataRes.user.is_manager.intValue();
                }
                this.ePx.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.ePA.add(muteUser);
                        }
                    }
                }
                this.bjI.bQ(this.bjI.rn() > 0 ? this.bjI.rn() - 1 : 0);
                List<AppData> blP = q.blR().blP();
                if (blP != null) {
                    blP.clear();
                }
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        com.baidu.tieba.tbadkCore.data.l lVar = new com.baidu.tieba.tbadkCore.data.l();
                        lVar.c(app);
                        AppData bwK = lVar.bwK();
                        if (!this.ePH.contains(lVar) && bwK.goods != null && (!StringUtils.isNull(bwK.goods.user_name) || !StringUtils.isNull(bwK.goods.lego_card))) {
                            this.ePH.add(lVar);
                            if (blP != null) {
                                blP.add(lVar.bwK());
                            }
                        }
                    }
                }
                q.blR().blQ();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.ePx.getIsSelectTail());
                }
                this.ePI.parserProtobuf(dataRes.twzhibo_anti);
                this.ePK = dataRes.appeal_info;
                if (dataRes.god_card != null) {
                    this.ePC = new a();
                    this.ePC.a(dataRes.god_card);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.ePQ = new h();
                    this.ePQ.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.guess_like != null) {
                    this.ePR = new CardHListViewData();
                    this.ePR.parseProtobuf(dataRes.guess_like);
                }
                if (dataRes.feed_thread_list != null && dataRes.feed_thread_list.size() > 0) {
                    List<ThreadInfo> list3 = dataRes.feed_thread_list;
                    if (this.ePE == null) {
                        this.ePE = new ArrayList();
                    }
                    this.ePE.clear();
                    for (ThreadInfo threadInfo : list3) {
                        if (threadInfo != null) {
                            bd bdVar = new bd();
                            bdVar.a(threadInfo);
                            this.ePE.add(bdVar);
                        }
                    }
                    if (this.ePE != null && this.ePE.size() > 15) {
                        this.ePE = v.a(this.ePE, 0, 15);
                    }
                }
                this.ePF = dataRes.is_follow_current_channel.intValue();
                if (v.v(dataRes.repost_recommend_forum_list) > 0) {
                    if (this.ePL == null) {
                        this.ePL = new ArrayList();
                    }
                    for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                        ay ayVar = new ay();
                        ayVar.parserProtobuf(simpleForum);
                        this.ePL.add(ayVar);
                    }
                }
                if (v.v(dataRes.from_forum_list) > 0) {
                    if (this.ePM == null) {
                        this.ePM = new ArrayList();
                    }
                    for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                        ay ayVar2 = new ay();
                        ayVar2.parserProtobuf(simpleForum2);
                        this.ePM.add(ayVar2);
                    }
                }
                if (dataRes.top_agree_post_list != null && this.ePN != null) {
                    this.ePN.a(context, dataRes.top_agree_post_list);
                }
                if (this.ePS >= 0) {
                    this.ePS = dataRes.thread_freq_num.longValue();
                }
                this.ePT = new l();
                this.ePT.a(dataRes);
                this.ePU = dataRes.partial_visible_toast;
                if (dataRes.follow_tip != null && dataRes.follow_tip.is_toast_tip.intValue() == 1) {
                    this.ePv = dataRes.follow_tip.tip_text;
                }
                this.ePG = new AlaLiveInfoCoreData();
                if (dataRes.ala_info != null) {
                    this.ePG.parserProtoBuf(dataRes.ala_info);
                }
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }

    public CardHListViewData aRy() {
        return this.ePR;
    }

    public PostData aRz() {
        return this.ePP;
    }

    public PostData c(PostData postData) {
        this.ePP = postData;
        return postData;
    }

    public n aRA() {
        return this.ePN;
    }

    public int aRB() {
        return this.ePu;
    }

    public int aRC() {
        return this.ePw;
    }

    public void pJ(int i) {
        this.ePw = i;
    }

    public List<MuteUser> aRD() {
        return this.ePA;
    }

    public ArrayList<com.baidu.tieba.tbadkCore.data.l> aRE() {
        return this.ePH;
    }

    public a aRF() {
        return this.ePC;
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> aRG() {
        return new ArrayList<>(this.ePs);
    }

    public String aRH() {
        return this.ePO;
    }

    public void pH(String str) {
        this.ePO = str;
    }

    public h aRI() {
        return this.ePQ;
    }

    public int aRJ() {
        return this.ePF;
    }

    public List<ay> aRK() {
        return this.ePM;
    }

    public long aRL() {
        return this.ePS;
    }

    public l aRM() {
        return this.ePT;
    }

    public void a(l lVar) {
        this.ePT = lVar;
    }

    public boolean aRN() {
        return (aRq() == null || !aRq().si() || aRq().rN() == null) ? false : true;
    }

    public String aRO() {
        return this.ePv;
    }

    public AlaLiveInfoCoreData aRP() {
        return this.ePG;
    }
}

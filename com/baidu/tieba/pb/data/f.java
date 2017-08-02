package com.baidu.tieba.pb.data;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.TwzhiboAnti;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.af;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.au;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.p;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.z;
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
    private int dEB;
    private a eCJ;
    private List<bl> eCL;
    private int eCM;
    private int eCN;
    private TwzhiboAnti eCP;
    private VoteDataInfo eCQ;
    public AppealInfo eCR;
    private List<be> eCS;
    private List<be> eCT;
    public String eCV;
    private PostData eCW;
    private h eCY;
    public CardHListViewData eCZ;
    private long eDa;
    private m eDb;
    public String eDc;
    private PostData eDd;
    private boolean eCI = true;
    private ArrayList<com.baidu.tieba.tbadkCore.data.l> eCO = new ArrayList<>();
    private ForumData eCy = new ForumData();
    private be eCz = new be();
    private bl bbB = new bl();
    private ArrayList<PostData> eCA = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private ar dDg = new ar();
    private AntiData Wq = new AntiData();
    private com.baidu.tbadk.data.h eCB = new com.baidu.tbadk.data.h();
    private int eCD = 0;
    private boolean eCC = false;
    private final UserData eCE = new UserData();
    private List<MuteUser> eCH = new ArrayList();
    private at eCF = new at();
    private au eCK = new au();
    private z eCG = new z();
    private af eCX = new af();
    private o eCU = new o();

    public boolean aOT() {
        return this.eCI;
    }

    public void iN(boolean z) {
        this.eCI = z;
    }

    public af aOU() {
        return this.eCX;
    }

    public VoteDataInfo aOV() {
        return this.eCQ;
    }

    public f() {
        this.dEB = 0;
        this.eCP = null;
        this.dEB = 0;
        this.eCP = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.eCA != null && this.eCA.size() > 0;
    }

    public p rU() {
        if (this.bbB == null) {
            return null;
        }
        return this.bbB.rU();
    }

    public String[] bE(Context context) {
        String str = null;
        String str2 = "";
        if (isValid()) {
            PostData postData = this.eCA.get(0);
            PreLoadImageInfo bsw = postData.bsw();
            str = bsw != null ? bsw.imgUrl : "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            str2 = postData.bP(context);
            if (this.bbB != null && this.bbB.sg() != null && this.bbB.sg().getGroup_id() != 0) {
                str2 = "[" + context.getString(d.l.photo_live_tips) + "] " + str2;
            }
            if (this.bbB != null && this.bbB.si() && postData != null && postData.Iq() != null) {
                str = postData.Iq().getThumbUrl();
            }
        }
        return new String[]{str, str2};
    }

    public ForumData aOW() {
        return this.eCy;
    }

    public be aOX() {
        return this.eCz;
    }

    public String getForumId() {
        if (this.eCy == null) {
            return "";
        }
        return this.eCy.getId();
    }

    public bl aOY() {
        return this.bbB;
    }

    public List<bl> aOZ() {
        return this.eCL;
    }

    public String getThreadId() {
        if (this.bbB == null) {
            return "";
        }
        return this.bbB.getId();
    }

    public ArrayList<PostData> aPa() {
        return this.eCA;
    }

    public ar qx() {
        return this.dDg;
    }

    public z aPb() {
        return this.eCG;
    }

    public au aPc() {
        return this.eCK;
    }

    public TwzhiboAnti aPd() {
        return this.eCP;
    }

    public void a(ar arVar, int i) {
        this.dDg.bH(arVar.qr());
        this.dDg.bF(arVar.ph());
        this.dDg.bE(arVar.qo());
        this.dDg.bI(arVar.qs());
        this.dDg.bG(arVar.qq());
        if (i == 0) {
            this.dDg = arVar;
        } else if (i == 1) {
            this.dDg.bJ(arVar.qt());
        } else if (i == 2) {
            this.dDg.bK(arVar.qu());
        }
    }

    public AntiData qh() {
        return this.Wq;
    }

    public UserData getUserData() {
        return this.eCE;
    }

    public boolean nB() {
        return this.bbB.getIsMarked() != 0;
    }

    public void ac(boolean z) {
        if (this.bbB != null) {
            if (z) {
                this.bbB.setIsMarked(1);
            } else {
                this.bbB.setIsMarked(0);
            }
        }
    }

    public String nA() {
        if (this.bbB != null) {
            return this.bbB.rE();
        }
        return null;
    }

    public void pc(String str) {
        if (this.bbB != null) {
            this.bbB.cG(str);
        }
    }

    public boolean aPe() {
        return (this.bbB == null || this.bbB.rG() == null || this.bbB.rG().size() <= 0 || this.bbB.rG().get(0) == null || !this.bbB.rG().get(0).getIsSenior()) ? false : true;
    }

    public PostData aPf() {
        return this.eDd;
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                com.baidu.tieba.recapp.d.a.bhY().rc(dataRes.asp_shown_info);
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
                mP(dataRes.is_new_url.intValue());
                this.eCy.parserProtobuf(dataRes.forum);
                this.eCz.parserProtobuf(dataRes.display_forum);
                this.bbB.setUserMap(this.userMap);
                this.bbB.a(dataRes.thread);
                this.bbB.bV(2);
                if (rU() != null) {
                    rU().setForumId(com.baidu.adp.lib.g.b.c(this.eCy.getId(), 0L));
                }
                this.eCF.a(dataRes.news_info);
                switch (this.eCF.WI) {
                    case 1:
                        this.eCG.eLw = this.eCF;
                        break;
                    case 2:
                        this.eCG.eLx = this.eCF;
                        break;
                    case 3:
                        this.eCG.eLy = this.eCF;
                        break;
                    default:
                        this.eCG.eLx = this.eCF;
                        break;
                }
                this.eCK.a(dataRes.recommend_book);
                if (this.bbB != null && this.bbB.rj() != null) {
                    this.eCQ = new VoteDataInfo();
                    this.eCQ.parserProtobuf(aOY().rj());
                }
                List<Post> list2 = dataRes.post_list;
                if (list2 != null && list2.size() > 0) {
                    for (Post post : dataRes.post_list) {
                        PostData postData = new PostData();
                        postData.setUserMap(this.userMap);
                        postData.a(post, context);
                        postData.a(aOY().rl());
                        if (postData.bsr() == 1 && this.bbB.sa()) {
                            if (aPe()) {
                                postData.setPostType(0);
                            } else {
                                postData.setPostType(this.bbB.rZ());
                            }
                        } else if (postData.bsr() == 1 && this.bbB != null && this.bbB.sh()) {
                            postData.setPostType(36);
                        } else if (postData.bsr() == 1 && this.bbB.sn()) {
                            postData.setPostType(41);
                        } else if (postData.bsr() == 1 && this.bbB != null && this.bbB.si()) {
                            postData.setPostType(0);
                            postData.Iq();
                            if (this.bbB.rt() == null || this.bbB.rt().size() == 0) {
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
                                postData.g(new TbRichText((Context) TbadkCoreApplication.getInst(), this.bbB.rt(), true));
                            }
                            this.eCW = postData;
                        } else if (postData.bsr() == 1 && this.bbB.so()) {
                            postData.setPostType(48);
                        }
                        this.eCA.add(postData);
                    }
                }
                if (dataRes.first_floor_post != null) {
                    this.eDd = new PostData();
                    this.eDd.setUserMap(this.userMap);
                    this.eDd.a(dataRes.first_floor_post, context);
                }
                this.dDg.a(dataRes.page);
                this.Wq.parserProtobuf(dataRes.anti);
                this.eCB.a(dataRes.location);
                this.eCC = dataRes.has_floor.intValue() == 1;
                if (dataRes.user != null) {
                    this.eCD = dataRes.user.is_manager.intValue();
                }
                this.eCE.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.eCH.add(muteUser);
                        }
                    }
                }
                this.bbB.bP(this.bbB.rn() > 0 ? this.bbB.rn() - 1 : 0);
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        com.baidu.tieba.tbadkCore.data.l lVar = new com.baidu.tieba.tbadkCore.data.l();
                        lVar.c(app);
                        AppData bsg = lVar.bsg();
                        if (!this.eCO.contains(lVar) && bsg.goods != null && (!StringUtils.isNull(bsg.goods.user_name) || !StringUtils.isNull(bsg.goods.lego_card))) {
                            this.eCO.add(lVar);
                        }
                    }
                }
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.eCE.getIsSelectTail());
                }
                this.eCP.parserProtobuf(dataRes.twzhibo_anti);
                this.eCR = dataRes.appeal_info;
                if (this.eCX != null) {
                    this.eCX.setForumId(getForumId());
                    this.eCX.setThreadId(getThreadId());
                    this.eCX.bD(0);
                    if (this.eCD > 0) {
                        this.eCX.bD(2);
                    }
                    if (this.bbB != null && this.bbB.getAuthor() != null) {
                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                        if (!TextUtils.isEmpty(currentAccount) && currentAccount.equals(this.bbB.getAuthor().getUserId())) {
                            this.eCX.bD(1);
                        }
                    }
                    this.eCX.a(dataRes.graffiti_rank_list_info);
                    this.eCX.Wc = this.bbB.Zy;
                }
                if (dataRes.god_card != null) {
                    this.eCJ = new a();
                    this.eCJ.a(dataRes.god_card);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.eCY = new h();
                    this.eCY.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.guess_like != null) {
                    this.eCZ = new CardHListViewData();
                    this.eCZ.parseProtobuf(dataRes.guess_like);
                }
                if (dataRes.feed_thread_list != null && dataRes.feed_thread_list.size() > 0) {
                    List<ThreadInfo> list3 = dataRes.feed_thread_list;
                    if (this.eCL == null) {
                        this.eCL = new ArrayList();
                    }
                    this.eCL.clear();
                    for (ThreadInfo threadInfo : list3) {
                        if (threadInfo != null) {
                            bl blVar = new bl();
                            blVar.a(threadInfo);
                            this.eCL.add(blVar);
                        }
                    }
                    if (this.eCL != null && this.eCL.size() > 15) {
                        this.eCL = u.a(this.eCL, 0, 15);
                    }
                }
                this.eCM = dataRes.is_follow_current_channel.intValue();
                this.eCN = dataRes.switch_read_open.intValue();
                if (u.u(dataRes.repost_recommend_forum_list) > 0) {
                    if (this.eCS == null) {
                        this.eCS = new ArrayList();
                    }
                    for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                        be beVar = new be();
                        beVar.parserProtobuf(simpleForum);
                        this.eCS.add(beVar);
                    }
                }
                if (u.u(dataRes.from_forum_list) > 0) {
                    if (this.eCT == null) {
                        this.eCT = new ArrayList();
                    }
                    for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                        be beVar2 = new be();
                        beVar2.parserProtobuf(simpleForum2);
                        this.eCT.add(beVar2);
                    }
                }
                if (dataRes.top_agree_post_list != null && this.eCU != null) {
                    this.eCU.a(context, dataRes.top_agree_post_list);
                }
                if (this.eDa >= 0) {
                    this.eDa = dataRes.thread_freq_num.longValue();
                }
                this.eDb = new m();
                this.eDb.a(dataRes);
                this.eDc = dataRes.partial_visible_toast;
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }

    public CardHListViewData aPg() {
        return this.eCZ;
    }

    public PostData aPh() {
        return this.eCW;
    }

    public PostData e(PostData postData) {
        this.eCW = postData;
        return postData;
    }

    public o aPi() {
        return this.eCU;
    }

    public int aPj() {
        return this.eCD;
    }

    public int aPk() {
        return this.dEB;
    }

    public void mP(int i) {
        this.dEB = i;
    }

    public List<MuteUser> aPl() {
        return this.eCH;
    }

    public ArrayList<com.baidu.tieba.tbadkCore.data.l> aPm() {
        return this.eCO;
    }

    public a aPn() {
        return this.eCJ;
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> aPo() {
        return new ArrayList<>(this.eCA);
    }

    public String aPp() {
        return this.eCV;
    }

    public void pd(String str) {
        this.eCV = str;
    }

    public h aPq() {
        return this.eCY;
    }

    public int aPr() {
        return this.eCM;
    }

    public boolean aPs() {
        return this.eCN == 1;
    }

    public List<be> aPt() {
        return this.eCT;
    }

    public long aPu() {
        return this.eDa;
    }

    public m aPv() {
        return this.eDb;
    }

    public void a(m mVar) {
        this.eDb = mVar;
    }
}

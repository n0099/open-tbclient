package com.baidu.tieba.pb.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.TwzhiboAnti;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.ap;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.p;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.aa;
import com.baidu.tieba.recapp.r;
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
    private String eGE;
    private int eGF;
    private a eGL;
    private List<bh> eGN;
    private int eGO;
    private TwzhiboAnti eGQ;
    private VoteDataInfo eGR;
    public AppealInfo eGS;
    private List<bc> eGT;
    private List<bc> eGU;
    public String eGW;
    private PostData eGX;
    private h eGY;
    public CardHListViewData eGZ;
    private long eHa;
    private l eHb;
    public String eHc;
    private PostData eHd;
    private boolean eGK = true;
    private ArrayList<com.baidu.tieba.tbadkCore.data.l> eGP = new ArrayList<>();
    private ForumData eGz = new ForumData();
    private bc eGA = new bc();
    private bh bff = new bh();
    private ArrayList<PostData> eGB = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private ap dRO = new ap();
    private AntiData Xe = new AntiData();
    private com.baidu.tbadk.data.i eGC = new com.baidu.tbadk.data.i();
    private int eGD = 0;
    private final UserData eGG = new UserData();
    private List<MuteUser> eGJ = new ArrayList();
    private ar eGH = new ar();
    private as eGM = new as();
    private aa eGI = new aa();
    private n eGV = new n();

    public boolean aPS() {
        return this.eGK;
    }

    public void iC(boolean z) {
        this.eGK = z;
    }

    public VoteDataInfo aPT() {
        return this.eGR;
    }

    public f() {
        this.eGF = 0;
        this.eGQ = null;
        this.eGF = 0;
        this.eGQ = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.eGB != null && this.eGB.size() > 0;
    }

    public p rT() {
        if (this.bff == null) {
            return null;
        }
        return this.bff.rT();
    }

    public String[] bK(Context context) {
        String str = null;
        String str2 = "";
        if (isValid()) {
            PostData postData = this.eGB.get(0);
            PreLoadImageInfo buL = postData.buL();
            str = buL != null ? buL.imgUrl : "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            str2 = postData.bX(context);
            if (this.bff != null && this.bff.sf() != null && this.bff.sf().getGroup_id() != 0) {
                str2 = "[" + context.getString(d.j.photo_live_tips) + "] " + str2;
            }
            if (this.bff != null && this.bff.sh() && postData != null && postData.Jd() != null) {
                str = postData.Jd().getThumbUrl();
            }
        }
        return new String[]{str, str2};
    }

    public ForumData aPU() {
        return this.eGz;
    }

    public bc aPV() {
        return this.eGA;
    }

    public String getForumId() {
        if (this.eGz == null) {
            return "";
        }
        return this.eGz.getId();
    }

    public bh aPW() {
        return this.bff;
    }

    public List<bh> aPX() {
        return this.eGN;
    }

    public String getThreadId() {
        if (this.bff == null) {
            return "";
        }
        return this.bff.getId();
    }

    public ArrayList<PostData> aPY() {
        return this.eGB;
    }

    public ap qv() {
        return this.dRO;
    }

    public aa aPZ() {
        return this.eGI;
    }

    public as aQa() {
        return this.eGM;
    }

    public TwzhiboAnti aQb() {
        return this.eGQ;
    }

    public void a(ap apVar, int i) {
        this.dRO.bI(apVar.qp());
        this.dRO.bG(apVar.pm());
        this.dRO.bF(apVar.qm());
        this.dRO.bJ(apVar.qq());
        this.dRO.bH(apVar.qo());
        if (i == 0) {
            this.dRO = apVar;
        } else if (i == 1) {
            this.dRO.bK(apVar.qr());
        } else if (i == 2) {
            this.dRO.bL(apVar.qs());
        }
    }

    public AntiData qf() {
        return this.Xe;
    }

    public UserData getUserData() {
        return this.eGG;
    }

    public boolean nC() {
        return this.bff.rC() != 0;
    }

    public void ab(boolean z) {
        if (this.bff != null) {
            if (z) {
                this.bff.bU(1);
            } else {
                this.bff.bU(0);
            }
        }
    }

    public String nB() {
        if (this.bff != null) {
            return this.bff.rD();
        }
        return null;
    }

    public void pq(String str) {
        if (this.bff != null) {
            this.bff.cK(str);
        }
    }

    public boolean aQc() {
        return (this.bff == null || this.bff.rF() == null || this.bff.rF().size() <= 0 || this.bff.rF().get(0) == null || !this.bff.rF().get(0).getIsSenior()) ? false : true;
    }

    public PostData aQd() {
        return this.eHd;
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                com.baidu.tieba.recapp.e.a.bjQ().rB(dataRes.asp_shown_info);
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
                pq(dataRes.is_new_url.intValue());
                this.eGz.parserProtobuf(dataRes.forum);
                this.eGA.parserProtobuf(dataRes.display_forum);
                this.bff.setUserMap(this.userMap);
                this.bff.a(dataRes.thread);
                this.bff.bX(2);
                if (rT() != null) {
                    rT().setForumId(com.baidu.adp.lib.g.b.c(this.eGz.getId(), 0L));
                }
                this.eGH.a(dataRes.news_info);
                switch (this.eGH.Xw) {
                    case 1:
                        this.eGI.eQw = this.eGH;
                        break;
                    case 2:
                        this.eGI.eQx = this.eGH;
                        break;
                    case 3:
                        this.eGI.eQy = this.eGH;
                        break;
                    default:
                        this.eGI.eQx = this.eGH;
                        break;
                }
                this.eGM.a(dataRes.recommend_book);
                if (this.bff != null && this.bff.rf() != null) {
                    this.eGR = new VoteDataInfo();
                    this.eGR.parserProtobuf(aPW().rf());
                }
                List<Post> list2 = dataRes.post_list;
                if (list2 != null && list2.size() > 0) {
                    for (Post post : dataRes.post_list) {
                        PostData postData = new PostData();
                        postData.setUserMap(this.userMap);
                        postData.a(post, context);
                        postData.a(aPW().ri());
                        if (postData.buG() == 1 && this.bff.rZ()) {
                            if (aQc()) {
                                postData.setPostType(0);
                            } else {
                                postData.setPostType(this.bff.rY());
                            }
                        } else if (postData.buG() == 1 && this.bff != null && this.bff.sg()) {
                            postData.setPostType(36);
                        } else if (postData.buG() == 1 && this.bff.sn()) {
                            postData.setPostType(41);
                        } else if (postData.buG() == 1 && this.bff != null && this.bff.sh()) {
                            postData.setPostType(0);
                            postData.Jd();
                            if (this.bff.rr() == null || this.bff.rr().size() == 0) {
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
                                postData.g(new TbRichText((Context) TbadkCoreApplication.getInst(), this.bff.rr(), true));
                            }
                            this.eGX = postData;
                        } else if (postData.buG() == 1 && this.bff.so()) {
                            postData.setPostType(48);
                        }
                        this.eGB.add(postData);
                    }
                }
                if (dataRes.first_floor_post != null) {
                    this.eHd = new PostData();
                    this.eHd.setUserMap(this.userMap);
                    this.eHd.a(dataRes.first_floor_post, context);
                }
                this.dRO.a(dataRes.page);
                this.Xe.parserProtobuf(dataRes.anti);
                this.eGC.a(dataRes.location);
                if (dataRes.user != null) {
                    this.eGD = dataRes.user.is_manager.intValue();
                }
                this.eGG.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.eGJ.add(muteUser);
                        }
                    }
                }
                this.bff.bQ(this.bff.rl() > 0 ? this.bff.rl() - 1 : 0);
                List<AppData> bjj = r.bjl().bjj();
                if (bjj != null) {
                    bjj.clear();
                }
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        com.baidu.tieba.tbadkCore.data.l lVar = new com.baidu.tieba.tbadkCore.data.l();
                        lVar.c(app);
                        AppData buv = lVar.buv();
                        if (!this.eGP.contains(lVar) && buv.goods != null && (!StringUtils.isNull(buv.goods.user_name) || !StringUtils.isNull(buv.goods.lego_card))) {
                            this.eGP.add(lVar);
                            if (bjj != null) {
                                bjj.add(lVar.buv());
                            }
                        }
                    }
                }
                r.bjl().bjk();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.eGG.getIsSelectTail());
                }
                this.eGQ.parserProtobuf(dataRes.twzhibo_anti);
                this.eGS = dataRes.appeal_info;
                if (dataRes.god_card != null) {
                    this.eGL = new a();
                    this.eGL.a(dataRes.god_card);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.eGY = new h();
                    this.eGY.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.guess_like != null) {
                    this.eGZ = new CardHListViewData();
                    this.eGZ.parseProtobuf(dataRes.guess_like);
                }
                if (dataRes.feed_thread_list != null && dataRes.feed_thread_list.size() > 0) {
                    List<ThreadInfo> list3 = dataRes.feed_thread_list;
                    if (this.eGN == null) {
                        this.eGN = new ArrayList();
                    }
                    this.eGN.clear();
                    for (ThreadInfo threadInfo : list3) {
                        if (threadInfo != null) {
                            bh bhVar = new bh();
                            bhVar.a(threadInfo);
                            this.eGN.add(bhVar);
                        }
                    }
                    if (this.eGN != null && this.eGN.size() > 15) {
                        this.eGN = v.a(this.eGN, 0, 15);
                    }
                }
                this.eGO = dataRes.is_follow_current_channel.intValue();
                if (v.u(dataRes.repost_recommend_forum_list) > 0) {
                    if (this.eGT == null) {
                        this.eGT = new ArrayList();
                    }
                    for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                        bc bcVar = new bc();
                        bcVar.parserProtobuf(simpleForum);
                        this.eGT.add(bcVar);
                    }
                }
                if (v.u(dataRes.from_forum_list) > 0) {
                    if (this.eGU == null) {
                        this.eGU = new ArrayList();
                    }
                    for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                        bc bcVar2 = new bc();
                        bcVar2.parserProtobuf(simpleForum2);
                        this.eGU.add(bcVar2);
                    }
                }
                if (dataRes.top_agree_post_list != null && this.eGV != null) {
                    this.eGV.a(context, dataRes.top_agree_post_list);
                }
                if (this.eHa >= 0) {
                    this.eHa = dataRes.thread_freq_num.longValue();
                }
                this.eHb = new l();
                this.eHb.a(dataRes);
                this.eHc = dataRes.partial_visible_toast;
                if (dataRes.follow_tip != null && dataRes.follow_tip.is_toast_tip.intValue() == 1) {
                    this.eGE = dataRes.follow_tip.tip_text;
                }
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }

    public CardHListViewData aQe() {
        return this.eGZ;
    }

    public PostData aQf() {
        return this.eGX;
    }

    public PostData c(PostData postData) {
        this.eGX = postData;
        return postData;
    }

    public n aQg() {
        return this.eGV;
    }

    public int aQh() {
        return this.eGD;
    }

    public int aQi() {
        return this.eGF;
    }

    public void pq(int i) {
        this.eGF = i;
    }

    public List<MuteUser> aQj() {
        return this.eGJ;
    }

    public ArrayList<com.baidu.tieba.tbadkCore.data.l> aQk() {
        return this.eGP;
    }

    public a aQl() {
        return this.eGL;
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> aQm() {
        return new ArrayList<>(this.eGB);
    }

    public String aQn() {
        return this.eGW;
    }

    public void pr(String str) {
        this.eGW = str;
    }

    public h aQo() {
        return this.eGY;
    }

    public int aQp() {
        return this.eGO;
    }

    public List<bc> aQq() {
        return this.eGU;
    }

    public long aQr() {
        return this.eHa;
    }

    public l aQs() {
        return this.eHb;
    }

    public void a(l lVar) {
        this.eHb = lVar;
    }

    public boolean aQt() {
        return (aPW() == null || !aPW().sh() || aPW().rL() == null) ? false : true;
    }

    public String aQu() {
        return this.eGE;
    }
}

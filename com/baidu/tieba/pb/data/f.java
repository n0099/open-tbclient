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
    private int dHP;
    private a eFQ;
    private List<bl> eFS;
    private int eFT;
    private int eFU;
    private TwzhiboAnti eFW;
    private VoteDataInfo eFX;
    public AppealInfo eFY;
    private List<be> eFZ;
    private List<be> eGa;
    public String eGc;
    private PostData eGd;
    private h eGf;
    public CardHListViewData eGg;
    private long eGh;
    private m eGi;
    public String eGj;
    private PostData eGk;
    private boolean eFP = true;
    private ArrayList<com.baidu.tieba.tbadkCore.data.l> eFV = new ArrayList<>();
    private ForumData eFF = new ForumData();
    private be eFG = new be();
    private bl bcM = new bl();
    private ArrayList<PostData> eFH = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private ar dGu = new ar();
    private AntiData XO = new AntiData();
    private com.baidu.tbadk.data.h eFI = new com.baidu.tbadk.data.h();
    private int eFK = 0;
    private boolean eFJ = false;
    private final UserData eFL = new UserData();
    private List<MuteUser> eFO = new ArrayList();
    private at eFM = new at();
    private au eFR = new au();
    private z eFN = new z();
    private af eGe = new af();
    private o eGb = new o();

    public boolean aPL() {
        return this.eFP;
    }

    public void iQ(boolean z) {
        this.eFP = z;
    }

    public af aPM() {
        return this.eGe;
    }

    public VoteDataInfo aPN() {
        return this.eFX;
    }

    public f() {
        this.dHP = 0;
        this.eFW = null;
        this.dHP = 0;
        this.eFW = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.eFH != null && this.eFH.size() > 0;
    }

    public p se() {
        if (this.bcM == null) {
            return null;
        }
        return this.bcM.se();
    }

    public String[] bD(Context context) {
        String str = null;
        String str2 = "";
        if (isValid()) {
            PostData postData = this.eFH.get(0);
            PreLoadImageInfo btl = postData.btl();
            str = btl != null ? btl.imgUrl : "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            str2 = postData.bO(context);
            if (this.bcM != null && this.bcM.sq() != null && this.bcM.sq().getGroup_id() != 0) {
                str2 = "[" + context.getString(d.l.photo_live_tips) + "] " + str2;
            }
            if (this.bcM != null && this.bcM.ss() && postData != null && postData.Ix() != null) {
                str = postData.Ix().getThumbUrl();
            }
        }
        return new String[]{str, str2};
    }

    public ForumData aPO() {
        return this.eFF;
    }

    public be aPP() {
        return this.eFG;
    }

    public String getForumId() {
        if (this.eFF == null) {
            return "";
        }
        return this.eFF.getId();
    }

    public bl aPQ() {
        return this.bcM;
    }

    public List<bl> aPR() {
        return this.eFS;
    }

    public String getThreadId() {
        if (this.bcM == null) {
            return "";
        }
        return this.bcM.getId();
    }

    public ArrayList<PostData> aPS() {
        return this.eFH;
    }

    public ar qH() {
        return this.dGu;
    }

    public z aPT() {
        return this.eFN;
    }

    public au aPU() {
        return this.eFR;
    }

    public TwzhiboAnti aPV() {
        return this.eFW;
    }

    public void a(ar arVar, int i) {
        this.dGu.bJ(arVar.qB());
        this.dGu.bH(arVar.pr());
        this.dGu.bG(arVar.qy());
        this.dGu.bK(arVar.qC());
        this.dGu.bI(arVar.qA());
        if (i == 0) {
            this.dGu = arVar;
        } else if (i == 1) {
            this.dGu.bL(arVar.qD());
        } else if (i == 2) {
            this.dGu.bM(arVar.qE());
        }
    }

    public AntiData qr() {
        return this.XO;
    }

    public UserData getUserData() {
        return this.eFL;
    }

    public boolean nL() {
        return this.bcM.getIsMarked() != 0;
    }

    public void ac(boolean z) {
        if (this.bcM != null) {
            if (z) {
                this.bcM.setIsMarked(1);
            } else {
                this.bcM.setIsMarked(0);
            }
        }
    }

    public String nK() {
        if (this.bcM != null) {
            return this.bcM.rO();
        }
        return null;
    }

    public void pk(String str) {
        if (this.bcM != null) {
            this.bcM.cM(str);
        }
    }

    public boolean aPW() {
        return (this.bcM == null || this.bcM.rQ() == null || this.bcM.rQ().size() <= 0 || this.bcM.rQ().get(0) == null || !this.bcM.rQ().get(0).getIsSenior()) ? false : true;
    }

    public PostData aPX() {
        return this.eGk;
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                com.baidu.tieba.recapp.d.a.biO().rj(dataRes.asp_shown_info);
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
                mY(dataRes.is_new_url.intValue());
                this.eFF.parserProtobuf(dataRes.forum);
                this.eFG.parserProtobuf(dataRes.display_forum);
                this.bcM.setUserMap(this.userMap);
                this.bcM.a(dataRes.thread);
                this.bcM.bX(2);
                if (se() != null) {
                    se().setForumId(com.baidu.adp.lib.g.b.d(this.eFF.getId(), 0L));
                }
                this.eFM.a(dataRes.news_info);
                switch (this.eFM.Yg) {
                    case 1:
                        this.eFN.eOD = this.eFM;
                        break;
                    case 2:
                        this.eFN.eOE = this.eFM;
                        break;
                    case 3:
                        this.eFN.eOF = this.eFM;
                        break;
                    default:
                        this.eFN.eOE = this.eFM;
                        break;
                }
                this.eFR.a(dataRes.recommend_book);
                if (this.bcM != null && this.bcM.rt() != null) {
                    this.eFX = new VoteDataInfo();
                    this.eFX.parserProtobuf(aPQ().rt());
                }
                List<Post> list2 = dataRes.post_list;
                if (list2 != null && list2.size() > 0) {
                    for (Post post : dataRes.post_list) {
                        PostData postData = new PostData();
                        postData.setUserMap(this.userMap);
                        postData.a(post, context);
                        postData.a(aPQ().rv());
                        if (postData.btg() == 1 && this.bcM.sk()) {
                            if (aPW()) {
                                postData.setPostType(0);
                            } else {
                                postData.setPostType(this.bcM.sj());
                            }
                        } else if (postData.btg() == 1 && this.bcM != null && this.bcM.sr()) {
                            postData.setPostType(36);
                        } else if (postData.btg() == 1 && this.bcM.sx()) {
                            postData.setPostType(41);
                        } else if (postData.btg() == 1 && this.bcM != null && this.bcM.ss()) {
                            postData.setPostType(0);
                            postData.Ix();
                            if (this.bcM.rD() == null || this.bcM.rD().size() == 0) {
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
                                postData.g(new TbRichText((Context) TbadkCoreApplication.getInst(), this.bcM.rD(), true));
                            }
                            this.eGd = postData;
                        } else if (postData.btg() == 1 && this.bcM.sy()) {
                            postData.setPostType(48);
                        }
                        this.eFH.add(postData);
                    }
                }
                if (dataRes.first_floor_post != null) {
                    this.eGk = new PostData();
                    this.eGk.setUserMap(this.userMap);
                    this.eGk.a(dataRes.first_floor_post, context);
                }
                this.dGu.a(dataRes.page);
                this.XO.parserProtobuf(dataRes.anti);
                this.eFI.a(dataRes.location);
                this.eFJ = dataRes.has_floor.intValue() == 1;
                if (dataRes.user != null) {
                    this.eFK = dataRes.user.is_manager.intValue();
                }
                this.eFL.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.eFO.add(muteUser);
                        }
                    }
                }
                this.bcM.bR(this.bcM.rx() > 0 ? this.bcM.rx() - 1 : 0);
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        com.baidu.tieba.tbadkCore.data.l lVar = new com.baidu.tieba.tbadkCore.data.l();
                        lVar.c(app);
                        AppData bsV = lVar.bsV();
                        if (!this.eFV.contains(lVar) && bsV.goods != null && (!StringUtils.isNull(bsV.goods.user_name) || !StringUtils.isNull(bsV.goods.lego_card))) {
                            this.eFV.add(lVar);
                        }
                    }
                }
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.eFL.getIsSelectTail());
                }
                this.eFW.parserProtobuf(dataRes.twzhibo_anti);
                this.eFY = dataRes.appeal_info;
                if (this.eGe != null) {
                    this.eGe.setForumId(getForumId());
                    this.eGe.setThreadId(getThreadId());
                    this.eGe.bF(0);
                    if (this.eFK > 0) {
                        this.eGe.bF(2);
                    }
                    if (this.bcM != null && this.bcM.getAuthor() != null) {
                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                        if (!TextUtils.isEmpty(currentAccount) && currentAccount.equals(this.bcM.getAuthor().getUserId())) {
                            this.eGe.bF(1);
                        }
                    }
                    this.eGe.a(dataRes.graffiti_rank_list_info);
                    this.eGe.XA = this.bcM.aaW;
                }
                if (dataRes.god_card != null) {
                    this.eFQ = new a();
                    this.eFQ.a(dataRes.god_card);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.eGf = new h();
                    this.eGf.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.guess_like != null) {
                    this.eGg = new CardHListViewData();
                    this.eGg.parseProtobuf(dataRes.guess_like);
                }
                if (dataRes.feed_thread_list != null && dataRes.feed_thread_list.size() > 0) {
                    List<ThreadInfo> list3 = dataRes.feed_thread_list;
                    if (this.eFS == null) {
                        this.eFS = new ArrayList();
                    }
                    this.eFS.clear();
                    for (ThreadInfo threadInfo : list3) {
                        if (threadInfo != null) {
                            bl blVar = new bl();
                            blVar.a(threadInfo);
                            this.eFS.add(blVar);
                        }
                    }
                    if (this.eFS != null && this.eFS.size() > 15) {
                        this.eFS = u.a(this.eFS, 0, 15);
                    }
                }
                this.eFT = dataRes.is_follow_current_channel.intValue();
                this.eFU = dataRes.switch_read_open.intValue();
                if (u.u(dataRes.repost_recommend_forum_list) > 0) {
                    if (this.eFZ == null) {
                        this.eFZ = new ArrayList();
                    }
                    for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                        be beVar = new be();
                        beVar.parserProtobuf(simpleForum);
                        this.eFZ.add(beVar);
                    }
                }
                if (u.u(dataRes.from_forum_list) > 0) {
                    if (this.eGa == null) {
                        this.eGa = new ArrayList();
                    }
                    for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                        be beVar2 = new be();
                        beVar2.parserProtobuf(simpleForum2);
                        this.eGa.add(beVar2);
                    }
                }
                if (dataRes.top_agree_post_list != null && this.eGb != null) {
                    this.eGb.a(context, dataRes.top_agree_post_list);
                }
                if (this.eGh >= 0) {
                    this.eGh = dataRes.thread_freq_num.longValue();
                }
                this.eGi = new m();
                this.eGi.a(dataRes);
                this.eGj = dataRes.partial_visible_toast;
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }

    public CardHListViewData aPY() {
        return this.eGg;
    }

    public PostData aPZ() {
        return this.eGd;
    }

    public PostData e(PostData postData) {
        this.eGd = postData;
        return postData;
    }

    public o aQa() {
        return this.eGb;
    }

    public int aQb() {
        return this.eFK;
    }

    public int aQc() {
        return this.dHP;
    }

    public void mY(int i) {
        this.dHP = i;
    }

    public List<MuteUser> aQd() {
        return this.eFO;
    }

    public ArrayList<com.baidu.tieba.tbadkCore.data.l> aQe() {
        return this.eFV;
    }

    public a aQf() {
        return this.eFQ;
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> aQg() {
        return new ArrayList<>(this.eFH);
    }

    public String aQh() {
        return this.eGc;
    }

    public void pl(String str) {
        this.eGc = str;
    }

    public h aQi() {
        return this.eGf;
    }

    public int aQj() {
        return this.eFT;
    }

    public boolean aQk() {
        return this.eFU == 1;
    }

    public List<be> aQl() {
        return this.eGa;
    }

    public long aQm() {
        return this.eGh;
    }

    public m aQn() {
        return this.eGi;
    }

    public void a(m mVar) {
        this.eGi = mVar;
    }
}

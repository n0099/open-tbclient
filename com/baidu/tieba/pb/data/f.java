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
    private a eFS;
    private List<bl> eFU;
    private int eFV;
    private int eFW;
    private TwzhiboAnti eFY;
    private VoteDataInfo eFZ;
    public AppealInfo eGa;
    private List<be> eGb;
    private List<be> eGc;
    public String eGe;
    private PostData eGf;
    private h eGh;
    public CardHListViewData eGi;
    private long eGj;
    private m eGk;
    public String eGl;
    private PostData eGm;
    private boolean eFR = true;
    private ArrayList<com.baidu.tieba.tbadkCore.data.l> eFX = new ArrayList<>();
    private ForumData eFH = new ForumData();
    private be eFI = new be();
    private bl bcN = new bl();
    private ArrayList<PostData> eFJ = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private ar dGu = new ar();
    private AntiData XP = new AntiData();
    private com.baidu.tbadk.data.h eFK = new com.baidu.tbadk.data.h();
    private int eFM = 0;
    private boolean eFL = false;
    private final UserData eFN = new UserData();
    private List<MuteUser> eFQ = new ArrayList();
    private at eFO = new at();
    private au eFT = new au();
    private z eFP = new z();
    private af eGg = new af();
    private o eGd = new o();

    public boolean aPG() {
        return this.eFR;
    }

    public void iQ(boolean z) {
        this.eFR = z;
    }

    public af aPH() {
        return this.eGg;
    }

    public VoteDataInfo aPI() {
        return this.eFZ;
    }

    public f() {
        this.dHP = 0;
        this.eFY = null;
        this.dHP = 0;
        this.eFY = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.eFJ != null && this.eFJ.size() > 0;
    }

    public p sf() {
        if (this.bcN == null) {
            return null;
        }
        return this.bcN.sf();
    }

    public String[] bD(Context context) {
        String str = null;
        String str2 = "";
        if (isValid()) {
            PostData postData = this.eFJ.get(0);
            PreLoadImageInfo bte = postData.bte();
            str = bte != null ? bte.imgUrl : "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            str2 = postData.bO(context);
            if (this.bcN != null && this.bcN.sr() != null && this.bcN.sr().getGroup_id() != 0) {
                str2 = "[" + context.getString(d.l.photo_live_tips) + "] " + str2;
            }
            if (this.bcN != null && this.bcN.st() && postData != null && postData.Ix() != null) {
                str = postData.Ix().getThumbUrl();
            }
        }
        return new String[]{str, str2};
    }

    public ForumData aPJ() {
        return this.eFH;
    }

    public be aPK() {
        return this.eFI;
    }

    public String getForumId() {
        if (this.eFH == null) {
            return "";
        }
        return this.eFH.getId();
    }

    public bl aPL() {
        return this.bcN;
    }

    public List<bl> aPM() {
        return this.eFU;
    }

    public String getThreadId() {
        if (this.bcN == null) {
            return "";
        }
        return this.bcN.getId();
    }

    public ArrayList<PostData> aPN() {
        return this.eFJ;
    }

    public ar qI() {
        return this.dGu;
    }

    public z aPO() {
        return this.eFP;
    }

    public au aPP() {
        return this.eFT;
    }

    public TwzhiboAnti aPQ() {
        return this.eFY;
    }

    public void a(ar arVar, int i) {
        this.dGu.bJ(arVar.qC());
        this.dGu.bH(arVar.ps());
        this.dGu.bG(arVar.qz());
        this.dGu.bK(arVar.qD());
        this.dGu.bI(arVar.qB());
        if (i == 0) {
            this.dGu = arVar;
        } else if (i == 1) {
            this.dGu.bL(arVar.qE());
        } else if (i == 2) {
            this.dGu.bM(arVar.qF());
        }
    }

    public AntiData qs() {
        return this.XP;
    }

    public UserData getUserData() {
        return this.eFN;
    }

    public boolean nM() {
        return this.bcN.getIsMarked() != 0;
    }

    public void ac(boolean z) {
        if (this.bcN != null) {
            if (z) {
                this.bcN.setIsMarked(1);
            } else {
                this.bcN.setIsMarked(0);
            }
        }
    }

    public String nL() {
        if (this.bcN != null) {
            return this.bcN.rP();
        }
        return null;
    }

    public void pp(String str) {
        if (this.bcN != null) {
            this.bcN.cP(str);
        }
    }

    public boolean aPR() {
        return (this.bcN == null || this.bcN.rR() == null || this.bcN.rR().size() <= 0 || this.bcN.rR().get(0) == null || !this.bcN.rR().get(0).getIsSenior()) ? false : true;
    }

    public PostData aPS() {
        return this.eGm;
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                com.baidu.tieba.recapp.d.a.biJ().ro(dataRes.asp_shown_info);
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
                this.eFH.parserProtobuf(dataRes.forum);
                this.eFI.parserProtobuf(dataRes.display_forum);
                this.bcN.setUserMap(this.userMap);
                this.bcN.a(dataRes.thread);
                this.bcN.bX(2);
                if (sf() != null) {
                    sf().setForumId(com.baidu.adp.lib.g.b.d(this.eFH.getId(), 0L));
                }
                this.eFO.a(dataRes.news_info);
                switch (this.eFO.Yh) {
                    case 1:
                        this.eFP.eOF = this.eFO;
                        break;
                    case 2:
                        this.eFP.eOG = this.eFO;
                        break;
                    case 3:
                        this.eFP.eOH = this.eFO;
                        break;
                    default:
                        this.eFP.eOG = this.eFO;
                        break;
                }
                this.eFT.a(dataRes.recommend_book);
                if (this.bcN != null && this.bcN.ru() != null) {
                    this.eFZ = new VoteDataInfo();
                    this.eFZ.parserProtobuf(aPL().ru());
                }
                List<Post> list2 = dataRes.post_list;
                if (list2 != null && list2.size() > 0) {
                    for (Post post : dataRes.post_list) {
                        PostData postData = new PostData();
                        postData.setUserMap(this.userMap);
                        postData.a(post, context);
                        postData.a(aPL().rw());
                        if (postData.bsZ() == 1 && this.bcN.sl()) {
                            if (aPR()) {
                                postData.setPostType(0);
                            } else {
                                postData.setPostType(this.bcN.sk());
                            }
                        } else if (postData.bsZ() == 1 && this.bcN != null && this.bcN.ss()) {
                            postData.setPostType(36);
                        } else if (postData.bsZ() == 1 && this.bcN.sy()) {
                            postData.setPostType(41);
                        } else if (postData.bsZ() == 1 && this.bcN != null && this.bcN.st()) {
                            postData.setPostType(0);
                            postData.Ix();
                            if (this.bcN.rE() == null || this.bcN.rE().size() == 0) {
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
                                postData.g(new TbRichText((Context) TbadkCoreApplication.getInst(), this.bcN.rE(), true));
                            }
                            this.eGf = postData;
                        } else if (postData.bsZ() == 1 && this.bcN.sz()) {
                            postData.setPostType(48);
                        }
                        this.eFJ.add(postData);
                    }
                }
                if (dataRes.first_floor_post != null) {
                    this.eGm = new PostData();
                    this.eGm.setUserMap(this.userMap);
                    this.eGm.a(dataRes.first_floor_post, context);
                }
                this.dGu.a(dataRes.page);
                this.XP.parserProtobuf(dataRes.anti);
                this.eFK.a(dataRes.location);
                this.eFL = dataRes.has_floor.intValue() == 1;
                if (dataRes.user != null) {
                    this.eFM = dataRes.user.is_manager.intValue();
                }
                this.eFN.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.eFQ.add(muteUser);
                        }
                    }
                }
                this.bcN.bR(this.bcN.ry() > 0 ? this.bcN.ry() - 1 : 0);
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        com.baidu.tieba.tbadkCore.data.l lVar = new com.baidu.tieba.tbadkCore.data.l();
                        lVar.c(app);
                        AppData bsO = lVar.bsO();
                        if (!this.eFX.contains(lVar) && bsO.goods != null && (!StringUtils.isNull(bsO.goods.user_name) || !StringUtils.isNull(bsO.goods.lego_card))) {
                            this.eFX.add(lVar);
                        }
                    }
                }
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.eFN.getIsSelectTail());
                }
                this.eFY.parserProtobuf(dataRes.twzhibo_anti);
                this.eGa = dataRes.appeal_info;
                if (this.eGg != null) {
                    this.eGg.setForumId(getForumId());
                    this.eGg.setThreadId(getThreadId());
                    this.eGg.bF(0);
                    if (this.eFM > 0) {
                        this.eGg.bF(2);
                    }
                    if (this.bcN != null && this.bcN.getAuthor() != null) {
                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                        if (!TextUtils.isEmpty(currentAccount) && currentAccount.equals(this.bcN.getAuthor().getUserId())) {
                            this.eGg.bF(1);
                        }
                    }
                    this.eGg.a(dataRes.graffiti_rank_list_info);
                    this.eGg.XB = this.bcN.aaW;
                }
                if (dataRes.god_card != null) {
                    this.eFS = new a();
                    this.eFS.a(dataRes.god_card);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.eGh = new h();
                    this.eGh.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.guess_like != null) {
                    this.eGi = new CardHListViewData();
                    this.eGi.parseProtobuf(dataRes.guess_like);
                }
                if (dataRes.feed_thread_list != null && dataRes.feed_thread_list.size() > 0) {
                    List<ThreadInfo> list3 = dataRes.feed_thread_list;
                    if (this.eFU == null) {
                        this.eFU = new ArrayList();
                    }
                    this.eFU.clear();
                    for (ThreadInfo threadInfo : list3) {
                        if (threadInfo != null) {
                            bl blVar = new bl();
                            blVar.a(threadInfo);
                            this.eFU.add(blVar);
                        }
                    }
                    if (this.eFU != null && this.eFU.size() > 15) {
                        this.eFU = u.a(this.eFU, 0, 15);
                    }
                }
                this.eFV = dataRes.is_follow_current_channel.intValue();
                this.eFW = dataRes.switch_read_open.intValue();
                if (u.u(dataRes.repost_recommend_forum_list) > 0) {
                    if (this.eGb == null) {
                        this.eGb = new ArrayList();
                    }
                    for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                        be beVar = new be();
                        beVar.parserProtobuf(simpleForum);
                        this.eGb.add(beVar);
                    }
                }
                if (u.u(dataRes.from_forum_list) > 0) {
                    if (this.eGc == null) {
                        this.eGc = new ArrayList();
                    }
                    for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                        be beVar2 = new be();
                        beVar2.parserProtobuf(simpleForum2);
                        this.eGc.add(beVar2);
                    }
                }
                if (dataRes.top_agree_post_list != null && this.eGd != null) {
                    this.eGd.a(context, dataRes.top_agree_post_list);
                }
                if (this.eGj >= 0) {
                    this.eGj = dataRes.thread_freq_num.longValue();
                }
                this.eGk = new m();
                this.eGk.a(dataRes);
                this.eGl = dataRes.partial_visible_toast;
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }

    public CardHListViewData aPT() {
        return this.eGi;
    }

    public PostData aPU() {
        return this.eGf;
    }

    public PostData e(PostData postData) {
        this.eGf = postData;
        return postData;
    }

    public o aPV() {
        return this.eGd;
    }

    public int aPW() {
        return this.eFM;
    }

    public int aPX() {
        return this.dHP;
    }

    public void mY(int i) {
        this.dHP = i;
    }

    public List<MuteUser> aPY() {
        return this.eFQ;
    }

    public ArrayList<com.baidu.tieba.tbadkCore.data.l> aPZ() {
        return this.eFX;
    }

    public a aQa() {
        return this.eFS;
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> aQb() {
        return new ArrayList<>(this.eFJ);
    }

    public String aQc() {
        return this.eGe;
    }

    public void pq(String str) {
        this.eGe = str;
    }

    public h aQd() {
        return this.eGh;
    }

    public int aQe() {
        return this.eFV;
    }

    public boolean aQf() {
        return this.eFW == 1;
    }

    public List<be> aQg() {
        return this.eGc;
    }

    public long aQh() {
        return this.eGj;
    }

    public m aQi() {
        return this.eGk;
    }

    public void a(m mVar) {
        this.eGk = mVar;
    }
}

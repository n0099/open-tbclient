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
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.p;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.pb.pb.main.dw;
import com.baidu.tieba.tbadkCore.data.AppData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.data.o;
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
import tbclient.SimpleUser;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes.dex */
public class f {
    private int dnQ;
    private PostData ehL;
    private a ehV;
    private List<bj> ehX;
    private int ehY;
    private int ehZ;
    private TwzhiboAnti eib;
    private VoteDataInfo eic;
    public AppealInfo eid;
    public String eie;
    private PostData eif;
    private h eih;
    public CardHListViewData eii;
    private boolean ehU = true;
    private ArrayList<o> eia = new ArrayList<>();
    private ForumData ehK = new ForumData();
    private bj bbv = new bj();
    private ArrayList<PostData> ehM = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private aq dms = new aq();
    private AntiData Wx = new AntiData();
    private com.baidu.tbadk.data.g ehN = new com.baidu.tbadk.data.g();
    private int ehP = 0;
    private boolean ehO = false;
    private final UserData ehQ = new UserData();
    private List<MuteUser> ehT = new ArrayList();
    private as ehR = new as();
    private at ehW = new at();
    private dw ehS = new dw();
    private ag eig = new ag();

    public boolean aJm() {
        return this.ehU;
    }

    public void ia(boolean z) {
        this.ehU = z;
    }

    public ag aJn() {
        return this.eig;
    }

    public VoteDataInfo aJo() {
        return this.eic;
    }

    public f() {
        this.dnQ = 0;
        this.eib = null;
        this.dnQ = 0;
        this.eib = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.ehM != null && this.ehM.size() > 0;
    }

    public p sp() {
        if (this.bbv == null) {
            return null;
        }
        return this.bbv.sp();
    }

    public String[] bK(Context context) {
        String str = null;
        String str2 = "";
        if (isValid()) {
            PostData postData = this.ehM.get(0);
            PreLoadImageInfo bhI = postData.bhI();
            str = bhI != null ? bhI.imgUrl : "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            str2 = postData.bT(context);
            if (this.bbv != null && this.bbv.sB() != null && this.bbv.sB().getGroup_id() != 0) {
                str2 = "[" + context.getString(w.l.msglist_live) + "] " + str2;
            }
            if (this.bbv != null && this.bbv.sD() && postData != null && postData.HZ() != null) {
                str = postData.HZ().qs();
            }
        }
        return new String[]{str, str2};
    }

    public ForumData aJp() {
        return this.ehK;
    }

    public String getForumId() {
        if (this.ehK == null) {
            return "";
        }
        return this.ehK.getId();
    }

    public bj aJq() {
        return this.bbv;
    }

    public List<bj> aJr() {
        return this.ehX;
    }

    public String getThreadId() {
        if (this.bbv == null) {
            return "";
        }
        return this.bbv.getId();
    }

    public ArrayList<PostData> aJs() {
        return this.ehM;
    }

    public aq getPage() {
        return this.dms;
    }

    public dw aJt() {
        return this.ehS;
    }

    public at aJu() {
        return this.ehW;
    }

    public TwzhiboAnti aJv() {
        return this.eib;
    }

    public void a(aq aqVar, int i) {
        this.dms.bH(aqVar.qO());
        this.dms.bF(aqVar.pk());
        this.dms.bE(aqVar.qL());
        this.dms.bI(aqVar.qP());
        this.dms.bG(aqVar.qN());
        if (i == 0) {
            this.dms = aqVar;
        } else if (i == 1) {
            this.dms.bJ(aqVar.qQ());
        } else if (i == 2) {
            this.dms.bK(aqVar.qR());
        }
    }

    public AntiData qE() {
        return this.Wx;
    }

    public UserData getUserData() {
        return this.ehQ;
    }

    public boolean nH() {
        return this.bbv.getIsMarked() != 0;
    }

    public void ac(boolean z) {
        if (this.bbv != null) {
            if (z) {
                this.bbv.setIsMarked(1);
            } else {
                this.bbv.setIsMarked(0);
            }
        }
    }

    public String nG() {
        if (this.bbv != null) {
            return this.bbv.rZ();
        }
        return null;
    }

    public void nl(String str) {
        if (this.bbv != null) {
            this.bbv.cr(str);
        }
    }

    public PostData aJw() {
        return this.ehL;
    }

    public boolean aJx() {
        return (this.bbv == null || this.bbv.sb() == null || this.bbv.sb().size() <= 0 || this.bbv.sb().get(0) == null || !this.bbv.sb().get(0).getIsSenior()) ? false : true;
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                com.baidu.tieba.recapp.c.a.aZL().pd(dataRes.asp_shown_info);
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
                mh(dataRes.is_new_url.intValue());
                this.ehK.parserProtobuf(dataRes.forum);
                this.bbv.setUserMap(this.userMap);
                this.bbv.a(dataRes.thread);
                this.bbv.bU(2);
                if (sp() != null) {
                    sp().setForumId(com.baidu.adp.lib.g.b.c(this.ehK.getId(), 0L));
                }
                this.ehR.a(dataRes.news_info);
                switch (this.ehR.WP) {
                    case 1:
                        this.ehS.eoR = this.ehR;
                        break;
                    case 2:
                        this.ehS.eoS = this.ehR;
                        break;
                    case 3:
                        this.ehS.eoT = this.ehR;
                        break;
                    default:
                        this.ehS.eoS = this.ehR;
                        break;
                }
                this.ehW.a(dataRes.recommend_book);
                if (this.bbv != null && this.bbv.rF() != null) {
                    this.eic = new VoteDataInfo();
                    this.eic.parserProtobuf(aJq().rF());
                }
                List<Post> list2 = dataRes.post_list;
                if (list2 != null && list2.size() > 0) {
                    for (Post post : dataRes.post_list) {
                        PostData postData = new PostData();
                        postData.setUserMap(this.userMap);
                        postData.a(post, context);
                        postData.a(aJq().rG());
                        if (postData.bhD() == 1 && this.bbv.sv()) {
                            if (aJx()) {
                                postData.setPostType(0);
                            } else {
                                postData.setPostType(this.bbv.su());
                            }
                        } else if (postData.bhD() == 1 && this.bbv != null && this.bbv.sC()) {
                            postData.setPostType(36);
                        } else if (postData.bhD() == 1 && this.bbv.sI()) {
                            postData.setPostType(41);
                        } else if (postData.bhD() == 1 && this.bbv != null && this.bbv.sD()) {
                            postData.setPostType(0);
                            postData.HZ();
                            if (this.bbv.rP() == null || this.bbv.rP().size() == 0) {
                                JSONArray jSONArray = new JSONArray();
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("type", 0);
                                    jSONObject.put("text", postData.getTitle());
                                    jSONArray.put(jSONObject);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                postData.f(TbRichTextView.a(context, jSONArray, false));
                            } else {
                                postData.f(new TbRichText((Context) TbadkCoreApplication.m9getInst(), this.bbv.rP(), true));
                            }
                            this.eif = postData;
                        } else if (postData.bhD() == 1 && this.bbv.sJ()) {
                            postData.setPostType(48);
                        }
                        this.ehM.add(postData);
                    }
                }
                this.dms.a(dataRes.page);
                this.Wx.parserProtobuf(dataRes.anti);
                this.ehN.a(dataRes.location);
                this.ehO = dataRes.has_floor.intValue() == 1;
                if (dataRes.user != null) {
                    this.ehP = dataRes.user.is_manager.intValue();
                }
                this.ehQ.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.ehT.add(muteUser);
                        }
                    }
                }
                this.bbv.bP(this.bbv.rJ() > 0 ? this.bbv.rJ() - 1 : 0);
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        o oVar = new o();
                        oVar.c(app);
                        AppData bhr = oVar.bhr();
                        if (!this.eia.contains(oVar) && bhr.goods != null && (!StringUtils.isNull(bhr.goods.user_name) || !StringUtils.isNull(bhr.goods.lego_card))) {
                            this.eia.add(oVar);
                        }
                    }
                }
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.ehQ.getIsSelectTail());
                }
                this.eib.parserProtobuf(dataRes.twzhibo_anti);
                this.eid = dataRes.appeal_info;
                if (this.eig != null) {
                    this.eig.setForumId(getForumId());
                    this.eig.setThreadId(getThreadId());
                    this.eig.bD(0);
                    if (this.ehP > 0) {
                        this.eig.bD(2);
                    }
                    if (this.bbv != null && this.bbv.getAuthor() != null) {
                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                        if (!TextUtils.isEmpty(currentAccount) && currentAccount.equals(this.bbv.getAuthor().getUserId())) {
                            this.eig.bD(1);
                        }
                    }
                    this.eig.a(dataRes.graffiti_rank_list_info);
                }
                if (dataRes.god_card != null) {
                    this.ehV = new a();
                    this.ehV.a(dataRes.god_card);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.eih = new h();
                    this.eih.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.guess_like != null) {
                    this.eii = new CardHListViewData();
                    this.eii.parseProtobuf(dataRes.guess_like);
                }
                if (dataRes.feed_thread_list != null && dataRes.feed_thread_list.size() > 0) {
                    List<ThreadInfo> list3 = dataRes.feed_thread_list;
                    if (this.ehX == null) {
                        this.ehX = new ArrayList();
                    }
                    this.ehX.clear();
                    for (ThreadInfo threadInfo : list3) {
                        if (threadInfo != null) {
                            bj bjVar = new bj();
                            bjVar.a(threadInfo);
                            this.ehX.add(bjVar);
                        }
                    }
                    if (this.ehX != null && this.ehX.size() > 15) {
                        this.ehX = x.a(this.ehX, 0, 15);
                    }
                }
                this.ehY = dataRes.is_follow_current_channel.intValue();
                this.ehZ = dataRes.switch_read_open.intValue();
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }

    public CardHListViewData aJy() {
        return this.eii;
    }

    public PostData aJz() {
        return this.eif;
    }

    public PostData a(PostData postData) {
        this.eif = postData;
        return postData;
    }

    public int aJA() {
        return this.ehP;
    }

    public int aJB() {
        return this.dnQ;
    }

    public void mh(int i) {
        this.dnQ = i;
    }

    public List<MuteUser> aJC() {
        return this.ehT;
    }

    public ArrayList<o> aJD() {
        return this.eia;
    }

    public a aJE() {
        return this.ehV;
    }

    public ArrayList<v> aJF() {
        return new ArrayList<>(this.ehM);
    }

    public String aJG() {
        return this.eie;
    }

    public void nm(String str) {
        this.eie = str;
    }

    public h aJH() {
        return this.eih;
    }

    public int aJI() {
        return this.ehY;
    }

    public boolean aJJ() {
        return this.ehZ == 1;
    }
}

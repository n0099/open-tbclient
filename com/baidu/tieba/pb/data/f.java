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
    private List<bc> eGA;
    public String eGC;
    private PostData eGD;
    private h eGE;
    public CardHListViewData eGF;
    private long eGG;
    private l eGH;
    public String eGI;
    private PostData eGJ;
    private String eGk;
    private int eGl;
    private a eGr;
    private List<bh> eGt;
    private int eGu;
    private TwzhiboAnti eGw;
    private VoteDataInfo eGx;
    public AppealInfo eGy;
    private List<bc> eGz;
    private boolean eGq = true;
    private ArrayList<com.baidu.tieba.tbadkCore.data.l> eGv = new ArrayList<>();
    private ForumData eGf = new ForumData();
    private bc eGg = new bc();
    private bh beV = new bh();
    private ArrayList<PostData> eGh = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private ap dRK = new ap();
    private AntiData Xe = new AntiData();
    private com.baidu.tbadk.data.i eGi = new com.baidu.tbadk.data.i();
    private int eGj = 0;
    private final UserData eGm = new UserData();
    private List<MuteUser> eGp = new ArrayList();
    private ar eGn = new ar();
    private as eGs = new as();
    private aa eGo = new aa();
    private n eGB = new n();

    public boolean aPK() {
        return this.eGq;
    }

    public void iw(boolean z) {
        this.eGq = z;
    }

    public VoteDataInfo aPL() {
        return this.eGx;
    }

    public f() {
        this.eGl = 0;
        this.eGw = null;
        this.eGl = 0;
        this.eGw = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.eGh != null && this.eGh.size() > 0;
    }

    public p rT() {
        if (this.beV == null) {
            return null;
        }
        return this.beV.rT();
    }

    public String[] bK(Context context) {
        String str = null;
        String str2 = "";
        if (isValid()) {
            PostData postData = this.eGh.get(0);
            PreLoadImageInfo buz = postData.buz();
            str = buz != null ? buz.imgUrl : "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            str2 = postData.bX(context);
            if (this.beV != null && this.beV.sf() != null && this.beV.sf().getGroup_id() != 0) {
                str2 = "[" + context.getString(d.j.photo_live_tips) + "] " + str2;
            }
            if (this.beV != null && this.beV.sh() && postData != null && postData.IS() != null) {
                str = postData.IS().getThumbUrl();
            }
        }
        return new String[]{str, str2};
    }

    public ForumData aPM() {
        return this.eGf;
    }

    public bc aPN() {
        return this.eGg;
    }

    public String getForumId() {
        if (this.eGf == null) {
            return "";
        }
        return this.eGf.getId();
    }

    public bh aPO() {
        return this.beV;
    }

    public List<bh> aPP() {
        return this.eGt;
    }

    public String getThreadId() {
        if (this.beV == null) {
            return "";
        }
        return this.beV.getId();
    }

    public ArrayList<PostData> aPQ() {
        return this.eGh;
    }

    public ap qv() {
        return this.dRK;
    }

    public aa aPR() {
        return this.eGo;
    }

    public as aPS() {
        return this.eGs;
    }

    public TwzhiboAnti aPT() {
        return this.eGw;
    }

    public void a(ap apVar, int i) {
        this.dRK.bI(apVar.qp());
        this.dRK.bG(apVar.pm());
        this.dRK.bF(apVar.qm());
        this.dRK.bJ(apVar.qq());
        this.dRK.bH(apVar.qo());
        if (i == 0) {
            this.dRK = apVar;
        } else if (i == 1) {
            this.dRK.bK(apVar.qr());
        } else if (i == 2) {
            this.dRK.bL(apVar.qs());
        }
    }

    public AntiData qf() {
        return this.Xe;
    }

    public UserData getUserData() {
        return this.eGm;
    }

    public boolean nC() {
        return this.beV.rC() != 0;
    }

    public void ab(boolean z) {
        if (this.beV != null) {
            if (z) {
                this.beV.bU(1);
            } else {
                this.beV.bU(0);
            }
        }
    }

    public String nB() {
        if (this.beV != null) {
            return this.beV.rD();
        }
        return null;
    }

    public void pm(String str) {
        if (this.beV != null) {
            this.beV.cK(str);
        }
    }

    public boolean aPU() {
        return (this.beV == null || this.beV.rF() == null || this.beV.rF().size() <= 0 || this.beV.rF().get(0) == null || !this.beV.rF().get(0).getIsSenior()) ? false : true;
    }

    public PostData aPV() {
        return this.eGJ;
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                com.baidu.tieba.recapp.e.a.bjF().ru(dataRes.asp_shown_info);
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
                pp(dataRes.is_new_url.intValue());
                this.eGf.parserProtobuf(dataRes.forum);
                this.eGg.parserProtobuf(dataRes.display_forum);
                this.beV.setUserMap(this.userMap);
                this.beV.a(dataRes.thread);
                this.beV.bX(2);
                if (rT() != null) {
                    rT().setForumId(com.baidu.adp.lib.g.b.c(this.eGf.getId(), 0L));
                }
                this.eGn.a(dataRes.news_info);
                switch (this.eGn.Xw) {
                    case 1:
                        this.eGo.eQc = this.eGn;
                        break;
                    case 2:
                        this.eGo.eQd = this.eGn;
                        break;
                    case 3:
                        this.eGo.eQe = this.eGn;
                        break;
                    default:
                        this.eGo.eQd = this.eGn;
                        break;
                }
                this.eGs.a(dataRes.recommend_book);
                if (this.beV != null && this.beV.rf() != null) {
                    this.eGx = new VoteDataInfo();
                    this.eGx.parserProtobuf(aPO().rf());
                }
                List<Post> list2 = dataRes.post_list;
                if (list2 != null && list2.size() > 0) {
                    for (Post post : dataRes.post_list) {
                        PostData postData = new PostData();
                        postData.setUserMap(this.userMap);
                        postData.a(post, context);
                        postData.a(aPO().ri());
                        if (postData.buu() == 1 && this.beV.rZ()) {
                            if (aPU()) {
                                postData.setPostType(0);
                            } else {
                                postData.setPostType(this.beV.rY());
                            }
                        } else if (postData.buu() == 1 && this.beV != null && this.beV.sg()) {
                            postData.setPostType(36);
                        } else if (postData.buu() == 1 && this.beV.sn()) {
                            postData.setPostType(41);
                        } else if (postData.buu() == 1 && this.beV != null && this.beV.sh()) {
                            postData.setPostType(0);
                            postData.IS();
                            if (this.beV.rr() == null || this.beV.rr().size() == 0) {
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
                                postData.g(new TbRichText((Context) TbadkCoreApplication.getInst(), this.beV.rr(), true));
                            }
                            this.eGD = postData;
                        } else if (postData.buu() == 1 && this.beV.so()) {
                            postData.setPostType(48);
                        }
                        this.eGh.add(postData);
                    }
                }
                if (dataRes.first_floor_post != null) {
                    this.eGJ = new PostData();
                    this.eGJ.setUserMap(this.userMap);
                    this.eGJ.a(dataRes.first_floor_post, context);
                }
                this.dRK.a(dataRes.page);
                this.Xe.parserProtobuf(dataRes.anti);
                this.eGi.a(dataRes.location);
                if (dataRes.user != null) {
                    this.eGj = dataRes.user.is_manager.intValue();
                }
                this.eGm.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.eGp.add(muteUser);
                        }
                    }
                }
                this.beV.bQ(this.beV.rl() > 0 ? this.beV.rl() - 1 : 0);
                List<AppData> biY = r.bja().biY();
                if (biY != null) {
                    biY.clear();
                }
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        com.baidu.tieba.tbadkCore.data.l lVar = new com.baidu.tieba.tbadkCore.data.l();
                        lVar.c(app);
                        AppData buj = lVar.buj();
                        if (!this.eGv.contains(lVar) && buj.goods != null && (!StringUtils.isNull(buj.goods.user_name) || !StringUtils.isNull(buj.goods.lego_card))) {
                            this.eGv.add(lVar);
                            if (biY != null) {
                                biY.add(lVar.buj());
                            }
                        }
                    }
                }
                r.bja().biZ();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.eGm.getIsSelectTail());
                }
                this.eGw.parserProtobuf(dataRes.twzhibo_anti);
                this.eGy = dataRes.appeal_info;
                if (dataRes.god_card != null) {
                    this.eGr = new a();
                    this.eGr.a(dataRes.god_card);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.eGE = new h();
                    this.eGE.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.guess_like != null) {
                    this.eGF = new CardHListViewData();
                    this.eGF.parseProtobuf(dataRes.guess_like);
                }
                if (dataRes.feed_thread_list != null && dataRes.feed_thread_list.size() > 0) {
                    List<ThreadInfo> list3 = dataRes.feed_thread_list;
                    if (this.eGt == null) {
                        this.eGt = new ArrayList();
                    }
                    this.eGt.clear();
                    for (ThreadInfo threadInfo : list3) {
                        if (threadInfo != null) {
                            bh bhVar = new bh();
                            bhVar.a(threadInfo);
                            this.eGt.add(bhVar);
                        }
                    }
                    if (this.eGt != null && this.eGt.size() > 15) {
                        this.eGt = v.a(this.eGt, 0, 15);
                    }
                }
                this.eGu = dataRes.is_follow_current_channel.intValue();
                if (v.u(dataRes.repost_recommend_forum_list) > 0) {
                    if (this.eGz == null) {
                        this.eGz = new ArrayList();
                    }
                    for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                        bc bcVar = new bc();
                        bcVar.parserProtobuf(simpleForum);
                        this.eGz.add(bcVar);
                    }
                }
                if (v.u(dataRes.from_forum_list) > 0) {
                    if (this.eGA == null) {
                        this.eGA = new ArrayList();
                    }
                    for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                        bc bcVar2 = new bc();
                        bcVar2.parserProtobuf(simpleForum2);
                        this.eGA.add(bcVar2);
                    }
                }
                if (dataRes.top_agree_post_list != null && this.eGB != null) {
                    this.eGB.a(context, dataRes.top_agree_post_list);
                }
                if (this.eGG >= 0) {
                    this.eGG = dataRes.thread_freq_num.longValue();
                }
                this.eGH = new l();
                this.eGH.a(dataRes);
                this.eGI = dataRes.partial_visible_toast;
                if (dataRes.follow_tip != null && dataRes.follow_tip.is_toast_tip.intValue() == 1) {
                    this.eGk = dataRes.follow_tip.tip_text;
                }
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }

    public CardHListViewData aPW() {
        return this.eGF;
    }

    public PostData aPX() {
        return this.eGD;
    }

    public PostData c(PostData postData) {
        this.eGD = postData;
        return postData;
    }

    public n aPY() {
        return this.eGB;
    }

    public int aPZ() {
        return this.eGj;
    }

    public int aQa() {
        return this.eGl;
    }

    public void pp(int i) {
        this.eGl = i;
    }

    public List<MuteUser> aQb() {
        return this.eGp;
    }

    public ArrayList<com.baidu.tieba.tbadkCore.data.l> aQc() {
        return this.eGv;
    }

    public a aQd() {
        return this.eGr;
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> aQe() {
        return new ArrayList<>(this.eGh);
    }

    public String aQf() {
        return this.eGC;
    }

    public void pn(String str) {
        this.eGC = str;
    }

    public h aQg() {
        return this.eGE;
    }

    public int aQh() {
        return this.eGu;
    }

    public List<bc> aQi() {
        return this.eGA;
    }

    public long aQj() {
        return this.eGG;
    }

    public l aQk() {
        return this.eGH;
    }

    public void a(l lVar) {
        this.eGH = lVar;
    }

    public boolean aQl() {
        return (aPO() == null || !aPO().sh() || aPO().rL() == null) ? false : true;
    }

    public String aQm() {
        return this.eGk;
    }
}

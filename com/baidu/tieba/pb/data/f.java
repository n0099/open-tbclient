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
    private TwzhiboAnti eOA;
    private VoteDataInfo eOB;
    public AppealInfo eOC;
    private List<ay> eOD;
    private List<ay> eOE;
    public String eOG;
    private PostData eOH;
    private h eOI;
    public CardHListViewData eOJ;
    private long eOK;
    private l eOL;
    public String eOM;
    private PostData eON;
    private String eOn;
    private int eOo;
    private a eOu;
    private List<bd> eOw;
    private int eOx;
    private AlaLiveInfoCoreData eOy;
    private boolean eOt = true;
    private ArrayList<com.baidu.tieba.tbadkCore.data.l> eOz = new ArrayList<>();
    private ForumData eOi = new ForumData();
    private ay eOj = new ay();
    private bd bjD = new bd();
    private ArrayList<PostData> eOk = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private al dZC = new al();
    private AntiData Xx = new AntiData();
    private com.baidu.tbadk.data.i eOl = new com.baidu.tbadk.data.i();
    private int eOm = 0;
    private final UserData eOp = new UserData();
    private List<MuteUser> eOs = new ArrayList();
    private an eOq = new an();
    private ao eOv = new ao();
    private ac eOr = new ac();
    private n eOF = new n();

    public boolean aRd() {
        return this.eOt;
    }

    public void iV(boolean z) {
        this.eOt = z;
    }

    public VoteDataInfo aRe() {
        return this.eOB;
    }

    public f() {
        this.eOo = 0;
        this.eOA = null;
        this.eOo = 0;
        this.eOA = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.eOk != null && this.eOk.size() > 0;
    }

    public String[] bP(Context context) {
        String str = null;
        String str2 = "";
        if (isValid()) {
            PostData postData = this.eOk.get(0);
            PreLoadImageInfo bwu = postData.bwu();
            str = bwu != null ? bwu.imgUrl : "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            str2 = postData.cf(context);
            if (this.bjD != null && this.bjD.si() != null && this.bjD.si().getGroup_id() != 0) {
                str2 = "[" + context.getString(d.j.photo_live_tips) + "] " + str2;
            }
            if (this.bjD != null && this.bjD.sk() && postData != null && postData.JA() != null) {
                str = postData.JA().getThumbUrl();
            }
        }
        return new String[]{str, str2};
    }

    public ForumData aRf() {
        return this.eOi;
    }

    public ay aRg() {
        return this.eOj;
    }

    public String getForumId() {
        if (this.eOi == null) {
            return "";
        }
        return this.eOi.getId();
    }

    public bd aRh() {
        return this.bjD;
    }

    public List<bd> aRi() {
        return this.eOw;
    }

    public String getThreadId() {
        if (this.bjD == null) {
            return "";
        }
        return this.bjD.getId();
    }

    public ArrayList<PostData> aRj() {
        return this.eOk;
    }

    public al qA() {
        return this.dZC;
    }

    public ac aRk() {
        return this.eOr;
    }

    public ao aRl() {
        return this.eOv;
    }

    public TwzhiboAnti aRm() {
        return this.eOA;
    }

    public void a(al alVar, int i) {
        this.dZC.bI(alVar.qu());
        this.dZC.bG(alVar.pt());
        this.dZC.bF(alVar.qr());
        this.dZC.bJ(alVar.qv());
        this.dZC.bH(alVar.qt());
        if (i == 0) {
            this.dZC = alVar;
        } else if (i == 1) {
            this.dZC.bK(alVar.qw());
        } else if (i == 2) {
            this.dZC.bL(alVar.qx());
        }
    }

    public AntiData qi() {
        return this.Xx;
    }

    public UserData getUserData() {
        return this.eOp;
    }

    public boolean nJ() {
        return this.bjD.rG() != 0;
    }

    public void ab(boolean z) {
        if (this.bjD != null) {
            if (z) {
                this.bjD.bU(1);
            } else {
                this.bjD.bU(0);
            }
        }
    }

    public String nI() {
        if (this.bjD != null) {
            return this.bjD.rH();
        }
        return null;
    }

    public void pG(String str) {
        if (this.bjD != null) {
            this.bjD.cK(str);
        }
    }

    public boolean aRn() {
        return (this.bjD == null || this.bjD.rJ() == null || this.bjD.rJ().size() <= 0 || this.bjD.rJ().get(0) == null || !this.bjD.rJ().get(0).getIsSenior()) ? false : true;
    }

    public PostData aRo() {
        return this.eON;
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                com.baidu.tieba.recapp.e.a.blQ().rW(dataRes.asp_shown_info);
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
                pC(dataRes.is_new_url.intValue());
                this.eOi.parserProtobuf(dataRes.forum);
                this.eOj.parserProtobuf(dataRes.display_forum);
                this.bjD.setUserMap(this.userMap);
                this.bjD.a(dataRes.thread);
                this.bjD.bY(2);
                this.eOq.a(dataRes.news_info);
                switch (this.eOq.XO) {
                    case 1:
                        this.eOr.eZc = this.eOq;
                        break;
                    case 2:
                        this.eOr.eZd = this.eOq;
                        break;
                    case 3:
                        this.eOr.eZe = this.eOq;
                        break;
                    default:
                        this.eOr.eZd = this.eOq;
                        break;
                }
                this.eOv.a(dataRes.recommend_book);
                if (this.bjD != null && this.bjD.rj() != null) {
                    this.eOB = new VoteDataInfo();
                    this.eOB.parserProtobuf(aRh().rj());
                }
                List<Post> list2 = dataRes.post_list;
                if (list2 != null && list2.size() > 0) {
                    for (Post post : dataRes.post_list) {
                        PostData postData = new PostData();
                        postData.setUserMap(this.userMap);
                        postData.a(post, context);
                        postData.a(aRh().rm());
                        if (postData.bwo() == 1 && this.bjD.sc()) {
                            if (aRn()) {
                                postData.setPostType(0);
                            } else {
                                postData.setPostType(this.bjD.sb());
                            }
                        } else if (postData.bwo() == 1 && this.bjD != null && this.bjD.sj()) {
                            postData.setPostType(36);
                        } else if (postData.bwo() == 1 && this.bjD.sq()) {
                            postData.setPostType(41);
                        } else if (postData.bwo() == 1 && this.bjD != null && this.bjD.sk()) {
                            postData.setPostType(0);
                            postData.JA();
                            if (this.bjD.rv() == null || this.bjD.rv().size() == 0) {
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
                                postData.d(new TbRichText((Context) TbadkCoreApplication.getInst(), this.bjD.rv(), true));
                            }
                            this.eOH = postData;
                        } else if (postData.bwo() == 1 && this.bjD.sr()) {
                            postData.setPostType(48);
                        }
                        if (postData.bwo() == 1 && this.bjD != null && this.bjD.isShareThread) {
                            postData.f(this.bjD.aaI);
                        }
                        this.eOk.add(postData);
                    }
                }
                if (dataRes.first_floor_post != null) {
                    this.eON = new PostData();
                    this.eON.setUserMap(this.userMap);
                    this.eON.a(dataRes.first_floor_post, context);
                    if (this.bjD != null && this.bjD.isShareThread) {
                        this.eON.f(this.bjD.aaI);
                    }
                }
                this.dZC.a(dataRes.page);
                this.Xx.parserProtobuf(dataRes.anti);
                this.eOl.a(dataRes.location);
                if (dataRes.user != null) {
                    this.eOm = dataRes.user.is_manager.intValue();
                }
                this.eOp.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.eOs.add(muteUser);
                        }
                    }
                }
                this.bjD.bQ(this.bjD.rp() > 0 ? this.bjD.rp() - 1 : 0);
                List<AppData> blj = q.bll().blj();
                if (blj != null) {
                    blj.clear();
                }
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        com.baidu.tieba.tbadkCore.data.l lVar = new com.baidu.tieba.tbadkCore.data.l();
                        lVar.c(app);
                        AppData bwd = lVar.bwd();
                        if (!this.eOz.contains(lVar) && bwd.goods != null && (!StringUtils.isNull(bwd.goods.user_name) || !StringUtils.isNull(bwd.goods.lego_card))) {
                            this.eOz.add(lVar);
                            if (blj != null) {
                                blj.add(lVar.bwd());
                            }
                        }
                    }
                }
                q.bll().blk();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.eOp.getIsSelectTail());
                }
                this.eOA.parserProtobuf(dataRes.twzhibo_anti);
                this.eOC = dataRes.appeal_info;
                if (dataRes.god_card != null) {
                    this.eOu = new a();
                    this.eOu.a(dataRes.god_card);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.eOI = new h();
                    this.eOI.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.guess_like != null) {
                    this.eOJ = new CardHListViewData();
                    this.eOJ.parseProtobuf(dataRes.guess_like);
                }
                if (dataRes.feed_thread_list != null && dataRes.feed_thread_list.size() > 0) {
                    List<ThreadInfo> list3 = dataRes.feed_thread_list;
                    if (this.eOw == null) {
                        this.eOw = new ArrayList();
                    }
                    this.eOw.clear();
                    for (ThreadInfo threadInfo : list3) {
                        if (threadInfo != null) {
                            bd bdVar = new bd();
                            bdVar.a(threadInfo);
                            this.eOw.add(bdVar);
                        }
                    }
                    if (this.eOw != null && this.eOw.size() > 15) {
                        this.eOw = v.a(this.eOw, 0, 15);
                    }
                }
                this.eOx = dataRes.is_follow_current_channel.intValue();
                if (v.v(dataRes.repost_recommend_forum_list) > 0) {
                    if (this.eOD == null) {
                        this.eOD = new ArrayList();
                    }
                    for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                        ay ayVar = new ay();
                        ayVar.parserProtobuf(simpleForum);
                        this.eOD.add(ayVar);
                    }
                }
                if (v.v(dataRes.from_forum_list) > 0) {
                    if (this.eOE == null) {
                        this.eOE = new ArrayList();
                    }
                    for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                        ay ayVar2 = new ay();
                        ayVar2.parserProtobuf(simpleForum2);
                        this.eOE.add(ayVar2);
                    }
                }
                if (dataRes.top_agree_post_list != null && this.eOF != null) {
                    this.eOF.a(context, dataRes.top_agree_post_list);
                }
                if (this.eOK >= 0) {
                    this.eOK = dataRes.thread_freq_num.longValue();
                }
                this.eOL = new l();
                this.eOL.a(dataRes);
                this.eOM = dataRes.partial_visible_toast;
                if (dataRes.follow_tip != null && dataRes.follow_tip.is_toast_tip.intValue() == 1) {
                    this.eOn = dataRes.follow_tip.tip_text;
                }
                this.eOy = new AlaLiveInfoCoreData();
                if (dataRes.ala_info != null) {
                    this.eOy.parserProtoBuf(dataRes.ala_info);
                }
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }

    public CardHListViewData aRp() {
        return this.eOJ;
    }

    public PostData aRq() {
        return this.eOH;
    }

    public PostData c(PostData postData) {
        this.eOH = postData;
        return postData;
    }

    public n aRr() {
        return this.eOF;
    }

    public int aRs() {
        return this.eOm;
    }

    public int aRt() {
        return this.eOo;
    }

    public void pC(int i) {
        this.eOo = i;
    }

    public List<MuteUser> aRu() {
        return this.eOs;
    }

    public ArrayList<com.baidu.tieba.tbadkCore.data.l> aRv() {
        return this.eOz;
    }

    public a aRw() {
        return this.eOu;
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> aRx() {
        return new ArrayList<>(this.eOk);
    }

    public String aRy() {
        return this.eOG;
    }

    public void pH(String str) {
        this.eOG = str;
    }

    public h aRz() {
        return this.eOI;
    }

    public int aRA() {
        return this.eOx;
    }

    public List<ay> aRB() {
        return this.eOE;
    }

    public long aRC() {
        return this.eOK;
    }

    public l aRD() {
        return this.eOL;
    }

    public void a(l lVar) {
        this.eOL = lVar;
    }

    public boolean aRE() {
        return (aRh() == null || !aRh().sk() || aRh().rP() == null) ? false : true;
    }

    public String aRF() {
        return this.eOn;
    }

    public AlaLiveInfoCoreData aRG() {
        return this.eOy;
    }
}

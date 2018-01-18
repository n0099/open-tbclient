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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.ad;
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
/* loaded from: classes2.dex */
public class f {
    private List<bd> fDA;
    private int fDB;
    private AlaLiveInfoCoreData fDC;
    private TwzhiboAnti fDE;
    private VoteDataInfo fDF;
    public AppealInfo fDG;
    private List<ay> fDH;
    private List<ay> fDI;
    public String fDK;
    private PostData fDL;
    private h fDM;
    public CardHListViewData fDN;
    private long fDO;
    private l fDP;
    public String fDQ;
    public int fDR;
    public int fDS;
    private String fDT;
    private String fDU;
    private PostData fDV;
    private String fDr;
    private int fDs;
    private a fDy;
    private boolean fDx = true;
    private ArrayList<com.baidu.tieba.tbadkCore.data.l> fDD = new ArrayList<>();
    private ForumData fDm = new ForumData();
    private ay fDn = new ay();
    private bd bXa = new bd();
    private ArrayList<PostData> fDo = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private al eOn = new al();
    private AntiData aLO = new AntiData();
    private com.baidu.tbadk.data.f fDp = new com.baidu.tbadk.data.f();
    private int fDq = 0;
    private final UserData fDt = new UserData();
    private List<MuteUser> fDw = new ArrayList();
    private an fDu = new an();
    private ao fDz = new ao();
    private ad fDv = new ad();
    private n fDJ = new n();

    public boolean aYC() {
        return this.fDx;
    }

    public void jB(boolean z) {
        this.fDx = z;
    }

    public VoteDataInfo aYD() {
        return this.fDF;
    }

    public f() {
        this.fDs = 0;
        this.fDE = null;
        this.fDs = 0;
        this.fDE = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.fDo != null && this.fDo.size() > 0;
    }

    public String[] bX(Context context) {
        String str = null;
        String str2 = "";
        if (isValid()) {
            int size = this.fDo.size() > 30 ? 30 : this.fDo.size();
            if (aYG() == null || aYG().yS() == null || am.isEmpty(aYG().yS().getUserId())) {
                return new String[]{null, ""};
            }
            String userId = aYG().yS().getUserId();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                PostData postData = (PostData) v.f(this.fDo, i);
                if (postData != null && postData.yS() != null && !am.isEmpty(postData.yS().getUserId()) && am.equals(userId, postData.yS().getUserId())) {
                    if (am.isEmpty(str)) {
                        str = postData.bvP();
                    }
                    String bvN = am.isEmpty(str2) ? postData.bvN() : str2;
                    if (!am.isEmpty(str) && !am.isEmpty(bvN)) {
                        str2 = bvN;
                        break;
                    }
                    str2 = bvN;
                }
                i++;
                str = str;
            }
            if (am.isEmpty(str)) {
                str = "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            }
            PostData postData2 = this.fDo.get(0);
            if (this.bXa != null && this.bXa.zD() != null && this.bXa.zD().getGroup_id() != 0) {
                str2 = "[" + context.getString(d.j.photo_live_tips) + "] " + str2;
            }
            if (this.bXa != null && this.bXa.zF() && postData2 != null && postData2.QL() != null) {
                str = postData2.QL().getThumbUrl();
            }
        }
        return new String[]{str, str2};
    }

    public ForumData aYE() {
        return this.fDm;
    }

    public ay aYF() {
        return this.fDn;
    }

    public String getForumId() {
        if (this.fDm == null) {
            return "";
        }
        return this.fDm.getId();
    }

    public bd aYG() {
        return this.bXa;
    }

    public List<bd> aYH() {
        return this.fDA;
    }

    public String getThreadId() {
        if (this.bXa == null) {
            return "";
        }
        return this.bXa.getId();
    }

    public ArrayList<PostData> aYI() {
        return this.fDo;
    }

    public al xY() {
        return this.eOn;
    }

    public ad aYJ() {
        return this.fDv;
    }

    public ao aYK() {
        return this.fDz;
    }

    public void a(al alVar, int i) {
        this.eOn.eH(alVar.xS());
        this.eOn.eF(alVar.wT());
        this.eOn.eE(alVar.xP());
        this.eOn.eI(alVar.xT());
        this.eOn.eG(alVar.xR());
        if (i == 0) {
            this.eOn = alVar;
        } else if (i == 1) {
            this.eOn.eJ(alVar.xU());
        } else if (i == 2) {
            this.eOn.eK(alVar.xV());
        }
    }

    public AntiData xG() {
        return this.aLO;
    }

    public UserData getUserData() {
        return this.fDt;
    }

    public boolean vk() {
        return this.bXa.zb() != 0;
    }

    public void aH(boolean z) {
        if (this.bXa != null) {
            if (z) {
                this.bXa.eT(1);
            } else {
                this.bXa.eT(0);
            }
        }
    }

    public String vj() {
        if (this.bXa != null) {
            return this.bXa.zc();
        }
        return null;
    }

    public void pT(String str) {
        if (this.bXa != null) {
            this.bXa.cR(str);
        }
    }

    public String aYL() {
        return this.fDU;
    }

    public boolean aYM() {
        return (this.bXa == null || this.bXa.ze() == null || this.bXa.ze().size() <= 0 || this.bXa.ze().get(0) == null || !this.bXa.ze().get(0).getIsSenior()) ? false : true;
    }

    public PostData aYN() {
        return this.fDV;
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                com.baidu.tieba.recapp.e.a.bnw().rG(dataRes.asp_shown_info);
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
                sw(dataRes.is_new_url.intValue());
                this.fDm.parserProtobuf(dataRes.forum);
                this.fDn.parserProtobuf(dataRes.display_forum);
                this.bXa.setUserMap(this.userMap);
                this.bXa.a(dataRes.thread);
                this.bXa.eW(2);
                this.fDu.a(dataRes.news_info);
                switch (this.fDu.aMf) {
                    case 1:
                        this.fDv.fOC = this.fDu;
                        break;
                    case 2:
                        this.fDv.fOD = this.fDu;
                        break;
                    case 3:
                        this.fDv.fOE = this.fDu;
                        break;
                    default:
                        this.fDv.fOD = this.fDu;
                        break;
                }
                this.fDz.a(dataRes.recommend_book);
                if (this.bXa != null && this.bXa.yE() != null) {
                    this.fDF = new VoteDataInfo();
                    this.fDF.parserProtobuf(aYG().yE());
                }
                List<Post> list2 = dataRes.post_list;
                if (list2 != null && list2.size() > 0) {
                    for (Post post : dataRes.post_list) {
                        PostData postData = new PostData();
                        postData.setUserMap(this.userMap);
                        postData.a(post, context);
                        postData.a(aYG().yH());
                        if (postData.bvH() == 1 && this.bXa.zx()) {
                            if (aYM()) {
                                postData.setPostType(0);
                            } else {
                                postData.setPostType(this.bXa.zw());
                            }
                        } else if (postData.bvH() == 1 && this.bXa != null && this.bXa.zE()) {
                            postData.setPostType(36);
                        } else if (postData.bvH() == 1 && this.bXa.zI()) {
                            postData.setPostType(41);
                        } else if (postData.bvH() == 1 && this.bXa != null && this.bXa.zF()) {
                            postData.setPostType(0);
                            postData.QL();
                            if (this.bXa.yQ() == null || this.bXa.yQ().size() == 0) {
                                JSONArray jSONArray = new JSONArray();
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("type", 0);
                                    jSONObject.put("text", "");
                                    jSONArray.put(jSONObject);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                postData.c(TbRichTextView.a(context, jSONArray, false));
                            } else {
                                postData.c(new TbRichText((Context) TbadkCoreApplication.getInst(), this.bXa.yQ(), true));
                            }
                            this.fDL = postData;
                        } else if (postData.bvH() == 1 && this.bXa.zJ()) {
                            postData.setPostType(48);
                        }
                        if (postData.bvH() == 1 && this.bXa != null && this.bXa.isShareThread) {
                            postData.f(this.bXa.aOZ);
                        }
                        this.fDo.add(postData);
                    }
                }
                if (dataRes.first_floor_post != null) {
                    this.fDV = new PostData();
                    this.fDV.setUserMap(this.userMap);
                    this.fDV.a(dataRes.first_floor_post, context);
                    if (this.bXa != null && this.bXa.isShareThread) {
                        this.fDV.f(this.bXa.aOZ);
                    }
                }
                this.eOn.a(dataRes.page);
                this.aLO.parserProtobuf(dataRes.anti);
                this.fDp.a(dataRes.location);
                if (dataRes.user != null) {
                    this.fDq = dataRes.user.is_manager.intValue();
                }
                this.fDt.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.fDw.add(muteUser);
                        }
                    }
                }
                this.bXa.eP(this.bXa.yK() > 0 ? this.bXa.yK() - 1 : 0);
                List<AppData> bmP = q.bmR().bmP();
                if (bmP != null) {
                    bmP.clear();
                }
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        com.baidu.tieba.tbadkCore.data.l lVar = new com.baidu.tieba.tbadkCore.data.l();
                        lVar.d(app);
                        AppData bvv = lVar.bvv();
                        if (!this.fDD.contains(lVar) && bvv.goods != null && (!StringUtils.isNull(bvv.goods.user_name) || !StringUtils.isNull(bvv.goods.lego_card))) {
                            this.fDD.add(lVar);
                            if (bmP != null) {
                                bmP.add(lVar.bvv());
                            }
                        }
                    }
                }
                q.bmR().bmQ();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.fDt.getIsSelectTail());
                }
                this.fDE.parserProtobuf(dataRes.twzhibo_anti);
                this.fDG = dataRes.appeal_info;
                if (dataRes.god_card != null) {
                    this.fDy = new a();
                    this.fDy.a(dataRes.god_card);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.fDM = new h();
                    this.fDM.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.guess_like != null) {
                    this.fDN = new CardHListViewData();
                    this.fDN.parseProtobuf(dataRes.guess_like);
                }
                if (dataRes.feed_thread_list != null && dataRes.feed_thread_list.size() > 0) {
                    List<ThreadInfo> list3 = dataRes.feed_thread_list;
                    if (this.fDA == null) {
                        this.fDA = new ArrayList();
                    }
                    this.fDA.clear();
                    for (ThreadInfo threadInfo : list3) {
                        if (threadInfo != null) {
                            bd bdVar = new bd();
                            bdVar.a(threadInfo);
                            this.fDA.add(bdVar);
                        }
                    }
                    if (this.fDA != null && this.fDA.size() > 15) {
                        this.fDA = v.b(this.fDA, 0, 15);
                    }
                }
                this.fDB = dataRes.is_follow_current_channel.intValue();
                if (v.D(dataRes.repost_recommend_forum_list) > 0) {
                    if (this.fDH == null) {
                        this.fDH = new ArrayList();
                    }
                    for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                        ay ayVar = new ay();
                        ayVar.parserProtobuf(simpleForum);
                        this.fDH.add(ayVar);
                    }
                }
                if (v.D(dataRes.from_forum_list) > 0) {
                    if (this.fDI == null) {
                        this.fDI = new ArrayList();
                    }
                    for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                        if (simpleForum2 != null) {
                            ay ayVar2 = new ay();
                            ayVar2.parserProtobuf(simpleForum2);
                            this.fDI.add(ayVar2);
                        }
                    }
                }
                this.fDU = dataRes.multi_forum_text;
                if (dataRes.top_agree_post_list != null && this.fDJ != null) {
                    this.fDJ.a(context, dataRes.top_agree_post_list);
                }
                if (this.fDO >= 0) {
                    this.fDO = dataRes.thread_freq_num.longValue();
                }
                this.fDP = new l();
                this.fDP.a(dataRes);
                this.fDQ = dataRes.partial_visible_toast;
                if (dataRes.follow_tip != null && dataRes.follow_tip.is_toast_tip.intValue() == 1) {
                    this.fDr = dataRes.follow_tip.tip_text;
                }
                this.fDC = new AlaLiveInfoCoreData();
                if (dataRes.ala_info != null) {
                    this.fDC.parserProtoBuf(dataRes.ala_info);
                }
                this.fDT = dataRes.fold_tip;
                this.fDR = dataRes.exp_news_today.intValue();
                this.fDS = dataRes.exp_guide_today.intValue();
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }

    public String aYO() {
        return this.fDT;
    }

    public CardHListViewData aYP() {
        return this.fDN;
    }

    public PostData aYQ() {
        return this.fDL;
    }

    public PostData c(PostData postData) {
        this.fDL = postData;
        return postData;
    }

    public n aYR() {
        return this.fDJ;
    }

    public int aYS() {
        return this.fDq;
    }

    public int aYT() {
        return this.fDs;
    }

    public void sw(int i) {
        this.fDs = i;
    }

    public List<MuteUser> aYU() {
        return this.fDw;
    }

    public ArrayList<com.baidu.tieba.tbadkCore.data.l> aYV() {
        return this.fDD;
    }

    public a aYW() {
        return this.fDy;
    }

    public String aYX() {
        return this.fDK;
    }

    public void pU(String str) {
        this.fDK = str;
    }

    public h aYY() {
        return this.fDM;
    }

    public int aYZ() {
        return this.fDB;
    }

    public List<ay> aZa() {
        return this.fDI;
    }

    public long aZb() {
        return this.fDO;
    }

    public l aZc() {
        return this.fDP;
    }

    public void a(l lVar) {
        this.fDP = lVar;
    }

    public boolean aZd() {
        return (aYG() == null || !aYG().zF() || aYG().zk() == null) ? false : true;
    }

    public String aZe() {
        return this.fDr;
    }

    public AlaLiveInfoCoreData aZf() {
        return this.fDC;
    }
}

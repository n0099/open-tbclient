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
import com.baidu.tbadk.core.data.au;
import com.baidu.tbadk.core.data.ay;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.e;
import com.baidu.tieba.pb.pb.main.ad;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.tbadkCore.data.AppData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.data.l;
import com.baidu.tieba.usermute.MuteUser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.App;
import tbclient.PbPage.AppealInfo;
import tbclient.PbPage.DataRes;
import tbclient.PbPage.PbSortType;
import tbclient.Post;
import tbclient.SimpleForum;
import tbclient.SimpleUser;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes6.dex */
public class d {
    private i fJA;
    public String fJB;
    public int fJC;
    public int fJD;
    public List<PbSortType> fJE;
    public int fJF;
    private String fJG;
    private String fJH;
    private PostData fJK;
    private String fJc;
    private int fJd;
    private a fJj;
    private List<bb> fJl;
    private int fJm;
    private AlaLiveInfoCoreData fJn;
    private TwzhiboAnti fJq;
    public AppealInfo fJr;
    private List<ay> fJs;
    private List<ay> fJt;
    public String fJv;
    private PostData fJw;
    private f fJx;
    public CardHListViewData fJy;
    private long fJz;
    private boolean fJi = true;
    private ArrayList<l> fJo = new ArrayList<>();
    private l fJp = null;
    private ForumData fIX = new ForumData();
    private ay fIY = new ay();
    private bb bIU = new bb();
    private ArrayList<PostData> fIZ = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private al eXT = new al();
    private AntiData aou = new AntiData();
    private com.baidu.tbadk.data.f fJa = new com.baidu.tbadk.data.f();
    private int fJb = 0;
    private final UserData fJe = new UserData();
    private List<MuteUser> fJh = new ArrayList();
    private an fJf = new an();
    private ao fJk = new ao();
    private ad fJg = new ad();
    private k fJu = new k();
    private List<au.a> fJI = new ArrayList();
    private HashSet<String> fJJ = new HashSet<>();

    public boolean beq() {
        return this.fJi;
    }

    public void ks(boolean z) {
        this.fJi = z;
    }

    public d() {
        this.fJd = 0;
        this.fJq = null;
        this.fJd = 0;
        this.fJq = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.fIZ != null && this.fIZ.size() > 0;
    }

    public String[] cL(Context context) {
        String str = null;
        String str2 = "";
        if (isValid()) {
            int size = this.fIZ.size() > 30 ? 30 : this.fIZ.size();
            if (bet() == null || bet().yC() == null || com.baidu.tbadk.core.util.ao.isEmpty(bet().yC().getUserId())) {
                return new String[]{null, ""};
            }
            String userId = bet().yC().getUserId();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                PostData postData = (PostData) v.d(this.fIZ, i);
                if (postData != null && postData.yC() != null && !com.baidu.tbadk.core.util.ao.isEmpty(postData.yC().getUserId()) && com.baidu.tbadk.core.util.ao.equals(userId, postData.yC().getUserId())) {
                    if (com.baidu.tbadk.core.util.ao.isEmpty(str)) {
                        str = postData.bBE();
                    }
                    String bBC = com.baidu.tbadk.core.util.ao.isEmpty(str2) ? postData.bBC() : str2;
                    if (!com.baidu.tbadk.core.util.ao.isEmpty(str) && !com.baidu.tbadk.core.util.ao.isEmpty(bBC)) {
                        str2 = bBC;
                        break;
                    }
                    str2 = bBC;
                }
                i++;
                str = str;
            }
            if (com.baidu.tbadk.core.util.ao.isEmpty(str)) {
                str = "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            }
            PostData postData2 = this.fIZ.get(0);
            if (this.bIU != null && this.bIU.zo() != null && this.bIU.zo().getGroup_id() != 0) {
                str2 = "[" + context.getString(e.j.photo_live_tips) + "] " + str2;
            }
            if (this.bIU != null && this.bIU.zq() && postData2 != null && postData2.Rd() != null) {
                str = postData2.Rd().getThumbUrl();
            }
        }
        return new String[]{str, str2};
    }

    public ForumData ber() {
        return this.fIX;
    }

    public ay bes() {
        return this.fIY;
    }

    public String getForumId() {
        if (this.fIX == null) {
            return "";
        }
        return this.fIX.getId();
    }

    public bb bet() {
        return this.bIU;
    }

    public List<bb> beu() {
        return this.fJl;
    }

    public String getThreadId() {
        if (this.bIU == null) {
            return "";
        }
        return this.bIU.getId();
    }

    public ArrayList<PostData> bev() {
        return this.fIZ;
    }

    public al xO() {
        return this.eXT;
    }

    public ad bew() {
        return this.fJg;
    }

    public ao bex() {
        return this.fJk;
    }

    public void a(al alVar, int i) {
        this.eXT.cu(alVar.xJ());
        this.eXT.cs(alVar.wW());
        this.eXT.cr(alVar.xG());
        this.eXT.cv(alVar.xK());
        this.eXT.ct(alVar.xI());
        if (i == 0) {
            this.eXT = alVar;
        } else if (i == 1) {
            this.eXT.cw(alVar.xL());
        } else if (i == 2) {
            this.eXT.cx(alVar.xM());
        }
    }

    public AntiData xA() {
        return this.aou;
    }

    public UserData getUserData() {
        return this.fJe;
    }

    public boolean vm() {
        return this.bIU.yL() != 0;
    }

    public void aO(boolean z) {
        if (this.bIU != null) {
            if (z) {
                this.bIU.cF(1);
            } else {
                this.bIU.cF(0);
            }
        }
    }

    public String vl() {
        if (this.bIU != null) {
            return this.bIU.yM();
        }
        return null;
    }

    public void si(String str) {
        if (this.bIU != null) {
            this.bIU.dX(str);
        }
    }

    public String bey() {
        return this.fJH;
    }

    public boolean bez() {
        return (this.bIU == null || this.bIU.yO() == null || this.bIU.yO().size() <= 0 || this.bIU.yO().get(0) == null || !this.bIU.yO().get(0).wX()) ? false : true;
    }

    public PostData beA() {
        return this.fJK;
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                com.baidu.tieba.recapp.d.a.btw().uj(dataRes.asp_shown_info);
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
                rE(dataRes.is_new_url.intValue());
                this.fIX.parserProtobuf(dataRes.forum);
                this.fIY.parserProtobuf(dataRes.display_forum);
                this.bIU.setUserMap(this.userMap);
                this.bIU.a(dataRes.thread);
                this.bIU.setCurrentPage(2);
                this.fJf.a(dataRes.news_info);
                switch (this.fJf.aoO) {
                    case 1:
                        this.fJg.fTz = this.fJf;
                        break;
                    case 2:
                        this.fJg.fTA = this.fJf;
                        break;
                    case 3:
                        this.fJg.fTB = this.fJf;
                        break;
                    default:
                        this.fJg.fTA = this.fJf;
                        break;
                }
                this.fJk.a(dataRes.recommend_book);
                List<Post> list2 = dataRes.post_list;
                if (list2 != null && list2.size() > 0) {
                    for (Post post : dataRes.post_list) {
                        if (!this.fJJ.contains(String.valueOf(post.id))) {
                            PostData postData = new PostData();
                            postData.setUserMap(this.userMap);
                            postData.ku(this.fIX.isBrandForum);
                            postData.a(post, context);
                            postData.a(bet().yp());
                            this.fJJ.add(postData.getId());
                            if (postData.bBx() == 1 && this.bIU.zh()) {
                                if (bez()) {
                                    postData.setPostType(0);
                                } else {
                                    postData.setPostType(this.bIU.zg());
                                }
                            } else if (postData.bBx() == 1 && this.bIU.zu()) {
                                postData.setPostType(41);
                            } else if (postData.bBx() == 1 && this.bIU != null && this.bIU.zq()) {
                                postData.setPostType(0);
                                postData.Rd();
                                if (this.bIU.yA() == null || this.bIU.yA().size() == 0) {
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
                                    postData.c(new TbRichText((Context) TbadkCoreApplication.getInst(), this.bIU.yA(), true));
                                }
                                this.fJw = postData;
                            }
                            if (postData.bBx() == 1 && this.bIU != null && this.bIU.isShareThread) {
                                postData.g(this.bIU.arT);
                            }
                            this.fIZ.add(postData);
                        }
                    }
                }
                if (dataRes.first_floor_post != null) {
                    this.fJK = new PostData();
                    this.fJK.setUserMap(this.userMap);
                    this.fJK.ku(this.fIX.isBrandForum);
                    this.fJK.a(dataRes.first_floor_post, context);
                    if (this.bIU != null && this.bIU.isShareThread) {
                        this.fJK.g(this.bIU.arT);
                    }
                }
                this.eXT.a(dataRes.page);
                this.aou.parserProtobuf(dataRes.anti);
                this.fJa.a(dataRes.location);
                if (dataRes.user != null) {
                    this.fJb = dataRes.user.is_manager.intValue();
                }
                this.fJe.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.fJh.add(muteUser);
                        }
                    }
                }
                this.bIU.cB(this.bIU.yt() > 0 ? this.bIU.yt() - 1 : 0);
                List<AppData> bsE = r.bsG().bsE();
                if (bsE != null) {
                    bsE.clear();
                }
                this.fJp = null;
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        l lVar = new l();
                        lVar.d(app);
                        AppData bBl = lVar.bBl();
                        if (!this.fJo.contains(lVar) && bBl.goods != null && (!StringUtils.isNull(bBl.goods.user_name) || !StringUtils.isNull(bBl.goods.lego_card))) {
                            this.fJo.add(lVar);
                            if (bsE != null) {
                                bsE.add(lVar.bBl());
                            }
                        }
                    }
                    a(dataRes);
                }
                r.bsG().bsF();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.fJe.getIsSelectTail());
                }
                this.fJq.parserProtobuf(dataRes.twzhibo_anti);
                this.fJr = dataRes.appeal_info;
                if (dataRes.god_card != null) {
                    this.fJj = new a();
                    this.fJj.a(dataRes.god_card);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.fJx = new f();
                    this.fJx.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.guess_like != null) {
                    this.fJy = new CardHListViewData();
                    this.fJy.parseProtobuf(dataRes.guess_like);
                }
                if (dataRes.feed_thread_list != null && dataRes.feed_thread_list.size() > 0) {
                    List<ThreadInfo> list3 = dataRes.feed_thread_list;
                    if (this.fJl == null) {
                        this.fJl = new ArrayList();
                    }
                    this.fJl.clear();
                    for (ThreadInfo threadInfo : list3) {
                        if (threadInfo != null) {
                            bb bbVar = new bb();
                            bbVar.a(threadInfo);
                            this.fJl.add(bbVar);
                        }
                    }
                    if (this.fJl != null && this.fJl.size() > 15) {
                        this.fJl = v.b(this.fJl, 0, 15);
                    }
                }
                this.fJm = dataRes.is_follow_current_channel.intValue();
                if (v.H(dataRes.repost_recommend_forum_list) > 0) {
                    if (this.fJs == null) {
                        this.fJs = new ArrayList();
                    }
                    for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                        ay ayVar = new ay();
                        ayVar.parserProtobuf(simpleForum);
                        this.fJs.add(ayVar);
                    }
                }
                if (v.H(dataRes.from_forum_list) > 0) {
                    if (this.fJt == null) {
                        this.fJt = new ArrayList();
                    }
                    for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                        if (simpleForum2 != null) {
                            ay ayVar2 = new ay();
                            ayVar2.parserProtobuf(simpleForum2);
                            this.fJt.add(ayVar2);
                        }
                    }
                }
                this.fJH = dataRes.multi_forum_text;
                if (dataRes.top_agree_post_list != null && this.fJu != null) {
                    this.fJu.ku(this.fIX.isBrandForum);
                    this.fJu.a(context, dataRes.top_agree_post_list);
                }
                if (this.fJz >= 0) {
                    this.fJz = dataRes.thread_freq_num.longValue();
                }
                this.fJA = new i();
                this.fJA.bJG = this.bIU;
                this.fJA.b(dataRes);
                this.fJB = dataRes.partial_visible_toast;
                if (dataRes.follow_tip != null && dataRes.follow_tip.is_toast_tip.intValue() == 1) {
                    this.fJc = dataRes.follow_tip.tip_text;
                }
                this.fJn = new AlaLiveInfoCoreData();
                if (dataRes.ala_info != null) {
                    this.fJn.parserProtoBuf(dataRes.ala_info);
                }
                this.fJG = dataRes.fold_tip;
                this.fJC = dataRes.exp_news_today.intValue();
                this.fJD = dataRes.exp_guide_today.intValue();
                if (!v.I(dataRes.thread_topic)) {
                    for (int i2 = 0; i2 < dataRes.thread_topic.size(); i2++) {
                        au.a aVar = new au.a();
                        aVar.a(dataRes.thread_topic.get(i2));
                        this.fJI.add(aVar);
                    }
                }
                this.fJE = dataRes.pb_sort_info;
                this.fJF = dataRes.sort_type.intValue();
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }

    private void a(DataRes dataRes) {
        App app = dataRes.banner_list.pb_banner_ad;
        l lVar = new l();
        lVar.heq = true;
        lVar.d(app);
        if (lVar.bBl().goods != null) {
            this.fJp = lVar;
        }
    }

    public String beB() {
        return this.fJG;
    }

    public CardHListViewData beC() {
        return this.fJy;
    }

    public PostData beD() {
        return this.fJw;
    }

    public PostData d(PostData postData) {
        this.fJw = postData;
        return postData;
    }

    public k beE() {
        return this.fJu;
    }

    public int beF() {
        return this.fJb;
    }

    public int beG() {
        return this.fJd;
    }

    public void rE(int i) {
        this.fJd = i;
    }

    public List<MuteUser> beH() {
        return this.fJh;
    }

    public ArrayList<l> beI() {
        return this.fJo;
    }

    public l beJ() {
        return this.fJp;
    }

    public void beK() {
        if (this.fJp.bBl() != null) {
            this.fJp.bBl().legoCard = null;
        }
        this.fJp = null;
    }

    public a beL() {
        return this.fJj;
    }

    public String beM() {
        return this.fJv;
    }

    public void sj(String str) {
        this.fJv = str;
    }

    public f beN() {
        return this.fJx;
    }

    public int beO() {
        return this.fJm;
    }

    public List<ay> beP() {
        return this.fJt;
    }

    public long beQ() {
        return this.fJz;
    }

    public i beR() {
        return this.fJA;
    }

    public boolean beS() {
        return (bet() == null || !bet().zq() || bet().yU() == null) ? false : true;
    }

    public String beT() {
        return this.fJc;
    }

    public AlaLiveInfoCoreData beU() {
        return this.fJn;
    }

    public List<au.a> beV() {
        return this.fJI;
    }
}

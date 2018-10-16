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
    private String fHD;
    private int fHE;
    private a fHK;
    private List<bb> fHM;
    private int fHN;
    private AlaLiveInfoCoreData fHO;
    private TwzhiboAnti fHR;
    public AppealInfo fHS;
    private List<ay> fHT;
    private List<ay> fHU;
    public String fHW;
    private PostData fHX;
    private f fHY;
    public CardHListViewData fHZ;
    private long fIa;
    private i fIb;
    public String fIc;
    public int fId;
    public int fIe;
    public List<PbSortType> fIf;
    public int fIg;
    private String fIh;
    private String fIi;
    private PostData fIl;
    private boolean fHJ = true;
    private ArrayList<l> fHP = new ArrayList<>();
    private l fHQ = null;
    private ForumData fHy = new ForumData();
    private ay fHz = new ay();
    private bb bIj = new bb();
    private ArrayList<PostData> fHA = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private al eWA = new al();
    private AntiData anH = new AntiData();
    private com.baidu.tbadk.data.f fHB = new com.baidu.tbadk.data.f();
    private int fHC = 0;
    private final UserData fHF = new UserData();
    private List<MuteUser> fHI = new ArrayList();
    private an fHG = new an();
    private ao fHL = new ao();
    private ad fHH = new ad();
    private k fHV = new k();
    private List<au.a> fIj = new ArrayList();
    private HashSet<String> fIk = new HashSet<>();

    public boolean beS() {
        return this.fHJ;
    }

    public void ki(boolean z) {
        this.fHJ = z;
    }

    public d() {
        this.fHE = 0;
        this.fHR = null;
        this.fHE = 0;
        this.fHR = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.fHA != null && this.fHA.size() > 0;
    }

    public String[] cQ(Context context) {
        String str = null;
        String str2 = "";
        if (isValid()) {
            int size = this.fHA.size() > 30 ? 30 : this.fHA.size();
            if (beV() == null || beV().yv() == null || com.baidu.tbadk.core.util.ao.isEmpty(beV().yv().getUserId())) {
                return new String[]{null, ""};
            }
            String userId = beV().yv().getUserId();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                PostData postData = (PostData) v.d(this.fHA, i);
                if (postData != null && postData.yv() != null && !com.baidu.tbadk.core.util.ao.isEmpty(postData.yv().getUserId()) && com.baidu.tbadk.core.util.ao.equals(userId, postData.yv().getUserId())) {
                    if (com.baidu.tbadk.core.util.ao.isEmpty(str)) {
                        str = postData.bCi();
                    }
                    String bCg = com.baidu.tbadk.core.util.ao.isEmpty(str2) ? postData.bCg() : str2;
                    if (!com.baidu.tbadk.core.util.ao.isEmpty(str) && !com.baidu.tbadk.core.util.ao.isEmpty(bCg)) {
                        str2 = bCg;
                        break;
                    }
                    str2 = bCg;
                }
                i++;
                str = str;
            }
            if (com.baidu.tbadk.core.util.ao.isEmpty(str)) {
                str = "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            }
            PostData postData2 = this.fHA.get(0);
            if (this.bIj != null && this.bIj.zh() != null && this.bIj.zh().getGroup_id() != 0) {
                str2 = "[" + context.getString(e.j.photo_live_tips) + "] " + str2;
            }
            if (this.bIj != null && this.bIj.zj() && postData2 != null && postData2.QU() != null) {
                str = postData2.QU().getThumbUrl();
            }
        }
        return new String[]{str, str2};
    }

    public ForumData beT() {
        return this.fHy;
    }

    public ay beU() {
        return this.fHz;
    }

    public String getForumId() {
        if (this.fHy == null) {
            return "";
        }
        return this.fHy.getId();
    }

    public bb beV() {
        return this.bIj;
    }

    public List<bb> beW() {
        return this.fHM;
    }

    public String getThreadId() {
        if (this.bIj == null) {
            return "";
        }
        return this.bIj.getId();
    }

    public ArrayList<PostData> beX() {
        return this.fHA;
    }

    public al xH() {
        return this.eWA;
    }

    public ad beY() {
        return this.fHH;
    }

    public ao beZ() {
        return this.fHL;
    }

    public void a(al alVar, int i) {
        this.eWA.cf(alVar.xB());
        this.eWA.cd(alVar.wO());
        this.eWA.cc(alVar.xy());
        this.eWA.cg(alVar.xC());
        this.eWA.ce(alVar.xA());
        if (i == 0) {
            this.eWA = alVar;
        } else if (i == 1) {
            this.eWA.ch(alVar.xD());
        } else if (i == 2) {
            this.eWA.ci(alVar.xE());
        }
    }

    public AntiData xs() {
        return this.anH;
    }

    public UserData getUserData() {
        return this.fHF;
    }

    public boolean vc() {
        return this.bIj.yE() != 0;
    }

    public void ay(boolean z) {
        if (this.bIj != null) {
            if (z) {
                this.bIj.cr(1);
            } else {
                this.bIj.cr(0);
            }
        }
    }

    public String vb() {
        if (this.bIj != null) {
            return this.bIj.yF();
        }
        return null;
    }

    public void sh(String str) {
        if (this.bIj != null) {
            this.bIj.dX(str);
        }
    }

    public String bfa() {
        return this.fIi;
    }

    public boolean bfb() {
        return (this.bIj == null || this.bIj.yH() == null || this.bIj.yH().size() <= 0 || this.bIj.yH().get(0) == null || !this.bIj.yH().get(0).wP()) ? false : true;
    }

    public PostData bfc() {
        return this.fIl;
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                com.baidu.tieba.recapp.d.a.bua().uf(dataRes.asp_shown_info);
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
                rl(dataRes.is_new_url.intValue());
                this.fHy.parserProtobuf(dataRes.forum);
                this.fHz.parserProtobuf(dataRes.display_forum);
                this.bIj.setUserMap(this.userMap);
                this.bIj.a(dataRes.thread);
                this.bIj.setCurrentPage(2);
                this.fHG.a(dataRes.news_info);
                switch (this.fHG.aob) {
                    case 1:
                        this.fHH.fRZ = this.fHG;
                        break;
                    case 2:
                        this.fHH.fSa = this.fHG;
                        break;
                    case 3:
                        this.fHH.fSb = this.fHG;
                        break;
                    default:
                        this.fHH.fSa = this.fHG;
                        break;
                }
                this.fHL.a(dataRes.recommend_book);
                List<Post> list2 = dataRes.post_list;
                if (list2 != null && list2.size() > 0) {
                    for (Post post : dataRes.post_list) {
                        if (!this.fIk.contains(String.valueOf(post.id))) {
                            PostData postData = new PostData();
                            postData.setUserMap(this.userMap);
                            postData.kk(this.fHy.isBrandForum);
                            postData.a(post, context);
                            postData.a(beV().yi());
                            this.fIk.add(postData.getId());
                            if (postData.bCb() == 1 && this.bIj.za()) {
                                if (bfb()) {
                                    postData.setPostType(0);
                                } else {
                                    postData.setPostType(this.bIj.yZ());
                                }
                            } else if (postData.bCb() == 1 && this.bIj.zn()) {
                                postData.setPostType(41);
                            } else if (postData.bCb() == 1 && this.bIj != null && this.bIj.zj()) {
                                postData.setPostType(0);
                                postData.QU();
                                if (this.bIj.yt() == null || this.bIj.yt().size() == 0) {
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
                                    postData.c(new TbRichText((Context) TbadkCoreApplication.getInst(), this.bIj.yt(), true));
                                }
                                this.fHX = postData;
                            }
                            if (postData.bCb() == 1 && this.bIj != null && this.bIj.isShareThread) {
                                postData.g(this.bIj.arg);
                            }
                            this.fHA.add(postData);
                        }
                    }
                }
                if (dataRes.first_floor_post != null) {
                    this.fIl = new PostData();
                    this.fIl.setUserMap(this.userMap);
                    this.fIl.kk(this.fHy.isBrandForum);
                    this.fIl.a(dataRes.first_floor_post, context);
                    if (this.bIj != null && this.bIj.isShareThread) {
                        this.fIl.g(this.bIj.arg);
                    }
                }
                this.eWA.a(dataRes.page);
                this.anH.parserProtobuf(dataRes.anti);
                this.fHB.a(dataRes.location);
                if (dataRes.user != null) {
                    this.fHC = dataRes.user.is_manager.intValue();
                }
                this.fHF.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.fHI.add(muteUser);
                        }
                    }
                }
                this.bIj.cn(this.bIj.ym() > 0 ? this.bIj.ym() - 1 : 0);
                List<AppData> bti = r.btk().bti();
                if (bti != null) {
                    bti.clear();
                }
                this.fHQ = null;
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        l lVar = new l();
                        lVar.d(app);
                        AppData bBP = lVar.bBP();
                        if (!this.fHP.contains(lVar) && bBP.goods != null && (!StringUtils.isNull(bBP.goods.user_name) || !StringUtils.isNull(bBP.goods.lego_card))) {
                            this.fHP.add(lVar);
                            if (bti != null) {
                                bti.add(lVar.bBP());
                            }
                        }
                    }
                    a(dataRes);
                }
                r.btk().btj();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.fHF.getIsSelectTail());
                }
                this.fHR.parserProtobuf(dataRes.twzhibo_anti);
                this.fHS = dataRes.appeal_info;
                if (dataRes.god_card != null) {
                    this.fHK = new a();
                    this.fHK.a(dataRes.god_card);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.fHY = new f();
                    this.fHY.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.guess_like != null) {
                    this.fHZ = new CardHListViewData();
                    this.fHZ.parseProtobuf(dataRes.guess_like);
                }
                if (dataRes.feed_thread_list != null && dataRes.feed_thread_list.size() > 0) {
                    List<ThreadInfo> list3 = dataRes.feed_thread_list;
                    if (this.fHM == null) {
                        this.fHM = new ArrayList();
                    }
                    this.fHM.clear();
                    for (ThreadInfo threadInfo : list3) {
                        if (threadInfo != null) {
                            bb bbVar = new bb();
                            bbVar.a(threadInfo);
                            this.fHM.add(bbVar);
                        }
                    }
                    if (this.fHM != null && this.fHM.size() > 15) {
                        this.fHM = v.b(this.fHM, 0, 15);
                    }
                }
                this.fHN = dataRes.is_follow_current_channel.intValue();
                if (v.I(dataRes.repost_recommend_forum_list) > 0) {
                    if (this.fHT == null) {
                        this.fHT = new ArrayList();
                    }
                    for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                        ay ayVar = new ay();
                        ayVar.parserProtobuf(simpleForum);
                        this.fHT.add(ayVar);
                    }
                }
                if (v.I(dataRes.from_forum_list) > 0) {
                    if (this.fHU == null) {
                        this.fHU = new ArrayList();
                    }
                    for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                        if (simpleForum2 != null) {
                            ay ayVar2 = new ay();
                            ayVar2.parserProtobuf(simpleForum2);
                            this.fHU.add(ayVar2);
                        }
                    }
                }
                this.fIi = dataRes.multi_forum_text;
                if (dataRes.top_agree_post_list != null && this.fHV != null) {
                    this.fHV.kk(this.fHy.isBrandForum);
                    this.fHV.a(context, dataRes.top_agree_post_list);
                }
                if (this.fIa >= 0) {
                    this.fIa = dataRes.thread_freq_num.longValue();
                }
                this.fIb = new i();
                this.fIb.bIV = this.bIj;
                this.fIb.b(dataRes);
                this.fIc = dataRes.partial_visible_toast;
                if (dataRes.follow_tip != null && dataRes.follow_tip.is_toast_tip.intValue() == 1) {
                    this.fHD = dataRes.follow_tip.tip_text;
                }
                this.fHO = new AlaLiveInfoCoreData();
                if (dataRes.ala_info != null) {
                    this.fHO.parserProtoBuf(dataRes.ala_info);
                }
                this.fIh = dataRes.fold_tip;
                this.fId = dataRes.exp_news_today.intValue();
                this.fIe = dataRes.exp_guide_today.intValue();
                if (!v.J(dataRes.thread_topic)) {
                    for (int i2 = 0; i2 < dataRes.thread_topic.size(); i2++) {
                        au.a aVar = new au.a();
                        aVar.a(dataRes.thread_topic.get(i2));
                        this.fIj.add(aVar);
                    }
                }
                this.fIf = dataRes.pb_sort_info;
                this.fIg = dataRes.sort_type.intValue();
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }

    private void a(DataRes dataRes) {
        App app = dataRes.banner_list.pb_banner_ad;
        l lVar = new l();
        lVar.hcS = true;
        lVar.d(app);
        if (lVar.bBP().goods != null) {
            this.fHQ = lVar;
        }
    }

    public String bfd() {
        return this.fIh;
    }

    public CardHListViewData bfe() {
        return this.fHZ;
    }

    public PostData bff() {
        return this.fHX;
    }

    public PostData d(PostData postData) {
        this.fHX = postData;
        return postData;
    }

    public k bfg() {
        return this.fHV;
    }

    public int bfh() {
        return this.fHC;
    }

    public int bfi() {
        return this.fHE;
    }

    public void rl(int i) {
        this.fHE = i;
    }

    public List<MuteUser> bfj() {
        return this.fHI;
    }

    public ArrayList<l> bfk() {
        return this.fHP;
    }

    public l bfl() {
        return this.fHQ;
    }

    public void bfm() {
        if (this.fHQ.bBP() != null) {
            this.fHQ.bBP().legoCard = null;
        }
        this.fHQ = null;
    }

    public a bfn() {
        return this.fHK;
    }

    public String bfo() {
        return this.fHW;
    }

    public void si(String str) {
        this.fHW = str;
    }

    public f bfp() {
        return this.fHY;
    }

    public int bfq() {
        return this.fHN;
    }

    public List<ay> bfr() {
        return this.fHU;
    }

    public long bfs() {
        return this.fIa;
    }

    public i bft() {
        return this.fIb;
    }

    public boolean bfu() {
        return (beV() == null || !beV().zj() || beV().yN() == null) ? false : true;
    }

    public String bfv() {
        return this.fHD;
    }

    public AlaLiveInfoCoreData bfw() {
        return this.fHO;
    }

    public List<au.a> bfx() {
        return this.fIj;
    }
}

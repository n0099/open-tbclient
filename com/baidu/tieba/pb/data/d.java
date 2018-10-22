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
    private String fHE;
    private int fHF;
    private a fHL;
    private List<bb> fHN;
    private int fHO;
    private AlaLiveInfoCoreData fHP;
    private TwzhiboAnti fHS;
    public AppealInfo fHT;
    private List<ay> fHU;
    private List<ay> fHV;
    public String fHX;
    private PostData fHY;
    private f fHZ;
    public CardHListViewData fIa;
    private long fIb;
    private i fIc;
    public String fId;
    public int fIe;
    public int fIf;
    public List<PbSortType> fIg;
    public int fIh;
    private String fIi;
    private String fIj;
    private PostData fIm;
    private boolean fHK = true;
    private ArrayList<l> fHQ = new ArrayList<>();
    private l fHR = null;
    private ForumData fHz = new ForumData();
    private ay fHA = new ay();
    private bb bIj = new bb();
    private ArrayList<PostData> fHB = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private al eWB = new al();
    private AntiData anH = new AntiData();
    private com.baidu.tbadk.data.f fHC = new com.baidu.tbadk.data.f();
    private int fHD = 0;
    private final UserData fHG = new UserData();
    private List<MuteUser> fHJ = new ArrayList();
    private an fHH = new an();
    private ao fHM = new ao();
    private ad fHI = new ad();
    private k fHW = new k();
    private List<au.a> fIk = new ArrayList();
    private HashSet<String> fIl = new HashSet<>();

    public boolean beS() {
        return this.fHK;
    }

    public void ki(boolean z) {
        this.fHK = z;
    }

    public d() {
        this.fHF = 0;
        this.fHS = null;
        this.fHF = 0;
        this.fHS = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.fHB != null && this.fHB.size() > 0;
    }

    public String[] cQ(Context context) {
        String str = null;
        String str2 = "";
        if (isValid()) {
            int size = this.fHB.size() > 30 ? 30 : this.fHB.size();
            if (beV() == null || beV().yv() == null || com.baidu.tbadk.core.util.ao.isEmpty(beV().yv().getUserId())) {
                return new String[]{null, ""};
            }
            String userId = beV().yv().getUserId();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                PostData postData = (PostData) v.d(this.fHB, i);
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
            PostData postData2 = this.fHB.get(0);
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
        return this.fHz;
    }

    public ay beU() {
        return this.fHA;
    }

    public String getForumId() {
        if (this.fHz == null) {
            return "";
        }
        return this.fHz.getId();
    }

    public bb beV() {
        return this.bIj;
    }

    public List<bb> beW() {
        return this.fHN;
    }

    public String getThreadId() {
        if (this.bIj == null) {
            return "";
        }
        return this.bIj.getId();
    }

    public ArrayList<PostData> beX() {
        return this.fHB;
    }

    public al xH() {
        return this.eWB;
    }

    public ad beY() {
        return this.fHI;
    }

    public ao beZ() {
        return this.fHM;
    }

    public void a(al alVar, int i) {
        this.eWB.cf(alVar.xB());
        this.eWB.cd(alVar.wO());
        this.eWB.cc(alVar.xy());
        this.eWB.cg(alVar.xC());
        this.eWB.ce(alVar.xA());
        if (i == 0) {
            this.eWB = alVar;
        } else if (i == 1) {
            this.eWB.ch(alVar.xD());
        } else if (i == 2) {
            this.eWB.ci(alVar.xE());
        }
    }

    public AntiData xs() {
        return this.anH;
    }

    public UserData getUserData() {
        return this.fHG;
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
        return this.fIj;
    }

    public boolean bfb() {
        return (this.bIj == null || this.bIj.yH() == null || this.bIj.yH().size() <= 0 || this.bIj.yH().get(0) == null || !this.bIj.yH().get(0).wP()) ? false : true;
    }

    public PostData bfc() {
        return this.fIm;
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
                this.fHz.parserProtobuf(dataRes.forum);
                this.fHA.parserProtobuf(dataRes.display_forum);
                this.bIj.setUserMap(this.userMap);
                this.bIj.a(dataRes.thread);
                this.bIj.setCurrentPage(2);
                this.fHH.a(dataRes.news_info);
                switch (this.fHH.aob) {
                    case 1:
                        this.fHI.fSa = this.fHH;
                        break;
                    case 2:
                        this.fHI.fSb = this.fHH;
                        break;
                    case 3:
                        this.fHI.fSc = this.fHH;
                        break;
                    default:
                        this.fHI.fSb = this.fHH;
                        break;
                }
                this.fHM.a(dataRes.recommend_book);
                List<Post> list2 = dataRes.post_list;
                if (list2 != null && list2.size() > 0) {
                    for (Post post : dataRes.post_list) {
                        if (!this.fIl.contains(String.valueOf(post.id))) {
                            PostData postData = new PostData();
                            postData.setUserMap(this.userMap);
                            postData.kk(this.fHz.isBrandForum);
                            postData.a(post, context);
                            postData.a(beV().yi());
                            this.fIl.add(postData.getId());
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
                                this.fHY = postData;
                            }
                            if (postData.bCb() == 1 && this.bIj != null && this.bIj.isShareThread) {
                                postData.g(this.bIj.arg);
                            }
                            this.fHB.add(postData);
                        }
                    }
                }
                if (dataRes.first_floor_post != null) {
                    this.fIm = new PostData();
                    this.fIm.setUserMap(this.userMap);
                    this.fIm.kk(this.fHz.isBrandForum);
                    this.fIm.a(dataRes.first_floor_post, context);
                    if (this.bIj != null && this.bIj.isShareThread) {
                        this.fIm.g(this.bIj.arg);
                    }
                }
                this.eWB.a(dataRes.page);
                this.anH.parserProtobuf(dataRes.anti);
                this.fHC.a(dataRes.location);
                if (dataRes.user != null) {
                    this.fHD = dataRes.user.is_manager.intValue();
                }
                this.fHG.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.fHJ.add(muteUser);
                        }
                    }
                }
                this.bIj.cn(this.bIj.ym() > 0 ? this.bIj.ym() - 1 : 0);
                List<AppData> bti = r.btk().bti();
                if (bti != null) {
                    bti.clear();
                }
                this.fHR = null;
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        l lVar = new l();
                        lVar.d(app);
                        AppData bBP = lVar.bBP();
                        if (!this.fHQ.contains(lVar) && bBP.goods != null && (!StringUtils.isNull(bBP.goods.user_name) || !StringUtils.isNull(bBP.goods.lego_card))) {
                            this.fHQ.add(lVar);
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
                    currentAccountObj.setIsSelectTail(this.fHG.getIsSelectTail());
                }
                this.fHS.parserProtobuf(dataRes.twzhibo_anti);
                this.fHT = dataRes.appeal_info;
                if (dataRes.god_card != null) {
                    this.fHL = new a();
                    this.fHL.a(dataRes.god_card);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.fHZ = new f();
                    this.fHZ.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.guess_like != null) {
                    this.fIa = new CardHListViewData();
                    this.fIa.parseProtobuf(dataRes.guess_like);
                }
                if (dataRes.feed_thread_list != null && dataRes.feed_thread_list.size() > 0) {
                    List<ThreadInfo> list3 = dataRes.feed_thread_list;
                    if (this.fHN == null) {
                        this.fHN = new ArrayList();
                    }
                    this.fHN.clear();
                    for (ThreadInfo threadInfo : list3) {
                        if (threadInfo != null) {
                            bb bbVar = new bb();
                            bbVar.a(threadInfo);
                            this.fHN.add(bbVar);
                        }
                    }
                    if (this.fHN != null && this.fHN.size() > 15) {
                        this.fHN = v.b(this.fHN, 0, 15);
                    }
                }
                this.fHO = dataRes.is_follow_current_channel.intValue();
                if (v.I(dataRes.repost_recommend_forum_list) > 0) {
                    if (this.fHU == null) {
                        this.fHU = new ArrayList();
                    }
                    for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                        ay ayVar = new ay();
                        ayVar.parserProtobuf(simpleForum);
                        this.fHU.add(ayVar);
                    }
                }
                if (v.I(dataRes.from_forum_list) > 0) {
                    if (this.fHV == null) {
                        this.fHV = new ArrayList();
                    }
                    for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                        if (simpleForum2 != null) {
                            ay ayVar2 = new ay();
                            ayVar2.parserProtobuf(simpleForum2);
                            this.fHV.add(ayVar2);
                        }
                    }
                }
                this.fIj = dataRes.multi_forum_text;
                if (dataRes.top_agree_post_list != null && this.fHW != null) {
                    this.fHW.kk(this.fHz.isBrandForum);
                    this.fHW.a(context, dataRes.top_agree_post_list);
                }
                if (this.fIb >= 0) {
                    this.fIb = dataRes.thread_freq_num.longValue();
                }
                this.fIc = new i();
                this.fIc.bIV = this.bIj;
                this.fIc.b(dataRes);
                this.fId = dataRes.partial_visible_toast;
                if (dataRes.follow_tip != null && dataRes.follow_tip.is_toast_tip.intValue() == 1) {
                    this.fHE = dataRes.follow_tip.tip_text;
                }
                this.fHP = new AlaLiveInfoCoreData();
                if (dataRes.ala_info != null) {
                    this.fHP.parserProtoBuf(dataRes.ala_info);
                }
                this.fIi = dataRes.fold_tip;
                this.fIe = dataRes.exp_news_today.intValue();
                this.fIf = dataRes.exp_guide_today.intValue();
                if (!v.J(dataRes.thread_topic)) {
                    for (int i2 = 0; i2 < dataRes.thread_topic.size(); i2++) {
                        au.a aVar = new au.a();
                        aVar.a(dataRes.thread_topic.get(i2));
                        this.fIk.add(aVar);
                    }
                }
                this.fIg = dataRes.pb_sort_info;
                this.fIh = dataRes.sort_type.intValue();
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }

    private void a(DataRes dataRes) {
        App app = dataRes.banner_list.pb_banner_ad;
        l lVar = new l();
        lVar.hcT = true;
        lVar.d(app);
        if (lVar.bBP().goods != null) {
            this.fHR = lVar;
        }
    }

    public String bfd() {
        return this.fIi;
    }

    public CardHListViewData bfe() {
        return this.fIa;
    }

    public PostData bff() {
        return this.fHY;
    }

    public PostData d(PostData postData) {
        this.fHY = postData;
        return postData;
    }

    public k bfg() {
        return this.fHW;
    }

    public int bfh() {
        return this.fHD;
    }

    public int bfi() {
        return this.fHF;
    }

    public void rl(int i) {
        this.fHF = i;
    }

    public List<MuteUser> bfj() {
        return this.fHJ;
    }

    public ArrayList<l> bfk() {
        return this.fHQ;
    }

    public l bfl() {
        return this.fHR;
    }

    public void bfm() {
        if (this.fHR.bBP() != null) {
            this.fHR.bBP().legoCard = null;
        }
        this.fHR = null;
    }

    public a bfn() {
        return this.fHL;
    }

    public String bfo() {
        return this.fHX;
    }

    public void si(String str) {
        this.fHX = str;
    }

    public f bfp() {
        return this.fHZ;
    }

    public int bfq() {
        return this.fHO;
    }

    public List<ay> bfr() {
        return this.fHV;
    }

    public long bfs() {
        return this.fIb;
    }

    public i bft() {
        return this.fIc;
    }

    public boolean bfu() {
        return (beV() == null || !beV().zj() || beV().yN() == null) ? false : true;
    }

    public String bfv() {
        return this.fHE;
    }

    public AlaLiveInfoCoreData bfw() {
        return this.fHP;
    }

    public List<au.a> bfx() {
        return this.fIk;
    }
}

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
    private String fPS;
    private int fPT;
    private a fPZ;
    private PostData fQA;
    private List<bb> fQb;
    private int fQc;
    private AlaLiveInfoCoreData fQd;
    private TwzhiboAnti fQg;
    public AppealInfo fQh;
    private List<ay> fQi;
    private List<ay> fQj;
    public String fQl;
    private PostData fQm;
    private f fQn;
    public CardHListViewData fQo;
    private long fQp;
    private i fQq;
    public String fQr;
    public int fQs;
    public int fQt;
    public List<PbSortType> fQu;
    public int fQv;
    private String fQw;
    private String fQx;
    private boolean fPY = true;
    private ArrayList<l> fQe = new ArrayList<>();
    private l fQf = null;
    private ForumData fPN = new ForumData();
    private ay fPO = new ay();
    private bb bMJ = new bb();
    private ArrayList<PostData> fPP = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private al feI = new al();
    private AntiData arV = new AntiData();
    private com.baidu.tbadk.data.f fPQ = new com.baidu.tbadk.data.f();
    private int fPR = 0;
    private final UserData fPU = new UserData();
    private List<MuteUser> fPX = new ArrayList();
    private an fPV = new an();
    private ao fQa = new ao();
    private ad fPW = new ad();
    private k fQk = new k();
    private List<au.a> fQy = new ArrayList();
    private HashSet<String> fQz = new HashSet<>();

    public boolean bgh() {
        return this.fPY;
    }

    public void kv(boolean z) {
        this.fPY = z;
    }

    public d() {
        this.fPT = 0;
        this.fQg = null;
        this.fPT = 0;
        this.fQg = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.fPP != null && this.fPP.size() > 0;
    }

    public String[] cP(Context context) {
        String str = null;
        String str2 = "";
        if (isValid()) {
            int size = this.fPP.size() > 30 ? 30 : this.fPP.size();
            if (bgk() == null || bgk().zG() == null || com.baidu.tbadk.core.util.ao.isEmpty(bgk().zG().getUserId())) {
                return new String[]{null, ""};
            }
            String userId = bgk().zG().getUserId();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                PostData postData = (PostData) v.d(this.fPP, i);
                if (postData != null && postData.zG() != null && !com.baidu.tbadk.core.util.ao.isEmpty(postData.zG().getUserId()) && com.baidu.tbadk.core.util.ao.equals(userId, postData.zG().getUserId())) {
                    if (com.baidu.tbadk.core.util.ao.isEmpty(str)) {
                        str = postData.bDz();
                    }
                    String bDx = com.baidu.tbadk.core.util.ao.isEmpty(str2) ? postData.bDx() : str2;
                    if (!com.baidu.tbadk.core.util.ao.isEmpty(str) && !com.baidu.tbadk.core.util.ao.isEmpty(bDx)) {
                        str2 = bDx;
                        break;
                    }
                    str2 = bDx;
                }
                i++;
                str = str;
            }
            if (com.baidu.tbadk.core.util.ao.isEmpty(str)) {
                str = "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            }
            PostData postData2 = this.fPP.get(0);
            if (this.bMJ != null && this.bMJ.As() != null && this.bMJ.As().getGroup_id() != 0) {
                str2 = "[" + context.getString(e.j.photo_live_tips) + "] " + str2;
            }
            if (this.bMJ != null && this.bMJ.Au() && postData2 != null && postData2.Sj() != null) {
                str = postData2.Sj().getThumbUrl();
            }
        }
        return new String[]{str, str2};
    }

    public ForumData bgi() {
        return this.fPN;
    }

    public ay bgj() {
        return this.fPO;
    }

    public String getForumId() {
        if (this.fPN == null) {
            return "";
        }
        return this.fPN.getId();
    }

    public bb bgk() {
        return this.bMJ;
    }

    public List<bb> bgl() {
        return this.fQb;
    }

    public String getThreadId() {
        if (this.bMJ == null) {
            return "";
        }
        return this.bMJ.getId();
    }

    public ArrayList<PostData> bgm() {
        return this.fPP;
    }

    public al yS() {
        return this.feI;
    }

    public ad bgn() {
        return this.fPW;
    }

    public ao bgo() {
        return this.fQa;
    }

    public void a(al alVar, int i) {
        this.feI.cI(alVar.yN());
        this.feI.cG(alVar.ya());
        this.feI.cF(alVar.yK());
        this.feI.cJ(alVar.yO());
        this.feI.cH(alVar.yM());
        if (i == 0) {
            this.feI = alVar;
        } else if (i == 1) {
            this.feI.cK(alVar.yP());
        } else if (i == 2) {
            this.feI.cL(alVar.yQ());
        }
    }

    public AntiData yE() {
        return this.arV;
    }

    public UserData getUserData() {
        return this.fPU;
    }

    public boolean wq() {
        return this.bMJ.zP() != 0;
    }

    public void aP(boolean z) {
        if (this.bMJ != null) {
            if (z) {
                this.bMJ.cT(1);
            } else {
                this.bMJ.cT(0);
            }
        }
    }

    public String wp() {
        if (this.bMJ != null) {
            return this.bMJ.zQ();
        }
        return null;
    }

    public void sL(String str) {
        if (this.bMJ != null) {
            this.bMJ.ep(str);
        }
    }

    public String bgp() {
        return this.fQx;
    }

    public boolean bgq() {
        return (this.bMJ == null || this.bMJ.zS() == null || this.bMJ.zS().size() <= 0 || this.bMJ.zS().get(0) == null || !this.bMJ.zS().get(0).yb()) ? false : true;
    }

    public PostData bgr() {
        return this.fQA;
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                com.baidu.tieba.recapp.d.a.bvp().uK(dataRes.asp_shown_info);
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
                rY(dataRes.is_new_url.intValue());
                this.fPN.parserProtobuf(dataRes.forum);
                this.fPO.parserProtobuf(dataRes.display_forum);
                this.bMJ.setUserMap(this.userMap);
                this.bMJ.a(dataRes.thread);
                this.bMJ.setCurrentPage(2);
                this.fPV.a(dataRes.news_info);
                switch (this.fPV.asp) {
                    case 1:
                        this.fPW.gap = this.fPV;
                        break;
                    case 2:
                        this.fPW.gaq = this.fPV;
                        break;
                    case 3:
                        this.fPW.gar = this.fPV;
                        break;
                    default:
                        this.fPW.gaq = this.fPV;
                        break;
                }
                this.fQa.a(dataRes.recommend_book);
                List<Post> list2 = dataRes.post_list;
                if (list2 != null && list2.size() > 0) {
                    for (Post post : dataRes.post_list) {
                        if (!this.fQz.contains(String.valueOf(post.id))) {
                            PostData postData = new PostData();
                            postData.setUserMap(this.userMap);
                            postData.kx(this.fPN.isBrandForum);
                            postData.a(post, context);
                            postData.a(bgk().zt());
                            this.fQz.add(postData.getId());
                            if (postData.bDs() == 1 && this.bMJ.Al()) {
                                if (bgq()) {
                                    postData.setPostType(0);
                                } else {
                                    postData.setPostType(this.bMJ.Ak());
                                }
                            } else if (postData.bDs() == 1 && this.bMJ.Ay()) {
                                postData.setPostType(41);
                            } else if (postData.bDs() == 1 && this.bMJ != null && this.bMJ.Au()) {
                                postData.setPostType(0);
                                postData.Sj();
                                if (this.bMJ.zE() == null || this.bMJ.zE().size() == 0) {
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
                                    postData.c(new TbRichText((Context) TbadkCoreApplication.getInst(), this.bMJ.zE(), true));
                                }
                                this.fQm = postData;
                            }
                            if (postData.bDs() == 1 && this.bMJ != null && this.bMJ.isShareThread) {
                                postData.g(this.bMJ.avt);
                            }
                            this.fPP.add(postData);
                        }
                    }
                }
                if (dataRes.first_floor_post != null) {
                    this.fQA = new PostData();
                    this.fQA.setUserMap(this.userMap);
                    this.fQA.kx(this.fPN.isBrandForum);
                    this.fQA.a(dataRes.first_floor_post, context);
                    if (this.bMJ != null && this.bMJ.isShareThread) {
                        this.fQA.g(this.bMJ.avt);
                    }
                }
                this.feI.a(dataRes.page);
                this.arV.parserProtobuf(dataRes.anti);
                this.fPQ.a(dataRes.location);
                if (dataRes.user != null) {
                    this.fPR = dataRes.user.is_manager.intValue();
                }
                this.fPU.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.fPX.add(muteUser);
                        }
                    }
                }
                this.bMJ.cP(this.bMJ.zx() > 0 ? this.bMJ.zx() - 1 : 0);
                List<AppData> bux = r.buz().bux();
                if (bux != null) {
                    bux.clear();
                }
                this.fQf = null;
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        l lVar = new l();
                        lVar.d(app);
                        AppData bDg = lVar.bDg();
                        if (!this.fQe.contains(lVar) && bDg.goods != null && (!StringUtils.isNull(bDg.goods.user_name) || !StringUtils.isNull(bDg.goods.lego_card))) {
                            this.fQe.add(lVar);
                            if (bux != null) {
                                bux.add(lVar.bDg());
                            }
                        }
                    }
                    a(dataRes);
                }
                r.buz().buy();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.fPU.getIsSelectTail());
                }
                this.fQg.parserProtobuf(dataRes.twzhibo_anti);
                this.fQh = dataRes.appeal_info;
                if (dataRes.god_card != null) {
                    this.fPZ = new a();
                    this.fPZ.a(dataRes.god_card);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.fQn = new f();
                    this.fQn.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.guess_like != null) {
                    this.fQo = new CardHListViewData();
                    this.fQo.parseProtobuf(dataRes.guess_like);
                }
                if (dataRes.feed_thread_list != null && dataRes.feed_thread_list.size() > 0) {
                    List<ThreadInfo> list3 = dataRes.feed_thread_list;
                    if (this.fQb == null) {
                        this.fQb = new ArrayList();
                    }
                    this.fQb.clear();
                    for (ThreadInfo threadInfo : list3) {
                        if (threadInfo != null) {
                            bb bbVar = new bb();
                            bbVar.a(threadInfo);
                            this.fQb.add(bbVar);
                        }
                    }
                    if (this.fQb != null && this.fQb.size() > 15) {
                        this.fQb = v.b(this.fQb, 0, 15);
                    }
                }
                this.fQc = dataRes.is_follow_current_channel.intValue();
                if (v.H(dataRes.repost_recommend_forum_list) > 0) {
                    if (this.fQi == null) {
                        this.fQi = new ArrayList();
                    }
                    for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                        ay ayVar = new ay();
                        ayVar.parserProtobuf(simpleForum);
                        this.fQi.add(ayVar);
                    }
                }
                if (v.H(dataRes.from_forum_list) > 0) {
                    if (this.fQj == null) {
                        this.fQj = new ArrayList();
                    }
                    for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                        if (simpleForum2 != null) {
                            ay ayVar2 = new ay();
                            ayVar2.parserProtobuf(simpleForum2);
                            this.fQj.add(ayVar2);
                        }
                    }
                }
                this.fQx = dataRes.multi_forum_text;
                if (dataRes.top_agree_post_list != null && this.fQk != null) {
                    this.fQk.kx(this.fPN.isBrandForum);
                    this.fQk.a(context, dataRes.top_agree_post_list);
                }
                if (this.fQp >= 0) {
                    this.fQp = dataRes.thread_freq_num.longValue();
                }
                this.fQq = new i();
                this.fQq.bNv = this.bMJ;
                this.fQq.b(dataRes);
                this.fQr = dataRes.partial_visible_toast;
                if (dataRes.follow_tip != null && dataRes.follow_tip.is_toast_tip.intValue() == 1) {
                    this.fPS = dataRes.follow_tip.tip_text;
                }
                this.fQd = new AlaLiveInfoCoreData();
                if (dataRes.ala_info != null) {
                    this.fQd.parserProtoBuf(dataRes.ala_info);
                }
                this.fQw = dataRes.fold_tip;
                this.fQs = dataRes.exp_news_today.intValue();
                this.fQt = dataRes.exp_guide_today.intValue();
                if (!v.I(dataRes.thread_topic)) {
                    for (int i2 = 0; i2 < dataRes.thread_topic.size(); i2++) {
                        au.a aVar = new au.a();
                        aVar.a(dataRes.thread_topic.get(i2));
                        this.fQy.add(aVar);
                    }
                }
                this.fQu = dataRes.pb_sort_info;
                this.fQv = dataRes.sort_type.intValue();
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }

    private void a(DataRes dataRes) {
        App app = dataRes.banner_list.pb_banner_ad;
        l lVar = new l();
        lVar.hlk = true;
        lVar.d(app);
        if (lVar.bDg().goods != null) {
            this.fQf = lVar;
        }
    }

    public String bgs() {
        return this.fQw;
    }

    public CardHListViewData bgt() {
        return this.fQo;
    }

    public PostData bgu() {
        return this.fQm;
    }

    public PostData d(PostData postData) {
        this.fQm = postData;
        return postData;
    }

    public k bgv() {
        return this.fQk;
    }

    public int bgw() {
        return this.fPR;
    }

    public int bgx() {
        return this.fPT;
    }

    public void rY(int i) {
        this.fPT = i;
    }

    public List<MuteUser> bgy() {
        return this.fPX;
    }

    public ArrayList<l> bgz() {
        return this.fQe;
    }

    public l bgA() {
        return this.fQf;
    }

    public void bgB() {
        if (this.fQf.bDg() != null) {
            this.fQf.bDg().legoCard = null;
        }
        this.fQf = null;
    }

    public a bgC() {
        return this.fPZ;
    }

    public String bgD() {
        return this.fQl;
    }

    public void sM(String str) {
        this.fQl = str;
    }

    public f bgE() {
        return this.fQn;
    }

    public int bgF() {
        return this.fQc;
    }

    public List<ay> bgG() {
        return this.fQj;
    }

    public long bgH() {
        return this.fQp;
    }

    public i bgI() {
        return this.fQq;
    }

    public boolean bgJ() {
        return (bgk() == null || !bgk().Au() || bgk().zY() == null) ? false : true;
    }

    public String bgK() {
        return this.fPS;
    }

    public AlaLiveInfoCoreData bgL() {
        return this.fQd;
    }

    public List<au.a> bgM() {
        return this.fQy;
    }
}

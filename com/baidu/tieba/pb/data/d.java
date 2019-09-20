package com.baidu.tieba.pb.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.TwzhiboAnti;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.an;
import com.baidu.tbadk.core.data.ap;
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.pb.pb.main.ad;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.tbadkCore.data.AppData;
import com.baidu.tieba.tbadkCore.data.PostData;
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
/* loaded from: classes4.dex */
public class d {
    private f hKA;
    public CardHListViewData hKB;
    private long hKC;
    private j hKD;
    public String hKE;
    public int hKF;
    public int hKG;
    public List<PbSortType> hKH;
    public int hKI;
    public g hKJ;
    private String hKK;
    private String hKL;
    private PostData hKQ;
    private String hKg;
    private int hKh;
    private a hKm;
    private List<bh> hKo;
    private int hKp;
    private AlaLiveInfoCoreData hKq;
    private TwzhiboAnti hKt;
    public AppealInfo hKu;
    private List<bd> hKv;
    private List<bd> hKw;
    public String hKy;
    private PostData hKz;
    private boolean hKl = true;
    private ArrayList<com.baidu.tieba.tbadkCore.data.m> hKr = new ArrayList<>();
    private com.baidu.tieba.tbadkCore.data.m hKs = null;
    public boolean hKO = false;
    public boolean hKP = false;
    private ForumData forum = new ForumData();
    private bd hKc = new bd();
    private bh dnM = new bh();
    private ArrayList<PostData> hKd = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private an page = new an();
    private AntiData anti = new AntiData();
    private com.baidu.tbadk.data.f hKe = new com.baidu.tbadk.data.f();
    private int hKf = 0;
    private final UserData userData = new UserData();
    private List<MuteUser> hKk = new ArrayList();
    private ap hKi = new ap();
    private aq hKn = new aq();
    private ad hKj = new ad();
    private m hKx = new m();
    private List<az.a> hKM = new ArrayList();
    private HashSet<String> hKN = new HashSet<>();

    public boolean bTw() {
        return this.hKl;
    }

    public void oh(boolean z) {
        this.hKl = z;
    }

    public d() {
        this.hKh = 0;
        this.hKt = null;
        this.hKh = 0;
        this.hKt = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.hKd != null && this.hKd.size() > 0;
    }

    public String[] ed(Context context) {
        String str = null;
        String str2 = "";
        if (isValid()) {
            int size = this.hKd.size() > 30 ? 30 : this.hKd.size();
            if (bTy() == null || bTy().aeC() == null || com.baidu.tbadk.core.util.aq.isEmpty(bTy().aeC().getUserId())) {
                return new String[]{null, ""};
            }
            String userId = bTy().aeC().getUserId();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                PostData postData = (PostData) v.c(this.hKd, i);
                if (postData != null && postData.aeC() != null && !com.baidu.tbadk.core.util.aq.isEmpty(postData.aeC().getUserId()) && com.baidu.tbadk.core.util.aq.bV(userId, postData.aeC().getUserId())) {
                    if (com.baidu.tbadk.core.util.aq.isEmpty(str)) {
                        str = postData.cqG();
                    }
                    String cqE = com.baidu.tbadk.core.util.aq.isEmpty(str2) ? postData.cqE() : str2;
                    if (!com.baidu.tbadk.core.util.aq.isEmpty(str) && !com.baidu.tbadk.core.util.aq.isEmpty(cqE)) {
                        str2 = cqE;
                        break;
                    }
                    str2 = cqE;
                }
                i++;
                str = str;
            }
            if (com.baidu.tbadk.core.util.aq.isEmpty(str)) {
                str = "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            }
            PostData postData2 = this.hKd.get(0);
            if (this.dnM != null && this.dnM.afu() != null && this.dnM.afu().getGroup_id() != 0) {
                str2 = "[" + context.getString(R.string.photo_live_tips) + "] " + str2;
            }
            if (this.dnM != null && this.dnM.afw() && postData2 != null && postData2.azk() != null) {
                str = postData2.azk().getThumbUrl();
            }
        }
        return new String[]{str, str2};
    }

    public ForumData getForum() {
        return this.forum;
    }

    public bd bTx() {
        return this.hKc;
    }

    public String getForumId() {
        if (this.forum == null) {
            return "";
        }
        return this.forum.getId();
    }

    public bh bTy() {
        return this.dnM;
    }

    public List<bh> bTz() {
        return this.hKo;
    }

    public String getThreadId() {
        if (this.dnM == null) {
            return "";
        }
        return this.dnM.getId();
    }

    public ArrayList<PostData> bTA() {
        return this.hKd;
    }

    public an getPage() {
        return this.page;
    }

    public ad bTB() {
        return this.hKj;
    }

    public aq bTC() {
        return this.hKn;
    }

    public void a(an anVar, int i) {
        this.page.hb(anVar.adu());
        this.page.gZ(anVar.acJ());
        this.page.gY(anVar.adr());
        this.page.hc(anVar.adv());
        this.page.ha(anVar.adt());
        if (i == 0) {
            this.page = anVar;
        } else if (i == 1) {
            this.page.hd(anVar.adw());
        } else if (i == 2) {
            this.page.he(anVar.adx());
        }
    }

    public AntiData getAnti() {
        return this.anti;
    }

    public UserData getUserData() {
        return this.userData;
    }

    public boolean aaF() {
        return this.dnM.aeK() != 0;
    }

    public void dx(boolean z) {
        if (this.dnM != null) {
            if (z) {
                this.dnM.hn(1);
            } else {
                this.dnM.hn(0);
            }
        }
    }

    public String aaE() {
        if (this.dnM != null) {
            return this.dnM.aeL();
        }
        return null;
    }

    public void Cj(String str) {
        if (this.dnM != null) {
            this.dnM.mE(str);
        }
    }

    public String bTD() {
        return this.hKL;
    }

    public boolean bTE() {
        return (this.dnM == null || this.dnM.aeN() == null || this.dnM.aeN().size() <= 0 || this.dnM.aeN().get(0) == null || !this.dnM.aeN().get(0).acK()) ? false : true;
    }

    public PostData bTF() {
        return this.hKQ;
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                com.baidu.tieba.recapp.d.a.cjz().Es(dataRes.asp_shown_info);
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
                setIsNewUrl(dataRes.is_new_url.intValue());
                this.forum.parserProtobuf(dataRes.forum);
                this.hKc.parserProtobuf(dataRes.display_forum);
                this.dnM.setUserMap(this.userMap);
                this.dnM.a(dataRes.thread);
                this.dnM.setCurrentPage(2);
                this.hKi.a(dataRes.news_info);
                switch (this.hKi.bIw) {
                    case 1:
                        this.hKj.hUK = this.hKi;
                        break;
                    case 2:
                        this.hKj.hUL = this.hKi;
                        break;
                    case 3:
                        this.hKj.hUM = this.hKi;
                        break;
                    default:
                        this.hKj.hUL = this.hKi;
                        break;
                }
                this.hKn.a(dataRes.recommend_book);
                List<Post> list2 = dataRes.post_list;
                if (list2 != null && list2.size() > 0) {
                    for (Post post : dataRes.post_list) {
                        if (!this.hKN.contains(String.valueOf(post.id))) {
                            PostData postData = new PostData();
                            postData.setUserMap(this.userMap);
                            postData.rd(this.forum.isBrandForum);
                            postData.a(post, context);
                            postData.a(bTy().aeo());
                            this.hKN.add(postData.getId());
                            if (postData.cqz() == 1 && this.dnM.afn()) {
                                if (bTE()) {
                                    postData.setPostType(0);
                                } else {
                                    postData.setPostType(this.dnM.afm());
                                }
                            } else if (postData.cqz() == 1 && this.dnM.afC()) {
                                postData.setPostType(41);
                            } else if (postData.cqz() == 1 && this.dnM != null && this.dnM.afw()) {
                                postData.setPostType(0);
                                postData.azk();
                                if (this.dnM.aeA() == null || this.dnM.aeA().size() == 0) {
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
                                    postData.c(new TbRichText((Context) TbadkCoreApplication.getInst(), this.dnM.aeA(), true));
                                }
                                this.hKz = postData;
                            }
                            if (postData.cqz() == 1 && this.dnM != null && this.dnM.isShareThread) {
                                postData.g(this.dnM.bMt);
                            }
                            this.hKd.add(postData);
                        }
                    }
                }
                if (dataRes.first_floor_post != null) {
                    this.hKQ = new PostData();
                    this.hKQ.setUserMap(this.userMap);
                    this.hKQ.rd(this.forum.isBrandForum);
                    this.hKQ.a(dataRes.first_floor_post, context);
                    if (this.dnM != null && this.dnM.isShareThread) {
                        this.hKQ.g(this.dnM.bMt);
                    }
                }
                this.page.a(dataRes.page);
                this.anti.parserProtobuf(dataRes.anti);
                this.hKe.a(dataRes.location);
                if (dataRes.user != null) {
                    this.hKf = dataRes.user.is_manager.intValue();
                }
                this.userData.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.hKk.add(muteUser);
                        }
                    }
                }
                this.dnM.hj(this.dnM.aet() > 0 ? this.dnM.aet() - 1 : 0);
                List<AppData> ciH = r.ciJ().ciH();
                if (ciH != null) {
                    ciH.clear();
                }
                this.hKs = null;
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        com.baidu.tieba.tbadkCore.data.m mVar = new com.baidu.tieba.tbadkCore.data.m();
                        mVar.d(app);
                        AppData cqn = mVar.cqn();
                        if (!this.hKr.contains(mVar) && cqn.goods != null && (!StringUtils.isNull(cqn.goods.user_name) || !StringUtils.isNull(cqn.goods.lego_card))) {
                            this.hKr.add(mVar);
                            if (ciH != null) {
                                ciH.add(mVar.cqn());
                            }
                        }
                    }
                    a(dataRes);
                }
                r.ciJ().ciI();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.userData.getIsSelectTail());
                }
                this.hKt.parserProtobuf(dataRes.twzhibo_anti);
                this.hKu = dataRes.appeal_info;
                if (dataRes.god_card != null) {
                    this.hKm = new a();
                    this.hKm.a(dataRes.god_card);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.hKA = new f();
                    this.hKA.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.guess_like != null) {
                    this.hKB = new CardHListViewData();
                    this.hKB.parseProtobuf(dataRes.guess_like);
                }
                if (dataRes.feed_thread_list != null && dataRes.feed_thread_list.size() > 0) {
                    List<ThreadInfo> list3 = dataRes.feed_thread_list;
                    if (this.hKo == null) {
                        this.hKo = new ArrayList();
                    }
                    this.hKo.clear();
                    for (ThreadInfo threadInfo : list3) {
                        if (threadInfo != null) {
                            bh bhVar = new bh();
                            bhVar.a(threadInfo);
                            this.hKo.add(bhVar);
                        }
                    }
                    if (this.hKo != null && this.hKo.size() > 15) {
                        this.hKo = v.c(this.hKo, 0, 15);
                    }
                }
                this.hKp = dataRes.is_follow_current_channel.intValue();
                if (v.Z(dataRes.repost_recommend_forum_list) > 0) {
                    if (this.hKv == null) {
                        this.hKv = new ArrayList();
                    }
                    for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                        bd bdVar = new bd();
                        bdVar.parserProtobuf(simpleForum);
                        this.hKv.add(bdVar);
                    }
                }
                if (v.Z(dataRes.from_forum_list) > 0) {
                    if (this.hKw == null) {
                        this.hKw = new ArrayList();
                    }
                    for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                        if (simpleForum2 != null) {
                            bd bdVar2 = new bd();
                            bdVar2.parserProtobuf(simpleForum2);
                            this.hKw.add(bdVar2);
                        }
                    }
                }
                this.hKL = dataRes.multi_forum_text;
                if (this.hKC >= 0) {
                    this.hKC = dataRes.thread_freq_num.longValue();
                }
                this.hKD = new j();
                this.hKD.cdk = this.dnM;
                this.hKD.b(dataRes);
                this.hKE = dataRes.partial_visible_toast;
                if (dataRes.follow_tip != null && dataRes.follow_tip.is_toast_tip.intValue() == 1) {
                    this.hKg = dataRes.follow_tip.tip_text;
                }
                this.hKq = new AlaLiveInfoCoreData();
                if (dataRes.ala_info != null) {
                    this.hKq.parserProtoBuf(dataRes.ala_info);
                }
                this.hKK = dataRes.fold_tip;
                this.hKF = dataRes.exp_news_today.intValue();
                this.hKG = dataRes.exp_guide_today.intValue();
                if (!v.aa(dataRes.thread_topic)) {
                    for (int i2 = 0; i2 < dataRes.thread_topic.size(); i2++) {
                        az.a aVar = new az.a();
                        aVar.a(dataRes.thread_topic.get(i2));
                        this.hKM.add(aVar);
                    }
                }
                this.hKH = dataRes.pb_sort_info;
                this.hKI = dataRes.sort_type.intValue();
                if (dataRes.manager_election != null) {
                    this.hKJ = g.a(dataRes.manager_election);
                }
                if (dataRes.business_promot_info != null) {
                    this.hKO = dataRes.business_promot_info.is_promot.longValue() == 1;
                    this.hKP = dataRes.business_promot_info.is_headlinepost.intValue() == 1;
                }
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }

    private void a(DataRes dataRes) {
        List<String> mq;
        App app = dataRes.banner_list.pb_banner_ad;
        com.baidu.tieba.tbadkCore.data.m mVar = new com.baidu.tieba.tbadkCore.data.m();
        mVar.jix = true;
        mVar.d(app);
        AppData cqn = mVar.cqn();
        if (cqn.goods != null) {
            if (v.aa(cqn.goods.thread_pic_list) && (mq = AdvertAppInfo.a.mq(cqn.goods.lego_card)) != null && cqn.goods.thread_pic_list != null) {
                cqn.goods.thread_pic_list.addAll(mq);
            }
            this.hKs = mVar;
        }
    }

    public String bTG() {
        return this.hKK;
    }

    public CardHListViewData bTH() {
        return this.hKB;
    }

    public PostData bTI() {
        return this.hKz;
    }

    public PostData d(PostData postData) {
        this.hKz = postData;
        return postData;
    }

    public m bTJ() {
        return this.hKx;
    }

    public int bTK() {
        return this.hKf;
    }

    public int getIsNewUrl() {
        return this.hKh;
    }

    public void setIsNewUrl(int i) {
        this.hKh = i;
    }

    public List<MuteUser> bTL() {
        return this.hKk;
    }

    public ArrayList<com.baidu.tieba.tbadkCore.data.m> bTM() {
        return this.hKr;
    }

    public com.baidu.tieba.tbadkCore.data.m bTN() {
        return this.hKs;
    }

    public void b(com.baidu.tieba.tbadkCore.data.m mVar) {
        this.hKs = mVar;
    }

    public void bTO() {
        if (this.hKs.cqn() != null) {
            this.hKs.cqn().legoCard = null;
        }
        this.hKs = null;
    }

    public a bTP() {
        return this.hKm;
    }

    public String bTQ() {
        return this.hKy;
    }

    public void Ck(String str) {
        this.hKy = str;
    }

    public f bTR() {
        return this.hKA;
    }

    public int bTS() {
        return this.hKp;
    }

    public List<bd> bTT() {
        return this.hKw;
    }

    public long bTU() {
        return this.hKC;
    }

    public j bTV() {
        return this.hKD;
    }

    public boolean bTW() {
        return (bTy() == null || !bTy().afw() || bTy().aeT() == null) ? false : true;
    }

    public AlaLiveInfoCoreData bTX() {
        return this.hKq;
    }
}

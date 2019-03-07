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
import com.baidu.tbadk.core.data.ay;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.ad;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.tbadkCore.data.AppData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.data.m;
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
    private String hjU;
    private int hjV;
    private PostData hkB;
    private a hka;
    private List<bg> hkc;
    private int hkd;
    private AlaLiveInfoCoreData hke;
    private TwzhiboAnti hkh;
    public AppealInfo hki;
    private List<bc> hkj;
    private List<bc> hkk;
    public String hkm;
    private PostData hkn;
    private f hko;
    public CardHListViewData hkp;
    private long hkq;
    private i hkr;
    public String hks;
    public int hkt;
    public int hku;
    public List<PbSortType> hkv;
    public int hkw;
    private String hkx;
    private String hky;
    private boolean hjZ = true;
    private ArrayList<m> hkf = new ArrayList<>();
    private m hkg = null;
    private ForumData forum = new ForumData();
    private bc hjQ = new bc();
    private bg cZD = new bg();
    private ArrayList<PostData> hjR = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private an page = new an();
    private AntiData anti = new AntiData();
    private com.baidu.tbadk.data.f hjS = new com.baidu.tbadk.data.f();
    private int hjT = 0;
    private final UserData userData = new UserData();
    private List<MuteUser> hjY = new ArrayList();
    private ap hjW = new ap();
    private aq hkb = new aq();
    private ad hjX = new ad();
    private k hkl = new k();
    private List<ay.a> hkz = new ArrayList();
    private HashSet<String> hkA = new HashSet<>();

    public boolean bHX() {
        return this.hjZ;
    }

    public void mZ(boolean z) {
        this.hjZ = z;
    }

    public d() {
        this.hjV = 0;
        this.hkh = null;
        this.hjV = 0;
        this.hkh = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.hjR != null && this.hjR.size() > 0;
    }

    public String[] el(Context context) {
        String str = null;
        String str2 = "";
        if (isValid()) {
            int size = this.hjR.size() > 30 ? 30 : this.hjR.size();
            if (bHZ() == null || bHZ().YR() == null || com.baidu.tbadk.core.util.ap.isEmpty(bHZ().YR().getUserId())) {
                return new String[]{null, ""};
            }
            String userId = bHZ().YR().getUserId();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                PostData postData = (PostData) v.c(this.hjR, i);
                if (postData != null && postData.YR() != null && !com.baidu.tbadk.core.util.ap.isEmpty(postData.YR().getUserId()) && com.baidu.tbadk.core.util.ap.equals(userId, postData.YR().getUserId())) {
                    if (com.baidu.tbadk.core.util.ap.isEmpty(str)) {
                        str = postData.cex();
                    }
                    String cev = com.baidu.tbadk.core.util.ap.isEmpty(str2) ? postData.cev() : str2;
                    if (!com.baidu.tbadk.core.util.ap.isEmpty(str) && !com.baidu.tbadk.core.util.ap.isEmpty(cev)) {
                        str2 = cev;
                        break;
                    }
                    str2 = cev;
                }
                i++;
                str = str;
            }
            if (com.baidu.tbadk.core.util.ap.isEmpty(str)) {
                str = "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            }
            PostData postData2 = this.hjR.get(0);
            if (this.cZD != null && this.cZD.ZJ() != null && this.cZD.ZJ().getGroup_id() != 0) {
                str2 = "[" + context.getString(d.j.photo_live_tips) + "] " + str2;
            }
            if (this.cZD != null && this.cZD.ZL() && postData2 != null && postData2.asH() != null) {
                str = postData2.asH().getThumbUrl();
            }
        }
        return new String[]{str, str2};
    }

    public ForumData getForum() {
        return this.forum;
    }

    public bc bHY() {
        return this.hjQ;
    }

    public String getForumId() {
        if (this.forum == null) {
            return "";
        }
        return this.forum.getId();
    }

    public bg bHZ() {
        return this.cZD;
    }

    public List<bg> bIa() {
        return this.hkc;
    }

    public String getThreadId() {
        if (this.cZD == null) {
            return "";
        }
        return this.cZD.getId();
    }

    public ArrayList<PostData> bIb() {
        return this.hjR;
    }

    public an getPage() {
        return this.page;
    }

    public ad bIc() {
        return this.hjX;
    }

    public aq bId() {
        return this.hkb;
    }

    public void a(an anVar, int i) {
        this.page.gk(anVar.XI());
        this.page.gi(anVar.WY());
        this.page.gh(anVar.XF());
        this.page.gl(anVar.XJ());
        this.page.gj(anVar.XH());
        if (i == 0) {
            this.page = anVar;
        } else if (i == 1) {
            this.page.gm(anVar.XK());
        } else if (i == 2) {
            this.page.gn(anVar.XL());
        }
    }

    public AntiData getAnti() {
        return this.anti;
    }

    public UserData getUserData() {
        return this.userData;
    }

    public boolean Vb() {
        return this.cZD.YZ() != 0;
    }

    public void cZ(boolean z) {
        if (this.cZD != null) {
            if (z) {
                this.cZD.gv(1);
            } else {
                this.cZD.gv(0);
            }
        }
    }

    public String Va() {
        if (this.cZD != null) {
            return this.cZD.Za();
        }
        return null;
    }

    public void zH(String str) {
        if (this.cZD != null) {
            this.cZD.lm(str);
        }
    }

    public String bIe() {
        return this.hky;
    }

    public boolean bIf() {
        return (this.cZD == null || this.cZD.Zc() == null || this.cZD.Zc().size() <= 0 || this.cZD.Zc().get(0) == null || !this.cZD.Zc().get(0).WZ()) ? false : true;
    }

    public PostData bIg() {
        return this.hkB;
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                com.baidu.tieba.recapp.d.a.bXw().BI(dataRes.asp_shown_info);
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
                this.hjQ.parserProtobuf(dataRes.display_forum);
                this.cZD.setUserMap(this.userMap);
                this.cZD.a(dataRes.thread);
                this.cZD.setCurrentPage(2);
                this.hjW.a(dataRes.news_info);
                switch (this.hjW.bzE) {
                    case 1:
                        this.hjX.hup = this.hjW;
                        break;
                    case 2:
                        this.hjX.huq = this.hjW;
                        break;
                    case 3:
                        this.hjX.hur = this.hjW;
                        break;
                    default:
                        this.hjX.huq = this.hjW;
                        break;
                }
                this.hkb.a(dataRes.recommend_book);
                List<Post> list2 = dataRes.post_list;
                if (list2 != null && list2.size() > 0) {
                    for (Post post : dataRes.post_list) {
                        if (!this.hkA.contains(String.valueOf(post.id))) {
                            PostData postData = new PostData();
                            postData.setUserMap(this.userMap);
                            postData.pU(this.forum.isBrandForum);
                            postData.a(post, context);
                            postData.a(bHZ().YD());
                            this.hkA.add(postData.getId());
                            if (postData.ceq() == 1 && this.cZD.ZC()) {
                                if (bIf()) {
                                    postData.setPostType(0);
                                } else {
                                    postData.setPostType(this.cZD.ZB());
                                }
                            } else if (postData.ceq() == 1 && this.cZD.ZR()) {
                                postData.setPostType(41);
                            } else if (postData.ceq() == 1 && this.cZD != null && this.cZD.ZL()) {
                                postData.setPostType(0);
                                postData.asH();
                                if (this.cZD.YP() == null || this.cZD.YP().size() == 0) {
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
                                    postData.c(new TbRichText((Context) TbadkCoreApplication.getInst(), this.cZD.YP(), true));
                                }
                                this.hkn = postData;
                            }
                            if (postData.ceq() == 1 && this.cZD != null && this.cZD.isShareThread) {
                                postData.g(this.cZD.bDt);
                            }
                            this.hjR.add(postData);
                        }
                    }
                }
                if (dataRes.first_floor_post != null) {
                    this.hkB = new PostData();
                    this.hkB.setUserMap(this.userMap);
                    this.hkB.pU(this.forum.isBrandForum);
                    this.hkB.a(dataRes.first_floor_post, context);
                    if (this.cZD != null && this.cZD.isShareThread) {
                        this.hkB.g(this.cZD.bDt);
                    }
                }
                this.page.a(dataRes.page);
                this.anti.parserProtobuf(dataRes.anti);
                this.hjS.a(dataRes.location);
                if (dataRes.user != null) {
                    this.hjT = dataRes.user.is_manager.intValue();
                }
                this.userData.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.hjY.add(muteUser);
                        }
                    }
                }
                this.cZD.gr(this.cZD.YI() > 0 ? this.cZD.YI() - 1 : 0);
                List<AppData> bWE = r.bWG().bWE();
                if (bWE != null) {
                    bWE.clear();
                }
                this.hkg = null;
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        m mVar = new m();
                        mVar.d(app);
                        AppData cee = mVar.cee();
                        if (!this.hkf.contains(mVar) && cee.goods != null && (!StringUtils.isNull(cee.goods.user_name) || !StringUtils.isNull(cee.goods.lego_card))) {
                            this.hkf.add(mVar);
                            if (bWE != null) {
                                bWE.add(mVar.cee());
                            }
                        }
                    }
                    a(dataRes);
                }
                r.bWG().bWF();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.userData.getIsSelectTail());
                }
                this.hkh.parserProtobuf(dataRes.twzhibo_anti);
                this.hki = dataRes.appeal_info;
                if (dataRes.god_card != null) {
                    this.hka = new a();
                    this.hka.a(dataRes.god_card);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.hko = new f();
                    this.hko.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.guess_like != null) {
                    this.hkp = new CardHListViewData();
                    this.hkp.parseProtobuf(dataRes.guess_like);
                }
                if (dataRes.feed_thread_list != null && dataRes.feed_thread_list.size() > 0) {
                    List<ThreadInfo> list3 = dataRes.feed_thread_list;
                    if (this.hkc == null) {
                        this.hkc = new ArrayList();
                    }
                    this.hkc.clear();
                    for (ThreadInfo threadInfo : list3) {
                        if (threadInfo != null) {
                            bg bgVar = new bg();
                            bgVar.a(threadInfo);
                            this.hkc.add(bgVar);
                        }
                    }
                    if (this.hkc != null && this.hkc.size() > 15) {
                        this.hkc = v.c(this.hkc, 0, 15);
                    }
                }
                this.hkd = dataRes.is_follow_current_channel.intValue();
                if (v.S(dataRes.repost_recommend_forum_list) > 0) {
                    if (this.hkj == null) {
                        this.hkj = new ArrayList();
                    }
                    for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                        bc bcVar = new bc();
                        bcVar.parserProtobuf(simpleForum);
                        this.hkj.add(bcVar);
                    }
                }
                if (v.S(dataRes.from_forum_list) > 0) {
                    if (this.hkk == null) {
                        this.hkk = new ArrayList();
                    }
                    for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                        if (simpleForum2 != null) {
                            bc bcVar2 = new bc();
                            bcVar2.parserProtobuf(simpleForum2);
                            this.hkk.add(bcVar2);
                        }
                    }
                }
                this.hky = dataRes.multi_forum_text;
                if (this.hkq >= 0) {
                    this.hkq = dataRes.thread_freq_num.longValue();
                }
                this.hkr = new i();
                this.hkr.bTk = this.cZD;
                this.hkr.b(dataRes);
                this.hks = dataRes.partial_visible_toast;
                if (dataRes.follow_tip != null && dataRes.follow_tip.is_toast_tip.intValue() == 1) {
                    this.hjU = dataRes.follow_tip.tip_text;
                }
                this.hke = new AlaLiveInfoCoreData();
                if (dataRes.ala_info != null) {
                    this.hke.parserProtoBuf(dataRes.ala_info);
                }
                this.hkx = dataRes.fold_tip;
                this.hkt = dataRes.exp_news_today.intValue();
                this.hku = dataRes.exp_guide_today.intValue();
                if (!v.T(dataRes.thread_topic)) {
                    for (int i2 = 0; i2 < dataRes.thread_topic.size(); i2++) {
                        ay.a aVar = new ay.a();
                        aVar.a(dataRes.thread_topic.get(i2));
                        this.hkz.add(aVar);
                    }
                }
                this.hkv = dataRes.pb_sort_info;
                this.hkw = dataRes.sort_type.intValue();
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }

    private void a(DataRes dataRes) {
        List<String> kY;
        App app = dataRes.banner_list.pb_banner_ad;
        m mVar = new m();
        mVar.iGg = true;
        mVar.d(app);
        AppData cee = mVar.cee();
        if (cee.goods != null) {
            if (v.T(cee.goods.thread_pic_list) && (kY = AdvertAppInfo.a.kY(cee.goods.lego_card)) != null && cee.goods.thread_pic_list != null) {
                cee.goods.thread_pic_list.addAll(kY);
            }
            this.hkg = mVar;
        }
    }

    public String bIh() {
        return this.hkx;
    }

    public CardHListViewData bIi() {
        return this.hkp;
    }

    public PostData bIj() {
        return this.hkn;
    }

    public PostData d(PostData postData) {
        this.hkn = postData;
        return postData;
    }

    public k bIk() {
        return this.hkl;
    }

    public int bIl() {
        return this.hjT;
    }

    public int getIsNewUrl() {
        return this.hjV;
    }

    public void setIsNewUrl(int i) {
        this.hjV = i;
    }

    public List<MuteUser> bIm() {
        return this.hjY;
    }

    public ArrayList<m> bIn() {
        return this.hkf;
    }

    public m bIo() {
        return this.hkg;
    }

    public void b(m mVar) {
        this.hkg = mVar;
    }

    public void bIp() {
        if (this.hkg.cee() != null) {
            this.hkg.cee().legoCard = null;
        }
        this.hkg = null;
    }

    public a bIq() {
        return this.hka;
    }

    public String bIr() {
        return this.hkm;
    }

    public void zI(String str) {
        this.hkm = str;
    }

    public f bIs() {
        return this.hko;
    }

    public int bIt() {
        return this.hkd;
    }

    public List<bc> bIu() {
        return this.hkk;
    }

    public long bIv() {
        return this.hkq;
    }

    public i bIw() {
        return this.hkr;
    }

    public boolean bIx() {
        return (bHZ() == null || !bHZ().ZL() || bHZ().Zi() == null) ? false : true;
    }

    public AlaLiveInfoCoreData bIy() {
        return this.hke;
    }
}

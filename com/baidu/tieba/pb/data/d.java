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
    private String hjV;
    private int hjW;
    private PostData hkC;
    private a hkb;
    private List<bg> hkd;
    private int hke;
    private AlaLiveInfoCoreData hkf;
    private TwzhiboAnti hki;
    public AppealInfo hkj;
    private List<bc> hkk;
    private List<bc> hkl;
    public String hkn;
    private PostData hko;
    private f hkp;
    public CardHListViewData hkq;
    private long hkr;
    private i hks;
    public String hkt;
    public int hku;
    public int hkv;
    public List<PbSortType> hkw;
    public int hkx;
    private String hky;
    private String hkz;
    private boolean hka = true;
    private ArrayList<m> hkg = new ArrayList<>();
    private m hkh = null;
    private ForumData forum = new ForumData();
    private bc hjR = new bc();
    private bg cZD = new bg();
    private ArrayList<PostData> hjS = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private an page = new an();
    private AntiData anti = new AntiData();
    private com.baidu.tbadk.data.f hjT = new com.baidu.tbadk.data.f();
    private int hjU = 0;
    private final UserData userData = new UserData();
    private List<MuteUser> hjZ = new ArrayList();
    private ap hjX = new ap();
    private aq hkc = new aq();
    private ad hjY = new ad();
    private k hkm = new k();
    private List<ay.a> hkA = new ArrayList();
    private HashSet<String> hkB = new HashSet<>();

    public boolean bHY() {
        return this.hka;
    }

    public void mZ(boolean z) {
        this.hka = z;
    }

    public d() {
        this.hjW = 0;
        this.hki = null;
        this.hjW = 0;
        this.hki = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.hjS != null && this.hjS.size() > 0;
    }

    public String[] el(Context context) {
        String str = null;
        String str2 = "";
        if (isValid()) {
            int size = this.hjS.size() > 30 ? 30 : this.hjS.size();
            if (bIa() == null || bIa().YR() == null || com.baidu.tbadk.core.util.ap.isEmpty(bIa().YR().getUserId())) {
                return new String[]{null, ""};
            }
            String userId = bIa().YR().getUserId();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                PostData postData = (PostData) v.c(this.hjS, i);
                if (postData != null && postData.YR() != null && !com.baidu.tbadk.core.util.ap.isEmpty(postData.YR().getUserId()) && com.baidu.tbadk.core.util.ap.equals(userId, postData.YR().getUserId())) {
                    if (com.baidu.tbadk.core.util.ap.isEmpty(str)) {
                        str = postData.cey();
                    }
                    String cew = com.baidu.tbadk.core.util.ap.isEmpty(str2) ? postData.cew() : str2;
                    if (!com.baidu.tbadk.core.util.ap.isEmpty(str) && !com.baidu.tbadk.core.util.ap.isEmpty(cew)) {
                        str2 = cew;
                        break;
                    }
                    str2 = cew;
                }
                i++;
                str = str;
            }
            if (com.baidu.tbadk.core.util.ap.isEmpty(str)) {
                str = "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            }
            PostData postData2 = this.hjS.get(0);
            if (this.cZD != null && this.cZD.ZJ() != null && this.cZD.ZJ().getGroup_id() != 0) {
                str2 = "[" + context.getString(d.j.photo_live_tips) + "] " + str2;
            }
            if (this.cZD != null && this.cZD.ZL() && postData2 != null && postData2.asI() != null) {
                str = postData2.asI().getThumbUrl();
            }
        }
        return new String[]{str, str2};
    }

    public ForumData getForum() {
        return this.forum;
    }

    public bc bHZ() {
        return this.hjR;
    }

    public String getForumId() {
        if (this.forum == null) {
            return "";
        }
        return this.forum.getId();
    }

    public bg bIa() {
        return this.cZD;
    }

    public List<bg> bIb() {
        return this.hkd;
    }

    public String getThreadId() {
        if (this.cZD == null) {
            return "";
        }
        return this.cZD.getId();
    }

    public ArrayList<PostData> bIc() {
        return this.hjS;
    }

    public an getPage() {
        return this.page;
    }

    public ad bId() {
        return this.hjY;
    }

    public aq bIe() {
        return this.hkc;
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

    public void zI(String str) {
        if (this.cZD != null) {
            this.cZD.lm(str);
        }
    }

    public String bIf() {
        return this.hkz;
    }

    public boolean bIg() {
        return (this.cZD == null || this.cZD.Zc() == null || this.cZD.Zc().size() <= 0 || this.cZD.Zc().get(0) == null || !this.cZD.Zc().get(0).WZ()) ? false : true;
    }

    public PostData bIh() {
        return this.hkC;
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                com.baidu.tieba.recapp.d.a.bXx().BJ(dataRes.asp_shown_info);
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
                this.hjR.parserProtobuf(dataRes.display_forum);
                this.cZD.setUserMap(this.userMap);
                this.cZD.a(dataRes.thread);
                this.cZD.setCurrentPage(2);
                this.hjX.a(dataRes.news_info);
                switch (this.hjX.bzE) {
                    case 1:
                        this.hjY.huq = this.hjX;
                        break;
                    case 2:
                        this.hjY.hur = this.hjX;
                        break;
                    case 3:
                        this.hjY.hus = this.hjX;
                        break;
                    default:
                        this.hjY.hur = this.hjX;
                        break;
                }
                this.hkc.a(dataRes.recommend_book);
                List<Post> list2 = dataRes.post_list;
                if (list2 != null && list2.size() > 0) {
                    for (Post post : dataRes.post_list) {
                        if (!this.hkB.contains(String.valueOf(post.id))) {
                            PostData postData = new PostData();
                            postData.setUserMap(this.userMap);
                            postData.pU(this.forum.isBrandForum);
                            postData.a(post, context);
                            postData.a(bIa().YD());
                            this.hkB.add(postData.getId());
                            if (postData.cer() == 1 && this.cZD.ZC()) {
                                if (bIg()) {
                                    postData.setPostType(0);
                                } else {
                                    postData.setPostType(this.cZD.ZB());
                                }
                            } else if (postData.cer() == 1 && this.cZD.ZR()) {
                                postData.setPostType(41);
                            } else if (postData.cer() == 1 && this.cZD != null && this.cZD.ZL()) {
                                postData.setPostType(0);
                                postData.asI();
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
                                this.hko = postData;
                            }
                            if (postData.cer() == 1 && this.cZD != null && this.cZD.isShareThread) {
                                postData.g(this.cZD.bDt);
                            }
                            this.hjS.add(postData);
                        }
                    }
                }
                if (dataRes.first_floor_post != null) {
                    this.hkC = new PostData();
                    this.hkC.setUserMap(this.userMap);
                    this.hkC.pU(this.forum.isBrandForum);
                    this.hkC.a(dataRes.first_floor_post, context);
                    if (this.cZD != null && this.cZD.isShareThread) {
                        this.hkC.g(this.cZD.bDt);
                    }
                }
                this.page.a(dataRes.page);
                this.anti.parserProtobuf(dataRes.anti);
                this.hjT.a(dataRes.location);
                if (dataRes.user != null) {
                    this.hjU = dataRes.user.is_manager.intValue();
                }
                this.userData.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.hjZ.add(muteUser);
                        }
                    }
                }
                this.cZD.gr(this.cZD.YI() > 0 ? this.cZD.YI() - 1 : 0);
                List<AppData> bWF = r.bWH().bWF();
                if (bWF != null) {
                    bWF.clear();
                }
                this.hkh = null;
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        m mVar = new m();
                        mVar.d(app);
                        AppData cef = mVar.cef();
                        if (!this.hkg.contains(mVar) && cef.goods != null && (!StringUtils.isNull(cef.goods.user_name) || !StringUtils.isNull(cef.goods.lego_card))) {
                            this.hkg.add(mVar);
                            if (bWF != null) {
                                bWF.add(mVar.cef());
                            }
                        }
                    }
                    a(dataRes);
                }
                r.bWH().bWG();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.userData.getIsSelectTail());
                }
                this.hki.parserProtobuf(dataRes.twzhibo_anti);
                this.hkj = dataRes.appeal_info;
                if (dataRes.god_card != null) {
                    this.hkb = new a();
                    this.hkb.a(dataRes.god_card);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.hkp = new f();
                    this.hkp.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.guess_like != null) {
                    this.hkq = new CardHListViewData();
                    this.hkq.parseProtobuf(dataRes.guess_like);
                }
                if (dataRes.feed_thread_list != null && dataRes.feed_thread_list.size() > 0) {
                    List<ThreadInfo> list3 = dataRes.feed_thread_list;
                    if (this.hkd == null) {
                        this.hkd = new ArrayList();
                    }
                    this.hkd.clear();
                    for (ThreadInfo threadInfo : list3) {
                        if (threadInfo != null) {
                            bg bgVar = new bg();
                            bgVar.a(threadInfo);
                            this.hkd.add(bgVar);
                        }
                    }
                    if (this.hkd != null && this.hkd.size() > 15) {
                        this.hkd = v.c(this.hkd, 0, 15);
                    }
                }
                this.hke = dataRes.is_follow_current_channel.intValue();
                if (v.S(dataRes.repost_recommend_forum_list) > 0) {
                    if (this.hkk == null) {
                        this.hkk = new ArrayList();
                    }
                    for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                        bc bcVar = new bc();
                        bcVar.parserProtobuf(simpleForum);
                        this.hkk.add(bcVar);
                    }
                }
                if (v.S(dataRes.from_forum_list) > 0) {
                    if (this.hkl == null) {
                        this.hkl = new ArrayList();
                    }
                    for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                        if (simpleForum2 != null) {
                            bc bcVar2 = new bc();
                            bcVar2.parserProtobuf(simpleForum2);
                            this.hkl.add(bcVar2);
                        }
                    }
                }
                this.hkz = dataRes.multi_forum_text;
                if (this.hkr >= 0) {
                    this.hkr = dataRes.thread_freq_num.longValue();
                }
                this.hks = new i();
                this.hks.bTk = this.cZD;
                this.hks.b(dataRes);
                this.hkt = dataRes.partial_visible_toast;
                if (dataRes.follow_tip != null && dataRes.follow_tip.is_toast_tip.intValue() == 1) {
                    this.hjV = dataRes.follow_tip.tip_text;
                }
                this.hkf = new AlaLiveInfoCoreData();
                if (dataRes.ala_info != null) {
                    this.hkf.parserProtoBuf(dataRes.ala_info);
                }
                this.hky = dataRes.fold_tip;
                this.hku = dataRes.exp_news_today.intValue();
                this.hkv = dataRes.exp_guide_today.intValue();
                if (!v.T(dataRes.thread_topic)) {
                    for (int i2 = 0; i2 < dataRes.thread_topic.size(); i2++) {
                        ay.a aVar = new ay.a();
                        aVar.a(dataRes.thread_topic.get(i2));
                        this.hkA.add(aVar);
                    }
                }
                this.hkw = dataRes.pb_sort_info;
                this.hkx = dataRes.sort_type.intValue();
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }

    private void a(DataRes dataRes) {
        List<String> kY;
        App app = dataRes.banner_list.pb_banner_ad;
        m mVar = new m();
        mVar.iGh = true;
        mVar.d(app);
        AppData cef = mVar.cef();
        if (cef.goods != null) {
            if (v.T(cef.goods.thread_pic_list) && (kY = AdvertAppInfo.a.kY(cef.goods.lego_card)) != null && cef.goods.thread_pic_list != null) {
                cef.goods.thread_pic_list.addAll(kY);
            }
            this.hkh = mVar;
        }
    }

    public String bIi() {
        return this.hky;
    }

    public CardHListViewData bIj() {
        return this.hkq;
    }

    public PostData bIk() {
        return this.hko;
    }

    public PostData d(PostData postData) {
        this.hko = postData;
        return postData;
    }

    public k bIl() {
        return this.hkm;
    }

    public int bIm() {
        return this.hjU;
    }

    public int getIsNewUrl() {
        return this.hjW;
    }

    public void setIsNewUrl(int i) {
        this.hjW = i;
    }

    public List<MuteUser> bIn() {
        return this.hjZ;
    }

    public ArrayList<m> bIo() {
        return this.hkg;
    }

    public m bIp() {
        return this.hkh;
    }

    public void b(m mVar) {
        this.hkh = mVar;
    }

    public void bIq() {
        if (this.hkh.cef() != null) {
            this.hkh.cef().legoCard = null;
        }
        this.hkh = null;
    }

    public a bIr() {
        return this.hkb;
    }

    public String bIs() {
        return this.hkn;
    }

    public void zJ(String str) {
        this.hkn = str;
    }

    public f bIt() {
        return this.hkp;
    }

    public int bIu() {
        return this.hke;
    }

    public List<bc> bIv() {
        return this.hkl;
    }

    public long bIw() {
        return this.hkr;
    }

    public i bIx() {
        return this.hks;
    }

    public boolean bIy() {
        return (bIa() == null || !bIa().ZL() || bIa().Zi() == null) ? false : true;
    }

    public AlaLiveInfoCoreData bIz() {
        return this.hkf;
    }
}

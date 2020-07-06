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
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.TwzhiboAnti;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.aw;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.data.bq;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.pb.pb.main.aa;
import com.baidu.tieba.pb.pb.main.ai;
import com.baidu.tieba.pb.pb.main.x;
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
/* loaded from: classes9.dex */
public class e {
    public AppealInfo jYF;
    public String jYG;
    public CardHListViewData jYH;
    public String jYI;
    public int jYJ;
    public int jYK;
    public List<PbSortType> jYL;
    public int jYM;
    public i jYN;
    public a jYR;
    private String jYX;
    private int jYY;
    public boolean jZB;
    private aa jZE;
    public String jZF;
    public String jZG;
    private List<bu> jZe;
    private AlaLiveInfoCoreData jZf;
    private TwzhiboAnti jZi;
    private List<bq> jZj;
    private List<bq> jZk;
    private PostData jZm;
    private h jZn;
    private long jZo;
    private m jZp;
    private String jZq;
    private String jZr;
    private List<com.baidu.tbadk.core.data.n> jZu;
    private com.baidu.tieba.pb.videopb.c.a jZw;
    private PostData jZx;
    private PostData jZz;
    public boolean jYO = false;
    public boolean jYP = false;
    public boolean jYQ = false;
    public boolean jYS = false;
    private boolean jZc = true;
    private ArrayList<com.baidu.tieba.tbadkCore.data.n> jZg = new ArrayList<>();
    private com.baidu.tieba.tbadkCore.data.n jZh = null;
    private int jZv = 0;
    public boolean jZy = true;
    public int jZA = 0;
    public int Xx = 0;
    private List<com.baidu.tieba.tbadkCore.data.n> jZC = new ArrayList();
    private ForumData forum = new ForumData();
    private bq jYT = new bq();
    private bu flT = new bu();
    private ArrayList<PostData> jYU = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private at page = new at();
    private AntiData anti = new AntiData();
    private com.baidu.tbadk.data.f jYV = new com.baidu.tbadk.data.f();
    private int jYW = 0;
    private final UserData userData = new UserData();
    private List<MuteUser> jZb = new ArrayList();
    private aw jYZ = new aw();
    private ax jZd = new ax();
    private ai jZa = new ai();
    private p jZl = new p();
    private x jZD = new x();
    private List<bk.a> jZs = new ArrayList();
    private HashSet<String> jZt = new HashSet<>();

    public e() {
        this.jYY = 0;
        this.jZi = null;
        this.jYY = 0;
        this.jZi = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.jYU != null && this.jYU.size() > 0;
    }

    public String[] fe(Context context) {
        return o(context, true);
    }

    public String[] o(Context context, boolean z) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5 = null;
        if (!isValid()) {
            str = "";
        } else {
            int size = this.jYU.size() > 30 ? 30 : this.jYU.size();
            if (cGO() == null || cGO().aSp() == null || ar.isEmpty(cGO().aSp().getUserId())) {
                return new String[]{null, ""};
            }
            String userId = cGO().aSp().getUserId();
            PostData cGY = cGY();
            if (cGY == null || cGY.aSp() == null || ar.isEmpty(cGY.aSp().getUserId())) {
                str2 = "";
            } else {
                if (!ar.equals(userId, cGY.aSp().getUserId())) {
                    str4 = null;
                } else {
                    str4 = cGY.dig();
                }
                if (!ar.isEmpty("")) {
                    str5 = str4;
                    str2 = "";
                } else {
                    str5 = str4;
                    str2 = cGY.die();
                }
            }
            if (ar.isEmpty(str2) && ar.isEmpty(str5)) {
                int i = 0;
                String str6 = str2;
                while (true) {
                    if (i >= size) {
                        str = str6;
                        str3 = str5;
                        break;
                    }
                    PostData postData = (PostData) w.getItem(this.jYU, i);
                    if (postData != null && postData.aSp() != null && !ar.isEmpty(postData.aSp().getUserId()) && ar.equals(userId, postData.aSp().getUserId())) {
                        if (ar.isEmpty(str5)) {
                            str5 = postData.dig();
                        }
                        String die = ar.isEmpty(str6) ? postData.die() : str6;
                        if (!ar.isEmpty(str5) && !ar.isEmpty(die)) {
                            str = die;
                            str3 = str5;
                            break;
                        }
                        str6 = die;
                    }
                    i++;
                }
            } else {
                str = str2;
                str3 = str5;
            }
            if (z && ar.isEmpty(str3)) {
                str3 = "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            }
            if (this.flT != null && this.flT.aTp() != null && this.flT.aTp().getGroup_id() != 0) {
                str = "[" + context.getString(R.string.photo_live_tips) + "] " + str;
            }
            str5 = (this.flT == null || this.flT.aSH() == null || ar.isEmpty(this.flT.aSH().thumbnail_url)) ? str3 : this.flT.aSH().thumbnail_url;
            if (this.flT != null && !this.flT.isShareThread && str5 == null && this.flT.dNX != null && this.flT.dNX.dJx != null) {
                ArrayList<MediaData> arrayList = this.flT.dNX.dJx;
                int size2 = arrayList.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size2) {
                        break;
                    }
                    MediaData mediaData = arrayList.get(i2);
                    if (mediaData != null && (mediaData.getType() == 3 || mediaData.getType() == 5)) {
                        if (!StringUtils.isNull(mediaData.getThumbnails_url())) {
                            str5 = mediaData.getThumbnails_url();
                            break;
                        } else if (!StringUtils.isNull(mediaData.getPicUrl())) {
                            str5 = mediaData.getPicUrl();
                            break;
                        }
                    }
                    i2++;
                }
            }
        }
        return new String[]{str5, str};
    }

    public ForumData getForum() {
        return this.forum;
    }

    public bq cGN() {
        return this.jYT;
    }

    public void e(bq bqVar) {
        this.jYT = bqVar;
    }

    public String getForumId() {
        if (this.forum == null) {
            return "";
        }
        return this.forum.getId();
    }

    public String getForumName() {
        if (this.forum == null) {
            return "";
        }
        return this.forum.getName();
    }

    public bu cGO() {
        return this.flT;
    }

    public void aG(bu buVar) {
        this.flT = buVar;
    }

    public List<bu> cGP() {
        return this.jZe;
    }

    public String getThreadId() {
        if (this.flT == null) {
            return "";
        }
        return this.flT.getId();
    }

    public ArrayList<PostData> cGQ() {
        return this.jYU;
    }

    public at getPage() {
        return this.page;
    }

    public ai cGR() {
        return this.jZa;
    }

    public ax cGS() {
        return this.jZd;
    }

    public x cGT() {
        if (this.jZD == null || !this.jZD.isValid()) {
            return null;
        }
        return this.jZD;
    }

    public aa cGU() {
        if (this.jZE == null || !this.jZE.isValid()) {
            return null;
        }
        return this.jZE;
    }

    public void a(at atVar, int i) {
        this.page.kx(atVar.aRd());
        this.page.kv(atVar.aQg());
        this.page.ku(atVar.aRa());
        this.page.ky(atVar.aRe());
        this.page.kw(atVar.aRc());
        if (i == 0) {
            this.page = atVar;
        } else if (i == 1) {
            this.page.kz(atVar.aRf());
        } else if (i == 2) {
            this.page.kA(atVar.aRg());
        }
    }

    public AntiData getAnti() {
        return this.anti;
    }

    public UserData getUserData() {
        return this.userData;
    }

    public boolean aOo() {
        return this.flT.aSw() != 0;
    }

    public void gJ(boolean z) {
        if (this.flT != null) {
            if (z) {
                this.flT.kK(1);
            } else {
                this.flT.kK(0);
            }
        }
    }

    public String aOn() {
        if (this.flT != null) {
            return this.flT.aSx();
        }
        return null;
    }

    public void JF(String str) {
        if (this.flT != null) {
            this.flT.vT(str);
        }
    }

    public String cGV() {
        return this.jZr;
    }

    public boolean cGW() {
        return (this.flT == null || this.flT.aSz() == null || this.flT.aSz().size() <= 0 || this.flT.aSz().get(0) == null || !this.flT.aSz().get(0).aQh()) ? false : true;
    }

    public PostData cGX() {
        return this.jZx;
    }

    public void d(PostData postData) {
        this.jZx = postData;
        this.jZz = postData;
        this.jZy = false;
    }

    public PostData cGY() {
        return this.jZz;
    }

    public void e(PostData postData) {
        this.jZz = postData;
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                com.baidu.tieba.recapp.d.a.cZG().LU(dataRes.asp_shown_info);
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
                this.jYT.parserProtobuf(dataRes.display_forum);
                this.flT.setUserMap(this.userMap);
                this.flT.a(dataRes.thread);
                this.jYZ.a(dataRes.news_info);
                switch (this.jYZ.dom) {
                    case 1:
                        this.jZa.kku = this.jYZ;
                        break;
                    case 2:
                        this.jZa.kkv = this.jYZ;
                        break;
                    case 3:
                        this.jZa.kkw = this.jYZ;
                        break;
                    default:
                        this.jZa.kkv = this.jYZ;
                        break;
                }
                this.jZd.a(dataRes.recommend_book);
                b(dataRes, context);
                this.jZx = new PostData();
                this.jZx.EW(1);
                this.jZx.setUserMap(this.userMap);
                this.jZx.uF(this.forum.isBrandForum);
                this.jZx.setTime(this.flT.getCreateTime());
                if (dataRes.first_floor_post != null) {
                    this.jZx.a(dataRes.first_floor_post, context);
                }
                if (this.flT != null && this.flT.isShareThread) {
                    this.jZx.h(this.flT.dNX);
                }
                if (this.jZz == null) {
                    this.jZz = this.jZx;
                    this.jZy = true;
                }
                this.page.a(dataRes.page);
                this.anti.parserProtobuf(dataRes.anti);
                this.jYV.a(dataRes.location);
                if (dataRes.user != null) {
                    this.jYW = dataRes.user.is_manager.intValue();
                }
                this.userData.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.jZb.add(muteUser);
                        }
                    }
                }
                this.flT.kG(this.flT.aSg() > 0 ? this.flT.aSg() - 1 : 0);
                List<AppData> cYR = com.baidu.tieba.recapp.q.cYT().cYR();
                if (cYR != null) {
                    cYR.clear();
                }
                this.jZh = null;
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        com.baidu.tieba.tbadkCore.data.n nVar = new com.baidu.tieba.tbadkCore.data.n();
                        nVar.d(app);
                        AppData dhN = nVar.dhN();
                        if (!this.jZg.contains(nVar) && dhN.goods != null && (!StringUtils.isNull(dhN.goods.user_name) || !StringUtils.isNull(dhN.goods.lego_card))) {
                            nVar.kny = cHn();
                            this.jZg.add(nVar);
                            if (cYR != null) {
                                cYR.add(nVar.dhN());
                            }
                        }
                    }
                    c(dataRes);
                    d(dataRes);
                }
                com.baidu.tieba.recapp.q.cYT().cYS();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.userData.getIsSelectTail());
                }
                this.jZi.parserProtobuf(dataRes.twzhibo_anti);
                this.jYF = dataRes.appeal_info;
                if (dataRes.forum_headline_img_info != null) {
                    this.jZn = new h();
                    this.jZn.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.guess_like != null) {
                    this.jYH = new CardHListViewData();
                    this.jYH.parseProtobuf(dataRes.guess_like);
                }
                b(dataRes);
                if (w.getCount(dataRes.repost_recommend_forum_list) > 0) {
                    if (this.jZj == null) {
                        this.jZj = new ArrayList();
                    }
                    for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                        bq bqVar = new bq();
                        bqVar.parserProtobuf(simpleForum);
                        this.jZj.add(bqVar);
                    }
                }
                if (w.getCount(dataRes.from_forum_list) > 0) {
                    if (this.jZk == null) {
                        this.jZk = new ArrayList();
                    }
                    for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                        if (simpleForum2 != null) {
                            bq bqVar2 = new bq();
                            bqVar2.parserProtobuf(simpleForum2);
                            this.jZk.add(bqVar2);
                        }
                    }
                }
                this.jZr = dataRes.multi_forum_text;
                if (this.jZo >= 0) {
                    this.jZo = dataRes.thread_freq_num.longValue();
                }
                a(dataRes);
                if (this.jZu == null) {
                    this.jZu = new ArrayList();
                }
                this.jZu.clear();
                if (dataRes.bjh_recommend != null) {
                    int i2 = 1;
                    for (ThreadInfo threadInfo : dataRes.bjh_recommend) {
                        if (threadInfo != null && !d(threadInfo) && !e(threadInfo)) {
                            com.baidu.tbadk.core.data.n nVar2 = new com.baidu.tbadk.core.data.n();
                            nVar2.setFloorNum(i2);
                            nVar2.a(threadInfo);
                            this.jZu.add(nVar2);
                            i2++;
                        }
                    }
                }
                if (this.jZw != null && this.jZw.cQr()) {
                    this.jZw = null;
                }
                if (dataRes.recom_ala_info != null && dataRes.recom_ala_info.live_status.intValue() == 1 && dataRes.recom_ala_info.pb_display_type.intValue() == 2) {
                    if (this.jZw == null) {
                        this.jZw = new com.baidu.tieba.pb.videopb.c.a();
                        this.jZw.parserProtoBuf(dataRes.recom_ala_info);
                    }
                } else if (this.jZw == null && dataRes.promotion != null) {
                    this.jZw = new com.baidu.tieba.pb.videopb.c.a();
                    this.jZw.a(dataRes.promotion);
                }
                if (dataRes.business_promot_info != null) {
                    this.jYO = dataRes.business_promot_info.is_promot.longValue() == 1;
                    this.jYP = dataRes.business_promot_info.is_headlinepost.intValue() == 1;
                    this.jYQ = dataRes.business_promot_info.is_s_card.intValue() == 1;
                    if (dataRes.business_promot_info.send_card_info != null) {
                        b bVar = new b();
                        bVar.a(dataRes.business_promot_info.send_card_info);
                        if (this.jYR == null) {
                            this.jYR = new a();
                        }
                        this.jYR.a(bVar);
                    }
                }
                this.jZD.reset();
                this.jZD.setUserMap(this.userMap);
                this.jZD.a(dataRes.recom_ala_info);
                this.jZE = new aa();
                this.jZE.setUserMap(this.userMap);
                this.jZE.a(dataRes.recom_ala_info);
                this.jZF = dataRes.jumptotab1 == null ? null : dataRes.jumptotab1.toString();
                this.jZG = dataRes.jumptotab2;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    private void b(DataRes dataRes, Context context) {
        List<Post> list = dataRes.post_list;
        if (list != null && list.size() > 0) {
            for (Post post : dataRes.post_list) {
                if (!this.jZt.contains(String.valueOf(post.id))) {
                    PostData postData = new PostData();
                    postData.setUserMap(this.userMap);
                    postData.uF(this.forum.isBrandForum);
                    postData.a(post, context);
                    postData.a(cGO().aSa());
                    if (postData.aUg() != null && postData.aUg().baijiahaoData == null && cGO() != null && cGO().getBaijiahaoData() != null) {
                        postData.aUg().baijiahaoData = cGO().getBaijiahaoData();
                    }
                    this.jZt.add(postData.getId());
                    if (postData.dhZ() == 1 && this.flT.aTd()) {
                        if (cGW()) {
                            postData.setPostType(0);
                        } else {
                            postData.setPostType(this.flT.aTc());
                        }
                    } else if (postData.dhZ() == 1 && this.flT.aTx()) {
                        postData.setPostType(41);
                    } else if (postData.dhZ() == 1 && this.flT != null && this.flT.aQV()) {
                        postData.setPostType(0);
                        postData.bkZ();
                        if (this.flT.aSn() == null || this.flT.aSn().size() == 0) {
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
                            postData.c(new TbRichText((Context) TbadkCoreApplication.getInst(), this.flT.aSn(), true));
                        }
                        this.jZm = postData;
                    }
                    if (postData.dhZ() == 1 && this.flT != null && this.flT.isShareThread) {
                        postData.h(this.flT.dNX);
                    }
                    if (postData.dhZ() == 1) {
                        this.jZz = postData;
                        this.jZy = false;
                    }
                    this.jYU.add(postData);
                }
            }
        }
    }

    private void a(DataRes dataRes) {
        this.jZp = new m(this.flT, this.anti);
        this.jYI = dataRes.partial_visible_toast;
        if (dataRes.follow_tip != null && dataRes.follow_tip.is_toast_tip.intValue() == 1) {
            this.jYX = dataRes.follow_tip.tip_text;
        }
        this.jZf = new AlaLiveInfoCoreData();
        if (dataRes.ala_info != null) {
            this.jZf.parserProtoBuf(dataRes.ala_info);
        }
        this.jZq = dataRes.fold_tip;
        this.jYJ = dataRes.exp_news_today.intValue();
        this.jYK = dataRes.exp_guide_today.intValue();
        if (!w.isEmpty(dataRes.thread_topic)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= dataRes.thread_topic.size()) {
                    break;
                }
                bk.a aVar = new bk.a();
                aVar.a(dataRes.thread_topic.get(i2));
                this.jZs.add(aVar);
                i = i2 + 1;
            }
        }
        this.jYL = dataRes.pb_sort_info;
        this.jYM = dataRes.sort_type.intValue();
        if (dataRes.manager_election != null) {
            this.jYN = i.b(dataRes.manager_election);
        }
    }

    private void b(DataRes dataRes) {
        if (dataRes.feed_thread_list != null && dataRes.feed_thread_list.size() > 0) {
            List<ThreadInfo> list = dataRes.feed_thread_list;
            if (this.jZe == null) {
                this.jZe = new ArrayList();
            }
            this.jZe.clear();
            for (ThreadInfo threadInfo : list) {
                if (threadInfo != null) {
                    bu buVar = new bu();
                    buVar.a(threadInfo);
                    this.jZe.add(buVar);
                }
            }
            if (this.jZe != null && this.jZe.size() > 15) {
                this.jZe = w.subList(this.jZe, 0, 15);
            }
        }
    }

    private void c(DataRes dataRes) {
        List<String> vD;
        App app = dataRes.banner_list.pb_banner_ad;
        com.baidu.tieba.tbadkCore.data.n nVar = new com.baidu.tieba.tbadkCore.data.n();
        nVar.lFJ = true;
        nVar.d(app);
        AppData dhN = nVar.dhN();
        if (dhN.goods != null) {
            if (w.isEmpty(dhN.goods.thread_pic_list) && (vD = AdvertAppInfo.a.vD(dhN.goods.lego_card)) != null && dhN.goods.thread_pic_list != null) {
                dhN.goods.thread_pic_list.addAll(vD);
            }
            this.jZh = nVar;
        }
    }

    private void d(DataRes dataRes) {
        List<App> list = dataRes.banner_list.video_recommend_ad;
        this.jZC.clear();
        if (list != null && !list.isEmpty()) {
            for (App app : list) {
                com.baidu.tieba.tbadkCore.data.n nVar = new com.baidu.tieba.tbadkCore.data.n();
                nVar.d(app);
                AppData dhN = nVar.dhN();
                if (!this.jZC.contains(nVar) && dhN.goods != null && (!StringUtils.isNull(dhN.goods.user_name) || !StringUtils.isNull(dhN.goods.lego_card))) {
                    nVar.kny = cHn();
                    this.jZC.add(nVar);
                }
            }
        }
    }

    public String cGZ() {
        return this.jZq;
    }

    public CardHListViewData cHa() {
        return this.jYH;
    }

    public PostData cHb() {
        return this.jZm;
    }

    public PostData f(PostData postData) {
        this.jZm = postData;
        return postData;
    }

    public p cHc() {
        return this.jZl;
    }

    public int cHd() {
        return this.jYW;
    }

    public int getIsNewUrl() {
        return this.jYY;
    }

    public void setIsNewUrl(int i) {
        this.jYY = i;
    }

    public List<MuteUser> cHe() {
        return this.jZb;
    }

    public ArrayList<com.baidu.tieba.tbadkCore.data.n> cHf() {
        return this.jZg;
    }

    public com.baidu.tieba.tbadkCore.data.n cHg() {
        return this.jZh;
    }

    public void b(com.baidu.tieba.tbadkCore.data.n nVar) {
        this.jZh = nVar;
    }

    public void cHh() {
        if (this.jZh.dhN() != null) {
            this.jZh.dhN().legoCard = null;
        }
        this.jZh = null;
    }

    public String cHi() {
        return this.jYG;
    }

    public void JG(String str) {
        this.jYG = str;
    }

    public h cHj() {
        return this.jZn;
    }

    public List<bq> cHk() {
        return this.jZk;
    }

    public long cHl() {
        return this.jZo;
    }

    public m cHm() {
        return this.jZp;
    }

    public void a(m mVar) {
        this.jZp = mVar;
    }

    public boolean cHn() {
        return (cGO() == null || !cGO().aQV() || cGO().aSH() == null) ? false : true;
    }

    public AlaLiveInfoCoreData cHo() {
        return this.jZf;
    }

    public List<com.baidu.tbadk.core.data.n> cHp() {
        return this.jZu;
    }

    public boolean cHq() {
        return cGO() != null && cGO().aQZ();
    }

    public String cHr() {
        if (this.jYL != null && this.jYL.size() > this.jYM) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.jYL.size()) {
                    break;
                } else if (this.jYL.get(i2).sort_type.intValue() != this.jYM) {
                    i = i2 + 1;
                } else {
                    return this.jYL.get(i2).sort_name;
                }
            }
        }
        return "";
    }

    public com.baidu.tieba.pb.videopb.c.a cHs() {
        return this.jZw;
    }

    public int cHt() {
        return this.jZv;
    }

    public void AX(int i) {
        this.jZv = i;
    }

    public List<com.baidu.tieba.tbadkCore.data.n> cHu() {
        return this.jZC;
    }

    private boolean d(ThreadInfo threadInfo) {
        if (threadInfo == null || getThreadId() == null || "0".equals(threadInfo.id) || "0".equals(threadInfo.tid)) {
            return false;
        }
        return getThreadId().equals(threadInfo.id) || getThreadId().equals(threadInfo.tid);
    }

    private boolean e(ThreadInfo threadInfo) {
        if (threadInfo == null || threadInfo.baijiahao == null || threadInfo.baijiahao.ori_ugc_nid == null || this.flT == null || this.flT.getBaijiahaoData() == null || this.flT.getBaijiahaoData().oriUgcNid == null || "0".equals(threadInfo.baijiahao.ori_ugc_nid)) {
            return false;
        }
        return threadInfo.baijiahao.ori_ugc_nid.equals(this.flT.getBaijiahaoData().oriUgcNid);
    }
}

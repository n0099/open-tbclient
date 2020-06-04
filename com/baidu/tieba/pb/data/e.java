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
import com.baidu.tbadk.core.data.ao;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
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
    public AppealInfo jEV;
    public String jEW;
    public CardHListViewData jEX;
    public String jEY;
    public int jEZ;
    private List<bg> jFA;
    private PostData jFC;
    private h jFD;
    private long jFE;
    private m jFF;
    private String jFG;
    private String jFH;
    private List<com.baidu.tbadk.core.data.k> jFK;
    private com.baidu.tieba.pb.videopb.c.a jFM;
    private PostData jFN;
    private PostData jFP;
    public boolean jFR;
    private aa jFU;
    public String jFV;
    public String jFW;
    public int jFa;
    public List<PbSortType> jFb;
    public int jFc;
    public i jFd;
    public a jFh;
    private String jFn;
    private int jFo;
    private List<bk> jFu;
    private AlaLiveInfoCoreData jFv;
    private TwzhiboAnti jFy;
    private List<bg> jFz;
    public boolean jFe = false;
    public boolean jFf = false;
    public boolean jFg = false;
    public boolean jFi = false;
    private boolean jFs = true;
    private ArrayList<com.baidu.tieba.tbadkCore.data.n> jFw = new ArrayList<>();
    private com.baidu.tieba.tbadkCore.data.n jFx = null;
    private int jFL = 0;
    public boolean jFO = true;
    public int jFQ = 0;
    public int WR = 0;
    private List<com.baidu.tieba.tbadkCore.data.n> jFS = new ArrayList();
    private ForumData forum = new ForumData();
    private bg jFj = new bg();
    private bk faJ = new bk();
    private ArrayList<PostData> jFk = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private ao page = new ao();
    private AntiData anti = new AntiData();
    private com.baidu.tbadk.data.f jFl = new com.baidu.tbadk.data.f();
    private int jFm = 0;
    private final UserData userData = new UserData();
    private List<MuteUser> jFr = new ArrayList();
    private ar jFp = new ar();
    private as jFt = new as();
    private ai jFq = new ai();
    private p jFB = new p();
    private x jFT = new x();
    private List<bc.a> jFI = new ArrayList();
    private HashSet<String> jFJ = new HashSet<>();

    public e() {
        this.jFo = 0;
        this.jFy = null;
        this.jFo = 0;
        this.jFy = new TwzhiboAnti();
    }

    public boolean cCw() {
        return this.jFs;
    }

    public void rb(boolean z) {
        this.jFs = z;
    }

    public boolean isValid() {
        return this.jFk != null && this.jFk.size() > 0;
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
            int size = this.jFk.size() > 30 ? 30 : this.jFk.size();
            if (cCy() == null || cCy().aQx() == null || aq.isEmpty(cCy().aQx().getUserId())) {
                return new String[]{null, ""};
            }
            String userId = cCy().aQx().getUserId();
            PostData cCI = cCI();
            if (cCI == null || cCI.aQx() == null || aq.isEmpty(cCI.aQx().getUserId())) {
                str2 = "";
            } else {
                if (!aq.equals(userId, cCI.aQx().getUserId())) {
                    str4 = null;
                } else {
                    str4 = cCI.ddQ();
                }
                if (!aq.isEmpty("")) {
                    str5 = str4;
                    str2 = "";
                } else {
                    str5 = str4;
                    str2 = cCI.ddO();
                }
            }
            if (aq.isEmpty(str2) && aq.isEmpty(str5)) {
                int i = 0;
                String str6 = str2;
                while (true) {
                    if (i >= size) {
                        str = str6;
                        str3 = str5;
                        break;
                    }
                    PostData postData = (PostData) v.getItem(this.jFk, i);
                    if (postData != null && postData.aQx() != null && !aq.isEmpty(postData.aQx().getUserId()) && aq.equals(userId, postData.aQx().getUserId())) {
                        if (aq.isEmpty(str5)) {
                            str5 = postData.ddQ();
                        }
                        String ddO = aq.isEmpty(str6) ? postData.ddO() : str6;
                        if (!aq.isEmpty(str5) && !aq.isEmpty(ddO)) {
                            str = ddO;
                            str3 = str5;
                            break;
                        }
                        str6 = ddO;
                    }
                    i++;
                }
            } else {
                str = str2;
                str3 = str5;
            }
            if (z && aq.isEmpty(str3)) {
                str3 = "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            }
            if (this.faJ != null && this.faJ.aRy() != null && this.faJ.aRy().getGroup_id() != 0) {
                str = "[" + context.getString(R.string.photo_live_tips) + "] " + str;
            }
            str5 = (this.faJ == null || this.faJ.aQQ() == null || aq.isEmpty(this.faJ.aQQ().thumbnail_url)) ? str3 : this.faJ.aQQ().thumbnail_url;
            if (this.faJ != null && !this.faJ.isShareThread && str5 == null && this.faJ.dHm != null && this.faJ.dHm.dDc != null) {
                ArrayList<MediaData> arrayList = this.faJ.dHm.dDc;
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

    public bg cCx() {
        return this.jFj;
    }

    public void e(bg bgVar) {
        this.jFj = bgVar;
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

    public bk cCy() {
        return this.faJ;
    }

    public void aG(bk bkVar) {
        this.faJ = bkVar;
    }

    public List<bk> cCz() {
        return this.jFu;
    }

    public String getThreadId() {
        if (this.faJ == null) {
            return "";
        }
        return this.faJ.getId();
    }

    public ArrayList<PostData> cCA() {
        return this.jFk;
    }

    public ao getPage() {
        return this.page;
    }

    public ai cCB() {
        return this.jFq;
    }

    public as cCC() {
        return this.jFt;
    }

    public x cCD() {
        if (this.jFT == null || !this.jFT.isValid()) {
            return null;
        }
        return this.jFT;
    }

    public aa cCE() {
        if (this.jFU == null || !this.jFU.isValid()) {
            return null;
        }
        return this.jFU;
    }

    public void a(ao aoVar, int i) {
        this.page.kl(aoVar.aPr());
        this.page.kj(aoVar.aOw());
        this.page.ki(aoVar.aPo());
        this.page.km(aoVar.aPs());
        this.page.kk(aoVar.aPq());
        if (i == 0) {
            this.page = aoVar;
        } else if (i == 1) {
            this.page.kn(aoVar.aPt());
        } else if (i == 2) {
            this.page.ko(aoVar.aPu());
        }
    }

    public AntiData getAnti() {
        return this.anti;
    }

    public UserData getUserData() {
        return this.userData;
    }

    public boolean aML() {
        return this.faJ.aQF() != 0;
    }

    public void gC(boolean z) {
        if (this.faJ != null) {
            if (z) {
                this.faJ.kw(1);
            } else {
                this.faJ.kw(0);
            }
        }
    }

    public String aMK() {
        if (this.faJ != null) {
            return this.faJ.aQG();
        }
        return null;
    }

    public void Jd(String str) {
        if (this.faJ != null) {
            this.faJ.vD(str);
        }
    }

    public String cCF() {
        return this.jFH;
    }

    public boolean cCG() {
        return (this.faJ == null || this.faJ.aQI() == null || this.faJ.aQI().size() <= 0 || this.faJ.aQI().get(0) == null || !this.faJ.aQI().get(0).aOx()) ? false : true;
    }

    public PostData cCH() {
        return this.jFN;
    }

    public void d(PostData postData) {
        this.jFN = postData;
        this.jFP = postData;
        this.jFO = false;
    }

    public PostData cCI() {
        return this.jFP;
    }

    public void e(PostData postData) {
        this.jFP = postData;
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                com.baidu.tieba.recapp.d.a.cVp().Lt(dataRes.asp_shown_info);
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
                this.jFj.parserProtobuf(dataRes.display_forum);
                this.faJ.setUserMap(this.userMap);
                this.faJ.a(dataRes.thread);
                this.jFp.a(dataRes.news_info);
                switch (this.jFp.djB) {
                    case 1:
                        this.jFq.jQE = this.jFp;
                        break;
                    case 2:
                        this.jFq.jQF = this.jFp;
                        break;
                    case 3:
                        this.jFq.jQG = this.jFp;
                        break;
                    default:
                        this.jFq.jQF = this.jFp;
                        break;
                }
                this.jFt.a(dataRes.recommend_book);
                b(dataRes, context);
                this.jFN = new PostData();
                this.jFN.DU(1);
                this.jFN.setUserMap(this.userMap);
                this.jFN.uq(this.forum.isBrandForum);
                this.jFN.setTime(this.faJ.getCreateTime());
                if (dataRes.first_floor_post != null) {
                    this.jFN.a(dataRes.first_floor_post, context);
                }
                if (this.faJ != null && this.faJ.isShareThread) {
                    this.jFN.h(this.faJ.dHm);
                }
                if (this.jFP == null) {
                    this.jFP = this.jFN;
                    this.jFO = true;
                }
                this.page.a(dataRes.page);
                this.anti.parserProtobuf(dataRes.anti);
                this.jFl.a(dataRes.location);
                if (dataRes.user != null) {
                    this.jFm = dataRes.user.is_manager.intValue();
                }
                this.userData.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.jFr.add(muteUser);
                        }
                    }
                }
                this.faJ.ks(this.faJ.aQo() > 0 ? this.faJ.aQo() - 1 : 0);
                List<AppData> cUA = com.baidu.tieba.recapp.q.cUC().cUA();
                if (cUA != null) {
                    cUA.clear();
                }
                this.jFx = null;
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        com.baidu.tieba.tbadkCore.data.n nVar = new com.baidu.tieba.tbadkCore.data.n();
                        nVar.d(app);
                        AppData ddx = nVar.ddx();
                        if (!this.jFw.contains(nVar) && ddx.goods != null && (!StringUtils.isNull(ddx.goods.user_name) || !StringUtils.isNull(ddx.goods.lego_card))) {
                            nVar.jTI = aWj();
                            this.jFw.add(nVar);
                            if (cUA != null) {
                                cUA.add(nVar.ddx());
                            }
                        }
                    }
                    c(dataRes);
                    d(dataRes);
                }
                com.baidu.tieba.recapp.q.cUC().cUB();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.userData.getIsSelectTail());
                }
                this.jFy.parserProtobuf(dataRes.twzhibo_anti);
                this.jEV = dataRes.appeal_info;
                if (dataRes.forum_headline_img_info != null) {
                    this.jFD = new h();
                    this.jFD.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.guess_like != null) {
                    this.jEX = new CardHListViewData();
                    this.jEX.parseProtobuf(dataRes.guess_like);
                }
                b(dataRes);
                if (v.getCount(dataRes.repost_recommend_forum_list) > 0) {
                    if (this.jFz == null) {
                        this.jFz = new ArrayList();
                    }
                    for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                        bg bgVar = new bg();
                        bgVar.parserProtobuf(simpleForum);
                        this.jFz.add(bgVar);
                    }
                }
                if (v.getCount(dataRes.from_forum_list) > 0) {
                    if (this.jFA == null) {
                        this.jFA = new ArrayList();
                    }
                    for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                        if (simpleForum2 != null) {
                            bg bgVar2 = new bg();
                            bgVar2.parserProtobuf(simpleForum2);
                            this.jFA.add(bgVar2);
                        }
                    }
                }
                this.jFH = dataRes.multi_forum_text;
                if (this.jFE >= 0) {
                    this.jFE = dataRes.thread_freq_num.longValue();
                }
                a(dataRes);
                if (this.jFK == null) {
                    this.jFK = new ArrayList();
                }
                this.jFK.clear();
                if (dataRes.bjh_recommend != null) {
                    int i2 = 1;
                    for (ThreadInfo threadInfo : dataRes.bjh_recommend) {
                        if (threadInfo != null && !d(threadInfo) && !e(threadInfo)) {
                            com.baidu.tbadk.core.data.k kVar = new com.baidu.tbadk.core.data.k();
                            kVar.setFloorNum(i2);
                            kVar.a(threadInfo);
                            this.jFK.add(kVar);
                            i2++;
                        }
                    }
                }
                if (this.jFM != null && this.jFM.cLZ()) {
                    this.jFM = null;
                }
                if (dataRes.recom_ala_info != null && dataRes.recom_ala_info.live_status.intValue() == 1 && dataRes.recom_ala_info.pb_display_type.intValue() == 2) {
                    if (this.jFM == null) {
                        this.jFM = new com.baidu.tieba.pb.videopb.c.a();
                        this.jFM.parserProtoBuf(dataRes.recom_ala_info);
                    }
                } else if (this.jFM == null && dataRes.promotion != null) {
                    this.jFM = new com.baidu.tieba.pb.videopb.c.a();
                    this.jFM.a(dataRes.promotion);
                }
                if (dataRes.business_promot_info != null) {
                    this.jFe = dataRes.business_promot_info.is_promot.longValue() == 1;
                    this.jFf = dataRes.business_promot_info.is_headlinepost.intValue() == 1;
                    this.jFg = dataRes.business_promot_info.is_s_card.intValue() == 1;
                    if (dataRes.business_promot_info.send_card_info != null) {
                        b bVar = new b();
                        bVar.a(dataRes.business_promot_info.send_card_info);
                        if (this.jFh == null) {
                            this.jFh = new a();
                        }
                        this.jFh.a(bVar);
                    }
                }
                this.jFT.reset();
                this.jFT.setUserMap(this.userMap);
                this.jFT.a(dataRes.recom_ala_info);
                this.jFU = new aa();
                this.jFU.setUserMap(this.userMap);
                this.jFU.a(dataRes.recom_ala_info);
                this.jFV = dataRes.jumptotab1 == null ? null : dataRes.jumptotab1.toString();
                this.jFW = dataRes.jumptotab2;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    private void b(DataRes dataRes, Context context) {
        List<Post> list = dataRes.post_list;
        if (list != null && list.size() > 0) {
            for (Post post : dataRes.post_list) {
                if (!this.jFJ.contains(String.valueOf(post.id))) {
                    PostData postData = new PostData();
                    postData.setUserMap(this.userMap);
                    postData.uq(this.forum.isBrandForum);
                    postData.a(post, context);
                    postData.a(cCy().aQi());
                    if (postData.aSp() != null && postData.aSp().baijiahaoData == null && cCy() != null && cCy().getBaijiahaoData() != null) {
                        postData.aSp().baijiahaoData = cCy().getBaijiahaoData();
                    }
                    this.jFJ.add(postData.getId());
                    if (postData.ddJ() == 1 && this.faJ.aRm()) {
                        if (cCG()) {
                            postData.setPostType(0);
                        } else {
                            postData.setPostType(this.faJ.aRl());
                        }
                    } else if (postData.ddJ() == 1 && this.faJ.aRG()) {
                        postData.setPostType(41);
                    } else if (postData.ddJ() == 1 && this.faJ != null && this.faJ.aPk()) {
                        postData.setPostType(0);
                        postData.biC();
                        if (this.faJ.aQv() == null || this.faJ.aQv().size() == 0) {
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
                            postData.c(new TbRichText((Context) TbadkCoreApplication.getInst(), this.faJ.aQv(), true));
                        }
                        this.jFC = postData;
                    }
                    if (postData.ddJ() == 1 && this.faJ != null && this.faJ.isShareThread) {
                        postData.h(this.faJ.dHm);
                    }
                    if (postData.ddJ() == 1) {
                        this.jFP = postData;
                        this.jFO = false;
                    }
                    this.jFk.add(postData);
                }
            }
        }
    }

    private void a(DataRes dataRes) {
        this.jFF = new m(this.faJ, this.anti);
        this.jEY = dataRes.partial_visible_toast;
        if (dataRes.follow_tip != null && dataRes.follow_tip.is_toast_tip.intValue() == 1) {
            this.jFn = dataRes.follow_tip.tip_text;
        }
        this.jFv = new AlaLiveInfoCoreData();
        if (dataRes.ala_info != null) {
            this.jFv.parserProtoBuf(dataRes.ala_info);
        }
        this.jFG = dataRes.fold_tip;
        this.jEZ = dataRes.exp_news_today.intValue();
        this.jFa = dataRes.exp_guide_today.intValue();
        if (!v.isEmpty(dataRes.thread_topic)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= dataRes.thread_topic.size()) {
                    break;
                }
                bc.a aVar = new bc.a();
                aVar.a(dataRes.thread_topic.get(i2));
                this.jFI.add(aVar);
                i = i2 + 1;
            }
        }
        this.jFb = dataRes.pb_sort_info;
        this.jFc = dataRes.sort_type.intValue();
        if (dataRes.manager_election != null) {
            this.jFd = i.b(dataRes.manager_election);
        }
    }

    private void b(DataRes dataRes) {
        if (dataRes.feed_thread_list != null && dataRes.feed_thread_list.size() > 0) {
            List<ThreadInfo> list = dataRes.feed_thread_list;
            if (this.jFu == null) {
                this.jFu = new ArrayList();
            }
            this.jFu.clear();
            for (ThreadInfo threadInfo : list) {
                if (threadInfo != null) {
                    bk bkVar = new bk();
                    bkVar.a(threadInfo);
                    this.jFu.add(bkVar);
                }
            }
            if (this.jFu != null && this.jFu.size() > 15) {
                this.jFu = v.subList(this.jFu, 0, 15);
            }
        }
    }

    private void c(DataRes dataRes) {
        List<String> vr;
        App app = dataRes.banner_list.pb_banner_ad;
        com.baidu.tieba.tbadkCore.data.n nVar = new com.baidu.tieba.tbadkCore.data.n();
        nVar.llP = true;
        nVar.d(app);
        AppData ddx = nVar.ddx();
        if (ddx.goods != null) {
            if (v.isEmpty(ddx.goods.thread_pic_list) && (vr = AdvertAppInfo.a.vr(ddx.goods.lego_card)) != null && ddx.goods.thread_pic_list != null) {
                ddx.goods.thread_pic_list.addAll(vr);
            }
            this.jFx = nVar;
        }
    }

    private void d(DataRes dataRes) {
        List<App> list = dataRes.banner_list.video_recommend_ad;
        this.jFS.clear();
        if (list != null && !list.isEmpty()) {
            for (App app : list) {
                com.baidu.tieba.tbadkCore.data.n nVar = new com.baidu.tieba.tbadkCore.data.n();
                nVar.d(app);
                AppData ddx = nVar.ddx();
                if (!this.jFS.contains(nVar) && ddx.goods != null && (!StringUtils.isNull(ddx.goods.user_name) || !StringUtils.isNull(ddx.goods.lego_card))) {
                    nVar.jTI = aWj();
                    this.jFS.add(nVar);
                }
            }
        }
    }

    public String cCJ() {
        return this.jFG;
    }

    public CardHListViewData cCK() {
        return this.jEX;
    }

    public PostData cCL() {
        return this.jFC;
    }

    public PostData f(PostData postData) {
        this.jFC = postData;
        return postData;
    }

    public p cCM() {
        return this.jFB;
    }

    public int cCN() {
        return this.jFm;
    }

    public int getIsNewUrl() {
        return this.jFo;
    }

    public void setIsNewUrl(int i) {
        this.jFo = i;
    }

    public List<MuteUser> cCO() {
        return this.jFr;
    }

    public ArrayList<com.baidu.tieba.tbadkCore.data.n> cCP() {
        return this.jFw;
    }

    public com.baidu.tieba.tbadkCore.data.n cCQ() {
        return this.jFx;
    }

    public void b(com.baidu.tieba.tbadkCore.data.n nVar) {
        this.jFx = nVar;
    }

    public void cCR() {
        if (this.jFx.ddx() != null) {
            this.jFx.ddx().legoCard = null;
        }
        this.jFx = null;
    }

    public String cCS() {
        return this.jEW;
    }

    public void Je(String str) {
        this.jEW = str;
    }

    public h cCT() {
        return this.jFD;
    }

    public List<bg> cCU() {
        return this.jFA;
    }

    public long cCV() {
        return this.jFE;
    }

    public m cCW() {
        return this.jFF;
    }

    public void a(m mVar) {
        this.jFF = mVar;
    }

    public boolean aWj() {
        return (cCy() == null || !cCy().aPk() || cCy().aQQ() == null) ? false : true;
    }

    public AlaLiveInfoCoreData cCX() {
        return this.jFv;
    }

    public List<com.baidu.tbadk.core.data.k> cCY() {
        return this.jFK;
    }

    public boolean cCZ() {
        return cCy() != null && cCy().aSx();
    }

    public String cDa() {
        if (this.jFb != null && this.jFb.size() > this.jFc) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.jFb.size()) {
                    break;
                } else if (this.jFb.get(i2).sort_type.intValue() != this.jFc) {
                    i = i2 + 1;
                } else {
                    return this.jFb.get(i2).sort_name;
                }
            }
        }
        return "";
    }

    public com.baidu.tieba.pb.videopb.c.a cDb() {
        return this.jFM;
    }

    public int cDc() {
        return this.jFL;
    }

    public void zV(int i) {
        this.jFL = i;
    }

    public List<com.baidu.tieba.tbadkCore.data.n> cDd() {
        return this.jFS;
    }

    private boolean d(ThreadInfo threadInfo) {
        if (threadInfo == null || getThreadId() == null || "0".equals(threadInfo.id) || "0".equals(threadInfo.tid)) {
            return false;
        }
        return getThreadId().equals(threadInfo.id) || getThreadId().equals(threadInfo.tid);
    }

    private boolean e(ThreadInfo threadInfo) {
        if (threadInfo == null || threadInfo.baijiahao == null || threadInfo.baijiahao.ori_ugc_nid == null || this.faJ == null || this.faJ.getBaijiahaoData() == null || this.faJ.getBaijiahaoData().oriUgcNid == null || "0".equals(threadInfo.baijiahao.ori_ugc_nid)) {
            return false;
        }
        return threadInfo.baijiahao.ori_ugc_nid.equals(this.faJ.getBaijiahaoData().oriUgcNid);
    }
}

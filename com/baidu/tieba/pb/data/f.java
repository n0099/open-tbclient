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
import com.baidu.tbadk.core.data.au;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.data.ay;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.br;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.pb.pb.main.ac;
import com.baidu.tieba.pb.pb.main.am;
import com.baidu.tieba.pb.pb.main.z;
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
/* loaded from: classes16.dex */
public class f {
    private String khA;
    private int khB;
    private List<bv> khH;
    private AlaLiveInfoCoreData khI;
    private TwzhiboAnti khL;
    private List<br> khM;
    private List<br> khN;
    private PostData khP;
    private i khQ;
    private long khR;
    private o khS;
    private String khT;
    private String khU;
    private List<com.baidu.tbadk.core.data.n> khX;
    private com.baidu.tieba.pb.videopb.c.a khZ;
    public AppealInfo khi;
    public String khj;
    public CardHListViewData khk;
    public String khl;
    public int khm;
    public int khn;
    public List<PbSortType> kho;
    public int khp;
    public k khq;
    public a khu;
    private PostData kia;
    private PostData kic;
    public boolean kif;
    private ac kii;
    public String kij;
    public String kik;
    public boolean khr = false;
    public boolean khs = false;
    public boolean kht = false;
    public boolean khv = false;
    private boolean khF = true;
    private ArrayList<com.baidu.tieba.tbadkCore.data.n> khJ = new ArrayList<>();
    private com.baidu.tieba.tbadkCore.data.n khK = null;
    private int khY = 0;
    public boolean kib = true;
    public int kie = 0;
    public int Xq = 0;
    private List<com.baidu.tieba.tbadkCore.data.n> kig = new ArrayList();
    private ForumData forum = new ForumData();
    private br khw = new br();
    private bv frb = new bv();
    private ArrayList<PostData> khx = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private au page = new au();
    private AntiData anti = new AntiData();
    private com.baidu.tbadk.data.f khy = new com.baidu.tbadk.data.f();
    private int khz = 0;
    private final UserData userData = new UserData();
    private List<MuteUser> khE = new ArrayList();
    private ax khC = new ax();
    private ay khG = new ay();
    private am khD = new am();
    private r khO = new r();
    private z kih = new z();
    private List<bl.a> khV = new ArrayList();
    private HashSet<String> khW = new HashSet<>();

    public f() {
        this.khB = 0;
        this.khL = null;
        this.khB = 0;
        this.khL = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.khx != null && this.khx.size() > 0;
    }

    public String[] fi(Context context) {
        return p(context, true);
    }

    public String[] p(Context context, boolean z) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5 = null;
        if (!isValid()) {
            str = "";
        } else {
            int size = this.khx.size() > 30 ? 30 : this.khx.size();
            if (cKx() == null || cKx().aWl() == null || as.isEmpty(cKx().aWl().getUserId())) {
                return new String[]{null, ""};
            }
            String userId = cKx().aWl().getUserId();
            PostData cKH = cKH();
            if (cKH == null || cKH.aWl() == null || as.isEmpty(cKH.aWl().getUserId())) {
                str2 = "";
            } else {
                if (!as.equals(userId, cKH.aWl().getUserId())) {
                    str4 = null;
                } else {
                    str4 = cKH.dlp();
                }
                if (!as.isEmpty("")) {
                    str5 = str4;
                    str2 = "";
                } else {
                    str5 = str4;
                    str2 = cKH.dln();
                }
            }
            if (as.isEmpty(str2) && as.isEmpty(str5)) {
                int i = 0;
                String str6 = str2;
                while (true) {
                    if (i >= size) {
                        str = str6;
                        str3 = str5;
                        break;
                    }
                    PostData postData = (PostData) x.getItem(this.khx, i);
                    if (postData != null && postData.aWl() != null && !as.isEmpty(postData.aWl().getUserId()) && as.equals(userId, postData.aWl().getUserId())) {
                        if (as.isEmpty(str5)) {
                            str5 = postData.dlp();
                        }
                        String dln = as.isEmpty(str6) ? postData.dln() : str6;
                        if (!as.isEmpty(str5) && !as.isEmpty(dln)) {
                            str = dln;
                            str3 = str5;
                            break;
                        }
                        str6 = dln;
                    }
                    i++;
                }
            } else {
                str = str2;
                str3 = str5;
            }
            if (z && as.isEmpty(str3)) {
                str3 = "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            }
            if (this.frb != null && this.frb.aXl() != null && this.frb.aXl().getGroup_id() != 0) {
                str = "[" + context.getString(R.string.photo_live_tips) + "] " + str;
            }
            str5 = (this.frb == null || this.frb.aWD() == null || as.isEmpty(this.frb.aWD().thumbnail_url)) ? str3 : this.frb.aWD().thumbnail_url;
            if (this.frb != null && !this.frb.isShareThread && str5 == null && this.frb.dUi != null && this.frb.dUi.dPJ != null) {
                ArrayList<MediaData> arrayList = this.frb.dUi.dPJ;
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

    public br cKw() {
        return this.khw;
    }

    public void d(br brVar) {
        this.khw = brVar;
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

    public bv cKx() {
        return this.frb;
    }

    public void aD(bv bvVar) {
        this.frb = bvVar;
    }

    public List<bv> cKy() {
        return this.khH;
    }

    public String getThreadId() {
        if (this.frb == null) {
            return "";
        }
        return this.frb.getId();
    }

    public ArrayList<PostData> cKz() {
        return this.khx;
    }

    public au getPage() {
        return this.page;
    }

    public am cKA() {
        return this.khD;
    }

    public ay cKB() {
        return this.khG;
    }

    public z cKC() {
        if (this.kih == null || !this.kih.isValid()) {
            return null;
        }
        return this.kih;
    }

    public ac cKD() {
        if (this.kii == null || !this.kii.isValid()) {
            return null;
        }
        return this.kii;
    }

    public void a(au auVar, int i) {
        this.page.kR(auVar.aUZ());
        this.page.kP(auVar.aUc());
        this.page.kO(auVar.aUW());
        this.page.kS(auVar.aVa());
        this.page.kQ(auVar.aUY());
        if (i == 0) {
            this.page = auVar;
        } else if (i == 1) {
            this.page.kT(auVar.aVb());
        } else if (i == 2) {
            this.page.kU(auVar.aVc());
        }
    }

    public AntiData getAnti() {
        return this.anti;
    }

    public UserData getUserData() {
        return this.userData;
    }

    public boolean aSj() {
        return this.frb.aWs() != 0;
    }

    public void he(boolean z) {
        if (this.frb != null) {
            if (z) {
                this.frb.le(1);
            } else {
                this.frb.le(0);
            }
        }
    }

    public String aSi() {
        if (this.frb != null) {
            return this.frb.aWt();
        }
        return null;
    }

    public void Kr(String str) {
        if (this.frb != null) {
            this.frb.xa(str);
        }
    }

    public String cKE() {
        return this.khU;
    }

    public boolean cKF() {
        return (this.frb == null || this.frb.aWv() == null || this.frb.aWv().size() <= 0 || this.frb.aWv().get(0) == null || !this.frb.aWv().get(0).aUd()) ? false : true;
    }

    public PostData cKG() {
        return this.kia;
    }

    public void d(PostData postData) {
        this.kia = postData;
        this.kic = postData;
        this.kib = false;
    }

    public PostData cKH() {
        return this.kic;
    }

    public void e(PostData postData) {
        this.kic = postData;
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                com.baidu.tieba.recapp.d.a.dcN().MC(dataRes.asp_shown_info);
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
                this.khw.parserProtobuf(dataRes.display_forum);
                this.frb.setUserMap(this.userMap);
                this.frb.a(dataRes.thread);
                this.khC.a(dataRes.news_info);
                switch (this.khC.duh) {
                    case 1:
                        this.khD.ktv = this.khC;
                        break;
                    case 2:
                        this.khD.ktw = this.khC;
                        break;
                    case 3:
                        this.khD.ktx = this.khC;
                        break;
                    default:
                        this.khD.ktw = this.khC;
                        break;
                }
                this.khG.a(dataRes.recommend_book);
                b(dataRes, context);
                this.kia = new PostData();
                this.kia.Fs(1);
                this.kia.setUserMap(this.userMap);
                this.kia.vj(this.forum.isBrandForum);
                this.kia.setTime(this.frb.getCreateTime());
                if (dataRes.first_floor_post != null) {
                    this.kia.a(dataRes.first_floor_post, context);
                }
                if (this.frb != null && this.frb.isShareThread) {
                    this.kia.h(this.frb.dUi);
                }
                if (this.kic == null) {
                    this.kic = this.kia;
                    this.kib = true;
                }
                this.page.a(dataRes.page);
                this.anti.parserProtobuf(dataRes.anti);
                this.khy.a(dataRes.location);
                if (dataRes.user != null) {
                    this.khz = dataRes.user.is_manager.intValue();
                }
                this.userData.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.khE.add(muteUser);
                        }
                    }
                }
                this.frb.la(this.frb.aWc() > 0 ? this.frb.aWc() - 1 : 0);
                List<AppData> dbY = com.baidu.tieba.recapp.r.dca().dbY();
                if (dbY != null) {
                    dbY.clear();
                }
                this.khK = null;
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        com.baidu.tieba.tbadkCore.data.n nVar = new com.baidu.tieba.tbadkCore.data.n();
                        nVar.d(app);
                        AppData dkW = nVar.dkW();
                        if (!this.khJ.contains(nVar) && dkW.goods != null && (!StringUtils.isNull(dkW.goods.user_name) || !StringUtils.isNull(dkW.goods.lego_card))) {
                            nVar.kwx = cKX();
                            this.khJ.add(nVar);
                            if (dbY != null) {
                                dbY.add(nVar.dkW());
                            }
                        }
                    }
                    c(dataRes);
                    d(dataRes);
                }
                com.baidu.tieba.recapp.r.dca().dbZ();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.userData.getIsSelectTail());
                }
                this.khL.parserProtobuf(dataRes.twzhibo_anti);
                this.khi = dataRes.appeal_info;
                if (dataRes.forum_headline_img_info != null) {
                    this.khQ = new i();
                    this.khQ.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.guess_like != null) {
                    this.khk = new CardHListViewData();
                    this.khk.parseProtobuf(dataRes.guess_like);
                }
                b(dataRes);
                if (x.getCount(dataRes.repost_recommend_forum_list) > 0) {
                    if (this.khM == null) {
                        this.khM = new ArrayList();
                    }
                    for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                        br brVar = new br();
                        brVar.parserProtobuf(simpleForum);
                        this.khM.add(brVar);
                    }
                }
                if (x.getCount(dataRes.from_forum_list) > 0) {
                    if (this.khN == null) {
                        this.khN = new ArrayList();
                    }
                    for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                        if (simpleForum2 != null) {
                            br brVar2 = new br();
                            brVar2.parserProtobuf(simpleForum2);
                            this.khN.add(brVar2);
                        }
                    }
                }
                this.khU = dataRes.multi_forum_text;
                if (this.khR >= 0) {
                    this.khR = dataRes.thread_freq_num.longValue();
                }
                a(dataRes);
                if (this.khX == null) {
                    this.khX = new ArrayList();
                }
                this.khX.clear();
                if (dataRes.bjh_recommend != null) {
                    int i2 = 1;
                    for (ThreadInfo threadInfo : dataRes.bjh_recommend) {
                        if (threadInfo != null && !d(threadInfo) && !e(threadInfo)) {
                            com.baidu.tbadk.core.data.n nVar2 = new com.baidu.tbadk.core.data.n();
                            nVar2.setFloorNum(i2);
                            nVar2.a(threadInfo);
                            this.khX.add(nVar2);
                            i2++;
                        }
                    }
                }
                if (this.khZ != null && this.khZ.cUh()) {
                    this.khZ = null;
                }
                if (dataRes.recom_ala_info != null && dataRes.recom_ala_info.live_status.intValue() == 1 && dataRes.recom_ala_info.pb_display_type.intValue() == 2) {
                    if (this.khZ == null) {
                        this.khZ = new com.baidu.tieba.pb.videopb.c.a();
                        this.khZ.parserProtoBuf(dataRes.recom_ala_info);
                    }
                } else if (this.khZ == null && dataRes.promotion != null) {
                    this.khZ = new com.baidu.tieba.pb.videopb.c.a();
                    this.khZ.a(dataRes.promotion);
                }
                if (dataRes.business_promot_info != null) {
                    this.khr = dataRes.business_promot_info.is_promot.longValue() == 1;
                    this.khs = dataRes.business_promot_info.is_headlinepost.intValue() == 1;
                    this.kht = dataRes.business_promot_info.is_s_card.intValue() == 1;
                    if (dataRes.business_promot_info.send_card_info != null) {
                        b bVar = new b();
                        bVar.a(dataRes.business_promot_info.send_card_info);
                        if (this.khu == null) {
                            this.khu = new a();
                        }
                        this.khu.a(bVar);
                    }
                }
                this.kih.reset();
                this.kih.setUserMap(this.userMap);
                this.kih.a(dataRes.recom_ala_info);
                if (this.kih.kqB != null) {
                    this.kih.kqB.setTid(getThreadId());
                }
                this.kii = new ac();
                this.kii.setUserMap(this.userMap);
                this.kii.a(dataRes.recom_ala_info);
                if (this.kii.kqB != null) {
                    this.kii.kqB.setTid(getThreadId());
                }
                this.kij = dataRes.jumptotab1 == null ? null : dataRes.jumptotab1.toString();
                this.kik = dataRes.jumptotab2;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    private void b(DataRes dataRes, Context context) {
        List<Post> list = dataRes.post_list;
        if (list != null && list.size() > 0) {
            for (Post post : dataRes.post_list) {
                if (!this.khW.contains(String.valueOf(post.id))) {
                    PostData postData = new PostData();
                    postData.setUserMap(this.userMap);
                    postData.vj(this.forum.isBrandForum);
                    postData.a(post, context);
                    postData.a(cKx().aVW());
                    if (postData.aYc() != null && postData.aYc().baijiahaoData == null && cKx() != null && cKx().getBaijiahaoData() != null) {
                        postData.aYc().baijiahaoData = cKx().getBaijiahaoData();
                    }
                    this.khW.add(postData.getId());
                    if (postData.dli() == 1 && this.frb.aWZ()) {
                        if (cKF()) {
                            postData.setPostType(0);
                        } else {
                            postData.setPostType(this.frb.aWY());
                        }
                    } else if (postData.dli() == 1 && this.frb.aXt()) {
                        postData.setPostType(41);
                    } else if (postData.dli() == 1 && this.frb != null && this.frb.aUR()) {
                        postData.setPostType(0);
                        postData.boT();
                        if (this.frb.aWj() == null || this.frb.aWj().size() == 0) {
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
                            postData.c(new TbRichText((Context) TbadkCoreApplication.getInst(), this.frb.aWj(), true));
                        }
                        this.khP = postData;
                    }
                    if (postData.dli() == 1 && this.frb != null && this.frb.isShareThread) {
                        postData.h(this.frb.dUi);
                    }
                    if (postData.dli() == 1) {
                        this.kic = postData;
                        this.kib = false;
                    }
                    this.khx.add(postData);
                }
            }
        }
    }

    private void a(DataRes dataRes) {
        this.khS = new o(this.frb, this.anti);
        this.khl = dataRes.partial_visible_toast;
        if (dataRes.follow_tip != null && dataRes.follow_tip.is_toast_tip.intValue() == 1) {
            this.khA = dataRes.follow_tip.tip_text;
        }
        this.khI = new AlaLiveInfoCoreData();
        if (dataRes.ala_info != null) {
            this.khI.parserProtoBuf(dataRes.ala_info);
        }
        this.khT = dataRes.fold_tip;
        this.khm = dataRes.exp_news_today.intValue();
        this.khn = dataRes.exp_guide_today.intValue();
        if (!x.isEmpty(dataRes.thread_topic)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= dataRes.thread_topic.size()) {
                    break;
                }
                bl.a aVar = new bl.a();
                aVar.a(dataRes.thread_topic.get(i2));
                this.khV.add(aVar);
                i = i2 + 1;
            }
        }
        this.kho = dataRes.pb_sort_info;
        this.khp = dataRes.sort_type.intValue();
        if (dataRes.manager_election != null) {
            this.khq = k.b(dataRes.manager_election);
        }
    }

    private void b(DataRes dataRes) {
        if (dataRes.feed_thread_list != null && dataRes.feed_thread_list.size() > 0) {
            List<ThreadInfo> list = dataRes.feed_thread_list;
            if (this.khH == null) {
                this.khH = new ArrayList();
            }
            this.khH.clear();
            for (ThreadInfo threadInfo : list) {
                if (threadInfo != null) {
                    bv bvVar = new bv();
                    bvVar.a(threadInfo);
                    this.khH.add(bvVar);
                }
            }
            if (this.khH != null && this.khH.size() > 15) {
                this.khH = x.subList(this.khH, 0, 15);
            }
        }
    }

    private void c(DataRes dataRes) {
        List<String> wK;
        App app = dataRes.banner_list.pb_banner_ad;
        com.baidu.tieba.tbadkCore.data.n nVar = new com.baidu.tieba.tbadkCore.data.n();
        nVar.lNa = true;
        nVar.d(app);
        AppData dkW = nVar.dkW();
        if (dkW.goods != null) {
            if (x.isEmpty(dkW.goods.thread_pic_list) && (wK = AdvertAppInfo.a.wK(dkW.goods.lego_card)) != null && dkW.goods.thread_pic_list != null) {
                dkW.goods.thread_pic_list.addAll(wK);
            }
            this.khK = nVar;
        }
    }

    private void d(DataRes dataRes) {
        List<App> list = dataRes.banner_list.video_recommend_ad;
        this.kig.clear();
        if (list != null && !list.isEmpty()) {
            for (App app : list) {
                com.baidu.tieba.tbadkCore.data.n nVar = new com.baidu.tieba.tbadkCore.data.n();
                nVar.d(app);
                AppData dkW = nVar.dkW();
                if (!this.kig.contains(nVar) && dkW.goods != null && (!StringUtils.isNull(dkW.goods.user_name) || !StringUtils.isNull(dkW.goods.lego_card))) {
                    nVar.kwx = cKX();
                    this.kig.add(nVar);
                }
            }
        }
    }

    public String cKI() {
        return this.khT;
    }

    public CardHListViewData cKJ() {
        return this.khk;
    }

    public PostData cKK() {
        return this.khP;
    }

    public PostData f(PostData postData) {
        this.khP = postData;
        return postData;
    }

    public r cKL() {
        return this.khO;
    }

    public int cKM() {
        return this.khz;
    }

    public int getIsNewUrl() {
        return this.khB;
    }

    public void setIsNewUrl(int i) {
        this.khB = i;
    }

    public List<MuteUser> cKN() {
        return this.khE;
    }

    public ArrayList<com.baidu.tieba.tbadkCore.data.n> cKO() {
        return this.khJ;
    }

    public com.baidu.tieba.tbadkCore.data.n cKP() {
        return this.khK;
    }

    public void b(com.baidu.tieba.tbadkCore.data.n nVar) {
        this.khK = nVar;
    }

    public void cKQ() {
        if (this.khK.dkW() != null) {
            this.khK.dkW().legoCard = null;
        }
        this.khK = null;
    }

    public void cKR() {
        this.kih = null;
        this.kii = null;
    }

    public String cKS() {
        return this.khj;
    }

    public void Ks(String str) {
        this.khj = str;
    }

    public i cKT() {
        return this.khQ;
    }

    public List<br> cKU() {
        return this.khN;
    }

    public long cKV() {
        return this.khR;
    }

    public o cKW() {
        return this.khS;
    }

    public void a(o oVar) {
        this.khS = oVar;
    }

    public boolean cKX() {
        return (cKx() == null || !cKx().aUR() || cKx().aWD() == null) ? false : true;
    }

    public AlaLiveInfoCoreData cKY() {
        return this.khI;
    }

    public List<com.baidu.tbadk.core.data.n> cKZ() {
        return this.khX;
    }

    public boolean cLa() {
        return cKx() != null && cKx().aUV();
    }

    public String cLb() {
        if (this.kho != null && this.kho.size() > this.khp) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.kho.size()) {
                    break;
                } else if (this.kho.get(i2).sort_type.intValue() != this.khp) {
                    i = i2 + 1;
                } else {
                    return this.kho.get(i2).sort_name;
                }
            }
        }
        return "";
    }

    public com.baidu.tieba.pb.videopb.c.a cLc() {
        return this.khZ;
    }

    public int cLd() {
        return this.khY;
    }

    public void Bw(int i) {
        this.khY = i;
    }

    public List<com.baidu.tieba.tbadkCore.data.n> cLe() {
        return this.kig;
    }

    private boolean d(ThreadInfo threadInfo) {
        if (threadInfo == null || getThreadId() == null || "0".equals(threadInfo.id) || "0".equals(threadInfo.tid)) {
            return false;
        }
        return getThreadId().equals(threadInfo.id) || getThreadId().equals(threadInfo.tid);
    }

    private boolean e(ThreadInfo threadInfo) {
        if (threadInfo == null || threadInfo.baijiahao == null || threadInfo.baijiahao.ori_ugc_nid == null || this.frb == null || this.frb.getBaijiahaoData() == null || this.frb.getBaijiahaoData().oriUgcNid == null || "0".equals(threadInfo.baijiahao.ori_ugc_nid)) {
            return false;
        }
        return threadInfo.baijiahao.ori_ugc_nid.equals(this.frb.getBaijiahaoData().oriUgcNid);
    }
}

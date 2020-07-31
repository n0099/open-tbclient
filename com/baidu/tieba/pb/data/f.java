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
    private List<bv> khF;
    private AlaLiveInfoCoreData khG;
    private TwzhiboAnti khJ;
    private List<br> khK;
    private List<br> khL;
    private PostData khN;
    private i khO;
    private long khP;
    private o khQ;
    private String khR;
    private String khS;
    private List<com.baidu.tbadk.core.data.n> khV;
    private com.baidu.tieba.pb.videopb.c.a khX;
    private PostData khY;
    public AppealInfo khg;
    public String khh;
    public CardHListViewData khi;
    public String khj;
    public int khk;
    public int khl;
    public List<PbSortType> khm;
    public int khn;
    public k kho;
    public a khs;
    private String khy;
    private int khz;
    private PostData kia;
    public boolean kic;
    private ac kig;
    public String kih;
    public String kii;
    public boolean khp = false;
    public boolean khq = false;
    public boolean khr = false;
    public boolean kht = false;
    private boolean khD = true;
    private ArrayList<com.baidu.tieba.tbadkCore.data.n> khH = new ArrayList<>();
    private com.baidu.tieba.tbadkCore.data.n khI = null;
    private int khW = 0;
    public boolean khZ = true;
    public int kib = 0;
    public int Xq = 0;
    private List<com.baidu.tieba.tbadkCore.data.n> kie = new ArrayList();
    private ForumData forum = new ForumData();
    private br khu = new br();
    private bv frb = new bv();
    private ArrayList<PostData> khv = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private au page = new au();
    private AntiData anti = new AntiData();
    private com.baidu.tbadk.data.f khw = new com.baidu.tbadk.data.f();
    private int khx = 0;
    private final UserData userData = new UserData();
    private List<MuteUser> khC = new ArrayList();
    private ax khA = new ax();
    private ay khE = new ay();
    private am khB = new am();
    private r khM = new r();
    private z kif = new z();
    private List<bl.a> khT = new ArrayList();
    private HashSet<String> khU = new HashSet<>();

    public f() {
        this.khz = 0;
        this.khJ = null;
        this.khz = 0;
        this.khJ = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.khv != null && this.khv.size() > 0;
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
            int size = this.khv.size() > 30 ? 30 : this.khv.size();
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
                    str4 = cKH.dlo();
                }
                if (!as.isEmpty("")) {
                    str5 = str4;
                    str2 = "";
                } else {
                    str5 = str4;
                    str2 = cKH.dlm();
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
                    PostData postData = (PostData) x.getItem(this.khv, i);
                    if (postData != null && postData.aWl() != null && !as.isEmpty(postData.aWl().getUserId()) && as.equals(userId, postData.aWl().getUserId())) {
                        if (as.isEmpty(str5)) {
                            str5 = postData.dlo();
                        }
                        String dlm = as.isEmpty(str6) ? postData.dlm() : str6;
                        if (!as.isEmpty(str5) && !as.isEmpty(dlm)) {
                            str = dlm;
                            str3 = str5;
                            break;
                        }
                        str6 = dlm;
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
        return this.khu;
    }

    public void d(br brVar) {
        this.khu = brVar;
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
        return this.khF;
    }

    public String getThreadId() {
        if (this.frb == null) {
            return "";
        }
        return this.frb.getId();
    }

    public ArrayList<PostData> cKz() {
        return this.khv;
    }

    public au getPage() {
        return this.page;
    }

    public am cKA() {
        return this.khB;
    }

    public ay cKB() {
        return this.khE;
    }

    public z cKC() {
        if (this.kif == null || !this.kif.isValid()) {
            return null;
        }
        return this.kif;
    }

    public ac cKD() {
        if (this.kig == null || !this.kig.isValid()) {
            return null;
        }
        return this.kig;
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
        return this.khS;
    }

    public boolean cKF() {
        return (this.frb == null || this.frb.aWv() == null || this.frb.aWv().size() <= 0 || this.frb.aWv().get(0) == null || !this.frb.aWv().get(0).aUd()) ? false : true;
    }

    public PostData cKG() {
        return this.khY;
    }

    public void d(PostData postData) {
        this.khY = postData;
        this.kia = postData;
        this.khZ = false;
    }

    public PostData cKH() {
        return this.kia;
    }

    public void e(PostData postData) {
        this.kia = postData;
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
                this.khu.parserProtobuf(dataRes.display_forum);
                this.frb.setUserMap(this.userMap);
                this.frb.a(dataRes.thread);
                this.khA.a(dataRes.news_info);
                switch (this.khA.duh) {
                    case 1:
                        this.khB.ktt = this.khA;
                        break;
                    case 2:
                        this.khB.ktu = this.khA;
                        break;
                    case 3:
                        this.khB.ktv = this.khA;
                        break;
                    default:
                        this.khB.ktu = this.khA;
                        break;
                }
                this.khE.a(dataRes.recommend_book);
                b(dataRes, context);
                this.khY = new PostData();
                this.khY.Fs(1);
                this.khY.setUserMap(this.userMap);
                this.khY.vj(this.forum.isBrandForum);
                this.khY.setTime(this.frb.getCreateTime());
                if (dataRes.first_floor_post != null) {
                    this.khY.a(dataRes.first_floor_post, context);
                }
                if (this.frb != null && this.frb.isShareThread) {
                    this.khY.h(this.frb.dUi);
                }
                if (this.kia == null) {
                    this.kia = this.khY;
                    this.khZ = true;
                }
                this.page.a(dataRes.page);
                this.anti.parserProtobuf(dataRes.anti);
                this.khw.a(dataRes.location);
                if (dataRes.user != null) {
                    this.khx = dataRes.user.is_manager.intValue();
                }
                this.userData.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.khC.add(muteUser);
                        }
                    }
                }
                this.frb.la(this.frb.aWc() > 0 ? this.frb.aWc() - 1 : 0);
                List<AppData> dbY = com.baidu.tieba.recapp.r.dca().dbY();
                if (dbY != null) {
                    dbY.clear();
                }
                this.khI = null;
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        com.baidu.tieba.tbadkCore.data.n nVar = new com.baidu.tieba.tbadkCore.data.n();
                        nVar.d(app);
                        AppData dkV = nVar.dkV();
                        if (!this.khH.contains(nVar) && dkV.goods != null && (!StringUtils.isNull(dkV.goods.user_name) || !StringUtils.isNull(dkV.goods.lego_card))) {
                            nVar.kwv = cKX();
                            this.khH.add(nVar);
                            if (dbY != null) {
                                dbY.add(nVar.dkV());
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
                this.khJ.parserProtobuf(dataRes.twzhibo_anti);
                this.khg = dataRes.appeal_info;
                if (dataRes.forum_headline_img_info != null) {
                    this.khO = new i();
                    this.khO.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.guess_like != null) {
                    this.khi = new CardHListViewData();
                    this.khi.parseProtobuf(dataRes.guess_like);
                }
                b(dataRes);
                if (x.getCount(dataRes.repost_recommend_forum_list) > 0) {
                    if (this.khK == null) {
                        this.khK = new ArrayList();
                    }
                    for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                        br brVar = new br();
                        brVar.parserProtobuf(simpleForum);
                        this.khK.add(brVar);
                    }
                }
                if (x.getCount(dataRes.from_forum_list) > 0) {
                    if (this.khL == null) {
                        this.khL = new ArrayList();
                    }
                    for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                        if (simpleForum2 != null) {
                            br brVar2 = new br();
                            brVar2.parserProtobuf(simpleForum2);
                            this.khL.add(brVar2);
                        }
                    }
                }
                this.khS = dataRes.multi_forum_text;
                if (this.khP >= 0) {
                    this.khP = dataRes.thread_freq_num.longValue();
                }
                a(dataRes);
                if (this.khV == null) {
                    this.khV = new ArrayList();
                }
                this.khV.clear();
                if (dataRes.bjh_recommend != null) {
                    int i2 = 1;
                    for (ThreadInfo threadInfo : dataRes.bjh_recommend) {
                        if (threadInfo != null && !d(threadInfo) && !e(threadInfo)) {
                            com.baidu.tbadk.core.data.n nVar2 = new com.baidu.tbadk.core.data.n();
                            nVar2.setFloorNum(i2);
                            nVar2.a(threadInfo);
                            this.khV.add(nVar2);
                            i2++;
                        }
                    }
                }
                if (this.khX != null && this.khX.cUh()) {
                    this.khX = null;
                }
                if (dataRes.recom_ala_info != null && dataRes.recom_ala_info.live_status.intValue() == 1 && dataRes.recom_ala_info.pb_display_type.intValue() == 2) {
                    if (this.khX == null) {
                        this.khX = new com.baidu.tieba.pb.videopb.c.a();
                        this.khX.parserProtoBuf(dataRes.recom_ala_info);
                    }
                } else if (this.khX == null && dataRes.promotion != null) {
                    this.khX = new com.baidu.tieba.pb.videopb.c.a();
                    this.khX.a(dataRes.promotion);
                }
                if (dataRes.business_promot_info != null) {
                    this.khp = dataRes.business_promot_info.is_promot.longValue() == 1;
                    this.khq = dataRes.business_promot_info.is_headlinepost.intValue() == 1;
                    this.khr = dataRes.business_promot_info.is_s_card.intValue() == 1;
                    if (dataRes.business_promot_info.send_card_info != null) {
                        b bVar = new b();
                        bVar.a(dataRes.business_promot_info.send_card_info);
                        if (this.khs == null) {
                            this.khs = new a();
                        }
                        this.khs.a(bVar);
                    }
                }
                this.kif.reset();
                this.kif.setUserMap(this.userMap);
                this.kif.a(dataRes.recom_ala_info);
                if (this.kif.kqz != null) {
                    this.kif.kqz.setTid(getThreadId());
                }
                this.kig = new ac();
                this.kig.setUserMap(this.userMap);
                this.kig.a(dataRes.recom_ala_info);
                if (this.kig.kqz != null) {
                    this.kig.kqz.setTid(getThreadId());
                }
                this.kih = dataRes.jumptotab1 == null ? null : dataRes.jumptotab1.toString();
                this.kii = dataRes.jumptotab2;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    private void b(DataRes dataRes, Context context) {
        List<Post> list = dataRes.post_list;
        if (list != null && list.size() > 0) {
            for (Post post : dataRes.post_list) {
                if (!this.khU.contains(String.valueOf(post.id))) {
                    PostData postData = new PostData();
                    postData.setUserMap(this.userMap);
                    postData.vj(this.forum.isBrandForum);
                    postData.a(post, context);
                    postData.a(cKx().aVW());
                    if (postData.aYc() != null && postData.aYc().baijiahaoData == null && cKx() != null && cKx().getBaijiahaoData() != null) {
                        postData.aYc().baijiahaoData = cKx().getBaijiahaoData();
                    }
                    this.khU.add(postData.getId());
                    if (postData.dlh() == 1 && this.frb.aWZ()) {
                        if (cKF()) {
                            postData.setPostType(0);
                        } else {
                            postData.setPostType(this.frb.aWY());
                        }
                    } else if (postData.dlh() == 1 && this.frb.aXt()) {
                        postData.setPostType(41);
                    } else if (postData.dlh() == 1 && this.frb != null && this.frb.aUR()) {
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
                        this.khN = postData;
                    }
                    if (postData.dlh() == 1 && this.frb != null && this.frb.isShareThread) {
                        postData.h(this.frb.dUi);
                    }
                    if (postData.dlh() == 1) {
                        this.kia = postData;
                        this.khZ = false;
                    }
                    this.khv.add(postData);
                }
            }
        }
    }

    private void a(DataRes dataRes) {
        this.khQ = new o(this.frb, this.anti);
        this.khj = dataRes.partial_visible_toast;
        if (dataRes.follow_tip != null && dataRes.follow_tip.is_toast_tip.intValue() == 1) {
            this.khy = dataRes.follow_tip.tip_text;
        }
        this.khG = new AlaLiveInfoCoreData();
        if (dataRes.ala_info != null) {
            this.khG.parserProtoBuf(dataRes.ala_info);
        }
        this.khR = dataRes.fold_tip;
        this.khk = dataRes.exp_news_today.intValue();
        this.khl = dataRes.exp_guide_today.intValue();
        if (!x.isEmpty(dataRes.thread_topic)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= dataRes.thread_topic.size()) {
                    break;
                }
                bl.a aVar = new bl.a();
                aVar.a(dataRes.thread_topic.get(i2));
                this.khT.add(aVar);
                i = i2 + 1;
            }
        }
        this.khm = dataRes.pb_sort_info;
        this.khn = dataRes.sort_type.intValue();
        if (dataRes.manager_election != null) {
            this.kho = k.b(dataRes.manager_election);
        }
    }

    private void b(DataRes dataRes) {
        if (dataRes.feed_thread_list != null && dataRes.feed_thread_list.size() > 0) {
            List<ThreadInfo> list = dataRes.feed_thread_list;
            if (this.khF == null) {
                this.khF = new ArrayList();
            }
            this.khF.clear();
            for (ThreadInfo threadInfo : list) {
                if (threadInfo != null) {
                    bv bvVar = new bv();
                    bvVar.a(threadInfo);
                    this.khF.add(bvVar);
                }
            }
            if (this.khF != null && this.khF.size() > 15) {
                this.khF = x.subList(this.khF, 0, 15);
            }
        }
    }

    private void c(DataRes dataRes) {
        List<String> wK;
        App app = dataRes.banner_list.pb_banner_ad;
        com.baidu.tieba.tbadkCore.data.n nVar = new com.baidu.tieba.tbadkCore.data.n();
        nVar.lMY = true;
        nVar.d(app);
        AppData dkV = nVar.dkV();
        if (dkV.goods != null) {
            if (x.isEmpty(dkV.goods.thread_pic_list) && (wK = AdvertAppInfo.a.wK(dkV.goods.lego_card)) != null && dkV.goods.thread_pic_list != null) {
                dkV.goods.thread_pic_list.addAll(wK);
            }
            this.khI = nVar;
        }
    }

    private void d(DataRes dataRes) {
        List<App> list = dataRes.banner_list.video_recommend_ad;
        this.kie.clear();
        if (list != null && !list.isEmpty()) {
            for (App app : list) {
                com.baidu.tieba.tbadkCore.data.n nVar = new com.baidu.tieba.tbadkCore.data.n();
                nVar.d(app);
                AppData dkV = nVar.dkV();
                if (!this.kie.contains(nVar) && dkV.goods != null && (!StringUtils.isNull(dkV.goods.user_name) || !StringUtils.isNull(dkV.goods.lego_card))) {
                    nVar.kwv = cKX();
                    this.kie.add(nVar);
                }
            }
        }
    }

    public String cKI() {
        return this.khR;
    }

    public CardHListViewData cKJ() {
        return this.khi;
    }

    public PostData cKK() {
        return this.khN;
    }

    public PostData f(PostData postData) {
        this.khN = postData;
        return postData;
    }

    public r cKL() {
        return this.khM;
    }

    public int cKM() {
        return this.khx;
    }

    public int getIsNewUrl() {
        return this.khz;
    }

    public void setIsNewUrl(int i) {
        this.khz = i;
    }

    public List<MuteUser> cKN() {
        return this.khC;
    }

    public ArrayList<com.baidu.tieba.tbadkCore.data.n> cKO() {
        return this.khH;
    }

    public com.baidu.tieba.tbadkCore.data.n cKP() {
        return this.khI;
    }

    public void b(com.baidu.tieba.tbadkCore.data.n nVar) {
        this.khI = nVar;
    }

    public void cKQ() {
        if (this.khI.dkV() != null) {
            this.khI.dkV().legoCard = null;
        }
        this.khI = null;
    }

    public void cKR() {
        this.kif = null;
        this.kig = null;
    }

    public String cKS() {
        return this.khh;
    }

    public void Ks(String str) {
        this.khh = str;
    }

    public i cKT() {
        return this.khO;
    }

    public List<br> cKU() {
        return this.khL;
    }

    public long cKV() {
        return this.khP;
    }

    public o cKW() {
        return this.khQ;
    }

    public void a(o oVar) {
        this.khQ = oVar;
    }

    public boolean cKX() {
        return (cKx() == null || !cKx().aUR() || cKx().aWD() == null) ? false : true;
    }

    public AlaLiveInfoCoreData cKY() {
        return this.khG;
    }

    public List<com.baidu.tbadk.core.data.n> cKZ() {
        return this.khV;
    }

    public boolean cLa() {
        return cKx() != null && cKx().aUV();
    }

    public String cLb() {
        if (this.khm != null && this.khm.size() > this.khn) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.khm.size()) {
                    break;
                } else if (this.khm.get(i2).sort_type.intValue() != this.khn) {
                    i = i2 + 1;
                } else {
                    return this.khm.get(i2).sort_name;
                }
            }
        }
        return "";
    }

    public com.baidu.tieba.pb.videopb.c.a cLc() {
        return this.khX;
    }

    public int cLd() {
        return this.khW;
    }

    public void Bw(int i) {
        this.khW = i;
    }

    public List<com.baidu.tieba.tbadkCore.data.n> cLe() {
        return this.kie;
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

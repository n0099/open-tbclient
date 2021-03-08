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
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.br;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.pb.pb.main.af;
import com.baidu.tieba.pb.pb.main.v;
import com.baidu.tieba.pb.pb.main.x;
import com.baidu.tieba.recapp.constants.Cmatch;
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
import tbclient.ForumRuleStatus;
import tbclient.PbPage.AppealInfo;
import tbclient.PbPage.DataRes;
import tbclient.PbPage.PbSortType;
import tbclient.Post;
import tbclient.SimpleForum;
import tbclient.SimpleUser;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes2.dex */
public class f {
    private ForumRuleStatus forumRule;
    private int lMA;
    private List<cb> lMG;
    private AlaLiveInfoCoreData lMH;
    private TwzhiboAnti lMK;
    private List<bx> lML;
    private List<bx> lMM;
    private PostData lMO;
    private j lMP;
    private long lMQ;
    private p lMR;
    private String lMS;
    private String lMT;
    private List<com.baidu.tbadk.core.data.p> lMW;
    private com.baidu.tieba.pb.videopb.c.a lMY;
    private PostData lMZ;
    public AppealInfo lMi;
    public String lMj;
    public CardHListViewData lMk;
    public String lMl;
    public int lMm;
    public int lMn;
    public List<PbSortType> lMo;
    public int lMp;
    public l lMq;
    public a lMu;
    private String lMz;
    private PostData lNb;
    public boolean lNd;
    private x lNg;
    public String lNh;
    public String lNi;
    private List<ThreadInfo> lNj;
    private com.baidu.tbadk.data.d lNk;
    public boolean lMr = false;
    public boolean lMs = false;
    public boolean lMt = false;
    public boolean lMv = false;
    private boolean lME = true;
    private ArrayList<com.baidu.tieba.tbadkCore.data.o> lMI = new ArrayList<>();
    private com.baidu.tieba.tbadkCore.data.o lMJ = null;
    private int lMX = 0;
    public boolean lNa = true;
    public int lNc = 0;
    public int abG = 0;
    private List<com.baidu.tieba.tbadkCore.data.o> lNe = new ArrayList();
    private boolean lNl = false;
    private ForumData forum = new ForumData();
    private bx lMw = new bx();
    private cb gAx = new cb();
    private ArrayList<PostData> lMx = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private az page = new az();
    private AntiData anti = new AntiData();
    private com.baidu.tbadk.data.g lMy = new com.baidu.tbadk.data.g();
    private int userIdentity = 0;
    private final UserData userData = new UserData();
    private List<MuteUser> lMD = new ArrayList();
    private bc lMB = new bc();
    private bd lMF = new bd();
    private af lMC = new af();
    private s lMN = new s();
    private v lNf = new v();
    private List<br.a> lMU = new ArrayList();
    private HashSet<String> lMV = new HashSet<>();

    public f() {
        this.lMA = 0;
        this.lMK = null;
        this.lMA = 0;
        this.lMK = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.lMx != null && this.lMx.size() > 0;
    }

    public String[] gK(Context context) {
        return t(context, true);
    }

    public String[] t(Context context, boolean z) {
        String str;
        String str2;
        String str3;
        String str4 = null;
        String str5 = "";
        if (!isValid()) {
            str = "";
        } else {
            int size = this.lMx.size() > 30 ? 30 : this.lMx.size();
            if (dlp() == null || dlp().bnS() == null || au.isEmpty(dlp().bnS().getUserId())) {
                return new String[]{null, ""};
            }
            String userId = dlp().bnS().getUserId();
            PostData dlz = dlz();
            if (dlz == null || dlz.bnS() == null || au.isEmpty(dlz.bnS().getUserId())) {
                str2 = null;
            } else {
                if (!au.equals(userId, dlz.bnS().getUserId())) {
                    str2 = null;
                } else {
                    str2 = dlz.dNV();
                }
                if (au.isEmpty("")) {
                    str5 = dlz.dNT();
                }
            }
            if (au.isEmpty(str5) && au.isEmpty(str2)) {
                int i = 0;
                String str6 = str2;
                while (true) {
                    if (i >= size) {
                        str3 = str6;
                        break;
                    }
                    PostData postData = (PostData) y.getItem(this.lMx, i);
                    if (postData != null && postData.bnS() != null && !au.isEmpty(postData.bnS().getUserId()) && au.equals(userId, postData.bnS().getUserId())) {
                        if (au.isEmpty(str6)) {
                            str6 = postData.dNV();
                        }
                        String dNT = au.isEmpty(str5) ? postData.dNT() : str5;
                        if (!au.isEmpty(str6) && !au.isEmpty(dNT)) {
                            str5 = dNT;
                            str3 = str6;
                            break;
                        }
                        str5 = dNT;
                    }
                    i++;
                }
            } else {
                str3 = str2;
            }
            String str7 = (z && au.isEmpty(str3)) ? "https://tieba-fe.gz.bcebos.com/yunying/tieba_logo.jpg" : str3;
            str = (this.gAx == null || this.gAx.boT() == null || this.gAx.boT().getGroup_id() == 0) ? str5 : "[" + context.getString(R.string.photo_live_tips) + "] " + str5;
            str4 = (this.gAx == null || this.gAx.boj() == null || au.isEmpty(this.gAx.boj().thumbnail_url)) ? str7 : this.gAx.boj().thumbnail_url;
            if (this.gAx != null && !this.gAx.isShareThread && str4 == null && this.gAx.eUD != null && this.gAx.eUD.ePU != null) {
                ArrayList<MediaData> arrayList = this.gAx.eUD.ePU;
                int size2 = arrayList.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size2) {
                        break;
                    }
                    MediaData mediaData = arrayList.get(i2);
                    if (mediaData != null && (mediaData.getType() == 3 || mediaData.getType() == 5)) {
                        if (!StringUtils.isNull(mediaData.getThumbnails_url())) {
                            str4 = mediaData.getThumbnails_url();
                            break;
                        } else if (!StringUtils.isNull(mediaData.getPicUrl())) {
                            str4 = mediaData.getPicUrl();
                            break;
                        }
                    }
                    i2++;
                }
            }
        }
        return new String[]{str4, str};
    }

    public ForumData getForum() {
        return this.forum;
    }

    public bx dlo() {
        return this.lMw;
    }

    public void d(bx bxVar) {
        this.lMw = bxVar;
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

    public cb dlp() {
        return this.gAx;
    }

    public void aJ(cb cbVar) {
        this.gAx = cbVar;
    }

    public List<cb> dlq() {
        return this.lMG;
    }

    public String getThreadId() {
        if (this.gAx == null) {
            return "";
        }
        return this.gAx.getId();
    }

    public ArrayList<PostData> dlr() {
        return this.lMx;
    }

    public az getPage() {
        return this.page;
    }

    public af dls() {
        return this.lMC;
    }

    public bd dlt() {
        return this.lMF;
    }

    public v dlu() {
        if (this.lNf == null || !this.lNf.isValid()) {
            return null;
        }
        return this.lNf;
    }

    public x dlv() {
        if (this.lNg == null || !this.lNg.isValid()) {
            return null;
        }
        return this.lNg;
    }

    public void a(az azVar, int i) {
        this.page.nc(azVar.bmF());
        this.page.na(azVar.blD());
        this.page.mZ(azVar.bmC());
        this.page.nd(azVar.bmG());
        this.page.nb(azVar.bmE());
        if (i == 0) {
            this.page = azVar;
        } else if (i == 1) {
            this.page.ne(azVar.bmH());
        } else if (i == 2) {
            this.page.nf(azVar.bmI());
        }
    }

    public AntiData getAnti() {
        return this.anti;
    }

    public UserData getUserData() {
        return this.userData;
    }

    public boolean bkb() {
        return this.gAx.bnZ() != 0;
    }

    public void ja(boolean z) {
        if (this.gAx != null) {
            if (z) {
                this.gAx.np(1);
            } else {
                this.gAx.np(0);
            }
        }
    }

    public String bka() {
        if (this.gAx != null) {
            return this.gAx.boa();
        }
        return null;
    }

    public void Pr(String str) {
        if (this.gAx != null) {
            this.gAx.Aq(str);
        }
    }

    public String dlw() {
        return this.lMT;
    }

    public boolean dlx() {
        return (this.gAx == null || this.gAx.boc() == null || this.gAx.boc().size() <= 0 || this.gAx.boc().get(0) == null || !this.gAx.boc().get(0).blE()) ? false : true;
    }

    public PostData dly() {
        return this.lMZ;
    }

    public void d(PostData postData) {
        this.lMZ = postData;
        this.lNb = postData;
        this.lNa = false;
    }

    public PostData dlz() {
        return this.lNb;
    }

    public void e(PostData postData) {
        this.lNb = postData;
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                com.baidu.tieba.recapp.c.a.dEu().RV(dataRes.asp_shown_info);
                List<User> list = dataRes.user_list;
                if (list != null) {
                    for (int i = 0; i < list.size(); i++) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(list.get(i));
                        String userId = metaData.getUserId();
                        if (userId != null && !userId.equals("0")) {
                            this.userMap.put(metaData.getUserId(), metaData);
                        }
                        if (i == 0) {
                            this.lNk = metaData.getBusinessAccountData();
                        }
                    }
                }
                setIsNewUrl(dataRes.is_new_url.intValue());
                this.forum.parserProtobuf(dataRes.forum);
                this.lMw.parserProtobuf(dataRes.display_forum);
                this.gAx.setUserMap(this.userMap);
                this.gAx.a(dataRes.thread);
                if (this.gAx.bnS() != null && this.gAx.bnS().getBusinessAccountData() == null) {
                    this.gAx.bnS().setBusinessAccountData(this.lNk);
                }
                this.lMB.a(dataRes.news_info);
                switch (this.lMB.euv) {
                    case 1:
                        this.lMC.lZw = this.lMB;
                        break;
                    case 2:
                        this.lMC.lZx = this.lMB;
                        break;
                    case 3:
                        this.lMC.lZy = this.lMB;
                        break;
                    default:
                        this.lMC.lZx = this.lMB;
                        break;
                }
                this.lMF.a(dataRes.recommend_book);
                b(dataRes, context);
                this.lMZ = new PostData();
                this.lMZ.JJ(1);
                this.lMZ.setUserMap(this.userMap);
                this.lMZ.yr(this.forum.isBrandForum);
                this.lMZ.setTime(this.gAx.getCreateTime());
                if (dataRes.first_floor_post != null) {
                    this.lMZ.a(dataRes.first_floor_post, context);
                }
                if (this.gAx != null && this.gAx.isShareThread) {
                    this.lMZ.h(this.gAx.eUD);
                }
                if (this.lNb == null) {
                    this.lNb = this.lMZ;
                    this.lNa = true;
                }
                this.page.a(dataRes.page);
                this.anti.parserProtobuf(dataRes.anti);
                this.lMy.a(dataRes.location);
                if (dataRes.user != null) {
                    this.userIdentity = dataRes.user.is_manager.intValue();
                }
                this.userData.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.lMD.add(muteUser);
                        }
                    }
                }
                this.gAx.nl(this.gAx.bnJ() > 0 ? this.gAx.bnJ() - 1 : 0);
                List<AppData> dDz = com.baidu.tieba.recapp.s.dDB().dDz();
                if (dDz != null) {
                    dDz.clear();
                }
                this.lMJ = null;
                this.lNl = false;
                if (dataRes.banner_list != null) {
                    List<App> list2 = dataRes.banner_list.app;
                    c(dataRes);
                    for (App app : list2) {
                        com.baidu.tieba.tbadkCore.data.o oVar = new com.baidu.tieba.tbadkCore.data.o();
                        App a2 = com.baidu.tieba.recapp.s.dDB().a(app, dlP() ? Cmatch.VIDEO_PB_COMMENT : Cmatch.PB_COMMENT);
                        if (a2 != null && !this.lNl && !com.baidu.tieba.recapp.a.a(a2, dataRes.banner_list)) {
                            oVar.eNm = true;
                            this.lNl = true;
                            app = a2;
                        }
                        oVar.h(app);
                        AppData dNC = oVar.dNC();
                        if (!this.lMI.contains(oVar) && dNC.goods != null && (!StringUtils.isNull(dNC.goods.user_name) || !StringUtils.isNull(dNC.goods.lego_card))) {
                            oVar.mcB = dlP();
                            this.lMI.add(oVar);
                            if (dDz != null) {
                                dDz.add(oVar.dNC());
                            }
                        }
                    }
                    d(dataRes);
                }
                com.baidu.tieba.recapp.s.dDB().dDA();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.userData.getIsSelectTail());
                }
                this.lMK.parserProtobuf(dataRes.twzhibo_anti);
                this.lMi = dataRes.appeal_info;
                if (dataRes.forum_headline_img_info != null) {
                    this.lMP = new j();
                    this.lMP.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.guess_like != null) {
                    this.lMk = new CardHListViewData();
                    this.lMk.parseProtobuf(dataRes.guess_like);
                }
                b(dataRes);
                if (y.getCount(dataRes.repost_recommend_forum_list) > 0) {
                    if (this.lML == null) {
                        this.lML = new ArrayList();
                    }
                    for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                        bx bxVar = new bx();
                        bxVar.parserProtobuf(simpleForum);
                        this.lML.add(bxVar);
                    }
                }
                if (y.getCount(dataRes.from_forum_list) > 0) {
                    if (this.lMM == null) {
                        this.lMM = new ArrayList();
                    }
                    for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                        if (simpleForum2 != null) {
                            bx bxVar2 = new bx();
                            bxVar2.parserProtobuf(simpleForum2);
                            this.lMM.add(bxVar2);
                        }
                    }
                }
                this.lMT = dataRes.multi_forum_text;
                if (this.lMQ >= 0) {
                    this.lMQ = dataRes.thread_freq_num.longValue();
                }
                a(dataRes);
                if (this.lMW == null) {
                    this.lMW = new ArrayList();
                }
                this.lMW.clear();
                if (dataRes.bjh_recommend != null) {
                    int i2 = 1;
                    for (ThreadInfo threadInfo : dataRes.bjh_recommend) {
                        if (threadInfo != null && !d(threadInfo) && !e(threadInfo)) {
                            com.baidu.tbadk.core.data.p pVar = new com.baidu.tbadk.core.data.p();
                            pVar.setFloorNum(i2);
                            pVar.a(threadInfo);
                            this.lMW.add(pVar);
                            i2++;
                        }
                    }
                }
                if (this.lMY != null && this.lMY.dvx()) {
                    this.lMY = null;
                }
                if (dataRes.recom_ala_info != null && dataRes.recom_ala_info.live_status.intValue() == 1 && dataRes.recom_ala_info.pb_display_type.intValue() == 2) {
                    if (this.lMY == null) {
                        this.lMY = new com.baidu.tieba.pb.videopb.c.a();
                        this.lMY.parserProtoBuf(dataRes.recom_ala_info);
                    }
                } else if (this.lMY == null && dataRes.promotion != null) {
                    this.lMY = new com.baidu.tieba.pb.videopb.c.a();
                    this.lMY.a(dataRes.promotion);
                }
                if (dataRes.business_promot_info != null) {
                    this.lMr = dataRes.business_promot_info.is_promot.longValue() == 1;
                    this.lMs = dataRes.business_promot_info.is_headlinepost.intValue() == 1;
                    this.lMt = dataRes.business_promot_info.is_s_card.intValue() == 1;
                    if (dataRes.business_promot_info.send_card_info != null) {
                        b bVar = new b();
                        bVar.a(dataRes.business_promot_info.send_card_info);
                        if (this.lMu == null) {
                            this.lMu = new a();
                        }
                        this.lMu.a(bVar);
                    }
                }
                this.lNf.reset();
                this.lNf.setUserMap(this.userMap);
                this.lNf.a(dataRes.recom_ala_info);
                if (this.lNf.lWn != null) {
                    this.lNf.lWn.setTid(getThreadId());
                }
                this.lNg = new x();
                this.lNg.setUserMap(this.userMap);
                this.lNg.a(dataRes.recom_ala_info);
                if (this.lNg.lWn != null) {
                    this.lNg.lWn.setTid(getThreadId());
                }
                if (y.getCount(dataRes.recom_thread_info) > 0) {
                    this.lNj = dataRes.recom_thread_info;
                }
                this.lNh = dataRes.jumptotab1 == null ? null : dataRes.jumptotab1.toString();
                this.lNi = dataRes.jumptotab2;
                if (dataRes.forum_rule != null) {
                    this.forumRule = dataRes.forum_rule;
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    private void b(DataRes dataRes, Context context) {
        List<Post> list = dataRes.post_list;
        if (list != null && list.size() > 0) {
            for (Post post : dataRes.post_list) {
                if (!this.lMV.contains(String.valueOf(post.id))) {
                    PostData postData = new PostData();
                    postData.setUserMap(this.userMap);
                    postData.yr(this.forum.isBrandForum);
                    postData.a(post, context);
                    postData.a(dlp().bnD());
                    if (postData.bpL() != null && postData.bpL().baijiahaoData == null && dlp() != null && dlp().getBaijiahaoData() != null) {
                        postData.bpL().baijiahaoData = dlp().getBaijiahaoData();
                    }
                    this.lMV.add(postData.getId());
                    if (postData.dNO() == 1 && this.gAx.boF()) {
                        if (dlx()) {
                            postData.setPostType(0);
                        } else {
                            postData.setPostType(this.gAx.boE());
                        }
                    } else if (postData.dNO() == 1 && this.gAx.bpb()) {
                        postData.setPostType(41);
                    } else if (postData.dNO() == 1 && this.gAx != null && this.gAx.bmx()) {
                        postData.setPostType(0);
                        postData.bHN();
                        if (this.gAx.bnQ() == null || this.gAx.bnQ().size() == 0) {
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
                            postData.c(new TbRichText(TbadkCoreApplication.getInst(), this.gAx.bnQ(), this.gAx.getTid(), true));
                        }
                        this.lMO = postData;
                    }
                    if (postData.dNO() == 1 && this.gAx != null && this.gAx.isShareThread) {
                        postData.h(this.gAx.eUD);
                    }
                    if (postData.dNO() == 1) {
                        this.lNb = postData;
                        this.lNa = false;
                        if (postData.bnS() != null && this.lNk != null) {
                            postData.bnS().setBusinessAccountData(this.lNk);
                        }
                    }
                    this.lMx.add(postData);
                }
            }
        }
    }

    private void a(DataRes dataRes) {
        this.lMR = new p(this.gAx, this.anti);
        this.lMl = dataRes.partial_visible_toast;
        if (dataRes.follow_tip != null && dataRes.follow_tip.is_toast_tip.intValue() == 1) {
            this.lMz = dataRes.follow_tip.tip_text;
        }
        this.lMH = new AlaLiveInfoCoreData();
        if (dataRes.ala_info != null) {
            this.lMH.parserProtoBuf(dataRes.ala_info);
        }
        this.lMS = dataRes.fold_tip;
        this.lMm = dataRes.exp_news_today.intValue();
        this.lMn = dataRes.exp_guide_today.intValue();
        if (!y.isEmpty(dataRes.thread_topic)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= dataRes.thread_topic.size()) {
                    break;
                }
                br.a aVar = new br.a();
                aVar.a(dataRes.thread_topic.get(i2));
                this.lMU.add(aVar);
                i = i2 + 1;
            }
        }
        this.lMo = dataRes.pb_sort_info;
        this.lMp = dataRes.sort_type.intValue();
        if (dataRes.manager_election != null) {
            this.lMq = l.b(dataRes.manager_election);
        }
    }

    private void b(DataRes dataRes) {
        if (dataRes.feed_thread_list != null && dataRes.feed_thread_list.size() > 0) {
            List<ThreadInfo> list = dataRes.feed_thread_list;
            if (this.lMG == null) {
                this.lMG = new ArrayList();
            }
            this.lMG.clear();
            for (ThreadInfo threadInfo : list) {
                if (threadInfo != null) {
                    cb cbVar = new cb();
                    cbVar.a(threadInfo);
                    this.lMG.add(cbVar);
                }
            }
            if (this.lMG != null && this.lMG.size() > 15) {
                this.lMG = y.subList(this.lMG, 0, 15);
            }
        }
    }

    private void c(DataRes dataRes) {
        List<String> zZ;
        com.baidu.tieba.tbadkCore.data.o oVar = new com.baidu.tieba.tbadkCore.data.o();
        oVar.nza = true;
        App app = dataRes.banner_list.pb_banner_ad;
        App a2 = com.baidu.tieba.recapp.s.dDB().a(app, Cmatch.PB_BANNER);
        if (a2 == null || this.lNl || com.baidu.tieba.recapp.a.a(a2, dataRes.banner_list)) {
            a2 = app;
        } else {
            oVar.eNm = true;
            this.lNl = true;
        }
        oVar.h(a2);
        AppData dNC = oVar.dNC();
        if (dNC.goods != null) {
            if (y.isEmpty(dNC.goods.thread_pic_list) && (zZ = AdvertAppInfo.a.zZ(dNC.goods.lego_card)) != null && dNC.goods.thread_pic_list != null) {
                dNC.goods.thread_pic_list.addAll(zZ);
            }
            this.lMJ = oVar;
        }
    }

    private void d(DataRes dataRes) {
        List<App> list = dataRes.banner_list.video_recommend_ad;
        this.lNe.clear();
        if (list != null && !list.isEmpty()) {
            for (App app : list) {
                com.baidu.tieba.tbadkCore.data.o oVar = new com.baidu.tieba.tbadkCore.data.o();
                oVar.h(app);
                AppData dNC = oVar.dNC();
                if (!this.lNe.contains(oVar) && dNC.goods != null && (!StringUtils.isNull(dNC.goods.user_name) || !StringUtils.isNull(dNC.goods.lego_card))) {
                    oVar.mcB = dlP();
                    this.lNe.add(oVar);
                }
            }
        }
    }

    public String dlA() {
        return this.lMS;
    }

    public CardHListViewData dlB() {
        return this.lMk;
    }

    public PostData dlC() {
        return this.lMO;
    }

    public PostData f(PostData postData) {
        this.lMO = postData;
        return postData;
    }

    public s dlD() {
        return this.lMN;
    }

    public int dlE() {
        return this.userIdentity;
    }

    public int getIsNewUrl() {
        return this.lMA;
    }

    public void setIsNewUrl(int i) {
        this.lMA = i;
    }

    public List<MuteUser> dlF() {
        return this.lMD;
    }

    public ArrayList<com.baidu.tieba.tbadkCore.data.o> dlG() {
        return this.lMI;
    }

    public com.baidu.tieba.tbadkCore.data.o dlH() {
        return this.lMJ;
    }

    public void b(com.baidu.tieba.tbadkCore.data.o oVar) {
        this.lMJ = oVar;
    }

    public void dlI() {
        if (this.lMJ.dNC() != null) {
            this.lMJ.dNC().legoCard = null;
        }
        this.lMJ = null;
    }

    public void dlJ() {
        this.lNf = null;
        this.lNg = null;
    }

    public String dlK() {
        return this.lMj;
    }

    public void Ps(String str) {
        this.lMj = str;
    }

    public j dlL() {
        return this.lMP;
    }

    public List<bx> dlM() {
        return this.lMM;
    }

    public long dlN() {
        return this.lMQ;
    }

    public p dlO() {
        return this.lMR;
    }

    public void a(p pVar) {
        this.lMR = pVar;
    }

    public boolean dlP() {
        return (dlp() == null || !dlp().bmx() || dlp().boj() == null) ? false : true;
    }

    public AlaLiveInfoCoreData dlQ() {
        return this.lMH;
    }

    public List<com.baidu.tbadk.core.data.p> dlR() {
        return this.lMW;
    }

    public boolean dlS() {
        return dlp() != null && dlp().bmB();
    }

    public String dlT() {
        if (this.lMo != null && this.lMo.size() > this.lMp) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.lMo.size()) {
                    break;
                } else if (this.lMo.get(i2).sort_type.intValue() != this.lMp) {
                    i = i2 + 1;
                } else {
                    return this.lMo.get(i2).sort_name;
                }
            }
        }
        return "";
    }

    public com.baidu.tieba.pb.videopb.c.a dlU() {
        return this.lMY;
    }

    public int dlV() {
        return this.lMX;
    }

    public void Fx(int i) {
        this.lMX = i;
    }

    public List<com.baidu.tieba.tbadkCore.data.o> dlW() {
        return this.lNe;
    }

    private boolean d(ThreadInfo threadInfo) {
        if (threadInfo == null || getThreadId() == null || "0".equals(threadInfo.id) || "0".equals(threadInfo.tid)) {
            return false;
        }
        return getThreadId().equals(threadInfo.id) || getThreadId().equals(threadInfo.tid);
    }

    private boolean e(ThreadInfo threadInfo) {
        if (threadInfo == null || threadInfo.baijiahao == null || threadInfo.baijiahao.ori_ugc_nid == null || this.gAx == null || this.gAx.getBaijiahaoData() == null || this.gAx.getBaijiahaoData().oriUgcNid == null || "0".equals(threadInfo.baijiahao.ori_ugc_nid)) {
            return false;
        }
        return threadInfo.baijiahao.ori_ugc_nid.equals(this.gAx.getBaijiahaoData().oriUgcNid);
    }

    public List<ThreadInfo> dlX() {
        return this.lNj;
    }

    public ForumRuleStatus dlY() {
        return this.forumRule;
    }
}

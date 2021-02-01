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
    public AppealInfo lJS;
    public String lJT;
    public CardHListViewData lJU;
    public String lJV;
    public int lJW;
    public int lJX;
    public List<PbSortType> lJY;
    public int lJZ;
    private long lKA;
    private p lKB;
    private String lKC;
    private String lKD;
    private List<com.baidu.tbadk.core.data.p> lKG;
    private com.baidu.tieba.pb.videopb.c.a lKI;
    private PostData lKJ;
    private PostData lKL;
    public boolean lKN;
    private x lKQ;
    public String lKR;
    public String lKS;
    private List<ThreadInfo> lKT;
    private com.baidu.tbadk.data.d lKU;
    public l lKa;
    public a lKe;
    private String lKj;
    private int lKk;
    private List<cb> lKq;
    private AlaLiveInfoCoreData lKr;
    private TwzhiboAnti lKu;
    private List<bx> lKv;
    private List<bx> lKw;
    private PostData lKy;
    private j lKz;
    public boolean lKb = false;
    public boolean lKc = false;
    public boolean lKd = false;
    public boolean lKf = false;
    private boolean lKo = true;
    private ArrayList<com.baidu.tieba.tbadkCore.data.o> lKs = new ArrayList<>();
    private com.baidu.tieba.tbadkCore.data.o lKt = null;
    private int lKH = 0;
    public boolean lKK = true;
    public int lKM = 0;
    public int aam = 0;
    private List<com.baidu.tieba.tbadkCore.data.o> lKO = new ArrayList();
    private ForumData forum = new ForumData();
    private bx lKg = new bx();
    private cb gyA = new cb();
    private ArrayList<PostData> lKh = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private az page = new az();
    private AntiData anti = new AntiData();
    private com.baidu.tbadk.data.g lKi = new com.baidu.tbadk.data.g();
    private int userIdentity = 0;
    private final UserData userData = new UserData();
    private List<MuteUser> lKn = new ArrayList();
    private bc lKl = new bc();
    private bd lKp = new bd();
    private af lKm = new af();
    private s lKx = new s();
    private v lKP = new v();
    private List<br.a> lKE = new ArrayList();
    private HashSet<String> lKF = new HashSet<>();

    public f() {
        this.lKk = 0;
        this.lKu = null;
        this.lKk = 0;
        this.lKu = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.lKh != null && this.lKh.size() > 0;
    }

    public String[] gL(Context context) {
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
            int size = this.lKh.size() > 30 ? 30 : this.lKh.size();
            if (dkZ() == null || dkZ().bnQ() == null || au.isEmpty(dkZ().bnQ().getUserId())) {
                return new String[]{null, ""};
            }
            String userId = dkZ().bnQ().getUserId();
            PostData dlj = dlj();
            if (dlj == null || dlj.bnQ() == null || au.isEmpty(dlj.bnQ().getUserId())) {
                str2 = null;
            } else {
                if (!au.equals(userId, dlj.bnQ().getUserId())) {
                    str2 = null;
                } else {
                    str2 = dlj.dNE();
                }
                if (au.isEmpty("")) {
                    str5 = dlj.dNC();
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
                    PostData postData = (PostData) y.getItem(this.lKh, i);
                    if (postData != null && postData.bnQ() != null && !au.isEmpty(postData.bnQ().getUserId()) && au.equals(userId, postData.bnQ().getUserId())) {
                        if (au.isEmpty(str6)) {
                            str6 = postData.dNE();
                        }
                        String dNC = au.isEmpty(str5) ? postData.dNC() : str5;
                        if (!au.isEmpty(str6) && !au.isEmpty(dNC)) {
                            str5 = dNC;
                            str3 = str6;
                            break;
                        }
                        str5 = dNC;
                    }
                    i++;
                }
            } else {
                str3 = str2;
            }
            String str7 = (z && au.isEmpty(str3)) ? "https://tieba-fe.gz.bcebos.com/yunying/tieba_logo.jpg" : str3;
            str = (this.gyA == null || this.gyA.boR() == null || this.gyA.boR().getGroup_id() == 0) ? str5 : "[" + context.getString(R.string.photo_live_tips) + "] " + str5;
            str4 = (this.gyA == null || this.gyA.boh() == null || au.isEmpty(this.gyA.boh().thumbnail_url)) ? str7 : this.gyA.boh().thumbnail_url;
            if (this.gyA != null && !this.gyA.isShareThread && str4 == null && this.gyA.eTc != null && this.gyA.eTc.eOt != null) {
                ArrayList<MediaData> arrayList = this.gyA.eTc.eOt;
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

    public bx dkY() {
        return this.lKg;
    }

    public void d(bx bxVar) {
        this.lKg = bxVar;
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

    public cb dkZ() {
        return this.gyA;
    }

    public void aJ(cb cbVar) {
        this.gyA = cbVar;
    }

    public List<cb> dla() {
        return this.lKq;
    }

    public String getThreadId() {
        if (this.gyA == null) {
            return "";
        }
        return this.gyA.getId();
    }

    public ArrayList<PostData> dlb() {
        return this.lKh;
    }

    public az getPage() {
        return this.page;
    }

    public af dlc() {
        return this.lKm;
    }

    public bd dld() {
        return this.lKp;
    }

    public v dle() {
        if (this.lKP == null || !this.lKP.isValid()) {
            return null;
        }
        return this.lKP;
    }

    public x dlf() {
        if (this.lKQ == null || !this.lKQ.isValid()) {
            return null;
        }
        return this.lKQ;
    }

    public void a(az azVar, int i) {
        this.page.nb(azVar.bmD());
        this.page.mZ(azVar.blB());
        this.page.mY(azVar.bmA());
        this.page.nc(azVar.bmE());
        this.page.na(azVar.bmC());
        if (i == 0) {
            this.page = azVar;
        } else if (i == 1) {
            this.page.nd(azVar.bmF());
        } else if (i == 2) {
            this.page.ne(azVar.bmG());
        }
    }

    public AntiData getAnti() {
        return this.anti;
    }

    public UserData getUserData() {
        return this.userData;
    }

    public boolean bjZ() {
        return this.gyA.bnX() != 0;
    }

    public void ja(boolean z) {
        if (this.gyA != null) {
            if (z) {
                this.gyA.no(1);
            } else {
                this.gyA.no(0);
            }
        }
    }

    public String bjY() {
        if (this.gyA != null) {
            return this.gyA.bnY();
        }
        return null;
    }

    public void Pk(String str) {
        if (this.gyA != null) {
            this.gyA.Aj(str);
        }
    }

    public String dlg() {
        return this.lKD;
    }

    public boolean dlh() {
        return (this.gyA == null || this.gyA.boa() == null || this.gyA.boa().size() <= 0 || this.gyA.boa().get(0) == null || !this.gyA.boa().get(0).blC()) ? false : true;
    }

    public PostData dli() {
        return this.lKJ;
    }

    public void d(PostData postData) {
        this.lKJ = postData;
        this.lKL = postData;
        this.lKK = false;
    }

    public PostData dlj() {
        return this.lKL;
    }

    public void e(PostData postData) {
        this.lKL = postData;
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                com.baidu.tieba.recapp.c.a.dEe().RD(dataRes.asp_shown_info);
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
                            this.lKU = metaData.getBusinessAccountData();
                        }
                    }
                }
                setIsNewUrl(dataRes.is_new_url.intValue());
                this.forum.parserProtobuf(dataRes.forum);
                this.lKg.parserProtobuf(dataRes.display_forum);
                this.gyA.setUserMap(this.userMap);
                this.gyA.a(dataRes.thread);
                if (this.gyA.bnQ() != null && this.gyA.bnQ().getBusinessAccountData() == null) {
                    this.gyA.bnQ().setBusinessAccountData(this.lKU);
                }
                this.lKl.a(dataRes.news_info);
                switch (this.lKl.esT) {
                    case 1:
                        this.lKm.lXf = this.lKl;
                        break;
                    case 2:
                        this.lKm.lXg = this.lKl;
                        break;
                    case 3:
                        this.lKm.lXh = this.lKl;
                        break;
                    default:
                        this.lKm.lXg = this.lKl;
                        break;
                }
                this.lKp.a(dataRes.recommend_book);
                b(dataRes, context);
                this.lKJ = new PostData();
                this.lKJ.JE(1);
                this.lKJ.setUserMap(this.userMap);
                this.lKJ.ys(this.forum.isBrandForum);
                this.lKJ.setTime(this.gyA.getCreateTime());
                if (dataRes.first_floor_post != null) {
                    this.lKJ.a(dataRes.first_floor_post, context);
                }
                if (this.gyA != null && this.gyA.isShareThread) {
                    this.lKJ.h(this.gyA.eTc);
                }
                if (this.lKL == null) {
                    this.lKL = this.lKJ;
                    this.lKK = true;
                }
                this.page.a(dataRes.page);
                this.anti.parserProtobuf(dataRes.anti);
                this.lKi.a(dataRes.location);
                if (dataRes.user != null) {
                    this.userIdentity = dataRes.user.is_manager.intValue();
                }
                this.userData.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.lKn.add(muteUser);
                        }
                    }
                }
                this.gyA.nk(this.gyA.bnH() > 0 ? this.gyA.bnH() - 1 : 0);
                List<AppData> dDk = com.baidu.tieba.recapp.r.dDm().dDk();
                if (dDk != null) {
                    dDk.clear();
                }
                this.lKt = null;
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        com.baidu.tieba.tbadkCore.data.o oVar = new com.baidu.tieba.tbadkCore.data.o();
                        oVar.e(app);
                        AppData dNl = oVar.dNl();
                        if (!this.lKs.contains(oVar) && dNl.goods != null && (!StringUtils.isNull(dNl.goods.user_name) || !StringUtils.isNull(dNl.goods.lego_card))) {
                            oVar.mai = dlz();
                            this.lKs.add(oVar);
                            if (dDk != null) {
                                dDk.add(oVar.dNl());
                            }
                        }
                    }
                    c(dataRes);
                    d(dataRes);
                }
                com.baidu.tieba.recapp.r.dDm().dDl();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.userData.getIsSelectTail());
                }
                this.lKu.parserProtobuf(dataRes.twzhibo_anti);
                this.lJS = dataRes.appeal_info;
                if (dataRes.forum_headline_img_info != null) {
                    this.lKz = new j();
                    this.lKz.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.guess_like != null) {
                    this.lJU = new CardHListViewData();
                    this.lJU.parseProtobuf(dataRes.guess_like);
                }
                b(dataRes);
                if (y.getCount(dataRes.repost_recommend_forum_list) > 0) {
                    if (this.lKv == null) {
                        this.lKv = new ArrayList();
                    }
                    for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                        bx bxVar = new bx();
                        bxVar.parserProtobuf(simpleForum);
                        this.lKv.add(bxVar);
                    }
                }
                if (y.getCount(dataRes.from_forum_list) > 0) {
                    if (this.lKw == null) {
                        this.lKw = new ArrayList();
                    }
                    for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                        if (simpleForum2 != null) {
                            bx bxVar2 = new bx();
                            bxVar2.parserProtobuf(simpleForum2);
                            this.lKw.add(bxVar2);
                        }
                    }
                }
                this.lKD = dataRes.multi_forum_text;
                if (this.lKA >= 0) {
                    this.lKA = dataRes.thread_freq_num.longValue();
                }
                a(dataRes);
                if (this.lKG == null) {
                    this.lKG = new ArrayList();
                }
                this.lKG.clear();
                if (dataRes.bjh_recommend != null) {
                    int i2 = 1;
                    for (ThreadInfo threadInfo : dataRes.bjh_recommend) {
                        if (threadInfo != null && !d(threadInfo) && !e(threadInfo)) {
                            com.baidu.tbadk.core.data.p pVar = new com.baidu.tbadk.core.data.p();
                            pVar.setFloorNum(i2);
                            pVar.a(threadInfo);
                            this.lKG.add(pVar);
                            i2++;
                        }
                    }
                }
                if (this.lKI != null && this.lKI.dvh()) {
                    this.lKI = null;
                }
                if (dataRes.recom_ala_info != null && dataRes.recom_ala_info.live_status.intValue() == 1 && dataRes.recom_ala_info.pb_display_type.intValue() == 2) {
                    if (this.lKI == null) {
                        this.lKI = new com.baidu.tieba.pb.videopb.c.a();
                        this.lKI.parserProtoBuf(dataRes.recom_ala_info);
                    }
                } else if (this.lKI == null && dataRes.promotion != null) {
                    this.lKI = new com.baidu.tieba.pb.videopb.c.a();
                    this.lKI.a(dataRes.promotion);
                }
                if (dataRes.business_promot_info != null) {
                    this.lKb = dataRes.business_promot_info.is_promot.longValue() == 1;
                    this.lKc = dataRes.business_promot_info.is_headlinepost.intValue() == 1;
                    this.lKd = dataRes.business_promot_info.is_s_card.intValue() == 1;
                    if (dataRes.business_promot_info.send_card_info != null) {
                        b bVar = new b();
                        bVar.a(dataRes.business_promot_info.send_card_info);
                        if (this.lKe == null) {
                            this.lKe = new a();
                        }
                        this.lKe.a(bVar);
                    }
                }
                this.lKP.reset();
                this.lKP.setUserMap(this.userMap);
                this.lKP.a(dataRes.recom_ala_info);
                if (this.lKP.lTW != null) {
                    this.lKP.lTW.setTid(getThreadId());
                }
                this.lKQ = new x();
                this.lKQ.setUserMap(this.userMap);
                this.lKQ.a(dataRes.recom_ala_info);
                if (this.lKQ.lTW != null) {
                    this.lKQ.lTW.setTid(getThreadId());
                }
                if (y.getCount(dataRes.recom_thread_info) > 0) {
                    this.lKT = dataRes.recom_thread_info;
                }
                this.lKR = dataRes.jumptotab1 == null ? null : dataRes.jumptotab1.toString();
                this.lKS = dataRes.jumptotab2;
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
                if (!this.lKF.contains(String.valueOf(post.id))) {
                    PostData postData = new PostData();
                    postData.setUserMap(this.userMap);
                    postData.ys(this.forum.isBrandForum);
                    postData.a(post, context);
                    postData.a(dkZ().bnB());
                    if (postData.bpJ() != null && postData.bpJ().baijiahaoData == null && dkZ() != null && dkZ().getBaijiahaoData() != null) {
                        postData.bpJ().baijiahaoData = dkZ().getBaijiahaoData();
                    }
                    this.lKF.add(postData.getId());
                    if (postData.dNx() == 1 && this.gyA.boD()) {
                        if (dlh()) {
                            postData.setPostType(0);
                        } else {
                            postData.setPostType(this.gyA.boC());
                        }
                    } else if (postData.dNx() == 1 && this.gyA.boZ()) {
                        postData.setPostType(41);
                    } else if (postData.dNx() == 1 && this.gyA != null && this.gyA.bmv()) {
                        postData.setPostType(0);
                        postData.bHJ();
                        if (this.gyA.bnO() == null || this.gyA.bnO().size() == 0) {
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
                            postData.c(new TbRichText(TbadkCoreApplication.getInst(), this.gyA.bnO(), this.gyA.getTid(), true));
                        }
                        this.lKy = postData;
                    }
                    if (postData.dNx() == 1 && this.gyA != null && this.gyA.isShareThread) {
                        postData.h(this.gyA.eTc);
                    }
                    if (postData.dNx() == 1) {
                        this.lKL = postData;
                        this.lKK = false;
                        if (postData.bnQ() != null && this.lKU != null) {
                            postData.bnQ().setBusinessAccountData(this.lKU);
                        }
                    }
                    this.lKh.add(postData);
                }
            }
        }
    }

    private void a(DataRes dataRes) {
        this.lKB = new p(this.gyA, this.anti);
        this.lJV = dataRes.partial_visible_toast;
        if (dataRes.follow_tip != null && dataRes.follow_tip.is_toast_tip.intValue() == 1) {
            this.lKj = dataRes.follow_tip.tip_text;
        }
        this.lKr = new AlaLiveInfoCoreData();
        if (dataRes.ala_info != null) {
            this.lKr.parserProtoBuf(dataRes.ala_info);
        }
        this.lKC = dataRes.fold_tip;
        this.lJW = dataRes.exp_news_today.intValue();
        this.lJX = dataRes.exp_guide_today.intValue();
        if (!y.isEmpty(dataRes.thread_topic)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= dataRes.thread_topic.size()) {
                    break;
                }
                br.a aVar = new br.a();
                aVar.a(dataRes.thread_topic.get(i2));
                this.lKE.add(aVar);
                i = i2 + 1;
            }
        }
        this.lJY = dataRes.pb_sort_info;
        this.lJZ = dataRes.sort_type.intValue();
        if (dataRes.manager_election != null) {
            this.lKa = l.b(dataRes.manager_election);
        }
    }

    private void b(DataRes dataRes) {
        if (dataRes.feed_thread_list != null && dataRes.feed_thread_list.size() > 0) {
            List<ThreadInfo> list = dataRes.feed_thread_list;
            if (this.lKq == null) {
                this.lKq = new ArrayList();
            }
            this.lKq.clear();
            for (ThreadInfo threadInfo : list) {
                if (threadInfo != null) {
                    cb cbVar = new cb();
                    cbVar.a(threadInfo);
                    this.lKq.add(cbVar);
                }
            }
            if (this.lKq != null && this.lKq.size() > 15) {
                this.lKq = y.subList(this.lKq, 0, 15);
            }
        }
    }

    private void c(DataRes dataRes) {
        List<String> zS;
        App app = dataRes.banner_list.pb_banner_ad;
        com.baidu.tieba.tbadkCore.data.o oVar = new com.baidu.tieba.tbadkCore.data.o();
        oVar.nwv = true;
        oVar.e(app);
        AppData dNl = oVar.dNl();
        if (dNl.goods != null) {
            if (y.isEmpty(dNl.goods.thread_pic_list) && (zS = AdvertAppInfo.a.zS(dNl.goods.lego_card)) != null && dNl.goods.thread_pic_list != null) {
                dNl.goods.thread_pic_list.addAll(zS);
            }
            this.lKt = oVar;
        }
    }

    private void d(DataRes dataRes) {
        List<App> list = dataRes.banner_list.video_recommend_ad;
        this.lKO.clear();
        if (list != null && !list.isEmpty()) {
            for (App app : list) {
                com.baidu.tieba.tbadkCore.data.o oVar = new com.baidu.tieba.tbadkCore.data.o();
                oVar.e(app);
                AppData dNl = oVar.dNl();
                if (!this.lKO.contains(oVar) && dNl.goods != null && (!StringUtils.isNull(dNl.goods.user_name) || !StringUtils.isNull(dNl.goods.lego_card))) {
                    oVar.mai = dlz();
                    this.lKO.add(oVar);
                }
            }
        }
    }

    public String dlk() {
        return this.lKC;
    }

    public CardHListViewData dll() {
        return this.lJU;
    }

    public PostData dlm() {
        return this.lKy;
    }

    public PostData f(PostData postData) {
        this.lKy = postData;
        return postData;
    }

    public s dln() {
        return this.lKx;
    }

    public int dlo() {
        return this.userIdentity;
    }

    public int getIsNewUrl() {
        return this.lKk;
    }

    public void setIsNewUrl(int i) {
        this.lKk = i;
    }

    public List<MuteUser> dlp() {
        return this.lKn;
    }

    public ArrayList<com.baidu.tieba.tbadkCore.data.o> dlq() {
        return this.lKs;
    }

    public com.baidu.tieba.tbadkCore.data.o dlr() {
        return this.lKt;
    }

    public void b(com.baidu.tieba.tbadkCore.data.o oVar) {
        this.lKt = oVar;
    }

    public void dls() {
        if (this.lKt.dNl() != null) {
            this.lKt.dNl().legoCard = null;
        }
        this.lKt = null;
    }

    public void dlt() {
        this.lKP = null;
        this.lKQ = null;
    }

    public String dlu() {
        return this.lJT;
    }

    public void Pl(String str) {
        this.lJT = str;
    }

    public j dlv() {
        return this.lKz;
    }

    public List<bx> dlw() {
        return this.lKw;
    }

    public long dlx() {
        return this.lKA;
    }

    public p dly() {
        return this.lKB;
    }

    public void a(p pVar) {
        this.lKB = pVar;
    }

    public boolean dlz() {
        return (dkZ() == null || !dkZ().bmv() || dkZ().boh() == null) ? false : true;
    }

    public AlaLiveInfoCoreData dlA() {
        return this.lKr;
    }

    public List<com.baidu.tbadk.core.data.p> dlB() {
        return this.lKG;
    }

    public boolean dlC() {
        return dkZ() != null && dkZ().bmz();
    }

    public String dlD() {
        if (this.lJY != null && this.lJY.size() > this.lJZ) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.lJY.size()) {
                    break;
                } else if (this.lJY.get(i2).sort_type.intValue() != this.lJZ) {
                    i = i2 + 1;
                } else {
                    return this.lJY.get(i2).sort_name;
                }
            }
        }
        return "";
    }

    public com.baidu.tieba.pb.videopb.c.a dlE() {
        return this.lKI;
    }

    public int dlF() {
        return this.lKH;
    }

    public void Fu(int i) {
        this.lKH = i;
    }

    public List<com.baidu.tieba.tbadkCore.data.o> dlG() {
        return this.lKO;
    }

    private boolean d(ThreadInfo threadInfo) {
        if (threadInfo == null || getThreadId() == null || "0".equals(threadInfo.id) || "0".equals(threadInfo.tid)) {
            return false;
        }
        return getThreadId().equals(threadInfo.id) || getThreadId().equals(threadInfo.tid);
    }

    private boolean e(ThreadInfo threadInfo) {
        if (threadInfo == null || threadInfo.baijiahao == null || threadInfo.baijiahao.ori_ugc_nid == null || this.gyA == null || this.gyA.getBaijiahaoData() == null || this.gyA.getBaijiahaoData().oriUgcNid == null || "0".equals(threadInfo.baijiahao.ori_ugc_nid)) {
            return false;
        }
        return threadInfo.baijiahao.ori_ugc_nid.equals(this.gyA.getBaijiahaoData().oriUgcNid);
    }

    public List<ThreadInfo> dlH() {
        return this.lKT;
    }

    public ForumRuleStatus dlI() {
        return this.forumRule;
    }
}

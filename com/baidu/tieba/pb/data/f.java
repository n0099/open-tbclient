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
    private List<cb> lKE;
    private AlaLiveInfoCoreData lKF;
    private TwzhiboAnti lKI;
    private List<bx> lKJ;
    private List<bx> lKK;
    private PostData lKM;
    private j lKN;
    private long lKO;
    private p lKP;
    private String lKQ;
    private String lKR;
    private List<com.baidu.tbadk.core.data.p> lKU;
    private com.baidu.tieba.pb.videopb.c.a lKW;
    private PostData lKX;
    private PostData lKZ;
    public AppealInfo lKg;
    public String lKh;
    public CardHListViewData lKi;
    public String lKj;
    public int lKk;
    public int lKl;
    public List<PbSortType> lKm;
    public int lKn;
    public l lKo;
    public a lKs;
    private String lKx;
    private int lKy;
    public boolean lLb;
    private x lLe;
    public String lLf;
    public String lLg;
    private List<ThreadInfo> lLh;
    private com.baidu.tbadk.data.d lLi;
    public boolean lKp = false;
    public boolean lKq = false;
    public boolean lKr = false;
    public boolean lKt = false;
    private boolean lKC = true;
    private ArrayList<com.baidu.tieba.tbadkCore.data.o> lKG = new ArrayList<>();
    private com.baidu.tieba.tbadkCore.data.o lKH = null;
    private int lKV = 0;
    public boolean lKY = true;
    public int lLa = 0;
    public int aam = 0;
    private List<com.baidu.tieba.tbadkCore.data.o> lLc = new ArrayList();
    private boolean lLj = false;
    private ForumData forum = new ForumData();
    private bx lKu = new bx();
    private cb gyO = new cb();
    private ArrayList<PostData> lKv = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private az page = new az();
    private AntiData anti = new AntiData();
    private com.baidu.tbadk.data.g lKw = new com.baidu.tbadk.data.g();
    private int userIdentity = 0;
    private final UserData userData = new UserData();
    private List<MuteUser> lKB = new ArrayList();
    private bc lKz = new bc();
    private bd lKD = new bd();
    private af lKA = new af();
    private s lKL = new s();
    private v lLd = new v();
    private List<br.a> lKS = new ArrayList();
    private HashSet<String> lKT = new HashSet<>();

    public f() {
        this.lKy = 0;
        this.lKI = null;
        this.lKy = 0;
        this.lKI = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.lKv != null && this.lKv.size() > 0;
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
            int size = this.lKv.size() > 30 ? 30 : this.lKv.size();
            if (dlg() == null || dlg().bnQ() == null || au.isEmpty(dlg().bnQ().getUserId())) {
                return new String[]{null, ""};
            }
            String userId = dlg().bnQ().getUserId();
            PostData dlq = dlq();
            if (dlq == null || dlq.bnQ() == null || au.isEmpty(dlq.bnQ().getUserId())) {
                str2 = null;
            } else {
                if (!au.equals(userId, dlq.bnQ().getUserId())) {
                    str2 = null;
                } else {
                    str2 = dlq.dNM();
                }
                if (au.isEmpty("")) {
                    str5 = dlq.dNK();
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
                    PostData postData = (PostData) y.getItem(this.lKv, i);
                    if (postData != null && postData.bnQ() != null && !au.isEmpty(postData.bnQ().getUserId()) && au.equals(userId, postData.bnQ().getUserId())) {
                        if (au.isEmpty(str6)) {
                            str6 = postData.dNM();
                        }
                        String dNK = au.isEmpty(str5) ? postData.dNK() : str5;
                        if (!au.isEmpty(str6) && !au.isEmpty(dNK)) {
                            str5 = dNK;
                            str3 = str6;
                            break;
                        }
                        str5 = dNK;
                    }
                    i++;
                }
            } else {
                str3 = str2;
            }
            String str7 = (z && au.isEmpty(str3)) ? "https://tieba-fe.gz.bcebos.com/yunying/tieba_logo.jpg" : str3;
            str = (this.gyO == null || this.gyO.boR() == null || this.gyO.boR().getGroup_id() == 0) ? str5 : "[" + context.getString(R.string.photo_live_tips) + "] " + str5;
            str4 = (this.gyO == null || this.gyO.boh() == null || au.isEmpty(this.gyO.boh().thumbnail_url)) ? str7 : this.gyO.boh().thumbnail_url;
            if (this.gyO != null && !this.gyO.isShareThread && str4 == null && this.gyO.eTc != null && this.gyO.eTc.eOt != null) {
                ArrayList<MediaData> arrayList = this.gyO.eTc.eOt;
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

    public bx dlf() {
        return this.lKu;
    }

    public void d(bx bxVar) {
        this.lKu = bxVar;
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

    public cb dlg() {
        return this.gyO;
    }

    public void aJ(cb cbVar) {
        this.gyO = cbVar;
    }

    public List<cb> dlh() {
        return this.lKE;
    }

    public String getThreadId() {
        if (this.gyO == null) {
            return "";
        }
        return this.gyO.getId();
    }

    public ArrayList<PostData> dli() {
        return this.lKv;
    }

    public az getPage() {
        return this.page;
    }

    public af dlj() {
        return this.lKA;
    }

    public bd dlk() {
        return this.lKD;
    }

    public v dll() {
        if (this.lLd == null || !this.lLd.isValid()) {
            return null;
        }
        return this.lLd;
    }

    public x dlm() {
        if (this.lLe == null || !this.lLe.isValid()) {
            return null;
        }
        return this.lLe;
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
        return this.gyO.bnX() != 0;
    }

    public void ja(boolean z) {
        if (this.gyO != null) {
            if (z) {
                this.gyO.no(1);
            } else {
                this.gyO.no(0);
            }
        }
    }

    public String bjY() {
        if (this.gyO != null) {
            return this.gyO.bnY();
        }
        return null;
    }

    public void Pl(String str) {
        if (this.gyO != null) {
            this.gyO.Aj(str);
        }
    }

    public String dln() {
        return this.lKR;
    }

    public boolean dlo() {
        return (this.gyO == null || this.gyO.boa() == null || this.gyO.boa().size() <= 0 || this.gyO.boa().get(0) == null || !this.gyO.boa().get(0).blC()) ? false : true;
    }

    public PostData dlp() {
        return this.lKX;
    }

    public void d(PostData postData) {
        this.lKX = postData;
        this.lKZ = postData;
        this.lKY = false;
    }

    public PostData dlq() {
        return this.lKZ;
    }

    public void e(PostData postData) {
        this.lKZ = postData;
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                com.baidu.tieba.recapp.c.a.dEm().RP(dataRes.asp_shown_info);
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
                            this.lLi = metaData.getBusinessAccountData();
                        }
                    }
                }
                setIsNewUrl(dataRes.is_new_url.intValue());
                this.forum.parserProtobuf(dataRes.forum);
                this.lKu.parserProtobuf(dataRes.display_forum);
                this.gyO.setUserMap(this.userMap);
                this.gyO.a(dataRes.thread);
                if (this.gyO.bnQ() != null && this.gyO.bnQ().getBusinessAccountData() == null) {
                    this.gyO.bnQ().setBusinessAccountData(this.lLi);
                }
                this.lKz.a(dataRes.news_info);
                switch (this.lKz.esT) {
                    case 1:
                        this.lKA.lXu = this.lKz;
                        break;
                    case 2:
                        this.lKA.lXv = this.lKz;
                        break;
                    case 3:
                        this.lKA.lXw = this.lKz;
                        break;
                    default:
                        this.lKA.lXv = this.lKz;
                        break;
                }
                this.lKD.a(dataRes.recommend_book);
                b(dataRes, context);
                this.lKX = new PostData();
                this.lKX.JE(1);
                this.lKX.setUserMap(this.userMap);
                this.lKX.ys(this.forum.isBrandForum);
                this.lKX.setTime(this.gyO.getCreateTime());
                if (dataRes.first_floor_post != null) {
                    this.lKX.a(dataRes.first_floor_post, context);
                }
                if (this.gyO != null && this.gyO.isShareThread) {
                    this.lKX.h(this.gyO.eTc);
                }
                if (this.lKZ == null) {
                    this.lKZ = this.lKX;
                    this.lKY = true;
                }
                this.page.a(dataRes.page);
                this.anti.parserProtobuf(dataRes.anti);
                this.lKw.a(dataRes.location);
                if (dataRes.user != null) {
                    this.userIdentity = dataRes.user.is_manager.intValue();
                }
                this.userData.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.lKB.add(muteUser);
                        }
                    }
                }
                this.gyO.nk(this.gyO.bnH() > 0 ? this.gyO.bnH() - 1 : 0);
                List<AppData> dDr = com.baidu.tieba.recapp.s.dDt().dDr();
                if (dDr != null) {
                    dDr.clear();
                }
                this.lKH = null;
                this.lLj = false;
                if (dataRes.banner_list != null) {
                    List<App> list2 = dataRes.banner_list.app;
                    c(dataRes);
                    for (App app : list2) {
                        com.baidu.tieba.tbadkCore.data.o oVar = new com.baidu.tieba.tbadkCore.data.o();
                        App a2 = com.baidu.tieba.recapp.s.dDt().a(app, dlG() ? Cmatch.VIDEO_PB_COMMENT : Cmatch.PB_COMMENT);
                        if (a2 != null && !this.lLj && !com.baidu.tieba.recapp.a.a(a2, dataRes.banner_list)) {
                            oVar.eLL = true;
                            this.lLj = true;
                            app = a2;
                        }
                        oVar.g(app);
                        AppData dNt = oVar.dNt();
                        if (!this.lKG.contains(oVar) && dNt.goods != null && (!StringUtils.isNull(dNt.goods.user_name) || !StringUtils.isNull(dNt.goods.lego_card))) {
                            oVar.maz = dlG();
                            this.lKG.add(oVar);
                            if (dDr != null) {
                                dDr.add(oVar.dNt());
                            }
                        }
                    }
                    d(dataRes);
                }
                com.baidu.tieba.recapp.s.dDt().dDs();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.userData.getIsSelectTail());
                }
                this.lKI.parserProtobuf(dataRes.twzhibo_anti);
                this.lKg = dataRes.appeal_info;
                if (dataRes.forum_headline_img_info != null) {
                    this.lKN = new j();
                    this.lKN.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.guess_like != null) {
                    this.lKi = new CardHListViewData();
                    this.lKi.parseProtobuf(dataRes.guess_like);
                }
                b(dataRes);
                if (y.getCount(dataRes.repost_recommend_forum_list) > 0) {
                    if (this.lKJ == null) {
                        this.lKJ = new ArrayList();
                    }
                    for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                        bx bxVar = new bx();
                        bxVar.parserProtobuf(simpleForum);
                        this.lKJ.add(bxVar);
                    }
                }
                if (y.getCount(dataRes.from_forum_list) > 0) {
                    if (this.lKK == null) {
                        this.lKK = new ArrayList();
                    }
                    for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                        if (simpleForum2 != null) {
                            bx bxVar2 = new bx();
                            bxVar2.parserProtobuf(simpleForum2);
                            this.lKK.add(bxVar2);
                        }
                    }
                }
                this.lKR = dataRes.multi_forum_text;
                if (this.lKO >= 0) {
                    this.lKO = dataRes.thread_freq_num.longValue();
                }
                a(dataRes);
                if (this.lKU == null) {
                    this.lKU = new ArrayList();
                }
                this.lKU.clear();
                if (dataRes.bjh_recommend != null) {
                    int i2 = 1;
                    for (ThreadInfo threadInfo : dataRes.bjh_recommend) {
                        if (threadInfo != null && !d(threadInfo) && !e(threadInfo)) {
                            com.baidu.tbadk.core.data.p pVar = new com.baidu.tbadk.core.data.p();
                            pVar.setFloorNum(i2);
                            pVar.a(threadInfo);
                            this.lKU.add(pVar);
                            i2++;
                        }
                    }
                }
                if (this.lKW != null && this.lKW.dvo()) {
                    this.lKW = null;
                }
                if (dataRes.recom_ala_info != null && dataRes.recom_ala_info.live_status.intValue() == 1 && dataRes.recom_ala_info.pb_display_type.intValue() == 2) {
                    if (this.lKW == null) {
                        this.lKW = new com.baidu.tieba.pb.videopb.c.a();
                        this.lKW.parserProtoBuf(dataRes.recom_ala_info);
                    }
                } else if (this.lKW == null && dataRes.promotion != null) {
                    this.lKW = new com.baidu.tieba.pb.videopb.c.a();
                    this.lKW.a(dataRes.promotion);
                }
                if (dataRes.business_promot_info != null) {
                    this.lKp = dataRes.business_promot_info.is_promot.longValue() == 1;
                    this.lKq = dataRes.business_promot_info.is_headlinepost.intValue() == 1;
                    this.lKr = dataRes.business_promot_info.is_s_card.intValue() == 1;
                    if (dataRes.business_promot_info.send_card_info != null) {
                        b bVar = new b();
                        bVar.a(dataRes.business_promot_info.send_card_info);
                        if (this.lKs == null) {
                            this.lKs = new a();
                        }
                        this.lKs.a(bVar);
                    }
                }
                this.lLd.reset();
                this.lLd.setUserMap(this.userMap);
                this.lLd.a(dataRes.recom_ala_info);
                if (this.lLd.lUl != null) {
                    this.lLd.lUl.setTid(getThreadId());
                }
                this.lLe = new x();
                this.lLe.setUserMap(this.userMap);
                this.lLe.a(dataRes.recom_ala_info);
                if (this.lLe.lUl != null) {
                    this.lLe.lUl.setTid(getThreadId());
                }
                if (y.getCount(dataRes.recom_thread_info) > 0) {
                    this.lLh = dataRes.recom_thread_info;
                }
                this.lLf = dataRes.jumptotab1 == null ? null : dataRes.jumptotab1.toString();
                this.lLg = dataRes.jumptotab2;
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
                if (!this.lKT.contains(String.valueOf(post.id))) {
                    PostData postData = new PostData();
                    postData.setUserMap(this.userMap);
                    postData.ys(this.forum.isBrandForum);
                    postData.a(post, context);
                    postData.a(dlg().bnB());
                    if (postData.bpJ() != null && postData.bpJ().baijiahaoData == null && dlg() != null && dlg().getBaijiahaoData() != null) {
                        postData.bpJ().baijiahaoData = dlg().getBaijiahaoData();
                    }
                    this.lKT.add(postData.getId());
                    if (postData.dNF() == 1 && this.gyO.boD()) {
                        if (dlo()) {
                            postData.setPostType(0);
                        } else {
                            postData.setPostType(this.gyO.boC());
                        }
                    } else if (postData.dNF() == 1 && this.gyO.boZ()) {
                        postData.setPostType(41);
                    } else if (postData.dNF() == 1 && this.gyO != null && this.gyO.bmv()) {
                        postData.setPostType(0);
                        postData.bHJ();
                        if (this.gyO.bnO() == null || this.gyO.bnO().size() == 0) {
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
                            postData.c(new TbRichText(TbadkCoreApplication.getInst(), this.gyO.bnO(), this.gyO.getTid(), true));
                        }
                        this.lKM = postData;
                    }
                    if (postData.dNF() == 1 && this.gyO != null && this.gyO.isShareThread) {
                        postData.h(this.gyO.eTc);
                    }
                    if (postData.dNF() == 1) {
                        this.lKZ = postData;
                        this.lKY = false;
                        if (postData.bnQ() != null && this.lLi != null) {
                            postData.bnQ().setBusinessAccountData(this.lLi);
                        }
                    }
                    this.lKv.add(postData);
                }
            }
        }
    }

    private void a(DataRes dataRes) {
        this.lKP = new p(this.gyO, this.anti);
        this.lKj = dataRes.partial_visible_toast;
        if (dataRes.follow_tip != null && dataRes.follow_tip.is_toast_tip.intValue() == 1) {
            this.lKx = dataRes.follow_tip.tip_text;
        }
        this.lKF = new AlaLiveInfoCoreData();
        if (dataRes.ala_info != null) {
            this.lKF.parserProtoBuf(dataRes.ala_info);
        }
        this.lKQ = dataRes.fold_tip;
        this.lKk = dataRes.exp_news_today.intValue();
        this.lKl = dataRes.exp_guide_today.intValue();
        if (!y.isEmpty(dataRes.thread_topic)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= dataRes.thread_topic.size()) {
                    break;
                }
                br.a aVar = new br.a();
                aVar.a(dataRes.thread_topic.get(i2));
                this.lKS.add(aVar);
                i = i2 + 1;
            }
        }
        this.lKm = dataRes.pb_sort_info;
        this.lKn = dataRes.sort_type.intValue();
        if (dataRes.manager_election != null) {
            this.lKo = l.b(dataRes.manager_election);
        }
    }

    private void b(DataRes dataRes) {
        if (dataRes.feed_thread_list != null && dataRes.feed_thread_list.size() > 0) {
            List<ThreadInfo> list = dataRes.feed_thread_list;
            if (this.lKE == null) {
                this.lKE = new ArrayList();
            }
            this.lKE.clear();
            for (ThreadInfo threadInfo : list) {
                if (threadInfo != null) {
                    cb cbVar = new cb();
                    cbVar.a(threadInfo);
                    this.lKE.add(cbVar);
                }
            }
            if (this.lKE != null && this.lKE.size() > 15) {
                this.lKE = y.subList(this.lKE, 0, 15);
            }
        }
    }

    private void c(DataRes dataRes) {
        List<String> zS;
        com.baidu.tieba.tbadkCore.data.o oVar = new com.baidu.tieba.tbadkCore.data.o();
        oVar.nwV = true;
        App app = dataRes.banner_list.pb_banner_ad;
        App a2 = com.baidu.tieba.recapp.s.dDt().a(app, Cmatch.PB_BANNER);
        if (a2 == null || this.lLj || com.baidu.tieba.recapp.a.a(a2, dataRes.banner_list)) {
            a2 = app;
        } else {
            oVar.eLL = true;
            this.lLj = true;
        }
        oVar.g(a2);
        AppData dNt = oVar.dNt();
        if (dNt.goods != null) {
            if (y.isEmpty(dNt.goods.thread_pic_list) && (zS = AdvertAppInfo.a.zS(dNt.goods.lego_card)) != null && dNt.goods.thread_pic_list != null) {
                dNt.goods.thread_pic_list.addAll(zS);
            }
            this.lKH = oVar;
        }
    }

    private void d(DataRes dataRes) {
        List<App> list = dataRes.banner_list.video_recommend_ad;
        this.lLc.clear();
        if (list != null && !list.isEmpty()) {
            for (App app : list) {
                com.baidu.tieba.tbadkCore.data.o oVar = new com.baidu.tieba.tbadkCore.data.o();
                oVar.g(app);
                AppData dNt = oVar.dNt();
                if (!this.lLc.contains(oVar) && dNt.goods != null && (!StringUtils.isNull(dNt.goods.user_name) || !StringUtils.isNull(dNt.goods.lego_card))) {
                    oVar.maz = dlG();
                    this.lLc.add(oVar);
                }
            }
        }
    }

    public String dlr() {
        return this.lKQ;
    }

    public CardHListViewData dls() {
        return this.lKi;
    }

    public PostData dlt() {
        return this.lKM;
    }

    public PostData f(PostData postData) {
        this.lKM = postData;
        return postData;
    }

    public s dlu() {
        return this.lKL;
    }

    public int dlv() {
        return this.userIdentity;
    }

    public int getIsNewUrl() {
        return this.lKy;
    }

    public void setIsNewUrl(int i) {
        this.lKy = i;
    }

    public List<MuteUser> dlw() {
        return this.lKB;
    }

    public ArrayList<com.baidu.tieba.tbadkCore.data.o> dlx() {
        return this.lKG;
    }

    public com.baidu.tieba.tbadkCore.data.o dly() {
        return this.lKH;
    }

    public void b(com.baidu.tieba.tbadkCore.data.o oVar) {
        this.lKH = oVar;
    }

    public void dlz() {
        if (this.lKH.dNt() != null) {
            this.lKH.dNt().legoCard = null;
        }
        this.lKH = null;
    }

    public void dlA() {
        this.lLd = null;
        this.lLe = null;
    }

    public String dlB() {
        return this.lKh;
    }

    public void Pm(String str) {
        this.lKh = str;
    }

    public j dlC() {
        return this.lKN;
    }

    public List<bx> dlD() {
        return this.lKK;
    }

    public long dlE() {
        return this.lKO;
    }

    public p dlF() {
        return this.lKP;
    }

    public void a(p pVar) {
        this.lKP = pVar;
    }

    public boolean dlG() {
        return (dlg() == null || !dlg().bmv() || dlg().boh() == null) ? false : true;
    }

    public AlaLiveInfoCoreData dlH() {
        return this.lKF;
    }

    public List<com.baidu.tbadk.core.data.p> dlI() {
        return this.lKU;
    }

    public boolean dlJ() {
        return dlg() != null && dlg().bmz();
    }

    public String dlK() {
        if (this.lKm != null && this.lKm.size() > this.lKn) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.lKm.size()) {
                    break;
                } else if (this.lKm.get(i2).sort_type.intValue() != this.lKn) {
                    i = i2 + 1;
                } else {
                    return this.lKm.get(i2).sort_name;
                }
            }
        }
        return "";
    }

    public com.baidu.tieba.pb.videopb.c.a dlL() {
        return this.lKW;
    }

    public int dlM() {
        return this.lKV;
    }

    public void Fu(int i) {
        this.lKV = i;
    }

    public List<com.baidu.tieba.tbadkCore.data.o> dlN() {
        return this.lLc;
    }

    private boolean d(ThreadInfo threadInfo) {
        if (threadInfo == null || getThreadId() == null || "0".equals(threadInfo.id) || "0".equals(threadInfo.tid)) {
            return false;
        }
        return getThreadId().equals(threadInfo.id) || getThreadId().equals(threadInfo.tid);
    }

    private boolean e(ThreadInfo threadInfo) {
        if (threadInfo == null || threadInfo.baijiahao == null || threadInfo.baijiahao.ori_ugc_nid == null || this.gyO == null || this.gyO.getBaijiahaoData() == null || this.gyO.getBaijiahaoData().oriUgcNid == null || "0".equals(threadInfo.baijiahao.ori_ugc_nid)) {
            return false;
        }
        return threadInfo.baijiahao.ori_ugc_nid.equals(this.gyO.getBaijiahaoData().oriUgcNid);
    }

    public List<ThreadInfo> dlO() {
        return this.lLh;
    }

    public ForumRuleStatus dlP() {
        return this.forumRule;
    }
}

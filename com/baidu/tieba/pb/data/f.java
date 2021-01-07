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
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.data.ba;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.data.bp;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.at;
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
    public AppealInfo lFK;
    public String lFL;
    public CardHListViewData lFM;
    public String lFN;
    public int lFO;
    public int lFP;
    public List<PbSortType> lFQ;
    public int lFR;
    public k lFS;
    public a lFW;
    private com.baidu.tieba.pb.videopb.c.a lGA;
    private PostData lGB;
    private PostData lGD;
    public boolean lGF;
    private x lGI;
    public String lGJ;
    public String lGK;
    private List<ThreadInfo> lGL;
    private String lGb;
    private int lGc;
    private List<bz> lGi;
    private AlaLiveInfoCoreData lGj;
    private TwzhiboAnti lGm;
    private List<bv> lGn;
    private List<bv> lGo;
    private PostData lGq;
    private i lGr;
    private long lGs;
    private o lGt;
    private String lGu;
    private String lGv;
    private List<com.baidu.tbadk.core.data.o> lGy;
    public boolean lFT = false;
    public boolean lFU = false;
    public boolean lFV = false;
    public boolean lFX = false;
    private boolean lGg = true;
    private ArrayList<com.baidu.tieba.tbadkCore.data.o> lGk = new ArrayList<>();
    private com.baidu.tieba.tbadkCore.data.o lGl = null;
    private int lGz = 0;
    public boolean lGC = true;
    public int lGE = 0;
    public int aas = 0;
    private List<com.baidu.tieba.tbadkCore.data.o> lGG = new ArrayList();
    private ForumData forum = new ForumData();
    private bv lFY = new bv();
    private bz gAx = new bz();
    private ArrayList<PostData> lFZ = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private ax page = new ax();
    private AntiData anti = new AntiData();
    private com.baidu.tbadk.data.g lGa = new com.baidu.tbadk.data.g();
    private int userIdentity = 0;
    private final UserData userData = new UserData();
    private List<MuteUser> lGf = new ArrayList();
    private ba lGd = new ba();
    private bb lGh = new bb();
    private af lGe = new af();
    private r lGp = new r();
    private v lGH = new v();
    private List<bp.a> lGw = new ArrayList();
    private HashSet<String> lGx = new HashSet<>();

    public f() {
        this.lGc = 0;
        this.lGm = null;
        this.lGc = 0;
        this.lGm = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.lFZ != null && this.lFZ.size() > 0;
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
            int size = this.lFZ.size() > 30 ? 30 : this.lFZ.size();
            if (dmF() == null || dmF().brr() == null || at.isEmpty(dmF().brr().getUserId())) {
                return new String[]{null, ""};
            }
            String userId = dmF().brr().getUserId();
            PostData dmP = dmP();
            if (dmP == null || dmP.brr() == null || at.isEmpty(dmP.brr().getUserId())) {
                str2 = null;
            } else {
                if (!at.equals(userId, dmP.brr().getUserId())) {
                    str2 = null;
                } else {
                    str2 = dmP.dPl();
                }
                if (at.isEmpty("")) {
                    str5 = dmP.dPj();
                }
            }
            if (at.isEmpty(str5) && at.isEmpty(str2)) {
                int i = 0;
                String str6 = str2;
                while (true) {
                    if (i >= size) {
                        str3 = str6;
                        break;
                    }
                    PostData postData = (PostData) com.baidu.tbadk.core.util.x.getItem(this.lFZ, i);
                    if (postData != null && postData.brr() != null && !at.isEmpty(postData.brr().getUserId()) && at.equals(userId, postData.brr().getUserId())) {
                        if (at.isEmpty(str6)) {
                            str6 = postData.dPl();
                        }
                        String dPj = at.isEmpty(str5) ? postData.dPj() : str5;
                        if (!at.isEmpty(str6) && !at.isEmpty(dPj)) {
                            str5 = dPj;
                            str3 = str6;
                            break;
                        }
                        str5 = dPj;
                    }
                    i++;
                }
            } else {
                str3 = str2;
            }
            String str7 = (z && at.isEmpty(str3)) ? "https://tieba-fe.gz.bcebos.com/yunying/tieba_logo.jpg" : str3;
            str = (this.gAx == null || this.gAx.bst() == null || this.gAx.bst().getGroup_id() == 0) ? str5 : "[" + context.getString(R.string.photo_live_tips) + "] " + str5;
            str4 = (this.gAx == null || this.gAx.brI() == null || at.isEmpty(this.gAx.brI().thumbnail_url)) ? str7 : this.gAx.brI().thumbnail_url;
            if (this.gAx != null && !this.gAx.isShareThread && str4 == null && this.gAx.eVB != null && this.gAx.eVB.eQS != null) {
                ArrayList<MediaData> arrayList = this.gAx.eVB.eQS;
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

    public bv dmE() {
        return this.lFY;
    }

    public void d(bv bvVar) {
        this.lFY = bvVar;
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

    public bz dmF() {
        return this.gAx;
    }

    public void aI(bz bzVar) {
        this.gAx = bzVar;
    }

    public List<bz> dmG() {
        return this.lGi;
    }

    public String getThreadId() {
        if (this.gAx == null) {
            return "";
        }
        return this.gAx.getId();
    }

    public ArrayList<PostData> dmH() {
        return this.lFZ;
    }

    public ax getPage() {
        return this.page;
    }

    public af dmI() {
        return this.lGe;
    }

    public bb dmJ() {
        return this.lGh;
    }

    public v dmK() {
        if (this.lGH == null || !this.lGH.isValid()) {
            return null;
        }
        return this.lGH;
    }

    public x dmL() {
        if (this.lGI == null || !this.lGI.isValid()) {
            return null;
        }
        return this.lGI;
    }

    public void a(ax axVar, int i) {
        this.page.oE(axVar.bqe());
        this.page.oC(axVar.bpd());
        this.page.oB(axVar.bqb());
        this.page.oF(axVar.bqf());
        this.page.oD(axVar.bqd());
        if (i == 0) {
            this.page = axVar;
        } else if (i == 1) {
            this.page.oG(axVar.bqg());
        } else if (i == 2) {
            this.page.oH(axVar.bqh());
        }
    }

    public AntiData getAnti() {
        return this.anti;
    }

    public UserData getUserData() {
        return this.userData;
    }

    public boolean bny() {
        return this.gAx.bry() != 0;
    }

    public void jc(boolean z) {
        if (this.gAx != null) {
            if (z) {
                this.gAx.oR(1);
            } else {
                this.gAx.oR(0);
            }
        }
    }

    public String bnx() {
        if (this.gAx != null) {
            return this.gAx.brz();
        }
        return null;
    }

    public void PA(String str) {
        if (this.gAx != null) {
            this.gAx.Bd(str);
        }
    }

    public String dmM() {
        return this.lGv;
    }

    public boolean dmN() {
        return (this.gAx == null || this.gAx.brB() == null || this.gAx.brB().size() <= 0 || this.gAx.brB().get(0) == null || !this.gAx.brB().get(0).bpe()) ? false : true;
    }

    public PostData dmO() {
        return this.lGB;
    }

    public void d(PostData postData) {
        this.lGB = postData;
        this.lGD = postData;
        this.lGC = false;
    }

    public PostData dmP() {
        return this.lGD;
    }

    public void e(PostData postData) {
        this.lGD = postData;
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                com.baidu.tieba.recapp.c.a.dFO().RR(dataRes.asp_shown_info);
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
                this.lFY.parserProtobuf(dataRes.display_forum);
                this.gAx.setUserMap(this.userMap);
                this.gAx.a(dataRes.thread);
                this.lGd.a(dataRes.news_info);
                switch (this.lGd.evA) {
                    case 1:
                        this.lGe.lSN = this.lGd;
                        break;
                    case 2:
                        this.lGe.lSO = this.lGd;
                        break;
                    case 3:
                        this.lGe.lSP = this.lGd;
                        break;
                    default:
                        this.lGe.lSO = this.lGd;
                        break;
                }
                this.lGh.a(dataRes.recommend_book);
                b(dataRes, context);
                this.lGB = new PostData();
                this.lGB.KR(1);
                this.lGB.setUserMap(this.userMap);
                this.lGB.yd(this.forum.isBrandForum);
                this.lGB.setTime(this.gAx.getCreateTime());
                if (dataRes.first_floor_post != null) {
                    this.lGB.a(dataRes.first_floor_post, context);
                }
                if (this.gAx != null && this.gAx.isShareThread) {
                    this.lGB.h(this.gAx.eVB);
                }
                if (this.lGD == null) {
                    this.lGD = this.lGB;
                    this.lGC = true;
                }
                this.page.a(dataRes.page);
                this.anti.parserProtobuf(dataRes.anti);
                this.lGa.a(dataRes.location);
                if (dataRes.user != null) {
                    this.userIdentity = dataRes.user.is_manager.intValue();
                }
                this.userData.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.lGf.add(muteUser);
                        }
                    }
                }
                this.gAx.oN(this.gAx.bri() > 0 ? this.gAx.bri() - 1 : 0);
                List<AppData> dEU = com.baidu.tieba.recapp.r.dEW().dEU();
                if (dEU != null) {
                    dEU.clear();
                }
                this.lGl = null;
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        com.baidu.tieba.tbadkCore.data.o oVar = new com.baidu.tieba.tbadkCore.data.o();
                        oVar.e(app);
                        AppData dOS = oVar.dOS();
                        if (!this.lGk.contains(oVar) && dOS.goods != null && (!StringUtils.isNull(dOS.goods.user_name) || !StringUtils.isNull(dOS.goods.lego_card))) {
                            oVar.lVP = dnf();
                            this.lGk.add(oVar);
                            if (dEU != null) {
                                dEU.add(oVar.dOS());
                            }
                        }
                    }
                    c(dataRes);
                    d(dataRes);
                }
                com.baidu.tieba.recapp.r.dEW().dEV();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.userData.getIsSelectTail());
                }
                this.lGm.parserProtobuf(dataRes.twzhibo_anti);
                this.lFK = dataRes.appeal_info;
                if (dataRes.forum_headline_img_info != null) {
                    this.lGr = new i();
                    this.lGr.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.guess_like != null) {
                    this.lFM = new CardHListViewData();
                    this.lFM.parseProtobuf(dataRes.guess_like);
                }
                b(dataRes);
                if (com.baidu.tbadk.core.util.x.getCount(dataRes.repost_recommend_forum_list) > 0) {
                    if (this.lGn == null) {
                        this.lGn = new ArrayList();
                    }
                    for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                        bv bvVar = new bv();
                        bvVar.parserProtobuf(simpleForum);
                        this.lGn.add(bvVar);
                    }
                }
                if (com.baidu.tbadk.core.util.x.getCount(dataRes.from_forum_list) > 0) {
                    if (this.lGo == null) {
                        this.lGo = new ArrayList();
                    }
                    for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                        if (simpleForum2 != null) {
                            bv bvVar2 = new bv();
                            bvVar2.parserProtobuf(simpleForum2);
                            this.lGo.add(bvVar2);
                        }
                    }
                }
                this.lGv = dataRes.multi_forum_text;
                if (this.lGs >= 0) {
                    this.lGs = dataRes.thread_freq_num.longValue();
                }
                a(dataRes);
                if (this.lGy == null) {
                    this.lGy = new ArrayList();
                }
                this.lGy.clear();
                if (dataRes.bjh_recommend != null) {
                    int i2 = 1;
                    for (ThreadInfo threadInfo : dataRes.bjh_recommend) {
                        if (threadInfo != null && !d(threadInfo) && !e(threadInfo)) {
                            com.baidu.tbadk.core.data.o oVar2 = new com.baidu.tbadk.core.data.o();
                            oVar2.setFloorNum(i2);
                            oVar2.a(threadInfo);
                            this.lGy.add(oVar2);
                            i2++;
                        }
                    }
                }
                if (this.lGA != null && this.lGA.dwM()) {
                    this.lGA = null;
                }
                if (dataRes.recom_ala_info != null && dataRes.recom_ala_info.live_status.intValue() == 1 && dataRes.recom_ala_info.pb_display_type.intValue() == 2) {
                    if (this.lGA == null) {
                        this.lGA = new com.baidu.tieba.pb.videopb.c.a();
                        this.lGA.parserProtoBuf(dataRes.recom_ala_info);
                    }
                } else if (this.lGA == null && dataRes.promotion != null) {
                    this.lGA = new com.baidu.tieba.pb.videopb.c.a();
                    this.lGA.a(dataRes.promotion);
                }
                if (dataRes.business_promot_info != null) {
                    this.lFT = dataRes.business_promot_info.is_promot.longValue() == 1;
                    this.lFU = dataRes.business_promot_info.is_headlinepost.intValue() == 1;
                    this.lFV = dataRes.business_promot_info.is_s_card.intValue() == 1;
                    if (dataRes.business_promot_info.send_card_info != null) {
                        b bVar = new b();
                        bVar.a(dataRes.business_promot_info.send_card_info);
                        if (this.lFW == null) {
                            this.lFW = new a();
                        }
                        this.lFW.a(bVar);
                    }
                }
                this.lGH.reset();
                this.lGH.setUserMap(this.userMap);
                this.lGH.a(dataRes.recom_ala_info);
                if (this.lGH.lPE != null) {
                    this.lGH.lPE.setTid(getThreadId());
                }
                this.lGI = new x();
                this.lGI.setUserMap(this.userMap);
                this.lGI.a(dataRes.recom_ala_info);
                if (this.lGI.lPE != null) {
                    this.lGI.lPE.setTid(getThreadId());
                }
                if (com.baidu.tbadk.core.util.x.getCount(dataRes.recom_thread_info) > 0) {
                    this.lGL = dataRes.recom_thread_info;
                }
                this.lGJ = dataRes.jumptotab1 == null ? null : dataRes.jumptotab1.toString();
                this.lGK = dataRes.jumptotab2;
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
                if (!this.lGx.contains(String.valueOf(post.id))) {
                    PostData postData = new PostData();
                    postData.setUserMap(this.userMap);
                    postData.yd(this.forum.isBrandForum);
                    postData.a(post, context);
                    postData.a(dmF().brc());
                    if (postData.btl() != null && postData.btl().baijiahaoData == null && dmF() != null && dmF().getBaijiahaoData() != null) {
                        postData.btl().baijiahaoData = dmF().getBaijiahaoData();
                    }
                    this.lGx.add(postData.getId());
                    if (postData.dPe() == 1 && this.gAx.bsf()) {
                        if (dmN()) {
                            postData.setPostType(0);
                        } else {
                            postData.setPostType(this.gAx.bse());
                        }
                    } else if (postData.dPe() == 1 && this.gAx.bsB()) {
                        postData.setPostType(41);
                    } else if (postData.dPe() == 1 && this.gAx != null && this.gAx.bpW()) {
                        postData.setPostType(0);
                        postData.bLh();
                        if (this.gAx.brp() == null || this.gAx.brp().size() == 0) {
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
                            postData.c(new TbRichText((Context) TbadkCoreApplication.getInst(), this.gAx.brp(), true));
                        }
                        this.lGq = postData;
                    }
                    if (postData.dPe() == 1 && this.gAx != null && this.gAx.isShareThread) {
                        postData.h(this.gAx.eVB);
                    }
                    if (postData.dPe() == 1) {
                        this.lGD = postData;
                        this.lGC = false;
                    }
                    this.lFZ.add(postData);
                }
            }
        }
    }

    private void a(DataRes dataRes) {
        this.lGt = new o(this.gAx, this.anti);
        this.lFN = dataRes.partial_visible_toast;
        if (dataRes.follow_tip != null && dataRes.follow_tip.is_toast_tip.intValue() == 1) {
            this.lGb = dataRes.follow_tip.tip_text;
        }
        this.lGj = new AlaLiveInfoCoreData();
        if (dataRes.ala_info != null) {
            this.lGj.parserProtoBuf(dataRes.ala_info);
        }
        this.lGu = dataRes.fold_tip;
        this.lFO = dataRes.exp_news_today.intValue();
        this.lFP = dataRes.exp_guide_today.intValue();
        if (!com.baidu.tbadk.core.util.x.isEmpty(dataRes.thread_topic)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= dataRes.thread_topic.size()) {
                    break;
                }
                bp.a aVar = new bp.a();
                aVar.a(dataRes.thread_topic.get(i2));
                this.lGw.add(aVar);
                i = i2 + 1;
            }
        }
        this.lFQ = dataRes.pb_sort_info;
        this.lFR = dataRes.sort_type.intValue();
        if (dataRes.manager_election != null) {
            this.lFS = k.b(dataRes.manager_election);
        }
    }

    private void b(DataRes dataRes) {
        if (dataRes.feed_thread_list != null && dataRes.feed_thread_list.size() > 0) {
            List<ThreadInfo> list = dataRes.feed_thread_list;
            if (this.lGi == null) {
                this.lGi = new ArrayList();
            }
            this.lGi.clear();
            for (ThreadInfo threadInfo : list) {
                if (threadInfo != null) {
                    bz bzVar = new bz();
                    bzVar.a(threadInfo);
                    this.lGi.add(bzVar);
                }
            }
            if (this.lGi != null && this.lGi.size() > 15) {
                this.lGi = com.baidu.tbadk.core.util.x.subList(this.lGi, 0, 15);
            }
        }
    }

    private void c(DataRes dataRes) {
        List<String> AM;
        App app = dataRes.banner_list.pb_banner_ad;
        com.baidu.tieba.tbadkCore.data.o oVar = new com.baidu.tieba.tbadkCore.data.o();
        oVar.nrr = true;
        oVar.e(app);
        AppData dOS = oVar.dOS();
        if (dOS.goods != null) {
            if (com.baidu.tbadk.core.util.x.isEmpty(dOS.goods.thread_pic_list) && (AM = AdvertAppInfo.a.AM(dOS.goods.lego_card)) != null && dOS.goods.thread_pic_list != null) {
                dOS.goods.thread_pic_list.addAll(AM);
            }
            this.lGl = oVar;
        }
    }

    private void d(DataRes dataRes) {
        List<App> list = dataRes.banner_list.video_recommend_ad;
        this.lGG.clear();
        if (list != null && !list.isEmpty()) {
            for (App app : list) {
                com.baidu.tieba.tbadkCore.data.o oVar = new com.baidu.tieba.tbadkCore.data.o();
                oVar.e(app);
                AppData dOS = oVar.dOS();
                if (!this.lGG.contains(oVar) && dOS.goods != null && (!StringUtils.isNull(dOS.goods.user_name) || !StringUtils.isNull(dOS.goods.lego_card))) {
                    oVar.lVP = dnf();
                    this.lGG.add(oVar);
                }
            }
        }
    }

    public String dmQ() {
        return this.lGu;
    }

    public CardHListViewData dmR() {
        return this.lFM;
    }

    public PostData dmS() {
        return this.lGq;
    }

    public PostData f(PostData postData) {
        this.lGq = postData;
        return postData;
    }

    public r dmT() {
        return this.lGp;
    }

    public int dmU() {
        return this.userIdentity;
    }

    public int getIsNewUrl() {
        return this.lGc;
    }

    public void setIsNewUrl(int i) {
        this.lGc = i;
    }

    public List<MuteUser> dmV() {
        return this.lGf;
    }

    public ArrayList<com.baidu.tieba.tbadkCore.data.o> dmW() {
        return this.lGk;
    }

    public com.baidu.tieba.tbadkCore.data.o dmX() {
        return this.lGl;
    }

    public void b(com.baidu.tieba.tbadkCore.data.o oVar) {
        this.lGl = oVar;
    }

    public void dmY() {
        if (this.lGl.dOS() != null) {
            this.lGl.dOS().legoCard = null;
        }
        this.lGl = null;
    }

    public void dmZ() {
        this.lGH = null;
        this.lGI = null;
    }

    public String dna() {
        return this.lFL;
    }

    public void PB(String str) {
        this.lFL = str;
    }

    public i dnb() {
        return this.lGr;
    }

    public List<bv> dnc() {
        return this.lGo;
    }

    public long dnd() {
        return this.lGs;
    }

    public o dne() {
        return this.lGt;
    }

    public void a(o oVar) {
        this.lGt = oVar;
    }

    public boolean dnf() {
        return (dmF() == null || !dmF().bpW() || dmF().brI() == null) ? false : true;
    }

    public AlaLiveInfoCoreData dng() {
        return this.lGj;
    }

    public List<com.baidu.tbadk.core.data.o> dnh() {
        return this.lGy;
    }

    public boolean dni() {
        return dmF() != null && dmF().bqa();
    }

    public String dnj() {
        if (this.lFQ != null && this.lFQ.size() > this.lFR) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.lFQ.size()) {
                    break;
                } else if (this.lFQ.get(i2).sort_type.intValue() != this.lFR) {
                    i = i2 + 1;
                } else {
                    return this.lFQ.get(i2).sort_name;
                }
            }
        }
        return "";
    }

    public com.baidu.tieba.pb.videopb.c.a dnk() {
        return this.lGA;
    }

    public int dnl() {
        return this.lGz;
    }

    public void GH(int i) {
        this.lGz = i;
    }

    public List<com.baidu.tieba.tbadkCore.data.o> dnm() {
        return this.lGG;
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

    public List<ThreadInfo> dnn() {
        return this.lGL;
    }

    public ForumRuleStatus dno() {
        return this.forumRule;
    }
}

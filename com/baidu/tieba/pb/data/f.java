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
    public AppealInfo lFL;
    public String lFM;
    public CardHListViewData lFN;
    public String lFO;
    public int lFP;
    public int lFQ;
    public List<PbSortType> lFR;
    public int lFS;
    public k lFT;
    public a lFX;
    private com.baidu.tieba.pb.videopb.c.a lGB;
    private PostData lGC;
    private PostData lGE;
    public boolean lGG;
    private x lGJ;
    public String lGK;
    public String lGL;
    private List<ThreadInfo> lGM;
    private String lGc;
    private int lGd;
    private List<bz> lGj;
    private AlaLiveInfoCoreData lGk;
    private TwzhiboAnti lGn;
    private List<bv> lGo;
    private List<bv> lGp;
    private PostData lGr;
    private i lGs;
    private long lGt;
    private o lGu;
    private String lGv;
    private String lGw;
    private List<com.baidu.tbadk.core.data.o> lGz;
    public boolean lFU = false;
    public boolean lFV = false;
    public boolean lFW = false;
    public boolean lFY = false;
    private boolean lGh = true;
    private ArrayList<com.baidu.tieba.tbadkCore.data.o> lGl = new ArrayList<>();
    private com.baidu.tieba.tbadkCore.data.o lGm = null;
    private int lGA = 0;
    public boolean lGD = true;
    public int lGF = 0;
    public int aas = 0;
    private List<com.baidu.tieba.tbadkCore.data.o> lGH = new ArrayList();
    private ForumData forum = new ForumData();
    private bv lFZ = new bv();
    private bz gAx = new bz();
    private ArrayList<PostData> lGa = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private ax page = new ax();
    private AntiData anti = new AntiData();
    private com.baidu.tbadk.data.g lGb = new com.baidu.tbadk.data.g();
    private int userIdentity = 0;
    private final UserData userData = new UserData();
    private List<MuteUser> lGg = new ArrayList();
    private ba lGe = new ba();
    private bb lGi = new bb();
    private af lGf = new af();
    private r lGq = new r();
    private v lGI = new v();
    private List<bp.a> lGx = new ArrayList();
    private HashSet<String> lGy = new HashSet<>();

    public f() {
        this.lGd = 0;
        this.lGn = null;
        this.lGd = 0;
        this.lGn = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.lGa != null && this.lGa.size() > 0;
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
            int size = this.lGa.size() > 30 ? 30 : this.lGa.size();
            if (dmE() == null || dmE().brq() == null || at.isEmpty(dmE().brq().getUserId())) {
                return new String[]{null, ""};
            }
            String userId = dmE().brq().getUserId();
            PostData dmO = dmO();
            if (dmO == null || dmO.brq() == null || at.isEmpty(dmO.brq().getUserId())) {
                str2 = null;
            } else {
                if (!at.equals(userId, dmO.brq().getUserId())) {
                    str2 = null;
                } else {
                    str2 = dmO.dPk();
                }
                if (at.isEmpty("")) {
                    str5 = dmO.dPi();
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
                    PostData postData = (PostData) com.baidu.tbadk.core.util.x.getItem(this.lGa, i);
                    if (postData != null && postData.brq() != null && !at.isEmpty(postData.brq().getUserId()) && at.equals(userId, postData.brq().getUserId())) {
                        if (at.isEmpty(str6)) {
                            str6 = postData.dPk();
                        }
                        String dPi = at.isEmpty(str5) ? postData.dPi() : str5;
                        if (!at.isEmpty(str6) && !at.isEmpty(dPi)) {
                            str5 = dPi;
                            str3 = str6;
                            break;
                        }
                        str5 = dPi;
                    }
                    i++;
                }
            } else {
                str3 = str2;
            }
            String str7 = (z && at.isEmpty(str3)) ? "https://tieba-fe.gz.bcebos.com/yunying/tieba_logo.jpg" : str3;
            str = (this.gAx == null || this.gAx.bss() == null || this.gAx.bss().getGroup_id() == 0) ? str5 : "[" + context.getString(R.string.photo_live_tips) + "] " + str5;
            str4 = (this.gAx == null || this.gAx.brH() == null || at.isEmpty(this.gAx.brH().thumbnail_url)) ? str7 : this.gAx.brH().thumbnail_url;
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

    public bv dmD() {
        return this.lFZ;
    }

    public void d(bv bvVar) {
        this.lFZ = bvVar;
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

    public bz dmE() {
        return this.gAx;
    }

    public void aI(bz bzVar) {
        this.gAx = bzVar;
    }

    public List<bz> dmF() {
        return this.lGj;
    }

    public String getThreadId() {
        if (this.gAx == null) {
            return "";
        }
        return this.gAx.getId();
    }

    public ArrayList<PostData> dmG() {
        return this.lGa;
    }

    public ax getPage() {
        return this.page;
    }

    public af dmH() {
        return this.lGf;
    }

    public bb dmI() {
        return this.lGi;
    }

    public v dmJ() {
        if (this.lGI == null || !this.lGI.isValid()) {
            return null;
        }
        return this.lGI;
    }

    public x dmK() {
        if (this.lGJ == null || !this.lGJ.isValid()) {
            return null;
        }
        return this.lGJ;
    }

    public void a(ax axVar, int i) {
        this.page.oE(axVar.bqd());
        this.page.oC(axVar.bpc());
        this.page.oB(axVar.bqa());
        this.page.oF(axVar.bqe());
        this.page.oD(axVar.bqc());
        if (i == 0) {
            this.page = axVar;
        } else if (i == 1) {
            this.page.oG(axVar.bqf());
        } else if (i == 2) {
            this.page.oH(axVar.bqg());
        }
    }

    public AntiData getAnti() {
        return this.anti;
    }

    public UserData getUserData() {
        return this.userData;
    }

    public boolean bnx() {
        return this.gAx.brx() != 0;
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

    public String bnw() {
        if (this.gAx != null) {
            return this.gAx.bry();
        }
        return null;
    }

    public void PB(String str) {
        if (this.gAx != null) {
            this.gAx.Be(str);
        }
    }

    public String dmL() {
        return this.lGw;
    }

    public boolean dmM() {
        return (this.gAx == null || this.gAx.brA() == null || this.gAx.brA().size() <= 0 || this.gAx.brA().get(0) == null || !this.gAx.brA().get(0).bpd()) ? false : true;
    }

    public PostData dmN() {
        return this.lGC;
    }

    public void d(PostData postData) {
        this.lGC = postData;
        this.lGE = postData;
        this.lGD = false;
    }

    public PostData dmO() {
        return this.lGE;
    }

    public void e(PostData postData) {
        this.lGE = postData;
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                com.baidu.tieba.recapp.c.a.dFN().RS(dataRes.asp_shown_info);
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
                this.lFZ.parserProtobuf(dataRes.display_forum);
                this.gAx.setUserMap(this.userMap);
                this.gAx.a(dataRes.thread);
                this.lGe.a(dataRes.news_info);
                switch (this.lGe.evA) {
                    case 1:
                        this.lGf.lSO = this.lGe;
                        break;
                    case 2:
                        this.lGf.lSP = this.lGe;
                        break;
                    case 3:
                        this.lGf.lSQ = this.lGe;
                        break;
                    default:
                        this.lGf.lSP = this.lGe;
                        break;
                }
                this.lGi.a(dataRes.recommend_book);
                b(dataRes, context);
                this.lGC = new PostData();
                this.lGC.KR(1);
                this.lGC.setUserMap(this.userMap);
                this.lGC.yd(this.forum.isBrandForum);
                this.lGC.setTime(this.gAx.getCreateTime());
                if (dataRes.first_floor_post != null) {
                    this.lGC.a(dataRes.first_floor_post, context);
                }
                if (this.gAx != null && this.gAx.isShareThread) {
                    this.lGC.h(this.gAx.eVB);
                }
                if (this.lGE == null) {
                    this.lGE = this.lGC;
                    this.lGD = true;
                }
                this.page.a(dataRes.page);
                this.anti.parserProtobuf(dataRes.anti);
                this.lGb.a(dataRes.location);
                if (dataRes.user != null) {
                    this.userIdentity = dataRes.user.is_manager.intValue();
                }
                this.userData.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.lGg.add(muteUser);
                        }
                    }
                }
                this.gAx.oN(this.gAx.brh() > 0 ? this.gAx.brh() - 1 : 0);
                List<AppData> dET = com.baidu.tieba.recapp.r.dEV().dET();
                if (dET != null) {
                    dET.clear();
                }
                this.lGm = null;
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        com.baidu.tieba.tbadkCore.data.o oVar = new com.baidu.tieba.tbadkCore.data.o();
                        oVar.e(app);
                        AppData dOR = oVar.dOR();
                        if (!this.lGl.contains(oVar) && dOR.goods != null && (!StringUtils.isNull(dOR.goods.user_name) || !StringUtils.isNull(dOR.goods.lego_card))) {
                            oVar.lVQ = dne();
                            this.lGl.add(oVar);
                            if (dET != null) {
                                dET.add(oVar.dOR());
                            }
                        }
                    }
                    c(dataRes);
                    d(dataRes);
                }
                com.baidu.tieba.recapp.r.dEV().dEU();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.userData.getIsSelectTail());
                }
                this.lGn.parserProtobuf(dataRes.twzhibo_anti);
                this.lFL = dataRes.appeal_info;
                if (dataRes.forum_headline_img_info != null) {
                    this.lGs = new i();
                    this.lGs.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.guess_like != null) {
                    this.lFN = new CardHListViewData();
                    this.lFN.parseProtobuf(dataRes.guess_like);
                }
                b(dataRes);
                if (com.baidu.tbadk.core.util.x.getCount(dataRes.repost_recommend_forum_list) > 0) {
                    if (this.lGo == null) {
                        this.lGo = new ArrayList();
                    }
                    for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                        bv bvVar = new bv();
                        bvVar.parserProtobuf(simpleForum);
                        this.lGo.add(bvVar);
                    }
                }
                if (com.baidu.tbadk.core.util.x.getCount(dataRes.from_forum_list) > 0) {
                    if (this.lGp == null) {
                        this.lGp = new ArrayList();
                    }
                    for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                        if (simpleForum2 != null) {
                            bv bvVar2 = new bv();
                            bvVar2.parserProtobuf(simpleForum2);
                            this.lGp.add(bvVar2);
                        }
                    }
                }
                this.lGw = dataRes.multi_forum_text;
                if (this.lGt >= 0) {
                    this.lGt = dataRes.thread_freq_num.longValue();
                }
                a(dataRes);
                if (this.lGz == null) {
                    this.lGz = new ArrayList();
                }
                this.lGz.clear();
                if (dataRes.bjh_recommend != null) {
                    int i2 = 1;
                    for (ThreadInfo threadInfo : dataRes.bjh_recommend) {
                        if (threadInfo != null && !d(threadInfo) && !e(threadInfo)) {
                            com.baidu.tbadk.core.data.o oVar2 = new com.baidu.tbadk.core.data.o();
                            oVar2.setFloorNum(i2);
                            oVar2.a(threadInfo);
                            this.lGz.add(oVar2);
                            i2++;
                        }
                    }
                }
                if (this.lGB != null && this.lGB.dwL()) {
                    this.lGB = null;
                }
                if (dataRes.recom_ala_info != null && dataRes.recom_ala_info.live_status.intValue() == 1 && dataRes.recom_ala_info.pb_display_type.intValue() == 2) {
                    if (this.lGB == null) {
                        this.lGB = new com.baidu.tieba.pb.videopb.c.a();
                        this.lGB.parserProtoBuf(dataRes.recom_ala_info);
                    }
                } else if (this.lGB == null && dataRes.promotion != null) {
                    this.lGB = new com.baidu.tieba.pb.videopb.c.a();
                    this.lGB.a(dataRes.promotion);
                }
                if (dataRes.business_promot_info != null) {
                    this.lFU = dataRes.business_promot_info.is_promot.longValue() == 1;
                    this.lFV = dataRes.business_promot_info.is_headlinepost.intValue() == 1;
                    this.lFW = dataRes.business_promot_info.is_s_card.intValue() == 1;
                    if (dataRes.business_promot_info.send_card_info != null) {
                        b bVar = new b();
                        bVar.a(dataRes.business_promot_info.send_card_info);
                        if (this.lFX == null) {
                            this.lFX = new a();
                        }
                        this.lFX.a(bVar);
                    }
                }
                this.lGI.reset();
                this.lGI.setUserMap(this.userMap);
                this.lGI.a(dataRes.recom_ala_info);
                if (this.lGI.lPF != null) {
                    this.lGI.lPF.setTid(getThreadId());
                }
                this.lGJ = new x();
                this.lGJ.setUserMap(this.userMap);
                this.lGJ.a(dataRes.recom_ala_info);
                if (this.lGJ.lPF != null) {
                    this.lGJ.lPF.setTid(getThreadId());
                }
                if (com.baidu.tbadk.core.util.x.getCount(dataRes.recom_thread_info) > 0) {
                    this.lGM = dataRes.recom_thread_info;
                }
                this.lGK = dataRes.jumptotab1 == null ? null : dataRes.jumptotab1.toString();
                this.lGL = dataRes.jumptotab2;
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
                if (!this.lGy.contains(String.valueOf(post.id))) {
                    PostData postData = new PostData();
                    postData.setUserMap(this.userMap);
                    postData.yd(this.forum.isBrandForum);
                    postData.a(post, context);
                    postData.a(dmE().brb());
                    if (postData.btk() != null && postData.btk().baijiahaoData == null && dmE() != null && dmE().getBaijiahaoData() != null) {
                        postData.btk().baijiahaoData = dmE().getBaijiahaoData();
                    }
                    this.lGy.add(postData.getId());
                    if (postData.dPd() == 1 && this.gAx.bse()) {
                        if (dmM()) {
                            postData.setPostType(0);
                        } else {
                            postData.setPostType(this.gAx.bsd());
                        }
                    } else if (postData.dPd() == 1 && this.gAx.bsA()) {
                        postData.setPostType(41);
                    } else if (postData.dPd() == 1 && this.gAx != null && this.gAx.bpV()) {
                        postData.setPostType(0);
                        postData.bLg();
                        if (this.gAx.bro() == null || this.gAx.bro().size() == 0) {
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
                            postData.c(new TbRichText((Context) TbadkCoreApplication.getInst(), this.gAx.bro(), true));
                        }
                        this.lGr = postData;
                    }
                    if (postData.dPd() == 1 && this.gAx != null && this.gAx.isShareThread) {
                        postData.h(this.gAx.eVB);
                    }
                    if (postData.dPd() == 1) {
                        this.lGE = postData;
                        this.lGD = false;
                    }
                    this.lGa.add(postData);
                }
            }
        }
    }

    private void a(DataRes dataRes) {
        this.lGu = new o(this.gAx, this.anti);
        this.lFO = dataRes.partial_visible_toast;
        if (dataRes.follow_tip != null && dataRes.follow_tip.is_toast_tip.intValue() == 1) {
            this.lGc = dataRes.follow_tip.tip_text;
        }
        this.lGk = new AlaLiveInfoCoreData();
        if (dataRes.ala_info != null) {
            this.lGk.parserProtoBuf(dataRes.ala_info);
        }
        this.lGv = dataRes.fold_tip;
        this.lFP = dataRes.exp_news_today.intValue();
        this.lFQ = dataRes.exp_guide_today.intValue();
        if (!com.baidu.tbadk.core.util.x.isEmpty(dataRes.thread_topic)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= dataRes.thread_topic.size()) {
                    break;
                }
                bp.a aVar = new bp.a();
                aVar.a(dataRes.thread_topic.get(i2));
                this.lGx.add(aVar);
                i = i2 + 1;
            }
        }
        this.lFR = dataRes.pb_sort_info;
        this.lFS = dataRes.sort_type.intValue();
        if (dataRes.manager_election != null) {
            this.lFT = k.b(dataRes.manager_election);
        }
    }

    private void b(DataRes dataRes) {
        if (dataRes.feed_thread_list != null && dataRes.feed_thread_list.size() > 0) {
            List<ThreadInfo> list = dataRes.feed_thread_list;
            if (this.lGj == null) {
                this.lGj = new ArrayList();
            }
            this.lGj.clear();
            for (ThreadInfo threadInfo : list) {
                if (threadInfo != null) {
                    bz bzVar = new bz();
                    bzVar.a(threadInfo);
                    this.lGj.add(bzVar);
                }
            }
            if (this.lGj != null && this.lGj.size() > 15) {
                this.lGj = com.baidu.tbadk.core.util.x.subList(this.lGj, 0, 15);
            }
        }
    }

    private void c(DataRes dataRes) {
        List<String> AN;
        App app = dataRes.banner_list.pb_banner_ad;
        com.baidu.tieba.tbadkCore.data.o oVar = new com.baidu.tieba.tbadkCore.data.o();
        oVar.nrs = true;
        oVar.e(app);
        AppData dOR = oVar.dOR();
        if (dOR.goods != null) {
            if (com.baidu.tbadk.core.util.x.isEmpty(dOR.goods.thread_pic_list) && (AN = AdvertAppInfo.a.AN(dOR.goods.lego_card)) != null && dOR.goods.thread_pic_list != null) {
                dOR.goods.thread_pic_list.addAll(AN);
            }
            this.lGm = oVar;
        }
    }

    private void d(DataRes dataRes) {
        List<App> list = dataRes.banner_list.video_recommend_ad;
        this.lGH.clear();
        if (list != null && !list.isEmpty()) {
            for (App app : list) {
                com.baidu.tieba.tbadkCore.data.o oVar = new com.baidu.tieba.tbadkCore.data.o();
                oVar.e(app);
                AppData dOR = oVar.dOR();
                if (!this.lGH.contains(oVar) && dOR.goods != null && (!StringUtils.isNull(dOR.goods.user_name) || !StringUtils.isNull(dOR.goods.lego_card))) {
                    oVar.lVQ = dne();
                    this.lGH.add(oVar);
                }
            }
        }
    }

    public String dmP() {
        return this.lGv;
    }

    public CardHListViewData dmQ() {
        return this.lFN;
    }

    public PostData dmR() {
        return this.lGr;
    }

    public PostData f(PostData postData) {
        this.lGr = postData;
        return postData;
    }

    public r dmS() {
        return this.lGq;
    }

    public int dmT() {
        return this.userIdentity;
    }

    public int getIsNewUrl() {
        return this.lGd;
    }

    public void setIsNewUrl(int i) {
        this.lGd = i;
    }

    public List<MuteUser> dmU() {
        return this.lGg;
    }

    public ArrayList<com.baidu.tieba.tbadkCore.data.o> dmV() {
        return this.lGl;
    }

    public com.baidu.tieba.tbadkCore.data.o dmW() {
        return this.lGm;
    }

    public void b(com.baidu.tieba.tbadkCore.data.o oVar) {
        this.lGm = oVar;
    }

    public void dmX() {
        if (this.lGm.dOR() != null) {
            this.lGm.dOR().legoCard = null;
        }
        this.lGm = null;
    }

    public void dmY() {
        this.lGI = null;
        this.lGJ = null;
    }

    public String dmZ() {
        return this.lFM;
    }

    public void PC(String str) {
        this.lFM = str;
    }

    public i dna() {
        return this.lGs;
    }

    public List<bv> dnb() {
        return this.lGp;
    }

    public long dnc() {
        return this.lGt;
    }

    public o dnd() {
        return this.lGu;
    }

    public void a(o oVar) {
        this.lGu = oVar;
    }

    public boolean dne() {
        return (dmE() == null || !dmE().bpV() || dmE().brH() == null) ? false : true;
    }

    public AlaLiveInfoCoreData dnf() {
        return this.lGk;
    }

    public List<com.baidu.tbadk.core.data.o> dng() {
        return this.lGz;
    }

    public boolean dnh() {
        return dmE() != null && dmE().bpZ();
    }

    public String dni() {
        if (this.lFR != null && this.lFR.size() > this.lFS) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.lFR.size()) {
                    break;
                } else if (this.lFR.get(i2).sort_type.intValue() != this.lFS) {
                    i = i2 + 1;
                } else {
                    return this.lFR.get(i2).sort_name;
                }
            }
        }
        return "";
    }

    public com.baidu.tieba.pb.videopb.c.a dnj() {
        return this.lGB;
    }

    public int dnk() {
        return this.lGA;
    }

    public void GH(int i) {
        this.lGA = i;
    }

    public List<com.baidu.tieba.tbadkCore.data.o> dnl() {
        return this.lGH;
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

    public List<ThreadInfo> dnm() {
        return this.lGM;
    }

    public ForumRuleStatus dnn() {
        return this.forumRule;
    }
}

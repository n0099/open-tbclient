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
    private List<bz> lBD;
    private AlaLiveInfoCoreData lBE;
    private TwzhiboAnti lBH;
    private List<bv> lBI;
    private List<bv> lBJ;
    private PostData lBL;
    private i lBM;
    private long lBN;
    private o lBO;
    private String lBP;
    private String lBQ;
    private List<com.baidu.tbadk.core.data.o> lBT;
    private com.baidu.tieba.pb.videopb.c.a lBV;
    private PostData lBW;
    private PostData lBY;
    public AppealInfo lBf;
    public String lBg;
    public CardHListViewData lBh;
    public String lBi;
    public int lBj;
    public int lBk;
    public List<PbSortType> lBl;
    public int lBm;
    public k lBn;
    public a lBr;
    private String lBw;
    private int lBx;
    public boolean lCa;
    private x lCd;
    public String lCe;
    public String lCf;
    private List<ThreadInfo> lCg;
    public boolean lBo = false;
    public boolean lBp = false;
    public boolean lBq = false;
    public boolean lBs = false;
    private boolean lBB = true;
    private ArrayList<com.baidu.tieba.tbadkCore.data.o> lBF = new ArrayList<>();
    private com.baidu.tieba.tbadkCore.data.o lBG = null;
    private int lBU = 0;
    public boolean lBX = true;
    public int lBZ = 0;
    public int aaq = 0;
    private List<com.baidu.tieba.tbadkCore.data.o> lCb = new ArrayList();
    private ForumData forum = new ForumData();
    private bv lBt = new bv();
    private bz gvQ = new bz();
    private ArrayList<PostData> lBu = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private ax page = new ax();
    private AntiData anti = new AntiData();
    private com.baidu.tbadk.data.g lBv = new com.baidu.tbadk.data.g();
    private int userIdentity = 0;
    private final UserData userData = new UserData();
    private List<MuteUser> lBA = new ArrayList();
    private ba lBy = new ba();
    private bb lBC = new bb();
    private af lBz = new af();
    private r lBK = new r();
    private v lCc = new v();
    private List<bp.a> lBR = new ArrayList();
    private HashSet<String> lBS = new HashSet<>();

    public f() {
        this.lBx = 0;
        this.lBH = null;
        this.lBx = 0;
        this.lBH = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.lBu != null && this.lBu.size() > 0;
    }

    public String[] gI(Context context) {
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
            int size = this.lBu.size() > 30 ? 30 : this.lBu.size();
            if (diN() == null || diN().bnx() == null || at.isEmpty(diN().bnx().getUserId())) {
                return new String[]{null, ""};
            }
            String userId = diN().bnx().getUserId();
            PostData diX = diX();
            if (diX == null || diX.bnx() == null || at.isEmpty(diX.bnx().getUserId())) {
                str2 = null;
            } else {
                if (!at.equals(userId, diX.bnx().getUserId())) {
                    str2 = null;
                } else {
                    str2 = diX.dLt();
                }
                if (at.isEmpty("")) {
                    str5 = diX.dLr();
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
                    PostData postData = (PostData) com.baidu.tbadk.core.util.x.getItem(this.lBu, i);
                    if (postData != null && postData.bnx() != null && !at.isEmpty(postData.bnx().getUserId()) && at.equals(userId, postData.bnx().getUserId())) {
                        if (at.isEmpty(str6)) {
                            str6 = postData.dLt();
                        }
                        String dLr = at.isEmpty(str5) ? postData.dLr() : str5;
                        if (!at.isEmpty(str6) && !at.isEmpty(dLr)) {
                            str5 = dLr;
                            str3 = str6;
                            break;
                        }
                        str5 = dLr;
                    }
                    i++;
                }
            } else {
                str3 = str2;
            }
            String str7 = (z && at.isEmpty(str3)) ? "https://tieba-fe.gz.bcebos.com/yunying/tieba_logo.jpg" : str3;
            str = (this.gvQ == null || this.gvQ.boz() == null || this.gvQ.boz().getGroup_id() == 0) ? str5 : "[" + context.getString(R.string.photo_live_tips) + "] " + str5;
            str4 = (this.gvQ == null || this.gvQ.bnO() == null || at.isEmpty(this.gvQ.bnO().thumbnail_url)) ? str7 : this.gvQ.bnO().thumbnail_url;
            if (this.gvQ != null && !this.gvQ.isShareThread && str4 == null && this.gvQ.eQQ != null && this.gvQ.eQQ.eMh != null) {
                ArrayList<MediaData> arrayList = this.gvQ.eQQ.eMh;
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

    public bv diM() {
        return this.lBt;
    }

    public void d(bv bvVar) {
        this.lBt = bvVar;
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

    public bz diN() {
        return this.gvQ;
    }

    public void aI(bz bzVar) {
        this.gvQ = bzVar;
    }

    public List<bz> diO() {
        return this.lBD;
    }

    public String getThreadId() {
        if (this.gvQ == null) {
            return "";
        }
        return this.gvQ.getId();
    }

    public ArrayList<PostData> diP() {
        return this.lBu;
    }

    public ax getPage() {
        return this.page;
    }

    public af diQ() {
        return this.lBz;
    }

    public bb diR() {
        return this.lBC;
    }

    public v diS() {
        if (this.lCc == null || !this.lCc.isValid()) {
            return null;
        }
        return this.lCc;
    }

    public x diT() {
        if (this.lCd == null || !this.lCd.isValid()) {
            return null;
        }
        return this.lCd;
    }

    public void a(ax axVar, int i) {
        this.page.mY(axVar.bmk());
        this.page.mW(axVar.blj());
        this.page.mV(axVar.bmh());
        this.page.mZ(axVar.bml());
        this.page.mX(axVar.bmj());
        if (i == 0) {
            this.page = axVar;
        } else if (i == 1) {
            this.page.na(axVar.bmm());
        } else if (i == 2) {
            this.page.nb(axVar.bmn());
        }
    }

    public AntiData getAnti() {
        return this.anti;
    }

    public UserData getUserData() {
        return this.userData;
    }

    public boolean bjE() {
        return this.gvQ.bnE() != 0;
    }

    public void iY(boolean z) {
        if (this.gvQ != null) {
            if (z) {
                this.gvQ.nl(1);
            } else {
                this.gvQ.nl(0);
            }
        }
    }

    public String bjD() {
        if (this.gvQ != null) {
            return this.gvQ.bnF();
        }
        return null;
    }

    public void Os(String str) {
        if (this.gvQ != null) {
            this.gvQ.zS(str);
        }
    }

    public String diU() {
        return this.lBQ;
    }

    public boolean diV() {
        return (this.gvQ == null || this.gvQ.bnH() == null || this.gvQ.bnH().size() <= 0 || this.gvQ.bnH().get(0) == null || !this.gvQ.bnH().get(0).blk()) ? false : true;
    }

    public PostData diW() {
        return this.lBW;
    }

    public void d(PostData postData) {
        this.lBW = postData;
        this.lBY = postData;
        this.lBX = false;
    }

    public PostData diX() {
        return this.lBY;
    }

    public void e(PostData postData) {
        this.lBY = postData;
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                com.baidu.tieba.recapp.c.a.dBW().QJ(dataRes.asp_shown_info);
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
                this.lBt.parserProtobuf(dataRes.display_forum);
                this.gvQ.setUserMap(this.userMap);
                this.gvQ.a(dataRes.thread);
                this.lBy.a(dataRes.news_info);
                switch (this.lBy.eqM) {
                    case 1:
                        this.lBz.lOj = this.lBy;
                        break;
                    case 2:
                        this.lBz.lOk = this.lBy;
                        break;
                    case 3:
                        this.lBz.lOl = this.lBy;
                        break;
                    default:
                        this.lBz.lOk = this.lBy;
                        break;
                }
                this.lBC.a(dataRes.recommend_book);
                b(dataRes, context);
                this.lBW = new PostData();
                this.lBW.Jk(1);
                this.lBW.setUserMap(this.userMap);
                this.lBW.xZ(this.forum.isBrandForum);
                this.lBW.setTime(this.gvQ.getCreateTime());
                if (dataRes.first_floor_post != null) {
                    this.lBW.a(dataRes.first_floor_post, context);
                }
                if (this.gvQ != null && this.gvQ.isShareThread) {
                    this.lBW.h(this.gvQ.eQQ);
                }
                if (this.lBY == null) {
                    this.lBY = this.lBW;
                    this.lBX = true;
                }
                this.page.a(dataRes.page);
                this.anti.parserProtobuf(dataRes.anti);
                this.lBv.a(dataRes.location);
                if (dataRes.user != null) {
                    this.userIdentity = dataRes.user.is_manager.intValue();
                }
                this.userData.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.lBA.add(muteUser);
                        }
                    }
                }
                this.gvQ.nh(this.gvQ.bno() > 0 ? this.gvQ.bno() - 1 : 0);
                List<AppData> dBc = com.baidu.tieba.recapp.r.dBe().dBc();
                if (dBc != null) {
                    dBc.clear();
                }
                this.lBG = null;
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        com.baidu.tieba.tbadkCore.data.o oVar = new com.baidu.tieba.tbadkCore.data.o();
                        oVar.e(app);
                        AppData dLa = oVar.dLa();
                        if (!this.lBF.contains(oVar) && dLa.goods != null && (!StringUtils.isNull(dLa.goods.user_name) || !StringUtils.isNull(dLa.goods.lego_card))) {
                            oVar.lRl = djn();
                            this.lBF.add(oVar);
                            if (dBc != null) {
                                dBc.add(oVar.dLa());
                            }
                        }
                    }
                    c(dataRes);
                    d(dataRes);
                }
                com.baidu.tieba.recapp.r.dBe().dBd();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.userData.getIsSelectTail());
                }
                this.lBH.parserProtobuf(dataRes.twzhibo_anti);
                this.lBf = dataRes.appeal_info;
                if (dataRes.forum_headline_img_info != null) {
                    this.lBM = new i();
                    this.lBM.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.guess_like != null) {
                    this.lBh = new CardHListViewData();
                    this.lBh.parseProtobuf(dataRes.guess_like);
                }
                b(dataRes);
                if (com.baidu.tbadk.core.util.x.getCount(dataRes.repost_recommend_forum_list) > 0) {
                    if (this.lBI == null) {
                        this.lBI = new ArrayList();
                    }
                    for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                        bv bvVar = new bv();
                        bvVar.parserProtobuf(simpleForum);
                        this.lBI.add(bvVar);
                    }
                }
                if (com.baidu.tbadk.core.util.x.getCount(dataRes.from_forum_list) > 0) {
                    if (this.lBJ == null) {
                        this.lBJ = new ArrayList();
                    }
                    for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                        if (simpleForum2 != null) {
                            bv bvVar2 = new bv();
                            bvVar2.parserProtobuf(simpleForum2);
                            this.lBJ.add(bvVar2);
                        }
                    }
                }
                this.lBQ = dataRes.multi_forum_text;
                if (this.lBN >= 0) {
                    this.lBN = dataRes.thread_freq_num.longValue();
                }
                a(dataRes);
                if (this.lBT == null) {
                    this.lBT = new ArrayList();
                }
                this.lBT.clear();
                if (dataRes.bjh_recommend != null) {
                    int i2 = 1;
                    for (ThreadInfo threadInfo : dataRes.bjh_recommend) {
                        if (threadInfo != null && !d(threadInfo) && !e(threadInfo)) {
                            com.baidu.tbadk.core.data.o oVar2 = new com.baidu.tbadk.core.data.o();
                            oVar2.setFloorNum(i2);
                            oVar2.a(threadInfo);
                            this.lBT.add(oVar2);
                            i2++;
                        }
                    }
                }
                if (this.lBV != null && this.lBV.dsU()) {
                    this.lBV = null;
                }
                if (dataRes.recom_ala_info != null && dataRes.recom_ala_info.live_status.intValue() == 1 && dataRes.recom_ala_info.pb_display_type.intValue() == 2) {
                    if (this.lBV == null) {
                        this.lBV = new com.baidu.tieba.pb.videopb.c.a();
                        this.lBV.parserProtoBuf(dataRes.recom_ala_info);
                    }
                } else if (this.lBV == null && dataRes.promotion != null) {
                    this.lBV = new com.baidu.tieba.pb.videopb.c.a();
                    this.lBV.a(dataRes.promotion);
                }
                if (dataRes.business_promot_info != null) {
                    this.lBo = dataRes.business_promot_info.is_promot.longValue() == 1;
                    this.lBp = dataRes.business_promot_info.is_headlinepost.intValue() == 1;
                    this.lBq = dataRes.business_promot_info.is_s_card.intValue() == 1;
                    if (dataRes.business_promot_info.send_card_info != null) {
                        b bVar = new b();
                        bVar.a(dataRes.business_promot_info.send_card_info);
                        if (this.lBr == null) {
                            this.lBr = new a();
                        }
                        this.lBr.a(bVar);
                    }
                }
                this.lCc.reset();
                this.lCc.setUserMap(this.userMap);
                this.lCc.a(dataRes.recom_ala_info);
                if (this.lCc.lLa != null) {
                    this.lCc.lLa.setTid(getThreadId());
                }
                this.lCd = new x();
                this.lCd.setUserMap(this.userMap);
                this.lCd.a(dataRes.recom_ala_info);
                if (this.lCd.lLa != null) {
                    this.lCd.lLa.setTid(getThreadId());
                }
                if (com.baidu.tbadk.core.util.x.getCount(dataRes.recom_thread_info) > 0) {
                    this.lCg = dataRes.recom_thread_info;
                }
                this.lCe = dataRes.jumptotab1 == null ? null : dataRes.jumptotab1.toString();
                this.lCf = dataRes.jumptotab2;
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
                if (!this.lBS.contains(String.valueOf(post.id))) {
                    PostData postData = new PostData();
                    postData.setUserMap(this.userMap);
                    postData.xZ(this.forum.isBrandForum);
                    postData.a(post, context);
                    postData.a(diN().bni());
                    if (postData.bpr() != null && postData.bpr().baijiahaoData == null && diN() != null && diN().getBaijiahaoData() != null) {
                        postData.bpr().baijiahaoData = diN().getBaijiahaoData();
                    }
                    this.lBS.add(postData.getId());
                    if (postData.dLm() == 1 && this.gvQ.bol()) {
                        if (diV()) {
                            postData.setPostType(0);
                        } else {
                            postData.setPostType(this.gvQ.bok());
                        }
                    } else if (postData.dLm() == 1 && this.gvQ.boH()) {
                        postData.setPostType(41);
                    } else if (postData.dLm() == 1 && this.gvQ != null && this.gvQ.bmc()) {
                        postData.setPostType(0);
                        postData.bHp();
                        if (this.gvQ.bnv() == null || this.gvQ.bnv().size() == 0) {
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
                            postData.c(new TbRichText((Context) TbadkCoreApplication.getInst(), this.gvQ.bnv(), true));
                        }
                        this.lBL = postData;
                    }
                    if (postData.dLm() == 1 && this.gvQ != null && this.gvQ.isShareThread) {
                        postData.h(this.gvQ.eQQ);
                    }
                    if (postData.dLm() == 1) {
                        this.lBY = postData;
                        this.lBX = false;
                    }
                    this.lBu.add(postData);
                }
            }
        }
    }

    private void a(DataRes dataRes) {
        this.lBO = new o(this.gvQ, this.anti);
        this.lBi = dataRes.partial_visible_toast;
        if (dataRes.follow_tip != null && dataRes.follow_tip.is_toast_tip.intValue() == 1) {
            this.lBw = dataRes.follow_tip.tip_text;
        }
        this.lBE = new AlaLiveInfoCoreData();
        if (dataRes.ala_info != null) {
            this.lBE.parserProtoBuf(dataRes.ala_info);
        }
        this.lBP = dataRes.fold_tip;
        this.lBj = dataRes.exp_news_today.intValue();
        this.lBk = dataRes.exp_guide_today.intValue();
        if (!com.baidu.tbadk.core.util.x.isEmpty(dataRes.thread_topic)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= dataRes.thread_topic.size()) {
                    break;
                }
                bp.a aVar = new bp.a();
                aVar.a(dataRes.thread_topic.get(i2));
                this.lBR.add(aVar);
                i = i2 + 1;
            }
        }
        this.lBl = dataRes.pb_sort_info;
        this.lBm = dataRes.sort_type.intValue();
        if (dataRes.manager_election != null) {
            this.lBn = k.b(dataRes.manager_election);
        }
    }

    private void b(DataRes dataRes) {
        if (dataRes.feed_thread_list != null && dataRes.feed_thread_list.size() > 0) {
            List<ThreadInfo> list = dataRes.feed_thread_list;
            if (this.lBD == null) {
                this.lBD = new ArrayList();
            }
            this.lBD.clear();
            for (ThreadInfo threadInfo : list) {
                if (threadInfo != null) {
                    bz bzVar = new bz();
                    bzVar.a(threadInfo);
                    this.lBD.add(bzVar);
                }
            }
            if (this.lBD != null && this.lBD.size() > 15) {
                this.lBD = com.baidu.tbadk.core.util.x.subList(this.lBD, 0, 15);
            }
        }
    }

    private void c(DataRes dataRes) {
        List<String> zB;
        App app = dataRes.banner_list.pb_banner_ad;
        com.baidu.tieba.tbadkCore.data.o oVar = new com.baidu.tieba.tbadkCore.data.o();
        oVar.nmK = true;
        oVar.e(app);
        AppData dLa = oVar.dLa();
        if (dLa.goods != null) {
            if (com.baidu.tbadk.core.util.x.isEmpty(dLa.goods.thread_pic_list) && (zB = AdvertAppInfo.a.zB(dLa.goods.lego_card)) != null && dLa.goods.thread_pic_list != null) {
                dLa.goods.thread_pic_list.addAll(zB);
            }
            this.lBG = oVar;
        }
    }

    private void d(DataRes dataRes) {
        List<App> list = dataRes.banner_list.video_recommend_ad;
        this.lCb.clear();
        if (list != null && !list.isEmpty()) {
            for (App app : list) {
                com.baidu.tieba.tbadkCore.data.o oVar = new com.baidu.tieba.tbadkCore.data.o();
                oVar.e(app);
                AppData dLa = oVar.dLa();
                if (!this.lCb.contains(oVar) && dLa.goods != null && (!StringUtils.isNull(dLa.goods.user_name) || !StringUtils.isNull(dLa.goods.lego_card))) {
                    oVar.lRl = djn();
                    this.lCb.add(oVar);
                }
            }
        }
    }

    public String diY() {
        return this.lBP;
    }

    public CardHListViewData diZ() {
        return this.lBh;
    }

    public PostData dja() {
        return this.lBL;
    }

    public PostData f(PostData postData) {
        this.lBL = postData;
        return postData;
    }

    public r djb() {
        return this.lBK;
    }

    public int djc() {
        return this.userIdentity;
    }

    public int getIsNewUrl() {
        return this.lBx;
    }

    public void setIsNewUrl(int i) {
        this.lBx = i;
    }

    public List<MuteUser> djd() {
        return this.lBA;
    }

    public ArrayList<com.baidu.tieba.tbadkCore.data.o> dje() {
        return this.lBF;
    }

    public com.baidu.tieba.tbadkCore.data.o djf() {
        return this.lBG;
    }

    public void b(com.baidu.tieba.tbadkCore.data.o oVar) {
        this.lBG = oVar;
    }

    public void djg() {
        if (this.lBG.dLa() != null) {
            this.lBG.dLa().legoCard = null;
        }
        this.lBG = null;
    }

    public void djh() {
        this.lCc = null;
        this.lCd = null;
    }

    public String dji() {
        return this.lBg;
    }

    public void Ot(String str) {
        this.lBg = str;
    }

    public i djj() {
        return this.lBM;
    }

    public List<bv> djk() {
        return this.lBJ;
    }

    public long djl() {
        return this.lBN;
    }

    public o djm() {
        return this.lBO;
    }

    public void a(o oVar) {
        this.lBO = oVar;
    }

    public boolean djn() {
        return (diN() == null || !diN().bmc() || diN().bnO() == null) ? false : true;
    }

    public AlaLiveInfoCoreData djo() {
        return this.lBE;
    }

    public List<com.baidu.tbadk.core.data.o> djp() {
        return this.lBT;
    }

    public boolean djq() {
        return diN() != null && diN().bmg();
    }

    public String djr() {
        if (this.lBl != null && this.lBl.size() > this.lBm) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.lBl.size()) {
                    break;
                } else if (this.lBl.get(i2).sort_type.intValue() != this.lBm) {
                    i = i2 + 1;
                } else {
                    return this.lBl.get(i2).sort_name;
                }
            }
        }
        return "";
    }

    public com.baidu.tieba.pb.videopb.c.a djs() {
        return this.lBV;
    }

    public int djt() {
        return this.lBU;
    }

    public void Fb(int i) {
        this.lBU = i;
    }

    public List<com.baidu.tieba.tbadkCore.data.o> dju() {
        return this.lCb;
    }

    private boolean d(ThreadInfo threadInfo) {
        if (threadInfo == null || getThreadId() == null || "0".equals(threadInfo.id) || "0".equals(threadInfo.tid)) {
            return false;
        }
        return getThreadId().equals(threadInfo.id) || getThreadId().equals(threadInfo.tid);
    }

    private boolean e(ThreadInfo threadInfo) {
        if (threadInfo == null || threadInfo.baijiahao == null || threadInfo.baijiahao.ori_ugc_nid == null || this.gvQ == null || this.gvQ.getBaijiahaoData() == null || this.gvQ.getBaijiahaoData().oriUgcNid == null || "0".equals(threadInfo.baijiahao.ori_ugc_nid)) {
            return false;
        }
        return threadInfo.baijiahao.ori_ugc_nid.equals(this.gvQ.getBaijiahaoData().oriUgcNid);
    }

    public List<ThreadInfo> djv() {
        return this.lCg;
    }

    public ForumRuleStatus djw() {
        return this.forumRule;
    }
}

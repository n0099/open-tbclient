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
import com.baidu.tbadk.core.data.bo;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
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
import tbclient.ForumRuleStatus;
import tbclient.PbPage.AppealInfo;
import tbclient.PbPage.DataRes;
import tbclient.PbPage.PbSortType;
import tbclient.Post;
import tbclient.SimpleForum;
import tbclient.SimpleUser;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes22.dex */
public class f {
    private ForumRuleStatus forumRule;
    public AppealInfo lAF;
    public String lAG;
    public CardHListViewData lAH;
    public String lAI;
    public int lAJ;
    public int lAK;
    public List<PbSortType> lAL;
    public int lAM;
    public k lAN;
    public a lAR;
    private String lAW;
    private int lAX;
    public boolean lBA;
    private ac lBD;
    public String lBE;
    public String lBF;
    private List<ThreadInfo> lBG;
    private List<by> lBd;
    private AlaLiveInfoCoreData lBe;
    private TwzhiboAnti lBh;
    private List<bu> lBi;
    private List<bu> lBj;
    private PostData lBl;
    private i lBm;
    private long lBn;
    private o lBo;
    private String lBp;
    private String lBq;
    private List<com.baidu.tbadk.core.data.o> lBt;
    private com.baidu.tieba.pb.videopb.c.a lBv;
    private PostData lBw;
    private PostData lBy;
    public boolean lAO = false;
    public boolean lAP = false;
    public boolean lAQ = false;
    public boolean lAS = false;
    private boolean lBb = true;
    private ArrayList<com.baidu.tieba.tbadkCore.data.n> lBf = new ArrayList<>();
    private com.baidu.tieba.tbadkCore.data.n lBg = null;
    private int lBu = 0;
    public boolean lBx = true;
    public int lBz = 0;
    public int ZJ = 0;
    private List<com.baidu.tieba.tbadkCore.data.n> lBB = new ArrayList();
    private ForumData forum = new ForumData();
    private bu lAT = new bu();
    private by gpH = new by();
    private ArrayList<PostData> lAU = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private ax page = new ax();
    private AntiData anti = new AntiData();
    private com.baidu.tbadk.data.g lAV = new com.baidu.tbadk.data.g();
    private int userIdentity = 0;
    private final UserData userData = new UserData();
    private List<MuteUser> lBa = new ArrayList();
    private ba lAY = new ba();
    private bb lBc = new bb();
    private am lAZ = new am();
    private r lBk = new r();
    private z lBC = new z();
    private List<bo.a> lBr = new ArrayList();
    private HashSet<String> lBs = new HashSet<>();

    public f() {
        this.lAX = 0;
        this.lBh = null;
        this.lAX = 0;
        this.lBh = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.lAU != null && this.lAU.size() > 0;
    }

    public String[] gr(Context context) {
        return w(context, true);
    }

    public String[] w(Context context, boolean z) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5 = null;
        if (!isValid()) {
            str = "";
        } else {
            int size = this.lAU.size() > 30 ? 30 : this.lAU.size();
            if (dmU() == null || dmU().boP() == null || au.isEmpty(dmU().boP().getUserId())) {
                return new String[]{null, ""};
            }
            String userId = dmU().boP().getUserId();
            PostData dne = dne();
            if (dne == null || dne.boP() == null || au.isEmpty(dne.boP().getUserId())) {
                str2 = "";
            } else {
                if (!au.equals(userId, dne.boP().getUserId())) {
                    str4 = null;
                } else {
                    str4 = dne.dPo();
                }
                if (!au.isEmpty("")) {
                    str5 = str4;
                    str2 = "";
                } else {
                    str5 = str4;
                    str2 = dne.dPm();
                }
            }
            if (au.isEmpty(str2) && au.isEmpty(str5)) {
                int i = 0;
                String str6 = str2;
                while (true) {
                    if (i >= size) {
                        str = str6;
                        str3 = str5;
                        break;
                    }
                    PostData postData = (PostData) y.getItem(this.lAU, i);
                    if (postData != null && postData.boP() != null && !au.isEmpty(postData.boP().getUserId()) && au.equals(userId, postData.boP().getUserId())) {
                        if (au.isEmpty(str5)) {
                            str5 = postData.dPo();
                        }
                        String dPm = au.isEmpty(str6) ? postData.dPm() : str6;
                        if (!au.isEmpty(str5) && !au.isEmpty(dPm)) {
                            str = dPm;
                            str3 = str5;
                            break;
                        }
                        str6 = dPm;
                    }
                    i++;
                }
            } else {
                str = str2;
                str3 = str5;
            }
            if (z && au.isEmpty(str3)) {
                str3 = "https://tieba-fe.gz.bcebos.com/yunying/tieba_logo.jpg";
            }
            if (this.gpH != null && this.gpH.bpR() != null && this.gpH.bpR().getGroup_id() != 0) {
                str = "[" + context.getString(R.string.photo_live_tips) + "] " + str;
            }
            str5 = (this.gpH == null || this.gpH.bph() == null || au.isEmpty(this.gpH.bph().thumbnail_url)) ? str3 : this.gpH.bph().thumbnail_url;
            if (this.gpH != null && !this.gpH.isShareThread && str5 == null && this.gpH.eLH != null && this.gpH.eLH.eHb != null) {
                ArrayList<MediaData> arrayList = this.gpH.eLH.eHb;
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

    public bu dmT() {
        return this.lAT;
    }

    public void d(bu buVar) {
        this.lAT = buVar;
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

    public by dmU() {
        return this.gpH;
    }

    public void aH(by byVar) {
        this.gpH = byVar;
    }

    public List<by> dmV() {
        return this.lBd;
    }

    public String getThreadId() {
        if (this.gpH == null) {
            return "";
        }
        return this.gpH.getId();
    }

    public ArrayList<PostData> dmW() {
        return this.lAU;
    }

    public ax getPage() {
        return this.page;
    }

    public am dmX() {
        return this.lAZ;
    }

    public bb dmY() {
        return this.lBc;
    }

    public z dmZ() {
        if (this.lBC == null || !this.lBC.isValid()) {
            return null;
        }
        return this.lBC;
    }

    public ac dna() {
        if (this.lBD == null || !this.lBD.isValid()) {
            return null;
        }
        return this.lBD;
    }

    public void a(ax axVar, int i) {
        this.page.ou(axVar.bnD());
        this.page.os(axVar.bmB());
        this.page.or(axVar.bnA());
        this.page.ov(axVar.bnE());
        this.page.ot(axVar.bnC());
        if (i == 0) {
            this.page = axVar;
        } else if (i == 1) {
            this.page.ow(axVar.bnF());
        } else if (i == 2) {
            this.page.ox(axVar.bnG());
        }
    }

    public AntiData getAnti() {
        return this.anti;
    }

    public UserData getUserData() {
        return this.userData;
    }

    public boolean bkY() {
        return this.gpH.boW() != 0;
    }

    public void iH(boolean z) {
        if (this.gpH != null) {
            if (z) {
                this.gpH.oH(1);
            } else {
                this.gpH.oH(0);
            }
        }
    }

    public String bkX() {
        if (this.gpH != null) {
            return this.gpH.boX();
        }
        return null;
    }

    public void PV(String str) {
        if (this.gpH != null) {
            this.gpH.Bf(str);
        }
    }

    public String dnb() {
        return this.lBq;
    }

    public boolean dnc() {
        return (this.gpH == null || this.gpH.boZ() == null || this.gpH.boZ().size() <= 0 || this.gpH.boZ().get(0) == null || !this.gpH.boZ().get(0).bmC()) ? false : true;
    }

    public PostData dnd() {
        return this.lBw;
    }

    public void d(PostData postData) {
        this.lBw = postData;
        this.lBy = postData;
        this.lBx = false;
    }

    public PostData dne() {
        return this.lBy;
    }

    public void e(PostData postData) {
        this.lBy = postData;
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                com.baidu.tieba.recapp.d.a.dFY().Sk(dataRes.asp_shown_info);
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
                this.lAT.parserProtobuf(dataRes.display_forum);
                this.gpH.setUserMap(this.userMap);
                this.gpH.a(dataRes.thread);
                this.lAY.a(dataRes.news_info);
                switch (this.lAY.elT) {
                    case 1:
                        this.lAZ.lNB = this.lAY;
                        break;
                    case 2:
                        this.lAZ.lNC = this.lAY;
                        break;
                    case 3:
                        this.lAZ.lND = this.lAY;
                        break;
                    default:
                        this.lAZ.lNC = this.lAY;
                        break;
                }
                this.lBc.a(dataRes.recommend_book);
                b(dataRes, context);
                this.lBw = new PostData();
                this.lBw.KV(1);
                this.lBw.setUserMap(this.userMap);
                this.lBw.xY(this.forum.isBrandForum);
                this.lBw.setTime(this.gpH.getCreateTime());
                if (dataRes.first_floor_post != null) {
                    this.lBw.a(dataRes.first_floor_post, context);
                }
                if (this.gpH != null && this.gpH.isShareThread) {
                    this.lBw.h(this.gpH.eLH);
                }
                if (this.lBy == null) {
                    this.lBy = this.lBw;
                    this.lBx = true;
                }
                this.page.a(dataRes.page);
                this.anti.parserProtobuf(dataRes.anti);
                this.lAV.a(dataRes.location);
                if (dataRes.user != null) {
                    this.userIdentity = dataRes.user.is_manager.intValue();
                }
                this.userData.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.lBa.add(muteUser);
                        }
                    }
                }
                this.gpH.oD(this.gpH.boG() > 0 ? this.gpH.boG() - 1 : 0);
                List<AppData> dFe = com.baidu.tieba.recapp.r.dFg().dFe();
                if (dFe != null) {
                    dFe.clear();
                }
                this.lBg = null;
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        com.baidu.tieba.tbadkCore.data.n nVar = new com.baidu.tieba.tbadkCore.data.n();
                        nVar.d(app);
                        AppData dOV = nVar.dOV();
                        if (!this.lBf.contains(nVar) && dOV.goods != null && (!StringUtils.isNull(dOV.goods.user_name) || !StringUtils.isNull(dOV.goods.lego_card))) {
                            nVar.lQD = dnv();
                            this.lBf.add(nVar);
                            if (dFe != null) {
                                dFe.add(nVar.dOV());
                            }
                        }
                    }
                    c(dataRes);
                    d(dataRes);
                }
                com.baidu.tieba.recapp.r.dFg().dFf();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.userData.getIsSelectTail());
                }
                this.lBh.parserProtobuf(dataRes.twzhibo_anti);
                this.lAF = dataRes.appeal_info;
                if (dataRes.forum_headline_img_info != null) {
                    this.lBm = new i();
                    this.lBm.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.guess_like != null) {
                    this.lAH = new CardHListViewData();
                    this.lAH.parseProtobuf(dataRes.guess_like);
                }
                b(dataRes);
                if (y.getCount(dataRes.repost_recommend_forum_list) > 0) {
                    if (this.lBi == null) {
                        this.lBi = new ArrayList();
                    }
                    for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                        bu buVar = new bu();
                        buVar.parserProtobuf(simpleForum);
                        this.lBi.add(buVar);
                    }
                }
                if (y.getCount(dataRes.from_forum_list) > 0) {
                    if (this.lBj == null) {
                        this.lBj = new ArrayList();
                    }
                    for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                        if (simpleForum2 != null) {
                            bu buVar2 = new bu();
                            buVar2.parserProtobuf(simpleForum2);
                            this.lBj.add(buVar2);
                        }
                    }
                }
                this.lBq = dataRes.multi_forum_text;
                if (this.lBn >= 0) {
                    this.lBn = dataRes.thread_freq_num.longValue();
                }
                a(dataRes);
                if (this.lBt == null) {
                    this.lBt = new ArrayList();
                }
                this.lBt.clear();
                if (dataRes.bjh_recommend != null) {
                    int i2 = 1;
                    for (ThreadInfo threadInfo : dataRes.bjh_recommend) {
                        if (threadInfo != null && !d(threadInfo) && !e(threadInfo)) {
                            com.baidu.tbadk.core.data.o oVar = new com.baidu.tbadk.core.data.o();
                            oVar.setFloorNum(i2);
                            oVar.a(threadInfo);
                            this.lBt.add(oVar);
                            i2++;
                        }
                    }
                }
                if (this.lBv != null && this.lBv.dwW()) {
                    this.lBv = null;
                }
                if (dataRes.recom_ala_info != null && dataRes.recom_ala_info.live_status.intValue() == 1 && dataRes.recom_ala_info.pb_display_type.intValue() == 2) {
                    if (this.lBv == null) {
                        this.lBv = new com.baidu.tieba.pb.videopb.c.a();
                        this.lBv.parserProtoBuf(dataRes.recom_ala_info);
                    }
                } else if (this.lBv == null && dataRes.promotion != null) {
                    this.lBv = new com.baidu.tieba.pb.videopb.c.a();
                    this.lBv.a(dataRes.promotion);
                }
                if (dataRes.business_promot_info != null) {
                    this.lAO = dataRes.business_promot_info.is_promot.longValue() == 1;
                    this.lAP = dataRes.business_promot_info.is_headlinepost.intValue() == 1;
                    this.lAQ = dataRes.business_promot_info.is_s_card.intValue() == 1;
                    if (dataRes.business_promot_info.send_card_info != null) {
                        b bVar = new b();
                        bVar.a(dataRes.business_promot_info.send_card_info);
                        if (this.lAR == null) {
                            this.lAR = new a();
                        }
                        this.lAR.a(bVar);
                    }
                }
                this.lBC.reset();
                this.lBC.setUserMap(this.userMap);
                this.lBC.a(dataRes.recom_ala_info);
                if (this.lBC.lKq != null) {
                    this.lBC.lKq.setTid(getThreadId());
                }
                this.lBD = new ac();
                this.lBD.setUserMap(this.userMap);
                this.lBD.a(dataRes.recom_ala_info);
                if (this.lBD.lKq != null) {
                    this.lBD.lKq.setTid(getThreadId());
                }
                if (y.getCount(dataRes.recom_thread_info) > 0) {
                    this.lBG = dataRes.recom_thread_info;
                }
                this.lBE = dataRes.jumptotab1 == null ? null : dataRes.jumptotab1.toString();
                this.lBF = dataRes.jumptotab2;
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
                if (!this.lBs.contains(String.valueOf(post.id))) {
                    PostData postData = new PostData();
                    postData.setUserMap(this.userMap);
                    postData.xY(this.forum.isBrandForum);
                    postData.a(post, context);
                    postData.a(dmU().boA());
                    if (postData.bqI() != null && postData.bqI().baijiahaoData == null && dmU() != null && dmU().getBaijiahaoData() != null) {
                        postData.bqI().baijiahaoData = dmU().getBaijiahaoData();
                    }
                    this.lBs.add(postData.getId());
                    if (postData.dPh() == 1 && this.gpH.bpD()) {
                        if (dnc()) {
                            postData.setPostType(0);
                        } else {
                            postData.setPostType(this.gpH.bpC());
                        }
                    } else if (postData.dPh() == 1 && this.gpH.bpZ()) {
                        postData.setPostType(41);
                    } else if (postData.dPh() == 1 && this.gpH != null && this.gpH.bnv()) {
                        postData.setPostType(0);
                        postData.bIM();
                        if (this.gpH.boN() == null || this.gpH.boN().size() == 0) {
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
                            postData.c(new TbRichText((Context) TbadkCoreApplication.getInst(), this.gpH.boN(), true));
                        }
                        this.lBl = postData;
                    }
                    if (postData.dPh() == 1 && this.gpH != null && this.gpH.isShareThread) {
                        postData.h(this.gpH.eLH);
                    }
                    if (postData.dPh() == 1) {
                        this.lBy = postData;
                        this.lBx = false;
                    }
                    this.lAU.add(postData);
                }
            }
        }
    }

    private void a(DataRes dataRes) {
        this.lBo = new o(this.gpH, this.anti);
        this.lAI = dataRes.partial_visible_toast;
        if (dataRes.follow_tip != null && dataRes.follow_tip.is_toast_tip.intValue() == 1) {
            this.lAW = dataRes.follow_tip.tip_text;
        }
        this.lBe = new AlaLiveInfoCoreData();
        if (dataRes.ala_info != null) {
            this.lBe.parserProtoBuf(dataRes.ala_info);
        }
        this.lBp = dataRes.fold_tip;
        this.lAJ = dataRes.exp_news_today.intValue();
        this.lAK = dataRes.exp_guide_today.intValue();
        if (!y.isEmpty(dataRes.thread_topic)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= dataRes.thread_topic.size()) {
                    break;
                }
                bo.a aVar = new bo.a();
                aVar.a(dataRes.thread_topic.get(i2));
                this.lBr.add(aVar);
                i = i2 + 1;
            }
        }
        this.lAL = dataRes.pb_sort_info;
        this.lAM = dataRes.sort_type.intValue();
        if (dataRes.manager_election != null) {
            this.lAN = k.b(dataRes.manager_election);
        }
    }

    private void b(DataRes dataRes) {
        if (dataRes.feed_thread_list != null && dataRes.feed_thread_list.size() > 0) {
            List<ThreadInfo> list = dataRes.feed_thread_list;
            if (this.lBd == null) {
                this.lBd = new ArrayList();
            }
            this.lBd.clear();
            for (ThreadInfo threadInfo : list) {
                if (threadInfo != null) {
                    by byVar = new by();
                    byVar.a(threadInfo);
                    this.lBd.add(byVar);
                }
            }
            if (this.lBd != null && this.lBd.size() > 15) {
                this.lBd = y.subList(this.lBd, 0, 15);
            }
        }
    }

    private void c(DataRes dataRes) {
        List<String> AP;
        App app = dataRes.banner_list.pb_banner_ad;
        com.baidu.tieba.tbadkCore.data.n nVar = new com.baidu.tieba.tbadkCore.data.n();
        nVar.nlG = true;
        nVar.d(app);
        AppData dOV = nVar.dOV();
        if (dOV.goods != null) {
            if (y.isEmpty(dOV.goods.thread_pic_list) && (AP = AdvertAppInfo.a.AP(dOV.goods.lego_card)) != null && dOV.goods.thread_pic_list != null) {
                dOV.goods.thread_pic_list.addAll(AP);
            }
            this.lBg = nVar;
        }
    }

    private void d(DataRes dataRes) {
        List<App> list = dataRes.banner_list.video_recommend_ad;
        this.lBB.clear();
        if (list != null && !list.isEmpty()) {
            for (App app : list) {
                com.baidu.tieba.tbadkCore.data.n nVar = new com.baidu.tieba.tbadkCore.data.n();
                nVar.d(app);
                AppData dOV = nVar.dOV();
                if (!this.lBB.contains(nVar) && dOV.goods != null && (!StringUtils.isNull(dOV.goods.user_name) || !StringUtils.isNull(dOV.goods.lego_card))) {
                    nVar.lQD = dnv();
                    this.lBB.add(nVar);
                }
            }
        }
    }

    public String dnf() {
        return this.lBp;
    }

    public CardHListViewData dng() {
        return this.lAH;
    }

    public PostData dnh() {
        return this.lBl;
    }

    public PostData f(PostData postData) {
        this.lBl = postData;
        return postData;
    }

    public r dni() {
        return this.lBk;
    }

    public int dnj() {
        return this.userIdentity;
    }

    public int getIsNewUrl() {
        return this.lAX;
    }

    public void setIsNewUrl(int i) {
        this.lAX = i;
    }

    public List<MuteUser> dnk() {
        return this.lBa;
    }

    public ArrayList<com.baidu.tieba.tbadkCore.data.n> dnl() {
        return this.lBf;
    }

    public com.baidu.tieba.tbadkCore.data.n dnm() {
        return this.lBg;
    }

    public void b(com.baidu.tieba.tbadkCore.data.n nVar) {
        this.lBg = nVar;
    }

    public void dnn() {
        if (this.lBg.dOV() != null) {
            this.lBg.dOV().legoCard = null;
        }
        this.lBg = null;
    }

    public void dno() {
        this.lBC = null;
        this.lBD = null;
    }

    public String dnp() {
        return this.lAG;
    }

    public void PW(String str) {
        this.lAG = str;
    }

    public i dnq() {
        return this.lBm;
    }

    public List<bu> dnr() {
        return this.lBj;
    }

    public long dnt() {
        return this.lBn;
    }

    public o dnu() {
        return this.lBo;
    }

    public void a(o oVar) {
        this.lBo = oVar;
    }

    public boolean dnv() {
        return (dmU() == null || !dmU().bnv() || dmU().bph() == null) ? false : true;
    }

    public AlaLiveInfoCoreData dnw() {
        return this.lBe;
    }

    public List<com.baidu.tbadk.core.data.o> dnx() {
        return this.lBt;
    }

    public boolean dny() {
        return dmU() != null && dmU().bnz();
    }

    public String dnz() {
        if (this.lAL != null && this.lAL.size() > this.lAM) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.lAL.size()) {
                    break;
                } else if (this.lAL.get(i2).sort_type.intValue() != this.lAM) {
                    i = i2 + 1;
                } else {
                    return this.lAL.get(i2).sort_name;
                }
            }
        }
        return "";
    }

    public com.baidu.tieba.pb.videopb.c.a dnA() {
        return this.lBv;
    }

    public int dnB() {
        return this.lBu;
    }

    public void GP(int i) {
        this.lBu = i;
    }

    public List<com.baidu.tieba.tbadkCore.data.n> dnC() {
        return this.lBB;
    }

    private boolean d(ThreadInfo threadInfo) {
        if (threadInfo == null || getThreadId() == null || "0".equals(threadInfo.id) || "0".equals(threadInfo.tid)) {
            return false;
        }
        return getThreadId().equals(threadInfo.id) || getThreadId().equals(threadInfo.tid);
    }

    private boolean e(ThreadInfo threadInfo) {
        if (threadInfo == null || threadInfo.baijiahao == null || threadInfo.baijiahao.ori_ugc_nid == null || this.gpH == null || this.gpH.getBaijiahaoData() == null || this.gpH.getBaijiahaoData().oriUgcNid == null || "0".equals(threadInfo.baijiahao.ori_ugc_nid)) {
            return false;
        }
        return threadInfo.baijiahao.ori_ugc_nid.equals(this.gpH.getBaijiahaoData().oriUgcNid);
    }

    public List<ThreadInfo> dnD() {
        return this.lBG;
    }

    public ForumRuleStatus dnE() {
        return this.forumRule;
    }
}

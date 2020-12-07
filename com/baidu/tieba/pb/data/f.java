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
    public AppealInfo lAD;
    public String lAE;
    public CardHListViewData lAF;
    public String lAG;
    public int lAH;
    public int lAI;
    public List<PbSortType> lAJ;
    public int lAK;
    public k lAL;
    public a lAP;
    private String lAU;
    private int lAV;
    private ac lBB;
    public String lBC;
    public String lBD;
    private List<ThreadInfo> lBE;
    private List<by> lBb;
    private AlaLiveInfoCoreData lBc;
    private TwzhiboAnti lBf;
    private List<bu> lBg;
    private List<bu> lBh;
    private PostData lBj;
    private i lBk;
    private long lBl;
    private o lBm;
    private String lBn;
    private String lBo;
    private List<com.baidu.tbadk.core.data.o> lBr;
    private com.baidu.tieba.pb.videopb.c.a lBt;
    private PostData lBu;
    private PostData lBw;
    public boolean lBy;
    public boolean lAM = false;
    public boolean lAN = false;
    public boolean lAO = false;
    public boolean lAQ = false;
    private boolean lAZ = true;
    private ArrayList<com.baidu.tieba.tbadkCore.data.n> lBd = new ArrayList<>();
    private com.baidu.tieba.tbadkCore.data.n lBe = null;
    private int lBs = 0;
    public boolean lBv = true;
    public int lBx = 0;
    public int ZJ = 0;
    private List<com.baidu.tieba.tbadkCore.data.n> lBz = new ArrayList();
    private ForumData forum = new ForumData();
    private bu lAR = new bu();
    private by gpF = new by();
    private ArrayList<PostData> lAS = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private ax page = new ax();
    private AntiData anti = new AntiData();
    private com.baidu.tbadk.data.g lAT = new com.baidu.tbadk.data.g();
    private int userIdentity = 0;
    private final UserData userData = new UserData();
    private List<MuteUser> lAY = new ArrayList();
    private ba lAW = new ba();
    private bb lBa = new bb();
    private am lAX = new am();
    private r lBi = new r();
    private z lBA = new z();
    private List<bo.a> lBp = new ArrayList();
    private HashSet<String> lBq = new HashSet<>();

    public f() {
        this.lAV = 0;
        this.lBf = null;
        this.lAV = 0;
        this.lBf = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.lAS != null && this.lAS.size() > 0;
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
            int size = this.lAS.size() > 30 ? 30 : this.lAS.size();
            if (dmT() == null || dmT().boP() == null || au.isEmpty(dmT().boP().getUserId())) {
                return new String[]{null, ""};
            }
            String userId = dmT().boP().getUserId();
            PostData dnd = dnd();
            if (dnd == null || dnd.boP() == null || au.isEmpty(dnd.boP().getUserId())) {
                str2 = "";
            } else {
                if (!au.equals(userId, dnd.boP().getUserId())) {
                    str4 = null;
                } else {
                    str4 = dnd.dPn();
                }
                if (!au.isEmpty("")) {
                    str5 = str4;
                    str2 = "";
                } else {
                    str5 = str4;
                    str2 = dnd.dPl();
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
                    PostData postData = (PostData) y.getItem(this.lAS, i);
                    if (postData != null && postData.boP() != null && !au.isEmpty(postData.boP().getUserId()) && au.equals(userId, postData.boP().getUserId())) {
                        if (au.isEmpty(str5)) {
                            str5 = postData.dPn();
                        }
                        String dPl = au.isEmpty(str6) ? postData.dPl() : str6;
                        if (!au.isEmpty(str5) && !au.isEmpty(dPl)) {
                            str = dPl;
                            str3 = str5;
                            break;
                        }
                        str6 = dPl;
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
            if (this.gpF != null && this.gpF.bpR() != null && this.gpF.bpR().getGroup_id() != 0) {
                str = "[" + context.getString(R.string.photo_live_tips) + "] " + str;
            }
            str5 = (this.gpF == null || this.gpF.bph() == null || au.isEmpty(this.gpF.bph().thumbnail_url)) ? str3 : this.gpF.bph().thumbnail_url;
            if (this.gpF != null && !this.gpF.isShareThread && str5 == null && this.gpF.eLH != null && this.gpF.eLH.eHb != null) {
                ArrayList<MediaData> arrayList = this.gpF.eLH.eHb;
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

    public bu dmS() {
        return this.lAR;
    }

    public void d(bu buVar) {
        this.lAR = buVar;
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

    public by dmT() {
        return this.gpF;
    }

    public void aH(by byVar) {
        this.gpF = byVar;
    }

    public List<by> dmU() {
        return this.lBb;
    }

    public String getThreadId() {
        if (this.gpF == null) {
            return "";
        }
        return this.gpF.getId();
    }

    public ArrayList<PostData> dmV() {
        return this.lAS;
    }

    public ax getPage() {
        return this.page;
    }

    public am dmW() {
        return this.lAX;
    }

    public bb dmX() {
        return this.lBa;
    }

    public z dmY() {
        if (this.lBA == null || !this.lBA.isValid()) {
            return null;
        }
        return this.lBA;
    }

    public ac dmZ() {
        if (this.lBB == null || !this.lBB.isValid()) {
            return null;
        }
        return this.lBB;
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
        return this.gpF.boW() != 0;
    }

    public void iH(boolean z) {
        if (this.gpF != null) {
            if (z) {
                this.gpF.oH(1);
            } else {
                this.gpF.oH(0);
            }
        }
    }

    public String bkX() {
        if (this.gpF != null) {
            return this.gpF.boX();
        }
        return null;
    }

    public void PV(String str) {
        if (this.gpF != null) {
            this.gpF.Bf(str);
        }
    }

    public String dna() {
        return this.lBo;
    }

    public boolean dnb() {
        return (this.gpF == null || this.gpF.boZ() == null || this.gpF.boZ().size() <= 0 || this.gpF.boZ().get(0) == null || !this.gpF.boZ().get(0).bmC()) ? false : true;
    }

    public PostData dnc() {
        return this.lBu;
    }

    public void d(PostData postData) {
        this.lBu = postData;
        this.lBw = postData;
        this.lBv = false;
    }

    public PostData dnd() {
        return this.lBw;
    }

    public void e(PostData postData) {
        this.lBw = postData;
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                com.baidu.tieba.recapp.d.a.dFX().Sk(dataRes.asp_shown_info);
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
                this.lAR.parserProtobuf(dataRes.display_forum);
                this.gpF.setUserMap(this.userMap);
                this.gpF.a(dataRes.thread);
                this.lAW.a(dataRes.news_info);
                switch (this.lAW.elT) {
                    case 1:
                        this.lAX.lNz = this.lAW;
                        break;
                    case 2:
                        this.lAX.lNA = this.lAW;
                        break;
                    case 3:
                        this.lAX.lNB = this.lAW;
                        break;
                    default:
                        this.lAX.lNA = this.lAW;
                        break;
                }
                this.lBa.a(dataRes.recommend_book);
                b(dataRes, context);
                this.lBu = new PostData();
                this.lBu.KV(1);
                this.lBu.setUserMap(this.userMap);
                this.lBu.xY(this.forum.isBrandForum);
                this.lBu.setTime(this.gpF.getCreateTime());
                if (dataRes.first_floor_post != null) {
                    this.lBu.a(dataRes.first_floor_post, context);
                }
                if (this.gpF != null && this.gpF.isShareThread) {
                    this.lBu.h(this.gpF.eLH);
                }
                if (this.lBw == null) {
                    this.lBw = this.lBu;
                    this.lBv = true;
                }
                this.page.a(dataRes.page);
                this.anti.parserProtobuf(dataRes.anti);
                this.lAT.a(dataRes.location);
                if (dataRes.user != null) {
                    this.userIdentity = dataRes.user.is_manager.intValue();
                }
                this.userData.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.lAY.add(muteUser);
                        }
                    }
                }
                this.gpF.oD(this.gpF.boG() > 0 ? this.gpF.boG() - 1 : 0);
                List<AppData> dFd = com.baidu.tieba.recapp.r.dFf().dFd();
                if (dFd != null) {
                    dFd.clear();
                }
                this.lBe = null;
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        com.baidu.tieba.tbadkCore.data.n nVar = new com.baidu.tieba.tbadkCore.data.n();
                        nVar.d(app);
                        AppData dOU = nVar.dOU();
                        if (!this.lBd.contains(nVar) && dOU.goods != null && (!StringUtils.isNull(dOU.goods.user_name) || !StringUtils.isNull(dOU.goods.lego_card))) {
                            nVar.lQB = dnu();
                            this.lBd.add(nVar);
                            if (dFd != null) {
                                dFd.add(nVar.dOU());
                            }
                        }
                    }
                    c(dataRes);
                    d(dataRes);
                }
                com.baidu.tieba.recapp.r.dFf().dFe();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.userData.getIsSelectTail());
                }
                this.lBf.parserProtobuf(dataRes.twzhibo_anti);
                this.lAD = dataRes.appeal_info;
                if (dataRes.forum_headline_img_info != null) {
                    this.lBk = new i();
                    this.lBk.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.guess_like != null) {
                    this.lAF = new CardHListViewData();
                    this.lAF.parseProtobuf(dataRes.guess_like);
                }
                b(dataRes);
                if (y.getCount(dataRes.repost_recommend_forum_list) > 0) {
                    if (this.lBg == null) {
                        this.lBg = new ArrayList();
                    }
                    for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                        bu buVar = new bu();
                        buVar.parserProtobuf(simpleForum);
                        this.lBg.add(buVar);
                    }
                }
                if (y.getCount(dataRes.from_forum_list) > 0) {
                    if (this.lBh == null) {
                        this.lBh = new ArrayList();
                    }
                    for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                        if (simpleForum2 != null) {
                            bu buVar2 = new bu();
                            buVar2.parserProtobuf(simpleForum2);
                            this.lBh.add(buVar2);
                        }
                    }
                }
                this.lBo = dataRes.multi_forum_text;
                if (this.lBl >= 0) {
                    this.lBl = dataRes.thread_freq_num.longValue();
                }
                a(dataRes);
                if (this.lBr == null) {
                    this.lBr = new ArrayList();
                }
                this.lBr.clear();
                if (dataRes.bjh_recommend != null) {
                    int i2 = 1;
                    for (ThreadInfo threadInfo : dataRes.bjh_recommend) {
                        if (threadInfo != null && !d(threadInfo) && !e(threadInfo)) {
                            com.baidu.tbadk.core.data.o oVar = new com.baidu.tbadk.core.data.o();
                            oVar.setFloorNum(i2);
                            oVar.a(threadInfo);
                            this.lBr.add(oVar);
                            i2++;
                        }
                    }
                }
                if (this.lBt != null && this.lBt.dwV()) {
                    this.lBt = null;
                }
                if (dataRes.recom_ala_info != null && dataRes.recom_ala_info.live_status.intValue() == 1 && dataRes.recom_ala_info.pb_display_type.intValue() == 2) {
                    if (this.lBt == null) {
                        this.lBt = new com.baidu.tieba.pb.videopb.c.a();
                        this.lBt.parserProtoBuf(dataRes.recom_ala_info);
                    }
                } else if (this.lBt == null && dataRes.promotion != null) {
                    this.lBt = new com.baidu.tieba.pb.videopb.c.a();
                    this.lBt.a(dataRes.promotion);
                }
                if (dataRes.business_promot_info != null) {
                    this.lAM = dataRes.business_promot_info.is_promot.longValue() == 1;
                    this.lAN = dataRes.business_promot_info.is_headlinepost.intValue() == 1;
                    this.lAO = dataRes.business_promot_info.is_s_card.intValue() == 1;
                    if (dataRes.business_promot_info.send_card_info != null) {
                        b bVar = new b();
                        bVar.a(dataRes.business_promot_info.send_card_info);
                        if (this.lAP == null) {
                            this.lAP = new a();
                        }
                        this.lAP.a(bVar);
                    }
                }
                this.lBA.reset();
                this.lBA.setUserMap(this.userMap);
                this.lBA.a(dataRes.recom_ala_info);
                if (this.lBA.lKo != null) {
                    this.lBA.lKo.setTid(getThreadId());
                }
                this.lBB = new ac();
                this.lBB.setUserMap(this.userMap);
                this.lBB.a(dataRes.recom_ala_info);
                if (this.lBB.lKo != null) {
                    this.lBB.lKo.setTid(getThreadId());
                }
                if (y.getCount(dataRes.recom_thread_info) > 0) {
                    this.lBE = dataRes.recom_thread_info;
                }
                this.lBC = dataRes.jumptotab1 == null ? null : dataRes.jumptotab1.toString();
                this.lBD = dataRes.jumptotab2;
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
                if (!this.lBq.contains(String.valueOf(post.id))) {
                    PostData postData = new PostData();
                    postData.setUserMap(this.userMap);
                    postData.xY(this.forum.isBrandForum);
                    postData.a(post, context);
                    postData.a(dmT().boA());
                    if (postData.bqI() != null && postData.bqI().baijiahaoData == null && dmT() != null && dmT().getBaijiahaoData() != null) {
                        postData.bqI().baijiahaoData = dmT().getBaijiahaoData();
                    }
                    this.lBq.add(postData.getId());
                    if (postData.dPg() == 1 && this.gpF.bpD()) {
                        if (dnb()) {
                            postData.setPostType(0);
                        } else {
                            postData.setPostType(this.gpF.bpC());
                        }
                    } else if (postData.dPg() == 1 && this.gpF.bpZ()) {
                        postData.setPostType(41);
                    } else if (postData.dPg() == 1 && this.gpF != null && this.gpF.bnv()) {
                        postData.setPostType(0);
                        postData.bIM();
                        if (this.gpF.boN() == null || this.gpF.boN().size() == 0) {
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
                            postData.c(new TbRichText((Context) TbadkCoreApplication.getInst(), this.gpF.boN(), true));
                        }
                        this.lBj = postData;
                    }
                    if (postData.dPg() == 1 && this.gpF != null && this.gpF.isShareThread) {
                        postData.h(this.gpF.eLH);
                    }
                    if (postData.dPg() == 1) {
                        this.lBw = postData;
                        this.lBv = false;
                    }
                    this.lAS.add(postData);
                }
            }
        }
    }

    private void a(DataRes dataRes) {
        this.lBm = new o(this.gpF, this.anti);
        this.lAG = dataRes.partial_visible_toast;
        if (dataRes.follow_tip != null && dataRes.follow_tip.is_toast_tip.intValue() == 1) {
            this.lAU = dataRes.follow_tip.tip_text;
        }
        this.lBc = new AlaLiveInfoCoreData();
        if (dataRes.ala_info != null) {
            this.lBc.parserProtoBuf(dataRes.ala_info);
        }
        this.lBn = dataRes.fold_tip;
        this.lAH = dataRes.exp_news_today.intValue();
        this.lAI = dataRes.exp_guide_today.intValue();
        if (!y.isEmpty(dataRes.thread_topic)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= dataRes.thread_topic.size()) {
                    break;
                }
                bo.a aVar = new bo.a();
                aVar.a(dataRes.thread_topic.get(i2));
                this.lBp.add(aVar);
                i = i2 + 1;
            }
        }
        this.lAJ = dataRes.pb_sort_info;
        this.lAK = dataRes.sort_type.intValue();
        if (dataRes.manager_election != null) {
            this.lAL = k.b(dataRes.manager_election);
        }
    }

    private void b(DataRes dataRes) {
        if (dataRes.feed_thread_list != null && dataRes.feed_thread_list.size() > 0) {
            List<ThreadInfo> list = dataRes.feed_thread_list;
            if (this.lBb == null) {
                this.lBb = new ArrayList();
            }
            this.lBb.clear();
            for (ThreadInfo threadInfo : list) {
                if (threadInfo != null) {
                    by byVar = new by();
                    byVar.a(threadInfo);
                    this.lBb.add(byVar);
                }
            }
            if (this.lBb != null && this.lBb.size() > 15) {
                this.lBb = y.subList(this.lBb, 0, 15);
            }
        }
    }

    private void c(DataRes dataRes) {
        List<String> AP;
        App app = dataRes.banner_list.pb_banner_ad;
        com.baidu.tieba.tbadkCore.data.n nVar = new com.baidu.tieba.tbadkCore.data.n();
        nVar.nlE = true;
        nVar.d(app);
        AppData dOU = nVar.dOU();
        if (dOU.goods != null) {
            if (y.isEmpty(dOU.goods.thread_pic_list) && (AP = AdvertAppInfo.a.AP(dOU.goods.lego_card)) != null && dOU.goods.thread_pic_list != null) {
                dOU.goods.thread_pic_list.addAll(AP);
            }
            this.lBe = nVar;
        }
    }

    private void d(DataRes dataRes) {
        List<App> list = dataRes.banner_list.video_recommend_ad;
        this.lBz.clear();
        if (list != null && !list.isEmpty()) {
            for (App app : list) {
                com.baidu.tieba.tbadkCore.data.n nVar = new com.baidu.tieba.tbadkCore.data.n();
                nVar.d(app);
                AppData dOU = nVar.dOU();
                if (!this.lBz.contains(nVar) && dOU.goods != null && (!StringUtils.isNull(dOU.goods.user_name) || !StringUtils.isNull(dOU.goods.lego_card))) {
                    nVar.lQB = dnu();
                    this.lBz.add(nVar);
                }
            }
        }
    }

    public String dne() {
        return this.lBn;
    }

    public CardHListViewData dnf() {
        return this.lAF;
    }

    public PostData dng() {
        return this.lBj;
    }

    public PostData f(PostData postData) {
        this.lBj = postData;
        return postData;
    }

    public r dnh() {
        return this.lBi;
    }

    public int dni() {
        return this.userIdentity;
    }

    public int getIsNewUrl() {
        return this.lAV;
    }

    public void setIsNewUrl(int i) {
        this.lAV = i;
    }

    public List<MuteUser> dnj() {
        return this.lAY;
    }

    public ArrayList<com.baidu.tieba.tbadkCore.data.n> dnk() {
        return this.lBd;
    }

    public com.baidu.tieba.tbadkCore.data.n dnl() {
        return this.lBe;
    }

    public void b(com.baidu.tieba.tbadkCore.data.n nVar) {
        this.lBe = nVar;
    }

    public void dnm() {
        if (this.lBe.dOU() != null) {
            this.lBe.dOU().legoCard = null;
        }
        this.lBe = null;
    }

    public void dnn() {
        this.lBA = null;
        this.lBB = null;
    }

    public String dno() {
        return this.lAE;
    }

    public void PW(String str) {
        this.lAE = str;
    }

    public i dnp() {
        return this.lBk;
    }

    public List<bu> dnq() {
        return this.lBh;
    }

    public long dnr() {
        return this.lBl;
    }

    public o dnt() {
        return this.lBm;
    }

    public void a(o oVar) {
        this.lBm = oVar;
    }

    public boolean dnu() {
        return (dmT() == null || !dmT().bnv() || dmT().bph() == null) ? false : true;
    }

    public AlaLiveInfoCoreData dnv() {
        return this.lBc;
    }

    public List<com.baidu.tbadk.core.data.o> dnw() {
        return this.lBr;
    }

    public boolean dnx() {
        return dmT() != null && dmT().bnz();
    }

    public String dny() {
        if (this.lAJ != null && this.lAJ.size() > this.lAK) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.lAJ.size()) {
                    break;
                } else if (this.lAJ.get(i2).sort_type.intValue() != this.lAK) {
                    i = i2 + 1;
                } else {
                    return this.lAJ.get(i2).sort_name;
                }
            }
        }
        return "";
    }

    public com.baidu.tieba.pb.videopb.c.a dnz() {
        return this.lBt;
    }

    public int dnA() {
        return this.lBs;
    }

    public void GP(int i) {
        this.lBs = i;
    }

    public List<com.baidu.tieba.tbadkCore.data.n> dnB() {
        return this.lBz;
    }

    private boolean d(ThreadInfo threadInfo) {
        if (threadInfo == null || getThreadId() == null || "0".equals(threadInfo.id) || "0".equals(threadInfo.tid)) {
            return false;
        }
        return getThreadId().equals(threadInfo.id) || getThreadId().equals(threadInfo.tid);
    }

    private boolean e(ThreadInfo threadInfo) {
        if (threadInfo == null || threadInfo.baijiahao == null || threadInfo.baijiahao.ori_ugc_nid == null || this.gpF == null || this.gpF.getBaijiahaoData() == null || this.gpF.getBaijiahaoData().oriUgcNid == null || "0".equals(threadInfo.baijiahao.ori_ugc_nid)) {
            return false;
        }
        return threadInfo.baijiahao.ori_ugc_nid.equals(this.gpF.getBaijiahaoData().oriUgcNid);
    }

    public List<ThreadInfo> dnC() {
        return this.lBE;
    }

    public ForumRuleStatus dnD() {
        return this.forumRule;
    }
}

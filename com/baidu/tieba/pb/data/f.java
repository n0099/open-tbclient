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
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.data.ay;
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.data.bs;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.at;
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
    public k kUA;
    public a kUE;
    private String kUJ;
    private int kUK;
    private List<bw> kUQ;
    private AlaLiveInfoCoreData kUR;
    private TwzhiboAnti kUU;
    private List<bs> kUV;
    private List<bs> kUW;
    private PostData kUY;
    private i kUZ;
    public AppealInfo kUs;
    public String kUt;
    public CardHListViewData kUu;
    public String kUv;
    public int kUw;
    public int kUx;
    public List<PbSortType> kUy;
    public int kUz;
    private long kVa;
    private o kVb;
    private String kVc;
    private String kVd;
    private List<com.baidu.tbadk.core.data.n> kVg;
    private com.baidu.tieba.pb.videopb.c.a kVi;
    private PostData kVj;
    private PostData kVl;
    public boolean kVn;
    private ac kVq;
    public String kVr;
    public String kVs;
    public boolean kUB = false;
    public boolean kUC = false;
    public boolean kUD = false;
    public boolean kUF = false;
    private boolean kUO = true;
    private ArrayList<com.baidu.tieba.tbadkCore.data.n> kUS = new ArrayList<>();
    private com.baidu.tieba.tbadkCore.data.n kUT = null;
    private int kVh = 0;
    public boolean kVk = true;
    public int kVm = 0;
    public int YG = 0;
    private List<com.baidu.tieba.tbadkCore.data.n> kVo = new ArrayList();
    private ForumData forum = new ForumData();
    private bs kUG = new bs();
    private bw fRW = new bw();
    private ArrayList<PostData> kUH = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private av page = new av();
    private AntiData anti = new AntiData();
    private com.baidu.tbadk.data.f kUI = new com.baidu.tbadk.data.f();
    private int userIdentity = 0;
    private final UserData userData = new UserData();
    private List<MuteUser> kUN = new ArrayList();
    private ay kUL = new ay();
    private az kUP = new az();
    private am kUM = new am();
    private r kUX = new r();
    private z kVp = new z();
    private List<bm.a> kVe = new ArrayList();
    private HashSet<String> kVf = new HashSet<>();

    public f() {
        this.kUK = 0;
        this.kUU = null;
        this.kUK = 0;
        this.kUU = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.kUH != null && this.kUH.size() > 0;
    }

    public String[] fI(Context context) {
        return r(context, true);
    }

    public String[] r(Context context, boolean z) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5 = null;
        if (!isValid()) {
            str = "";
        } else {
            int size = this.kUH.size() > 30 ? 30 : this.kUH.size();
            if (dcA() == null || dcA().bih() == null || at.isEmpty(dcA().bih().getUserId())) {
                return new String[]{null, ""};
            }
            String userId = dcA().bih().getUserId();
            PostData dcK = dcK();
            if (dcK == null || dcK.bih() == null || at.isEmpty(dcK.bih().getUserId())) {
                str2 = "";
            } else {
                if (!at.equals(userId, dcK.bih().getUserId())) {
                    str4 = null;
                } else {
                    str4 = dcK.dEw();
                }
                if (!at.isEmpty("")) {
                    str5 = str4;
                    str2 = "";
                } else {
                    str5 = str4;
                    str2 = dcK.dEu();
                }
            }
            if (at.isEmpty(str2) && at.isEmpty(str5)) {
                int i = 0;
                String str6 = str2;
                while (true) {
                    if (i >= size) {
                        str = str6;
                        str3 = str5;
                        break;
                    }
                    PostData postData = (PostData) y.getItem(this.kUH, i);
                    if (postData != null && postData.bih() != null && !at.isEmpty(postData.bih().getUserId()) && at.equals(userId, postData.bih().getUserId())) {
                        if (at.isEmpty(str5)) {
                            str5 = postData.dEw();
                        }
                        String dEu = at.isEmpty(str6) ? postData.dEu() : str6;
                        if (!at.isEmpty(str5) && !at.isEmpty(dEu)) {
                            str = dEu;
                            str3 = str5;
                            break;
                        }
                        str6 = dEu;
                    }
                    i++;
                }
            } else {
                str = str2;
                str3 = str5;
            }
            if (z && at.isEmpty(str3)) {
                str3 = "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            }
            if (this.fRW != null && this.fRW.bjh() != null && this.fRW.bjh().getGroup_id() != 0) {
                str = "[" + context.getString(R.string.photo_live_tips) + "] " + str;
            }
            str5 = (this.fRW == null || this.fRW.biz() == null || at.isEmpty(this.fRW.biz().thumbnail_url)) ? str3 : this.fRW.biz().thumbnail_url;
            if (this.fRW != null && !this.fRW.isShareThread && str5 == null && this.fRW.erY != null && this.fRW.erY.ent != null) {
                ArrayList<MediaData> arrayList = this.fRW.erY.ent;
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

    public bs dcz() {
        return this.kUG;
    }

    public void d(bs bsVar) {
        this.kUG = bsVar;
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

    public bw dcA() {
        return this.fRW;
    }

    public void aF(bw bwVar) {
        this.fRW = bwVar;
    }

    public List<bw> dcB() {
        return this.kUQ;
    }

    public String getThreadId() {
        if (this.fRW == null) {
            return "";
        }
        return this.fRW.getId();
    }

    public ArrayList<PostData> dcC() {
        return this.kUH;
    }

    public av getPage() {
        return this.page;
    }

    public am dcD() {
        return this.kUM;
    }

    public az dcE() {
        return this.kUP;
    }

    public z dcF() {
        if (this.kVp == null || !this.kVp.isValid()) {
            return null;
        }
        return this.kVp;
    }

    public ac dcG() {
        if (this.kVq == null || !this.kVq.isValid()) {
            return null;
        }
        return this.kVq;
    }

    public void a(av avVar, int i) {
        this.page.nF(avVar.bgV());
        this.page.nD(avVar.bfW());
        this.page.nC(avVar.bgS());
        this.page.nG(avVar.bgW());
        this.page.nE(avVar.bgU());
        if (i == 0) {
            this.page = avVar;
        } else if (i == 1) {
            this.page.nH(avVar.bgX());
        } else if (i == 2) {
            this.page.nI(avVar.bgY());
        }
    }

    public AntiData getAnti() {
        return this.anti;
    }

    public UserData getUserData() {
        return this.userData;
    }

    public boolean bec() {
        return this.fRW.bio() != 0;
    }

    public void hU(boolean z) {
        if (this.fRW != null) {
            if (z) {
                this.fRW.nS(1);
            } else {
                this.fRW.nS(0);
            }
        }
    }

    public String beb() {
        if (this.fRW != null) {
            return this.fRW.bip();
        }
        return null;
    }

    public void OC(String str) {
        if (this.fRW != null) {
            this.fRW.Aw(str);
        }
    }

    public String dcH() {
        return this.kVd;
    }

    public boolean dcI() {
        return (this.fRW == null || this.fRW.bir() == null || this.fRW.bir().size() <= 0 || this.fRW.bir().get(0) == null || !this.fRW.bir().get(0).bfX()) ? false : true;
    }

    public PostData dcJ() {
        return this.kVj;
    }

    public void d(PostData postData) {
        this.kVj = postData;
        this.kVl = postData;
        this.kVk = false;
    }

    public PostData dcK() {
        return this.kVl;
    }

    public void e(PostData postData) {
        this.kVl = postData;
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                com.baidu.tieba.recapp.d.a.dvt().QO(dataRes.asp_shown_info);
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
                this.kUG.parserProtobuf(dataRes.display_forum);
                this.fRW.setUserMap(this.userMap);
                this.fRW.a(dataRes.thread);
                this.kUL.a(dataRes.news_info);
                switch (this.kUL.dSm) {
                    case 1:
                        this.kUM.lgU = this.kUL;
                        break;
                    case 2:
                        this.kUM.lgV = this.kUL;
                        break;
                    case 3:
                        this.kUM.lgW = this.kUL;
                        break;
                    default:
                        this.kUM.lgV = this.kUL;
                        break;
                }
                this.kUP.a(dataRes.recommend_book);
                b(dataRes, context);
                this.kVj = new PostData();
                this.kVj.IY(1);
                this.kVj.setUserMap(this.userMap);
                this.kVj.wQ(this.forum.isBrandForum);
                this.kVj.setTime(this.fRW.getCreateTime());
                if (dataRes.first_floor_post != null) {
                    this.kVj.a(dataRes.first_floor_post, context);
                }
                if (this.fRW != null && this.fRW.isShareThread) {
                    this.kVj.h(this.fRW.erY);
                }
                if (this.kVl == null) {
                    this.kVl = this.kVj;
                    this.kVk = true;
                }
                this.page.a(dataRes.page);
                this.anti.parserProtobuf(dataRes.anti);
                this.kUI.a(dataRes.location);
                if (dataRes.user != null) {
                    this.userIdentity = dataRes.user.is_manager.intValue();
                }
                this.userData.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.kUN.add(muteUser);
                        }
                    }
                }
                this.fRW.nO(this.fRW.bhY() > 0 ? this.fRW.bhY() - 1 : 0);
                List<AppData> duD = com.baidu.tieba.recapp.r.duF().duD();
                if (duD != null) {
                    duD.clear();
                }
                this.kUT = null;
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        com.baidu.tieba.tbadkCore.data.n nVar = new com.baidu.tieba.tbadkCore.data.n();
                        nVar.d(app);
                        AppData dEd = nVar.dEd();
                        if (!this.kUS.contains(nVar) && dEd.goods != null && (!StringUtils.isNull(dEd.goods.user_name) || !StringUtils.isNull(dEd.goods.lego_card))) {
                            nVar.ljW = dda();
                            this.kUS.add(nVar);
                            if (duD != null) {
                                duD.add(nVar.dEd());
                            }
                        }
                    }
                    c(dataRes);
                    d(dataRes);
                }
                com.baidu.tieba.recapp.r.duF().duE();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.userData.getIsSelectTail());
                }
                this.kUU.parserProtobuf(dataRes.twzhibo_anti);
                this.kUs = dataRes.appeal_info;
                if (dataRes.forum_headline_img_info != null) {
                    this.kUZ = new i();
                    this.kUZ.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.guess_like != null) {
                    this.kUu = new CardHListViewData();
                    this.kUu.parseProtobuf(dataRes.guess_like);
                }
                b(dataRes);
                if (y.getCount(dataRes.repost_recommend_forum_list) > 0) {
                    if (this.kUV == null) {
                        this.kUV = new ArrayList();
                    }
                    for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                        bs bsVar = new bs();
                        bsVar.parserProtobuf(simpleForum);
                        this.kUV.add(bsVar);
                    }
                }
                if (y.getCount(dataRes.from_forum_list) > 0) {
                    if (this.kUW == null) {
                        this.kUW = new ArrayList();
                    }
                    for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                        if (simpleForum2 != null) {
                            bs bsVar2 = new bs();
                            bsVar2.parserProtobuf(simpleForum2);
                            this.kUW.add(bsVar2);
                        }
                    }
                }
                this.kVd = dataRes.multi_forum_text;
                if (this.kVa >= 0) {
                    this.kVa = dataRes.thread_freq_num.longValue();
                }
                a(dataRes);
                if (this.kVg == null) {
                    this.kVg = new ArrayList();
                }
                this.kVg.clear();
                if (dataRes.bjh_recommend != null) {
                    int i2 = 1;
                    for (ThreadInfo threadInfo : dataRes.bjh_recommend) {
                        if (threadInfo != null && !d(threadInfo) && !e(threadInfo)) {
                            com.baidu.tbadk.core.data.n nVar2 = new com.baidu.tbadk.core.data.n();
                            nVar2.setFloorNum(i2);
                            nVar2.a(threadInfo);
                            this.kVg.add(nVar2);
                            i2++;
                        }
                    }
                }
                if (this.kVi != null && this.kVi.dms()) {
                    this.kVi = null;
                }
                if (dataRes.recom_ala_info != null && dataRes.recom_ala_info.live_status.intValue() == 1 && dataRes.recom_ala_info.pb_display_type.intValue() == 2) {
                    if (this.kVi == null) {
                        this.kVi = new com.baidu.tieba.pb.videopb.c.a();
                        this.kVi.parserProtoBuf(dataRes.recom_ala_info);
                    }
                } else if (this.kVi == null && dataRes.promotion != null) {
                    this.kVi = new com.baidu.tieba.pb.videopb.c.a();
                    this.kVi.a(dataRes.promotion);
                }
                if (dataRes.business_promot_info != null) {
                    this.kUB = dataRes.business_promot_info.is_promot.longValue() == 1;
                    this.kUC = dataRes.business_promot_info.is_headlinepost.intValue() == 1;
                    this.kUD = dataRes.business_promot_info.is_s_card.intValue() == 1;
                    if (dataRes.business_promot_info.send_card_info != null) {
                        b bVar = new b();
                        bVar.a(dataRes.business_promot_info.send_card_info);
                        if (this.kUE == null) {
                            this.kUE = new a();
                        }
                        this.kUE.a(bVar);
                    }
                }
                this.kVp.reset();
                this.kVp.setUserMap(this.userMap);
                this.kVp.a(dataRes.recom_ala_info);
                if (this.kVp.ldL != null) {
                    this.kVp.ldL.setTid(getThreadId());
                }
                this.kVq = new ac();
                this.kVq.setUserMap(this.userMap);
                this.kVq.a(dataRes.recom_ala_info);
                if (this.kVq.ldL != null) {
                    this.kVq.ldL.setTid(getThreadId());
                }
                this.kVr = dataRes.jumptotab1 == null ? null : dataRes.jumptotab1.toString();
                this.kVs = dataRes.jumptotab2;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    private void b(DataRes dataRes, Context context) {
        List<Post> list = dataRes.post_list;
        if (list != null && list.size() > 0) {
            for (Post post : dataRes.post_list) {
                if (!this.kVf.contains(String.valueOf(post.id))) {
                    PostData postData = new PostData();
                    postData.setUserMap(this.userMap);
                    postData.wQ(this.forum.isBrandForum);
                    postData.a(post, context);
                    postData.a(dcA().bhS());
                    if (postData.bjY() != null && postData.bjY().baijiahaoData == null && dcA() != null && dcA().getBaijiahaoData() != null) {
                        postData.bjY().baijiahaoData = dcA().getBaijiahaoData();
                    }
                    this.kVf.add(postData.getId());
                    if (postData.dEp() == 1 && this.fRW.biV()) {
                        if (dcI()) {
                            postData.setPostType(0);
                        } else {
                            postData.setPostType(this.fRW.biU());
                        }
                    } else if (postData.dEp() == 1 && this.fRW.bjp()) {
                        postData.setPostType(41);
                    } else if (postData.dEp() == 1 && this.fRW != null && this.fRW.bgN()) {
                        postData.setPostType(0);
                        postData.bBA();
                        if (this.fRW.bif() == null || this.fRW.bif().size() == 0) {
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
                            postData.c(new TbRichText((Context) TbadkCoreApplication.getInst(), this.fRW.bif(), true));
                        }
                        this.kUY = postData;
                    }
                    if (postData.dEp() == 1 && this.fRW != null && this.fRW.isShareThread) {
                        postData.h(this.fRW.erY);
                    }
                    if (postData.dEp() == 1) {
                        this.kVl = postData;
                        this.kVk = false;
                    }
                    this.kUH.add(postData);
                }
            }
        }
    }

    private void a(DataRes dataRes) {
        this.kVb = new o(this.fRW, this.anti);
        this.kUv = dataRes.partial_visible_toast;
        if (dataRes.follow_tip != null && dataRes.follow_tip.is_toast_tip.intValue() == 1) {
            this.kUJ = dataRes.follow_tip.tip_text;
        }
        this.kUR = new AlaLiveInfoCoreData();
        if (dataRes.ala_info != null) {
            this.kUR.parserProtoBuf(dataRes.ala_info);
        }
        this.kVc = dataRes.fold_tip;
        this.kUw = dataRes.exp_news_today.intValue();
        this.kUx = dataRes.exp_guide_today.intValue();
        if (!y.isEmpty(dataRes.thread_topic)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= dataRes.thread_topic.size()) {
                    break;
                }
                bm.a aVar = new bm.a();
                aVar.a(dataRes.thread_topic.get(i2));
                this.kVe.add(aVar);
                i = i2 + 1;
            }
        }
        this.kUy = dataRes.pb_sort_info;
        this.kUz = dataRes.sort_type.intValue();
        if (dataRes.manager_election != null) {
            this.kUA = k.b(dataRes.manager_election);
        }
    }

    private void b(DataRes dataRes) {
        if (dataRes.feed_thread_list != null && dataRes.feed_thread_list.size() > 0) {
            List<ThreadInfo> list = dataRes.feed_thread_list;
            if (this.kUQ == null) {
                this.kUQ = new ArrayList();
            }
            this.kUQ.clear();
            for (ThreadInfo threadInfo : list) {
                if (threadInfo != null) {
                    bw bwVar = new bw();
                    bwVar.a(threadInfo);
                    this.kUQ.add(bwVar);
                }
            }
            if (this.kUQ != null && this.kUQ.size() > 15) {
                this.kUQ = y.subList(this.kUQ, 0, 15);
            }
        }
    }

    private void c(DataRes dataRes) {
        List<String> Ag;
        App app = dataRes.banner_list.pb_banner_ad;
        com.baidu.tieba.tbadkCore.data.n nVar = new com.baidu.tieba.tbadkCore.data.n();
        nVar.mEe = true;
        nVar.d(app);
        AppData dEd = nVar.dEd();
        if (dEd.goods != null) {
            if (y.isEmpty(dEd.goods.thread_pic_list) && (Ag = AdvertAppInfo.a.Ag(dEd.goods.lego_card)) != null && dEd.goods.thread_pic_list != null) {
                dEd.goods.thread_pic_list.addAll(Ag);
            }
            this.kUT = nVar;
        }
    }

    private void d(DataRes dataRes) {
        List<App> list = dataRes.banner_list.video_recommend_ad;
        this.kVo.clear();
        if (list != null && !list.isEmpty()) {
            for (App app : list) {
                com.baidu.tieba.tbadkCore.data.n nVar = new com.baidu.tieba.tbadkCore.data.n();
                nVar.d(app);
                AppData dEd = nVar.dEd();
                if (!this.kVo.contains(nVar) && dEd.goods != null && (!StringUtils.isNull(dEd.goods.user_name) || !StringUtils.isNull(dEd.goods.lego_card))) {
                    nVar.ljW = dda();
                    this.kVo.add(nVar);
                }
            }
        }
    }

    public String dcL() {
        return this.kVc;
    }

    public CardHListViewData dcM() {
        return this.kUu;
    }

    public PostData dcN() {
        return this.kUY;
    }

    public PostData f(PostData postData) {
        this.kUY = postData;
        return postData;
    }

    public r dcO() {
        return this.kUX;
    }

    public int dcP() {
        return this.userIdentity;
    }

    public int getIsNewUrl() {
        return this.kUK;
    }

    public void setIsNewUrl(int i) {
        this.kUK = i;
    }

    public List<MuteUser> dcQ() {
        return this.kUN;
    }

    public ArrayList<com.baidu.tieba.tbadkCore.data.n> dcR() {
        return this.kUS;
    }

    public com.baidu.tieba.tbadkCore.data.n dcS() {
        return this.kUT;
    }

    public void b(com.baidu.tieba.tbadkCore.data.n nVar) {
        this.kUT = nVar;
    }

    public void dcT() {
        if (this.kUT.dEd() != null) {
            this.kUT.dEd().legoCard = null;
        }
        this.kUT = null;
    }

    public void dcU() {
        this.kVp = null;
        this.kVq = null;
    }

    public String dcV() {
        return this.kUt;
    }

    public void OD(String str) {
        this.kUt = str;
    }

    public i dcW() {
        return this.kUZ;
    }

    public List<bs> dcX() {
        return this.kUW;
    }

    public long dcY() {
        return this.kVa;
    }

    public o dcZ() {
        return this.kVb;
    }

    public void a(o oVar) {
        this.kVb = oVar;
    }

    public boolean dda() {
        return (dcA() == null || !dcA().bgN() || dcA().biz() == null) ? false : true;
    }

    public AlaLiveInfoCoreData ddb() {
        return this.kUR;
    }

    public List<com.baidu.tbadk.core.data.n> ddc() {
        return this.kVg;
    }

    public boolean ddd() {
        return dcA() != null && dcA().bgR();
    }

    public String dde() {
        if (this.kUy != null && this.kUy.size() > this.kUz) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.kUy.size()) {
                    break;
                } else if (this.kUy.get(i2).sort_type.intValue() != this.kUz) {
                    i = i2 + 1;
                } else {
                    return this.kUy.get(i2).sort_name;
                }
            }
        }
        return "";
    }

    public com.baidu.tieba.pb.videopb.c.a ddf() {
        return this.kVi;
    }

    public int ddg() {
        return this.kVh;
    }

    public void EW(int i) {
        this.kVh = i;
    }

    public List<com.baidu.tieba.tbadkCore.data.n> ddh() {
        return this.kVo;
    }

    private boolean d(ThreadInfo threadInfo) {
        if (threadInfo == null || getThreadId() == null || "0".equals(threadInfo.id) || "0".equals(threadInfo.tid)) {
            return false;
        }
        return getThreadId().equals(threadInfo.id) || getThreadId().equals(threadInfo.tid);
    }

    private boolean e(ThreadInfo threadInfo) {
        if (threadInfo == null || threadInfo.baijiahao == null || threadInfo.baijiahao.ori_ugc_nid == null || this.fRW == null || this.fRW.getBaijiahaoData() == null || this.fRW.getBaijiahaoData().oriUgcNid == null || "0".equals(threadInfo.baijiahao.ori_ugc_nid)) {
            return false;
        }
        return threadInfo.baijiahao.ori_ugc_nid.equals(this.fRW.getBaijiahaoData().oriUgcNid);
    }
}

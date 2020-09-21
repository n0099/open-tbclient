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
/* loaded from: classes21.dex */
public class f {
    private List<bw> kFF;
    private AlaLiveInfoCoreData kFG;
    private TwzhiboAnti kFJ;
    private List<bs> kFK;
    private List<bs> kFL;
    private PostData kFN;
    private i kFO;
    private long kFP;
    private o kFQ;
    private String kFR;
    private String kFS;
    private List<com.baidu.tbadk.core.data.n> kFV;
    private com.baidu.tieba.pb.videopb.c.a kFX;
    private PostData kFY;
    public AppealInfo kFh;
    public String kFi;
    public CardHListViewData kFj;
    public String kFk;
    public int kFl;
    public int kFm;
    public List<PbSortType> kFn;
    public int kFo;
    public k kFp;
    public a kFt;
    private String kFy;
    private int kFz;
    private PostData kGa;
    public boolean kGc;
    private ac kGf;
    public String kGg;
    public String kGh;
    public boolean kFq = false;
    public boolean kFr = false;
    public boolean kFs = false;
    public boolean kFu = false;
    private boolean kFD = true;
    private ArrayList<com.baidu.tieba.tbadkCore.data.n> kFH = new ArrayList<>();
    private com.baidu.tieba.tbadkCore.data.n kFI = null;
    private int kFW = 0;
    public boolean kFZ = true;
    public int kGb = 0;
    public int Yq = 0;
    private List<com.baidu.tieba.tbadkCore.data.n> kGd = new ArrayList();
    private ForumData forum = new ForumData();
    private bs kFv = new bs();
    private bw fFN = new bw();
    private ArrayList<PostData> kFw = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private av page = new av();
    private AntiData anti = new AntiData();
    private com.baidu.tbadk.data.f kFx = new com.baidu.tbadk.data.f();
    private int userIdentity = 0;
    private final UserData userData = new UserData();
    private List<MuteUser> kFC = new ArrayList();
    private ay kFA = new ay();
    private az kFE = new az();
    private am kFB = new am();
    private r kFM = new r();
    private z kGe = new z();
    private List<bm.a> kFT = new ArrayList();
    private HashSet<String> kFU = new HashSet<>();

    public f() {
        this.kFz = 0;
        this.kFJ = null;
        this.kFz = 0;
        this.kFJ = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.kFw != null && this.kFw.size() > 0;
    }

    public String[] fB(Context context) {
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
            int size = this.kFw.size() > 30 ? 30 : this.kFw.size();
            if (cYR() == null || cYR().bfy() == null || at.isEmpty(cYR().bfy().getUserId())) {
                return new String[]{null, ""};
            }
            String userId = cYR().bfy().getUserId();
            PostData cZb = cZb();
            if (cZb == null || cZb.bfy() == null || at.isEmpty(cZb.bfy().getUserId())) {
                str2 = "";
            } else {
                if (!at.equals(userId, cZb.bfy().getUserId())) {
                    str4 = null;
                } else {
                    str4 = cZb.dAK();
                }
                if (!at.isEmpty("")) {
                    str5 = str4;
                    str2 = "";
                } else {
                    str5 = str4;
                    str2 = cZb.dAI();
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
                    PostData postData = (PostData) y.getItem(this.kFw, i);
                    if (postData != null && postData.bfy() != null && !at.isEmpty(postData.bfy().getUserId()) && at.equals(userId, postData.bfy().getUserId())) {
                        if (at.isEmpty(str5)) {
                            str5 = postData.dAK();
                        }
                        String dAI = at.isEmpty(str6) ? postData.dAI() : str6;
                        if (!at.isEmpty(str5) && !at.isEmpty(dAI)) {
                            str = dAI;
                            str3 = str5;
                            break;
                        }
                        str6 = dAI;
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
            if (this.fFN != null && this.fFN.bgy() != null && this.fFN.bgy().getGroup_id() != 0) {
                str = "[" + context.getString(R.string.photo_live_tips) + "] " + str;
            }
            str5 = (this.fFN == null || this.fFN.bfQ() == null || at.isEmpty(this.fFN.bfQ().thumbnail_url)) ? str3 : this.fFN.bfQ().thumbnail_url;
            if (this.fFN != null && !this.fFN.isShareThread && str5 == null && this.fFN.efS != null && this.fFN.efS.ebq != null) {
                ArrayList<MediaData> arrayList = this.fFN.efS.ebq;
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

    public bs cYQ() {
        return this.kFv;
    }

    public void d(bs bsVar) {
        this.kFv = bsVar;
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

    public bw cYR() {
        return this.fFN;
    }

    public void aF(bw bwVar) {
        this.fFN = bwVar;
    }

    public List<bw> cYS() {
        return this.kFF;
    }

    public String getThreadId() {
        if (this.fFN == null) {
            return "";
        }
        return this.fFN.getId();
    }

    public ArrayList<PostData> cYT() {
        return this.kFw;
    }

    public av getPage() {
        return this.page;
    }

    public am cYU() {
        return this.kFB;
    }

    public az cYV() {
        return this.kFE;
    }

    public z cYW() {
        if (this.kGe == null || !this.kGe.isValid()) {
            return null;
        }
        return this.kGe;
    }

    public ac cYX() {
        if (this.kGf == null || !this.kGf.isValid()) {
            return null;
        }
        return this.kGf;
    }

    public void a(av avVar, int i) {
        this.page.ni(avVar.bem());
        this.page.ng(avVar.bdn());
        this.page.nf(avVar.bej());
        this.page.nj(avVar.ben());
        this.page.nh(avVar.bel());
        if (i == 0) {
            this.page = avVar;
        } else if (i == 1) {
            this.page.nk(avVar.beo());
        } else if (i == 2) {
            this.page.nl(avVar.bep());
        }
    }

    public AntiData getAnti() {
        return this.anti;
    }

    public UserData getUserData() {
        return this.userData;
    }

    public boolean bbu() {
        return this.fFN.bfF() != 0;
    }

    public void hy(boolean z) {
        if (this.fFN != null) {
            if (z) {
                this.fFN.nv(1);
            } else {
                this.fFN.nv(0);
            }
        }
    }

    public String bbt() {
        if (this.fFN != null) {
            return this.fFN.bfG();
        }
        return null;
    }

    public void NN(String str) {
        if (this.fFN != null) {
            this.fFN.zK(str);
        }
    }

    public String cYY() {
        return this.kFS;
    }

    public boolean cYZ() {
        return (this.fFN == null || this.fFN.bfI() == null || this.fFN.bfI().size() <= 0 || this.fFN.bfI().get(0) == null || !this.fFN.bfI().get(0).bdo()) ? false : true;
    }

    public PostData cZa() {
        return this.kFY;
    }

    public void d(PostData postData) {
        this.kFY = postData;
        this.kGa = postData;
        this.kFZ = false;
    }

    public PostData cZb() {
        return this.kGa;
    }

    public void e(PostData postData) {
        this.kGa = postData;
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                com.baidu.tieba.recapp.d.a.drI().Qa(dataRes.asp_shown_info);
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
                this.kFv.parserProtobuf(dataRes.display_forum);
                this.fFN.setUserMap(this.userMap);
                this.fFN.a(dataRes.thread);
                this.kFA.a(dataRes.news_info);
                switch (this.kFA.dGl) {
                    case 1:
                        this.kFB.kRH = this.kFA;
                        break;
                    case 2:
                        this.kFB.kRI = this.kFA;
                        break;
                    case 3:
                        this.kFB.kRJ = this.kFA;
                        break;
                    default:
                        this.kFB.kRI = this.kFA;
                        break;
                }
                this.kFE.a(dataRes.recommend_book);
                b(dataRes, context);
                this.kFY = new PostData();
                this.kFY.Is(1);
                this.kFY.setUserMap(this.userMap);
                this.kFY.wj(this.forum.isBrandForum);
                this.kFY.setTime(this.fFN.getCreateTime());
                if (dataRes.first_floor_post != null) {
                    this.kFY.a(dataRes.first_floor_post, context);
                }
                if (this.fFN != null && this.fFN.isShareThread) {
                    this.kFY.h(this.fFN.efS);
                }
                if (this.kGa == null) {
                    this.kGa = this.kFY;
                    this.kFZ = true;
                }
                this.page.a(dataRes.page);
                this.anti.parserProtobuf(dataRes.anti);
                this.kFx.a(dataRes.location);
                if (dataRes.user != null) {
                    this.userIdentity = dataRes.user.is_manager.intValue();
                }
                this.userData.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.kFC.add(muteUser);
                        }
                    }
                }
                this.fFN.nr(this.fFN.bfp() > 0 ? this.fFN.bfp() - 1 : 0);
                List<AppData> dqS = com.baidu.tieba.recapp.r.dqU().dqS();
                if (dqS != null) {
                    dqS.clear();
                }
                this.kFI = null;
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        com.baidu.tieba.tbadkCore.data.n nVar = new com.baidu.tieba.tbadkCore.data.n();
                        nVar.d(app);
                        AppData dAr = nVar.dAr();
                        if (!this.kFH.contains(nVar) && dAr.goods != null && (!StringUtils.isNull(dAr.goods.user_name) || !StringUtils.isNull(dAr.goods.lego_card))) {
                            nVar.kUJ = cZr();
                            this.kFH.add(nVar);
                            if (dqS != null) {
                                dqS.add(nVar.dAr());
                            }
                        }
                    }
                    c(dataRes);
                    d(dataRes);
                }
                com.baidu.tieba.recapp.r.dqU().dqT();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.userData.getIsSelectTail());
                }
                this.kFJ.parserProtobuf(dataRes.twzhibo_anti);
                this.kFh = dataRes.appeal_info;
                if (dataRes.forum_headline_img_info != null) {
                    this.kFO = new i();
                    this.kFO.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.guess_like != null) {
                    this.kFj = new CardHListViewData();
                    this.kFj.parseProtobuf(dataRes.guess_like);
                }
                b(dataRes);
                if (y.getCount(dataRes.repost_recommend_forum_list) > 0) {
                    if (this.kFK == null) {
                        this.kFK = new ArrayList();
                    }
                    for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                        bs bsVar = new bs();
                        bsVar.parserProtobuf(simpleForum);
                        this.kFK.add(bsVar);
                    }
                }
                if (y.getCount(dataRes.from_forum_list) > 0) {
                    if (this.kFL == null) {
                        this.kFL = new ArrayList();
                    }
                    for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                        if (simpleForum2 != null) {
                            bs bsVar2 = new bs();
                            bsVar2.parserProtobuf(simpleForum2);
                            this.kFL.add(bsVar2);
                        }
                    }
                }
                this.kFS = dataRes.multi_forum_text;
                if (this.kFP >= 0) {
                    this.kFP = dataRes.thread_freq_num.longValue();
                }
                a(dataRes);
                if (this.kFV == null) {
                    this.kFV = new ArrayList();
                }
                this.kFV.clear();
                if (dataRes.bjh_recommend != null) {
                    int i2 = 1;
                    for (ThreadInfo threadInfo : dataRes.bjh_recommend) {
                        if (threadInfo != null && !d(threadInfo) && !e(threadInfo)) {
                            com.baidu.tbadk.core.data.n nVar2 = new com.baidu.tbadk.core.data.n();
                            nVar2.setFloorNum(i2);
                            nVar2.a(threadInfo);
                            this.kFV.add(nVar2);
                            i2++;
                        }
                    }
                }
                if (this.kFX != null && this.kFX.diJ()) {
                    this.kFX = null;
                }
                if (dataRes.recom_ala_info != null && dataRes.recom_ala_info.live_status.intValue() == 1 && dataRes.recom_ala_info.pb_display_type.intValue() == 2) {
                    if (this.kFX == null) {
                        this.kFX = new com.baidu.tieba.pb.videopb.c.a();
                        this.kFX.parserProtoBuf(dataRes.recom_ala_info);
                    }
                } else if (this.kFX == null && dataRes.promotion != null) {
                    this.kFX = new com.baidu.tieba.pb.videopb.c.a();
                    this.kFX.a(dataRes.promotion);
                }
                if (dataRes.business_promot_info != null) {
                    this.kFq = dataRes.business_promot_info.is_promot.longValue() == 1;
                    this.kFr = dataRes.business_promot_info.is_headlinepost.intValue() == 1;
                    this.kFs = dataRes.business_promot_info.is_s_card.intValue() == 1;
                    if (dataRes.business_promot_info.send_card_info != null) {
                        b bVar = new b();
                        bVar.a(dataRes.business_promot_info.send_card_info);
                        if (this.kFt == null) {
                            this.kFt = new a();
                        }
                        this.kFt.a(bVar);
                    }
                }
                this.kGe.reset();
                this.kGe.setUserMap(this.userMap);
                this.kGe.a(dataRes.recom_ala_info);
                if (this.kGe.kOz != null) {
                    this.kGe.kOz.setTid(getThreadId());
                }
                this.kGf = new ac();
                this.kGf.setUserMap(this.userMap);
                this.kGf.a(dataRes.recom_ala_info);
                if (this.kGf.kOz != null) {
                    this.kGf.kOz.setTid(getThreadId());
                }
                this.kGg = dataRes.jumptotab1 == null ? null : dataRes.jumptotab1.toString();
                this.kGh = dataRes.jumptotab2;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    private void b(DataRes dataRes, Context context) {
        List<Post> list = dataRes.post_list;
        if (list != null && list.size() > 0) {
            for (Post post : dataRes.post_list) {
                if (!this.kFU.contains(String.valueOf(post.id))) {
                    PostData postData = new PostData();
                    postData.setUserMap(this.userMap);
                    postData.wj(this.forum.isBrandForum);
                    postData.a(post, context);
                    postData.a(cYR().bfj());
                    if (postData.bhp() != null && postData.bhp().baijiahaoData == null && cYR() != null && cYR().getBaijiahaoData() != null) {
                        postData.bhp().baijiahaoData = cYR().getBaijiahaoData();
                    }
                    this.kFU.add(postData.getId());
                    if (postData.dAD() == 1 && this.fFN.bgm()) {
                        if (cYZ()) {
                            postData.setPostType(0);
                        } else {
                            postData.setPostType(this.fFN.bgl());
                        }
                    } else if (postData.dAD() == 1 && this.fFN.bgG()) {
                        postData.setPostType(41);
                    } else if (postData.dAD() == 1 && this.fFN != null && this.fFN.bee()) {
                        postData.setPostType(0);
                        postData.byQ();
                        if (this.fFN.bfw() == null || this.fFN.bfw().size() == 0) {
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
                            postData.c(new TbRichText((Context) TbadkCoreApplication.getInst(), this.fFN.bfw(), true));
                        }
                        this.kFN = postData;
                    }
                    if (postData.dAD() == 1 && this.fFN != null && this.fFN.isShareThread) {
                        postData.h(this.fFN.efS);
                    }
                    if (postData.dAD() == 1) {
                        this.kGa = postData;
                        this.kFZ = false;
                    }
                    this.kFw.add(postData);
                }
            }
        }
    }

    private void a(DataRes dataRes) {
        this.kFQ = new o(this.fFN, this.anti);
        this.kFk = dataRes.partial_visible_toast;
        if (dataRes.follow_tip != null && dataRes.follow_tip.is_toast_tip.intValue() == 1) {
            this.kFy = dataRes.follow_tip.tip_text;
        }
        this.kFG = new AlaLiveInfoCoreData();
        if (dataRes.ala_info != null) {
            this.kFG.parserProtoBuf(dataRes.ala_info);
        }
        this.kFR = dataRes.fold_tip;
        this.kFl = dataRes.exp_news_today.intValue();
        this.kFm = dataRes.exp_guide_today.intValue();
        if (!y.isEmpty(dataRes.thread_topic)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= dataRes.thread_topic.size()) {
                    break;
                }
                bm.a aVar = new bm.a();
                aVar.a(dataRes.thread_topic.get(i2));
                this.kFT.add(aVar);
                i = i2 + 1;
            }
        }
        this.kFn = dataRes.pb_sort_info;
        this.kFo = dataRes.sort_type.intValue();
        if (dataRes.manager_election != null) {
            this.kFp = k.b(dataRes.manager_election);
        }
    }

    private void b(DataRes dataRes) {
        if (dataRes.feed_thread_list != null && dataRes.feed_thread_list.size() > 0) {
            List<ThreadInfo> list = dataRes.feed_thread_list;
            if (this.kFF == null) {
                this.kFF = new ArrayList();
            }
            this.kFF.clear();
            for (ThreadInfo threadInfo : list) {
                if (threadInfo != null) {
                    bw bwVar = new bw();
                    bwVar.a(threadInfo);
                    this.kFF.add(bwVar);
                }
            }
            if (this.kFF != null && this.kFF.size() > 15) {
                this.kFF = y.subList(this.kFF, 0, 15);
            }
        }
    }

    private void c(DataRes dataRes) {
        List<String> zu;
        App app = dataRes.banner_list.pb_banner_ad;
        com.baidu.tieba.tbadkCore.data.n nVar = new com.baidu.tieba.tbadkCore.data.n();
        nVar.moy = true;
        nVar.d(app);
        AppData dAr = nVar.dAr();
        if (dAr.goods != null) {
            if (y.isEmpty(dAr.goods.thread_pic_list) && (zu = AdvertAppInfo.a.zu(dAr.goods.lego_card)) != null && dAr.goods.thread_pic_list != null) {
                dAr.goods.thread_pic_list.addAll(zu);
            }
            this.kFI = nVar;
        }
    }

    private void d(DataRes dataRes) {
        List<App> list = dataRes.banner_list.video_recommend_ad;
        this.kGd.clear();
        if (list != null && !list.isEmpty()) {
            for (App app : list) {
                com.baidu.tieba.tbadkCore.data.n nVar = new com.baidu.tieba.tbadkCore.data.n();
                nVar.d(app);
                AppData dAr = nVar.dAr();
                if (!this.kGd.contains(nVar) && dAr.goods != null && (!StringUtils.isNull(dAr.goods.user_name) || !StringUtils.isNull(dAr.goods.lego_card))) {
                    nVar.kUJ = cZr();
                    this.kGd.add(nVar);
                }
            }
        }
    }

    public String cZc() {
        return this.kFR;
    }

    public CardHListViewData cZd() {
        return this.kFj;
    }

    public PostData cZe() {
        return this.kFN;
    }

    public PostData f(PostData postData) {
        this.kFN = postData;
        return postData;
    }

    public r cZf() {
        return this.kFM;
    }

    public int cZg() {
        return this.userIdentity;
    }

    public int getIsNewUrl() {
        return this.kFz;
    }

    public void setIsNewUrl(int i) {
        this.kFz = i;
    }

    public List<MuteUser> cZh() {
        return this.kFC;
    }

    public ArrayList<com.baidu.tieba.tbadkCore.data.n> cZi() {
        return this.kFH;
    }

    public com.baidu.tieba.tbadkCore.data.n cZj() {
        return this.kFI;
    }

    public void b(com.baidu.tieba.tbadkCore.data.n nVar) {
        this.kFI = nVar;
    }

    public void cZk() {
        if (this.kFI.dAr() != null) {
            this.kFI.dAr().legoCard = null;
        }
        this.kFI = null;
    }

    public void cZl() {
        this.kGe = null;
        this.kGf = null;
    }

    public String cZm() {
        return this.kFi;
    }

    public void NO(String str) {
        this.kFi = str;
    }

    public i cZn() {
        return this.kFO;
    }

    public List<bs> cZo() {
        return this.kFL;
    }

    public long cZp() {
        return this.kFP;
    }

    public o cZq() {
        return this.kFQ;
    }

    public void a(o oVar) {
        this.kFQ = oVar;
    }

    public boolean cZr() {
        return (cYR() == null || !cYR().bee() || cYR().bfQ() == null) ? false : true;
    }

    public AlaLiveInfoCoreData cZs() {
        return this.kFG;
    }

    public List<com.baidu.tbadk.core.data.n> cZt() {
        return this.kFV;
    }

    public boolean cZu() {
        return cYR() != null && cYR().bei();
    }

    public String cZv() {
        if (this.kFn != null && this.kFn.size() > this.kFo) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.kFn.size()) {
                    break;
                } else if (this.kFn.get(i2).sort_type.intValue() != this.kFo) {
                    i = i2 + 1;
                } else {
                    return this.kFn.get(i2).sort_name;
                }
            }
        }
        return "";
    }

    public com.baidu.tieba.pb.videopb.c.a cZw() {
        return this.kFX;
    }

    public int cZx() {
        return this.kFW;
    }

    public void Eq(int i) {
        this.kFW = i;
    }

    public List<com.baidu.tieba.tbadkCore.data.n> cZy() {
        return this.kGd;
    }

    private boolean d(ThreadInfo threadInfo) {
        if (threadInfo == null || getThreadId() == null || "0".equals(threadInfo.id) || "0".equals(threadInfo.tid)) {
            return false;
        }
        return getThreadId().equals(threadInfo.id) || getThreadId().equals(threadInfo.tid);
    }

    private boolean e(ThreadInfo threadInfo) {
        if (threadInfo == null || threadInfo.baijiahao == null || threadInfo.baijiahao.ori_ugc_nid == null || this.fFN == null || this.fFN.getBaijiahaoData() == null || this.fFN.getBaijiahaoData().oriUgcNid == null || "0".equals(threadInfo.baijiahao.ori_ugc_nid)) {
            return false;
        }
        return threadInfo.baijiahao.ori_ugc_nid.equals(this.fFN.getBaijiahaoData().oriUgcNid);
    }
}

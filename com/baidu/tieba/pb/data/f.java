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
/* loaded from: classes16.dex */
public class f {
    public AppealInfo kwB;
    public String kwC;
    public CardHListViewData kwD;
    public String kwE;
    public int kwF;
    public int kwG;
    public List<PbSortType> kwH;
    public int kwI;
    public k kwJ;
    public a kwN;
    private String kwT;
    private int kwU;
    private ac kxA;
    public String kxB;
    public String kxC;
    private List<bw> kxa;
    private AlaLiveInfoCoreData kxb;
    private TwzhiboAnti kxe;
    private List<bs> kxf;
    private List<bs> kxg;
    private PostData kxi;
    private i kxj;
    private long kxk;
    private o kxl;
    private String kxm;
    private String kxn;
    private List<com.baidu.tbadk.core.data.n> kxq;
    private com.baidu.tieba.pb.videopb.c.a kxs;
    private PostData kxt;
    private PostData kxv;
    public boolean kxx;
    public boolean kwK = false;
    public boolean kwL = false;
    public boolean kwM = false;
    public boolean kwO = false;
    private boolean kwY = true;
    private ArrayList<com.baidu.tieba.tbadkCore.data.n> kxc = new ArrayList<>();
    private com.baidu.tieba.tbadkCore.data.n kxd = null;
    private int kxr = 0;
    public boolean kxu = true;
    public int kxw = 0;
    public int XV = 0;
    private List<com.baidu.tieba.tbadkCore.data.n> kxy = new ArrayList();
    private ForumData forum = new ForumData();
    private bs kwP = new bs();
    private bw fCx = new bw();
    private ArrayList<PostData> kwQ = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private av page = new av();
    private AntiData anti = new AntiData();
    private com.baidu.tbadk.data.f kwR = new com.baidu.tbadk.data.f();
    private int kwS = 0;
    private final UserData userData = new UserData();
    private List<MuteUser> kwX = new ArrayList();
    private ay kwV = new ay();
    private az kwZ = new az();
    private am kwW = new am();
    private r kxh = new r();
    private z kxz = new z();
    private List<bm.a> kxo = new ArrayList();
    private HashSet<String> kxp = new HashSet<>();

    public f() {
        this.kwU = 0;
        this.kxe = null;
        this.kwU = 0;
        this.kxe = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.kwQ != null && this.kwQ.size() > 0;
    }

    public String[] fv(Context context) {
        return q(context, true);
    }

    public String[] q(Context context, boolean z) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5 = null;
        if (!isValid()) {
            str = "";
        } else {
            int size = this.kwQ.size() > 30 ? 30 : this.kwQ.size();
            if (cVl() == null || cVl().beE() == null || at.isEmpty(cVl().beE().getUserId())) {
                return new String[]{null, ""};
            }
            String userId = cVl().beE().getUserId();
            PostData cVv = cVv();
            if (cVv == null || cVv.beE() == null || at.isEmpty(cVv.beE().getUserId())) {
                str2 = "";
            } else {
                if (!at.equals(userId, cVv.beE().getUserId())) {
                    str4 = null;
                } else {
                    str4 = cVv.dwM();
                }
                if (!at.isEmpty("")) {
                    str5 = str4;
                    str2 = "";
                } else {
                    str5 = str4;
                    str2 = cVv.dwK();
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
                    PostData postData = (PostData) y.getItem(this.kwQ, i);
                    if (postData != null && postData.beE() != null && !at.isEmpty(postData.beE().getUserId()) && at.equals(userId, postData.beE().getUserId())) {
                        if (at.isEmpty(str5)) {
                            str5 = postData.dwM();
                        }
                        String dwK = at.isEmpty(str6) ? postData.dwK() : str6;
                        if (!at.isEmpty(str5) && !at.isEmpty(dwK)) {
                            str = dwK;
                            str3 = str5;
                            break;
                        }
                        str6 = dwK;
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
            if (this.fCx != null && this.fCx.bfE() != null && this.fCx.bfE().getGroup_id() != 0) {
                str = "[" + context.getString(R.string.photo_live_tips) + "] " + str;
            }
            str5 = (this.fCx == null || this.fCx.beW() == null || at.isEmpty(this.fCx.beW().thumbnail_url)) ? str3 : this.fCx.beW().thumbnail_url;
            if (this.fCx != null && !this.fCx.isShareThread && str5 == null && this.fCx.edE != null && this.fCx.edE.dZc != null) {
                ArrayList<MediaData> arrayList = this.fCx.edE.dZc;
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

    public bs cVk() {
        return this.kwP;
    }

    public void d(bs bsVar) {
        this.kwP = bsVar;
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

    public bw cVl() {
        return this.fCx;
    }

    public void aE(bw bwVar) {
        this.fCx = bwVar;
    }

    public List<bw> cVm() {
        return this.kxa;
    }

    public String getThreadId() {
        if (this.fCx == null) {
            return "";
        }
        return this.fCx.getId();
    }

    public ArrayList<PostData> cVn() {
        return this.kwQ;
    }

    public av getPage() {
        return this.page;
    }

    public am cVo() {
        return this.kwW;
    }

    public az cVp() {
        return this.kwZ;
    }

    public z cVq() {
        if (this.kxz == null || !this.kxz.isValid()) {
            return null;
        }
        return this.kxz;
    }

    public ac cVr() {
        if (this.kxA == null || !this.kxA.isValid()) {
            return null;
        }
        return this.kxA;
    }

    public void a(av avVar, int i) {
        this.page.mX(avVar.bds());
        this.page.mV(avVar.bct());
        this.page.mU(avVar.bdp());
        this.page.mY(avVar.bdt());
        this.page.mW(avVar.bdr());
        if (i == 0) {
            this.page = avVar;
        } else if (i == 1) {
            this.page.mZ(avVar.bdu());
        } else if (i == 2) {
            this.page.na(avVar.bdv());
        }
    }

    public AntiData getAnti() {
        return this.anti;
    }

    public UserData getUserData() {
        return this.userData;
    }

    public boolean baA() {
        return this.fCx.beL() != 0;
    }

    public void hA(boolean z) {
        if (this.fCx != null) {
            if (z) {
                this.fCx.nk(1);
            } else {
                this.fCx.nk(0);
            }
        }
    }

    public String baz() {
        if (this.fCx != null) {
            return this.fCx.beM();
        }
        return null;
    }

    public void Nk(String str) {
        if (this.fCx != null) {
            this.fCx.zo(str);
        }
    }

    public String cVs() {
        return this.kxn;
    }

    public boolean cVt() {
        return (this.fCx == null || this.fCx.beO() == null || this.fCx.beO().size() <= 0 || this.fCx.beO().get(0) == null || !this.fCx.beO().get(0).bcu()) ? false : true;
    }

    public PostData cVu() {
        return this.kxt;
    }

    public void d(PostData postData) {
        this.kxt = postData;
        this.kxv = postData;
        this.kxu = false;
    }

    public PostData cVv() {
        return this.kxv;
    }

    public void e(PostData postData) {
        this.kxv = postData;
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                com.baidu.tieba.recapp.d.a.dnW().Pz(dataRes.asp_shown_info);
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
                this.kwP.parserProtobuf(dataRes.display_forum);
                this.fCx.setUserMap(this.userMap);
                this.fCx.a(dataRes.thread);
                this.kwV.a(dataRes.news_info);
                switch (this.kwV.dEg) {
                    case 1:
                        this.kwW.kJa = this.kwV;
                        break;
                    case 2:
                        this.kwW.kJb = this.kwV;
                        break;
                    case 3:
                        this.kwW.kJc = this.kwV;
                        break;
                    default:
                        this.kwW.kJb = this.kwV;
                        break;
                }
                this.kwZ.a(dataRes.recommend_book);
                b(dataRes, context);
                this.kxt = new PostData();
                this.kxt.HP(1);
                this.kxt.setUserMap(this.userMap);
                this.kxt.vY(this.forum.isBrandForum);
                this.kxt.setTime(this.fCx.getCreateTime());
                if (dataRes.first_floor_post != null) {
                    this.kxt.a(dataRes.first_floor_post, context);
                }
                if (this.fCx != null && this.fCx.isShareThread) {
                    this.kxt.h(this.fCx.edE);
                }
                if (this.kxv == null) {
                    this.kxv = this.kxt;
                    this.kxu = true;
                }
                this.page.a(dataRes.page);
                this.anti.parserProtobuf(dataRes.anti);
                this.kwR.a(dataRes.location);
                if (dataRes.user != null) {
                    this.kwS = dataRes.user.is_manager.intValue();
                }
                this.userData.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.kwX.add(muteUser);
                        }
                    }
                }
                this.fCx.ng(this.fCx.bev() > 0 ? this.fCx.bev() - 1 : 0);
                List<AppData> dnf = com.baidu.tieba.recapp.r.dnh().dnf();
                if (dnf != null) {
                    dnf.clear();
                }
                this.kxd = null;
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        com.baidu.tieba.tbadkCore.data.n nVar = new com.baidu.tieba.tbadkCore.data.n();
                        nVar.d(app);
                        AppData dwt = nVar.dwt();
                        if (!this.kxc.contains(nVar) && dwt.goods != null && (!StringUtils.isNull(dwt.goods.user_name) || !StringUtils.isNull(dwt.goods.lego_card))) {
                            nVar.kMc = cVL();
                            this.kxc.add(nVar);
                            if (dnf != null) {
                                dnf.add(nVar.dwt());
                            }
                        }
                    }
                    c(dataRes);
                    d(dataRes);
                }
                com.baidu.tieba.recapp.r.dnh().dng();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.userData.getIsSelectTail());
                }
                this.kxe.parserProtobuf(dataRes.twzhibo_anti);
                this.kwB = dataRes.appeal_info;
                if (dataRes.forum_headline_img_info != null) {
                    this.kxj = new i();
                    this.kxj.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.guess_like != null) {
                    this.kwD = new CardHListViewData();
                    this.kwD.parseProtobuf(dataRes.guess_like);
                }
                b(dataRes);
                if (y.getCount(dataRes.repost_recommend_forum_list) > 0) {
                    if (this.kxf == null) {
                        this.kxf = new ArrayList();
                    }
                    for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                        bs bsVar = new bs();
                        bsVar.parserProtobuf(simpleForum);
                        this.kxf.add(bsVar);
                    }
                }
                if (y.getCount(dataRes.from_forum_list) > 0) {
                    if (this.kxg == null) {
                        this.kxg = new ArrayList();
                    }
                    for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                        if (simpleForum2 != null) {
                            bs bsVar2 = new bs();
                            bsVar2.parserProtobuf(simpleForum2);
                            this.kxg.add(bsVar2);
                        }
                    }
                }
                this.kxn = dataRes.multi_forum_text;
                if (this.kxk >= 0) {
                    this.kxk = dataRes.thread_freq_num.longValue();
                }
                a(dataRes);
                if (this.kxq == null) {
                    this.kxq = new ArrayList();
                }
                this.kxq.clear();
                if (dataRes.bjh_recommend != null) {
                    int i2 = 1;
                    for (ThreadInfo threadInfo : dataRes.bjh_recommend) {
                        if (threadInfo != null && !d(threadInfo) && !e(threadInfo)) {
                            com.baidu.tbadk.core.data.n nVar2 = new com.baidu.tbadk.core.data.n();
                            nVar2.setFloorNum(i2);
                            nVar2.a(threadInfo);
                            this.kxq.add(nVar2);
                            i2++;
                        }
                    }
                }
                if (this.kxs != null && this.kxs.dfe()) {
                    this.kxs = null;
                }
                if (dataRes.recom_ala_info != null && dataRes.recom_ala_info.live_status.intValue() == 1 && dataRes.recom_ala_info.pb_display_type.intValue() == 2) {
                    if (this.kxs == null) {
                        this.kxs = new com.baidu.tieba.pb.videopb.c.a();
                        this.kxs.parserProtoBuf(dataRes.recom_ala_info);
                    }
                } else if (this.kxs == null && dataRes.promotion != null) {
                    this.kxs = new com.baidu.tieba.pb.videopb.c.a();
                    this.kxs.a(dataRes.promotion);
                }
                if (dataRes.business_promot_info != null) {
                    this.kwK = dataRes.business_promot_info.is_promot.longValue() == 1;
                    this.kwL = dataRes.business_promot_info.is_headlinepost.intValue() == 1;
                    this.kwM = dataRes.business_promot_info.is_s_card.intValue() == 1;
                    if (dataRes.business_promot_info.send_card_info != null) {
                        b bVar = new b();
                        bVar.a(dataRes.business_promot_info.send_card_info);
                        if (this.kwN == null) {
                            this.kwN = new a();
                        }
                        this.kwN.a(bVar);
                    }
                }
                this.kxz.reset();
                this.kxz.setUserMap(this.userMap);
                this.kxz.a(dataRes.recom_ala_info);
                if (this.kxz.kFT != null) {
                    this.kxz.kFT.setTid(getThreadId());
                }
                this.kxA = new ac();
                this.kxA.setUserMap(this.userMap);
                this.kxA.a(dataRes.recom_ala_info);
                if (this.kxA.kFT != null) {
                    this.kxA.kFT.setTid(getThreadId());
                }
                this.kxB = dataRes.jumptotab1 == null ? null : dataRes.jumptotab1.toString();
                this.kxC = dataRes.jumptotab2;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    private void b(DataRes dataRes, Context context) {
        List<Post> list = dataRes.post_list;
        if (list != null && list.size() > 0) {
            for (Post post : dataRes.post_list) {
                if (!this.kxp.contains(String.valueOf(post.id))) {
                    PostData postData = new PostData();
                    postData.setUserMap(this.userMap);
                    postData.vY(this.forum.isBrandForum);
                    postData.a(post, context);
                    postData.a(cVl().bep());
                    if (postData.bgv() != null && postData.bgv().baijiahaoData == null && cVl() != null && cVl().getBaijiahaoData() != null) {
                        postData.bgv().baijiahaoData = cVl().getBaijiahaoData();
                    }
                    this.kxp.add(postData.getId());
                    if (postData.dwF() == 1 && this.fCx.bfs()) {
                        if (cVt()) {
                            postData.setPostType(0);
                        } else {
                            postData.setPostType(this.fCx.bfr());
                        }
                    } else if (postData.dwF() == 1 && this.fCx.bfM()) {
                        postData.setPostType(41);
                    } else if (postData.dwF() == 1 && this.fCx != null && this.fCx.bdk()) {
                        postData.setPostType(0);
                        postData.bxG();
                        if (this.fCx.beC() == null || this.fCx.beC().size() == 0) {
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
                            postData.c(new TbRichText((Context) TbadkCoreApplication.getInst(), this.fCx.beC(), true));
                        }
                        this.kxi = postData;
                    }
                    if (postData.dwF() == 1 && this.fCx != null && this.fCx.isShareThread) {
                        postData.h(this.fCx.edE);
                    }
                    if (postData.dwF() == 1) {
                        this.kxv = postData;
                        this.kxu = false;
                    }
                    this.kwQ.add(postData);
                }
            }
        }
    }

    private void a(DataRes dataRes) {
        this.kxl = new o(this.fCx, this.anti);
        this.kwE = dataRes.partial_visible_toast;
        if (dataRes.follow_tip != null && dataRes.follow_tip.is_toast_tip.intValue() == 1) {
            this.kwT = dataRes.follow_tip.tip_text;
        }
        this.kxb = new AlaLiveInfoCoreData();
        if (dataRes.ala_info != null) {
            this.kxb.parserProtoBuf(dataRes.ala_info);
        }
        this.kxm = dataRes.fold_tip;
        this.kwF = dataRes.exp_news_today.intValue();
        this.kwG = dataRes.exp_guide_today.intValue();
        if (!y.isEmpty(dataRes.thread_topic)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= dataRes.thread_topic.size()) {
                    break;
                }
                bm.a aVar = new bm.a();
                aVar.a(dataRes.thread_topic.get(i2));
                this.kxo.add(aVar);
                i = i2 + 1;
            }
        }
        this.kwH = dataRes.pb_sort_info;
        this.kwI = dataRes.sort_type.intValue();
        if (dataRes.manager_election != null) {
            this.kwJ = k.b(dataRes.manager_election);
        }
    }

    private void b(DataRes dataRes) {
        if (dataRes.feed_thread_list != null && dataRes.feed_thread_list.size() > 0) {
            List<ThreadInfo> list = dataRes.feed_thread_list;
            if (this.kxa == null) {
                this.kxa = new ArrayList();
            }
            this.kxa.clear();
            for (ThreadInfo threadInfo : list) {
                if (threadInfo != null) {
                    bw bwVar = new bw();
                    bwVar.a(threadInfo);
                    this.kxa.add(bwVar);
                }
            }
            if (this.kxa != null && this.kxa.size() > 15) {
                this.kxa = y.subList(this.kxa, 0, 15);
            }
        }
    }

    private void c(DataRes dataRes) {
        List<String> yY;
        App app = dataRes.banner_list.pb_banner_ad;
        com.baidu.tieba.tbadkCore.data.n nVar = new com.baidu.tieba.tbadkCore.data.n();
        nVar.meK = true;
        nVar.d(app);
        AppData dwt = nVar.dwt();
        if (dwt.goods != null) {
            if (y.isEmpty(dwt.goods.thread_pic_list) && (yY = AdvertAppInfo.a.yY(dwt.goods.lego_card)) != null && dwt.goods.thread_pic_list != null) {
                dwt.goods.thread_pic_list.addAll(yY);
            }
            this.kxd = nVar;
        }
    }

    private void d(DataRes dataRes) {
        List<App> list = dataRes.banner_list.video_recommend_ad;
        this.kxy.clear();
        if (list != null && !list.isEmpty()) {
            for (App app : list) {
                com.baidu.tieba.tbadkCore.data.n nVar = new com.baidu.tieba.tbadkCore.data.n();
                nVar.d(app);
                AppData dwt = nVar.dwt();
                if (!this.kxy.contains(nVar) && dwt.goods != null && (!StringUtils.isNull(dwt.goods.user_name) || !StringUtils.isNull(dwt.goods.lego_card))) {
                    nVar.kMc = cVL();
                    this.kxy.add(nVar);
                }
            }
        }
    }

    public String cVw() {
        return this.kxm;
    }

    public CardHListViewData cVx() {
        return this.kwD;
    }

    public PostData cVy() {
        return this.kxi;
    }

    public PostData f(PostData postData) {
        this.kxi = postData;
        return postData;
    }

    public r cVz() {
        return this.kxh;
    }

    public int cVA() {
        return this.kwS;
    }

    public int getIsNewUrl() {
        return this.kwU;
    }

    public void setIsNewUrl(int i) {
        this.kwU = i;
    }

    public List<MuteUser> cVB() {
        return this.kwX;
    }

    public ArrayList<com.baidu.tieba.tbadkCore.data.n> cVC() {
        return this.kxc;
    }

    public com.baidu.tieba.tbadkCore.data.n cVD() {
        return this.kxd;
    }

    public void b(com.baidu.tieba.tbadkCore.data.n nVar) {
        this.kxd = nVar;
    }

    public void cVE() {
        if (this.kxd.dwt() != null) {
            this.kxd.dwt().legoCard = null;
        }
        this.kxd = null;
    }

    public void cVF() {
        this.kxz = null;
        this.kxA = null;
    }

    public String cVG() {
        return this.kwC;
    }

    public void Nl(String str) {
        this.kwC = str;
    }

    public i cVH() {
        return this.kxj;
    }

    public List<bs> cVI() {
        return this.kxg;
    }

    public long cVJ() {
        return this.kxk;
    }

    public o cVK() {
        return this.kxl;
    }

    public void a(o oVar) {
        this.kxl = oVar;
    }

    public boolean cVL() {
        return (cVl() == null || !cVl().bdk() || cVl().beW() == null) ? false : true;
    }

    public AlaLiveInfoCoreData cVM() {
        return this.kxb;
    }

    public List<com.baidu.tbadk.core.data.n> cVN() {
        return this.kxq;
    }

    public boolean cVO() {
        return cVl() != null && cVl().bdo();
    }

    public String cVP() {
        if (this.kwH != null && this.kwH.size() > this.kwI) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.kwH.size()) {
                    break;
                } else if (this.kwH.get(i2).sort_type.intValue() != this.kwI) {
                    i = i2 + 1;
                } else {
                    return this.kwH.get(i2).sort_name;
                }
            }
        }
        return "";
    }

    public com.baidu.tieba.pb.videopb.c.a cVQ() {
        return this.kxs;
    }

    public int cVR() {
        return this.kxr;
    }

    public void DP(int i) {
        this.kxr = i;
    }

    public List<com.baidu.tieba.tbadkCore.data.n> cVS() {
        return this.kxy;
    }

    private boolean d(ThreadInfo threadInfo) {
        if (threadInfo == null || getThreadId() == null || "0".equals(threadInfo.id) || "0".equals(threadInfo.tid)) {
            return false;
        }
        return getThreadId().equals(threadInfo.id) || getThreadId().equals(threadInfo.tid);
    }

    private boolean e(ThreadInfo threadInfo) {
        if (threadInfo == null || threadInfo.baijiahao == null || threadInfo.baijiahao.ori_ugc_nid == null || this.fCx == null || this.fCx.getBaijiahaoData() == null || this.fCx.getBaijiahaoData().oriUgcNid == null || "0".equals(threadInfo.baijiahao.ori_ugc_nid)) {
            return false;
        }
        return threadInfo.baijiahao.ori_ugc_nid.equals(this.fCx.getBaijiahaoData().oriUgcNid);
    }
}

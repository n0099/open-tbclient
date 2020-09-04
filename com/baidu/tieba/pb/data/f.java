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
    public AppealInfo kwI;
    public String kwJ;
    public CardHListViewData kwK;
    public String kwL;
    public int kwM;
    public int kwN;
    public List<PbSortType> kwO;
    public int kwP;
    public k kwQ;
    public a kwU;
    private PostData kxA;
    private PostData kxC;
    public boolean kxE;
    private ac kxH;
    public String kxI;
    public String kxJ;
    private String kxa;
    private int kxb;
    private List<bw> kxh;
    private AlaLiveInfoCoreData kxi;
    private TwzhiboAnti kxl;
    private List<bs> kxm;
    private List<bs> kxn;
    private PostData kxp;
    private i kxq;
    private long kxr;
    private o kxs;
    private String kxt;
    private String kxu;
    private List<com.baidu.tbadk.core.data.n> kxx;
    private com.baidu.tieba.pb.videopb.c.a kxz;
    public boolean kwR = false;
    public boolean kwS = false;
    public boolean kwT = false;
    public boolean kwV = false;
    private boolean kxf = true;
    private ArrayList<com.baidu.tieba.tbadkCore.data.n> kxj = new ArrayList<>();
    private com.baidu.tieba.tbadkCore.data.n kxk = null;
    private int kxy = 0;
    public boolean kxB = true;
    public int kxD = 0;
    public int XX = 0;
    private List<com.baidu.tieba.tbadkCore.data.n> kxF = new ArrayList();
    private ForumData forum = new ForumData();
    private bs kwW = new bs();
    private bw fCB = new bw();
    private ArrayList<PostData> kwX = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private av page = new av();
    private AntiData anti = new AntiData();
    private com.baidu.tbadk.data.f kwY = new com.baidu.tbadk.data.f();
    private int kwZ = 0;
    private final UserData userData = new UserData();
    private List<MuteUser> kxe = new ArrayList();
    private ay kxc = new ay();
    private az kxg = new az();
    private am kxd = new am();
    private r kxo = new r();
    private z kxG = new z();
    private List<bm.a> kxv = new ArrayList();
    private HashSet<String> kxw = new HashSet<>();

    public f() {
        this.kxb = 0;
        this.kxl = null;
        this.kxb = 0;
        this.kxl = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.kwX != null && this.kwX.size() > 0;
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
            int size = this.kwX.size() > 30 ? 30 : this.kwX.size();
            if (cVm() == null || cVm().beE() == null || at.isEmpty(cVm().beE().getUserId())) {
                return new String[]{null, ""};
            }
            String userId = cVm().beE().getUserId();
            PostData cVw = cVw();
            if (cVw == null || cVw.beE() == null || at.isEmpty(cVw.beE().getUserId())) {
                str2 = "";
            } else {
                if (!at.equals(userId, cVw.beE().getUserId())) {
                    str4 = null;
                } else {
                    str4 = cVw.dwR();
                }
                if (!at.isEmpty("")) {
                    str5 = str4;
                    str2 = "";
                } else {
                    str5 = str4;
                    str2 = cVw.dwP();
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
                    PostData postData = (PostData) y.getItem(this.kwX, i);
                    if (postData != null && postData.beE() != null && !at.isEmpty(postData.beE().getUserId()) && at.equals(userId, postData.beE().getUserId())) {
                        if (at.isEmpty(str5)) {
                            str5 = postData.dwR();
                        }
                        String dwP = at.isEmpty(str6) ? postData.dwP() : str6;
                        if (!at.isEmpty(str5) && !at.isEmpty(dwP)) {
                            str = dwP;
                            str3 = str5;
                            break;
                        }
                        str6 = dwP;
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
            if (this.fCB != null && this.fCB.bfE() != null && this.fCB.bfE().getGroup_id() != 0) {
                str = "[" + context.getString(R.string.photo_live_tips) + "] " + str;
            }
            str5 = (this.fCB == null || this.fCB.beW() == null || at.isEmpty(this.fCB.beW().thumbnail_url)) ? str3 : this.fCB.beW().thumbnail_url;
            if (this.fCB != null && !this.fCB.isShareThread && str5 == null && this.fCB.edI != null && this.fCB.edI.dZg != null) {
                ArrayList<MediaData> arrayList = this.fCB.edI.dZg;
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

    public bs cVl() {
        return this.kwW;
    }

    public void d(bs bsVar) {
        this.kwW = bsVar;
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

    public bw cVm() {
        return this.fCB;
    }

    public void aE(bw bwVar) {
        this.fCB = bwVar;
    }

    public List<bw> cVn() {
        return this.kxh;
    }

    public String getThreadId() {
        if (this.fCB == null) {
            return "";
        }
        return this.fCB.getId();
    }

    public ArrayList<PostData> cVo() {
        return this.kwX;
    }

    public av getPage() {
        return this.page;
    }

    public am cVp() {
        return this.kxd;
    }

    public az cVq() {
        return this.kxg;
    }

    public z cVr() {
        if (this.kxG == null || !this.kxG.isValid()) {
            return null;
        }
        return this.kxG;
    }

    public ac cVs() {
        if (this.kxH == null || !this.kxH.isValid()) {
            return null;
        }
        return this.kxH;
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
        return this.fCB.beL() != 0;
    }

    public void hB(boolean z) {
        if (this.fCB != null) {
            if (z) {
                this.fCB.nk(1);
            } else {
                this.fCB.nk(0);
            }
        }
    }

    public String baz() {
        if (this.fCB != null) {
            return this.fCB.beM();
        }
        return null;
    }

    public void Nl(String str) {
        if (this.fCB != null) {
            this.fCB.zp(str);
        }
    }

    public String cVt() {
        return this.kxu;
    }

    public boolean cVu() {
        return (this.fCB == null || this.fCB.beO() == null || this.fCB.beO().size() <= 0 || this.fCB.beO().get(0) == null || !this.fCB.beO().get(0).bcu()) ? false : true;
    }

    public PostData cVv() {
        return this.kxA;
    }

    public void d(PostData postData) {
        this.kxA = postData;
        this.kxC = postData;
        this.kxB = false;
    }

    public PostData cVw() {
        return this.kxC;
    }

    public void e(PostData postData) {
        this.kxC = postData;
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                com.baidu.tieba.recapp.d.a.dnZ().PA(dataRes.asp_shown_info);
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
                this.kwW.parserProtobuf(dataRes.display_forum);
                this.fCB.setUserMap(this.userMap);
                this.fCB.a(dataRes.thread);
                this.kxc.a(dataRes.news_info);
                switch (this.kxc.dEk) {
                    case 1:
                        this.kxd.kJh = this.kxc;
                        break;
                    case 2:
                        this.kxd.kJi = this.kxc;
                        break;
                    case 3:
                        this.kxd.kJj = this.kxc;
                        break;
                    default:
                        this.kxd.kJi = this.kxc;
                        break;
                }
                this.kxg.a(dataRes.recommend_book);
                b(dataRes, context);
                this.kxA = new PostData();
                this.kxA.HP(1);
                this.kxA.setUserMap(this.userMap);
                this.kxA.wa(this.forum.isBrandForum);
                this.kxA.setTime(this.fCB.getCreateTime());
                if (dataRes.first_floor_post != null) {
                    this.kxA.a(dataRes.first_floor_post, context);
                }
                if (this.fCB != null && this.fCB.isShareThread) {
                    this.kxA.h(this.fCB.edI);
                }
                if (this.kxC == null) {
                    this.kxC = this.kxA;
                    this.kxB = true;
                }
                this.page.a(dataRes.page);
                this.anti.parserProtobuf(dataRes.anti);
                this.kwY.a(dataRes.location);
                if (dataRes.user != null) {
                    this.kwZ = dataRes.user.is_manager.intValue();
                }
                this.userData.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.kxe.add(muteUser);
                        }
                    }
                }
                this.fCB.ng(this.fCB.bev() > 0 ? this.fCB.bev() - 1 : 0);
                List<AppData> dni = com.baidu.tieba.recapp.r.dnk().dni();
                if (dni != null) {
                    dni.clear();
                }
                this.kxk = null;
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        com.baidu.tieba.tbadkCore.data.n nVar = new com.baidu.tieba.tbadkCore.data.n();
                        nVar.d(app);
                        AppData dwy = nVar.dwy();
                        if (!this.kxj.contains(nVar) && dwy.goods != null && (!StringUtils.isNull(dwy.goods.user_name) || !StringUtils.isNull(dwy.goods.lego_card))) {
                            nVar.kMj = cVM();
                            this.kxj.add(nVar);
                            if (dni != null) {
                                dni.add(nVar.dwy());
                            }
                        }
                    }
                    c(dataRes);
                    d(dataRes);
                }
                com.baidu.tieba.recapp.r.dnk().dnj();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.userData.getIsSelectTail());
                }
                this.kxl.parserProtobuf(dataRes.twzhibo_anti);
                this.kwI = dataRes.appeal_info;
                if (dataRes.forum_headline_img_info != null) {
                    this.kxq = new i();
                    this.kxq.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.guess_like != null) {
                    this.kwK = new CardHListViewData();
                    this.kwK.parseProtobuf(dataRes.guess_like);
                }
                b(dataRes);
                if (y.getCount(dataRes.repost_recommend_forum_list) > 0) {
                    if (this.kxm == null) {
                        this.kxm = new ArrayList();
                    }
                    for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                        bs bsVar = new bs();
                        bsVar.parserProtobuf(simpleForum);
                        this.kxm.add(bsVar);
                    }
                }
                if (y.getCount(dataRes.from_forum_list) > 0) {
                    if (this.kxn == null) {
                        this.kxn = new ArrayList();
                    }
                    for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                        if (simpleForum2 != null) {
                            bs bsVar2 = new bs();
                            bsVar2.parserProtobuf(simpleForum2);
                            this.kxn.add(bsVar2);
                        }
                    }
                }
                this.kxu = dataRes.multi_forum_text;
                if (this.kxr >= 0) {
                    this.kxr = dataRes.thread_freq_num.longValue();
                }
                a(dataRes);
                if (this.kxx == null) {
                    this.kxx = new ArrayList();
                }
                this.kxx.clear();
                if (dataRes.bjh_recommend != null) {
                    int i2 = 1;
                    for (ThreadInfo threadInfo : dataRes.bjh_recommend) {
                        if (threadInfo != null && !d(threadInfo) && !e(threadInfo)) {
                            com.baidu.tbadk.core.data.n nVar2 = new com.baidu.tbadk.core.data.n();
                            nVar2.setFloorNum(i2);
                            nVar2.a(threadInfo);
                            this.kxx.add(nVar2);
                            i2++;
                        }
                    }
                }
                if (this.kxz != null && this.kxz.dff()) {
                    this.kxz = null;
                }
                if (dataRes.recom_ala_info != null && dataRes.recom_ala_info.live_status.intValue() == 1 && dataRes.recom_ala_info.pb_display_type.intValue() == 2) {
                    if (this.kxz == null) {
                        this.kxz = new com.baidu.tieba.pb.videopb.c.a();
                        this.kxz.parserProtoBuf(dataRes.recom_ala_info);
                    }
                } else if (this.kxz == null && dataRes.promotion != null) {
                    this.kxz = new com.baidu.tieba.pb.videopb.c.a();
                    this.kxz.a(dataRes.promotion);
                }
                if (dataRes.business_promot_info != null) {
                    this.kwR = dataRes.business_promot_info.is_promot.longValue() == 1;
                    this.kwS = dataRes.business_promot_info.is_headlinepost.intValue() == 1;
                    this.kwT = dataRes.business_promot_info.is_s_card.intValue() == 1;
                    if (dataRes.business_promot_info.send_card_info != null) {
                        b bVar = new b();
                        bVar.a(dataRes.business_promot_info.send_card_info);
                        if (this.kwU == null) {
                            this.kwU = new a();
                        }
                        this.kwU.a(bVar);
                    }
                }
                this.kxG.reset();
                this.kxG.setUserMap(this.userMap);
                this.kxG.a(dataRes.recom_ala_info);
                if (this.kxG.kGa != null) {
                    this.kxG.kGa.setTid(getThreadId());
                }
                this.kxH = new ac();
                this.kxH.setUserMap(this.userMap);
                this.kxH.a(dataRes.recom_ala_info);
                if (this.kxH.kGa != null) {
                    this.kxH.kGa.setTid(getThreadId());
                }
                this.kxI = dataRes.jumptotab1 == null ? null : dataRes.jumptotab1.toString();
                this.kxJ = dataRes.jumptotab2;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    private void b(DataRes dataRes, Context context) {
        List<Post> list = dataRes.post_list;
        if (list != null && list.size() > 0) {
            for (Post post : dataRes.post_list) {
                if (!this.kxw.contains(String.valueOf(post.id))) {
                    PostData postData = new PostData();
                    postData.setUserMap(this.userMap);
                    postData.wa(this.forum.isBrandForum);
                    postData.a(post, context);
                    postData.a(cVm().bep());
                    if (postData.bgv() != null && postData.bgv().baijiahaoData == null && cVm() != null && cVm().getBaijiahaoData() != null) {
                        postData.bgv().baijiahaoData = cVm().getBaijiahaoData();
                    }
                    this.kxw.add(postData.getId());
                    if (postData.dwK() == 1 && this.fCB.bfs()) {
                        if (cVu()) {
                            postData.setPostType(0);
                        } else {
                            postData.setPostType(this.fCB.bfr());
                        }
                    } else if (postData.dwK() == 1 && this.fCB.bfM()) {
                        postData.setPostType(41);
                    } else if (postData.dwK() == 1 && this.fCB != null && this.fCB.bdk()) {
                        postData.setPostType(0);
                        postData.bxH();
                        if (this.fCB.beC() == null || this.fCB.beC().size() == 0) {
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
                            postData.c(new TbRichText((Context) TbadkCoreApplication.getInst(), this.fCB.beC(), true));
                        }
                        this.kxp = postData;
                    }
                    if (postData.dwK() == 1 && this.fCB != null && this.fCB.isShareThread) {
                        postData.h(this.fCB.edI);
                    }
                    if (postData.dwK() == 1) {
                        this.kxC = postData;
                        this.kxB = false;
                    }
                    this.kwX.add(postData);
                }
            }
        }
    }

    private void a(DataRes dataRes) {
        this.kxs = new o(this.fCB, this.anti);
        this.kwL = dataRes.partial_visible_toast;
        if (dataRes.follow_tip != null && dataRes.follow_tip.is_toast_tip.intValue() == 1) {
            this.kxa = dataRes.follow_tip.tip_text;
        }
        this.kxi = new AlaLiveInfoCoreData();
        if (dataRes.ala_info != null) {
            this.kxi.parserProtoBuf(dataRes.ala_info);
        }
        this.kxt = dataRes.fold_tip;
        this.kwM = dataRes.exp_news_today.intValue();
        this.kwN = dataRes.exp_guide_today.intValue();
        if (!y.isEmpty(dataRes.thread_topic)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= dataRes.thread_topic.size()) {
                    break;
                }
                bm.a aVar = new bm.a();
                aVar.a(dataRes.thread_topic.get(i2));
                this.kxv.add(aVar);
                i = i2 + 1;
            }
        }
        this.kwO = dataRes.pb_sort_info;
        this.kwP = dataRes.sort_type.intValue();
        if (dataRes.manager_election != null) {
            this.kwQ = k.b(dataRes.manager_election);
        }
    }

    private void b(DataRes dataRes) {
        if (dataRes.feed_thread_list != null && dataRes.feed_thread_list.size() > 0) {
            List<ThreadInfo> list = dataRes.feed_thread_list;
            if (this.kxh == null) {
                this.kxh = new ArrayList();
            }
            this.kxh.clear();
            for (ThreadInfo threadInfo : list) {
                if (threadInfo != null) {
                    bw bwVar = new bw();
                    bwVar.a(threadInfo);
                    this.kxh.add(bwVar);
                }
            }
            if (this.kxh != null && this.kxh.size() > 15) {
                this.kxh = y.subList(this.kxh, 0, 15);
            }
        }
    }

    private void c(DataRes dataRes) {
        List<String> yZ;
        App app = dataRes.banner_list.pb_banner_ad;
        com.baidu.tieba.tbadkCore.data.n nVar = new com.baidu.tieba.tbadkCore.data.n();
        nVar.meZ = true;
        nVar.d(app);
        AppData dwy = nVar.dwy();
        if (dwy.goods != null) {
            if (y.isEmpty(dwy.goods.thread_pic_list) && (yZ = AdvertAppInfo.a.yZ(dwy.goods.lego_card)) != null && dwy.goods.thread_pic_list != null) {
                dwy.goods.thread_pic_list.addAll(yZ);
            }
            this.kxk = nVar;
        }
    }

    private void d(DataRes dataRes) {
        List<App> list = dataRes.banner_list.video_recommend_ad;
        this.kxF.clear();
        if (list != null && !list.isEmpty()) {
            for (App app : list) {
                com.baidu.tieba.tbadkCore.data.n nVar = new com.baidu.tieba.tbadkCore.data.n();
                nVar.d(app);
                AppData dwy = nVar.dwy();
                if (!this.kxF.contains(nVar) && dwy.goods != null && (!StringUtils.isNull(dwy.goods.user_name) || !StringUtils.isNull(dwy.goods.lego_card))) {
                    nVar.kMj = cVM();
                    this.kxF.add(nVar);
                }
            }
        }
    }

    public String cVx() {
        return this.kxt;
    }

    public CardHListViewData cVy() {
        return this.kwK;
    }

    public PostData cVz() {
        return this.kxp;
    }

    public PostData f(PostData postData) {
        this.kxp = postData;
        return postData;
    }

    public r cVA() {
        return this.kxo;
    }

    public int cVB() {
        return this.kwZ;
    }

    public int getIsNewUrl() {
        return this.kxb;
    }

    public void setIsNewUrl(int i) {
        this.kxb = i;
    }

    public List<MuteUser> cVC() {
        return this.kxe;
    }

    public ArrayList<com.baidu.tieba.tbadkCore.data.n> cVD() {
        return this.kxj;
    }

    public com.baidu.tieba.tbadkCore.data.n cVE() {
        return this.kxk;
    }

    public void b(com.baidu.tieba.tbadkCore.data.n nVar) {
        this.kxk = nVar;
    }

    public void cVF() {
        if (this.kxk.dwy() != null) {
            this.kxk.dwy().legoCard = null;
        }
        this.kxk = null;
    }

    public void cVG() {
        this.kxG = null;
        this.kxH = null;
    }

    public String cVH() {
        return this.kwJ;
    }

    public void Nm(String str) {
        this.kwJ = str;
    }

    public i cVI() {
        return this.kxq;
    }

    public List<bs> cVJ() {
        return this.kxn;
    }

    public long cVK() {
        return this.kxr;
    }

    public o cVL() {
        return this.kxs;
    }

    public void a(o oVar) {
        this.kxs = oVar;
    }

    public boolean cVM() {
        return (cVm() == null || !cVm().bdk() || cVm().beW() == null) ? false : true;
    }

    public AlaLiveInfoCoreData cVN() {
        return this.kxi;
    }

    public List<com.baidu.tbadk.core.data.n> cVO() {
        return this.kxx;
    }

    public boolean cVP() {
        return cVm() != null && cVm().bdo();
    }

    public String cVQ() {
        if (this.kwO != null && this.kwO.size() > this.kwP) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.kwO.size()) {
                    break;
                } else if (this.kwO.get(i2).sort_type.intValue() != this.kwP) {
                    i = i2 + 1;
                } else {
                    return this.kwO.get(i2).sort_name;
                }
            }
        }
        return "";
    }

    public com.baidu.tieba.pb.videopb.c.a cVR() {
        return this.kxz;
    }

    public int cVS() {
        return this.kxy;
    }

    public void DP(int i) {
        this.kxy = i;
    }

    public List<com.baidu.tieba.tbadkCore.data.n> cVT() {
        return this.kxF;
    }

    private boolean d(ThreadInfo threadInfo) {
        if (threadInfo == null || getThreadId() == null || "0".equals(threadInfo.id) || "0".equals(threadInfo.tid)) {
            return false;
        }
        return getThreadId().equals(threadInfo.id) || getThreadId().equals(threadInfo.tid);
    }

    private boolean e(ThreadInfo threadInfo) {
        if (threadInfo == null || threadInfo.baijiahao == null || threadInfo.baijiahao.ori_ugc_nid == null || this.fCB == null || this.fCB.getBaijiahaoData() == null || this.fCB.getBaijiahaoData().oriUgcNid == null || "0".equals(threadInfo.baijiahao.ori_ugc_nid)) {
            return false;
        }
        return threadInfo.baijiahao.ori_ugc_nid.equals(this.fCB.getBaijiahaoData().oriUgcNid);
    }
}

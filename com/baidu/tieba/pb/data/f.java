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
    public AppealInfo lmN;
    public String lmO;
    public CardHListViewData lmP;
    public String lmQ;
    public int lmR;
    public int lmS;
    public List<PbSortType> lmT;
    public int lmU;
    public k lmV;
    public a lmZ;
    private List<com.baidu.tbadk.core.data.n> lnC;
    private com.baidu.tieba.pb.videopb.c.a lnE;
    private PostData lnF;
    private PostData lnH;
    public boolean lnJ;
    private ac lnM;
    public String lnN;
    public String lnO;
    private String lne;
    private int lnf;
    private List<bw> lnm;
    private AlaLiveInfoCoreData lnn;
    private TwzhiboAnti lnq;
    private List<bs> lnr;
    private List<bs> lns;
    private PostData lnu;
    private i lnv;
    private long lnw;
    private o lnx;
    private String lny;
    private String lnz;
    public boolean lmW = false;
    public boolean lmX = false;
    public boolean lmY = false;
    public boolean lna = false;
    private boolean lnk = true;
    private ArrayList<com.baidu.tieba.tbadkCore.data.n> lno = new ArrayList<>();
    private com.baidu.tieba.tbadkCore.data.n lnp = null;
    private int lnD = 0;
    public boolean lnG = true;
    public int lnI = 0;
    public int YH = 0;
    private List<com.baidu.tieba.tbadkCore.data.n> lnK = new ArrayList();
    private ForumData forum = new ForumData();
    private bs lnb = new bs();
    private bw ghO = new bw();
    private ArrayList<PostData> lnc = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private av page = new av();
    private AntiData anti = new AntiData();
    private com.baidu.tbadk.data.f lnd = new com.baidu.tbadk.data.f();
    private int userIdentity = 0;
    private final UserData userData = new UserData();
    private List<MuteUser> lnj = new ArrayList();
    private ay lnh = new ay();
    private az lnl = new az();
    private am lni = new am();
    private r lnt = new r();
    private z lnL = new z();
    private List<bm.a> lnA = new ArrayList();
    private HashSet<String> lnB = new HashSet<>();

    public f() {
        this.lnf = 0;
        this.lnq = null;
        this.lnf = 0;
        this.lnq = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.lnc != null && this.lnc.size() > 0;
    }

    public String[] fJ(Context context) {
        return s(context, true);
    }

    public String[] s(Context context, boolean z) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5 = null;
        if (!isValid()) {
            str = "";
        } else {
            int size = this.lnc.size() > 30 ? 30 : this.lnc.size();
            if (dik() == null || dik().bmA() == null || at.isEmpty(dik().bmA().getUserId())) {
                return new String[]{null, ""};
            }
            String userId = dik().bmA().getUserId();
            PostData diu = diu();
            if (diu == null || diu.bmA() == null || at.isEmpty(diu.bmA().getUserId())) {
                str2 = "";
            } else {
                if (!at.equals(userId, diu.bmA().getUserId())) {
                    str4 = null;
                } else {
                    str4 = diu.dKg();
                }
                if (!at.isEmpty("")) {
                    str5 = str4;
                    str2 = "";
                } else {
                    str5 = str4;
                    str2 = diu.dKe();
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
                    PostData postData = (PostData) y.getItem(this.lnc, i);
                    if (postData != null && postData.bmA() != null && !at.isEmpty(postData.bmA().getUserId()) && at.equals(userId, postData.bmA().getUserId())) {
                        if (at.isEmpty(str5)) {
                            str5 = postData.dKg();
                        }
                        String dKe = at.isEmpty(str6) ? postData.dKe() : str6;
                        if (!at.isEmpty(str5) && !at.isEmpty(dKe)) {
                            str = dKe;
                            str3 = str5;
                            break;
                        }
                        str6 = dKe;
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
            if (this.ghO != null && this.ghO.bnA() != null && this.ghO.bnA().getGroup_id() != 0) {
                str = "[" + context.getString(R.string.photo_live_tips) + "] " + str;
            }
            str5 = (this.ghO == null || this.ghO.bmS() == null || at.isEmpty(this.ghO.bmS().thumbnail_url)) ? str3 : this.ghO.bmS().thumbnail_url;
            if (this.ghO != null && !this.ghO.isShareThread && str5 == null && this.ghO.eGn != null && this.ghO.eGn.eBL != null) {
                ArrayList<MediaData> arrayList = this.ghO.eGn.eBL;
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

    public bs dij() {
        return this.lnb;
    }

    public void d(bs bsVar) {
        this.lnb = bsVar;
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

    public bw dik() {
        return this.ghO;
    }

    public void aF(bw bwVar) {
        this.ghO = bwVar;
    }

    public List<bw> dil() {
        return this.lnm;
    }

    public String getThreadId() {
        if (this.ghO == null) {
            return "";
        }
        return this.ghO.getId();
    }

    public ArrayList<PostData> dim() {
        return this.lnc;
    }

    public av getPage() {
        return this.page;
    }

    public am din() {
        return this.lni;
    }

    public az dio() {
        return this.lnl;
    }

    public z dip() {
        if (this.lnL == null || !this.lnL.isValid()) {
            return null;
        }
        return this.lnL;
    }

    public ac diq() {
        if (this.lnM == null || !this.lnM.isValid()) {
            return null;
        }
        return this.lnM;
    }

    public void a(av avVar, int i) {
        this.page.oa(avVar.blo());
        this.page.nY(avVar.bkp());
        this.page.nX(avVar.bll());
        this.page.ob(avVar.blp());
        this.page.nZ(avVar.bln());
        if (i == 0) {
            this.page = avVar;
        } else if (i == 1) {
            this.page.oc(avVar.blq());
        } else if (i == 2) {
            this.page.od(avVar.blr());
        }
    }

    public AntiData getAnti() {
        return this.anti;
    }

    public UserData getUserData() {
        return this.userData;
    }

    public boolean biv() {
        return this.ghO.bmH() != 0;
    }

    public void iq(boolean z) {
        if (this.ghO != null) {
            if (z) {
                this.ghO.on(1);
            } else {
                this.ghO.on(0);
            }
        }
    }

    public String biu() {
        if (this.ghO != null) {
            return this.ghO.bmI();
        }
        return null;
    }

    public void Pr(String str) {
        if (this.ghO != null) {
            this.ghO.Bd(str);
        }
    }

    public String dir() {
        return this.lnz;
    }

    public boolean dis() {
        return (this.ghO == null || this.ghO.bmK() == null || this.ghO.bmK().size() <= 0 || this.ghO.bmK().get(0) == null || !this.ghO.bmK().get(0).bkq()) ? false : true;
    }

    public PostData dit() {
        return this.lnF;
    }

    public void d(PostData postData) {
        this.lnF = postData;
        this.lnH = postData;
        this.lnG = false;
    }

    public PostData diu() {
        return this.lnH;
    }

    public void e(PostData postData) {
        this.lnH = postData;
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                com.baidu.tieba.recapp.d.a.dBc().RD(dataRes.asp_shown_info);
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
                this.lnb.parserProtobuf(dataRes.display_forum);
                this.ghO.setUserMap(this.userMap);
                this.ghO.a(dataRes.thread);
                this.lnh.a(dataRes.news_info);
                switch (this.lnh.egA) {
                    case 1:
                        this.lni.lzu = this.lnh;
                        break;
                    case 2:
                        this.lni.lzv = this.lnh;
                        break;
                    case 3:
                        this.lni.lzw = this.lnh;
                        break;
                    default:
                        this.lni.lzv = this.lnh;
                        break;
                }
                this.lnl.a(dataRes.recommend_book);
                b(dataRes, context);
                this.lnF = new PostData();
                this.lnF.JD(1);
                this.lnF.setUserMap(this.userMap);
                this.lnF.xq(this.forum.isBrandForum);
                this.lnF.setTime(this.ghO.getCreateTime());
                if (dataRes.first_floor_post != null) {
                    this.lnF.a(dataRes.first_floor_post, context);
                }
                if (this.ghO != null && this.ghO.isShareThread) {
                    this.lnF.h(this.ghO.eGn);
                }
                if (this.lnH == null) {
                    this.lnH = this.lnF;
                    this.lnG = true;
                }
                this.page.a(dataRes.page);
                this.anti.parserProtobuf(dataRes.anti);
                this.lnd.a(dataRes.location);
                if (dataRes.user != null) {
                    this.userIdentity = dataRes.user.is_manager.intValue();
                }
                this.userData.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.lnj.add(muteUser);
                        }
                    }
                }
                this.ghO.oj(this.ghO.bmr() > 0 ? this.ghO.bmr() - 1 : 0);
                List<AppData> dAm = com.baidu.tieba.recapp.r.dAo().dAm();
                if (dAm != null) {
                    dAm.clear();
                }
                this.lnp = null;
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        com.baidu.tieba.tbadkCore.data.n nVar = new com.baidu.tieba.tbadkCore.data.n();
                        nVar.d(app);
                        AppData dJN = nVar.dJN();
                        if (!this.lno.contains(nVar) && dJN.goods != null && (!StringUtils.isNull(dJN.goods.user_name) || !StringUtils.isNull(dJN.goods.lego_card))) {
                            nVar.lCw = diK();
                            this.lno.add(nVar);
                            if (dAm != null) {
                                dAm.add(nVar.dJN());
                            }
                        }
                    }
                    c(dataRes);
                    d(dataRes);
                }
                com.baidu.tieba.recapp.r.dAo().dAn();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.userData.getIsSelectTail());
                }
                this.lnq.parserProtobuf(dataRes.twzhibo_anti);
                this.lmN = dataRes.appeal_info;
                if (dataRes.forum_headline_img_info != null) {
                    this.lnv = new i();
                    this.lnv.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.guess_like != null) {
                    this.lmP = new CardHListViewData();
                    this.lmP.parseProtobuf(dataRes.guess_like);
                }
                b(dataRes);
                if (y.getCount(dataRes.repost_recommend_forum_list) > 0) {
                    if (this.lnr == null) {
                        this.lnr = new ArrayList();
                    }
                    for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                        bs bsVar = new bs();
                        bsVar.parserProtobuf(simpleForum);
                        this.lnr.add(bsVar);
                    }
                }
                if (y.getCount(dataRes.from_forum_list) > 0) {
                    if (this.lns == null) {
                        this.lns = new ArrayList();
                    }
                    for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                        if (simpleForum2 != null) {
                            bs bsVar2 = new bs();
                            bsVar2.parserProtobuf(simpleForum2);
                            this.lns.add(bsVar2);
                        }
                    }
                }
                this.lnz = dataRes.multi_forum_text;
                if (this.lnw >= 0) {
                    this.lnw = dataRes.thread_freq_num.longValue();
                }
                a(dataRes);
                if (this.lnC == null) {
                    this.lnC = new ArrayList();
                }
                this.lnC.clear();
                if (dataRes.bjh_recommend != null) {
                    int i2 = 1;
                    for (ThreadInfo threadInfo : dataRes.bjh_recommend) {
                        if (threadInfo != null && !d(threadInfo) && !e(threadInfo)) {
                            com.baidu.tbadk.core.data.n nVar2 = new com.baidu.tbadk.core.data.n();
                            nVar2.setFloorNum(i2);
                            nVar2.a(threadInfo);
                            this.lnC.add(nVar2);
                            i2++;
                        }
                    }
                }
                if (this.lnE != null && this.lnE.dsc()) {
                    this.lnE = null;
                }
                if (dataRes.recom_ala_info != null && dataRes.recom_ala_info.live_status.intValue() == 1 && dataRes.recom_ala_info.pb_display_type.intValue() == 2) {
                    if (this.lnE == null) {
                        this.lnE = new com.baidu.tieba.pb.videopb.c.a();
                        this.lnE.parserProtoBuf(dataRes.recom_ala_info);
                    }
                } else if (this.lnE == null && dataRes.promotion != null) {
                    this.lnE = new com.baidu.tieba.pb.videopb.c.a();
                    this.lnE.a(dataRes.promotion);
                }
                if (dataRes.business_promot_info != null) {
                    this.lmW = dataRes.business_promot_info.is_promot.longValue() == 1;
                    this.lmX = dataRes.business_promot_info.is_headlinepost.intValue() == 1;
                    this.lmY = dataRes.business_promot_info.is_s_card.intValue() == 1;
                    if (dataRes.business_promot_info.send_card_info != null) {
                        b bVar = new b();
                        bVar.a(dataRes.business_promot_info.send_card_info);
                        if (this.lmZ == null) {
                            this.lmZ = new a();
                        }
                        this.lmZ.a(bVar);
                    }
                }
                this.lnL.reset();
                this.lnL.setUserMap(this.userMap);
                this.lnL.a(dataRes.recom_ala_info);
                if (this.lnL.lwl != null) {
                    this.lnL.lwl.setTid(getThreadId());
                }
                this.lnM = new ac();
                this.lnM.setUserMap(this.userMap);
                this.lnM.a(dataRes.recom_ala_info);
                if (this.lnM.lwl != null) {
                    this.lnM.lwl.setTid(getThreadId());
                }
                this.lnN = dataRes.jumptotab1 == null ? null : dataRes.jumptotab1.toString();
                this.lnO = dataRes.jumptotab2;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    private void b(DataRes dataRes, Context context) {
        List<Post> list = dataRes.post_list;
        if (list != null && list.size() > 0) {
            for (Post post : dataRes.post_list) {
                if (!this.lnB.contains(String.valueOf(post.id))) {
                    PostData postData = new PostData();
                    postData.setUserMap(this.userMap);
                    postData.xq(this.forum.isBrandForum);
                    postData.a(post, context);
                    postData.a(dik().bml());
                    if (postData.bor() != null && postData.bor().baijiahaoData == null && dik() != null && dik().getBaijiahaoData() != null) {
                        postData.bor().baijiahaoData = dik().getBaijiahaoData();
                    }
                    this.lnB.add(postData.getId());
                    if (postData.dJZ() == 1 && this.ghO.bno()) {
                        if (dis()) {
                            postData.setPostType(0);
                        } else {
                            postData.setPostType(this.ghO.bnn());
                        }
                    } else if (postData.dJZ() == 1 && this.ghO.bnI()) {
                        postData.setPostType(41);
                    } else if (postData.dJZ() == 1 && this.ghO != null && this.ghO.blg()) {
                        postData.setPostType(0);
                        postData.bFS();
                        if (this.ghO.bmy() == null || this.ghO.bmy().size() == 0) {
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
                            postData.c(new TbRichText((Context) TbadkCoreApplication.getInst(), this.ghO.bmy(), true));
                        }
                        this.lnu = postData;
                    }
                    if (postData.dJZ() == 1 && this.ghO != null && this.ghO.isShareThread) {
                        postData.h(this.ghO.eGn);
                    }
                    if (postData.dJZ() == 1) {
                        this.lnH = postData;
                        this.lnG = false;
                    }
                    this.lnc.add(postData);
                }
            }
        }
    }

    private void a(DataRes dataRes) {
        this.lnx = new o(this.ghO, this.anti);
        this.lmQ = dataRes.partial_visible_toast;
        if (dataRes.follow_tip != null && dataRes.follow_tip.is_toast_tip.intValue() == 1) {
            this.lne = dataRes.follow_tip.tip_text;
        }
        this.lnn = new AlaLiveInfoCoreData();
        if (dataRes.ala_info != null) {
            this.lnn.parserProtoBuf(dataRes.ala_info);
        }
        this.lny = dataRes.fold_tip;
        this.lmR = dataRes.exp_news_today.intValue();
        this.lmS = dataRes.exp_guide_today.intValue();
        if (!y.isEmpty(dataRes.thread_topic)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= dataRes.thread_topic.size()) {
                    break;
                }
                bm.a aVar = new bm.a();
                aVar.a(dataRes.thread_topic.get(i2));
                this.lnA.add(aVar);
                i = i2 + 1;
            }
        }
        this.lmT = dataRes.pb_sort_info;
        this.lmU = dataRes.sort_type.intValue();
        if (dataRes.manager_election != null) {
            this.lmV = k.b(dataRes.manager_election);
        }
    }

    private void b(DataRes dataRes) {
        if (dataRes.feed_thread_list != null && dataRes.feed_thread_list.size() > 0) {
            List<ThreadInfo> list = dataRes.feed_thread_list;
            if (this.lnm == null) {
                this.lnm = new ArrayList();
            }
            this.lnm.clear();
            for (ThreadInfo threadInfo : list) {
                if (threadInfo != null) {
                    bw bwVar = new bw();
                    bwVar.a(threadInfo);
                    this.lnm.add(bwVar);
                }
            }
            if (this.lnm != null && this.lnm.size() > 15) {
                this.lnm = y.subList(this.lnm, 0, 15);
            }
        }
    }

    private void c(DataRes dataRes) {
        List<String> AN;
        App app = dataRes.banner_list.pb_banner_ad;
        com.baidu.tieba.tbadkCore.data.n nVar = new com.baidu.tieba.tbadkCore.data.n();
        nVar.mWO = true;
        nVar.d(app);
        AppData dJN = nVar.dJN();
        if (dJN.goods != null) {
            if (y.isEmpty(dJN.goods.thread_pic_list) && (AN = AdvertAppInfo.a.AN(dJN.goods.lego_card)) != null && dJN.goods.thread_pic_list != null) {
                dJN.goods.thread_pic_list.addAll(AN);
            }
            this.lnp = nVar;
        }
    }

    private void d(DataRes dataRes) {
        List<App> list = dataRes.banner_list.video_recommend_ad;
        this.lnK.clear();
        if (list != null && !list.isEmpty()) {
            for (App app : list) {
                com.baidu.tieba.tbadkCore.data.n nVar = new com.baidu.tieba.tbadkCore.data.n();
                nVar.d(app);
                AppData dJN = nVar.dJN();
                if (!this.lnK.contains(nVar) && dJN.goods != null && (!StringUtils.isNull(dJN.goods.user_name) || !StringUtils.isNull(dJN.goods.lego_card))) {
                    nVar.lCw = diK();
                    this.lnK.add(nVar);
                }
            }
        }
    }

    public String div() {
        return this.lny;
    }

    public CardHListViewData diw() {
        return this.lmP;
    }

    public PostData dix() {
        return this.lnu;
    }

    public PostData f(PostData postData) {
        this.lnu = postData;
        return postData;
    }

    public r diy() {
        return this.lnt;
    }

    public int diz() {
        return this.userIdentity;
    }

    public int getIsNewUrl() {
        return this.lnf;
    }

    public void setIsNewUrl(int i) {
        this.lnf = i;
    }

    public List<MuteUser> diA() {
        return this.lnj;
    }

    public ArrayList<com.baidu.tieba.tbadkCore.data.n> diB() {
        return this.lno;
    }

    public com.baidu.tieba.tbadkCore.data.n diC() {
        return this.lnp;
    }

    public void b(com.baidu.tieba.tbadkCore.data.n nVar) {
        this.lnp = nVar;
    }

    public void diD() {
        if (this.lnp.dJN() != null) {
            this.lnp.dJN().legoCard = null;
        }
        this.lnp = null;
    }

    public void diE() {
        this.lnL = null;
        this.lnM = null;
    }

    public String diF() {
        return this.lmO;
    }

    public void Ps(String str) {
        this.lmO = str;
    }

    public i diG() {
        return this.lnv;
    }

    public List<bs> diH() {
        return this.lns;
    }

    public long diI() {
        return this.lnw;
    }

    public o diJ() {
        return this.lnx;
    }

    public void a(o oVar) {
        this.lnx = oVar;
    }

    public boolean diK() {
        return (dik() == null || !dik().blg() || dik().bmS() == null) ? false : true;
    }

    public AlaLiveInfoCoreData diL() {
        return this.lnn;
    }

    public List<com.baidu.tbadk.core.data.n> diM() {
        return this.lnC;
    }

    public boolean diN() {
        return dik() != null && dik().blk();
    }

    public String diO() {
        if (this.lmT != null && this.lmT.size() > this.lmU) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.lmT.size()) {
                    break;
                } else if (this.lmT.get(i2).sort_type.intValue() != this.lmU) {
                    i = i2 + 1;
                } else {
                    return this.lmT.get(i2).sort_name;
                }
            }
        }
        return "";
    }

    public com.baidu.tieba.pb.videopb.c.a diP() {
        return this.lnE;
    }

    public int diQ() {
        return this.lnD;
    }

    public void FC(int i) {
        this.lnD = i;
    }

    public List<com.baidu.tieba.tbadkCore.data.n> diR() {
        return this.lnK;
    }

    private boolean d(ThreadInfo threadInfo) {
        if (threadInfo == null || getThreadId() == null || "0".equals(threadInfo.id) || "0".equals(threadInfo.tid)) {
            return false;
        }
        return getThreadId().equals(threadInfo.id) || getThreadId().equals(threadInfo.tid);
    }

    private boolean e(ThreadInfo threadInfo) {
        if (threadInfo == null || threadInfo.baijiahao == null || threadInfo.baijiahao.ori_ugc_nid == null || this.ghO == null || this.ghO.getBaijiahaoData() == null || this.ghO.getBaijiahaoData().oriUgcNid == null || "0".equals(threadInfo.baijiahao.ori_ugc_nid)) {
            return false;
        }
        return threadInfo.baijiahao.ori_ugc_nid.equals(this.ghO.getBaijiahaoData().oriUgcNid);
    }
}

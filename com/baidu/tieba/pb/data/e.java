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
import com.baidu.tbadk.core.data.ao;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.pb.pb.main.aa;
import com.baidu.tieba.pb.pb.main.ai;
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
import tbclient.PbPage.AppealInfo;
import tbclient.PbPage.DataRes;
import tbclient.PbPage.PbSortType;
import tbclient.Post;
import tbclient.SimpleForum;
import tbclient.SimpleUser;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes9.dex */
public class e {
    public AppealInfo jDP;
    public String jDQ;
    public CardHListViewData jDR;
    public String jDS;
    public int jDT;
    public int jDU;
    public List<PbSortType> jDV;
    public int jDW;
    public i jDX;
    private String jEA;
    private String jEB;
    private List<com.baidu.tbadk.core.data.k> jEE;
    private com.baidu.tieba.pb.videopb.c.a jEG;
    private PostData jEH;
    private PostData jEJ;
    public boolean jEL;
    private aa jEO;
    public String jEP;
    public String jEQ;
    public a jEb;
    private String jEh;
    private int jEi;
    private List<bk> jEo;
    private AlaLiveInfoCoreData jEp;
    private TwzhiboAnti jEs;
    private List<bg> jEt;
    private List<bg> jEu;
    private PostData jEw;
    private h jEx;
    private long jEy;
    private m jEz;
    public boolean jDY = false;
    public boolean jDZ = false;
    public boolean jEa = false;
    public boolean jEc = false;
    private boolean jEm = true;
    private ArrayList<com.baidu.tieba.tbadkCore.data.n> jEq = new ArrayList<>();
    private com.baidu.tieba.tbadkCore.data.n jEr = null;
    private int jEF = 0;
    public boolean jEI = true;
    public int jEK = 0;
    public int WR = 0;
    private List<com.baidu.tieba.tbadkCore.data.n> jEM = new ArrayList();
    private ForumData forum = new ForumData();
    private bg jEd = new bg();
    private bk fay = new bk();
    private ArrayList<PostData> jEe = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private ao page = new ao();
    private AntiData anti = new AntiData();
    private com.baidu.tbadk.data.f jEf = new com.baidu.tbadk.data.f();
    private int jEg = 0;
    private final UserData userData = new UserData();
    private List<MuteUser> jEl = new ArrayList();
    private ar jEj = new ar();
    private as jEn = new as();
    private ai jEk = new ai();
    private p jEv = new p();
    private x jEN = new x();
    private List<bc.a> jEC = new ArrayList();
    private HashSet<String> jED = new HashSet<>();

    public e() {
        this.jEi = 0;
        this.jEs = null;
        this.jEi = 0;
        this.jEs = new TwzhiboAnti();
    }

    public boolean cCg() {
        return this.jEm;
    }

    public void rb(boolean z) {
        this.jEm = z;
    }

    public boolean isValid() {
        return this.jEe != null && this.jEe.size() > 0;
    }

    public String[] fe(Context context) {
        return o(context, true);
    }

    public String[] o(Context context, boolean z) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5 = null;
        if (!isValid()) {
            str = "";
        } else {
            int size = this.jEe.size() > 30 ? 30 : this.jEe.size();
            if (cCi() == null || cCi().aQx() == null || aq.isEmpty(cCi().aQx().getUserId())) {
                return new String[]{null, ""};
            }
            String userId = cCi().aQx().getUserId();
            PostData cCs = cCs();
            if (cCs == null || cCs.aQx() == null || aq.isEmpty(cCs.aQx().getUserId())) {
                str2 = "";
            } else {
                if (!aq.equals(userId, cCs.aQx().getUserId())) {
                    str4 = null;
                } else {
                    str4 = cCs.ddB();
                }
                if (!aq.isEmpty("")) {
                    str5 = str4;
                    str2 = "";
                } else {
                    str5 = str4;
                    str2 = cCs.ddz();
                }
            }
            if (aq.isEmpty(str2) && aq.isEmpty(str5)) {
                int i = 0;
                String str6 = str2;
                while (true) {
                    if (i >= size) {
                        str = str6;
                        str3 = str5;
                        break;
                    }
                    PostData postData = (PostData) v.getItem(this.jEe, i);
                    if (postData != null && postData.aQx() != null && !aq.isEmpty(postData.aQx().getUserId()) && aq.equals(userId, postData.aQx().getUserId())) {
                        if (aq.isEmpty(str5)) {
                            str5 = postData.ddB();
                        }
                        String ddz = aq.isEmpty(str6) ? postData.ddz() : str6;
                        if (!aq.isEmpty(str5) && !aq.isEmpty(ddz)) {
                            str = ddz;
                            str3 = str5;
                            break;
                        }
                        str6 = ddz;
                    }
                    i++;
                }
            } else {
                str = str2;
                str3 = str5;
            }
            if (z && aq.isEmpty(str3)) {
                str3 = "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            }
            if (this.fay != null && this.fay.aRy() != null && this.fay.aRy().getGroup_id() != 0) {
                str = "[" + context.getString(R.string.photo_live_tips) + "] " + str;
            }
            str5 = (this.fay == null || this.fay.aQQ() == null || aq.isEmpty(this.fay.aQQ().thumbnail_url)) ? str3 : this.fay.aQQ().thumbnail_url;
            if (this.fay != null && !this.fay.isShareThread && str5 == null && this.fay.dHm != null && this.fay.dHm.dDc != null) {
                ArrayList<MediaData> arrayList = this.fay.dHm.dDc;
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

    public bg cCh() {
        return this.jEd;
    }

    public void e(bg bgVar) {
        this.jEd = bgVar;
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

    public bk cCi() {
        return this.fay;
    }

    public void aG(bk bkVar) {
        this.fay = bkVar;
    }

    public List<bk> cCj() {
        return this.jEo;
    }

    public String getThreadId() {
        if (this.fay == null) {
            return "";
        }
        return this.fay.getId();
    }

    public ArrayList<PostData> cCk() {
        return this.jEe;
    }

    public ao getPage() {
        return this.page;
    }

    public ai cCl() {
        return this.jEk;
    }

    public as cCm() {
        return this.jEn;
    }

    public x cCn() {
        if (this.jEN == null || !this.jEN.isValid()) {
            return null;
        }
        return this.jEN;
    }

    public aa cCo() {
        if (this.jEO == null || !this.jEO.isValid()) {
            return null;
        }
        return this.jEO;
    }

    public void a(ao aoVar, int i) {
        this.page.kj(aoVar.aPr());
        this.page.kh(aoVar.aOw());
        this.page.kg(aoVar.aPo());
        this.page.kk(aoVar.aPs());
        this.page.ki(aoVar.aPq());
        if (i == 0) {
            this.page = aoVar;
        } else if (i == 1) {
            this.page.kl(aoVar.aPt());
        } else if (i == 2) {
            this.page.km(aoVar.aPu());
        }
    }

    public AntiData getAnti() {
        return this.anti;
    }

    public UserData getUserData() {
        return this.userData;
    }

    public boolean aML() {
        return this.fay.aQF() != 0;
    }

    public void gC(boolean z) {
        if (this.fay != null) {
            if (z) {
                this.fay.ku(1);
            } else {
                this.fay.ku(0);
            }
        }
    }

    public String aMK() {
        if (this.fay != null) {
            return this.fay.aQG();
        }
        return null;
    }

    public void Jc(String str) {
        if (this.fay != null) {
            this.fay.vD(str);
        }
    }

    public String cCp() {
        return this.jEB;
    }

    public boolean cCq() {
        return (this.fay == null || this.fay.aQI() == null || this.fay.aQI().size() <= 0 || this.fay.aQI().get(0) == null || !this.fay.aQI().get(0).aOx()) ? false : true;
    }

    public PostData cCr() {
        return this.jEH;
    }

    public void d(PostData postData) {
        this.jEH = postData;
        this.jEJ = postData;
        this.jEI = false;
    }

    public PostData cCs() {
        return this.jEJ;
    }

    public void e(PostData postData) {
        this.jEJ = postData;
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                com.baidu.tieba.recapp.d.a.cUZ().Ls(dataRes.asp_shown_info);
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
                this.jEd.parserProtobuf(dataRes.display_forum);
                this.fay.setUserMap(this.userMap);
                this.fay.a(dataRes.thread);
                this.jEj.a(dataRes.news_info);
                switch (this.jEj.djB) {
                    case 1:
                        this.jEk.jPy = this.jEj;
                        break;
                    case 2:
                        this.jEk.jPz = this.jEj;
                        break;
                    case 3:
                        this.jEk.jPA = this.jEj;
                        break;
                    default:
                        this.jEk.jPz = this.jEj;
                        break;
                }
                this.jEn.a(dataRes.recommend_book);
                b(dataRes, context);
                this.jEH = new PostData();
                this.jEH.DS(1);
                this.jEH.setUserMap(this.userMap);
                this.jEH.uq(this.forum.isBrandForum);
                this.jEH.setTime(this.fay.getCreateTime());
                if (dataRes.first_floor_post != null) {
                    this.jEH.a(dataRes.first_floor_post, context);
                }
                if (this.fay != null && this.fay.isShareThread) {
                    this.jEH.h(this.fay.dHm);
                }
                if (this.jEJ == null) {
                    this.jEJ = this.jEH;
                    this.jEI = true;
                }
                this.page.a(dataRes.page);
                this.anti.parserProtobuf(dataRes.anti);
                this.jEf.a(dataRes.location);
                if (dataRes.user != null) {
                    this.jEg = dataRes.user.is_manager.intValue();
                }
                this.userData.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.jEl.add(muteUser);
                        }
                    }
                }
                this.fay.kq(this.fay.aQo() > 0 ? this.fay.aQo() - 1 : 0);
                List<AppData> cUk = com.baidu.tieba.recapp.q.cUm().cUk();
                if (cUk != null) {
                    cUk.clear();
                }
                this.jEr = null;
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        com.baidu.tieba.tbadkCore.data.n nVar = new com.baidu.tieba.tbadkCore.data.n();
                        nVar.d(app);
                        AppData ddi = nVar.ddi();
                        if (!this.jEq.contains(nVar) && ddi.goods != null && (!StringUtils.isNull(ddi.goods.user_name) || !StringUtils.isNull(ddi.goods.lego_card))) {
                            nVar.jSC = aWi();
                            this.jEq.add(nVar);
                            if (cUk != null) {
                                cUk.add(nVar.ddi());
                            }
                        }
                    }
                    c(dataRes);
                    d(dataRes);
                }
                com.baidu.tieba.recapp.q.cUm().cUl();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.userData.getIsSelectTail());
                }
                this.jEs.parserProtobuf(dataRes.twzhibo_anti);
                this.jDP = dataRes.appeal_info;
                if (dataRes.forum_headline_img_info != null) {
                    this.jEx = new h();
                    this.jEx.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.guess_like != null) {
                    this.jDR = new CardHListViewData();
                    this.jDR.parseProtobuf(dataRes.guess_like);
                }
                b(dataRes);
                if (v.getCount(dataRes.repost_recommend_forum_list) > 0) {
                    if (this.jEt == null) {
                        this.jEt = new ArrayList();
                    }
                    for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                        bg bgVar = new bg();
                        bgVar.parserProtobuf(simpleForum);
                        this.jEt.add(bgVar);
                    }
                }
                if (v.getCount(dataRes.from_forum_list) > 0) {
                    if (this.jEu == null) {
                        this.jEu = new ArrayList();
                    }
                    for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                        if (simpleForum2 != null) {
                            bg bgVar2 = new bg();
                            bgVar2.parserProtobuf(simpleForum2);
                            this.jEu.add(bgVar2);
                        }
                    }
                }
                this.jEB = dataRes.multi_forum_text;
                if (this.jEy >= 0) {
                    this.jEy = dataRes.thread_freq_num.longValue();
                }
                a(dataRes);
                if (this.jEE == null) {
                    this.jEE = new ArrayList();
                }
                this.jEE.clear();
                if (dataRes.bjh_recommend != null) {
                    int i2 = 1;
                    for (ThreadInfo threadInfo : dataRes.bjh_recommend) {
                        if (threadInfo != null && !d(threadInfo) && !e(threadInfo)) {
                            com.baidu.tbadk.core.data.k kVar = new com.baidu.tbadk.core.data.k();
                            kVar.setFloorNum(i2);
                            kVar.a(threadInfo);
                            this.jEE.add(kVar);
                            i2++;
                        }
                    }
                }
                if (this.jEG != null && this.jEG.cLJ()) {
                    this.jEG = null;
                }
                if (dataRes.recom_ala_info != null && dataRes.recom_ala_info.live_status.intValue() == 1 && dataRes.recom_ala_info.pb_display_type.intValue() == 2) {
                    if (this.jEG == null) {
                        this.jEG = new com.baidu.tieba.pb.videopb.c.a();
                        this.jEG.parserProtoBuf(dataRes.recom_ala_info);
                    }
                } else if (this.jEG == null && dataRes.promotion != null) {
                    this.jEG = new com.baidu.tieba.pb.videopb.c.a();
                    this.jEG.a(dataRes.promotion);
                }
                if (dataRes.business_promot_info != null) {
                    this.jDY = dataRes.business_promot_info.is_promot.longValue() == 1;
                    this.jDZ = dataRes.business_promot_info.is_headlinepost.intValue() == 1;
                    this.jEa = dataRes.business_promot_info.is_s_card.intValue() == 1;
                    if (dataRes.business_promot_info.send_card_info != null) {
                        b bVar = new b();
                        bVar.a(dataRes.business_promot_info.send_card_info);
                        if (this.jEb == null) {
                            this.jEb = new a();
                        }
                        this.jEb.a(bVar);
                    }
                }
                this.jEN.reset();
                this.jEN.setUserMap(this.userMap);
                this.jEN.a(dataRes.recom_ala_info);
                this.jEO = new aa();
                this.jEO.setUserMap(this.userMap);
                this.jEO.a(dataRes.recom_ala_info);
                this.jEP = dataRes.jumptotab1 == null ? null : dataRes.jumptotab1.toString();
                this.jEQ = dataRes.jumptotab2;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    private void b(DataRes dataRes, Context context) {
        List<Post> list = dataRes.post_list;
        if (list != null && list.size() > 0) {
            for (Post post : dataRes.post_list) {
                if (!this.jED.contains(String.valueOf(post.id))) {
                    PostData postData = new PostData();
                    postData.setUserMap(this.userMap);
                    postData.uq(this.forum.isBrandForum);
                    postData.a(post, context);
                    postData.a(cCi().aQi());
                    if (postData.aSp() != null && postData.aSp().baijiahaoData == null && cCi() != null && cCi().getBaijiahaoData() != null) {
                        postData.aSp().baijiahaoData = cCi().getBaijiahaoData();
                    }
                    this.jED.add(postData.getId());
                    if (postData.ddu() == 1 && this.fay.aRm()) {
                        if (cCq()) {
                            postData.setPostType(0);
                        } else {
                            postData.setPostType(this.fay.aRl());
                        }
                    } else if (postData.ddu() == 1 && this.fay.aRG()) {
                        postData.setPostType(41);
                    } else if (postData.ddu() == 1 && this.fay != null && this.fay.aPk()) {
                        postData.setPostType(0);
                        postData.biA();
                        if (this.fay.aQv() == null || this.fay.aQv().size() == 0) {
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
                            postData.c(new TbRichText((Context) TbadkCoreApplication.getInst(), this.fay.aQv(), true));
                        }
                        this.jEw = postData;
                    }
                    if (postData.ddu() == 1 && this.fay != null && this.fay.isShareThread) {
                        postData.h(this.fay.dHm);
                    }
                    if (postData.ddu() == 1) {
                        this.jEJ = postData;
                        this.jEI = false;
                    }
                    this.jEe.add(postData);
                }
            }
        }
    }

    private void a(DataRes dataRes) {
        this.jEz = new m(this.fay, this.anti);
        this.jDS = dataRes.partial_visible_toast;
        if (dataRes.follow_tip != null && dataRes.follow_tip.is_toast_tip.intValue() == 1) {
            this.jEh = dataRes.follow_tip.tip_text;
        }
        this.jEp = new AlaLiveInfoCoreData();
        if (dataRes.ala_info != null) {
            this.jEp.parserProtoBuf(dataRes.ala_info);
        }
        this.jEA = dataRes.fold_tip;
        this.jDT = dataRes.exp_news_today.intValue();
        this.jDU = dataRes.exp_guide_today.intValue();
        if (!v.isEmpty(dataRes.thread_topic)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= dataRes.thread_topic.size()) {
                    break;
                }
                bc.a aVar = new bc.a();
                aVar.a(dataRes.thread_topic.get(i2));
                this.jEC.add(aVar);
                i = i2 + 1;
            }
        }
        this.jDV = dataRes.pb_sort_info;
        this.jDW = dataRes.sort_type.intValue();
        if (dataRes.manager_election != null) {
            this.jDX = i.b(dataRes.manager_election);
        }
    }

    private void b(DataRes dataRes) {
        if (dataRes.feed_thread_list != null && dataRes.feed_thread_list.size() > 0) {
            List<ThreadInfo> list = dataRes.feed_thread_list;
            if (this.jEo == null) {
                this.jEo = new ArrayList();
            }
            this.jEo.clear();
            for (ThreadInfo threadInfo : list) {
                if (threadInfo != null) {
                    bk bkVar = new bk();
                    bkVar.a(threadInfo);
                    this.jEo.add(bkVar);
                }
            }
            if (this.jEo != null && this.jEo.size() > 15) {
                this.jEo = v.subList(this.jEo, 0, 15);
            }
        }
    }

    private void c(DataRes dataRes) {
        List<String> vr;
        App app = dataRes.banner_list.pb_banner_ad;
        com.baidu.tieba.tbadkCore.data.n nVar = new com.baidu.tieba.tbadkCore.data.n();
        nVar.lkG = true;
        nVar.d(app);
        AppData ddi = nVar.ddi();
        if (ddi.goods != null) {
            if (v.isEmpty(ddi.goods.thread_pic_list) && (vr = AdvertAppInfo.a.vr(ddi.goods.lego_card)) != null && ddi.goods.thread_pic_list != null) {
                ddi.goods.thread_pic_list.addAll(vr);
            }
            this.jEr = nVar;
        }
    }

    private void d(DataRes dataRes) {
        List<App> list = dataRes.banner_list.video_recommend_ad;
        this.jEM.clear();
        if (list != null && !list.isEmpty()) {
            for (App app : list) {
                com.baidu.tieba.tbadkCore.data.n nVar = new com.baidu.tieba.tbadkCore.data.n();
                nVar.d(app);
                AppData ddi = nVar.ddi();
                if (!this.jEM.contains(nVar) && ddi.goods != null && (!StringUtils.isNull(ddi.goods.user_name) || !StringUtils.isNull(ddi.goods.lego_card))) {
                    nVar.jSC = aWi();
                    this.jEM.add(nVar);
                }
            }
        }
    }

    public String cCt() {
        return this.jEA;
    }

    public CardHListViewData cCu() {
        return this.jDR;
    }

    public PostData cCv() {
        return this.jEw;
    }

    public PostData f(PostData postData) {
        this.jEw = postData;
        return postData;
    }

    public p cCw() {
        return this.jEv;
    }

    public int cCx() {
        return this.jEg;
    }

    public int getIsNewUrl() {
        return this.jEi;
    }

    public void setIsNewUrl(int i) {
        this.jEi = i;
    }

    public List<MuteUser> cCy() {
        return this.jEl;
    }

    public ArrayList<com.baidu.tieba.tbadkCore.data.n> cCz() {
        return this.jEq;
    }

    public com.baidu.tieba.tbadkCore.data.n cCA() {
        return this.jEr;
    }

    public void b(com.baidu.tieba.tbadkCore.data.n nVar) {
        this.jEr = nVar;
    }

    public void cCB() {
        if (this.jEr.ddi() != null) {
            this.jEr.ddi().legoCard = null;
        }
        this.jEr = null;
    }

    public String cCC() {
        return this.jDQ;
    }

    public void Jd(String str) {
        this.jDQ = str;
    }

    public h cCD() {
        return this.jEx;
    }

    public List<bg> cCE() {
        return this.jEu;
    }

    public long cCF() {
        return this.jEy;
    }

    public m cCG() {
        return this.jEz;
    }

    public void a(m mVar) {
        this.jEz = mVar;
    }

    public boolean aWi() {
        return (cCi() == null || !cCi().aPk() || cCi().aQQ() == null) ? false : true;
    }

    public AlaLiveInfoCoreData cCH() {
        return this.jEp;
    }

    public List<com.baidu.tbadk.core.data.k> cCI() {
        return this.jEE;
    }

    public boolean cCJ() {
        return cCi() != null && cCi().aSx();
    }

    public String cCK() {
        if (this.jDV != null && this.jDV.size() > this.jDW) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.jDV.size()) {
                    break;
                } else if (this.jDV.get(i2).sort_type.intValue() != this.jDW) {
                    i = i2 + 1;
                } else {
                    return this.jDV.get(i2).sort_name;
                }
            }
        }
        return "";
    }

    public com.baidu.tieba.pb.videopb.c.a cCL() {
        return this.jEG;
    }

    public int cCM() {
        return this.jEF;
    }

    public void zT(int i) {
        this.jEF = i;
    }

    public List<com.baidu.tieba.tbadkCore.data.n> cCN() {
        return this.jEM;
    }

    private boolean d(ThreadInfo threadInfo) {
        if (threadInfo == null || getThreadId() == null || "0".equals(threadInfo.id) || "0".equals(threadInfo.tid)) {
            return false;
        }
        return getThreadId().equals(threadInfo.id) || getThreadId().equals(threadInfo.tid);
    }

    private boolean e(ThreadInfo threadInfo) {
        if (threadInfo == null || threadInfo.baijiahao == null || threadInfo.baijiahao.ori_ugc_nid == null || this.fay == null || this.fay.getBaijiahaoData() == null || this.fay.getBaijiahaoData().oriUgcNid == null || "0".equals(threadInfo.baijiahao.ori_ugc_nid)) {
            return false;
        }
        return threadInfo.baijiahao.ori_ugc_nid.equals(this.fay.getBaijiahaoData().oriUgcNid);
    }
}

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
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.TwzhiboAnti;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.an;
import com.baidu.tbadk.core.data.ap;
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.core.data.ay;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.ad;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.tbadkCore.data.AppData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.data.m;
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
/* loaded from: classes4.dex */
public class d {
    private String hjH;
    private int hjI;
    private a hjN;
    private List<bg> hjP;
    private int hjQ;
    private AlaLiveInfoCoreData hjR;
    private TwzhiboAnti hjU;
    public AppealInfo hjV;
    private List<bc> hjW;
    private List<bc> hjX;
    public String hjZ;
    private PostData hka;
    private f hkb;
    public CardHListViewData hkc;
    private long hkd;
    private i hke;
    public String hkf;
    public int hkg;
    public int hkh;
    public List<PbSortType> hki;
    public int hkj;
    private String hkk;
    private String hkl;
    private PostData hko;
    private boolean hjM = true;
    private ArrayList<m> hjS = new ArrayList<>();
    private m hjT = null;
    private ForumData forum = new ForumData();
    private bc hjD = new bc();
    private bg cZC = new bg();
    private ArrayList<PostData> hjE = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private an page = new an();
    private AntiData anti = new AntiData();
    private com.baidu.tbadk.data.f hjF = new com.baidu.tbadk.data.f();
    private int hjG = 0;
    private final UserData userData = new UserData();
    private List<MuteUser> hjL = new ArrayList();
    private ap hjJ = new ap();
    private aq hjO = new aq();
    private ad hjK = new ad();
    private k hjY = new k();
    private List<ay.a> hkm = new ArrayList();
    private HashSet<String> hkn = new HashSet<>();

    public boolean bHU() {
        return this.hjM;
    }

    public void mZ(boolean z) {
        this.hjM = z;
    }

    public d() {
        this.hjI = 0;
        this.hjU = null;
        this.hjI = 0;
        this.hjU = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.hjE != null && this.hjE.size() > 0;
    }

    public String[] ek(Context context) {
        String str = null;
        String str2 = "";
        if (isValid()) {
            int size = this.hjE.size() > 30 ? 30 : this.hjE.size();
            if (bHW() == null || bHW().YO() == null || com.baidu.tbadk.core.util.ap.isEmpty(bHW().YO().getUserId())) {
                return new String[]{null, ""};
            }
            String userId = bHW().YO().getUserId();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                PostData postData = (PostData) v.c(this.hjE, i);
                if (postData != null && postData.YO() != null && !com.baidu.tbadk.core.util.ap.isEmpty(postData.YO().getUserId()) && com.baidu.tbadk.core.util.ap.equals(userId, postData.YO().getUserId())) {
                    if (com.baidu.tbadk.core.util.ap.isEmpty(str)) {
                        str = postData.cew();
                    }
                    String ceu = com.baidu.tbadk.core.util.ap.isEmpty(str2) ? postData.ceu() : str2;
                    if (!com.baidu.tbadk.core.util.ap.isEmpty(str) && !com.baidu.tbadk.core.util.ap.isEmpty(ceu)) {
                        str2 = ceu;
                        break;
                    }
                    str2 = ceu;
                }
                i++;
                str = str;
            }
            if (com.baidu.tbadk.core.util.ap.isEmpty(str)) {
                str = "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            }
            PostData postData2 = this.hjE.get(0);
            if (this.cZC != null && this.cZC.ZG() != null && this.cZC.ZG().getGroup_id() != 0) {
                str2 = "[" + context.getString(d.j.photo_live_tips) + "] " + str2;
            }
            if (this.cZC != null && this.cZC.ZI() && postData2 != null && postData2.asE() != null) {
                str = postData2.asE().getThumbUrl();
            }
        }
        return new String[]{str, str2};
    }

    public ForumData getForum() {
        return this.forum;
    }

    public bc bHV() {
        return this.hjD;
    }

    public String getForumId() {
        if (this.forum == null) {
            return "";
        }
        return this.forum.getId();
    }

    public bg bHW() {
        return this.cZC;
    }

    public List<bg> bHX() {
        return this.hjP;
    }

    public String getThreadId() {
        if (this.cZC == null) {
            return "";
        }
        return this.cZC.getId();
    }

    public ArrayList<PostData> bHY() {
        return this.hjE;
    }

    public an getPage() {
        return this.page;
    }

    public ad bHZ() {
        return this.hjK;
    }

    public aq bIa() {
        return this.hjO;
    }

    public void a(an anVar, int i) {
        this.page.gj(anVar.XF());
        this.page.gh(anVar.WV());
        this.page.gg(anVar.XC());
        this.page.gk(anVar.XG());
        this.page.gi(anVar.XE());
        if (i == 0) {
            this.page = anVar;
        } else if (i == 1) {
            this.page.gl(anVar.XH());
        } else if (i == 2) {
            this.page.gm(anVar.XI());
        }
    }

    public AntiData getAnti() {
        return this.anti;
    }

    public UserData getUserData() {
        return this.userData;
    }

    public boolean UY() {
        return this.cZC.YW() != 0;
    }

    public void cZ(boolean z) {
        if (this.cZC != null) {
            if (z) {
                this.cZC.gu(1);
            } else {
                this.cZC.gu(0);
            }
        }
    }

    public String UX() {
        if (this.cZC != null) {
            return this.cZC.YX();
        }
        return null;
    }

    public void zF(String str) {
        if (this.cZC != null) {
            this.cZC.ln(str);
        }
    }

    public String bIb() {
        return this.hkl;
    }

    public boolean bIc() {
        return (this.cZC == null || this.cZC.YZ() == null || this.cZC.YZ().size() <= 0 || this.cZC.YZ().get(0) == null || !this.cZC.YZ().get(0).WW()) ? false : true;
    }

    public PostData bId() {
        return this.hko;
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                com.baidu.tieba.recapp.d.a.bXv().BG(dataRes.asp_shown_info);
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
                this.hjD.parserProtobuf(dataRes.display_forum);
                this.cZC.setUserMap(this.userMap);
                this.cZC.a(dataRes.thread);
                this.cZC.setCurrentPage(2);
                this.hjJ.a(dataRes.news_info);
                switch (this.hjJ.bzJ) {
                    case 1:
                        this.hjK.htW = this.hjJ;
                        break;
                    case 2:
                        this.hjK.htX = this.hjJ;
                        break;
                    case 3:
                        this.hjK.htY = this.hjJ;
                        break;
                    default:
                        this.hjK.htX = this.hjJ;
                        break;
                }
                this.hjO.a(dataRes.recommend_book);
                List<Post> list2 = dataRes.post_list;
                if (list2 != null && list2.size() > 0) {
                    for (Post post : dataRes.post_list) {
                        if (!this.hkn.contains(String.valueOf(post.id))) {
                            PostData postData = new PostData();
                            postData.setUserMap(this.userMap);
                            postData.pU(this.forum.isBrandForum);
                            postData.a(post, context);
                            postData.a(bHW().YA());
                            this.hkn.add(postData.getId());
                            if (postData.cep() == 1 && this.cZC.Zz()) {
                                if (bIc()) {
                                    postData.setPostType(0);
                                } else {
                                    postData.setPostType(this.cZC.Zy());
                                }
                            } else if (postData.cep() == 1 && this.cZC.ZO()) {
                                postData.setPostType(41);
                            } else if (postData.cep() == 1 && this.cZC != null && this.cZC.ZI()) {
                                postData.setPostType(0);
                                postData.asE();
                                if (this.cZC.YM() == null || this.cZC.YM().size() == 0) {
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
                                    postData.c(new TbRichText((Context) TbadkCoreApplication.getInst(), this.cZC.YM(), true));
                                }
                                this.hka = postData;
                            }
                            if (postData.cep() == 1 && this.cZC != null && this.cZC.isShareThread) {
                                postData.g(this.cZC.bDy);
                            }
                            this.hjE.add(postData);
                        }
                    }
                }
                if (dataRes.first_floor_post != null) {
                    this.hko = new PostData();
                    this.hko.setUserMap(this.userMap);
                    this.hko.pU(this.forum.isBrandForum);
                    this.hko.a(dataRes.first_floor_post, context);
                    if (this.cZC != null && this.cZC.isShareThread) {
                        this.hko.g(this.cZC.bDy);
                    }
                }
                this.page.a(dataRes.page);
                this.anti.parserProtobuf(dataRes.anti);
                this.hjF.a(dataRes.location);
                if (dataRes.user != null) {
                    this.hjG = dataRes.user.is_manager.intValue();
                }
                this.userData.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.hjL.add(muteUser);
                        }
                    }
                }
                this.cZC.gq(this.cZC.YF() > 0 ? this.cZC.YF() - 1 : 0);
                List<AppData> bWD = r.bWF().bWD();
                if (bWD != null) {
                    bWD.clear();
                }
                this.hjT = null;
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        m mVar = new m();
                        mVar.d(app);
                        AppData ced = mVar.ced();
                        if (!this.hjS.contains(mVar) && ced.goods != null && (!StringUtils.isNull(ced.goods.user_name) || !StringUtils.isNull(ced.goods.lego_card))) {
                            this.hjS.add(mVar);
                            if (bWD != null) {
                                bWD.add(mVar.ced());
                            }
                        }
                    }
                    a(dataRes);
                }
                r.bWF().bWE();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.userData.getIsSelectTail());
                }
                this.hjU.parserProtobuf(dataRes.twzhibo_anti);
                this.hjV = dataRes.appeal_info;
                if (dataRes.god_card != null) {
                    this.hjN = new a();
                    this.hjN.a(dataRes.god_card);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.hkb = new f();
                    this.hkb.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.guess_like != null) {
                    this.hkc = new CardHListViewData();
                    this.hkc.parseProtobuf(dataRes.guess_like);
                }
                if (dataRes.feed_thread_list != null && dataRes.feed_thread_list.size() > 0) {
                    List<ThreadInfo> list3 = dataRes.feed_thread_list;
                    if (this.hjP == null) {
                        this.hjP = new ArrayList();
                    }
                    this.hjP.clear();
                    for (ThreadInfo threadInfo : list3) {
                        if (threadInfo != null) {
                            bg bgVar = new bg();
                            bgVar.a(threadInfo);
                            this.hjP.add(bgVar);
                        }
                    }
                    if (this.hjP != null && this.hjP.size() > 15) {
                        this.hjP = v.c(this.hjP, 0, 15);
                    }
                }
                this.hjQ = dataRes.is_follow_current_channel.intValue();
                if (v.S(dataRes.repost_recommend_forum_list) > 0) {
                    if (this.hjW == null) {
                        this.hjW = new ArrayList();
                    }
                    for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                        bc bcVar = new bc();
                        bcVar.parserProtobuf(simpleForum);
                        this.hjW.add(bcVar);
                    }
                }
                if (v.S(dataRes.from_forum_list) > 0) {
                    if (this.hjX == null) {
                        this.hjX = new ArrayList();
                    }
                    for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                        if (simpleForum2 != null) {
                            bc bcVar2 = new bc();
                            bcVar2.parserProtobuf(simpleForum2);
                            this.hjX.add(bcVar2);
                        }
                    }
                }
                this.hkl = dataRes.multi_forum_text;
                if (this.hkd >= 0) {
                    this.hkd = dataRes.thread_freq_num.longValue();
                }
                this.hke = new i();
                this.hke.bTn = this.cZC;
                this.hke.b(dataRes);
                this.hkf = dataRes.partial_visible_toast;
                if (dataRes.follow_tip != null && dataRes.follow_tip.is_toast_tip.intValue() == 1) {
                    this.hjH = dataRes.follow_tip.tip_text;
                }
                this.hjR = new AlaLiveInfoCoreData();
                if (dataRes.ala_info != null) {
                    this.hjR.parserProtoBuf(dataRes.ala_info);
                }
                this.hkk = dataRes.fold_tip;
                this.hkg = dataRes.exp_news_today.intValue();
                this.hkh = dataRes.exp_guide_today.intValue();
                if (!v.T(dataRes.thread_topic)) {
                    for (int i2 = 0; i2 < dataRes.thread_topic.size(); i2++) {
                        ay.a aVar = new ay.a();
                        aVar.a(dataRes.thread_topic.get(i2));
                        this.hkm.add(aVar);
                    }
                }
                this.hki = dataRes.pb_sort_info;
                this.hkj = dataRes.sort_type.intValue();
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }

    private void a(DataRes dataRes) {
        List<String> kZ;
        App app = dataRes.banner_list.pb_banner_ad;
        m mVar = new m();
        mVar.iFJ = true;
        mVar.d(app);
        AppData ced = mVar.ced();
        if (ced.goods != null) {
            if (v.T(ced.goods.thread_pic_list) && (kZ = AdvertAppInfo.a.kZ(ced.goods.lego_card)) != null && ced.goods.thread_pic_list != null) {
                ced.goods.thread_pic_list.addAll(kZ);
            }
            this.hjT = mVar;
        }
    }

    public String bIe() {
        return this.hkk;
    }

    public CardHListViewData bIf() {
        return this.hkc;
    }

    public PostData bIg() {
        return this.hka;
    }

    public PostData d(PostData postData) {
        this.hka = postData;
        return postData;
    }

    public k bIh() {
        return this.hjY;
    }

    public int bIi() {
        return this.hjG;
    }

    public int getIsNewUrl() {
        return this.hjI;
    }

    public void setIsNewUrl(int i) {
        this.hjI = i;
    }

    public List<MuteUser> bIj() {
        return this.hjL;
    }

    public ArrayList<m> bIk() {
        return this.hjS;
    }

    public m bIl() {
        return this.hjT;
    }

    public void b(m mVar) {
        this.hjT = mVar;
    }

    public void bIm() {
        if (this.hjT.ced() != null) {
            this.hjT.ced().legoCard = null;
        }
        this.hjT = null;
    }

    public a bIn() {
        return this.hjN;
    }

    public String bIo() {
        return this.hjZ;
    }

    public void zG(String str) {
        this.hjZ = str;
    }

    public f bIp() {
        return this.hkb;
    }

    public int bIq() {
        return this.hjQ;
    }

    public List<bc> bIr() {
        return this.hjX;
    }

    public long bIs() {
        return this.hkd;
    }

    public i bIt() {
        return this.hke;
    }

    public boolean bIu() {
        return (bHW() == null || !bHW().ZI() || bHW().Zf() == null) ? false : true;
    }

    public AlaLiveInfoCoreData bIv() {
        return this.hjR;
    }
}

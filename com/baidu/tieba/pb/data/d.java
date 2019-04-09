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
    private String hjI;
    private int hjJ;
    private a hjO;
    private List<bg> hjQ;
    private int hjR;
    private AlaLiveInfoCoreData hjS;
    private TwzhiboAnti hjV;
    public AppealInfo hjW;
    private List<bc> hjX;
    private List<bc> hjY;
    public String hka;
    private PostData hkb;
    private f hkc;
    public CardHListViewData hkd;
    private long hke;
    private i hkf;
    public String hkg;
    public int hkh;
    public int hki;
    public List<PbSortType> hkj;
    public int hkk;
    private String hkl;
    private String hkm;
    private PostData hkp;
    private boolean hjN = true;
    private ArrayList<m> hjT = new ArrayList<>();
    private m hjU = null;
    private ForumData forum = new ForumData();
    private bc hjE = new bc();
    private bg cZD = new bg();
    private ArrayList<PostData> hjF = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private an page = new an();
    private AntiData anti = new AntiData();
    private com.baidu.tbadk.data.f hjG = new com.baidu.tbadk.data.f();
    private int hjH = 0;
    private final UserData userData = new UserData();
    private List<MuteUser> hjM = new ArrayList();
    private ap hjK = new ap();
    private aq hjP = new aq();
    private ad hjL = new ad();
    private k hjZ = new k();
    private List<ay.a> hkn = new ArrayList();
    private HashSet<String> hko = new HashSet<>();

    public boolean bHU() {
        return this.hjN;
    }

    public void mZ(boolean z) {
        this.hjN = z;
    }

    public d() {
        this.hjJ = 0;
        this.hjV = null;
        this.hjJ = 0;
        this.hjV = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.hjF != null && this.hjF.size() > 0;
    }

    public String[] ek(Context context) {
        String str = null;
        String str2 = "";
        if (isValid()) {
            int size = this.hjF.size() > 30 ? 30 : this.hjF.size();
            if (bHW() == null || bHW().YO() == null || com.baidu.tbadk.core.util.ap.isEmpty(bHW().YO().getUserId())) {
                return new String[]{null, ""};
            }
            String userId = bHW().YO().getUserId();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                PostData postData = (PostData) v.c(this.hjF, i);
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
            PostData postData2 = this.hjF.get(0);
            if (this.cZD != null && this.cZD.ZG() != null && this.cZD.ZG().getGroup_id() != 0) {
                str2 = "[" + context.getString(d.j.photo_live_tips) + "] " + str2;
            }
            if (this.cZD != null && this.cZD.ZI() && postData2 != null && postData2.asE() != null) {
                str = postData2.asE().getThumbUrl();
            }
        }
        return new String[]{str, str2};
    }

    public ForumData getForum() {
        return this.forum;
    }

    public bc bHV() {
        return this.hjE;
    }

    public String getForumId() {
        if (this.forum == null) {
            return "";
        }
        return this.forum.getId();
    }

    public bg bHW() {
        return this.cZD;
    }

    public List<bg> bHX() {
        return this.hjQ;
    }

    public String getThreadId() {
        if (this.cZD == null) {
            return "";
        }
        return this.cZD.getId();
    }

    public ArrayList<PostData> bHY() {
        return this.hjF;
    }

    public an getPage() {
        return this.page;
    }

    public ad bHZ() {
        return this.hjL;
    }

    public aq bIa() {
        return this.hjP;
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
        return this.cZD.YW() != 0;
    }

    public void cZ(boolean z) {
        if (this.cZD != null) {
            if (z) {
                this.cZD.gu(1);
            } else {
                this.cZD.gu(0);
            }
        }
    }

    public String UX() {
        if (this.cZD != null) {
            return this.cZD.YX();
        }
        return null;
    }

    public void zF(String str) {
        if (this.cZD != null) {
            this.cZD.ln(str);
        }
    }

    public String bIb() {
        return this.hkm;
    }

    public boolean bIc() {
        return (this.cZD == null || this.cZD.YZ() == null || this.cZD.YZ().size() <= 0 || this.cZD.YZ().get(0) == null || !this.cZD.YZ().get(0).WW()) ? false : true;
    }

    public PostData bId() {
        return this.hkp;
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
                this.hjE.parserProtobuf(dataRes.display_forum);
                this.cZD.setUserMap(this.userMap);
                this.cZD.a(dataRes.thread);
                this.cZD.setCurrentPage(2);
                this.hjK.a(dataRes.news_info);
                switch (this.hjK.bzK) {
                    case 1:
                        this.hjL.htX = this.hjK;
                        break;
                    case 2:
                        this.hjL.htY = this.hjK;
                        break;
                    case 3:
                        this.hjL.htZ = this.hjK;
                        break;
                    default:
                        this.hjL.htY = this.hjK;
                        break;
                }
                this.hjP.a(dataRes.recommend_book);
                List<Post> list2 = dataRes.post_list;
                if (list2 != null && list2.size() > 0) {
                    for (Post post : dataRes.post_list) {
                        if (!this.hko.contains(String.valueOf(post.id))) {
                            PostData postData = new PostData();
                            postData.setUserMap(this.userMap);
                            postData.pU(this.forum.isBrandForum);
                            postData.a(post, context);
                            postData.a(bHW().YA());
                            this.hko.add(postData.getId());
                            if (postData.cep() == 1 && this.cZD.Zz()) {
                                if (bIc()) {
                                    postData.setPostType(0);
                                } else {
                                    postData.setPostType(this.cZD.Zy());
                                }
                            } else if (postData.cep() == 1 && this.cZD.ZO()) {
                                postData.setPostType(41);
                            } else if (postData.cep() == 1 && this.cZD != null && this.cZD.ZI()) {
                                postData.setPostType(0);
                                postData.asE();
                                if (this.cZD.YM() == null || this.cZD.YM().size() == 0) {
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
                                    postData.c(new TbRichText((Context) TbadkCoreApplication.getInst(), this.cZD.YM(), true));
                                }
                                this.hkb = postData;
                            }
                            if (postData.cep() == 1 && this.cZD != null && this.cZD.isShareThread) {
                                postData.g(this.cZD.bDz);
                            }
                            this.hjF.add(postData);
                        }
                    }
                }
                if (dataRes.first_floor_post != null) {
                    this.hkp = new PostData();
                    this.hkp.setUserMap(this.userMap);
                    this.hkp.pU(this.forum.isBrandForum);
                    this.hkp.a(dataRes.first_floor_post, context);
                    if (this.cZD != null && this.cZD.isShareThread) {
                        this.hkp.g(this.cZD.bDz);
                    }
                }
                this.page.a(dataRes.page);
                this.anti.parserProtobuf(dataRes.anti);
                this.hjG.a(dataRes.location);
                if (dataRes.user != null) {
                    this.hjH = dataRes.user.is_manager.intValue();
                }
                this.userData.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.hjM.add(muteUser);
                        }
                    }
                }
                this.cZD.gq(this.cZD.YF() > 0 ? this.cZD.YF() - 1 : 0);
                List<AppData> bWD = r.bWF().bWD();
                if (bWD != null) {
                    bWD.clear();
                }
                this.hjU = null;
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        m mVar = new m();
                        mVar.d(app);
                        AppData ced = mVar.ced();
                        if (!this.hjT.contains(mVar) && ced.goods != null && (!StringUtils.isNull(ced.goods.user_name) || !StringUtils.isNull(ced.goods.lego_card))) {
                            this.hjT.add(mVar);
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
                this.hjV.parserProtobuf(dataRes.twzhibo_anti);
                this.hjW = dataRes.appeal_info;
                if (dataRes.god_card != null) {
                    this.hjO = new a();
                    this.hjO.a(dataRes.god_card);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.hkc = new f();
                    this.hkc.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.guess_like != null) {
                    this.hkd = new CardHListViewData();
                    this.hkd.parseProtobuf(dataRes.guess_like);
                }
                if (dataRes.feed_thread_list != null && dataRes.feed_thread_list.size() > 0) {
                    List<ThreadInfo> list3 = dataRes.feed_thread_list;
                    if (this.hjQ == null) {
                        this.hjQ = new ArrayList();
                    }
                    this.hjQ.clear();
                    for (ThreadInfo threadInfo : list3) {
                        if (threadInfo != null) {
                            bg bgVar = new bg();
                            bgVar.a(threadInfo);
                            this.hjQ.add(bgVar);
                        }
                    }
                    if (this.hjQ != null && this.hjQ.size() > 15) {
                        this.hjQ = v.c(this.hjQ, 0, 15);
                    }
                }
                this.hjR = dataRes.is_follow_current_channel.intValue();
                if (v.S(dataRes.repost_recommend_forum_list) > 0) {
                    if (this.hjX == null) {
                        this.hjX = new ArrayList();
                    }
                    for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                        bc bcVar = new bc();
                        bcVar.parserProtobuf(simpleForum);
                        this.hjX.add(bcVar);
                    }
                }
                if (v.S(dataRes.from_forum_list) > 0) {
                    if (this.hjY == null) {
                        this.hjY = new ArrayList();
                    }
                    for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                        if (simpleForum2 != null) {
                            bc bcVar2 = new bc();
                            bcVar2.parserProtobuf(simpleForum2);
                            this.hjY.add(bcVar2);
                        }
                    }
                }
                this.hkm = dataRes.multi_forum_text;
                if (this.hke >= 0) {
                    this.hke = dataRes.thread_freq_num.longValue();
                }
                this.hkf = new i();
                this.hkf.bTo = this.cZD;
                this.hkf.b(dataRes);
                this.hkg = dataRes.partial_visible_toast;
                if (dataRes.follow_tip != null && dataRes.follow_tip.is_toast_tip.intValue() == 1) {
                    this.hjI = dataRes.follow_tip.tip_text;
                }
                this.hjS = new AlaLiveInfoCoreData();
                if (dataRes.ala_info != null) {
                    this.hjS.parserProtoBuf(dataRes.ala_info);
                }
                this.hkl = dataRes.fold_tip;
                this.hkh = dataRes.exp_news_today.intValue();
                this.hki = dataRes.exp_guide_today.intValue();
                if (!v.T(dataRes.thread_topic)) {
                    for (int i2 = 0; i2 < dataRes.thread_topic.size(); i2++) {
                        ay.a aVar = new ay.a();
                        aVar.a(dataRes.thread_topic.get(i2));
                        this.hkn.add(aVar);
                    }
                }
                this.hkj = dataRes.pb_sort_info;
                this.hkk = dataRes.sort_type.intValue();
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }

    private void a(DataRes dataRes) {
        List<String> kZ;
        App app = dataRes.banner_list.pb_banner_ad;
        m mVar = new m();
        mVar.iFK = true;
        mVar.d(app);
        AppData ced = mVar.ced();
        if (ced.goods != null) {
            if (v.T(ced.goods.thread_pic_list) && (kZ = AdvertAppInfo.a.kZ(ced.goods.lego_card)) != null && ced.goods.thread_pic_list != null) {
                ced.goods.thread_pic_list.addAll(kZ);
            }
            this.hjU = mVar;
        }
    }

    public String bIe() {
        return this.hkl;
    }

    public CardHListViewData bIf() {
        return this.hkd;
    }

    public PostData bIg() {
        return this.hkb;
    }

    public PostData d(PostData postData) {
        this.hkb = postData;
        return postData;
    }

    public k bIh() {
        return this.hjZ;
    }

    public int bIi() {
        return this.hjH;
    }

    public int getIsNewUrl() {
        return this.hjJ;
    }

    public void setIsNewUrl(int i) {
        this.hjJ = i;
    }

    public List<MuteUser> bIj() {
        return this.hjM;
    }

    public ArrayList<m> bIk() {
        return this.hjT;
    }

    public m bIl() {
        return this.hjU;
    }

    public void b(m mVar) {
        this.hjU = mVar;
    }

    public void bIm() {
        if (this.hjU.ced() != null) {
            this.hjU.ced().legoCard = null;
        }
        this.hjU = null;
    }

    public a bIn() {
        return this.hjO;
    }

    public String bIo() {
        return this.hka;
    }

    public void zG(String str) {
        this.hka = str;
    }

    public f bIp() {
        return this.hkc;
    }

    public int bIq() {
        return this.hjR;
    }

    public List<bc> bIr() {
        return this.hjY;
    }

    public long bIs() {
        return this.hke;
    }

    public i bIt() {
        return this.hkf;
    }

    public boolean bIu() {
        return (bHW() == null || !bHW().ZI() || bHW().Zf() == null) ? false : true;
    }

    public AlaLiveInfoCoreData bIv() {
        return this.hjS;
    }
}

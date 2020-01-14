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
import com.baidu.tbadk.core.data.ap;
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.pb.pb.main.ae;
import com.baidu.tieba.recapp.r;
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
/* loaded from: classes7.dex */
public class f {
    private a iAb;
    private List<bj> iAd;
    private AlaLiveInfoCoreData iAe;
    private TwzhiboAnti iAh;
    private List<bf> iAi;
    private List<bf> iAj;
    private PostData iAl;
    private h iAm;
    private long iAn;
    private l iAo;
    private String iAp;
    private String iAq;
    private List<com.baidu.tbadk.core.data.l> iAt;
    private com.baidu.tieba.pb.videopb.c.a iAv;
    private PostData iAw;
    public AppealInfo izD;
    public String izE;
    public CardHListViewData izF;
    public String izG;
    public int izH;
    public int izI;
    public List<PbSortType> izJ;
    public int izK;
    public i izL;
    public b izP;
    private String izV;
    private int izW;
    public boolean izM = false;
    public boolean izN = false;
    public boolean izO = false;
    public boolean izQ = false;
    private boolean iAa = true;
    private ArrayList<com.baidu.tieba.tbadkCore.data.m> iAf = new ArrayList<>();
    private com.baidu.tieba.tbadkCore.data.m iAg = null;
    private int iAu = 0;
    private ForumData forum = new ForumData();
    private bf izR = new bf();
    private bj efE = new bj();
    private ArrayList<PostData> izS = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private ap page = new ap();
    private AntiData anti = new AntiData();
    private com.baidu.tbadk.data.f izT = new com.baidu.tbadk.data.f();
    private int izU = 0;
    private final UserData userData = new UserData();
    private List<MuteUser> izZ = new ArrayList();
    private as izX = new as();
    private at iAc = new at();
    private ae izY = new ae();
    private o iAk = new o();
    private List<bb.a> iAr = new ArrayList();
    private HashSet<String> iAs = new HashSet<>();

    public f() {
        this.izW = 0;
        this.iAh = null;
        this.izW = 0;
        this.iAh = new TwzhiboAnti();
    }

    public boolean ciQ() {
        return this.iAa;
    }

    public void pr(boolean z) {
        this.iAa = z;
    }

    public boolean isValid() {
        return this.izS != null && this.izS.size() > 0;
    }

    public String[] fg(Context context) {
        String str = null;
        String str2 = "";
        if (isValid()) {
            int size = this.izS.size() > 30 ? 30 : this.izS.size();
            if (ciS() == null || ciS().azX() == null || aq.isEmpty(ciS().azX().getUserId())) {
                return new String[]{null, ""};
            }
            String userId = ciS().azX().getUserId();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                PostData postData = (PostData) v.getItem(this.izS, i);
                if (postData != null && postData.azX() != null && !aq.isEmpty(postData.azX().getUserId()) && aq.equals(userId, postData.azX().getUserId())) {
                    if (aq.isEmpty(str)) {
                        str = postData.cJG();
                    }
                    String cJE = aq.isEmpty(str2) ? postData.cJE() : str2;
                    if (!aq.isEmpty(str) && !aq.isEmpty(cJE)) {
                        str2 = cJE;
                        break;
                    }
                    str2 = cJE;
                }
                i++;
                str = str;
            }
            if (aq.isEmpty(str)) {
                str = "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            }
            PostData postData2 = this.izS.get(0);
            if (this.efE != null && this.efE.aAV() != null && this.efE.aAV().getGroup_id() != 0) {
                str2 = "[" + context.getString(R.string.photo_live_tips) + "] " + str2;
            }
            if (this.efE != null && this.efE.aAX() && postData2 != null && postData2.aRJ() != null) {
                str = postData2.aRJ().getThumbUrl();
            }
        }
        return new String[]{str, str2};
    }

    public ForumData getForum() {
        return this.forum;
    }

    public bf ciR() {
        return this.izR;
    }

    public void e(bf bfVar) {
        this.izR = bfVar;
    }

    public String getForumId() {
        if (this.forum == null) {
            return "";
        }
        return this.forum.getId();
    }

    public bj ciS() {
        return this.efE;
    }

    public void aA(bj bjVar) {
        this.efE = bjVar;
    }

    public List<bj> ciT() {
        return this.iAd;
    }

    public String getThreadId() {
        if (this.efE == null) {
            return "";
        }
        return this.efE.getId();
    }

    public ArrayList<PostData> ciU() {
        return this.izS;
    }

    public ap getPage() {
        return this.page;
    }

    public ae ciV() {
        return this.izY;
    }

    public at ciW() {
        return this.iAc;
    }

    public void a(ap apVar, int i) {
        this.page.jk(apVar.ayP());
        this.page.ji(apVar.axX());
        this.page.jh(apVar.ayM());
        this.page.jl(apVar.ayQ());
        this.page.jj(apVar.ayO());
        if (i == 0) {
            this.page = apVar;
        } else if (i == 1) {
            this.page.jm(apVar.ayR());
        } else if (i == 2) {
            this.page.jn(apVar.ayS());
        }
    }

    public AntiData getAnti() {
        return this.anti;
    }

    public UserData getUserData() {
        return this.userData;
    }

    public boolean aww() {
        return this.efE.aAf() != 0;
    }

    public void ff(boolean z) {
        if (this.efE != null) {
            if (z) {
                this.efE.jw(1);
            } else {
                this.efE.jw(0);
            }
        }
    }

    public String awv() {
        if (this.efE != null) {
            return this.efE.aAg();
        }
        return null;
    }

    public void Ft(String str) {
        if (this.efE != null) {
            this.efE.sq(str);
        }
    }

    public String ciX() {
        return this.iAq;
    }

    public boolean ciY() {
        return (this.efE == null || this.efE.aAi() == null || this.efE.aAi().size() <= 0 || this.efE.aAi().get(0) == null || !this.efE.aAi().get(0).axY()) ? false : true;
    }

    public PostData ciZ() {
        return this.iAw;
    }

    public void d(PostData postData) {
        this.iAw = postData;
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                com.baidu.tieba.recapp.d.a.cBM().HK(dataRes.asp_shown_info);
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
                this.izR.parserProtobuf(dataRes.display_forum);
                this.efE.setUserMap(this.userMap);
                this.efE.a(dataRes.thread);
                this.izX.a(dataRes.news_info);
                switch (this.izX.cvj) {
                    case 1:
                        this.izY.iKM = this.izX;
                        break;
                    case 2:
                        this.izY.iKN = this.izX;
                        break;
                    case 3:
                        this.izY.iKO = this.izX;
                        break;
                    default:
                        this.izY.iKN = this.izX;
                        break;
                }
                this.iAc.a(dataRes.recommend_book);
                b(dataRes, context);
                this.iAw = new PostData();
                this.iAw.Cq(1);
                this.iAw.setUserMap(this.userMap);
                this.iAw.sG(this.forum.isBrandForum);
                this.iAw.setTime(this.efE.getCreateTime());
                if (dataRes.first_floor_post != null) {
                    this.iAw.a(dataRes.first_floor_post, context);
                }
                if (this.efE != null && this.efE.isShareThread) {
                    this.iAw.g(this.efE.cPN);
                }
                this.page.a(dataRes.page);
                this.anti.parserProtobuf(dataRes.anti);
                this.izT.a(dataRes.location);
                if (dataRes.user != null) {
                    this.izU = dataRes.user.is_manager.intValue();
                }
                this.userData.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.izZ.add(muteUser);
                        }
                    }
                }
                this.efE.js(this.efE.azO() > 0 ? this.efE.azO() - 1 : 0);
                List<AppData> cAV = r.cAX().cAV();
                if (cAV != null) {
                    cAV.clear();
                }
                this.iAg = null;
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        com.baidu.tieba.tbadkCore.data.m mVar = new com.baidu.tieba.tbadkCore.data.m();
                        mVar.d(app);
                        AppData cJn = mVar.cJn();
                        if (!this.iAf.contains(mVar) && cJn.goods != null && (!StringUtils.isNull(cJn.goods.user_name) || !StringUtils.isNull(cJn.goods.lego_card))) {
                            this.iAf.add(mVar);
                            if (cAV != null) {
                                cAV.add(mVar.cJn());
                            }
                        }
                    }
                    c(dataRes);
                }
                r.cAX().cAW();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.userData.getIsSelectTail());
                }
                this.iAh.parserProtobuf(dataRes.twzhibo_anti);
                this.izD = dataRes.appeal_info;
                if (dataRes.god_card != null) {
                    this.iAb = new a();
                    this.iAb.a(dataRes.god_card);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.iAm = new h();
                    this.iAm.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.guess_like != null) {
                    this.izF = new CardHListViewData();
                    this.izF.parseProtobuf(dataRes.guess_like);
                }
                b(dataRes);
                if (v.getCount(dataRes.repost_recommend_forum_list) > 0) {
                    if (this.iAi == null) {
                        this.iAi = new ArrayList();
                    }
                    for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                        bf bfVar = new bf();
                        bfVar.parserProtobuf(simpleForum);
                        this.iAi.add(bfVar);
                    }
                }
                if (v.getCount(dataRes.from_forum_list) > 0) {
                    if (this.iAj == null) {
                        this.iAj = new ArrayList();
                    }
                    for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                        if (simpleForum2 != null) {
                            bf bfVar2 = new bf();
                            bfVar2.parserProtobuf(simpleForum2);
                            this.iAj.add(bfVar2);
                        }
                    }
                }
                this.iAq = dataRes.multi_forum_text;
                if (this.iAn >= 0) {
                    this.iAn = dataRes.thread_freq_num.longValue();
                }
                a(dataRes);
                if (this.iAt == null) {
                    this.iAt = new ArrayList();
                }
                this.iAt.clear();
                if (dataRes.bjh_recommend != null) {
                    int i2 = 1;
                    for (ThreadInfo threadInfo : dataRes.bjh_recommend) {
                        if (threadInfo != null && !c(threadInfo) && !d(threadInfo)) {
                            com.baidu.tbadk.core.data.l lVar = new com.baidu.tbadk.core.data.l();
                            lVar.setFloorNum(i2);
                            lVar.a(threadInfo);
                            this.iAt.add(lVar);
                            i2++;
                        }
                    }
                }
                if (this.iAv == null && dataRes.promotion != null) {
                    this.iAv = new com.baidu.tieba.pb.videopb.c.a();
                    this.iAv.a(dataRes.promotion);
                }
                if (dataRes.business_promot_info != null) {
                    this.izM = dataRes.business_promot_info.is_promot.longValue() == 1;
                    this.izN = dataRes.business_promot_info.is_headlinepost.intValue() == 1;
                    this.izO = dataRes.business_promot_info.is_s_card.intValue() == 1;
                    if (dataRes.business_promot_info.send_card_info != null) {
                        c cVar = new c();
                        cVar.a(dataRes.business_promot_info.send_card_info);
                        if (this.izP == null) {
                            this.izP = new b();
                        }
                        this.izP.a(cVar);
                    }
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
                if (!this.iAs.contains(String.valueOf(post.id))) {
                    PostData postData = new PostData();
                    postData.setUserMap(this.userMap);
                    postData.sG(this.forum.isBrandForum);
                    postData.a(post, context);
                    postData.a(ciS().azI());
                    this.iAs.add(postData.getId());
                    if (postData.cJz() == 1 && this.efE.aAI()) {
                        if (ciY()) {
                            postData.setPostType(0);
                        } else {
                            postData.setPostType(this.efE.aAH());
                        }
                    } else if (postData.cJz() == 1 && this.efE.aBd()) {
                        postData.setPostType(41);
                    } else if (postData.cJz() == 1 && this.efE != null && this.efE.aAX()) {
                        postData.setPostType(0);
                        postData.aRJ();
                        if (this.efE.azV() == null || this.efE.azV().size() == 0) {
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
                            postData.c(new TbRichText((Context) TbadkCoreApplication.getInst(), this.efE.azV(), true));
                        }
                        this.iAl = postData;
                    }
                    if (postData.cJz() == 1 && this.efE != null && this.efE.isShareThread) {
                        postData.g(this.efE.cPN);
                    }
                    this.izS.add(postData);
                }
            }
        }
    }

    private void a(DataRes dataRes) {
        this.iAo = new l();
        this.iAo.Np = this.efE;
        this.izG = dataRes.partial_visible_toast;
        if (dataRes.follow_tip != null && dataRes.follow_tip.is_toast_tip.intValue() == 1) {
            this.izV = dataRes.follow_tip.tip_text;
        }
        this.iAe = new AlaLiveInfoCoreData();
        if (dataRes.ala_info != null) {
            this.iAe.parserProtoBuf(dataRes.ala_info);
        }
        this.iAp = dataRes.fold_tip;
        this.izH = dataRes.exp_news_today.intValue();
        this.izI = dataRes.exp_guide_today.intValue();
        if (!v.isEmpty(dataRes.thread_topic)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= dataRes.thread_topic.size()) {
                    break;
                }
                bb.a aVar = new bb.a();
                aVar.a(dataRes.thread_topic.get(i2));
                this.iAr.add(aVar);
                i = i2 + 1;
            }
        }
        this.izJ = dataRes.pb_sort_info;
        this.izK = dataRes.sort_type.intValue();
        if (dataRes.manager_election != null) {
            this.izL = i.a(dataRes.manager_election);
        }
    }

    private void b(DataRes dataRes) {
        if (dataRes.feed_thread_list != null && dataRes.feed_thread_list.size() > 0) {
            List<ThreadInfo> list = dataRes.feed_thread_list;
            if (this.iAd == null) {
                this.iAd = new ArrayList();
            }
            this.iAd.clear();
            for (ThreadInfo threadInfo : list) {
                if (threadInfo != null) {
                    bj bjVar = new bj();
                    bjVar.a(threadInfo);
                    this.iAd.add(bjVar);
                }
            }
            if (this.iAd != null && this.iAd.size() > 15) {
                this.iAd = v.subList(this.iAd, 0, 15);
            }
        }
    }

    private void c(DataRes dataRes) {
        List<String> se;
        App app = dataRes.banner_list.pb_banner_ad;
        com.baidu.tieba.tbadkCore.data.m mVar = new com.baidu.tieba.tbadkCore.data.m();
        mVar.kfo = true;
        mVar.d(app);
        AppData cJn = mVar.cJn();
        if (cJn.goods != null) {
            if (v.isEmpty(cJn.goods.thread_pic_list) && (se = AdvertAppInfo.a.se(cJn.goods.lego_card)) != null && cJn.goods.thread_pic_list != null) {
                cJn.goods.thread_pic_list.addAll(se);
            }
            this.iAg = mVar;
        }
    }

    public String cja() {
        return this.iAp;
    }

    public CardHListViewData cjb() {
        return this.izF;
    }

    public PostData cjc() {
        return this.iAl;
    }

    public PostData e(PostData postData) {
        this.iAl = postData;
        return postData;
    }

    public o cjd() {
        return this.iAk;
    }

    public int cje() {
        return this.izU;
    }

    public int getIsNewUrl() {
        return this.izW;
    }

    public void setIsNewUrl(int i) {
        this.izW = i;
    }

    public List<MuteUser> cjf() {
        return this.izZ;
    }

    public ArrayList<com.baidu.tieba.tbadkCore.data.m> cjg() {
        return this.iAf;
    }

    public com.baidu.tieba.tbadkCore.data.m cjh() {
        return this.iAg;
    }

    public void b(com.baidu.tieba.tbadkCore.data.m mVar) {
        this.iAg = mVar;
    }

    public void cji() {
        if (this.iAg.cJn() != null) {
            this.iAg.cJn().legoCard = null;
        }
        this.iAg = null;
    }

    public a cjj() {
        return this.iAb;
    }

    public String cjk() {
        return this.izE;
    }

    public void Fu(String str) {
        this.izE = str;
    }

    public h cjl() {
        return this.iAm;
    }

    public List<bf> cjm() {
        return this.iAj;
    }

    public long cjn() {
        return this.iAn;
    }

    public l cjo() {
        return this.iAo;
    }

    public void a(l lVar) {
        this.iAo = lVar;
    }

    public boolean cjp() {
        return (ciS() == null || !ciS().aAX() || ciS().aAo() == null) ? false : true;
    }

    public AlaLiveInfoCoreData cjq() {
        return this.iAe;
    }

    public List<com.baidu.tbadk.core.data.l> cjr() {
        return this.iAt;
    }

    public boolean cjs() {
        return ciS() != null && ciS().aBV();
    }

    public String cjt() {
        if (this.izJ != null && this.izJ.size() > this.izK) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.izJ.size()) {
                    break;
                } else if (this.izJ.get(i2).sort_type.intValue() != this.izK) {
                    i = i2 + 1;
                } else {
                    return this.izJ.get(i2).sort_name;
                }
            }
        }
        return "";
    }

    public com.baidu.tieba.pb.videopb.c.a cju() {
        return this.iAv;
    }

    public int cjv() {
        return this.iAu;
    }

    public void yt(int i) {
        this.iAu = i;
    }

    private boolean c(ThreadInfo threadInfo) {
        if (threadInfo == null || getThreadId() == null || "0".equals(threadInfo.id) || "0".equals(threadInfo.tid)) {
            return false;
        }
        return getThreadId().equals(threadInfo.id) || getThreadId().equals(threadInfo.tid);
    }

    private boolean d(ThreadInfo threadInfo) {
        if (threadInfo == null || threadInfo.baijiahao == null || threadInfo.baijiahao.ori_ugc_nid == null || this.efE == null || this.efE.getBaijiahaoData() == null || this.efE.getBaijiahaoData().oriUgcNid == null || "0".equals(threadInfo.baijiahao.ori_ugc_nid)) {
            return false;
        }
        return threadInfo.baijiahao.ori_ugc_nid.equals(this.efE.getBaijiahaoData().oriUgcNid);
    }
}

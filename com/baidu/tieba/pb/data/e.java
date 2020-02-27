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
import com.baidu.tieba.pb.pb.main.ab;
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
/* loaded from: classes9.dex */
public class e {
    public int iBA;
    public List<PbSortType> iBB;
    public int iBC;
    public h iBD;
    public a iBH;
    private String iBN;
    private int iBO;
    private List<bj> iBU;
    private AlaLiveInfoCoreData iBV;
    private TwzhiboAnti iBY;
    private List<bf> iBZ;
    public AppealInfo iBv;
    public String iBw;
    public CardHListViewData iBx;
    public String iBy;
    public int iBz;
    private List<bf> iCa;
    private PostData iCc;
    private g iCd;
    private long iCe;
    private k iCf;
    private String iCg;
    private String iCh;
    private List<com.baidu.tbadk.core.data.l> iCk;
    private com.baidu.tieba.pb.videopb.c.a iCm;
    private PostData iCn;
    public boolean iCp;
    public boolean iBE = false;
    public boolean iBF = false;
    public boolean iBG = false;
    public boolean iBI = false;
    private boolean iBS = true;
    private ArrayList<com.baidu.tieba.tbadkCore.data.m> iBW = new ArrayList<>();
    private com.baidu.tieba.tbadkCore.data.m iBX = null;
    private int iCl = 0;
    public int iCo = 0;
    public int Df = 0;
    private ForumData forum = new ForumData();
    private bf iBJ = new bf();
    private bj ejI = new bj();
    private ArrayList<PostData> iBK = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private ap page = new ap();
    private AntiData anti = new AntiData();
    private com.baidu.tbadk.data.f iBL = new com.baidu.tbadk.data.f();
    private int iBM = 0;
    private final UserData userData = new UserData();
    private List<MuteUser> iBR = new ArrayList();
    private as iBP = new as();
    private at iBT = new at();
    private ab iBQ = new ab();
    private n iCb = new n();
    private List<bb.a> iCi = new ArrayList();
    private HashSet<String> iCj = new HashSet<>();

    public e() {
        this.iBO = 0;
        this.iBY = null;
        this.iBO = 0;
        this.iBY = new TwzhiboAnti();
    }

    public boolean ckq() {
        return this.iBS;
    }

    public void pu(boolean z) {
        this.iBS = z;
    }

    public boolean isValid() {
        return this.iBK != null && this.iBK.size() > 0;
    }

    public String[] fj(Context context) {
        String str = null;
        String str2 = "";
        if (isValid()) {
            int size = this.iBK.size() > 30 ? 30 : this.iBK.size();
            if (cks() == null || cks().aCm() == null || aq.isEmpty(cks().aCm().getUserId())) {
                return new String[]{null, ""};
            }
            String userId = cks().aCm().getUserId();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                PostData postData = (PostData) v.getItem(this.iBK, i);
                if (postData != null && postData.aCm() != null && !aq.isEmpty(postData.aCm().getUserId()) && aq.equals(userId, postData.aCm().getUserId())) {
                    if (aq.isEmpty(str)) {
                        str = postData.cLf();
                    }
                    String cLd = aq.isEmpty(str2) ? postData.cLd() : str2;
                    if (!aq.isEmpty(str) && !aq.isEmpty(cLd)) {
                        str2 = cLd;
                        break;
                    }
                    str2 = cLd;
                }
                i++;
                str = str;
            }
            if (aq.isEmpty(str)) {
                str = "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            }
            PostData postData2 = this.iBK.get(0);
            if (this.ejI != null && this.ejI.aDj() != null && this.ejI.aDj().getGroup_id() != 0) {
                str2 = "[" + context.getString(R.string.photo_live_tips) + "] " + str2;
            }
            if (this.ejI != null && this.ejI.aAZ() && postData2 != null && postData2.aUa() != null) {
                str = postData2.aUa().getThumbUrl();
            }
        }
        return new String[]{str, str2};
    }

    public ForumData getForum() {
        return this.forum;
    }

    public bf ckr() {
        return this.iBJ;
    }

    public void e(bf bfVar) {
        this.iBJ = bfVar;
    }

    public String getForumId() {
        if (this.forum == null) {
            return "";
        }
        return this.forum.getId();
    }

    public bj cks() {
        return this.ejI;
    }

    public void aE(bj bjVar) {
        this.ejI = bjVar;
    }

    public List<bj> ckt() {
        return this.iBU;
    }

    public String getThreadId() {
        if (this.ejI == null) {
            return "";
        }
        return this.ejI.getId();
    }

    public ArrayList<PostData> cku() {
        return this.iBK;
    }

    public ap getPage() {
        return this.page;
    }

    public ab ckv() {
        return this.iBQ;
    }

    public at ckw() {
        return this.iBT;
    }

    public void a(ap apVar, int i) {
        this.page.jC(apVar.aBg());
        this.page.jA(apVar.aAl());
        this.page.jz(apVar.aBd());
        this.page.jD(apVar.aBh());
        this.page.jB(apVar.aBf());
        if (i == 0) {
            this.page = apVar;
        } else if (i == 1) {
            this.page.jE(apVar.aBi());
        } else if (i == 2) {
            this.page.jF(apVar.aBj());
        }
    }

    public AntiData getAnti() {
        return this.anti;
    }

    public UserData getUserData() {
        return this.userData;
    }

    public boolean ayJ() {
        return this.ejI.aCu() != 0;
    }

    public void fm(boolean z) {
        if (this.ejI != null) {
            if (z) {
                this.ejI.jN(1);
            } else {
                this.ejI.jN(0);
            }
        }
    }

    public String ayI() {
        if (this.ejI != null) {
            return this.ejI.aCv();
        }
        return null;
    }

    public void FI(String str) {
        if (this.ejI != null) {
            this.ejI.sH(str);
        }
    }

    public String ckx() {
        return this.iCh;
    }

    public boolean cky() {
        return (this.ejI == null || this.ejI.aCx() == null || this.ejI.aCx().size() <= 0 || this.ejI.aCx().get(0) == null || !this.ejI.aCx().get(0).aAm()) ? false : true;
    }

    public PostData ckz() {
        return this.iCn;
    }

    public void d(PostData postData) {
        this.iCn = postData;
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                com.baidu.tieba.recapp.d.a.cDi().HY(dataRes.asp_shown_info);
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
                this.iBJ.parserProtobuf(dataRes.display_forum);
                this.ejI.setUserMap(this.userMap);
                this.ejI.a(dataRes.thread);
                this.iBP.a(dataRes.news_info);
                switch (this.iBP.czh) {
                    case 1:
                        this.iBQ.iMh = this.iBP;
                        break;
                    case 2:
                        this.iBQ.iMi = this.iBP;
                        break;
                    case 3:
                        this.iBQ.iMj = this.iBP;
                        break;
                    default:
                        this.iBQ.iMi = this.iBP;
                        break;
                }
                this.iBT.a(dataRes.recommend_book);
                b(dataRes, context);
                this.iCn = new PostData();
                this.iCn.Cw(1);
                this.iCn.setUserMap(this.userMap);
                this.iCn.sK(this.forum.isBrandForum);
                this.iCn.setTime(this.ejI.getCreateTime());
                if (dataRes.first_floor_post != null) {
                    this.iCn.a(dataRes.first_floor_post, context);
                }
                if (this.ejI != null && this.ejI.isShareThread) {
                    this.iCn.h(this.ejI.cTP);
                }
                this.page.a(dataRes.page);
                this.anti.parserProtobuf(dataRes.anti);
                this.iBL.a(dataRes.location);
                if (dataRes.user != null) {
                    this.iBM = dataRes.user.is_manager.intValue();
                }
                this.userData.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.iBR.add(muteUser);
                        }
                    }
                }
                this.ejI.jJ(this.ejI.aCd() > 0 ? this.ejI.aCd() - 1 : 0);
                List<AppData> cCr = r.cCt().cCr();
                if (cCr != null) {
                    cCr.clear();
                }
                this.iBX = null;
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        com.baidu.tieba.tbadkCore.data.m mVar = new com.baidu.tieba.tbadkCore.data.m();
                        mVar.d(app);
                        AppData cKM = mVar.cKM();
                        if (!this.iBW.contains(mVar) && cKM.goods != null && (!StringUtils.isNull(cKM.goods.user_name) || !StringUtils.isNull(cKM.goods.lego_card))) {
                            mVar.iPe = aHI();
                            this.iBW.add(mVar);
                            if (cCr != null) {
                                cCr.add(mVar.cKM());
                            }
                        }
                    }
                    c(dataRes);
                }
                r.cCt().cCs();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.userData.getIsSelectTail());
                }
                this.iBY.parserProtobuf(dataRes.twzhibo_anti);
                this.iBv = dataRes.appeal_info;
                if (dataRes.forum_headline_img_info != null) {
                    this.iCd = new g();
                    this.iCd.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.guess_like != null) {
                    this.iBx = new CardHListViewData();
                    this.iBx.parseProtobuf(dataRes.guess_like);
                }
                b(dataRes);
                if (v.getCount(dataRes.repost_recommend_forum_list) > 0) {
                    if (this.iBZ == null) {
                        this.iBZ = new ArrayList();
                    }
                    for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                        bf bfVar = new bf();
                        bfVar.parserProtobuf(simpleForum);
                        this.iBZ.add(bfVar);
                    }
                }
                if (v.getCount(dataRes.from_forum_list) > 0) {
                    if (this.iCa == null) {
                        this.iCa = new ArrayList();
                    }
                    for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                        if (simpleForum2 != null) {
                            bf bfVar2 = new bf();
                            bfVar2.parserProtobuf(simpleForum2);
                            this.iCa.add(bfVar2);
                        }
                    }
                }
                this.iCh = dataRes.multi_forum_text;
                if (this.iCe >= 0) {
                    this.iCe = dataRes.thread_freq_num.longValue();
                }
                a(dataRes);
                if (this.iCk == null) {
                    this.iCk = new ArrayList();
                }
                this.iCk.clear();
                if (dataRes.bjh_recommend != null) {
                    int i2 = 1;
                    for (ThreadInfo threadInfo : dataRes.bjh_recommend) {
                        if (threadInfo != null && !c(threadInfo) && !d(threadInfo)) {
                            com.baidu.tbadk.core.data.l lVar = new com.baidu.tbadk.core.data.l();
                            lVar.setFloorNum(i2);
                            lVar.a(threadInfo);
                            this.iCk.add(lVar);
                            i2++;
                        }
                    }
                }
                if (this.iCm == null && dataRes.promotion != null) {
                    this.iCm = new com.baidu.tieba.pb.videopb.c.a();
                    this.iCm.a(dataRes.promotion);
                }
                if (dataRes.business_promot_info != null) {
                    this.iBE = dataRes.business_promot_info.is_promot.longValue() == 1;
                    this.iBF = dataRes.business_promot_info.is_headlinepost.intValue() == 1;
                    this.iBG = dataRes.business_promot_info.is_s_card.intValue() == 1;
                    if (dataRes.business_promot_info.send_card_info != null) {
                        b bVar = new b();
                        bVar.a(dataRes.business_promot_info.send_card_info);
                        if (this.iBH == null) {
                            this.iBH = new a();
                        }
                        this.iBH.a(bVar);
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
                if (!this.iCj.contains(String.valueOf(post.id))) {
                    PostData postData = new PostData();
                    postData.setUserMap(this.userMap);
                    postData.sK(this.forum.isBrandForum);
                    postData.a(post, context);
                    postData.a(cks().aBX());
                    this.iCj.add(postData.getId());
                    if (postData.cKY() == 1 && this.ejI.aCX()) {
                        if (cky()) {
                            postData.setPostType(0);
                        } else {
                            postData.setPostType(this.ejI.aCW());
                        }
                    } else if (postData.cKY() == 1 && this.ejI.aDq()) {
                        postData.setPostType(41);
                    } else if (postData.cKY() == 1 && this.ejI != null && this.ejI.aAZ()) {
                        postData.setPostType(0);
                        postData.aUa();
                        if (this.ejI.aCk() == null || this.ejI.aCk().size() == 0) {
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
                            postData.c(new TbRichText((Context) TbadkCoreApplication.getInst(), this.ejI.aCk(), true));
                        }
                        this.iCc = postData;
                    }
                    if (postData.cKY() == 1 && this.ejI != null && this.ejI.isShareThread) {
                        postData.h(this.ejI.cTP);
                    }
                    this.iBK.add(postData);
                }
            }
        }
    }

    private void a(DataRes dataRes) {
        this.iCf = new k(this.ejI, this.anti);
        this.iBy = dataRes.partial_visible_toast;
        if (dataRes.follow_tip != null && dataRes.follow_tip.is_toast_tip.intValue() == 1) {
            this.iBN = dataRes.follow_tip.tip_text;
        }
        this.iBV = new AlaLiveInfoCoreData();
        if (dataRes.ala_info != null) {
            this.iBV.parserProtoBuf(dataRes.ala_info);
        }
        this.iCg = dataRes.fold_tip;
        this.iBz = dataRes.exp_news_today.intValue();
        this.iBA = dataRes.exp_guide_today.intValue();
        if (!v.isEmpty(dataRes.thread_topic)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= dataRes.thread_topic.size()) {
                    break;
                }
                bb.a aVar = new bb.a();
                aVar.a(dataRes.thread_topic.get(i2));
                this.iCi.add(aVar);
                i = i2 + 1;
            }
        }
        this.iBB = dataRes.pb_sort_info;
        this.iBC = dataRes.sort_type.intValue();
        if (dataRes.manager_election != null) {
            this.iBD = h.a(dataRes.manager_election);
        }
    }

    private void b(DataRes dataRes) {
        if (dataRes.feed_thread_list != null && dataRes.feed_thread_list.size() > 0) {
            List<ThreadInfo> list = dataRes.feed_thread_list;
            if (this.iBU == null) {
                this.iBU = new ArrayList();
            }
            this.iBU.clear();
            for (ThreadInfo threadInfo : list) {
                if (threadInfo != null) {
                    bj bjVar = new bj();
                    bjVar.a(threadInfo);
                    this.iBU.add(bjVar);
                }
            }
            if (this.iBU != null && this.iBU.size() > 15) {
                this.iBU = v.subList(this.iBU, 0, 15);
            }
        }
    }

    private void c(DataRes dataRes) {
        List<String> sv;
        App app = dataRes.banner_list.pb_banner_ad;
        com.baidu.tieba.tbadkCore.data.m mVar = new com.baidu.tieba.tbadkCore.data.m();
        mVar.kgo = true;
        mVar.d(app);
        AppData cKM = mVar.cKM();
        if (cKM.goods != null) {
            if (v.isEmpty(cKM.goods.thread_pic_list) && (sv = AdvertAppInfo.a.sv(cKM.goods.lego_card)) != null && cKM.goods.thread_pic_list != null) {
                cKM.goods.thread_pic_list.addAll(sv);
            }
            this.iBX = mVar;
        }
    }

    public String ckA() {
        return this.iCg;
    }

    public CardHListViewData ckB() {
        return this.iBx;
    }

    public PostData ckC() {
        return this.iCc;
    }

    public PostData e(PostData postData) {
        this.iCc = postData;
        return postData;
    }

    public n ckD() {
        return this.iCb;
    }

    public int ckE() {
        return this.iBM;
    }

    public int getIsNewUrl() {
        return this.iBO;
    }

    public void setIsNewUrl(int i) {
        this.iBO = i;
    }

    public List<MuteUser> ckF() {
        return this.iBR;
    }

    public ArrayList<com.baidu.tieba.tbadkCore.data.m> ckG() {
        return this.iBW;
    }

    public com.baidu.tieba.tbadkCore.data.m ckH() {
        return this.iBX;
    }

    public void b(com.baidu.tieba.tbadkCore.data.m mVar) {
        this.iBX = mVar;
    }

    public void ckI() {
        if (this.iBX.cKM() != null) {
            this.iBX.cKM().legoCard = null;
        }
        this.iBX = null;
    }

    public String ckJ() {
        return this.iBw;
    }

    public void FJ(String str) {
        this.iBw = str;
    }

    public g ckK() {
        return this.iCd;
    }

    public List<bf> ckL() {
        return this.iCa;
    }

    public long ckM() {
        return this.iCe;
    }

    public k ckN() {
        return this.iCf;
    }

    public void a(k kVar) {
        this.iCf = kVar;
    }

    public boolean aHI() {
        return (cks() == null || !cks().aAZ() || cks().aCD() == null) ? false : true;
    }

    public AlaLiveInfoCoreData ckO() {
        return this.iBV;
    }

    public List<com.baidu.tbadk.core.data.l> ckP() {
        return this.iCk;
    }

    public boolean ckQ() {
        return cks() != null && cks().aEg();
    }

    public String ckR() {
        if (this.iBB != null && this.iBB.size() > this.iBC) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.iBB.size()) {
                    break;
                } else if (this.iBB.get(i2).sort_type.intValue() != this.iBC) {
                    i = i2 + 1;
                } else {
                    return this.iBB.get(i2).sort_name;
                }
            }
        }
        return "";
    }

    public com.baidu.tieba.pb.videopb.c.a ckS() {
        return this.iCm;
    }

    public int ckT() {
        return this.iCl;
    }

    public void yA(int i) {
        this.iCl = i;
    }

    private boolean c(ThreadInfo threadInfo) {
        if (threadInfo == null || getThreadId() == null || "0".equals(threadInfo.id) || "0".equals(threadInfo.tid)) {
            return false;
        }
        return getThreadId().equals(threadInfo.id) || getThreadId().equals(threadInfo.tid);
    }

    private boolean d(ThreadInfo threadInfo) {
        if (threadInfo == null || threadInfo.baijiahao == null || threadInfo.baijiahao.ori_ugc_nid == null || this.ejI == null || this.ejI.getBaijiahaoData() == null || this.ejI.getBaijiahaoData().oriUgcNid == null || "0".equals(threadInfo.baijiahao.ori_ugc_nid)) {
            return false;
        }
        return threadInfo.baijiahao.ori_ugc_nid.equals(this.ejI.getBaijiahaoData().oriUgcNid);
    }
}

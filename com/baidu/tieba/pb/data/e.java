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
    public AppealInfo iBJ;
    public String iBK;
    public CardHListViewData iBL;
    public String iBM;
    public int iBN;
    public int iBO;
    public List<PbSortType> iBP;
    public int iBQ;
    public h iBR;
    public a iBV;
    private com.baidu.tieba.pb.videopb.c.a iCA;
    private PostData iCB;
    public boolean iCD;
    private String iCb;
    private int iCc;
    private List<bj> iCi;
    private AlaLiveInfoCoreData iCj;
    private TwzhiboAnti iCm;
    private List<bf> iCn;
    private List<bf> iCo;
    private PostData iCq;
    private g iCr;
    private long iCs;
    private k iCt;
    private String iCu;
    private String iCv;
    private List<com.baidu.tbadk.core.data.l> iCy;
    public boolean iBS = false;
    public boolean iBT = false;
    public boolean iBU = false;
    public boolean iBW = false;
    private boolean iCg = true;
    private ArrayList<com.baidu.tieba.tbadkCore.data.m> iCk = new ArrayList<>();
    private com.baidu.tieba.tbadkCore.data.m iCl = null;
    private int iCz = 0;
    public int iCC = 0;
    public int Df = 0;
    private ForumData forum = new ForumData();
    private bf iBX = new bf();
    private bj ejW = new bj();
    private ArrayList<PostData> iBY = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private ap page = new ap();
    private AntiData anti = new AntiData();
    private com.baidu.tbadk.data.f iBZ = new com.baidu.tbadk.data.f();
    private int iCa = 0;
    private final UserData userData = new UserData();
    private List<MuteUser> iCf = new ArrayList();
    private as iCd = new as();
    private at iCh = new at();
    private ab iCe = new ab();
    private n iCp = new n();
    private List<bb.a> iCw = new ArrayList();
    private HashSet<String> iCx = new HashSet<>();

    public e() {
        this.iCc = 0;
        this.iCm = null;
        this.iCc = 0;
        this.iCm = new TwzhiboAnti();
    }

    public boolean ckt() {
        return this.iCg;
    }

    public void pu(boolean z) {
        this.iCg = z;
    }

    public boolean isValid() {
        return this.iBY != null && this.iBY.size() > 0;
    }

    public String[] fj(Context context) {
        String str = null;
        String str2 = "";
        if (isValid()) {
            int size = this.iBY.size() > 30 ? 30 : this.iBY.size();
            if (ckv() == null || ckv().aCo() == null || aq.isEmpty(ckv().aCo().getUserId())) {
                return new String[]{null, ""};
            }
            String userId = ckv().aCo().getUserId();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                PostData postData = (PostData) v.getItem(this.iBY, i);
                if (postData != null && postData.aCo() != null && !aq.isEmpty(postData.aCo().getUserId()) && aq.equals(userId, postData.aCo().getUserId())) {
                    if (aq.isEmpty(str)) {
                        str = postData.cLi();
                    }
                    String cLg = aq.isEmpty(str2) ? postData.cLg() : str2;
                    if (!aq.isEmpty(str) && !aq.isEmpty(cLg)) {
                        str2 = cLg;
                        break;
                    }
                    str2 = cLg;
                }
                i++;
                str = str;
            }
            if (aq.isEmpty(str)) {
                str = "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            }
            PostData postData2 = this.iBY.get(0);
            if (this.ejW != null && this.ejW.aDl() != null && this.ejW.aDl().getGroup_id() != 0) {
                str2 = "[" + context.getString(R.string.photo_live_tips) + "] " + str2;
            }
            if (this.ejW != null && this.ejW.aBb() && postData2 != null && postData2.aUd() != null) {
                str = postData2.aUd().getThumbUrl();
            }
        }
        return new String[]{str, str2};
    }

    public ForumData getForum() {
        return this.forum;
    }

    public bf cku() {
        return this.iBX;
    }

    public void e(bf bfVar) {
        this.iBX = bfVar;
    }

    public String getForumId() {
        if (this.forum == null) {
            return "";
        }
        return this.forum.getId();
    }

    public bj ckv() {
        return this.ejW;
    }

    public void aE(bj bjVar) {
        this.ejW = bjVar;
    }

    public List<bj> ckw() {
        return this.iCi;
    }

    public String getThreadId() {
        if (this.ejW == null) {
            return "";
        }
        return this.ejW.getId();
    }

    public ArrayList<PostData> ckx() {
        return this.iBY;
    }

    public ap getPage() {
        return this.page;
    }

    public ab cky() {
        return this.iCe;
    }

    public at ckz() {
        return this.iCh;
    }

    public void a(ap apVar, int i) {
        this.page.jC(apVar.aBi());
        this.page.jA(apVar.aAn());
        this.page.jz(apVar.aBf());
        this.page.jD(apVar.aBj());
        this.page.jB(apVar.aBh());
        if (i == 0) {
            this.page = apVar;
        } else if (i == 1) {
            this.page.jE(apVar.aBk());
        } else if (i == 2) {
            this.page.jF(apVar.aBl());
        }
    }

    public AntiData getAnti() {
        return this.anti;
    }

    public UserData getUserData() {
        return this.userData;
    }

    public boolean ayL() {
        return this.ejW.aCw() != 0;
    }

    public void fm(boolean z) {
        if (this.ejW != null) {
            if (z) {
                this.ejW.jN(1);
            } else {
                this.ejW.jN(0);
            }
        }
    }

    public String ayK() {
        if (this.ejW != null) {
            return this.ejW.aCx();
        }
        return null;
    }

    public void FJ(String str) {
        if (this.ejW != null) {
            this.ejW.sH(str);
        }
    }

    public String ckA() {
        return this.iCv;
    }

    public boolean ckB() {
        return (this.ejW == null || this.ejW.aCz() == null || this.ejW.aCz().size() <= 0 || this.ejW.aCz().get(0) == null || !this.ejW.aCz().get(0).aAo()) ? false : true;
    }

    public PostData ckC() {
        return this.iCB;
    }

    public void d(PostData postData) {
        this.iCB = postData;
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                com.baidu.tieba.recapp.d.a.cDl().HZ(dataRes.asp_shown_info);
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
                this.iBX.parserProtobuf(dataRes.display_forum);
                this.ejW.setUserMap(this.userMap);
                this.ejW.a(dataRes.thread);
                this.iCd.a(dataRes.news_info);
                switch (this.iCd.czj) {
                    case 1:
                        this.iCe.iMv = this.iCd;
                        break;
                    case 2:
                        this.iCe.iMw = this.iCd;
                        break;
                    case 3:
                        this.iCe.iMx = this.iCd;
                        break;
                    default:
                        this.iCe.iMw = this.iCd;
                        break;
                }
                this.iCh.a(dataRes.recommend_book);
                b(dataRes, context);
                this.iCB = new PostData();
                this.iCB.Cw(1);
                this.iCB.setUserMap(this.userMap);
                this.iCB.sK(this.forum.isBrandForum);
                this.iCB.setTime(this.ejW.getCreateTime());
                if (dataRes.first_floor_post != null) {
                    this.iCB.a(dataRes.first_floor_post, context);
                }
                if (this.ejW != null && this.ejW.isShareThread) {
                    this.iCB.h(this.ejW.cTR);
                }
                this.page.a(dataRes.page);
                this.anti.parserProtobuf(dataRes.anti);
                this.iBZ.a(dataRes.location);
                if (dataRes.user != null) {
                    this.iCa = dataRes.user.is_manager.intValue();
                }
                this.userData.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.iCf.add(muteUser);
                        }
                    }
                }
                this.ejW.jJ(this.ejW.aCf() > 0 ? this.ejW.aCf() - 1 : 0);
                List<AppData> cCu = r.cCw().cCu();
                if (cCu != null) {
                    cCu.clear();
                }
                this.iCl = null;
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        com.baidu.tieba.tbadkCore.data.m mVar = new com.baidu.tieba.tbadkCore.data.m();
                        mVar.d(app);
                        AppData cKP = mVar.cKP();
                        if (!this.iCk.contains(mVar) && cKP.goods != null && (!StringUtils.isNull(cKP.goods.user_name) || !StringUtils.isNull(cKP.goods.lego_card))) {
                            mVar.iPs = aHL();
                            this.iCk.add(mVar);
                            if (cCu != null) {
                                cCu.add(mVar.cKP());
                            }
                        }
                    }
                    c(dataRes);
                }
                r.cCw().cCv();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.userData.getIsSelectTail());
                }
                this.iCm.parserProtobuf(dataRes.twzhibo_anti);
                this.iBJ = dataRes.appeal_info;
                if (dataRes.forum_headline_img_info != null) {
                    this.iCr = new g();
                    this.iCr.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.guess_like != null) {
                    this.iBL = new CardHListViewData();
                    this.iBL.parseProtobuf(dataRes.guess_like);
                }
                b(dataRes);
                if (v.getCount(dataRes.repost_recommend_forum_list) > 0) {
                    if (this.iCn == null) {
                        this.iCn = new ArrayList();
                    }
                    for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                        bf bfVar = new bf();
                        bfVar.parserProtobuf(simpleForum);
                        this.iCn.add(bfVar);
                    }
                }
                if (v.getCount(dataRes.from_forum_list) > 0) {
                    if (this.iCo == null) {
                        this.iCo = new ArrayList();
                    }
                    for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                        if (simpleForum2 != null) {
                            bf bfVar2 = new bf();
                            bfVar2.parserProtobuf(simpleForum2);
                            this.iCo.add(bfVar2);
                        }
                    }
                }
                this.iCv = dataRes.multi_forum_text;
                if (this.iCs >= 0) {
                    this.iCs = dataRes.thread_freq_num.longValue();
                }
                a(dataRes);
                if (this.iCy == null) {
                    this.iCy = new ArrayList();
                }
                this.iCy.clear();
                if (dataRes.bjh_recommend != null) {
                    int i2 = 1;
                    for (ThreadInfo threadInfo : dataRes.bjh_recommend) {
                        if (threadInfo != null && !c(threadInfo) && !d(threadInfo)) {
                            com.baidu.tbadk.core.data.l lVar = new com.baidu.tbadk.core.data.l();
                            lVar.setFloorNum(i2);
                            lVar.a(threadInfo);
                            this.iCy.add(lVar);
                            i2++;
                        }
                    }
                }
                if (this.iCA == null && dataRes.promotion != null) {
                    this.iCA = new com.baidu.tieba.pb.videopb.c.a();
                    this.iCA.a(dataRes.promotion);
                }
                if (dataRes.business_promot_info != null) {
                    this.iBS = dataRes.business_promot_info.is_promot.longValue() == 1;
                    this.iBT = dataRes.business_promot_info.is_headlinepost.intValue() == 1;
                    this.iBU = dataRes.business_promot_info.is_s_card.intValue() == 1;
                    if (dataRes.business_promot_info.send_card_info != null) {
                        b bVar = new b();
                        bVar.a(dataRes.business_promot_info.send_card_info);
                        if (this.iBV == null) {
                            this.iBV = new a();
                        }
                        this.iBV.a(bVar);
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
                if (!this.iCx.contains(String.valueOf(post.id))) {
                    PostData postData = new PostData();
                    postData.setUserMap(this.userMap);
                    postData.sK(this.forum.isBrandForum);
                    postData.a(post, context);
                    postData.a(ckv().aBZ());
                    this.iCx.add(postData.getId());
                    if (postData.cLb() == 1 && this.ejW.aCZ()) {
                        if (ckB()) {
                            postData.setPostType(0);
                        } else {
                            postData.setPostType(this.ejW.aCY());
                        }
                    } else if (postData.cLb() == 1 && this.ejW.aDs()) {
                        postData.setPostType(41);
                    } else if (postData.cLb() == 1 && this.ejW != null && this.ejW.aBb()) {
                        postData.setPostType(0);
                        postData.aUd();
                        if (this.ejW.aCm() == null || this.ejW.aCm().size() == 0) {
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
                            postData.c(new TbRichText((Context) TbadkCoreApplication.getInst(), this.ejW.aCm(), true));
                        }
                        this.iCq = postData;
                    }
                    if (postData.cLb() == 1 && this.ejW != null && this.ejW.isShareThread) {
                        postData.h(this.ejW.cTR);
                    }
                    this.iBY.add(postData);
                }
            }
        }
    }

    private void a(DataRes dataRes) {
        this.iCt = new k(this.ejW, this.anti);
        this.iBM = dataRes.partial_visible_toast;
        if (dataRes.follow_tip != null && dataRes.follow_tip.is_toast_tip.intValue() == 1) {
            this.iCb = dataRes.follow_tip.tip_text;
        }
        this.iCj = new AlaLiveInfoCoreData();
        if (dataRes.ala_info != null) {
            this.iCj.parserProtoBuf(dataRes.ala_info);
        }
        this.iCu = dataRes.fold_tip;
        this.iBN = dataRes.exp_news_today.intValue();
        this.iBO = dataRes.exp_guide_today.intValue();
        if (!v.isEmpty(dataRes.thread_topic)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= dataRes.thread_topic.size()) {
                    break;
                }
                bb.a aVar = new bb.a();
                aVar.a(dataRes.thread_topic.get(i2));
                this.iCw.add(aVar);
                i = i2 + 1;
            }
        }
        this.iBP = dataRes.pb_sort_info;
        this.iBQ = dataRes.sort_type.intValue();
        if (dataRes.manager_election != null) {
            this.iBR = h.a(dataRes.manager_election);
        }
    }

    private void b(DataRes dataRes) {
        if (dataRes.feed_thread_list != null && dataRes.feed_thread_list.size() > 0) {
            List<ThreadInfo> list = dataRes.feed_thread_list;
            if (this.iCi == null) {
                this.iCi = new ArrayList();
            }
            this.iCi.clear();
            for (ThreadInfo threadInfo : list) {
                if (threadInfo != null) {
                    bj bjVar = new bj();
                    bjVar.a(threadInfo);
                    this.iCi.add(bjVar);
                }
            }
            if (this.iCi != null && this.iCi.size() > 15) {
                this.iCi = v.subList(this.iCi, 0, 15);
            }
        }
    }

    private void c(DataRes dataRes) {
        List<String> sv;
        App app = dataRes.banner_list.pb_banner_ad;
        com.baidu.tieba.tbadkCore.data.m mVar = new com.baidu.tieba.tbadkCore.data.m();
        mVar.kgC = true;
        mVar.d(app);
        AppData cKP = mVar.cKP();
        if (cKP.goods != null) {
            if (v.isEmpty(cKP.goods.thread_pic_list) && (sv = AdvertAppInfo.a.sv(cKP.goods.lego_card)) != null && cKP.goods.thread_pic_list != null) {
                cKP.goods.thread_pic_list.addAll(sv);
            }
            this.iCl = mVar;
        }
    }

    public String ckD() {
        return this.iCu;
    }

    public CardHListViewData ckE() {
        return this.iBL;
    }

    public PostData ckF() {
        return this.iCq;
    }

    public PostData e(PostData postData) {
        this.iCq = postData;
        return postData;
    }

    public n ckG() {
        return this.iCp;
    }

    public int ckH() {
        return this.iCa;
    }

    public int getIsNewUrl() {
        return this.iCc;
    }

    public void setIsNewUrl(int i) {
        this.iCc = i;
    }

    public List<MuteUser> ckI() {
        return this.iCf;
    }

    public ArrayList<com.baidu.tieba.tbadkCore.data.m> ckJ() {
        return this.iCk;
    }

    public com.baidu.tieba.tbadkCore.data.m ckK() {
        return this.iCl;
    }

    public void b(com.baidu.tieba.tbadkCore.data.m mVar) {
        this.iCl = mVar;
    }

    public void ckL() {
        if (this.iCl.cKP() != null) {
            this.iCl.cKP().legoCard = null;
        }
        this.iCl = null;
    }

    public String ckM() {
        return this.iBK;
    }

    public void FK(String str) {
        this.iBK = str;
    }

    public g ckN() {
        return this.iCr;
    }

    public List<bf> ckO() {
        return this.iCo;
    }

    public long ckP() {
        return this.iCs;
    }

    public k ckQ() {
        return this.iCt;
    }

    public void a(k kVar) {
        this.iCt = kVar;
    }

    public boolean aHL() {
        return (ckv() == null || !ckv().aBb() || ckv().aCF() == null) ? false : true;
    }

    public AlaLiveInfoCoreData ckR() {
        return this.iCj;
    }

    public List<com.baidu.tbadk.core.data.l> ckS() {
        return this.iCy;
    }

    public boolean ckT() {
        return ckv() != null && ckv().aEi();
    }

    public String ckU() {
        if (this.iBP != null && this.iBP.size() > this.iBQ) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.iBP.size()) {
                    break;
                } else if (this.iBP.get(i2).sort_type.intValue() != this.iBQ) {
                    i = i2 + 1;
                } else {
                    return this.iBP.get(i2).sort_name;
                }
            }
        }
        return "";
    }

    public com.baidu.tieba.pb.videopb.c.a ckV() {
        return this.iCA;
    }

    public int ckW() {
        return this.iCz;
    }

    public void yA(int i) {
        this.iCz = i;
    }

    private boolean c(ThreadInfo threadInfo) {
        if (threadInfo == null || getThreadId() == null || "0".equals(threadInfo.id) || "0".equals(threadInfo.tid)) {
            return false;
        }
        return getThreadId().equals(threadInfo.id) || getThreadId().equals(threadInfo.tid);
    }

    private boolean d(ThreadInfo threadInfo) {
        if (threadInfo == null || threadInfo.baijiahao == null || threadInfo.baijiahao.ori_ugc_nid == null || this.ejW == null || this.ejW.getBaijiahaoData() == null || this.ejW.getBaijiahaoData().oriUgcNid == null || "0".equals(threadInfo.baijiahao.ori_ugc_nid)) {
            return false;
        }
        return threadInfo.baijiahao.ori_ugc_nid.equals(this.ejW.getBaijiahaoData().oriUgcNid);
    }
}

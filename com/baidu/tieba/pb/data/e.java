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
    public String iBA;
    public int iBB;
    public int iBC;
    public List<PbSortType> iBD;
    public int iBE;
    public h iBF;
    public a iBJ;
    private String iBP;
    private int iBQ;
    private List<bj> iBW;
    private AlaLiveInfoCoreData iBX;
    public AppealInfo iBx;
    public String iBy;
    public CardHListViewData iBz;
    private TwzhiboAnti iCa;
    private List<bf> iCb;
    private List<bf> iCc;
    private PostData iCe;
    private g iCf;
    private long iCg;
    private k iCh;
    private String iCi;
    private String iCj;
    private List<com.baidu.tbadk.core.data.l> iCm;
    private com.baidu.tieba.pb.videopb.c.a iCo;
    private PostData iCp;
    public boolean iCr;
    public boolean iBG = false;
    public boolean iBH = false;
    public boolean iBI = false;
    public boolean iBK = false;
    private boolean iBU = true;
    private ArrayList<com.baidu.tieba.tbadkCore.data.m> iBY = new ArrayList<>();
    private com.baidu.tieba.tbadkCore.data.m iBZ = null;
    private int iCn = 0;
    public int iCq = 0;
    public int Df = 0;
    private ForumData forum = new ForumData();
    private bf iBL = new bf();
    private bj ejJ = new bj();
    private ArrayList<PostData> iBM = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private ap page = new ap();
    private AntiData anti = new AntiData();
    private com.baidu.tbadk.data.f iBN = new com.baidu.tbadk.data.f();
    private int iBO = 0;
    private final UserData userData = new UserData();
    private List<MuteUser> iBT = new ArrayList();
    private as iBR = new as();
    private at iBV = new at();
    private ab iBS = new ab();
    private n iCd = new n();
    private List<bb.a> iCk = new ArrayList();
    private HashSet<String> iCl = new HashSet<>();

    public e() {
        this.iBQ = 0;
        this.iCa = null;
        this.iBQ = 0;
        this.iCa = new TwzhiboAnti();
    }

    public boolean cks() {
        return this.iBU;
    }

    public void pu(boolean z) {
        this.iBU = z;
    }

    public boolean isValid() {
        return this.iBM != null && this.iBM.size() > 0;
    }

    public String[] fj(Context context) {
        String str = null;
        String str2 = "";
        if (isValid()) {
            int size = this.iBM.size() > 30 ? 30 : this.iBM.size();
            if (cku() == null || cku().aCo() == null || aq.isEmpty(cku().aCo().getUserId())) {
                return new String[]{null, ""};
            }
            String userId = cku().aCo().getUserId();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                PostData postData = (PostData) v.getItem(this.iBM, i);
                if (postData != null && postData.aCo() != null && !aq.isEmpty(postData.aCo().getUserId()) && aq.equals(userId, postData.aCo().getUserId())) {
                    if (aq.isEmpty(str)) {
                        str = postData.cLh();
                    }
                    String cLf = aq.isEmpty(str2) ? postData.cLf() : str2;
                    if (!aq.isEmpty(str) && !aq.isEmpty(cLf)) {
                        str2 = cLf;
                        break;
                    }
                    str2 = cLf;
                }
                i++;
                str = str;
            }
            if (aq.isEmpty(str)) {
                str = "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            }
            PostData postData2 = this.iBM.get(0);
            if (this.ejJ != null && this.ejJ.aDl() != null && this.ejJ.aDl().getGroup_id() != 0) {
                str2 = "[" + context.getString(R.string.photo_live_tips) + "] " + str2;
            }
            if (this.ejJ != null && this.ejJ.aBb() && postData2 != null && postData2.aUc() != null) {
                str = postData2.aUc().getThumbUrl();
            }
        }
        return new String[]{str, str2};
    }

    public ForumData getForum() {
        return this.forum;
    }

    public bf ckt() {
        return this.iBL;
    }

    public void e(bf bfVar) {
        this.iBL = bfVar;
    }

    public String getForumId() {
        if (this.forum == null) {
            return "";
        }
        return this.forum.getId();
    }

    public bj cku() {
        return this.ejJ;
    }

    public void aE(bj bjVar) {
        this.ejJ = bjVar;
    }

    public List<bj> ckv() {
        return this.iBW;
    }

    public String getThreadId() {
        if (this.ejJ == null) {
            return "";
        }
        return this.ejJ.getId();
    }

    public ArrayList<PostData> ckw() {
        return this.iBM;
    }

    public ap getPage() {
        return this.page;
    }

    public ab ckx() {
        return this.iBS;
    }

    public at cky() {
        return this.iBV;
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
        return this.ejJ.aCw() != 0;
    }

    public void fm(boolean z) {
        if (this.ejJ != null) {
            if (z) {
                this.ejJ.jN(1);
            } else {
                this.ejJ.jN(0);
            }
        }
    }

    public String ayK() {
        if (this.ejJ != null) {
            return this.ejJ.aCx();
        }
        return null;
    }

    public void FI(String str) {
        if (this.ejJ != null) {
            this.ejJ.sH(str);
        }
    }

    public String ckz() {
        return this.iCj;
    }

    public boolean ckA() {
        return (this.ejJ == null || this.ejJ.aCz() == null || this.ejJ.aCz().size() <= 0 || this.ejJ.aCz().get(0) == null || !this.ejJ.aCz().get(0).aAo()) ? false : true;
    }

    public PostData ckB() {
        return this.iCp;
    }

    public void d(PostData postData) {
        this.iCp = postData;
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                com.baidu.tieba.recapp.d.a.cDk().HY(dataRes.asp_shown_info);
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
                this.iBL.parserProtobuf(dataRes.display_forum);
                this.ejJ.setUserMap(this.userMap);
                this.ejJ.a(dataRes.thread);
                this.iBR.a(dataRes.news_info);
                switch (this.iBR.czi) {
                    case 1:
                        this.iBS.iMj = this.iBR;
                        break;
                    case 2:
                        this.iBS.iMk = this.iBR;
                        break;
                    case 3:
                        this.iBS.iMl = this.iBR;
                        break;
                    default:
                        this.iBS.iMk = this.iBR;
                        break;
                }
                this.iBV.a(dataRes.recommend_book);
                b(dataRes, context);
                this.iCp = new PostData();
                this.iCp.Cw(1);
                this.iCp.setUserMap(this.userMap);
                this.iCp.sK(this.forum.isBrandForum);
                this.iCp.setTime(this.ejJ.getCreateTime());
                if (dataRes.first_floor_post != null) {
                    this.iCp.a(dataRes.first_floor_post, context);
                }
                if (this.ejJ != null && this.ejJ.isShareThread) {
                    this.iCp.h(this.ejJ.cTQ);
                }
                this.page.a(dataRes.page);
                this.anti.parserProtobuf(dataRes.anti);
                this.iBN.a(dataRes.location);
                if (dataRes.user != null) {
                    this.iBO = dataRes.user.is_manager.intValue();
                }
                this.userData.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.iBT.add(muteUser);
                        }
                    }
                }
                this.ejJ.jJ(this.ejJ.aCf() > 0 ? this.ejJ.aCf() - 1 : 0);
                List<AppData> cCt = r.cCv().cCt();
                if (cCt != null) {
                    cCt.clear();
                }
                this.iBZ = null;
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        com.baidu.tieba.tbadkCore.data.m mVar = new com.baidu.tieba.tbadkCore.data.m();
                        mVar.d(app);
                        AppData cKO = mVar.cKO();
                        if (!this.iBY.contains(mVar) && cKO.goods != null && (!StringUtils.isNull(cKO.goods.user_name) || !StringUtils.isNull(cKO.goods.lego_card))) {
                            mVar.iPg = aHK();
                            this.iBY.add(mVar);
                            if (cCt != null) {
                                cCt.add(mVar.cKO());
                            }
                        }
                    }
                    c(dataRes);
                }
                r.cCv().cCu();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.userData.getIsSelectTail());
                }
                this.iCa.parserProtobuf(dataRes.twzhibo_anti);
                this.iBx = dataRes.appeal_info;
                if (dataRes.forum_headline_img_info != null) {
                    this.iCf = new g();
                    this.iCf.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.guess_like != null) {
                    this.iBz = new CardHListViewData();
                    this.iBz.parseProtobuf(dataRes.guess_like);
                }
                b(dataRes);
                if (v.getCount(dataRes.repost_recommend_forum_list) > 0) {
                    if (this.iCb == null) {
                        this.iCb = new ArrayList();
                    }
                    for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                        bf bfVar = new bf();
                        bfVar.parserProtobuf(simpleForum);
                        this.iCb.add(bfVar);
                    }
                }
                if (v.getCount(dataRes.from_forum_list) > 0) {
                    if (this.iCc == null) {
                        this.iCc = new ArrayList();
                    }
                    for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                        if (simpleForum2 != null) {
                            bf bfVar2 = new bf();
                            bfVar2.parserProtobuf(simpleForum2);
                            this.iCc.add(bfVar2);
                        }
                    }
                }
                this.iCj = dataRes.multi_forum_text;
                if (this.iCg >= 0) {
                    this.iCg = dataRes.thread_freq_num.longValue();
                }
                a(dataRes);
                if (this.iCm == null) {
                    this.iCm = new ArrayList();
                }
                this.iCm.clear();
                if (dataRes.bjh_recommend != null) {
                    int i2 = 1;
                    for (ThreadInfo threadInfo : dataRes.bjh_recommend) {
                        if (threadInfo != null && !c(threadInfo) && !d(threadInfo)) {
                            com.baidu.tbadk.core.data.l lVar = new com.baidu.tbadk.core.data.l();
                            lVar.setFloorNum(i2);
                            lVar.a(threadInfo);
                            this.iCm.add(lVar);
                            i2++;
                        }
                    }
                }
                if (this.iCo == null && dataRes.promotion != null) {
                    this.iCo = new com.baidu.tieba.pb.videopb.c.a();
                    this.iCo.a(dataRes.promotion);
                }
                if (dataRes.business_promot_info != null) {
                    this.iBG = dataRes.business_promot_info.is_promot.longValue() == 1;
                    this.iBH = dataRes.business_promot_info.is_headlinepost.intValue() == 1;
                    this.iBI = dataRes.business_promot_info.is_s_card.intValue() == 1;
                    if (dataRes.business_promot_info.send_card_info != null) {
                        b bVar = new b();
                        bVar.a(dataRes.business_promot_info.send_card_info);
                        if (this.iBJ == null) {
                            this.iBJ = new a();
                        }
                        this.iBJ.a(bVar);
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
                if (!this.iCl.contains(String.valueOf(post.id))) {
                    PostData postData = new PostData();
                    postData.setUserMap(this.userMap);
                    postData.sK(this.forum.isBrandForum);
                    postData.a(post, context);
                    postData.a(cku().aBZ());
                    this.iCl.add(postData.getId());
                    if (postData.cLa() == 1 && this.ejJ.aCZ()) {
                        if (ckA()) {
                            postData.setPostType(0);
                        } else {
                            postData.setPostType(this.ejJ.aCY());
                        }
                    } else if (postData.cLa() == 1 && this.ejJ.aDs()) {
                        postData.setPostType(41);
                    } else if (postData.cLa() == 1 && this.ejJ != null && this.ejJ.aBb()) {
                        postData.setPostType(0);
                        postData.aUc();
                        if (this.ejJ.aCm() == null || this.ejJ.aCm().size() == 0) {
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
                            postData.c(new TbRichText((Context) TbadkCoreApplication.getInst(), this.ejJ.aCm(), true));
                        }
                        this.iCe = postData;
                    }
                    if (postData.cLa() == 1 && this.ejJ != null && this.ejJ.isShareThread) {
                        postData.h(this.ejJ.cTQ);
                    }
                    this.iBM.add(postData);
                }
            }
        }
    }

    private void a(DataRes dataRes) {
        this.iCh = new k(this.ejJ, this.anti);
        this.iBA = dataRes.partial_visible_toast;
        if (dataRes.follow_tip != null && dataRes.follow_tip.is_toast_tip.intValue() == 1) {
            this.iBP = dataRes.follow_tip.tip_text;
        }
        this.iBX = new AlaLiveInfoCoreData();
        if (dataRes.ala_info != null) {
            this.iBX.parserProtoBuf(dataRes.ala_info);
        }
        this.iCi = dataRes.fold_tip;
        this.iBB = dataRes.exp_news_today.intValue();
        this.iBC = dataRes.exp_guide_today.intValue();
        if (!v.isEmpty(dataRes.thread_topic)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= dataRes.thread_topic.size()) {
                    break;
                }
                bb.a aVar = new bb.a();
                aVar.a(dataRes.thread_topic.get(i2));
                this.iCk.add(aVar);
                i = i2 + 1;
            }
        }
        this.iBD = dataRes.pb_sort_info;
        this.iBE = dataRes.sort_type.intValue();
        if (dataRes.manager_election != null) {
            this.iBF = h.a(dataRes.manager_election);
        }
    }

    private void b(DataRes dataRes) {
        if (dataRes.feed_thread_list != null && dataRes.feed_thread_list.size() > 0) {
            List<ThreadInfo> list = dataRes.feed_thread_list;
            if (this.iBW == null) {
                this.iBW = new ArrayList();
            }
            this.iBW.clear();
            for (ThreadInfo threadInfo : list) {
                if (threadInfo != null) {
                    bj bjVar = new bj();
                    bjVar.a(threadInfo);
                    this.iBW.add(bjVar);
                }
            }
            if (this.iBW != null && this.iBW.size() > 15) {
                this.iBW = v.subList(this.iBW, 0, 15);
            }
        }
    }

    private void c(DataRes dataRes) {
        List<String> sv;
        App app = dataRes.banner_list.pb_banner_ad;
        com.baidu.tieba.tbadkCore.data.m mVar = new com.baidu.tieba.tbadkCore.data.m();
        mVar.kgq = true;
        mVar.d(app);
        AppData cKO = mVar.cKO();
        if (cKO.goods != null) {
            if (v.isEmpty(cKO.goods.thread_pic_list) && (sv = AdvertAppInfo.a.sv(cKO.goods.lego_card)) != null && cKO.goods.thread_pic_list != null) {
                cKO.goods.thread_pic_list.addAll(sv);
            }
            this.iBZ = mVar;
        }
    }

    public String ckC() {
        return this.iCi;
    }

    public CardHListViewData ckD() {
        return this.iBz;
    }

    public PostData ckE() {
        return this.iCe;
    }

    public PostData e(PostData postData) {
        this.iCe = postData;
        return postData;
    }

    public n ckF() {
        return this.iCd;
    }

    public int ckG() {
        return this.iBO;
    }

    public int getIsNewUrl() {
        return this.iBQ;
    }

    public void setIsNewUrl(int i) {
        this.iBQ = i;
    }

    public List<MuteUser> ckH() {
        return this.iBT;
    }

    public ArrayList<com.baidu.tieba.tbadkCore.data.m> ckI() {
        return this.iBY;
    }

    public com.baidu.tieba.tbadkCore.data.m ckJ() {
        return this.iBZ;
    }

    public void b(com.baidu.tieba.tbadkCore.data.m mVar) {
        this.iBZ = mVar;
    }

    public void ckK() {
        if (this.iBZ.cKO() != null) {
            this.iBZ.cKO().legoCard = null;
        }
        this.iBZ = null;
    }

    public String ckL() {
        return this.iBy;
    }

    public void FJ(String str) {
        this.iBy = str;
    }

    public g ckM() {
        return this.iCf;
    }

    public List<bf> ckN() {
        return this.iCc;
    }

    public long ckO() {
        return this.iCg;
    }

    public k ckP() {
        return this.iCh;
    }

    public void a(k kVar) {
        this.iCh = kVar;
    }

    public boolean aHK() {
        return (cku() == null || !cku().aBb() || cku().aCF() == null) ? false : true;
    }

    public AlaLiveInfoCoreData ckQ() {
        return this.iBX;
    }

    public List<com.baidu.tbadk.core.data.l> ckR() {
        return this.iCm;
    }

    public boolean ckS() {
        return cku() != null && cku().aEi();
    }

    public String ckT() {
        if (this.iBD != null && this.iBD.size() > this.iBE) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.iBD.size()) {
                    break;
                } else if (this.iBD.get(i2).sort_type.intValue() != this.iBE) {
                    i = i2 + 1;
                } else {
                    return this.iBD.get(i2).sort_name;
                }
            }
        }
        return "";
    }

    public com.baidu.tieba.pb.videopb.c.a ckU() {
        return this.iCo;
    }

    public int ckV() {
        return this.iCn;
    }

    public void yA(int i) {
        this.iCn = i;
    }

    private boolean c(ThreadInfo threadInfo) {
        if (threadInfo == null || getThreadId() == null || "0".equals(threadInfo.id) || "0".equals(threadInfo.tid)) {
            return false;
        }
        return getThreadId().equals(threadInfo.id) || getThreadId().equals(threadInfo.tid);
    }

    private boolean d(ThreadInfo threadInfo) {
        if (threadInfo == null || threadInfo.baijiahao == null || threadInfo.baijiahao.ori_ugc_nid == null || this.ejJ == null || this.ejJ.getBaijiahaoData() == null || this.ejJ.getBaijiahaoData().oriUgcNid == null || "0".equals(threadInfo.baijiahao.ori_ugc_nid)) {
            return false;
        }
        return threadInfo.baijiahao.ori_ugc_nid.equals(this.ejJ.getBaijiahaoData().oriUgcNid);
    }
}

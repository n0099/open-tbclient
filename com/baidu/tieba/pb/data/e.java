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
    private String iDB;
    private int iDC;
    private List<bj> iDI;
    private AlaLiveInfoCoreData iDJ;
    private TwzhiboAnti iDM;
    private List<bf> iDN;
    private List<bf> iDO;
    private PostData iDQ;
    private g iDR;
    private long iDS;
    private k iDT;
    private String iDU;
    private String iDV;
    private List<com.baidu.tbadk.core.data.l> iDY;
    public AppealInfo iDj;
    public String iDk;
    public CardHListViewData iDl;
    public String iDm;
    public int iDn;
    public int iDo;
    public List<PbSortType> iDp;
    public int iDq;
    public h iDr;
    public a iDv;
    private com.baidu.tieba.pb.videopb.c.a iEa;
    private PostData iEb;
    public boolean iEd;
    public boolean iDs = false;
    public boolean iDt = false;
    public boolean iDu = false;
    public boolean iDw = false;
    private boolean iDG = true;
    private ArrayList<com.baidu.tieba.tbadkCore.data.m> iDK = new ArrayList<>();
    private com.baidu.tieba.tbadkCore.data.m iDL = null;
    private int iDZ = 0;
    public int iEc = 0;
    public int Df = 0;
    private List<com.baidu.tieba.tbadkCore.data.m> iEe = new ArrayList();
    private ForumData forum = new ForumData();
    private bf iDx = new bf();
    private bj ekm = new bj();
    private ArrayList<PostData> iDy = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private ap page = new ap();
    private AntiData anti = new AntiData();
    private com.baidu.tbadk.data.f iDz = new com.baidu.tbadk.data.f();
    private int iDA = 0;
    private final UserData userData = new UserData();
    private List<MuteUser> iDF = new ArrayList();
    private as iDD = new as();
    private at iDH = new at();
    private ab iDE = new ab();
    private n iDP = new n();
    private List<bb.a> iDW = new ArrayList();
    private HashSet<String> iDX = new HashSet<>();

    public e() {
        this.iDC = 0;
        this.iDM = null;
        this.iDC = 0;
        this.iDM = new TwzhiboAnti();
    }

    public boolean ckN() {
        return this.iDG;
    }

    public void pA(boolean z) {
        this.iDG = z;
    }

    public boolean isValid() {
        return this.iDy != null && this.iDy.size() > 0;
    }

    public String[] fi(Context context) {
        String str = null;
        String str2 = "";
        if (isValid()) {
            int size = this.iDy.size() > 30 ? 30 : this.iDy.size();
            if (ckP() == null || ckP().aCr() == null || aq.isEmpty(ckP().aCr().getUserId())) {
                return new String[]{null, ""};
            }
            String userId = ckP().aCr().getUserId();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                PostData postData = (PostData) v.getItem(this.iDy, i);
                if (postData != null && postData.aCr() != null && !aq.isEmpty(postData.aCr().getUserId()) && aq.equals(userId, postData.aCr().getUserId())) {
                    if (aq.isEmpty(str)) {
                        str = postData.cLC();
                    }
                    String cLA = aq.isEmpty(str2) ? postData.cLA() : str2;
                    if (!aq.isEmpty(str) && !aq.isEmpty(cLA)) {
                        str2 = cLA;
                        break;
                    }
                    str2 = cLA;
                }
                i++;
                str = str;
            }
            if (aq.isEmpty(str)) {
                str = "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            }
            PostData postData2 = this.iDy.get(0);
            if (this.ekm != null && this.ekm.aDo() != null && this.ekm.aDo().getGroup_id() != 0) {
                str2 = "[" + context.getString(R.string.photo_live_tips) + "] " + str2;
            }
            if (this.ekm != null && this.ekm.aBe() && postData2 != null && postData2.aUh() != null) {
                str = postData2.aUh().getThumbUrl();
            }
        }
        return new String[]{str, str2};
    }

    public ForumData getForum() {
        return this.forum;
    }

    public bf ckO() {
        return this.iDx;
    }

    public void e(bf bfVar) {
        this.iDx = bfVar;
    }

    public String getForumId() {
        if (this.forum == null) {
            return "";
        }
        return this.forum.getId();
    }

    public bj ckP() {
        return this.ekm;
    }

    public void aF(bj bjVar) {
        this.ekm = bjVar;
    }

    public List<bj> ckQ() {
        return this.iDI;
    }

    public String getThreadId() {
        if (this.ekm == null) {
            return "";
        }
        return this.ekm.getId();
    }

    public ArrayList<PostData> ckR() {
        return this.iDy;
    }

    public ap getPage() {
        return this.page;
    }

    public ab ckS() {
        return this.iDE;
    }

    public at ckT() {
        return this.iDH;
    }

    public void a(ap apVar, int i) {
        this.page.jC(apVar.aBl());
        this.page.jA(apVar.aAq());
        this.page.jz(apVar.aBi());
        this.page.jD(apVar.aBm());
        this.page.jB(apVar.aBk());
        if (i == 0) {
            this.page = apVar;
        } else if (i == 1) {
            this.page.jE(apVar.aBn());
        } else if (i == 2) {
            this.page.jF(apVar.aBo());
        }
    }

    public AntiData getAnti() {
        return this.anti;
    }

    public UserData getUserData() {
        return this.userData;
    }

    public boolean ayO() {
        return this.ekm.aCz() != 0;
    }

    public void fn(boolean z) {
        if (this.ekm != null) {
            if (z) {
                this.ekm.jN(1);
            } else {
                this.ekm.jN(0);
            }
        }
    }

    public String ayN() {
        if (this.ekm != null) {
            return this.ekm.aCA();
        }
        return null;
    }

    public void FI(String str) {
        if (this.ekm != null) {
            this.ekm.sG(str);
        }
    }

    public String ckU() {
        return this.iDV;
    }

    public boolean ckV() {
        return (this.ekm == null || this.ekm.aCC() == null || this.ekm.aCC().size() <= 0 || this.ekm.aCC().get(0) == null || !this.ekm.aCC().get(0).aAr()) ? false : true;
    }

    public PostData ckW() {
        return this.iEb;
    }

    public void d(PostData postData) {
        this.iEb = postData;
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                com.baidu.tieba.recapp.d.a.cDF().HY(dataRes.asp_shown_info);
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
                this.iDx.parserProtobuf(dataRes.display_forum);
                this.ekm.setUserMap(this.userMap);
                this.ekm.a(dataRes.thread);
                this.iDD.a(dataRes.news_info);
                switch (this.iDD.czu) {
                    case 1:
                        this.iDE.iNW = this.iDD;
                        break;
                    case 2:
                        this.iDE.iNX = this.iDD;
                        break;
                    case 3:
                        this.iDE.iNY = this.iDD;
                        break;
                    default:
                        this.iDE.iNX = this.iDD;
                        break;
                }
                this.iDH.a(dataRes.recommend_book);
                b(dataRes, context);
                this.iEb = new PostData();
                this.iEb.CE(1);
                this.iEb.setUserMap(this.userMap);
                this.iEb.sQ(this.forum.isBrandForum);
                this.iEb.setTime(this.ekm.getCreateTime());
                if (dataRes.first_floor_post != null) {
                    this.iEb.a(dataRes.first_floor_post, context);
                }
                if (this.ekm != null && this.ekm.isShareThread) {
                    this.iEb.h(this.ekm.cUe);
                }
                this.page.a(dataRes.page);
                this.anti.parserProtobuf(dataRes.anti);
                this.iDz.a(dataRes.location);
                if (dataRes.user != null) {
                    this.iDA = dataRes.user.is_manager.intValue();
                }
                this.userData.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.iDF.add(muteUser);
                        }
                    }
                }
                this.ekm.jJ(this.ekm.aCi() > 0 ? this.ekm.aCi() - 1 : 0);
                List<AppData> cCO = r.cCQ().cCO();
                if (cCO != null) {
                    cCO.clear();
                }
                this.iDL = null;
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        com.baidu.tieba.tbadkCore.data.m mVar = new com.baidu.tieba.tbadkCore.data.m();
                        mVar.d(app);
                        AppData cLj = mVar.cLj();
                        if (!this.iDK.contains(mVar) && cLj.goods != null && (!StringUtils.isNull(cLj.goods.user_name) || !StringUtils.isNull(cLj.goods.lego_card))) {
                            mVar.iQT = aHP();
                            this.iDK.add(mVar);
                            if (cCO != null) {
                                cCO.add(mVar.cLj());
                            }
                        }
                    }
                    c(dataRes);
                    d(dataRes);
                }
                r.cCQ().cCP();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.userData.getIsSelectTail());
                }
                this.iDM.parserProtobuf(dataRes.twzhibo_anti);
                this.iDj = dataRes.appeal_info;
                if (dataRes.forum_headline_img_info != null) {
                    this.iDR = new g();
                    this.iDR.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.guess_like != null) {
                    this.iDl = new CardHListViewData();
                    this.iDl.parseProtobuf(dataRes.guess_like);
                }
                b(dataRes);
                if (v.getCount(dataRes.repost_recommend_forum_list) > 0) {
                    if (this.iDN == null) {
                        this.iDN = new ArrayList();
                    }
                    for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                        bf bfVar = new bf();
                        bfVar.parserProtobuf(simpleForum);
                        this.iDN.add(bfVar);
                    }
                }
                if (v.getCount(dataRes.from_forum_list) > 0) {
                    if (this.iDO == null) {
                        this.iDO = new ArrayList();
                    }
                    for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                        if (simpleForum2 != null) {
                            bf bfVar2 = new bf();
                            bfVar2.parserProtobuf(simpleForum2);
                            this.iDO.add(bfVar2);
                        }
                    }
                }
                this.iDV = dataRes.multi_forum_text;
                if (this.iDS >= 0) {
                    this.iDS = dataRes.thread_freq_num.longValue();
                }
                a(dataRes);
                if (this.iDY == null) {
                    this.iDY = new ArrayList();
                }
                this.iDY.clear();
                if (dataRes.bjh_recommend != null) {
                    int i2 = 1;
                    for (ThreadInfo threadInfo : dataRes.bjh_recommend) {
                        if (threadInfo != null && !c(threadInfo) && !d(threadInfo)) {
                            com.baidu.tbadk.core.data.l lVar = new com.baidu.tbadk.core.data.l();
                            lVar.setFloorNum(i2);
                            lVar.a(threadInfo);
                            this.iDY.add(lVar);
                            i2++;
                        }
                    }
                }
                if (this.iEa == null && dataRes.promotion != null) {
                    this.iEa = new com.baidu.tieba.pb.videopb.c.a();
                    this.iEa.a(dataRes.promotion);
                }
                if (dataRes.business_promot_info != null) {
                    this.iDs = dataRes.business_promot_info.is_promot.longValue() == 1;
                    this.iDt = dataRes.business_promot_info.is_headlinepost.intValue() == 1;
                    this.iDu = dataRes.business_promot_info.is_s_card.intValue() == 1;
                    if (dataRes.business_promot_info.send_card_info != null) {
                        b bVar = new b();
                        bVar.a(dataRes.business_promot_info.send_card_info);
                        if (this.iDv == null) {
                            this.iDv = new a();
                        }
                        this.iDv.a(bVar);
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
                if (!this.iDX.contains(String.valueOf(post.id))) {
                    PostData postData = new PostData();
                    postData.setUserMap(this.userMap);
                    postData.sQ(this.forum.isBrandForum);
                    postData.a(post, context);
                    postData.a(ckP().aCc());
                    this.iDX.add(postData.getId());
                    if (postData.cLv() == 1 && this.ekm.aDc()) {
                        if (ckV()) {
                            postData.setPostType(0);
                        } else {
                            postData.setPostType(this.ekm.aDb());
                        }
                    } else if (postData.cLv() == 1 && this.ekm.aDw()) {
                        postData.setPostType(41);
                    } else if (postData.cLv() == 1 && this.ekm != null && this.ekm.aBe()) {
                        postData.setPostType(0);
                        postData.aUh();
                        if (this.ekm.aCp() == null || this.ekm.aCp().size() == 0) {
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
                            postData.c(new TbRichText((Context) TbadkCoreApplication.getInst(), this.ekm.aCp(), true));
                        }
                        this.iDQ = postData;
                    }
                    if (postData.cLv() == 1 && this.ekm != null && this.ekm.isShareThread) {
                        postData.h(this.ekm.cUe);
                    }
                    this.iDy.add(postData);
                }
            }
        }
    }

    private void a(DataRes dataRes) {
        this.iDT = new k(this.ekm, this.anti);
        this.iDm = dataRes.partial_visible_toast;
        if (dataRes.follow_tip != null && dataRes.follow_tip.is_toast_tip.intValue() == 1) {
            this.iDB = dataRes.follow_tip.tip_text;
        }
        this.iDJ = new AlaLiveInfoCoreData();
        if (dataRes.ala_info != null) {
            this.iDJ.parserProtoBuf(dataRes.ala_info);
        }
        this.iDU = dataRes.fold_tip;
        this.iDn = dataRes.exp_news_today.intValue();
        this.iDo = dataRes.exp_guide_today.intValue();
        if (!v.isEmpty(dataRes.thread_topic)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= dataRes.thread_topic.size()) {
                    break;
                }
                bb.a aVar = new bb.a();
                aVar.a(dataRes.thread_topic.get(i2));
                this.iDW.add(aVar);
                i = i2 + 1;
            }
        }
        this.iDp = dataRes.pb_sort_info;
        this.iDq = dataRes.sort_type.intValue();
        if (dataRes.manager_election != null) {
            this.iDr = h.a(dataRes.manager_election);
        }
    }

    private void b(DataRes dataRes) {
        if (dataRes.feed_thread_list != null && dataRes.feed_thread_list.size() > 0) {
            List<ThreadInfo> list = dataRes.feed_thread_list;
            if (this.iDI == null) {
                this.iDI = new ArrayList();
            }
            this.iDI.clear();
            for (ThreadInfo threadInfo : list) {
                if (threadInfo != null) {
                    bj bjVar = new bj();
                    bjVar.a(threadInfo);
                    this.iDI.add(bjVar);
                }
            }
            if (this.iDI != null && this.iDI.size() > 15) {
                this.iDI = v.subList(this.iDI, 0, 15);
            }
        }
    }

    private void c(DataRes dataRes) {
        List<String> su;
        App app = dataRes.banner_list.pb_banner_ad;
        com.baidu.tieba.tbadkCore.data.m mVar = new com.baidu.tieba.tbadkCore.data.m();
        mVar.kif = true;
        mVar.d(app);
        AppData cLj = mVar.cLj();
        if (cLj.goods != null) {
            if (v.isEmpty(cLj.goods.thread_pic_list) && (su = AdvertAppInfo.a.su(cLj.goods.lego_card)) != null && cLj.goods.thread_pic_list != null) {
                cLj.goods.thread_pic_list.addAll(su);
            }
            this.iDL = mVar;
        }
    }

    private void d(DataRes dataRes) {
        List<App> list = dataRes.banner_list.video_recommend_ad;
        this.iEe.clear();
        if (list != null && !list.isEmpty()) {
            for (App app : list) {
                com.baidu.tieba.tbadkCore.data.m mVar = new com.baidu.tieba.tbadkCore.data.m();
                mVar.d(app);
                AppData cLj = mVar.cLj();
                if (!this.iEe.contains(mVar) && cLj.goods != null && (!StringUtils.isNull(cLj.goods.user_name) || !StringUtils.isNull(cLj.goods.lego_card))) {
                    mVar.iQT = aHP();
                    this.iEe.add(mVar);
                }
            }
        }
    }

    public String ckX() {
        return this.iDU;
    }

    public CardHListViewData ckY() {
        return this.iDl;
    }

    public PostData ckZ() {
        return this.iDQ;
    }

    public PostData e(PostData postData) {
        this.iDQ = postData;
        return postData;
    }

    public n cla() {
        return this.iDP;
    }

    public int clb() {
        return this.iDA;
    }

    public int getIsNewUrl() {
        return this.iDC;
    }

    public void setIsNewUrl(int i) {
        this.iDC = i;
    }

    public List<MuteUser> clc() {
        return this.iDF;
    }

    public ArrayList<com.baidu.tieba.tbadkCore.data.m> cld() {
        return this.iDK;
    }

    public com.baidu.tieba.tbadkCore.data.m cle() {
        return this.iDL;
    }

    public void b(com.baidu.tieba.tbadkCore.data.m mVar) {
        this.iDL = mVar;
    }

    public void clf() {
        if (this.iDL.cLj() != null) {
            this.iDL.cLj().legoCard = null;
        }
        this.iDL = null;
    }

    public String clg() {
        return this.iDk;
    }

    public void FJ(String str) {
        this.iDk = str;
    }

    public g clh() {
        return this.iDR;
    }

    public List<bf> cli() {
        return this.iDO;
    }

    public long clj() {
        return this.iDS;
    }

    public k clk() {
        return this.iDT;
    }

    public void a(k kVar) {
        this.iDT = kVar;
    }

    public boolean aHP() {
        return (ckP() == null || !ckP().aBe() || ckP().aCI() == null) ? false : true;
    }

    public AlaLiveInfoCoreData cll() {
        return this.iDJ;
    }

    public List<com.baidu.tbadk.core.data.l> clm() {
        return this.iDY;
    }

    public boolean cln() {
        return ckP() != null && ckP().aEm();
    }

    public String clo() {
        if (this.iDp != null && this.iDp.size() > this.iDq) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.iDp.size()) {
                    break;
                } else if (this.iDp.get(i2).sort_type.intValue() != this.iDq) {
                    i = i2 + 1;
                } else {
                    return this.iDp.get(i2).sort_name;
                }
            }
        }
        return "";
    }

    public com.baidu.tieba.pb.videopb.c.a clp() {
        return this.iEa;
    }

    public int clq() {
        return this.iDZ;
    }

    public void yI(int i) {
        this.iDZ = i;
    }

    public List<com.baidu.tieba.tbadkCore.data.m> clr() {
        return this.iEe;
    }

    private boolean c(ThreadInfo threadInfo) {
        if (threadInfo == null || getThreadId() == null || "0".equals(threadInfo.id) || "0".equals(threadInfo.tid)) {
            return false;
        }
        return getThreadId().equals(threadInfo.id) || getThreadId().equals(threadInfo.tid);
    }

    private boolean d(ThreadInfo threadInfo) {
        if (threadInfo == null || threadInfo.baijiahao == null || threadInfo.baijiahao.ori_ugc_nid == null || this.ekm == null || this.ekm.getBaijiahaoData() == null || this.ekm.getBaijiahaoData().oriUgcNid == null || "0".equals(threadInfo.baijiahao.ori_ugc_nid)) {
            return false;
        }
        return threadInfo.baijiahao.ori_ugc_nid.equals(this.ekm.getBaijiahaoData().oriUgcNid);
    }
}

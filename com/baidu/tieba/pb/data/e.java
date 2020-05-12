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
import com.baidu.tieba.recapp.q;
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
    public int jnA;
    public h jnB;
    public a jnF;
    private String jnL;
    private int jnM;
    private List<bj> jnS;
    private AlaLiveInfoCoreData jnT;
    private TwzhiboAnti jnW;
    private List<bf> jnX;
    private List<bf> jnY;
    public AppealInfo jnt;
    public String jnu;
    public CardHListViewData jnv;
    public String jnw;
    public int jnx;
    public int jny;
    public List<PbSortType> jnz;
    private PostData joa;
    private g job;
    private long joc;
    private k jod;
    private String joe;
    private String jof;
    private List<com.baidu.tbadk.core.data.l> joi;
    private com.baidu.tieba.pb.videopb.c.a jok;
    private PostData jol;
    public boolean jon;
    public boolean jnC = false;
    public boolean jnD = false;
    public boolean jnE = false;
    public boolean jnG = false;
    private boolean jnQ = true;
    private ArrayList<com.baidu.tieba.tbadkCore.data.m> jnU = new ArrayList<>();
    private com.baidu.tieba.tbadkCore.data.m jnV = null;
    private int joj = 0;
    public int jom = 0;
    public int WD = 0;
    private List<com.baidu.tieba.tbadkCore.data.m> joo = new ArrayList();
    private ForumData forum = new ForumData();
    private bf jnH = new bf();
    private bj eNR = new bj();
    private ArrayList<PostData> jnI = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private ap page = new ap();
    private AntiData anti = new AntiData();
    private com.baidu.tbadk.data.f jnJ = new com.baidu.tbadk.data.f();
    private int jnK = 0;
    private final UserData userData = new UserData();
    private List<MuteUser> jnP = new ArrayList();
    private as jnN = new as();
    private at jnR = new at();
    private ab jnO = new ab();
    private n jnZ = new n();
    private List<bb.a> jog = new ArrayList();
    private HashSet<String> joh = new HashSet<>();

    public e() {
        this.jnM = 0;
        this.jnW = null;
        this.jnM = 0;
        this.jnW = new TwzhiboAnti();
    }

    public boolean cvq() {
        return this.jnQ;
    }

    public void qE(boolean z) {
        this.jnQ = z;
    }

    public boolean isValid() {
        return this.jnI != null && this.jnI.size() > 0;
    }

    public String[] eP(Context context) {
        String str = null;
        String str2 = "";
        if (isValid()) {
            int size = this.jnI.size() > 30 ? 30 : this.jnI.size();
            if (cvs() == null || cvs().aKC() == null || aq.isEmpty(cvs().aKC().getUserId())) {
                return new String[]{null, ""};
            }
            String userId = cvs().aKC().getUserId();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                PostData postData = (PostData) v.getItem(this.jnI, i);
                if (postData != null && postData.aKC() != null && !aq.isEmpty(postData.aKC().getUserId()) && aq.equals(userId, postData.aKC().getUserId())) {
                    if (aq.isEmpty(str)) {
                        str = postData.cWw();
                    }
                    String cWu = aq.isEmpty(str2) ? postData.cWu() : str2;
                    if (!aq.isEmpty(str) && !aq.isEmpty(cWu)) {
                        str2 = cWu;
                        break;
                    }
                    str2 = cWu;
                }
                i++;
                str = str;
            }
            if (aq.isEmpty(str)) {
                str = "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            }
            PostData postData2 = this.jnI.get(0);
            if (this.eNR != null && this.eNR.aLz() != null && this.eNR.aLz().getGroup_id() != 0) {
                str2 = "[" + context.getString(R.string.photo_live_tips) + "] " + str2;
            }
            if (this.eNR != null && this.eNR.aJp() && postData2 != null && postData2.bcp() != null) {
                str = postData2.bcp().getThumbUrl();
            }
        }
        return new String[]{str, str2};
    }

    public ForumData getForum() {
        return this.forum;
    }

    public bf cvr() {
        return this.jnH;
    }

    public void e(bf bfVar) {
        this.jnH = bfVar;
    }

    public String getForumId() {
        if (this.forum == null) {
            return "";
        }
        return this.forum.getId();
    }

    public bj cvs() {
        return this.eNR;
    }

    public void aG(bj bjVar) {
        this.eNR = bjVar;
    }

    public List<bj> cvt() {
        return this.jnS;
    }

    public String getThreadId() {
        if (this.eNR == null) {
            return "";
        }
        return this.eNR.getId();
    }

    public ArrayList<PostData> cvu() {
        return this.jnI;
    }

    public ap getPage() {
        return this.page;
    }

    public ab cvv() {
        return this.jnO;
    }

    public at cvw() {
        return this.jnR;
    }

    public void a(ap apVar, int i) {
        this.page.jJ(apVar.aJw());
        this.page.jH(apVar.aIB());
        this.page.jG(apVar.aJt());
        this.page.jK(apVar.aJx());
        this.page.jI(apVar.aJv());
        if (i == 0) {
            this.page = apVar;
        } else if (i == 1) {
            this.page.jL(apVar.aJy());
        } else if (i == 2) {
            this.page.jM(apVar.aJz());
        }
    }

    public AntiData getAnti() {
        return this.anti;
    }

    public UserData getUserData() {
        return this.userData;
    }

    public boolean aGX() {
        return this.eNR.aKK() != 0;
    }

    public void gk(boolean z) {
        if (this.eNR != null) {
            if (z) {
                this.eNR.jU(1);
            } else {
                this.eNR.jU(0);
            }
        }
    }

    public String aGW() {
        if (this.eNR != null) {
            return this.eNR.aKL();
        }
        return null;
    }

    public void Ht(String str) {
        if (this.eNR != null) {
            this.eNR.tX(str);
        }
    }

    public String cvx() {
        return this.jof;
    }

    public boolean cvy() {
        return (this.eNR == null || this.eNR.aKN() == null || this.eNR.aKN().size() <= 0 || this.eNR.aKN().get(0) == null || !this.eNR.aKN().get(0).aIC()) ? false : true;
    }

    public PostData cvz() {
        return this.jol;
    }

    public void d(PostData postData) {
        this.jol = postData;
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                com.baidu.tieba.recapp.d.a.cNZ().JG(dataRes.asp_shown_info);
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
                this.jnH.parserProtobuf(dataRes.display_forum);
                this.eNR.setUserMap(this.userMap);
                this.eNR.a(dataRes.thread);
                this.jnN.a(dataRes.news_info);
                switch (this.jnN.cYx) {
                    case 1:
                        this.jnO.jyj = this.jnN;
                        break;
                    case 2:
                        this.jnO.jyk = this.jnN;
                        break;
                    case 3:
                        this.jnO.jyl = this.jnN;
                        break;
                    default:
                        this.jnO.jyk = this.jnN;
                        break;
                }
                this.jnR.a(dataRes.recommend_book);
                b(dataRes, context);
                this.jol = new PostData();
                this.jol.Di(1);
                this.jol.setUserMap(this.userMap);
                this.jol.tS(this.forum.isBrandForum);
                this.jol.setTime(this.eNR.getCreateTime());
                if (dataRes.first_floor_post != null) {
                    this.jol.a(dataRes.first_floor_post, context);
                }
                if (this.eNR != null && this.eNR.isShareThread) {
                    this.jol.h(this.eNR.dtt);
                }
                this.page.a(dataRes.page);
                this.anti.parserProtobuf(dataRes.anti);
                this.jnJ.a(dataRes.location);
                if (dataRes.user != null) {
                    this.jnK = dataRes.user.is_manager.intValue();
                }
                this.userData.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.jnP.add(muteUser);
                        }
                    }
                }
                this.eNR.jQ(this.eNR.aKt() > 0 ? this.eNR.aKt() - 1 : 0);
                List<AppData> cNk = q.cNm().cNk();
                if (cNk != null) {
                    cNk.clear();
                }
                this.jnV = null;
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        com.baidu.tieba.tbadkCore.data.m mVar = new com.baidu.tieba.tbadkCore.data.m();
                        mVar.d(app);
                        AppData cWd = mVar.cWd();
                        if (!this.jnU.contains(mVar) && cWd.goods != null && (!StringUtils.isNull(cWd.goods.user_name) || !StringUtils.isNull(cWd.goods.lego_card))) {
                            mVar.jBg = aQe();
                            this.jnU.add(mVar);
                            if (cNk != null) {
                                cNk.add(mVar.cWd());
                            }
                        }
                    }
                    c(dataRes);
                    d(dataRes);
                }
                q.cNm().cNl();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.userData.getIsSelectTail());
                }
                this.jnW.parserProtobuf(dataRes.twzhibo_anti);
                this.jnt = dataRes.appeal_info;
                if (dataRes.forum_headline_img_info != null) {
                    this.job = new g();
                    this.job.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.guess_like != null) {
                    this.jnv = new CardHListViewData();
                    this.jnv.parseProtobuf(dataRes.guess_like);
                }
                b(dataRes);
                if (v.getCount(dataRes.repost_recommend_forum_list) > 0) {
                    if (this.jnX == null) {
                        this.jnX = new ArrayList();
                    }
                    for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                        bf bfVar = new bf();
                        bfVar.parserProtobuf(simpleForum);
                        this.jnX.add(bfVar);
                    }
                }
                if (v.getCount(dataRes.from_forum_list) > 0) {
                    if (this.jnY == null) {
                        this.jnY = new ArrayList();
                    }
                    for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                        if (simpleForum2 != null) {
                            bf bfVar2 = new bf();
                            bfVar2.parserProtobuf(simpleForum2);
                            this.jnY.add(bfVar2);
                        }
                    }
                }
                this.jof = dataRes.multi_forum_text;
                if (this.joc >= 0) {
                    this.joc = dataRes.thread_freq_num.longValue();
                }
                a(dataRes);
                if (this.joi == null) {
                    this.joi = new ArrayList();
                }
                this.joi.clear();
                if (dataRes.bjh_recommend != null) {
                    int i2 = 1;
                    for (ThreadInfo threadInfo : dataRes.bjh_recommend) {
                        if (threadInfo != null && !c(threadInfo) && !d(threadInfo)) {
                            com.baidu.tbadk.core.data.l lVar = new com.baidu.tbadk.core.data.l();
                            lVar.setFloorNum(i2);
                            lVar.a(threadInfo);
                            this.joi.add(lVar);
                            i2++;
                        }
                    }
                }
                if (this.jok == null && dataRes.promotion != null) {
                    this.jok = new com.baidu.tieba.pb.videopb.c.a();
                    this.jok.a(dataRes.promotion);
                }
                if (dataRes.business_promot_info != null) {
                    this.jnC = dataRes.business_promot_info.is_promot.longValue() == 1;
                    this.jnD = dataRes.business_promot_info.is_headlinepost.intValue() == 1;
                    this.jnE = dataRes.business_promot_info.is_s_card.intValue() == 1;
                    if (dataRes.business_promot_info.send_card_info != null) {
                        b bVar = new b();
                        bVar.a(dataRes.business_promot_info.send_card_info);
                        if (this.jnF == null) {
                            this.jnF = new a();
                        }
                        this.jnF.a(bVar);
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
                if (!this.joh.contains(String.valueOf(post.id))) {
                    PostData postData = new PostData();
                    postData.setUserMap(this.userMap);
                    postData.tS(this.forum.isBrandForum);
                    postData.a(post, context);
                    postData.a(cvs().aKn());
                    this.joh.add(postData.getId());
                    if (postData.cWp() == 1 && this.eNR.aLn()) {
                        if (cvy()) {
                            postData.setPostType(0);
                        } else {
                            postData.setPostType(this.eNR.aLm());
                        }
                    } else if (postData.cWp() == 1 && this.eNR.aLH()) {
                        postData.setPostType(41);
                    } else if (postData.cWp() == 1 && this.eNR != null && this.eNR.aJp()) {
                        postData.setPostType(0);
                        postData.bcp();
                        if (this.eNR.aKA() == null || this.eNR.aKA().size() == 0) {
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
                            postData.c(new TbRichText((Context) TbadkCoreApplication.getInst(), this.eNR.aKA(), true));
                        }
                        this.joa = postData;
                    }
                    if (postData.cWp() == 1 && this.eNR != null && this.eNR.isShareThread) {
                        postData.h(this.eNR.dtt);
                    }
                    this.jnI.add(postData);
                }
            }
        }
    }

    private void a(DataRes dataRes) {
        this.jod = new k(this.eNR, this.anti);
        this.jnw = dataRes.partial_visible_toast;
        if (dataRes.follow_tip != null && dataRes.follow_tip.is_toast_tip.intValue() == 1) {
            this.jnL = dataRes.follow_tip.tip_text;
        }
        this.jnT = new AlaLiveInfoCoreData();
        if (dataRes.ala_info != null) {
            this.jnT.parserProtoBuf(dataRes.ala_info);
        }
        this.joe = dataRes.fold_tip;
        this.jnx = dataRes.exp_news_today.intValue();
        this.jny = dataRes.exp_guide_today.intValue();
        if (!v.isEmpty(dataRes.thread_topic)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= dataRes.thread_topic.size()) {
                    break;
                }
                bb.a aVar = new bb.a();
                aVar.a(dataRes.thread_topic.get(i2));
                this.jog.add(aVar);
                i = i2 + 1;
            }
        }
        this.jnz = dataRes.pb_sort_info;
        this.jnA = dataRes.sort_type.intValue();
        if (dataRes.manager_election != null) {
            this.jnB = h.b(dataRes.manager_election);
        }
    }

    private void b(DataRes dataRes) {
        if (dataRes.feed_thread_list != null && dataRes.feed_thread_list.size() > 0) {
            List<ThreadInfo> list = dataRes.feed_thread_list;
            if (this.jnS == null) {
                this.jnS = new ArrayList();
            }
            this.jnS.clear();
            for (ThreadInfo threadInfo : list) {
                if (threadInfo != null) {
                    bj bjVar = new bj();
                    bjVar.a(threadInfo);
                    this.jnS.add(bjVar);
                }
            }
            if (this.jnS != null && this.jnS.size() > 15) {
                this.jnS = v.subList(this.jnS, 0, 15);
            }
        }
    }

    private void c(DataRes dataRes) {
        List<String> tL;
        App app = dataRes.banner_list.pb_banner_ad;
        com.baidu.tieba.tbadkCore.data.m mVar = new com.baidu.tieba.tbadkCore.data.m();
        mVar.kSp = true;
        mVar.d(app);
        AppData cWd = mVar.cWd();
        if (cWd.goods != null) {
            if (v.isEmpty(cWd.goods.thread_pic_list) && (tL = AdvertAppInfo.a.tL(cWd.goods.lego_card)) != null && cWd.goods.thread_pic_list != null) {
                cWd.goods.thread_pic_list.addAll(tL);
            }
            this.jnV = mVar;
        }
    }

    private void d(DataRes dataRes) {
        List<App> list = dataRes.banner_list.video_recommend_ad;
        this.joo.clear();
        if (list != null && !list.isEmpty()) {
            for (App app : list) {
                com.baidu.tieba.tbadkCore.data.m mVar = new com.baidu.tieba.tbadkCore.data.m();
                mVar.d(app);
                AppData cWd = mVar.cWd();
                if (!this.joo.contains(mVar) && cWd.goods != null && (!StringUtils.isNull(cWd.goods.user_name) || !StringUtils.isNull(cWd.goods.lego_card))) {
                    mVar.jBg = aQe();
                    this.joo.add(mVar);
                }
            }
        }
    }

    public String cvA() {
        return this.joe;
    }

    public CardHListViewData cvB() {
        return this.jnv;
    }

    public PostData cvC() {
        return this.joa;
    }

    public PostData e(PostData postData) {
        this.joa = postData;
        return postData;
    }

    public n cvD() {
        return this.jnZ;
    }

    public int cvE() {
        return this.jnK;
    }

    public int getIsNewUrl() {
        return this.jnM;
    }

    public void setIsNewUrl(int i) {
        this.jnM = i;
    }

    public List<MuteUser> cvF() {
        return this.jnP;
    }

    public ArrayList<com.baidu.tieba.tbadkCore.data.m> cvG() {
        return this.jnU;
    }

    public com.baidu.tieba.tbadkCore.data.m cvH() {
        return this.jnV;
    }

    public void b(com.baidu.tieba.tbadkCore.data.m mVar) {
        this.jnV = mVar;
    }

    public void cvI() {
        if (this.jnV.cWd() != null) {
            this.jnV.cWd().legoCard = null;
        }
        this.jnV = null;
    }

    public String cvJ() {
        return this.jnu;
    }

    public void Hu(String str) {
        this.jnu = str;
    }

    public g cvK() {
        return this.job;
    }

    public List<bf> cvL() {
        return this.jnY;
    }

    public long cvM() {
        return this.joc;
    }

    public k cvN() {
        return this.jod;
    }

    public void a(k kVar) {
        this.jod = kVar;
    }

    public boolean aQe() {
        return (cvs() == null || !cvs().aJp() || cvs().aKT() == null) ? false : true;
    }

    public AlaLiveInfoCoreData cvO() {
        return this.jnT;
    }

    public List<com.baidu.tbadk.core.data.l> cvP() {
        return this.joi;
    }

    public boolean cvQ() {
        return cvs() != null && cvs().aMy();
    }

    public String cvR() {
        if (this.jnz != null && this.jnz.size() > this.jnA) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.jnz.size()) {
                    break;
                } else if (this.jnz.get(i2).sort_type.intValue() != this.jnA) {
                    i = i2 + 1;
                } else {
                    return this.jnz.get(i2).sort_name;
                }
            }
        }
        return "";
    }

    public com.baidu.tieba.pb.videopb.c.a cvS() {
        return this.jok;
    }

    public int cvT() {
        return this.joj;
    }

    public void zj(int i) {
        this.joj = i;
    }

    public List<com.baidu.tieba.tbadkCore.data.m> cvU() {
        return this.joo;
    }

    private boolean c(ThreadInfo threadInfo) {
        if (threadInfo == null || getThreadId() == null || "0".equals(threadInfo.id) || "0".equals(threadInfo.tid)) {
            return false;
        }
        return getThreadId().equals(threadInfo.id) || getThreadId().equals(threadInfo.tid);
    }

    private boolean d(ThreadInfo threadInfo) {
        if (threadInfo == null || threadInfo.baijiahao == null || threadInfo.baijiahao.ori_ugc_nid == null || this.eNR == null || this.eNR.getBaijiahaoData() == null || this.eNR.getBaijiahaoData().oriUgcNid == null || "0".equals(threadInfo.baijiahao.ori_ugc_nid)) {
            return false;
        }
        return threadInfo.baijiahao.ori_ugc_nid.equals(this.eNR.getBaijiahaoData().oriUgcNid);
    }
}

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
    public a jnB;
    private String jnH;
    private int jnI;
    private List<bj> jnO;
    private AlaLiveInfoCoreData jnP;
    private TwzhiboAnti jnS;
    private List<bf> jnT;
    private List<bf> jnU;
    private PostData jnW;
    private g jnX;
    private long jnY;
    private k jnZ;
    public AppealInfo jnp;
    public String jnq;
    public CardHListViewData jnr;
    public String jns;
    public int jnt;
    public int jnu;
    public List<PbSortType> jnv;
    public int jnw;
    public h jnx;
    private String joa;
    private String job;
    private List<com.baidu.tbadk.core.data.l> joe;
    private com.baidu.tieba.pb.videopb.c.a jog;
    private PostData joh;
    public boolean joj;
    public boolean jny = false;
    public boolean jnz = false;
    public boolean jnA = false;
    public boolean jnC = false;
    private boolean jnM = true;
    private ArrayList<com.baidu.tieba.tbadkCore.data.m> jnQ = new ArrayList<>();
    private com.baidu.tieba.tbadkCore.data.m jnR = null;
    private int jof = 0;
    public int joi = 0;
    public int WA = 0;
    private List<com.baidu.tieba.tbadkCore.data.m> jok = new ArrayList();
    private ForumData forum = new ForumData();
    private bf jnD = new bf();
    private bj eNM = new bj();
    private ArrayList<PostData> jnE = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private ap page = new ap();
    private AntiData anti = new AntiData();
    private com.baidu.tbadk.data.f jnF = new com.baidu.tbadk.data.f();
    private int jnG = 0;
    private final UserData userData = new UserData();
    private List<MuteUser> jnL = new ArrayList();
    private as jnJ = new as();
    private at jnN = new at();
    private ab jnK = new ab();
    private n jnV = new n();
    private List<bb.a> joc = new ArrayList();
    private HashSet<String> jod = new HashSet<>();

    public e() {
        this.jnI = 0;
        this.jnS = null;
        this.jnI = 0;
        this.jnS = new TwzhiboAnti();
    }

    public boolean cvs() {
        return this.jnM;
    }

    public void qE(boolean z) {
        this.jnM = z;
    }

    public boolean isValid() {
        return this.jnE != null && this.jnE.size() > 0;
    }

    public String[] fb(Context context) {
        String str = null;
        String str2 = "";
        if (isValid()) {
            int size = this.jnE.size() > 30 ? 30 : this.jnE.size();
            if (cvu() == null || cvu().aKE() == null || aq.isEmpty(cvu().aKE().getUserId())) {
                return new String[]{null, ""};
            }
            String userId = cvu().aKE().getUserId();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                PostData postData = (PostData) v.getItem(this.jnE, i);
                if (postData != null && postData.aKE() != null && !aq.isEmpty(postData.aKE().getUserId()) && aq.equals(userId, postData.aKE().getUserId())) {
                    if (aq.isEmpty(str)) {
                        str = postData.cWy();
                    }
                    String cWw = aq.isEmpty(str2) ? postData.cWw() : str2;
                    if (!aq.isEmpty(str) && !aq.isEmpty(cWw)) {
                        str2 = cWw;
                        break;
                    }
                    str2 = cWw;
                }
                i++;
                str = str;
            }
            if (aq.isEmpty(str)) {
                str = "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            }
            PostData postData2 = this.jnE.get(0);
            if (this.eNM != null && this.eNM.aLB() != null && this.eNM.aLB().getGroup_id() != 0) {
                str2 = "[" + context.getString(R.string.photo_live_tips) + "] " + str2;
            }
            if (this.eNM != null && this.eNM.aJr() && postData2 != null && postData2.bcr() != null) {
                str = postData2.bcr().getThumbUrl();
            }
        }
        return new String[]{str, str2};
    }

    public ForumData getForum() {
        return this.forum;
    }

    public bf cvt() {
        return this.jnD;
    }

    public void e(bf bfVar) {
        this.jnD = bfVar;
    }

    public String getForumId() {
        if (this.forum == null) {
            return "";
        }
        return this.forum.getId();
    }

    public bj cvu() {
        return this.eNM;
    }

    public void aG(bj bjVar) {
        this.eNM = bjVar;
    }

    public List<bj> cvv() {
        return this.jnO;
    }

    public String getThreadId() {
        if (this.eNM == null) {
            return "";
        }
        return this.eNM.getId();
    }

    public ArrayList<PostData> cvw() {
        return this.jnE;
    }

    public ap getPage() {
        return this.page;
    }

    public ab cvx() {
        return this.jnK;
    }

    public at cvy() {
        return this.jnN;
    }

    public void a(ap apVar, int i) {
        this.page.jJ(apVar.aJy());
        this.page.jH(apVar.aID());
        this.page.jG(apVar.aJv());
        this.page.jK(apVar.aJz());
        this.page.jI(apVar.aJx());
        if (i == 0) {
            this.page = apVar;
        } else if (i == 1) {
            this.page.jL(apVar.aJA());
        } else if (i == 2) {
            this.page.jM(apVar.aJB());
        }
    }

    public AntiData getAnti() {
        return this.anti;
    }

    public UserData getUserData() {
        return this.userData;
    }

    public boolean aGZ() {
        return this.eNM.aKM() != 0;
    }

    public void gk(boolean z) {
        if (this.eNM != null) {
            if (z) {
                this.eNM.jU(1);
            } else {
                this.eNM.jU(0);
            }
        }
    }

    public String aGY() {
        if (this.eNM != null) {
            return this.eNM.aKN();
        }
        return null;
    }

    public void Hq(String str) {
        if (this.eNM != null) {
            this.eNM.tU(str);
        }
    }

    public String cvz() {
        return this.job;
    }

    public boolean cvA() {
        return (this.eNM == null || this.eNM.aKP() == null || this.eNM.aKP().size() <= 0 || this.eNM.aKP().get(0) == null || !this.eNM.aKP().get(0).aIE()) ? false : true;
    }

    public PostData cvB() {
        return this.joh;
    }

    public void d(PostData postData) {
        this.joh = postData;
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                com.baidu.tieba.recapp.d.a.cOb().JD(dataRes.asp_shown_info);
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
                this.jnD.parserProtobuf(dataRes.display_forum);
                this.eNM.setUserMap(this.userMap);
                this.eNM.a(dataRes.thread);
                this.jnJ.a(dataRes.news_info);
                switch (this.jnJ.cYs) {
                    case 1:
                        this.jnK.jyf = this.jnJ;
                        break;
                    case 2:
                        this.jnK.jyg = this.jnJ;
                        break;
                    case 3:
                        this.jnK.jyh = this.jnJ;
                        break;
                    default:
                        this.jnK.jyg = this.jnJ;
                        break;
                }
                this.jnN.a(dataRes.recommend_book);
                b(dataRes, context);
                this.joh = new PostData();
                this.joh.Di(1);
                this.joh.setUserMap(this.userMap);
                this.joh.tS(this.forum.isBrandForum);
                this.joh.setTime(this.eNM.getCreateTime());
                if (dataRes.first_floor_post != null) {
                    this.joh.a(dataRes.first_floor_post, context);
                }
                if (this.eNM != null && this.eNM.isShareThread) {
                    this.joh.h(this.eNM.dto);
                }
                this.page.a(dataRes.page);
                this.anti.parserProtobuf(dataRes.anti);
                this.jnF.a(dataRes.location);
                if (dataRes.user != null) {
                    this.jnG = dataRes.user.is_manager.intValue();
                }
                this.userData.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.jnL.add(muteUser);
                        }
                    }
                }
                this.eNM.jQ(this.eNM.aKv() > 0 ? this.eNM.aKv() - 1 : 0);
                List<AppData> cNm = q.cNo().cNm();
                if (cNm != null) {
                    cNm.clear();
                }
                this.jnR = null;
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        com.baidu.tieba.tbadkCore.data.m mVar = new com.baidu.tieba.tbadkCore.data.m();
                        mVar.d(app);
                        AppData cWf = mVar.cWf();
                        if (!this.jnQ.contains(mVar) && cWf.goods != null && (!StringUtils.isNull(cWf.goods.user_name) || !StringUtils.isNull(cWf.goods.lego_card))) {
                            mVar.jBc = aQh();
                            this.jnQ.add(mVar);
                            if (cNm != null) {
                                cNm.add(mVar.cWf());
                            }
                        }
                    }
                    c(dataRes);
                    d(dataRes);
                }
                q.cNo().cNn();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.userData.getIsSelectTail());
                }
                this.jnS.parserProtobuf(dataRes.twzhibo_anti);
                this.jnp = dataRes.appeal_info;
                if (dataRes.forum_headline_img_info != null) {
                    this.jnX = new g();
                    this.jnX.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.guess_like != null) {
                    this.jnr = new CardHListViewData();
                    this.jnr.parseProtobuf(dataRes.guess_like);
                }
                b(dataRes);
                if (v.getCount(dataRes.repost_recommend_forum_list) > 0) {
                    if (this.jnT == null) {
                        this.jnT = new ArrayList();
                    }
                    for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                        bf bfVar = new bf();
                        bfVar.parserProtobuf(simpleForum);
                        this.jnT.add(bfVar);
                    }
                }
                if (v.getCount(dataRes.from_forum_list) > 0) {
                    if (this.jnU == null) {
                        this.jnU = new ArrayList();
                    }
                    for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                        if (simpleForum2 != null) {
                            bf bfVar2 = new bf();
                            bfVar2.parserProtobuf(simpleForum2);
                            this.jnU.add(bfVar2);
                        }
                    }
                }
                this.job = dataRes.multi_forum_text;
                if (this.jnY >= 0) {
                    this.jnY = dataRes.thread_freq_num.longValue();
                }
                a(dataRes);
                if (this.joe == null) {
                    this.joe = new ArrayList();
                }
                this.joe.clear();
                if (dataRes.bjh_recommend != null) {
                    int i2 = 1;
                    for (ThreadInfo threadInfo : dataRes.bjh_recommend) {
                        if (threadInfo != null && !c(threadInfo) && !d(threadInfo)) {
                            com.baidu.tbadk.core.data.l lVar = new com.baidu.tbadk.core.data.l();
                            lVar.setFloorNum(i2);
                            lVar.a(threadInfo);
                            this.joe.add(lVar);
                            i2++;
                        }
                    }
                }
                if (this.jog == null && dataRes.promotion != null) {
                    this.jog = new com.baidu.tieba.pb.videopb.c.a();
                    this.jog.a(dataRes.promotion);
                }
                if (dataRes.business_promot_info != null) {
                    this.jny = dataRes.business_promot_info.is_promot.longValue() == 1;
                    this.jnz = dataRes.business_promot_info.is_headlinepost.intValue() == 1;
                    this.jnA = dataRes.business_promot_info.is_s_card.intValue() == 1;
                    if (dataRes.business_promot_info.send_card_info != null) {
                        b bVar = new b();
                        bVar.a(dataRes.business_promot_info.send_card_info);
                        if (this.jnB == null) {
                            this.jnB = new a();
                        }
                        this.jnB.a(bVar);
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
                if (!this.jod.contains(String.valueOf(post.id))) {
                    PostData postData = new PostData();
                    postData.setUserMap(this.userMap);
                    postData.tS(this.forum.isBrandForum);
                    postData.a(post, context);
                    postData.a(cvu().aKp());
                    this.jod.add(postData.getId());
                    if (postData.cWr() == 1 && this.eNM.aLp()) {
                        if (cvA()) {
                            postData.setPostType(0);
                        } else {
                            postData.setPostType(this.eNM.aLo());
                        }
                    } else if (postData.cWr() == 1 && this.eNM.aLJ()) {
                        postData.setPostType(41);
                    } else if (postData.cWr() == 1 && this.eNM != null && this.eNM.aJr()) {
                        postData.setPostType(0);
                        postData.bcr();
                        if (this.eNM.aKC() == null || this.eNM.aKC().size() == 0) {
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
                            postData.c(new TbRichText((Context) TbadkCoreApplication.getInst(), this.eNM.aKC(), true));
                        }
                        this.jnW = postData;
                    }
                    if (postData.cWr() == 1 && this.eNM != null && this.eNM.isShareThread) {
                        postData.h(this.eNM.dto);
                    }
                    this.jnE.add(postData);
                }
            }
        }
    }

    private void a(DataRes dataRes) {
        this.jnZ = new k(this.eNM, this.anti);
        this.jns = dataRes.partial_visible_toast;
        if (dataRes.follow_tip != null && dataRes.follow_tip.is_toast_tip.intValue() == 1) {
            this.jnH = dataRes.follow_tip.tip_text;
        }
        this.jnP = new AlaLiveInfoCoreData();
        if (dataRes.ala_info != null) {
            this.jnP.parserProtoBuf(dataRes.ala_info);
        }
        this.joa = dataRes.fold_tip;
        this.jnt = dataRes.exp_news_today.intValue();
        this.jnu = dataRes.exp_guide_today.intValue();
        if (!v.isEmpty(dataRes.thread_topic)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= dataRes.thread_topic.size()) {
                    break;
                }
                bb.a aVar = new bb.a();
                aVar.a(dataRes.thread_topic.get(i2));
                this.joc.add(aVar);
                i = i2 + 1;
            }
        }
        this.jnv = dataRes.pb_sort_info;
        this.jnw = dataRes.sort_type.intValue();
        if (dataRes.manager_election != null) {
            this.jnx = h.b(dataRes.manager_election);
        }
    }

    private void b(DataRes dataRes) {
        if (dataRes.feed_thread_list != null && dataRes.feed_thread_list.size() > 0) {
            List<ThreadInfo> list = dataRes.feed_thread_list;
            if (this.jnO == null) {
                this.jnO = new ArrayList();
            }
            this.jnO.clear();
            for (ThreadInfo threadInfo : list) {
                if (threadInfo != null) {
                    bj bjVar = new bj();
                    bjVar.a(threadInfo);
                    this.jnO.add(bjVar);
                }
            }
            if (this.jnO != null && this.jnO.size() > 15) {
                this.jnO = v.subList(this.jnO, 0, 15);
            }
        }
    }

    private void c(DataRes dataRes) {
        List<String> tI;
        App app = dataRes.banner_list.pb_banner_ad;
        com.baidu.tieba.tbadkCore.data.m mVar = new com.baidu.tieba.tbadkCore.data.m();
        mVar.kSl = true;
        mVar.d(app);
        AppData cWf = mVar.cWf();
        if (cWf.goods != null) {
            if (v.isEmpty(cWf.goods.thread_pic_list) && (tI = AdvertAppInfo.a.tI(cWf.goods.lego_card)) != null && cWf.goods.thread_pic_list != null) {
                cWf.goods.thread_pic_list.addAll(tI);
            }
            this.jnR = mVar;
        }
    }

    private void d(DataRes dataRes) {
        List<App> list = dataRes.banner_list.video_recommend_ad;
        this.jok.clear();
        if (list != null && !list.isEmpty()) {
            for (App app : list) {
                com.baidu.tieba.tbadkCore.data.m mVar = new com.baidu.tieba.tbadkCore.data.m();
                mVar.d(app);
                AppData cWf = mVar.cWf();
                if (!this.jok.contains(mVar) && cWf.goods != null && (!StringUtils.isNull(cWf.goods.user_name) || !StringUtils.isNull(cWf.goods.lego_card))) {
                    mVar.jBc = aQh();
                    this.jok.add(mVar);
                }
            }
        }
    }

    public String cvC() {
        return this.joa;
    }

    public CardHListViewData cvD() {
        return this.jnr;
    }

    public PostData cvE() {
        return this.jnW;
    }

    public PostData e(PostData postData) {
        this.jnW = postData;
        return postData;
    }

    public n cvF() {
        return this.jnV;
    }

    public int cvG() {
        return this.jnG;
    }

    public int getIsNewUrl() {
        return this.jnI;
    }

    public void setIsNewUrl(int i) {
        this.jnI = i;
    }

    public List<MuteUser> cvH() {
        return this.jnL;
    }

    public ArrayList<com.baidu.tieba.tbadkCore.data.m> cvI() {
        return this.jnQ;
    }

    public com.baidu.tieba.tbadkCore.data.m cvJ() {
        return this.jnR;
    }

    public void b(com.baidu.tieba.tbadkCore.data.m mVar) {
        this.jnR = mVar;
    }

    public void cvK() {
        if (this.jnR.cWf() != null) {
            this.jnR.cWf().legoCard = null;
        }
        this.jnR = null;
    }

    public String cvL() {
        return this.jnq;
    }

    public void Hr(String str) {
        this.jnq = str;
    }

    public g cvM() {
        return this.jnX;
    }

    public List<bf> cvN() {
        return this.jnU;
    }

    public long cvO() {
        return this.jnY;
    }

    public k cvP() {
        return this.jnZ;
    }

    public void a(k kVar) {
        this.jnZ = kVar;
    }

    public boolean aQh() {
        return (cvu() == null || !cvu().aJr() || cvu().aKV() == null) ? false : true;
    }

    public AlaLiveInfoCoreData cvQ() {
        return this.jnP;
    }

    public List<com.baidu.tbadk.core.data.l> cvR() {
        return this.joe;
    }

    public boolean cvS() {
        return cvu() != null && cvu().aMA();
    }

    public String cvT() {
        if (this.jnv != null && this.jnv.size() > this.jnw) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.jnv.size()) {
                    break;
                } else if (this.jnv.get(i2).sort_type.intValue() != this.jnw) {
                    i = i2 + 1;
                } else {
                    return this.jnv.get(i2).sort_name;
                }
            }
        }
        return "";
    }

    public com.baidu.tieba.pb.videopb.c.a cvU() {
        return this.jog;
    }

    public int cvV() {
        return this.jof;
    }

    public void zj(int i) {
        this.jof = i;
    }

    public List<com.baidu.tieba.tbadkCore.data.m> cvW() {
        return this.jok;
    }

    private boolean c(ThreadInfo threadInfo) {
        if (threadInfo == null || getThreadId() == null || "0".equals(threadInfo.id) || "0".equals(threadInfo.tid)) {
            return false;
        }
        return getThreadId().equals(threadInfo.id) || getThreadId().equals(threadInfo.tid);
    }

    private boolean d(ThreadInfo threadInfo) {
        if (threadInfo == null || threadInfo.baijiahao == null || threadInfo.baijiahao.ori_ugc_nid == null || this.eNM == null || this.eNM.getBaijiahaoData() == null || this.eNM.getBaijiahaoData().oriUgcNid == null || "0".equals(threadInfo.baijiahao.ori_ugc_nid)) {
            return false;
        }
        return threadInfo.baijiahao.ori_ugc_nid.equals(this.eNM.getBaijiahaoData().oriUgcNid);
    }
}

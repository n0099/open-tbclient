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
/* loaded from: classes6.dex */
public class f {
    public AppealInfo ivZ;
    private AlaLiveInfoCoreData iwA;
    private TwzhiboAnti iwD;
    private List<bf> iwE;
    private List<bf> iwF;
    private PostData iwH;
    private h iwI;
    private long iwJ;
    private l iwK;
    private String iwL;
    private String iwM;
    private List<com.baidu.tbadk.core.data.l> iwP;
    private com.baidu.tieba.pb.videopb.c.a iwR;
    private PostData iwS;
    public String iwa;
    public CardHListViewData iwb;
    public String iwc;
    public int iwd;
    public int iwe;
    public List<PbSortType> iwf;
    public int iwg;
    public i iwh;
    public b iwl;
    private String iwr;
    private int iws;
    private a iwx;
    private List<bj> iwz;
    public boolean iwi = false;
    public boolean iwj = false;
    public boolean iwk = false;
    public boolean iwm = false;
    private boolean iww = true;
    private ArrayList<com.baidu.tieba.tbadkCore.data.m> iwB = new ArrayList<>();
    private com.baidu.tieba.tbadkCore.data.m iwC = null;
    private int iwQ = 0;
    private ForumData forum = new ForumData();
    private bf iwn = new bf();
    private bj eft = new bj();
    private ArrayList<PostData> iwo = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private ap page = new ap();
    private AntiData anti = new AntiData();
    private com.baidu.tbadk.data.f iwp = new com.baidu.tbadk.data.f();
    private int iwq = 0;
    private final UserData userData = new UserData();
    private List<MuteUser> iwv = new ArrayList();
    private as iwt = new as();
    private at iwy = new at();
    private ae iwu = new ae();
    private o iwG = new o();
    private List<bb.a> iwN = new ArrayList();
    private HashSet<String> iwO = new HashSet<>();

    public f() {
        this.iws = 0;
        this.iwD = null;
        this.iws = 0;
        this.iwD = new TwzhiboAnti();
    }

    public boolean chI() {
        return this.iww;
    }

    public void pf(boolean z) {
        this.iww = z;
    }

    public boolean isValid() {
        return this.iwo != null && this.iwo.size() > 0;
    }

    public String[] fg(Context context) {
        String str = null;
        String str2 = "";
        if (isValid()) {
            int size = this.iwo.size() > 30 ? 30 : this.iwo.size();
            if (chK() == null || chK().azE() == null || aq.isEmpty(chK().azE().getUserId())) {
                return new String[]{null, ""};
            }
            String userId = chK().azE().getUserId();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                PostData postData = (PostData) v.getItem(this.iwo, i);
                if (postData != null && postData.azE() != null && !aq.isEmpty(postData.azE().getUserId()) && aq.equals(userId, postData.azE().getUserId())) {
                    if (aq.isEmpty(str)) {
                        str = postData.cIA();
                    }
                    String cIy = aq.isEmpty(str2) ? postData.cIy() : str2;
                    if (!aq.isEmpty(str) && !aq.isEmpty(cIy)) {
                        str2 = cIy;
                        break;
                    }
                    str2 = cIy;
                }
                i++;
                str = str;
            }
            if (aq.isEmpty(str)) {
                str = "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            }
            PostData postData2 = this.iwo.get(0);
            if (this.eft != null && this.eft.aAC() != null && this.eft.aAC().getGroup_id() != 0) {
                str2 = "[" + context.getString(R.string.photo_live_tips) + "] " + str2;
            }
            if (this.eft != null && this.eft.aAE() && postData2 != null && postData2.aRp() != null) {
                str = postData2.aRp().getThumbUrl();
            }
        }
        return new String[]{str, str2};
    }

    public ForumData getForum() {
        return this.forum;
    }

    public bf chJ() {
        return this.iwn;
    }

    public void e(bf bfVar) {
        this.iwn = bfVar;
    }

    public String getForumId() {
        if (this.forum == null) {
            return "";
        }
        return this.forum.getId();
    }

    public bj chK() {
        return this.eft;
    }

    public void az(bj bjVar) {
        this.eft = bjVar;
    }

    public List<bj> chL() {
        return this.iwz;
    }

    public String getThreadId() {
        if (this.eft == null) {
            return "";
        }
        return this.eft.getId();
    }

    public ArrayList<PostData> chM() {
        return this.iwo;
    }

    public ap getPage() {
        return this.page;
    }

    public ae chN() {
        return this.iwu;
    }

    public at chO() {
        return this.iwy;
    }

    public void a(ap apVar, int i) {
        this.page.jk(apVar.ayw());
        this.page.ji(apVar.axE());
        this.page.jh(apVar.ayt());
        this.page.jl(apVar.ayx());
        this.page.jj(apVar.ayv());
        if (i == 0) {
            this.page = apVar;
        } else if (i == 1) {
            this.page.jm(apVar.ayy());
        } else if (i == 2) {
            this.page.jn(apVar.ayz());
        }
    }

    public AntiData getAnti() {
        return this.anti;
    }

    public UserData getUserData() {
        return this.userData;
    }

    public boolean awd() {
        return this.eft.azM() != 0;
    }

    public void fa(boolean z) {
        if (this.eft != null) {
            if (z) {
                this.eft.jw(1);
            } else {
                this.eft.jw(0);
            }
        }
    }

    public String awc() {
        if (this.eft != null) {
            return this.eft.azN();
        }
        return null;
    }

    public void Fj(String str) {
        if (this.eft != null) {
            this.eft.sn(str);
        }
    }

    public String chP() {
        return this.iwM;
    }

    public boolean chQ() {
        return (this.eft == null || this.eft.azP() == null || this.eft.azP().size() <= 0 || this.eft.azP().get(0) == null || !this.eft.azP().get(0).axF()) ? false : true;
    }

    public PostData chR() {
        return this.iwS;
    }

    public void d(PostData postData) {
        this.iwS = postData;
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                com.baidu.tieba.recapp.d.a.cAE().HA(dataRes.asp_shown_info);
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
                this.iwn.parserProtobuf(dataRes.display_forum);
                this.eft.setUserMap(this.userMap);
                this.eft.a(dataRes.thread);
                this.iwt.a(dataRes.news_info);
                switch (this.iwt.cuY) {
                    case 1:
                        this.iwu.iHi = this.iwt;
                        break;
                    case 2:
                        this.iwu.iHj = this.iwt;
                        break;
                    case 3:
                        this.iwu.iHk = this.iwt;
                        break;
                    default:
                        this.iwu.iHj = this.iwt;
                        break;
                }
                this.iwy.a(dataRes.recommend_book);
                b(dataRes, context);
                this.iwS = new PostData();
                this.iwS.Cl(1);
                this.iwS.setUserMap(this.userMap);
                this.iwS.su(this.forum.isBrandForum);
                this.iwS.setTime(this.eft.getCreateTime());
                if (dataRes.first_floor_post != null) {
                    this.iwS.a(dataRes.first_floor_post, context);
                }
                if (this.eft != null && this.eft.isShareThread) {
                    this.iwS.g(this.eft.cPD);
                }
                this.page.a(dataRes.page);
                this.anti.parserProtobuf(dataRes.anti);
                this.iwp.a(dataRes.location);
                if (dataRes.user != null) {
                    this.iwq = dataRes.user.is_manager.intValue();
                }
                this.userData.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.iwv.add(muteUser);
                        }
                    }
                }
                this.eft.js(this.eft.azv() > 0 ? this.eft.azv() - 1 : 0);
                List<AppData> czM = r.czO().czM();
                if (czM != null) {
                    czM.clear();
                }
                this.iwC = null;
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        com.baidu.tieba.tbadkCore.data.m mVar = new com.baidu.tieba.tbadkCore.data.m();
                        mVar.d(app);
                        AppData cIh = mVar.cIh();
                        if (!this.iwB.contains(mVar) && cIh.goods != null && (!StringUtils.isNull(cIh.goods.user_name) || !StringUtils.isNull(cIh.goods.lego_card))) {
                            this.iwB.add(mVar);
                            if (czM != null) {
                                czM.add(mVar.cIh());
                            }
                        }
                    }
                    c(dataRes);
                }
                r.czO().czN();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.userData.getIsSelectTail());
                }
                this.iwD.parserProtobuf(dataRes.twzhibo_anti);
                this.ivZ = dataRes.appeal_info;
                if (dataRes.god_card != null) {
                    this.iwx = new a();
                    this.iwx.a(dataRes.god_card);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.iwI = new h();
                    this.iwI.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.guess_like != null) {
                    this.iwb = new CardHListViewData();
                    this.iwb.parseProtobuf(dataRes.guess_like);
                }
                b(dataRes);
                if (v.getCount(dataRes.repost_recommend_forum_list) > 0) {
                    if (this.iwE == null) {
                        this.iwE = new ArrayList();
                    }
                    for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                        bf bfVar = new bf();
                        bfVar.parserProtobuf(simpleForum);
                        this.iwE.add(bfVar);
                    }
                }
                if (v.getCount(dataRes.from_forum_list) > 0) {
                    if (this.iwF == null) {
                        this.iwF = new ArrayList();
                    }
                    for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                        if (simpleForum2 != null) {
                            bf bfVar2 = new bf();
                            bfVar2.parserProtobuf(simpleForum2);
                            this.iwF.add(bfVar2);
                        }
                    }
                }
                this.iwM = dataRes.multi_forum_text;
                if (this.iwJ >= 0) {
                    this.iwJ = dataRes.thread_freq_num.longValue();
                }
                a(dataRes);
                if (this.iwP == null) {
                    this.iwP = new ArrayList();
                }
                this.iwP.clear();
                if (dataRes.bjh_recommend != null) {
                    int i2 = 1;
                    for (ThreadInfo threadInfo : dataRes.bjh_recommend) {
                        if (threadInfo != null && !c(threadInfo) && !d(threadInfo)) {
                            com.baidu.tbadk.core.data.l lVar = new com.baidu.tbadk.core.data.l();
                            lVar.setFloorNum(i2);
                            lVar.a(threadInfo);
                            this.iwP.add(lVar);
                            i2++;
                        }
                    }
                }
                if (this.iwR == null && dataRes.promotion != null) {
                    this.iwR = new com.baidu.tieba.pb.videopb.c.a();
                    this.iwR.a(dataRes.promotion);
                }
                if (dataRes.business_promot_info != null) {
                    this.iwi = dataRes.business_promot_info.is_promot.longValue() == 1;
                    this.iwj = dataRes.business_promot_info.is_headlinepost.intValue() == 1;
                    this.iwk = dataRes.business_promot_info.is_s_card.intValue() == 1;
                    if (dataRes.business_promot_info.send_card_info != null) {
                        c cVar = new c();
                        cVar.a(dataRes.business_promot_info.send_card_info);
                        if (this.iwl == null) {
                            this.iwl = new b();
                        }
                        this.iwl.a(cVar);
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
                if (!this.iwO.contains(String.valueOf(post.id))) {
                    PostData postData = new PostData();
                    postData.setUserMap(this.userMap);
                    postData.su(this.forum.isBrandForum);
                    postData.a(post, context);
                    postData.a(chK().azp());
                    this.iwO.add(postData.getId());
                    if (postData.cIt() == 1 && this.eft.aAp()) {
                        if (chQ()) {
                            postData.setPostType(0);
                        } else {
                            postData.setPostType(this.eft.aAo());
                        }
                    } else if (postData.cIt() == 1 && this.eft.aAK()) {
                        postData.setPostType(41);
                    } else if (postData.cIt() == 1 && this.eft != null && this.eft.aAE()) {
                        postData.setPostType(0);
                        postData.aRp();
                        if (this.eft.azC() == null || this.eft.azC().size() == 0) {
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
                            postData.c(new TbRichText((Context) TbadkCoreApplication.getInst(), this.eft.azC(), true));
                        }
                        this.iwH = postData;
                    }
                    if (postData.cIt() == 1 && this.eft != null && this.eft.isShareThread) {
                        postData.g(this.eft.cPD);
                    }
                    this.iwo.add(postData);
                }
            }
        }
    }

    private void a(DataRes dataRes) {
        this.iwK = new l();
        this.iwK.Nl = this.eft;
        this.iwc = dataRes.partial_visible_toast;
        if (dataRes.follow_tip != null && dataRes.follow_tip.is_toast_tip.intValue() == 1) {
            this.iwr = dataRes.follow_tip.tip_text;
        }
        this.iwA = new AlaLiveInfoCoreData();
        if (dataRes.ala_info != null) {
            this.iwA.parserProtoBuf(dataRes.ala_info);
        }
        this.iwL = dataRes.fold_tip;
        this.iwd = dataRes.exp_news_today.intValue();
        this.iwe = dataRes.exp_guide_today.intValue();
        if (!v.isEmpty(dataRes.thread_topic)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= dataRes.thread_topic.size()) {
                    break;
                }
                bb.a aVar = new bb.a();
                aVar.a(dataRes.thread_topic.get(i2));
                this.iwN.add(aVar);
                i = i2 + 1;
            }
        }
        this.iwf = dataRes.pb_sort_info;
        this.iwg = dataRes.sort_type.intValue();
        if (dataRes.manager_election != null) {
            this.iwh = i.a(dataRes.manager_election);
        }
    }

    private void b(DataRes dataRes) {
        if (dataRes.feed_thread_list != null && dataRes.feed_thread_list.size() > 0) {
            List<ThreadInfo> list = dataRes.feed_thread_list;
            if (this.iwz == null) {
                this.iwz = new ArrayList();
            }
            this.iwz.clear();
            for (ThreadInfo threadInfo : list) {
                if (threadInfo != null) {
                    bj bjVar = new bj();
                    bjVar.a(threadInfo);
                    this.iwz.add(bjVar);
                }
            }
            if (this.iwz != null && this.iwz.size() > 15) {
                this.iwz = v.subList(this.iwz, 0, 15);
            }
        }
    }

    private void c(DataRes dataRes) {
        List<String> sb;
        App app = dataRes.banner_list.pb_banner_ad;
        com.baidu.tieba.tbadkCore.data.m mVar = new com.baidu.tieba.tbadkCore.data.m();
        mVar.kbG = true;
        mVar.d(app);
        AppData cIh = mVar.cIh();
        if (cIh.goods != null) {
            if (v.isEmpty(cIh.goods.thread_pic_list) && (sb = AdvertAppInfo.a.sb(cIh.goods.lego_card)) != null && cIh.goods.thread_pic_list != null) {
                cIh.goods.thread_pic_list.addAll(sb);
            }
            this.iwC = mVar;
        }
    }

    public String chS() {
        return this.iwL;
    }

    public CardHListViewData chT() {
        return this.iwb;
    }

    public PostData chU() {
        return this.iwH;
    }

    public PostData e(PostData postData) {
        this.iwH = postData;
        return postData;
    }

    public o chV() {
        return this.iwG;
    }

    public int chW() {
        return this.iwq;
    }

    public int getIsNewUrl() {
        return this.iws;
    }

    public void setIsNewUrl(int i) {
        this.iws = i;
    }

    public List<MuteUser> chX() {
        return this.iwv;
    }

    public ArrayList<com.baidu.tieba.tbadkCore.data.m> chY() {
        return this.iwB;
    }

    public com.baidu.tieba.tbadkCore.data.m chZ() {
        return this.iwC;
    }

    public void b(com.baidu.tieba.tbadkCore.data.m mVar) {
        this.iwC = mVar;
    }

    public void cia() {
        if (this.iwC.cIh() != null) {
            this.iwC.cIh().legoCard = null;
        }
        this.iwC = null;
    }

    public a cib() {
        return this.iwx;
    }

    public String cic() {
        return this.iwa;
    }

    public void Fk(String str) {
        this.iwa = str;
    }

    public h cid() {
        return this.iwI;
    }

    public List<bf> cie() {
        return this.iwF;
    }

    public long cif() {
        return this.iwJ;
    }

    public l cig() {
        return this.iwK;
    }

    public void a(l lVar) {
        this.iwK = lVar;
    }

    public boolean cih() {
        return (chK() == null || !chK().aAE() || chK().azV() == null) ? false : true;
    }

    public AlaLiveInfoCoreData cii() {
        return this.iwA;
    }

    public List<com.baidu.tbadk.core.data.l> cij() {
        return this.iwP;
    }

    public boolean cik() {
        return chK() != null && chK().aBC();
    }

    public String cil() {
        if (this.iwf != null && this.iwf.size() > this.iwg) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.iwf.size()) {
                    break;
                } else if (this.iwf.get(i2).sort_type.intValue() != this.iwg) {
                    i = i2 + 1;
                } else {
                    return this.iwf.get(i2).sort_name;
                }
            }
        }
        return "";
    }

    public com.baidu.tieba.pb.videopb.c.a cim() {
        return this.iwR;
    }

    public int cin() {
        return this.iwQ;
    }

    public void yo(int i) {
        this.iwQ = i;
    }

    private boolean c(ThreadInfo threadInfo) {
        if (threadInfo == null || getThreadId() == null || "0".equals(threadInfo.id) || "0".equals(threadInfo.tid)) {
            return false;
        }
        return getThreadId().equals(threadInfo.id) || getThreadId().equals(threadInfo.tid);
    }

    private boolean d(ThreadInfo threadInfo) {
        if (threadInfo == null || threadInfo.baijiahao == null || threadInfo.baijiahao.ori_ugc_nid == null || this.eft == null || this.eft.getBaijiahaoData() == null || this.eft.getBaijiahaoData().oriUgcNid == null || "0".equals(threadInfo.baijiahao.ori_ugc_nid)) {
            return false;
        }
        return threadInfo.baijiahao.ori_ugc_nid.equals(this.eft.getBaijiahaoData().oriUgcNid);
    }
}

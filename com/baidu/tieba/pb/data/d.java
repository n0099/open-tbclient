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
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.pb.pb.main.ad;
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
/* loaded from: classes4.dex */
public class d {
    private long hBA;
    private j hBB;
    public String hBC;
    public int hBD;
    public int hBE;
    public List<PbSortType> hBF;
    public int hBG;
    public g hBH;
    private String hBI;
    private String hBJ;
    private PostData hBM;
    private String hBe;
    private int hBf;
    private a hBk;
    private List<bg> hBm;
    private int hBn;
    private AlaLiveInfoCoreData hBo;
    private TwzhiboAnti hBr;
    public AppealInfo hBs;
    private List<bc> hBt;
    private List<bc> hBu;
    public String hBw;
    private PostData hBx;
    private f hBy;
    public CardHListViewData hBz;
    private boolean hBj = true;
    private ArrayList<com.baidu.tieba.tbadkCore.data.m> hBp = new ArrayList<>();
    private com.baidu.tieba.tbadkCore.data.m hBq = null;
    private ForumData forum = new ForumData();
    private bc hBa = new bc();
    private bg dkl = new bg();
    private ArrayList<PostData> hBb = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private an page = new an();
    private AntiData anti = new AntiData();
    private com.baidu.tbadk.data.f hBc = new com.baidu.tbadk.data.f();
    private int hBd = 0;
    private final UserData userData = new UserData();
    private List<MuteUser> hBi = new ArrayList();
    private ap hBg = new ap();
    private aq hBl = new aq();
    private ad hBh = new ad();
    private m hBv = new m();
    private List<ay.a> hBK = new ArrayList();
    private HashSet<String> hBL = new HashSet<>();

    public boolean bPK() {
        return this.hBj;
    }

    public void nP(boolean z) {
        this.hBj = z;
    }

    public d() {
        this.hBf = 0;
        this.hBr = null;
        this.hBf = 0;
        this.hBr = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.hBb != null && this.hBb.size() > 0;
    }

    public String[] ea(Context context) {
        String str = null;
        String str2 = "";
        if (isValid()) {
            int size = this.hBb.size() > 30 ? 30 : this.hBb.size();
            if (bPM() == null || bPM().adv() == null || com.baidu.tbadk.core.util.ap.isEmpty(bPM().adv().getUserId())) {
                return new String[]{null, ""};
            }
            String userId = bPM().adv().getUserId();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                PostData postData = (PostData) v.c(this.hBb, i);
                if (postData != null && postData.adv() != null && !com.baidu.tbadk.core.util.ap.isEmpty(postData.adv().getUserId()) && com.baidu.tbadk.core.util.ap.equals(userId, postData.adv().getUserId())) {
                    if (com.baidu.tbadk.core.util.ap.isEmpty(str)) {
                        str = postData.cmE();
                    }
                    String cmC = com.baidu.tbadk.core.util.ap.isEmpty(str2) ? postData.cmC() : str2;
                    if (!com.baidu.tbadk.core.util.ap.isEmpty(str) && !com.baidu.tbadk.core.util.ap.isEmpty(cmC)) {
                        str2 = cmC;
                        break;
                    }
                    str2 = cmC;
                }
                i++;
                str = str;
            }
            if (com.baidu.tbadk.core.util.ap.isEmpty(str)) {
                str = "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            }
            PostData postData2 = this.hBb.get(0);
            if (this.dkl != null && this.dkl.aen() != null && this.dkl.aen().getGroup_id() != 0) {
                str2 = "[" + context.getString(R.string.photo_live_tips) + "] " + str2;
            }
            if (this.dkl != null && this.dkl.aep() && postData2 != null && postData2.axK() != null) {
                str = postData2.axK().getThumbUrl();
            }
        }
        return new String[]{str, str2};
    }

    public ForumData getForum() {
        return this.forum;
    }

    public bc bPL() {
        return this.hBa;
    }

    public String getForumId() {
        if (this.forum == null) {
            return "";
        }
        return this.forum.getId();
    }

    public bg bPM() {
        return this.dkl;
    }

    public List<bg> bPN() {
        return this.hBm;
    }

    public String getThreadId() {
        if (this.dkl == null) {
            return "";
        }
        return this.dkl.getId();
    }

    public ArrayList<PostData> bPO() {
        return this.hBb;
    }

    public an getPage() {
        return this.page;
    }

    public ad bPP() {
        return this.hBh;
    }

    public aq bPQ() {
        return this.hBl;
    }

    public void a(an anVar, int i) {
        this.page.gV(anVar.acn());
        this.page.gT(anVar.abC());
        this.page.gS(anVar.ack());
        this.page.gW(anVar.aco());
        this.page.gU(anVar.acm());
        if (i == 0) {
            this.page = anVar;
        } else if (i == 1) {
            this.page.gX(anVar.acp());
        } else if (i == 2) {
            this.page.gY(anVar.acq());
        }
    }

    public AntiData getAnti() {
        return this.anti;
    }

    public UserData getUserData() {
        return this.userData;
    }

    public boolean ZC() {
        return this.dkl.adD() != 0;
    }

    public void ds(boolean z) {
        if (this.dkl != null) {
            if (z) {
                this.dkl.hg(1);
            } else {
                this.dkl.hg(0);
            }
        }
    }

    public String ZB() {
        if (this.dkl != null) {
            return this.dkl.adE();
        }
        return null;
    }

    public void AX(String str) {
        if (this.dkl != null) {
            this.dkl.mr(str);
        }
    }

    public String bPR() {
        return this.hBJ;
    }

    public boolean bPS() {
        return (this.dkl == null || this.dkl.adG() == null || this.dkl.adG().size() <= 0 || this.dkl.adG().get(0) == null || !this.dkl.adG().get(0).abD()) ? false : true;
    }

    public PostData bPT() {
        return this.hBM;
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                com.baidu.tieba.recapp.d.a.cfC().De(dataRes.asp_shown_info);
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
                this.hBa.parserProtobuf(dataRes.display_forum);
                this.dkl.setUserMap(this.userMap);
                this.dkl.a(dataRes.thread);
                this.dkl.setCurrentPage(2);
                this.hBg.a(dataRes.news_info);
                switch (this.hBg.bGX) {
                    case 1:
                        this.hBh.hLF = this.hBg;
                        break;
                    case 2:
                        this.hBh.hLG = this.hBg;
                        break;
                    case 3:
                        this.hBh.hLH = this.hBg;
                        break;
                    default:
                        this.hBh.hLG = this.hBg;
                        break;
                }
                this.hBl.a(dataRes.recommend_book);
                List<Post> list2 = dataRes.post_list;
                if (list2 != null && list2.size() > 0) {
                    for (Post post : dataRes.post_list) {
                        if (!this.hBL.contains(String.valueOf(post.id))) {
                            PostData postData = new PostData();
                            postData.setUserMap(this.userMap);
                            postData.qK(this.forum.isBrandForum);
                            postData.a(post, context);
                            postData.a(bPM().adh());
                            this.hBL.add(postData.getId());
                            if (postData.cmx() == 1 && this.dkl.aeg()) {
                                if (bPS()) {
                                    postData.setPostType(0);
                                } else {
                                    postData.setPostType(this.dkl.aef());
                                }
                            } else if (postData.cmx() == 1 && this.dkl.aev()) {
                                postData.setPostType(41);
                            } else if (postData.cmx() == 1 && this.dkl != null && this.dkl.aep()) {
                                postData.setPostType(0);
                                postData.axK();
                                if (this.dkl.adt() == null || this.dkl.adt().size() == 0) {
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
                                    postData.c(new TbRichText((Context) TbadkCoreApplication.getInst(), this.dkl.adt(), true));
                                }
                                this.hBx = postData;
                            }
                            if (postData.cmx() == 1 && this.dkl != null && this.dkl.isShareThread) {
                                postData.g(this.dkl.bKQ);
                            }
                            this.hBb.add(postData);
                        }
                    }
                }
                if (dataRes.first_floor_post != null) {
                    this.hBM = new PostData();
                    this.hBM.setUserMap(this.userMap);
                    this.hBM.qK(this.forum.isBrandForum);
                    this.hBM.a(dataRes.first_floor_post, context);
                    if (this.dkl != null && this.dkl.isShareThread) {
                        this.hBM.g(this.dkl.bKQ);
                    }
                }
                this.page.a(dataRes.page);
                this.anti.parserProtobuf(dataRes.anti);
                this.hBc.a(dataRes.location);
                if (dataRes.user != null) {
                    this.hBd = dataRes.user.is_manager.intValue();
                }
                this.userData.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.hBi.add(muteUser);
                        }
                    }
                }
                this.dkl.hc(this.dkl.adm() > 0 ? this.dkl.adm() - 1 : 0);
                List<AppData> ceK = r.ceM().ceK();
                if (ceK != null) {
                    ceK.clear();
                }
                this.hBq = null;
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        com.baidu.tieba.tbadkCore.data.m mVar = new com.baidu.tieba.tbadkCore.data.m();
                        mVar.d(app);
                        AppData cml = mVar.cml();
                        if (!this.hBp.contains(mVar) && cml.goods != null && (!StringUtils.isNull(cml.goods.user_name) || !StringUtils.isNull(cml.goods.lego_card))) {
                            this.hBp.add(mVar);
                            if (ceK != null) {
                                ceK.add(mVar.cml());
                            }
                        }
                    }
                    a(dataRes);
                }
                r.ceM().ceL();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.userData.getIsSelectTail());
                }
                this.hBr.parserProtobuf(dataRes.twzhibo_anti);
                this.hBs = dataRes.appeal_info;
                if (dataRes.god_card != null) {
                    this.hBk = new a();
                    this.hBk.a(dataRes.god_card);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.hBy = new f();
                    this.hBy.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.guess_like != null) {
                    this.hBz = new CardHListViewData();
                    this.hBz.parseProtobuf(dataRes.guess_like);
                }
                if (dataRes.feed_thread_list != null && dataRes.feed_thread_list.size() > 0) {
                    List<ThreadInfo> list3 = dataRes.feed_thread_list;
                    if (this.hBm == null) {
                        this.hBm = new ArrayList();
                    }
                    this.hBm.clear();
                    for (ThreadInfo threadInfo : list3) {
                        if (threadInfo != null) {
                            bg bgVar = new bg();
                            bgVar.a(threadInfo);
                            this.hBm.add(bgVar);
                        }
                    }
                    if (this.hBm != null && this.hBm.size() > 15) {
                        this.hBm = v.c(this.hBm, 0, 15);
                    }
                }
                this.hBn = dataRes.is_follow_current_channel.intValue();
                if (v.Z(dataRes.repost_recommend_forum_list) > 0) {
                    if (this.hBt == null) {
                        this.hBt = new ArrayList();
                    }
                    for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                        bc bcVar = new bc();
                        bcVar.parserProtobuf(simpleForum);
                        this.hBt.add(bcVar);
                    }
                }
                if (v.Z(dataRes.from_forum_list) > 0) {
                    if (this.hBu == null) {
                        this.hBu = new ArrayList();
                    }
                    for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                        if (simpleForum2 != null) {
                            bc bcVar2 = new bc();
                            bcVar2.parserProtobuf(simpleForum2);
                            this.hBu.add(bcVar2);
                        }
                    }
                }
                this.hBJ = dataRes.multi_forum_text;
                if (this.hBA >= 0) {
                    this.hBA = dataRes.thread_freq_num.longValue();
                }
                this.hBB = new j();
                this.hBB.cbh = this.dkl;
                this.hBB.b(dataRes);
                this.hBC = dataRes.partial_visible_toast;
                if (dataRes.follow_tip != null && dataRes.follow_tip.is_toast_tip.intValue() == 1) {
                    this.hBe = dataRes.follow_tip.tip_text;
                }
                this.hBo = new AlaLiveInfoCoreData();
                if (dataRes.ala_info != null) {
                    this.hBo.parserProtoBuf(dataRes.ala_info);
                }
                this.hBI = dataRes.fold_tip;
                this.hBD = dataRes.exp_news_today.intValue();
                this.hBE = dataRes.exp_guide_today.intValue();
                if (!v.aa(dataRes.thread_topic)) {
                    for (int i2 = 0; i2 < dataRes.thread_topic.size(); i2++) {
                        ay.a aVar = new ay.a();
                        aVar.a(dataRes.thread_topic.get(i2));
                        this.hBK.add(aVar);
                    }
                }
                this.hBF = dataRes.pb_sort_info;
                this.hBG = dataRes.sort_type.intValue();
                if (dataRes.manager_election != null) {
                    this.hBH = g.a(dataRes.manager_election);
                }
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }

    private void a(DataRes dataRes) {
        List<String> md;
        App app = dataRes.banner_list.pb_banner_ad;
        com.baidu.tieba.tbadkCore.data.m mVar = new com.baidu.tieba.tbadkCore.data.m();
        mVar.iYD = true;
        mVar.d(app);
        AppData cml = mVar.cml();
        if (cml.goods != null) {
            if (v.aa(cml.goods.thread_pic_list) && (md = AdvertAppInfo.a.md(cml.goods.lego_card)) != null && cml.goods.thread_pic_list != null) {
                cml.goods.thread_pic_list.addAll(md);
            }
            this.hBq = mVar;
        }
    }

    public String bPU() {
        return this.hBI;
    }

    public CardHListViewData bPV() {
        return this.hBz;
    }

    public PostData bPW() {
        return this.hBx;
    }

    public PostData d(PostData postData) {
        this.hBx = postData;
        return postData;
    }

    public m bPX() {
        return this.hBv;
    }

    public int bPY() {
        return this.hBd;
    }

    public int getIsNewUrl() {
        return this.hBf;
    }

    public void setIsNewUrl(int i) {
        this.hBf = i;
    }

    public List<MuteUser> bPZ() {
        return this.hBi;
    }

    public ArrayList<com.baidu.tieba.tbadkCore.data.m> bQa() {
        return this.hBp;
    }

    public com.baidu.tieba.tbadkCore.data.m bQb() {
        return this.hBq;
    }

    public void b(com.baidu.tieba.tbadkCore.data.m mVar) {
        this.hBq = mVar;
    }

    public void bQc() {
        if (this.hBq.cml() != null) {
            this.hBq.cml().legoCard = null;
        }
        this.hBq = null;
    }

    public a bQd() {
        return this.hBk;
    }

    public String bQe() {
        return this.hBw;
    }

    public void AY(String str) {
        this.hBw = str;
    }

    public f bQf() {
        return this.hBy;
    }

    public int bQg() {
        return this.hBn;
    }

    public List<bc> bQh() {
        return this.hBu;
    }

    public long bQi() {
        return this.hBA;
    }

    public j bQj() {
        return this.hBB;
    }

    public boolean bQk() {
        return (bPM() == null || !bPM().aep() || bPM().adM() == null) ? false : true;
    }

    public AlaLiveInfoCoreData bQl() {
        return this.hBo;
    }
}

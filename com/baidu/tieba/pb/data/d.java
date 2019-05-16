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
    public int hBA;
    public List<PbSortType> hBB;
    public int hBC;
    public g hBD;
    private String hBE;
    private String hBF;
    private PostData hBI;
    private String hBa;
    private int hBb;
    private a hBg;
    private List<bg> hBi;
    private int hBj;
    private AlaLiveInfoCoreData hBk;
    private TwzhiboAnti hBn;
    public AppealInfo hBo;
    private List<bc> hBp;
    private List<bc> hBq;
    public String hBs;
    private PostData hBt;
    private f hBu;
    public CardHListViewData hBv;
    private long hBw;
    private j hBx;
    public String hBy;
    public int hBz;
    private boolean hBf = true;
    private ArrayList<com.baidu.tieba.tbadkCore.data.m> hBl = new ArrayList<>();
    private com.baidu.tieba.tbadkCore.data.m hBm = null;
    private ForumData forum = new ForumData();
    private bc hAW = new bc();
    private bg dkk = new bg();
    private ArrayList<PostData> hAX = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private an page = new an();
    private AntiData anti = new AntiData();
    private com.baidu.tbadk.data.f hAY = new com.baidu.tbadk.data.f();
    private int hAZ = 0;
    private final UserData userData = new UserData();
    private List<MuteUser> hBe = new ArrayList();
    private ap hBc = new ap();
    private aq hBh = new aq();
    private ad hBd = new ad();
    private m hBr = new m();
    private List<ay.a> hBG = new ArrayList();
    private HashSet<String> hBH = new HashSet<>();

    public boolean bPG() {
        return this.hBf;
    }

    public void nO(boolean z) {
        this.hBf = z;
    }

    public d() {
        this.hBb = 0;
        this.hBn = null;
        this.hBb = 0;
        this.hBn = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.hAX != null && this.hAX.size() > 0;
    }

    public String[] ea(Context context) {
        String str = null;
        String str2 = "";
        if (isValid()) {
            int size = this.hAX.size() > 30 ? 30 : this.hAX.size();
            if (bPI() == null || bPI().adv() == null || com.baidu.tbadk.core.util.ap.isEmpty(bPI().adv().getUserId())) {
                return new String[]{null, ""};
            }
            String userId = bPI().adv().getUserId();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                PostData postData = (PostData) v.c(this.hAX, i);
                if (postData != null && postData.adv() != null && !com.baidu.tbadk.core.util.ap.isEmpty(postData.adv().getUserId()) && com.baidu.tbadk.core.util.ap.equals(userId, postData.adv().getUserId())) {
                    if (com.baidu.tbadk.core.util.ap.isEmpty(str)) {
                        str = postData.cmB();
                    }
                    String cmz = com.baidu.tbadk.core.util.ap.isEmpty(str2) ? postData.cmz() : str2;
                    if (!com.baidu.tbadk.core.util.ap.isEmpty(str) && !com.baidu.tbadk.core.util.ap.isEmpty(cmz)) {
                        str2 = cmz;
                        break;
                    }
                    str2 = cmz;
                }
                i++;
                str = str;
            }
            if (com.baidu.tbadk.core.util.ap.isEmpty(str)) {
                str = "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            }
            PostData postData2 = this.hAX.get(0);
            if (this.dkk != null && this.dkk.aen() != null && this.dkk.aen().getGroup_id() != 0) {
                str2 = "[" + context.getString(R.string.photo_live_tips) + "] " + str2;
            }
            if (this.dkk != null && this.dkk.aep() && postData2 != null && postData2.axJ() != null) {
                str = postData2.axJ().getThumbUrl();
            }
        }
        return new String[]{str, str2};
    }

    public ForumData getForum() {
        return this.forum;
    }

    public bc bPH() {
        return this.hAW;
    }

    public String getForumId() {
        if (this.forum == null) {
            return "";
        }
        return this.forum.getId();
    }

    public bg bPI() {
        return this.dkk;
    }

    public List<bg> bPJ() {
        return this.hBi;
    }

    public String getThreadId() {
        if (this.dkk == null) {
            return "";
        }
        return this.dkk.getId();
    }

    public ArrayList<PostData> bPK() {
        return this.hAX;
    }

    public an getPage() {
        return this.page;
    }

    public ad bPL() {
        return this.hBd;
    }

    public aq bPM() {
        return this.hBh;
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
        return this.dkk.adD() != 0;
    }

    public void ds(boolean z) {
        if (this.dkk != null) {
            if (z) {
                this.dkk.hg(1);
            } else {
                this.dkk.hg(0);
            }
        }
    }

    public String ZB() {
        if (this.dkk != null) {
            return this.dkk.adE();
        }
        return null;
    }

    public void AV(String str) {
        if (this.dkk != null) {
            this.dkk.ms(str);
        }
    }

    public String bPN() {
        return this.hBF;
    }

    public boolean bPO() {
        return (this.dkk == null || this.dkk.adG() == null || this.dkk.adG().size() <= 0 || this.dkk.adG().get(0) == null || !this.dkk.adG().get(0).abD()) ? false : true;
    }

    public PostData bPP() {
        return this.hBI;
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                com.baidu.tieba.recapp.d.a.cfz().Dc(dataRes.asp_shown_info);
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
                this.hAW.parserProtobuf(dataRes.display_forum);
                this.dkk.setUserMap(this.userMap);
                this.dkk.a(dataRes.thread);
                this.dkk.setCurrentPage(2);
                this.hBc.a(dataRes.news_info);
                switch (this.hBc.bGW) {
                    case 1:
                        this.hBd.hLB = this.hBc;
                        break;
                    case 2:
                        this.hBd.hLC = this.hBc;
                        break;
                    case 3:
                        this.hBd.hLD = this.hBc;
                        break;
                    default:
                        this.hBd.hLC = this.hBc;
                        break;
                }
                this.hBh.a(dataRes.recommend_book);
                List<Post> list2 = dataRes.post_list;
                if (list2 != null && list2.size() > 0) {
                    for (Post post : dataRes.post_list) {
                        if (!this.hBH.contains(String.valueOf(post.id))) {
                            PostData postData = new PostData();
                            postData.setUserMap(this.userMap);
                            postData.qJ(this.forum.isBrandForum);
                            postData.a(post, context);
                            postData.a(bPI().adh());
                            this.hBH.add(postData.getId());
                            if (postData.cmu() == 1 && this.dkk.aeg()) {
                                if (bPO()) {
                                    postData.setPostType(0);
                                } else {
                                    postData.setPostType(this.dkk.aef());
                                }
                            } else if (postData.cmu() == 1 && this.dkk.aev()) {
                                postData.setPostType(41);
                            } else if (postData.cmu() == 1 && this.dkk != null && this.dkk.aep()) {
                                postData.setPostType(0);
                                postData.axJ();
                                if (this.dkk.adt() == null || this.dkk.adt().size() == 0) {
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
                                    postData.c(new TbRichText((Context) TbadkCoreApplication.getInst(), this.dkk.adt(), true));
                                }
                                this.hBt = postData;
                            }
                            if (postData.cmu() == 1 && this.dkk != null && this.dkk.isShareThread) {
                                postData.g(this.dkk.bKP);
                            }
                            this.hAX.add(postData);
                        }
                    }
                }
                if (dataRes.first_floor_post != null) {
                    this.hBI = new PostData();
                    this.hBI.setUserMap(this.userMap);
                    this.hBI.qJ(this.forum.isBrandForum);
                    this.hBI.a(dataRes.first_floor_post, context);
                    if (this.dkk != null && this.dkk.isShareThread) {
                        this.hBI.g(this.dkk.bKP);
                    }
                }
                this.page.a(dataRes.page);
                this.anti.parserProtobuf(dataRes.anti);
                this.hAY.a(dataRes.location);
                if (dataRes.user != null) {
                    this.hAZ = dataRes.user.is_manager.intValue();
                }
                this.userData.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.hBe.add(muteUser);
                        }
                    }
                }
                this.dkk.hc(this.dkk.adm() > 0 ? this.dkk.adm() - 1 : 0);
                List<AppData> ceH = r.ceJ().ceH();
                if (ceH != null) {
                    ceH.clear();
                }
                this.hBm = null;
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        com.baidu.tieba.tbadkCore.data.m mVar = new com.baidu.tieba.tbadkCore.data.m();
                        mVar.d(app);
                        AppData cmi = mVar.cmi();
                        if (!this.hBl.contains(mVar) && cmi.goods != null && (!StringUtils.isNull(cmi.goods.user_name) || !StringUtils.isNull(cmi.goods.lego_card))) {
                            this.hBl.add(mVar);
                            if (ceH != null) {
                                ceH.add(mVar.cmi());
                            }
                        }
                    }
                    a(dataRes);
                }
                r.ceJ().ceI();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.userData.getIsSelectTail());
                }
                this.hBn.parserProtobuf(dataRes.twzhibo_anti);
                this.hBo = dataRes.appeal_info;
                if (dataRes.god_card != null) {
                    this.hBg = new a();
                    this.hBg.a(dataRes.god_card);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.hBu = new f();
                    this.hBu.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.guess_like != null) {
                    this.hBv = new CardHListViewData();
                    this.hBv.parseProtobuf(dataRes.guess_like);
                }
                if (dataRes.feed_thread_list != null && dataRes.feed_thread_list.size() > 0) {
                    List<ThreadInfo> list3 = dataRes.feed_thread_list;
                    if (this.hBi == null) {
                        this.hBi = new ArrayList();
                    }
                    this.hBi.clear();
                    for (ThreadInfo threadInfo : list3) {
                        if (threadInfo != null) {
                            bg bgVar = new bg();
                            bgVar.a(threadInfo);
                            this.hBi.add(bgVar);
                        }
                    }
                    if (this.hBi != null && this.hBi.size() > 15) {
                        this.hBi = v.c(this.hBi, 0, 15);
                    }
                }
                this.hBj = dataRes.is_follow_current_channel.intValue();
                if (v.Z(dataRes.repost_recommend_forum_list) > 0) {
                    if (this.hBp == null) {
                        this.hBp = new ArrayList();
                    }
                    for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                        bc bcVar = new bc();
                        bcVar.parserProtobuf(simpleForum);
                        this.hBp.add(bcVar);
                    }
                }
                if (v.Z(dataRes.from_forum_list) > 0) {
                    if (this.hBq == null) {
                        this.hBq = new ArrayList();
                    }
                    for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                        if (simpleForum2 != null) {
                            bc bcVar2 = new bc();
                            bcVar2.parserProtobuf(simpleForum2);
                            this.hBq.add(bcVar2);
                        }
                    }
                }
                this.hBF = dataRes.multi_forum_text;
                if (this.hBw >= 0) {
                    this.hBw = dataRes.thread_freq_num.longValue();
                }
                this.hBx = new j();
                this.hBx.cbg = this.dkk;
                this.hBx.b(dataRes);
                this.hBy = dataRes.partial_visible_toast;
                if (dataRes.follow_tip != null && dataRes.follow_tip.is_toast_tip.intValue() == 1) {
                    this.hBa = dataRes.follow_tip.tip_text;
                }
                this.hBk = new AlaLiveInfoCoreData();
                if (dataRes.ala_info != null) {
                    this.hBk.parserProtoBuf(dataRes.ala_info);
                }
                this.hBE = dataRes.fold_tip;
                this.hBz = dataRes.exp_news_today.intValue();
                this.hBA = dataRes.exp_guide_today.intValue();
                if (!v.aa(dataRes.thread_topic)) {
                    for (int i2 = 0; i2 < dataRes.thread_topic.size(); i2++) {
                        ay.a aVar = new ay.a();
                        aVar.a(dataRes.thread_topic.get(i2));
                        this.hBG.add(aVar);
                    }
                }
                this.hBB = dataRes.pb_sort_info;
                this.hBC = dataRes.sort_type.intValue();
                if (dataRes.manager_election != null) {
                    this.hBD = g.a(dataRes.manager_election);
                }
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }

    private void a(DataRes dataRes) {
        List<String> me;
        App app = dataRes.banner_list.pb_banner_ad;
        com.baidu.tieba.tbadkCore.data.m mVar = new com.baidu.tieba.tbadkCore.data.m();
        mVar.iYx = true;
        mVar.d(app);
        AppData cmi = mVar.cmi();
        if (cmi.goods != null) {
            if (v.aa(cmi.goods.thread_pic_list) && (me = AdvertAppInfo.a.me(cmi.goods.lego_card)) != null && cmi.goods.thread_pic_list != null) {
                cmi.goods.thread_pic_list.addAll(me);
            }
            this.hBm = mVar;
        }
    }

    public String bPQ() {
        return this.hBE;
    }

    public CardHListViewData bPR() {
        return this.hBv;
    }

    public PostData bPS() {
        return this.hBt;
    }

    public PostData d(PostData postData) {
        this.hBt = postData;
        return postData;
    }

    public m bPT() {
        return this.hBr;
    }

    public int bPU() {
        return this.hAZ;
    }

    public int getIsNewUrl() {
        return this.hBb;
    }

    public void setIsNewUrl(int i) {
        this.hBb = i;
    }

    public List<MuteUser> bPV() {
        return this.hBe;
    }

    public ArrayList<com.baidu.tieba.tbadkCore.data.m> bPW() {
        return this.hBl;
    }

    public com.baidu.tieba.tbadkCore.data.m bPX() {
        return this.hBm;
    }

    public void b(com.baidu.tieba.tbadkCore.data.m mVar) {
        this.hBm = mVar;
    }

    public void bPY() {
        if (this.hBm.cmi() != null) {
            this.hBm.cmi().legoCard = null;
        }
        this.hBm = null;
    }

    public a bPZ() {
        return this.hBg;
    }

    public String bQa() {
        return this.hBs;
    }

    public void AW(String str) {
        this.hBs = str;
    }

    public f bQb() {
        return this.hBu;
    }

    public int bQc() {
        return this.hBj;
    }

    public List<bc> bQd() {
        return this.hBq;
    }

    public long bQe() {
        return this.hBw;
    }

    public j bQf() {
        return this.hBx;
    }

    public boolean bQg() {
        return (bPI() == null || !bPI().aep() || bPI().adM() == null) ? false : true;
    }

    public AlaLiveInfoCoreData bQh() {
        return this.hBk;
    }
}

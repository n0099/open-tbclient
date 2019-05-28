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
    private j hBA;
    public String hBB;
    public int hBC;
    public int hBD;
    public List<PbSortType> hBE;
    public int hBF;
    public g hBG;
    private String hBH;
    private String hBI;
    private PostData hBL;
    private String hBd;
    private int hBe;
    private a hBj;
    private List<bg> hBl;
    private int hBm;
    private AlaLiveInfoCoreData hBn;
    private TwzhiboAnti hBq;
    public AppealInfo hBr;
    private List<bc> hBs;
    private List<bc> hBt;
    public String hBv;
    private PostData hBw;
    private f hBx;
    public CardHListViewData hBy;
    private long hBz;
    private boolean hBi = true;
    private ArrayList<com.baidu.tieba.tbadkCore.data.m> hBo = new ArrayList<>();
    private com.baidu.tieba.tbadkCore.data.m hBp = null;
    private ForumData forum = new ForumData();
    private bc hAZ = new bc();
    private bg dkl = new bg();
    private ArrayList<PostData> hBa = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private an page = new an();
    private AntiData anti = new AntiData();
    private com.baidu.tbadk.data.f hBb = new com.baidu.tbadk.data.f();
    private int hBc = 0;
    private final UserData userData = new UserData();
    private List<MuteUser> hBh = new ArrayList();
    private ap hBf = new ap();
    private aq hBk = new aq();
    private ad hBg = new ad();
    private m hBu = new m();
    private List<ay.a> hBJ = new ArrayList();
    private HashSet<String> hBK = new HashSet<>();

    public boolean bPJ() {
        return this.hBi;
    }

    public void nO(boolean z) {
        this.hBi = z;
    }

    public d() {
        this.hBe = 0;
        this.hBq = null;
        this.hBe = 0;
        this.hBq = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.hBa != null && this.hBa.size() > 0;
    }

    public String[] ea(Context context) {
        String str = null;
        String str2 = "";
        if (isValid()) {
            int size = this.hBa.size() > 30 ? 30 : this.hBa.size();
            if (bPL() == null || bPL().adv() == null || com.baidu.tbadk.core.util.ap.isEmpty(bPL().adv().getUserId())) {
                return new String[]{null, ""};
            }
            String userId = bPL().adv().getUserId();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                PostData postData = (PostData) v.c(this.hBa, i);
                if (postData != null && postData.adv() != null && !com.baidu.tbadk.core.util.ap.isEmpty(postData.adv().getUserId()) && com.baidu.tbadk.core.util.ap.equals(userId, postData.adv().getUserId())) {
                    if (com.baidu.tbadk.core.util.ap.isEmpty(str)) {
                        str = postData.cmD();
                    }
                    String cmB = com.baidu.tbadk.core.util.ap.isEmpty(str2) ? postData.cmB() : str2;
                    if (!com.baidu.tbadk.core.util.ap.isEmpty(str) && !com.baidu.tbadk.core.util.ap.isEmpty(cmB)) {
                        str2 = cmB;
                        break;
                    }
                    str2 = cmB;
                }
                i++;
                str = str;
            }
            if (com.baidu.tbadk.core.util.ap.isEmpty(str)) {
                str = "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            }
            PostData postData2 = this.hBa.get(0);
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

    public bc bPK() {
        return this.hAZ;
    }

    public String getForumId() {
        if (this.forum == null) {
            return "";
        }
        return this.forum.getId();
    }

    public bg bPL() {
        return this.dkl;
    }

    public List<bg> bPM() {
        return this.hBl;
    }

    public String getThreadId() {
        if (this.dkl == null) {
            return "";
        }
        return this.dkl.getId();
    }

    public ArrayList<PostData> bPN() {
        return this.hBa;
    }

    public an getPage() {
        return this.page;
    }

    public ad bPO() {
        return this.hBg;
    }

    public aq bPP() {
        return this.hBk;
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

    public void AV(String str) {
        if (this.dkl != null) {
            this.dkl.ms(str);
        }
    }

    public String bPQ() {
        return this.hBI;
    }

    public boolean bPR() {
        return (this.dkl == null || this.dkl.adG() == null || this.dkl.adG().size() <= 0 || this.dkl.adG().get(0) == null || !this.dkl.adG().get(0).abD()) ? false : true;
    }

    public PostData bPS() {
        return this.hBL;
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                com.baidu.tieba.recapp.d.a.cfB().Dc(dataRes.asp_shown_info);
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
                this.hAZ.parserProtobuf(dataRes.display_forum);
                this.dkl.setUserMap(this.userMap);
                this.dkl.a(dataRes.thread);
                this.dkl.setCurrentPage(2);
                this.hBf.a(dataRes.news_info);
                switch (this.hBf.bGW) {
                    case 1:
                        this.hBg.hLE = this.hBf;
                        break;
                    case 2:
                        this.hBg.hLF = this.hBf;
                        break;
                    case 3:
                        this.hBg.hLG = this.hBf;
                        break;
                    default:
                        this.hBg.hLF = this.hBf;
                        break;
                }
                this.hBk.a(dataRes.recommend_book);
                List<Post> list2 = dataRes.post_list;
                if (list2 != null && list2.size() > 0) {
                    for (Post post : dataRes.post_list) {
                        if (!this.hBK.contains(String.valueOf(post.id))) {
                            PostData postData = new PostData();
                            postData.setUserMap(this.userMap);
                            postData.qJ(this.forum.isBrandForum);
                            postData.a(post, context);
                            postData.a(bPL().adh());
                            this.hBK.add(postData.getId());
                            if (postData.cmw() == 1 && this.dkl.aeg()) {
                                if (bPR()) {
                                    postData.setPostType(0);
                                } else {
                                    postData.setPostType(this.dkl.aef());
                                }
                            } else if (postData.cmw() == 1 && this.dkl.aev()) {
                                postData.setPostType(41);
                            } else if (postData.cmw() == 1 && this.dkl != null && this.dkl.aep()) {
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
                                this.hBw = postData;
                            }
                            if (postData.cmw() == 1 && this.dkl != null && this.dkl.isShareThread) {
                                postData.g(this.dkl.bKP);
                            }
                            this.hBa.add(postData);
                        }
                    }
                }
                if (dataRes.first_floor_post != null) {
                    this.hBL = new PostData();
                    this.hBL.setUserMap(this.userMap);
                    this.hBL.qJ(this.forum.isBrandForum);
                    this.hBL.a(dataRes.first_floor_post, context);
                    if (this.dkl != null && this.dkl.isShareThread) {
                        this.hBL.g(this.dkl.bKP);
                    }
                }
                this.page.a(dataRes.page);
                this.anti.parserProtobuf(dataRes.anti);
                this.hBb.a(dataRes.location);
                if (dataRes.user != null) {
                    this.hBc = dataRes.user.is_manager.intValue();
                }
                this.userData.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.hBh.add(muteUser);
                        }
                    }
                }
                this.dkl.hc(this.dkl.adm() > 0 ? this.dkl.adm() - 1 : 0);
                List<AppData> ceJ = r.ceL().ceJ();
                if (ceJ != null) {
                    ceJ.clear();
                }
                this.hBp = null;
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        com.baidu.tieba.tbadkCore.data.m mVar = new com.baidu.tieba.tbadkCore.data.m();
                        mVar.d(app);
                        AppData cmk = mVar.cmk();
                        if (!this.hBo.contains(mVar) && cmk.goods != null && (!StringUtils.isNull(cmk.goods.user_name) || !StringUtils.isNull(cmk.goods.lego_card))) {
                            this.hBo.add(mVar);
                            if (ceJ != null) {
                                ceJ.add(mVar.cmk());
                            }
                        }
                    }
                    a(dataRes);
                }
                r.ceL().ceK();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.userData.getIsSelectTail());
                }
                this.hBq.parserProtobuf(dataRes.twzhibo_anti);
                this.hBr = dataRes.appeal_info;
                if (dataRes.god_card != null) {
                    this.hBj = new a();
                    this.hBj.a(dataRes.god_card);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.hBx = new f();
                    this.hBx.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.guess_like != null) {
                    this.hBy = new CardHListViewData();
                    this.hBy.parseProtobuf(dataRes.guess_like);
                }
                if (dataRes.feed_thread_list != null && dataRes.feed_thread_list.size() > 0) {
                    List<ThreadInfo> list3 = dataRes.feed_thread_list;
                    if (this.hBl == null) {
                        this.hBl = new ArrayList();
                    }
                    this.hBl.clear();
                    for (ThreadInfo threadInfo : list3) {
                        if (threadInfo != null) {
                            bg bgVar = new bg();
                            bgVar.a(threadInfo);
                            this.hBl.add(bgVar);
                        }
                    }
                    if (this.hBl != null && this.hBl.size() > 15) {
                        this.hBl = v.c(this.hBl, 0, 15);
                    }
                }
                this.hBm = dataRes.is_follow_current_channel.intValue();
                if (v.Z(dataRes.repost_recommend_forum_list) > 0) {
                    if (this.hBs == null) {
                        this.hBs = new ArrayList();
                    }
                    for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                        bc bcVar = new bc();
                        bcVar.parserProtobuf(simpleForum);
                        this.hBs.add(bcVar);
                    }
                }
                if (v.Z(dataRes.from_forum_list) > 0) {
                    if (this.hBt == null) {
                        this.hBt = new ArrayList();
                    }
                    for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                        if (simpleForum2 != null) {
                            bc bcVar2 = new bc();
                            bcVar2.parserProtobuf(simpleForum2);
                            this.hBt.add(bcVar2);
                        }
                    }
                }
                this.hBI = dataRes.multi_forum_text;
                if (this.hBz >= 0) {
                    this.hBz = dataRes.thread_freq_num.longValue();
                }
                this.hBA = new j();
                this.hBA.cbg = this.dkl;
                this.hBA.b(dataRes);
                this.hBB = dataRes.partial_visible_toast;
                if (dataRes.follow_tip != null && dataRes.follow_tip.is_toast_tip.intValue() == 1) {
                    this.hBd = dataRes.follow_tip.tip_text;
                }
                this.hBn = new AlaLiveInfoCoreData();
                if (dataRes.ala_info != null) {
                    this.hBn.parserProtoBuf(dataRes.ala_info);
                }
                this.hBH = dataRes.fold_tip;
                this.hBC = dataRes.exp_news_today.intValue();
                this.hBD = dataRes.exp_guide_today.intValue();
                if (!v.aa(dataRes.thread_topic)) {
                    for (int i2 = 0; i2 < dataRes.thread_topic.size(); i2++) {
                        ay.a aVar = new ay.a();
                        aVar.a(dataRes.thread_topic.get(i2));
                        this.hBJ.add(aVar);
                    }
                }
                this.hBE = dataRes.pb_sort_info;
                this.hBF = dataRes.sort_type.intValue();
                if (dataRes.manager_election != null) {
                    this.hBG = g.a(dataRes.manager_election);
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
        mVar.iYz = true;
        mVar.d(app);
        AppData cmk = mVar.cmk();
        if (cmk.goods != null) {
            if (v.aa(cmk.goods.thread_pic_list) && (me = AdvertAppInfo.a.me(cmk.goods.lego_card)) != null && cmk.goods.thread_pic_list != null) {
                cmk.goods.thread_pic_list.addAll(me);
            }
            this.hBp = mVar;
        }
    }

    public String bPT() {
        return this.hBH;
    }

    public CardHListViewData bPU() {
        return this.hBy;
    }

    public PostData bPV() {
        return this.hBw;
    }

    public PostData d(PostData postData) {
        this.hBw = postData;
        return postData;
    }

    public m bPW() {
        return this.hBu;
    }

    public int bPX() {
        return this.hBc;
    }

    public int getIsNewUrl() {
        return this.hBe;
    }

    public void setIsNewUrl(int i) {
        this.hBe = i;
    }

    public List<MuteUser> bPY() {
        return this.hBh;
    }

    public ArrayList<com.baidu.tieba.tbadkCore.data.m> bPZ() {
        return this.hBo;
    }

    public com.baidu.tieba.tbadkCore.data.m bQa() {
        return this.hBp;
    }

    public void b(com.baidu.tieba.tbadkCore.data.m mVar) {
        this.hBp = mVar;
    }

    public void bQb() {
        if (this.hBp.cmk() != null) {
            this.hBp.cmk().legoCard = null;
        }
        this.hBp = null;
    }

    public a bQc() {
        return this.hBj;
    }

    public String bQd() {
        return this.hBv;
    }

    public void AW(String str) {
        this.hBv = str;
    }

    public f bQe() {
        return this.hBx;
    }

    public int bQf() {
        return this.hBm;
    }

    public List<bc> bQg() {
        return this.hBt;
    }

    public long bQh() {
        return this.hBz;
    }

    public j bQi() {
        return this.hBA;
    }

    public boolean bQj() {
        return (bPL() == null || !bPL().aep() || bPL().adM() == null) ? false : true;
    }

    public AlaLiveInfoCoreData bQk() {
        return this.hBn;
    }
}

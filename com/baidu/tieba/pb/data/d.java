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
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.bh;
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
    private String hHU;
    private int hHV;
    private PostData hIE;
    private a hIa;
    private List<bh> hIc;
    private int hId;
    private AlaLiveInfoCoreData hIe;
    private TwzhiboAnti hIh;
    public AppealInfo hIi;
    private List<bd> hIj;
    private List<bd> hIk;
    public String hIm;
    private PostData hIn;
    private f hIo;
    public CardHListViewData hIp;
    private long hIq;
    private j hIr;
    public String hIs;
    public int hIt;
    public int hIu;
    public List<PbSortType> hIv;
    public int hIw;
    public g hIx;
    private String hIy;
    private String hIz;
    private boolean hHZ = true;
    private ArrayList<com.baidu.tieba.tbadkCore.data.m> hIf = new ArrayList<>();
    private com.baidu.tieba.tbadkCore.data.m hIg = null;
    public boolean hIC = false;
    public boolean hID = false;
    private ForumData forum = new ForumData();
    private bd hHQ = new bd();
    private bh dur = new bh();
    private ArrayList<PostData> hHR = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private an page = new an();
    private AntiData anti = new AntiData();
    private com.baidu.tbadk.data.f hHS = new com.baidu.tbadk.data.f();
    private int hHT = 0;
    private final UserData userData = new UserData();
    private List<MuteUser> hHY = new ArrayList();
    private ap hHW = new ap();
    private aq hIb = new aq();
    private ad hHX = new ad();
    private m hIl = new m();
    private List<az.a> hIA = new ArrayList();
    private HashSet<String> hIB = new HashSet<>();

    public boolean bQv() {
        return this.hHZ;
    }

    public void nR(boolean z) {
        this.hHZ = z;
    }

    public d() {
        this.hHV = 0;
        this.hIh = null;
        this.hHV = 0;
        this.hIh = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.hHR != null && this.hHR.size() > 0;
    }

    public String[] dP(Context context) {
        String str = null;
        String str2 = "";
        if (isValid()) {
            int size = this.hHR.size() > 30 ? 30 : this.hHR.size();
            if (bQx() == null || bQx().aiE() == null || com.baidu.tbadk.core.util.aq.isEmpty(bQx().aiE().getUserId())) {
                return new String[]{null, ""};
            }
            String userId = bQx().aiE().getUserId();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                PostData postData = (PostData) v.getItem(this.hHR, i);
                if (postData != null && postData.aiE() != null && !com.baidu.tbadk.core.util.aq.isEmpty(postData.aiE().getUserId()) && com.baidu.tbadk.core.util.aq.equals(userId, postData.aiE().getUserId())) {
                    if (com.baidu.tbadk.core.util.aq.isEmpty(str)) {
                        str = postData.cou();
                    }
                    String cos = com.baidu.tbadk.core.util.aq.isEmpty(str2) ? postData.cos() : str2;
                    if (!com.baidu.tbadk.core.util.aq.isEmpty(str) && !com.baidu.tbadk.core.util.aq.isEmpty(cos)) {
                        str2 = cos;
                        break;
                    }
                    str2 = cos;
                }
                i++;
                str = str;
            }
            if (com.baidu.tbadk.core.util.aq.isEmpty(str)) {
                str = "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            }
            PostData postData2 = this.hHR.get(0);
            if (this.dur != null && this.dur.ajw() != null && this.dur.ajw().getGroup_id() != 0) {
                str2 = "[" + context.getString(R.string.photo_live_tips) + "] " + str2;
            }
            if (this.dur != null && this.dur.ajy() && postData2 != null && postData2.azr() != null) {
                str = postData2.azr().getThumbUrl();
            }
        }
        return new String[]{str, str2};
    }

    public ForumData getForum() {
        return this.forum;
    }

    public bd bQw() {
        return this.hHQ;
    }

    public String getForumId() {
        if (this.forum == null) {
            return "";
        }
        return this.forum.getId();
    }

    public bh bQx() {
        return this.dur;
    }

    public List<bh> bQy() {
        return this.hIc;
    }

    public String getThreadId() {
        if (this.dur == null) {
            return "";
        }
        return this.dur.getId();
    }

    public ArrayList<PostData> bQz() {
        return this.hHR;
    }

    public an getPage() {
        return this.page;
    }

    public ad bQA() {
        return this.hHX;
    }

    public aq bQB() {
        return this.hIb;
    }

    public void a(an anVar, int i) {
        this.page.hz(anVar.ahw());
        this.page.hx(anVar.agN());
        this.page.hw(anVar.aht());
        this.page.hA(anVar.ahx());
        this.page.hy(anVar.ahv());
        if (i == 0) {
            this.page = anVar;
        } else if (i == 1) {
            this.page.hB(anVar.ahy());
        } else if (i == 2) {
            this.page.hC(anVar.ahz());
        }
    }

    public AntiData getAnti() {
        return this.anti;
    }

    public UserData getUserData() {
        return this.userData;
    }

    public boolean afk() {
        return this.dur.aiM() != 0;
    }

    public void dO(boolean z) {
        if (this.dur != null) {
            if (z) {
                this.dur.hL(1);
            } else {
                this.dur.hL(0);
            }
        }
    }

    public String afj() {
        if (this.dur != null) {
            return this.dur.aiN();
        }
        return null;
    }

    public void AC(String str) {
        if (this.dur != null) {
            this.dur.nc(str);
        }
    }

    public String bQC() {
        return this.hIz;
    }

    public boolean bQD() {
        return (this.dur == null || this.dur.aiP() == null || this.dur.aiP().size() <= 0 || this.dur.aiP().get(0) == null || !this.dur.aiP().get(0).agO()) ? false : true;
    }

    public PostData bQE() {
        return this.hIE;
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                com.baidu.tieba.recapp.d.a.cgB().CN(dataRes.asp_shown_info);
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
                this.hHQ.parserProtobuf(dataRes.display_forum);
                this.dur.setUserMap(this.userMap);
                this.dur.a(dataRes.thread);
                this.dur.setCurrentPage(2);
                this.hHW.a(dataRes.news_info);
                switch (this.hHW.bZm) {
                    case 1:
                        this.hHX.hSB = this.hHW;
                        break;
                    case 2:
                        this.hHX.hSC = this.hHW;
                        break;
                    case 3:
                        this.hHX.hSD = this.hHW;
                        break;
                    default:
                        this.hHX.hSC = this.hHW;
                        break;
                }
                this.hIb.a(dataRes.recommend_book);
                List<Post> list2 = dataRes.post_list;
                if (list2 != null && list2.size() > 0) {
                    for (Post post : dataRes.post_list) {
                        if (!this.hIB.contains(String.valueOf(post.id))) {
                            PostData postData = new PostData();
                            postData.setUserMap(this.userMap);
                            postData.qM(this.forum.isBrandForum);
                            postData.a(post, context);
                            postData.a(bQx().aiq());
                            this.hIB.add(postData.getId());
                            if (postData.con() == 1 && this.dur.ajp()) {
                                if (bQD()) {
                                    postData.setPostType(0);
                                } else {
                                    postData.setPostType(this.dur.ajo());
                                }
                            } else if (postData.con() == 1 && this.dur.ajE()) {
                                postData.setPostType(41);
                            } else if (postData.con() == 1 && this.dur != null && this.dur.ajy()) {
                                postData.setPostType(0);
                                postData.azr();
                                if (this.dur.aiC() == null || this.dur.aiC().size() == 0) {
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
                                    postData.c(new TbRichText((Context) TbadkCoreApplication.getInst(), this.dur.aiC(), true));
                                }
                                this.hIn = postData;
                            }
                            if (postData.con() == 1 && this.dur != null && this.dur.isShareThread) {
                                postData.g(this.dur.cdl);
                            }
                            this.hHR.add(postData);
                        }
                    }
                }
                if (dataRes.first_floor_post != null) {
                    this.hIE = new PostData();
                    this.hIE.setUserMap(this.userMap);
                    this.hIE.qM(this.forum.isBrandForum);
                    this.hIE.a(dataRes.first_floor_post, context);
                    if (this.dur != null && this.dur.isShareThread) {
                        this.hIE.g(this.dur.cdl);
                    }
                }
                this.page.a(dataRes.page);
                this.anti.parserProtobuf(dataRes.anti);
                this.hHS.a(dataRes.location);
                if (dataRes.user != null) {
                    this.hHT = dataRes.user.is_manager.intValue();
                }
                this.userData.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.hHY.add(muteUser);
                        }
                    }
                }
                this.dur.hH(this.dur.aiv() > 0 ? this.dur.aiv() - 1 : 0);
                List<AppData> cfH = r.cfJ().cfH();
                if (cfH != null) {
                    cfH.clear();
                }
                this.hIg = null;
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        com.baidu.tieba.tbadkCore.data.m mVar = new com.baidu.tieba.tbadkCore.data.m();
                        mVar.d(app);
                        AppData cob = mVar.cob();
                        if (!this.hIf.contains(mVar) && cob.goods != null && (!StringUtils.isNull(cob.goods.user_name) || !StringUtils.isNull(cob.goods.lego_card))) {
                            this.hIf.add(mVar);
                            if (cfH != null) {
                                cfH.add(mVar.cob());
                            }
                        }
                    }
                    a(dataRes);
                }
                r.cfJ().cfI();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.userData.getIsSelectTail());
                }
                this.hIh.parserProtobuf(dataRes.twzhibo_anti);
                this.hIi = dataRes.appeal_info;
                if (dataRes.god_card != null) {
                    this.hIa = new a();
                    this.hIa.a(dataRes.god_card);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.hIo = new f();
                    this.hIo.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.guess_like != null) {
                    this.hIp = new CardHListViewData();
                    this.hIp.parseProtobuf(dataRes.guess_like);
                }
                if (dataRes.feed_thread_list != null && dataRes.feed_thread_list.size() > 0) {
                    List<ThreadInfo> list3 = dataRes.feed_thread_list;
                    if (this.hIc == null) {
                        this.hIc = new ArrayList();
                    }
                    this.hIc.clear();
                    for (ThreadInfo threadInfo : list3) {
                        if (threadInfo != null) {
                            bh bhVar = new bh();
                            bhVar.a(threadInfo);
                            this.hIc.add(bhVar);
                        }
                    }
                    if (this.hIc != null && this.hIc.size() > 15) {
                        this.hIc = v.subList(this.hIc, 0, 15);
                    }
                }
                this.hId = dataRes.is_follow_current_channel.intValue();
                if (v.getCount(dataRes.repost_recommend_forum_list) > 0) {
                    if (this.hIj == null) {
                        this.hIj = new ArrayList();
                    }
                    for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                        bd bdVar = new bd();
                        bdVar.parserProtobuf(simpleForum);
                        this.hIj.add(bdVar);
                    }
                }
                if (v.getCount(dataRes.from_forum_list) > 0) {
                    if (this.hIk == null) {
                        this.hIk = new ArrayList();
                    }
                    for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                        if (simpleForum2 != null) {
                            bd bdVar2 = new bd();
                            bdVar2.parserProtobuf(simpleForum2);
                            this.hIk.add(bdVar2);
                        }
                    }
                }
                this.hIz = dataRes.multi_forum_text;
                if (this.hIq >= 0) {
                    this.hIq = dataRes.thread_freq_num.longValue();
                }
                this.hIr = new j();
                this.hIr.cqG = this.dur;
                this.hIr.b(dataRes);
                this.hIs = dataRes.partial_visible_toast;
                if (dataRes.follow_tip != null && dataRes.follow_tip.is_toast_tip.intValue() == 1) {
                    this.hHU = dataRes.follow_tip.tip_text;
                }
                this.hIe = new AlaLiveInfoCoreData();
                if (dataRes.ala_info != null) {
                    this.hIe.parserProtoBuf(dataRes.ala_info);
                }
                this.hIy = dataRes.fold_tip;
                this.hIt = dataRes.exp_news_today.intValue();
                this.hIu = dataRes.exp_guide_today.intValue();
                if (!v.isEmpty(dataRes.thread_topic)) {
                    for (int i2 = 0; i2 < dataRes.thread_topic.size(); i2++) {
                        az.a aVar = new az.a();
                        aVar.a(dataRes.thread_topic.get(i2));
                        this.hIA.add(aVar);
                    }
                }
                this.hIv = dataRes.pb_sort_info;
                this.hIw = dataRes.sort_type.intValue();
                if (dataRes.manager_election != null) {
                    this.hIx = g.a(dataRes.manager_election);
                }
                if (dataRes.business_promot_info != null) {
                    this.hIC = dataRes.business_promot_info.is_promot.longValue() == 1;
                    this.hID = dataRes.business_promot_info.is_headlinepost.intValue() == 1;
                }
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }

    private void a(DataRes dataRes) {
        List<String> mN;
        App app = dataRes.banner_list.pb_banner_ad;
        com.baidu.tieba.tbadkCore.data.m mVar = new com.baidu.tieba.tbadkCore.data.m();
        mVar.jht = true;
        mVar.d(app);
        AppData cob = mVar.cob();
        if (cob.goods != null) {
            if (v.isEmpty(cob.goods.thread_pic_list) && (mN = AdvertAppInfo.a.mN(cob.goods.lego_card)) != null && cob.goods.thread_pic_list != null) {
                cob.goods.thread_pic_list.addAll(mN);
            }
            this.hIg = mVar;
        }
    }

    public String bQF() {
        return this.hIy;
    }

    public CardHListViewData bQG() {
        return this.hIp;
    }

    public PostData bQH() {
        return this.hIn;
    }

    public PostData d(PostData postData) {
        this.hIn = postData;
        return postData;
    }

    public m bQI() {
        return this.hIl;
    }

    public int bQJ() {
        return this.hHT;
    }

    public int getIsNewUrl() {
        return this.hHV;
    }

    public void setIsNewUrl(int i) {
        this.hHV = i;
    }

    public List<MuteUser> bQK() {
        return this.hHY;
    }

    public ArrayList<com.baidu.tieba.tbadkCore.data.m> bQL() {
        return this.hIf;
    }

    public com.baidu.tieba.tbadkCore.data.m bQM() {
        return this.hIg;
    }

    public void b(com.baidu.tieba.tbadkCore.data.m mVar) {
        this.hIg = mVar;
    }

    public void bQN() {
        if (this.hIg.cob() != null) {
            this.hIg.cob().legoCard = null;
        }
        this.hIg = null;
    }

    public a bQO() {
        return this.hIa;
    }

    public String bQP() {
        return this.hIm;
    }

    public void AD(String str) {
        this.hIm = str;
    }

    public f bQQ() {
        return this.hIo;
    }

    public int bQR() {
        return this.hId;
    }

    public List<bd> bQS() {
        return this.hIk;
    }

    public long bQT() {
        return this.hIq;
    }

    public j bQU() {
        return this.hIr;
    }

    public boolean bQV() {
        return (bQx() == null || !bQx().ajy() || bQx().aiV() == null) ? false : true;
    }

    public AlaLiveInfoCoreData bQW() {
        return this.hIe;
    }
}

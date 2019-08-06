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
    private List<bd> hIA;
    public String hIC;
    private PostData hID;
    private f hIE;
    public CardHListViewData hIF;
    private long hIG;
    private j hIH;
    public String hII;
    public int hIJ;
    public int hIK;
    public List<PbSortType> hIL;
    public int hIM;
    public g hIN;
    private String hIO;
    private String hIP;
    private PostData hIT;
    private String hIk;
    private int hIl;
    private a hIq;
    private List<bh> hIs;
    private int hIt;
    private AlaLiveInfoCoreData hIu;
    private TwzhiboAnti hIx;
    public AppealInfo hIy;
    private List<bd> hIz;
    private boolean hIp = true;
    private ArrayList<com.baidu.tieba.tbadkCore.data.m> hIv = new ArrayList<>();
    private com.baidu.tieba.tbadkCore.data.m hIw = null;
    public boolean hIS = false;
    private ForumData forum = new ForumData();
    private bd hIg = new bd();
    private bh dma = new bh();
    private ArrayList<PostData> hIh = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private an page = new an();
    private AntiData anti = new AntiData();
    private com.baidu.tbadk.data.f hIi = new com.baidu.tbadk.data.f();
    private int hIj = 0;
    private final UserData userData = new UserData();
    private List<MuteUser> hIo = new ArrayList();
    private ap hIm = new ap();
    private aq hIr = new aq();
    private ad hIn = new ad();
    private m hIB = new m();
    private List<az.a> hIQ = new ArrayList();
    private HashSet<String> hIR = new HashSet<>();

    public boolean bSJ() {
        return this.hIp;
    }

    public void od(boolean z) {
        this.hIp = z;
    }

    public d() {
        this.hIl = 0;
        this.hIx = null;
        this.hIl = 0;
        this.hIx = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.hIh != null && this.hIh.size() > 0;
    }

    public String[] ec(Context context) {
        String str = null;
        String str2 = "";
        if (isValid()) {
            int size = this.hIh.size() > 30 ? 30 : this.hIh.size();
            if (bSL() == null || bSL().aey() == null || com.baidu.tbadk.core.util.aq.isEmpty(bSL().aey().getUserId())) {
                return new String[]{null, ""};
            }
            String userId = bSL().aey().getUserId();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                PostData postData = (PostData) v.c(this.hIh, i);
                if (postData != null && postData.aey() != null && !com.baidu.tbadk.core.util.aq.isEmpty(postData.aey().getUserId()) && com.baidu.tbadk.core.util.aq.bV(userId, postData.aey().getUserId())) {
                    if (com.baidu.tbadk.core.util.aq.isEmpty(str)) {
                        str = postData.cpS();
                    }
                    String cpQ = com.baidu.tbadk.core.util.aq.isEmpty(str2) ? postData.cpQ() : str2;
                    if (!com.baidu.tbadk.core.util.aq.isEmpty(str) && !com.baidu.tbadk.core.util.aq.isEmpty(cpQ)) {
                        str2 = cpQ;
                        break;
                    }
                    str2 = cpQ;
                }
                i++;
                str = str;
            }
            if (com.baidu.tbadk.core.util.aq.isEmpty(str)) {
                str = "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            }
            PostData postData2 = this.hIh.get(0);
            if (this.dma != null && this.dma.afq() != null && this.dma.afq().getGroup_id() != 0) {
                str2 = "[" + context.getString(R.string.photo_live_tips) + "] " + str2;
            }
            if (this.dma != null && this.dma.afs() && postData2 != null && postData2.ayY() != null) {
                str = postData2.ayY().getThumbUrl();
            }
        }
        return new String[]{str, str2};
    }

    public ForumData getForum() {
        return this.forum;
    }

    public bd bSK() {
        return this.hIg;
    }

    public String getForumId() {
        if (this.forum == null) {
            return "";
        }
        return this.forum.getId();
    }

    public bh bSL() {
        return this.dma;
    }

    public List<bh> bSM() {
        return this.hIs;
    }

    public String getThreadId() {
        if (this.dma == null) {
            return "";
        }
        return this.dma.getId();
    }

    public ArrayList<PostData> bSN() {
        return this.hIh;
    }

    public an getPage() {
        return this.page;
    }

    public ad bSO() {
        return this.hIn;
    }

    public aq bSP() {
        return this.hIr;
    }

    public void a(an anVar, int i) {
        this.page.ha(anVar.adq());
        this.page.gY(anVar.acF());
        this.page.gX(anVar.adn());
        this.page.hb(anVar.adr());
        this.page.gZ(anVar.adp());
        if (i == 0) {
            this.page = anVar;
        } else if (i == 1) {
            this.page.hc(anVar.ads());
        } else if (i == 2) {
            this.page.hd(anVar.adt());
        }
    }

    public AntiData getAnti() {
        return this.anti;
    }

    public UserData getUserData() {
        return this.userData;
    }

    public boolean aaB() {
        return this.dma.aeG() != 0;
    }

    public void dx(boolean z) {
        if (this.dma != null) {
            if (z) {
                this.dma.hm(1);
            } else {
                this.dma.hm(0);
            }
        }
    }

    public String aaA() {
        if (this.dma != null) {
            return this.dma.aeH();
        }
        return null;
    }

    public void BK(String str) {
        if (this.dma != null) {
            this.dma.mC(str);
        }
    }

    public String bSQ() {
        return this.hIP;
    }

    public boolean bSR() {
        return (this.dma == null || this.dma.aeJ() == null || this.dma.aeJ().size() <= 0 || this.dma.aeJ().get(0) == null || !this.dma.aeJ().get(0).acG()) ? false : true;
    }

    public PostData bSS() {
        return this.hIT;
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                com.baidu.tieba.recapp.d.a.ciL().DS(dataRes.asp_shown_info);
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
                this.hIg.parserProtobuf(dataRes.display_forum);
                this.dma.setUserMap(this.userMap);
                this.dma.a(dataRes.thread);
                this.dma.setCurrentPage(2);
                this.hIm.a(dataRes.news_info);
                switch (this.hIm.bHY) {
                    case 1:
                        this.hIn.hSN = this.hIm;
                        break;
                    case 2:
                        this.hIn.hSO = this.hIm;
                        break;
                    case 3:
                        this.hIn.hSP = this.hIm;
                        break;
                    default:
                        this.hIn.hSO = this.hIm;
                        break;
                }
                this.hIr.a(dataRes.recommend_book);
                List<Post> list2 = dataRes.post_list;
                if (list2 != null && list2.size() > 0) {
                    for (Post post : dataRes.post_list) {
                        if (!this.hIR.contains(String.valueOf(post.id))) {
                            PostData postData = new PostData();
                            postData.setUserMap(this.userMap);
                            postData.ra(this.forum.isBrandForum);
                            postData.a(post, context);
                            postData.a(bSL().aek());
                            this.hIR.add(postData.getId());
                            if (postData.cpL() == 1 && this.dma.afj()) {
                                if (bSR()) {
                                    postData.setPostType(0);
                                } else {
                                    postData.setPostType(this.dma.afi());
                                }
                            } else if (postData.cpL() == 1 && this.dma.afy()) {
                                postData.setPostType(41);
                            } else if (postData.cpL() == 1 && this.dma != null && this.dma.afs()) {
                                postData.setPostType(0);
                                postData.ayY();
                                if (this.dma.aew() == null || this.dma.aew().size() == 0) {
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
                                    postData.c(new TbRichText((Context) TbadkCoreApplication.getInst(), this.dma.aew(), true));
                                }
                                this.hID = postData;
                            }
                            if (postData.cpL() == 1 && this.dma != null && this.dma.isShareThread) {
                                postData.g(this.dma.bLV);
                            }
                            this.hIh.add(postData);
                        }
                    }
                }
                if (dataRes.first_floor_post != null) {
                    this.hIT = new PostData();
                    this.hIT.setUserMap(this.userMap);
                    this.hIT.ra(this.forum.isBrandForum);
                    this.hIT.a(dataRes.first_floor_post, context);
                    if (this.dma != null && this.dma.isShareThread) {
                        this.hIT.g(this.dma.bLV);
                    }
                }
                this.page.a(dataRes.page);
                this.anti.parserProtobuf(dataRes.anti);
                this.hIi.a(dataRes.location);
                if (dataRes.user != null) {
                    this.hIj = dataRes.user.is_manager.intValue();
                }
                this.userData.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.hIo.add(muteUser);
                        }
                    }
                }
                this.dma.hi(this.dma.aep() > 0 ? this.dma.aep() - 1 : 0);
                List<AppData> chT = r.chV().chT();
                if (chT != null) {
                    chT.clear();
                }
                this.hIw = null;
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        com.baidu.tieba.tbadkCore.data.m mVar = new com.baidu.tieba.tbadkCore.data.m();
                        mVar.d(app);
                        AppData cpz = mVar.cpz();
                        if (!this.hIv.contains(mVar) && cpz.goods != null && (!StringUtils.isNull(cpz.goods.user_name) || !StringUtils.isNull(cpz.goods.lego_card))) {
                            this.hIv.add(mVar);
                            if (chT != null) {
                                chT.add(mVar.cpz());
                            }
                        }
                    }
                    a(dataRes);
                }
                r.chV().chU();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.userData.getIsSelectTail());
                }
                this.hIx.parserProtobuf(dataRes.twzhibo_anti);
                this.hIy = dataRes.appeal_info;
                if (dataRes.god_card != null) {
                    this.hIq = new a();
                    this.hIq.a(dataRes.god_card);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.hIE = new f();
                    this.hIE.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.guess_like != null) {
                    this.hIF = new CardHListViewData();
                    this.hIF.parseProtobuf(dataRes.guess_like);
                }
                if (dataRes.feed_thread_list != null && dataRes.feed_thread_list.size() > 0) {
                    List<ThreadInfo> list3 = dataRes.feed_thread_list;
                    if (this.hIs == null) {
                        this.hIs = new ArrayList();
                    }
                    this.hIs.clear();
                    for (ThreadInfo threadInfo : list3) {
                        if (threadInfo != null) {
                            bh bhVar = new bh();
                            bhVar.a(threadInfo);
                            this.hIs.add(bhVar);
                        }
                    }
                    if (this.hIs != null && this.hIs.size() > 15) {
                        this.hIs = v.c(this.hIs, 0, 15);
                    }
                }
                this.hIt = dataRes.is_follow_current_channel.intValue();
                if (v.Z(dataRes.repost_recommend_forum_list) > 0) {
                    if (this.hIz == null) {
                        this.hIz = new ArrayList();
                    }
                    for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                        bd bdVar = new bd();
                        bdVar.parserProtobuf(simpleForum);
                        this.hIz.add(bdVar);
                    }
                }
                if (v.Z(dataRes.from_forum_list) > 0) {
                    if (this.hIA == null) {
                        this.hIA = new ArrayList();
                    }
                    for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                        if (simpleForum2 != null) {
                            bd bdVar2 = new bd();
                            bdVar2.parserProtobuf(simpleForum2);
                            this.hIA.add(bdVar2);
                        }
                    }
                }
                this.hIP = dataRes.multi_forum_text;
                if (this.hIG >= 0) {
                    this.hIG = dataRes.thread_freq_num.longValue();
                }
                this.hIH = new j();
                this.hIH.ccq = this.dma;
                this.hIH.b(dataRes);
                this.hII = dataRes.partial_visible_toast;
                if (dataRes.follow_tip != null && dataRes.follow_tip.is_toast_tip.intValue() == 1) {
                    this.hIk = dataRes.follow_tip.tip_text;
                }
                this.hIu = new AlaLiveInfoCoreData();
                if (dataRes.ala_info != null) {
                    this.hIu.parserProtoBuf(dataRes.ala_info);
                }
                this.hIO = dataRes.fold_tip;
                this.hIJ = dataRes.exp_news_today.intValue();
                this.hIK = dataRes.exp_guide_today.intValue();
                if (!v.aa(dataRes.thread_topic)) {
                    for (int i2 = 0; i2 < dataRes.thread_topic.size(); i2++) {
                        az.a aVar = new az.a();
                        aVar.a(dataRes.thread_topic.get(i2));
                        this.hIQ.add(aVar);
                    }
                }
                this.hIL = dataRes.pb_sort_info;
                this.hIM = dataRes.sort_type.intValue();
                if (dataRes.manager_election != null) {
                    this.hIN = g.a(dataRes.manager_election);
                }
                if (dataRes.business_promot_info != null) {
                    this.hIS = dataRes.business_promot_info.is_promot.intValue() == 1;
                }
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }

    private void a(DataRes dataRes) {
        List<String> mo;
        App app = dataRes.banner_list.pb_banner_ad;
        com.baidu.tieba.tbadkCore.data.m mVar = new com.baidu.tieba.tbadkCore.data.m();
        mVar.jgb = true;
        mVar.d(app);
        AppData cpz = mVar.cpz();
        if (cpz.goods != null) {
            if (v.aa(cpz.goods.thread_pic_list) && (mo = AdvertAppInfo.a.mo(cpz.goods.lego_card)) != null && cpz.goods.thread_pic_list != null) {
                cpz.goods.thread_pic_list.addAll(mo);
            }
            this.hIw = mVar;
        }
    }

    public String bST() {
        return this.hIO;
    }

    public CardHListViewData bSU() {
        return this.hIF;
    }

    public PostData bSV() {
        return this.hID;
    }

    public PostData d(PostData postData) {
        this.hID = postData;
        return postData;
    }

    public m bSW() {
        return this.hIB;
    }

    public int bSX() {
        return this.hIj;
    }

    public int getIsNewUrl() {
        return this.hIl;
    }

    public void setIsNewUrl(int i) {
        this.hIl = i;
    }

    public List<MuteUser> bSY() {
        return this.hIo;
    }

    public ArrayList<com.baidu.tieba.tbadkCore.data.m> bSZ() {
        return this.hIv;
    }

    public com.baidu.tieba.tbadkCore.data.m bTa() {
        return this.hIw;
    }

    public void b(com.baidu.tieba.tbadkCore.data.m mVar) {
        this.hIw = mVar;
    }

    public void bTb() {
        if (this.hIw.cpz() != null) {
            this.hIw.cpz().legoCard = null;
        }
        this.hIw = null;
    }

    public a bTc() {
        return this.hIq;
    }

    public String bTd() {
        return this.hIC;
    }

    public void BL(String str) {
        this.hIC = str;
    }

    public f bTe() {
        return this.hIE;
    }

    public int bTf() {
        return this.hIt;
    }

    public List<bd> bTg() {
        return this.hIA;
    }

    public long bTh() {
        return this.hIG;
    }

    public j bTi() {
        return this.hIH;
    }

    public boolean bTj() {
        return (bSL() == null || !bSL().afs() || bSL().aeP() == null) ? false : true;
    }

    public AlaLiveInfoCoreData bTk() {
        return this.hIu;
    }
}

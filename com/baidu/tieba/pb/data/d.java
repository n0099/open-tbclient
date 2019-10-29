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
    private String hIL;
    private int hIM;
    private a hIR;
    private List<bh> hIT;
    private int hIU;
    private AlaLiveInfoCoreData hIV;
    private TwzhiboAnti hIY;
    public AppealInfo hIZ;
    private List<bd> hJa;
    private List<bd> hJb;
    public String hJd;
    private PostData hJe;
    private f hJf;
    public CardHListViewData hJg;
    private long hJh;
    private j hJi;
    public String hJj;
    public int hJk;
    public int hJl;
    public List<PbSortType> hJm;
    public int hJn;
    public g hJo;
    private String hJp;
    private String hJq;
    private PostData hJv;
    private boolean hIQ = true;
    private ArrayList<com.baidu.tieba.tbadkCore.data.m> hIW = new ArrayList<>();
    private com.baidu.tieba.tbadkCore.data.m hIX = null;
    public boolean hJt = false;
    public boolean hJu = false;
    private ForumData forum = new ForumData();
    private bd hIH = new bd();
    private bh dvi = new bh();
    private ArrayList<PostData> hII = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private an page = new an();
    private AntiData anti = new AntiData();
    private com.baidu.tbadk.data.f hIJ = new com.baidu.tbadk.data.f();
    private int hIK = 0;
    private final UserData userData = new UserData();
    private List<MuteUser> hIP = new ArrayList();
    private ap hIN = new ap();
    private aq hIS = new aq();
    private ad hIO = new ad();
    private m hJc = new m();
    private List<az.a> hJr = new ArrayList();
    private HashSet<String> hJs = new HashSet<>();

    public boolean bQx() {
        return this.hIQ;
    }

    public void nR(boolean z) {
        this.hIQ = z;
    }

    public d() {
        this.hIM = 0;
        this.hIY = null;
        this.hIM = 0;
        this.hIY = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.hII != null && this.hII.size() > 0;
    }

    public String[] dP(Context context) {
        String str = null;
        String str2 = "";
        if (isValid()) {
            int size = this.hII.size() > 30 ? 30 : this.hII.size();
            if (bQz() == null || bQz().aiG() == null || com.baidu.tbadk.core.util.aq.isEmpty(bQz().aiG().getUserId())) {
                return new String[]{null, ""};
            }
            String userId = bQz().aiG().getUserId();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                PostData postData = (PostData) v.getItem(this.hII, i);
                if (postData != null && postData.aiG() != null && !com.baidu.tbadk.core.util.aq.isEmpty(postData.aiG().getUserId()) && com.baidu.tbadk.core.util.aq.equals(userId, postData.aiG().getUserId())) {
                    if (com.baidu.tbadk.core.util.aq.isEmpty(str)) {
                        str = postData.cow();
                    }
                    String cou = com.baidu.tbadk.core.util.aq.isEmpty(str2) ? postData.cou() : str2;
                    if (!com.baidu.tbadk.core.util.aq.isEmpty(str) && !com.baidu.tbadk.core.util.aq.isEmpty(cou)) {
                        str2 = cou;
                        break;
                    }
                    str2 = cou;
                }
                i++;
                str = str;
            }
            if (com.baidu.tbadk.core.util.aq.isEmpty(str)) {
                str = "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            }
            PostData postData2 = this.hII.get(0);
            if (this.dvi != null && this.dvi.ajy() != null && this.dvi.ajy().getGroup_id() != 0) {
                str2 = "[" + context.getString(R.string.photo_live_tips) + "] " + str2;
            }
            if (this.dvi != null && this.dvi.ajA() && postData2 != null && postData2.azt() != null) {
                str = postData2.azt().getThumbUrl();
            }
        }
        return new String[]{str, str2};
    }

    public ForumData getForum() {
        return this.forum;
    }

    public bd bQy() {
        return this.hIH;
    }

    public String getForumId() {
        if (this.forum == null) {
            return "";
        }
        return this.forum.getId();
    }

    public bh bQz() {
        return this.dvi;
    }

    public List<bh> bQA() {
        return this.hIT;
    }

    public String getThreadId() {
        if (this.dvi == null) {
            return "";
        }
        return this.dvi.getId();
    }

    public ArrayList<PostData> bQB() {
        return this.hII;
    }

    public an getPage() {
        return this.page;
    }

    public ad bQC() {
        return this.hIO;
    }

    public aq bQD() {
        return this.hIS;
    }

    public void a(an anVar, int i) {
        this.page.hA(anVar.ahy());
        this.page.hy(anVar.agP());
        this.page.hx(anVar.ahv());
        this.page.hB(anVar.ahz());
        this.page.hz(anVar.ahx());
        if (i == 0) {
            this.page = anVar;
        } else if (i == 1) {
            this.page.hC(anVar.ahA());
        } else if (i == 2) {
            this.page.hD(anVar.ahB());
        }
    }

    public AntiData getAnti() {
        return this.anti;
    }

    public UserData getUserData() {
        return this.userData;
    }

    public boolean afm() {
        return this.dvi.aiO() != 0;
    }

    public void dO(boolean z) {
        if (this.dvi != null) {
            if (z) {
                this.dvi.hM(1);
            } else {
                this.dvi.hM(0);
            }
        }
    }

    public String afl() {
        if (this.dvi != null) {
            return this.dvi.aiP();
        }
        return null;
    }

    public void AC(String str) {
        if (this.dvi != null) {
            this.dvi.nc(str);
        }
    }

    public String bQE() {
        return this.hJq;
    }

    public boolean bQF() {
        return (this.dvi == null || this.dvi.aiR() == null || this.dvi.aiR().size() <= 0 || this.dvi.aiR().get(0) == null || !this.dvi.aiR().get(0).agQ()) ? false : true;
    }

    public PostData bQG() {
        return this.hJv;
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                com.baidu.tieba.recapp.d.a.cgD().CN(dataRes.asp_shown_info);
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
                this.hIH.parserProtobuf(dataRes.display_forum);
                this.dvi.setUserMap(this.userMap);
                this.dvi.a(dataRes.thread);
                this.dvi.setCurrentPage(2);
                this.hIN.a(dataRes.news_info);
                switch (this.hIN.cad) {
                    case 1:
                        this.hIO.hTs = this.hIN;
                        break;
                    case 2:
                        this.hIO.hTt = this.hIN;
                        break;
                    case 3:
                        this.hIO.hTu = this.hIN;
                        break;
                    default:
                        this.hIO.hTt = this.hIN;
                        break;
                }
                this.hIS.a(dataRes.recommend_book);
                List<Post> list2 = dataRes.post_list;
                if (list2 != null && list2.size() > 0) {
                    for (Post post : dataRes.post_list) {
                        if (!this.hJs.contains(String.valueOf(post.id))) {
                            PostData postData = new PostData();
                            postData.setUserMap(this.userMap);
                            postData.qM(this.forum.isBrandForum);
                            postData.a(post, context);
                            postData.a(bQz().ais());
                            this.hJs.add(postData.getId());
                            if (postData.cop() == 1 && this.dvi.ajr()) {
                                if (bQF()) {
                                    postData.setPostType(0);
                                } else {
                                    postData.setPostType(this.dvi.ajq());
                                }
                            } else if (postData.cop() == 1 && this.dvi.ajG()) {
                                postData.setPostType(41);
                            } else if (postData.cop() == 1 && this.dvi != null && this.dvi.ajA()) {
                                postData.setPostType(0);
                                postData.azt();
                                if (this.dvi.aiE() == null || this.dvi.aiE().size() == 0) {
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
                                    postData.c(new TbRichText((Context) TbadkCoreApplication.getInst(), this.dvi.aiE(), true));
                                }
                                this.hJe = postData;
                            }
                            if (postData.cop() == 1 && this.dvi != null && this.dvi.isShareThread) {
                                postData.g(this.dvi.cec);
                            }
                            this.hII.add(postData);
                        }
                    }
                }
                if (dataRes.first_floor_post != null) {
                    this.hJv = new PostData();
                    this.hJv.setUserMap(this.userMap);
                    this.hJv.qM(this.forum.isBrandForum);
                    this.hJv.a(dataRes.first_floor_post, context);
                    if (this.dvi != null && this.dvi.isShareThread) {
                        this.hJv.g(this.dvi.cec);
                    }
                }
                this.page.a(dataRes.page);
                this.anti.parserProtobuf(dataRes.anti);
                this.hIJ.a(dataRes.location);
                if (dataRes.user != null) {
                    this.hIK = dataRes.user.is_manager.intValue();
                }
                this.userData.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.hIP.add(muteUser);
                        }
                    }
                }
                this.dvi.hI(this.dvi.aix() > 0 ? this.dvi.aix() - 1 : 0);
                List<AppData> cfJ = r.cfL().cfJ();
                if (cfJ != null) {
                    cfJ.clear();
                }
                this.hIX = null;
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        com.baidu.tieba.tbadkCore.data.m mVar = new com.baidu.tieba.tbadkCore.data.m();
                        mVar.d(app);
                        AppData cod = mVar.cod();
                        if (!this.hIW.contains(mVar) && cod.goods != null && (!StringUtils.isNull(cod.goods.user_name) || !StringUtils.isNull(cod.goods.lego_card))) {
                            this.hIW.add(mVar);
                            if (cfJ != null) {
                                cfJ.add(mVar.cod());
                            }
                        }
                    }
                    a(dataRes);
                }
                r.cfL().cfK();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.userData.getIsSelectTail());
                }
                this.hIY.parserProtobuf(dataRes.twzhibo_anti);
                this.hIZ = dataRes.appeal_info;
                if (dataRes.god_card != null) {
                    this.hIR = new a();
                    this.hIR.a(dataRes.god_card);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.hJf = new f();
                    this.hJf.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.guess_like != null) {
                    this.hJg = new CardHListViewData();
                    this.hJg.parseProtobuf(dataRes.guess_like);
                }
                if (dataRes.feed_thread_list != null && dataRes.feed_thread_list.size() > 0) {
                    List<ThreadInfo> list3 = dataRes.feed_thread_list;
                    if (this.hIT == null) {
                        this.hIT = new ArrayList();
                    }
                    this.hIT.clear();
                    for (ThreadInfo threadInfo : list3) {
                        if (threadInfo != null) {
                            bh bhVar = new bh();
                            bhVar.a(threadInfo);
                            this.hIT.add(bhVar);
                        }
                    }
                    if (this.hIT != null && this.hIT.size() > 15) {
                        this.hIT = v.subList(this.hIT, 0, 15);
                    }
                }
                this.hIU = dataRes.is_follow_current_channel.intValue();
                if (v.getCount(dataRes.repost_recommend_forum_list) > 0) {
                    if (this.hJa == null) {
                        this.hJa = new ArrayList();
                    }
                    for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                        bd bdVar = new bd();
                        bdVar.parserProtobuf(simpleForum);
                        this.hJa.add(bdVar);
                    }
                }
                if (v.getCount(dataRes.from_forum_list) > 0) {
                    if (this.hJb == null) {
                        this.hJb = new ArrayList();
                    }
                    for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                        if (simpleForum2 != null) {
                            bd bdVar2 = new bd();
                            bdVar2.parserProtobuf(simpleForum2);
                            this.hJb.add(bdVar2);
                        }
                    }
                }
                this.hJq = dataRes.multi_forum_text;
                if (this.hJh >= 0) {
                    this.hJh = dataRes.thread_freq_num.longValue();
                }
                this.hJi = new j();
                this.hJi.cry = this.dvi;
                this.hJi.b(dataRes);
                this.hJj = dataRes.partial_visible_toast;
                if (dataRes.follow_tip != null && dataRes.follow_tip.is_toast_tip.intValue() == 1) {
                    this.hIL = dataRes.follow_tip.tip_text;
                }
                this.hIV = new AlaLiveInfoCoreData();
                if (dataRes.ala_info != null) {
                    this.hIV.parserProtoBuf(dataRes.ala_info);
                }
                this.hJp = dataRes.fold_tip;
                this.hJk = dataRes.exp_news_today.intValue();
                this.hJl = dataRes.exp_guide_today.intValue();
                if (!v.isEmpty(dataRes.thread_topic)) {
                    for (int i2 = 0; i2 < dataRes.thread_topic.size(); i2++) {
                        az.a aVar = new az.a();
                        aVar.a(dataRes.thread_topic.get(i2));
                        this.hJr.add(aVar);
                    }
                }
                this.hJm = dataRes.pb_sort_info;
                this.hJn = dataRes.sort_type.intValue();
                if (dataRes.manager_election != null) {
                    this.hJo = g.a(dataRes.manager_election);
                }
                if (dataRes.business_promot_info != null) {
                    this.hJt = dataRes.business_promot_info.is_promot.longValue() == 1;
                    this.hJu = dataRes.business_promot_info.is_headlinepost.intValue() == 1;
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
        mVar.jil = true;
        mVar.d(app);
        AppData cod = mVar.cod();
        if (cod.goods != null) {
            if (v.isEmpty(cod.goods.thread_pic_list) && (mN = AdvertAppInfo.a.mN(cod.goods.lego_card)) != null && cod.goods.thread_pic_list != null) {
                cod.goods.thread_pic_list.addAll(mN);
            }
            this.hIX = mVar;
        }
    }

    public String bQH() {
        return this.hJp;
    }

    public CardHListViewData bQI() {
        return this.hJg;
    }

    public PostData bQJ() {
        return this.hJe;
    }

    public PostData d(PostData postData) {
        this.hJe = postData;
        return postData;
    }

    public m bQK() {
        return this.hJc;
    }

    public int bQL() {
        return this.hIK;
    }

    public int getIsNewUrl() {
        return this.hIM;
    }

    public void setIsNewUrl(int i) {
        this.hIM = i;
    }

    public List<MuteUser> bQM() {
        return this.hIP;
    }

    public ArrayList<com.baidu.tieba.tbadkCore.data.m> bQN() {
        return this.hIW;
    }

    public com.baidu.tieba.tbadkCore.data.m bQO() {
        return this.hIX;
    }

    public void b(com.baidu.tieba.tbadkCore.data.m mVar) {
        this.hIX = mVar;
    }

    public void bQP() {
        if (this.hIX.cod() != null) {
            this.hIX.cod().legoCard = null;
        }
        this.hIX = null;
    }

    public a bQQ() {
        return this.hIR;
    }

    public String bQR() {
        return this.hJd;
    }

    public void AD(String str) {
        this.hJd = str;
    }

    public f bQS() {
        return this.hJf;
    }

    public int bQT() {
        return this.hIU;
    }

    public List<bd> bQU() {
        return this.hJb;
    }

    public long bQV() {
        return this.hJh;
    }

    public j bQW() {
        return this.hJi;
    }

    public boolean bQX() {
        return (bQz() == null || !bQz().ajA() || bQz().aiX() == null) ? false : true;
    }

    public AlaLiveInfoCoreData bQY() {
        return this.hIV;
    }
}

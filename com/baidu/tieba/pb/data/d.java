package com.baidu.tieba.pb.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.TwzhiboAnti;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.data.an;
import com.baidu.tbadk.core.data.ao;
import com.baidu.tbadk.core.data.au;
import com.baidu.tbadk.core.data.ay;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.e;
import com.baidu.tieba.pb.pb.main.ad;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.tbadkCore.data.AppData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.data.l;
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
public class d {
    private String fSK;
    private int fSL;
    private a fSR;
    private List<bb> fST;
    private int fSU;
    private AlaLiveInfoCoreData fSV;
    private TwzhiboAnti fSY;
    public AppealInfo fSZ;
    private List<ay> fTa;
    private List<ay> fTb;
    public String fTd;
    private PostData fTe;
    private f fTf;
    public CardHListViewData fTg;
    private long fTh;
    private i fTi;
    public String fTj;
    public int fTk;
    public int fTl;
    public List<PbSortType> fTm;
    public int fTn;
    private String fTo;
    private String fTp;
    private PostData fTs;
    private boolean fSQ = true;
    private ArrayList<l> fSW = new ArrayList<>();
    private l fSX = null;
    private ForumData fSF = new ForumData();
    private ay fSG = new ay();
    private bb bMM = new bb();
    private ArrayList<PostData> fSH = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private al fhz = new al();
    private AntiData arV = new AntiData();
    private com.baidu.tbadk.data.f fSI = new com.baidu.tbadk.data.f();
    private int fSJ = 0;
    private final UserData fSM = new UserData();
    private List<MuteUser> fSP = new ArrayList();
    private an fSN = new an();
    private ao fSS = new ao();
    private ad fSO = new ad();
    private k fTc = new k();
    private List<au.a> fTq = new ArrayList();
    private HashSet<String> fTr = new HashSet<>();

    public boolean bgS() {
        return this.fSQ;
    }

    public void ky(boolean z) {
        this.fSQ = z;
    }

    public d() {
        this.fSL = 0;
        this.fSY = null;
        this.fSL = 0;
        this.fSY = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.fSH != null && this.fSH.size() > 0;
    }

    public String[] cP(Context context) {
        String str = null;
        String str2 = "";
        if (isValid()) {
            int size = this.fSH.size() > 30 ? 30 : this.fSH.size();
            if (bgV() == null || bgV().zG() == null || com.baidu.tbadk.core.util.ao.isEmpty(bgV().zG().getUserId())) {
                return new String[]{null, ""};
            }
            String userId = bgV().zG().getUserId();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                PostData postData = (PostData) v.d(this.fSH, i);
                if (postData != null && postData.zG() != null && !com.baidu.tbadk.core.util.ao.isEmpty(postData.zG().getUserId()) && com.baidu.tbadk.core.util.ao.equals(userId, postData.zG().getUserId())) {
                    if (com.baidu.tbadk.core.util.ao.isEmpty(str)) {
                        str = postData.bEq();
                    }
                    String bEo = com.baidu.tbadk.core.util.ao.isEmpty(str2) ? postData.bEo() : str2;
                    if (!com.baidu.tbadk.core.util.ao.isEmpty(str) && !com.baidu.tbadk.core.util.ao.isEmpty(bEo)) {
                        str2 = bEo;
                        break;
                    }
                    str2 = bEo;
                }
                i++;
                str = str;
            }
            if (com.baidu.tbadk.core.util.ao.isEmpty(str)) {
                str = "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            }
            PostData postData2 = this.fSH.get(0);
            if (this.bMM != null && this.bMM.As() != null && this.bMM.As().getGroup_id() != 0) {
                str2 = "[" + context.getString(e.j.photo_live_tips) + "] " + str2;
            }
            if (this.bMM != null && this.bMM.Au() && postData2 != null && postData2.Sl() != null) {
                str = postData2.Sl().getThumbUrl();
            }
        }
        return new String[]{str, str2};
    }

    public ForumData bgT() {
        return this.fSF;
    }

    public ay bgU() {
        return this.fSG;
    }

    public String getForumId() {
        if (this.fSF == null) {
            return "";
        }
        return this.fSF.getId();
    }

    public bb bgV() {
        return this.bMM;
    }

    public List<bb> bgW() {
        return this.fST;
    }

    public String getThreadId() {
        if (this.bMM == null) {
            return "";
        }
        return this.bMM.getId();
    }

    public ArrayList<PostData> bgX() {
        return this.fSH;
    }

    public al yS() {
        return this.fhz;
    }

    public ad bgY() {
        return this.fSO;
    }

    public ao bgZ() {
        return this.fSS;
    }

    public void a(al alVar, int i) {
        this.fhz.cI(alVar.yN());
        this.fhz.cG(alVar.ya());
        this.fhz.cF(alVar.yK());
        this.fhz.cJ(alVar.yO());
        this.fhz.cH(alVar.yM());
        if (i == 0) {
            this.fhz = alVar;
        } else if (i == 1) {
            this.fhz.cK(alVar.yP());
        } else if (i == 2) {
            this.fhz.cL(alVar.yQ());
        }
    }

    public AntiData yE() {
        return this.arV;
    }

    public UserData getUserData() {
        return this.fSM;
    }

    public boolean wq() {
        return this.bMM.zP() != 0;
    }

    public void aP(boolean z) {
        if (this.bMM != null) {
            if (z) {
                this.bMM.cT(1);
            } else {
                this.bMM.cT(0);
            }
        }
    }

    public String wp() {
        if (this.bMM != null) {
            return this.bMM.zQ();
        }
        return null;
    }

    public void sO(String str) {
        if (this.bMM != null) {
            this.bMM.ep(str);
        }
    }

    public String bha() {
        return this.fTp;
    }

    public boolean bhb() {
        return (this.bMM == null || this.bMM.zS() == null || this.bMM.zS().size() <= 0 || this.bMM.zS().get(0) == null || !this.bMM.zS().get(0).yb()) ? false : true;
    }

    public PostData bhc() {
        return this.fTs;
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                com.baidu.tieba.recapp.d.a.bwa().uN(dataRes.asp_shown_info);
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
                sl(dataRes.is_new_url.intValue());
                this.fSF.parserProtobuf(dataRes.forum);
                this.fSG.parserProtobuf(dataRes.display_forum);
                this.bMM.setUserMap(this.userMap);
                this.bMM.a(dataRes.thread);
                this.bMM.setCurrentPage(2);
                this.fSN.a(dataRes.news_info);
                switch (this.fSN.asp) {
                    case 1:
                        this.fSO.gdh = this.fSN;
                        break;
                    case 2:
                        this.fSO.gdi = this.fSN;
                        break;
                    case 3:
                        this.fSO.gdj = this.fSN;
                        break;
                    default:
                        this.fSO.gdi = this.fSN;
                        break;
                }
                this.fSS.a(dataRes.recommend_book);
                List<Post> list2 = dataRes.post_list;
                if (list2 != null && list2.size() > 0) {
                    for (Post post : dataRes.post_list) {
                        if (!this.fTr.contains(String.valueOf(post.id))) {
                            PostData postData = new PostData();
                            postData.setUserMap(this.userMap);
                            postData.kA(this.fSF.isBrandForum);
                            postData.a(post, context);
                            postData.a(bgV().zt());
                            this.fTr.add(postData.getId());
                            if (postData.bEj() == 1 && this.bMM.Al()) {
                                if (bhb()) {
                                    postData.setPostType(0);
                                } else {
                                    postData.setPostType(this.bMM.Ak());
                                }
                            } else if (postData.bEj() == 1 && this.bMM.Ay()) {
                                postData.setPostType(41);
                            } else if (postData.bEj() == 1 && this.bMM != null && this.bMM.Au()) {
                                postData.setPostType(0);
                                postData.Sl();
                                if (this.bMM.zE() == null || this.bMM.zE().size() == 0) {
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
                                    postData.c(new TbRichText((Context) TbadkCoreApplication.getInst(), this.bMM.zE(), true));
                                }
                                this.fTe = postData;
                            }
                            if (postData.bEj() == 1 && this.bMM != null && this.bMM.isShareThread) {
                                postData.g(this.bMM.avt);
                            }
                            this.fSH.add(postData);
                        }
                    }
                }
                if (dataRes.first_floor_post != null) {
                    this.fTs = new PostData();
                    this.fTs.setUserMap(this.userMap);
                    this.fTs.kA(this.fSF.isBrandForum);
                    this.fTs.a(dataRes.first_floor_post, context);
                    if (this.bMM != null && this.bMM.isShareThread) {
                        this.fTs.g(this.bMM.avt);
                    }
                }
                this.fhz.a(dataRes.page);
                this.arV.parserProtobuf(dataRes.anti);
                this.fSI.a(dataRes.location);
                if (dataRes.user != null) {
                    this.fSJ = dataRes.user.is_manager.intValue();
                }
                this.fSM.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.fSP.add(muteUser);
                        }
                    }
                }
                this.bMM.cP(this.bMM.zx() > 0 ? this.bMM.zx() - 1 : 0);
                List<AppData> bvi = r.bvk().bvi();
                if (bvi != null) {
                    bvi.clear();
                }
                this.fSX = null;
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        l lVar = new l();
                        lVar.d(app);
                        AppData bDX = lVar.bDX();
                        if (!this.fSW.contains(lVar) && bDX.goods != null && (!StringUtils.isNull(bDX.goods.user_name) || !StringUtils.isNull(bDX.goods.lego_card))) {
                            this.fSW.add(lVar);
                            if (bvi != null) {
                                bvi.add(lVar.bDX());
                            }
                        }
                    }
                    a(dataRes);
                }
                r.bvk().bvj();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.fSM.getIsSelectTail());
                }
                this.fSY.parserProtobuf(dataRes.twzhibo_anti);
                this.fSZ = dataRes.appeal_info;
                if (dataRes.god_card != null) {
                    this.fSR = new a();
                    this.fSR.a(dataRes.god_card);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.fTf = new f();
                    this.fTf.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.guess_like != null) {
                    this.fTg = new CardHListViewData();
                    this.fTg.parseProtobuf(dataRes.guess_like);
                }
                if (dataRes.feed_thread_list != null && dataRes.feed_thread_list.size() > 0) {
                    List<ThreadInfo> list3 = dataRes.feed_thread_list;
                    if (this.fST == null) {
                        this.fST = new ArrayList();
                    }
                    this.fST.clear();
                    for (ThreadInfo threadInfo : list3) {
                        if (threadInfo != null) {
                            bb bbVar = new bb();
                            bbVar.a(threadInfo);
                            this.fST.add(bbVar);
                        }
                    }
                    if (this.fST != null && this.fST.size() > 15) {
                        this.fST = v.b(this.fST, 0, 15);
                    }
                }
                this.fSU = dataRes.is_follow_current_channel.intValue();
                if (v.H(dataRes.repost_recommend_forum_list) > 0) {
                    if (this.fTa == null) {
                        this.fTa = new ArrayList();
                    }
                    for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                        ay ayVar = new ay();
                        ayVar.parserProtobuf(simpleForum);
                        this.fTa.add(ayVar);
                    }
                }
                if (v.H(dataRes.from_forum_list) > 0) {
                    if (this.fTb == null) {
                        this.fTb = new ArrayList();
                    }
                    for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                        if (simpleForum2 != null) {
                            ay ayVar2 = new ay();
                            ayVar2.parserProtobuf(simpleForum2);
                            this.fTb.add(ayVar2);
                        }
                    }
                }
                this.fTp = dataRes.multi_forum_text;
                if (dataRes.top_agree_post_list != null && this.fTc != null) {
                    this.fTc.kA(this.fSF.isBrandForum);
                    this.fTc.a(context, dataRes.top_agree_post_list);
                }
                if (this.fTh >= 0) {
                    this.fTh = dataRes.thread_freq_num.longValue();
                }
                this.fTi = new i();
                this.fTi.bNy = this.bMM;
                this.fTi.b(dataRes);
                this.fTj = dataRes.partial_visible_toast;
                if (dataRes.follow_tip != null && dataRes.follow_tip.is_toast_tip.intValue() == 1) {
                    this.fSK = dataRes.follow_tip.tip_text;
                }
                this.fSV = new AlaLiveInfoCoreData();
                if (dataRes.ala_info != null) {
                    this.fSV.parserProtoBuf(dataRes.ala_info);
                }
                this.fTo = dataRes.fold_tip;
                this.fTk = dataRes.exp_news_today.intValue();
                this.fTl = dataRes.exp_guide_today.intValue();
                if (!v.I(dataRes.thread_topic)) {
                    for (int i2 = 0; i2 < dataRes.thread_topic.size(); i2++) {
                        au.a aVar = new au.a();
                        aVar.a(dataRes.thread_topic.get(i2));
                        this.fTq.add(aVar);
                    }
                }
                this.fTm = dataRes.pb_sort_info;
                this.fTn = dataRes.sort_type.intValue();
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }

    private void a(DataRes dataRes) {
        App app = dataRes.banner_list.pb_banner_ad;
        l lVar = new l();
        lVar.hov = true;
        lVar.d(app);
        if (lVar.bDX().goods != null) {
            this.fSX = lVar;
        }
    }

    public String bhd() {
        return this.fTo;
    }

    public CardHListViewData bhe() {
        return this.fTg;
    }

    public PostData bhf() {
        return this.fTe;
    }

    public PostData d(PostData postData) {
        this.fTe = postData;
        return postData;
    }

    public k bhg() {
        return this.fTc;
    }

    public int bhh() {
        return this.fSJ;
    }

    public int bhi() {
        return this.fSL;
    }

    public void sl(int i) {
        this.fSL = i;
    }

    public List<MuteUser> bhj() {
        return this.fSP;
    }

    public ArrayList<l> bhk() {
        return this.fSW;
    }

    public l bhl() {
        return this.fSX;
    }

    public void bhm() {
        if (this.fSX.bDX() != null) {
            this.fSX.bDX().legoCard = null;
        }
        this.fSX = null;
    }

    public a bhn() {
        return this.fSR;
    }

    public String bho() {
        return this.fTd;
    }

    public void sP(String str) {
        this.fTd = str;
    }

    public f bhp() {
        return this.fTf;
    }

    public int bhq() {
        return this.fSU;
    }

    public List<ay> bhr() {
        return this.fTb;
    }

    public long bhs() {
        return this.fTh;
    }

    public i bht() {
        return this.fTi;
    }

    public boolean bhu() {
        return (bgV() == null || !bgV().Au() || bgV().zY() == null) ? false : true;
    }

    public String bhv() {
        return this.fSK;
    }

    public AlaLiveInfoCoreData bhw() {
        return this.fSV;
    }

    public List<au.a> bhx() {
        return this.fTq;
    }
}

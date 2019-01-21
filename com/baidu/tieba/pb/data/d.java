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
    private String fTI;
    private int fTJ;
    private a fTP;
    private List<bb> fTR;
    private int fTS;
    private AlaLiveInfoCoreData fTT;
    private TwzhiboAnti fTW;
    public AppealInfo fTX;
    private List<ay> fTY;
    private List<ay> fTZ;
    public String fUb;
    private PostData fUc;
    private f fUd;
    public CardHListViewData fUe;
    private long fUf;
    private i fUg;
    public String fUh;
    public int fUi;
    public int fUj;
    public List<PbSortType> fUk;
    public int fUl;
    private String fUm;
    private String fUn;
    private PostData fUq;
    private boolean fTO = true;
    private ArrayList<l> fTU = new ArrayList<>();
    private l fTV = null;
    private ForumData fTD = new ForumData();
    private ay fTE = new ay();
    private bb bNA = new bb();
    private ArrayList<PostData> fTF = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private al fip = new al();
    private AntiData asy = new AntiData();
    private com.baidu.tbadk.data.f fTG = new com.baidu.tbadk.data.f();
    private int fTH = 0;
    private final UserData fTK = new UserData();
    private List<MuteUser> fTN = new ArrayList();
    private an fTL = new an();
    private ao fTQ = new ao();
    private ad fTM = new ad();
    private k fUa = new k();
    private List<au.a> fUo = new ArrayList();
    private HashSet<String> fUp = new HashSet<>();

    public boolean bhw() {
        return this.fTO;
    }

    public void ky(boolean z) {
        this.fTO = z;
    }

    public d() {
        this.fTJ = 0;
        this.fTW = null;
        this.fTJ = 0;
        this.fTW = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.fTF != null && this.fTF.size() > 0;
    }

    public String[] cP(Context context) {
        String str = null;
        String str2 = "";
        if (isValid()) {
            int size = this.fTF.size() > 30 ? 30 : this.fTF.size();
            if (bhz() == null || bhz().zT() == null || com.baidu.tbadk.core.util.ao.isEmpty(bhz().zT().getUserId())) {
                return new String[]{null, ""};
            }
            String userId = bhz().zT().getUserId();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                PostData postData = (PostData) v.d(this.fTF, i);
                if (postData != null && postData.zT() != null && !com.baidu.tbadk.core.util.ao.isEmpty(postData.zT().getUserId()) && com.baidu.tbadk.core.util.ao.equals(userId, postData.zT().getUserId())) {
                    if (com.baidu.tbadk.core.util.ao.isEmpty(str)) {
                        str = postData.bEZ();
                    }
                    String bEX = com.baidu.tbadk.core.util.ao.isEmpty(str2) ? postData.bEX() : str2;
                    if (!com.baidu.tbadk.core.util.ao.isEmpty(str) && !com.baidu.tbadk.core.util.ao.isEmpty(bEX)) {
                        str2 = bEX;
                        break;
                    }
                    str2 = bEX;
                }
                i++;
                str = str;
            }
            if (com.baidu.tbadk.core.util.ao.isEmpty(str)) {
                str = "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            }
            PostData postData2 = this.fTF.get(0);
            if (this.bNA != null && this.bNA.AF() != null && this.bNA.AF().getGroup_id() != 0) {
                str2 = "[" + context.getString(e.j.photo_live_tips) + "] " + str2;
            }
            if (this.bNA != null && this.bNA.AH() && postData2 != null && postData2.SH() != null) {
                str = postData2.SH().getThumbUrl();
            }
        }
        return new String[]{str, str2};
    }

    public ForumData bhx() {
        return this.fTD;
    }

    public ay bhy() {
        return this.fTE;
    }

    public String getForumId() {
        if (this.fTD == null) {
            return "";
        }
        return this.fTD.getId();
    }

    public bb bhz() {
        return this.bNA;
    }

    public List<bb> bhA() {
        return this.fTR;
    }

    public String getThreadId() {
        if (this.bNA == null) {
            return "";
        }
        return this.bNA.getId();
    }

    public ArrayList<PostData> bhB() {
        return this.fTF;
    }

    public al zf() {
        return this.fip;
    }

    public ad bhC() {
        return this.fTM;
    }

    public ao bhD() {
        return this.fTQ;
    }

    public void a(al alVar, int i) {
        this.fip.cI(alVar.za());
        this.fip.cG(alVar.yn());
        this.fip.cF(alVar.yX());
        this.fip.cJ(alVar.zb());
        this.fip.cH(alVar.yZ());
        if (i == 0) {
            this.fip = alVar;
        } else if (i == 1) {
            this.fip.cK(alVar.zc());
        } else if (i == 2) {
            this.fip.cL(alVar.zd());
        }
    }

    public AntiData yR() {
        return this.asy;
    }

    public UserData getUserData() {
        return this.fTK;
    }

    public boolean wx() {
        return this.bNA.Ac() != 0;
    }

    public void aQ(boolean z) {
        if (this.bNA != null) {
            if (z) {
                this.bNA.cT(1);
            } else {
                this.bNA.cT(0);
            }
        }
    }

    public String ww() {
        if (this.bNA != null) {
            return this.bNA.Ad();
        }
        return null;
    }

    public void te(String str) {
        if (this.bNA != null) {
            this.bNA.ey(str);
        }
    }

    public String bhE() {
        return this.fUn;
    }

    public boolean bhF() {
        return (this.bNA == null || this.bNA.Af() == null || this.bNA.Af().size() <= 0 || this.bNA.Af().get(0) == null || !this.bNA.Af().get(0).yo()) ? false : true;
    }

    public PostData bhG() {
        return this.fUq;
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                com.baidu.tieba.recapp.d.a.bwJ().vd(dataRes.asp_shown_info);
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
                sp(dataRes.is_new_url.intValue());
                this.fTD.parserProtobuf(dataRes.forum);
                this.fTE.parserProtobuf(dataRes.display_forum);
                this.bNA.setUserMap(this.userMap);
                this.bNA.a(dataRes.thread);
                this.bNA.setCurrentPage(2);
                this.fTL.a(dataRes.news_info);
                switch (this.fTL.asS) {
                    case 1:
                        this.fTM.geg = this.fTL;
                        break;
                    case 2:
                        this.fTM.geh = this.fTL;
                        break;
                    case 3:
                        this.fTM.gei = this.fTL;
                        break;
                    default:
                        this.fTM.geh = this.fTL;
                        break;
                }
                this.fTQ.a(dataRes.recommend_book);
                List<Post> list2 = dataRes.post_list;
                if (list2 != null && list2.size() > 0) {
                    for (Post post : dataRes.post_list) {
                        if (!this.fUp.contains(String.valueOf(post.id))) {
                            PostData postData = new PostData();
                            postData.setUserMap(this.userMap);
                            postData.kA(this.fTD.isBrandForum);
                            postData.a(post, context);
                            postData.a(bhz().zG());
                            this.fUp.add(postData.getId());
                            if (postData.bES() == 1 && this.bNA.Ay()) {
                                if (bhF()) {
                                    postData.setPostType(0);
                                } else {
                                    postData.setPostType(this.bNA.Ax());
                                }
                            } else if (postData.bES() == 1 && this.bNA.AL()) {
                                postData.setPostType(41);
                            } else if (postData.bES() == 1 && this.bNA != null && this.bNA.AH()) {
                                postData.setPostType(0);
                                postData.SH();
                                if (this.bNA.zR() == null || this.bNA.zR().size() == 0) {
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
                                    postData.c(new TbRichText((Context) TbadkCoreApplication.getInst(), this.bNA.zR(), true));
                                }
                                this.fUc = postData;
                            }
                            if (postData.bES() == 1 && this.bNA != null && this.bNA.isShareThread) {
                                postData.g(this.bNA.avW);
                            }
                            this.fTF.add(postData);
                        }
                    }
                }
                if (dataRes.first_floor_post != null) {
                    this.fUq = new PostData();
                    this.fUq.setUserMap(this.userMap);
                    this.fUq.kA(this.fTD.isBrandForum);
                    this.fUq.a(dataRes.first_floor_post, context);
                    if (this.bNA != null && this.bNA.isShareThread) {
                        this.fUq.g(this.bNA.avW);
                    }
                }
                this.fip.a(dataRes.page);
                this.asy.parserProtobuf(dataRes.anti);
                this.fTG.a(dataRes.location);
                if (dataRes.user != null) {
                    this.fTH = dataRes.user.is_manager.intValue();
                }
                this.fTK.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.fTN.add(muteUser);
                        }
                    }
                }
                this.bNA.cP(this.bNA.zK() > 0 ? this.bNA.zK() - 1 : 0);
                List<AppData> bvR = r.bvT().bvR();
                if (bvR != null) {
                    bvR.clear();
                }
                this.fTV = null;
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        l lVar = new l();
                        lVar.d(app);
                        AppData bEG = lVar.bEG();
                        if (!this.fTU.contains(lVar) && bEG.goods != null && (!StringUtils.isNull(bEG.goods.user_name) || !StringUtils.isNull(bEG.goods.lego_card))) {
                            this.fTU.add(lVar);
                            if (bvR != null) {
                                bvR.add(lVar.bEG());
                            }
                        }
                    }
                    a(dataRes);
                }
                r.bvT().bvS();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.fTK.getIsSelectTail());
                }
                this.fTW.parserProtobuf(dataRes.twzhibo_anti);
                this.fTX = dataRes.appeal_info;
                if (dataRes.god_card != null) {
                    this.fTP = new a();
                    this.fTP.a(dataRes.god_card);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.fUd = new f();
                    this.fUd.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.guess_like != null) {
                    this.fUe = new CardHListViewData();
                    this.fUe.parseProtobuf(dataRes.guess_like);
                }
                if (dataRes.feed_thread_list != null && dataRes.feed_thread_list.size() > 0) {
                    List<ThreadInfo> list3 = dataRes.feed_thread_list;
                    if (this.fTR == null) {
                        this.fTR = new ArrayList();
                    }
                    this.fTR.clear();
                    for (ThreadInfo threadInfo : list3) {
                        if (threadInfo != null) {
                            bb bbVar = new bb();
                            bbVar.a(threadInfo);
                            this.fTR.add(bbVar);
                        }
                    }
                    if (this.fTR != null && this.fTR.size() > 15) {
                        this.fTR = v.b(this.fTR, 0, 15);
                    }
                }
                this.fTS = dataRes.is_follow_current_channel.intValue();
                if (v.H(dataRes.repost_recommend_forum_list) > 0) {
                    if (this.fTY == null) {
                        this.fTY = new ArrayList();
                    }
                    for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                        ay ayVar = new ay();
                        ayVar.parserProtobuf(simpleForum);
                        this.fTY.add(ayVar);
                    }
                }
                if (v.H(dataRes.from_forum_list) > 0) {
                    if (this.fTZ == null) {
                        this.fTZ = new ArrayList();
                    }
                    for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                        if (simpleForum2 != null) {
                            ay ayVar2 = new ay();
                            ayVar2.parserProtobuf(simpleForum2);
                            this.fTZ.add(ayVar2);
                        }
                    }
                }
                this.fUn = dataRes.multi_forum_text;
                if (dataRes.top_agree_post_list != null && this.fUa != null) {
                    this.fUa.kA(this.fTD.isBrandForum);
                    this.fUa.a(context, dataRes.top_agree_post_list);
                }
                if (this.fUf >= 0) {
                    this.fUf = dataRes.thread_freq_num.longValue();
                }
                this.fUg = new i();
                this.fUg.bOl = this.bNA;
                this.fUg.b(dataRes);
                this.fUh = dataRes.partial_visible_toast;
                if (dataRes.follow_tip != null && dataRes.follow_tip.is_toast_tip.intValue() == 1) {
                    this.fTI = dataRes.follow_tip.tip_text;
                }
                this.fTT = new AlaLiveInfoCoreData();
                if (dataRes.ala_info != null) {
                    this.fTT.parserProtoBuf(dataRes.ala_info);
                }
                this.fUm = dataRes.fold_tip;
                this.fUi = dataRes.exp_news_today.intValue();
                this.fUj = dataRes.exp_guide_today.intValue();
                if (!v.I(dataRes.thread_topic)) {
                    for (int i2 = 0; i2 < dataRes.thread_topic.size(); i2++) {
                        au.a aVar = new au.a();
                        aVar.a(dataRes.thread_topic.get(i2));
                        this.fUo.add(aVar);
                    }
                }
                this.fUk = dataRes.pb_sort_info;
                this.fUl = dataRes.sort_type.intValue();
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }

    private void a(DataRes dataRes) {
        App app = dataRes.banner_list.pb_banner_ad;
        l lVar = new l();
        lVar.hpB = true;
        lVar.d(app);
        if (lVar.bEG().goods != null) {
            this.fTV = lVar;
        }
    }

    public String bhH() {
        return this.fUm;
    }

    public CardHListViewData bhI() {
        return this.fUe;
    }

    public PostData bhJ() {
        return this.fUc;
    }

    public PostData d(PostData postData) {
        this.fUc = postData;
        return postData;
    }

    public k bhK() {
        return this.fUa;
    }

    public int bhL() {
        return this.fTH;
    }

    public int bhM() {
        return this.fTJ;
    }

    public void sp(int i) {
        this.fTJ = i;
    }

    public List<MuteUser> bhN() {
        return this.fTN;
    }

    public ArrayList<l> bhO() {
        return this.fTU;
    }

    public l bhP() {
        return this.fTV;
    }

    public void b(l lVar) {
        this.fTV = lVar;
    }

    public void bhQ() {
        if (this.fTV.bEG() != null) {
            this.fTV.bEG().legoCard = null;
        }
        this.fTV = null;
    }

    public a bhR() {
        return this.fTP;
    }

    public String bhS() {
        return this.fUb;
    }

    public void tf(String str) {
        this.fUb = str;
    }

    public f bhT() {
        return this.fUd;
    }

    public int bhU() {
        return this.fTS;
    }

    public List<ay> bhV() {
        return this.fTZ;
    }

    public long bhW() {
        return this.fUf;
    }

    public i bhX() {
        return this.fUg;
    }

    public boolean bhY() {
        return (bhz() == null || !bhz().AH() || bhz().Al() == null) ? false : true;
    }

    public String bhZ() {
        return this.fTI;
    }

    public AlaLiveInfoCoreData bia() {
        return this.fTT;
    }

    public List<au.a> bib() {
        return this.fUo;
    }
}

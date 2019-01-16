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
    private String fTH;
    private int fTI;
    private a fTO;
    private List<bb> fTQ;
    private int fTR;
    private AlaLiveInfoCoreData fTS;
    private TwzhiboAnti fTV;
    public AppealInfo fTW;
    private List<ay> fTX;
    private List<ay> fTY;
    public String fUa;
    private PostData fUb;
    private f fUc;
    public CardHListViewData fUd;
    private long fUe;
    private i fUf;
    public String fUg;
    public int fUh;
    public int fUi;
    public List<PbSortType> fUj;
    public int fUk;
    private String fUl;
    private String fUm;
    private PostData fUp;
    private boolean fTN = true;
    private ArrayList<l> fTT = new ArrayList<>();
    private l fTU = null;
    private ForumData fTC = new ForumData();
    private ay fTD = new ay();
    private bb bNz = new bb();
    private ArrayList<PostData> fTE = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private al fio = new al();
    private AntiData asx = new AntiData();
    private com.baidu.tbadk.data.f fTF = new com.baidu.tbadk.data.f();
    private int fTG = 0;
    private final UserData fTJ = new UserData();
    private List<MuteUser> fTM = new ArrayList();
    private an fTK = new an();
    private ao fTP = new ao();
    private ad fTL = new ad();
    private k fTZ = new k();
    private List<au.a> fUn = new ArrayList();
    private HashSet<String> fUo = new HashSet<>();

    public boolean bhw() {
        return this.fTN;
    }

    public void ky(boolean z) {
        this.fTN = z;
    }

    public d() {
        this.fTI = 0;
        this.fTV = null;
        this.fTI = 0;
        this.fTV = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.fTE != null && this.fTE.size() > 0;
    }

    public String[] cP(Context context) {
        String str = null;
        String str2 = "";
        if (isValid()) {
            int size = this.fTE.size() > 30 ? 30 : this.fTE.size();
            if (bhz() == null || bhz().zT() == null || com.baidu.tbadk.core.util.ao.isEmpty(bhz().zT().getUserId())) {
                return new String[]{null, ""};
            }
            String userId = bhz().zT().getUserId();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                PostData postData = (PostData) v.d(this.fTE, i);
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
            PostData postData2 = this.fTE.get(0);
            if (this.bNz != null && this.bNz.AF() != null && this.bNz.AF().getGroup_id() != 0) {
                str2 = "[" + context.getString(e.j.photo_live_tips) + "] " + str2;
            }
            if (this.bNz != null && this.bNz.AH() && postData2 != null && postData2.SH() != null) {
                str = postData2.SH().getThumbUrl();
            }
        }
        return new String[]{str, str2};
    }

    public ForumData bhx() {
        return this.fTC;
    }

    public ay bhy() {
        return this.fTD;
    }

    public String getForumId() {
        if (this.fTC == null) {
            return "";
        }
        return this.fTC.getId();
    }

    public bb bhz() {
        return this.bNz;
    }

    public List<bb> bhA() {
        return this.fTQ;
    }

    public String getThreadId() {
        if (this.bNz == null) {
            return "";
        }
        return this.bNz.getId();
    }

    public ArrayList<PostData> bhB() {
        return this.fTE;
    }

    public al zf() {
        return this.fio;
    }

    public ad bhC() {
        return this.fTL;
    }

    public ao bhD() {
        return this.fTP;
    }

    public void a(al alVar, int i) {
        this.fio.cI(alVar.za());
        this.fio.cG(alVar.yn());
        this.fio.cF(alVar.yX());
        this.fio.cJ(alVar.zb());
        this.fio.cH(alVar.yZ());
        if (i == 0) {
            this.fio = alVar;
        } else if (i == 1) {
            this.fio.cK(alVar.zc());
        } else if (i == 2) {
            this.fio.cL(alVar.zd());
        }
    }

    public AntiData yR() {
        return this.asx;
    }

    public UserData getUserData() {
        return this.fTJ;
    }

    public boolean wx() {
        return this.bNz.Ac() != 0;
    }

    public void aQ(boolean z) {
        if (this.bNz != null) {
            if (z) {
                this.bNz.cT(1);
            } else {
                this.bNz.cT(0);
            }
        }
    }

    public String ww() {
        if (this.bNz != null) {
            return this.bNz.Ad();
        }
        return null;
    }

    public void te(String str) {
        if (this.bNz != null) {
            this.bNz.ey(str);
        }
    }

    public String bhE() {
        return this.fUm;
    }

    public boolean bhF() {
        return (this.bNz == null || this.bNz.Af() == null || this.bNz.Af().size() <= 0 || this.bNz.Af().get(0) == null || !this.bNz.Af().get(0).yo()) ? false : true;
    }

    public PostData bhG() {
        return this.fUp;
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
                this.fTC.parserProtobuf(dataRes.forum);
                this.fTD.parserProtobuf(dataRes.display_forum);
                this.bNz.setUserMap(this.userMap);
                this.bNz.a(dataRes.thread);
                this.bNz.setCurrentPage(2);
                this.fTK.a(dataRes.news_info);
                switch (this.fTK.asR) {
                    case 1:
                        this.fTL.gef = this.fTK;
                        break;
                    case 2:
                        this.fTL.geg = this.fTK;
                        break;
                    case 3:
                        this.fTL.geh = this.fTK;
                        break;
                    default:
                        this.fTL.geg = this.fTK;
                        break;
                }
                this.fTP.a(dataRes.recommend_book);
                List<Post> list2 = dataRes.post_list;
                if (list2 != null && list2.size() > 0) {
                    for (Post post : dataRes.post_list) {
                        if (!this.fUo.contains(String.valueOf(post.id))) {
                            PostData postData = new PostData();
                            postData.setUserMap(this.userMap);
                            postData.kA(this.fTC.isBrandForum);
                            postData.a(post, context);
                            postData.a(bhz().zG());
                            this.fUo.add(postData.getId());
                            if (postData.bES() == 1 && this.bNz.Ay()) {
                                if (bhF()) {
                                    postData.setPostType(0);
                                } else {
                                    postData.setPostType(this.bNz.Ax());
                                }
                            } else if (postData.bES() == 1 && this.bNz.AL()) {
                                postData.setPostType(41);
                            } else if (postData.bES() == 1 && this.bNz != null && this.bNz.AH()) {
                                postData.setPostType(0);
                                postData.SH();
                                if (this.bNz.zR() == null || this.bNz.zR().size() == 0) {
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
                                    postData.c(new TbRichText((Context) TbadkCoreApplication.getInst(), this.bNz.zR(), true));
                                }
                                this.fUb = postData;
                            }
                            if (postData.bES() == 1 && this.bNz != null && this.bNz.isShareThread) {
                                postData.g(this.bNz.avV);
                            }
                            this.fTE.add(postData);
                        }
                    }
                }
                if (dataRes.first_floor_post != null) {
                    this.fUp = new PostData();
                    this.fUp.setUserMap(this.userMap);
                    this.fUp.kA(this.fTC.isBrandForum);
                    this.fUp.a(dataRes.first_floor_post, context);
                    if (this.bNz != null && this.bNz.isShareThread) {
                        this.fUp.g(this.bNz.avV);
                    }
                }
                this.fio.a(dataRes.page);
                this.asx.parserProtobuf(dataRes.anti);
                this.fTF.a(dataRes.location);
                if (dataRes.user != null) {
                    this.fTG = dataRes.user.is_manager.intValue();
                }
                this.fTJ.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.fTM.add(muteUser);
                        }
                    }
                }
                this.bNz.cP(this.bNz.zK() > 0 ? this.bNz.zK() - 1 : 0);
                List<AppData> bvR = r.bvT().bvR();
                if (bvR != null) {
                    bvR.clear();
                }
                this.fTU = null;
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        l lVar = new l();
                        lVar.d(app);
                        AppData bEG = lVar.bEG();
                        if (!this.fTT.contains(lVar) && bEG.goods != null && (!StringUtils.isNull(bEG.goods.user_name) || !StringUtils.isNull(bEG.goods.lego_card))) {
                            this.fTT.add(lVar);
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
                    currentAccountObj.setIsSelectTail(this.fTJ.getIsSelectTail());
                }
                this.fTV.parserProtobuf(dataRes.twzhibo_anti);
                this.fTW = dataRes.appeal_info;
                if (dataRes.god_card != null) {
                    this.fTO = new a();
                    this.fTO.a(dataRes.god_card);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.fUc = new f();
                    this.fUc.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.guess_like != null) {
                    this.fUd = new CardHListViewData();
                    this.fUd.parseProtobuf(dataRes.guess_like);
                }
                if (dataRes.feed_thread_list != null && dataRes.feed_thread_list.size() > 0) {
                    List<ThreadInfo> list3 = dataRes.feed_thread_list;
                    if (this.fTQ == null) {
                        this.fTQ = new ArrayList();
                    }
                    this.fTQ.clear();
                    for (ThreadInfo threadInfo : list3) {
                        if (threadInfo != null) {
                            bb bbVar = new bb();
                            bbVar.a(threadInfo);
                            this.fTQ.add(bbVar);
                        }
                    }
                    if (this.fTQ != null && this.fTQ.size() > 15) {
                        this.fTQ = v.b(this.fTQ, 0, 15);
                    }
                }
                this.fTR = dataRes.is_follow_current_channel.intValue();
                if (v.H(dataRes.repost_recommend_forum_list) > 0) {
                    if (this.fTX == null) {
                        this.fTX = new ArrayList();
                    }
                    for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                        ay ayVar = new ay();
                        ayVar.parserProtobuf(simpleForum);
                        this.fTX.add(ayVar);
                    }
                }
                if (v.H(dataRes.from_forum_list) > 0) {
                    if (this.fTY == null) {
                        this.fTY = new ArrayList();
                    }
                    for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                        if (simpleForum2 != null) {
                            ay ayVar2 = new ay();
                            ayVar2.parserProtobuf(simpleForum2);
                            this.fTY.add(ayVar2);
                        }
                    }
                }
                this.fUm = dataRes.multi_forum_text;
                if (dataRes.top_agree_post_list != null && this.fTZ != null) {
                    this.fTZ.kA(this.fTC.isBrandForum);
                    this.fTZ.a(context, dataRes.top_agree_post_list);
                }
                if (this.fUe >= 0) {
                    this.fUe = dataRes.thread_freq_num.longValue();
                }
                this.fUf = new i();
                this.fUf.bOk = this.bNz;
                this.fUf.b(dataRes);
                this.fUg = dataRes.partial_visible_toast;
                if (dataRes.follow_tip != null && dataRes.follow_tip.is_toast_tip.intValue() == 1) {
                    this.fTH = dataRes.follow_tip.tip_text;
                }
                this.fTS = new AlaLiveInfoCoreData();
                if (dataRes.ala_info != null) {
                    this.fTS.parserProtoBuf(dataRes.ala_info);
                }
                this.fUl = dataRes.fold_tip;
                this.fUh = dataRes.exp_news_today.intValue();
                this.fUi = dataRes.exp_guide_today.intValue();
                if (!v.I(dataRes.thread_topic)) {
                    for (int i2 = 0; i2 < dataRes.thread_topic.size(); i2++) {
                        au.a aVar = new au.a();
                        aVar.a(dataRes.thread_topic.get(i2));
                        this.fUn.add(aVar);
                    }
                }
                this.fUj = dataRes.pb_sort_info;
                this.fUk = dataRes.sort_type.intValue();
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }

    private void a(DataRes dataRes) {
        App app = dataRes.banner_list.pb_banner_ad;
        l lVar = new l();
        lVar.hpA = true;
        lVar.d(app);
        if (lVar.bEG().goods != null) {
            this.fTU = lVar;
        }
    }

    public String bhH() {
        return this.fUl;
    }

    public CardHListViewData bhI() {
        return this.fUd;
    }

    public PostData bhJ() {
        return this.fUb;
    }

    public PostData d(PostData postData) {
        this.fUb = postData;
        return postData;
    }

    public k bhK() {
        return this.fTZ;
    }

    public int bhL() {
        return this.fTG;
    }

    public int bhM() {
        return this.fTI;
    }

    public void sp(int i) {
        this.fTI = i;
    }

    public List<MuteUser> bhN() {
        return this.fTM;
    }

    public ArrayList<l> bhO() {
        return this.fTT;
    }

    public l bhP() {
        return this.fTU;
    }

    public void b(l lVar) {
        this.fTU = lVar;
    }

    public void bhQ() {
        if (this.fTU.bEG() != null) {
            this.fTU.bEG().legoCard = null;
        }
        this.fTU = null;
    }

    public a bhR() {
        return this.fTO;
    }

    public String bhS() {
        return this.fUa;
    }

    public void tf(String str) {
        this.fUa = str;
    }

    public f bhT() {
        return this.fUc;
    }

    public int bhU() {
        return this.fTR;
    }

    public List<ay> bhV() {
        return this.fTY;
    }

    public long bhW() {
        return this.fUe;
    }

    public i bhX() {
        return this.fUf;
    }

    public boolean bhY() {
        return (bhz() == null || !bhz().AH() || bhz().Al() == null) ? false : true;
    }

    public String bhZ() {
        return this.fTH;
    }

    public AlaLiveInfoCoreData bia() {
        return this.fTS;
    }

    public List<au.a> bib() {
        return this.fUn;
    }
}

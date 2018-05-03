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
import com.baidu.tbadk.core.data.am;
import com.baidu.tbadk.core.data.ao;
import com.baidu.tbadk.core.data.ap;
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.ac;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.tbadkCore.data.AppData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.usermute.MuteUser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.App;
import tbclient.PbPage.AppealInfo;
import tbclient.PbPage.DataRes;
import tbclient.Post;
import tbclient.SimpleForum;
import tbclient.SimpleUser;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes2.dex */
public class d {
    private String fbQ;
    private int fbR;
    private a fbX;
    private List<bd> fbZ;
    private int fca;
    private AlaLiveInfoCoreData fcb;
    private TwzhiboAnti fcd;
    public AppealInfo fce;
    private List<az> fcf;
    private List<az> fcg;
    public String fci;
    private PostData fcj;
    private f fck;
    public CardHListViewData fcl;
    private long fcm;
    private j fcn;
    public String fco;
    public int fcp;
    public int fcq;
    private String fcr;
    private String fcs;
    private PostData fcu;
    private boolean fbW = true;
    private ArrayList<com.baidu.tieba.tbadkCore.data.l> fcc = new ArrayList<>();
    private ForumData fbL = new ForumData();
    private az fbM = new az();
    private bd bji = new bd();
    private ArrayList<PostData> fbN = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private am enx = new am();
    private AntiData YB = new AntiData();
    private com.baidu.tbadk.data.f fbO = new com.baidu.tbadk.data.f();
    private int fbP = 0;
    private final UserData fbS = new UserData();
    private List<MuteUser> fbV = new ArrayList();
    private ao fbT = new ao();
    private ap fbY = new ap();
    private ac fbU = new ac();
    private l fch = new l();
    private List<av.a> fct = new ArrayList();

    public boolean aVp() {
        return this.fbW;
    }

    public void jo(boolean z) {
        this.fbW = z;
    }

    public d() {
        this.fbR = 0;
        this.fcd = null;
        this.fbR = 0;
        this.fcd = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.fbN != null && this.fbN.size() > 0;
    }

    public String[] bM(Context context) {
        String str = null;
        String str2 = "";
        if (isValid()) {
            int size = this.fbN.size() > 30 ? 30 : this.fbN.size();
            if (aVs() == null || aVs().rQ() == null || an.isEmpty(aVs().rQ().getUserId())) {
                return new String[]{null, ""};
            }
            String userId = aVs().rQ().getUserId();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                PostData postData = (PostData) v.c(this.fbN, i);
                if (postData != null && postData.rQ() != null && !an.isEmpty(postData.rQ().getUserId()) && an.equals(userId, postData.rQ().getUserId())) {
                    if (an.isEmpty(str)) {
                        str = postData.bsg();
                    }
                    String bse = an.isEmpty(str2) ? postData.bse() : str2;
                    if (!an.isEmpty(str) && !an.isEmpty(bse)) {
                        str2 = bse;
                        break;
                    }
                    str2 = bse;
                }
                i++;
                str = str;
            }
            if (an.isEmpty(str)) {
                str = "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            }
            PostData postData2 = this.fbN.get(0);
            if (this.bji != null && this.bji.sz() != null && this.bji.sz().getGroup_id() != 0) {
                str2 = "[" + context.getString(d.k.photo_live_tips) + "] " + str2;
            }
            if (this.bji != null && this.bji.sB() && postData2 != null && postData2.JT() != null) {
                str = postData2.JT().getThumbUrl();
            }
        }
        return new String[]{str, str2};
    }

    public ForumData aVq() {
        return this.fbL;
    }

    public az aVr() {
        return this.fbM;
    }

    public String getForumId() {
        if (this.fbL == null) {
            return "";
        }
        return this.fbL.getId();
    }

    public bd aVs() {
        return this.bji;
    }

    public List<bd> aVt() {
        return this.fbZ;
    }

    public String getThreadId() {
        if (this.bji == null) {
            return "";
        }
        return this.bji.getId();
    }

    public ArrayList<PostData> aVu() {
        return this.fbN;
    }

    public am rg() {
        return this.enx;
    }

    public ac aVv() {
        return this.fbU;
    }

    public ap aVw() {
        return this.fbY;
    }

    public void a(am amVar, int i) {
        this.enx.bF(amVar.ra());
        this.enx.bD(amVar.qq());
        this.enx.bC(amVar.qX());
        this.enx.bG(amVar.rb());
        this.enx.bE(amVar.qZ());
        if (i == 0) {
            this.enx = amVar;
        } else if (i == 1) {
            this.enx.bH(amVar.rc());
        } else if (i == 2) {
            this.enx.bI(amVar.rd());
        }
    }

    public AntiData qT() {
        return this.YB;
    }

    public UserData getUserData() {
        return this.fbS;
    }

    public boolean oI() {
        return this.bji.rY() != 0;
    }

    public void ae(boolean z) {
        if (this.bji != null) {
            if (z) {
                this.bji.bR(1);
            } else {
                this.bji.bR(0);
            }
        }
    }

    public String oH() {
        if (this.bji != null) {
            return this.bji.rZ();
        }
        return null;
    }

    public void qp(String str) {
        if (this.bji != null) {
            this.bji.cQ(str);
        }
    }

    public String aVx() {
        return this.fcs;
    }

    public boolean aVy() {
        return (this.bji == null || this.bji.sb() == null || this.bji.sb().size() <= 0 || this.bji.sb().get(0) == null || !this.bji.sb().get(0).qr()) ? false : true;
    }

    public PostData aVz() {
        return this.fcu;
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                com.baidu.tieba.recapp.d.a.bjZ().sc(dataRes.asp_shown_info);
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
                pU(dataRes.is_new_url.intValue());
                this.fbL.parserProtobuf(dataRes.forum);
                this.fbM.parserProtobuf(dataRes.display_forum);
                this.bji.setUserMap(this.userMap);
                this.bji.a(dataRes.thread);
                this.bji.bU(2);
                this.fbT.a(dataRes.news_info);
                switch (this.fbT.YS) {
                    case 1:
                        this.fbU.fmg = this.fbT;
                        break;
                    case 2:
                        this.fbU.fmh = this.fbT;
                        break;
                    case 3:
                        this.fbU.fmi = this.fbT;
                        break;
                    default:
                        this.fbU.fmh = this.fbT;
                        break;
                }
                this.fbY.a(dataRes.recommend_book);
                List<Post> list2 = dataRes.post_list;
                if (list2 != null && list2.size() > 0) {
                    for (Post post : dataRes.post_list) {
                        PostData postData = new PostData();
                        postData.setUserMap(this.userMap);
                        postData.a(post, context);
                        postData.a(aVs().rF());
                        if (postData.brZ() == 1 && this.bji.st()) {
                            if (aVy()) {
                                postData.setPostType(0);
                            } else {
                                postData.setPostType(this.bji.ss());
                            }
                        } else if (postData.brZ() == 1 && this.bji.sF()) {
                            postData.setPostType(41);
                        } else if (postData.brZ() == 1 && this.bji != null && this.bji.sB()) {
                            postData.setPostType(0);
                            postData.JT();
                            if (this.bji.rO() == null || this.bji.rO().size() == 0) {
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
                                postData.c(new TbRichText((Context) TbadkCoreApplication.getInst(), this.bji.rO(), true));
                            }
                            this.fcj = postData;
                        }
                        if (postData.brZ() == 1 && this.bji != null && this.bji.isShareThread) {
                            postData.f(this.bji.abL);
                        }
                        this.fbN.add(postData);
                    }
                }
                if (dataRes.first_floor_post != null) {
                    this.fcu = new PostData();
                    this.fcu.setUserMap(this.userMap);
                    this.fcu.a(dataRes.first_floor_post, context);
                    if (this.bji != null && this.bji.isShareThread) {
                        this.fcu.f(this.bji.abL);
                    }
                }
                this.enx.a(dataRes.page);
                this.YB.parserProtobuf(dataRes.anti);
                this.fbO.a(dataRes.location);
                if (dataRes.user != null) {
                    this.fbP = dataRes.user.is_manager.intValue();
                }
                this.fbS.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.fbV.add(muteUser);
                        }
                    }
                }
                this.bji.bN(this.bji.rI() > 0 ? this.bji.rI() - 1 : 0);
                List<AppData> bjj = r.bjl().bjj();
                if (bjj != null) {
                    bjj.clear();
                }
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        com.baidu.tieba.tbadkCore.data.l lVar = new com.baidu.tieba.tbadkCore.data.l();
                        lVar.d(app);
                        AppData brP = lVar.brP();
                        if (!this.fcc.contains(lVar) && brP.goods != null && (!StringUtils.isNull(brP.goods.user_name) || !StringUtils.isNull(brP.goods.lego_card))) {
                            this.fcc.add(lVar);
                            if (bjj != null) {
                                bjj.add(lVar.brP());
                            }
                        }
                    }
                }
                r.bjl().bjk();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.fbS.getIsSelectTail());
                }
                this.fcd.parserProtobuf(dataRes.twzhibo_anti);
                this.fce = dataRes.appeal_info;
                if (dataRes.god_card != null) {
                    this.fbX = new a();
                    this.fbX.a(dataRes.god_card);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.fck = new f();
                    this.fck.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.guess_like != null) {
                    this.fcl = new CardHListViewData();
                    this.fcl.parseProtobuf(dataRes.guess_like);
                }
                if (dataRes.feed_thread_list != null && dataRes.feed_thread_list.size() > 0) {
                    List<ThreadInfo> list3 = dataRes.feed_thread_list;
                    if (this.fbZ == null) {
                        this.fbZ = new ArrayList();
                    }
                    this.fbZ.clear();
                    for (ThreadInfo threadInfo : list3) {
                        if (threadInfo != null) {
                            bd bdVar = new bd();
                            bdVar.a(threadInfo);
                            this.fbZ.add(bdVar);
                        }
                    }
                    if (this.fbZ != null && this.fbZ.size() > 15) {
                        this.fbZ = v.a(this.fbZ, 0, 15);
                    }
                }
                this.fca = dataRes.is_follow_current_channel.intValue();
                if (v.v(dataRes.repost_recommend_forum_list) > 0) {
                    if (this.fcf == null) {
                        this.fcf = new ArrayList();
                    }
                    for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                        az azVar = new az();
                        azVar.parserProtobuf(simpleForum);
                        this.fcf.add(azVar);
                    }
                }
                if (v.v(dataRes.from_forum_list) > 0) {
                    if (this.fcg == null) {
                        this.fcg = new ArrayList();
                    }
                    for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                        if (simpleForum2 != null) {
                            az azVar2 = new az();
                            azVar2.parserProtobuf(simpleForum2);
                            this.fcg.add(azVar2);
                        }
                    }
                }
                this.fcs = dataRes.multi_forum_text;
                if (dataRes.top_agree_post_list != null && this.fch != null) {
                    this.fch.a(context, dataRes.top_agree_post_list);
                }
                if (this.fcm >= 0) {
                    this.fcm = dataRes.thread_freq_num.longValue();
                }
                this.fcn = new j();
                this.fcn.a(dataRes);
                this.fco = dataRes.partial_visible_toast;
                if (dataRes.follow_tip != null && dataRes.follow_tip.is_toast_tip.intValue() == 1) {
                    this.fbQ = dataRes.follow_tip.tip_text;
                }
                this.fcb = new AlaLiveInfoCoreData();
                if (dataRes.ala_info != null) {
                    this.fcb.parserProtoBuf(dataRes.ala_info);
                }
                this.fcr = dataRes.fold_tip;
                this.fcp = dataRes.exp_news_today.intValue();
                this.fcq = dataRes.exp_guide_today.intValue();
                if (!v.w(dataRes.thread_topic)) {
                    for (int i2 = 0; i2 < dataRes.thread_topic.size(); i2++) {
                        av.a aVar = new av.a();
                        aVar.a(dataRes.thread_topic.get(i2));
                        this.fct.add(aVar);
                    }
                }
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }

    public String aVA() {
        return this.fcr;
    }

    public CardHListViewData aVB() {
        return this.fcl;
    }

    public PostData aVC() {
        return this.fcj;
    }

    public PostData c(PostData postData) {
        this.fcj = postData;
        return postData;
    }

    public l aVD() {
        return this.fch;
    }

    public int aVE() {
        return this.fbP;
    }

    public int aVF() {
        return this.fbR;
    }

    public void pU(int i) {
        this.fbR = i;
    }

    public List<MuteUser> aVG() {
        return this.fbV;
    }

    public ArrayList<com.baidu.tieba.tbadkCore.data.l> aVH() {
        return this.fcc;
    }

    public a aVI() {
        return this.fbX;
    }

    public String aVJ() {
        return this.fci;
    }

    public void qq(String str) {
        this.fci = str;
    }

    public f aVK() {
        return this.fck;
    }

    public int aVL() {
        return this.fca;
    }

    public List<az> aVM() {
        return this.fcg;
    }

    public long aVN() {
        return this.fcm;
    }

    public j aVO() {
        return this.fcn;
    }

    public void a(j jVar) {
        this.fcn = jVar;
    }

    public boolean aVP() {
        return (aVs() == null || !aVs().sB() || aVs().sh() == null) ? false : true;
    }

    public String aVQ() {
        return this.fbQ;
    }

    public AlaLiveInfoCoreData aVR() {
        return this.fcb;
    }

    public List<av.a> aVS() {
        return this.fct;
    }
}

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
    private String fbT;
    private int fbU;
    private a fca;
    private List<bd> fcc;
    private int fcd;
    private AlaLiveInfoCoreData fce;
    private TwzhiboAnti fcg;
    public AppealInfo fch;
    private List<az> fci;
    private List<az> fcj;
    public String fcl;
    private PostData fcm;
    private f fcn;
    public CardHListViewData fco;
    private long fcp;
    private j fcq;
    public String fcr;
    public int fcs;
    public int fct;
    private String fcu;
    private String fcv;
    private PostData fcx;
    private boolean fbZ = true;
    private ArrayList<com.baidu.tieba.tbadkCore.data.l> fcf = new ArrayList<>();
    private ForumData fbO = new ForumData();
    private az fbP = new az();
    private bd bji = new bd();
    private ArrayList<PostData> fbQ = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private am enA = new am();
    private AntiData YB = new AntiData();
    private com.baidu.tbadk.data.f fbR = new com.baidu.tbadk.data.f();
    private int fbS = 0;
    private final UserData fbV = new UserData();
    private List<MuteUser> fbY = new ArrayList();
    private ao fbW = new ao();
    private ap fcb = new ap();
    private ac fbX = new ac();
    private l fck = new l();
    private List<av.a> fcw = new ArrayList();

    public boolean aVp() {
        return this.fbZ;
    }

    public void jo(boolean z) {
        this.fbZ = z;
    }

    public d() {
        this.fbU = 0;
        this.fcg = null;
        this.fbU = 0;
        this.fcg = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.fbQ != null && this.fbQ.size() > 0;
    }

    public String[] bM(Context context) {
        String str = null;
        String str2 = "";
        if (isValid()) {
            int size = this.fbQ.size() > 30 ? 30 : this.fbQ.size();
            if (aVs() == null || aVs().rQ() == null || an.isEmpty(aVs().rQ().getUserId())) {
                return new String[]{null, ""};
            }
            String userId = aVs().rQ().getUserId();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                PostData postData = (PostData) v.c(this.fbQ, i);
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
            PostData postData2 = this.fbQ.get(0);
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
        return this.fbO;
    }

    public az aVr() {
        return this.fbP;
    }

    public String getForumId() {
        if (this.fbO == null) {
            return "";
        }
        return this.fbO.getId();
    }

    public bd aVs() {
        return this.bji;
    }

    public List<bd> aVt() {
        return this.fcc;
    }

    public String getThreadId() {
        if (this.bji == null) {
            return "";
        }
        return this.bji.getId();
    }

    public ArrayList<PostData> aVu() {
        return this.fbQ;
    }

    public am rg() {
        return this.enA;
    }

    public ac aVv() {
        return this.fbX;
    }

    public ap aVw() {
        return this.fcb;
    }

    public void a(am amVar, int i) {
        this.enA.bG(amVar.ra());
        this.enA.bE(amVar.qq());
        this.enA.bD(amVar.qX());
        this.enA.bH(amVar.rb());
        this.enA.bF(amVar.qZ());
        if (i == 0) {
            this.enA = amVar;
        } else if (i == 1) {
            this.enA.bI(amVar.rc());
        } else if (i == 2) {
            this.enA.bJ(amVar.rd());
        }
    }

    public AntiData qT() {
        return this.YB;
    }

    public UserData getUserData() {
        return this.fbV;
    }

    public boolean oI() {
        return this.bji.rY() != 0;
    }

    public void ae(boolean z) {
        if (this.bji != null) {
            if (z) {
                this.bji.bS(1);
            } else {
                this.bji.bS(0);
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
        return this.fcv;
    }

    public boolean aVy() {
        return (this.bji == null || this.bji.sb() == null || this.bji.sb().size() <= 0 || this.bji.sb().get(0) == null || !this.bji.sb().get(0).qr()) ? false : true;
    }

    public PostData aVz() {
        return this.fcx;
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
                pV(dataRes.is_new_url.intValue());
                this.fbO.parserProtobuf(dataRes.forum);
                this.fbP.parserProtobuf(dataRes.display_forum);
                this.bji.setUserMap(this.userMap);
                this.bji.a(dataRes.thread);
                this.bji.bV(2);
                this.fbW.a(dataRes.news_info);
                switch (this.fbW.YS) {
                    case 1:
                        this.fbX.fmj = this.fbW;
                        break;
                    case 2:
                        this.fbX.fmk = this.fbW;
                        break;
                    case 3:
                        this.fbX.fml = this.fbW;
                        break;
                    default:
                        this.fbX.fmk = this.fbW;
                        break;
                }
                this.fcb.a(dataRes.recommend_book);
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
                            this.fcm = postData;
                        }
                        if (postData.brZ() == 1 && this.bji != null && this.bji.isShareThread) {
                            postData.f(this.bji.abL);
                        }
                        this.fbQ.add(postData);
                    }
                }
                if (dataRes.first_floor_post != null) {
                    this.fcx = new PostData();
                    this.fcx.setUserMap(this.userMap);
                    this.fcx.a(dataRes.first_floor_post, context);
                    if (this.bji != null && this.bji.isShareThread) {
                        this.fcx.f(this.bji.abL);
                    }
                }
                this.enA.a(dataRes.page);
                this.YB.parserProtobuf(dataRes.anti);
                this.fbR.a(dataRes.location);
                if (dataRes.user != null) {
                    this.fbS = dataRes.user.is_manager.intValue();
                }
                this.fbV.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.fbY.add(muteUser);
                        }
                    }
                }
                this.bji.bO(this.bji.rI() > 0 ? this.bji.rI() - 1 : 0);
                List<AppData> bjj = r.bjl().bjj();
                if (bjj != null) {
                    bjj.clear();
                }
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        com.baidu.tieba.tbadkCore.data.l lVar = new com.baidu.tieba.tbadkCore.data.l();
                        lVar.d(app);
                        AppData brP = lVar.brP();
                        if (!this.fcf.contains(lVar) && brP.goods != null && (!StringUtils.isNull(brP.goods.user_name) || !StringUtils.isNull(brP.goods.lego_card))) {
                            this.fcf.add(lVar);
                            if (bjj != null) {
                                bjj.add(lVar.brP());
                            }
                        }
                    }
                }
                r.bjl().bjk();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.fbV.getIsSelectTail());
                }
                this.fcg.parserProtobuf(dataRes.twzhibo_anti);
                this.fch = dataRes.appeal_info;
                if (dataRes.god_card != null) {
                    this.fca = new a();
                    this.fca.a(dataRes.god_card);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.fcn = new f();
                    this.fcn.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.guess_like != null) {
                    this.fco = new CardHListViewData();
                    this.fco.parseProtobuf(dataRes.guess_like);
                }
                if (dataRes.feed_thread_list != null && dataRes.feed_thread_list.size() > 0) {
                    List<ThreadInfo> list3 = dataRes.feed_thread_list;
                    if (this.fcc == null) {
                        this.fcc = new ArrayList();
                    }
                    this.fcc.clear();
                    for (ThreadInfo threadInfo : list3) {
                        if (threadInfo != null) {
                            bd bdVar = new bd();
                            bdVar.a(threadInfo);
                            this.fcc.add(bdVar);
                        }
                    }
                    if (this.fcc != null && this.fcc.size() > 15) {
                        this.fcc = v.a(this.fcc, 0, 15);
                    }
                }
                this.fcd = dataRes.is_follow_current_channel.intValue();
                if (v.v(dataRes.repost_recommend_forum_list) > 0) {
                    if (this.fci == null) {
                        this.fci = new ArrayList();
                    }
                    for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                        az azVar = new az();
                        azVar.parserProtobuf(simpleForum);
                        this.fci.add(azVar);
                    }
                }
                if (v.v(dataRes.from_forum_list) > 0) {
                    if (this.fcj == null) {
                        this.fcj = new ArrayList();
                    }
                    for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                        if (simpleForum2 != null) {
                            az azVar2 = new az();
                            azVar2.parserProtobuf(simpleForum2);
                            this.fcj.add(azVar2);
                        }
                    }
                }
                this.fcv = dataRes.multi_forum_text;
                if (dataRes.top_agree_post_list != null && this.fck != null) {
                    this.fck.a(context, dataRes.top_agree_post_list);
                }
                if (this.fcp >= 0) {
                    this.fcp = dataRes.thread_freq_num.longValue();
                }
                this.fcq = new j();
                this.fcq.a(dataRes);
                this.fcr = dataRes.partial_visible_toast;
                if (dataRes.follow_tip != null && dataRes.follow_tip.is_toast_tip.intValue() == 1) {
                    this.fbT = dataRes.follow_tip.tip_text;
                }
                this.fce = new AlaLiveInfoCoreData();
                if (dataRes.ala_info != null) {
                    this.fce.parserProtoBuf(dataRes.ala_info);
                }
                this.fcu = dataRes.fold_tip;
                this.fcs = dataRes.exp_news_today.intValue();
                this.fct = dataRes.exp_guide_today.intValue();
                if (!v.w(dataRes.thread_topic)) {
                    for (int i2 = 0; i2 < dataRes.thread_topic.size(); i2++) {
                        av.a aVar = new av.a();
                        aVar.a(dataRes.thread_topic.get(i2));
                        this.fcw.add(aVar);
                    }
                }
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }

    public String aVA() {
        return this.fcu;
    }

    public CardHListViewData aVB() {
        return this.fco;
    }

    public PostData aVC() {
        return this.fcm;
    }

    public PostData c(PostData postData) {
        this.fcm = postData;
        return postData;
    }

    public l aVD() {
        return this.fck;
    }

    public int aVE() {
        return this.fbS;
    }

    public int aVF() {
        return this.fbU;
    }

    public void pV(int i) {
        this.fbU = i;
    }

    public List<MuteUser> aVG() {
        return this.fbY;
    }

    public ArrayList<com.baidu.tieba.tbadkCore.data.l> aVH() {
        return this.fcf;
    }

    public a aVI() {
        return this.fca;
    }

    public String aVJ() {
        return this.fcl;
    }

    public void qq(String str) {
        this.fcl = str;
    }

    public f aVK() {
        return this.fcn;
    }

    public int aVL() {
        return this.fcd;
    }

    public List<az> aVM() {
        return this.fcj;
    }

    public long aVN() {
        return this.fcp;
    }

    public j aVO() {
        return this.fcq;
    }

    public void a(j jVar) {
        this.fcq = jVar;
    }

    public boolean aVP() {
        return (aVs() == null || !aVs().sB() || aVs().sh() == null) ? false : true;
    }

    public String aVQ() {
        return this.fbT;
    }

    public AlaLiveInfoCoreData aVR() {
        return this.fce;
    }

    public List<av.a> aVS() {
        return this.fcw;
    }
}

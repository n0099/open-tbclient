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
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.ad;
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
    private TwzhiboAnti fsA;
    public AppealInfo fsB;
    private List<az> fsC;
    private List<az> fsD;
    public String fsF;
    private PostData fsG;
    private f fsH;
    public CardHListViewData fsI;
    private long fsJ;
    private j fsK;
    public String fsL;
    public int fsM;
    public int fsN;
    private String fsO;
    private String fsP;
    private PostData fsR;
    private String fsm;
    private int fsn;
    private a fst;
    private List<bc> fsv;
    private int fsw;
    private AlaLiveInfoCoreData fsx;
    private boolean fss = true;
    private ArrayList<com.baidu.tieba.tbadkCore.data.l> fsy = new ArrayList<>();
    private com.baidu.tieba.tbadkCore.data.l fsz = null;
    private ForumData fsh = new ForumData();
    private az fsi = new az();
    private bc btc = new bc();
    private ArrayList<PostData> fsj = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private am eDN = new am();
    private AntiData agS = new AntiData();
    private com.baidu.tbadk.data.f fsk = new com.baidu.tbadk.data.f();
    private int fsl = 0;
    private final UserData fso = new UserData();
    private List<MuteUser> fsr = new ArrayList();
    private ao fsp = new ao();
    private ap fsu = new ap();
    private ad fsq = new ad();
    private l fsE = new l();
    private List<av.a> fsQ = new ArrayList();

    public boolean baS() {
        return this.fss;
    }

    public void jE(boolean z) {
        this.fss = z;
    }

    public d() {
        this.fsn = 0;
        this.fsA = null;
        this.fsn = 0;
        this.fsA = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.fsj != null && this.fsj.size() > 0;
    }

    public String[] bW(Context context) {
        String str = null;
        String str2 = "";
        if (isValid()) {
            int size = this.fsj.size() > 30 ? 30 : this.fsj.size();
            if (baV() == null || baV().vw() == null || com.baidu.tbadk.core.util.ap.isEmpty(baV().vw().getUserId())) {
                return new String[]{null, ""};
            }
            String userId = baV().vw().getUserId();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                PostData postData = (PostData) w.d(this.fsj, i);
                if (postData != null && postData.vw() != null && !com.baidu.tbadk.core.util.ap.isEmpty(postData.vw().getUserId()) && com.baidu.tbadk.core.util.ap.equals(userId, postData.vw().getUserId())) {
                    if (com.baidu.tbadk.core.util.ap.isEmpty(str)) {
                        str = postData.bxJ();
                    }
                    String bxH = com.baidu.tbadk.core.util.ap.isEmpty(str2) ? postData.bxH() : str2;
                    if (!com.baidu.tbadk.core.util.ap.isEmpty(str) && !com.baidu.tbadk.core.util.ap.isEmpty(bxH)) {
                        str2 = bxH;
                        break;
                    }
                    str2 = bxH;
                }
                i++;
                str = str;
            }
            if (com.baidu.tbadk.core.util.ap.isEmpty(str)) {
                str = "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            }
            PostData postData2 = this.fsj.get(0);
            if (this.btc != null && this.btc.wf() != null && this.btc.wf().getGroup_id() != 0) {
                str2 = "[" + context.getString(d.k.photo_live_tips) + "] " + str2;
            }
            if (this.btc != null && this.btc.wh() && postData2 != null && postData2.NJ() != null) {
                str = postData2.NJ().getThumbUrl();
            }
        }
        return new String[]{str, str2};
    }

    public ForumData baT() {
        return this.fsh;
    }

    public az baU() {
        return this.fsi;
    }

    public String getForumId() {
        if (this.fsh == null) {
            return "";
        }
        return this.fsh.getId();
    }

    public bc baV() {
        return this.btc;
    }

    public List<bc> baW() {
        return this.fsv;
    }

    public String getThreadId() {
        if (this.btc == null) {
            return "";
        }
        return this.btc.getId();
    }

    public ArrayList<PostData> baX() {
        return this.fsj;
    }

    public am uJ() {
        return this.eDN;
    }

    public ad baY() {
        return this.fsq;
    }

    public ap baZ() {
        return this.fsu;
    }

    public void a(am amVar, int i) {
        this.eDN.bJ(amVar.uD());
        this.eDN.bH(amVar.tR());
        this.eDN.bG(amVar.uA());
        this.eDN.bK(amVar.uE());
        this.eDN.bI(amVar.uC());
        if (i == 0) {
            this.eDN = amVar;
        } else if (i == 1) {
            this.eDN.bL(amVar.uF());
        } else if (i == 2) {
            this.eDN.bM(amVar.uG());
        }
    }

    public AntiData uu() {
        return this.agS;
    }

    public UserData getUserData() {
        return this.fso;
    }

    public boolean sc() {
        return this.btc.vE() != 0;
    }

    public void ah(boolean z) {
        if (this.btc != null) {
            if (z) {
                this.btc.bV(1);
            } else {
                this.btc.bV(0);
            }
        }
    }

    public String sb() {
        if (this.btc != null) {
            return this.btc.vF();
        }
        return null;
    }

    public void rf(String str) {
        if (this.btc != null) {
            this.btc.ds(str);
        }
    }

    public String bba() {
        return this.fsP;
    }

    public boolean bbb() {
        return (this.btc == null || this.btc.vH() == null || this.btc.vH().size() <= 0 || this.btc.vH().get(0) == null || !this.btc.vH().get(0).tS()) ? false : true;
    }

    public PostData bbc() {
        return this.fsR;
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                com.baidu.tieba.recapp.d.a.bpy().sW(dataRes.asp_shown_info);
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
                qm(dataRes.is_new_url.intValue());
                this.fsh.parserProtobuf(dataRes.forum);
                this.fsi.parserProtobuf(dataRes.display_forum);
                this.btc.setUserMap(this.userMap);
                this.btc.a(dataRes.thread);
                this.btc.bY(2);
                this.fsp.a(dataRes.news_info);
                switch (this.fsp.ahm) {
                    case 1:
                        this.fsq.fCI = this.fsp;
                        break;
                    case 2:
                        this.fsq.fCJ = this.fsp;
                        break;
                    case 3:
                        this.fsq.fCK = this.fsp;
                        break;
                    default:
                        this.fsq.fCJ = this.fsp;
                        break;
                }
                this.fsu.a(dataRes.recommend_book);
                List<Post> list2 = dataRes.post_list;
                if (list2 != null && list2.size() > 0) {
                    for (Post post : dataRes.post_list) {
                        PostData postData = new PostData();
                        postData.setUserMap(this.userMap);
                        postData.jG(this.fsh.isBrandForum);
                        postData.a(post, context);
                        postData.a(baV().vj());
                        if (postData.bxC() == 1 && this.btc.vZ()) {
                            if (bbb()) {
                                postData.setPostType(0);
                            } else {
                                postData.setPostType(this.btc.vY());
                            }
                        } else if (postData.bxC() == 1 && this.btc.wl()) {
                            postData.setPostType(41);
                        } else if (postData.bxC() == 1 && this.btc != null && this.btc.wh()) {
                            postData.setPostType(0);
                            postData.NJ();
                            if (this.btc.vu() == null || this.btc.vu().size() == 0) {
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
                                postData.c(new TbRichText((Context) TbadkCoreApplication.getInst(), this.btc.vu(), true));
                            }
                            this.fsG = postData;
                        }
                        if (postData.bxC() == 1 && this.btc != null && this.btc.isShareThread) {
                            postData.g(this.btc.akk);
                        }
                        this.fsj.add(postData);
                    }
                }
                if (dataRes.first_floor_post != null) {
                    this.fsR = new PostData();
                    this.fsR.setUserMap(this.userMap);
                    this.fsR.jG(this.fsh.isBrandForum);
                    this.fsR.a(dataRes.first_floor_post, context);
                    if (this.btc != null && this.btc.isShareThread) {
                        this.fsR.g(this.btc.akk);
                    }
                }
                this.eDN.a(dataRes.page);
                this.agS.parserProtobuf(dataRes.anti);
                this.fsk.a(dataRes.location);
                if (dataRes.user != null) {
                    this.fsl = dataRes.user.is_manager.intValue();
                }
                this.fso.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.fsr.add(muteUser);
                        }
                    }
                }
                this.btc.bR(this.btc.vn() > 0 ? this.btc.vn() - 1 : 0);
                List<AppData> boH = r.boJ().boH();
                if (boH != null) {
                    boH.clear();
                }
                this.fsz = null;
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        com.baidu.tieba.tbadkCore.data.l lVar = new com.baidu.tieba.tbadkCore.data.l();
                        lVar.d(app);
                        AppData bxq = lVar.bxq();
                        if (!this.fsy.contains(lVar) && bxq.goods != null && (!StringUtils.isNull(bxq.goods.user_name) || !StringUtils.isNull(bxq.goods.lego_card))) {
                            this.fsy.add(lVar);
                            if (boH != null) {
                                boH.add(lVar.bxq());
                            }
                        }
                    }
                    a(dataRes);
                }
                r.boJ().boI();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.fso.getIsSelectTail());
                }
                this.fsA.parserProtobuf(dataRes.twzhibo_anti);
                this.fsB = dataRes.appeal_info;
                if (dataRes.god_card != null) {
                    this.fst = new a();
                    this.fst.a(dataRes.god_card);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.fsH = new f();
                    this.fsH.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.guess_like != null) {
                    this.fsI = new CardHListViewData();
                    this.fsI.parseProtobuf(dataRes.guess_like);
                }
                if (dataRes.feed_thread_list != null && dataRes.feed_thread_list.size() > 0) {
                    List<ThreadInfo> list3 = dataRes.feed_thread_list;
                    if (this.fsv == null) {
                        this.fsv = new ArrayList();
                    }
                    this.fsv.clear();
                    for (ThreadInfo threadInfo : list3) {
                        if (threadInfo != null) {
                            bc bcVar = new bc();
                            bcVar.a(threadInfo);
                            this.fsv.add(bcVar);
                        }
                    }
                    if (this.fsv != null && this.fsv.size() > 15) {
                        this.fsv = w.a(this.fsv, 0, 15);
                    }
                }
                this.fsw = dataRes.is_follow_current_channel.intValue();
                if (w.z(dataRes.repost_recommend_forum_list) > 0) {
                    if (this.fsC == null) {
                        this.fsC = new ArrayList();
                    }
                    for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                        az azVar = new az();
                        azVar.parserProtobuf(simpleForum);
                        this.fsC.add(azVar);
                    }
                }
                if (w.z(dataRes.from_forum_list) > 0) {
                    if (this.fsD == null) {
                        this.fsD = new ArrayList();
                    }
                    for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                        if (simpleForum2 != null) {
                            az azVar2 = new az();
                            azVar2.parserProtobuf(simpleForum2);
                            this.fsD.add(azVar2);
                        }
                    }
                }
                this.fsP = dataRes.multi_forum_text;
                if (dataRes.top_agree_post_list != null && this.fsE != null) {
                    this.fsE.jG(this.fsh.isBrandForum);
                    this.fsE.a(context, dataRes.top_agree_post_list);
                }
                if (this.fsJ >= 0) {
                    this.fsJ = dataRes.thread_freq_num.longValue();
                }
                this.fsK = new j();
                this.fsK.b(dataRes);
                this.fsL = dataRes.partial_visible_toast;
                if (dataRes.follow_tip != null && dataRes.follow_tip.is_toast_tip.intValue() == 1) {
                    this.fsm = dataRes.follow_tip.tip_text;
                }
                this.fsx = new AlaLiveInfoCoreData();
                if (dataRes.ala_info != null) {
                    this.fsx.parserProtoBuf(dataRes.ala_info);
                }
                this.fsO = dataRes.fold_tip;
                this.fsM = dataRes.exp_news_today.intValue();
                this.fsN = dataRes.exp_guide_today.intValue();
                if (!w.A(dataRes.thread_topic)) {
                    for (int i2 = 0; i2 < dataRes.thread_topic.size(); i2++) {
                        av.a aVar = new av.a();
                        aVar.a(dataRes.thread_topic.get(i2));
                        this.fsQ.add(aVar);
                    }
                }
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }

    private void a(DataRes dataRes) {
        App app = dataRes.banner_list.pb_banner_ad;
        com.baidu.tieba.tbadkCore.data.l lVar = new com.baidu.tieba.tbadkCore.data.l();
        lVar.gMT = true;
        lVar.d(app);
        if (lVar.bxq().goods != null) {
            this.fsz = lVar;
        }
    }

    public String bbd() {
        return this.fsO;
    }

    public CardHListViewData bbe() {
        return this.fsI;
    }

    public PostData bbf() {
        return this.fsG;
    }

    public PostData c(PostData postData) {
        this.fsG = postData;
        return postData;
    }

    public l bbg() {
        return this.fsE;
    }

    public int bbh() {
        return this.fsl;
    }

    public int bbi() {
        return this.fsn;
    }

    public void qm(int i) {
        this.fsn = i;
    }

    public List<MuteUser> bbj() {
        return this.fsr;
    }

    public ArrayList<com.baidu.tieba.tbadkCore.data.l> bbk() {
        return this.fsy;
    }

    public com.baidu.tieba.tbadkCore.data.l bbl() {
        return this.fsz;
    }

    public a bbm() {
        return this.fst;
    }

    public String bbn() {
        return this.fsF;
    }

    public void rg(String str) {
        this.fsF = str;
    }

    public f bbo() {
        return this.fsH;
    }

    public int bbp() {
        return this.fsw;
    }

    public List<az> bbq() {
        return this.fsD;
    }

    public long bbr() {
        return this.fsJ;
    }

    public j bbs() {
        return this.fsK;
    }

    public void a(j jVar) {
        this.fsK = jVar;
    }

    public boolean bbt() {
        return (baV() == null || !baV().wh() || baV().vN() == null) ? false : true;
    }

    public String bbu() {
        return this.fsm;
    }

    public AlaLiveInfoCoreData bbv() {
        return this.fsx;
    }

    public List<av.a> bbw() {
        return this.fsQ;
    }
}

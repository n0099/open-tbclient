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
    private String fcX;
    private int fcY;
    private PostData fdB;
    private a fde;
    private List<bd> fdg;
    private int fdh;
    private AlaLiveInfoCoreData fdi;
    private TwzhiboAnti fdk;
    public AppealInfo fdl;
    private List<az> fdm;
    private List<az> fdn;
    public String fdp;
    private PostData fdq;
    private f fdr;
    public CardHListViewData fds;
    private long fdt;
    private j fdu;
    public String fdv;
    public int fdw;
    public int fdx;
    private String fdy;
    private String fdz;
    private boolean fdd = true;
    private ArrayList<com.baidu.tieba.tbadkCore.data.l> fdj = new ArrayList<>();
    private ForumData fcS = new ForumData();
    private az fcT = new az();
    private bd bjy = new bd();
    private ArrayList<PostData> fcU = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private am eoG = new am();
    private AntiData YB = new AntiData();
    private com.baidu.tbadk.data.f fcV = new com.baidu.tbadk.data.f();
    private int fcW = 0;
    private final UserData fcZ = new UserData();
    private List<MuteUser> fdc = new ArrayList();
    private ao fda = new ao();
    private ap fdf = new ap();
    private ac fdb = new ac();
    private l fdo = new l();
    private List<av.a> fdA = new ArrayList();

    public boolean aVp() {
        return this.fdd;
    }

    public void jp(boolean z) {
        this.fdd = z;
    }

    public d() {
        this.fcY = 0;
        this.fdk = null;
        this.fcY = 0;
        this.fdk = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.fcU != null && this.fcU.size() > 0;
    }

    public String[] bM(Context context) {
        String str = null;
        String str2 = "";
        if (isValid()) {
            int size = this.fcU.size() > 30 ? 30 : this.fcU.size();
            if (aVs() == null || aVs().rP() == null || an.isEmpty(aVs().rP().getUserId())) {
                return new String[]{null, ""};
            }
            String userId = aVs().rP().getUserId();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                PostData postData = (PostData) v.c(this.fcU, i);
                if (postData != null && postData.rP() != null && !an.isEmpty(postData.rP().getUserId()) && an.equals(userId, postData.rP().getUserId())) {
                    if (an.isEmpty(str)) {
                        str = postData.bse();
                    }
                    String bsc = an.isEmpty(str2) ? postData.bsc() : str2;
                    if (!an.isEmpty(str) && !an.isEmpty(bsc)) {
                        str2 = bsc;
                        break;
                    }
                    str2 = bsc;
                }
                i++;
                str = str;
            }
            if (an.isEmpty(str)) {
                str = "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            }
            PostData postData2 = this.fcU.get(0);
            if (this.bjy != null && this.bjy.sy() != null && this.bjy.sy().getGroup_id() != 0) {
                str2 = "[" + context.getString(d.k.photo_live_tips) + "] " + str2;
            }
            if (this.bjy != null && this.bjy.sA() && postData2 != null && postData2.JR() != null) {
                str = postData2.JR().getThumbUrl();
            }
        }
        return new String[]{str, str2};
    }

    public ForumData aVq() {
        return this.fcS;
    }

    public az aVr() {
        return this.fcT;
    }

    public String getForumId() {
        if (this.fcS == null) {
            return "";
        }
        return this.fcS.getId();
    }

    public bd aVs() {
        return this.bjy;
    }

    public List<bd> aVt() {
        return this.fdg;
    }

    public String getThreadId() {
        if (this.bjy == null) {
            return "";
        }
        return this.bjy.getId();
    }

    public ArrayList<PostData> aVu() {
        return this.fcU;
    }

    public am rf() {
        return this.eoG;
    }

    public ac aVv() {
        return this.fdb;
    }

    public ap aVw() {
        return this.fdf;
    }

    public void a(am amVar, int i) {
        this.eoG.bG(amVar.qZ());
        this.eoG.bE(amVar.qp());
        this.eoG.bD(amVar.qW());
        this.eoG.bH(amVar.ra());
        this.eoG.bF(amVar.qY());
        if (i == 0) {
            this.eoG = amVar;
        } else if (i == 1) {
            this.eoG.bI(amVar.rb());
        } else if (i == 2) {
            this.eoG.bJ(amVar.rc());
        }
    }

    public AntiData qS() {
        return this.YB;
    }

    public UserData getUserData() {
        return this.fcZ;
    }

    public boolean oH() {
        return this.bjy.rX() != 0;
    }

    public void ae(boolean z) {
        if (this.bjy != null) {
            if (z) {
                this.bjy.bS(1);
            } else {
                this.bjy.bS(0);
            }
        }
    }

    public String oG() {
        if (this.bjy != null) {
            return this.bjy.rY();
        }
        return null;
    }

    public void qs(String str) {
        if (this.bjy != null) {
            this.bjy.cQ(str);
        }
    }

    public String aVx() {
        return this.fdz;
    }

    public boolean aVy() {
        return (this.bjy == null || this.bjy.sa() == null || this.bjy.sa().size() <= 0 || this.bjy.sa().get(0) == null || !this.bjy.sa().get(0).qq()) ? false : true;
    }

    public PostData aVz() {
        return this.fdB;
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                com.baidu.tieba.recapp.d.a.bjY().sf(dataRes.asp_shown_info);
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
                pT(dataRes.is_new_url.intValue());
                this.fcS.parserProtobuf(dataRes.forum);
                this.fcT.parserProtobuf(dataRes.display_forum);
                this.bjy.setUserMap(this.userMap);
                this.bjy.a(dataRes.thread);
                this.bjy.bV(2);
                this.fda.a(dataRes.news_info);
                switch (this.fda.YS) {
                    case 1:
                        this.fdb.fnn = this.fda;
                        break;
                    case 2:
                        this.fdb.fno = this.fda;
                        break;
                    case 3:
                        this.fdb.fnp = this.fda;
                        break;
                    default:
                        this.fdb.fno = this.fda;
                        break;
                }
                this.fdf.a(dataRes.recommend_book);
                List<Post> list2 = dataRes.post_list;
                if (list2 != null && list2.size() > 0) {
                    for (Post post : dataRes.post_list) {
                        PostData postData = new PostData();
                        postData.setUserMap(this.userMap);
                        postData.a(post, context);
                        postData.a(aVs().rE());
                        if (postData.brX() == 1 && this.bjy.ss()) {
                            if (aVy()) {
                                postData.setPostType(0);
                            } else {
                                postData.setPostType(this.bjy.sr());
                            }
                        } else if (postData.brX() == 1 && this.bjy.sE()) {
                            postData.setPostType(41);
                        } else if (postData.brX() == 1 && this.bjy != null && this.bjy.sA()) {
                            postData.setPostType(0);
                            postData.JR();
                            if (this.bjy.rN() == null || this.bjy.rN().size() == 0) {
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
                                postData.c(new TbRichText((Context) TbadkCoreApplication.getInst(), this.bjy.rN(), true));
                            }
                            this.fdq = postData;
                        }
                        if (postData.brX() == 1 && this.bjy != null && this.bjy.isShareThread) {
                            postData.f(this.bjy.abM);
                        }
                        this.fcU.add(postData);
                    }
                }
                if (dataRes.first_floor_post != null) {
                    this.fdB = new PostData();
                    this.fdB.setUserMap(this.userMap);
                    this.fdB.a(dataRes.first_floor_post, context);
                    if (this.bjy != null && this.bjy.isShareThread) {
                        this.fdB.f(this.bjy.abM);
                    }
                }
                this.eoG.a(dataRes.page);
                this.YB.parserProtobuf(dataRes.anti);
                this.fcV.a(dataRes.location);
                if (dataRes.user != null) {
                    this.fcW = dataRes.user.is_manager.intValue();
                }
                this.fcZ.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.fdc.add(muteUser);
                        }
                    }
                }
                this.bjy.bO(this.bjy.rH() > 0 ? this.bjy.rH() - 1 : 0);
                List<AppData> bji = r.bjk().bji();
                if (bji != null) {
                    bji.clear();
                }
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        com.baidu.tieba.tbadkCore.data.l lVar = new com.baidu.tieba.tbadkCore.data.l();
                        lVar.d(app);
                        AppData brN = lVar.brN();
                        if (!this.fdj.contains(lVar) && brN.goods != null && (!StringUtils.isNull(brN.goods.user_name) || !StringUtils.isNull(brN.goods.lego_card))) {
                            this.fdj.add(lVar);
                            if (bji != null) {
                                bji.add(lVar.brN());
                            }
                        }
                    }
                }
                r.bjk().bjj();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.fcZ.getIsSelectTail());
                }
                this.fdk.parserProtobuf(dataRes.twzhibo_anti);
                this.fdl = dataRes.appeal_info;
                if (dataRes.god_card != null) {
                    this.fde = new a();
                    this.fde.a(dataRes.god_card);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.fdr = new f();
                    this.fdr.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.guess_like != null) {
                    this.fds = new CardHListViewData();
                    this.fds.parseProtobuf(dataRes.guess_like);
                }
                if (dataRes.feed_thread_list != null && dataRes.feed_thread_list.size() > 0) {
                    List<ThreadInfo> list3 = dataRes.feed_thread_list;
                    if (this.fdg == null) {
                        this.fdg = new ArrayList();
                    }
                    this.fdg.clear();
                    for (ThreadInfo threadInfo : list3) {
                        if (threadInfo != null) {
                            bd bdVar = new bd();
                            bdVar.a(threadInfo);
                            this.fdg.add(bdVar);
                        }
                    }
                    if (this.fdg != null && this.fdg.size() > 15) {
                        this.fdg = v.a(this.fdg, 0, 15);
                    }
                }
                this.fdh = dataRes.is_follow_current_channel.intValue();
                if (v.v(dataRes.repost_recommend_forum_list) > 0) {
                    if (this.fdm == null) {
                        this.fdm = new ArrayList();
                    }
                    for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                        az azVar = new az();
                        azVar.parserProtobuf(simpleForum);
                        this.fdm.add(azVar);
                    }
                }
                if (v.v(dataRes.from_forum_list) > 0) {
                    if (this.fdn == null) {
                        this.fdn = new ArrayList();
                    }
                    for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                        if (simpleForum2 != null) {
                            az azVar2 = new az();
                            azVar2.parserProtobuf(simpleForum2);
                            this.fdn.add(azVar2);
                        }
                    }
                }
                this.fdz = dataRes.multi_forum_text;
                if (dataRes.top_agree_post_list != null && this.fdo != null) {
                    this.fdo.a(context, dataRes.top_agree_post_list);
                }
                if (this.fdt >= 0) {
                    this.fdt = dataRes.thread_freq_num.longValue();
                }
                this.fdu = new j();
                this.fdu.a(dataRes);
                this.fdv = dataRes.partial_visible_toast;
                if (dataRes.follow_tip != null && dataRes.follow_tip.is_toast_tip.intValue() == 1) {
                    this.fcX = dataRes.follow_tip.tip_text;
                }
                this.fdi = new AlaLiveInfoCoreData();
                if (dataRes.ala_info != null) {
                    this.fdi.parserProtoBuf(dataRes.ala_info);
                }
                this.fdy = dataRes.fold_tip;
                this.fdw = dataRes.exp_news_today.intValue();
                this.fdx = dataRes.exp_guide_today.intValue();
                if (!v.w(dataRes.thread_topic)) {
                    for (int i2 = 0; i2 < dataRes.thread_topic.size(); i2++) {
                        av.a aVar = new av.a();
                        aVar.a(dataRes.thread_topic.get(i2));
                        this.fdA.add(aVar);
                    }
                }
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }

    public String aVA() {
        return this.fdy;
    }

    public CardHListViewData aVB() {
        return this.fds;
    }

    public PostData aVC() {
        return this.fdq;
    }

    public PostData c(PostData postData) {
        this.fdq = postData;
        return postData;
    }

    public l aVD() {
        return this.fdo;
    }

    public int aVE() {
        return this.fcW;
    }

    public int aVF() {
        return this.fcY;
    }

    public void pT(int i) {
        this.fcY = i;
    }

    public List<MuteUser> aVG() {
        return this.fdc;
    }

    public ArrayList<com.baidu.tieba.tbadkCore.data.l> aVH() {
        return this.fdj;
    }

    public a aVI() {
        return this.fde;
    }

    public String aVJ() {
        return this.fdp;
    }

    public void qt(String str) {
        this.fdp = str;
    }

    public f aVK() {
        return this.fdr;
    }

    public int aVL() {
        return this.fdh;
    }

    public List<az> aVM() {
        return this.fdn;
    }

    public long aVN() {
        return this.fdt;
    }

    public j aVO() {
        return this.fdu;
    }

    public void a(j jVar) {
        this.fdu = jVar;
    }

    public boolean aVP() {
        return (aVs() == null || !aVs().sA() || aVs().sg() == null) ? false : true;
    }

    public String aVQ() {
        return this.fcX;
    }

    public AlaLiveInfoCoreData aVR() {
        return this.fdi;
    }

    public List<av.a> aVS() {
        return this.fdA;
    }
}

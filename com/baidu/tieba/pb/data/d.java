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
import com.baidu.tbadk.core.data.ay;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.am;
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
import com.baidu.tieba.vote.VoteDataInfo;
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
    private String fGY;
    private int fGZ;
    private String fHA;
    private String fHB;
    private PostData fHC;
    private a fHf;
    private List<bd> fHh;
    private int fHi;
    private AlaLiveInfoCoreData fHj;
    private TwzhiboAnti fHl;
    private VoteDataInfo fHm;
    public AppealInfo fHn;
    private List<ay> fHo;
    private List<ay> fHp;
    public String fHr;
    private PostData fHs;
    private f fHt;
    public CardHListViewData fHu;
    private long fHv;
    private j fHw;
    public String fHx;
    public int fHy;
    public int fHz;
    private boolean fHe = true;
    private ArrayList<com.baidu.tieba.tbadkCore.data.l> fHk = new ArrayList<>();
    private ForumData fGT = new ForumData();
    private ay fGU = new ay();
    private bd bZf = new bd();
    private ArrayList<PostData> fGV = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private al eSK = new al();
    private AntiData aMZ = new AntiData();
    private com.baidu.tbadk.data.f fGW = new com.baidu.tbadk.data.f();
    private int fGX = 0;
    private final UserData fHa = new UserData();
    private List<MuteUser> fHd = new ArrayList();
    private an fHb = new an();
    private ao fHg = new ao();
    private ac fHc = new ac();
    private l fHq = new l();

    public boolean bap() {
        return this.fHe;
    }

    public void jN(boolean z) {
        this.fHe = z;
    }

    public VoteDataInfo baq() {
        return this.fHm;
    }

    public d() {
        this.fGZ = 0;
        this.fHl = null;
        this.fGZ = 0;
        this.fHl = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.fGV != null && this.fGV.size() > 0;
    }

    public String[] bY(Context context) {
        String str = null;
        String str2 = "";
        if (isValid()) {
            int size = this.fGV.size() > 30 ? 30 : this.fGV.size();
            if (bat() == null || bat().zn() == null || am.isEmpty(bat().zn().getUserId())) {
                return new String[]{null, ""};
            }
            String userId = bat().zn().getUserId();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                PostData postData = (PostData) v.f(this.fGV, i);
                if (postData != null && postData.zn() != null && !am.isEmpty(postData.zn().getUserId()) && am.equals(userId, postData.zn().getUserId())) {
                    if (am.isEmpty(str)) {
                        str = postData.bxb();
                    }
                    String bwZ = am.isEmpty(str2) ? postData.bwZ() : str2;
                    if (!am.isEmpty(str) && !am.isEmpty(bwZ)) {
                        str2 = bwZ;
                        break;
                    }
                    str2 = bwZ;
                }
                i++;
                str = str;
            }
            if (am.isEmpty(str)) {
                str = "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            }
            PostData postData2 = this.fGV.get(0);
            if (this.bZf != null && this.bZf.zY() != null && this.bZf.zY().getGroup_id() != 0) {
                str2 = "[" + context.getString(d.j.photo_live_tips) + "] " + str2;
            }
            if (this.bZf != null && this.bZf.Aa() && postData2 != null && postData2.Rr() != null) {
                str = postData2.Rr().getThumbUrl();
            }
        }
        return new String[]{str, str2};
    }

    public ForumData bar() {
        return this.fGT;
    }

    public ay bas() {
        return this.fGU;
    }

    public String getForumId() {
        if (this.fGT == null) {
            return "";
        }
        return this.fGT.getId();
    }

    public bd bat() {
        return this.bZf;
    }

    public List<bd> bau() {
        return this.fHh;
    }

    public String getThreadId() {
        if (this.bZf == null) {
            return "";
        }
        return this.bZf.getId();
    }

    public ArrayList<PostData> bav() {
        return this.fGV;
    }

    public al yA() {
        return this.eSK;
    }

    public ac baw() {
        return this.fHc;
    }

    public ao bax() {
        return this.fHg;
    }

    public void a(al alVar, int i) {
        this.eSK.eH(alVar.yu());
        this.eSK.eF(alVar.xH());
        this.eSK.eE(alVar.yr());
        this.eSK.eI(alVar.yv());
        this.eSK.eG(alVar.yt());
        if (i == 0) {
            this.eSK = alVar;
        } else if (i == 1) {
            this.eSK.eJ(alVar.yw());
        } else if (i == 2) {
            this.eSK.eK(alVar.yx());
        }
    }

    public AntiData yn() {
        return this.aMZ;
    }

    public UserData getUserData() {
        return this.fHa;
    }

    public boolean vX() {
        return this.bZf.zw() != 0;
    }

    public void aL(boolean z) {
        if (this.bZf != null) {
            if (z) {
                this.bZf.eT(1);
            } else {
                this.bZf.eT(0);
            }
        }
    }

    public String vW() {
        if (this.bZf != null) {
            return this.bZf.zx();
        }
        return null;
    }

    public void qj(String str) {
        if (this.bZf != null) {
            this.bZf.dc(str);
        }
    }

    public String bay() {
        return this.fHB;
    }

    public boolean baz() {
        return (this.bZf == null || this.bZf.zz() == null || this.bZf.zz().size() <= 0 || this.bZf.zz().get(0) == null || !this.bZf.zz().get(0).xI()) ? false : true;
    }

    public PostData baA() {
        return this.fHC;
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                com.baidu.tieba.recapp.d.a.boR().rV(dataRes.asp_shown_info);
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
                sA(dataRes.is_new_url.intValue());
                this.fGT.parserProtobuf(dataRes.forum);
                this.fGU.parserProtobuf(dataRes.display_forum);
                this.bZf.setUserMap(this.userMap);
                this.bZf.a(dataRes.thread);
                this.bZf.eW(2);
                this.fHb.a(dataRes.news_info);
                switch (this.fHb.aNq) {
                    case 1:
                        this.fHc.fRU = this.fHb;
                        break;
                    case 2:
                        this.fHc.fRV = this.fHb;
                        break;
                    case 3:
                        this.fHc.fRW = this.fHb;
                        break;
                    default:
                        this.fHc.fRV = this.fHb;
                        break;
                }
                this.fHg.a(dataRes.recommend_book);
                if (this.bZf != null && this.bZf.yZ() != null) {
                    this.fHm = new VoteDataInfo();
                    this.fHm.parserProtobuf(bat().yZ());
                }
                List<Post> list2 = dataRes.post_list;
                if (list2 != null && list2.size() > 0) {
                    for (Post post : dataRes.post_list) {
                        PostData postData = new PostData();
                        postData.setUserMap(this.userMap);
                        postData.a(post, context);
                        postData.a(bat().zc());
                        if (postData.bwT() == 1 && this.bZf.zS()) {
                            if (baz()) {
                                postData.setPostType(0);
                            } else {
                                postData.setPostType(this.bZf.zR());
                            }
                        } else if (postData.bwT() == 1 && this.bZf != null && this.bZf.zZ()) {
                            postData.setPostType(36);
                        } else if (postData.bwT() == 1 && this.bZf.Ad()) {
                            postData.setPostType(41);
                        } else if (postData.bwT() == 1 && this.bZf != null && this.bZf.Aa()) {
                            postData.setPostType(0);
                            postData.Rr();
                            if (this.bZf.zl() == null || this.bZf.zl().size() == 0) {
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
                                postData.c(new TbRichText((Context) TbadkCoreApplication.getInst(), this.bZf.zl(), true));
                            }
                            this.fHs = postData;
                        }
                        if (postData.bwT() == 1 && this.bZf != null && this.bZf.isShareThread) {
                            postData.f(this.bZf.aQl);
                        }
                        this.fGV.add(postData);
                    }
                }
                if (dataRes.first_floor_post != null) {
                    this.fHC = new PostData();
                    this.fHC.setUserMap(this.userMap);
                    this.fHC.a(dataRes.first_floor_post, context);
                    if (this.bZf != null && this.bZf.isShareThread) {
                        this.fHC.f(this.bZf.aQl);
                    }
                }
                this.eSK.a(dataRes.page);
                this.aMZ.parserProtobuf(dataRes.anti);
                this.fGW.a(dataRes.location);
                if (dataRes.user != null) {
                    this.fGX = dataRes.user.is_manager.intValue();
                }
                this.fHa.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.fHd.add(muteUser);
                        }
                    }
                }
                this.bZf.eP(this.bZf.zf() > 0 ? this.bZf.zf() - 1 : 0);
                List<AppData> boc = r.boe().boc();
                if (boc != null) {
                    boc.clear();
                }
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        com.baidu.tieba.tbadkCore.data.l lVar = new com.baidu.tieba.tbadkCore.data.l();
                        lVar.d(app);
                        AppData bwI = lVar.bwI();
                        if (!this.fHk.contains(lVar) && bwI.goods != null && (!StringUtils.isNull(bwI.goods.user_name) || !StringUtils.isNull(bwI.goods.lego_card))) {
                            this.fHk.add(lVar);
                            if (boc != null) {
                                boc.add(lVar.bwI());
                            }
                        }
                    }
                }
                r.boe().bod();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.fHa.getIsSelectTail());
                }
                this.fHl.parserProtobuf(dataRes.twzhibo_anti);
                this.fHn = dataRes.appeal_info;
                if (dataRes.god_card != null) {
                    this.fHf = new a();
                    this.fHf.a(dataRes.god_card);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.fHt = new f();
                    this.fHt.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.guess_like != null) {
                    this.fHu = new CardHListViewData();
                    this.fHu.parseProtobuf(dataRes.guess_like);
                }
                if (dataRes.feed_thread_list != null && dataRes.feed_thread_list.size() > 0) {
                    List<ThreadInfo> list3 = dataRes.feed_thread_list;
                    if (this.fHh == null) {
                        this.fHh = new ArrayList();
                    }
                    this.fHh.clear();
                    for (ThreadInfo threadInfo : list3) {
                        if (threadInfo != null) {
                            bd bdVar = new bd();
                            bdVar.a(threadInfo);
                            this.fHh.add(bdVar);
                        }
                    }
                    if (this.fHh != null && this.fHh.size() > 15) {
                        this.fHh = v.b(this.fHh, 0, 15);
                    }
                }
                this.fHi = dataRes.is_follow_current_channel.intValue();
                if (v.D(dataRes.repost_recommend_forum_list) > 0) {
                    if (this.fHo == null) {
                        this.fHo = new ArrayList();
                    }
                    for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                        ay ayVar = new ay();
                        ayVar.parserProtobuf(simpleForum);
                        this.fHo.add(ayVar);
                    }
                }
                if (v.D(dataRes.from_forum_list) > 0) {
                    if (this.fHp == null) {
                        this.fHp = new ArrayList();
                    }
                    for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                        if (simpleForum2 != null) {
                            ay ayVar2 = new ay();
                            ayVar2.parserProtobuf(simpleForum2);
                            this.fHp.add(ayVar2);
                        }
                    }
                }
                this.fHB = dataRes.multi_forum_text;
                if (dataRes.top_agree_post_list != null && this.fHq != null) {
                    this.fHq.a(context, dataRes.top_agree_post_list);
                }
                if (this.fHv >= 0) {
                    this.fHv = dataRes.thread_freq_num.longValue();
                }
                this.fHw = new j();
                this.fHw.a(dataRes);
                this.fHx = dataRes.partial_visible_toast;
                if (dataRes.follow_tip != null && dataRes.follow_tip.is_toast_tip.intValue() == 1) {
                    this.fGY = dataRes.follow_tip.tip_text;
                }
                this.fHj = new AlaLiveInfoCoreData();
                if (dataRes.ala_info != null) {
                    this.fHj.parserProtoBuf(dataRes.ala_info);
                }
                this.fHA = dataRes.fold_tip;
                this.fHy = dataRes.exp_news_today.intValue();
                this.fHz = dataRes.exp_guide_today.intValue();
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }

    public String baB() {
        return this.fHA;
    }

    public CardHListViewData baC() {
        return this.fHu;
    }

    public PostData baD() {
        return this.fHs;
    }

    public PostData c(PostData postData) {
        this.fHs = postData;
        return postData;
    }

    public l baE() {
        return this.fHq;
    }

    public int baF() {
        return this.fGX;
    }

    public int baG() {
        return this.fGZ;
    }

    public void sA(int i) {
        this.fGZ = i;
    }

    public List<MuteUser> baH() {
        return this.fHd;
    }

    public ArrayList<com.baidu.tieba.tbadkCore.data.l> baI() {
        return this.fHk;
    }

    public a baJ() {
        return this.fHf;
    }

    public String baK() {
        return this.fHr;
    }

    public void qk(String str) {
        this.fHr = str;
    }

    public f baL() {
        return this.fHt;
    }

    public int baM() {
        return this.fHi;
    }

    public List<ay> baN() {
        return this.fHp;
    }

    public long baO() {
        return this.fHv;
    }

    public j baP() {
        return this.fHw;
    }

    public void a(j jVar) {
        this.fHw = jVar;
    }

    public boolean baQ() {
        return (bat() == null || !bat().Aa() || bat().zF() == null) ? false : true;
    }

    public String baR() {
        return this.fGY;
    }

    public AlaLiveInfoCoreData baS() {
        return this.fHj;
    }
}

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
    private List<ay> fHA;
    public String fHC;
    private PostData fHD;
    private f fHE;
    public CardHListViewData fHF;
    private long fHG;
    private j fHH;
    public String fHI;
    public int fHJ;
    public int fHK;
    private String fHL;
    private String fHM;
    private PostData fHN;
    private String fHj;
    private int fHk;
    private a fHq;
    private List<bd> fHs;
    private int fHt;
    private AlaLiveInfoCoreData fHu;
    private TwzhiboAnti fHw;
    private VoteDataInfo fHx;
    public AppealInfo fHy;
    private List<ay> fHz;
    private boolean fHp = true;
    private ArrayList<com.baidu.tieba.tbadkCore.data.l> fHv = new ArrayList<>();
    private ForumData fHe = new ForumData();
    private ay fHf = new ay();
    private bd bZr = new bd();
    private ArrayList<PostData> fHg = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private al eSW = new al();
    private AntiData aNk = new AntiData();
    private com.baidu.tbadk.data.f fHh = new com.baidu.tbadk.data.f();
    private int fHi = 0;
    private final UserData fHl = new UserData();
    private List<MuteUser> fHo = new ArrayList();
    private an fHm = new an();
    private ao fHr = new ao();
    private ac fHn = new ac();
    private l fHB = new l();

    public boolean baq() {
        return this.fHp;
    }

    public void jN(boolean z) {
        this.fHp = z;
    }

    public VoteDataInfo bar() {
        return this.fHx;
    }

    public d() {
        this.fHk = 0;
        this.fHw = null;
        this.fHk = 0;
        this.fHw = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.fHg != null && this.fHg.size() > 0;
    }

    public String[] bY(Context context) {
        String str = null;
        String str2 = "";
        if (isValid()) {
            int size = this.fHg.size() > 30 ? 30 : this.fHg.size();
            if (bau() == null || bau().zn() == null || am.isEmpty(bau().zn().getUserId())) {
                return new String[]{null, ""};
            }
            String userId = bau().zn().getUserId();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                PostData postData = (PostData) v.f(this.fHg, i);
                if (postData != null && postData.zn() != null && !am.isEmpty(postData.zn().getUserId()) && am.equals(userId, postData.zn().getUserId())) {
                    if (am.isEmpty(str)) {
                        str = postData.bxc();
                    }
                    String bxa = am.isEmpty(str2) ? postData.bxa() : str2;
                    if (!am.isEmpty(str) && !am.isEmpty(bxa)) {
                        str2 = bxa;
                        break;
                    }
                    str2 = bxa;
                }
                i++;
                str = str;
            }
            if (am.isEmpty(str)) {
                str = "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            }
            PostData postData2 = this.fHg.get(0);
            if (this.bZr != null && this.bZr.zY() != null && this.bZr.zY().getGroup_id() != 0) {
                str2 = "[" + context.getString(d.j.photo_live_tips) + "] " + str2;
            }
            if (this.bZr != null && this.bZr.Aa() && postData2 != null && postData2.Rs() != null) {
                str = postData2.Rs().getThumbUrl();
            }
        }
        return new String[]{str, str2};
    }

    public ForumData bas() {
        return this.fHe;
    }

    public ay bat() {
        return this.fHf;
    }

    public String getForumId() {
        if (this.fHe == null) {
            return "";
        }
        return this.fHe.getId();
    }

    public bd bau() {
        return this.bZr;
    }

    public List<bd> bav() {
        return this.fHs;
    }

    public String getThreadId() {
        if (this.bZr == null) {
            return "";
        }
        return this.bZr.getId();
    }

    public ArrayList<PostData> baw() {
        return this.fHg;
    }

    public al yA() {
        return this.eSW;
    }

    public ac bax() {
        return this.fHn;
    }

    public ao bay() {
        return this.fHr;
    }

    public void a(al alVar, int i) {
        this.eSW.eH(alVar.yu());
        this.eSW.eF(alVar.xH());
        this.eSW.eE(alVar.yr());
        this.eSW.eI(alVar.yv());
        this.eSW.eG(alVar.yt());
        if (i == 0) {
            this.eSW = alVar;
        } else if (i == 1) {
            this.eSW.eJ(alVar.yw());
        } else if (i == 2) {
            this.eSW.eK(alVar.yx());
        }
    }

    public AntiData yn() {
        return this.aNk;
    }

    public UserData getUserData() {
        return this.fHl;
    }

    public boolean vX() {
        return this.bZr.zw() != 0;
    }

    public void aL(boolean z) {
        if (this.bZr != null) {
            if (z) {
                this.bZr.eT(1);
            } else {
                this.bZr.eT(0);
            }
        }
    }

    public String vW() {
        if (this.bZr != null) {
            return this.bZr.zx();
        }
        return null;
    }

    public void qj(String str) {
        if (this.bZr != null) {
            this.bZr.dc(str);
        }
    }

    public String baz() {
        return this.fHM;
    }

    public boolean baA() {
        return (this.bZr == null || this.bZr.zz() == null || this.bZr.zz().size() <= 0 || this.bZr.zz().get(0) == null || !this.bZr.zz().get(0).xI()) ? false : true;
    }

    public PostData baB() {
        return this.fHN;
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                com.baidu.tieba.recapp.d.a.boS().rV(dataRes.asp_shown_info);
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
                sz(dataRes.is_new_url.intValue());
                this.fHe.parserProtobuf(dataRes.forum);
                this.fHf.parserProtobuf(dataRes.display_forum);
                this.bZr.setUserMap(this.userMap);
                this.bZr.a(dataRes.thread);
                this.bZr.eW(2);
                this.fHm.a(dataRes.news_info);
                switch (this.fHm.aNB) {
                    case 1:
                        this.fHn.fSf = this.fHm;
                        break;
                    case 2:
                        this.fHn.fSg = this.fHm;
                        break;
                    case 3:
                        this.fHn.fSh = this.fHm;
                        break;
                    default:
                        this.fHn.fSg = this.fHm;
                        break;
                }
                this.fHr.a(dataRes.recommend_book);
                if (this.bZr != null && this.bZr.yZ() != null) {
                    this.fHx = new VoteDataInfo();
                    this.fHx.parserProtobuf(bau().yZ());
                }
                List<Post> list2 = dataRes.post_list;
                if (list2 != null && list2.size() > 0) {
                    for (Post post : dataRes.post_list) {
                        PostData postData = new PostData();
                        postData.setUserMap(this.userMap);
                        postData.a(post, context);
                        postData.a(bau().zc());
                        if (postData.bwU() == 1 && this.bZr.zS()) {
                            if (baA()) {
                                postData.setPostType(0);
                            } else {
                                postData.setPostType(this.bZr.zR());
                            }
                        } else if (postData.bwU() == 1 && this.bZr != null && this.bZr.zZ()) {
                            postData.setPostType(36);
                        } else if (postData.bwU() == 1 && this.bZr.Ad()) {
                            postData.setPostType(41);
                        } else if (postData.bwU() == 1 && this.bZr != null && this.bZr.Aa()) {
                            postData.setPostType(0);
                            postData.Rs();
                            if (this.bZr.zl() == null || this.bZr.zl().size() == 0) {
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
                                postData.c(new TbRichText((Context) TbadkCoreApplication.getInst(), this.bZr.zl(), true));
                            }
                            this.fHD = postData;
                        }
                        if (postData.bwU() == 1 && this.bZr != null && this.bZr.isShareThread) {
                            postData.f(this.bZr.aQw);
                        }
                        this.fHg.add(postData);
                    }
                }
                if (dataRes.first_floor_post != null) {
                    this.fHN = new PostData();
                    this.fHN.setUserMap(this.userMap);
                    this.fHN.a(dataRes.first_floor_post, context);
                    if (this.bZr != null && this.bZr.isShareThread) {
                        this.fHN.f(this.bZr.aQw);
                    }
                }
                this.eSW.a(dataRes.page);
                this.aNk.parserProtobuf(dataRes.anti);
                this.fHh.a(dataRes.location);
                if (dataRes.user != null) {
                    this.fHi = dataRes.user.is_manager.intValue();
                }
                this.fHl.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.fHo.add(muteUser);
                        }
                    }
                }
                this.bZr.eP(this.bZr.zf() > 0 ? this.bZr.zf() - 1 : 0);
                List<AppData> bod = r.bof().bod();
                if (bod != null) {
                    bod.clear();
                }
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        com.baidu.tieba.tbadkCore.data.l lVar = new com.baidu.tieba.tbadkCore.data.l();
                        lVar.d(app);
                        AppData bwJ = lVar.bwJ();
                        if (!this.fHv.contains(lVar) && bwJ.goods != null && (!StringUtils.isNull(bwJ.goods.user_name) || !StringUtils.isNull(bwJ.goods.lego_card))) {
                            this.fHv.add(lVar);
                            if (bod != null) {
                                bod.add(lVar.bwJ());
                            }
                        }
                    }
                }
                r.bof().boe();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.fHl.getIsSelectTail());
                }
                this.fHw.parserProtobuf(dataRes.twzhibo_anti);
                this.fHy = dataRes.appeal_info;
                if (dataRes.god_card != null) {
                    this.fHq = new a();
                    this.fHq.a(dataRes.god_card);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.fHE = new f();
                    this.fHE.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.guess_like != null) {
                    this.fHF = new CardHListViewData();
                    this.fHF.parseProtobuf(dataRes.guess_like);
                }
                if (dataRes.feed_thread_list != null && dataRes.feed_thread_list.size() > 0) {
                    List<ThreadInfo> list3 = dataRes.feed_thread_list;
                    if (this.fHs == null) {
                        this.fHs = new ArrayList();
                    }
                    this.fHs.clear();
                    for (ThreadInfo threadInfo : list3) {
                        if (threadInfo != null) {
                            bd bdVar = new bd();
                            bdVar.a(threadInfo);
                            this.fHs.add(bdVar);
                        }
                    }
                    if (this.fHs != null && this.fHs.size() > 15) {
                        this.fHs = v.b(this.fHs, 0, 15);
                    }
                }
                this.fHt = dataRes.is_follow_current_channel.intValue();
                if (v.D(dataRes.repost_recommend_forum_list) > 0) {
                    if (this.fHz == null) {
                        this.fHz = new ArrayList();
                    }
                    for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                        ay ayVar = new ay();
                        ayVar.parserProtobuf(simpleForum);
                        this.fHz.add(ayVar);
                    }
                }
                if (v.D(dataRes.from_forum_list) > 0) {
                    if (this.fHA == null) {
                        this.fHA = new ArrayList();
                    }
                    for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                        if (simpleForum2 != null) {
                            ay ayVar2 = new ay();
                            ayVar2.parserProtobuf(simpleForum2);
                            this.fHA.add(ayVar2);
                        }
                    }
                }
                this.fHM = dataRes.multi_forum_text;
                if (dataRes.top_agree_post_list != null && this.fHB != null) {
                    this.fHB.a(context, dataRes.top_agree_post_list);
                }
                if (this.fHG >= 0) {
                    this.fHG = dataRes.thread_freq_num.longValue();
                }
                this.fHH = new j();
                this.fHH.a(dataRes);
                this.fHI = dataRes.partial_visible_toast;
                if (dataRes.follow_tip != null && dataRes.follow_tip.is_toast_tip.intValue() == 1) {
                    this.fHj = dataRes.follow_tip.tip_text;
                }
                this.fHu = new AlaLiveInfoCoreData();
                if (dataRes.ala_info != null) {
                    this.fHu.parserProtoBuf(dataRes.ala_info);
                }
                this.fHL = dataRes.fold_tip;
                this.fHJ = dataRes.exp_news_today.intValue();
                this.fHK = dataRes.exp_guide_today.intValue();
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }

    public String baC() {
        return this.fHL;
    }

    public CardHListViewData baD() {
        return this.fHF;
    }

    public PostData baE() {
        return this.fHD;
    }

    public PostData c(PostData postData) {
        this.fHD = postData;
        return postData;
    }

    public l baF() {
        return this.fHB;
    }

    public int baG() {
        return this.fHi;
    }

    public int baH() {
        return this.fHk;
    }

    public void sz(int i) {
        this.fHk = i;
    }

    public List<MuteUser> baI() {
        return this.fHo;
    }

    public ArrayList<com.baidu.tieba.tbadkCore.data.l> baJ() {
        return this.fHv;
    }

    public a baK() {
        return this.fHq;
    }

    public String baL() {
        return this.fHC;
    }

    public void qk(String str) {
        this.fHC = str;
    }

    public f baM() {
        return this.fHE;
    }

    public int baN() {
        return this.fHt;
    }

    public List<ay> baO() {
        return this.fHA;
    }

    public long baP() {
        return this.fHG;
    }

    public j baQ() {
        return this.fHH;
    }

    public void a(j jVar) {
        this.fHH = jVar;
    }

    public boolean baR() {
        return (bau() == null || !bau().Aa() || bau().zF() == null) ? false : true;
    }

    public String baS() {
        return this.fHj;
    }

    public AlaLiveInfoCoreData baT() {
        return this.fHu;
    }
}

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
import com.baidu.tieba.tbadkCore.data.m;
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
    private TwzhiboAnti fHB;
    private VoteDataInfo fHC;
    public AppealInfo fHD;
    private List<ay> fHE;
    private List<ay> fHF;
    public String fHH;
    private PostData fHI;
    private f fHJ;
    public CardHListViewData fHK;
    private long fHL;
    private j fHM;
    public String fHN;
    public int fHO;
    public int fHP;
    private String fHQ;
    private String fHR;
    private PostData fHS;
    private String fHo;
    private int fHp;
    private a fHv;
    private List<bd> fHx;
    private int fHy;
    private AlaLiveInfoCoreData fHz;
    private boolean fHu = true;
    private ArrayList<m> fHA = new ArrayList<>();
    private ForumData fHj = new ForumData();
    private ay fHk = new ay();
    private bd bZi = new bd();
    private ArrayList<PostData> fHl = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private al eSZ = new al();
    private AntiData aNa = new AntiData();
    private com.baidu.tbadk.data.f fHm = new com.baidu.tbadk.data.f();
    private int fHn = 0;
    private final UserData fHq = new UserData();
    private List<MuteUser> fHt = new ArrayList();
    private an fHr = new an();
    private ao fHw = new ao();
    private ac fHs = new ac();
    private l fHG = new l();

    public boolean baq() {
        return this.fHu;
    }

    public void jS(boolean z) {
        this.fHu = z;
    }

    public VoteDataInfo bar() {
        return this.fHC;
    }

    public d() {
        this.fHp = 0;
        this.fHB = null;
        this.fHp = 0;
        this.fHB = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.fHl != null && this.fHl.size() > 0;
    }

    public String[] bY(Context context) {
        String str = null;
        String str2 = "";
        if (isValid()) {
            int size = this.fHl.size() > 30 ? 30 : this.fHl.size();
            if (bau() == null || bau().zn() == null || am.isEmpty(bau().zn().getUserId())) {
                return new String[]{null, ""};
            }
            String userId = bau().zn().getUserId();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                PostData postData = (PostData) v.f(this.fHl, i);
                if (postData != null && postData.zn() != null && !am.isEmpty(postData.zn().getUserId()) && am.equals(userId, postData.zn().getUserId())) {
                    if (am.isEmpty(str)) {
                        str = postData.bxg();
                    }
                    String bxe = am.isEmpty(str2) ? postData.bxe() : str2;
                    if (!am.isEmpty(str) && !am.isEmpty(bxe)) {
                        str2 = bxe;
                        break;
                    }
                    str2 = bxe;
                }
                i++;
                str = str;
            }
            if (am.isEmpty(str)) {
                str = "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            }
            PostData postData2 = this.fHl.get(0);
            if (this.bZi != null && this.bZi.zY() != null && this.bZi.zY().getGroup_id() != 0) {
                str2 = "[" + context.getString(d.j.photo_live_tips) + "] " + str2;
            }
            if (this.bZi != null && this.bZi.Aa() && postData2 != null && postData2.Rs() != null) {
                str = postData2.Rs().getThumbUrl();
            }
        }
        return new String[]{str, str2};
    }

    public ForumData bas() {
        return this.fHj;
    }

    public ay bat() {
        return this.fHk;
    }

    public String getForumId() {
        if (this.fHj == null) {
            return "";
        }
        return this.fHj.getId();
    }

    public bd bau() {
        return this.bZi;
    }

    public List<bd> bav() {
        return this.fHx;
    }

    public String getThreadId() {
        if (this.bZi == null) {
            return "";
        }
        return this.bZi.getId();
    }

    public ArrayList<PostData> baw() {
        return this.fHl;
    }

    public al yA() {
        return this.eSZ;
    }

    public ac bax() {
        return this.fHs;
    }

    public ao bay() {
        return this.fHw;
    }

    public void a(al alVar, int i) {
        this.eSZ.eH(alVar.yu());
        this.eSZ.eF(alVar.xH());
        this.eSZ.eE(alVar.yr());
        this.eSZ.eI(alVar.yv());
        this.eSZ.eG(alVar.yt());
        if (i == 0) {
            this.eSZ = alVar;
        } else if (i == 1) {
            this.eSZ.eJ(alVar.yw());
        } else if (i == 2) {
            this.eSZ.eK(alVar.yx());
        }
    }

    public AntiData yn() {
        return this.aNa;
    }

    public UserData getUserData() {
        return this.fHq;
    }

    public boolean vX() {
        return this.bZi.zw() != 0;
    }

    public void aL(boolean z) {
        if (this.bZi != null) {
            if (z) {
                this.bZi.eT(1);
            } else {
                this.bZi.eT(0);
            }
        }
    }

    public String vW() {
        if (this.bZi != null) {
            return this.bZi.zx();
        }
        return null;
    }

    public void qj(String str) {
        if (this.bZi != null) {
            this.bZi.dc(str);
        }
    }

    public String baz() {
        return this.fHR;
    }

    public boolean baA() {
        return (this.bZi == null || this.bZi.zz() == null || this.bZi.zz().size() <= 0 || this.bZi.zz().get(0) == null || !this.bZi.zz().get(0).xI()) ? false : true;
    }

    public PostData baB() {
        return this.fHS;
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
                sA(dataRes.is_new_url.intValue());
                this.fHj.parserProtobuf(dataRes.forum);
                this.fHk.parserProtobuf(dataRes.display_forum);
                this.bZi.setUserMap(this.userMap);
                this.bZi.a(dataRes.thread);
                this.bZi.eW(2);
                this.fHr.a(dataRes.news_info);
                switch (this.fHr.aNr) {
                    case 1:
                        this.fHs.fSk = this.fHr;
                        break;
                    case 2:
                        this.fHs.fSl = this.fHr;
                        break;
                    case 3:
                        this.fHs.fSm = this.fHr;
                        break;
                    default:
                        this.fHs.fSl = this.fHr;
                        break;
                }
                this.fHw.a(dataRes.recommend_book);
                if (this.bZi != null && this.bZi.yZ() != null) {
                    this.fHC = new VoteDataInfo();
                    this.fHC.parserProtobuf(bau().yZ());
                }
                List<Post> list2 = dataRes.post_list;
                if (list2 != null && list2.size() > 0) {
                    for (Post post : dataRes.post_list) {
                        PostData postData = new PostData();
                        postData.setUserMap(this.userMap);
                        postData.a(post, context);
                        postData.a(bau().zc());
                        if (postData.bwY() == 1 && this.bZi.zS()) {
                            if (baA()) {
                                postData.setPostType(0);
                            } else {
                                postData.setPostType(this.bZi.zR());
                            }
                        } else if (postData.bwY() == 1 && this.bZi != null && this.bZi.zZ()) {
                            postData.setPostType(36);
                        } else if (postData.bwY() == 1 && this.bZi.Ad()) {
                            postData.setPostType(41);
                        } else if (postData.bwY() == 1 && this.bZi != null && this.bZi.Aa()) {
                            postData.setPostType(0);
                            postData.Rs();
                            if (this.bZi.zl() == null || this.bZi.zl().size() == 0) {
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
                                postData.c(new TbRichText((Context) TbadkCoreApplication.getInst(), this.bZi.zl(), true));
                            }
                            this.fHI = postData;
                        }
                        if (postData.bwY() == 1 && this.bZi != null && this.bZi.isShareThread) {
                            postData.f(this.bZi.aQm);
                        }
                        this.fHl.add(postData);
                    }
                }
                if (dataRes.first_floor_post != null) {
                    this.fHS = new PostData();
                    this.fHS.setUserMap(this.userMap);
                    this.fHS.a(dataRes.first_floor_post, context);
                    if (this.bZi != null && this.bZi.isShareThread) {
                        this.fHS.f(this.bZi.aQm);
                    }
                }
                this.eSZ.a(dataRes.page);
                this.aNa.parserProtobuf(dataRes.anti);
                this.fHm.a(dataRes.location);
                if (dataRes.user != null) {
                    this.fHn = dataRes.user.is_manager.intValue();
                }
                this.fHq.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.fHt.add(muteUser);
                        }
                    }
                }
                this.bZi.eP(this.bZi.zf() > 0 ? this.bZi.zf() - 1 : 0);
                List<AppData> bod = r.bof().bod();
                if (bod != null) {
                    bod.clear();
                }
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        m mVar = new m();
                        mVar.d(app);
                        AppData bwN = mVar.bwN();
                        if (!this.fHA.contains(mVar) && bwN.goods != null && (!StringUtils.isNull(bwN.goods.user_name) || !StringUtils.isNull(bwN.goods.lego_card))) {
                            this.fHA.add(mVar);
                            if (bod != null) {
                                bod.add(mVar.bwN());
                            }
                        }
                    }
                }
                r.bof().boe();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.fHq.getIsSelectTail());
                }
                this.fHB.parserProtobuf(dataRes.twzhibo_anti);
                this.fHD = dataRes.appeal_info;
                if (dataRes.god_card != null) {
                    this.fHv = new a();
                    this.fHv.a(dataRes.god_card);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.fHJ = new f();
                    this.fHJ.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.guess_like != null) {
                    this.fHK = new CardHListViewData();
                    this.fHK.parseProtobuf(dataRes.guess_like);
                }
                if (dataRes.feed_thread_list != null && dataRes.feed_thread_list.size() > 0) {
                    List<ThreadInfo> list3 = dataRes.feed_thread_list;
                    if (this.fHx == null) {
                        this.fHx = new ArrayList();
                    }
                    this.fHx.clear();
                    for (ThreadInfo threadInfo : list3) {
                        if (threadInfo != null) {
                            bd bdVar = new bd();
                            bdVar.a(threadInfo);
                            this.fHx.add(bdVar);
                        }
                    }
                    if (this.fHx != null && this.fHx.size() > 15) {
                        this.fHx = v.b(this.fHx, 0, 15);
                    }
                }
                this.fHy = dataRes.is_follow_current_channel.intValue();
                if (v.D(dataRes.repost_recommend_forum_list) > 0) {
                    if (this.fHE == null) {
                        this.fHE = new ArrayList();
                    }
                    for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                        ay ayVar = new ay();
                        ayVar.parserProtobuf(simpleForum);
                        this.fHE.add(ayVar);
                    }
                }
                if (v.D(dataRes.from_forum_list) > 0) {
                    if (this.fHF == null) {
                        this.fHF = new ArrayList();
                    }
                    for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                        if (simpleForum2 != null) {
                            ay ayVar2 = new ay();
                            ayVar2.parserProtobuf(simpleForum2);
                            this.fHF.add(ayVar2);
                        }
                    }
                }
                this.fHR = dataRes.multi_forum_text;
                if (dataRes.top_agree_post_list != null && this.fHG != null) {
                    this.fHG.a(context, dataRes.top_agree_post_list);
                }
                if (this.fHL >= 0) {
                    this.fHL = dataRes.thread_freq_num.longValue();
                }
                this.fHM = new j();
                this.fHM.a(dataRes);
                this.fHN = dataRes.partial_visible_toast;
                if (dataRes.follow_tip != null && dataRes.follow_tip.is_toast_tip.intValue() == 1) {
                    this.fHo = dataRes.follow_tip.tip_text;
                }
                this.fHz = new AlaLiveInfoCoreData();
                if (dataRes.ala_info != null) {
                    this.fHz.parserProtoBuf(dataRes.ala_info);
                }
                this.fHQ = dataRes.fold_tip;
                this.fHO = dataRes.exp_news_today.intValue();
                this.fHP = dataRes.exp_guide_today.intValue();
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }

    public String baC() {
        return this.fHQ;
    }

    public CardHListViewData baD() {
        return this.fHK;
    }

    public PostData baE() {
        return this.fHI;
    }

    public PostData c(PostData postData) {
        this.fHI = postData;
        return postData;
    }

    public l baF() {
        return this.fHG;
    }

    public int baG() {
        return this.fHn;
    }

    public int baH() {
        return this.fHp;
    }

    public void sA(int i) {
        this.fHp = i;
    }

    public List<MuteUser> baI() {
        return this.fHt;
    }

    public ArrayList<m> baJ() {
        return this.fHA;
    }

    public a baK() {
        return this.fHv;
    }

    public String baL() {
        return this.fHH;
    }

    public void qk(String str) {
        this.fHH = str;
    }

    public f baM() {
        return this.fHJ;
    }

    public int baN() {
        return this.fHy;
    }

    public List<ay> baO() {
        return this.fHF;
    }

    public long baP() {
        return this.fHL;
    }

    public j baQ() {
        return this.fHM;
    }

    public void a(j jVar) {
        this.fHM = jVar;
    }

    public boolean baR() {
        return (bau() == null || !bau().Aa() || bau().zF() == null) ? false : true;
    }

    public String baS() {
        return this.fHo;
    }

    public AlaLiveInfoCoreData baT() {
        return this.fHz;
    }
}

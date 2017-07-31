package com.baidu.tieba.pb.data;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.TwzhiboAnti;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.af;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.au;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.p;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.z;
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
/* loaded from: classes.dex */
public class f {
    private int dFS;
    private a eDW;
    private List<bl> eDY;
    private int eDZ;
    private int eEa;
    private TwzhiboAnti eEc;
    private VoteDataInfo eEd;
    public AppealInfo eEe;
    private List<be> eEf;
    private List<be> eEg;
    public String eEi;
    private PostData eEj;
    private h eEl;
    public CardHListViewData eEm;
    private long eEn;
    private m eEo;
    public String eEp;
    private PostData eEq;
    private boolean eDV = true;
    private ArrayList<com.baidu.tieba.tbadkCore.data.l> eEb = new ArrayList<>();
    private ForumData eDL = new ForumData();
    private be eDM = new be();
    private bl bcL = new bl();
    private ArrayList<PostData> eDN = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private ar dEx = new ar();
    private AntiData XM = new AntiData();
    private com.baidu.tbadk.data.h eDO = new com.baidu.tbadk.data.h();
    private int eDQ = 0;
    private boolean eDP = false;
    private final UserData eDR = new UserData();
    private List<MuteUser> eDU = new ArrayList();
    private at eDS = new at();
    private au eDX = new au();
    private z eDT = new z();
    private af eEk = new af();
    private o eEh = new o();

    public boolean aPe() {
        return this.eDV;
    }

    public void iN(boolean z) {
        this.eDV = z;
    }

    public af aPf() {
        return this.eEk;
    }

    public VoteDataInfo aPg() {
        return this.eEd;
    }

    public f() {
        this.dFS = 0;
        this.eEc = null;
        this.dFS = 0;
        this.eEc = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.eDN != null && this.eDN.size() > 0;
    }

    public p se() {
        if (this.bcL == null) {
            return null;
        }
        return this.bcL.se();
    }

    public String[] bD(Context context) {
        String str = null;
        String str2 = "";
        if (isValid()) {
            PostData postData = this.eDN.get(0);
            PreLoadImageInfo bsD = postData.bsD();
            str = bsD != null ? bsD.imgUrl : "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            str2 = postData.bO(context);
            if (this.bcL != null && this.bcL.sq() != null && this.bcL.sq().getGroup_id() != 0) {
                str2 = "[" + context.getString(d.l.photo_live_tips) + "] " + str2;
            }
            if (this.bcL != null && this.bcL.ss() && postData != null && postData.Ix() != null) {
                str = postData.Ix().getThumbUrl();
            }
        }
        return new String[]{str, str2};
    }

    public ForumData aPh() {
        return this.eDL;
    }

    public be aPi() {
        return this.eDM;
    }

    public String getForumId() {
        if (this.eDL == null) {
            return "";
        }
        return this.eDL.getId();
    }

    public bl aPj() {
        return this.bcL;
    }

    public List<bl> aPk() {
        return this.eDY;
    }

    public String getThreadId() {
        if (this.bcL == null) {
            return "";
        }
        return this.bcL.getId();
    }

    public ArrayList<PostData> aPl() {
        return this.eDN;
    }

    public ar qH() {
        return this.dEx;
    }

    public z aPm() {
        return this.eDT;
    }

    public au aPn() {
        return this.eDX;
    }

    public TwzhiboAnti aPo() {
        return this.eEc;
    }

    public void a(ar arVar, int i) {
        this.dEx.bJ(arVar.qB());
        this.dEx.bH(arVar.pr());
        this.dEx.bG(arVar.qy());
        this.dEx.bK(arVar.qC());
        this.dEx.bI(arVar.qA());
        if (i == 0) {
            this.dEx = arVar;
        } else if (i == 1) {
            this.dEx.bL(arVar.qD());
        } else if (i == 2) {
            this.dEx.bM(arVar.qE());
        }
    }

    public AntiData qr() {
        return this.XM;
    }

    public UserData getUserData() {
        return this.eDR;
    }

    public boolean nL() {
        return this.bcL.getIsMarked() != 0;
    }

    public void ac(boolean z) {
        if (this.bcL != null) {
            if (z) {
                this.bcL.setIsMarked(1);
            } else {
                this.bcL.setIsMarked(0);
            }
        }
    }

    public String nK() {
        if (this.bcL != null) {
            return this.bcL.rO();
        }
        return null;
    }

    public void pg(String str) {
        if (this.bcL != null) {
            this.bcL.cM(str);
        }
    }

    public boolean aPp() {
        return (this.bcL == null || this.bcL.rQ() == null || this.bcL.rQ().size() <= 0 || this.bcL.rQ().get(0) == null || !this.bcL.rQ().get(0).getIsSenior()) ? false : true;
    }

    public PostData aPq() {
        return this.eEq;
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                com.baidu.tieba.recapp.d.a.bii().rh(dataRes.asp_shown_info);
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
                mO(dataRes.is_new_url.intValue());
                this.eDL.parserProtobuf(dataRes.forum);
                this.eDM.parserProtobuf(dataRes.display_forum);
                this.bcL.setUserMap(this.userMap);
                this.bcL.a(dataRes.thread);
                this.bcL.bX(2);
                if (se() != null) {
                    se().setForumId(com.baidu.adp.lib.g.b.d(this.eDL.getId(), 0L));
                }
                this.eDS.a(dataRes.news_info);
                switch (this.eDS.Ye) {
                    case 1:
                        this.eDT.eMJ = this.eDS;
                        break;
                    case 2:
                        this.eDT.eMK = this.eDS;
                        break;
                    case 3:
                        this.eDT.eML = this.eDS;
                        break;
                    default:
                        this.eDT.eMK = this.eDS;
                        break;
                }
                this.eDX.a(dataRes.recommend_book);
                if (this.bcL != null && this.bcL.rt() != null) {
                    this.eEd = new VoteDataInfo();
                    this.eEd.parserProtobuf(aPj().rt());
                }
                List<Post> list2 = dataRes.post_list;
                if (list2 != null && list2.size() > 0) {
                    for (Post post : dataRes.post_list) {
                        PostData postData = new PostData();
                        postData.setUserMap(this.userMap);
                        postData.a(post, context);
                        postData.a(aPj().rv());
                        if (postData.bsy() == 1 && this.bcL.sk()) {
                            if (aPp()) {
                                postData.setPostType(0);
                            } else {
                                postData.setPostType(this.bcL.sj());
                            }
                        } else if (postData.bsy() == 1 && this.bcL != null && this.bcL.sr()) {
                            postData.setPostType(36);
                        } else if (postData.bsy() == 1 && this.bcL.sx()) {
                            postData.setPostType(41);
                        } else if (postData.bsy() == 1 && this.bcL != null && this.bcL.ss()) {
                            postData.setPostType(0);
                            postData.Ix();
                            if (this.bcL.rD() == null || this.bcL.rD().size() == 0) {
                                JSONArray jSONArray = new JSONArray();
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("type", 0);
                                    jSONObject.put("text", "");
                                    jSONArray.put(jSONObject);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                postData.g(TbRichTextView.a(context, jSONArray, false));
                            } else {
                                postData.g(new TbRichText((Context) TbadkCoreApplication.getInst(), this.bcL.rD(), true));
                            }
                            this.eEj = postData;
                        } else if (postData.bsy() == 1 && this.bcL.sy()) {
                            postData.setPostType(48);
                        }
                        this.eDN.add(postData);
                    }
                }
                if (dataRes.first_floor_post != null) {
                    this.eEq = new PostData();
                    this.eEq.setUserMap(this.userMap);
                    this.eEq.a(dataRes.first_floor_post, context);
                }
                this.dEx.a(dataRes.page);
                this.XM.parserProtobuf(dataRes.anti);
                this.eDO.a(dataRes.location);
                this.eDP = dataRes.has_floor.intValue() == 1;
                if (dataRes.user != null) {
                    this.eDQ = dataRes.user.is_manager.intValue();
                }
                this.eDR.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.eDU.add(muteUser);
                        }
                    }
                }
                this.bcL.bR(this.bcL.rx() > 0 ? this.bcL.rx() - 1 : 0);
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        com.baidu.tieba.tbadkCore.data.l lVar = new com.baidu.tieba.tbadkCore.data.l();
                        lVar.c(app);
                        AppData bsn = lVar.bsn();
                        if (!this.eEb.contains(lVar) && bsn.goods != null && (!StringUtils.isNull(bsn.goods.user_name) || !StringUtils.isNull(bsn.goods.lego_card))) {
                            this.eEb.add(lVar);
                        }
                    }
                }
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.eDR.getIsSelectTail());
                }
                this.eEc.parserProtobuf(dataRes.twzhibo_anti);
                this.eEe = dataRes.appeal_info;
                if (this.eEk != null) {
                    this.eEk.setForumId(getForumId());
                    this.eEk.setThreadId(getThreadId());
                    this.eEk.bF(0);
                    if (this.eDQ > 0) {
                        this.eEk.bF(2);
                    }
                    if (this.bcL != null && this.bcL.getAuthor() != null) {
                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                        if (!TextUtils.isEmpty(currentAccount) && currentAccount.equals(this.bcL.getAuthor().getUserId())) {
                            this.eEk.bF(1);
                        }
                    }
                    this.eEk.a(dataRes.graffiti_rank_list_info);
                    this.eEk.Xy = this.bcL.aaU;
                }
                if (dataRes.god_card != null) {
                    this.eDW = new a();
                    this.eDW.a(dataRes.god_card);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.eEl = new h();
                    this.eEl.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.guess_like != null) {
                    this.eEm = new CardHListViewData();
                    this.eEm.parseProtobuf(dataRes.guess_like);
                }
                if (dataRes.feed_thread_list != null && dataRes.feed_thread_list.size() > 0) {
                    List<ThreadInfo> list3 = dataRes.feed_thread_list;
                    if (this.eDY == null) {
                        this.eDY = new ArrayList();
                    }
                    this.eDY.clear();
                    for (ThreadInfo threadInfo : list3) {
                        if (threadInfo != null) {
                            bl blVar = new bl();
                            blVar.a(threadInfo);
                            this.eDY.add(blVar);
                        }
                    }
                    if (this.eDY != null && this.eDY.size() > 15) {
                        this.eDY = u.a(this.eDY, 0, 15);
                    }
                }
                this.eDZ = dataRes.is_follow_current_channel.intValue();
                this.eEa = dataRes.switch_read_open.intValue();
                if (u.u(dataRes.repost_recommend_forum_list) > 0) {
                    if (this.eEf == null) {
                        this.eEf = new ArrayList();
                    }
                    for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                        be beVar = new be();
                        beVar.parserProtobuf(simpleForum);
                        this.eEf.add(beVar);
                    }
                }
                if (u.u(dataRes.from_forum_list) > 0) {
                    if (this.eEg == null) {
                        this.eEg = new ArrayList();
                    }
                    for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                        be beVar2 = new be();
                        beVar2.parserProtobuf(simpleForum2);
                        this.eEg.add(beVar2);
                    }
                }
                if (dataRes.top_agree_post_list != null && this.eEh != null) {
                    this.eEh.a(context, dataRes.top_agree_post_list);
                }
                if (this.eEn >= 0) {
                    this.eEn = dataRes.thread_freq_num.longValue();
                }
                this.eEo = new m();
                this.eEo.a(dataRes);
                this.eEp = dataRes.partial_visible_toast;
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }

    public CardHListViewData aPr() {
        return this.eEm;
    }

    public PostData aPs() {
        return this.eEj;
    }

    public PostData e(PostData postData) {
        this.eEj = postData;
        return postData;
    }

    public o aPt() {
        return this.eEh;
    }

    public int aPu() {
        return this.eDQ;
    }

    public int aPv() {
        return this.dFS;
    }

    public void mO(int i) {
        this.dFS = i;
    }

    public List<MuteUser> aPw() {
        return this.eDU;
    }

    public ArrayList<com.baidu.tieba.tbadkCore.data.l> aPx() {
        return this.eEb;
    }

    public a aPy() {
        return this.eDW;
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> aPz() {
        return new ArrayList<>(this.eDN);
    }

    public String aPA() {
        return this.eEi;
    }

    public void ph(String str) {
        this.eEi = str;
    }

    public h aPB() {
        return this.eEl;
    }

    public int aPC() {
        return this.eDZ;
    }

    public boolean aPD() {
        return this.eEa == 1;
    }

    public List<be> aPE() {
        return this.eEg;
    }

    public long aPF() {
        return this.eEn;
    }

    public m aPG() {
        return this.eEo;
    }

    public void a(m mVar) {
        this.eEo = mVar;
    }
}

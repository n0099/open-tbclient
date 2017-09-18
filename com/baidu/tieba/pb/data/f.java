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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.p;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.z;
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
/* loaded from: classes.dex */
public class f {
    private int dPp;
    private PostData eFA;
    private a eFg;
    private List<bj> eFi;
    private int eFj;
    private int eFk;
    private TwzhiboAnti eFm;
    private VoteDataInfo eFn;
    public AppealInfo eFo;
    private List<be> eFp;
    private List<be> eFq;
    public String eFs;
    private PostData eFt;
    private h eFv;
    public CardHListViewData eFw;
    private long eFx;
    private l eFy;
    public String eFz;
    private boolean eFf = true;
    private ArrayList<com.baidu.tieba.tbadkCore.data.l> eFl = new ArrayList<>();
    private ForumData eEV = new ForumData();
    private be eEW = new be();
    private bj bcG = new bj();
    private ArrayList<PostData> eEX = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private ar dNU = new ar();
    private AntiData WY = new AntiData();
    private com.baidu.tbadk.data.h eEY = new com.baidu.tbadk.data.h();
    private int eFa = 0;
    private boolean eEZ = false;
    private final UserData eFb = new UserData();
    private List<MuteUser> eFe = new ArrayList();
    private at eFc = new at();
    private au eFh = new au();
    private z eFd = new z();
    private af eFu = new af();
    private n eFr = new n();

    public boolean aPd() {
        return this.eFf;
    }

    public void iR(boolean z) {
        this.eFf = z;
    }

    public af aPe() {
        return this.eFu;
    }

    public VoteDataInfo aPf() {
        return this.eFn;
    }

    public f() {
        this.dPp = 0;
        this.eFm = null;
        this.dPp = 0;
        this.eFm = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.eEX != null && this.eEX.size() > 0;
    }

    public p sa() {
        if (this.bcG == null) {
            return null;
        }
        return this.bcG.sa();
    }

    public String[] bN(Context context) {
        String str = null;
        String str2 = "";
        if (isValid()) {
            PostData postData = this.eEX.get(0);
            PreLoadImageInfo bsE = postData.bsE();
            str = bsE != null ? bsE.imgUrl : "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            str2 = postData.ca(context);
            if (this.bcG != null && this.bcG.sm() != null && this.bcG.sm().getGroup_id() != 0) {
                str2 = "[" + context.getString(d.l.photo_live_tips) + "] " + str2;
            }
            if (this.bcG != null && this.bcG.so() && postData != null && postData.IF() != null) {
                str = postData.IF().getThumbUrl();
            }
        }
        return new String[]{str, str2};
    }

    public ForumData aPg() {
        return this.eEV;
    }

    public be aPh() {
        return this.eEW;
    }

    public String getForumId() {
        if (this.eEV == null) {
            return "";
        }
        return this.eEV.getId();
    }

    public bj aPi() {
        return this.bcG;
    }

    public List<bj> aPj() {
        return this.eFi;
    }

    public String getThreadId() {
        if (this.bcG == null) {
            return "";
        }
        return this.bcG.getId();
    }

    public ArrayList<PostData> aPk() {
        return this.eEX;
    }

    public ar qD() {
        return this.dNU;
    }

    public z aPl() {
        return this.eFd;
    }

    public au aPm() {
        return this.eFh;
    }

    public TwzhiboAnti aPn() {
        return this.eFm;
    }

    public void a(ar arVar, int i) {
        this.dNU.bJ(arVar.qx());
        this.dNU.bH(arVar.pm());
        this.dNU.bG(arVar.qu());
        this.dNU.bK(arVar.qy());
        this.dNU.bI(arVar.qw());
        if (i == 0) {
            this.dNU = arVar;
        } else if (i == 1) {
            this.dNU.bL(arVar.qz());
        } else if (i == 2) {
            this.dNU.bM(arVar.qA());
        }
    }

    public AntiData qn() {
        return this.WY;
    }

    public UserData getUserData() {
        return this.eFb;
    }

    public boolean nG() {
        return this.bcG.getIsMarked() != 0;
    }

    public void ac(boolean z) {
        if (this.bcG != null) {
            if (z) {
                this.bcG.setIsMarked(1);
            } else {
                this.bcG.setIsMarked(0);
            }
        }
    }

    public String nF() {
        if (this.bcG != null) {
            return this.bcG.rK();
        }
        return null;
    }

    public void pd(String str) {
        if (this.bcG != null) {
            this.bcG.cF(str);
        }
    }

    public boolean aPo() {
        return (this.bcG == null || this.bcG.rM() == null || this.bcG.rM().size() <= 0 || this.bcG.rM().get(0) == null || !this.bcG.rM().get(0).getIsSenior()) ? false : true;
    }

    public PostData aPp() {
        return this.eFA;
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                com.baidu.tieba.recapp.d.a.bhT().re(dataRes.asp_shown_info);
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
                nt(dataRes.is_new_url.intValue());
                this.eEV.parserProtobuf(dataRes.forum);
                this.eEW.parserProtobuf(dataRes.display_forum);
                this.bcG.setUserMap(this.userMap);
                this.bcG.a(dataRes.thread);
                this.bcG.bX(2);
                if (sa() != null) {
                    sa().setForumId(com.baidu.adp.lib.g.b.c(this.eEV.getId(), 0L));
                }
                this.eFc.a(dataRes.news_info);
                switch (this.eFc.Xp) {
                    case 1:
                        this.eFd.eNT = this.eFc;
                        break;
                    case 2:
                        this.eFd.eNU = this.eFc;
                        break;
                    case 3:
                        this.eFd.eNV = this.eFc;
                        break;
                    default:
                        this.eFd.eNU = this.eFc;
                        break;
                }
                this.eFh.a(dataRes.recommend_book);
                if (this.bcG != null && this.bcG.rp() != null) {
                    this.eFn = new VoteDataInfo();
                    this.eFn.parserProtobuf(aPi().rp());
                }
                List<Post> list2 = dataRes.post_list;
                if (list2 != null && list2.size() > 0) {
                    for (Post post : dataRes.post_list) {
                        PostData postData = new PostData();
                        postData.setUserMap(this.userMap);
                        postData.a(post, context);
                        postData.a(aPi().rr());
                        if (postData.bsz() == 1 && this.bcG.sg()) {
                            if (aPo()) {
                                postData.setPostType(0);
                            } else {
                                postData.setPostType(this.bcG.sf());
                            }
                        } else if (postData.bsz() == 1 && this.bcG != null && this.bcG.sn()) {
                            postData.setPostType(36);
                        } else if (postData.bsz() == 1 && this.bcG.st()) {
                            postData.setPostType(41);
                        } else if (postData.bsz() == 1 && this.bcG != null && this.bcG.so()) {
                            postData.setPostType(0);
                            postData.IF();
                            if (this.bcG.rz() == null || this.bcG.rz().size() == 0) {
                                JSONArray jSONArray = new JSONArray();
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("type", 0);
                                    jSONObject.put("text", "");
                                    jSONArray.put(jSONObject);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                postData.f(TbRichTextView.a(context, jSONArray, false));
                            } else {
                                postData.f(new TbRichText((Context) TbadkCoreApplication.getInst(), this.bcG.rz(), true));
                            }
                            this.eFt = postData;
                        } else if (postData.bsz() == 1 && this.bcG.su()) {
                            postData.setPostType(48);
                        }
                        this.eEX.add(postData);
                    }
                }
                if (dataRes.first_floor_post != null) {
                    this.eFA = new PostData();
                    this.eFA.setUserMap(this.userMap);
                    this.eFA.a(dataRes.first_floor_post, context);
                }
                this.dNU.a(dataRes.page);
                this.WY.parserProtobuf(dataRes.anti);
                this.eEY.a(dataRes.location);
                this.eEZ = dataRes.has_floor.intValue() == 1;
                if (dataRes.user != null) {
                    this.eFa = dataRes.user.is_manager.intValue();
                }
                this.eFb.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.eFe.add(muteUser);
                        }
                    }
                }
                this.bcG.bR(this.bcG.rt() > 0 ? this.bcG.rt() - 1 : 0);
                List<AppData> bhm = r.bho().bhm();
                if (bhm != null) {
                    bhm.clear();
                }
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        com.baidu.tieba.tbadkCore.data.l lVar = new com.baidu.tieba.tbadkCore.data.l();
                        lVar.c(app);
                        AppData bso = lVar.bso();
                        if (!this.eFl.contains(lVar) && bso.goods != null && (!StringUtils.isNull(bso.goods.user_name) || !StringUtils.isNull(bso.goods.lego_card))) {
                            this.eFl.add(lVar);
                            if (bhm != null) {
                                bhm.add(lVar.bso());
                            }
                        }
                    }
                }
                r.bho().bhn();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.eFb.getIsSelectTail());
                }
                this.eFm.parserProtobuf(dataRes.twzhibo_anti);
                this.eFo = dataRes.appeal_info;
                if (this.eFu != null) {
                    this.eFu.setForumId(getForumId());
                    this.eFu.setThreadId(getThreadId());
                    this.eFu.bF(0);
                    if (this.eFa > 0) {
                        this.eFu.bF(2);
                    }
                    if (this.bcG != null && this.bcG.getAuthor() != null) {
                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                        if (!TextUtils.isEmpty(currentAccount) && currentAccount.equals(this.bcG.getAuthor().getUserId())) {
                            this.eFu.bF(1);
                        }
                    }
                    this.eFu.a(dataRes.graffiti_rank_list_info);
                    this.eFu.WK = this.bcG.aac;
                }
                if (dataRes.god_card != null) {
                    this.eFg = new a();
                    this.eFg.a(dataRes.god_card);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.eFv = new h();
                    this.eFv.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.guess_like != null) {
                    this.eFw = new CardHListViewData();
                    this.eFw.parseProtobuf(dataRes.guess_like);
                }
                if (dataRes.feed_thread_list != null && dataRes.feed_thread_list.size() > 0) {
                    List<ThreadInfo> list3 = dataRes.feed_thread_list;
                    if (this.eFi == null) {
                        this.eFi = new ArrayList();
                    }
                    this.eFi.clear();
                    for (ThreadInfo threadInfo : list3) {
                        if (threadInfo != null) {
                            bj bjVar = new bj();
                            bjVar.a(threadInfo);
                            this.eFi.add(bjVar);
                        }
                    }
                    if (this.eFi != null && this.eFi.size() > 15) {
                        this.eFi = v.a(this.eFi, 0, 15);
                    }
                }
                this.eFj = dataRes.is_follow_current_channel.intValue();
                this.eFk = dataRes.switch_read_open.intValue();
                if (v.u(dataRes.repost_recommend_forum_list) > 0) {
                    if (this.eFp == null) {
                        this.eFp = new ArrayList();
                    }
                    for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                        be beVar = new be();
                        beVar.parserProtobuf(simpleForum);
                        this.eFp.add(beVar);
                    }
                }
                if (v.u(dataRes.from_forum_list) > 0) {
                    if (this.eFq == null) {
                        this.eFq = new ArrayList();
                    }
                    for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                        be beVar2 = new be();
                        beVar2.parserProtobuf(simpleForum2);
                        this.eFq.add(beVar2);
                    }
                }
                if (dataRes.top_agree_post_list != null && this.eFr != null) {
                    this.eFr.a(context, dataRes.top_agree_post_list);
                }
                if (this.eFx >= 0) {
                    this.eFx = dataRes.thread_freq_num.longValue();
                }
                this.eFy = new l();
                this.eFy.a(dataRes);
                this.eFz = dataRes.partial_visible_toast;
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }

    public CardHListViewData aPq() {
        return this.eFw;
    }

    public PostData aPr() {
        return this.eFt;
    }

    public PostData e(PostData postData) {
        this.eFt = postData;
        return postData;
    }

    public n aPs() {
        return this.eFr;
    }

    public int aPt() {
        return this.eFa;
    }

    public int aPu() {
        return this.dPp;
    }

    public void nt(int i) {
        this.dPp = i;
    }

    public List<MuteUser> aPv() {
        return this.eFe;
    }

    public ArrayList<com.baidu.tieba.tbadkCore.data.l> aPw() {
        return this.eFl;
    }

    public a aPx() {
        return this.eFg;
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> aPy() {
        return new ArrayList<>(this.eEX);
    }

    public String aPz() {
        return this.eFs;
    }

    public void pe(String str) {
        this.eFs = str;
    }

    public h aPA() {
        return this.eFv;
    }

    public int aPB() {
        return this.eFj;
    }

    public List<be> aPC() {
        return this.eFq;
    }

    public long aPD() {
        return this.eFx;
    }

    public l aPE() {
        return this.eFy;
    }

    public void a(l lVar) {
        this.eFy = lVar;
    }

    public boolean aPF() {
        return (aPi() == null || !aPi().so() || aPi().rS() == null) ? false : true;
    }
}

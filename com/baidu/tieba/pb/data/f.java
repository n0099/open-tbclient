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
    private int dOv;
    private h eEB;
    public CardHListViewData eEC;
    private long eED;
    private l eEE;
    public String eEF;
    private PostData eEG;
    private a eEm;
    private List<bj> eEo;
    private int eEp;
    private int eEq;
    private TwzhiboAnti eEs;
    private VoteDataInfo eEt;
    public AppealInfo eEu;
    private List<be> eEv;
    private List<be> eEw;
    public String eEy;
    private PostData eEz;
    private boolean eEl = true;
    private ArrayList<com.baidu.tieba.tbadkCore.data.l> eEr = new ArrayList<>();
    private ForumData eEb = new ForumData();
    private be eEc = new be();
    private bj bcJ = new bj();
    private ArrayList<PostData> eEd = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private ar dNa = new ar();
    private AntiData WY = new AntiData();
    private com.baidu.tbadk.data.h eEe = new com.baidu.tbadk.data.h();
    private int eEg = 0;
    private boolean eEf = false;
    private final UserData eEh = new UserData();
    private List<MuteUser> eEk = new ArrayList();
    private at eEi = new at();
    private au eEn = new au();
    private z eEj = new z();
    private af eEA = new af();
    private n eEx = new n();

    public boolean aOS() {
        return this.eEl;
    }

    public void iQ(boolean z) {
        this.eEl = z;
    }

    public af aOT() {
        return this.eEA;
    }

    public VoteDataInfo aOU() {
        return this.eEt;
    }

    public f() {
        this.dOv = 0;
        this.eEs = null;
        this.dOv = 0;
        this.eEs = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.eEd != null && this.eEd.size() > 0;
    }

    public p sa() {
        if (this.bcJ == null) {
            return null;
        }
        return this.bcJ.sa();
    }

    public String[] bM(Context context) {
        String str = null;
        String str2 = "";
        if (isValid()) {
            PostData postData = this.eEd.get(0);
            PreLoadImageInfo bst = postData.bst();
            str = bst != null ? bst.imgUrl : "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            str2 = postData.bZ(context);
            if (this.bcJ != null && this.bcJ.sm() != null && this.bcJ.sm().getGroup_id() != 0) {
                str2 = "[" + context.getString(d.l.photo_live_tips) + "] " + str2;
            }
            if (this.bcJ != null && this.bcJ.so() && postData != null && postData.IF() != null) {
                str = postData.IF().getThumbUrl();
            }
        }
        return new String[]{str, str2};
    }

    public ForumData aOV() {
        return this.eEb;
    }

    public be aOW() {
        return this.eEc;
    }

    public String getForumId() {
        if (this.eEb == null) {
            return "";
        }
        return this.eEb.getId();
    }

    public bj aOX() {
        return this.bcJ;
    }

    public List<bj> aOY() {
        return this.eEo;
    }

    public String getThreadId() {
        if (this.bcJ == null) {
            return "";
        }
        return this.bcJ.getId();
    }

    public ArrayList<PostData> aOZ() {
        return this.eEd;
    }

    public ar qD() {
        return this.dNa;
    }

    public z aPa() {
        return this.eEj;
    }

    public au aPb() {
        return this.eEn;
    }

    public TwzhiboAnti aPc() {
        return this.eEs;
    }

    public void a(ar arVar, int i) {
        this.dNa.bJ(arVar.qx());
        this.dNa.bH(arVar.pm());
        this.dNa.bG(arVar.qu());
        this.dNa.bK(arVar.qy());
        this.dNa.bI(arVar.qw());
        if (i == 0) {
            this.dNa = arVar;
        } else if (i == 1) {
            this.dNa.bL(arVar.qz());
        } else if (i == 2) {
            this.dNa.bM(arVar.qA());
        }
    }

    public AntiData qn() {
        return this.WY;
    }

    public UserData getUserData() {
        return this.eEh;
    }

    public boolean nG() {
        return this.bcJ.getIsMarked() != 0;
    }

    public void ac(boolean z) {
        if (this.bcJ != null) {
            if (z) {
                this.bcJ.setIsMarked(1);
            } else {
                this.bcJ.setIsMarked(0);
            }
        }
    }

    public String nF() {
        if (this.bcJ != null) {
            return this.bcJ.rK();
        }
        return null;
    }

    public void pb(String str) {
        if (this.bcJ != null) {
            this.bcJ.cF(str);
        }
    }

    public boolean aPd() {
        return (this.bcJ == null || this.bcJ.rM() == null || this.bcJ.rM().size() <= 0 || this.bcJ.rM().get(0) == null || !this.bcJ.rM().get(0).getIsSenior()) ? false : true;
    }

    public PostData aPe() {
        return this.eEG;
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                com.baidu.tieba.recapp.d.a.bhI().rc(dataRes.asp_shown_info);
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
                nr(dataRes.is_new_url.intValue());
                this.eEb.parserProtobuf(dataRes.forum);
                this.eEc.parserProtobuf(dataRes.display_forum);
                this.bcJ.setUserMap(this.userMap);
                this.bcJ.a(dataRes.thread);
                this.bcJ.bX(2);
                if (sa() != null) {
                    sa().setForumId(com.baidu.adp.lib.g.b.c(this.eEb.getId(), 0L));
                }
                this.eEi.a(dataRes.news_info);
                switch (this.eEi.Xp) {
                    case 1:
                        this.eEj.eMZ = this.eEi;
                        break;
                    case 2:
                        this.eEj.eNa = this.eEi;
                        break;
                    case 3:
                        this.eEj.eNb = this.eEi;
                        break;
                    default:
                        this.eEj.eNa = this.eEi;
                        break;
                }
                this.eEn.a(dataRes.recommend_book);
                if (this.bcJ != null && this.bcJ.rp() != null) {
                    this.eEt = new VoteDataInfo();
                    this.eEt.parserProtobuf(aOX().rp());
                }
                List<Post> list2 = dataRes.post_list;
                if (list2 != null && list2.size() > 0) {
                    for (Post post : dataRes.post_list) {
                        PostData postData = new PostData();
                        postData.setUserMap(this.userMap);
                        postData.a(post, context);
                        postData.a(aOX().rr());
                        if (postData.bso() == 1 && this.bcJ.sg()) {
                            if (aPd()) {
                                postData.setPostType(0);
                            } else {
                                postData.setPostType(this.bcJ.sf());
                            }
                        } else if (postData.bso() == 1 && this.bcJ != null && this.bcJ.sn()) {
                            postData.setPostType(36);
                        } else if (postData.bso() == 1 && this.bcJ.st()) {
                            postData.setPostType(41);
                        } else if (postData.bso() == 1 && this.bcJ != null && this.bcJ.so()) {
                            postData.setPostType(0);
                            postData.IF();
                            if (this.bcJ.rz() == null || this.bcJ.rz().size() == 0) {
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
                                postData.f(new TbRichText((Context) TbadkCoreApplication.getInst(), this.bcJ.rz(), true));
                            }
                            this.eEz = postData;
                        } else if (postData.bso() == 1 && this.bcJ.su()) {
                            postData.setPostType(48);
                        }
                        this.eEd.add(postData);
                    }
                }
                if (dataRes.first_floor_post != null) {
                    this.eEG = new PostData();
                    this.eEG.setUserMap(this.userMap);
                    this.eEG.a(dataRes.first_floor_post, context);
                }
                this.dNa.a(dataRes.page);
                this.WY.parserProtobuf(dataRes.anti);
                this.eEe.a(dataRes.location);
                this.eEf = dataRes.has_floor.intValue() == 1;
                if (dataRes.user != null) {
                    this.eEg = dataRes.user.is_manager.intValue();
                }
                this.eEh.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.eEk.add(muteUser);
                        }
                    }
                }
                this.bcJ.bR(this.bcJ.rt() > 0 ? this.bcJ.rt() - 1 : 0);
                List<AppData> bhb = r.bhd().bhb();
                if (bhb != null) {
                    bhb.clear();
                }
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        com.baidu.tieba.tbadkCore.data.l lVar = new com.baidu.tieba.tbadkCore.data.l();
                        lVar.c(app);
                        AppData bsd = lVar.bsd();
                        if (!this.eEr.contains(lVar) && bsd.goods != null && (!StringUtils.isNull(bsd.goods.user_name) || !StringUtils.isNull(bsd.goods.lego_card))) {
                            this.eEr.add(lVar);
                            if (bhb != null) {
                                bhb.add(lVar.bsd());
                            }
                        }
                    }
                }
                r.bhd().bhc();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.eEh.getIsSelectTail());
                }
                this.eEs.parserProtobuf(dataRes.twzhibo_anti);
                this.eEu = dataRes.appeal_info;
                if (this.eEA != null) {
                    this.eEA.setForumId(getForumId());
                    this.eEA.setThreadId(getThreadId());
                    this.eEA.bF(0);
                    if (this.eEg > 0) {
                        this.eEA.bF(2);
                    }
                    if (this.bcJ != null && this.bcJ.getAuthor() != null) {
                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                        if (!TextUtils.isEmpty(currentAccount) && currentAccount.equals(this.bcJ.getAuthor().getUserId())) {
                            this.eEA.bF(1);
                        }
                    }
                    this.eEA.a(dataRes.graffiti_rank_list_info);
                    this.eEA.WK = this.bcJ.aac;
                }
                if (dataRes.god_card != null) {
                    this.eEm = new a();
                    this.eEm.a(dataRes.god_card);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.eEB = new h();
                    this.eEB.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.guess_like != null) {
                    this.eEC = new CardHListViewData();
                    this.eEC.parseProtobuf(dataRes.guess_like);
                }
                if (dataRes.feed_thread_list != null && dataRes.feed_thread_list.size() > 0) {
                    List<ThreadInfo> list3 = dataRes.feed_thread_list;
                    if (this.eEo == null) {
                        this.eEo = new ArrayList();
                    }
                    this.eEo.clear();
                    for (ThreadInfo threadInfo : list3) {
                        if (threadInfo != null) {
                            bj bjVar = new bj();
                            bjVar.a(threadInfo);
                            this.eEo.add(bjVar);
                        }
                    }
                    if (this.eEo != null && this.eEo.size() > 15) {
                        this.eEo = v.a(this.eEo, 0, 15);
                    }
                }
                this.eEp = dataRes.is_follow_current_channel.intValue();
                this.eEq = dataRes.switch_read_open.intValue();
                if (v.u(dataRes.repost_recommend_forum_list) > 0) {
                    if (this.eEv == null) {
                        this.eEv = new ArrayList();
                    }
                    for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                        be beVar = new be();
                        beVar.parserProtobuf(simpleForum);
                        this.eEv.add(beVar);
                    }
                }
                if (v.u(dataRes.from_forum_list) > 0) {
                    if (this.eEw == null) {
                        this.eEw = new ArrayList();
                    }
                    for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                        be beVar2 = new be();
                        beVar2.parserProtobuf(simpleForum2);
                        this.eEw.add(beVar2);
                    }
                }
                if (dataRes.top_agree_post_list != null && this.eEx != null) {
                    this.eEx.a(context, dataRes.top_agree_post_list);
                }
                if (this.eED >= 0) {
                    this.eED = dataRes.thread_freq_num.longValue();
                }
                this.eEE = new l();
                this.eEE.a(dataRes);
                this.eEF = dataRes.partial_visible_toast;
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }

    public CardHListViewData aPf() {
        return this.eEC;
    }

    public PostData aPg() {
        return this.eEz;
    }

    public PostData e(PostData postData) {
        this.eEz = postData;
        return postData;
    }

    public n aPh() {
        return this.eEx;
    }

    public int aPi() {
        return this.eEg;
    }

    public int aPj() {
        return this.dOv;
    }

    public void nr(int i) {
        this.dOv = i;
    }

    public List<MuteUser> aPk() {
        return this.eEk;
    }

    public ArrayList<com.baidu.tieba.tbadkCore.data.l> aPl() {
        return this.eEr;
    }

    public a aPm() {
        return this.eEm;
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> aPn() {
        return new ArrayList<>(this.eEd);
    }

    public String aPo() {
        return this.eEy;
    }

    public void pc(String str) {
        this.eEy = str;
    }

    public h aPp() {
        return this.eEB;
    }

    public int aPq() {
        return this.eEp;
    }

    public List<be> aPr() {
        return this.eEw;
    }

    public long aPs() {
        return this.eED;
    }

    public l aPt() {
        return this.eEE;
    }

    public void a(l lVar) {
        this.eEE = lVar;
    }

    public boolean aPu() {
        return (aOX() == null || !aOX().so() || aOX().rS() == null) ? false : true;
    }
}

package com.baidu.tieba.pb.data;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
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
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.pb.pb.main.es;
import com.baidu.tieba.tbadkCore.data.AppData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.usermute.MuteUser;
import com.baidu.tieba.vote.VoteDataInfo;
import com.baidu.tieba.w;
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
    private int doe;
    private a eiD;
    private List<bl> eiF;
    private int eiG;
    private int eiH;
    private TwzhiboAnti eiJ;
    private VoteDataInfo eiK;
    public AppealInfo eiL;
    private List<be> eiM;
    private List<be> eiN;
    public String eiP;
    private PostData eiQ;
    private h eiS;
    public CardHListViewData eiT;
    private long eiU;
    private m eiV;
    public String eiW;
    private PostData eiX;
    private boolean eiC = true;
    private ArrayList<com.baidu.tieba.tbadkCore.data.o> eiI = new ArrayList<>();
    private ForumData eis = new ForumData();
    private be eit = new be();
    private bl aYA = new bl();
    private ArrayList<PostData> eiu = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private ar dmJ = new ar();
    private AntiData Wa = new AntiData();
    private com.baidu.tbadk.data.g eiv = new com.baidu.tbadk.data.g();
    private int eix = 0;
    private boolean eiw = false;
    private final UserData eiy = new UserData();
    private List<MuteUser> eiB = new ArrayList();
    private at eiz = new at();
    private au eiE = new au();
    private es eiA = new es();
    private af eiR = new af();
    private o eiO = new o();

    public boolean aIw() {
        return this.eiC;
    }

    public void hX(boolean z) {
        this.eiC = z;
    }

    public af aIx() {
        return this.eiR;
    }

    public VoteDataInfo aIy() {
        return this.eiK;
    }

    public f() {
        this.doe = 0;
        this.eiJ = null;
        this.doe = 0;
        this.eiJ = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.eiu != null && this.eiu.size() > 0;
    }

    public p rT() {
        if (this.aYA == null) {
            return null;
        }
        return this.aYA.rT();
    }

    public String[] bJ(Context context) {
        String str = null;
        String str2 = "";
        if (isValid()) {
            PostData postData = this.eiu.get(0);
            PreLoadImageInfo bil = postData.bil();
            str = bil != null ? bil.imgUrl : "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            str2 = postData.bU(context);
            if (this.aYA != null && this.aYA.sf() != null && this.aYA.sf().getGroup_id() != 0) {
                str2 = "[" + context.getString(w.l.photo_live_tips) + "] " + str2;
            }
            if (this.aYA != null && this.aYA.sh() && postData != null && postData.HH() != null) {
                str = postData.HH().getThumbUrl();
            }
        }
        return new String[]{str, str2};
    }

    public ForumData aIz() {
        return this.eis;
    }

    public be aIA() {
        return this.eit;
    }

    public String getForumId() {
        if (this.eis == null) {
            return "";
        }
        return this.eis.getId();
    }

    public bl aIB() {
        return this.aYA;
    }

    public List<bl> aIC() {
        return this.eiF;
    }

    public String getThreadId() {
        if (this.aYA == null) {
            return "";
        }
        return this.aYA.getId();
    }

    public ArrayList<PostData> aID() {
        return this.eiu;
    }

    public ar qx() {
        return this.dmJ;
    }

    public es aIE() {
        return this.eiA;
    }

    public au aIF() {
        return this.eiE;
    }

    public TwzhiboAnti aIG() {
        return this.eiJ;
    }

    public void a(ar arVar, int i) {
        this.dmJ.bI(arVar.qr());
        this.dmJ.bG(arVar.ph());
        this.dmJ.bF(arVar.qo());
        this.dmJ.bJ(arVar.qs());
        this.dmJ.bH(arVar.qq());
        if (i == 0) {
            this.dmJ = arVar;
        } else if (i == 1) {
            this.dmJ.bK(arVar.qt());
        } else if (i == 2) {
            this.dmJ.bL(arVar.qu());
        }
    }

    public AntiData qh() {
        return this.Wa;
    }

    public UserData getUserData() {
        return this.eiy;
    }

    public boolean nD() {
        return this.aYA.getIsMarked() != 0;
    }

    public void ac(boolean z) {
        if (this.aYA != null) {
            if (z) {
                this.aYA.setIsMarked(1);
            } else {
                this.aYA.setIsMarked(0);
            }
        }
    }

    public String nC() {
        if (this.aYA != null) {
            return this.aYA.rD();
        }
        return null;
    }

    public void nK(String str) {
        if (this.aYA != null) {
            this.aYA.cv(str);
        }
    }

    public boolean aIH() {
        return (this.aYA == null || this.aYA.rF() == null || this.aYA.rF().size() <= 0 || this.aYA.rF().get(0) == null || !this.aYA.rF().get(0).getIsSenior()) ? false : true;
    }

    public PostData aII() {
        return this.eiX;
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                com.baidu.tieba.recapp.d.a.ban().pG(dataRes.asp_shown_info);
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
                mv(dataRes.is_new_url.intValue());
                this.eis.parserProtobuf(dataRes.forum);
                this.eit.parserProtobuf(dataRes.display_forum);
                this.aYA.setUserMap(this.userMap);
                this.aYA.a(dataRes.thread);
                this.aYA.bW(2);
                if (rT() != null) {
                    rT().setForumId(com.baidu.adp.lib.g.b.c(this.eis.getId(), 0L));
                }
                this.eiz.a(dataRes.news_info);
                switch (this.eiz.Ws) {
                    case 1:
                        this.eiA.erc = this.eiz;
                        break;
                    case 2:
                        this.eiA.erd = this.eiz;
                        break;
                    case 3:
                        this.eiA.ere = this.eiz;
                        break;
                    default:
                        this.eiA.erd = this.eiz;
                        break;
                }
                this.eiE.a(dataRes.recommend_book);
                if (this.aYA != null && this.aYA.rj() != null) {
                    this.eiK = new VoteDataInfo();
                    this.eiK.parserProtobuf(aIB().rj());
                }
                List<Post> list2 = dataRes.post_list;
                if (list2 != null && list2.size() > 0) {
                    for (Post post : dataRes.post_list) {
                        PostData postData = new PostData();
                        postData.setUserMap(this.userMap);
                        postData.a(post, context);
                        postData.a(aIB().rk());
                        if (postData.big() == 1 && this.aYA.rZ()) {
                            if (aIH()) {
                                postData.setPostType(0);
                            } else {
                                postData.setPostType(this.aYA.rY());
                            }
                        } else if (postData.big() == 1 && this.aYA != null && this.aYA.sg()) {
                            postData.setPostType(36);
                        } else if (postData.big() == 1 && this.aYA.sm()) {
                            postData.setPostType(41);
                        } else if (postData.big() == 1 && this.aYA != null && this.aYA.sh()) {
                            postData.setPostType(0);
                            postData.HH();
                            if (this.aYA.rt() == null || this.aYA.rt().size() == 0) {
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
                                postData.f(new TbRichText((Context) TbadkCoreApplication.m9getInst(), this.aYA.rt(), true));
                            }
                            this.eiQ = postData;
                        } else if (postData.big() == 1 && this.aYA.sn()) {
                            postData.setPostType(48);
                        }
                        this.eiu.add(postData);
                    }
                }
                if (dataRes.first_floor_post != null) {
                    this.eiX = new PostData();
                    this.eiX.setUserMap(this.userMap);
                    this.eiX.a(dataRes.first_floor_post, context);
                }
                this.dmJ.a(dataRes.page);
                this.Wa.parserProtobuf(dataRes.anti);
                this.eiv.a(dataRes.location);
                this.eiw = dataRes.has_floor.intValue() == 1;
                if (dataRes.user != null) {
                    this.eix = dataRes.user.is_manager.intValue();
                }
                this.eiy.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.eiB.add(muteUser);
                        }
                    }
                }
                this.aYA.bQ(this.aYA.rn() > 0 ? this.aYA.rn() - 1 : 0);
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        com.baidu.tieba.tbadkCore.data.o oVar = new com.baidu.tieba.tbadkCore.data.o();
                        oVar.c(app);
                        AppData bhV = oVar.bhV();
                        if (!this.eiI.contains(oVar) && bhV.goods != null && (!StringUtils.isNull(bhV.goods.user_name) || !StringUtils.isNull(bhV.goods.lego_card))) {
                            this.eiI.add(oVar);
                        }
                    }
                }
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.eiy.getIsSelectTail());
                }
                this.eiJ.parserProtobuf(dataRes.twzhibo_anti);
                this.eiL = dataRes.appeal_info;
                if (this.eiR != null) {
                    this.eiR.setForumId(getForumId());
                    this.eiR.setThreadId(getThreadId());
                    this.eiR.bE(0);
                    if (this.eix > 0) {
                        this.eiR.bE(2);
                    }
                    if (this.aYA != null && this.aYA.getAuthor() != null) {
                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                        if (!TextUtils.isEmpty(currentAccount) && currentAccount.equals(this.aYA.getAuthor().getUserId())) {
                            this.eiR.bE(1);
                        }
                    }
                    this.eiR.a(dataRes.graffiti_rank_list_info);
                    this.eiR.VM = this.aYA.Zg;
                }
                if (dataRes.god_card != null) {
                    this.eiD = new a();
                    this.eiD.a(dataRes.god_card);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.eiS = new h();
                    this.eiS.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.guess_like != null) {
                    this.eiT = new CardHListViewData();
                    this.eiT.parseProtobuf(dataRes.guess_like);
                }
                if (dataRes.feed_thread_list != null && dataRes.feed_thread_list.size() > 0) {
                    List<ThreadInfo> list3 = dataRes.feed_thread_list;
                    if (this.eiF == null) {
                        this.eiF = new ArrayList();
                    }
                    this.eiF.clear();
                    for (ThreadInfo threadInfo : list3) {
                        if (threadInfo != null) {
                            bl blVar = new bl();
                            blVar.a(threadInfo);
                            this.eiF.add(blVar);
                        }
                    }
                    if (this.eiF != null && this.eiF.size() > 15) {
                        this.eiF = x.a(this.eiF, 0, 15);
                    }
                }
                this.eiG = dataRes.is_follow_current_channel.intValue();
                this.eiH = dataRes.switch_read_open.intValue();
                if (x.q(dataRes.repost_recommend_forum_list) > 0) {
                    if (this.eiM == null) {
                        this.eiM = new ArrayList();
                    }
                    for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                        be beVar = new be();
                        beVar.parserProtobuf(simpleForum);
                        this.eiM.add(beVar);
                    }
                }
                if (x.q(dataRes.from_forum_list) > 0) {
                    if (this.eiN == null) {
                        this.eiN = new ArrayList();
                    }
                    for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                        be beVar2 = new be();
                        beVar2.parserProtobuf(simpleForum2);
                        this.eiN.add(beVar2);
                    }
                }
                if (dataRes.top_agree_post_list != null && this.eiO != null) {
                    this.eiO.a(context, dataRes.top_agree_post_list);
                }
                if (this.eiU >= 0) {
                    this.eiU = dataRes.thread_freq_num.longValue();
                }
                this.eiV = new m();
                this.eiV.a(dataRes);
                this.eiW = dataRes.partial_visible_toast;
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }

    public CardHListViewData aIJ() {
        return this.eiT;
    }

    public PostData aIK() {
        return this.eiQ;
    }

    public PostData d(PostData postData) {
        this.eiQ = postData;
        return postData;
    }

    public o aIL() {
        return this.eiO;
    }

    public int aIM() {
        return this.eix;
    }

    public int aIN() {
        return this.doe;
    }

    public void mv(int i) {
        this.doe = i;
    }

    public List<MuteUser> aIO() {
        return this.eiB;
    }

    public ArrayList<com.baidu.tieba.tbadkCore.data.o> aIP() {
        return this.eiI;
    }

    public a aIQ() {
        return this.eiD;
    }

    public ArrayList<v> aIR() {
        return new ArrayList<>(this.eiu);
    }

    public String aIS() {
        return this.eiP;
    }

    public void nL(String str) {
        this.eiP = str;
    }

    public h aIT() {
        return this.eiS;
    }

    public int aIU() {
        return this.eiG;
    }

    public boolean aIV() {
        return this.eiH == 1;
    }

    public List<be> aIW() {
        return this.eiN;
    }

    public long aIX() {
        return this.eiU;
    }

    public m aIY() {
        return this.eiV;
    }

    public void a(m mVar) {
        this.eiV = mVar;
    }
}

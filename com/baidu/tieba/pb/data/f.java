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
import com.baidu.tbadk.core.data.ap;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.p;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.pb.pb.main.du;
import com.baidu.tieba.tbadkCore.data.AppData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.data.o;
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
import tbclient.SimpleUser;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes.dex */
public class f {
    private int doH;
    public AppealInfo eiA;
    public String eiB;
    private PostData eiC;
    private h eiE;
    public CardHListViewData eiF;
    private PostData eii;
    private a eis;
    private List<bi> eiu;
    private int eiv;
    private int eiw;
    private TwzhiboAnti eiy;
    private VoteDataInfo eiz;
    private boolean eir = true;
    private ArrayList<o> eix = new ArrayList<>();
    private ForumData eih = new ForumData();
    private bi bck = new bi();
    private ArrayList<PostData> eij = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private ap dni = new ap();
    private AntiData WN = new AntiData();
    private com.baidu.tbadk.data.g eik = new com.baidu.tbadk.data.g();
    private int eim = 0;
    private boolean eil = false;
    private final UserData ein = new UserData();
    private List<MuteUser> eiq = new ArrayList();
    private ar eio = new ar();
    private as eit = new as();
    private du eip = new du();
    private af eiD = new af();

    public boolean aKu() {
        return this.eir;
    }

    public void ij(boolean z) {
        this.eir = z;
    }

    public af aKv() {
        return this.eiD;
    }

    public VoteDataInfo aKw() {
        return this.eiz;
    }

    public f() {
        this.doH = 0;
        this.eiy = null;
        this.doH = 0;
        this.eiy = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.eij != null && this.eij.size() > 0;
    }

    public p sN() {
        if (this.bck == null) {
            return null;
        }
        return this.bck.sN();
    }

    public String[] bD(Context context) {
        String str = null;
        String str2 = "";
        if (isValid()) {
            PostData postData = this.eij.get(0);
            PreLoadImageInfo bju = postData.bju();
            str = bju != null ? bju.imgUrl : "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            str2 = postData.bN(context);
            if (this.bck != null && this.bck.sZ() != null && this.bck.sZ().getGroup_id() != 0) {
                str2 = "[" + context.getString(w.l.photo_live_tips) + "] " + str2;
            }
            if (this.bck != null && this.bck.tb() && postData != null && postData.Iy() != null) {
                str = postData.Iy().qP();
            }
        }
        return new String[]{str, str2};
    }

    public ForumData aKx() {
        return this.eih;
    }

    public String getForumId() {
        if (this.eih == null) {
            return "";
        }
        return this.eih.getId();
    }

    public bi aKy() {
        return this.bck;
    }

    public List<bi> aKz() {
        return this.eiu;
    }

    public String getThreadId() {
        if (this.bck == null) {
            return "";
        }
        return this.bck.getId();
    }

    public ArrayList<PostData> aKA() {
        return this.eij;
    }

    public ap rr() {
        return this.dni;
    }

    public du aKB() {
        return this.eip;
    }

    public as aKC() {
        return this.eit;
    }

    public TwzhiboAnti aKD() {
        return this.eiy;
    }

    public void a(ap apVar, int i) {
        this.dni.bK(apVar.rl());
        this.dni.bI(apVar.pI());
        this.dni.bH(apVar.ri());
        this.dni.bL(apVar.rm());
        this.dni.bJ(apVar.rk());
        if (i == 0) {
            this.dni = apVar;
        } else if (i == 1) {
            this.dni.bM(apVar.rn());
        } else if (i == 2) {
            this.dni.bN(apVar.ro());
        }
    }

    public AntiData rb() {
        return this.WN;
    }

    public UserData getUserData() {
        return this.ein;
    }

    public boolean oe() {
        return this.bck.getIsMarked() != 0;
    }

    public void ae(boolean z) {
        if (this.bck != null) {
            if (z) {
                this.bck.setIsMarked(1);
            } else {
                this.bck.setIsMarked(0);
            }
        }
    }

    public String od() {
        if (this.bck != null) {
            return this.bck.sx();
        }
        return null;
    }

    public void ns(String str) {
        if (this.bck != null) {
            this.bck.cy(str);
        }
    }

    public PostData aKE() {
        return this.eii;
    }

    public boolean aKF() {
        return (this.bck == null || this.bck.sz() == null || this.bck.sz().size() <= 0 || this.bck.sz().get(0) == null || !this.bck.sz().get(0).getIsSenior()) ? false : true;
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                com.baidu.tieba.recapp.d.a.bbv().pt(dataRes.asp_shown_info);
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
                mo(dataRes.is_new_url.intValue());
                this.eih.parserProtobuf(dataRes.forum);
                this.bck.setUserMap(this.userMap);
                this.bck.a(dataRes.thread);
                this.bck.bX(2);
                if (sN() != null) {
                    sN().setForumId(com.baidu.adp.lib.g.b.c(this.eih.getId(), 0L));
                }
                this.eio.a(dataRes.news_info);
                switch (this.eio.Xf) {
                    case 1:
                        this.eip.epr = this.eio;
                        break;
                    case 2:
                        this.eip.eps = this.eio;
                        break;
                    case 3:
                        this.eip.ept = this.eio;
                        break;
                    default:
                        this.eip.eps = this.eio;
                        break;
                }
                this.eit.a(dataRes.recommend_book);
                if (this.bck != null && this.bck.sd() != null) {
                    this.eiz = new VoteDataInfo();
                    this.eiz.parserProtobuf(aKy().sd());
                }
                List<Post> list2 = dataRes.post_list;
                if (list2 != null && list2.size() > 0) {
                    for (Post post : dataRes.post_list) {
                        PostData postData = new PostData();
                        postData.setUserMap(this.userMap);
                        postData.a(post, context);
                        postData.a(aKy().se());
                        if (postData.bjp() == 1 && this.bck.sT()) {
                            if (aKF()) {
                                postData.setPostType(0);
                            } else {
                                postData.setPostType(this.bck.sS());
                            }
                        } else if (postData.bjp() == 1 && this.bck != null && this.bck.ta()) {
                            postData.setPostType(36);
                        } else if (postData.bjp() == 1 && this.bck.tg()) {
                            postData.setPostType(41);
                        } else if (postData.bjp() == 1 && this.bck != null && this.bck.tb()) {
                            postData.setPostType(0);
                            postData.Iy();
                            if (this.bck.sn() == null || this.bck.sn().size() == 0) {
                                JSONArray jSONArray = new JSONArray();
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("type", 0);
                                    jSONObject.put("text", postData.getTitle());
                                    jSONArray.put(jSONObject);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                postData.f(TbRichTextView.a(context, jSONArray, false));
                            } else {
                                postData.f(new TbRichText((Context) TbadkCoreApplication.m9getInst(), this.bck.sn(), true));
                            }
                            this.eiC = postData;
                        } else if (postData.bjp() == 1 && this.bck.th()) {
                            postData.setPostType(48);
                        }
                        this.eij.add(postData);
                    }
                }
                this.dni.a(dataRes.page);
                this.WN.parserProtobuf(dataRes.anti);
                this.eik.a(dataRes.location);
                this.eil = dataRes.has_floor.intValue() == 1;
                if (dataRes.user != null) {
                    this.eim = dataRes.user.is_manager.intValue();
                }
                this.ein.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.eiq.add(muteUser);
                        }
                    }
                }
                this.bck.bS(this.bck.sh() > 0 ? this.bck.sh() - 1 : 0);
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        o oVar = new o();
                        oVar.c(app);
                        AppData bjd = oVar.bjd();
                        if (!this.eix.contains(oVar) && bjd.goods != null && (!StringUtils.isNull(bjd.goods.user_name) || !StringUtils.isNull(bjd.goods.lego_card))) {
                            this.eix.add(oVar);
                        }
                    }
                }
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.ein.getIsSelectTail());
                }
                this.eiy.parserProtobuf(dataRes.twzhibo_anti);
                this.eiA = dataRes.appeal_info;
                if (this.eiD != null) {
                    this.eiD.setForumId(getForumId());
                    this.eiD.setThreadId(getThreadId());
                    this.eiD.bG(0);
                    if (this.eim > 0) {
                        this.eiD.bG(2);
                    }
                    if (this.bck != null && this.bck.getAuthor() != null) {
                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                        if (!TextUtils.isEmpty(currentAccount) && currentAccount.equals(this.bck.getAuthor().getUserId())) {
                            this.eiD.bG(1);
                        }
                    }
                    this.eiD.a(dataRes.graffiti_rank_list_info);
                }
                if (dataRes.god_card != null) {
                    this.eis = new a();
                    this.eis.a(dataRes.god_card);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.eiE = new h();
                    this.eiE.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.guess_like != null) {
                    this.eiF = new CardHListViewData();
                    this.eiF.parseProtobuf(dataRes.guess_like);
                }
                if (dataRes.feed_thread_list != null && dataRes.feed_thread_list.size() > 0) {
                    List<ThreadInfo> list3 = dataRes.feed_thread_list;
                    if (this.eiu == null) {
                        this.eiu = new ArrayList();
                    }
                    this.eiu.clear();
                    for (ThreadInfo threadInfo : list3) {
                        if (threadInfo != null) {
                            bi biVar = new bi();
                            biVar.a(threadInfo);
                            this.eiu.add(biVar);
                        }
                    }
                    if (this.eiu != null && this.eiu.size() > 15) {
                        this.eiu = x.a(this.eiu, 0, 15);
                    }
                }
                this.eiv = dataRes.is_follow_current_channel.intValue();
                this.eiw = dataRes.switch_read_open.intValue();
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }

    public CardHListViewData aKG() {
        return this.eiF;
    }

    public PostData aKH() {
        return this.eiC;
    }

    public PostData a(PostData postData) {
        this.eiC = postData;
        return postData;
    }

    public int aKI() {
        return this.eim;
    }

    public int aKJ() {
        return this.doH;
    }

    public void mo(int i) {
        this.doH = i;
    }

    public List<MuteUser> aKK() {
        return this.eiq;
    }

    public ArrayList<o> aKL() {
        return this.eix;
    }

    public a aKM() {
        return this.eis;
    }

    public ArrayList<v> aKN() {
        return new ArrayList<>(this.eij);
    }

    public String aKO() {
        return this.eiB;
    }

    public void nt(String str) {
        this.eiB = str;
    }

    public h aKP() {
        return this.eiE;
    }

    public int aKQ() {
        return this.eiv;
    }

    public boolean aKR() {
        return this.eiw == 1;
    }
}

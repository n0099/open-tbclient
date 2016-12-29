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
import com.baidu.tbadk.core.data.ae;
import com.baidu.tbadk.core.data.an;
import com.baidu.tbadk.core.data.ap;
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.ah;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.pb.pb.main.Cdo;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.data.p;
import com.baidu.tieba.tbadkCore.data.q;
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
import tbclient.SimpleUser;
import tbclient.User;
/* loaded from: classes.dex */
public class f {
    public String aRT;
    private a dWH;
    private TwzhiboAnti dWK;
    private VoteDataInfo dWL;
    public AppealInfo dWM;
    private q dWN;
    private h dWP;
    public CardHListViewData dWQ;
    private q dWx;
    private int dem;
    private boolean dWG = true;
    private ArrayList<p> dWJ = new ArrayList<>();
    private ForumData dWw = new ForumData();
    private bg beB = new bg();
    private ArrayList<q> dWy = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private an dcN = new an();
    private AntiData Sc = new AntiData();
    private com.baidu.tbadk.data.g dWz = new com.baidu.tbadk.data.g();
    private int dWB = 0;
    private boolean dWA = false;
    private final UserData dWC = new UserData();
    private List<MuteUser> dWF = new ArrayList();
    private ap dWD = new ap();
    private aq dWI = new aq();
    private Cdo dWE = new Cdo();
    private ae dWO = new ae();

    public boolean aIh() {
        return this.dWG;
    }

    public void hW(boolean z) {
        this.dWG = z;
    }

    public ae aIi() {
        return this.dWO;
    }

    public VoteDataInfo aIj() {
        return this.dWL;
    }

    public f() {
        this.dem = 0;
        this.dWK = null;
        this.dem = 0;
        this.dWK = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.dWy != null && this.dWy.size() > 0;
    }

    public String[] bh(Context context) {
        String str = null;
        String str2 = "";
        if (isValid()) {
            q qVar = this.dWy.get(0);
            ah bgf = qVar.bgf();
            str = bgf != null ? bgf.imgUrl : "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            str2 = qVar.bt(context);
            if (this.beB != null && this.beB.so() != null && this.beB.so().getGroup_id() != 0) {
                str2 = "[" + context.getString(r.j.msglist_live) + "] " + str2;
            }
            if (this.beB != null && this.beB.sq() && qVar != null && qVar.HH() != null) {
                str = qVar.HH().qh();
            }
        }
        return new String[]{str, str2};
    }

    public ForumData aIk() {
        return this.dWw;
    }

    public String getForumId() {
        if (this.dWw == null) {
            return "";
        }
        return this.dWw.getId();
    }

    public bg aIl() {
        return this.beB;
    }

    public String getThreadId() {
        if (this.beB == null) {
            return "";
        }
        return this.beB.getId();
    }

    public ArrayList<q> aIm() {
        return this.dWy;
    }

    public an getPage() {
        return this.dcN;
    }

    public Cdo aIn() {
        return this.dWE;
    }

    public aq aIo() {
        return this.dWI;
    }

    public TwzhiboAnti aIp() {
        return this.dWK;
    }

    public void a(an anVar, int i) {
        this.dcN.bN(anVar.qC());
        this.dcN.bL(anVar.pd());
        this.dcN.bK(anVar.qz());
        this.dcN.bO(anVar.qD());
        this.dcN.bM(anVar.qB());
        if (i == 0) {
            this.dcN = anVar;
        } else if (i == 1) {
            this.dcN.bP(anVar.qE());
        } else if (i == 2) {
            this.dcN.bQ(anVar.qF());
        }
    }

    public AntiData qt() {
        return this.Sc;
    }

    public UserData getUserData() {
        return this.dWC;
    }

    public boolean nz() {
        return this.beB.getIsMarked() != 0;
    }

    public void ad(boolean z) {
        if (this.beB != null) {
            if (z) {
                this.beB.setIsMarked(1);
            } else {
                this.beB.setIsMarked(0);
            }
        }
    }

    public String ny() {
        if (this.beB != null) {
            return this.beB.rO();
        }
        return null;
    }

    public void nM(String str) {
        if (this.beB != null) {
            this.beB.cA(str);
        }
    }

    public q aIq() {
        return this.dWx;
    }

    public boolean aIr() {
        return (this.beB == null || this.beB.rQ() == null || this.beB.rQ().size() <= 0 || this.beB.rQ().get(0) == null || !this.beB.rQ().get(0).getIsSenior()) ? false : true;
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                com.baidu.tieba.recapp.c.a.aYn().pA(dataRes.asp_shown_info);
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
                lE(dataRes.is_new_url.intValue());
                this.dWw.parserProtobuf(dataRes.forum);
                this.beB.setUserMap(this.userMap);
                this.beB.a(dataRes.thread);
                this.dWD.a(dataRes.news_info);
                switch (this.dWD.Ss) {
                    case 1:
                        this.dWE.edb = this.dWD;
                        break;
                    case 2:
                        this.dWE.edc = this.dWD;
                        break;
                    case 3:
                        this.dWE.edd = this.dWD;
                        break;
                    default:
                        this.dWE.edc = this.dWD;
                        break;
                }
                this.dWI.a(dataRes.recommend_book);
                if (this.beB != null && this.beB.ru() != null) {
                    this.dWL = new VoteDataInfo();
                    this.dWL.parserProtobuf(aIl().ru());
                }
                List<Post> list2 = dataRes.post_list;
                if (list2 != null && list2.size() > 0) {
                    for (Post post : dataRes.post_list) {
                        q qVar = new q();
                        qVar.setUserMap(this.userMap);
                        qVar.a(post, context);
                        qVar.a(aIl().rv());
                        if (qVar.bga() == 1 && this.beB.si()) {
                            if (aIr()) {
                                qVar.setPostType(0);
                            } else {
                                qVar.setPostType(this.beB.sh());
                            }
                        } else if (qVar.bga() == 1 && this.beB != null && this.beB.sp()) {
                            qVar.setPostType(36);
                        } else if (qVar.bga() == 1 && this.beB.sv()) {
                            qVar.setPostType(41);
                        } else if (qVar.bga() == 1 && this.beB != null && this.beB.sq()) {
                            qVar.setPostType(0);
                            qVar.HH();
                            if (this.beB.rD() == null || this.beB.rD().size() == 0) {
                                JSONArray jSONArray = new JSONArray();
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("type", 0);
                                    jSONObject.put("text", qVar.getTitle());
                                    jSONArray.put(jSONObject);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                qVar.f(TbRichTextView.a(context, jSONArray, false));
                            } else {
                                qVar.f(new com.baidu.tbadk.widget.richText.a((Context) TbadkCoreApplication.m9getInst(), this.beB.rD(), true));
                            }
                            this.dWN = qVar;
                        } else if (qVar.bga() == 1 && this.beB.sw()) {
                            qVar.setPostType(48);
                        }
                        this.dWy.add(qVar);
                    }
                }
                this.dcN.a(dataRes.page);
                this.Sc.parserProtobuf(dataRes.anti);
                this.dWz.a(dataRes.location);
                this.dWA = dataRes.has_floor.intValue() == 1;
                if (dataRes.user != null) {
                    this.dWB = dataRes.user.is_manager.intValue();
                }
                this.dWC.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.dWF.add(muteUser);
                        }
                    }
                }
                this.beB.bV(this.beB.rx() > 0 ? this.beB.rx() - 1 : 0);
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        p pVar = new p();
                        pVar.c(app);
                        com.baidu.tieba.tbadkCore.data.e bfO = pVar.bfO();
                        if (!this.dWJ.contains(pVar) && bfO.ffS != null && (!StringUtils.isNull(bfO.ffS.user_name) || !StringUtils.isNull(bfO.ffS.lego_card))) {
                            this.dWJ.add(pVar);
                        }
                    }
                }
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.dWC.getIsSelectTail());
                }
                this.dWK.parserProtobuf(dataRes.twzhibo_anti);
                this.dWM = dataRes.appeal_info;
                if (this.dWO != null) {
                    this.dWO.setForumId(getForumId());
                    this.dWO.setThreadId(getThreadId());
                    this.dWO.bJ(0);
                    if (this.dWB > 0) {
                        this.dWO.bJ(2);
                    }
                    if (this.beB != null && this.beB.getAuthor() != null) {
                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                        if (!TextUtils.isEmpty(currentAccount) && currentAccount.equals(this.beB.getAuthor().getUserId())) {
                            this.dWO.bJ(1);
                        }
                    }
                    this.dWO.a(dataRes.graffiti_rank_list_info);
                }
                if (dataRes.god_card != null) {
                    this.dWH = new a();
                    this.dWH.a(dataRes.god_card);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.dWP = new h();
                    this.dWP.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.guess_like != null) {
                    this.dWQ = new CardHListViewData();
                    this.dWQ.parseProtobuf(dataRes.guess_like);
                }
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }

    public CardHListViewData aIs() {
        return this.dWQ;
    }

    public q aIt() {
        return this.dWN;
    }

    public q a(q qVar) {
        this.dWN = qVar;
        return qVar;
    }

    public int aIu() {
        return this.dWB;
    }

    public int aIv() {
        return this.dem;
    }

    public void lE(int i) {
        this.dem = i;
    }

    public List<MuteUser> aIw() {
        return this.dWF;
    }

    public ArrayList<p> aIx() {
        return this.dWJ;
    }

    public a aIy() {
        return this.dWH;
    }

    public ArrayList<v> aIz() {
        return new ArrayList<>(this.dWy);
    }

    public String Li() {
        return this.aRT;
    }

    public void hi(String str) {
        this.aRT = str;
    }

    public h aIA() {
        return this.dWP;
    }
}

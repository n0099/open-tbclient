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
import com.baidu.tbadk.core.data.ao;
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.pb.pb.main.dv;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.data.AppData;
import com.baidu.tieba.tbadkCore.data.o;
import com.baidu.tieba.tbadkCore.data.p;
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
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes.dex */
public class f {
    private int dlx;
    private a efA;
    private List<bh> efC;
    private int efD;
    private TwzhiboAnti efF;
    private VoteDataInfo efG;
    public AppealInfo efH;
    public String efI;
    private p efJ;
    private h efL;
    public CardHListViewData efM;
    private p efq;
    private boolean efz = true;
    private ArrayList<o> efE = new ArrayList<>();
    private ForumData efp = new ForumData();
    private bh aVi = new bh();
    private ArrayList<p> efr = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private ao djY = new ao();
    private AntiData Rl = new AntiData();
    private com.baidu.tbadk.data.g efs = new com.baidu.tbadk.data.g();
    private int efu = 0;
    private boolean eft = false;
    private final UserData efv = new UserData();
    private List<MuteUser> efy = new ArrayList();
    private aq efw = new aq();
    private ar efB = new ar();
    private dv efx = new dv();
    private af efK = new af();

    public boolean aJV() {
        return this.efz;
    }

    public void ih(boolean z) {
        this.efz = z;
    }

    public af aJW() {
        return this.efK;
    }

    public VoteDataInfo aJX() {
        return this.efG;
    }

    public f() {
        this.dlx = 0;
        this.efF = null;
        this.dlx = 0;
        this.efF = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.efr != null && this.efr.size() > 0;
    }

    public String[] bm(Context context) {
        String str = null;
        String str2 = "";
        if (isValid()) {
            p pVar = this.efr.get(0);
            PreLoadImageInfo bhV = pVar.bhV();
            str = bhV != null ? bhV.imgUrl : "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            str2 = pVar.bv(context);
            if (this.aVi != null && this.aVi.sg() != null && this.aVi.sg().getGroup_id() != 0) {
                str2 = "[" + context.getString(r.l.msglist_live) + "] " + str2;
            }
            if (this.aVi != null && this.aVi.si() && pVar != null && pVar.Hz() != null) {
                str = pVar.Hz().qa();
            }
        }
        return new String[]{str, str2};
    }

    public ForumData aJY() {
        return this.efp;
    }

    public String getForumId() {
        if (this.efp == null) {
            return "";
        }
        return this.efp.getId();
    }

    public bh aJZ() {
        return this.aVi;
    }

    public List<bh> aKa() {
        return this.efC;
    }

    public String getThreadId() {
        if (this.aVi == null) {
            return "";
        }
        return this.aVi.getId();
    }

    public ArrayList<p> aKb() {
        return this.efr;
    }

    public ao getPage() {
        return this.djY;
    }

    public dv aKc() {
        return this.efx;
    }

    public ar aKd() {
        return this.efB;
    }

    public TwzhiboAnti aKe() {
        return this.efF;
    }

    public void a(ao aoVar, int i) {
        this.djY.bM(aoVar.qv());
        this.djY.bK(aoVar.oW());
        this.djY.bJ(aoVar.qs());
        this.djY.bN(aoVar.qw());
        this.djY.bL(aoVar.qu());
        if (i == 0) {
            this.djY = aoVar;
        } else if (i == 1) {
            this.djY.bO(aoVar.qx());
        } else if (i == 2) {
            this.djY.bP(aoVar.qy());
        }
    }

    public AntiData qm() {
        return this.Rl;
    }

    public UserData getUserData() {
        return this.efv;
    }

    public boolean nt() {
        return this.aVi.getIsMarked() != 0;
    }

    public void ad(boolean z) {
        if (this.aVi != null) {
            if (z) {
                this.aVi.setIsMarked(1);
            } else {
                this.aVi.setIsMarked(0);
            }
        }
    }

    public String ns() {
        if (this.aVi != null) {
            return this.aVi.rF();
        }
        return null;
    }

    public void od(String str) {
        if (this.aVi != null) {
            this.aVi.cy(str);
        }
    }

    public p aKf() {
        return this.efq;
    }

    public boolean aKg() {
        return (this.aVi == null || this.aVi.rH() == null || this.aVi.rH().size() <= 0 || this.aVi.rH().get(0) == null || !this.aVi.rH().get(0).getIsSenior()) ? false : true;
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                com.baidu.tieba.recapp.c.a.bad().pU(dataRes.asp_shown_info);
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
                mr(dataRes.is_new_url.intValue());
                this.efp.parserProtobuf(dataRes.forum);
                this.aVi.setUserMap(this.userMap);
                this.aVi.a(dataRes.thread);
                this.aVi.aW(2);
                this.efw.a(dataRes.news_info);
                switch (this.efw.RB) {
                    case 1:
                        this.efx.elU = this.efw;
                        break;
                    case 2:
                        this.efx.elV = this.efw;
                        break;
                    case 3:
                        this.efx.elW = this.efw;
                        break;
                    default:
                        this.efx.elV = this.efw;
                        break;
                }
                this.efB.a(dataRes.recommend_book);
                if (this.aVi != null && this.aVi.rm() != null) {
                    this.efG = new VoteDataInfo();
                    this.efG.parserProtobuf(aJZ().rm());
                }
                List<Post> list2 = dataRes.post_list;
                if (list2 != null && list2.size() > 0) {
                    for (Post post : dataRes.post_list) {
                        p pVar = new p();
                        pVar.setUserMap(this.userMap);
                        pVar.a(post, context);
                        pVar.a(aJZ().rn());
                        if (pVar.bhQ() == 1 && this.aVi.sa()) {
                            if (aKg()) {
                                pVar.setPostType(0);
                            } else {
                                pVar.setPostType(this.aVi.rZ());
                            }
                        } else if (pVar.bhQ() == 1 && this.aVi != null && this.aVi.sh()) {
                            pVar.setPostType(36);
                        } else if (pVar.bhQ() == 1 && this.aVi.sn()) {
                            pVar.setPostType(41);
                        } else if (pVar.bhQ() == 1 && this.aVi != null && this.aVi.si()) {
                            pVar.setPostType(0);
                            pVar.Hz();
                            if (this.aVi.rv() == null || this.aVi.rv().size() == 0) {
                                JSONArray jSONArray = new JSONArray();
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("type", 0);
                                    jSONObject.put("text", pVar.getTitle());
                                    jSONArray.put(jSONObject);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                pVar.f(TbRichTextView.a(context, jSONArray, false));
                            } else {
                                pVar.f(new TbRichText((Context) TbadkCoreApplication.m9getInst(), this.aVi.rv(), true));
                            }
                            this.efJ = pVar;
                        } else if (pVar.bhQ() == 1 && this.aVi.so()) {
                            pVar.setPostType(48);
                        }
                        this.efr.add(pVar);
                    }
                }
                this.djY.a(dataRes.page);
                this.Rl.parserProtobuf(dataRes.anti);
                this.efs.a(dataRes.location);
                this.eft = dataRes.has_floor.intValue() == 1;
                if (dataRes.user != null) {
                    this.efu = dataRes.user.is_manager.intValue();
                }
                this.efv.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.efy.add(muteUser);
                        }
                    }
                }
                this.aVi.bU(this.aVi.rp() > 0 ? this.aVi.rp() - 1 : 0);
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        o oVar = new o();
                        oVar.c(app);
                        AppData bhE = oVar.bhE();
                        if (!this.efE.contains(oVar) && bhE.goods != null && (!StringUtils.isNull(bhE.goods.user_name) || !StringUtils.isNull(bhE.goods.lego_card))) {
                            this.efE.add(oVar);
                        }
                    }
                }
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.efv.getIsSelectTail());
                }
                this.efF.parserProtobuf(dataRes.twzhibo_anti);
                this.efH = dataRes.appeal_info;
                if (this.efK != null) {
                    this.efK.setForumId(getForumId());
                    this.efK.setThreadId(getThreadId());
                    this.efK.bI(0);
                    if (this.efu > 0) {
                        this.efK.bI(2);
                    }
                    if (this.aVi != null && this.aVi.getAuthor() != null) {
                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                        if (!TextUtils.isEmpty(currentAccount) && currentAccount.equals(this.aVi.getAuthor().getUserId())) {
                            this.efK.bI(1);
                        }
                    }
                    this.efK.a(dataRes.graffiti_rank_list_info);
                }
                if (dataRes.god_card != null) {
                    this.efA = new a();
                    this.efA.a(dataRes.god_card);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.efL = new h();
                    this.efL.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.guess_like != null) {
                    this.efM = new CardHListViewData();
                    this.efM.parseProtobuf(dataRes.guess_like);
                }
                if (dataRes.feed_thread_list != null && dataRes.feed_thread_list.size() > 0) {
                    List<ThreadInfo> list3 = dataRes.feed_thread_list;
                    if (this.efC == null) {
                        this.efC = new ArrayList();
                    }
                    this.efC.clear();
                    for (ThreadInfo threadInfo : list3) {
                        if (threadInfo != null) {
                            bh bhVar = new bh();
                            bhVar.a(threadInfo);
                            this.efC.add(bhVar);
                        }
                    }
                    if (this.efC != null && this.efC.size() > 15) {
                        this.efC = w.a(this.efC, 0, 15);
                    }
                }
                this.efD = dataRes.is_follow_current_channel.intValue();
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }

    public CardHListViewData aKh() {
        return this.efM;
    }

    public p aKi() {
        return this.efJ;
    }

    public p a(p pVar) {
        this.efJ = pVar;
        return pVar;
    }

    public int aKj() {
        return this.efu;
    }

    public int aKk() {
        return this.dlx;
    }

    public void mr(int i) {
        this.dlx = i;
    }

    public List<MuteUser> aKl() {
        return this.efy;
    }

    public ArrayList<o> aKm() {
        return this.efE;
    }

    public a aKn() {
        return this.efA;
    }

    public ArrayList<v> aKo() {
        return new ArrayList<>(this.efr);
    }

    public String aKp() {
        return this.efI;
    }

    public void oe(String str) {
        this.efI = str;
    }

    public h aKq() {
        return this.efL;
    }

    public int aKr() {
        return this.efD;
    }
}

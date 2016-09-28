package com.baidu.tieba.pb.data;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AdditionData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.TwzhiboAnti;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.ad;
import com.baidu.tbadk.core.data.am;
import com.baidu.tbadk.core.data.ao;
import com.baidu.tbadk.core.data.ap;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.pb.pb.main.ds;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.data.p;
import com.baidu.tieba.tbadkCore.data.q;
import com.baidu.tieba.usermute.MuteUser;
import com.baidu.tieba.vote.VoteDataInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tbclient.App;
import tbclient.PbPage.AppealInfo;
import tbclient.PbPage.DataRes;
import tbclient.Post;
import tbclient.SimpleUser;
import tbclient.User;
/* loaded from: classes.dex */
public class h {
    public String aQv;
    private int dvK;
    private q elY;
    private c emi;
    private TwzhiboAnti emm;
    private VoteDataInfo emn;
    public AppealInfo emo;
    private l emq;
    private boolean emh = true;
    private ArrayList<p> eml = new ArrayList<>();
    private ForumData elX = new ForumData();
    private bi bbU = new bi();
    private ArrayList<q> elZ = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private am duh = new am();
    private AntiData RK = new AntiData();
    private com.baidu.tbadk.data.g ema = new com.baidu.tbadk.data.g();
    private int emc = 0;
    private boolean emb = false;
    private final UserData emd = new UserData();
    private List<MuteUser> emg = new ArrayList();
    private AdditionData emk = new AdditionData();
    private ao eme = new ao();
    private ap emj = new ap();
    private ds emf = new ds();
    private ad emp = new ad();

    public boolean aMo() {
        return this.emh;
    }

    public void hP(boolean z) {
        this.emh = z;
    }

    public ad aMp() {
        return this.emp;
    }

    public VoteDataInfo aMq() {
        return this.emn;
    }

    public h() {
        this.dvK = 0;
        this.emm = null;
        this.dvK = 0;
        this.emm = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.elZ != null && this.elZ.size() > 0;
    }

    public String[] aW(Context context) {
        String str = "";
        if (isValid()) {
            q qVar = this.elZ.get(0);
            ak bjV = qVar.bjV();
            r1 = bjV != null ? bjV.imgUrl : null;
            str = qVar.bg(context);
            if (this.bbU != null && this.bbU.sx() != null && this.bbU.sx().getGroup_id() != 0) {
                str = "[" + context.getString(r.j.msglist_live) + "] " + str;
            }
            if (this.bbU != null && this.bbU.sz() && qVar != null && qVar.Ii() != null) {
                r1 = qVar.Ii().qd();
            }
        }
        return new String[]{r1, str};
    }

    public ForumData aMr() {
        return this.elX;
    }

    public String getForumId() {
        if (this.elX == null) {
            return "";
        }
        return this.elX.getId();
    }

    public bi aMs() {
        return this.bbU;
    }

    public String getThreadId() {
        if (this.bbU == null) {
            return "";
        }
        return this.bbU.getId();
    }

    public ArrayList<q> aMt() {
        return this.elZ;
    }

    public am getPage() {
        return this.duh;
    }

    public ds aMu() {
        return this.emf;
    }

    public ap aMv() {
        return this.emj;
    }

    public TwzhiboAnti aMw() {
        return this.emm;
    }

    public void a(am amVar, int i) {
        this.duh.bN(amVar.qz());
        this.duh.bL(amVar.pb());
        this.duh.bK(amVar.qw());
        this.duh.bO(amVar.qA());
        this.duh.bM(amVar.qy());
        if (i == 0) {
            this.duh = amVar;
        } else if (i == 1) {
            this.duh.bP(amVar.qB());
        } else if (i == 2) {
            this.duh.bQ(amVar.qC());
        }
    }

    public AntiData qq() {
        return this.RK;
    }

    public UserData getUserData() {
        return this.emd;
    }

    public boolean nv() {
        return this.bbU.getIsMarked() != 0;
    }

    public void ad(boolean z) {
        if (this.bbU != null) {
            if (z) {
                this.bbU.setIsMarked(1);
            } else {
                this.bbU.setIsMarked(0);
            }
        }
    }

    public String nu() {
        if (this.bbU != null) {
            return this.bbU.rV();
        }
        return null;
    }

    public void oY(String str) {
        if (this.bbU != null) {
            this.bbU.cx(str);
        }
    }

    public q aMx() {
        return this.elY;
    }

    public boolean aMy() {
        return (this.bbU == null || this.bbU.rX() == null || this.bbU.rX().size() <= 0 || this.bbU.rX().get(0) == null || !this.bbU.rX().get(0).getIsSenior()) ? false : true;
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
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
                mz(dataRes.is_new_url.intValue());
                this.elX.parserProtobuf(dataRes.forum);
                this.bbU.setUserMap(this.userMap);
                this.bbU.a(dataRes.thread);
                this.eme.a(dataRes.news_info);
                switch (this.eme.Sc) {
                    case 1:
                        this.emf.esx = this.eme;
                        break;
                    case 2:
                        this.emf.esy = this.eme;
                        break;
                    case 3:
                        this.emf.esz = this.eme;
                        break;
                    default:
                        this.emf.esy = this.eme;
                        break;
                }
                this.emj.a(dataRes.recommend_book);
                if (this.bbU != null && this.bbU.rE() != null) {
                    this.emn = new VoteDataInfo();
                    this.emn.parserProtobuf(aMs().rE());
                }
                List<Post> list2 = dataRes.post_list;
                if (list2 != null && list2.size() > 0) {
                    for (Post post : dataRes.post_list) {
                        q qVar = new q();
                        qVar.setUserMap(this.userMap);
                        qVar.a(post, context);
                        qVar.a(aMs().rF());
                        if (qVar.bjO() == 1 && this.bbU.sr()) {
                            if (aMy()) {
                                qVar.setPostType(0);
                            } else {
                                qVar.setPostType(this.bbU.sq());
                            }
                        } else if (qVar.bjO() == 1 && this.bbU != null && this.bbU.sy()) {
                            qVar.setPostType(36);
                        } else if (qVar.bjO() == 1 && this.bbU.sE()) {
                            qVar.setPostType(41);
                        } else if (qVar.bjO() == 1 && this.bbU != null && this.bbU.sz()) {
                            qVar.setPostType(40);
                        } else if (qVar.bjO() == 1 && this.bbU.sF()) {
                            qVar.setPostType(48);
                        }
                        this.elZ.add(qVar);
                    }
                }
                this.duh.a(dataRes.page);
                this.RK.parserProtobuf(dataRes.anti);
                this.ema.a(dataRes.location);
                this.emb = dataRes.has_floor.intValue() == 1;
                if (dataRes.user != null) {
                    this.emc = dataRes.user.is_manager.intValue();
                }
                this.emd.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.emg.add(muteUser);
                        }
                    }
                }
                this.emk.parserProtoBuf(dataRes.add_post);
                this.bbU.bU(this.bbU.rH() > 0 ? this.bbU.rH() - 1 : 0);
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        p pVar = new p();
                        pVar.c(app);
                        com.baidu.tieba.tbadkCore.data.e bjD = pVar.bjD();
                        if (!this.eml.contains(pVar) && bjD.fuA != null && !StringUtils.isNull(bjD.fuA.user_name)) {
                            this.eml.add(pVar);
                        }
                    }
                }
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.emd.getIsSelectTail());
                }
                this.emm.parserProtobuf(dataRes.twzhibo_anti);
                this.emo = dataRes.appeal_info;
                this.emp.setForumId(getForumId());
                this.emp.setThreadId(getThreadId());
                this.emp.bJ(0);
                if (this.emc > 0) {
                    this.emp.bJ(2);
                }
                if (this.bbU != null && this.bbU.getAuthor() != null) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (!TextUtils.isEmpty(currentAccount) && currentAccount.equals(this.bbU.getAuthor().getUserId())) {
                        this.emp.bJ(1);
                    }
                }
                this.emp.a(dataRes.graffiti_rank_list_info);
                if (dataRes.god_card != null) {
                    this.emi = new c();
                    this.emi.a(dataRes.god_card);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.emq = new l();
                    this.emq.a(dataRes.forum_headline_img_info);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public int aMz() {
        return this.emc;
    }

    public int aMA() {
        return this.dvK;
    }

    public void mz(int i) {
        this.dvK = i;
    }

    public List<MuteUser> aMB() {
        return this.emg;
    }

    public AdditionData aMC() {
        return this.emk;
    }

    public ArrayList<p> aMD() {
        return this.eml;
    }

    public c aME() {
        return this.emi;
    }

    public ArrayList<v> aMF() {
        return new ArrayList<>(this.elZ);
    }

    public String Lm() {
        return this.aQv;
    }

    public void hm(String str) {
        this.aQv = str;
    }

    public l aMG() {
        return this.emq;
    }
}

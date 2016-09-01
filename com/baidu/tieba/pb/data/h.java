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
import com.baidu.tbadk.core.data.ab;
import com.baidu.tbadk.core.data.ak;
import com.baidu.tbadk.core.data.am;
import com.baidu.tbadk.core.data.an;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tieba.pb.pb.main.ds;
import com.baidu.tieba.t;
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
    public String aPf;
    private int duk;
    private q eka;
    private c ekk;
    private TwzhiboAnti eko;
    private VoteDataInfo ekp;
    public AppealInfo ekq;
    private boolean ekj = true;
    private ArrayList<p> ekn = new ArrayList<>();
    private ForumData ejZ = new ForumData();
    private bg bbC = new bg();
    private ArrayList<q> ekb = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private ak dsK = new ak();
    private AntiData RE = new AntiData();
    private com.baidu.tbadk.data.g ekc = new com.baidu.tbadk.data.g();
    private int eke = 0;
    private boolean ekd = false;
    private final UserData ekf = new UserData();
    private List<MuteUser> eki = new ArrayList();
    private AdditionData ekm = new AdditionData();
    private am ekg = new am();
    private an ekl = new an();
    private ds ekh = new ds();
    private ab ekr = new ab();

    public boolean aLM() {
        return this.ekj;
    }

    public void hM(boolean z) {
        this.ekj = z;
    }

    public ab aLN() {
        return this.ekr;
    }

    public VoteDataInfo aLO() {
        return this.ekp;
    }

    public h() {
        this.duk = 0;
        this.eko = null;
        this.duk = 0;
        this.eko = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.ekb != null && this.ekb.size() > 0;
    }

    public String[] aY(Context context) {
        String str = "";
        if (isValid()) {
            q qVar = this.ekb.get(0);
            com.baidu.tbadk.core.util.ak bjj = qVar.bjj();
            r1 = bjj != null ? bjj.imgUrl : null;
            str = qVar.bj(context);
            if (this.bbC != null && this.bbC.sl() != null && this.bbC.sl().getGroup_id() != 0) {
                str = "[" + context.getString(t.j.msglist_live) + "] " + str;
            }
            if (this.bbC != null && this.bbC.sn() && qVar != null && qVar.Ij() != null) {
                r1 = qVar.Ij().pS();
            }
        }
        return new String[]{r1, str};
    }

    public ForumData aLP() {
        return this.ejZ;
    }

    public String getForumId() {
        if (this.ejZ == null) {
            return "";
        }
        return this.ejZ.getId();
    }

    public bg aLQ() {
        return this.bbC;
    }

    public String getThreadId() {
        if (this.bbC == null) {
            return "";
        }
        return this.bbC.getId();
    }

    public ArrayList<q> aLR() {
        return this.ekb;
    }

    public ak getPage() {
        return this.dsK;
    }

    public ds aLS() {
        return this.ekh;
    }

    public an aLT() {
        return this.ekl;
    }

    public TwzhiboAnti aLU() {
        return this.eko;
    }

    public void a(ak akVar, int i) {
        this.dsK.bN(akVar.qo());
        this.dsK.bL(akVar.pa());
        this.dsK.bK(akVar.ql());
        this.dsK.bO(akVar.qp());
        this.dsK.bM(akVar.qn());
        if (i == 0) {
            this.dsK = akVar;
        } else if (i == 1) {
            this.dsK.bP(akVar.qq());
        } else if (i == 2) {
            this.dsK.bQ(akVar.qr());
        }
    }

    public AntiData qf() {
        return this.RE;
    }

    public UserData getUserData() {
        return this.ekf;
    }

    public boolean nv() {
        return this.bbC.getIsMarked() != 0;
    }

    public void ad(boolean z) {
        if (this.bbC != null) {
            if (z) {
                this.bbC.setIsMarked(1);
            } else {
                this.bbC.setIsMarked(0);
            }
        }
    }

    public String nu() {
        if (this.bbC != null) {
            return this.bbC.rJ();
        }
        return null;
    }

    public void oK(String str) {
        if (this.bbC != null) {
            this.bbC.cv(str);
        }
    }

    public q aLV() {
        return this.eka;
    }

    public boolean aLW() {
        return (this.bbC == null || this.bbC.rL() == null || this.bbC.rL().size() <= 0 || this.bbC.rL().get(0) == null || !this.bbC.rL().get(0).getIsSenior()) ? false : true;
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
                mr(dataRes.is_new_url.intValue());
                this.ejZ.parserProtobuf(dataRes.forum);
                this.bbC.setUserMap(this.userMap);
                this.bbC.a(dataRes.thread);
                this.ekg.a(dataRes.news_info);
                switch (this.ekg.RW) {
                    case 1:
                        this.ekh.eqz = this.ekg;
                        break;
                    case 2:
                        this.ekh.eqA = this.ekg;
                        break;
                    case 3:
                        this.ekh.eqB = this.ekg;
                        break;
                    default:
                        this.ekh.eqA = this.ekg;
                        break;
                }
                this.ekl.a(dataRes.recommend_book);
                if (this.bbC != null && this.bbC.rs() != null) {
                    this.ekp = new VoteDataInfo();
                    this.ekp.parserProtobuf(aLQ().rs());
                }
                List<Post> list2 = dataRes.post_list;
                if (list2 != null && list2.size() > 0) {
                    for (Post post : dataRes.post_list) {
                        q qVar = new q();
                        qVar.setUserMap(this.userMap);
                        qVar.a(post, context);
                        qVar.a(aLQ().rt());
                        if (qVar.bjc() == 1 && this.bbC.sf()) {
                            if (aLW()) {
                                qVar.setPostType(0);
                            } else {
                                qVar.setPostType(this.bbC.se());
                            }
                        } else if (qVar.bjc() == 1 && this.bbC != null && this.bbC.sm()) {
                            qVar.setPostType(36);
                        } else if (qVar.bjc() == 1 && this.bbC.ss()) {
                            qVar.setPostType(41);
                        } else if (qVar.bjc() == 1 && this.bbC != null && this.bbC.sn()) {
                            qVar.setPostType(40);
                        } else if (qVar.bjc() == 1 && this.bbC.st()) {
                            qVar.setPostType(48);
                        }
                        this.ekb.add(qVar);
                    }
                }
                this.dsK.a(dataRes.page);
                this.RE.parserProtobuf(dataRes.anti);
                this.ekc.a(dataRes.location);
                this.ekd = dataRes.has_floor.intValue() == 1;
                if (dataRes.user != null) {
                    this.eke = dataRes.user.is_manager.intValue();
                }
                this.ekf.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.eki.add(muteUser);
                        }
                    }
                }
                this.ekm.parserProtoBuf(dataRes.add_post);
                this.bbC.bU(this.bbC.rv() > 0 ? this.bbC.rv() - 1 : 0);
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        p pVar = new p();
                        pVar.c(app);
                        com.baidu.tieba.tbadkCore.data.e biS = pVar.biS();
                        if (!this.ekn.contains(pVar) && biS.frT != null && !StringUtils.isNull(biS.frT.user_name)) {
                            this.ekn.add(pVar);
                        }
                    }
                }
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.ekf.getIsSelectTail());
                }
                this.eko.parserProtobuf(dataRes.twzhibo_anti);
                this.ekq = dataRes.appeal_info;
                this.ekr.setForumId(getForumId());
                this.ekr.setThreadId(getThreadId());
                this.ekr.bJ(0);
                if (this.eke > 0) {
                    this.ekr.bJ(2);
                }
                if (this.bbC != null && this.bbC.getAuthor() != null) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (!TextUtils.isEmpty(currentAccount) && currentAccount.equals(this.bbC.getAuthor().getUserId())) {
                        this.ekr.bJ(1);
                    }
                }
                this.ekr.a(dataRes.graffiti_rank_list_info);
                if (dataRes.god_card != null) {
                    this.ekk = new c();
                    this.ekk.a(dataRes.god_card);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public int aLX() {
        return this.eke;
    }

    public int aLY() {
        return this.duk;
    }

    public void mr(int i) {
        this.duk = i;
    }

    public List<MuteUser> aLZ() {
        return this.eki;
    }

    public AdditionData aMa() {
        return this.ekm;
    }

    public ArrayList<p> aMb() {
        return this.ekn;
    }

    public c aMc() {
        return this.ekk;
    }

    public ArrayList<v> aMd() {
        return new ArrayList<>(this.ekb);
    }

    public String KD() {
        return this.aPf;
    }

    public void hf(String str) {
        this.aPf = str;
    }
}

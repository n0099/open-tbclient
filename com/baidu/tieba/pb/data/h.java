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
import com.baidu.tbadk.core.data.aa;
import com.baidu.tbadk.core.data.aj;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.data.am;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.pb.pb.main.ds;
import com.baidu.tieba.tbadkCore.data.r;
import com.baidu.tieba.tbadkCore.data.s;
import com.baidu.tieba.u;
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
    private s dXW;
    private c dYg;
    private TwzhiboAnti dYk;
    private VoteDataInfo dYl;
    public AppealInfo dYm;
    private int diC;
    private boolean dYf = true;
    private ArrayList<r> dYj = new ArrayList<>();
    private ForumData dXV = new ForumData();
    private be aWa = new be();
    private ArrayList<s> dXX = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private aj dhe = new aj();
    private AntiData OT = new AntiData();
    private com.baidu.tbadk.data.g dXY = new com.baidu.tbadk.data.g();
    private int dYa = 0;
    private boolean dXZ = false;
    private final UserData dYb = new UserData();
    private List<MuteUser> dYe = new ArrayList();
    private AdditionData dYi = new AdditionData();
    private al dYc = new al();
    private am dYh = new am();
    private ds dYd = new ds();
    private aa dYn = new aa();

    public boolean aGU() {
        return this.dYf;
    }

    public void hq(boolean z) {
        this.dYf = z;
    }

    public aa aGV() {
        return this.dYn;
    }

    public VoteDataInfo aGW() {
        return this.dYl;
    }

    public h() {
        this.diC = 0;
        this.dYk = null;
        this.diC = 0;
        this.dYk = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.dXX != null && this.dXX.size() > 0;
    }

    public String[] aM(Context context) {
        String str = "";
        if (isValid()) {
            s sVar = this.dXX.get(0);
            ak bfI = sVar.bfI();
            r1 = bfI != null ? bfI.imgUrl : null;
            str = sVar.aW(context);
            if (this.aWa != null && this.aWa.rf() != null && this.aWa.rf().getGroup_id() != 0) {
                str = "[" + context.getString(u.j.msglist_live) + "] " + str;
            }
            if (this.aWa != null && this.aWa.rh() && sVar != null && sVar.GM() != null) {
                r1 = sVar.GM().oP();
            }
        }
        return new String[]{r1, str};
    }

    public ForumData aGX() {
        return this.dXV;
    }

    public String getForumId() {
        if (this.dXV == null) {
            return "";
        }
        return this.dXV.getId();
    }

    public be aGY() {
        return this.aWa;
    }

    public String getThreadId() {
        if (this.aWa == null) {
            return "";
        }
        return this.aWa.getId();
    }

    public ArrayList<s> aGZ() {
        return this.dXX;
    }

    public aj getPage() {
        return this.dhe;
    }

    public ds aHa() {
        return this.dYd;
    }

    public am aHb() {
        return this.dYh;
    }

    public TwzhiboAnti aHc() {
        return this.dYk;
    }

    public void a(aj ajVar, int i) {
        this.dhe.bA(ajVar.pl());
        this.dhe.by(ajVar.oe());
        this.dhe.bx(ajVar.pi());
        this.dhe.bB(ajVar.pm());
        this.dhe.bz(ajVar.pk());
        if (i == 0) {
            this.dhe = ajVar;
        } else if (i == 1) {
            this.dhe.bC(ajVar.pn());
        } else if (i == 2) {
            this.dhe.bD(ajVar.po());
        }
    }

    public AntiData pc() {
        return this.OT;
    }

    public UserData getUserData() {
        return this.dYb;
    }

    public boolean mA() {
        return this.aWa.getIsMarked() != 0;
    }

    public void ab(boolean z) {
        if (this.aWa != null) {
            if (z) {
                this.aWa.setIsMarked(1);
            } else {
                this.aWa.setIsMarked(0);
            }
        }
    }

    public String mz() {
        if (this.aWa != null) {
            return this.aWa.qE();
        }
        return null;
    }

    public void oa(String str) {
        if (this.aWa != null) {
            this.aWa.ct(str);
        }
    }

    public s aHd() {
        return this.dXW;
    }

    public boolean aHe() {
        return (this.aWa == null || this.aWa.qG() == null || this.aWa.qG().size() <= 0 || this.aWa.qG().get(0) == null || !this.aWa.qG().get(0).getIsSenior()) ? false : true;
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
                lO(dataRes.is_new_url.intValue());
                this.dXV.parserProtobuf(dataRes.forum);
                this.aWa.setUserMap(this.userMap);
                this.aWa.a(dataRes.thread);
                this.dYc.a(dataRes.news_info);
                switch (this.dYc.Pk) {
                    case 1:
                        this.dYd.eeu = this.dYc;
                        break;
                    case 2:
                        this.dYd.eev = this.dYc;
                        break;
                    case 3:
                        this.dYd.eew = this.dYc;
                        break;
                    default:
                        this.dYd.eev = this.dYc;
                        break;
                }
                this.dYh.a(dataRes.recommend_book);
                if (this.aWa != null && this.aWa.qo() != null) {
                    this.dYl = new VoteDataInfo();
                    this.dYl.parserProtobuf(aGY().qo());
                }
                List<Post> list2 = dataRes.post_list;
                if (list2 != null && list2.size() > 0) {
                    for (Post post : dataRes.post_list) {
                        s sVar = new s();
                        sVar.setUserMap(this.userMap);
                        sVar.a(post, context);
                        sVar.a(aGY().qp());
                        if (sVar.bfB() == 1 && this.aWa.ra()) {
                            if (aHe()) {
                                sVar.setPostType(0);
                            } else {
                                sVar.setPostType(this.aWa.qZ());
                            }
                        } else if (sVar.bfB() == 1 && this.aWa != null && this.aWa.rg()) {
                            sVar.setPostType(36);
                        } else if (sVar.bfB() == 1 && this.aWa.rn()) {
                            sVar.setPostType(41);
                        } else if (sVar.bfB() == 1 && this.aWa != null && this.aWa.rh()) {
                            sVar.setPostType(40);
                        } else if (sVar.bfB() == 1 && this.aWa.ro()) {
                            sVar.setPostType(48);
                        }
                        this.dXX.add(sVar);
                    }
                }
                this.dhe.a(dataRes.page);
                this.OT.parserProtobuf(dataRes.anti);
                this.dXY.a(dataRes.location);
                this.dXZ = dataRes.has_floor.intValue() == 1;
                if (dataRes.user != null) {
                    this.dYa = dataRes.user.is_manager.intValue();
                }
                this.dYb.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.dYe.add(muteUser);
                        }
                    }
                }
                this.dYi.parserProtoBuf(dataRes.add_post);
                this.aWa.bH(this.aWa.qr() > 0 ? this.aWa.qr() - 1 : 0);
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        r rVar = new r();
                        rVar.c(app);
                        com.baidu.tieba.tbadkCore.data.e bfq = rVar.bfq();
                        if (!this.dYj.contains(rVar) && bfq.fka != null && !StringUtils.isNull(bfq.fka.user_name)) {
                            this.dYj.add(rVar);
                        }
                    }
                }
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.dYb.getIsSelectTail());
                }
                this.dYk.parserProtobuf(dataRes.twzhibo_anti);
                this.dYm = dataRes.appeal_info;
                this.dYn.setForumId(getForumId());
                this.dYn.setThreadId(getThreadId());
                this.dYn.bw(0);
                if (this.dYa > 0) {
                    this.dYn.bw(2);
                }
                if (this.aWa != null && this.aWa.getAuthor() != null) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (!TextUtils.isEmpty(currentAccount) && currentAccount.equals(this.aWa.getAuthor().getUserId())) {
                        this.dYn.bw(1);
                    }
                }
                this.dYn.a(dataRes.graffiti_rank_list_info);
                if (dataRes.god_card != null) {
                    this.dYg = new c();
                    this.dYg.a(dataRes.god_card);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public int aHf() {
        return this.dYa;
    }

    public int aHg() {
        return this.diC;
    }

    public void lO(int i) {
        this.diC = i;
    }

    public List<MuteUser> aHh() {
        return this.dYe;
    }

    public AdditionData aHi() {
        return this.dYi;
    }

    public ArrayList<r> aHj() {
        return this.dYj;
    }

    public c aHk() {
        return this.dYg;
    }

    public ArrayList<v> aHl() {
        return new ArrayList<>(this.dXX);
    }
}

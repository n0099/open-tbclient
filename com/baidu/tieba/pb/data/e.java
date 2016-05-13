package com.baidu.tieba.pb.data;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AdditionData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.TwzhiboAnti;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.ad;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.data.v;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.data.r;
import com.baidu.tieba.tbadkCore.data.s;
import com.baidu.tieba.usermute.data.MuteUser;
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
public class e {
    private int cAh;
    private s dfb;
    private TwzhiboAnti dfm;
    private VoteDataInfo dfn;
    public AppealInfo dfo;
    private boolean dfj = true;
    private ArrayList<r> dfl = new ArrayList<>();
    private ForumData dfa = new ForumData();
    private ax aRZ = new ax();
    private ArrayList<s> dfc = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private ad cyL = new ad();
    private AntiData OF = new AntiData();
    private com.baidu.tbadk.data.f dfd = new com.baidu.tbadk.data.f();
    private int dff = 0;
    private boolean dfe = false;
    private final UserData dfg = new UserData();
    private List<MuteUser> dfi = new ArrayList();
    private AdditionData dfk = new AdditionData();
    private bc dfh = new bc();
    private v dfp = new v();

    public boolean avA() {
        return this.dfj;
    }

    public void gp(boolean z) {
        this.dfj = z;
    }

    public v avB() {
        return this.dfp;
    }

    public VoteDataInfo avC() {
        return this.dfn;
    }

    public e() {
        this.cAh = 0;
        this.dfm = null;
        this.cAh = 0;
        this.dfm = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.dfc != null && this.dfc.size() > 0;
    }

    public String[] aJ(Context context) {
        String str = "";
        if (isValid()) {
            s sVar = this.dfc.get(0);
            aj aUf = sVar.aUf();
            r1 = aUf != null ? aUf.imgUrl : null;
            str = sVar.aU(context);
            if (this.aRZ != null && this.aRZ.getAnchorInfoData() != null && this.aRZ.getAnchorInfoData().getGroup_id() != 0) {
                str = "[" + context.getString(t.j.msglist_live) + "] " + str;
            }
            if (this.aRZ != null && this.aRZ.rn() && sVar != null && sVar.GN() != null) {
                r1 = sVar.GN().po();
            }
        }
        return new String[]{r1, str};
    }

    public ForumData avD() {
        return this.dfa;
    }

    public String getForumId() {
        if (this.dfa == null) {
            return "";
        }
        return this.dfa.getId();
    }

    public ax avE() {
        return this.aRZ;
    }

    public String getThreadId() {
        if (this.aRZ == null) {
            return "";
        }
        return this.aRZ.getId();
    }

    public ArrayList<s> avF() {
        return this.dfc;
    }

    public ad getPage() {
        return this.cyL;
    }

    public bc avG() {
        return this.dfh;
    }

    public TwzhiboAnti avH() {
        return this.dfm;
    }

    public void a(ad adVar, int i) {
        this.cyL.bA(adVar.pI());
        this.cyL.by(adVar.ou());
        this.cyL.bx(adVar.pF());
        this.cyL.bB(adVar.pJ());
        this.cyL.bz(adVar.pH());
        if (i == 0) {
            this.cyL = adVar;
        } else if (i == 1) {
            this.cyL.bC(adVar.pK());
        } else if (i == 2) {
            this.cyL.bD(adVar.pL());
        }
    }

    public AntiData pz() {
        return this.OF;
    }

    public UserData getUserData() {
        return this.dfg;
    }

    public boolean mP() {
        return this.aRZ.getIsMarked() != 0;
    }

    public void aa(boolean z) {
        if (this.aRZ != null) {
            if (z) {
                this.aRZ.setIsMarked(1);
            } else {
                this.aRZ.setIsMarked(0);
            }
        }
    }

    public String mO() {
        if (this.aRZ != null) {
            return this.aRZ.qU();
        }
        return null;
    }

    public void lO(String str) {
        if (this.aRZ != null) {
            this.aRZ.cu(str);
        }
    }

    public s avI() {
        return this.dfb;
    }

    public boolean avJ() {
        return (this.aRZ == null || this.aRZ.qV() == null || this.aRZ.qV().size() <= 0 || this.aRZ.qV().get(0) == null || !this.aRZ.qV().get(0).getIsSenior()) ? false : true;
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
                kg(dataRes.is_new_url.intValue());
                this.dfa.parserProtobuf(dataRes.forum);
                this.aRZ.setUserMap(this.userMap);
                this.aRZ.a(dataRes.thread);
                this.dfh.a(dataRes.news_info);
                if (this.aRZ != null && this.aRZ.qM() != null) {
                    this.dfn = new VoteDataInfo();
                    this.dfn.parserProtobuf(avE().qM());
                }
                List<Post> list2 = dataRes.post_list;
                if (list2 != null && list2.size() > 0) {
                    for (Post post : dataRes.post_list) {
                        s sVar = new s();
                        sVar.setUserMap(this.userMap);
                        sVar.a(post, context);
                        sVar.setPraise(avE().getPraise());
                        if (sVar.aTY() == 1 && this.aRZ.ri()) {
                            if (avJ()) {
                                sVar.setPostType(0);
                            } else {
                                sVar.setPostType(this.aRZ.rh());
                            }
                        } else if (sVar.aTY() == 1 && this.aRZ != null && this.aRZ.rm()) {
                            sVar.setPostType(36);
                        } else if (sVar.aTY() == 1 && this.aRZ.rt()) {
                            sVar.setPostType(41);
                        } else if (sVar.aTY() == 1 && this.aRZ != null && this.aRZ.rn()) {
                            sVar.setPostType(40);
                        }
                        this.dfc.add(sVar);
                    }
                }
                this.cyL.a(dataRes.page);
                this.OF.parserProtobuf(dataRes.anti);
                this.dfd.a(dataRes.location);
                this.dfe = dataRes.has_floor.intValue() == 1;
                if (dataRes.user != null) {
                    this.dff = dataRes.user.is_manager.intValue();
                }
                this.dfg.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.dfi.add(muteUser);
                        }
                    }
                }
                this.dfk.parserProtoBuf(dataRes.add_post);
                this.aRZ.setReply_num(this.aRZ.getReply_num() > 0 ? this.aRZ.getReply_num() - 1 : 0);
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        r rVar = new r();
                        rVar.c(app);
                        com.baidu.tieba.tbadkCore.data.e aTN = rVar.aTN();
                        if (!this.dfl.contains(rVar) && aTN.esk != null && !StringUtils.isNull(aTN.esk.user_name)) {
                            this.dfl.add(rVar);
                        }
                    }
                }
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.dfg.getIsSelectTail());
                }
                this.dfm.parserProtobuf(dataRes.twzhibo_anti);
                this.dfo = dataRes.appeal_info;
                this.dfp.setForumId(getForumId());
                this.dfp.setThreadId(getThreadId());
                this.dfp.bw(0);
                if (this.dff > 0) {
                    this.dfp.bw(2);
                }
                if (this.aRZ != null && this.aRZ.getAuthor() != null) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (!TextUtils.isEmpty(currentAccount) && currentAccount.equals(this.aRZ.getAuthor().getUserId())) {
                        this.dfp.bw(1);
                    }
                }
                this.dfp.a(dataRes.graffiti_rank_list_info);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public int avK() {
        return this.dff;
    }

    public int avL() {
        return this.cAh;
    }

    public void kg(int i) {
        this.cAh = i;
    }

    public List<MuteUser> avM() {
        return this.dfi;
    }

    public AdditionData avN() {
        return this.dfk;
    }

    public ArrayList<r> avO() {
        return this.dfl;
    }

    public ArrayList<com.baidu.adp.widget.ListView.v> avP() {
        return new ArrayList<>(this.dfc);
    }
}

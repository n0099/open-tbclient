package com.baidu.tieba.pb.a;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AdditionData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.TwzhiboAnti;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.ad;
import com.baidu.tbadk.core.data.z;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.data.q;
import com.baidu.tieba.tbadkCore.data.r;
import com.baidu.tieba.usermute.data.MuteUser;
import com.baidu.tieba.vote.VoteDataInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tbclient.App;
import tbclient.PbPage.DataRes;
import tbclient.Post;
import tbclient.SimpleUser;
import tbclient.User;
/* loaded from: classes.dex */
public class c {
    private TwzhiboAnti cCY;
    private VoteDataInfo cCZ;
    private int ckg;
    private boolean cCV = true;
    private ArrayList<q> cCX = new ArrayList<>();
    private ForumData cCN = new ForumData();
    private z aQp = new z();
    private ArrayList<r> cCO = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private com.baidu.tbadk.core.data.q ciK = new com.baidu.tbadk.core.data.q();
    private AntiData VX = new AntiData();
    private com.baidu.tbadk.data.d cCP = new com.baidu.tbadk.data.d();
    private int cCR = 0;
    private boolean cCQ = false;
    private final UserData cCS = new UserData();
    private List<MuteUser> cCU = new ArrayList();
    private AdditionData cCW = new AdditionData();
    private ad cCT = new ad();

    public boolean akE() {
        return this.cCV;
    }

    public void eR(boolean z) {
        this.cCV = z;
    }

    public VoteDataInfo akF() {
        return this.cCZ;
    }

    public c() {
        this.ckg = 0;
        this.cCY = null;
        this.ckg = 0;
        this.cCY = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.cCO != null && this.cCO.size() > 0;
    }

    public String[] aD(Context context) {
        String str = "";
        if (isValid()) {
            r rVar = this.cCO.get(0);
            ai aFx = rVar.aFx();
            r1 = aFx != null ? aFx.Xp : null;
            str = rVar.aS(context);
            if (this.aQp != null && this.aQp.getAnchorInfoData() != null && this.aQp.getAnchorInfoData().getGroup_id() != 0) {
                str = "[" + context.getString(n.j.msglist_live) + "] " + str;
            }
        }
        return new String[]{r1, str};
    }

    public ForumData akG() {
        return this.cCN;
    }

    public String getForumId() {
        if (this.cCN == null) {
            return "";
        }
        return this.cCN.getId();
    }

    public z akH() {
        return this.aQp;
    }

    public String getThreadId() {
        if (this.aQp == null) {
            return "";
        }
        return this.aQp.getId();
    }

    public ArrayList<r> akI() {
        return this.cCO;
    }

    public com.baidu.tbadk.core.data.q getPage() {
        return this.ciK;
    }

    public ad akJ() {
        return this.cCT;
    }

    public TwzhiboAnti akK() {
        return this.cCY;
    }

    public void a(com.baidu.tbadk.core.data.q qVar, int i) {
        this.ciK.bw(qVar.rM());
        this.ciK.bv(qVar.rj());
        this.ciK.bu(qVar.rK());
        this.ciK.bx(qVar.rN());
        if (i == 0) {
            this.ciK = qVar;
        } else if (i == 1) {
            this.ciK.by(qVar.rO());
        } else if (i == 2) {
            this.ciK.bz(qVar.rP());
        }
    }

    public AntiData rI() {
        return this.VX;
    }

    public UserData getUserData() {
        return this.cCS;
    }

    public boolean pN() {
        return this.aQp.getIsMarked() != 0;
    }

    public void Y(boolean z) {
        if (this.aQp != null) {
            if (z) {
                this.aQp.setIsMarked(1);
            } else {
                this.aQp.setIsMarked(0);
            }
        }
    }

    public String pM() {
        if (this.aQp != null) {
            return this.aQp.sz();
        }
        return null;
    }

    public void ku(String str) {
        if (this.aQp != null) {
            this.aQp.cz(str);
        }
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
                jz(dataRes.is_new_url.intValue());
                this.cCN.parserProtobuf(dataRes.forum);
                this.aQp.setUserMap(this.userMap);
                this.aQp.a(dataRes.thread);
                this.cCT.a(dataRes.news_info);
                if (this.aQp != null && this.aQp.sr() != null) {
                    this.cCZ = new VoteDataInfo();
                    this.cCZ.parserProtobuf(akH().sr());
                }
                List<Post> list2 = dataRes.post_list;
                if (list2 != null && list2.size() > 0) {
                    for (Post post : dataRes.post_list) {
                        r rVar = new r();
                        rVar.setUserMap(this.userMap);
                        rVar.a(post, context);
                        if (rVar.aFq() == 1 && this.aQp.sJ()) {
                            rVar.setPostType(this.aQp.sI());
                        } else if (rVar.aFq() == 1 && this.aQp != null && this.aQp.sM()) {
                            rVar.setPostType(36);
                        }
                        this.cCO.add(rVar);
                    }
                }
                this.ciK.a(dataRes.page);
                this.VX.parserProtobuf(dataRes.anti);
                this.cCP.a(dataRes.location);
                this.cCQ = dataRes.has_floor.intValue() == 1;
                if (dataRes.user != null) {
                    this.cCR = dataRes.user.is_manager.intValue();
                }
                this.cCS.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.cCU.add(muteUser);
                        }
                    }
                }
                this.cCW.parserProtoBuf(dataRes.add_post);
                this.aQp.setReply_num(this.aQp.getReply_num() > 0 ? this.aQp.getReply_num() - 1 : 0);
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        q qVar = new q();
                        qVar.b(app);
                        com.baidu.tieba.tbadkCore.data.d aFf = qVar.aFf();
                        if (!this.cCX.contains(qVar) && aFf.dGx != null && !StringUtils.isNull(aFf.dGx.user_name)) {
                            this.cCX.add(qVar);
                        }
                    }
                }
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.cCS.getIsSelectTail());
                }
                this.cCY.parserProtobuf(dataRes.twzhibo_anti);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public int akL() {
        return this.cCR;
    }

    public int akM() {
        return this.ckg;
    }

    public void jz(int i) {
        this.ckg = i;
    }

    public List<MuteUser> akN() {
        return this.cCU;
    }

    public AdditionData akO() {
        return this.cCW;
    }

    public ArrayList<q> akP() {
        return this.cCX;
    }

    public ArrayList<u> akQ() {
        return new ArrayList<>(this.cCO);
    }
}

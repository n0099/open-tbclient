package com.baidu.tieba.pb.a;

import android.content.Context;
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
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.data.u;
import com.baidu.tieba.t;
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
    private TwzhiboAnti cJE;
    private VoteDataInfo cJF;
    private int coG;
    private boolean cJB = true;
    private ArrayList<q> cJD = new ArrayList<>();
    private ForumData cJt = new ForumData();
    private ah aSu = new ah();
    private ArrayList<r> cJu = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private u cnk = new u();
    private AntiData VM = new AntiData();
    private com.baidu.tbadk.data.d cJv = new com.baidu.tbadk.data.d();
    private int cJx = 0;
    private boolean cJw = false;
    private final UserData cJy = new UserData();
    private List<MuteUser> cJA = new ArrayList();
    private AdditionData cJC = new AdditionData();
    private al cJz = new al();

    public boolean aoC() {
        return this.cJB;
    }

    public void ff(boolean z) {
        this.cJB = z;
    }

    public VoteDataInfo aoD() {
        return this.cJF;
    }

    public c() {
        this.coG = 0;
        this.cJE = null;
        this.coG = 0;
        this.cJE = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.cJu != null && this.cJu.size() > 0;
    }

    public String[] aE(Context context) {
        String str = "";
        if (isValid()) {
            r rVar = this.cJu.get(0);
            com.baidu.tbadk.core.util.ah aMC = rVar.aMC();
            r1 = aMC != null ? aMC.imgUrl : null;
            str = rVar.aU(context);
            if (this.aSu != null && this.aSu.getAnchorInfoData() != null && this.aSu.getAnchorInfoData().getGroup_id() != 0) {
                str = "[" + context.getString(t.j.msglist_live) + "] " + str;
            }
            if (this.aSu != null && this.aSu.tJ() && rVar != null && rVar.Hb() != null) {
                r1 = rVar.Hb().Hx();
            }
        }
        return new String[]{r1, str};
    }

    public ForumData aoE() {
        return this.cJt;
    }

    public String getForumId() {
        if (this.cJt == null) {
            return "";
        }
        return this.cJt.getId();
    }

    public ah aoF() {
        return this.aSu;
    }

    public String getThreadId() {
        if (this.aSu == null) {
            return "";
        }
        return this.aSu.getId();
    }

    public ArrayList<r> aoG() {
        return this.cJu;
    }

    public u getPage() {
        return this.cnk;
    }

    public al aoH() {
        return this.cJz;
    }

    public TwzhiboAnti aoI() {
        return this.cJE;
    }

    public void a(u uVar, int i) {
        this.cnk.bN(uVar.st());
        this.cnk.bL(uVar.rG());
        this.cnk.bK(uVar.sq());
        this.cnk.bO(uVar.su());
        this.cnk.bM(uVar.ss());
        if (i == 0) {
            this.cnk = uVar;
        } else if (i == 1) {
            this.cnk.bP(uVar.sv());
        } else if (i == 2) {
            this.cnk.bQ(uVar.sw());
        }
    }

    public AntiData so() {
        return this.VM;
    }

    public UserData getUserData() {
        return this.cJy;
    }

    public boolean qg() {
        return this.aSu.getIsMarked() != 0;
    }

    public void Y(boolean z) {
        if (this.aSu != null) {
            if (z) {
                this.aSu.setIsMarked(1);
            } else {
                this.aSu.setIsMarked(0);
            }
        }
    }

    public String qf() {
        if (this.aSu != null) {
            return this.aSu.ts();
        }
        return null;
    }

    public void kx(String str) {
        if (this.aSu != null) {
            this.aSu.cy(str);
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
                jW(dataRes.is_new_url.intValue());
                this.cJt.parserProtobuf(dataRes.forum);
                this.aSu.setUserMap(this.userMap);
                this.aSu.a(dataRes.thread);
                this.cJz.a(dataRes.news_info);
                if (this.aSu != null && this.aSu.tk() != null) {
                    this.cJF = new VoteDataInfo();
                    this.cJF.parserProtobuf(aoF().tk());
                }
                List<Post> list2 = dataRes.post_list;
                if (list2 != null && list2.size() > 0) {
                    for (Post post : dataRes.post_list) {
                        r rVar = new r();
                        rVar.setUserMap(this.userMap);
                        rVar.a(post, context);
                        if (rVar.aMw() == 1 && this.aSu.tF()) {
                            rVar.setPostType(this.aSu.tE());
                        } else if (rVar.aMw() == 1 && this.aSu != null && this.aSu.tI()) {
                            rVar.setPostType(36);
                        } else if (rVar.aMw() == 1 && this.aSu.tP()) {
                            rVar.setPostType(41);
                        } else if (rVar.aMw() == 1 && this.aSu != null && this.aSu.tJ()) {
                            rVar.setPostType(40);
                        }
                        this.cJu.add(rVar);
                    }
                }
                this.cnk.a(dataRes.page);
                this.VM.parserProtobuf(dataRes.anti);
                this.cJv.a(dataRes.location);
                this.cJw = dataRes.has_floor.intValue() == 1;
                if (dataRes.user != null) {
                    this.cJx = dataRes.user.is_manager.intValue();
                }
                this.cJy.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.cJA.add(muteUser);
                        }
                    }
                }
                this.cJC.parserProtoBuf(dataRes.add_post);
                this.aSu.setReply_num(this.aSu.getReply_num() > 0 ? this.aSu.getReply_num() - 1 : 0);
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        q qVar = new q();
                        qVar.c(app);
                        com.baidu.tieba.tbadkCore.data.d aMl = qVar.aMl();
                        if (!this.cJD.contains(qVar) && aMl.dWs != null && !StringUtils.isNull(aMl.dWs.user_name)) {
                            this.cJD.add(qVar);
                        }
                    }
                }
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.cJy.getIsSelectTail());
                }
                this.cJE.parserProtobuf(dataRes.twzhibo_anti);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public int aoJ() {
        return this.cJx;
    }

    public int aoK() {
        return this.coG;
    }

    public void jW(int i) {
        this.coG = i;
    }

    public List<MuteUser> aoL() {
        return this.cJA;
    }

    public AdditionData aoM() {
        return this.cJC;
    }

    public ArrayList<q> aoN() {
        return this.cJD;
    }

    public ArrayList<com.baidu.adp.widget.ListView.u> aoO() {
        return new ArrayList<>(this.cJu);
    }
}

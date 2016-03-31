package com.baidu.tieba.pb.data;

import android.content.Context;
import android.text.TextUtils;
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
import com.baidu.tbadk.core.data.ac;
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.data.aw;
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
    private int czj;
    private s dcH;
    private TwzhiboAnti dcS;
    private VoteDataInfo dcT;
    public AppealInfo dcU;
    private boolean dcP = true;
    private ArrayList<r> dcR = new ArrayList<>();
    private ForumData dcG = new ForumData();
    private as aWf = new as();
    private ArrayList<s> dcI = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private ac cxM = new ac();
    private AntiData TQ = new AntiData();
    private com.baidu.tbadk.data.e dcJ = new com.baidu.tbadk.data.e();
    private int dcL = 0;
    private boolean dcK = false;
    private final UserData dcM = new UserData();
    private List<MuteUser> dcO = new ArrayList();
    private AdditionData dcQ = new AdditionData();
    private aw dcN = new aw();
    private v dcV = new v();

    public boolean avr() {
        return this.dcP;
    }

    public void fP(boolean z) {
        this.dcP = z;
    }

    public v avs() {
        return this.dcV;
    }

    public VoteDataInfo avt() {
        return this.dcT;
    }

    public e() {
        this.czj = 0;
        this.dcS = null;
        this.czj = 0;
        this.dcS = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.dcI != null && this.dcI.size() > 0;
    }

    public String[] aD(Context context) {
        String str = "";
        if (isValid()) {
            s sVar = this.dcI.get(0);
            aj aTz = sVar.aTz();
            r1 = aTz != null ? aTz.imgUrl : null;
            str = sVar.aO(context);
            if (this.aWf != null && this.aWf.getAnchorInfoData() != null && this.aWf.getAnchorInfoData().getGroup_id() != 0) {
                str = "[" + context.getString(t.j.msglist_live) + "] " + str;
            }
            if (this.aWf != null && this.aWf.tO() && sVar != null && sVar.Iv() != null) {
                r1 = sVar.Iv().rV();
            }
        }
        return new String[]{r1, str};
    }

    public ForumData avu() {
        return this.dcG;
    }

    public String getForumId() {
        if (this.dcG == null) {
            return "";
        }
        return this.dcG.getId();
    }

    public as avv() {
        return this.aWf;
    }

    public String getThreadId() {
        if (this.aWf == null) {
            return "";
        }
        return this.aWf.getId();
    }

    public ArrayList<s> avw() {
        return this.dcI;
    }

    public ac getPage() {
        return this.cxM;
    }

    public aw avx() {
        return this.dcN;
    }

    public TwzhiboAnti avy() {
        return this.dcS;
    }

    public void a(ac acVar, int i) {
        this.cxM.bP(acVar.so());
        this.cxM.bN(acVar.qX());
        this.cxM.bM(acVar.sl());
        this.cxM.bQ(acVar.sp());
        this.cxM.bO(acVar.sn());
        if (i == 0) {
            this.cxM = acVar;
        } else if (i == 1) {
            this.cxM.bR(acVar.sq());
        } else if (i == 2) {
            this.cxM.bS(acVar.sr());
        }
    }

    public AntiData sf() {
        return this.TQ;
    }

    public UserData getUserData() {
        return this.dcM;
    }

    public boolean pu() {
        return this.aWf.getIsMarked() != 0;
    }

    public void X(boolean z) {
        if (this.aWf != null) {
            if (z) {
                this.aWf.setIsMarked(1);
            } else {
                this.aWf.setIsMarked(0);
            }
        }
    }

    public String ps() {
        if (this.aWf != null) {
            return this.aWf.tv();
        }
        return null;
    }

    public void lK(String str) {
        if (this.aWf != null) {
            this.aWf.cw(str);
        }
    }

    public s avz() {
        return this.dcH;
    }

    public boolean avA() {
        return (this.aWf == null || this.aWf.tw() == null || this.aWf.tw().size() <= 0 || this.aWf.tw().get(0) == null || !this.aWf.tw().get(0).ra()) ? false : true;
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
                kB(dataRes.is_new_url.intValue());
                this.dcG.parserProtobuf(dataRes.forum);
                this.aWf.setUserMap(this.userMap);
                this.aWf.a(dataRes.thread);
                this.dcN.a(dataRes.news_info);
                if (this.aWf != null && this.aWf.tm() != null) {
                    this.dcT = new VoteDataInfo();
                    this.dcT.parserProtobuf(avv().tm());
                }
                List<Post> list2 = dataRes.post_list;
                if (list2 != null && list2.size() > 0) {
                    for (Post post : dataRes.post_list) {
                        s sVar = new s();
                        sVar.setUserMap(this.userMap);
                        sVar.a(post, context);
                        if (sVar.aTs() == 1 && this.aWf.tJ()) {
                            if (avA()) {
                                sVar.setPostType(0);
                            } else {
                                sVar.setPostType(this.aWf.tI());
                            }
                        } else if (sVar.aTs() == 1 && this.aWf != null && this.aWf.tN()) {
                            sVar.setPostType(36);
                        } else if (sVar.aTs() == 1 && this.aWf.tU()) {
                            sVar.setPostType(41);
                        } else if (sVar.aTs() == 1 && this.aWf != null && this.aWf.tO()) {
                            sVar.setPostType(40);
                        }
                        this.dcI.add(sVar);
                    }
                }
                this.cxM.a(dataRes.page);
                this.TQ.parserProtobuf(dataRes.anti);
                this.dcJ.a(dataRes.location);
                this.dcK = dataRes.has_floor.intValue() == 1;
                if (dataRes.user != null) {
                    this.dcL = dataRes.user.is_manager.intValue();
                }
                this.dcM.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.dcO.add(muteUser);
                        }
                    }
                }
                this.dcQ.parserProtoBuf(dataRes.add_post);
                this.aWf.setReply_num(this.aWf.getReply_num() > 0 ? this.aWf.getReply_num() - 1 : 0);
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        r rVar = new r();
                        rVar.c(app);
                        com.baidu.tieba.tbadkCore.data.e aTh = rVar.aTh();
                        if (!this.dcR.contains(rVar) && aTh.epa != null && !StringUtils.isNull(aTh.epa.user_name)) {
                            this.dcR.add(rVar);
                        }
                    }
                }
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.dcM.getIsSelectTail());
                }
                this.dcS.parserProtobuf(dataRes.twzhibo_anti);
                this.dcU = dataRes.appeal_info;
                this.dcV.setForumId(getForumId());
                this.dcV.setThreadId(getThreadId());
                this.dcV.bL(0);
                if (this.dcL > 0) {
                    this.dcV.bL(2);
                }
                if (this.aWf != null && this.aWf.getAuthor() != null) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (!TextUtils.isEmpty(currentAccount) && currentAccount.equals(this.aWf.getAuthor().getUserId())) {
                        this.dcV.bL(1);
                    }
                }
                this.dcV.a(dataRes.graffiti_rank_list_info);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public int avB() {
        return this.dcL;
    }

    public int avC() {
        return this.czj;
    }

    public void kB(int i) {
        this.czj = i;
    }

    public List<MuteUser> avD() {
        return this.dcO;
    }

    public AdditionData avE() {
        return this.dcQ;
    }

    public ArrayList<r> avF() {
        return this.dcR;
    }

    public ArrayList<u> avG() {
        return new ArrayList<>(this.dcI);
    }
}

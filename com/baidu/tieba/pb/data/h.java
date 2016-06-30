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
import com.baidu.tbadk.core.data.af;
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.data.x;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.pb.pb.main.dr;
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
    private s dLN;
    private c dLX;
    private TwzhiboAnti dMa;
    private VoteDataInfo dMb;
    public AppealInfo dMc;
    private int dfE;
    private boolean dLW = true;
    private ArrayList<r> dLZ = new ArrayList<>();
    private ForumData dLM = new ForumData();
    private az aVc = new az();
    private ArrayList<s> dLO = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private af deh = new af();
    private AntiData OF = new AntiData();
    private com.baidu.tbadk.data.g dLP = new com.baidu.tbadk.data.g();
    private int dLR = 0;
    private boolean dLQ = false;
    private final UserData dLS = new UserData();
    private List<MuteUser> dLV = new ArrayList();
    private AdditionData dLY = new AdditionData();
    private ah dLT = new ah();
    private dr dLU = new dr();
    private x dMd = new x();

    public boolean aDK() {
        return this.dLW;
    }

    public void hf(boolean z) {
        this.dLW = z;
    }

    public x aDL() {
        return this.dMd;
    }

    public VoteDataInfo aDM() {
        return this.dMb;
    }

    public h() {
        this.dfE = 0;
        this.dMa = null;
        this.dfE = 0;
        this.dMa = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.dLO != null && this.dLO.size() > 0;
    }

    public String[] aM(Context context) {
        String str = "";
        if (isValid()) {
            s sVar = this.dLO.get(0);
            ak bct = sVar.bct();
            r1 = bct != null ? bct.imgUrl : null;
            str = sVar.aW(context);
            if (this.aVc != null && this.aVc.getAnchorInfoData() != null && this.aVc.getAnchorInfoData().getGroup_id() != 0) {
                str = "[" + context.getString(u.j.msglist_live) + "] " + str;
            }
            if (this.aVc != null && this.aVc.rj() && sVar != null && sVar.GO() != null) {
                r1 = sVar.GO().pg();
            }
        }
        return new String[]{r1, str};
    }

    public ForumData aDN() {
        return this.dLM;
    }

    public String getForumId() {
        if (this.dLM == null) {
            return "";
        }
        return this.dLM.getId();
    }

    public az aDO() {
        return this.aVc;
    }

    public String getThreadId() {
        if (this.aVc == null) {
            return "";
        }
        return this.aVc.getId();
    }

    public ArrayList<s> aDP() {
        return this.dLO;
    }

    public af getPage() {
        return this.deh;
    }

    public dr aDQ() {
        return this.dLU;
    }

    public TwzhiboAnti aDR() {
        return this.dMa;
    }

    public void a(af afVar, int i) {
        this.deh.bB(afVar.pC());
        this.deh.bz(afVar.op());
        this.deh.by(afVar.pz());
        this.deh.bC(afVar.pD());
        this.deh.bA(afVar.pB());
        if (i == 0) {
            this.deh = afVar;
        } else if (i == 1) {
            this.deh.bD(afVar.pE());
        } else if (i == 2) {
            this.deh.bE(afVar.pF());
        }
    }

    public AntiData pt() {
        return this.OF;
    }

    public UserData getUserData() {
        return this.dLS;
    }

    public boolean mK() {
        return this.aVc.getIsMarked() != 0;
    }

    public void Z(boolean z) {
        if (this.aVc != null) {
            if (z) {
                this.aVc.setIsMarked(1);
            } else {
                this.aVc.setIsMarked(0);
            }
        }
    }

    public String mJ() {
        if (this.aVc != null) {
            return this.aVc.qP();
        }
        return null;
    }

    public void np(String str) {
        if (this.aVc != null) {
            this.aVc.ct(str);
        }
    }

    public s aDS() {
        return this.dLN;
    }

    public boolean aDT() {
        return (this.aVc == null || this.aVc.qQ() == null || this.aVc.qQ().size() <= 0 || this.aVc.qQ().get(0) == null || !this.aVc.qQ().get(0).getIsSenior()) ? false : true;
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
                lI(dataRes.is_new_url.intValue());
                this.dLM.parserProtobuf(dataRes.forum);
                this.aVc.setUserMap(this.userMap);
                this.aVc.a(dataRes.thread);
                this.dLT.a(dataRes.news_info);
                switch (this.dLT.OW) {
                    case 1:
                        this.dLU.dSd = this.dLT;
                        break;
                    case 2:
                        this.dLU.dSe = this.dLT;
                        break;
                    case 3:
                        this.dLU.dSf = this.dLT;
                        break;
                    default:
                        this.dLU.dSe = this.dLT;
                        break;
                }
                if (this.aVc != null && this.aVc.qF() != null) {
                    this.dMb = new VoteDataInfo();
                    this.dMb.parserProtobuf(aDO().qF());
                }
                List<Post> list2 = dataRes.post_list;
                if (list2 != null && list2.size() > 0) {
                    for (Post post : dataRes.post_list) {
                        s sVar = new s();
                        sVar.setUserMap(this.userMap);
                        sVar.a(post, context);
                        sVar.setPraise(aDO().getPraise());
                        if (sVar.bcm() == 1 && this.aVc.re()) {
                            if (aDT()) {
                                sVar.setPostType(0);
                            } else {
                                sVar.setPostType(this.aVc.rd());
                            }
                        } else if (sVar.bcm() == 1 && this.aVc != null && this.aVc.ri()) {
                            sVar.setPostType(36);
                        } else if (sVar.bcm() == 1 && this.aVc.rp()) {
                            sVar.setPostType(41);
                        } else if (sVar.bcm() == 1 && this.aVc != null && this.aVc.rj()) {
                            sVar.setPostType(40);
                        }
                        this.dLO.add(sVar);
                    }
                }
                this.deh.a(dataRes.page);
                this.OF.parserProtobuf(dataRes.anti);
                this.dLP.a(dataRes.location);
                this.dLQ = dataRes.has_floor.intValue() == 1;
                if (dataRes.user != null) {
                    this.dLR = dataRes.user.is_manager.intValue();
                }
                this.dLS.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.dLV.add(muteUser);
                        }
                    }
                }
                this.dLY.parserProtoBuf(dataRes.add_post);
                this.aVc.setReply_num(this.aVc.getReply_num() > 0 ? this.aVc.getReply_num() - 1 : 0);
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        r rVar = new r();
                        rVar.c(app);
                        com.baidu.tieba.tbadkCore.data.e bcb = rVar.bcb();
                        if (!this.dLZ.contains(rVar) && bcb.eWY != null && !StringUtils.isNull(bcb.eWY.user_name)) {
                            this.dLZ.add(rVar);
                        }
                    }
                }
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.dLS.getIsSelectTail());
                }
                this.dMa.parserProtobuf(dataRes.twzhibo_anti);
                this.dMc = dataRes.appeal_info;
                this.dMd.setForumId(getForumId());
                this.dMd.setThreadId(getThreadId());
                this.dMd.bx(0);
                if (this.dLR > 0) {
                    this.dMd.bx(2);
                }
                if (this.aVc != null && this.aVc.getAuthor() != null) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (!TextUtils.isEmpty(currentAccount) && currentAccount.equals(this.aVc.getAuthor().getUserId())) {
                        this.dMd.bx(1);
                    }
                }
                this.dMd.a(dataRes.graffiti_rank_list_info);
                if (dataRes.god_card != null) {
                    this.dLX = new c();
                    this.dLX.a(dataRes.god_card);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public int aDU() {
        return this.dLR;
    }

    public int aDV() {
        return this.dfE;
    }

    public void lI(int i) {
        this.dfE = i;
    }

    public List<MuteUser> aDW() {
        return this.dLV;
    }

    public AdditionData aDX() {
        return this.dLY;
    }

    public ArrayList<r> aDY() {
        return this.dLZ;
    }

    public c aDZ() {
        return this.dLX;
    }

    public ArrayList<v> aEa() {
        return new ArrayList<>(this.dLO);
    }
}

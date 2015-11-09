package com.baidu.tieba.pb.a;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AdditionData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.TwzhiboAnti;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.aa;
import com.baidu.tbadk.core.data.w;
import com.baidu.tbadk.core.util.ad;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.data.n;
import com.baidu.tieba.tbadkCore.data.o;
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
    private int bPQ;
    private TwzhiboAnti cgW;
    private VoteDataInfo cgX;
    private boolean cgT = true;
    private ArrayList<n> cgV = new ArrayList<>();
    private ForumData cgK = new ForumData();
    private w cgL = new w();
    private ArrayList<o> cgM = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private com.baidu.tbadk.core.data.o cbi = new com.baidu.tbadk.core.data.o();
    private AntiData UV = new AntiData();
    private com.baidu.tbadk.data.d cgN = new com.baidu.tbadk.data.d();
    private int cgP = 0;
    private boolean cgO = false;
    private final UserData cgQ = new UserData();
    private List<MuteUser> cgS = new ArrayList();
    private AdditionData cgU = new AdditionData();
    private aa cgR = new aa();

    public boolean afe() {
        return this.cgT;
    }

    public void eq(boolean z) {
        this.cgT = z;
    }

    public VoteDataInfo aff() {
        return this.cgX;
    }

    public c() {
        this.bPQ = 0;
        this.cgW = null;
        this.bPQ = 0;
        this.cgW = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.cgM != null && this.cgM.size() > 0;
    }

    public String[] aD(Context context) {
        String str = "";
        if (isValid()) {
            o oVar = this.cgM.get(0);
            ad axA = oVar.axA();
            r1 = axA != null ? axA.Wd : null;
            str = oVar.aS(context);
            if (this.cgL != null && this.cgL.getAnchorInfoData() != null && this.cgL.getAnchorInfoData().getGroup_id() != 0) {
                str = "[" + context.getString(i.h.msglist_live) + "] " + str;
            }
        }
        return new String[]{r1, str};
    }

    public ForumData afg() {
        return this.cgK;
    }

    public String getForumId() {
        if (this.cgK == null) {
            return "";
        }
        return this.cgK.getId();
    }

    public w afh() {
        return this.cgL;
    }

    public String getThreadId() {
        if (this.cgL == null) {
            return "";
        }
        return this.cgL.getId();
    }

    public ArrayList<o> afi() {
        return this.cgM;
    }

    public com.baidu.tbadk.core.data.o getPage() {
        return this.cbi;
    }

    public aa afj() {
        return this.cgR;
    }

    public TwzhiboAnti afk() {
        return this.cgW;
    }

    public void a(com.baidu.tbadk.core.data.o oVar, int i) {
        this.cbi.bw(oVar.rI());
        this.cbi.bv(oVar.rm());
        this.cbi.bu(oVar.rG());
        this.cbi.bx(oVar.rJ());
        if (i == 0) {
            this.cbi = oVar;
        } else if (i == 1) {
            this.cbi.by(oVar.rK());
        } else if (i == 2) {
            this.cbi.bz(oVar.rL());
        }
    }

    public AntiData rE() {
        return this.UV;
    }

    public UserData getUserData() {
        return this.cgQ;
    }

    public boolean qi() {
        return this.cgL.getIsMarked() != 0;
    }

    public void ab(boolean z) {
        if (this.cgL != null) {
            if (z) {
                this.cgL.setIsMarked(1);
            } else {
                this.cgL.setIsMarked(0);
            }
        }
    }

    public String qh() {
        if (this.cgL != null) {
            return this.cgL.sn();
        }
        return null;
    }

    public void jI(String str) {
        if (this.cgL != null) {
            this.cgL.co(str);
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
                ih(dataRes.is_new_url.intValue());
                this.cgK.parserProtobuf(dataRes.forum);
                this.cgL.setUserMap(this.userMap);
                this.cgL.a(dataRes.thread);
                this.cgR.a(dataRes.news_info);
                if (this.cgL != null && this.cgL.sg() != null) {
                    this.cgX = new VoteDataInfo();
                    this.cgX.parserProtobuf(afh().sg());
                }
                List<Post> list2 = dataRes.post_list;
                if (list2 != null && list2.size() > 0) {
                    for (Post post : dataRes.post_list) {
                        o oVar = new o();
                        oVar.setUserMap(this.userMap);
                        oVar.a(post, context);
                        if (oVar.axt() == 1 && this.cgL.sy()) {
                            oVar.setPostType(this.cgL.sx());
                        } else if (oVar.axt() == 1 && this.cgL != null && this.cgL.sB()) {
                            oVar.setPostType(36);
                        }
                        this.cgM.add(oVar);
                    }
                }
                this.cbi.a(dataRes.page);
                this.UV.parserProtobuf(dataRes.anti);
                this.cgN.a(dataRes.location);
                this.cgO = dataRes.has_floor.intValue() == 1;
                if (dataRes.user != null) {
                    this.cgP = dataRes.user.is_manager.intValue();
                }
                this.cgQ.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.cgS.add(muteUser);
                        }
                    }
                }
                this.cgU.parserProtoBuf(dataRes.add_post);
                this.cgL.setReply_num(this.cgL.getReply_num() > 0 ? this.cgL.getReply_num() - 1 : 0);
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        n nVar = new n();
                        nVar.b(app);
                        if (!this.cgV.contains(nVar)) {
                            this.cgV.add(nVar);
                        }
                    }
                }
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.cgQ.getIsSelectTail());
                }
                this.cgW.parserProtobuf(dataRes.twzhibo_anti);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public int afl() {
        return this.cgP;
    }

    public int afm() {
        return this.bPQ;
    }

    public void ih(int i) {
        this.bPQ = i;
    }

    public List<MuteUser> afn() {
        return this.cgS;
    }

    public AdditionData afo() {
        return this.cgU;
    }

    public ArrayList<n> afp() {
        return this.cgV;
    }

    public ArrayList<u> afq() {
        return new ArrayList<>(this.cgM);
    }
}

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
import com.baidu.tbadk.core.data.q;
import com.baidu.tbadk.core.data.z;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.n;
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
    private int cgd;
    private TwzhiboAnti czt;
    private VoteDataInfo czu;
    private boolean czq = true;
    private ArrayList<n> czs = new ArrayList<>();
    private ForumData czh = new ForumData();
    private z czi = new z();
    private ArrayList<o> czj = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private q ceI = new q();
    private AntiData Vx = new AntiData();
    private com.baidu.tbadk.data.d czk = new com.baidu.tbadk.data.d();
    private int czm = 0;
    private boolean czl = false;
    private final UserData czn = new UserData();
    private List<MuteUser> czp = new ArrayList();
    private AdditionData czr = new AdditionData();
    private ad czo = new ad();

    public boolean ajw() {
        return this.czq;
    }

    public void eS(boolean z) {
        this.czq = z;
    }

    public VoteDataInfo ajx() {
        return this.czu;
    }

    public c() {
        this.cgd = 0;
        this.czt = null;
        this.cgd = 0;
        this.czt = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.czj != null && this.czj.size() > 0;
    }

    public String[] aD(Context context) {
        String str = "";
        if (isValid()) {
            o oVar = this.czj.get(0);
            ai aDk = oVar.aDk();
            r1 = aDk != null ? aDk.WN : null;
            str = oVar.aR(context);
            if (this.czi != null && this.czi.getAnchorInfoData() != null && this.czi.getAnchorInfoData().getGroup_id() != 0) {
                str = "[" + context.getString(n.i.msglist_live) + "] " + str;
            }
        }
        return new String[]{r1, str};
    }

    public ForumData ajy() {
        return this.czh;
    }

    public String getForumId() {
        if (this.czh == null) {
            return "";
        }
        return this.czh.getId();
    }

    public z ajz() {
        return this.czi;
    }

    public String getThreadId() {
        if (this.czi == null) {
            return "";
        }
        return this.czi.getId();
    }

    public ArrayList<o> ajA() {
        return this.czj;
    }

    public q getPage() {
        return this.ceI;
    }

    public ad ajB() {
        return this.czo;
    }

    public TwzhiboAnti ajC() {
        return this.czt;
    }

    public void a(q qVar, int i) {
        this.ceI.bD(qVar.sd());
        this.ceI.bC(qVar.rA());
        this.ceI.bB(qVar.sb());
        this.ceI.bE(qVar.se());
        if (i == 0) {
            this.ceI = qVar;
        } else if (i == 1) {
            this.ceI.bF(qVar.sf());
        } else if (i == 2) {
            this.ceI.bG(qVar.sg());
        }
    }

    public AntiData rZ() {
        return this.Vx;
    }

    public UserData getUserData() {
        return this.czn;
    }

    public boolean qp() {
        return this.czi.getIsMarked() != 0;
    }

    public void ab(boolean z) {
        if (this.czi != null) {
            if (z) {
                this.czi.setIsMarked(1);
            } else {
                this.czi.setIsMarked(0);
            }
        }
    }

    public String qo() {
        if (this.czi != null) {
            return this.czi.sP();
        }
        return null;
    }

    public void kx(String str) {
        if (this.czi != null) {
            this.czi.cw(str);
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
                jb(dataRes.is_new_url.intValue());
                this.czh.parserProtobuf(dataRes.forum);
                this.czi.setUserMap(this.userMap);
                this.czi.a(dataRes.thread);
                this.czo.a(dataRes.news_info);
                if (this.czi != null && this.czi.sH() != null) {
                    this.czu = new VoteDataInfo();
                    this.czu.parserProtobuf(ajz().sH());
                }
                List<Post> list2 = dataRes.post_list;
                if (list2 != null && list2.size() > 0) {
                    for (Post post : dataRes.post_list) {
                        o oVar = new o();
                        oVar.setUserMap(this.userMap);
                        oVar.a(post, context);
                        if (oVar.aDd() == 1 && this.czi.sZ()) {
                            oVar.setPostType(this.czi.sY());
                        } else if (oVar.aDd() == 1 && this.czi != null && this.czi.tc()) {
                            oVar.setPostType(36);
                        }
                        this.czj.add(oVar);
                    }
                }
                this.ceI.a(dataRes.page);
                this.Vx.parserProtobuf(dataRes.anti);
                this.czk.a(dataRes.location);
                this.czl = dataRes.has_floor.intValue() == 1;
                if (dataRes.user != null) {
                    this.czm = dataRes.user.is_manager.intValue();
                }
                this.czn.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.czp.add(muteUser);
                        }
                    }
                }
                this.czr.parserProtoBuf(dataRes.add_post);
                this.czi.setReply_num(this.czi.getReply_num() > 0 ? this.czi.getReply_num() - 1 : 0);
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        com.baidu.tieba.tbadkCore.data.n nVar = new com.baidu.tieba.tbadkCore.data.n();
                        nVar.b(app);
                        com.baidu.tieba.tbadkCore.data.d aCS = nVar.aCS();
                        if (!this.czs.contains(nVar) && aCS.dzd != null && !StringUtils.isNull(aCS.dzd.user_name)) {
                            this.czs.add(nVar);
                        }
                    }
                }
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.czn.getIsSelectTail());
                }
                this.czt.parserProtobuf(dataRes.twzhibo_anti);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public int ajD() {
        return this.czm;
    }

    public int ajE() {
        return this.cgd;
    }

    public void jb(int i) {
        this.cgd = i;
    }

    public List<MuteUser> ajF() {
        return this.czp;
    }

    public AdditionData ajG() {
        return this.czr;
    }

    public ArrayList<com.baidu.tieba.tbadkCore.data.n> ajH() {
        return this.czs;
    }

    public ArrayList<u> ajI() {
        return new ArrayList<>(this.czj);
    }
}

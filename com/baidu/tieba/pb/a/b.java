package com.baidu.tieba.pb.a;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AdditionData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.aa;
import com.baidu.tbadk.core.data.q;
import com.baidu.tbadk.core.data.w;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.data.d;
import com.baidu.tbadk.game.GameInfoData;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.data.i;
import com.baidu.tieba.tbadkCore.data.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tbclient.App;
import tbclient.PbPage.DataRes;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes.dex */
public class b {
    private int bxp;
    private boolean bJL = true;
    private ArrayList<i> bJN = new ArrayList<>();
    private ForumData bJD = new ForumData();
    private w bJE = new w();
    private ArrayList<j> bJF = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private q bGk = new q();
    private AntiData Ql = new AntiData();
    private d bJG = new d();
    private int bJI = 0;
    private boolean bJH = false;
    private final UserData bJJ = new UserData();
    private AdditionData bJM = new AdditionData();
    private aa bJK = new aa();

    public boolean aaq() {
        return this.bJL;
    }

    public void dP(boolean z) {
        this.bJL = z;
    }

    public b() {
        this.bxp = 0;
        this.bxp = 0;
    }

    public boolean isValid() {
        return this.bJF != null && this.bJF.size() > 0;
    }

    public String[] aC(Context context) {
        String str = "";
        if (isValid()) {
            j jVar = this.bJF.get(0);
            ao aoI = jVar.aoI();
            r1 = aoI != null ? aoI.Ri : null;
            str = jVar.aK(context);
            if (this.bJE != null && this.bJE.getAnchorInfoData() != null && this.bJE.getAnchorInfoData().getGroup_id() != 0) {
                str = "[" + context.getString(t.msglist_live) + "] " + str;
            }
        }
        return new String[]{r1, str};
    }

    public ForumData aar() {
        return this.bJD;
    }

    public w aas() {
        return this.bJE;
    }

    public ArrayList<j> aat() {
        return this.bJF;
    }

    public q Zp() {
        return this.bGk;
    }

    public aa aau() {
        return this.bJK;
    }

    public void a(q qVar, int i) {
        this.bGk.bm(qVar.qP());
        this.bGk.bl(qVar.qt());
        this.bGk.bk(qVar.qN());
        this.bGk.bn(qVar.qQ());
        if (i == 0) {
            this.bGk = qVar;
        } else if (i == 1) {
            this.bGk.bo(qVar.qR());
        } else if (i == 2) {
            this.bGk.bp(qVar.qS());
        }
    }

    public AntiData qK() {
        return this.Ql;
    }

    public UserData getUserData() {
        return this.bJJ;
    }

    public boolean pq() {
        return this.bJE.rn() != 0;
    }

    public void Z(boolean z) {
        if (this.bJE != null) {
            if (z) {
                this.bJE.bs(1);
            } else {
                this.bJE.bs(0);
            }
        }
    }

    public String pp() {
        if (this.bJE != null) {
            return this.bJE.ro();
        }
        return null;
    }

    public void ik(String str) {
        if (this.bJE != null) {
            this.bJE.ci(str);
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
                        if (userId != null && !userId.equals(GameInfoData.NOT_FROM_DETAIL)) {
                            this.userMap.put(metaData.getUserId(), metaData);
                        }
                    }
                }
                gX(dataRes.is_new_url.intValue());
                this.bJD.parserProtobuf(dataRes.forum);
                this.bJE.setUserMap(this.userMap);
                this.bJE.a(dataRes.thread);
                this.bJK.a(dataRes.news_info);
                List<Post> list2 = dataRes.post_list;
                if (list2 != null && list2.size() > 0) {
                    for (Post post : dataRes.post_list) {
                        j jVar = new j();
                        jVar.setUserMap(this.userMap);
                        jVar.a(post, context);
                        this.bJF.add(jVar);
                    }
                }
                this.bGk.a(dataRes.page);
                this.Ql.parserProtobuf(dataRes.anti);
                this.bJG.a(dataRes.location);
                this.bJH = dataRes.has_floor.intValue() == 1;
                if (dataRes.user != null) {
                    this.bJI = dataRes.user.is_manager.intValue();
                }
                this.bJJ.parserProtobuf(dataRes.user);
                this.bJM.parserProtoBuf(dataRes.add_post);
                this.bJE.setReply_num(this.bJE.getReply_num() > 0 ? this.bJE.getReply_num() - 1 : 0);
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        i iVar = new i();
                        iVar.b(app);
                        if (!this.bJN.contains(iVar)) {
                            this.bJN.add(iVar);
                        }
                    }
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public int aav() {
        return this.bJI;
    }

    public int aaw() {
        return this.bxp;
    }

    public void gX(int i) {
        this.bxp = i;
    }

    public AdditionData aax() {
        return this.bJM;
    }

    public ArrayList<i> aay() {
        return this.bJN;
    }
}

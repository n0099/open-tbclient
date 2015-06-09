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
    private int bxq;
    private boolean bJM = true;
    private ArrayList<i> bJO = new ArrayList<>();
    private ForumData bJE = new ForumData();
    private w bJF = new w();
    private ArrayList<j> bJG = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private q bGl = new q();
    private AntiData Ql = new AntiData();
    private d bJH = new d();
    private int bJJ = 0;
    private boolean bJI = false;
    private final UserData bJK = new UserData();
    private AdditionData bJN = new AdditionData();
    private aa bJL = new aa();

    public boolean aar() {
        return this.bJM;
    }

    public void dP(boolean z) {
        this.bJM = z;
    }

    public b() {
        this.bxq = 0;
        this.bxq = 0;
    }

    public boolean isValid() {
        return this.bJG != null && this.bJG.size() > 0;
    }

    public String[] aC(Context context) {
        String str = "";
        if (isValid()) {
            j jVar = this.bJG.get(0);
            ao aoJ = jVar.aoJ();
            r1 = aoJ != null ? aoJ.Ri : null;
            str = jVar.aK(context);
            if (this.bJF != null && this.bJF.getAnchorInfoData() != null && this.bJF.getAnchorInfoData().getGroup_id() != 0) {
                str = "[" + context.getString(t.msglist_live) + "] " + str;
            }
        }
        return new String[]{r1, str};
    }

    public ForumData aas() {
        return this.bJE;
    }

    public w aat() {
        return this.bJF;
    }

    public ArrayList<j> aau() {
        return this.bJG;
    }

    public q Zq() {
        return this.bGl;
    }

    public aa aav() {
        return this.bJL;
    }

    public void a(q qVar, int i) {
        this.bGl.bm(qVar.qP());
        this.bGl.bl(qVar.qt());
        this.bGl.bk(qVar.qN());
        this.bGl.bn(qVar.qQ());
        if (i == 0) {
            this.bGl = qVar;
        } else if (i == 1) {
            this.bGl.bo(qVar.qR());
        } else if (i == 2) {
            this.bGl.bp(qVar.qS());
        }
    }

    public AntiData qK() {
        return this.Ql;
    }

    public UserData getUserData() {
        return this.bJK;
    }

    public boolean pq() {
        return this.bJF.rn() != 0;
    }

    public void Z(boolean z) {
        if (this.bJF != null) {
            if (z) {
                this.bJF.bs(1);
            } else {
                this.bJF.bs(0);
            }
        }
    }

    public String pp() {
        if (this.bJF != null) {
            return this.bJF.ro();
        }
        return null;
    }

    public void ik(String str) {
        if (this.bJF != null) {
            this.bJF.ci(str);
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
                this.bJE.parserProtobuf(dataRes.forum);
                this.bJF.setUserMap(this.userMap);
                this.bJF.a(dataRes.thread);
                this.bJL.a(dataRes.news_info);
                List<Post> list2 = dataRes.post_list;
                if (list2 != null && list2.size() > 0) {
                    for (Post post : dataRes.post_list) {
                        j jVar = new j();
                        jVar.setUserMap(this.userMap);
                        jVar.a(post, context);
                        this.bJG.add(jVar);
                    }
                }
                this.bGl.a(dataRes.page);
                this.Ql.parserProtobuf(dataRes.anti);
                this.bJH.a(dataRes.location);
                this.bJI = dataRes.has_floor.intValue() == 1;
                if (dataRes.user != null) {
                    this.bJJ = dataRes.user.is_manager.intValue();
                }
                this.bJK.parserProtobuf(dataRes.user);
                this.bJN.parserProtoBuf(dataRes.add_post);
                this.bJF.setReply_num(this.bJF.getReply_num() > 0 ? this.bJF.getReply_num() - 1 : 0);
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        i iVar = new i();
                        iVar.b(app);
                        if (!this.bJO.contains(iVar)) {
                            this.bJO.add(iVar);
                        }
                    }
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public int aaw() {
        return this.bJJ;
    }

    public int aax() {
        return this.bxq;
    }

    public void gX(int i) {
        this.bxq = i;
    }

    public AdditionData aay() {
        return this.bJN;
    }

    public ArrayList<i> aaz() {
        return this.bJO;
    }
}

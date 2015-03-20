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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.data.d;
import com.baidu.tbadk.game.GameInfoData;
import com.baidu.tieba.tbadkCore.c.i;
import com.baidu.tieba.tbadkCore.c.j;
import com.baidu.tieba.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tbclient.App;
import tbclient.PbPage.DataRes;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes.dex */
public class b {
    private int bur;
    private boolean bHj = true;
    private ArrayList<i> bHl = new ArrayList<>();
    private ForumData bHb = new ForumData();
    private w bHc = new w();
    private ArrayList<j> bHd = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private q bDc = new q();
    private AntiData PN = new AntiData();
    private d bHe = new d();
    private int bHg = 0;
    private boolean bHf = false;
    private final UserData bHh = new UserData();
    private AdditionData bHk = new AdditionData();
    private aa bHi = new aa();

    public boolean YN() {
        return this.bHj;
    }

    public void dF(boolean z) {
        this.bHj = z;
    }

    public b() {
        this.bur = 0;
        this.bur = 0;
    }

    public boolean isValid() {
        return this.bHd != null && this.bHd.size() > 0;
    }

    public String[] ay(Context context) {
        String str = "";
        if (isValid()) {
            j jVar = this.bHd.get(0);
            ar amH = jVar.amH();
            r1 = amH != null ? amH.QK : null;
            str = jVar.aF(context);
            if (this.bHc != null && this.bHc.getAnchorInfoData() != null && this.bHc.getAnchorInfoData().getGroup_id() != 0) {
                str = "[" + context.getString(y.msglist_live) + "] " + str;
            }
        }
        return new String[]{r1, str};
    }

    public ForumData YO() {
        return this.bHb;
    }

    public w YP() {
        return this.bHc;
    }

    public ArrayList<j> YQ() {
        return this.bHd;
    }

    public q XE() {
        return this.bDc;
    }

    public aa YR() {
        return this.bHi;
    }

    public void a(q qVar, int i) {
        this.bDc.bp(qVar.qj());
        this.bDc.bo(qVar.pN());
        this.bDc.bn(qVar.qh());
        this.bDc.bq(qVar.qk());
        if (i == 0) {
            this.bDc = qVar;
        } else if (i == 1) {
            this.bDc.br(qVar.ql());
        } else if (i == 2) {
            this.bDc.bs(qVar.qm());
        }
    }

    public AntiData qe() {
        return this.PN;
    }

    public UserData getUserData() {
        return this.bHh;
    }

    public boolean oQ() {
        return this.bHc.qH() != 0;
    }

    public void W(boolean z) {
        if (this.bHc != null) {
            if (z) {
                this.bHc.bv(1);
            } else {
                this.bHc.bv(0);
            }
        }
    }

    public String oP() {
        if (this.bHc != null) {
            return this.bHc.qI();
        }
        return null;
    }

    public void hC(String str) {
        if (this.bHc != null) {
            this.bHc.bV(str);
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
                gE(dataRes.is_new_url.intValue());
                this.bHb.parserProtobuf(dataRes.forum);
                this.bHc.setUserMap(this.userMap);
                this.bHc.a(dataRes.thread);
                this.bHi.a(dataRes.news_info);
                List<Post> list2 = dataRes.post_list;
                if (list2 != null && list2.size() > 0) {
                    for (Post post : dataRes.post_list) {
                        j jVar = new j();
                        jVar.setUserMap(this.userMap);
                        jVar.a(post, context);
                        this.bHd.add(jVar);
                    }
                }
                this.bDc.a(dataRes.page);
                this.PN.parserProtobuf(dataRes.anti);
                this.bHe.a(dataRes.location);
                this.bHf = dataRes.has_floor.intValue() == 1;
                if (dataRes.user != null) {
                    this.bHg = dataRes.user.is_manager.intValue();
                }
                this.bHh.parserProtobuf(dataRes.user);
                this.bHk.parserProtoBuf(dataRes.add_post);
                this.bHc.setReply_num(this.bHc.getReply_num() > 0 ? this.bHc.getReply_num() - 1 : 0);
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        i iVar = new i();
                        iVar.b(app);
                        if (!this.bHl.contains(iVar)) {
                            this.bHl.add(iVar);
                        }
                    }
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public int YS() {
        return this.bHg;
    }

    public int YT() {
        return this.bur;
    }

    public void gE(int i) {
        this.bur = i;
    }

    public AdditionData YU() {
        return this.bHk;
    }

    public ArrayList<i> YV() {
        return this.bHl;
    }
}

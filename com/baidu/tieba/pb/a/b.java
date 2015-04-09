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
    private int buH;
    private boolean bHw = true;
    private ArrayList<i> bHy = new ArrayList<>();
    private ForumData bHo = new ForumData();
    private w bHp = new w();
    private ArrayList<j> bHq = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private q bDp = new q();
    private AntiData PP = new AntiData();
    private d bHr = new d();
    private int bHt = 0;
    private boolean bHs = false;
    private final UserData bHu = new UserData();
    private AdditionData bHx = new AdditionData();
    private aa bHv = new aa();

    public boolean YZ() {
        return this.bHw;
    }

    public void dD(boolean z) {
        this.bHw = z;
    }

    public b() {
        this.buH = 0;
        this.buH = 0;
    }

    public boolean isValid() {
        return this.bHq != null && this.bHq.size() > 0;
    }

    public String[] ay(Context context) {
        String str = "";
        if (isValid()) {
            j jVar = this.bHq.get(0);
            ar amW = jVar.amW();
            r1 = amW != null ? amW.QM : null;
            str = jVar.aF(context);
            if (this.bHp != null && this.bHp.getAnchorInfoData() != null && this.bHp.getAnchorInfoData().getGroup_id() != 0) {
                str = "[" + context.getString(y.msglist_live) + "] " + str;
            }
        }
        return new String[]{r1, str};
    }

    public ForumData Za() {
        return this.bHo;
    }

    public w Zb() {
        return this.bHp;
    }

    public ArrayList<j> Zc() {
        return this.bHq;
    }

    public q XQ() {
        return this.bDp;
    }

    public aa Zd() {
        return this.bHv;
    }

    public void a(q qVar, int i) {
        this.bDp.bp(qVar.qj());
        this.bDp.bo(qVar.pN());
        this.bDp.bn(qVar.qh());
        this.bDp.bq(qVar.qk());
        if (i == 0) {
            this.bDp = qVar;
        } else if (i == 1) {
            this.bDp.br(qVar.ql());
        } else if (i == 2) {
            this.bDp.bs(qVar.qm());
        }
    }

    public AntiData qe() {
        return this.PP;
    }

    public UserData getUserData() {
        return this.bHu;
    }

    public boolean oQ() {
        return this.bHp.qH() != 0;
    }

    public void W(boolean z) {
        if (this.bHp != null) {
            if (z) {
                this.bHp.bv(1);
            } else {
                this.bHp.bv(0);
            }
        }
    }

    public String oP() {
        if (this.bHp != null) {
            return this.bHp.qI();
        }
        return null;
    }

    public void hF(String str) {
        if (this.bHp != null) {
            this.bHp.bV(str);
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
                gG(dataRes.is_new_url.intValue());
                this.bHo.parserProtobuf(dataRes.forum);
                this.bHp.setUserMap(this.userMap);
                this.bHp.a(dataRes.thread);
                this.bHv.a(dataRes.news_info);
                List<Post> list2 = dataRes.post_list;
                if (list2 != null && list2.size() > 0) {
                    for (Post post : dataRes.post_list) {
                        j jVar = new j();
                        jVar.setUserMap(this.userMap);
                        jVar.a(post, context);
                        this.bHq.add(jVar);
                    }
                }
                this.bDp.a(dataRes.page);
                this.PP.parserProtobuf(dataRes.anti);
                this.bHr.a(dataRes.location);
                this.bHs = dataRes.has_floor.intValue() == 1;
                if (dataRes.user != null) {
                    this.bHt = dataRes.user.is_manager.intValue();
                }
                this.bHu.parserProtobuf(dataRes.user);
                this.bHx.parserProtoBuf(dataRes.add_post);
                this.bHp.setReply_num(this.bHp.getReply_num() > 0 ? this.bHp.getReply_num() - 1 : 0);
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        i iVar = new i();
                        iVar.b(app);
                        if (!this.bHy.contains(iVar)) {
                            this.bHy.add(iVar);
                        }
                    }
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public int Ze() {
        return this.bHt;
    }

    public int Zf() {
        return this.buH;
    }

    public void gG(int i) {
        this.buH = i;
    }

    public AdditionData Zg() {
        return this.bHx;
    }

    public ArrayList<i> Zh() {
        return this.bHy;
    }
}

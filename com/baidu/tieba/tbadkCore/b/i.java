package com.baidu.tieba.tbadkCore.b;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AdditionData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.q;
import com.baidu.tbadk.core.data.x;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tbclient.App;
import tbclient.PbPage.DataRes;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes.dex */
public class i {
    private int ata;
    private boolean bYA = true;
    private ArrayList<j> bYC = new ArrayList<>();
    private ForumData bTA = new ForumData();
    private x bYv = new x();
    private ArrayList<k> bYw = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private q btC = new q();
    private AntiData DY = new AntiData();
    private com.baidu.tbadk.data.d bYx = new com.baidu.tbadk.data.d();
    private int bYz = 0;
    private boolean bYy = false;
    private final UserData bTF = new UserData();
    private AdditionData bYB = new AdditionData();

    public boolean ahd() {
        return this.bYA;
    }

    public void eC(boolean z) {
        this.bYA = z;
    }

    public i() {
        this.ata = 0;
        this.ata = 0;
    }

    public boolean isValid() {
        return this.bYw != null && this.bYw.size() > 0;
    }

    public String[] ax(Context context) {
        String str = "";
        if (isValid()) {
            k kVar = this.bYw.get(0);
            at ahA = kVar.ahA();
            r1 = ahA != null ? ahA.EX : null;
            str = kVar.aA(context);
            if (this.bYv != null && this.bYv.getAnchorInfoData() != null && this.bYv.getAnchorInfoData().getGroup_id() != 0) {
                str = "[" + context.getString(z.msglist_live) + "] " + str;
            }
        }
        return new String[]{r1, str};
    }

    public ForumData aeI() {
        return this.bTA;
    }

    public x ahe() {
        return this.bYv;
    }

    public ArrayList<k> ahf() {
        return this.bYw;
    }

    public q mT() {
        return this.btC;
    }

    public void a(q qVar, int i) {
        this.btC.bq(qVar.mP());
        this.btC.bp(qVar.mm());
        this.btC.bo(qVar.mN());
        this.btC.br(qVar.mQ());
        if (i == 0) {
            this.btC = qVar;
        } else if (i == 1) {
            this.btC.bs(qVar.mR());
        } else if (i == 2) {
            this.btC.bt(qVar.mS());
        }
    }

    public AntiData mK() {
        return this.DY;
    }

    public UserData getUserData() {
        return this.bTF;
    }

    public boolean lb() {
        return this.bYv.nr() != 0;
    }

    public void Y(boolean z) {
        if (this.bYv != null) {
            if (z) {
                this.bYv.bw(1);
            } else {
                this.bYv.bw(0);
            }
        }
    }

    public String ld() {
        if (this.bYv != null) {
            return this.bYv.ns();
        }
        return null;
    }

    public void il(String str) {
        if (this.bYv != null) {
            this.bYv.bO(str);
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
                gL(dataRes.is_new_url.intValue());
                this.bTA.parserProtobuf(dataRes.forum);
                this.bYv.setUserMap(this.userMap);
                this.bYv.a(dataRes.thread);
                List<Post> list2 = dataRes.post_list;
                if (list2 != null && list2.size() > 0) {
                    for (Post post : dataRes.post_list) {
                        k kVar = new k();
                        kVar.setUserMap(this.userMap);
                        kVar.a(post, context);
                        this.bYw.add(kVar);
                    }
                }
                this.btC.a(dataRes.page);
                this.DY.parserProtobuf(dataRes.anti);
                this.bYx.a(dataRes.location);
                this.bYy = dataRes.has_floor.intValue() == 1;
                if (dataRes.user != null) {
                    this.bYz = dataRes.user.is_manager.intValue();
                }
                this.bTF.parserProtobuf(dataRes.user);
                this.bYB.parserProtoBuf(dataRes.add_post);
                this.bYv.setReply_num(this.bYv.getReply_num() > 0 ? this.bYv.getReply_num() - 1 : 0);
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        j jVar = new j();
                        jVar.b(app);
                        if (!this.bYC.contains(jVar)) {
                            this.bYC.add(jVar);
                        }
                    }
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public int ahg() {
        return this.bYz;
    }

    public int CB() {
        return this.ata;
    }

    public void gL(int i) {
        this.ata = i;
    }

    public AdditionData ahh() {
        return this.bYB;
    }

    public ArrayList<j> ahi() {
        return this.bYC;
    }
}

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
    private int atd;
    private boolean bYB = true;
    private ArrayList<j> bYD = new ArrayList<>();
    private ForumData bTB = new ForumData();
    private x bYw = new x();
    private ArrayList<k> bYx = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private q btD = new q();
    private AntiData Eb = new AntiData();
    private com.baidu.tbadk.data.d bYy = new com.baidu.tbadk.data.d();
    private int bYA = 0;
    private boolean bYz = false;
    private final UserData bTG = new UserData();
    private AdditionData bYC = new AdditionData();

    public boolean ahi() {
        return this.bYB;
    }

    public void eC(boolean z) {
        this.bYB = z;
    }

    public i() {
        this.atd = 0;
        this.atd = 0;
    }

    public boolean isValid() {
        return this.bYx != null && this.bYx.size() > 0;
    }

    public String[] ax(Context context) {
        String str = "";
        if (isValid()) {
            k kVar = this.bYx.get(0);
            at ahF = kVar.ahF();
            r1 = ahF != null ? ahF.Fa : null;
            str = kVar.aA(context);
            if (this.bYw != null && this.bYw.getAnchorInfoData() != null && this.bYw.getAnchorInfoData().getGroup_id() != 0) {
                str = "[" + context.getString(z.msglist_live) + "] " + str;
            }
        }
        return new String[]{r1, str};
    }

    public ForumData aeN() {
        return this.bTB;
    }

    public x ahj() {
        return this.bYw;
    }

    public ArrayList<k> ahk() {
        return this.bYx;
    }

    public q na() {
        return this.btD;
    }

    public void a(q qVar, int i) {
        this.btD.bq(qVar.mW());
        this.btD.bp(qVar.mt());
        this.btD.bo(qVar.mU());
        this.btD.br(qVar.mX());
        if (i == 0) {
            this.btD = qVar;
        } else if (i == 1) {
            this.btD.bs(qVar.mY());
        } else if (i == 2) {
            this.btD.bt(qVar.mZ());
        }
    }

    public AntiData mR() {
        return this.Eb;
    }

    public UserData getUserData() {
        return this.bTG;
    }

    public boolean li() {
        return this.bYw.ny() != 0;
    }

    public void Y(boolean z) {
        if (this.bYw != null) {
            if (z) {
                this.bYw.bw(1);
            } else {
                this.bYw.bw(0);
            }
        }
    }

    public String lk() {
        if (this.bYw != null) {
            return this.bYw.nz();
        }
        return null;
    }

    public void in(String str) {
        if (this.bYw != null) {
            this.bYw.bR(str);
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
                this.bTB.parserProtobuf(dataRes.forum);
                this.bYw.setUserMap(this.userMap);
                this.bYw.a(dataRes.thread);
                List<Post> list2 = dataRes.post_list;
                if (list2 != null && list2.size() > 0) {
                    for (Post post : dataRes.post_list) {
                        k kVar = new k();
                        kVar.setUserMap(this.userMap);
                        kVar.a(post, context);
                        this.bYx.add(kVar);
                    }
                }
                this.btD.a(dataRes.page);
                this.Eb.parserProtobuf(dataRes.anti);
                this.bYy.a(dataRes.location);
                this.bYz = dataRes.has_floor.intValue() == 1;
                if (dataRes.user != null) {
                    this.bYA = dataRes.user.is_manager.intValue();
                }
                this.bTG.parserProtobuf(dataRes.user);
                this.bYC.parserProtoBuf(dataRes.add_post);
                this.bYw.setReply_num(this.bYw.getReply_num() > 0 ? this.bYw.getReply_num() - 1 : 0);
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        j jVar = new j();
                        jVar.b(app);
                        if (!this.bYD.contains(jVar)) {
                            this.bYD.add(jVar);
                        }
                    }
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public int ahl() {
        return this.bYA;
    }

    public int CH() {
        return this.atd;
    }

    public void gL(int i) {
        this.atd = i;
    }

    public AdditionData ahm() {
        return this.bYC;
    }

    public ArrayList<j> ahn() {
        return this.bYD;
    }
}

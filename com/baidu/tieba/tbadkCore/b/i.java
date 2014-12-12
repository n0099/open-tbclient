package com.baidu.tieba.tbadkCore.b;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AdditionData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.p;
import com.baidu.tbadk.core.data.w;
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
    private int arY;
    private boolean bWJ = true;
    private ArrayList<j> bWL = new ArrayList<>();
    private ForumData bRO = new ForumData();
    private w bWE = new w();
    private ArrayList<k> bWF = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private p bsg = new p();
    private AntiData DX = new AntiData();
    private com.baidu.tbadk.data.d bWG = new com.baidu.tbadk.data.d();
    private int bWI = 0;
    private boolean bWH = false;
    private final UserData bRT = new UserData();
    private AdditionData bWK = new AdditionData();

    public boolean agD() {
        return this.bWJ;
    }

    public void ev(boolean z) {
        this.bWJ = z;
    }

    public i() {
        this.arY = 0;
        this.arY = 0;
    }

    public boolean isValid() {
        return this.bWF != null && this.bWF.size() > 0;
    }

    public String[] aw(Context context) {
        String str = "";
        if (isValid()) {
            k kVar = this.bWF.get(0);
            at aha = kVar.aha();
            r1 = aha != null ? aha.imgUrl : null;
            str = kVar.az(context);
            if (this.bWE != null && this.bWE.getAnchorInfoData() != null && this.bWE.getAnchorInfoData().getGroup_id() != 0) {
                str = "[" + context.getString(z.msglist_live) + "] " + str;
            }
        }
        return new String[]{r1, str};
    }

    public ForumData aej() {
        return this.bRO;
    }

    public w agE() {
        return this.bWE;
    }

    public ArrayList<k> agF() {
        return this.bWF;
    }

    public p mY() {
        return this.bsg;
    }

    public void a(p pVar, int i) {
        this.bsg.bl(pVar.mU());
        this.bsg.bk(pVar.mt());
        this.bsg.bj(pVar.mS());
        this.bsg.bm(pVar.mV());
        if (i == 0) {
            this.bsg = pVar;
        } else if (i == 1) {
            this.bsg.bn(pVar.mW());
        } else if (i == 2) {
            this.bsg.bo(pVar.mX());
        }
    }

    public AntiData mP() {
        return this.DX;
    }

    public UserData getUserData() {
        return this.bRT;
    }

    public boolean li() {
        return this.bWE.nw() != 0;
    }

    public void Y(boolean z) {
        if (this.bWE != null) {
            if (z) {
                this.bWE.br(1);
            } else {
                this.bWE.br(0);
            }
        }
    }

    public String lk() {
        if (this.bWE != null) {
            return this.bWE.nx();
        }
        return null;
    }

    public void ig(String str) {
        if (this.bWE != null) {
            this.bWE.bT(str);
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
                gC(dataRes.is_new_url.intValue());
                this.bRO.parserProtobuf(dataRes.forum);
                this.bWE.setUserMap(this.userMap);
                this.bWE.a(dataRes.thread);
                List<Post> list2 = dataRes.post_list;
                if (list2 != null && list2.size() > 0) {
                    for (Post post : dataRes.post_list) {
                        k kVar = new k();
                        kVar.setUserMap(this.userMap);
                        kVar.a(post, context);
                        this.bWF.add(kVar);
                    }
                }
                this.bsg.a(dataRes.page);
                this.DX.parserProtobuf(dataRes.anti);
                this.bWG.a(dataRes.location);
                this.bWH = dataRes.has_floor.intValue() == 1;
                if (dataRes.user != null) {
                    this.bWI = dataRes.user.is_manager.intValue();
                }
                this.bRT.parserProtobuf(dataRes.user);
                this.bWK.parserProtoBuf(dataRes.add_post);
                this.bWE.setReply_num(this.bWE.getReply_num() > 0 ? this.bWE.getReply_num() - 1 : 0);
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        j jVar = new j();
                        jVar.b(app);
                        if (!this.bWL.contains(jVar)) {
                            this.bWL.add(jVar);
                        }
                    }
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public int agG() {
        return this.bWI;
    }

    public int Ci() {
        return this.arY;
    }

    public void gC(int i) {
        this.arY = i;
    }

    public AdditionData agH() {
        return this.bWK;
    }

    public ArrayList<j> agI() {
        return this.bWL;
    }
}

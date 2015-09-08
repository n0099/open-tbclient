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
import com.baidu.tbadk.core.data.ab;
import com.baidu.tbadk.core.data.o;
import com.baidu.tbadk.core.data.x;
import com.baidu.tbadk.core.util.ac;
import com.baidu.tbadk.data.d;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.data.h;
import com.baidu.tieba.tbadkCore.data.i;
import com.baidu.tieba.usermute.data.MuteUser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tbclient.App;
import tbclient.PbPage.DataRes;
import tbclient.Post;
import tbclient.SimpleUser;
import tbclient.User;
/* loaded from: classes.dex */
public class b {
    private int bLM;
    private TwzhiboAnti cbc;
    private boolean caZ = true;
    private ArrayList<h> cbb = new ArrayList<>();
    private ForumData caQ = new ForumData();
    private x caR = new x();
    private ArrayList<i> caS = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private o bWI = new o();
    private AntiData Vc = new AntiData();
    private d caT = new d();
    private int caV = 0;
    private boolean caU = false;
    private final UserData caW = new UserData();
    private List<MuteUser> caY = new ArrayList();
    private AdditionData cba = new AdditionData();
    private ab caX = new ab();

    public boolean acO() {
        return this.caZ;
    }

    public void ej(boolean z) {
        this.caZ = z;
    }

    public b() {
        this.bLM = 0;
        this.cbc = null;
        this.bLM = 0;
        this.cbc = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.caS != null && this.caS.size() > 0;
    }

    public String[] aF(Context context) {
        String str = "";
        if (isValid()) {
            i iVar = this.caS.get(0);
            ac auq = iVar.auq();
            r1 = auq != null ? auq.Wg : null;
            str = iVar.aU(context);
            if (this.caR != null && this.caR.getAnchorInfoData() != null && this.caR.getAnchorInfoData().getGroup_id() != 0) {
                str = "[" + context.getString(i.h.msglist_live) + "] " + str;
            }
        }
        return new String[]{r1, str};
    }

    public ForumData acP() {
        return this.caQ;
    }

    public x acQ() {
        return this.caR;
    }

    public ArrayList<com.baidu.tieba.tbadkCore.data.i> acR() {
        return this.caS;
    }

    public o getPage() {
        return this.bWI;
    }

    public ab acS() {
        return this.caX;
    }

    public TwzhiboAnti acT() {
        return this.cbc;
    }

    public void a(o oVar, int i) {
        this.bWI.bw(oVar.rO());
        this.bWI.bv(oVar.rt());
        this.bWI.bu(oVar.rM());
        this.bWI.bx(oVar.rP());
        if (i == 0) {
            this.bWI = oVar;
        } else if (i == 1) {
            this.bWI.by(oVar.rQ());
        } else if (i == 2) {
            this.bWI.bz(oVar.rR());
        }
    }

    public AntiData rK() {
        return this.Vc;
    }

    public UserData getUserData() {
        return this.caW;
    }

    public boolean qo() {
        return this.caR.getIsMarked() != 0;
    }

    public void ab(boolean z) {
        if (this.caR != null) {
            if (z) {
                this.caR.setIsMarked(1);
            } else {
                this.caR.setIsMarked(0);
            }
        }
    }

    public String qn() {
        if (this.caR != null) {
            return this.caR.ss();
        }
        return null;
    }

    public void jo(String str) {
        if (this.caR != null) {
            this.caR.co(str);
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
                hL(dataRes.is_new_url.intValue());
                this.caQ.parserProtobuf(dataRes.forum);
                this.caR.setUserMap(this.userMap);
                this.caR.a(dataRes.thread);
                this.caX.a(dataRes.news_info);
                List<Post> list2 = dataRes.post_list;
                if (list2 != null && list2.size() > 0) {
                    for (Post post : dataRes.post_list) {
                        com.baidu.tieba.tbadkCore.data.i iVar = new com.baidu.tieba.tbadkCore.data.i();
                        iVar.setUserMap(this.userMap);
                        iVar.a(post, context);
                        this.caS.add(iVar);
                    }
                }
                this.bWI.a(dataRes.page);
                this.Vc.parserProtobuf(dataRes.anti);
                this.caT.a(dataRes.location);
                this.caU = dataRes.has_floor.intValue() == 1;
                if (dataRes.user != null) {
                    this.caV = dataRes.user.is_manager.intValue();
                }
                this.caW.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.caY.add(muteUser);
                        }
                    }
                }
                this.cba.parserProtoBuf(dataRes.add_post);
                this.caR.setReply_num(this.caR.getReply_num() > 0 ? this.caR.getReply_num() - 1 : 0);
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        h hVar = new h();
                        hVar.b(app);
                        if (!this.cbb.contains(hVar)) {
                            this.cbb.add(hVar);
                        }
                    }
                }
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.caW.getIsSelectTail());
                }
                this.cbc.parserProtobuf(dataRes.twzhibo_anti);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public int acU() {
        return this.caV;
    }

    public int acV() {
        return this.bLM;
    }

    public void hL(int i) {
        this.bLM = i;
    }

    public List<MuteUser> acW() {
        return this.caY;
    }

    public AdditionData acX() {
        return this.cba;
    }

    public ArrayList<h> acY() {
        return this.cbb;
    }

    public ArrayList<u> acZ() {
        return new ArrayList<>(this.caS);
    }
}

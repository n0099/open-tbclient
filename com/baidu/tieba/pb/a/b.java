package com.baidu.tieba.pb.a;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AdditionData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.p;
import com.baidu.tbadk.core.data.v;
import com.baidu.tbadk.core.data.z;
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
    private int bLf;
    private boolean caf = true;
    private ArrayList<h> cah = new ArrayList<>();
    private ForumData bZW = new ForumData();
    private v bZX = new v();
    private ArrayList<i> bZY = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private p bWc = new p();
    private AntiData Vd = new AntiData();
    private d bZZ = new d();
    private int cab = 0;
    private boolean caa = false;
    private final UserData cac = new UserData();
    private List<MuteUser> cae = new ArrayList();
    private AdditionData cag = new AdditionData();
    private z cad = new z();

    public boolean acF() {
        return this.caf;
    }

    public void ec(boolean z) {
        this.caf = z;
    }

    public b() {
        this.bLf = 0;
        this.bLf = 0;
    }

    public boolean isValid() {
        return this.bZY != null && this.bZY.size() > 0;
    }

    public String[] aG(Context context) {
        String str = "";
        if (isValid()) {
            i iVar = this.bZY.get(0);
            ac aqc = iVar.aqc();
            r1 = aqc != null ? aqc.VY : null;
            str = iVar.aR(context);
            if (this.bZX != null && this.bZX.getAnchorInfoData() != null && this.bZX.getAnchorInfoData().getGroup_id() != 0) {
                str = "[" + context.getString(i.C0057i.msglist_live) + "] " + str;
            }
        }
        return new String[]{r1, str};
    }

    public ForumData acG() {
        return this.bZW;
    }

    public v acH() {
        return this.bZX;
    }

    public ArrayList<com.baidu.tieba.tbadkCore.data.i> acI() {
        return this.bZY;
    }

    public p getPage() {
        return this.bWc;
    }

    public z acJ() {
        return this.cad;
    }

    public void a(p pVar, int i) {
        this.bWc.bv(pVar.rR());
        this.bWc.bu(pVar.ru());
        this.bWc.bt(pVar.rP());
        this.bWc.bw(pVar.rS());
        if (i == 0) {
            this.bWc = pVar;
        } else if (i == 1) {
            this.bWc.bx(pVar.rT());
        } else if (i == 2) {
            this.bWc.by(pVar.rU());
        }
    }

    public AntiData rM() {
        return this.Vd;
    }

    public UserData getUserData() {
        return this.cac;
    }

    public boolean qr() {
        return this.bZX.getIsMarked() != 0;
    }

    public void ab(boolean z) {
        if (this.bZX != null) {
            if (z) {
                this.bZX.setIsMarked(1);
            } else {
                this.bZX.setIsMarked(0);
            }
        }
    }

    public String qq() {
        if (this.bZX != null) {
            return this.bZX.sr();
        }
        return null;
    }

    public void jg(String str) {
        if (this.bZX != null) {
            this.bZX.ci(str);
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
                hB(dataRes.is_new_url.intValue());
                this.bZW.parserProtobuf(dataRes.forum);
                this.bZX.setUserMap(this.userMap);
                this.bZX.a(dataRes.thread);
                this.cad.a(dataRes.news_info);
                List<Post> list2 = dataRes.post_list;
                if (list2 != null && list2.size() > 0) {
                    for (Post post : dataRes.post_list) {
                        com.baidu.tieba.tbadkCore.data.i iVar = new com.baidu.tieba.tbadkCore.data.i();
                        iVar.setUserMap(this.userMap);
                        iVar.a(post, context);
                        this.bZY.add(iVar);
                    }
                }
                this.bWc.a(dataRes.page);
                this.Vd.parserProtobuf(dataRes.anti);
                this.bZZ.a(dataRes.location);
                this.caa = dataRes.has_floor.intValue() == 1;
                if (dataRes.user != null) {
                    this.cab = dataRes.user.is_manager.intValue();
                }
                this.cac.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.cae.add(muteUser);
                        }
                    }
                }
                this.cag.parserProtoBuf(dataRes.add_post);
                this.bZX.setReply_num(this.bZX.getReply_num() > 0 ? this.bZX.getReply_num() - 1 : 0);
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        h hVar = new h();
                        hVar.b(app);
                        if (!this.cah.contains(hVar)) {
                            this.cah.add(hVar);
                        }
                    }
                }
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.cac.getIsSelectTail());
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public int acK() {
        return this.cab;
    }

    public int acL() {
        return this.bLf;
    }

    public void hB(int i) {
        this.bLf = i;
    }

    public List<MuteUser> acM() {
        return this.cae;
    }

    public AdditionData acN() {
        return this.cag;
    }

    public ArrayList<h> acO() {
        return this.cah;
    }
}

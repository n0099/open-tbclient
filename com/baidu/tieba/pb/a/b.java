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
import com.baidu.tbadk.core.data.aa;
import com.baidu.tbadk.core.data.o;
import com.baidu.tbadk.core.data.w;
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.data.d;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.data.j;
import com.baidu.tieba.tbadkCore.data.k;
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
public class b {
    private int bPv;
    private TwzhiboAnti cgr;
    private VoteDataInfo cgs;
    private boolean cgo = true;
    private ArrayList<j> cgq = new ArrayList<>();
    private ForumData cgf = new ForumData();
    private w cgg = new w();
    private ArrayList<k> cgh = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private o caH = new o();
    private AntiData UT = new AntiData();
    private d cgi = new d();
    private int cgk = 0;
    private boolean cgj = false;
    private final UserData cgl = new UserData();
    private List<MuteUser> cgn = new ArrayList();
    private AdditionData cgp = new AdditionData();
    private aa cgm = new aa();

    public boolean aeH() {
        return this.cgo;
    }

    public void eo(boolean z) {
        this.cgo = z;
    }

    public VoteDataInfo aeI() {
        return this.cgs;
    }

    public b() {
        this.bPv = 0;
        this.cgr = null;
        this.bPv = 0;
        this.cgr = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.cgh != null && this.cgh.size() > 0;
    }

    public String[] aE(Context context) {
        String str = "";
        if (isValid()) {
            k kVar = this.cgh.get(0);
            ad awL = kVar.awL();
            r1 = awL != null ? awL.Wa : null;
            str = kVar.aT(context);
            if (this.cgg != null && this.cgg.getAnchorInfoData() != null && this.cgg.getAnchorInfoData().getGroup_id() != 0) {
                str = "[" + context.getString(i.h.msglist_live) + "] " + str;
            }
        }
        return new String[]{r1, str};
    }

    public ForumData aeJ() {
        return this.cgf;
    }

    public w aeK() {
        return this.cgg;
    }

    public ArrayList<k> aeL() {
        return this.cgh;
    }

    public o getPage() {
        return this.caH;
    }

    public aa aeM() {
        return this.cgm;
    }

    public TwzhiboAnti aeN() {
        return this.cgr;
    }

    public void a(o oVar, int i) {
        this.caH.bw(oVar.rG());
        this.caH.bv(oVar.rl());
        this.caH.bu(oVar.rE());
        this.caH.bx(oVar.rH());
        if (i == 0) {
            this.caH = oVar;
        } else if (i == 1) {
            this.caH.by(oVar.rI());
        } else if (i == 2) {
            this.caH.bz(oVar.rJ());
        }
    }

    public AntiData rC() {
        return this.UT;
    }

    public UserData getUserData() {
        return this.cgl;
    }

    public boolean qh() {
        return this.cgg.getIsMarked() != 0;
    }

    public void ab(boolean z) {
        if (this.cgg != null) {
            if (z) {
                this.cgg.setIsMarked(1);
            } else {
                this.cgg.setIsMarked(0);
            }
        }
    }

    public String qg() {
        if (this.cgg != null) {
            return this.cgg.sk();
        }
        return null;
    }

    public void jG(String str) {
        if (this.cgg != null) {
            this.cgg.cp(str);
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
                hT(dataRes.is_new_url.intValue());
                this.cgf.parserProtobuf(dataRes.forum);
                this.cgg.setUserMap(this.userMap);
                this.cgg.a(dataRes.thread);
                this.cgm.a(dataRes.news_info);
                if (this.cgg != null && this.cgg.sd() != null) {
                    this.cgs = new VoteDataInfo();
                    this.cgs.parserProtobuf(aeK().sd());
                }
                List<Post> list2 = dataRes.post_list;
                if (list2 != null && list2.size() > 0) {
                    for (Post post : dataRes.post_list) {
                        k kVar = new k();
                        kVar.setUserMap(this.userMap);
                        kVar.a(post, context);
                        if (kVar.awE() == 1 && this.cgg.sv()) {
                            kVar.setPostType(this.cgg.su());
                        } else if (kVar.awE() == 1 && this.cgg != null && this.cgg.sy()) {
                            kVar.setPostType(36);
                        }
                        this.cgh.add(kVar);
                    }
                }
                this.caH.a(dataRes.page);
                this.UT.parserProtobuf(dataRes.anti);
                this.cgi.a(dataRes.location);
                this.cgj = dataRes.has_floor.intValue() == 1;
                if (dataRes.user != null) {
                    this.cgk = dataRes.user.is_manager.intValue();
                }
                this.cgl.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.cgn.add(muteUser);
                        }
                    }
                }
                this.cgp.parserProtoBuf(dataRes.add_post);
                this.cgg.setReply_num(this.cgg.getReply_num() > 0 ? this.cgg.getReply_num() - 1 : 0);
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        j jVar = new j();
                        jVar.b(app);
                        if (!this.cgq.contains(jVar)) {
                            this.cgq.add(jVar);
                        }
                    }
                }
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.cgl.getIsSelectTail());
                }
                this.cgr.parserProtobuf(dataRes.twzhibo_anti);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public int aeO() {
        return this.cgk;
    }

    public int aeP() {
        return this.bPv;
    }

    public void hT(int i) {
        this.bPv = i;
    }

    public List<MuteUser> aeQ() {
        return this.cgn;
    }

    public AdditionData aeR() {
        return this.cgp;
    }

    public ArrayList<j> aeS() {
        return this.cgq;
    }

    public ArrayList<u> aeT() {
        return new ArrayList<>(this.cgh);
    }
}

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
import com.baidu.tbadk.core.data.n;
import com.baidu.tbadk.core.data.v;
import com.baidu.tbadk.core.data.z;
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
    private int bPk;
    private TwzhiboAnti cgg;
    private VoteDataInfo cgh;
    private boolean cgd = true;
    private ArrayList<j> cgf = new ArrayList<>();
    private ForumData cfU = new ForumData();
    private v cfV = new v();
    private ArrayList<k> cfW = new ArrayList<>();
    private HashMap<String, MetaData> userMap = new HashMap<>();
    private n caw = new n();
    private AntiData UR = new AntiData();
    private d cfX = new d();
    private int cfZ = 0;
    private boolean cfY = false;
    private final UserData cga = new UserData();
    private List<MuteUser> cgc = new ArrayList();
    private AdditionData cge = new AdditionData();
    private z cgb = new z();

    public boolean aeL() {
        return this.cgd;
    }

    public void eo(boolean z) {
        this.cgd = z;
    }

    public VoteDataInfo aeM() {
        return this.cgh;
    }

    public b() {
        this.bPk = 0;
        this.cgg = null;
        this.bPk = 0;
        this.cgg = new TwzhiboAnti();
    }

    public boolean isValid() {
        return this.cfW != null && this.cfW.size() > 0;
    }

    public String[] aE(Context context) {
        String str = "";
        if (isValid()) {
            k kVar = this.cfW.get(0);
            ad awF = kVar.awF();
            r1 = awF != null ? awF.VY : null;
            str = kVar.aT(context);
            if (this.cfV != null && this.cfV.getAnchorInfoData() != null && this.cfV.getAnchorInfoData().getGroup_id() != 0) {
                str = "[" + context.getString(i.h.msglist_live) + "] " + str;
            }
        }
        return new String[]{r1, str};
    }

    public ForumData aeN() {
        return this.cfU;
    }

    public v aeO() {
        return this.cfV;
    }

    public ArrayList<k> aeP() {
        return this.cfW;
    }

    public n getPage() {
        return this.caw;
    }

    public z aeQ() {
        return this.cgb;
    }

    public TwzhiboAnti aeR() {
        return this.cgg;
    }

    public void a(n nVar, int i) {
        this.caw.bw(nVar.rJ());
        this.caw.bv(nVar.ro());
        this.caw.bu(nVar.rH());
        this.caw.bx(nVar.rK());
        if (i == 0) {
            this.caw = nVar;
        } else if (i == 1) {
            this.caw.by(nVar.rL());
        } else if (i == 2) {
            this.caw.bz(nVar.rM());
        }
    }

    public AntiData rF() {
        return this.UR;
    }

    public UserData getUserData() {
        return this.cga;
    }

    public boolean qk() {
        return this.cfV.getIsMarked() != 0;
    }

    public void ab(boolean z) {
        if (this.cfV != null) {
            if (z) {
                this.cfV.setIsMarked(1);
            } else {
                this.cfV.setIsMarked(0);
            }
        }
    }

    public String qj() {
        if (this.cfV != null) {
            return this.cfV.sn();
        }
        return null;
    }

    public void jG(String str) {
        if (this.cfV != null) {
            this.cfV.co(str);
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
                this.cfU.parserProtobuf(dataRes.forum);
                this.cfV.setUserMap(this.userMap);
                this.cfV.a(dataRes.thread);
                this.cgb.a(dataRes.news_info);
                if (this.cfV != null && this.cfV.sg() != null) {
                    this.cgh = new VoteDataInfo();
                    this.cgh.parserProtobuf(aeO().sg());
                }
                List<Post> list2 = dataRes.post_list;
                if (list2 != null && list2.size() > 0) {
                    for (Post post : dataRes.post_list) {
                        k kVar = new k();
                        kVar.setUserMap(this.userMap);
                        kVar.a(post, context);
                        if (kVar.awy() == 1 && this.cfV.sy()) {
                            kVar.setPostType(this.cfV.sx());
                        } else if (kVar.awy() == 1 && this.cfV != null && this.cfV.sB()) {
                            kVar.setPostType(36);
                        }
                        this.cfW.add(kVar);
                    }
                }
                this.caw.a(dataRes.page);
                this.UR.parserProtobuf(dataRes.anti);
                this.cfX.a(dataRes.location);
                this.cfY = dataRes.has_floor.intValue() == 1;
                if (dataRes.user != null) {
                    this.cfZ = dataRes.user.is_manager.intValue();
                }
                this.cga.parserProtobuf(dataRes.user);
                if (dataRes.user != null && dataRes.user.mute_user != null) {
                    for (SimpleUser simpleUser : dataRes.user.mute_user) {
                        if (simpleUser != null) {
                            MuteUser muteUser = new MuteUser();
                            muteUser.parserProtobuf(simpleUser);
                            this.cgc.add(muteUser);
                        }
                    }
                }
                this.cge.parserProtoBuf(dataRes.add_post);
                this.cfV.setReply_num(this.cfV.getReply_num() > 0 ? this.cfV.getReply_num() - 1 : 0);
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        j jVar = new j();
                        jVar.b(app);
                        if (!this.cgf.contains(jVar)) {
                            this.cgf.add(jVar);
                        }
                    }
                }
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.cga.getIsSelectTail());
                }
                this.cgg.parserProtobuf(dataRes.twzhibo_anti);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public int aeS() {
        return this.cfZ;
    }

    public int aeT() {
        return this.bPk;
    }

    public void hT(int i) {
        this.bPk = i;
    }

    public List<MuteUser> aeU() {
        return this.cgc;
    }

    public AdditionData aeV() {
        return this.cge;
    }

    public ArrayList<j> aeW() {
        return this.cgf;
    }

    public ArrayList<u> aeX() {
        return new ArrayList<>(this.cfW);
    }
}

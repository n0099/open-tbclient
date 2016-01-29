package com.baidu.tieba.personInfo;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddressListActivityConfig;
import com.baidu.tbadk.core.atomData.FriendFeedActivityConfig;
import com.baidu.tbadk.core.atomData.GroupActivityActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPrivilegeActivityConfig;
import com.baidu.tbadk.core.atomData.MyGiftListActivityConfig;
import com.baidu.tbadk.core.atomData.MyLiveActivityConfig;
import com.baidu.tbadk.core.atomData.PbHistoryActivityConfig;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.data.GodUserData;
import com.baidu.tieba.person.ProfileHttpResponseMessage;
import com.baidu.tieba.person.ProfileRequestMessage;
import com.baidu.tieba.person.ProfileSocketResponseMessage;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
import tbclient.PostInfoList;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes.dex */
public class bf extends com.baidu.adp.base.e<BaseFragmentActivity> {
    private ArrayList<com.baidu.adp.widget.ListView.u> Zg;
    private boolean bDM;
    private AntiData cJM;
    private CustomMessageListener cZC;
    private PersonTainInfo daC;
    private List<PersonInfoPostList> daF;
    private PersonUserGodInfo dcd;
    private MetaData dcp;
    private com.baidu.tieba.person.data.h djA;
    private com.baidu.tieba.person.data.g djB;
    private com.baidu.tieba.person.data.q djC;
    private com.baidu.tieba.person.a.ae djD;
    private BaseFragmentActivity djE;
    private boolean djF;
    private List<com.baidu.tieba.card.a.c> djG;
    private boolean djj;
    private boolean djk;
    private String djl;
    public boolean djm;
    private User djn;
    private bp djo;
    private com.baidu.tbadk.coreExtra.d.a djp;
    private long djq;
    private com.baidu.tieba.person.data.m djr;
    private com.baidu.tieba.person.data.f djs;
    private com.baidu.tieba.person.data.k djt;
    private com.baidu.tieba.person.data.c dju;
    private com.baidu.tieba.person.data.o djv;
    private com.baidu.tieba.person.data.l djw;
    private com.baidu.tieba.person.data.i djx;
    private com.baidu.tieba.person.data.b djy;
    private com.baidu.tieba.person.data.e djz;
    private String mId;
    private String mName;
    private String mNameShow;
    private UserData mUserData;
    private String stType;

    public MetaData getAuthor() {
        return this.dcp;
    }

    public PersonUserGodInfo avy() {
        return this.dcd;
    }

    public ArrayList<com.baidu.adp.widget.ListView.u> getDataList() {
        return this.Zg;
    }

    public List<com.baidu.tieba.card.a.c> avz() {
        return this.djG;
    }

    public void bq(long j) {
        this.djq = j;
    }

    public AntiData ajb() {
        return this.cJM;
    }

    public void e(AntiData antiData) {
        this.cJM = antiData;
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public void f(UserData userData) {
        if (userData != null) {
            setName(userData.getUserName());
            lf(userData.getName_show());
        }
        this.mUserData = userData;
    }

    public PersonTainInfo avA() {
        return this.daC;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public bf(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.daF = new ArrayList();
        this.djp = new com.baidu.tbadk.coreExtra.d.a(this.mLoadDataCallBack);
        this.Zg = new ArrayList<>();
        this.djF = false;
        this.djG = new ArrayList();
        this.cZC = new bg(this, CmdConfigCustom.CMD_CACHE_PERSONINFO);
        this.djE = baseFragmentActivity;
    }

    public boolean getIsSelf() {
        return this.bDM;
    }

    public void setIsSelf(boolean z) {
        this.bDM = z;
    }

    public void gd(boolean z) {
        this.djj = z;
    }

    public void ge(boolean z) {
        this.djk = z;
    }

    public String getId() {
        return this.mId;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public String getName() {
        return this.mName;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void lf(String str) {
        this.mNameShow = str;
    }

    public String getStType() {
        return this.stType;
    }

    public void setStType(String str) {
        this.stType = str;
    }

    public String avB() {
        return this.djl;
    }

    public void lg(String str) {
        this.djl = str;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public void avC() {
        if (this.mUserData != null && this.djp != null && this.mUserData.getUserId() != null) {
            if (this.mUserData.getHave_attention() != 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.au("c10609").aa("obj_id", this.mUserData.getUserId()).r("obj_param1", avR()));
            } else {
                TiebaStatic.log(new com.baidu.tbadk.core.util.au("c10610").aa("obj_id", this.mUserData.getUserId()).r("obj_param1", avR()));
            }
            this.djp.a(this.mUserData.getHave_attention() != 1, this.mUserData.getPortrait(), this.mUserData.getUserId(), avS());
        }
    }

    public void avD() {
        MessageManager.getInstance().unRegisterListener(this.cZC);
    }

    public void atY() {
        com.baidu.tbadk.task.a aVar = new com.baidu.tbadk.task.a(CmdConfigCustom.CMD_CACHE_PERSONINFO, new bh());
        aVar.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(aVar);
        this.cZC.setSelfListener(true);
        this.cZC.setTag(getUniqueId());
        registerListener(this.cZC);
    }

    public void avE() {
        sendMessage(new RequestPersonInfoMessage());
    }

    public void avF() {
        if (!com.baidu.adp.lib.util.i.iZ()) {
            this.mLoadDataCallBack.d(0);
        } else if (TbadkCoreApplication.isLogin() || (this.djE instanceof PersonInfoActivity)) {
            ProfileRequestMessage profileRequestMessage = new ProfileRequestMessage();
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                profileRequestMessage.set_uid(Long.valueOf(com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccount(), 0L)));
            }
            profileRequestMessage.set_need_post_count(1);
            profileRequestMessage.set_pn(1);
            profileRequestMessage.set_rn(20);
            profileRequestMessage.set_has_plist(1);
            profileRequestMessage.set_from_db(false);
            profileRequestMessage.set_error_hint(true);
            profileRequestMessage.setSelf(getIsSelf());
            if (!getIsSelf()) {
                profileRequestMessage.set_friend_uid(Long.valueOf(com.baidu.adp.lib.h.b.c(getId(), 0L)));
                profileRequestMessage.set_is_guest(1);
            }
            if (avB() != null) {
                try {
                    profileRequestMessage.set_st_type(avB());
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
            sendMessage(profileRequestMessage);
        }
    }

    public void a(ProfileSocketResponseMessage profileSocketResponseMessage) {
        if (profileSocketResponseMessage != null) {
            b(profileSocketResponseMessage);
            a(profileSocketResponseMessage.hasError(), profileSocketResponseMessage.getErrorString(), profileSocketResponseMessage.isFrom_db(), profileSocketResponseMessage.isError_hint());
        }
    }

    public void a(ProfileHttpResponseMessage profileHttpResponseMessage) {
        if (profileHttpResponseMessage != null) {
            b(profileHttpResponseMessage);
            a(profileHttpResponseMessage.hasError(), profileHttpResponseMessage.getErrorString(), profileHttpResponseMessage.isFrom_db(), profileHttpResponseMessage.isError_hint());
        }
    }

    public void a(boolean z, String str, boolean z2, boolean z3) {
        if (!z) {
            if (getIsSelf()) {
                com.baidu.tbadk.getUserInfo.b.DV().a(this.mUserData);
                TbadkCoreApplication.m411getInst();
                if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                    TbadkCoreApplication.m411getInst();
                    TbadkCoreApplication.getCurrentAccountInfo().setGodType(this.dcd.getGodType());
                }
            }
            UserData userData = this.mUserData;
            if (userData != null) {
                f(userData);
            }
            AntiData ajb = ajb();
            if (ajb != null) {
                e(ajb);
            }
            avQ();
            this.mLoadDataCallBack.d(1);
            return;
        }
        if (z3) {
            setErrorString(str);
        }
        this.mLoadDataCallBack.d(0);
    }

    public void b(ProfileHttpResponseMessage profileHttpResponseMessage) {
        if (profileHttpResponseMessage != null) {
            try {
                if (this.mUserData == null) {
                    this.mUserData = new UserData();
                }
                this.mUserData.parserProtobuf(profileHttpResponseMessage.GetUser());
                this.djn = profileHttpResponseMessage.GetUser();
                if (this.daC == null) {
                    this.daC = new PersonTainInfo();
                }
                this.daC.parseProto(profileHttpResponseMessage.GetTainfo());
                if (this.dcd == null) {
                    this.dcd = new PersonUserGodInfo();
                }
                this.dcd.parserProtobuf(profileHttpResponseMessage.getUserGodInfo());
                if (this.dcp == null) {
                    this.dcp = new MetaData();
                }
                this.dcp.parserProtobuf(this.djn);
                if (this.cJM == null) {
                    this.cJM = new AntiData();
                }
                this.cJM.parserProtobuf(profileHttpResponseMessage.GetAntiStat());
                this.cJM.setUser_id(this.mUserData.getUserId());
                this.cJM.setUser_name(this.mUserData.getUserName());
                if (profileHttpResponseMessage.getUcCard() != null) {
                    this.djo = new bp();
                    this.djo.a(profileHttpResponseMessage.getUcCard());
                }
                this.daF.clear();
                List<PostInfoList> GetPostList = profileHttpResponseMessage.GetPostList();
                if (GetPostList != null) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < GetPostList.size()) {
                            PersonInfoPostList personInfoPostList = new PersonInfoPostList();
                            personInfoPostList.parseProto(GetPostList.get(i2));
                            this.daF.add(personInfoPostList);
                            i = i2 + 1;
                        } else {
                            return;
                        }
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void b(ProfileSocketResponseMessage profileSocketResponseMessage) {
        if (profileSocketResponseMessage != null) {
            try {
                if (this.mUserData == null) {
                    this.mUserData = new UserData();
                }
                this.mUserData.parserProtobuf(profileSocketResponseMessage.GetUser());
                this.djn = profileSocketResponseMessage.GetUser();
                if (this.daC == null) {
                    this.daC = new PersonTainInfo();
                }
                this.daC.parseProto(profileSocketResponseMessage.GetTainfo());
                if (this.dcd == null) {
                    this.dcd = new PersonUserGodInfo();
                }
                this.dcd.parserProtobuf(profileSocketResponseMessage.getUserGodInfo());
                if (this.dcp == null) {
                    this.dcp = new MetaData();
                }
                this.dcp.parserProtobuf(this.djn);
                if (this.cJM == null) {
                    this.cJM = new AntiData();
                }
                this.cJM.parserProtobuf(profileSocketResponseMessage.GetAntiStat());
                this.cJM.setUser_id(this.mUserData.getUserId());
                this.cJM.setUser_name(this.mUserData.getUserName());
                if (profileSocketResponseMessage.getUcCard() != null) {
                    this.djo = new bp();
                    this.djo.a(profileSocketResponseMessage.getUcCard());
                }
                this.daF.clear();
                List<PostInfoList> GetPostList = profileSocketResponseMessage.GetPostList();
                if (GetPostList != null) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < GetPostList.size()) {
                            PersonInfoPostList personInfoPostList = new PersonInfoPostList();
                            personInfoPostList.parseProto(GetPostList.get(i2));
                            this.daF.add(personInfoPostList);
                            i = i2 + 1;
                        } else {
                            return;
                        }
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private boolean avG() {
        return TbadkCoreApplication.m411getInst().appResponseToIntentClass(AddressListActivityConfig.class);
    }

    private boolean avH() {
        return TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.START_EDITMARK);
    }

    private boolean avI() {
        return TbadkCoreApplication.m411getInst().appResponseToIntentClass(PbHistoryActivityConfig.class);
    }

    private boolean avJ() {
        return TbadkCoreApplication.m411getInst().appResponseToIntentClass(MyLiveActivityConfig.class);
    }

    private boolean auc() {
        return TbadkCoreApplication.m411getInst().appResponseToIntentClass(MemberPrivilegeActivityConfig.class);
    }

    private boolean aub() {
        return TbadkCoreApplication.m411getInst().appResponseToIntentClass(MyGiftListActivityConfig.class);
    }

    private boolean avK() {
        return TbadkCoreApplication.m411getInst().appResponseToIntentClass(FriendFeedActivityConfig.class);
    }

    private boolean avL() {
        return TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_FEED);
    }

    private boolean avM() {
        return TbadkCoreApplication.m411getInst().appResponseToIntentClass(GroupActivityActivityConfig.class) && TbadkCoreApplication.m411getInst().appResponseToIntentClass(PersonGroupActivityConfig.class);
    }

    public com.baidu.tieba.person.data.c avN() {
        com.baidu.tieba.person.data.c cVar = new com.baidu.tieba.person.data.c();
        if (avI()) {
            cVar.dbF.add(new com.baidu.tieba.person.data.d(2));
        }
        if (avH()) {
            cVar.dbF.add(new com.baidu.tieba.person.data.d(1));
        }
        if (!avS()) {
            cVar.dbF.add(new com.baidu.tieba.person.data.d(4));
            cVar.dbF.add(new com.baidu.tieba.person.data.d(3));
        } else if (this.bDM && avK()) {
            cVar.dbF.add(new com.baidu.tieba.person.data.d(5));
        }
        if (avG()) {
            cVar.dbF.add(new com.baidu.tieba.person.data.d(0));
        }
        return cVar;
    }

    private com.baidu.tieba.person.a.ae avO() {
        if (this.mUserData == null) {
            return null;
        }
        com.baidu.tieba.person.a.ae aeVar = new com.baidu.tieba.person.a.ae();
        aeVar.setSelf(this.bDM);
        aeVar.setPhotoAlbum(this.mUserData.getPhotoAlbum());
        if (this.bDM && this.mUserData.getPhotoAlbum() != null && !bs(this.mUserData.getPhotoAlbum()) && this.mUserData.getPhotoAlbum().size() < 9) {
            com.baidu.tbadk.data.g gVar = new com.baidu.tbadk.data.g();
            gVar.bd(false);
            gVar.be(true);
            aeVar.getPhotoAlbum().add(gVar);
            return aeVar;
        }
        return aeVar;
    }

    private boolean bs(List<com.baidu.tbadk.data.g> list) {
        int o = com.baidu.tbadk.core.util.x.o(list);
        if (o == 0) {
            return false;
        }
        for (int i = o - 1; i >= 0; i--) {
            com.baidu.tbadk.data.g gVar = (com.baidu.tbadk.data.g) com.baidu.tbadk.core.util.x.b(list, i);
            if (gVar != null && gVar.isAdded()) {
                return true;
            }
        }
        return false;
    }

    public com.baidu.tieba.person.a.ae avP() {
        return this.djD;
    }

    public void avQ() {
        this.Zg.clear();
        if (this.mUserData != null && getIsSelf() && this.mUserData.getUserVipInfo() != null) {
            TbadkCoreApplication.setCurrentMemberType(this.mUserData.getUserVipInfo().getVipStatus());
        }
        com.baidu.tieba.person.data.n nVar = new com.baidu.tieba.person.data.n();
        nVar.setIsSelf(getIsSelf());
        if (this.daC != null) {
            nVar.b(this.daC);
        }
        nVar.f(this.mUserData);
        this.Zg.add(nVar);
        if (this.bDM || avS()) {
            this.dju = avN();
            this.Zg.add(this.dju);
        }
        if (auc()) {
            this.djr = new com.baidu.tieba.person.data.m();
            if (this.bDM || this.mUserData == null || this.mUserData.getIsMem() == 2) {
                if (this.mUserData.getMembershipUserInfo() != null) {
                    this.djr.setVipContent(this.mUserData.getMembershipUserInfo().getVipContent());
                    this.djr.setVipIcon(this.mUserData.getMembershipUserInfo().getVipIcon());
                    this.djr.setVipLink(this.mUserData.getMembershipUserInfo().getVipLink());
                }
                this.djr.setIsSelf(this.bDM);
                this.djr.f(this.mUserData);
                this.Zg.add(this.djr);
            }
        }
        if (this.bDM && this.djo != null) {
            this.djC = new com.baidu.tieba.person.data.q();
            this.djC.setName(this.djo.getName());
            this.djC.lc(this.djo.auu());
            this.djC.setIcon(this.djo.getIcon());
            this.djC.lb(this.djo.aut());
            this.djC.bp(this.djo.auv());
            this.Zg.add(this.djC);
        }
        if (this.bDM && !avS()) {
            this.djA = new com.baidu.tieba.person.data.h();
            this.djA.dbB = false;
            this.Zg.add(this.djA);
        }
        if (this.bDM && avL() && com.baidu.adp.lib.c.e.gE().ai("mygroup_states") == 1) {
            this.djB = new com.baidu.tieba.person.data.g();
            this.djB.dbA = false;
            if (this.djA == null) {
                this.djB.dbA = true;
                this.djm = true;
            }
            this.djB.dbB = false;
            this.Zg.add(this.djB);
        }
        if (aub()) {
            this.djx = new com.baidu.tieba.person.data.i();
            this.djx.f(this.mUserData);
            this.djx.setIsSelf(getIsSelf());
            if (avT()) {
                this.djx.fV(true);
            } else {
                this.djx.fV(false);
            }
            this.Zg.add(this.djx);
        }
        if (!avT()) {
            this.djD = avO();
            this.Zg.add(this.djD);
        }
        if (!this.bDM && this.mUserData != null && !avT()) {
            this.djz = new com.baidu.tieba.person.data.e();
            this.djz.dbJ = this.mUserData.getFansNum();
            this.djz.sex = this.mUserData.getSex();
            this.djz.isSelf = this.bDM;
            this.djz.userId = this.mUserData.getUserId();
            this.Zg.add(this.djz);
            this.djy = new com.baidu.tieba.person.data.b();
            this.djy.dbD = this.mUserData.getConcernNum();
            this.djy.isSelf = this.bDM;
            this.djy.userId = this.mUserData.getUserId();
            this.djy.sex = this.mUserData.getSex();
            this.Zg.add(this.djy);
        }
        if (!avT()) {
            this.djv = new com.baidu.tieba.person.data.o();
            this.djv.setIsSelf(getIsSelf());
            this.djv.f(this.mUserData);
            this.djv.a(avA());
            this.djv.d(this.daF);
            if (com.baidu.tbadk.core.util.x.o(this.daF) <= 0) {
                this.djv.dbB = false;
            }
            this.Zg.add(this.djv);
        }
        if (avU()) {
            List<ThreadInfo> godThreadList = this.dcd.getGodThreadList();
            com.baidu.tieba.person.data.j jVar = new com.baidu.tieba.person.data.j();
            jVar.title = TbadkCoreApplication.m411getInst().getString(t.j.group_title_god);
            jVar.dbS = Math.max(com.baidu.adp.lib.h.b.c(this.dcd.getTotalThread(), 0L), godThreadList.size());
            this.Zg.add(jVar);
            if (com.baidu.tbadk.core.util.x.o(godThreadList) > 0) {
                List<ThreadInfo> subList = godThreadList.subList(0, Math.min(godThreadList.size(), 2));
                this.djG.clear();
                bt(subList);
            }
        }
        if (getIsSelf() && avJ()) {
            this.djw = new com.baidu.tieba.person.data.l();
            this.Zg.add(this.djw);
            this.djw.setUser(this.djn);
        }
        if (!avT()) {
            this.djs = new com.baidu.tieba.person.data.f();
            this.djs.setSelf(getIsSelf());
            if (this.mUserData != null) {
                this.djs.setSex(this.mUserData.getSex());
                this.djs.setCount(this.mUserData.getLike_bars());
                this.djs.setIsFriend(avA().getIsFriend());
                this.djs.setUserId(this.mUserData.getUserId());
                this.djs.lw(this.mUserData.getPersonPrivate().Cc());
                this.djs.bo(this.mUserData.getLikeForum());
                if (com.baidu.tbadk.core.util.x.o(this.mUserData.getLikeForum()) <= 0) {
                    this.djs.dbB = false;
                }
            }
            this.Zg.add(this.djs);
        }
        if (avM() && !avT()) {
            this.djt = new com.baidu.tieba.person.data.k();
            this.djt.setIsSelf(getIsSelf());
            this.djt.f(this.mUserData);
            this.djt.a(avA());
            if (com.baidu.tbadk.core.util.x.o(this.mUserData.getGroup()) <= 0) {
                this.djt.dbB = false;
            }
            this.Zg.add(this.djt);
        }
        if (avT()) {
            com.baidu.tieba.person.data.j jVar2 = new com.baidu.tieba.person.data.j();
            jVar2.dbT = true;
            jVar2.dbR = avW();
            this.Zg.add(jVar2);
            this.djG.clear();
            bt(this.dcd.getGodThreadList());
        }
        this.djF = true;
    }

    public int avR() {
        if (getUserData() == null || getUserData().getGodInfo() == null) {
            return 0;
        }
        int intValue = getUserData().getGodInfo().type.intValue();
        return (intValue == 2 || intValue == 1) ? 1 : 0;
    }

    public boolean avS() {
        return this.dcd != null && this.dcd.getGodType() == 2;
    }

    public boolean avT() {
        return avS() && !this.bDM;
    }

    public boolean avU() {
        return avS() && this.bDM;
    }

    public boolean avV() {
        if (this.dcd == null || this.dcd.getGodType() != 2) {
            return false;
        }
        return com.baidu.adp.lib.h.b.c(this.dcd.getTotalThread(), 0L) > ((long) this.dcd.getGodThreadList().size());
    }

    public int avW() {
        if (this.dcd != null) {
            return this.dcd.getCurPage();
        }
        return 0;
    }

    public void b(com.baidu.tbadk.core.data.q qVar) {
        if (qVar != null && this.djF && this.djw != null) {
            this.djw.a(qVar);
            if (this.mLoadDataCallBack != null) {
                this.mLoadDataCallBack.d(1);
            }
        }
    }

    public void bt(List<ThreadInfo> list) {
        if (this.Zg != null && com.baidu.tbadk.core.util.x.o(list) > 0) {
            List<com.baidu.tieba.card.a.c> a = com.baidu.tieba.person.god.b.a(list, this.dcp, false);
            this.djG.addAll(a);
            this.Zg.addAll(a);
        }
    }

    public void avX() {
        if (this.dcp != null && this.mUserData != null && this.dcd != null) {
            this.dcp.setFansNum(this.mUserData.getFansNum());
            GodUserData godUserData = new GodUserData();
            godUserData.setType(this.dcd.getGodType());
            godUserData.setFollowed(this.mUserData.getHave_attention());
            godUserData.setId(Long.valueOf(com.baidu.adp.lib.h.b.c(this.mUserData.getUserId(), 0L)));
            this.dcp.setGodUserData(godUserData);
        }
    }
}

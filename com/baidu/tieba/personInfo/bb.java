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
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.person.ProfileHttpResponseMessage;
import com.baidu.tieba.person.ProfileRequestMessage;
import com.baidu.tieba.person.ProfileSocketResponseMessage;
import java.util.ArrayList;
import java.util.List;
import tbclient.PostInfoList;
/* loaded from: classes.dex */
public class bb extends com.baidu.adp.base.e<BaseFragmentActivity> {
    private ArrayList<com.baidu.adp.widget.ListView.u> YJ;
    private boolean bAA;
    private AntiData cDg;
    private PersonTainInfo cQV;
    private List<PersonInfoPostList> cQY;
    private CustomMessageListener cQf;
    private PersonUserGodInfo cSk;
    private final int cUJ;
    private boolean cXB;
    private boolean cXC;
    private String cXD;
    public boolean cXE;
    private com.baidu.tbadk.coreExtra.d.a cXF;
    private long cXG;
    private com.baidu.tieba.person.data.l cXH;
    private com.baidu.tieba.person.data.f cXI;
    private com.baidu.tieba.person.data.j cXJ;
    private com.baidu.tieba.person.data.c cXK;
    private com.baidu.tieba.person.data.n cXL;
    private com.baidu.tieba.person.data.k cXM;
    private com.baidu.tieba.person.data.i cXN;
    private com.baidu.tieba.person.data.o cXO;
    private com.baidu.tieba.person.data.b cXP;
    private com.baidu.tieba.person.data.e cXQ;
    private com.baidu.tieba.person.data.h cXR;
    private com.baidu.tieba.person.data.g cXS;
    private com.baidu.tieba.person.a.ae cXT;
    private BaseFragmentActivity cXU;
    private String mId;
    private String mName;
    private String mNameShow;
    private UserData mUserData;
    private String stType;

    public ArrayList<com.baidu.adp.widget.ListView.u> getDataList() {
        return this.YJ;
    }

    public void bn(long j) {
        this.cXG = j;
    }

    public AntiData ala() {
        return this.cDg;
    }

    public void b(AntiData antiData) {
        this.cDg = antiData;
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public void f(UserData userData) {
        if (userData != null) {
            setName(userData.getUserName());
            kV(userData.getName_show());
        }
        this.mUserData = userData;
    }

    public PersonTainInfo aqp() {
        return this.cQV;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public bb(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.cUJ = 9;
        this.cQY = new ArrayList();
        this.cXF = new com.baidu.tbadk.coreExtra.d.a(this.mLoadDataCallBack);
        this.YJ = new ArrayList<>();
        this.cQf = new bc(this, CmdConfigCustom.CMD_CACHE_PERSONINFO);
        this.cXU = baseFragmentActivity;
    }

    public boolean getIsSelf() {
        return this.bAA;
    }

    public void setIsSelf(boolean z) {
        this.bAA = z;
    }

    public void fM(boolean z) {
        this.cXB = z;
    }

    public void fN(boolean z) {
        this.cXC = z;
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

    public void kV(String str) {
        this.mNameShow = str;
    }

    public String getStType() {
        return this.stType;
    }

    public void setStType(String str) {
        this.stType = str;
    }

    public String aqq() {
        return this.cXD;
    }

    public void kW(String str) {
        this.cXD = str;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public void aqr() {
        if (this.mUserData != null && this.cXF != null && this.mUserData.getUserId() != null) {
            if (this.mUserData.getHave_attention() != 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10609").aa("obj_id", this.mUserData.getUserId()).r("obj_param1", aqH()));
            } else {
                TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10610").aa("obj_id", this.mUserData.getUserId()).r("obj_param1", aqH()));
            }
            this.cXF.a(this.mUserData.getHave_attention() != 1, this.mUserData.getPortrait(), this.mUserData.getUserId());
        }
    }

    public void aqs() {
        MessageManager.getInstance().unRegisterListener(this.cQf);
    }

    public void apf() {
        com.baidu.tbadk.task.a aVar = new com.baidu.tbadk.task.a(CmdConfigCustom.CMD_CACHE_PERSONINFO, new bd());
        aVar.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(aVar);
        this.cQf.setSelfListener(true);
        this.cQf.setTag(getUniqueId());
        registerListener(this.cQf);
    }

    public void aqt() {
        sendMessage(new RequestPersonInfoMessage());
    }

    public void aqu() {
        if (!com.baidu.adp.lib.util.i.iQ()) {
            this.mLoadDataCallBack.d(0);
        } else if (TbadkCoreApplication.isLogin() || (this.cXU instanceof PersonInfoActivity)) {
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
            if (aqq() != null) {
                try {
                    profileRequestMessage.set_st_type(aqq());
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
                com.baidu.tbadk.getUserInfo.b.CE().a(this.mUserData);
                TbadkCoreApplication.m411getInst();
                if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                    TbadkCoreApplication.m411getInst();
                    TbadkCoreApplication.getCurrentAccountInfo().setGodType(this.cSk.getGodType());
                }
            }
            UserData userData = this.mUserData;
            if (userData != null) {
                f(userData);
            }
            AntiData ala = ala();
            if (ala != null) {
                b(ala);
            }
            aqG();
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
                if (this.cQV == null) {
                    this.cQV = new PersonTainInfo();
                }
                this.cQV.parseProto(profileHttpResponseMessage.GetTainfo());
                if (this.cSk == null) {
                    this.cSk = new PersonUserGodInfo();
                }
                this.cSk.parserProtobuf(profileHttpResponseMessage.getUserGodInfo());
                if (this.cDg == null) {
                    this.cDg = new AntiData();
                }
                this.cDg.parserProtobuf(profileHttpResponseMessage.GetAntiStat());
                this.cDg.setUser_id(this.mUserData.getUserId());
                this.cDg.setUser_name(this.mUserData.getUserName());
                this.cQY.clear();
                List<PostInfoList> GetPostList = profileHttpResponseMessage.GetPostList();
                if (GetPostList != null) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < GetPostList.size()) {
                            PersonInfoPostList personInfoPostList = new PersonInfoPostList();
                            personInfoPostList.parseProto(GetPostList.get(i2));
                            this.cQY.add(personInfoPostList);
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
                if (this.cQV == null) {
                    this.cQV = new PersonTainInfo();
                }
                this.cQV.parseProto(profileSocketResponseMessage.GetTainfo());
                if (this.cSk == null) {
                    this.cSk = new PersonUserGodInfo();
                }
                this.cSk.parserProtobuf(profileSocketResponseMessage.getUserGodInfo());
                if (this.cDg == null) {
                    this.cDg = new AntiData();
                }
                this.cDg.parserProtobuf(profileSocketResponseMessage.GetAntiStat());
                this.cDg.setUser_id(this.mUserData.getUserId());
                this.cDg.setUser_name(this.mUserData.getUserName());
                this.cQY.clear();
                List<PostInfoList> GetPostList = profileSocketResponseMessage.GetPostList();
                if (GetPostList != null) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < GetPostList.size()) {
                            PersonInfoPostList personInfoPostList = new PersonInfoPostList();
                            personInfoPostList.parseProto(GetPostList.get(i2));
                            this.cQY.add(personInfoPostList);
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

    private boolean aqv() {
        return this.cSk != null && (this.cSk.getGodType() == 1 || this.cSk.getGodType() == 2);
    }

    private boolean aqw() {
        return TbadkCoreApplication.m411getInst().appResponseToIntentClass(AddressListActivityConfig.class);
    }

    private boolean aqx() {
        return TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.START_EDITMARK);
    }

    private boolean aqy() {
        return TbadkCoreApplication.m411getInst().appResponseToIntentClass(PbHistoryActivityConfig.class);
    }

    private boolean aqz() {
        return TbadkCoreApplication.m411getInst().appResponseToIntentClass(MyLiveActivityConfig.class);
    }

    private boolean apk() {
        return TbadkCoreApplication.m411getInst().appResponseToIntentClass(MemberPrivilegeActivityConfig.class);
    }

    private boolean apj() {
        return TbadkCoreApplication.m411getInst().appResponseToIntentClass(MyGiftListActivityConfig.class);
    }

    private boolean aqA() {
        return TbadkCoreApplication.m411getInst().appResponseToIntentClass(FriendFeedActivityConfig.class);
    }

    private boolean aqB() {
        return TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_FEED);
    }

    private boolean aqC() {
        return TbadkCoreApplication.m411getInst().appResponseToIntentClass(GroupActivityActivityConfig.class) && TbadkCoreApplication.m411getInst().appResponseToIntentClass(PersonGroupActivityConfig.class);
    }

    public com.baidu.tieba.person.data.c aqD() {
        com.baidu.tieba.person.data.c cVar = new com.baidu.tieba.person.data.c();
        if (aqy()) {
            cVar.cRR.add(new com.baidu.tieba.person.data.d(2));
        }
        if (aqx()) {
            cVar.cRR.add(new com.baidu.tieba.person.data.d(1));
        }
        cVar.cRR.add(new com.baidu.tieba.person.data.d(4));
        cVar.cRR.add(new com.baidu.tieba.person.data.d(3));
        if (aqw()) {
            cVar.cRR.add(new com.baidu.tieba.person.data.d(0));
        }
        return cVar;
    }

    private com.baidu.tieba.person.a.ae aqE() {
        if (this.mUserData == null) {
            return null;
        }
        com.baidu.tieba.person.a.ae aeVar = new com.baidu.tieba.person.a.ae();
        aeVar.setSelf(this.bAA);
        aeVar.setPhotoAlbum(this.mUserData.getPhotoAlbum());
        if (this.bAA && this.mUserData.getPhotoAlbum() != null && !bo(this.mUserData.getPhotoAlbum()) && this.mUserData.getPhotoAlbum().size() < 9) {
            com.baidu.tbadk.data.g gVar = new com.baidu.tbadk.data.g();
            gVar.bb(false);
            gVar.bc(true);
            aeVar.getPhotoAlbum().add(gVar);
            return aeVar;
        }
        return aeVar;
    }

    private boolean bo(List<com.baidu.tbadk.data.g> list) {
        int l = com.baidu.tbadk.core.util.y.l(list);
        if (l == 0) {
            return false;
        }
        for (int i = l - 1; i >= 0; i--) {
            com.baidu.tbadk.data.g gVar = (com.baidu.tbadk.data.g) com.baidu.tbadk.core.util.y.b(list, i);
            if (gVar != null && gVar.isAdded()) {
                return true;
            }
        }
        return false;
    }

    public com.baidu.tieba.person.a.ae aqF() {
        return this.cXT;
    }

    public void aqG() {
        this.YJ.clear();
        if (this.mUserData != null && getIsSelf() && this.mUserData.getUserVipInfo() != null) {
            TbadkCoreApplication.setCurrentMemberType(this.mUserData.getUserVipInfo().getVipStatus());
        }
        com.baidu.tieba.person.data.m mVar = new com.baidu.tieba.person.data.m();
        mVar.setIsSelf(getIsSelf());
        if (this.cQV != null) {
            mVar.b(this.cQV);
        }
        mVar.f(this.mUserData);
        this.YJ.add(mVar);
        if (this.bAA) {
            this.cXK = aqD();
            this.YJ.add(this.cXK);
        }
        if (apk()) {
            this.cXH = new com.baidu.tieba.person.data.l();
            if (this.bAA || this.mUserData == null || this.mUserData.getIsMem() == 2) {
                if (this.mUserData.getMembershipUserInfo() != null) {
                    this.cXH.setVipContent(this.mUserData.getMembershipUserInfo().getVipContent());
                    this.cXH.setVipIcon(this.mUserData.getMembershipUserInfo().getVipIcon());
                    this.cXH.setVipLink(this.mUserData.getMembershipUserInfo().getVipLink());
                }
                this.cXH.setIsSelf(this.bAA);
                this.cXH.f(this.mUserData);
                this.YJ.add(this.cXH);
            }
        }
        if (this.bAA && aqA()) {
            this.cXR = new com.baidu.tieba.person.data.h();
            this.cXR.cRN = false;
            this.YJ.add(this.cXR);
        }
        if (this.bAA && aqB() && com.baidu.adp.lib.c.e.gw().aj("mygroup_states") == 1) {
            this.cXS = new com.baidu.tieba.person.data.g();
            this.cXS.cRM = false;
            if (this.cXR == null) {
                this.cXS.cRM = true;
                this.cXE = true;
            }
            this.cXS.cRN = false;
            this.YJ.add(this.cXS);
        }
        if (aqv()) {
            this.cXO = new com.baidu.tieba.person.data.o();
            this.cXO.a(this.cSk);
            this.YJ.add(this.cXO);
        }
        if (apj()) {
            this.cXN = new com.baidu.tieba.person.data.i();
            this.cXN.f(this.mUserData);
            this.cXN.setIsSelf(getIsSelf());
            this.YJ.add(this.cXN);
        }
        this.cXT = aqE();
        this.YJ.add(this.cXT);
        if (!this.bAA && this.mUserData != null) {
            this.cXQ = new com.baidu.tieba.person.data.e();
            this.cXQ.cRV = this.mUserData.getFansNum();
            this.cXQ.sex = this.mUserData.getSex();
            this.cXQ.isSelf = this.bAA;
            this.cXQ.userId = this.mUserData.getUserId();
            this.YJ.add(this.cXQ);
            this.cXP = new com.baidu.tieba.person.data.b();
            this.cXP.cRP = this.mUserData.getConcern_num();
            this.cXP.isSelf = this.bAA;
            this.cXP.userId = this.mUserData.getUserId();
            this.cXP.sex = this.mUserData.getSex();
            this.YJ.add(this.cXP);
        }
        this.cXL = new com.baidu.tieba.person.data.n();
        this.cXL.setIsSelf(getIsSelf());
        this.cXL.f(this.mUserData);
        this.cXL.a(aqp());
        this.cXL.d(this.cQY);
        if (com.baidu.tbadk.core.util.y.l(this.cQY) <= 0) {
            this.cXL.cRN = false;
        }
        this.YJ.add(this.cXL);
        this.cXI = new com.baidu.tieba.person.data.f();
        this.cXI.setSelf(getIsSelf());
        if (this.mUserData != null) {
            this.cXI.setSex(this.mUserData.getSex());
            this.cXI.setCount(this.mUserData.getLike_bars());
            this.cXI.setIsFriend(this.mUserData.getIsFriend());
            this.cXI.setUserId(this.mUserData.getUserId());
            this.cXI.kP(this.mUserData.getPersonPrivate().AM());
            this.cXI.bm(this.mUserData.getLikeForum());
            if (com.baidu.tbadk.core.util.y.l(this.mUserData.getLikeForum()) <= 0) {
                this.cXI.cRN = false;
            }
        }
        this.YJ.add(this.cXI);
        if (aqC()) {
            this.cXJ = new com.baidu.tieba.person.data.j();
            this.cXJ.setIsSelf(getIsSelf());
            this.cXJ.f(this.mUserData);
            this.cXJ.a(aqp());
            if (com.baidu.tbadk.core.util.y.l(this.mUserData.getGroup()) <= 0) {
                this.cXJ.cRN = false;
            }
            this.YJ.add(this.cXJ);
        }
        if (getIsSelf() && aqz()) {
            this.cXM = new com.baidu.tieba.person.data.k();
            this.YJ.add(this.cXM);
        }
    }

    public int aqH() {
        if (getUserData() == null || getUserData().getGodInfo() == null) {
            return 0;
        }
        int intValue = getUserData().getGodInfo().type.intValue();
        return (intValue == 2 || intValue == 1) ? 1 : 0;
    }
}

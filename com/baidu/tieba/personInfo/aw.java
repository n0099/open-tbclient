package com.baidu.tieba.personInfo;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddressListActivityConfig;
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
public class aw extends com.baidu.adp.base.e<BaseFragmentActivity> {
    private ArrayList<com.baidu.adp.widget.ListView.u> Yg;
    private boolean bwJ;
    private CustomMessageListener cLP;
    private PersonTainInfo cMB;
    private List<PersonInfoPostList> cME;
    private PersonUserGodInfo cNE;
    private final int cQh;
    private boolean cST;
    private boolean cSU;
    private String cSV;
    private com.baidu.tbadk.coreExtra.d.a cSW;
    private long cSX;
    private com.baidu.tieba.person.data.j cSY;
    private com.baidu.tieba.person.data.f cSZ;
    private com.baidu.tieba.person.data.h cTa;
    private com.baidu.tieba.person.data.c cTb;
    private com.baidu.tieba.person.data.l cTc;
    private com.baidu.tieba.person.data.i cTd;
    private com.baidu.tieba.person.data.g cTe;
    private com.baidu.tieba.person.data.m cTf;
    private com.baidu.tieba.person.data.b cTg;
    private com.baidu.tieba.person.data.e cTh;
    private com.baidu.tieba.person.a.aa cTi;
    private AntiData czB;
    private String mId;
    private String mName;
    private String mNameShow;
    private UserData mUserData;
    private String stType;

    public ArrayList<com.baidu.adp.widget.ListView.u> getDataList() {
        return this.Yg;
    }

    public void bh(long j) {
        this.cSX = j;
    }

    public AntiData ajS() {
        return this.czB;
    }

    public void b(AntiData antiData) {
        this.czB = antiData;
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public void f(UserData userData) {
        if (userData != null) {
            setName(userData.getUserName());
            kY(userData.getName_show());
        }
        this.mUserData = userData;
    }

    public PersonTainInfo apc() {
        return this.cMB;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public aw(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.cQh = 9;
        this.cME = new ArrayList();
        this.cSW = new com.baidu.tbadk.coreExtra.d.a(this.mLoadDataCallBack);
        this.Yg = new ArrayList<>();
        this.cLP = new ax(this, CmdConfigCustom.CMD_CACHE_PERSONINFO);
    }

    public boolean getIsSelf() {
        return this.bwJ;
    }

    public void setIsSelf(boolean z) {
        this.bwJ = z;
    }

    public void fN(boolean z) {
        this.cST = z;
    }

    public void fO(boolean z) {
        this.cSU = z;
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

    public void kY(String str) {
        this.mNameShow = str;
    }

    public String getStType() {
        return this.stType;
    }

    public void setStType(String str) {
        this.stType = str;
    }

    public String apd() {
        return this.cSV;
    }

    public void kZ(String str) {
        this.cSV = str;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public void ape() {
        if (this.mUserData != null && this.cSW != null && this.mUserData.getUserId() != null) {
            if (this.mUserData.getHave_attention() != 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10609").ab("obj_id", this.mUserData.getUserId()).r("obj_param1", aps()));
            } else {
                TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10610").ab("obj_id", this.mUserData.getUserId()).r("obj_param1", aps()));
            }
            this.cSW.a(this.mUserData.getHave_attention() != 1, this.mUserData.getPortrait(), this.mUserData.getUserId());
        }
    }

    public void apf() {
        MessageManager.getInstance().unRegisterListener(this.cLP);
    }

    public void anU() {
        com.baidu.tbadk.task.a aVar = new com.baidu.tbadk.task.a(CmdConfigCustom.CMD_CACHE_PERSONINFO, new ay());
        aVar.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(aVar);
        this.cLP.setSelfListener(true);
        this.cLP.setTag(getUniqueId());
        registerListener(this.cLP);
    }

    public void apg() {
        sendMessage(new RequestPersonInfoMessage());
    }

    public void aph() {
        if (!com.baidu.adp.lib.util.i.iP()) {
            a(true, null, false, false);
        }
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
        if (apd() != null) {
            try {
                profileRequestMessage.set_st_type(apd());
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
        sendMessage(profileRequestMessage);
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
                com.baidu.tbadk.getUserInfo.b.CP().a(this.mUserData);
            }
            UserData userData = this.mUserData;
            if (userData != null) {
                f(userData);
            }
            AntiData ajS = ajS();
            if (ajS != null) {
                b(ajS);
            }
            apr();
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
                if (this.cMB == null) {
                    this.cMB = new PersonTainInfo();
                }
                this.cMB.parseProto(profileHttpResponseMessage.GetTainfo());
                if (this.cNE == null) {
                    this.cNE = new PersonUserGodInfo();
                }
                this.cNE.parserProtobuf(profileHttpResponseMessage.getUserGodInfo());
                if (this.czB == null) {
                    this.czB = new AntiData();
                }
                this.czB.parserProtobuf(profileHttpResponseMessage.GetAntiStat());
                this.czB.setUser_id(this.mUserData.getUserId());
                this.czB.setUser_name(this.mUserData.getUserName());
                this.cME.clear();
                List<PostInfoList> GetPostList = profileHttpResponseMessage.GetPostList();
                if (GetPostList != null) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < GetPostList.size()) {
                            PersonInfoPostList personInfoPostList = new PersonInfoPostList();
                            personInfoPostList.parseProto(GetPostList.get(i2));
                            this.cME.add(personInfoPostList);
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
                if (this.cMB == null) {
                    this.cMB = new PersonTainInfo();
                }
                this.cMB.parseProto(profileSocketResponseMessage.GetTainfo());
                if (this.cNE == null) {
                    this.cNE = new PersonUserGodInfo();
                }
                this.cNE.parserProtobuf(profileSocketResponseMessage.getUserGodInfo());
                if (this.czB == null) {
                    this.czB = new AntiData();
                }
                this.czB.parserProtobuf(profileSocketResponseMessage.GetAntiStat());
                this.czB.setUser_id(this.mUserData.getUserId());
                this.czB.setUser_name(this.mUserData.getUserName());
                this.cME.clear();
                List<PostInfoList> GetPostList = profileSocketResponseMessage.GetPostList();
                if (GetPostList != null) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < GetPostList.size()) {
                            PersonInfoPostList personInfoPostList = new PersonInfoPostList();
                            personInfoPostList.parseProto(GetPostList.get(i2));
                            this.cME.add(personInfoPostList);
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

    private boolean api() {
        return this.cNE != null && (this.cNE.getGodType() == 1 || this.cNE.getGodType() == 2);
    }

    private boolean apj() {
        return TbadkCoreApplication.m411getInst().appResponseToIntentClass(AddressListActivityConfig.class);
    }

    private boolean apk() {
        return TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.START_EDITMARK);
    }

    private boolean apl() {
        return TbadkCoreApplication.m411getInst().appResponseToIntentClass(PbHistoryActivityConfig.class);
    }

    private boolean apm() {
        return TbadkCoreApplication.m411getInst().appResponseToIntentClass(MyLiveActivityConfig.class);
    }

    private boolean aoa() {
        return TbadkCoreApplication.m411getInst().appResponseToIntentClass(MemberPrivilegeActivityConfig.class);
    }

    private boolean anY() {
        return TbadkCoreApplication.m411getInst().appResponseToIntentClass(MyGiftListActivityConfig.class);
    }

    private boolean apn() {
        return TbadkCoreApplication.m411getInst().appResponseToIntentClass(GroupActivityActivityConfig.class) && TbadkCoreApplication.m411getInst().appResponseToIntentClass(PersonGroupActivityConfig.class);
    }

    public com.baidu.tieba.person.data.c apo() {
        com.baidu.tieba.person.data.c cVar = new com.baidu.tieba.person.data.c();
        if (apl()) {
            cVar.cNn.add(new com.baidu.tieba.person.data.d(2));
        }
        if (apk()) {
            cVar.cNn.add(new com.baidu.tieba.person.data.d(1));
        }
        cVar.cNn.add(new com.baidu.tieba.person.data.d(4));
        cVar.cNn.add(new com.baidu.tieba.person.data.d(3));
        if (apj()) {
            cVar.cNn.add(new com.baidu.tieba.person.data.d(0));
        }
        return cVar;
    }

    private com.baidu.tieba.person.a.aa app() {
        if (this.mUserData == null) {
            return null;
        }
        com.baidu.tieba.person.a.aa aaVar = new com.baidu.tieba.person.a.aa();
        aaVar.setSelf(this.bwJ);
        aaVar.setPhotoAlbum(this.mUserData.getPhotoAlbum());
        if (this.bwJ && this.mUserData.getPhotoAlbum() != null && this.mUserData.getPhotoAlbum().size() < 9) {
            com.baidu.tbadk.data.g gVar = new com.baidu.tbadk.data.g();
            gVar.bc(false);
            gVar.bd(true);
            aaVar.getPhotoAlbum().add(gVar);
            return aaVar;
        }
        return aaVar;
    }

    public com.baidu.tieba.person.a.aa apq() {
        return this.cTi;
    }

    public void apr() {
        this.Yg.clear();
        if (this.mUserData != null && getIsSelf()) {
            TbadkCoreApplication.setCurrentMemberType(this.mUserData.getUserVipInfo().getVipStatus());
        }
        com.baidu.tieba.person.data.k kVar = new com.baidu.tieba.person.data.k();
        kVar.setIsSelf(getIsSelf());
        if (this.cMB != null) {
            kVar.b(this.cMB);
        }
        kVar.f(this.mUserData);
        this.Yg.add(kVar);
        if (this.bwJ) {
            this.cTb = apo();
            this.Yg.add(this.cTb);
        }
        if (aoa()) {
            this.cSY = new com.baidu.tieba.person.data.j();
            if (this.bwJ || this.mUserData == null || this.mUserData.getIsMem() == 2) {
                if (this.mUserData.getMembershipUserInfo() != null) {
                    this.cSY.setVipContent(this.mUserData.getMembershipUserInfo().getVipContent());
                    this.cSY.setVipIcon(this.mUserData.getMembershipUserInfo().getVipIcon());
                    this.cSY.setVipLink(this.mUserData.getMembershipUserInfo().getVipLink());
                }
                this.cSY.setIsSelf(this.bwJ);
                this.cSY.f(this.mUserData);
                this.Yg.add(this.cSY);
            }
        }
        if (api()) {
            this.cTf = new com.baidu.tieba.person.data.m();
            this.cTf.a(this.cNE);
            this.Yg.add(this.cTf);
        }
        if (anY()) {
            this.cTe = new com.baidu.tieba.person.data.g();
            this.cTe.f(this.mUserData);
            this.cTe.setIsSelf(getIsSelf());
            this.Yg.add(this.cTe);
        }
        this.cTi = app();
        this.Yg.add(this.cTi);
        if (!this.bwJ && this.mUserData != null) {
            this.cTh = new com.baidu.tieba.person.data.e();
            this.cTh.cNr = this.mUserData.getFansNum();
            this.cTh.sex = this.mUserData.getSex();
            this.cTh.isSelf = this.bwJ;
            this.cTh.userId = this.mUserData.getUserId();
            this.Yg.add(this.cTh);
            this.cTg = new com.baidu.tieba.person.data.b();
            this.cTg.cNl = this.mUserData.getConcern_num();
            this.cTg.isSelf = this.bwJ;
            this.cTg.userId = this.mUserData.getUserId();
            this.cTg.sex = this.mUserData.getSex();
            this.Yg.add(this.cTg);
        }
        this.cTc = new com.baidu.tieba.person.data.l();
        this.cTc.setIsSelf(getIsSelf());
        this.cTc.f(this.mUserData);
        this.cTc.a(apc());
        this.cTc.d(this.cME);
        if (com.baidu.tbadk.core.util.y.k(this.cME) <= 0) {
            this.cTc.cNj = false;
        }
        this.Yg.add(this.cTc);
        this.cSZ = new com.baidu.tieba.person.data.f();
        this.cSZ.setSelf(getIsSelf());
        if (this.mUserData != null) {
            this.cSZ.setSex(this.mUserData.getSex());
            this.cSZ.setCount(this.mUserData.getLike_bars());
            this.cSZ.setIsFriend(this.mUserData.getIsFriend());
            this.cSZ.setUserId(this.mUserData.getUserId());
            this.cSZ.ks(this.mUserData.getPersonPrivate().AW());
            this.cSZ.bp(this.mUserData.getLikeForum());
            if (com.baidu.tbadk.core.util.y.k(this.mUserData.getLikeForum()) <= 0) {
                this.cSZ.cNj = false;
            }
        }
        this.Yg.add(this.cSZ);
        if (apn()) {
            this.cTa = new com.baidu.tieba.person.data.h();
            this.cTa.setIsSelf(getIsSelf());
            this.cTa.f(this.mUserData);
            this.cTa.a(apc());
            if (com.baidu.tbadk.core.util.y.k(this.mUserData.getGroup()) <= 0) {
                this.cTa.cNj = false;
            }
            this.Yg.add(this.cTa);
        }
        if (getIsSelf() && apm()) {
            this.cTd = new com.baidu.tieba.person.data.i();
            this.Yg.add(this.cTd);
        }
    }

    public int aps() {
        if (getUserData() == null || getUserData().getGodInfo() == null) {
            return 0;
        }
        int intValue = getUserData().getGodInfo().type.intValue();
        return (intValue == 2 || intValue == 1) ? 1 : 0;
    }
}

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
    private ArrayList<com.baidu.adp.widget.ListView.u> Xz;
    private boolean bJj;
    private boolean dDJ;
    private boolean dDK;
    private String dDL;
    public boolean dDM;
    private User dDN;
    private bp dDO;
    private com.baidu.tbadk.coreExtra.d.a dDP;
    private long dDQ;
    private com.baidu.tieba.person.data.m dDR;
    private com.baidu.tieba.person.data.f dDS;
    private com.baidu.tieba.person.data.k dDT;
    private com.baidu.tieba.person.data.c dDU;
    private com.baidu.tieba.person.data.o dDV;
    private com.baidu.tieba.person.data.l dDW;
    private com.baidu.tieba.person.data.i dDX;
    private com.baidu.tieba.person.data.b dDY;
    private com.baidu.tieba.person.data.e dDZ;
    private com.baidu.tieba.person.data.h dEa;
    private com.baidu.tieba.person.data.g dEb;
    private com.baidu.tieba.person.data.q dEc;
    private com.baidu.tieba.person.a.ae dEd;
    private BaseFragmentActivity dEe;
    private boolean dEf;
    private List<com.baidu.tieba.card.a.c> dEg;
    private AntiData ddd;
    private CustomMessageListener duf;
    private PersonTainInfo dve;
    private List<PersonInfoPostList> dvh;
    private PersonUserGodInfo dwG;
    private MetaData dwS;
    private String mId;
    private String mName;
    private String mNameShow;
    private UserData mUserData;
    private String stType;

    public MetaData getAuthor() {
        return this.dwS;
    }

    public PersonUserGodInfo aDd() {
        return this.dwG;
    }

    public ArrayList<com.baidu.adp.widget.ListView.u> getDataList() {
        return this.Xz;
    }

    public List<com.baidu.tieba.card.a.c> aDe() {
        return this.dEg;
    }

    public void bH(long j) {
        this.dDQ = j;
    }

    public AntiData amu() {
        return this.ddd;
    }

    public void e(AntiData antiData) {
        this.ddd = antiData;
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public void f(UserData userData) {
        if (userData != null) {
            setName(userData.getUserName());
            mu(userData.getName_show());
        }
        this.mUserData = userData;
    }

    public PersonTainInfo aDf() {
        return this.dve;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public bf(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.dvh = new ArrayList();
        this.dDP = new com.baidu.tbadk.coreExtra.d.a(this.mLoadDataCallBack);
        this.Xz = new ArrayList<>();
        this.dEf = false;
        this.dEg = new ArrayList();
        this.duf = new bg(this, CmdConfigCustom.CMD_CACHE_PERSONINFO);
        this.dEe = baseFragmentActivity;
    }

    public boolean getIsSelf() {
        return this.bJj;
    }

    public void setIsSelf(boolean z) {
        this.bJj = z;
    }

    public void gR(boolean z) {
        this.dDJ = z;
    }

    public void gS(boolean z) {
        this.dDK = z;
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

    public void mu(String str) {
        this.mNameShow = str;
    }

    public String getStType() {
        return this.stType;
    }

    public void setStType(String str) {
        this.stType = str;
    }

    public String aDg() {
        return this.dDL;
    }

    public void mv(String str) {
        this.dDL = str;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public void aDh() {
        if (this.mUserData != null && this.dDP != null && this.mUserData.getUserId() != null) {
            if (this.mUserData.getHave_attention() != 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10609").ac("obj_id", this.mUserData.getUserId()).r("obj_param1", aDw()));
            } else {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10610").ac("obj_id", this.mUserData.getUserId()).r("obj_param1", aDw()));
            }
            this.dDP.a(this.mUserData.getHave_attention() != 1, this.mUserData.getPortrait(), this.mUserData.getUserId(), aDx());
        }
    }

    public void aDi() {
        MessageManager.getInstance().unRegisterListener(this.duf);
    }

    public void aBD() {
        com.baidu.tbadk.task.a aVar = new com.baidu.tbadk.task.a(CmdConfigCustom.CMD_CACHE_PERSONINFO, new bh());
        aVar.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(aVar);
        this.duf.setSelfListener(true);
        this.duf.setTag(getUniqueId());
        registerListener(this.duf);
    }

    public void aDj() {
        sendMessage(new RequestPersonInfoMessage());
    }

    public void aDk() {
        if (!com.baidu.adp.lib.util.i.jf()) {
            this.mLoadDataCallBack.d(0);
        } else if (TbadkCoreApplication.isLogin() || (this.dEe instanceof PersonInfoActivity)) {
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
            if (aDg() != null) {
                try {
                    profileRequestMessage.set_st_type(aDg());
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
                com.baidu.tbadk.getUserInfo.b.EG().a(this.mUserData);
                TbadkCoreApplication.m411getInst();
                if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                    TbadkCoreApplication.m411getInst();
                    TbadkCoreApplication.getCurrentAccountInfo().setGodType(this.dwG.getGodType());
                }
            }
            UserData userData = this.mUserData;
            if (userData != null) {
                f(userData);
            }
            AntiData amu = amu();
            if (amu != null) {
                e(amu);
            }
            aDv();
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
                this.dDN = profileHttpResponseMessage.GetUser();
                if (this.dve == null) {
                    this.dve = new PersonTainInfo();
                }
                this.dve.parseProto(profileHttpResponseMessage.GetTainfo());
                if (this.dwG == null) {
                    this.dwG = new PersonUserGodInfo();
                }
                this.dwG.parserProtobuf(profileHttpResponseMessage.getUserGodInfo());
                if (this.dwS == null) {
                    this.dwS = new MetaData();
                }
                this.dwS.parserProtobuf(this.dDN);
                if (this.ddd == null) {
                    this.ddd = new AntiData();
                }
                this.ddd.parserProtobuf(profileHttpResponseMessage.GetAntiStat());
                this.ddd.setUser_id(this.mUserData.getUserId());
                this.ddd.setUser_name(this.mUserData.getUserName());
                if (profileHttpResponseMessage.getUcCard() != null) {
                    this.dDO = new bp();
                    this.dDO.a(profileHttpResponseMessage.getUcCard());
                }
                this.dvh.clear();
                List<PostInfoList> GetPostList = profileHttpResponseMessage.GetPostList();
                if (GetPostList != null) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < GetPostList.size()) {
                            PersonInfoPostList personInfoPostList = new PersonInfoPostList();
                            personInfoPostList.parseProto(GetPostList.get(i2));
                            this.dvh.add(personInfoPostList);
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
                this.dDN = profileSocketResponseMessage.GetUser();
                if (this.dve == null) {
                    this.dve = new PersonTainInfo();
                }
                this.dve.parseProto(profileSocketResponseMessage.GetTainfo());
                if (this.dwG == null) {
                    this.dwG = new PersonUserGodInfo();
                }
                this.dwG.parserProtobuf(profileSocketResponseMessage.getUserGodInfo());
                if (this.dwS == null) {
                    this.dwS = new MetaData();
                }
                this.dwS.parserProtobuf(this.dDN);
                if (this.ddd == null) {
                    this.ddd = new AntiData();
                }
                this.ddd.parserProtobuf(profileSocketResponseMessage.GetAntiStat());
                this.ddd.setUser_id(this.mUserData.getUserId());
                this.ddd.setUser_name(this.mUserData.getUserName());
                if (profileSocketResponseMessage.getUcCard() != null) {
                    this.dDO = new bp();
                    this.dDO.a(profileSocketResponseMessage.getUcCard());
                }
                this.dvh.clear();
                List<PostInfoList> GetPostList = profileSocketResponseMessage.GetPostList();
                if (GetPostList != null) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < GetPostList.size()) {
                            PersonInfoPostList personInfoPostList = new PersonInfoPostList();
                            personInfoPostList.parseProto(GetPostList.get(i2));
                            this.dvh.add(personInfoPostList);
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

    private boolean aDl() {
        return TbadkCoreApplication.m411getInst().appResponseToIntentClass(AddressListActivityConfig.class);
    }

    private boolean aDm() {
        return TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.START_EDITMARK);
    }

    private boolean aDn() {
        return TbadkCoreApplication.m411getInst().appResponseToIntentClass(PbHistoryActivityConfig.class);
    }

    private boolean aDo() {
        return TbadkCoreApplication.m411getInst().appResponseToIntentClass(MyLiveActivityConfig.class);
    }

    private boolean aBH() {
        return TbadkCoreApplication.m411getInst().appResponseToIntentClass(MemberPrivilegeActivityConfig.class);
    }

    private boolean aBG() {
        return TbadkCoreApplication.m411getInst().appResponseToIntentClass(MyGiftListActivityConfig.class);
    }

    private boolean aDp() {
        return TbadkCoreApplication.m411getInst().appResponseToIntentClass(FriendFeedActivityConfig.class);
    }

    private boolean aDq() {
        return TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_FEED);
    }

    private boolean aDr() {
        return TbadkCoreApplication.m411getInst().appResponseToIntentClass(GroupActivityActivityConfig.class) && TbadkCoreApplication.m411getInst().appResponseToIntentClass(PersonGroupActivityConfig.class);
    }

    public com.baidu.tieba.person.data.c aDs() {
        com.baidu.tieba.person.data.c cVar = new com.baidu.tieba.person.data.c();
        if (aDn()) {
            cVar.dwi.add(new com.baidu.tieba.person.data.d(2));
        }
        if (aDm()) {
            cVar.dwi.add(new com.baidu.tieba.person.data.d(1));
        }
        if (!aDx()) {
            cVar.dwi.add(new com.baidu.tieba.person.data.d(4));
            cVar.dwi.add(new com.baidu.tieba.person.data.d(3));
        } else if (this.bJj && aDp()) {
            cVar.dwi.add(new com.baidu.tieba.person.data.d(5));
        }
        if (aDl()) {
            cVar.dwi.add(new com.baidu.tieba.person.data.d(0));
        }
        return cVar;
    }

    private com.baidu.tieba.person.a.ae aDt() {
        if (this.mUserData == null) {
            return null;
        }
        com.baidu.tieba.person.a.ae aeVar = new com.baidu.tieba.person.a.ae();
        aeVar.setSelf(this.bJj);
        aeVar.setPhotoAlbum(this.mUserData.getPhotoAlbum());
        if (this.bJj && this.mUserData.getPhotoAlbum() != null && !bO(this.mUserData.getPhotoAlbum()) && this.mUserData.getPhotoAlbum().size() < 9) {
            com.baidu.tbadk.data.h hVar = new com.baidu.tbadk.data.h();
            hVar.bj(false);
            hVar.bk(true);
            aeVar.getPhotoAlbum().add(hVar);
            return aeVar;
        }
        return aeVar;
    }

    private boolean bO(List<com.baidu.tbadk.data.h> list) {
        int p = com.baidu.tbadk.core.util.y.p(list);
        if (p == 0) {
            return false;
        }
        for (int i = p - 1; i >= 0; i--) {
            com.baidu.tbadk.data.h hVar = (com.baidu.tbadk.data.h) com.baidu.tbadk.core.util.y.b(list, i);
            if (hVar != null && hVar.isAdded()) {
                return true;
            }
        }
        return false;
    }

    public com.baidu.tieba.person.a.ae aDu() {
        return this.dEd;
    }

    public void aDv() {
        this.Xz.clear();
        if (this.mUserData != null && getIsSelf() && this.mUserData.getUserVipInfo() != null) {
            TbadkCoreApplication.setCurrentMemberType(this.mUserData.getUserVipInfo().getVipStatus());
        }
        com.baidu.tieba.person.data.n nVar = new com.baidu.tieba.person.data.n();
        nVar.setIsSelf(getIsSelf());
        if (this.dve != null) {
            nVar.b(this.dve);
        }
        nVar.f(this.mUserData);
        this.Xz.add(nVar);
        if (this.bJj || aDx()) {
            this.dDU = aDs();
            this.Xz.add(this.dDU);
        }
        if (aBH()) {
            this.dDR = new com.baidu.tieba.person.data.m();
            if (this.bJj || this.mUserData == null || this.mUserData.getIsMem() == 2) {
                if (this.mUserData.getMembershipUserInfo() != null) {
                    this.dDR.setVipContent(this.mUserData.getMembershipUserInfo().getVipContent());
                    this.dDR.setVipIcon(this.mUserData.getMembershipUserInfo().getVipIcon());
                    this.dDR.setVipLink(this.mUserData.getMembershipUserInfo().getVipLink());
                }
                this.dDR.setIsSelf(this.bJj);
                this.dDR.f(this.mUserData);
                this.Xz.add(this.dDR);
            }
        }
        if (this.bJj && this.dDO != null) {
            this.dEc = new com.baidu.tieba.person.data.q();
            this.dEc.setName(this.dDO.getName());
            this.dEc.mr(this.dDO.aCa());
            this.dEc.setIcon(this.dDO.getIcon());
            this.dEc.mq(this.dDO.aBZ());
            this.dEc.bL(this.dDO.aCb());
            this.Xz.add(this.dEc);
        }
        if (this.bJj && !aDx() && aDp()) {
            this.dEa = new com.baidu.tieba.person.data.h();
            this.dEa.dwe = false;
            this.Xz.add(this.dEa);
        }
        if (this.bJj && aDq() && com.baidu.adp.lib.c.e.gE().ai("mygroup_states") == 1) {
            this.dEb = new com.baidu.tieba.person.data.g();
            this.dEb.dwd = false;
            if (this.dEa == null) {
                this.dEb.dwd = true;
                this.dDM = true;
            }
            this.dEb.dwe = false;
            this.Xz.add(this.dEb);
        }
        if (aBG()) {
            this.dDX = new com.baidu.tieba.person.data.i();
            this.dDX.f(this.mUserData);
            this.dDX.setIsSelf(getIsSelf());
            if (aDy()) {
                this.dDX.gI(true);
            } else {
                this.dDX.gI(false);
            }
            this.Xz.add(this.dDX);
        }
        if (!aDy()) {
            this.dEd = aDt();
            this.Xz.add(this.dEd);
        }
        if (!this.bJj && this.mUserData != null && !aDy()) {
            this.dDZ = new com.baidu.tieba.person.data.e();
            this.dDZ.dwm = this.mUserData.getFansNum();
            this.dDZ.sex = this.mUserData.getSex();
            this.dDZ.isSelf = this.bJj;
            this.dDZ.userId = this.mUserData.getUserId();
            this.Xz.add(this.dDZ);
            this.dDY = new com.baidu.tieba.person.data.b();
            this.dDY.dwg = this.mUserData.getConcernNum();
            this.dDY.isSelf = this.bJj;
            this.dDY.userId = this.mUserData.getUserId();
            this.dDY.sex = this.mUserData.getSex();
            this.Xz.add(this.dDY);
        }
        if (!aDy()) {
            this.dDV = new com.baidu.tieba.person.data.o();
            this.dDV.setIsSelf(getIsSelf());
            this.dDV.f(this.mUserData);
            this.dDV.a(aDf());
            this.dDV.d(this.dvh);
            if (com.baidu.tbadk.core.util.y.p(this.dvh) <= 0) {
                this.dDV.dwe = false;
            }
            this.Xz.add(this.dDV);
        }
        if (aDz()) {
            List<ThreadInfo> godThreadList = this.dwG.getGodThreadList();
            com.baidu.tieba.person.data.j jVar = new com.baidu.tieba.person.data.j();
            jVar.title = TbadkCoreApplication.m411getInst().getString(t.j.group_title_god);
            jVar.dwv = Math.max(com.baidu.adp.lib.h.b.c(this.dwG.getTotalThread(), 0L), godThreadList.size());
            this.Xz.add(jVar);
            if (com.baidu.tbadk.core.util.y.p(godThreadList) > 0) {
                List<ThreadInfo> subList = godThreadList.subList(0, Math.min(godThreadList.size(), 2));
                this.dEg.clear();
                bP(subList);
            }
        }
        if (getIsSelf() && aDo()) {
            this.dDW = new com.baidu.tieba.person.data.l();
            this.Xz.add(this.dDW);
            this.dDW.setUser(this.dDN);
        }
        if (!aDy()) {
            this.dDS = new com.baidu.tieba.person.data.f();
            this.dDS.setSelf(getIsSelf());
            if (this.mUserData != null) {
                this.dDS.setSex(this.mUserData.getSex());
                this.dDS.setCount(this.mUserData.getLike_bars());
                this.dDS.setIsFriend(aDf().getIsFriend());
                this.dDS.setUserId(this.mUserData.getUserId());
                this.dDS.mF(this.mUserData.getPersonPrivate().CH());
                this.dDS.bK(this.mUserData.getLikeForum());
                if (com.baidu.tbadk.core.util.y.p(this.mUserData.getLikeForum()) <= 0) {
                    this.dDS.dwe = false;
                }
            }
            this.Xz.add(this.dDS);
        }
        if (aDr() && !aDy()) {
            this.dDT = new com.baidu.tieba.person.data.k();
            this.dDT.setIsSelf(getIsSelf());
            this.dDT.f(this.mUserData);
            this.dDT.a(aDf());
            if (com.baidu.tbadk.core.util.y.p(this.mUserData.getGroup()) <= 0) {
                this.dDT.dwe = false;
            }
            this.Xz.add(this.dDT);
        }
        if (aDy()) {
            com.baidu.tieba.person.data.j jVar2 = new com.baidu.tieba.person.data.j();
            jVar2.dww = true;
            jVar2.dwu = aDB();
            this.Xz.add(jVar2);
            this.dEg.clear();
            bP(this.dwG.getGodThreadList());
        }
        this.dEf = true;
    }

    public int aDw() {
        if (getUserData() == null || getUserData().getGodInfo() == null) {
            return 0;
        }
        int intValue = getUserData().getGodInfo().type.intValue();
        return (intValue == 2 || intValue == 1) ? 1 : 0;
    }

    public boolean aDx() {
        return this.dwG != null && this.dwG.getGodType() == 2;
    }

    public boolean aDy() {
        return aDx() && !this.bJj;
    }

    public boolean aDz() {
        return aDx() && this.bJj;
    }

    public boolean aDA() {
        if (this.dwG == null || this.dwG.getGodType() != 2) {
            return false;
        }
        return com.baidu.adp.lib.h.b.c(this.dwG.getTotalThread(), 0L) > ((long) this.dwG.getGodThreadList().size());
    }

    public int aDB() {
        if (this.dwG != null) {
            return this.dwG.getCurPage();
        }
        return 0;
    }

    public void b(com.baidu.tbadk.core.data.w wVar) {
        if (wVar != null && this.dEf && this.dDW != null) {
            this.dDW.a(wVar);
            if (this.mLoadDataCallBack != null) {
                this.mLoadDataCallBack.d(1);
            }
        }
    }

    public void bP(List<ThreadInfo> list) {
        if (this.Xz != null && com.baidu.tbadk.core.util.y.p(list) > 0) {
            List<com.baidu.tieba.card.a.c> a = com.baidu.tieba.person.god.b.a(list, this.dwS, false);
            this.dEg.addAll(a);
            this.Xz.addAll(a);
        }
    }

    public void aDC() {
        if (this.dwS != null && this.mUserData != null && this.dwG != null) {
            this.dwS.setFansNum(this.mUserData.getFansNum());
            GodUserData godUserData = new GodUserData();
            godUserData.setType(this.dwG.getGodType());
            godUserData.setFollowed(this.mUserData.getHave_attention());
            godUserData.setId(Long.valueOf(com.baidu.adp.lib.h.b.c(this.mUserData.getUserId(), 0L)));
            this.dwS.setGodUserData(godUserData);
        }
    }
}

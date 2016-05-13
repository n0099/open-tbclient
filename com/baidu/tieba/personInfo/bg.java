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
import com.baidu.tbadk.core.atomData.MyGiftListActivityConfig;
import com.baidu.tbadk.core.atomData.MyLiveActivityConfig;
import com.baidu.tbadk.core.atomData.PbHistoryActivityConfig;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.atomData.PersonListActivityConfig;
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
import tbclient.Highlist;
import tbclient.PostInfoList;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes.dex */
public class bg extends com.baidu.adp.base.e<BaseFragmentActivity> {
    private ArrayList<com.baidu.adp.widget.ListView.v> SN;
    private boolean bJq;
    private CustomMessageListener cZY;
    private boolean dGU;
    private boolean dGV;
    private String dGW;
    public boolean dGX;
    private User dGY;
    private bq dGZ;
    private com.baidu.tbadk.coreExtra.d.a dHa;
    private long dHb;
    private com.baidu.tieba.person.data.g dHc;
    private com.baidu.tieba.person.data.l dHd;
    private com.baidu.tieba.person.data.d dHe;
    private com.baidu.tieba.person.data.p dHf;
    private com.baidu.tieba.person.data.m dHg;
    private com.baidu.tieba.person.data.j dHh;
    private com.baidu.tieba.person.data.c dHi;
    private com.baidu.tieba.person.data.f dHj;
    private com.baidu.tieba.person.data.i dHk;
    private com.baidu.tieba.person.data.h dHl;
    private com.baidu.tieba.person.data.t dHm;
    private com.baidu.tieba.person.data.q dHn;
    private com.baidu.tieba.person.data.s dHo;
    private com.baidu.tieba.person.a.al dHp;
    private BaseFragmentActivity dHq;
    private boolean dHr;
    private List<com.baidu.tieba.card.a.c> dHs;
    private AntiData dfx;
    private PersonTainInfo dya;
    private List<PersonInfoPostList> dyd;
    private PersonUserGodInfo dzL;
    private MetaData dzX;
    private Highlist highlist;
    private String mId;
    private String mName;
    private String mNameShow;
    private UserData mUserData;
    private String stType;

    public MetaData getAuthor() {
        return this.dzX;
    }

    public PersonUserGodInfo aDB() {
        return this.dzL;
    }

    public ArrayList<com.baidu.adp.widget.ListView.v> getDataList() {
        return this.SN;
    }

    public List<com.baidu.tieba.card.a.c> aDC() {
        return this.dHs;
    }

    public void bH(long j) {
        this.dHb = j;
    }

    public AntiData getAntiData() {
        return this.dfx;
    }

    public void setAntiData(AntiData antiData) {
        this.dfx = antiData;
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public void f(UserData userData) {
        if (userData != null) {
            setName(userData.getUserName());
            mz(userData.getName_show());
        }
        this.mUserData = userData;
    }

    public PersonTainInfo aDD() {
        return this.dya;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public bg(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.dyd = new ArrayList();
        this.dHa = new com.baidu.tbadk.coreExtra.d.a(this.mLoadDataCallBack);
        this.SN = new ArrayList<>();
        this.dHr = false;
        this.dHs = new ArrayList();
        this.cZY = new bh(this, CmdConfigCustom.CMD_CACHE_PERSONINFO);
        this.dHq = baseFragmentActivity;
    }

    public boolean getIsSelf() {
        return this.bJq;
    }

    public void setIsSelf(boolean z) {
        this.bJq = z;
    }

    public void hA(boolean z) {
        this.dGU = z;
    }

    public void hB(boolean z) {
        this.dGV = z;
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

    public void mz(String str) {
        this.mNameShow = str;
    }

    public String getStType() {
        return this.stType;
    }

    public void setStType(String str) {
        this.stType = str;
    }

    public String aDE() {
        return this.dGW;
    }

    public void mA(String str) {
        this.dGW = str;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public void aDF() {
        if (this.mUserData != null && this.dHa != null && this.mUserData.getUserId() != null) {
            if (this.mUserData.getHave_attention() != 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10609").ac("obj_id", this.mUserData.getUserId()).s("obj_param1", aDV()));
            } else {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10610").ac("obj_id", this.mUserData.getUserId()).s("obj_param1", aDV()));
            }
            this.dHa.a(this.mUserData.getHave_attention() != 1, this.mUserData.getPortrait(), this.mUserData.getUserId(), aDW(), "0");
        }
    }

    public void aDG() {
        MessageManager.getInstance().unRegisterListener(this.cZY);
    }

    public void atU() {
        com.baidu.tbadk.task.a aVar = new com.baidu.tbadk.task.a(CmdConfigCustom.CMD_CACHE_PERSONINFO, new bi());
        aVar.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(aVar);
        this.cZY.setSelfListener(true);
        this.cZY.setTag(getUniqueId());
        registerListener(this.cZY);
    }

    public void aDH() {
        sendMessage(new RequestPersonInfoMessage());
    }

    public void aDI() {
        if (!com.baidu.adp.lib.util.i.fq()) {
            this.mLoadDataCallBack.d(0);
        } else if (TbadkCoreApplication.isLogin() || (this.dHq instanceof PersonInfoActivity)) {
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
            if (aDE() != null) {
                try {
                    profileRequestMessage.set_st_type(aDE());
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
                com.baidu.tbadk.getUserInfo.b.CA().a(this.mUserData);
                TbadkCoreApplication.m11getInst();
                if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                    TbadkCoreApplication.m11getInst();
                    TbadkCoreApplication.getCurrentAccountInfo().setGodType(this.dzL.getGodType());
                }
            }
            UserData userData = this.mUserData;
            if (userData != null) {
                f(userData);
            }
            AntiData antiData = getAntiData();
            if (antiData != null) {
                setAntiData(antiData);
            }
            aDU();
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
                this.dGY = profileHttpResponseMessage.GetUser();
                if (this.dya == null) {
                    this.dya = new PersonTainInfo();
                }
                this.dya.parseProto(profileHttpResponseMessage.GetTainfo());
                if (this.dzL == null) {
                    this.dzL = new PersonUserGodInfo();
                }
                this.dzL.parserProtobuf(profileHttpResponseMessage.getUserGodInfo());
                if (this.dzX == null) {
                    this.dzX = new MetaData();
                }
                this.dzX.parserProtobuf(this.dGY);
                if (this.dfx == null) {
                    this.dfx = new AntiData();
                }
                this.dfx.parserProtobuf(profileHttpResponseMessage.GetAntiStat());
                this.dfx.setUser_id(this.mUserData.getUserId());
                this.dfx.setUser_name(this.mUserData.getUserName());
                if (profileHttpResponseMessage.getUcCard() != null) {
                    this.dGZ = new bq();
                    this.dGZ.a(profileHttpResponseMessage.getUcCard());
                }
                this.dyd.clear();
                List<PostInfoList> GetPostList = profileHttpResponseMessage.GetPostList();
                if (GetPostList != null) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= GetPostList.size()) {
                            break;
                        }
                        PersonInfoPostList personInfoPostList = new PersonInfoPostList();
                        personInfoPostList.parseProto(GetPostList.get(i2));
                        this.dyd.add(personInfoPostList);
                        i = i2 + 1;
                    }
                }
                if (this.highlist == null) {
                    this.highlist = profileHttpResponseMessage.getHighlist();
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
                this.dGY = profileSocketResponseMessage.GetUser();
                if (this.dya == null) {
                    this.dya = new PersonTainInfo();
                }
                this.dya.parseProto(profileSocketResponseMessage.GetTainfo());
                if (this.dzL == null) {
                    this.dzL = new PersonUserGodInfo();
                }
                this.dzL.parserProtobuf(profileSocketResponseMessage.getUserGodInfo());
                if (this.dzX == null) {
                    this.dzX = new MetaData();
                }
                this.dzX.parserProtobuf(this.dGY);
                if (this.dfx == null) {
                    this.dfx = new AntiData();
                }
                this.dfx.parserProtobuf(profileSocketResponseMessage.GetAntiStat());
                this.dfx.setUser_id(this.mUserData.getUserId());
                this.dfx.setUser_name(this.mUserData.getUserName());
                if (profileSocketResponseMessage.getUcCard() != null) {
                    this.dGZ = new bq();
                    this.dGZ.a(profileSocketResponseMessage.getUcCard());
                }
                this.dyd.clear();
                List<PostInfoList> GetPostList = profileSocketResponseMessage.GetPostList();
                if (GetPostList != null) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= GetPostList.size()) {
                            break;
                        }
                        PersonInfoPostList personInfoPostList = new PersonInfoPostList();
                        personInfoPostList.parseProto(GetPostList.get(i2));
                        this.dyd.add(personInfoPostList);
                        i = i2 + 1;
                    }
                }
                if (this.highlist == null) {
                    this.highlist = profileSocketResponseMessage.getHighlist();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private boolean aDJ() {
        return TbadkCoreApplication.m11getInst().appResponseToIntentClass(AddressListActivityConfig.class);
    }

    private boolean aDK() {
        return TbadkCoreApplication.m11getInst().appResponseToCmd(CmdConfigCustom.START_EDITMARK);
    }

    private boolean aDL() {
        return TbadkCoreApplication.m11getInst().appResponseToIntentClass(PbHistoryActivityConfig.class);
    }

    private boolean aDM() {
        return TbadkCoreApplication.m11getInst().appResponseToIntentClass(MyLiveActivityConfig.class);
    }

    private boolean aBZ() {
        return TbadkCoreApplication.m11getInst().appResponseToIntentClass(MyGiftListActivityConfig.class);
    }

    private boolean aDN() {
        return TbadkCoreApplication.m11getInst().appResponseToIntentClass(FriendFeedActivityConfig.class);
    }

    private boolean aDO() {
        return TbadkCoreApplication.m11getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_FEED);
    }

    private boolean aDP() {
        return TbadkCoreApplication.m11getInst().appResponseToIntentClass(PersonListActivityConfig.class);
    }

    private boolean aDQ() {
        return TbadkCoreApplication.m11getInst().appResponseToIntentClass(GroupActivityActivityConfig.class) && TbadkCoreApplication.m11getInst().appResponseToIntentClass(PersonGroupActivityConfig.class);
    }

    public com.baidu.tieba.person.data.d aDR() {
        com.baidu.tieba.person.data.d dVar = new com.baidu.tieba.person.data.d();
        if (aDL()) {
            dVar.dzm.add(new com.baidu.tieba.person.data.e(2));
        }
        if (aDK()) {
            dVar.dzm.add(new com.baidu.tieba.person.data.e(1));
        }
        if (!aDW()) {
            if (aDP()) {
                dVar.dzm.add(new com.baidu.tieba.person.data.e(4));
                dVar.dzm.add(new com.baidu.tieba.person.data.e(3));
            }
        } else if (this.bJq && aDN()) {
            dVar.dzm.add(new com.baidu.tieba.person.data.e(5));
        }
        if (aDJ()) {
            dVar.dzm.add(new com.baidu.tieba.person.data.e(0));
        }
        return dVar;
    }

    private com.baidu.tieba.person.a.al aDS() {
        if (this.mUserData == null) {
            return null;
        }
        com.baidu.tieba.person.a.al alVar = new com.baidu.tieba.person.a.al();
        alVar.setSelf(this.bJq);
        alVar.setPhotoAlbum(this.mUserData.getPhotoAlbum());
        if (this.bJq && this.mUserData.getPhotoAlbum() != null && !bQ(this.mUserData.getPhotoAlbum()) && this.mUserData.getPhotoAlbum().size() < 9) {
            com.baidu.tieba.person.data.b bVar = new com.baidu.tieba.person.data.b();
            bVar.mu(9 - this.mUserData.getPhotoAlbum().size());
            alVar.getPhotoAlbum().add(bVar);
            return alVar;
        }
        return alVar;
    }

    private boolean bQ(List<com.baidu.adp.widget.ListView.v> list) {
        int r = com.baidu.tbadk.core.util.y.r(list);
        if (r == 0) {
            return false;
        }
        for (int i = r - 1; i >= 0; i--) {
            com.baidu.adp.widget.ListView.v vVar = (com.baidu.adp.widget.ListView.v) com.baidu.tbadk.core.util.y.c(list, i);
            if (vVar != null && (vVar instanceof com.baidu.tieba.person.data.b)) {
                return true;
            }
        }
        return false;
    }

    public com.baidu.tieba.person.a.al aDT() {
        return this.dHp;
    }

    public void aDU() {
        this.SN.clear();
        if (this.mUserData != null && getIsSelf() && this.mUserData.getUserVipInfo() != null) {
            TbadkCoreApplication.setCurrentMemberType(this.mUserData.getUserVipInfo().getVipStatus());
        }
        com.baidu.tieba.person.data.o oVar = new com.baidu.tieba.person.data.o();
        oVar.setIsSelf(getIsSelf());
        if (this.dya != null) {
            oVar.b(this.dya);
        }
        oVar.f(this.mUserData);
        this.SN.add(oVar);
        if (this.bJq || aDW()) {
            this.dHe = aDR();
            this.SN.add(this.dHe);
        }
        if (this.bJq && this.dGZ != null) {
            this.dHm = new com.baidu.tieba.person.data.t();
            this.dHm.setName(this.dGZ.getName());
            this.dHm.mw(this.dGZ.aCx());
            this.dHm.setIcon(this.dGZ.getIcon());
            this.dHm.mv(this.dGZ.aCw());
            this.dHm.bN(this.dGZ.aCy());
            this.SN.add(this.dHm);
        }
        if (this.bJq && !aDW() && aDN()) {
            this.dHk = new com.baidu.tieba.person.data.i();
            this.dHk.dzg = false;
            this.SN.add(this.dHk);
        }
        if (this.bJq && aDO() && com.baidu.adp.lib.c.e.cS().Z("mygroup_states") == 1) {
            this.dHl = new com.baidu.tieba.person.data.h();
            this.dHl.dzf = false;
            if (this.dHk == null) {
                this.dHl.dzf = true;
                this.dGX = true;
            }
            this.dHl.dzg = false;
            this.SN.add(this.dHl);
        }
        if (aBZ()) {
            this.dHh = new com.baidu.tieba.person.data.j();
            this.dHh.f(this.mUserData);
            this.dHh.setIsSelf(getIsSelf());
            if (aDX()) {
                this.dHh.ho(true);
            } else {
                this.dHh.ho(false);
            }
            this.SN.add(this.dHh);
        }
        if (com.baidu.tbadk.plugins.g.Fd()) {
            if (this.bJq) {
                this.dHn = new com.baidu.tieba.person.data.q();
                this.dHn.dzg = false;
                this.SN.add(this.dHn);
            } else if (this.highlist != null && this.highlist.list != null && this.highlist.list.size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < this.highlist.list.size() && i != 4; i++) {
                    arrayList.add(this.highlist.list.get(i));
                }
                this.dHo = new com.baidu.tieba.person.data.s();
                this.dHo.mu(this.mUserData.getUserId());
                this.dHo.setSex(this.mUserData.getSex());
                this.dHo.bM(arrayList);
                this.dHo.setHasMore(this.highlist.has_more.booleanValue());
                this.SN.add(this.dHo);
            }
        }
        if (!aDX()) {
            this.dHp = aDS();
            this.SN.add(this.dHp);
        }
        if (!this.bJq && this.mUserData != null && !aDX() && aDP()) {
            this.dHj = new com.baidu.tieba.person.data.f();
            this.dHj.dzq = this.mUserData.getFansNum();
            this.dHj.sex = this.mUserData.getSex();
            this.dHj.isSelf = this.bJq;
            this.dHj.userId = this.mUserData.getUserId();
            this.SN.add(this.dHj);
            this.dHi = new com.baidu.tieba.person.data.c();
            this.dHi.dzk = this.mUserData.getConcernNum();
            this.dHi.isSelf = this.bJq;
            this.dHi.userId = this.mUserData.getUserId();
            this.dHi.sex = this.mUserData.getSex();
            this.SN.add(this.dHi);
        }
        if (!aDX()) {
            this.dHf = new com.baidu.tieba.person.data.p();
            this.dHf.setIsSelf(getIsSelf());
            this.dHf.f(this.mUserData);
            this.dHf.a(aDD());
            this.dHf.d(this.dyd);
            if (com.baidu.tbadk.core.util.y.r(this.dyd) <= 0) {
                this.dHf.dzg = false;
            }
            this.SN.add(this.dHf);
        }
        if (aDY()) {
            List<ThreadInfo> godThreadList = this.dzL.getGodThreadList();
            com.baidu.tieba.person.data.k kVar = new com.baidu.tieba.person.data.k();
            kVar.title = TbadkCoreApplication.m11getInst().getString(t.j.group_title_god);
            kVar.dzz = Math.max(com.baidu.adp.lib.h.b.c(this.dzL.getTotalThread(), 0L), godThreadList.size());
            this.SN.add(kVar);
            if (com.baidu.tbadk.core.util.y.r(godThreadList) > 0) {
                List<ThreadInfo> subList = godThreadList.subList(0, Math.min(godThreadList.size(), 2));
                this.dHs.clear();
                bR(subList);
            }
        }
        if (getIsSelf() && aDM()) {
            this.dHg = new com.baidu.tieba.person.data.m();
            this.SN.add(this.dHg);
            this.dHg.setUser(this.dGY);
        }
        if (!aDX()) {
            this.dHc = new com.baidu.tieba.person.data.g();
            this.dHc.setSelf(getIsSelf());
            if (this.mUserData != null) {
                this.dHc.setSex(this.mUserData.getSex());
                this.dHc.setCount(this.mUserData.getLike_bars());
                this.dHc.setIsFriend(aDD().getIsFriend());
                this.dHc.setUserId(this.mUserData.getUserId());
                this.dHc.mw(this.mUserData.getPersonPrivate().AC());
                this.dHc.bL(this.mUserData.getLikeForum());
                if (com.baidu.tbadk.core.util.y.r(this.mUserData.getLikeForum()) <= 0) {
                    this.dHc.dzg = false;
                }
            }
            this.SN.add(this.dHc);
        }
        if (aDQ() && !aDX()) {
            this.dHd = new com.baidu.tieba.person.data.l();
            this.dHd.setIsSelf(getIsSelf());
            this.dHd.f(this.mUserData);
            this.dHd.a(aDD());
            if (com.baidu.tbadk.core.util.y.r(this.mUserData.getGroup()) <= 0) {
                this.dHd.dzg = false;
            }
            this.SN.add(this.dHd);
        }
        if (aDX()) {
            com.baidu.tieba.person.data.k kVar2 = new com.baidu.tieba.person.data.k();
            kVar2.dzA = true;
            kVar2.dzy = aEa();
            this.SN.add(kVar2);
            this.dHs.clear();
            bR(this.dzL.getGodThreadList());
        }
        this.dHr = true;
    }

    public int aDV() {
        if (getUserData() == null || getUserData().getGodInfo() == null) {
            return 0;
        }
        int intValue = getUserData().getGodInfo().type.intValue();
        return (intValue == 2 || intValue == 1) ? 1 : 0;
    }

    public boolean aDW() {
        return this.dzL != null && this.dzL.getGodType() == 2;
    }

    public boolean aDX() {
        return aDW() && !this.bJq;
    }

    public boolean aDY() {
        return aDW() && this.bJq;
    }

    public boolean aDZ() {
        if (this.dzL == null || this.dzL.getGodType() != 2) {
            return false;
        }
        return com.baidu.adp.lib.h.b.c(this.dzL.getTotalThread(), 0L) > ((long) this.dzL.getGodThreadList().size());
    }

    public int aEa() {
        if (this.dzL != null) {
            return this.dzL.getCurPage();
        }
        return 0;
    }

    public void b(com.baidu.tbadk.core.data.w wVar) {
        if (wVar != null && this.dHr && this.dHg != null) {
            this.dHg.a(wVar);
            if (this.mLoadDataCallBack != null) {
                this.mLoadDataCallBack.d(1);
            }
        }
    }

    public void bR(List<ThreadInfo> list) {
        if (this.SN != null && com.baidu.tbadk.core.util.y.r(list) > 0) {
            List<com.baidu.tieba.card.a.c> a = com.baidu.tieba.person.god.b.a(list, this.dzX, false);
            this.dHs.addAll(a);
            this.SN.addAll(a);
        }
    }

    public void aEb() {
        if (this.dzX != null && this.mUserData != null && this.dzL != null) {
            this.dzX.setFansNum(this.mUserData.getFansNum());
            GodUserData godUserData = new GodUserData();
            godUserData.setType(this.dzL.getGodType());
            godUserData.setFollowed(this.mUserData.getHave_attention());
            godUserData.setId(Long.valueOf(com.baidu.adp.lib.h.b.c(this.mUserData.getUserId(), 0L)));
            this.dzX.setGodUserData(godUserData);
        }
    }
}

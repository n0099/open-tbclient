package com.baidu.tieba.personInfo;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddressListActivityConfig;
import com.baidu.tbadk.core.atomData.EcommPersonManagerActivityConfig;
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
import com.baidu.tbadk.switchs.EcommSwitchStatic;
import com.baidu.tieba.person.ProfileHttpResponseMessage;
import com.baidu.tieba.person.ProfileRequestMessage;
import com.baidu.tieba.person.ProfileSocketResponseMessage;
import com.baidu.tieba.person.bs;
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.DealWindow;
import tbclient.Highlist;
import tbclient.PostInfoList;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes.dex */
public class bp extends com.baidu.adp.base.e<BaseFragmentActivity> {
    private ArrayList<com.baidu.adp.widget.ListView.v> Te;
    private BdUniqueId aeu;
    private com.baidu.tbadk.coreExtra.d.a bjp;
    private boolean chd;
    private CustomMessageListener dGG;
    private AntiData dMq;
    private PersonTainInfo egw;
    private List<PersonInfoPostList> egz;
    private MetaData eiE;
    private PersonUserGodInfo eip;
    private boolean epY;
    private boolean epZ;
    private String eqa;
    public boolean eqb;
    public boolean eqc;
    private User eqd;
    private long eqe;
    private com.baidu.tieba.person.data.n eqf;
    private com.baidu.tieba.person.data.g eqg;
    private com.baidu.tieba.person.data.l eqh;
    private com.baidu.tieba.person.data.d eqi;
    private com.baidu.tieba.person.data.p eqj;
    private com.baidu.tieba.person.data.m eqk;
    private com.baidu.tieba.person.data.j eql;
    private com.baidu.tieba.person.data.c eqm;
    private com.baidu.tieba.person.data.f eqn;
    private com.baidu.tieba.person.data.i eqo;
    private com.baidu.tieba.person.data.h eqp;
    private com.baidu.tieba.person.data.t eqq;
    private com.baidu.tieba.person.data.q eqr;
    private com.baidu.tieba.person.data.s eqs;
    public com.baidu.tieba.person.data.v eqt;
    private com.baidu.tieba.person.a.al equ;
    private BaseFragmentActivity eqv;
    private boolean eqw;
    private List<com.baidu.tieba.card.a.c> eqx;
    private Highlist highlist;
    private String mId;
    private String mName;
    private String mNameShow;
    private UserData mUserData;
    private String stType;
    private com.baidu.tieba.person.bs ucCardData;
    public DealWindow window;

    public MetaData getAuthor() {
        return this.eiE;
    }

    public PersonUserGodInfo aMw() {
        return this.eip;
    }

    public ArrayList<com.baidu.adp.widget.ListView.v> getDataList() {
        return this.Te;
    }

    public List<com.baidu.tieba.card.a.c> aMx() {
        return this.eqx;
    }

    public void cr(long j) {
        this.eqe = j;
    }

    public AntiData getAntiData() {
        return this.dMq;
    }

    public void setAntiData(AntiData antiData) {
        this.dMq = antiData;
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public void f(UserData userData) {
        if (userData != null) {
            setName(userData.getUserName());
            og(userData.getName_show());
        }
        this.mUserData = userData;
    }

    public PersonTainInfo aMy() {
        return this.egw;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public bp(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.egz = new ArrayList();
        this.bjp = new com.baidu.tbadk.coreExtra.d.a(this.mLoadDataCallBack);
        this.Te = new ArrayList<>();
        this.eqw = false;
        this.eqx = new ArrayList();
        this.dGG = new bq(this, CmdConfigCustom.CMD_CACHE_PERSONINFO);
        this.eqv = baseFragmentActivity;
    }

    public boolean getIsSelf() {
        return this.chd;
    }

    public void setIsSelf(boolean z) {
        this.chd = z;
    }

    public void iv(boolean z) {
        this.epY = z;
    }

    public void iw(boolean z) {
        this.epZ = z;
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

    public void og(String str) {
        this.mNameShow = str;
    }

    public String getStType() {
        return this.stType;
    }

    public void setStType(String str) {
        this.stType = str;
    }

    public String aMz() {
        return this.eqa;
    }

    public void oh(String str) {
        this.eqa = str;
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.aeu = bdUniqueId;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public void aMA() {
        if (this.mUserData != null && this.bjp != null && this.mUserData.getUserId() != null) {
            if (this.mUserData.getHave_attention() != 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10609").ab("obj_id", this.mUserData.getUserId()).s("obj_param1", aMQ()));
            } else {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10610").ab("obj_id", this.mUserData.getUserId()).s("obj_param1", aMQ()));
            }
            this.bjp.a(this.mUserData.getHave_attention() != 1, this.mUserData.getPortrait(), this.mUserData.getUserId(), aMR(), this.aeu);
        }
    }

    public void aMB() {
        MessageManager.getInstance().unRegisterListener(this.dGG);
    }

    public void aBZ() {
        com.baidu.tbadk.task.a aVar = new com.baidu.tbadk.task.a(CmdConfigCustom.CMD_CACHE_PERSONINFO, new br());
        aVar.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(aVar);
        this.dGG.setSelfListener(true);
        this.dGG.setTag(getUniqueId());
        registerListener(this.dGG);
    }

    public void aMC() {
        sendMessage(new RequestPersonInfoMessage());
    }

    public void aMD() {
        if (!com.baidu.adp.lib.util.i.fr()) {
            this.mLoadDataCallBack.d(0);
        } else if (TbadkCoreApplication.isLogin() || (this.eqv instanceof PersonInfoActivity)) {
            ProfileRequestMessage profileRequestMessage = new ProfileRequestMessage();
            profileRequestMessage.setNetType(NetMessage.NetType.AUTO);
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
            if (aMz() != null) {
                try {
                    profileRequestMessage.set_st_type(aMz());
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
                com.baidu.tbadk.getUserInfo.b.CI().a(this.mUserData);
                TbadkCoreApplication.m9getInst();
                if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                    TbadkCoreApplication.m9getInst();
                    TbadkCoreApplication.getCurrentAccountInfo().setGodType(this.eip.getGodType());
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
            aMP();
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
                this.eqd = profileHttpResponseMessage.GetUser();
                if (this.egw == null) {
                    this.egw = new PersonTainInfo();
                }
                this.egw.parseProto(profileHttpResponseMessage.GetTainfo());
                if (this.eip == null) {
                    this.eip = new PersonUserGodInfo();
                }
                this.eip.parserProtobuf(profileHttpResponseMessage.getUserGodInfo());
                if (this.eiE == null) {
                    this.eiE = new MetaData();
                }
                this.eiE.parserProtobuf(this.eqd);
                if (this.dMq == null) {
                    this.dMq = new AntiData();
                }
                this.dMq.parserProtobuf(profileHttpResponseMessage.GetAntiStat());
                this.dMq.setUser_id(this.mUserData.getUserId());
                this.dMq.setUser_name(this.mUserData.getUserName());
                this.ucCardData = profileHttpResponseMessage.ucCardData;
                this.egz.clear();
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
                        this.egz.add(personInfoPostList);
                        i = i2 + 1;
                    }
                }
                if (this.highlist == null) {
                    this.highlist = profileHttpResponseMessage.getHighlist();
                }
                if (profileHttpResponseMessage.window != null) {
                    this.window = profileHttpResponseMessage.window;
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
                this.eqd = profileSocketResponseMessage.GetUser();
                if (this.egw == null) {
                    this.egw = new PersonTainInfo();
                }
                this.egw.parseProto(profileSocketResponseMessage.GetTainfo());
                if (this.eip == null) {
                    this.eip = new PersonUserGodInfo();
                }
                this.eip.parserProtobuf(profileSocketResponseMessage.getUserGodInfo());
                if (this.eiE == null) {
                    this.eiE = new MetaData();
                }
                this.eiE.parserProtobuf(this.eqd);
                if (this.dMq == null) {
                    this.dMq = new AntiData();
                }
                this.dMq.parserProtobuf(profileSocketResponseMessage.GetAntiStat());
                this.dMq.setUser_id(this.mUserData.getUserId());
                this.dMq.setUser_name(this.mUserData.getUserName());
                this.ucCardData = profileSocketResponseMessage.ucCardData;
                this.egz.clear();
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
                        this.egz.add(personInfoPostList);
                        i = i2 + 1;
                    }
                }
                if (this.highlist == null) {
                    this.highlist = profileSocketResponseMessage.getHighlist();
                }
                if (profileSocketResponseMessage.window != null) {
                    this.window = profileSocketResponseMessage.window;
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private boolean aME() {
        return TbadkCoreApplication.m9getInst().appResponseToIntentClass(AddressListActivityConfig.class);
    }

    private boolean aMF() {
        return TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.START_EDITMARK);
    }

    private boolean aMG() {
        return TbadkCoreApplication.m9getInst().appResponseToIntentClass(PbHistoryActivityConfig.class);
    }

    private boolean aMH() {
        return TbadkCoreApplication.m9getInst().appResponseToIntentClass(MyLiveActivityConfig.class);
    }

    private boolean aKR() {
        return TbadkCoreApplication.m9getInst().appResponseToIntentClass(MyGiftListActivityConfig.class);
    }

    private boolean aMI() {
        return TbadkCoreApplication.m9getInst().appResponseToIntentClass(FriendFeedActivityConfig.class);
    }

    private boolean aMJ() {
        return TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_FEED);
    }

    private boolean aMK() {
        return TbadkCoreApplication.m9getInst().appResponseToIntentClass(PersonListActivityConfig.class);
    }

    private boolean aML() {
        return TbadkCoreApplication.m9getInst().appResponseToIntentClass(GroupActivityActivityConfig.class) && TbadkCoreApplication.m9getInst().appResponseToIntentClass(PersonGroupActivityConfig.class);
    }

    public com.baidu.tieba.person.data.d aMM() {
        com.baidu.tieba.person.data.d dVar = new com.baidu.tieba.person.data.d();
        if (aMG()) {
            dVar.ehQ.add(new com.baidu.tieba.person.data.e(2));
        }
        if (aMF()) {
            dVar.ehQ.add(new com.baidu.tieba.person.data.e(1));
        }
        if (!aMR()) {
            if (aMK()) {
                dVar.ehQ.add(new com.baidu.tieba.person.data.e(4));
                dVar.ehQ.add(new com.baidu.tieba.person.data.e(3));
            }
        } else if (this.chd && aMI()) {
            dVar.ehQ.add(new com.baidu.tieba.person.data.e(5));
        }
        if (aME()) {
            dVar.ehQ.add(new com.baidu.tieba.person.data.e(0));
        }
        return dVar;
    }

    private com.baidu.tieba.person.a.al aMN() {
        if (this.mUserData == null) {
            return null;
        }
        com.baidu.tieba.person.a.al alVar = new com.baidu.tieba.person.a.al();
        alVar.setSelf(this.chd);
        alVar.setPhotoAlbum(this.mUserData.getPhotoAlbum());
        if (this.chd && this.mUserData.getPhotoAlbum() != null && !co(this.mUserData.getPhotoAlbum()) && this.mUserData.getPhotoAlbum().size() < 9) {
            com.baidu.tieba.person.data.b bVar = new com.baidu.tieba.person.data.b();
            bVar.nV(9 - this.mUserData.getPhotoAlbum().size());
            alVar.getPhotoAlbum().add(bVar);
            return alVar;
        }
        return alVar;
    }

    private boolean co(List<com.baidu.adp.widget.ListView.v> list) {
        int s = com.baidu.tbadk.core.util.y.s(list);
        if (s == 0) {
            return false;
        }
        for (int i = s - 1; i >= 0; i--) {
            com.baidu.adp.widget.ListView.v vVar = (com.baidu.adp.widget.ListView.v) com.baidu.tbadk.core.util.y.c(list, i);
            if (vVar != null && (vVar instanceof com.baidu.tieba.person.data.b)) {
                return true;
            }
        }
        return false;
    }

    public com.baidu.tieba.person.a.al aMO() {
        return this.equ;
    }

    public void aMP() {
        this.Te.clear();
        if (this.mUserData != null && getIsSelf() && this.mUserData.getUserVipInfo() != null) {
            TbadkCoreApplication.setCurrentMemberType(this.mUserData.getUserVipInfo().getVipStatus());
        }
        com.baidu.tieba.person.data.o oVar = new com.baidu.tieba.person.data.o();
        oVar.setIsSelf(getIsSelf());
        if (this.egw != null) {
            oVar.b(this.egw);
        }
        oVar.f(this.mUserData);
        this.Te.add(oVar);
        if (this.chd || aMR()) {
            this.eqi = aMM();
            this.Te.add(this.eqi);
        }
        if (TbadkCoreApplication.isLogin() && this.chd && this.mUserData.membershipInfo != null && !StringUtils.isNull(this.mUserData.membershipInfo.mTitle) && !StringUtils.isNull(this.mUserData.membershipInfo.mLink)) {
            this.eqf = new com.baidu.tieba.person.data.n();
            this.eqf.mContent = this.mUserData.membershipInfo.mContent;
            this.eqf.mVipIcon = this.mUserData.membershipInfo.mVipIcon;
            this.eqf.mLink = this.mUserData.membershipInfo.mLink;
            this.eqf.mTitle = this.mUserData.membershipInfo.mTitle;
            this.eqf.chd = this.chd;
            this.eqf.mUserData = this.mUserData;
            this.Te.add(this.eqf);
        }
        if (this.window != null && EcommSwitchStatic.Fq()) {
            this.eqt = new com.baidu.tieba.person.data.v(2);
            this.eqt.chd = this.chd;
            this.eqt.mUserData = this.mUserData;
            this.eqt.window = this.window;
            this.eqt.Te = this.Te;
            this.eqt.aDA();
        }
        if (this.chd && this.ucCardData != null) {
            this.eqq = new com.baidu.tieba.person.data.t();
            this.eqq.setName(this.ucCardData.name);
            this.eqq.oc(this.ucCardData.efw);
            this.eqq.setIcon(this.ucCardData.icon);
            this.eqq.ob(this.ucCardData.efv);
            boolean appResponseToIntentClass = TbadkCoreApplication.m9getInst().appResponseToIntentClass(EcommPersonManagerActivityConfig.class);
            if (this.ucCardData.efx != null && (!EcommSwitchStatic.Fq() || !appResponseToIntentClass)) {
                Iterator<bs.a> it = this.ucCardData.efx.iterator();
                while (it.hasNext()) {
                    bs.a next = it.next();
                    if (next != null && next.title.equals(this.eqv.getResources().getString(u.j.ecomm_my_shop))) {
                        it.remove();
                    }
                }
            }
            this.eqq.ck(this.ucCardData.efx);
            this.Te.add(this.eqq);
        }
        if (this.chd && !aMR() && aMI() && com.baidu.adp.lib.c.e.cT().Z("ios_friends_states") == 1) {
            this.eqo = new com.baidu.tieba.person.data.i();
            this.eqo.ehK = false;
            this.eqc = true;
            this.Te.add(this.eqo);
        }
        if (this.chd && aMJ() && com.baidu.adp.lib.c.e.cT().Z("mygroup_states") == 1) {
            this.eqp = new com.baidu.tieba.person.data.h();
            this.eqp.ehJ = false;
            if (this.eqo == null) {
                this.eqp.ehJ = true;
                this.eqb = true;
            }
            this.eqp.ehK = false;
            this.Te.add(this.eqp);
        }
        if (aKR()) {
            this.eql = new com.baidu.tieba.person.data.j();
            this.eql.f(this.mUserData);
            this.eql.setIsSelf(getIsSelf());
            if (aMS()) {
                this.eql.ij(true);
            } else {
                this.eql.ij(false);
            }
            this.Te.add(this.eql);
        }
        if (com.baidu.tbadk.plugins.d.Fk()) {
            if (this.chd) {
                this.eqr = new com.baidu.tieba.person.data.q();
                this.eqr.ehK = false;
                this.Te.add(this.eqr);
            } else if (this.highlist != null && this.highlist.list != null && this.highlist.list.size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < this.highlist.list.size() && i != 4; i++) {
                    arrayList.add(this.highlist.list.get(i));
                }
                this.eqs = new com.baidu.tieba.person.data.s();
                this.eqs.oa(this.mUserData.getUserId());
                this.eqs.setSex(this.mUserData.getSex());
                this.eqs.cj(arrayList);
                this.eqs.setHasMore(this.highlist.has_more.booleanValue());
                this.Te.add(this.eqs);
            }
        }
        if (!aMS()) {
            this.equ = aMN();
            this.Te.add(this.equ);
        }
        if (!this.chd && this.mUserData != null && !aMS() && aMK()) {
            this.eqn = new com.baidu.tieba.person.data.f();
            this.eqn.ehU = this.mUserData.getFansNum();
            this.eqn.sex = this.mUserData.getSex();
            this.eqn.isSelf = this.chd;
            this.eqn.userId = this.mUserData.getUserId();
            this.Te.add(this.eqn);
            this.eqm = new com.baidu.tieba.person.data.c();
            this.eqm.ehO = this.mUserData.getConcernNum();
            this.eqm.isSelf = this.chd;
            this.eqm.userId = this.mUserData.getUserId();
            this.eqm.sex = this.mUserData.getSex();
            this.Te.add(this.eqm);
        }
        if (!aMS()) {
            this.eqj = new com.baidu.tieba.person.data.p();
            this.eqj.setIsSelf(getIsSelf());
            this.eqj.f(this.mUserData);
            this.eqj.a(aMy());
            this.eqj.d(this.egz);
            if (com.baidu.tbadk.core.util.y.s(this.egz) <= 0) {
                this.eqj.ehK = false;
            }
            this.Te.add(this.eqj);
        }
        if (aMT()) {
            List<ThreadInfo> godThreadList = this.eip.getGodThreadList();
            com.baidu.tieba.person.data.k kVar = new com.baidu.tieba.person.data.k();
            kVar.title = TbadkCoreApplication.m9getInst().getString(u.j.group_title_god);
            kVar.eid = Math.max(com.baidu.adp.lib.h.b.c(this.eip.getTotalThread(), 0L), godThreadList.size());
            this.Te.add(kVar);
            if (com.baidu.tbadk.core.util.y.s(godThreadList) > 0) {
                List<ThreadInfo> subList = godThreadList.subList(0, Math.min(godThreadList.size(), 2));
                this.eqx.clear();
                cp(subList);
            }
        }
        if (getIsSelf() && aMH()) {
            this.eqk = new com.baidu.tieba.person.data.m();
            this.Te.add(this.eqk);
            this.eqk.setUser(this.eqd);
        }
        if (!aMS()) {
            this.eqg = new com.baidu.tieba.person.data.g();
            this.eqg.setSelf(getIsSelf());
            if (this.mUserData != null) {
                this.eqg.setSex(this.mUserData.getSex());
                this.eqg.setCount(this.mUserData.getLike_bars());
                this.eqg.setIsFriend(aMy().getIsFriend());
                this.eqg.setUserId(this.mUserData.getUserId());
                this.eqg.nX(this.mUserData.getPersonPrivate().AL());
                this.eqg.ci(this.mUserData.getLikeForum());
                if (com.baidu.tbadk.core.util.y.s(this.mUserData.getLikeForum()) <= 0) {
                    this.eqg.ehK = false;
                }
            }
            this.Te.add(this.eqg);
        }
        if (aML() && !aMS()) {
            this.eqh = new com.baidu.tieba.person.data.l();
            this.eqh.setIsSelf(getIsSelf());
            this.eqh.f(this.mUserData);
            this.eqh.a(aMy());
            if (com.baidu.tbadk.core.util.y.s(this.mUserData.getGroup()) <= 0) {
                this.eqh.ehK = false;
            }
            this.Te.add(this.eqh);
        }
        if (aMS()) {
            com.baidu.tieba.person.data.k kVar2 = new com.baidu.tieba.person.data.k();
            kVar2.eie = true;
            kVar2.eic = aMV();
            this.Te.add(kVar2);
            this.eqx.clear();
            cp(this.eip.getGodThreadList());
        }
        this.eqw = true;
    }

    public int aMQ() {
        if (getUserData() == null || getUserData().getGodInfo() == null) {
            return 0;
        }
        int intValue = getUserData().getGodInfo().type.intValue();
        return (intValue == 2 || intValue == 1) ? 1 : 0;
    }

    public boolean aMR() {
        return this.eip != null && this.eip.getGodType() == 2;
    }

    public boolean aMS() {
        return aMR() && !this.chd;
    }

    public boolean aMT() {
        return aMR() && this.chd;
    }

    public boolean aMU() {
        if (this.eip == null || this.eip.getGodType() != 2) {
            return false;
        }
        return com.baidu.adp.lib.h.b.c(this.eip.getTotalThread(), 0L) > ((long) this.eip.getGodThreadList().size());
    }

    public int aMV() {
        if (this.eip != null) {
            return this.eip.getCurPage();
        }
        return 0;
    }

    public void b(com.baidu.tbadk.core.data.y yVar) {
        if (yVar != null && this.eqw && this.eqk != null) {
            this.eqk.a(yVar);
            if (this.mLoadDataCallBack != null) {
                this.mLoadDataCallBack.d(1);
            }
        }
    }

    public void cp(List<ThreadInfo> list) {
        if (this.Te != null && com.baidu.tbadk.core.util.y.s(list) > 0) {
            List<com.baidu.tieba.card.a.c> a = com.baidu.tieba.person.god.c.a(list, this.eiE, false);
            this.eqx.addAll(a);
            this.Te.addAll(a);
        }
    }

    public void aMW() {
        if (this.eiE != null && this.mUserData != null && this.eip != null) {
            this.eiE.setFansNum(this.mUserData.getFansNum());
            GodUserData godUserData = new GodUserData();
            godUserData.setType(this.eip.getGodType());
            godUserData.setFollowed(this.mUserData.getHave_attention());
            godUserData.setId(Long.valueOf(com.baidu.adp.lib.h.b.c(this.mUserData.getUserId(), 0L)));
            this.eiE.setGodUserData(godUserData);
        }
    }
}

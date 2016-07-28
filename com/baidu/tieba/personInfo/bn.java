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
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.switchs.EcommSwitchStatic;
import com.baidu.tieba.person.ProfileHttpResponseMessage;
import com.baidu.tieba.person.ProfileRequestMessage;
import com.baidu.tieba.person.ProfileSocketResponseMessage;
import com.baidu.tieba.person.f;
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
public class bn extends com.baidu.adp.base.e<BaseFragmentActivity> {
    private ArrayList<com.baidu.adp.widget.ListView.v> TM;
    private BdUniqueId afi;
    private com.baidu.tbadk.coreExtra.d.a bkQ;
    private boolean cjo;
    private CustomMessageListener dKS;
    private AntiData dYA;
    private boolean eBK;
    private boolean eBL;
    private String eBM;
    private b eBN;
    private User eBO;
    private UserTbVipInfoData eBP;
    private long eBQ;
    private com.baidu.tieba.person.data.m eBR;
    public com.baidu.tieba.person.data.d eBS;
    private com.baidu.tieba.person.data.h eBT;
    private com.baidu.tieba.person.data.k eBU;
    private com.baidu.tieba.person.data.e eBV;
    private com.baidu.tieba.person.data.o eBW;
    private com.baidu.tieba.person.data.l eBX;
    private com.baidu.tieba.person.data.i eBY;
    private com.baidu.tieba.person.data.c eBZ;
    private com.baidu.tieba.person.data.g eCa;
    private com.baidu.tieba.person.data.s eCb;
    private com.baidu.tieba.person.data.p eCc;
    private com.baidu.tieba.person.data.r eCd;
    public com.baidu.tieba.person.data.u eCe;
    private com.baidu.tieba.person.a.aj eCf;
    private BaseFragmentActivity eCg;
    private boolean eCh;
    private List<com.baidu.tieba.card.a.c> eCi;
    private PersonTainInfo eqv;
    private List<PersonInfoPostList> eqy;
    private MetaData esI;
    private PersonUserGodInfo est;
    private Highlist highlist;
    private String mId;
    private String mName;
    private String mNameShow;
    private UserData mUserData;
    private String stType;
    private com.baidu.tieba.person.f ucCardData;
    public DealWindow window;

    public MetaData getAuthor() {
        return this.esI;
    }

    public PersonUserGodInfo aPB() {
        return this.est;
    }

    public ArrayList<com.baidu.adp.widget.ListView.v> getDataList() {
        return this.TM;
    }

    public List<com.baidu.tieba.card.a.c> aPC() {
        return this.eCi;
    }

    public void co(long j) {
        this.eBQ = j;
    }

    public AntiData getAntiData() {
        return this.dYA;
    }

    public void setAntiData(AntiData antiData) {
        this.dYA = antiData;
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public void f(UserData userData) {
        if (userData != null) {
            setName(userData.getUserName());
            oR(userData.getName_show());
        }
        this.mUserData = userData;
    }

    public PersonTainInfo aPD() {
        return this.eqv;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public bn(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.eqy = new ArrayList();
        this.bkQ = new com.baidu.tbadk.coreExtra.d.a(this.mLoadDataCallBack);
        this.TM = new ArrayList<>();
        this.eCh = false;
        this.eCi = new ArrayList();
        this.dKS = new bo(this, CmdConfigCustom.CMD_CACHE_PERSONINFO);
        this.eCg = baseFragmentActivity;
    }

    public boolean getIsSelf() {
        return this.cjo;
    }

    public void setIsSelf(boolean z) {
        this.cjo = z;
    }

    public void iA(boolean z) {
        this.eBK = z;
    }

    public void iB(boolean z) {
        this.eBL = z;
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

    public void oR(String str) {
        this.mNameShow = str;
    }

    public String getStType() {
        return this.stType;
    }

    public void setStType(String str) {
        this.stType = str;
    }

    public String aPE() {
        return this.eBM;
    }

    public void oS(String str) {
        this.eBM = str;
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.afi = bdUniqueId;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public void aPF() {
        if (this.mUserData != null && this.bkQ != null && this.mUserData.getUserId() != null) {
            if (this.mUserData.getHave_attention() != 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10609").ab("obj_id", this.mUserData.getUserId()).s("obj_param1", aPT()));
            } else {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10610").ab("obj_id", this.mUserData.getUserId()).s("obj_param1", aPT()));
            }
            this.bkQ.a(this.mUserData.getHave_attention() != 1, this.mUserData.getPortrait(), this.mUserData.getUserId(), aPU(), this.afi);
        }
    }

    public void aPG() {
        MessageManager.getInstance().unRegisterListener(this.dKS);
    }

    public void aDa() {
        com.baidu.tbadk.task.a aVar = new com.baidu.tbadk.task.a(CmdConfigCustom.CMD_CACHE_PERSONINFO, new bp());
        aVar.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(aVar);
        this.dKS.setSelfListener(true);
        this.dKS.setTag(getUniqueId());
        registerListener(this.dKS);
    }

    public void aPH() {
        sendMessage(new RequestPersonInfoMessage());
    }

    public void aPI() {
        if (!com.baidu.adp.lib.util.i.fq()) {
            this.mLoadDataCallBack.g(0);
        } else if (TbadkCoreApplication.isLogin() || (this.eCg instanceof PersonInfoActivity)) {
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
            if (aPE() != null) {
                try {
                    profileRequestMessage.set_st_type(aPE());
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
                com.baidu.tbadk.getUserInfo.b.CH().a(this.mUserData);
                TbadkCoreApplication.m10getInst();
                if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                    TbadkCoreApplication.m10getInst();
                    TbadkCoreApplication.getCurrentAccountInfo().setGodType(this.est.getGodType());
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
            aPS();
            this.mLoadDataCallBack.g(1);
            return;
        }
        if (z3) {
            setErrorString(str);
        }
        this.mLoadDataCallBack.g(0);
    }

    public void b(ProfileHttpResponseMessage profileHttpResponseMessage) {
        if (profileHttpResponseMessage != null) {
            try {
                if (this.mUserData == null) {
                    this.mUserData = new UserData();
                }
                this.mUserData.parserProtobuf(profileHttpResponseMessage.GetUser());
                this.eBO = profileHttpResponseMessage.GetUser();
                if (this.eqv == null) {
                    this.eqv = new PersonTainInfo();
                }
                this.eqv.parseProto(profileHttpResponseMessage.GetTainfo());
                if (this.est == null) {
                    this.est = new PersonUserGodInfo();
                }
                this.est.parserProtobuf(profileHttpResponseMessage.getUserGodInfo());
                if (this.esI == null) {
                    this.esI = new MetaData();
                }
                this.esI.parserProtobuf(this.eBO);
                if (this.dYA == null) {
                    this.dYA = new AntiData();
                }
                this.dYA.parserProtobuf(profileHttpResponseMessage.GetAntiStat());
                this.dYA.setUser_id(this.mUserData.getUserId());
                this.dYA.setUser_name(this.mUserData.getUserName());
                this.ucCardData = profileHttpResponseMessage.ucCardData;
                if (profileHttpResponseMessage.bookrack != null) {
                    this.eBN = new b();
                    this.eBN.a(profileHttpResponseMessage.bookrack);
                }
                this.eqy.clear();
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
                        this.eqy.add(personInfoPostList);
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
                this.eBO = profileSocketResponseMessage.GetUser();
                if (this.eqv == null) {
                    this.eqv = new PersonTainInfo();
                }
                this.eqv.parseProto(profileSocketResponseMessage.GetTainfo());
                if (this.est == null) {
                    this.est = new PersonUserGodInfo();
                }
                this.est.parserProtobuf(profileSocketResponseMessage.getUserGodInfo());
                if (this.esI == null) {
                    this.esI = new MetaData();
                }
                this.esI.parserProtobuf(this.eBO);
                if (this.dYA == null) {
                    this.dYA = new AntiData();
                }
                this.dYA.parserProtobuf(profileSocketResponseMessage.GetAntiStat());
                this.dYA.setUser_id(this.mUserData.getUserId());
                this.dYA.setUser_name(this.mUserData.getUserName());
                this.ucCardData = profileSocketResponseMessage.ucCardData;
                if (profileSocketResponseMessage.bookrack != null) {
                    this.eBN = new b();
                    this.eBN.a(profileSocketResponseMessage.bookrack);
                }
                this.eqy.clear();
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
                        this.eqy.add(personInfoPostList);
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

    private boolean aPJ() {
        return TbadkCoreApplication.m10getInst().appResponseToIntentClass(AddressListActivityConfig.class);
    }

    private boolean aPK() {
        return TbadkCoreApplication.m10getInst().appResponseToCmd(CmdConfigCustom.START_EDITMARK);
    }

    private boolean aPL() {
        return TbadkCoreApplication.m10getInst().appResponseToIntentClass(PbHistoryActivityConfig.class);
    }

    private boolean aPM() {
        return TbadkCoreApplication.m10getInst().appResponseToIntentClass(MyLiveActivityConfig.class);
    }

    private boolean aNu() {
        return TbadkCoreApplication.m10getInst().appResponseToIntentClass(MyGiftListActivityConfig.class);
    }

    private boolean aPN() {
        return TbadkCoreApplication.m10getInst().appResponseToIntentClass(PersonListActivityConfig.class);
    }

    private boolean aPO() {
        return TbadkCoreApplication.m10getInst().appResponseToIntentClass(GroupActivityActivityConfig.class) && TbadkCoreApplication.m10getInst().appResponseToIntentClass(PersonGroupActivityConfig.class);
    }

    public com.baidu.tieba.person.data.e aPP() {
        com.baidu.tieba.person.data.e eVar = new com.baidu.tieba.person.data.e();
        if (aPL()) {
            eVar.erW.add(new com.baidu.tieba.person.data.f(2));
        }
        if (aPK()) {
            eVar.erW.add(new com.baidu.tieba.person.data.f(1));
        }
        if (!aPU() && aPN()) {
            eVar.erW.add(new com.baidu.tieba.person.data.f(4));
            eVar.erW.add(new com.baidu.tieba.person.data.f(3));
        }
        if (aPJ()) {
            eVar.erW.add(new com.baidu.tieba.person.data.f(0));
        }
        return eVar;
    }

    private com.baidu.tieba.person.a.aj aPQ() {
        if (this.mUserData == null) {
            return null;
        }
        com.baidu.tieba.person.a.aj ajVar = new com.baidu.tieba.person.a.aj();
        ajVar.setSelf(this.cjo);
        ajVar.setPhotoAlbum(this.mUserData.getPhotoAlbum());
        if (this.cjo && this.mUserData.getPhotoAlbum() != null && !cA(this.mUserData.getPhotoAlbum()) && this.mUserData.getPhotoAlbum().size() < 9) {
            com.baidu.tieba.person.data.b bVar = new com.baidu.tieba.person.data.b();
            bVar.og(9 - this.mUserData.getPhotoAlbum().size());
            ajVar.getPhotoAlbum().add(bVar);
            return ajVar;
        }
        return ajVar;
    }

    private boolean cA(List<com.baidu.adp.widget.ListView.v> list) {
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

    public com.baidu.tieba.person.a.aj aPR() {
        return this.eCf;
    }

    public void aPS() {
        this.TM.clear();
        if (this.mUserData != null && getIsSelf() && this.mUserData.getUserVipInfo() != null) {
            TbadkCoreApplication.setCurrentMemberType(this.mUserData.getUserVipInfo().getVipStatus());
        }
        com.baidu.tieba.person.data.n nVar = new com.baidu.tieba.person.data.n();
        nVar.setIsSelf(getIsSelf());
        if (this.eqv != null) {
            nVar.b(this.eqv);
        }
        nVar.f(this.mUserData);
        this.TM.add(nVar);
        if (this.cjo || aPU()) {
            this.eBV = aPP();
            this.TM.add(this.eBV);
        }
        if (TbadkCoreApplication.isLogin() && this.cjo && this.mUserData.membershipInfo != null && !StringUtils.isNull(this.mUserData.membershipInfo.mTitle) && !StringUtils.isNull(this.mUserData.membershipInfo.mLink)) {
            this.eBR = new com.baidu.tieba.person.data.m();
            this.eBR.mContent = this.mUserData.membershipInfo.mContent;
            this.eBR.mVipIcon = this.mUserData.membershipInfo.mVipIcon;
            this.eBR.mLink = this.mUserData.membershipInfo.mLink;
            this.eBR.mTitle = this.mUserData.membershipInfo.mTitle;
            this.eBR.cjo = this.cjo;
            this.eBR.mUserData = this.mUserData;
            this.TM.add(this.eBR);
        }
        if (this.cjo && this.eBN != null) {
            this.eBS = new com.baidu.tieba.person.data.d(this.cjo, this.eBN);
            this.TM.add(this.eBS);
        }
        if (this.window != null && EcommSwitchStatic.Fr()) {
            if (this.cjo) {
                this.eCe = new com.baidu.tieba.person.data.u(2);
                this.eCe.cjo = this.cjo;
                this.eCe.mUserData = this.mUserData;
                this.eCe.window = this.window;
                this.eCe.TM = this.TM;
                this.eCe.aGK();
            } else if (this.window.list != null && this.window.list.size() > 0) {
                this.eCe = new com.baidu.tieba.person.data.u(2);
                this.eCe.cjo = this.cjo;
                this.eCe.mUserData = this.mUserData;
                this.eCe.window = this.window;
                this.eCe.TM = this.TM;
                this.eCe.aGK();
            }
        }
        if (this.cjo && this.ucCardData != null) {
            this.eCb = new com.baidu.tieba.person.data.s();
            this.eCb.setName(this.ucCardData.name);
            this.eCb.oK(this.ucCardData.epw);
            this.eCb.setIcon(this.ucCardData.icon);
            this.eCb.oJ(this.ucCardData.epv);
            boolean appResponseToIntentClass = TbadkCoreApplication.m10getInst().appResponseToIntentClass(EcommPersonManagerActivityConfig.class);
            if (this.ucCardData.epx != null && (!EcommSwitchStatic.Fr() || !appResponseToIntentClass)) {
                Iterator<f.a> it = this.ucCardData.epx.iterator();
                while (it.hasNext()) {
                    f.a next = it.next();
                    if (next != null && next.title.equals(this.eCg.getResources().getString(u.j.ecomm_my_shop))) {
                        it.remove();
                    }
                }
            }
            this.eCb.cx(this.ucCardData.epx);
            this.TM.add(this.eCb);
        }
        if (aNu()) {
            this.eBY = new com.baidu.tieba.person.data.i();
            this.eBY.f(this.mUserData);
            this.eBY.setIsSelf(getIsSelf());
            if (aPV()) {
                this.eBY.is(true);
            } else {
                this.eBY.is(false);
            }
            this.TM.add(this.eBY);
        }
        if (com.baidu.tbadk.plugins.g.Fl()) {
            if (this.cjo) {
                this.eCc = new com.baidu.tieba.person.data.p();
                this.eCc.erJ = false;
                this.TM.add(this.eCc);
            } else if (this.highlist != null && this.highlist.list != null && this.highlist.list.size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < this.highlist.list.size() && i != 4; i++) {
                    arrayList.add(this.highlist.list.get(i));
                }
                this.eCd = new com.baidu.tieba.person.data.r();
                this.eCd.oI(this.mUserData.getUserId());
                this.eCd.setSex(this.mUserData.getSex());
                this.eCd.cw(arrayList);
                this.eCd.setHasMore(this.highlist.has_more.booleanValue());
                this.TM.add(this.eCd);
            }
        }
        if (!aPV()) {
            this.eCf = aPQ();
            this.TM.add(this.eCf);
        }
        if (!this.cjo && this.mUserData != null && !aPV() && aPN()) {
            this.eCa = new com.baidu.tieba.person.data.g();
            this.eCa.esa = this.mUserData.getFansNum();
            this.eCa.sex = this.mUserData.getSex();
            this.eCa.isSelf = this.cjo;
            this.eCa.userId = this.mUserData.getUserId();
            this.TM.add(this.eCa);
            this.eBZ = new com.baidu.tieba.person.data.c();
            this.eBZ.erN = this.mUserData.getConcernNum();
            this.eBZ.isSelf = this.cjo;
            this.eBZ.userId = this.mUserData.getUserId();
            this.eBZ.sex = this.mUserData.getSex();
            this.TM.add(this.eBZ);
        }
        if (!aPV()) {
            this.eBW = new com.baidu.tieba.person.data.o();
            this.eBW.setIsSelf(getIsSelf());
            this.eBW.f(this.mUserData);
            this.eBW.a(aPD());
            this.eBW.d(this.eqy);
            if (com.baidu.tbadk.core.util.y.s(this.eqy) <= 0) {
                this.eBW.erJ = false;
            }
            this.TM.add(this.eBW);
        }
        if (aPW()) {
            List<ThreadInfo> godThreadList = this.est.getGodThreadList();
            com.baidu.tieba.person.data.j jVar = new com.baidu.tieba.person.data.j();
            jVar.title = TbadkCoreApplication.m10getInst().getString(u.j.group_title_god);
            jVar.esh = Math.max(com.baidu.adp.lib.h.b.c(this.est.getTotalThread(), 0L), godThreadList.size());
            this.TM.add(jVar);
            if (com.baidu.tbadk.core.util.y.s(godThreadList) > 0) {
                List<ThreadInfo> subList = godThreadList.subList(0, Math.min(godThreadList.size(), 2));
                this.eCi.clear();
                cB(subList);
            }
        }
        if (getIsSelf() && aPM()) {
            this.eBX = new com.baidu.tieba.person.data.l();
            this.TM.add(this.eBX);
            this.eBX.setUser(this.eBO);
        }
        if (!aPV()) {
            this.eBT = new com.baidu.tieba.person.data.h();
            this.eBT.setSelf(getIsSelf());
            if (this.mUserData != null) {
                this.eBT.setSex(this.mUserData.getSex());
                this.eBT.setCount(this.mUserData.getLike_bars());
                this.eBT.setIsFriend(aPD().getIsFriend());
                this.eBT.setUserId(this.mUserData.getUserId());
                this.eBT.oi(this.mUserData.getPersonPrivate().AL());
                this.eBT.cv(this.mUserData.getLikeForum());
                if (com.baidu.tbadk.core.util.y.s(this.mUserData.getLikeForum()) <= 0) {
                    this.eBT.erJ = false;
                }
            }
            this.TM.add(this.eBT);
        }
        if (aPO() && !aPV()) {
            this.eBU = new com.baidu.tieba.person.data.k();
            this.eBU.setIsSelf(getIsSelf());
            this.eBU.f(this.mUserData);
            this.eBU.a(aPD());
            if (com.baidu.tbadk.core.util.y.s(this.mUserData.getGroup()) <= 0) {
                this.eBU.erJ = false;
            }
            this.TM.add(this.eBU);
        }
        if (aPV()) {
            com.baidu.tieba.person.data.j jVar2 = new com.baidu.tieba.person.data.j();
            jVar2.esi = true;
            jVar2.esg = aPY();
            this.TM.add(jVar2);
            this.eCi.clear();
            cB(this.est.getGodThreadList());
        }
        this.eCh = true;
    }

    public int aPT() {
        if (getUserData() == null || getUserData().getGodInfo() == null) {
            return 0;
        }
        int intValue = getUserData().getGodInfo().type.intValue();
        return (intValue == 2 || intValue == 1) ? 1 : 0;
    }

    public boolean aPU() {
        return this.est != null && this.est.getGodType() == 2;
    }

    public boolean aPV() {
        return aPU() && !this.cjo;
    }

    public boolean aPW() {
        return aPU() && this.cjo;
    }

    public boolean aPX() {
        if (this.est == null || this.est.getGodType() != 2) {
            return false;
        }
        return com.baidu.adp.lib.h.b.c(this.est.getTotalThread(), 0L) > ((long) this.est.getGodThreadList().size());
    }

    public int aPY() {
        if (this.est != null) {
            return this.est.getCurPage();
        }
        return 0;
    }

    public void b(com.baidu.tbadk.core.data.ab abVar) {
        if (abVar != null && this.eCh && this.eBX != null) {
            this.eBX.a(abVar);
            if (this.mLoadDataCallBack != null) {
                this.mLoadDataCallBack.g(1);
            }
        }
    }

    public void cB(List<ThreadInfo> list) {
        if (this.TM != null && com.baidu.tbadk.core.util.y.s(list) > 0) {
            List<com.baidu.tieba.card.a.c> a = com.baidu.tieba.person.god.c.a(list, this.esI, false);
            this.eCi.addAll(a);
            this.TM.addAll(a);
        }
    }

    public void aPZ() {
        if (this.esI != null && this.mUserData != null && this.est != null) {
            this.esI.setFansNum(this.mUserData.getFansNum());
            GodUserData godUserData = new GodUserData();
            godUserData.setType(this.est.getGodType());
            godUserData.setFollowed(this.mUserData.getHave_attention());
            godUserData.setId(Long.valueOf(com.baidu.adp.lib.h.b.c(this.mUserData.getUserId(), 0L)));
            UserTbVipInfoData userTbVipInfoData = new UserTbVipInfoData();
            if (this.eBP != null) {
                userTbVipInfoData.setVipIntro(this.eBP.getvipIntro());
                userTbVipInfoData.setVipV_detail(this.eBP.getvipV_detail());
                userTbVipInfoData.setVipV_url(this.eBP.getvipV_url());
            }
            this.esI.setGodUserData(godUserData);
            this.esI.setTbVipInfoData(userTbVipInfoData);
        }
    }
}

package com.baidu.tieba.personInfo;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tieba.person.ProfileHttpResponseMessage;
import com.baidu.tieba.person.ProfileRequestMessage;
import com.baidu.tieba.person.ProfileSocketResponseMessage;
import java.util.ArrayList;
import java.util.List;
import tbclient.PostInfoList;
/* loaded from: classes.dex */
public class v extends com.baidu.adp.base.f<PersonInfoActivity> {
    private CustomMessageListener bIE;
    private boolean bLr;
    private boolean bLs;
    private String bLt;
    private AntiData bLu;
    private List<PersonInfoPostList> bLv;
    private PersonTainInfo bLw;
    private com.baidu.tbadk.coreExtra.c.a bLx;
    private long bLy;
    private int bLz;
    private boolean bze;
    private String mId;
    private String mName;
    private UserData mUserData;
    private String stType;

    public long abS() {
        return this.bLy;
    }

    public void ai(long j) {
        this.bLy = j;
    }

    public void hv(int i) {
        this.bLz = i;
    }

    public AntiData abT() {
        return this.bLu;
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public void l(UserData userData) {
        this.mUserData = userData;
    }

    public List<PersonInfoPostList> abU() {
        return this.bLv;
    }

    public PersonTainInfo abV() {
        return this.bLw;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public v(PersonInfoActivity personInfoActivity) {
        super(personInfoActivity.getPageContext());
        this.bLv = new ArrayList();
        this.bLx = new com.baidu.tbadk.coreExtra.c.a(this.mLoadDataCallBack);
        this.bIE = new w(this, 2001235);
    }

    public boolean getIsSelf() {
        return this.bze;
    }

    public void setIsSelf(boolean z) {
        this.bze = z;
    }

    public boolean abW() {
        return this.bLr;
    }

    public void el(boolean z) {
        this.bLr = z;
    }

    public boolean abX() {
        return this.bLs;
    }

    public void em(boolean z) {
        this.bLs = z;
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

    public String getStType() {
        return this.stType;
    }

    public void setStType(String str) {
        this.stType = str;
    }

    public String abY() {
        return this.bLt;
    }

    public void hP(String str) {
        this.bLt = str;
    }

    public void b(PersonChangeData personChangeData) {
        this.mUserData.setSex(personChangeData.getSex());
        this.mUserData.setUserName(personChangeData.getName());
        this.mUserData.setIntro(personChangeData.getIntro());
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        return false;
    }

    public void abZ() {
        if (this.mUserData != null && this.bLx != null) {
            this.bLx.a(this.mUserData.getHave_attention() != 1, this.mUserData.getPortrait(), this.mUserData.getUserId());
        }
    }

    public void aca() {
        MessageManager.getInstance().unRegisterListener(this.bIE);
    }

    public void abe() {
        com.baidu.tbadk.task.a aVar = new com.baidu.tbadk.task.a(2001235, new y());
        aVar.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(aVar);
        registerListener(this.bIE);
    }

    public void acb() {
        sendMessage(new RequestPersonInfoMessage());
    }

    public void acc() {
        ProfileRequestMessage profileRequestMessage = new ProfileRequestMessage();
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            profileRequestMessage.set_uid(Integer.valueOf(com.baidu.adp.lib.g.c.toInt(TbadkCoreApplication.getCurrentAccount(), 0)));
        }
        profileRequestMessage.set_need_post_count(1);
        profileRequestMessage.set_pn(1);
        profileRequestMessage.set_rn(20);
        profileRequestMessage.set_has_plist(1);
        profileRequestMessage.set_from_db(false);
        profileRequestMessage.set_error_hint(true);
        profileRequestMessage.setSelf(getIsSelf());
        if (!getIsSelf()) {
            profileRequestMessage.set_friend_uid(Long.valueOf(com.baidu.adp.lib.g.c.a(getId(), 0L)));
            profileRequestMessage.set_is_guest(1);
        }
        if (abY() != null) {
            try {
                profileRequestMessage.set_st_type(abY());
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
                com.baidu.tbadk.getUserInfo.b.vS().a(this.mUserData);
            }
            UserData userData = this.mUserData;
            if (userData != null) {
                l(userData);
            }
            AntiData abT = abT();
            if (abT != null) {
                this.bLu = abT;
            }
            this.mLoadDataCallBack.c(true);
            return;
        }
        if (z3) {
            setErrorString(str);
        }
        this.mLoadDataCallBack.c(false);
    }

    public void b(ProfileHttpResponseMessage profileHttpResponseMessage) {
        if (profileHttpResponseMessage != null) {
            try {
                if (this.mUserData == null) {
                    this.mUserData = new UserData();
                }
                this.mUserData.parserProtobuf(profileHttpResponseMessage.GetUser());
                if (this.bLw == null) {
                    this.bLw = new PersonTainInfo();
                }
                this.bLw.parseProto(profileHttpResponseMessage.GetTainfo());
                if (this.bLu == null) {
                    this.bLu = new AntiData();
                }
                this.bLu.parserProtobuf(profileHttpResponseMessage.GetAntiStat());
                this.bLv.clear();
                List<PostInfoList> GetPostList = profileHttpResponseMessage.GetPostList();
                if (GetPostList != null) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < GetPostList.size()) {
                            PersonInfoPostList personInfoPostList = new PersonInfoPostList();
                            personInfoPostList.parseProto(GetPostList.get(i2));
                            this.bLv.add(personInfoPostList);
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
                if (this.bLw == null) {
                    this.bLw = new PersonTainInfo();
                }
                this.bLw.parseProto(profileSocketResponseMessage.GetTainfo());
                if (this.bLu == null) {
                    this.bLu = new AntiData();
                }
                this.bLu.parserProtobuf(profileSocketResponseMessage.GetAntiStat());
                this.bLv.clear();
                List<PostInfoList> GetPostList = profileSocketResponseMessage.GetPostList();
                if (GetPostList != null) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < GetPostList.size()) {
                            PersonInfoPostList personInfoPostList = new PersonInfoPostList();
                            personInfoPostList.parseProto(GetPostList.get(i2));
                            this.bLv.add(personInfoPostList);
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
}

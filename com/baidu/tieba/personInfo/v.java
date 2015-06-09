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
    private boolean aYg;
    private AntiData bJV;
    private CustomMessageListener bTH;
    private boolean bWA;
    private String bWB;
    private List<PersonInfoPostList> bWC;
    private PersonTainInfo bWD;
    private com.baidu.tbadk.coreExtra.c.a bWE;
    private long bWF;
    private int bWG;
    private boolean bWz;
    private String mId;
    private String mName;
    private UserData mUserData;
    private String stType;

    public long afw() {
        return this.bWF;
    }

    public void am(long j) {
        this.bWF = j;
    }

    public void hW(int i) {
        this.bWG = i;
    }

    public AntiData aaH() {
        return this.bJV;
    }

    public void a(AntiData antiData) {
        this.bJV = antiData;
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public void k(UserData userData) {
        if (userData != null) {
            setName(userData.getUserName());
        }
        this.mUserData = userData;
    }

    public List<PersonInfoPostList> afx() {
        return this.bWC;
    }

    public PersonTainInfo afy() {
        return this.bWD;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public v(PersonInfoActivity personInfoActivity) {
        super(personInfoActivity.getPageContext());
        this.bWC = new ArrayList();
        this.bWE = new com.baidu.tbadk.coreExtra.c.a(this.mLoadDataCallBack);
        this.bTH = new w(this, 2001235);
    }

    public boolean getIsSelf() {
        return this.aYg;
    }

    public void setIsSelf(boolean z) {
        this.aYg = z;
    }

    public boolean afz() {
        return this.bWz;
    }

    public void es(boolean z) {
        this.bWz = z;
    }

    public boolean afA() {
        return this.bWA;
    }

    public void et(boolean z) {
        this.bWA = z;
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

    public String afB() {
        return this.bWB;
    }

    public void iH(String str) {
        this.bWB = str;
    }

    public void a(PersonChangeData personChangeData) {
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

    public void afC() {
        if (this.mUserData != null && this.bWE != null) {
            this.bWE.a(this.mUserData.getHave_attention() != 1, this.mUserData.getPortrait(), this.mUserData.getUserId());
        }
    }

    public void afD() {
        MessageManager.getInstance().unRegisterListener(this.bTH);
    }

    public void aeH() {
        com.baidu.tbadk.task.a aVar = new com.baidu.tbadk.task.a(2001235, new y());
        aVar.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(aVar);
        registerListener(this.bTH);
    }

    public void afE() {
        sendMessage(new RequestPersonInfoMessage());
    }

    public void afF() {
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
            profileRequestMessage.set_friend_uid(Long.valueOf(com.baidu.adp.lib.g.c.c(getId(), 0L)));
            profileRequestMessage.set_is_guest(1);
        }
        if (afB() != null) {
            try {
                profileRequestMessage.set_st_type(afB());
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
                com.baidu.tbadk.getUserInfo.b.Ag().a(this.mUserData);
            }
            UserData userData = this.mUserData;
            if (userData != null) {
                k(userData);
            }
            AntiData aaH = aaH();
            if (aaH != null) {
                a(aaH);
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
                if (this.bWD == null) {
                    this.bWD = new PersonTainInfo();
                }
                this.bWD.parseProto(profileHttpResponseMessage.GetTainfo());
                if (this.bJV == null) {
                    this.bJV = new AntiData();
                }
                this.bJV.parserProtobuf(profileHttpResponseMessage.GetAntiStat());
                this.bJV.setUser_id(this.mUserData.getUserId());
                this.bJV.setUser_name(this.mUserData.getUserName());
                this.bWC.clear();
                List<PostInfoList> GetPostList = profileHttpResponseMessage.GetPostList();
                if (GetPostList != null) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < GetPostList.size()) {
                            PersonInfoPostList personInfoPostList = new PersonInfoPostList();
                            personInfoPostList.parseProto(GetPostList.get(i2));
                            this.bWC.add(personInfoPostList);
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
                if (this.bWD == null) {
                    this.bWD = new PersonTainInfo();
                }
                this.bWD.parseProto(profileSocketResponseMessage.GetTainfo());
                if (this.bJV == null) {
                    this.bJV = new AntiData();
                }
                this.bJV.parserProtobuf(profileSocketResponseMessage.GetAntiStat());
                this.bJV.setUser_id(this.mUserData.getUserId());
                this.bJV.setUser_name(this.mUserData.getUserName());
                this.bWC.clear();
                List<PostInfoList> GetPostList = profileSocketResponseMessage.GetPostList();
                if (GetPostList != null) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < GetPostList.size()) {
                            PersonInfoPostList personInfoPostList = new PersonInfoPostList();
                            personInfoPostList.parseProto(GetPostList.get(i2));
                            this.bWC.add(personInfoPostList);
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

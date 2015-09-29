package com.baidu.tieba.personInfo;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tieba.person.ProfileHttpResponseMessage;
import com.baidu.tieba.person.ProfileRequestMessage;
import com.baidu.tieba.person.ProfileSocketResponseMessage;
import java.util.ArrayList;
import java.util.List;
import tbclient.PostInfoList;
/* loaded from: classes.dex */
public class y extends com.baidu.adp.base.e<PersonInfoActivity> {
    private boolean bmZ;
    private AntiData cgo;
    private CustomMessageListener cqO;
    private boolean ctA;
    private String ctB;
    private List<PersonInfoPostList> ctC;
    private PersonTainInfo ctD;
    private com.baidu.tbadk.coreExtra.d.a ctE;
    private long ctF;
    private int ctG;
    private boolean ctz;
    private String mId;
    private String mName;
    private UserData mUserData;
    private String stType;

    public long ajM() {
        return this.ctF;
    }

    public void aJ(long j) {
        this.ctF = j;
    }

    public void jn(int i) {
        this.ctG = i;
    }

    public AntiData afh() {
        return this.cgo;
    }

    public void b(AntiData antiData) {
        this.cgo = antiData;
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public void i(UserData userData) {
        if (userData != null) {
            setName(userData.getUserName());
        }
        this.mUserData = userData;
    }

    public List<PersonInfoPostList> getPostList() {
        return this.ctC;
    }

    public PersonTainInfo ajN() {
        return this.ctD;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public y(PersonInfoActivity personInfoActivity) {
        super(personInfoActivity.getPageContext());
        this.ctC = new ArrayList();
        this.ctE = new com.baidu.tbadk.coreExtra.d.a(this.mLoadDataCallBack);
        this.cqO = new z(this, CmdConfigCustom.CMD_CACHE_PERSONINFO);
    }

    public boolean getIsSelf() {
        return this.bmZ;
    }

    public void setIsSelf(boolean z) {
        this.bmZ = z;
    }

    public boolean ajO() {
        return this.ctz;
    }

    public void fb(boolean z) {
        this.ctz = z;
    }

    public boolean ajP() {
        return this.ctA;
    }

    public void fc(boolean z) {
        this.ctA = z;
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

    public String ajQ() {
        return this.ctB;
    }

    public void kd(String str) {
        this.ctB = str;
    }

    public void a(PersonChangeData personChangeData) {
        this.mUserData.setSex(personChangeData.getSex());
        this.mUserData.setUserName(personChangeData.getName());
        this.mUserData.setIntro(personChangeData.getIntro());
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public void ajR() {
        if (this.mUserData != null && this.ctE != null) {
            this.ctE.a(this.mUserData.getHave_attention() != 1, this.mUserData.getPortrait(), this.mUserData.getUserId());
        }
    }

    public void ajS() {
        MessageManager.getInstance().unRegisterListener(this.cqO);
    }

    public void aiP() {
        com.baidu.tbadk.task.a aVar = new com.baidu.tbadk.task.a(CmdConfigCustom.CMD_CACHE_PERSONINFO, new ac());
        aVar.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(aVar);
        registerListener(this.cqO);
    }

    public void ajT() {
        sendMessage(new RequestPersonInfoMessage());
    }

    public void ajU() {
        ProfileRequestMessage profileRequestMessage = new ProfileRequestMessage();
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            profileRequestMessage.set_uid(Long.valueOf(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L)));
        }
        profileRequestMessage.set_need_post_count(1);
        profileRequestMessage.set_pn(1);
        profileRequestMessage.set_rn(20);
        profileRequestMessage.set_has_plist(1);
        profileRequestMessage.set_from_db(false);
        profileRequestMessage.set_error_hint(true);
        profileRequestMessage.setSelf(getIsSelf());
        if (!getIsSelf()) {
            profileRequestMessage.set_friend_uid(Long.valueOf(com.baidu.adp.lib.g.b.c(getId(), 0L)));
            profileRequestMessage.set_is_guest(1);
        }
        if (ajQ() != null) {
            try {
                profileRequestMessage.set_st_type(ajQ());
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
                com.baidu.tbadk.getUserInfo.b.BY().a(this.mUserData);
            }
            UserData userData = this.mUserData;
            if (userData != null) {
                i(userData);
            }
            AntiData afh = afh();
            if (afh != null) {
                b(afh);
            }
            this.mLoadDataCallBack.d(true);
            return;
        }
        if (z3) {
            setErrorString(str);
        }
        this.mLoadDataCallBack.d(false);
    }

    public void b(ProfileHttpResponseMessage profileHttpResponseMessage) {
        if (profileHttpResponseMessage != null) {
            try {
                if (this.mUserData == null) {
                    this.mUserData = new UserData();
                }
                this.mUserData.parserProtobuf(profileHttpResponseMessage.GetUser());
                if (this.ctD == null) {
                    this.ctD = new PersonTainInfo();
                }
                this.ctD.parseProto(profileHttpResponseMessage.GetTainfo());
                if (this.cgo == null) {
                    this.cgo = new AntiData();
                }
                this.cgo.parserProtobuf(profileHttpResponseMessage.GetAntiStat());
                this.cgo.setUser_id(this.mUserData.getUserId());
                this.cgo.setUser_name(this.mUserData.getUserName());
                this.ctC.clear();
                List<PostInfoList> GetPostList = profileHttpResponseMessage.GetPostList();
                if (GetPostList != null) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < GetPostList.size()) {
                            PersonInfoPostList personInfoPostList = new PersonInfoPostList();
                            personInfoPostList.parseProto(GetPostList.get(i2));
                            this.ctC.add(personInfoPostList);
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
                if (this.ctD == null) {
                    this.ctD = new PersonTainInfo();
                }
                this.ctD.parseProto(profileSocketResponseMessage.GetTainfo());
                if (this.cgo == null) {
                    this.cgo = new AntiData();
                }
                this.cgo.parserProtobuf(profileSocketResponseMessage.GetAntiStat());
                this.cgo.setUser_id(this.mUserData.getUserId());
                this.cgo.setUser_name(this.mUserData.getUserName());
                this.ctC.clear();
                List<PostInfoList> GetPostList = profileSocketResponseMessage.GetPostList();
                if (GetPostList != null) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < GetPostList.size()) {
                            PersonInfoPostList personInfoPostList = new PersonInfoPostList();
                            personInfoPostList.parseProto(GetPostList.get(i2));
                            this.ctC.add(personInfoPostList);
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

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
    private boolean bnk;
    private AntiData cgz;
    private CustomMessageListener cqZ;
    private boolean ctK;
    private boolean ctL;
    private String ctM;
    private List<PersonInfoPostList> ctN;
    private PersonTainInfo ctO;
    private com.baidu.tbadk.coreExtra.d.a ctP;
    private long ctQ;
    private int ctR;
    private String mId;
    private String mName;
    private UserData mUserData;
    private String stType;

    public long ajI() {
        return this.ctQ;
    }

    public void aR(long j) {
        this.ctQ = j;
    }

    public void jn(int i) {
        this.ctR = i;
    }

    public AntiData afd() {
        return this.cgz;
    }

    public void b(AntiData antiData) {
        this.cgz = antiData;
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
        return this.ctN;
    }

    public PersonTainInfo ajJ() {
        return this.ctO;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public y(PersonInfoActivity personInfoActivity) {
        super(personInfoActivity.getPageContext());
        this.ctN = new ArrayList();
        this.ctP = new com.baidu.tbadk.coreExtra.d.a(this.mLoadDataCallBack);
        this.cqZ = new z(this, CmdConfigCustom.CMD_CACHE_PERSONINFO);
    }

    public boolean getIsSelf() {
        return this.bnk;
    }

    public void setIsSelf(boolean z) {
        this.bnk = z;
    }

    public boolean ajK() {
        return this.ctK;
    }

    public void fb(boolean z) {
        this.ctK = z;
    }

    public boolean ajL() {
        return this.ctL;
    }

    public void fc(boolean z) {
        this.ctL = z;
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

    public String ajM() {
        return this.ctM;
    }

    public void kd(String str) {
        this.ctM = str;
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

    public void ajN() {
        if (this.mUserData != null && this.ctP != null) {
            this.ctP.a(this.mUserData.getHave_attention() != 1, this.mUserData.getPortrait(), this.mUserData.getUserId());
        }
    }

    public void ajO() {
        MessageManager.getInstance().unRegisterListener(this.cqZ);
    }

    public void aiL() {
        com.baidu.tbadk.task.a aVar = new com.baidu.tbadk.task.a(CmdConfigCustom.CMD_CACHE_PERSONINFO, new ac());
        aVar.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(aVar);
        registerListener(this.cqZ);
    }

    public void ajP() {
        sendMessage(new RequestPersonInfoMessage());
    }

    public void ajQ() {
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
        if (ajM() != null) {
            try {
                profileRequestMessage.set_st_type(ajM());
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
                com.baidu.tbadk.getUserInfo.b.BV().a(this.mUserData);
            }
            UserData userData = this.mUserData;
            if (userData != null) {
                i(userData);
            }
            AntiData afd = afd();
            if (afd != null) {
                b(afd);
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
                if (this.ctO == null) {
                    this.ctO = new PersonTainInfo();
                }
                this.ctO.parseProto(profileHttpResponseMessage.GetTainfo());
                if (this.cgz == null) {
                    this.cgz = new AntiData();
                }
                this.cgz.parserProtobuf(profileHttpResponseMessage.GetAntiStat());
                this.cgz.setUser_id(this.mUserData.getUserId());
                this.cgz.setUser_name(this.mUserData.getUserName());
                this.ctN.clear();
                List<PostInfoList> GetPostList = profileHttpResponseMessage.GetPostList();
                if (GetPostList != null) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < GetPostList.size()) {
                            PersonInfoPostList personInfoPostList = new PersonInfoPostList();
                            personInfoPostList.parseProto(GetPostList.get(i2));
                            this.ctN.add(personInfoPostList);
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
                if (this.ctO == null) {
                    this.ctO = new PersonTainInfo();
                }
                this.ctO.parseProto(profileSocketResponseMessage.GetTainfo());
                if (this.cgz == null) {
                    this.cgz = new AntiData();
                }
                this.cgz.parserProtobuf(profileSocketResponseMessage.GetAntiStat());
                this.cgz.setUser_id(this.mUserData.getUserId());
                this.cgz.setUser_name(this.mUserData.getUserName());
                this.ctN.clear();
                List<PostInfoList> GetPostList = profileSocketResponseMessage.GetPostList();
                if (GetPostList != null) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < GetPostList.size()) {
                            PersonInfoPostList personInfoPostList = new PersonInfoPostList();
                            personInfoPostList.parseProto(GetPostList.get(i2));
                            this.ctN.add(personInfoPostList);
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

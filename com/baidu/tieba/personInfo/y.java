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
    private boolean bnO;
    private AntiData che;
    private CustomMessageListener csv;
    private boolean cvg;
    private boolean cvh;
    private String cvi;
    private List<PersonInfoPostList> cvj;
    private PersonTainInfo cvk;
    private com.baidu.tbadk.coreExtra.d.a cvl;
    private long cvm;
    private int cvn;
    private String mId;
    private String mName;
    private String mNameShow;
    private UserData mUserData;
    private String stType;

    public long ako() {
        return this.cvm;
    }

    public void aR(long j) {
        this.cvm = j;
    }

    public void jB(int i) {
        this.cvn = i;
    }

    public AntiData afA() {
        return this.che;
    }

    public void b(AntiData antiData) {
        this.che = antiData;
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public void i(UserData userData) {
        if (userData != null) {
            setName(userData.getUserName());
            kg(userData.getName_show());
        }
        this.mUserData = userData;
    }

    public List<PersonInfoPostList> getPostList() {
        return this.cvj;
    }

    public PersonTainInfo akp() {
        return this.cvk;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public y(PersonInfoActivity personInfoActivity) {
        super(personInfoActivity.getPageContext());
        this.cvj = new ArrayList();
        this.cvl = new com.baidu.tbadk.coreExtra.d.a(this.mLoadDataCallBack);
        this.csv = new z(this, CmdConfigCustom.CMD_CACHE_PERSONINFO);
    }

    public boolean getIsSelf() {
        return this.bnO;
    }

    public void setIsSelf(boolean z) {
        this.bnO = z;
    }

    public boolean akq() {
        return this.cvg;
    }

    public void fe(boolean z) {
        this.cvg = z;
    }

    public boolean akr() {
        return this.cvh;
    }

    public void ff(boolean z) {
        this.cvh = z;
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

    public String getNameShow() {
        return this.mNameShow;
    }

    public void kg(String str) {
        this.mNameShow = str;
    }

    public String getStType() {
        return this.stType;
    }

    public void setStType(String str) {
        this.stType = str;
    }

    public String aks() {
        return this.cvi;
    }

    public void kh(String str) {
        this.cvi = str;
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

    public void akt() {
        if (this.mUserData != null && this.cvl != null) {
            this.cvl.a(this.mUserData.getHave_attention() != 1, this.mUserData.getPortrait(), this.mUserData.getUserId());
        }
    }

    public void aku() {
        MessageManager.getInstance().unRegisterListener(this.csv);
    }

    public void ajr() {
        com.baidu.tbadk.task.a aVar = new com.baidu.tbadk.task.a(CmdConfigCustom.CMD_CACHE_PERSONINFO, new ac());
        aVar.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(aVar);
        registerListener(this.csv);
    }

    public void akv() {
        sendMessage(new RequestPersonInfoMessage());
    }

    public void akw() {
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
        if (aks() != null) {
            try {
                profileRequestMessage.set_st_type(aks());
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
                com.baidu.tbadk.getUserInfo.b.BO().a(this.mUserData);
            }
            UserData userData = this.mUserData;
            if (userData != null) {
                i(userData);
            }
            AntiData afA = afA();
            if (afA != null) {
                b(afA);
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
                if (this.cvk == null) {
                    this.cvk = new PersonTainInfo();
                }
                this.cvk.parseProto(profileHttpResponseMessage.GetTainfo());
                if (this.che == null) {
                    this.che = new AntiData();
                }
                this.che.parserProtobuf(profileHttpResponseMessage.GetAntiStat());
                this.che.setUser_id(this.mUserData.getUserId());
                this.che.setUser_name(this.mUserData.getUserName());
                this.cvj.clear();
                List<PostInfoList> GetPostList = profileHttpResponseMessage.GetPostList();
                if (GetPostList != null) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < GetPostList.size()) {
                            PersonInfoPostList personInfoPostList = new PersonInfoPostList();
                            personInfoPostList.parseProto(GetPostList.get(i2));
                            this.cvj.add(personInfoPostList);
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
                if (this.cvk == null) {
                    this.cvk = new PersonTainInfo();
                }
                this.cvk.parseProto(profileSocketResponseMessage.GetTainfo());
                if (this.che == null) {
                    this.che = new AntiData();
                }
                this.che.parserProtobuf(profileSocketResponseMessage.GetAntiStat());
                this.che.setUser_id(this.mUserData.getUserId());
                this.che.setUser_name(this.mUserData.getUserName());
                this.cvj.clear();
                List<PostInfoList> GetPostList = profileSocketResponseMessage.GetPostList();
                if (GetPostList != null) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < GetPostList.size()) {
                            PersonInfoPostList personInfoPostList = new PersonInfoPostList();
                            personInfoPostList.parseProto(GetPostList.get(i2));
                            this.cvj.add(personInfoPostList);
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

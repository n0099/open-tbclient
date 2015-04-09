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
    private boolean aVz;
    private AntiData bHF;
    private CustomMessageListener bRb;
    private boolean bTR;
    private boolean bTS;
    private String bTT;
    private List<PersonInfoPostList> bTU;
    private PersonTainInfo bTV;
    private com.baidu.tbadk.coreExtra.c.a bTW;
    private long bTX;
    private int bTY;
    private String mId;
    private String mName;
    private UserData mUserData;
    private String stType;

    public long aeq() {
        return this.bTX;
    }

    public void al(long j) {
        this.bTX = j;
    }

    public void hH(int i) {
        this.bTY = i;
    }

    public AntiData Zp() {
        return this.bHF;
    }

    public void a(AntiData antiData) {
        this.bHF = antiData;
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

    public List<PersonInfoPostList> aer() {
        return this.bTU;
    }

    public PersonTainInfo aes() {
        return this.bTV;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public v(PersonInfoActivity personInfoActivity) {
        super(personInfoActivity.getPageContext());
        this.bTU = new ArrayList();
        this.bTW = new com.baidu.tbadk.coreExtra.c.a(this.mLoadDataCallBack);
        this.bRb = new w(this, 2001235);
    }

    public boolean getIsSelf() {
        return this.aVz;
    }

    public void setIsSelf(boolean z) {
        this.aVz = z;
    }

    public boolean aet() {
        return this.bTR;
    }

    public void eg(boolean z) {
        this.bTR = z;
    }

    public boolean aeu() {
        return this.bTS;
    }

    public void eh(boolean z) {
        this.bTS = z;
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

    public String aev() {
        return this.bTT;
    }

    public void ic(String str) {
        this.bTT = str;
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

    public void aew() {
        if (this.mUserData != null && this.bTW != null) {
            this.bTW.a(this.mUserData.getHave_attention() != 1, this.mUserData.getPortrait(), this.mUserData.getUserId());
        }
    }

    public void aex() {
        MessageManager.getInstance().unRegisterListener(this.bRb);
    }

    public void ady() {
        com.baidu.tbadk.task.a aVar = new com.baidu.tbadk.task.a(2001235, new y());
        aVar.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(aVar);
        registerListener(this.bRb);
    }

    public void aey() {
        sendMessage(new RequestPersonInfoMessage());
    }

    public void aez() {
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
        if (aev() != null) {
            try {
                profileRequestMessage.set_st_type(aev());
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
                com.baidu.tbadk.getUserInfo.b.zs().a(this.mUserData);
            }
            UserData userData = this.mUserData;
            if (userData != null) {
                k(userData);
            }
            AntiData Zp = Zp();
            if (Zp != null) {
                a(Zp);
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
                if (this.bTV == null) {
                    this.bTV = new PersonTainInfo();
                }
                this.bTV.parseProto(profileHttpResponseMessage.GetTainfo());
                if (this.bHF == null) {
                    this.bHF = new AntiData();
                }
                this.bHF.parserProtobuf(profileHttpResponseMessage.GetAntiStat());
                this.bHF.setUser_id(this.mUserData.getUserId());
                this.bHF.setUser_name(this.mUserData.getUserName());
                this.bTU.clear();
                List<PostInfoList> GetPostList = profileHttpResponseMessage.GetPostList();
                if (GetPostList != null) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < GetPostList.size()) {
                            PersonInfoPostList personInfoPostList = new PersonInfoPostList();
                            personInfoPostList.parseProto(GetPostList.get(i2));
                            this.bTU.add(personInfoPostList);
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
                if (this.bTV == null) {
                    this.bTV = new PersonTainInfo();
                }
                this.bTV.parseProto(profileSocketResponseMessage.GetTainfo());
                if (this.bHF == null) {
                    this.bHF = new AntiData();
                }
                this.bHF.parserProtobuf(profileSocketResponseMessage.GetAntiStat());
                this.bHF.setUser_id(this.mUserData.getUserId());
                this.bHF.setUser_name(this.mUserData.getUserName());
                this.bTU.clear();
                List<PostInfoList> GetPostList = profileSocketResponseMessage.GetPostList();
                if (GetPostList != null) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < GetPostList.size()) {
                            PersonInfoPostList personInfoPostList = new PersonInfoPostList();
                            personInfoPostList.parseProto(GetPostList.get(i2));
                            this.bTU.add(personInfoPostList);
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

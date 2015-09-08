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
public class w extends com.baidu.adp.base.e<PersonInfoActivity> {
    private boolean bmy;
    private AntiData cbj;
    private CustomMessageListener clk;
    private boolean cnS;
    private boolean cnT;
    private String cnU;
    private List<PersonInfoPostList> cnV;
    private PersonTainInfo cnW;
    private com.baidu.tbadk.coreExtra.c.a cnX;
    private long cnY;
    private int cnZ;
    private String mId;
    private String mName;
    private UserData mUserData;
    private String stType;

    public long ahL() {
        return this.cnY;
    }

    public void av(long j) {
        this.cnY = j;
    }

    public void jd(int i) {
        this.cnZ = i;
    }

    public AntiData adj() {
        return this.cbj;
    }

    public void b(AntiData antiData) {
        this.cbj = antiData;
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public void h(UserData userData) {
        if (userData != null) {
            setName(userData.getUserName());
        }
        this.mUserData = userData;
    }

    public List<PersonInfoPostList> getPostList() {
        return this.cnV;
    }

    public PersonTainInfo ahM() {
        return this.cnW;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public w(PersonInfoActivity personInfoActivity) {
        super(personInfoActivity.getPageContext());
        this.cnV = new ArrayList();
        this.cnX = new com.baidu.tbadk.coreExtra.c.a(this.mLoadDataCallBack);
        this.clk = new x(this, CmdConfigCustom.CMD_CACHE_PERSONINFO);
    }

    public boolean getIsSelf() {
        return this.bmy;
    }

    public void setIsSelf(boolean z) {
        this.bmy = z;
    }

    public boolean ahN() {
        return this.cnS;
    }

    public void eV(boolean z) {
        this.cnS = z;
    }

    public boolean ahO() {
        return this.cnT;
    }

    public void eW(boolean z) {
        this.cnT = z;
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

    public String ahP() {
        return this.cnU;
    }

    public void jI(String str) {
        this.cnU = str;
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

    public void ahQ() {
        if (this.mUserData != null && this.cnX != null) {
            this.cnX.a(this.mUserData.getHave_attention() != 1, this.mUserData.getPortrait(), this.mUserData.getUserId());
        }
    }

    public void ahR() {
        MessageManager.getInstance().unRegisterListener(this.clk);
    }

    public void agP() {
        com.baidu.tbadk.task.a aVar = new com.baidu.tbadk.task.a(CmdConfigCustom.CMD_CACHE_PERSONINFO, new aa());
        aVar.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(aVar);
        registerListener(this.clk);
    }

    public void ahS() {
        sendMessage(new RequestPersonInfoMessage());
    }

    public void ahT() {
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
        if (ahP() != null) {
            try {
                profileRequestMessage.set_st_type(ahP());
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
                com.baidu.tbadk.getUserInfo.b.Cl().a(this.mUserData);
            }
            UserData userData = this.mUserData;
            if (userData != null) {
                h(userData);
            }
            AntiData adj = adj();
            if (adj != null) {
                b(adj);
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
                if (this.cnW == null) {
                    this.cnW = new PersonTainInfo();
                }
                this.cnW.parseProto(profileHttpResponseMessage.GetTainfo());
                if (this.cbj == null) {
                    this.cbj = new AntiData();
                }
                this.cbj.parserProtobuf(profileHttpResponseMessage.GetAntiStat());
                this.cbj.setUser_id(this.mUserData.getUserId());
                this.cbj.setUser_name(this.mUserData.getUserName());
                this.cnV.clear();
                List<PostInfoList> GetPostList = profileHttpResponseMessage.GetPostList();
                if (GetPostList != null) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < GetPostList.size()) {
                            PersonInfoPostList personInfoPostList = new PersonInfoPostList();
                            personInfoPostList.parseProto(GetPostList.get(i2));
                            this.cnV.add(personInfoPostList);
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
                if (this.cnW == null) {
                    this.cnW = new PersonTainInfo();
                }
                this.cnW.parseProto(profileSocketResponseMessage.GetTainfo());
                if (this.cbj == null) {
                    this.cbj = new AntiData();
                }
                this.cbj.parserProtobuf(profileSocketResponseMessage.GetAntiStat());
                this.cbj.setUser_id(this.mUserData.getUserId());
                this.cbj.setUser_name(this.mUserData.getUserName());
                this.cnV.clear();
                List<PostInfoList> GetPostList = profileSocketResponseMessage.GetPostList();
                if (GetPostList != null) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < GetPostList.size()) {
                            PersonInfoPostList personInfoPostList = new PersonInfoPostList();
                            personInfoPostList.parseProto(GetPostList.get(i2));
                            this.cnV.add(personInfoPostList);
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

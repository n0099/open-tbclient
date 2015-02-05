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
    private CustomMessageListener bID;
    private boolean bLq;
    private boolean bLr;
    private String bLs;
    private AntiData bLt;
    private List<PersonInfoPostList> bLu;
    private PersonTainInfo bLv;
    private com.baidu.tbadk.coreExtra.c.a bLw;
    private long bLx;
    private int bLy;
    private boolean bzd;
    private String mId;
    private String mName;
    private UserData mUserData;
    private String stType;

    public long abN() {
        return this.bLx;
    }

    public void ai(long j) {
        this.bLx = j;
    }

    public void hv(int i) {
        this.bLy = i;
    }

    public AntiData abO() {
        return this.bLt;
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public void l(UserData userData) {
        this.mUserData = userData;
    }

    public List<PersonInfoPostList> abP() {
        return this.bLu;
    }

    public PersonTainInfo abQ() {
        return this.bLv;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public v(PersonInfoActivity personInfoActivity) {
        super(personInfoActivity.getPageContext());
        this.bLu = new ArrayList();
        this.bLw = new com.baidu.tbadk.coreExtra.c.a(this.mLoadDataCallBack);
        this.bID = new w(this, 2001235);
    }

    public boolean getIsSelf() {
        return this.bzd;
    }

    public void setIsSelf(boolean z) {
        this.bzd = z;
    }

    public boolean abR() {
        return this.bLq;
    }

    public void el(boolean z) {
        this.bLq = z;
    }

    public boolean abS() {
        return this.bLr;
    }

    public void em(boolean z) {
        this.bLr = z;
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

    public String abT() {
        return this.bLs;
    }

    public void hN(String str) {
        this.bLs = str;
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

    public void abU() {
        if (this.mUserData != null && this.bLw != null) {
            this.bLw.a(this.mUserData.getHave_attention() != 1, this.mUserData.getPortrait(), this.mUserData.getUserId());
        }
    }

    public void abV() {
        MessageManager.getInstance().unRegisterListener(this.bID);
    }

    public void aaZ() {
        com.baidu.tbadk.task.a aVar = new com.baidu.tbadk.task.a(2001235, new y());
        aVar.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(aVar);
        registerListener(this.bID);
    }

    public void abW() {
        sendMessage(new RequestPersonInfoMessage());
    }

    public void abX() {
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
        if (abT() != null) {
            try {
                profileRequestMessage.set_st_type(abT());
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
                com.baidu.tbadk.getUserInfo.b.vM().a(this.mUserData);
            }
            UserData userData = this.mUserData;
            if (userData != null) {
                l(userData);
            }
            AntiData abO = abO();
            if (abO != null) {
                this.bLt = abO;
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
                if (this.bLv == null) {
                    this.bLv = new PersonTainInfo();
                }
                this.bLv.parseProto(profileHttpResponseMessage.GetTainfo());
                if (this.bLt == null) {
                    this.bLt = new AntiData();
                }
                this.bLt.parserProtobuf(profileHttpResponseMessage.GetAntiStat());
                this.bLu.clear();
                List<PostInfoList> GetPostList = profileHttpResponseMessage.GetPostList();
                if (GetPostList != null) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < GetPostList.size()) {
                            PersonInfoPostList personInfoPostList = new PersonInfoPostList();
                            personInfoPostList.parseProto(GetPostList.get(i2));
                            this.bLu.add(personInfoPostList);
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
                if (this.bLv == null) {
                    this.bLv = new PersonTainInfo();
                }
                this.bLv.parseProto(profileSocketResponseMessage.GetTainfo());
                if (this.bLt == null) {
                    this.bLt = new AntiData();
                }
                this.bLt.parserProtobuf(profileSocketResponseMessage.GetAntiStat());
                this.bLu.clear();
                List<PostInfoList> GetPostList = profileSocketResponseMessage.GetPostList();
                if (GetPostList != null) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < GetPostList.size()) {
                            PersonInfoPostList personInfoPostList = new PersonInfoPostList();
                            personInfoPostList.parseProto(GetPostList.get(i2));
                            this.bLu.add(personInfoPostList);
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

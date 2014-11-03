package com.baidu.tieba.personInfo;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.data.PersonChangeData;
import com.baidu.tieba.person.ProfileHttpResponseMessage;
import com.baidu.tieba.person.ProfileRequestMessage;
import com.baidu.tieba.person.ProfileSocketResponseMessage;
import java.util.ArrayList;
import java.util.List;
import tbclient.PostInfoList;
/* loaded from: classes.dex */
public class v extends com.baidu.adp.base.e {
    private AntiData amJ;
    private CustomMessageListener bDt;
    private boolean bGm;
    private boolean bGn;
    private String bGo;
    private List<PersonInfoPostList> bGp;
    private PersonTainInfo bGq;
    private com.baidu.tbadk.coreExtra.b.a bGr;
    private long bGs;
    private int bGt;
    private boolean bpa;
    private String mId;
    private String mName;
    private UserData mUserData;
    private String stType;

    public long aaT() {
        return this.bGs;
    }

    public void X(long j) {
        this.bGs = j;
    }

    public void hd(int i) {
        this.bGt = i;
    }

    public AntiData Ap() {
        return this.amJ;
    }

    public void a(AntiData antiData) {
        this.amJ = antiData;
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public void h(UserData userData) {
        this.mUserData = userData;
    }

    public List<PersonInfoPostList> aaU() {
        return this.bGp;
    }

    public PersonTainInfo aaV() {
        return this.bGq;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public v(Context context) {
        super(context);
        this.bGp = new ArrayList();
        this.bGr = new com.baidu.tbadk.coreExtra.b.a(this.mLoadDataCallBack);
        this.bDt = new w(this, 2001235);
    }

    public boolean getIsSelf() {
        return this.bpa;
    }

    public void setIsSelf(boolean z) {
        this.bpa = z;
    }

    public boolean aaW() {
        return this.bGm;
    }

    public void ez(boolean z) {
        this.bGm = z;
    }

    public boolean aaX() {
        return this.bGn;
    }

    public void eA(boolean z) {
        this.bGn = z;
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

    public String aaY() {
        return this.bGo;
    }

    public void hi(String str) {
        this.bGo = str;
    }

    public void c(PersonChangeData personChangeData) {
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

    public void aaZ() {
        if (this.mUserData != null && this.bGr != null) {
            this.bGr.a(this.mUserData.getHave_attention() != 1, this.mUserData.getPortrait(), this.mUserData.getUserId());
        }
    }

    public void aba() {
        MessageManager.getInstance().unRegisterListener(this.bDt);
    }

    public void aai() {
        com.baidu.tbadk.task.a aVar = new com.baidu.tbadk.task.a(2001235, new y());
        aVar.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(aVar);
        registerListener(this.bDt);
    }

    public void abb() {
        sendMessage(new RequestPersonInfoMessage());
    }

    public void abc() {
        ProfileRequestMessage profileRequestMessage = new ProfileRequestMessage();
        if (TbadkApplication.getCurrentAccount() != null) {
            profileRequestMessage.set_uid(Integer.valueOf(com.baidu.adp.lib.g.c.f(TbadkApplication.getCurrentAccount(), 0)));
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
        if (aaY() != null) {
            try {
                profileRequestMessage.set_st_type(aaY());
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
                AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    if (this.mUserData != null && !TextUtils.isEmpty(this.mUserData.getPortrait())) {
                        com.baidu.tbadk.core.account.a.y(currentAccountObj.getAccount(), this.mUserData.getPortrait());
                        currentAccountObj.setPortrait(this.mUserData.getPortrait());
                    }
                } else {
                    return;
                }
            }
            UserData userData = this.mUserData;
            if (userData != null) {
                h(userData);
            }
            AntiData Ap = Ap();
            if (Ap != null) {
                a(Ap);
            }
            this.mLoadDataCallBack.a(true);
            return;
        }
        if (z3) {
            setErrorString(str);
        }
        this.mLoadDataCallBack.a(false);
    }

    public void b(ProfileHttpResponseMessage profileHttpResponseMessage) {
        if (profileHttpResponseMessage != null) {
            try {
                if (this.mUserData == null) {
                    this.mUserData = new UserData();
                }
                this.mUserData.parserProtobuf(profileHttpResponseMessage.GetUser());
                if (this.bGq == null) {
                    this.bGq = new PersonTainInfo();
                }
                this.bGq.parseProto(profileHttpResponseMessage.GetTainfo());
                if (this.amJ == null) {
                    this.amJ = new AntiData();
                }
                this.amJ.parserProtobuf(profileHttpResponseMessage.GetAntiStat());
                this.bGp.clear();
                List<PostInfoList> GetPostList = profileHttpResponseMessage.GetPostList();
                if (GetPostList != null) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < GetPostList.size()) {
                            PersonInfoPostList personInfoPostList = new PersonInfoPostList();
                            personInfoPostList.parseProto(GetPostList.get(i2));
                            this.bGp.add(personInfoPostList);
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
                if (this.bGq == null) {
                    this.bGq = new PersonTainInfo();
                }
                this.bGq.parseProto(profileSocketResponseMessage.GetTainfo());
                if (this.amJ == null) {
                    this.amJ = new AntiData();
                }
                this.amJ.parserProtobuf(profileSocketResponseMessage.GetAntiStat());
                this.bGp.clear();
                List<PostInfoList> GetPostList = profileSocketResponseMessage.GetPostList();
                if (GetPostList != null) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < GetPostList.size()) {
                            PersonInfoPostList personInfoPostList = new PersonInfoPostList();
                            personInfoPostList.parseProto(GetPostList.get(i2));
                            this.bGp.add(personInfoPostList);
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

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
    private CustomMessageListener bGS;
    private boolean bJG;
    private boolean bJH;
    private String bJI;
    private AntiData bJJ;
    private List<PersonInfoPostList> bJK;
    private PersonTainInfo bJL;
    private com.baidu.tbadk.coreExtra.c.a bJM;
    private long bJN;
    private int bJO;
    private boolean bxv;
    private String mId;
    private String mName;
    private UserData mUserData;
    private String stType;

    public long abo() {
        return this.bJN;
    }

    public void ai(long j) {
        this.bJN = j;
    }

    public void hm(int i) {
        this.bJO = i;
    }

    public AntiData abp() {
        return this.bJJ;
    }

    public void a(AntiData antiData) {
        this.bJJ = antiData;
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public void l(UserData userData) {
        this.mUserData = userData;
    }

    public List<PersonInfoPostList> abq() {
        return this.bJK;
    }

    public PersonTainInfo abr() {
        return this.bJL;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public v(PersonInfoActivity personInfoActivity) {
        super(personInfoActivity.getPageContext());
        this.bJK = new ArrayList();
        this.bJM = new com.baidu.tbadk.coreExtra.c.a(this.mLoadDataCallBack);
        this.bGS = new w(this, 2001235);
    }

    public boolean getIsSelf() {
        return this.bxv;
    }

    public void setIsSelf(boolean z) {
        this.bxv = z;
    }

    public boolean abs() {
        return this.bJG;
    }

    public void ef(boolean z) {
        this.bJG = z;
    }

    public boolean abt() {
        return this.bJH;
    }

    public void eg(boolean z) {
        this.bJH = z;
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

    public String abu() {
        return this.bJI;
    }

    public void hI(String str) {
        this.bJI = str;
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

    public void abv() {
        if (this.mUserData != null && this.bJM != null) {
            this.bJM.a(this.mUserData.getHave_attention() != 1, this.mUserData.getPortrait(), this.mUserData.getUserId());
        }
    }

    public void abw() {
        MessageManager.getInstance().unRegisterListener(this.bGS);
    }

    public void aaz() {
        com.baidu.tbadk.task.a aVar = new com.baidu.tbadk.task.a(2001235, new y());
        aVar.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(aVar);
        registerListener(this.bGS);
    }

    public void abx() {
        sendMessage(new RequestPersonInfoMessage());
    }

    public void aby() {
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
        if (abu() != null) {
            try {
                profileRequestMessage.set_st_type(abu());
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
                com.baidu.tbadk.getUserInfo.b.vA().a(this.mUserData);
            }
            UserData userData = this.mUserData;
            if (userData != null) {
                l(userData);
            }
            AntiData abp = abp();
            if (abp != null) {
                a(abp);
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
                if (this.bJL == null) {
                    this.bJL = new PersonTainInfo();
                }
                this.bJL.parseProto(profileHttpResponseMessage.GetTainfo());
                if (this.bJJ == null) {
                    this.bJJ = new AntiData();
                }
                this.bJJ.parserProtobuf(profileHttpResponseMessage.GetAntiStat());
                this.bJK.clear();
                List<PostInfoList> GetPostList = profileHttpResponseMessage.GetPostList();
                if (GetPostList != null) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < GetPostList.size()) {
                            PersonInfoPostList personInfoPostList = new PersonInfoPostList();
                            personInfoPostList.parseProto(GetPostList.get(i2));
                            this.bJK.add(personInfoPostList);
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
                if (this.bJL == null) {
                    this.bJL = new PersonTainInfo();
                }
                this.bJL.parseProto(profileSocketResponseMessage.GetTainfo());
                if (this.bJJ == null) {
                    this.bJJ = new AntiData();
                }
                this.bJJ.parserProtobuf(profileSocketResponseMessage.GetAntiStat());
                this.bJK.clear();
                List<PostInfoList> GetPostList = profileSocketResponseMessage.GetPostList();
                if (GetPostList != null) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < GetPostList.size()) {
                            PersonInfoPostList personInfoPostList = new PersonInfoPostList();
                            personInfoPostList.parseProto(GetPostList.get(i2));
                            this.bJK.add(personInfoPostList);
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

package com.baidu.tieba.more;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.person.PersonPostListData;
import com.baidu.tieba.person.ProfileHttpResponseMessage;
import com.baidu.tieba.person.ProfileRequestMessage;
import com.baidu.tieba.person.ProfileSocketResponseMessage;
import tbclient.Profile.DataRes;
/* loaded from: classes.dex */
public class ac extends com.baidu.adp.base.e {
    private boolean Ty;
    private com.baidu.tieba.b.a aAO;
    private com.baidu.adp.framework.listener.a brl;
    private final Context mContext;
    private String mId;
    Handler mUIHandler;
    private UserData mUser;

    public ac(Context context) {
        super(context);
        this.mUIHandler = null;
        this.aAO = null;
        this.Ty = false;
        this.brl = new ad(this, CmdConfigHttp.PROFILE_HTTP_CMD, 303012);
        this.mUser = null;
        this.mContext = context;
        this.mUIHandler = new Handler(Looper.getMainLooper());
        this.aAO = new com.baidu.tieba.b.a("profileStat");
        registerListener(this.brl);
    }

    public UserData getUser() {
        return this.mUser;
    }

    public void setUser(UserData userData) {
        this.mUser = userData;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public void c(boolean z, boolean z2) {
        cancelMessage();
        d(z, z2);
    }

    public void d(boolean z, boolean z2) {
        if (!this.Ty) {
            this.Ty = true;
            ProfileRequestMessage profileRequestMessage = new ProfileRequestMessage();
            if (TbadkApplication.getCurrentAccount() != null) {
                profileRequestMessage.set_uid(Integer.valueOf(TbadkApplication.getCurrentAccount()));
            }
            if (z) {
                SY();
            }
            profileRequestMessage.set_has_plist(0);
            profileRequestMessage.set_from_db(z);
            profileRequestMessage.set_error_hint(z2);
            profileRequestMessage.setSelf(true);
            UZ();
            sendMessage(profileRequestMessage);
        }
    }

    public void a(boolean z, String str, boolean z2, boolean z3) {
        if (!z) {
            if (z2) {
                AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    if (getUser() != null && !TextUtils.isEmpty(getUser().getPortrait())) {
                        com.baidu.tbadk.core.account.a.y(currentAccountObj.getAccount(), getUser().getPortrait());
                        currentAccountObj.setPortrait(getUser().getPortrait());
                    }
                } else {
                    return;
                }
            }
            UserData user = getUser();
            if (user != null) {
                setUser(user);
            }
            this.mLoadDataMode = 1;
            this.mLoadDataCallBack.a(true);
            return;
        }
        if (z3) {
            setErrorString(str);
        } else {
            setErrorString(this.mContext.getString(com.baidu.tieba.y.neterror));
        }
        this.mLoadDataMode = 1;
        this.mLoadDataCallBack.a(false);
    }

    public void a(ProfileSocketResponseMessage profileSocketResponseMessage) {
        this.Ty = false;
        if (profileSocketResponseMessage != null) {
            b(profileSocketResponseMessage);
            a(profileSocketResponseMessage.hasError(), profileSocketResponseMessage.getErrorString(), profileSocketResponseMessage.isFrom_db(), profileSocketResponseMessage.isError_hint());
        }
    }

    public void a(ProfileHttpResponseMessage profileHttpResponseMessage) {
        this.Ty = false;
        if (profileHttpResponseMessage != null) {
            b(profileHttpResponseMessage);
            a(profileHttpResponseMessage.hasError(), profileHttpResponseMessage.getErrorString(), profileHttpResponseMessage.isFrom_db(), profileHttpResponseMessage.isError_hint());
        }
    }

    public void b(ProfileSocketResponseMessage profileSocketResponseMessage) {
        if (profileSocketResponseMessage != null) {
            try {
                this.mUser = new UserData();
                this.mUser.parserProtobuf(profileSocketResponseMessage.GetUser());
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            new PersonPostListData().parserData(profileSocketResponseMessage);
        }
    }

    public void b(ProfileHttpResponseMessage profileHttpResponseMessage) {
        if (profileHttpResponseMessage != null) {
            try {
                this.mUser = new UserData();
                this.mUser.parserProtobuf(profileHttpResponseMessage.GetUser());
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            new PersonPostListData().parserData(profileHttpResponseMessage);
        }
    }

    public void SY() {
        wQ().a("profile_cache_key", new ae(this));
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            try {
                this.mUser = new UserData();
                this.mUser.parserProtobuf(dataRes.user);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private com.baidu.adp.lib.cache.t<byte[]> wQ() {
        return com.baidu.tbadk.core.a.a.kS().C("tb_user_profile", TbadkApplication.getCurrentAccountName());
    }

    private void UZ() {
        if (this.aAO == null) {
            this.aAO = new com.baidu.tieba.b.a("profileStat");
            this.aAO.start();
        }
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }
}

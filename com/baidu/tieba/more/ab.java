package com.baidu.tieba.more;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.person.PersonPostListData;
import com.baidu.tieba.person.ProfileHttpResponseMessage;
import com.baidu.tieba.person.ProfileRequestMessage;
import com.baidu.tieba.person.ProfileSocketResponseMessage;
import tbclient.Profile.DataRes;
/* loaded from: classes.dex */
public class ab extends com.baidu.adp.base.f<MoreActivity> {
    private boolean ZD;
    private com.baidu.tieba.tbadkCore.d.a aCg;
    private com.baidu.adp.framework.listener.a buz;
    private final Context mContext;
    private String mId;
    Handler mUIHandler;
    private UserData mUser;

    public ab(MoreActivity moreActivity) {
        super(moreActivity.getPageContext());
        this.mUIHandler = null;
        this.aCg = null;
        this.ZD = false;
        this.buz = new ac(this, CmdConfigHttp.PROFILE_HTTP_CMD, 303012);
        this.mUser = null;
        this.mContext = moreActivity.getPageContext().getContext();
        this.mUIHandler = new Handler(Looper.getMainLooper());
        this.aCg = new com.baidu.tieba.tbadkCore.d.a("profileStat");
        registerListener(this.buz);
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

    public void d(boolean z, boolean z2) {
        cancelMessage();
        e(z, z2);
    }

    public void e(boolean z, boolean z2) {
        if (!this.ZD) {
            this.ZD = true;
            ProfileRequestMessage profileRequestMessage = new ProfileRequestMessage();
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                profileRequestMessage.set_uid(Integer.valueOf(TbadkCoreApplication.getCurrentAccount()));
            }
            if (z) {
                Vl();
            }
            profileRequestMessage.set_has_plist(0);
            profileRequestMessage.set_from_db(z);
            profileRequestMessage.set_error_hint(z2);
            profileRequestMessage.setSelf(true);
            Vm();
            sendMessage(profileRequestMessage);
        }
    }

    public void a(boolean z, String str, boolean z2, boolean z3) {
        if (!z) {
            if (z2) {
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    if (getUser() != null && !TextUtils.isEmpty(getUser().getPortrait())) {
                        com.baidu.tbadk.core.account.a.J(currentAccountObj.getAccount(), getUser().getPortrait());
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
            this.mLoadDataCallBack.c(true);
            return;
        }
        if (z3) {
            setErrorString(str);
        } else {
            setErrorString(this.mContext.getString(com.baidu.tieba.z.neterror));
        }
        this.mLoadDataMode = 1;
        this.mLoadDataCallBack.c(false);
    }

    public void a(ProfileSocketResponseMessage profileSocketResponseMessage) {
        this.ZD = false;
        if (profileSocketResponseMessage != null) {
            b(profileSocketResponseMessage);
            a(profileSocketResponseMessage.hasError(), profileSocketResponseMessage.getErrorString(), profileSocketResponseMessage.isFrom_db(), profileSocketResponseMessage.isError_hint());
        }
    }

    public void a(ProfileHttpResponseMessage profileHttpResponseMessage) {
        this.ZD = false;
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

    public void Vl() {
        Am().a("profile_cache_key", new ad(this));
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

    private com.baidu.adp.lib.cache.t<byte[]> Am() {
        return com.baidu.tbadk.core.a.a.nS().N("tb_user_profile", TbadkCoreApplication.getCurrentAccountName());
    }

    private void Vm() {
        if (this.aCg == null) {
            this.aCg = new com.baidu.tieba.tbadkCore.d.a("profileStat");
            this.aCg.start();
        }
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        return false;
    }
}

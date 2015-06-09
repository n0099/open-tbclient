package com.baidu.tieba.setting.more;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.person.ProfileHttpResponseMessage;
import com.baidu.tieba.person.ProfileRequestMessage;
import com.baidu.tieba.person.ProfileSocketResponseMessage;
import com.baidu.tieba.setting.person.PersonPostListData;
import tbclient.Profile.DataRes;
/* loaded from: classes.dex */
public class w extends com.baidu.adp.base.f<MoreActivity> {
    private com.baidu.tieba.tbadkCore.e.a aFt;
    private boolean alI;
    private com.baidu.adp.framework.listener.a cfv;
    private final Context mContext;
    private String mId;
    Handler mUIHandler;
    private UserData mUser;

    public w(MoreActivity moreActivity) {
        super(moreActivity.getPageContext());
        this.mUIHandler = null;
        this.aFt = null;
        this.alI = false;
        this.cfv = new x(this, CmdConfigHttp.PROFILE_HTTP_CMD, 303012);
        this.mUser = null;
        this.mContext = moreActivity.getPageContext().getContext();
        this.mUIHandler = new Handler(Looper.getMainLooper());
        this.aFt = new com.baidu.tieba.tbadkCore.e.a("profileStat");
        registerListener(this.cfv);
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

    public void i(boolean z, boolean z2) {
        cancelMessage();
        j(z, z2);
    }

    public void j(boolean z, boolean z2) {
        if (!this.alI) {
            this.alI = true;
            ProfileRequestMessage profileRequestMessage = new ProfileRequestMessage();
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                profileRequestMessage.set_uid(Integer.valueOf(TbadkCoreApplication.getCurrentAccount()));
            }
            if (z) {
                aiX();
            }
            profileRequestMessage.set_has_plist(0);
            profileRequestMessage.set_from_db(z);
            profileRequestMessage.set_error_hint(z2);
            profileRequestMessage.setSelf(true);
            aeV();
            sendMessage(profileRequestMessage);
        }
    }

    public void a(boolean z, String str, boolean z2, boolean z3) {
        if (!z) {
            UserData user = getUser();
            if (user != null) {
                setUser(user);
            }
            com.baidu.tbadk.getUserInfo.b.Ag().a(getUser());
            this.mLoadDataMode = 1;
            this.mLoadDataCallBack.c(true);
            return;
        }
        if (z3) {
            setErrorString(str);
        } else {
            setErrorString(this.mContext.getString(com.baidu.tieba.t.neterror));
        }
        this.mLoadDataMode = 1;
        this.mLoadDataCallBack.c(false);
    }

    public void a(ProfileSocketResponseMessage profileSocketResponseMessage) {
        this.alI = false;
        if (profileSocketResponseMessage != null) {
            b(profileSocketResponseMessage);
            a(profileSocketResponseMessage.hasError(), profileSocketResponseMessage.getErrorString(), profileSocketResponseMessage.isFrom_db(), profileSocketResponseMessage.isError_hint());
        }
    }

    public void a(ProfileHttpResponseMessage profileHttpResponseMessage) {
        this.alI = false;
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

    public void aiX() {
        Ih().a("profile_cache_key", new y(this));
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

    private com.baidu.adp.lib.cache.t<byte[]> Ih() {
        return com.baidu.tbadk.core.b.a.rI().V("tb_user_profile", TbadkCoreApplication.getCurrentAccountName());
    }

    private void aeV() {
        if (this.aFt == null) {
            this.aFt = new com.baidu.tieba.tbadkCore.e.a("profileStat");
            this.aFt.start();
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

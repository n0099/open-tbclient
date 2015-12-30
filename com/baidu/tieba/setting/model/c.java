package com.baidu.tieba.setting.model;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.n;
import com.baidu.tieba.person.ProfileHttpResponseMessage;
import com.baidu.tieba.person.ProfileRequestMessage;
import com.baidu.tieba.person.ProfileSocketResponseMessage;
import com.baidu.tieba.setting.more.MoreActivity;
import com.baidu.tieba.setting.person.PersonPostListData;
import tbclient.Profile.DataRes;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.base.e<MoreActivity> {
    private com.baidu.tieba.tbadkCore.d.a aUT;
    private com.baidu.adp.framework.listener.a dsN;
    private final Context mContext;
    private String mId;
    private boolean mIsLoading;
    Handler mUIHandler;
    private UserData mUser;

    public c(MoreActivity moreActivity) {
        super(moreActivity.getPageContext());
        this.mUIHandler = null;
        this.aUT = null;
        this.mIsLoading = false;
        this.dsN = new d(this, CmdConfigHttp.PROFILE_HTTP_CMD, 303012);
        this.mUser = null;
        this.mContext = moreActivity.getPageContext().getContext();
        this.mUIHandler = new Handler(Looper.getMainLooper());
        this.aUT = new com.baidu.tieba.tbadkCore.d.a("profileStat");
        registerListener(this.dsN);
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

    public void s(boolean z, boolean z2) {
        cancelMessage();
        t(z, z2);
    }

    public void t(boolean z, boolean z2) {
        if (!this.mIsLoading) {
            this.mIsLoading = true;
            ProfileRequestMessage profileRequestMessage = new ProfileRequestMessage();
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                profileRequestMessage.set_uid(Long.valueOf(com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccount(), 0L)));
            }
            if (z) {
                aye();
                return;
            }
            profileRequestMessage.set_need_post_count(1);
            profileRequestMessage.set_pn(1);
            profileRequestMessage.set_rn(20);
            profileRequestMessage.set_has_plist(1);
            profileRequestMessage.set_from_db(z);
            profileRequestMessage.set_error_hint(z2);
            profileRequestMessage.setSelf(true);
            apY();
            sendMessage(profileRequestMessage);
        }
    }

    public void a(boolean z, String str, boolean z2, boolean z3) {
        if (!z) {
            UserData user = getUser();
            if (user != null) {
                setUser(user);
            }
            com.baidu.tbadk.getUserInfo.b.CE().a(getUser());
            this.mLoadDataMode = 1;
            this.mLoadDataCallBack.d(true);
            return;
        }
        if (z3) {
            setErrorString(str);
        } else {
            setErrorString(this.mContext.getString(n.j.neterror));
        }
        this.mLoadDataMode = 1;
        this.mLoadDataCallBack.d(false);
    }

    public void a(ProfileSocketResponseMessage profileSocketResponseMessage) {
        this.mIsLoading = false;
        if (profileSocketResponseMessage != null) {
            b(profileSocketResponseMessage);
            a(profileSocketResponseMessage.hasError(), profileSocketResponseMessage.getErrorString(), profileSocketResponseMessage.isFrom_db(), profileSocketResponseMessage.isError_hint());
        }
    }

    public void a(ProfileHttpResponseMessage profileHttpResponseMessage) {
        this.mIsLoading = false;
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

    public void aye() {
        KB().a("profile_cache_key", new e(this));
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

    private o<byte[]> KB() {
        return com.baidu.tbadk.core.b.a.tc().P("tb_user_profile", TbadkCoreApplication.getCurrentAccountName());
    }

    private void apY() {
        if (this.aUT == null) {
            this.aUT = new com.baidu.tieba.tbadkCore.d.a("profileStat");
            this.aUT.start();
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

package com.baidu.tieba.setting.model;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.listener.a;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.d;
import com.baidu.tieba.person.ProfileHttpResponseMessage;
import com.baidu.tieba.person.ProfileRequestMessage;
import com.baidu.tieba.person.ProfileSocketResponseMessage;
import com.baidu.tieba.setting.more.MoreActivity;
import com.baidu.tieba.setting.person.PersonPostListData;
import com.baidu.tieba.tbadkCore.d.b;
import com.squareup.wire.Wire;
import tbclient.Profile.DataRes;
import tbclient.Profile.NicknameInfo;
import tbclient.Profile.ProfileResIdl;
/* loaded from: classes3.dex */
public class MoreDiscoveryModel extends BdBaseModel<MoreActivity> {
    public static final int GET_DATA_FROM_DB = 2;
    public static final int GET_DATA_FROM_NET = 1;
    private b cQK;
    private NicknameInfo gaz;
    private a gxf;
    private final Context mContext;
    private String mId;
    private boolean mIsLoading;
    Handler mUIHandler;
    private UserData mUser;

    public MoreDiscoveryModel(MoreActivity moreActivity) {
        super(moreActivity.getPageContext());
        this.mUIHandler = null;
        this.cQK = null;
        this.mIsLoading = false;
        this.gxf = new a(CmdConfigHttp.PROFILE_HTTP_CMD, 303012) { // from class: com.baidu.tieba.setting.model.MoreDiscoveryModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if ((responsedMessage instanceof ProfileSocketResponseMessage) || (responsedMessage instanceof ProfileHttpResponseMessage)) {
                    if (responsedMessage.getOrginalMessage() == null || MoreDiscoveryModel.this.getUniqueId() == null || MoreDiscoveryModel.this.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                        if (responsedMessage instanceof ProfileSocketResponseMessage) {
                            ProfileSocketResponseMessage profileSocketResponseMessage = (ProfileSocketResponseMessage) responsedMessage;
                            if (MoreDiscoveryModel.this.cQK != null) {
                                MoreDiscoveryModel.this.cQK.a(false, !responsedMessage.hasError(), profileSocketResponseMessage.getError(), profileSocketResponseMessage.getErrorString(), profileSocketResponseMessage.getDownSize(), 0L, profileSocketResponseMessage.getCostTime());
                                MoreDiscoveryModel.this.cQK = null;
                            }
                            MoreDiscoveryModel.this.a(profileSocketResponseMessage);
                        }
                        if (responsedMessage instanceof ProfileHttpResponseMessage) {
                            ProfileHttpResponseMessage profileHttpResponseMessage = (ProfileHttpResponseMessage) responsedMessage;
                            if (MoreDiscoveryModel.this.cQK != null) {
                                MoreDiscoveryModel.this.cQK.a(true, !responsedMessage.hasError(), profileHttpResponseMessage.getError(), profileHttpResponseMessage.getErrorString(), profileHttpResponseMessage.getDownSize(), profileHttpResponseMessage.getCostTime(), 0L);
                                MoreDiscoveryModel.this.cQK = null;
                            }
                            MoreDiscoveryModel.this.a(profileHttpResponseMessage);
                        }
                    }
                }
            }
        };
        this.mUser = null;
        this.mContext = moreActivity.getPageContext().getContext();
        this.mUIHandler = new Handler(Looper.getMainLooper());
        this.cQK = new b("profileStat");
        registerListener(this.gxf);
    }

    public NicknameInfo getNicknameInfo() {
        return this.gaz;
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

    public void Q(boolean z, boolean z2) {
        cancelMessage();
        R(z, z2);
    }

    public void R(boolean z, boolean z2) {
        if (!this.mIsLoading) {
            this.mIsLoading = true;
            ProfileRequestMessage profileRequestMessage = new ProfileRequestMessage();
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                profileRequestMessage.set_uid(Long.valueOf(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L)));
            }
            if (z) {
                tL();
                return;
            }
            profileRequestMessage.set_need_post_count(1);
            profileRequestMessage.set_pn(1);
            profileRequestMessage.set_rn(20);
            profileRequestMessage.set_has_plist(1);
            profileRequestMessage.set_from_db(z);
            profileRequestMessage.set_error_hint(z2);
            profileRequestMessage.setSelf(true);
            profileRequestMessage.setIs_from_usercenter(1);
            profileRequestMessage.setPage(2);
            bqJ();
            sendMessage(profileRequestMessage);
        }
    }

    public void a(boolean z, String str, boolean z2, boolean z3) {
        if (!z) {
            UserData user = getUser();
            if (user != null) {
                setUser(user);
            }
            com.baidu.tbadk.getUserInfo.b.IM().a(getUser());
            this.mLoadDataMode = 1;
            this.mLoadDataCallBack.i(true);
            return;
        }
        if (z3) {
            setErrorString(str);
        } else {
            setErrorString(this.mContext.getString(d.k.neterror));
        }
        this.mLoadDataMode = 1;
        this.mLoadDataCallBack.i(false);
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
                this.gaz = profileSocketResponseMessage.getNicknameInfo();
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
                this.gaz = profileHttpResponseMessage.getNicknameInfo();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            new PersonPostListData().parserData(profileHttpResponseMessage);
        }
    }

    public void tL() {
        bqI().a("profile_cache_key", new l.a<byte[]>() { // from class: com.baidu.tieba.setting.model.MoreDiscoveryModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.cache.l.a
            /* renamed from: n */
            public void g(String str, byte[] bArr) {
                boolean z;
                if (bArr != null) {
                    try {
                        MoreDiscoveryModel.this.a(((ProfileResIdl) new Wire(new Class[0]).parseFrom(bArr, ProfileResIdl.class)).data);
                        z = true;
                    } catch (Exception e) {
                        z = false;
                    }
                    if (z) {
                        MoreDiscoveryModel.this.mUIHandler.post(new Runnable() { // from class: com.baidu.tieba.setting.model.MoreDiscoveryModel.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                MoreDiscoveryModel.this.mLoadDataMode = 2;
                                MoreDiscoveryModel.this.setErrorString(null);
                                MoreDiscoveryModel.this.mLoadDataCallBack.i(true);
                            }
                        });
                    }
                }
                MoreDiscoveryModel.this.mIsLoading = false;
            }
        });
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            try {
                this.mUser = new UserData();
                this.mUser.parserProtobuf(dataRes.user);
                this.gaz = dataRes.nickname_info;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private l<byte[]> bqI() {
        return com.baidu.tbadk.core.c.a.xj().Q("tb_user_profile", TbadkCoreApplication.getCurrentAccountName());
    }

    private void bqJ() {
        if (this.cQK == null) {
            this.cQK = new b("profileStat");
            this.cQK.start();
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }
}

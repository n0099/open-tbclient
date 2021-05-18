package com.baidu.tieba.setting.model;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.R;
import com.baidu.tieba.person.ProfileHttpResponseMessage;
import com.baidu.tieba.person.ProfileRequestMessage;
import com.baidu.tieba.person.ProfileSocketResponseMessage;
import com.baidu.tieba.setting.more.MoreActivity;
import com.baidu.tieba.setting.person.PersonPostListData;
import com.squareup.wire.Wire;
import d.a.c.e.d.l;
import tbclient.Profile.DataRes;
import tbclient.Profile.NicknameInfo;
import tbclient.Profile.ProfileResIdl;
/* loaded from: classes5.dex */
public class MoreDiscoveryModel extends BdBaseModel<MoreActivity> {
    public static final int GET_DATA_FROM_DB = 2;
    public static final int GET_DATA_FROM_NET = 1;

    /* renamed from: e  reason: collision with root package name */
    public UserData f20469e;

    /* renamed from: f  reason: collision with root package name */
    public NicknameInfo f20470f;

    /* renamed from: g  reason: collision with root package name */
    public final Context f20471g;

    /* renamed from: h  reason: collision with root package name */
    public Handler f20472h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.k0.d3.j0.b f20473i;
    public boolean j;
    public d.a.c.c.g.a k;

    /* loaded from: classes5.dex */
    public class a extends d.a.c.c.g.a {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z = responsedMessage instanceof ProfileSocketResponseMessage;
            if (z || (responsedMessage instanceof ProfileHttpResponseMessage)) {
                if (responsedMessage.getOrginalMessage() == null || MoreDiscoveryModel.this.getUniqueId() == null || MoreDiscoveryModel.this.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                    if (z) {
                        ProfileSocketResponseMessage profileSocketResponseMessage = (ProfileSocketResponseMessage) responsedMessage;
                        if (MoreDiscoveryModel.this.f20473i != null) {
                            MoreDiscoveryModel.this.f20473i.b(false, !responsedMessage.hasError(), profileSocketResponseMessage.getError(), profileSocketResponseMessage.getErrorString(), profileSocketResponseMessage.getDownSize(), 0L, profileSocketResponseMessage.getCostTime());
                            MoreDiscoveryModel.this.f20473i = null;
                        }
                        MoreDiscoveryModel.this.D(profileSocketResponseMessage);
                    }
                    if (responsedMessage instanceof ProfileHttpResponseMessage) {
                        ProfileHttpResponseMessage profileHttpResponseMessage = (ProfileHttpResponseMessage) responsedMessage;
                        if (MoreDiscoveryModel.this.f20473i != null) {
                            MoreDiscoveryModel.this.f20473i.b(true, !responsedMessage.hasError(), profileHttpResponseMessage.getError(), profileHttpResponseMessage.getErrorString(), profileHttpResponseMessage.getDownSize(), profileHttpResponseMessage.getCostTime(), 0L);
                            MoreDiscoveryModel.this.f20473i = null;
                        }
                        MoreDiscoveryModel.this.C(profileHttpResponseMessage);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements l.a<byte[]> {

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                MoreDiscoveryModel.this.mLoadDataMode = 2;
                MoreDiscoveryModel.this.setErrorString(null);
                MoreDiscoveryModel.this.mLoadDataCallBack.c(Boolean.TRUE);
            }
        }

        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.d.l.a
        /* renamed from: b */
        public void a(String str, byte[] bArr) {
            if (bArr != null) {
                boolean z = true;
                try {
                    MoreDiscoveryModel.this.F(((ProfileResIdl) new Wire(new Class[0]).parseFrom(bArr, ProfileResIdl.class)).data);
                } catch (Exception unused) {
                    z = false;
                }
                if (z) {
                    MoreDiscoveryModel.this.f20472h.post(new a());
                }
            }
            MoreDiscoveryModel.this.j = false;
        }
    }

    public MoreDiscoveryModel(MoreActivity moreActivity) {
        super(moreActivity.getPageContext());
        this.f20472h = null;
        this.f20473i = null;
        this.j = false;
        this.k = new a(CmdConfigHttp.PROFILE_HTTP_CMD, 303012);
        this.f20469e = null;
        this.f20471g = moreActivity.getPageContext().getContext();
        this.f20472h = new Handler(Looper.getMainLooper());
        this.f20473i = new d.a.k0.d3.j0.b("profileStat");
        registerListener(this.k);
    }

    public void A() {
        x().f("profile_cache_key", new b());
    }

    public void B(boolean z, boolean z2) {
        if (this.j) {
            return;
        }
        this.j = true;
        ProfileRequestMessage profileRequestMessage = new ProfileRequestMessage();
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            profileRequestMessage.set_uid(Long.valueOf(d.a.c.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L)));
        }
        if (z) {
            A();
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
        I();
        sendMessage(profileRequestMessage);
    }

    public void C(ProfileHttpResponseMessage profileHttpResponseMessage) {
        this.j = false;
        if (profileHttpResponseMessage != null) {
            G(profileHttpResponseMessage);
            E(profileHttpResponseMessage.hasError(), profileHttpResponseMessage.getErrorString(), profileHttpResponseMessage.isFrom_db(), profileHttpResponseMessage.isError_hint());
        }
    }

    public void D(ProfileSocketResponseMessage profileSocketResponseMessage) {
        this.j = false;
        if (profileSocketResponseMessage != null) {
            H(profileSocketResponseMessage);
            E(profileSocketResponseMessage.hasError(), profileSocketResponseMessage.getErrorString(), profileSocketResponseMessage.isFrom_db(), profileSocketResponseMessage.isError_hint());
        }
    }

    public void E(boolean z, String str, boolean z2, boolean z3) {
        if (!z) {
            UserData user = getUser();
            if (user != null) {
                setUser(user);
            }
            d.a.j0.z.b.a().e(getUser());
            this.mLoadDataMode = 1;
            this.mLoadDataCallBack.c(Boolean.TRUE);
            return;
        }
        if (z3) {
            setErrorString(str);
        } else {
            setErrorString(this.f20471g.getString(R.string.neterror));
        }
        this.mLoadDataMode = 1;
        this.mLoadDataCallBack.c(Boolean.FALSE);
    }

    public void F(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        try {
            UserData userData = new UserData();
            this.f20469e = userData;
            userData.parserProtobuf(dataRes.user);
            this.f20470f = dataRes.nickname_info;
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void G(ProfileHttpResponseMessage profileHttpResponseMessage) {
        if (profileHttpResponseMessage == null) {
            return;
        }
        try {
            UserData userData = new UserData();
            this.f20469e = userData;
            userData.parserProtobuf(profileHttpResponseMessage.GetUser());
            this.f20470f = profileHttpResponseMessage.getNicknameInfo();
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
        new PersonPostListData().parserData(profileHttpResponseMessage);
    }

    public void H(ProfileSocketResponseMessage profileSocketResponseMessage) {
        if (profileSocketResponseMessage == null) {
            return;
        }
        try {
            UserData userData = new UserData();
            this.f20469e = userData;
            userData.parserProtobuf(profileSocketResponseMessage.GetUser());
            this.f20470f = profileSocketResponseMessage.getNicknameInfo();
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
        new PersonPostListData().parserData(profileSocketResponseMessage);
    }

    public final void I() {
        if (this.f20473i == null) {
            d.a.k0.d3.j0.b bVar = new d.a.k0.d3.j0.b("profileStat");
            this.f20473i = bVar;
            bVar.f();
        }
    }

    public void J(String str) {
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public UserData getUser() {
        return this.f20469e;
    }

    public void setUser(UserData userData) {
        this.f20469e = userData;
    }

    public final l<byte[]> x() {
        return d.a.j0.r.r.a.f().e("tb_user_profile", TbadkCoreApplication.getCurrentAccountName());
    }

    public void y(boolean z, boolean z2) {
        cancelMessage();
        B(z, z2);
    }

    public NicknameInfo z() {
        return this.f20470f;
    }
}

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
import d.b.b.e.d.l;
import tbclient.Profile.DataRes;
import tbclient.Profile.NicknameInfo;
import tbclient.Profile.ProfileResIdl;
/* loaded from: classes5.dex */
public class MoreDiscoveryModel extends BdBaseModel<MoreActivity> {
    public static final int GET_DATA_FROM_DB = 2;
    public static final int GET_DATA_FROM_NET = 1;

    /* renamed from: e  reason: collision with root package name */
    public UserData f20977e;

    /* renamed from: f  reason: collision with root package name */
    public NicknameInfo f20978f;

    /* renamed from: g  reason: collision with root package name */
    public final Context f20979g;

    /* renamed from: h  reason: collision with root package name */
    public Handler f20980h;
    public d.b.i0.c3.j0.b i;
    public boolean j;
    public d.b.b.c.g.a k;

    /* loaded from: classes5.dex */
    public class a extends d.b.b.c.g.a {
        public a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.b.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z = responsedMessage instanceof ProfileSocketResponseMessage;
            if (z || (responsedMessage instanceof ProfileHttpResponseMessage)) {
                if (responsedMessage.getOrginalMessage() == null || MoreDiscoveryModel.this.getUniqueId() == null || MoreDiscoveryModel.this.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                    if (z) {
                        ProfileSocketResponseMessage profileSocketResponseMessage = (ProfileSocketResponseMessage) responsedMessage;
                        if (MoreDiscoveryModel.this.i != null) {
                            MoreDiscoveryModel.this.i.b(false, !responsedMessage.hasError(), profileSocketResponseMessage.getError(), profileSocketResponseMessage.getErrorString(), profileSocketResponseMessage.getDownSize(), 0L, profileSocketResponseMessage.getCostTime());
                            MoreDiscoveryModel.this.i = null;
                        }
                        MoreDiscoveryModel.this.D(profileSocketResponseMessage);
                    }
                    if (responsedMessage instanceof ProfileHttpResponseMessage) {
                        ProfileHttpResponseMessage profileHttpResponseMessage = (ProfileHttpResponseMessage) responsedMessage;
                        if (MoreDiscoveryModel.this.i != null) {
                            MoreDiscoveryModel.this.i.b(true, !responsedMessage.hasError(), profileHttpResponseMessage.getError(), profileHttpResponseMessage.getErrorString(), profileHttpResponseMessage.getDownSize(), profileHttpResponseMessage.getCostTime(), 0L);
                            MoreDiscoveryModel.this.i = null;
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
        @Override // d.b.b.e.d.l.a
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
                    MoreDiscoveryModel.this.f20980h.post(new a());
                }
            }
            MoreDiscoveryModel.this.j = false;
        }
    }

    public MoreDiscoveryModel(MoreActivity moreActivity) {
        super(moreActivity.getPageContext());
        this.f20980h = null;
        this.i = null;
        this.j = false;
        this.k = new a(CmdConfigHttp.PROFILE_HTTP_CMD, 303012);
        this.f20977e = null;
        this.f20979g = moreActivity.getPageContext().getContext();
        this.f20980h = new Handler(Looper.getMainLooper());
        this.i = new d.b.i0.c3.j0.b("profileStat");
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
            profileRequestMessage.set_uid(Long.valueOf(d.b.b.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L)));
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
            d.b.h0.z.b.a().e(getUser());
            this.mLoadDataMode = 1;
            this.mLoadDataCallBack.c(Boolean.TRUE);
            return;
        }
        if (z3) {
            setErrorString(str);
        } else {
            setErrorString(this.f20979g.getString(R.string.neterror));
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
            this.f20977e = userData;
            userData.parserProtobuf(dataRes.user);
            this.f20978f = dataRes.nickname_info;
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
            this.f20977e = userData;
            userData.parserProtobuf(profileHttpResponseMessage.GetUser());
            this.f20978f = profileHttpResponseMessage.getNicknameInfo();
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
            this.f20977e = userData;
            userData.parserProtobuf(profileSocketResponseMessage.GetUser());
            this.f20978f = profileSocketResponseMessage.getNicknameInfo();
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
        new PersonPostListData().parserData(profileSocketResponseMessage);
    }

    public final void I() {
        if (this.i == null) {
            d.b.i0.c3.j0.b bVar = new d.b.i0.c3.j0.b("profileStat");
            this.i = bVar;
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
        return this.f20977e;
    }

    public void setUser(UserData userData) {
        this.f20977e = userData;
    }

    public final l<byte[]> x() {
        return d.b.h0.r.r.a.f().e("tb_user_profile", TbadkCoreApplication.getCurrentAccountName());
    }

    public void y(boolean z, boolean z2) {
        cancelMessage();
        B(z, z2);
    }

    public NicknameInfo z() {
        return this.f20978f;
    }
}

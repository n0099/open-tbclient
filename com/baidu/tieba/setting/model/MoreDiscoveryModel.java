package com.baidu.tieba.setting.model;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.core.view.InputDeviceCompat;
import c.a.e.a.f;
import c.a.e.e.d.l;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.R;
import com.baidu.tieba.person.ProfileHttpResponseMessage;
import com.baidu.tieba.person.ProfileRequestMessage;
import com.baidu.tieba.person.ProfileSocketResponseMessage;
import com.baidu.tieba.setting.more.MoreActivity;
import com.baidu.tieba.setting.person.PersonPostListData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.Profile.DataRes;
import tbclient.Profile.NicknameInfo;
import tbclient.Profile.ProfileResIdl;
/* loaded from: classes7.dex */
public class MoreDiscoveryModel extends BdBaseModel<MoreActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int GET_DATA_FROM_DB = 2;
    public static final int GET_DATA_FROM_NET = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public UserData f56333e;

    /* renamed from: f  reason: collision with root package name */
    public NicknameInfo f56334f;

    /* renamed from: g  reason: collision with root package name */
    public final Context f56335g;

    /* renamed from: h  reason: collision with root package name */
    public Handler f56336h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.p0.i3.j0.b f56337i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f56338j;
    public c.a.e.c.g.a k;

    /* loaded from: classes7.dex */
    public class a extends c.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MoreDiscoveryModel f56339a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(MoreDiscoveryModel moreDiscoveryModel, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {moreDiscoveryModel, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56339a = moreDiscoveryModel;
        }

        @Override // c.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                boolean z = responsedMessage instanceof ProfileSocketResponseMessage;
                if (z || (responsedMessage instanceof ProfileHttpResponseMessage)) {
                    if (responsedMessage.getOrginalMessage() == null || this.f56339a.getUniqueId() == null || this.f56339a.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                        if (z) {
                            ProfileSocketResponseMessage profileSocketResponseMessage = (ProfileSocketResponseMessage) responsedMessage;
                            if (this.f56339a.f56337i != null) {
                                this.f56339a.f56337i.b(false, !responsedMessage.hasError(), profileSocketResponseMessage.getError(), profileSocketResponseMessage.getErrorString(), profileSocketResponseMessage.getDownSize(), 0L, profileSocketResponseMessage.getCostTime());
                                this.f56339a.f56337i = null;
                            }
                            this.f56339a.H(profileSocketResponseMessage);
                        }
                        if (responsedMessage instanceof ProfileHttpResponseMessage) {
                            ProfileHttpResponseMessage profileHttpResponseMessage = (ProfileHttpResponseMessage) responsedMessage;
                            if (this.f56339a.f56337i != null) {
                                this.f56339a.f56337i.b(true, !responsedMessage.hasError(), profileHttpResponseMessage.getError(), profileHttpResponseMessage.getErrorString(), profileHttpResponseMessage.getDownSize(), profileHttpResponseMessage.getCostTime(), 0L);
                                this.f56339a.f56337i = null;
                            }
                            this.f56339a.G(profileHttpResponseMessage);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements l.a<byte[]> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MoreDiscoveryModel f56340a;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f56341e;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f56341e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f56341e.f56340a.mLoadDataMode = 2;
                    this.f56341e.f56340a.setErrorString(null);
                    this.f56341e.f56340a.mLoadDataCallBack.c(Boolean.TRUE);
                }
            }
        }

        public b(MoreDiscoveryModel moreDiscoveryModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {moreDiscoveryModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56340a = moreDiscoveryModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e.e.d.l.a
        /* renamed from: b */
        public void a(String str, byte[] bArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bArr) == null) {
                if (bArr != null) {
                    boolean z = true;
                    try {
                        this.f56340a.J(((ProfileResIdl) new Wire(new Class[0]).parseFrom(bArr, ProfileResIdl.class)).data);
                    } catch (Exception unused) {
                        z = false;
                    }
                    if (z) {
                        this.f56340a.f56336h.post(new a(this));
                    }
                }
                this.f56340a.f56338j = false;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MoreDiscoveryModel(MoreActivity moreActivity) {
        super(moreActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {moreActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f56336h = null;
        this.f56337i = null;
        this.f56338j = false;
        this.k = new a(this, CmdConfigHttp.PROFILE_HTTP_CMD, 303012);
        this.f56333e = null;
        this.f56335g = moreActivity.getPageContext().getContext();
        this.f56336h = new Handler(Looper.getMainLooper());
        this.f56337i = new c.a.p0.i3.j0.b("profileStat");
        registerListener(this.k);
    }

    public final l<byte[]> B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? c.a.o0.s.r.a.f().e("tb_user_profile", TbadkCoreApplication.getCurrentAccountName()) : (l) invokeV.objValue;
    }

    public void C(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            cancelMessage();
            F(z, z2);
        }
    }

    public NicknameInfo D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f56334f : (NicknameInfo) invokeV.objValue;
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            B().f("profile_cache_key", new b(this));
        }
    }

    public void F(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || this.f56338j) {
            return;
        }
        this.f56338j = true;
        ProfileRequestMessage profileRequestMessage = new ProfileRequestMessage();
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            profileRequestMessage.set_uid(Long.valueOf(c.a.e.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L)));
        }
        if (z) {
            E();
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
        M();
        sendMessage(profileRequestMessage);
    }

    public void G(ProfileHttpResponseMessage profileHttpResponseMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, profileHttpResponseMessage) == null) {
            this.f56338j = false;
            if (profileHttpResponseMessage != null) {
                K(profileHttpResponseMessage);
                I(profileHttpResponseMessage.hasError(), profileHttpResponseMessage.getErrorString(), profileHttpResponseMessage.isFrom_db(), profileHttpResponseMessage.isError_hint());
            }
        }
    }

    public void H(ProfileSocketResponseMessage profileSocketResponseMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, profileSocketResponseMessage) == null) {
            this.f56338j = false;
            if (profileSocketResponseMessage != null) {
                L(profileSocketResponseMessage);
                I(profileSocketResponseMessage.hasError(), profileSocketResponseMessage.getErrorString(), profileSocketResponseMessage.isFrom_db(), profileSocketResponseMessage.isError_hint());
            }
        }
    }

    public void I(boolean z, String str, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), str, Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            if (!z) {
                UserData user = getUser();
                if (user != null) {
                    setUser(user);
                }
                c.a.o0.a0.b.a().e(getUser());
                this.mLoadDataMode = 1;
                this.mLoadDataCallBack.c(Boolean.TRUE);
                return;
            }
            if (z3) {
                setErrorString(str);
            } else {
                setErrorString(this.f56335g.getString(R.string.neterror));
            }
            this.mLoadDataMode = 1;
            this.mLoadDataCallBack.c(Boolean.FALSE);
        }
    }

    public void J(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dataRes) == null) || dataRes == null) {
            return;
        }
        try {
            UserData userData = new UserData();
            this.f56333e = userData;
            userData.parserProtobuf(dataRes.user);
            this.f56334f = dataRes.nickname_info;
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void K(ProfileHttpResponseMessage profileHttpResponseMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, profileHttpResponseMessage) == null) || profileHttpResponseMessage == null) {
            return;
        }
        try {
            UserData userData = new UserData();
            this.f56333e = userData;
            userData.parserProtobuf(profileHttpResponseMessage.GetUser());
            this.f56334f = profileHttpResponseMessage.getNicknameInfo();
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
        new PersonPostListData().parserData(profileHttpResponseMessage);
    }

    public void L(ProfileSocketResponseMessage profileSocketResponseMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, profileSocketResponseMessage) == null) || profileSocketResponseMessage == null) {
            return;
        }
        try {
            UserData userData = new UserData();
            this.f56333e = userData;
            userData.parserProtobuf(profileSocketResponseMessage.GetUser());
            this.f56334f = profileSocketResponseMessage.getNicknameInfo();
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
        new PersonPostListData().parserData(profileSocketResponseMessage);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void M() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && this.f56337i == null) {
            c.a.p0.i3.j0.b bVar = new c.a.p0.i3.j0.b("profileStat");
            this.f56337i = bVar;
            bVar.f();
        }
    }

    public void N(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public UserData getUser() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f56333e : (UserData) invokeV.objValue;
    }

    public void setUser(UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, userData) == null) {
            this.f56333e = userData;
        }
    }
}

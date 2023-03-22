package com.baidu.tieba.setting.model;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.R;
import com.baidu.tieba.a9;
import com.baidu.tieba.gg;
import com.baidu.tieba.he5;
import com.baidu.tieba.ic9;
import com.baidu.tieba.me;
import com.baidu.tieba.person.ProfileHttpResponseMessage;
import com.baidu.tieba.person.ProfileRequestMessage;
import com.baidu.tieba.person.ProfileSocketResponseMessage;
import com.baidu.tieba.setting.more.MoreActivity;
import com.baidu.tieba.setting.person.PersonPostListData;
import com.baidu.tieba.yz4;
import com.baidu.tieba.za;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.Anti;
import tbclient.Profile.DataRes;
import tbclient.Profile.NicknameInfo;
import tbclient.Profile.ProfileResIdl;
/* loaded from: classes6.dex */
public class MoreDiscoveryModel extends BdBaseModel<MoreActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int GET_DATA_FROM_DB = 2;
    public static final int GET_DATA_FROM_NET = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public UserData a;
    public NicknameInfo b;
    public final Context c;
    public Handler d;
    public ic9 e;
    public boolean f;
    public za g;

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void i0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes6.dex */
    public class b implements me.a<byte[]> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MoreDiscoveryModel a;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                    return;
                }
                this.a.a.mLoadDataMode = 2;
                this.a.a.setErrorString(null);
                this.a.a.mLoadDataCallBack.c(Boolean.TRUE);
            }
        }

        public b(MoreDiscoveryModel moreDiscoveryModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {moreDiscoveryModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = moreDiscoveryModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.me.a
        /* renamed from: b */
        public void a(String str, byte[] bArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bArr) == null) {
                if (bArr != null) {
                    boolean z = true;
                    try {
                        this.a.e0(((ProfileResIdl) new Wire(new Class[0]).parseFrom(bArr, ProfileResIdl.class)).data);
                    } catch (Exception unused) {
                        z = false;
                    }
                    if (z) {
                        this.a.d.post(new a(this));
                    }
                }
                this.a.f = false;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a extends za {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MoreDiscoveryModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(MoreDiscoveryModel moreDiscoveryModel, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {moreDiscoveryModel, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = moreDiscoveryModel;
        }

        @Override // com.baidu.tieba.za
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                boolean z = responsedMessage instanceof ProfileSocketResponseMessage;
                if (!z && !(responsedMessage instanceof ProfileHttpResponseMessage)) {
                    return;
                }
                if (responsedMessage.getOrginalMessage() != null && this.a.getUniqueId() != null && this.a.getUniqueId() != responsedMessage.getOrginalMessage().getTag()) {
                    return;
                }
                if (z) {
                    ProfileSocketResponseMessage profileSocketResponseMessage = (ProfileSocketResponseMessage) responsedMessage;
                    if (this.a.e != null) {
                        this.a.e.b(false, !responsedMessage.hasError(), profileSocketResponseMessage.getError(), profileSocketResponseMessage.getErrorString(), profileSocketResponseMessage.getDownSize(), 0L, profileSocketResponseMessage.getCostTime());
                        this.a.e = null;
                    }
                    this.a.c0(profileSocketResponseMessage);
                }
                if (responsedMessage instanceof ProfileHttpResponseMessage) {
                    ProfileHttpResponseMessage profileHttpResponseMessage = (ProfileHttpResponseMessage) responsedMessage;
                    if (this.a.e != null) {
                        this.a.e.b(true, !responsedMessage.hasError(), profileHttpResponseMessage.getError(), profileHttpResponseMessage.getErrorString(), profileHttpResponseMessage.getDownSize(), profileHttpResponseMessage.getCostTime(), 0L);
                        this.a.e = null;
                    }
                    this.a.b0(profileHttpResponseMessage);
                }
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((a9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = null;
        this.e = null;
        this.f = false;
        this.g = new a(this, CmdConfigHttp.PROFILE_HTTP_CMD, 303012);
        this.a = null;
        this.c = moreActivity.getPageContext().getContext();
        this.d = new Handler(Looper.getMainLooper());
        this.e = new ic9("profileStat");
        registerListener(this.g);
    }

    public void b0(ProfileHttpResponseMessage profileHttpResponseMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, profileHttpResponseMessage) == null) {
            this.f = false;
            if (profileHttpResponseMessage != null) {
                f0(profileHttpResponseMessage);
                d0(profileHttpResponseMessage.hasError(), profileHttpResponseMessage.getErrorString(), profileHttpResponseMessage.isFrom_db(), profileHttpResponseMessage.isError_hint());
            }
        }
    }

    public void c0(ProfileSocketResponseMessage profileSocketResponseMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, profileSocketResponseMessage) == null) {
            this.f = false;
            if (profileSocketResponseMessage != null) {
                g0(profileSocketResponseMessage);
                d0(profileSocketResponseMessage.hasError(), profileSocketResponseMessage.getErrorString(), profileSocketResponseMessage.isFrom_db(), profileSocketResponseMessage.isError_hint());
            }
        }
    }

    public void e0(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, dataRes) != null) || dataRes == null) {
            return;
        }
        try {
            UserData userData = new UserData();
            this.a = userData;
            userData.parserProtobuf(dataRes.user);
            Anti anti = dataRes.anti_stat;
            this.b = dataRes.nickname_info;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void setUser(UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, userData) == null) {
            this.a = userData;
        }
    }

    public void X(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            cancelMessage();
            a0(z, z2);
        }
    }

    public final me<byte[]> W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            yz4.d();
            return yz4.c("tb_user_profile", TbadkCoreApplication.getCurrentAccountName());
        }
        return (me) invokeV.objValue;
    }

    public NicknameInfo Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b;
        }
        return (NicknameInfo) invokeV.objValue;
    }

    public void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            W().f("profile_cache_key", new b(this));
        }
    }

    public UserData getUser() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.a;
        }
        return (UserData) invokeV.objValue;
    }

    public final void h0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && this.e == null) {
            ic9 ic9Var = new ic9("profileStat");
            this.e = ic9Var;
            ic9Var.f();
        }
    }

    public void a0(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) != null) || this.f) {
            return;
        }
        this.f = true;
        ProfileRequestMessage profileRequestMessage = new ProfileRequestMessage();
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            profileRequestMessage.set_uid(Long.valueOf(gg.g(TbadkCoreApplication.getCurrentAccount(), 0L)));
        }
        if (z) {
            Z();
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
        h0();
        sendMessage(profileRequestMessage);
    }

    public void d0(boolean z, String str, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z), str, Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            if (!z) {
                UserData user = getUser();
                if (user != null) {
                    setUser(user);
                }
                he5.d().i(getUser());
                this.mLoadDataMode = 1;
                this.mLoadDataCallBack.c(Boolean.TRUE);
                return;
            }
            if (z3) {
                setErrorString(str);
            } else {
                setErrorString(this.c.getString(R.string.obfuscated_res_0x7f0f0d1f));
            }
            this.mLoadDataMode = 1;
            this.mLoadDataCallBack.c(Boolean.FALSE);
        }
    }

    public void f0(ProfileHttpResponseMessage profileHttpResponseMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048586, this, profileHttpResponseMessage) != null) || profileHttpResponseMessage == null) {
            return;
        }
        try {
            UserData userData = new UserData();
            this.a = userData;
            userData.parserProtobuf(profileHttpResponseMessage.GetUser());
            profileHttpResponseMessage.GetAntiStat();
            this.b = profileHttpResponseMessage.getNicknameInfo();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        new PersonPostListData().parserData(profileHttpResponseMessage);
    }

    public void g0(ProfileSocketResponseMessage profileSocketResponseMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048587, this, profileSocketResponseMessage) != null) || profileSocketResponseMessage == null) {
            return;
        }
        try {
            UserData userData = new UserData();
            this.a = userData;
            userData.parserProtobuf(profileSocketResponseMessage.GetUser());
            profileSocketResponseMessage.GetAntiStat();
            this.b = profileSocketResponseMessage.getNicknameInfo();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        new PersonPostListData().parserData(profileSocketResponseMessage);
    }
}

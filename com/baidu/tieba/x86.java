package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.callback.AccountRealNameCallback;
import com.baidu.sapi2.callback.SapiCallback;
import com.baidu.sapi2.dto.RealNameDTO;
import com.baidu.sapi2.result.AccountRealNameResult;
import com.baidu.sapi2.result.CheckUserFaceIdResult;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation;
import com.baidu.tieba.n44;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
@Singleton
@Service
/* loaded from: classes8.dex */
public class x86 extends ActivityDelegation implements k84 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements SapiCallback<CheckUserFaceIdResult> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n44.d a;
        public final /* synthetic */ x86 b;

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            }
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            }
        }

        public a(x86 x86Var, n44.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x86Var, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = x86Var;
            this.a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        /* renamed from: a */
        public void onFailure(CheckUserFaceIdResult checkUserFaceIdResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, checkUserFaceIdResult) == null) {
                this.a.onFail(checkUserFaceIdResult.getResultMsg());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        /* renamed from: b */
        public void onSuccess(CheckUserFaceIdResult checkUserFaceIdResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, checkUserFaceIdResult) == null) {
                if (!"advanced_cert_face_match".equals(checkUserFaceIdResult.action) && !"cert_face_match".equals(checkUserFaceIdResult.action)) {
                    this.b.f(null, null, this.a);
                } else {
                    this.a.onSuccess();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends AccountRealNameCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n44.d a;

        public b(x86 x86Var, n44.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x86Var, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // com.baidu.sapi2.callback.AccountRealNameCallback
        public void onFinish(AccountRealNameResult accountRealNameResult) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, accountRealNameResult) == null) {
                super.onFinish(accountRealNameResult);
                if (accountRealNameResult.getResultCode() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    this.a.onSuccess();
                } else {
                    this.a.onFail(accountRealNameResult.getResultMsg());
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements n44.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x86 a;

        public c(x86 x86Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x86Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x86Var;
        }

        @Override // com.baidu.tieba.n44.d
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.a.mResult.putString("bundle_fail", "real_name_success");
                this.a.finish();
            }
        }

        @Override // com.baidu.tieba.n44.d
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.mResult.putString("bundle_success", "real_name_success");
                this.a.finish();
            }
        }
    }

    public x86() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public boolean onExec() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            f(getAgent(), co3.g(this.mParams, "swanAppId"), new c(this));
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.k84
    public void b(n44.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) {
            if (SapiAccountManager.getInstance().getSapiConfiguration() == null) {
                dVar.onFail("pass没有初始化");
                return;
            }
            SapiAccount session = SapiAccountManager.getInstance().getSession();
            HashMap hashMap = new HashMap();
            hashMap.put("scene", "baidugame");
            SapiAccountManager.getInstance().getAccountService().checkUserFaceId(new a(this, dVar), session.bduss, hashMap);
        }
    }

    public final void f(Context context, String str, n44.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, dVar) == null) {
            if (SapiAccountManager.getInstance().getSapiConfiguration() == null) {
                dVar.onFail("pass没有初始化");
                return;
            }
            RealNameDTO realNameDTO = new RealNameDTO();
            realNameDTO.bduss = SapiAccountManager.getInstance().getSession().bduss;
            realNameDTO.scene = "baidugame";
            realNameDTO.needCbKey = true;
            PassportSDK.getInstance().loadAccountRealName(qw2.T().getActivity(), new b(this, dVar), realNameDTO);
        }
    }
}

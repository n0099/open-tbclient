package com.baidu.tieba;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.callback.RegisterUserFaceIDCallback;
import com.baidu.sapi2.callback.SapiCallback;
import com.baidu.sapi2.callback.VerifyUserFaceIDCallback;
import com.baidu.sapi2.dto.FaceBaseDTO;
import com.baidu.sapi2.dto.FaceIDRegDTO;
import com.baidu.sapi2.dto.FaceIDVerifyDTO;
import com.baidu.sapi2.result.CheckUserFaceIdResult;
import com.baidu.sapi2.result.RealNameFaceIDResult;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.result.UnRealNameFaceIDResult;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class uv7 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile uv7 c;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity a;
    public e b;

    /* loaded from: classes6.dex */
    public interface e {
        void a(boolean z, String str);

        void b(boolean z, boolean z2, String str);

        void c();

        void onFail();
    }

    /* loaded from: classes6.dex */
    public class a implements SapiCallback<CheckUserFaceIdResult> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiAccount a;
        public final /* synthetic */ uv7 b;

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

        public a(uv7 uv7Var, SapiAccount sapiAccount) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uv7Var, sapiAccount};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = uv7Var;
            this.a = sapiAccount;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        /* renamed from: a */
        public void onFailure(CheckUserFaceIdResult checkUserFaceIdResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, checkUserFaceIdResult) == null) {
                if (checkUserFaceIdResult != null) {
                    xi.P(TbadkCoreApplication.getInst(), checkUserFaceIdResult.getResultMsg());
                }
                if (this.b.b != null) {
                    this.b.b.onFail();
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        /* renamed from: b */
        public void onSuccess(CheckUserFaceIdResult checkUserFaceIdResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, checkUserFaceIdResult) == null) {
                int i = checkUserFaceIdResult.status;
                if (i == 1) {
                    if (!TextUtils.isEmpty(checkUserFaceIdResult.livingUname)) {
                        BdLog.e("非实名人脸验证流程");
                        this.b.e(false, false, FaceBaseDTO.BUSINESS_SENCE_REALNAME_FACE, checkUserFaceIdResult.livingUname, this.a.bduss);
                        return;
                    }
                    BdLog.e("实名人脸验证流程");
                    this.b.e(false, false, FaceBaseDTO.BUSINESS_SENCE_REALNAME_FACE, "", this.a.bduss);
                } else if (i == 2) {
                    BdLog.e("人脸注册流程");
                    this.b.j(false, false, FaceBaseDTO.BUSINESS_SENCE_REALNAME_FACE, checkUserFaceIdResult.authsid, checkUserFaceIdResult.livingUname, checkUserFaceIdResult.authWidgetURL);
                } else if (i == 3) {
                    BdLog.e("人脸验证不可用");
                    xi.P(TbadkCoreApplication.getInst(), "刷脸功能暂不可用，请您稍后再试");
                    if (this.b.b != null) {
                        this.b.b.c();
                    }
                } else {
                    BdLog.e("人脸验证不可用");
                    xi.P(TbadkCoreApplication.getInst(), "刷脸功能暂不可用，请您稍后再试");
                    if (this.b.b != null) {
                        this.b.b.c();
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends VerifyUserFaceIDCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ uv7 c;

        public b(uv7 uv7Var, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uv7Var, Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = uv7Var;
            this.a = z;
            this.b = z2;
        }

        @Override // com.baidu.sapi2.callback.FaceIDCallback
        public void onFailure(SapiResult sapiResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, sapiResult) == null) {
                if (sapiResult != null && sapiResult.getResultCode() != -204 && !StringHelper.equals("用户取消操作", sapiResult.getResultMsg())) {
                    xi.P(TbadkCoreApplication.getInst(), sapiResult.getResultMsg());
                }
                if (this.c.b == null) {
                    return;
                }
                this.c.b.b(sapiResult instanceof RealNameFaceIDResult, false, null);
            }
        }

        @Override // com.baidu.sapi2.callback.FaceIDCallback
        public void onSuccess(SapiResult sapiResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sapiResult) == null) {
                if (sapiResult instanceof RealNameFaceIDResult) {
                    RealNameFaceIDResult realNameFaceIDResult = (RealNameFaceIDResult) sapiResult;
                    BdLog.d("实名人脸验证成功,callBackKey:" + realNameFaceIDResult.callBackKey + ",authSid:" + realNameFaceIDResult.authSid);
                    xi.P(TbadkCoreApplication.getInst(), "刷脸验证成功");
                    if (this.c.b != null) {
                        this.c.b.b(true, true, realNameFaceIDResult.callBackKey);
                    }
                    if (!this.a) {
                        return;
                    }
                    this.c.h(this.b, realNameFaceIDResult.callBackKey);
                } else if (sapiResult instanceof UnRealNameFaceIDResult) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("非实名人脸验证成功 callBackKey");
                    UnRealNameFaceIDResult unRealNameFaceIDResult = (UnRealNameFaceIDResult) sapiResult;
                    sb.append(unRealNameFaceIDResult.registerResult);
                    BdLog.d(sb.toString());
                    xi.P(TbadkCoreApplication.getInst(), "刷脸验证成功");
                    if (this.c.b != null) {
                        this.c.b.b(false, true, unRealNameFaceIDResult.callBackKey);
                    }
                    if (!this.a) {
                        return;
                    }
                    this.c.h(this.b, unRealNameFaceIDResult.callBackKey);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends RegisterUserFaceIDCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ uv7 c;

        public c(uv7 uv7Var, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uv7Var, Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = uv7Var;
            this.a = z;
            this.b = z2;
        }

        @Override // com.baidu.sapi2.callback.FaceIDCallback
        public void onFailure(SapiResult sapiResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, sapiResult) == null) {
                if (sapiResult != null && sapiResult.getResultCode() != -204 && !StringHelper.equals("用户取消操作", sapiResult.getResultMsg())) {
                    xi.P(TbadkCoreApplication.getInst(), sapiResult.getResultMsg());
                }
                if (this.c.b != null) {
                    this.c.b.a(false, null);
                }
            }
        }

        @Override // com.baidu.sapi2.callback.FaceIDCallback
        public void onSuccess(SapiResult sapiResult) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sapiResult) == null) && (sapiResult instanceof UnRealNameFaceIDResult)) {
                StringBuilder sb = new StringBuilder();
                sb.append("人脸注册结果");
                UnRealNameFaceIDResult unRealNameFaceIDResult = (UnRealNameFaceIDResult) sapiResult;
                sb.append(unRealNameFaceIDResult.registerResult);
                BdLog.d(sb.toString());
                xi.P(TbadkCoreApplication.getInst(), "刷脸注册成功");
                if (this.c.b != null) {
                    this.c.b.a(true, unRealNameFaceIDResult.callBackKey);
                }
                if (!this.a) {
                    return;
                }
                this.c.h(this.b, unRealNameFaceIDResult.callBackKey);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements SapiCallback<SapiResult> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(SapiResult sapiResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, sapiResult) == null) {
            }
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        public d(uv7 uv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(SapiResult sapiResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, sapiResult) == null) {
                BdLog.d("faceLginSwitch onSuccess()" + sapiResult.getResultCode());
            }
        }
    }

    public uv7() {
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

    public static uv7 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (c == null) {
                synchronized (uv7.class) {
                    if (c == null) {
                        c = new uv7();
                    }
                }
            }
            return c;
        }
        return (uv7) invokeV.objValue;
    }

    public void k(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, eVar) == null) {
            this.b = eVar;
        }
    }

    public final void e(boolean z, boolean z2, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str, str2, str3}) == null) {
            FaceIDVerifyDTO faceIDVerifyDTO = new FaceIDVerifyDTO();
            faceIDVerifyDTO.livingUname = str2;
            faceIDVerifyDTO.businessSence = str;
            faceIDVerifyDTO.bduss = str3;
            faceIDVerifyDTO.showGuidePage = false;
            PassportSDK.getInstance().verifyUserFaceId(this.a, new b(this, z, z2), faceIDVerifyDTO);
        }
    }

    public final void f() {
        SapiAccount session;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || (session = SapiAccountManager.getInstance().getSession()) == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("scene", FaceBaseDTO.BUSINESS_SENCE_REALNAME_FACE);
        SapiAccountManager.getInstance().getAccountService().checkUserFaceId(new a(this, session), session.bduss, hashMap);
    }

    public void g(Activity activity, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, activity, eVar) == null) {
            this.a = activity;
            this.b = eVar;
            f();
        }
    }

    public final void h(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048579, this, z, str) == null) {
            SapiAccountManager.getInstance().getAccountService().faceLoginSwitch(new d(this), SapiAccountManager.getInstance().getSession().bduss, !z, str);
        }
    }

    public final void j(boolean z, boolean z2, String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str, str2, str3, str4}) == null) {
            FaceIDRegDTO faceIDRegDTO = new FaceIDRegDTO();
            faceIDRegDTO.authsid = str2;
            faceIDRegDTO.livingUname = str3;
            faceIDRegDTO.businessSence = str;
            faceIDRegDTO.authWidgetURL = str4;
            faceIDRegDTO.showGuidePage = true;
            PassportSDK.getInstance().registerUserFaceID(this.a, new c(this, z, z2), faceIDRegDTO);
        }
    }
}

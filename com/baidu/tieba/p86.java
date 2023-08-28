package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentActivity;
import com.baidu.android.common.util.CommonParam;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.callback.AccountRealNameCallback;
import com.baidu.sapi2.callback.GetTplStokenCallback;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.callback.SmsViewLoginCallback;
import com.baidu.sapi2.callback.VerifyUserFaceIDCallback;
import com.baidu.sapi2.dto.FaceIDVerifyDTO;
import com.baidu.sapi2.dto.RealNameDTO;
import com.baidu.sapi2.result.AccountRealNameResult;
import com.baidu.sapi2.result.GetTplStokenResult;
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.baidu.sapi2.result.RealNameFaceIDResult;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.result.UnRealNameFaceIDResult;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog;
import com.baidu.tieba.ha3;
import com.baidu.tieba.hs3;
import com.baidu.tieba.ls3;
import com.baidu.tieba.pr3;
import com.baidu.tieba.wt3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
@Service
/* loaded from: classes7.dex */
public class p86 implements gs3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ca3 a;

    /* loaded from: classes7.dex */
    public class b extends SmsViewLoginCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppPhoneLoginDialog.g a;
        public final /* synthetic */ Context b;

        /* renamed from: com.baidu.tieba.p86$b$b  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class DialogInterface$OnClickListenerC0435b implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            /* renamed from: com.baidu.tieba.p86$b$b$a */
            /* loaded from: classes7.dex */
            public class a implements pr1 {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DialogInterface$OnClickListenerC0435b a;

                public a(DialogInterface$OnClickListenerC0435b dialogInterface$OnClickListenerC0435b) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {dialogInterface$OnClickListenerC0435b};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = dialogInterface$OnClickListenerC0435b;
                }

                @Override // com.baidu.tieba.pr1
                public void onResult(int i) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                        if (i == 0) {
                            this.a.a.a.onSuccess();
                        } else {
                            this.a.a.a.onFailure();
                        }
                    }
                }
            }

            public DialogInterface$OnClickListenerC0435b(b bVar) {
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

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                    er3.M((FragmentActivity) this.a.b, false, null, new a(this));
                }
            }
        }

        /* loaded from: classes7.dex */
        public class a implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                }
            }

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
                    }
                }
            }
        }

        /* loaded from: classes7.dex */
        public class c implements pr1 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public c(b bVar) {
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

            @Override // com.baidu.tieba.pr1
            public void onResult(int i) {
                SwanAppPhoneLoginDialog.g gVar;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && (gVar = this.a.a) != null) {
                    if (i == 0) {
                        gVar.onSuccess();
                    } else {
                        gVar.onFailure();
                    }
                }
            }
        }

        public b(p86 p86Var, SwanAppPhoneLoginDialog.g gVar, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p86Var, gVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gVar;
            this.b = context;
        }

        @Override // com.baidu.sapi2.callback.SmsViewLoginCallback
        public void onCheckCodeViewHide() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.onCheckCodeViewHide();
            }
        }

        @Override // com.baidu.sapi2.callback.SmsViewLoginCallback
        public void onCheckCodeViewShow() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.onCheckCodeViewShow();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(WebAuthResult webAuthResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, webAuthResult) == null) {
                this.a.onFailure();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(WebAuthResult webAuthResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, webAuthResult) == null) {
                n86.k().v(new c(this));
            }
        }

        @Override // com.baidu.sapi2.callback.SmsViewLoginCallback
        public void onNeedBack(WebAuthResult webAuthResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, webAuthResult) == null) {
                Context context = this.b;
                eo3.a(context, ((FragmentActivity) context).getWindow().getDecorView().getWindowToken());
                String string = this.b.getResources().getString(R.string.obfuscated_res_0x7f0f008d);
                String string2 = this.b.getResources().getString(R.string.obfuscated_res_0x7f0f008f);
                if (webAuthResult.getResultCode() == 12) {
                    string = this.b.getResources().getString(R.string.obfuscated_res_0x7f0f008e);
                    string2 = this.b.getResources().getString(R.string.obfuscated_res_0x7f0f0090);
                }
                ha3.a aVar = new ha3.a(this.b);
                aVar.V(this.b.getResources().getString(R.string.obfuscated_res_0x7f0f0091));
                aVar.x(string);
                aVar.P(string2, new DialogInterface$OnClickListenerC0435b(this));
                aVar.C(this.b.getResources().getString(R.string.obfuscated_res_0x7f0f008c), new a(this));
                aVar.X();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends OneKeyLoginCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lt3 a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ p86 c;

        /* loaded from: classes7.dex */
        public class a implements pr1 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // com.baidu.tieba.pr1
            public void onResult(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                    if (i == 0) {
                        this.a.a.onResult(0);
                    } else {
                        this.a.a.onResult(-1);
                    }
                    c cVar = this.a;
                    cVar.c.q(cVar.b);
                }
            }
        }

        public c(p86 p86Var, lt3 lt3Var, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p86Var, lt3Var, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = p86Var;
            this.a = lt3Var;
            this.b = activity;
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void onFail(OneKeyLoginResult oneKeyLoginResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, oneKeyLoginResult) == null) {
                this.a.onResult(-1);
                this.c.q(this.b);
            }
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void onGuideProcess(OneKeyLoginResult oneKeyLoginResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oneKeyLoginResult) == null) {
                this.a.onResult(-1);
                this.c.q(this.b);
            }
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void onSuccess(OneKeyLoginResult oneKeyLoginResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, oneKeyLoginResult) == null) {
                n86.k().v(new a(this));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a extends GetTplStokenCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pr3.a a;

        public a(p86 p86Var, pr3.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p86Var, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(GetTplStokenResult getTplStokenResult) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, getTplStokenResult) == null) && this.a != null) {
                pr3 pr3Var = new pr3();
                if (getTplStokenResult != null) {
                    pr3Var.b = getTplStokenResult.tplStokenMap;
                    pr3Var.a = getTplStokenResult.getResultCode();
                    getTplStokenResult.getResultMsg();
                    GetTplStokenResult.FailureType failureType = getTplStokenResult.failureType;
                    if (failureType != null) {
                        failureType.name();
                    }
                }
                this.a.a(pr3Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(GetTplStokenResult getTplStokenResult) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048580, this, getTplStokenResult) == null) && this.a != null) {
                pr3 pr3Var = new pr3();
                if (getTplStokenResult != null) {
                    pr3Var.b = getTplStokenResult.tplStokenMap;
                    pr3Var.a = getTplStokenResult.getResultCode();
                    getTplStokenResult.getResultMsg();
                    GetTplStokenResult.FailureType failureType = getTplStokenResult.failureType;
                    if (failureType != null) {
                        failureType.name();
                    }
                }
                this.a.b(pr3Var);
            }
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFinish() {
            pr3.a aVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (aVar = this.a) != null) {
                aVar.onFinish();
            }
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onStart() {
            pr3.a aVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (aVar = this.a) != null) {
                aVar.onStart();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends VerifyUserFaceIDCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fs3 a;

        public d(p86 p86Var, fs3 fs3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p86Var, fs3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fs3Var;
        }

        @Override // com.baidu.sapi2.callback.FaceIDCallback
        public void onFailure(SapiResult sapiResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, sapiResult) == null) {
                this.a.onFailure(sapiResult.getResultMsg());
            }
        }

        @Override // com.baidu.sapi2.callback.FaceIDCallback
        public void onSuccess(SapiResult sapiResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sapiResult) == null) {
                ds3 ds3Var = new ds3();
                if (sapiResult instanceof RealNameFaceIDResult) {
                    ds3Var.a = ((RealNameFaceIDResult) sapiResult).callBackKey;
                    this.a.a(ds3Var);
                } else if (sapiResult instanceof UnRealNameFaceIDResult) {
                    ds3Var.a = ((UnRealNameFaceIDResult) sapiResult).registerResult;
                    this.a.a(ds3Var);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends AccountRealNameCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fs3 a;

        public e(p86 p86Var, fs3 fs3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p86Var, fs3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fs3Var;
        }

        @Override // com.baidu.sapi2.callback.AccountRealNameCallback
        public void onFinish(AccountRealNameResult accountRealNameResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, accountRealNameResult) == null) {
                super.onFinish(accountRealNameResult);
                if (accountRealNameResult.getResultCode() == 0) {
                    ds3 ds3Var = new ds3();
                    if (accountRealNameResult.seniorRealNameSuc) {
                        ds3Var.a = accountRealNameResult.callbackkey;
                        this.a.a(ds3Var);
                        return;
                    }
                }
                this.a.onFailure(accountRealNameResult.getResultMsg());
            }
        }
    }

    public p86() {
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

    public static String p(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            return CommonParam.getCUID(context);
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.gs3
    public String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            return rj3.a().getString("bd_box_ptoken", "");
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.gs3
    public String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            return n86.k().n();
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.gs3
    public es3 d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            es3 es3Var = new es3();
            es3Var.a = n86.k().j();
            es3Var.b = n86.k().h();
            return es3Var;
        }
        return (es3) invokeL.objValue;
    }

    @Override // com.baidu.tieba.gs3
    public boolean g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, context)) == null) {
            return n86.k().q();
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.gs3
    public String getBduss(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, context)) == null) {
            return n86.k().i();
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.gs3
    public void h(rr1 rr1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, rr1Var) == null) {
            n86.k().e(rr1Var);
        }
    }

    public void q(Context context) {
        ca3 ca3Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, context) == null) && (context instanceof Activity) && !((Activity) context).isFinishing() && (ca3Var = this.a) != null) {
            ca3Var.dismiss();
        }
    }

    public static String r(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            if (!TextUtils.isEmpty(str) && str.length() > 7) {
                String substring = str.substring(0, 8);
                String substring2 = str.substring(8, str.length());
                String upperCase = SapiUtils.getClientId(context).toUpperCase();
                return substring + jr4.d((substring2 + jr4.d(upperCase.getBytes(), false)).getBytes(), false);
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.gs3
    public void c(Context context, Bundle bundle, pr1 pr1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, bundle, pr1Var) == null) {
            n86.k().r(context, bundle, pr1Var);
        }
    }

    @Override // com.baidu.tieba.gs3
    public void j(Context context, SwanAppPhoneLoginDialog.g gVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, context, gVar, str) == null) {
            PassportSDK.getInstance().startSmsViewLogin(new b(this, gVar, context), str);
        }
    }

    @Override // com.baidu.tieba.gs3
    public void m(Activity activity, String str, lt3 lt3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048589, this, activity, str, lt3Var) == null) {
            s(activity);
            PassportSDK.getInstance().loadOneKeyLogin(activity, r(activity, str), new c(this, lt3Var, activity));
        }
    }

    @Override // com.baidu.tieba.gs3
    public void n(String str, ArrayList<String> arrayList, ls3.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048590, this, str, arrayList, cVar) == null) {
            n86.k().l(str, arrayList, cVar);
        }
    }

    @Override // com.baidu.tieba.gs3
    public void o(pr3.a aVar, String str, List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048591, this, aVar, str, list) == null) {
            SapiAccountManager.getInstance().getAccountService().getTplStoken(new a(this, aVar), str, list);
        }
    }

    @Override // com.baidu.tieba.gs3
    public void e(Activity activity, String str, String str2, fs3 fs3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, activity, str, str2, fs3Var) == null) {
            RealNameDTO realNameDTO = new RealNameDTO();
            realNameDTO.bduss = SapiAccountManager.getInstance().getSession().bduss;
            realNameDTO.scene = str;
            realNameDTO.needCbKey = true;
            PassportSDK.getInstance().loadAccountRealName(activity, new e(this, fs3Var), realNameDTO);
        }
    }

    @Override // com.baidu.tieba.gs3
    public void l(Activity activity, String str, String str2, fs3 fs3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048588, this, activity, str, str2, fs3Var) == null) {
            FaceIDVerifyDTO faceIDVerifyDTO = new FaceIDVerifyDTO();
            faceIDVerifyDTO.businessSence = str;
            faceIDVerifyDTO.bduss = str2;
            PassportSDK.getInstance().verifyUserFaceId(activity, new d(this, fs3Var), faceIDVerifyDTO);
        }
    }

    @Override // com.baidu.tieba.gs3
    public void f(Context context, wt3.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, context, dVar) == null) {
            n86.k().g(context, "1", dVar);
        }
    }

    @Override // com.baidu.tieba.gs3
    public void i(Context context, hs3.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, context, dVar) == null) {
            n86.k().f(context, "1", dVar);
        }
    }

    @Override // com.baidu.tieba.gs3
    public String k(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, context)) == null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("aps_identity", 0);
            String string = sharedPreferences.getString("uid_v3", "");
            if (TextUtils.isEmpty(string)) {
                String p = p(context);
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString("uid_v3", p);
                edit.apply();
                return p;
            }
            return string;
        }
        return (String) invokeL.objValue;
    }

    public final void s(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, context) == null) {
            ca3 ca3Var = new ca3(context, 16973833);
            this.a = ca3Var;
            Window window = ca3Var.getWindow();
            if (window != null) {
                window.setBackgroundDrawableResource(17170445);
                window.setDimAmount(0.0f);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.height = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0700d9);
                attributes.width = -1;
                window.setAttributes(attributes);
            }
            this.a.setCanceledOnTouchOutside(false);
            this.a.setCancelable(false);
            this.a.a(true);
            this.a.setContentView(R.layout.obfuscated_res_0x7f0d05f3);
            View findViewById = this.a.findViewById(R.id.obfuscated_res_0x7f091f9e);
            ProgressBar progressBar = (ProgressBar) this.a.findViewById(R.id.obfuscated_res_0x7f091648);
            TextView textView = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f091757);
            if (findViewById != null) {
                findViewById.setBackground(findViewById.getResources().getDrawable(R.drawable.obfuscated_res_0x7f081102));
            }
            if (progressBar != null) {
                progressBar.setIndeterminateDrawable(progressBar.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080f79));
            }
            if (textView != null) {
                textView.setTextColor(textView.getResources().getColor(R.color.obfuscated_res_0x7f0607c7));
                textView.setText(R.string.obfuscated_res_0x7f0f009d);
            }
            this.a.show();
        }
    }
}

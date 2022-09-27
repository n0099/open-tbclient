package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWorkErr;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import com.baidu.tieba.nu4;
import com.baidu.tieba.u05;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class no8 {
    public static /* synthetic */ Interceptable $ic;
    public static AtomicBoolean a;
    public static List<Integer> b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements nu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nu4 a;
        public final /* synthetic */ u05 b;

        public a(nu4 nu4Var, u05 u05Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nu4Var, u05Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nu4Var;
            this.b = u05Var;
        }

        @Override // com.baidu.tieba.nu4.e
        public void onClick(nu4 nu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nu4Var) == null) {
                this.a.dismiss();
                MessageManager.getInstance().sendMessage(new CustomMessage(2921372, this.b));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements nu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nu4 a;

        public b(nu4 nu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nu4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nu4Var;
        }

        @Override // com.baidu.tieba.nu4.e
        public void onClick(nu4 nu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nu4Var) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static abstract class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
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

        public abstract void a(String str);

        public void b(u05.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
                if (cVar != null && cVar.a) {
                    if (cVar instanceof u05.a) {
                        a(((u05.a) cVar).b);
                        return;
                    } else if (cVar instanceof u05.b) {
                        c(((u05.b) cVar).b);
                        return;
                    } else {
                        e();
                        return;
                    }
                }
                d();
            }
        }

        public abstract void c(String str);

        public abstract void d();

        public abstract void e();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948009298, "Lcom/baidu/tieba/no8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948009298, "Lcom/baidu/tieba/no8;");
                return;
            }
        }
        a = new AtomicBoolean(false);
        b = Arrays.asList(Integer.valueOf((int) NetWorkErr.ERROR_UEG_IDENTITY_VERIFY), Integer.valueOf((int) NetWorkErr.ERROR_UEG_PHONE_VERIFY), Integer.valueOf((int) NetWorkErr.ERROR_UEG_MODIFY_PWD), Integer.valueOf((int) NetWorkErr.ERROR_UEG_FACE_VERIFY), Integer.valueOf((int) NetWorkErr.ERROR_UEG_DOUBLE_CHECK), Integer.valueOf((int) NetWorkErr.ERROR_UEG_BIND_MOBILE));
    }

    public static boolean a(int i, AuthTokenData authTokenData, c cVar) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65537, null, i, authTokenData, cVar)) == null) {
            if (b.contains(Integer.valueOf(i))) {
                if ((i == 3250020 || i == 3250021) && (authTokenData == null || TextUtils.isEmpty(authTokenData.getAuthToken()))) {
                    return false;
                }
                return c(i, authTokenData.getAuthToken(), cVar);
            }
            return false;
        }
        return invokeILL.booleanValue;
    }

    public static boolean b(int i, String str, c cVar) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65538, null, i, str, cVar)) == null) {
            if (b.contains(Integer.valueOf(i))) {
                if ((i == 3250020 || i == 3250021) && TextUtils.isEmpty(str)) {
                    return false;
                }
                return c(i, str, cVar);
            }
            return false;
        }
        return invokeILL.booleanValue;
    }

    public static boolean c(int i, String str, c cVar) {
        InterceptResult invokeILL;
        u05 a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65539, null, i, str, cVar)) == null) {
            if (a.compareAndSet(false, true)) {
                String.valueOf(System.currentTimeMillis());
                if (i == 3250022) {
                    u05 d = u05.d();
                    d.g(cVar);
                    if (cVar != null) {
                        cVar.d();
                    }
                    if (TbadkCoreApplication.getInst().getCurrentActivity() != null) {
                        nu4 nu4Var = new nu4(TbadkCoreApplication.getInst().getCurrentActivity());
                        nu4Var.setMessageId(R.string.obfuscated_res_0x7f0f028b);
                        nu4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0afb, new a(nu4Var, d));
                        nu4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0375, new b(nu4Var));
                        if (TbadkCoreApplication.getInst().getCurrentActivity() instanceof s9) {
                            nu4Var.create(((s9) TbadkCoreApplication.getInst().getCurrentActivity()).getPageContext());
                            nu4Var.show();
                        }
                    }
                } else {
                    if (i == 3250017) {
                        a2 = u05.b();
                    } else if (i == 3250023) {
                        a2 = u05.c();
                    } else if (i == 3250024) {
                        a2 = new u05(4, null);
                    } else {
                        a2 = u05.a(str);
                    }
                    a2.g(cVar);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921372, a2));
                }
                a.set(false);
                return true;
            }
            return false;
        }
        return invokeILL.booleanValue;
    }
}

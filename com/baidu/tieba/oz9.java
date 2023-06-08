package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWorkErr;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import com.baidu.tieba.c55;
import com.baidu.tieba.rc5;
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
/* loaded from: classes7.dex */
public class oz9 {
    public static /* synthetic */ Interceptable $ic;
    public static AtomicBoolean a;
    public static List<Integer> b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements c55.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c55 a;
        public final /* synthetic */ rc5 b;

        public a(c55 c55Var, rc5 rc5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c55Var, rc5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c55Var;
            this.b = rc5Var;
        }

        @Override // com.baidu.tieba.c55.e
        public void onClick(c55 c55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, c55Var) == null) {
                this.a.dismiss();
                MessageManager.getInstance().sendMessage(new CustomMessage(2921372, this.b));
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements c55.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c55 a;

        public b(c55 c55Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c55Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c55Var;
        }

        @Override // com.baidu.tieba.c55.e
        public void onClick(c55 c55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, c55Var) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static abstract class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public abstract void a(String str);

        public abstract void c(String str);

        public abstract void d();

        public abstract void e();

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

        public void b(rc5.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
                if (cVar != null && cVar.a) {
                    if (cVar instanceof rc5.a) {
                        a(((rc5.a) cVar).b);
                        return;
                    } else if (cVar instanceof rc5.b) {
                        c(((rc5.b) cVar).b);
                        return;
                    } else {
                        e();
                        return;
                    }
                }
                d();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948049691, "Lcom/baidu/tieba/oz9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948049691, "Lcom/baidu/tieba/oz9;");
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
                if ((i != 3250020 && i != 3250021) || (authTokenData != null && !TextUtils.isEmpty(authTokenData.getAuthToken()))) {
                    return c(i, authTokenData.getAuthToken(), cVar);
                }
                return false;
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
                if ((i != 3250020 && i != 3250021) || !TextUtils.isEmpty(str)) {
                    return c(i, str, cVar);
                }
                return false;
            }
            return false;
        }
        return invokeILL.booleanValue;
    }

    public static boolean c(int i, String str, c cVar) {
        InterceptResult invokeILL;
        rc5 a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65539, null, i, str, cVar)) == null) {
            if (!a.compareAndSet(false, true)) {
                return false;
            }
            String.valueOf(System.currentTimeMillis());
            if (i == 3250022) {
                rc5 d = rc5.d();
                d.g(cVar);
                if (cVar != null) {
                    cVar.d();
                }
                if (TbadkCoreApplication.getInst().getCurrentActivity() != null) {
                    c55 c55Var = new c55(TbadkCoreApplication.getInst().getCurrentActivity());
                    c55Var.setMessageId(R.string.anti_account_modifypwd_tip);
                    c55Var.setPositiveButton(R.string.modify_pwd, new a(c55Var, d));
                    c55Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03c9, new b(c55Var));
                    if (TbadkCoreApplication.getInst().getCurrentActivity() instanceof l9) {
                        c55Var.create(((l9) TbadkCoreApplication.getInst().getCurrentActivity()).getPageContext());
                        c55Var.show();
                    }
                }
            } else {
                if (i == 3250017) {
                    a2 = rc5.b();
                } else if (i == 3250023) {
                    a2 = rc5.c();
                } else if (i == 3250024) {
                    a2 = new rc5(4, null);
                } else {
                    a2 = rc5.a(str);
                }
                a2.g(cVar);
                MessageManager.getInstance().sendMessage(new CustomMessage(2921372, a2));
            }
            a.set(false);
            return true;
        }
        return invokeILL.booleanValue;
    }
}

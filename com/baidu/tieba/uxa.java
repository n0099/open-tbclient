package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.base.BdPageContextSupport;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWorkErr;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import com.baidu.tieba.f05;
import com.baidu.tieba.j85;
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
/* loaded from: classes8.dex */
public class uxa {
    public static /* synthetic */ Interceptable $ic;
    public static AtomicBoolean a;
    public static List<Integer> b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements f05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f05 a;
        public final /* synthetic */ j85 b;

        public a(f05 f05Var, j85 j85Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f05Var, j85Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f05Var;
            this.b = j85Var;
        }

        @Override // com.baidu.tieba.f05.e
        public void onClick(f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) {
                this.a.dismiss();
                MessageManager.getInstance().sendMessage(new CustomMessage(2921372, this.b));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements f05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f05 a;

        public b(f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f05Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f05Var;
        }

        @Override // com.baidu.tieba.f05.e
        public void onClick(f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
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

        public void b(j85.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
                if (cVar != null && cVar.a) {
                    if (cVar instanceof j85.a) {
                        a(((j85.a) cVar).b);
                        return;
                    } else if (cVar instanceof j85.b) {
                        c(((j85.b) cVar).b);
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948227755, "Lcom/baidu/tieba/uxa;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948227755, "Lcom/baidu/tieba/uxa;");
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
        j85 a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65539, null, i, str, cVar)) == null) {
            if (!a.compareAndSet(false, true)) {
                return false;
            }
            String.valueOf(System.currentTimeMillis());
            if (i == 3250022) {
                j85 d = j85.d();
                d.h(cVar);
                if (cVar != null) {
                    cVar.d();
                }
                if (TbadkCoreApplication.getInst().getCurrentActivity() != null) {
                    f05 f05Var = new f05(TbadkCoreApplication.getInst().getCurrentActivity());
                    f05Var.setMessageId(R.string.anti_account_modifypwd_tip);
                    f05Var.setPositiveButton(R.string.modify_pwd, new a(f05Var, d));
                    f05Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03db, new b(f05Var));
                    if (TbadkCoreApplication.getInst().getCurrentActivity() instanceof BdPageContextSupport) {
                        f05Var.create(((BdPageContextSupport) TbadkCoreApplication.getInst().getCurrentActivity()).getPageContext());
                        f05Var.show();
                    }
                }
            } else {
                if (i == 3250017) {
                    a2 = j85.b();
                } else if (i == 3250023) {
                    a2 = j85.c();
                } else if (i == 3250024) {
                    a2 = new j85(4, null);
                } else {
                    a2 = j85.a(str);
                }
                a2.h(cVar);
                MessageManager.getInstance().sendMessage(new CustomMessage(2921372, a2));
            }
            a.set(false);
            return true;
        }
        return invokeILL.booleanValue;
    }
}

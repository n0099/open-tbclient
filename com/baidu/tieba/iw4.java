package com.baidu.tieba;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.dialog.yun.strategy.ExcludeDialogStrategy;
import com.baidu.tbadk.core.dialog.yun.strategy.FrequenceDialogStrategy;
import com.baidu.tbadk.core.dialog.yun.strategy.PageDialogStrategy;
import com.baidu.tbadk.core.dialog.yun.strategy.UniqueDialogStrategy;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.data.DialogStrategiesData;
import com.baidu.tieba.hw4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes5.dex */
public class iw4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final Map<String, kw4> a;
    @NonNull
    public final Set<String> b;
    @NonNull
    public final Set<String> c;
    @NonNull
    public final Set<String> d;
    @NonNull
    public String e;
    public boolean f;
    public final CustomMessageListener g;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iw4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(iw4 iw4Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iw4Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iw4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                this.a.b.remove(str);
                this.a.c.remove(str);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ gw4 b;

        public b(Context context, gw4 gw4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, gw4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.b = gw4Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                iw4.p(this.a, this.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements hw4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ gw4 b;
        public final /* synthetic */ iw4 c;

        public c(iw4 iw4Var, Context context, gw4 gw4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iw4Var, context, gw4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = iw4Var;
            this.a = context;
            this.b = gw4Var;
        }

        @Override // com.baidu.tieba.hw4.c
        public void a(List<DialogStrategiesData> list) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, list) != null) || list == null) {
                return;
            }
            for (DialogStrategiesData dialogStrategiesData : list) {
                List<DialogStrategiesData.StrategiesConfigData> dialogStrategy = dialogStrategiesData.getDialogStrategy();
                HashMap hashMap = new HashMap();
                hashMap.put("currentShowingDialogList", this.c.b);
                hashMap.put("alreadyShownDialogs", this.c.d);
                hashMap.put("currentPageName", this.c.e);
                if (TextUtils.isEmpty(dialogStrategiesData.getDialogName()) || !this.c.b.contains(dialogStrategiesData.getDialogName())) {
                    if (!this.c.j(dialogStrategy)) {
                        if (dialogStrategy == null) {
                            dialogStrategy = new ArrayList<>();
                        }
                        dialogStrategy.add(DialogStrategiesData.StrategiesConfigData.G());
                    }
                    if (dialogStrategy != null) {
                        for (DialogStrategiesData.StrategiesConfigData strategiesConfigData : dialogStrategy) {
                            kw4 kw4Var = (kw4) this.c.a.get(strategiesConfigData.getType());
                            if (kw4Var == null || kw4Var.b(kw4Var.a(dialogStrategiesData, strategiesConfigData.H(), hashMap))) {
                            }
                        }
                    }
                    this.c.i(this.a, dialogStrategiesData.getDialogName(), this.c.r(dialogStrategiesData.getDialogUrl(), this.b));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public static final iw4 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-704701373, "Lcom/baidu/tieba/iw4$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-704701373, "Lcom/baidu/tieba/iw4$d;");
                    return;
                }
            }
            a = new iw4(null);
        }
    }

    public iw4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new HashMap();
        this.b = new HashSet();
        this.c = new HashSet();
        this.d = new HashSet();
        this.e = "";
        this.f = false;
        this.g = new a(this, 2921753);
        this.a.put("FREQUENCE_STRATEGY", new FrequenceDialogStrategy());
        this.a.put("PAGE_STRATEGY", new PageDialogStrategy());
        this.a.put("EXCLUDE_STRATEGY", new ExcludeDialogStrategy());
        this.a.put("UNIQUE_STRATEGY", new UniqueDialogStrategy());
        MessageManager.getInstance().registerListener(this.g);
    }

    public /* synthetic */ iw4(a aVar) {
        this();
    }

    public static void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65548, null, z) == null) {
            k().f = z;
        }
    }

    public static void n(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, str) == null) {
            k().b.add(str);
            k().d.add(str);
        }
    }

    public static void o(@NonNull gw4 gw4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65550, null, gw4Var) == null) && gw4Var.c()) {
            k().e = "";
        }
    }

    public static void t(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, str) == null) {
            k().b.remove(str);
        }
    }

    public final void s(@NonNull Context context, @NonNull gw4 gw4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, context, gw4Var) == null) {
            if (gw4Var.c()) {
                this.e = gw4Var.b();
            }
            hw4.f().e(gw4Var.b(), new c(this, context, gw4Var));
        }
    }

    public final void i(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, context, str, str2) == null) {
            q(context, str2, str);
            lw4.a.c(str);
            this.b.add(str);
            this.d.add(str);
            this.c.add(str);
        }
    }

    public static iw4 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            return d.a;
        }
        return (iw4) invokeV.objValue;
    }

    public static boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            return !k().c.isEmpty();
        }
        return invokeV.booleanValue;
    }

    public static void p(@NonNull Context context, @NonNull gw4 gw4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65551, null, context, gw4Var) == null) {
            if (!yi.E()) {
                ah.a().post(new b(context, gw4Var));
            } else if (MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW || LogoActivityConfig.IS_HOT_SPLASH_SHOW || !BdNetTypeUtil.isNetWorkAvailable()) {
            } else {
                if (gw4Var.c() && k().f) {
                    return;
                }
                k().s(context, gw4Var);
            }
        }
    }

    public final boolean j(List<DialogStrategiesData.StrategiesConfigData> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return false;
            }
            for (DialogStrategiesData.StrategiesConfigData strategiesConfigData : list) {
                if ("UN_UNIQUE_STRATEGY".equals(strategiesConfigData.getType())) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void q(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, str, str2) == null) {
            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(context, "", str, false, true, true);
            tbWebViewActivityConfig.setPageTranslucent(TbWebViewActivityConfig.PAGE_TYPE_BLACK_TRANSLUCENT);
            tbWebViewActivityConfig.setWebDialogName(str2);
            tbWebViewActivityConfig.setTranslucentAutoClose(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
        }
    }

    public final String r(String str, @NonNull gw4 gw4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, gw4Var)) == null) {
            if (!TextUtils.isEmpty(str)) {
                return Uri.parse(str).buildUpon().appendQueryParameter("time", gw4Var.b()).build().toString();
            }
            return str;
        }
        return (String) invokeLL.objValue;
    }
}

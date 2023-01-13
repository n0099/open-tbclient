package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.TBWebViewActivity;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.atomData.WebViewActivityConfig;
import com.baidu.tbadk.core.dialog.yun.strategy.ExcludeDialogStrategy;
import com.baidu.tbadk.core.dialog.yun.strategy.FrequenceDialogStrategy;
import com.baidu.tbadk.core.dialog.yun.strategy.PageDialogStrategy;
import com.baidu.tbadk.core.dialog.yun.strategy.UniqueDialogStrategy;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.data.DialogStrategiesData;
import com.baidu.tieba.sw4;
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
/* loaded from: classes6.dex */
public class tw4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final Map<String, vw4> a;
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

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tw4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(tw4 tw4Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tw4Var, Integer.valueOf(i)};
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
            this.a = tw4Var;
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

    /* loaded from: classes6.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ rw4 b;

        public b(Context context, rw4 rw4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, rw4Var};
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
            this.b = rw4Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                tw4.q(this.a, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements sw4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ rw4 b;
        public final /* synthetic */ tw4 c;

        public c(tw4 tw4Var, Context context, rw4 rw4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tw4Var, context, rw4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = tw4Var;
            this.a = context;
            this.b = rw4Var;
        }

        @Override // com.baidu.tieba.sw4.c
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
                if (!TextUtils.isEmpty(dialogStrategiesData.getDialogName()) && this.c.b.contains(dialogStrategiesData.getDialogName())) {
                    BdLog.printExceptionLog("YunDialogManager", "repeat");
                } else {
                    if (!this.c.j(dialogStrategy)) {
                        if (dialogStrategy == null) {
                            dialogStrategy = new ArrayList<>();
                        }
                        dialogStrategy.add(DialogStrategiesData.StrategiesConfigData.G());
                    }
                    if (dialogStrategy != null) {
                        for (DialogStrategiesData.StrategiesConfigData strategiesConfigData : dialogStrategy) {
                            vw4 vw4Var = (vw4) this.c.a.get(strategiesConfigData.getType());
                            if (vw4Var == null || vw4Var.b(vw4Var.a(dialogStrategiesData, strategiesConfigData.H(), hashMap))) {
                            }
                        }
                    }
                    this.c.i(this.a, dialogStrategiesData.getDialogName(), this.c.s(dialogStrategiesData.getDialogUrl(), this.b));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public static final tw4 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-389780712, "Lcom/baidu/tieba/tw4$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-389780712, "Lcom/baidu/tieba/tw4$d;");
                    return;
                }
            }
            a = new tw4(null);
        }
    }

    public tw4() {
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

    public /* synthetic */ tw4(a aVar) {
        this();
    }

    public static boolean m(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, activity)) == null) {
            if ((activity instanceof TBWebViewActivity) && activity.getIntent() != null && !TextUtils.isEmpty(activity.getIntent().getStringExtra(WebViewActivityConfig.TAG_WEB_DIALOG_NAME))) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65549, null, z) == null) {
            k().f = z;
        }
    }

    public static void o(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, str) == null) {
            k().b.add(str);
            k().d.add(str);
        }
    }

    public static void u(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, str) == null) {
            k().b.remove(str);
        }
    }

    public final void t(@NonNull Context context, @NonNull rw4 rw4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, context, rw4Var) == null) {
            if (rw4Var.c()) {
                this.e = rw4Var.b();
            }
            sw4.f().e(rw4Var.b(), new c(this, context, rw4Var));
        }
    }

    public static tw4 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            return d.a;
        }
        return (tw4) invokeV.objValue;
    }

    public static boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            return !k().c.isEmpty();
        }
        return invokeV.booleanValue;
    }

    public static void p(@NonNull rw4 rw4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, rw4Var) == null) {
            BdLog.printExceptionLog("YunDialogManager", "onHidden:" + rw4Var.b());
            if (rw4Var.c()) {
                k().e = "";
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

    public static void q(@NonNull Context context, @NonNull rw4 rw4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65552, null, context, rw4Var) == null) {
            if (!zi.E()) {
                bh.a().postAtFrontOfQueue(new b(context, rw4Var));
                return;
            }
            BdLog.printExceptionLog("YunDialogManager", "onShow:" + rw4Var.b());
            if (MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW) {
                BdLog.printExceptionLog("YunDialogManager", "IS_MAIN_TAB_SPLASH_SHOW");
            } else if (LogoActivityConfig.IS_HOT_SPLASH_SHOW) {
                BdLog.printExceptionLog("YunDialogManager", "IS_HOT_SPLASH_SHOW");
            } else if (!BdNetTypeUtil.isNetWorkAvailable()) {
                BdLog.printExceptionLog("YunDialogManager", "isNetWorkUnavailable");
            } else if (rw4Var.c() && k().f) {
                BdLog.printExceptionLog("YunDialogManager", "isBackFromYunDialog");
            } else {
                k().t(context, rw4Var);
            }
        }
    }

    public final void i(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, context, str, str2) == null) {
            r(context, str2, str);
            BdLog.printExceptionLog("YunDialogManager", "doShowDialog:" + str);
            ww4.a.c(str);
            this.b.add(str);
            this.d.add(str);
            this.c.add(str);
        }
    }

    public final void r(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, str, str2) == null) {
            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(context, "", str, false, true, true);
            tbWebViewActivityConfig.setPageTranslucent(TbWebViewActivityConfig.PAGE_TYPE_BLACK_TRANSLUCENT);
            tbWebViewActivityConfig.setWebDialogName(str2);
            tbWebViewActivityConfig.setTranslucentAutoClose(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
        }
    }

    public final String s(String str, @NonNull rw4 rw4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, rw4Var)) == null) {
            if (!TextUtils.isEmpty(str)) {
                return Uri.parse(str).buildUpon().appendQueryParameter("time", rw4Var.b()).build().toString();
            }
            return str;
        }
        return (String) invokeLL.objValue;
    }
}

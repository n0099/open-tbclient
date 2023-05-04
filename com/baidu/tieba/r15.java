package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.TBWebViewActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.WebViewActivityConfig;
import com.baidu.tbadk.core.dialog.yun.YunDialogDataManager;
import com.baidu.tbadk.core.dialog.yun.strategy.ExcludeDialogStrategy;
import com.baidu.tbadk.core.dialog.yun.strategy.FrequenceDialogStrategy;
import com.baidu.tbadk.core.dialog.yun.strategy.PageDialogStrategy;
import com.baidu.tbadk.core.dialog.yun.strategy.UniqueDialogStrategy;
import com.baidu.tbadk.core.log.YunDialogLog;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.data.DialogStrategiesData;
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
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class r15 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final Map<String, p25> a;
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
        public final /* synthetic */ r15 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(r15 r15Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r15Var, Integer.valueOf(i)};
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
            this.a = r15Var;
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
        public final /* synthetic */ q15 b;

        public b(Context context, q15 q15Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, q15Var};
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
            this.b = q15Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                r15.o(this.a, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements YunDialogDataManager.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ q15 b;

        public c(Context context, q15 q15Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, q15Var};
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
            this.b = q15Var;
        }

        @Override // com.baidu.tbadk.core.dialog.yun.YunDialogDataManager.d
        public void a(List<DialogStrategiesData> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                for (DialogStrategiesData dialogStrategiesData : list) {
                    r15.c().r(this.a, this.b.b(), dialogStrategiesData, new JSONObject());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ String b;
        public final /* synthetic */ JSONObject c;

        public d(Context context, String str, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, str, jSONObject};
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
            this.b = str;
            this.c = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                r15.p(this.a, this.b, this.c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class e implements YunDialogDataManager.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ JSONObject b;

        public e(Context context, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, jSONObject};
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
            this.b = jSONObject;
        }

        @Override // com.baidu.tbadk.core.dialog.yun.YunDialogDataManager.d
        public void a(List<DialogStrategiesData> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                for (DialogStrategiesData dialogStrategiesData : list) {
                    r15.c().r(this.a, "", dialogStrategiesData, this.b);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public static final r15 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-511655631, "Lcom/baidu/tieba/r15$f;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-511655631, "Lcom/baidu/tieba/r15$f;");
                    return;
                }
            }
            a = new r15(null);
        }
    }

    public r15() {
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
        q25 q25Var = new q25();
        hj1<r25> hj1Var = q25Var.a;
        if (hj1Var != null && !ListUtils.isEmpty(hj1Var.getList())) {
            for (r25 r25Var : q25Var.a.getList()) {
                this.a.put(r25Var.name(), r25Var.a());
            }
        }
        this.a.put("FREQUENCE_STRATEGY", new FrequenceDialogStrategy());
        this.a.put("PAGE_STRATEGY", new PageDialogStrategy());
        this.a.put("EXCLUDE_STRATEGY", new ExcludeDialogStrategy());
        this.a.put("UNIQUE_STRATEGY", new UniqueDialogStrategy());
        this.a.put("HYBRID_CHECK_STRATEGY", new t25());
        this.a.put("NA_USER_ICON_STRATEGY", new z25());
        this.a.put("NA_USER_GROWTH_STRATEGY", new y25());
        this.a.put("NA_NEW_GOD_STRATEGY", new u25());
        this.a.put("NA_OPERATION_STRATEGY", new w25());
        this.a.put("NA_LIVE_REMIND_STRATEGY", new v25());
        this.a.put("NA_UPDATE_STRATEGY", new x25());
        dj8 yunDialogLog = YunDialogLog.getInstance();
        yunDialogLog.c("YunDialogManager", "strategyMap:" + this.a);
        MessageManager.getInstance().registerListener(this.g);
    }

    public /* synthetic */ r15(a aVar) {
        this();
    }

    public static boolean k(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, activity)) == null) {
            if ((activity instanceof TBWebViewActivity) && activity.getIntent() != null && !TextUtils.isEmpty(activity.getIntent().getStringExtra(WebViewActivityConfig.TAG_WEB_DIALOG_NAME))) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65547, null, z) == null) {
            h().f = z;
        }
    }

    public static void m(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, str) == null) {
            h().b.add(str);
            h().d.add(str);
        }
    }

    public static void s(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, str) == null) {
            h().b.remove(str);
            h().c.remove(str);
        }
    }

    public static /* synthetic */ r15 c() {
        return h();
    }

    public static r15 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return f.a;
        }
        return (r15) invokeV.objValue;
    }

    public static Set<String> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return h().c;
        }
        return (Set) invokeV.objValue;
    }

    public static boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return !h().c.isEmpty();
        }
        return invokeV.booleanValue;
    }

    public static boolean e(@Nullable q15 q15Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, q15Var)) == null) {
            String str = null;
            if (MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW) {
                dj8 yunDialogLog = YunDialogLog.getInstance();
                StringBuilder sb = new StringBuilder();
                sb.append("云弹窗 ");
                if (q15Var != null) {
                    str = q15Var.b();
                }
                sb.append(str);
                sb.append(" 不可显示：当前冷启动开屏展示中");
                yunDialogLog.c("YunDialogManager", sb.toString());
                return false;
            } else if (LogoActivityConfig.IS_HOT_SPLASH_SHOW) {
                dj8 yunDialogLog2 = YunDialogLog.getInstance();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("云弹窗 ");
                if (q15Var != null) {
                    str = q15Var.b();
                }
                sb2.append(str);
                sb2.append(" 不可显示：当前热启动开屏展示中");
                yunDialogLog2.c("YunDialogManager", sb2.toString());
                return false;
            } else if (!BdNetTypeUtil.isNetWorkAvailable()) {
                dj8 yunDialogLog3 = YunDialogLog.getInstance();
                StringBuilder sb3 = new StringBuilder();
                sb3.append("云弹窗 ");
                if (q15Var != null) {
                    str = q15Var.b();
                }
                sb3.append(str);
                sb3.append(" 不可显示：当前网络异常");
                yunDialogLog3.c("YunDialogManager", sb3.toString());
                return false;
            } else if (q15Var != null && q15Var.c() && h().f) {
                dj8 yunDialogLog4 = YunDialogLog.getInstance();
                yunDialogLog4.c("YunDialogManager", "云弹窗 " + q15Var.b() + " 不可显示：从云弹窗返回");
                return false;
            } else if (TbadkCoreApplication.getInst().isInBackground()) {
                YunDialogLog.getInstance().c("YunDialogManager", "isInBackground");
                return false;
            } else {
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public static void n(@NonNull q15 q15Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, q15Var) == null) {
            dj8 yunDialogLog = YunDialogLog.getInstance();
            yunDialogLog.c("YunDialogManager", "云弹窗时机消失:" + q15Var.b());
            if (q15Var.c()) {
                h().e = "";
            }
        }
    }

    public final boolean g(List<DialogStrategiesData.StrategiesConfigData> list) {
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

    public static void o(@NonNull Context context, @NonNull q15 q15Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65550, null, context, q15Var) == null) {
            if (!ii.E()) {
                jg.a().postAtFrontOfQueue(new b(context, q15Var));
                return;
            }
            dj8 yunDialogLog = YunDialogLog.getInstance();
            yunDialogLog.c("YunDialogManager", "云弹窗时机触发:" + q15Var.b());
            if (q15Var.c()) {
                h().e = q15Var.b();
            }
            if (!e(q15Var)) {
                return;
            }
            YunDialogDataManager.j().g(q15Var.b(), new c(context, q15Var));
        }
    }

    public static void p(@NonNull Context context, @NonNull String str, @NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65551, null, context, str, jSONObject) == null) {
            if (!ii.E()) {
                jg.a().postAtFrontOfQueue(new d(context, str, jSONObject));
            } else if (!e(null)) {
            } else {
                YunDialogDataManager.j().f(str, new e(context, jSONObject));
            }
        }
    }

    public final void f(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, context, str, str2) == null) {
            this.b.add(str);
            this.c.add(str);
            n25.a(context, str, str2);
            dj8 yunDialogLog = YunDialogLog.getInstance();
            yunDialogLog.c("YunDialogManager", "云弹窗 " + str + " 弹出显示，展示链接：" + str2);
            a35.a.c(str);
            this.d.add(str);
        }
    }

    public final String q(String str, @NonNull String str2, @NonNull JSONObject jSONObject) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, jSONObject)) == null) {
            if (!TextUtils.isEmpty(str)) {
                Uri.Builder appendQueryParameter = Uri.parse(str).buildUpon().appendQueryParameter("time", str2);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    appendQueryParameter.appendQueryParameter(next, jSONObject.optString(next));
                }
                return appendQueryParameter.build().toString();
            }
            return str;
        }
        return (String) invokeLLL.objValue;
    }

    public final void r(@NonNull Context context, @NonNull String str, @NonNull DialogStrategiesData dialogStrategiesData, @NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, context, str, dialogStrategiesData, jSONObject) == null) {
            dj8 yunDialogLog = YunDialogLog.getInstance();
            yunDialogLog.c("YunDialogManager", "准备显示云弹窗：" + dialogStrategiesData.getDialogName() + " ，参数：" + jSONObject);
            List<DialogStrategiesData.StrategiesConfigData> dialogStrategy = dialogStrategiesData.getDialogStrategy();
            HashMap hashMap = new HashMap();
            hashMap.put("currentShowingDialogList", this.b);
            hashMap.put("alreadyShownDialogs", this.d);
            hashMap.put("currentPageName", this.e);
            if (!TextUtils.isEmpty(dialogStrategiesData.getDialogName()) && this.b.contains(dialogStrategiesData.getDialogName())) {
                dj8 yunDialogLog2 = YunDialogLog.getInstance();
                yunDialogLog2.c("YunDialogManager", "云弹窗 " + dialogStrategiesData.getDialogName() + " 正在显示中，过滤");
                return;
            }
            if (!g(dialogStrategy)) {
                if (dialogStrategy == null) {
                    dialogStrategy = new ArrayList<>();
                }
                dialogStrategy.add(DialogStrategiesData.StrategiesConfigData.V());
            }
            if (dialogStrategy != null) {
                for (DialogStrategiesData.StrategiesConfigData strategiesConfigData : dialogStrategy) {
                    p25 p25Var = this.a.get(strategiesConfigData.getType());
                    if (p25Var != null && !p25Var.b(p25Var.a(dialogStrategiesData, strategiesConfigData.W(), hashMap))) {
                        return;
                    }
                }
            }
            f(context, dialogStrategiesData.getDialogName(), q(dialogStrategiesData.getDialogUrl(), str, jSONObject));
        }
    }
}

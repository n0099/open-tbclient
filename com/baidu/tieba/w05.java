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
public class w05 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final Map<String, d15> a;
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
        public final /* synthetic */ w05 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(w05 w05Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w05Var, Integer.valueOf(i)};
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
            this.a = w05Var;
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
        public final /* synthetic */ v05 b;

        public b(Context context, v05 v05Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, v05Var};
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
            this.b = v05Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                w05.n(this.a, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements YunDialogDataManager.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ v05 b;

        public c(Context context, v05 v05Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, v05Var};
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
            this.b = v05Var;
        }

        @Override // com.baidu.tbadk.core.dialog.yun.YunDialogDataManager.c
        public void a(List<DialogStrategiesData> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                for (DialogStrategiesData dialogStrategiesData : list) {
                    w05.c().q(this.a, this.b.b(), dialogStrategiesData, new JSONObject());
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
                w05.o(this.a, this.b, this.c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class e implements YunDialogDataManager.c {
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

        @Override // com.baidu.tbadk.core.dialog.yun.YunDialogDataManager.c
        public void a(List<DialogStrategiesData> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                for (DialogStrategiesData dialogStrategiesData : list) {
                    w05.c().q(this.a, "", dialogStrategiesData, this.b);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public static final w05 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-369433397, "Lcom/baidu/tieba/w05$f;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-369433397, "Lcom/baidu/tieba/w05$f;");
                    return;
                }
            }
            a = new w05(null);
        }
    }

    public w05() {
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
        e15 e15Var = new e15();
        dj1<f15> dj1Var = e15Var.a;
        if (dj1Var != null && !ListUtils.isEmpty(dj1Var.getList())) {
            for (f15 f15Var : e15Var.a.getList()) {
                this.a.put(f15Var.name(), f15Var.a());
            }
        }
        this.a.put("FREQUENCE_STRATEGY", new FrequenceDialogStrategy());
        this.a.put("PAGE_STRATEGY", new PageDialogStrategy());
        this.a.put("EXCLUDE_STRATEGY", new ExcludeDialogStrategy());
        this.a.put("UNIQUE_STRATEGY", new UniqueDialogStrategy());
        w58 yunDialogLog = YunDialogLog.getInstance();
        yunDialogLog.c("YunDialogManager", "strategyMap:" + this.a);
        MessageManager.getInstance().registerListener(this.g);
    }

    public /* synthetic */ w05(a aVar) {
        this();
    }

    public static boolean j(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, activity)) == null) {
            if ((activity instanceof TBWebViewActivity) && activity.getIntent() != null && !TextUtils.isEmpty(activity.getIntent().getStringExtra(WebViewActivityConfig.TAG_WEB_DIALOG_NAME))) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65546, null, z) == null) {
            h().f = z;
        }
    }

    public static void l(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, str) == null) {
            h().b.add(str);
            h().d.add(str);
        }
    }

    public static void r(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, str) == null) {
            h().b.remove(str);
        }
    }

    public static /* synthetic */ w05 c() {
        return h();
    }

    public static w05 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return f.a;
        }
        return (w05) invokeV.objValue;
    }

    public static boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return !h().c.isEmpty();
        }
        return invokeV.booleanValue;
    }

    public static boolean e(@Nullable v05 v05Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, v05Var)) == null) {
            String str = null;
            if (MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW) {
                w58 yunDialogLog = YunDialogLog.getInstance();
                StringBuilder sb = new StringBuilder();
                sb.append("云弹窗 ");
                if (v05Var != null) {
                    str = v05Var.b();
                }
                sb.append(str);
                sb.append(" 不可显示：当前冷启动开屏展示中");
                yunDialogLog.c("YunDialogManager", sb.toString());
                return false;
            } else if (LogoActivityConfig.IS_HOT_SPLASH_SHOW) {
                w58 yunDialogLog2 = YunDialogLog.getInstance();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("云弹窗 ");
                if (v05Var != null) {
                    str = v05Var.b();
                }
                sb2.append(str);
                sb2.append(" 不可显示：当前热启动开屏展示中");
                yunDialogLog2.c("YunDialogManager", sb2.toString());
                return false;
            } else if (!BdNetTypeUtil.isNetWorkAvailable()) {
                w58 yunDialogLog3 = YunDialogLog.getInstance();
                StringBuilder sb3 = new StringBuilder();
                sb3.append("云弹窗 ");
                if (v05Var != null) {
                    str = v05Var.b();
                }
                sb3.append(str);
                sb3.append(" 不可显示：当前网络异常");
                yunDialogLog3.c("YunDialogManager", sb3.toString());
                return false;
            } else if (v05Var != null && v05Var.c() && h().f) {
                w58 yunDialogLog4 = YunDialogLog.getInstance();
                yunDialogLog4.c("YunDialogManager", "云弹窗 " + v05Var.b() + " 不可显示：从云弹窗返回");
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

    public static void m(@NonNull v05 v05Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, v05Var) == null) {
            w58 yunDialogLog = YunDialogLog.getInstance();
            yunDialogLog.c("YunDialogManager", "云弹窗时机消失:" + v05Var.b());
            if (v05Var.c()) {
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

    public static void n(@NonNull Context context, @NonNull v05 v05Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, context, v05Var) == null) {
            if (!hi.E()) {
                jg.a().postAtFrontOfQueue(new b(context, v05Var));
                return;
            }
            w58 yunDialogLog = YunDialogLog.getInstance();
            yunDialogLog.c("YunDialogManager", "云弹窗时机触发:" + v05Var.b());
            if (v05Var.c()) {
                h().e = v05Var.b();
            }
            if (!e(v05Var)) {
                return;
            }
            YunDialogDataManager.j().g(v05Var.b(), new c(context, v05Var));
        }
    }

    public static void o(@NonNull Context context, @NonNull String str, @NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65550, null, context, str, jSONObject) == null) {
            if (!hi.E()) {
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
            b15.a(context, str, str2);
            w58 yunDialogLog = YunDialogLog.getInstance();
            yunDialogLog.c("YunDialogManager", "云弹窗 " + str + " 弹出显示，展示链接：" + str2);
            h15.a.c(str);
            this.b.add(str);
            this.d.add(str);
            this.c.add(str);
        }
    }

    public final String p(String str, @NonNull String str2, @NonNull JSONObject jSONObject) {
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

    public final void q(@NonNull Context context, @NonNull String str, @NonNull DialogStrategiesData dialogStrategiesData, @NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, context, str, dialogStrategiesData, jSONObject) == null) {
            w58 yunDialogLog = YunDialogLog.getInstance();
            yunDialogLog.c("YunDialogManager", "准备显示云弹窗：" + dialogStrategiesData.getDialogName() + " ，参数：" + jSONObject);
            List<DialogStrategiesData.StrategiesConfigData> dialogStrategy = dialogStrategiesData.getDialogStrategy();
            HashMap hashMap = new HashMap();
            hashMap.put("currentShowingDialogList", this.b);
            hashMap.put("alreadyShownDialogs", this.d);
            hashMap.put("currentPageName", this.e);
            if (!TextUtils.isEmpty(dialogStrategiesData.getDialogName()) && this.b.contains(dialogStrategiesData.getDialogName())) {
                w58 yunDialogLog2 = YunDialogLog.getInstance();
                yunDialogLog2.c("YunDialogManager", "云弹窗 " + dialogStrategiesData.getDialogName() + " 正在显示中，过滤");
                return;
            }
            if (!g(dialogStrategy)) {
                if (dialogStrategy == null) {
                    dialogStrategy = new ArrayList<>();
                }
                dialogStrategy.add(DialogStrategiesData.StrategiesConfigData.R());
            }
            if (dialogStrategy != null) {
                for (DialogStrategiesData.StrategiesConfigData strategiesConfigData : dialogStrategy) {
                    d15 d15Var = this.a.get(strategiesConfigData.getType());
                    if (d15Var != null && !d15Var.b(d15Var.a(dialogStrategiesData, strategiesConfigData.S(), hashMap))) {
                        return;
                    }
                }
            }
            f(context, dialogStrategiesData.getDialogName(), p(dialogStrategiesData.getDialogUrl(), str, jSONObject));
        }
    }
}

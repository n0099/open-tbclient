package com.baidu.tieba.recapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.recapp.activity.AdWebVideoActivity;
import com.baidu.tieba.recapp.activity.AdWebVideoActivityConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.f88;
import com.repackage.fj5;
import com.repackage.h88;
import com.repackage.j88;
import com.repackage.l88;
import com.repackage.th5;
import com.repackage.x88;
import com.repackage.z88;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class RecAppStatic {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a implements l88.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        @Override // com.repackage.l88.a
        public int a(Context context, String[] strArr) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, strArr)) == null) {
                if (strArr != null && strArr[0] != null) {
                    Uri parse = Uri.parse(strArr[0]);
                    if ("button_action".equalsIgnoreCase(parse.getAuthority())) {
                        String queryParameter = parse.getQueryParameter("scheme");
                        if (!TextUtils.isEmpty(queryParameter)) {
                            if (queryParameter.startsWith("tel:")) {
                                Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(queryParameter));
                                intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                                TbadkCoreApplication.getInst().startActivity(intent);
                                context.startActivity(intent);
                                return 0;
                            }
                            String queryParameter2 = parse.getQueryParameter("params");
                            if (!TextUtils.isEmpty(queryParameter2)) {
                                Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(queryParameter));
                                intent2.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                                try {
                                    JSONObject jSONObject = new JSONObject(queryParameter2);
                                    Iterator<String> keys = jSONObject.keys();
                                    while (keys.hasNext()) {
                                        String next = keys.next();
                                        if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(jSONObject.getString(next))) {
                                            intent2.putExtra(next, jSONObject.getString(next));
                                        }
                                    }
                                    context.startActivity(intent2);
                                    return 0;
                                } catch (JSONException unused) {
                                }
                            }
                        }
                    }
                }
                return 3;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbadkCoreApplication val$application;

        public b(TbadkCoreApplication tbadkCoreApplication) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbadkCoreApplication};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.val$application = tbadkCoreApplication;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
                this.val$application.notifySwitchProcess(intent.getBooleanExtra("message", false));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1601986444, "Lcom/baidu/tieba/recapp/RecAppStatic;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1601986444, "Lcom/baidu/tieba/recapp/RecAppStatic;");
                return;
            }
        }
        x88.a.set(new z88());
        TbadkCoreApplication.getInst().setRecAppExist(true);
        fj5.l().e(new a());
        th5.b().c(1, new j88());
        th5.b().c(2, new h88());
        TbadkCoreApplication inst = TbadkCoreApplication.getInst();
        inst.RegisterIntent(AdWebVideoActivityConfig.class, AdWebVideoActivity.class);
        b bVar = new b(inst);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tieba.baidu.notifyprocess");
        inst.registerReceiver(bVar, intentFilter);
        f88.t().b();
        f88.t().f();
    }

    public RecAppStatic() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }
}

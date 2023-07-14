package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.ext.widget.dialog.AutoOrientationBtnActDialog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.android.ActivityUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.feed.ad.util.InterceptCallback;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.searchbox.schemedispatch.forbid.InvokeStatistic;
import com.baidu.searchbox.schemedispatch.forbid.InvokeStatisticKt;
import com.baidu.searchbox.schemedispatch.forbid.SchemeForbidStatisticUtils;
import com.baidu.searchbox.schemedispatch.monitor.OpenAppManager;
import com.baidu.searchbox.schemedispatch.monitor.bean.SchemeCheckInfo;
import com.baidu.searchbox.schemedispatch.monitor.bean.SchemeCheckInfoKt;
import com.baidu.searchbox.schemedispatch.monitor.control.OpenAppAllowAlertControl;
import com.baidu.searchbox.schemedispatch.monitor.control.OpenAppBlockAlertControl;
import com.baidu.tieba.mx;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.List;
/* loaded from: classes7.dex */
public class nx {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public WeakReference<AutoOrientationBtnActDialog> a;

    /* loaded from: classes7.dex */
    public class a implements AutoOrientationBtnActDialog.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ InterceptCallback a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ String d;
        public final /* synthetic */ InvokeStatistic e;
        public final /* synthetic */ SchemeCheckInfo f;
        public final /* synthetic */ nx g;

        public a(nx nxVar, InterceptCallback interceptCallback, boolean z, Context context, String str, InvokeStatistic invokeStatistic, SchemeCheckInfo schemeCheckInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nxVar, interceptCallback, Boolean.valueOf(z), context, str, invokeStatistic, schemeCheckInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = nxVar;
            this.a = interceptCallback;
            this.b = z;
            this.c = context;
            this.d = str;
            this.e = invokeStatistic;
            this.f = schemeCheckInfo;
        }

        @Override // com.baidu.android.ext.widget.dialog.AutoOrientationBtnActDialog.OnItemClickListener
        public void onItemClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                InterceptCallback interceptCallback = this.a;
                if (interceptCallback != null) {
                    if (this.b) {
                        interceptCallback.onResult(this.g.e(this.c, this.d, this.e));
                    } else {
                        interceptCallback.onResult(true);
                    }
                }
                OpenAppAllowAlertControl.addRule(this.f.getScheme());
                OpenAppBlockAlertControl.removeRule(this.f.getScheme());
                SchemeForbidStatisticUtils.ubcSchemaDialog(1);
                this.e.confirmAlert();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements AutoOrientationBtnActDialog.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ InterceptCallback a;
        public final /* synthetic */ SchemeCheckInfo b;
        public final /* synthetic */ InvokeStatistic c;

        public b(nx nxVar, InterceptCallback interceptCallback, SchemeCheckInfo schemeCheckInfo, InvokeStatistic invokeStatistic) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nxVar, interceptCallback, schemeCheckInfo, invokeStatistic};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = interceptCallback;
            this.b = schemeCheckInfo;
            this.c = invokeStatistic;
        }

        @Override // com.baidu.android.ext.widget.dialog.AutoOrientationBtnActDialog.OnItemClickListener
        public void onItemClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                InterceptCallback interceptCallback = this.a;
                if (interceptCallback != null) {
                    interceptCallback.onResult(false);
                }
                OpenAppBlockAlertControl.addRule(this.b.getScheme());
                OpenAppAllowAlertControl.removeRule(this.b.getScheme());
                SchemeForbidStatisticUtils.ubcSchemaDialog(3);
                this.c.cancleAlert();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public static final nx a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(258996292, "Lcom/baidu/tieba/nx$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(258996292, "Lcom/baidu/tieba/nx$c;");
                    return;
                }
            }
            a = new nx(null);
        }
    }

    public nx() {
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

    public static nx b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return c.a;
        }
        return (nx) invokeV.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        AutoOrientationBtnActDialog autoOrientationBtnActDialog;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            WeakReference<AutoOrientationBtnActDialog> weakReference = this.a;
            if (weakReference == null || (autoOrientationBtnActDialog = weakReference.get()) == null || !autoOrientationBtnActDialog.isShowing()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public /* synthetic */ nx(a aVar) {
        this();
    }

    public final boolean c(SchemeCheckInfo schemeCheckInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, schemeCheckInfo)) == null) {
            if (schemeCheckInfo.notAlert() || OpenAppAllowAlertControl.checkRule(schemeCheckInfo.getScheme())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean f(Context context, String str, boolean z, boolean z2, InvokeStatistic invokeStatistic) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{context, str, Boolean.valueOf(z), Boolean.valueOf(z2), invokeStatistic})) == null) {
            if (TextUtils.isEmpty(str) || context == null) {
                return false;
            }
            Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(str);
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
            if (queryIntentActivities == null || queryIntentActivities.size() <= 0) {
                return false;
            }
            ResolveInfo next = queryIntentActivities.iterator().next();
            if (next != null) {
                String str2 = next.activityInfo.name;
                Intent intent2 = new Intent("android.intent.action.MAIN");
                intent2.addCategory("android.intent.category.LAUNCHER");
                intent2.setComponent(new ComponentName(str, str2));
                intent2.setFlags(LaunchTaskConstants.OTHER_PROCESS);
                try {
                    boolean startActivitySafely = ActivityUtils.startActivitySafely(context, intent2, z, z2);
                    if (startActivitySafely) {
                        invokeStatistic.invokeSuc();
                    } else {
                        invokeStatistic.setSource("other").invokeFail();
                    }
                    return startActivitySafely;
                } catch (ActivityNotFoundException unused) {
                    invokeStatistic.setSource("other").invokeFail();
                    return false;
                }
            }
            invokeStatistic.setSource(InvokeStatisticKt.SCHEME_INVOKE_SOURCE_NOT_INSTALL).invokeFail();
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public final boolean e(Context context, String str, InvokeStatistic invokeStatistic) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, str, invokeStatistic)) == null) {
            return f(context, str, false, true, invokeStatistic);
        }
        return invokeLLL.booleanValue;
    }

    @SuppressLint({"PrivateResource"})
    public void g(SchemeCheckInfo schemeCheckInfo, String str, boolean z, InterceptCallback interceptCallback, boolean z2, InvokeStatistic invokeStatistic) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{schemeCheckInfo, str, Boolean.valueOf(z), interceptCallback, Boolean.valueOf(z2), invokeStatistic}) == null) {
            Context appContext = AppRuntime.getAppContext();
            invokeStatistic.setValue(true);
            if (z2 && c(schemeCheckInfo)) {
                if (OpenAppBlockAlertControl.checkRule(schemeCheckInfo.getScheme())) {
                    interceptCallback.onResult(false);
                    return;
                }
                SchemeForbidStatisticUtils.ubcShowDialog();
                if (d()) {
                    return;
                }
                invokeStatistic.setValue(false);
                if (interceptCallback != null && z) {
                    invokeStatistic.setPage("package");
                }
                mx.c cVar = new mx.c();
                cVar.g(R.string.third_party_visit_dialog_title);
                cVar.e(String.format(appContext.getResources().getString(R.string.third_party_visit_dialog_content), OpenAppManager.getSchemeName(schemeCheckInfo)));
                cVar.f(appContext.getResources().getDimensionPixelSize(R.dimen.third_party_visit_dialog_content_size));
                cVar.setButton(new AutoOrientationBtnActDialog.BtnItem(appContext.getText(R.string.third_party_visit_dialog_cancel), R.color.obfuscated_res_0x7f0604a1, new b(this, interceptCallback, schemeCheckInfo, invokeStatistic))).setButton(new AutoOrientationBtnActDialog.BtnItem(appContext.getText(R.string.third_party_visit_dialog), R.color.obfuscated_res_0x7f0604a1, new a(this, interceptCallback, z, appContext, str, invokeStatistic, schemeCheckInfo)));
                AutoOrientationBtnActDialog show = cVar.show();
                invokeStatistic.showAlert();
                this.a = new WeakReference<>(show);
            } else if (interceptCallback != null) {
                if (z) {
                    invokeStatistic.setPage("package");
                    interceptCallback.onResult(e(appContext, str, invokeStatistic));
                    return;
                }
                interceptCallback.onResult(true);
            }
        }
    }

    @SuppressLint({"PrivateResource"})
    public void h(String str, String str2, boolean z, InterceptCallback interceptCallback, boolean z2, InvokeStatistic invokeStatistic) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, str2, Boolean.valueOf(z), interceptCallback, Boolean.valueOf(z2), invokeStatistic}) == null) {
            SchemeCheckInfo schemeInGlobalWhiteList = OpenAppManager.getSchemeInGlobalWhiteList(AppRuntime.getAppContext(), "", str, "", null, true);
            if (schemeInGlobalWhiteList == null) {
                schemeInGlobalWhiteList = SchemeCheckInfoKt.defaultSchemeCheckInfo(str);
            }
            g(schemeInGlobalWhiteList, str2, z, interceptCallback, z2, invokeStatistic);
        }
    }
}

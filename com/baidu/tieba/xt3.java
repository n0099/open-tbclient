package com.baidu.tieba;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.swan.game.ad.downloader.model.DownloadParams;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
import com.baidu.swan.game.ad.downloader.view.SwanAdDownloadButtonView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes8.dex */
public class xt3 implements vt3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public SwanAdDownloadButtonView b;
    public wt3 c;
    public qt3 d;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xt3 a;

        public a(xt3 xt3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xt3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xt3Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || hu3.b() == null) {
                return;
            }
            if (this.a.c.a == DownloadState.NOT_START || this.a.c.a == DownloadState.DELETED) {
                hu3.b().d(this.a.a, ((DownloadParams) this.a.p()).a(), DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.a.d);
            }
            if (this.a.c.a == DownloadState.DOWNLOADING) {
                hu3.b().d(this.a.a, ((DownloadParams) this.a.p()).a(), DownloadParams.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, this.a.d);
            }
            if (this.a.c.a == DownloadState.DOWNLOAD_PAUSED) {
                hu3.b().d(this.a.a, ((DownloadParams) this.a.p()).a(), DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.a.d);
            }
            if (this.a.c.a == DownloadState.DOWNLOAD_FAILED) {
                hu3.b().d(this.a.a, ((DownloadParams) this.a.p()).a(), DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.a.d);
            }
            if (this.a.c.a == DownloadState.DOWNLOADED) {
                this.a.d.b();
                hu3.b().d(this.a.a, ((DownloadParams) this.a.p()).a(), DownloadParams.SwanAppDownloadType.TYPE_INSTALL_APP, this.a.d);
            }
            if (this.a.c.a == DownloadState.INSTALLED) {
                String e = this.a.d.e();
                if (TextUtils.isEmpty(this.a.c.b) && !TextUtils.isEmpty(e)) {
                    this.a.a(e);
                }
                xt3 xt3Var = this.a;
                xt3Var.r(xt3Var.c.b);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static /* synthetic */ class b {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-278064524, "Lcom/baidu/tieba/xt3$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-278064524, "Lcom/baidu/tieba/xt3$b;");
                    return;
                }
            }
            int[] iArr = new int[DownloadState.values().length];
            a = iArr;
            try {
                iArr[DownloadState.NOT_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[DownloadState.DOWNLOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[DownloadState.DOWNLOAD_PAUSED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[DownloadState.DOWNLOADED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[DownloadState.DOWNLOAD_FAILED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[DownloadState.INSTALLED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public xt3() {
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

    @Override // com.baidu.tieba.vt3
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            u(this.b);
        }
    }

    @Override // com.baidu.tieba.vt3
    public View getRealView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.b;
        }
        return (View) invokeV.objValue;
    }

    public Object p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.b.getTag();
        }
        return invokeV.objValue;
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.b.setOnClickListener(new a(this));
        }
    }

    public static float m(float f) {
        InterceptResult invokeF;
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65541, null, f)) == null) {
            DisplayMetrics displayMetrics = AppRuntime.getAppContext().getResources().getDisplayMetrics();
            if (displayMetrics != null) {
                f2 = displayMetrics.density;
            } else {
                f2 = 0.0f;
            }
            return f * f2;
        }
        return invokeF.floatValue;
    }

    @Override // com.baidu.tieba.vt3
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.c.b = str;
        }
    }

    @Override // com.baidu.tieba.vt3
    public void b(DownloadState downloadState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadState) == null) {
            v(downloadState);
        }
    }

    @Override // com.baidu.tieba.vt3
    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            t(i);
        }
    }

    @Override // com.baidu.tieba.vt3
    public void e(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, obj) == null) {
            this.b.setTag(obj);
        }
    }

    public final void t(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            wt3 wt3Var = this.c;
            if (i != wt3Var.c) {
                wt3Var.c = i;
                w();
            }
        }
    }

    public final void v(DownloadState downloadState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, downloadState) == null) {
            wt3 wt3Var = this.c;
            if (downloadState != wt3Var.a) {
                wt3Var.a = downloadState;
                w();
            }
        }
    }

    public final float n(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048585, this, context, i)) == null) {
            TypedValue typedValue = new TypedValue();
            context.getResources().getValue(i, typedValue, true);
            return typedValue.getFloat();
        }
        return invokeLI.floatValue;
    }

    @Override // com.baidu.tieba.vt3
    public /* bridge */ /* synthetic */ vt3 c(Context context, DownloadParams downloadParams, qt3 qt3Var) {
        l(context, downloadParams, qt3Var);
        return this;
    }

    public xt3 l(Context context, DownloadParams downloadParams, qt3 qt3Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, downloadParams, qt3Var)) == null) {
            this.a = context;
            this.c = wt3.a(downloadParams.a, downloadParams.b);
            this.d = qt3Var;
            k();
            q();
            return this;
        }
        return (xt3) invokeLLL.objValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.b = new SwanAdDownloadButtonView(this.a);
            String string = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1519);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 81;
            layoutParams.bottomMargin = (int) (this.a.getResources().getDisplayMetrics().heightPixels * 0.14d);
            this.b.setLayoutParams(layoutParams);
            float n = n(this.a, R.dimen.obfuscated_res_0x7f0707e5);
            int color = this.a.getResources().getColor(R.color.obfuscated_res_0x7f060aea);
            u(this.b);
            SwanAdDownloadButtonView swanAdDownloadButtonView = this.b;
            swanAdDownloadButtonView.j(m(n));
            swanAdDownloadButtonView.f(true);
            swanAdDownloadButtonView.i(-1);
            swanAdDownloadButtonView.h(color);
            swanAdDownloadButtonView.g(true);
            this.b.setText(string);
            this.b.setVisibility(0);
            this.b.setProgress(this.c.c);
        }
    }

    public final ResolveInfo o(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, context, str)) == null) {
            if (context == null || TextUtils.isEmpty(str)) {
                return null;
            }
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(str);
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
            if (queryIntentActivities.size() <= 0) {
                return null;
            }
            return queryIntentActivities.iterator().next();
        }
        return (ResolveInfo) invokeLL.objValue;
    }

    public final void r(String str) {
        ResolveInfo o;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048589, this, str) != null) || TextUtils.isEmpty(str) || (o = o(this.a, str)) == null) {
            return;
        }
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        ActivityInfo activityInfo = o.activityInfo;
        intent.setComponent(new ComponentName(activityInfo.packageName, activityInfo.name));
        intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
        try {
            this.a.startActivity(intent);
        } catch (Exception unused) {
        }
    }

    public final int s(DownloadState downloadState) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, downloadState)) == null) {
            switch (b.a[downloadState.ordinal()]) {
                case 1:
                default:
                    return R.string.obfuscated_res_0x7f0f1519;
                case 2:
                    return R.string.obfuscated_res_0x7f0f151e;
                case 3:
                    return R.string.obfuscated_res_0x7f0f151a;
                case 4:
                    return R.string.obfuscated_res_0x7f0f151c;
                case 5:
                    return R.string.obfuscated_res_0x7f0f151b;
                case 6:
                    return R.string.obfuscated_res_0x7f0f151d;
            }
        }
        return invokeL.intValue;
    }

    public final void u(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, view2) == null) && view2 != null) {
            float n = n(this.a, R.dimen.obfuscated_res_0x7f0707e6);
            float n2 = n(this.a, R.dimen.obfuscated_res_0x7f0707e4);
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(-1, -2);
                view2.setLayoutParams(layoutParams);
            }
            if (n >= 0.0f && n <= 1.0f) {
                n *= this.a.getResources().getDisplayMetrics().widthPixels;
            }
            if (n2 > 0.0f && n2 <= 1.0f) {
                n2 *= this.a.getResources().getDisplayMetrics().heightPixels;
            }
            layoutParams.width = (int) n;
            layoutParams.height = (int) n2;
        }
    }

    public final void w() {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            wt3 wt3Var = this.c;
            if (wt3Var.a == DownloadState.DOWNLOADING) {
                SwanAdDownloadButtonView swanAdDownloadButtonView = this.b;
                if (swanAdDownloadButtonView != null && swanAdDownloadButtonView.getVisibility() != 8) {
                    if (this.c.c < this.b.getMax()) {
                        String string2 = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1518);
                        string = String.format(string2, this.c.c + "%");
                    } else {
                        string = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f151c);
                    }
                    this.b.setText(string);
                    this.b.setProgress(this.c.c);
                }
            } else {
                if (hv3.a(this.a, wt3Var.b)) {
                    this.c.a = DownloadState.INSTALLED;
                }
                String string3 = this.a.getResources().getString(s(this.c.a));
                if (this.c.a == DownloadState.DOWNLOADED) {
                    this.b.setProgress(100);
                }
                wt3 wt3Var2 = this.c;
                if (wt3Var2.a == DownloadState.DOWNLOAD_PAUSED) {
                    this.b.setProgress(wt3Var2.c);
                }
                this.b.setText(string3);
            }
            SwanAdDownloadButtonView swanAdDownloadButtonView2 = this.b;
            if (swanAdDownloadButtonView2 != null) {
                swanAdDownloadButtonView2.postInvalidate();
            }
        }
    }
}

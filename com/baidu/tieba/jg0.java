package com.baidu.tieba;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class jg0 extends ym0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static final class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ long b;
        public final /* synthetic */ long c;
        public final /* synthetic */ String d;

        public a(long j, long j2, long j3, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j;
            this.b = j2;
            this.c = j3;
            this.d = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a < lg0.c()) {
                    lg0.z();
                } else if (lg0.f()) {
                    return;
                } else {
                    lg0.h(this.b, this.c, this.d);
                }
                lg0.g(this.b, "boot_from_cold", this.c, this.d);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ long b;
        public final /* synthetic */ String c;

        public b(long j, long j2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j), Long.valueOf(j2), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j;
            this.b = j2;
            this.c = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                lg0.g(this.a, "boot_from_background", this.b, this.c);
            }
        }
    }

    public jg0() {
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

    @Override // com.baidu.tieba.ym0, com.baidu.tieba.bn0
    public void onActivityCreated(Activity activity, Bundle bundle) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, activity, bundle) == null) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            if (!TextUtils.equals(activity.getLocalClassName(), "MainActivity")) {
                return;
            }
            if (!lg0.d()) {
                lg0.l();
                return;
            }
            String i = lg0.i();
            long j2 = lg0.j();
            a aVar = new a(System.currentTimeMillis() - j2, j2, System.currentTimeMillis(), i);
            Handler handler = new Handler();
            j = kg0.a;
            handler.postDelayed(aVar, j);
        }
    }

    @Override // com.baidu.tieba.ym0, com.baidu.tieba.bn0
    public void onBackgroundToForeground(Activity activity) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            if (!lg0.d()) {
                lg0.l();
            } else if (!TextUtils.equals(activity.getLocalClassName(), lg0.k())) {
            } else {
                String i = lg0.i();
                long j2 = lg0.j();
                long currentTimeMillis = System.currentTimeMillis();
                if (System.currentTimeMillis() - j2 < lg0.c()) {
                    lg0.z();
                    lg0.y();
                }
                b bVar = new b(j2, currentTimeMillis, i);
                Handler handler = new Handler();
                j = kg0.a;
                handler.postDelayed(bVar, j);
            }
        }
    }

    @Override // com.baidu.tieba.ym0, com.baidu.tieba.bn0
    public void onForegroundToBackground(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            lg0.w(activity);
        }
    }
}

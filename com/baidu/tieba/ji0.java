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
/* loaded from: classes6.dex */
public final class ji0 extends yo0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
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
                if (this.a < li0.c()) {
                    li0.z();
                } else if (li0.f()) {
                    return;
                } else {
                    li0.h(this.b, this.c, this.d);
                }
                li0.g(this.b, "boot_from_cold", this.c, this.d);
            }
        }
    }

    /* loaded from: classes6.dex */
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
                li0.g(this.a, "boot_from_background", this.b, this.c);
            }
        }
    }

    public ji0() {
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

    @Override // com.baidu.tieba.yo0, com.baidu.tieba.bp0
    public void onActivityCreated(Activity activity, Bundle bundle) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, activity, bundle) == null) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            if (!TextUtils.equals(activity.getLocalClassName(), "MainActivity")) {
                return;
            }
            if (!li0.d()) {
                li0.l();
                return;
            }
            String i = li0.i();
            long j2 = li0.j();
            a aVar = new a(System.currentTimeMillis() - j2, j2, System.currentTimeMillis(), i);
            Handler handler = new Handler();
            j = ki0.a;
            handler.postDelayed(aVar, j);
        }
    }

    @Override // com.baidu.tieba.yo0, com.baidu.tieba.bp0
    public void onBackgroundToForeground(Activity activity) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            if (!li0.d()) {
                li0.l();
            } else if (!TextUtils.equals(activity.getLocalClassName(), li0.k())) {
            } else {
                String i = li0.i();
                long j2 = li0.j();
                long currentTimeMillis = System.currentTimeMillis();
                if (System.currentTimeMillis() - j2 < li0.c()) {
                    li0.z();
                    li0.y();
                }
                b bVar = new b(j2, currentTimeMillis, i);
                Handler handler = new Handler();
                j = ki0.a;
                handler.postDelayed(bVar, j);
            }
        }
    }

    @Override // com.baidu.tieba.yo0, com.baidu.tieba.bp0
    public void onForegroundToBackground(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            li0.w(activity);
        }
    }
}

package com.baidu.tieba;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Process;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class yi5 implements xi5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;
    public wi5 b;
    public Application c;
    public String d;
    public final dj5 e;
    public final ej5 f;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public class b extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yi5 this$0;

        public b(yi5 yi5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yi5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = yi5Var;
        }

        public /* synthetic */ b(yi5 yi5Var, a aVar) {
            this(yi5Var);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            ui5 a;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(1048576, this, context, intent) != null) || intent == null) {
                return;
            }
            if (!zi5.i()) {
                String c = zi5.c();
                zi5.m(c + " Process Not In WhiteList，No Receive");
            } else if (!"intent.action.ACTION.TB.MUTI_PROCESS".equals(intent.getAction()) || (a = this.this$0.e.a(intent)) == null) {
            } else {
                int myPid = Process.myPid();
                int pid = a.getPid();
                if (a != null && a.getType() == 1) {
                    if (myPid == pid) {
                        return;
                    }
                } else if (a.getType() == 2) {
                    if (myPid != pid) {
                        return;
                    }
                } else if (a.getType() == 3 && !zi5.l()) {
                    return;
                }
                if (this.this$0.b != null) {
                    this.this$0.b.a(a);
                }
            }
        }
    }

    public yi5(Application application) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {application};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = null;
        this.e = new dj5();
        this.f = new ej5();
        this.c = application;
    }

    public final void f(ui5 ui5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ui5Var) == null) {
            if (ui5Var != null) {
                try {
                    Intent intent = new Intent();
                    intent.setPackage(e());
                    intent.setAction("intent.action.ACTION.TB.MUTI_PROCESS");
                    this.f.a(intent, ui5Var);
                    this.c.sendBroadcast(intent);
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            throw new NullPointerException("send multi-process message is null");
        }
    }

    @Override // com.baidu.tieba.xi5
    public void a(ui5 ui5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ui5Var) == null) {
            f(ui5Var);
        }
    }

    @Override // com.baidu.tieba.xi5
    public void b(wi5 wi5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wi5Var) == null) {
            this.b = wi5Var;
        }
    }

    private void registerReceiver() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            try {
                unregisterReceiver();
                this.a = new b(this, null);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.setPriority(1000);
                intentFilter.addAction("intent.action.ACTION.TB.MUTI_PROCESS");
                this.c.registerReceiver(this.a, intentFilter);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void unregisterReceiver() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            try {
                if (this.a != null && this.c != null) {
                    this.c.unregisterReceiver(this.a);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final String e() {
        InterceptResult invokeV;
        Application application;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.d == null && (application = this.c) != null) {
                this.d = application.getPackageName();
            }
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xi5
    public void startService() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            registerReceiver();
        }
    }

    public void stopService() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            unregisterReceiver();
        }
    }
}

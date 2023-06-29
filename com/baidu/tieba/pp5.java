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
public class pp5 implements op5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;
    public np5 b;
    public Application c;
    public String d;
    public final up5 e;
    public final vp5 f;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public class b extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pp5 this$0;

        public b(pp5 pp5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pp5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = pp5Var;
        }

        public /* synthetic */ b(pp5 pp5Var, a aVar) {
            this(pp5Var);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            lp5 a;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(1048576, this, context, intent) != null) || intent == null) {
                return;
            }
            if (!qp5.i()) {
                String c = qp5.c();
                qp5.m(c + " Process Not In WhiteList，No Receive");
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
                } else if (a.getType() == 3 && !qp5.l()) {
                    return;
                }
                if (this.this$0.b != null) {
                    this.this$0.b.a(a);
                }
            }
        }
    }

    public pp5(Application application) {
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
        this.e = new up5();
        this.f = new vp5();
        this.c = application;
    }

    public final void f(lp5 lp5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, lp5Var) == null) {
            if (lp5Var != null) {
                try {
                    Intent intent = new Intent();
                    intent.setPackage(e());
                    intent.setAction("intent.action.ACTION.TB.MUTI_PROCESS");
                    this.f.a(intent, lp5Var);
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

    @Override // com.baidu.tieba.op5
    public void a(lp5 lp5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, lp5Var) == null) {
            f(lp5Var);
        }
    }

    @Override // com.baidu.tieba.op5
    public void b(np5 np5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, np5Var) == null) {
            this.b = np5Var;
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

    @Override // com.baidu.tieba.op5
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

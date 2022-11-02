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
/* loaded from: classes4.dex */
public class jb5 implements ib5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;
    public hb5 b;
    public Application c;
    public String d;
    public final ob5 e;
    public final pb5 f;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public class b extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jb5 this$0;

        public b(jb5 jb5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jb5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = jb5Var;
        }

        public /* synthetic */ b(jb5 jb5Var, a aVar) {
            this(jb5Var);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            fb5 a;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(1048576, this, context, intent) != null) || intent == null) {
                return;
            }
            if (!kb5.i()) {
                String c = kb5.c();
                kb5.m(c + " Process Not In WhiteList，No Receive");
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
                } else if (a.getType() == 3 && !kb5.l()) {
                    return;
                }
                if (this.this$0.b != null) {
                    this.this$0.b.a(a);
                }
            }
        }
    }

    public jb5(Application application) {
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
        this.e = new ob5();
        this.f = new pb5();
        this.c = application;
    }

    public final void f(fb5 fb5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fb5Var) == null) {
            if (fb5Var != null) {
                try {
                    Intent intent = new Intent();
                    intent.setPackage(e());
                    intent.setAction("intent.action.ACTION.TB.MUTI_PROCESS");
                    this.f.a(intent, fb5Var);
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

    @Override // com.baidu.tieba.ib5
    public void a(fb5 fb5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fb5Var) == null) {
            f(fb5Var);
        }
    }

    @Override // com.baidu.tieba.ib5
    public void b(hb5 hb5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hb5Var) == null) {
            this.b = hb5Var;
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

    @Override // com.baidu.tieba.ib5
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

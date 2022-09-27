package com.baidu.tieba;

import android.content.IntentFilter;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.swan.apps.network.NetworkBroadcastReceiver;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class wu2 extends m33 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;
    public NetworkBroadcastReceiver a;
    public TelephonyManager b;
    public a c;

    /* loaded from: classes6.dex */
    public class a extends PhoneStateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<CallbackHandler> a;
        public String b;
        public String c;
        public final /* synthetic */ wu2 d;

        public a(wu2 wu2Var, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wu2Var, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = wu2Var;
            this.c = "";
            this.a = new WeakReference<>(callbackHandler);
            this.b = str;
        }

        public void a(CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, callbackHandler, str) == null) {
                this.a = new WeakReference<>(callbackHandler);
                this.b = str;
            }
        }

        @Override // android.telephony.PhoneStateListener
        public void onDataConnectionStateChanged(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) {
                if (wu2.d) {
                    Log.d("PhoneStateListener", "——> onDataConnectionStateChanged: state " + i + " networkType " + i2);
                }
                if (2 == i) {
                    String d = SwanAppNetworkUtils.d(i2, null);
                    if (TextUtils.isEmpty(d) || d.equals(this.c)) {
                        return;
                    }
                    this.c = d;
                    SwanAppNetworkUtils.k(this.d, this.a.get(), this.b);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948282997, "Lcom/baidu/tieba/wu2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948282997, "Lcom/baidu/tieba/wu2;");
                return;
            }
        }
        d = vj1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wu2(l33 l33Var) {
        super(l33Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {l33Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((l33) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public void a(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, callbackHandler, str) == null) {
            if (this.b == null) {
                this.b = (TelephonyManager) getSystemService("phone");
                a aVar = new a(this, callbackHandler, str);
                this.c = aVar;
                this.b.listen(aVar, 64);
                return;
            }
            a aVar2 = this.c;
            if (aVar2 != null) {
                aVar2.a(callbackHandler, str);
            }
        }
    }

    public void b(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, callbackHandler, str) == null) {
            NetworkBroadcastReceiver networkBroadcastReceiver = this.a;
            if (networkBroadcastReceiver == null) {
                this.a = new NetworkBroadcastReceiver(callbackHandler, str);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                registerReceiver(this.a, intentFilter);
            } else if (networkBroadcastReceiver != null) {
                networkBroadcastReceiver.updateCallback(callbackHandler, str);
            }
            a(callbackHandler, str);
        }
    }
}

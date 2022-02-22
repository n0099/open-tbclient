package com.baidu.yunjiasu.tornadosdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.yunjiasu.tornadosdk.IAction;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\n"}, d2 = {"Lcom/baidu/yunjiasu/tornadosdk/TornadoBroadcast;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "Companion", "tornadosdk_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class TornadoBroadcast extends BroadcastReceiver {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Companion Companion;
    public static final String TAG = "TornadoBroadcast";
    public transient /* synthetic */ FieldHolder $fh;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0016\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\u000f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/baidu/yunjiasu/tornadosdk/TornadoBroadcast$Companion;", "", "()V", "TAG", "", "onReceiveT2T", "", "intent", "Landroid/content/Intent;", MiPushClient.COMMAND_REGISTER, "c", "Landroid/content/Context;", "broadcastReceiver", "Landroid/content/BroadcastReceiver;", "sendPing", "unRegister", "tornadosdk_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Companion() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void onReceiveT2T(Intent intent) {
            String action;
            String string;
            String str;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, intent) == null) || intent == null || (action = intent.getAction()) == null) {
                return;
            }
            switch (action.hashCode()) {
                case -1955832654:
                    if (action.equals(IAction.T2T.EVENT_BOOSTER_START_OK)) {
                        Bundle extras = intent.getExtras();
                        string = extras != null ? extras.getString(IAction.EXTRA.VALUE_STRING) : null;
                        str = string != null ? string : "";
                        LogTo.INSTANCE.d("*****", "[TornadoBroadcast] EVENT_BOOSTER_START_OK");
                        Tornado.INSTANCE.onEvent$tornadosdk_release(TornadoEvent.EVENT_BOOSTER_START_OK, str);
                        return;
                    }
                    return;
                case -728577181:
                    if (action.equals(IAction.T2T.EVENT_BOOSTER_START_FAIL_WITH_TOKEN_INVALID)) {
                        Bundle extras2 = intent.getExtras();
                        string = extras2 != null ? extras2.getString(IAction.EXTRA.VALUE_STRING) : null;
                        str = string != null ? string : "";
                        LogTo.INSTANCE.d("*****", "[TornadoBroadcast] EVENT_BOOSTER_START_FAIL_WITH_TOKEN_INVALID");
                        Tornado.INSTANCE.onEvent$tornadosdk_release(TornadoEvent.EVENT_BOOSTER_START_FAIL_WITH_TOKEN_INVALID, str);
                        Tornado.INSTANCE.stop();
                        return;
                    }
                    return;
                case 435945019:
                    if (action.equals(IAction.T2T.EVENT_BOOSTER_STOP)) {
                        Bundle extras3 = intent.getExtras();
                        string = extras3 != null ? extras3.getString(IAction.EXTRA.VALUE_STRING) : null;
                        str = string != null ? string : "";
                        LogTo.INSTANCE.d("*****", Intrinsics.stringPlus("[TornadoBroadcast] EVENT_BOOSTER_STOP ", str));
                        Tornado.INSTANCE.onEvent$tornadosdk_release(TornadoEvent.EVENT_BOOSTER_STOP, str);
                        Tornado.INSTANCE.stop();
                        return;
                    }
                    return;
                case 1640219764:
                    if (action.equals(IAction.T2T.EVENT_BOOSTER_START_FAIL)) {
                        Bundle extras4 = intent.getExtras();
                        string = extras4 != null ? extras4.getString(IAction.EXTRA.VALUE_STRING) : null;
                        str = string != null ? string : "";
                        LogTo.INSTANCE.d("*****", "[TornadoBroadcast] EVENT_BOOSTER_START_FAIL");
                        Tornado.INSTANCE.onEvent$tornadosdk_release(TornadoEvent.EVENT_BOOSTER_START_FAIL, str);
                        Tornado.INSTANCE.stop();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }

        public final void register(Context c2, BroadcastReceiver broadcastReceiver) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c2, broadcastReceiver) == null) {
                Intrinsics.checkNotNullParameter(c2, "c");
                Intrinsics.checkNotNullParameter(broadcastReceiver, "broadcastReceiver");
                LogTo.INSTANCE.i(TornadoBroadcast.TAG, "register() --");
                try {
                    IntentFilter intentFilter = new IntentFilter();
                    for (String str : IAction.T2T.INSTANCE.getActionMap().values()) {
                        intentFilter.addAction(str);
                    }
                    c2.registerReceiver(broadcastReceiver, intentFilter);
                } catch (Exception e2) {
                    LogTo.INSTANCE.e(TornadoBroadcast.TAG, Intrinsics.stringPlus("register(): Exception: ", e2.getMessage()));
                }
            }
        }

        public final void sendPing(Context c2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, c2) == null) {
                Intrinsics.checkNotNullParameter(c2, "c");
                c2.sendBroadcast(new Intent(IAction.VPN.PING));
            }
        }

        public final void unRegister(Context c2, BroadcastReceiver broadcastReceiver) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, c2, broadcastReceiver) == null) {
                Intrinsics.checkNotNullParameter(c2, "c");
                Intrinsics.checkNotNullParameter(broadcastReceiver, "broadcastReceiver");
                LogTo.INSTANCE.i(TornadoBroadcast.TAG, "unRegister() --");
                try {
                    c2.unregisterReceiver(broadcastReceiver);
                } catch (Exception unused) {
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1293152972, "Lcom/baidu/yunjiasu/tornadosdk/TornadoBroadcast;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1293152972, "Lcom/baidu/yunjiasu/tornadosdk/TornadoBroadcast;");
                return;
            }
        }
        Companion = new Companion(null);
    }

    public TornadoBroadcast() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) || intent == null) {
            return;
        }
        Collection<String> values = IAction.T2T.INSTANCE.getActionMap().values();
        String action = intent.getAction();
        Intrinsics.checkNotNull(action);
        if (values.contains(action)) {
            Companion.onReceiveT2T(intent);
        }
    }
}

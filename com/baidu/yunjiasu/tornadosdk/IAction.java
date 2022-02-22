package com.baidu.yunjiasu.tornadosdk;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0006"}, d2 = {"Lcom/baidu/yunjiasu/tornadosdk/IAction;", "", "()V", "EXTRA", "T2T", "VPN", "tornadosdk_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class IAction {
    public static /* synthetic */ Interceptable $ic;
    public static final IAction INSTANCE;
    public transient /* synthetic */ FieldHolder $fh;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/baidu/yunjiasu/tornadosdk/IAction$EXTRA;", "", "()V", "VALUE_BOOL", "", "VALUE_LONG", "VALUE_STRING", "tornadosdk_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class EXTRA {
        public static /* synthetic */ Interceptable $ic = null;
        public static final EXTRA INSTANCE;
        public static final String VALUE_BOOL = "TRD_BOOL";
        public static final String VALUE_LONG = "TRD_LONG";
        public static final String VALUE_STRING = "TRD_STRING";
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2037711947, "Lcom/baidu/yunjiasu/tornadosdk/IAction$EXTRA;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2037711947, "Lcom/baidu/yunjiasu/tornadosdk/IAction$EXTRA;");
                    return;
                }
            }
            INSTANCE = new EXTRA();
        }

        public EXTRA() {
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
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R&\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00040\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/baidu/yunjiasu/tornadosdk/IAction$T2T;", "", "()V", "EVENT_BOOSTER_PREPARE_FAIL", "", "EVENT_BOOSTER_PREPARE_OK", "EVENT_BOOSTER_SCLIENT_EOF", "EVENT_BOOSTER_START_FAIL", "EVENT_BOOSTER_START_FAIL_WITH_TOKEN_INVALID", "EVENT_BOOSTER_START_OK", "EVENT_BOOSTER_STOP", "EVENT_REMOTE_EVENT_CLOSED", "EVENT_SCLIENT_HAND_SHAKE_FAIL", "EVENT_SCLIENT_HAND_SHAKE_OK", "TAG", "actionMap", "", "", "getActionMap", "()Ljava/util/Map;", "setActionMap", "(Ljava/util/Map;)V", "tornadosdk_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class T2T {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String EVENT_BOOSTER_PREPARE_FAIL = "com.baidu.yunjiasu.tornadosdk.t2t.EVENT_BOOSTER_PREPARE_FAIL";
        public static final String EVENT_BOOSTER_PREPARE_OK = "com.baidu.yunjiasu.tornadosdk.t2t.EVENT_BOOSTER_PREPARE_OK";
        public static final String EVENT_BOOSTER_SCLIENT_EOF = "com.baidu.yunjiasu.tornadosdk.t2t.EVENT_BOOSTER_SCLIENT_EOF";
        public static final String EVENT_BOOSTER_START_FAIL = "com.baidu.yunjiasu.tornadosdk.t2t.EVENT_BOOSTER_START_FAIL";
        public static final String EVENT_BOOSTER_START_FAIL_WITH_TOKEN_INVALID = "com.baidu.yunjiasu.tornadosdk.t2t.EVENT_BOOSTER_START_FAIL_WITH_TOKEN_INVALID";
        public static final String EVENT_BOOSTER_START_OK = "com.baidu.yunjiasu.tornadosdk.t2t.EVENT_BOOSTER_START_OK";
        public static final String EVENT_BOOSTER_STOP = "com.baidu.yunjiasu.tornadosdk.t2t.EVENT_BOOSTER_STOP";
        public static final String EVENT_REMOTE_EVENT_CLOSED = "com.baidu.yunjiasu.tornadosdk.t2t.EVENT_REMOTE_EVENT_CLOSED";
        public static final String EVENT_SCLIENT_HAND_SHAKE_FAIL = "com.baidu.yunjiasu.tornadosdk.t2t.EVENT_SCLIENT_HAND_SHAKE_FAIL";
        public static final String EVENT_SCLIENT_HAND_SHAKE_OK = "com.baidu.yunjiasu.tornadosdk.t2t.EVENT_SCLIENT_HAND_SHAKE_OK";
        public static final T2T INSTANCE;
        public static final String TAG = "com.baidu.yunjiasu.tornadosdk.t2t";
        public static Map<Long, String> actionMap;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(641636165, "Lcom/baidu/yunjiasu/tornadosdk/IAction$T2T;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(641636165, "Lcom/baidu/yunjiasu/tornadosdk/IAction$T2T;");
                    return;
                }
            }
            INSTANCE = new T2T();
            actionMap = MapsKt__MapsKt.mapOf(TuplesKt.to(0L, EVENT_BOOSTER_PREPARE_OK), TuplesKt.to(1L, EVENT_BOOSTER_PREPARE_FAIL), TuplesKt.to(21L, EVENT_BOOSTER_START_OK), TuplesKt.to(22L, EVENT_BOOSTER_START_FAIL), TuplesKt.to(23L, EVENT_BOOSTER_START_FAIL_WITH_TOKEN_INVALID), TuplesKt.to(51L, EVENT_SCLIENT_HAND_SHAKE_OK), TuplesKt.to(52L, EVENT_SCLIENT_HAND_SHAKE_FAIL), TuplesKt.to(61L, EVENT_REMOTE_EVENT_CLOSED), TuplesKt.to(31L, EVENT_BOOSTER_STOP), TuplesKt.to(41L, EVENT_BOOSTER_SCLIENT_EOF));
        }

        public T2T() {
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

        public final Map<Long, String> getActionMap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? actionMap : (Map) invokeV.objValue;
        }

        public final void setActionMap(Map<Long, String> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map) == null) {
                Intrinsics.checkNotNullParameter(map, "<set-?>");
                actionMap = map;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/baidu/yunjiasu/tornadosdk/IAction$VPN;", "", "()V", "EVENT", "", "PING", "TAG_VPN", "tornadosdk_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class VPN {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String EVENT = "com.baidu.yunjiasu.tornadosdk.vpnservice.EVENT";
        public static final VPN INSTANCE;
        public static final String PING = "com.baidu.yunjiasu.tornadosdk.vpnservice.PING";
        public static final String TAG_VPN = "com.baidu.yunjiasu.tornadosdk.vpnservice";
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(641724391, "Lcom/baidu/yunjiasu/tornadosdk/IAction$VPN;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(641724391, "Lcom/baidu/yunjiasu/tornadosdk/IAction$VPN;");
                    return;
                }
            }
            INSTANCE = new VPN();
        }

        public VPN() {
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
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1757896169, "Lcom/baidu/yunjiasu/tornadosdk/IAction;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1757896169, "Lcom/baidu/yunjiasu/tornadosdk/IAction;");
                return;
            }
        }
        INSTANCE = new IAction();
    }

    public IAction() {
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
}

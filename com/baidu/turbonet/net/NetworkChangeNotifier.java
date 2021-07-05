package com.baidu.turbonet.net;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.turbonet.base.annotations.CalledByNative;
import com.baidu.turbonet.base.annotations.JNINamespace;
import com.baidu.turbonet.base.annotations.NativeClassQualifiedName;
import com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect;
import d.a.t0.a.b;
import java.util.ArrayList;
import java.util.Iterator;
@JNINamespace
/* loaded from: classes5.dex */
public class NetworkChangeNotifier {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static NetworkChangeNotifier f23017h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Context f23018a;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList<Long> f23019b;

    /* renamed from: c  reason: collision with root package name */
    public final b<ConnectionTypeObserver> f23020c;

    /* renamed from: d  reason: collision with root package name */
    public NetworkChangeNotifierAutoDetect f23021d;

    /* renamed from: e  reason: collision with root package name */
    public int f23022e;

    /* renamed from: f  reason: collision with root package name */
    public double f23023f;

    /* renamed from: g  reason: collision with root package name */
    public int f23024g;

    /* loaded from: classes5.dex */
    public interface ConnectionTypeObserver {
        void onConnectionTypeChanged(int i2);
    }

    /* loaded from: classes5.dex */
    public class a implements NetworkChangeNotifierAutoDetect.Observer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NetworkChangeNotifier f23025a;

        public a(NetworkChangeNotifier networkChangeNotifier) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {networkChangeNotifier};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23025a = networkChangeNotifier;
        }

        @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
        public void a(double d2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Double.valueOf(d2)}) == null) {
                this.f23025a.q(d2);
            }
        }

        @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                this.f23025a.l(i2);
            }
        }

        @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
        public void c(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                this.f23025a.k(i2);
            }
        }

        @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
        public void d(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
                this.f23025a.j(i2, i3);
            }
        }

        @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
        public void e(int[] iArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, iArr) == null) {
                this.f23025a.m(iArr);
            }
        }

        @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
        public void onConnectionTypeChanged(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
                this.f23025a.p(i2);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-674605621, "Lcom/baidu/turbonet/net/NetworkChangeNotifier;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-674605621, "Lcom/baidu/turbonet/net/NetworkChangeNotifier;");
        }
    }

    public NetworkChangeNotifier(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f23022e = 0;
        this.f23023f = Double.POSITIVE_INFINITY;
        this.f23024g = 0;
        this.f23018a = context.getApplicationContext();
        this.f23019b = new ArrayList<>();
        this.f23020c = new b<>();
    }

    public static NetworkChangeNotifier e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) ? f23017h : (NetworkChangeNotifier) invokeV.objValue;
    }

    public static double f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.AD_TEXT_ID, null, i2)) == null) ? nativeGetMaxBandwidthForConnectionSubtype(i2) : invokeI.doubleValue;
    }

    @CalledByNative
    public static void fakeDefaultNetwork(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(AdIconUtil.BAIDU_LOGO_ID, null, i2, i3) == null) {
            e().h(i3, i2);
        }
    }

    @CalledByNative
    public static void fakeMaxBandwidthChanged(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{Double.valueOf(d2)}) == null) {
            e().i(d2);
        }
    }

    @CalledByNative
    public static void fakeNetworkConnected(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65544, null, i2, i3) == null) {
            e().j(i2, i3);
        }
    }

    @CalledByNative
    public static void fakeNetworkDisconnected(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65545, null, i2) == null) {
            e().k(i2);
        }
    }

    @CalledByNative
    public static void fakeNetworkSoonToBeDisconnected(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65546, null, i2) == null) {
            e().l(i2);
        }
    }

    @CalledByNative
    public static void fakePurgeActiveNetworkList(int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, iArr) == null) {
            e().m(iArr);
        }
    }

    @CalledByNative
    public static void forceConnectivityState(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65548, null, z) == null) {
            e().d(z);
        }
    }

    @CalledByNative
    public static NetworkChangeNotifier init(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, context)) == null) {
            if (f23017h == null) {
                f23017h = new NetworkChangeNotifier(context);
            }
            return f23017h;
        }
        return (NetworkChangeNotifier) invokeL.objValue;
    }

    public static void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, null) == null) {
            e().o(true, new RegistrationPolicyAlwaysRegister());
        }
    }

    public static native double nativeGetMaxBandwidthForConnectionSubtype(int i2);

    @NativeClassQualifiedName
    private native void nativeNotifyConnectionTypeChanged(long j, int i2, int i3);

    @NativeClassQualifiedName
    private native void nativeNotifyMaxBandwidthChanged(long j, double d2);

    @NativeClassQualifiedName
    private native void nativeNotifyOfNetworkConnect(long j, int i2, int i3);

    @NativeClassQualifiedName
    private native void nativeNotifyOfNetworkDisconnect(long j, int i2);

    @NativeClassQualifiedName
    private native void nativeNotifyOfNetworkSoonToDisconnect(long j, int i2);

    @NativeClassQualifiedName
    private native void nativeNotifyPurgeActiveNetworkList(long j, int[] iArr);

    @CalledByNative
    public void addNativeObserver(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            this.f23019b.add(Long.valueOf(j));
        }
    }

    public final void c() {
        NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (networkChangeNotifierAutoDetect = this.f23021d) == null) {
            return;
        }
        networkChangeNotifierAutoDetect.destroy();
        this.f23021d = null;
    }

    public final void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if ((this.f23022e != 6) != z) {
                p(z ? 0 : 6);
                q(z ? Double.POSITIVE_INFINITY : 0.0d);
            }
        }
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            h(i2, getCurrentDefaultNetId());
        }
    }

    @CalledByNative
    public int getCurrentConnectionSubtype() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect = this.f23021d;
            if (networkChangeNotifierAutoDetect == null) {
                return 0;
            }
            return networkChangeNotifierAutoDetect.getCurrentConnectionSubtype(networkChangeNotifierAutoDetect.getCurrentNetworkState());
        }
        return invokeV.intValue;
    }

    @CalledByNative
    public int getCurrentConnectionType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f23022e : invokeV.intValue;
    }

    @CalledByNative
    public int getCurrentDefaultNetId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect = this.f23021d;
            if (networkChangeNotifierAutoDetect == null) {
                return -1;
            }
            return networkChangeNotifierAutoDetect.getDefaultNetId();
        }
        return invokeV.intValue;
    }

    @CalledByNative
    public double getCurrentMaxBandwidthInMbps() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f23023f : invokeV.doubleValue;
    }

    @CalledByNative
    public int[] getCurrentNetworksAndTypes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect = this.f23021d;
            return networkChangeNotifierAutoDetect == null ? new int[0] : networkChangeNotifierAutoDetect.getNetworksAndTypes();
        }
        return (int[]) invokeV.objValue;
    }

    public final void h(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048585, this, i2, i3) == null) {
            Iterator<Long> it = this.f23019b.iterator();
            while (it.hasNext()) {
                nativeNotifyConnectionTypeChanged(it.next().longValue(), i2, i3);
            }
            Iterator<ConnectionTypeObserver> it2 = this.f23020c.iterator();
            while (it2.hasNext()) {
                it2.next().onConnectionTypeChanged(i2);
            }
        }
    }

    public void i(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Double.valueOf(d2)}) == null) {
            Iterator<Long> it = this.f23019b.iterator();
            while (it.hasNext()) {
                nativeNotifyMaxBandwidthChanged(it.next().longValue(), d2);
            }
        }
    }

    public void j(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048587, this, i2, i3) == null) {
            Iterator<Long> it = this.f23019b.iterator();
            while (it.hasNext()) {
                nativeNotifyOfNetworkConnect(it.next().longValue(), i2, i3);
            }
        }
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            Iterator<Long> it = this.f23019b.iterator();
            while (it.hasNext()) {
                nativeNotifyOfNetworkDisconnect(it.next().longValue(), i2);
            }
        }
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            Iterator<Long> it = this.f23019b.iterator();
            while (it.hasNext()) {
                nativeNotifyOfNetworkSoonToDisconnect(it.next().longValue(), i2);
            }
        }
    }

    public void m(int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, iArr) == null) {
            Iterator<Long> it = this.f23019b.iterator();
            while (it.hasNext()) {
                nativeNotifyPurgeActiveNetworkList(it.next().longValue(), iArr);
            }
        }
    }

    public final void o(boolean z, NetworkChangeNotifierAutoDetect.RegistrationPolicy registrationPolicy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048591, this, z, registrationPolicy) == null) {
            if (z) {
                if (this.f23021d == null) {
                    NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect = new NetworkChangeNotifierAutoDetect(new a(this), this.f23018a, registrationPolicy);
                    this.f23021d = networkChangeNotifierAutoDetect;
                    NetworkChangeNotifierAutoDetect.d currentNetworkState = networkChangeNotifierAutoDetect.getCurrentNetworkState();
                    p(this.f23021d.getCurrentConnectionType(currentNetworkState));
                    q(this.f23021d.getCurrentMaxBandwidthInMbps(currentNetworkState));
                    return;
                }
                return;
            }
            c();
        }
    }

    public final void p(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.f23022e = i2;
            g(i2);
        }
    }

    public final void q(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Double.valueOf(d2)}) == null) {
            if (d2 == this.f23023f && this.f23022e == this.f23024g) {
                return;
            }
            this.f23023f = d2;
            this.f23024g = this.f23022e;
            i(d2);
        }
    }

    @CalledByNative
    public void removeNativeObserver(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048594, this, j) == null) {
            this.f23019b.remove(Long.valueOf(j));
        }
    }
}

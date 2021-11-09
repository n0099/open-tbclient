package com.baidu.turbonet.net;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import b.a.s0.a.b;
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
import java.util.ArrayList;
import java.util.Iterator;
@JNINamespace
/* loaded from: classes10.dex */
public class NetworkChangeNotifier {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static NetworkChangeNotifier f56485h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Context f56486a;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList<Long> f56487b;

    /* renamed from: c  reason: collision with root package name */
    public final b<ConnectionTypeObserver> f56488c;

    /* renamed from: d  reason: collision with root package name */
    public NetworkChangeNotifierAutoDetect f56489d;

    /* renamed from: e  reason: collision with root package name */
    public int f56490e;

    /* renamed from: f  reason: collision with root package name */
    public double f56491f;

    /* renamed from: g  reason: collision with root package name */
    public int f56492g;

    /* loaded from: classes10.dex */
    public interface ConnectionTypeObserver {
        void a(int i2);
    }

    /* loaded from: classes10.dex */
    public class a implements NetworkChangeNotifierAutoDetect.Observer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NetworkChangeNotifier f56493a;

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
            this.f56493a = networkChangeNotifier;
        }

        @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f56493a.p(i2);
            }
        }

        @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
        public void b(double d2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Double.valueOf(d2)}) == null) {
                this.f56493a.q(d2);
            }
        }

        @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
        public void c(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                this.f56493a.l(i2);
            }
        }

        @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
        public void d(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
                this.f56493a.k(i2);
            }
        }

        @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
        public void e(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048580, this, i2, i3) == null) {
                this.f56493a.j(i2, i3);
            }
        }

        @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
        public void f(int[] iArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, iArr) == null) {
                this.f56493a.m(iArr);
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
        this.f56490e = 0;
        this.f56491f = Double.POSITIVE_INFINITY;
        this.f56492g = 0;
        this.f56486a = context.getApplicationContext();
        this.f56487b = new ArrayList<>();
        this.f56488c = new b<>();
    }

    public static NetworkChangeNotifier e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? f56485h : (NetworkChangeNotifier) invokeV.objValue;
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
            if (f56485h == null) {
                f56485h = new NetworkChangeNotifier(context);
            }
            return f56485h;
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
            this.f56487b.add(Long.valueOf(j));
        }
    }

    public final void c() {
        NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (networkChangeNotifierAutoDetect = this.f56489d) == null) {
            return;
        }
        networkChangeNotifierAutoDetect.destroy();
        this.f56489d = null;
    }

    public final void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if ((this.f56490e != 6) != z) {
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
            NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect = this.f56489d;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f56490e : invokeV.intValue;
    }

    @CalledByNative
    public int getCurrentDefaultNetId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect = this.f56489d;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f56491f : invokeV.doubleValue;
    }

    @CalledByNative
    public int[] getCurrentNetworksAndTypes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect = this.f56489d;
            return networkChangeNotifierAutoDetect == null ? new int[0] : networkChangeNotifierAutoDetect.getNetworksAndTypes();
        }
        return (int[]) invokeV.objValue;
    }

    public final void h(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048585, this, i2, i3) == null) {
            Iterator<Long> it = this.f56487b.iterator();
            while (it.hasNext()) {
                nativeNotifyConnectionTypeChanged(it.next().longValue(), i2, i3);
            }
            Iterator<ConnectionTypeObserver> it2 = this.f56488c.iterator();
            while (it2.hasNext()) {
                it2.next().a(i2);
            }
        }
    }

    public void i(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Double.valueOf(d2)}) == null) {
            Iterator<Long> it = this.f56487b.iterator();
            while (it.hasNext()) {
                nativeNotifyMaxBandwidthChanged(it.next().longValue(), d2);
            }
        }
    }

    public void j(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048587, this, i2, i3) == null) {
            Iterator<Long> it = this.f56487b.iterator();
            while (it.hasNext()) {
                nativeNotifyOfNetworkConnect(it.next().longValue(), i2, i3);
            }
        }
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            Iterator<Long> it = this.f56487b.iterator();
            while (it.hasNext()) {
                nativeNotifyOfNetworkDisconnect(it.next().longValue(), i2);
            }
        }
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            Iterator<Long> it = this.f56487b.iterator();
            while (it.hasNext()) {
                nativeNotifyOfNetworkSoonToDisconnect(it.next().longValue(), i2);
            }
        }
    }

    public void m(int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, iArr) == null) {
            Iterator<Long> it = this.f56487b.iterator();
            while (it.hasNext()) {
                nativeNotifyPurgeActiveNetworkList(it.next().longValue(), iArr);
            }
        }
    }

    public final void o(boolean z, NetworkChangeNotifierAutoDetect.RegistrationPolicy registrationPolicy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048591, this, z, registrationPolicy) == null) {
            if (z) {
                if (this.f56489d == null) {
                    NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect = new NetworkChangeNotifierAutoDetect(new a(this), this.f56486a, registrationPolicy);
                    this.f56489d = networkChangeNotifierAutoDetect;
                    NetworkChangeNotifierAutoDetect.d currentNetworkState = networkChangeNotifierAutoDetect.getCurrentNetworkState();
                    p(this.f56489d.getCurrentConnectionType(currentNetworkState));
                    q(this.f56489d.getCurrentMaxBandwidthInMbps(currentNetworkState));
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
            this.f56490e = i2;
            g(i2);
        }
    }

    public final void q(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Double.valueOf(d2)}) == null) {
            if (d2 == this.f56491f && this.f56490e == this.f56492g) {
                return;
            }
            this.f56491f = d2;
            this.f56492g = this.f56490e;
            i(d2);
        }
    }

    @CalledByNative
    public void removeNativeObserver(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048594, this, j) == null) {
            this.f56487b.remove(Long.valueOf(j));
        }
    }
}

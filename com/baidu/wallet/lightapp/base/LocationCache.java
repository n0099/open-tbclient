package com.baidu.wallet.lightapp.base;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.lightapp.base.datamodel.LocationProvider;
/* loaded from: classes13.dex */
public final class LocationCache {
    public static /* synthetic */ Interceptable $ic;
    public static double a;

    /* renamed from: b  reason: collision with root package name */
    public static double f51453b;

    /* renamed from: c  reason: collision with root package name */
    public static Coord f51454c;

    /* renamed from: d  reason: collision with root package name */
    public static long f51455d;

    /* renamed from: e  reason: collision with root package name */
    public static LocationProvider f51456e;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes13.dex */
    public static final class Coord {
        public static final /* synthetic */ Coord[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Coord BD09LL;
        public static final Coord BD09MC;
        public static final Coord GCJ02;
        public static final Coord UNKNOWN;
        public static final Coord WGS84;
        public transient /* synthetic */ FieldHolder $fh;
        public int value;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1361300705, "Lcom/baidu/wallet/lightapp/base/LocationCache$Coord;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1361300705, "Lcom/baidu/wallet/lightapp/base/LocationCache$Coord;");
                    return;
                }
            }
            UNKNOWN = new Coord(RomUtils.UNKNOWN, 0, 0);
            WGS84 = new Coord("WGS84", 1, 1);
            GCJ02 = new Coord("GCJ02", 2, 3);
            BD09LL = new Coord("BD09LL", 3, 5);
            Coord coord = new Coord("BD09MC", 4, 6);
            BD09MC = coord;
            $VALUES = new Coord[]{UNKNOWN, WGS84, GCJ02, BD09LL, coord};
        }

        public Coord(String str, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.value = i3;
        }

        public static Coord valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Coord) Enum.valueOf(Coord.class, str) : (Coord) invokeL.objValue;
        }

        public static Coord[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Coord[]) $VALUES.clone() : (Coord[]) invokeV.objValue;
        }

        public int type() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.value : invokeV.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-357455376, "Lcom/baidu/wallet/lightapp/base/LocationCache;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-357455376, "Lcom/baidu/wallet/lightapp/base/LocationCache;");
                return;
            }
        }
        f51454c = Coord.UNKNOWN;
        f51455d = 0L;
        f51456e = LocationProvider.HOST;
    }

    public static void a(double d2, double d3, Coord coord, LocationProvider locationProvider) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{Double.valueOf(d2), Double.valueOf(d3), coord, locationProvider}) == null) {
            a = d2;
            f51453b = d3;
            f51454c = coord;
            f51455d = System.currentTimeMillis();
            f51456e = locationProvider;
        }
    }

    public static double b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? f51453b : invokeV.doubleValue;
    }

    public static Coord c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? f51454c : (Coord) invokeV.objValue;
    }

    public static long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? f51455d : invokeV.longValue;
    }

    public static double a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? a : invokeV.doubleValue;
    }
}

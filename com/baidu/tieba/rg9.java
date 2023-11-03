package com.baidu.tieba;

import android.location.Address;
import com.baidu.adp.lib.lbs.BdLocationMananger;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.interfaces.location.LocationCallback;
import com.baidu.searchbox.live.interfaces.location.LocationInfo;
import com.baidu.searchbox.live.interfaces.service.LiveLocationService;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class rg9 implements LiveLocationService {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements BdLocationMananger.LocationCallBack {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LocationCallback a;
        public final /* synthetic */ rg9 b;

        public a(rg9 rg9Var, LocationCallback locationCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rg9Var, locationCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rg9Var;
            this.a = locationCallback;
        }

        @Override // com.baidu.adp.lib.lbs.BdLocationMananger.LocationCallBack
        public void onLocationGeted(int i, String str, Address address) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, address) == null) {
                try {
                    if (this.a != null) {
                        this.a.onReceiveLocation(this.b.b(address));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948120805, "Lcom/baidu/tieba/rg9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948120805, "Lcom/baidu/tieba/rg9;");
                return;
            }
        }
        BdLocationMananger.getInstance().addWhiteList(rg9.class);
    }

    public rg9() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveLocationService
    public LocationInfo getLocationInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return b(BdLocationMananger.getInstance().getAddress(false, (BdLocationMananger.LocationCallBack) null));
        }
        return (LocationInfo) invokeV.objValue;
    }

    public final LocationInfo b(Address address) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, address)) == null) {
            LocationInfo locationInfo = new LocationInfo();
            if (address != null) {
                locationInfo.setCity(address.getLocality());
                locationInfo.setLatitude(address.getLatitude());
                locationInfo.setLongitude(address.getLongitude());
                locationInfo.setProvince(address.getAdminArea());
                locationInfo.setCounty(address.getCountryName());
            }
            return locationInfo;
        }
        return (LocationInfo) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveLocationService
    public void requestLocate(LocationCallback locationCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, locationCallback) == null) {
            if (!UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
                if (locationCallback != null) {
                    locationCallback.onReceiveLocation(new LocationInfo());
                    return;
                }
                return;
            }
            BdLocationMananger.getInstance().getAddress(false, (BdLocationMananger.LocationCallBack) new a(this, locationCallback));
        }
    }
}

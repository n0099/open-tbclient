package com.baidu.tieba;

import android.content.Context;
import android.location.Address;
import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.permissionhelper.ApiUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tieba.pf;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Locale;
/* loaded from: classes7.dex */
public class rq8 implements qf {
    public static /* synthetic */ Interceptable $ic;
    public static rq8 k;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public boolean b;
    public String c;
    public pf.d d;
    public b e;
    public LocationClient f;
    public LocationClientOption g;
    public Address h;
    public long i;
    public boolean j;

    /* loaded from: classes7.dex */
    public static class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001330) {
                if ((ApiUtil.shouldCheckPermission() && !PermissionUtil.checkLocationForBaiduLocation(TbadkCoreApplication.getInst())) || !(customResponsedMessage.getData() instanceof Boolean)) {
                    return;
                }
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    pf.n().r(rq8.j());
                } else {
                    pf.n().v(rq8.j());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements BDLocationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rq8 a;

        public b(rq8 rq8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rq8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rq8Var;
        }

        public /* synthetic */ b(rq8 rq8Var, a aVar) {
            this(rq8Var);
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bDLocation) == null) {
                if ((!ApiUtil.shouldCheckPermission() || PermissionUtil.checkLocationForBaiduLocation(TbadkCoreApplication.getInst())) && bDLocation != null && bDLocation.getLocType() != 62 && bDLocation.getLocType() != 63 && bDLocation.getLocType() != 67 && bDLocation.getLocType() != 68 && bDLocation.getLocType() <= 161) {
                    this.a.c();
                    this.a.h = new Address(Locale.getDefault());
                    this.a.h.setLatitude(bDLocation.getLatitude());
                    this.a.h.setLongitude(bDLocation.getLongitude());
                    n95 m = n95.m();
                    m.B("key_last_receive_location_latitude_and_longitude", bDLocation.getLatitude() + "," + bDLocation.getLongitude());
                    this.a.h.setLocality(bDLocation.getCity());
                    Bundle bundle = new Bundle();
                    bundle.putFloat("radius", bDLocation.getRadius());
                    bundle.putDouble("altitude", bDLocation.getAltitude());
                    bundle.putFloat("speed", bDLocation.getSpeed());
                    bundle.putString("cityCode", bDLocation.getCityCode());
                    bundle.putString("street", bDLocation.getStreet());
                    bundle.putString("streetNumber", bDLocation.getStreetNumber());
                    bundle.putString("province", bDLocation.getProvince());
                    this.a.h.setExtras(bundle);
                    this.a.i = System.currentTimeMillis();
                    StringBuffer stringBuffer = new StringBuffer();
                    if (bDLocation.getDistrict() == null || bDLocation.getStreet() == null) {
                        stringBuffer.append(bDLocation.getCity());
                    }
                    stringBuffer.append(bDLocation.getDistrict());
                    stringBuffer.append(bDLocation.getStreet());
                    if (bDLocation.getAddrStr() != null) {
                        this.a.h.setAddressLine(0, stringBuffer.toString());
                    }
                    if (this.a.d != null) {
                        this.a.d.a(0, "", this.a.h, this.a.i, this.a.j);
                        tn9.e().i(String.valueOf(this.a.h.getLatitude()));
                        tn9.e().j(String.valueOf(this.a.h.getLongitude()));
                        tn9.e().k(System.currentTimeMillis());
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948130384, "Lcom/baidu/tieba/rq8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948130384, "Lcom/baidu/tieba/rq8;");
                return;
            }
        }
        MessageManager.getInstance().registerListener(new a(2001330));
    }

    public static rq8 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            if (k == null) {
                synchronized (rq8.class) {
                    if (k == null) {
                        k = new rq8();
                    }
                }
            }
            return k;
        }
        return (rq8) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qf
    public void c() {
        LocationClient locationClient;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (locationClient = this.f) != null && locationClient.isStarted()) {
            try {
                this.f.stop();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Override // com.baidu.tieba.qf
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c();
        }
    }

    public rq8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = true;
        this.c = "";
        this.d = null;
        this.i = 0L;
        this.j = false;
    }

    @Override // com.baidu.tieba.qf
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            if ((!ApiUtil.shouldCheckPermission() || PermissionUtil.checkLocationForBaiduLocation(TbadkCoreApplication.getInst())) && this.b && this.f != null) {
                try {
                    this.j = z;
                    if (z) {
                        this.g.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
                    }
                    this.f.setLocOption(this.g);
                    if (!this.f.isStarted()) {
                        this.f.start();
                    }
                    this.f.requestLocation();
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    c();
                    pf.d dVar = this.d;
                    if (dVar != null) {
                        dVar.a(5, "", this.h, this.i, this.j);
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.qf
    public void b(pf.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) {
            this.a = TbadkCoreApplication.getInst().getContext();
            this.d = dVar;
            this.c = "baidu";
            if (this.b) {
                try {
                    this.f = new LocationClient(this.a);
                    LocationClientOption locationClientOption = new LocationClientOption();
                    this.g = locationClientOption;
                    locationClientOption.setOpenGps(true);
                    this.g.setIgnoreKillProcess(true);
                    this.g.setProdName(this.c);
                    this.g.setAddrType("all");
                    this.g.setCoorType("bd09ll");
                    b bVar = new b(this, null);
                    this.e = bVar;
                    this.f.registerLocationListener(bVar);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    }
}

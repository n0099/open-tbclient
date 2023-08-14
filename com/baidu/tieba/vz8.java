package com.baidu.tieba;

import android.content.Context;
import android.location.Address;
import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.lbs.BdLocationMananger;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.permissionhelper.ApiUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tieba.recapp.localads.LocationCacheData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Locale;
/* loaded from: classes8.dex */
public class vz8 implements hf {
    public static /* synthetic */ Interceptable $ic;
    public static vz8 k;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public boolean b;
    public String c;
    public BdLocationMananger.c d;
    public b e;
    public LocationClient f;
    public LocationClientOption g;
    public Address h;
    public long i;
    public boolean j;

    /* loaded from: classes8.dex */
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
                    BdLocationMananger.getInstance().registerProvider(vz8.j());
                } else {
                    BdLocationMananger.getInstance().unRegiserProvider(vz8.j());
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements BDLocationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vz8 a;

        public b(vz8 vz8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vz8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vz8Var;
        }

        public /* synthetic */ b(vz8 vz8Var, a aVar) {
            this(vz8Var);
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
                    SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
                    sharedPrefHelper.putString("key_last_receive_location_latitude_and_longitude", bDLocation.getLatitude() + "," + bDLocation.getLongitude());
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
                        LocationCacheData.getInstance().setLatitude(String.valueOf(this.a.h.getLatitude()));
                        LocationCacheData.getInstance().setLongitude(String.valueOf(this.a.h.getLongitude()));
                        LocationCacheData.getInstance().setSaveTime(System.currentTimeMillis());
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948258197, "Lcom/baidu/tieba/vz8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948258197, "Lcom/baidu/tieba/vz8;");
                return;
            }
        }
        MessageManager.getInstance().registerListener(new a(2001330));
    }

    public static vz8 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            if (k == null) {
                synchronized (vz8.class) {
                    if (k == null) {
                        k = new vz8();
                    }
                }
            }
            return k;
        }
        return (vz8) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hf
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

    @Override // com.baidu.tieba.hf
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c();
        }
    }

    public vz8() {
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

    @Override // com.baidu.tieba.hf
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
                    BdLocationMananger.c cVar = this.d;
                    if (cVar != null) {
                        cVar.a(5, "", this.h, this.i, this.j);
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.hf
    public void b(BdLocationMananger.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.a = TbadkCoreApplication.getInst().getContext();
            this.d = cVar;
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

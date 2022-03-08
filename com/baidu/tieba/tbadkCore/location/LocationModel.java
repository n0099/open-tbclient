package com.baidu.tieba.tbadkCore.location;

import android.content.Context;
import android.location.Address;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.i.a;
import c.a.d.f.p.l;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.mutiprocess.location.LocationEvent;
import com.baidu.tieba.tbadkCore.location.LocationData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class LocationModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public e f46757e;

    /* renamed from: f  reason: collision with root package name */
    public f f46758f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.d.a.f f46759g;

    /* renamed from: h  reason: collision with root package name */
    public HttpMessageListener f46760h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.d.c.g.c f46761i;

    /* renamed from: j  reason: collision with root package name */
    public a.c f46762j;
    public CustomMessageListener k;

    /* loaded from: classes6.dex */
    public class a extends c.a.d.c.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LocationModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(LocationModel locationModel, int i2, boolean z) {
            super(i2, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {locationModel, Integer.valueOf(i2), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Boolean) objArr2[1]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = locationModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) {
                if (socketResponsedMessage == null || socketResponsedMessage.getError() != 0 || !(socketResponsedMessage instanceof LocationSocketResponsedMessage)) {
                    if (this.a.f46757e != null) {
                        String str = null;
                        if (socketResponsedMessage != null && socketResponsedMessage.getError() > 0) {
                            str = socketResponsedMessage.getErrorString();
                        }
                        this.a.f46757e.onFail(str);
                        return;
                    }
                    return;
                }
                this.a.F(((LocationSocketResponsedMessage) socketResponsedMessage).getLocationData());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LocationModel a;

        public b(LocationModel locationModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {locationModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = locationModel;
        }

        @Override // c.a.d.f.i.a.c
        public void onLocationGeted(int i2, String str, Address address) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, address) == null) {
                if (i2 != 0 || address == null) {
                    if (this.a.f46757e != null) {
                        this.a.f46757e.onFail(str);
                        return;
                    }
                    return;
                }
                this.a.K(String.valueOf(address.getLongitude()), String.valueOf(address.getLatitude()));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LocationModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(LocationModel locationModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {locationModel, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = locationModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                if (httpResponsedMessage == null || httpResponsedMessage.getError() != 0) {
                    if (this.a.f46757e != null) {
                        String str = null;
                        if (httpResponsedMessage != null && httpResponsedMessage.getError() > 0) {
                            str = httpResponsedMessage.getErrorString();
                        }
                        this.a.f46757e.onFail(str);
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().setLocationShared(true);
                this.a.I();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LocationModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(LocationModel locationModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {locationModel, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = locationModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof ResponsedSelectLocation)) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    this.a.N(false);
                    this.a.M(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    if (this.a.f46758f != null) {
                        this.a.f46758f.b(responsedSelectLocation.getName());
                        return;
                    }
                    return;
                }
                this.a.N(true);
                if (this.a.f46758f != null) {
                    this.a.f46758f.a();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface e {
        void a();

        void b(LocationData locationData);

        void onFail(String str);
    }

    /* loaded from: classes6.dex */
    public interface f {
        void a();

        void b(String str);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1126885917, "Lcom/baidu/tieba/tbadkCore/location/LocationModel;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1126885917, "Lcom/baidu/tieba/tbadkCore/location/LocationModel;");
                return;
            }
        }
        c.a.d.f.i.a.n().g(LocationModel.class);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocationModel(c.a.d.a.f fVar) {
        super(fVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((c.a.d.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f46761i = new a(this, 303017, true);
        this.f46762j = new b(this);
        this.k = new d(this, 2001226);
        BdLog.addLogPackage(LocationModel.class.getPackage().getName());
        this.f46759g = fVar;
        if (!TbadkCoreApplication.getInst().isMainProcess(false)) {
            this.f46761i.setSelfListener(false);
        }
        registerListener(this.f46761i);
        registerListener(this.k);
    }

    public static void A(LocationData locationData) {
        List<LocationData.NearByAddressData> poi_info;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, locationData) == null) || locationData == null || (poi_info = locationData.getPoi_info()) == null || poi_info.isEmpty()) {
            return;
        }
        int size = poi_info.size();
        int i2 = 0;
        while (i2 < size) {
            if (StringUtils.isNull(poi_info.get(i2) != null ? poi_info.get(i2).getName() : null)) {
                poi_info.remove(i2);
                size--;
                i2--;
            }
            i2++;
        }
        if (StringUtils.isNull(locationData.getFormatted_address())) {
            if (poi_info.size() >= 1) {
                locationData.setFormatted_address(poi_info.get(0).getName());
                locationData.setSn(poi_info.get(0).getSn());
                return;
            }
            return;
        }
        for (LocationData.NearByAddressData nearByAddressData : poi_info) {
            if (locationData.getFormatted_address().equals(nearByAddressData.getName())) {
                locationData.setSn(nearByAddressData.getSn());
                return;
            }
        }
    }

    public static void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            c.a.r0.y3.g0.a.h(303017, LocationSocketResponsedMessage.class, false, false);
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f46760h = new c(this, CmdConfigHttp.SET_PRIVATE_CMD);
        }
    }

    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? System.currentTimeMillis() - c.a.r0.y3.p0.b.a().c() > 300000 : invokeV.booleanValue;
    }

    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            LocationData b2 = c.a.r0.y3.p0.b.a().b();
            return (C() || b2 == null || StringUtils.isNull(b2.getFormatted_address())) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean E(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) ? UtilHelper.isSystemLocationProviderEnabled(context) : invokeL.booleanValue;
    }

    public final void F(LocationData locationData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, locationData) == null) {
            if (locationData == null) {
                e eVar = this.f46757e;
                if (eVar != null) {
                    eVar.onFail(null);
                    return;
                }
                return;
            }
            A(locationData);
            c.a.r0.y3.p0.b.a().g(System.currentTimeMillis());
            c.a.r0.y3.p0.b.a().e(locationData);
            e eVar2 = this.f46757e;
            if (eVar2 != null) {
                eVar2.b(locationData);
            }
        }
    }

    public final void G(LocationData locationData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, locationData) == null) && !TbadkCoreApplication.getInst().isMainProcess(false) && (this.f46759g.getPageActivity() instanceof BaseActivity)) {
            LocationEvent locationEvent = new LocationEvent();
            locationEvent.setType(1);
            locationEvent.eventType = 2;
            locationEvent.locationData = locationData;
            locationEvent.needRefresh = true;
            ((BaseActivity) this.f46759g.getPageActivity()).publishEvent(locationEvent);
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (D()) {
                e eVar = this.f46757e;
                if (eVar != null) {
                    eVar.b(c.a.r0.y3.p0.b.a().b());
                }
            } else if (l.z()) {
                if (PermissionUtil.checkLocationForGoogle(this.f46759g.getPageActivity())) {
                    c.a.d.f.i.a.n().k(true, this.f46762j);
                }
            } else {
                e eVar2 = this.f46757e;
                if (eVar2 != null) {
                    eVar2.a();
                }
            }
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (D()) {
                e eVar = this.f46757e;
                if (eVar != null) {
                    eVar.b(c.a.r0.y3.p0.b.a().b());
                }
            } else if (l.z()) {
                if (PermissionUtil.checkLocationForBaiduLocation(this.f46759g.getPageActivity())) {
                    c.a.d.f.i.a.n().k(true, this.f46762j);
                } else {
                    PermissionUtil.reuqestBaiduLocationPermission(this.f46759g.getPageActivity(), 0);
                }
            } else {
                e eVar2 = this.f46757e;
                if (eVar2 != null) {
                    eVar2.a();
                }
            }
        }
    }

    public void K(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) {
            if (!TbadkCoreApplication.getInst().isMainProcess(false)) {
                if (this.f46759g.getPageActivity() instanceof BaseActivity) {
                    LocationEvent locationEvent = new LocationEvent();
                    locationEvent.setType(3);
                    locationEvent.eventType = 0;
                    locationEvent.lat = str2;
                    locationEvent.lng = str;
                    ((BaseActivity) this.f46759g.getPageActivity()).publishEvent(locationEvent);
                    return;
                }
                return;
            }
            LocationSocketRequestMessage locationSocketRequestMessage = new LocationSocketRequestMessage();
            locationSocketRequestMessage.setLat(str2);
            locationSocketRequestMessage.setLng(str);
            sendMessage(locationSocketRequestMessage);
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.f46760h == null) {
                B();
                registerListener(this.f46760h);
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
            httpMessage.addParam("opt", "location");
            httpMessage.addParam("val", String.valueOf(1));
            sendMessage(httpMessage);
        }
    }

    public void M(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, str2) == null) {
            LocationData b2 = c.a.r0.y3.p0.b.a().b();
            if (b2 != null) {
                b2.setFormatted_address(str);
                b2.setSn(str2);
            }
            G(b2);
        }
    }

    public void N(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            c.a.r0.y3.p0.b.a().f(z);
            c.a.q0.r.j0.b.k().u("no_longer_show_address", c.a.r0.y3.p0.b.a().d());
        }
    }

    public void O(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, eVar) == null) {
            this.f46757e = eVar;
        }
    }

    public void P(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, fVar) == null) {
            this.f46758f = fVar;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            cancelMessage();
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? E(this.f46759g.getPageActivity()) && TbadkCoreApplication.getInst().getLocationShared() && !c.a.r0.y3.p0.b.a().d() : invokeV.booleanValue;
    }
}

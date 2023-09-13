package com.baidu.tieba.tbadkCore.location;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.SocketMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.lbs.BdLocationMananger;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.mutiprocess.location.LocationEvent;
import com.baidu.tieba.bha;
import com.baidu.tieba.sia;
import com.baidu.tieba.tbadkCore.location.LocationData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes8.dex */
public class LocationModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c a;
    public d b;
    public BdPageContext c;
    public SocketMessageListener d;
    public CustomMessageListener e;

    /* loaded from: classes8.dex */
    public interface c {
        void a(LocationData locationData);

        void onFail(String str);
    }

    /* loaded from: classes8.dex */
    public interface d {
        void a();

        void b(String str);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes8.dex */
    public class a extends SocketMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LocationModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(LocationModel locationModel, int i, boolean z) {
            super(i, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {locationModel, Integer.valueOf(i), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
        /* renamed from: g */
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, socketResponsedMessage) == null) {
                if (socketResponsedMessage == null || socketResponsedMessage.getError() != 0 || !(socketResponsedMessage instanceof LocationSocketResponsedMessage)) {
                    if (this.a.a != null) {
                        String str = null;
                        if (socketResponsedMessage != null && socketResponsedMessage.getError() > 0) {
                            str = socketResponsedMessage.getErrorString();
                        }
                        this.a.a.onFail(str);
                        return;
                    }
                    return;
                }
                this.a.Q(((LocationSocketResponsedMessage) socketResponsedMessage).getLocationData());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LocationModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(LocationModel locationModel, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {locationModel, Integer.valueOf(i)};
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
            this.a = locationModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || !(customResponsedMessage instanceof ResponsedSelectLocation)) {
                return;
            }
            ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
            if (responsedSelectLocation.isShowLocation()) {
                this.a.U(false);
                this.a.T(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                if (this.a.b != null) {
                    this.a.b.b(responsedSelectLocation.getName());
                    return;
                }
                return;
            }
            this.a.U(true);
            if (this.a.b != null) {
                this.a.b.a();
            }
        }
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
        BdLocationMananger.getInstance().addWhiteList(LocationModel.class);
    }

    public static void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            bha.h(303017, LocationSocketResponsedMessage.class, false, false);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            cancelMessage();
            return true;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocationModel(BdPageContext bdPageContext) {
        super(bdPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdPageContext};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((BdPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = new a(this, 303017, true);
        this.e = new b(this, 2001226);
        BdLog.addLogPackage(LocationModel.class.getPackage().getName());
        this.c = bdPageContext;
        if (!TbadkCoreApplication.getInst().isMainProcess(false)) {
            this.d.setSelfListener(false);
        }
        registerListener(this.d);
        registerListener(this.e);
    }

    public void U(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            sia.a().e(z);
            SharedPrefHelper.getInstance().putBoolean("no_longer_show_address", sia.a().c());
        }
    }

    public void V(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            this.a = cVar;
        }
    }

    public void T(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            LocationData b2 = sia.a().b();
            if (b2 != null) {
                b2.setFormatted_address(str);
                b2.setSn(str2);
            }
            R(b2);
        }
    }

    public static void P(LocationData locationData) {
        List<LocationData.NearByAddressData> poi_info;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, locationData) == null) && locationData != null && (poi_info = locationData.getPoi_info()) != null && !poi_info.isEmpty()) {
            int size = poi_info.size();
            int i = 0;
            while (i < size) {
                String str = null;
                if (poi_info.get(i) != null) {
                    str = poi_info.get(i).getName();
                }
                if (StringUtils.isNull(str)) {
                    poi_info.remove(i);
                    size--;
                    i--;
                }
                i++;
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
    }

    public final void Q(LocationData locationData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, locationData) == null) {
            if (locationData == null) {
                c cVar = this.a;
                if (cVar != null) {
                    cVar.onFail(null);
                    return;
                }
                return;
            }
            P(locationData);
            sia.a().f(System.currentTimeMillis());
            sia.a().d(locationData);
            c cVar2 = this.a;
            if (cVar2 != null) {
                cVar2.a(locationData);
            }
        }
    }

    public final void R(LocationData locationData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, locationData) == null) && !TbadkCoreApplication.getInst().isMainProcess(false) && (this.c.getPageActivity() instanceof BaseActivity)) {
            LocationEvent locationEvent = new LocationEvent();
            locationEvent.setType(1);
            locationEvent.eventType = 2;
            locationEvent.locationData = locationData;
            locationEvent.needRefresh = true;
            ((BaseActivity) this.c.getPageActivity()).publishEvent(locationEvent);
        }
    }
}

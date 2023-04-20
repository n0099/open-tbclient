package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.mutiprocess.location.LocationEvent;
import com.baidu.tieba.tbadkCore.location.LocationData;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.location.LocationSocketRequestMessage;
import com.baidu.tieba.tbadkCore.location.LocationSocketResponsedMessage;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class rj5 implements wi5<LocationEvent> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public bb a;

    /* loaded from: classes6.dex */
    public class a extends bb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(rj5 rj5Var, int i, boolean z) {
            super(i, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rj5Var, Integer.valueOf(i), Boolean.valueOf(z)};
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
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        /* renamed from: a */
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            LocationData locationData;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, socketResponsedMessage) != null) || socketResponsedMessage == null) {
                return;
            }
            LocationEvent locationEvent = new LocationEvent();
            locationEvent.setType(1);
            locationEvent.eventType = 1;
            locationEvent.errorCode = socketResponsedMessage.getError();
            locationEvent.errorMsg = socketResponsedMessage.getErrorString();
            if (socketResponsedMessage instanceof LocationSocketResponsedMessage) {
                locationEvent.locationData = ((LocationSocketResponsedMessage) socketResponsedMessage).getLocationData();
            }
            if (socketResponsedMessage.getError() == 0 && (locationData = locationEvent.locationData) != null) {
                LocationModel.T(locationData);
                ym9.a().f(System.currentTimeMillis());
                ym9.a().d(locationEvent.locationData);
            }
            cj5.i(locationEvent);
        }
    }

    public rj5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new a(this, 303017, true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.wi5
    /* renamed from: a */
    public boolean onEvent(LocationEvent locationEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, locationEvent)) == null) {
            if (locationEvent == null) {
                return false;
            }
            if (locationEvent.getType() == 3) {
                MessageManager.getInstance().unRegisterListener(this.a);
                MessageManager.getInstance().registerListener(this.a);
                LocationSocketRequestMessage locationSocketRequestMessage = new LocationSocketRequestMessage();
                locationSocketRequestMessage.setLat(locationEvent.lat);
                locationSocketRequestMessage.setLng(locationEvent.lng);
                MessageManager.getInstance().sendMessage(locationSocketRequestMessage);
            } else if (locationEvent.eventType == 1) {
                LocationSocketResponsedMessage locationSocketResponsedMessage = new LocationSocketResponsedMessage();
                locationSocketResponsedMessage.setError(locationEvent.errorCode);
                locationSocketResponsedMessage.setErrorString(locationEvent.errorMsg);
                locationSocketResponsedMessage.setLocationData(locationEvent.locationData);
                MessageManager.getInstance().dispatchResponsedMessage(locationSocketResponsedMessage);
            } else if (locationEvent.locationData != null && locationEvent.needRefresh) {
                ym9.a().d(locationEvent.locationData);
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(locationEvent.isShowLocation, locationEvent.locName, locationEvent.locAddr, locationEvent.locSn));
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}

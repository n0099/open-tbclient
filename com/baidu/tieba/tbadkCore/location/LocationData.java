package com.baidu.tieba.tbadkCore.location;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetPoisByLocation.DataRes;
import tbclient.GetPoisByLocation.PoiInfo;
/* loaded from: classes8.dex */
public class LocationData implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String formatted_address;
    public List<NearByAddressData> poi_info;
    public String sn;

    /* loaded from: classes8.dex */
    public static class NearByAddressData implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String addr;
        public String name;
        public String sn;

        public NearByAddressData() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public String getAddr() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.addr;
            }
            return (String) invokeV.objValue;
        }

        public String getName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.name;
            }
            return (String) invokeV.objValue;
        }

        public String getSn() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.sn;
            }
            return (String) invokeV.objValue;
        }

        public void parserProtoBuf(PoiInfo poiInfo) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048579, this, poiInfo) != null) || poiInfo == null) {
                return;
            }
            this.name = poiInfo.name;
            this.addr = poiInfo.addr;
            this.sn = poiInfo.sn;
        }

        public void setName(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.name = str;
            }
        }

        public void setSn(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
                this.sn = str;
            }
        }
    }

    public LocationData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public String getFormatted_address() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.formatted_address;
        }
        return (String) invokeV.objValue;
    }

    public List<NearByAddressData> getPoi_info() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.poi_info;
        }
        return (List) invokeV.objValue;
    }

    public String getSn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.sn;
        }
        return (String) invokeV.objValue;
    }

    public void parserProtoBuf(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, dataRes) != null) || dataRes == null) {
            return;
        }
        this.formatted_address = dataRes.formatted_address;
        List<PoiInfo> list = dataRes.poi_info;
        if (list == null) {
            return;
        }
        this.poi_info = new ArrayList();
        for (PoiInfo poiInfo : list) {
            NearByAddressData nearByAddressData = new NearByAddressData();
            nearByAddressData.parserProtoBuf(poiInfo);
            this.poi_info.add(nearByAddressData);
        }
    }

    public void setFormatted_address(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.formatted_address = str;
        }
    }

    public void setSn(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.sn = str;
        }
    }
}

package com.baidu.wallet.fastpay.datamodel;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.NoProguard;
import java.io.Serializable;
/* loaded from: classes5.dex */
public class TrafficFaceModel implements NoProguard, Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -7879913133068333699L;
    public transient /* synthetic */ FieldHolder $fh;
    public String actualPrice;
    public String denomination;
    public ExtInfoMap extInfoMap;
    public int id;
    public String latitude;
    public String modelId;
    public String originalPrice;

    /* loaded from: classes5.dex */
    public static class ExtInfoMap implements NoProguard, Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 1615331933156718269L;
        public transient /* synthetic */ FieldHolder $fh;
        public String chargeProvince;
        public String chargeProvinceCode;
        public String fromDate;
        public String huiDesc;
        public String huiIcon;
        public String huiTip;
        public String net;
        public String prodCode;
        public String times;
        public String usePeriod;
        public String useProvince;
        public String useProvinceCode;

        public ExtInfoMap() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.prodCode = "";
            this.chargeProvince = "";
            this.chargeProvinceCode = "";
            this.net = "";
            this.useProvince = "";
            this.useProvinceCode = "";
            this.times = "";
            this.usePeriod = "";
            this.fromDate = "";
            this.huiIcon = "";
            this.huiTip = "";
            this.huiDesc = "";
        }
    }

    public TrafficFaceModel() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.id = 0;
        this.denomination = "";
        this.originalPrice = "";
        this.actualPrice = "";
        this.latitude = "";
        this.modelId = "";
    }

    public String getFromDate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ExtInfoMap extInfoMap = this.extInfoMap;
            return (extInfoMap == null || TextUtils.isEmpty(extInfoMap.fromDate)) ? "" : this.extInfoMap.fromDate;
        }
        return (String) invokeV.objValue;
    }

    public String getHuiDesc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ExtInfoMap extInfoMap = this.extInfoMap;
            return (extInfoMap == null || TextUtils.isEmpty(extInfoMap.huiDesc)) ? "" : this.extInfoMap.huiDesc;
        }
        return (String) invokeV.objValue;
    }

    public String getHuiIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ExtInfoMap extInfoMap = this.extInfoMap;
            return (extInfoMap == null || TextUtils.isEmpty(extInfoMap.huiIcon)) ? "" : this.extInfoMap.huiIcon;
        }
        return (String) invokeV.objValue;
    }

    public String getHuiTip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ExtInfoMap extInfoMap = this.extInfoMap;
            return (extInfoMap == null || TextUtils.isEmpty(extInfoMap.huiTip)) ? "" : this.extInfoMap.huiTip;
        }
        return (String) invokeV.objValue;
    }

    public String getTimes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ExtInfoMap extInfoMap = this.extInfoMap;
            return (extInfoMap == null || TextUtils.isEmpty(extInfoMap.times)) ? "" : this.extInfoMap.times;
        }
        return (String) invokeV.objValue;
    }

    public String getUsePeriod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ExtInfoMap extInfoMap = this.extInfoMap;
            return (extInfoMap == null || TextUtils.isEmpty(extInfoMap.usePeriod)) ? "" : this.extInfoMap.usePeriod;
        }
        return (String) invokeV.objValue;
    }

    public String getUseProvince() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ExtInfoMap extInfoMap = this.extInfoMap;
            return (extInfoMap == null || TextUtils.isEmpty(extInfoMap.useProvince)) ? "" : this.extInfoMap.useProvince;
        }
        return (String) invokeV.objValue;
    }

    public String getactualPrice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? TextUtils.isEmpty(this.actualPrice) ? "0" : this.actualPrice : (String) invokeV.objValue;
    }

    public boolean isCheeper() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (TextUtils.isEmpty(this.originalPrice) || TextUtils.isEmpty(this.actualPrice)) {
                return false;
            }
            try {
                return Integer.parseInt(this.actualPrice) < Integer.parseInt(this.originalPrice);
            } catch (NumberFormatException unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return "TrafficFaceModel [id=" + this.id + ", denomination=" + this.denomination + ", original_price=" + this.originalPrice + ", actualPrice=" + this.actualPrice + ", latitude=" + this.latitude + ", modelId=" + this.modelId + ", extInfoMap=" + this.extInfoMap + PreferencesUtil.RIGHT_MOUNT;
        }
        return (String) invokeV.objValue;
    }
}

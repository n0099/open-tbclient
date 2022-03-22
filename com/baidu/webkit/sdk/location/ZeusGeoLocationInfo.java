package com.baidu.webkit.sdk.location;

import android.text.TextUtils;
import android.text.format.DateFormat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ZeusGeoLocationInfo {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String COOR_TYPE_GCJ = "gcj02";
    public transient /* synthetic */ FieldHolder $fh;
    public String mCity;
    public String mCityCode;
    public String mDistrict;
    public double mLatitude;
    public double mLongitude;
    public String mProvince;
    public double mRadius;
    public String mStreet;
    public String mStreetNumber;
    public long mTime;

    public ZeusGeoLocationInfo() {
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
        this.mLongitude = 0.0d;
        this.mLatitude = 0.0d;
        this.mRadius = 100.0d;
        this.mTime = 0L;
        this.mProvince = "";
        this.mCity = "";
        this.mDistrict = "";
        this.mStreet = "";
        this.mStreetNumber = "";
        this.mCityCode = "";
    }

    public String getCity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mCity : (String) invokeV.objValue;
    }

    public String getCityCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mCityCode : (String) invokeV.objValue;
    }

    public String getCoorType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "gcj02" : (String) invokeV.objValue;
    }

    public String getDistrict() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mDistrict : (String) invokeV.objValue;
    }

    public double getLatitude() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mLatitude : invokeV.doubleValue;
    }

    public double getLongitude() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mLongitude : invokeV.doubleValue;
    }

    public String getProvince() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mProvince : (String) invokeV.objValue;
    }

    public double getRadius() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mRadius : invokeV.doubleValue;
    }

    public String getStreet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mStreet : (String) invokeV.objValue;
    }

    public String getStreetNumber() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mStreetNumber : (String) invokeV.objValue;
    }

    public long getTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mTime : invokeV.longValue;
    }

    public void setCity(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            this.mCity = str;
        }
    }

    public void setCityCode(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            this.mCityCode = str;
        }
    }

    public void setDistrict(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            this.mDistrict = str;
        }
    }

    public void setLatitude(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Double.valueOf(d2)}) == null) {
            this.mLatitude = d2;
        }
    }

    public void setLongitude(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Double.valueOf(d2)}) == null) {
            this.mLongitude = d2;
        }
    }

    public void setProvince(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            this.mProvince = str;
        }
    }

    public void setRadius(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Double.valueOf(d2)}) == null) {
            this.mRadius = d2;
        }
    }

    public void setStreet(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            this.mStreet = str;
        }
    }

    public void setStreetNumber(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            this.mStreetNumber = str;
        }
    }

    public void setTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048596, this, j) == null) {
            this.mTime = j;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return "longitude[" + this.mLongitude + "] latitude[" + this.mLatitude + "] radius[" + this.mRadius + "] province[" + this.mProvince + "] city[" + this.mCity + "] district[" + this.mDistrict + "] street[" + this.mStreet + "] streetNumber[" + this.mStreetNumber + "] cityCode[" + this.mCityCode + "] mTime[" + ((Object) DateFormat.format("yyyy-MM-dd kk:mm:ss", this.mTime)) + PreferencesUtil.RIGHT_MOUNT;
        }
        return (String) invokeV.objValue;
    }
}

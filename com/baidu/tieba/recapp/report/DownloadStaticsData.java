package com.baidu.tieba.recapp.report;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes4.dex */
public class DownloadStaticsData implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DOWNLOAD_CONTINUE = "1";
    public static final String DOWNLOAD_NORMAL_CLICK = "0";
    public static final String DOWNLOAD_NOTIFY_CLICK = "1";
    public static final String DOWNLOAD_START = "0";
    public transient /* synthetic */ FieldHolder $fh;
    public String adPosition;
    public String apk_name;
    public String da_page;
    public String da_range;
    public String da_range_nt;
    public String extensionInfo;
    public String fid;

    public DownloadStaticsData() {
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
        this.da_range = "0";
        this.da_range_nt = "0";
    }

    public String getAdPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.adPosition : (String) invokeV.objValue;
    }

    public String getApk_name() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.apk_name : (String) invokeV.objValue;
    }

    public String getDa_page() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.da_page : (String) invokeV.objValue;
    }

    public String getDa_range() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.da_range : (String) invokeV.objValue;
    }

    public String getDa_range_nt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.da_range_nt : (String) invokeV.objValue;
    }

    public String getExtensionInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.extensionInfo : (String) invokeV.objValue;
    }

    public String getFid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.fid : (String) invokeV.objValue;
    }

    public void setAdPosition(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.adPosition = str;
        }
    }

    public void setApk_name(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.apk_name = str;
        }
    }

    public void setDa_page(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.da_page = str;
        }
    }

    public void setDa_range(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.da_range = str;
        }
    }

    public void setDa_range_nt(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.da_range_nt = str;
        }
    }

    public void setExtensionInfo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.extensionInfo = str;
        }
    }

    public void setFid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.fid = str;
        }
    }
}

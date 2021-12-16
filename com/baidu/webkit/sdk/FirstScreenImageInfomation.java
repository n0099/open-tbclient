package com.baidu.webkit.sdk;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class FirstScreenImageInfomation {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean bHaveImageInScreen;
    public int nErrorOccurredCount;
    public int nImageCount;
    public long nMaxTimeStamp;
    public int nPaintHeightForMaxImage;
    public int nPaintWidthForMaxImage;
    public int nPosXForMaxImage;
    public int nPosYForMaxImage;
    public long nTimeStampForMaxImage;
    public String url;

    public FirstScreenImageInfomation() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public int getErrorOccurredCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.nErrorOccurredCount : invokeV.intValue;
    }

    public boolean getHaveImageInScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.bHaveImageInScreen : invokeV.booleanValue;
    }

    public int getImageCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.nImageCount : invokeV.intValue;
    }

    public long getMaxTimeStamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.nMaxTimeStamp : invokeV.longValue;
    }

    public int getPaintHeightForMaxImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.nPaintHeightForMaxImage : invokeV.intValue;
    }

    public int getPaintWidthForMaxImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.nPaintWidthForMaxImage : invokeV.intValue;
    }

    public int getPosXForMaxImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.nPosXForMaxImage : invokeV.intValue;
    }

    public int getPosYForMaxImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.nPosYForMaxImage : invokeV.intValue;
    }

    public long getTimeStampForMaxImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.nTimeStampForMaxImage : invokeV.longValue;
    }

    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.url : (String) invokeV.objValue;
    }

    public void setErrorOccurredCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.nErrorOccurredCount = i2;
        }
    }

    public void setHaveImageInScreen(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.bHaveImageInScreen = z;
        }
    }

    public void setImageCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.nImageCount = i2;
        }
    }

    public void setMaxTimeStamp(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048589, this, j2) == null) {
            this.nMaxTimeStamp = j2;
        }
    }

    public void setPaintHeightForMaxImage(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.nPaintHeightForMaxImage = i2;
        }
    }

    public void setPaintWidthForMaxImage(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.nPaintWidthForMaxImage = i2;
        }
    }

    public void setPosXForMaxImage(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.nPosXForMaxImage = i2;
        }
    }

    public void setPosYForMaxImage(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.nPosYForMaxImage = i2;
        }
    }

    public void setTimeStampForMaxImage(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048594, this, j2) == null) {
            this.nTimeStampForMaxImage = j2;
        }
    }

    public void setUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.url = str;
        }
    }
}

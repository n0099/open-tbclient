package com.baidu.wallet.lightapp.business;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes12.dex */
public class LangbridgeBarParams implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int fullScreenActionBarColor;
    public int fullScreenTitleColor;
    public boolean isFullScreen;
    public boolean isHideHost;
    public boolean isHideTitle;
    public boolean isIconWhite;

    public LangbridgeBarParams() {
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
        this.fullScreenActionBarColor = -1;
        this.fullScreenTitleColor = 0;
        this.isFullScreen = false;
        this.isHideTitle = false;
        this.isIconWhite = false;
        this.isHideHost = false;
    }

    public boolean equals(LangbridgeBarParams langbridgeBarParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, langbridgeBarParams)) == null) ? langbridgeBarParams != null && langbridgeBarParams.isHideHost == this.isHideHost && langbridgeBarParams.fullScreenActionBarColor == this.fullScreenActionBarColor && langbridgeBarParams.isFullScreen == this.isFullScreen && langbridgeBarParams.isHideTitle == this.isHideTitle && langbridgeBarParams.fullScreenTitleColor == this.fullScreenTitleColor && langbridgeBarParams.isIconWhite == this.isIconWhite : invokeL.booleanValue;
    }

    public void setFullScreen(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.isFullScreen = z;
        }
    }

    public void setFullScreenActionBarColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.fullScreenActionBarColor = i2;
        }
    }

    public void setFullScreenTitleColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.fullScreenTitleColor = i2;
        }
    }

    public void setHideTitle(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.isHideTitle = z;
        }
    }

    public void setIconWhite(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.isIconWhite = z;
        }
    }

    public void setValues(boolean z, int i2, int i3, boolean z2, boolean z3, boolean z4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)}) == null) {
            this.isFullScreen = z;
            this.isHideTitle = z2;
            this.isIconWhite = z3;
            this.fullScreenActionBarColor = i2;
            this.fullScreenTitleColor = i3;
            this.isHideHost = z4;
        }
    }
}

package com.baidu.tieba;

import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class os6 implements iu9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public jy9 a;

    @Override // com.baidu.tieba.iu9
    public boolean isFullScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public os6(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(view2, "view");
        if (ny9.class.isAssignableFrom(view2.getClass())) {
            this.a = ((ny9) view2).getVideoOrVrView();
        }
    }

    @Override // com.baidu.tieba.iu9
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            jy9 jy9Var = this.a;
            if (jy9Var != null) {
                return (int) jy9Var.getCurrentPosition();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.iu9
    public String getPlayUrl() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            jy9 jy9Var = this.a;
            if (jy9Var != null) {
                str = jy9Var.getPlayUrl();
            } else {
                str = null;
            }
            if (str == null) {
                return "";
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.iu9
    public View getVideoContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            jy9 jy9Var = this.a;
            if (jy9Var != null) {
                return jy9Var.getVideoContainer();
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.iu9
    public boolean isPlayStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            jy9 jy9Var = this.a;
            if (jy9Var != null) {
                return jy9Var.isPlayStarted();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.iu9
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            jy9 jy9Var = this.a;
            if (jy9Var != null) {
                return jy9Var.isPlaying();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.iu9
    public void startPlay() {
        jy9 jy9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (jy9Var = this.a) != null) {
            jy9Var.startPlay();
        }
    }

    @Override // com.baidu.tieba.iu9
    public void stopPlay() {
        jy9 jy9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (jy9Var = this.a) != null) {
            jy9Var.stopPlay();
        }
    }
}

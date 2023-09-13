package com.baidu.tieba;

import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class js6 implements yy9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public x2a a;

    @Override // com.baidu.tieba.yy9
    public boolean isFullScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public js6(View view2) {
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
        if (b3a.class.isAssignableFrom(view2.getClass())) {
            this.a = ((b3a) view2).getVideoOrVrView();
        }
    }

    @Override // com.baidu.tieba.yy9
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            x2a x2aVar = this.a;
            if (x2aVar != null) {
                return (int) x2aVar.getCurrentPosition();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.yy9
    public String getPlayUrl() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            x2a x2aVar = this.a;
            if (x2aVar != null) {
                str = x2aVar.getPlayUrl();
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

    @Override // com.baidu.tieba.yy9
    public View getVideoContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            x2a x2aVar = this.a;
            if (x2aVar != null) {
                return x2aVar.getVideoContainer();
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yy9
    public boolean isPlayStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            x2a x2aVar = this.a;
            if (x2aVar != null) {
                return x2aVar.isPlayStarted();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.yy9
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            x2a x2aVar = this.a;
            if (x2aVar != null) {
                return x2aVar.isPlaying();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.yy9
    public void startPlay() {
        x2a x2aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (x2aVar = this.a) != null) {
            x2aVar.startPlay();
        }
    }

    @Override // com.baidu.tieba.yy9
    public void stopPlay() {
        x2a x2aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (x2aVar = this.a) != null) {
            x2aVar.stopPlay();
        }
    }
}

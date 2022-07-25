package com.baidu.tieba.recapp.adapter;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.c68;
import com.repackage.i98;
import com.repackage.pd7;
/* loaded from: classes3.dex */
public class PbAppLegoViewHolder extends TypeAdapter.ViewHolder implements c68 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public pd7<?> a;
    public i98 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbAppLegoViewHolder(pd7<?> pd7Var) {
        super((View) pd7Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pd7Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = pd7Var;
    }

    public void b(int i) {
        i98 i98Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || (i98Var = this.b) == null) {
            return;
        }
        i98Var.autoPlay(i);
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            i98 i98Var = this.b;
            if (i98Var == null) {
                return false;
            }
            return i98Var.canPlay();
        }
        return invokeV.booleanValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            i98 i98Var = this.b;
            if (i98Var != null) {
                return i98Var.getPlayStatus();
            }
            return -2;
        }
        return invokeV.intValue;
    }

    public void e() {
        i98 i98Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (i98Var = this.b) == null) {
            return;
        }
        i98Var.release();
    }

    public void f(i98 i98Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, i98Var) == null) {
            this.b = i98Var;
        }
    }

    public void g() {
        pd7<?> pd7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (pd7Var = this.a) == null) {
            return;
        }
        pd7Var.e();
    }

    @Override // com.repackage.c68
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            i98 i98Var = this.b;
            if (i98Var == null) {
                return 0;
            }
            return (int) i98Var.getCurrentPosition();
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.c68
    public String getPlayUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            i98 i98Var = this.b;
            return i98Var == null ? "" : i98Var.getPlayUrl();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.c68
    public View getVideoContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            i98 i98Var = this.b;
            if (i98Var == null) {
                return null;
            }
            return i98Var.getVideoContainer();
        }
        return (View) invokeV.objValue;
    }

    @Override // com.repackage.c68
    public boolean isFullScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.c68
    public boolean isPlayStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            i98 i98Var = this.b;
            if (i98Var == null) {
                return false;
            }
            return i98Var.isPlayStarted();
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.c68
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            i98 i98Var = this.b;
            if (i98Var == null) {
                return false;
            }
            return i98Var.isPlaying();
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.c68
    public void startPlay() {
        i98 i98Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (i98Var = this.b) == null) {
            return;
        }
        i98Var.startPlay();
    }

    @Override // com.repackage.c68
    public void stopPlay() {
        i98 i98Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (i98Var = this.b) == null) {
            return;
        }
        i98Var.stopPlay();
    }
}

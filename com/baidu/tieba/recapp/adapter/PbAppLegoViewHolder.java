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
import com.repackage.p68;
import com.repackage.pd7;
import com.repackage.t98;
/* loaded from: classes3.dex */
public class PbAppLegoViewHolder extends TypeAdapter.ViewHolder implements p68 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public pd7<?> a;
    public t98 b;

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

    public void c(int i) {
        t98 t98Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || (t98Var = this.b) == null) {
            return;
        }
        t98Var.autoPlay(i);
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            t98 t98Var = this.b;
            if (t98Var == null) {
                return false;
            }
            return t98Var.canPlay();
        }
        return invokeV.booleanValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            t98 t98Var = this.b;
            if (t98Var != null) {
                return t98Var.getPlayStatus();
            }
            return -2;
        }
        return invokeV.intValue;
    }

    public void f() {
        t98 t98Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (t98Var = this.b) == null) {
            return;
        }
        t98Var.release();
    }

    public void g(t98 t98Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, t98Var) == null) {
            this.b = t98Var;
        }
    }

    @Override // com.repackage.p68
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            t98 t98Var = this.b;
            if (t98Var == null) {
                return 0;
            }
            return (int) t98Var.getCurrentPosition();
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.p68
    public String getPlayUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            t98 t98Var = this.b;
            return t98Var == null ? "" : t98Var.getPlayUrl();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.p68
    public View getVideoContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            t98 t98Var = this.b;
            if (t98Var == null) {
                return null;
            }
            return t98Var.getVideoContainer();
        }
        return (View) invokeV.objValue;
    }

    public void h() {
        pd7<?> pd7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (pd7Var = this.a) == null) {
            return;
        }
        pd7Var.e();
    }

    @Override // com.repackage.p68
    public boolean isFullScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.p68
    public boolean isPlayStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            t98 t98Var = this.b;
            if (t98Var == null) {
                return false;
            }
            return t98Var.isPlayStarted();
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.p68
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            t98 t98Var = this.b;
            if (t98Var == null) {
                return false;
            }
            return t98Var.isPlaying();
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.p68
    public void startPlay() {
        t98 t98Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (t98Var = this.b) == null) {
            return;
        }
        t98Var.startPlay();
    }

    @Override // com.repackage.p68
    public void stopPlay() {
        t98 t98Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (t98Var = this.b) == null) {
            return;
        }
        t98Var.stopPlay();
    }
}

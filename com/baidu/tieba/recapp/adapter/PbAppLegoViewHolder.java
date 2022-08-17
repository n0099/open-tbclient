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
import com.repackage.i88;
import com.repackage.jf7;
import com.repackage.ob8;
/* loaded from: classes4.dex */
public class PbAppLegoViewHolder extends TypeAdapter.ViewHolder implements i88 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public jf7<?> a;
    public ob8 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbAppLegoViewHolder(jf7<?> jf7Var) {
        super((View) jf7Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jf7Var};
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
        this.a = jf7Var;
    }

    public void a(int i) {
        ob8 ob8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || (ob8Var = this.b) == null) {
            return;
        }
        ob8Var.autoPlay(i);
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ob8 ob8Var = this.b;
            if (ob8Var == null) {
                return false;
            }
            return ob8Var.canPlay();
        }
        return invokeV.booleanValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ob8 ob8Var = this.b;
            if (ob8Var != null) {
                return ob8Var.getPlayStatus();
            }
            return -2;
        }
        return invokeV.intValue;
    }

    public void d() {
        ob8 ob8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (ob8Var = this.b) == null) {
            return;
        }
        ob8Var.release();
    }

    public void e(ob8 ob8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ob8Var) == null) {
            this.b = ob8Var;
        }
    }

    public void f() {
        jf7<?> jf7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (jf7Var = this.a) == null) {
            return;
        }
        jf7Var.f();
    }

    @Override // com.repackage.i88
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ob8 ob8Var = this.b;
            if (ob8Var == null) {
                return 0;
            }
            return (int) ob8Var.getCurrentPosition();
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.i88
    public String getPlayUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ob8 ob8Var = this.b;
            return ob8Var == null ? "" : ob8Var.getPlayUrl();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.i88
    public View getVideoContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            ob8 ob8Var = this.b;
            if (ob8Var == null) {
                return null;
            }
            return ob8Var.getVideoContainer();
        }
        return (View) invokeV.objValue;
    }

    @Override // com.repackage.i88
    public boolean isFullScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.i88
    public boolean isPlayStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            ob8 ob8Var = this.b;
            if (ob8Var == null) {
                return false;
            }
            return ob8Var.isPlayStarted();
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.i88
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            ob8 ob8Var = this.b;
            if (ob8Var == null) {
                return false;
            }
            return ob8Var.isPlaying();
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.i88
    public void startPlay() {
        ob8 ob8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (ob8Var = this.b) == null) {
            return;
        }
        ob8Var.startPlay();
    }

    @Override // com.repackage.i88
    public void stopPlay() {
        ob8 ob8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (ob8Var = this.b) == null) {
            return;
        }
        ob8Var.stopPlay();
    }
}

package com.baidu.tieba.recapp.adapter;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.q39;
import com.baidu.tieba.x2a;
import com.baidu.tieba.yy9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class PbAppLegoViewHolder extends TypeAdapter.ViewHolder implements yy9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public q39<?> a;
    public x2a b;

    @Override // com.baidu.tieba.yy9
    public boolean isFullScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbAppLegoViewHolder(q39<?> q39Var) {
        super((View) q39Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {q39Var};
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
        this.a = q39Var;
    }

    public void a(int i) {
        x2a x2aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && (x2aVar = this.b) != null) {
            x2aVar.autoPlay(i);
        }
    }

    public void e(x2a x2aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, x2aVar) == null) {
            this.b = x2aVar;
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            x2a x2aVar = this.b;
            if (x2aVar == null) {
                return false;
            }
            return x2aVar.canPlay();
        }
        return invokeV.booleanValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            x2a x2aVar = this.b;
            if (x2aVar != null) {
                return x2aVar.getPlayStatus();
            }
            return -2;
        }
        return invokeV.intValue;
    }

    public void d() {
        x2a x2aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (x2aVar = this.b) != null) {
            x2aVar.release();
        }
    }

    public void f() {
        q39<?> q39Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (q39Var = this.a) != null) {
            q39Var.f();
        }
    }

    @Override // com.baidu.tieba.yy9
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            x2a x2aVar = this.b;
            if (x2aVar == null) {
                return 0;
            }
            return (int) x2aVar.getCurrentPosition();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.yy9
    public String getPlayUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            x2a x2aVar = this.b;
            if (x2aVar == null) {
                return "";
            }
            return x2aVar.getPlayUrl();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yy9
    public View getVideoContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            x2a x2aVar = this.b;
            if (x2aVar == null) {
                return null;
            }
            return x2aVar.getVideoContainer();
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yy9
    public boolean isPlayStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            x2a x2aVar = this.b;
            if (x2aVar == null) {
                return false;
            }
            return x2aVar.isPlayStarted();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.yy9
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            x2a x2aVar = this.b;
            if (x2aVar == null) {
                return false;
            }
            return x2aVar.isPlaying();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.yy9
    public void startPlay() {
        x2a x2aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (x2aVar = this.b) != null) {
            x2aVar.startPlay();
        }
    }

    @Override // com.baidu.tieba.yy9
    public void stopPlay() {
        x2a x2aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (x2aVar = this.b) != null) {
            x2aVar.stopPlay();
        }
    }
}

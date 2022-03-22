package com.baidu.tieba.recapp.adapter;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.c3.e;
import c.a.p0.l3.n;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class PbAppLegoViewHolder extends TypeAdapter.ViewHolder implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.p0.b2.o.l.e<?> a;

    /* renamed from: b  reason: collision with root package name */
    public n f35703b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbAppLegoViewHolder(c.a.p0.b2.o.l.e<?> eVar) {
        super((View) eVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
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
        this.a = eVar;
    }

    public void c(int i) {
        n nVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || (nVar = this.f35703b) == null) {
            return;
        }
        nVar.autoPlay(i);
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            n nVar = this.f35703b;
            if (nVar == null) {
                return false;
            }
            return nVar.canPlay();
        }
        return invokeV.booleanValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            n nVar = this.f35703b;
            if (nVar != null) {
                return nVar.getPlayStatus();
            }
            return -2;
        }
        return invokeV.intValue;
    }

    public void f() {
        n nVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (nVar = this.f35703b) == null) {
            return;
        }
        nVar.release();
    }

    public void g(n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, nVar) == null) {
            this.f35703b = nVar;
        }
    }

    @Override // c.a.p0.c3.e
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            n nVar = this.f35703b;
            if (nVar == null) {
                return 0;
            }
            return (int) nVar.getCurrentPosition();
        }
        return invokeV.intValue;
    }

    @Override // c.a.p0.c3.e
    public String getPlayUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            n nVar = this.f35703b;
            return nVar == null ? "" : nVar.getPlayUrl();
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.p0.c3.e
    public View getVideoContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            n nVar = this.f35703b;
            if (nVar == null) {
                return null;
            }
            return nVar.getVideoContainer();
        }
        return (View) invokeV.objValue;
    }

    public void h() {
        c.a.p0.b2.o.l.e<?> eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (eVar = this.a) == null) {
            return;
        }
        eVar.e();
    }

    @Override // c.a.p0.c3.e
    public boolean isFullScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.c3.e
    public boolean isPlayStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            n nVar = this.f35703b;
            if (nVar == null) {
                return false;
            }
            return nVar.isPlayStarted();
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.c3.e
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            n nVar = this.f35703b;
            if (nVar == null) {
                return false;
            }
            return nVar.isPlaying();
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.c3.e
    public void startPlay() {
        n nVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (nVar = this.f35703b) == null) {
            return;
        }
        nVar.startPlay();
    }

    @Override // c.a.p0.c3.e
    public void stopPlay() {
        n nVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (nVar = this.f35703b) == null) {
            return;
        }
        nVar.stopPlay();
    }
}

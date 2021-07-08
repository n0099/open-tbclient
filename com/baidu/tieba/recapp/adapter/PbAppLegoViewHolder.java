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
import d.a.p0.n2.e;
import d.a.p0.w2.m;
/* loaded from: classes4.dex */
public class PbAppLegoViewHolder extends TypeAdapter.ViewHolder implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public d.a.p0.n1.o.l.e<?> f20496e;

    /* renamed from: f  reason: collision with root package name */
    public m f20497f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbAppLegoViewHolder(d.a.p0.n1.o.l.e<?> eVar) {
        super((View) eVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f20496e = eVar;
    }

    @Override // d.a.p0.n2.e
    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void b(int i2) {
        m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || (mVar = this.f20497f) == null) {
            return;
        }
        mVar.autoPlay(i2);
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            m mVar = this.f20497f;
            if (mVar == null) {
                return false;
            }
            return mVar.canPlay();
        }
        return invokeV.booleanValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            m mVar = this.f20497f;
            if (mVar != null) {
                return mVar.getPlayStatus();
            }
            return -2;
        }
        return invokeV.intValue;
    }

    public void e() {
        m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (mVar = this.f20497f) == null) {
            return;
        }
        mVar.release();
    }

    public void f(m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, mVar) == null) {
            this.f20497f = mVar;
        }
    }

    public void g() {
        d.a.p0.n1.o.l.e<?> eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (eVar = this.f20496e) == null) {
            return;
        }
        eVar.g();
    }

    @Override // d.a.p0.n2.e
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            m mVar = this.f20497f;
            if (mVar == null) {
                return 0;
            }
            return (int) mVar.getCurrentPosition();
        }
        return invokeV.intValue;
    }

    @Override // d.a.p0.n2.e
    public String getPlayUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            m mVar = this.f20497f;
            return mVar == null ? "" : mVar.getPlayUrl();
        }
        return (String) invokeV.objValue;
    }

    @Override // d.a.p0.n2.e
    public View getVideoContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            m mVar = this.f20497f;
            if (mVar == null) {
                return null;
            }
            return mVar.getVideoContainer();
        }
        return (View) invokeV.objValue;
    }

    @Override // d.a.p0.n2.e
    public boolean isPlayStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            m mVar = this.f20497f;
            if (mVar == null) {
                return false;
            }
            return mVar.isPlayStarted();
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.p0.n2.e
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            m mVar = this.f20497f;
            if (mVar == null) {
                return false;
            }
            return mVar.isPlaying();
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.p0.n2.e
    public void startPlay() {
        m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (mVar = this.f20497f) == null) {
            return;
        }
        mVar.startPlay();
    }

    @Override // d.a.p0.n2.e
    public void stopPlay() {
        m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (mVar = this.f20497f) == null) {
            return;
        }
        mVar.stopPlay();
    }
}

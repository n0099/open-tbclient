package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes5.dex */
public final class iu extends mr implements ku {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ks d;
    public final ms e;
    public final qs f;
    public final ts g;
    public final os h;
    public final js i;
    public final ps j;
    public final lu k;
    public final tu l;

    public iu(ks ksVar, ms msVar, qs qsVar, ts tsVar, os osVar, js jsVar, ps psVar, lu luVar, tu tuVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ksVar, msVar, qsVar, tsVar, osVar, jsVar, psVar, luVar, tuVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = ksVar;
        this.e = msVar;
        this.f = qsVar;
        this.g = tsVar;
        this.h = osVar;
        this.i = jsVar;
        this.j = psVar;
        this.k = luVar;
        this.l = tuVar;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ iu(ks ksVar, ms msVar, qs qsVar, ts tsVar, os osVar, js jsVar, ps psVar, lu luVar, tu tuVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(ksVar, msVar, qsVar, tsVar, osVar, jsVar, psVar, r10, r11);
        mu muVar;
        vu vuVar;
        if ((i & 128) != 0) {
            muVar = new mu();
        } else {
            muVar = luVar;
        }
        if ((i & 256) != 0) {
            vuVar = new vu();
        } else {
            vuVar = tuVar;
        }
    }

    @Override // com.baidu.tieba.lr
    public ps a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.j;
        }
        return (ps) invokeV.objValue;
    }

    @Override // com.baidu.tieba.lr
    public qs b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.f;
        }
        return (qs) invokeV.objValue;
    }

    @Override // com.baidu.tieba.lr
    public js c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.i;
        }
        return (js) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ku
    public lu d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.k;
        }
        return (lu) invokeV.objValue;
    }

    @Override // com.baidu.tieba.lr
    public ts e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.g;
        }
        return (ts) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ku
    public tu f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.l;
        }
        return (tu) invokeV.objValue;
    }

    @Override // com.baidu.tieba.lr
    public ms g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.e;
        }
        return (ms) invokeV.objValue;
    }

    @Override // com.baidu.tieba.lr
    public ks h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.d;
        }
        return (ks) invokeV.objValue;
    }

    @Override // com.baidu.tieba.lr
    public os i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.h;
        }
        return (os) invokeV.objValue;
    }
}

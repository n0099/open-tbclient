package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes8.dex */
public final class qp extends um implements sp {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final sn d;
    public final un e;
    public final yn f;
    public final bo g;
    public final wn h;
    public final rn i;
    public final xn j;
    public final tp k;
    public final bq l;

    public qp(sn snVar, un unVar, yn ynVar, bo boVar, wn wnVar, rn rnVar, xn xnVar, tp tpVar, bq bqVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {snVar, unVar, ynVar, boVar, wnVar, rnVar, xnVar, tpVar, bqVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = snVar;
        this.e = unVar;
        this.f = ynVar;
        this.g = boVar;
        this.h = wnVar;
        this.i = rnVar;
        this.j = xnVar;
        this.k = tpVar;
        this.l = bqVar;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ qp(sn snVar, un unVar, yn ynVar, bo boVar, wn wnVar, rn rnVar, xn xnVar, tp tpVar, bq bqVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(snVar, unVar, ynVar, boVar, wnVar, rnVar, xnVar, r10, r11);
        up upVar;
        dq dqVar;
        if ((i & 128) != 0) {
            upVar = new up();
        } else {
            upVar = tpVar;
        }
        if ((i & 256) != 0) {
            dqVar = new dq();
        } else {
            dqVar = bqVar;
        }
    }

    @Override // com.baidu.tieba.tm
    public xn a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.j;
        }
        return (xn) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tm
    public yn b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.f;
        }
        return (yn) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tm
    public rn c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.i;
        }
        return (rn) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sp
    public tp d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.k;
        }
        return (tp) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tm
    public bo e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.g;
        }
        return (bo) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sp
    public bq f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.l;
        }
        return (bq) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tm
    public un g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.e;
        }
        return (un) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tm
    public sn h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.d;
        }
        return (sn) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tm
    public wn i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.h;
        }
        return (wn) invokeV.objValue;
    }
}

package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import kotlin.Pair;
import kotlin.collections.MapsKt__MapsKt;
/* loaded from: classes7.dex */
public final class qz9 implements k2a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final wz9 a;
    public final vz9 b;
    public final xz9 c;
    public final rz9 d;
    public final tz9 e;
    public final HashMap<m2a, HashMap<l2a, m2a>> f;

    public qz9() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new wz9();
        this.b = new vz9();
        this.c = new xz9();
        new yz9();
        this.d = new rz9();
        this.e = new tz9();
        new uz9();
        new sz9();
        this.f = MapsKt__MapsKt.hashMapOf(new Pair(a(), MapsKt__MapsKt.hashMapOf(new Pair(this.d, this.b))), new Pair(this.b, MapsKt__MapsKt.hashMapOf(new Pair(this.e, this.c))));
    }

    public final rz9 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.d;
        }
        return (rz9) invokeV.objValue;
    }

    public final vz9 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b;
        }
        return (vz9) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.k2a
    /* renamed from: d */
    public wz9 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.a;
        }
        return (wz9) invokeV.objValue;
    }

    public final tz9 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.e;
        }
        return (tz9) invokeV.objValue;
    }

    public final xz9 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.c;
        }
        return (xz9) invokeV.objValue;
    }

    @Override // com.baidu.tieba.k2a
    public HashMap<m2a, HashMap<l2a, m2a>> getMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.f;
        }
        return (HashMap) invokeV.objValue;
    }
}

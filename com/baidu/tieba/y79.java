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
public final class y79 implements j89 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c89 a;
    public final e89 b;
    public final d89 c;
    public final a89 d;
    public final z79 e;
    public final b89 f;
    public final HashMap<l89, HashMap<k89, l89>> g;

    public y79() {
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
        this.a = new c89();
        this.b = new e89();
        this.c = new d89();
        this.d = new a89();
        this.e = new z79();
        this.f = new b89();
        this.g = MapsKt__MapsKt.hashMapOf(new Pair(a(), MapsKt__MapsKt.hashMapOf(new Pair(this.d, this.b), new Pair(this.f, this.c))), new Pair(this.b, MapsKt__MapsKt.hashMapOf(new Pair(this.e, this.c))));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.j89
    /* renamed from: b */
    public c89 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return (c89) invokeV.objValue;
    }

    public final z79 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.e;
        }
        return (z79) invokeV.objValue;
    }

    public final d89 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.c;
        }
        return (d89) invokeV.objValue;
    }

    public final a89 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.d;
        }
        return (a89) invokeV.objValue;
    }

    public final e89 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.b;
        }
        return (e89) invokeV.objValue;
    }

    @Override // com.baidu.tieba.j89
    public HashMap<l89, HashMap<k89, l89>> getMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.g;
        }
        return (HashMap) invokeV.objValue;
    }
}

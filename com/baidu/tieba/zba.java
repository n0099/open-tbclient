package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import kotlin.Pair;
import kotlin.collections.MapsKt__MapsKt;
/* loaded from: classes9.dex */
public final class zba implements kca {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ica a;
    public final fca b;
    public final gca c;
    public final hca d;
    public final aca e;
    public final bca f;
    public final cca g;
    public final HashMap<nca, HashMap<lca, nca>> h;

    public zba() {
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
        this.a = new ica();
        this.b = new fca();
        this.c = new gca();
        this.d = new hca();
        this.e = new aca();
        this.f = new bca();
        this.g = new cca();
        this.h = MapsKt__MapsKt.hashMapOf(new Pair(a(), MapsKt__MapsKt.hashMapOf(new Pair(this.e, this.b))), new Pair(this.b, MapsKt__MapsKt.hashMapOf(new Pair(this.f, this.c))), new Pair(this.c, MapsKt__MapsKt.hashMapOf(new Pair(this.g, this.d))));
    }

    public final aca b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.e;
        }
        return (aca) invokeV.objValue;
    }

    public final fca c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b;
        }
        return (fca) invokeV.objValue;
    }

    public final bca d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.f;
        }
        return (bca) invokeV.objValue;
    }

    public final gca e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.c;
        }
        return (gca) invokeV.objValue;
    }

    public final cca f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.g;
        }
        return (cca) invokeV.objValue;
    }

    public final hca g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.d;
        }
        return (hca) invokeV.objValue;
    }

    @Override // com.baidu.tieba.kca
    public HashMap<nca, HashMap<lca, nca>> getMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.h;
        }
        return (HashMap) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kca
    /* renamed from: h */
    public ica a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.a;
        }
        return (ica) invokeV.objValue;
    }
}

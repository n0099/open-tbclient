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
/* loaded from: classes7.dex */
public final class s7a implements uaa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final z7a a;
    public final x7a b;
    public final a8a c;
    public final y7a d;
    public final t7a e;
    public final v7a f;
    public final u7a g;
    public final HashMap<xaa, HashMap<vaa, xaa>> h;

    public s7a() {
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
        this.a = new z7a();
        this.b = new x7a();
        this.c = new a8a();
        this.d = new y7a();
        new b8a();
        this.e = new t7a();
        this.f = new v7a();
        new w7a();
        this.g = new u7a();
        this.h = MapsKt__MapsKt.hashMapOf(new Pair(a(), MapsKt__MapsKt.hashMapOf(new Pair(this.e, this.b))), new Pair(this.b, MapsKt__MapsKt.hashMapOf(new Pair(this.f, this.c))), new Pair(this.c, MapsKt__MapsKt.hashMapOf(new Pair(this.g, this.d))), new Pair(this.d, MapsKt__MapsKt.hashMapOf(new Pair(this.e, this.b))));
    }

    public final t7a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.e;
        }
        return (t7a) invokeV.objValue;
    }

    public final x7a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b;
        }
        return (x7a) invokeV.objValue;
    }

    public final y7a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.d;
        }
        return (y7a) invokeV.objValue;
    }

    public final u7a e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.g;
        }
        return (u7a) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.uaa
    /* renamed from: f */
    public z7a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.a;
        }
        return (z7a) invokeV.objValue;
    }

    public final v7a g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.f;
        }
        return (v7a) invokeV.objValue;
    }

    @Override // com.baidu.tieba.uaa
    public HashMap<xaa, HashMap<vaa, xaa>> getMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.h;
        }
        return (HashMap) invokeV.objValue;
    }

    public final a8a h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.c;
        }
        return (a8a) invokeV.objValue;
    }
}

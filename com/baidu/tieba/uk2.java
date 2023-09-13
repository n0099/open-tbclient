package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.go4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public final class uk2 implements go4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public boolean b;
    public go4 c;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public uk2 a;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public uk2 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                uk2 uk2Var = this.a;
                this.a = null;
                return uk2Var;
            }
            return (uk2) invokeV.objValue;
        }

        public final uk2 c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (this.a == null) {
                    this.a = new uk2(null);
                }
                return this.a;
            }
            return (uk2) invokeV.objValue;
        }

        public b b(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) != null) {
                return (b) invokeZ.objValue;
            }
            c().b = z;
            return this;
        }

        public b d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048579, this, str)) != null) {
                return (b) invokeL.objValue;
            }
            c().a = str;
            return this;
        }

        public b e(go4 go4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048580, this, go4Var)) != null) {
                return (b) invokeL.objValue;
            }
            c().c = go4Var;
            return this;
        }
    }

    public uk2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b;
        }
        return invokeV.booleanValue;
    }

    @NonNull
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return "SoLib:: libName=" + this.a + " buildin=" + this.b;
        }
        return (String) invokeV.objValue;
    }

    public /* synthetic */ uk2(a aVar) {
        this();
    }

    @Override // com.baidu.tieba.go4
    public void a(String str, go4.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, aVar) == null) {
            go4 go4Var = this.c;
            if (go4Var != null) {
                go4Var.a(str, aVar);
            } else if (aVar != null) {
                aVar.a(true);
            }
        }
    }
}

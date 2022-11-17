package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ta5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public String b;
    public boolean c;
    public String d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public ua5 j;
    public va5 k;
    public sg<in> l;

    public int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return 45;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes6.dex */
    public class a extends sg<in> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ta5 a;

        public a(ta5 ta5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ta5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ta5Var;
        }

        @Override // com.baidu.tieba.sg
        public void onCancelled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                super.onCancelled(str);
            }
        }

        @Override // com.baidu.tieba.sg
        public void onProgressUpdate(Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, objArr) == null) {
                super.onProgressUpdate(objArr);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sg
        public void onLoaded(in inVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, inVar, str, i) == null) {
                if (inVar != null && str != null) {
                    if (this.a.w()) {
                        if (str.equals(this.a.j.b())) {
                            this.a.f = true;
                        }
                        if (str.equals(this.a.j.c())) {
                            this.a.g = true;
                        }
                        if (str.equals(this.a.j.a())) {
                            this.a.h = true;
                        }
                        if (this.a.f && this.a.g && this.a.h) {
                            this.a.i = true;
                        }
                    } else {
                        if (str.equals(this.a.b)) {
                            this.a.c = true;
                        }
                        if (str.equals(this.a.d)) {
                            this.a.e = true;
                        }
                        if (this.a.c && this.a.e) {
                            this.a.i = true;
                        }
                    }
                }
                if (this.a.k != null && this.a.i) {
                    this.a.k.a();
                }
            }
        }
    }

    public ta5() {
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
        this.l = new a(this);
    }

    public ua5 r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.j;
        }
        return (ua5) invokeV.objValue;
    }

    public String t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.i;
        }
        return invokeV.booleanValue;
    }

    public void A(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bdUniqueId) == null) {
            this.a = bdUniqueId;
        }
    }

    public void y(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject) == null) {
            this.b = jSONObject.optString("pic_before");
            this.d = jSONObject.optString("pic_after");
            ua5 ua5Var = new ua5();
            this.j = ua5Var;
            ua5Var.i(jSONObject);
        }
    }

    public void z(va5 va5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, va5Var) == null) {
            this.k = va5Var;
        }
    }

    public final boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ua5 ua5Var = this.j;
            if (ua5Var != null && StringUtils.isNotNull(ua5Var.b()) && StringUtils.isNotNull(this.j.c()) && StringUtils.isNotNull(this.j.a())) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            String str = this.b;
            if (str != null && !xi.isEmpty(str)) {
                tg.h().k(this.b, s(), this.l, 0, 0, this.a, new Object[0]);
            }
            String str2 = this.d;
            if (str2 != null && !xi.isEmpty(str2)) {
                tg.h().k(this.d, s(), this.l, 0, 0, this.a, new Object[0]);
            }
            if (w()) {
                tg.h().k(this.j.b(), s(), this.l, 0, 0, this.a, new Object[0]);
                tg.h().k(this.j.c(), s(), this.l, 0, 0, this.a, new Object[0]);
                tg.h().k(this.j.a(), s(), this.l, 0, 0, this.a, new Object[0]);
            }
        }
    }
}

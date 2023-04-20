package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class wz2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static final class a implements sz2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Function1 a;
        public final /* synthetic */ String b;

        public a(Function1 function1, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {function1, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = function1;
            this.b = str;
        }

        @Override // com.baidu.tieba.sz2
        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                JSONArray a = wz2.a();
                if (a != null && a.length() != 0) {
                    int length = a.length();
                    for (int i = 0; i < length; i++) {
                        if (Intrinsics.areEqual(this.b, a.get(i))) {
                            Function1 function1 = this.a;
                            if (function1 != null) {
                                Unit unit = (Unit) function1.invoke(Boolean.TRUE);
                                return;
                            }
                            return;
                        }
                    }
                    Function1 function12 = this.a;
                    if (function12 != null) {
                        Unit unit2 = (Unit) function12.invoke(Boolean.FALSE);
                        return;
                    }
                    return;
                }
                Function1 function13 = this.a;
                if (function13 != null) {
                    Unit unit3 = (Unit) function13.invoke(Boolean.TRUE);
                }
            }
        }
    }

    public static final /* synthetic */ JSONArray a() {
        return c();
    }

    public static final void b(String str, Function1<? super Boolean, Unit> function1) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, function1) == null) {
            rz2.g().z(new a(function1, str));
        }
    }

    public static final JSONArray c() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            v73 b0 = v73.b0();
            if (b0 == null) {
                return null;
            }
            String q = b0.e0().q("note_data_pay_check_list", "");
            if (q != null && !StringsKt__StringsJVMKt.isBlank(q)) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return null;
            }
            return new JSONObject(q).optJSONArray("pay_keys");
        }
        return (JSONArray) invokeV.objValue;
    }
}

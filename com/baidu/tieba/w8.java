package com.baidu.tieba;

import android.util.SparseArray;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import org.json.JSONArray;
/* loaded from: classes8.dex */
public class w8 implements u8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public JSONArray a;

    public w8(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONArray};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = jSONArray;
    }

    @Override // com.baidu.tieba.u8
    public Object a(k9 k9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, k9Var)) == null) {
            Class<?> a = k9Var.a();
            Type[] b = k9Var.b();
            if (a.isArray()) {
                Class<?> componentType = a.getComponentType();
                Object newInstance = Array.newInstance(componentType, this.a.length());
                int length = this.a.length();
                for (int i = 0; i < length; i++) {
                    Object a2 = o9.a(this.a.opt(i)).a(new k9(componentType));
                    if (a2 != null) {
                        Array.set(newInstance, i, a2);
                    }
                }
                return newInstance;
            } else if (b != null && b.length >= 1) {
                if (r7.e(a, List.class)) {
                    List<Object> a3 = i9.a(k9Var, this.a.length());
                    if (a3 != null) {
                        int length2 = this.a.length();
                        for (int i2 = 0; i2 < length2; i2++) {
                            Object a4 = o9.a(this.a.opt(i2)).a(new k9(b[0]));
                            if (a4 != null) {
                                a3.add(a4);
                            }
                        }
                    }
                    return a3;
                } else if (r7.e(a, Set.class)) {
                    Set<Object> d = i9.d(k9Var, this.a.length());
                    if (d != null) {
                        int length3 = this.a.length();
                        for (int i3 = 0; i3 < length3; i3++) {
                            Object a5 = o9.a(this.a.opt(i3)).a(new k9(b[0]));
                            if (a5 != null) {
                                d.add(a5);
                            }
                        }
                    }
                    return d;
                } else if (r7.e(a, Map.class)) {
                    Map<String, Object> b2 = i9.b(k9Var, this.a.length());
                    if (b2 != null) {
                        int length4 = this.a.length();
                        for (int i4 = 0; i4 < length4; i4++) {
                            Object a6 = o9.a(this.a.opt(i4)).a(new k9(b[0]));
                            if (a6 != null) {
                                b2.put(String.valueOf(i4), a6);
                            }
                        }
                    }
                    return b2;
                } else if (r7.e(a, Queue.class)) {
                    Queue<Object> c = i9.c(k9Var, this.a.length());
                    if (c != null) {
                        int length5 = this.a.length();
                        for (int i5 = 0; i5 < length5; i5++) {
                            Object a7 = o9.a(this.a.opt(i5)).a(new k9(b[0]));
                            if (a7 != null) {
                                c.add(a7);
                            }
                        }
                    }
                    return c;
                } else if (a == SparseArray.class) {
                    SparseArray sparseArray = new SparseArray(this.a.length());
                    int length6 = this.a.length();
                    for (int i6 = 0; i6 < length6; i6++) {
                        Object a8 = o9.a(this.a.opt(i6)).a(new k9(b[0]));
                        if (a8 != null) {
                            sparseArray.put(i6, a8);
                        }
                    }
                    return sparseArray;
                } else {
                    return null;
                }
            } else {
                return null;
            }
        }
        return invokeL.objValue;
    }
}

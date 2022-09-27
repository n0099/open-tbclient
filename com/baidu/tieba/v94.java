package com.baidu.tieba;

import android.util.SparseArray;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class v94 {
    public static /* synthetic */ Interceptable $ic;
    public static SparseArray<t94> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948195608, "Lcom/baidu/tieba/v94;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948195608, "Lcom/baidu/tieba/v94;");
                return;
            }
        }
        SparseArray<t94> sparseArray = new SparseArray<>();
        a = sparseArray;
        sparseArray.put(5, new t94(5, R.string.obfuscated_res_0x7f0f00fc, R.drawable.obfuscated_res_0x7f0800f5, true));
        a.put(35, new t94(35, R.string.obfuscated_res_0x7f0f00ef, R.drawable.obfuscated_res_0x7f0800d5, true));
        a.put(39, new t94(39, R.string.obfuscated_res_0x7f0f00f6, R.drawable.obfuscated_res_0x7f0800f8, true));
        a.put(4, new t94(4, R.string.obfuscated_res_0x7f0f00fd, R.drawable.obfuscated_res_0x7f0800fb, true));
        a.put(37, new t94(37, R.string.obfuscated_res_0x7f0f00f1, R.drawable.obfuscated_res_0x7f0800d8, true));
        a.put(38, new t94(38, R.string.obfuscated_res_0x7f0f00fa, R.drawable.obfuscated_res_0x7f0800d4, true));
        a.put(42, new t94(42, R.string.obfuscated_res_0x7f0f00f2, R.drawable.obfuscated_res_0x7f0800f8, true));
        a.put(49, new t94(49, R.string.obfuscated_res_0x7f0f126a, R.drawable.obfuscated_res_0x7f081157, true));
        a.put(50, new t94(50, R.string.obfuscated_res_0x7f0f12ee, R.drawable.obfuscated_res_0x7f081156, true));
        a.put(43, new t94(43, R.string.obfuscated_res_0x7f0f00f0, R.drawable.obfuscated_res_0x7f0800d9, true));
        a.put(9, new t94(9, R.string.obfuscated_res_0x7f0f00fb, R.drawable.obfuscated_res_0x7f0800e5, true));
        a.put(46, new t94(46, R.string.obfuscated_res_0x7f0f00f3, R.drawable.obfuscated_res_0x7f0800ea, true));
        a.put(47, new t94(47, R.string.obfuscated_res_0x7f0f00f4, R.drawable.obfuscated_res_0x7f0800ed, true));
    }

    public static t94 a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) ? t94.k(a.get(i)) : (t94) invokeI.objValue;
    }

    public static List<t94> b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            ArrayList arrayList = new ArrayList();
            if (i != 0) {
                if (i != 12) {
                    if (i != 13) {
                        switch (i) {
                            case 16:
                                arrayList.add(t94.k(a.get(5)));
                                break;
                            case 17:
                            case 18:
                                arrayList.add(t94.k(a.get(38)));
                                arrayList.add(t94.k(a.get(4)));
                                arrayList.add(t94.k(a.get(39)));
                                arrayList.add(t94.k(a.get(35)));
                                arrayList.add(t94.k(a.get(5)));
                                arrayList.add(t94.k(a.get(49)));
                                break;
                            case 19:
                                arrayList.add(t94.l(a.get(38), false));
                                arrayList.add(t94.l(a.get(4), false));
                                arrayList.add(t94.k(a.get(39)));
                                arrayList.add(t94.l(a.get(35), false));
                                arrayList.add(t94.k(a.get(5)));
                                arrayList.add(t94.l(a.get(49), false));
                                break;
                            case 20:
                                arrayList.add(t94.k(a.get(38)));
                                arrayList.add(t94.k(a.get(4)));
                                arrayList.add(t94.k(a.get(39)));
                                arrayList.add(t94.k(a.get(35)));
                                arrayList.add(t94.k(a.get(5)));
                                arrayList.add(t94.k(a.get(49)));
                                break;
                        }
                    } else {
                        arrayList.add(t94.k(a.get(43)));
                    }
                }
                arrayList.add(t94.k(a.get(38)));
                arrayList.add(t94.k(a.get(4)));
                arrayList.add(t94.k(a.get(39)));
                arrayList.add(t94.k(a.get(35)));
                arrayList.add(t94.k(a.get(5)));
                arrayList.add(t94.k(a.get(49)));
            } else {
                arrayList.add(t94.k(a.get(38)));
                arrayList.add(t94.k(a.get(5)));
                arrayList.add(t94.k(a.get(4)));
                arrayList.add(t94.k(a.get(35)));
                arrayList.add(t94.k(a.get(42)));
            }
            return arrayList;
        }
        return (List) invokeI.objValue;
    }
}

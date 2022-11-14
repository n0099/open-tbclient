package com.baidu.tieba;

import android.util.SparseArray;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class pa4 {
    public static /* synthetic */ Interceptable $ic;
    public static SparseArray<na4> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948055302, "Lcom/baidu/tieba/pa4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948055302, "Lcom/baidu/tieba/pa4;");
                return;
            }
        }
        SparseArray<na4> sparseArray = new SparseArray<>();
        a = sparseArray;
        sparseArray.put(5, new na4(5, R.string.obfuscated_res_0x7f0f00fc, R.drawable.obfuscated_res_0x7f0800f5, true));
        a.put(35, new na4(35, R.string.obfuscated_res_0x7f0f00ef, R.drawable.obfuscated_res_0x7f0800d5, true));
        a.put(39, new na4(39, R.string.obfuscated_res_0x7f0f00f6, R.drawable.obfuscated_res_0x7f0800f8, true));
        a.put(4, new na4(4, R.string.obfuscated_res_0x7f0f00fd, R.drawable.obfuscated_res_0x7f0800fb, true));
        a.put(37, new na4(37, R.string.obfuscated_res_0x7f0f00f1, R.drawable.obfuscated_res_0x7f0800d8, true));
        a.put(38, new na4(38, R.string.obfuscated_res_0x7f0f00fa, R.drawable.obfuscated_res_0x7f0800d4, true));
        a.put(42, new na4(42, R.string.obfuscated_res_0x7f0f00f2, R.drawable.obfuscated_res_0x7f0800f8, true));
        a.put(49, new na4(49, R.string.obfuscated_res_0x7f0f12a3, R.drawable.obfuscated_res_0x7f081195, true));
        a.put(50, new na4(50, R.string.obfuscated_res_0x7f0f1327, R.drawable.obfuscated_res_0x7f081194, true));
        a.put(43, new na4(43, R.string.obfuscated_res_0x7f0f00f0, R.drawable.obfuscated_res_0x7f0800d9, true));
        a.put(9, new na4(9, R.string.obfuscated_res_0x7f0f00fb, R.drawable.obfuscated_res_0x7f0800e5, true));
        a.put(46, new na4(46, R.string.obfuscated_res_0x7f0f00f3, R.drawable.obfuscated_res_0x7f0800ea, true));
        a.put(47, new na4(47, R.string.obfuscated_res_0x7f0f00f4, R.drawable.obfuscated_res_0x7f0800ed, true));
    }

    public static na4 a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) {
            return na4.k(a.get(i));
        }
        return (na4) invokeI.objValue;
    }

    public static List<na4> b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            ArrayList arrayList = new ArrayList();
            if (i != 0) {
                if (i != 12) {
                    if (i != 13) {
                        switch (i) {
                            case 16:
                                arrayList.add(na4.k(a.get(5)));
                                break;
                            case 17:
                            case 18:
                                arrayList.add(na4.k(a.get(38)));
                                arrayList.add(na4.k(a.get(4)));
                                arrayList.add(na4.k(a.get(39)));
                                arrayList.add(na4.k(a.get(35)));
                                arrayList.add(na4.k(a.get(5)));
                                arrayList.add(na4.k(a.get(49)));
                                break;
                            case 19:
                                arrayList.add(na4.l(a.get(38), false));
                                arrayList.add(na4.l(a.get(4), false));
                                arrayList.add(na4.k(a.get(39)));
                                arrayList.add(na4.l(a.get(35), false));
                                arrayList.add(na4.k(a.get(5)));
                                arrayList.add(na4.l(a.get(49), false));
                                break;
                            case 20:
                                arrayList.add(na4.k(a.get(38)));
                                arrayList.add(na4.k(a.get(4)));
                                arrayList.add(na4.k(a.get(39)));
                                arrayList.add(na4.k(a.get(35)));
                                arrayList.add(na4.k(a.get(5)));
                                arrayList.add(na4.k(a.get(49)));
                                break;
                        }
                    } else {
                        arrayList.add(na4.k(a.get(43)));
                    }
                }
                arrayList.add(na4.k(a.get(38)));
                arrayList.add(na4.k(a.get(4)));
                arrayList.add(na4.k(a.get(39)));
                arrayList.add(na4.k(a.get(35)));
                arrayList.add(na4.k(a.get(5)));
                arrayList.add(na4.k(a.get(49)));
            } else {
                arrayList.add(na4.k(a.get(38)));
                arrayList.add(na4.k(a.get(5)));
                arrayList.add(na4.k(a.get(4)));
                arrayList.add(na4.k(a.get(35)));
                arrayList.add(na4.k(a.get(42)));
            }
            return arrayList;
        }
        return (List) invokeI.objValue;
    }
}

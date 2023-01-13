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
public class ta4 {
    public static /* synthetic */ Interceptable $ic;
    public static SparseArray<ra4> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948174466, "Lcom/baidu/tieba/ta4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948174466, "Lcom/baidu/tieba/ta4;");
                return;
            }
        }
        SparseArray<ra4> sparseArray = new SparseArray<>();
        a = sparseArray;
        sparseArray.put(5, new ra4(5, R.string.obfuscated_res_0x7f0f00fe, R.drawable.obfuscated_res_0x7f0800f5, true));
        a.put(35, new ra4(35, R.string.obfuscated_res_0x7f0f00f1, R.drawable.obfuscated_res_0x7f0800d5, true));
        a.put(39, new ra4(39, R.string.obfuscated_res_0x7f0f00f8, R.drawable.obfuscated_res_0x7f0800f8, true));
        a.put(4, new ra4(4, R.string.obfuscated_res_0x7f0f00ff, R.drawable.obfuscated_res_0x7f0800fb, true));
        a.put(37, new ra4(37, R.string.obfuscated_res_0x7f0f00f3, R.drawable.obfuscated_res_0x7f0800d8, true));
        a.put(38, new ra4(38, R.string.obfuscated_res_0x7f0f00fc, R.drawable.obfuscated_res_0x7f0800d4, true));
        a.put(42, new ra4(42, R.string.obfuscated_res_0x7f0f00f4, R.drawable.obfuscated_res_0x7f0800f8, true));
        a.put(49, new ra4(49, R.string.obfuscated_res_0x7f0f12f5, R.drawable.obfuscated_res_0x7f0811d5, true));
        a.put(50, new ra4(50, R.string.obfuscated_res_0x7f0f1379, R.drawable.obfuscated_res_0x7f0811d4, true));
        a.put(43, new ra4(43, R.string.obfuscated_res_0x7f0f00f2, R.drawable.obfuscated_res_0x7f0800d9, true));
        a.put(9, new ra4(9, R.string.obfuscated_res_0x7f0f00fd, R.drawable.obfuscated_res_0x7f0800e5, true));
        a.put(46, new ra4(46, R.string.obfuscated_res_0x7f0f00f5, R.drawable.obfuscated_res_0x7f0800ea, true));
        a.put(47, new ra4(47, R.string.obfuscated_res_0x7f0f00f6, R.drawable.obfuscated_res_0x7f0800ed, true));
    }

    public static ra4 a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) {
            return ra4.k(a.get(i));
        }
        return (ra4) invokeI.objValue;
    }

    public static List<ra4> b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            ArrayList arrayList = new ArrayList();
            if (i != 0) {
                if (i != 12) {
                    if (i != 13) {
                        switch (i) {
                            case 16:
                                arrayList.add(ra4.k(a.get(5)));
                                break;
                            case 17:
                            case 18:
                                arrayList.add(ra4.k(a.get(38)));
                                arrayList.add(ra4.k(a.get(4)));
                                arrayList.add(ra4.k(a.get(39)));
                                arrayList.add(ra4.k(a.get(35)));
                                arrayList.add(ra4.k(a.get(5)));
                                arrayList.add(ra4.k(a.get(49)));
                                break;
                            case 19:
                                arrayList.add(ra4.l(a.get(38), false));
                                arrayList.add(ra4.l(a.get(4), false));
                                arrayList.add(ra4.k(a.get(39)));
                                arrayList.add(ra4.l(a.get(35), false));
                                arrayList.add(ra4.k(a.get(5)));
                                arrayList.add(ra4.l(a.get(49), false));
                                break;
                            case 20:
                                arrayList.add(ra4.k(a.get(38)));
                                arrayList.add(ra4.k(a.get(4)));
                                arrayList.add(ra4.k(a.get(39)));
                                arrayList.add(ra4.k(a.get(35)));
                                arrayList.add(ra4.k(a.get(5)));
                                arrayList.add(ra4.k(a.get(49)));
                                break;
                        }
                    } else {
                        arrayList.add(ra4.k(a.get(43)));
                    }
                }
                arrayList.add(ra4.k(a.get(38)));
                arrayList.add(ra4.k(a.get(4)));
                arrayList.add(ra4.k(a.get(39)));
                arrayList.add(ra4.k(a.get(35)));
                arrayList.add(ra4.k(a.get(5)));
                arrayList.add(ra4.k(a.get(49)));
            } else {
                arrayList.add(ra4.k(a.get(38)));
                arrayList.add(ra4.k(a.get(5)));
                arrayList.add(ra4.k(a.get(4)));
                arrayList.add(ra4.k(a.get(35)));
                arrayList.add(ra4.k(a.get(42)));
            }
            return arrayList;
        }
        return (List) invokeI.objValue;
    }
}

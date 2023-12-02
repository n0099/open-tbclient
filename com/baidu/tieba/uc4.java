package com.baidu.tieba;

import android.util.SparseArray;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class uc4 {
    public static /* synthetic */ Interceptable $ic;
    public static SparseArray<sc4> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948206179, "Lcom/baidu/tieba/uc4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948206179, "Lcom/baidu/tieba/uc4;");
                return;
            }
        }
        SparseArray<sc4> sparseArray = new SparseArray<>();
        a = sparseArray;
        sparseArray.put(5, new sc4(5, R.string.obfuscated_res_0x7f0f0133, R.drawable.obfuscated_res_0x7f080115, true));
        a.put(35, new sc4(35, R.string.obfuscated_res_0x7f0f0126, R.drawable.obfuscated_res_0x7f0800f5, true));
        a.put(39, new sc4(39, R.string.obfuscated_res_0x7f0f012d, R.drawable.obfuscated_res_0x7f080118, true));
        a.put(4, new sc4(4, R.string.obfuscated_res_0x7f0f0134, R.drawable.obfuscated_res_0x7f08011b, true));
        a.put(37, new sc4(37, R.string.obfuscated_res_0x7f0f0128, R.drawable.obfuscated_res_0x7f0800f8, true));
        a.put(38, new sc4(38, R.string.obfuscated_res_0x7f0f0131, R.drawable.obfuscated_res_0x7f0800f4, true));
        a.put(42, new sc4(42, R.string.obfuscated_res_0x7f0f0129, R.drawable.obfuscated_res_0x7f080118, true));
        a.put(49, new sc4(49, R.string.obfuscated_res_0x7f0f1514, R.drawable.obfuscated_res_0x7f08147c, true));
        a.put(50, new sc4(50, R.string.obfuscated_res_0x7f0f1598, R.drawable.obfuscated_res_0x7f08147b, true));
        a.put(43, new sc4(43, R.string.obfuscated_res_0x7f0f0127, R.drawable.obfuscated_res_0x7f0800f9, true));
        a.put(9, new sc4(9, R.string.obfuscated_res_0x7f0f0132, R.drawable.obfuscated_res_0x7f080105, true));
        a.put(46, new sc4(46, R.string.obfuscated_res_0x7f0f012a, R.drawable.obfuscated_res_0x7f08010a, true));
        a.put(47, new sc4(47, R.string.obfuscated_res_0x7f0f012b, R.drawable.obfuscated_res_0x7f08010d, true));
    }

    public static sc4 a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) {
            return sc4.k(a.get(i));
        }
        return (sc4) invokeI.objValue;
    }

    public static List<sc4> b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            ArrayList arrayList = new ArrayList();
            if (i != 0) {
                if (i != 12) {
                    if (i != 13) {
                        switch (i) {
                            case 16:
                                arrayList.add(sc4.k(a.get(5)));
                                break;
                            case 17:
                            case 18:
                                arrayList.add(sc4.k(a.get(38)));
                                arrayList.add(sc4.k(a.get(4)));
                                arrayList.add(sc4.k(a.get(39)));
                                arrayList.add(sc4.k(a.get(35)));
                                arrayList.add(sc4.k(a.get(5)));
                                arrayList.add(sc4.k(a.get(49)));
                                break;
                            case 19:
                                arrayList.add(sc4.l(a.get(38), false));
                                arrayList.add(sc4.l(a.get(4), false));
                                arrayList.add(sc4.k(a.get(39)));
                                arrayList.add(sc4.l(a.get(35), false));
                                arrayList.add(sc4.k(a.get(5)));
                                arrayList.add(sc4.l(a.get(49), false));
                                break;
                            case 20:
                                arrayList.add(sc4.k(a.get(38)));
                                arrayList.add(sc4.k(a.get(4)));
                                arrayList.add(sc4.k(a.get(39)));
                                arrayList.add(sc4.k(a.get(35)));
                                arrayList.add(sc4.k(a.get(5)));
                                arrayList.add(sc4.k(a.get(49)));
                                break;
                        }
                    } else {
                        arrayList.add(sc4.k(a.get(43)));
                    }
                }
                arrayList.add(sc4.k(a.get(38)));
                arrayList.add(sc4.k(a.get(4)));
                arrayList.add(sc4.k(a.get(39)));
                arrayList.add(sc4.k(a.get(35)));
                arrayList.add(sc4.k(a.get(5)));
                arrayList.add(sc4.k(a.get(49)));
            } else {
                arrayList.add(sc4.k(a.get(38)));
                arrayList.add(sc4.k(a.get(5)));
                arrayList.add(sc4.k(a.get(4)));
                arrayList.add(sc4.k(a.get(35)));
                arrayList.add(sc4.k(a.get(42)));
            }
            return arrayList;
        }
        return (List) invokeI.objValue;
    }
}

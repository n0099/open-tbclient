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
public class rc4 {
    public static /* synthetic */ Interceptable $ic;
    public static SparseArray<pc4> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948116806, "Lcom/baidu/tieba/rc4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948116806, "Lcom/baidu/tieba/rc4;");
                return;
            }
        }
        SparseArray<pc4> sparseArray = new SparseArray<>();
        a = sparseArray;
        sparseArray.put(5, new pc4(5, R.string.obfuscated_res_0x7f0f0133, R.drawable.obfuscated_res_0x7f080115, true));
        a.put(35, new pc4(35, R.string.obfuscated_res_0x7f0f0126, R.drawable.obfuscated_res_0x7f0800f5, true));
        a.put(39, new pc4(39, R.string.obfuscated_res_0x7f0f012d, R.drawable.obfuscated_res_0x7f080118, true));
        a.put(4, new pc4(4, R.string.obfuscated_res_0x7f0f0134, R.drawable.obfuscated_res_0x7f08011b, true));
        a.put(37, new pc4(37, R.string.obfuscated_res_0x7f0f0128, R.drawable.obfuscated_res_0x7f0800f8, true));
        a.put(38, new pc4(38, R.string.obfuscated_res_0x7f0f0131, R.drawable.obfuscated_res_0x7f0800f4, true));
        a.put(42, new pc4(42, R.string.obfuscated_res_0x7f0f0129, R.drawable.obfuscated_res_0x7f080118, true));
        a.put(49, new pc4(49, R.string.obfuscated_res_0x7f0f1513, R.drawable.obfuscated_res_0x7f081479, true));
        a.put(50, new pc4(50, R.string.obfuscated_res_0x7f0f1597, R.drawable.obfuscated_res_0x7f081478, true));
        a.put(43, new pc4(43, R.string.obfuscated_res_0x7f0f0127, R.drawable.obfuscated_res_0x7f0800f9, true));
        a.put(9, new pc4(9, R.string.obfuscated_res_0x7f0f0132, R.drawable.obfuscated_res_0x7f080105, true));
        a.put(46, new pc4(46, R.string.obfuscated_res_0x7f0f012a, R.drawable.obfuscated_res_0x7f08010a, true));
        a.put(47, new pc4(47, R.string.obfuscated_res_0x7f0f012b, R.drawable.obfuscated_res_0x7f08010d, true));
    }

    public static pc4 a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) {
            return pc4.k(a.get(i));
        }
        return (pc4) invokeI.objValue;
    }

    public static List<pc4> b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            ArrayList arrayList = new ArrayList();
            if (i != 0) {
                if (i != 12) {
                    if (i != 13) {
                        switch (i) {
                            case 16:
                                arrayList.add(pc4.k(a.get(5)));
                                break;
                            case 17:
                            case 18:
                                arrayList.add(pc4.k(a.get(38)));
                                arrayList.add(pc4.k(a.get(4)));
                                arrayList.add(pc4.k(a.get(39)));
                                arrayList.add(pc4.k(a.get(35)));
                                arrayList.add(pc4.k(a.get(5)));
                                arrayList.add(pc4.k(a.get(49)));
                                break;
                            case 19:
                                arrayList.add(pc4.l(a.get(38), false));
                                arrayList.add(pc4.l(a.get(4), false));
                                arrayList.add(pc4.k(a.get(39)));
                                arrayList.add(pc4.l(a.get(35), false));
                                arrayList.add(pc4.k(a.get(5)));
                                arrayList.add(pc4.l(a.get(49), false));
                                break;
                            case 20:
                                arrayList.add(pc4.k(a.get(38)));
                                arrayList.add(pc4.k(a.get(4)));
                                arrayList.add(pc4.k(a.get(39)));
                                arrayList.add(pc4.k(a.get(35)));
                                arrayList.add(pc4.k(a.get(5)));
                                arrayList.add(pc4.k(a.get(49)));
                                break;
                        }
                    } else {
                        arrayList.add(pc4.k(a.get(43)));
                    }
                }
                arrayList.add(pc4.k(a.get(38)));
                arrayList.add(pc4.k(a.get(4)));
                arrayList.add(pc4.k(a.get(39)));
                arrayList.add(pc4.k(a.get(35)));
                arrayList.add(pc4.k(a.get(5)));
                arrayList.add(pc4.k(a.get(49)));
            } else {
                arrayList.add(pc4.k(a.get(38)));
                arrayList.add(pc4.k(a.get(5)));
                arrayList.add(pc4.k(a.get(4)));
                arrayList.add(pc4.k(a.get(35)));
                arrayList.add(pc4.k(a.get(42)));
            }
            return arrayList;
        }
        return (List) invokeI.objValue;
    }
}

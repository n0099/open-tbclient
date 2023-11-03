package com.baidu.tieba;

import android.util.SparseArray;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class qc4 {
    public static /* synthetic */ Interceptable $ic;
    public static SparseArray<oc4> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948087015, "Lcom/baidu/tieba/qc4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948087015, "Lcom/baidu/tieba/qc4;");
                return;
            }
        }
        SparseArray<oc4> sparseArray = new SparseArray<>();
        a = sparseArray;
        sparseArray.put(5, new oc4(5, R.string.obfuscated_res_0x7f0f012b, R.drawable.obfuscated_res_0x7f080113, true));
        a.put(35, new oc4(35, R.string.obfuscated_res_0x7f0f011e, R.drawable.obfuscated_res_0x7f0800f3, true));
        a.put(39, new oc4(39, R.string.obfuscated_res_0x7f0f0125, R.drawable.obfuscated_res_0x7f080116, true));
        a.put(4, new oc4(4, R.string.obfuscated_res_0x7f0f012c, R.drawable.obfuscated_res_0x7f080119, true));
        a.put(37, new oc4(37, R.string.obfuscated_res_0x7f0f0120, R.drawable.obfuscated_res_0x7f0800f6, true));
        a.put(38, new oc4(38, R.string.obfuscated_res_0x7f0f0129, R.drawable.obfuscated_res_0x7f0800f2, true));
        a.put(42, new oc4(42, R.string.obfuscated_res_0x7f0f0121, R.drawable.obfuscated_res_0x7f080116, true));
        a.put(49, new oc4(49, R.string.obfuscated_res_0x7f0f1503, R.drawable.obfuscated_res_0x7f081456, true));
        a.put(50, new oc4(50, R.string.obfuscated_res_0x7f0f1587, R.drawable.obfuscated_res_0x7f081455, true));
        a.put(43, new oc4(43, R.string.obfuscated_res_0x7f0f011f, R.drawable.obfuscated_res_0x7f0800f7, true));
        a.put(9, new oc4(9, R.string.obfuscated_res_0x7f0f012a, R.drawable.obfuscated_res_0x7f080103, true));
        a.put(46, new oc4(46, R.string.obfuscated_res_0x7f0f0122, R.drawable.obfuscated_res_0x7f080108, true));
        a.put(47, new oc4(47, R.string.obfuscated_res_0x7f0f0123, R.drawable.obfuscated_res_0x7f08010b, true));
    }

    public static oc4 a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) {
            return oc4.k(a.get(i));
        }
        return (oc4) invokeI.objValue;
    }

    public static List<oc4> b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            ArrayList arrayList = new ArrayList();
            if (i != 0) {
                if (i != 12) {
                    if (i != 13) {
                        switch (i) {
                            case 16:
                                arrayList.add(oc4.k(a.get(5)));
                                break;
                            case 17:
                            case 18:
                                arrayList.add(oc4.k(a.get(38)));
                                arrayList.add(oc4.k(a.get(4)));
                                arrayList.add(oc4.k(a.get(39)));
                                arrayList.add(oc4.k(a.get(35)));
                                arrayList.add(oc4.k(a.get(5)));
                                arrayList.add(oc4.k(a.get(49)));
                                break;
                            case 19:
                                arrayList.add(oc4.l(a.get(38), false));
                                arrayList.add(oc4.l(a.get(4), false));
                                arrayList.add(oc4.k(a.get(39)));
                                arrayList.add(oc4.l(a.get(35), false));
                                arrayList.add(oc4.k(a.get(5)));
                                arrayList.add(oc4.l(a.get(49), false));
                                break;
                            case 20:
                                arrayList.add(oc4.k(a.get(38)));
                                arrayList.add(oc4.k(a.get(4)));
                                arrayList.add(oc4.k(a.get(39)));
                                arrayList.add(oc4.k(a.get(35)));
                                arrayList.add(oc4.k(a.get(5)));
                                arrayList.add(oc4.k(a.get(49)));
                                break;
                        }
                    } else {
                        arrayList.add(oc4.k(a.get(43)));
                    }
                }
                arrayList.add(oc4.k(a.get(38)));
                arrayList.add(oc4.k(a.get(4)));
                arrayList.add(oc4.k(a.get(39)));
                arrayList.add(oc4.k(a.get(35)));
                arrayList.add(oc4.k(a.get(5)));
                arrayList.add(oc4.k(a.get(49)));
            } else {
                arrayList.add(oc4.k(a.get(38)));
                arrayList.add(oc4.k(a.get(5)));
                arrayList.add(oc4.k(a.get(4)));
                arrayList.add(oc4.k(a.get(35)));
                arrayList.add(oc4.k(a.get(42)));
            }
            return arrayList;
        }
        return (List) invokeI.objValue;
    }
}

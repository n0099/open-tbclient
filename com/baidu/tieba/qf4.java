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
public class qf4 {
    public static /* synthetic */ Interceptable $ic;
    public static SparseArray<of4> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948089898, "Lcom/baidu/tieba/qf4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948089898, "Lcom/baidu/tieba/qf4;");
                return;
            }
        }
        SparseArray<of4> sparseArray = new SparseArray<>();
        a = sparseArray;
        sparseArray.put(5, new of4(5, R.string.obfuscated_res_0x7f0f0126, R.drawable.obfuscated_res_0x7f08010f, true));
        a.put(35, new of4(35, R.string.obfuscated_res_0x7f0f0119, R.drawable.obfuscated_res_0x7f0800ef, true));
        a.put(39, new of4(39, R.string.obfuscated_res_0x7f0f0120, R.drawable.obfuscated_res_0x7f080112, true));
        a.put(4, new of4(4, R.string.obfuscated_res_0x7f0f0127, R.drawable.obfuscated_res_0x7f080115, true));
        a.put(37, new of4(37, R.string.obfuscated_res_0x7f0f011b, R.drawable.obfuscated_res_0x7f0800f2, true));
        a.put(38, new of4(38, R.string.obfuscated_res_0x7f0f0124, R.drawable.obfuscated_res_0x7f0800ee, true));
        a.put(42, new of4(42, R.string.obfuscated_res_0x7f0f011c, R.drawable.obfuscated_res_0x7f080112, true));
        a.put(49, new of4(49, R.string.obfuscated_res_0x7f0f1424, R.drawable.obfuscated_res_0x7f081388, true));
        a.put(50, new of4(50, R.string.obfuscated_res_0x7f0f14a8, R.drawable.obfuscated_res_0x7f081387, true));
        a.put(43, new of4(43, R.string.obfuscated_res_0x7f0f011a, R.drawable.obfuscated_res_0x7f0800f3, true));
        a.put(9, new of4(9, R.string.obfuscated_res_0x7f0f0125, R.drawable.obfuscated_res_0x7f0800ff, true));
        a.put(46, new of4(46, R.string.obfuscated_res_0x7f0f011d, R.drawable.obfuscated_res_0x7f080104, true));
        a.put(47, new of4(47, R.string.obfuscated_res_0x7f0f011e, R.drawable.obfuscated_res_0x7f080107, true));
    }

    public static of4 a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) {
            return of4.k(a.get(i));
        }
        return (of4) invokeI.objValue;
    }

    public static List<of4> b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            ArrayList arrayList = new ArrayList();
            if (i != 0) {
                if (i != 12) {
                    if (i != 13) {
                        switch (i) {
                            case 16:
                                arrayList.add(of4.k(a.get(5)));
                                break;
                            case 17:
                            case 18:
                                arrayList.add(of4.k(a.get(38)));
                                arrayList.add(of4.k(a.get(4)));
                                arrayList.add(of4.k(a.get(39)));
                                arrayList.add(of4.k(a.get(35)));
                                arrayList.add(of4.k(a.get(5)));
                                arrayList.add(of4.k(a.get(49)));
                                break;
                            case 19:
                                arrayList.add(of4.l(a.get(38), false));
                                arrayList.add(of4.l(a.get(4), false));
                                arrayList.add(of4.k(a.get(39)));
                                arrayList.add(of4.l(a.get(35), false));
                                arrayList.add(of4.k(a.get(5)));
                                arrayList.add(of4.l(a.get(49), false));
                                break;
                            case 20:
                                arrayList.add(of4.k(a.get(38)));
                                arrayList.add(of4.k(a.get(4)));
                                arrayList.add(of4.k(a.get(39)));
                                arrayList.add(of4.k(a.get(35)));
                                arrayList.add(of4.k(a.get(5)));
                                arrayList.add(of4.k(a.get(49)));
                                break;
                        }
                    } else {
                        arrayList.add(of4.k(a.get(43)));
                    }
                }
                arrayList.add(of4.k(a.get(38)));
                arrayList.add(of4.k(a.get(4)));
                arrayList.add(of4.k(a.get(39)));
                arrayList.add(of4.k(a.get(35)));
                arrayList.add(of4.k(a.get(5)));
                arrayList.add(of4.k(a.get(49)));
            } else {
                arrayList.add(of4.k(a.get(38)));
                arrayList.add(of4.k(a.get(5)));
                arrayList.add(of4.k(a.get(4)));
                arrayList.add(of4.k(a.get(35)));
                arrayList.add(of4.k(a.get(42)));
            }
            return arrayList;
        }
        return (List) invokeI.objValue;
    }
}

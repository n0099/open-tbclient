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
public class rh4 {
    public static /* synthetic */ Interceptable $ic;
    public static SparseArray<ph4> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948121611, "Lcom/baidu/tieba/rh4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948121611, "Lcom/baidu/tieba/rh4;");
                return;
            }
        }
        SparseArray<ph4> sparseArray = new SparseArray<>();
        a = sparseArray;
        sparseArray.put(5, new ph4(5, R.string.obfuscated_res_0x7f0f0129, R.drawable.obfuscated_res_0x7f080110, true));
        a.put(35, new ph4(35, R.string.obfuscated_res_0x7f0f011c, R.drawable.obfuscated_res_0x7f0800f0, true));
        a.put(39, new ph4(39, R.string.obfuscated_res_0x7f0f0123, R.drawable.obfuscated_res_0x7f080113, true));
        a.put(4, new ph4(4, R.string.obfuscated_res_0x7f0f012a, R.drawable.obfuscated_res_0x7f080116, true));
        a.put(37, new ph4(37, R.string.obfuscated_res_0x7f0f011e, R.drawable.obfuscated_res_0x7f0800f3, true));
        a.put(38, new ph4(38, R.string.obfuscated_res_0x7f0f0127, R.drawable.obfuscated_res_0x7f0800ef, true));
        a.put(42, new ph4(42, R.string.obfuscated_res_0x7f0f011f, R.drawable.obfuscated_res_0x7f080113, true));
        a.put(49, new ph4(49, R.string.obfuscated_res_0x7f0f14d8, R.drawable.obfuscated_res_0x7f081447, true));
        a.put(50, new ph4(50, R.string.obfuscated_res_0x7f0f155c, R.drawable.obfuscated_res_0x7f081446, true));
        a.put(43, new ph4(43, R.string.obfuscated_res_0x7f0f011d, R.drawable.obfuscated_res_0x7f0800f4, true));
        a.put(9, new ph4(9, R.string.obfuscated_res_0x7f0f0128, R.drawable.obfuscated_res_0x7f080100, true));
        a.put(46, new ph4(46, R.string.obfuscated_res_0x7f0f0120, R.drawable.obfuscated_res_0x7f080105, true));
        a.put(47, new ph4(47, R.string.obfuscated_res_0x7f0f0121, R.drawable.obfuscated_res_0x7f080108, true));
    }

    public static ph4 a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) {
            return ph4.k(a.get(i));
        }
        return (ph4) invokeI.objValue;
    }

    public static List<ph4> b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            ArrayList arrayList = new ArrayList();
            if (i != 0) {
                if (i != 12) {
                    if (i != 13) {
                        switch (i) {
                            case 16:
                                arrayList.add(ph4.k(a.get(5)));
                                break;
                            case 17:
                            case 18:
                                arrayList.add(ph4.k(a.get(38)));
                                arrayList.add(ph4.k(a.get(4)));
                                arrayList.add(ph4.k(a.get(39)));
                                arrayList.add(ph4.k(a.get(35)));
                                arrayList.add(ph4.k(a.get(5)));
                                arrayList.add(ph4.k(a.get(49)));
                                break;
                            case 19:
                                arrayList.add(ph4.l(a.get(38), false));
                                arrayList.add(ph4.l(a.get(4), false));
                                arrayList.add(ph4.k(a.get(39)));
                                arrayList.add(ph4.l(a.get(35), false));
                                arrayList.add(ph4.k(a.get(5)));
                                arrayList.add(ph4.l(a.get(49), false));
                                break;
                            case 20:
                                arrayList.add(ph4.k(a.get(38)));
                                arrayList.add(ph4.k(a.get(4)));
                                arrayList.add(ph4.k(a.get(39)));
                                arrayList.add(ph4.k(a.get(35)));
                                arrayList.add(ph4.k(a.get(5)));
                                arrayList.add(ph4.k(a.get(49)));
                                break;
                        }
                    } else {
                        arrayList.add(ph4.k(a.get(43)));
                    }
                }
                arrayList.add(ph4.k(a.get(38)));
                arrayList.add(ph4.k(a.get(4)));
                arrayList.add(ph4.k(a.get(39)));
                arrayList.add(ph4.k(a.get(35)));
                arrayList.add(ph4.k(a.get(5)));
                arrayList.add(ph4.k(a.get(49)));
            } else {
                arrayList.add(ph4.k(a.get(38)));
                arrayList.add(ph4.k(a.get(5)));
                arrayList.add(ph4.k(a.get(4)));
                arrayList.add(ph4.k(a.get(35)));
                arrayList.add(ph4.k(a.get(42)));
            }
            return arrayList;
        }
        return (List) invokeI.objValue;
    }
}

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
public class oa4 {
    public static /* synthetic */ Interceptable $ic;
    public static SparseArray<ma4> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948025511, "Lcom/baidu/tieba/oa4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948025511, "Lcom/baidu/tieba/oa4;");
                return;
            }
        }
        SparseArray<ma4> sparseArray = new SparseArray<>();
        a = sparseArray;
        sparseArray.put(5, new ma4(5, R.string.obfuscated_res_0x7f0f00ff, R.drawable.obfuscated_res_0x7f0800f5, true));
        a.put(35, new ma4(35, R.string.obfuscated_res_0x7f0f00f2, R.drawable.obfuscated_res_0x7f0800d5, true));
        a.put(39, new ma4(39, R.string.obfuscated_res_0x7f0f00f9, R.drawable.obfuscated_res_0x7f0800f8, true));
        a.put(4, new ma4(4, R.string.obfuscated_res_0x7f0f0100, R.drawable.obfuscated_res_0x7f0800fb, true));
        a.put(37, new ma4(37, R.string.obfuscated_res_0x7f0f00f4, R.drawable.obfuscated_res_0x7f0800d8, true));
        a.put(38, new ma4(38, R.string.obfuscated_res_0x7f0f00fd, R.drawable.obfuscated_res_0x7f0800d4, true));
        a.put(42, new ma4(42, R.string.obfuscated_res_0x7f0f00f5, R.drawable.obfuscated_res_0x7f0800f8, true));
        a.put(49, new ma4(49, R.string.obfuscated_res_0x7f0f12de, R.drawable.obfuscated_res_0x7f0811bf, true));
        a.put(50, new ma4(50, R.string.obfuscated_res_0x7f0f1362, R.drawable.obfuscated_res_0x7f0811be, true));
        a.put(43, new ma4(43, R.string.obfuscated_res_0x7f0f00f3, R.drawable.obfuscated_res_0x7f0800d9, true));
        a.put(9, new ma4(9, R.string.obfuscated_res_0x7f0f00fe, R.drawable.obfuscated_res_0x7f0800e5, true));
        a.put(46, new ma4(46, R.string.obfuscated_res_0x7f0f00f6, R.drawable.obfuscated_res_0x7f0800ea, true));
        a.put(47, new ma4(47, R.string.obfuscated_res_0x7f0f00f7, R.drawable.obfuscated_res_0x7f0800ed, true));
    }

    public static ma4 a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) {
            return ma4.k(a.get(i));
        }
        return (ma4) invokeI.objValue;
    }

    public static List<ma4> b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            ArrayList arrayList = new ArrayList();
            if (i != 0) {
                if (i != 12) {
                    if (i != 13) {
                        switch (i) {
                            case 16:
                                arrayList.add(ma4.k(a.get(5)));
                                break;
                            case 17:
                            case 18:
                                arrayList.add(ma4.k(a.get(38)));
                                arrayList.add(ma4.k(a.get(4)));
                                arrayList.add(ma4.k(a.get(39)));
                                arrayList.add(ma4.k(a.get(35)));
                                arrayList.add(ma4.k(a.get(5)));
                                arrayList.add(ma4.k(a.get(49)));
                                break;
                            case 19:
                                arrayList.add(ma4.l(a.get(38), false));
                                arrayList.add(ma4.l(a.get(4), false));
                                arrayList.add(ma4.k(a.get(39)));
                                arrayList.add(ma4.l(a.get(35), false));
                                arrayList.add(ma4.k(a.get(5)));
                                arrayList.add(ma4.l(a.get(49), false));
                                break;
                            case 20:
                                arrayList.add(ma4.k(a.get(38)));
                                arrayList.add(ma4.k(a.get(4)));
                                arrayList.add(ma4.k(a.get(39)));
                                arrayList.add(ma4.k(a.get(35)));
                                arrayList.add(ma4.k(a.get(5)));
                                arrayList.add(ma4.k(a.get(49)));
                                break;
                        }
                    } else {
                        arrayList.add(ma4.k(a.get(43)));
                    }
                }
                arrayList.add(ma4.k(a.get(38)));
                arrayList.add(ma4.k(a.get(4)));
                arrayList.add(ma4.k(a.get(39)));
                arrayList.add(ma4.k(a.get(35)));
                arrayList.add(ma4.k(a.get(5)));
                arrayList.add(ma4.k(a.get(49)));
            } else {
                arrayList.add(ma4.k(a.get(38)));
                arrayList.add(ma4.k(a.get(5)));
                arrayList.add(ma4.k(a.get(4)));
                arrayList.add(ma4.k(a.get(35)));
                arrayList.add(ma4.k(a.get(42)));
            }
            return arrayList;
        }
        return (List) invokeI.objValue;
    }
}

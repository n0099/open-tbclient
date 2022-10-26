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
public class w94 {
    public static /* synthetic */ Interceptable $ic;
    public static SparseArray a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948225399, "Lcom/baidu/tieba/w94;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948225399, "Lcom/baidu/tieba/w94;");
                return;
            }
        }
        SparseArray sparseArray = new SparseArray();
        a = sparseArray;
        sparseArray.put(5, new u94(5, R.string.obfuscated_res_0x7f0f00fc, R.drawable.obfuscated_res_0x7f0800f5, true));
        a.put(35, new u94(35, R.string.obfuscated_res_0x7f0f00ef, R.drawable.obfuscated_res_0x7f0800d5, true));
        a.put(39, new u94(39, R.string.obfuscated_res_0x7f0f00f6, R.drawable.obfuscated_res_0x7f0800f8, true));
        a.put(4, new u94(4, R.string.obfuscated_res_0x7f0f00fd, R.drawable.obfuscated_res_0x7f0800fb, true));
        a.put(37, new u94(37, R.string.obfuscated_res_0x7f0f00f1, R.drawable.obfuscated_res_0x7f0800d8, true));
        a.put(38, new u94(38, R.string.obfuscated_res_0x7f0f00fa, R.drawable.obfuscated_res_0x7f0800d4, true));
        a.put(42, new u94(42, R.string.obfuscated_res_0x7f0f00f2, R.drawable.obfuscated_res_0x7f0800f8, true));
        a.put(49, new u94(49, R.string.obfuscated_res_0x7f0f127f, R.drawable.obfuscated_res_0x7f081169, true));
        a.put(50, new u94(50, R.string.obfuscated_res_0x7f0f1303, R.drawable.obfuscated_res_0x7f081168, true));
        a.put(43, new u94(43, R.string.obfuscated_res_0x7f0f00f0, R.drawable.obfuscated_res_0x7f0800d9, true));
        a.put(9, new u94(9, R.string.obfuscated_res_0x7f0f00fb, R.drawable.obfuscated_res_0x7f0800e5, true));
        a.put(46, new u94(46, R.string.obfuscated_res_0x7f0f00f3, R.drawable.obfuscated_res_0x7f0800ea, true));
        a.put(47, new u94(47, R.string.obfuscated_res_0x7f0f00f4, R.drawable.obfuscated_res_0x7f0800ed, true));
    }

    public static u94 a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) {
            return u94.k((u94) a.get(i));
        }
        return (u94) invokeI.objValue;
    }

    public static List b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            ArrayList arrayList = new ArrayList();
            if (i != 0) {
                if (i != 12) {
                    if (i != 13) {
                        switch (i) {
                            case 16:
                                arrayList.add(u94.k((u94) a.get(5)));
                                break;
                            case 17:
                            case 18:
                                arrayList.add(u94.k((u94) a.get(38)));
                                arrayList.add(u94.k((u94) a.get(4)));
                                arrayList.add(u94.k((u94) a.get(39)));
                                arrayList.add(u94.k((u94) a.get(35)));
                                arrayList.add(u94.k((u94) a.get(5)));
                                arrayList.add(u94.k((u94) a.get(49)));
                                break;
                            case 19:
                                arrayList.add(u94.l((u94) a.get(38), false));
                                arrayList.add(u94.l((u94) a.get(4), false));
                                arrayList.add(u94.k((u94) a.get(39)));
                                arrayList.add(u94.l((u94) a.get(35), false));
                                arrayList.add(u94.k((u94) a.get(5)));
                                arrayList.add(u94.l((u94) a.get(49), false));
                                break;
                            case 20:
                                arrayList.add(u94.k((u94) a.get(38)));
                                arrayList.add(u94.k((u94) a.get(4)));
                                arrayList.add(u94.k((u94) a.get(39)));
                                arrayList.add(u94.k((u94) a.get(35)));
                                arrayList.add(u94.k((u94) a.get(5)));
                                arrayList.add(u94.k((u94) a.get(49)));
                                break;
                        }
                    } else {
                        arrayList.add(u94.k((u94) a.get(43)));
                    }
                }
                arrayList.add(u94.k((u94) a.get(38)));
                arrayList.add(u94.k((u94) a.get(4)));
                arrayList.add(u94.k((u94) a.get(39)));
                arrayList.add(u94.k((u94) a.get(35)));
                arrayList.add(u94.k((u94) a.get(5)));
                arrayList.add(u94.k((u94) a.get(49)));
            } else {
                arrayList.add(u94.k((u94) a.get(38)));
                arrayList.add(u94.k((u94) a.get(5)));
                arrayList.add(u94.k((u94) a.get(4)));
                arrayList.add(u94.k((u94) a.get(35)));
                arrayList.add(u94.k((u94) a.get(42)));
            }
            return arrayList;
        }
        return (List) invokeI.objValue;
    }
}

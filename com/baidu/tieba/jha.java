package com.baidu.tieba;

import android.util.Pair;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.LinkedList;
/* loaded from: classes5.dex */
public class jha {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, String str2, LinkedList<Pair<String, Object>> linkedList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65536, null, str, str2, linkedList) == null) && kha.c().g() != null) {
            kha.c().g().b(54, null, null, null, null, null, str, null, str2, null, linkedList);
        }
    }
}

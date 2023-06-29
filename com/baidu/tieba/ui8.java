package com.baidu.tieba;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class ui8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static uj8 a(Context context, RecyclerView recyclerView, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65536, null, context, recyclerView, i)) == null) {
            return new uj8(context, recyclerView, new si8(), new ti8(), i, 1);
        }
        return (uj8) invokeLLI.objValue;
    }

    public static uj8 b(Context context, RecyclerView recyclerView, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65537, null, context, recyclerView, i)) == null) {
            return new uj8(context, recyclerView, new si8(), new ti8(), i, 2);
        }
        return (uj8) invokeLLI.objValue;
    }

    public static tj8 c(Context context, RecyclerView recyclerView, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65538, null, context, recyclerView, i)) == null) {
            return new tj8(context, recyclerView, new si8(), new ti8(), i, 1);
        }
        return (tj8) invokeLLI.objValue;
    }
}

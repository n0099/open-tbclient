package com.baidu.tieba;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class io8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static kp8 a(Context context, RecyclerView recyclerView, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65536, null, context, recyclerView, i)) == null) {
            return new kp8(context, recyclerView, new fo8(), new go8(), i, 1);
        }
        return (kp8) invokeLLI.objValue;
    }

    public static kp8 b(Context context, RecyclerView recyclerView, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65537, null, context, recyclerView, i)) == null) {
            return new kp8(context, recyclerView, new fo8(), new go8(), i, 2);
        }
        return (kp8) invokeLLI.objValue;
    }

    public static jp8 c(Context context, RecyclerView recyclerView, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65538, null, context, recyclerView, i)) == null) {
            return new jp8(context, recyclerView, new fo8(), new go8(), i, 1);
        }
        return (jp8) invokeLLI.objValue;
    }
}

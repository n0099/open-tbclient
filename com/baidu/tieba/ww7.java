package com.baidu.tieba;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ww7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static rx7 a(Context context, RecyclerView recyclerView, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65536, null, context, recyclerView, i)) == null) {
            return new rx7(context, recyclerView, new uw7(), new vw7(), i, 1);
        }
        return (rx7) invokeLLI.objValue;
    }

    public static rx7 b(Context context, RecyclerView recyclerView, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65537, null, context, recyclerView, i)) == null) {
            return new rx7(context, recyclerView, new uw7(), new vw7(), i, 2);
        }
        return (rx7) invokeLLI.objValue;
    }

    public static qx7 c(Context context, RecyclerView recyclerView, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65538, null, context, recyclerView, i)) == null) {
            return new qx7(context, recyclerView, new uw7(), new vw7(), i, 1);
        }
        return (qx7) invokeLLI.objValue;
    }
}

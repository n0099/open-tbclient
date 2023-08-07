package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes8.dex */
public class u48 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(int i, @NonNull List<ym> list, @NonNull String str) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65536, null, i, list, str)) == null) {
            if (!ListUtils.isEmpty(list) && i >= 0 && i < list.size()) {
                while (i < list.size()) {
                    i++;
                    if (i >= list.size()) {
                        return list.size();
                    }
                    if (list.get(i) instanceof jn6) {
                        jn6 jn6Var = (jn6) list.get(i);
                        if (jn6Var.getThreadData() == null || (!TextUtils.isEmpty(jn6Var.getThreadData().getTid()) && str.equals(jn6Var.getThreadData().getTid()))) {
                        }
                    }
                    return i;
                }
            }
            return -1;
        }
        return invokeILL.intValue;
    }
}

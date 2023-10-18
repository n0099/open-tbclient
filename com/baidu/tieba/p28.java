package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes7.dex */
public class p28 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(int i, @NonNull List<yh> list, @NonNull String str) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65536, null, i, list, str)) == null) {
            if (!ListUtils.isEmpty(list) && i >= 0 && i < list.size()) {
                while (i < list.size()) {
                    i++;
                    if (i >= list.size()) {
                        return list.size();
                    }
                    if (list.get(i) instanceof jk6) {
                        jk6 jk6Var = (jk6) list.get(i);
                        if (jk6Var.getThreadData() == null || (!TextUtils.isEmpty(jk6Var.getThreadData().getTid()) && str.equals(jk6Var.getThreadData().getTid()))) {
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

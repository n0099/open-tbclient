package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes8.dex */
public class vi9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeL;
        List<ym> data;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bdTypeRecyclerView)) == null) {
            if (bdTypeRecyclerView != null && (data = bdTypeRecyclerView.getData()) != null && data.size() > 0) {
                for (int i = 0; i < data.size(); i++) {
                    ym ymVar = data.get(i);
                    if ((ymVar instanceof rba) && ymVar.getType() == rba.W0) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static int b(BdTypeRecyclerView bdTypeRecyclerView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, bdTypeRecyclerView, str)) == null) {
            if (bdTypeRecyclerView != null && !TextUtils.isEmpty(str)) {
                List<ym> data = bdTypeRecyclerView.getData();
                int headerViewsCount = bdTypeRecyclerView.getHeaderViewsCount();
                if (data != null && data.size() > 0) {
                    int size = data.size();
                    for (int i = 0; i < size; i++) {
                        ym ymVar = data.get(i);
                        if ((ymVar instanceof rba) && ymVar.getType() == rba.W0 && str.equals(((rba) ymVar).S())) {
                            return i + headerViewsCount;
                        }
                    }
                }
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    public static void c(BdTypeRecyclerView bdTypeRecyclerView, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65538, null, bdTypeRecyclerView, str) != null) || bdTypeRecyclerView == null) {
            return;
        }
        int b = b(bdTypeRecyclerView, str);
        if (bdTypeRecyclerView.getLayoutManager() != null) {
            bdTypeRecyclerView.getLayoutManager().scrollToPosition(b);
        }
    }
}

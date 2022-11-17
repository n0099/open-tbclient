package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class rl5 implements sl5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.sl5
    public int b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            if (i < 4) {
                return 1;
            }
            return (i < 4 || i >= 7) ? 3 : 2;
        }
        return invokeI.intValue;
    }

    public rl5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.sl5
    public int a(ConstrainImageLayout constrainImageLayout, List<MediaData> list, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048576, this, constrainImageLayout, list, i, i2)) == null) {
            if (ListUtils.getCount(list) <= 0) {
                return i2;
            }
            if (i == 0) {
                return e(constrainImageLayout, list, i2);
            }
            if (i == 1) {
                return d(constrainImageLayout, list, i2);
            }
            if (i == 2) {
                return c(constrainImageLayout, list, i2);
            }
            return i2;
        }
        return invokeLLII.intValue;
    }

    public final int c(ConstrainImageLayout constrainImageLayout, List<MediaData> list, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, constrainImageLayout, list, i)) == null) {
            if (constrainImageLayout != null && !ListUtils.isEmpty(list)) {
                int count = ListUtils.getCount(list);
                constrainImageLayout.setImageMaxChildCount(3);
                int i2 = count - 9;
                if (i2 > 0) {
                    int i3 = i + 3;
                    List<MediaData> subList = ListUtils.subList(list, i, i3);
                    constrainImageLayout.setExtraCenterText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f044d, new Object[]{Integer.valueOf(i2)}));
                    constrainImageLayout.setUrls(subList, i, true);
                    return i3;
                }
                constrainImageLayout.setUrls(ListUtils.subList(list, i, count), i);
                constrainImageLayout.setExtraCenterText(null);
                return count;
            }
            return i;
        }
        return invokeLLI.intValue;
    }

    public final int d(ConstrainImageLayout constrainImageLayout, List<MediaData> list, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048579, this, constrainImageLayout, list, i)) == null) {
            if (constrainImageLayout != null && !ListUtils.isEmpty(list)) {
                if (ListUtils.getCount(list) == 4) {
                    int i2 = i + 2;
                    constrainImageLayout.setUrls(ListUtils.subList(list, i, i2), i);
                    return i2;
                }
                int i3 = i + 3;
                constrainImageLayout.setUrls(ListUtils.subList(list, i, i3), i);
                return i3;
            }
            return i;
        }
        return invokeLLI.intValue;
    }

    public final int e(ConstrainImageLayout constrainImageLayout, List<MediaData> list, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, constrainImageLayout, list, i)) == null) {
            if (constrainImageLayout != null && !ListUtils.isEmpty(list)) {
                int count = ListUtils.getCount(list);
                if (count == 1) {
                    constrainImageLayout.setUrls(list, i);
                    return 0;
                } else if (count != 2 && count != 4 && count != 5) {
                    int i2 = i + 3;
                    constrainImageLayout.setUrls(ListUtils.subList(list, i, i2), i);
                    return i2;
                } else {
                    int i3 = i + 2;
                    constrainImageLayout.setUrls(ListUtils.subList(list, i, i3), i);
                    return i3;
                }
            }
            return i;
        }
        return invokeLLI.intValue;
    }
}

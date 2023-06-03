package com.baidu.tieba;

import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.frs.accelerator.PkgNameAndNodeInfoData;
import com.baidu.tieba.frs.accelerator.TornadoNodeInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class jf7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Map<Integer, PkgNameAndNodeInfoData> a(List<TornadoNodeInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            if (!ListUtils.isEmpty(list)) {
                HashMap hashMap = new HashMap();
                int i = 0;
                for (int i2 = 0; i2 < list.size(); i2++) {
                    for (int i3 = 0; i3 < list.get(i2).getNodeInfoList().size(); i3++) {
                        hashMap.put(Integer.valueOf(i), new PkgNameAndNodeInfoData(list.get(i2).getPackageName(), list.get(i2).getNodeInfoList().get(i3), list.get(i2).getGameId()));
                        i++;
                    }
                }
                return hashMap;
            }
            return null;
        }
        return (Map) invokeL.objValue;
    }

    public static String[] b(List<TornadoNodeInfo> list, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, list, i)) == null) {
            if (!ListUtils.isEmpty(list) && i > 0) {
                String[] strArr = new String[i];
                int i2 = 0;
                for (int i3 = 0; i3 < list.size(); i3++) {
                    for (int i4 = 0; i4 < list.get(i3).getNodeInfoList().size(); i4++) {
                        strArr[i2] = list.get(i3).getNodeInfoList().get(i4).getNodeName();
                        i2++;
                    }
                }
                return strArr;
            }
            return null;
        }
        return (String[]) invokeLI.objValue;
    }
}

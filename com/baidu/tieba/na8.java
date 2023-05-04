package com.baidu.tieba;

import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class na8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, imMessageCenterShowItemData)) == null) {
            if (imMessageCenterShowItemData == null) {
                return false;
            }
            if (!String.valueOf(4).equals(imMessageCenterShowItemData.getOwnerName()) && !"".equals(imMessageCenterShowItemData.getOwnerName())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean b(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, imMessageCenterShowItemData)) == null) {
            if (imMessageCenterShowItemData == null) {
                return false;
            }
            return String.valueOf(9).equals(imMessageCenterShowItemData.getOwnerName());
        }
        return invokeL.booleanValue;
    }

    public static boolean c(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, imMessageCenterShowItemData)) == null) {
            if (imMessageCenterShowItemData == null || !String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName()) || "3222425470".equals(imMessageCenterShowItemData.getFriendId()) || "801001117".equals(imMessageCenterShowItemData.getFriendId()) || "5044059141".equals(imMessageCenterShowItemData.getFriendId())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}

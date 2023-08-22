package com.baidu.tieba;

import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public final class uu7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return SharedPrefHelper.getInstance().getString(SharedPrefHelper.getSharedPrefKeyWithAccount("forum_group_entrance_guide_has_show_array"), "");
        }
        return (String) invokeV.objValue;
    }

    public static final String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return SharedPrefHelper.getInstance().getString(SharedPrefHelper.getSharedPrefKeyWithAccount("forum_group_feed_card_has_show_array"), "");
        }
        return (String) invokeV.objValue;
    }

    public static final int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return SharedPrefHelper.getInstance().getInt(SharedPrefHelper.getSharedPrefKeyWithAccount("forum_group_entrance_guide_frequency"), 0);
        }
        return invokeV.intValue;
    }

    public static final int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return SharedPrefHelper.getInstance().getInt(SharedPrefHelper.getSharedPrefKeyWithAccount("forum_group_feed_card_frequency"), 0);
        }
        return invokeV.intValue;
    }

    public static final void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, str) == null) {
            SharedPrefHelper.getInstance().putString(SharedPrefHelper.getSharedPrefKeyWithAccount("forum_group_entrance_guide_has_show_array"), str);
        }
    }

    public static final void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, str) == null) {
            SharedPrefHelper.getInstance().putString(SharedPrefHelper.getSharedPrefKeyWithAccount("forum_group_feed_card_has_show_array"), str);
        }
    }
}

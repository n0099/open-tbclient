package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class t28 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static String a(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) ? str == null ? "" : str : (String) invokeL.objValue;
    }

    public static void b(@NonNull String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65537, null, str, str2, str3, str4, str5) == null) {
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.addParam("fid", a(str2));
            statisticItem.addParam("fname", a(str3));
            statisticItem.addParam("jumpfid", a(str4));
            statisticItem.addParam("jumpfname", a(str5));
            TiebaStatic.log(statisticItem);
        }
    }

    public static void c(@NonNull String str, @Nullable String str2, @Nullable String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, str, str2, str3) == null) {
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.addParam("fid", a(str2));
            statisticItem.addParam("fname", a(str3));
            TiebaStatic.log(statisticItem);
        }
    }
}

package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.data.ShareIMCommonCardData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class xb8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull ShareIMCommonCardData shareIMCommonCardData, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65536, null, shareIMCommonCardData, i) == null) {
            if (ShareIMCommonCardData.isValidTopic(shareIMCommonCardData)) {
                c(shareIMCommonCardData, i);
            } else if (ShareIMCommonCardData.isValidAlbum(shareIMCommonCardData)) {
                b(shareIMCommonCardData, i);
            }
        }
    }

    public static void b(@NonNull ShareIMCommonCardData shareIMCommonCardData, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(65537, null, shareIMCommonCardData, i) != null) || !ShareIMCommonCardData.isValidAlbum(shareIMCommonCardData)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_ALBUM_SHARE_TYPE);
        statisticItem.addParam("obj_type", i);
        TiebaStatic.log(statisticItem);
    }

    public static void c(@NonNull ShareIMCommonCardData shareIMCommonCardData, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(65538, null, shareIMCommonCardData, i) != null) || !ShareIMCommonCardData.isValidTopic(shareIMCommonCardData)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_TOPIC_SHARE_TYPE);
        statisticItem.addParam("obj_type", i);
        TiebaStatic.log(statisticItem);
    }
}

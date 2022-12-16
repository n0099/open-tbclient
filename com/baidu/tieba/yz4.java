package com.baidu.tieba;

import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.itemcard.ItemCardHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
@JvmName(name = "ItemTabLogUtil")
/* loaded from: classes7.dex */
public final class yz4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final int a(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65536, null, i, i2)) == null) {
            if (i != 1) {
                return i != 2 ? -1 : 2;
            } else if (i2 != 1) {
                return i2 != 2 ? -1 : 3;
            } else {
                return 4;
            }
        }
        return invokeII.intValue;
    }

    public static final int b(String name) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, name)) == null) {
            Intrinsics.checkNotNullParameter(name, "name");
            if (Intrinsics.areEqual(ItemCardHelper.a, name)) {
                return 1;
            }
            if (Intrinsics.areEqual(ItemCardHelper.b, name)) {
                return 2;
            }
            return 9;
        }
        return invokeL.intValue;
    }

    public static final void c(xz4 itemLogData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, itemLogData) == null) {
            Intrinsics.checkNotNullParameter(itemLogData, "itemLogData");
            StatisticItem statisticItem = new StatisticItem();
            boolean z = false;
            switch (itemLogData.getType()) {
                case 1:
                    statisticItem.key(CommonStatisticKey.KEY_FRS_ITEM_TAB_ALBUM_CLICK).param("obj_name", itemLogData.b()).param("obj_locate", itemLogData.c()).param("obj_type", itemLogData.g()).param("fid", itemLogData.a()).param("uid", itemLogData.i());
                    break;
                case 2:
                    statisticItem.key(CommonStatisticKey.KEY_FRS_ITEM_TAB_TAG_CLICK).param("obj_name", itemLogData.b()).param("obj_locate", itemLogData.c()).param("fid", itemLogData.a());
                    break;
                case 3:
                    statisticItem.key(CommonStatisticKey.KEY_FRS_ITEM_TAB_RECOMMEND_CLICK).param("obj_name", itemLogData.b()).param("obj_locate", itemLogData.c()).param("obj_type", itemLogData.g()).param("fid", itemLogData.a());
                    break;
                case 4:
                    statisticItem.key(CommonStatisticKey.KEY_FRS_ITEM_TAB_COMMENT_CLICK).param("obj_name", itemLogData.b()).param("obj_locate", itemLogData.c()).param("obj_type", itemLogData.g()).param("fid", itemLogData.a());
                    break;
                case 5:
                    statisticItem.key(CommonStatisticKey.KEY_FRS_ITEM_TAB_SHOW).param("obj_name", itemLogData.b()).param("obj_source", itemLogData.f()).param("obj_locate", itemLogData.a());
                    break;
                case 6:
                    statisticItem.key(CommonStatisticKey.KEY_FRS_ITEM_TAB_RANKING).param("obj_name", itemLogData.b()).param("obj_type", itemLogData.g()).param("fid", itemLogData.a());
                    break;
                case 7:
                    statisticItem.key(CommonStatisticKey.KEY_FRS_ORDER_DOWNLOAD_EXPORT).param("obj_name", itemLogData.b()).param("obj_type", itemLogData.g()).param("fid", itemLogData.a()).param("uid", itemLogData.i());
                    break;
                case 8:
                    statisticItem.key(CommonStatisticKey.KEY_FRS_ORDER_DOWNLOAD_CLICK).param("obj_name", itemLogData.b()).param("obj_type", itemLogData.g()).param("fid", itemLogData.a()).param("uid", itemLogData.i()).param("obj_source", itemLogData.f());
                    String d = itemLogData.d();
                    if (!((d == null || d.length() == 0) ? true : true)) {
                        statisticItem.param("obj_locate", itemLogData.d());
                        break;
                    }
                    break;
                case 9:
                    statisticItem.key(CommonStatisticKey.KEY_ITEM_RECENT_UPDATE_SHOW).param("fid", itemLogData.a());
                    break;
                case 10:
                    statisticItem.key(CommonStatisticKey.KEY_ITEM_RECENT_UPDATE_CLICK).param("fid", itemLogData.a());
                    break;
                case 11:
                    statisticItem.key(CommonStatisticKey.KEY_ITEM_HOT_VIDEO_SHOW).param("fid", itemLogData.a()).param("obj_locate", itemLogData.c());
                    break;
                case 12:
                    statisticItem.key(CommonStatisticKey.KEY_ITEM_HOT_VIDEO_CLICK).param("fid", itemLogData.a()).param("obj_locate", itemLogData.c());
                    String h = itemLogData.h();
                    if (!((h == null || h.length() == 0) ? true : true)) {
                        statisticItem.param("post_id", itemLogData.h());
                        break;
                    }
                    break;
                case 13:
                    statisticItem.key(CommonStatisticKey.KEY_FRS_ITEM_GAME_CODE_SHOW).param("fid", itemLogData.a()).param("obj_id", itemLogData.b()).param("uid", itemLogData.i());
                    break;
                case 14:
                    statisticItem.key(CommonStatisticKey.KEY_FRS_ITEM_GAME_CODE_CLICK).param("fid", itemLogData.a()).param("obj_id", itemLogData.b()).param("uid", itemLogData.i());
                    break;
                case 15:
                    statisticItem.key(CommonStatisticKey.KEY_FRS_ITEM_GAME_CODE_FLOATING_LAYER_SHOW).param("obj_id", itemLogData.b()).param("fid", itemLogData.a()).param("obj_locate", itemLogData.c()).param("uid", itemLogData.i());
                    break;
                case 16:
                    statisticItem.key(CommonStatisticKey.KEY_FRS_ITEM_GAME_CODE_FLOATING_LAYER_CLICK).param("obj_id", itemLogData.b()).param("fid", itemLogData.a()).param("obj_name", itemLogData.e()).param("obj_type", itemLogData.g());
                    break;
                case 17:
                    statisticItem.key(CommonStatisticKey.KEY_FRS_ITEM_ACCELERATOR_START_BTN_DESC_SHOW).param("fid", itemLogData.a()).param("uid", itemLogData.i()).param("obj_id", itemLogData.b());
                    break;
                case 18:
                    statisticItem.key(CommonStatisticKey.KEY_FRS_ITEM_ACCELERATOR_START_BTN_DESC_CLICK).param("fid", itemLogData.a()).param("uid", itemLogData.i()).param("obj_id", itemLogData.b());
                    break;
                case 19:
                    statisticItem.key(CommonStatisticKey.KEY_FRS_ITEM_ACCELERATOR_START_BTN_IMG_CLICK).param("fid", itemLogData.a()).param("uid", itemLogData.i()).param("obj_id", itemLogData.b());
                    break;
            }
            TiebaStatic.log(statisticItem);
        }
    }
}

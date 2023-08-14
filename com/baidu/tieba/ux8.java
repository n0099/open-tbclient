package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class ux8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65536, null, i)) == null) {
            switch (i) {
                case 1:
                    return R.drawable.icon_hand_normal_card_recommend;
                case 2:
                    return R.drawable.icon_comment_n;
                case 3:
                    return R.drawable.icon_home_yule;
                case 4:
                    return R.drawable.icon_see_n;
                case 5:
                    return R.drawable.icon_frs_ba_ticket;
                case 6:
                    return R.drawable.icon_frs_game;
                case 7:
                    return R.drawable.icon_frs_news;
                case 8:
                    return R.drawable.icon_new_live;
                case 9:
                    return R.drawable.icon_hottopic_new;
                case 10:
                    return R.drawable.icon_hottopic_hot;
                case 11:
                    return R.drawable.icon_hottopic_tuijian;
                case 12:
                    return R.drawable.icon_people_num;
                case 13:
                    return R.drawable.icon_time_start;
                case 14:
                    return R.drawable.lego_interview_notice_button_before_selector;
                case 15:
                    return R.drawable.lego_interview_notice_button_after_selector;
                default:
                    return 0;
            }
        }
        return invokeI.intValue;
    }
}

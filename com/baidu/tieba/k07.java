package com.baidu.tieba;

import android.view.View;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.FeedTabCardStatisticHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class k07 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(View view2, t15 t15Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65536, null, view2, t15Var, str) == null) && t15Var != null && t15Var.getThreadData() != null) {
            ThreadData threadData = t15Var.getThreadData();
            if (threadData.isVideoThreadType()) {
                TiebaStatic.log(FeedTabCardStatisticHelper.clickThreadVideoAreaStatisticLog(threadData, str));
                return;
            }
            int id = view2.getId();
            if (view2.getId() != R.id.thread_card_root && id != R.id.thread_info_commont_container) {
                if (id == R.id.user_avatar) {
                    TiebaStatic.log(FeedTabCardStatisticHelper.clickThreadPotraitStatisticLog(threadData, str));
                    return;
                } else if (id == R.id.user_name) {
                    TiebaStatic.log(FeedTabCardStatisticHelper.clickThreadPotraitStatisticLog(threadData, str));
                    return;
                } else if (id == R.id.forum_name_text) {
                    TiebaStatic.log(FeedTabCardStatisticHelper.clickThreadEnterForumStatisticLog(threadData, str));
                    return;
                } else if (id == R.id.thread_info_commont_container) {
                    TiebaStatic.log(FeedTabCardStatisticHelper.clickThreadTitleStatisticLog(threadData, str));
                    return;
                } else if (view2 instanceof TbImageView) {
                    TiebaStatic.log(FeedTabCardStatisticHelper.clickThreadBigPictureStatisticLog(threadData, str));
                    return;
                } else {
                    return;
                }
            }
            TiebaStatic.log(FeedTabCardStatisticHelper.clickThreadTitleStatisticLog(threadData, str));
        }
    }

    public static void b(t15 t15Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65537, null, t15Var, str) == null) && t15Var != null && t15Var.getThreadData() != null) {
            if (t15Var.getThreadData().isVideoThreadType()) {
                np6.b().a(FeedTabCardStatisticHelper.showVideoThreadStatisticLog(t15Var.getThreadData(), str));
            } else {
                np6.b().a(FeedTabCardStatisticHelper.showPictureTextThreadStatisticLog(t15Var.getThreadData(), str));
            }
        }
    }
}

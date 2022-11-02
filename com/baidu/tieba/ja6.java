package com.baidu.tieba;

import android.view.View;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.FeedTabCardStatisticHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class ja6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(View view2, rr4 rr4Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65536, null, view2, rr4Var, str) == null) && rr4Var != null && rr4Var.getThreadData() != null) {
            ThreadData threadData = rr4Var.getThreadData();
            if (threadData.isVideoThreadType()) {
                TiebaStatic.log(FeedTabCardStatisticHelper.clickThreadVideoAreaStatisticLog(threadData, str));
                return;
            }
            int id = view2.getId();
            if (view2.getId() != R.id.obfuscated_res_0x7f0921d0 && id != R.id.obfuscated_res_0x7f0921e4) {
                if (id == R.id.obfuscated_res_0x7f0924c8) {
                    TiebaStatic.log(FeedTabCardStatisticHelper.clickThreadPotraitStatisticLog(threadData, str));
                    return;
                } else if (id == R.id.obfuscated_res_0x7f0924f6) {
                    TiebaStatic.log(FeedTabCardStatisticHelper.clickThreadPotraitStatisticLog(threadData, str));
                    return;
                } else if (id == R.id.obfuscated_res_0x7f090aac) {
                    TiebaStatic.log(FeedTabCardStatisticHelper.clickThreadEnterForumStatisticLog(threadData, str));
                    return;
                } else if (id == R.id.obfuscated_res_0x7f0921e4) {
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

    public static void b(rr4 rr4Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65537, null, rr4Var, str) == null) && rr4Var != null && rr4Var.getThreadData() != null) {
            if (rr4Var.getThreadData().isVideoThreadType()) {
                s36.b().a(FeedTabCardStatisticHelper.showVideoThreadStatisticLog(rr4Var.getThreadData(), str));
            } else {
                s36.b().a(FeedTabCardStatisticHelper.showPictureTextThreadStatisticLog(rr4Var.getThreadData(), str));
            }
        }
    }
}

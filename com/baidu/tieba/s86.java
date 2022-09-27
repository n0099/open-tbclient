package com.baidu.tieba;

import android.view.View;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.FeedTabCardStatisticHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class s86 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(View view2, yq4 yq4Var, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65536, null, view2, yq4Var, str) == null) || yq4Var == null || yq4Var.getThreadData() == null) {
            return;
        }
        ThreadData threadData = yq4Var.getThreadData();
        if (threadData.isVideoThreadType()) {
            TiebaStatic.log(FeedTabCardStatisticHelper.clickThreadVideoAreaStatisticLog(threadData, str));
            return;
        }
        int id = view2.getId();
        if (view2.getId() == R.id.obfuscated_res_0x7f092180 || id == R.id.obfuscated_res_0x7f092194) {
            TiebaStatic.log(FeedTabCardStatisticHelper.clickThreadTitleStatisticLog(threadData, str));
        } else if (id == R.id.obfuscated_res_0x7f092488) {
            TiebaStatic.log(FeedTabCardStatisticHelper.clickThreadPotraitStatisticLog(threadData, str));
        } else if (id == R.id.obfuscated_res_0x7f0924b6) {
            TiebaStatic.log(FeedTabCardStatisticHelper.clickThreadPotraitStatisticLog(threadData, str));
        } else if (id == R.id.obfuscated_res_0x7f090a8f) {
            TiebaStatic.log(FeedTabCardStatisticHelper.clickThreadEnterForumStatisticLog(threadData, str));
        } else if (id == R.id.obfuscated_res_0x7f092194) {
            TiebaStatic.log(FeedTabCardStatisticHelper.clickThreadTitleStatisticLog(threadData, str));
        } else if (view2 instanceof TbImageView) {
            TiebaStatic.log(FeedTabCardStatisticHelper.clickThreadBigPictureStatisticLog(threadData, str));
        }
    }

    public static void b(yq4 yq4Var, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, yq4Var, str) == null) || yq4Var == null || yq4Var.getThreadData() == null) {
            return;
        }
        if (yq4Var.getThreadData().isVideoThreadType()) {
            b26.b().a(FeedTabCardStatisticHelper.showVideoThreadStatisticLog(yq4Var.getThreadData(), str));
        } else {
            b26.b().a(FeedTabCardStatisticHelper.showPictureTextThreadStatisticLog(yq4Var.getThreadData(), str));
        }
    }
}

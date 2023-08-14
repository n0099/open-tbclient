package com.baidu.tieba;

import android.graphics.Rect;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
@JvmName(name = "FestivalTipViewHelper")
/* loaded from: classes6.dex */
public final class lqa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(String str, String str2, TbRichTextView.Position position) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, str, str2, position) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FESTIVAL_TIP_VIEW_CLICK);
            boolean z2 = false;
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                statisticItem.addParam("tid", str);
            }
            if (!((str2 == null || str2.length() == 0) ? true : true)) {
                statisticItem.addParam("pid", str2);
            }
            if (position != null) {
                statisticItem.addParam("obj_locate", position.getIndex());
            }
            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.eventStat();
        }
    }

    public static final void b(rba postData, TbRichTextView richTextView, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65537, null, postData, richTextView, z) == null) {
            Intrinsics.checkNotNullParameter(postData, "postData");
            Intrinsics.checkNotNullParameter(richTextView, "richTextView");
            if (postData.E() != null) {
                if (z) {
                    richTextView.getLayoutStrategy().m(-1);
                } else {
                    richTextView.getLayoutStrategy().m(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X004));
                }
            }
        }
    }

    public static final void c(rba postData, TbRichTextView richTextView) {
        Rect rect;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, postData, richTextView) == null) {
            Intrinsics.checkNotNullParameter(postData, "postData");
            Intrinsics.checkNotNullParameter(richTextView, "richTextView");
            k06 layoutStrategy = richTextView.getLayoutStrategy();
            if (postData.E() != null) {
                rect = new Rect(-1, -1, -1, BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds53));
            } else {
                rect = null;
            }
            layoutStrategy.s(rect);
        }
    }
}

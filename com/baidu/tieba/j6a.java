package com.baidu.tieba;

import android.app.Activity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
@JvmName(name = "TopicListUtil")
/* loaded from: classes6.dex */
public final class j6a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @JvmOverloads
    public static final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            e(null, null, 3, null);
        }
    }

    @JvmOverloads
    public static final void c(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, tbPageContext) == null) {
            e(tbPageContext, null, 2, null);
        }
    }

    public static final void a(int i, String fid, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{Integer.valueOf(i), fid, Integer.valueOf(i2)}) == null) {
            Intrinsics.checkNotNullParameter(fid, "fid");
            TiebaStatic.log(new StatisticItem("c15112").param("obj_type", i).param("fid", fid).param("obj_locate", i2));
        }
    }

    @JvmOverloads
    public static final void d(TbPageContext<?> tbPageContext, String listType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, tbPageContext, listType) == null) {
            Intrinsics.checkNotNullParameter(listType, "listType");
            String str = "https://tieba.baidu.com/mo/q/hybrid/hotTopicRank?customfullscreen=1&nonavigationbar=1&list_type=" + listType;
            if (Intrinsics.areEqual("all", listType)) {
                str = str + "&page_key=a078";
            }
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity != null) {
                qx4.v(currentActivity, null, str, true);
            } else if (tbPageContext != null) {
                qx4.v(tbPageContext.getPageActivity(), null, str, true);
            }
        }
    }

    public static /* synthetic */ void e(TbPageContext tbPageContext, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            tbPageContext = null;
        }
        if ((i & 2) != 0) {
            str = "all";
        }
        d(tbPageContext, str);
    }
}

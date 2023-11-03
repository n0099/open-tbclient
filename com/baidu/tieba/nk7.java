package com.baidu.tieba;

import android.os.Bundle;
import com.baidu.tieba.forum.data.ForumTabItem;
import com.baidu.tieba.forum.statistic.ForumStatConstant$TabType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class nk7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final ForumStatConstant$TabType a(Bundle bundle) {
        InterceptResult invokeL;
        ForumStatConstant$TabType forumStatConstant$TabType;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bundle)) == null) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            ForumStatConstant$TabType forumStatConstant$TabType2 = ForumStatConstant$TabType.TAB_TYPE_UNKNOWN;
            ForumTabItem forumTabItem = (ForumTabItem) bundle.getParcelable("forum_tab_info");
            if (forumTabItem != null) {
                if (forumTabItem.getNetType() == 2) {
                    forumStatConstant$TabType = ForumStatConstant$TabType.TAB_TYPE_HOT;
                } else if ((forumTabItem.getTabId() == 1 && forumTabItem.getNetType() == 1) || forumTabItem.getTabId() == 503) {
                    forumStatConstant$TabType = ForumStatConstant$TabType.TAB_TYPE_NEW;
                } else if (forumTabItem.getTabId() == 301) {
                    forumStatConstant$TabType = ForumStatConstant$TabType.TAB_TYPE_GOOD;
                } else if (forumTabItem.isGeneralTab()) {
                    forumStatConstant$TabType = ForumStatConstant$TabType.TAB_TYPE_GENERAL;
                } else {
                    forumStatConstant$TabType = ForumStatConstant$TabType.TAB_TYPE_UNKNOWN;
                }
                return forumStatConstant$TabType;
            }
            return forumStatConstant$TabType2;
        }
        return (ForumStatConstant$TabType) invokeL.objValue;
    }
}

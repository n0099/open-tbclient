package com.baidu.tieba;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ForumSquareActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class jp6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65536, null, i)) == null) {
            if (p45.m().i("like_forum_sort_level", false)) {
                return 2;
            }
            return 1;
        }
        return invokeI.intValue;
    }

    public static void b(TbPageContext<?> tbPageContext, String str) {
        ForumSquareActivityConfig forumSquareActivityConfig;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, tbPageContext, str) != null) || tbPageContext == null) {
            return;
        }
        if (!StringUtils.isNull(str)) {
            forumSquareActivityConfig = new ForumSquareActivityConfig(tbPageContext.getPageActivity(), str);
        } else {
            forumSquareActivityConfig = new ForumSquareActivityConfig(tbPageContext.getPageActivity());
        }
        tbPageContext.sendMessage(new CustomMessage(2002001, forumSquareActivityConfig));
    }
}

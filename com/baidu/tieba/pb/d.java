package com.baidu.tieba.pb;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
public class d {
    public static int v(TbPageContext tbPageContext) {
        String fromPageKey = UtilHelper.getFromPageKey(tbPageContext);
        if (fromPageKey == null) {
            return 3;
        }
        if (fromPageKey.equals("a002")) {
            return 1;
        }
        return fromPageKey.equals("a006") ? 2 : 3;
    }
}

package com.baidu.tieba.tblauncher;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.bg;
/* loaded from: classes.dex */
class u implements bg.a {
    @Override // com.baidu.tbadk.core.util.bg.a
    public int a(TbPageContext<?> tbPageContext, String[] strArr) {
        if (tbPageContext == null || strArr == null || strArr.length == 0) {
            return 3;
        }
        String str = strArr[0];
        if (str.contains(TbConfig.WEB_VIEW_JUMP2NATIVE)) {
            if (str.contains("jump_enter_forum=1")) {
                com.baidu.tbadk.core.d.b.a(tbPageContext.getPageActivity(), 1, true);
                return 1;
            } else if (str.contains("jump_chosen_post=1")) {
                com.baidu.tbadk.core.d.b.a(tbPageContext.getPageActivity(), 2, true);
                return 1;
            }
        }
        return 3;
    }
}

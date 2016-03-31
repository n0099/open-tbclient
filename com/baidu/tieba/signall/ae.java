package com.baidu.tieba.signall;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.SignAllForumActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.bg;
/* loaded from: classes.dex */
class ae implements bg.a {
    @Override // com.baidu.tbadk.core.util.bg.a
    public int a(TbPageContext<?> tbPageContext, String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return 3;
        }
        String str = strArr[0];
        if (!StringUtils.isNull(str) && str.contains("onekeysign:")) {
            SignAllForumActivityConfig signAllForumActivityConfig = new SignAllForumActivityConfig(tbPageContext.getPageActivity());
            if (tbPageContext.getOrignalPage() instanceof BaseActivity) {
                tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.SIGN_ALL_FORUM_CUSTOM_CMD, signAllForumActivityConfig));
                return 0;
            } else if (tbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
                tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.SIGN_ALL_FORUM_CUSTOM_CMD, signAllForumActivityConfig));
                return 0;
            }
        }
        return 3;
    }
}

package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.browser.BaseWebViewActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.bg;
/* loaded from: classes.dex */
class z implements bg.a {
    @Override // com.baidu.tbadk.core.util.bg.a
    public int a(TbPageContext<?> tbPageContext, String[] strArr) {
        String gv;
        if (strArr == null || strArr.length == 0) {
            return 3;
        }
        String str = strArr[0];
        if (str.startsWith(TbConfig.URL_JUMP_TAG_WALLET)) {
            gv = TiebaStatic.gv(str);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_WALLET_ITEM_CLICK, gv));
            if (tbPageContext.getOrignalPage() instanceof BaseWebViewActivity) {
                ((BaseWebViewActivity) tbPageContext.getOrignalPage()).finish();
            }
            return 0;
        }
        return 3;
    }
}

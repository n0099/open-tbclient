package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.browser.BaseWebViewActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.bc;
/* loaded from: classes.dex */
class y implements bc.a {
    @Override // com.baidu.tbadk.core.util.bc.a
    public int a(TbPageContext<?> tbPageContext, String[] strArr) {
        String gI;
        if (strArr == null || strArr.length == 0) {
            return 3;
        }
        String str = strArr[0];
        if (str.startsWith(TbConfig.URL_JUMP_TAG_WALLET)) {
            gI = TiebaStatic.gI(str);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_WALLET_ITEM_CLICK, gI));
            if (tbPageContext.getOrignalPage() instanceof BaseWebViewActivity) {
                ((BaseWebViewActivity) tbPageContext.getOrignalPage()).finish();
            }
            return 0;
        }
        return 3;
    }
}

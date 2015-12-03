package com.baidu.tieba.tbean;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.BuyTBeanActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.bf;
/* loaded from: classes.dex */
class c implements bf.a {
    @Override // com.baidu.tbadk.core.util.bf.a
    public boolean a(TbPageContext<?> tbPageContext, String[] strArr) {
        if (strArr == null || strArr.length == 0 || !strArr[0].contains("tdoudiscount:")) {
            return false;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(tbPageContext.getPageActivity(), 0L)));
        return true;
    }
}

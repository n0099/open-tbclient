package com.baidu.tieba.imMessageCenter.chatmessage;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ChatMessageActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.be;
/* loaded from: classes2.dex */
class b implements be.a {
    @Override // com.baidu.tbadk.core.util.be.a
    public int a(TbPageContext<?> tbPageContext, String[] strArr) {
        if (strArr == null || strArr.length == 0 || strArr[0] == null) {
            return 3;
        }
        String str = strArr[0];
        if (str.contains("http://tieba.baidu.com/mo/q/chat") || str.contains("https://tieba.baidu.com/mo/q/chat")) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChatMessageActivityConfig(tbPageContext.getPageActivity(), -1)));
            return 0;
        }
        return 3;
    }
}

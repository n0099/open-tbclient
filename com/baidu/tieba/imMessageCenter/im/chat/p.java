package com.baidu.tieba.imMessageCenter.im.chat;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.util.aa;
/* loaded from: classes2.dex */
class p implements bb.a {
    @Override // com.baidu.tbadk.core.util.bb.a
    public int a(TbPageContext<?> tbPageContext, String[] strArr) {
        if (tbPageContext == null || strArr == null || strArr.length == 0) {
            return 3;
        }
        String str = strArr[0];
        if (str.contains(TbConfig.WEB_VIEW_JUMP2NATIVE) && str.contains("jump_chat=1")) {
            String aq = aa.aq(str, "userid=");
            String aq2 = aa.aq(str, "username=");
            String aq3 = aa.aq(str, "portrait=");
            if (aq != null && aq.length() > 0) {
                try {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(tbPageContext.getPageActivity(), Long.parseLong(aq), aq2, aq3, 0)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.IM_MESSAGE_CENTER_ACTIVITY_START));
            }
            return 1;
        }
        return 3;
    }
}

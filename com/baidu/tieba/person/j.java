package com.baidu.tieba.person;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.util.aa;
/* loaded from: classes.dex */
class j implements bb.a {
    @Override // com.baidu.tbadk.core.util.bb.a
    public int a(TbPageContext<?> tbPageContext, String[] strArr) {
        if (tbPageContext == null || strArr == null || strArr.length == 0) {
            return 3;
        }
        String str = strArr[0];
        if (str.contains(TbConfig.WEB_VIEW_JUMP2NATIVE) && str.contains("jump_personalCenter=1")) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(tbPageContext.getPageActivity(), aa.aq(str, "userid="), aa.aq(str, "un="))));
            return 1;
        }
        return 3;
    }
}

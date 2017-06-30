package com.baidu.tieba.personPolymeric;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.g.b;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.util.ab;
/* loaded from: classes.dex */
class a implements be.a {
    @Override // com.baidu.tbadk.core.util.be.a
    public int a(TbPageContext<?> tbPageContext, String[] strArr) {
        if (tbPageContext == null || strArr == null || strArr.length == 0) {
            return 3;
        }
        String str = strArr[0];
        if (str.contains(TbConfig.WEB_VIEW_JUMP2NATIVE) && str.contains("jump_personalCenter=1")) {
            String aq = ab.aq(str, "userid=");
            ab.aq(str, "un=");
            long c = b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
            long c2 = b.c(aq, 0L);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(tbPageContext.getPageActivity()).createNormalConfig(c2, c2 == c, false)));
            return 1;
        }
        return 3;
    }
}

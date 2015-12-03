package com.baidu.tieba.pb.chosen;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.bf;
/* loaded from: classes.dex */
class ab implements bf.a {
    @Override // com.baidu.tbadk.core.util.bf.a
    public boolean a(TbPageContext<?> tbPageContext, String[] strArr) {
        if (strArr == null || strArr.length <= 0) {
            return false;
        }
        String str = strArr[0];
        if (str.startsWith("http://tieba.baidu.com/mo/q/recommendpb") && str.contains("ftid=")) {
            String substring = str.substring(str.lastIndexOf("ftid=") + "ftid=".length());
            if (tbPageContext != null) {
                tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbChosenActivityConfig(tbPageContext.getPageActivity(), com.baidu.adp.lib.h.b.c(substring, 0L), null)));
                return true;
            }
            return false;
        }
        return false;
    }
}

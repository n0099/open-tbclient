package com.baidu.tieba.pb.chosen;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.f.b;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.util.bf;
/* loaded from: classes8.dex */
public class RecommendsStatic {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(PbChosenActivityConfig.class, PbChosenActivity.class);
        cSY();
    }

    private static void cSY() {
        bf.bsV().a(new bf.a() { // from class: com.baidu.tieba.pb.chosen.RecommendsStatic.1
            @Override // com.baidu.tbadk.core.util.bf.a
            public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
                if (strArr == null || strArr.length <= 0) {
                    return 3;
                }
                String str = strArr[0];
                if (str.startsWith("http://tieba.baidu.com/mo/q/recommendpb") && str.contains("ftid=")) {
                    String substring = str.substring(str.lastIndexOf("ftid=") + "ftid=".length());
                    if (tbPageContext != null) {
                        tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbChosenActivityConfig(tbPageContext.getPageActivity(), b.toLong(substring, 0L), null)));
                        return 0;
                    }
                }
                return 3;
            }
        });
    }
}

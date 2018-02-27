package com.baidu.tieba.signall;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SignAllForumActivityConfig;
import com.baidu.tbadk.core.atomData.SignAllForumAdvertActivityConfig;
import com.baidu.tbadk.core.util.aw;
/* loaded from: classes3.dex */
public class SignAllForumStatic {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(SignAllForumActivityConfig.class, SignAllForumActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(SignAllForumAdvertActivityConfig.class, SignAllForumAdvertActivity.class);
        btO();
    }

    private static void btO() {
        aw.Dt().a(new aw.a() { // from class: com.baidu.tieba.signall.SignAllForumStatic.1
            @Override // com.baidu.tbadk.core.util.aw.a
            public int a(TbPageContext<?> tbPageContext, String[] strArr) {
                if (strArr == null || strArr.length == 0) {
                    return 3;
                }
                String str = strArr[0];
                if (!StringUtils.isNull(str) && str.contains("onekeysign:")) {
                    SignAllForumActivityConfig signAllForumActivityConfig = new SignAllForumActivityConfig(tbPageContext.getPageActivity());
                    if (tbPageContext.getOrignalPage() instanceof BaseActivity) {
                        tbPageContext.sendMessage(new CustomMessage(2002001, signAllForumActivityConfig));
                        return 0;
                    } else if (tbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
                        tbPageContext.sendMessage(new CustomMessage(2002001, signAllForumActivityConfig));
                        return 0;
                    }
                }
                return 3;
            }
        });
    }
}

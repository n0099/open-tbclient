package com.baidu.tieba.square;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumSquareActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.square.message.ForumSquareHttpResponsedMessage;
import com.baidu.tieba.square.message.ForumSquareSocketResponsedMessage;
/* loaded from: classes2.dex */
public class ForumSquareStatic {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(ForumSquareActivityConfig.class, ForumSquareActivity.class);
        dgE();
    }

    private static void dgE() {
        com.baidu.tieba.tbadkCore.a.a.a(309653, ForumSquareSocketResponsedMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309653, CmdConfigHttp.CMD_FORUM_SQUARE, TbConfig.URL_FORUM_SQUARE, ForumSquareHttpResponsedMessage.class, false, false, true, false);
    }
}

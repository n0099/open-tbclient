package com.baidu.tieba.square;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumSquareActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.square.message.ForumSquareHttpResponsedMessage;
import com.baidu.tieba.square.message.ForumSquareSocketResponsedMessage;
import d.a.n0.e3.d0.a;
/* loaded from: classes5.dex */
public class ForumSquareStatic {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(ForumSquareActivityConfig.class, ForumSquareActivity.class);
        a();
    }

    public static void a() {
        a.h(309653, ForumSquareSocketResponsedMessage.class, false, false);
        a.c(309653, CmdConfigHttp.CMD_FORUM_SQUARE, TbConfig.URL_FORUM_SQUARE, ForumSquareHttpResponsedMessage.class, false, false, true, false);
    }
}

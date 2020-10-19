package com.baidu.tieba.majorsearch;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SearchMajorActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.majorsearch.message.SearchMajorHttpResponsedMessage;
/* loaded from: classes24.dex */
public class SearchMajorStatic {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(SearchMajorActivityConfig.class, SearchMajorActivity.class);
        cWy();
    }

    private static void cWy() {
        com.baidu.tieba.tbadkCore.a.a.c(CmdConfigHttp.CMD_SEARCH_MAJOR, TbConfig.URL_SEARCH_MAJOR, SearchMajorHttpResponsedMessage.class, false, false, true, false);
    }
}

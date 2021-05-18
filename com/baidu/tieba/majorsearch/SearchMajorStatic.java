package com.baidu.tieba.majorsearch;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SearchMajorActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.majorsearch.message.SearchMajorHttpResponsedMessage;
import d.a.k0.d3.d0.a;
/* loaded from: classes3.dex */
public class SearchMajorStatic {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(SearchMajorActivityConfig.class, SearchMajorActivity.class);
        a();
    }

    public static void a() {
        a.e(CmdConfigHttp.CMD_SEARCH_MAJOR, TbConfig.URL_SEARCH_MAJOR, SearchMajorHttpResponsedMessage.class, false, false, true, false);
    }
}

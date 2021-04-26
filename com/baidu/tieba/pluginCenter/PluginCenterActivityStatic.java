package com.baidu.tieba.pluginCenter;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PluginCenterActivityConfig;
import com.baidu.tbadk.core.atomData.PluginDetailActivityConfig;
import com.baidu.tbadk.core.atomData.PluginDownloadActivityConfig;
/* loaded from: classes4.dex */
public class PluginCenterActivityStatic {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(PluginCenterActivityConfig.class, NpsPluginCenterActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(PluginDetailActivityConfig.class, PluginDetailActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(PluginDownloadActivityConfig.class, PluginDownloadActivity.class);
    }
}

package com.baidu.tieba.pluginCenter;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PluginCenterActivityConfig;
import com.baidu.tbadk.core.atomData.PluginDetailActivityConfig;
import com.baidu.tbadk.core.atomData.PluginDownloadActivityConfig;
/* loaded from: classes.dex */
public class PluginCenterActivityStatic {
    static {
        TbadkCoreApplication.m10getInst().RegisterIntent(PluginCenterActivityConfig.class, PluginCenterActivity.class);
        TbadkCoreApplication.m10getInst().RegisterIntent(PluginDetailActivityConfig.class, PluginDetailActivity.class);
        TbadkCoreApplication.m10getInst().RegisterIntent(PluginDownloadActivityConfig.class, PluginDownloadActivity.class);
    }
}

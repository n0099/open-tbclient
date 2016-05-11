package com.baidu.tieba.pluginCenter;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PluginCenterActivityConfig;
import com.baidu.tbadk.core.atomData.PluginDetailActivityConfig;
import com.baidu.tbadk.core.atomData.PluginDownloadActivityConfig;
/* loaded from: classes.dex */
public class PluginCenterActivityStatic {
    static {
        TbadkCoreApplication.m11getInst().RegisterIntent(PluginCenterActivityConfig.class, PluginCenterActivity.class);
        TbadkCoreApplication.m11getInst().RegisterIntent(PluginDetailActivityConfig.class, PluginDetailActivity.class);
        TbadkCoreApplication.m11getInst().RegisterIntent(PluginDownloadActivityConfig.class, PluginDownloadActivity.class);
    }
}

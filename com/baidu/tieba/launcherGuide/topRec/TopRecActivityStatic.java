package com.baidu.tieba.launcherGuide.topRec;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.TopRecActivityConfig;
/* loaded from: classes.dex */
public class TopRecActivityStatic {
    static {
        TbadkApplication.getInst().RegisterIntent(TopRecActivityConfig.class, TopRecActivity.class);
    }
}

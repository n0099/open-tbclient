package com.baidu.tieba.video.localvideo;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LocalVideoActivityConfig;
/* loaded from: classes2.dex */
public class LocalVideoActivityStatic {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(LocalVideoActivityConfig.class, LocalVideoActivity.class);
    }
}

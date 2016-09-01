package com.baidu.tieba.write.album;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
/* loaded from: classes.dex */
public class AlbumActivityStatic {
    static {
        TbadkCoreApplication.m9getInst().RegisterIntent(AlbumActivityConfig.class, AlbumActivity.class);
    }
}

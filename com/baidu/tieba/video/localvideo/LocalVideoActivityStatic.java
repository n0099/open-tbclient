package com.baidu.tieba.video.localvideo;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CloudMusicActivityConfig;
import com.baidu.tbadk.core.atomData.EditVideoActivityConfig;
import com.baidu.tbadk.core.atomData.LocalVideoActivityConfig;
import com.baidu.tbadk.core.atomData.RecordVideoActivityConfig;
import com.baidu.tieba.video.cloudmusic.CloudMusicActivity;
import com.baidu.tieba.video.editvideo.EditVideoActivity;
import com.baidu.tieba.video.record.RecordVideoActivity;
/* loaded from: classes10.dex */
public class LocalVideoActivityStatic {
    public static String Tag = "tag";

    static {
        TbadkCoreApplication.getInst().RegisterIntent(LocalVideoActivityConfig.class, LocalVideoActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(RecordVideoActivityConfig.class, RecordVideoActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(EditVideoActivityConfig.class, EditVideoActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(CloudMusicActivityConfig.class, CloudMusicActivity.class);
    }
}

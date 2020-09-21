package com.baidu.tieba.video.localvideo;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CloudMusicActivityConfig;
import com.baidu.tbadk.core.atomData.EditVideoActivityConfig;
import com.baidu.tbadk.core.atomData.LocalVideoActivityConfig;
import com.baidu.tbadk.core.atomData.RecordVideoActivityConfig;
import com.baidu.tieba.video.cloudmusic.CloudMusicActivity;
import com.baidu.tieba.video.editvideo.EditVideoActivity;
import com.baidu.tieba.video.record.RecordVideoActivity;
/* loaded from: classes22.dex */
public class LocalVideoActivityStatic {
    public static String Tag = "tag";

    static {
        TbadkCoreApplication.getInst().RegisterIntent(LocalVideoActivityConfig.class, LocalVideoActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(RecordVideoActivityConfig.class, RecordVideoActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(EditVideoActivityConfig.class, EditVideoActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(CloudMusicActivityConfig.class, CloudMusicActivity.class);
        CustomMessageTask customMessageTask = new CustomMessageTask(2921466, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivityStatic.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<com.baidu.tieba.c.b> run(CustomMessage<Object> customMessage) {
                if (customMessage == null || !(customMessage.getData() instanceof com.baidu.tieba.video.b)) {
                    return null;
                }
                return new CustomResponsedMessage<>(2921466, new com.baidu.tieba.video.editvideo.view.b((com.baidu.tieba.video.b) customMessage.getData()));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}

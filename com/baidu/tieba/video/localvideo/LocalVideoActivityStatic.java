package com.baidu.tieba.video.localvideo;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CloudMusicActivityConfig;
import com.baidu.tbadk.core.atomData.EditVideoActivityConfig;
import com.baidu.tbadk.core.atomData.RecordVideoActivityConfig;
import com.baidu.tieba.video.cloudmusic.CloudMusicActivity;
import com.baidu.tieba.video.editvideo.EditVideoActivity;
import com.baidu.tieba.video.record.RecordVideoActivity;
import d.a.j0.b0.b;
/* loaded from: classes5.dex */
public class LocalVideoActivityStatic {

    /* loaded from: classes5.dex */
    public static class a implements CustomMessageTask.CustomRunnable<Object> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<b> run(CustomMessage<Object> customMessage) {
            if (customMessage == null || !(customMessage.getData() instanceof d.a.j0.q3.b)) {
                return null;
            }
            return new CustomResponsedMessage<>(2921466, new d.a.j0.q3.j.h.b((d.a.j0.q3.b) customMessage.getData()));
        }
    }

    static {
        TbadkCoreApplication.getInst().RegisterIntent(RecordVideoActivityConfig.class, RecordVideoActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(EditVideoActivityConfig.class, EditVideoActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(CloudMusicActivityConfig.class, CloudMusicActivity.class);
        CustomMessageTask customMessageTask = new CustomMessageTask(2921466, new a());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}

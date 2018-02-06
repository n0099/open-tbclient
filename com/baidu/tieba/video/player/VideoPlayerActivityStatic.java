package com.baidu.tieba.video.player;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.b.d;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.XiaoyingPlayerConfig;
import com.baidu.tbadk.editortools.r;
import com.baidu.tieba.xiaoying.editor.a;
import com.baidu.tieba.xiaoying.editor.c;
/* loaded from: classes3.dex */
public class VideoPlayerActivityStatic {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(XiaoyingPlayerConfig.class, VideoPlayerActivity.class);
        CustomMessageTask customMessageTask = new CustomMessageTask(2001349, new CustomMessageTask.CustomRunnable<Context>() { // from class: com.baidu.tieba.video.player.VideoPlayerActivityStatic.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<r> run(CustomMessage<Context> customMessage) {
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Context) || d.mA().an("xiaoying_write") == 0) {
                    return null;
                }
                return new CustomResponsedMessage<>(2001349, new c(customMessage.getData()));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2001350, new CustomMessageTask.CustomRunnable<Context>() { // from class: com.baidu.tieba.video.player.VideoPlayerActivityStatic.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<r> run(CustomMessage<Context> customMessage) {
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Context) || d.mA().an("xiaoying_write") == 0) {
                    return null;
                }
                return new CustomResponsedMessage<>(2001350, new a(customMessage.getData()));
            }
        });
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
    }
}

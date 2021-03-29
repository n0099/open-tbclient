package com.baidu.tieba.image;

import android.content.Intent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
/* loaded from: classes3.dex */
public class ImageViewerActivityStatic {

    /* loaded from: classes3.dex */
    public static class a implements CustomMessageTask.CustomRunnable<ImageViewerConfig> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<ImageViewerConfig> customMessage) {
            if (customMessage != null && customMessage.getData() != null) {
                ImageViewerConfig data = customMessage.getData();
                Intent intent = data.getIntent();
                if (ImageViewerConfig.DATA_VALID.equals(intent.getStringExtra(ImageViewerConfig.IS_DATA_VALID))) {
                    if (ImageViewerConfig.START_ACTIVITY_NORMAL.equals(intent.getStringExtra(ImageViewerConfig.START_ACTIVITY_TYPE))) {
                        data.startActivityForRemote(ImageViewerActivity.class);
                    } else {
                        data.startActivityForResultForRemote(14001, ImageViewerActivity.class);
                    }
                }
            }
            return null;
        }
    }

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2010000, new a());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}

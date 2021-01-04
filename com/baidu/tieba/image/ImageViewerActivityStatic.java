package com.baidu.tieba.image;

import android.content.Intent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
/* loaded from: classes8.dex */
public class ImageViewerActivityStatic {
    public static String Tag = "tag";

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new CustomMessageTask.CustomRunnable<ImageViewerConfig>() { // from class: com.baidu.tieba.image.ImageViewerActivityStatic.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<ImageViewerConfig> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    ImageViewerConfig data = customMessage.getData();
                    Intent intent = data.getIntent();
                    if (ImageViewerConfig.DATA_VALID.equals(intent.getStringExtra(ImageViewerConfig.IS_DATA_VALID))) {
                        if (ImageViewerConfig.START_ACTIVITY_NORMAL.equals(intent.getStringExtra(ImageViewerConfig.START_ACTIVITY_TYPE))) {
                            data.startActivityForRemote(ImageViewerActivity.class);
                        } else {
                            data.startActivityForResultForRemote(RequestResponseCode.REQUEST_PB_BIG_IMAGE, ImageViewerActivity.class);
                        }
                    }
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}

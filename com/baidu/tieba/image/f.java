package com.baidu.tieba.image;

import android.content.Intent;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
/* loaded from: classes.dex */
class f implements CustomMessageTask.CustomRunnable<ImageViewerConfig> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<ImageViewerConfig> customMessage) {
        if (customMessage != null && customMessage.getData() != null) {
            ImageViewerConfig data = customMessage.getData();
            Intent intent = data.getIntent();
            if (ImageViewerConfig.DATA_VALID.equals(intent.getStringExtra(ImageViewerConfig.IS_DATA_VALID))) {
                intent.setClass(data.getContext(), ImageViewerActivity.class);
                if (ImageViewerConfig.START_ACTIVITY_NORMAL.equals(intent.getStringExtra(ImageViewerConfig.START_ACTIVITY_TYPE))) {
                    data.startActivity();
                } else {
                    data.startActivityForResult(14001);
                }
            }
        }
        return null;
    }
}

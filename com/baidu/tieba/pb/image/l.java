package com.baidu.tieba.pb.image;

import android.text.TextUtils;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements CustomMessageTask.CustomRunnable<com.baidu.tbadk.core.atomData.v> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<com.baidu.tbadk.core.atomData.v> customMessage) {
        if (customMessage != null && customMessage.getData() != null) {
            customMessage.getData().getIntent().setClass(customMessage.getData().getContext(), ImagePbActivity.class);
            if (!TextUtils.isEmpty(customMessage.getData().getIntent().getStringExtra(com.baidu.tbadk.core.frameworkData.a.THREAD_ID))) {
                customMessage.getData().startActivity();
            }
        }
        return null;
    }
}

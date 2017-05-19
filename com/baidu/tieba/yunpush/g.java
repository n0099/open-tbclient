package com.baidu.tieba.yunpush;

import android.content.Intent;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.pushservice.PushServiceUtil;
/* loaded from: classes2.dex */
class g extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public g(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Intent)) {
            PushServiceUtil.getInstance().onUnbind((Intent) customResponsedMessage.getData());
        }
    }
}

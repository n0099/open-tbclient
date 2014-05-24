package com.baidu.tieba.tblauncher;

import android.app.Activity;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class s extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public s(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Object data = customResponsedMessage.getData();
        if (data instanceof Activity) {
            com.baidu.tbadk.core.b.b.a((Activity) data);
        }
    }
}

package com.baidu.tieba.j;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends CustomMessageListener {
    final /* synthetic */ a flI;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(a aVar, int i) {
        super(i);
        this.flI = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
            this.flI.mHasNewVersion = ((Boolean) customResponsedMessage.getData()).booleanValue();
            a aVar = this.flI;
            z = this.flI.mHasNewVersion;
            aVar.fli = z ? true : this.flI.fli;
            this.flI.baH();
        }
    }
}

package com.baidu.tieba.person.post;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.tieba.person.post.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends CustomMessageListener {
    final /* synthetic */ v dhq;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(v vVar, int i) {
        super(i);
        this.dhq = vVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        q qVar;
        v.a aVar;
        if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && com.baidu.adp.lib.util.i.iZ()) {
            z = this.dhq.aza;
            if (z) {
                qVar = this.dhq.dhn;
                qVar.fY(false);
                aVar = this.dhq.dhp;
                aVar.Ob();
            }
        }
    }
}

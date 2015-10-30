package com.baidu.tieba.person.post;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.tieba.person.post.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends CustomMessageListener {
    final /* synthetic */ u csi;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(u uVar, int i) {
        super(i);
        this.csi = uVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        p pVar;
        u.a aVar;
        if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && com.baidu.adp.lib.util.i.iM()) {
            z = this.csi.avO;
            if (z) {
                pVar = this.csi.csf;
                pVar.eX(false);
                aVar = this.csi.csh;
                aVar.Kf();
            }
        }
    }
}

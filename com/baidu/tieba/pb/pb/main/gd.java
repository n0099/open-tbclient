package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.pb.pb.main.eg;
/* loaded from: classes.dex */
class gd extends CustomMessageListener {
    final /* synthetic */ ReaderPbService dVY;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gd(ReaderPbService readerPbService, int i) {
        super(i);
        this.dVY = readerPbService;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        eg.a aVar;
        eg.a aVar2;
        eg egVar;
        eg egVar2;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
            int intValue = ((Integer) customResponsedMessage.getData()).intValue();
            if (intValue == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10833").ab("obj_locate", "1"));
                aVar2 = this.dVY.mRefreshCallback;
                egVar = this.dVY.mReaderManager;
                int i = egVar.dST;
                egVar2 = this.dVY.mReaderManager;
                aVar2.bb(i, egVar2.aGF());
            } else if (intValue == 2) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10833").ab("obj_locate", "2"));
                aVar = this.dVY.mRefreshCallback;
                aVar.aGI();
            }
        }
    }
}

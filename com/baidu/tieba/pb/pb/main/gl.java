package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.pb.pb.main.ei;
/* loaded from: classes.dex */
class gl extends CustomMessageListener {
    final /* synthetic */ ReaderPbService eDb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gl(ReaderPbService readerPbService, int i) {
        super(i);
        this.eDb = readerPbService;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ei.a aVar;
        ei.a aVar2;
        ei eiVar;
        ei eiVar2;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
            int intValue = ((Integer) customResponsedMessage.getData()).intValue();
            if (intValue == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10833").ab("obj_locate", "1"));
                aVar2 = this.eDb.mRefreshCallback;
                eiVar = this.eDb.mReaderManager;
                int i = eiVar.ezP;
                eiVar2 = this.eDb.mReaderManager;
                aVar2.bl(i, eiVar2.aRt());
            } else if (intValue == 2) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10833").ab("obj_locate", "2"));
                aVar = this.eDb.mRefreshCallback;
                aVar.aRw();
            }
        }
    }
}

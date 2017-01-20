package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.pb.pb.main.ei;
/* loaded from: classes.dex */
class go extends CustomMessageListener {
    final /* synthetic */ ReaderPbService eqq;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public go(ReaderPbService readerPbService, int i) {
        super(i);
        this.eqq = readerPbService;
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
                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10833").ab("obj_locate", "1"));
                aVar2 = this.eqq.mRefreshCallback;
                eiVar = this.eqq.mReaderManager;
                int i = eiVar.emS;
                eiVar2 = this.eqq.mReaderManager;
                aVar2.bb(i, eiVar2.aNb());
            } else if (intValue == 2) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10833").ab("obj_locate", "2"));
                aVar = this.eqq.mRefreshCallback;
                aVar.aNe();
            }
        }
    }
}

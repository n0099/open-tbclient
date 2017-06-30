package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.pb.pb.main.fh;
/* loaded from: classes.dex */
class ho extends CustomMessageListener {
    final /* synthetic */ ReaderPbService eEB;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ho(ReaderPbService readerPbService, int i) {
        super(i);
        this.eEB = readerPbService;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        fh.a aVar;
        fh.a aVar2;
        fh fhVar;
        fh fhVar2;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
            int intValue = ((Integer) customResponsedMessage.getData()).intValue();
            if (intValue == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.au("c10833").Z("obj_locate", "1"));
                aVar2 = this.eEB.mRefreshCallback;
                fhVar = this.eEB.mReaderManager;
                int i = fhVar.eAL;
                fhVar2 = this.eEB.mReaderManager;
                aVar2.bc(i, fhVar2.aPO());
            } else if (intValue == 2) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.au("c10833").Z("obj_locate", "2"));
                aVar = this.eEB.mRefreshCallback;
                aVar.aPR();
            }
        }
    }
}

package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.pb.pb.main.ej;
/* loaded from: classes.dex */
class go extends CustomMessageListener {
    final /* synthetic */ ReaderPbService etx;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public go(ReaderPbService readerPbService, int i) {
        super(i);
        this.etx = readerPbService;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ej.a aVar;
        ej.a aVar2;
        ej ejVar;
        ej ejVar2;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
            int intValue = ((Integer) customResponsedMessage.getData()).intValue();
            if (intValue == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10833").Z("obj_locate", "1"));
                aVar2 = this.etx.mRefreshCallback;
                ejVar = this.etx.mReaderManager;
                int i = ejVar.epS;
                ejVar2 = this.etx.mReaderManager;
                aVar2.bf(i, ejVar2.aMu());
            } else if (intValue == 2) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10833").Z("obj_locate", "2"));
                aVar = this.etx.mRefreshCallback;
                aVar.aMx();
            }
        }
    }
}

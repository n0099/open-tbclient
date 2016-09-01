package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.pb.pb.main.eh;
/* loaded from: classes.dex */
class gi extends CustomMessageListener {
    final /* synthetic */ ReaderPbService euI;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gi(ReaderPbService readerPbService, int i) {
        super(i);
        this.euI = readerPbService;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        eh.a aVar;
        eh.a aVar2;
        eh ehVar;
        eh ehVar2;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
            int intValue = ((Integer) customResponsedMessage.getData()).intValue();
            if (intValue == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10833").ab("obj_locate", "1"));
                aVar2 = this.euI.mRefreshCallback;
                ehVar = this.euI.mReaderManager;
                int i = ehVar.erp;
                ehVar2 = this.euI.mReaderManager;
                aVar2.bi(i, ehVar2.aOJ());
            } else if (intValue == 2) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10833").ab("obj_locate", "2"));
                aVar = this.euI.mRefreshCallback;
                aVar.aOM();
            }
        }
    }
}

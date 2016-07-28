package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.pb.pb.main.eh;
/* loaded from: classes.dex */
class gh extends CustomMessageListener {
    final /* synthetic */ ReaderPbService eiB;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gh(ReaderPbService readerPbService, int i) {
        super(i);
        this.eiB = readerPbService;
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
                aVar2 = this.eiB.mRefreshCallback;
                ehVar = this.eiB.mReaderManager;
                int i = ehVar.efk;
                ehVar2 = this.eiB.mReaderManager;
                aVar2.be(i, ehVar2.aJS());
            } else if (intValue == 2) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10833").ab("obj_locate", "2"));
                aVar = this.eiB.mRefreshCallback;
                aVar.aJV();
            }
        }
    }
}

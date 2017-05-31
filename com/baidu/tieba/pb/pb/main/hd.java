package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.pb.pb.main.ey;
/* loaded from: classes.dex */
class hd extends CustomMessageListener {
    final /* synthetic */ ReaderPbService evn;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hd(ReaderPbService readerPbService, int i) {
        super(i);
        this.evn = readerPbService;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ey.a aVar;
        ey.a aVar2;
        ey eyVar;
        ey eyVar2;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
            int intValue = ((Integer) customResponsedMessage.getData()).intValue();
            if (intValue == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10833").Z("obj_locate", "1"));
                aVar2 = this.evn.mRefreshCallback;
                eyVar = this.evn.mReaderManager;
                int i = eyVar.erA;
                eyVar2 = this.evn.mReaderManager;
                aVar2.aU(i, eyVar2.aLQ());
            } else if (intValue == 2) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10833").Z("obj_locate", "2"));
                aVar = this.evn.mRefreshCallback;
                aVar.aLT();
            }
        }
    }
}

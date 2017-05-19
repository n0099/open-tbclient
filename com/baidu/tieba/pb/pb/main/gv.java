package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.pb.pb.main.ep;
/* loaded from: classes.dex */
class gv extends CustomMessageListener {
    final /* synthetic */ ReaderPbService epy;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gv(ReaderPbService readerPbService, int i) {
        super(i);
        this.epy = readerPbService;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ep.a aVar;
        ep.a aVar2;
        ep epVar;
        ep epVar2;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
            int intValue = ((Integer) customResponsedMessage.getData()).intValue();
            if (intValue == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10833").aa("obj_locate", "1"));
                aVar2 = this.epy.mRefreshCallback;
                epVar = this.epy.mReaderManager;
                int i = epVar.elN;
                epVar2 = this.epy.mReaderManager;
                aVar2.aW(i, epVar2.aKU());
            } else if (intValue == 2) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10833").aa("obj_locate", "2"));
                aVar = this.epy.mRefreshCallback;
                aVar.aKX();
            }
        }
    }
}

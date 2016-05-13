package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.pb.pb.main.dz;
/* loaded from: classes.dex */
class fw extends CustomMessageListener {
    final /* synthetic */ ReaderPbService dpB;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fw(ReaderPbService readerPbService, int i) {
        super(i);
        this.dpB = readerPbService;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        dz.a aVar;
        dz.a aVar2;
        dz dzVar;
        dz dzVar2;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
            int intValue = ((Integer) customResponsedMessage.getData()).intValue();
            if (intValue == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10833").ac("obj_locate", "1"));
                aVar2 = this.dpB.mRefreshCallback;
                dzVar = this.dpB.mReaderManager;
                int i = dzVar.dmC;
                dzVar2 = this.dpB.mReaderManager;
                aVar2.aM(i, dzVar2.ayw());
            } else if (intValue == 2) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10833").ac("obj_locate", "2"));
                aVar = this.dpB.mRefreshCallback;
                aVar.ayz();
            }
        }
    }
}

package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.pb.pb.main.eh;
/* loaded from: classes.dex */
class gm extends CustomMessageListener {
    final /* synthetic */ ReaderPbService etX;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gm(ReaderPbService readerPbService, int i) {
        super(i);
        this.etX = readerPbService;
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
                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10833").aa("obj_locate", "1"));
                aVar2 = this.etX.mRefreshCallback;
                ehVar = this.etX.mReaderManager;
                int i = ehVar.eqs;
                ehVar2 = this.etX.mReaderManager;
                aVar2.aZ(i, ehVar2.aNE());
            } else if (intValue == 2) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10833").aa("obj_locate", "2"));
                aVar = this.etX.mRefreshCallback;
                aVar.aNH();
            }
        }
    }
}

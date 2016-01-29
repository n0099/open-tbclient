package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.pb.pb.main.dn;
/* loaded from: classes.dex */
class fi extends CustomMessageListener {
    final /* synthetic */ ReaderPbService cSC;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fi(ReaderPbService readerPbService, int i) {
        super(i);
        this.cSC = readerPbService;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        dn.a aVar;
        dn.a aVar2;
        dn dnVar;
        dn dnVar2;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
            int intValue = ((Integer) customResponsedMessage.getData()).intValue();
            if (intValue == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.au("c10833").aa("obj_locate", "1"));
                aVar2 = this.cSC.mRefreshCallback;
                dnVar = this.cSC.mReaderManager;
                int aqC = dnVar.aqC();
                dnVar2 = this.cSC.mReaderManager;
                aVar2.aM(aqC, dnVar2.aqE());
            } else if (intValue == 2) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.au("c10833").aa("obj_locate", "2"));
                aVar = this.cSC.mRefreshCallback;
                aVar.aqH();
            }
        }
    }
}

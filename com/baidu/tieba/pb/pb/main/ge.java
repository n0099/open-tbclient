package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.pb.pb.main.eb;
/* loaded from: classes.dex */
class ge extends CustomMessageListener {
    final /* synthetic */ ReaderPbService ehh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ge(ReaderPbService readerPbService, int i) {
        super(i);
        this.ehh = readerPbService;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        eb.a aVar;
        eb.a aVar2;
        eb ebVar;
        eb ebVar2;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
            int intValue = ((Integer) customResponsedMessage.getData()).intValue();
            if (intValue == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.at("c10833").ab("obj_locate", "1"));
                aVar2 = this.ehh.mRefreshCallback;
                ebVar = this.ehh.mReaderManager;
                int i = ebVar.edY;
                ebVar2 = this.ehh.mReaderManager;
                aVar2.ba(i, ebVar2.aLn());
            } else if (intValue == 2) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.at("c10833").ab("obj_locate", "2"));
                aVar = this.ehh.mRefreshCallback;
                aVar.aLq();
            }
        }
    }
}

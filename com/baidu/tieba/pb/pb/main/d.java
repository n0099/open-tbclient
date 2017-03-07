package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends CustomMessageListener {
    final /* synthetic */ b ekc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(b bVar, int i) {
        super(i);
        this.ekc = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        PbModel pbModel;
        PbModel pbModel2;
        PbModel pbModel3;
        PbModel pbModel4;
        int f;
        pbModel = this.ekc.ejZ;
        if (pbModel != null) {
            pbModel2 = this.ekc.ejZ;
            if (pbModel2.aLQ() != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.graffiti.b)) {
                com.baidu.tieba.graffiti.b bVar = (com.baidu.tieba.graffiti.b) customResponsedMessage.getData();
                String threadId = bVar.getThreadId();
                com.baidu.tbadk.core.data.af agI = bVar.agI();
                if (agI != null && !TextUtils.isEmpty(threadId)) {
                    pbModel3 = this.ekc.ejZ;
                    if (threadId.equals(pbModel3.getThreadID())) {
                        pbModel4 = this.ekc.ejZ;
                        com.baidu.tbadk.core.data.ag aLj = pbModel4.aLQ().aLj();
                        if (aLj != null) {
                            List<com.baidu.tbadk.core.data.af> items = aLj.getItems();
                            if (items == null) {
                                items = new ArrayList<>();
                            }
                            f = this.ekc.f(agI.getGid(), items);
                            if (f >= 0 && com.baidu.tbadk.core.util.x.d(items, f) != null) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GRAFFITI_LIST_CHANGED, aLj));
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RECORDER_RESET_CMD));
                            }
                        }
                    }
                }
            }
        }
    }
}

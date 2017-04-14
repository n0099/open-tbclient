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
public class c extends CustomMessageListener {
    final /* synthetic */ b eii;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(b bVar, int i) {
        super(i);
        this.eii = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        PbModel pbModel;
        PbModel pbModel2;
        PbModel pbModel3;
        com.baidu.tbadk.core.data.ae graffitiInfo;
        PbModel pbModel4;
        int f;
        pbModel = this.eii.eif;
        if (pbModel != null) {
            pbModel2 = this.eii.eif;
            if (pbModel2.aLZ() != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.graffiti.j)) {
                com.baidu.tieba.graffiti.j jVar = (com.baidu.tieba.graffiti.j) customResponsedMessage.getData();
                String threadId = jVar.getThreadId();
                if (!TextUtils.isEmpty(threadId)) {
                    pbModel3 = this.eii.eif;
                    if (threadId.equals(pbModel3.getThreadID()) && (graffitiInfo = jVar.getGraffitiInfo()) != null && graffitiInfo.qR()) {
                        pbModel4 = this.eii.eif;
                        com.baidu.tbadk.core.data.af aLr = pbModel4.aLZ().aLr();
                        if (aLr != null) {
                            List<com.baidu.tbadk.core.data.ae> items = aLr.getItems();
                            if (items == null) {
                                items = new ArrayList<>();
                            }
                            f = this.eii.f(graffitiInfo.getUid(), items);
                            if (f >= 0) {
                                com.baidu.tbadk.core.util.x.d(items, f);
                            }
                            items.add(0, graffitiInfo);
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GRAFFITI_LIST_CHANGED, aLr));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RECORDER_RESET_CMD));
                    }
                }
            }
        }
    }
}

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
public class n extends CustomMessageListener {
    final /* synthetic */ m dfX;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(m mVar, int i) {
        super(i);
        this.dfX = mVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        df dfVar;
        df dfVar2;
        df dfVar3;
        com.baidu.tbadk.core.data.u graffitiInfo;
        df dfVar4;
        int e;
        dfVar = this.dfX.dfV;
        if (dfVar != null) {
            dfVar2 = this.dfX.dfV;
            if (dfVar2.axA() != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.graffiti.k)) {
                com.baidu.tieba.graffiti.k kVar = (com.baidu.tieba.graffiti.k) customResponsedMessage.getData();
                String threadId = kVar.getThreadId();
                if (!TextUtils.isEmpty(threadId)) {
                    dfVar3 = this.dfX.dfV;
                    if (threadId.equals(dfVar3.getThreadID()) && (graffitiInfo = kVar.getGraffitiInfo()) != null && graffitiInfo.rX()) {
                        dfVar4 = this.dfX.dfV;
                        com.baidu.tbadk.core.data.v awW = dfVar4.axA().awW();
                        if (awW != null) {
                            List<com.baidu.tbadk.core.data.u> items = awW.getItems();
                            if (items == null) {
                                items = new ArrayList<>();
                            }
                            e = this.dfX.e(graffitiInfo.getUid(), items);
                            if (e >= 0) {
                                com.baidu.tbadk.core.util.y.c(items, e);
                            }
                            items.add(0, graffitiInfo);
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GRAFFITI_LIST_CHANGED, awW));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RECORDER_RESET_CMD));
                    }
                }
            }
        }
    }
}

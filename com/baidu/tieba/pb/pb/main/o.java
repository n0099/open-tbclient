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
public class o extends CustomMessageListener {
    final /* synthetic */ m dfX;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(m mVar, int i) {
        super(i);
        this.dfX = mVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        df dfVar;
        df dfVar2;
        df dfVar3;
        df dfVar4;
        int d;
        dfVar = this.dfX.dfV;
        if (dfVar != null) {
            dfVar2 = this.dfX.dfV;
            if (dfVar2.axA() != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.graffiti.c)) {
                com.baidu.tieba.graffiti.c cVar = (com.baidu.tieba.graffiti.c) customResponsedMessage.getData();
                String threadId = cVar.getThreadId();
                com.baidu.tbadk.core.data.u Ye = cVar.Ye();
                if (Ye != null && !TextUtils.isEmpty(threadId)) {
                    dfVar3 = this.dfX.dfV;
                    if (threadId.equals(dfVar3.getThreadID())) {
                        dfVar4 = this.dfX.dfV;
                        com.baidu.tbadk.core.data.v awW = dfVar4.axA().awW();
                        if (awW != null) {
                            List<com.baidu.tbadk.core.data.u> items = awW.getItems();
                            if (items == null) {
                                items = new ArrayList<>();
                            }
                            d = this.dfX.d(Ye.getGid(), items);
                            if (d >= 0 && com.baidu.tbadk.core.util.y.c(items, d) != null) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GRAFFITI_LIST_CHANGED, awW));
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RECORDER_RESET_CMD));
                            }
                        }
                    }
                }
            }
        }
    }
}

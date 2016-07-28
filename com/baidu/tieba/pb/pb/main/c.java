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
    final /* synthetic */ b eau;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(b bVar, int i) {
        super(i);
        this.eau = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        dh dhVar;
        dh dhVar2;
        dh dhVar3;
        com.baidu.tbadk.core.data.z graffitiInfo;
        dh dhVar4;
        int a;
        dhVar = this.eau.eas;
        if (dhVar != null) {
            dhVar2 = this.eau.eas;
            if (dhVar2.aJs() != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.graffiti.k)) {
                com.baidu.tieba.graffiti.k kVar = (com.baidu.tieba.graffiti.k) customResponsedMessage.getData();
                String threadId = kVar.getThreadId();
                if (!TextUtils.isEmpty(threadId)) {
                    dhVar3 = this.eau.eas;
                    if (threadId.equals(dhVar3.getThreadID()) && (graffitiInfo = kVar.getGraffitiInfo()) != null && graffitiInfo.oR()) {
                        dhVar4 = this.eau.eas;
                        com.baidu.tbadk.core.data.aa aIJ = dhVar4.aJs().aIJ();
                        if (aIJ != null) {
                            List<com.baidu.tbadk.core.data.z> items = aIJ.getItems();
                            if (items == null) {
                                items = new ArrayList<>();
                            }
                            a = this.eau.a(graffitiInfo.getUid(), items);
                            if (a >= 0) {
                                com.baidu.tbadk.core.util.y.d(items, a);
                            }
                            items.add(0, graffitiInfo);
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GRAFFITI_LIST_CHANGED, aIJ));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RECORDER_RESET_CMD));
                    }
                }
            }
        }
    }
}

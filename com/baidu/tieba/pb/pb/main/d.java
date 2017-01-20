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
    final /* synthetic */ b ehk;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(b bVar, int i) {
        super(i);
        this.ehk = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        PbModel pbModel;
        PbModel pbModel2;
        PbModel pbModel3;
        PbModel pbModel4;
        int f;
        pbModel = this.ehk.ehh;
        if (pbModel != null) {
            pbModel2 = this.ehk.ehh;
            if (pbModel2.aMu() != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.graffiti.b)) {
                com.baidu.tieba.graffiti.b bVar = (com.baidu.tieba.graffiti.b) customResponsedMessage.getData();
                String threadId = bVar.getThreadId();
                com.baidu.tbadk.core.data.ae ahx = bVar.ahx();
                if (ahx != null && !TextUtils.isEmpty(threadId)) {
                    pbModel3 = this.ehk.ehh;
                    if (threadId.equals(pbModel3.getThreadID())) {
                        pbModel4 = this.ehk.ehh;
                        com.baidu.tbadk.core.data.af aLN = pbModel4.aMu().aLN();
                        if (aLN != null) {
                            List<com.baidu.tbadk.core.data.ae> items = aLN.getItems();
                            if (items == null) {
                                items = new ArrayList<>();
                            }
                            f = this.ehk.f(ahx.getGid(), items);
                            if (f >= 0 && com.baidu.tbadk.core.util.w.d(items, f) != null) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GRAFFITI_LIST_CHANGED, aLN));
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RECORDER_RESET_CMD));
                            }
                        }
                    }
                }
            }
        }
    }
}

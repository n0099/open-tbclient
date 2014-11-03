package com.baidu.tieba.neighbors;

import android.view.View;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class n extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public n(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tbadk.b.a aVar;
        com.baidu.tbadk.b.a aVar2;
        com.baidu.tbadk.b.a aVar3;
        View.OnClickListener onClickListener;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2009501 && customResponsedMessage.getData() != null) {
            NeighborsStatic.anC = (com.baidu.tbadk.b.a) customResponsedMessage.getData();
            aVar = NeighborsStatic.anC;
            if (aVar.getContext() != null) {
                aVar2 = NeighborsStatic.anC;
                ((com.baidu.tbadk.b.a) customResponsedMessage.getData()).a(new NeighborsActivityConfig(aVar2.getContext(), true));
                aVar3 = NeighborsStatic.anC;
                ((com.baidu.tbadk.b.a) customResponsedMessage.getData()).b(new NeighborsActivityConfig(aVar3.getContext(), false));
                onClickListener = NeighborsStatic.He;
                ((com.baidu.tbadk.b.a) customResponsedMessage.getData()).c(onClickListener);
                ((com.baidu.tbadk.b.a) customResponsedMessage.getData()).cA(s.icon_neighbors);
                ((com.baidu.tbadk.b.a) customResponsedMessage.getData()).cB(v.neighbors);
            }
        }
    }
}

package com.baidu.tieba.myCollection;

import android.content.Context;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.v;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
class d extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public d(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tbadk.mainTab.f fVar;
        int i;
        int i2;
        com.baidu.tbadk.mainTab.e eVar;
        com.baidu.tbadk.mainTab.e eVar2;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007007 && customResponsedMessage.getData() != null) {
            EditMarkStatic.aNZ = (com.baidu.tbadk.mainTab.f) customResponsedMessage.getData();
            fVar = EditMarkStatic.aNZ;
            Context context = fVar.getContext();
            int i3 = z.my_mark;
            int i4 = v.icon_news_down_bar_one;
            int i5 = v.icon_menu_collect_n;
            i = EditMarkStatic.msgCount;
            EditMarkStatic.bwJ = new e(this, context, i3, i4, i5, i);
            i2 = EditMarkStatic.msgCount;
            if (i2 > 0) {
                eVar2 = EditMarkStatic.bwJ;
                eVar2.aL(true);
            }
            eVar = EditMarkStatic.bwJ;
            ((com.baidu.tbadk.mainTab.f) customResponsedMessage.getData()).a(eVar);
        }
    }
}

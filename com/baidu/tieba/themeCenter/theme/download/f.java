package com.baidu.tieba.themeCenter.theme.download;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.themeCenter.theme.download.d;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends CustomMessageListener {
    final /* synthetic */ d dOG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(d dVar, int i) {
        super(i);
        this.dOG = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        com.baidu.tieba.themeCenter.b bVar;
        ArrayList arrayList4;
        com.baidu.tieba.themeCenter.b bVar2;
        d.a aVar;
        d.a aVar2;
        boolean z;
        List<com.baidu.tieba.themeCenter.theme.top.a> list;
        List list2;
        ArrayList arrayList5;
        if (customResponsedMessage != null) {
            arrayList = this.dOG.dOD;
            if (arrayList == null) {
                this.dOG.dOD = new ArrayList();
            }
            arrayList2 = this.dOG.dOD;
            arrayList2.clear();
            arrayList3 = this.dOG.dOD;
            bVar = this.dOG.dOC;
            arrayList3.add(bVar);
            arrayList4 = this.dOG.dOD;
            bVar2 = this.dOG.dNT;
            arrayList4.add(bVar2);
            if (customResponsedMessage.getData() != null && (list2 = (List) customResponsedMessage.getData()) != null) {
                arrayList5 = this.dOG.dOD;
                arrayList5.addAll(list2);
            }
            this.dOG.aHN();
            aVar = this.dOG.dOE;
            if (aVar != null) {
                aVar2 = this.dOG.dOE;
                z = this.dOG.dOF;
                list = this.dOG.mThemeList;
                aVar2.a(z, list);
            }
        }
    }
}

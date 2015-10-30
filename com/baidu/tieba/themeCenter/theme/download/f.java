package com.baidu.tieba.themeCenter.theme.download;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.themeCenter.theme.download.d;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends CustomMessageListener {
    final /* synthetic */ d dhp;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(d dVar, int i) {
        super(i);
        this.dhp = dVar;
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
            arrayList = this.dhp.dhm;
            if (arrayList == null) {
                this.dhp.dhm = new ArrayList();
            }
            arrayList2 = this.dhp.dhm;
            arrayList2.clear();
            arrayList3 = this.dhp.dhm;
            bVar = this.dhp.dhl;
            arrayList3.add(bVar);
            arrayList4 = this.dhp.dhm;
            bVar2 = this.dhp.dgD;
            arrayList4.add(bVar2);
            if (customResponsedMessage.getData() != null && (list2 = (List) customResponsedMessage.getData()) != null) {
                arrayList5 = this.dhp.dhm;
                arrayList5.addAll(list2);
            }
            this.dhp.azy();
            aVar = this.dhp.dhn;
            if (aVar != null) {
                aVar2 = this.dhp.dhn;
                z = this.dhp.dho;
                list = this.dhp.mThemeList;
                aVar2.a(z, list);
            }
        }
    }
}

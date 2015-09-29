package com.baidu.tieba.themeCenter.theme.top;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.themeCenter.dressCenter.k;
import com.baidu.tieba.themeCenter.theme.top.d;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends CustomMessageListener {
    final /* synthetic */ d dgY;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(d dVar, int i) {
        super(i);
        this.dgY = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        List list;
        List list2;
        List list3;
        d.a aVar;
        d.a aVar2;
        k kVar;
        List<a> list4;
        if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
            this.dgY.dga = (List) customResponsedMessage.getData();
            list = this.dgY.mThemeList;
            if (list != null) {
                list2 = this.dgY.mThemeList;
                if (list2.size() > 0) {
                    list3 = this.dgY.dga;
                    if (list3 != null) {
                        aVar = this.dgY.dge;
                        if (aVar == null) {
                            return;
                        }
                        this.dgY.azs();
                        aVar2 = this.dgY.dge;
                        int error = customResponsedMessage.getError();
                        String errorString = customResponsedMessage.getErrorString();
                        kVar = this.dgY.mRecommand;
                        list4 = this.dgY.mThemeList;
                        aVar2.a(error, errorString, kVar, list4);
                    }
                }
            }
        }
    }
}

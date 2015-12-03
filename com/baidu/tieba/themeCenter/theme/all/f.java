package com.baidu.tieba.themeCenter.theme.all;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.themeCenter.dressCenter.k;
import com.baidu.tieba.themeCenter.theme.top.d;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends CustomMessageListener {
    final /* synthetic */ d dGx;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(d dVar, int i) {
        super(i);
        this.dGx = dVar;
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
        List<com.baidu.tieba.themeCenter.theme.top.a> list4;
        if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
            this.dGx.dGp = (List) customResponsedMessage.getData();
            list = this.dGx.dGp;
            if (list != null) {
                list2 = this.dGx.dGq;
                if (list2 != null) {
                    list3 = this.dGx.dGq;
                    if (list3.size() > 2) {
                        aVar = this.dGx.dGt;
                        if (aVar == null) {
                            return;
                        }
                        this.dGx.aFy();
                        aVar2 = this.dGx.dGt;
                        int error = customResponsedMessage.getError();
                        String errorString = customResponsedMessage.getErrorString();
                        kVar = this.dGx.mRecommand;
                        list4 = this.dGx.mThemeList;
                        aVar2.a(error, errorString, kVar, list4);
                    }
                }
            }
        }
    }
}

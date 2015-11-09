package com.baidu.tieba.themeCenter.theme.top;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.themeCenter.dressCenter.k;
import com.baidu.tieba.themeCenter.theme.top.d;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends CustomMessageListener {
    final /* synthetic */ d dje;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(d dVar, int i) {
        super(i);
        this.dje = dVar;
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
            this.dje.dig = (List) customResponsedMessage.getData();
            list = this.dje.mThemeList;
            if (list != null) {
                list2 = this.dje.mThemeList;
                if (list2.size() > 0) {
                    list3 = this.dje.dig;
                    if (list3 != null) {
                        aVar = this.dje.dik;
                        if (aVar == null) {
                            return;
                        }
                        this.dje.aAo();
                        aVar2 = this.dje.dik;
                        int error = customResponsedMessage.getError();
                        String errorString = customResponsedMessage.getErrorString();
                        kVar = this.dje.mRecommand;
                        list4 = this.dje.mThemeList;
                        aVar2.a(error, errorString, kVar, list4);
                    }
                }
            }
        }
    }
}

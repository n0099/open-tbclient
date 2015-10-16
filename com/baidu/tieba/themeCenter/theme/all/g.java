package com.baidu.tieba.themeCenter.theme.all;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.themeCenter.dressCenter.k;
import com.baidu.tieba.themeCenter.theme.top.d;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends CustomMessageListener {
    final /* synthetic */ d dgH;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(d dVar, int i) {
        super(i);
        this.dgH = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        d.a aVar;
        d.a aVar2;
        k kVar;
        List<com.baidu.tieba.themeCenter.theme.top.a> list;
        if (customResponsedMessage != null) {
            aVar = this.dgH.dgE;
            if (aVar == null) {
                return;
            }
            this.dgH.azC();
            aVar2 = this.dgH.dgE;
            int error = customResponsedMessage.getError();
            String errorString = customResponsedMessage.getErrorString();
            kVar = this.dgH.mRecommand;
            list = this.dgH.mThemeList;
            aVar2.a(error, errorString, kVar, list);
        }
    }
}

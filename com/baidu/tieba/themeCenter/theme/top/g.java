package com.baidu.tieba.themeCenter.theme.top;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.themeCenter.dressCenter.k;
import com.baidu.tieba.themeCenter.theme.top.d;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends CustomMessageListener {
    final /* synthetic */ d dhy;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(d dVar, int i) {
        super(i);
        this.dhy = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        d.a aVar;
        d.a aVar2;
        k kVar;
        List<a> list;
        if (customResponsedMessage != null) {
            aVar = this.dhy.dgE;
            if (aVar == null) {
                return;
            }
            this.dhy.azy();
            aVar2 = this.dhy.dgE;
            int error = customResponsedMessage.getError();
            String errorString = customResponsedMessage.getErrorString();
            kVar = this.dhy.mRecommand;
            list = this.dhy.mThemeList;
            aVar2.a(error, errorString, kVar, list);
        }
    }
}

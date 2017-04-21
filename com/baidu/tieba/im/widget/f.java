package com.baidu.tieba.im.widget;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class f implements com.baidu.tbadk.util.f<Integer> {
    final /* synthetic */ d diB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar) {
        this.diB = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.f
    /* renamed from: b */
    public void onReturnDataInUI(Integer num) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_ACCOUNT_CHANGE_FOR_IM, null));
    }
}

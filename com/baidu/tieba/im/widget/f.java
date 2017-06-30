package com.baidu.tieba.im.widget;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.util.h;
/* loaded from: classes.dex */
class f implements h<Integer> {
    final /* synthetic */ d dpV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar) {
        this.dpV = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.h
    /* renamed from: f */
    public void onReturnDataInUI(Integer num) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_ACCOUNT_CHANGE_FOR_IM, null));
    }
}

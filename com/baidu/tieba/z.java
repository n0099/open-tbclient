package com.baidu.tieba;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class z implements com.baidu.adp.framework.task.a<AccountData> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.a] */
    @Override // com.baidu.adp.framework.task.a
    public final CustomResponsedMessage<?> a(com.baidu.adp.framework.message.a<AccountData> aVar) {
        com.baidu.tbadk.coreExtra.messageCenter.a.a().a(true);
        com.baidu.tieba.util.k.n();
        return null;
    }
}

package com.baidu.tieba.tbluncher;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
final class j implements com.baidu.adp.framework.task.a<Void> {
    @Override // com.baidu.adp.framework.task.a
    public final CustomResponsedMessage<?> a(com.baidu.adp.framework.message.a<Void> aVar) {
        if (aVar != null) {
            MainTabActivity.c = true;
        }
        return null;
    }
}

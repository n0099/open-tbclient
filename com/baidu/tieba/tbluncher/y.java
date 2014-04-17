package com.baidu.tieba.tbluncher;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
final class y implements com.baidu.adp.framework.task.a<com.baidu.tbadk.core.b.aa> {
    @Override // com.baidu.adp.framework.task.a
    public final CustomResponsedMessage<?> a(com.baidu.adp.framework.message.a<com.baidu.tbadk.core.b.aa> aVar) {
        if (aVar != null && aVar.a() != null) {
            aVar.a().d().setClass(aVar.a().c(), MainTabActivity.class);
            aVar.a().f();
        }
        return null;
    }
}

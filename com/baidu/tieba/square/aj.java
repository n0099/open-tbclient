package com.baidu.tieba.square;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
final class aj implements com.baidu.adp.framework.task.a<com.baidu.tbadk.core.b.aq> {
    @Override // com.baidu.adp.framework.task.a
    public final CustomResponsedMessage<?> a(com.baidu.adp.framework.message.a<com.baidu.tbadk.core.b.aq> aVar) {
        if (aVar != null && aVar.a() != null) {
            aVar.a().d().setClass(aVar.a().c(), SingleSquareActivity.class);
            aVar.a().f();
        }
        return null;
    }
}

package com.baidu.tieba.tbluncher;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.b.aa;
/* loaded from: classes.dex */
final class q implements com.baidu.adp.framework.task.a<aa> {
    @Override // com.baidu.adp.framework.task.a
    public final CustomResponsedMessage<?> a(com.baidu.adp.framework.message.a<aa> aVar) {
        if (aVar != null && aVar.a() != null) {
            aVar.a().d().setClass(aVar.a().c(), MainTabActivity.class);
            aVar.a().f();
        }
        return null;
    }
}

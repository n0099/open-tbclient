package com.baidu.tieba.signall;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.b.an;
/* loaded from: classes.dex */
final class g implements com.baidu.adp.framework.task.a<an> {
    @Override // com.baidu.adp.framework.task.a
    public final CustomResponsedMessage<?> a(com.baidu.adp.framework.message.a<an> aVar) {
        if (aVar != null && aVar.a() != null) {
            aVar.a().d().setClass(aVar.a().c(), SignAllForumActivity.class);
            aVar.a().f();
        }
        return null;
    }
}

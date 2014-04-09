package com.baidu.tieba.person;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
final class ca implements com.baidu.adp.framework.task.a<com.baidu.tbadk.core.b.ag> {
    @Override // com.baidu.adp.framework.task.a
    public final CustomResponsedMessage<com.baidu.tbadk.core.b.ag> a(com.baidu.adp.framework.message.a<com.baidu.tbadk.core.b.ag> aVar) {
        if (aVar != null && aVar.a() != null) {
            PersonInfoActivityStatic.a(aVar.a().c(), aVar.a().d().getStringExtra("user_id"), aVar.a().d().getStringExtra("user_name"));
        }
        return null;
    }
}

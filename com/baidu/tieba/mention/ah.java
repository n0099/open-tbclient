package com.baidu.tieba.mention;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
final class ah implements com.baidu.adp.framework.task.a<com.baidu.tbadk.core.frameworkData.a> {
    @Override // com.baidu.adp.framework.task.a
    public final CustomResponsedMessage<?> a(com.baidu.adp.framework.message.a<com.baidu.tbadk.core.frameworkData.a> aVar) {
        if (aVar != null && aVar.a() != null) {
            aVar.a().d().setClass(aVar.a().c(), SingleMentionActivity.class);
            aVar.a().d().putExtra("showBack", true);
            aVar.a().d().putExtra("NotifiIdKey", 11);
            com.baidu.tbadk.core.b.ab.a = true;
            aVar.a().f();
        }
        return null;
    }
}

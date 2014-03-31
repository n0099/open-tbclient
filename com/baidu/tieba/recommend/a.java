package com.baidu.tieba.recommend;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
final class a implements com.baidu.adp.framework.task.a<com.baidu.tbadk.core.b.f> {
    @Override // com.baidu.adp.framework.task.a
    public final CustomResponsedMessage<?> a(com.baidu.adp.framework.message.a<com.baidu.tbadk.core.b.f> aVar) {
        if (aVar != null && aVar.a() != null) {
            aVar.a().d().setClass(aVar.a().c(), DailyClassicalActivity.class);
            aVar.a().f();
        }
        return null;
    }
}

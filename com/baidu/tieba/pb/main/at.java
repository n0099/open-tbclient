package com.baidu.tieba.pb.main;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
final class at implements com.baidu.adp.framework.task.a<com.baidu.tbadk.core.b.af> {
    @Override // com.baidu.adp.framework.task.a
    public final CustomResponsedMessage<?> a(com.baidu.adp.framework.message.a<com.baidu.tbadk.core.b.af> aVar) {
        if (aVar != null && aVar.a() != null) {
            aVar.a().d().setClass(aVar.a().c(), PbActivity.class);
            if ("1".equals(aVar.a().d().getStringExtra("is_start_for_result"))) {
                aVar.a().b(aVar.a().d().getIntExtra("request_code", 0));
            } else {
                aVar.a().f();
            }
        }
        return null;
    }
}

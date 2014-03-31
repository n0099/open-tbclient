package com.baidu.tieba.image;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.b.t;
/* loaded from: classes.dex */
final class d implements com.baidu.adp.framework.task.a<t> {
    @Override // com.baidu.adp.framework.task.a
    public final CustomResponsedMessage<?> a(com.baidu.adp.framework.message.a<t> aVar) {
        if (aVar != null && aVar.a() != null && "data_valid".equals(aVar.a().d().getStringExtra("is_data_valid"))) {
            aVar.a().d().setClass(aVar.a().c(), ImageViewerActivity.class);
            if ("start_activity_normal".equals(aVar.a().d().getStringExtra("start_activity_type"))) {
                aVar.a().f();
            } else {
                aVar.a().b(14001);
            }
        }
        return null;
    }
}

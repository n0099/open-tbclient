package com.baidu.tieba.pb.praise;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.b.ai;
/* loaded from: classes.dex */
final class d implements com.baidu.adp.framework.task.a<ai> {
    @Override // com.baidu.adp.framework.task.a
    public final CustomResponsedMessage<ai> a(com.baidu.adp.framework.message.a<ai> aVar) {
        if (aVar != null && aVar.a() != null) {
            PraiseListActivity.a(aVar.a().c(), aVar.a().d().getStringExtra("post_id"), aVar.a().d().getStringExtra("post_desc"));
        }
        return null;
    }
}

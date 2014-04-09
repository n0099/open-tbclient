package com.baidu.tieba.pb.image;

import android.text.TextUtils;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
final class l implements com.baidu.adp.framework.task.a<com.baidu.tbadk.core.b.s> {
    @Override // com.baidu.adp.framework.task.a
    public final CustomResponsedMessage<?> a(com.baidu.adp.framework.message.a<com.baidu.tbadk.core.b.s> aVar) {
        if (aVar != null && aVar.a() != null) {
            aVar.a().d().setClass(aVar.a().c(), ImagePbActivity.class);
            if (!TextUtils.isEmpty(aVar.a().d().getStringExtra("thread_id"))) {
                aVar.a().f();
            }
        }
        return null;
    }
}

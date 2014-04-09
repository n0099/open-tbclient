package com.baidu.tieba;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
final class w implements Runnable {
    final /* synthetic */ v a;
    private final /* synthetic */ com.baidu.adp.framework.message.a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar, com.baidu.adp.framework.message.a aVar) {
        this.a = vVar;
        this.b = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TbadkApplication.j();
        p.a((AccountData) this.b.a());
    }
}

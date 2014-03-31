package com.baidu.tieba;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
final class y implements Runnable {
    final /* synthetic */ x a;
    private final /* synthetic */ com.baidu.adp.framework.message.a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar, com.baidu.adp.framework.message.a aVar) {
        this.a = xVar;
        this.b = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TbadkApplication.j();
        r.a((AccountData) this.b.a());
    }
}

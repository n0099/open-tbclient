package com.baidu.tieba;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.account.SapiFastRegActivity;
/* loaded from: classes.dex */
final class u implements Runnable {
    final /* synthetic */ t a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar) {
        this.a = tVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SapiFastRegActivity.a(TbadkApplication.j());
    }
}

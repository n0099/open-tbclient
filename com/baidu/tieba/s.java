package com.baidu.tieba;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.account.SapiFastRegActivity;
/* loaded from: classes.dex */
final class s implements Runnable {
    final /* synthetic */ r a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar) {
        this.a = rVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SapiFastRegActivity.a(TbadkApplication.j());
    }
}

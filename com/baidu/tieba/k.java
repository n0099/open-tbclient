package com.baidu.tieba;

import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
final class k extends Thread {
    private k() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ k(byte b) {
        this();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        super.run();
        com.baidu.tbadk.core.util.ak akVar = new com.baidu.tbadk.core.util.ak(String.valueOf(com.baidu.tbadk.core.data.n.a) + "c/m/register");
        akVar.a().a().b = false;
        akVar.a("channel_id", TbadkApplication.j().S());
        akVar.a("channel_uid", TbadkApplication.j().R());
        akVar.i();
    }
}

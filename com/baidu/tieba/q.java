package com.baidu.tieba;

import android.os.Handler;
import android.os.Message;
import com.baidu.location.LocationClientOption;
import com.baidu.tbadk.TbadkApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class q implements Handler.Callback {
    final /* synthetic */ p a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.a = pVar;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        switch (message.what) {
            case 2:
                com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2006001, "start"));
                return false;
            case 3:
                com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2006001, "stop"));
                return false;
            case LocationClientOption.MIN_SCAN_SPAN /* 1000 */:
                com.baidu.tbplugin.k.a(TbadkApplication.j());
                com.baidu.tbadk.plugins.a aVar = new com.baidu.tbadk.plugins.a();
                p pVar = this.a;
                aVar.a(p.e(), TbadkApplication.j().m(), TbadkApplication.j().T(), new r(this));
                return false;
            default:
                return false;
        }
    }
}

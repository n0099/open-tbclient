package com.baidu.tieba;

import android.os.Handler;
import android.os.Message;
import com.baidu.location.LocationClientOption;
import com.baidu.tbadk.TbadkApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class s implements Handler.Callback {
    final /* synthetic */ r a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar) {
        this.a = rVar;
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
                TbadkApplication j = TbadkApplication.j();
                TbadkApplication.j().T();
                TbadkApplication.j().m();
                com.baidu.tbplugin.k.a(j);
                com.baidu.tbadk.plugins.a aVar = new com.baidu.tbadk.plugins.a();
                r rVar = this.a;
                aVar.a(r.e(), TbadkApplication.j().m(), TbadkApplication.j().T(), new t(this));
                return false;
            default:
                return false;
        }
    }
}

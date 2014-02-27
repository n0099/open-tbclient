package com.baidu.tieba.util;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bb extends Handler {
    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        super.handleMessage(message);
        try {
            NetWorkCore netWorkCore = (NetWorkCore) message.obj;
            if (netWorkCore != null) {
                netWorkCore.s();
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b(getClass().getName(), "initNetWorkCore", e.getMessage());
        }
    }
}

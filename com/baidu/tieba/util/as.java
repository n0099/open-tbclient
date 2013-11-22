package com.baidu.tieba.util;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class as extends Handler {
    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        try {
            NetWorkCore netWorkCore = (NetWorkCore) message.obj;
            if (netWorkCore != null) {
                netWorkCore.r();
            }
        } catch (Exception e) {
            bg.b(getClass().getName(), "initNetWorkCore", e.getMessage());
        }
    }
}

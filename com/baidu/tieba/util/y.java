package com.baidu.tieba.util;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends Handler {
    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        try {
            NetWorkCore netWorkCore = (NetWorkCore) message.obj;
            if (netWorkCore != null) {
                netWorkCore.q();
            }
        } catch (Exception e) {
            aq.b(getClass().getName(), "initNetWorkCore", e.getMessage());
        }
    }
}

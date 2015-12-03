package com.baidu.tieba.onlineDebugger.command;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class g implements d {
    private String msgContent;

    public g(String str) {
        int indexOf = str.indexOf(" ");
        if (indexOf != -1) {
            this.msgContent = str.substring(indexOf + 1);
        } else {
            this.msgContent = str;
        }
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("showmsg cmd msg content cannot be empty");
        }
    }

    @Override // com.baidu.tieba.onlineDebugger.command.d
    public Object aiA() {
        com.baidu.adp.lib.h.h.hj().post(new h(this));
        return true;
    }

    @Override // com.baidu.tieba.onlineDebugger.command.d
    public boolean aiB() {
        return true;
    }
}

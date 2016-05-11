package com.baidu.tieba.onlineDebugger.command;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class g implements d {
    private static Character dbA = 's';
    private static Character dbB = 'l';
    private Character dbC;
    private String msgContent;

    public g(String str) {
        int indexOf;
        this.dbC = dbA;
        int indexOf2 = str.indexOf(32);
        if (indexOf2 != -1) {
            this.msgContent = str.substring(indexOf2 + 1).trim();
            if (this.msgContent.startsWith("-") && (indexOf = this.msgContent.indexOf(32)) != -1) {
                try {
                    this.dbC = Character.valueOf(this.msgContent.charAt(1));
                    this.msgContent = this.msgContent.substring(indexOf + 1);
                } catch (Exception e) {
                }
            }
        } else {
            this.msgContent = str;
        }
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("showmsg cmd msg content cannot be empty");
        }
    }

    @Override // com.baidu.tieba.onlineDebugger.command.d
    public Object aux() {
        com.baidu.adp.lib.h.h.dL().post(new h(this));
        return true;
    }

    @Override // com.baidu.tieba.onlineDebugger.command.d
    public boolean auy() {
        return true;
    }
}

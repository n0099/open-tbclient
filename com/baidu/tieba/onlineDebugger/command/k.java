package com.baidu.tieba.onlineDebugger.command;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class k implements h {
    private static Character dIh = 's';
    private static Character dIi = 'l';
    private Character dIj;
    private String msgContent;

    public k(String str) {
        int indexOf;
        this.dIj = dIh;
        int indexOf2 = str.indexOf(32);
        if (indexOf2 != -1) {
            this.msgContent = str.substring(indexOf2 + 1).trim();
            if (this.msgContent.startsWith("-") && (indexOf = this.msgContent.indexOf(32)) != -1) {
                try {
                    this.dIj = Character.valueOf(this.msgContent.charAt(1));
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

    @Override // com.baidu.tieba.onlineDebugger.command.h
    public Object aCF() {
        com.baidu.adp.lib.h.h.dM().post(new l(this));
        return true;
    }

    @Override // com.baidu.tieba.onlineDebugger.command.h
    public boolean aCG() {
        return true;
    }
}

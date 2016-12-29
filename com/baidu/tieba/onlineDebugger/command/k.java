package com.baidu.tieba.onlineDebugger.command;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class k implements h {
    private static Character dSV = 's';
    private static Character dSW = 'l';
    private Character dSX;
    private String msgContent;

    public k(String str) {
        int indexOf;
        this.dSX = dSV;
        int indexOf2 = str.indexOf(32);
        if (indexOf2 != -1) {
            this.msgContent = str.substring(indexOf2 + 1).trim();
            if (this.msgContent.startsWith("-") && (indexOf = this.msgContent.indexOf(32)) != -1) {
                try {
                    this.dSX = Character.valueOf(this.msgContent.charAt(1));
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
    public Object aHc() {
        com.baidu.adp.lib.h.h.eG().post(new l(this));
        return true;
    }

    @Override // com.baidu.tieba.onlineDebugger.command.h
    public boolean aHd() {
        return true;
    }
}

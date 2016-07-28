package com.baidu.tieba.onlineDebugger.command;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class k implements h {
    private static Character dUq = 's';
    private static Character dUr = 'l';
    private Character dUs;
    private String msgContent;

    public k(String str) {
        int indexOf;
        this.dUs = dUq;
        int indexOf2 = str.indexOf(32);
        if (indexOf2 != -1) {
            this.msgContent = str.substring(indexOf2 + 1).trim();
            if (this.msgContent.startsWith("-") && (indexOf = this.msgContent.indexOf(32)) != -1) {
                try {
                    this.dUs = Character.valueOf(this.msgContent.charAt(1));
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
    public Object aFP() {
        com.baidu.adp.lib.h.h.dL().post(new l(this));
        return true;
    }

    @Override // com.baidu.tieba.onlineDebugger.command.h
    public boolean aFQ() {
        return true;
    }
}

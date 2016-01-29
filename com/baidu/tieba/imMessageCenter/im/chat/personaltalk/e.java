package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private HashMap<String, a> ciq = new HashMap<>();

    public void a(String str, a aVar) {
        this.ciq.put(str, aVar);
    }

    public boolean jg(String str) {
        a aVar;
        return (this.ciq == null || (aVar = this.ciq.get(str)) == null || Math.abs(System.currentTimeMillis() - aVar.afI()) >= 300000) ? false : true;
    }

    public com.baidu.tbadk.coreExtra.relationship.b jh(String str) {
        if (this.ciq.get(str) != null) {
            return this.ciq.get(str).afH();
        }
        return null;
    }
}

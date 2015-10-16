package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private HashMap<String, a> bKq = new HashMap<>();

    public void a(String str, a aVar) {
        this.bKq.put(str, aVar);
    }

    public boolean iu(String str) {
        a aVar;
        return (this.bKq == null || (aVar = this.bKq.get(str)) == null || Math.abs(System.currentTimeMillis() - aVar.HI()) >= 300000) ? false : true;
    }

    public com.baidu.tbadk.coreExtra.relationship.b iv(String str) {
        if (this.bKq.get(str) != null) {
            return this.bKq.get(str).XT();
        }
        return null;
    }
}

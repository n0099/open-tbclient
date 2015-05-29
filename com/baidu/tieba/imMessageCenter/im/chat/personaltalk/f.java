package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import java.util.HashMap;
/* loaded from: classes.dex */
public class f {
    private HashMap<String, a> bsB = new HashMap<>();

    public void a(String str, a aVar) {
        this.bsB.put(str, aVar);
    }

    public boolean hE(String str) {
        a aVar;
        return (this.bsB == null || (aVar = this.bsB.get(str)) == null || Math.abs(System.currentTimeMillis() - aVar.Hk()) >= 300000) ? false : true;
    }

    public com.baidu.tbadk.coreExtra.relationship.b hF(String str) {
        if (this.bsB.get(str) != null) {
            return this.bsB.get(str).VB();
        }
        return null;
    }
}

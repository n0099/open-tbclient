package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import java.util.HashMap;
/* loaded from: classes.dex */
public class f {
    private HashMap<String, a> bsC = new HashMap<>();

    public void a(String str, a aVar) {
        this.bsC.put(str, aVar);
    }

    public boolean hE(String str) {
        a aVar;
        return (this.bsC == null || (aVar = this.bsC.get(str)) == null || Math.abs(System.currentTimeMillis() - aVar.Hl()) >= 300000) ? false : true;
    }

    public com.baidu.tbadk.coreExtra.relationship.b hF(String str) {
        if (this.bsC.get(str) != null) {
            return this.bsC.get(str).VC();
        }
        return null;
    }
}

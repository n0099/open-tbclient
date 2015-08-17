package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private HashMap<String, a> bGt = new HashMap<>();

    public void a(String str, a aVar) {
        this.bGt.put(str, aVar);
    }

    public boolean ih(String str) {
        a aVar;
        return (this.bGt == null || (aVar = this.bGt.get(str)) == null || Math.abs(System.currentTimeMillis() - aVar.Ia()) >= 300000) ? false : true;
    }

    public com.baidu.tbadk.coreExtra.relationship.b ii(String str) {
        if (this.bGt.get(str) != null) {
            return this.bGt.get(str).Xj();
        }
        return null;
    }
}

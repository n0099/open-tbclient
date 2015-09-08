package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private HashMap<String, a> bHa = new HashMap<>();

    public void a(String str, a aVar) {
        this.bHa.put(str, aVar);
    }

    public boolean iq(String str) {
        a aVar;
        return (this.bHa == null || (aVar = this.bHa.get(str)) == null || Math.abs(System.currentTimeMillis() - aVar.HO()) >= 300000) ? false : true;
    }

    public com.baidu.tbadk.coreExtra.relationship.b ir(String str) {
        if (this.bHa.get(str) != null) {
            return this.bHa.get(str).Xl();
        }
        return null;
    }
}

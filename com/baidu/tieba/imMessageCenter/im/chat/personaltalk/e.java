package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private HashMap<String, a> csV = new HashMap<>();

    public void a(String str, a aVar) {
        this.csV.put(str, aVar);
    }

    public boolean jP(String str) {
        a aVar;
        return (this.csV == null || (aVar = this.csV.get(str)) == null || Math.abs(System.currentTimeMillis() - aVar.ajc()) >= 300000) ? false : true;
    }

    public com.baidu.tbadk.coreExtra.relationship.b jQ(String str) {
        if (this.csV.get(str) != null) {
            return this.csV.get(str).ajb();
        }
        return null;
    }
}

package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private HashMap<String, a> duT = new HashMap<>();

    public void a(String str, a aVar) {
        this.duT.put(str, aVar);
    }

    public boolean mB(String str) {
        a aVar;
        return (this.duT == null || (aVar = this.duT.get(str)) == null || Math.abs(System.currentTimeMillis() - aVar.getTimeStamp()) >= 300000) ? false : true;
    }

    public com.baidu.tbadk.coreExtra.relationship.b mC(String str) {
        if (this.duT.get(str) != null) {
            return this.duT.get(str).azu();
        }
        return null;
    }
}

package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private HashMap<String, a> bZP = new HashMap<>();

    public void a(String str, a aVar) {
        this.bZP.put(str, aVar);
    }

    public boolean iQ(String str) {
        a aVar;
        return (this.bZP == null || (aVar = this.bZP.get(str)) == null || Math.abs(System.currentTimeMillis() - aVar.IU()) >= 300000) ? false : true;
    }

    public com.baidu.tbadk.coreExtra.relationship.b iR(String str) {
        if (this.bZP.get(str) != null) {
            return this.bZP.get(str).abq();
        }
        return null;
    }
}

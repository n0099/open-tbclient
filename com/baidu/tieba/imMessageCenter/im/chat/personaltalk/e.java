package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private HashMap<String, a> bKf = new HashMap<>();

    public void a(String str, a aVar) {
        this.bKf.put(str, aVar);
    }

    public boolean iu(String str) {
        a aVar;
        return (this.bKf == null || (aVar = this.bKf.get(str)) == null || Math.abs(System.currentTimeMillis() - aVar.HI()) >= 300000) ? false : true;
    }

    public com.baidu.tbadk.coreExtra.relationship.b iv(String str) {
        if (this.bKf.get(str) != null) {
            return this.bKf.get(str).XT();
        }
        return null;
    }
}

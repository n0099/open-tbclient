package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private HashMap<String, a> cZi = new HashMap<>();

    public void a(String str, a aVar) {
        this.cZi.put(str, aVar);
    }

    public boolean ll(String str) {
        a aVar;
        return (this.cZi == null || (aVar = this.cZi.get(str)) == null || Math.abs(System.currentTimeMillis() - aVar.getTimeStamp()) >= 300000) ? false : true;
    }

    public com.baidu.tbadk.coreExtra.relationship.b lm(String str) {
        if (this.cZi.get(str) != null) {
            return this.cZi.get(str).ary();
        }
        return null;
    }
}

package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private HashMap<String, a> ctT = new HashMap<>();

    public void a(String str, a aVar) {
        this.ctT.put(str, aVar);
    }

    public boolean jS(String str) {
        a aVar;
        return (this.ctT == null || (aVar = this.ctT.get(str)) == null || Math.abs(System.currentTimeMillis() - aVar.getTimeStamp()) >= 300000) ? false : true;
    }

    public com.baidu.tbadk.coreExtra.relationship.b jT(String str) {
        if (this.ctT.get(str) != null) {
            return this.ctT.get(str).aji();
        }
        return null;
    }
}

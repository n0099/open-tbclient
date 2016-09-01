package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private HashMap<String, a> dnN = new HashMap<>();

    public void a(String str, a aVar) {
        this.dnN.put(str, aVar);
    }

    public boolean mb(String str) {
        a aVar;
        return (this.dnN == null || (aVar = this.dnN.get(str)) == null || Math.abs(System.currentTimeMillis() - aVar.getTimeStamp()) >= 300000) ? false : true;
    }

    public com.baidu.tbadk.coreExtra.relationship.b mc(String str) {
        if (this.dnN.get(str) != null) {
            return this.dnN.get(str).awY();
        }
        return null;
    }
}

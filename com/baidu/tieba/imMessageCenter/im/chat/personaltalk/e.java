package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private HashMap<String, a> dcf = new HashMap<>();

    public void a(String str, a aVar) {
        this.dcf.put(str, aVar);
    }

    public boolean ls(String str) {
        a aVar;
        return (this.dcf == null || (aVar = this.dcf.get(str)) == null || Math.abs(System.currentTimeMillis() - aVar.getTimeStamp()) >= 300000) ? false : true;
    }

    public com.baidu.tbadk.coreExtra.relationship.b lt(String str) {
        if (this.dcf.get(str) != null) {
            return this.dcf.get(str).ask();
        }
        return null;
    }
}

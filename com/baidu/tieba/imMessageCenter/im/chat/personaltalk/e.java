package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private HashMap<String, a> dpm = new HashMap<>();

    public void a(String str, a aVar) {
        this.dpm.put(str, aVar);
    }

    public boolean mo(String str) {
        a aVar;
        return (this.dpm == null || (aVar = this.dpm.get(str)) == null || Math.abs(System.currentTimeMillis() - aVar.getTimeStamp()) >= 300000) ? false : true;
    }

    public com.baidu.tbadk.coreExtra.relationship.b mp(String str) {
        if (this.dpm.get(str) != null) {
            return this.dpm.get(str).axx();
        }
        return null;
    }
}
